package com.tencent.tendinsv.view;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.cmic.gen.sdk.tencent.view.GenLoginAuthActivity;
import com.tencent.tendinsv.b;
import com.tencent.tendinsv.utils.l;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/view/CmccLoginActivity.class */
public class CmccLoginActivity extends GenLoginAuthActivity {
    private void d() {
        RelativeLayout relativeLayout;
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = 0;
        attributes.height = 0;
        window.setAttributes(attributes);
        ViewGroup viewGroup = (ViewGroup) ((ViewGroup) window.getDecorView().findViewById(16908290)).getChildAt(0);
        if (viewGroup == null || (relativeLayout = (RelativeLayout) viewGroup.findViewById(17476)) == null) {
            return;
        }
        relativeLayout.performClick();
    }

    @Override // com.cmic.gen.sdk.tencent.view.GenLoginAuthActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            d();
        } catch (Exception e) {
            l.d(b.F, "onCreate--Exception_e=", e);
            finish();
        }
    }
}
