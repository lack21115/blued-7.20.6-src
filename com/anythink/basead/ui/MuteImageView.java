package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/MuteImageView.class */
public class MuteImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6140a;

    public MuteImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6140a = false;
    }

    public void setMute(boolean z) {
        if (z) {
            setSelected(true);
        } else {
            setSelected(false);
        }
    }
}
