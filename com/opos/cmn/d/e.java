package com.opos.cmn.d;

import android.content.Context;
import android.net.wifi.WifiEnterpriseConfig;
import android.text.TextUtils;
import com.opos.videocache.c;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/d/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f11057a = new byte[0];
    private static volatile com.opos.videocache.c b;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/d/e$a.class */
    public interface a {
        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/d/e$b.class */
    public static final class b implements com.opos.videocache.b.b {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, String> f11061a;

        public b() {
            HashMap hashMap = new HashMap(1);
            this.f11061a = hashMap;
            hashMap.put("Accept-Encoding", WifiEnterpriseConfig.IDENTITY_KEY);
        }

        @Override // com.opos.videocache.b.b
        public Map<String, String> a(String str) {
            return this.f11061a;
        }
    }

    public static com.opos.videocache.c a(final Context context) {
        com.opos.videocache.c cVar;
        com.opos.videocache.c cVar2 = b;
        if (cVar2 == null) {
            synchronized (f11057a) {
                com.opos.videocache.c cVar3 = b;
                cVar = cVar3;
                if (cVar3 == null) {
                    cVar = new c.a(context.getApplicationContext()).a(new com.opos.videocache.a.c() { // from class: com.opos.cmn.d.e.1
                        @Override // com.opos.videocache.a.c
                        public String a(String str) {
                            return e.c(Context.this, str);
                        }
                    }).a(1073741824L).a(50).a(new b()).a();
                    b = cVar;
                }
            }
            return cVar;
        }
        return cVar2;
    }

    public static String a(Context context, String str) {
        String a2 = (context == null || com.opos.cmn.an.c.a.a(str)) ? "" : a(context).a(str);
        com.opos.cmn.an.f.a.b("VideoProxyUtils", "getProxyUrl=" + a2);
        return a2;
    }

    public static void a(final Context context, final String str, final a aVar) {
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.cmn.d.e.2
            @Override // java.lang.Runnable
            public void run() {
                String a2 = e.a(Context.this, str);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(a2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(Context context, String str) {
        String a2 = d.a(context.getApplicationContext(), str);
        String str2 = a2;
        if (TextUtils.isEmpty(a2)) {
            str2 = d.b(context.getApplicationContext(), str);
        }
        return str2;
    }
}
