---
description: O2OA提供多种单点认证配置，如约定密钥的单点认证配置，OAuth2客户端与服务端配置支持。本文主要讲解如果使用约定密钥实现外部系统与O2OA的单点认证。
---

# 约定密钥单点认证配置

![](../../.gitbook/assets/1%20%2811%29.png)

## 关于用户账号同步

通过单点认证的系统中拥有统一的用户登录账号，或者进行某种账号映射是单点认证登录设置的基础。

## 单点认证配置入口

在系统菜单-控制面板-系统设置中定制您的系统。点击系统菜单，找到“系统SSO配置置”，点击后打开设计中心。

![&#x6253;&#x5F00;&#x7CFB;&#x7EDF;&#x4E3B;&#x83DC;&#x5355;](../../.gitbook/assets/2%20%287%29.png)

![&#x6253;&#x5F00;&#x63A7;&#x4EF6;&#x9762;&#x677F;](../../.gitbook/assets/3%20%283%29.png)

## 约定密钥的单点认证

在控制面板 - 系统设置 - 基础配置 - 系统SSO配置界面添加一个SSO配置：

![](../../.gitbook/assets/4%20%289%29.png)

{% hint style="info" %}
当然也可以在服务器配置文件：o2server/config/token.json中进行配置，如果config目录中没有该配置文件，可以从o2server/configSample目录中COPY文件token.json到o2server/config目录后再进行配置文件修改
{% endhint %}

```text
"ssos": [
    {
      "enable": true,
      "client": "ERP",
      "key": "password"
    }
  ],
```

参数配置：

```text
"enable": "是否启用",
"client": "名称",
"key": "密钥"
```

## 数据加密工具类（Java）

Crypto.java

```text
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

/**
 * encrypt and decrypt utils
 * @author O2OA
 *
 */
public class Crypto {

	private static final String utf8 = "UTF-8";
	private final static String DES = "DES";
	private final static String cipher_init = "DES";

	public static String encrypt(String data, String key) throws Exception {
		byte[] bt = encrypt(data.getBytes(), key.getBytes());
		String str = Base64.encodeBase64URLSafeString(bt);
		return URLEncoder.encode( str, utf8 );
	}

	public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);
		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);
		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(cipher_init);
		// 用密钥初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
		return cipher.doFinal(data);
	}

	public static String decrypt(String data, String key) throws IOException, Exception {
		if (StringUtils.isEmpty(data)) {
			return null;
		}
		String str = URLDecoder.decode(data, utf8);
		byte[] buf = Base64.decodeBase64(str);
		byte[] bt = decrypt(buf, key.getBytes());
		return new String(bt);
	}

	public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);
		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance(cipher_init);
		// 用密钥初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
		return cipher.doFinal(data);
	}
}
```

## 从第三方系统登录O2OA

### 第三方系统使用数据加密登录O2OA

```text
/**
	 * 从系统中获取已经登录第三方系统的用户账号，并且进行账号和信息加密，送到到O2OA进行登录
*/
//sso名称和密码是在O2OA平台中约定的配置项
String sso_client_name = "ERP";
String sso_key = "password";
//sso_url在O2OA平台中准备好的单点登录页面模板
//文件路径：o2server/servers/webserver/x_desktop/sso.html
String sso_url = "http://o2oa_hostip:port/x_desktop/sso.html";
		
//login_uid为在第三方系统中识别的登录账号名，这里理解为双方系统账号是统一的账号
String login_uid = "user1";
		
//获取当前时间
long time = new Date().getTime();
//将用户账号和登录时间一起使用sso_key进行信息加密
String xtoken = null;
try {
	xtoken = Crypto.encrypt( login_uid + "#" + time, sso_key );
	response.sendRedirect( sso_url + "?client=" + sso_client_name + "&xtoken=" + xtoken );
} catch (Exception e) {
	e.printStackTrace();
}
```

{% hint style="info" %}
信息加密后，将用户的登录账号（O2OA可以识别的账号）以及登录时间一起使用约定的密码进行加密，然后发送到O2OA的sso.html
{% endhint %}

### O2OA相关修改（sso.html）

文件路径：o2server/servers/webServer/x\_desktop/sso.html 修改登录相关的代码

```text
......
COMMON.setContentPath("/x_desktop");
COMMON.AjaxModule.load("mwf", function(){
    MWF.getJSON("res/config/config.json", function(config){
        getServiceAddress(config, function(address){
            var uri = new URI(window.location.toString());
            var xtoken = uri.getData("xtoken");
            var client = uri.getData("client");
            if (xtoken){
                var res = new Request.JSON({
                    url: address+"/jaxrs/sso",
                    secure: false,
                    method: "POST",
                    noCache: true,
                    withCredentials: true,
                    onSuccess: function(responseJSON, responseText){
                         window.location = "/index.html" ;
                    }.bind(this),
                    onFailure: function(xhr){
                         window.location = "/index.html";
                    }.bind(this),
                    onError: function(text, error){
                        window.location = "/index.html";
                    }.bind(this)
                });
                res.setHeader("Content-Type", "application/json; charset=utf-8");
                var json = {"token": xtoken, "client": client};
                res.send(JSON.encode(json));
            }else{
                window.location = "/index.html";
            }
});
});

```

{% hint style="info" %}
系统登录成功，可以指定到单独的门户页面，或者打开指定应用界面。登录失败后，也可以指定到单独的错误处理页面
{% endhint %}



