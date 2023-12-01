package android.content.res;

import android.content.Context;
import android.content.pm.PackageParser;
import android.content.res.Resources;
import android.graphics.Movie;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.internal.util.Protocol;
import com.blued.android.chat.grpc.backup.MsgBackupManager;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LayoutInflated;
import de.robv.android.xposed.callbacks.XCallback;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import xposed.dummy.XResourcesSuperClass;
import xposed.dummy.XTypedArraySuperClass;

/* loaded from: source-259656-dex2jar.jar:android/content/res/XResources.class */
public class XResources extends XResourcesSuperClass {
    private static final String EXTRA_XML_INSTANCE_DETAILS = "xmlInstanceDetails";
    private boolean mIsObjectInited;
    private String mPackageName;
    private byte[] mReplacementsCache;
    private String mResDir;
    private static final SparseArray<HashMap<String, Object>> sReplacements = new SparseArray<>();
    private static final SparseArray<HashMap<String, ResourceNames>> sResourceNames = new SparseArray<>();
    private static final byte[] sSystemReplacementsCache = new byte[256];
    private static final HashMap<String, byte[]> sReplacementsCacheMap = new HashMap<>();
    private static final SparseArray<ColorStateList> sColorStateListCache = new SparseArray<>(0);
    private static final SparseArray<HashMap<String, XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated>>> sLayoutCallbacks = new SparseArray<>();
    private static final WeakHashMap<XmlResourceParser, XMLInstanceDetails> sXmlInstanceDetails = new WeakHashMap<>();
    private static final ThreadLocal<LinkedList<XC_MethodHook.MethodHookParam>> sIncludedLayouts = new ThreadLocal<LinkedList<XC_MethodHook.MethodHookParam>>() { // from class: android.content.res.XResources.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public LinkedList<XC_MethodHook.MethodHookParam> initialValue() {
            return new LinkedList<>();
        }
    };
    private static final HashMap<String, Long> sResDirLastModified = new HashMap<>();
    private static final HashMap<String, String> sResDirPackageNames = new HashMap<>();
    private static ThreadLocal<Object> sLatestResKey = null;

    /* loaded from: source-259656-dex2jar.jar:android/content/res/XResources$DimensionReplacement.class */
    public static class DimensionReplacement {
        private final int mUnit;
        private final float mValue;

        public DimensionReplacement(float f, int i) {
            this.mValue = f;
            this.mUnit = i;
        }

        public float getDimension(DisplayMetrics displayMetrics) {
            return TypedValue.applyDimension(this.mUnit, this.mValue, displayMetrics);
        }

        public int getDimensionPixelOffset(DisplayMetrics displayMetrics) {
            return (int) TypedValue.applyDimension(this.mUnit, this.mValue, displayMetrics);
        }

        public int getDimensionPixelSize(DisplayMetrics displayMetrics) {
            int applyDimension = (int) (0.5f + TypedValue.applyDimension(this.mUnit, this.mValue, displayMetrics));
            if (applyDimension != 0) {
                return applyDimension;
            }
            if (this.mValue == 0.0f) {
                return 0;
            }
            return this.mValue > 0.0f ? 1 : -1;
        }
    }

    /* loaded from: source-259656-dex2jar.jar:android/content/res/XResources$DrawableLoader.class */
    public static abstract class DrawableLoader {
        public abstract Drawable newDrawable(XResources xResources, int i) throws Throwable;

        public Drawable newDrawableForDensity(XResources xResources, int i, int i2) throws Throwable {
            return newDrawable(xResources, i);
        }
    }

    /* loaded from: source-259656-dex2jar.jar:android/content/res/XResources$ResourceNames.class */
    public static class ResourceNames {
        public final String fullName;
        public final int id;
        public final String name;
        public final String pkg;
        public final String type;

        private ResourceNames(int i, String str, String str2, String str3) {
            this.id = i;
            this.pkg = str;
            this.name = str2;
            this.type = str3;
            this.fullName = str + ":" + str3 + BridgeUtil.SPLIT_MARK + str2;
        }

        public boolean equals(String str, String str2, String str3, int i) {
            if (str == null || str.equals(this.pkg)) {
                if (str2 == null || str2.equals(this.name)) {
                    if (str3 == null || str3.equals(this.type)) {
                        return i == 0 || i == this.id;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: source-259656-dex2jar.jar:android/content/res/XResources$XMLInstanceDetails.class */
    private class XMLInstanceDetails {
        public final XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated> callbacks;
        public final XResources res;
        public final ResourceNames resNames;
        public final String variant;

        private XMLInstanceDetails(ResourceNames resourceNames, String str, XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated> copyOnWriteSortedSet) {
            this.res = XResources.this;
            this.resNames = resourceNames;
            this.variant = str;
            this.callbacks = copyOnWriteSortedSet;
        }
    }

    /* loaded from: source-259656-dex2jar.jar:android/content/res/XResources$XTypedArray.class */
    public static class XTypedArray extends XTypedArraySuperClass {
        private XTypedArray() {
            super((Resources) null, (int[]) null, (int[]) null, 0);
            throw new UnsupportedOperationException();
        }

        public boolean getBoolean(int i, boolean z) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(i, 0));
            return replacement instanceof Boolean ? ((Boolean) replacement).booleanValue() : replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getBoolean(((XResForwarder) replacement).getId()) : super.getBoolean(i, z);
        }

        public int getColor(int i, int i2) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(i, 0));
            return replacement instanceof Integer ? ((Integer) replacement).intValue() : replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getColor(((XResForwarder) replacement).getId()) : super.getColor(i, i2);
        }

        public ColorStateList getColorStateList(int i) {
            ColorStateList colorStateList;
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(i, 0));
            if (replacement instanceof ColorStateList) {
                return (ColorStateList) replacement;
            }
            if (!(replacement instanceof Integer)) {
                return replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getColorStateList(((XResForwarder) replacement).getId()) : super.getColorStateList(i);
            }
            int intValue = ((Integer) replacement).intValue();
            synchronized (XResources.sColorStateListCache) {
                ColorStateList colorStateList2 = (ColorStateList) XResources.sColorStateListCache.get(intValue);
                colorStateList = colorStateList2;
                if (colorStateList2 == null) {
                    colorStateList = ColorStateList.valueOf(intValue);
                    XResources.sColorStateListCache.put(intValue, colorStateList);
                }
            }
            return colorStateList;
        }

        public float getDimension(int i, float f) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(i, 0));
            return replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getDimension(((XResForwarder) replacement).getId()) : super.getDimension(i, f);
        }

        public int getDimensionPixelOffset(int i, int i2) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(i, 0));
            return replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getDimensionPixelOffset(((XResForwarder) replacement).getId()) : super.getDimensionPixelOffset(i, i2);
        }

        public int getDimensionPixelSize(int i, int i2) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(i, 0));
            return replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getDimensionPixelSize(((XResForwarder) replacement).getId()) : super.getDimensionPixelSize(i, i2);
        }

        public Drawable getDrawable(int i) {
            int resourceId = getResourceId(i, 0);
            XResources xResources = (XResources) getResources();
            Object replacement = xResources.getReplacement(resourceId);
            if (replacement instanceof DrawableLoader) {
                try {
                    Drawable newDrawable = ((DrawableLoader) replacement).newDrawable(xResources, resourceId);
                    if (newDrawable != null) {
                        return newDrawable;
                    }
                } catch (Throwable th) {
                    XposedBridge.log(th);
                }
            } else if (replacement instanceof Integer) {
                return new ColorDrawable(((Integer) replacement).intValue());
            } else {
                if (replacement instanceof XResForwarder) {
                    return ((XResForwarder) replacement).getResources().getDrawable(((XResForwarder) replacement).getId());
                }
            }
            return super.getDrawable(i);
        }

        public float getFloat(int i, float f) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(i, 0));
            return replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getDimension(((XResForwarder) replacement).getId()) : super.getFloat(i, f);
        }

        public float getFraction(int i, int i2, int i3, float f) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(i, 0));
            return replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getFraction(((XResForwarder) replacement).getId(), i2, i3) : super.getFraction(i, i2, i3, f);
        }

        public int getInt(int i, int i2) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(i, 0));
            return replacement instanceof Integer ? ((Integer) replacement).intValue() : replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getInteger(((XResForwarder) replacement).getId()) : super.getInt(i, i2);
        }

        public int getInteger(int i, int i2) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(i, 0));
            return replacement instanceof Integer ? ((Integer) replacement).intValue() : replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getInteger(((XResForwarder) replacement).getId()) : super.getInteger(i, i2);
        }

        public int getLayoutDimension(int i, int i2) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(i, 0));
            return replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getDimensionPixelSize(((XResForwarder) replacement).getId()) : super.getLayoutDimension(i, i2);
        }

        public int getLayoutDimension(int i, String str) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(i, 0));
            return replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getDimensionPixelSize(((XResForwarder) replacement).getId()) : super.getLayoutDimension(i, str);
        }

        public String getString(int i) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(i, 0));
            return replacement instanceof CharSequence ? replacement.toString() : replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getString(((XResForwarder) replacement).getId()) : super.getString(i);
        }

        public CharSequence getText(int i) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(i, 0));
            return replacement instanceof CharSequence ? (CharSequence) replacement : replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getText(((XResForwarder) replacement).getId()) : super.getText(i);
        }

        public CharSequence[] getTextArray(int i) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(i, 0));
            return replacement instanceof CharSequence[] ? (CharSequence[]) replacement : replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getTextArray(((XResForwarder) replacement).getId()) : super.getTextArray(i);
        }
    }

    private XResources() {
        throw new UnsupportedOperationException();
    }

    public static int getFakeResId(Resources resources, int i) {
        return getFakeResId(resources.getResourceName(i));
    }

    public static int getFakeResId(String str) {
        return 2113929216 | (str.hashCode() & 16777215);
    }

    private static String getPackageName(String str) {
        String str2;
        String str3;
        PackageParser.PackageLite parsePackageLite;
        if (str == null) {
            str3 = MsgBackupManager.PLATFORM_ANDROID;
        } else {
            synchronized (sResDirPackageNames) {
                str2 = sResDirPackageNames.get(str);
            }
            str3 = str2;
            if (str2 == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        parsePackageLite = PackageParser.parsePackageLite(new File(str), 0);
                    } catch (PackageParser.PackageParserException e) {
                        throw new IllegalStateException("Could not determine package name for " + str, e);
                    }
                } else {
                    parsePackageLite = PackageParser.parsePackageLite(str, 0);
                }
                if (parsePackageLite == null || parsePackageLite.packageName == null) {
                    throw new IllegalStateException("Could not determine package name for " + str);
                }
                Log.w(XposedBridge.TAG, "Package name for " + str + " had to be retrieved via parser");
                String str4 = parsePackageLite.packageName;
                setPackageNameForResDir(str4, str);
                return str4;
            }
        }
        return str3;
    }

    public static String getPackageNameDuringConstruction() {
        Object obj;
        if (sLatestResKey == null || (obj = sLatestResKey.get()) == null) {
            throw new IllegalStateException("This method can only be called during getTopLevelResources()");
        }
        return getPackageName((String) XposedHelpers.getObjectField(obj, "mResDir"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object getReplacement(int i) {
        HashMap<String, Object> hashMap;
        if (i <= 0) {
            return null;
        }
        if (i < 2130706432) {
            if ((sSystemReplacementsCache[((i & Protocol.BASE_NETWORK_STATE_TRACKER) >> 11) | ((i & 248) >> 3)] & (1 << (i & 7))) == 0) {
                return null;
            }
        } else if (this.mResDir != null && (this.mReplacementsCache[((i & Protocol.BASE_NETWORK_STATE_TRACKER) >> 12) | ((i & 120) >> 3)] & (1 << (i & 7))) == 0) {
            return null;
        }
        synchronized (sReplacements) {
            hashMap = sReplacements.get(i);
        }
        if (hashMap != null) {
            synchronized (hashMap) {
                Object obj = hashMap.get(this.mResDir);
                if (obj != null || this.mResDir == null) {
                    return obj;
                }
                return hashMap.get(null);
            }
        }
        return null;
    }

    private ResourceNames getResourceNames(int i) {
        return new ResourceNames(i, getResourcePackageName(i), getResourceTypeName(i), getResourceEntryName(i));
    }

    private static ResourceNames getSystemResourceNames(int i) {
        Resources system = getSystem();
        return new ResourceNames(i, system.getResourcePackageName(i), system.getResourceTypeName(i), system.getResourceEntryName(i));
    }

    private static XC_LayoutInflated.Unhook hookLayoutInternal(String str, int i, ResourceNames resourceNames, XC_LayoutInflated xC_LayoutInflated) {
        HashMap<String, XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated>> hashMap;
        if (i == 0) {
            throw new IllegalArgumentException("id 0 is not an allowed resource identifier");
        }
        synchronized (sLayoutCallbacks) {
            HashMap<String, XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated>> hashMap2 = sLayoutCallbacks.get(i);
            hashMap = hashMap2;
            if (hashMap2 == null) {
                hashMap = new HashMap<>();
                sLayoutCallbacks.put(i, hashMap);
            }
        }
        synchronized (hashMap) {
            try {
                XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated> copyOnWriteSortedSet = hashMap.get(str);
                XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated> copyOnWriteSortedSet2 = copyOnWriteSortedSet;
                if (copyOnWriteSortedSet == null) {
                    copyOnWriteSortedSet2 = new XposedBridge.CopyOnWriteSortedSet<>();
                    hashMap.put(str, copyOnWriteSortedSet2);
                }
            } finally {
                XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated> copyOnWriteSortedSet3 = hashMap;
            }
        }
        hashMap.add(xC_LayoutInflated);
        putResourceNames(str, resourceNames);
        xC_LayoutInflated.getClass();
        return new XC_LayoutInflated.Unhook(str, i);
    }

    public static XC_LayoutInflated.Unhook hookSystemWideLayout(int i, XC_LayoutInflated xC_LayoutInflated) {
        if (i >= 2130706432) {
            throw new IllegalArgumentException("ids >= 0x7f000000 are app specific and cannot be set for the framework");
        }
        return hookLayoutInternal(null, i, getSystemResourceNames(i), xC_LayoutInflated);
    }

    @Deprecated
    public static XC_LayoutInflated.Unhook hookSystemWideLayout(String str, XC_LayoutInflated xC_LayoutInflated) {
        int identifier = getSystem().getIdentifier(str, null, null);
        if (identifier == 0) {
            throw new Resources.NotFoundException(str);
        }
        return hookSystemWideLayout(identifier, xC_LayoutInflated);
    }

    public static XC_LayoutInflated.Unhook hookSystemWideLayout(String str, String str2, String str3, XC_LayoutInflated xC_LayoutInflated) {
        int identifier = getSystem().getIdentifier(str3, str2, str);
        if (identifier == 0) {
            throw new Resources.NotFoundException(str + ":" + str2 + BridgeUtil.SPLIT_MARK + str3);
        }
        return hookSystemWideLayout(identifier, xC_LayoutInflated);
    }

    public static void init(ThreadLocal<Object> threadLocal) throws Exception {
        sLatestResKey = threadLocal;
        XposedHelpers.findAndHookMethod(LayoutInflater.class, "inflate", XmlPullParser.class, ViewGroup.class, Boolean.TYPE, new XC_MethodHook() { // from class: android.content.res.XResources.2
            @Override // de.robv.android.xposed.XC_MethodHook
            protected void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                XMLInstanceDetails xMLInstanceDetails;
                if (methodHookParam.hasThrowable()) {
                    return;
                }
                synchronized (XResources.sXmlInstanceDetails) {
                    xMLInstanceDetails = (XMLInstanceDetails) XResources.sXmlInstanceDetails.get(methodHookParam.args[0]);
                }
                if (xMLInstanceDetails != null) {
                    XC_LayoutInflated.LayoutInflatedParam layoutInflatedParam = new XC_LayoutInflated.LayoutInflatedParam(xMLInstanceDetails.callbacks);
                    layoutInflatedParam.view = (View) methodHookParam.getResult();
                    layoutInflatedParam.resNames = xMLInstanceDetails.resNames;
                    layoutInflatedParam.variant = xMLInstanceDetails.variant;
                    layoutInflatedParam.res = xMLInstanceDetails.res;
                    XCallback.callAll(layoutInflatedParam);
                }
            }
        });
        XC_MethodHook xC_MethodHook = new XC_MethodHook() { // from class: android.content.res.XResources.3
            @Override // de.robv.android.xposed.XC_MethodHook
            protected void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                XMLInstanceDetails xMLInstanceDetails;
                ((LinkedList) XResources.sIncludedLayouts.get()).pop();
                if (methodHookParam.hasThrowable() || (xMLInstanceDetails = (XMLInstanceDetails) methodHookParam.getObjectExtra(XResources.EXTRA_XML_INSTANCE_DETAILS)) == null) {
                    return;
                }
                XC_LayoutInflated.LayoutInflatedParam layoutInflatedParam = new XC_LayoutInflated.LayoutInflatedParam(xMLInstanceDetails.callbacks);
                ViewGroup viewGroup = (ViewGroup) methodHookParam.args[(Build.VERSION.SDK_INT < 23 ? (byte) 1 : (byte) 2) == 1 ? 1 : 0];
                layoutInflatedParam.view = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
                layoutInflatedParam.resNames = xMLInstanceDetails.resNames;
                layoutInflatedParam.variant = xMLInstanceDetails.variant;
                layoutInflatedParam.res = xMLInstanceDetails.res;
                XCallback.callAll(layoutInflatedParam);
            }

            @Override // de.robv.android.xposed.XC_MethodHook
            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                ((LinkedList) XResources.sIncludedLayouts.get()).push(methodHookParam);
            }
        };
        if (Build.VERSION.SDK_INT < 21) {
            XposedHelpers.findAndHookMethod(LayoutInflater.class, "parseInclude", XmlPullParser.class, View.class, AttributeSet.class, xC_MethodHook);
        } else if (Build.VERSION.SDK_INT < 23) {
            XposedHelpers.findAndHookMethod(LayoutInflater.class, "parseInclude", XmlPullParser.class, View.class, AttributeSet.class, Boolean.TYPE, xC_MethodHook);
        } else {
            XposedHelpers.findAndHookMethod(LayoutInflater.class, "parseInclude", XmlPullParser.class, Context.class, View.class, AttributeSet.class, xC_MethodHook);
        }
    }

    private static boolean isXmlCached(Resources resources, int i) {
        int[] iArr = (int[]) XposedHelpers.getObjectField(resources, "mCachedXmlBlockIds");
        synchronized (iArr) {
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return false;
                }
                if (iArr[i3] == i) {
                    return true;
                }
                i2 = i3 + 1;
            }
        }
    }

    private static void putResourceNames(String str, ResourceNames resourceNames) {
        int i = resourceNames.id;
        synchronized (sResourceNames) {
            HashMap<String, ResourceNames> hashMap = sResourceNames.get(i);
            HashMap<String, ResourceNames> hashMap2 = hashMap;
            if (hashMap == null) {
                hashMap2 = new HashMap<>();
                sResourceNames.put(i, hashMap2);
            }
            synchronized (hashMap2) {
                hashMap2.put(str, resourceNames);
            }
        }
    }

    private static native void rewriteXmlReferencesNative(long j, XResources xResources, Resources resources);

    public static void setPackageNameForResDir(String str, String str2) {
        synchronized (sResDirPackageNames) {
            sResDirPackageNames.put(str2, str);
        }
    }

    private static void setReplacement(int i, Object obj, XResources xResources) {
        String str = xResources != null ? xResources.mResDir : null;
        if (i == 0) {
            throw new IllegalArgumentException("id 0 is not an allowed resource identifier");
        }
        if (str == null && i >= 2130706432) {
            throw new IllegalArgumentException("ids >= 0x7f000000 are app specific and cannot be set for the framework");
        }
        if (obj instanceof Drawable) {
            throw new IllegalArgumentException("Drawable replacements are deprecated since Xposed 2.1. Use DrawableLoader instead.");
        }
        if (i < 2130706432) {
            int i2 = ((i & Protocol.BASE_NETWORK_STATE_TRACKER) >> 11) | ((i & 248) >> 3);
            str = sSystemReplacementsCache;
            synchronized (str) {
                try {
                    byte[] bArr = sSystemReplacementsCache;
                    bArr[i2] = (byte) (bArr[i2] | (1 << (i & 7)));
                } finally {
                    String str2 = str;
                }
            }
        } else {
            int i3 = ((i & Protocol.BASE_NETWORK_STATE_TRACKER) >> 12) | ((i & 120) >> 3);
            synchronized (xResources.mReplacementsCache) {
                str = xResources.mReplacementsCache;
                str[i3] = (byte) (str[i3] | (1 << (i & 7)));
            }
        }
        synchronized (sReplacements) {
            HashMap<String, Object> hashMap = sReplacements.get(i);
            HashMap<String, Object> hashMap2 = hashMap;
            if (hashMap == null) {
                hashMap2 = new HashMap<>();
                sReplacements.put(i, hashMap2);
            }
            str.put(str, obj);
        }
    }

    public static void setSystemWideReplacement(int i, Object obj) {
        setReplacement(i, obj, null);
    }

    @Deprecated
    public static void setSystemWideReplacement(String str, Object obj) {
        int identifier = getSystem().getIdentifier(str, null, null);
        if (identifier == 0) {
            throw new Resources.NotFoundException(str);
        }
        setReplacement(identifier, obj, null);
    }

    public static void setSystemWideReplacement(String str, String str2, String str3, Object obj) {
        int identifier = getSystem().getIdentifier(str3, str2, str);
        if (identifier == 0) {
            throw new Resources.NotFoundException(str + ":" + str2 + BridgeUtil.SPLIT_MARK + str3);
        }
        setReplacement(identifier, obj, null);
    }

    private static int translateAttrId(String str, XResources xResources) {
        try {
            return xResources.getIdentifier(str, "attr", xResources.mPackageName);
        } catch (Resources.NotFoundException e) {
            XposedBridge.log("Attribute " + str + " not found in original resources");
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0092 A[Catch: Exception -> 0x00bb, TRY_ENTER, TryCatch #1 {Exception -> 0x00bb, blocks: (B:2:0x0000, B:4:0x0016, B:7:0x0028, B:9:0x0043, B:16:0x005b, B:18:0x0066, B:22:0x0092, B:25:0x009e, B:27:0x00a9), top: B:40:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int translateResId(int r7, android.content.res.XResources r8, android.content.res.Resources r9) {
        /*
            Method dump skipped, instructions count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.res.XResources.translateResId(int, android.content.res.XResources, android.content.res.Resources):int");
    }

    public static void unhookLayout(String str, int i, XC_LayoutInflated xC_LayoutInflated) {
        synchronized (sLayoutCallbacks) {
            HashMap<String, XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated>> hashMap = sLayoutCallbacks.get(i);
            if (hashMap == null) {
                return;
            }
            synchronized (hashMap) {
                XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated> copyOnWriteSortedSet = hashMap.get(str);
                if (copyOnWriteSortedSet == null) {
                    return;
                }
                copyOnWriteSortedSet.remove(xC_LayoutInflated);
            }
        }
    }

    public int addResource(Resources resources, int i) {
        int fakeResId = getFakeResId(resources, i);
        synchronized (sReplacements) {
            if (sReplacements.indexOfKey(fakeResId) < 0) {
                setReplacement(fakeResId, new XResForwarder(resources, i));
            }
        }
        return fakeResId;
    }

    public XmlResourceParser getAnimation(int i) throws Resources.NotFoundException {
        Object replacement = getReplacement(i);
        if (replacement instanceof XResForwarder) {
            Resources resources = ((XResForwarder) replacement).getResources();
            int id = ((XResForwarder) replacement).getId();
            boolean isXmlCached = isXmlCached(resources, id);
            XmlResourceParser animation = resources.getAnimation(id);
            if (!isXmlCached) {
                rewriteXmlReferencesNative(Build.VERSION.SDK_INT >= 21 ? XposedHelpers.getLongField(animation, "mParseState") : XposedHelpers.getIntField(animation, "mParseState"), this, resources);
            }
            return animation;
        }
        return super.getAnimation(i);
    }

    public boolean getBoolean(int i) throws Resources.NotFoundException {
        Object replacement = getReplacement(i);
        return replacement instanceof Boolean ? ((Boolean) replacement).booleanValue() : replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getBoolean(((XResForwarder) replacement).getId()) : super.getBoolean(i);
    }

    public int getColor(int i) throws Resources.NotFoundException {
        Object replacement = getReplacement(i);
        return replacement instanceof Integer ? ((Integer) replacement).intValue() : replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getColor(((XResForwarder) replacement).getId()) : super.getColor(i);
    }

    public ColorStateList getColorStateList(int i) throws Resources.NotFoundException {
        ColorStateList colorStateList;
        Object replacement = getReplacement(i);
        if (replacement instanceof ColorStateList) {
            return (ColorStateList) replacement;
        }
        if (!(replacement instanceof Integer)) {
            return replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getColorStateList(((XResForwarder) replacement).getId()) : super.getColorStateList(i);
        }
        int intValue = ((Integer) replacement).intValue();
        synchronized (sColorStateListCache) {
            ColorStateList colorStateList2 = sColorStateListCache.get(intValue);
            colorStateList = colorStateList2;
            if (colorStateList2 == null) {
                colorStateList = ColorStateList.valueOf(intValue);
                sColorStateListCache.put(intValue, colorStateList);
            }
        }
        return colorStateList;
    }

    public float getDimension(int i) throws Resources.NotFoundException {
        Object replacement = getReplacement(i);
        return replacement instanceof DimensionReplacement ? ((DimensionReplacement) replacement).getDimension(getDisplayMetrics()) : replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getDimension(((XResForwarder) replacement).getId()) : super.getDimension(i);
    }

    public int getDimensionPixelOffset(int i) throws Resources.NotFoundException {
        Object replacement = getReplacement(i);
        return replacement instanceof DimensionReplacement ? ((DimensionReplacement) replacement).getDimensionPixelOffset(getDisplayMetrics()) : replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getDimensionPixelOffset(((XResForwarder) replacement).getId()) : super.getDimensionPixelOffset(i);
    }

    public int getDimensionPixelSize(int i) throws Resources.NotFoundException {
        Object replacement = getReplacement(i);
        return replacement instanceof DimensionReplacement ? ((DimensionReplacement) replacement).getDimensionPixelSize(getDisplayMetrics()) : replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getDimensionPixelSize(((XResForwarder) replacement).getId()) : super.getDimensionPixelSize(i);
    }

    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        try {
            if (XposedHelpers.incrementMethodDepth("getDrawable") == 1) {
                Object replacement = getReplacement(i);
                if (replacement instanceof DrawableLoader) {
                    Drawable newDrawable = ((DrawableLoader) replacement).newDrawable(this, i);
                    if (newDrawable != null) {
                        return newDrawable;
                    }
                } else if (replacement instanceof Integer) {
                    ColorDrawable colorDrawable = new ColorDrawable(((Integer) replacement).intValue());
                    XposedHelpers.decrementMethodDepth("getDrawable");
                    return colorDrawable;
                } else if (replacement instanceof XResForwarder) {
                    Drawable drawable = ((XResForwarder) replacement).getResources().getDrawable(((XResForwarder) replacement).getId());
                    XposedHelpers.decrementMethodDepth("getDrawable");
                    return drawable;
                }
            }
            Drawable drawable2 = super.getDrawable(i);
            XposedHelpers.decrementMethodDepth("getDrawable");
            return drawable2;
        } finally {
            XposedHelpers.decrementMethodDepth("getDrawable");
        }
    }

    public Drawable getDrawable(int i, Resources.Theme theme) throws Resources.NotFoundException {
        try {
            if (XposedHelpers.incrementMethodDepth("getDrawable") == 1) {
                Object replacement = getReplacement(i);
                if (replacement instanceof DrawableLoader) {
                    Drawable newDrawable = ((DrawableLoader) replacement).newDrawable(this, i);
                    if (newDrawable != null) {
                        return newDrawable;
                    }
                } else if (replacement instanceof Integer) {
                    ColorDrawable colorDrawable = new ColorDrawable(((Integer) replacement).intValue());
                    XposedHelpers.decrementMethodDepth("getDrawable");
                    return colorDrawable;
                } else if (replacement instanceof XResForwarder) {
                    Drawable drawable = ((XResForwarder) replacement).getResources().getDrawable(((XResForwarder) replacement).getId());
                    XposedHelpers.decrementMethodDepth("getDrawable");
                    return drawable;
                }
            }
            Drawable drawable2 = super.getDrawable(i, theme);
            XposedHelpers.decrementMethodDepth("getDrawable");
            return drawable2;
        } finally {
            XposedHelpers.decrementMethodDepth("getDrawable");
        }
    }

    public Drawable getDrawable(int i, Resources.Theme theme, boolean z) throws Resources.NotFoundException {
        try {
            if (XposedHelpers.incrementMethodDepth("getDrawable") == 1) {
                Object replacement = getReplacement(i);
                if (replacement instanceof DrawableLoader) {
                    Drawable newDrawable = ((DrawableLoader) replacement).newDrawable(this, i);
                    if (newDrawable != null) {
                        return newDrawable;
                    }
                } else if (replacement instanceof Integer) {
                    ColorDrawable colorDrawable = new ColorDrawable(((Integer) replacement).intValue());
                    XposedHelpers.decrementMethodDepth("getDrawable");
                    return colorDrawable;
                } else if (replacement instanceof XResForwarder) {
                    Drawable drawable = ((XResForwarder) replacement).getResources().getDrawable(((XResForwarder) replacement).getId());
                    XposedHelpers.decrementMethodDepth("getDrawable");
                    return drawable;
                }
            }
            Drawable drawable2 = super.getDrawable(i, theme, z);
            XposedHelpers.decrementMethodDepth("getDrawable");
            return drawable2;
        } finally {
            XposedHelpers.decrementMethodDepth("getDrawable");
        }
    }

    public Drawable getDrawableForDensity(int i, int i2) throws Resources.NotFoundException {
        try {
            if (XposedHelpers.incrementMethodDepth("getDrawableForDensity") == 1) {
                Object replacement = getReplacement(i);
                if (replacement instanceof DrawableLoader) {
                    Drawable newDrawableForDensity = ((DrawableLoader) replacement).newDrawableForDensity(this, i, i2);
                    if (newDrawableForDensity != null) {
                        return newDrawableForDensity;
                    }
                } else if (replacement instanceof Integer) {
                    ColorDrawable colorDrawable = new ColorDrawable(((Integer) replacement).intValue());
                    XposedHelpers.decrementMethodDepth("getDrawableForDensity");
                    return colorDrawable;
                } else if (replacement instanceof XResForwarder) {
                    Drawable drawableForDensity = ((XResForwarder) replacement).getResources().getDrawableForDensity(((XResForwarder) replacement).getId(), i2);
                    XposedHelpers.decrementMethodDepth("getDrawableForDensity");
                    return drawableForDensity;
                }
            }
            Drawable drawableForDensity2 = super.getDrawableForDensity(i, i2);
            XposedHelpers.decrementMethodDepth("getDrawableForDensity");
            return drawableForDensity2;
        } finally {
            XposedHelpers.decrementMethodDepth("getDrawableForDensity");
        }
    }

    public Drawable getDrawableForDensity(int i, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        try {
            if (XposedHelpers.incrementMethodDepth("getDrawableForDensity") == 1) {
                Object replacement = getReplacement(i);
                if (replacement instanceof DrawableLoader) {
                    Drawable newDrawableForDensity = ((DrawableLoader) replacement).newDrawableForDensity(this, i, i2);
                    if (newDrawableForDensity != null) {
                        return newDrawableForDensity;
                    }
                } else if (replacement instanceof Integer) {
                    ColorDrawable colorDrawable = new ColorDrawable(((Integer) replacement).intValue());
                    XposedHelpers.decrementMethodDepth("getDrawableForDensity");
                    return colorDrawable;
                } else if (replacement instanceof XResForwarder) {
                    Drawable drawableForDensity = ((XResForwarder) replacement).getResources().getDrawableForDensity(((XResForwarder) replacement).getId(), i2);
                    XposedHelpers.decrementMethodDepth("getDrawableForDensity");
                    return drawableForDensity;
                }
            }
            Drawable drawableForDensity2 = super.getDrawableForDensity(i, i2, theme);
            XposedHelpers.decrementMethodDepth("getDrawableForDensity");
            return drawableForDensity2;
        } finally {
            XposedHelpers.decrementMethodDepth("getDrawableForDensity");
        }
    }

    public Drawable getDrawableForDensity(int i, int i2, Resources.Theme theme, boolean z) throws Resources.NotFoundException {
        try {
            if (XposedHelpers.incrementMethodDepth("getDrawableForDensity") == 1) {
                Object replacement = getReplacement(i);
                if (replacement instanceof DrawableLoader) {
                    Drawable newDrawableForDensity = ((DrawableLoader) replacement).newDrawableForDensity(this, i, i2);
                    if (newDrawableForDensity != null) {
                        return newDrawableForDensity;
                    }
                } else if (replacement instanceof Integer) {
                    ColorDrawable colorDrawable = new ColorDrawable(((Integer) replacement).intValue());
                    XposedHelpers.decrementMethodDepth("getDrawableForDensity");
                    return colorDrawable;
                } else if (replacement instanceof XResForwarder) {
                    Drawable drawableForDensity = ((XResForwarder) replacement).getResources().getDrawableForDensity(((XResForwarder) replacement).getId(), i2);
                    XposedHelpers.decrementMethodDepth("getDrawableForDensity");
                    return drawableForDensity;
                }
            }
            Drawable drawableForDensity2 = super.getDrawableForDensity(i, i2, theme, z);
            XposedHelpers.decrementMethodDepth("getDrawableForDensity");
            return drawableForDensity2;
        } finally {
            XposedHelpers.decrementMethodDepth("getDrawableForDensity");
        }
    }

    public float getFraction(int i, int i2, int i3) {
        Object replacement = getReplacement(i);
        return replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getFraction(((XResForwarder) replacement).getId(), i2, i3) : super.getFraction(i, i2, i3);
    }

    public int[] getIntArray(int i) throws Resources.NotFoundException {
        Object replacement = getReplacement(i);
        return replacement instanceof int[] ? (int[]) replacement : replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getIntArray(((XResForwarder) replacement).getId()) : super.getIntArray(i);
    }

    public int getInteger(int i) throws Resources.NotFoundException {
        Object replacement = getReplacement(i);
        return replacement instanceof Integer ? ((Integer) replacement).intValue() : replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getInteger(((XResForwarder) replacement).getId()) : super.getInteger(i);
    }

    public XmlResourceParser getLayout(int i) throws Resources.NotFoundException {
        XmlResourceParser layout;
        HashMap<String, XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated>> hashMap;
        XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated> copyOnWriteSortedSet;
        Object replacement = getReplacement(i);
        if (replacement instanceof XResForwarder) {
            Resources resources = ((XResForwarder) replacement).getResources();
            int id = ((XResForwarder) replacement).getId();
            boolean isXmlCached = isXmlCached(resources, id);
            XmlResourceParser layout2 = resources.getLayout(id);
            layout = layout2;
            if (!isXmlCached) {
                rewriteXmlReferencesNative(Build.VERSION.SDK_INT >= 21 ? XposedHelpers.getLongField(layout2, "mParseState") : XposedHelpers.getIntField(layout2, "mParseState"), this, resources);
                layout = layout2;
            }
        } else {
            layout = super.getLayout(i);
        }
        synchronized (sLayoutCallbacks) {
            hashMap = sLayoutCallbacks.get(i);
        }
        if (hashMap != null) {
            synchronized (hashMap) {
                XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated> copyOnWriteSortedSet2 = hashMap.get(this.mResDir);
                copyOnWriteSortedSet = copyOnWriteSortedSet2;
                if (copyOnWriteSortedSet2 == null) {
                    copyOnWriteSortedSet = copyOnWriteSortedSet2;
                    if (this.mResDir != null) {
                        copyOnWriteSortedSet = hashMap.get(null);
                    }
                }
            }
            if (copyOnWriteSortedSet != null) {
                String str = "layout";
                TypedValue typedValue = (TypedValue) XposedHelpers.getObjectField(this, "mTmpValue");
                getValue(i, typedValue, true);
                if (typedValue.type == 3) {
                    String[] split = typedValue.string.toString().split(BridgeUtil.SPLIT_MARK, 3);
                    if (split.length == 3) {
                        str = split[1];
                    } else {
                        XposedBridge.log("Unexpected resource path \"" + typedValue.string.toString() + "\" for resource id 0x" + Integer.toHexString(i));
                    }
                } else {
                    XposedBridge.log(new Resources.NotFoundException("Could not find file name for resource id 0x") + Integer.toHexString(i));
                }
                synchronized (sXmlInstanceDetails) {
                    synchronized (sResourceNames) {
                        HashMap<String, ResourceNames> hashMap2 = sResourceNames.get(i);
                        if (hashMap2 != null) {
                            synchronized (hashMap2) {
                                XMLInstanceDetails xMLInstanceDetails = new XMLInstanceDetails(hashMap2.get(this.mResDir), str, copyOnWriteSortedSet);
                                sXmlInstanceDetails.put(layout, xMLInstanceDetails);
                                XC_MethodHook.MethodHookParam peek = sIncludedLayouts.get().peek();
                                if (peek != null) {
                                    peek.setObjectExtra(EXTRA_XML_INSTANCE_DETAILS, xMLInstanceDetails);
                                }
                            }
                        }
                    }
                }
            }
        }
        return layout;
    }

    public Movie getMovie(int i) throws Resources.NotFoundException {
        Object replacement = getReplacement(i);
        return replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getMovie(((XResForwarder) replacement).getId()) : super.getMovie(i);
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public CharSequence getQuantityText(int i, int i2) throws Resources.NotFoundException {
        Object replacement = getReplacement(i);
        return replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getQuantityText(((XResForwarder) replacement).getId(), i2) : super.getQuantityText(i, i2);
    }

    public String[] getStringArray(int i) throws Resources.NotFoundException {
        Object replacement = getReplacement(i);
        return replacement instanceof String[] ? (String[]) replacement : replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getStringArray(((XResForwarder) replacement).getId()) : super.getStringArray(i);
    }

    public CharSequence getText(int i) throws Resources.NotFoundException {
        Object replacement = getReplacement(i);
        return replacement instanceof CharSequence ? (CharSequence) replacement : replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getText(((XResForwarder) replacement).getId()) : super.getText(i);
    }

    public CharSequence getText(int i, CharSequence charSequence) {
        Object replacement = getReplacement(i);
        return replacement instanceof CharSequence ? (CharSequence) replacement : replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getText(((XResForwarder) replacement).getId(), charSequence) : super.getText(i, charSequence);
    }

    public CharSequence[] getTextArray(int i) throws Resources.NotFoundException {
        Object replacement = getReplacement(i);
        return replacement instanceof CharSequence[] ? (CharSequence[]) replacement : replacement instanceof XResForwarder ? ((XResForwarder) replacement).getResources().getTextArray(((XResForwarder) replacement).getId()) : super.getTextArray(i);
    }

    public XmlResourceParser getXml(int i) throws Resources.NotFoundException {
        Object replacement = getReplacement(i);
        if (replacement instanceof XResForwarder) {
            Resources resources = ((XResForwarder) replacement).getResources();
            int id = ((XResForwarder) replacement).getId();
            boolean isXmlCached = isXmlCached(resources, id);
            XmlResourceParser xml = resources.getXml(id);
            if (!isXmlCached) {
                rewriteXmlReferencesNative(Build.VERSION.SDK_INT >= 21 ? XposedHelpers.getLongField(xml, "mParseState") : XposedHelpers.getIntField(xml, "mParseState"), this, resources);
            }
            return xml;
        }
        return super.getXml(i);
    }

    public XC_LayoutInflated.Unhook hookLayout(int i, XC_LayoutInflated xC_LayoutInflated) {
        return hookLayoutInternal(this.mResDir, i, getResourceNames(i), xC_LayoutInflated);
    }

    @Deprecated
    public XC_LayoutInflated.Unhook hookLayout(String str, XC_LayoutInflated xC_LayoutInflated) {
        int identifier = getIdentifier(str, null, null);
        if (identifier == 0) {
            throw new Resources.NotFoundException(str);
        }
        return hookLayout(identifier, xC_LayoutInflated);
    }

    public XC_LayoutInflated.Unhook hookLayout(String str, String str2, String str3, XC_LayoutInflated xC_LayoutInflated) {
        int identifier = getIdentifier(str3, str2, str);
        if (identifier == 0) {
            throw new Resources.NotFoundException(str + ":" + str2 + BridgeUtil.SPLIT_MARK + str3);
        }
        return hookLayout(identifier, xC_LayoutInflated);
    }

    public void initObject(String str) {
        if (this.mIsObjectInited) {
            throw new IllegalStateException("Object has already been initialized");
        }
        this.mResDir = str;
        this.mPackageName = getPackageName(str);
        if (str != null) {
            synchronized (sReplacementsCacheMap) {
                this.mReplacementsCache = sReplacementsCacheMap.get(str);
                if (this.mReplacementsCache == null) {
                    this.mReplacementsCache = new byte[128];
                    sReplacementsCacheMap.put(str, this.mReplacementsCache);
                }
            }
        }
        this.mIsObjectInited = true;
    }

    public boolean isFirstLoad() {
        synchronized (sReplacements) {
            if (this.mResDir == null) {
                return false;
            }
            Long valueOf = Long.valueOf(new File(this.mResDir).lastModified());
            Long l = sResDirLastModified.get(this.mResDir);
            if (valueOf.equals(l)) {
                return false;
            }
            sResDirLastModified.put(this.mResDir, valueOf);
            if (l == null) {
                return true;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= sReplacements.size()) {
                    Arrays.fill(this.mReplacementsCache, (byte) 0);
                    return true;
                }
                sReplacements.valueAt(i2).remove(this.mResDir);
                i = i2 + 1;
            }
        }
    }

    public void setReplacement(int i, Object obj) {
        setReplacement(i, obj, this);
    }

    @Deprecated
    public void setReplacement(String str, Object obj) {
        int identifier = getIdentifier(str, null, null);
        if (identifier == 0) {
            throw new Resources.NotFoundException(str);
        }
        setReplacement(identifier, obj, this);
    }

    public void setReplacement(String str, String str2, String str3, Object obj) {
        int identifier = getIdentifier(str3, str2, str);
        if (identifier == 0) {
            throw new Resources.NotFoundException(str + ":" + str2 + BridgeUtil.SPLIT_MARK + str3);
        }
        setReplacement(identifier, obj, this);
    }
}
