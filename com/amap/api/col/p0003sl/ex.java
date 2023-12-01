package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.ex  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ex.class */
public abstract class ex<T, V> extends ew<T, V> {
    public ex(Context context, T t) {
        super(context, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String b(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            fe.a(e, "ProtocalHandler", "strEncoderUnsupportedEncodingException");
            return "";
        } catch (Exception e2) {
            fe.a(e2, "ProtocalHandler", "strEncoderException");
            return "";
        }
    }

    private static String c(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            stringBuffer.append(d(split[i2]));
            stringBuffer.append("&");
            i = i2 + 1;
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2.length() > 1) {
            str = (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
        }
        return str;
    }

    private static String d(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            fe.a(e, "ProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e2) {
            fe.a(e2, "ProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.ew
    public abstract V a(String str) throws AMapException;

    @Override // com.amap.api.col.p0003sl.ew
    protected abstract String c();

    @Override // com.amap.api.col.p0003sl.kb
    public byte[] getEntityBytes() {
        try {
            String c2 = c();
            StringBuffer stringBuffer = new StringBuffer();
            if (c2 != null) {
                stringBuffer.append(c2);
                stringBuffer.append("&");
            }
            stringBuffer.append("language=");
            stringBuffer.append(ServiceSettings.getInstance().getLanguage());
            String stringBuffer2 = stringBuffer.toString();
            String c3 = c(stringBuffer2);
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(stringBuffer2);
            String a2 = hr.a();
            stringBuffer3.append("&ts=".concat(String.valueOf(a2)));
            stringBuffer3.append("&scode=" + hr.a(this.i, a2, c3));
            return stringBuffer3.toString().getBytes("utf-8");
        } catch (Throwable th) {
            fe.a(th, "ProtocalHandler", "getEntity");
            return null;
        }
    }

    @Override // com.amap.api.col.p0003sl.ew, com.amap.api.col.p0003sl.kb
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.ew, com.amap.api.col.p0003sl.kb
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Search 9.3.1");
        hashMap.put("X-INFO", hr.b(this.i));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "9.3.1", "sea"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }
}
