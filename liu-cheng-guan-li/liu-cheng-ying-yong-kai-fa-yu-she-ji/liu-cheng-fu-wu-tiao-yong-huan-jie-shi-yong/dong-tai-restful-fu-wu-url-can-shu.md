---
description: >-
  http://{hostip}:{port}/service. 
  多数情况下，我们需要在实际运行过程中动态指定流程中需要调用的服务的地址以及其他的URL参数，那么URL的参数化也需要有一个方法来实现，本章主要讲述此功能
---

# 服务地址URL动态参数

很多情况下，服务的地址是通过脚本，或者其他服务在执行过程中计算得到的，所以在流程定义时无法直接在服务调用环节上写死配置。比如有一个服务的地址，开发环境和测试环境的地址是不一样的，如果环境切换，所有的服务调用所有的地址都需要修改，希望有一个地方可以统一进行配置修改。

实际上脚本可以完成复杂的过程实现，为了能简单明了地说明问题，这里，我们尝试把一个服务的主机IP和服务的端口写到脚本文件里。后续到脚本里进行获取。

## 1、使用脚本来记录参数

在流程应用中新建一个脚本，取名为serviceAddress（名字可任意取）。

![&#x65B0;&#x5EFA;&#x811A;&#x672C;](../../../.gitbook/assets/1%20%281%29.png)

添加脚本内容：

```javascript
this.address = {
"host": "dev.o2oa.net",
"port": "8000"
}
```

这里定义了一个address对象，用于存储服务的地址和端口，以备后续使用。

## 2、 在流程中添加一个“服务调用”活动

配置“调用”属性如下图：

![&#x5728;&#x670D;&#x52A1;&#x8C03;&#x7528;&#x73AF;&#x8282;&#x6DFB;&#x52A0;&#x53C2;&#x6570;&#x811A;&#x672C;](../../../.gitbook/assets/2%20%286%29.png)

配置REST地址为：[http://{host}:{port}/service](http://{host}:{port}/service); 

将服务地址中的IP地址或域名用{host}参数代替，端口用{port}代替。 

在参数脚本中选择第一步中创建的serviceAddress脚本。 

在代码框中输入代码： 

```javascript
this.parameters.put("host", this.address.host); 
this.parameters.put("port", this.address.port); 
```

将host和port设置为脚本中配置的值。

## 3、 运行流程到服务调用可正常访问服务。

在开发环境、测试环境和生产环境切换时，只需修改serviceAddress脚本中的json数据即可。





















