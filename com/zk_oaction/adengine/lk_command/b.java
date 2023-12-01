package com.zk_oaction.adengine.lk_command;

import android.os.Handler;
import android.service.notification.Condition;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.blued.android.chat.core.pack.ReqAckPackage;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_command/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    protected com.zk_oaction.adengine.lk_sdk.c f41909a;
    protected com.zk_oaction.adengine.lk_expression.a b;

    /* renamed from: c  reason: collision with root package name */
    protected int f41910c;
    protected com.zk_oaction.adengine.lk_expression.a d;
    protected String e;
    protected com.zk_oaction.adengine.lk_expression.c g;
    protected String h;
    private String i;
    private String j;
    private String k;
    protected int f = -1;
    private Runnable l = new a();

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_command/b$a.class */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            com.zk_oaction.adengine.lk_sdk.interfaces.f fVar = bVar.f41909a.p.get(bVar.i);
            if (fVar != null) {
                if (b.this.j.equals("visibility")) {
                    fVar.a(b.this.k);
                } else if (b.this.j.equals(ReqAckPackage.REQ_RESPONSE_KEY.ANIMATION)) {
                    fVar.b(b.this.k);
                } else if (b.this.j.equals("clickable")) {
                    fVar.c(b.this.k);
                } else {
                    try {
                        ((com.zk_oaction.adengine.lk_view.b) fVar).a(b.this.j, Float.parseFloat(b.this.k));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public b(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f41909a = cVar;
    }

    public void a() {
        this.b.a((String) null, (String) null);
        if (this.b.a() != 0.0f) {
            if (this.d.a() != 1.0f || this.f41910c == 0) {
                this.l.run();
            } else {
                new Handler().postDelayed(this.l, this.f41910c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(XmlPullParser xmlPullParser) {
        try {
            String attributeValue = xmlPullParser.getAttributeValue(null, "scenetype");
            if (attributeValue != null) {
                this.f = Integer.parseInt(attributeValue);
            }
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "extend");
            if (attributeValue2 != null) {
                this.g = new com.zk_oaction.adengine.lk_expression.c(this.f41909a, attributeValue2, null);
            }
            this.h = xmlPullParser.getAttributeValue(null, "report");
            this.e = xmlPullParser.getAttributeValue(null, "scene");
        } catch (Throwable th) {
        }
    }

    public boolean a(XmlPullParser xmlPullParser, String str) {
        try {
            String attributeValue = xmlPullParser.getAttributeValue(null, TypedValues.AttributesType.S_TARGET);
            int indexOf = attributeValue.indexOf(46);
            this.i = attributeValue.substring(0, indexOf);
            this.j = attributeValue.substring(indexOf + 1);
            this.k = xmlPullParser.getAttributeValue(null, "value");
            this.b = new com.zk_oaction.adengine.lk_expression.a(this.f41909a, null, xmlPullParser.getAttributeValue(null, Condition.SCHEME), 1.0f, null, false);
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "delay");
            if (attributeValue2 != null) {
                this.f41910c = Integer.parseInt(attributeValue2);
            }
            this.d = new com.zk_oaction.adengine.lk_expression.a(this.f41909a, null, xmlPullParser.getAttributeValue(null, "delayCondition"), 1.0f, null, false);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
