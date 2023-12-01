package com.kwad.sdk.core.diskcache;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.ksad.download.c;
import com.ksad.download.d;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/diskcache/a.class */
public class a {
    public static void aJ(final Context context) {
        g.schedule(new aw() { // from class: com.kwad.sdk.core.diskcache.a.1
            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                d O;
                synchronized (a.class) {
                    try {
                        File cB = av.cB(Context.this);
                        if (cB.exists()) {
                            for (File file : a.i(cB)) {
                                if (file.getName().endsWith(".apk") && com.kwad.sdk.core.a.tS().bu(file.getAbsolutePath()) != null && a.b(Context.this, file) != null && (O = c.M().O()) != null) {
                                    O.b(file);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        }, 10L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PackageInfo b(Context context, File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (file.exists() && (!file.isDirectory())) {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(file.getPath(), 65);
                try {
                    if (packageManager.getPackageInfo(packageArchiveInfo.packageName, 1) != null) {
                        return null;
                    }
                    return packageArchiveInfo;
                } catch (Exception e) {
                    return packageArchiveInfo;
                }
            }
            return null;
        } catch (Exception e2) {
            b.printStackTrace(e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<File> i(File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(listFiles));
        m(arrayList);
        return arrayList;
    }

    private static void m(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.a.2
            private static int a(File file, File file2) {
                if (file.lastModified() >= file2.lastModified()) {
                    return file.lastModified() == file2.lastModified() ? 0 : 1;
                }
                return -1;
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(File file, File file2) {
                return a(file, file2);
            }
        });
    }
}
