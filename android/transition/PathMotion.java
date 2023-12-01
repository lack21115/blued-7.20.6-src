package android.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;

/* loaded from: source-9557208-dex2jar.jar:android/transition/PathMotion.class */
public abstract class PathMotion {
    public PathMotion() {
    }

    public PathMotion(Context context, AttributeSet attributeSet) {
    }

    public abstract Path getPath(float f, float f2, float f3, float f4);
}
