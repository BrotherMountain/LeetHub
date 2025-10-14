# 문제 접근: Products 와 Orders의 product_id를 하나의 테이블로 만들어야함 그런 다음 두 테이블의 product_id를 바탕으로 unit을 합쳐야함

WITH MonthlyOrders AS (
    SELECT
        p.product_name,
        o.unit,
        SUM(o.unit) OVER (PARTITION BY p.product_id) AS total_unit_in_feb
    FROM
        Products p
    JOIN
        Orders o ON p.product_id = o.product_id
    WHERE
        DATE_FORMAT(o.order_date, '%Y-%m') = '2020-02'
)

SELECT DISTINCT
    product_name,
    total_unit_in_feb AS unit
FROM
    MonthlyOrders
WHERE
    total_unit_in_feb >= 100;
