# 人员信息

**1.  获取人员信息：getPerson**

<table>
  <thead>
    <tr>
      <th style="text-align:left"><b>&#x51FD;&#x6570;&#x8BF4;&#x660E;</b>
      </th>
      <th style="text-align:left">var personObj = this.org.getPerson(name)</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left"><b>&#x53C2;&#x6570;&#x8BF4;&#x660E;</b>
      </td>
      <td style="text-align:left">name : &#xFF08;string&#xFF09;&#x5FC5;&#x9009;&#xFF0C;&#x4EBA;&#x5458;&#x7684;distinguishedName
        | id | unique | name</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x8FD4;&#x56DE;&#x503C;</b>
      </td>
      <td style="text-align:left">personObj &#x8FD4;&#x56DE;&#x4EBA;&#x5458;&#x7684;&#x5BF9;&#x8C61;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x811A;&#x672C;&#x793A;&#x4F8B;</b>
      </td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">
        <p>var personObj = this.org.getPerson(&quot;&#x6797;&#x73B2;@linling@P&quot;);</p>
        <p>return personObj.mobile;</p>
      </td>
      <td style="text-align:left"></td>
    </tr>
  </tbody>
</table>**2. 查询下级人员：listSubPerson**

<table>
  <thead>
    <tr>
      <th style="text-align:left"><b>&#x51FD;&#x6570;&#x8BF4;&#x660E;</b>
      </th>
      <th style="text-align:left">var person_array = this.org.listSubPerson (name,[true|false])</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left"><b>&#x53C2;&#x6570;&#x8BF4;&#x660E;</b>
      </td>
      <td style="text-align:left">
        <p>name : &#xFF08;string&#xFF09;&#x5FC5;&#x9009;&#xFF0C;&#x4EBA;&#x5458;&#x7684;distinguishedName
          | id | unique | name</p>
        <p>nested &#x5E03;&#x5C14; true&#x5D4C;&#x5957;&#x4E0B;&#x7EA7;&#xFF1B;false&#x76F4;&#x63A5;&#x4E0B;&#x7EA7;&#xFF1B;&#x9ED8;&#x8BA4;false&#xFF1B;</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x8FD4;&#x56DE;&#x503C;</b>
      </td>
      <td style="text-align:left">person_array &#x8FD4;&#x56DE;&#x4EBA;&#x5458;&#x7684;&#x5BF9;&#x8C61;&#x6570;&#x7EC4;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x811A;&#x672C;&#x793A;&#x4F8B;</b>
      </td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">var person_array = this.org.listSubPerson (&quot;&#x6797;&#x6797;@linlin@P&quot;);</td>
      <td
      style="text-align:left"></td>
    </tr>
  </tbody>
</table>**3. 查询上级人员：listSupPerson**

<table>
  <thead>
    <tr>
      <th style="text-align:left"><b>&#x51FD;&#x6570;&#x8BF4;&#x660E;</b>
      </th>
      <th style="text-align:left">var person_array = this.org.listSupPerson(name,[true|false])</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left"><b>&#x53C2;&#x6570;&#x8BF4;&#x660E;</b>
      </td>
      <td style="text-align:left">
        <p>name : &#xFF08;string&#xFF09;&#x5FC5;&#x9009;&#xFF0C;&#x4EBA;&#x5458;&#x7684;distinguishedName
          | id | unique | name</p>
        <p>nested &#x5E03;&#x5C14; true&#x5D4C;&#x5957;&#x4E0A;&#x7EA7;&#xFF1B;false&#x76F4;&#x63A5;&#x4E0A;&#x7EA7;&#xFF1B;&#x9ED8;&#x8BA4;false&#xFF1B;</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x8FD4;&#x56DE;&#x503C;</b>
      </td>
      <td style="text-align:left">person_array &#x8FD4;&#x56DE;&#x4EBA;&#x5458;&#x7684;&#x5BF9;&#x8C61;&#x6570;&#x7EC4;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x811A;&#x672C;&#x793A;&#x4F8B;</b>
      </td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">var person_array = this.org.listSupPerson(&quot;&#x6797;&#x6797;@linlin@P&quot;);</td>
      <td
      style="text-align:left"></td>
    </tr>
  </tbody>
</table>**4. 获取群组的所有人员：listPersonWithGroup**

| **函数说明** | var person\_array = this.org.listPersonWithGroup\(name\); |
| :--- | :--- |
| **参数说明** | name : （string）必选，群组名 |
| **返回值** | person\_array 返回人员的对象数组 |
| **脚本示例** |  |
| var person\_array = this.org.listPersonWithGroup \("人力组"\); |  |

5**. 获取角色的所有人员：listPersonWithRole**

| **函数说明** | var person\_array = this.org.listPersonWithRole\(name\); |
| :--- | :--- |
| **参数说明** | name : （string）必选，角色名 |
| **返回值** | person\_array 返回人员的对象数组 |
| **脚本示例** |  |
| var person\_array = this.org.listPersonWithRole\("Manager"\); |  |

**6.获取指定身份的所有人员：listPersonWithIdentity**

**函数说明**

| var person\_array = this.org.listPersonWithIdentity\(name\); |  |
| :--- | :--- |
| **参数说明** | name : （string）必选，身份唯一编码 |
| **返回值** | person\_array 返回人员的对象数组 |
| **脚本示例** |  |
| var person\_array = this.org.listPersonWithIdentity\("李杰@114849cc-eb77-4217-bd15-00b449acbdbb@I"\); |  |

**7. 查询组织成员的人员：listPersonWithUnit**

<table>
  <thead>
    <tr>
      <th style="text-align:left"><b>&#x51FD;&#x6570;&#x8BF4;&#x660E;</b>
      </th>
      <th style="text-align:left">var person_array = this.org.listPersonWithUnit (name,[true|false]);</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left"><b>&#x53C2;&#x6570;&#x8BF4;&#x660E;</b>
      </td>
      <td style="text-align:left">
        <p>name : &#xFF08;string&#xFF09;&#x5FC5;&#x9009;&#xFF0C;&#x7EC4;&#x7EC7;&#x7684;DN&#x6216;&#x8005;&#x552F;&#x4E00;&#x7F16;&#x7801;</p>
        <p>nested &#x5E03;&#x5C14; true&#x5D4C;&#x5957;&#x7684;&#x6240;&#x6709;&#x6210;&#x5458;&#xFF1B;false&#x76F4;&#x63A5;&#x6210;&#x5458;&#xFF1B;&#x9ED8;&#x8BA4;false&#xFF1B;</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x8FD4;&#x56DE;&#x503C;</b>
      </td>
      <td style="text-align:left">person_array &#x8FD4;&#x56DE;&#x4EBA;&#x5458;&#x7684;&#x5BF9;&#x8C61;&#x6570;&#x7EC4;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x811A;&#x672C;&#x793A;&#x4F8B;</b>
      </td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">
        <p>var name =&quot;&#x5185;&#x63A7;&#x7BA1;&#x7406;&#x90E8;@2462e85b-ebad-4cfe-b264-866e80c349bf@U&quot;;</p>
        <p>var person_array = this.org.listPersonWithUnit(name,true);</p>
      </td>
      <td style="text-align:left"></td>
    </tr>
  </tbody>
</table>