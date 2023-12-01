package com.sdk.tencent.r;

import android.content.ContentResolver;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.igexin.push.core.b;
import com.sdk.tencent.f.c;
import com.sdk.tencent.q.e;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/r/a.class */
public class a extends com.sdk.tencent.i.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f28076a = "com.sdk.tencent.r.a";
    public static boolean b = c.b;

    public static String a(String str, String str2, TreeMap<String, Object> treeMap) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(str2);
            stringBuffer.append('?');
            for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
                String key = entry.getKey();
                String str3 = entry.getValue() + "";
                if (entry.getValue() != null && str3.length() > 0 && !b.l.equals(str3) && !"sign".equals(key) && !key.startsWith(BridgeUtil.UNDERLINE_STR) && !ContentResolver.SCHEME_FILE.equals(key)) {
                    stringBuffer.append(key);
                    stringBuffer.append('=');
                    stringBuffer.append(entry.getValue());
                    stringBuffer.append('&');
                }
            }
            if (stringBuffer.charAt(stringBuffer.length() - 1) == '&') {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            return e.a(stringBuffer.toString());
        } catch (Exception e) {
            com.sdk.tencent.n.b.a(f28076a, e.getMessage(), Boolean.valueOf(b));
            return null;
        }
    }
}
