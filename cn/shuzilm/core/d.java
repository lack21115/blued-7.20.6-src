package cn.shuzilm.core;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/d.class */
public final class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, Context context) {
        this.a = str;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject;
        try {
            DUHelper.setConfig("f_pkg", this.a);
            Context context = this.b;
            jSONObject = DUHelper.l;
            DUHelper.onIEvent(context, jSONObject.toString(), null, null);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }
}
