package com.anythink.china.common.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.anythink.china.common.a.a;
import com.anythink.china.common.a.d;
import com.anythink.china.common.a.e;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/common/service/ApkDownloadService.class */
public class ApkDownloadService extends Service {
    public static final String a = "extra_unique_id";
    private static final String b = ApkDownloadService.class.getSimpleName();
    private Map<String, d> c = new HashMap();

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/china/common/service/ApkDownloadService$a.class */
    public final class a extends Binder implements com.anythink.china.common.service.a {
        public a() {
        }

        @Override // com.anythink.china.common.service.a
        public final void a(String str) {
            ApkDownloadService.this.a(str);
        }

        @Override // com.anythink.china.common.service.a
        public final boolean a() {
            return ApkDownloadService.this.c.size() == 0;
        }

        @Override // com.anythink.china.common.service.a
        public final void b(String str) {
            d dVar = (d) ApkDownloadService.this.c.get(str);
            if (dVar != null) {
                dVar.b();
                ApkDownloadService.this.c.remove(str);
            }
        }

        @Override // com.anythink.china.common.service.a
        public final void c(String str) {
            d dVar = (d) ApkDownloadService.this.c.get(str);
            if (dVar != null) {
                dVar.a();
                ApkDownloadService.this.c.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            e eVar = com.anythink.china.common.a.a(getApplicationContext()).f().get(str);
            if (eVar == null) {
                return;
            }
            d dVar = new d(eVar);
            dVar.a(new a.InterfaceC0048a() { // from class: com.anythink.china.common.service.ApkDownloadService.1
                @Override // com.anythink.china.common.a.a.InterfaceC0048a
                public final void a(e eVar2, long j) {
                    if (ApkDownloadService.this.c != null) {
                        ApkDownloadService.this.c.remove(eVar2.n);
                    }
                    a.InterfaceC0048a c = com.anythink.china.common.a.a(ApkDownloadService.this.getApplicationContext()).c(eVar2.n);
                    if (c != null) {
                        c.a(eVar2, j);
                    }
                }

                @Override // com.anythink.china.common.a.a.InterfaceC0048a
                public final void a(e eVar2, long j, long j2) {
                    a.InterfaceC0048a c = com.anythink.china.common.a.a(ApkDownloadService.this.getApplicationContext()).c(eVar2.n);
                    if (c != null) {
                        c.a(eVar2, j, j2);
                    }
                }

                @Override // com.anythink.china.common.a.a.InterfaceC0048a
                public final void a(e eVar2, long j, long j2, int i) {
                    if (ApkDownloadService.this.c != null) {
                        ApkDownloadService.this.c.remove(eVar2.n);
                    }
                    a.InterfaceC0048a c = com.anythink.china.common.a.a(ApkDownloadService.this.getApplicationContext()).c(eVar2.n);
                    if (c != null) {
                        c.a(eVar2, j, j2, i);
                    }
                }

                @Override // com.anythink.china.common.a.a.InterfaceC0048a
                public final void a(e eVar2, String str2) {
                    if (ApkDownloadService.this.c != null) {
                        ApkDownloadService.this.c.remove(eVar2.n);
                    }
                    a.InterfaceC0048a c = com.anythink.china.common.a.a(ApkDownloadService.this.getApplicationContext()).c(eVar2.n);
                    if (c != null) {
                        c.a(eVar2, str2);
                    }
                }

                @Override // com.anythink.china.common.a.a.InterfaceC0048a
                public final void b(e eVar2, long j, long j2) {
                    a.InterfaceC0048a c = com.anythink.china.common.a.a(ApkDownloadService.this.getApplicationContext()).c(eVar2.n);
                    if (c != null) {
                        c.b(eVar2, j, j2);
                    }
                }
            });
            if (this.c != null) {
                this.c.put(str, dVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent != null) {
            a(intent.getStringExtra(a));
        }
        return new a();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        com.anythink.china.common.b.a.a(getApplicationContext()).a();
        super.onTaskRemoved(intent);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
