package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.a.a.g;
import java.util.zip.Adler32;

/* loaded from: source-8457232-dex2jar.jar:com/ta/utdid2/device/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static a f34907a;
    static final Object d = new Object();

    static long a(a aVar) {
        if (aVar != null) {
            String format = String.format("%s%s%s%s%s", aVar.f(), aVar.getDeviceId(), Long.valueOf(aVar.a()), aVar.getImsi(), aVar.e());
            if (g.m9885a(format)) {
                return 0L;
            }
            Adler32 adler32 = new Adler32();
            adler32.reset();
            adler32.update(format.getBytes());
            return adler32.getValue();
        }
        return 0L;
    }

    private static a a(Context context) {
        if (context != null) {
            synchronized (d) {
                String value = c.a(context).getValue();
                if (g.m9885a(value)) {
                    return null;
                }
                String str = value;
                if (value.endsWith("\n")) {
                    str = value.substring(0, value.length() - 1);
                }
                a aVar = new a();
                long currentTimeMillis = System.currentTimeMillis();
                String a2 = com.ta.utdid2.a.a.e.a(context);
                String c2 = com.ta.utdid2.a.a.e.c(context);
                aVar.d(a2);
                aVar.b(a2);
                aVar.b(currentTimeMillis);
                aVar.c(c2);
                aVar.e(str);
                aVar.a(a(aVar));
                return aVar;
            }
        }
        return null;
    }

    public static a b(Context context) {
        synchronized (b.class) {
            try {
                if (f34907a != null) {
                    return f34907a;
                } else if (context != null) {
                    a a2 = a(context);
                    f34907a = a2;
                    return a2;
                } else {
                    return null;
                }
            } finally {
            }
        }
    }
}
