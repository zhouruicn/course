# 组织架构管理 - Object: org

## 获取组织管理架构org对象

你可以通过org对象获取组织中的**人员、人员属性、组织、组织属性、身份、群组和角色**。

### Syntax:

您可以在流程表单、内容管理表单和门户页面中，通过this来获取当前实例的org对象，如下：

```javascript
var org = this.org;
```

## 人员信息: person 操作

### getPerson

根据人员标识获取对应的人员对象数组：person对象数组

#### Syntax:

```javascript
var personList = this.org.getPerson( person );
```

#### Arguments:

```javascript
> person :　（string JsonObject or array）必选。
可以是人员的distinguishedName、name、id、unique属性值，人员对象，或者是上述属性值和对象的数组。
```

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

#### Return:

```javascript
> person array :　（Array）人员对象数组。
```

person对象为JSON格式数据，其格式和主要数据如下：

{% code-tabs %}
{% code-tabs-item title="person对象" %}
```javascript
{
    "name": "李四",    //姓名
    "genderType": "m", //性别， m为男性， f为女性， d未知
    "signature": "", //签名
    "description": "", //说明
    "employee": "1111", //员工号
    "unique": "lisi", //唯一标识
    "distinguishedName": "李四@lisi@P", //识别名
    "orderNumber": 14214946, //排序号
    "mail": "", //邮箱
    "weixin": "", //微信号
    "qq": "", //qq号码
    "mobile": "85252281460", //手机号码
    "officePhone": "", //办公电话
    "boardDate" : "", //入职日期
    "birthday" : "", //生日
    "age" : "", //年龄
    "qiyeweixinId" : "", //企业微信id
    "dingdingId" : "", //钉钉id
    "zhengwuDingdingId" //政务钉钉id
}
```
{% endcode-tabs-item %}
{% endcode-tabs %}

### listSubPerson

根据人员标识获取下级人员的对象数组：person对象数组。该上下级关系被人员的汇报对象值（superior）决定。

#### Syntax:

```javascript
var personList = this.org.listSubPerson( person , nested );
```

#### Arguments:

```javascript
> person :　（string JsonObject or array）必选。
可以是人员的distinguishedName、name、id、unique属性值，人员对象，或者是上述属性值和对象的数组。
> nested :　（boolean）可选，true嵌套的所有人员；false直接人员；默认false
```

{% code-tabs %}
{% code-tabs-item title="参数person 示例" %}
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

```javascript
> person array :　（Array）人员对象数组。
```

person对象为JSON格式数据，其格式和主要数据如下：

{% code-tabs %}
{% code-tabs-item title="person对象" %}
```javascript
{
    "name": "李四",    //姓名
    "genderType": "m", //性别， m为男性， f为女性， d未知
    "signature": "", //签名
    "description": "", //说明
    "employee": "1111", //员工号
    "unique": "lisi", //唯一标识
    "distinguishedName": "李四@lisi@P", //识别名
    "orderNumber": 14214946, //排序号
    "mail": "", //邮箱
    "weixin": "", //微信号
    "qq": "", //qq号码
    "mobile": "85252281460", //手机号码
    "officePhone": "", //办公电话
    "boardDate" : "", //入职日期
    "birthday" : "", //生日
    "age" : "", //年龄
    "qiyeweixinId" : "", //企业微信id
    "dingdingId" : "", //钉钉id
    "zhengwuDingdingId" //政务钉钉id
}
```
{% endcode-tabs-item %}
{% endcode-tabs %}

### listSupPerson

根据人员标识获取上级人员的对象数组：person对象数组。该上下级关系被人员的汇报对象值（superior）决定。

#### Syntax:

```javascript
var personList = this.org.listSupPerson( person , nested );
```

#### Arguments:

```javascript
> person :　（string JsonObject or array）必选。
可以是人员的distinguishedName、name、id、unique属性值，人员对象，或者是上述属性值和对象的数组。
> nested :　（boolean）可选，true嵌套的所有人员；false直接人员；默认false
```

{% code-tabs %}
{% code-tabs-item title="参数person 示例" %}
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

```javascript
> person array :　（Array）人员对象数组。
```

person对象为JSON格式数据，其格式和主要数据如下：

{% code-tabs %}
{% code-tabs-item title="person对象" %}
```javascript
{
    "name": "李四",    //姓名
    "genderType": "m", //性别， m为男性， f为女性， d未知
    "signature": "", //签名
    "description": "", //说明
    "employee": "1111", //员工号
    "unique": "lisi", //唯一标识
    "distinguishedName": "李四@lisi@P", //识别名
    "orderNumber": 14214946, //排序号
    "mail": "", //邮箱
    "weixin": "", //微信号
    "qq": "", //qq号码
    "mobile": "85252281460", //手机号码
    "officePhone": "", //办公电话
    "boardDate" : "", //入职日期
    "birthday" : "", //生日
    "age" : "", //年龄
    "qiyeweixinId" : "", //企业微信id
    "dingdingId" : "", //钉钉id
    "zhengwuDingdingId" //政务钉钉id
}
```
{% endcode-tabs-item %}
{% endcode-tabs %}

### listPersonWithGroup

根据群组标识获取人员对象成员：person对象数组。

#### Syntax:

```javascript
var personList = this.org.listPersonWithGroup( group );
```

#### Arguments:

```text
> group :　（string JsonObject or array）必选。可以是群组的distinguishedName、name、id、unique属性值，群组对象，或者是上述属性值和对象的数组。
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

```javascript
> person array :　（Array）人员对象数组。
```

person对象为JSON格式数据，其格式和主要数据如下：

{% code-tabs %}
{% code-tabs-item title="person对象" %}
```javascript
{
    "name": "李四",    //姓名
    "genderType": "m", //性别， m为男性， f为女性， d未知
    "signature": "", //签名
    "description": "", //说明
    "employee": "1111", //员工号
    "unique": "lisi", //唯一标识
    "distinguishedName": "李四@lisi@P", //识别名
    "orderNumber": 14214946, //排序号
    "mail": "", //邮箱
    "weixin": "", //微信号
    "qq": "", //qq号码
    "mobile": "85252281460", //手机号码
    "officePhone": "", //办公电话
    "boardDate" : "", //入职日期
    "birthday" : "", //生日
    "age" : "", //年龄
    "qiyeweixinId" : "", //企业微信id
    "dingdingId" : "", //钉钉id
    "zhengwuDingdingId" //政务钉钉id
}
```
{% endcode-tabs-item %}
{% endcode-tabs %}

### listPersonWithRole

根据角色标识获取人员对象数组：person对象数组。

#### Syntax:

```javascript
var personList = this.org.listPersonWithRole( role, nested );
```

#### Arguments:

```javascript
> role :　（string JsonObject or array）必选。
可以是角色的distinguishedName、name、id、unique属性值，人员对象，或者是上述属性值和对象的数组。
> nested :　（boolean）可选，true嵌套的所有人员；false直接人员；默认false
```

{% code-tabs %}
{% code-tabs-item title="参数role示例" %}
```javascript
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
{% endcode-tabs-item %}
{% endcode-tabs %}

#### Return:

```javascript
> person array :　（Array）人员对象数组。
```

person对象为JSON格式数据，其格式和主要数据如下：

{% code-tabs %}
{% code-tabs-item title="person对象" %}
```javascript
{
    "name": "李四",    //姓名
    "genderType": "m", //性别， m为男性， f为女性， d未知
    "signature": "", //签名
    "description": "", //说明
    "employee": "1111", //员工号
    "unique": "lisi", //唯一标识
    "distinguishedName": "李四@lisi@P", //识别名
    "orderNumber": 14214946, //排序号
    "mail": "", //邮箱
    "weixin": "", //微信号
    "qq": "", //qq号码
    "mobile": "85252281460", //手机号码
    "officePhone": "", //办公电话
    "boardDate" : "", //入职日期
    "birthday" : "", //生日
    "age" : "", //年龄
    "qiyeweixinId" : "", //企业微信id
    "dingdingId" : "", //钉钉id
    "zhengwuDingdingId" //政务钉钉id
}
```
{% endcode-tabs-item %}
{% endcode-tabs %}

### listPersonWithIdentity

根据群组标识获取人员对象成员：person对象数组。

#### Syntax:

```javascript
var personList = this.org.listPersonWithIdentity( identity );
```

#### Arguments:

```text
> identity :　（string JsonObject or array）必选。
可以是身份的distinguishedName、name、id、unique属性值，身份对象，或者是上述属性值和对象的数组。
```

{% code-tabs %}
{% code-tabs-item title="参数identity示例" %}
```javascript
//以下均为合法参数
//身份属性值
"李四@23dd1b53-feed-485d-8c9c-1a4e64ff58a2@I" //身份识别名
"23dd1b53-feed-485d-8c9c-1a4e64ff58a2" //id
"lisi_i" //身份唯一标识
"李四" //名称

//对象
{ "distinguishedName": "李四@23dd1b53-feed-485d-8c9c-1a4e64ff58a2@I" } //身份识别名
{ "unique": "23dd1b53-feed-485d-8c9c-1a4e64ff58a2" } //身份唯一标识
{ "unique": "lisi_i" } //身份唯一标识
{ "name": "李四" } //名称对象

//上述属性组和对象数组
[ "张三", "李四" ] //名称数组
[ { "name": "李四" }, { "name": "张三" } ] //名称数组

...其他属性值或对象数组
```
{% endcode-tabs-item %}
{% endcode-tabs %}

#### Return:

```javascript
> person array :　（Array）人员对象数组。
```

person对象为JSON格式数据，其格式和主要数据如下：

{% code-tabs %}
{% code-tabs-item title="person对象" %}
```javascript
{
    "name": "李四",    //姓名
    "genderType": "m", //性别， m为男性， f为女性， d未知
    "signature": "", //签名
    "description": "", //说明
    "employee": "1111", //员工号
    "unique": "lisi", //唯一标识
    "distinguishedName": "李四@lisi@P", //识别名
    "orderNumber": 14214946, //排序号
    "mail": "", //邮箱
    "weixin": "", //微信号
    "qq": "", //qq号码
    "mobile": "85252281460", //手机号码
    "officePhone": "", //办公电话
    "boardDate" : "", //入职日期
    "birthday" : "", //生日
    "age" : "", //年龄
    "qiyeweixinId" : "", //企业微信id
    "dingdingId" : "", //钉钉id
    "zhengwuDingdingId" //政务钉钉id
}
```
{% endcode-tabs-item %}
{% endcode-tabs %}

### listPersonWithUnit

根据组织标识获取人员对象成员：person对象数组。 Syntax:

#### Syntax:

```javascript
var personList = this.org.listPersonWithUnit( unit );
```

#### Arguments:

```javascript
> unit :　（string JsonObject or array）必选。
可以是群组的distinguishedName、name、id、unique属性值，群组对象，或者是上述属性值和对象的数组。
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
> person array :　（Array）人员对象数组。
```

person对象为JSON格式数据，其格式和主要数据如下：

{% code-tabs %}
{% code-tabs-item title="person对象" %}
```javascript
{
    "name": "李四",    //姓名
    "genderType": "m", //性别， m为男性， f为女性， d未知
    "signature": "", //签名
    "description": "", //说明
    "employee": "1111", //员工号
    "unique": "lisi", //唯一标识
    "distinguishedName": "李四@lisi@P", //识别名
    "orderNumber": 14214946, //排序号
    "mail": "", //邮箱
    "weixin": "", //微信号
    "qq": "", //qq号码
    "mobile": "85252281460", //手机号码
    "officePhone": "", //办公电话
    "boardDate" : "", //入职日期
    "birthday" : "", //生日
    "age" : "", //年龄
    "qiyeweixinId" : "", //企业微信id
    "dingdingId" : "", //钉钉id
    "zhengwuDingdingId" //政务钉钉id
}
```
{% endcode-tabs-item %}
{% endcode-tabs %}

## 人员属性: personAttribute操作

### appendPersonAttribute

添加人员属性值\(在属性中添加values值，如果没有此属性，则创建一个\)

#### Syntax:

```javascript
this.org.appendPersonAttribute( person, attribute, valueArray);
```

#### Arguments:

```javascript
> person :　（string or JsonObject ）必选。
可以是人员的distinguishedName、name、id、unique属性值，人员对象。
> attribute :　（string）必选，属性名称
> valueArray :　（Array）必选，属性值，必须为数组
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
```
{% endcode-tabs-item %}
{% endcode-tabs %}

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
> person :　（string or JsonObject ）必选。
可以是人员的distinguishedName、name、id、unique属性值，人员对象。
> attribute:　（string）必选，属性名称
> valueArray:　（Array）必选，属性值，必须为数组
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
```
{% endcode-tabs-item %}
{% endcode-tabs %}

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
> person :　（string or JsonObject）必选。
可以是人员的distinguishedName、name、id、unique属性值，组织对象。
> attributeName :　（string）必选，属性名称
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
```
{% endcode-tabs-item %}
{% endcode-tabs %}

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
> person :　（string , JsonObject or array）必选。
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
> person :　（string , JsonObject or array）必选。
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
> personAttribute array :　（Array）人员属性对象数组。
```

personAttribute对象为JSON格式数据，其格式和主要数据如下：

{% code-tabs %}
{% code-tabs-item title="personAttribute对象" %}
```javascript
{
    "name": "住址",
    "person": "张三@zhangsan@P",
    "attributeList": [
        "杭州市","绍兴市"
    ]
}
```
{% endcode-tabs-item %}
{% endcode-tabs %}

## 组织信息: unit操作

### Method: getUnit

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












































