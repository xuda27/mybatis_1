# mybatis_1简介：

1. **mybatis实现关联表查询**
2. 以oracle数据库为例
3. 假设1个班级对应1个老师
4. 班级表与老师表DDL如下：

```sql
  
create table teachers(
  tid int primary key,
  tname varchar2(10) not null
);
  
create table classes(
  cid int primary key,
  cname varchar2(10) not null unique,
  tid int
  	constraints FK_classes_teachers_id references teachers(tid)
);
  
```

