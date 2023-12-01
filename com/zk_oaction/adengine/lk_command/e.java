package com.zk_oaction.adengine.lk_command;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.service.notification.Condition;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_command/e.class */
public class e extends b {
    private Intent i;
    private Runnable j;

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_command/e$a.class */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e eVar = e.this;
                eVar.f28218a.k.a(eVar.i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public e(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar);
        this.j = new a();
    }

    private void b(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        try {
            if (attributeValue != null) {
                this.i = (Intent) Intent.parseUri(attributeValue, 0).clone();
                return;
            }
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "selectIntent");
            if (attributeValue2 != null) {
                int lastIndexOf = attributeValue2.lastIndexOf("#Intent");
                Intent parseUri = Intent.parseUri(attributeValue2.substring(0, lastIndexOf - 1), 0);
                Intent intent = parseUri;
                if (this.f28218a.j.getPackageManager().queryIntentActivities(parseUri, 0).isEmpty()) {
                    intent = Intent.parseUri(attributeValue2.substring(lastIndexOf), 0);
                }
                this.i = (Intent) intent.clone();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void c(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "action");
        if (attributeValue != null) {
            this.i.setAction(attributeValue);
        }
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "uri");
        if (attributeValue2 != null) {
            this.i.setData(Uri.parse(attributeValue2));
        }
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "type");
        if (attributeValue3 != null) {
            this.i.setType(attributeValue3);
        }
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "category");
        if (attributeValue4 != null) {
            this.i.addCategory(attributeValue4);
        }
        String attributeValue5 = xmlPullParser.getAttributeValue(null, "package");
        String attributeValue6 = xmlPullParser.getAttributeValue(null, "class");
        if (attributeValue5 != null && attributeValue6 != null) {
            this.i.setClassName(attributeValue5, attributeValue6);
        }
        this.b = new com.zk_oaction.adengine.lk_expression.a(this.f28218a, null, xmlPullParser.getAttributeValue(null, Condition.SCHEME), 1.0f, null, false);
        String attributeValue7 = xmlPullParser.getAttributeValue(null, "delay");
        if (attributeValue7 != null) {
            this.f28219c = Integer.parseInt(attributeValue7);
        }
        this.d = new com.zk_oaction.adengine.lk_expression.a(this.f28218a, null, xmlPullParser.getAttributeValue(null, "delayCondition"), 1.0f, null, false);
    }

    @Override // com.zk_oaction.adengine.lk_command.b
    public void a() {
        this.b.a((String) null, (String) null);
        if (this.b.a() != 0.0f) {
            if (this.d.a() != 1.0f || this.f28219c == 0) {
                this.j.run();
            } else {
                new Handler().postDelayed(this.j, this.f28219c);
            }
        }
    }

    @Override // com.zk_oaction.adengine.lk_command.b
    public boolean a(XmlPullParser xmlPullParser, String str) {
        try {
            this.i = new Intent();
            b(xmlPullParser);
            this.i.addFlags(268435456);
            c(xmlPullParser);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
