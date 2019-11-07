---
description: >-
  在很多时间，调用第三方系统服务的时候，需要指定的HTTPHEADER，需要带一些认证标识，或者其他第三方指定的信息，此时需要在发送请求时对httpHeader进行编辑，此篇上要讲述该功能
---

# 自定义HTTP头信息

在流程服务调用活动的调用属性中，可找到“消息头脚本“，在代码框中使用：

```javascript
this.headers.put(“name”, “value”);
```

或者一次添加多个HttpHeader：

```javascript
this.headers.put({
    "name1": "value1",
    "name2": "value2"
});
```

如下图所示：

![&#x5728;&#x670D;&#x52A1;&#x5C5E;&#x6027;&#x4E2D;&#x7F16;&#x8F91;&#x6D88;&#x606F;&#x5934;](../../../.gitbook/assets/3%20%2810%29.png)

当然也可以创建一个脚本，在脚本中写好设置消息头代码，在此处引用。

![&#x70B9;&#x51FB;&#x53F3;&#x4FA7;&#x52A0;&#x53F7;&#x53EF;&#x4EE5;&#x5F15;&#x5165;&#x811A;&#x672C;](../../../.gitbook/assets/4%20%285%29.png)



