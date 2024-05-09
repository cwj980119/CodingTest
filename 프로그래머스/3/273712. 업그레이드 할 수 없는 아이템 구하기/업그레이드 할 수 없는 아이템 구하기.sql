-- 코드를 작성해주세요
select ITEM_ID, ITEM_NAME, RARITY
from item_info ii1
where (select count(*) 
       from item_tree ii2
       where ii2.parent_item_id = ii1.item_id
      ) = 0
order by item_id desc