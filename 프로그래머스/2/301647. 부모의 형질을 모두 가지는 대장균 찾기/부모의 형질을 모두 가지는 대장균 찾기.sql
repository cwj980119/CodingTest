-- 코드를 작성해주세요
select ed1.ID as ID, ed1.GENOTYPE as GENOTYPE, ed2.GENOTYPE as PARENT_GENOTYPE
from ECOLI_DATA as ed1
join ECOLI_DATA as ed2
where ed1.id is not null and ed1.parent_id = ed2.id and ed1.GENOTYPE & ed2.GENOTYPE = ed2.GENOTYPE
order by ed1.id asc;