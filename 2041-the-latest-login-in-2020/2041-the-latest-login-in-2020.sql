# 문제 해석: 2020년도에 로그인한 유저 id와 타임스탬프 출력
# 접근: Year()함수를 사용해서 연도를 추출한 다음, 2020년도라면 해당 행과 열을 출력하는식으로 접근해야할듯
# GROUP BY로 user_id 묶기


SELECT
    user_id,
    MAX(time_stamp) AS last_stamp
FROM 
    Logins
WHERE
    YEAR(time_stamp) = 2020
GROUP BY 
    user_Id
