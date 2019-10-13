---
description: >-
  主要介绍前端API，代码示例及写法，同步API文档：http://www.o2oa.net/x_desktop/portal.html?id=dcd8e168-2da0-4496-83ee-137dc976c7f6
---

# 前端开发API

## 概述

* O2OA 是一个高度可定制化的企业级办公平台，您可以通过脚本语言扩展平台功能。
* O2OA 脚本基于Javascript语法，您可以通过脚本访问和操作允许的DOM对象；也可以通过平台定义的API操作业务数据、组织、视图等各种对象。脚本可以在后端（服务器端）和前端（浏览器端）执行。定义在流程中的脚本在后端执行；定义在表单等其他地方的脚本在前端执行。
* 后端脚本基于JDK8标准的Nashorn，遵循ECMAScript 5.1规范。前端脚本基于您使用的浏览器的Javascript引擎。



## API总览

| 对象 |  |  |
| :--- | :--- | :--- |
| 业务数据\(data\) | 流程实例\(workContext\) | 内容管理实例\(documentContext\) |
| 组织\(org\) | 流程表单\(form\) | 页面\(page\) |
| 视图\(view\) | 数据字典\(Dict\) | Action\(Action\) |
| 引用\(include\) | 方法定义\(define\) | session\(session\) |

| 服务 |  |
| :--- | :--- |
| x\_processplatform\_assemble\_surface | 流程平台相关服务 |
| x\_portal\_assemble\_surface | 门户平台相关服务 |
| x\_cms\_assemble\_control | 内容管理平台相关服务 |
| x\_query\_assemble\_surface | 数据平台相关服务 |
| x\_organization\_assemble\_express | 组织架构相关服务 |
| x\_file\_assemble\_control | 云文件相关服务 |
| x\_meeting\_assemble\_control | 会议管理相关服务 |
| x\_bbs\_assemble\_control | 论坛相关服务 |
| x\_calendar\_assemble\_control | 日程管理相关服务 |
| x\_hotpic\_assemble\_control | 热点信息相关服务 |
| x\_mind\_assemble\_control | 脑图模块相关服务 |
| x\_organization\_assemble\_personal | 个人设置相关服务 |
| x\_attendance\_assemble\_control.json | 考勤模块相关服务 |

## 嵌入脚本

　　• O2OA 可在多个位置嵌入脚本代码，用于扩展平台和实现自定义功能。嵌入脚本代码分为前端执行代码和服务端执行代码，两者语法一致，在某些方法和对象的调用上略微有所区别，在后续文档中会一一说明。　　可嵌入脚本位置和说明如下表：

<table>
  <thead>
    <tr>
      <th style="text-align:left"></th>
      <th style="text-align:left"></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left">
        <img src="http://www.o2oa.net:20020/x_portal_assemble_surface/jaxrs/file/f2b671f8-6363-4042-a6d8-083e53a514d3/portal/dcd8e168-2da0-4496-83ee-137dc976c7f6/content"
        alt/>
      </td>
      <td style="text-align:left">
        <p>&#x540D;&#x79F0;&#xFF1A; &#x8868;&#x5355;&#x548C;&#x9875;&#x9762;&#x5143;&#x7D20;&#x4E8B;&#x4EF6;</p>
        <p>&#x8BF4;&#x660E;&#xFF1A; &#x6D41;&#x7A0B;&#x5E73;&#x53F0;&#x548C;&#x5185;&#x5BB9;&#x5E73;&#x53F0;&#x7684;&#x8868;&#x5355;&#x548C;&#x95E8;&#x6237;&#x5E73;&#x53F0;&#x7684;&#x9875;&#x9762;&#x4E2D;&#xFF0C;&#x6BCF;&#x4E2A;&#x8BBE;&#x8BA1;&#x5143;&#x7D20;&#x5305;&#x542B;&#x591A;&#x79CD;&#x4E8B;&#x4EF6;&#xFF0C;&#x5305;&#x62EC;DOM&#x5BF9;&#x8C61;&#x539F;&#x751F;&#x4E8B;&#x4EF6;&#x548C;O2&#x5E73;&#x53F0;&#x6269;&#x5C55;&#x4E8B;&#x4EF6;&#x3002;</p>
        <p>&#x6267;&#x884C;&#xFF1A; &#x524D;&#x7AEF;&#x6267;&#x884C;&#xFF0C;&#x57FA;&#x4E8E;&#x6D4F;&#x89C8;&#x5668;</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left">
        <img src="http://www.o2oa.net:20020/x_portal_assemble_surface/jaxrs/file/7cd69211-9c0a-4714-871f-054a39f454b1/portal/dcd8e168-2da0-4496-83ee-137dc976c7f6/content"
        alt/>
      </td>
      <td style="text-align:left">
        <p>&#x540D;&#x79F0;&#xFF1A; &#x8868;&#x5355;&#x548C;&#x9875;&#x9762;&#x53EF;&#x7F16;&#x8F91;&#x5143;&#x7D20;&#x9ED8;&#x8BA4;&#x503C;</p>
        <p>&#x8BF4;&#x660E;&#xFF1A; &#x6D41;&#x7A0B;&#x5E73;&#x53F0;&#x548C;&#x5185;&#x5BB9;&#x5E73;&#x53F0;&#x7684;&#x8868;&#x5355;&#x548C;&#x95E8;&#x6237;&#x5E73;&#x53F0;&#x7684;&#x9875;&#x9762;&#x4E2D;&#xFF0C;&#x53EF;&#x7F16;&#x8F91;&#x5143;&#x7D20;&#x6216;&#x6587;&#x672C;&#x5143;&#x7D20;&#x7684;&#x9ED8;&#x8BA4;&#x503C;&#x53EF;&#x4EE5;&#x901A;&#x8FC7;&#x811A;&#x672C;&#x6307;&#x5B9A;&#x3002;</p>
        <p>&#x6267;&#x884C;&#xFF1A; &#x524D;&#x7AEF;&#x6267;&#x884C;&#xFF0C;&#x57FA;&#x4E8E;&#x6D4F;&#x89C8;&#x5668;</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left">
        <img src="http://www.o2oa.net:20020/x_portal_assemble_surface/jaxrs/file/d354fd74-488a-47b7-ae80-ee3ee4edfb6b/portal/dcd8e168-2da0-4496-83ee-137dc976c7f6/content"
        alt/>
      </td>
      <td style="text-align:left">
        <p>&#x540D;&#x79F0;&#xFF1A; &#x8868;&#x5355;&#x548C;&#x9875;&#x9762;&#x5143;&#x7D20;&#x7684;&#x90E8;&#x5206;&#x5C5E;&#x6027;</p>
        <p>&#x8BF4;&#x660E;&#xFF1A; &#x6D41;&#x7A0B;&#x5E73;&#x53F0;&#x548C;&#x5185;&#x5BB9;&#x5E73;&#x53F0;&#x7684;&#x8868;&#x5355;&#x548C;&#x95E8;&#x6237;&#x5E73;&#x53F0;&#x7684;&#x9875;&#x9762;&#x4E2D;&#xFF0C;&#x6709;&#x8BB8;&#x591A;&#x5143;&#x7D20;&#x7684;&#x76F8;&#x5173;&#x5C5E;&#x6027;&#x53EF;&#x4EE5;&#x901A;&#x8FC7;&#x811A;&#x672C;&#x6765;&#x5B9A;&#x4E49;&#x3002;&#x5982;&#xFF1A;&#x4E0B;&#x62C9;&#x6846;&#x3001;&#x5355;&#x9009;&#x591A;&#x9009;&#x6309;&#x94AE;&#x7684;&#x53EF;&#x9009;&#x503C;&#x3001;&#x4EBA;&#x5458;&#x5B57;&#x6BB5;&#x7684;&#x9009;&#x62E9;&#x8303;&#x56F4;&#x3001;&#x533A;&#x6BB5;&#x4F9D;&#x636E;&#x7B49;&#x3002;</p>
        <p>&#x6267;&#x884C;&#xFF1A; &#x524D;&#x7AEF;&#x6267;&#x884C;&#xFF0C;&#x57FA;&#x4E8E;&#x6D4F;&#x89C8;&#x5668;</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left">
        <img src="http://www.o2oa.net:20020/x_portal_assemble_surface/jaxrs/file/b5098409-32e3-45dc-a27d-a9c54863f2e6/portal/dcd8e168-2da0-4496-83ee-137dc976c7f6/content"
        alt/>
      </td>
      <td style="text-align:left">
        <p>&#x540D;&#x79F0;&#xFF1A; &#x8868;&#x5355;&#x53EF;&#x7F16;&#x8F91;&#x5143;&#x7D20;&#x6821;&#x9A8C;</p>
        <p>&#x8BF4;&#x660E;&#xFF1A; &#x6D41;&#x7A0B;&#x5E73;&#x53F0;&#x7684;&#x8868;&#x5355;&#x4E2D;&#xFF0C;&#x53EF;&#x7F16;&#x8F91;&#x7684;&#x5B57;&#x6BB5;&#x53EF;&#x4EE5;&#x901A;&#x8FC7;&#x811A;&#x672C;&#x8FDB;&#x884C;&#x6709;&#x6548;&#x6027;&#x6821;&#x9A8C;&#xFF0C;&#x6821;&#x9A8C;&#x901A;&#x8FC7;&#x8FD4;&#x56DE;true&#xFF0C;&#x4E0D;&#x901A;&#x8FC7;&#x8FD4;&#x56DE;&#x63D0;&#x793A;&#x4FE1;&#x606F;&#x3002;</p>
        <p>&#x6267;&#x884C;&#xFF1A; &#x524D;&#x7AEF;&#x6267;&#x884C;&#xFF0C;&#x57FA;&#x4E8E;&#x6D4F;&#x89C8;&#x5668;</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left">
        <img src="http://www.o2oa.net:20020/x_portal_assemble_surface/jaxrs/file/b866b3c0-77ac-4621-b80d-16afa6f0aeff/portal/dcd8e168-2da0-4496-83ee-137dc976c7f6/content"
        alt/>
      </td>
      <td style="text-align:left">
        <p>&#x540D;&#x79F0;&#xFF1A; &#x8868;&#x5355;&#x53EF;&#x7F16;&#x8F91;&#x5143;&#x7D20;&#x533A;&#x6BB5;&#x4F9D;&#x636E;</p>
        <p>&#x8BF4;&#x660E;&#xFF1A; &#x6D41;&#x7A0B;&#x5E73;&#x53F0;&#x7684;&#x8868;&#x5355;&#x4E2D;&#xFF0C;&#x53EF;&#x7F16;&#x8F91;&#x7684;&#x5B57;&#x6BB5;&#x53EF;&#x4F7F;&#x7528;&#x533A;&#x6BB5;&#x6570;&#x636E;&#xFF0C;&#x533A;&#x6BB5;&#x6570;&#x636E;&#x4F9D;&#x636E;&#x53EF;&#x901A;&#x8FC7;&#x8868;&#x5355;&#x6307;&#x5B9A;</p>
        <p>&#x6267;&#x884C;&#xFF1A; &#x524D;&#x7AEF;&#x6267;&#x884C;&#xFF0C;&#x57FA;&#x4E8E;&#x6D4F;&#x89C8;&#x5668;</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left">
        <img src="http://www.o2oa.net:20020/x_portal_assemble_surface/jaxrs/file/6233038b-daf1-4aba-8bc3-270a70c49a51/portal/dcd8e168-2da0-4496-83ee-137dc976c7f6/content"
        alt/>
      </td>
      <td style="text-align:left">
        <p>&#x540D;&#x79F0;&#xFF1A; &#x811A;&#x672C;</p>
        <p>&#x8BF4;&#x660E;&#xFF1A; &#x6D41;&#x7A0B;&#x5E73;&#x53F0;&#x3001;&#x95E8;&#x6237;&#x5E73;&#x53F0;&#x548C;&#x5185;&#x5BB9;&#x7BA1;&#x7406;&#x5E73;&#x53F0;&#x4E2D;&#xFF0C;&#x90FD;&#x6709;&#x811A;&#x672C;&#x8BBE;&#x8BA1;&#x5143;&#x7D20;&#xFF0C;&#x53EF;&#x4EE5;&#x5728;&#x6B64;&#x521B;&#x5EFA;&#x81EA;&#x5DF1;&#x7684;&#x811A;&#x672C;&#x5E93;&#x3002;</p>
        <p>&#x6267;&#x884C;&#xFF1A; &#x7531;&#x8C03;&#x7528;&#x811A;&#x672C;&#x4F4D;&#x7F6E;&#x51B3;&#x5B9A;&#x8FD0;&#x884C;&#x73AF;&#x5883;</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left"></td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left"></td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left"></td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left"></td>
      <td style="text-align:left"></td>
    </tr>
  </tbody>
</table>## 样例

　　• 这是一个简单的样例，用于展现脚本如何编写和运行。　　• 本例中我们要实现一个表单中，两个下拉框从配置数据中获取可选数据，以及实现联动。　　• 我们需要创建一个流程应用，一个表单以及一个数据字典。在表单中创建两个下拉列表框。　　1、先在表单中创建两个下拉框![](http://www.o2oa.net:20020/x_portal_assemble_surface/jaxrs/file/f928351f-79ff-40ca-bf70-88ce51f27219/portal/dcd8e168-2da0-4496-83ee-137dc976c7f6/content)　　2、在category1和category2两个下拉框的属性中，选择通过“脚本”编辑可选值。category1![](http://www.o2oa.net:20020/x_portal_assemble_surface/jaxrs/file/7fba0676-a8f3-47f9-a0ed-d91f288fc26f/portal/dcd8e168-2da0-4496-83ee-137dc976c7f6/content)category2![](http://www.o2oa.net:20020/x_portal_assemble_surface/jaxrs/file/17bb5d8a-a61d-4bdb-9e17-a5e2d1b4411b/portal/dcd8e168-2da0-4496-83ee-137dc976c7f6/content)　　3、在category1和category2两个下拉框的可选值脚本如下：　　category1的可选值脚本var dict = new this.Dict\("category"\); //获取名为category的数据字典var categoryList = dict.get\(\); //获取数据字典var options = Object.keys\(categoryList\); //获取大类，赋值给options变量options.unshift\("\(请选择大类\)\|"\); //在options数组首位插入提示选项，并将“”作为value，“\(请选择大类\)”作为textreturn options; //返回列表，作为列表框的可选值　　category2的可选值脚本var dict = new this.Dict\("category"\); //获取名为category的数据字典var categoryList = dict.get\(this.data.category1\); //获取数据字典,以下拉框category1的值为关键字的数据值（数组）return categoryList; //返回列表，作为列表框的可选值　　4、在category1的change事件中添加如下代码：//获category2下拉框，并刷新可选项this.form.get\("category2"\).resetOption\(\);　　5、设计数据字典如下图，并命名为："分类配置"，别名为：“category”。![](http://www.o2oa.net:20020/x_portal_assemble_surface/jaxrs/file/dbcd7b5c-e0c4-4c2c-a055-e7374a935364/portal/dcd8e168-2da0-4496-83ee-137dc976c7f6/content)　　6、预览表单，即可看到大类下拉框中选项为数据字典中的第一层数据，选择不同的大类可与小类下拉框实现联动。

















