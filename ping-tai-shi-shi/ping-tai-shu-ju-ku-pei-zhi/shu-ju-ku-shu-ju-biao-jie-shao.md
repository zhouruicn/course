---
description: 本章节主要介绍O2OA支持的各种不同的数据库的连接配置信息，供开发者参考。
---

# 数据库配置信息样例

{% hint style="info" %}
#### 平台默认内置H2数据,在正式环境中建议使用外部数据库.
{% endhint %}

外部数据库通过config/externalDataSources.json配置实现.

## H2

H2为内置数据库,不需要进行配置.

在node.json配置的data中进行配置.

```text
  "data": {
    "enable": true,
    "tcpPort": 20050.0,
    "webPort": 20051.0,
    "includes": [],
    "excludes": [],
    "jmxEnable": false,
    "cacheSize": 512.0,
    "logLevel": "WARN"
  }
```

参数说明：

```text
enable:是否启用,如果没有可用的externalDataSources.json文件,那么默认会在节点中启用本地的H2数据库作为默认的数据库. 
tcpPort:H2数据库jdbc连接端口,登录的用户名:sa,密码为xadmin的密码.数据库创建在/o2server/local/repository/data/X.mv.db,一旦数据库文件被创建,那么该数据库的密码被创建. 
webPort:H2数据库web端口,H2提供一个web端的client,此端口为web端client的访问端口.用户名sa,密码为xadmin数据库初始创建的密码. 
includes:设置此数据库存储的类,默认情况下存储所有类型,如果需要对每个类进行单独的控制以达到高性能,可以将不同的类存储到不同的节点上提高性能.可以使用通配符. 
excludes:在此节点上不存储的类,和includes一起设置实际存储的类,可以使用通配符. 
jmxEnable:是否启动jmx,如果启用,可以通过本地的jmx客户端进行访问,不支持远程jmx客户端.
 cacheSize:H2数据库缓存大小,设置H2用于作为缓存的内存大小,以M作为单位,这里默认为512M. 
logLevel:默认日志级别
```

## Mysql

{% hint style="info" %}
#### 支持MySQL5.7以上版本,建议使用MySQL8
{% endhint %}

```text
[
	{
		"url":"jdbc:mysql://127.0.0.1:3306/X?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
		"username" : "root",
		"password" :"password",
		"includes": [],
		"excludes": [],
		"enable" : true
	}
]
```

## Oracle

{% hint style="info" %}
#### 仅支持Oracle12c以上版本,**不支持12c以下版本**
{% endhint %}

```text
[
	{
		"url":"jdbc:oracle:thin:@//127.0.0.1:1521/orcl",
		"username" : "X",
		"password" :"password",
		"includes": [],
		"excludes": [],
		"enable" : true
	}
]
```

## DB2

{% hint style="info" %}
#### 支持DB2v10以上版本.
{% endhint %}

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

{% hint style="info" %}
#### DB2默认对查询长度有限制,查询的长度不能超过字段长度.由于数据会引起一下错误:

Caused by: org.apache.openjpa.lib.jdbc.ReportingSQLException: DB2 SQL Error: SQLCODE=-302, SQLSTATE=22001
{% endhint %}

在这样的情况下可以通过设置以下参数解决:

DB2\_DEFERRED\_PREPARE\_SEMANTICS=YES

## SQLServer

{% hint style="info" %}
#### 支持SQL Server 2017 以上版本
{% endhint %}

```text
[
	{
		"url" : "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=X;selectMethod=cursor;sendStringParametersAsUnicode=false",
		"username" : "sa",
		"password" :"password",
		"includes": [],
		"excludes": [],
		"enable" : true
	}
]
```

## PostgreSQL

```text
[
	{
		"url" : "jdbc:postgresql://localhost:5432/X",
		"username" : "postgres",
		"password" :"password",
		"includes": [],
		"excludes": [],
		"enable" : true
	}
]
```

## Informix

```text
[
	{
		"url" : "jdbc:informix-sqli://123.45.67.89:1533/X:INFORMIXSERVER=informixServer",
		"username" : "admin",
		"password" :"password",
		"includes": [],
		"excludes": [],
		"enable" : true
	}
]
```

## 达梦数据库

```text
[
	{
		"url" : "jdbc:dm://127.0.0.1/X",
		"username" : "admin",
		"password" :"password",
		"includes": [],
		"excludes": [],
		"enable" : true
	}
]
```

## 人大金仓数据库

{% hint style="info" %}
#### 人大金仓数据库支持V7和V8两个版本,但两个版本的jdbc驱动不同.
{% endhint %}

### V7

```text
[
	{
		"url" : "jdbc:kingbase://127.0.0.1:54321/X",
		"username" : "system",
		"password" :"krms",
		"includes": [],
		"excludes": [],
		"enable" : true
	}
]
```

### V8

```text
[
	{
		"url" : "jdbc:kingbase8://127.0.0.1:54321/X",
		"username" : "system",
		"password" :"krms",
		"includes": [],
		"excludes": [],
		"enable" : true
	}
]
```





















