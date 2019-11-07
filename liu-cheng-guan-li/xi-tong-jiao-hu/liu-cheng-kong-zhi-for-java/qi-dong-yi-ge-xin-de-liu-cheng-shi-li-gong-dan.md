---
description: 本例使用Java语言发送请求，向服务器进行认证后，启动一个新的流程，创建一个工单
---

# 启动一个新的流程实例（工单）

完整代码：

{% tabs %}
{% tab title="Demo\_StartProcess.java" %}
```java
package net.o2oa.demos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import net.o2oa.demos.Demo_LoginToServer.LoginResult;

/**
 * 本例使用Java语言发送请求，向服务器进行认证后，启动一个新的流程，创建一个工单
 * @author O2OA
 *
 */
public class Demo_StartProcess {
	
	static final String URL_LOGIN="/x_processplatform_assemble_surface/jaxrs/work/process/";
	
    public static void main( String[] args ) {
    	String applicationServer = "127.0.0.1";
		Integer applicationPort = 20020;
		String userName = "张三";
		String password = "o2";
		String identity ="测试部门	张三@9659e75d-b3f3-4eb3-bf26-52812d9228ec@I";
		
		String processFlag = "bc4b0018-edee-4225-838e-1b2db5c24f25";
		String processData = "{\"latest\":\"false\",\"title\":\"使用Java启动流程示例一\",\"identity\":\""+identity+"\",\"data\":\"{'name':'这是Name参数'}\"}";
		
		try {
			LoginResult result = Demo_LoginToServer.login(applicationServer, applicationPort, userName, password);
			if( StringUtils.equals( "success", result.getType() )) {
				//成功登录 到O2Server
				System.out.println("成功登录到O2Server！xtoken=" + result.getToken() );
				//启动指定的流程
				start( applicationServer, applicationPort, processFlag, processData, result.getToken() );
			}else {
				//登录失败
				System.out.println("登录失败！message:" + result.getMessage() );
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static List<String> start( String applicationServer, Integer applicationPort, String processFlag, String processData, String xtoken ) throws Exception {

    	//将xtoken添加到httpHeader里，调用服务一定要添加认证过的token
    	Map<String, String> headMap = getHeader( xtoken );

        String path = "http://" + applicationServer + ":" + applicationPort + URL_LOGIN + processFlag ;
        String responseData =  sendPost( path, processData, headMap);

        /**
         * {
			  "type": "success",
			  "data": [
			    {
			      "taskCompletedList": [],
			      "taskList": [
			        {
			          "id": "773c19e8-46b8-4fd5-b998-618e9a259958",
			          "job": "8baa58cb-914c-4c30-b32f-d9c23cf1cf7f",
			          "title": "测试----123321",
			          "startTime": "2019-10-19 15:41:48",
			          "startTimeMonth": "2019-10",
			          "work": "a3e0d9c6-aa73-4346-8ad9-d929903477d4",
			          "application": "a34ea9d9-cceb-45d4-8e55-d81b932ee438",
			          "applicationName": "测试应用",
			          "applicationAlias": "发文管理",
			          "process": "bc4b0018-edee-4225-838e-1b2db5c24f25",
			          "processName": "李义测试",
			          "processAlias": "",
			          "serial": "",
			          "person": "张三@0b31209b-cc14-46c6-afcb-d3823d0abfb7@P",
			          "identity": "张三@9659e75d-b3f3-4eb3-bf26-52812d9228ec@I",
			          "unit": "测试部门@b3a3a25b-6a10-45ed-8dc5-b354d7449c59@U",
			          "activity": "5596e264-7bd7-4d51-ad2d-1a0cf152695f",
			          "activityName": "拟稿",
			          "activityAlias": "",
			          "activityDescription": "",
			          "activityType": "manual",
			          "activityToken": "9d79104c-dfce-4407-8bd1-cb4981787267",
			          "creatorPerson": "张三@0b31209b-cc14-46c6-afcb-d3823d0abfb7@P",
			          "creatorIdentity": "张三@9659e75d-b3f3-4eb3-bf26-52812d9228ec@I",
			          "creatorUnit": "测试部门@b3a3a25b-6a10-45ed-8dc5-b354d7449c59@U",
			          "expired": false,
			          "urged": false,
			          "routeList": [
			            "cadae125-ff16-41e1-89dd-0e04f43295f0"
			          ],
			          "routeNameList": [
			            "送核稿"
			          ],
			          "routeOpinionList": [
			            ""
			          ],
			          "routeDecisionOpinionList": [
			            ""
			          ],
			          "routeName": "",
			          "opinion": "",
			          "modified": false,
			          "viewed": false,
			          "first": true,
			          "createTime": "2019-10-19 15:41:48",
			          "updateTime": "2019-10-19 15:41:48"
			        }
			      ],
			      "currentTaskIndex": 0,
			      "id": "322e82e0-b5d6-45a9-9cb3-e4c93ea71150",
			      "job": "8baa58cb-914c-4c30-b32f-d9c23cf1cf7f",
			      "work": "a3e0d9c6-aa73-4346-8ad9-d929903477d4",
			      "completed": false,
			      "fromActivity": "5596e264-7bd7-4d51-ad2d-1a0cf152695f",
			      "fromActivityType": "manual",
			      "fromActivityName": "拟稿",
			      "fromActivityAlias": "",
			      "fromActivityToken": "9d79104c-dfce-4407-8bd1-cb4981787267",
			      "fromTime": "2019-10-19 15:41:48",
			      "application": "a34ea9d9-cceb-45d4-8e55-d81b932ee438",
			      "applicationName": "测试应用",
			      "process": "bc4b0018-edee-4225-838e-1b2db5c24f25",
			      "processName": "李义测试",
			      "connected": false,
			      "splitting": false,
			      "splitTokenList": [],
			      "createTime": "2019-10-19 15:41:48",
			      "updateTime": "2019-10-19 15:41:48"
			    }
			  ],
			  "message": "",
			  "date": "2019-10-19 15:41:48",
			  "spent": 192,
			  "size": 1,
			  "count": 0,
			  "position": 0
			}
         */
        JSONObject jsonObj = new JSONObject( responseData );              
        JSONArray dataArray = jsonObj.getJSONArray("data");
        List<String> workIds = new ArrayList<>();
        if( dataArray != null && dataArray.length() > 0 ) {
        	for (int i = 0; i < dataArray.length(); i++) {
        	    JSONObject data = (JSONObject) dataArray.get(i);
        	    String workid = data.getString("work");
        	    workIds.add( workid );
                System.out.println("流程启动完成，生成workId=" + workid);
        	}
        }        
        return workIds;
    }
    
    public static String sendPost( String url, String param, Map<String,String> headers ) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            headers.entrySet().forEach( header->{
                conn.setRequestProperty(header.getKey(),header.getValue());
            });

            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println(" POST" + e);
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
    
    public static Map<String, String> getHeader( String xtoken ) {
    	Map<String, String> headMap = new HashMap<String, String>();
    	headMap.put("x-token", xtoken );
        headMap.put("Cookie", "x-token=" + xtoken );
        headMap.put("accept", "*/*");
        headMap.put("connection", "Keep-Alive");
        headMap.put("Content-Type", "application/json; charset=utf-8");
        headMap.put("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        return headMap;
    }
}

```
{% endtab %}
{% endtabs %}

pom.xml

```markup
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>net.o2oa.demos</groupId>
	<artifactId>test_o2oa_java_demo</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>test_start_process_demo</name>
	<url>http://maven.apache.org</url>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	</properties>

	<dependencies>
		<!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient -->
		<dependency>
			<groupId>org.apache.httpcomponents</groupId>
			<artifactId>httpclient</artifactId>
			<version>4.5.10</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpcore-nio -->
		<dependency>
			<groupId>org.apache.httpcomponents</groupId>
			<artifactId>httpcore-nio</artifactId>
			<version>4.4.12</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpcore -->
		<dependency>
			<groupId>org.apache.httpcomponents</groupId>
			<artifactId>httpcore</artifactId>
			<version>4.4.12</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpmime -->
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
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.json/json -->
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

示例代码下载（Eclipse, JDK1.8）:

{% file src="../../../.gitbook/assets/test\_o2oa\_java\_demo.zip" caption="test\_o2oa\_java\_demo.zip" %}

