package com.zk_oaction.adengine.lk_command;

import android.os.Handler;
import android.service.notification.Condition;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_command/h.class */
public class h extends b {
    private String i;
    private String j;
    private com.zk_oaction.adengine.lk_expression.a k;
    private Runnable l;

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_command/h$a.class */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.k.a((String) null, (String) null);
            h hVar = h.this;
            hVar.f28218a.a(hVar.i, "" + h.this.k.a());
        }
    }

    public h(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar);
        this.l = new a();
    }

    @Override // com.zk_oaction.adengine.lk_command.b
    public void a() {
        this.b.a((String) null, (String) null);
        if (this.b.a() != 0.0f) {
            if (this.d.a() != 1.0f || this.f28219c == 0) {
                this.l.run();
            } else {
                new Handler().postDelayed(this.l, this.f28219c);
            }
        }
    }

    @Override // com.zk_oaction.adengine.lk_command.b
    public boolean a(XmlPullParser xmlPullParser, String str) {
        try {
            this.i = xmlPullParser.getAttributeValue(null, "name");
            this.j = xmlPullParser.getAttributeValue(null, "expression");
            this.k = new com.zk_oaction.adengine.lk_expression.a(this.f28218a, null, this.j, 0.0f, null, false);
            this.b = new com.zk_oaction.adengine.lk_expression.a(this.f28218a, null, xmlPullParser.getAttributeValue(null, Condition.SCHEME), 1.0f, null, false);
            String attributeValue = xmlPullParser.getAttributeValue(null, "delay");
            if (attributeValue != null) {
                this.f28219c = Integer.parseInt(attributeValue);
            }
            this.d = new com.zk_oaction.adengine.lk_expression.a(this.f28218a, null, xmlPullParser.getAttributeValue(null, "delayCondition"), 1.0f, null, false);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
