# 新增组织

**请求报文**

<table>
  <thead>
    <tr>
      <th style="text-align:left">
        <p>{</p>
        <p>&quot;action&quot;:&quot;add&quot;,</p>
        <p>&quot;name&quot;:&quot;&quot;, //&#x540D;&#x79F0;,&#x53EF;&#x4EE5;&#x91CD;&#x540D;.</p>
        <p>&quot;unique&quot;:&quot;&quot;, //&#x552F;&#x4E00;&#x6807;&#x8BC6;,&#x4E0D;&#x53EF;&#x91CD;&#x590D;,&#x4E3A;&#x7A7A;&#x5219;&#x4F7F;&#x7528;&#x81EA;&#x52A8;&#x586B;&#x5145;&#x503C;</p>
        <p>&quot;distinguishedName&quot;:&quot;&quot;, //&#x8BC6;&#x522B;&#x540D;.&#x4EE5;@U&#x7ED3;&#x5C3E;.</p>
        <p>&quot;typeList&quot;:&quot;&quot;, //&#x7EC4;&#x7EC7;&#x7C7B;&#x578B;.</p>
        <p>&quot;description&quot;:&quot;&quot;, //&#x63CF;&#x8FF0;.</p>
        <p>&quot;shortName&quot;:&quot;&quot;, //&#x7EC4;&#x7EC7;&#x7B80;&#x79F0;&#x3002;</p>
        <p>&quot;superior&quot;:&quot;&quot;, //&#x4E0A;&#x7EA7;&#x7EC4;&#x7EC7;.</p>
        <p>&quot;orderNumber&quot;:&quot;&quot;, //&#x6392;&#x5E8F;&#x53F7;,&#x5347;&#x5E8F;&#x6392;&#x5217;,&#x4E3A;&#x7A7A;&#x5728;&#x6700;&#x540E;</p>
        <p>&quot;controllerList&quot;:&quot;&quot;, //&#x7EC4;&#x7EC7;&#x7684;&#x7BA1;&#x7406;&#x4EBA;&#x5458;.</p>
        <p>&quot;dingdingId&quot;:&quot;&quot;, //&#x9489;&#x9489;&#x90E8;&#x95E8;ID.</p>
        <p>&quot;dingdingHash&quot;:&quot;&quot;, //&#x9489;&#x9489;&#x90E8;&#x95E8;&#x54C8;&#x5E0C;&#x7279;&#x5F81;.</p>
        <p>&quot;qiyeweixinId&quot;:&quot;&quot;, //&#x4F01;&#x4E1A;&#x5FAE;&#x4FE1;&#x4EBA;&#x5458;ID.</p>
        <p>&quot;zhengwuDingdingId&quot;:&quot;&quot;, //&#x653F;&#x52A1;&#x9489;&#x9489;&#x4EBA;&#x5458;ID.</p>
        <p>&quot;zhengwuDingdingHash&quot;:&quot;&quot;, //&#x653F;&#x52A1;&#x9489;&#x9489;&#x4EBA;&#x5458;&#x54C8;&#x5E0C;&#x7279;&#x5F81;.</p>
        <p>&quot;qiyeweixinHash&quot;:&quot;&quot;, //&#x4F01;&#x4E1A;&#x5FAE;&#x4FE1;&#x4EBA;&#x5458;&#x54C8;&#x5E0C;&#x7279;&#x5F81;.</p>
        <p>&quot;attributeList&quot; : [ //&#x7EC4;&#x7EC7;&#x5C5E;&#x6027;</p>
        <p>{</p>
        <p>description:&quot;&quot;, //&#x63CF;&#x8FF0;.</p>
        <p>name:&quot;&quot;, //&#x540D;&#x79F0;,&#x4E0D;&#x53EF;&#x91CD;&#x540D;.</p>
        <p>unique:&quot;&quot;, //&#x552F;&#x4E00;&#x6807;&#x8BC6;,&#x4E0D;&#x53EF;&#x91CD;&#x590D;,&#x4E3A;&#x7A7A;&#x5219;&#x4F7F;&#x7528;&#x81EA;&#x52A8;&#x586B;&#x5145;&#x503C;</p>
        <p>distinguishedName:&quot;&quot;, //&#x8BC6;&#x522B;&#x540D;,&#x81EA;&#x52A8;&#x586B;&#x5145;,@UA&#x7ED3;&#x5C3E;.</p>
        <p>orderNumber:&quot;&quot;, //&#x6392;&#x5E8F;&#x53F7;,&#x5347;&#x5E8F;&#x6392;&#x5217;,&#x4E3A;&#x7A7A;&#x5728;&#x6700;&#x540E;</p>
        <p>value:&quot;&quot;, //&#x5C5E;&#x6027;&#x503C;,&#x591A;&#x503C;.</p>
        <p>}</p>
        <p>...</p>
        <p>],</p>
        <p>&quot;dutyList&quot; : [ //&#x7EC4;&#x7EC7;&#x804C;&#x52A1;</p>
        <p>{</p>
        <p>description:&quot;&quot;, //&#x63CF;&#x8FF0;.</p>
        <p>name:&quot;&quot;, //&#x540D;&#x79F0;,&#x540C;&#x4E00;&#x7EC4;&#x7EC7;&#x4E0B;&#x4E0D;&#x53EF;&#x91CD;&#x540D;.</p>
        <p>unique:&quot;&quot;, //&#x552F;&#x4E00;&#x6807;&#x8BC6;,&#x4E0D;&#x53EF;&#x91CD;&#x590D;,&#x4E3A;&#x7A7A;&#x5219;&#x4F7F;&#x7528;&#x81EA;&#x52A8;&#x586B;&#x5145;&#x503C;</p>
        <p>distinguishedName:&quot;&quot;, //&#x8BC6;&#x522B;&#x540D;,&#x81EA;&#x52A8;&#x586B;&#x5145;,@UD&#x7ED3;&#x5C3E;.</p>
        <p>orderNumber:&quot;&quot;, //&#x6392;&#x5E8F;&#x53F7;,&#x5347;&#x5E8F;&#x6392;&#x5217;,&#x4E3A;&#x7A7A;&#x5728;&#x6700;&#x540E;</p>
        <p>value:&quot;&quot;, //&#x7EC4;&#x7EC7;&#x804C;&#x52A1;&#x8EAB;&#x4EFD;&#x6210;&#x5458;,&#x591A;&#x503C;.</p>
        <p>}</p>
        <p>...</p>
        <p>]</p>
        <p>}</p>
      </th>
    </tr>
  </thead>
  <tbody></tbody>
</table><table>
  <thead>
    <tr>
      <th style="text-align:left">&#x5C5E;&#x6027;</th>
      <th style="text-align:left">&#x4E0A;&#x7EA7;</th>
      <th style="text-align:left">&#x7C7B;&#x578B;</th>
      <th style="text-align:left">&#x5355;&#x503C;/&#x591A;&#x503C;</th>
      <th style="text-align:left">&#x8BF4;&#x660E;</th>
      <th style="text-align:left">&#x6837;&#x4F8B;</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left">action</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">add</td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">name</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x540D;&#x79F0;,&#x53EF;&#x4EE5;&#x91CD;&#x540D;.</td>
      <td style="text-align:left">&#x6280;&#x672F;&#x652F;&#x6301;</td>
    </tr>
    <tr>
      <td style="text-align:left">unique</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x552F;&#x4E00;&#x6807;&#x8BC6;,&#x4E0D;&#x53EF;&#x91CD;&#x590D;,&#x4E3A;&#x7A7A;&#x5219;&#x4F7F;&#x7528;&#x81EA;&#x52A8;&#x586B;&#x5145;&#x503C;</td>
      <td
      style="text-align:left">1000263571</td>
    </tr>
    <tr>
      <td style="text-align:left">distinguishedName</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x8BC6;&#x522B;&#x540D;.&#x5982;&#x679C;&#x672A;&#x7A7A;&#x7CFB;&#x7EDF;&#x81EA;&#x52A8;&#x586B;&#x5145;.&#x4EE5;@U&#x7ED3;&#x5C3E;.</td>
      <td
      style="text-align:left">&#x6280;&#x672F;&#x652F;&#x6301;@1000263571@U</td>
    </tr>
    <tr>
      <td style="text-align:left">typeList</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">array</td>
      <td style="text-align:left">multi</td>
      <td style="text-align:left">&#x7EC4;&#x7EC7;&#x7C7B;&#x578B;.</td>
      <td style="text-align:left">[ &quot;&#x90E8;&#x95E8;&quot; ]</td>
    </tr>
    <tr>
      <td style="text-align:left">description</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x63CF;&#x8FF0;.</td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">shortName</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x7EC4;&#x7EC7;&#x7B80;&#x79F0;&#x3002;</td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">levelName</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x663E;&#x793A;&#x7684;&#x5C42;&#x7EA7;&#x540D;.</td>
      <td style="text-align:left">&#x5B89;&#x5FBD;&#x8054;&#x901A;/&#x6280;&#x672F;&#x652F;&#x6301;</td>
    </tr>
    <tr>
      <td style="text-align:left">superior</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x4E0A;&#x7EA7;&#x7EC4;&#x7EC7;&#x6807;&#x5FD7;&#x4F4D;&#xFF0C;&#x53EF;&#x4EE5;&#x4E3A;&#x7EC4;&#x7EC7;&#x552F;&#x4E00;&#x7F16;&#x7801;unique/&#x7EC4;&#x7EC7;&#x7684;distinguishedName/&#x7EC4;&#x7EC7;id</td>
      <td
      style="text-align:left">&quot;companyLeader/&quot;&#x516C;&#x53F8;&#x7BA1;&#x7406;&#x5C42;@9b45cb75-52f8-4e73-8470-4cdc78230b7d@U&quot;/9d14f85a-27ba-4e02-b4ef-4ebfcf3f19c0</td>
    </tr>
    <tr>
      <td style="text-align:left">orderNumber</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">number</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x6392;&#x5E8F;&#x53F7;,&#x5347;&#x5E8F;&#x6392;&#x5217;,&#x4E3A;&#x7A7A;&#x5728;&#x6700;&#x540E;</td>
      <td
      style="text-align:left">20</td>
    </tr>
    <tr>
      <td style="text-align:left">controllerList</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">array</td>
      <td style="text-align:left">multi</td>
      <td style="text-align:left">&#x7EC4;&#x7EC7;&#x7684;&#x7BA1;&#x7406;&#x4EBA;&#x5458;&#x7684;.distinguishedName
        &#x3001;unique &#x3001;employee&#x6216;mobile</td>
      <td style="text-align:left">[&quot;138000000&quot;]</td>
    </tr>
    <tr>
      <td style="text-align:left">dingdingId</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x9489;&#x9489;&#x90E8;&#x95E8;ID.</td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">dingdingHash</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x9489;&#x9489;&#x90E8;&#x95E8;&#x54C8;&#x5E0C;&#x7279;&#x5F81;.</td>
      <td
      style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">qiyeweixinId</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x4F01;&#x4E1A;&#x5FAE;&#x4FE1;&#x4EBA;&#x5458;ID.</td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">zhengwuDingdingId</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x653F;&#x52A1;&#x9489;&#x9489;&#x4EBA;&#x5458;ID.</td>
      <td style="text-align:left">1000263571</td>
    </tr>
    <tr>
      <td style="text-align:left">zhengwuDingdingHash</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x653F;&#x52A1;&#x9489;&#x9489;&#x4EBA;&#x5458;&#x54C8;&#x5E0C;&#x7279;&#x5F81;.</td>
      <td
      style="text-align:left">8ecfc82b45c5d33be7f84599b265e4fffb56108c0f8f85bde7856e01521a7d0b</td>
    </tr>
    <tr>
      <td style="text-align:left">qiyeweixinHash</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x4F01;&#x4E1A;&#x5FAE;&#x4FE1;&#x4EBA;&#x5458;&#x54C8;&#x5E0C;&#x7279;&#x5F81;.</td>
      <td
      style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">attributeList</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">array</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x7EC4;&#x7EC7;&#x5C5E;&#x6027;&#x5217;&#x8868;</td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">name</td>
      <td style="text-align:left">attributeList</td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">multi</td>
      <td style="text-align:left">&#x540D;&#x79F0;,&#x4E0D;&#x53EF;&#x91CD;&#x540D;.</td>
      <td style="text-align:left">&#x7EC4;&#x7EC7;&#x5C5E;&#x6027;</td>
    </tr>
    <tr>
      <td style="text-align:left">description</td>
      <td style="text-align:left">attributeList</td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x63CF;&#x8FF0;.</td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">distinguishedName</td>
      <td style="text-align:left">attributeList</td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x8BC6;&#x522B;&#x540D;,&#x81EA;&#x52A8;&#x586B;&#x5145;,@UA&#x7ED3;&#x5C3E;.</td>
      <td
      style="text-align:left">&#x7EC4;&#x7EC7;&#x5C5E;&#x6027;@e762a4df-44ce-418c-bb20-899558b49622@UA</td>
    </tr>
    <tr>
      <td style="text-align:left">unique</td>
      <td style="text-align:left">attributeList</td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x552F;&#x4E00;&#x6807;&#x8BC6;,&#x4E0D;&#x53EF;&#x91CD;&#x590D;,&#x4E3A;&#x7A7A;&#x5219;&#x4F7F;&#x7528;&#x81EA;&#x52A8;&#x586B;&#x5145;&#x503C;</td>
      <td
      style="text-align:left">e762a4df-44ce-418c-bb20-899558b49622</td>
    </tr>
    <tr>
      <td style="text-align:left">value</td>
      <td style="text-align:left">attributeList</td>
      <td style="text-align:left">string/array</td>
      <td style="text-align:left">multi</td>
      <td style="text-align:left">&#x5C5E;&#x6027;&#x503C;,&#x591A;&#x503C;.</td>
      <td style="text-align:left">[&quot;&#x7EC4;&#x7EC7;&#x5C5E;&#x6027;&#x503C;&quot;]</td>
    </tr>
    <tr>
      <td style="text-align:left">orderNumber</td>
      <td style="text-align:left">attributeList</td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x6392;&#x5E8F;&#x53F7;,&#x5347;&#x5E8F;&#x6392;&#x5217;,&#x4E3A;&#x7A7A;&#x5728;&#x6700;&#x540E;</td>
      <td
      style="text-align:left">112345</td>
    </tr>
    <tr>
      <td style="text-align:left">dutyList</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">array</td>
      <td style="text-align:left">multi</td>
      <td style="text-align:left">&#x7EC4;&#x7EC7;&#x804C;&#x52A1;</td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">name</td>
      <td style="text-align:left">dutyList</td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x540D;&#x79F0;,&#x540C;&#x4E00;&#x7EC4;&#x7EC7;&#x4E0B;&#x4E0D;&#x53EF;&#x91CD;&#x540D;.</td>
      <td
      style="text-align:left">&#x90E8;&#x95E8;&#x9886;&#x5BFC;</td>
    </tr>
    <tr>
      <td style="text-align:left">description</td>
      <td style="text-align:left">dutyList</td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x63CF;&#x8FF0;.</td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">unique</td>
      <td style="text-align:left">dutyList</td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x552F;&#x4E00;&#x6807;&#x8BC6;,&#x4E0D;&#x53EF;&#x91CD;&#x590D;,&#x4E3A;&#x7A7A;&#x5219;&#x4F7F;&#x7528;&#x81EA;&#x52A8;&#x586B;&#x5145;&#x503C;</td>
      <td
      style="text-align:left">7a1b7021-8812-4d18-9447-6b27ce7454ed</td>
    </tr>
    <tr>
      <td style="text-align:left">distinguishedName</td>
      <td style="text-align:left">dutyList</td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x8BC6;&#x522B;&#x540D;,&#x81EA;&#x52A8;&#x586B;&#x5145;,@UD&#x7ED3;&#x5C3E;.</td>
      <td
      style="text-align:left">&#x90E8;&#x95E8;&#x9886;&#x5BFC;@7a1b7021-8812-4d18-9447-6b27ce7454ed@UD</td>
    </tr>
    <tr>
      <td style="text-align:left">orderNumber</td>
      <td style="text-align:left">dutyList</td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">&#x6392;&#x5E8F;&#x53F7;,&#x5347;&#x5E8F;&#x6392;&#x5217;,&#x4E3A;&#x7A7A;&#x5728;&#x6700;&#x540E;</td>
      <td
      style="text-align:left">&#x6392;&#x5E8F;&#x53F7;,&#x5347;&#x5E8F;&#x6392;&#x5217;,&#x4E3A;&#x7A7A;&#x5728;&#x6700;&#x540E;</td>
    </tr>
    <tr>
      <td style="text-align:left">value</td>
      <td style="text-align:left">dutyList</td>
      <td style="text-align:left">aray</td>
      <td style="text-align:left">multi</td>
      <td style="text-align:left">
        <p>&#x7EC4;&#x7EC7;&#x804C;&#x52A1;&#x8EAB;&#x4EFD;&#x6210;&#x5458;,&#x591A;&#x503C;.</p>
        <p>&#x53EF;&#x4EE5;&#x662F;&#x4EBA;&#x5458;&#x7684;.distinguishedName &#x3001;unique
          &#x3001;employee&#x6216;mobile</p>
      </td>
      <td style="text-align:left">[&quot;&#x5F20;&#x4E09;@fb3ea7de-d54f-4679-8e9a-35cb1e6b3d01@P&quot;,&quot;P0780&quot;,&quot;13800000000&quot;,&quot;fb3ea7de-d54f-4679-8e9a-35cb1e6b3d01&quot;]</td>
    </tr>
  </tbody>
</table>**响应报文**

<table>
  <thead>
    <tr>
      <th style="text-align:left">
        <p>{</p>
        <p>&quot;data&quot;: {</p>
        <p>&quot;value&quot;: {</p>
        <p>&quot;id&quot; : &quot;&quot;, //&#x5982;&#x679C;&#x6210;&#x529F;&#xFF0C;&#x7EC4;&#x7EC7;64&#x4F4D;id</p>
        <p>&quot;distinguishedName: &quot;&quot;, //&#x5982;&#x679C;&#x6210;&#x529F;&#xFF0C;&#x7EC4;&#x7EC7;&#x8BC6;&#x522B;&#x540D;</p>
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