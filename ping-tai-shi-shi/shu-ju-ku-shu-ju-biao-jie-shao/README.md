# 数据库配置

平台默认内置H2数据,在正式环境中建议使用外部数据库.

外部数据库通过config/externalDataSources.json配置实现.

```text
[ 
	{
		"enable": false,
		"url": "", 
		"username": "",
		"password": "",
		"includes": [],
		"excludes": [],
		"logLevel": "WARN"
	}
]
```



