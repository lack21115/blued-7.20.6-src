package com.tencent.turingcam;

import android.hardware.Camera;
import com.tencent.turingcam.kWj12;
import com.tencent.turingcam.s7Dnc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/yiZAu.class */
public class yiZAu extends s7Dnc {
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private long f39845c;
    private int d;
    private float e;
    private int f;
    private int g;
    private int h;
    private long i;

    public yiZAu() {
        super("5");
        this.f39845c = 0L;
        this.d = 0;
    }

    @Override // com.tencent.turingcam.s7Dnc
    public long a(kWj12.spXPg spxpg) {
        Camera.Parameters parameters = spxpg.a().getParameters();
        if (parameters.getMaxExposureCompensation() == parameters.getMinExposureCompensation()) {
            return -1002L;
        }
        this.b = parameters.getExposureCompensation();
        this.f = spxpg.e(300);
        this.g = spxpg.d(1000);
        this.h = spxpg.c(300);
        this.e = spxpg.c();
        this.d = 0;
        this.f39845c = System.currentTimeMillis();
        this.i = System.currentTimeMillis();
        return 0L;
    }

    @Override // com.tencent.turingcam.s7Dnc
    public boolean a(s7Dnc.spXPg spxpg, Camera camera, wmqhz wmqhzVar) {
        if (System.currentTimeMillis() - this.i < this.h) {
            return false;
        }
        float f = this.e;
        Camera.Parameters parameters = camera.getParameters();
        parameters.setExposureCompensation(Math.max(Math.min(Math.round(f / parameters.getExposureCompensationStep()), parameters.getMaxExposureCompensation()), parameters.getMinExposureCompensation()));
        camera.setParameters(parameters);
        Camera.Parameters parameters2 = camera.getParameters();
        int i = parameters2.getPreviewSize().width;
        int i2 = parameters2.getPreviewSize().height;
        if (System.currentTimeMillis() - this.f39845c > this.f) {
            int i3 = (int) (i * 0.1f);
            int i4 = (int) (i2 * 0.1f);
            byte[] bArr = new byte[i3 * i4];
            byte[] bArr2 = spxpg.b;
            int i5 = (i2 - i4) / 2;
            int i6 = (i - i3) / 2;
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= i4) {
                    break;
                }
                System.arraycopy((Object) bArr2, ((i5 + i8) * i) + i6, (Object) bArr, i3 * i8, i3);
                i7 = i8 + 1;
            }
            Bi3eT bi3eT = new Bi3eT();
            bi3eT.b = a();
            int i9 = this.d;
            this.d = i9 + 1;
            bi3eT.f39810c = i9;
            bi3eT.e = i3;
            bi3eT.f = i4;
            bi3eT.d = bArr;
            wmqhzVar.f39841c.add(bi3eT);
            this.f39845c = System.currentTimeMillis();
            if (this.d >= this.g / this.f) {
                parameters2.setExposureCompensation(this.b);
                camera.setParameters(parameters2);
                return true;
            }
            return false;
        }
        return false;
    }
}
