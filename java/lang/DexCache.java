package java.lang;

import com.android.dex.Dex;
import java.lang.reflect.ArtField;
import java.lang.reflect.ArtMethod;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/lang/DexCache.class */
public final class DexCache {
    private volatile Dex dex;
    private long dexFile;
    String location;
    ArtField[] resolvedFields;
    ArtMethod[] resolvedMethods;
    Class[] resolvedTypes;
    String[] strings;

    private DexCache() {
    }

    private native Dex getDexNative();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Dex getDex() {
        Dex dex;
        Dex dex2 = this.dex;
        if (dex2 == null) {
            synchronized (this) {
                Dex dex3 = this.dex;
                dex = dex3;
                if (dex3 == null) {
                    dex = getDexNative();
                    this.dex = dex;
                }
            }
            return dex;
        }
        return dex2;
    }
}
