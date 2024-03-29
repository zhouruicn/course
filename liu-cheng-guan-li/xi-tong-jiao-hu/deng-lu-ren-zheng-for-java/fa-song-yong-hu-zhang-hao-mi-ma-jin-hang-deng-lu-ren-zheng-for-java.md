---
description: 此示例演示如何使用java发送Http请求来登录o2server，获取登录认证xtoken信息
---

# 发送用户账号密码进行登录认证

完整代码示例：

{% tabs %}
{% tab title="使用账号密码发送请求登录" %}
```java
package net.o2oa.demos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.codec.binary.StringUtils;
import org.json.JSONObject;

/**
 * 此示例演示如何使用java发送Http请求来登录o2server，获取登录认证xtoken信息 * @author O2OA
 */
public class Demo_LoginToServer {
    static final String URL_LOGIN = "/x_organization_assemble_authentication/jaxrs/authentication";

    public static void main(String[] args) {
        String applicationServer = "127.0.0.1";
        Integer applicationPort = 20020;
        String userName = "张三";
        String password = "o2";
        try {
            LoginResult result = login(applicationServer, applicationPort, userName, password);
            if (StringUtils.equals("success", result.getType())) {
                System.out.println("xtoken=" + result.getToken());
            } else {
                System.out.println("message:" + result.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //服务地址：http://127.0.0.1:20020/x_organization_assemble_authentication/jaxrs/authentication
    // {"credential":"xadmin","password":"o2"}
    /**
     * 使用登录认证的接口进行服务器登录，获取xtoken信息
     * @param applicationServer  127.0.0.1
     * @param applicationPort     20020
     * @param userName             张三
     * @param password              o2
     * @return
     * @throws Exception
     */
    public static LoginResult login(String applicationServer, Integer applicationPort, String userName, String password) throws Exception {
        //参数
        String loginUrl = "http://" + applicationServer + ":" + applicationPort + URL_LOGIN;
        String loginParams = String.format("{'credential':'%s','password':'%s'}", userName, password);
        String responseData = sendPost(loginUrl, loginParams);
        JSONObject result = new JSONObject(responseData);
        String type = result.getString("type");
        if (StringUtils.equals("success", type)) {
            //登录成功
            JSONObject data = result.getJSONObject("data");
            String token = data.getString("token");
            return new LoginResult("success", token, "登录成功！");
        } else {
            //登录失败
            return new LoginResult("error", null, "用户不存在或者密码错误！");
        }
    }

    /**
     * 发送POST请求     * 	 * @param url  地址	 * @param param   传入的数据	 * @return
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static class LoginResult {
        private String type;
        private String token;
        private String message;

        public LoginResult(String type, String token, String message) {
            super();
            this.type = type;
            this.token = token;
            this.message = message;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
```
{% endtab %}
{% endtabs %}

{% tabs %}
{% tab title="成功响应结果" %}
```javascript
{
  "type": "success",
  "data": {
    "tokenType": "manager",
    "token": "HeEoZIVgPjQAuhSAF5z5qKCO-_-iWowwEIdiuKMfurQ",
    "roleList": [
      "Manager",
      "OrganizationManager",
      "MeetingManager",
      "ProcessPlatformManager"
    ],
    "id": "xadmin",
    "name": "xadmin",
    "employee": "xadmin",
    "distinguishedName": "xadmin@o2oa@P",
    "mail": "xadmin@o2oa.net",
    "weixin": "",
    "qq": "",
    "mobile": ""
  },
  "message": "",
  "date": "2019-10-19 14:15:17",
  "spent": 18,
  "size": -1,
  "count": 0,
  "position": 0
}
```
{% endtab %}
{% endtabs %}

{% tabs %}
{% tab title="失败响应结果" %}
```javascript
{
  "readyState": 4,
  "responseText": "{\"type\": \"error\",\"message\": \"用户不存在或者密码错误.\",\"date\": \"2019-10-19 14:34:34\",\"spent\": 9,  \"size\": -1,  \"count\": 0,  \"position\": 0,   \"prompt\":\"com.x.organization.assemble.authentication.jaxrs.authentication.ExceptionPersonNotExistOrInvalidPassword\"  }",
  "responseJSON": {
    "type": "error",
    "message": "用户不存在或者密码错误.",
    "date": "2019-10-19 14:34:34",
    "spent": 9,
    "size": -1,
    "count": 0,
    "position": 0,
    "prompt": "com.x.organization.assemble.authentication.jaxrs.authentication.ExceptionPersonNotExistOrInvalidPassword"
  },
  "status": 500,
  "statusText": "Internal Server Error"
}
```
{% endtab %}
{% endtabs %}

pom.xml

```markup
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>net.o2oa.demos</groupId>
    <artifactId>test_start_process_demo</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>
    <name>test_start_process_demo</name>
    <url>http://maven.apache.org</url>
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    <dependencies>        <!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient -->
        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpclient</artifactId>
            <version>4.5.10</version>
        </dependency>        <!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpcore-nio -->
        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpcore-nio</artifactId>
            <version>4.4.12</version>
        </dependency>        <!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpcore -->
        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpcore</artifactId>
            <version>4.4.12</version>
        </dependency>        <!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpmime -->
        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpmime</artifactId>
            <version>4.5.10</version>
        </dependency>
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>3.9</version>
        </dependency>
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.5</version>
        </dependency>        <!-- https://mvnrepository.com/artifact/org.json/json -->
        <dependency>
            <groupId>org.json</groupId>
            <artifactId>json</artifactId>
            <version>20190722</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

示例下载（Eclipse，JDK1.8）：

{% file src="../../../.gitbook/assets/test\_o2oa\_java\_demo \(1\).zip" caption="test\_o2oa\_java\_demo.zip" %}

