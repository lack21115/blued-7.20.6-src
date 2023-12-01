package com.tencent.cloud.huiyansdkface.a.c.a;

import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/c/a/k.class */
public class k implements com.tencent.cloud.huiyansdkface.a.e.c {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f21773a = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.tencent.cloud.huiyansdkface.a.c.a.k.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("WeCamera-PreviewProcessorThread");
            return thread;
        }
    });
    private Camera b;

    /* renamed from: c  reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.c.a f21774c;
    private List<com.tencent.cloud.huiyansdkface.a.e.d> d;
    private com.tencent.cloud.huiyansdkface.a.a.a.d e;
    private int f;
    private com.tencent.cloud.huiyansdkface.a.e.b g;
    private a h = new a();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/c/a/k$a.class */
    class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f21778a = false;
        public boolean b = false;

        a() {
        }
    }

    public k(com.tencent.cloud.huiyansdkface.a.c.a aVar, Camera camera) {
        this.b = camera;
        this.f21774c = aVar;
        com.tencent.cloud.huiyansdkface.a.e.b d = aVar.d();
        this.g = d;
        this.e = d.b();
        this.f = this.g.f();
        this.d = new ArrayList();
    }

    private void a(com.tencent.cloud.huiyansdkface.a.e.a aVar, byte[] bArr) {
        synchronized (this.d) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.d.size()) {
                    this.d.get(i2).a(aVar);
                    i = i2 + 1;
                }
            }
        }
        try {
            this.b.addCallbackBuffer(bArr);
        } catch (Exception e) {
            com.tencent.cloud.huiyansdkface.a.d.a.d("V1PreviewProcessor", e, "addCallbackBuffer err:" + Log.getStackTraceString(e), new Object[0]);
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, byte[] bArr2) {
        a(new com.tencent.cloud.huiyansdkface.a.e.a(this.e, bArr, this.g.c(), this.f, this.g.a()), bArr2);
    }

    private byte[] a(com.tencent.cloud.huiyansdkface.a.a.a.d dVar) {
        int i = this.f;
        int a2 = i == 842094169 ? a(dVar.f21740a, dVar.b) : ((dVar.f21740a * dVar.b) * ImageFormat.getBitsPerPixel(i)) / 8;
        com.tencent.cloud.huiyansdkface.a.d.a.a("V1PreviewProcessor", "camera preview format:" + i + ",calc buffer size:" + a2, new Object[0]);
        return new byte[a2];
    }

    public int a(int i, int i2) {
        int ceil = ((int) Math.ceil(i / 16.0d)) * 16;
        return (ceil * i2) + ((((((int) Math.ceil((ceil / 2) / 16.0d)) * 16) * i2) / 2) * 2);
    }

    public void a() {
        com.tencent.cloud.huiyansdkface.a.d.a.b("V1PreviewProcessor", "add callback buffer", new Object[0]);
        try {
            this.b.addCallbackBuffer(a(this.e));
        } catch (Exception e) {
            com.tencent.cloud.huiyansdkface.a.d.a.d("V1PreviewProcessor", e, "addCallbackBuffer err:" + Log.getStackTraceString(e), new Object[0]);
            e.printStackTrace();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.e.c
    public void a(com.tencent.cloud.huiyansdkface.a.e.d dVar) {
        synchronized (this.d) {
            com.tencent.cloud.huiyansdkface.a.d.a.a("V1PreviewProcessor", "register preview callback:" + dVar, new Object[0]);
            if (dVar != null && !this.d.contains(dVar)) {
                this.d.add(dVar);
            }
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.e.c
    public void b() {
        a();
        com.tencent.cloud.huiyansdkface.a.d.a.b("V1PreviewProcessor", "start preview callback.", new Object[0]);
        this.b.setPreviewCallbackWithBuffer(new Camera.PreviewCallback() { // from class: com.tencent.cloud.huiyansdkface.a.c.a.k.2
            @Override // android.hardware.Camera.PreviewCallback
            public void onPreviewFrame(final byte[] bArr, Camera camera) {
                byte[] bArr2;
                if (k.this.h.f21778a) {
                    bArr2 = new byte[bArr.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                } else {
                    bArr2 = bArr;
                }
                if (k.this.h.b) {
                    k.this.a(bArr2, bArr);
                    return;
                }
                final byte[] bArr3 = bArr2;
                k.f21773a.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.a.c.a.k.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        k.this.a(bArr3, bArr);
                    }
                });
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.a.e.c
    public void c() {
        com.tencent.cloud.huiyansdkface.a.d.a.b("V1PreviewProcessor", "stop preview callback.", new Object[0]);
        this.b.setPreviewCallbackWithBuffer(null);
    }
}
