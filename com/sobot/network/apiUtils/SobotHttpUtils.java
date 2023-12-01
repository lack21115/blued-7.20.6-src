package com.sobot.network.apiUtils;

import android.content.Context;
import android.text.TextUtils;
import com.sobot.network.http.HttpBaseUtils;
import com.sobot.network.http.SobotOkHttpUtils;
import com.sobot.network.http.log.SobotNetLogUtils;
import java.io.IOException;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import okhttp3.MediaType;
import okhttp3.Response;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/apiUtils/SobotHttpUtils.class */
public class SobotHttpUtils {

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/network/apiUtils/SobotHttpUtils$SobotRequestCallBack.class */
    public interface SobotRequestCallBack {
        void onFailure(String str);

        void onSuccess(String str);
    }

    public static void doGet(Object obj, String str, Map<String, String> map, HttpBaseUtils.StringCallBack stringCallBack) {
        HttpBaseUtils.getInstance().doGet(obj, str, map, null, stringCallBack);
    }

    public static void doGet(Object obj, String str, Map<String, String> map, Map<String, String> map2, HttpBaseUtils.StringCallBack stringCallBack) {
        HttpBaseUtils.getInstance().doGet(obj, str, map, map2, stringCallBack);
    }

    public static void doPost(Object obj, String str, Map<String, String> map, HttpBaseUtils.StringCallBack stringCallBack) {
        HttpBaseUtils.getInstance().doPost(obj, str, map, null, stringCallBack);
    }

    public static void doPost(Object obj, String str, Map<String, String> map, Map<String, String> map2, HttpBaseUtils.StringCallBack stringCallBack) {
        HttpBaseUtils.getInstance().doPost(obj, str, map, map2, stringCallBack);
    }

    public static void doPostByJsonString(Object obj, String str, Map<String, String> map, Map<String, String> map2, HttpBaseUtils.StringCallBack stringCallBack) {
        HttpBaseUtils.getInstance().doPostByJsonString(obj, str, map, map2, stringCallBack);
    }

    public static void doPostByString(Object obj, String str, Map<String, String> map, Map<String, String> map2, MediaType mediaType, HttpBaseUtils.StringCallBack stringCallBack) {
        HttpBaseUtils.getInstance().doPostByString(obj, str, map, map2, mediaType, stringCallBack);
    }

    public static Response doPostSync(Object obj, String str, Map<String, String> map, Map<String, String> map2) throws IOException {
        return HttpBaseUtils.getInstance().doPostSync(obj, str, map, map2);
    }

    public static void init(Context context, final String str) {
        if (context == null) {
            SobotNetLogUtils.e("SobotHttpUtils init: context is null, please check!");
        } else {
            SobotHttpGlobalContext.getInstance(context.getApplicationContext());
        }
        SobotOkHttpUtils.getInstance().setHostNameVerifier(new HostnameVerifier() { // from class: com.sobot.network.apiUtils.SobotHttpUtils.1
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str2, SSLSession sSLSession) {
                if (TextUtils.isEmpty(str) || !str.contains(str2)) {
                    return HttpsURLConnection.getDefaultHostnameVerifier().verify(str2, sSLSession);
                }
                return true;
            }
        });
    }

    public static void uploadFile(Object obj, String str, Map<String, String> map, Map<String, String> map2, String str2, HttpBaseUtils.StringCallBack stringCallBack) {
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("sobot---请求参数： url = " + str + ", filePath=" + str2 + "  ");
            for (String str3 : map.keySet()) {
                sb.append(str3 + "=" + map.get(str3) + ", ");
            }
            SobotNetLogUtils.i(sb.toString().substring(0, sb.toString().length() - 2));
        }
        HttpBaseUtils.getInstance().uploadFile(obj, str, map, map2, str2, stringCallBack);
    }
}
