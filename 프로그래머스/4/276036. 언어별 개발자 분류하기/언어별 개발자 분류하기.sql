-- 코드를 작성해주세요
select (case
            when (Skill_code&(select sum(code) 
                             from skillcodes 
                             group by category 
                             having category like 'Front End') 
                and Skill_code&(select code 
                                from skillcodes
                                where name like 'Python') )
            then 'A'
            when (skill_code&(select code from skillcodes where name like 'C#'))
            then 'B'
            when (Skill_code&(select sum(code) 
                             from skillcodes 
                             group by category 
                             having category like 'Front End'))
            then 'C'
        end
       ) as GRADE,
       ID,
       EMAIL
from developers
where (case
            when (Skill_code&(select sum(code) 
                             from skillcodes 
                             group by category 
                             having category like 'Front End') 
                and Skill_code&(select code 
                                from skillcodes
                                where name like 'Python') )
            then 'A'
            when (skill_code&(select code from skillcodes where name like 'C#'))
            then 'B'
            when (Skill_code&(select sum(code) 
                             from skillcodes 
                             group by category 
                             having category like 'Front End'))
            then 'C'
        end
       ) is not null
order by grade, id
        