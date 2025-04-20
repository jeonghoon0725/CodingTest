-- 코드를 작성해주세요
SELECT E.EMP_NO
        ,E.EMP_NAME
        ,G.SCORE_GRADE AS GRADE
        ,CASE
            WHEN G.SCORE_GRADE = 'A' THEN E.SAL * 0.15
            WHEN G.SCORE_GRADE = 'B' THEN E.SAL * 0.1
            WHEN G.SCORE_GRADE = 'S' THEN E.SAL * 0.2
            ELSE 0
        END AS BONUS
FROM HR_EMPLOYEES E
INNER JOIN (
    SELECT
        EMP_NO 
        ,CASE
            WHEN AVG(SCORE) >= 96 THEN 'S'
            WHEN AVG(SCORE) >= 90 THEN 'A'
            WHEN AVG(SCORE) >= 80 THEN 'B'
            ELSE 'C'
        END AS SCORE_GRADE
    FROM HR_GRADE
    GROUP BY EMP_NO
) G
ON E.EMP_NO = G.EMP_NO
ORDER BY EMP_NO