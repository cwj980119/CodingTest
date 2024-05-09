-- 코드를 작성해주세요
select ii.ITEM_ID, ITEM_NAME, RARITY
from ITEM_INFO ii
join ITEM_TREE it
on ii.item_id = it.item_id
where it.PARENT_ITEM_ID in (select item_id from item_info where rarity like 'rare')
order by item_id desc