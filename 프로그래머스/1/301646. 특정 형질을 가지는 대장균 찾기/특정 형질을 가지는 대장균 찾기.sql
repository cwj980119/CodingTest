-- 코드를 작성해주세요
select count(*) as COUNT
from ecoli_data as ed
where ed.genotype&2 = 0 and (ed.genotype&1 or ed.genotype&4);