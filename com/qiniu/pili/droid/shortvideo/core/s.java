package com.qiniu.pili.droid.shortvideo.core;

import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Handler;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import com.qiniu.pili.droid.shortvideo.PLImageView;
import com.qiniu.pili.droid.shortvideo.PLPositionTransition;
import com.qiniu.pili.droid.shortvideo.PLTextView;
import com.qiniu.pili.droid.shortvideo.PLTransition;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.b;
import com.qiniu.pili.droid.shortvideo.encode.a;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/s.class */
public class s implements Runnable {
    private static final PLVideoSaveListener x = new PLVideoSaveListener() { // from class: com.qiniu.pili.droid.shortvideo.core.s.3
        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onProgressUpdate(float f) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.v;
            eVar.c("TransitionMakerCore", "onProgressUpdate: " + f);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoCanceled() {
            com.qiniu.pili.droid.shortvideo.f.e.v.c("TransitionMakerCore", "onSaveVideoCanceled");
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoFailed(int i) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.v;
            eVar.c("TransitionMakerCore", "onSaveVideoFailed: " + i);
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
        public void onSaveVideoSuccess(String str) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.v;
            eVar.c("TransitionMakerCore", "onSaveVideoSuccess: " + str);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f27619a;
    private PLVideoEncodeSetting b;

    /* renamed from: c  reason: collision with root package name */
    private String f27620c;
    private PLVideoSaveListener d;
    private com.qiniu.pili.droid.shortvideo.gl.a.f e;
    private com.qiniu.pili.droid.shortvideo.gl.a.d f;
    private com.qiniu.pili.droid.shortvideo.gl.c.g g;
    private com.qiniu.pili.droid.shortvideo.gl.c.f h;
    private volatile Surface i;
    private com.qiniu.pili.droid.shortvideo.muxer.b j;
    private com.qiniu.pili.droid.shortvideo.encode.e k;
    private MediaFormat l;
    private volatile boolean m;
    private volatile boolean n;
    private volatile boolean o;
    private long p;
    private long q;
    private long r;
    private int s;
    private Hashtable<View, a> t = new Hashtable<>();
    private Hashtable<View, AnimatorSet> u = new Hashtable<>();
    private Handler v = new Handler();
    private a.InterfaceC0745a w = new a.InterfaceC0745a() { // from class: com.qiniu.pili.droid.shortvideo.core.s.2
        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(MediaFormat mediaFormat) {
            com.qiniu.pili.droid.shortvideo.f.e.v.c("TransitionMakerCore", "video onEncodedFormatChanged ");
            s.this.l = mediaFormat;
            s.this.h();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(Surface surface) {
            com.qiniu.pili.droid.shortvideo.f.e.v.c("TransitionMakerCore", "video onSurfaceCreated ");
            s.this.i = surface;
            new Thread(s.this).start();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            if (!s.this.n) {
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.v;
                eVar.b("TransitionMakerCore", "video frame not write  " + bufferInfo.presentationTimeUs);
                return;
            }
            s.this.j.a(byteBuffer, bufferInfo);
            com.qiniu.pili.droid.shortvideo.f.e eVar2 = com.qiniu.pili.droid.shortvideo.f.e.v;
            eVar2.b("TransitionMakerCore", "writeVideo " + bufferInfo.presentationTimeUs);
            s.this.d.onProgressUpdate((((float) bufferInfo.presentationTimeUs) * 1.0f) / ((float) s.this.r));
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void a(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.v;
            eVar.c("TransitionMakerCore", "encode started result: " + z);
            if (z) {
                return;
            }
            s.this.d.onSaveVideoFailed(6);
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0745a
        public void b(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e.v.c("TransitionMakerCore", "encode stopped");
            s.this.l = null;
            s.this.i();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/s$a.class */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        LinkedList<PLTransition> f27623a;
        Bitmap b;

        /* renamed from: c  reason: collision with root package name */
        float f27624c;
        float d;

        public a(LinkedList<PLTransition> linkedList) {
            this.f27623a = linkedList;
        }
    }

    public s(ViewGroup viewGroup, PLVideoEncodeSetting pLVideoEncodeSetting) {
        this.f27619a = viewGroup;
        this.b = pLVideoEncodeSetting;
        l.a(viewGroup.getContext().getApplicationContext());
    }

    private com.qiniu.pili.droid.shortvideo.gl.c.g a(int i, int i2) {
        com.qiniu.pili.droid.shortvideo.gl.c.g gVar = new com.qiniu.pili.droid.shortvideo.gl.c.g();
        gVar.a(i, i2);
        gVar.b();
        return gVar;
    }

    private com.qiniu.pili.droid.shortvideo.gl.c.m a(View view, a aVar) {
        com.qiniu.pili.droid.shortvideo.gl.c.m mVar = new com.qiniu.pili.droid.shortvideo.gl.c.m(aVar.b);
        mVar.a(false);
        mVar.a(view.getAlpha());
        mVar.b((int) view.getRotation());
        mVar.b(aVar.f27624c / this.f27619a.getWidth(), aVar.d / this.f27619a.getHeight());
        Iterator<PLTransition> it = aVar.f27623a.iterator();
        while (it.hasNext()) {
            mVar.a(it.next());
        }
        mVar.a(this.b.getVideoEncodingWidth(), this.b.getVideoEncodingHeight());
        mVar.b();
        return mVar;
    }

    private boolean a(String str) {
        if (str == null) {
            com.qiniu.pili.droid.shortvideo.f.e.v.e("TransitionMakerCore", "dest video path is wrong!");
            return false;
        }
        File parentFile = new File(str).getParentFile();
        if (parentFile.exists() || parentFile.mkdir()) {
            return true;
        }
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.v;
        eVar.e("TransitionMakerCore", "failed to mkdir: " + parentFile.getAbsolutePath());
        return false;
    }

    private com.qiniu.pili.droid.shortvideo.gl.c.f b(int i, int i2) {
        com.qiniu.pili.droid.shortvideo.gl.c.f fVar = new com.qiniu.pili.droid.shortvideo.gl.c.f();
        fVar.a(i, i2);
        fVar.b();
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        for (Map.Entry<View, AnimatorSet> entry : this.u.entrySet()) {
            AnimatorSet value = entry.getValue();
            value.cancel();
            value.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        synchronized (this) {
            if (this.l == null) {
                return;
            }
            com.qiniu.pili.droid.shortvideo.muxer.b bVar = new com.qiniu.pili.droid.shortvideo.muxer.b();
            this.j = bVar;
            if (bVar.a(this.f27620c, this.l, null, 0)) {
                this.n = true;
                com.qiniu.pili.droid.shortvideo.f.e.v.c("TransitionMakerCore", "start output muxer success!");
            } else {
                com.qiniu.pili.droid.shortvideo.f.e.v.e("TransitionMakerCore", "start output muxer failed!");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        synchronized (this) {
            if (this.l == null && this.n) {
                boolean a2 = this.j.a();
                if (this.m) {
                    new File(this.f27620c).delete();
                    this.d.onSaveVideoCanceled();
                } else {
                    this.d.onProgressUpdate(1.0f);
                    if (a2) {
                        this.d.onSaveVideoSuccess(this.f27620c);
                    } else {
                        this.d.onSaveVideoFailed(3);
                        QosManager.a().a(3);
                    }
                }
                this.n = false;
                this.o = false;
                com.qiniu.pili.droid.shortvideo.f.e.v.c("TransitionMakerCore", "save stopped !");
            }
        }
    }

    public void a() {
        this.v.removeCallbacksAndMessages(null);
        this.t.clear();
        for (Map.Entry<View, AnimatorSet> entry : this.u.entrySet()) {
            AnimatorSet value = entry.getValue();
            value.end();
            value.cancel();
        }
        this.u.clear();
        this.f27619a.removeAllViews();
    }

    public void a(int i) {
        this.r = i * 1000;
    }

    public void a(View view, PLTransition pLTransition) {
        if (this.t.containsKey(view)) {
            this.t.get(view).f27623a.add(pLTransition);
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(pLTransition);
        this.t.put(view, new a(linkedList));
    }

    public void a(PLImageView pLImageView) {
        this.f27619a.addView(pLImageView);
    }

    public void a(PLTextView pLTextView) {
        this.f27619a.addView(pLTextView);
    }

    public void a(String str, PLVideoSaveListener pLVideoSaveListener) {
        com.qiniu.pili.droid.shortvideo.f.e.v.c("TransitionMakerCore", "save +");
        if (u.a().a(b.a.transition_make, pLVideoSaveListener)) {
            if (this.o) {
                com.qiniu.pili.droid.shortvideo.f.e.v.e("TransitionMakerCore", "transition make: save already started");
            } else if (!a(str)) {
                com.qiniu.pili.droid.shortvideo.f.e.v.e("TransitionMakerCore", "transition make: dstVideoPath is wrong!");
            } else {
                this.o = true;
                this.f27620c = str;
                this.q = 0L;
                this.m = false;
                for (Map.Entry<View, a> entry : this.t.entrySet()) {
                    View key = entry.getKey();
                    float videoEncodingWidth = this.b.getVideoEncodingWidth() / this.f27619a.getWidth();
                    Bitmap a2 = com.qiniu.pili.droid.shortvideo.f.j.a(key);
                    Matrix matrix = new Matrix();
                    matrix.postScale(videoEncodingWidth, videoEncodingWidth);
                    entry.getValue().b = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
                    Iterator<PLTransition> it = entry.getValue().f27623a.iterator();
                    while (it.hasNext()) {
                        PLTransition next = it.next();
                        if (next instanceof PLPositionTransition) {
                            ((PLPositionTransition) next).a(this.f27619a.getWidth(), this.f27619a.getHeight());
                        }
                    }
                }
                PLVideoSaveListener pLVideoSaveListener2 = pLVideoSaveListener;
                if (pLVideoSaveListener == null) {
                    pLVideoSaveListener2 = x;
                }
                this.d = pLVideoSaveListener2;
                this.p = 1000000 / this.b.getVideoEncodingFps();
                com.qiniu.pili.droid.shortvideo.encode.e eVar = new com.qiniu.pili.droid.shortvideo.encode.e(this.b);
                this.k = eVar;
                eVar.a(this.w);
                this.k.a();
                com.qiniu.pili.droid.shortvideo.f.e.v.c("TransitionMakerCore", "save -");
            }
        }
    }

    public void b() {
        this.v.removeCallbacksAndMessages(null);
        for (Map.Entry<View, AnimatorSet> entry : this.u.entrySet()) {
            AnimatorSet value = entry.getValue();
            value.end();
            value.cancel();
        }
    }

    public void b(int i) {
        this.f27619a.setBackgroundColor(i);
        this.s = i;
    }

    public void c() {
        final long j = this.r / 1000;
        Runnable runnable = new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.core.s.1
            @Override // java.lang.Runnable
            public void run() {
                s.this.g();
                s.this.v.postDelayed(this, j);
            }
        };
        if (!this.u.isEmpty()) {
            g();
            this.v.removeCallbacksAndMessages(null);
            this.v.postDelayed(runnable, j);
        } else if (!this.t.isEmpty()) {
            for (Map.Entry<View, a> entry : this.t.entrySet()) {
                View key = entry.getKey();
                a value = entry.getValue();
                value.f27624c = key.getX();
                value.d = key.getY();
                LinkedList<PLTransition> linkedList = value.f27623a;
                ArrayList arrayList = new ArrayList();
                AnimatorSet animatorSet = new AnimatorSet();
                Iterator<PLTransition> it = linkedList.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().a(key));
                }
                animatorSet.playTogether(arrayList);
                animatorSet.start();
                this.u.put(key, animatorSet);
            }
            this.v.postDelayed(runnable, j);
        }
    }

    public void d() {
        com.qiniu.pili.droid.shortvideo.f.e.v.c("TransitionMakerCore", "cancel save");
        this.m = true;
    }

    public void e() {
        this.v.removeCallbacksAndMessages(null);
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operation_transition_make", 1);
            jSONObject.put("data_type", QosManager.a.config);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        com.qiniu.pili.droid.shortvideo.gl.a.d dVar = new com.qiniu.pili.droid.shortvideo.gl.a.d(null, 1);
        this.f = dVar;
        com.qiniu.pili.droid.shortvideo.gl.a.f fVar = new com.qiniu.pili.droid.shortvideo.gl.a.f(dVar, this.i, false);
        this.e = fVar;
        fVar.b();
        this.g = a(this.b.getVideoEncodingWidth(), this.b.getVideoEncodingHeight());
        this.h = b(this.b.getVideoEncodingWidth(), this.b.getVideoEncodingHeight());
        int a2 = com.qiniu.pili.droid.shortvideo.f.d.a((ByteBuffer) null, this.b.getVideoEncodingWidth(), this.b.getVideoEncodingHeight(), 6408);
        int size = this.t.size();
        com.qiniu.pili.droid.shortvideo.gl.c.m[] mVarArr = new com.qiniu.pili.droid.shortvideo.gl.c.m[size];
        Iterator<Map.Entry<View, a>> it = this.t.entrySet().iterator();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            i = a2;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<View, a> next = it.next();
            mVarArr[i4] = a(next.getKey(), next.getValue());
            i3 = i4 + 1;
        }
        while (true) {
            i2 = 0;
            if (this.q > this.r) {
                break;
            }
            i2 = 0;
            if (this.m) {
                break;
            }
            GLES20.glClear(16384);
            i = this.h.a(i, Color.red(this.s) / 255.0f, Color.green(this.s) / 255.0f, Color.blue(this.s) / 255.0f);
            long j = this.q * 1000;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < size) {
                    i = mVarArr[i6].a(i, j);
                    i5 = i6 + 1;
                }
            }
            this.g.b(i);
            this.e.a(j);
            this.e.c();
            this.k.a(j);
            this.q += this.p;
        }
        while (i2 < size) {
            mVarArr[i2].f();
            i2++;
        }
        this.g.f();
        this.h.f();
        this.e.d();
        this.f.a();
        this.k.c();
    }
}
