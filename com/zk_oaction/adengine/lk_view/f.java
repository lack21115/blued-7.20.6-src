package com.zk_oaction.adengine.lk_view;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.zk_oaction.adengine.lk_expression.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/f.class */
public class f implements a.w, com.zk_oaction.adengine.lk_sdk.interfaces.b, com.zk_oaction.adengine.lk_sdk.interfaces.f {
    private float A;
    private float B;
    private float C;
    private f D;

    /* renamed from: a  reason: collision with root package name */
    protected com.zk_oaction.adengine.lk_sdk.c f42054a;
    protected String b;

    /* renamed from: c  reason: collision with root package name */
    protected com.zk_oaction.adengine.lk_expression.a f42055c;
    protected com.zk_oaction.adengine.lk_expression.a d;
    protected com.zk_oaction.adengine.lk_expression.a e;
    protected com.zk_oaction.adengine.lk_expression.a f;
    protected com.zk_oaction.adengine.lk_expression.a g;
    protected com.zk_oaction.adengine.lk_expression.a h;
    protected com.zk_oaction.adengine.lk_expression.a i;
    protected float j;
    protected Object l;
    protected HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void>> n;
    private float p;
    private com.zk_oaction.adengine.lk_expression.a s;
    private com.zk_oaction.adengine.lk_expression.a t;
    private com.zk_oaction.adengine.lk_expression.a u;
    private com.zk_oaction.adengine.lk_expression.a v;
    private float w;
    private float x;
    private float y;
    protected ArrayList<com.zk_oaction.adengine.lk_sdk.interfaces.b> k = new ArrayList<>();
    private float z = 255.0f;
    private ArrayList<com.zk_oaction.adengine.lk_animation.b> o = new ArrayList<>();
    private ArrayList<com.zk_oaction.adengine.lk_unlock.b> q = new ArrayList<>();
    private ArrayList<com.zk_oaction.adengine.lk_command.a> r = new ArrayList<>();
    protected ArrayList<com.zk_oaction.adengine.lk_view.g> m = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/f$a.class */
    public class a implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        a() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            f.this.j(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/f$b.class */
    public class b implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        b() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            f.this.a(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/f$c.class */
    public class c implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        c() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            f.this.b(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/f$d.class */
    public class d implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        d() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            f.this.c(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/f$e.class */
    public class e implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        e() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            f.this.d(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.zk_oaction.adengine.lk_view.f$f  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/f$f.class */
    public class C1117f implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        C1117f() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            f.this.e(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/f$g.class */
    public class g implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        g() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            f.this.f(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/f$h.class */
    public class h implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        h() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            f.this.g(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/f$i.class */
    public class i implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        i() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            f.this.h(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/f$j.class */
    public class j implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        j() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            f.this.i(xmlPullParser);
            return null;
        }
    }

    public f(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f42054a = cVar;
        a();
    }

    private void a(com.zk_oaction.adengine.lk_view.g gVar) {
        gVar.setTag(this.l);
        gVar.a(this);
        if (gVar.e() != null) {
            this.f42054a.p.put(gVar.e(), gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.g gVar = new com.zk_oaction.adengine.lk_view.g(this.f42054a);
        if (gVar.b(xmlPullParser, "Image")) {
            if (this.v.a() == 1.0f && TextUtils.isEmpty(gVar.o())) {
                b(gVar);
            } else {
                a(gVar);
            }
        }
    }

    private void b(com.zk_oaction.adengine.lk_view.g gVar) {
        this.m.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.e eVar = new com.zk_oaction.adengine.lk_view.e(this.f42054a);
        if (eVar.b(xmlPullParser, "Frame")) {
            eVar.setTag(this.l);
            eVar.a(this);
            if (eVar.e() != null) {
                this.f42054a.p.put(eVar.e(), eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(XmlPullParser xmlPullParser) {
        m mVar = new m(this.f42054a);
        if (mVar.b(xmlPullParser, "Text")) {
            mVar.setTag(this.l);
            mVar.a(this);
            if (mVar.e() != null) {
                this.f42054a.p.put(mVar.e(), mVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.i iVar = new com.zk_oaction.adengine.lk_view.i(this.f42054a);
        if (iVar.b(xmlPullParser, "ImageNumber")) {
            iVar.setTag(this.l);
            iVar.a(this);
            if (iVar.e() != null) {
                this.f42054a.p.put(iVar.e(), iVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_unlock.b bVar = new com.zk_oaction.adengine.lk_unlock.b(this.f42054a);
        if (bVar.a(xmlPullParser, "Slider")) {
            this.f42054a.q.add(bVar);
            if (bVar.e() != null) {
                this.f42054a.p.put(bVar.e(), bVar);
            }
            this.q.add(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_command.a aVar = new com.zk_oaction.adengine.lk_command.a(this.f42054a);
        aVar.a(this);
        if (aVar.a(xmlPullParser, "Button")) {
            this.f42054a.q.add(aVar);
            if (aVar.e() != null) {
                this.f42054a.p.put(aVar.e(), aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(XmlPullParser xmlPullParser) {
        f fVar = new f(this.f42054a);
        fVar.a(this.l);
        if (fVar.a(xmlPullParser, "Group")) {
            fVar.a(this);
            if (fVar.e() != null) {
                this.f42054a.p.put(fVar.e(), fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_animation.d dVar = new com.zk_oaction.adengine.lk_animation.d(this);
        if (dVar.a(xmlPullParser)) {
            this.f42054a.a(dVar);
            this.o.add(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_animation.a aVar = new com.zk_oaction.adengine.lk_animation.a(this);
        if (aVar.a(xmlPullParser)) {
            this.f42054a.a(aVar);
            this.o.add(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_animation.e eVar = new com.zk_oaction.adengine.lk_animation.e(this);
        if (eVar.a(xmlPullParser)) {
            this.f42054a.a(eVar);
            this.o.add(eVar);
        }
    }

    protected void a() {
        HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void>> hashMap = new HashMap<>();
        this.n = hashMap;
        hashMap.put("Image", new b());
        this.n.put("Frame", new c());
        this.n.put("Text", new d());
        this.n.put("ImageNumber", new e());
        this.n.put("Slider", new C1117f());
        this.n.put("Button", new g());
        this.n.put("Group", new h());
        this.n.put("PositionAnimation", new i());
        this.n.put("AlphaAnimation", new j());
        this.n.put("RotationAnimation", new a());
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void a(float f) {
        this.z = f;
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().d("alpha");
        }
    }

    public void a(com.zk_oaction.adengine.lk_command.a aVar) {
        this.r.add(aVar);
    }

    public void a(com.zk_oaction.adengine.lk_sdk.interfaces.b bVar) {
        this.k.add(bVar);
    }

    public void a(f fVar) {
        this.D = fVar;
        fVar.a((com.zk_oaction.adengine.lk_sdk.interfaces.b) this);
    }

    public void a(Object obj) {
        this.l = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
        if (r3.h.a() == 1.0f) goto L11;
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
            goto L39
        Ld:
            r0 = r4
            java.lang.String r1 = "false"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L1a
            goto L30
        L1a:
            r0 = r4
            java.lang.String r1 = "toggle"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L41
            r0 = r3
            com.zk_oaction.adengine.lk_expression.a r0 = r0.h
            float r0 = r0.a()
            r1 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L39
        L30:
            r0 = r3
            com.zk_oaction.adengine.lk_expression.a r0 = r0.h
            r1 = 0
            r0.a(r1)
            return
        L39:
            r0 = r3
            com.zk_oaction.adengine.lk_expression.a r0 = r0.h
            r1 = 1065353216(0x3f800000, float:1.0)
            r0.a(r1)
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_view.f.a(java.lang.String):void");
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f) {
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().d(str);
        }
        if (str.equals("x") || str.equals("y")) {
            Iterator<com.zk_oaction.adengine.lk_command.a> it2 = this.r.iterator();
            while (it2.hasNext()) {
                it2.next().b();
            }
        }
        if (str.equals("visibility")) {
            if (q() != 0.0f) {
                f();
                Iterator<com.zk_oaction.adengine.lk_unlock.b> it3 = this.q.iterator();
                while (it3.hasNext()) {
                    it3.next().a("true");
                }
            } else {
                g();
                Iterator<com.zk_oaction.adengine.lk_unlock.b> it4 = this.q.iterator();
                while (it4.hasNext()) {
                    it4.next().a("false");
                }
            }
            if (this.b != null) {
                this.f42054a.a(this.b + ".visibility", "" + q());
            }
        }
    }

    public boolean a(XmlPullParser xmlPullParser, String str) {
        try {
            this.b = xmlPullParser.getAttributeValue(null, "name");
            this.f42055c = new com.zk_oaction.adengine.lk_expression.a(this.f42054a, "x", xmlPullParser.getAttributeValue(null, "x"), 0.0f, null, true);
            this.d = new com.zk_oaction.adengine.lk_expression.a(this.f42054a, "y", xmlPullParser.getAttributeValue(null, "y"), 0.0f, null, true);
            String attributeValue = xmlPullParser.getAttributeValue(null, IAdInterListener.AdReqParam.WIDTH);
            String str2 = attributeValue;
            if (attributeValue == null) {
                str2 = xmlPullParser.getAttributeValue(null, "width");
            }
            this.e = new com.zk_oaction.adengine.lk_expression.a(this.f42054a, "width", str2, 0.0f, null, true);
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "h");
            String str3 = attributeValue2;
            if (attributeValue2 == null) {
                str3 = xmlPullParser.getAttributeValue(null, "height");
            }
            this.f = new com.zk_oaction.adengine.lk_expression.a(this.f42054a, "height", str3, 0.0f, null, true);
            this.g = new com.zk_oaction.adengine.lk_expression.a(this.f42054a, "alpha", xmlPullParser.getAttributeValue(null, "alpha"), 255.0f, null, false);
            String attributeValue3 = xmlPullParser.getAttributeValue(null, "rotation");
            String str4 = attributeValue3;
            if (attributeValue3 == null) {
                str4 = xmlPullParser.getAttributeValue(null, "angle");
            }
            this.s = new com.zk_oaction.adengine.lk_expression.a(this.f42054a, "rotation", str4, 0.0f, null, false);
            this.t = new com.zk_oaction.adengine.lk_expression.a(this.f42054a, "rotationX", xmlPullParser.getAttributeValue(null, "rotationX"), 0.0f, null, false);
            this.u = new com.zk_oaction.adengine.lk_expression.a(this.f42054a, "rotationY", xmlPullParser.getAttributeValue(null, "rotationY"), 0.0f, null, false);
            this.p = new com.zk_oaction.adengine.lk_expression.a(this.f42054a, "active", xmlPullParser.getAttributeValue(null, "active"), 1.0f, null, false).a();
            this.h = new com.zk_oaction.adengine.lk_expression.a(this.f42054a, "visibility", xmlPullParser.getAttributeValue(null, "visibility"), 1.0f, null, false);
            this.v = new com.zk_oaction.adengine.lk_expression.a(this.f42054a, "layered", xmlPullParser.getAttributeValue(null, "layered"), 0.0f, null, false);
            this.i = new com.zk_oaction.adengine.lk_expression.a(this.f42054a, "clip", xmlPullParser.getAttributeValue(null, "clip"), 0.0f, null, false);
            while (true) {
                int next = xmlPullParser.next();
                if (next == 1) {
                    return false;
                }
                if (next == 2) {
                    com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> cVar = this.n.get(xmlPullParser.getName());
                    if (cVar != null) {
                        cVar.a(xmlPullParser);
                    }
                } else if (next == 3 && xmlPullParser.getName().equals(str)) {
                    c();
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public com.zk_oaction.adengine.lk_sdk.c b() {
        return this.f42054a;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void b(float f) {
        this.A = f;
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().d("rotation");
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void b(String str) {
        if (str.equals("play")) {
            f();
        } else if (str.equals("stop")) {
            g();
        }
    }

    public void c() {
        this.f42055c.a(this);
        this.d.a(this);
        this.e.a(this);
        this.f.a(this);
        this.g.a(this);
        this.s.a(this);
        this.t.a(this);
        this.u.a(this);
        this.h.a(this);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void c(float f) {
        this.B = f;
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().d("rotationX");
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void c(String str) {
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.k.iterator();
        while (it.hasNext()) {
            com.zk_oaction.adengine.lk_sdk.interfaces.b next = it.next();
            if (next instanceof com.zk_oaction.adengine.lk_sdk.interfaces.f) {
                ((com.zk_oaction.adengine.lk_sdk.interfaces.f) next).c(str);
            }
        }
    }

    public ArrayList<com.zk_oaction.adengine.lk_sdk.interfaces.b> d() {
        return this.k;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void d(float f) {
        this.C = f;
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().d("rotationY");
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void d(String str) {
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().d(str);
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public String e() {
        return this.b;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void e(float f) {
        this.h.a(f);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void f() {
        Iterator<com.zk_oaction.adengine.lk_animation.b> it = this.o.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void f(float f) {
        this.p = f;
        a("visibility", 0.0f);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void f(float f, float f2) {
        this.w = f;
        this.j = f2;
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.k.iterator();
        while (it.hasNext()) {
            com.zk_oaction.adengine.lk_sdk.interfaces.b next = it.next();
            next.d("x");
            next.d("y");
        }
        Iterator<com.zk_oaction.adengine.lk_command.a> it2 = this.r.iterator();
        while (it2.hasNext()) {
            it2.next().b();
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void g() {
        Iterator<com.zk_oaction.adengine.lk_animation.b> it = this.o.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void g(float f, float f2) {
        this.x = f;
        this.y = f2;
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.k.iterator();
        while (it.hasNext()) {
            com.zk_oaction.adengine.lk_sdk.interfaces.b next = it.next();
            next.d("x");
            next.d("y");
        }
        Iterator<com.zk_oaction.adengine.lk_command.a> it2 = this.r.iterator();
        while (it2.hasNext()) {
            it2.next().b();
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void h() {
        Iterator<com.zk_oaction.adengine.lk_animation.b> it = this.o.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void h(float f, float f2) {
    }

    public float i() {
        f fVar = this.D;
        return (fVar != null ? fVar.i() : 0.0f) + this.f42055c.a() + this.x + this.w;
    }

    public float j() {
        f fVar = this.D;
        return (fVar != null ? fVar.j() : 0.0f) + this.d.a() + this.y + this.j;
    }

    public float k() {
        return this.e.a();
    }

    public float l() {
        return this.f.a();
    }

    public float m() {
        f fVar = this.D;
        return (int) (((((fVar != null ? fVar.m() / 255.0f : 1.0f) * this.g.a()) * this.z) / 255.0f) + 0.5f);
    }

    public float n() {
        f fVar = this.D;
        return (fVar != null ? fVar.n() : 0.0f) + this.s.a() + this.A;
    }

    public float o() {
        f fVar = this.D;
        return (fVar != null ? fVar.o() : 0.0f) + this.t.a() + this.B;
    }

    public float p() {
        f fVar = this.D;
        return (fVar != null ? fVar.p() : 0.0f) + this.u.a() + this.C;
    }

    public float q() {
        f fVar = this.D;
        return (fVar != null ? fVar.q() : 1.0f) * this.h.a() * this.p;
    }

    public boolean r() {
        com.zk_oaction.adengine.lk_expression.a aVar = this.i;
        return aVar != null && aVar.a() == 1.0f;
    }

    public ArrayList<com.zk_oaction.adengine.lk_view.g> s() {
        return this.m;
    }
}
