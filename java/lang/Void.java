package java.lang;

import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/lang/Void.class */
public final class Void {
    public static final Class<Void> TYPE = lookupType();

    private Void() {
    }

    private static Class<Void> lookupType() {
        try {
            return Runnable.class.getMethod("run", EmptyArray.CLASS).getReturnType();
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}
