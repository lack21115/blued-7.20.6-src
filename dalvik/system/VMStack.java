package dalvik.system;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/VMStack.class */
public final class VMStack {
    public static native int fillStackTraceElements(Thread thread, StackTraceElement[] stackTraceElementArr);

    public static native ClassLoader getCallingClassLoader();

    public static native ClassLoader getClosestUserClassLoader(ClassLoader classLoader, ClassLoader classLoader2);

    public static Class<?> getStackClass1() {
        return getStackClass2();
    }

    public static native Class<?> getStackClass2();

    public static native StackTraceElement[] getThreadStackTrace(Thread thread);
}
