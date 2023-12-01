package com.zk_oaction.adengine.lk_unlock;

import android.content.Intent;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.zk_oaction.adengine.lk_expression.a;
import com.zk_oaction.adengine.lk_sdk.a;
import java.net.URISyntaxException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/d.class */
public class d implements a.w, a.b {

    /* renamed from: a  reason: collision with root package name */
    public com.zk_oaction.adengine.lk_unlock.a f28303a;
    public com.zk_oaction.adengine.lk_command.g b;

    /* renamed from: c  reason: collision with root package name */
    public Intent f28304c;
    private com.zk_oaction.adengine.lk_sdk.c d;
    private com.zk_oaction.adengine.lk_unlock.c e;
    private com.zk_oaction.adengine.lk_unlock.c f;
    private com.zk_oaction.adengine.lk_unlock.c g;
    private com.zk_oaction.adengine.lk_expression.a h;
    private com.zk_oaction.adengine.lk_expression.a i;
    private com.zk_oaction.adengine.lk_expression.a j;
    private com.zk_oaction.adengine.lk_expression.a k;
    private float m;
    private float n;
    private float o;
    private float p;
    private String r;
    private String s;
    private String t;
    private HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void>> u;
    private com.zk_oaction.adengine.lk_unlock.b v;
    private float w;
    private float x;
    private float y;
    private RectF l = new RectF();
    private int q = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/d$a.class */
    public class a implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        a() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            d.this.a(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/d$b.class */
    public class b implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        b() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            d.this.b(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/d$c.class */
    public class c implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        c() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            d.this.c(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.zk_oaction.adengine.lk_unlock.d$d  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/d$d.class */
    public class C0942d implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        C0942d() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            d.this.d(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/d$e.class */
    public class e implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        e() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            d.this.e(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/d$f.class */
    public class f implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        f() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            d.this.f(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/d$g.class */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.d.k.a(d.this.f28304c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public d(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.d = cVar;
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_unlock.c cVar = new com.zk_oaction.adengine.lk_unlock.c(this.d);
        this.e = cVar;
        if (cVar.a(xmlPullParser, "NormalState")) {
            return;
        }
        this.e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_unlock.c cVar = new com.zk_oaction.adengine.lk_unlock.c(this.d);
        this.f = cVar;
        if (cVar.a(xmlPullParser, "PressedState")) {
            return;
        }
        this.f = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_unlock.c cVar = new com.zk_oaction.adengine.lk_unlock.c(this.d);
        this.g = cVar;
        if (cVar.a(xmlPullParser, "ReachedState")) {
            return;
        }
        this.g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_unlock.a aVar = new com.zk_oaction.adengine.lk_unlock.a(this.d);
        this.f28303a = aVar;
        if (aVar.a(xmlPullParser, "Path")) {
            return;
        }
        this.f28303a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_command.g gVar = new com.zk_oaction.adengine.lk_command.g(this.d);
        this.b = gVar;
        if (gVar.a(xmlPullParser, "Trigger")) {
            return;
        }
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(XmlPullParser xmlPullParser) {
        this.f28304c = new Intent();
        g(xmlPullParser);
        h(xmlPullParser);
    }

    private void g(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        try {
            if (attributeValue != null) {
                this.f28304c = (Intent) Intent.parseUri(attributeValue, 0).clone();
                return;
            }
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "selectIntent");
            if (attributeValue2 != null) {
                int lastIndexOf = attributeValue2.lastIndexOf("#Intent");
                Intent parseUri = Intent.parseUri(attributeValue2.substring(0, lastIndexOf - 1), 0);
                Intent intent = parseUri;
                if (this.d.j.getPackageManager().queryIntentActivities(parseUri, 0).isEmpty()) {
                    intent = Intent.parseUri(attributeValue2.substring(lastIndexOf), 0);
                }
                this.f28304c = (Intent) intent.clone();
            }
        } catch (URISyntaxException e2) {
            e2.printStackTrace();
        }
    }

    private void h(XmlPullParser xmlPullParser) {
        this.f28304c.addFlags(270532608);
        String attributeValue = xmlPullParser.getAttributeValue(null, "action");
        if (attributeValue != null) {
            this.f28304c.setAction(attributeValue);
        }
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "uri");
        if (attributeValue2 != null) {
            this.f28304c.setData(Uri.parse(attributeValue2));
        }
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "type");
        if (attributeValue3 != null) {
            this.f28304c.setType(attributeValue3);
        }
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "category");
        if (attributeValue4 != null) {
            this.f28304c.addCategory(attributeValue4);
        }
        String attributeValue5 = xmlPullParser.getAttributeValue(null, "package");
        String attributeValue6 = xmlPullParser.getAttributeValue(null, "class");
        if (attributeValue5 == null || attributeValue6 == null) {
            return;
        }
        this.f28304c.setClassName(attributeValue5, attributeValue6);
    }

    private void i() {
        HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void>> hashMap = new HashMap<>();
        this.u = hashMap;
        hashMap.put("NormalState", new a());
        this.u.put("PressedState", new b());
        this.u.put("ReachedState", new c());
        this.u.put("Path", new C0942d());
        this.u.put("Trigger", new e());
        this.u.put("Intent", new f());
    }

    private void j() {
        com.zk_oaction.adengine.lk_unlock.c cVar = this.e;
        if (cVar != null && !cVar.b()) {
            this.e.a();
        }
        com.zk_oaction.adengine.lk_unlock.c cVar2 = this.f;
        if (cVar2 != null) {
            cVar2.a(true);
        }
        com.zk_oaction.adengine.lk_unlock.c cVar3 = this.g;
        if (cVar3 != null) {
            cVar3.a(true);
        }
        String str = this.r;
        if (str != null) {
            this.d.k.a(str, 1.0f, false, false);
        }
    }

    private void k() {
        com.zk_oaction.adengine.lk_unlock.c cVar = this.f;
        if (cVar != null && !cVar.b()) {
            this.f.a();
            com.zk_oaction.adengine.lk_unlock.c cVar2 = this.e;
            if (cVar2 != null) {
                cVar2.a(true);
            }
            com.zk_oaction.adengine.lk_unlock.c cVar3 = this.g;
            if (cVar3 != null) {
                cVar3.a(true);
            }
        }
        String str = this.s;
        if (str != null) {
            this.d.k.a(str, 1.0f, false, false);
        }
    }

    private void l() {
        com.zk_oaction.adengine.lk_unlock.c cVar = this.g;
        if (cVar != null && !cVar.b()) {
            this.g.a();
            com.zk_oaction.adengine.lk_unlock.c cVar2 = this.e;
            boolean z = true;
            if (cVar2 != null) {
                cVar2.a(true);
            }
            com.zk_oaction.adengine.lk_unlock.c cVar3 = this.f;
            if (cVar3 != null) {
                if (this.q == 1) {
                    z = false;
                }
                cVar3.a(z);
            }
        }
        String str = this.t;
        if (str != null) {
            this.d.k.a(str, 1.0f, false, false);
        }
    }

    private void m() {
        com.zk_oaction.adengine.lk_unlock.c cVar = this.e;
        if (cVar != null) {
            cVar.a(true);
        }
        com.zk_oaction.adengine.lk_unlock.c cVar2 = this.f;
        if (cVar2 != null) {
            cVar2.a(true);
        }
        com.zk_oaction.adengine.lk_unlock.c cVar3 = this.g;
        if (cVar3 != null) {
            cVar3.a(true);
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.a.b
    public void a() {
        this.v.f();
    }

    @Override // com.zk_oaction.adengine.lk_sdk.a.b
    public void a(float f2) {
        float f3 = f2 / this.w;
        float f4 = this.x;
        float f5 = this.m;
        float f6 = this.y;
        this.v.a((f4 * f3) + f5, (f3 * f6) + this.n, true);
    }

    public void a(float f2, float f3, com.zk_oaction.adengine.lk_unlock.b bVar, float[] fArr) {
        this.d.B = true;
        if (f2 == -1.0f) {
            bVar.a(this.m, this.n, true);
            bVar.f();
            return;
        }
        if (f2 < 100.0f) {
            f2 = 100.0f;
        }
        if (f3 < 10.0f) {
            f3 = 10.0f;
        }
        this.v = bVar;
        float sqrt = (float) Math.sqrt((c() * c()) + (d() * d()));
        this.w = sqrt;
        if (sqrt == 0.0f) {
            this.v.f();
            return;
        }
        this.x = c();
        this.y = d();
        new com.zk_oaction.adengine.lk_sdk.a().a(f2, f3, this.w, this, fArr);
    }

    public void a(float f2, float f3, boolean z) {
        float f4 = f2 - this.m;
        this.o = f4;
        float f5 = f3 - this.n;
        this.p = f5;
        com.zk_oaction.adengine.lk_unlock.a aVar = this.f28303a;
        if (aVar != null) {
            aVar.a(f4, f5, z);
        }
    }

    public void a(int i) {
        if (this.q == i) {
            return;
        }
        if (i == 0) {
            j();
        } else if (i == 1) {
            k();
        } else if (i != 2) {
            m();
        } else {
            l();
        }
        this.q = i;
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f2) {
        com.zk_oaction.adengine.lk_expression.a aVar = this.h;
        if (aVar == null || this.i == null || this.j == null || this.k == null) {
            return;
        }
        this.l.set(aVar.a(), this.i.a(), this.h.a() + this.j.a(), this.i.a() + this.k.a());
    }

    public boolean a(float f2, float f3) {
        float f4 = (int) (f2 + 0.5f);
        float f5 = (int) (f3 + 0.5f);
        RectF rectF = this.l;
        return f4 >= ((float) ((int) (rectF.left + 0.5f))) && f4 <= ((float) ((int) (rectF.right + 0.5f))) && f5 >= ((float) ((int) (rectF.top + 0.5f))) && f5 <= ((float) ((int) (rectF.bottom + 0.5f)));
    }

    public boolean a(XmlPullParser xmlPullParser, String str) {
        try {
            this.h = new com.zk_oaction.adengine.lk_expression.a(this.d, null, xmlPullParser.getAttributeValue(null, "x"), 0.0f, this, true);
            this.i = new com.zk_oaction.adengine.lk_expression.a(this.d, null, xmlPullParser.getAttributeValue(null, "y"), 0.0f, this, true);
            this.j = new com.zk_oaction.adengine.lk_expression.a(this.d, null, xmlPullParser.getAttributeValue(null, IAdInterListener.AdReqParam.WIDTH), 0.0f, this, true);
            this.k = new com.zk_oaction.adengine.lk_expression.a(this.d, null, xmlPullParser.getAttributeValue(null, "h"), 0.0f, this, true);
            this.l.set(this.h.a(), this.i.a(), this.h.a() + this.j.a(), this.i.a() + this.k.a());
            String attributeValue = xmlPullParser.getAttributeValue(null, "normalSound");
            this.r = attributeValue;
            if (attributeValue != null) {
                String str2 = this.d.l + this.r;
                this.r = str2;
                this.d.k.a(str2);
            }
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "pressedSound");
            this.s = attributeValue2;
            if (attributeValue2 != null) {
                String str3 = this.d.l + this.s;
                this.s = str3;
                this.d.k.a(str3);
            }
            String attributeValue3 = xmlPullParser.getAttributeValue(null, "reachedSound");
            this.t = attributeValue3;
            if (attributeValue3 != null) {
                String str4 = this.d.l + this.t;
                this.t = str4;
                this.d.k.a(str4);
            }
            while (true) {
                int next = xmlPullParser.next();
                if (next == 1) {
                    return false;
                }
                if (next == 2) {
                    com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> cVar = this.u.get(xmlPullParser.getName());
                    if (cVar != null) {
                        cVar.a(xmlPullParser);
                    }
                } else if (next == 3 && xmlPullParser.getName().equals(str)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public int b() {
        return this.q;
    }

    public void b(float f2, float f3) {
        this.m = f2;
        this.n = f3;
    }

    public float c() {
        com.zk_oaction.adengine.lk_unlock.a aVar = this.f28303a;
        return aVar != null ? aVar.a() - this.h.a() : this.o;
    }

    public float d() {
        com.zk_oaction.adengine.lk_unlock.a aVar = this.f28303a;
        return aVar != null ? aVar.b() - this.i.a() : this.p;
    }

    public float e() {
        return this.h.a() + c();
    }

    public float f() {
        return this.i.a() + d();
    }

    public void g() {
        com.zk_oaction.adengine.lk_unlock.c cVar = this.e;
        if (cVar != null) {
            cVar.a(c(), d());
        }
        com.zk_oaction.adengine.lk_unlock.c cVar2 = this.f;
        if (cVar2 != null) {
            cVar2.a(c(), d());
        }
        com.zk_oaction.adengine.lk_unlock.c cVar3 = this.g;
        if (cVar3 != null) {
            cVar3.a(c(), d());
        }
    }

    public void h() {
        if (this.f28304c != null) {
            new Handler(Looper.getMainLooper()).post(new g());
        }
        com.zk_oaction.adengine.lk_command.g gVar = this.b;
        if (gVar != null) {
            gVar.a();
        }
    }
}
