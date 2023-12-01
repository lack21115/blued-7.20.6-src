package com.zk_oaction.adengine.lk_animation;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_animation/a.class */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_sdk.interfaces.b f41881a;

    /* renamed from: c  reason: collision with root package name */
    private long f41882c;
    private ArrayList<C1102a> b = new ArrayList<>();
    private float d = -1.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.zk_oaction.adengine.lk_animation.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_animation/a$a.class */
    public static class C1102a {

        /* renamed from: a  reason: collision with root package name */
        com.zk_oaction.adengine.lk_expression.a f41883a;
        long b;

        public C1102a(com.zk_oaction.adengine.lk_expression.a aVar, long j) {
            this.f41883a = aVar;
            this.b = j;
        }
    }

    public a(com.zk_oaction.adengine.lk_sdk.interfaces.b bVar) {
        this.f41881a = bVar;
    }

    private void a(com.zk_oaction.adengine.lk_expression.a aVar, long j) {
        this.b.add(new C1102a(aVar, j));
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public long a() {
        return this.f41882c;
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public void a(long j) {
        int size = this.b.size();
        float f = 0.0f;
        long j2 = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            C1102a c1102a = this.b.get(i2);
            long j3 = c1102a.b;
            int i3 = (j > j3 ? 1 : (j == j3 ? 0 : -1));
            if (i3 <= 0) {
                if (i3 == 0) {
                    if (Float.valueOf(c1102a.f41883a.a()).equals(Float.valueOf(this.d))) {
                        return;
                    }
                    this.f41881a.a(c1102a.f41883a.a());
                    this.d = c1102a.f41883a.a();
                    return;
                }
                float a2 = ((c1102a.f41883a.a() - f) * (((float) (j - j2)) / ((float) (j3 - j2)))) + f;
                if (Float.valueOf(a2).equals(Float.valueOf(this.d))) {
                    return;
                }
                this.f41881a.a(a2);
                this.d = a2;
                return;
            }
            f = c1102a.f41883a.a();
            j2 = c1102a.b;
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
                    if (next == 3 && xmlPullParser.getName().equals("AlphaAnimation")) {
                        return true;
                    }
                } else if (xmlPullParser.getName().equals("Alpha")) {
                    com.zk_oaction.adengine.lk_expression.a aVar = new com.zk_oaction.adengine.lk_expression.a(this.f41881a.b(), null, xmlPullParser.getAttributeValue(null, "a"), 0.0f, null, false);
                    long parseLong = Long.parseLong(xmlPullParser.getAttributeValue(null, "time"));
                    if (parseLong > this.f41882c) {
                        this.f41882c = parseLong;
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
