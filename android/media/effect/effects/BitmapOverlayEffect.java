package android.media.effect.effects;

import android.filterpacks.imageproc.BitmapOverlayFilter;
import android.media.effect.EffectContext;
import android.media.effect.SingleFilterEffect;

/* loaded from: source-9557208-dex2jar.jar:android/media/effect/effects/BitmapOverlayEffect.class */
public class BitmapOverlayEffect extends SingleFilterEffect {
    public BitmapOverlayEffect(EffectContext effectContext, String str) {
        super(effectContext, str, BitmapOverlayFilter.class, "image", "image", new Object[0]);
    }
}
