package android.media.effect.effects;

import android.filterpacks.imageproc.LomoishFilter;
import android.media.effect.EffectContext;
import android.media.effect.SingleFilterEffect;

/* loaded from: source-9557208-dex2jar.jar:android/media/effect/effects/LomoishEffect.class */
public class LomoishEffect extends SingleFilterEffect {
    public LomoishEffect(EffectContext effectContext, String str) {
        super(effectContext, str, LomoishFilter.class, "image", "image", new Object[0]);
    }
}
