# 문제 해석: 각 플레이어의 첫번째 로그인 날짜를 반환해라
# 문제 접근: 일단 각 player_id로 그룹화 한 다음 event_date가 가장 작은 MIN값만 반환하도록 하면 될 듯

SELECT
    player_id,
    MIN(event_date) as first_login
FROM
    Activity
GROUP BY
    player_id