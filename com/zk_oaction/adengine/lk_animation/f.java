package com.zk_oaction.adengine.lk_animation;

import com.baidu.mobads.sdk.api.IAdInterListener;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_animation/f.class */
public class f extends b {

    /* renamed from: a  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_sdk.interfaces.b f28205a;

    /* renamed from: c  reason: collision with root package name */
    private long f28206c;
    private ArrayList<a> b = new ArrayList<>();
    private float d = -1.0f;
    private float e = -1.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_animation/f$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        com.zk_oaction.adengine.lk_expression.a f28207a;
        com.zk_oaction.adengine.lk_expression.a b;

        /* renamed from: c  reason: collision with root package name */
        long f28208c;

        public a(com.zk_oaction.adengine.lk_expression.a aVar, com.zk_oaction.adengine.lk_expression.a aVar2, long j) {
            this.f28207a = aVar;
            this.b = aVar2;
            this.f28208c = j;
        }
    }

    public f(com.zk_oaction.adengine.lk_sdk.interfaces.b bVar) {
        this.f28205a = bVar;
    }

    private void a(com.zk_oaction.adengine.lk_expression.a aVar, com.zk_oaction.adengine.lk_expression.a aVar2, long j) {
        this.b.add(new a(aVar, aVar2, j));
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public long a() {
        return this.f28206c;
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public void a(long j) {
        int size = this.b.size();
        float f = 0.0f;
        long j2 = 0;
        float f2 = 0.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            a aVar = this.b.get(i2);
            long j3 = aVar.f28208c;
            int i3 = (j > j3 ? 1 : (j == j3 ? 0 : -1));
            if (i3 <= 0) {
                if (i3 == 0) {
                    if (Float.valueOf(aVar.f28207a.a()).equals(Float.valueOf(this.d)) && Float.valueOf(aVar.b.a()).equals(Float.valueOf(this.e))) {
                        return;
                    }
                    this.f28205a.h(aVar.f28207a.a(), aVar.b.a());
                    this.d = aVar.f28207a.a();
                    this.e = aVar.b.a();
                    return;
                }
                float f3 = ((float) (j - j2)) / ((float) (j3 - j2));
                float a2 = ((aVar.f28207a.a() - f) * f3) + f;
                float a3 = ((aVar.b.a() - f2) * f3) + f2;
                if (Float.valueOf(a2).equals(Float.valueOf(this.d)) && Float.valueOf(a3).equals(Float.valueOf(this.e))) {
                    return;
                }
                this.f28205a.h(a2, a3);
                this.d = a2;
                this.e = a3;
                return;
            }
            f = aVar.f28207a.a();
            f2 = aVar.b.a();
            j2 = aVar.f28208c;
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
                    if (next == 3 && xmlPullParser.getName().equals("SizeAnimation")) {
                        return true;
                    }
                } else if (xmlPullParser.getName().equals("Size")) {
                    com.zk_oaction.adengine.lk_expression.a aVar = new com.zk_oaction.adengine.lk_expression.a(this.f28205a.b(), null, xmlPullParser.getAttributeValue(null, IAdInterListener.AdReqParam.WIDTH), 0.0f, null, true);
                    com.zk_oaction.adengine.lk_expression.a aVar2 = new com.zk_oaction.adengine.lk_expression.a(this.f28205a.b(), null, xmlPullParser.getAttributeValue(null, "h"), 0.0f, null, true);
                    long parseLong = Long.parseLong(xmlPullParser.getAttributeValue(null, "time"));
                    if (parseLong > this.f28206c) {
                        this.f28206c = parseLong;
                    }
                    a(aVar, aVar2, parseLong);
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
