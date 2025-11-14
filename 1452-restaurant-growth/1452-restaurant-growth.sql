SELECT
    distinct visited_on,
    sum(amount) OVER w AS amount,
    round((sum(amount) over w)/7, 2) as average_amount
FROM
    customer
    WINDOW w AS(
        ORDER BY visited_on
        RANGE BETWEEN INTERVAL 6 DAY PRECEDING and current row
    )
    Limit 6, 999 