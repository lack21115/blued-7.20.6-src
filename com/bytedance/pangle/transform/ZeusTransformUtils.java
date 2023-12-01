package com.bytedance.pangle.transform;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.FileProvider;
import com.bytedance.pangle.PluginContext;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.activity.GeneratePluginActivity;
import com.bytedance.pangle.activity.GenerateProxyActivity;
import com.bytedance.pangle.activity.GenerateProxyAppCompatActivity;
import com.bytedance.pangle.activity.IPluginActivity;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import com.bytedance.pangle.res.PluginResources;
import com.bytedance.pangle.service.PluginIntentService;
import com.bytedance.pangle.service.PluginService;
import com.bytedance.pangle.service.client.ServiceManagerNative;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.wrapper.PluginActivityWrapper;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/transform/ZeusTransformUtils.class */
public class ZeusTransformUtils {
    private static final String TAG = "PluginContextUtils";
    public static Class fragmentClazz;
    static HashMap<String, WeakReference<Context>> contextCache = new HashMap<>();
    static boolean hasEnsure = false;
    static HashMap<String, Constructor<View>> sConstructorMap = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Activity _getActivity(Object obj, String str) {
        try {
            Activity activity = (Activity) MethodUtils.invokeMethod(obj, "getActivity", new Object[0]);
            Activity activity2 = (Activity) wrapperContext(activity, str);
            return activity2 instanceof GenerateProxyActivity ? ((GenerateProxyActivity) activity2).mTargetActivity : (isSupportLibIso(str) || !(activity2 instanceof GenerateProxyAppCompatActivity)) ? (Activity) wrapperContext(activity, str) : ((GenerateProxyAppCompatActivity) activity2).mTargetActivity;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static boolean bindService(Object obj, Intent intent, ServiceConnection serviceConnection, int i, String str) {
        if (obj instanceof Context) {
            return ServiceManagerNative.getInstance().bindServiceNative((Context) obj, intent, serviceConnection, i, str);
        }
        try {
            return ((Boolean) MethodUtils.invokeMethod(obj, "bindService", new Object[]{intent, serviceConnection, Integer.valueOf(i)}, new Class[]{Intent.class, ServiceConnection.class, Integer.TYPE})).booleanValue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void clearConstructorCache() {
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                if (sConstructorMap == null) {
                    sConstructorMap = (HashMap) FieldUtils.readStaticField(LayoutInflater.class, "sConstructorMap");
                }
                for (String str : new HashSet(sConstructorMap.keySet())) {
                    if (!str.startsWith("android.view.") && !str.startsWith("android.widget.") && !str.startsWith("android.webkit.") && str.contains(".")) {
                        sConstructorMap.remove(str);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    private static Context convertProxy2PluginActivity(Context context) {
        try {
            if ((context instanceof GenerateProxyActivity) || (context instanceof GenerateProxyAppCompatActivity)) {
                return (Activity) FieldUtils.readField(context, "mTargetActivity");
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "convertProxy2PluginActivity failed.", th);
        }
        return context;
    }

    private static void ensureFragmentActivity() {
        if (hasEnsure) {
            return;
        }
        try {
            fragmentClazz = Zeus.class.getClassLoader().loadClass("androidx.fragment.app.FragmentActivity");
        } catch (Throwable th) {
            try {
                fragmentClazz = Zeus.class.getClassLoader().loadClass("androidx.fragment.app.FragmentActivity");
            } catch (Throwable th2) {
            }
        }
        hasEnsure = true;
    }

    private static boolean equalsFragmentActivity(Class cls) {
        ensureFragmentActivity();
        Class cls2 = fragmentClazz;
        return cls2 != null && cls == cls2;
    }

    public static Class forName(String str, String str2) {
        return Zeus.getPlugin(str2).mClassLoader.loadClass(str);
    }

    public static Activity getActivity(Object obj, String str) {
        return _getActivity(obj, str);
    }

    public static String getAssetPaths(AssetManager assetManager) {
        StringBuilder sb = new StringBuilder();
        if (assetManager == null) {
            return "";
        }
        try {
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "TransformUtils GetAssetsPaths error. ", th);
        }
        if (Build.VERSION.SDK_INT < 28 && (Build.VERSION.SDK_INT != 27 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
            int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= intValue) {
                    break;
                }
                try {
                    String str = (String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i2 + 1));
                    if (!TextUtils.isEmpty(str)) {
                        sb.append(str);
                    }
                } catch (IndexOutOfBoundsException e) {
                }
                i = i2 + 1;
            }
            return sb.toString();
        }
        Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
        if (objArr != null && objArr.length > 0) {
            int length = objArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    break;
                }
                sb.append((String) MethodUtils.invokeMethod(objArr[i4], "getAssetPath", new Object[0]));
                i3 = i4 + 1;
            }
        }
        return sb.toString();
    }

    public static Context getContext(Object obj, String str) {
        try {
            Context context = (Context) MethodUtils.invokeMethod(obj, "getContext", new Object[0]);
            if ((isSupportLibIso(str) || !instanceOfFragmentActivity(context)) && !(context instanceof Activity) && !(context instanceof Application) && (context instanceof PluginContext)) {
                return context;
            }
            return wrapperContext(context, str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Context getContextIfNeedWrap(Context context, Context context2, String str) {
        Activity readField;
        while (context2 != null) {
            if (context2 instanceof IPluginActivity) {
                if (TextUtils.equals(((IPluginActivity) context2).getPluginPkgName(), str)) {
                    return null;
                }
                return context;
            } else if (context2 instanceof PluginContext) {
                PluginContext pluginContext = (PluginContext) context2;
                if (TextUtils.equals(pluginContext.mPlugin.mPkgName, str)) {
                    return null;
                }
                return pluginContext.mOriginContext;
            } else if (context2 instanceof PluginActivityWrapper) {
                PluginActivityWrapper pluginActivityWrapper = (PluginActivityWrapper) context2;
                if (TextUtils.equals(pluginActivityWrapper.pluginContext.mPlugin.mPkgName, str)) {
                    return null;
                }
                return pluginActivityWrapper.mOriginActivity;
            } else if (!isSupportLibIso(str) && (context2 instanceof PluginFragmentActivityWrapper)) {
                if (TextUtils.equals(((PluginFragmentActivityWrapper) context2).pluginContext.mPlugin.mPkgName, str)) {
                    return null;
                }
                try {
                    readField = ((PluginFragmentActivityWrapper) context2).getOriginActivity();
                } catch (Throwable th) {
                    try {
                        readField = FieldUtils.readField(context2, "mOriginActivity");
                    } catch (Throwable th2) {
                        throw new RuntimeException(th2);
                    }
                }
                return (Context) readField;
            } else if (context2 instanceof PluginApplicationWrapper) {
                PluginApplicationWrapper pluginApplicationWrapper = (PluginApplicationWrapper) context2;
                if (TextUtils.equals(pluginApplicationWrapper.mPluginContext.mPlugin.mPkgName, str)) {
                    return null;
                }
                return pluginApplicationWrapper.mOriginApplication;
            } else if (context2.getResources() instanceof PluginResources) {
                PluginResources pluginResources = (PluginResources) context2.getResources();
                try {
                    String str2 = (String) FieldUtils.readField(pluginResources, "pluginPkg");
                    if (TextUtils.isEmpty(str2)) {
                        String assetPaths = getAssetPaths(pluginResources.getAssets());
                        if (!assetPaths.contains("/" + str + "/version")) {
                            return context;
                        }
                    } else if (!TextUtils.equals(str2, str)) {
                        return context;
                    }
                    return null;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return null;
                }
            } else if (!(context2 instanceof ContextWrapper)) {
                return context;
            } else {
                try {
                    context2 = (Context) FieldUtils.readField(context2, "mBase");
                } catch (Throwable th4) {
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
            }
        }
        return null;
    }

    public static int getIdentifier(Object obj, String str, String str2, String str3, String str4) {
        if (!(obj instanceof Resources)) {
            try {
                return ((Integer) MethodUtils.invokeMethod(obj, "getIdentifier", str, str2, str3)).intValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        Resources resources = (Resources) obj;
        if (!TextUtils.equals("android", str3)) {
            str3 = str4;
        }
        return resources.getIdentifier(str, str2, str3);
    }

    public static Resources getResources(Object obj, String str) {
        try {
            Resources resources = (Resources) MethodUtils.invokeMethod(obj, "getResources", new Object[0]);
            if (resources == null) {
                return null;
            }
            if (resources instanceof PluginResources) {
                String str2 = (String) FieldUtils.readField(resources, "pluginPkg");
                if (TextUtils.isEmpty(str2)) {
                    String assetPaths = getAssetPaths(resources.getAssets());
                    if (assetPaths.contains("/" + str + "/version")) {
                        return resources;
                    }
                } else if (TextUtils.equals(str2, str)) {
                    return resources;
                }
            }
            return PluginManager.getInstance().getPlugin(str).mResources;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Uri getUriForFile(Context context, String str, File file, String str2) {
        try {
            return FileProvider.getUriForFile(file);
        } catch (NoClassDefFoundError e) {
            return Uri.parse("");
        }
    }

    public static Window getWindow(Activity activity, String str) {
        Window window = activity.getWindow();
        if (window == null) {
            try {
                return (Window) MethodUtils.invokeMethod(activity, "getWindow", new Object[0]);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
        return window;
    }

    private static Context getWrapperFromCache(Object obj, String str) {
        HashMap<String, WeakReference<Context>> hashMap = contextCache;
        WeakReference<Context> weakReference = hashMap.get(str + System.identityHashCode(obj));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private static void handleAttrAfter(TypedArray typedArray, int[] iArr, int[] iArr2) {
        if (Arrays.equals(iArr, iArr2)) {
            return;
        }
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                break;
            }
            hashMap.put(Integer.valueOf(iArr[i2]), Integer.valueOf(i2));
            i = i2 + 1;
        }
        HashMap hashMap2 = new HashMap();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= iArr2.length) {
                try {
                    break;
                } catch (IllegalAccessException e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "read mData failed.");
                    return;
                }
            }
            hashMap2.put((Integer) hashMap.get(Integer.valueOf(iArr2[i4])), Integer.valueOf(i4));
            i3 = i4 + 1;
        }
        int[] iArr3 = (int[]) FieldUtils.readField(typedArray, "mData");
        int[] copyOf = Arrays.copyOf(iArr3, iArr3.length);
        for (Integer num : hashMap2.keySet()) {
            Integer num2 = (Integer) hashMap2.get(num);
            if (!num.equals(num2)) {
                System.arraycopy(iArr3, num.intValue() * 7, copyOf, num2.intValue() * 7, 7);
            }
        }
        System.arraycopy(copyOf, 0, iArr3, 0, iArr3.length);
    }

    private static int[] handleAttrBefore(int[] iArr) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Arrays.sort(copyOf);
        return copyOf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        if ((r4 instanceof com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper) == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.view.View inflate(android.content.Context r4, int r5, android.view.ViewGroup r6, java.lang.String r7) {
        /*
            r0 = r4
            r8 = r0
            r0 = r4
            boolean r0 = r0 instanceof com.bytedance.pangle.PluginContext
            if (r0 != 0) goto L36
            r0 = r4
            r8 = r0
            r0 = r4
            boolean r0 = r0 instanceof com.bytedance.pangle.wrapper.PluginActivityWrapper
            if (r0 != 0) goto L36
            r0 = r7
            boolean r0 = isSupportLibIso(r0)
            if (r0 != 0) goto L25
            r0 = r4
            r8 = r0
            r0 = r4
            boolean r0 = r0 instanceof com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper
            if (r0 != 0) goto L36
        L25:
            r0 = r4
            r8 = r0
            r0 = r4
            boolean r0 = r0 instanceof com.bytedance.pangle.wrapper.PluginApplicationWrapper
            if (r0 != 0) goto L36
            r0 = r4
            r1 = r7
            android.content.Context r0 = wrapperContext(r0, r1)
            r8 = r0
        L36:
            r0 = r8
            java.lang.String r1 = "layout_inflater"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
            r4 = r0
            clearConstructorCache()
            r0 = r4
            r1 = r5
            r2 = r6
            android.view.View r0 = r0.inflate(r1, r2)
            r4 = r0
            clearConstructorCache()
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.transform.ZeusTransformUtils.inflate(android.content.Context, int, android.view.ViewGroup, java.lang.String):android.view.View");
    }

    public static View inflate(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, String str) {
        return inflate(layoutInflater, i, viewGroup, viewGroup != null, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002c, code lost:
        if ((r0 instanceof com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper) == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.view.View inflate(android.view.LayoutInflater r5, int r6, android.view.ViewGroup r7, boolean r8, java.lang.String r9) {
        /*
            r0 = r5
            android.content.Context r0 = r0.getContext()
            r11 = r0
            r0 = r5
            r10 = r0
            r0 = r11
            boolean r0 = r0 instanceof com.bytedance.pangle.PluginContext
            if (r0 != 0) goto L97
            r0 = r5
            r10 = r0
            r0 = r11
            boolean r0 = r0 instanceof com.bytedance.pangle.wrapper.PluginActivityWrapper
            if (r0 != 0) goto L97
            r0 = r9
            boolean r0 = isSupportLibIso(r0)
            if (r0 != 0) goto L2f
            r0 = r5
            r10 = r0
            r0 = r11
            boolean r0 = r0 instanceof com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper
            if (r0 != 0) goto L97
        L2f:
            r0 = r5
            r10 = r0
            r0 = r11
            boolean r0 = r0 instanceof com.bytedance.pangle.wrapper.PluginApplicationWrapper
            if (r0 != 0) goto L97
            r0 = r11
            r1 = r9
            android.content.Context r0 = wrapperContext(r0, r1)
            r10 = r0
            r0 = r5
            android.view.LayoutInflater$Factory r0 = r0.getFactory()
            r11 = r0
            r0 = r5
            android.view.LayoutInflater$Factory2 r0 = r0.getFactory2()
            r5 = r0
            r0 = r10
            java.lang.String r1 = "layout_inflater"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
            r10 = r0
            r0 = r9
            boolean r0 = isSupportLibIso(r0)
            if (r0 == 0) goto L97
            r0 = r11
            if (r0 == 0) goto L7e
            r0 = r10
            java.lang.String r1 = "mFactory"
            r2 = r11
            com.bytedance.pangle.util.FieldUtils.writeField(r0, r1, r2)     // Catch: java.lang.Throwable -> La8
            goto L7e
        L75:
            java.lang.String r0 = "Zeus/resources_pangle"
            java.lang.String r1 = "set Factory failed."
            com.bytedance.pangle.log.ZeusLogger.w(r0, r1)
        L7e:
            r0 = r5
            if (r0 == 0) goto L97
            r0 = r10
            java.lang.String r1 = "mFactory2"
            r2 = r5
            com.bytedance.pangle.util.FieldUtils.writeField(r0, r1, r2)     // Catch: java.lang.Throwable -> Lad
            goto L97
        L8e:
            java.lang.String r0 = "Zeus/resources_pangle"
            java.lang.String r1 = "set Factory2 failed."
            com.bytedance.pangle.log.ZeusLogger.w(r0, r1)
        L97:
            clearConstructorCache()
            r0 = r10
            r1 = r6
            r2 = r7
            r3 = r8
            android.view.View r0 = r0.inflate(r1, r2, r3)
            r5 = r0
            clearConstructorCache()
            r0 = r5
            return r0
        La8:
            r9 = move-exception
            goto L75
        Lad:
            r5 = move-exception
            goto L8e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.transform.ZeusTransformUtils.inflate(android.view.LayoutInflater, int, android.view.ViewGroup, boolean, java.lang.String):android.view.View");
    }

    public static View inflate(LayoutInflater layoutInflater, XmlPullParser xmlPullParser, ViewGroup viewGroup, String str) {
        return inflate(layoutInflater, xmlPullParser, viewGroup, viewGroup != null, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002c, code lost:
        if ((r0 instanceof com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper) == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.view.View inflate(android.view.LayoutInflater r5, org.xmlpull.v1.XmlPullParser r6, android.view.ViewGroup r7, boolean r8, java.lang.String r9) {
        /*
            r0 = r5
            android.content.Context r0 = r0.getContext()
            r10 = r0
            r0 = r10
            r5 = r0
            r0 = r10
            boolean r0 = r0 instanceof com.bytedance.pangle.PluginContext
            if (r0 != 0) goto L42
            r0 = r10
            r5 = r0
            r0 = r10
            boolean r0 = r0 instanceof com.bytedance.pangle.wrapper.PluginActivityWrapper
            if (r0 != 0) goto L42
            r0 = r9
            boolean r0 = isSupportLibIso(r0)
            if (r0 != 0) goto L2f
            r0 = r10
            r5 = r0
            r0 = r10
            boolean r0 = r0 instanceof com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper
            if (r0 != 0) goto L42
        L2f:
            r0 = r10
            r5 = r0
            r0 = r10
            boolean r0 = r0 instanceof com.bytedance.pangle.wrapper.PluginApplicationWrapper
            if (r0 != 0) goto L42
            r0 = r10
            r1 = r9
            android.content.Context r0 = wrapperContext(r0, r1)
            r5 = r0
        L42:
            r0 = r5
            java.lang.String r1 = "layout_inflater"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
            r5 = r0
            clearConstructorCache()
            r0 = r5
            r1 = r6
            r2 = r7
            r3 = r8
            android.view.View r0 = r0.inflate(r1, r2, r3)
            r5 = r0
            clearConstructorCache()
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.transform.ZeusTransformUtils.inflate(android.view.LayoutInflater, org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean, java.lang.String):android.view.View");
    }

    public static boolean instanceOf(Class cls, Object obj) {
        return instanceOf(obj, cls);
    }

    public static boolean instanceOf(Object obj, Class cls) {
        Activity readField;
        if (obj instanceof PluginContext) {
            return cls.isInstance(((PluginContext) obj).mOriginContext);
        }
        if (obj instanceof PluginActivityWrapper) {
            return cls.isInstance(((PluginActivityWrapper) obj).mOriginActivity);
        }
        if (!(obj instanceof PluginFragmentActivityWrapper)) {
            return obj instanceof PluginApplicationWrapper ? cls.isInstance(((PluginApplicationWrapper) obj).mOriginApplication) : obj instanceof GenerateProxyActivity ? cls.isInstance(((GenerateProxyActivity) obj).mTargetActivity) : cls.isInstance(obj);
        }
        try {
            readField = ((PluginFragmentActivityWrapper) obj).getOriginActivity();
        } catch (Throwable th) {
            try {
                readField = FieldUtils.readField(obj, "mOriginActivity");
            } catch (Throwable th2) {
                throw new RuntimeException(th2);
            }
        }
        return cls.isInstance(readField);
    }

    private static boolean instanceOfFragmentActivity(Object obj) {
        ensureFragmentActivity();
        Class cls = fragmentClazz;
        if (cls == null) {
            return false;
        }
        return cls.isInstance(obj);
    }

    private static boolean isSupportLibIso(String str) {
        try {
            return PluginManager.getInstance().getPlugin(str).mIsSupportLibIso;
        } catch (Throwable th) {
            return false;
        }
    }

    public static int mapRes(int i, String str, String str2) {
        if (i < 2130706432) {
            return i;
        }
        int identifier = Zeus.getAppApplication().getResources().getIdentifier(str2, str, Zeus.getAppApplication().getPackageName());
        int i2 = identifier;
        if (identifier == 0) {
            i2 = Zeus.getAppApplication().getResources().getIdentifier(str2.replace("_", "."), str, Zeus.getAppApplication().getPackageName());
        }
        if (i2 == 0) {
            ZeusLogger.d(ZeusLogger.TAG_RESOURCES, "Cant find res, resName = " + str2 + ", pluginResId = " + i);
        }
        return i2;
    }

    public static TypedArray obtainAttributes(Object obj, AttributeSet attributeSet, int[] iArr, String str) {
        if (!(obj instanceof Resources)) {
            try {
                return (TypedArray) MethodUtils.invokeMethod(obj, "obtainAttributes", attributeSet, iArr);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        int[] handleAttrBefore = handleAttrBefore(iArr);
        TypedArray obtainAttributes = ((Resources) obj).obtainAttributes(attributeSet, handleAttrBefore);
        handleAttrAfter(obtainAttributes, handleAttrBefore, iArr);
        return obtainAttributes;
    }

    public static TypedArray obtainStyledAttributes(Object obj, int i, int[] iArr, String str) {
        if (obj instanceof Context) {
            int[] handleAttrBefore = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes = ((Context) obj).obtainStyledAttributes(i, handleAttrBefore);
            handleAttrAfter(obtainStyledAttributes, handleAttrBefore, iArr);
            return obtainStyledAttributes;
        } else if (!(obj instanceof Resources.Theme)) {
            try {
                return (TypedArray) MethodUtils.invokeMethod(obj, "obtainStyledAttributes", Integer.valueOf(i), iArr);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            int[] handleAttrBefore2 = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes2 = ((Resources.Theme) obj).obtainStyledAttributes(i, handleAttrBefore2);
            handleAttrAfter(obtainStyledAttributes2, handleAttrBefore2, iArr);
            return obtainStyledAttributes2;
        }
    }

    public static TypedArray obtainStyledAttributes(Object obj, AttributeSet attributeSet, int[] iArr, int i, int i2, String str) {
        if (obj instanceof Context) {
            int[] handleAttrBefore = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes = ((Context) obj).obtainStyledAttributes(attributeSet, handleAttrBefore);
            handleAttrAfter(obtainStyledAttributes, handleAttrBefore, iArr);
            return obtainStyledAttributes;
        } else if (!(obj instanceof Resources.Theme)) {
            try {
                return (TypedArray) MethodUtils.invokeMethod(obj, "obtainStyledAttributes", attributeSet, iArr, Integer.valueOf(i), Integer.valueOf(i2));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            int[] handleAttrBefore2 = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes2 = ((Resources.Theme) obj).obtainStyledAttributes(attributeSet, handleAttrBefore2, i, i2);
            handleAttrAfter(obtainStyledAttributes2, handleAttrBefore2, iArr);
            return obtainStyledAttributes2;
        }
    }

    public static TypedArray obtainStyledAttributes(Object obj, AttributeSet attributeSet, int[] iArr, String str) {
        if (!(obj instanceof Context)) {
            try {
                return (TypedArray) MethodUtils.invokeMethod(obj, "obtainStyledAttributes", attributeSet, iArr);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        int[] handleAttrBefore = handleAttrBefore(iArr);
        TypedArray obtainStyledAttributes = ((Context) obj).obtainStyledAttributes(attributeSet, handleAttrBefore);
        handleAttrAfter(obtainStyledAttributes, handleAttrBefore, iArr);
        return obtainStyledAttributes;
    }

    public static TypedArray obtainStyledAttributes(Object obj, int[] iArr, String str) {
        if (obj instanceof Context) {
            int[] handleAttrBefore = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes = ((Context) obj).obtainStyledAttributes(handleAttrBefore);
            handleAttrAfter(obtainStyledAttributes, handleAttrBefore, iArr);
            return obtainStyledAttributes;
        } else if (!(obj instanceof Resources.Theme)) {
            try {
                return (TypedArray) MethodUtils.invokeMethod(obj, "obtainStyledAttributes", iArr, new Class[]{int[].class});
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            int[] handleAttrBefore2 = handleAttrBefore(iArr);
            TypedArray obtainStyledAttributes2 = ((Resources.Theme) obj).obtainStyledAttributes(handleAttrBefore2);
            handleAttrAfter(obtainStyledAttributes2, handleAttrBefore2, iArr);
            return obtainStyledAttributes2;
        }
    }

    public static Object preCheckCast(Object obj, Class cls, String str) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Context) {
            boolean z = !cls.isInstance(obj);
            if (equalsFragmentActivity(cls)) {
                return wrapperContext2FragmentActivity(obj, str);
            }
            if (cls == Activity.class) {
                return wrapperContext2Activity(obj, str);
            }
            if (cls == Application.class) {
                return wrapperContext2Application(obj, str);
            }
            if ((obj instanceof PluginContext) && z) {
                return ((PluginContext) obj).mOriginContext;
            }
            if ((obj instanceof PluginFragmentActivityWrapper) && z) {
                try {
                    return ((PluginFragmentActivityWrapper) obj).getOriginActivity();
                } catch (Throwable th) {
                    try {
                        return FieldUtils.readField(obj, "mOriginActivity");
                    } catch (Throwable th2) {
                        throw new RuntimeException(th2);
                    }
                }
            } else if ((obj instanceof PluginActivityWrapper) && z) {
                return ((PluginActivityWrapper) obj).mOriginActivity;
            } else {
                if ((obj instanceof PluginApplicationWrapper) && z) {
                    return ((PluginApplicationWrapper) obj).mOriginApplication;
                }
                GeneratePluginActivity generatePluginActivity = obj;
                if (obj instanceof GenerateProxyActivity) {
                    generatePluginActivity = obj;
                    if (z) {
                        generatePluginActivity = ((GenerateProxyActivity) obj).mTargetActivity;
                    }
                }
                return generatePluginActivity;
            }
        }
        return obj;
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, int i, String str) {
        if (obj instanceof Context) {
            ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[3 params]");
            return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, i, str);
        }
        try {
            return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, Integer.valueOf(i));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str) {
        if (obj instanceof Context) {
            ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute");
            return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str);
        }
        try {
            return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i, String str2) {
        if (obj instanceof Context) {
            ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[5 params]");
            return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str, handler, i, str2);
        }
        try {
            return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, str, handler, Integer.valueOf(i));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, String str2) {
        if (obj instanceof Context) {
            ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[4 params]");
            return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str, handler, str2);
        }
        try {
            return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, str, handler);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void registerZeusActivityStub(String str, String[] strArr, String str2) {
        ComponentManager.registerActivity(str2, str, strArr);
    }

    public static void requestPermissions(Object obj, String[] strArr, int i, String str) {
        if (obj instanceof IPluginActivity) {
            ((IPluginActivity) obj)._requestPermissions(strArr, i);
            return;
        }
        Object obj2 = obj;
        if (obj instanceof Activity) {
            Object obj3 = null;
            try {
                obj3 = FieldUtils.readField(obj, "mOriginActivity");
            } catch (IllegalAccessException e) {
            }
            obj2 = obj;
            if (obj3 != null) {
                obj2 = obj3;
            }
        }
        try {
            MethodUtils.invokeMethod(obj2, "requestPermissions", strArr, Integer.valueOf(i));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void setComponentEnabledSetting(PackageManager packageManager, ComponentName componentName, int i, int i2) {
        try {
            packageManager.setComponentEnabledSetting(componentName, i, i2);
        } catch (Throwable th) {
        }
    }

    public static void setResult(Object obj, int i, Intent intent, String str) {
        if (obj instanceof Activity) {
            try {
                Object readField = FieldUtils.readField(obj, "mProxyActivity");
                Object obj2 = readField;
                if (readField == null) {
                    obj2 = FieldUtils.readField(obj, "mOriginActivity");
                }
                if (obj2 != null) {
                    MethodUtils.invokeMethod(obj2, "setResult", Integer.valueOf(i), intent);
                    return;
                }
            } catch (Exception e) {
            }
        }
        try {
            MethodUtils.invokeMethod(obj, "setResult", Integer.valueOf(i), intent);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void setResult(Object obj, int i, String str) {
        if (obj instanceof Activity) {
            try {
                Object readField = FieldUtils.readField(obj, "mProxyActivity");
                if (readField != null) {
                    MethodUtils.invokeMethod(readField, "setResult", Integer.valueOf(i));
                    return;
                }
            } catch (Exception e) {
                ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "Cant find mProxyActivity, obj = ".concat(String.valueOf(obj)));
            }
        }
        try {
            MethodUtils.invokeMethod(obj, "setResult", Integer.valueOf(i));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void startActivity(Object obj, Intent intent, Bundle bundle, String str) {
        try {
            ComponentManager.startActivity(obj, intent, bundle, str);
        } catch (Throwable th) {
            if (obj instanceof Context) {
                ComponentManager.startActivity((Context) obj, intent, bundle, str);
                return;
            }
            try {
                MethodUtils.invokeMethod(obj, "startActivity", new Object[]{intent, bundle}, new Class[]{Intent.class, Bundle.class});
            } catch (Throwable th2) {
                th2.addSuppressed(th);
                throw new RuntimeException(th2);
            }
        }
    }

    public static void startActivity(Object obj, Intent intent, String str) {
        startActivity(obj, intent, null, str);
    }

    public static void startActivityForResult(Object obj, Intent intent, int i, Bundle bundle, String str) {
        try {
            ComponentManager.startActivityForResult(obj, intent, i, bundle, str);
        } catch (Throwable th) {
            if (obj instanceof Activity) {
                ComponentManager.startActivityForResult((Activity) obj, intent, i, bundle, str);
                return;
            }
            try {
                MethodUtils.invokeMethod(obj, "startActivityForResult", new Object[]{intent, Integer.valueOf(i), bundle}, new Class[]{Intent.class, Integer.TYPE, Bundle.class});
            } catch (Throwable th2) {
                th2.addSuppressed(th);
                throw new RuntimeException(th2);
            }
        }
    }

    public static void startActivityForResult(Object obj, Intent intent, int i, String str) {
        startActivityForResult(obj, intent, i, null, str);
    }

    public static ComponentName startService(Object obj, Intent intent, String str) {
        if (obj instanceof Context) {
            return ServiceManagerNative.getInstance().startServiceNative((Context) obj, intent, str);
        }
        try {
            return (ComponentName) MethodUtils.invokeMethod(obj, "startService", intent);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean stopService(Object obj, Intent intent, String str) {
        if (obj instanceof Context) {
            return ServiceManagerNative.getInstance().stopServiceNative((Context) obj, intent, str);
        }
        try {
            return ((Boolean) MethodUtils.invokeMethod(obj, "stopService", intent)).booleanValue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void unbindService(Object obj, ServiceConnection serviceConnection, String str) {
        if (obj instanceof Context) {
            ServiceManagerNative.getInstance().unbindServiceNative(serviceConnection);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "unbindService", serviceConnection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void unregisterReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, String str) {
        if (obj instanceof Context) {
            ComponentManager.unregisterReceiver((Context) obj, pluginBroadcastReceiver);
            return;
        }
        try {
            MethodUtils.invokeMethod(obj, "unregisterReceiver", pluginBroadcastReceiver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Context wrapperContext(Object obj, String str) {
        Context pluginApplicationWrapper;
        Application application;
        if (Zeus.getAppApplication() == null && (application = (Application) ((Context) obj).getApplicationContext()) != null) {
            Zeus.setAppContext(application);
        }
        if (obj == null) {
            return null;
        }
        Context wrapperFromCache = getWrapperFromCache(obj, str);
        if (wrapperFromCache != null) {
            return wrapperFromCache;
        }
        Context context = (Context) obj;
        Context contextIfNeedWrap = getContextIfNeedWrap(context, context, str);
        if (contextIfNeedWrap == null) {
            return context;
        }
        if (!isSupportLibIso(str) && instanceOfFragmentActivity(contextIfNeedWrap)) {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            try {
                pluginApplicationWrapper = new PluginFragmentActivityWrapper((Activity) contextIfNeedWrap, new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), false));
            } catch (Throwable th) {
                try {
                    pluginApplicationWrapper = (Context) MethodUtils.invokeConstructor(PluginFragmentActivityWrapper.class, new Object[]{contextIfNeedWrap, new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), false)}, new Class[]{fragmentClazz, PluginContext.class});
                } catch (Throwable th2) {
                    return contextIfNeedWrap;
                }
            }
        } else if (contextIfNeedWrap instanceof Activity) {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            pluginApplicationWrapper = new PluginActivityWrapper((Activity) contextIfNeedWrap, new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), false));
        } else {
            pluginApplicationWrapper = contextIfNeedWrap instanceof Application ? new PluginApplicationWrapper((Application) contextIfNeedWrap, new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), true)) : new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), false);
        }
        if (pluginApplicationWrapper != null) {
            HashMap<String, WeakReference<Context>> hashMap = contextCache;
            hashMap.put(str + System.identityHashCode(contextIfNeedWrap), new WeakReference<>(pluginApplicationWrapper));
        }
        return pluginApplicationWrapper;
    }

    public static Activity wrapperContext2Activity(Object obj, String str) {
        while (obj != null) {
            Context wrapperContext = wrapperContext(obj, str);
            if (wrapperContext instanceof Activity) {
                return (Activity) wrapperContext;
            }
            if (!(wrapperContext instanceof PluginContext)) {
                throw new RuntimeException("强转失败");
            }
            obj = ((PluginContext) wrapperContext).mOriginContext;
        }
        return null;
    }

    public static Application wrapperContext2Application(Object obj, String str) {
        while (obj != null) {
            Context wrapperContext = wrapperContext(obj, str);
            if (wrapperContext instanceof Application) {
                return (Application) wrapperContext;
            }
            if (!(wrapperContext instanceof PluginContext)) {
                throw new RuntimeException("强转失败");
            }
            obj = ((PluginContext) wrapperContext).mOriginContext;
        }
        return null;
    }

    private static Object wrapperContext2FragmentActivity(Object obj, String str) {
        while (obj != null) {
            Context wrapperContext = wrapperContext(obj, str);
            if (!isSupportLibIso(str) && instanceOfFragmentActivity(wrapperContext)) {
                return wrapperContext;
            }
            if (!(wrapperContext instanceof PluginContext)) {
                throw new RuntimeException("强转失败");
            }
            obj = ((PluginContext) wrapperContext).mOriginContext;
        }
        return null;
    }

    public static Object wrapperContextForParams(Object obj, Class cls, String str) {
        if (!(obj instanceof PluginService)) {
            if (obj instanceof PluginIntentService) {
                return obj;
            }
            if (obj instanceof Context) {
                Context convertProxy2PluginActivity = convertProxy2PluginActivity(wrapperContext(obj, str));
                if (cls.isInstance(convertProxy2PluginActivity)) {
                    return convertProxy2PluginActivity;
                }
            }
        }
        return obj;
    }
}
