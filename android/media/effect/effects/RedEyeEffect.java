package android.media.effect.effects;

import android.filterpacks.imageproc.RedEyeFilter;
import android.media.effect.EffectContext;
import android.media.effect.SingleFilterEffect;

/* loaded from: source-9557208-dex2jar.jar:android/media/effect/effects/RedEyeEffect.class */
public class RedEyeEffect extends SingleFilterEffect {
    public RedEyeEffect(EffectContext effectContext, String str) {
        super(effectContext, str, RedEyeFilter.class, "image", "image", new Object[0]);
    }
}
