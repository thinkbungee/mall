/**1. getPermissionList
            查询一个用户(比如这个用户的admin_id=3)拥有的所有权限SQL：
分析：
一个用户(可以拥有多种角色role)
比如 ums_admin中 id=3 的用户 的 role为 1(商品管理员),2(商品分类管理员),4(品牌管理员)：

role和permission对应关系
role为1 拥有  权限id：1 2 3 7 8
role为2 拥有  权限id：4 9 10 11
role为4 拥有  权限id：6 15 16 17

所以分析SQL的组成
 */
-- 第一 查询 这个roleList的所有权限
select * from ums_permission p where p.id in (1, 2, 3, 7, 8,
                                              4, 9, 10, 11,
                                              6, 15, 16, 17);

-- 第二 查询 这个用户id 拥有的roles
select * from ums_admin_role_relation ar where ar.admin_id = 3;

-- 第三 查询 role对应的权限
-- 比较简单


-- 第四 结合 ums_admin_permission_relation 表
-- 权限为- 需要剔除掉，权限为+ 需要增加

-- 汇总SQL
SELECT p.*
FROM ums_admin_role_relation ar
       LEFT JOIN ums_role r ON ar.role_id = r.id
       LEFT JOIN ums_role_permission_relation rp ON rp.role_id = r.id
       LEFT JOIN ums_permission p ON rp.permission_id = p.id
WHERE ar.admin_id = 3
  AND p.id IS NOT NULL
  AND p.id NOT IN (
                  SELECT p.id
                  FROM
                       ums_admin_permission_relation pr
                         LEFT JOIN ums_permission p ON pr.permission_id = p.id
                  WHERE pr.type = -1 AND pr.admin_id = 3
                  )
UNION
SELECT p.*
FROM ums_admin_permission_relation pr
       LEFT JOIN ums_permission p ON pr.permission_id = p.id
WHERE pr.type = 1 and pr.admin_id = 3
