# 删除组织

**请求报文**

<table>
  <thead>
    <tr>
      <th style="text-align:left">
        <p>{</p>
        <p>action : &quot;delete&quot;,</p>
        <p>distinguishedName : &quot;&quot;, //&#x8BC6;&#x522B;&#x540D;,@P&#x7ED3;&#x5C3E;.</p>
        <p>unique : &quot;&quot;, //&#x552F;&#x4E00;&#x6807;&#x8BC6;</p>
        <p>}</p>
      </th>
    </tr>
  </thead>
  <tbody></tbody>
</table>**说明：**distinguishedName 、unique 用来查找组织，其中一项不为空即可

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