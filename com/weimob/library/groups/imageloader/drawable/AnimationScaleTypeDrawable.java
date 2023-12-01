package com.weimob.library.groups.imageloader.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/drawable/AnimationScaleTypeDrawable.class */
public class AnimationScaleTypeDrawable extends ScaleTypeDrawable implements Animatable {
    private OnLevelChangeListener onLevelChangeListener;

    public AnimationScaleTypeDrawable(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        super(drawable, scaleType);
        if (!(drawable instanceof Animatable)) {
            throw new RuntimeException("ScaleTypeDrawable 参数必须是 Animatable");
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return ((Animatable) getCurrent()).isRunning();
    }

    protected boolean onLevelChange(int i) {
        OnLevelChangeListener onLevelChangeListener = this.onLevelChangeListener;
        if (onLevelChangeListener != null) {
            onLevelChangeListener.onLevelChange(i);
        }
        return super.onLevelChange(i);
    }

    public void setOnLevelChangeListener(OnLevelChangeListener onLevelChangeListener) {
        this.onLevelChangeListener = onLevelChangeListener;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        ((Animatable) getCurrent()).start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        ((Animatable) getCurrent()).stop();
    }
}
