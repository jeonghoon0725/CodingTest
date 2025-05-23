-- 코드를 입력하세요
SELECT
    AI.ANIMAL_ID
    ,AI.ANIMAL_TYPE
    ,AI.NAME
FROM ANIMAL_INS AI
INNER JOIN ANIMAL_OUTS AO
ON AO.ANIMAL_ID = AI.ANIMAL_ID
WHERE AI.SEX_UPON_INTAKE LIKE 'Intact%'
AND (
    AO.SEX_UPON_OUTCOME LIKE 'Spayed%'
        OR
    AO.SEX_UPON_OUTCOME LIKE 'Neutered%'
)