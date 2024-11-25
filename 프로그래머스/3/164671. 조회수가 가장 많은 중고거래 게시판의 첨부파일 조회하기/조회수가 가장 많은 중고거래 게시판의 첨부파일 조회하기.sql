-- 코드를 입력하세요

SELECT
    ('/home/grep/src/' || B.BOARD_ID 
     || '/' || F.FILE_ID || F.FILE_NAME || F.FILE_EXT) AS FILE_PATH
FROM (
    SELECT
        BOARD_ID
    FROM (
        SELECT
            BOARD_ID
            , WRITER_ID
            , TITLE
            , CONTENTS
            , PRICE
            , CREATED_DATE
            , STATUS
            , VIEWS
        FROM USED_GOODS_BOARD
        ORDER BY VIEWS DESC
    ) B
    WHERE ROWNUM = 1
) B
INNER JOIN USED_GOODS_FILE F
ON B.BOARD_ID = F.BOARD_ID

ORDER BY F.FILE_ID DESC