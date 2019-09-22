---
description: O2OA提供离线升级命令，用户可以下载最新的安装包到服务器进行服务器升级，系统升级时可以对旧程序进行备份，让升级操作更加可靠。
---

# 平台升级操作说明

{% hint style="info" %}
#### **因为安装包比较大，部分用户直接在线升级因为网络原因会导致更新不成功，所以我们停用在线直接升级，启用离线包进行服务器升级的方式。**
{% endhint %}

##  一、**查看当前系统版本号**

服务器下载完成后，执行启动命令（start\_windows.bat或者start\_linux.sh等），命令提示窗口将会展示服务器信息及可执行的服务器命令说明，如下图所示：

![&#x67E5;&#x8BE2;&#x670D;&#x52A1;&#x5668;&#x7248;&#x672C;&#x53F7;](../.gitbook/assets/qq-jie-tu-20190922145840.png)

##  二、**下载离线安装包**

{% hint style="info" %}
#### O2OA v4.1369\[o2server_20190223090617_\*.zip\]之后的版本均支持离线升级操作。
{% endhint %}

![O2OA&#x5B98;&#x7F51;&#x4E0B;&#x8F7D;](../.gitbook/assets/qq-jie-tu-20190922150202.png)

在O2OA v4.1369之后，O2OA支持系统下载离线包进行离线升级来支持内网升级并且提高升级过程成功率。

![](../.gitbook/assets/074dd7dba8f53fcfda1ebf64d982ea2fdca.jpg)

执行命令：

```text
update file d:/versions/o2server_20190318092737_windows.zip false o2
```

此命令将根据下载到本地磁盘D盘version目录下的O2OA服务器安装文件：o2server\_20190318092737\_windows.zip 进行升级，不对原系统进行备份，如果是其他操作系统，请根据操作系统自行选择正确的安装文件。

{% hint style="info" %}
#### 根据不同的服务器主机配置，升级过程可能需要一定的时间。
{% endhint %}

更新命令执行完成后，请点击任意键关闭控制台窗口（linux可以exit或者kill进程来退出），然后重新执行start\_windows命令，系统会自动开始服务器文件升级过程，如下图所示界面：

![&#x91CD;&#x65B0;&#x542F;&#x52A8;&#xFF0C;&#x5B8C;&#x6210;&#x5347;&#x7EA7;&#x8FC7;&#x7A0B;](../.gitbook/assets/de3097d445f3f613de08316c12ddff9b1f2.jpg)

升级完成后即可启动服务器。

































