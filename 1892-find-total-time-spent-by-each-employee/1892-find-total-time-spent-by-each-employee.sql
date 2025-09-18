SELECT e.event_day AS day,
    e.emp_id,
    sum(out_time) - sum(in_time) as total_time
FROM
    Employees e
GROUP BY e.emp_id, e.event_day