# 群组信息

### **1. 获取群组的对象数组：getGroup**

<table>
  <thead>
    <tr>
      <th style="text-align:left"><b>&#x51FD;&#x6570;&#x8BF4;&#x660E;</b>
      </th>
      <th style="text-align:left">var groupObj = this.org.getGroup(name);</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left"><b>&#x53C2;&#x6570;&#x8BF4;&#x660E;</b>
      </td>
      <td style="text-align:left">name : (string)&#x5FC5;&#x9009;&#xFF0C;&#x7FA4;&#x7EC4;&#x540D;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x8FD4;&#x56DE;&#x503C;</b>
      </td>
      <td style="text-align:left">groupArray: &#x8FD4;&#x56DE;&#x7FA4;&#x7EC4;&#x7684;&#x5BF9;&#x8C61;&#x6570;&#x7EC4;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x811A;&#x672C;&#x793A;&#x4F8B;</b>
      </td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">
        <p>var name = &quot;&#x4EBA;&#x529B;&#x7EC4;&quot;;</p>
        <p>var groupObj = this.org.getGroup(name);</p>
        <p>return groupObj.distinguishedName;</p>
      </td>
      <td style="text-align:left"></td>
    </tr>
  </tbody>
</table>### **２. 查询下级群组列表：listSubGroup**

<table>
  <thead>
    <tr>
      <th style="text-align:left"><b>&#x51FD;&#x6570;&#x8BF4;&#x660E;</b>
      </th>
      <th style="text-align:left">var groupObj = this.org.listSubGroup (name, [true|false]);</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left"><b>&#x53C2;&#x6570;&#x8BF4;&#x660E;</b>
      </td>
      <td style="text-align:left">
        <p>name : &#xFF08;string&#xFF09;&#x5FC5;&#x9009;&#xFF0C;&#x7FA4;&#x7EC4;&#x540D;</p>
        <p>nested &#x5E03;&#x5C14; true&#x5D4C;&#x5957;&#x4E0B;&#x7EA7;&#xFF1B;false&#x76F4;&#x63A5;&#x4E0B;&#x7EA7;&#xFF1B;&#x9ED8;&#x8BA4;false&#xFF1B;</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x8FD4;&#x56DE;&#x503C;</b>
      </td>
      <td style="text-align:left">groupArray: &#x8FD4;&#x56DE;&#x7FA4;&#x7EC4;&#x7684;&#x5BF9;&#x8C61;&#x6570;&#x7EC4;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x811A;&#x672C;&#x793A;&#x4F8B;</b>
      </td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">
        <p>var name = &quot;&#x4EBA;&#x529B;&#x7EC4;&quot;;</p>
        <p>var groupObj= this.org. listSubGroup (name, true);</p>
        <p>if(groupObj.length&lt;1){</p>
        <p>return &quot;&quot;;</p>
        <p>} else {</p>
        <p>return groupObj[0].unique;</p>
        <p>}</p>
      </td>
      <td style="text-align:left"></td>
    </tr>
  </tbody>
</table>### **３. 查询上级群组列表：listSupGroup**

<table>
  <thead>
    <tr>
      <th style="text-align:left"><b>&#x51FD;&#x6570;&#x8BF4;&#x660E;</b>
      </th>
      <th style="text-align:left">var groupObj = this.org.listSupGroup(name, [true|false]);</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left"><b>&#x53C2;&#x6570;&#x8BF4;&#x660E;</b>
      </td>
      <td style="text-align:left">
        <p>name : &#xFF08;string&#xFF09;&#x5FC5;&#x9009;&#xFF0C;&#x7FA4;&#x7EC4;&#x540D;</p>
        <p>nested &#x5E03;&#x5C14; true&#x5D4C;&#x5957;&#x4E0A;&#x7EA7;&#xFF1B;false&#x76F4;&#x63A5;&#x4E0A;&#x7EA7;&#xFF1B;&#x9ED8;&#x8BA4;false&#xFF1B;</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x8FD4;&#x56DE;&#x503C;</b>
      </td>
      <td style="text-align:left">groupArray: &#x8FD4;&#x56DE;&#x7FA4;&#x7EC4;&#x7684;&#x5BF9;&#x8C61;&#x6570;&#x7EC4;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x811A;&#x672C;&#x793A;&#x4F8B;</b>
      </td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">var groupObj = this.org.listSupGroup(&quot;&#x4EBA;&#x529B;&#x7EC4;&quot;,true)</td>
      <td
      style="text-align:left"></td>
    </tr>
  </tbody>
</table>４**. 查询人员所在群组（嵌套）：listGroupWithPerson**

<table>
  <thead>
    <tr>
      <th style="text-align:left"><b>&#x51FD;&#x6570;&#x8BF4;&#x660E;</b>
      </th>
      <th style="text-align:left">var groupObj = this.org.this.org.listGroupWithPerson(name, [true|false]);</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left"><b>&#x53C2;&#x6570;&#x8BF4;&#x660E;</b>
      </td>
      <td style="text-align:left">
        <p>name : &#xFF08;string&#xFF09;&#x5FC5;&#x9009;&#xFF0C;&#x7FA4;&#x7EC4;&#x540D;</p>
        <p>nested &#x5E03;&#x5C14; true&#x5D4C;&#x5957;&#x4E0B;&#x7EA7;&#xFF1B;false&#x76F4;&#x63A5;&#x4E0B;&#x7EA7;&#xFF1B;&#x9ED8;&#x8BA4;false&#xFF1B;</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x8FD4;&#x56DE;&#x503C;</b>
      </td>
      <td style="text-align:left">groupArray: &#x8FD4;&#x56DE;&#x7FA4;&#x7EC4;&#x7684;&#x5BF9;&#x8C61;&#x6570;&#x7EC4;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x811A;&#x672C;&#x793A;&#x4F8B;</b>
      </td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">var groupObj = this.org.listGroupWithPerson (&quot;&#x4EBA;&#x529B;&#x7EC4;&quot;,true)</td>
      <td
      style="text-align:left"></td>
    </tr>
  </tbody>
</table>### **５. 群组是否拥有角色：groupHasRole**

<table>
  <thead>
    <tr>
      <th style="text-align:left"><b>&#x51FD;&#x6570;&#x8BF4;&#x660E;</b>
      </th>
      <th style="text-align:left">var groupObj = this.org.groupHasRole (name, role);</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left"><b>&#x53C2;&#x6570;&#x8BF4;&#x660E;</b>
      </td>
      <td style="text-align:left">
        <p>name : &#xFF08;string&#xFF09;&#x5FC5;&#x9009;&#xFF0C;&#x7FA4;&#x7EC4;&#x540D;</p>
        <p>role&#x9700;&#x8981;&#x67E5;&#x8BE2;&#x7684;&#x89D2;&#x8272;&#x540D;&#x79F0;</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x8FD4;&#x56DE;&#x503C;</b>
      </td>
      <td style="text-align:left">true, false</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x811A;&#x672C;&#x793A;&#x4F8B;</b>
      </td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">this.org.groupHasRole (&quot;&#x4EBA;&#x529B;&#x7EC4;&quot;, &quot;Manager&quot;);</td>
      <td
      style="text-align:left"></td>
    </tr>
  </tbody>
</table>