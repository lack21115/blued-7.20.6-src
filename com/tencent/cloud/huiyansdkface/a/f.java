package com.tencent.cloud.huiyansdkface.a;

import android.os.Handler;
import android.os.Looper;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.a.a f21790a;
    private c b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f21791c = new Handler(Looper.getMainLooper());

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/f$a.class */
    public interface a {
        void a();
    }

    public f(com.tencent.cloud.huiyansdkface.a.a.a.a aVar, c cVar) {
        this.f21790a = aVar;
        this.b = cVar;
    }

    public com.tencent.cloud.huiyansdkface.a.a.a.a a() {
        com.tencent.cloud.huiyansdkface.a.a.a.a aVar = this.f21790a.b() ? com.tencent.cloud.huiyansdkface.a.a.a.a.BACK : com.tencent.cloud.huiyansdkface.a.a.a.a.FRONT;
        this.f21790a = aVar;
        return aVar;
    }

    public void a(final c cVar, final a aVar) {
        if (cVar != null) {
            c cVar2 = this.b;
            cVar.a((b) new e() { // from class: com.tencent.cloud.huiyansdkface.a.f.1
                @Override // com.tencent.cloud.huiyansdkface.a.e, com.tencent.cloud.huiyansdkface.a.b
                public void a(com.tencent.cloud.huiyansdkface.a.c.a aVar2) {
                    super.a(aVar2);
                    cVar.b(this);
                    f.this.f21791c.post(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.a.f.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a();
                        }
                    });
                }
            });
            if (cVar2 != null) {
                cVar2.a((b) new com.tencent.cloud.huiyansdkface.a.a() { // from class: com.tencent.cloud.huiyansdkface.a.f.2
                    @Override // com.tencent.cloud.huiyansdkface.a.a, com.tencent.cloud.huiyansdkface.a.b
                    public void a() {
                        f.this.b = cVar;
                        f.this.b.b(this);
                        cVar.b();
                    }
                });
                cVar2.d();
            }
        }
    }
}
