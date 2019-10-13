# O2OA集群部署

## 说明

服务器环境由一下部分组成:

Web服务器

Center服务器

Application服务器

Storage服务器\(附件存储服务器\)

Data服务器\(数据库服务器\)

系统支持集群方式进行应用扩展.

![](../../.gitbook/assets/image%20%28134%29.png)

扩展依靠配置文件实现,可以对以下服务器进行扩展:

Web服务器

Application服务器

Storage服务器

Data服务器

目前尚不支持Center服务器的集群扩展,在后续版本将会支持.



## 主机信息

主机：192.168.0.1

主机：192.168.0.2

## 集群需求

192.168.0.1：应用服务器，文件存储服务器，数据库服务器，中心服务器，WEB服务器

192.168.0.2：应用服务器，文件存储服务器，数据库服务器

## 配置步骤

### 一、配置节点标识

1、在主机192.168.0.1的o2server/local目录中修改或者新增文件node.cfg，修改内容为主机的域名或者IP（如果以域名访问，则内容为域名，如demo.o2oa.net）；

主机192.168.0.1的节点标识文件配置

| 192.168.0.1 |
| :--- |


2、在主机192.168.0.2的o2server/local目录中修改或者新增文件node.cfg，修改内容为主机的域名或者IP（如果以域名访问，则内容为域名，如demo.o2oa.net）；

主机192.168.0.2的节点标识文件配置

| 192.168.0.2 |
| :--- |


### 二、准备配置文件

双机集群需要准备两份服务器IP命名的配置文件（如果以域名访问，则需要以域名方式对文件命名如node\_demo.o2oa.net.json）：

1、从任一主机的o2server/configSample目录中copy文件node\_127.0.0.1.json到其他目录，命令为node\_192.168.0.1.json

2、同步骤1，从任一主机的o2server/configSample目录中copy文件node\_127.0.0.1.json到其他目录，命令为node\_192.168.0.2.json

3、修改node\_192.168.0.1.json，修改isPrimaryCenter = true，标记该服务器为中心服务器，配置文件如下：

<table>
  <thead>
    <tr>
      <th style="text-align:left">
        <p>{</p>
        <p>&quot;enable&quot;: true,</p>
        <p> <b>&quot;isPrimaryCenter&quot;: true,</b>
        </p>
        <p>&quot;application&quot;: {</p>
        <p> <b> &quot;enable&quot;: true,</b>
        </p>
        <p>......</p>
        <p>},</p>
        <p>&quot;web&quot;: {</p>
        <p> <b>&quot;enable&quot;: true,</b>
        </p>
        <p>......</p>
        <p>},</p>
        <p>&quot;data&quot;: {</p>
        <p> <b>&quot;enable&quot;: true,</b>
        </p>
        <p>......</p>
        <p>},</p>
        <p>&quot;storage&quot;: {</p>
        <p> <b>&quot;enable&quot;: true,</b>
        </p>
        <p>......</p>
        <p>},</p>
        <p>......</p>
        <p>}</p>
      </th>
    </tr>
  </thead>
  <tbody></tbody>
</table>3、修改node\_192.168.0.2.json，修改isPrimaryCenter = false，标记该服务器不是中心服务器，并且关闭该服务器的WEB服务器，配置文件如下：

<table>
  <thead>
    <tr>
      <th style="text-align:left">
        <p>{</p>
        <p>&quot;enable&quot;: true,</p>
        <p> <b>&quot;isPrimaryCenter&quot;: false,</b>
        </p>
        <p>&quot;application&quot;: {</p>
        <p> <b>&quot;enable&quot;: true,</b>
        </p>
        <p>......</p>
        <p>},</p>
        <p>&quot;web&quot;: {</p>
        <p> <b>&quot;enable&quot;: false,</b>
        </p>
        <p>&quot;sslEnable&quot;: false,</p>
        <p>&quot;proxyHost&quot;: &quot;&quot;,</p>
        <p>......</p>
        <p>},</p>
        <p>&quot;data&quot;: {</p>
        <p> <b>&quot;enable&quot;: true,</b>
        </p>
        <p>......</p>
        <p>},</p>
        <p>&quot;storage&quot;: {</p>
        <p> <b>&quot;enable&quot;: true,</b>
        </p>
        <p>......</p>
        <p>},</p>
        <p>......</p>
        <p>}</p>
      </th>
    </tr>
  </thead>
  <tbody></tbody>
</table>4、将配置文件node\_192.168.0.1.json和node\_192.168.0.2.json，同时放到两台服务器的o2server/config目录内.

### 三、启动服务器

1、启动服务器192.168.0.1

服务器192.168.0.1应该启动全部服务，所以在执行start\_windows.bat或者./start\_linux.sh后，直接键入start启动服务器即可。

2、启动服务器192.168.0.2

服务器192.168.0.2只需要启动部分服务，所以需要依次键入命令启动相应的服务器：

1）启动数据库服务器

键入命令：start data

2）启动文件存储服务器

键入命令：start storage

3）启动应用服务器

注意：192.168.0.2启动之前192.168.0.1的中心服务器一定要先启动完成，否则应用服务器启动会报错。

键入命令：start application

