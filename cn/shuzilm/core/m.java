package cn.shuzilm.core;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/m.class */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4186a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f4187c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Context context, String str, String str2) {
        this.f4186a = context;
        this.b = str;
        this.f4187c = str2;
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
            Context context = this.f4186a;
            jSONObject = DUHelper.l;
            dUHelper.a(context, jSONObject, this.b);
            dUHelper2 = DUHelper.d;
            jSONObject2 = DUHelper.k;
            dUHelper2.a(jSONObject2, this.f4187c);
            Context context2 = this.f4186a;
            jSONObject3 = DUHelper.l;
            String jSONObject5 = jSONObject3.toString();
            jSONObject4 = DUHelper.k;
            DUHelper.run(context2, jSONObject5, jSONObject4.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }
}
