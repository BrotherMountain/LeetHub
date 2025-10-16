# 문제 접근: 아무것도 주문하지 않는 모든 고객 찾기
# 두 테이블을 INNER JOIN 한 다음, NOT IN 연산으로 없는 아이디만 추출하면 될 듯
SELECT
    name AS Customers
FROM
    Customers
WHERE id NOT IN (
    SELECT 
        c.id 
    FROM
        Customers c
    JOIN
        Orders o
    ON c.id = o.customerId)
