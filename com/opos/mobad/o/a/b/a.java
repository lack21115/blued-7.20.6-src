package com.opos.mobad.o.a.b;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/a/b/a.class */
public class a extends PopupWindow {
    public a(Context context) {
        super(context);
        setClippingEnabled(false);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable());
    }

    public void a(View view, int i, int i2, View view2) {
        if (view == null || view2 == null) {
            return;
        }
        setFocusable(false);
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        getContentView().setSystemUiVisibility(view2.getRootView().getSystemUiVisibility());
        showAtLocation(view2, 17, 0, 0);
        setFocusable(true);
        update();
    }
}
