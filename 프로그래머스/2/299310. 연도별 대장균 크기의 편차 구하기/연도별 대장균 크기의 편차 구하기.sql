-- 코드를 작성해주세요
SELECT YEAR(ed1.differentiation_date) as YEAR, (d1.mx - ed1.size_of_colony) as YEAR_DEV, ed1.id as ID
from ecoli_data as ed1
join (select max(size_of_colony) as mx, Year(differentiation_date) as year
      from ecoli_data
      group by year
     ) as d1
on year(ed1.differentiation_date) = d1.year
order by year asc, year_dev asc;
