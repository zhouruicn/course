# 外系统启动流程

## 第一步：单点登入

一、创建SSO配置，请参考组织管理里中的SSO管理

二、通过下面代码获取token.

```java
String token = ""; 
//单点登入
String path = "
http://127.0.0.1:20020/x_organization_assemble_authentication/jaxrs/sso
"; 
long time = new Date().getTime(); 
String login_uid = "test"; 
String sso_key = "12345678"; 
String xtoken = null;
 try { xtoken = Crypto.encrypt( login_uid + "#" + time, sso_key ); 
 System.out.println(xtoken); } 
 catch (Exception e1) { 
  e1.printStackTrace(); 
 }
String string = "{\"token\": "+xtoken+", \"client\": \"unicom\"}";
String  str =  HttpClientUtils.getInstance().sendPost(path,string);
try {
       JSONObject jsonObj = (JSONObject)(new JSONParser().parse(str));
      // System.out.println(jsonObj.toJSONString() + "\n" + jsonObj.getClass());
       JSONObject data = (JSONObject) jsonObj.get("data");
        System.out.println(data.get("token"));
        token = (String) data.get("token");
    } catch (ParseException e) {
        e.printStackTrace();
    }
```

## 第二步：创建流程

一、创建creatework

二、创建流程获取workid

```java
 path = "http://127.0.0.1:20030/x_program_center/jaxrs/invoke/creatework/execute";
 String string1 = "{\"latest\" : false,\"title\" : \"测试20190910\",\"identity\" : \"test@9d10d320-b20c-4dea-8194-9e0a70d2e1c6@I\",\"data\":{\"subject\":\"测试20190910\"}}";
 String strflow =  HttpClientUtils.getInstance().sendPost(path,string1);
 String work = "";
   try {
        JSONObject jsonObj = (JSONObject)(new JSONParser().parse(strflow));
        JSONObject data = (JSONObject) jsonObj.get("data");
        JSONObject value = (JSONObject) data.get("value");
                    data = (JSONObject)value.get("data");
        JSONObject data0 = (JSONObject)data.get("0");
                    work = (String)data0.get("work");
             //System.out.println(work);
         } catch (ParseException e) {
             e.printStackTrace();
         }
```



## 第三步：上传附件

一、设置x-token

二、设置workid

```java
//上传附件
try {
  Map<String,String> uploadParams = new LinkedHashMap<String, String>();
  uploadParams.put("fileName", "云化统一信息平台二期演示视频解说词0515v3.docx");
  uploadParams.put("site", "attachment");
  uploadParams.put("extraParam","");

  Map<String, String> headMap = new HashMap<String, String>();
  headMap.put("Cookie", "x-token=" + token);
  headMap.put("accept", "*/*");
  headMap.put("connection", "Keep-Alive");
  headMap.put("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
  String strurl = "http://127.0.0.1:20020/x_processplatform_assemble_surface/jaxrs/attachment/upload/work/" + work;
  HttpClientUtils.getInstance().uploadFileImpl(
                strurl, "F:\\云化统一信息平台二期演示视频解说词0515v3.docx",
                "file", uploadParams, headMap);
    } catch (Exception e) {
        e.printStackTrace();
    }
```

