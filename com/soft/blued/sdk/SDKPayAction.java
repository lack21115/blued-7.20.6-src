package com.soft.blued.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.blued.android.core.AppMethods;
import com.soft.blued.sdk.ui.SDKPayFragment;
import com.soft.blued.utils.Logger;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/sdk/SDKPayAction.class */
public class SDKPayAction extends SDKBaseAction {
    private int f;
    private String g;

    public SDKPayAction(Intent intent) {
        super(intent);
        this.f = 0;
        this.f = intent.getIntExtra("goods_id", 0);
        this.g = intent.getStringExtra("app_token");
        Logger.a("SDKAction", "goodsId:", Integer.valueOf(this.f), ", appToken:", this.g);
    }

    private Intent d() {
        Intent intent = new Intent("com.blued.android.sdk.action.pay_result", (Uri) null);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setPackage(this.e);
        intent.setFlags(67108864);
        return intent;
    }

    @Override // com.soft.blued.sdk.SDKBaseAction
    protected void a(Context context) {
        Logger.a("SDKAction", "startAction, action:", this);
        SDKPayFragment.a(context, this.f16059a, this.f, this.f16060c, this.d, null, null, this.g, null);
    }

    public void a(Context context, int i, int i2, int i3) {
        Logger.a("SDKAction", "payFinish, result:", Integer.valueOf(i), ", errorCode:", Integer.valueOf(i2), ", balance:", Integer.valueOf(i3), ", action:", this);
        if (c()) {
            return;
        }
        Intent d = d();
        d.putExtra("extra_result_int", i);
        if (i == 1) {
            d.putExtra("extra_error_code_int", i2);
        } else if (i == 0) {
            d.putExtra("extra_pay_balance_int", i3);
        }
        if (AppMethods.a(d)) {
            context.startActivity(d);
        }
        b();
    }

    @Override // com.soft.blued.sdk.SDKBaseAction
    protected void b(Context context) {
        Logger.a("SDKAction", "cancelAction, action:", this);
        a(context, 2, 0, 0);
    }

    @Override // com.soft.blued.sdk.SDKBaseAction
    public String toString() {
        return super.toString() + "[goodsId:" + this.f + "]";
    }
}
