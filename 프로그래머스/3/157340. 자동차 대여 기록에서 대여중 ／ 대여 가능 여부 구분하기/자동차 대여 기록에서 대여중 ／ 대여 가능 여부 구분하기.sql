-- 코드를 입력하세요
SELECT
    CAR_ID
    ,CASE
        WHEN MAX(
                CASE
                    WHEN TO_DATE('20221016', 'YYYYMMDD') BETWEEN START_DATE AND END_DATE THEN 1
                    ELSE 0
                END
            ) = 1 THEN '대여중'
        ELSE '대여 가능'
    END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
GROUP BY CAR_ID
ORDER BY CAR_ID DESC