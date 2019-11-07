# 内容管理实例 - Object: documentContext

## 获取documentContext对象

你可以通过documentContext获取内容管理实例相关的对象数据。

### Syntax:

您可以在内容管理表单中，通过this来获取当前实例的documentContext对象，如下：

```javascript
var context = this.documentContext;
```

## 内容管理文档相关操作

### getDocument

获取当前内容管理实例的文档对象：document对象

#### Syntax:

```javascript
var doc = this.documentContext.getDocument();
```

#### Return:

```javascript
> document :　（Object）内容管理实例对象。
```

document对象为JSON格式数据，其格式和主要数据如下：

```javascript
{
    "creatorPersonShort": "XXX",        //创建人简称
    "creatorUnitNameShort": "开发部",   //创建人组织
    "creatorTopUnitNameShort": "浙江兰德纵横",  //创建人所在的顶层
    "id": "3359aedd-c2d8-4d8c-b8b0-02507da1b3f4",   //文档ID
    "summary": "",                                  //文档摘要
    "title": "航天科工外部董事调研组到培训中心调研",//文档标题
    "documentType": "信息",                         //文档类型
    "appId": "c295f34c-9ce1-4122-b795-820267e32b68",    //栏目的ID
    "appName": "通知公告",                              //栏目名称
    "categoryId": "33fb19f0-0670-464d-875c-32fb86148f7a",//分类ID
    "categoryName": "通知公告",                         //分类名称
    "categoryAlias": "通知公告-通知公告",               //分类别名
    "form": "dddefed4-4411-4e4e-b982-cdd4cd083443",     //表单ID
    "formName": "通知公告编辑表单",                     //表单名称
    "readFormId": "d6f1f596-fcb7-4a87-baaf-7f6cdafe3cec",   //阅读表单ID
    "readFormName": "通知公告阅读表单",                     //阅读表单名称
    "creatorPerson": "李义@liyi@P",                     //创建人
    "creatorIdentity": "李义@469d1601-c4a5-46ae-b7bf-4da9af07b6fa@I",   //创建人身份
    "creatorUnitName": "浙江兰德纵横@a706f5f0-4a3b-4785-8e1d-0a944bfad4eb@U",   //创建人组织全称
    "creatorTopUnitName": "浙江兰德纵横@a706f5f0-4a3b-4785-8e1d-0a944bfad4eb@U",//创建人顶层组织全称
    "docStatus": "published",                           //文档状态
    "publishTime": "2018-01-04 14:17:16",               //发布时间
    "readPersonList": [                                 //可读人员列表
        "李义@liyi@P",
        "所有人"
    ],
    "readUnitList": [],                                 //可读组织列表
    "readGroupList": [],                                //可读群组列表
    "authorPersonList": [                               //可编辑人员列表
        "李义@liyi@P"
    ],
    "authorUnitList": [],                               //可编辑组织列表
    "authorGroupList": [],                              //可编辑群组列表
    "managerList": [                                    //管理者列表
        "李义@liyi@P"
    ],
    "pictureList": []                                   //图片列表
}
```

### getControl

获取当前人对内容管理实例的权限。

#### Syntax:

```javascript
var doc = this.documentContext.getControl();
```

#### Return:

```javascript
> Object :　（Object）当前人对内容管理实例的所拥有的权限。
```

返回内容如下：

{% tabs %}
{% tab title="内容管理实例的权限" %}
```javascript
{
    "allowRead": true,              //是否允许阅读文档
    "allowPublishDocument": true,   //是否允许发布文档
    "allowSave": true,              //是否允许保存文档
    "allowPopularDocument": true,   //是否允许设置为热点
    "allowEditDocument": true,      //是否允许编辑文档
    "allowDeleteDocument": true     //是否允许删除文档
}
```
{% endtab %}
{% endtabs %}

### getAttachmentList

获取当前流程实例的附件对象列表。

#### Syntax:

```javascript
var attachmentList = this.documentContext.getAttachmentList();
```

#### Return:

```javascript
> Array of Object :　（array）当前流程实例的所有附件对象。
```

附件对象是一个JSON数组。每个对象的格式和主要数据如下：

{% tabs %}
{% tab title="附件对象" %}
```javascript
{
    "id": "a5cc5858-cac5-445a-a0a5-888d224eb2f6",   //附件ID
    "site": "attachment",                           //附件存储位置（一般用于区分附件在哪个表单元素中显示）
    "name": "13145352_115454884000_2.jpg",          //附件名称
    "appId": "c295f34c-9ce1-4122-b795-820267e32b68",  //栏目ID
    "categoryId": "33fb19f0-0670-464d-875c-32fb86148f7a",  //分类ID
    "documentId": "ca74cbef-2a7f-401a-80e3-577ac9839348",  //文档ID
    "creatorUid": "XX@huqi@P",                      //附件上传人
    "extension": "jpg",
    "length": 364507,                               //附件大小
},
```
{% endtab %}
{% endtabs %}

