package com.tencent.cloud.huiyansdkface.facelight.process;

import com.tencent.cloud.huiyansdkface.facelight.c.b.b;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.process.c.e;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import java.util.concurrent.Callable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/process/b.class */
public class b {
    private static InterfaceC0912b e;
    private static c f;
    private static final String b = b.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static int f35625c = 0;
    private static boolean d = false;

    /* renamed from: a  reason: collision with root package name */
    public static int f35624a = 0;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/process/b$a.class */
    public interface a {
        void a();

        void a(int i);

        void a(int i, String str, String str2);

        void a(byte[][] bArr, int i, int i2);
    }

    /* renamed from: com.tencent.cloud.huiyansdkface.facelight.process.b$b  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/process/b$b.class */
    public interface InterfaceC0912b {
        void a();

        void a(int i, String str, String str2);
    }

    public static int a() {
        try {
            YTPoseDetectJNIInterface.nativeLog(b, "[YTFacePreviewInterface.initModel] ---");
            if (f35625c > 0) {
                YTPoseDetectJNIInterface.nativeLog(b, "[YTFacePreviewInterface.initModel] has already inited.");
                f35625c++;
                return 0;
            }
            int initModel = YTPoseDetectJNIInterface.initModel("");
            if (initModel == 0) {
                c cVar = new c();
                f = cVar;
                cVar.a();
                f35625c++;
                return 0;
            }
            return initModel;
        } catch (Exception e2) {
            WLogger.e(b, "initModel failed. message: " + e2.toString());
            e2.printStackTrace();
            KycWaSDK.getInstance().trackCustomKVEvent(null, "facepage_model_init_failed", "PoseDetectInterface exception:" + e2.toString(), null);
            return 10;
        }
    }

    public static int a(int i, InterfaceC0912b interfaceC0912b) {
        YTPoseDetectJNIInterface.nativeLog(b, "[YTPoseDetectInterface.start] ---");
        if (interfaceC0912b == null) {
            return -1;
        }
        e = interfaceC0912b;
        if (f35625c > 0) {
            f.a(i, new InterfaceC0912b() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.b.5
                @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.InterfaceC0912b
                public void a() {
                    b.i();
                }

                @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.InterfaceC0912b
                public void a(int i2, String str, String str2) {
                    b.b(i2, str, str2);
                }
            });
            return 0;
        }
        b(2, "Not init model.", "Call YTPoseDetectInterface.initModel() before.");
        return 0;
    }

    public static void a(final com.tencent.cloud.huiyansdkface.facelight.process.c.d dVar) {
        WLogger.i(b, "getActReflectDataOnSubThread");
        com.tencent.cloud.huiyansdkface.facelight.c.b.b.a(new Callable<YTActRefData>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.b.3
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public YTActRefData call() {
                WLogger.i(b.b, "getActReflectData enter");
                return YTPoseDetectJNIInterface.getActionReflectData(b.f.b);
            }
        }, new b.a<YTActRefData>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.b.4
            @Override // com.tencent.cloud.huiyansdkface.facelight.c.b.b.a
            public void a(YTActRefData yTActRefData) {
                WLogger.i(b.b, "getActReflectData success,get bestImages!");
                com.tencent.cloud.huiyansdkface.facelight.process.c.d.this.a(yTActRefData);
            }
        });
    }

    public static void a(final e eVar) {
        WLogger.i(b, "getFrameListOnSubThread");
        com.tencent.cloud.huiyansdkface.facelight.c.b.b.a(new Callable<byte[][]>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.b.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public byte[][] call() {
                WLogger.i(b.b, "getFrameList enter");
                return YTPoseDetectJNIInterface.getFrameList();
            }
        }, new b.a<byte[][]>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.b.2
            @Override // com.tencent.cloud.huiyansdkface.facelight.c.b.b.a
            public void a(byte[][] bArr) {
                WLogger.i(b.b, "pushBackupData success,get bestImages!");
                e.this.a(bArr);
            }
        });
    }

    public static void a(float[] fArr, float[] fArr2, int i, byte[] bArr, int i2, int i3, float f2, float f3, float f4, a aVar, int i4, int i5) {
        int i6;
        String str;
        String str2;
        if (f35625c <= 0) {
            i6 = 2;
            str = "Not init model on poseDetect.";
            str2 = "Call YTPoseDetectInterface.initModel() before.";
        } else if (d) {
            int a2 = f.a(fArr, fArr2, i, bArr, i2, i3, f2, f3, f4, i4, i5);
            if (i != 5) {
                aVar.a(a2);
            }
            if (YTPoseDetectJNIInterface.canReflect()) {
                aVar.a();
            }
            if (YTPoseDetectJNIInterface.isRecordingDone()) {
                YTPoseDetectJNIInterface.nativeLog(b, "poseDetectOnFrame.onRecordingDone.");
                aVar.a((byte[][]) null, 0, 0);
                return;
            }
            return;
        } else {
            i6 = 3;
            str = "Not call start() interface before.";
            str2 = "Call YTPoseDetectInterface.start() before.";
        }
        aVar.a(i6, str, str2);
    }

    public static void b() {
        YTPoseDetectJNIInterface.nativeLog(b, "[YTFacePreviewInterface.finalize] ---");
        int i = f35625c - 1;
        f35625c = i;
        if (i <= 0) {
            c cVar = f;
            if (cVar != null) {
                cVar.b();
            }
            YTPoseDetectJNIInterface.releaseAll();
            f35625c = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i, String str, String str2) {
        String str3 = b;
        YTPoseDetectJNIInterface.nativeLog(str3, "[YTPoseDetectInterface.noticeFailed] resultCode: " + i + " \r\nmessage: " + str + " \r\ntips: " + str2);
        e.a(i, str, str2);
        e = null;
        d = false;
    }

    public static void c() {
        YTPoseDetectJNIInterface.resetDetect();
    }

    public static void d() {
        YTPoseDetectJNIInterface.nativeLog(b, "[YTPoseDetectInterface.stop] ---");
        c cVar = f;
        if (cVar != null) {
            cVar.c();
        }
        d = false;
    }

    public static boolean e() {
        c cVar = f;
        return cVar != null && cVar.f35629a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i() {
        YTPoseDetectJNIInterface.nativeLog(b, "[YTPoseDetectInterface.noticeSuccess] ---");
        e.a();
        e = null;
        d = true;
    }
}
