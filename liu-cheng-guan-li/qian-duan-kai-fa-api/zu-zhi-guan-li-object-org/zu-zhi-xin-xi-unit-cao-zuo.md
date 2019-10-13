# 组织信息: unit操作

## 获取组织管理架构org对象

你可以通过org对象获取组织中的**人员、人员属性、组织、组织属性、身份、群组和角色**。

### Syntax:

您可以在流程表单、内容管理表单和门户页面中，通过this来获取当前实例的org对象，如下：

```javascript
var org = this.org;
```

## 组织信息: unit操作

### getUnit

根据组织标识获取对应的组织：unit对象数组

#### Syntax:

```javascript
var unitList = this.org.getUnit( unit );
```

#### Arguments:

```text
> unit :　（string JsonObject or array）必选。
可以是组织的distinguishedName、name、id、unique属性值，组织对象，或者是上述属性值和对象的数组。
```

{% code-tabs %}
{% code-tabs-item title="参数person示例" %}
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
{% endcode-tabs-item %}
{% endcode-tabs %}

#### Return:

```text
> unit array :　（Array）组织对象数组。
```

unit对象为JSON格式数据，其格式和主要数据如下：

{% code-tabs %}
{% code-tabs-item title="unit对象" %}
```javascript
{
    "name": "开发部", //组织名称
    "unique": "kfb",  //组织唯一标识
    "distinguishedName": "开发部@kfb@U", //组织识别名
    "typeList": [   //组织类型
        "部门"
    ],
    "description": "", //组织描述
    "shortName": "kfb", //组织简称
    "level": 2, //组织层级
    "levelName": "浙江兰德纵横/开发部", //层级名
    "superior": "浙江兰德纵横@a706f5f0-4a3b-4785-8e1d-0a944bfad4eb@U" //上级组织
}
```
{% endcode-tabs-item %}
{% endcode-tabs %}

### listSubUnit

根据组织标识获取下级组织的对象数组：unit对象数组。

#### Syntax:

```javascript
var unitList = this.org.listSubUnit( unit , nested );
```

#### Arguments:

```javascript
> unit :　（string JsonObject or array）必选。
可以是组织的distinguishedName、name、id、unique属性值，组织对象，或者是上述属性值和对象的数组。
> nested :　（boolean）可选，true嵌套的所有组织；false直接组织；默认false
```

{% code-tabs %}
{% code-tabs-item title="参数unit示例" %}
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
{% endcode-tabs-item %}
{% endcode-tabs %}

#### Return:

```javascript
> unit array :　（Array）组织对象数组。
```

unit对象为JSON格式数据，其格式和主要数据如下：

{% code-tabs %}
{% code-tabs-item title="unit对象" %}
```javascript
{
    "name": "开发部", //组织名称
    "unique": "kfb",  //组织唯一标识
    "distinguishedName": "开发部@kfb@U", //组织识别名
    "typeList": [   //组织类型
        "部门"
    ],
    "description": "", //组织描述
    "shortName": "kfb", //组织简称
    "level": 2, //组织层级
    "levelName": "浙江兰德纵横/开发部", //层级名
    "superior": "浙江兰德纵横@a706f5f0-4a3b-4785-8e1d-0a944bfad4eb@U" //上级组织
}
```
{% endcode-tabs-item %}
{% endcode-tabs %}



































































