package android.media.effect.effects;

import android.filterpacks.imageproc.CropRectFilter;
import android.media.effect.EffectContext;
import android.media.effect.SizeChangeEffect;

/* loaded from: source-9557208-dex2jar.jar:android/media/effect/effects/CropEffect.class */
public class CropEffect extends SizeChangeEffect {
    public CropEffect(EffectContext effectContext, String str) {
        super(effectContext, str, CropRectFilter.class, "image", "image", new Object[0]);
    }
}
