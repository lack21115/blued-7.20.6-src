package com.tencent.liteav.videoproducer.producer;

import android.content.Context;
import android.os.Looper;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.videobase.utils.Rotation;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/d.class */
public final class d extends OrientationEventListener implements r.a {

    /* renamed from: a  reason: collision with root package name */
    private final a f23456a;
    private final Display b;

    /* renamed from: c  reason: collision with root package name */
    private Rotation f23457c;
    private int d;
    private com.tencent.liteav.base.util.r e;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/d$a.class */
    public interface a {
        void a(Rotation rotation, int i);
    }

    public d(Context context, a aVar) {
        super(context);
        this.f23456a = aVar;
        this.b = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
    }

    private static int a(int i) {
        int i2 = 0;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return i != 3 ? 0 : 270;
                }
                return 180;
            }
            i2 = 90;
        }
        return i2;
    }

    private void b() {
        a aVar = this.f23456a;
        if (aVar != null) {
            aVar.a(this.f23457c, a(this.d));
        }
    }

    @Override // com.tencent.liteav.base.util.r.a
    public final void a_() {
        int rotation = this.b.getRotation();
        if (this.d != rotation) {
            this.d = rotation;
            b();
        }
    }

    @Override // android.view.OrientationEventListener
    public final void disable() {
        super.disable();
        com.tencent.liteav.base.util.r rVar = this.e;
        if (rVar != null) {
            rVar.a();
            this.e = null;
        }
    }

    @Override // android.view.OrientationEventListener
    public final void enable() {
        super.enable();
        if (this.e == null) {
            com.tencent.liteav.base.util.r rVar = new com.tencent.liteav.base.util.r(Looper.getMainLooper(), this);
            this.e = rVar;
            rVar.a(0, 1000);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // android.view.OrientationEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onOrientationChanged(int r4) {
        /*
            r3 = this;
            r0 = r4
            r1 = -1
            if (r0 != r1) goto L6
            return
        L6:
            r0 = r4
            r1 = 45
            if (r0 <= r1) goto L36
            r0 = r4
            r1 = 135(0x87, float:1.89E-43)
            if (r0 > r1) goto L1a
            com.tencent.liteav.videobase.utils.Rotation r0 = com.tencent.liteav.videobase.utils.Rotation.ROTATION_90
            r5 = r0
            goto L3a
        L1a:
            r0 = r4
            r1 = 225(0xe1, float:3.15E-43)
            if (r0 > r1) goto L28
            com.tencent.liteav.videobase.utils.Rotation r0 = com.tencent.liteav.videobase.utils.Rotation.ROTATION_180
            r5 = r0
            goto L3a
        L28:
            r0 = r4
            r1 = 315(0x13b, float:4.41E-43)
            if (r0 > r1) goto L36
            com.tencent.liteav.videobase.utils.Rotation r0 = com.tencent.liteav.videobase.utils.Rotation.ROTATION_270
            r5 = r0
            goto L3a
        L36:
            com.tencent.liteav.videobase.utils.Rotation r0 = com.tencent.liteav.videobase.utils.Rotation.NORMAL
            r5 = r0
        L3a:
            r0 = r3
            com.tencent.liteav.videobase.utils.Rotation r0 = r0.f23457c
            r1 = r5
            if (r0 == r1) goto L56
            r0 = r3
            r1 = r5
            r0.f23457c = r1
            r0 = r3
            r1 = r3
            android.view.Display r1 = r1.b
            int r1 = r1.getRotation()
            r0.d = r1
            r0 = r3
            r0.b()
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.producer.d.onOrientationChanged(int):void");
    }
}
