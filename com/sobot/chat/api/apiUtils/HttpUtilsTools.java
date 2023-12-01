package com.sobot.chat.api.apiUtils;

import com.sobot.chat.core.HttpUtils;
import com.sobot.chat.utils.LogUtils;
import java.io.IOException;
import java.util.Map;
import okhttp3.Response;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/apiUtils/HttpUtilsTools.class */
public class HttpUtilsTools {

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/apiUtils/HttpUtilsTools$SobotRequestCallBack.class */
    public interface SobotRequestCallBack {
        void onFailure(String str);

        void onSuccess(String str);
    }

    public static void doPost(Object obj, String str, Map<String, String> map, HttpUtils.a aVar) {
        HttpUtils.getInstance().doPost(obj, str, map, aVar);
    }

    public static void doPost(String str, Map<String, String> map, HttpUtils.a aVar) {
        HttpUtils.getInstance().doPost(null, str, map, aVar);
    }

    public static Response doPostSync(Object obj, String str, Map<String, String> map) throws IOException {
        return HttpUtils.getInstance().doPostSync(obj, str, map);
    }

    public static void uploadFile(Object obj, String str, Map<String, String> map, String str2, HttpUtils.a aVar) {
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("sobot---请求参数： url = " + str + ", filePath=" + str2 + "  ");
            for (String str3 : map.keySet()) {
                sb.append(str3 + "=" + map.get(str3) + ", ");
            }
            LogUtils.i(sb.toString().substring(0, sb.toString().length() - 2));
        }
        HttpUtils.getInstance().uploadFile(obj, str, map, str2, aVar);
    }
}
