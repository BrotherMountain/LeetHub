# 문제 접근: actor_id 하나당 동일한 director_id가 3번 반복된 테이블만 출력되어야 함
# Group By actor_id
# count(director_id) >= 3
SELECT
    actor_id,
    director_id
FROM
    ActorDirector
GROUP BY
    actor_id, director_id
HAVING
    count(director_id) >= 3


