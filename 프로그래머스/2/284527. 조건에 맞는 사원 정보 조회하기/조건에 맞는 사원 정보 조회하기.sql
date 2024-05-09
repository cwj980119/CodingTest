-- 코드를 작성해주세요
select sum(score) as score, he.emp_no as emp_no, emp_name, position, email
from hr_employees he
join hr_grade hg
on he.emp_no = hg.emp_no
group by hg.emp_no
order by sum(score) desc
limit 1