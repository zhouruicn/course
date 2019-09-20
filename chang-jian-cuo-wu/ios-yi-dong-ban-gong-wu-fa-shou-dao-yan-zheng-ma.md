---
description: iphone7 with IOS10.2.1无法收到服务器绑定的验证码。
---

# IOS移动办公无法收到验证码

## 一、错误描述

错误！underlying\(ErrorDomain=NSURLErrorDomain Code=-1009 "似乎已断开与互联网的连接。" UserInfo={\_kCFStreamErrorCodeKey=50,NSUnderlyingError=0x281da75d0{Error Domain=kCFErrorDomain CFNetwork Code=-1009 "\(null\)" UserInfo=......

![&#x9519;&#x8BEF;&#x622A;&#x5C4F;](../.gitbook/assets/wei-xin-tu-pian-20190918154318.jpg)

## 二、原因分析

O2APP无法使用网络，无法连接到服务器。

## 三、解决方案

在应用权限 设置里允许 O2 APP使用数据网络，重新启动APP即可解决问题。

