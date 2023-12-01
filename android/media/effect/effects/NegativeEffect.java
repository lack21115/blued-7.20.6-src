package android.media.effect.effects;

import android.filterpacks.imageproc.NegativeFilter;
import android.media.effect.EffectContext;
import android.media.effect.SingleFilterEffect;

/* loaded from: source-9557208-dex2jar.jar:android/media/effect/effects/NegativeEffect.class */
public class NegativeEffect extends SingleFilterEffect {
    public NegativeEffect(EffectContext effectContext, String str) {
        super(effectContext, str, NegativeFilter.class, "image", "image", new Object[0]);
    }
}
