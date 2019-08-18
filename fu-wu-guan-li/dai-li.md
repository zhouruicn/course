# 代理

代理是运行在服务器端的定时任务，使用Javascript编写，可以直接调用Java类。

## 入口

点系统的左上角导航-&gt;设计中心-&gt;服务管理-&gt;代理打开。

![](../.gitbook/assets/qq-tu-pian-20190818120532.png)

## 触发时间

点击“定时任务corn表达式”可选择corn表达式进行触发时间的配置。corn表达式详解[点击这里](http://www.o2oa.net/x_component_Template/widget/$CronPicker/cron_express_description.html)。

## 调用服务

### 调用O2OA后台服务

服务查看和调试

打开 [http://centerserver:20030/x\_program\_center/jest/list.htm](http://dev.o2oa.net:20030/x_program_center/jest/list.html)l

**本小节中的“服务根”如下**：

| x\_processplatform\_assemble\_surface | 流程平台相关服务 |
| :--- | :--- |
| x\_portal\_assemble\_surface | 门户平台相关服务 |
| x\_cms\_assemble\_control | 内容管理平台相关服务 |
| x\_query\_assemble\_surface | 数据平台相关服务 |
| x\_organization\_assemble\_express | 组织架构相关服务 |
| x\_file\_assemble\_control | 云文件相关服务 |
| x\_meeting\_assemble\_control | 会议管理相关服务 |
| x\_bbs\_assemble\_control | 论坛相关服务 |
| x\_calendar\_assemble\_control | 日程管理相关服务 |
| x\_hotpic\_assemble\_control | 热点信息相关服务 |
| x\_mind\_assemble\_control | 脑图模块相关服务 |
| x\_organization\_assemble\_personal | 个人设置相关服务 |
| x\_attendance\_assemble\_control | 考勤模块相关服务 |

**本小节中的“路径”**，可以在服务详情中找到，如下图：

![](../.gitbook/assets/qq-tu-pian-20190818123643.png)

以上图的服务为例，最后拼接成下列两种路径均可使用

/jaxrs/work/workorworkcompleted/dcd8e168-2da0-4496-83ee-137dc976c7f6

或

work/workorworkcompleted/dcd8e168-2da0-4496-83ee-137dc976c7f6

#### GET方法

```text
var applications = resources.getContext().applications();
applications.getQuery('x_processplatform_assemble_surface', "data/workcompleted/"+workCompletedId+"/publishFlag", "true" );
```



