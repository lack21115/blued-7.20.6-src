package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/ShaderKt.class */
public final class ShaderKt {
    public static final void transform(Shader shader, Function1<? super Matrix, Unit> block) {
        Intrinsics.e(shader, "<this>");
        Intrinsics.e(block, "block");
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        block.invoke(matrix);
        shader.setLocalMatrix(matrix);
    }
}
