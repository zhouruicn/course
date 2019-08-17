# 备份数据

O2OA除了自动备份，还支持手工将服务器数据库中所有的数据进行导出操作。

![IMG\_257](file:///C:\Users\wwgwilly\AppData\Local\Temp\msohtmlclip1\01\clip_image002.gif)

Winodws操作系统中操作步骤（其他操作系统中操作方式类似）：

1）执行o2server/start\_windows.bat

2）启动内置数据库（说明：如果使用的是外部数据，请确保数据已经正常启动，能够被o2server连接）

     执行命令：start data，启动完成后如下图所示：

![IMG\_258](file:///C:\Users\wwgwilly\AppData\Local\Temp\msohtmlclip1\01\clip_image004.gif)

 3）导出数据

          执行命令：dump data o2  （说明：其中o2是服务器默认的管理员密码），执行效果如下图所示：

![IMG\_259](file:///C:\Users\wwgwilly\AppData\Local\Temp\msohtmlclip1\01\clip_image006.gif)

导出完成后，会显示：

2018-10-16 10:20:18 PRINT \[main\] com.x.server.console.action.ActionDumpData - dump data completed,   directory: D:\o2server\local\dump\dumpData\_20181016101732, count: 56144, elapsed: 2 minutes.

在信息中指明了导出的数据文件存放的路径以及导出的数据量和导出过程消耗的时间：

导出的数据文件存放的路径：directory: D:\o2server\local\dump\dumpData\_20181016101732

导出的数据量：count: 56144,

导出过程消耗的时间：elapsed: 2 minutes.

如下图所示：

![IMG\_260](file:///C:\Users\wwgwilly\AppData\Local\Temp\msohtmlclip1\01\clip_image008.gif)

导出文件存放位置：

