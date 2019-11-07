# 流程实例 - Object: workContext

你可以通过workContext获取和流程相关的流程实例对象数据。

## 获取workContext对象

您可以在表单或流程的各个嵌入脚本中，通过this来获取当前流程实例数据，如下：

### Syntax:

```javascript
var context = this.workContext;
```

## 流程实例相关操作

### getTask

获取当前流程与当前用户相关的**待办对象**：task对象。 

当前流程实例正在流转中，并且当前用户有待办，则返回当前用户的待办对象，否则返回null。

#### Syntax:

```javascript
var task = this.workContext.getTask();
```

#### Return:

```text
> task :　（Object）当前用户的待办任务对象：task。
> null :　（null）当前用户没有对此流程实例的待办时，或流程实例已经流转结束，返回null。
```

task对象为JSON格式数据，其格式和主要数据如下：

{% tabs %}
{% tab title="task对象" %}
```javascript
{
    "id": "dd476045-7c79-44f7-9dba-f51d322de40f",   //待办ID
    "title": "XX7月北京出差报销审批",               //流程实例标题
    "startTime": "2018-09-27 22:49:22",             //待办到达时间
    "startTimeMonth": "2018-09",                    //待办到达的月份
    "work": "854e2c22-718e-48bb-98db-96f4b43e7ee8", //流程实例ID
    "application": "1dc23336-6be6-402b-bed6-36e707a1dd17",  //流程应用ID
    "applicationName": "财务管理",                          //流程应用名称
    "applicationAlias": "finance",                          //流程应用别名
    "process": "2207db11-dddf-4ebd-864d-3819f3e173c6",      //流程ID
    "processName": "报销审批流程",                          //流程名称
    "processAlias": "",                                     //流程别名
    "serial": "",                                           //流程编号
    "person": "XXX@huqi@P",                             //待办人名称
    "identity": "XX@481c9edc-5fb5-41f1-b5c2-6ea609082cdb@I",    //待办人身份
    "unit": "XX@c448d8bb-98b8-4305-9d3f-12537723cfcc@U",        //待办人所在组织
    "activity": "13d15daf-2ac5-4c1b-a669-1607a0e5ed15",         //当前活动的ID
    "activityName": "部门领导审核",                             //当前活动的名称
    "activityAlias": "",                                        //当前活动的别名
    "activityDescription": "",                                  //当前活动描述
    "activityType": "manual",                                   //当前活动类型
    "creatorPerson": "XX@huqi@P",                               //流程实例创建人
    "creatorIdentity": "XX@481c9edc-5fb5-41f1-b5c2-6ea609082cdb@I", //流程实例创建人的身份
    "creatorUnit": "XX@c448d8bb-98b8-4305-9d3f-12537723cfcc@U", //流程实例创建人所在组织
    "expired": false,                                           //是否已超时
    "urged": false,                                             //是否进行催办
    "routeList": [                                              //可选的路由ID
        "89b58fe0-6dcb-4fe7-8c2e-3f77204df6d4",
        "f3105b7a-2929-4682-aab8-15fef5ea0f23"
    ],
    "routeNameList": [                                          //可选的路由名称
        "退回申请人",
        "送财务部门复审"
    ],
    "routeOpinionList": [                                       //可选路由的默认意见
        "",
        ""
    ]
}
```
{% endtab %}
{% endtabs %}

### getWork

获取当前流程实例对象：work对象或workCompleted对象。

#### Syntax:

```javascript
var work = this.workContext.getWork();
```

#### Return:

```javascript
> work :　（Object）流程实例对象。
> workCompleted :　（Object）如果流程已结束，返回已结束的流程实例对象：workCompleted。
```

work对象或workCompleted对象为JSON格式数据，其格式和主要数据如下：

{% tabs %}
{% tab title="work对象" %}
```javascript
var work = {
    "id": "854e2c22-718e-48bb-98db-96f4b43e7ee8",   //流程实例ID
    "splitValue": "xxxxxxxxxxxxxx", //流程拆分后的拆分依据
    "title": "xx7月北京出差报销审批",               //流程实例名称
    "startTime": "2018-09-07 14:03:22",             //流程启动时间
    "startTimeMonth": "2018-09",                    //流程启动的月份
    "creatorPerson": "xx@huqi@P",                   //流程实例创建人
    "creatorIdentity": "xx@481c9edc-5fb5-41f1-b5c2-6ea609082cdb@I", //流程实例创建人身份
    "creatorUnit": "xx@c448d8bb-98b8-4305-9d3f-12537723cfcc@U",     //流程实例创建人所在组织
    "creatorUnitLevelName": "浙江兰德纵横/开发部",          //流程实例创建人所在组织层次
    "application": "1dc23336-6be6-402b-bed6-36e707a1dd17",  //流程应用ID
    "applicationName": "财务管理",                          //流程应用名称
    "applicationAlias": "finance",                          //流程应用别名
    "process": "2207db11-dddf-4ebd-864d-3819f3e173c6",      //流程ID
    "processName": "报销审批流程",                          //流程名称
    "processAlias": "",                                     //流程别名
    "activity": "13d15daf-2ac5-4c1b-a669-1607a0e5ed15",     //当前活动ID
    "activityType": "manual",                               //当前活动类型
    "activityName": "部门领导审核",                         //当前活动名称
    "activityAlias": "",                                    //当前活动别名
    "activityDescription": "",                              //当前活动描述
    "activityArrivedTime": "2018-09-27 22:49:21",           //当前活动到达时间
    "serial": "",                                           //编号
    "workStatus": "processing",                             //流程实例状态
    "errorRetry": 0,                                        //流转失败重试次数
    "splitting": false,                                     //流程是否拆分
    "form": "db3b2766-93a1-4058-b522-0edb922bd84f"          //流程展现所使用的表单
}
```
{% endtab %}
{% endtabs %}

{% tabs %}
{% tab title="workCompleted对象" %}
```javascript
var workCompleted = {
    "id": "be0195f1-f2e2-4eac-911c-99897a43ff8f",   //流程实例ID
    "title": "xx7月北京出差报销审批",               //流程实例名称
    "startTime": "2018-09-19 16:14:16",             //流程启动时间
    "startTimeMonth": "2018-09",                    //流程启动的月份
    "completedTime": "2018-09-19 16:15:28",         //流程完成时间
    "completedTimeMonth": "2018-09",                //流程完成的月份
    "creatorPerson": "xx@huqi@P",                   //流程实例创建人
    "creatorIdentity": "xx@481c9edc-5fb5-41f1-b5c2-6ea609082cdb@I", //流程实例创建人身份
    "creatorUnit": "xx@c448d8bb-98b8-4305-9d3f-12537723cfcc@U",     //流程实例创建人所在组织
    "creatorUnitLevelName": "浙江兰德纵横/开发部",  //流程实例创建人所在组织层次
    "application": "1dc23336-6be6-402b-bed6-36e707a1dd17",  //流程应用ID
    "applicationName": "财务管理",                          //流程应用名称
    "applicationAlias": "finance",                          //流程应用别名
    "process": "2207db11-dddf-4ebd-864d-3819f3e173c6",      //流程ID
    "processName": "报销审批流程",                          //流程名称
    "processAlias": "",                                     //流程别名
    "serial": "",                                           //编号
    "form": "320be1ca-ee49-478f-a751-f65ab67cf818",         //流程展现所使用的表单
}
```
{% endtab %}
{% endtabs %}

### getActivity

获取当前流程实例所在的**活动节点对象**：activity对象。

#### Syntax:

```javascript
var activity = this.workContext.getActivity();
```

#### Return:

```javascript
> activity :　（Object）当前流程实例所在的活动节点对象：activity。
> null :　（null）如果当前流程实例已流转完成，则返回null。
```

### getTaskList

获取当前流程实例的**所有待办对象**。如果流程实例已流转完成，则返回一个空数组。

#### Syntax:

```javascript
var taskList = this.workContext.getTaskList();
```

#### Return:

```javascript
> array of task :　（array）当前流程实例的所有待办。
```

### getReadList

获取当前流程实例的所有待阅对象。如果流程实例无待阅，则返回一个空数组。

#### Syntax:

```javascript
var taskList = this.workContext.getReadList();
```

#### Return:

```javascript
> array of read :　（array）当前流程实例的所有待阅。
```

每个read对象为JSON格式数据，其格式和主要数据如下：

{% tabs %}
{% tab title="read对象" %}
```javascript
{
    "id": "dd476045-7c79-44f7-9dba-f51d322de40f",   //待阅ID
    "title": "XX7月北京出差报销审批",               //流程实例标题
    "startTime": "2018-09-27 22:49:22",             //待阅产生时间
    "startTimeMonth": "2018-09",                    //待阅产生的月份
    "work": "854e2c22-718e-48bb-98db-96f4b43e7ee8", //流程实例ID
    "application": "1dc23336-6be6-402b-bed6-36e707a1dd17",  //流程应用ID
    "applicationName": "财务管理",                          //流程应用名称
    "applicationAlias": "finance",                          //流程应用别名
    "process": "2207db11-dddf-4ebd-864d-3819f3e173c6",      //流程ID
    "processName": "报销审批流程",                          //流程名称
    "processAlias": "",                                     //流程别名
    "completed": false,                             //流程是否已完成
    "serial": "",                                   //流程编号
    "person": "XXX@huqi@P",                         //待阅人名称
    "identity": "XX@481c9edc-5fb5-41f1-b5c2-6ea609082cdb@I",    //待阅人身份
    "unit": "XX@c448d8bb-98b8-4305-9d3f-12537723cfcc@U",        //待阅人所在组织
    "activity": "13d15daf-2ac5-4c1b-a669-1607a0e5ed15",         //当前活动的ID
    "activityName": "部门领导审核",                             //当前活动的名称
    "activityAlias": "",                                        //当前活动的别名
    "activityDescription": "",                                  //当前活动描述
    "activityType": "manual",                                   //当前活动类型
    "creatorPerson": "XX@huqi@P",                               //流程实例创建人
    "creatorIdentity": "XX@481c9edc-5fb5-41f1-b5c2-6ea609082cdb@I", //流程实例创建人的身份
    "creatorUnit": "XX@c448d8bb-98b8-4305-9d3f-12537723cfcc@U"  //流程实例创建人所在组织
}
```
{% endtab %}
{% endtabs %}

### getTaskCompletedList

获取当前流程实例的所有已办对象。如果流程实例没有任何人处理过，则返回一个空数组。

#### Syntax:

```javascript
var taskCompletedList = this.workContext.getTaskCompletedList();
```

#### Return:

```javascript
> array of workCompleted :　（array）当前流程实例的所有已办。
```

每个workCompleted对象为JSON格式数据，其格式和主要数据如下：

{% tabs %}
{% tab title="workCompleted对象" %}
```javascript
{
    "id": "2aef274c-ec3b-4cb3-882b-6f6c4a2fb6f6",   //已办ID
    "title": "xx7月北京出差报销审批",               //流程实例标题
    "startTime": "2018-09-27 22:49:22",             //待办产生时间
    "startTimeMonth": "2018-09",                    //待办产生的月份
    "completedTime": "2018-10-08 22:04:35",         //已办处理时间
    "completedTimeMonth": "2018-10",                //已办处理的月份
    "work": "854e2c22-718e-48bb-98db-96f4b43e7ee8", //流程实例ID
    "completed": false,                             //流程是否已完成
    "application": "1dc23336-6be6-402b-bed6-36e707a1dd17",  //流程应用ID
    "applicationName": "财务管理",                          //流程应用名称
    "applicationAlias": "finance",                          //流程应用别名
    "process": "2207db11-dddf-4ebd-864d-3819f3e173c6",      //流程ID
    "processName": "报销审批流程",                          //流程名称
    "processAlias": "",                                     //流程别名
    "serial": "",                                   //流程编号
    "person": "xx@huqi@P",                          //已办人名称
    "identity": "XX@481c9edc-5fb5-41f1-b5c2-6ea609082cdb@I",    //已办人身份
    "unit": "XX@c448d8bb-98b8-4305-9d3f-12537723cfcc@U",        //已办人所在组织
    "activity": "13d15daf-2ac5-4c1b-a669-1607a0e5ed15",         //当前活动的ID
    "activityName": "部门领导审核",                             //当前活动的名称
    "activityAlias": "",                                        //当前活动的别名
    "activityDescription": "",                                  //当前活动描述
    "activityType": "manual",                                   //当前活动类型
    "creatorPerson": "XX@huqi@P",                               //流程实例创建人
    "creatorIdentity": "XX@481c9edc-5fb5-41f1-b5c2-6ea609082cdb@I", //流程实例创建人的身份
    "creatorUnit": "XX@c448d8bb-98b8-4305-9d3f-12537723cfcc@U"  //流程实例创建人所在组织
    "routeName": "退回申请人",                      //已办选择的路由名称
    "opinion": "退回申请人"                         //办理意见
}
```
{% endtab %}
{% endtabs %}

### getControl

获取当前人对流程实例的权限。

#### Syntax:

```javascript
var control = this.workContext.getControl();
```

#### Return:

```javascript
> Object :　（Object）当前人对流程实例的所拥有的权限。
```

返回内容如下：

{% tabs %}
{% tab title="流程实例的权限对象" %}
```javascript
{
    "allowVisit": true,             //是否允许访问
    "allowProcessing": true,        //是否允许流转
    "allowReadProcessing": false,   //是否有待阅
    "allowSave": true,              //是否允许保存业务数据
    "allowReset": false,            //是否允许重置处理人
    "allowRetract": false,          //是否允许撤回
    "allowReroute": false,          //是否允许调度
    "allowDelete": true             //是否允许删除流程实例
}
```
{% endtab %}
{% endtabs %}

### getWorkLogList

获取当前流程实例的所有流程记录。

#### Syntax:

```javascript
var workLogList = this.workContext.getWorkLogList();
```

#### Return:

```javascript
> Array of Object :　（array）当前流程实例的所有流程记录。
```

流程记录是一个JSON数组。每个对象的格式和主要数据如下：

```javascript
{
    "taskList": [...],          //此记录的待办（task）对象数组，见getTaskList
    "taskCompletedList": [...],//此记录的已办（taskCompleted）对象数组，见getTaskCompletedList
    "readList": [...],          //此记录的待阅（read）对象数组，见getReadList
    "readCompletedList": [...],//此记录的已阅（readCompleted）对象数组
    "id": "7e30462b-93f1-4e4d-a38b-bea41ed7fc02",   //此纪录的ID
    "work": "854e2c22-718e-48bb-98db-96f4b43e7ee8", //流程实例ID
    "completed": false,                             //是否已完成
    "fromActivity": "e31ad938-c495-45a6-8d77-b8a9b61a165b", //起始活动ID
    "fromActivityType": "manual",                           //起始活动类型
    "fromActivityName": "申请人",                           //起始活动名称
    "fromActivityAlias": "",                                //起始活动别名
    "fromActivityToken": "51209d08-d634-4f15-9b8d-7a6cf131b89f",//起始活动流程记录token（对应上一条流程记录的arrivedActivityToken）
    "fromTime": "2018-09-07 14:03:22",                          //起始活动的到达时间
    "arrivedActivity": "13d15daf-2ac5-4c1b-a669-1607a0e5ed15",  //到达活动的ID
    "arrivedActivityType": "manual",                            //到达活动类型
    "arrivedActivityName": "部门领导审核",                      //到达活动名称
    "arrivedActivityToken": "0a4cfc83-9757-4000-a669-8a45c3ab069e", //到达活动的token
    "arrivedTime": "2018-09-27 15:50:34",                       //到达此活动的时间
    "application": "1dc23336-6be6-402b-bed6-36e707a1dd17",      //流程应用ID
    "applicationName": "财务管理",                              //流程应用名称
    "process": "2207db11-dddf-4ebd-864d-3819f3e173c6",          //流程ID
    "processName": "报销审批流程",                              //流程名称
    "route": "85272e6d-4fda-4cba-aa93-84f964138981",            //经过的路由ID
    "routeName": "送部门领导审核",                              //经过的路由名称
    "connected": true                                           //是否有下一条流程记录
},
```

### getAttachmentList

获取当前流程实例的附件对象列表。

#### Syntax:

```javascript
var attachmentList = this.workContext.getAttachmentList();
```

#### Return:

```javascript
> Array of Object :　（array）当前流程实例的所有附件对象。
```

附件对象是一个JSON数组。每个对象的格式和主要数据如下：

```javascript
{
    "id": "56c4e86f-a4c8-4cc2-a150-1a0d2c5febcb",   //附件ID
    "name": "133203a2-92e6-4653-9954-161b72ddb7f9.png", //附件名称
    "extension": "png",                             //附件扩展名
    "length": 43864,                                //附件大小
    "person": "xx@huqi@P",                          //附件上传人
    "lastUpdateTime": "2018-09-27 15:50:34",        //最后的修改时间
    "lastUpdatePerson": "xx@huqi@P",                //最后的修改人
    "activity": "e31ad938-c495-45a6-8d77-b8a9b61a165b", //附件上传的活动ID
    "activityName": "申请人",                           //附件上传的活动名称
    "activityType": "manual",                           //附件上传的活动类型        
    "site": "$mediaOpinion",                        //附件存储位置（一般用于区分附件在哪个表单元素中显示）
    "type": "image/png"                             //附件类型（contentType）       
}
```

### getRouteList

获取当前待办的可选路由。与task对象中的routeNameList取值相同。

#### Syntax:

```javascript
var routeList = this.workContext.getRouteList();
```

#### Return:

```javascript
> Array of String :　（array）当前待办的可选路由。
```

### setTitle

重新设置流程实例标题。

> 注意：如果表单中有名为“subject”或“title”的可输入元素，或给业务数据（data）的 “subject” 或 “title” 节点赋了值，那么每次流转后，流程实例的标题会自动设置为 “subject” 或 “title” 的值。

#### Syntax:

```javascript
this.workContext.setTitle("这是一个标题");
```

#### Return:

```text
无返回值
```

