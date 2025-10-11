# 문제 해석: 모든 중복 이메일 보고
# 문제 접근 : COUNT > 1 사용하면 될듯
SELECT
    email AS Email
FROM
    Person
GROUP BY
    email
HAVING
    COUNT(email) > 1
