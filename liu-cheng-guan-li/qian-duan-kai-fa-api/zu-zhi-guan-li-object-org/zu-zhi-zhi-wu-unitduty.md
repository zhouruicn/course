# 组织职务: unitDuty

## 获取组织管理架构org对象

你可以通过org对象获取组织中的**人员、人员属性、组织、组织属性、身份、群组和角色**。

### Syntax:

您可以在流程表单、内容管理表单和门户页面中，通过this来获取当前实例的org对象，如下：

```javascript
var org = this.org;
```

## 组织职务: unitDuty

### getDuty

根据职务名称和组织名称获取身份。

#### Syntax: 

```javascript
var identityList = this.org.getDuty( dutyName, unit );
```

#### Arguments:

```javascript
> dutyName :　（string ）必选。组织职务名称。
> unit :　（string or JsonObject）必选。
可以是组织的distinguishedName、name、id、unique属性值，组织对象。
```

{% code title="参数unit示例" %}
```javascript
//以下均为合法参数
//组织属性值
"开发部@kfb@U" //组织标识名
"cce8bc22-225a-4f85-8132-7374d546886e" //id
"kfb" //组织唯一标识
"开发部" //组织名称

//对象
{ "distinguishedName": "开发部@kfb@U" } //人员识别名
{ "unique": "cce8bc22-225a-4f85-8132-7374d546886e" } //人员唯一标识
{ "unique": "kfb" } //人员唯一标识
{ "name": "开发部" } //名称对象
```
{% endcode %}

#### Return:

```javascript
> identity array :　（Array）身份对象数组。
```

identity对象为JSON格式数据，其格式和主要数据如下：

{% code title="identity对象" %}
```javascript
{
    "name": "李四",  //身份名称，不唯一
    "unique": "23dd1b53-feed-485d-8c9c-1a4e64ff58a2", //身份唯一标识
    "description": "", //身份描述
    "distinguishedName": "李四@23dd1b53-feed-485d-8c9c-1a4e64ff58a2@I", //身份全称
    "person": "李四@lisi@P", //人员
    "unit": "开发部@kfb@U",  //组织
    "unitName": "开发部",   //组织名称, 不唯一
    "unitLevel": 2,         //组织层级
    "unitLevelName": "浙江兰德纵横/开发部", //组织层级名
    "orderNumber": 24920439 //排序号
}

```
{% endcode %}

### listDutyNameWithIdentity

获取身份的所有职务名称。

#### Syntax:

```javascript
var dutyNameList = this.org.listDutyNameWithIdentity( identity );
```

#### Arguments:

```text
> identity :　（string , JsonObject or array）必选。
可以是身份的distinguishedName、name、id、unique属性值，身份对象，或者是上述属性值和对象的数组。
```

{% code title="参数identity示例" %}
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
{% endcode %}

#### Return:

```javascript
> duty name array :　（Array）职务名称数组。
```

### listDutyNameWithUnit

获取组织的所有职务名称。

#### Syntax:

```javascript
var dutyNameList = this.org.listDutyNameWithIdentity( unit );
```

#### Arguments:

```javascript
> unit :　（string , JsonObject or array）必选。
可以是组织的distinguishedName、name、id、unique属性值，组织对象，或者是上述属性值和对象的数组。
```

{% code title="参数unit示例" %}
```javascript
//以下均为合法参数
//组织属性值
"开发部@kfb@U" //组织标识名
"cce8bc22-225a-4f85-8132-7374d546886e" //id
"kfb" //组织唯一标识
"开发部" //组织名称

//对象
{ "distinguishedName": "开发部@kfb@U" } //组织识别名
{ "unique": "cce8bc22-225a-4f85-8132-7374d546886e" } //组织唯一标识
{ "unique": "kfb" } //组织唯一标识
{ "name": "开发部" } //组织对象

//上述属性组和对象数组
[ "开发部", "综合部" ] //名称数组
[ { "name": "开发部" }, { "name": "综合部" } ] //名称数组

...其他属性值或对象数组
```
{% endcode %}

#### Return:

```javascript
> duty name array :　（Array）职务名称数组。
```

### listUnitAllDuty

获取组织的所有职务。

#### Syntax:

```javascript
var dutyList = this.org.listUnitAllDuty( unit );
```

#### Arguments:

```javascript
> unit :　（string , JsonObject or array）必选。
可以是组织的distinguishedName、name、id、unique属性值，组织对象，或者是上述属性值和对象的数组。
```

{% code title="参数unit示例" %}
```javascript
//以下均为合法参数
//组织属性值
"开发部@kfb@U" //组织标识名
"cce8bc22-225a-4f85-8132-7374d546886e" //id
"kfb" //组织唯一标识
"开发部" //组织名称

//对象
{ "distinguishedName": "开发部@kfb@U" } //组织识别名
{ "unique": "cce8bc22-225a-4f85-8132-7374d546886e" } //组织唯一标识
{ "unique": "kfb" } //组织唯一标识
{ "name": "开发部" } //组织对象

//上述属性组和对象数组
[ "开发部", "综合部" ] //名称数组
[ { "name": "开发部" }, { "name": "综合部" } ] //名称数组

...其他属性值或对象数组
```
{% endcode %}

#### Return:

```javascript
> duty array :　（Array）组织职务对象数组。
```

duty对象为JSON格式数据，其格式和主要数据如下：

{% code title="duty对象" %}
```javascript
{
    "name": "正职领导", //职务名称
    "unit": "开发部@kfb@U", //组织识别名
    "identityList": [   //身份对象数组
        {
            "name": "李四",
            "unique": "lisi",
            "description": "",
            "distinguishedName": "李四@6eafc523-b8a7-4a95-ad9e-a5af87c04410@I",
            "person": "李四@lisi@P",
            "unit": "财务部@310088ea-2786-4ed9-8489-f294e9436ce9@U",
            "unitName": "财务部",
            "unitLevel": 2,
            "unitLevelName": "浙江兰德纵横/财务部",
            "orderNumber": 16972237
        }
    ]
}
```
{% endcode %}



















