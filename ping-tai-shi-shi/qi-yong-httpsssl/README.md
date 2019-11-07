---
description: O2OA支持以SSL方式连接WEB服务器，应用服务器以及中心服务器，以获得更高的网络安全性。
---

# 启用HTTPS（SSL）

##  **一、WEB和应用服务器配置**

1、文件位置：o2server/config/node\_127.0.0.1.json, 如果目录里没有该文件，可以从o2server/configSample目录里COPY一个到config目录下。

{% hint style="info" %}
**直接修改o2server/configSample下的node\_127.0.0.1.json配置将不会生效。**
{% endhint %}

如下图所示：

![&#x590D;&#x5236;&#x914D;&#x7F6E;&#x6587;&#x4EF6;](../../.gitbook/assets/892f3bd53ede2a1acddb7dd98db885988a6.jpg%20%281%29.webp)

2、修改node\_127.0.0.1.json内容：

```text
{  "enable": true,  "isPrimaryCenter": true,  "application": {    "enable": true,    "port": 20020.0,    "sslEnable": true,         #启用SSL    "proxyHost": "",    "proxyPort": 20020.0,    "redeploy": true,    "scanInterval": 0.0,    "includes": [],    "excludes": [],    "weights": []  },  "web": {    "enable": true,    "sslEnable": true,         #启用SSL    "port": 443,               #修改端口为443    "weight": 100.0  },  "data": {    "enable": true,    "tcpPort": 20050.0,    "webPort": 20051.0,    "includes": [],    "excludes": [],    "jmxEnable": false,    "cacheSize": 512.0  },  "storage": {    "enable": true,    "port": 20040.0,    "sslEnable": false,    "name": "251",    "accounts": []  },  "logLevel": "warn",  "dumpData": {    "cron": "",    "size": 14.0,    "###cron": "定时任务cron表达式###",    "###size": "最大保留分数,超过将自动删除最久的数据.###"  },  "dumpStorage": {    "cron": "",    "size": 14.0,    "###cron": "定时任务cron表达式###",    "###size": "最大保留分数,超过将自动删除最久的数据.###"  },  "restoreData": {    "cron": "",    "date": "",    "###cron": "定时任务cron表达式###",    "###date": "导入数据时间戳,需要在local/dump下有此时间戳的文件.###"  },  "restoreStorage": {    "cron": "",    "date": "",    "###cron": "定时任务cron表达式###",    "###date": "导入数据时间戳,需要在local/dump下有此时间戳的文件.###"  }, ......}
```

将配置文件中的web和application对象中的sslEnable设置为true, web服务器的端口设定为443。

## **二、中心服务器配置**

1、文件位置：o2server/config/centerServer.json, 如果目录里没有该文件，可以从o2server/configSample目录里COPY一个到config目录下。

如下图所示：

![&#x590D;&#x5236;centerServer.json](../../.gitbook/assets/742c0939a5fff8a82813ad8c58b25f7a2f7.jpg.webp)

2、修改centerServer.json内容：

```text
{  "sslEnable": true,       #启动SSL  "redeploy": true,  "port": 20030.0,  "httpProtocol": "",  "proxyHost": "",  "proxyPort": 20030.0,  "scanInterval": 0.0,  "###enable": "是否启用###",  "###sslEnable": "是否启用ssl传输加密,如果启用将使用config/keystore文件作为密钥文件.使用config/token.json文件中的sslKeyStorePassword字段为密钥密码,sslKeyManagerPassword为管理密码.###",  "###redeploy": "每次启动是否重新部署所有应用.###",  "###port": "端口,center服务器端口,默认20030###",  "###httpProtocol": "对外http访问协议,http/https###",  "###proxyHost": "代理主机,当服务器是通过apache/eginx等代理服务器映射到公网或者通过路由器做端口映射,在这样的情况下需要设置此地址以标明公网访问地址.###",  "###proxyPort": "代理端口,当服务器是通过apache/eginx等代理服务器映射到公网或者通过路由器做端口映射,在这样的情况下需要设置此地址以标明公网访问端口.###",  "###scanInterval": "重新扫描war包时间间隔(秒)###",  "###config": "其他参数###"}
```

将配置文件中的sslEnable设置为true。

## **三、网站域名证书申请**

百度云目前有免费的SSL域名证书申请：https://cloud.baidu.com/product/ssl.html

![](../../.gitbook/assets/screen-shot-2019-02-27-at-10.27.52.png.webp)

 点击**立即购买**，进入购买页面，点击\`**下一步**\`完成购买。

![](../../.gitbook/assets/screen-shot-2019-02-27-at-10.28.36.png.webp)

完成购买后会在已购证书列表中找到买好的证书，然后点击证书申请。

![](../../.gitbook/assets/screen-shot-2019-02-27-at-10.41.55.png.webp)

进入一个申请证书的表单页面，这个表单页面主要是填写域名

{% hint style="info" %}
#### **这里填写的域名一定要和O2OA使用的域名一直，不然证书还是无效的，比如：O2OA服务器域名是oa.xxx.com，不能只填写xxx.com，把你要用https的域名填入进去。**
{% endhint %}

 还有下面的公司信息尽量和域名申请的时候的信息一直，加大申请的成功率。

![](../../.gitbook/assets/screen-shot-2019-02-27-at-10.42.44.png.webp)

完成这个表单后，需要验证你的域名，还是到已购证书列表， 点击后面的查看申请，就会看到DNS验证的方式。

![](../../.gitbook/assets/screen-shot-2019-02-27-at-11.04.50.png.webp)

DNS验证：它会让你去DNS服务商那边配置一个TXT的域名解析，按照它给你的这个名称和设置值到DNS服务商那边配置好。

![](../../.gitbook/assets/screen-shot-2019-02-27-at-10.54.08.png.webp)

DNS那边配置好后就耐心等待，几分钟后等验证通过。

![](../../.gitbook/assets/screen-shot-2019-02-28-at-14.11.39.png.webp)

申请成功后点击查看证书，进入证书详情页面可以下载证书。

![](../../.gitbook/assets/screen-shot-2019-02-28-at-14.12.19.png.webp)

{% hint style="info" %}
#### **下载证书的时候选择倒数第二个jks，还有那个解压密码一定要记住，后面配置文件需要用到。**
{% endhint %}

下载下来的证书名称一般是这样的：\`**SHA256withRSA\_域名.jks**\`  
把这个文件复制到O2OA服务端目录下的config文件夹内，并且改名成\`keystore\` ，没有后缀的。  
还有这个config文件夹内有一个叫token.json的文件，如果没有到configSample目录下复制一个过来，把里面的两个ssl的密码修改成你刚才下载证书时候的解压密码。

##  **四、修改token.json配置**

文件位置：o2server/config/token.json, 如果目录里没有该文件，可以从o2server/configSample目录里COPY一个到config目录下。

```text
 "sslKeyStorePassword": "1234", "sslKeyManagerPassword": "1234",
```

{% hint style="info" %}
#### 这里的1234，就是下载证书时候的解压密码
{% endhint %}

## **五、重启服务器。**

## **六、以HTTPS形式访问系统**

        https://127.0.0.1

