package com.tencent.qcloud.core.util;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLHandshakeException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/util/QCloudHttpUtils.class */
public class QCloudHttpUtils {
    public static Map<String, List<String>> getDecodedQueryPair(URL url) {
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (url.getQuery() != null) {
            String[] split = url.getQuery().split(ContainerUtils.FIELD_DELIMITER);
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str2 = split[i2];
                int indexOf = str2.indexOf("=");
                String urlDecodeString = indexOf > 0 ? urlDecodeString(str2.substring(0, indexOf)) : str2;
                if (!linkedHashMap.containsKey(urlDecodeString)) {
                    linkedHashMap.put(urlDecodeString, new LinkedList());
                }
                if (indexOf > 0) {
                    int length2 = str2.length();
                    int i3 = indexOf + 1;
                    if (length2 > i3) {
                        str = urlDecodeString(str2.substring(i3));
                        ((List) linkedHashMap.get(urlDecodeString)).add(str);
                        i = i2 + 1;
                    }
                }
                str = null;
                ((List) linkedHashMap.get(urlDecodeString)).add(str);
                i = i2 + 1;
            }
        }
        return linkedHashMap;
    }

    public static Map<String, List<String>> getQueryPair(URL url) {
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (url.getQuery() != null) {
            String[] split = url.getQuery().split(ContainerUtils.FIELD_DELIMITER);
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str2 = split[i2];
                int indexOf = str2.indexOf("=");
                String substring = indexOf > 0 ? str2.substring(0, indexOf) : str2;
                if (!linkedHashMap.containsKey(substring)) {
                    linkedHashMap.put(substring, new LinkedList());
                }
                if (indexOf > 0) {
                    int length2 = str2.length();
                    int i3 = indexOf + 1;
                    if (length2 > i3) {
                        str = str2.substring(i3);
                        ((List) linkedHashMap.get(substring)).add(str);
                        i = i2 + 1;
                    }
                }
                str = null;
                ((List) linkedHashMap.get(substring)).add(str);
                i = i2 + 1;
            }
        }
        return linkedHashMap;
    }

    public static boolean isNetworkConditionException(Throwable th) {
        if ((th instanceof UnknownHostException) || (th instanceof SocketTimeoutException) || (th instanceof ConnectException) || (th instanceof HttpRetryException) || (th instanceof NoRouteToHostException)) {
            return true;
        }
        return (th instanceof SSLHandshakeException) && !(th.getCause() instanceof CertificateException);
    }

    public static long[] parseContentRange(String str) {
        if (QCloudStringUtils.isEmpty(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(" ");
        int indexOf = str.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        int indexOf2 = str.indexOf("/");
        if (lastIndexOf == -1 || indexOf == -1 || indexOf2 == -1) {
            return null;
        }
        return new long[]{Long.parseLong(str.substring(lastIndexOf + 1, indexOf)), Long.parseLong(str.substring(indexOf + 1, indexOf2)), Long.parseLong(str.substring(indexOf2 + 1))};
    }

    public static String queryParametersString(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!z) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append(entry.getKey() + "=" + entry.getValue());
            z = false;
        }
        return sb.toString();
    }

    public static Map<String, List<String>> transformToMultiMap(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(entry.getValue());
            hashMap.put(entry.getKey(), arrayList);
        }
        return hashMap;
    }

    public static String urlDecodeString(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String urlEncodeString(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            String[] split = str.split(" ", -1);
            int length = split.length;
            for (int i = 0; i < length; i++) {
                if (i == 0 && "".equals(split[i])) {
                    sb.append("%20");
                } else {
                    if (length > 1 && i == length - 1 && "".equals(split[i])) {
                        break;
                    }
                    sb.append(URLEncoder.encode(split[i], "UTF-8"));
                    if (i != length - 1) {
                        sb.append("%20");
                    }
                }
            }
            return sb.toString().replaceAll("\\*", "%2A");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String urlEncodeWithSlash(String str) {
        String str2 = str;
        if (str != null) {
            str2 = str;
            if (str.length() > 0) {
                str2 = str;
                if (!str.equals("/")) {
                    String[] split = str.split("/");
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= split.length) {
                            break;
                        }
                        split[i2] = urlEncodeString(split[i2]);
                        i = i2 + 1;
                    }
                    StringBuilder sb = new StringBuilder();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= split.length) {
                            break;
                        }
                        sb.append(split[i4]);
                        sb.append("/");
                        i3 = i4 + 1;
                    }
                    if (!str.endsWith("/")) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    str2 = sb.toString();
                }
            }
        }
        return str2;
    }
}
