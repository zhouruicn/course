# 视图

视图创建

视图查询

```text
//获取“财务管理”应用中“报销审批数据”视图中的数据
this.view.lookup({
    "view": "报销审批数据",
    "application": "财务管理",
    "filter": [
        {
            "logic":"and",
            "path":"$work.title",
            "comparison":"like",
            "value":"7月",
            "formatType":"textValue"
        }
    ]
}, function(data){
    var result = data.grid; //得到过滤后的数据
    //......
});
```

