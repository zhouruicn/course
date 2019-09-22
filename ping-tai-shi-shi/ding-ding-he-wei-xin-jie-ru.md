---
description: O2OA平台可以以第自建应用的方式集成到阿里钉钉，同步钉钉的企业通讯录作为本地组织人员架构，并且可以将待办等通知直接推送到钉钉进行消息提醒。
---

# 集成到阿里钉钉\(DingTalk\)

{% hint style="info" %}
**如果O2OA成功接入钉钉，O2OA将会自动从钉钉拉取所有的人员和组织进行同步，O2OA的所有人员和组织以企业钉钉中创建的组织架构为准（ 本地已经创建的人员和组织将保留不会被删除，可能会造成人员和组织重复 ）。**

**对企业通讯录授权时，所对应的组织请设置为顶层组织，后续将会细化相应的权限设置。**
{% endhint %}

> **O2OA接入钉钉建议先配置好钉钉应用，待组织和人员从钉钉同步完成后，再进行组织和人员的信息编辑，避免人员和组织信息的重复创建。**

## **一、**注册企业钉钉（自行准备）

注册地址：https://oa.dingtalk.com/\#/login

![&#x4F01;&#x4E1A;&#x6CE8;&#x518C;&#x9489;&#x9489;](../.gitbook/assets/5e08cfe7002c494242ca215bcfdc42e1065.jpg)

需要提供使用钉钉的企业相关信息。

![](https://oscimg.oschina.net/oscnet/87b0bfd3a69c03f11bb003719e49c6f5d43.jpg)

## 获取企业CropId和CorpSecret

注册成功后，使用管理员账号登录企业钉钉，在\[工作台\] 页面中，点击**自建应用**上方**应用开发**链接，在这里可以查看企业的CropId和SSOsectet信息，如下图所示：

![](https://oscimg.oschina.net/oscnet/24bd68c770c6bb0beefa17b7b9ed2b7d81b.jpg)

点击**应用开发**进入开发平台，如下图所示：

![](https://oscimg.oschina.net/oscnet/abcb197af3a47d30b339abb01f2bfc8da3a.jpg)

请记录企业的CropId和CropSectet信息。

## 添加企业钉钉自建应用（O2OA）

注册成功后，使用管理员账号登录企业钉钉，在\[工作台\] 页面中，点击**自建应用**，如下图所示：

![](https://oscimg.oschina.net/oscnet/325870b2cea0dea214a8935911a69419f13.jpg)

在弹出的新增微应用界面填写O2OA服务器相关信息，如下图所示：

![](https://oscimg.oschina.net/oscnet/ebfbeb2e9fc72629dd62e276f9b1119845d.jpg)

必填项：

```text
应用Logo：您可以上传您需要显示在钉钉里的O2OA办公应用图标。

应用名称：填写您指定的钉钉里O2OA办公应用的应用名称，如移动办公，企业办公，O2OA办公等等。

功能介绍：填写应用的功能介绍

首页地址：http://[serverIp]:[port]/x_desktop/ddsso.html

(其中[serverIp]为您部署的O2OA公网IP或者域名，[port]是开放的web端口，默认为80不用填写)
```

填写完成后点击提交即可完成应用创建，填写好的界面如下图所示：

![](https://oscimg.oschina.net/oscnet/ed82f9fef29608ea403efdfb3916a2cd102.jpg)

查看应用信息：

![](https://oscimg.oschina.net/oscnet/10e19ee2fa96d7d339211761e1782ce8383.jpg)

您可以在界面中获取AgentId信息，这两个信息以及之前获取的CropId和SSOsecret信息将配置到O2OA相关的接入配置中，请牢记此信息。

## 在O2OA中进行相关接入配置

1、进入o2oa安装目录，从o2server/config/sample 目录下拷贝 dingding.json 到 o2server/config 目录（如果已经复制过了，请跳过此步骤）；

2、使用文本编辑器打开dingding.json进行编辑：

```text
{
  "enable": false,
  "corpId": "",
  "agentId": "",
  "corpSecret": "",
  "syncCron": "10 0/10 * * * ?",
  "forceSyncCron": "10 45 8,12 * * ?",
  "oapiAddress": "https://oapi.dingtalk.com",
  "messageEnable": true,
}
```

参数说明：

  "**enable**": "是否启用企业钉钉接入: true \| false",  

  "**corpId**": "企业钉钉参数corpId（从企业钉钉开发平台信息中获取）",

  "**agentId**": "企业钉钉应用信息AgentId（从企业钉钉信息中获取 'AgentId'）",

  "**corpSecret**": "企业钉钉参数SSOsecret（从企业钉钉开放平台信息中获取 'SSOsecret'）",

  "**syncCron**": "拉入同步时间表达式, 默认每10分钟同步一次\(10 0/10 \* \* \* ?\).",

  "**forceSyncCron**": "强制拉入同步cron, 默认在每天的8点和12点强制进行同步\(10 45 8,12 \* \* ?\)",

  "**oapiAddress**": "企业钉钉api服务器地址, 固定填写：https://oapi.dingtalk.com",

  "**messageEnable**": "是否允许推送消息到企业钉钉: true \| false"

完成以上配置后重启O2OA，即可完成O2OA在企业钉钉中的接入，可以在企业钉钉中看到自己配置的企业应用。

![](https://oscimg.oschina.net/oscnet/f99efbb29e6aeb6b38b8043b5479194d03b.jpg)

