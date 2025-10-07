# 문제해석: x,y,z 좌표를 토대로 삼각형 만들 수 있는 지 확인하기
# 문제 접근: y는 x와 z보다 커야함

SELECT
    x,y,z,
    CASE
        WHEN x + y > z AND x + z > y AND y + z > x
        THEN 'Yes'
        ELSE 'No'
    END AS triangle
FROM
    Triangle