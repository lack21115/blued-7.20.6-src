package dalvik.system;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/PathClassLoader.class */
public class PathClassLoader extends BaseDexClassLoader {
    public PathClassLoader(String str, ClassLoader classLoader) {
        super(str, null, null, classLoader);
    }

    public PathClassLoader(String str, String str2, ClassLoader classLoader) {
        super(str, null, str2, classLoader);
    }
}
