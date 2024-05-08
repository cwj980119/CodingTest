-- 코드를 작성해주세요
select concat(quarter(differentiation_date), "Q") as quarter, count(*) as ECOLI_COUNT
from ECOLI_DATA
group by quarter
order by quarter;