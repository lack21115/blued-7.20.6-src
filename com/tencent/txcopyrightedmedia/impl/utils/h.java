package com.tencent.txcopyrightedmedia.impl.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.txcopyrightedmedia.impl.utils.u;
import com.tencent.txcopyrightedmedia.impl.utils.v;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/h.class */
public final class h implements v.a {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, byte[]> f26409a = new ConcurrentHashMap();

    @Override // com.tencent.txcopyrightedmedia.impl.utils.v.a
    public final u.n a(String str, String str2, Map<String, String> map) {
        int i;
        byte[] bArr;
        Uri parse = Uri.parse("http://" + v.e + ":" + v.d + str + "?" + str2);
        new StringBuilder("receive request: ").append(parse.toString());
        String queryParameter = (TextUtils.isEmpty(str) || TextUtils.equals("/", str)) ? parse.getQueryParameter("bfid") : null;
        if (queryParameter == null) {
            return u.a(u.n.c.NOT_FOUND, "text/plain", "SOURCE NOT FOUND");
        }
        int i2 = 0;
        int i3 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder("Header: ");
            sb.append(entry.getKey());
            sb.append(" = ");
            sb.append(entry.getValue());
            if ("range".equalsIgnoreCase(entry.getKey())) {
                String[] split = entry.getValue().split("=");
                if (split.length == 2) {
                    String[] split2 = split[1].split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    int i4 = i3;
                    if (split2.length > 0) {
                        i4 = Integer.parseInt(split2[0]);
                    }
                    i3 = i4;
                    if (split2.length > 1) {
                        i2 = Integer.parseInt(split2[1]);
                        i3 = i4;
                    }
                }
            }
        }
        byte[] bArr2 = this.f26409a.get(queryParameter);
        if (bArr2 == null) {
            return u.a(u.n.c.OK, "text/plain", "Buffer " + queryParameter + "not found");
        }
        int length = i2 == 0 ? bArr2.length : i2 + 1;
        if (i3 == 0 && length == bArr2.length) {
            bArr = bArr2;
            i = length;
        } else {
            byte[] bArr3 = new byte[length - i3];
            int min = Math.min(bArr2.length, length);
            int i5 = i3;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                i = min;
                bArr = bArr3;
                if (i5 >= min) {
                    break;
                }
                bArr3[i7] = bArr2[i5];
                i5++;
                i6 = i7 + 1;
            }
        }
        StringBuilder sb2 = new StringBuilder("response bytes: rangeStart: ");
        sb2.append(i3);
        sb2.append(", rangeEnd: ");
        int i8 = i - 1;
        sb2.append(i8);
        sb2.append(", content length: ");
        sb2.append(bArr.length);
        u.n a2 = u.a(u.n.c.OK, com.anythink.expressad.exoplayer.k.o.q, new ByteArrayInputStream(bArr), bArr.length);
        a2.a("Content-Range", "bytes " + i3 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i8 + "/" + bArr2.length);
        return a2;
    }

    public final void a(String str) {
        this.f26409a.remove(str);
    }
}
