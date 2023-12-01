package com.sdk.tencent.v;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.sdk.tencent.a.d;
import com.sdk.tencent.base.api.CallBack;
import com.sdk.tencent.base.framework.bean.DataInfo;
import com.sdk.tencent.base.framework.utils.app.AppUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/v/a.class */
public class a<T> {
    public static final String f = "com.sdk.tencent.v.a";
    public static Boolean g = Boolean.valueOf(com.sdk.tencent.f.c.b);

    /* renamed from: a  reason: collision with root package name */
    public CallBack<T> f14392a;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public a<T>.b f14393c;
    public com.sdk.tencent.a.c d;
    public int e;

    /* renamed from: com.sdk.tencent.v.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/v/a$a.class */
    public class C0593a implements com.sdk.tencent.e.a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f14394a;

        public C0593a(int i) {
            this.f14394a = i;
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
                Context context = a.this.b;
                int i3 = this.f14394a;
                String str4 = com.sdk.tencent.b.a.f14328a;
                com.sdk.tencent.b.a.a(context, i3, t + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2, com.tencent.tendinsv.b.g);
                try {
                    Context context2 = a.this.b;
                    String a2 = com.sdk.tencent.s.a.a(String.valueOf(t));
                    if (a2 == 0) {
                        a.this.a(1, "SDK解密异常", 302001, a2, str2);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(a2);
                    str3 = a2;
                    if (this.f14394a == 1) {
                        jSONObject.remove("fakeMobile");
                        str3 = jSONObject.toString();
                    }
                } catch (Exception e) {
                    str3 = t;
                }
            }
            a.this.a(i, str, i2, str3, str2);
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/v/a$b.class */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public Handler f14395a = new Handler(Looper.getMainLooper());
        public long b;

        public b(long j) {
            this.b = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.d != null) {
                com.sdk.tencent.n.b.c(a.f, "超时，已取消请求", a.g);
                a.this.d.a();
            }
            a.this.a(1, "超时", 101005, null, com.sdk.tencent.n.c.a().f14357c);
        }
    }

    public a(Context context, int i, CallBack<T> callBack) {
        a(context, i, callBack);
    }

    public void a(int i) {
        String a2 = com.sdk.tencent.b.a.a(this.b, i, com.tencent.tendinsv.b.g);
        if (com.sdk.tencent.n.b.b(a2).booleanValue()) {
            a(0, "成功", 100, com.sdk.tencent.b.a.a(a2), com.sdk.tencent.b.a.b(a2));
        } else if (!com.sdk.tencent.q.b.a(this.b)) {
            a(1, 201001, "操作频繁请,稍后再试");
        } else {
            com.sdk.tencent.x.a aVar = new com.sdk.tencent.x.a(this.b, new C0593a(i));
            DataInfo dataInfo = new DataInfo();
            dataInfo.putData("serviceType", Integer.valueOf(i));
            dataInfo.putData("privateIp", AppUtils.getLocalIPAddress());
            dataInfo.putData("newVersion", "10");
            this.d = aVar.a(aVar.g, "/dro/netm/v1.0/qc", dataInfo, new com.sdk.tencent.g.a(aVar), 0, d.b.POST);
        }
    }

    public final void a(int i, int i2, String str) {
        String str2 = com.sdk.tencent.n.c.a().f14357c;
        String str3 = str2;
        if (com.sdk.tencent.n.b.a(str2).booleanValue()) {
            str3 = com.sdk.tencent.q.a.a(20);
        }
        a<T>.b bVar = this.f14393c;
        if (bVar != null) {
            bVar.f14395a.removeCallbacks(bVar);
        }
        CallBack<T> callBack = this.f14392a;
        if (callBack != null) {
            callBack.onFailed(i, i2, str, str3);
            this.f14392a = null;
        }
        String str4 = com.sdk.tencent.s.a.f14389a;
    }

    public final void a(int i, String str, int i2, T t, String str2) {
        String str3 = str2;
        if (com.sdk.tencent.n.b.a(str2).booleanValue()) {
            str3 = com.sdk.tencent.q.a.a(20);
        }
        a<T>.b bVar = this.f14393c;
        if (bVar != null) {
            bVar.f14395a.removeCallbacks(bVar);
        }
        CallBack<T> callBack = this.f14392a;
        if (callBack != null) {
            callBack.onSuccess(i, str, i2, t, str3);
            this.f14392a = null;
        }
        String str4 = com.sdk.tencent.s.a.f14389a;
    }

    public final void a(Context context, int i, CallBack<T> callBack) {
        this.f14392a = callBack;
        this.b = context;
        int i2 = i;
        if (i <= 0) {
            i2 = 30;
        }
        this.e = i2;
        a<T>.b bVar = new b(i2 * 1000);
        this.f14393c = bVar;
        bVar.f14395a.postDelayed(bVar, bVar.b);
        com.sdk.tencent.n.c.b();
    }
}
