package com.zk_oaction.adengine.lk_command;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_command/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public String f28224a;
    private com.zk_oaction.adengine.lk_sdk.c b;

    /* renamed from: c  reason: collision with root package name */
    private String f28225c;
    private String d;
    private String e;
    private com.zk_oaction.adengine.lk_sdk.interfaces.f f;
    private ArrayList<b> g = new ArrayList<>();

    public g(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.b = cVar;
    }

    private void a(XmlPullParser xmlPullParser) {
        String name = xmlPullParser.getName();
        b bVar = "Command".equals(name) ? new b(this.b) : "SoundCommand".equals(name) ? new f(this.b) : "VariableCommand".equals(name) ? new h(this.b) : "ExternCommand".equals(name) ? new c(this.b) : "IntentCommand".equals(name) ? new e(this.b) : "VideoCommand".equals(name) ? new i(this.b) : null;
        if (bVar == null || !bVar.a(xmlPullParser, "VariableCommand")) {
            return;
        }
        this.g.add(bVar);
    }

    public void a() {
        String str = this.f28225c;
        if (str != null) {
            com.zk_oaction.adengine.lk_sdk.interfaces.f fVar = this.b.p.get(str);
            this.f = fVar;
            if (fVar != null && this.d.equals("visibility")) {
                this.f.a(this.e);
            }
        }
        Iterator<b> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public boolean a(XmlPullParser xmlPullParser, String str) {
        this.f28224a = xmlPullParser.getAttributeValue(null, "action");
        this.f28225c = xmlPullParser.getAttributeValue(null, TypedValues.AttributesType.S_TARGET);
        this.d = xmlPullParser.getAttributeValue(null, "property");
        this.e = xmlPullParser.getAttributeValue(null, "value");
        try {
            int next = xmlPullParser.next();
            while (next != 1) {
                if (next == 2) {
                    a(xmlPullParser);
                } else if (next == 3 && xmlPullParser.getName().equals(str)) {
                    return true;
                }
                next = xmlPullParser.next();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
