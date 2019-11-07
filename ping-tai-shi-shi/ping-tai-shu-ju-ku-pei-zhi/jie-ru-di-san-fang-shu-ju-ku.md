---
description: >-
  O2OA内置H2数据库，但系统真正上线使用时，需要更高的数据库性能。此时，可以将O2OA数据库切换到第三方商用级数据库，如Mysql等。本文以MySQL数据库为例进行说明。
---

# 接入第三方数据库

##  **一、数据库准备工作 - Mysql数据库安装​**

下载和安装数据库的知识并不在本博客讲述的范围，请大家百度相关的技术文章完成Mysql数据库的安装。建议版本在Mysql5.7+，推荐Mysql8。

Mysql各版本下载请参见：[https://blog.csdn.net/kerafan/article/details/78001849](https://www.mysql.com/downloads/)

Mysql安装步骤请参见：[http://www.cnblogs.com/sshoub/p/4321640.html](https://www.cnblogs.com/sshoub/p/4321640.html)

Mysql修改数据库连接数：https://blog.csdn.net/zhya910702/article/details/48372433

##  **二、O2OA配置修改​**

###  **1、关闭内置数据库**

配置文件路径：o2server/config/node\_127.0.0.1.json

如果没有该文件，请从目录o2server/configSample/中复制**node\_127.0.0.1.json**文件到o2server/config目录下。

{% hint style="info" %}
直接在configSample目录下修改配置文件将不会生效。
{% endhint %}

```text
{  "enable": true,  "port":null,  "sslEnable":false,  "logLevel":"info",  "isPrimaryCenter": true,  "nodeAgentEnable": true,  "application": {    "enable": true,    "port": null,    "sslEnable": false,    "proxyHost": "",    "proxyPort": null,    "forceRedeploy": true,    "scanInterval":5,    "includes":[],    "excludes":[]  },  "web": {    "enable": true,    "port": null,    "sslEnable": false,    "proxyHost": "",    "proxyPort": null,    "forceRedeploy": true  },  "storage": {    "enable": true,    "port": null,    "sslEnable": false,    "name" : ""  },  "data": {             #内置数据库相关配置，可以修改端口以及是否启用    "enable": true,     #修改enable的值为false    "tcpPort": null,    "webPort": null,    "includes": [],    "excludes": []  },  "dumpData":{    "cron" : "0 0 21 * * ?",    "size" : 14  },  "dumpStorage":{    "cron" : "0 0 21 * * ?",    "size" : 14  }}
```

###  **2、开启和配置外部数据库信息**

配置文件路径：o2server/config/externalDataSources.json

如果没有该文件，请从目录o2server/configSample/ 中复制**externalDataSources.json**文件到o2server/config目录下。

{% hint style="info" %}
直接在configSample目录下修改配置文件将不会生效。
{% endhint %}

将其中的url、username、password以及enable信息修改为上述Mysql的相关信息，如：

```text
[    {        "url":"jdbc:mysql://127.0.0.1:3306/X?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",        "username" : "root",        "password" :"password",        "includes": [],        "excludes": [],        "enable" : true    }]
```

 URL参数说明如下**：**

```text
useUnicode: 是否使用Unicode字符集，如果参数characterEncoding设置为gb2312或gbk，本参数值必须设置为true false 1.1g characterEncoding: 当useUnicode设置为true时，指定字符编码。比如可设置为gb2312或gbk false 1.1g autoReconnect: 当数据库连接异常中断时，是否自动重新连接？ false 1.1 autoReconnectForPools: 是否使用针对数据库连接池的重连策略 false 3.1.3 failOverReadOnly: 自动重连成功后，连接是否设置为只读？ true 3.0.12 maxReconnects: autoReconnect设置为true时，重试连接的次数 3 1.1 initialTimeout: autoReconnect设置为true时，两次重连之间的时间间隔，单位：秒 2 1.1 connectTimeout: 和数据库服务器建立socket连接时的超时，单位：毫秒。 0表示永不超时，适用于JDK 1.4及更高版本 0 3.0.1 socketTimeout: socket操作（读写）超时，单位：毫秒。 0表示永不超时 0 3.0.1 serverTimezone: 服务器时区（避免数据与正确时间相关8小时的问题）
```

{% hint style="info" %}
**数据库连接URL中的数据 X01 是需要预选创建的，O2Server会自动创建数据表，但不会自动创建数据库。**
{% endhint %}

设置完成后，重启o2server即可。

\*\*\*\*

\*\*\*\*

\*\*\*\*

