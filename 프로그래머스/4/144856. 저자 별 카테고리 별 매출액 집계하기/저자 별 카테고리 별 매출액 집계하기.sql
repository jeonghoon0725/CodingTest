-- 코드를 입력하세요
SELECT
    B.AUTHOR_ID
    , A.AUTHOR_NAME
    , B.CATEGORY
    , SUM(B.PRICE * S.SALES) AS TOTAL_SALES
FROM BOOK_SALES S
INNER JOIN BOOK B
ON B.BOOK_ID = S.BOOK_ID
INNER JOIN AUTHOR A
ON A.AUTHOR_ID = B.AUTHOR_ID
WHERE S.SALES_DATE >= '2022-01-01'
AND S.SALES_DATE < '2022-02-01'
GROUP BY B.AUTHOR_ID
        , A.AUTHOR_NAME
        , B.CATEGORY
ORDER BY AUTHOR_ID, CATEGORY DESC