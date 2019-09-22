---
description: 与其他系统实现单点登入
---

# SSO管理

1.1 URL传递加密参数方式 

这种方式是比较通用简单的实现方式，应急门户将用户登录信息（用户ID）以URL参数方式传递给被集成系统，被集成系统通过接收参数获取登陆用户的信息，实现单点登陆。

 1.1.1 集成前提 

1、被集成系统为B/S架构。 

2、被集成系统可以二次开发接收参数。

 3、被集成系统需要使用相同的加密解密算法。

 1.1.2 集成方式 URL传加密参数方式优点在于通用性较强。为了系统安全，传递参数的值都通过加密算法\(DES2\)加密，并通过其它方法来保证安全性。这种方式对被集成系统要求比较低，针对被集成系统现状可以灵活转变。

 1.1.3 场景 

用户登录到OA系统后，点击对方系统链接，系统会自动跳转到OA系统的中间页面，中间页面将登陆用户的ID（uid：邮箱账号前缀）和系统当前时间（current）加密后设置到表单域然后通过post方式提交对方系统指定url，对方系统在接受到参数后首先通过对应解密算法解密参数值，得到uid和current两个参数的值，然后验证uid合法性，验证URL时间合法性（规则见2.1.5）。如果以上两项中有不符合要求，跳转到系统登录页面。如果两项都通过，初始化系统后进入系统。

 1.1.4 加密算法 

本次uid和current加密解密都是通过DES2加解密算法来实现。算法中key由双方商定。

算法调用如下： 返回值 方法名 说明 String createEncryptor\(String str\) 加密字符串 String byteToString\(byte\[\] str\) 转换byte数组为字符串 byte\[\] stringToByte\(String str\) 转换字符串为byte\[\]型数据 String createDecryptor\(String str\) 解密字符串 

代码片断： DES2 des = new DES2\(key\); String str = “tempstr”; String tempstr = des. createEncryptor\(str\);//加密字符串 String strtmp = des. createDecryptor\(tempstr\);//解密字符串

1.1.5 URL合法性验证规则 

此次为防止盗用链接，设置时间校验。系统接收到current后，用系统当前时间和current比较，如果时间之差在10分钟之内，则视为有效的URL，否则视为无效的URL。时间验证需要同步物理主机的时间。

 current验证规则代码片断： String current = request.getParemter\(“current”\);//获得current参数 DES2 des = new DES2\(key\); current = des.createDecryptor \(current\);//解密字符串 long oldTime = Long.parseLong\(s\); Calendar cal = Calendar.getInstance\(\); long time = cal.getTimeInMillis\(\); if\(time-oldtime&lt;600000\){ url有效 ...... }else{ 跳转到登录页面 }

