package android.media.effect.effects;

import android.filterpacks.imageproc.RotateFilter;
import android.media.effect.EffectContext;
import android.media.effect.SizeChangeEffect;

/* loaded from: source-9557208-dex2jar.jar:android/media/effect/effects/RotateEffect.class */
public class RotateEffect extends SizeChangeEffect {
    public RotateEffect(EffectContext effectContext, String str) {
        super(effectContext, str, RotateFilter.class, "image", "image", new Object[0]);
    }
}
