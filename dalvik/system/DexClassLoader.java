package dalvik.system;

import java.io.File;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/DexClassLoader.class */
public class DexClassLoader extends BaseDexClassLoader {
    public DexClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, new File(str2), str3, classLoader);
    }
}
