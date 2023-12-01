package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.anythink.core.common.k.h;
import com.anythink.expressad.foundation.h.i;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/StarLevelView.class */
public class StarLevelView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    Context f6200a;

    public StarLevelView(Context context) {
        this(context, null);
        this.f6200a = context;
    }

    public StarLevelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.f6200a = context;
    }

    public StarLevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6200a = context;
    }

    public void setState(boolean z) {
        if (z) {
            setImageResource(h.a(getContext(), "myoffer_splash_star", i.f7952c));
        } else {
            setImageResource(h.a(getContext(), "myoffer_splash_star_gray", i.f7952c));
        }
    }
}
