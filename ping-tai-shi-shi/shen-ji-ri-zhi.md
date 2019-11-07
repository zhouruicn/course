# 平台审计日志配置

## 启用审计日志

config/logLevel.json文件中:

```text
  "audit": {    "enable": true,    "logSize": 21  }
```

enable:是否启用审计日志,默认不启用.

logSize:审计日志保留天数.

## 审计日志格式

审计日志存放在logs目录下,文件名为2018\_01\_01.audit.log,每天一个,重启服务器添加到上次结束后.

2019-08-09 10:33:40,,,193,,,anonymous,,,127.0.0.1,,,/x\_organization\_assemble\_authentication/jaxrs/authentication/bind,,,Mozilla/5.0 \(Windows NT 10.0; Win64; x64\) AppleWebKit/537.36 \(KHTML, like Gecko\) Chrome/76.0.3809.100 Safari/537.36,,,com.x.organization.assemble.authentication.jaxrs.authentication.ActionBind,,,日渐

如：

```text
2019-08-09 10:33:40,,,193,,,anonymous,,,127.0.0.1,,,/x_organization_assemble_authentication/jaxrs/authentication/bind,,,Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36,,,com.x.organization.assemble.authentication.jaxrs.authentication.ActionBind,,,日渐
```

时间,,,执行毫秒,,,当前用户,,,地址,,,浏览器信息,,,运行类,,,扩充

