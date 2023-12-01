package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/PathDashPathEffect.class */
public class PathDashPathEffect extends PathEffect {

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/PathDashPathEffect$Style.class */
    public enum Style {
        TRANSLATE(0),
        ROTATE(1),
        MORPH(2);
        
        int native_style;

        Style(int i) {
            this.native_style = i;
        }
    }

    public PathDashPathEffect(Path path, float f, float f2, Style style) {
        this.native_instance = nativeCreate(path.ni(), f, f2, style.native_style);
    }

    private static native long nativeCreate(long j, float f, float f2, int i);
}
