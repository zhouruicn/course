package tools;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class HttpClientUtils2 {

   
    public static final int THREAD_POOL_SIZE = 5;

    public interface HttpClientDownLoadProgress {
        public void onProgress(int progress);
    }

    private static HttpClientUtils2 httpClientDownload;

    private ExecutorService downloadExcutorService;

    private HttpClientUtils2() {
        downloadExcutorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }

    public static HttpClientUtils2 getInstance() {
        if (httpClientDownload == null) {
            httpClientDownload = new HttpClientUtils2();
        }
        return httpClientDownload;
    }

    /**
     *
     *
     * @param url
     * @param filePath
     */
    public void download(final String url, final String filePath) {
        downloadExcutorService.execute(new Runnable() {

            @Override
            public void run() {
                httpDownloadFile(url, filePath, null, null);
            }
        });
    }

    /**
     * �
     *
     * @param url
     * @param filePath
     * @param progress
     *          
     */
    public void download(final String url, final String filePath,
                         final HttpClientDownLoadProgress progress) {
        downloadExcutorService.execute(new Runnable() {

            @Override
            public void run() {
                httpDownloadFile(url, filePath, progress, null);
            }
        });
    }

    
    /**
     * 下载文件
     *
     * @param url
     * @param filePath
     */
    public void download(final String url, final String filePath,final HttpClientDownLoadProgress progress,Map<String, String> headMap) {
        downloadExcutorService.execute(new Runnable() {
            @Override
            public void run() {
            	 httpDownloadFile(url, filePath, progress, headMap);
            }
        });
    }
    
    /**
     *
     *
     * @param url
     * @param filePath
     */
    private void httpDownloadFile(String url, String filePath,
                                  HttpClientDownLoadProgress progress, Map<String, String> headMap) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(url);
            setGetHead(httpGet, headMap);
            CloseableHttpResponse response1 = httpclient.execute(httpGet);
            try {
                System.out.println(response1.getStatusLine());
                HttpEntity httpEntity = response1.getEntity();
                long contentLength = httpEntity.getContentLength();
                InputStream is = httpEntity.getContent();
               
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int r = 0;
                long totalRead = 0;
                while ((r = is.read(buffer)) > 0) {
                    output.write(buffer, 0, r);
                    totalRead += r;
                    if (progress != null) {
                        progress.onProgress((int) (totalRead * 100 / contentLength));
                    }
                }
                FileOutputStream fos = new FileOutputStream(filePath);
                output.writeTo(fos);
                output.flush();
                output.close();
                fos.close();
                EntityUtils.consume(httpEntity);
            } finally {
                response1.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 
     *
     * @param url
     * @return
     */
    public String httpGet(String url) {
        return httpGet(url, null);
    }

    /**
     * http get����
     *
     * @param url
     * @return
     */
    public String httpGet(String url, Map<String, String> headMap) {
        String responseContent = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(url);
            setGetHead(httpGet, headMap);
            CloseableHttpResponse response1 = httpclient.execute(httpGet);
          
            try {
                System.out.println(response1.getStatusLine());
                HttpEntity entity = response1.getEntity();
                responseContent = getRespString(entity);
                System.out.println("debug:" + responseContent);
                EntityUtils.consume(entity);
            } finally {
                response1.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }

    public String httpPost(String url, Map<String, String> paramsMap) {
        return httpPost(url, paramsMap, null);
    }

    /**
     * 
     *
     * @param url
     * @param paramsMap
     * @return
     */
    public String httpPost(String url, Map<String, String> paramsMap,
                           Map<String, String> headMap) {
        String responseContent = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost(url);
            setPostHead(httpPost, headMap);
            setPostParams(httpPost, paramsMap);
            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
                System.out.println(response.getStatusLine());
                HttpEntity entity = response.getEntity();
                responseContent = getRespString(entity);
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("responseContent = " + responseContent);
        return responseContent;
    }

    /**
     * 
     *
     * @param httpPost
     * @param paramsMap
     * @throws Exception
     */
    private void setPostParams(HttpPost httpPost, Map<String, String> paramsMap)
            throws Exception {
        if (paramsMap != null && paramsMap.size() > 0) {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            Set<String> keySet = paramsMap.keySet();
            for (String key : keySet) {
                nvps.add(new BasicNameValuePair(key, paramsMap.get(key)));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        }
    }

    /**
     *
     *
     * @param httpPost
     * @param headMap
     */
    private void setPostHead(HttpPost httpPost, Map<String, String> headMap) {
        if (headMap != null && headMap.size() > 0) {
            Set<String> keySet = headMap.keySet();
            for (String key : keySet) {
                httpPost.addHeader(key, headMap.get(key));
            }
        }
    }

    /**
     * 
     *
     * @param httpGet
     * @param headMap
     */
    private void setGetHead(HttpGet httpGet, Map<String, String> headMap) {
        if (headMap != null && headMap.size() > 0) {
            Set<String> keySet = headMap.keySet();
            for (String key : keySet) {
                httpGet.addHeader(key, headMap.get(key));
            }
        }
    }

    /**
     *
     *
     * @param serverUrl
     *  ַ
     * @param localFilePath
     *          
     * @param serverFieldName
     * @param params
     * @return
     * @throws Exception
     */
    public String uploadFileImpl(String serverUrl, String localFilePath,String serverFieldName, Map<String, String> params, Map<String, String> paramshead)
            throws Exception {
        String respStr = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost(serverUrl);
          
          // httppost.setHeader("Cookie", "x-token=Xb9XTOjIQJa-6kyV0T4KAl1QUygkW0UgzZByx9ojDbK5WpQ-5IZ5pw");
          // httppost.setHeader("accept", "*/*");  
          // httppost.setHeader("connection", "Keep-Alive");  
          // httppost.setHeader("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
           
          // httppost.setHeader("Content-Type", "charset=utf-8");
          //conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            
            setPostHead(httppost, paramshead);
            
            FileBody binFileBody = new FileBody(new File(localFilePath));

            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            // add the file params
            
            multipartEntityBuilder.addPart(serverFieldName, binFileBody);
        
            setUploadParams(multipartEntityBuilder, params);

            HttpEntity reqEntity = multipartEntityBuilder.build();
            httppost.setEntity(reqEntity);

            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                System.out.println(response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                respStr = getRespString(resEntity);
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
        System.out.println("resp=" + respStr);
        return respStr;
    }

    /**
     * 
     *
     * @param multipartEntityBuilder
     * @param params
     */
    private void setUploadParams(MultipartEntityBuilder multipartEntityBuilder,
                                 Map<String, String> params) {
        if (params != null && params.size() > 0) {
            Set<String> keys = params.keySet();
            for (String key : keys) {
                multipartEntityBuilder.addPart(key, new StringBody(params.get(key),ContentType.APPLICATION_JSON));
                
            }
        }
    }

    /**
     * String
     *
     * @param entity
     * @return
     * @throws Exception
     */
    private String getRespString(HttpEntity entity) throws Exception {
        if (entity == null) {
            return null;
        }
        InputStream is = entity.getContent();
        StringBuffer strBuf = new StringBuffer();
        byte[] buffer = new byte[4096];
        int r = 0;
        while ((r = is.read(buffer)) > 0) {
            strBuf.append(new String(buffer, 0, r, "UTF-8"));
        }
        return strBuf.toString();
    }
    
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
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
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
            System.out.println(" POST"+e);
            e.printStackTrace();
        }
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        System.out.println(result);
        return result;
    } 
    
    public static void main(String[] args) {
      
        // GET
    	  String token = "";
          //单点登入
          String path = "http://127.0.0.1:20020/x_organization_assemble_authentication/jaxrs/sso";
          long time = new Date().getTime();
          String login_uid = "%E6%88%91";
          String sso_key = "12345678";
          String xtoken = null;
  		try {
  			xtoken = Crypto.encrypt( login_uid + "#" + time, sso_key );
  			System.out.println(xtoken);
  		} catch (Exception e1) {
  			// TODO Auto-generated catch block
  			e1.printStackTrace();
  		}
  		
          String string = "{\"token\": "+xtoken+", \"client\": \"unicom\"}";
          String  str =  HttpClientUtils.getInstance().sendPost(path,string);
      	
          try {
              JSONObject jsonObj = (JSONObject)(new JSONParser().parse(str));
              System.out.println(jsonObj.toJSONString() + "\n" + jsonObj.getClass());
              JSONObject data = (JSONObject) jsonObj.get("data");
              System.out.println(data.get("token"));
              token = (String) data.get("token");
              
          } catch (ParseException e) {
              e.printStackTrace();
          }
 
          System.out.println("单点登入======================================================");
          Map<String, String> headMap = new HashMap<String, String>();
          headMap.put("Cookie", "x-token=" + token);
          headMap.put("accept", "*/*");
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
         
          System.out.println("获取待办数======================================================");
          //获取附件数据  
          System.out.println("获取附件数据");
          url = "http://127.0.0.1:20020/x_processplatform_assemble_surface/jaxrs/attachment/list/workorworkcompleted/3085d704-bc2b-444b-9e00-114b96f7fe4e";
          httpClientUtils = new HttpClientUtils2();
          str =  httpClientUtils.httpGet(url,headMap);
          
          try {
              JSONObject jsonObj = (JSONObject)(new JSONParser().parse(str));
              JSONArray datas = (JSONArray) jsonObj.get("data");
              for(int i =0;i<datas.size();i++) {
            	  JSONObject data=(JSONObject)datas.get(i);
            	  String id = (String) data.get("id");
                  System.out.println("id="+id);
              }
          } catch (ParseException e) {
              e.printStackTrace();
          }

          System.out.println("获取附件数据 ======================================================");
          
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
          
          System.out.println("获取待办列表======================================================");
           
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
          System.out.println("获取表单数据======================================================");  
          
        //获取附件数据  
          System.out.println("获取附件数据");
          url = "http://127.0.0.1:20020/x_processplatform_assemble_surface/jaxrs/attachment/list/workorworkcompleted/3085d704-bc2b-444b-9e00-114b96f7fe4e";
          str =  httpClientUtils.httpGet(url,headMap);
          
          try {
              JSONObject jsonObj = (JSONObject)(new JSONParser().parse(str));
              JSONArray datas = (JSONArray) jsonObj.get("data");
              for(int i =0;i<datas.size();i++) {
            	  JSONObject data=(JSONObject)datas.get(i);
            	  String id = (String) data.get("id");
                  System.out.println("id="+id);
              }
          } catch (ParseException e) {
              e.printStackTrace();
          }
          System.out.println("获取附件数据======================================================");  
       //下载附件
       
          System.out.println("下载附件");
          url = "http://127.0.0.1:20020/x_processplatform_assemble_surface/jaxrs/attachment/download/9e46ea49-ec79-4161-ad6c-23e0ccbc6c59/work/3085d704-bc2b-444b-9e00-114b96f7fe4e";
          //str =  httpClientUtils.httpGet(url,headMap);
          String filePath = "d:\\5831241667.pdf";
          httpClientUtils.download(url, filePath, new HttpClientUtils2.HttpClientDownLoadProgress() {
              @Override
              public void onProgress(int progress) {
                 // System.out.println("download progress = " + progress);
              }}, headMap);
          System.out.println("下载附件======================================================");  
          
       // 流程记录
          System.out.println("流程记录......");
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
          System.out.println("流程记录======================================================");     
          
    }
}
