package com.zk_oaction.adengine.lk_unlock;

import com.zk_oaction.adengine.lk_command.g;
import com.zk_oaction.adengine.lk_view.i;
import com.zk_oaction.adengine.lk_view.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    protected com.zk_oaction.adengine.lk_view.f f41986a;
    private com.zk_oaction.adengine.lk_sdk.c b;

    /* renamed from: c  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_view.d f41987c;
    private ArrayList<com.zk_oaction.adengine.lk_sdk.interfaces.b> d = new ArrayList<>();
    private boolean e;
    private g f;
    private HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void>> g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/c$a.class */
    public class a implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        a() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.a(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/c$b.class */
    public class b implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        b() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.b(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.zk_oaction.adengine.lk_unlock.c$c  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/c$c.class */
    public class C1111c implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        C1111c() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.c(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/c$d.class */
    public class d implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        d() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.d(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/c$e.class */
    public class e implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        e() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.e(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/c$f.class */
    public class f implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        f() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.f(xmlPullParser);
            return null;
        }
    }

    public c(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.b = cVar;
        this.f41987c = cVar.m;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.g gVar = new com.zk_oaction.adengine.lk_view.g(this.b);
        if (gVar.b(xmlPullParser, "Image")) {
            com.zk_oaction.adengine.lk_view.f fVar = this.f41986a;
            if (fVar != null) {
                gVar.a(fVar);
            } else {
                this.f41987c.a((com.zk_oaction.adengine.lk_sdk.interfaces.b) gVar);
            }
            this.d.add(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.e eVar = new com.zk_oaction.adengine.lk_view.e(this.b);
        if (eVar.b(xmlPullParser, "Frame")) {
            com.zk_oaction.adengine.lk_view.f fVar = this.f41986a;
            if (fVar != null) {
                eVar.a(fVar);
            } else {
                this.f41987c.a((com.zk_oaction.adengine.lk_sdk.interfaces.b) eVar);
            }
            this.d.add(eVar);
        }
    }

    private void c() {
        HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void>> hashMap = new HashMap<>();
        this.g = hashMap;
        hashMap.put("Image", new a());
        this.g.put("Frame", new b());
        this.g.put("Text", new C1111c());
        this.g.put("ImageNumber", new d());
        this.g.put("Group", new e());
        this.g.put("Trigger", new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(XmlPullParser xmlPullParser) {
        m mVar = new m(this.b);
        if (mVar.b(xmlPullParser, "Text")) {
            com.zk_oaction.adengine.lk_view.f fVar = this.f41986a;
            if (fVar != null) {
                mVar.a(fVar);
            } else {
                this.f41987c.a((com.zk_oaction.adengine.lk_sdk.interfaces.b) mVar);
            }
            this.d.add(mVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(XmlPullParser xmlPullParser) {
        i iVar = new i(this.b);
        if (iVar.b(xmlPullParser, "ImageNumber")) {
            com.zk_oaction.adengine.lk_view.f fVar = this.f41986a;
            if (fVar != null) {
                iVar.a(fVar);
            } else {
                this.f41987c.a((com.zk_oaction.adengine.lk_sdk.interfaces.b) iVar);
            }
            this.d.add(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.f fVar = new com.zk_oaction.adengine.lk_view.f(this.b);
        if (fVar.a(xmlPullParser, "Group")) {
            com.zk_oaction.adengine.lk_view.f fVar2 = this.f41986a;
            if (fVar2 != null) {
                fVar.a(fVar2);
            } else {
                this.f41987c.a(fVar);
            }
            this.d.add(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(XmlPullParser xmlPullParser) {
        g gVar = new g(this.b);
        this.f = gVar;
        if (gVar.a(xmlPullParser, "Trigger")) {
            return;
        }
        this.f = null;
    }

    public void a() {
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.d.iterator();
        while (it.hasNext()) {
            com.zk_oaction.adengine.lk_sdk.interfaces.b next = it.next();
            next.f(1.0f);
            next.e(1.0f);
            next.f();
        }
        g gVar = this.f;
        if (gVar != null) {
            gVar.a();
        }
        this.e = true;
    }

    public void a(float f2, float f3) {
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().f(f2, f3);
        }
    }

    public void a(com.zk_oaction.adengine.lk_view.f fVar) {
        this.f41986a = fVar;
    }

    public void a(boolean z) {
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.d.iterator();
        while (it.hasNext()) {
            com.zk_oaction.adengine.lk_sdk.interfaces.b next = it.next();
            if (z) {
                next.g();
            } else {
                next.h();
            }
            next.f(0.0f);
            next.e(0.0f);
        }
        this.e = false;
    }

    public boolean a(XmlPullParser xmlPullParser, String str) {
        while (true) {
            try {
                int next = xmlPullParser.next();
                if (next == 1) {
                    return false;
                }
                if (next == 2) {
                    com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> cVar = this.g.get(xmlPullParser.getName());
                    if (cVar != null) {
                        cVar.a(xmlPullParser);
                    }
                } else if (next == 3 && xmlPullParser.getName().equals(str)) {
                    return true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
    }

    public boolean b() {
        return this.e;
    }
}
