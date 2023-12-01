package com.zk_oaction.adengine.lk_view;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.ads.fw;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.zk_oaction.adengine.lk_expression.a;
import com.zk_oaction.adengine.lk_expression.c;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/n.class */
public class n extends TextureView implements MediaPlayer.OnPreparedListener, TextureView.SurfaceTextureListener, a.w {
    private boolean A;
    private boolean B;
    private Handler C;
    private AudioManager.OnAudioFocusChangeListener D;
    private boolean E;
    private i F;
    private boolean G;
    private String H;

    /* renamed from: a  reason: collision with root package name */
    public com.zk_oaction.adengine.lk_sdk.c f28385a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public com.zk_oaction.adengine.lk_expression.a f28386c;
    public com.zk_oaction.adengine.lk_expression.a d;
    public com.zk_oaction.adengine.lk_expression.a e;
    public com.zk_oaction.adengine.lk_expression.a f;
    public com.zk_oaction.adengine.lk_expression.a g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public String m;
    public String n;
    public Surface o;
    public MediaPlayer p;
    public int q;
    public int r;
    public float s;
    public AudioManager t;
    public boolean u;
    public float v;
    private boolean w;
    private int x;
    private int y;
    private Map z;

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/n$a.class */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                try {
                    n.this.t();
                    n nVar = n.this;
                    if (nVar.p == null || !nVar.h) {
                        return;
                    }
                    sendEmptyMessageDelayed(0, nVar.f28385a.i);
                } catch (Throwable th) {
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/n$b.class */
    class b implements AudioManager.OnAudioFocusChangeListener {
        b() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            n nVar;
            float f;
            if (i != -3 && i != -2 && i != -1) {
                if (i == 1 || i == 2) {
                    nVar = n.this;
                    f = 1.0f;
                    nVar.a(f);
                } else if (i != 3 && i != 4) {
                    return;
                }
            }
            nVar = n.this;
            f = 0.0f;
            nVar.a(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/n$c.class */
    public class c implements MediaPlayer.OnCompletionListener {
        c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                n nVar = n.this;
                nVar.h = false;
                if (nVar.b != null) {
                    com.zk_oaction.adengine.lk_variable.g gVar = nVar.f28385a.n;
                    gVar.a(n.this.b + ".play", "0");
                }
                n nVar2 = n.this;
                if (nVar2.i) {
                    return;
                }
                nVar2.u();
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/n$d.class */
    public class d implements MediaPlayer.OnInfoListener {
        d() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i != 3 || n.this.F == null) {
                return false;
            }
            n.this.F.a();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/n$e.class */
    public class e implements MediaPlayer.OnErrorListener {
        e() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            mediaPlayer.reset();
            n nVar = n.this;
            nVar.f("MediaPlayer onError:" + i);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/n$f.class */
    public class f implements MediaPlayer.OnVideoSizeChangedListener {
        f() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            n nVar = n.this;
            nVar.q = i;
            nVar.r = i2;
            if (nVar.l()) {
                n.this.requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/n$g.class */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n nVar = n.this;
            MediaPlayer mediaPlayer = nVar.p;
            if (mediaPlayer == null || nVar.k) {
                return;
            }
            mediaPlayer.release();
            n.this.p = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/n$h.class */
    public class h implements c.b {
        h() {
        }

        @Override // com.zk_oaction.adengine.lk_expression.c.b
        public void h_(String str) {
            n.this.e(str);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/n$i.class */
    public interface i {
        void a();
    }

    public n(com.zk_oaction.adengine.lk_sdk.c cVar, i iVar) {
        super(cVar.j);
        this.s = 0.0f;
        this.G = false;
        this.w = false;
        this.y = -1;
        this.A = false;
        this.B = false;
        this.C = new a(Looper.getMainLooper());
        this.D = new b();
        this.f28385a = cVar;
        setSurfaceTextureListener(this);
        AudioManager audioManager = (AudioManager) cVar.j.getSystemService("audio");
        this.t = audioManager;
        if (audioManager != null) {
            this.E = audioManager.isMusicActive();
        }
        this.F = iVar;
    }

    public static boolean a(int i2) {
        try {
            Class<?> cls = Class.forName("android.media.AudioSystem");
            if (cls != null) {
                Class<?> cls2 = Integer.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("isStreamActive", cls2, cls2);
                if (declaredMethod != null) {
                    return ((Boolean) declaredMethod.invoke(null, Integer.valueOf(i2), 0)).booleanValue();
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private void b(XmlPullParser xmlPullParser) {
        this.b = xmlPullParser.getAttributeValue(null, "name");
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MediaPlayer mediaPlayer = this.p;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.p = null;
        }
        if (this.o != null) {
            try {
                MediaPlayer mediaPlayer2 = new MediaPlayer();
                this.p = mediaPlayer2;
                mediaPlayer2.setSurface(this.o);
                this.p.setOnPreparedListener(this);
                this.p.setOnCompletionListener(new c());
                this.p.setOnInfoListener(new d());
                this.p.setOnErrorListener(new e());
                this.p.setOnVideoSizeChangedListener(new f());
                this.p.reset();
                if (TextUtils.isEmpty(str) || !str.startsWith("http")) {
                    this.p.setDataSource(str);
                } else {
                    this.j = true;
                    this.p.setDataSource(getContext(), Uri.parse(this.n));
                }
                this.p.setLooping(this.i);
                if (this.G) {
                    this.p.setVolume(0.0f, 0.0f);
                } else {
                    MediaPlayer mediaPlayer3 = this.p;
                    float f2 = this.s;
                    mediaPlayer3.setVolume(f2, f2);
                }
                this.l = false;
                this.p.prepareAsync();
            } catch (Exception e2) {
                f(e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    private void c(XmlPullParser xmlPullParser) {
        this.f28386c = new com.zk_oaction.adengine.lk_expression.a(this.f28385a, "x", xmlPullParser.getAttributeValue(null, "x"), 0.0f, this, true);
        this.d = new com.zk_oaction.adengine.lk_expression.a(this.f28385a, "y", xmlPullParser.getAttributeValue(null, "y"), 0.0f, this, true);
    }

    private void d(String str) {
        this.w = !TextUtils.isEmpty(this.H) && "1".equals(str);
    }

    private void d(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, IAdInterListener.AdReqParam.WIDTH);
        String str = attributeValue;
        if (attributeValue == null) {
            str = xmlPullParser.getAttributeValue(null, "width");
        }
        com.zk_oaction.adengine.lk_sdk.c cVar = this.f28385a;
        float f2 = com.zk_oaction.adengine.lk_sdk.c.f28239a;
        float f3 = com.zk_oaction.adengine.lk_sdk.c.b;
        if (f2 <= f3) {
            f3 = f2;
            f2 = f3;
        }
        if (cVar.C) {
            f2 = (16.0f * f3) / 9.0f;
        }
        this.e = new com.zk_oaction.adengine.lk_expression.a(this.f28385a, "width", str, f3, this, true);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "h");
        this.f = new com.zk_oaction.adengine.lk_expression.a(this.f28385a, "height", attributeValue2 == null ? xmlPullParser.getAttributeValue(null, "height") : attributeValue2, f2, this, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        try {
            if (this.z == null) {
                this.z = new HashMap();
            }
            this.z.clear();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.z.put(obj, jSONObject.optString(obj));
                }
            }
        } catch (Throwable th) {
        }
    }

    private void e(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "play");
        this.h = attributeValue != null ? Boolean.parseBoolean(attributeValue) : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        this.C.removeCallbacksAndMessages(null);
        if (this.w) {
            this.f28385a.k.a(this.H, this.y, str, this.z);
        }
    }

    private void f(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "looping");
        if (attributeValue != null) {
            this.i = Boolean.parseBoolean(attributeValue);
        }
        if (xmlPullParser.getAttributeValue(null, "count") != null) {
            this.i = false;
        }
    }

    private void g(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, RemoteMessageConst.Notification.SOUND);
        if (attributeValue != null) {
            try {
                this.s = Float.parseFloat(attributeValue);
            } catch (Exception e2) {
                this.s = 0.0f;
            }
        }
        this.f28385a.n.a(this.b + ".sound", "" + this.s);
    }

    private void h(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "living");
        if (attributeValue != null) {
            this.j = Boolean.parseBoolean(attributeValue);
        }
        String attributeValue2 = xmlPullParser.getAttributeValue(null, OapsKey.KEY_SRC);
        if (attributeValue2 == null) {
            attributeValue2 = "";
        } else if (!this.j) {
            attributeValue2 = this.f28385a.l + attributeValue2;
        }
        this.n = attributeValue2;
    }

    private void i() {
        if (this.g.a() == 0.0f) {
            this.g.a(1.0f);
            setVisibility(0);
            if (this.h && this.k) {
                o();
            }
        }
    }

    private void i(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "scaleType");
        this.m = attributeValue;
        if (attributeValue == null) {
            this.m = "fill";
        }
    }

    private void j() {
        if (this.g.a() == 1.0f) {
            this.g.a(0.0f);
            setVisibility(4);
            MediaPlayer mediaPlayer = this.p;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.p.pause();
        }
    }

    private void j(XmlPullParser xmlPullParser) {
        this.g = new com.zk_oaction.adengine.lk_expression.a(this.f28385a, "visibility", xmlPullParser.getAttributeValue(null, "visibility"), 1.0f, null, false);
    }

    private void k() {
        if (this.g.a() != 1.0f) {
            this.g.a(1.0f);
            setVisibility(0);
            if (this.h && this.k) {
                o();
                return;
            }
            return;
        }
        this.g.a(0.0f);
        setVisibility(4);
        MediaPlayer mediaPlayer = this.p;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.p.pause();
    }

    private void k(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "defaultBitmap");
        if (attributeValue != null) {
            ((com.zk_oaction.adengine.lk_view.c) getParent()).d(attributeValue);
        }
    }

    private void l(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "audioFocus");
        if (attributeValue != null) {
            this.B = Boolean.parseBoolean(attributeValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l() {
        float width;
        int height;
        float height2;
        try {
            if (this.m.equals("fill") || this.q == 0 || this.r == 0) {
                return false;
            }
            float a2 = this.e.a() / this.q;
            float a3 = this.f.a() / this.r;
            Matrix matrix = new Matrix();
            matrix.preTranslate((this.e.a() - this.q) / 2.0f, (this.f.a() - this.r) / 2.0f);
            matrix.preScale(this.q / this.e.a(), this.r / this.f.a());
            if (this.m.equals("fit_width")) {
                width = getWidth() / 2;
                height = getHeight();
                a3 = a2;
            } else if (this.m.equals("fit_height")) {
                width = getWidth() / 2;
                height2 = getHeight() / 2;
                matrix.postScale(a3, a3, width, height2);
                setTransform(matrix);
                return true;
            } else if (!this.m.equals("center")) {
                if (this.m.equals("center_crop")) {
                    a3 = Math.max(a2, a3);
                    width = getWidth() / 2;
                    height = getHeight();
                }
                setTransform(matrix);
                return true;
            } else {
                a3 = Math.min(a2, a3);
                width = getWidth() / 2;
                height = getHeight();
            }
            height2 = height / 2;
            matrix.postScale(a3, a3, width, height2);
            setTransform(matrix);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private void m(XmlPullParser xmlPullParser) {
        this.H = xmlPullParser.getAttributeValue(null, "scene");
        d(xmlPullParser.getAttributeValue(null, "report"));
        try {
            String attributeValue = xmlPullParser.getAttributeValue(null, "scenetype");
            if (attributeValue != null) {
                this.y = Integer.parseInt(attributeValue);
            }
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "extend");
            if (attributeValue2 != null) {
                new com.zk_oaction.adengine.lk_expression.c(this.f28385a, attributeValue2, new h());
            }
        } catch (Throwable th) {
        }
    }

    private boolean m() {
        boolean z = false;
        if (this.s != 0.0f) {
            z = false;
            if (!this.E) {
                z = false;
                if (!a(4)) {
                    AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.D;
                    z = false;
                    if (onAudioFocusChangeListener != null) {
                        this.u = true;
                        z = false;
                        if (1 == this.t.requestAudioFocus(onAudioFocusChangeListener, 3, 2)) {
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    private boolean n() {
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;
        if (!this.u || (onAudioFocusChangeListener = this.D) == null) {
            return false;
        }
        this.u = false;
        return 1 == this.t.abandonAudioFocus(onAudioFocusChangeListener);
    }

    private void o() {
        try {
            if (this.p == null || !this.l) {
                return;
            }
            if (this.B) {
                m();
            }
            this.p.start();
            if (this.b != null) {
                com.zk_oaction.adengine.lk_variable.g gVar = this.f28385a.n;
                gVar.a(this.b + ".play", "1");
            }
            com.zk_oaction.adengine.lk_interfaces.d dVar = this.f28385a.g;
            if (dVar != null) {
                dVar.a(this.b);
            }
            r();
        } catch (Throwable th) {
            th.printStackTrace();
            f(th.getMessage());
        }
    }

    private void p() {
        try {
            if (this.p == null || !this.l) {
                return;
            }
            s();
            if (this.B) {
                n();
            }
            this.p.pause();
            if (this.b != null) {
                com.zk_oaction.adengine.lk_variable.g gVar = this.f28385a.n;
                gVar.a(this.b + ".play", "0");
            }
            this.v = this.p.getCurrentPosition() / this.p.getDuration();
            com.zk_oaction.adengine.lk_interfaces.d dVar = this.f28385a.g;
            if (dVar != null) {
                dVar.b(this.b);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            f(th.getMessage());
        }
    }

    private void q() {
        try {
            if (this.p != null) {
                this.l = false;
                ((com.zk_oaction.adengine.lk_view.c) getParent()).invalidate();
                Handler handler = getHandler();
                if (handler != null) {
                    handler.postDelayed(new g(), 10L);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void r() {
        try {
            if (this.w) {
                this.A = false;
                this.f28385a.k.a(this.H, this.y, this.x, this.z);
                this.C.removeMessages(0);
                this.C.sendEmptyMessageDelayed(0, this.f28385a.i);
            }
        } catch (Throwable th) {
        }
    }

    private void s() {
        MediaPlayer mediaPlayer;
        try {
            this.C.removeCallbacksAndMessages(null);
            if (this.A || !this.w || (mediaPlayer = this.p) == null) {
                return;
            }
            this.f28385a.k.b(this.H, this.y, mediaPlayer.getCurrentPosition(), this.x, this.z);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        MediaPlayer mediaPlayer;
        if (!this.w || (mediaPlayer = this.p) == null) {
            return;
        }
        this.f28385a.k.a(this.H, this.y, mediaPlayer.getCurrentPosition(), this.x, this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.C.removeCallbacksAndMessages(null);
        this.A = true;
        if (this.w) {
            com.zk_oaction.adengine.lk_interfaces.a aVar = this.f28385a.k;
            String str = this.H;
            int i2 = this.y;
            int i3 = this.x;
            aVar.c(str, i2, i3, i3, this.z);
        }
    }

    public String a() {
        return this.b;
    }

    public void a(float f2) {
        try {
            if (this.G) {
                this.s = 0.0f;
            } else {
                this.s = f2;
            }
            this.f28385a.n.a(this.b + ".sound", "" + this.s);
            MediaPlayer mediaPlayer = this.p;
            if (mediaPlayer != null) {
                float f3 = this.s;
                mediaPlayer.setVolume(f3, f3);
            }
        } catch (Throwable th) {
        }
    }

    public void a(String str) {
        if (str.equals(fw.Code)) {
            i();
        } else if (str.equals("false")) {
            j();
        } else if (str.equals("toggle")) {
            k();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
        if (r0.equals("fill") == false) goto L20;
     */
    @Override // com.zk_oaction.adengine.lk_expression.a.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r4, float r5) {
        /*
            r3 = this;
            r0 = r4
            if (r0 != 0) goto L5
            return
        L5:
            r0 = r4
            java.lang.String r1 = "x"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L7d
            if (r0 == 0) goto L1b
            r0 = r3
            android.view.ViewParent r0 = r0.getParent()     // Catch: java.lang.Throwable -> L7d
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch: java.lang.Throwable -> L7d
            r1 = r5
            r0.setTranslationX(r1)     // Catch: java.lang.Throwable -> L7d
            return
        L1b:
            r0 = r4
            java.lang.String r1 = "y"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L7d
            if (r0 == 0) goto L31
            r0 = r3
            android.view.ViewParent r0 = r0.getParent()     // Catch: java.lang.Throwable -> L7d
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch: java.lang.Throwable -> L7d
            r1 = r5
            r0.setTranslationY(r1)     // Catch: java.lang.Throwable -> L7d
            return
        L31:
            r0 = r4
            java.lang.String r1 = "width"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L7d
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L58
            r0 = r3
            java.lang.String r0 = r0.m     // Catch: java.lang.Throwable -> L7d
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L78
            r0 = r4
            java.lang.String r1 = "fill"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L7d
            if (r0 != 0) goto L78
        L50:
            r0 = r3
            boolean r0 = r0.l()     // Catch: java.lang.Throwable -> L7d
            goto L78
        L58:
            r0 = r4
            java.lang.String r1 = "height"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L7d
            if (r0 == 0) goto L7c
            r0 = r3
            java.lang.String r0 = r0.m     // Catch: java.lang.Throwable -> L7d
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L78
            r0 = r4
            java.lang.String r1 = "fill"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L7d
            if (r0 != 0) goto L78
            goto L50
        L78:
            r0 = r3
            r0.requestLayout()     // Catch: java.lang.Throwable -> L7d
        L7c:
            return
        L7d:
            r4 = move-exception
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_view.n.a(java.lang.String, float):void");
    }

    public void a(String str, int i2, String str2, String str3, String str4) {
        this.y = i2;
        this.H = str2;
        e(str3);
        d(str4);
        b(str);
    }

    public void a(boolean z) {
        try {
            this.G = z;
            MediaPlayer mediaPlayer = this.p;
            if (mediaPlayer != null) {
                float f2 = z ? 0.0f : 1.0f;
                mediaPlayer.setVolume(f2, f2);
            }
        } catch (Throwable th) {
        }
    }

    public void a(boolean z, boolean z2) {
        if (this.h == z) {
            return;
        }
        this.h = z;
        if (this.o != null) {
            if (!z) {
                p();
                if (z2) {
                    q();
                }
            } else if (this.k && this.g.a() == 1.0f) {
                if (z2) {
                    b(this.n);
                } else {
                    o();
                }
            }
        }
    }

    public boolean a(XmlPullParser xmlPullParser) {
        b(xmlPullParser);
        c(xmlPullParser);
        d(xmlPullParser);
        e(xmlPullParser);
        f(xmlPullParser);
        g(xmlPullParser);
        h(xmlPullParser);
        i(xmlPullParser);
        j(xmlPullParser);
        k(xmlPullParser);
        l(xmlPullParser);
        m(xmlPullParser);
        ((ViewGroup) getParent()).setTranslationX(this.f28386c.a());
        ((ViewGroup) getParent()).setTranslationY(this.d.a());
        return true;
    }

    public void b() {
        this.k = true;
        if (this.h && this.g.a() == 1.0f) {
            if (this.p == null) {
                b(this.n);
            } else {
                o();
            }
        }
    }

    public void b(String str) {
        if (!str.equals(this.n)) {
            this.n = str;
        }
        c(this.n);
    }

    public void c() {
        this.k = false;
        p();
    }

    public void d() {
        try {
            q();
            Surface surface = this.o;
            if (surface != null) {
                surface.release();
                this.o = null;
            }
        } catch (Throwable th) {
        }
    }

    public float e() {
        com.zk_oaction.adengine.lk_expression.a aVar = this.e;
        if (aVar != null) {
            return aVar.a();
        }
        return 0.0f;
    }

    public float f() {
        com.zk_oaction.adengine.lk_expression.a aVar = this.f;
        if (aVar != null) {
            return aVar.a();
        }
        return 0.0f;
    }

    public float g() {
        com.zk_oaction.adengine.lk_expression.a aVar = this.f28386c;
        if (aVar != null) {
            return aVar.a();
        }
        return 0.0f;
    }

    public float h() {
        com.zk_oaction.adengine.lk_expression.a aVar = this.d;
        if (aVar != null) {
            return aVar.a();
        }
        return 0.0f;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        setMeasuredDimension((int) this.e.a(), (int) this.f.a());
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        try {
            if (this.f28385a.f) {
                MediaPlayer mediaPlayer2 = this.p;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.release();
                    this.p = null;
                    return;
                }
                return;
            }
            this.l = true;
            MediaPlayer mediaPlayer3 = this.p;
            if (mediaPlayer3 != null) {
                this.x = mediaPlayer3.getDuration();
                if (!this.h || !this.k || this.g.a() != 1.0f) {
                    if (this.j) {
                        return;
                    }
                    this.p.seekTo(0);
                    return;
                }
                if (this.E || this.G) {
                    this.p.setVolume(0.0f, 0.0f);
                } else {
                    MediaPlayer mediaPlayer4 = this.p;
                    float f2 = this.s;
                    mediaPlayer4.setVolume(f2, f2);
                }
                o();
            }
        } catch (Throwable th) {
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.o = new Surface(surfaceTexture);
        if (this.h && this.k && this.g.a() == 1.0f) {
            b(this.n);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.l = false;
        try {
            MediaPlayer mediaPlayer = this.p;
            if (mediaPlayer != null) {
                this.v = mediaPlayer.getCurrentPosition() / this.p.getDuration();
                this.p.release();
                this.p = null;
            }
        } catch (Throwable th) {
        }
        try {
            Surface surface = this.o;
            if (surface != null) {
                surface.release();
                this.o = null;
                return true;
            }
            return true;
        } catch (Throwable th2) {
            return true;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
