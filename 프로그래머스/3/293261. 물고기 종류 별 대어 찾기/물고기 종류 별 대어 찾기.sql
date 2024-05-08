select fi.id, fni.fish_name, fi.length
from fish_info fi, fish_name_info fni
where (fi.fish_type, length) in (select fish_type, max(length)
                              from fish_info
                              group by fish_type
) and fi.fish_type = fni.fish_type
order by fi.id asc