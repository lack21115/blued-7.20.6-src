package com.sobot.network.http;

import android.content.ContentResolver;
import android.text.TextUtils;
import com.sobot.network.http.builder.PostFormBuilder;
import com.sobot.network.http.callback.StringCallback;
import com.sobot.network.http.download.SobotDownload;
import com.sobot.network.http.download.SobotDownloadTask;
import com.sobot.network.http.log.SobotNetLogUtils;
import com.sobot.network.http.request.RequestCall;
import com.sobot.network.http.upload.SobotUpload;
import com.sobot.network.http.upload.SobotUploadTask;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Response;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/HttpBaseUtils.class */
public class HttpBaseUtils {
    private static HttpBaseUtils client;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/HttpBaseUtils$FileCallBack.class */
    public interface FileCallBack {
        void inProgress(int i);

        void onError(Exception exc, String str, int i);

        void onResponse(File file);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/HttpBaseUtils$StringCallBack.class */
    public interface StringCallBack {
        void inProgress(int i);

        void onError(Exception exc, String str, int i);

        void onResponse(String str);
    }

    private HttpBaseUtils() {
    }

    public static HttpBaseUtils getInstance() {
        if (client == null) {
            client = new HttpBaseUtils();
        }
        return client;
    }

    public static String map2Json(Map<String, String> map) {
        return (map == null || map.size() <= 0) ? "" : new JSONObject(map).toString();
    }

    private void printLog(String str, Map<String, String> map) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("sobot---请求参数： url = " + str + "  ");
            for (String str2 : map.keySet()) {
                sb.append(str2 + "=" + map.get(str2) + ", ");
            }
            SobotNetLogUtils.i(sb.toString().substring(0, sb.toString().length() - 2));
        } catch (Exception e) {
        }
    }

    public SobotDownloadTask addDownloadFileTask(String str, String str2, String str3, Map<String, String> map, Map<String, String> map2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return SobotDownload.request(str, obtainGetRequest(str2, map, map2)).priority(new Random().nextInt(100)).fileName(str3).save();
    }

    public SobotUploadTask addUploadFileTask(String str, String str2, Map<String, String> map, Map<String, String> map2, String str3, String str4) {
        SobotNetLogUtils.i("上传文件 请求URL: --> " + str2);
        SobotNetLogUtils.i("上传文件 请求参数: --> " + map);
        HashMap hashMap = map2;
        if (map2 == null) {
            hashMap = new HashMap();
        }
        PostFormBuilder post = SobotOkHttpUtils.post();
        if (!TextUtils.isEmpty(str3)) {
            File file = new File(str3);
            post.addFile(ContentResolver.SCHEME_FILE, file.getName(), file);
        }
        if (!TextUtils.isEmpty(str4)) {
            File file2 = new File(str4);
            post.addFile("imageFile", file2.getName(), file2);
        }
        HashMap hashMap2 = hashMap;
        if (hashMap == null) {
            hashMap2 = new HashMap();
        }
        return SobotUpload.request(str, post.url(str2).params(map).headers(hashMap2).build().connTimeOut(30000L).readTimeOut(30000L).writeTimeOut(30000L)).priority(new Random().nextInt(100)).tmpTag(str).filePath(str3).start();
    }

    public void doGet(Object obj, final String str, Map<String, String> map, Map<String, String> map2, final StringCallBack stringCallBack) {
        SobotNetLogUtils.i("请求URL: --> " + str);
        SobotNetLogUtils.i("请求参数: --> " + map);
        HashMap hashMap = map2;
        if (map2 == null) {
            hashMap = new HashMap();
        }
        SobotOkHttpUtils.get().tag(obj).url(str).params(map).headers(hashMap).build().readTimeOut(8000L).writeTimeOut(8000L).connTimeOut(8000L).execute(new StringCallback() { // from class: com.sobot.network.http.HttpBaseUtils.3
            @Override // com.sobot.network.http.callback.Callback
            public void onError(Call call, Exception exc) {
                SobotNetLogUtils.i(call.toString());
                exc.printStackTrace();
                stringCallBack.onError(exc, call.toString(), -1);
            }

            @Override // com.sobot.network.http.callback.Callback
            public void onResponse(String str2) {
                SobotNetLogUtils.i(str + "----请求返回结果: --> " + str2);
                stringCallBack.onResponse(str2);
            }
        });
    }

    public void doPost(Object obj, final String str, Map<String, String> map, Map<String, String> map2, final StringCallBack stringCallBack) {
        SobotNetLogUtils.i("请求URL: --> " + str);
        SobotNetLogUtils.i("请求参数: --> " + map);
        HashMap hashMap = map2;
        if (map2 == null) {
            hashMap = new HashMap();
        }
        SobotOkHttpUtils.post().tag(obj).url(str).headers(hashMap).params(map).build().readTimeOut(8000L).writeTimeOut(8000L).connTimeOut(8000L).execute(new StringCallback() { // from class: com.sobot.network.http.HttpBaseUtils.1
            @Override // com.sobot.network.http.callback.Callback
            public void onError(Call call, Exception exc) {
                SobotNetLogUtils.i(call.toString());
                exc.printStackTrace();
                stringCallBack.onError(exc, call.toString(), -1);
            }

            @Override // com.sobot.network.http.callback.Callback
            public void onResponse(String str2) {
                SobotNetLogUtils.i(str + "----请求返回结果: --> " + str2);
                stringCallBack.onResponse(str2);
            }
        });
    }

    public void doPostByJsonString(Object obj, String str, Map<String, String> map, Map<String, String> map2, StringCallBack stringCallBack) {
        doPostByString(obj, str, map, map2, MediaType.get("application/json"), stringCallBack);
    }

    public void doPostByString(Object obj, final String str, Map<String, String> map, Map<String, String> map2, MediaType mediaType, final StringCallBack stringCallBack) {
        SobotNetLogUtils.i("请求URL: --> " + str);
        SobotNetLogUtils.i("请求参数: --> " + map);
        HashMap hashMap = map2;
        if (map2 == null) {
            hashMap = new HashMap();
        }
        SobotOkHttpUtils.postString().tag(obj).url(str).headers(hashMap).mediaType(mediaType).content(map2Json(map)).build().readTimeOut(8000L).writeTimeOut(8000L).connTimeOut(8000L).execute(new StringCallback() { // from class: com.sobot.network.http.HttpBaseUtils.2
            @Override // com.sobot.network.http.callback.Callback
            public void onError(Call call, Exception exc) {
                SobotNetLogUtils.i(call.toString());
                exc.printStackTrace();
                stringCallBack.onError(exc, call.toString(), -1);
            }

            @Override // com.sobot.network.http.callback.Callback
            public void onResponse(String str2) {
                SobotNetLogUtils.i(str + "----请求返回结果: --> " + str2);
                stringCallBack.onResponse(str2);
            }
        });
    }

    public Response doPostSync(Object obj, String str, Map<String, String> map, Map<String, String> map2) throws IOException {
        SobotNetLogUtils.i("请求URL: --> " + str);
        SobotNetLogUtils.i("请求参数: --> " + map);
        HashMap hashMap = map2;
        if (map2 == null) {
            hashMap = new HashMap();
        }
        return SobotOkHttpUtils.post().tag(obj).url(str).headers(hashMap).params(map).build().readTimeOut(8000L).writeTimeOut(8000L).connTimeOut(8000L).execute();
    }

    public void download(String str, File file, final FileCallBack fileCallBack) {
        SobotNetLogUtils.i("下载地址：" + str);
        SobotOkHttpUtils.get().url(str).build().connTimeOut(30000L).readTimeOut(30000L).writeTimeOut(30000L).execute(new com.sobot.network.http.callback.FileCallBack(file.getAbsolutePath()) { // from class: com.sobot.network.http.HttpBaseUtils.4
            @Override // com.sobot.network.http.callback.FileCallBack
            public void inProgress(float f, long j) {
                fileCallBack.inProgress((int) (f * 100.0f));
            }

            @Override // com.sobot.network.http.callback.Callback
            public void onError(Call call, Exception exc) {
                fileCallBack.onError(exc, call.toString(), -1);
            }

            @Override // com.sobot.network.http.callback.Callback
            public void onResponse(File file2) {
                fileCallBack.onResponse(file2);
            }
        });
    }

    public RequestCall obtainGetRequest(String str, Map<String, String> map, Map<String, String> map2) {
        SobotNetLogUtils.i("请求URL: --> " + str);
        SobotNetLogUtils.i("请求参数: --> " + map);
        HashMap hashMap = map2;
        if (map2 == null) {
            hashMap = new HashMap();
        }
        return SobotOkHttpUtils.get().url(str).headers(hashMap).params(map).build().connTimeOut(30000L).readTimeOut(30000L).writeTimeOut(30000L);
    }

    public void uploadFile(Object obj, String str, Map<String, String> map, Map<String, String> map2, String str2, final StringCallBack stringCallBack) {
        SobotNetLogUtils.i("请求URL: --> " + str);
        SobotNetLogUtils.i("请求参数: --> " + map);
        HashMap hashMap = map2;
        if (map2 == null) {
            hashMap = new HashMap();
        }
        PostFormBuilder post = SobotOkHttpUtils.post();
        if (!TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            if (file.exists() && file.isFile()) {
                post.addFile(ContentResolver.SCHEME_FILE, file.getName(), file);
            }
        }
        post.url(str).params(map).headers(hashMap).tag(obj).build().connTimeOut(30000L).readTimeOut(30000L).writeTimeOut(30000L).execute(new StringCallback() { // from class: com.sobot.network.http.HttpBaseUtils.5
            @Override // com.sobot.network.http.callback.Callback
            public void inProgress(float f) {
                super.inProgress(f);
                stringCallBack.inProgress((int) (f * 100.0f));
            }

            @Override // com.sobot.network.http.callback.Callback
            public void onError(Call call, Exception exc) {
                stringCallBack.onError(exc, call.toString(), -1);
            }

            @Override // com.sobot.network.http.callback.Callback
            public void onResponse(String str3) {
                stringCallBack.onResponse(str3);
            }
        });
    }
}
