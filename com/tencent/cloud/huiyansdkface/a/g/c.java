package com.tencent.cloud.huiyansdkface.a.g;

import android.content.Context;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.cloud.huiyansdkface.a.a.a.d;
import com.tencent.cloud.huiyansdkface.a.g.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/g/c.class */
public class c extends FrameLayout implements b {

    /* renamed from: a  reason: collision with root package name */
    a f35487a;
    View b;

    /* renamed from: c  reason: collision with root package name */
    private CountDownLatch f35488c;
    private SurfaceView d;
    private volatile SurfaceHolder e;
    private boolean f;
    private com.tencent.cloud.huiyansdkface.a.a.a.c g;
    private com.tencent.cloud.huiyansdkface.a.e.b h;
    private Rect i;
    private com.tencent.cloud.huiyansdkface.a.c j;
    private boolean k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.cloud.huiyansdkface.a.g.c$4  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/g/c$4.class */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f35492a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:37:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0051 -> B:33:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:31:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:27:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:35:0x0040). Please submit an issue!!! */
        static {
            int[] iArr = new int[com.tencent.cloud.huiyansdkface.a.a.a.c.values().length];
            f35492a = iArr;
            try {
                iArr[com.tencent.cloud.huiyansdkface.a.a.a.c.CROP_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f35492a[com.tencent.cloud.huiyansdkface.a.a.a.c.CROP_START.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f35492a[com.tencent.cloud.huiyansdkface.a.a.a.c.CROP_END.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f35492a[com.tencent.cloud.huiyansdkface.a.a.a.c.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f35492a[com.tencent.cloud.huiyansdkface.a.a.a.c.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f35492a[com.tencent.cloud.huiyansdkface.a.a.a.c.FIT_CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public c(Context context) {
        super(context);
        this.f35488c = new CountDownLatch(1);
        this.f = false;
        this.k = false;
        b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tencent.cloud.huiyansdkface.a.c cVar, Object obj) {
        if (cVar != null) {
            cVar.a(obj);
        }
    }

    private void b(Context context) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int i;
        int i2;
        int i3;
        int width = getWidth();
        int height = getHeight();
        d dVar = new d(width, height);
        d b = this.h.b();
        d dVar2 = b;
        if (b()) {
            dVar2 = new d(b.b, b.f35431a);
        }
        d a2 = this.g.name().startsWith("FIT") ? com.tencent.cloud.huiyansdkface.a.f.b.a(dVar2, dVar) : com.tencent.cloud.huiyansdkface.a.f.b.b(dVar2, dVar);
        com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", "container layout size:width=" + width + ",height=" + height, new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("preview size scale result:");
        sb.append(a2);
        com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", sb.toString(), new Object[0]);
        int i4 = (a2.f35431a - width) / 2;
        int i5 = (a2.b - height) / 2;
        switch (AnonymousClass4.f35492a[this.g.ordinal()]) {
            case 1:
            case 6:
                i = -i4;
                i2 = -i5;
                i3 = width + i4;
                height += i5;
                break;
            case 2:
            case 4:
                i = -i4;
                i3 = width + i4;
                height += i5 * 2;
                i2 = 0;
                break;
            case 3:
            case 5:
                i = -i4;
                i2 = i5 * (-2);
                i3 = width + i4;
                break;
            default:
                i3 = 0;
                height = 0;
                i = 0;
                i2 = 0;
                break;
        }
        this.i = new Rect(i, i2, i3, height);
        com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", "we camera view child rect size:" + this.i.toShortString(), new Object[0]);
    }

    private boolean e() {
        if (this.f35488c.getCount() == 0 && this.e == null) {
            com.tencent.cloud.huiyansdkface.a.d.a.c("CameraSurfaceView", "surfaceHolder==null and countDownLatch==0", new Object[0]);
            return true;
        }
        try {
            com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", "attachCameraView:wait for surface create", new Object[0]);
            this.f35488c.await(1L, TimeUnit.SECONDS);
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return true;
        }
    }

    protected SurfaceView a(Context context) {
        return new SurfaceView(context);
    }

    @Override // com.tencent.cloud.huiyansdkface.a.g.b
    public void a() {
        this.k = true;
        com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", "startPreview now and request layout", new Object[0]);
    }

    @Override // com.tencent.cloud.huiyansdkface.a.g.b
    public void a(com.tencent.cloud.huiyansdkface.a.a.a.c cVar, com.tencent.cloud.huiyansdkface.a.e.b bVar) {
        this.g = cVar;
        this.h = bVar;
        com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", "setPreviewConfig", new Object[0]);
        c();
    }

    @Override // com.tencent.cloud.huiyansdkface.a.g.b
    public void a(com.tencent.cloud.huiyansdkface.a.c cVar) {
        this.j = cVar;
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.f35487a = aVar;
            this.b = aVar.a(getContext());
            this.f35487a.a(new a.InterfaceC0905a() { // from class: com.tencent.cloud.huiyansdkface.a.g.c.1
                @Override // com.tencent.cloud.huiyansdkface.a.g.a.InterfaceC0905a
                public void a() {
                    com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", "onPreviewCreated", new Object[0]);
                    c.this.f = true;
                    c.this.f35488c.countDown();
                }

                @Override // com.tencent.cloud.huiyansdkface.a.g.a.InterfaceC0905a
                public void b() {
                    com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", "onPreviewDestroy", new Object[0]);
                    c.this.g = null;
                    com.tencent.cloud.huiyansdkface.a.c cVar = c.this.j;
                    if (cVar != null) {
                        cVar.d();
                    }
                }
            });
            addView(this.b, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        this.d = a(getContext());
        if (this.e != null) {
            com.tencent.cloud.huiyansdkface.a.d.a.c("CameraSurfaceView", "surfaceHolder already created", new Object[0]);
            return;
        }
        this.d.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.tencent.cloud.huiyansdkface.a.g.c.2
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                StringBuilder sb = new StringBuilder();
                sb.append("surfaceChanged:");
                sb.append(surfaceHolder != null);
                sb.append(":");
                sb.append(i);
                sb.append(",width=");
                sb.append(i2);
                sb.append(",height=");
                sb.append(i3);
                com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", sb.toString(), new Object[0]);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                StringBuilder sb = new StringBuilder();
                sb.append("surfaceCreated:");
                sb.append(surfaceHolder != null);
                sb.append(":");
                sb.append(Thread.currentThread().getName());
                com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", sb.toString(), new Object[0]);
                if (c.this.k) {
                    c cVar = c.this;
                    cVar.a(cVar.j, c.this.d);
                    return;
                }
                c.this.e = surfaceHolder;
                c.this.f35488c.countDown();
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", "surfaceDestroyed:" + surfaceHolder, new Object[0]);
                c.this.g = null;
                com.tencent.cloud.huiyansdkface.a.c cVar = c.this.j;
                if (cVar != null) {
                    cVar.d();
                }
            }
        });
        addView(this.d, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.tencent.cloud.huiyansdkface.a.g.b
    public boolean a(com.tencent.cloud.huiyansdkface.a.c cVar, com.tencent.cloud.huiyansdkface.a.c.a.a aVar, boolean z) {
        a aVar2;
        if (z) {
            SurfaceView surfaceView = this.f35487a;
            if (surfaceView == null) {
                surfaceView = this.d;
            }
            a(cVar, surfaceView);
            return true;
        }
        a aVar3 = this.f35487a;
        if (aVar3 != null) {
            if (aVar3.b() && !this.f && e()) {
                return false;
            }
            aVar2 = this.f35487a;
        } else if (this.e == null && e()) {
            return false;
        } else {
            aVar2 = this.d;
        }
        a(cVar, aVar2);
        return true;
    }

    protected boolean b() {
        return (this.h.d() - this.h.e()) % 180 != 0;
    }

    public void c() {
        post(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.a.g.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.g == null) {
                    return;
                }
                c.this.d();
                Rect rect = c.this.i;
                View childAt = c.this.getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                layoutParams.width = rect.width();
                layoutParams.height = rect.height();
                layoutParams.topMargin = rect.top;
                layoutParams.leftMargin = rect.left;
                childAt.setLayoutParams(layoutParams);
            }
        });
    }

    public com.tencent.cloud.huiyansdkface.a.e.b getPreviewParameter() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f35488c.getCount() > 0) {
            this.f35488c.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", "onLayout:changed=" + z, new Object[0]);
        super.onLayout(z, i, i2, i3, i4);
        if (this.h == null || this.g == null || !z) {
            return;
        }
        c();
    }
}
