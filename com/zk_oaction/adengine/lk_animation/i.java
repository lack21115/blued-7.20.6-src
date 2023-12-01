package com.zk_oaction.adengine.lk_animation;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_animation/i.class */
public class i extends b {

    /* renamed from: a  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_sdk.c f41904a;
    private com.zk_oaction.adengine.lk_variable.d b;
    private long d;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<a> f41905c = new ArrayList<>();
    private float e = Float.MAX_VALUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_animation/i$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        com.zk_oaction.adengine.lk_expression.a f41906a;
        long b;

        public a(com.zk_oaction.adengine.lk_expression.a aVar, long j) {
            this.f41906a = aVar;
            this.b = j;
        }
    }

    public i(com.zk_oaction.adengine.lk_sdk.c cVar, com.zk_oaction.adengine.lk_variable.d dVar) {
        this.f41904a = cVar;
        this.b = dVar;
        b();
    }

    private void a(com.zk_oaction.adengine.lk_expression.a aVar, long j) {
        this.f41905c.add(new a(aVar, j));
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public long a() {
        return this.d;
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public void a(long j) {
        int size = this.f41905c.size();
        float f = 0.0f;
        long j2 = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            a aVar = this.f41905c.get(i2);
            long j3 = aVar.b;
            int i3 = (j > j3 ? 1 : (j == j3 ? 0 : -1));
            if (i3 <= 0) {
                if (i3 == 0) {
                    if (Float.valueOf(aVar.f41906a.a()).equals(Float.valueOf(this.e))) {
                        return;
                    }
                    this.b.b("" + aVar.f41906a.a());
                    this.e = aVar.f41906a.a();
                    return;
                }
                float a2 = ((aVar.f41906a.a() - f) * (((float) (j - j2)) / ((float) (j3 - j2)))) + f;
                if (Float.valueOf(a2).equals(Float.valueOf(this.e))) {
                    return;
                }
                this.b.b("" + a2);
                this.e = a2;
                return;
            }
            f = aVar.f41906a.a();
            j2 = aVar.b;
            i = i2 + 1;
        }
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
                    if (next == 3 && xmlPullParser.getName().equals("VariableAnimation")) {
                        return true;
                    }
                } else if (xmlPullParser.getName().equals("AniFrame")) {
                    com.zk_oaction.adengine.lk_expression.a aVar = new com.zk_oaction.adengine.lk_expression.a(this.f41904a, null, xmlPullParser.getAttributeValue(null, "value"), 0.0f, null, false);
                    long parseLong = Long.parseLong(xmlPullParser.getAttributeValue(null, "time"));
                    if (parseLong > this.d) {
                        this.d = parseLong;
                    }
                    a(aVar, parseLong);
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
