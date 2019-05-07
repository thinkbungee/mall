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

select p.*
from ums_admin_role_relation ar
       left join ums_role r on ar.role_id = r.id
       left join ums_role_permission_relation rp on rp.role_id = r.id
       left join ums_permission p on rp.permission_id = p.id
where ar.admin_id = 3
  and p.id is not null
  and p.id not in (
                  select p.id
                  from
                       ums_admin_permission_relation pr
                         left join ums_permission p on pr.permission_id = p.id
                  where pr.type = -1 and pr.admin_id = 3
                  )
union
select p.*
from ums_admin_permission_relation pr
       left join ums_permission p on pr.permission_id = p.id
where pr.type = 1 and pr.admin_id = 3


