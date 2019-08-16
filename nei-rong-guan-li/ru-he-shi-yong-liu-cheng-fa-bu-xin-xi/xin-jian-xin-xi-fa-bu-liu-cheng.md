# 新建信息发布流程

![](../../.gitbook/assets/image%20%282%29.png)

在流程最后增加一个服务调用节点，该节点作用是把流程数据传入到信息发布的通知公告中。如图配置相应的参数 REST地址：document/cipher/publish/content 配置消息体脚本：引用publishToCMS脚本，并设置消息体内容。

![](../../.gitbook/assets/image%20%286%29.png)

在脚本配置中新建publishToCMS脚本，代码见

![](../../.gitbook/assets/image%20%284%29.png)

示例表单如下：

![](../../.gitbook/assets/image%20%288%29.png)

