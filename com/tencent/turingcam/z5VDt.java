package com.tencent.turingcam;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import com.huawei.openalliance.ad.constant.t;
import com.sobot.chat.camera.StCameraView;
import com.tencent.turingcam.s7Dnc;
import com.tencent.turingcam.view.ShGzN;
import com.tencent.turingcam.view.TuringPreviewDisplay;
import com.tencent.turingcam.y8N3A;
import com.tencent.turingface.sdk.mfa.c9YSQ;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/z5VDt.class */
public class z5VDt {

    /* renamed from: a  reason: collision with root package name */
    private static final String f26155a = WOMZP.b("3spd2H8hHma4H18EjYTzWg==");
    private static final String b = WOMZP.b("DSv7X69YcoK1PCJvm8ce5osrHNM=");

    /* renamed from: c  reason: collision with root package name */
    private static final String f26156c = WOMZP.b("PRCBC9ulqKi8tK1vJSfQ3CVEfaa9uZL8xNsqSA==");
    private static final String d = WOMZP.b("ZhC44TH2gipmEmDqkN11sw==");
    private static final String e = WOMZP.b("GPJOXui0b6GBvil8JLG3bY/zgr9DbLPt");
    private static final String f = WOMZP.b("53GWiqTfPF5HGxYjWLrd0U4Oll+oAajp");
    private static final String g = WOMZP.b("tnBzhxxR/b+gYqxoICYmA1lN0tEjYYXvb1msZQ==");
    private static final String h = WOMZP.b("W31u13O9REtolI1/zQ62pl5cse0Shhs4WEu3fuJwapA=");
    private static final String i = WOMZP.b("WsIxLAQ7292izcD9D2+F/C1r56ivVsc57/Qy2Wr+k/4=");
    public static final /* synthetic */ int j = 0;
    private String k;
    private XnM3A l;
    private WeakReference<Camera> m;
    private B9LVG n;
    private kwCJn o;
    private WeakReference<View> p;
    private boolean q;
    private TuringFaceBuilder r;
    long s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/z5VDt$B9LVG.class */
    public interface B9LVG {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/z5VDt$Bi3eT.class */
    public static class Bi3eT {

        /* renamed from: a  reason: collision with root package name */
        private static final z5VDt f26157a = new z5VDt(null);

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ z5VDt a() {
            return f26157a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/z5VDt$ShGzN.class */
    public class ShGzN implements ShGzN.spXPg {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Camera f26158a;

        ShGzN(Camera camera) {
            this.f26158a = camera;
        }

        @Override // com.tencent.turingcam.view.ShGzN.spXPg
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            z5VDt.a(z5VDt.this, this.f26158a, surfaceTexture, null);
            if (z5VDt.this.n != null) {
                ((F2BEC) z5VDt.this.n).f26122a.onPreviewAvailable();
            }
        }

        @Override // com.tencent.turingcam.view.ShGzN.spXPg
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (z5VDt.this.n != null) {
                ((F2BEC) z5VDt.this.n).f26122a.onPreviewDestroyed();
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/z5VDt$SkEpO.class */
    public class SkEpO implements SurfaceHolder.Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Camera f26159a;

        SkEpO(Camera camera) {
            this.f26159a = camera;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            z5VDt.a(z5VDt.this, this.f26159a, null, surfaceHolder);
            if (z5VDt.this.n != null) {
                ((F2BEC) z5VDt.this.n).f26122a.onPreviewAvailable();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (z5VDt.this.n != null) {
                ((F2BEC) z5VDt.this.n).f26122a.onPreviewDestroyed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/z5VDt$kwCJn.class */
    public static class kwCJn {

        /* renamed from: a  reason: collision with root package name */
        String f26160a;
        int b = 0;

        /* renamed from: c  reason: collision with root package name */
        com.tencent.turingcam.wmqhz f26161c;
        List<String> d;
        Map<String, String> e;
        byte[] f;

        kwCJn() {
            com.tencent.turingcam.wmqhz wmqhzVar = new com.tencent.turingcam.wmqhz();
            this.f26161c = wmqhzVar;
            wmqhzVar.f26150c = new ArrayList<>();
            this.f26161c.d = new HashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/z5VDt$spXPg.class */
    public class spXPg implements CvowV {
        spXPg() {
        }

        @Override // com.tencent.turingcam.CvowV
        public void a(Message message) {
            int i = message.what;
            if (i == 3) {
                z5VDt.a(z5VDt.this, (s7Dnc.spXPg) message.obj);
            } else if (i == 4) {
                z5VDt.a(z5VDt.this);
            } else if (i == 5) {
                Object obj = message.obj;
                z5VDt.a(z5VDt.this, obj != null ? (String) obj : "");
            } else if (i != 6) {
            } else {
                z5VDt.b(z5VDt.this, (String) message.obj);
            }
        }

        @Override // com.tencent.turingcam.CvowV
        public void a(Throwable th) {
            if (z5VDt.this.n != null) {
                ((F2BEC) z5VDt.this.n).f26122a.onException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/z5VDt$wmqhz.class */
    public class wmqhz implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TuringPreviewDisplay f26163a;
        final /* synthetic */ View b;

        wmqhz(z5VDt z5vdt, TuringPreviewDisplay turingPreviewDisplay, View view) {
            this.f26163a = turingPreviewDisplay;
            this.b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f26163a.addView(this.b, -1, -1);
        }
    }

    private z5VDt() {
        this.q = false;
        this.s = 0L;
    }

    /* synthetic */ z5VDt(spXPg spxpg) {
        this();
    }

    private SWw7W a() {
        SWw7W sWw7W = new SWw7W();
        sWw7W.f26124a = 2;
        sWw7W.f26125c = y8N3A.b;
        sWw7W.b = Build.BRAND;
        sWw7W.d = Build.VERSION.RELEASE;
        sWw7W.e = "2.0.3";
        sWw7W.g = "7WCF54SWX5H87QEV";
        sWw7W.f = String.valueOf(108158);
        sWw7W.h = this.r.getContext().getPackageName();
        sWw7W.i = String.valueOf(this.r.getChannel() != 0 ? this.r.getChannel() : 108098);
        return sWw7W;
    }

    static void a(z5VDt z5vdt) {
        z5vdt.o.b = 4;
        B9LVG b9lvg = z5vdt.n;
        if (b9lvg != null) {
            ((F2BEC) b9lvg).f26122a.onFinish(-301005L, null);
        }
    }

    static void a(z5VDt z5vdt, s7Dnc.spXPg spxpg) {
        kwCJn kwcjn = z5vdt.o;
        if (kwcjn != null) {
            int i2 = kwcjn.b;
            if (i2 == 6 || i2 == 2 || i2 == 3) {
                z5vdt.s = System.currentTimeMillis();
                z5vdt.o.b = 3;
                z5vdt.l.a(z5vdt.k, 4);
                z5vdt.l.a(z5vdt.k, 4, 10000L);
                Camera camera = z5vdt.m.get();
                if (camera == null) {
                    B9LVG b9lvg = z5vdt.n;
                    if (b9lvg != null) {
                        ((F2BEC) b9lvg).f26122a.onFinishFrameCheck(-301001L, null);
                    }
                    hxUS9.b().a("process_code", -301001L);
                    return;
                }
                kwCJn kwcjn2 = z5vdt.o;
                com.tencent.turingcam.wmqhz wmqhzVar = kwcjn2.f26161c;
                Iterator<String> it = kwcjn2.d.iterator();
                while (it.hasNext()) {
                    s7Dnc a2 = FLlEM.a(it.next());
                    if (a2 != null && a2.a(spxpg, camera, wmqhzVar)) {
                        a2.a();
                        it.remove();
                    }
                }
                if (z5vdt.o.d.isEmpty()) {
                    z5vdt.l.a(z5vdt.k, 4);
                    z5vdt.o.b = 4;
                    hxUS9.b().a("process_code", 0L);
                    hxUS9.b().a("process_cost", System.currentTimeMillis() - z5vdt.s);
                    long currentTimeMillis = System.currentTimeMillis();
                    com.tencent.turingcam.B9LVG b9lvg2 = new com.tencent.turingcam.B9LVG();
                    b9lvg2.f26117c = z5vdt.o.f26160a;
                    ArrayList<com.tencent.turingcam.Bi3eT> arrayList = new ArrayList<>();
                    b9lvg2.d = arrayList;
                    arrayList.addAll(z5vdt.o.f26161c.f26150c);
                    b9lvg2.e = z5vdt.o.f;
                    b9lvg2.f = z5vdt.a();
                    com.tencent.turingcam.ShGzN shGzN = new com.tencent.turingcam.ShGzN(128);
                    b9lvg2.a(shGzN);
                    c9YSQ c9ysq = (c9YSQ) com.tencent.turingface.sdk.mfa.EQsUZ.a(104, shGzN.a());
                    c9ysq.f26250a.getClass();
                    byte[] bArr = c9ysq.f26250a.f26181a;
                    B9LVG b9lvg3 = z5vdt.n;
                    if (b9lvg3 != null) {
                        ((F2BEC) b9lvg3).f26122a.onFinishFrameCheck(0L, bArr);
                    }
                    hxUS9.b().a("upload_code", 0L);
                    hxUS9.b().a("upload_cost", System.currentTimeMillis() - currentTimeMillis);
                }
            }
        }
    }

    static void a(z5VDt z5vdt, String str) {
        z5vdt.getClass();
        hxUS9.b().a();
        long currentTimeMillis = System.currentTimeMillis();
        WeakReference<Camera> weakReference = z5vdt.m;
        Camera camera = weakReference != null ? weakReference.get() : null;
        y8N3A.SkEpO b2 = y8N3A.a().b();
        int i2 = b2.f26153a;
        if (i2 != 0) {
            long j2 = i2 - StCameraView.MEDIA_QUALITY_FUNNY;
            B9LVG b9lvg = z5vdt.n;
            if (b9lvg != null) {
                ((F2BEC) b9lvg).f26122a.onFinish(j2, null);
            }
            hxUS9.b().a("upload_code", j2);
            return;
        }
        String str2 = b2.b;
        com.tencent.turingcam.kwCJn kwcjn = new com.tencent.turingcam.kwCJn();
        kwcjn.d = "";
        kwcjn.e = new ArrayList<>();
        kwcjn.f = y8N3A.a().c();
        kwcjn.h = z5vdt.a();
        kwcjn.i = str2;
        HashMap hashMap = new HashMap();
        kwcjn.g = hashMap;
        HashMap hashMap2 = new HashMap();
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            hashMap2.put(f26155a, parameters.get(b) + t.aE + parameters.get(f26156c) + t.aE + parameters.get(d) + t.aE + parameters.get(e) + t.aE + parameters.get(f) + t.aE + parameters.get(g) + t.aE + parameters.get(h) + t.aE + parameters.get(i));
        }
        String str3 = "camera parameter:" + hashMap2;
        hashMap.putAll(hashMap2);
        if (!TextUtils.isEmpty(str)) {
            kwcjn.g.put("token", str);
        }
        com.tencent.turingcam.ShGzN shGzN = new com.tencent.turingcam.ShGzN(128);
        kwcjn.a(shGzN);
        c9YSQ c9ysq = (c9YSQ) com.tencent.turingface.sdk.mfa.EQsUZ.a(103, shGzN.a());
        c9ysq.f26250a.getClass();
        byte[] bArr = c9ysq.f26250a.f26181a;
        B9LVG b9lvg2 = z5vdt.n;
        if (b9lvg2 != null) {
            ((F2BEC) b9lvg2).f26122a.onFinish(0L, bArr);
        }
        hxUS9.b().a("upload_code", 0L);
        hxUS9.b().a("upload_cost", System.currentTimeMillis() - currentTimeMillis);
    }

    static boolean a(z5VDt z5vdt, Camera camera, SurfaceTexture surfaceTexture, SurfaceHolder surfaceHolder) {
        z5vdt.getClass();
        if (camera == null) {
            return false;
        }
        try {
            if (surfaceTexture != null) {
                camera.setPreviewTexture(surfaceTexture);
                return true;
            } else if (surfaceHolder != null) {
                camera.setPreviewDisplay(surfaceHolder);
                return true;
            } else {
                return false;
            }
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void b(com.tencent.turingcam.z5VDt r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 563
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingcam.z5VDt.b(com.tencent.turingcam.z5VDt, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(Camera camera, TuringPreviewDisplay turingPreviewDisplay) {
        com.tencent.turingcam.view.spXPg spxpg;
        this.r.isHardwareAcceleration();
        TuringFaceBuilder turingFaceBuilder = this.r;
        if (turingFaceBuilder != null && turingFaceBuilder.isHardwareAcceleration() && oqKCa.f()) {
            com.tencent.turingcam.view.ShGzN shGzN = new com.tencent.turingcam.view.ShGzN(turingPreviewDisplay.getContext(), null);
            shGzN.a(new ShGzN(camera));
            spxpg = shGzN;
        } else {
            com.tencent.turingcam.view.spXPg spxpg2 = new com.tencent.turingcam.view.spXPg(turingPreviewDisplay.getContext(), null);
            spxpg2.getHolder().addCallback(new SkEpO(camera));
            spxpg = spxpg2;
        }
        this.p = new WeakReference<>(spxpg);
        turingPreviewDisplay.post(new wmqhz(this, turingPreviewDisplay, spxpg));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Camera camera, String str) {
        if (camera != null) {
            this.m = new WeakReference<>(camera);
        }
        Message obtain = Message.obtain();
        obtain.what = 5;
        obtain.obj = str;
        this.l.a(this.k, obtain);
    }

    public void a(TuringFaceBuilder turingFaceBuilder) {
        if (this.q) {
            return;
        }
        this.r = turingFaceBuilder;
        long currentTimeMillis = System.currentTimeMillis();
        y8N3A.a().a(this.r);
        hxUS9.b().a(this.r.getContext());
        XnM3A xnM3A = new XnM3A();
        this.l = xnM3A;
        this.k = xnM3A.a(new spXPg());
        this.q = true;
        hxUS9.b().a("init_cost", System.currentTimeMillis() - currentTimeMillis);
        hxUS9.b().a("init_code", 0L);
        Log.i("turingfacecheck", "TuringFaceSDK: V2.0.3,B7,7WCF54SWX5H87QEV,youtu(debug=false,log=false,env=false)");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(B9LVG b9lvg) {
        this.n = b9lvg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        Message obtain = Message.obtain();
        obtain.what = 6;
        obtain.obj = str;
        this.l.a(this.k, obtain);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        s7Dnc.spXPg spxpg = new s7Dnc.spXPg();
        spxpg.f26142a = System.currentTimeMillis();
        spxpg.b = bArr;
        Message obtain = Message.obtain();
        obtain.obj = spxpg;
        obtain.what = 3;
        this.l.a(this.k, obtain);
    }
}
