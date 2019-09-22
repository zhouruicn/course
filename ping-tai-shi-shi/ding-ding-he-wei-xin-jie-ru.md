---
description: O2OA平台可以以第微应用的方式集成到阿里钉钉，同步钉钉的企业通讯录作为本地组织人员架构，并且可以将待办等通知直接推送到钉钉进行消息提醒。
---

# 集成到阿里钉钉\(DingTalk\)

{% hint style="info" %}
**如果O2OA成功接入钉钉，O2OA将会自动从钉钉拉取所有的人员和组织进行同步，O2OA的所有人员和组织以企业钉钉中创建的组织架构为准（ 本地已经创建的人员和组织将保留不会被删除，可能会造成人员和组织重复 ）。**

**对企业通讯录授权时，所对应的组织请设置为顶层组织，后续将会细化相应的权限设置。**
{% endhint %}

> **O2OA接入钉钉建议先配置好钉钉应用，待组织和人员从钉钉同步完成后，再进行组织和人员的信息编辑，避免人员和组织信息的重复创建。**

## 一、前提条件

1、完成O2OA部署，平台可以正常访问

2、确保O2OA平台可以正常通过公网进行访问（不是内网）

## **二、**注册企业钉钉

注册地址：https://oa.dingtalk.com/\#/login，此步骤需要企业自行准备。

![&#x4F01;&#x4E1A;&#x6CE8;&#x518C;&#x9489;&#x9489;](../.gitbook/assets/5e08cfe7002c494242ca215bcfdc42e1065.jpg)

需要提供使用钉钉的企业相关信息。

![&#x4F01;&#x4E1A;&#x9996;&#x9875;](../.gitbook/assets/5ec1aa20b34173f743e65f1e81bf2048939.jpg)

## 三、添加钉钉微应用

钉钉注册成功后，使用企业管理员账号登录企业钉钉，在\[工作台\] 页面中，点击**自建应用**链接，新建一个企业应用，如下图所示：

![&#x4F01;&#x4E1A;&#x63A7;&#x5236;&#x53F0;&#x5DE5;&#x4F5C;&#x53F0;](../.gitbook/assets/0bcb3d6c87b4d20f3b52fda5b46b52e1a70.jpg)

填写应用基本信息，如下图所示：

![&#x521B;&#x5EFA;&#x81EA;&#x5EFA;&#x5E94;&#x7528;](../.gitbook/assets/0fde74eb66ff0284472db72a0f407b81f60.jpg)

参数说明：

```text
应用Logo：您可以上传您需要显示在钉钉里的O2OA办公应用图标。
应用名称：填写您指定的钉钉里O2OA办公应用的应用名称，如移动办公，企业办公，O2OA办公等等。
功能介绍：填写应用的功能介绍
开发方式：企业内部自主开发
```

填写完成后点击下一步，填写配置开发信息，如下图所示：

![&#x914D;&#x7F6E;&#x5E94;&#x7528;&#x8BE6;&#x7EC6;&#x4FE1;&#x606F;](../.gitbook/assets/5cdb4bafec322214e736ed2c06b3b8336bb.jpg)

参数说明：

```text
开发模式       ：开发应用
开发应用类型    ：微应用
应用首页链接    ：http://[serverIp]:[port]/x_desktop/ddsso.html
(其中[serverIp]为您部署的O2OA公网IP或者域名，[port]是开放的web端口，默认为80不用填写)
开服务器出口IP  ：填写服务器公网出口IP地址
首页地址       ：http://[serverIp]:[port]/x_desktop/ddsso.html
可使用范围      ：根据要求填写
```

填写完成后点击提交即可完成应用创建，填写好的界面如下图所示：

![&#x81EA;&#x5EFA;&#x5E94;&#x7528;&#x521B;&#x5EFA;&#x5B8C;&#x6210;](../.gitbook/assets/1ec156f6f554f24eb6814a748e2b00924b3.jpg)

## 四、查询应用的AgentId、appKey、appSecret和CorpId信息 <a id="h1_8"></a>

### 1、查询应用的AgentId、appKey、appSecret信息

点击自建应用设置，查看应用的详细设置信息

![&#x67E5;&#x8BE2;&#x5E94;&#x7528;&#x8BBE;&#x7F6E;](../.gitbook/assets/6484c20a92e8f34891dc57d57ea8a86243c.jpg)

查询已经创建好的应用设置信息，如下图所示：

![](../.gitbook/assets/cc0aaf6644cb5601b6bcb0584bbd06d0720.jpg)

{% hint style="info" %}
 请记录应用的**AgentId、AppKey以及AppSecret**信息，后续需要配置到服务器设置里
{% endhint %}

### 2、查询企业CropId信息

进入钉钉开放平台，点击左侧导航：开发信息 -&gt; 开发账号信息：

![&#x67E5;&#x8BE2;CropId](../.gitbook/assets/1760272839045c8bbfef42d61f8810f89dc.jpg)

{% hint style="info" %}
 请记录企业的**CorpId**信息，后续需要配置到服务器设置里。
{% endhint %}

## 五、设置钉钉微应用的通讯录权限 <a id="h1_9"></a>

在已经创建好的微应用的权限设置栏可以对应用的操作权限进行设置，如下图所示：

![&#x8BBE;&#x7F6E;&#x901A;&#x8BAF;&#x5F55;&#x6743;&#x9650;](../.gitbook/assets/de90b8301614394041386d47149ed147e42.jpg)

{% hint style="info" %}
企业通讯录权限：请开启通讯录只读权限、手机号码信息以及邮箱等个人信息，并且将选择授权范围**设置为最顶层组织。**
{% endhint %}

至此，钉钉应用创建以及设置工作已经完成。

## 六、O2OA接入配置 <a id="h1_10"></a>

1、进入o2oa安装目录，从o2server/configSample 目录下拷贝 dingding.json 到 o2server/config 目录（如果已经复制过了，请跳过此步骤）；

2、使用文本编辑器打开dingding.json进行编辑：

```text
{
  "enable": true,
  "corpId": "",
  "agentId": "",
  "appKey": "",
  "appSecret": "",
  "syncCron": "10 0/10 * * * ?",
  "forceSyncCron": "10 45 8,12 * * ?",
  "oapiAddress": "https://oapi.dingtalk.com",
  "messageEnable": true,
  "###enable": "是否启用###",
  "###corpId": "钉钉corpId###",
  "###agentId": "agentId###",
  "###appKey": "应用的key,唯一标识###",
  "###appSecret": "应用的密钥###",
  "###syncCron": "组织同步cron,默认每10分钟同步一次.###",
  "###forceSyncCron": "强制拉入同步cron,默认在每天的8点和12点强制进行同步.###",
  "###oapiAddress": "oapi服务器地址###",
  "###messageEnable": "是否启用消息推送###"
}
```

参数说明：

```text
"enable": "是否启用企业钉钉接入: true | false",  
"agentId": "企业钉钉应用信息AgentId（从企业钉钉信息中获取 'AgentId'）",
"appKey": "企业钉钉参数SSOsecret（从企业钉钉开放平台信息中获取 'AppKey'）",
"appSecret": "企业钉钉参数SSOsecret（从企业钉钉开放平台信息中获取 'AppSecret'）",
"syncCron": "拉入同步时间表达式, 默认每10分钟同步一次(10 0/10 * * * ?).",
"forceSyncCron": "强制拉入同步cron, 默认在每天的8点和12点强制进行同步(10 45 8,12 * * ?)",
"oapiAddress": "企业钉钉api服务器地址, 固定填写：https://oapi.dingtalk.com",
"messageEnable": "是否允许推送消息到企业钉钉: true | false"
```

![&#x9489;&#x9489;&#x4E0A;&#x7684;&#x667A;&#x548C;&#x529E;&#x516C;&#x5E73;&#x53F0;](../.gitbook/assets/f99efbb29e6aeb6b38b8043b5479194d03b.jpg)

完成以上配置后重启O2OA，即可完成O2OA在企业钉钉中的接入，可以在企业钉钉中看到自己配置的企业应用。

## 七、手工从钉钉拉取组织人员数据 <a id="h1_11"></a>

服务地址：http://**localhost**:20030/x\_program\_center/jest/index.html

服务名称：**DingdingAction**.pullSync

如下图所示界面，点击GET之后，观察服务器控制台或者日志文件信息（o2server/logs），可以查看到同步日志。

{% hint style="info" %}
**请注意，不要多次点击GET，**点击一次后，控制台会有正在拉取组织人员信息相关的日志。
{% endhint %}

![&#x4E2D;&#x5FC3;&#x670D;&#x52A1;&#x5668;API](../.gitbook/assets/qq-jie-tu-20190922144246.png)



