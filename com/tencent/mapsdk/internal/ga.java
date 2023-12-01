package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ga.class */
public class ga {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23795a = "FileUtil";
    public static final int b = 1024;

    /* renamed from: c  reason: collision with root package name */
    public static final int f23796c = 1048576;
    public static final int d = 1073741824;
    public static File e;
    private static final cb f = new cb();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ga$a.class */
    public static final class a implements FileFilter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f23797a;

        public a(String str) {
            this.f23797a = str;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.compile(this.f23797a).matcher(file.getName()).matches();
        }
    }

    public static long a(File file, FileFilter fileFilter) {
        long j = 0;
        long j2 = 0;
        if (file != null) {
            if (!file.exists()) {
                return 0L;
            }
            j2 = 0;
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles(fileFilter);
                j2 = 0;
                if (listFiles != null) {
                    int length = listFiles.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        j2 = j;
                        if (i2 >= length) {
                            break;
                        }
                        j += a(listFiles[i2], fileFilter);
                        i = i2 + 1;
                    }
                }
            }
            if (fileFilter == null || fileFilter.accept(file)) {
                j2 = file.length();
                File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
                file.renameTo(file2);
                file2.delete();
            }
        }
        return j2;
    }

    public static File a(File file) {
        return a(file.getParentFile(), file.getName());
    }

    public static File a(File file, String str) {
        if (file == null || TextUtils.isEmpty(str)) {
            return null;
        }
        File file2 = new File(file, str);
        file2.mkdirs();
        return file2;
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            String packageName = context.getPackageName();
            if (packageName == null || packageName.length() == 0) {
                return "";
            }
            String str = packageName;
            if (packageName.length() > 255) {
                str = packageName.substring(0, 254);
            }
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x009f, code lost:
        if (r7 != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0187, code lost:
        if (r6 == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01bf, code lost:
        if (r6 == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01c2, code lost:
        d(r5);
        b(r12, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01ce, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01cf, code lost:
        d(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01d5, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.io.File r5, int r6) {
        /*
            Method dump skipped, instructions count: 509
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.ga.a(java.io.File, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00d0, code lost:
        if (r8 != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x016f, code lost:
        if (r6 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01a4, code lost:
        if (r6 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01a7, code lost:
        d(r5);
        b(r13, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01b3, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01b4, code lost:
        d(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01b9, code lost:
        return;
     */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x00eb: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r16 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:36:0x00eb */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.io.File r5, int r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.ga.a(java.io.File, int, java.lang.String):void");
    }

    public static void a(File file, File file2) {
        if (!file2.exists()) {
            a(file2.getParentFile(), file2.getName());
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file3 : listFiles) {
                    a(file3, new File(file2, file.getName()));
                }
                return;
            }
            return;
        }
        File file4 = new File(file2, file.getName());
        if (Build.VERSION.SDK_INT < 26) {
            b(file4, h(file));
            return;
        }
        try {
            Files.copy(file.toPath(), file4.toPath(), new CopyOption[0]);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void a(File file, byte[] bArr) {
        RandomAccessFile randomAccessFile;
        if (file == null || bArr == null || bArr.length == 0) {
            return;
        }
        if (!file.exists()) {
            b(file);
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    randomAccessFile.seek(randomAccessFile.length());
                    randomAccessFile.write(bArr);
                    ha.a(randomAccessFile);
                } catch (FileNotFoundException e2) {
                    e = e2;
                    e.printStackTrace();
                    ha.a(randomAccessFile);
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                    ha.a(randomAccessFile);
                } catch (Throwable th) {
                    randomAccessFile2 = randomAccessFile;
                    th = th;
                    ha.a(randomAccessFile2);
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                randomAccessFile = null;
            } catch (IOException e5) {
                e = e5;
                randomAccessFile = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(String str) {
        return b(new File(str));
    }

    public static boolean a(String str, String str2) {
        File file = new File(str);
        File file2 = new File(str2);
        if (file2.exists()) {
            e(file2);
        }
        return file.renameTo(new File(str2));
    }

    public static File b(File file, String str) {
        File file2 = null;
        if (file != null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int lastIndexOf = str.lastIndexOf(File.separator);
            File file3 = file;
            String str2 = str;
            if (lastIndexOf != -1) {
                str2 = str.substring(lastIndexOf + 1);
                file3 = new File(file, str.substring(0, lastIndexOf));
            }
            if (!file3.exists() && !file3.mkdirs()) {
                if (Log.isLoggable("FileUtil", 6)) {
                    Log.e("FileUtil", "create file failed with mkdirs failed:" + file3.getAbsolutePath());
                    return null;
                }
                return null;
            }
            File file4 = new File(file3, str2);
            file2 = file4;
            try {
                if (!file4.exists()) {
                    file2 = file4;
                    if (!file4.createNewFile()) {
                        file2 = file4;
                        if (Log.isLoggable("FileUtil", 6)) {
                            Log.e("FileUtil", "create file failed:" + file4.getAbsolutePath());
                            return file4;
                        }
                    }
                }
            } catch (IOException e2) {
                file2 = file4;
                if (Log.isLoggable("FileUtil", 6)) {
                    Log.e("FileUtil", "create file failed.", e2);
                    file2 = file4;
                }
            }
        }
        return file2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v6 */
    public static String b(File file, int i) {
        BufferedReader bufferedReader;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (i == -1) {
                return null;
            }
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    try {
                        String readLine = bufferedReader.readLine();
                        file = bufferedReader;
                        if (readLine == null) {
                            break;
                        } else if (i3 == i) {
                            ha.a(bufferedReader);
                            return readLine;
                        } else {
                            i2 = i3 + 1;
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        e.printStackTrace();
                        file = bufferedReader;
                        ha.a((Closeable) file);
                        return null;
                    } catch (IOException e3) {
                        e = e3;
                        e.printStackTrace();
                        file = bufferedReader;
                        ha.a((Closeable) file);
                        return null;
                    }
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                bufferedReader = 0;
            } catch (IOException e5) {
                e = e5;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                file = null;
                ha.a((Closeable) file);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String b(String str) {
        String str2;
        if (str == null) {
            return "";
        }
        String trim = str.trim();
        String str3 = trim;
        if (trim.contains("../")) {
            str3 = trim.replaceAll("\\.\\./", "");
        }
        while (true) {
            str2 = str3;
            if (!str3.startsWith(File.separator)) {
                break;
            }
            str3 = str3.substring(1);
        }
        while (str2.endsWith(File.separator)) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        return str2;
    }

    public static void b(File file, int i, String str) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        File file2;
        RandomAccessFile randomAccessFile3;
        RandomAccessFile randomAccessFile4;
        File file3;
        RandomAccessFile randomAccessFile5;
        long j;
        long j2;
        if (file == null || !file.exists() || i == -1) {
            return;
        }
        File file4 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (FileNotFoundException e2) {
                e = e2;
                file2 = null;
                randomAccessFile = null;
                randomAccessFile3 = null;
            } catch (IOException e3) {
                e = e3;
                file2 = null;
                randomAccessFile = null;
                randomAccessFile3 = null;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = null;
                randomAccessFile2 = null;
            }
            try {
                file2 = c(file);
                try {
                    randomAccessFile2 = new RandomAccessFile(file2, "rw");
                    int i2 = 0;
                    long j3 = 0;
                    while (true) {
                        try {
                            j = j3;
                            String readLine = randomAccessFile.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (i2 == i) {
                                j2 = randomAccessFile.getFilePointer() - IOUtils.LINE_SEPARATOR_WINDOWS.getBytes().length;
                            } else {
                                j2 = j;
                                if (i2 > i) {
                                    randomAccessFile2.write(readLine.getBytes("ISO-8859-1"));
                                    j2 = j;
                                }
                            }
                            i2++;
                            j3 = j2;
                        } catch (FileNotFoundException e4) {
                            randomAccessFile3 = randomAccessFile2;
                            e = e4;
                            e.printStackTrace();
                            randomAccessFile4 = randomAccessFile3;
                            file3 = file2;
                            randomAccessFile5 = randomAccessFile;
                            ha.a(randomAccessFile5);
                            ha.a(randomAccessFile4);
                            d(file3);
                        } catch (IOException e5) {
                            randomAccessFile3 = randomAccessFile2;
                            e = e5;
                            e.printStackTrace();
                            randomAccessFile4 = randomAccessFile3;
                            file3 = file2;
                            randomAccessFile5 = randomAccessFile;
                            ha.a(randomAccessFile5);
                            ha.a(randomAccessFile4);
                            d(file3);
                        } catch (Throwable th2) {
                            file4 = file2;
                            th = th2;
                            ha.a(randomAccessFile);
                            ha.a(randomAccessFile2);
                            d(file4);
                            throw th;
                        }
                    }
                    randomAccessFile.seek(j);
                    randomAccessFile.write((str + IOUtils.LINE_SEPARATOR_WINDOWS).getBytes());
                    randomAccessFile2.seek(0L);
                    while (true) {
                        String readLine2 = randomAccessFile2.readLine();
                        randomAccessFile5 = randomAccessFile;
                        randomAccessFile4 = randomAccessFile2;
                        file3 = file2;
                        if (readLine2 == null) {
                            break;
                        }
                        randomAccessFile.write(readLine2.getBytes("ISO-8859-1"));
                    }
                } catch (FileNotFoundException e6) {
                    e = e6;
                    randomAccessFile3 = null;
                } catch (IOException e7) {
                    e = e7;
                    randomAccessFile3 = null;
                }
            } catch (FileNotFoundException e8) {
                e = e8;
                file2 = null;
                randomAccessFile3 = null;
            } catch (IOException e9) {
                e = e9;
                file2 = null;
                randomAccessFile3 = null;
            } catch (Throwable th3) {
                th = th3;
                file4 = null;
                randomAccessFile2 = null;
                ha.a(randomAccessFile);
                ha.a(randomAccessFile2);
                d(file4);
                throw th;
            }
            ha.a(randomAccessFile5);
            ha.a(randomAccessFile4);
            d(file3);
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
        }
    }

    public static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return false;
        }
        if (parentFile.exists() || parentFile.mkdirs()) {
            try {
                return file.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean b(File file, File file2) {
        if (file == null || !file.exists()) {
            return false;
        }
        d(file2);
        return file.renameTo(file2);
    }

    public static boolean b(File file, byte[] bArr) {
        FileOutputStream fileOutputStream;
        if (file == null || bArr == null || !b(file)) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.close();
                        return true;
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            return false;
                        }
                        return false;
                    } catch (IOException e3) {
                        e = e3;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            return false;
                        }
                        return false;
                    } catch (Throwable th) {
                        fileOutputStream2 = fileOutputStream;
                        th = th;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                    fileOutputStream = null;
                } catch (IOException e6) {
                    e = e6;
                    fileOutputStream = null;
                }
            } catch (IOException e7) {
                e7.printStackTrace();
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static File[] b(File file, FileFilter fileFilter) {
        File[] fileArr = new File[0];
        if (file != null && file.isDirectory()) {
            return file.listFiles(fileFilter);
        }
        return fileArr;
    }

    public static File c(File file) {
        if (file != null) {
            File parentFile = file.getParentFile();
            StringBuilder sb = new StringBuilder();
            cb cbVar = f;
            sb.append(cbVar.a(System.currentTimeMillis() + ""));
            sb.append(".tmp");
            return b(parentFile, sb.toString());
        }
        return null;
    }

    public static File[] c(File file, String str) {
        return b(file, new a(str));
    }

    public static int d(File file, String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        if (file == null || !file.exists()) {
            return -1;
        }
        BufferedReader bufferedReader3 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                int i = 0;
                while (true) {
                    try {
                        int i2 = i;
                        String readLine = bufferedReader.readLine();
                        bufferedReader2 = bufferedReader;
                        if (readLine == null) {
                            break;
                        } else if (readLine.startsWith(str)) {
                            ha.a(bufferedReader);
                            return i2;
                        } else {
                            i = i2 + 1;
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        e.printStackTrace();
                        bufferedReader2 = bufferedReader;
                        ha.a(bufferedReader2);
                        return -1;
                    } catch (IOException e3) {
                        e = e3;
                        e.printStackTrace();
                        bufferedReader2 = bufferedReader;
                        ha.a(bufferedReader2);
                        return -1;
                    } catch (Throwable th) {
                        bufferedReader3 = bufferedReader;
                        th = th;
                        ha.a(bufferedReader3);
                        throw th;
                    }
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                bufferedReader = null;
            } catch (IOException e5) {
                e = e5;
                bufferedReader = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean d(File file) {
        boolean z = false;
        if (file != null) {
            z = false;
            if (file.exists()) {
                Stack stack = new Stack();
                stack.push(file);
                z = false;
                while (!stack.isEmpty()) {
                    File file2 = (File) stack.peek();
                    if (file2.isFile()) {
                        z = file2.delete();
                        stack.pop();
                    } else if (file2.isDirectory()) {
                        File[] listFiles = file2.listFiles();
                        if (listFiles == null || listFiles.length == 0) {
                            z = file2.delete();
                            stack.pop();
                        } else {
                            int length = listFiles.length;
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 < length) {
                                    stack.push(listFiles[i2]);
                                    i = i2 + 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public static long e(File file) {
        return a(file, (FileFilter) null);
    }

    public static void e(File file, String str) {
        RandomAccessFile randomAccessFile;
        if (file == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!file.exists()) {
            b(file);
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    randomAccessFile.seek(randomAccessFile.length());
                    randomAccessFile.write((str + IOUtils.LINE_SEPARATOR_WINDOWS).getBytes());
                    ha.a(randomAccessFile);
                } catch (FileNotFoundException e2) {
                    e = e2;
                    e.printStackTrace();
                    ha.a(randomAccessFile);
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                    ha.a(randomAccessFile);
                } catch (Throwable th) {
                    randomAccessFile2 = randomAccessFile;
                    th = th;
                    ha.a(randomAccessFile2);
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                randomAccessFile = null;
            } catch (IOException e5) {
                e = e5;
                randomAccessFile = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean f(File file) {
        if (file != null && file.exists() && file.isFile()) {
            return file.delete();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable] */
    public static List<String> g(File file) {
        BufferedReader bufferedReader;
        if (file == null) {
            return null;
        }
        try {
            if (!file.exists()) {
                return null;
            }
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e2) {
                e = e2;
                bufferedReader = null;
            } catch (IOException e3) {
                e = e3;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                file = null;
                ha.a((Closeable) file);
                throw th;
            }
            try {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        ha.a(bufferedReader);
                        return arrayList;
                    }
                    arrayList.add(readLine);
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                e.printStackTrace();
                ha.a(bufferedReader);
                return null;
            } catch (IOException e5) {
                e = e5;
                e.printStackTrace();
                ha.a(bufferedReader);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x011e: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:72:0x011e */
    public static byte[] h(File file) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        FileInputStream fileInputStream2;
        ByteArrayOutputStream byteArrayOutputStream3;
        FileInputStream fileInputStream3;
        ByteArrayOutputStream byteArrayOutputStream4 = null;
        if (file == null) {
            return null;
        }
        try {
            try {
                if (!file.exists()) {
                    return null;
                }
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        ByteArrayOutputStream byteArrayOutputStream5 = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream5.write(bArr, 0, read);
                            }
                            byte[] byteArray = byteArrayOutputStream5.toByteArray();
                            try {
                                byteArrayOutputStream5.flush();
                                byteArrayOutputStream5.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            try {
                                fileInputStream.close();
                                return byteArray;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return byteArray;
                            }
                        } catch (FileNotFoundException e4) {
                            e = e4;
                            fileInputStream3 = fileInputStream;
                            byteArrayOutputStream3 = byteArrayOutputStream5;
                            e.printStackTrace();
                            if (byteArrayOutputStream3 != null) {
                                try {
                                    byteArrayOutputStream3.flush();
                                    byteArrayOutputStream3.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (fileInputStream3 != null) {
                                fileInputStream3.close();
                                return null;
                            }
                            return null;
                        } catch (IOException e6) {
                            e = e6;
                            fileInputStream2 = fileInputStream;
                            byteArrayOutputStream2 = byteArrayOutputStream5;
                            e.printStackTrace();
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.flush();
                                    byteArrayOutputStream2.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                                return null;
                            }
                            return null;
                        }
                    } catch (FileNotFoundException e8) {
                        e = e8;
                        fileInputStream3 = fileInputStream;
                        byteArrayOutputStream3 = null;
                    } catch (IOException e9) {
                        e = e9;
                        fileInputStream2 = fileInputStream;
                        byteArrayOutputStream2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayOutputStream4 != null) {
                            try {
                                byteArrayOutputStream4.flush();
                                byteArrayOutputStream4.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e12) {
                    e = e12;
                    byteArrayOutputStream3 = null;
                    fileInputStream3 = null;
                } catch (IOException e13) {
                    e = e13;
                    byteArrayOutputStream2 = null;
                    fileInputStream2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
                byteArrayOutputStream4 = byteArrayOutputStream;
            }
        } catch (IOException e14) {
            e14.printStackTrace();
            return null;
        }
    }
}
