package com.kuaishou.weapon.p0;

import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/dn.class */
public class dn {

    /* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/dn$a.class */
    static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            Object obj = dp.a(classLoader, "pathList").get(classLoader);
            Field a2 = dp.a(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) a2.get(obj);
            ArrayList arrayList = new ArrayList();
            int length = fileArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    arrayList.add(file);
                    a2.set(obj, arrayList.toArray(new File[0]));
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

    /* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/dn$b.class */
    static final class b {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            Object obj = dp.a(classLoader, "pathList").get(classLoader);
            Field a2 = dp.a(obj, "nativeLibraryDirectories");
            List list = (List) a2.get(obj);
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
            a2.set(obj, arrayList2);
            if (a2.get(obj) != arrayList2) {
                dp.b(obj, "nativeLibraryDirectories").set(obj, arrayList2);
            }
            List list2 = (List) dp.a(obj, "systemNativeLibraryDirectories").get(obj);
            ArrayList arrayList3 = list2;
            if (list2 == null) {
                arrayList3 = new ArrayList(2);
            }
            ArrayList arrayList4 = new ArrayList(arrayList2.size() + arrayList3.size() + 1);
            arrayList4.addAll(arrayList2);
            arrayList4.addAll(arrayList3);
            Object[] objArr = (Object[]) dp.a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList4, null, new ArrayList());
            Field a3 = dp.a(obj, "nativeLibraryPathElements");
            a3.set(obj, objArr);
            if (a3.get(obj) != objArr) {
                dp.b(obj, "nativeLibraryPathElements").set(obj, objArr);
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/dn$c.class */
    static final class c {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            Object obj = dp.a(classLoader, "pathList").get(classLoader);
            List list = (List) dp.a(obj, "nativeLibraryDirectories").get(obj);
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
            List list3 = (List) dp.a(obj, "systemNativeLibraryDirectories").get(obj);
            ArrayList arrayList = list3;
            if (list3 == null) {
                arrayList = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList(list2.size() + arrayList.size() + 1);
            arrayList2.addAll(list2);
            arrayList2.addAll(arrayList);
            dp.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) dp.a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList2, null, new ArrayList()));
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/dn$d.class */
    static final class d {
        private d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            Object obj = dp.a(classLoader, "pathList").get(classLoader);
            List list = (List) dp.a(obj, "nativeLibraryDirectories").get(obj);
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
            List list3 = (List) dp.a(obj, "systemNativeLibraryDirectories").get(obj);
            ArrayList arrayList = list3;
            if (list3 == null) {
                arrayList = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList(list2.size() + arrayList.size() + 1);
            arrayList2.addAll(list2);
            arrayList2.addAll(arrayList);
            dp.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) dp.a(obj, "makePathElements", List.class).invoke(obj, arrayList2));
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/dn$e.class */
    static final class e {
        private e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            String path = file.getPath();
            Field a2 = dp.a(classLoader, "libPath");
            String valueOf = String.valueOf(a2.get(classLoader));
            a2.set(classLoader, TextUtils.isEmpty(valueOf) ? path : valueOf + ":" + path);
            Field a3 = dp.a(classLoader, "libraryPathElements");
            List<String> list = (List) a3.get(classLoader);
            for (String str : list) {
                if (path.equals(str)) {
                    return;
                }
            }
            list.add(path);
            a3.set(classLoader, list);
        }
    }

    public static void a(ClassLoader classLoader, File file) {
        synchronized (dn.class) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        if ((Build.VERSION.SDK_INT == 25 && Build.VERSION.PREVIEW_SDK_INT != 0) || Build.VERSION.SDK_INT > 25) {
                            d.b(classLoader, file);
                        } else if (Build.VERSION.SDK_INT == 24) {
                            c.b(classLoader, file);
                        } else if (Build.VERSION.SDK_INT >= 23) {
                            b.b(classLoader, file);
                        } else if (Build.VERSION.SDK_INT >= 14) {
                            a.b(classLoader, file);
                        } else {
                            e.b(classLoader, file);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
