package com.soft.blued.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/sdk/SDKBrowserAction.class */
public class SDKBrowserAction extends SDKBaseAction {
    private final String f;

    public SDKBrowserAction(Intent intent) {
        super(intent);
        this.f = intent.getStringExtra("url");
    }

    @Override // com.soft.blued.sdk.SDKBaseAction
    protected void a(Context context) {
        if (!TextUtils.isEmpty(this.f)) {
            WebViewShowInfoFragment.show(context, this.f, -1);
        }
        b();
    }

    @Override // com.soft.blued.sdk.SDKBaseAction
    protected void b(Context context) {
    }
}
