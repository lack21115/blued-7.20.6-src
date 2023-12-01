package a.a.a.a.a.b;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public e f1234a;
    public Camera b;

    /* renamed from: c  reason: collision with root package name */
    public volatile Camera.CameraInfo f1235c;
    public Camera.Parameters d;
    public Handler e;
    public d f;
    public int g;
    public final Object h;
    public ConditionVariable i;
    public Semaphore j;

    /* renamed from: a.a.a.a.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/b$b.class */
    public class HandlerC0006b extends Handler {
        public HandlerC0006b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
            eVar.c("CameraDevice", "msg.what:" + message.what);
            try {
                switch (message.what) {
                    case 1:
                        b.this.b.stopPreview();
                        b.this.b.setPreviewCallbackWithBuffer(null);
                        b.this.b.release();
                        b.this.b = null;
                        b.this.f = null;
                        b.this.d = null;
                        a.a.a.a.a.e.e.g.c("CameraDevice", "RELEASE");
                        break;
                    case 2:
                        try {
                            b.this.b.setPreviewTexture((SurfaceTexture) message.obj);
                            return;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    case 3:
                        a.a.a.a.a.e.e.g.c("CameraDevice", "startPreview");
                        b.this.b.startPreview();
                        return;
                    case 4:
                        b.this.b.stopPreview();
                        break;
                    case 5:
                        b.this.b.setParameters((Camera.Parameters) message.obj);
                        break;
                    case 6:
                        b.this.d = b.this.b.getParameters();
                        break;
                    case 7:
                        b.this.b.setOneShotPreviewCallback((Camera.PreviewCallback) message.obj);
                        break;
                    case 8:
                        b.this.b.setPreviewCallbackWithBuffer((Camera.PreviewCallback) message.obj);
                        break;
                    case 9:
                        a.a.a.a.a.e.e eVar2 = a.a.a.a.a.e.e.g;
                        eVar2.c("CameraDevice", "arg1:" + message.arg1);
                        b.this.b.setDisplayOrientation(message.arg1);
                        break;
                    case 10:
                        b.this.b.setErrorCallback((Camera.ErrorCallback) message.obj);
                        break;
                    case 11:
                        for (byte[] bArr : (List) message.obj) {
                            a.a.a.a.a.e.e eVar3 = a.a.a.a.a.e.e.g;
                            eVar3.c("CameraDevice", bArr + " added");
                            b.this.b.addCallbackBuffer(bArr);
                        }
                        break;
                    case 12:
                        b.this.b.autoFocus((Camera.AutoFocusCallback) message.obj);
                        break;
                    case 13:
                        b.this.b.cancelAutoFocus();
                        break;
                    case 14:
                        try {
                            b.this.b.setAutoFocusMoveCallback((Camera.AutoFocusMoveCallback) message.obj);
                            break;
                        } catch (NoClassDefFoundError e2) {
                            a.a.a.a.a.e.e eVar4 = a.a.a.a.a.e.e.g;
                            eVar4.e("CameraDevice", "FATAL ERROR:" + e2.getMessage());
                            break;
                        }
                }
            } catch (NullPointerException e3) {
                a.a.a.a.a.e.e eVar5 = a.a.a.a.a.e.e.g;
                eVar5.e("CameraDevice", "exception msg:" + e3.getMessage());
            } catch (RuntimeException e4) {
                if (message.what != 1 && b.this.b != null) {
                    try {
                        a.a.a.a.a.e.e eVar6 = a.a.a.a.a.e.e.g;
                        eVar6.e("CameraDevice", "CameraManager,CameraHandler in handle message exception:" + e4);
                        b.this.b.release();
                    } catch (Exception e5) {
                        a.a.a.a.a.e.e.g.e("CameraDevice", "Fail to release the camera.");
                    }
                    b.this.b = null;
                    b.this.f = null;
                    b.this.d = null;
                }
            }
            b.this.g();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/b$c.class */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final b f1237a = new b();
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/b$d.class */
    public class d {
        public d() {
            new ReentrantLock();
            a.a.a.a.a.e.h.a(b.this.b != null);
        }

        public void a() {
            synchronized (this) {
                b.this.e.removeCallbacksAndMessages(null);
                b.this.e();
                b.this.e.sendEmptyMessage(1);
                b.this.f();
            }
        }

        public void a(int i) {
            b.this.e();
            b.this.e.obtainMessage(9, i, 0).sendToTarget();
            b.this.f();
        }

        public void a(SurfaceTexture surfaceTexture) {
            b.this.e.obtainMessage(2, surfaceTexture).sendToTarget();
        }

        public void a(Camera.AutoFocusCallback autoFocusCallback) {
            b.this.i.close();
            b.this.e.obtainMessage(12, autoFocusCallback).sendToTarget();
            b.this.i.block();
        }

        public void a(Camera.AutoFocusMoveCallback autoFocusMoveCallback) {
            b.this.i.close();
            b.this.e.obtainMessage(14, autoFocusMoveCallback).sendToTarget();
            b.this.i.block();
        }

        public void a(Camera.Parameters parameters) {
            b.this.e();
            b.this.e.obtainMessage(5, parameters).sendToTarget();
            b.this.f();
            b(parameters);
        }

        public void a(Camera.PreviewCallback previewCallback) {
            b.this.e();
            b.this.e.obtainMessage(8, previewCallback).sendToTarget();
            b.this.f();
        }

        public void a(List<byte[]> list) {
            b.this.e();
            b.this.e.obtainMessage(11, list).sendToTarget();
            b.this.f();
        }

        public void b() {
            b.this.e.sendEmptyMessage(3);
        }

        public final void b(Camera.Parameters parameters) {
            if (b.this.f1234a != null) {
                b.this.f1234a.a(parameters);
            }
        }

        public void b(Camera.PreviewCallback previewCallback) {
            b.this.e();
            b.this.e.obtainMessage(7, previewCallback).sendToTarget();
            b.this.f();
        }

        public void c() {
            b.this.e();
            b.this.e.sendEmptyMessage(4);
            b.this.f();
        }

        public Camera.Parameters d() {
            b.this.e();
            b.this.e.sendEmptyMessage(6);
            b.this.f();
            b(b.this.d);
            return b.this.d;
        }

        public void e() {
            b.this.i.close();
            b.this.e.sendEmptyMessage(13);
            b.this.i.block();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/b$e.class */
    public interface e {
        void a(Camera.Parameters parameters);
    }

    public b() {
        this.f1235c = new Camera.CameraInfo();
        this.g = -1;
        this.h = new Object();
        this.i = new ConditionVariable();
        this.j = new Semaphore(1);
        HandlerThread handlerThread = new HandlerThread("CameraHandlerThread");
        handlerThread.start();
        this.e = new HandlerC0006b(handlerThread.getLooper());
    }

    public static b a() {
        return c.f1237a;
    }

    public static boolean a(int i) {
        if (Build.VERSION.SDK_INT < 9) {
            return false;
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras > 2 && i == 2) {
            return true;
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= numberOfCameras) {
                return false;
            }
            Camera.getCameraInfo(i3, cameraInfo);
            if (i == cameraInfo.facing) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    public void a(e eVar) {
        this.f1234a = eVar;
    }

    public d b(int i) {
        synchronized (this) {
            c(i);
            if (this.b != null) {
                d dVar = new d();
                this.f = dVar;
                return dVar;
            }
            return null;
        }
    }

    public Camera.CameraInfo b() {
        Camera.CameraInfo cameraInfo;
        synchronized (this.h) {
            Camera.getCameraInfo(this.g, this.f1235c);
            cameraInfo = this.f1235c;
        }
        return cameraInfo;
    }

    public final void c(int i) {
        this.e.removeCallbacksAndMessages(null);
        if (this.b != null) {
            this.f.a();
        }
        this.b = Camera.open(i);
        this.g = i;
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
        eVar.c("CameraDevice", "camera opened:" + this.b + ",(" + i + ")");
        synchronized (this.h) {
            Camera.getCameraInfo(i, this.f1235c);
        }
    }

    public boolean c() {
        boolean z;
        synchronized (this.h) {
            z = true;
            if (this.f1235c.facing != 1) {
                z = false;
            }
        }
        return z;
    }

    public int d() {
        return Camera.getNumberOfCameras();
    }

    public final void e() {
        a.a.a.a.a.e.e.g.a("CameraDevice", "sginal: acquiring semphore");
        try {
            this.j.acquire();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        this.i.close();
        a.a.a.a.a.e.e.g.a("CameraDevice", "sginal: acquired semphore");
    }

    public final void f() {
        a.a.a.a.a.e.e.g.a("CameraDevice", "sginal: blocking");
        this.i.block();
        a.a.a.a.a.e.e.g.a("CameraDevice", "sginal: released blocking");
    }

    public final void g() {
        a.a.a.a.a.e.e.g.a("CameraDevice", "sginal: releasing semphore");
        this.i.open();
        this.j.release();
        a.a.a.a.a.e.e.g.a("CameraDevice", "sginal: released semphore");
    }
}
