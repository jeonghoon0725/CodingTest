-- 코드를 입력하세요
SELECT
    B.TITLE
    ,B.BOARD_ID
    ,R.REPLY_ID
    ,R.WRITER_ID
    ,R.CONTENTS
    ,TO_CHAR(R.CREATED_DATE, 'YYYY-MM-DD') AS CREATED_DATE
FROM USED_GOODS_BOARD B
INNER JOIN USED_GOODS_REPLY R
ON B.BOARD_ID = R.BOARD_ID
WHERE B.CREATED_DATE >= TO_DATE('20221001', 'YYYYMMDD')
AND B.CREATED_DATE <= TO_DATE('20221031', 'YYYYMMDD')
ORDER BY CREATED_DATE, TITLE