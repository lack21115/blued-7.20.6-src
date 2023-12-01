package com.zk_oaction.adengine.lk_animation;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_animation/e.class */
public class e extends b {

    /* renamed from: a  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_sdk.interfaces.b f28202a;

    /* renamed from: c  reason: collision with root package name */
    private long f28203c;
    private int e;
    private ArrayList<a> b = new ArrayList<>();
    private float d = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_animation/e$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        com.zk_oaction.adengine.lk_expression.a f28204a;
        long b;

        public a(com.zk_oaction.adengine.lk_expression.a aVar, long j) {
            this.f28204a = aVar;
            this.b = j;
        }
    }

    public e(com.zk_oaction.adengine.lk_sdk.interfaces.b bVar) {
        this.f28202a = bVar;
    }

    private void a(com.zk_oaction.adengine.lk_expression.a aVar, long j) {
        this.b.add(new a(aVar, j));
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public long a() {
        return this.f28203c;
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
            a aVar = this.b.get(i2);
            long j3 = aVar.b;
            int i3 = (j > j3 ? 1 : (j == j3 ? 0 : -1));
            if (i3 <= 0) {
                if (i3 == 0) {
                    if (Float.valueOf(aVar.f28204a.a()).equals(Float.valueOf(this.d))) {
                        return;
                    }
                    int i4 = this.e;
                    if (i4 == 0) {
                        this.f28202a.b(aVar.f28204a.a());
                    } else if (i4 == 1) {
                        this.f28202a.c(aVar.f28204a.a());
                    } else if (i4 == 2) {
                        this.f28202a.d(aVar.f28204a.a());
                    }
                    this.d = aVar.f28204a.a();
                    return;
                }
                float a2 = ((aVar.f28204a.a() - f) * (((float) (j - j2)) / ((float) (j3 - j2)))) + f;
                if (Float.valueOf(a2).equals(Float.valueOf(this.d))) {
                    return;
                }
                int i5 = this.e;
                if (i5 == 0) {
                    this.f28202a.b(a2);
                } else if (i5 == 1) {
                    this.f28202a.c(a2);
                } else if (i5 == 2) {
                    this.f28202a.d(a2);
                }
                this.d = a2;
                return;
            }
            f = aVar.f28204a.a();
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
                if (next == 2) {
                    if (xmlPullParser.getName().equals("Rotation")) {
                        this.e = 0;
                    } else if (xmlPullParser.getName().equals("RotationX")) {
                        this.e = 1;
                    } else if (xmlPullParser.getName().equals("RotationY")) {
                        this.e = 2;
                    }
                    com.zk_oaction.adengine.lk_expression.a aVar = new com.zk_oaction.adengine.lk_expression.a(this.f28202a.b(), null, xmlPullParser.getAttributeValue(null, "angle"), 0.0f, null, false);
                    long parseLong = Long.parseLong(xmlPullParser.getAttributeValue(null, "time"));
                    if (parseLong > this.f28203c) {
                        this.f28203c = parseLong;
                    }
                    a(aVar, parseLong);
                } else if (next == 3 && xmlPullParser.getName().equals("RotationAnimation")) {
                    return true;
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
