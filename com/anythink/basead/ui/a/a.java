package com.anythink.basead.ui.a;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/a/a.class */
public final class a {
    public static void a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = 0;
        view.setLayoutParams(layoutParams);
    }
}
