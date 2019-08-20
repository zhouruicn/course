---
description: Statement
---

# 查询语句

查询语句是建立在数据表基数上的查询语句配置。配置查询语句后，在应用中可调用执行。

## 入口 <a id="ru-kou"></a>

点系统的左上角导航-&gt;设计中心-&gt;数据中心-&gt;具体应用-&gt;查询配置打开

## 查询语句的后台服务 <a id="shi-tu-de-hou-tai-fu-wu"></a>

​[http://applicationServer:20020/x\_query\_assemble\_surface/jest/index.html](http://:20020/****/x_query_assemble_surface/jest/index.html)​

![](../.gitbook/assets/qq-tu-pian-20190820103821.png)

## 创建查询配置

1、创建查询配置；

2、选择语句类型和数据表；

3、编写查询语句，保存

## 查询语句

### 语法

查询语句用的是JPA JPQL语句，如 `select o from tableName o where o.name='zhangsan'`。

了解JPQL语句可以点击链接查看：[https://www.objectdb.com/java/jpa/query/jpql/structure](https://www.objectdb.com/java/jpa/query/jpql/structure)​

### 动态传参

查询语句中的参数可以使用json传入

如：

查询语句的设计为 `select o from tableName o where o.name=?n`

在调用查询语句的时候传入 json

```text
{
    "n" : "zhangsan"
}
```

则 最终在后台拼接成的语句为

`select o from tableName o where o.name=‘’`

![](../.gitbook/assets/qq-tu-pian-20190820111500.png)

## 使用 <a id="shu-ju-biao-jiao-ben"></a>

需要编写脚本去使用查询语句

```text
o2.Actions.get( "x_query_assemble_surface" ).executeStatement(
    statementFlag, //语句id、语句名称或语句别名
    page, //页码，数字
    size,  //每页条数
    function(json){
        //执行結果
    }
)
```



