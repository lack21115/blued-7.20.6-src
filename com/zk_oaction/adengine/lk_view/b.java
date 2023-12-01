package com.zk_oaction.adengine.lk_view;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.zk_oaction.adengine.lk_expression.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b.class */
public class b extends FrameLayout implements a.w, com.zk_oaction.adengine.lk_sdk.interfaces.b, com.zk_oaction.adengine.lk_sdk.interfaces.f {
    protected com.zk_oaction.adengine.lk_expression.a A;
    protected com.zk_oaction.adengine.lk_expression.a B;
    protected com.zk_oaction.adengine.lk_expression.a C;
    protected com.zk_oaction.adengine.lk_expression.a D;
    protected com.zk_oaction.adengine.lk_expression.a E;
    protected com.zk_oaction.adengine.lk_expression.a F;
    protected String G;
    protected int H;
    protected String I;
    protected String J;
    protected com.zk_oaction.adengine.lk_expression.a K;
    protected com.zk_oaction.adengine.lk_sdk.interfaces.a L;
    protected boolean M;
    protected float N;
    protected float O;
    protected float P;
    protected float Q;
    protected float R;
    protected float S;
    private HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void>> T;
    private HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<String, com.zk_oaction.adengine.lk_animation.b>> U;

    /* renamed from: a  reason: collision with root package name */
    protected float f28326a;
    protected float b;

    /* renamed from: c  reason: collision with root package name */
    protected float f28327c;
    protected float d;
    protected com.zk_oaction.adengine.lk_view.f e;
    protected float f;
    protected float g;
    protected float h;
    protected float i;
    protected float j;
    protected float k;
    protected float l;
    protected float m;
    protected float n;
    protected float o;
    protected float p;
    protected ArrayList<com.zk_oaction.adengine.lk_animation.b> q;
    protected boolean r;
    protected Rect s;
    protected com.zk_oaction.adengine.lk_sdk.c t;
    protected String u;
    protected com.zk_oaction.adengine.lk_expression.a v;
    protected com.zk_oaction.adengine.lk_expression.a w;
    protected com.zk_oaction.adengine.lk_expression.a x;
    protected com.zk_oaction.adengine.lk_expression.a y;
    protected com.zk_oaction.adengine.lk_expression.a z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$a.class */
    public class a implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        a() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(Float f) {
            b.this.k(f.floatValue());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.zk_oaction.adengine.lk_view.b$b  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$b.class */
    public class C0944b implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        C0944b() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(Float f) {
            b.this.l(f.floatValue());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$c.class */
    public class c implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        c() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(Float f) {
            b.this.m(f.floatValue());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$d.class */
    public class d implements com.zk_oaction.adengine.lk_sdk.interfaces.c<String, com.zk_oaction.adengine.lk_animation.b> {
        d() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public com.zk_oaction.adengine.lk_animation.b a(String str) {
            return new com.zk_oaction.adengine.lk_animation.d(b.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$e.class */
    public class e implements com.zk_oaction.adengine.lk_sdk.interfaces.c<String, com.zk_oaction.adengine.lk_animation.b> {
        e() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public com.zk_oaction.adengine.lk_animation.b a(String str) {
            return new com.zk_oaction.adengine.lk_animation.a(b.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$f.class */
    public class f implements com.zk_oaction.adengine.lk_sdk.interfaces.c<String, com.zk_oaction.adengine.lk_animation.b> {
        f() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public com.zk_oaction.adengine.lk_animation.b a(String str) {
            return new com.zk_oaction.adengine.lk_animation.f(b.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$g.class */
    public class g implements com.zk_oaction.adengine.lk_sdk.interfaces.c<String, com.zk_oaction.adengine.lk_animation.b> {
        g() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public com.zk_oaction.adengine.lk_animation.b a(String str) {
            return new com.zk_oaction.adengine.lk_animation.e(b.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$h.class */
    public class h implements com.zk_oaction.adengine.lk_sdk.interfaces.c<String, com.zk_oaction.adengine.lk_animation.b> {
        h() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public com.zk_oaction.adengine.lk_animation.b a(String str) {
            return new com.zk_oaction.adengine.lk_animation.g((com.zk_oaction.adengine.lk_view.g) b.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$i.class */
    public class i implements com.zk_oaction.adengine.lk_sdk.interfaces.a {
        i() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
        public void a() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
        public boolean a(float f, float f2) {
            return f > b.this.getTranslationX() && f < b.this.getTranslationX() + b.this.x.a() && f2 > b.this.getTranslationY() && f2 < b.this.getTranslationY() + b.this.y.a();
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
        public void b(float f, float f2) {
            b bVar = b.this;
            bVar.R = bVar.f;
            bVar.S = bVar.g;
            bVar.f28326a = f;
            bVar.b = f2;
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
        public void c(float f, float f2) {
            b bVar = b.this;
            float f3 = (bVar.R + f) - bVar.f28326a;
            float f4 = (bVar.S + f2) - bVar.b;
            float f5 = f3;
            float f6 = f4;
            if (bVar.M) {
                float f7 = bVar.N;
                float f8 = f3;
                if (f3 < f7) {
                    f8 = f7;
                }
                float f9 = bVar.P;
                float f10 = f8;
                if (f8 > f9) {
                    f10 = f9;
                }
                float f11 = bVar.O;
                float f12 = f4;
                if (f4 < f11) {
                    f12 = f11;
                }
                float f13 = bVar.Q;
                f5 = f10;
                f6 = f12;
                if (f12 > f13) {
                    f6 = f13;
                    f5 = f10;
                }
            }
            bVar.f(f5, f6);
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
        public boolean c() {
            return false;
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
        public void d() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
        public void d(float f, float f2) {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
        public void e(float f, float f2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$j.class */
    public class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f28337a;

        j(float f) {
            this.f28337a = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.zk_oaction.adengine.lk_sdk.c cVar;
            String str;
            String str2;
            b bVar = b.this;
            float f = bVar.H;
            float f2 = this.f28337a;
            float f3 = bVar.p;
            com.zk_oaction.adengine.lk_view.f fVar = bVar.e;
            if ((fVar != null ? fVar.q() : 1.0f) * f * f2 * f3 == 0.0f) {
                b.super.setVisibility(4);
                b.this.g();
                b bVar2 = b.this;
                if (bVar2.u == null) {
                    return;
                }
                cVar = bVar2.t;
                str = b.this.u + ".visibility";
                str2 = "0";
            } else {
                b.super.setVisibility(0);
                b.this.f();
                b bVar3 = b.this;
                if (bVar3.u == null) {
                    return;
                }
                cVar = bVar3.t;
                str = b.this.u + ".visibility";
                str2 = "1";
            }
            cVar.a(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$k.class */
    public class k implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        k() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(Float f) {
            b.this.g(f.floatValue());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$l.class */
    public class l implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Float> {
        l() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(Float f) {
            return Float.valueOf(b.this.I.equals("center") ? f.floatValue() / 2.0f : b.this.I.equals("left") ? 0.0f : f.floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$m.class */
    public class m implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Float> {
        m() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(Float f) {
            return Float.valueOf(b.this.J.equals("center") ? f.floatValue() / 2.0f : b.this.J.equals(Constant.MAP_KEY_TOP) ? 0.0f : f.floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$n.class */
    public class n implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        n() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(Float f) {
            b.this.h(f.floatValue());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$o.class */
    public class o implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        o() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(Float f) {
            b.this.i(f.floatValue());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$p.class */
    public class p implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        p() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(Float f) {
            b.this.j(f.floatValue());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$q.class */
    public class q implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        q() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(Float f) {
            b.this.setPivotX(f.floatValue());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$r.class */
    public class r implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        r() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(Float f) {
            b.this.setPivotY(f.floatValue());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$s.class */
    public class s implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        s() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(Float f) {
            b.this.setRotation(f.floatValue() + b.this.k);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$t.class */
    public class t implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        t() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(Float f) {
            b.this.setRotationX(f.floatValue() + b.this.l);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/b$u.class */
    public class u implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        u() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(Float f) {
            b.this.setRotationY(f.floatValue() + b.this.m);
            return null;
        }
    }

    public b(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar.j);
        this.t = cVar;
        this.q = new ArrayList<>();
        this.s = new Rect();
        this.j = 255.0f;
        this.p = 1.0f;
        a();
        c();
        setWillNotDraw(false);
    }

    private void a() {
        HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void>> hashMap = new HashMap<>();
        this.T = hashMap;
        hashMap.put("x", new k());
        this.T.put("y", new n());
        this.T.put("width", new o());
        this.T.put("height", new p());
        this.T.put("pivotX", new q());
        this.T.put("pivotY", new r());
        this.T.put(Key.ROTATION, new s());
        this.T.put("rotationX", new t());
        this.T.put("rotationY", new u());
        this.T.put("alpha", new a());
        this.T.put("visibility", new C0944b());
        this.T.put("enableMove", new c());
    }

    private void b(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_expression.a aVar = new com.zk_oaction.adengine.lk_expression.a(this.t, "enableMove", xmlPullParser.getAttributeValue(null, "enableMove"), 0.0f, this, false);
        this.K = aVar;
        if (aVar.a() != 0.0f) {
            String attributeValue = xmlPullParser.getAttributeValue(null, "moveRect");
            if (attributeValue != null) {
                this.M = true;
                String[] split = attributeValue.split(",");
                this.N = Float.parseFloat(split[0]);
                this.O = Float.parseFloat(split[1]);
                this.P = Float.parseFloat(split[2]);
                this.Q = Float.parseFloat(split[3]);
            }
            i iVar = new i();
            this.L = iVar;
            this.t.q.add(iVar);
        }
    }

    private com.zk_oaction.adengine.lk_animation.b c(XmlPullParser xmlPullParser) {
        String name = xmlPullParser.getName();
        com.zk_oaction.adengine.lk_animation.b a2 = (name == null || this.U.get(name) == null) ? null : this.U.get(name).a(name);
        if (a2 == null || !a2.a(xmlPullParser)) {
            return a2;
        }
        synchronized (this) {
            this.t.a(a2);
            this.q.add(a2);
        }
        return a2;
    }

    private void c() {
        HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<String, com.zk_oaction.adengine.lk_animation.b>> hashMap = new HashMap<>();
        this.U = hashMap;
        hashMap.put("PositionAnimation", new d());
        this.U.put("AlphaAnimation", new e());
        this.U.put("SizeAnimation", new f());
        this.U.put("RotationAnimation", new g());
        this.U.put("SourcesAnimation", new h());
    }

    private boolean d() {
        com.zk_oaction.adengine.lk_view.f fVar = this.e;
        return fVar != null && fVar.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(float f2) {
        setTranslationX(f2);
        if (this.u != null) {
            this.t.a(this.u + ".actual_x", "" + (getTranslationX() / this.t.t));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(float f2) {
        setTranslationY(f2);
        if (this.u != null) {
            this.t.a(this.u + ".actual_y", "" + (getTranslationY() / this.t.t));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(float f2) {
        if (this.I != null) {
            this.f28327c = new l().a((l) Float.valueOf(f2)).floatValue();
            setTranslationX(this.v.a());
            com.zk_oaction.adengine.lk_expression.a aVar = this.z;
            if (aVar != null && aVar.b == null) {
                aVar.a(this.f28327c);
            }
        }
        if (this.u != null) {
            if ((this instanceof com.zk_oaction.adengine.lk_view.g) || (this instanceof com.zk_oaction.adengine.lk_view.i)) {
                this.t.a(this.u + ".bmp_width", "" + (f2 / this.t.t));
            }
            this.t.a(this.u + ".actual_w", "" + (f2 / this.t.t));
        }
        com.zk_oaction.adengine.lk_expression.a aVar2 = this.x;
        if (aVar2 == null || this.y == null) {
            return;
        }
        this.s.set(0, 0, (int) aVar2.a(), (int) this.y.a());
        j();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(float f2) {
        if (this.J != null) {
            this.d = new m().a((m) Float.valueOf(f2)).floatValue();
            setTranslationY(this.w.a());
            com.zk_oaction.adengine.lk_expression.a aVar = this.A;
            if (aVar != null && aVar.b == null) {
                aVar.a(this.d);
            }
        }
        if (this.u != null) {
            if ((this instanceof com.zk_oaction.adengine.lk_view.g) || (this instanceof com.zk_oaction.adengine.lk_view.i)) {
                this.t.a(this.u + ".bmp_height", "" + (f2 / this.t.t));
            }
            this.t.a(this.u + ".actual_h", "" + (f2 / this.t.t));
        }
        com.zk_oaction.adengine.lk_expression.a aVar2 = this.x;
        if (aVar2 == null || this.y == null) {
            return;
        }
        this.s.set(0, 0, (int) aVar2.a(), (int) this.y.a());
        j();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(float f2) {
        float f3;
        if (f2 < 0.0f) {
            f3 = 0.0f;
        } else {
            f3 = f2;
            if (f2 > 255.0f) {
                f3 = 255.0f;
            }
        }
        float f4 = f3 / 255.0f;
        this.n = f4;
        setAlpha((f4 * this.j) / 255.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(float f2) {
        this.o = f2;
        e(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(float f2) {
        if (f2 == 0.0f) {
            this.t.q.remove(this.L);
            f(0.0f, 0.0f);
        } else if (this.t.q.contains(this.L)) {
        } else {
            this.t.q.add(this.L);
        }
    }

    public String a(com.zk_oaction.adengine.lk_expression.a aVar, String str) {
        if (aVar != null) {
            str = aVar.f28227a;
        }
        return str;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void a(float f2) {
        this.j = f2;
        setAlpha((this.n * f2) / 255.0f);
    }

    public void a(int i2, int i3) {
        this.x.a(i2);
        this.y.a(i3);
    }

    public void a(com.zk_oaction.adengine.lk_view.f fVar) {
        this.e = fVar;
        fVar.a((com.zk_oaction.adengine.lk_sdk.interfaces.b) this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
        if (r3.o == 1.0f) goto L12;
     */
    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r4) {
        /*
            r3 = this;
            r0 = r4
            java.lang.String r1 = "true"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Ld
            goto L35
        Ld:
            r0 = r4
            java.lang.String r1 = "false"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L1a
            goto L2d
        L1a:
            r0 = r4
            java.lang.String r1 = "toggle"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3a
            r0 = r3
            float r0 = r0.o
            r1 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L35
        L2d:
            r0 = r3
            r1 = 0
            r0.o = r1
            goto L3a
        L35:
            r0 = r3
            r1 = 1065353216(0x3f800000, float:1.0)
            r0.o = r1
        L3a:
            r0 = r3
            r1 = r3
            float r1 = r1.o
            r0.e(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_view.b.a(java.lang.String):void");
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f2) {
        if (str == null || this.T.get(str) == null) {
            return;
        }
        this.T.get(str).a(Float.valueOf(f2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(XmlPullParser xmlPullParser) {
        this.u = xmlPullParser.getAttributeValue(null, "name");
        this.v = new com.zk_oaction.adengine.lk_expression.a(this.t, "x", xmlPullParser.getAttributeValue(null, "x"), 0.0f, this, true);
        this.w = new com.zk_oaction.adengine.lk_expression.a(this.t, "y", xmlPullParser.getAttributeValue(null, "y"), 0.0f, this, true);
        this.I = xmlPullParser.getAttributeValue(null, "align");
        this.J = xmlPullParser.getAttributeValue(null, "alignV");
        String attributeValue = xmlPullParser.getAttributeValue(null, IAdInterListener.AdReqParam.WIDTH);
        String str = attributeValue;
        if (attributeValue == null) {
            str = xmlPullParser.getAttributeValue(null, "width");
        }
        com.zk_oaction.adengine.lk_expression.a aVar = new com.zk_oaction.adengine.lk_expression.a(this.t, "width", str, 0.0f, null, true);
        this.x = aVar;
        aVar.a(this);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "h");
        String str2 = attributeValue2;
        if (attributeValue2 == null) {
            str2 = xmlPullParser.getAttributeValue(null, "height");
        }
        com.zk_oaction.adengine.lk_expression.a aVar2 = new com.zk_oaction.adengine.lk_expression.a(this.t, "height", str2, 0.0f, null, true);
        this.y = aVar2;
        aVar2.a(this);
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "pivotX");
        String str3 = attributeValue3;
        if (attributeValue3 == null) {
            str3 = xmlPullParser.getAttributeValue(null, "centerX");
        }
        this.z = new com.zk_oaction.adengine.lk_expression.a(this.t, "pivotX", str3, 0.0f, this, true);
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "pivotY");
        String str4 = attributeValue4;
        if (attributeValue4 == null) {
            str4 = xmlPullParser.getAttributeValue(null, "centerY");
        }
        this.A = new com.zk_oaction.adengine.lk_expression.a(this.t, "pivotY", str4, 0.0f, this, true);
        String attributeValue5 = xmlPullParser.getAttributeValue(null, Key.ROTATION);
        String str5 = attributeValue5;
        if (attributeValue5 == null) {
            str5 = xmlPullParser.getAttributeValue(null, "angle");
        }
        this.B = new com.zk_oaction.adengine.lk_expression.a(this.t, Key.ROTATION, str5, 0.0f, this, false);
        String attributeValue6 = xmlPullParser.getAttributeValue(null, "rotationX");
        String str6 = attributeValue6;
        if (attributeValue6 == null) {
            str6 = xmlPullParser.getAttributeValue(null, "angleX");
        }
        this.C = new com.zk_oaction.adengine.lk_expression.a(this.t, "rotationX", str6, 0.0f, this, false);
        String attributeValue7 = xmlPullParser.getAttributeValue(null, "rotationY");
        String str7 = attributeValue7;
        if (attributeValue7 == null) {
            str7 = xmlPullParser.getAttributeValue(null, "angleY");
        }
        this.D = new com.zk_oaction.adengine.lk_expression.a(this.t, "rotationY", str7, 0.0f, this, false);
        this.E = new com.zk_oaction.adengine.lk_expression.a(this.t, "alpha", xmlPullParser.getAttributeValue(null, "alpha"), 255.0f, this, false);
        String attributeValue8 = xmlPullParser.getAttributeValue(null, "category");
        this.G = attributeValue8;
        if (attributeValue8 == null) {
            this.H = 1;
        }
        this.p = new com.zk_oaction.adengine.lk_expression.a(this.t, "active", xmlPullParser.getAttributeValue(null, "active"), 1.0f, null, false).a();
        this.F = new com.zk_oaction.adengine.lk_expression.a(this.t, "visibility", xmlPullParser.getAttributeValue(null, "visibility"), 1.0f, this, false);
        b(xmlPullParser);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
        if (getVisibility() == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
        f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(org.xmlpull.v1.XmlPullParser r4, java.lang.String r5) {
        /*
            r3 = this;
        L0:
            r0 = 1
            r7 = r0
            r0 = r4
            int r0 = r0.next()     // Catch: java.lang.Throwable -> L69
            r6 = r0
            r0 = r6
            r1 = 1
            if (r0 == r1) goto L6e
            r0 = r6
            r1 = 2
            if (r0 == r1) goto L33
            r0 = r6
            r1 = 3
            if (r0 != r1) goto L0
            r0 = r4
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> L69
            r1 = r5
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L69
            if (r0 == 0) goto L0
            r0 = r3
            int r0 = r0.getVisibility()     // Catch: java.lang.Throwable -> L69
            if (r0 != 0) goto L71
        L2d:
            r0 = r3
            r0.f()     // Catch: java.lang.Throwable -> L69
            r0 = 1
            return r0
        L33:
            r0 = r3
            r1 = r4
            com.zk_oaction.adengine.lk_animation.b r0 = r0.c(r1)     // Catch: java.lang.Throwable -> L69
            if (r0 != 0) goto L0
            r0 = r4
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = "Mask"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L69
            if (r0 == 0) goto L54
            r0 = r3
            int r0 = r0.getVisibility()     // Catch: java.lang.Throwable -> L69
            if (r0 != 0) goto L71
            goto L2d
        L54:
            r0 = r4
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = "Paint"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L69
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L0
            r0 = 1
            return r0
        L69:
            r4 = move-exception
            r0 = r4
            r0.printStackTrace()
        L6e:
            r0 = 0
            r7 = r0
        L71:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_view.b.a(org.xmlpull.v1.XmlPullParser, java.lang.String):boolean");
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public com.zk_oaction.adengine.lk_sdk.c b() {
        return this.t;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void b(float f2) {
        this.k = f2;
        setRotation(this.B.a() + f2);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void b(String str) {
        if (str.equals("play")) {
            f();
        } else if (str.equals("stop")) {
            g();
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void c(float f2) {
        this.l = f2;
        setRotationX(this.C.a() + f2);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void c(String str) {
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void d(float f2) {
        this.m = f2;
        setRotationY(this.D.a() + f2);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void d(String str) {
        if (str.equals("x")) {
            setTranslationX(this.v.a());
        } else if (str.equals("y")) {
            setTranslationY(this.w.a());
        } else if (str.equals(a(this.E, "alpha"))) {
            setAlpha((this.n * this.j) / 255.0f);
        } else if (str.equals(Key.ROTATION)) {
            setRotation(this.B.a() + this.k);
        } else if (str.equals("rotationX")) {
            setRotationX(this.C.a() + this.l);
        } else if (str.equals("rotationY")) {
            setRotationY(this.D.a() + this.m);
        } else if (str.equals(a(this.F, "visibility"))) {
            e(this.o);
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public String e() {
        return this.u;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void e(float f2) {
        com.zk_oaction.adengine.lk_sdk.c cVar;
        String str;
        String str2;
        Thread currentThread = Thread.currentThread();
        com.zk_oaction.adengine.lk_sdk.c cVar2 = this.t;
        if (currentThread != cVar2.w) {
            cVar2.y.post(new j(f2));
            return;
        }
        float f3 = this.H;
        float f4 = this.p;
        com.zk_oaction.adengine.lk_view.f fVar = this.e;
        if ((fVar != null ? fVar.q() : 1.0f) * f4 * f3 * f2 == 0.0f) {
            super.setVisibility(4);
            g();
            if (this.u == null) {
                return;
            }
            cVar = this.t;
            str = this.u + ".visibility";
            str2 = "0";
        } else {
            super.setVisibility(0);
            f();
            if (this.u == null) {
                return;
            }
            cVar = this.t;
            str = this.u + ".visibility";
            str2 = "1";
        }
        cVar.a(str, str2);
    }

    public void e(String str) {
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void f() {
        synchronized (this) {
            Iterator<com.zk_oaction.adengine.lk_animation.b> it = this.q.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void f(float f2) {
        this.p = f2;
        e(this.o);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void f(float f2, float f3) {
        this.f = f2;
        this.g = f3;
        setTranslationX(this.v.a());
        setTranslationY(this.w.a());
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void g() {
        synchronized (this) {
            Iterator<com.zk_oaction.adengine.lk_animation.b> it = this.q.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void g(float f2, float f3) {
        this.h = f2;
        this.i = f3;
        setTranslationX(this.v.a());
        setTranslationY(this.w.a());
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void h() {
        synchronized (this) {
            Iterator<com.zk_oaction.adengine.lk_animation.b> it = this.q.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void h(float f2, float f3) {
        try {
            setScaleX(f2 / this.x.a());
            setScaleY(f3 / this.y.a());
        } catch (Exception e2) {
        }
    }

    protected boolean i() {
        return false;
    }

    protected void j() {
        int makeMeasureSpec;
        float l2;
        if (this.r) {
            if (i() || d()) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) this.e.k(), 1073741824);
                l2 = this.e.l();
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) this.x.a(), 1073741824);
                l2 = this.y.a();
            }
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((int) l2, 1073741824);
            forceLayout();
            measure(makeMeasureSpec, makeMeasureSpec2);
            layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public float k() {
        com.zk_oaction.adengine.lk_expression.a aVar = this.x;
        if (aVar != null) {
            return aVar.a();
        }
        return 0.0f;
    }

    public float l() {
        com.zk_oaction.adengine.lk_expression.a aVar = this.y;
        if (aVar != null) {
            return aVar.a();
        }
        return 0.0f;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int makeMeasureSpec;
        float l2;
        if (i() || d()) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) this.e.k(), 1073741824);
            l2 = this.e.l();
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) this.x.a(), 1073741824);
            l2 = this.y.a();
        }
        super.onMeasure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec((int) l2, 1073741824));
        this.r = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View
    public void setAlpha(float f2) {
        com.zk_oaction.adengine.lk_view.f fVar = this.e;
        super.setAlpha(((fVar != null ? fVar.m() : 255.0f) * f2) / 255.0f);
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        com.zk_oaction.adengine.lk_view.f fVar = this.e;
        super.setRotation((fVar != null ? fVar.n() : 0.0f) + f2);
    }

    @Override // android.view.View
    public void setRotationX(float f2) {
        com.zk_oaction.adengine.lk_view.f fVar = this.e;
        super.setRotationX((fVar != null ? fVar.o() : 0.0f) + f2);
    }

    @Override // android.view.View
    public void setRotationY(float f2) {
        com.zk_oaction.adengine.lk_view.f fVar = this.e;
        super.setRotationY((fVar != null ? fVar.p() : 0.0f) + f2);
    }

    @Override // android.view.View
    public void setTranslationX(float f2) {
        float f3 = this.f28327c;
        float f4 = this.h;
        float f5 = this.f;
        com.zk_oaction.adengine.lk_view.f fVar = this.e;
        super.setTranslationX((fVar != null ? fVar.i() : 0.0f) + f5 + (f2 - f3) + f4);
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        float f3 = this.d;
        float f4 = this.i;
        float f5 = this.g;
        com.zk_oaction.adengine.lk_view.f fVar = this.e;
        super.setTranslationY((fVar != null ? fVar.j() : 0.0f) + f5 + (f2 - f3) + f4);
    }
}
