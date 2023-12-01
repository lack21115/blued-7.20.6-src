package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/PorterDuff.class */
public class PorterDuff {

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/PorterDuff$Mode.class */
    public enum Mode {
        CLEAR(0),
        SRC(1),
        DST(2),
        SRC_OVER(3),
        DST_OVER(4),
        SRC_IN(5),
        DST_IN(6),
        SRC_OUT(7),
        DST_OUT(8),
        SRC_ATOP(9),
        DST_ATOP(10),
        XOR(11),
        DARKEN(12),
        LIGHTEN(13),
        MULTIPLY(14),
        SCREEN(15),
        ADD(16),
        OVERLAY(17);
        
        public final int nativeInt;

        Mode(int i) {
            this.nativeInt = i;
        }
    }
}
