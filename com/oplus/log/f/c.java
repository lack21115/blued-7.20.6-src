package com.oplus.log.f;

import android.text.TextUtils;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/f/c.class */
public final class c implements d {

    /* renamed from: a  reason: collision with root package name */
    private final com.oplus.log.a.a f10682a;

    public c(com.oplus.log.a.a aVar) {
        this.f10682a = aVar;
    }

    private static String a(String str) {
        long j;
        try {
            j = Long.parseLong(str);
        } catch (Throwable th) {
            j = 0;
        }
        return new DecimalFormat("##.##").format(((float) j) / 1048576.0f);
    }

    private static String c(com.oplus.log.b.b bVar) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(bVar.f10637c)) {
            sb.append(bVar.f10637c);
            sb.append("|");
        }
        sb.append(d(bVar));
        sb.append(bVar.b);
        return sb.toString();
    }

    private static String d(com.oplus.log.b.b bVar) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (bVar.f != null) {
            Iterator<Map.Entry<String, String>> it = bVar.f.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                String str2 = null;
                try {
                    str = next.getKey();
                    try {
                        str2 = next.getValue();
                    } catch (Throwable th) {
                    }
                } catch (Throwable th2) {
                    str = null;
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    String str3 = str2;
                    if ("RAMSize".equals(str)) {
                        str3 = a(str2) + "GB";
                    }
                    String str4 = str3;
                    if ("InternalFreeSpace".equals(str)) {
                        str4 = a(str3) + "GB";
                    }
                    sb.append(str);
                    sb.append(":");
                    sb.append(str4);
                    if (it.hasNext()) {
                        sb.append(", ");
                    }
                }
            }
            sb.append("|");
        }
        return sb.toString();
    }

    public final int a() {
        return 104;
    }

    @Override // com.oplus.log.f.d
    public final void a(com.oplus.log.b.b bVar) {
        if (this.f10682a == null || !(bVar.b instanceof String)) {
            return;
        }
        this.f10682a.a(bVar.e, c(bVar), bVar.d, a());
    }

    @Override // com.oplus.log.f.d
    public final void b(com.oplus.log.b.b bVar) {
        if (this.f10682a == null || !(bVar.b instanceof String)) {
            return;
        }
        this.f10682a.a(bVar.e, c(bVar), bVar.d, a());
    }
}
