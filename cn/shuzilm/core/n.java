package cn.shuzilm.core;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/n.class */
public final class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4188a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f4189c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, String str, String str2) {
        this.f4188a = context;
        this.b = str;
        this.f4189c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        DUHelper dUHelper;
        JSONObject jSONObject;
        DUHelper dUHelper2;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        try {
            str = DUHelper.i;
            DUHelper.setConfig("apiKey", str);
            dUHelper = DUHelper.d;
            Context context = this.f4188a;
            jSONObject = DUHelper.l;
            dUHelper.a(context, jSONObject, this.b);
            dUHelper2 = DUHelper.d;
            jSONObject2 = DUHelper.k;
            dUHelper2.a(jSONObject2, this.f4189c);
            Context context2 = this.f4188a;
            jSONObject3 = DUHelper.l;
            String jSONObject5 = jSONObject3.toString();
            jSONObject4 = DUHelper.k;
            DUHelper.reportRun(context2, jSONObject5, jSONObject4.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }
}
