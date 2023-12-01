package android.media.effect.effects;

import android.filterfw.core.Frame;
import android.media.effect.EffectContext;
import android.media.effect.FilterEffect;

/* loaded from: source-9557208-dex2jar.jar:android/media/effect/effects/IdentityEffect.class */
public class IdentityEffect extends FilterEffect {
    public IdentityEffect(EffectContext effectContext, String str) {
        super(effectContext, str);
    }

    @Override // android.media.effect.Effect
    public void apply(int i, int i2, int i3, int i4) {
        beginGLEffect();
        Frame frameFromTexture = frameFromTexture(i, i2, i3);
        Frame frameFromTexture2 = frameFromTexture(i4, i2, i3);
        frameFromTexture2.setDataFromFrame(frameFromTexture);
        frameFromTexture.release();
        frameFromTexture2.release();
        endGLEffect();
    }

    @Override // android.media.effect.Effect
    public void release() {
    }

    @Override // android.media.effect.Effect
    public void setParameter(String str, Object obj) {
        throw new IllegalArgumentException("Unknown parameter " + str + " for IdentityEffect!");
    }
}
