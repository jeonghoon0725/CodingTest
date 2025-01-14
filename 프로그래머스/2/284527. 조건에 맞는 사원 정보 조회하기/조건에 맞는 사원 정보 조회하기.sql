WITH CTE_SUM_SCORE AS (
    SELECT
        EMP_NO,
        SUM(SCORE) AS SUM_SCORE
    FROM HR_GRADE
    GROUP BY EMP_NO
)

SELECT
    CSS.SUM_SCORE AS SCORE
    ,HE.EMP_NO
    ,HE.EMP_NAME
    ,HE.POSITION
    ,HE.EMAIL
FROM CTE_SUM_SCORE CSS
LEFT OUTER JOIN HR_EMPLOYEES HE ON HE.EMP_NO = CSS.EMP_NO
LEFT OUTER JOIN HR_DEPARTMENT HD ON HD.DEPT_ID = HE.DEPT_ID
WHERE CSS.SUM_SCORE = (
    SELECT MAX(SUM_SCORE) FROM CTE_SUM_SCORE
);