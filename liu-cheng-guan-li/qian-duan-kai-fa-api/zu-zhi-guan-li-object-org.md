# 组织管理 - Object: org

## 获取组织管理org对象

你可以通过org获取组织中的人员、人员属性、组织、组织属性、身份、群组和角色。

### Syntax:

您可以在流程表单、内容管理表单和门户页面中，通过this来获取当前实例的org对象，如下：

```javascript
var org = this.org;
```

## 人员: person 相关操作API

### Method: getPerson

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

### Method: listSubPerson

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

### Method: listSupPerson

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

















