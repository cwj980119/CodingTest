-- 코드를 입력하세요
SELECT APNT_NO, PT_NAME, P.PT_NO, D.MCDP_CD, DR_NAME, APNT_YMD
FROM APPOINTMENT A
JOIN PATIENT P
ON P.PT_NO = A.PT_NO
JOIN DOCTOR D
ON D.DR_ID = A.MDDR_ID
WHERE YEAR(APNT_YMD) = 2022 AND MONTH(APNT_YMD) = 4 AND DAY(APNT_YMD) = 13 AND APNT_CNCL_YMD IS NULL AND D.MCDP_CD LIKE 'CS'
ORDER BY APNT_YMD