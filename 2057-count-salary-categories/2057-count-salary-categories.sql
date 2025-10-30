SELECT
    'High Salary' AS category,
    COUNT(
        CASE
            WHEN income > 50000
            THEN 1
        END
    ) AS accounts_count
FROM
    accounts

UNION ALL

SELECT
    'Low Salary' AS category,
    COUNT(
        CASE
            WHEN income < 20000
            THEN 1
        END
    ) AS accounts_count
FROM
    accounts

UNION ALL

SELECT
    'Average Salary' AS category,
    COUNT(
        CASE
            WHEN income >= 20000 AND income <= 50000 
            THEN 1
        END
    ) AS accounts_count
FROM
    accounts

