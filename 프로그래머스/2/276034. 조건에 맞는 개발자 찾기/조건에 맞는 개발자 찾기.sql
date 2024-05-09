-- 코드를 작성해주세요
select ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS
WHERE SKILL_CODE&(select sum(code) from skillcodes where name like 'C#' or name like 'Python')
order by id