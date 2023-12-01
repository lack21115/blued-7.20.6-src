package com.bytedance.pangle.util;

import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/util/j.class */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    static volatile ArrayList<String> f21505a;
    private static String b;

    public static List<String> a() {
        AssetManager assetManager;
        try {
            assetManager = (AssetManager) AssetManager.class.newInstance();
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "Execute 'AssetManager.class.newInstance()' failed. ", e);
            assetManager = null;
        }
        return a(assetManager);
    }

    public static List<String> a(AssetManager assetManager) {
        ArrayList arrayList = new ArrayList();
        if (assetManager == null) {
            return arrayList;
        }
        try {
            if (!i.i()) {
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
                            arrayList.add(str);
                        }
                    } catch (IndexOutOfBoundsException e) {
                    }
                    i = i2 + 1;
                }
            } else {
                Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                if (objArr != null && objArr.length > 0) {
                    int length = objArr.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= length) {
                            break;
                        }
                        arrayList.add((String) MethodUtils.invokeMethod(objArr[i4], "getAssetPath", new Object[0]));
                        i3 = i4 + 1;
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "ResUtils GetAssetsPaths error. ", th);
        }
        return arrayList;
    }

    public static boolean a(AssetManager assetManager, String str) {
        try {
            if (!i.i()) {
                int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                int i = 0;
                while (i < intValue) {
                    i++;
                    if (TextUtils.equals((String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i)), str)) {
                        return true;
                    }
                }
                return false;
            }
            Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
            if (objArr == null || objArr.length <= 0) {
                return false;
            }
            int length = objArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return false;
                }
                if (TextUtils.equals((String) MethodUtils.invokeMethod(objArr[i3], "getAssetPath", new Object[0]), str)) {
                    return true;
                }
                i2 = i3 + 1;
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "containsPath error. ", th);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String[] a(ApplicationInfo applicationInfo) {
        String[] strArr;
        try {
            strArr = (String[]) com.bytedance.pangle.b.b.a.a(ApplicationInfo.class, "resourceDirs").get(applicationInfo);
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "get resourceDirs failed.", th);
            strArr = new String[0];
        }
        String[] strArr2 = applicationInfo.splitSourceDirs;
        String[] strArr3 = applicationInfo.sharedLibraryFiles;
        ArrayList arrayList = new ArrayList(10);
        if (applicationInfo.sourceDir != null) {
            arrayList.add(applicationInfo.sourceDir);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return (String[]) arrayList.toArray(new String[0]);
            }
            Object[] objArr = new String[]{strArr2, strArr3, strArr}[i2];
            if (objArr != 0) {
                arrayList.addAll(Arrays.asList(objArr));
            }
            i = i2 + 1;
        }
    }

    public static String b(AssetManager assetManager) {
        List<String> a2 = a(assetManager);
        StringBuilder sb = new StringBuilder("[");
        if (a2.size() > 0) {
            for (String str : a2) {
                sb.append(str);
                sb.append(" , ");
            }
            sb.delete(sb.lastIndexOf(" , "), sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0099 A[Catch: Exception -> 0x00c6, all -> 0x00d6, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x00c6, blocks: (B:18:0x0068, B:22:0x0082, B:26:0x008c, B:31:0x0099, B:32:0x00ad), top: B:54:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad A[Catch: Exception -> 0x00c6, all -> 0x00d6, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x00c6, blocks: (B:18:0x0068, B:22:0x0082, B:26:0x008c, B:31:0x0099, B:32:0x00ad), top: B:54:0x0068 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> b() {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.util.j.b():java.util.List");
    }
}
