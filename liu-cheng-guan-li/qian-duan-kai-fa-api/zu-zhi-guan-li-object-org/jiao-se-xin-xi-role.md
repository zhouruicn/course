# 角色信息: role

## 获取组织管理架构org对象

你可以通过org对象获取组织中的**人员、人员属性、组织、组织属性、身份、群组和角色**。

### Syntax:

您可以在流程表单、内容管理表单和门户页面中，通过this来获取当前实例的org对象，如下：

```javascript
var org = this.org;
```

## 角色信息: role

### getRole

根据角色标识获取对应的角色对象数组。

#### Syntax:

```javascript
var roleList = this.org.getRole( role );
```

#### Arguments:

```javascript
> role :（string JsonObject or array）必选。
可以是角色的distinguishedName、name、id、unique属性值，角色对象，或者是上述属性值和对象的数组。
```

{% tabs %}
{% tab title="参数role示例" %}
```javascript
///以下均为合法参数
//角色属性值
"Manager@ManagerSystemRole@R" //角色识别名
"cce8bc22-225a-4f85-8132-7374d546886e" //id
"ManagerSystemRole" //角色唯一标识
"Manager" //角色名称

//对象
{ "distinguishedName": "Manager@ManagerSystemRole@R" } //角色识别名
{ "unique": "cce8bc22-225a-4f85-8132-7374d546886e" } //角色唯一标识
{ "unique": "ManagerSystemRole" } //角色唯一标识
{ "name": "Manager" } //角色对象

//上述属性组和对象数组
[ "Manager", "OrganizationManager" ] //名称数组
[ { "name": "Manager" }, { "name": "OrganizationManager" } ] //名称数组

...其他属性值或对象数组
```
{% endtab %}
{% endtabs %}

#### Return:

```javascript
> role array :　（Array）角色对象数组。
```

role对象为JSON格式数据，其格式和主要数据如下：

{% tabs %}
{% tab title="role对象" %}
```javascript
{
    "name": "Manager",   //角色名称
    "unique": "ManagerSystemRole", //角色唯一标识
    "description": "", //角色描述
    "distinguishedName": "Manager@ManagerSystemRole@R", //角色识别名
    "orderNumber": 7897556, //排序号
    "personList": [  //人员成员
        "张三@zhangsan@P",
        "李四@lisi@P"
    ],
    "groupList": [  //群组成员
        "测试群组@ceshizu@G"
    ]
}
```
{% endtab %}
{% endtabs %}

### listRoleWithPerson

根据人员标识获取所有的角色对象数组。如果角色具有群组（group）成员，且群组中包含该人员，那么该角色也被返回。

#### Syntax:

```javascript
var roleList = this.org.listRoleWithPerson( person );
```

#### Arguments:

```javascript
> person :　（string , JsonObject or array）必选。
可以是人员的distinguishedName、name、id、unique属性值，人员对象，或者是上述属性值和对象的数组。
```

{% tabs %}
{% tab title="参数person示例" %}
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
{% endtab %}
{% endtabs %}

#### Return:

```javascript
> role array :　（Array）角色对象数组。
```

role对象为JSON格式数据，其格式和主要数据如下：

{% tabs %}
{% tab title="role对象" %}
```javascript
{
    "name": "Manager",   //角色名称
    "unique": "ManagerSystemRole", //角色唯一标识
    "description": "", //角色描述
    "distinguishedName": "Manager@ManagerSystemRole@R", //角色识别名
    "orderNumber": 7897556, //排序号
    "personList": [  //人员成员
        "张三@zhangsan@P",
        "李四@lisi@P"
    ],
    "groupList": [  //群组成员
        "测试群组@ceshizu@G"
    ]
}
```
{% endtab %}
{% endtabs %}

### personHasRole

判断人员是否拥有角色。

#### Syntax:

```javascript
var flag = this.org.personHasRole( person, role );
```

#### Arguments:

```javascript
> person :　（string or JsonObject）必选。
可以是人员的distinguishedName、name、id、unique属性值，人员对象。
> role :　（string JsonObject or array）必选。
可以是角色的distinguishedName、name、id、unique属性值，角色对象，或者是上述属性值和对象的数组。
```

{% tabs %}
{% tab title="参数person示例" %}
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
```
{% endtab %}
{% endtabs %}

{% tabs %}
{% tab title="参数role示例" %}
```javascript
///以下均为合法参数
//角色属性值
"Manager@ManagerSystemRole@R" //角色识别名
"cce8bc22-225a-4f85-8132-7374d546886e" //id
"ManagerSystemRole" //角色唯一标识
"Manager" //角色名称

//对象
{ "distinguishedName": "Manager@ManagerSystemRole@R" } //角色识别名
{ "unique": "cce8bc22-225a-4f85-8132-7374d546886e" } //角色唯一标识
{ "unique": "ManagerSystemRole" } //角色唯一标识
{ "name": "Manager" } //角色对象

//上述属性组和对象数组
[ "Manager", "OrganizationManager" ] //名称数组
[ { "name": "Manager" }, { "name": "OrganizationManager" } ] //名称数组

...其他属性值或对象数组
```
{% endtab %}
{% endtabs %}

#### Return:

```javascript
> flag :　（boolean）如果人员拥有角色返回true, 否则返回false。
```

### groupHasRole

判断群组是否拥有角色。

#### Syntax:

```javascript
var flag = this.org.groupHasRole( group, role );
```

#### Arguments:

```text
> group :　（string or JsonObject）必选。
可以是群组的distinguishedName、name、id、unique属性值，群组对象。
> role :　（string JsonObject or array）必选。
可以是角色的distinguishedName、name、id、unique属性值，角色对象，或者是上述属性值和对象的数组。
```

{% tabs %}
{% tab title="参数group示例" %}
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
```
{% endtab %}
{% endtabs %}

{% tabs %}
{% tab title="参数role示例" %}
```javascript
///以下均为合法参数
//角色属性值
"Manager@ManagerSystemRole@R" //角色识别名
"cce8bc22-225a-4f85-8132-7374d546886e" //id
"ManagerSystemRole" //角色唯一标识
"Manager" //角色名称

//对象
{ "distinguishedName": "Manager@ManagerSystemRole@R" } //角色识别名
{ "unique": "cce8bc22-225a-4f85-8132-7374d546886e" } //角色唯一标识
{ "unique": "ManagerSystemRole" } //角色唯一标识
{ "name": "Manager" } //角色对象

//上述属性组和对象数组
[ "Manager", "OrganizationManager" ] //名称数组
[ { "name": "Manager" }, { "name": "OrganizationManager" } ] //名称数组

...其他属性值或对象数组
```
{% endtab %}
{% endtabs %}

#### Return:

```javascript
> flag :　（boolean）如果群组拥有角色返回true, 否则返回false。
```







