package com.huawei.hms.framework.network.grs.g;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.network.grs.h.d;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/g/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f22709a = ExecutorsUtils.newCachedThreadPool("GRS_RequestController-Task");
    private final Map<String, com.huawei.hms.framework.network.grs.g.k.b> b = new ConcurrentHashMap(16);

    /* renamed from: c  reason: collision with root package name */
    private final Object f22710c = new Object();
    private com.huawei.hms.framework.network.grs.e.a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/g/h$a.class */
    public class a implements Callable<d> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.g.k.c f22711a;
        final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c f22712c;

        a(com.huawei.hms.framework.network.grs.g.k.c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2) {
            this.f22711a = cVar;
            this.b = str;
            this.f22712c = cVar2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public d call() {
            return new c(this.f22711a, h.this.d).a(h.this.f22709a, this.b, this.f22712c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/g/h$b.class */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.g.k.c f22713a;
        final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c f22714c;
        final /* synthetic */ com.huawei.hms.framework.network.grs.b d;

        b(com.huawei.hms.framework.network.grs.g.k.c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2, com.huawei.hms.framework.network.grs.b bVar) {
            this.f22713a = cVar;
            this.b = str;
            this.f22714c = cVar2;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.a(hVar.a(this.f22713a, this.b, this.f22714c), this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, com.huawei.hms.framework.network.grs.b bVar) {
        if (bVar != null) {
            if (dVar == null) {
                Logger.v("RequestController", "GrsResponse is null");
                bVar.a();
                return;
            }
            Logger.v("RequestController", "GrsResponse is not null");
            bVar.a(dVar);
        }
    }

    public d a(com.huawei.hms.framework.network.grs.g.k.c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2) {
        Future<d> submit;
        String str2;
        Logger.d("RequestController", "request to server with service name is: " + str);
        String grsParasKey = cVar.b().getGrsParasKey(true, true, cVar.a());
        Logger.v("RequestController", "request spUrlKey: " + grsParasKey);
        synchronized (this.f22710c) {
            if (!NetworkUtil.isNetworkAvailable(cVar.a())) {
                return null;
            }
            d.a a2 = com.huawei.hms.framework.network.grs.h.d.a(grsParasKey);
            com.huawei.hms.framework.network.grs.g.k.b bVar = this.b.get(grsParasKey);
            try {
                if (bVar != null && bVar.b()) {
                    submit = bVar.a();
                    return submit.get();
                }
                return submit.get();
            } catch (InterruptedException e) {
                e = e;
                str2 = "when check result, find InterruptedException, check others";
                Logger.w("RequestController", str2, e);
                return null;
            } catch (CancellationException e2) {
                e = e2;
                str2 = "when check result, find CancellationException, check others";
                Logger.w("RequestController", str2, e);
                return null;
            } catch (ExecutionException e3) {
                e = e3;
                str2 = "when check result, find ExecutionException, check others";
                Logger.w("RequestController", str2, e);
                return null;
            }
            if (a2 != null && a2.a()) {
                return null;
            }
            Logger.d("RequestController", "hitGrsRequestBean == null or request block is released.");
            submit = this.f22709a.submit(new a(cVar, str, cVar2));
            this.b.put(grsParasKey, new com.huawei.hms.framework.network.grs.g.k.b(submit));
        }
    }

    public void a(com.huawei.hms.framework.network.grs.e.a aVar) {
        this.d = aVar;
    }

    public void a(com.huawei.hms.framework.network.grs.g.k.c cVar, com.huawei.hms.framework.network.grs.b bVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2) {
        this.f22709a.execute(new b(cVar, str, cVar2, bVar));
    }

    public void a(String str) {
        synchronized (this.f22710c) {
            this.b.remove(str);
        }
    }
}
