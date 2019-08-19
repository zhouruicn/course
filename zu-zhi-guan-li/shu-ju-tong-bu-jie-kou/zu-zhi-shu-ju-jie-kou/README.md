# 组织数据接口

| 服务地址 | http://ahpp.zoneland.net:20030/x\_program\_center/jaxrs/invoke/unitAsync/execute |
| :--- | :--- |
| 调用方式 | HTTP |
| 调用方法 | POST |
| 请求报文Content-Type | application/json; charset=utf-8 |
| 响应报文Content-Type | application/json; charset=utf-8 |

本服务对应组织的增删改查操作，通过传请求报文的action参数进行对应的操作：

| 参数 | 执行操作 |
| :--- | :--- |
| add | 新增组织 |
| update | 修改组织 |
| delete | 删除组织 |

如：删除组织的请求报文可以为

<table>
  <thead>
    <tr>
      <th style="text-align:left">
        <p>{</p>
        <p>&quot;action&quot;: &quot;delete&quot;, //&#x5220;&#x9664;&#x7EC4;&#x7EC7;</p>
        <p>&quot;flag&quot; : &quot;&quot; //&#x7EC4;&#x7EC7;&#x6807;&#x5FD7;</p>
        <p>}</p>
      </th>
    </tr>
  </thead>
  <tbody></tbody>
</table>{% file src="../../../.gitbook/assets/unitsycn.json" %}

