# 常用事件脚本说明

表单的事件包含两种：一种是表单容器对应的DIV对象的DOM事件，一种是表单系统事件。 表单系统事件如下表：

  
表单系统事件如下表：

<table>
  <thead>
    <tr>
      <th style="text-align:left"><b>&#x4E8B;&#x4EF6;&#x540D;</b>
      </th>
      <th style="text-align:left"><b>&#x63CF;&#x8FF0;</b>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left">beforeLoad</td>
      <td style="text-align:left">&#x8868;&#x5355;&#x88AB;&#x8F7D;&#x5165;&#x4E4B;&#x524D;&#x6267;&#x884C;&#x3002;</td>
    </tr>
    <tr>
      <td style="text-align:left">
        <p>afterLoad</p>
        <p>load</p>
        <p>postLoad</p>
      </td>
      <td style="text-align:left">&#x8868;&#x5355;&#x88AB;&#x5B8C;&#x5168;&#x8F7D;&#x5165;&#x4E4B;&#x540E;&#x6267;&#x884C;</td>
    </tr>
    <tr>
      <td style="text-align:left">beforeSave</td>
      <td style="text-align:left">&#x5728;&#x7528;&#x6237;&#x70B9;&#x51FB;&#x201C;&#x4FDD;&#x5B58;&#x201D;&#x6309;&#x94AE;&#xFF0C;&#x6216;&#x6267;&#x884C;this.form.save&#x65B9;&#x6CD5;&#xFF0C;&#x800C;&#x6570;&#x636E;&#x6CA1;&#x6709;&#x771F;&#x6B63;&#x88AB;&#x4FDD;&#x5B58;&#x4E4B;&#x524D;&#x3002;&#x5728;&#x8868;&#x5355;&#x6267;&#x884C;&#x6D41;&#x8F6C;&#x7684;&#x8FC7;&#x7A0B;&#x4E2D;&#xFF0C;&#x4F1A;&#x5148;&#x5BF9;&#x8868;&#x5355;&#x6570;&#x636E;&#x8FDB;&#x884C;&#x4FDD;&#x5B58;&#xFF0C;&#x6240;&#x4EE5;&#x4E5F;&#x4F1A;&#x89E6;&#x53D1;beforeSave&#x4E8B;&#x4EF6;&#x3002;</td>
    </tr>
    <tr>
      <td style="text-align:left">afterSave</td>
      <td style="text-align:left">&#x5728;&#x7528;&#x6237;&#x70B9;&#x51FB;&#x201C;&#x4FDD;&#x5B58;&#x201D;&#x6309;&#x94AE;&#xFF0C;&#x6216;&#x6267;&#x884C;this.form.save&#x65B9;&#x6CD5;&#xFF0C;&#x6570;&#x636E;&#x88AB;&#x4FDD;&#x5B58;&#x6210;&#x529F;&#x4E4B;&#x540E;&#x3002;&#x5728;&#x8868;&#x5355;&#x6267;&#x884C;&#x6D41;&#x8F6C;&#x7684;&#x8FC7;&#x7A0B;&#x4E2D;&#xFF0C;&#x4F1A;&#x5148;&#x5BF9;&#x8868;&#x5355;&#x6570;&#x636E;&#x8FDB;&#x884C;&#x4FDD;&#x5B58;&#xFF0C;&#x6240;&#x4EE5;&#x4E5F;&#x4F1A;&#x89E6;&#x53D1;afterSave&#x4E8B;&#x4EF6;&#x3002;</td>
    </tr>
    <tr>
      <td style="text-align:left">beforeClose</td>
      <td style="text-align:left">&#x8868;&#x5355;&#x7A97;&#x53E3;&#x88AB;&#x5173;&#x95ED;&#x4E4B;&#x524D;&#x3002;</td>
    </tr>
    <tr>
      <td style="text-align:left">
        <p>submit</p>
        <p>beforeProcess</p>
      </td>
      <td style="text-align:left">&#x5728;&#x8868;&#x5355;&#x7EE7;&#x7EED;&#x6D41;&#x8F6C;&#x4E4B;&#x524D;&#x6267;&#x884C;&#xFF08;&#x5DF2;&#x7ECF;&#x586B;&#x5199;&#x610F;&#x89C1;&#x548C;&#x9009;&#x62E9;&#x51B3;&#x7B56;&#xFF09;&#x3002;&#x70B9;&#x51FB;&#x201C;&#x7EE7;&#x7EED;&#x6D41;&#x8F6C;&#x201D;&#x6309;&#x94AE;&#xFF0C;&#x6216;&#x6267;&#x884C;this.from.process&#x65B9;&#x6CD5;&#xFF0C;&#x90FD;&#x4F1A;&#x89E6;&#x53D1;&#x6B64;&#x4E8B;&#x4EF6;&#x3002;</td>
    </tr>
    <tr>
      <td style="text-align:left">beforeProcessWork</td>
      <td style="text-align:left">&#x5728;&#x8868;&#x5355;&#x7EE7;&#x7EED;&#x6D41;&#x8F6C;&#x4E4B;&#x524D;&#x6267;&#x884C;&#xFF0C;&#x4E0E;submit&#x548C;beforeProcess&#x4E0D;&#x540C;&#x7684;&#x662F;&#xFF0C;beforeProcessWork&#x662F;&#x5728;&#x586B;&#x5199;&#x610F;&#x89C1;&#x548C;&#x9009;&#x62E9;&#x51B3;&#x7B56;&#x7A97;&#x53E3;&#x5F39;&#x51FA;&#x4E4B;&#x524D;&#x6267;&#x884C;&#x7684;&#x3002;</td>
    </tr>
    <tr>
      <td style="text-align:left">afterProcess</td>
      <td style="text-align:left">&#x5728;&#x8868;&#x5355;&#x6267;&#x884C;&#x6D41;&#x8F6C;&#x6210;&#x529F;&#x4E4B;&#x540E;&#x6267;&#x884C;&#x3002;</td>
    </tr>
    <tr>
      <td style="text-align:left">beforeReset</td>
      <td style="text-align:left">&#x5728;&#x6267;&#x884C;&#x91CD;&#x7F6E;&#x5904;&#x7406;&#x4EBA;&#x64CD;&#x4F5C;&#x4E4B;&#x524D;&#x6267;&#x884C;&#x3002;</td>
    </tr>
    <tr>
      <td style="text-align:left">afterReset</td>
      <td style="text-align:left">&#x5728;&#x6267;&#x884C;&#x91CD;&#x7F6E;&#x5904;&#x7406;&#x4EBA;&#x64CD;&#x4F5C;&#x4E4B;&#x540E;&#x6267;&#x884C;&#x3002;</td>
    </tr>
  </tbody>
</table>| beforeRetract | 在执行撤回操作之前执行。 |
| :--- | :--- |
| afterRetract | 在执行撤回操作之后执行。 |
| beforeReroute | 在执行调度操作之前执行。 |
| afterReroute | 在执行调度操作之后执行。 |
| beforeModulesLoad | 在表单已载入,但表单中的元素未载入之时执行。 |
| afterModulesLoad | 在表单中的所有元素载入之后执行。实际执行时间与afterLoad、load、postLoad相同。 |
| resize | 在表单所在容器的大小发生变化时执行。 |
| beforeDelete | 在执行删除操作之前执行。 |

　　表单容器的DOM事件请参考相关HTML规范。可参考：  
 　　[MDN: HTMLDivElement](https://developer.mozilla.org/zh-CN/docs/Web/API/HTMLDivElement)

　　关于事件的详细编写方法，请参阅《O2OA开发API文档》。

