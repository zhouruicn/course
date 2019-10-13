# 群组信息: group

## 获取组织管理架构org对象

你可以通过org对象获取组织中的**人员、人员属性、组织、组织属性、身份、群组和角色**。

### Syntax:

您可以在流程表单、内容管理表单和门户页面中，通过this来获取当前实例的org对象，如下：

```javascript
var org = this.org;
```

## 群组信息: group

### getGroup

根据群组标识获取对应的群组对象数组：group对象数组

#### Syntax:

```javascript
var groupList = this.org.getGroup( group );
```

#### Arguments:

```text
> group :　（string JsonObject or array）必选。
可以是群组的distinguishedName、name、id、unique属性值，群组对象，或者是上述属性值和对象的数组。
```

{% code-tabs %}
{% code-tabs-item title="参数group示例" %}
```javascript
//以下均为合法参数
//群组属性值
"工作汇报读者@ReportReader@G" //群组识别名
"cce8bc22-225a-4f85-8132-7374d546886e" //id
"ReportReader" //群组唯一标识
"工作汇报读者" //群组名称

//对象
{ "distinguishedName": "工作汇报读者@ReportReader@G" } //群组识别名
{ "unique": "cce8bc22-225a-4f85-8132-7374d546886e" } //群组唯一标识
{ "unique": "ReportReader" } //群组唯一标识
{ "name": "工作汇报读者" } //群组对象

//上述属性组和对象数组
[ "工作汇报读者", "公文阅读者" ] //名称数组
[ { "name": "工作汇报读者" }, { "name": "公文阅读者" } ] //名称数组

...其他属性值或对象数组

```
{% endcode-tabs-item %}
{% endcode-tabs %}

#### Return:

```text
> group array:　（Array）群组对象数组。
```

group对象为JSON格式数据，其格式和主要数据如下：

```javascript
{
    "name": "工作汇报读者", //群组名称
    "unique": "ReportReader",   //群组唯一标志
    "description": "可查看所有部门所有状态的工作汇报", //群组说明
    "distinguishedName": "工作汇报读者@ReportReader@G", //群组全称
    "orderNumber": 13699599,  //排序号
    "personList": [     //个人成员
        "张三@zhangsan@P",
        "李四@lisi@P",
    ],
    "groupList": [  //群组成员
        "所有部门领导@AllDepartLeader@G",
        "所有部门汇报管理员@AllDepartReportManager@G"
    ]
}
```

### listSubGroup

根据群组标识获取下级群组的对象数组：group对象数组。

#### Syntax:

```javascript
var groupList = this.org.listSubGroup( group , nested );
```

#### Arguments:

```text
> group :　（string JsonObject or array）必选。
可以是群组的distinguishedName、name、id、unique属性值，群组对象，或者是上述属性值和对象的数组。
> nested :　（boolean）可选，true嵌套的所有下级群组；false直接群组；默认false
```

{% code-tabs %}
{% code-tabs-item title="参数group示例" %}
```javascript
//以下均为合法参数
//群组属性值
"工作汇报读者@ReportReader@G" //群组识别名
"cce8bc22-225a-4f85-8132-7374d546886e" //id
"ReportReader" //群组唯一标识
"工作汇报读者" //群组名称

//对象
{ "distinguishedName": "工作汇报读者@ReportReader@G" } //群组识别名
{ "unique": "cce8bc22-225a-4f85-8132-7374d546886e" } //群组唯一标识
{ "unique": "ReportReader" } //群组唯一标识
{ "name": "工作汇报读者" } //群组对象

//上述属性组和对象数组
[ "工作汇报读者", "公文阅读者" ] //名称数组
[ { "name": "工作汇报读者" }, { "name": "公文阅读者" } ] //名称数组

...其他属性值或对象数组
```
{% endcode-tabs-item %}
{% endcode-tabs %}

#### Return:

```text
> group array:　（Array）群组对象数组。
```

group对象为JSON格式数据，其格式和主要数据如下：

```javascript
{
    "name": "工作汇报读者", //群组名称
    "unique": "ReportReader",   //群组唯一标志
    "description": "可查看所有部门所有状态的工作汇报", //群组说明
    "distinguishedName": "工作汇报读者@ReportReader@G", //群组全称
    "orderNumber": 13699599,  //排序号
    "personList": [     //个人成员
        "张三@zhangsan@P",
        "李四@lisi@P",
    ],
    "groupList": [  //群组成员
        "所有部门领导@AllDepartLeader@G",
        "所有部门汇报管理员@AllDepartReportManager@G"
    ]
}
```

### listSupGroup

根据群组标识获取上级群组的对象数组：group对象数组。

#### Syntax:

```javascript
var groupList = this.org.listSupGroup( group , nested );
```

#### Arguments:

```text
> group :　（string JsonObject or array）必选。
可以是群组的distinguishedName、name、id、unique属性值，群组对象，或者是上述属性值和对象的数组。
> nested :　（boolean）可选，true嵌套的所有上级群组；false直接群组；默认false
```

{% code-tabs %}
{% code-tabs-item title="参数group示例" %}
```javascript
//以下均为合法参数
//群组属性值
"工作汇报读者@ReportReader@G" //群组识别名
"cce8bc22-225a-4f85-8132-7374d546886e" //id
"ReportReader" //群组唯一标识
"工作汇报读者" //群组名称

//对象
{ "distinguishedName": "工作汇报读者@ReportReader@G" } //群组识别名
{ "unique": "cce8bc22-225a-4f85-8132-7374d546886e" } //群组唯一标识
{ "unique": "ReportReader" } //群组唯一标识
{ "name": "工作汇报读者" } //群组对象

//上述属性组和对象数组
[ "工作汇报读者", "公文阅读者" ] //名称数组
[ { "name": "工作汇报读者" }, { "name": "公文阅读者" } ] //名称数组

...其他属性值或对象数组
```
{% endcode-tabs-item %}
{% endcode-tabs %}

#### Return:

```text
> group array:　（Array）群组对象数组。
```

group对象为JSON格式数据，其格式和主要数据如下：

```javascript
{
    "name": "工作汇报读者", //群组名称
    "unique": "ReportReader",   //群组唯一标志
    "description": "可查看所有部门所有状态的工作汇报", //群组说明
    "distinguishedName": "工作汇报读者@ReportReader@G", //群组全称
    "orderNumber": 13699599,  //排序号
    "personList": [     //个人成员
        "张三@zhangsan@P",
        "李四@lisi@P",
    ],
    "groupList": [  //群组成员
        "所有部门领导@AllDepartLeader@G",
        "所有部门汇报管理员@AllDepartReportManager@G"
    ]
}
```

### listGroupWithPerson

根据人员标识获取所有的群组对象数组。如果群组具有群组（group）成员，且群组成员中包含该人员，那么该群组也被返回。

#### Syntax:

```javascript
var groupList = this.org.listGroupWithPerson( person );
```

#### Arguments:

```javascript
> person :　（string JsonObject or array）必选。
可以是人员的distinguishedName、name、id、unique属性值，人员对象，或者是上述属性值和对象的数组。
```

{% code-tabs %}
{% code-tabs-item title="参数person示例" %}
```javascript
//以下均为合法参数
//人员属性值
"李四@lisi@P" //人员别名
"cce8bc22-225a-4f85-8132-7374d546886e" //id
"lisi" //人员唯一标识
"李四" //人员名称

//对象
{ "distinguishedName": "李四@lisi@P" } //人员识别名
{ "unique": "cce8bc22-225a-4f85-8132-7374d546886e" } //人员唯一标识
{ "unique": "lisi" } //人员唯一标识
{ "name": "李四" } //名称对象

//上述属性组和对象数组
[ "张三", "李四" ] //名称数组
[ { "name": "李四" }, { "name": "张三" } ] //名称数组

...其他属性值或对象数组
```
{% endcode-tabs-item %}
{% endcode-tabs %}

#### Return:

```text
> group array:　（Array）群组对象数组。
```

group对象为JSON格式数据，其格式和主要数据如下：

```javascript
{
    "name": "工作汇报读者", //群组名称
    "unique": "ReportReader",   //群组唯一标志
    "description": "可查看所有部门所有状态的工作汇报", //群组说明
    "distinguishedName": "工作汇报读者@ReportReader@G", //群组全称
    "orderNumber": 13699599,  //排序号
    "personList": [     //个人成员
        "张三@zhangsan@P",
        "李四@lisi@P",
    ],
    "groupList": [  //群组成员
        "所有部门领导@AllDepartLeader@G",
        "所有部门汇报管理员@AllDepartReportManager@G"
    ]
}
```

