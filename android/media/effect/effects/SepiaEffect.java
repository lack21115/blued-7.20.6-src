package android.media.effect.effects;

import android.filterpacks.imageproc.SepiaFilter;
import android.media.effect.EffectContext;
import android.media.effect.SingleFilterEffect;

/* loaded from: source-9557208-dex2jar.jar:android/media/effect/effects/SepiaEffect.class */
public class SepiaEffect extends SingleFilterEffect {
    public SepiaEffect(EffectContext effectContext, String str) {
        super(effectContext, str, SepiaFilter.class, "image", "image", new Object[0]);
    }
}
