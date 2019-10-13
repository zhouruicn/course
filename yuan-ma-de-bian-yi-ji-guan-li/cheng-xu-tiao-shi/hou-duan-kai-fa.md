---
description: O2OA无法直接在IDE内直接运行起来，无法直接进行断点调试。可以使用JVM的调试端口配合IDE进行远程调试。
---

# 后端代码的远程调试

## 一、服务器上添加配置

jvm是支持远程调试的，得在启动脚本里加jvm参数开启远程调试

![&#x6DFB;&#x52A0;&#x914D;&#x7F6E;](../../.gitbook/assets/image%20%2865%29.png)

添加内容：-Xdebug -Xrunjdwp:transport=dt\_socket,address=6666,server=y,suspend=n

```text
"%~dp0jvm\windows\bin\java" -Xdebug -Xrunjdwp:transport=dt_socket,address=6666,server=y,suspend=n -Xms2g -XX:+UseConcMarkSweepGC -jar "%~dp0console.jar"
```

## 二、启动服务器

正常启动服务器，但是可以看到输出的日志中有打印开放端口的的日志。

Listening for transport dt\_socket at address: 6666

![&#x670D;&#x52A1;&#x5668;&#x542F;&#x52A8;&#x622A;&#x56FE;](../../.gitbook/assets/qq-jie-tu-20190920163631.png)

## 三、IDEA相关配置

### 1、增加调试/运行配置

![](../../.gitbook/assets/image%20%28152%29.png)

### 2、启动调试

点击左上角的绿色小虫，会提示

Connected to the target VM, address: '127.0.0.1:6666', transport: 'socket'

![](../../.gitbook/assets/image%20%28130%29.png)

### 3、增加断点

![](../../.gitbook/assets/image%20%281%29.png)

## 四、Eclipse相关配置

### 1、打开调试/运行配置界面

![](../../.gitbook/assets/image%20%2843%29.png)

### 2、新增远程调试配置

![](../../.gitbook/assets/image%20%28167%29.png)

### 3、选择需要调试的项目

选择项目，输入远程服务器的主机ip地址与端口号

![](../../.gitbook/assets/image%20%2816%29.png)

### 4、配置完成后点击“debug”按钮

![](../../.gitbook/assets/image.png)

### 5、在代码增加断点调试

![](../../.gitbook/assets/image%20%28168%29.png)

Eclipse远程调试教程很多，可以参考:

[https://www.eclipse.org/jetty/documentation/current/enable-remote-debugging.html](https://www.eclipse.org/jetty/documentation/current/enable-remote-debugging.html)

