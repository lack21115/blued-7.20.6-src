package com.sobot.chat.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/SobotCache.class */
public class SobotCache {
    private static final int MAX_COUNT = Integer.MAX_VALUE;
    private static final int MAX_SIZE = 50000000;
    public static final int TIME_DAY = 86400;
    public static final int TIME_HOUR = 3600;
    private static Map<String, SobotCache> mInstanceMap = new HashMap();
    private ACacheManager mCache;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/SobotCache$ACacheManager.class */
    public class ACacheManager {
        private final AtomicInteger cacheCount;
        protected File cacheDir;
        private final AtomicLong cacheSize;
        private final int countLimit;
        private final Map<File, Long> lastUsageDates;
        private final long sizeLimit;

        private ACacheManager(File file, long j, int i) {
            this.lastUsageDates = Collections.synchronizedMap(new HashMap());
            this.cacheDir = file;
            this.sizeLimit = j;
            this.countLimit = i;
            this.cacheSize = new AtomicLong();
            this.cacheCount = new AtomicInteger();
            calculateCacheSizeAndCacheCount();
        }

        private void calculateCacheSizeAndCacheCount() {
            new Thread(new Runnable() { // from class: com.sobot.chat.utils.SobotCache.ACacheManager.1
                @Override // java.lang.Runnable
                public void run() {
                    File[] listFiles = ACacheManager.this.cacheDir.listFiles();
                    if (listFiles != null) {
                        int i = 0;
                        int i2 = 0;
                        for (File file : listFiles) {
                            i = (int) (i + ACacheManager.this.calculateSize(file));
                            i2++;
                            ACacheManager.this.lastUsageDates.put(file, Long.valueOf(file.lastModified()));
                        }
                        ACacheManager.this.cacheSize.set(i);
                        ACacheManager.this.cacheCount.set(i2);
                    }
                }
            }).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long calculateSize(File file) {
            return file.length();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.lastUsageDates.clear();
            this.cacheSize.set(0L);
            File[] listFiles = this.cacheDir.listFiles();
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
                listFiles[i2].delete();
                i = i2 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public File get(String str) {
            File newFile = newFile(str);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            newFile.setLastModified(valueOf.longValue());
            this.lastUsageDates.put(newFile, valueOf);
            return newFile;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public File newFile(String str) {
            if (!this.cacheDir.exists()) {
                this.cacheDir.mkdirs();
            }
            File file = this.cacheDir;
            return new File(file, str.hashCode() + "");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void put(File file) {
            int i = this.cacheCount.get();
            while (i + 1 > this.countLimit) {
                this.cacheSize.addAndGet(-removeNext());
                i = this.cacheCount.addAndGet(-1);
            }
            this.cacheCount.addAndGet(1);
            long calculateSize = calculateSize(file);
            long j = this.cacheSize.get();
            while (j + calculateSize > this.sizeLimit) {
                j = this.cacheSize.addAndGet(-removeNext());
            }
            this.cacheSize.addAndGet(calculateSize);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(valueOf.longValue());
            this.lastUsageDates.put(file, valueOf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean remove(String str) {
            return get(str).delete();
        }

        private long removeNext() {
            File file;
            if (this.lastUsageDates.isEmpty()) {
                return 0L;
            }
            Set<Map.Entry<File, Long>> entrySet = this.lastUsageDates.entrySet();
            synchronized (this.lastUsageDates) {
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
            long calculateSize = calculateSize(file);
            if (file.delete()) {
                this.lastUsageDates.remove(file);
            }
            return calculateSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/SobotCache$Utils.class */
    public static class Utils {
        private static final char mSeparator = ' ';

        private Utils() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] Bitmap2Bytes(Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Bitmap Bytes2Bimap(byte[] bArr) {
            if (bArr.length == 0) {
                return null;
            }
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Drawable bitmap2Drawable(Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            return new BitmapDrawable(bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String clearDateInfo(String str) {
            String str2 = str;
            if (str != null) {
                str2 = str;
                if (hasDateInfo(str.getBytes())) {
                    str2 = str.substring(str.indexOf(32) + 1, str.length());
                }
            }
            return str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] clearDateInfo(byte[] bArr) {
            byte[] bArr2 = bArr;
            if (hasDateInfo(bArr)) {
                bArr2 = copyOfRange(bArr, indexOf(bArr, ' ') + 1, bArr.length);
            }
            return bArr2;
        }

        private static byte[] copyOfRange(byte[] bArr, int i, int i2) {
            int i3 = i2 - i;
            if (i3 >= 0) {
                byte[] bArr2 = new byte[i3];
                System.arraycopy((Object) bArr, i, (Object) bArr2, 0, Math.min(bArr.length - i, i3));
                return bArr2;
            }
            throw new IllegalArgumentException(i + " > " + i2);
        }

        private static String createDateInfo(int i) {
            String str = System.currentTimeMillis() + "";
            while (true) {
                String str2 = str;
                if (str2.length() >= 13) {
                    return str2 + "-" + i + ' ';
                }
                str = "0" + str2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Bitmap drawable2Bitmap(Drawable drawable) {
            if (drawable == null) {
                return null;
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        }

        private static String[] getDateInfoFromDate(byte[] bArr) {
            if (hasDateInfo(bArr)) {
                return new String[]{new String(copyOfRange(bArr, 0, 13)), new String(copyOfRange(bArr, 14, indexOf(bArr, ' ')))};
            }
            return null;
        }

        private static boolean hasDateInfo(byte[] bArr) {
            return bArr != null && bArr.length > 15 && bArr[13] == 45 && indexOf(bArr, ' ') > 14;
        }

        private static int indexOf(byte[] bArr, char c2) {
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

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isDue(String str) {
            return isDue(str.getBytes());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isDue(byte[] bArr) {
            String str;
            String[] dateInfoFromDate = getDateInfoFromDate(bArr);
            if (dateInfoFromDate == null || dateInfoFromDate.length != 2) {
                return false;
            }
            String str2 = dateInfoFromDate[0];
            while (true) {
                str = str2;
                if (!str.startsWith("0")) {
                    break;
                }
                str2 = str.substring(1, str.length());
            }
            return System.currentTimeMillis() > Long.valueOf(str).longValue() + (Long.valueOf(dateInfoFromDate[1]).longValue() * 1000);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] newByteArrayWithDateInfo(int i, byte[] bArr) {
            byte[] bytes = createDateInfo(i).getBytes();
            byte[] bArr2 = new byte[bytes.length + bArr.length];
            System.arraycopy((Object) bytes, 0, (Object) bArr2, 0, bytes.length);
            System.arraycopy((Object) bArr, 0, (Object) bArr2, bytes.length, bArr.length);
            return bArr2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String newStringWithDateInfo(int i, String str) {
            return createDateInfo(i) + str;
        }
    }

    private SobotCache(File file, long j, int i) {
        if (!file.exists()) {
            file.mkdirs();
        }
        this.mCache = new ACacheManager(file, j, i);
    }

    public static SobotCache get(Context context) {
        return get(context, context.getPackageName() + "_sobotCache");
    }

    public static SobotCache get(Context context, long j, int i) {
        File cacheDir = context.getCacheDir();
        return get(new File(cacheDir, context.getPackageName() + "_sobotCache"), j, i);
    }

    public static SobotCache get(Context context, String str) {
        return get(new File(context.getCacheDir(), str), 50000000L, Integer.MAX_VALUE);
    }

    public static SobotCache get(File file) {
        return get(file, 50000000L, Integer.MAX_VALUE);
    }

    public static SobotCache get(File file, long j, int i) {
        Map<String, SobotCache> map = mInstanceMap;
        SobotCache sobotCache = map.get(file.getAbsoluteFile() + myPid());
        SobotCache sobotCache2 = sobotCache;
        if (sobotCache == null) {
            sobotCache2 = new SobotCache(file, j, i);
            Map<String, SobotCache> map2 = mInstanceMap;
            map2.put(file.getAbsolutePath() + myPid(), sobotCache2);
        }
        return sobotCache2;
    }

    private static String myPid() {
        return BridgeUtil.UNDERLINE_STR + Process.myPid();
    }

    public void clear() {
        this.mCache.clear();
    }

    public File file(String str) {
        File newFile = this.mCache.newFile(str);
        if (newFile.exists()) {
            return newFile;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] getAsBinary(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            r7 = r0
            r0 = r5
            com.sobot.chat.utils.SobotCache$ACacheManager r0 = r0.mCache     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
            r1 = r6
            java.io.File r0 = com.sobot.chat.utils.SobotCache.ACacheManager.access$400(r0, r1)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
            r8 = r0
            r0 = r8
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
            if (r0 != 0) goto L14
            r0 = 0
            return r0
        L14:
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
            r1 = r0
            r2 = r8
            java.lang.String r3 = "r"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
            r8 = r0
            r0 = r8
            r7 = r0
            r0 = r8
            long r0 = r0.length()     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L8c
            int r0 = (int) r0     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L8c
            byte[] r0 = new byte[r0]     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L8c
            r9 = r0
            r0 = r8
            r7 = r0
            r0 = r8
            r1 = r9
            int r0 = r0.read(r1)     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L8c
            r0 = r8
            r7 = r0
            r0 = r9
            boolean r0 = com.sobot.chat.utils.SobotCache.Utils.access$800(r0)     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L8c
            if (r0 != 0) goto L52
            r0 = r8
            r7 = r0
            r0 = r9
            byte[] r0 = com.sobot.chat.utils.SobotCache.Utils.access$900(r0)     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L8c
            r6 = r0
            r0 = r8
            r0.close()     // Catch: java.io.IOException -> L4b
            r0 = r6
            return r0
        L4b:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
            r0 = r6
            return r0
        L52:
            r0 = r8
            r0.close()     // Catch: java.io.IOException -> L59
            goto L5e
        L59:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
        L5e:
            r0 = r5
            r1 = r6
            boolean r0 = r0.remove(r1)
            r0 = 0
            return r0
        L66:
            r7 = move-exception
            r0 = r8
            r6 = r0
            r0 = r7
            r8 = r0
            goto L75
        L6e:
            r6 = move-exception
            goto L8d
        L72:
            r8 = move-exception
            r0 = 0
            r6 = r0
        L75:
            r0 = r6
            r7 = r0
            r0 = r8
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L8c
            r0 = r6
            if (r0 == 0) goto L8a
            r0 = r6
            r0.close()     // Catch: java.io.IOException -> L85
            r0 = 0
            return r0
        L85:
            r6 = move-exception
            r0 = r6
            r0.printStackTrace()
        L8a:
            r0 = 0
            return r0
        L8c:
            r6 = move-exception
        L8d:
            r0 = r7
            if (r0 == 0) goto L9d
            r0 = r7
            r0.close()     // Catch: java.io.IOException -> L98
            goto L9d
        L98:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
        L9d:
            r0 = r6
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.utils.SobotCache.getAsBinary(java.lang.String):byte[]");
    }

    public Bitmap getAsBitmap(String str) {
        if (getAsBinary(str) == null) {
            return null;
        }
        return Utils.Bytes2Bimap(getAsBinary(str));
    }

    public Drawable getAsDrawable(String str) {
        if (getAsBinary(str) == null) {
            return null;
        }
        return Utils.bitmap2Drawable(Utils.Bytes2Bimap(getAsBinary(str)));
    }

    public JSONArray getAsJSONArray(String str) {
        try {
            return new JSONArray(getAsString(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject getAsJSONObject(String str) {
        try {
            return new JSONObject(getAsString(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x009a: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:43:0x009a */
    public Object getAsObject(String str) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2;
        Throwable th;
        AutoCloseable autoCloseable;
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream3;
        ObjectInputStream objectInputStream2;
        byte[] asBinary = getAsBinary(str);
        try {
            if (asBinary != null) {
                try {
                    byteArrayInputStream2 = new ByteArrayInputStream(asBinary);
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

    /* JADX WARN: Removed duplicated region for block: B:59:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getAsString(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.utils.SobotCache.getAsString(java.lang.String):java.lang.String");
    }

    public void put(String str, Bitmap bitmap) {
        put(str, Utils.Bitmap2Bytes(bitmap));
    }

    public void put(String str, Bitmap bitmap, int i) {
        put(str, Utils.Bitmap2Bytes(bitmap), i);
    }

    public void put(String str, Drawable drawable) {
        put(str, Utils.drawable2Bitmap(drawable));
    }

    public void put(String str, Drawable drawable, int i) {
        put(str, Utils.drawable2Bitmap(drawable), i);
    }

    public void put(String str, Serializable serializable) {
        put(str, serializable, -1);
    }

    public void put(String str, Serializable serializable, int i) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream3.writeObject(serializable);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (i != -1) {
                            put(str, byteArray, i);
                        } else {
                            put(str, byteArray);
                        }
                        objectOutputStream3.close();
                    } catch (Exception e) {
                        e = e;
                        objectOutputStream = objectOutputStream3;
                        objectOutputStream2 = objectOutputStream;
                        e.printStackTrace();
                        objectOutputStream.close();
                    } catch (Throwable th) {
                        th = th;
                        objectOutputStream2 = objectOutputStream3;
                        try {
                            objectOutputStream2.close();
                        } catch (IOException e2) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
                objectOutputStream = null;
            }
        } catch (IOException e4) {
        }
    }

    public void put(String str, String str2) {
        BufferedWriter bufferedWriter;
        File newFile = this.mCache.newFile(str);
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                BufferedWriter bufferedWriter3 = new BufferedWriter(new FileWriter(newFile), 1024);
                try {
                    bufferedWriter3.write(str2);
                } catch (IOException e) {
                    bufferedWriter = bufferedWriter3;
                    e = e;
                    bufferedWriter2 = bufferedWriter;
                    e.printStackTrace();
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.flush();
                            bufferedWriter.close();
                        } catch (IOException e2) {
                            e = e2;
                            e.printStackTrace();
                            this.mCache.put(newFile);
                        }
                    }
                    this.mCache.put(newFile);
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter2 = bufferedWriter3;
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.flush();
                            bufferedWriter2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    this.mCache.put(newFile);
                    throw th;
                }
                try {
                    bufferedWriter3.flush();
                    bufferedWriter3.close();
                } catch (IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    this.mCache.put(newFile);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedWriter = null;
        }
        this.mCache.put(newFile);
    }

    public void put(String str, String str2, int i) {
        put(str, Utils.newStringWithDateInfo(i, str2));
    }

    public void put(String str, JSONArray jSONArray) {
        put(str, jSONArray.toString());
    }

    public void put(String str, JSONArray jSONArray, int i) {
        put(str, jSONArray.toString(), i);
    }

    public void put(String str, JSONObject jSONObject) {
        put(str, jSONObject.toString());
    }

    public void put(String str, JSONObject jSONObject, int i) {
        put(str, jSONObject.toString(), i);
    }

    public void put(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        File newFile = this.mCache.newFile(str);
        FileOutputStream fileOutputStream3 = null;
        try {
            try {
                fileOutputStream2 = new FileOutputStream(newFile);
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
                            this.mCache.put(newFile);
                        }
                    }
                    this.mCache.put(newFile);
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
                    this.mCache.put(newFile);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
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
            this.mCache.put(newFile);
        }
        this.mCache.put(newFile);
    }

    public void put(String str, byte[] bArr, int i) {
        put(str, Utils.newByteArrayWithDateInfo(i, bArr));
    }

    public boolean remove(String str) {
        return this.mCache.remove(str);
    }
}
