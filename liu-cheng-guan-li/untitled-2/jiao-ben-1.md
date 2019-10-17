# 脚本开发

1、表单引入脚本include

```javascript
this.include("initScript") //脚本配置的名称、别名或id

//如果需要引用其他应用的脚本配置，将options设置为JsonObject
this.include({
    type : "portal", //应用类型。可以为 portal  process  cms。如果没有该选项或者值为空字符串，则表示应用脚本和被应用的脚本配置类型相同；比如在门户的A应用脚本中引用门户B应用的脚本配置，则type可以省略。
    application : "首页", // 门户、流程、CMS的名称、别名、id。 默认为当前应用
    name : "initScript" // 脚本配置的名称、别名或id
})
```

2、脚本方法定义 this.define\("xxx",function\(\){}.bind\(this\)\)

3、脚本系统服务调用

接口地址：

[http://dev.o2oa.net:20030/x\_program\_center/jest/list.html](http://dev.o2oa.net:20030/x_program_center/jest/list.html)

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

或者也可以直接调用系统内置的方法例如

```javascript
MWF.Actions.get("x_cms_assemble_control").getDocument(id,function(json){
    //code
}.bind(this))
```

getDocument是系统中已经定义的方法，具体可以查看服务调用文件o2\_core/o2/xAction/service目录下的服务文件

4、操作嵌入视图数据

5、服务调用实现翻页

```javascript
var action = new this.Action("x_cms_assemble_control", {
    "del":{"uri": "/jaxrs/document/{id}", "method": "DELETE"},
    "change":{"uri": "/jaxrs/document/category/change", "method": "PUT"},
    "cancel":{"uri": "/jaxrs/document/publish/{id}/cancel", "method": "PUT"},
    // 获取未读消息
    "info":{"uri": "/jaxrs/viewrecord/unread", "method": "PUT"},
    // 获取文档
    "list":{"uri": "/jaxrs/document/filter/list/{id}/next/{count}", "method": "PUT"},
    "publish":{"uri": "/jaxrs/document/publish/content", "method": "PUT"},
});

this.data.add("curid","(0)");
this.data.add("pageCount","10");

this.define("loadList",function(id,count,data,callback){ 
    action.invoke({"name": "list","parameter":{"id":id,"count":count},"data":data,"async": true, "success": function(json){if(callback)callback(json);}.bind(this)});
}.bind(this));

this.define("showList",function(json){
    //alert(JSON.stringify(json));
    var content = this.form.get("content").node;
    json.data.each(function(data){
        new Element("div",{text:data.title}).inject(content);
    }.bind(this))
}.bind(this))
```

6、引入外部js框架，例如jquery

```javascript
 o2.load("/o2_lib/jquery/jquery.min.js",function(){
        var jq = jQuery.noConflict(true);
        //alert(jq("#aaa").find("input").val())
        jq(document).ready(function(){
            //window.setTimeout(function(){ 
                var tab = jq("table");
                var tr = tab.find("tr"); 
                tr.mouseover(function(){
                    jq(this).css("background-color","#ff0")
                });
                tr.mouseout(function(){
                    jq(this).css("background-color","")
                })
            //},2000);
            
        })
    }.bind(this))
```

