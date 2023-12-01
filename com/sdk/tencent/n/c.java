package com.sdk.tencent.n;

import android.net.Uri;
import com.sdk.tencent.q.d;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/n/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static com.sdk.tencent.f.a f28064a;

    public static com.sdk.tencent.f.a a() {
        if (f28064a == null) {
            b();
        }
        return f28064a;
    }

    public static void a(String str) {
        if (b.b(str).booleanValue() && b.a(f28064a.f28045c).booleanValue()) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("sequenceNumber");
            String queryParameter2 = parse.getQueryParameter("ret_url");
            if (b.b(queryParameter2).booleanValue()) {
                queryParameter = Uri.parse(d.a(queryParameter2)).getQueryParameter("seq");
            }
            f28064a.f28045c = queryParameter;
        }
    }

    public static void b() {
        f28064a = new com.sdk.tencent.f.a();
    }

    public static void b(String str) {
        try {
            List<String> list = f28064a.b.f28047c;
            list.add(str);
            f28064a.b.f28047c = list;
        } catch (Throwable th) {
        }
    }
}
