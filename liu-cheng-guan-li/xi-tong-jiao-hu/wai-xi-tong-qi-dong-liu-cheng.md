# 外系统启动流程

## 第一步：单点登入

一、创建SSO配置，请参考组织管理里中的SSO管理

二、通过下面代码获取token.

```java
String token = ""; //单点登入String path = "http://127.0.0.1:20020/x_organization_assemble_authentication/jaxrs/sso"; long time = new Date().getTime(); String login_uid = "test"; String sso_key = "12345678"; String xtoken = null; try { xtoken = Crypto.encrypt( login_uid + "#" + time, sso_key );  System.out.println(xtoken); }  catch (Exception e1) {   e1.printStackTrace();  }String string = "{\"token\": "+xtoken+", \"client\": \"unicom\"}";String  str =  HttpClientUtils.getInstance().sendPost(path,string);try {       JSONObject jsonObj = (JSONObject)(new JSONParser().parse(str));      // System.out.println(jsonObj.toJSONString() + "\n" + jsonObj.getClass());       JSONObject data = (JSONObject) jsonObj.get("data");        System.out.println(data.get("token"));        token = (String) data.get("token");    } catch (ParseException e) {        e.printStackTrace();    }
```

## 第二步：创建流程

一、设置x-token

```java
  path = "http://127.0.0.1:20020/x_processplatform_assemble_surface/jaxrs/work/process/e51984cb-bce9-42b3-9b6a-20fc1ef31676";  JSONObject result = new JSONObject();    result.put("latest", false);    result.put("title", "演示系统2019-10-19wwww");    result.put("identity", "test@a2b7b360-2685-4989-ae70-77a2f207c6d7@I");           JSONObject department = new JSONObject();  department.put("subject", "测试20191018java启动wwww");  result.put("data", department);    String strflow =  HttpClientUtils.getInstance().sendPost2(path,token,result.toJSONString());    String work = "";		JsonParser parser = new JsonParser(); 	JsonObject object = null; 	object =(JsonObject) parser.parse(strflow);	JsonArray value =object.getAsJsonArray("data");	object = value.get(0).getAsJsonObject(); 	work= object.get("work").getAsString();
```



## 第三步：上传附件

一、设置x-token

二、设置workid

```java
//上传附件try {  Map<String,String> uploadParams = new LinkedHashMap<String, String>();  uploadParams.put("fileName", "云化统一信息平台二期演示视频解说词0515v3.docx");  uploadParams.put("site", "attachment");  uploadParams.put("extraParam","");  Map<String, String> headMap = new HashMap<String, String>();  headMap.put("Cookie", "x-token=" + token);  headMap.put("accept", "*/*");  headMap.put("connection", "Keep-Alive");  headMap.put("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");  String strurl = "http://127.0.0.1:20020/x_processplatform_assemble_surface/jaxrs/attachment/upload/work/" + work;  HttpClientUtils.getInstance().uploadFileImpl(                strurl, "F:\\云化统一信息平台二期演示视频解说词0515v3.docx",                "file", uploadParams, headMap);    } catch (Exception e) {        e.printStackTrace();    }
```

{% file src="../../.gitbook/assets/httpclientutils.java" %}

