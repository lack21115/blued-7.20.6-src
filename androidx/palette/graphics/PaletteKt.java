package androidx.palette.graphics;

import androidx.palette.graphics.Palette;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/palette/graphics/PaletteKt.class */
public final class PaletteKt {
    public static final Palette.Swatch get(Palette receiver, Target target) {
        Intrinsics.d(receiver, "$receiver");
        Intrinsics.d(target, "target");
        return receiver.getSwatchForTarget(target);
    }
}
