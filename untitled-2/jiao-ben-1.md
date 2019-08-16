# 脚本开发

1、表单引入脚本include

2、脚本方法定义 this.define\("xxx",function\(\){}.bind\(this\)\)

3、脚本系统服务调用

this.action\("xxx服务根"\)或者MWF.Actions.get\("xxxx服务根"\)；

例如：引入了cms的文档服务方法，删除，修改，取消发布等方法。

```javascript
var action = new this.Action("x_cms_assemble_control", {
      "del":{"uri": "/jaxrs/document/{id}", "method": "DELETE"},
      "change":{"uri": "/jaxrs/document/category/change", "method": "PUT"}, 
      "cancel":{"uri": "/jaxrs/document/publish/{id}/cancel", "method": "PUT"}
      }
     );
```

定义方法调用服务

```javascript
this.define("change",function(data,callback){ 
    action.invoke({"name": "change","data":data,"parameter": {},"async": true, 
    "success": function(json){
        if(callback)callback(json);
        }.bind(this)}); 
    }.bind(this)
```





