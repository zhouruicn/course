# 人员数据接口

| 服务地址 | http://{centerserver}:20030/x\_program\_center/jaxrs/invoke/personSync/execute |
| :--- | :--- |
| 调用方式 | HTTP |
| 调用方法 | POST |
| 请求报文Content-Type | application/json; charset=utf-8 |
| 响应报文Content-Type | application/json; charset=utf-8 |

本服务对应用户的增删改查操作，通过传请求报文的action参数进行对应的操作：

| 参数 | 执行操作 |
| :--- | :--- |
| add | 新增用户 |
| update | 修改用户 |
| updatepwd | 修改密码 |
| updateSuperior | 修改用户的汇报对象 |
| delete | 删除用户 |

如：删除用户的请求报文为

<table>
  <thead>
    <tr>
      <th style="text-align:left">
        <p>{</p>
        <p>&quot;action&quot;: &quot;delete&quot;, //&#x5220;&#x9664;&#x7528;&#x6237;</p>
        <p>&quot;flag&quot; : &quot;&quot; //&#x7528;&#x6237;&#x6807;&#x5FD7;</p>
        <p>}</p>
      </th>
    </tr>
  </thead>
  <tbody></tbody>
</table>{% file src="../../../../.gitbook/assets/personsync.json" %}



