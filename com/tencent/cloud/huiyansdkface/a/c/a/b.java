package com.tencent.cloud.huiyansdkface.a.c.a;

import android.hardware.Camera;
import android.view.SurfaceView;
import java.io.IOException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/c/a/b.class */
public class b implements com.tencent.cloud.huiyansdkface.a.c.a<a> {
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private int f21760c;
    private com.tencent.cloud.huiyansdkface.a.e.b e;
    private volatile boolean d = false;

    /* renamed from: a  reason: collision with root package name */
    private f f21759a = new f();

    @Override // com.tencent.cloud.huiyansdkface.a.c.a
    public com.tencent.cloud.huiyansdkface.a.a.a a(com.tencent.cloud.huiyansdkface.a.a.c cVar) {
        return new d(this, this.b).a(cVar);
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.a
    public void a() {
        this.f21759a.a();
        this.b = null;
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.a
    public void a(float f) {
        if (f == -1.0f) {
            return;
        }
        new l(this.b.a()).a(f);
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.a
    public void a(com.tencent.cloud.huiyansdkface.a.a.f fVar, int i) {
        this.f21760c = i;
        a aVar = this.b;
        if (aVar != null) {
            int i2 = -1;
            if (fVar != null) {
                i2 = fVar.a(aVar, i);
            }
            int i3 = i2;
            if (i2 < 0) {
                i3 = com.tencent.cloud.huiyansdkface.a.f.a.a(this.b.d(), i, this.b.e());
            }
            com.tencent.cloud.huiyansdkface.a.d.a.a("CameraV1Device", "camera set display orientation:screenOrientation=" + i + ",camera orientation=" + this.b.e() + ",\ncalc display orientation result:" + i3, new Object[0]);
            this.b.a().setDisplayOrientation(i3);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.a
    public void a(Object obj) {
        if (obj instanceof com.tencent.cloud.huiyansdkface.a.g.a) {
            ((com.tencent.cloud.huiyansdkface.a.g.a) obj).a(this.b);
            return;
        }
        if (obj == null) {
            try {
                this.b.a().setPreviewDisplay(null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            com.tencent.cloud.huiyansdkface.a.d.a.a("CameraV1Device", "set display view :" + obj, new Object[0]);
            this.b.a().setPreviewDisplay(((SurfaceView) obj).getHolder());
        } catch (Exception e2) {
            com.tencent.cloud.huiyansdkface.a.b.b.a(com.tencent.cloud.huiyansdkface.a.b.c.b(3, "set preview display failed", e2));
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.a
    /* renamed from: b */
    public a a(com.tencent.cloud.huiyansdkface.a.a.a.a aVar) {
        try {
            if (this.f21759a.a(aVar) == null) {
                com.tencent.cloud.huiyansdkface.a.b.b.a(com.tencent.cloud.huiyansdkface.a.b.c.b(11, "no camera can use", null));
                return null;
            }
            a b = this.f21759a.b();
            this.b = b;
            b.a(f());
            return this.b;
        } catch (Exception e) {
            com.tencent.cloud.huiyansdkface.a.b.b.a(com.tencent.cloud.huiyansdkface.a.b.c.b(1, "open camera exception", e));
            return null;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.a
    public void b() {
        this.d = false;
        com.tencent.cloud.huiyansdkface.a.d.a.a("CameraV1Device", "startPreview", new Object[0]);
        try {
            this.b.a().startPreview();
        } catch (Throwable th) {
            com.tencent.cloud.huiyansdkface.a.b.b.a(com.tencent.cloud.huiyansdkface.a.b.c.a(3, "start preview failed", th));
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.a
    public void c() {
        synchronized (this) {
            if (this.b != null) {
                com.tencent.cloud.huiyansdkface.a.d.a.a("CameraV1Device", "stopPreview", new Object[0]);
                this.b.a().stopPreview();
                this.d = true;
            } else if (!this.d) {
                com.tencent.cloud.huiyansdkface.a.b.b.a(com.tencent.cloud.huiyansdkface.a.b.c.a(81, "you must start preview first"));
            }
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.a
    public com.tencent.cloud.huiyansdkface.a.e.b d() {
        com.tencent.cloud.huiyansdkface.a.e.b bVar = this.e;
        if (bVar != null) {
            return bVar;
        }
        com.tencent.cloud.huiyansdkface.a.e.b bVar2 = new com.tencent.cloud.huiyansdkface.a.e.b();
        Camera.Parameters parameters = this.b.a().getParameters();
        Camera.Size previewSize = parameters.getPreviewSize();
        com.tencent.cloud.huiyansdkface.a.e.b d = bVar2.a(new com.tencent.cloud.huiyansdkface.a.a.a.d(previewSize.width, previewSize.height)).a(this.b.d()).c(this.b.e()).b(this.f21760c).a(com.tencent.cloud.huiyansdkface.a.f.a.a(this.b.d(), this.f21760c, this.b.e())).d(parameters.getPreviewFormat());
        this.e = d;
        return d;
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.a
    public com.tencent.cloud.huiyansdkface.a.e.c e() {
        return new k(this, this.b.a());
    }

    public com.tencent.cloud.huiyansdkface.a.a.d f() {
        a aVar = this.b;
        if (aVar == null) {
            return null;
        }
        return new g(aVar).a();
    }
}
