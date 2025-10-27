WITH RED_COMPANY_ID AS(
    SELECT
        o.sales_id
    FROM
        Orders o
    WHERE
        o.com_id IN(
            SELECT
                c.com_id
            FROM
                Company c
            WHERE
                c.name ='RED'
        )
)

SELECT
    s.name
FROM
    SalesPerson s
WHERE
    s.sales_id NOT IN (SELECT
            *
        FROM
            RED_COMPANY_ID
    )





