package mtopsdk.mtop.transform.converter;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/transform/converter/NetworkConverterUtils.class */
public class NetworkConverterUtils {
    public static String a(Map map, String str) {
        if (map != null) {
            String str2 = str;
            if (StringUtils.b(str)) {
                str2 = "utf-8";
            }
            StringBuilder sb = new StringBuilder(64);
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                try {
                    String encode = URLEncoder.encode((String) entry.getKey(), str2);
                    String encode2 = URLEncoder.encode((String) entry.getValue(), str2);
                    sb.append(encode);
                    sb.append("=");
                    sb.append((Object) encode2);
                    if (it.hasNext()) {
                        sb.append("&");
                    }
                } catch (Throwable th) {
                    TBSdkLog.d("mtopsdk.NetworkConverterUtils", "[createParamQueryStr]getQueryStr error ---" + th.toString());
                }
            }
            return sb.toString();
        }
        return null;
    }

    public static URL a(String str, Map map) {
        if (StringUtils.b(str)) {
            TBSdkLog.d("mtopsdk.NetworkConverterUtils", "[initUrl]  baseUrl is blank, initUrl error");
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(str);
            if (map != null) {
                String a2 = a(map, "utf-8");
                if (StringUtils.a(a2) && str.indexOf("?") == -1) {
                    sb.append("?");
                    sb.append(a2);
                }
            }
            return new URL(sb.toString());
        } catch (Exception e) {
            TBSdkLog.b("mtopsdk.NetworkConverterUtils", "[initUrl]initUrl new URL error", e);
            return null;
        }
    }
}
