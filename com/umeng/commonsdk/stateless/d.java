package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.zip.Deflater;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/stateless/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f27205a;
    private static Object b = new Object();

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0150, code lost:
        if (r14 == null) goto L85;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r6, java.lang.String r7, java.lang.String r8, byte[] r9) {
        /*
            Method dump skipped, instructions count: 414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.d.a(android.content.Context, java.lang.String, java.lang.String, byte[]):int");
    }

    public static File a(Context context) {
        File file;
        File file2 = null;
        File file3 = null;
        try {
            synchronized (b) {
                StringBuilder sb = new StringBuilder();
                sb.append("get last envelope begin, thread is ");
                sb.append(Thread.currentThread());
                ULog.i("walle", sb.toString());
                file = null;
                if (context != null) {
                    file = null;
                    if (context.getApplicationContext() != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(context.getApplicationContext().getFilesDir());
                        sb2.append(File.separator);
                        sb2.append(a.e);
                        String sb3 = sb2.toString();
                        file = null;
                        if (!TextUtils.isEmpty(sb3)) {
                            File file4 = new File(sb3);
                            file = null;
                            if (file4.isDirectory()) {
                                File[] listFiles = file4.listFiles();
                                file = null;
                                if (listFiles != null) {
                                    file = null;
                                    if (listFiles.length > 0) {
                                        int i = 0;
                                        while (true) {
                                            file = file2;
                                            if (i >= listFiles.length) {
                                                break;
                                            }
                                            File file5 = listFiles[i];
                                            File file6 = file2;
                                            if (file5 != null) {
                                                file6 = file2;
                                                if (file5.isDirectory()) {
                                                    File file7 = file2;
                                                    File[] listFiles2 = file5.listFiles();
                                                    file6 = file2;
                                                    if (listFiles2 != null) {
                                                        file6 = file2;
                                                        if (listFiles2.length > 0) {
                                                            File file8 = file2;
                                                            Arrays.sort(listFiles2, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.1
                                                                @Override // java.util.Comparator
                                                                /* renamed from: a */
                                                                public int compare(File file9, File file10) {
                                                                    int i2 = ((file9.lastModified() - file10.lastModified()) > 0L ? 1 : ((file9.lastModified() - file10.lastModified()) == 0L ? 0 : -1));
                                                                    if (i2 > 0) {
                                                                        return 1;
                                                                    }
                                                                    return i2 == 0 ? 0 : -1;
                                                                }
                                                            });
                                                            File file9 = listFiles2[0];
                                                            file6 = file2;
                                                            if (file9 != null) {
                                                                if (file2 != null) {
                                                                    file6 = file2;
                                                                    if (file2.lastModified() > file9.lastModified()) {
                                                                    }
                                                                }
                                                                file6 = file9;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            i++;
                                            file2 = file6;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                StringBuilder sb4 = new StringBuilder();
                File file10 = file;
                sb4.append("get last envelope end, thread is ");
                File file11 = file;
                sb4.append(Thread.currentThread());
                File file12 = file;
                ULog.i("walle", sb4.toString());
                file3 = file;
            }
            return file;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return file3;
        }
    }

    public static String a(Context context, boolean z) {
        String str;
        if (context == null) {
            return null;
        }
        try {
            if (z) {
                str = context.getApplicationContext().getFilesDir() + File.separator + a.e;
            } else {
                str = context.getApplicationContext().getFilesDir() + File.separator + a.f;
            }
            return str;
        } catch (Throwable th) {
            return null;
        }
    }

    public static void a(Context context, String str, int i) {
        try {
            if (str == null) {
                ULog.i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
                return;
            }
            File file = new File(str);
            if (!file.isDirectory()) {
                ULog.i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
                return;
            }
            synchronized (b) {
                File[] listFiles = file.listFiles();
                ULog.i("AmapLBS", "[lbs-build] delete file begin " + listFiles.length + ", thread is " + Thread.currentThread());
                if (listFiles == null || listFiles.length < i) {
                    ULog.i("AmapLBS", "[lbs-build] file size < max");
                } else {
                    ULog.i("AmapLBS", "[lbs-build] file size >= max");
                    ArrayList arrayList = new ArrayList();
                    int length = listFiles.length;
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= length) {
                            break;
                        }
                        File file2 = listFiles[i3];
                        if (file2 != null) {
                            arrayList.add(file2);
                        }
                        i2 = i3 + 1;
                    }
                    if (arrayList.size() >= i) {
                        Collections.sort(arrayList, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.4
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(File file3, File file4) {
                                if (file3 == null || file4 == null || file3.lastModified() >= file4.lastModified()) {
                                    return (file3 == null || file4 == null || file3.lastModified() != file4.lastModified()) ? 1 : 0;
                                }
                                return -1;
                            }
                        });
                        if (ULog.DEBUG) {
                            int i4 = 0;
                            while (true) {
                                int i5 = i4;
                                if (i5 >= arrayList.size()) {
                                    break;
                                }
                                ULog.i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i5)).getPath());
                                i4 = i5 + 1;
                            }
                        }
                        int i6 = 0;
                        while (true) {
                            int i7 = i6;
                            if (i7 > arrayList.size() - i) {
                                break;
                            }
                            if (arrayList.get(i7) != null) {
                                ULog.i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i7)).getPath());
                                try {
                                    ((File) arrayList.get(i7)).delete();
                                    arrayList.remove(i7);
                                } catch (Exception e) {
                                }
                            }
                            i6 = i7 + 1;
                        }
                    }
                }
                ULog.i("AmapLBS", "[lbs-build] delete file end " + listFiles.length + ", thread is " + Thread.currentThread());
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static void a(Context context, String str, final String str2, int i) {
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.isDirectory()) {
                synchronized (b) {
                    File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.umeng.commonsdk.stateless.d.5
                        @Override // java.io.FilenameFilter
                        public boolean accept(File file2, String str3) {
                            return str3.startsWith(str2);
                        }
                    });
                    if (listFiles == null || listFiles.length < i) {
                        ULog.i("AmapLBS", "[lbs-build] file size < max");
                    } else {
                        ULog.i("AmapLBS", "[lbs-build] file size >= max");
                        ArrayList arrayList = new ArrayList();
                        int length = listFiles.length;
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= length) {
                                break;
                            }
                            File file2 = listFiles[i3];
                            if (file2 != null) {
                                arrayList.add(file2);
                            }
                            i2 = i3 + 1;
                        }
                        if (arrayList.size() >= i) {
                            Collections.sort(arrayList, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.6
                                @Override // java.util.Comparator
                                /* renamed from: a */
                                public int compare(File file3, File file4) {
                                    if (file3 == null || file4 == null || file3.lastModified() >= file4.lastModified()) {
                                        return (file3 == null || file4 == null || file3.lastModified() != file4.lastModified()) ? 1 : 0;
                                    }
                                    return -1;
                                }
                            });
                            if (ULog.DEBUG) {
                                int i4 = 0;
                                while (true) {
                                    int i5 = i4;
                                    if (i5 >= arrayList.size()) {
                                        break;
                                    }
                                    ULog.i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i5)).getPath());
                                    i4 = i5 + 1;
                                }
                            }
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 > arrayList.size() - i) {
                                    break;
                                }
                                if (arrayList.get(i7) != null) {
                                    ULog.i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i7)).getPath());
                                    try {
                                        ((File) arrayList.get(i7)).delete();
                                        arrayList.remove(i7);
                                    } catch (Exception e) {
                                    }
                                }
                                i6 = i7 + 1;
                            }
                        }
                    }
                    ULog.i("AmapLBS", "[lbs-build] delete file end " + listFiles.length + ", thread is " + Thread.currentThread());
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static boolean a(long j, long j2) {
        return j > j2;
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            String[] list = file.list();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.length) {
                    break;
                } else if (!a(new File(file, list[i2]))) {
                    return false;
                } else {
                    i = i2 + 1;
                }
            }
        }
        return file.delete();
    }

    public static byte[] a(String str) throws IOException {
        byte[] bArr;
        synchronized (b) {
            FileChannel fileChannel = null;
            try {
                FileChannel channel = new RandomAccessFile(str, "r").getChannel();
                MappedByteBuffer load = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).load();
                bArr = new byte[(int) channel.size()];
                if (load.remaining() > 0) {
                    fileChannel = channel;
                    load.get(bArr, 0, load.remaining());
                }
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (Throwable th) {
                    }
                }
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder();
                FileChannel fileChannel2 = fileChannel;
                sb.append("[stateless] write envelope, e is ");
                FileChannel fileChannel3 = fileChannel;
                sb.append(e.getMessage());
                FileChannel fileChannel4 = fileChannel;
                ULog.i("walle", sb.toString());
                FileChannel fileChannel5 = fileChannel;
                throw e;
            }
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        f27205a = 0;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            while (!deflater.finished()) {
                try {
                    int deflate = deflater.deflate(bArr2);
                    f27205a += deflate;
                    byteArrayOutputStream.write(bArr2, 0, deflate);
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            }
            deflater.end();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }

    public static File b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (b) {
                String str = context.getApplicationContext().getFilesDir() + File.separator + a.f;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                synchronized (b) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length != 0) {
                        Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.2
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(File file2, File file3) {
                                int i = ((file2.lastModified() - file3.lastModified()) > 0L ? 1 : ((file2.lastModified() - file3.lastModified()) == 0L ? 0 : -1));
                                if (i > 0) {
                                    return 1;
                                }
                                return i == 0 ? 0 : -1;
                            }
                        });
                        return listFiles[0];
                    }
                    return null;
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String b(String str) {
        try {
            return Base64.encodeToString(str.getBytes(), 0);
        } catch (Throwable th) {
            return "";
        }
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return stringBuffer.toString().toLowerCase(Locale.US);
            }
            stringBuffer.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0182, code lost:
        if (r0 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01c8, code lost:
        if (r0 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01cb, code lost:
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01d1, code lost:
        r11 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01e4, code lost:
        r11 = r10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(android.content.Context r6, java.lang.String r7, java.lang.String r8, byte[] r9) {
        /*
            Method dump skipped, instructions count: 505
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.d.b(android.content.Context, java.lang.String, java.lang.String, byte[]):boolean");
    }

    public static String c(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Throwable th) {
            return "";
        }
    }

    public static File[] c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (b) {
                String str = context.getApplicationContext().getFilesDir() + File.separator + a.f;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                synchronized (b) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length != 0) {
                        Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.3
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(File file2, File file3) {
                                int i = ((file2.lastModified() - file3.lastModified()) > 0L ? 1 : ((file2.lastModified() - file3.lastModified()) == 0L ? 0 : -1));
                                if (i > 0) {
                                    return 1;
                                }
                                return i == 0 ? 0 : -1;
                            }
                        });
                        return listFiles;
                    }
                    return null;
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String d(String str) {
        if (!TextUtils.isEmpty(str) && str.indexOf("envelope") < 0) {
            int lastIndexOf = str.lastIndexOf("_");
            String str2 = "";
            if (lastIndexOf >= 0) {
                int lastIndexOf2 = str.lastIndexOf(".");
                str2 = "";
                if (lastIndexOf2 >= 0) {
                    str2 = str.substring(lastIndexOf + 1, lastIndexOf2);
                }
            }
            return str2;
        }
        return "";
    }
}
