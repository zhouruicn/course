# 源码的编译和源码结构

O2OA在github上开源了平台源码，用户可以Fork源码，并且自己进行服务器编译，打包。也支持对源码自行进行修改后进行服务器打包。

**因为在github上Clone源码实在是太慢了，所以我们也可以使用国内的仓库gitee\[码云\]来下载，速度会快很多。**

具体步骤如下：

## 一、Fork源码到自己的gitee仓库

1、访问O2OA项目的gitee仓库：[https://gitee.com/liyihz2008/O2OA](https://gitee.com/liyihz2008/O2OA)

![](https://oscimg.oschina.net/oscnet/5e1e99a58f038e25d8b9f5de0cdb6b16c67.jpg)

2、点击Fork将O2OA源码Fork到自己的gitee\[码云\]仓库

![](https://oscimg.oschina.net/oscnet/f6515e4edd65d66d4244a3e1f57027be55e.jpg)

## 二、安装Github Desktop

1、下载Github Desktop：[https://desktop.github.com/](https://desktop.github.com/)

![](https://oscimg.oschina.net/oscnet/6755930cda64dda199b7c95f25dda345b9c.jpg)

## 三、使用Github Desktop客户端Clone源码到本地

1）查询自己的gitee仓库\[码云\]中O2OA项目的Clone地址

![](https://oscimg.oschina.net/oscnet/b50d33723936497271679337c6e8c683153.jpg)

2、打开Github Desktop客户端，从自己的github仓库中clone源码

1）打开Github Desktop客户端，点击Clone a repository form the Internet...

![](https://oscimg.oschina.net/oscnet/886c383129c41dd489dc41d53b1a498abaa.jpg)

2）在弹出的Clone a repository对话框里选择URL选项卡，填写URL和Clone到的本地地址后，点击Clone即可开始Clone项目源码：

![](https://oscimg.oschina.net/oscnet/739fc6d6f7ae35842fb2ed0cdbcd70f8a0f.jpg)

请注意，我们建议您Clone您之前Fork到自己的gitee仓库里的源码，可以观察一下Clone的地址：

如：https://gitee.com/**您的github账号**/O2OA， 而不是https://gitee.com/**liyihz2008**/O2OA

3）正在Clone，等等Clone完成即可。如下图所示：

![](https://oscimg.oschina.net/oscnet/366de2dd40d36f110ccdbf87418041c2046.jpg)

从Github上Clone项目比gitee上要慢很多，可能需要更多的时间。

## 四、配置源码编译环境

### 1、安装Nodejs

nodejs下载地址：http://nodejs.cn/download/ （您也可以从官网下载：https://nodejs.org/en/）

![](https://oscimg.oschina.net/oscnet/d934ca91c240ea6e6f72f299b4148d98afc.jpg)

下载windows安装程序（.mis）

下载完成后直接进行安装，直接next直至安装完成即可。如下图所示：

![](https://oscimg.oschina.net/oscnet/2b4958cd139609d2e415fc2ec118d0244f5.jpg)

### 2、安装配置maven环境

1）Maven下载地址：http://maven.apache.org/download.cgi， 下载好之后，解压并选择存放路径

![](https://oscimg.oschina.net/oscnet/25248387227c23ea872dcf52ff7a1d85d04.jpg)

2）首先打开我的电脑-&gt;属性-&gt;高级系统设置

新建系统变量：MAVEN\_HOME，复制Maven的路径

![](https://oscimg.oschina.net/oscnet/88aa73fb295a1e2d4e2ab9cb6037b68a333.jpg)

在系统变量：path中复制粘贴：%MAVEN\_HOME%\bin

![](https://oscimg.oschina.net/oscnet/bce4d5b5be6d86c3e1e5268f946c3aed051.jpg)

Win+R快捷键打开命令行，输入：mvn -v，如出现以下图样，则表示配置成功

![](https://oscimg.oschina.net/oscnet/922464ec15477100d54ed9d28e203b1e998.jpg)

### 3、安装配置ant环境

官方http://ant.apache.org/bindownload.cgi下载新版（目前为Ant1.10.5）的ant，得到的是一个apache-ant-1.10.5-bin.zip的压缩包。将其解压到你的硬盘上，例如：E:\Work\apache-ant-1.10.5。

新建系统变量：ANT\_HOME，复制Ant的路径，如下图所示：

![](https://oscimg.oschina.net/oscnet/be398090ddc29534db2e00a3b8394a63702.jpg)

在系统变量：path中复制粘贴：%ANT\_HOME%\bin：

![](https://oscimg.oschina.net/oscnet/246366695599786472ee7973ecb9c5ae617.jpg)

在系统变量：classpath中复制粘贴：%ANT\_HOME%\lib

![](https://oscimg.oschina.net/oscnet/77429e3918629683f93be36a128726f6fad.jpg)

Win+R快捷键打开命令行，输入：ant，如出现以下图样，则表示配置成功

![](https://oscimg.oschina.net/oscnet/bea63d633e850ac60b38b69a10997f083d8.jpg)

## 五、初次编译源码

下载后o2server项目源码直接导入eclipse后会有很多依赖错误，因为大量的依赖包没有编译为jar文件，所以需要先将下载后的源码中o2server项目整体编译一次。

1、打开命令提示工具，cd到o2oa/o2server目录（或者直接在o2server目录打开powersheell\(win10\)）

```text
cd E:\O2\o2oa\o2server
```

![](https://oscimg.oschina.net/oscnet/dbd363cc4da7e9020681b90f39ac77617a7.jpg)

2、在o2server目录下直接执行命令进行编译：**mvn install**，开始进行源码编译：

```text
mvn install
```

![](https://oscimg.oschina.net/oscnet/63f6396617f93d5c1432de6d9e06df3d5ae.jpg)

直到编译完成（一共57个项目，视开发机性能约需5-20分钟），如下图所示：

![](https://oscimg.oschina.net/oscnet/64751e48373ee400f6ecc4874ce4a72677e.jpg)

3、打包安装程序： ant

```text
ant
```

编译完成后，可直接支持ant命令进行打包：

![](https://oscimg.oschina.net/oscnet/02080f82cdbe31e9cbd170967767d52c6ad.jpg)

直到打包完成（视开发机性能，约5-10分钟），如下图所示：

![](https://oscimg.oschina.net/oscnet/1a5860f7566b073a8a1447d952d01aebfee.jpg)

## 六、使用Eclipse导入o2oa源码

注意，当源码导入到eclipse项目后，maven会从mvn repository下载所依赖的项目jar包，可能需要一些时间，视情况在5-30分钟左右。

![](https://oscimg.oschina.net/oscnet/896831c2bb17e519835c9079744562d8651.jpg)

当所有的依赖包下载完成后，eclipse里如果仍有大量报错，请在o2server项目上执行Maven -&gt; Update Project...

## 七、关于Eclipse中pom.xml报错

1、关于o2server项目的pom.xml报错：

![](https://oscimg.oschina.net/oscnet/0337dd7b799ff46c1d79dec2700f02663bb.jpg)

三个相对路径依赖引用引起的pom.xml报错，可以忽略，完全不影响项目编译。

2、关于x\_base\_core\_project项目和所有的 \*\_core\_entity 项目中pom.xml报错

![](https://oscimg.oschina.net/oscnet/a18e76e52d69ac26f76a43260a3955dac43.jpg)

maven plugin的execution出错，可以忽略，不影响项目编译。解决方案可以百度：maven plugin的execution出错，有很多解决方案发，我们的源码会在近期更新时解决此问题。

## 八、单独的项目编译

将项目导入eclipse后，也可以在eclipse里使用maven插件对单个的项目进行编译。

直接打开指定项目，在pom.xml上运行Run as ... -&gt; Maven install即可，如下图所示：

![](https://oscimg.oschina.net/oscnet/931c074275baf4dfaf842561826a18d8904.jpg)

编译完成后，jar 包将编译到目录：o2oa\o2server\store\jars，war包将编译到目录：o2oa\o2server\store

