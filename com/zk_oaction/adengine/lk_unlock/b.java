package com.zk_oaction.adengine.lk_unlock;

import android.os.Handler;
import android.os.Looper;
import com.zk_oaction.adengine.lk_expression.a;
import com.zk_oaction.adengine.lk_sdk.interfaces.f;
import com.zk_oaction.adengine.lk_variable.g;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/b.class */
public class b implements a.w, com.zk_oaction.adengine.lk_sdk.interfaces.a, f {

    /* renamed from: a  reason: collision with root package name */
    protected com.zk_oaction.adengine.lk_sdk.c f41983a;
    protected String b;

    /* renamed from: c  reason: collision with root package name */
    protected com.zk_oaction.adengine.lk_expression.a f41984c;
    protected com.zk_oaction.adengine.lk_expression.a d;
    protected com.zk_oaction.adengine.lk_expression.a e;
    protected com.zk_oaction.adengine.lk_expression.a f;
    protected d g;
    protected boolean j;
    protected d k;
    protected float[] l;
    protected com.zk_oaction.adengine.lk_variable.d m;
    protected com.zk_oaction.adengine.lk_variable.d n;
    protected com.zk_oaction.adengine.lk_variable.d o;
    protected com.zk_oaction.adengine.lk_variable.d p;
    protected Handler q = new Handler(Looper.getMainLooper());
    protected ArrayList<d> h = new ArrayList<>();
    protected int i = -1;

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_unlock/b$a.class */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            bVar.g.a(-1.0f, 0.0f, bVar, bVar.l);
        }
    }

    public b(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f41983a = cVar;
        this.f41983a.s.add(this);
    }

    private void a(float f) {
        int i;
        com.zk_oaction.adengine.lk_sdk.c cVar;
        String str;
        String str2;
        if (f == 1.0f) {
            i = 0;
            this.i = 0;
            this.g.a(0);
            Iterator<d> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().a(0);
            }
            if (this.b != null) {
                cVar = this.f41983a;
                str = this.b + ".visibility";
                str2 = "1";
                i = 0;
                cVar.a(str, str2);
            }
        } else {
            this.i = 3;
            this.g.a(3);
            Iterator<d> it2 = this.h.iterator();
            while (it2.hasNext()) {
                it2.next().a(3);
            }
            i = 3;
            if (this.b != null) {
                cVar = this.f41983a;
                str = this.b + ".visibility";
                str2 = "0";
                i = 3;
                cVar.a(str, str2);
            }
        }
        a(i);
    }

    private void a(XmlPullParser xmlPullParser) {
        try {
            b(xmlPullParser);
            this.f41984c = new com.zk_oaction.adengine.lk_expression.a(this.f41983a, null, xmlPullParser.getAttributeValue(null, "bounceInitSpeed"), 0.0f, null, true);
            this.d = new com.zk_oaction.adengine.lk_expression.a(this.f41983a, null, xmlPullParser.getAttributeValue(null, "bounceAccelation"), 0.0f, null, true);
            this.e = new com.zk_oaction.adengine.lk_expression.a(this.f41983a, null, xmlPullParser.getAttributeValue(null, "visibility"), 1.0f, null, false);
            this.f = new com.zk_oaction.adengine.lk_expression.a(this.f41983a, "always", xmlPullParser.getAttributeValue(null, "always"), 0.0f, null, false);
            String attributeValue = xmlPullParser.getAttributeValue(null, "keyPoint");
            if (attributeValue == null) {
                return;
            }
            String[] split = attributeValue.split(",");
            this.l = new float[split.length];
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                this.l[i2] = Float.parseFloat(split[i2]);
                i = i2 + 1;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        this.b = attributeValue;
        if (attributeValue != null) {
            g gVar = this.f41983a.n;
            com.zk_oaction.adengine.lk_variable.d a2 = gVar.a(this.b + ".move_x");
            this.m = a2;
            if (a2 == null) {
                com.zk_oaction.adengine.lk_sdk.c cVar = this.f41983a;
                com.zk_oaction.adengine.lk_variable.d dVar = new com.zk_oaction.adengine.lk_variable.d(cVar, this.b + ".move_x");
                this.m = dVar;
                this.f41983a.n.a(dVar);
            }
            g gVar2 = this.f41983a.n;
            com.zk_oaction.adengine.lk_variable.d a3 = gVar2.a(this.b + ".move_y");
            this.n = a3;
            if (a3 == null) {
                com.zk_oaction.adengine.lk_sdk.c cVar2 = this.f41983a;
                com.zk_oaction.adengine.lk_variable.d dVar2 = new com.zk_oaction.adengine.lk_variable.d(cVar2, this.b + ".move_y");
                this.n = dVar2;
                this.f41983a.n.a(dVar2);
            }
            g gVar3 = this.f41983a.n;
            com.zk_oaction.adengine.lk_variable.d a4 = gVar3.a(this.b + ".move_dist");
            this.o = a4;
            if (a4 == null) {
                com.zk_oaction.adengine.lk_sdk.c cVar3 = this.f41983a;
                com.zk_oaction.adengine.lk_variable.d dVar3 = new com.zk_oaction.adengine.lk_variable.d(cVar3, this.b + ".move_dist");
                this.o = dVar3;
                this.f41983a.n.a(dVar3);
            }
            g gVar4 = this.f41983a.n;
            com.zk_oaction.adengine.lk_variable.d a5 = gVar4.a(this.b + ".state");
            this.p = a5;
            if (a5 == null) {
                com.zk_oaction.adengine.lk_sdk.c cVar4 = this.f41983a;
                com.zk_oaction.adengine.lk_variable.d dVar4 = new com.zk_oaction.adengine.lk_variable.d(cVar4, this.b + ".state");
                this.p = dVar4;
                this.f41983a.n.a(dVar4);
            }
        }
    }

    private void g() {
        this.f41983a.a(this);
    }

    public String a(com.zk_oaction.adengine.lk_expression.a aVar, String str) {
        if (aVar != null) {
            str = aVar.f41918a;
        }
        return str;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void a() {
    }

    public void a(float f, float f2, boolean z) {
        this.g.a(f, f2, z);
        this.g.g();
        if (this.b != null) {
            com.zk_oaction.adengine.lk_variable.d dVar = this.m;
            dVar.b("" + (this.g.c() / this.f41983a.t));
            com.zk_oaction.adengine.lk_variable.d dVar2 = this.n;
            dVar2.b("" + (this.g.d() / this.f41983a.t));
            com.zk_oaction.adengine.lk_variable.d dVar3 = this.o;
            dVar3.b("" + (Math.sqrt((this.g.c() * this.g.c()) + (this.g.d() * this.g.d())) / this.f41983a.t));
        }
    }

    protected void a(int i) {
        if (this.i == i) {
            return;
        }
        this.i = i;
        if (this.b == null || i >= 3) {
            return;
        }
        com.zk_oaction.adengine.lk_variable.d dVar = this.p;
        dVar.b("" + i);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void a(String str) {
        int i;
        com.zk_oaction.adengine.lk_sdk.c cVar;
        String str2;
        String str3;
        if (str.equals("true")) {
            i = 0;
            this.g.a(0);
            Iterator<d> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().a(0);
            }
            if (this.b != null) {
                cVar = this.f41983a;
                str2 = this.b + ".visibility";
                str3 = "1";
                i = 0;
                cVar.a(str2, str3);
            }
            a(i);
        } else if (!str.equals("false")) {
            if (str.equals("toggle")) {
                a((String) null, this.i == 0 ? 0.0f : 1.0f);
            }
        } else {
            this.g.a(3);
            Iterator<d> it2 = this.h.iterator();
            while (it2.hasNext()) {
                it2.next().a(3);
            }
            i = 3;
            if (this.b != null) {
                cVar = this.f41983a;
                str2 = this.b + ".visibility";
                str3 = "0";
                i = 3;
                cVar.a(str2, str3);
            }
            a(i);
        }
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f) {
        if (str == null) {
            a(f);
        } else if (a(this.f, "always").equals(str)) {
            g();
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public boolean a(float f, float f2) {
        if (this.i == 3) {
            return false;
        }
        return this.g.a(f, f2);
    }

    public boolean a(XmlPullParser xmlPullParser, String str) {
        a(xmlPullParser);
        try {
            int next = xmlPullParser.next();
            while (next != 1) {
                if (next != 2) {
                    if (next == 3 && xmlPullParser.getName().equals(str)) {
                        if (this.h.size() == 1) {
                            this.g.f41994a = this.h.get(0).f41994a;
                        }
                        this.e.a(this);
                        this.f.a(this);
                        return true;
                    }
                } else if (xmlPullParser.getName().equals("StartPoint")) {
                    d dVar = new d(this.f41983a);
                    this.g = dVar;
                    if (!dVar.a(xmlPullParser, "StartPoint")) {
                        return false;
                    }
                } else if (xmlPullParser.getName().equals("EndPoint")) {
                    d dVar2 = new d(this.f41983a);
                    if (!dVar2.a(xmlPullParser, "EndPoint")) {
                        return false;
                    }
                    this.h.add(dVar2);
                }
                next = xmlPullParser.next();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void b(float f, float f2) {
        this.g.a(1);
        Iterator<d> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().a(1);
        }
        a(1);
        this.g.b(f, f2);
        this.f41983a.a(50L);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void b(String str) {
    }

    public boolean b() {
        return this.f.a() == 1.0f;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void c(float f, float f2) {
        a(f, f2, false);
        this.j = false;
        this.k = null;
        Iterator<d> it = this.h.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.a(this.g.e(), this.g.f())) {
                this.j = true;
                this.k = next;
                next.a(2);
            } else {
                next.a(1);
            }
        }
        if (!this.j) {
            if (this.g.b() != 1) {
                this.g.a(1);
                a(1);
            }
        } else if (this.g.b() != 2) {
            this.g.a(2);
            a(2);
            this.f41983a.a(50L);
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void c(String str) {
        a(str);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public boolean c() {
        return this.i == 3;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void d() {
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void d(float f, float f2) {
        if (this.j) {
            this.k.h();
        } else {
            this.f41983a.a(50L);
        }
        if (this.i == 2) {
            this.q.postDelayed(new a(), 100L);
        } else {
            this.g.a(this.f41984c.a(), this.d.a(), this, this.l);
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public String e() {
        return this.b;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void e(float f, float f2) {
        this.g.a(this.f41984c.a(), this.d.a(), this, this.l);
    }

    public void f() {
        this.f41983a.B = false;
        if (this.i != 3) {
            this.g.a(0);
            Iterator<d> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().a(0);
            }
            a(0);
        }
    }
}
