package android.media.effect.effects;

import android.filterpacks.imageproc.FisheyeFilter;
import android.media.effect.EffectContext;
import android.media.effect.SingleFilterEffect;

/* loaded from: source-9557208-dex2jar.jar:android/media/effect/effects/FisheyeEffect.class */
public class FisheyeEffect extends SingleFilterEffect {
    public FisheyeEffect(EffectContext effectContext, String str) {
        super(effectContext, str, FisheyeFilter.class, "image", "image", new Object[0]);
    }
}
