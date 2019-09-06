# 普通初始化密码

普通人员默认密码修改

方法**一**：系统配置文件修改

配置文件路径：o2server/config/person.json 如果没有该文件，请从目录o2server/config/sample/中复制person.json文件到o2server/config目录下。

![](../../.gitbook/assets/image%20%28123%29.png)

从以上脚本信息，我们可以看到，修改password值即可完成对用户默认密码的设置。

**重启服务器，使配置生效即可。**

方法二：在系统控制面板中的系统设置

![](../../.gitbook/assets/image%20%28156%29.png)

点击“修改默认密码”，输入要修改的内容比如“（return “12345678”）”,再点击“确定”按钮

![](../../.gitbook/assets/image%20%287%29.png)

**重启服务器，使配置生效即可**

