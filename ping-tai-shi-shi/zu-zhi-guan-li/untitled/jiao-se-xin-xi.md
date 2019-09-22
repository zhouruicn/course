# 角色信息

### **1.  获取角色信息：getRole**

<table>
  <thead>
    <tr>
      <th style="text-align:left"><b>&#x51FD;&#x6570;&#x8BF4;&#x660E;</b>
      </th>
      <th style="text-align:left">var roleObj= this.org.getRole(name);</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left"><b>&#x53C2;&#x6570;&#x8BF4;&#x660E;</b>
      </td>
      <td style="text-align:left">name : &#xFF08;string&#xFF09;&#x5FC5;&#x9009;&#xFF0C;&#x89D2;&#x8272;&#x540D;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x8FD4;&#x56DE;&#x503C;</b>
      </td>
      <td style="text-align:left">roleObj: &#x8FD4;&#x56DE;&#x89D2;&#x8272;&#x7684;&#x5BF9;&#x8C61;&#x6570;&#x7EC4;&#x3002;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x811A;&#x672C;&#x793A;&#x4F8B;</b>
      </td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">
        <p>var name = &quot;Manager&quot;;</p>
        <p>var roleObj = this.org.getRole (name);</p>
        <p>return roleObj.distinguishedName;</p>
      </td>
      <td style="text-align:left"></td>
    </tr>
  </tbody>
</table>### ２. 人员所有角色（嵌套）：listRoleWithPerson

| **函数说明** | var roleObj= this.org.listRoleWithPerson \(name\); |
| :--- | :--- |
| **参数说明** | name : （string）必选，个人 |
| **返回值** | roleObj: 返回角色的对象数组。 |
| **脚本示例** |  |
| var roleObj = this.org.listRoleWithPerson \(“李杰@lijie@P”\); |  |

### **３. 人员是否拥有角色：personHasRole**

<table>
  <thead>
    <tr>
      <th style="text-align:left"><b>&#x51FD;&#x6570;&#x8BF4;&#x660E;</b>
      </th>
      <th style="text-align:left">var roleObj= this.org.personHasRole(name,role)</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left"><b>&#x53C2;&#x6570;&#x8BF4;&#x660E;</b>
      </td>
      <td style="text-align:left">
        <p>name : &#xFF08;string&#xFF09;&#x5FC5;&#x9009;&#xFF0C;&#x4EBA;&#x5458;&#x7684;distinguishedName
          | id | unique | name</p>
        <p>Role&#xFF1A;&#x89D2;&#x8272;&#x540D;</p>
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
      <td style="text-align:left">
        <p>var hasRole = this.org. personHasRole(&quot;&#x6797;&#x6797;@linlin@P&quot;,&quot;Manager&quot;);</p>
        <p>return hasRole;</p>
      </td>
      <td style="text-align:left"></td>
    </tr>
  </tbody>
</table>