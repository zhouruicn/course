# 备份恢复数据

1、服务器备份相关设置

2、数据导出和数据导入

3、文件存储导出和文件存储导入

**一、服务器备份相关设置**

       O2OA可以实现自动进行数据和文件存储的备份，服务器进行配置后，系统将会按指定的时间周期对服务器中的数据以及文件进行备份，有效地避免服务器使用中的数据误操作带来的数据丢失。

       配置文件路径：o2server/config/node\_127.0.0.1.json       

<table>
  <thead>
    <tr>
      <th style="text-align:left">
        <p>{
          <br />&quot;enable&quot;: true,
          <br />&quot;port&quot;:null,
          <br />&quot;sslEnable&quot;:false,
          <br />&quot;logLevel&quot;:&quot;info&quot;,
          <br />&quot;isPrimaryCenter&quot;: true,
          <br />&quot;nodeAgentEnable&quot;: true,
          <br />&quot;application&quot;: {
          <br />&quot;enable&quot;: true,
          <br />&quot;port&quot;: null,
          <br />&quot;sslEnable&quot;: false,
          <br />&quot;proxyHost&quot;: &quot;&quot;,
          <br />&quot;proxyPort&quot;: null,
          <br />&quot;forceRedeploy&quot;: true,
          <br />&quot;scanInterval&quot;:5,
          <br />&quot;includes&quot;:[],
          <br />&quot;excludes&quot;:[]
          <br />},
          <br />&quot;web&quot;: {
          <br />&quot;enable&quot;: true,
          <br />&quot;port&quot;: 80,
          <br />&quot;sslEnable&quot;: false,
          <br />&quot;proxyHost&quot;: &quot;&quot;,
          <br />&quot;proxyPort&quot;: 80,
          <br />&quot;forceRedeploy&quot;: true
          <br />},
          <br />&quot;storage&quot;: {
          <br />&quot;enable&quot;: true,
          <br />&quot;port&quot;: null,
          <br />&quot;sslEnable&quot;: false,
          <br />&quot;name&quot; : &quot;&quot;
          <br />},
          <br />&quot;data&quot;: {
          <br />&quot;enable&quot;: true,
          <br />&quot;tcpPort&quot;: null,
          <br />&quot;webPort&quot;: null,
          <br />&quot;includes&quot;: [],
          <br />&quot;excludes&quot;: []
          <br />},</p>
        <p><b>   //&#x6570;&#x636E;&#x5E93;&#x5BFC;&#x51FA;&#x5907;&#x4EFD;&#x76F8;&#x5173;&#x914D;&#x7F6E;</b>
          <br
          />&quot;dumpData&quot;:{
          <br />&quot;cron&quot; : &quot;0 0 21 * * ?&quot;, //&#x6570;&#x636E;&#x5E93;&#x5BFC;&#x51FA;&#x5907;&#x4EFD;&#x6267;&#x884C;&#x7684;&#x65F6;&#x95F4;&#x5468;&#x671F;&#xFF0C;Cron&#x8868;&#x8FBE;&#x5F0F;
          <br
          />&quot;size&quot; : 14 //&#x6570;&#x636E;&#x5E93;&#x5BFC;&#x51FA;&#x5907;&#x4EFD;&#x6587;&#x4EF6;&#x4FDD;&#x7559;&#x7684;&#x6700;&#x5927;&#x4E2A;&#x6570;
          <br
          />},</p>
        <p><b>  //&#x6587;&#x4EF6;&#x5BFC;&#x51FA;&#x5907;&#x4EFD;&#x76F8;&#x5173;&#x914D;&#x7F6E;<br />  </b> &quot;dumpStorage&quot;:{
          <br
          />&quot;cron&quot; : &quot;0 0 21 * * ?&quot;, //&#x6587;&#x4EF6;&#x5B58;&#x50A8;&#x5BFC;&#x51FA;&#x5907;&#x4EFD;&#x6267;&#x884C;&#x7684;&#x65F6;&#x95F4;&#x5468;&#x671F;&#xFF0C;Cron&#x8868;&#x8FBE;&#x5F0F;
          <br
          />&quot;size&quot; : 14 //&#x6587;&#x4EF6;&#x5B58;&#x50A8;&#x5BFC;&#x51FA;&#x5907;&#x4EFD;&#x6587;&#x4EF6;&#x4FDD;&#x7559;&#x7684;&#x6700;&#x5927;&#x4E2A;&#x6570;
          <br
          />}
          <br />}</p>
      </th>
    </tr>
  </thead>
  <tbody></tbody>
</table>备份文件存放位置：o2server\local\backup

![](https://oscimg.oschina.net/oscnet/fec12a14f3f9a1fff095aa45a7fa96dc9f1.jpg)

**配置说明：**

1、参数cron：O2OA采用通用的CRON时间表达式来实现对任务执行周期 的设定。CRON表达式相关的说明，请参见：https://www.cnblogs.com/javahr/p/8318728.html

     常用的CRON表达式：     

| （1）0 0 2 1 \* ? \*   表示在每月的1日的凌晨2点调整任务  （2）0 15 10 ? \* MON-FRI   表示周一到周五每天上午10:15执行作业  （3）0 15 10 ? 6L 2002-2006   表示2002-2006年的每个月的最后一个星期五上午10:15执行作  （4）0 0 10,14,16 \* \* ?   每天上午10点，下午2点，4点   （5）0 0/30 9-17 \* \* ?   朝九晚五工作时间内每半小时   （6）0 0 12 ? \* WED    表示每个星期三中午12点   （7）0 0 12 \* \* ?   每天中午12点触发   （8）0 15 10 ? \* \*    每天上午10:15触发   （9）0 15 10 \* \* ?     每天上午10:15触发   （10）0 15 10 \* \* ? \*    每天上午10:15触发   （11）0 15 10 \* \* ? 2005    2005年的每天上午10:15触发   （12）0 \* 14 \* \* ?     在每天下午2点到下午2:59期间的每1分钟触发   （13）0 0/5 14 \* \* ?    在每天下午2点到下午2:55期间的每5分钟触发   （14）0 0/5 14,18 \* \* ?     在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发   （15）0 0-5 14 \* \* ?    在每天下午2点到下午2:05期间的每1分钟触发   （16）0 10,44 14 ? 3 WED    每年三月的星期三的下午2:10和2:44触发   （17）0 15 10 ? \* MON-FRI    周一至周五的上午10:15触发   （18）0 15 10 15 \* ?    每月15日上午10:15触发   （19）0 15 10 L \* ?    每月最后一日的上午10:15触发   （20）0 15 10 ? \* 6L    每月的最后一个星期五上午10:15触发   （21）0 15 10 ? \* 6L 2002-2005   2002年至2005年的每月的最后一个星期五上午10:15触发   （22）0 15 10 ? \* 6\#3   每月的第三个星期五上午10:15触发 |
| :--- |


2、参数size：因为考虑到备份对磁盘容量的消夏，O2OA支持只保留指定数量的备份文件。超过size指定数量的备份文件时，最早的备份文件将会被删除。

**二、数据导出和数据导入命令**

1、数据导出命令： dump data &lt;superpwd&gt;

     O2OA除了自动备份，还支持手工将服务器数据库中所有的数据进行导出操作。

![](https://oscimg.oschina.net/oscnet/7d4de1ceb2ce56d2245c22b5d79e2955119.jpg)

Winodws操作系统中操作步骤（其他操作系统中操作方式类似）：

1）执行o2server/start\_windows.bat

2）启动内置数据库（说明：如果使用的是外部数据，请确保数据已经正常启动，能够被o2server连接）

     执行命令：start data，启动完成后如下图所示：

![](https://oscimg.oschina.net/oscnet/598fb9e490241a11959c8b6abcbb507ef91.jpg)

     3）导出数据

          执行命令：dump data o2  （说明：其中o2是服务器默认的管理员密码），执行效果如下图所示：

![](https://oscimg.oschina.net/oscnet/82a1ee0664e0f4b56d4c827d311f9dd5f55.jpg)

导出完成后，会显示：

2018-10-16 10:20:18 PRINT \[main\] com.x.server.console.action.ActionDumpData - dump data completed, directory: D:\o2server\local\dump\dumpData\_20181016101732, count: 56144, elapsed: 2 minutes.

在信息中指明了导出的数据文件存放的路径以及导出的数据量和导出过程消耗的时间：

导出的数据文件存放的路径：directory: D:\o2server\local\dump\dumpData\_20181016101732

导出的数据量：count: 56144,

导出过程消耗的时间：elapsed: 2 minutes.

如下图所示：

![](https://oscimg.oschina.net/oscnet/f164f1c9e48d67086fe9532719c43b90a4b.jpg)

导出文件存放位置：

![](https://oscimg.oschina.net/oscnet/f8ad118d77b6612b3eb1608deabd773c68a.jpg)

2、导入已存在的备份数据文件，命令：restore data &lt;superpwd&gt;

![](https://oscimg.oschina.net/oscnet/0df6dc925c15524e053aed8269eb746b051.jpg)

Winodws操作系统中操作步骤（其他操作系统中操作方式类似）：

1）执行o2server/start\_windows.bat

2）启动内置数据库（说明：如果使用的是外部数据，请确保数据已经正常启动，能够被o2server连接）

     执行命令：start data，启动完成后如下图所示：

![](https://oscimg.oschina.net/oscnet/b70426f80c01ac93f07f318b25706eaedc2.jpg)

3）恢复数据

      恢复数据前，需要确保需要恢复的数据文件已经存在，已经放置在o2server\local\dump目录中，并且文件夹命名方式为dumpData\_&lt;导出文件的时间标识&gt;，如dumpData\_20181016101732， 时间标识20181016101732将在导入命令中使用。

      执行命令：restore data 20181016101732 o2  （说明：其中o2是服务器默认的管理员密码， 20181016101732为导出文件的时间标识），执行效果如下图所示：      ![](https://oscimg.oschina.net/oscnet/7f660166108c21afc4691f7a7a219eb93ed.jpg)

       上图为O2OA系统正在执行数据恢复过程，请注意，如果原数据库中存在数据，原有来的数据将被清除。数据恢复过程执行完成后，如下图所示：

![](https://oscimg.oschina.net/oscnet/43f68a5d4d14077597f406e7517f4459c1c.jpg)

恢复完成后，会显示：

2018-10-16 10:42:01 PRINT \[main\] com.x.server.console.action.ActionRestoreData - restore data completed, total count: 56144, elapsed: 3 minutes.

在信息中指明了恢复的数据量和恢复过程消耗的时间：

导出的数据量：count: 56144,

导出过程消耗的时间：elapsed: 3 minutes.       

文件恢复完成后，直接键入start，即可正常启动服务器。

**三、文件存储导出和文件存储导入命令**

       1、文件存储导出和导入过程与数据导出导入过程类似，本篇不在赘述。

       2、文件存储导出导入也可以使用文件目录的复制和粘贴的方式进行。

