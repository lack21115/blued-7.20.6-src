package cn.shuzilm.core;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/h.class */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4183a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, String str) {
        this.f4183a = context;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject;
        try {
            Context context = this.f4183a;
            jSONObject = DUHelper.l;
            DUHelper.dGZvcmRQ(context, jSONObject.toString(), this.b);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }
}
