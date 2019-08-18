# 恢复数据

命令：restore data &lt;superpwd&gt;

![](../../.gitbook/assets/image%20%2843%29.png)

Winodws操作系统中操作步骤（其他操作系统中操作方式类似）：

1）执行o2server/start\_windows.bat

2）启动内置数据库（说明：如果使用的是外部数据，请确保数据已经正常启动，能够被o2server连接）

      执行命令：start data，启动完成后如下图所示：

![](../../.gitbook/assets/image%20%2856%29.png)

 3）恢复数据

      恢复数据前，需要确保需要恢复的数据文件已经存在，已经放置在o2server\local\dump目录中，并且文件夹命名方式为dumpData\_&lt;导出文件的时间标识&gt;，如dumpData\_20181016101732， 时间标识20181016101732将在导入命令中使用。

      执行命令：restore data 20181016101732 o2  （说明： 其中o2是服务器默认的管理员密码，  20181016101732为导出文件的时间标识），执行效果如下图所示： 

![](../../.gitbook/assets/image%20%28103%29.png)

       上图为O2OA系统正在执行数据恢复过程，请注意，如果原数据库中存在数据，原有来的数据将被清除。数据恢复过程执行完成后，如下图所示：

![](../../.gitbook/assets/image.png)

恢复完成后，会显示：

2018-10-16 10:42:01 PRINT \[main\] com.x.server.console.action.ActionRestoreData - restore data completed, total count: 56144, elapsed: 3 minutes.

在信息中指明了恢复的数据量和恢复过程消耗的时间：

导出的数据量：count: 56144,

导出过程消耗的时间：elapsed: 3 minutes.        文件恢复完成后，直接键入start，即可正常启动服务器。

