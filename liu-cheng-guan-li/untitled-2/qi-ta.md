# 其他

1、门户页面跳转，参数传递

             this.page.toPage\("页面名称", {"keyword": “value”}\);

            获取： var par = this.page.parameters; //par的内容：{"type": "my type"}

2、使用系统内置组件模板

> ```javascript
> MWF.xDesktop.requireApp("Template", "MTooltips", null, false);var tt = new Class({    Extends: MTooltips,    _getHtml : function(){        var html =            "<table width='100%' bordr='0' cellpadding='7' cellspacing='0' style='margin:13px 13px 13px 13px;'>" +            "<tr><td width='70'>title:</td>" +            "    <td style=''>test</td></tr>" +            "<tr><td >time:</td>" +            "    <td style=''>2019-08-21</td></tr>" +            "</table>";        return html;    },   });var pc = new tt(this.form.getApp().content,this.target.node,this.form.app,{},{    axis : "x"});pc.create();
> ```

