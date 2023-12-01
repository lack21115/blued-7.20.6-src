package android.content.res;

import android.os.ParcelFileDescriptor;
import android.util.SparseArray;
import android.util.TypedValue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: source-9557208-dex2jar.jar:android/content/res/AssetManager.class */
public final class AssetManager implements AutoCloseable {
    public static final int ACCESS_BUFFER = 3;
    public static final int ACCESS_RANDOM = 1;
    public static final int ACCESS_STREAMING = 2;
    public static final int ACCESS_UNKNOWN = 0;
    private static final boolean DEBUG_REFS = false;
    static final int STYLE_ASSET_COOKIE = 2;
    static final int STYLE_CHANGING_CONFIGURATIONS = 4;
    static final int STYLE_DATA = 1;
    static final int STYLE_DENSITY = 5;
    static final int STYLE_NUM_ENTRIES = 6;
    static final int STYLE_RESOURCE_ID = 3;
    static final int STYLE_TYPE = 0;
    private static final String TAG = "AssetManager";
    private static final boolean localLOGV = false;
    private static final Object sSync = new Object();
    static AssetManager sSystem = null;
    private String mAppName;
    private int mCommonResCookie;
    private String mCommonResPackageName;
    private int mIconPackCookie;
    private String mIconPackageName;
    private int mNumRefs;
    private long mObject;
    private final long[] mOffsets;
    private boolean mOpen;
    private HashMap<Long, RuntimeException> mRefStacks;
    private StringBlock[] mStringBlocks;
    private ArrayList<Integer> mThemeCookies;
    private String mThemePackageName;
    private boolean mThemeSupport;
    private final TypedValue mValue;

    /* loaded from: source-9557208-dex2jar.jar:android/content/res/AssetManager$AssetInputStream.class */
    public final class AssetInputStream extends InputStream {
        private long mAsset;
        private long mLength;
        private long mMarkPos;

        private AssetInputStream(long j) {
            this.mAsset = j;
            this.mLength = AssetManager.this.getAssetLength(j);
        }

        @Override // java.io.InputStream
        public final int available() throws IOException {
            long assetRemainingLength = AssetManager.this.getAssetRemainingLength(this.mAsset);
            if (assetRemainingLength > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) assetRemainingLength;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            synchronized (AssetManager.this) {
                if (this.mAsset != 0) {
                    AssetManager.this.destroyAsset(this.mAsset);
                    this.mAsset = 0L;
                    AssetManager.this.decRefsLocked(hashCode());
                }
            }
        }

        protected void finalize() throws Throwable {
            close();
        }

        public final int getAssetInt() {
            throw new UnsupportedOperationException();
        }

        public final long getNativeAsset() {
            return this.mAsset;
        }

        @Override // java.io.InputStream
        public final void mark(int i) {
            this.mMarkPos = AssetManager.this.seekAsset(this.mAsset, 0L, 0);
        }

        @Override // java.io.InputStream
        public final boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public final int read() throws IOException {
            return AssetManager.this.readAssetChar(this.mAsset);
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr) throws IOException {
            return AssetManager.this.readAsset(this.mAsset, bArr, 0, bArr.length);
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i, int i2) throws IOException {
            return AssetManager.this.readAsset(this.mAsset, bArr, i, i2);
        }

        @Override // java.io.InputStream
        public final void reset() throws IOException {
            AssetManager.this.seekAsset(this.mAsset, this.mMarkPos, -1);
        }

        @Override // java.io.InputStream
        public final long skip(long j) throws IOException {
            long seekAsset = AssetManager.this.seekAsset(this.mAsset, 0L, 0);
            long j2 = j;
            if (seekAsset + j > this.mLength) {
                j2 = this.mLength - seekAsset;
            }
            if (j2 > 0) {
                AssetManager.this.seekAsset(this.mAsset, j2, 0);
            }
            return j2;
        }
    }

    public AssetManager() {
        this.mValue = new TypedValue();
        this.mOffsets = new long[2];
        this.mStringBlocks = null;
        this.mNumRefs = 1;
        this.mOpen = true;
        this.mThemeCookies = new ArrayList<>(2);
        synchronized (this) {
            init(false);
            ensureSystemAssets();
        }
    }

    private AssetManager(boolean z) {
        this.mValue = new TypedValue();
        this.mOffsets = new long[2];
        this.mStringBlocks = null;
        this.mNumRefs = 1;
        this.mOpen = true;
        this.mThemeCookies = new ArrayList<>(2);
        init(true);
    }

    private final native int addAssetPathNative(String str);

    private final native int addCommonOverlayPathNative(String str, String str2, String str3);

    private final native int addIconPathNative(String str, String str2, String str3, int i);

    private final native int addOverlayPathNative(String str, String str2, String str3, String str4, String str5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final native boolean applyStyle(long j, int i, int i2, long j2, int[] iArr, int[] iArr2, int[] iArr3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final native void applyThemeStyle(long j, int i, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final native void copyTheme(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public final void decRefsLocked(long j) {
        this.mNumRefs--;
        if (this.mNumRefs == 0) {
            destroy();
        }
    }

    private final native void deleteTheme(long j);

    private final native void destroy();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void destroyAsset(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final native void dumpTheme(long j, int i, String str, String str2);

    private static void ensureSystemAssets() {
        synchronized (sSync) {
            if (sSystem == null) {
                AssetManager assetManager = new AssetManager(true);
                assetManager.makeStringBlocks(null);
                sSystem = assetManager;
            }
        }
    }

    private final native int[] getArrayStringInfo(int i);

    private final native String[] getArrayStringResource(int i);

    public static final native String getAssetAllocations();

    /* JADX INFO: Access modifiers changed from: private */
    public final native long getAssetLength(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long getAssetRemainingLength(long j);

    public static final native int getGlobalAssetCount();

    public static final native int getGlobalAssetManagerCount();

    private final native long getNativeStringBlock(int i);

    private final native int getStringBlockCount();

    public static AssetManager getSystem() {
        ensureSystemAssets();
        return sSystem;
    }

    private final void incRefsLocked(long j) {
        this.mNumRefs++;
    }

    private final native void init(boolean z);

    private final native int loadResourceBagValue(int i, int i2, TypedValue typedValue, boolean z);

    private final native int loadResourceValue(int i, short s, TypedValue typedValue, boolean z);

    static final native int loadThemeAttributeValue(long j, int i, TypedValue typedValue, boolean z);

    private final native long newTheme();

    private final native long openAsset(String str, int i);

    private final native ParcelFileDescriptor openAssetFd(String str, long[] jArr) throws IOException;

    private native ParcelFileDescriptor openNonAssetFdNative(int i, String str, long[] jArr) throws IOException;

    private final native long openNonAssetNative(int i, String str, int i2);

    private final native long openXmlAssetNative(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public final native int readAsset(long j, byte[] bArr, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public final native int readAssetChar(long j);

    private final native boolean removeOverlayPathNative(String str, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final native boolean resolveAttrs(long j, int i, int i2, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long seekAsset(long j, long j2, int i);

    public final int addAssetPath(String str) {
        int addAssetPathNative;
        synchronized (this) {
            addAssetPathNative = addAssetPathNative(str);
            if (this.mStringBlocks != null) {
                makeStringBlocks(this.mStringBlocks);
            }
        }
        return addAssetPathNative;
    }

    public final int[] addAssetPaths(String[] strArr) {
        int[] iArr;
        if (strArr != null) {
            int[] iArr2 = new int[strArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                iArr = iArr2;
                if (i2 >= strArr.length) {
                    break;
                }
                iArr2[i2] = addAssetPath(strArr[i2]);
                i = i2 + 1;
            }
        } else {
            iArr = null;
        }
        return iArr;
    }

    public final int addCommonOverlayPath(String str, String str2, String str3) {
        int addCommonOverlayPathNative;
        synchronized (this) {
            addCommonOverlayPathNative = addCommonOverlayPathNative(str, str2, str3);
        }
        return addCommonOverlayPathNative;
    }

    public final int addIconPath(String str, String str2, String str3, int i) {
        int addIconPathNative;
        synchronized (this) {
            addIconPathNative = addIconPathNative(str, str2, str3, i);
        }
        return addIconPathNative;
    }

    public final int addOverlayPath(String str, String str2, String str3, String str4, String str5) {
        int addOverlayPathNative;
        synchronized (this) {
            addOverlayPathNative = addOverlayPathNative(str, str2, str3, str4, str5);
        }
        return addOverlayPathNative;
    }

    public void addThemeCookie(int i) {
        this.mThemeCookies.add(Integer.valueOf(i));
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.mOpen) {
                this.mOpen = false;
                decRefsLocked(hashCode());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long createTheme() {
        long newTheme;
        synchronized (this) {
            if (!this.mOpen) {
                throw new RuntimeException("Assetmanager has been closed");
            }
            newTheme = newTheme();
            incRefsLocked(newTheme);
        }
        return newTheme;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void ensureStringBlocks() {
        if (this.mStringBlocks == null) {
            synchronized (this) {
                if (this.mStringBlocks == null) {
                    makeStringBlocks(sSystem.mStringBlocks);
                }
            }
        }
    }

    protected void finalize() throws Throwable {
        try {
            destroy();
        } finally {
            super.finalize();
        }
    }

    public String getAppName() {
        return this.mAppName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final native int[] getArrayIntResource(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final native int getArraySize(int i);

    public final native SparseArray<String> getAssignedPackageIdentifiers();

    public final native int getBasePackageCount();

    public final native int getBasePackageId(int i);

    public final native String getBasePackageName(int i);

    public final native String getBaseResourcePackageName(int i);

    public int getCommonResCookie() {
        return this.mCommonResCookie;
    }

    public String getCommonResPackageName() {
        return this.mCommonResPackageName;
    }

    public final native String getCookieName(int i);

    public int getIconPackCookie() {
        return this.mIconPackCookie;
    }

    public String getIconPackageName() {
        return this.mIconPackageName;
    }

    public final native String[] getLocales();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CharSequence getPooledStringForCookie(int i, int i2) {
        return this.mStringBlocks[i - 1].get(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CharSequence getResourceBagText(int i, int i2) {
        synchronized (this) {
            TypedValue typedValue = this.mValue;
            int loadResourceBagValue = loadResourceBagValue(i, i2, typedValue, true);
            if (loadResourceBagValue >= 0) {
                if (typedValue.type == 3) {
                    return this.mStringBlocks[loadResourceBagValue].get(typedValue.data);
                }
                return typedValue.coerceToString();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final native String getResourceEntryName(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final native int getResourceIdentifier(String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final native String getResourceName(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final native String getResourcePackageName(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String[] getResourceStringArray(int i) {
        return getArrayStringResource(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CharSequence getResourceText(int i) {
        synchronized (this) {
            TypedValue typedValue = this.mValue;
            int loadResourceValue = loadResourceValue(i, (short) 0, typedValue, true);
            if (loadResourceValue >= 0) {
                if (typedValue.type == 3) {
                    return this.mStringBlocks[loadResourceValue].get(typedValue.data);
                }
                return typedValue.coerceToString();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CharSequence[] getResourceTextArray(int i) {
        int[] arrayStringInfo = getArrayStringInfo(i);
        int length = arrayStringInfo.length;
        CharSequence[] charSequenceArr = new CharSequence[length / 2];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 >= length) {
                return charSequenceArr;
            }
            int i5 = arrayStringInfo[i2];
            int i6 = arrayStringInfo[i2 + 1];
            charSequenceArr[i4] = i6 >= 0 ? this.mStringBlocks[i5].get(i6) : null;
            i2 += 2;
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final native String getResourceTypeName(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getResourceValue(int i, int i2, TypedValue typedValue, boolean z) {
        int loadResourceValue = loadResourceValue(i, (short) i2, typedValue, z);
        if (loadResourceValue >= 0) {
            if (typedValue.type != 3) {
                return true;
            }
            typedValue.string = this.mStringBlocks[loadResourceValue].get(typedValue.data);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final native int[] getStyleAttributes(int i);

    public ArrayList<Integer> getThemeCookies() {
        return this.mThemeCookies;
    }

    public String getThemePackageName() {
        return this.mThemePackageName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getThemeValue(long j, int i, TypedValue typedValue, boolean z) {
        int loadThemeAttributeValue = loadThemeAttributeValue(j, i, typedValue, z);
        if (loadThemeAttributeValue >= 0) {
            if (typedValue.type != 3) {
                return true;
            }
            StringBlock[] stringBlockArr = this.mStringBlocks;
            StringBlock[] stringBlockArr2 = stringBlockArr;
            if (stringBlockArr == null) {
                ensureStringBlocks();
                stringBlockArr2 = this.mStringBlocks;
            }
            typedValue.string = stringBlockArr2[loadThemeAttributeValue].get(typedValue.data);
            return true;
        }
        return false;
    }

    public final boolean hasThemeSupport() {
        return this.mThemeSupport;
    }

    public boolean hasThemedAssets() {
        return this.mThemeCookies.size() > 0;
    }

    public final native boolean isUpToDate();

    public final native String[] list(String str) throws IOException;

    final void makeStringBlocks(StringBlock[] stringBlockArr) {
        int length = stringBlockArr != null ? stringBlockArr.length : 0;
        int stringBlockCount = getStringBlockCount();
        this.mStringBlocks = new StringBlock[stringBlockCount];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= stringBlockCount) {
                return;
            }
            if (i2 < length) {
                this.mStringBlocks[i2] = stringBlockArr[i2];
            } else {
                this.mStringBlocks[i2] = new StringBlock(getNativeStringBlock(i2), true);
            }
            i = i2 + 1;
        }
    }

    public final InputStream open(String str) throws IOException {
        return open(str, 2);
    }

    public final InputStream open(String str, int i) throws IOException {
        synchronized (this) {
            if (this.mOpen) {
                long openAsset = openAsset(str, i);
                if (openAsset != 0) {
                    AssetInputStream assetInputStream = new AssetInputStream(openAsset);
                    incRefsLocked(assetInputStream.hashCode());
                    return assetInputStream;
                }
                throw new FileNotFoundException("Asset file: " + str);
            }
            throw new RuntimeException("Assetmanager has been closed");
        }
    }

    public final AssetFileDescriptor openFd(String str) throws IOException {
        synchronized (this) {
            if (this.mOpen) {
                ParcelFileDescriptor openAssetFd = openAssetFd(str, this.mOffsets);
                if (openAssetFd != null) {
                    return new AssetFileDescriptor(openAssetFd, this.mOffsets[0], this.mOffsets[1]);
                }
                throw new FileNotFoundException("Asset file: " + str);
            }
            throw new RuntimeException("Assetmanager has been closed");
        }
    }

    public final InputStream openNonAsset(int i, String str) throws IOException {
        return openNonAsset(i, str, 2);
    }

    public final InputStream openNonAsset(int i, String str, int i2) throws IOException {
        synchronized (this) {
            if (this.mOpen) {
                long openNonAssetNative = openNonAssetNative(i, str, i2);
                if (openNonAssetNative != 0) {
                    AssetInputStream assetInputStream = new AssetInputStream(openNonAssetNative);
                    incRefsLocked(assetInputStream.hashCode());
                    return assetInputStream;
                }
                throw new FileNotFoundException("Asset absolute file: " + str);
            }
            throw new RuntimeException("Assetmanager has been closed");
        }
    }

    public final InputStream openNonAsset(String str) throws IOException {
        return openNonAsset(0, str, 2);
    }

    public final InputStream openNonAsset(String str, int i) throws IOException {
        return openNonAsset(0, str, i);
    }

    public final AssetFileDescriptor openNonAssetFd(int i, String str) throws IOException {
        synchronized (this) {
            if (this.mOpen) {
                ParcelFileDescriptor openNonAssetFdNative = openNonAssetFdNative(i, str, this.mOffsets);
                if (openNonAssetFdNative != null) {
                    return new AssetFileDescriptor(openNonAssetFdNative, this.mOffsets[0], this.mOffsets[1]);
                }
                throw new FileNotFoundException("Asset absolute file: " + str);
            }
            throw new RuntimeException("Assetmanager has been closed");
        }
    }

    public final AssetFileDescriptor openNonAssetFd(String str) throws IOException {
        return openNonAssetFd(0, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final XmlBlock openXmlBlockAsset(int i, String str) throws IOException {
        synchronized (this) {
            if (this.mOpen) {
                long openXmlAssetNative = openXmlAssetNative(i, str);
                if (openXmlAssetNative != 0) {
                    XmlBlock xmlBlock = new XmlBlock(this, openXmlAssetNative);
                    incRefsLocked(xmlBlock.hashCode());
                    return xmlBlock;
                }
                throw new FileNotFoundException("Asset XML file: " + str);
            }
            throw new RuntimeException("Assetmanager has been closed");
        }
    }

    final XmlBlock openXmlBlockAsset(String str) throws IOException {
        return openXmlBlockAsset(0, str);
    }

    public final XmlResourceParser openXmlResourceParser(int i, String str) throws IOException {
        XmlBlock openXmlBlockAsset = openXmlBlockAsset(i, str);
        XmlResourceParser newParser = openXmlBlockAsset.newParser();
        openXmlBlockAsset.close();
        return newParser;
    }

    public final XmlResourceParser openXmlResourceParser(String str) throws IOException {
        return openXmlResourceParser(0, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void recreateStringBlocks() {
        synchronized (this) {
            makeStringBlocks(sSystem.mStringBlocks);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void releaseTheme(long j) {
        synchronized (this) {
            deleteTheme(j);
            decRefsLocked(j);
        }
    }

    public final boolean removeOverlayPath(String str, int i) {
        boolean removeOverlayPathNative;
        synchronized (this) {
            removeOverlayPathNative = removeOverlayPathNative(str, i);
        }
        return removeOverlayPathNative;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final native int retrieveArray(int i, int[] iArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final native boolean retrieveAttributes(long j, int[] iArr, int[] iArr2, int[] iArr3);

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public void setCommonResCookie(int i) {
        this.mCommonResCookie = i;
    }

    public void setCommonResPackageName(String str) {
        this.mCommonResPackageName = str;
    }

    public final native void setConfiguration(int i, int i2, String str, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16);

    public void setIconPackCookie(int i) {
        this.mIconPackCookie = i;
    }

    public void setIconPackageName(String str) {
        this.mIconPackageName = str;
    }

    public final native void setLocale(String str);

    public void setThemePackageName(String str) {
        this.mThemePackageName = str;
    }

    public final void setThemeSupport(boolean z) {
        this.mThemeSupport = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xmlBlockGone(int i) {
        synchronized (this) {
            decRefsLocked(i);
        }
    }
}
