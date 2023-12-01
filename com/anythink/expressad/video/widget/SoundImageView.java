package com.anythink.expressad.video.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.anythink.expressad.foundation.h.i;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/widget/SoundImageView.class */
public class SoundImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f5878a;

    public SoundImageView(Context context) {
        super(context);
        this.f5878a = true;
    }

    public SoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5878a = true;
    }

    public SoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5878a = true;
    }

    public boolean getStatus() {
        return this.f5878a;
    }

    public void setSoundStatus(boolean z) {
        this.f5878a = z;
        if (z) {
            setImageResource(i.a(getContext(), "anythink_reward_sound_open", i.f5112c));
        } else {
            setImageResource(i.a(getContext(), "anythink_reward_sound_close", i.f5112c));
        }
    }
}
