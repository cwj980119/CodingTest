-- 코드를 작성해주세요
SELECT count(*) as FISH_COUNT, month(time) as MONTH
FROM fish_info
group by month(time)
order by month(time)