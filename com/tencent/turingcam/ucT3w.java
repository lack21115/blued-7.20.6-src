package com.tencent.turingcam;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.turingcam.kWj12;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/ucT3w.class */
public class ucT3w extends s7Dnc {
    private WeakReference<View> b;

    /* renamed from: c  reason: collision with root package name */
    private int f26143c;
    private int d;
    private long e;
    private long f;

    public ucT3w() {
        super("3");
        this.f26143c = 0;
        this.d = 180;
    }

    private Bi3eT a(Bitmap bitmap, int i) {
        Bi3eT bi3eT = new Bi3eT();
        bi3eT.b = a();
        bi3eT.f26119c = i;
        bi3eT.e = bitmap.getWidth();
        bi3eT.f = bitmap.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
        bi3eT.d = byteArrayOutputStream.toByteArray();
        return bi3eT;
    }

    @Override // com.tencent.turingcam.s7Dnc
    public long a(kWj12.spXPg spxpg) {
        View b = spxpg.b();
        this.e = System.currentTimeMillis();
        this.f = spxpg.e();
        if (b == null) {
            hxUS9.b().a("checker_start_codes", a(), String.valueOf(-1001L));
            return -1001L;
        } else if (!(b instanceof com.tencent.turingcam.view.ShGzN)) {
            hxUS9.b().a("checker_start_codes", a(), String.valueOf(-1002L));
            return -1002L;
        } else {
            int b2 = spxpg.b(180);
            if (b2 > 0) {
                this.d = b2;
            }
            this.b = new WeakReference<>(b);
            this.f26143c = 0;
            hxUS9.b().a("checker_start_codes", a(), String.valueOf(0L));
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    @Override // com.tencent.turingcam.s7Dnc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.tencent.turingcam.s7Dnc.spXPg r9, android.hardware.Camera r10, com.tencent.turingcam.wmqhz r11) {
        /*
            Method dump skipped, instructions count: 651
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingcam.ucT3w.a(com.tencent.turingcam.s7Dnc$spXPg, android.hardware.Camera, com.tencent.turingcam.wmqhz):boolean");
    }
}
