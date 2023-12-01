package com.amap.api.col.p0003sl;

import com.alipay.sdk.sys.a;
import com.anythink.core.common.c.d;
import com.efs.sdk.base.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.de  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/de.class */
public abstract class de extends da {
    public de() {
        setProxy(hz.a(aa.a));
        setConnectionTimeout(5000);
        setSoTimeout(50000);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(String str) {
        String b = b(str);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        String a = hr.a();
        stringBuffer.append("&ts=".concat(String.valueOf(a)));
        stringBuffer.append("&scode=" + hr.a(aa.a, a, b));
        return stringBuffer.toString();
    }

    private static String b(String str) {
        String[] split = str.split(a.b);
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            stringBuffer.append(c(split[i2]));
            stringBuffer.append(a.b);
            i = i2 + 1;
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2.length() > 1) {
            str = (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
        }
        return str;
    }

    private static String c(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            iw.c(e, "AbstractProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e2) {
            iw.c(e2, "AbstractProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    @Override // com.amap.api.col.p0003sl.kb
    public String getIPV6URL() {
        String url = getURL();
        String str = url;
        if (url != null) {
            str = url;
            if (url.contains("http://restsdk.amap.com/v4/gridmap?")) {
                str = dw.a(url);
            }
        }
        return str;
    }

    @Override // com.amap.api.col.p0003sl.da, com.amap.api.col.p0003sl.kb
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public Map<String, String> getRequestHead() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", w.c);
        hashtable.put("Accept-Encoding", Constants.CP_GZIP);
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "9.3.1", "3dmap"));
        hashtable.put("x-INFO", hr.a(aa.a));
        hashtable.put(d.a.b, ho.f(aa.a));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public boolean isSupportIPV6() {
        String url = getURL();
        return url != null && url.contains("http://restsdk.amap.com/v4/gridmap?");
    }
}
