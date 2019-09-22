---
description: O2OA平台内嵌了H2数据库，管理员可以通过支持JDBC的客户端对H2数据库进行访问和数据操作。
---

# 访问和操作H2数据库

O2OA默认内嵌了H2数据库，H2数据库支持两种访问方式：

**一、以WEB方式访问数据库**

**二、以客户端形式访问数据库（JDBC）**

\*\*\*\*

## **Web访问** <a id="h1_1"></a>

默认访问地址：[http://hostip:20051/](http://hostip:20051/)

{% hint style="info" %}
**20051为系统默认的H2数据库访问端口，管理员可以在node\_127.0.0.1.json里对端口进行配置**
{% endhint %}

![&#x8FDE;&#x63A5;H2&#x6570;&#x636E;&#x5E93;](../../.gitbook/assets/d667b22f88cd15311295e0b684f4fc06fff.jpg.webp)

**参数说明**

```text
Saved Settings: Generic H2 （Server）
Setting Name: Generic H2 （Server）
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:tcp://localhost:20050/X
User Name：sa
Password: o2
```

{% hint style="info" %}
**20050是平台默认的H2数据库JDBC访问端口，管理员可以在node\_127.0.0.1.json文件中修改该端口配置。**
{% endhint %}

\*\*\*\*

\*\*\*\*

\*\*\*\*

\*\*\*\*

\*\*\*\*

