# SSO客户端程序

get方式：

java加密方式：

String login\_uid = "test"; 

long time = new Date\(\).getTime\(\); 

String sso\_key = "12345678";

 String xtoken = **Crypto**.encrypt\( login\_uid + "\#" + time, sso\_key \);

js脚本打开url,如下：

var client = "unicom"; 

var xtoken = "5no3eDzdxrU1-cV\_7F7e1gZq-RKMrJ-X" ；

var redirect= "[http://127.0.0.1/x\_desktop/app.html?app=process.TaskCenter](http://127.0.0.1/x_desktop/app.html?app=process.TaskCenter)" ；

var url = "[http://127.0.0.1/x\_desktop/sso.html](http://127.0.0.1/x_desktop/sso.html)" + "?client=" + client + "&xtoken=" + xtoken + "&redirect=" + redirect ; 

window.open\(url\)；

post方式：

![](../../.gitbook/assets/image%20%28106%29.png)

sso.html文件所在路径

![](../../.gitbook/assets/image%20%28139%29.png)

