package com.sdk.tencent.w;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.sdk.tencent.a.d;
import com.sdk.tencent.base.api.CallBack;
import com.sdk.tencent.base.framework.bean.DataInfo;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/w/a.class */
public class a<T> {
    public static final String f = "com.sdk.tencent.w.a";
    public static Boolean g = Boolean.valueOf(com.sdk.tencent.f.c.b);

    /* renamed from: a  reason: collision with root package name */
    public a<T>.c f14399a;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public com.sdk.tencent.a.c f14400c;
    public int d;
    public CallBack<T> e;

    /* renamed from: com.sdk.tencent.w.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/w/a$a.class */
    public class C0594a implements com.sdk.tencent.e.a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f14401a;

        public C0594a(int i) {
            this.f14401a = i;
        }

        @Override // com.sdk.tencent.e.a
        public void a(int i, int i2, String str) {
            a.this.a(i, i2, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.sdk.tencent.e.a
        public void onSuccess(int i, String str, int i2, T t, String str2) {
            com.sdk.tencent.q.b.b(a.this.b);
            String str3 = t;
            if (i == 0) {
                try {
                    Context context = a.this.b;
                    int i3 = this.f14401a;
                    String str4 = com.sdk.tencent.b.a.f14328a;
                    StringBuilder sb = new StringBuilder();
                    sb.append(t);
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb.append(str2);
                    com.sdk.tencent.b.a.a(context, i3, sb.toString(), "CTC");
                    Context context2 = a.this.b;
                    String a2 = com.sdk.tencent.s.a.a(String.valueOf(t));
                    if (a2 == 0) {
                        a.this.a(1, "SDK解密异常", 302001, a2, str2);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(a2);
                    str3 = a2;
                    if (this.f14401a == 1) {
                        jSONObject.remove("fakeMobile");
                        str3 = jSONObject.toString();
                    }
                } catch (Exception e) {
                    com.sdk.tencent.n.b.a(a.f, e.toString(), a.g);
                    str3 = t;
                }
            }
            a.this.a(i, str, i2, str3, str2);
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/w/a$b.class */
    public class b implements com.sdk.tencent.e.a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f14402a;

        public b(String str) {
            this.f14402a = str;
        }

        @Override // com.sdk.tencent.e.a
        public void a(int i, int i2, String str) {
            a.this.a(i, i2, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.String] */
        @Override // com.sdk.tencent.e.a
        public void onSuccess(int i, String str, int i2, T t, String str2) {
            if (i == 0 && com.sdk.tencent.n.b.a(this.f14402a).booleanValue()) {
                Context context = a.this.b;
                t = com.sdk.tencent.s.a.a(String.valueOf(t));
                if (t == null) {
                    a.this.a(1, "SDK解密异常", 302001, t, str2);
                    return;
                }
            }
            a.this.a(i, str, i2, t, str2);
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/w/a$c.class */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public Handler f14403a = new Handler(Looper.getMainLooper());
        public long b;

        public c(long j) {
            this.b = j;
        }

        public void a() {
            this.f14403a.postDelayed(this, this.b);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f14400c != null) {
                com.sdk.tencent.n.b.c(a.f, "超时，已取消请求", a.g);
                a.this.f14400c.a();
            }
            a.this.a(1, "超时", 101005, null, com.sdk.tencent.n.c.a().f14357c);
        }
    }

    public a(Context context, int i, CallBack<T> callBack) {
        this.b = context;
        this.e = callBack;
        int i2 = i <= 0 ? 30 : i;
        this.d = i2;
        a<T>.c cVar = new c(i2 * 1000);
        this.f14399a = cVar;
        cVar.a();
        com.sdk.tencent.n.c.b();
    }

    public void a(int i) {
        String a2 = com.sdk.tencent.b.a.a(this.b, i, "CTC");
        if (com.sdk.tencent.n.b.b(a2).booleanValue()) {
            a(0, "成功", 100, com.sdk.tencent.b.a.a(a2), com.sdk.tencent.b.a.b(a2));
        } else if (!com.sdk.tencent.q.b.a(this.b)) {
            a(1, 201001, "操作频繁请,稍后再试");
        } else {
            com.sdk.tencent.x.a aVar = new com.sdk.tencent.x.a(this.b, new C0594a(i));
            DataInfo dataInfo = new DataInfo();
            dataInfo.putData("serviceType", Integer.valueOf(i));
            this.f14400c = aVar.a(aVar.g, "/dro/ctc/v1.0/gctcbs", dataInfo, new com.sdk.tencent.g.a(aVar), 0, d.b.POST);
        }
    }

    public final void a(int i, int i2, String str) {
        String str2 = com.sdk.tencent.n.c.a().f14357c;
        String str3 = str2;
        if (com.sdk.tencent.n.b.a(str2).booleanValue()) {
            str3 = com.sdk.tencent.q.a.a(20);
        }
        a<T>.c cVar = this.f14399a;
        if (cVar != null) {
            cVar.f14403a.removeCallbacks(cVar);
        }
        CallBack<T> callBack = this.e;
        if (callBack != null) {
            callBack.onFailed(i, i2, str, str3);
            this.e = null;
        }
        String str4 = com.sdk.tencent.s.a.f14389a;
    }

    public final void a(int i, String str, int i2, T t, String str2) {
        String str3 = str2;
        if (com.sdk.tencent.n.b.a(str2).booleanValue()) {
            str3 = com.sdk.tencent.q.a.a(20);
        }
        a<T>.c cVar = this.f14399a;
        if (cVar != null) {
            cVar.f14403a.removeCallbacks(cVar);
        }
        CallBack<T> callBack = this.e;
        if (callBack != null) {
            callBack.onSuccess(i, str, i2, t, str3);
            this.e = null;
        }
        String str4 = com.sdk.tencent.s.a.f14389a;
    }

    public void a(String str, String str2) {
        DataInfo dataInfo;
        String str3;
        com.sdk.tencent.g.a aVar;
        d.b bVar;
        String str4;
        Context context = this.b;
        com.sdk.tencent.n.b.b(com.sdk.tencent.b.a.f14328a, "oauth cache clear", com.sdk.tencent.b.a.b);
        com.sdk.tencent.j.a.a(context, "accessCode1");
        com.sdk.tencent.x.a aVar2 = new com.sdk.tencent.x.a(this.b, new b(str2));
        if (com.sdk.tencent.n.b.a(str2).booleanValue()) {
            dataInfo = new DataInfo();
            dataInfo.putData("accessCode", str);
            str3 = aVar2.g;
            aVar = new com.sdk.tencent.g.a(aVar2);
            bVar = d.b.POST;
            str4 = "/api/ctc/v1.0/gmctc";
        } else {
            dataInfo = new DataInfo();
            dataInfo.putData("accessCode", str);
            dataInfo.putData("mobile", str2);
            str3 = aVar2.g;
            aVar = new com.sdk.tencent.g.a(aVar2);
            bVar = d.b.POST;
            str4 = "/api/ctc/v1.0/gvctc";
        }
        this.f14400c = aVar2.a(str3, str4, dataInfo, aVar, 0, bVar);
    }
}
