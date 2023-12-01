package android.media.effect;

import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.format.ImageFormat;

/* loaded from: source-9557208-dex2jar.jar:android/media/effect/FilterEffect.class */
public abstract class FilterEffect extends Effect {
    protected EffectContext mEffectContext;
    private String mName;

    /* JADX INFO: Access modifiers changed from: protected */
    public FilterEffect(EffectContext effectContext, String str) {
        this.mEffectContext = effectContext;
        this.mName = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void beginGLEffect() {
        this.mEffectContext.assertValidGLState();
        this.mEffectContext.saveGLState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void endGLEffect() {
        this.mEffectContext.restoreGLState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Frame frameFromTexture(int i, int i2, int i3) {
        Frame newBoundFrame = getFilterContext().getFrameManager().newBoundFrame(ImageFormat.create(i2, i3, 3, 3), 100, i);
        newBoundFrame.setTimestamp(-1L);
        return newBoundFrame;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FilterContext getFilterContext() {
        return this.mEffectContext.mFilterContext;
    }

    @Override // android.media.effect.Effect
    public String getName() {
        return this.mName;
    }
}
