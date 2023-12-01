package com.tencent.thumbplayer.utils;

import android.content.Context;
import android.os.Process;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, a> f39422a = new HashMap();
    private C1028a b;

    /* renamed from: com.tencent.thumbplayer.utils.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/a$a.class */
    public static class C1028a {

        /* renamed from: a  reason: collision with root package name */
        protected File f39423a;
        private final AtomicLong b;

        /* renamed from: c  reason: collision with root package name */
        private final AtomicInteger f39424c;
        private final long d;
        private final int e;
        private final Map<File, Long> f;

        private C1028a(File file, long j, int i) {
            this.f = Collections.synchronizedMap(new HashMap());
            this.f39423a = file;
            this.d = j;
            this.e = i;
            this.b = new AtomicLong();
            this.f39424c = new AtomicInteger();
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public File a(String str) {
            File b = b(str);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            b.setLastModified(valueOf.longValue());
            this.f.put(b, valueOf);
            return b;
        }

        private void a() {
            o.a().d().execute(new Runnable() { // from class: com.tencent.thumbplayer.utils.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    File[] listFiles = C1028a.this.f39423a.listFiles();
                    if (listFiles != null) {
                        int i = 0;
                        int i2 = 0;
                        for (File file : listFiles) {
                            i = (int) (i + C1028a.this.b(file));
                            i2++;
                            C1028a.this.f.put(file, Long.valueOf(file.lastModified()));
                        }
                        C1028a.this.b.set(i);
                        C1028a.this.f39424c.set(i2);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(File file) {
            int i = this.f39424c.get();
            while (i + 1 > this.e) {
                this.b.addAndGet(-c());
                i = this.f39424c.addAndGet(-1);
            }
            this.f39424c.addAndGet(1);
            long b = b(file);
            long j = this.b.get();
            while (j + b > this.d) {
                j = this.b.addAndGet(-c());
            }
            this.b.addAndGet(b);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(valueOf.longValue());
            this.f.put(file, valueOf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long b(File file) {
            if (file == null) {
                return 0L;
            }
            return file.length();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public File b(String str) {
            File file = this.f39423a;
            StringBuilder sb = new StringBuilder();
            sb.append(str.hashCode());
            return new File(file, sb.toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.f.clear();
            this.b.set(0L);
            this.f39424c.set(0);
            File[] listFiles = this.f39423a.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    file.delete();
                }
            }
        }

        private long c() {
            File file;
            if (this.f.isEmpty()) {
                return 0L;
            }
            Set<Map.Entry<File, Long>> entrySet = this.f.entrySet();
            synchronized (this.f) {
                file = null;
                Long l = null;
                for (Map.Entry<File, Long> entry : entrySet) {
                    if (file == null) {
                        file = entry.getKey();
                        l = entry.getValue();
                    } else {
                        Long value = entry.getValue();
                        if (value.longValue() < l.longValue()) {
                            file = entry.getKey();
                            l = value;
                        }
                    }
                }
            }
            if (file == null) {
                return 0L;
            }
            long b = b(file);
            if (file != null && file.delete()) {
                this.f.remove(file);
            }
            return b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c(String str) {
            File a2 = a(str);
            long b = b(a2);
            if (a2.delete()) {
                this.f39424c.addAndGet(-1);
                this.b.addAndGet(-b);
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/a$b.class */
    public static class b {
        private static int a(byte[] bArr, char c2) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= bArr.length) {
                    return -1;
                }
                if (bArr[i2] == c2) {
                    return i2;
                }
                i = i2 + 1;
            }
        }

        private static String a(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            String sb2 = sb.toString();
            while (true) {
                String str = sb2;
                if (str.length() >= 13) {
                    return str + "-" + i + ' ';
                }
                sb2 = "0".concat(String.valueOf(str));
            }
        }

        private static byte[] a(byte[] bArr, int i, int i2) {
            int i3 = i2 - i;
            if (i3 >= 0) {
                byte[] bArr2 = new byte[i3];
                System.arraycopy((Object) bArr, i, (Object) bArr2, 0, Math.min(bArr.length - i, i3));
                return bArr2;
            }
            throw new IllegalArgumentException(i + " > " + i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] b(int i, byte[] bArr) {
            byte[] bytes = a(i).getBytes();
            byte[] bArr2 = new byte[bytes.length + bArr.length];
            System.arraycopy((Object) bytes, 0, (Object) bArr2, 0, bytes.length);
            System.arraycopy((Object) bArr, 0, (Object) bArr2, bytes.length, bArr.length);
            return bArr2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean c(byte[] bArr) {
            String str;
            String[] f = f(bArr);
            if (f == null || f.length != 2) {
                return false;
            }
            String str2 = f[0];
            while (true) {
                str = str2;
                if (!str.startsWith("0")) {
                    try {
                        break;
                    } catch (Exception e) {
                        return false;
                    }
                }
                str2 = str.substring(1, str.length());
            }
            return System.currentTimeMillis() > Long.valueOf(str).longValue() + (Long.valueOf(f[1]).longValue() * 1000);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] d(byte[] bArr) {
            byte[] bArr2 = bArr;
            if (e(bArr)) {
                bArr2 = a(bArr, a(bArr, ' ') + 1, bArr.length);
            }
            return bArr2;
        }

        private static boolean e(byte[] bArr) {
            return bArr != null && bArr.length > 15 && bArr[13] == 45 && a(bArr, ' ') > 14;
        }

        private static String[] f(byte[] bArr) {
            if (e(bArr)) {
                return new String[]{new String(a(bArr, 0, 13)), new String(a(bArr, 14, a(bArr, ' ')))};
            }
            return null;
        }
    }

    private a(File file, long j, int i) {
        if (file.exists() || file.mkdirs()) {
            this.b = new C1028a(file, j, i);
        } else {
            this.b = null;
        }
    }

    public static a a(Context context, String str) {
        return a(new File(context.getCacheDir(), str), 50000000L, Integer.MAX_VALUE);
    }

    public static a a(File file, long j, int i) {
        a aVar;
        try {
            aVar = f39422a.get(file.getAbsoluteFile() + b());
        } catch (Exception e) {
            aVar = null;
        }
        a aVar2 = aVar;
        if (aVar == null) {
            try {
                aVar2 = new a(file, j, i);
                try {
                    f39422a.put(file.getAbsolutePath() + b(), aVar2);
                } catch (Throwable th) {
                }
            } catch (Throwable th2) {
                return aVar;
            }
        }
        return aVar2;
    }

    private static String b() {
        return BridgeUtil.UNDERLINE_STR + Process.myPid();
    }

    public void a() {
        C1028a c1028a = this.b;
        if (c1028a == null) {
            return;
        }
        c1028a.b();
    }

    public void a(String str, Serializable serializable) {
        a(str, serializable, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(String str, Serializable serializable, int i) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream3;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                objectOutputStream3 = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Exception e) {
                e = e;
                objectOutputStream2 = null;
            } catch (Throwable th) {
                th = th;
                objectOutputStream = null;
            }
            try {
                objectOutputStream3.writeObject(serializable);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (i != -1) {
                    a(str, byteArray, i);
                } else {
                    a(str, byteArray);
                }
                try {
                    objectOutputStream3.close();
                } catch (Throwable th2) {
                }
            } catch (Exception e2) {
                objectOutputStream2 = objectOutputStream3;
                e = e2;
                e.printStackTrace();
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (Throwable th3) {
                    }
                }
            } catch (Throwable th4) {
                objectOutputStream = objectOutputStream3;
                th = th4;
                th.printStackTrace();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (Throwable th5) {
                    }
                }
            }
        } catch (Throwable th6) {
            if (serializable != 0) {
                try {
                    serializable.close();
                } catch (Throwable th7) {
                }
            }
            throw th6;
        }
    }

    public void a(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        C1028a c1028a = this.b;
        if (c1028a == null) {
            return;
        }
        File b2 = c1028a.b(str);
        FileOutputStream fileOutputStream3 = null;
        try {
            try {
                fileOutputStream2 = new FileOutputStream(b2);
                try {
                    fileOutputStream2.write(bArr);
                } catch (Exception e) {
                    fileOutputStream = fileOutputStream2;
                    e = e;
                    fileOutputStream3 = fileOutputStream;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            e.printStackTrace();
                            this.b.a(b2);
                        }
                    }
                    this.b.a(b2);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream3 = fileOutputStream2;
                    if (fileOutputStream3 != null) {
                        try {
                            fileOutputStream3.flush();
                            fileOutputStream3.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    this.b.a(b2);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = null;
            }
            try {
                fileOutputStream2.flush();
                fileOutputStream2.close();
            } catch (IOException e5) {
                e = e5;
                e.printStackTrace();
                this.b.a(b2);
            }
            this.b.a(b2);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void a(String str, byte[] bArr, int i) {
        a(str, b.b(i, bArr));
    }

    public byte[] a(String str) {
        RandomAccessFile randomAccessFile;
        C1028a c1028a = this.b;
        AutoCloseable autoCloseable = null;
        try {
            if (c1028a == null) {
                return null;
            }
            try {
                File a2 = c1028a.a(str);
                if (a2.exists()) {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(a2, "r");
                    try {
                        byte[] bArr = new byte[(int) randomAccessFile2.length()];
                        if (randomAccessFile2.read(bArr) <= 0) {
                            try {
                                randomAccessFile2.close();
                                return null;
                            } catch (IOException e) {
                                e.printStackTrace();
                                return null;
                            }
                        } else if (b.c(bArr)) {
                            try {
                                randomAccessFile2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            c(str);
                            return null;
                        } else {
                            byte[] d = b.d(bArr);
                            try {
                                randomAccessFile2.close();
                                return d;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return d;
                            }
                        }
                    } catch (Exception e4) {
                        randomAccessFile = randomAccessFile2;
                        e = e4;
                        e.printStackTrace();
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                                return null;
                            } catch (IOException e5) {
                                e5.printStackTrace();
                                return null;
                            }
                        }
                        return null;
                    }
                }
                return null;
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        autoCloseable.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x009a: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:43:0x009a */
    public Object b(String str) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2;
        Throwable th;
        AutoCloseable autoCloseable;
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream3;
        ObjectInputStream objectInputStream2;
        byte[] a2 = a(str);
        try {
            if (a2 != null) {
                try {
                    byteArrayInputStream2 = new ByteArrayInputStream(a2);
                    try {
                        objectInputStream2 = new ObjectInputStream(byteArrayInputStream2);
                    } catch (Exception e) {
                        e = e;
                        byteArrayInputStream3 = byteArrayInputStream2;
                        objectInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        autoCloseable = null;
                        if (byteArrayInputStream2 != null) {
                            try {
                                byteArrayInputStream2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (autoCloseable != null) {
                            try {
                                autoCloseable.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    objectInputStream = null;
                    byteArrayInputStream3 = null;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayInputStream2 = null;
                    autoCloseable = null;
                }
                try {
                    Object readObject = objectInputStream2.readObject();
                    try {
                        byteArrayInputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    try {
                        objectInputStream2.close();
                        return readObject;
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        return readObject;
                    }
                } catch (Exception e7) {
                    e = e7;
                    byteArrayInputStream3 = byteArrayInputStream2;
                    objectInputStream = objectInputStream2;
                    e.printStackTrace();
                    if (byteArrayInputStream3 != null) {
                        try {
                            byteArrayInputStream3.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                            return null;
                        } catch (IOException e9) {
                            e9.printStackTrace();
                            return null;
                        }
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable th4) {
            byteArrayInputStream2 = byteArrayInputStream;
            th = th4;
        }
    }

    public boolean c(String str) {
        C1028a c1028a = this.b;
        if (c1028a == null) {
            return false;
        }
        return c1028a.c(str);
    }
}
