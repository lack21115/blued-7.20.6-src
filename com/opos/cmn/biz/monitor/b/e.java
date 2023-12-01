package com.opos.cmn.biz.monitor.b;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.opos.cmn.biz.monitor.b.a;
import com.opos.cmn.biz.monitor.b.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/b/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private Context f24658a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f24659c;
    private int d = 0;
    private com.opos.cmn.biz.monitor.b.a e;
    private a f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/b/e$a.class */
    public interface a {
        void a();

        void a(byte[] bArr);
    }

    public e(Context context, String str, int i, com.opos.cmn.biz.monitor.b.a aVar, a aVar2) {
        this.f24658a = context;
        this.b = str;
        this.f24659c = i;
        this.e = aVar;
        this.f = aVar2;
    }

    public static boolean a(byte[] bArr) {
        String str;
        if (bArr == null || bArr.length <= 0) {
            str = "request success but data empty";
        } else {
            try {
                int i = new JSONObject(new String(bArr)).getInt("code");
                if (i == 0) {
                    return true;
                }
                str = "request success but ret:" + i;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("NetRequestExecutor", "request but parse fail", e);
                return false;
            }
        }
        com.opos.cmn.an.f.a.b("NetRequestExecutor", str);
        return false;
    }

    public void a() {
        com.opos.cmn.an.f.a.b("NetRequestExecutor", "send request:" + this.b);
        a(this.b);
    }

    protected void a(int i, byte[] bArr, Map<String, String> map) {
        a aVar;
        if (200 == i) {
            a aVar2 = this.f;
            if (aVar2 != null) {
                aVar2.a(bArr);
                return;
            }
            return;
        }
        if (302 == i) {
            String str = map.get("location");
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = map.get(HttpHeaders.LOCATION);
            }
            if (this.d < this.f24659c && !TextUtils.isEmpty(str2)) {
                com.opos.cmn.an.f.a.b("NetRequestExecutor", "retry with url:" + str2);
                this.d = this.d + 1;
                a(str2);
                return;
            }
            aVar = this.f;
            if (aVar == null) {
                return;
            }
        } else {
            aVar = this.f;
            if (aVar == null) {
                return;
            }
        }
        aVar.a();
    }

    protected void a(final String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.ACCEPT, "application/json");
        this.e.a(this.f24658a, new b.a(str).a(hashMap).a(), new a.InterfaceC0627a() { // from class: com.opos.cmn.biz.monitor.b.e.1
            @Override // com.opos.cmn.biz.monitor.b.a.InterfaceC0627a
            public void a() {
                com.opos.cmn.an.f.a.b("NetRequestExecutor", "request fail with url:" + str);
                if (e.this.f != null) {
                    e.this.f.a();
                }
            }

            @Override // com.opos.cmn.biz.monitor.b.a.InterfaceC0627a
            public void a(c cVar) {
                com.opos.cmn.an.f.a.b("NetRequestExecutor", "result code:" + cVar.a());
                e.this.a(cVar.a(), cVar.c(), cVar.b());
            }
        });
    }
}
