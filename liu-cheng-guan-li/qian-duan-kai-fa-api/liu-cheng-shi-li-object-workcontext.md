# 流程实例 - Object: workContext

你可以通过workContext获取和流程相关的流程实例对象数据。

## 获取对象

您可以在表单或流程的各个嵌入脚本中，通过this来获取当前流程实例数据，如下：

### Syntax:

```javascript
var context = this.workContext;
```

## Method: getTask

获取当前流程与当前用户相关的**待办对象**：task对象。 

当前流程实例正在流转中，并且当前用户有待办，则返回当前用户的待办对象，否则返回null。

### Syntax:

```javascript
var task = this.workContext.getTask();
```

### Return:

```text
> task :　（Object）当前用户的待办任务对象：task。
> null :　（null）当前用户没有对此流程实例的待办时，或流程实例已经流转结束，返回null。
```

task对象为JSON格式数据，其格式和主要数据如下：

{% code-tabs %}
{% code-tabs-item title="task对象" %}
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
{% endcode-tabs-item %}
{% endcode-tabs %}

## Method: getWork

获取当前流程实例对象：work对象或workCompleted对象。

### Syntax:

```javascript
var work = this.workContext.getWork();
```

### Return:

```javascript
> work :　（Object）流程实例对象。
> workCompleted :　（Object）如果流程已结束，返回已结束的流程实例对象：workCompleted。
```

work对象或workCompleted对象为JSON格式数据，其格式和主要数据如下：

{% code-tabs %}
{% code-tabs-item title="work对象" %}
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
{% endcode-tabs-item %}
{% endcode-tabs %}

{% code-tabs %}
{% code-tabs-item title="workCompleted对象" %}
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
{% endcode-tabs-item %}
{% endcode-tabs %}

## Method: getActivity

获取当前流程实例所在的**活动节点对象**：activity对象。

### Syntax:

```javascript
var activity = this.workContext.getActivity();
```

### Return:

```javascript
> activity :　（Object）当前流程实例所在的活动节点对象：activity。
> null :　（null）如果当前流程实例已流转完成，则返回null。
```

## Method: getTaskList

获取当前流程实例的**所有待办对象**。如果流程实例已流转完成，则返回一个空数组。

### Syntax:

```javascript
var taskList = this.workContext.getTaskList();
```

### Return:

```javascript
> array of task :　（array）当前流程实例的所有待办。
```





























































