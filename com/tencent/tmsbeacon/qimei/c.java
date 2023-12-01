package com.tencent.tmsbeacon.qimei;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tmsbeacon.a.a.b;
import com.tencent.tmsbeacon.a.c.f;
import com.tencent.tmsbeacon.base.net.RequestType;
import com.tencent.tmsbeacon.base.net.b.e;
import com.tencent.tmsbeacon.base.net.call.Callback;
import com.tencent.tmsbeacon.base.net.call.JceRequestEntity;
import com.tencent.tmsbeacon.base.net.d;
import com.tencent.tmsbeacon.pack.QimeiPackage;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/qimei/c.class */
public final class c implements e.a, Callback<byte[]>, Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Context f39612a;
    private AtomicInteger b = new AtomicInteger();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/qimei/c$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.d();
            String a2 = e.a(c.this.f39612a);
            com.tencent.tmsbeacon.base.util.c.a(QimeiSDK.TAG, "non-main process check local qimei: " + a2, new Object[0]);
            if (TextUtils.isEmpty(a2)) {
                if (c.this.b.getAndIncrement() > 30) {
                    return;
                }
                c.this.c();
                return;
            }
            c.this.a(a2);
            e.a(System.currentTimeMillis());
            c.this.d();
        }
    }

    public c(Context context) {
        this.f39612a = context;
    }

    private void a(HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("q_m", hashMap);
        b.a().a(new com.tencent.tmsbeacon.a.a.c(1, hashMap2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.tencent.tmsbeacon.base.util.c.a(QimeiSDK.TAG, 4, "stop netListen.", new Object[0]);
        com.tencent.tmsbeacon.base.net.b.e.a(this);
    }

    @Override // com.tencent.tmsbeacon.base.net.b.e.a
    public void a() {
        this.b.set(0);
        com.tencent.tmsbeacon.a.b.a.a().a(this);
    }

    public void a(String str) {
        Qimei b = com.tencent.tmsbeacon.qimei.a.a().b();
        HashMap<String, String> a2 = e.a(str);
        Qimei qimei = b;
        if (a2 != null) {
            qimei = new Qimei(a2.get("A3"), a2.get("A153"), a2);
            com.tencent.tmsbeacon.base.util.c.a("[qimei] showQimei: " + qimei.toString(), new Object[0]);
        }
        com.tencent.tmsbeacon.qimei.a.a().a(qimei);
        a(a2);
    }

    @Override // com.tencent.tmsbeacon.base.net.call.Callback
    /* renamed from: a */
    public void onResponse(byte[] bArr) {
        com.tencent.tmsbeacon.base.util.c.a(QimeiSDK.TAG, 1, "onResponse length: %d. ", Integer.valueOf(bArr.length));
        com.tencent.tmsbeacon.pack.a aVar = new com.tencent.tmsbeacon.pack.a(bArr);
        QimeiPackage qimeiPackage = new QimeiPackage();
        qimeiPackage.readFrom(aVar);
        String str = qimeiPackage.qimei;
        com.tencent.tmsbeacon.base.util.c.a(QimeiSDK.TAG, 2, "get new qimei: %s", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.tmsbeacon.base.util.c.a(QimeiSDK.TAG, 3, "dispatch qimei to listener and save qimei!", new Object[0]);
        a(str);
        e.a(this.f39612a, str);
        e.a(System.currentTimeMillis());
        d();
    }

    @Override // com.tencent.tmsbeacon.base.net.b.e.a
    public void b() {
    }

    public void c() {
        com.tencent.tmsbeacon.a.b.a.a().a(300L, new a());
    }

    @Override // com.tencent.tmsbeacon.base.net.call.Callback
    public void onFailure(d dVar) {
        com.tencent.tmsbeacon.base.util.c.a(QimeiSDK.TAG, 1, "onFailure msg: %s. Waiting next query.", dVar.toString());
        com.tencent.tmsbeacon.a.b.d.b().a("498", dVar.toString());
        if (com.tencent.tmsbeacon.qimei.a.a().b().isEmpty()) {
            com.tencent.tmsbeacon.a.b.a.a().a(10000L, this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.tmsbeacon.base.net.b.e.a(this.f39612a, this);
        if (com.tencent.tmsbeacon.base.net.b.d.d()) {
            if (!com.tencent.tmsbeacon.a.c.b.f(this.f39612a)) {
                c();
                return;
            }
            QimeiSDK qimeiSDK = QimeiSDK.getInstance();
            JceRequestEntity a2 = JceRequestEntity.builder().a(RequestType.QIMEI).a(com.tencent.tmsbeacon.base.net.b.b.b(true), 8081).b(com.tencent.tmsbeacon.base.net.b.b.b(false)).a(qimeiSDK.getAppKey()).a(102).b(103).a(com.tencent.tmsbeacon.qimei.a.a().c()).b("A141", qimeiSDK.getBeaconIdInfo()).b("A142", String.valueOf(qimeiSDK.getContext().getApplicationInfo().targetSdkVersion)).b("A143", qimeiSDK.getOmgID()).b("A144", f.e().i()).b("A23", com.tencent.tmsbeacon.a.c.c.d().a()).a();
            com.tencent.tmsbeacon.base.net.c.c().b(a2).a(this);
            com.tencent.tmsbeacon.base.util.c.a(QimeiSDK.TAG, 0, "QimeiQueryTask start. RequestEntity: %s", a2.toString());
        }
    }
}
