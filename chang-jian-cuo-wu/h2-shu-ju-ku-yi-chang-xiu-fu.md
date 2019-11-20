# H2数据库异常修复

用H2自带修改工具。

先从[http://www.h2database.com/html/download.htm](http://www.h2database.com/html/download.html)下载，并安装window版H2

![](../.gitbook/assets/image%20%28132%29.png)

一、将损坏的数据库X.h2.db移动到h2的bin目录下，如\h2\bin，

二、然后，进入cmd,后进入对应目录输入：

java -cp h2-1.4.200.jar org.h2.tools.Recover  

![](../.gitbook/assets/image%20%28103%29.png)

 于是，可以看到bin目录下生成了一个SQL文件X.h2.sql。

三、利用生成sql语句文档内容，再生成数据库X2

C:\Program Files\H2\bin&gt;java -cp h2-1.4.200.jar org.h2.tools.RunScript -url jdbc

:h2:./X2 -user sa -password o2 -script X.h2.sql

执行命令后，X.h2.sql内容写入到X2.mv.db

![](../.gitbook/assets/image%20%2857%29.png)

![](../.gitbook/assets/image%20%28144%29.png)

第二种修复方法：java -cp h2-1.4.200.jar org.h2.tools.Script -url jdbc:h2:./X -user sa -password o2 -script ./backup.sql  



