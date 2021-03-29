SELECT COUNT(*) FROM videos_file;
/* 重复文件每个个数*/
SELECT `name`,COUNT(*) num FROM videos_file GROUP BY `name` HAVING COUNT(*)>1
/* 重复文件数量*/
SELECT COUNT(*) FROM (SELECT `name`,COUNT(*) num FROM videos_file GROUP BY `name` HAVING COUNT(*)>1) a;

SELECT * FROM videos_file WHERE `name` LIKE '%.png';

/* 查找重复文件*/
SELECT * FROM videos_file WHERE `name` IN (SELECT `name` FROM videos_file GROUP BY`name` HAVING COUNT(*)>1);

 /* 删除数据 id从0开始*/
 TRUNCATE TABLE videos_file;