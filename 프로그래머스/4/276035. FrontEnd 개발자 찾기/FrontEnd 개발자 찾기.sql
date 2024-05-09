-- 코드를 작성해주세요
select ID, EMAIL, FIRST_NAME, LAST_NAME
from developers
where skill_code&(select sum(code) from skillcodes where category like 'Front End')
order by ID