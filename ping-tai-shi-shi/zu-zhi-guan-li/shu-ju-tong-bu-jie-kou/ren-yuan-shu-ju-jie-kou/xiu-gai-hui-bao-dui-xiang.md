# 修改汇报对象

**请求报文**

<table>
  <thead>
    <tr>
      <th style="text-align:left">
        <p>{</p>
        <p>action : &quot;updateSuperior&quot;,</p>
        <p>flag: &quot;&quot;, //&#x7528;&#x6237;&#x6807;&#x5FD7;&#x4F4D;</p>
        <p>superior: &quot;&quot; //&#x7528;&#x6237;&#x6C47;&#x62A5;&#x5BF9;&#x8C61;</p>
        <p>}</p>
      </th>
    </tr>
  </thead>
  <tbody></tbody>
</table>**说明：**flag用来查找用户

可以为distinguishedName : "",  //识别名,,@P结尾.

unique : "",              //唯一标识,

employee: "",           //工号,.

mobile: "",             //,手机号.

Id : ""                 //个人数据库主键

**响应报文**

<table>
  <thead>
    <tr>
      <th style="text-align:left">
        <p>{</p>
        <p>&quot;data&quot;: {</p>
        <p>&quot;value&quot;: {</p>
        <p>&quot;result&quot; : &quot;&quot;, //&#x54CD;&#x5E94;&#x6210;&#x529F;&#x4E3A;
          success, &#x5931;&#x8D25;&#x4E3A;error</p>
        <p>&quot;description&quot;: &quot;&quot; //&#x54CD;&#x5E94;&#x7ED3;&#x679C;&#x63CF;&#x8FF0;</p>
        <p>}</p>
        <p>}</p>
        <p>}</p>
      </th>
    </tr>
  </thead>
  <tbody></tbody>
</table>