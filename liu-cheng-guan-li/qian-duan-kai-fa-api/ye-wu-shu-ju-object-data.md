---
description: >-
  data对象是流程平台中，流程实例的业务数据，以及内容管理平台中，实例的业务数据，这些数据一般情况下是通过您创建的表单收集而来的，也可以通过脚本创建和增删改查。
---

# 业务数据 - Object: data

data对象基本上是一个JSON对象，您可以用访问JSON对象的方法访问他对象的所有数据，但增加和删除数据时略有不同。

您可以在表单或流程的各个嵌入脚本中，通过this来获取当前实例的业务数据，如下：

```javascript
var data = this.data;
```

## 业务数据相关操作

### \[property\]

访问或修改data对象的数据。 

data数据用于存储表单获取的数据，所有属性都是动态的，其格式和访问方式都和JSON类似。在表单脚本中使用data对象，实现了data和表单可编辑元素的双向绑定。改变data对象，会自动更新表单元素，修改表单可编辑元素，也会自动修改data对象。

#### Syntax:

{% tabs %}
{% tab title="Syntax:" %}
```javascript
var value = this.data.property;  //获取名为property的数据值this.data.property = '123';   //将property的值修改为'123'
```
{% endtab %}
{% endtabs %}

#### Return:

> any : 任何数据类型。

#### Examples 1:

获取流程文档的subject值：

{% tabs %}
{% tab title="获取流程文档的subject值：" %}
```javascript
var subject = this.data.subject; 
```
{% endtab %}
{% endtabs %}

#### Examples 2:

获取流程文档中的数据网格的值：

如有以下数据网格：

![](http://www.o2oa.net:20020/x_portal_assemble_surface/jaxrs/file/f39a1d05-31c9-44a8-ac87-616372ba7cd5/portal/dcd8e168-2da0-4496-83ee-137dc976c7f6/content)

其数据网格设计如下\(数据网格id为：datagrid\)：

![](http://www.o2oa.net:20020/x_portal_assemble_surface/jaxrs/file/91e0517b-90f5-4bf9-a87b-c3852c8bc747/portal/dcd8e168-2da0-4496-83ee-137dc976c7f6/content)

使用下面的脚本：

```javascript
var data = this.data.datagrid; 
```

获取到data的值如下：

```javascript
{    "data": [        {            "amountCol": { "amount": "12000" },            "countCol": { "number": "10" },            "nameCol": { "name": "手机" },            "priceCol": { "price": "1200" }        },        {            "amountCol": { "amount": "15000" },            "countCol": { "number": "5" },            "nameCol": { "name": "电脑" },            "priceCol": { "price": "3000" }        }    ],    "total": {        "amountCol": "27000",        "countCol": "15"    }}
```

获取到数据网格中的其他数据：

```javascript
//获取数据网格中的第一条数据var data = this.data.datagrid.data[0];//获取数据网格中的第一条数据的 nameCol 列的值var data = this.data.datagrid.data[0].nameCol.name;//获取数据网格中的 amountCol 列的总计值var data = this.data.datagrid.total.amountCol; 
```

修改数据网格中的数据：

```javascript
//修改数据网格中的第一条数据的 nameCol 列的值this.data.datagrid.data[0].nameCol.name='平板电脑'; 
```

修改后数据网格中的数据为：

![](http://www.o2oa.net:20020/x_portal_assemble_surface/jaxrs/file/65a2c334-85cf-4304-8c2f-bf858109640f/portal/dcd8e168-2da0-4496-83ee-137dc976c7f6/content)

### add

为data对象添加一个数据节点。

#### Syntax:

{% tabs %}
{% tab title="Syntax:" %}
```javascript
var newData = this.data.add(key, value, overwrite);
```
{% endtab %}
{% endtabs %}

#### Arguments:

```javascript
> key :　（string or number）必选，要添加的新的数据节点名称或数组索引号> value :　（string, number, array or JsonObject）必选，新的数据节点的值> overwrite :　（boolean）可选，如果要添加的节点已经存在，是否覆盖。默认为 false
```

#### Return:

```text
> any :　新添加的数据节点或原有的同名节点。
```

#### Examples:

```javascript
//为data添加一个名为"remark"值为"I am remark"的数据this.data.add("remark", "I am remark");//-------------------------------------------------------------------//为data添加一个名为"person"的Object对象数据var person = this.data.add("person", {});person.add("name", "Tom");person.add("age", 23);//或者可以这样var person = this.data.add("person", {name: "Tom", "age": "23"});//-------------------------------------------------------------------//为data添加一个名为"orders"的数组对象数据var orders = this.data.add("orders", []);orders.add({name: "phone", count: 5});orders.add({name: "computer", count: 10});orders[0].add("count", 10, true);  //将第一条数据的count修改为10//或者可以这样var orders = this.data.add("orders", [    {name: "phone", count: 5},    {name: "computer", count: 10}]);//将第一条数据修改为name为mobile; count为10orders.add(0, {name: "mobile", count: 10}, true);
```

### del

删除data对象中一个指定的数据节点。

#### Syntax:

```javascript
var data = this.data.del(key);
```

#### Arguments:

```javascript
> key :　（string or number）必选，要删除的数据节点名称或数组索引号
```

#### Return:

```javascript
> data :　被删除数据节点的父节点
```

#### Examples:

```javascript
//删除data下名为"remark"的数据节点this.data.del("remark");//-------------------------------------------------------------------//删除"person"的age数据节点var person = this.data.add.person.del("age");//-------------------------------------------------------------------//删除"orders"数组对象中的第二条数据this.data.orders.del(1);
```

### save

保存data对象

#### Syntax:

```javascript
this.data.save(callback);
```

#### Arguments:

```javascript
> callback :　（function）可选，保存成功后的回调函数
```

#### Return:

```text
没有返回值
```

#### Examples:

```javascript
this.data.save(function(json){    this.form.notice("save success!", "success")});
```







































