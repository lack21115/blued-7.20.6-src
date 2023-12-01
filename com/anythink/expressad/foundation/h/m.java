package com.anythink.expressad.foundation.h;

import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/m.class */
public final class m extends e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5121a = 1;
    public static final int b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5122c = 3;
    public static final int d = 4;
    public static final String e = "/download/.at";
    public static final String f = "/atdownload";
    private static final String g = "SameFileTool";

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/m$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f5123a = 448;
        public static final int b = 256;

        /* renamed from: c  reason: collision with root package name */
        public static final int f5124c = 128;
        public static final int d = 64;
        public static final int e = 56;
        public static final int f = 32;
        public static final int g = 16;
        public static final int h = 8;
        public static final int i = 7;
        public static final int j = 4;
        public static final int k = 2;
        public static final int l = 1;

        a() {
        }
    }

    private static double a(long j, int i) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return 0.0d;
                    }
                    return Double.valueOf(decimalFormat.format(j / 1.073741824E9d)).doubleValue();
                }
                return Double.valueOf(decimalFormat.format(j / 1048576.0d)).doubleValue();
            }
            return Double.valueOf(decimalFormat.format(j / 1024.0d)).doubleValue();
        }
        return Double.valueOf(decimalFormat.format(j)).doubleValue();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(4:7|8|(4:9|10|11|(8:13|14|15|16|17|18|19|20)(0))|21) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
        r8 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.io.File r6) {
        /*
            Method dump skipped, instructions count: 170
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.h.m.a(java.io.File):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x01d3, code lost:
        throw new java.lang.Exception("zipEntry's name is unsafe!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 615
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.h.m.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public static void a() {
        new Thread(new Runnable() { // from class: com.anythink.expressad.foundation.h.m.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (com.anythink.expressad.foundation.b.a.b().d() == null) {
                        return;
                    }
                    String b2 = com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_VC);
                    try {
                        File file = new File(b2);
                        if (!file.exists() || !file.isDirectory()) {
                            return;
                        }
                        File[] b3 = m.b(b2);
                        int length = b3.length;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= length) {
                                return;
                            }
                            File file2 = b3[i2];
                            if (file2.exists() && file2.isFile()) {
                                file2.delete();
                            }
                            i = i2 + 1;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    if (com.anythink.expressad.a.f4103a) {
                        e3.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void a(long j) {
        try {
            Iterator<File> it = e(new File(com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_RES_MANAGER_DIR))).iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (next.lastModified() < j && next.exists() && next.isFile()) {
                    next.delete();
                }
            }
        } catch (Throwable th) {
            o.b(g, th.getMessage(), th);
        }
    }

    static /* synthetic */ void a(String str, int i) {
        try {
            if (d(new File(str)) > i * 1048576) {
                f(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            o.d(g, "clean memory failed");
        }
    }

    public static boolean a(String str) {
        if (com.anythink.expressad.foundation.g.d.e.a(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }

    private static boolean a(String str, String str2, String str3) {
        try {
            if (r.b()) {
                String str4 = str + File.separator + str3;
                File file = new File(str4);
                if (file.exists() && file.isFile() && r.a(file.length())) {
                    File file2 = new File(str2);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    int b2 = b(str4, str2 + File.separator + str3);
                    if (file.exists() && b2 == 0) {
                        file.delete();
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(byte[] bArr, File file) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (file.getParentFile() != null && !file.exists()) {
                    file.getParentFile().mkdirs();
                }
                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                try {
                    fileOutputStream3.write(bArr);
                    try {
                        fileOutputStream3.close();
                        return true;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return true;
                    }
                } catch (Exception e3) {
                    fileOutputStream = fileOutputStream3;
                    e = e3;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream3;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                fileOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static double b(String str, int i) {
        long j;
        File file = new File(str);
        try {
            j = file.isDirectory() ? d(file) : c(file);
        } catch (Exception e2) {
            e2.printStackTrace();
            o.d("获取文件大小", "获取失败!");
            j = 0;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return 0.0d;
                    }
                    return Double.valueOf(decimalFormat.format(j / 1.073741824E9d)).doubleValue();
                }
                return Double.valueOf(decimalFormat.format(j / 1048576.0d)).doubleValue();
            }
            return Double.valueOf(decimalFormat.format(j / 1024.0d)).doubleValue();
        }
        return Double.valueOf(decimalFormat.format(j)).doubleValue();
    }

    private static int b(String str, String str2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream2;
        FileInputStream fileInputStream2;
        try {
            if (r.f5130a) {
                fileInputStream = new FileInputStream(str);
                try {
                    fileOutputStream2 = new FileOutputStream(str2);
                } catch (Exception e2) {
                    fileOutputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                    File file = new File(str2);
                    if (file.exists()) {
                        if (file.isFile()) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                            try {
                                fileOutputStream2.close();
                                return 0;
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                return 0;
                            }
                        }
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    try {
                        fileOutputStream2.close();
                        return -1;
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        return -1;
                    }
                } catch (Exception e7) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            return -1;
                        } catch (IOException e9) {
                            e9.printStackTrace();
                            return -1;
                        }
                    }
                    return -1;
                } catch (Throwable th2) {
                    fileOutputStream = fileOutputStream2;
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            return -1;
        } catch (Exception e12) {
            fileOutputStream2 = null;
            fileInputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            fileInputStream = null;
        }
    }

    private static String b(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j == 0) {
            return "0B";
        }
        if (j < 1024) {
            return decimalFormat.format(j) + "B";
        } else if (j < 1048576) {
            return decimalFormat.format(j / 1024.0d) + "KB";
        } else if (j < 1073741824) {
            return decimalFormat.format(j / 1048576.0d) + "AT";
        } else {
            return decimalFormat.format(j / 1.073741824E9d) + "GB";
        }
    }

    public static String b(File file) {
        String str = "";
        try {
        } catch (Exception e2) {
            str = e2.getMessage();
        }
        if (file.isFile()) {
            file.delete();
            return "";
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                int length = listFiles.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        file.delete();
                        return "";
                    }
                    b(listFiles[i2]);
                    i = i2 + 1;
                }
            }
            file.delete();
            return "";
        }
        return str;
    }

    public static void b() {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.expressad.foundation.h.m.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.anythink.expressad.d.b.a();
                    com.anythink.expressad.foundation.b.a.b().e();
                    com.anythink.expressad.d.a b2 = com.anythink.expressad.d.b.b();
                    com.anythink.expressad.d.a aVar = b2;
                    if (b2 == null) {
                        com.anythink.expressad.d.b.a();
                        aVar = com.anythink.expressad.d.b.c();
                    }
                    m.a(com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_RES_MANAGER_DIR), aVar.b());
                    m.a(System.currentTimeMillis() - (aVar.n() * 1000));
                } catch (Exception e2) {
                    if (com.anythink.expressad.a.f4103a) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

    public static File[] b(String str) {
        try {
            File file = new File(str);
            File[] fileArr = null;
            if (file.exists()) {
                fileArr = file.listFiles();
            }
            return fileArr;
        } catch (Exception e2) {
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x006c: MOVE  (r0 I:??[long, double]) = (r8 I:??[long, double]), block:B:26:0x0068 */
    private static long c(File file) {
        FileInputStream fileInputStream;
        long j;
        long j2;
        long j3 = 0;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    if (file.exists()) {
                        fileInputStream = new FileInputStream(file);
                        try {
                            j3 = fileInputStream.available();
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            j2 = 0;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                                j2 = 0;
                            }
                            return j2;
                        } catch (Throwable th) {
                            fileInputStream2 = fileInputStream;
                            th = th;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        file.createNewFile();
                        o.d("获取文件大小", "文件不存在!");
                        fileInputStream = null;
                    }
                    j2 = j3;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                        return j3;
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream = null;
                }
                return j2;
            } catch (Exception e5) {
                e5.printStackTrace();
                return j;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(str);
            if (!file.exists() || !file.isDirectory()) {
                return;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                File file2 = listFiles[i2];
                if (file2.lastModified() + (currentTimeMillis - 1440000) < currentTimeMillis2) {
                    b(file2);
                    try {
                        File file3 = new File(str + ".zip");
                        if (file3.exists() && file3.isFile()) {
                            b(file3);
                        }
                    } catch (Exception e2) {
                    }
                }
                i = i2 + 1;
            }
        } catch (Exception e3) {
        }
    }

    private static void c(String str, int i) {
        try {
            if (d(new File(str)) > i * 1048576) {
                f(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            o.d(g, "clean memory failed");
        }
    }

    private static boolean c(String str, String str2) {
        File[] listFiles;
        if (str == null) {
            return false;
        }
        try {
            if (TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2)) {
                return false;
            }
            File file = new File(str);
            if (!file.isDirectory() || file.listFiles() == null || file.listFiles().length <= 0 || (listFiles = file.listFiles()) == null) {
                return false;
            }
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                File file2 = listFiles[i2];
                if (!file2.isFile()) {
                    c(file2.getAbsolutePath(), str2);
                } else if (str2.equals(file2.getName())) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static long d(File file) {
        File[] listFiles = file.listFiles();
        long j = 0;
        long j2 = 0;
        if (listFiles != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                j2 = j;
                if (i2 >= listFiles.length) {
                    break;
                }
                j += listFiles[i2].isDirectory() ? d(listFiles[i2]) : c(listFiles[i2]);
                i = i2 + 1;
            }
        }
        return j2;
    }

    public static String d(String str) {
        return !TextUtils.isEmpty(str) ? p.a(x.a(str.trim())) : "";
    }

    private static boolean d(String str, int i) {
        try {
            Class.forName("android.os.FileUtils").getMethod("setPermissions", String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, str, Integer.valueOf(i), -1, -1);
            return true;
        } catch (ClassNotFoundException e2) {
            o.a(g, "error when set permissions:", e2);
            return false;
        } catch (IllegalAccessException e3) {
            o.a(g, "error when set permissions:", e3);
            return false;
        } catch (IllegalArgumentException e4) {
            o.a(g, "error when set permissions:", e4);
            return false;
        } catch (NoSuchMethodException e5) {
            o.a(g, "error when set permissions:", e5);
            return false;
        } catch (InvocationTargetException e6) {
            o.a(g, "error when set permissions:", e6);
            return false;
        }
    }

    private static String e(String str) {
        long j;
        File file = new File(str);
        try {
            j = file.isDirectory() ? d(file) : c(file);
        } catch (Exception e2) {
            e2.printStackTrace();
            o.d("获取文件大小", "获取失败!");
            j = 0;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j == 0) {
            return "0B";
        }
        if (j < 1024) {
            return decimalFormat.format(j) + "B";
        } else if (j < 1048576) {
            return decimalFormat.format(j / 1024.0d) + "KB";
        } else if (j < 1073741824) {
            return decimalFormat.format(j / 1048576.0d) + "AT";
        } else {
            return decimalFormat.format(j / 1.073741824E9d) + "GB";
        }
    }

    private static ArrayList<File> e(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.anythink.expressad.foundation.h.m.3
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return !file2.isHidden() || file2.isDirectory();
            }
        });
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            File file2 = listFiles[i2];
            if (file2.isDirectory()) {
                arrayList.addAll(e(file2));
            } else {
                arrayList.add(file2);
            }
            i = i2 + 1;
        }
    }

    private static void f(String str) {
        try {
            ArrayList<File> e2 = e(new File(str));
            Collections.sort(e2, new Comparator<File>() { // from class: com.anythink.expressad.foundation.h.m.4
                private static int a(File file, File file2) {
                    int i = ((file.lastModified() - file2.lastModified()) > 0L ? 1 : ((file.lastModified() - file2.lastModified()) == 0L ? 0 : -1));
                    if (i > 0) {
                        return 1;
                    }
                    return i == 0 ? 0 : -1;
                }

                @Override // java.util.Comparator
                public final /* synthetic */ int compare(File file, File file2) {
                    int i = ((file.lastModified() - file2.lastModified()) > 0L ? 1 : ((file.lastModified() - file2.lastModified()) == 0L ? 0 : -1));
                    if (i > 0) {
                        return 1;
                    }
                    return i == 0 ? 0 : -1;
                }

                @Override // java.util.Comparator
                public final boolean equals(Object obj) {
                    return true;
                }
            });
            int size = (e2.size() - 1) / 2;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                File file = e2.get(i2);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
                i = i2 + 1;
            }
        } catch (Exception e3) {
            o.d(g, "del memory failed");
        }
    }

    private static void g(String str) {
        try {
            File file = new File(str);
            if (!file.exists() || !file.isDirectory()) {
                return;
            }
            File[] b2 = b(str);
            int length = b2.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                File file2 = b2[i2];
                if (file2.exists() && file2.isFile()) {
                    file2.delete();
                }
                i = i2 + 1;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
