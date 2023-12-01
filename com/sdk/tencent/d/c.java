package com.sdk.tencent.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.sdk.tencent.a.c;
import java.net.HttpURLConnection;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/d/c.class */
public abstract class c<Params, Progress, Result> {
    public static final d g = new d();
    public static final Executor h = new com.sdk.tencent.d.d(5);

    /* renamed from: a  reason: collision with root package name */
    public final e<Params, Result> f28031a;
    public final FutureTask<Result> b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f28032c = new AtomicBoolean();
    public final AtomicBoolean d = new AtomicBoolean();
    public volatile boolean e = false;
    public Boolean f = Boolean.valueOf(com.sdk.tencent.f.c.f28050c);

    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/d/c$a.class */
    public class a extends e<Params, Result> {
        public a() {
            super(null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0110 -> B:26:0x015d). Please submit an issue!!! */
        @Override // java.util.concurrent.Callable
        public Result call() {
            c.this.d.set(true);
            Process.setThreadPriority(10);
            c cVar = c.this;
            Params[] paramsArr = this.f28035a;
            com.sdk.tencent.a.c cVar2 = (com.sdk.tencent.a.c) cVar;
            if (cVar2.m != c.a.CANCELLED && paramsArr != null && paramsArr.length != 0) {
                if (paramsArr.length == 4) {
                    cVar2.q = String.valueOf(paramsArr[1]);
                    cVar2.r = true;
                    cVar2.s = (Boolean) paramsArr[2];
                    cVar2.t = (Boolean) paramsArr[3];
                }
                if (paramsArr.length == 2) {
                    cVar2.u = (Boolean) paramsArr[1];
                }
                try {
                    cVar2.p = SystemClock.uptimeMillis();
                    cVar2.a(1);
                    com.sdk.tencent.a.d dVar = (com.sdk.tencent.a.d) paramsArr[0];
                    String b = dVar.b();
                    cVar2.l = b;
                    HttpURLConnection a2 = dVar.a(b, false);
                    if (a2 == null) {
                        cVar2.a(4, new com.sdk.tencent.a.f(0, cVar2.b(), false));
                    } else {
                        com.sdk.tencent.a.f b2 = cVar2.b(dVar, a2);
                        if (b2.f28014a == 0) {
                            cVar2.a(4, b2);
                        } else {
                            cVar2.a(3, Integer.valueOf(b2.f28014a), b2.b);
                        }
                    }
                } catch (Exception e) {
                    com.sdk.tencent.n.c.b(e.toString());
                    com.sdk.tencent.n.b.a("PriorityAsyncTask", "网络访问异常：\n" + e.toString(), cVar2.f);
                    cVar2.a(3, 302002, "网络访问异常");
                }
            }
            return (Result) cVar.a((c) null);
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/d/c$b.class */
    public class b extends FutureTask<Result> {
        public b(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                c cVar = c.this;
                Result result = get();
                if (cVar.d.get()) {
                    return;
                }
                cVar.a((c) result);
            } catch (Exception e) {
                c cVar2 = c.this;
                if (!cVar2.d.get()) {
                    cVar2.a((c) null);
                }
                com.sdk.tencent.n.b.a("PriorityAsyncTask", e.getMessage(), c.this.f);
            }
        }
    }

    /* renamed from: com.sdk.tencent.d.c$c  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/d/c$c.class */
    public static class C0757c<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final c f28034a;
        public final Data[] b;

        public C0757c(c cVar, Data... dataArr) {
            this.f28034a = cVar;
            this.b = dataArr;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/d/c$d.class */
    public static class d extends Handler {
        public d() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            int i;
            C0757c c0757c = (C0757c) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                c cVar = c0757c.f28034a;
                Object obj2 = c0757c.b[0];
                cVar.f28032c.get();
            } else if (i2 != 2) {
            } else {
                c cVar2 = c0757c.f28034a;
                Object[] objArr = c0757c.b;
                com.sdk.tencent.a.c cVar3 = (com.sdk.tencent.a.c) cVar2;
                if (cVar3.m == c.a.CANCELLED || objArr == null || objArr.length == 0 || cVar3.j == null) {
                    return;
                }
                int intValue = ((Integer) objArr[0]).intValue();
                if (intValue == 1) {
                    cVar3.m = c.a.STARTED;
                    obj = cVar3.j;
                } else if (intValue != 2) {
                    if (intValue == 3) {
                        if (objArr.length != 3) {
                            return;
                        }
                        cVar3.m = c.a.FAILURE;
                        Object obj3 = cVar3.j;
                        int intValue2 = ((Integer) objArr[1]).intValue();
                        String str = (String) objArr[2];
                        com.sdk.tencent.g.b bVar = ((com.sdk.tencent.g.a) obj3).f28053a;
                        String str2 = ((Object) str) + "";
                        com.sdk.tencent.e.a<T> aVar = bVar.e;
                        if (aVar != 0) {
                            aVar.a(intValue2, 302002, str2);
                            bVar.e = null;
                            return;
                        }
                        return;
                    } else if (intValue != 4 || objArr.length != 2) {
                        return;
                    } else {
                        cVar3.m = c.a.SUCCESS;
                        Object obj4 = cVar3.j;
                        com.sdk.tencent.a.f fVar = (com.sdk.tencent.a.f) objArr[1];
                        String str3 = cVar3.v.b;
                        com.sdk.tencent.g.a aVar2 = (com.sdk.tencent.g.a) obj4;
                        aVar2.getClass();
                        try {
                            JSONObject jSONObject = new JSONObject(fVar != null ? (String) fVar.b : "");
                            i = jSONObject.optInt("code");
                            try {
                                String optString = jSONObject.optString("msg");
                                int optInt = jSONObject.optInt("status");
                                String optString2 = jSONObject.optString("obj");
                                String optString3 = jSONObject.optString("seq");
                                if (!com.sdk.tencent.n.b.a(optString).booleanValue() || !com.sdk.tencent.n.b.a(optString3).booleanValue() || !com.sdk.tencent.n.b.a(optString2).booleanValue()) {
                                    aVar2.f28053a.a(i, optString, optInt, optString2, optString3);
                                    return;
                                }
                                aVar2.f28053a.a(1, "服务端数据格式出错", 302003, null, com.sdk.tencent.n.c.a().f28045c);
                                com.sdk.tencent.n.b.a(com.sdk.tencent.g.b.i, "返回数据为空", Boolean.valueOf(com.sdk.tencent.g.b.j));
                                return;
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    com.sdk.tencent.n.c.f28064a.b.d = th.toString();
                                } catch (Throwable th2) {
                                }
                                aVar2.f28053a.a(i, "服务端数据格式出错", 302003, null, com.sdk.tencent.n.c.a().f28045c);
                                com.sdk.tencent.n.b.a(com.sdk.tencent.g.b.i, "返回数据解析异常：" + th.toString(), Boolean.valueOf(com.sdk.tencent.g.b.j));
                                return;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            i = 1;
                        }
                    }
                } else if (objArr.length != 3) {
                    return;
                } else {
                    cVar3.m = c.a.LOADING;
                    obj = cVar3.j;
                    Long.parseLong(String.valueOf(objArr[1]));
                    Long.parseLong(String.valueOf(objArr[2]));
                }
                obj.getClass();
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/d/c$e.class */
    public static abstract class e<Params, Result> implements Callable<Result> {

        /* renamed from: a  reason: collision with root package name */
        public Params[] f28035a;

        public e() {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public c() {
        a aVar = new a();
        this.f28031a = aVar;
        this.b = new b(aVar);
    }

    public final Result a(Result result) {
        g.obtainMessage(1, new C0757c(this, result)).sendToTarget();
        return result;
    }

    public final void a(Progress... progressArr) {
        if (this.f28032c.get()) {
            return;
        }
        g.obtainMessage(2, new C0757c(this, progressArr)).sendToTarget();
    }
}
