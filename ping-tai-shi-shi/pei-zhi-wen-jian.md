---
description: 本章节主要讲述平台支持的配置文件以及各项配置相关的用途说明。
---

# 平台配置文件说明

系统配置文件分成两类:

## local目录下的配置文件

配置样例文件位于localSample目录.

### node.cfg

用于标识当前节点的名称.

```text
127.0.0.1
```

## config目录下的配置文件

配置样例文件位于configSample目录.

### appStyle.json

配置原生app移动端样式和内容.

```javascript
{  "indexType": "default",  "indexPortal": "",  "nativeAppList": [],  "images": [],  "###indexType": "首页展现类型,default是移动端原来的首页,portal是门户.###",  "###indexPortal": "门户首页.###",  "###nativeAppList": "导航设置###",  "###images": "图片设置.###"}
```

### bindLogo.png

扫描二维码登录的二维码中心标识图片,长68px,宽68px.



### centerServer.json

center服务器配置.

```javascript
{  "enable": true,  "order": 0.0,  "sslEnable": false,  "redeploy": true,  "port": 20030.0,  "httpProtocol": "",  "proxyHost": "",  "proxyPort": 20030.0,  "scanInterval": 0.0,  "configApiEnable": true,  "###enable": "是否启用###",  "###order": "center节点顺序,顺序排列0,1,2...###",  "###sslEnable": "是否启用ssl传输加密,如果启用将使用config/keystore文件作为密钥文件.使用config/token.json文件中的sslKeyStorePassword字段为密钥密码,sslKeyManagerPassword为管理密码.###",  "###redeploy": "每次启动是否重新部署所有应用.###",  "###port": "端口,center服务器端口,默认20030###",  "###httpProtocol": "对外http访问协议,http/https###",  "###proxyHost": "代理主机,当服务器是通过apache/nginx等代理服务器映射到公网或者通过路由器做端口映射,在这样的情况下需要设置此地址以标明公网访问地址.###",  "###proxyPort": "代理端口,当服务器是通过apache/nginx等代理服务器映射到公网或者通过路由器做端口映射,在这样的情况下需要设置此地址以标明公网访问端口.###",  "###scanInterval": "重新扫描war包时间间隔(秒)###",  "###config": "其他参数###",  "###configApiEnable": "允许通过Api修改config###"}
```

### collect.json

云服务器配置.

```javascript
{  "enable": false,  "name": "",  "password": "",  "title": "",  "footer": "",  "appUrl": "",  "server": "",  "port": 20080.0,  "sslEnable": false,  "###enable": "是否启用连接到云平台###",  "###name": "云平台账户名称,同时显示在登录页面底部.###",  "###password": "云平台密码###",  "###title": "系统标题,同时显示在登录页面上部.###",  "###footer": "底部申明###",  "###appUrl": "app下载地址###",  "###server": "云平台服务器地址###",  "###port": "云平台端口###",  "###sslEnable": "云平台连接是否启用ssl###",  "###secret": "推送消息secret###",  "###key": "推送消息key###"}
```

### dingding.json

钉钉配置

```javascript
{  "enable": false,  "corpId": "",  "agentId": "",  "appKey": "",  "appSecret": "",  "syncCron": "10 0/10 * * * ?",  "forceSyncCron": "10 45 8,12 * * ?",  "oapiAddress": "https://oapi.dingtalk.com",  "messageEnable": true,  "###enable": "是否启用###",  "###corpId": "钉钉corpId###",  "###agentId": "agentId###",  "###appKey": "应用的key,唯一标识###",  "###appSecret": "应用的密钥###",  "###syncCron": "组织同步cron,默认每10分钟同步一次.###",  "###forceSyncCron": "强制拉入同步cron,默认在每天的8点和12点强制进行同步.###",  "###oapiAddress": "oapi服务器地址###",  "###messageEnable": "是否启用消息推送###"}
```

### dumpRestoreData.json

数据库数据和文件导出设置.

```javascript
{  "enable": false,  "includes": [],  "excludes": [],  "batchSize": 2000.0,  "###enable": "是否启用.###",  "###includes": "导出导入包含对象,可以使用通配符*.###",  "###excludes": "导出导入排除对象,可以使用通配符*.###",  "###batchSize": "批量对象数量.###"}
```

### dumpRestoreStorage.json

数据库数据和文件导入设置.

```javascript
{  "includes": [],  "excludes": [],  "batchSize": 500.0,  "redistribute": true,  "exceptionInvalidStorage": true,  "###enable": "是否启用.###",  "###includes": "导出导入包含对象,可以使用通配符*.###",  "###excludes": "导出导入排除对象,可以使用通配符*.###",  "###batchSize": "批量对象数量.###",  "###redistribute": "是否进行重新分布.###",  "###exceptionInvalidStorage": "无法获取storage是否升起错误.###"}
```

### logLevel.json

日志设置.

```javascript
{  "x_program_center": "",  "x_processplatform_service_processing": "",  "x_processplatform_assemble_surface": "",  "x_processplatform_assemble_designer": "",  "x_query_assemble_designer": "",  "x_query_assemble_surface": "",  "x_query_service_processing": "",  "x_meeting_assemble_control": "",  "x_organization_assemble_authentication": "",  "x_organization_assemble_control": "",  "x_general_assemble_control": "",  "x_file_assemble_control": "",  "x_attendance_assemble_control": "",  "x_collaboration_core_message": "",  "x_organization_core_express": "",  "x_query_core_express": "",  "x_bbs_assemble_control": "",  "x_calendar_assemble_control": "",  "x_cms_assemble_control": "",  "x_component_assemble_control": "",  "x_hotpic_assemble_control": "",  "x_message_assemble_communicate": "",  "x_mind_assemble_control": "",  "x_okr_assemble_control": "",  "x_organization_assemble_express": "",  "x_organization_assemble_personal": "",  "x_portal_assemble_designer": "",  "x_portal_assemble_surface": "",  "x_processplatform_assemble_bam": "",  "audit": {    "###enable": "是否启用审计日志###",    "###logSize": "审计日志保留天数###"  },  "###x_program_center": "是否启用调试###",  "###x_processplatform_service_processing": "是否启用调试###",  "###x_processplatform_assemble_surface": "是否启用调试###",  "###x_processplatform_assemble_designer": "是否启用调试###",  "###x_query_assemble_designer": "是否启用调试###",  "###x_query_assemble_surface": "是否启用调试###",  "###x_query_service_processing": "是否启用调试###",  "###x_meeting_assemble_control": "是否启用调试###",  "###x_organization_assemble_authentication": "是否启用调试###",  "###x_organization_assemble_control": "是否启用调试###",  "###x_general_assemble_control": "是否启用调试###",  "###x_file_assemble_control": "是否启用调试###",  "###x_attendance_assemble_control": "是否启用调试###",  "###x_collaboration_core_message": "是否启用调试###",  "###x_organization_core_express": "是否启用调试###",  "###x_query_core_express": "是否启用调试###",  "###x_bbs_assemble_control": "是否启用调试###",  "###x_calendar_assemble_control": "是否启用调试###",  "###x_cms_assemble_control": "是否启用调试###",  "###x_component_assemble_control": "是否启用调试###",  "###x_hotpic_assemble_control": "是否启用调试###",  "###x_message_assemble_communicate": "是否启用调试###",  "###x_mind_assemble_control": "是否启用调试###",  "###x_okr_assemble_control": "是否启用调试###",  "###x_organization_assemble_express": "是否启用调试###",  "###x_organization_assemble_personal": "是否启用调试###",  "###x_portal_assemble_designer": "是否启用调试###",  "###x_portal_assemble_surface": "是否启用调试###",  "###x_processplatform_assemble_bam": "是否启用调试###",  "###audit": "审计日志配置###"}
```

### meeting.json

会议管理以及openMeeting连接设置.

```javascript
{  "enable": false,  "oauth2Id": "5",  "port": 5080.0,  "host": "127.0.0.1",  "user": "xadmin",  "pass": "",  "anonymousAccessAttachment": false,  "###enable": "是否启用###",  "###oauth2Id": "openMeeting单点序号###",  "###port": "openMeeting端口###",  "###host": "openMeeting服务器###",  "###user": "openMeeting管理员账户###",  "###pass": "openMeeting管理员密码###",  "###httpProtocol": "openMeeting协议###",  "###anonymousAccessAttachment": "匿名用户是否可以访问附件###"}
```

### messages.json

消息配置.

```javascript
{  "attachment_editor": {    "consumers": [      "ws",      "pms",      "dingding",      "zhengwuDingding",      "qiyeweixin"    ]  },  "attachment_editorCancel": {    "consumers": [      "ws",      "pms",      "dingding",      "zhengwuDingding",      "qiyeweixin"    ]  },  "attachment_editorModify": {    "consumers": [      "ws",      "pms",      "dingding",      "zhengwuDingding",      "qiyeweixin"    ]  },  "attachment_share": {    "consumers": [      "ws",      "pms",      "dingding",      "zhengwuDingding",      "qiyeweixin"    ]  },  "attachment_shareCancel": {    "consumers": [      "ws",      "pms",      "dingding",      "zhengwuDingding",      "qiyeweixin"    ]  },  "meeting_delete": {    "consumers": [      "ws",      "pms",      "dingding",      "zhengwuDingding",      "qiyeweixin"    ]  },  "meeting_invite": {    "consumers": [      "ws",      "pms",      "dingding",      "zhengwuDingding",      "qiyeweixin"    ]  },  "readCompleted_create": {    "consumers": []  },  "readCompleted_delete": {    "consumers": []  },  "read_create": {    "consumers": [      "ws",      "pms",      "dingding",      "zhengwuDingding",      "qiyeweixin"    ]  },  "read_delete": {    "consumers": []  },  "taskCompleted_create": {    "consumers": []  },  "taskCompleted_delete": {    "consumers": []  },  "task_create": {    "consumers": [      "ws",      "pms",      "dingding",      "zhengwuDingding",      "qiyeweixin"    ]  },  "task_delete": {    "consumers": []  },  "task_press": {    "consumers": [      "ws",      "pms",      "dingding",      "zhengwuDingding",      "qiyeweixin"    ]  },  "###clean": "清理设置.###",  "clean": {    "enable": true,    "cron": "30 30 6 * * ?",    "keep": 7.0,    "###enable": "是否启用###",    "###cron": "定时cron表达式###",    "###keep": "消息保留天数###"  }}
```

### node\_127.0.0.1.json

节点配置.

```javascript
{  "enable": true,  "isPrimaryCenter": true,  "center": {    "enable": true,    "order": 0.0,    "sslEnable": false,    "redeploy": true,    "port": 20030.0,    "httpProtocol": "",    "proxyHost": "",    "proxyPort": 20030.0,    "scanInterval": 0.0,    "configApiEnable": true,    "###enable": "是否启用###",    "###order": "center节点顺序,顺序排列0,1,2...###",    "###sslEnable": "是否启用ssl传输加密,如果启用将使用config/keystore文件作为密钥文件.使用config/token.json文件中的sslKeyStorePassword字段为密钥密码,sslKeyManagerPassword为管理密码.###",    "###redeploy": "每次启动是否重新部署所有应用.###",    "###port": "端口,center服务器端口,默认20030###",    "###httpProtocol": "对外http访问协议,http/https###",    "###proxyHost": "代理主机,当服务器是通过apache/nginx等代理服务器映射到公网或者通过路由器做端口映射,在这样的情况下需要设置此地址以标明公网访问地址.###",    "###proxyPort": "代理端口,当服务器是通过apache/nginx等代理服务器映射到公网或者通过路由器做端口映射,在这样的情况下需要设置此地址以标明公网访问端口.###",    "###scanInterval": "重新扫描war包时间间隔(秒)###",    "###config": "其他参数###",    "###configApiEnable": "允许通过Api修改config###"  },  "application": {    "enable": true,    "port": 20020.0,    "sslEnable": false,    "proxyHost": "",    "proxyPort": 20020.0,    "redeploy": true,    "scanInterval": 0.0,    "includes": [],    "excludes": [],    "weights": [],    "###enable": "是否启用###",    "###port": "http/https端口,负责向前端提供数据访问接口.默认为20020端口.###",    "###sslEnable": "是否启用ssl传输加密,如果启用将使用config/keystore文件作为密钥文件.使用config/token.json文件中的sslKeyStorePassword字段为密钥密码,sslKeyManagerPassword为管理密码.###",    "###proxyHost": "代理主机,当服务器是通过apache/nginx等代理服务器映射到公网或者通过路由器做端口映射,在这样的情况下需要设置此地址以标明公网访问地址.###",    "###proxyPort": "代理端口,当服务器是通过apache/nginx等代理服务器映射到公网或者通过路由器做端口映射,在这样的情况下需要设置此地址以标明公网访问端口.###",    "###redeploy": "每次启动是否重载全部应用.###",    "###scanInterval": "应用reload扫描间隔,\u003c0 表示不会reload应用,扫描到应用文件发生了变化.###",    "###includes": "承载的应用,在集群环境下可以选择仅承载部分应用以降低服务器负载,可以使用*作为通配符.###",    "###excludes": "选择不承载的应用,和includes的值配合使用可以选择或者排除承载的应用,可以使用*作为通配符.###",    "###weights": "设置应用的权重,在集群环境中,一个应用可以部署多个实例提供负载均衡.通过合计占比来分配应用占比.###"  },  "web": {    "enable": true,    "sslEnable": false,    "proxyHost": "",    "weight": 100.0,    "dirAllowed": false,    "###enable": "是否启用###",    "###port": "http/https端口,用户输入网址后实际访问的第一个端口.http协议默认为80端口,https默认为443端口.###",    "###sslEnable": "是否启用ssl传输加密,如果启用将使用config/keystore文件作为密钥文件.使用config/token.json文件中的sslKeyStorePassword字段为密钥密码,sslKeyManagerPassword为管理密码.###",    "###proxyHost": "代理主机,当服务器是通过apache/nginx等代理服务器映射到公网或者通过路由器做端口映射,在这样的情况下需要设置此地址以标明公网访问地址.###",    "###proxyPort": "代理端口,当服务器是通过apache/nginx等代理服务器映射到公网或者通过路由器做端口映射,在这样的情况下需要设置此地址以标明公网访问端口.###",    "###weight": "设置权重.当前没有作用,###",    "###dirAllowed": "允许浏览目录,###"  },  "data": {    "enable": true,    "tcpPort": 20050.0,    "webPort": 20051.0,    "includes": [],    "excludes": [],    "jmxEnable": false,    "cacheSize": 512.0,    "logLevel": "WARN",    "###enable": "是否启用,如果没有可用的externalDataSources.json文件,那么默认会在节点中启用本地的H2数据库作为默认的数据库.###",    "###tcpPort": "H2数据库jdbc连接端口,登录的用户名:sa,密码为xadmin的密码.数据库创建在/o2server/local/repository/data/X.mv.db,一旦数据库文件被创建,那么该数据库的密码被创建.###",    "###webPort": "H2数据库web端口,H2提供一个web端的client,此端口为web端client的访问端口.用户名sa,密码为xadmin数据库初始创建的密码.###",    "###includes": "设置此数据库存储的类,默认情况下存储所有类型,如果需要对每个类进行单独的控制以达到高性能,可以将不同的类存储到不同的节点上提高性能.可以使用通配符*###",    "###excludes": "在此节点上不存储的类,和includes一起设置实际存储的类,可以使用通配符*###",    "###jmxEnable": "是否启动jmx,如果启用,可以通过本地的jmx客户端进行访问,不支持远程jmx客户端.###",    "###cacheSize": "H2数据库缓存大小,设置H2用于作为缓存的内存大小,以M作为单位,这里默认为512M.###",    "###logLevel": "默认日志级别###"  },  "storage": {    "enable": true,    "port": 20040.0,    "sslEnable": false,    "name": "251",    "accounts": [],    "###enable": "是否启用,对于二进制流文件,比如附件,图片等存储在单独的文件服务器中,可以支持多种文件服务器,默认情况下使用ftp服务器作为文件服务器,每个节点可以启动一个文件服务器以提供高性能.###",    "###port": "ftp服务器端口,此端口可以不对外开放,仅有ApplicationServer进行访问,并不直接对用户提供服务.###",    "###sslEnable": "是否启用ssl传输加密,如果启用将使用config/keystore文件作为密钥文件.使用config/token.json文件中的sslKeyStorePassword字段为密钥密码,sslKeyManagerPassword为管理密码.###",    "###name": "名称,多个节点中不能重名,默认为251.###",    "###accounts": "二进制流文件是分多个账号分段存储的,可以单独设置每个分类的存储配置,一般不需要设置.###",    "###passivePorts": "ftp传输有主动和被动之分,如果使用了被动传输,设置被动端口范围,默认为29000-30000.###"  },  "logLevel": "warn",  "dumpData": {    "enable": false,    "cron": "",    "size": 14.0,    "path": "",    "###enable": "是否启用,默认每天凌晨2点进行备份.###",    "###cron": "定时任务cron表达式###",    "###size": "最大保留份数,超过将自动删除最久的数据.###",    "###path": "备份路径###"  },  "dumpStorage": {    "enable": false,    "cron": "",    "size": 14.0,    "path": "",    "###enable": "是否启用,默认每天凌晨2点进行备份.###",    "###cron": "定时任务cron表达式###",    "###size": "最大保留份数,超过将自动删除最久的数据.###",    "###path": "备份路径###"  },  "restoreData": {    "cron": "",    "path": "",    "###enable": "是否启用,默认每天凌晨2点进行备份.###",    "###cron": "定时任务cron表达式###",    "###path": "恢复路径###"  },  "restoreStorage": {    "cron": "",    "path": "",    "###enable": "是否启用,默认每天凌晨2点进行备份.###",    "###cron": "定时任务cron表达式###",    "###path": "恢复路径###"  },  "nodeAgentEnable": false,  "nodeAgentPort": 20010.0,  "nodeAgentEncrypt": true,  "quickStartWebApp": false,  "###enable": "是否启用###",  "###isPrimaryCenter": "是否是center节点,仅允许存在一个center节点###",  "###center": "Center服务器配置###",  "###application": "Application服务器配置###",  "###web": "Web服务器配置###",  "###data": "Data服务器配置###",  "###storage": "Storage服务器配置###",  "###logLevel": "日志级别,默认当前节点的slf4j日志级别,通过系统变量\"org.slf4j.simpleLogger.defaultLogLevel\"设置到当前jvm中.###",  "###dumpData": "定时数据导出配置###",  "###dumpStorage": "定时存储文件导出配置###",  "###restoreData": "定时数据导入配置###",  "###restoreStorage": "定时存储文件导入配置###",  "###logSize": "日志文件保留天数.###",  "###auditLogSize": "审计日志文件保留天数.###",  "###nodeAgentEnable": "是否启用节点代理###",  "###nodeAgentPort": "是否启用节点端口###",  "###nodeAgentEncrypt": "是否启用节点代理加密###",  "###quickStartWebApp": "是否使用快速应用部署###",  "###banner": "服务器控制台启动标识###",  "###autoStart": "是否自动启动###"}
```

### person.json

用户配置

```javascript
{  "MAX_PASSWORDPERIOD": 3650.0,  "captchaLogin": true,  "codeLogin": true,  "bindLogin": true,  "faceLogin": true,  "password": "(var v \u003d person.getMobile(); return v.substring(v.length - 6))",  "passwordPeriod": 0.0,  "register": "disable",  "superPermission": true,  "###captchaLogin": "是否启用验证码登录,默认值:true###",  "###codeLogin": "是否启用验证码登录,默认值:true###",  "###bindLogin": "是否启用扫描二维码登录,默认值:false###",  "###faceLogin": "是否启用刷脸登录,默认值:false###",  "###password": "注册初始密码,使用()调用脚本生成初始密码,默认为:(var v \u003d person.getMobile(); return v.substring(v.length - 6))###",  "###passwordPeriod": "密码过期时间,0表示不过期,默认值:0###",  "###register": "是否允许用户自注册,disable:不允许,captcha通过验证码注册,code:通过短信注册,默认值:disable###",  "###superPermission": "是否启用超级管理员权限,默认值:true###",  "###mobileRegex": "手机号码校验正则表达式,()表示脚本内容,默认值:(^(\\+)?0{0,2}852\\d{8}$)|(^(\\+)?0{0,2}853\\d{8}$)|(^(\\+)?0{0,2}886\\d{9}$)|(^1(3|4|5|7|8|9)\\d{9}$)###",  "###loginPage": "定制登录页面设置.###",  "loginPage": {    "enable": false,    "portal": "",    "page": "",    "###enable": "是否启用定制登录页面.###",    "###portal": "指定登录页面所属的portal,可以用id,name,alias.###",    "###page": "指定的登录页面,可以使用name,alias,id###"  },  "###failureInterval": "登录限制时间(分钟)###",  "###failureCount": "尝试登录次数###",  "###tokenExpiredMinutes": "token时长,分钟###"}
```

### processPlatform.json

流程平台配置

```javascript
{  "urge": {    "enable": true,    "cron": "6 6/10 8-18 * * ?",    "###enable": "是否启用###",    "###cron": "定时cron表达式.###"  },  "expire": {    "enable": true,    "cron": "8 8/10 * * * ?",    "auto": "disable",    "###enable": "是否启用###",    "###cron": "定时cron表达式###",    "###auto": "自动处理模式,disable:禁用,neural:人工神经网络,single:仅处理只有一条路由的工作.###"  },  "delay": {    "enable": true,    "cron": "2 2/10 * * * ?",    "###enable": "是否启用###",    "###cron": "定时cron表达式###"  },  "reorganize": {    "enable": true,    "cron": "30 15 8,12,14 * * ?",    "triggerAfterMinutes": 1440.0,    "###enable": "是否启用###",    "###cron": "定时cron表达式###",    "###triggerAfterMinutes": "当工作滞留设定时间后,将尝试触发工作流转,可以自动处理由于人员变动的引起的工作滞留.###"  },  "dataMerge": {    "enable": false,    "cron": "30 30 6 * * ?",    "period": 730.0,    "###enable": "是否启用###",    "###cron": "定时cron表达式###",    "###period": "期限,已完成工作结束间隔指定时间进行merge,默认两年后进行merge###"  },  "maintenanceIdentity": "",  "formVersionPeriod": 45.0,  "processVersionPeriod": 45.0,  "scriptVersionPeriod": 45.0,  "docToWordType": "local",  "docToWordDefaultFileName": "正文.docx",  "docToWordDefaultSite": "$doc",  "###press": "提醒设置,设置提醒间隔.###",  "press": {    "###intervalMinutes": "提醒间隔(分钟)###",    "###count": "提醒数量限制.###"  },  "###urge": "催办任务设置,发现即将过期时发送提醒消息.###",  "###expire": "过期任务设置,将执行3个独立任务,1.将已经过了截至时间的待办标记过期,2.触发设置了过期路由的工作,3.如果启用了自动流转,那么开始自动流转,可以选择仅处理唯一路由的工作,或者启动基于MLP的人工神经网络进行处理.###",  "###delay": "延时任务设置,定时触发延时任务,当超过延时时间后继续流转.###",  "###reorganize": "整理任务设置,将执行4个独立任务,1.删除无效的待办,2.删除流程或者应用不存在的工作,3.将活动节点错误的工作调度到开始节点,4.触发滞留时间过长的工作.###",  "###dataMerge": "合并任务设置,定时触发合并任务,将已完成工作的Data从Item表中提取合并到WorkCompleted的Data字段中,默认工作完成后2年开始进行合并.###",  "###maintenanceIdentity": "维护身份,当工作发生意外错误,无法找到对应的处理人情况下,先尝试将工作分配给创建身份,如果创建身份也不可获取,那么分配给指定人员,默认情况下这个值为空.###",  "###formVersionPeriod": "表单历史版本保留天数.###",  "###processVersionPeriod": "流程历史版本保留天数.###",  "###scriptVersionPeriod": "脚本历史版本保留天数.###",  "###docToWordType": "HTML版式公文转换成Word文件方式,local,cloud.###",  "###docToWordDefaultFileName": "HTML版式公文转换成Word文件缺省文件名.###",  "###docToWordDefaultSite": "HTML版式公文转换成Word文件缺省site.###"}
```

### qiyeweixin.json

企业微信配置.

```javascript
{  "enable": false,  "syncCron": "10 0/10 * * * ?",  "forceSyncCron": "10 45 8,12 * * ?",  "apiAddress": "https://qyapi.weixin.qq.com",  "corpId": "",  "corpSecret": "",  "agentId": "",  "token": "",  "encodingAesKey": "",  "messageEnable": true,  "###enable": "是否启用.###",  "###syncCron": "拉入同步cron,默认每10分钟同步一次.###",  "###forceSyncCron": "强制拉入同步cron,默认在每天的8点和12点强制进行同步.###",  "###apiAddress": "api服务器地址###",  "###corpId": "企业微信corpId###",  "###corpSecret": "企业微信corpSecret###",  "###agentId": "企业微信agentId###",  "###token": "回调token###",  "###encodingAesKey": "回调encodingAesKey###",  "###messageEnable": "推送消息到企业微信###"}
```

### query.json

数据中心配置

```javascript
{  "crawlWorkCompleted": {    "enable": true,    "cron": "50 50 21 * * ?",    "count": 5000.0,    "###enable": "是否启用###",    "###cron": "定时cron表达式.###",    "###count": "每次处理的数量,默认为5000,同时每次将重爬最旧的10%以提高数据质量.###"  },  "crawlWork": {    "enable": true,    "cron": "45 45 * * * ?",    "count": 1000.0,    "###enable": "是否启用###",    "###cron": "定时cron表达式.###",    "###count": "每次处理的数量,默认为1000,同时每次将重爬最旧的25%以提高数据质量.###"  },  "crawlCms": {    "enable": true,    "cron": "55 55 8/2 * * ?",    "count": 1000.0,    "###enable": "是否启用###",    "###cron": "定时cron表达式.###",    "###count": "每次处理的数量,默认为1000,同时每次将重爬最旧的10%以提高数据质量.###"  },  "extractOffice": true,  "extractPdf": true,  "extractText": true,  "extractImage": false,  "tessLanguage": "chi_sim",  "###crawlWorkCompleted": "已完成工作收集器设置.###",  "###crawlWork": "工作收集器设置.###",  "###crawlCms": "内容管理收集器设置.###",  "###extractOffice": "抽取office中的文本.###",  "###extractPdf": "抽取pdf中的文本.###",  "###extractText": "抽取文本中的文本.###",  "###extractImage": "抽取图像中的文本.###",  "###tessLanguage": "tess使用语言.###"}
```

### startImage.png

服务器启动时显示的logo图标,通过ASCII码展现,图片要求背景透明,长40px,宽20px.

### token.json

认证配置.

```javascript
{  "key": "",  "password": "",  "sslKeyStorePassword": "12345678",  "sslKeyManagerPassword": "12345678",  "initialManager": "xadmin",  "initialManagerDistinguishedName": "xadmin@o2oa@P",  "ssos": [    {      "enable": false,      "client": "",      "key": "",      "###enable": "是否启用###",      "###client": "名称###",      "###key": "密钥###"    }  ],  "oauths": [    {      "enable": false,      "clientId": "",      "mapping": {},      "###enable": "是否启用###",      "###clientId": "客户端名称###",      "###mapping": "返回值###"    }  ],  "oauthClients": [    {      "enable": false,      "name": "",      "displayName": "",      "icon": "",      "clientId": "",      "clientSecret": "",      "authAddress": "",      "authParameter": "client_id\u003d{$client_id}\u0026redirect_uri\u003d{$redirect_uri}",      "authMethod": "GET",      "tokenAddress": "",      "tokenParameter": "client_id\u003d{$client_id}\u0026client_secret\u003d{$client_secret}\u0026redirect_uri\u003d{$redirect_uri}\u0026grant_type\u003dauthorization_code\u0026code\u003d{$code}",      "tokenMethod": "POST",      "tokenType": "json",      "infoAddress": "",      "infoParameter": "access_token\u003d{$access_token}",      "infoMethod": "GET",      "infoType": "json",      "infoCredentialField": "openId",      "infoScriptText": "",      "bindingEnable": false,      "bindingField": "",      "###enable": "是否启用.###",      "###name": "名称.###",      "###displayName": "显示名称.###",      "###icon": "图标.###",      "###clientId": "用户oauth2认证的client_id.###",      "###clientSecret": "用户oauth2认证的client_secret.###",      "###authAddress": "认证后的跳转地址.###",      "###authParameter": "请求密钥方法参数.###",      "###authMethod": "请求密钥方法.一般为GET###",      "###tokenAddress": "请求令牌网址.###",      "###tokenParameter": "请求令牌方法参数.###",      "###tokenMethod": "请求令牌方法.一般为POST###",      "###tokenType": "token信息格式.json格式或者form格式###",      "###infoAddress": "请求信息网址.###",      "###infoParameter": "请求信息方法参数.###",      "###infoMethod": "请求信息方法.一般为GET###",      "###infoType": "info信息格式.json格式或者form格式或者script格式###",      "###infoCredentialField": "info信息中用于标识个人的字段.###",      "###infoScriptText": "info信息中用于标识个人的字段.###",      "###bindingEnable": "是否允许绑定到用户,如果允许,用户可以自行绑定.###",      "###bindingField": "绑定字段,对端的用户标识,一般为openId绑定到个人字段,可选值为open1Id,open2Id,open3Id,open4Id,open5Id###"    }  ],  "###key": "加密用口令的密钥,修改后会导致用户口令验证失败.###",  "###password": "初始管理员密码,用于内部数据库和FTP文件服务器,以及http的token加密.###",  "###sslKeyStorePassword": "ssl密码###",  "###sslKeyManagerPassword": "ssl管理密码###",  "###initialManager": "初始管理员名称,目前不可更改.###",  "###initialManagerDistinguishedName": "初始管理员DistinguishedName,不可更改.###",  "###ssos": "sso登录配置###",  "###oauths": "oauth单点登录配置###",  "###oauthClients": "作为客户端单点登录配置###"}
```

### vfs.json

服务器中使用vfs作为中间协议转换服务,vfs.json用于配置vfs一些特性.

```javascript
{  "ftp": {    "passive": true  }}
```

### workTime.json

工作时间,节假日配置

```javascript
{  "amStart": "09:00:00",  "amEnd": "11:30:00",  "pmStart": "13:00:00",  "pmEnd": "17:30:00",  "holidays": [],  "workdays": [],  "weekends": [    1.0,    7.0  ],  "###amStart": "工作时间上午开始时间###",  "###amEnd": "工作时间上午结束时间###",  "###pmStart": "工作时间下午开始时间###",  "###pmEnd": "工作时间下午结束时间###",  "###holidays": "固定节假日,格式为[\"2019-01-01\",\"2019-05-01\"]###",  "###workdays": "固定工作时间,格式为[\"2019-01-01\",\"2019-05-01\"]###",  "###weekends": "周末设定,默认格式为[1,7]其中1代表周日,7代表周六.###"}
```

### zhengwuDingding.json

政务钉钉配置.

```javascript
{  "enable": false,  "appSecret": "",  "agentId": "",  "syncCron": "10 0/10 * * * ?",  "forceSyncCron": "10 45 8,12 * * ?",  "oapiAddress": "https://oapi.dingtalk.com",  "corpId": "",  "corpSecret": "",  "titleSplit": [    ",",    "、",    "，",    " ",    "　"  ],  "personAttributeTitleName": "职务",  "nonce": "o2oa",  "messageEnable": true,  "###enable": "是否启用.###",  "###appId": "政务钉钉appId###",  "###appSecret": "政务钉钉appSecret###",  "###agentId": "政务钉钉agentId###",  "###syncCron": "拉入同步cron,默认每10分钟同步一次.###",  "###forceSyncCron": "强制拉入同步cron,默认在每天的8点和12点强制进行同步.###",  "###oapiAddress": "oapi服务器地址###",  "###corpId": "政务钉钉corpId###",  "###corpSecret": "政务钉钉corpSecret###",  "###titleSplit": "title分隔符###",  "###personAttributeTitleName": "title对应个人属性名称###",  "###nonce": "政务钉钉nonce###",  "###messageEnable": "推送消息到政务钉钉消息###"}
```

