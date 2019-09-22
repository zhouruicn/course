# 备份恢复数据

## **数据导出和数据导入命令**

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

## **文件存储导出和文件存储导入命令**

       1、文件存储导出和导入过程与数据导出导入过程类似，本篇不在赘述。

       2、文件存储导出导入也可以使用文件目录的复制和粘贴的方式进行。

