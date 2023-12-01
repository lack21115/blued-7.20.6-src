package android.media.effect.effects;

import android.filterpacks.imageproc.VignetteFilter;
import android.media.effect.EffectContext;
import android.media.effect.SingleFilterEffect;

/* loaded from: source-9557208-dex2jar.jar:android/media/effect/effects/VignetteEffect.class */
public class VignetteEffect extends SingleFilterEffect {
    public VignetteEffect(EffectContext effectContext, String str) {
        super(effectContext, str, VignetteFilter.class, "image", "image", new Object[0]);
    }
}
