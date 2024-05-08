-- 코드를 작성해주세요
select ID, (select count(*)
           from ECOLI_DATA ed2
           where ed2.parent_id = ed1.id) CHILD_COUNT
from ECOLI_DATA ed1
order by id asc;