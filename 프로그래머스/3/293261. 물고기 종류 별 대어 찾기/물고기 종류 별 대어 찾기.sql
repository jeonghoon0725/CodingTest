-- 코드를 작성해주세요
SELECT
    ID
    ,(
        SELECT
            FISH_NAME
        FROM FISH_NAME_INFO FNI
        WHERE FNI.FISH_TYPE = FI.FISH_TYPE
    ) AS FISH_NAME
    ,LENGTH
FROM (
    SELECT
        ID
        ,FISH_TYPE
        ,LENGTH
        ,ROW_NUMBER() OVER (PARTITION BY FISH_TYPE ORDER BY LENGTH DESC) AS RN
    FROM FISH_INFO
) FI
WHERE FI.RN = 1
ORDER BY ID