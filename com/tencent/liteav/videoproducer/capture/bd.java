package com.tencent.liteav.videoproducer.capture;

import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.r;
import com.tencent.rtmp.video.TXScreenCapture;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/bd.class */
public class bd {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bd f23220a;
    private final Context b;
    private MediaProjection g;
    private com.tencent.liteav.base.util.r h;
    private boolean i;
    private final Map<Surface, a> e = new HashMap();
    private boolean f = false;
    private final Runnable j = be.a(this);
    private final MediaProjection.Callback k = new AnonymousClass1();
    private final r.a l = new r.a() { // from class: com.tencent.liteav.videoproducer.capture.bd.2
        @Override // com.tencent.liteav.base.util.r.a
        public final void a_() {
            bd.this.d.a(bj.a(bd.this));
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final Handler f23221c = new com.tencent.liteav.base.util.b(Looper.getMainLooper());
    private final com.tencent.liteav.base.util.j d = new com.tencent.liteav.base.util.j();

    /* renamed from: com.tencent.liteav.videoproducer.capture.bd$1  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/bd$1.class */
    final class AnonymousClass1 extends MediaProjection.Callback {
        AnonymousClass1() {
        }

        @Override // android.media.projection.MediaProjection.Callback
        public final void onStop() {
            LiteavLog.e("VirtualDisplayManager", "MediaProjection session is no longer valid");
            bd.this.d.a(bi.a(bd.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/bd$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Surface f23224a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f23225c;
        public b d;
        public VirtualDisplay e;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/bd$b.class */
    public interface b {
        void a(boolean z, boolean z2);

        void b(boolean z);

        void e();
    }

    private bd(Context context) {
        this.b = context.getApplicationContext();
        this.i = b(context);
    }

    public static bd a(Context context) {
        if (f23220a == null) {
            synchronized (bd.class) {
                try {
                    if (f23220a == null) {
                        f23220a = new bd(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f23220a;
    }

    private void a() {
        for (a aVar : this.e.values()) {
            if (aVar.e == null) {
                aVar.e = this.g.createVirtualDisplay("TXCScreenCapture", aVar.b, aVar.f23225c, 1, 1, aVar.f23224a, (VirtualDisplay.Callback) null, (Handler) null);
                LiteavLog.i("VirtualDisplayManager", "create VirtualDisplay " + aVar.e);
                if (aVar.d != null) {
                    aVar.d.a(true, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(bd bdVar, MediaProjection mediaProjection) {
        bdVar.f = false;
        if (mediaProjection == null) {
            HashMap hashMap = new HashMap(bdVar.e);
            bdVar.e.clear();
            for (a aVar : hashMap.values()) {
                if (aVar.d != null) {
                    aVar.d.a(false, true);
                }
            }
            return;
        }
        LiteavLog.i("VirtualDisplayManager", "Got session ".concat(String.valueOf(mediaProjection)));
        bdVar.g = mediaProjection;
        mediaProjection.registerCallback(bdVar.k, bdVar.f23221c);
        bdVar.a();
        com.tencent.liteav.base.util.r rVar = new com.tencent.liteav.base.util.r(Looper.getMainLooper(), bdVar.l);
        bdVar.h = rVar;
        rVar.a(50, 50);
        b(bdVar.g);
        bdVar.a(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(bd bdVar, Surface surface) {
        if (surface != null) {
            a remove = bdVar.e.remove(surface);
            if (remove != null && remove.e != null) {
                remove.e.release();
                LiteavLog.i("VirtualDisplayManager", "VirtualDisplay released, " + remove.e);
            }
            bdVar.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(bd bdVar, Surface surface, int i, int i2, MediaProjection mediaProjection, b bVar) {
        if (surface == null) {
            LiteavLog.e("VirtualDisplayManager", "surface is null!");
            bVar.a(false, false);
            return;
        }
        a aVar = new a((byte) 0);
        aVar.f23224a = surface;
        aVar.b = i;
        aVar.f23225c = i2;
        aVar.d = bVar;
        aVar.e = null;
        bdVar.e.put(surface, aVar);
        bdVar.d.c(bdVar.j);
        if (bdVar.g == null && mediaProjection == null) {
            if (bdVar.f) {
                return;
            }
            bdVar.f = true;
            Intent intent = new Intent(bdVar.b, TXScreenCapture.TXScreenCaptureAssistantActivity.class);
            intent.addFlags(268435456);
            bdVar.b.startActivity(intent);
        } else if (mediaProjection == null || bdVar.g == mediaProjection) {
            bdVar.a();
        } else {
            LiteavLog.i("VirtualDisplayManager", "startVirtualDisplay with media projection:".concat(String.valueOf(mediaProjection)));
            bdVar.a(mediaProjection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.e.isEmpty()) {
            if (z) {
                this.d.a(this.j, TimeUnit.SECONDS.toMillis(1L));
                return;
            }
            LiteavLog.i("VirtualDisplayManager", "Stop media projection session " + this.g);
            if (this.g != null) {
                b((MediaProjection) null);
                try {
                    this.g.unregisterCallback(this.k);
                    this.g.stop();
                } catch (Throwable th) {
                    LiteavLog.w("VirtualDisplayManager", "stop media projection session with exception ", th);
                }
                this.g = null;
            }
            com.tencent.liteav.base.util.r rVar = this.h;
            if (rVar != null) {
                rVar.a();
                this.h = null;
            }
        }
    }

    private static void b(MediaProjection mediaProjection) {
        try {
            Class.forName("com.tencent.liteav.audio.SystemLoopbackRecorder").getMethod("notifyMediaProjectionState", MediaProjection.class).invoke(null, mediaProjection);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            LiteavLog.e("VirtualDisplayManager", "fail to send media projection session " + e.getMessage());
        }
    }

    private static boolean b(Context context) {
        int rotation;
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return windowManager == null || (rotation = windowManager.getDefaultDisplay().getRotation()) == 0 || rotation == 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(bd bdVar) {
        HashMap hashMap = new HashMap(bdVar.e);
        bdVar.e.clear();
        for (a aVar : hashMap.values()) {
            if (aVar.d != null) {
                if (aVar.e != null) {
                    aVar.d.e();
                } else {
                    aVar.d.a(false, false);
                }
            }
        }
        bdVar.a(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(bd bdVar) {
        boolean b2 = b(bdVar.b);
        if (bdVar.i != b2) {
            bdVar.i = b2;
            for (a aVar : bdVar.e.values()) {
                if (aVar.d != null) {
                    aVar.d.b(b2);
                }
            }
        }
    }

    public final void a(MediaProjection mediaProjection) {
        this.d.a(bh.a(this, mediaProjection));
    }

    public final void a(Surface surface) {
        this.d.b(bg.a(this, surface));
    }

    public final void a(Surface surface, int i, int i2, MediaProjection mediaProjection, b bVar) {
        this.d.b(bf.a(this, surface, i, i2, mediaProjection, bVar));
    }
}
