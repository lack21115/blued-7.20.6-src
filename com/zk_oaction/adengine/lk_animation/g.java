package com.zk_oaction.adengine.lk_animation;

import com.cdo.oaps.ad.OapsKey;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_animation/g.class */
public class g extends b {

    /* renamed from: a  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_view.g f41900a;

    /* renamed from: c  reason: collision with root package name */
    private long f41901c;
    private ArrayList<a> b = new ArrayList<>();
    private String d = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_animation/g$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        String f41902a;
        long b;

        public a(String str, long j) {
            this.f41902a = str;
            this.b = j;
        }
    }

    public g(com.zk_oaction.adengine.lk_view.g gVar) {
        this.f41900a = gVar;
    }

    private void a(String str, long j) {
        this.b.add(new a(str, j));
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public long a() {
        return this.f41901c;
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public void a(long j) {
        int size = this.b.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size) {
                i = i2;
                break;
            } else if (j <= this.b.get(i).b) {
                break;
            } else {
                i2 = i;
                i++;
            }
        }
        a aVar = this.b.get(i);
        if (this.d.equals(aVar.f41902a)) {
            return;
        }
        String str = aVar.f41902a;
        this.d = str;
        this.f41900a.e(str);
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public boolean a(XmlPullParser xmlPullParser) {
        while (true) {
            try {
                int next = xmlPullParser.next();
                if (next == 1) {
                    return false;
                }
                if (next != 2) {
                    if (next == 3 && xmlPullParser.getName().equals("SourcesAnimation")) {
                        return true;
                    }
                } else if (xmlPullParser.getName().equals("Source")) {
                    String attributeValue = xmlPullParser.getAttributeValue(null, OapsKey.KEY_SRC);
                    long parseLong = Long.parseLong(xmlPullParser.getAttributeValue(null, "time"));
                    if (parseLong > this.f41901c) {
                        this.f41901c = parseLong;
                    }
                    a(attributeValue, parseLong);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (XmlPullParserException e2) {
                e2.printStackTrace();
                return false;
            }
        }
    }
}
