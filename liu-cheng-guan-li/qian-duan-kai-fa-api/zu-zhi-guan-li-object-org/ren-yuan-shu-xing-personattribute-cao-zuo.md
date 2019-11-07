# 人员属性: personAttribute操作

## 获取组织管理架构org对象

你可以通过org对象获取组织中的**人员、人员属性、组织、组织属性、身份、群组和角色**。

### Syntax:

您可以在流程表单、内容管理表单和门户页面中，通过this来获取当前实例的org对象，如下：

```javascript
var org = this.org;
```

## 人员属性: personAttribute操作

### appendPersonAttribute

添加人员属性值\(在属性中添加values值，如果没有此属性，则创建一个\)

#### Syntax:

```javascript
this.org.appendPersonAttribute( person, attribute, valueArray);
```

#### Arguments:

```javascript
> person :　（string or JsonObject ）必选。可以是人员的distinguishedName、name、id、unique属性值，人员对象。> attribute :　（string）必选，属性名称> valueArray :　（Array）必选，属性值，必须为数组
```

{% tabs %}
{% tab title="参数person示例" %}
```javascript
//以下均为合法参数//人员属性值"李四@lisi@P" //人员别名"cce8bc22-225a-4f85-8132-7374d546886e" //id"lisi" //人员唯一标识"李四" //人员名称//对象{ "distinguishedName": "李四@lisi@P" } //人员识别名{ "unique": "cce8bc22-225a-4f85-8132-7374d546886e" } //人员唯一标识{ "unique": "lisi" } //人员唯一标识{ "name": "李四" } //名称对象
```
{% endtab %}
{% endtabs %}

#### Return:

```text
没有返回值
```

### setPersonAttribute

设置人员属性值\(将属性值修改为values，如果没有此属性，则创建一个\)

#### Syntax:

```javascript
this.org.setPersonAttribute( person, attribute, valueArray );
```

#### Arguments:

```text
> person :　（string or JsonObject ）必选。可以是人员的distinguishedName、name、id、unique属性值，人员对象。> attribute:　（string）必选，属性名称> valueArray:　（Array）必选，属性值，必须为数组
```

{% tabs %}
{% tab title="参数person示例" %}
```javascript
//以下均为合法参数//人员属性值"李四@lisi@P" //人员别名"cce8bc22-225a-4f85-8132-7374d546886e" //id"lisi" //人员唯一标识"李四" //人员名称//对象{ "distinguishedName": "李四@lisi@P" } //人员识别名{ "unique": "cce8bc22-225a-4f85-8132-7374d546886e" } //人员唯一标识{ "unique": "lisi" } //人员唯一标识{ "name": "李四" } //名称对象
```
{% endtab %}
{% endtabs %}

#### Return:

```text
没有返回值
```

### getPersonAttribute

根据人员和属性名称获取属性值。

#### Syntax:

```javascript
var valueList = this.org.getPersonAttribute( person, attributeName );
```

#### Arguments:

```javascript
> person :　（string or JsonObject）必选。可以是人员的distinguishedName、name、id、unique属性值，组织对象。> attributeName :　（string）必选，属性名称
```

{% tabs %}
{% tab title="参数person示例" %}
```javascript
//以下均为合法参数//人员属性值"李四@lisi@P" //人员别名"cce8bc22-225a-4f85-8132-7374d546886e" //id"lisi" //人员唯一标识"李四" //人员名称//对象{ "distinguishedName": "李四@lisi@P" } //人员识别名{ "unique": "cce8bc22-225a-4f85-8132-7374d546886e" } //人员唯一标识{ "unique": "lisi" } //人员唯一标识{ "name": "李四" } //名称对象
```
{% endtab %}
{% endtabs %}

#### Return:

```text
> string array :　（Array）属性值数组。如：[ value1, value2 ]
```

### listPersonAttributeName

列出人员所有属性的名称

#### Syntax:

```text
var attributeNameList = this.org.listPersonAttributeName( person );
```

#### Arguments:

```text
> person :　（string , JsonObject or array）必选。可以是人员的distinguishedName、name、id、unique属性值，人员对象，或者是上述属性值和对象的数组。
```

{% tabs %}
{% tab title="参数person示例" %}
```javascript
//以下均为合法参数//人员属性值"李四@lisi@P" //人员别名"cce8bc22-225a-4f85-8132-7374d546886e" //id"lisi" //人员唯一标识"李四" //人员名称//对象{ "distinguishedName": "李四@lisi@P" } //人员识别名{ "unique": "cce8bc22-225a-4f85-8132-7374d546886e" } //人员唯一标识{ "unique": "lisi" } //人员唯一标识{ "name": "李四" } //名称对象//上述属性组和对象数组[ "张三", "李四" ] //名称数组[ { "name": "李四" }, { "name": "张三" } ] //名称数组...其他属性值或对象数组
```
{% endtab %}
{% endtabs %}

#### Return:

```text
> string array :　（Array）人员属性名称数组。如：[ attributeName1, attributeName2 ]
```

### listPersonAllAttribute

列出人员的所有属性值。

#### Syntax:

```javascript
var personAttributeList = this.org.listPersonAllAttribute( person );
```

#### Arguments:

```text
> person :　（string , JsonObject or array）必选。可以是人员的distinguishedName、name、id、unique属性值，人员对象，或者是上述属性值和对象的数组。
```

{% tabs %}
{% tab title="参数person示例" %}
```javascript
//以下均为合法参数//人员属性值"李四@lisi@P" //人员别名"cce8bc22-225a-4f85-8132-7374d546886e" //id"lisi" //人员唯一标识"李四" //人员名称//对象{ "distinguishedName": "李四@lisi@P" } //人员识别名{ "unique": "cce8bc22-225a-4f85-8132-7374d546886e" } //人员唯一标识{ "unique": "lisi" } //人员唯一标识{ "name": "李四" } //名称对象//上述属性组和对象数组[ "张三", "李四" ] //名称数组[ { "name": "李四" }, { "name": "张三" } ] //名称数组...其他属性值或对象数组
```
{% endtab %}
{% endtabs %}

#### Return:

```text
> personAttribute array :　（Array）人员属性对象数组。
```

personAttribute对象为JSON格式数据，其格式和主要数据如下：

{% tabs %}
{% tab title="personAttribute对象" %}
```javascript
{    "name": "住址",    "person": "张三@zhangsan@P",    "attributeList": [        "杭州市","绍兴市"    ]}
```
{% endtab %}
{% endtabs %}







