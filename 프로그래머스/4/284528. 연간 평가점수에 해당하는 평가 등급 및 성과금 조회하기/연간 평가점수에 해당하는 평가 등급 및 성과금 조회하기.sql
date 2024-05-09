-- 코드를 작성해주세요
select he.emp_no, he.emp_name, (
    case
        when avg(score) >= 96 then 'S'
        when avg(score) >= 90 then 'A'
        when avg(score) >= 80 then 'B'
        else 'C'
    end
) as GRADE,
(
    case
        when avg(score) >= 96 then sal*0.2
        when avg(score) >= 90 then sal*0.15
        when avg(score) >= 80 then sal*0.1
        else sal*0
    end
) as BONUS
from hr_employees he
join hr_grade hg
on he.emp_no = hg.emp_no
group by he.emp_no
order by he.emp_no