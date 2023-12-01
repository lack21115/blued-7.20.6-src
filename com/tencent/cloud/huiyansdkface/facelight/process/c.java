package com.tencent.cloud.huiyansdkface.facelight.process;

import com.tencent.cloud.huiyansdkface.facelight.process.b;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.ugc.UGCTransitionRules;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/process/c.class */
public class c {
    private static final String e = c.class.getSimpleName();
    public int b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f35629a = false;

    /* renamed from: c  reason: collision with root package name */
    public int f35630c = 1280;
    public int d = UGCTransitionRules.DEFAULT_IMAGE_WIDTH;

    public int a(float[] fArr, float[] fArr2, int i, byte[] bArr, int i2, int i3, float f, float f2, float f3, int i4, int i5) {
        this.f35630c = i2;
        this.d = i3;
        return YTPoseDetectJNIInterface.poseDetect(fArr, fArr2, i, bArr, i2, i3, this.b, f, f2, f3, i4, i5);
    }

    public void a() {
    }

    public void a(int i, b.InterfaceC0912b interfaceC0912b) {
        if (this.f35629a) {
            WLogger.d(e, "Restart FaceDetect process. YTPoseDetectInterface.stop() should be called before the next start, or maybe camera's parameter may be setting wrong.");
        }
        this.b = i;
        this.f35629a = true;
        interfaceC0912b.a();
    }

    public void b() {
    }

    public void c() {
        if (this.f35629a) {
            this.f35629a = false;
            YTPoseDetectJNIInterface.resetDetect();
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }
}
