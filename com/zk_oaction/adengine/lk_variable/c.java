package com.zk_oaction.adengine.lk_variable;

import com.zk_oaction.adengine.lk_expression.a;
import com.zk_oaction.adengine.lk_expression.c;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_variable/c.class */
public class c implements a.w, c.b {

    /* renamed from: a  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_sdk.c f28315a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<d> f28316c = new ArrayList<>();
    private ArrayList<String> d = new ArrayList<>();
    private ArrayList<String> e = new ArrayList<>();
    private ArrayList<com.zk_oaction.adengine.lk_expression.c> f = new ArrayList<>();
    private ArrayList<com.zk_oaction.adengine.lk_expression.a> g = new ArrayList<>();

    public c(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f28315a = cVar;
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f) {
        String substring = str.substring(0, str.lastIndexOf(46));
        Iterator<d> it = this.f28316c.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.c().equals(substring) && f >= 0.0f && f < this.e.size()) {
                next.b(this.e.get((int) f));
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean a(XmlPullParser xmlPullParser) {
        ArrayList arrayList;
        com.zk_oaction.adengine.lk_expression.c cVar;
        this.b = xmlPullParser.getAttributeValue(null, "type");
        try {
            int next = xmlPullParser.next();
            while (next != 1) {
                if (next == 2) {
                    if (xmlPullParser.getName().equals("Var")) {
                        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
                        d a2 = this.f28315a.n.a(attributeValue);
                        d dVar = a2;
                        if (a2 == null) {
                            dVar = new d(this.f28315a, attributeValue);
                            this.f28315a.n.a(dVar);
                        }
                        dVar.f28317a = this.b;
                        this.f28316c.add(dVar);
                        arrayList = this.d;
                        cVar = xmlPullParser.getAttributeValue(null, "index");
                    } else if (xmlPullParser.getName().equals("Item")) {
                        String attributeValue2 = xmlPullParser.getAttributeValue(null, "value");
                        if (attributeValue2.contains("@")) {
                            com.zk_oaction.adengine.lk_expression.c cVar2 = new com.zk_oaction.adengine.lk_expression.c(this.f28315a, attributeValue2, this);
                            this.e.add(cVar2.a());
                            arrayList = this.f;
                            cVar = cVar2;
                        } else {
                            this.e.add(attributeValue2);
                            this.f.add(null);
                        }
                    }
                    arrayList.add(cVar);
                } else if (next == 3 && xmlPullParser.getName().equals("VarArray")) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= this.f28316c.size()) {
                            return true;
                        }
                        d dVar2 = this.f28316c.get(i2);
                        ArrayList<com.zk_oaction.adengine.lk_expression.a> arrayList2 = this.g;
                        com.zk_oaction.adengine.lk_sdk.c cVar3 = this.f28315a;
                        arrayList2.add(new com.zk_oaction.adengine.lk_expression.a(cVar3, dVar2.c() + ".index", this.d.get(i2), 0.0f, this, false));
                        i = i2 + 1;
                    }
                }
                next = xmlPullParser.next();
            }
            return false;
        } catch (XmlPullParserException e) {
            e.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.zk_oaction.adengine.lk_expression.c.b
    public void h_(String str) {
        Iterator<com.zk_oaction.adengine.lk_expression.c> it = this.f.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            com.zk_oaction.adengine.lk_expression.c next = it.next();
            if (next != null && next.a().equals(str)) {
                this.e.remove(i2);
                this.e.add(i2, str);
                break;
            }
            i = i2 + 1;
        }
        Iterator<com.zk_oaction.adengine.lk_expression.a> it2 = this.g.iterator();
        while (it2.hasNext()) {
            com.zk_oaction.adengine.lk_expression.a next2 = it2.next();
            a(next2.f28227a, next2.a());
        }
    }
}
