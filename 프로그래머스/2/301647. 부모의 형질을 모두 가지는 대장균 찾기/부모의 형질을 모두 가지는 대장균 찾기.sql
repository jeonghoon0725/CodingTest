-- 코드를 작성해주세요
SELECT
    ED.ID
    ,ED.GENOTYPE
    ,ED_H.GENOTYPE AS PARENT_GENOTYPE
FROM ECOLI_DATA ED
INNER JOIN ECOLI_DATA ED_H
ON ED_H.ID = ED.PARENT_ID
WHERE ED.GENOTYPE & ED_H.GENOTYPE = ED_H.GENOTYPE
ORDER BY ED.ID