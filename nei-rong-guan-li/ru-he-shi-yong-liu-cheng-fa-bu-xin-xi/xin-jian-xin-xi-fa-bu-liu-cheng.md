# 新建信息发布流程

![](../../.gitbook/assets/image%20%2838%29.png)

在流程最后增加一个服务调用节点，该节点作用是把流程数据传入到信息发布的通知公告中。如图配置相应的参数 REST地址：document/cipher/publish/content 配置消息体脚本：引用publishToCMS脚本，并设置消息体内容。

![](../../.gitbook/assets/image%20%2880%29.png)

```text
var data = this.getPublishData();
this.body.set(data);
```

在脚本配置中新建publishToCMS脚本，代码见

![](../../.gitbook/assets/image%20%2854%29.png)

```text
this.define("getPublishData", function(){
    
    var clone = function (obj) {
        if (null === obj || "object" != typeof obj) return obj;
        
        if ( typeof obj.length==='number'){ //数组
            //print( "array" );
            var copy = [];
            for (var i = 0, len = obj.length; i < len; ++i) {
                copy[i] = clone(obj[i]);
            }
            return copy;
        }else{
            var copy = {};
            for (var attr in obj) { 
                copy[attr] = clone(obj[attr]);
            }
            return copy;
        }
    };
    
    var removeHTMLTag = function(str) {
        str = str.replace(/<\/?[^>]*>/g,''); //去除HTML tag
        str = str.replace(/[ | ]*\n/g,'\n'); //去除行尾空白
        //str = str.replace(/\n[\s| | ]*\r/g,'\n'); //去除多余空行
        str=str.replace(/&nbsp;/ig,'');//去掉&nbsp;
        str=str.replace(/\s/g,''); //将空格去掉
        return str;
    };
  
    
    var document = clone( this.data.cmsDocument ); 
    var data = clone( this.data );
    
    var work = this.workContext.getWork();
    
    data.formProcess = true;
    
    delete document.attachmentList;
    document.subject = data.subject;
    document.title = data.subject;
    
    document.wf_workId = work.id;
    document.wf_jobId = work.job;
    
    document.pictureList = [];
    if( data.imageclipper ){
        document.pictureList.push( data.imageclipper );
    }
    
    document.summary = "";
    if( data.htmleditor ){
        var text = removeHTMLTag( data.htmleditor );
        document.summary = text.substr(0,85);
    }
    
    var attachmentList = this.workContext.getAttachmentList();
    var attachmentIds = [];
    for( var i=0, len=attachmentList.length; i<len; ++i ){
        attachmentIds.push( attachmentList[i].id );
    }
    document.wf_attachmentIds = attachmentIds;
    
    
    var cnArray = ["组织","群组","人员","人员","角色"];
    var keyArray = ["U","G","I","P","R"];
    var result = [];
    print( "data.publishFor.length="+data.publishFor.length );
    if( typeOf(data.publishFor) == "array" && data.publishFor.length > 0){
        for( var i=0; i<data.publishFor.length; i++ ){
            var publishFor = data.publishFor[i];
            var dn = typeOf( publishFor ) === "string" ? publishFor : publishFor.distinguishedName;
            var index = keyArray.indexOf(dn.substr(dn.length-1, 1))
            if( index > -1 ){
                result.push({
                    permission : "阅读",
                    permissionObjectType : cnArray[ index ],
                    permissionObjectName : dn
                });
            }
        }
    }
    print( JSON.stringify(result) )
    
    var owners = [];
    if( result.length > 0 ){
        var taskCompletedList = this.workContext.getTaskCompletedList();
        for(var i=0, len=taskCompletedList.length; i<len; ++i){
            var taskCompleted = taskCompletedList[i];
            if(taskCompleted.person){
                owners.push( taskCompleted.person );
            }
        }
        if( owners.length > 0 ){
            for(var i=0, len=owners.length; i<len; ++i){
                result.push({
                    permission : "阅读",
                    permissionObjectType : "人员",
                    permissionObjectName : owners[i]
                });
            }
        }
    }

    document.permissionList = result;
    
    data.processOwnerList = owners;
    document.docData = data;
    
    return document;
}.bind(this));

```

示例表单如下：

![](../../.gitbook/assets/image%20%28110%29.png)

