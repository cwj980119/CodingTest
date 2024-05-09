-- 코드를 작성해주세요
select count(id) as FISH_COUNT, fni.fish_name
from fish_info fi join fish_name_info fni on fi.fish_type = fni.fish_type
group by fni.fish_name
order by count(*) desc