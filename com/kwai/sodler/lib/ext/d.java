package com.kwai.sodler.lib.ext;

import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/ext/d.class */
public final class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/ext/d$a.class */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwai.sodler.lib.ext.e.g(classLoader, "pathList").get(classLoader);
            Field g = com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) g.get(obj);
            ArrayList arrayList = new ArrayList();
            int length = fileArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    arrayList.add(file);
                    g.set(obj, arrayList.toArray(new File[0]));
                    return;
                }
                File file2 = fileArr[i2];
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/ext/d$b.class */
    public static final class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwai.sodler.lib.ext.e.g(classLoader, "pathList").get(classLoader);
            Field g = com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryDirectories");
            List list = (List) g.get(obj);
            ArrayList arrayList = list;
            if (list == null) {
                arrayList = new ArrayList(2);
            }
            ArrayList<File> arrayList2 = new ArrayList(arrayList);
            for (File file2 : arrayList2) {
                if (file.equals(file2)) {
                    return;
                }
            }
            arrayList2.add(file);
            g.set(obj, arrayList2);
            if (g.get(obj) != arrayList2) {
                com.kwai.sodler.lib.ext.e.h(obj, "nativeLibraryDirectories").set(obj, arrayList2);
            }
            List list2 = (List) com.kwai.sodler.lib.ext.e.g(obj, "systemNativeLibraryDirectories").get(obj);
            ArrayList arrayList3 = list2;
            if (list2 == null) {
                arrayList3 = new ArrayList(2);
            }
            ArrayList arrayList4 = new ArrayList(arrayList2.size() + arrayList3.size() + 1);
            arrayList4.addAll(arrayList2);
            arrayList4.addAll(arrayList3);
            Object[] objArr = (Object[]) com.kwai.sodler.lib.ext.e.b(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList4, null, new ArrayList());
            Field g2 = com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryPathElements");
            g2.set(obj, objArr);
            if (g2.get(obj) != objArr) {
                com.kwai.sodler.lib.ext.e.h(obj, "nativeLibraryPathElements").set(obj, objArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/ext/d$c.class */
    public static final class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwai.sodler.lib.ext.e.g(classLoader, "pathList").get(classLoader);
            List list = (List) com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryDirectories").get(obj);
            List<File> list2 = list;
            if (list == null) {
                list2 = new ArrayList(2);
            }
            for (File file2 : list2) {
                if (file.equals(file2)) {
                    return;
                }
            }
            list2.add(file);
            List list3 = (List) com.kwai.sodler.lib.ext.e.g(obj, "systemNativeLibraryDirectories").get(obj);
            ArrayList arrayList = list3;
            if (list3 == null) {
                arrayList = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList(list2.size() + arrayList.size() + 1);
            arrayList2.addAll(list2);
            arrayList2.addAll(arrayList);
            com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryPathElements").set(obj, (Object[]) com.kwai.sodler.lib.ext.e.b(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList2, null, new ArrayList()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwai.sodler.lib.ext.d$d  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/ext/d$d.class */
    public static final class C0596d {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwai.sodler.lib.ext.e.g(classLoader, "pathList").get(classLoader);
            List list = (List) com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryDirectories").get(obj);
            List<File> list2 = list;
            if (list == null) {
                list2 = new ArrayList(2);
            }
            for (File file2 : list2) {
                if (file.equals(file2)) {
                    return;
                }
            }
            list2.add(file);
            List list3 = (List) com.kwai.sodler.lib.ext.e.g(obj, "systemNativeLibraryDirectories").get(obj);
            ArrayList arrayList = list3;
            if (list3 == null) {
                arrayList = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList(list2.size() + arrayList.size() + 1);
            arrayList2.addAll(list2);
            arrayList2.addAll(arrayList);
            com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryPathElements").set(obj, (Object[]) com.kwai.sodler.lib.ext.e.b(obj, "makePathElements", List.class).invoke(obj, arrayList2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/ext/d$e.class */
    public static final class e {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            String path = file.getPath();
            Field g = com.kwai.sodler.lib.ext.e.g(classLoader, "libPath");
            String valueOf = String.valueOf(g.get(classLoader));
            g.set(classLoader, TextUtils.isEmpty(valueOf) ? path : valueOf + ":" + path);
            Field g2 = com.kwai.sodler.lib.ext.e.g(classLoader, "libraryPathElements");
            List<String> list = (List) g2.get(classLoader);
            for (String str : list) {
                if (path.equals(str)) {
                    return;
                }
            }
            list.add(path);
            g2.set(classLoader, list);
        }
    }

    public static void c(ClassLoader classLoader, File file) {
        synchronized (d.class) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        if ((Build.VERSION.SDK_INT == 25 && Build.VERSION.PREVIEW_SDK_INT != 0) || Build.VERSION.SDK_INT > 25) {
                            C0596d.d(classLoader, file);
                            return;
                        } else if (Build.VERSION.SDK_INT == 24) {
                            c.d(classLoader, file);
                            return;
                        } else if (Build.VERSION.SDK_INT >= 23) {
                            b.d(classLoader, file);
                            return;
                        } else if (Build.VERSION.SDK_INT >= 14) {
                            a.d(classLoader, file);
                            return;
                        } else {
                            e.d(classLoader, file);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            com.kwai.sodler.lib.a.e("Sodler.ShareLibraryLoader", String.format("installNativeLibraryPath, folder %s is illegal", file));
        }
    }
}
