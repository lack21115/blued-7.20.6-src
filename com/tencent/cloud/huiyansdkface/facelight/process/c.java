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
    public boolean f21938a = false;

    /* renamed from: c  reason: collision with root package name */
    public int f21939c = 1280;
    public int d = UGCTransitionRules.DEFAULT_IMAGE_WIDTH;

    public int a(float[] fArr, float[] fArr2, int i, byte[] bArr, int i2, int i3, float f, float f2, float f3, int i4, int i5) {
        this.f21939c = i2;
        this.d = i3;
        return YTPoseDetectJNIInterface.poseDetect(fArr, fArr2, i, bArr, i2, i3, this.b, f, f2, f3, i4, i5);
    }

    public void a() {
    }

    public void a(int i, b.InterfaceC0742b interfaceC0742b) {
        if (this.f21938a) {
            WLogger.d(e, "Restart FaceDetect process. YTPoseDetectInterface.stop() should be called before the next start, or maybe camera's parameter may be setting wrong.");
        }
        this.b = i;
        this.f21938a = true;
        interfaceC0742b.a();
    }

    public void b() {
    }

    public void c() {
        if (this.f21938a) {
            this.f21938a = false;
            YTPoseDetectJNIInterface.resetDetect();
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }
}
