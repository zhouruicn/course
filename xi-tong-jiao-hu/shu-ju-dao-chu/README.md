# 数据导出

## 第一步：单点登入

一、创建SSO配置，请参考组织管理里中的SSO管理

二、通过下面代码获取token.

```java
接口:http://127.0.0.1:20020/x_organization_assemble_authentication/jaxrs/sso
```

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

## 第二步：获取待办列表

```java
//获取待办数
http://127.0.0.1:20020/x_processplatform_assemble_surface/jaxrs/work/count/%E6%88%91@9938@P；
%E6%88%91@9938@P 为参数名
//获取待办列表
http://127.0.0.1:20020/x_processplatform_assemble_surface/jaxrs/task/list/(0)/next/"+count
(0) 为开始参数名
count为几条参数名
```

```java
      Map headMap = new HashMap();
      headMap.put("Cookie", "x-token=" + token); headMap.put("accept", "/"); 
      headMap.put("connection", "Keep-Alive"); 
      headMap.put("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
  
      //获取待办数
      String count = "0";
      String url =  "http://127.0.0.1:20020/x_processplatform_assemble_surface/jaxrs/work/count/%E6%88%91@9938@P";
      HttpClientUtils2 httpClientUtils = new HttpClientUtils2();
      str = httpClientUtils.httpGet(url,headMap);
      try {
          JSONObject jsonObj = (JSONObject)(new JSONParser().parse(str));
          JSONObject data = (JSONObject) jsonObj.get("data");
          count = data.get("task").toString();
          System.out.println("count=" + count);
      } catch (ParseException e) {
          e.printStackTrace();
      }


      //获取待办列表
      url = "http://127.0.0.1:20020/x_processplatform_assemble_surface/jaxrs/task/list/(0)/next/"+count;
      str = httpClientUtils.httpGet(url,headMap);

      try {
          JSONObject jsonObj = (JSONObject)(new JSONParser().parse(str));
          JSONArray datas = (JSONArray) jsonObj.get("data");
          for(int i =0;i<datas.size();i++) {
              JSONObject data=(JSONObject)datas.get(i);
              String workid = (String) data.get("work");
              System.out.println(workid);
          }
      } catch (ParseException e) {
          e.printStackTrace();
      }
```



## 第三步：获取表单数据

```java
http://127.0.0.1:20020/x_processplatform_assemble_surface/jaxrs/work/workorworkcompleted/3085d704-bc2b-444b-9e00-114b96f7fe4e";
3085d704-bc2b-444b-9e00-114b96f7fe4e 为work id 参数名
```

```java
 //获取表单数据
  url = "http://127.0.0.1:20020/x_processplatform_assemble_surface/jaxrs/work/workorworkcompleted/3085d704-bc2b-444b-9e00-114b96f7fe4e";
  str =  httpClientUtils.httpGet(url,headMap);
  try {
         JSONObject jsonObj = (JSONObject)(new JSONParser().parse(str));
          JSONObject data = (JSONObject) jsonObj.get("data");
          data = (JSONObject) data.get("data");
          String explain = (String) data.get("explain");
          System.out.println(explain);
          } catch (ParseException e) {
              e.printStackTrace();
          }
```

## 四：下载附件

```java
http://127.0.0.1:20020/x_processplatform_assemble_surface/jaxrs/attachment/download/9e46ea49-ec79-4161-ad6c-23e0ccbc6c59/work/3085d704-bc2b-444b-9e00-114b96f7fe4e
9e46ea49-ec79-4161-ad6c-23e0ccbc6c59 为附件id参数名
3085d704-bc2b-444b-9e00-114b96f7fe4e 为work id 参数名

```

```java
   //下载附件       
  url = "http://127.0.0.1:20020/x_processplatform_assemble_surface/jaxrs/attachment/download/9e46ea49-ec79-4161-ad6c-23e0ccbc6c59/work/3085d704-bc2b-444b-9e00-114b96f7fe4e";
  String filePath = "d:\\5831241667.pdf";
  httpClientUtils.download(url, filePath, new HttpClientUtils2.HttpClientDownLoadProgress() {
              public void onProgress(int progress) {
                  //System.out.println("download progress = " + progress);
 }}, headMap);
```

## 五：获取流程记录

```java
http://127.0.0.1:20020/x_processplatform_assemble_surface/jaxrs/worklog/list/workorworkcompleted/3085d704-bc2b-444b-9e00-114b96f7fe4e;
3085d704-bc2b-444b-9e00-114b96f7fe4e 为work id 参数名
```

```java
 url = "http://127.0.0.1:20020/x_processplatform_assemble_surface/jaxrs/worklog/list/workorworkcompleted/3085d704-bc2b-444b-9e00-114b96f7fe4e";
 str = httpClientUtils.httpGet(url,headMap);
 try {
      JSONObject jsonObj = (JSONObject)(new JSONParser().parse(str));
      JSONArray datas = (JSONArray) jsonObj.get("data");
      for(int i =0;i<datas.size();i++) {
         JSONObject data=(JSONObject)datas.get(i);
         String fromActivityName = (String) data.get("fromActivityName");
         System.out.println("fromActivityName="+fromActivityName);
         }
    } catch (ParseException e) {
         e.printStackTrace();
}
```

