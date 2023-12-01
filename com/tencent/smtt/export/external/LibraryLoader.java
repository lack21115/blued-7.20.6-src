package com.tencent.smtt.export.external;

import android.content.Context;
import android.os.Build;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/LibraryLoader.class */
public class LibraryLoader {
    private static String[] sLibrarySearchPaths;

    public static String[] getLibrarySearchPaths(Context context) {
        String[] strArr = sLibrarySearchPaths;
        if (strArr != null) {
            return strArr;
        }
        if (context == null) {
            return new String[]{"/system/lib"};
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(getNativeLibraryDir(context));
        arrayList.add("/system/lib");
        String[] strArr2 = new String[arrayList.size()];
        arrayList.toArray(strArr2);
        sLibrarySearchPaths = strArr2;
        return strArr2;
    }

    public static String getNativeLibraryDir(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 9) {
            return context.getApplicationInfo().nativeLibraryDir;
        }
        if (i >= 4) {
            return context.getApplicationInfo().dataDir + "/lib";
        }
        return "/data/data/" + context.getPackageName() + "/lib";
    }

    public static void loadLibrary(Context context, String str) throws UnsatisfiedLinkError {
        String[] librarySearchPaths = getLibrarySearchPaths(context);
        String mapLibraryName = System.mapLibraryName(str);
        int length = librarySearchPaths.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                try {
                    System.loadLibrary(str);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            String str2 = librarySearchPaths[i2] + BridgeUtil.SPLIT_MARK + mapLibraryName;
            if (new File(str2).exists()) {
                try {
                    System.load(str2);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            i = i2 + 1;
        }
    }
}
