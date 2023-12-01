package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.h;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/ShakeBorderThumbView.class */
public class ShakeBorderThumbView extends BaseShakeView {
    public ShakeBorderThumbView(Context context) {
        super(context);
    }

    public ShakeBorderThumbView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShakeBorderThumbView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ShakeBorderThumbView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.anythink.basead.ui.BaseShakeView
    final void a() {
        setOrientation(0);
        setGravity(17);
        setBackgroundResource(h.a(n.a().g(), "myoffer_bg_shake_border_thumb", "drawable"));
        LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_shake_border_thumb", "layout"), (ViewGroup) this, true);
        int a = h.a(getContext(), 10.0f);
        int a2 = h.a(getContext(), 12.0f);
        int a3 = h.a(getContext(), 6.0f);
        setPadding(a, a3, a2, a3);
    }
}
