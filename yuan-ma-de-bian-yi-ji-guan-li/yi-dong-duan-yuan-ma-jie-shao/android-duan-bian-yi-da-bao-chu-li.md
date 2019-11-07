---
description: O2平台Android客户端，最低支持Android版本4.4 Android KitKat，编程语言主要使用kotlin
---

# Android端编译打包处理

### 环境安装

请使用最新版本的`Android Studio`进行导入编译，编译的Android SDK版本是 26 \[**Android O**\] 。 `Android Studio`下载地址[https://developer.android.google.cn/studio/](https://developer.android.google.cn/studio/)

![](http://img.muliba.net/post/20190107140605.png)

安装Android Studio完成后，打开设置里面的SDK Manager工具。

![](http://img.muliba.net/post/20190107141121.png)

选择Android 8.0 ，安装SDK。

![](http://img.muliba.net/post/20190106112546.png)

然后选择SDK Tools 选项卡，勾选右下角的Show Package Details，然后选择Android SDK Build-Tools 下面的27.0.3版本进行安装。

![](http://img.muliba.net/post/20190106112529.png)

### 导入项目

打开`Android Studio` 点击`Open an existing Android Studio project`

![](http://img.muliba.net/post/20190107142220.png)

等它加载完成后可能会弹出这样一个窗口，让你更新gradle版本，这个不需要更新，点击 `Donot remind me again for this project`

![](http://img.muliba.net/post/20190107142755.png)

### 项目基本信息修改

#### 项目名称

项目名称就是Android手机桌面上显示的名称，这个名称修改是在strings资源文件中：

具体位置：`./app/src/main/res/values/strings.xml`

![](http://img.muliba.net/post/20190107143459.png)

#### 项目桌面LOGO

还有就是项目的LOGO，这个LOGO是在Android手机桌面上显示那个图标，这个需要替换图片： 图片位置： `./app/src/main/res` 这个资源目录下有4个 `mipmap` 文件夹，把4个文件夹中的`logo.png`和`logo_round.png`都替换了。

|  |  |
| :---: | :---: |
| ![http://img.muliba.net/post/20190105171759.png](http://img.muliba.net/post/20190105171759.png) | ![](http://img.muliba.net/post/20190105171908.png) |

#### 唯一应用ID

Android应用都有一个唯一的应用ID `applicationId` 。这个id代表这个Android App所以不能重复，一般都用公司域名组成的一串字符串，如： `com.baidu.app.xxx` 。 修改的文件是在`./app/build.gradle` 文件中，android -&gt; defaultConfig -&gt; applicationId 。

![](http://img.muliba.net/post/20190107144344.png)

#### 可配置的应用内图标

App内看到的一些O2OA相关的logo图标，可以不编译打包进App，我们服务端可以进行动态配置。用管理员进入我们O2OA的服务端，找到系统设置-&gt;移动办公配置-&gt;样式配置，就可以修改图标了：

![](http://img.muliba.net/post/20190105172349.png)



### 

### 第三方SDK注册配置

找到项目根目录下的 `local.properties` 文件，里面有一些第三方SDK的key需要配置。

```text
# 下面是第三方SDK 需要的key

# 极光推送
JPUSH_APPKEY_DEBUG=极光推送AppKey
#蒲公英
PGY_APP_ID_DEBUG=蒲公英AppId
#百度语音
BAIDU_SPEECH_APPID=百度语音AppId
BAIDU_SPEECH_SECRET=百度语音Secret
BAIDU_SPEECH_APPKEY=百度语音Appkey
#百度地图
BAIDU_MAP_APPKEY=百度地图Appkey
#腾讯bugly
BUGLY_APPID=腾讯Bugly AppId
```

这些key具体的注册获取，下面有大致说明。

#### 百度语音识别和语音合成

百度语音的官方地址：[http://yuyin.baidu.com/](http://yuyin.baidu.com/) 。 点击右上角控制台登录后，`创建应用` 。

![](http://img.muliba.net/post/20190107152003.png)

注册完成后，查看应用详情，就能看到百度语音相关的AppId、AppKey、SecretKey。把这3个字段内容拷贝到local.properties文件中对应的地方。

![](http://img.muliba.net/post/20190107152530.png)

#### 百度地图

百度地图官方地址：[http://lbsyun.baidu.com/](http://lbsyun.baidu.com/) 登录，进入控制台，创建应用。

![](http://img.muliba.net/post/20190107153754.png)

如图这里有一个必填项SHA1，这个SHA1需要用到Android 打包的签名文件。所以先要有一个签名文件。

**生成签名文件**

签名文件可以用Android Studio 生成。先找到Android Studio菜单 Build -&gt; Generate Signed Bundle or APK 。

![](http://img.muliba.net/post/20190107154817.png)

然后勾选APK ，下一步。 ![](http://img.muliba.net/post/20190107155010.png)

然后点击新建按钮，创建一个新的签名文件。 ![](http://img.muliba.net/post/20190107155053.png)

下面就是签名文件生成的表单，填写完成后点击OK 就生成了。 ![](http://img.muliba.net/post/20190107155231.png)

**获取百度地图需要的SHA1**

使用keytool生成SHA1

* 运行进入控制台（以Window开发环境为例）

![and\_key6.png](http://mapopen-pub-androidsdk.bj.bcebos.com/map/images/and_key6.png)

![and\_key7.png](http://mapopen-pub-androidsdk.bj.bcebos.com/map/images/and_key7.png)

* 定位到`.android`文件夹下，输入`cd .android` 

![and\_key8.png](http://mapopen-pub-androidsdk.bj.bcebos.com/map/images/and_key8.png)

* 继续在控制台输入命令。 命令为：`keytool -list -v -keystore 这里写上面生成的那个签名文件的全路径`
* 输入密码获取。 提示输入签名文件密码。输入密码后回车，此时可在控制台显示的信息中获取SHA1值，如下图所示：
* 
![ and\_key9.png](http://mapopen-pub-androidsdk.cdn.bcebos.com/map/images/and_key9.png)

![and\_key10.png](http://mapopen-pub-androidsdk.cdn.bcebos.com/map/images/and_key10.png)

把这里显示的SHA1的值拷贝到刚才百度地图应用创建页面表单中 ，创建地图应用成功后，到应用列表页面拷贝应用的AK就是AppKey的值。

![](http://img.muliba.net/post/20190107160741.png)

然后把这个值填入`local.properties`文件中对应的百度地图Appkey的位置。

#### 极光

极光官方网站：[https://www.jiguang.cn](https://www.jiguang.cn) 注册登录后，先创建应用。 ![](http://img.muliba.net/post/20190107165307.png)

应用创建后应用信息里面有一个AppKey，把值拷贝后粘贴到`local.properties` 文件中的极光推送AppKey对应的地方 `JPUSH_APPKEY` 。

还是在极光应用管理界面点击左边的 `推送设置` 菜单，把你的应用ID填写进Android那栏： ![](http://img.muliba.net/post/20190107165445.png)

#### 蒲公英

如果需要使用应用内更新App的功能，就要使用蒲公英。蒲公英的官方网址：[https://www.pgyer.com](https://www.pgyer.com)

> 发布应用 -&gt; 上传打包好的apk文件（如何打包apk文件，请看本文下面一章内容） -&gt; 填写说明 -&gt; 发布 -&gt; 应用管理 -&gt; 应用概述 -&gt; App Key

把这个App Key的值拷贝到我们的项目的`local.properties`文件中的蒲公英配置对应的字段内：`PGY_APP_ID`

![](http://img.muliba.net/post/20190108101245.png)

![](http://img.muliba.net/post/20190108101302.png)

![](http://img.muliba.net/post/20190108101315.png)

![](http://img.muliba.net/post/20190108101330.png)

### 

### 直连版本配置

如果你不希望连接到我们O2云，通过修改配置编译打包，生成的Android应用，就会直接连接到你们自己的O2OA服务器。目前这个直连版本是不能接收到通知消息的。 修改方式如下： 在app目录下的build.gradle文件中，找到 android -&gt; buildTypes ，把`InnerServer` 改成 `true` 。这里应用有两个 一个debug下的 一个是release下的

```groovy
buildConfigField "Boolean", "InnerServer", "true"
```

![](http://img.muliba.net/post/20190107162547.png)

然后找到app-&gt;assets 目录下找到server.json文件，把里面的centerHost 、 centerPort、httpProtocol改成你们自己的O2OA中心服务器地址信息。

![](http://img.muliba.net/post/20190107162607.png)

### 

### 打包Android apk

打包还是通过Android Studio工具。上面提到的生成签名文件的时候一样，找到菜单 Build -&gt; Generate Signed Bundle or APK 。

![](http://img.muliba.net/post/20190107154817.png)

然后勾选APK ，下一步。 ![](http://img.muliba.net/post/20190107155010.png)

这次不用新建了因为刚才已经创建好签名文件了，选择你刚才生成的签名文件，输入密码，然后继续。 ![](http://img.muliba.net/post/20190107163404.png)

这里的签名版本V1和V2都勾选。点击 `Finish` 就开始打包了。 打包完成后，APK文件在 `./app/O2PLATFORM/release/O2PLATFORM-4.8.0.apk`

### app下载地址配置

我们O2OA平台登陆页扫码登录的二维码，有两个功能：

第一个是通过app扫码登录

第二个是如果手机还没有安装我们的app，通过其他app，如微信，扫码就会跳转到app的下载安装地址

![&#x767B;&#x5F55;&#x9875;](http://img.muliba.net/post/20190819134437.png)

![&#x767B;&#x5F55;&#x9875;2](http://img.muliba.net/post/20190819134447.png)

app的下载安装地址可以配置，打开o2server/config/collect.json ，如果没有这个文件就到o2server/configSample目录下复制一个过去。

```javascript

  {
  ...
  "appUrl": "http://www.pgyer.com/ZhiHe_android" ##app下载地址
  ...
 }
  

```



### 官方网站:

官方网站 : [http://www.o2oa.net](http://www.o2oa.net)

下载地址 : [http://www.o2oa.net](http://www.o2oa.net/download.html)

oschina项目主页 : [https://www.oschina.net/p/o2oa](https://www.oschina.net/p/o2oa)

