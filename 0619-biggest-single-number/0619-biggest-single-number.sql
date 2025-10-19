# 단일 숫자 = 단 한 번만 숫자가 나옴 => COUNT(num) = 1
# 가장 큰 MAX
SELECT
    MAX(num) AS num
FROM (
    SELECT 
        num
    FROM 
        MyNumbers
    GROUP BY
        num
    HAVING COUNT(num) = 1
) AS maxnumber;