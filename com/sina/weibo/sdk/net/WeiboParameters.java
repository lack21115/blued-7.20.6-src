package com.sina.weibo.sdk.net;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Set;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/net/WeiboParameters.class */
public class WeiboParameters {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private String mAppKey;
    private LinkedHashMap<String, Object> mParams = new LinkedHashMap<>();

    public WeiboParameters(String str) {
        this.mAppKey = str;
    }

    @Deprecated
    public void add(String str, int i) {
        this.mParams.put(str, String.valueOf(i));
    }

    @Deprecated
    public void add(String str, long j) {
        this.mParams.put(str, String.valueOf(j));
    }

    @Deprecated
    public void add(String str, Object obj) {
        this.mParams.put(str, obj.toString());
    }

    @Deprecated
    public void add(String str, String str2) {
        this.mParams.put(str, str2);
    }

    public boolean containsKey(String str) {
        return this.mParams.containsKey(str);
    }

    public boolean containsValue(String str) {
        return this.mParams.containsValue(str);
    }

    public String encodeUrl() {
        boolean z;
        String str;
        StringBuilder sb = new StringBuilder();
        boolean z2 = true;
        for (String str2 : this.mParams.keySet()) {
            if (z2) {
                z = false;
            } else {
                sb.append(ContainerUtils.FIELD_DELIMITER);
                z = z2;
            }
            Object obj = this.mParams.get(str2);
            z2 = z;
            if (obj instanceof String) {
                if (!TextUtils.isEmpty((String) obj)) {
                    try {
                        sb.append(String.valueOf(URLEncoder.encode(str2, "UTF-8")) + "=" + URLEncoder.encode(str, "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                LogUtil.i("encodeUrl", sb.toString());
                z2 = z;
            }
        }
        return sb.toString();
    }

    public Object get(String str) {
        return this.mParams.get(str);
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public LinkedHashMap<String, Object> getParams() {
        return this.mParams;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean hasBinaryData() {
        /*
            r3 = this;
            r0 = r3
            java.util.LinkedHashMap<java.lang.String, java.lang.Object> r0 = r0.mParams
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
            r4 = r0
        Ld:
            r0 = r4
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L18
            r0 = 0
            return r0
        L18:
            r0 = r4
            java.lang.Object r0 = r0.next()
            java.lang.String r0 = (java.lang.String) r0
            r5 = r0
            r0 = r3
            java.util.LinkedHashMap<java.lang.String, java.lang.Object> r0 = r0.mParams
            r1 = r5
            java.lang.Object r0 = r0.get(r1)
            r5 = r0
            r0 = r5
            boolean r0 = r0 instanceof java.io.ByteArrayOutputStream
            if (r0 != 0) goto L39
            r0 = r5
            boolean r0 = r0 instanceof android.graphics.Bitmap
            if (r0 == 0) goto Ld
        L39:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.net.WeiboParameters.hasBinaryData():boolean");
    }

    public Set<String> keySet() {
        return this.mParams.keySet();
    }

    public void put(String str, int i) {
        this.mParams.put(str, String.valueOf(i));
    }

    public void put(String str, long j) {
        this.mParams.put(str, String.valueOf(j));
    }

    public void put(String str, Bitmap bitmap) {
        this.mParams.put(str, bitmap);
    }

    public void put(String str, Object obj) {
        this.mParams.put(str, obj.toString());
    }

    public void put(String str, String str2) {
        this.mParams.put(str, str2);
    }

    public void remove(String str) {
        if (this.mParams.containsKey(str)) {
            this.mParams.remove(str);
            LinkedHashMap<String, Object> linkedHashMap = this.mParams;
            linkedHashMap.remove(linkedHashMap.get(str));
        }
    }

    public void setParams(LinkedHashMap<String, Object> linkedHashMap) {
        this.mParams = linkedHashMap;
    }

    public int size() {
        return this.mParams.size();
    }
}
