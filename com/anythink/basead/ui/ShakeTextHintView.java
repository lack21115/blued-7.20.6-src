package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.anythink.core.common.k.h;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/ShakeTextHintView.class */
public class ShakeTextHintView extends BaseShakeView {
    public ShakeTextHintView(Context context) {
        super(context);
    }

    public ShakeTextHintView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShakeTextHintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ShakeTextHintView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.anythink.basead.ui.BaseShakeView
    final void a() {
        setOrientation(0);
        setGravity(17);
        LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_shake_text_hint", "layout"), (ViewGroup) this, true);
        int a2 = h.a(getContext(), 4.0f);
        setPadding(a2, a2, a2, a2);
    }
}
