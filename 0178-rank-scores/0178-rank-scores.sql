# Write your MySQL query statement below
select s.score , count(distinct s1.score) as 'rank'
from scores s
join scores s1
on s.score<=s1.score
group by s.id,s.score
order by s.score desc