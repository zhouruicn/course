---
description: O2OA服务器提供了配置文件，支持自定义工作日、节假日、工作时间配置。
---

# 平台工作日节假日配置

## 一、工作日节假日配置文件 <a id="h1_1"></a>

文件路径：o2server/config

文件名：workTime.json

注意：如果o2server/config目录下没有该文件，请从o2server/configSample目录中COPY一份到o2server/config目录中，直接在configSample目录中修改将不会生效。

## 二、配置说明（平台默认使用的为以下配置） <a id="h1_2"></a>

![](../.gitbook/assets/image%20%28126%29.png)

其中holidays一般配置国家每年发布的法定节假日（如遇周末可以不用配置）

workday一般配置因法定节假日调休的周末日期。

## 三、业务使用案例 <a id="h1_2"></a>

业务需求：时效监督或催办提醒

首先打开任意一个流程图，然后配置此流程超时时间为3天，且勾选仅计算工作时间（见下图），那此流程待办的超时时间计算就会用到上面配置的工作时间和节假日时间。

![](../.gitbook/assets/image%20%287%29.png)

