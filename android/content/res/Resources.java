package android.content.res;

import android.R;
import android.animation.Animator;
import android.animation.StateListAnimator;
import android.app.ComposedIconInfo;
import android.app.IconPackHelper;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageItemInfo;
import android.content.res.XmlBlock;
import android.graphics.Movie;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Trace;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.Pools;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.ViewDebug;
import com.android.internal.util.XmlUtils;
import com.anythink.expressad.foundation.h.i;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Locale;
import libcore.icu.NativePluralRules;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/content/res/Resources.class */
public class Resources {
    private static final boolean DEBUG_CONFIG = false;
    private static final boolean DEBUG_LOAD = false;
    private static final int ID_OTHER = 16777220;
    static final String TAG = "Resources";
    public static final int THEME_APP_PKG_ID = 97;
    public static final int THEME_COMMON_PKG_ID = 95;
    public static final int THEME_FRAMEWORK_PKG_ID = 96;
    public static final int THEME_ICON_PKG_ID = 98;
    private static final boolean TRACE_FOR_MISS_PRELOAD = false;
    private static final boolean TRACE_FOR_PRELOAD = false;
    private static boolean sPreloaded;
    private static int sPreloadedDensity;
    private final Object mAccessLock;
    private final ConfigurationBoundResourceCache<Animator> mAnimatorCache;
    final AssetManager mAssets;
    private TypedArray mCachedStyledAttributes;
    private final int[] mCachedXmlBlockIds;
    private final XmlBlock[] mCachedXmlBlocks;
    private final ArrayMap<String, LongSparseArray<WeakReference<Drawable.ConstantState>>> mColorDrawableCache;
    private final LongSparseArray<WeakReference<ColorStateList>> mColorStateListCache;
    private CompatibilityInfo mCompatibilityInfo;
    private ComposedIconInfo mComposedIconInfo;
    private final Configuration mConfiguration;
    private final ArrayMap<String, LongSparseArray<WeakReference<Drawable.ConstantState>>> mDrawableCache;
    private SparseArray<PackageItemInfo> mIcons;
    private int mLastCachedXmlBlockIndex;
    final DisplayMetrics mMetrics;
    private NativePluralRules mPluralRule;
    private boolean mPreloading;
    private final ConfigurationBoundResourceCache<StateListAnimator> mStateListAnimatorCache;
    private final Configuration mTmpConfig;
    private TypedValue mTmpValue;
    private WeakReference<IBinder> mToken;
    final Pools.SynchronizedPool<TypedArray> mTypedArrayPool;
    private static final int LAYOUT_DIR_CONFIG = ActivityInfo.activityInfoConfigToNative(8192);
    private static final Object sSync = new Object();
    private static final LongSparseArray<Drawable.ConstantState> sPreloadedColorDrawables = new LongSparseArray<>();
    private static final LongSparseArray<ColorStateList> sPreloadedColorStateLists = new LongSparseArray<>();
    static Resources mSystem = null;
    private static final LongSparseArray<Drawable.ConstantState>[] sPreloadedDrawables = new LongSparseArray[2];

    /* loaded from: source-9557208-dex2jar.jar:android/content/res/Resources$NotFoundException.class */
    public static class NotFoundException extends RuntimeException {
        public NotFoundException() {
        }

        public NotFoundException(String str) {
            super(str);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/res/Resources$Theme.class */
    public final class Theme {
        private final AssetManager mAssets;
        private final long mTheme;
        private int mThemeResId = 0;
        private String mKey = "";

        Theme() {
            this.mAssets = Resources.this.mAssets;
            this.mTheme = this.mAssets.createTheme();
        }

        private String getResourceNameFromHexString(String str) {
            return Resources.this.getResourceName(Integer.parseInt(str, 16));
        }

        public void applyStyle(int i, boolean z) {
            AssetManager.applyThemeStyle(this.mTheme, i, z);
            this.mThemeResId = i;
            this.mKey += Integer.toHexString(i) + (z ? "! " : " ");
        }

        public void dump(int i, String str, String str2) {
            AssetManager.dumpTheme(this.mTheme, i, str, str2);
        }

        protected void finalize() throws Throwable {
            super.finalize();
            this.mAssets.releaseTheme(this.mTheme);
        }

        public int[] getAllAttributes() {
            return this.mAssets.getStyleAttributes(getAppliedStyleResId());
        }

        int getAppliedStyleResId() {
            return this.mThemeResId;
        }

        public Drawable getDrawable(int i) throws NotFoundException {
            return Resources.this.getDrawable(i, this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getKey() {
            return this.mKey;
        }

        long getNativeTheme() {
            return this.mTheme;
        }

        public Resources getResources() {
            return Resources.this;
        }

        @ViewDebug.ExportedProperty(category = "theme", hasAdjacentMapping = true)
        public String[] getTheme() {
            String[] split = this.mKey.split(" ");
            String[] strArr = new String[split.length * 2];
            int i = 0;
            int length = split.length;
            while (true) {
                int i2 = length - 1;
                if (i >= strArr.length) {
                    return strArr;
                }
                String str = split[i2];
                boolean endsWith = str.endsWith("!");
                strArr[i] = endsWith ? getResourceNameFromHexString(str.substring(0, str.length() - 1)) : getResourceNameFromHexString(str);
                strArr[i + 1] = endsWith ? "forced" : "not forced";
                i += 2;
                length = i2;
            }
        }

        public TypedArray obtainStyledAttributes(int i, int[] iArr) throws NotFoundException {
            TypedArray obtain = TypedArray.obtain(Resources.this, iArr.length);
            obtain.mTheme = this;
            AssetManager.applyStyle(this.mTheme, 0, i, 0L, iArr, obtain.mData, obtain.mIndices);
            return obtain;
        }

        public TypedArray obtainStyledAttributes(AttributeSet attributeSet, int[] iArr, int i, int i2) {
            TypedArray obtain = TypedArray.obtain(Resources.this, iArr.length);
            XmlBlock.Parser parser = (XmlBlock.Parser) attributeSet;
            AssetManager.applyStyle(this.mTheme, i, i2, parser != null ? parser.mParseState : 0L, iArr, obtain.mData, obtain.mIndices);
            obtain.mTheme = this;
            obtain.mXml = parser;
            return obtain;
        }

        public TypedArray obtainStyledAttributes(int[] iArr) {
            TypedArray obtain = TypedArray.obtain(Resources.this, iArr.length);
            obtain.mTheme = this;
            AssetManager.applyStyle(this.mTheme, 0, 0, 0L, iArr, obtain.mData, obtain.mIndices);
            return obtain;
        }

        public boolean resolveAttribute(int i, TypedValue typedValue, boolean z) {
            return this.mAssets.getThemeValue(this.mTheme, i, typedValue, z);
        }

        public TypedArray resolveAttributes(int[] iArr, int[] iArr2) {
            int length = iArr2.length;
            if (iArr == null || length != iArr.length) {
                throw new IllegalArgumentException("Base attribute values must the same length as attrs");
            }
            TypedArray obtain = TypedArray.obtain(Resources.this, length);
            AssetManager.resolveAttrs(this.mTheme, 0, 0, iArr, iArr2, obtain.mData, obtain.mIndices);
            obtain.mTheme = this;
            obtain.mXml = null;
            return obtain;
        }

        public void setTo(Theme theme) {
            AssetManager.copyTheme(this.mTheme, theme.mTheme);
            this.mThemeResId = theme.mThemeResId;
            this.mKey = theme.mKey;
        }
    }

    static {
        sPreloadedDrawables[0] = new LongSparseArray<>();
        sPreloadedDrawables[1] = new LongSparseArray<>();
    }

    private Resources() {
        this.mTypedArrayPool = new Pools.SynchronizedPool<>(5);
        this.mAccessLock = new Object();
        this.mTmpConfig = new Configuration();
        this.mDrawableCache = new ArrayMap<>();
        this.mColorDrawableCache = new ArrayMap<>();
        this.mColorStateListCache = new LongSparseArray<>();
        this.mAnimatorCache = new ConfigurationBoundResourceCache<>(this);
        this.mStateListAnimatorCache = new ConfigurationBoundResourceCache<>(this);
        this.mTmpValue = new TypedValue();
        this.mCachedStyledAttributes = null;
        this.mLastCachedXmlBlockIndex = -1;
        this.mCachedXmlBlockIds = new int[]{0, 0, 0, 0};
        this.mCachedXmlBlocks = new XmlBlock[4];
        this.mMetrics = new DisplayMetrics();
        this.mConfiguration = new Configuration();
        this.mCompatibilityInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
        this.mAssets = AssetManager.getSystem();
        this.mConfiguration.setToDefaults();
        this.mMetrics.setToDefaults();
        updateConfiguration(null, null);
        this.mAssets.ensureStringBlocks();
    }

    public Resources(AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        this(assetManager, displayMetrics, configuration, CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO, null);
    }

    public Resources(AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration, CompatibilityInfo compatibilityInfo, IBinder iBinder) {
        this.mTypedArrayPool = new Pools.SynchronizedPool<>(5);
        this.mAccessLock = new Object();
        this.mTmpConfig = new Configuration();
        this.mDrawableCache = new ArrayMap<>();
        this.mColorDrawableCache = new ArrayMap<>();
        this.mColorStateListCache = new LongSparseArray<>();
        this.mAnimatorCache = new ConfigurationBoundResourceCache<>(this);
        this.mStateListAnimatorCache = new ConfigurationBoundResourceCache<>(this);
        this.mTmpValue = new TypedValue();
        this.mCachedStyledAttributes = null;
        this.mLastCachedXmlBlockIndex = -1;
        this.mCachedXmlBlockIds = new int[]{0, 0, 0, 0};
        this.mCachedXmlBlocks = new XmlBlock[4];
        this.mMetrics = new DisplayMetrics();
        this.mConfiguration = new Configuration();
        this.mCompatibilityInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
        this.mAssets = assetManager;
        this.mMetrics.setToDefaults();
        if (compatibilityInfo != null) {
            this.mCompatibilityInfo = compatibilityInfo;
        }
        this.mToken = new WeakReference<>(iBinder);
        updateConfiguration(configuration, displayMetrics);
        assetManager.recreateStringBlocks();
    }

    private static String adjustLanguageTag(String str) {
        String str2;
        int indexOf = str.indexOf(45);
        if (indexOf == -1) {
            str2 = "";
        } else {
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf);
            str = substring;
            str2 = substring2;
        }
        return Locale.adjustLanguageCode(str) + str2;
    }

    private static int attrForQuantityCode(int i) {
        switch (i) {
            case 0:
                return 16777221;
            case 1:
                return 16777222;
            case 2:
                return 16777223;
            case 3:
                return 16777224;
            case 4:
                return 16777225;
            default:
                return ID_OTHER;
        }
    }

    private void cacheDrawable(TypedValue typedValue, Theme theme, boolean z, ArrayMap<String, LongSparseArray<WeakReference<Drawable.ConstantState>>> arrayMap, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return;
        }
        if (!this.mPreloading) {
            synchronized (this.mAccessLock) {
                String str = theme == null ? "" : theme.mKey;
                LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = arrayMap.get(str);
                LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray2 = longSparseArray;
                if (longSparseArray == null) {
                    longSparseArray2 = new LongSparseArray<>(1);
                    arrayMap.put(str, longSparseArray2);
                }
                longSparseArray2.put(j, new WeakReference<>(constantState));
            }
            return;
        }
        int changingConfigurations = constantState.getChangingConfigurations();
        if (z) {
            if (verifyPreloadConfig(changingConfigurations, 0, typedValue.resourceId, i.f5112c)) {
                sPreloadedColorDrawables.put(j, constantState);
            }
        } else if (verifyPreloadConfig(changingConfigurations, LAYOUT_DIR_CONFIG, typedValue.resourceId, i.f5112c)) {
            if ((LAYOUT_DIR_CONFIG & changingConfigurations) != 0) {
                sPreloadedDrawables[this.mConfiguration.getLayoutDirection()].put(j, constantState);
                return;
            }
            sPreloadedDrawables[0].put(j, constantState);
            sPreloadedDrawables[1].put(j, constantState);
        }
    }

    private int calcConfigChanges(Configuration configuration) {
        int i = 268435455;
        if (configuration != null) {
            this.mTmpConfig.setTo(configuration);
            int i2 = configuration.densityDpi;
            int i3 = i2;
            if (i2 == 0) {
                i3 = this.mMetrics.noncompatDensityDpi;
            }
            this.mCompatibilityInfo.applyToConfiguration(i3, this.mTmpConfig);
            if (this.mTmpConfig.locale == null) {
                this.mTmpConfig.locale = Locale.getDefault();
                this.mTmpConfig.setLayoutDirection(this.mTmpConfig.locale);
            }
            int updateFrom = this.mConfiguration.updateFrom(this.mTmpConfig);
            if ((updateFrom & 1048576) == 0) {
                return ActivityInfo.activityInfoConfigToNative(updateFrom);
            }
            i = ActivityInfo.activityInfoConfigToNative(updateFrom) | 1048576;
        }
        return i;
    }

    private void clearDrawableCacheLocked(LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray, int i) {
        Drawable.ConstantState constantState;
        if (Configuration.needNewResources(i, 0)) {
            longSparseArray.clear();
            return;
        }
        int size = longSparseArray.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            WeakReference<Drawable.ConstantState> valueAt = longSparseArray.valueAt(i3);
            if (valueAt != null && (constantState = valueAt.get()) != null && Configuration.needNewResources(i, constantState.getChangingConfigurations())) {
                longSparseArray.setValueAt(i3, null);
            }
            i2 = i3 + 1;
        }
    }

    private void clearDrawableCachesLocked(ArrayMap<String, LongSparseArray<WeakReference<Drawable.ConstantState>>> arrayMap, int i) {
        int size = arrayMap.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            clearDrawableCacheLocked(arrayMap.valueAt(i3), i);
            i2 = i3 + 1;
        }
    }

    private ColorStateList getCachedColorStateList(long j) {
        synchronized (this.mAccessLock) {
            WeakReference<ColorStateList> weakReference = this.mColorStateListCache.get(j);
            if (weakReference != null) {
                ColorStateList colorStateList = weakReference.get();
                if (colorStateList != null) {
                    return colorStateList;
                }
                this.mColorStateListCache.delete(j);
            }
            return null;
        }
    }

    private Drawable getCachedDrawable(ArrayMap<String, LongSparseArray<WeakReference<Drawable.ConstantState>>> arrayMap, long j, Theme theme) {
        Drawable cachedDrawableLocked;
        synchronized (this.mAccessLock) {
            LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = arrayMap.get(theme != null ? theme.mKey : "");
            if (longSparseArray == null || (cachedDrawableLocked = getCachedDrawableLocked(longSparseArray, j)) == null) {
                return null;
            }
            return cachedDrawableLocked;
        }
    }

    private Drawable getCachedDrawableLocked(LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray, long j) {
        Drawable.ConstantState constantStateLocked = getConstantStateLocked(longSparseArray, j);
        if (constantStateLocked != null) {
            return constantStateLocked.newDrawable(this);
        }
        return null;
    }

    private Drawable.ConstantState getConstantStateLocked(LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray, long j) {
        WeakReference<Drawable.ConstantState> weakReference = longSparseArray.get(j);
        if (weakReference != null) {
            Drawable.ConstantState constantState = weakReference.get();
            if (constantState != null) {
                return constantState;
            }
            longSparseArray.delete(j);
            return null;
        }
        return null;
    }

    private NativePluralRules getPluralRule() {
        NativePluralRules nativePluralRules;
        synchronized (sSync) {
            if (this.mPluralRule == null) {
                this.mPluralRule = NativePluralRules.forLocale(this.mConfiguration.locale);
            }
            nativePluralRules = this.mPluralRule;
        }
        return nativePluralRules;
    }

    public static Resources getSystem() {
        Resources resources;
        synchronized (sSync) {
            Resources resources2 = mSystem;
            resources = resources2;
            if (resources2 == null) {
                resources = new Resources();
                mSystem = resources;
            }
        }
        return resources;
    }

    private Drawable loadDrawableForCookie(TypedValue typedValue, int i, Theme theme) {
        Drawable createFromResourceStream;
        if (typedValue.string == null) {
            throw new NotFoundException("Resource \"" + getResourceName(i) + "\" (" + Integer.toHexString(i) + ")  is not a Drawable (color or path): " + typedValue);
        }
        String charSequence = typedValue.string.toString();
        Trace.traceBegin(8192L, charSequence);
        try {
            if (charSequence.endsWith(".xml")) {
                XmlResourceParser loadXmlResourceParser = loadXmlResourceParser(charSequence, i, typedValue.assetCookie, i.f5112c);
                createFromResourceStream = Drawable.createFromXml(this, loadXmlResourceParser, theme);
                loadXmlResourceParser.close();
            } else {
                InputStream openNonAsset = this.mAssets.openNonAsset(typedValue.assetCookie, charSequence, 2);
                createFromResourceStream = Drawable.createFromResourceStream(this, typedValue, openNonAsset, charSequence, null);
                openNonAsset.close();
            }
            Trace.traceEnd(8192L);
            return createFromResourceStream;
        } catch (Exception e) {
            Trace.traceEnd(8192L);
            NotFoundException notFoundException = new NotFoundException("File " + charSequence + " from drawable resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e);
            throw notFoundException;
        }
    }

    public static boolean resourceHasPackage(int i) {
        return (i >>> 24) != 0;
    }

    public static int selectDefaultTheme(int i, int i2) {
        return selectSystemTheme(i, i2, R.style.Theme, R.style.Theme_Holo, R.style.Theme_DeviceDefault, R.style.Theme_DeviceDefault_Light_DarkActionBar);
    }

    public static int selectSystemTheme(int i, int i2, int i3, int i4, int i5, int i6) {
        return i != 0 ? i : i2 < 11 ? i3 : i2 < 14 ? i4 : i2 < 10000 ? i5 : i6;
    }

    private static String stringForQuantityCode(int i) {
        switch (i) {
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "few";
            case 4:
                return "many";
            default:
                return "other";
        }
    }

    public static void updateSystemConfiguration(Configuration configuration, DisplayMetrics displayMetrics, CompatibilityInfo compatibilityInfo) {
        if (mSystem != null) {
            mSystem.updateConfiguration(configuration, displayMetrics, compatibilityInfo);
        }
    }

    private boolean verifyPreloadConfig(int i, int i2, int i3, String str) {
        String str2;
        if (((-1073745921) & i & (i2 ^ (-1))) != 0) {
            try {
                str2 = getResourceName(i3);
            } catch (NotFoundException e) {
                str2 = "?";
            }
            Log.w(TAG, "Preloaded " + str + " resource #0x" + Integer.toHexString(i3) + " (" + str2 + ") that varies with configuration!!");
            return false;
        }
        return true;
    }

    public final void finishPreloading() {
        if (this.mPreloading) {
            this.mPreloading = false;
            flushLayoutCache();
        }
    }

    public final void flushLayoutCache() {
        synchronized (this.mCachedXmlBlockIds) {
            int length = this.mCachedXmlBlockIds.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < length) {
                    this.mCachedXmlBlockIds[i2] = 0;
                    XmlBlock xmlBlock = this.mCachedXmlBlocks[i2];
                    if (xmlBlock != null) {
                        xmlBlock.close();
                    }
                    this.mCachedXmlBlocks[i2] = null;
                    i = i2 + 1;
                }
            }
        }
    }

    public XmlResourceParser getAnimation(int i) throws NotFoundException {
        return loadXmlResourceParser(i, i.f);
    }

    public ConfigurationBoundResourceCache<Animator> getAnimatorCache() {
        return this.mAnimatorCache;
    }

    public final AssetManager getAssets() {
        return this.mAssets;
    }

    public boolean getBoolean(int i) throws NotFoundException {
        boolean z = true;
        synchronized (this.mAccessLock) {
            TypedValue typedValue = this.mTmpValue;
            TypedValue typedValue2 = typedValue;
            if (typedValue == null) {
                typedValue2 = new TypedValue();
                this.mTmpValue = typedValue2;
            }
            getValue(i, typedValue2, true);
            if (typedValue2.type < 16 || typedValue2.type > 31) {
                throw new NotFoundException("Resource ID #0x" + Integer.toHexString(i) + " type #0x" + Integer.toHexString(typedValue2.type) + " is not valid");
            }
            if (typedValue2.data == 0) {
                z = false;
            }
        }
        return z;
    }

    public int getColor(int i) throws NotFoundException {
        synchronized (this.mAccessLock) {
            TypedValue typedValue = this.mTmpValue;
            TypedValue typedValue2 = typedValue;
            if (typedValue == null) {
                typedValue2 = new TypedValue();
            }
            getValue(i, typedValue2, true);
            if (typedValue2.type >= 16 && typedValue2.type <= 31) {
                this.mTmpValue = typedValue2;
                return typedValue2.data;
            } else if (typedValue2.type != 3) {
                throw new NotFoundException("Resource ID #0x" + Integer.toHexString(i) + " type #0x" + Integer.toHexString(typedValue2.type) + " is not valid");
            } else {
                this.mTmpValue = null;
                ColorStateList loadColorStateList = loadColorStateList(typedValue2, i);
                synchronized (this.mAccessLock) {
                    if (this.mTmpValue == null) {
                        this.mTmpValue = typedValue2;
                    }
                }
                return loadColorStateList.getDefaultColor();
            }
        }
    }

    public ColorStateList getColorStateList(int i) throws NotFoundException {
        TypedValue typedValue;
        synchronized (this.mAccessLock) {
            typedValue = this.mTmpValue;
            if (typedValue == null) {
                typedValue = new TypedValue();
            } else {
                this.mTmpValue = null;
            }
            getValue(i, typedValue, true);
        }
        ColorStateList loadColorStateList = loadColorStateList(typedValue, i);
        synchronized (this.mAccessLock) {
            if (this.mTmpValue == null) {
                this.mTmpValue = typedValue;
            }
        }
        return loadColorStateList;
    }

    public CompatibilityInfo getCompatibilityInfo() {
        return this.mCompatibilityInfo;
    }

    public ComposedIconInfo getComposedIconInfo() {
        return this.mComposedIconInfo;
    }

    public Configuration getConfiguration() {
        return this.mConfiguration;
    }

    public float getDimension(int i) throws NotFoundException {
        float complexToDimension;
        synchronized (this.mAccessLock) {
            TypedValue typedValue = this.mTmpValue;
            TypedValue typedValue2 = typedValue;
            if (typedValue == null) {
                typedValue2 = new TypedValue();
                this.mTmpValue = typedValue2;
            }
            getValue(i, typedValue2, true);
            if (typedValue2.type != 5) {
                throw new NotFoundException("Resource ID #0x" + Integer.toHexString(i) + " type #0x" + Integer.toHexString(typedValue2.type) + " is not valid");
            }
            complexToDimension = TypedValue.complexToDimension(typedValue2.data, this.mMetrics);
        }
        return complexToDimension;
    }

    public int getDimensionPixelOffset(int i) throws NotFoundException {
        int complexToDimensionPixelOffset;
        synchronized (this.mAccessLock) {
            TypedValue typedValue = this.mTmpValue;
            TypedValue typedValue2 = typedValue;
            if (typedValue == null) {
                typedValue2 = new TypedValue();
                this.mTmpValue = typedValue2;
            }
            getValue(i, typedValue2, true);
            if (typedValue2.type != 5) {
                throw new NotFoundException("Resource ID #0x" + Integer.toHexString(i) + " type #0x" + Integer.toHexString(typedValue2.type) + " is not valid");
            }
            complexToDimensionPixelOffset = TypedValue.complexToDimensionPixelOffset(typedValue2.data, this.mMetrics);
        }
        return complexToDimensionPixelOffset;
    }

    public int getDimensionPixelSize(int i) throws NotFoundException {
        int complexToDimensionPixelSize;
        synchronized (this.mAccessLock) {
            TypedValue typedValue = this.mTmpValue;
            TypedValue typedValue2 = typedValue;
            if (typedValue == null) {
                typedValue2 = new TypedValue();
                this.mTmpValue = typedValue2;
            }
            getValue(i, typedValue2, true);
            if (typedValue2.type != 5) {
                throw new NotFoundException("Resource ID #0x" + Integer.toHexString(i) + " type #0x" + Integer.toHexString(typedValue2.type) + " is not valid");
            }
            complexToDimensionPixelSize = TypedValue.complexToDimensionPixelSize(typedValue2.data, this.mMetrics);
        }
        return complexToDimensionPixelSize;
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.mMetrics;
    }

    @Deprecated
    public Drawable getDrawable(int i) throws NotFoundException {
        Drawable drawable = getDrawable(i, null);
        if (drawable != null && drawable.canApplyTheme()) {
            Log.w(TAG, "Drawable " + getResourceName(i) + " has unresolved theme attributes! Consider using Resources.getDrawable(int, Theme) or Context.getDrawable(int).", new RuntimeException());
        }
        return drawable;
    }

    public Drawable getDrawable(int i, Theme theme) throws NotFoundException {
        return getDrawable(i, theme, true);
    }

    public Drawable getDrawable(int i, Theme theme, boolean z) throws NotFoundException {
        TypedValue typedValue;
        Drawable loadDrawable;
        PackageItemInfo packageItemInfo = null;
        if (this.mIcons != null) {
            packageItemInfo = this.mIcons.get(i);
        }
        int i2 = i;
        if (packageItemInfo != null) {
            i2 = i;
            if (packageItemInfo.themedIcon != 0) {
                i2 = packageItemInfo.themedIcon;
            }
        }
        synchronized (this.mAccessLock) {
            typedValue = this.mTmpValue;
            if (typedValue == null) {
                typedValue = new TypedValue();
            } else {
                this.mTmpValue = null;
            }
            getValue(i2, typedValue, true, z);
        }
        try {
            loadDrawable = loadDrawable(typedValue, i2, theme);
        } catch (NotFoundException e) {
            if (!z || this.mComposedIconInfo == null || packageItemInfo == null || packageItemInfo.themedIcon != 0) {
                throw e;
            }
            Log.e(TAG, "Failed to retrieve composed icon.", e);
            getValue(i2, typedValue, true, false);
            loadDrawable = loadDrawable(typedValue, i2, theme);
        }
        synchronized (this.mAccessLock) {
            if (this.mTmpValue == null) {
                this.mTmpValue = typedValue;
            }
        }
        return loadDrawable;
    }

    @Deprecated
    public Drawable getDrawableForDensity(int i, int i2) throws NotFoundException {
        return getDrawableForDensity(i, i2, null);
    }

    public Drawable getDrawableForDensity(int i, int i2, Theme theme) {
        return getDrawableForDensity(i, i2, theme, true);
    }

    public Drawable getDrawableForDensity(int i, int i2, Theme theme, boolean z) {
        TypedValue typedValue;
        PackageItemInfo packageItemInfo = null;
        if (this.mIcons != null) {
            packageItemInfo = this.mIcons.get(i);
        }
        int i3 = i;
        if (packageItemInfo != null) {
            i3 = i;
            if (packageItemInfo.themedIcon != 0) {
                i3 = packageItemInfo.themedIcon;
            }
        }
        synchronized (this.mAccessLock) {
            typedValue = this.mTmpValue;
            if (typedValue == null) {
                typedValue = new TypedValue();
            } else {
                this.mTmpValue = null;
            }
            getValueForDensity(i3, i2, typedValue, true, z);
            if (typedValue.density > 0 && typedValue.density != 65535) {
                if (typedValue.density == i2) {
                    typedValue.density = this.mMetrics.densityDpi;
                } else {
                    typedValue.density = (typedValue.density * this.mMetrics.densityDpi) / i2;
                }
            }
        }
        Drawable loadDrawable = loadDrawable(typedValue, i3, theme);
        synchronized (this.mAccessLock) {
            if (this.mTmpValue == null) {
                this.mTmpValue = typedValue;
            }
        }
        return loadDrawable;
    }

    public float getFloat(int i) {
        float f;
        synchronized (this.mAccessLock) {
            TypedValue typedValue = this.mTmpValue;
            TypedValue typedValue2 = typedValue;
            if (typedValue == null) {
                typedValue2 = new TypedValue();
                this.mTmpValue = typedValue2;
            }
            getValue(i, typedValue2, true);
            if (typedValue2.type != 4) {
                throw new NotFoundException("Resource ID #0x" + Integer.toHexString(i) + " type #0x" + Integer.toHexString(typedValue2.type) + " is not valid");
            }
            f = typedValue2.getFloat();
        }
        return f;
    }

    public float getFraction(int i, int i2, int i3) {
        float complexToFraction;
        synchronized (this.mAccessLock) {
            TypedValue typedValue = this.mTmpValue;
            TypedValue typedValue2 = typedValue;
            if (typedValue == null) {
                typedValue2 = new TypedValue();
                this.mTmpValue = typedValue2;
            }
            getValue(i, typedValue2, true);
            if (typedValue2.type != 6) {
                throw new NotFoundException("Resource ID #0x" + Integer.toHexString(i) + " type #0x" + Integer.toHexString(typedValue2.type) + " is not valid");
            }
            complexToFraction = TypedValue.complexToFraction(typedValue2.data, i2, i3);
        }
        return complexToFraction;
    }

    public int getIdentifier(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return this.mAssets.getResourceIdentifier(str, str2, str3);
        }
    }

    public int[] getIntArray(int i) throws NotFoundException {
        int[] arrayIntResource = this.mAssets.getArrayIntResource(i);
        if (arrayIntResource != null) {
            return arrayIntResource;
        }
        throw new NotFoundException("Int array resource ID #0x" + Integer.toHexString(i));
    }

    public int getInteger(int i) throws NotFoundException {
        int i2;
        synchronized (this.mAccessLock) {
            TypedValue typedValue = this.mTmpValue;
            TypedValue typedValue2 = typedValue;
            if (typedValue == null) {
                typedValue2 = new TypedValue();
                this.mTmpValue = typedValue2;
            }
            getValue(i, typedValue2, true);
            if (typedValue2.type < 16 || typedValue2.type > 31) {
                throw new NotFoundException("Resource ID #0x" + Integer.toHexString(i) + " type #0x" + Integer.toHexString(typedValue2.type) + " is not valid");
            }
            i2 = typedValue2.data;
        }
        return i2;
    }

    public XmlResourceParser getLayout(int i) throws NotFoundException {
        return loadXmlResourceParser(i, "layout");
    }

    public Movie getMovie(int i) throws NotFoundException {
        InputStream openRawResource = openRawResource(i);
        Movie decodeStream = Movie.decodeStream(openRawResource);
        try {
            openRawResource.close();
            return decodeStream;
        } catch (IOException e) {
            return decodeStream;
        }
    }

    public LongSparseArray<Drawable.ConstantState> getPreloadedDrawables() {
        return sPreloadedDrawables[0];
    }

    public String getQuantityString(int i, int i2) throws NotFoundException {
        return getQuantityText(i, i2).toString();
    }

    public String getQuantityString(int i, int i2, Object... objArr) throws NotFoundException {
        return String.format(this.mConfiguration.locale, getQuantityText(i, i2).toString(), objArr);
    }

    public CharSequence getQuantityText(int i, int i2) throws NotFoundException {
        NativePluralRules pluralRule = getPluralRule();
        CharSequence resourceBagText = this.mAssets.getResourceBagText(i, attrForQuantityCode(pluralRule.quantityForInt(i2)));
        if (resourceBagText != null) {
            return resourceBagText;
        }
        CharSequence resourceBagText2 = this.mAssets.getResourceBagText(i, ID_OTHER);
        if (resourceBagText2 != null) {
            return resourceBagText2;
        }
        throw new NotFoundException("Plural resource ID #0x" + Integer.toHexString(i) + " quantity=" + i2 + " item=" + stringForQuantityCode(pluralRule.quantityForInt(i2)));
    }

    public String getResourceEntryName(int i) throws NotFoundException {
        String resourceEntryName = this.mAssets.getResourceEntryName(i);
        if (resourceEntryName != null) {
            return resourceEntryName;
        }
        throw new NotFoundException("Unable to find resource ID #0x" + Integer.toHexString(i));
    }

    public String getResourceName(int i) throws NotFoundException {
        String resourceName = this.mAssets.getResourceName(i);
        if (resourceName != null) {
            return resourceName;
        }
        throw new NotFoundException("Unable to find resource ID #0x" + Integer.toHexString(i));
    }

    public String getResourcePackageName(int i) throws NotFoundException {
        String resourcePackageName = this.mAssets.getResourcePackageName(i);
        if (resourcePackageName != null) {
            return resourcePackageName;
        }
        throw new NotFoundException("Unable to find resource ID #0x" + Integer.toHexString(i));
    }

    public String getResourceTypeName(int i) throws NotFoundException {
        String resourceTypeName = this.mAssets.getResourceTypeName(i);
        if (resourceTypeName != null) {
            return resourceTypeName;
        }
        throw new NotFoundException("Unable to find resource ID #0x" + Integer.toHexString(i));
    }

    public ConfigurationBoundResourceCache<StateListAnimator> getStateListAnimatorCache() {
        return this.mStateListAnimatorCache;
    }

    public String getString(int i) throws NotFoundException {
        CharSequence text = getText(i);
        if (text != null) {
            return text.toString();
        }
        throw new NotFoundException("String resource ID #0x" + Integer.toHexString(i));
    }

    public String getString(int i, Object... objArr) throws NotFoundException {
        return String.format(this.mConfiguration.locale, getString(i), objArr);
    }

    public String[] getStringArray(int i) throws NotFoundException {
        String[] resourceStringArray = this.mAssets.getResourceStringArray(i);
        if (resourceStringArray != null) {
            return resourceStringArray;
        }
        throw new NotFoundException("String array resource ID #0x" + Integer.toHexString(i));
    }

    public CharSequence getText(int i) throws NotFoundException {
        CharSequence resourceText = this.mAssets.getResourceText(i);
        if (resourceText != null) {
            return resourceText;
        }
        throw new NotFoundException("String resource ID #0x" + Integer.toHexString(i));
    }

    public CharSequence getText(int i, CharSequence charSequence) {
        CharSequence resourceText = i != 0 ? this.mAssets.getResourceText(i) : null;
        return resourceText != null ? resourceText : charSequence;
    }

    public CharSequence[] getTextArray(int i) throws NotFoundException {
        CharSequence[] resourceTextArray = this.mAssets.getResourceTextArray(i);
        if (resourceTextArray != null) {
            return resourceTextArray;
        }
        throw new NotFoundException("Text array resource ID #0x" + Integer.toHexString(i));
    }

    public void getValue(int i, TypedValue typedValue, boolean z) throws NotFoundException {
        getValue(i, typedValue, z, true);
    }

    public void getValue(int i, TypedValue typedValue, boolean z, boolean z2) throws NotFoundException {
        PackageItemInfo packageItemInfo = this.mIcons != null ? this.mIcons.get(i) : null;
        int i2 = i;
        if (packageItemInfo != null) {
            i2 = i;
            if (packageItemInfo.themedIcon != 0) {
                i2 = packageItemInfo.themedIcon;
            }
        }
        if (!this.mAssets.getResourceValue(i2, 0, typedValue, z)) {
            throw new NotFoundException("Resource ID #0x" + Integer.toHexString(i2));
        }
        if (z2 && IconPackHelper.shouldComposeIcon(this.mComposedIconInfo) && packageItemInfo != null && packageItemInfo.themedIcon == 0) {
            IconPackHelper.IconCustomizer.getValue(this, i2, typedValue, loadDrawable(typedValue, i2, null));
        }
    }

    public void getValue(String str, TypedValue typedValue, boolean z) throws NotFoundException {
        int identifier = getIdentifier(str, "string", null);
        if (identifier == 0) {
            throw new NotFoundException("String resource name " + str);
        }
        getValue(identifier, typedValue, z);
    }

    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws NotFoundException {
        getValueForDensity(i, i2, typedValue, z, true);
    }

    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z, boolean z2) throws NotFoundException {
        PackageItemInfo packageItemInfo = this.mIcons != null ? this.mIcons.get(i) : null;
        int i3 = i;
        if (packageItemInfo != null) {
            i3 = i;
            if (packageItemInfo.themedIcon != 0) {
                i3 = packageItemInfo.themedIcon;
            }
        }
        if (!this.mAssets.getResourceValue(i3, i2, typedValue, z)) {
            throw new NotFoundException("Resource ID #0x" + Integer.toHexString(i3));
        }
        if (z2 && IconPackHelper.shouldComposeIcon(this.mComposedIconInfo) && packageItemInfo != null && packageItemInfo.themedIcon == 0) {
            int i4 = typedValue.density;
            if (typedValue.density > 0 && typedValue.density != 65535) {
                if (typedValue.density == i2) {
                    typedValue.density = this.mMetrics.densityDpi;
                } else {
                    typedValue.density = (typedValue.density * this.mMetrics.densityDpi) / i2;
                }
            }
            Drawable loadDrawable = loadDrawable(typedValue, i3, null);
            typedValue.density = i4;
            IconPackHelper.IconCustomizer.getValue(this, i3, typedValue, loadDrawable);
        }
    }

    public XmlResourceParser getXml(int i) throws NotFoundException {
        return loadXmlResourceParser(i, "xml");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList loadColorStateList(TypedValue typedValue, int i) throws NotFoundException {
        long j = (typedValue.assetCookie << 32) | typedValue.data;
        if (typedValue.type >= 28 && typedValue.type <= 31) {
            ColorStateList colorStateList = this.mAssets.hasThemedAssets() ? null : sPreloadedColorStateLists.get(j);
            if (colorStateList != null) {
                return colorStateList;
            }
            ColorStateList valueOf = ColorStateList.valueOf(typedValue.data);
            if (this.mPreloading && verifyPreloadConfig(typedValue.changingConfigurations, 0, typedValue.resourceId, "color")) {
                sPreloadedColorStateLists.put(j, valueOf);
            }
            return valueOf;
        }
        ColorStateList cachedColorStateList = getCachedColorStateList(j);
        if (cachedColorStateList != null) {
            return cachedColorStateList;
        }
        ColorStateList colorStateList2 = this.mAssets.hasThemedAssets() ? null : sPreloadedColorStateLists.get(j);
        if (colorStateList2 != null) {
            return colorStateList2;
        }
        if (typedValue.string == null) {
            throw new NotFoundException("Resource is not a ColorStateList (color or path): " + typedValue);
        }
        String charSequence = typedValue.string.toString();
        if (charSequence.endsWith(".xml")) {
            Trace.traceBegin(8192L, charSequence);
            try {
                XmlResourceParser loadXmlResourceParser = loadXmlResourceParser(charSequence, i, typedValue.assetCookie, "colorstatelist");
                ColorStateList createFromXml = ColorStateList.createFromXml(this, loadXmlResourceParser);
                loadXmlResourceParser.close();
                Trace.traceEnd(8192L);
                if (createFromXml != null) {
                    if (!this.mPreloading) {
                        synchronized (this.mAccessLock) {
                            this.mColorStateListCache.put(j, new WeakReference<>(createFromXml));
                        }
                    } else if (verifyPreloadConfig(typedValue.changingConfigurations, 0, typedValue.resourceId, "color")) {
                        sPreloadedColorStateLists.put(j, createFromXml);
                    }
                }
                return createFromXml;
            } catch (Exception e) {
                Trace.traceEnd(8192L);
                NotFoundException notFoundException = new NotFoundException("File " + charSequence + " from color state list resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e);
                throw notFoundException;
            }
        }
        throw new NotFoundException("File " + charSequence + " from drawable resource ID #0x" + Integer.toHexString(i) + ": .xml extension required");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable loadDrawable(TypedValue typedValue, int i, Theme theme) throws NotFoundException {
        boolean z;
        ArrayMap<String, LongSparseArray<WeakReference<Drawable.ConstantState>>> arrayMap;
        long j;
        ColorDrawable colorDrawable;
        Drawable cachedDrawable;
        if (typedValue.type < 28 || typedValue.type > 31) {
            z = false;
            arrayMap = this.mDrawableCache;
            j = (typedValue.assetCookie << 32) | typedValue.data;
        } else {
            z = true;
            arrayMap = this.mColorDrawableCache;
            j = typedValue.data;
        }
        if (this.mPreloading || (cachedDrawable = getCachedDrawable(arrayMap, j, theme)) == null) {
            Drawable.ConstantState constantState = z ? this.mAssets.hasThemedAssets() ? null : sPreloadedColorDrawables.get(j) : this.mAssets.hasThemedAssets() ? null : sPreloadedDrawables[this.mConfiguration.getLayoutDirection()].get(j);
            if (constantState != null) {
                colorDrawable = constantState.newDrawable(this);
                if (theme != null) {
                    colorDrawable = colorDrawable.mutate();
                    colorDrawable.applyTheme(theme);
                    colorDrawable.clearMutated();
                }
            } else {
                colorDrawable = z ? new ColorDrawable(typedValue.data) : loadDrawableForCookie(typedValue, i, theme);
            }
            if (colorDrawable != null) {
                colorDrawable.setChangingConfigurations(typedValue.changingConfigurations);
                cacheDrawable(typedValue, theme, z, arrayMap, j, colorDrawable);
            }
            return colorDrawable;
        }
        return cachedDrawable;
    }

    XmlResourceParser loadXmlResourceParser(int i, String str) throws NotFoundException {
        XmlResourceParser loadXmlResourceParser;
        synchronized (this.mAccessLock) {
            TypedValue typedValue = this.mTmpValue;
            TypedValue typedValue2 = typedValue;
            if (typedValue == null) {
                typedValue2 = new TypedValue();
                this.mTmpValue = typedValue2;
            }
            getValue(i, typedValue2, true);
            if (typedValue2.type != 3) {
                throw new NotFoundException("Resource ID #0x" + Integer.toHexString(i) + " type #0x" + Integer.toHexString(typedValue2.type) + " is not valid");
            }
            loadXmlResourceParser = loadXmlResourceParser(typedValue2.string.toString(), i, typedValue2.assetCookie, str);
        }
        return loadXmlResourceParser;
    }

    XmlResourceParser loadXmlResourceParser(String str, int i, int i2, String str2) throws NotFoundException {
        if (i != 0) {
            try {
                synchronized (this.mCachedXmlBlockIds) {
                    int length = this.mCachedXmlBlockIds.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= length) {
                            XmlBlock openXmlBlockAsset = this.mAssets.openXmlBlockAsset(i2, str);
                            if (openXmlBlockAsset != null) {
                                int i5 = this.mLastCachedXmlBlockIndex + 1;
                                int i6 = i5;
                                if (i5 >= length) {
                                    i6 = 0;
                                }
                                this.mLastCachedXmlBlockIndex = i6;
                                XmlBlock xmlBlock = this.mCachedXmlBlocks[i6];
                                if (xmlBlock != null) {
                                    xmlBlock.close();
                                }
                                this.mCachedXmlBlockIds[i6] = i;
                                this.mCachedXmlBlocks[i6] = openXmlBlockAsset;
                                return openXmlBlockAsset.newParser();
                            }
                        } else if (this.mCachedXmlBlockIds[i4] == i) {
                            return this.mCachedXmlBlocks[i4].newParser();
                        } else {
                            i3 = i4 + 1;
                        }
                    }
                }
            } catch (Exception e) {
                NotFoundException notFoundException = new NotFoundException("File " + str + " from xml type " + str2 + " resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e);
                throw notFoundException;
            }
        }
        throw new NotFoundException("File " + str + " from xml type " + str2 + " resource ID #0x" + Integer.toHexString(i));
    }

    public final Theme newTheme() {
        return new Theme();
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        TypedArray obtain = TypedArray.obtain(this, iArr.length);
        XmlBlock.Parser parser = (XmlBlock.Parser) attributeSet;
        this.mAssets.retrieveAttributes(parser.mParseState, iArr, obtain.mData, obtain.mIndices);
        obtain.mXml = parser;
        return obtain;
    }

    public TypedArray obtainTypedArray(int i) throws NotFoundException {
        int arraySize = this.mAssets.getArraySize(i);
        if (arraySize < 0) {
            throw new NotFoundException("Array resource ID #0x" + Integer.toHexString(i));
        }
        TypedArray obtain = TypedArray.obtain(this, arraySize);
        obtain.mLength = this.mAssets.retrieveArray(i, obtain.mData);
        obtain.mIndices[0] = 0;
        return obtain;
    }

    public InputStream openRawResource(int i) throws NotFoundException {
        TypedValue typedValue;
        synchronized (this.mAccessLock) {
            typedValue = this.mTmpValue;
            if (typedValue == null) {
                typedValue = new TypedValue();
            } else {
                this.mTmpValue = null;
            }
        }
        InputStream openRawResource = openRawResource(i, typedValue);
        synchronized (this.mAccessLock) {
            if (this.mTmpValue == null) {
                this.mTmpValue = typedValue;
            }
        }
        return openRawResource;
    }

    public InputStream openRawResource(int i, TypedValue typedValue) throws NotFoundException {
        getValue(i, typedValue, true);
        try {
            return this.mAssets.openNonAsset(typedValue.assetCookie, typedValue.string.toString(), 2);
        } catch (Exception e) {
            NotFoundException notFoundException = new NotFoundException("File " + typedValue.string.toString() + " from drawable resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e);
            throw notFoundException;
        }
    }

    public AssetFileDescriptor openRawResourceFd(int i) throws NotFoundException {
        TypedValue typedValue;
        synchronized (this.mAccessLock) {
            typedValue = this.mTmpValue;
            if (typedValue == null) {
                typedValue = new TypedValue();
            } else {
                this.mTmpValue = null;
            }
            getValue(i, typedValue, true);
            try {
            } catch (Throwable th) {
                synchronized (this.mAccessLock) {
                    if (this.mTmpValue == null) {
                        this.mTmpValue = typedValue;
                    }
                    throw th;
                }
            }
        }
        try {
            AssetFileDescriptor openNonAssetFd = this.mAssets.openNonAssetFd(typedValue.assetCookie, typedValue.string.toString());
            synchronized (this.mAccessLock) {
                if (this.mTmpValue == null) {
                    this.mTmpValue = typedValue;
                }
            }
            return openNonAssetFd;
        } catch (Exception e) {
            NotFoundException notFoundException = new NotFoundException("File " + typedValue.string.toString() + " from drawable resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e);
            throw notFoundException;
        }
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        boolean z = true;
        TypedArray obtainAttributes = obtainAttributes(attributeSet, com.android.internal.R.styleable.Extra);
        String string = obtainAttributes.getString(0);
        if (string == null) {
            obtainAttributes.recycle();
            throw new XmlPullParserException(SimpleComparison.LESS_THAN_OPERATION + str + "> requires an android:name attribute at " + attributeSet.getPositionDescription());
        }
        TypedValue peekValue = obtainAttributes.peekValue(1);
        if (peekValue == null) {
            obtainAttributes.recycle();
            throw new XmlPullParserException(SimpleComparison.LESS_THAN_OPERATION + str + "> requires an android:value or android:resource attribute at " + attributeSet.getPositionDescription());
        }
        if (peekValue.type == 3) {
            bundle.putCharSequence(string, peekValue.coerceToString());
        } else if (peekValue.type == 18) {
            if (peekValue.data == 0) {
                z = false;
            }
            bundle.putBoolean(string, z);
        } else if (peekValue.type >= 16 && peekValue.type <= 31) {
            bundle.putInt(string, peekValue.data);
        } else if (peekValue.type != 4) {
            obtainAttributes.recycle();
            throw new XmlPullParserException(SimpleComparison.LESS_THAN_OPERATION + str + "> only supports string, integer, float, color, and boolean at " + attributeSet.getPositionDescription());
        } else {
            bundle.putFloat(string, peekValue.getFloat());
        }
        obtainAttributes.recycle();
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        int depth = xmlResourceParser.getDepth();
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlResourceParser.getDepth() <= depth) {
                return;
            }
            if (next != 3 && next != 4) {
                if (xmlResourceParser.getName().equals("extra")) {
                    parseBundleExtra("extra", xmlResourceParser, bundle);
                    XmlUtils.skipCurrentTag(xmlResourceParser);
                } else {
                    XmlUtils.skipCurrentTag(xmlResourceParser);
                }
            }
        }
    }

    void recycleCachedStyledAttributes(TypedArray typedArray) {
        synchronized (this.mAccessLock) {
            TypedArray typedArray2 = this.mCachedStyledAttributes;
            if (typedArray2 == null || typedArray2.mData.length < typedArray.mData.length) {
                this.mCachedStyledAttributes = typedArray;
            }
        }
    }

    public void setCompatibilityInfo(CompatibilityInfo compatibilityInfo) {
        if (compatibilityInfo != null) {
            this.mCompatibilityInfo = compatibilityInfo;
            updateConfiguration(this.mConfiguration, this.mMetrics);
        }
    }

    public void setComposedIconInfo(ComposedIconInfo composedIconInfo) {
        this.mComposedIconInfo = composedIconInfo;
    }

    public void setIconResources(SparseArray<PackageItemInfo> sparseArray) {
        this.mIcons = sparseArray;
    }

    public final void startPreloading() {
        synchronized (sSync) {
            if (sPreloaded) {
                throw new IllegalStateException("Resources already preloaded");
            }
            sPreloaded = true;
            this.mPreloading = true;
            sPreloadedDensity = DisplayMetrics.DENSITY_PREFERRED;
            this.mConfiguration.densityDpi = sPreloadedDensity;
            updateConfiguration(null, null);
        }
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        updateConfiguration(configuration, displayMetrics, null);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics, CompatibilityInfo compatibilityInfo) {
        int i;
        int i2;
        synchronized (this.mAccessLock) {
            if (compatibilityInfo != null) {
                this.mCompatibilityInfo = compatibilityInfo;
            }
            if (displayMetrics != null) {
                this.mMetrics.setTo(displayMetrics);
            }
            this.mCompatibilityInfo.applyToDisplayMetrics(this.mMetrics);
            int calcConfigChanges = calcConfigChanges(configuration);
            if (this.mConfiguration.locale == null) {
                this.mConfiguration.locale = Locale.getDefault();
                this.mConfiguration.setLayoutDirection(this.mConfiguration.locale);
            }
            if (this.mConfiguration.densityDpi != 0) {
                if (DisplayMetrics.DENSITY_DEVICE_DEFAULT == this.mCompatibilityInfo.applicationDensity && configuration != null && configuration.densityDpi == DisplayMetrics.DENSITY_DEVICE_DEFAULT) {
                    this.mMetrics.setDensity(DisplayMetrics.DENSITY_PREFERRED);
                } else {
                    this.mMetrics.setDensity(this.mConfiguration.densityDpi);
                }
            }
            this.mMetrics.scaledDensity = this.mMetrics.density * this.mConfiguration.fontScale;
            String str = null;
            if (this.mConfiguration.locale != null) {
                str = adjustLanguageTag(this.mConfiguration.locale.toLanguageTag());
            }
            if (this.mMetrics.widthPixels >= this.mMetrics.heightPixels) {
                i = this.mMetrics.widthPixels;
                i2 = this.mMetrics.heightPixels;
            } else {
                i = this.mMetrics.heightPixels;
                i2 = this.mMetrics.widthPixels;
            }
            int i3 = this.mConfiguration.keyboardHidden;
            int i4 = i3;
            if (i3 == 1) {
                i4 = i3;
                if (this.mConfiguration.hardKeyboardHidden == 2) {
                    i4 = 3;
                }
            }
            this.mAssets.setConfiguration(this.mConfiguration.mcc, this.mConfiguration.mnc, str, this.mConfiguration.orientation, this.mConfiguration.touchscreen, this.mConfiguration.densityDpi, this.mConfiguration.keyboard, i4, this.mConfiguration.navigation, i, i2, this.mConfiguration.smallestScreenWidthDp, this.mConfiguration.screenWidthDp, this.mConfiguration.screenHeightDp, this.mConfiguration.screenLayout, this.mConfiguration.uiMode, Build.VERSION.RESOURCES_SDK_INT);
            clearDrawableCachesLocked(this.mDrawableCache, calcConfigChanges);
            clearDrawableCachesLocked(this.mColorDrawableCache, calcConfigChanges);
            this.mAnimatorCache.onConfigurationChange(calcConfigChanges);
            this.mStateListAnimatorCache.onConfigurationChange(calcConfigChanges);
            this.mColorStateListCache.clear();
            flushLayoutCache();
        }
        synchronized (sSync) {
            if (this.mPluralRule != null) {
                this.mPluralRule = NativePluralRules.forLocale(configuration.locale);
            }
        }
    }

    public final void updateStringCache() {
        synchronized (this.mAccessLock) {
            this.mAssets.recreateStringBlocks();
        }
    }
}
