# 新增用户

用户信息包括3个部分：基本信息、用户属性和所在部门。新增用户，需列式该用户下的全量属性和所在部门。接口根据报文的用户所在部门对用户的身份进行新增。

**请求报文**

<table>
  <thead>
    <tr>
      <th style="text-align:left">
        <p>{</p>
        <p>action : &#x201C;add&#x201D;,</p>
        <p>genderType : &quot;m&quot;, //&#x6027;&#x522B;.&#x7537;:m,&#x5973;:f,&#x672A;&#x77E5;:d</p>
        <p>signature : &quot;&quot;, //&#x4E2A;&#x6027;&#x7B7E;&#x540D;</p>
        <p>description :&quot;&quot;, // &#x63CF;&#x8FF0;.</p>
        <p>name: &quot;&quot;, //&#x540D;&#x79F0;,&#x53EF;&#x91CD;&#x540D;.</p>
        <p>employee: &quot;&quot;, //&#x5DE5;&#x53F7;,&#x5FC5;&#x586B;,&#x4E0D;&#x53EF;&#x91CD;&#x590D;.</p>
        <p>unique: &quot;&quot;, //&#x552F;&#x4E00;&#x6807;&#x8BC6;,&#x4E0D;&#x53EF;&#x91CD;&#x590D;,&#x4E3A;&#x7A7A;&#x5219;&#x4F7F;&#x7528;&#x81EA;&#x52A8;&#x586B;&#x5145;&#x503C;</p>
        <p>distinguishedName: &quot;&quot;, //&#x8BC6;&#x522B;&#x540D;,&#x7CFB;&#x7EDF;&#x81EA;&#x52A8;&#x586B;&#x5145;,@P&#x7ED3;&#x5C3E;.</p>
        <p>orderNumber: &quot;&quot;, //&#x6392;&#x5E8F;&#x53F7;,&#x5347;&#x5E8F;&#x6392;&#x5217;,&#x4E3A;&#x7A7A;&#x5728;&#x6700;&#x540E;</p>
        <p>controllerList: &quot;&quot;, //&#x4E2A;&#x4EBA;&#x7BA1;&#x7406;&#x8005;.&#x9ED8;&#x8BA4;&#x4E3A;&#x521B;&#x5EFA;&#x8005;&#x3002;</p>
        <p>superior: &quot;&quot;, //&#x6C47;&#x62A5;&#x5BF9;&#x8C61;.</p>
        <p>mail: &quot;&quot;, //&#x90AE;&#x4EF6;&#x5730;&#x5740;.</p>
        <p>weixin: &quot;&quot;, //&#x5FAE;&#x4FE1;&#x53F7;.</p>
        <p>qq: &quot;&quot;, //QQ&#x53F7;.</p>
        <p>mobile: &quot;&quot;, //&#x5FC5;&#x586B;,&#x624B;&#x673A;&#x53F7;.</p>
        <p>officePhone: &quot;&quot;, //&#x529E;&#x516C;&#x7535;&#x8BDD;.</p>
        <p>boardDate: &quot;&quot;, //&#x5165;&#x804C;&#x65F6;&#x95F4;.</p>
        <p>birthday: &quot;&quot;, //&#x751F;&#x65E5;.</p>
        <p>age: &quot;&quot;, //&#x5E74;&#x9F84;</p>
        <p>dingdingId: &quot;&quot;, //&#x9489;&#x9489;&#x4EBA;&#x5458;ID.</p>
        <p>dingdingHash: &quot;&quot; //&#x9489;&#x9489;&#x4EBA;&#x5458;&#x54C8;&#x5E0C;&#x7279;&#x5F81;.</p>
        <p>attributeList : [ //&#x7528;&#x6237;&#x7684;&#x5176;&#x4ED6;&#x5C5E;&#x6027;&#xFF0C;&#x9700;&#x5168;&#x91CF;&#x5217;&#x5F0F;</p>
        <p>{</p>
        <p>name : &quot;&quot;, //&#x5C5E;&#x6027;&#x540D;&#x79F0;,</p>
        <p>value : &quot;&quot;, //&#x5C5E;&#x6027;&#x503C;&#xFF0C;&#x5141;&#x8BB8;&#x5B57;&#x7B26;&#x4E32;&#x6216;&#x8005;&#x6570;&#x7EC4;</p>
        <p>description : &quot;&quot; //&#x5C5E;&#x6027;&#x63CF;&#x8FF0;</p>
        <p>orderNumber: &quot;&quot; //&#x6392;&#x5E8F;&#x53F7;,&#x5347;&#x5E8F;&#x6392;&#x5217;,&#x4E3A;&#x7A7A;&#x5728;&#x6700;&#x540E;</p>
        <p>}</p>
        <p>...</p>
        <p>],</p>
        <p>unitList : [ //&#x7528;&#x6237;&#x6240;&#x5728;&#x90E8;&#x95E8;&#xFF0C;&#x9700;&#x5168;&#x91CF;&#x5217;&#x5F0F;</p>
        <p>{</p>
        <p>flag: &quot;&quot;, //&#x7EC4;&#x7EC7;&#x6807;&#x5FD7;&#x4F4D;&#xFF0C;&#x53EF;&#x4EE5;&#x4E3A;&#x7EC4;&#x7EC7;&#x552F;&#x4E00;&#x7F16;&#x7801;unique/&#x7EC4;&#x7EC7;&#x7684;distinguishedName/&#x7EC4;&#x7EC7;id</p>
        <p>orderNumber: &quot;&quot;, //&#x5728;&#x7EC4;&#x7EC7;&#x91CC;&#x7684;&#x6392;&#x5E8F;&#x53F7;,&#x5347;&#x5E8F;&#x6392;&#x5217;,&#x4E3A;&#x7A7A;&#x5728;&#x6700;&#x540E;</p>
        <p>description: &quot;&quot;, //&#x63CF;&#x8FF0;</p>
        <p>duty : &quot;&quot;, //&#x7528;&#x6237;&#x7684;&#x804C;&#x52A1;</p>
        <p>position : &quot;&quot; //&#x7528;&#x6237;&#x7684;&#x5C97;&#x4F4D;</p>
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
      <th style="text-align:left">&#x5FC5;&#x586B;</th>
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
      <td style="text-align:left">true</td>
      <td style="text-align:left">&#x64CD;&#x4F5C;</td>
      <td style="text-align:left">add</td>
    </tr>
    <tr>
      <td style="text-align:left">genderType</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">true</td>
      <td style="text-align:left">&#x6027;&#x522B;.&#x7537;:m,&#x5973;:f,&#x672A;&#x77E5;:d</td>
      <td style="text-align:left">m</td>
    </tr>
    <tr>
      <td style="text-align:left">signature</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x4E2A;&#x6027;&#x7B7E;&#x540D;.</td>
      <td style="text-align:left">&#x9999;&#x6E2F;&#x79FB;&#x52A8;</td>
    </tr>
    <tr>
      <td style="text-align:left">description</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x63CF;&#x8FF0;.</td>
      <td style="text-align:left">&#x9999;&#x6E2F;&#x79FB;&#x52A8;</td>
    </tr>
    <tr>
      <td style="text-align:left">name</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">true</td>
      <td style="text-align:left">&#x540D;&#x79F0;,&#x53EF;&#x91CD;&#x540D;.</td>
      <td style="text-align:left">&#x5F20;&#x4E09;</td>
    </tr>
    <tr>
      <td style="text-align:left">employee</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">true</td>
      <td style="text-align:left">&#x5DE5;&#x53F7;,&#x5FC5;&#x586B;,&#x4E0D;&#x53EF;&#x91CD;&#x590D;.</td>
      <td
      style="text-align:left">P0780</td>
    </tr>
    <tr>
      <td style="text-align:left">unique</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x552F;&#x4E00;&#x6807;&#x8BC6;,&#x4E0D;&#x53EF;&#x91CD;&#x590D;,&#x4E3A;&#x7A7A;&#x5219;&#x4F7F;&#x7528;&#x81EA;&#x52A8;&#x586B;&#x5145;&#x503C;</td>
      <td
      style="text-align:left">fb3ea7de-d54f-4679-8e9a-35cb1e6b3d01</td>
    </tr>
    <tr>
      <td style="text-align:left">distinguishedName</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x8BC6;&#x522B;&#x540D;,&#x81EA;&#x52A8;&#x586B;&#x5145;,@P&#x7ED3;&#x5C3E;.</td>
      <td
      style="text-align:left">&#x5F20;&#x4E09;@fb3ea7de-d54f-4679-8e9a-35cb1e6b3d01@P</td>
    </tr>
    <tr>
      <td style="text-align:left">orderNumber</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">number</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x6392;&#x5E8F;&#x53F7;,&#x5347;&#x5E8F;&#x6392;&#x5217;,&#x4E3A;&#x7A7A;&#x5728;&#x6700;&#x540E;</td>
      <td
      style="text-align:left">1</td>
    </tr>
    <tr>
      <td style="text-align:left">controllerarray</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">array</td>
      <td style="text-align:left">multi</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x4E2A;&#x4EBA;&#x7BA1;&#x7406;&#x8005;.&#x9ED8;&#x8BA4;&#x4E3A;&#x521B;&#x5EFA;&#x8005;&#x3002;</td>
      <td
      style="text-align:left">83de86fc-60bc-4b4c-955c-1085915865a4</td>
    </tr>
    <tr>
      <td style="text-align:left">superior</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">
        <p>&#x6C47;&#x62A5;&#x5BF9;&#x8C61;.</p>
        <p>&#x53EF;&#x4EE5;&#x4E3A;&#x6C47;&#x62A5;&#x5BF9;&#x8C61;&#x7684;distinguishedName
          &#x3001;unique &#x3001;employee&#x3001;mobile&#x3002;&#x5982;&#x679C;&#x672A;&#x627E;&#x5230;&#x6C47;&#x62A5;&#x5BF9;&#x8C61;&#xFF0C;&#x4E0D;&#x8BBE;&#x7F6E;&#x3002;</p>
      </td>
      <td style="text-align:left">P0180</td>
    </tr>
    <tr>
      <td style="text-align:left">mail</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x90AE;&#x4EF6;&#x5730;&#x5740;&#xFF0C;&#x4E0D;&#x53EF;&#x91CD;&#x590D;.</td>
      <td
      style="text-align:left">1234567@qq.com</td>
    </tr>
    <tr>
      <td style="text-align:left">weixin</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x5FAE;&#x4FE1;&#x53F7;.</td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">qq</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">QQ&#x53F7;.</td>
      <td style="text-align:left">1234567</td>
    </tr>
    <tr>
      <td style="text-align:left">mobile</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left">true</td>
      <td style="text-align:left">&#x5FC5;&#x586B;,&#x624B;&#x673A;&#x53F7;,&#x4E0D;&#x53EF;&#x91CD;&#x590D;.</td>
      <td
      style="text-align:left">13800000000</td>
    </tr>
    <tr>
      <td style="text-align:left">officePhone</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x529E;&#x516C;&#x7535;&#x8BDD;.</td>
      <td style="text-align:left">0571-88888888</td>
    </tr>
    <tr>
      <td style="text-align:left">boarddate</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">date-string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x5165;&#x804C;&#x65F6;&#x95F4;.</td>
      <td style="text-align:left">2015-02-02</td>
    </tr>
    <tr>
      <td style="text-align:left">birthday</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">date-string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x751F;&#x65E5;.</td>
      <td style="text-align:left">1995-10-12</td>
    </tr>
    <tr>
      <td style="text-align:left">age</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">number</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x5E74;&#x9F84;</td>
      <td style="text-align:left">20</td>
    </tr>
    <tr>
      <td style="text-align:left">dingdingId</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x9489;&#x9489;&#x4EBA;&#x5458;ID.</td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">dingdingHash</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x9489;&#x9489;&#x4EBA;&#x5458;&#x54C8;&#x5E0C;&#x7279;&#x5F81;.</td>
      <td
      style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">zhengwuDingdingId</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x653F;&#x52A1;&#x9489;&#x9489;&#x4EBA;&#x5458;ID.</td>
      <td style="text-align:left">1000833324</td>
    </tr>
    <tr>
      <td style="text-align:left">zhengwuDingdingHash</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x653F;&#x52A1;&#x9489;&#x9489;&#x4EBA;&#x5458;&#x54C8;&#x5E0C;&#x7279;&#x5F81;.</td>
      <td
      style="text-align:left">b388708eb84d6ae6328e03526a069ec864416a3b916ce22b8fb8bbfa3d84eb6b</td>
    </tr>
    <tr>
      <td style="text-align:left">qiyeweixinId</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x4F01;&#x4E1A;&#x5FAE;&#x4FE1;&#x4EBA;&#x5458;ID.</td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">qiyeweixinHash</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x4F01;&#x4E1A;&#x5FAE;&#x4FE1;&#x4EBA;&#x5458;&#x54C8;&#x5E0C;&#x7279;&#x5F81;.</td>
      <td
      style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">attributeList</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">array</td>
      <td style="text-align:left">multi</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x5176;&#x4ED6;&#x4EBA;&#x5458;&#x5C5E;&#x6027;&#x5217;&#x8868;</td>
      <td
      style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">name</td>
      <td style="text-align:left">attributeList</td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x5C5E;&#x6027;&#x540D;&#x79F0;</td>
      <td style="text-align:left">&#x7EA7;&#x522B;</td>
    </tr>
    <tr>
      <td style="text-align:left">description</td>
      <td style="text-align:left">attributeList</td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x5C5E;&#x6027;&#x63CF;&#x8FF0;</td>
      <td style="text-align:left">&#x7EA7;&#x522B;&#x63CF;&#x8FF0;</td>
    </tr>
    <tr>
      <td style="text-align:left">value</td>
      <td style="text-align:left">attributeList</td>
      <td style="text-align:left">string/array</td>
      <td style="text-align:left">multi</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x5C5E;&#x6027;&#x503C;</td>
      <td style="text-align:left">1 / [ &quot;1&quot; ]</td>
    </tr>
    <tr>
      <td style="text-align:left">orderNumber</td>
      <td style="text-align:left">attributeList</td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x6392;&#x5E8F;&#x53F7;,&#x5347;&#x5E8F;&#x6392;&#x5217;,&#x4E3A;&#x7A7A;&#x5728;&#x6700;&#x540E;</td>
      <td
      style="text-align:left">18315158</td>
    </tr>
    <tr>
      <td style="text-align:left">unitList</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">array</td>
      <td style="text-align:left">multi</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x6240;&#x5728;&#x7EC4;&#x7EC7;&#x5217;&#x8868;</td>
      <td style="text-align:left"></td>
    </tr>
    <tr>
      <td style="text-align:left">flag</td>
      <td style="text-align:left">unitList</td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x7EC4;&#x7EC7;&#x6807;&#x5FD7;&#x4F4D;&#xFF0C;&#x53EF;&#x4EE5;&#x4E3A;&#x7EC4;&#x7EC7;&#x552F;&#x4E00;&#x7F16;&#x7801;unique/&#x7EC4;&#x7EC7;&#x7684;distinguishedName/&#x7EC4;&#x7EC7;id</td>
      <td
      style="text-align:left">&quot;companyLeader/&quot;&#x516C;&#x53F8;&#x7BA1;&#x7406;&#x5C42;@9b45cb75-52f8-4e73-8470-4cdc78230b7d@U&quot;,</td>
    </tr>
    <tr>
      <td style="text-align:left">orderNumber</td>
      <td style="text-align:left">unitList</td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x7528;&#x6237;&#x5728;&#x7EC4;&#x7EC7;&#x91CC;&#x7684;&#x6392;&#x5E8F;&#x53F7;&#x5347;&#x5E8F;&#x6392;&#x5217;,&#x4E3A;&#x7A7A;&#x5728;&#x6700;&#x540E;</td>
      <td
      style="text-align:left">123</td>
    </tr>
    <tr>
      <td style="text-align:left">description</td>
      <td style="text-align:left">unitList</td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x63CF;&#x8FF0;</td>
      <td style="text-align:left">&#x516C;&#x53F8;&#x7BA1;&#x7406;&#x5C42;</td>
    </tr>
    <tr>
      <td style="text-align:left">duty</td>
      <td style="text-align:left">unitList</td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x7528;&#x6237;&#x5728;&#x8BE5;&#x7EC4;&#x7EC7;&#x7684;&#x804C;&#x52A1;</td>
      <td
      style="text-align:left">&#x6B63;&#x804C;&#x9886;&#x5BFC;</td>
    </tr>
    <tr>
      <td style="text-align:left">position</td>
      <td style="text-align:left">unitList</td>
      <td style="text-align:left">string</td>
      <td style="text-align:left">single</td>
      <td style="text-align:left"></td>
      <td style="text-align:left">&#x7528;&#x6237;&#x5728;&#x8BE5;&#x7EC4;&#x7EC7;&#x7684;&#x5C97;&#x4F4D;</td>
      <td
      style="text-align:left">&#x7BA1;&#x7406;&#x5C97;</td>
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
        <p>&quot;id&quot; : &quot;&quot;, //&#x5982;&#x679C;&#x6210;&#x529F;&#xFF0C;&#x7528;&#x6237;64&#x4F4D;id</p>
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