---
description: O2OA支持对单个组件进行负载均衡设置，可以将某一个使用量比较大，负载压力比较大的组件，分布到多个主机上提供服务。
---

# 非对称集群配置

## 一、修改集群应用配置

配置文件路径：o2server/config/node\_127.0.0.1.json\(集群模式下应该以域名或者实际IP为名，而非127.0.0.1\)。如果没有该文件，请从目录o2server/configSample/中复制node\_127.0.0.1.json文件到o2server/config目录下。

{% hint style="info" %}
直接修改configSample目录下的配置文件，修改将不会生效。

在集群模式下，应该不是node\_127.0.0.1.json，修改与对应主机IP或者域名一致的配置文件，并且COPY到各台服务器。
{% endhint %}

文件内容如下：

```text
{
  "enable": true,
  "isPrimaryCenter": true,
  "application": {
    "enable": true,
    "port": 20020.0,
    "sslEnable": false,
    "proxyHost": "",
    "proxyPort": 20020.0,
    "redeploy": true,
    "scanInterval": 0.0,
    "includes": [x_file_assemble_control],    #这里填入需要启动的服务
    "excludes": [],                           #这里填写不需要启动（排除）的服务
    "weights": [],
    "###includes": "承载的应用,在集群环境下可以选择仅承载部分应用以降低服务器负载,可以使用*作为通配符.###",
    "###excludes": "选择不承载的应用,和includes的值配合使用可以选择或者排除承载的应用,可以使用*作为通配符.###",
    "###weights": "设置应用的权重,在集群环境中,一个应用可以部署多个实例提供负载均衡.通过合计占比来分配应用占比.###"
  },
  ......
}

```

其中application为应用服务器配置，在配置中的includes和excludes可以对该应用服务器包含的应用或者排除的应用进行编辑，以实现非对称集群配置

## 二、应用列表说明

| **应用名称** | **说明** |
| :--- | :--- |
| x\_attendance\_assemble\_control | 考勤管理 |
| x\_bbs\_assemble\_control | 企业社区 |
| x\_calendar\_assemble\_control | 日程管理 |
| x\_cms\_assemble\_control | 内容管理，信息管理 |
| x\_collaboration\_assemble\_websocket | websocket消息服务 |
| x\_collaboration\_service\_message | 消息服务 |
| x\_component\_assemble\_control | 组件服务 |
| x\_file\_assemble\_control | 云文件，文件存储 |
| x\_general\_assemble\_control | 通用服务：省市县数据 |
| x\_hotpic\_assemble\_control | 热点新闻服务：推送显示在移动APP首页 |
| x\_meeting\_assemble\_control | 会议管理 |
| x\_message\_assemble\_communicate | 消息管理 |
| x\_mind\_assemble\_control | 脑图工具 |
| x\_okr\_assemble\_control | 执行力管理 |
| x\_organization\_assemble\_authentication | 组织管理 |
| x\_organization\_assemble\_control | 组织管理 |
| x\_organization\_assemble\_express | 组织管理 |
| x\_organization\_assemble\_personal | 组织管理 |
| x\_portal\_assemble\_designer | 门户管理 |
| x\_portal\_assemble\_surface | 门户管理 |
| x\_processplatform\_assemble\_bam | 流程管理 |
| x\_processplatform\_assemble\_designer | 流程管理 |
| x\_processplatform\_assemble\_surface | 流程管理 |
| x\_processplatform\_service\_processing | 流程管理 |
| x\_program\_center | 中心服务器 |
| x\_query\_assemble\_designer | 数据中心 |
| x\_query\_assemble\_surface | 数据中心 |
| x\_query\_service\_processing | 数据中心 |

