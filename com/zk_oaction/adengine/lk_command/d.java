package com.zk_oaction.adengine.lk_command;

import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_command/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    protected com.zk_oaction.adengine.lk_sdk.c f41913a;
    public ArrayList<g> b = new ArrayList<>();

    public d(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f41913a = cVar;
    }

    public void a(String str) {
        Iterator<g> it = this.b.iterator();
        while (it.hasNext()) {
            g next = it.next();
            String str2 = next.f41915a;
            if (str2 != null && str2.equals(str)) {
                next.a();
            }
        }
    }

    public boolean a(XmlPullParser xmlPullParser, String str) {
        while (true) {
            try {
                int next = xmlPullParser.next();
                if (next == 1) {
                    return false;
                }
                if (next != 2) {
                    if (next == 3 && xmlPullParser.getName().equals(str)) {
                        return true;
                    }
                } else if (xmlPullParser.getName().equals("Trigger")) {
                    g gVar = new g(this.f41913a);
                    if (gVar.a(xmlPullParser, "Trigger")) {
                        this.b.add(gVar);
                    }
                }
            } catch (XmlPullParserException e) {
                e.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
    }
}
