package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/bo.class */
public class bo {
    private static List<File> a(File file, final String str, int i) {
        ArrayList arrayList = new ArrayList();
        try {
            File[] listFiles = file.listFiles(new FileFilter() { // from class: com.kuaishou.weapon.p0.bo.1
                @Override // java.io.FileFilter
                public final boolean accept(File file2) {
                    return file2.isDirectory() || file2.getName().toLowerCase().contains(str);
                }
            });
            if (listFiles != null) {
                int length = listFiles.length;
                int i2 = 0;
                while (i2 < length) {
                    File file2 = listFiles[i2];
                    if (file2.isFile()) {
                        arrayList.add(file2);
                        return arrayList;
                    }
                    arrayList.addAll(a(file2, str, i));
                    i2++;
                    i++;
                }
            }
            return arrayList;
        } catch (Throwable th) {
            return arrayList;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
        }
    }

    public static boolean a(Context context, String str) {
        try {
            String str2 = Engine.soPath;
            if (!TextUtils.isEmpty(str2)) {
                if (new File(str2 + "/lib" + str).exists()) {
                    return true;
                }
            }
            return a(context.getFilesDir(), str, 0).size() > 0;
        } catch (Throwable th) {
            return false;
        }
    }
}
