-- 코드를 작성해주세요
select HD.DEPT_ID AS DEPT_ID, HD.DEPT_NAME_EN AS DEPT_NAME_EN, ROUND(AVG(HE.SAL),0) AS AVG_SAL
from HR_DEPARTMENT as hd
join HR_EMPLOYEES as he
on hd.DEPT_ID = HE.DEPT_ID
GROUP BY HD.DEPT_ID
ORDER BY AVG(HE.SAL) DESC