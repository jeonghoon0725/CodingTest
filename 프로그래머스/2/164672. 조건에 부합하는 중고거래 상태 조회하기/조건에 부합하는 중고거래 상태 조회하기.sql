-- 코드를 입력하세요
SELECT
    BOARD_ID
    , WRITER_ID
    , TITLE
    --, CONTENTS
    , PRICE
    --, CREATED_DATE
    --, STATUS
    , CASE STATUS
        WHEN 'DONE' THEN '거래완료'
        WHEN 'SALE' THEN '판매중'
        WHEN 'RESERVED' THEN '예약중'
    END AS STATUS
    --, VIEWS
FROM USED_GOODS_BOARD 
WHERE CREATED_DATE = TO_DATE('2022-10-05', 'YYYY-MM-DD')

ORDER BY BOARD_ID DESC
