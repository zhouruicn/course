# DB2

支持DB2v10以上版本.

```text
[
	{
		"url" : "jdbc:db2://127.0.0.1:50000/X",
		"username" : "db2admin",
		"password" :"password",
		"includes": [],
		"excludes": [],
		"enable" : true
	}
]
```

DB2默认对查询长度有限制,查询的长度不能超过字段长度.由于数据会引起一下错误:

```text
Caused by: org.apache.openjpa.lib.jdbc.ReportingSQLException: DB2 SQL Error: SQLCODE=-302, SQLSTATE=22001
```

在这样的情况下可以通过设置一下参数:

DB2\_DEFERRED\_PREPARE\_SEMANTICS=YES

