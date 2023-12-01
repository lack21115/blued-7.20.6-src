package android.media.effect.effects;

import android.filterpacks.imageproc.StraightenFilter;
import android.media.effect.EffectContext;
import android.media.effect.SingleFilterEffect;

/* loaded from: source-9557208-dex2jar.jar:android/media/effect/effects/StraightenEffect.class */
public class StraightenEffect extends SingleFilterEffect {
    public StraightenEffect(EffectContext effectContext, String str) {
        super(effectContext, str, StraightenFilter.class, "image", "image", new Object[0]);
    }
}
