---
description: 平台自带的H2数据库在使用过程中会随着数据量的增加而增长，但是并不会在删除数据后自动缩小。所以O2OA提供了数据库压缩命令用于缩小数据库占用的空间。
---

# 压缩H2数据库

操作命令说明

```text
compact data passwd
```

{% hint style="info" %}
#### 其中passwd 是xadmin密码。压缩数据库时，请不要启动数据库。
{% endhint %}

执行压缩命令

数据库压缩命令：compact data o2，其中o2是平台默认的xadmin密码。

{% hint style="info" %}
#### 如果密码已经修改过了，请使用新的密码。
{% endhint %}

![&#x6B63;&#x5728;&#x538B;&#x7F29;&#x6570;&#x636E;&#x5E93;](../../.gitbook/assets/5%20%281%29.png)

压缩时间由数据量大小而定。

![&#x6570;&#x636E;&#x5E93;&#x538B;&#x7F29;&#x5B8C;&#x6210;](../../.gitbook/assets/6%20%287%29.png)

压缩完成后，H2数据库文件会有一定的缩小。 

{% hint style="info" %}
#### 数据库文件路径：o2server\local\repository\data\X.mv.db
{% endhint %}





