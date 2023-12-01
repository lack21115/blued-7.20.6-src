package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.anythink.core.common.k.h;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/StarLevelView.class */
public class StarLevelView extends ImageView {
    Context a;

    public StarLevelView(Context context) {
        this(context, null);
        this.a = context;
    }

    public StarLevelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.a = context;
    }

    public StarLevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
    }

    public void setState(boolean z) {
        if (z) {
            setImageResource(h.a(getContext(), "myoffer_splash_star", "drawable"));
        } else {
            setImageResource(h.a(getContext(), "myoffer_splash_star_gray", "drawable"));
        }
    }
}
