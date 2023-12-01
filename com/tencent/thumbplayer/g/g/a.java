package com.tencent.thumbplayer.g.g;

import android.text.TextUtils;
import com.alipay.sdk.util.i;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/g/a.class */
public class a {
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f39357c;
    private boolean d;
    private boolean e;
    private boolean g;

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Long> f39356a = new HashMap();
    private String f = "";

    public a(boolean z) {
        this.g = z;
    }

    private final void c(boolean z) {
        this.f39357c = z;
        this.e = true;
    }

    private final void d(boolean z) {
        this.d = z;
    }

    public final void a() {
        this.f = "";
        this.f39356a.clear();
        this.b = System.currentTimeMillis();
    }

    public final void a(boolean z) {
        d(z);
        this.b = System.currentTimeMillis();
    }

    public final void b() {
        this.f39356a.put("createCodec", Long.valueOf(System.currentTimeMillis() - this.b));
    }

    public final void b(boolean z) {
        c(z);
        this.f39356a.put("configCodec", Long.valueOf(System.currentTimeMillis() - this.b));
    }

    public final void c() {
        this.b = System.currentTimeMillis();
    }

    public final void d() {
        this.f39356a.put("startCodec", Long.valueOf(System.currentTimeMillis() - this.b));
    }

    public final String e() {
        if (TextUtils.isEmpty(this.f)) {
            StringBuilder sb = new StringBuilder("{");
            sb.append("\"isVideo\":");
            sb.append(this.g + " ,");
            if (this.e) {
                sb.append("\"isReuse\":");
                sb.append(this.f39357c + " ,");
            }
            sb.append("\"reuseEnable\":");
            sb.append(this.d + " ,");
            long j = 0L;
            for (Map.Entry<String, Long> entry : this.f39356a.entrySet()) {
                long j2 = j;
                if (entry != null) {
                    j2 = j + entry.getValue().longValue();
                }
                sb.append("\"" + ((Object) entry.getKey()) + "\":");
                sb.append(entry.getValue().longValue() + " ,");
                j = j2;
            }
            sb.append("\"totalCodec\":");
            sb.append(j);
            sb.append(i.d);
            this.f = sb.toString();
        }
        return this.f;
    }
}
