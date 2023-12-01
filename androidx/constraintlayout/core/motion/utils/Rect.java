package androidx.constraintlayout.core.motion.utils;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/Rect.class */
public class Rect {
    public int bottom;
    public int left;
    public int right;
    public int top;

    public int height() {
        return this.bottom - this.top;
    }

    public int width() {
        return this.right - this.left;
    }
}
