package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.qiniu.pili.droid.shortvideo.PLBuiltinFilter;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLEffectPlugin;
import com.qiniu.pili.droid.shortvideo.PLGifWatermarkSetting;
import com.qiniu.pili.droid.shortvideo.PLImageView;
import com.qiniu.pili.droid.shortvideo.PLMixAudioFile;
import com.qiniu.pili.droid.shortvideo.PLPaintView;
import com.qiniu.pili.droid.shortvideo.PLSpeedTimeRange;
import com.qiniu.pili.droid.shortvideo.PLTextView;
import com.qiniu.pili.droid.shortvideo.PLVideoEditSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import com.qiniu.pili.droid.shortvideo.PLVideoPlayerListener;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.PLWatermarkSetting;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.b;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/m.class */
public class m implements MediaPlayer.OnCompletionListener, PLVideoFilterListener {
    private List<a> A;
    private int B;
    private int C;
    private GLSurfaceView D;
    private boolean E;
    private int F;
    private int G;
    private int H;
    private String I;
    private String J;
    private String K;
    private boolean L;
    private long M;
    private PLVideoEncodeSetting N;
    private PLWatermarkSetting O;
    private PLWatermarkSetting P;
    private com.qiniu.pili.droid.shortvideo.e.c Q;

    /* renamed from: a  reason: collision with root package name */
    protected double f13887a;
    List<PLSpeedTimeRange> b;

    /* renamed from: c  reason: collision with root package name */
    private Context f13888c;
    private int d;
    private int e;
    private com.qiniu.pili.droid.shortvideo.e.b f;
    private com.qiniu.pili.droid.shortvideo.e.a g;
    private com.qiniu.pili.droid.shortvideo.process.a.d h;
    private Object i;
    private PLVideoFilterListener j;
    private PLVideoSaveListener k;
    private PLVideoPlayerListener l;
    private PLEffectPlugin m;
    private PLVideoEditSetting n;
    private com.qiniu.pili.droid.shortvideo.transcoder.audio.a o;
    private volatile boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private float t;
    private float u;
    private float v;
    private q w;
    private long x;
    private long y;
    private ViewGroup z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/m$a.class */
    public class a {
        private long b;

        /* renamed from: c  reason: collision with root package name */
        private long f13895c;
        private View d;

        public a(View view, long j, long j2) {
            this.b = j;
            this.f13895c = j2;
            this.d = view;
        }

        public View a() {
            return this.d;
        }

        public boolean a(long j) {
            if (this.f13895c >= m.this.M) {
                return j >= this.b;
            }
            long j2 = this.b;
            return j >= j2 && j <= j2 + this.f13895c;
        }

        public void b(long j) {
            this.b = j;
        }

        public void c(long j) {
            this.f13895c = j;
        }
    }

    public m(GLSurfaceView gLSurfaceView) {
        this.n = new PLVideoEditSetting();
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = true;
        this.t = 1.0f;
        this.u = 1.0f;
        this.v = 1.0f;
        this.A = new LinkedList();
        this.f13887a = 1.0d;
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "init without PLVideoEditSetting +");
        Context applicationContext = gLSurfaceView.getContext().getApplicationContext();
        this.f13888c = applicationContext;
        l.a(applicationContext);
        this.D = gLSurfaceView;
        this.f = new com.qiniu.pili.droid.shortvideo.e.b(gLSurfaceView);
        this.h = new com.qiniu.pili.droid.shortvideo.process.a.d(this.f13888c);
        this.f.a((PLVideoFilterListener) this);
        this.f.a((MediaPlayer.OnCompletionListener) this);
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "init without PLVideoEditSetting -");
    }

    public m(GLSurfaceView gLSurfaceView, PLVideoEditSetting pLVideoEditSetting) {
        this.n = new PLVideoEditSetting();
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = true;
        this.t = 1.0f;
        this.u = 1.0f;
        this.v = 1.0f;
        this.A = new LinkedList();
        this.f13887a = 1.0d;
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "init +");
        Context applicationContext = gLSurfaceView.getContext().getApplicationContext();
        this.f13888c = applicationContext;
        l.a(applicationContext);
        this.D = gLSurfaceView;
        this.n = pLVideoEditSetting;
        com.qiniu.pili.droid.shortvideo.e.b bVar = new com.qiniu.pili.droid.shortvideo.e.b(gLSurfaceView);
        this.f = bVar;
        bVar.a(this.n.getSourceFilepath());
        this.f.a((PLVideoFilterListener) this);
        this.f.a((MediaPlayer.OnCompletionListener) this);
        com.qiniu.pili.droid.shortvideo.process.a.d dVar = new com.qiniu.pili.droid.shortvideo.process.a.d(this.f13888c);
        this.h = dVar;
        dVar.a(this.n.isGifPreviewEnabled());
        String destFilepath = this.n.getDestFilepath();
        if (destFilepath == null) {
            File filesDir = this.f13888c.getFilesDir();
            this.n.setDestFilepath(new File(filesDir, "pl-edited-" + System.currentTimeMillis() + ".mp4").getAbsolutePath());
        } else {
            this.n.setDestFilepath(l.a(this.f13888c, destFilepath));
        }
        this.M = com.qiniu.pili.droid.shortvideo.f.g.a((Object) this.n.getSourceFilepath());
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "init -");
    }

    private void a(Object obj) {
        if (this.o == null) {
            this.o = new com.qiniu.pili.droid.shortvideo.transcoder.audio.a();
        }
        if (obj instanceof String) {
            this.o.a((String) obj);
        } else {
            this.o.a((AssetFileDescriptor) obj);
        }
        this.o.a(this.s);
        if (this.g == null) {
            this.g = new com.qiniu.pili.droid.shortvideo.e.a();
        }
        if (this.o.d()) {
            this.g.a(this.o.c());
        } else {
            this.g.a(this.o.a());
        }
        this.g.a(this.s);
        this.g.a(this.u);
        this.o.a(this.g.a());
        if (this.q) {
            j();
            this.f.b(0);
        }
        a(this.t, this.u);
    }

    private void b(View view) {
        b(view, 0L, this.M);
    }

    private void b(View view, long j, long j2) {
        if (view == null) {
            com.qiniu.pili.droid.shortvideo.f.e.e.d("ShortVideoEditorCore", "addView failed : view is null");
        } else if (!(this.D.getParent() instanceof ViewGroup)) {
            throw new IllegalStateException("GLSurfaceView does not have a parent, it cannot be root view!");
        } else {
            if (this.z == null) {
                this.z = (ViewGroup) this.D.getParent();
            }
            a aVar = new a(view, j, j2);
            if (view instanceof PLPaintView) {
                this.z.addView(view);
                this.A.add(aVar);
                return;
            }
            ViewGroup viewGroup = this.z;
            viewGroup.addView(view, viewGroup.getChildCount() - this.d);
            List<a> list = this.A;
            list.add(list.size() - this.d, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PLVideoSaveListener pLVideoSaveListener) {
        if (this.E) {
            this.f.e();
        }
        this.w.a(this.f13887a);
        List<PLSpeedTimeRange> list = this.b;
        if (list != null) {
            this.w.a(list);
        }
        if (this.h.e() == null) {
            this.w.a(pLVideoSaveListener);
            return;
        }
        this.w.a(this.F, this.G, com.qiniu.pili.droid.shortvideo.f.g.e(this.h.e()), pLVideoSaveListener);
    }

    private a c(View view) {
        for (a aVar : this.A) {
            if (aVar.a() == view) {
                return aVar;
            }
        }
        return null;
    }

    private void c(PLMixAudioFile pLMixAudioFile) {
        this.Q.c(pLMixAudioFile);
        this.f.a(pLMixAudioFile.getVolume());
    }

    private void d(View view) {
        if (this.z == null || view == null) {
            com.qiniu.pili.droid.shortvideo.f.e.e.d("ShortVideoEditorCore", "group or view is null, cannot remove.");
            return;
        }
        a c2 = c(view);
        if (c2 == null) {
            com.qiniu.pili.droid.shortvideo.f.e.e.d("ShortVideoEditorCore", "removeView failed : view is not find , it must be added first!");
            return;
        }
        this.A.remove(c2);
        this.z.removeView(view);
    }

    private void j() {
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "startAudioPlayback +");
        if (this.o == null) {
            return;
        }
        this.g.b();
        com.qiniu.pili.droid.shortvideo.e.c cVar = this.Q;
        if (cVar != null) {
            cVar.a(b());
        }
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "startAudioPlayback -");
    }

    private void k() {
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "resumeAudioPlayback +");
        com.qiniu.pili.droid.shortvideo.e.a aVar = this.g;
        if (aVar != null) {
            aVar.f();
        }
        com.qiniu.pili.droid.shortvideo.e.c cVar = this.Q;
        if (cVar != null) {
            cVar.b(b());
        }
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "resumeAudioPlayback -");
    }

    private void l() {
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "pauseAudioPlayback +");
        com.qiniu.pili.droid.shortvideo.e.a aVar = this.g;
        if (aVar != null) {
            aVar.e();
        }
        com.qiniu.pili.droid.shortvideo.e.c cVar = this.Q;
        if (cVar != null) {
            cVar.d();
        }
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "pauseAudioPlayback -");
    }

    private void m() {
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "stopAudioPlayback +");
        com.qiniu.pili.droid.shortvideo.e.a aVar = this.g;
        if (aVar != null) {
            aVar.d();
        }
        com.qiniu.pili.droid.shortvideo.e.c cVar = this.Q;
        if (cVar != null) {
            cVar.e();
        }
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "stopAudioPlayback -");
    }

    private void n() {
        Iterator<a> it = this.A.iterator();
        while (it.hasNext()) {
            View a2 = it.next().a();
            if ((a2 instanceof PLTextView) && ((PLTextView) a2).getText().toString().isEmpty()) {
                it.remove();
                this.z.removeView(a2);
            }
        }
    }

    private boolean o() {
        com.qiniu.pili.droid.shortvideo.e.c cVar = this.Q;
        return cVar != null && cVar.b() >= 2;
    }

    private void p() {
        for (final a aVar : this.A) {
            aVar.a().post(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.core.m.4
                @Override // java.lang.Runnable
                public void run() {
                    aVar.a().setVisibility(aVar.a((long) m.this.f.i()) ? 0 : 4);
                }
            });
        }
    }

    public Bitmap a(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        view.draw(canvas);
        return createBitmap;
    }

    public void a() {
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "resumePlayback +");
        this.q = true;
        this.f.c();
        k();
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "resumePlayback -");
    }

    public void a(double d) {
        a(d, false);
    }

    public void a(double d, boolean z) {
        if (u.a().a(b.a.edit_speed)) {
            if (!com.qiniu.pili.droid.shortvideo.f.j.a(d)) {
                com.qiniu.pili.droid.shortvideo.f.e.e.d("ShortVideoEditorCore", "only support multiple of 2 !!!");
                return;
            }
            this.f13887a = d;
            if (this.b != null) {
                this.b = null;
                com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "reset speedTimeRanges to null! ");
            }
            if (z) {
                this.f.a(d);
            }
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.e;
            eVar.c("ShortVideoEditorCore", "set speed to: " + d);
        }
    }

    public void a(float f, float f2) {
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.e;
        eVar.c("ShortVideoEditorCore", "setAudioMixVolume: " + f + ", " + f2);
        this.t = f;
        this.u = f2;
        com.qiniu.pili.droid.shortvideo.transcoder.audio.a aVar = this.o;
        if (aVar != null) {
            aVar.a(new com.qiniu.pili.droid.shortvideo.transcoder.audio.c(f, f2));
        } else {
            this.r = f == 0.0f;
        }
        com.qiniu.pili.droid.shortvideo.e.a aVar2 = this.g;
        if (aVar2 != null) {
            aVar2.a(f2);
        }
        this.f.a(f);
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "setAudioMixVolume -");
    }

    public void a(int i) {
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "seekTo +");
        this.f.b(i);
        if (this.g != null) {
            com.qiniu.pili.droid.shortvideo.transcoder.audio.a aVar = this.o;
            if (aVar == null || aVar.e() == null) {
                this.g.a(i);
            } else {
                this.g.a(i + this.o.e().a());
            }
        }
        com.qiniu.pili.droid.shortvideo.e.c cVar = this.Q;
        if (cVar != null) {
            cVar.a(i);
        }
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "seekTo -");
    }

    public void a(long j, long j2) {
        if (j < 0 || j2 <= j) {
            com.qiniu.pili.droid.shortvideo.f.e.e.e("ShortVideoEditorCore", "beginMs must not smaller than 0, endMs must bigger than 0 and beginMs");
            return;
        }
        this.x = j;
        this.y = j2;
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.e;
        eVar.c("ShortVideoEditorCore", "set range to: " + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2 + " duration: " + (j2 - j));
    }

    public void a(AssetFileDescriptor assetFileDescriptor) {
        if (u.a().a(b.a.edit_audio_mix)) {
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "setAudioMixAsset +");
            if (assetFileDescriptor == null) {
                g();
                return;
            }
            a((Object) assetFileDescriptor);
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "setAudioMixAsset -");
        }
    }

    public void a(View view, long j, long j2) {
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "setViewTimeline +");
        if (view == null) {
            com.qiniu.pili.droid.shortvideo.f.e.e.d("ShortVideoEditorCore", "setViewTimeline failed : view is null");
            return;
        }
        a c2 = c(view);
        if (c2 != null) {
            c2.b(j);
            c2.c(j2);
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.h;
            eVar.c("ShortVideoEditorCore", "set view start time : " + j + " duration : " + j2);
        } else {
            com.qiniu.pili.droid.shortvideo.f.e.e.d("ShortVideoEditorCore", "setViewTimeline failed : view is not find , it must be added first!");
        }
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "setViewTimeline -");
    }

    public void a(PLDisplayMode pLDisplayMode) {
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.e;
        eVar.c("ShortVideoEditorCore", "setDisplayMode :" + pLDisplayMode);
        this.f.a(pLDisplayMode);
    }

    public void a(PLEffectPlugin pLEffectPlugin) {
        this.m = pLEffectPlugin;
    }

    public void a(PLGifWatermarkSetting pLGifWatermarkSetting) {
        if (u.a().a(b.a.edit_image)) {
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "addGifWatermark +");
            this.h.a(pLGifWatermarkSetting);
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "addGifWatermark -");
        }
    }

    public void a(PLImageView pLImageView) {
        if (u.a().a(b.a.edit_image)) {
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "addImageView +");
            b((View) pLImageView);
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "addImageView -");
        }
    }

    public void a(PLMixAudioFile pLMixAudioFile) {
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "removeMixAudioFile +");
        com.qiniu.pili.droid.shortvideo.e.c cVar = this.Q;
        if (cVar != null) {
            cVar.b(pLMixAudioFile);
        }
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "removeMixAudioFile -");
    }

    public void a(PLPaintView pLPaintView) {
        if (u.a().a(b.a.edit_paint)) {
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "addPaintView +");
            b((View) pLPaintView);
            this.d++;
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "addPaintView -");
        }
    }

    public void a(PLTextView pLTextView) {
        if (u.a().a(b.a.edit_text)) {
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "addTextView +");
            b((View) pLTextView);
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "addTextView -");
        }
    }

    public void a(PLVideoEditSetting pLVideoEditSetting) {
        if (this.n != null) {
            this.f.b(pLVideoEditSetting.getSourceFilepath());
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "reset PLVideoEditSetting");
        }
        this.n = pLVideoEditSetting;
        this.h.a(pLVideoEditSetting.isGifPreviewEnabled());
        this.f.a(this.n.getSourceFilepath());
        String destFilepath = this.n.getDestFilepath();
        if (destFilepath == null) {
            File filesDir = this.f13888c.getFilesDir();
            this.n.setDestFilepath(new File(filesDir, "pl-edited-" + System.currentTimeMillis() + ".mp4").getAbsolutePath());
        } else {
            this.n.setDestFilepath(l.a(this.f13888c, destFilepath));
        }
        this.M = com.qiniu.pili.droid.shortvideo.f.g.a((Object) this.n.getSourceFilepath());
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "set PLVideoEditSetting success");
        if (this.q) {
            this.f.a();
            j();
        }
    }

    public void a(PLVideoEncodeSetting pLVideoEncodeSetting) {
        this.N = pLVideoEncodeSetting;
    }

    public void a(PLVideoFilterListener pLVideoFilterListener, boolean z) {
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "startPlayback +");
        PLVideoEditSetting pLVideoEditSetting = this.n;
        if (pLVideoEditSetting == null) {
            throw new IllegalStateException("not set PLVideoEditSetting !");
        }
        if (pLVideoEditSetting.getSourceFilepath() == null) {
            throw new IllegalStateException("not set source filepath !");
        }
        this.q = true;
        this.j = pLVideoFilterListener;
        this.f.a(z);
        this.f.a();
        j();
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "startPlayback -");
    }

    public void a(PLVideoPlayerListener pLVideoPlayerListener) {
        this.l = pLVideoPlayerListener;
    }

    public void a(PLVideoSaveListener pLVideoSaveListener) {
        this.k = pLVideoSaveListener;
    }

    public void a(PLWatermarkSetting pLWatermarkSetting) {
        if (u.a().a(b.a.edit_watermark)) {
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "setWatermark +");
            this.h.a(pLWatermarkSetting);
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "setWatermark -");
        }
    }

    public void a(String str) {
        if (u.a().a(b.a.edit_audio_mix)) {
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "setAudioMixFile +");
            if (str == null || str.isEmpty()) {
                g();
                return;
            }
            a((Object) str);
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "setAudioMixFile -");
        }
    }

    public void a(String str, String str2) {
        if (u.a().a(b.a.edit_mv)) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.e;
            eVar.c("ShortVideoEditorCore", "setMVEffect mv file: " + str + ", mask file: " + str2);
            this.I = str;
            this.J = str2;
            this.F = 0;
            this.G = 0;
            this.H = 0;
            if (str != null) {
                this.F = com.qiniu.pili.droid.shortvideo.f.g.b(str);
                this.G = com.qiniu.pili.droid.shortvideo.f.g.c(str);
                this.H = com.qiniu.pili.droid.shortvideo.f.g.d(str);
            }
            this.h.a(str, str2, this.F, this.G);
            this.f.a(this.F, this.G);
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "setMVEffect -");
        }
    }

    public void a(String str, boolean z) {
        if (u.a().a(b.a.edit_filter)) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.e;
            eVar.c("ShortVideoEditorCore", "setFilter: " + str);
            this.K = str;
            this.L = z;
            this.h.a(str, z);
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "setFilter -");
        }
    }

    public void a(List<PLSpeedTimeRange> list) {
        if (u.a().a(b.a.edit_speed)) {
            this.b = list;
            this.f13887a = 1.0d;
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "setSpeedTimeRanges : reset mSpeed to 1.0 ");
        }
    }

    public void a(boolean z) {
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.e;
        eVar.c("ShortVideoEditorCore", "setPlaybackLoop: " + z);
        this.f.b(z);
    }

    public int b() {
        com.qiniu.pili.droid.shortvideo.f.e.e.b("ShortVideoEditorCore", "getCurrentPosition");
        return this.f.i();
    }

    public void b(int i) {
        if (u.a().a(b.a.edit_rotate)) {
            if (!com.qiniu.pili.droid.shortvideo.f.j.a(i)) {
                com.qiniu.pili.droid.shortvideo.f.e.e.e("ShortVideoEditorCore", "rotate must be 0, (-)90, (-)180, (-)270");
            } else if (this.e == i) {
                com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "already in target rotation !");
            } else {
                this.e = i;
                this.f.a(i);
                int i2 = this.F;
                if (i2 != 0) {
                    this.h.a(this.I, this.J, i2, this.G);
                    this.f.a(this.F, this.G);
                }
                String str = this.K;
                if (str != null) {
                    this.h.a(str, this.L);
                }
            }
        }
    }

    public void b(long j, long j2) {
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.e;
        eVar.c("ShortVideoEditorCore", "setAudioMixFileRange: " + j + ", " + j2);
        if (this.o == null || this.g == null) {
            return;
        }
        com.qiniu.pili.droid.shortvideo.transcoder.audio.d dVar = new com.qiniu.pili.droid.shortvideo.transcoder.audio.d(j, j2);
        this.o.a(dVar);
        this.g.a(dVar);
        if (this.q) {
            this.f.b(0);
            this.g.a(j);
        }
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "setAudioMixFileRange -");
    }

    public void b(PLGifWatermarkSetting pLGifWatermarkSetting) {
        if (u.a().a(b.a.edit_image)) {
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "removeGifWatermark +");
            this.h.b(pLGifWatermarkSetting);
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "removeGifWatermark -");
        }
    }

    public void b(PLImageView pLImageView) {
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "removeImageView +");
        d(pLImageView);
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "removeImageView -");
    }

    public void b(PLMixAudioFile pLMixAudioFile) {
        if (u.a().a(b.a.edit_multi_audio_mix)) {
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "addMixAudioFile +");
            if (this.Q == null) {
                this.Q = new com.qiniu.pili.droid.shortvideo.e.c();
            }
            if (this.n.getSourceFilepath().compareTo(pLMixAudioFile.getFilepath()) == 0) {
                c(pLMixAudioFile);
            } else {
                if (this.Q.a() == null) {
                    try {
                        c(new PLMixAudioFile(this.n.getSourceFilepath()));
                        com.qiniu.pili.droid.shortvideo.f.e.e.d("ShortVideoEditorCore", "no main audio file yet, create a default main audio file");
                    } catch (IOException e) {
                        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.e;
                        eVar.e("ShortVideoEditorCore", "create main audio file failed : " + e.getMessage());
                        return;
                    }
                }
                this.Q.a(pLMixAudioFile);
            }
            com.qiniu.pili.droid.shortvideo.f.e eVar2 = com.qiniu.pili.droid.shortvideo.f.e.e;
            eVar2.c("ShortVideoEditorCore", "add mix audio file : the file path is " + pLMixAudioFile.getFilepath());
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "addMixAudioFile -");
        }
    }

    public void b(PLPaintView pLPaintView) {
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "removePaintView +");
        d(pLPaintView);
        this.d--;
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "removePaintView -");
    }

    public void b(PLTextView pLTextView) {
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "removeTextView +");
        d(pLTextView);
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "removeTextView -");
    }

    public void b(final PLVideoFilterListener pLVideoFilterListener, boolean z) {
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "save +");
            if (this.p) {
                return;
            }
            if (!u.a().b()) {
                com.qiniu.pili.droid.shortvideo.f.e.b.d("unauthorized !");
                QosManager.a().a(8);
                if (this.k != null) {
                    this.k.onSaveVideoFailed(8);
                }
                return;
            }
            this.p = true;
            if (!this.h.b() && this.o == null && pLVideoFilterListener == null && this.A.isEmpty() && !this.r && this.f13887a == 1.0d && !o() && this.b == null && this.e == 0) {
                com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "no filter, mv, watermark, speed, mixed audio selected, text effect, rotation, and no external listener, return the original file.");
                if (this.k != null) {
                    this.k.onSaveVideoSuccess(this.n.getSourceFilepath());
                }
                this.p = false;
                return;
            }
            q qVar = new q(this.f13888c, this.n.getSourceFilepath(), this.n.getDestFilepath());
            this.w = qVar;
            qVar.a(this.N);
            this.w.a(this.o);
            this.w.a(this.r);
            this.w.a(this.e);
            this.w.a(this.i);
            if (o()) {
                this.w.b(this.Q.c());
            }
            if (this.y > 0) {
                this.w.a(this.x * 1000, this.y * 1000);
            }
            n();
            if (this.h.b() || pLVideoFilterListener != null || !this.A.isEmpty()) {
                final com.qiniu.pili.droid.shortvideo.process.a.d dVar = new com.qiniu.pili.droid.shortvideo.process.a.d(this.f13888c);
                dVar.a(this.h.d(), this.h.c());
                dVar.a(this.h.e(), this.h.f(), this.F, this.G);
                dVar.a(this.h.g());
                dVar.a(this.h.h());
                PLVideoFilterListener pLVideoFilterListener2 = new PLVideoFilterListener() { // from class: com.qiniu.pili.droid.shortvideo.core.m.1
                    private com.qiniu.pili.droid.shortvideo.gl.c.d[] d;

                    @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
                    public int onDrawFrame(int i, int i2, int i3, long j, float[] fArr) {
                        int i4;
                        int onSaveFrame;
                        synchronized (com.qiniu.pili.droid.shortvideo.f.d.f13982a) {
                            if (m.this.m != null && (onSaveFrame = m.this.m.onSaveFrame(i, i2, i3, j, fArr)) > 0) {
                                i = onSaveFrame;
                            }
                            int i5 = i;
                            if (pLVideoFilterListener != null) {
                                int onDrawFrame = pLVideoFilterListener.onDrawFrame(i, i2, i3, j, fArr);
                                i5 = i;
                                if (onDrawFrame > 0) {
                                    i5 = onDrawFrame;
                                }
                            }
                            if (!dVar.i()) {
                                dVar.a(i2, i3);
                            }
                            dVar.b(m.this.O);
                            int a2 = dVar.a(i5, j / 1000, true);
                            i4 = a2;
                            if (!m.this.A.isEmpty()) {
                                if (this.d == null) {
                                    int g = m.this.f.g();
                                    int h = m.this.f.h();
                                    int i6 = m.this.B;
                                    int i7 = m.this.C;
                                    this.d = new com.qiniu.pili.droid.shortvideo.gl.c.d[m.this.A.size()];
                                    int i8 = 0;
                                    while (true) {
                                        int i9 = i8;
                                        if (i9 >= this.d.length) {
                                            break;
                                        }
                                        View a3 = ((a) m.this.A.get(i9)).a();
                                        float x = a3.getX();
                                        float f = g;
                                        float y = a3.getY();
                                        float f2 = h;
                                        com.qiniu.pili.droid.shortvideo.gl.c.d dVar2 = new com.qiniu.pili.droid.shortvideo.gl.c.d(m.this.a(a3));
                                        dVar2.a(false);
                                        dVar2.a(a3.getAlpha());
                                        dVar2.b((int) a3.getRotation());
                                        float scaleX = ((1.0f - a3.getScaleX()) * a3.getWidth()) / 2.0f;
                                        float f3 = i6 - (g * 2);
                                        float f4 = ((x - f) + scaleX) / f3;
                                        float scaleY = ((1.0f - a3.getScaleY()) * a3.getHeight()) / 2.0f;
                                        float f5 = i7 - (h * 2);
                                        dVar2.b(f4, ((y - f2) + scaleY) / f5);
                                        dVar2.a((a3.getScaleX() * a3.getWidth()) / f3, (a3.getScaleY() * a3.getHeight()) / f5);
                                        dVar2.a(m.this.F != 0 ? m.this.F : i2, m.this.G != 0 ? m.this.G : i3);
                                        dVar2.b();
                                        this.d[i9] = dVar2;
                                        i8 = i9 + 1;
                                    }
                                }
                                int i10 = 0;
                                while (true) {
                                    i4 = a2;
                                    if (i10 >= this.d.length) {
                                        break;
                                    }
                                    int i11 = a2;
                                    if (((a) m.this.A.get(i10)).a(com.qiniu.pili.droid.shortvideo.f.j.b(j))) {
                                        i11 = this.d[i10].a(a2);
                                    }
                                    i10++;
                                    a2 = i11;
                                }
                            }
                            GLES20.glFinish();
                        }
                        return i4;
                    }

                    @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
                    public void onSurfaceChanged(int i, int i2) {
                        if (m.this.m != null) {
                            m.this.m.onSurfaceChanged(i, i2);
                        }
                        PLVideoFilterListener pLVideoFilterListener3 = pLVideoFilterListener;
                        if (pLVideoFilterListener3 != null) {
                            pLVideoFilterListener3.onSurfaceChanged(i, i2);
                        }
                    }

                    @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
                    public void onSurfaceCreated() {
                        if (m.this.m != null) {
                            m.this.m.onSurfaceCreated();
                        }
                        PLVideoFilterListener pLVideoFilterListener3 = pLVideoFilterListener;
                        if (pLVideoFilterListener3 != null) {
                            pLVideoFilterListener3.onSurfaceCreated();
                        }
                    }

                    @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
                    public void onSurfaceDestroy() {
                        if (m.this.m != null) {
                            m.this.m.onSurfaceDestroy();
                        }
                        dVar.j();
                        if (this.d != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                com.qiniu.pili.droid.shortvideo.gl.c.d[] dVarArr = this.d;
                                if (i2 >= dVarArr.length) {
                                    break;
                                }
                                dVarArr[i2].f();
                                i = i2 + 1;
                            }
                            this.d = null;
                        }
                        PLVideoFilterListener pLVideoFilterListener3 = pLVideoFilterListener;
                        if (pLVideoFilterListener3 != null) {
                            pLVideoFilterListener3.onSurfaceDestroy();
                        }
                    }
                };
                if (this.h.e() != null) {
                    this.w.a(this.F, this.G, this.H, pLVideoFilterListener2, z);
                } else {
                    this.w.a(pLVideoFilterListener2, z);
                }
            }
            b(new PLVideoSaveListener() { // from class: com.qiniu.pili.droid.shortvideo.core.m.2
                @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
                public void onProgressUpdate(float f) {
                    if (m.this.k != null) {
                        m.this.k.onProgressUpdate(f);
                    }
                }

                @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
                public void onSaveVideoCanceled() {
                    com.qiniu.pili.droid.shortvideo.f.e.n.c("ShortVideoEditorCore", "save video canceled");
                    m.this.p = false;
                    m.this.E = false;
                    if (m.this.k != null) {
                        m.this.k.onSaveVideoCanceled();
                    }
                }

                @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
                public void onSaveVideoFailed(int i) {
                    m.this.p = false;
                    if (i == 16 && m.this.h.e() == null && !m.this.E) {
                        com.qiniu.pili.droid.shortvideo.f.e.e.d("ShortVideoEditorCore", "not support multiple media codec, stop video player and transcode again!");
                        m.this.E = true;
                        m.this.b(this);
                        return;
                    }
                    if (m.this.k != null) {
                        m.this.k.onSaveVideoFailed(i);
                    }
                    m.this.E = false;
                }

                @Override // com.qiniu.pili.droid.shortvideo.PLVideoSaveListener
                public void onSaveVideoSuccess(String str) {
                    m.this.p = false;
                    m.this.E = false;
                    if (m.this.k != null) {
                        m.this.k.onSaveVideoSuccess(str);
                    }
                }
            });
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "save -");
        }
    }

    public void b(PLWatermarkSetting pLWatermarkSetting) {
        if (u.a().a(b.a.edit_watermark)) {
            this.O = pLWatermarkSetting;
        }
    }

    public void b(boolean z) {
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "setAudioMixLooping");
        this.s = z;
        com.qiniu.pili.droid.shortvideo.transcoder.audio.a aVar = this.o;
        if (aVar != null) {
            aVar.a(z);
        }
        com.qiniu.pili.droid.shortvideo.e.a aVar2 = this.g;
        if (aVar2 != null) {
            aVar2.a(this.s);
        }
    }

    public void c() {
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "pausePlayback +");
        this.q = false;
        this.f.b();
        this.h.b(true);
        l();
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "pausePlayback -");
    }

    public void c(PLGifWatermarkSetting pLGifWatermarkSetting) {
        if (u.a().a(b.a.edit_image)) {
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "updateGifWatermark +");
            this.h.c(pLGifWatermarkSetting);
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "updateGifWatermark -");
        }
    }

    public void c(PLWatermarkSetting pLWatermarkSetting) {
        if (u.a().a(b.a.edit_watermark)) {
            this.P = pLWatermarkSetting;
        }
    }

    public void c(boolean z) {
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.e;
        eVar.c("ShortVideoEditorCore", "muteOriginAudio + isMute: " + z);
        if (z && this.t == 0.0f) {
            com.qiniu.pili.droid.shortvideo.f.e.h.d("ShortVideoEditorCore", "origin audio has already muted!");
            return;
        }
        if (z) {
            this.v = this.t;
            a(0.0f, this.u);
        } else {
            a(this.v, this.u);
        }
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "muteOriginAudio -");
    }

    public void d() {
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "stopPlayback +");
        this.q = false;
        this.f.f();
        this.j = null;
        m();
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "stopPlayback -");
    }

    public PLBuiltinFilter[] e() {
        return this.h.a();
    }

    public int f() {
        com.qiniu.pili.droid.shortvideo.e.a aVar = this.g;
        if (aVar != null) {
            return aVar.a();
        }
        return 0;
    }

    public void g() {
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "clearAudioMix +");
        this.o = null;
        com.qiniu.pili.droid.shortvideo.e.a aVar = this.g;
        if (aVar != null) {
            aVar.a(new com.qiniu.pili.droid.shortvideo.transcoder.audio.d(0L, 0L));
        }
        m();
        com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "clearAudioMix -");
    }

    public void h() {
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "cancelSave +");
            if (this.E) {
                this.f.d();
            }
            if (this.w != null) {
                this.w.a();
            }
            com.qiniu.pili.droid.shortvideo.f.e.e.c("ShortVideoEditorCore", "cancelSave -");
        }
    }

    public JSONObject i() {
        Set<PLGifWatermarkSetting> h = this.h.h();
        int size = h != null ? h.size() + 0 : 0;
        int i = this.h.g() == null ? 0 : 1;
        int i2 = this.K == null ? 0 : 1;
        int i3 = this.I == null ? 0 : 1;
        int i4 = 0;
        int i5 = 0;
        int i6 = size;
        for (a aVar : this.A) {
            if (aVar.d instanceof PLImageView) {
                i6++;
            } else if (aVar.d instanceof PLTextView) {
                i4++;
            } else if (aVar.d instanceof PLPaintView) {
                i5++;
            }
        }
        int i7 = this.f13887a == 1.0d ? 0 : 1;
        List<PLSpeedTimeRange> list = this.b;
        int i8 = i7;
        if (list != null) {
            i8 = i7 + list.size();
        }
        int i9 = this.e == 0 ? 0 : 1;
        int i10 = this.o == null ? 0 : 1;
        com.qiniu.pili.droid.shortvideo.e.c cVar = this.Q;
        int b = cVar != null ? cVar.b() : 0;
        int i11 = this.x != 0 ? 1 : 0;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operation_edit_image", i6);
            jSONObject.put("operation_edit_watermark", i);
            jSONObject.put("operation_edit_filter", i2);
            jSONObject.put("operation_edit_mv", i3);
            jSONObject.put("operation_edit_text", i4);
            jSONObject.put("operation_edit_paint", i5);
            jSONObject.put("operation_edit_speed", i8);
            jSONObject.put("operation_edit_rotate", i9);
            jSONObject.put("operation_edit_audio_mix", i10);
            jSONObject.put("operation_edit_multi_audio_mix", b);
            jSONObject.put("operation_trim_video", i11);
            jSONObject.put("data_type", QosManager.a.config);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        PLVideoPlayerListener pLVideoPlayerListener = this.l;
        if (pLVideoPlayerListener != null) {
            pLVideoPlayerListener.onCompletion();
        }
        com.qiniu.pili.droid.shortvideo.e.c cVar = this.Q;
        if (cVar != null) {
            cVar.f();
        }
        com.qiniu.pili.droid.shortvideo.e.a aVar = this.g;
        if (aVar == null || this.o == null) {
            return;
        }
        if (this.q) {
            aVar.b();
        } else {
            aVar.e();
        }
        this.g.a(this.o.e().a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0054, code lost:
        if (r9 > 0) goto L13;
     */
    @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int onDrawFrame(int r9, int r10, int r11, long r12, float[] r14) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.pili.droid.shortvideo.core.m.onDrawFrame(int, int, int, long, float[]):int");
    }

    @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
    public void onSurfaceChanged(int i, int i2) {
        this.B = i;
        this.C = i2;
        PLEffectPlugin pLEffectPlugin = this.m;
        if (pLEffectPlugin != null) {
            pLEffectPlugin.onSurfaceChanged(i, i2);
        }
        PLVideoFilterListener pLVideoFilterListener = this.j;
        if (pLVideoFilterListener != null) {
            pLVideoFilterListener.onSurfaceChanged(i, i2);
        }
        if (this.F == 0 && this.G == 0) {
            return;
        }
        this.f.a(this.F, this.G);
    }

    @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
    public void onSurfaceCreated() {
        PLEffectPlugin pLEffectPlugin = this.m;
        if (pLEffectPlugin != null) {
            pLEffectPlugin.onSurfaceCreated();
        }
        PLVideoFilterListener pLVideoFilterListener = this.j;
        if (pLVideoFilterListener != null) {
            pLVideoFilterListener.onSurfaceCreated();
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
    public void onSurfaceDestroy() {
        PLEffectPlugin pLEffectPlugin = this.m;
        if (pLEffectPlugin != null) {
            pLEffectPlugin.onSurfaceDestroy();
        }
        this.h.j();
        PLVideoFilterListener pLVideoFilterListener = this.j;
        if (pLVideoFilterListener != null) {
            pLVideoFilterListener.onSurfaceDestroy();
        }
        this.i = null;
    }
}
