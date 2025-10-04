# 문제 해석: 무료 체험판에서 유료 구독으로 전환한 사용자 찾기, 무료 체험 기간 동안 각 사용자의 평균 일일 활동 기간 계산, 소수점 2자리 이하 자릿수까지 반올림, 유료 기간 동안 각 사용자의 평균 일일 활동 기간을 계산, 소수점 2자리 이하 자릿수까지 반올림
# 문제 조건: user_id를 오름차순으로 정렬
# 문제 접근: 1. 오름차순 정렬이므로 Order By user_id ASC
# 2. user당 무료 체험판과 유료 체험판을 구분짓기 위해서 Group By user_id를 사용해야함
# 3. 평균 일일 활동기간을 구해야하므로 ROUND(AVG()),2)
SELECT
    user_id,
    ROUND(AVG(CASE WHEN activity_type = 'free_trial' THEN activity_duration END), 2) AS trial_avg_duration,
    ROUND(AVG(CASE WHEN activity_type = 'paid' THEN activity_duration END), 2) AS paid_avg_duration
FROM
    UserActivity
GROUP BY 
    user_id
HAVING
    COUNT(CASE WHEN activity_type = 'paid' THEN 1 END) > 0
ORDER BY user_id ASC
        