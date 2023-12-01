package com.zk_oaction.adengine.lk_animation;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_animation/a.class */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_sdk.interfaces.b f28190a;

    /* renamed from: c  reason: collision with root package name */
    private long f28191c;
    private ArrayList<C0932a> b = new ArrayList<>();
    private float d = -1.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.zk_oaction.adengine.lk_animation.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_animation/a$a.class */
    public static class C0932a {

        /* renamed from: a  reason: collision with root package name */
        com.zk_oaction.adengine.lk_expression.a f28192a;
        long b;

        public C0932a(com.zk_oaction.adengine.lk_expression.a aVar, long j) {
            this.f28192a = aVar;
            this.b = j;
        }
    }

    public a(com.zk_oaction.adengine.lk_sdk.interfaces.b bVar) {
        this.f28190a = bVar;
    }

    private void a(com.zk_oaction.adengine.lk_expression.a aVar, long j) {
        this.b.add(new C0932a(aVar, j));
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public long a() {
        return this.f28191c;
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
            C0932a c0932a = this.b.get(i2);
            long j3 = c0932a.b;
            int i3 = (j > j3 ? 1 : (j == j3 ? 0 : -1));
            if (i3 <= 0) {
                if (i3 == 0) {
                    if (Float.valueOf(c0932a.f28192a.a()).equals(Float.valueOf(this.d))) {
                        return;
                    }
                    this.f28190a.a(c0932a.f28192a.a());
                    this.d = c0932a.f28192a.a();
                    return;
                }
                float a2 = ((c0932a.f28192a.a() - f) * (((float) (j - j2)) / ((float) (j3 - j2)))) + f;
                if (Float.valueOf(a2).equals(Float.valueOf(this.d))) {
                    return;
                }
                this.f28190a.a(a2);
                this.d = a2;
                return;
            }
            f = c0932a.f28192a.a();
            j2 = c0932a.b;
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
                    com.zk_oaction.adengine.lk_expression.a aVar = new com.zk_oaction.adengine.lk_expression.a(this.f28190a.b(), null, xmlPullParser.getAttributeValue(null, "a"), 0.0f, null, false);
                    long parseLong = Long.parseLong(xmlPullParser.getAttributeValue(null, "time"));
                    if (parseLong > this.f28191c) {
                        this.f28191c = parseLong;
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
