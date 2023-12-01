package com.zk_oaction.adengine.lk_command;

import android.os.Handler;
import android.os.Looper;
import android.service.notification.Condition;
import com.blued.android.module.common.web.LoaderConstants;
import com.heytap.mcssdk.constant.IntentConstant;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_command/c.class */
public class c extends b {
    private String i;
    private Runnable j;

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_command/c$a.class */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.i.equals("unlock")) {
                c.this.f41909a.a(50L);
                c.this.f41909a.k.a();
            } else if (c.this.i.equals(LoaderConstants.VIBRATE)) {
                c.this.f41909a.a(50L);
            } else {
                String str = null;
                com.zk_oaction.adengine.lk_expression.c cVar = c.this.g;
                if (cVar != null) {
                    str = cVar.a();
                }
                c cVar2 = c.this;
                cVar2.f41909a.k.a(cVar2.i, c.this.f, str);
            }
        }
    }

    public c(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar);
        this.j = new a();
    }

    @Override // com.zk_oaction.adengine.lk_command.b
    public void a() {
        this.b.a((String) null, (String) null);
        if (this.b.a() != 0.0f) {
            if (this.d.a() != 1.0f || this.f41910c == 0) {
                this.j.run();
            } else {
                new Handler(Looper.getMainLooper()).postDelayed(this.j, this.f41910c);
            }
        }
    }

    @Override // com.zk_oaction.adengine.lk_command.b
    public boolean a(XmlPullParser xmlPullParser, String str) {
        try {
            this.i = xmlPullParser.getAttributeValue(null, IntentConstant.COMMAND);
            this.b = new com.zk_oaction.adengine.lk_expression.a(this.f41909a, null, xmlPullParser.getAttributeValue(null, Condition.SCHEME), 1.0f, null, false);
            String attributeValue = xmlPullParser.getAttributeValue(null, "delay");
            if (attributeValue != null) {
                this.f41910c = Integer.parseInt(attributeValue);
            }
            this.d = new com.zk_oaction.adengine.lk_expression.a(this.f41909a, null, xmlPullParser.getAttributeValue(null, "delayCondition"), 1.0f, null, false);
            a(xmlPullParser);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
