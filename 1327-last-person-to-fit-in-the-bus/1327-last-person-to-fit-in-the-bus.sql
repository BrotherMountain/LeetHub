WITH UserWeightTable AS (
    SELECT
        person_name,
        weight,
        SUM(weight) OVER (ORDER BY turn) AS TotalWeight
    FROM
        Queue
)

SELECT
    person_name
FROM
    UserWeightTable
WHERE
    TotalWeight <= 1000
ORDER BY TotalWeight DESC
LIMIT 1