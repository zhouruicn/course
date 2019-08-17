# 组织信息

###  **1.查询组织的下级：listSubUnit函数说明**

<table>
  <thead>
    <tr>
      <th style="text-align:left">var unitList=this.org.listSubUnit (name,[true|false]);</th>
      <th style="text-align:left"></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left"><b>&#x53C2;&#x6570;&#x8BF4;&#x660E;</b>
      </td>
      <td style="text-align:left">
        <p>name : &#xFF08;String|Array&#xFF09;&#x5FC5;&#x9009;&#xFF0C;&#x7EC4;&#x7EC7;&#x552F;&#x4E00;&#x7F16;&#x7801;</p>
        <p>nested &#x5E03;&#x5C14; true&#x5D4C;&#x5957;&#x4E0B;&#x7EA7;&#xFF1B;false&#x76F4;&#x63A5;&#x4E0B;&#x7EA7;&#xFF1B;&#x9ED8;&#x8BA4;false</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x8FD4;&#x56DE;&#x503C;</b>
      </td>
      <td style="text-align:left">unitArray &#x8FD4;&#x56DE;&#x7EC4;&#x7EC7;&#x7684;&#x5BF9;&#x8C61;&#x6570;&#x7EC4;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x811A;&#x672C;&#x793A;&#x4F8B;</b>
      </td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">
        <p>var dn = &quot;&#x4EBA;&#x793E;&#x4E8B;&#x4E1A;&#x90E8;@e0c84b01-ef35-482f-946b-93e040848af5@U&quot;;</p>
        <p>var unitArray = this.org.listSubUnit(dn);</p>
        <p>return unitArray.length;</p>
      </td>
      <td style="text-align:left"></td>
    </tr>
  </tbody>
</table>### 2.  **查询组织的上级：listSupUnit**

<table>
  <thead>
    <tr>
      <th style="text-align:left"><b>&#x51FD;&#x6570;&#x8BF4;&#x660E;</b>
      </th>
      <th style="text-align:left">var unitList=this.org.listSupUnit(name,[true|false]);</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left"><b>&#x53C2;&#x6570;&#x8BF4;&#x660E;</b>
      </td>
      <td style="text-align:left">
        <p>name : &#xFF08;String|Array&#xFF09;&#x5FC5;&#x9009;&#xFF0C;&#x7EC4;&#x7EC7;&#x552F;&#x4E00;&#x7F16;&#x7801;</p>
        <p>nested &#x5E03;&#x5C14; true&#x5D4C;&#x5957;&#x4E0A;&#x7EA7;&#xFF1B;false&#x76F4;&#x63A5;&#x4E0A;&#x7EA7;&#xFF1B;&#x9ED8;&#x8BA4;false</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x8FD4;&#x56DE;&#x503C;</b>
      </td>
      <td style="text-align:left">unitArray &#x8FD4;&#x56DE;&#x7EC4;&#x7EC7;&#x7684;&#x5BF9;&#x8C61;&#x6570;&#x7EC4;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x811A;&#x672C;&#x793A;&#x4F8B;</b>
      </td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">
        <p>var dn = &quot;&#x4EBA;&#x793E;&#x4E8B;&#x4E1A;&#x90E8;@e0c84b01-ef35-482f-946b-93e040848af5@U&quot;;</p>
        <p>var unitArray = this.org.listSupUnit(dn);</p>
        <p>return unitArray.length;</p>
      </td>
      <td style="text-align:left"></td>
    </tr>
  </tbody>
</table>### **3.根据个人身份获取组织：getUnitByIdentity**

<table>
  <thead>
    <tr>
      <th style="text-align:left"><b>&#x51FD;&#x6570;&#x8BF4;&#x660E;</b>
      </th>
      <th style="text-align:left">var unitList=this.org.getUnitByIdentity (name,flag);</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left"><b>&#x53C2;&#x6570;&#x8BF4;&#x660E;</b>
      </td>
      <td style="text-align:left">
        <p>name : &#xFF08;String|Array&#xFF09;&#x5FC5;&#x9009;&#xFF0C;&#x4E2A;&#x4EBA;&#x552F;&#x4E00;&#x7F16;&#x7801;</p>
        <p>flag&#xFF1A;</p>
        <p>&#x6570;&#x5B57; -- &#x8868;&#x793A;&#x83B7;&#x53D6;&#x7B2C;&#x51E0;&#x5C42;&#x7684;&#x7EC4;&#x7EC7;</p>
        <p>&#x5B57;&#x7B26;&#x4E32; -- &#x8868;&#x793A;&#x83B7;&#x53D6;&#x6307;&#x5B9A;&#x7C7B;&#x578B;&#x7684;&#x7EC4;&#x7EC7;</p>
        <p>&#x7A7A;&#x5B57;&#x7B26;&#x4E32; -- &#x8868;&#x793A;&#x83B7;&#x53D6;&#x76F4;&#x63A5;&#x6240;&#x5728;&#x7684;&#x7EC4;&#x7EC7;</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x8FD4;&#x56DE;&#x503C;</b>
      </td>
      <td style="text-align:left">unitArray &#x8FD4;&#x56DE;&#x7EC4;&#x7EC7;&#x7684;&#x5BF9;&#x8C61;&#x6570;&#x7EC4;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x811A;&#x672C;&#x793A;&#x4F8B;</b>
      </td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">
        <p>var dn = &quot;&#x674E;&#x4E49;@5d10c11e-54cd-458d-9c34-5ba1a371a4d9@I&quot;;</p>
        <p>var unitArray = this.org.getUnitByIdentity(dn, &quot;&#x4E00;&#x7EA7;&#x90E8;&#x95E8;&quot;);</p>
        <p>return unitArray.name;</p>
      </td>
      <td style="text-align:left"></td>
    </tr>
  </tbody>
</table>### **4.列出身份所在组织的所有上级组织：listAllSupUnitWithIdentity**

<table>
  <thead>
    <tr>
      <th style="text-align:left"><b>&#x51FD;&#x6570;&#x8BF4;&#x660E;</b>
      </th>
      <th style="text-align:left">var unitList= this.org.listAllSupUnitWithIdentity (name);</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left"><b>&#x53C2;&#x6570;&#x8BF4;&#x660E;</b>
      </td>
      <td style="text-align:left">name : &#xFF08;String|Array&#xFF09;&#x5FC5;&#x9009;&#xFF0C;&#x8EAB;&#x4EFD;&#x552F;&#x4E00;&#x7F16;&#x7801;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x8FD4;&#x56DE;&#x503C;</b>
      </td>
      <td style="text-align:left">unitArray &#x8FD4;&#x56DE;&#x7EC4;&#x7EC7;&#x7684;&#x5BF9;&#x8C61;&#x6570;&#x7EC4;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x811A;&#x672C;&#x793A;&#x4F8B;</b>
      </td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">
        <p>var dn = &quot;&#x674E;&#x4E49;@5d10c11e-54cd-458d-9c34-5ba1a371a4d9@I&quot;;</p>
        <p>var unitArray = this.org.listAllSupUnitWithIdentity (dn);</p>
        <p>return unitArray.length;</p>
      </td>
      <td style="text-align:left"></td>
    </tr>
  </tbody>
</table>### 5.  **获取人员所在的所有组织：listUnitWithPerson**

<table>
  <thead>
    <tr>
      <th style="text-align:left"><b>&#x51FD;&#x6570;&#x8BF4;&#x660E;</b>
      </th>
      <th style="text-align:left">var unitList= this.org.listUnitWithPerson (name);</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left"><b>&#x53C2;&#x6570;&#x8BF4;&#x660E;</b>
      </td>
      <td style="text-align:left">name : &#xFF08;String|Array&#xFF09;&#x5FC5;&#x9009;&#xFF0C;&#x8EAB;&#x4EFD;&#x552F;&#x4E00;&#x7F16;&#x7801;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x8FD4;&#x56DE;&#x503C;</b>
      </td>
      <td style="text-align:left">unitArray &#x8FD4;&#x56DE;&#x7EC4;&#x7EC7;&#x7684;&#x5BF9;&#x8C61;&#x6570;&#x7EC4;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x811A;&#x672C;&#x793A;&#x4F8B;</b>
      </td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">
        <p>var dn = &quot;&#x674E;&#x4E49;@5d10c11e-54cd-458d-9c34-5ba1a371a4d9@I&quot;;</p>
        <p>var unitArray = this.org.listUnitWithPerson (dn);</p>
        <p>return unitArray.length;</p>
      </td>
      <td style="text-align:left"></td>
    </tr>
  </tbody>
</table>### 6.**列出个人所在组织的所有上级组织：listAllSupUnitWithPerson**

<table>
  <thead>
    <tr>
      <th style="text-align:left"><b>&#x51FD;&#x6570;&#x8BF4;&#x660E;</b>
      </th>
      <th style="text-align:left">var unitList= this.org.listAllSupUnitWithPerson (name);</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left"><b>&#x53C2;&#x6570;&#x8BF4;&#x660E;</b>
      </td>
      <td style="text-align:left">name : &#xFF08;String|Array&#xFF09;&#x5FC5;&#x9009;&#xFF0C;&#x4E2A;&#x4EBA;&#x552F;&#x4E00;&#x7F16;&#x7801;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x8FD4;&#x56DE;&#x503C;</b>
      </td>
      <td style="text-align:left">unitArray &#x8FD4;&#x56DE;&#x7EC4;&#x7EC7;&#x7684;&#x5BF9;&#x8C61;&#x6570;&#x7EC4;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x811A;&#x672C;&#x793A;&#x4F8B;</b>
      </td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">
        <p>var dn = &quot;&#x674E;&#x4E49;@5d10c11e-54cd-458d-9c34-5ba1a371a4d9@I&quot;;</p>
        <p>var unitArray = this.org.listAllSupUnitWithPerson (dn);</p>
        <p>return unitArray.length;</p>
      </td>
      <td style="text-align:left"></td>
    </tr>
  </tbody>
</table>### 7.**根据组织属性获取所有符合的组织：listUnitWithAttribute**

<table>
  <thead>
    <tr>
      <th style="text-align:left"><b>&#x51FD;&#x6570;&#x8BF4;&#x660E;</b>
      </th>
      <th style="text-align:left">var unitList= this.org.listUnitWithAttribute(name,attribute);</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left"><b>&#x53C2;&#x6570;&#x8BF4;&#x660E;</b>
      </td>
      <td style="text-align:left">
        <p>name : &#xFF08;String|Array&#xFF09;&#x5C5E;&#x6027;&#x540D;</p>
        <p>attribute &#x5C5E;&#x6027;&#x503C;</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x8FD4;&#x56DE;&#x503C;</b>
      </td>
      <td style="text-align:left">unitArray &#x8FD4;&#x56DE;&#x7EC4;&#x7EC7;&#x7684;&#x5BF9;&#x8C61;&#x6570;&#x7EC4;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x811A;&#x672C;&#x793A;&#x4F8B;</b>
      </td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">
        <p>var name= &quot;&quot;; var attribute = &quot;&quot;;</p>
        <p>var unitArray = this.org.listUnitWithAttribute (name,attribute );</p>
        <p>return unitArray.length;</p>
      </td>
      <td style="text-align:left"></td>
    </tr>
  </tbody>
</table>### 8.  **根据组织职务获取所有符合的组织：listUnitWithDuty**

<table>
  <thead>
    <tr>
      <th style="text-align:left"><b>&#x51FD;&#x6570;&#x8BF4;&#x660E;</b>
      </th>
      <th style="text-align:left">var unitList= this.org. listUnitWithDuty (name,id);</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left"><b>&#x53C2;&#x6570;&#x8BF4;&#x660E;</b>
      </td>
      <td style="text-align:left">
        <p>name : &#xFF08;String|Array&#xFF09;&#x7EC4;&#x7EC7;&#x804C;&#x52A1;&#x540D;</p>
        <p>id &#x8EAB;&#x4EFD;id&#xFF08;&#x4E5F;&#x53EF;&#x4EE5;&#x662F;&#x8EAB;&#x4EFD;&#x5BF9;&#x8C61;&#xFF09;</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x8FD4;&#x56DE;&#x503C;</b>
      </td>
      <td style="text-align:left">unitArray &#x8FD4;&#x56DE;&#x7EC4;&#x7EC7;&#x7684;&#x5BF9;&#x8C61;&#x6570;&#x7EC4;</td>
    </tr>
    <tr>
      <td style="text-align:left"><b>&#x811A;&#x672C;&#x793A;&#x4F8B;</b>
      </td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">
        <p>var name = &quot;&#x603B;&#x7ECF;&#x7406;&quot;;</p>
        <p>var id = &quot;&#x8EAB;&#x4EFD;id&quot;;</p>
        <p>var unitArray = this.org.listUnitWithDuty (name,id);</p>
        <p>return unitArray.length;</p>
      </td>
      <td style="text-align:left"></td>
    </tr>
  </tbody>
</table>