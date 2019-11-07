# 组织属性: unitAttribute

## 获取组织管理架构org对象

你可以通过org对象获取组织中的**人员、人员属性、组织、组织属性、身份、群组和角色**。

### Syntax:

您可以在流程表单、内容管理表单和门户页面中，通过this来获取当前实例的org对象，如下：

```javascript
var org = this.org;
```

## 组织属性: unitAttribute

### appendUnitAttribute

添加组织属性值\(在属性中添加values值，如果没有此属性，则创建一个\)

#### Syntax:

```javascript
this.org.appendUnitAttribute( unit, attribute, valueArray);
```

#### Arguments:

```text
> unit :　（string or JsonObject ）必选。
可以是组织的distinguishedName、name、id、unique属性值，组织对象。
> attribute :　（string）必选，属性名称
> valueArray :　（Array）必选，属性值，必须为数组
```

{% tabs %}
{% tab title="参数Unit示例" %}
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
```
{% endtab %}
{% endtabs %}

#### Return:

```text
没有返回值
```

### setUnitAttribute

设置组织属性值\(将属性值修改为values，如果没有此属性，则创建一个\)

#### Syntax:

```javascript
this.org.setUnitAttribute( unit, attribute, valueArray );
```

#### Arguments:

```text
> unit :　（string or JsonObject ）必选。
可以是组织的distinguishedName、name、id、unique属性值，组织对象。
> attribute :　（string）必选，属性名称
> valueArray :　（Array）必选，属性值，必须为数组
```

{% tabs %}
{% tab title="参数Unit示例" %}
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
```
{% endtab %}
{% endtabs %}

#### Return:

```text
没有返回值
```

### getUnitAttribute

根据组织标识和属性名称获取对应属性值。

#### Syntax:

```javascript
var valueList = this.org.getUnitAttribute( unit, attributeName );
```

#### Arguments:

```text
> unit :　（string or JsonObject ）必选。
可以是组织的distinguishedName、name、id、unique属性值，组织对象。
> attributeName :　（string）必选，属性名称
```

{% tabs %}
{% tab title="参数Unit示例" %}
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
```
{% endtab %}
{% endtabs %}

#### Return:

```text
> string array :　（Array）属性值数组。如：[ value1, value2 ]
```

### listUnitAttributeName

列出组织所有属性的名称。

#### Syntax:

```javascript
var valueList = this.org.listUnitAttributeName( unit );
```

#### Arguments:

```text
> unit :　（string or JsonObject ）必选。
可以是组织的distinguishedName、name、id、unique属性值，组织对象。
```

{% tabs %}
{% tab title="参数Unit示例" %}
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
{% endtab %}
{% endtabs %}

#### Return:

```text
> string array :　（Array）属性名称数组。如：[ attributeName1, attributeName2,.....]
```

### listUnitAllAttribute

列出人员的所有属性值。

#### Syntax:

```javascript
var valueList = this.org.listUnitAllAttribute( unit );
```

#### Arguments:

```text
> unit :　（string or JsonObject ）必选。
可以是组织的distinguishedName、name、id、unique属性值，组织对象。
```

{% tabs %}
{% tab title="参数Unit示例" %}
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
{% endtab %}
{% endtabs %}

#### Return:

```text
> unitAttribute array :　（Array）组织属性对象数组。
```

unitAttribute对象为JSON格式数据，其格式和主要数据如下：

{% tabs %}
{% tab title="unitAttribute对象" %}
```javascript
{
    "name": "部门类别",
    "unit": "开发部@kfb@U",
    "attributeList": [
        "生产部门"
    ]
}
```
{% endtab %}
{% endtabs %}

