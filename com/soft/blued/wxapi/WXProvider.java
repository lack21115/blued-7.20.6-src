package com.soft.blued.wxapi;

import android.content.Context;
import android.content.Intent;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/wxapi/WXProvider.class */
public class WXProvider {

    /* renamed from: a  reason: collision with root package name */
    private static WXProvider f34880a;
    private ILoginCallback b;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/wxapi/WXProvider$ILoginCallback.class */
    public interface ILoginCallback {
        void a();

        void a(WXLoginBean wXLoginBean);

        void b();
    }

    public static WXProvider a() {
        if (f34880a == null) {
            f34880a = new WXProvider();
        }
        return f34880a;
    }

    public void a(int i, WXLoginBean wXLoginBean) {
        if (i == 0) {
            ILoginCallback iLoginCallback = this.b;
            if (iLoginCallback != null) {
                iLoginCallback.a(wXLoginBean);
            }
        } else if (i != 1) {
            ILoginCallback iLoginCallback2 = this.b;
            if (iLoginCallback2 != null) {
                iLoginCallback2.b();
            }
        } else {
            ILoginCallback iLoginCallback3 = this.b;
            if (iLoginCallback3 != null) {
                iLoginCallback3.a();
            }
        }
    }

    public void a(Context context) {
        Intent intent = new Intent(context, WXEntryActivity.class);
        intent.putExtra("intent_mode", "intent_mode_login");
        context.startActivity(intent);
    }

    public void a(ILoginCallback iLoginCallback) {
        this.b = iLoginCallback;
    }

    public void b() {
        this.b = null;
    }
}
