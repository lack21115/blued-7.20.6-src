package com.zk_oaction.adengine.lk_command;

import android.graphics.RectF;
import com.huawei.hms.ads.fw;
import com.zk_oaction.adengine.lk_expression.a;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_command/a.class */
public class a implements a.w, com.zk_oaction.adengine.lk_sdk.interfaces.a, com.zk_oaction.adengine.lk_sdk.interfaces.f {

    /* renamed from: a  reason: collision with root package name */
    protected com.zk_oaction.adengine.lk_sdk.c f28216a;
    protected com.zk_oaction.adengine.lk_expression.a b;

    /* renamed from: c  reason: collision with root package name */
    protected com.zk_oaction.adengine.lk_expression.a f28217c;
    protected com.zk_oaction.adengine.lk_expression.a d;
    protected com.zk_oaction.adengine.lk_expression.a e;
    protected com.zk_oaction.adengine.lk_expression.a f;
    protected RectF g = new RectF();
    protected ArrayList<g> h = new ArrayList<>();
    protected com.zk_oaction.adengine.lk_unlock.c i;
    protected com.zk_oaction.adengine.lk_unlock.c j;
    protected String k;
    protected com.zk_oaction.adengine.lk_view.f l;
    protected boolean m;

    public a(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f28216a = cVar;
    }

    private void a(XmlPullParser xmlPullParser) {
        if ("Trigger".equals(xmlPullParser.getName())) {
            g gVar = new g(this.f28216a);
            if (gVar.a(xmlPullParser, "Trigger")) {
                this.h.add(gVar);
            }
        } else if (xmlPullParser.getName().equals("Normal")) {
            com.zk_oaction.adengine.lk_unlock.c cVar = new com.zk_oaction.adengine.lk_unlock.c(this.f28216a);
            this.i = cVar;
            cVar.a(this.l);
            if (this.i.a(xmlPullParser, "Normal")) {
                return;
            }
            this.i = null;
        } else if (xmlPullParser.getName().equals("Pressed")) {
            com.zk_oaction.adengine.lk_unlock.c cVar2 = new com.zk_oaction.adengine.lk_unlock.c(this.f28216a);
            this.j = cVar2;
            cVar2.a(this.l);
            if (this.j.a(xmlPullParser, "Pressed")) {
                return;
            }
            this.j = null;
        }
    }

    public String a(com.zk_oaction.adengine.lk_expression.a aVar, String str) {
        if (aVar != null) {
            str = aVar.f28227a;
        }
        return str;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void a() {
        Iterator<g> it = this.h.iterator();
        while (it.hasNext()) {
            g next = it.next();
            String str = next.f28224a;
            if (str != null && str.equals("double")) {
                next.a();
            }
        }
    }

    public void a(com.zk_oaction.adengine.lk_view.f fVar) {
        this.l = fVar;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void a(String str) {
        boolean z;
        if (str.equals(fw.Code)) {
            z = false;
        } else if (str.equals("false")) {
            this.m = true;
            return;
        } else if (!str.equals("toggle")) {
            return;
        } else {
            z = !this.m;
        }
        this.m = z;
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f) {
        if (str == null || !str.equals(a(this.f, "visibility"))) {
            b();
        } else {
            this.m = f <= 0.0f;
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public boolean a(float f, float f2) {
        return this.g.contains(f, f2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x00f6, code lost:
        r0 = r10.i;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00fc, code lost:
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00ff, code lost:
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0104, code lost:
        r0 = r10.j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0109, code lost:
        if (r0 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x010c, code lost:
        r0.a(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0112, code lost:
        r0 = r10.l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0117, code lost:
        if (r0 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x011a, code lost:
        r0.a(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0120, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(org.xmlpull.v1.XmlPullParser r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_command.a.a(org.xmlpull.v1.XmlPullParser, java.lang.String):boolean");
    }

    public void b() {
        com.zk_oaction.adengine.lk_expression.a aVar = this.b;
        if (aVar == null || this.f28217c == null || this.d == null || this.e == null) {
            return;
        }
        this.g.set(aVar.a(), this.f28217c.a(), this.b.a() + this.d.a(), this.f28217c.a() + this.e.a());
        com.zk_oaction.adengine.lk_view.f fVar = this.l;
        if (fVar != null) {
            this.g.offset(fVar.i(), this.l.j());
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void b(float f, float f2) {
        Iterator<g> it = this.h.iterator();
        while (it.hasNext()) {
            g next = it.next();
            String str = next.f28224a;
            if (str != null && str.equals("down")) {
                next.a();
            }
        }
        com.zk_oaction.adengine.lk_unlock.c cVar = this.j;
        if (cVar != null) {
            cVar.a();
        }
        com.zk_oaction.adengine.lk_unlock.c cVar2 = this.i;
        if (cVar2 != null) {
            cVar2.a(true);
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void b(String str) {
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void c(float f, float f2) {
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void c(String str) {
        a(str);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public boolean c() {
        boolean z = false;
        if (!this.m) {
            com.zk_oaction.adengine.lk_view.f fVar = this.l;
            if (fVar != null) {
                if (fVar.q() == 1.0f) {
                    return false;
                }
            }
            return z;
        }
        z = true;
        return z;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void d() {
        Iterator<g> it = this.h.iterator();
        while (it.hasNext()) {
            g next = it.next();
            String str = next.f28224a;
            if (str != null && str.equals("click")) {
                next.a();
            }
        }
        com.zk_oaction.adengine.lk_unlock.c cVar = this.j;
        if (cVar != null) {
            cVar.a(true);
        }
        com.zk_oaction.adengine.lk_unlock.c cVar2 = this.i;
        if (cVar2 != null) {
            cVar2.a();
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void d(float f, float f2) {
        Iterator<g> it = this.h.iterator();
        while (it.hasNext()) {
            g next = it.next();
            String str = next.f28224a;
            if (str != null && str.equals("up")) {
                next.a();
            }
        }
        com.zk_oaction.adengine.lk_unlock.c cVar = this.j;
        if (cVar != null) {
            cVar.a(true);
        }
        com.zk_oaction.adengine.lk_unlock.c cVar2 = this.i;
        if (cVar2 != null) {
            cVar2.a();
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public String e() {
        return this.k;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void e(float f, float f2) {
    }
}
