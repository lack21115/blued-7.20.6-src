package android.media.effect.effects;

import android.filterpacks.imageproc.TintFilter;
import android.media.effect.EffectContext;
import android.media.effect.SingleFilterEffect;

/* loaded from: source-9557208-dex2jar.jar:android/media/effect/effects/TintEffect.class */
public class TintEffect extends SingleFilterEffect {
    public TintEffect(EffectContext effectContext, String str) {
        super(effectContext, str, TintFilter.class, "image", "image", new Object[0]);
    }
}
