# 활성 구독 존재, 최소 한 번 다운그레이드 수행, 현재 계획 수익이 과거 최대 계획 수익의 50% 보다 적음
# 최소 60일 이상 구독자인 테이블을 day_as_subscriiber를 desc로 user_id를 asc로 해서 반환하기
# 문제 접근: user_id로 그룹화하기
# monthly_amount의 Max값 중에서 현재 monthly_amount의 값이 50%보다 작아야 함
# plan_name이 NULL이 아니면 됨
# DATEDIFF(day1, day2)를 통해 가장 마지막의 날짜(MAX(event_date))가 60일 이상
WITH UserEventStats AS(
    SELECT
        user_id,
        event_type,
        monthly_amount,
        plan_name,
        ROW_NUMBER() OVER(PARTITION BY user_id ORDER BY event_date DESC) as rn,
        DATEDIFF(
            MAX(event_date) OVER(PARTITION BY user_id),
            MIN(event_date) OVER(PARTITION BY user_id)
        ) AS days_as_subscriber,
        MAX(monthly_amount) OVER(PARTITION BY user_id) as max_monthly_amount
    FROM
        subscription_events
)

SELECT DISTINCT
    user_id, plan_name AS current_plan, monthly_amount AS current_monthly_amount, max_monthly_amount AS max_historical_amount, days_as_subscriber
FROM
    UserEventStats
WHERE
    user_id IN (SELECT user_id FROM subscription_events WHERE event_type = 'downgrade')
    AND 
    rn = 1 
    AND
    event_type != 'cancel'
    AND
    days_as_subscriber >= 60
    AND 
    monthly_amount < (max_monthly_amount * 0.5)
ORDER BY
    days_as_subscriber DESC,
    user_id ASC;