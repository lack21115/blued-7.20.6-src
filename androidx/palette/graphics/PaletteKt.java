package androidx.palette.graphics;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.palette.graphics.Palette;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/palette/graphics/PaletteKt.class */
public final class PaletteKt {
    public static final Palette.Swatch get(Palette palette, Target target) {
        Intrinsics.d(palette, "$receiver");
        Intrinsics.d(target, TypedValues.AttributesType.S_TARGET);
        return palette.getSwatchForTarget(target);
    }
}
