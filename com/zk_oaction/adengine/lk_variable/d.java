package com.zk_oaction.adengine.lk_variable;

import com.zk_oaction.adengine.lk_animation.i;
import com.zk_oaction.adengine.lk_expression.a;
import com.zk_oaction.adengine.lk_expression.c;
import java.util.AbstractCollection;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_variable/d.class */
public class d implements a.w, c.b {

    /* renamed from: a  reason: collision with root package name */
    public String f42008a;
    private com.zk_oaction.adengine.lk_sdk.c b;
    private String d;
    private String e;
    private float g;
    private ArrayList<com.zk_oaction.adengine.lk_command.g> i;
    private float h = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<f> f42009c = new ArrayList<>();
    private ArrayList<com.zk_oaction.adengine.lk_animation.b> f = new ArrayList<>();

    public d(com.zk_oaction.adengine.lk_sdk.c cVar, String str) {
        this.b = cVar;
        this.d = str;
        if (str != null) {
            str.equals("point_count");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [com.zk_oaction.adengine.lk_animation.b, com.zk_oaction.adengine.lk_animation.i] */
    /* JADX WARN: Type inference failed for: r0v23, types: [com.zk_oaction.adengine.lk_animation.c] */
    private void b(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_command.g gVar;
        AbstractCollection abstractCollection;
        if (xmlPullParser.getName().equals("VariableAnimation")) {
            ?? iVar = new i(this.b, this);
            if (!iVar.a(xmlPullParser)) {
                return;
            }
            this.b.o.a(iVar);
            abstractCollection = this.f;
            gVar = iVar;
        } else if (!xmlPullParser.getName().equals("Trigger")) {
            return;
        } else {
            com.zk_oaction.adengine.lk_command.g gVar2 = new com.zk_oaction.adengine.lk_command.g(this.b);
            if (!gVar2.a(xmlPullParser, "Trigger")) {
                return;
            }
            if (this.i == null) {
                this.i = new ArrayList<>();
            }
            gVar = gVar2;
            abstractCollection = this.i;
        }
        abstractCollection.add(gVar);
    }

    public void a(f fVar) {
        if (this.f42009c.contains(fVar)) {
            return;
        }
        this.f42009c.add(fVar);
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f) {
        b("" + f);
    }

    public boolean a() {
        String str = this.f42008a;
        return str == null || str.equals("number");
    }

    public boolean a(XmlPullParser xmlPullParser) {
        this.f42008a = xmlPullParser.getAttributeValue(null, "type");
        String attributeValue = xmlPullParser.getAttributeValue(null, "threshold");
        if (attributeValue != null) {
            try {
                this.g = Float.parseFloat(attributeValue);
                this.i = new ArrayList<>();
                String attributeValue2 = xmlPullParser.getAttributeValue(null, "thresholdtype");
                if (attributeValue2 != null) {
                    this.h = Float.parseFloat(attributeValue2);
                }
            } catch (Throwable th) {
            }
        }
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "expression");
        if (attributeValue3 != null) {
            if (a()) {
                com.zk_oaction.adengine.lk_expression.a aVar = new com.zk_oaction.adengine.lk_expression.a(this.b, this.d, attributeValue3, 0.0f, null, false);
                String str = this.d;
                if (str != null && this.b.a(str, aVar.f41919c)) {
                    aVar.a(this);
                }
            } else {
                new com.zk_oaction.adengine.lk_expression.c(this.b, attributeValue3, this);
            }
        }
        xmlPullParser.getAttributeValue(null, "persist");
        if (attributeValue3 != null && attributeValue3.indexOf("rand") == -1 && attributeValue3.indexOf("screen_width") == -1) {
            attributeValue3.indexOf("screen_height");
        }
        while (true) {
            try {
                int next = xmlPullParser.next();
                if (next == 1) {
                    return false;
                }
                if (next == 2) {
                    b(xmlPullParser);
                } else if (next == 3 && xmlPullParser.getName().equals("Var")) {
                    return true;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                return false;
            }
        }
    }

    public String b() {
        return this.e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ea, code lost:
        if (r0 == 0.0f) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bc A[Catch: Exception -> 0x00dc, TRY_ENTER, TryCatch #0 {Exception -> 0x00dc, blocks: (B:11:0x0051, B:13:0x0058, B:15:0x0060, B:17:0x0067, B:19:0x007c, B:22:0x0094, B:32:0x00bc, B:34:0x00c5, B:36:0x00cd, B:27:0x00a9), top: B:43:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_variable.d.b(java.lang.String):void");
    }

    public String c() {
        return this.d;
    }

    @Override // com.zk_oaction.adengine.lk_expression.c.b
    public void h_(String str) {
        b(str);
    }
}
