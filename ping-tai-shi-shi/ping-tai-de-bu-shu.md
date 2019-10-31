---
description: O2OA安装部署非常方便，只需要简单的三步即可完成安装。平台内部集成了多项管理命令，可以进行系统升级，管理员密码修改，数据导出恢复等管理操作。
---

# 平台下载及安装部署

## 一、下载安装包并且解压

 http://www.o2oa.net/download.html

下载与系统对应的版本.

O2OA支持windows/linux/macos/aix/中标麒麟操作系统，下载相应的安装包版本，安装包大小大概400M左右。这里以Windows系统为例：

1\) 下载o2server\_yyyyMMddHHmmss\_windows.zip程序包.

2\) 解压下载后的压缩包到任意目录（注意：为了避免JVM异常，**请不要使用有中文目录和空格的目录名**）

## 二、检查服务器端口环境

为了服务器能正常启动，请确认服务器的80、20020、20030端口未被占用，如果是云服务器的话，请确认以上端口可以被访问（已经加入到安全控制策略，或者防火墙允许以上端口被访问）

## 三、启动服务器

打开o2server文件夹，选择start\_windows.bat双击打开（如有必要，请使用管理员身份打开start\_windows.bat），命令提示窗口如下图所示:

![](../.gitbook/assets/12a010d5313bea667ded00c148ec84d594a.jpg)

![](file://C:/Users/zhour/Desktop/12a010d5313bea667ded00c148ec84d594a.jpg?lastModify=1565946515)

在命令行中输入"start" 回车，O2OA各服务器开始启动启动服务，等待相关服务启动完成即可。

 _**启动顺序依次为：**_

 a.数据库服务器 （默认占用20050端口）

 b.文件存储服务器（默认占用20040端口）

 c.中心调度服务器（默认占用20030端口）

 d.应用服务器 （默认占用20020端口）

 e.静态资源服务器（WEB服务器，默认占用80端口）

启动界面如下图所示：

![](../.gitbook/assets/image%20%2853%29.png)

![&#x670D;&#x52A1;&#x5668;&#x542F;&#x52A8;&#x987A;&#x5E8F;](file://C:/Users/zhour/Desktop/qidong.jpg?lastModify=1565946515)

当出现如下信息

**\[main\] com.x.server.console.server.web.WebServerTools - web server start completed on port: 80.**

时，表示安装完毕，可通过当前主机[http://127.0.0.1:80](http://127.0.0.1:80) 登陆O2OA平台。

![](https://oscimg.oschina.net/oscnet/27a128076d5b086a5957f406e9b6314e2ac.jpg)

 输入用户名xadmin密码o2登陆系统即可。

## 四、启动命令说明

```text
help                                         显示启动命令列表。
start|stop [all]                             启动或者停止服务器，启动全部或者停止全部服务器时，all可以省略.
start|stop data                              启动或者停止数据库服务器。
start|stop                                   启动或者停止文件存储服务器。
start|stop center                            启动或者停止中心调度服务器。
start|stop                                   启动或者停止应用服务器。
start|stop web                               启动或者停止WEB服务器。
dump data (passwd)                           导出全部数据命令，如 dump data o2，其中o2是
                                             管理员密码，导出的数据在目录
                                             o2server/local/dump目录下，导出文件名如：
                                             o2server/local/dump/dumpData_20180926060
                                             000。其中20180926060000是日期时间后缀，在导入
                                             （恢复）数据时使用。
dump storage (passwd)                        导出附件或者文件内容，命令使用方法如dump data，
                                             不再详述。
restore data yyyyMMddHHmmss (passwd)         导入（恢复）数据，命令如：
                                             restore data 20180926060000 o2，
                                             其中20180926060000是导出文件的时间后缀，
                                             o2是管理员密码。
restore storage yyyyMMddHHmmss (passwd)      导入（恢复）文件或者附件数据，导入方式同
                                             restore data，不再详述。
setPassword (oldpasswd) (newpasswd)          设置管理员密码，如：setPassword o2 12345678,
                                             其中o2是旧密码，12345678是新密码。
update file path (backup)(passwd)            更新服务器至新版本。
                                             如：update file o2server_xxxx.zip false o2， 
                                             其中o2是旧密码。
compact data (passwod)                       压缩系统自带的H2数据库，如果使用了其他数据库，
                                             此功能不需要使用。命令如：compact data o2， 
                                             其中o2是旧密码。
erase content (cms|pp|bbs|log|report) (passwd)     清除业务数据。此命令将在保留系统设计的
                                                   前提下，清除所有已经发起的流程，以及发布
                                                   的信息，论坛的贴子等用户使用过程中产生的
                                                   数据。如：erase content cms o2， 其中
                                                   cms指信息内容管理系统，o2是旧密码。
create encrypt key                                 创建用于远程连接服务器的私钥和公钥.
show (os|cpu|memory|thread) interval repeat        显示服务器运行状态,例如显示cpu繁忙程度,
                                                   间隔两秒显示一次,共重复100次.
                                                   show cpu 2 100
exit                                               在停止所有服务器之后，退出控制进程。
```

## 五、如何停止服务

### 1、Windows环境

![&#x6B63;&#x5E38;&#x8FD0;&#x884C;&#x4E2D;&#x7684;&#x7CFB;&#x7EDF;](../.gitbook/assets/1%20%288%29.png)

#### 方式一：直接在命令窗口输入 stop

![&#x505C;&#x6B62;&#x670D;&#x52A1;](../.gitbook/assets/2%20%2811%29.png)

#### 方式二：直接关闭命令窗口，进程将被直接杀死

### 2、Linux环境

#### 方式一：如果启动后的控制台窗口仍然存在，直接在控制台输入stop即可，过程与windows环境类似。

#### 方式二：如果控制台已经关闭，o2server进程在后台执行 

1）打开命令控制台，执行命令：ps -ef \| grep o2server

![&#x67E5;&#x8BE2;&#x670D;&#x52A1;&#x8FDB;&#x7A0B;&#x53F7;](../.gitbook/assets/3%20%289%29.png)

2）查询进程号，kill指定o2server进程

```text
kill -9 27488
```

## 六、关于服务器升级

### 1、下载新的服务器安装包

从官网下载安装包，如：o2server20190910223112.zip

### 2、启动旧版本o2server控制台

进入o2server安装目录，打开控制台。

### 3、输入命令开始升级

在控制台输入:  update file \(path\) \(backup\) \(passwd\)

如：update file d:/o2server20190910223112.zip false o2

```text
path:   最新安装包路径.
backup: true | false, 是否进行程序备份.
passwd: xadmin 管理员密码.
```

### 4、重启服务器，完成升级过程。

### 5、键入start，正常启动服务器。



