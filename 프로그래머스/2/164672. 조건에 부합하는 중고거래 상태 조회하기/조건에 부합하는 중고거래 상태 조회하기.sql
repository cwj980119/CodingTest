-- 코드를 입력하세요
SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, (CASE
                                            WHEN STATUS LIKE 'SALE' THEN '판매중'
                                            WHEN STATUS LIKE 'RESERVED' THEN '예약중'
                                            WHEN STATUS LIKE 'DONE' THEN '거래완료'
                                           END
                                          )
FROM USED_GOODS_BOARD
WHERE CREATED_DATE = '2022-10-5'
ORDER BY BOARD_ID DESC