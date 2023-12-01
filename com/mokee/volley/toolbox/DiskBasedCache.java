package com.mokee.volley.toolbox;

import com.mokee.volley.Cache;
import com.mokee.volley.VolleyError;
import com.mokee.volley.VolleyLog;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/DiskBasedCache.class */
public class DiskBasedCache implements Cache {
    private static final String[] e = null;
    private long a;
    private final File b;
    private final int c;
    private final Map<String, b> d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/DiskBasedCache$a.class */
    public static class a extends FilterInputStream {
        private int a;

        private a(InputStream inputStream) {
            super(inputStream);
            this.a = 0;
        }

        /* synthetic */ a(InputStream inputStream, a aVar) {
            this(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                try {
                    this.a++;
                } catch (IOException e) {
                    throw e;
                }
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                try {
                    this.a += read;
                } catch (IOException e) {
                    throw e;
                }
            }
            return read;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/DiskBasedCache$b.class */
    public static class b {
        private static final String a;
        public String etag;
        public String key;
        public Map<String, String> responseHeaders;
        public long serverDate;
        public long size;
        public long softTtl;
        public long ttl;

        /* JADX WARN: Code restructure failed: missing block: B:10:0x005c, code lost:
            r0 = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0061, code lost:
            r7 = r6;
            r11 = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0067, code lost:
            r10 = r11;
            r6 = r7;
            r5 = r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0071, code lost:
            if (r7 > r8) goto L3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0074, code lost:
            com.mokee.volley.toolbox.DiskBasedCache.b.a = new java.lang.String(r11).intern();
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0083, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0084, code lost:
            r5 = 'r';
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x008a, code lost:
            r5 = '*';
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0090, code lost:
            r5 = 16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0096, code lost:
            r5 = '-';
         */
        /* JADX WARN: Code restructure failed: missing block: B:3:0x0017, code lost:
            if (r6 <= 1) goto L3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:4:0x001a, code lost:
            r8 = r5;
            r0 = r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x001e, code lost:
            r7 = r0;
            r0 = r10;
            r0 = r0[r7];
         */
        /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:
            switch((r8 % 5)) {
                case 0: goto L12;
                case 1: goto L13;
                case 2: goto L14;
                case 3: goto L15;
                default: goto L6;
            };
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0048, code lost:
            r5 = 25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x004b, code lost:
            r0[r7] = (char) (r5 ^ r0);
            r8 = r8 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0059, code lost:
            if (r6 != 0) goto L10;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0071 -> B:4:0x001a). Please submit an issue!!! */
        static {
            /*
                java.lang.String r0 = "WY"
                char[] r0 = r0.toCharArray()
                r10 = r0
                r0 = r10
                int r0 = r0.length
                r6 = r0
                r0 = 0
                r8 = r0
                r0 = 0
                r5 = r0
                r0 = r10
                r11 = r0
                r0 = r6
                r7 = r0
                r0 = r6
                r1 = 1
                if (r0 > r1) goto L67
            L1a:
                r0 = r5
                r8 = r0
                r0 = r5
                r7 = r0
            L1e:
                r0 = r10
                r11 = r0
                r0 = r11
                r1 = r7
                char r0 = r0[r1]
                r9 = r0
                r0 = r8
                r1 = 5
                int r0 = r0 % r1
                switch(r0) {
                    case 0: goto L84;
                    case 1: goto L8a;
                    case 2: goto L90;
                    case 3: goto L96;
                    default: goto L48;
                }
            L48:
                r0 = 25
                r5 = r0
            L4b:
                r0 = r11
                r1 = r7
                r2 = r5
                r3 = r9
                r2 = r2 ^ r3
                char r2 = (char) r2
                r0[r1] = r2
                r0 = r8
                r1 = 1
                int r0 = r0 + r1
                r8 = r0
                r0 = r6
                if (r0 != 0) goto L61
                r0 = r6
                r7 = r0
                goto L1e
            L61:
                r0 = r6
                r7 = r0
                r0 = r10
                r11 = r0
            L67:
                r0 = r11
                r10 = r0
                r0 = r7
                r6 = r0
                r0 = r8
                r5 = r0
                r0 = r7
                r1 = r8
                if (r0 > r1) goto L1a
                java.lang.String r0 = new java.lang.String
                r1 = r0
                r2 = r11
                r1.<init>(r2)
                java.lang.String r0 = r0.intern()
                com.mokee.volley.toolbox.DiskBasedCache.b.a = r0
                return
            L84:
                r0 = 114(0x72, float:1.6E-43)
                r5 = r0
                goto L4b
            L8a:
                r0 = 42
                r5 = r0
                goto L4b
            L90:
                r0 = 16
                r5 = r0
                goto L4b
            L96:
                r0 = 45
                r5 = r0
                goto L4b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.toolbox.DiskBasedCache.b.m11290clinit():void");
        }

        private b() {
        }

        public b(String str, Cache.Entry entry) {
            this.key = str;
            this.size = entry.data.length;
            this.etag = entry.etag;
            this.serverDate = entry.serverDate;
            this.ttl = entry.ttl;
            this.softTtl = entry.softTtl;
            this.responseHeaders = entry.responseHeaders;
        }

        public static b readHeader(InputStream inputStream) throws IOException {
            b bVar = new b();
            if (DiskBasedCache.b(inputStream) != 538183203) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    throw e;
                }
            }
            try {
                bVar.key = DiskBasedCache.a(inputStream);
                bVar.etag = DiskBasedCache.a(inputStream);
                if (bVar.etag.equals("")) {
                    bVar.etag = null;
                }
                bVar.serverDate = DiskBasedCache.d(inputStream);
                bVar.ttl = DiskBasedCache.d(inputStream);
                bVar.softTtl = DiskBasedCache.d(inputStream);
                bVar.responseHeaders = DiskBasedCache.c(inputStream);
                return bVar;
            } catch (IOException e2) {
                throw e2;
            }
        }

        public Cache.Entry toCacheEntry(byte[] bArr) {
            Cache.Entry entry = new Cache.Entry();
            entry.data = bArr;
            entry.etag = this.etag;
            entry.serverDate = this.serverDate;
            entry.ttl = this.ttl;
            entry.softTtl = this.softTtl;
            entry.responseHeaders = this.responseHeaders;
            return entry;
        }

        public boolean writeHeader(OutputStream outputStream) {
            try {
                try {
                    DiskBasedCache.a(outputStream, 538183203);
                    DiskBasedCache.a(outputStream, this.key);
                    DiskBasedCache.a(outputStream, this.etag == null ? "" : this.etag);
                    DiskBasedCache.a(outputStream, this.serverDate);
                    DiskBasedCache.a(outputStream, this.ttl);
                    DiskBasedCache.a(outputStream, this.softTtl);
                    DiskBasedCache.a(this.responseHeaders, outputStream);
                    outputStream.flush();
                    return true;
                } catch (IOException e) {
                    throw e;
                }
            } catch (IOException e2) {
                VolleyLog.d(a, e2.toString());
                return false;
            }
        }
    }

    static {
        String[] strArr = new String[14];
        throw new VerifyError("bad dex opcode");
    }

    public DiskBasedCache(File file) {
        this(file, 5242880);
    }

    public DiskBasedCache(File file, int i) {
        this.d = new LinkedHashMap(16, 0.75f, true);
        this.a = 0L;
        this.b = file;
        this.c = i;
    }

    static String a(InputStream inputStream) throws IOException {
        return new String(a(inputStream, (int) d(inputStream)), e[4]);
    }

    private String a(String str) {
        int length = str.length() / 2;
        return String.valueOf(String.valueOf(str.substring(0, length).hashCode())) + String.valueOf(str.substring(length).hashCode());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004d, code lost:
        r0 = r0.next().getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x006d, code lost:
        if (getFileForKey(r0.key).delete() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0070, code lost:
        r9.a -= r0.size;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0080, code lost:
        if (r0 == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0083, code lost:
        com.mokee.volley.VolleyLog.d(com.mokee.volley.toolbox.DiskBasedCache.e[7], r0.key, a(r0.key));
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00a4, code lost:
        r0.remove();
        r0 = r12 + 1;
        r11 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00c2, code lost:
        if (((float) (r9.a + r10)) >= (r9.c * 0.9f)) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00c5, code lost:
        r11 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00c9, code lost:
        if (r0 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00cc, code lost:
        r11 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ce, code lost:
        r12 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00d7, code lost:
        if (r0.hasNext() != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00dd, code lost:
        if (com.mokee.volley.VolleyLog.DEBUG == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00e0, code lost:
        com.mokee.volley.VolleyLog.v(com.mokee.volley.toolbox.DiskBasedCache.e[5], java.lang.Integer.valueOf(r11), java.lang.Long.valueOf(r9.a - r0), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime() - r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x010c, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004a, code lost:
        if (r0 != false) goto L10;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00d7 -> B:10:0x004d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r10) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.toolbox.DiskBasedCache.a(int):void");
    }

    static void a(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static void a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes(e[11]);
        a(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (com.mokee.volley.toolbox.ImageLoader.h != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r7, com.mokee.volley.toolbox.DiskBasedCache.b r8) {
        /*
            r6 = this;
            r0 = r6
            java.util.Map<java.lang.String, com.mokee.volley.toolbox.DiskBasedCache$b> r0 = r0.d
            r1 = r7
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L20
            r0 = r6
            r1 = r6
            long r1 = r1.a
            r2 = r8
            long r2 = r2.size
            long r1 = r1 + r2
            r0.a = r1
            boolean r0 = com.mokee.volley.toolbox.ImageLoader.h
            if (r0 == 0) goto L44
        L20:
            r0 = r6
            java.util.Map<java.lang.String, com.mokee.volley.toolbox.DiskBasedCache$b> r0 = r0.d
            r1 = r7
            java.lang.Object r0 = r0.get(r1)
            com.mokee.volley.toolbox.DiskBasedCache$b r0 = (com.mokee.volley.toolbox.DiskBasedCache.b) r0
            r11 = r0
            r0 = r6
            long r0 = r0.a
            r9 = r0
            r0 = r6
            r1 = r8
            long r1 = r1.size
            r2 = r11
            long r2 = r2.size
            long r1 = r1 - r2
            r2 = r9
            long r1 = r1 + r2
            r0.a = r1
        L44:
            r0 = r6
            java.util.Map<java.lang.String, com.mokee.volley.toolbox.DiskBasedCache$b> r0 = r0.d
            r1 = r7
            r2 = r8
            java.lang.Object r0 = r0.put(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.toolbox.DiskBasedCache.a(java.lang.String, com.mokee.volley.toolbox.DiskBasedCache$b):void");
    }

    static void a(Map<String, String> map, OutputStream outputStream) throws IOException {
        boolean z = ImageLoader.h;
        if (map != null) {
            a(outputStream, map.size());
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            if (z) {
                Map.Entry<String, String> next = it.next();
                a(outputStream, next.getKey());
                a(outputStream, next.getValue());
            }
            while (it.hasNext()) {
                Map.Entry<String, String> next2 = it.next();
                a(outputStream, next2.getKey());
                a(outputStream, next2.getValue());
            }
            if (!z) {
                return;
            }
        }
        try {
            a(outputStream, 0);
        } catch (IOException e2) {
            throw e2;
        }
    }

    private static byte[] a(InputStream inputStream, int i) throws IOException {
        int read;
        int i2 = 0;
        byte[] bArr = new byte[i];
        while (i2 < i && (read = inputStream.read(bArr, i2, i - i2)) != -1) {
            i2 += read;
        }
        if (i2 != i) {
            try {
                throw new IOException(e[1] + i + e[0] + i2 + e[2]);
            } catch (IOException e2) {
                throw e2;
            }
        }
        return bArr;
    }

    static int b(InputStream inputStream) throws IOException {
        return 0 | (e(inputStream) << 0) | (e(inputStream) << 8) | (e(inputStream) << 16) | (e(inputStream) << 24);
    }

    private void b(String str) {
        b bVar = this.d.get(str);
        if (bVar != null) {
            this.a -= bVar.size;
            this.d.remove(str);
        }
    }

    static Map<String, String> c(InputStream inputStream) throws IOException {
        HashMap emptyMap;
        boolean z = ImageLoader.h;
        int b2 = b(inputStream);
        if (b2 == 0) {
            try {
                emptyMap = Collections.emptyMap();
            } catch (IOException e2) {
                throw e2;
            }
        } else {
            emptyMap = new HashMap(b2);
        }
        int i = 0;
        Map<String, String> map = emptyMap;
        if (z) {
            emptyMap.put(a(inputStream).intern(), a(inputStream).intern());
            i = 0 + 1;
            map = emptyMap;
        }
        while (true) {
            int i2 = i;
            Map<String, String> map2 = map;
            if (i >= b2) {
                return map;
            }
            map2.put(a(inputStream).intern(), a(inputStream).intern());
            i = i2 + 1;
            map = map2;
        }
    }

    static long d(InputStream inputStream) throws IOException {
        boolean z = false;
        boolean z2 = ImageLoader.h;
        long e2 = e(inputStream);
        long e3 = e(inputStream);
        long e4 = e(inputStream);
        long e5 = e(inputStream);
        long e6 = e(inputStream);
        long e7 = e(inputStream);
        long e8 = e(inputStream);
        long e9 = e(inputStream);
        try {
            if (VolleyError.b) {
                if (!z2) {
                    z = true;
                }
                ImageLoader.h = z;
            }
            return 0 | ((e2 & 255) << 0) | ((e3 & 255) << 8) | ((e4 & 255) << 16) | ((e5 & 255) << 24) | ((e6 & 255) << 32) | ((e7 & 255) << 40) | ((e8 & 255) << 48) | ((e9 & 255) << 56);
        } catch (IOException e10) {
            try {
                throw e10;
            } catch (IOException e11) {
                throw e11;
            }
        }
    }

    private static int e(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read == -1) {
            try {
                throw new EOFException();
            } catch (IOException e2) {
                throw e2;
            }
        }
        return read;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
        r6 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
        if (r5 < r0) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (r0 != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
        r0[r6].delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002b, code lost:
        r5 = r6 + 1;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005a -> B:8:0x0022). Please submit an issue!!! */
    @Override // com.mokee.volley.Cache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void clear() {
        /*
            r4 = this;
            r0 = 0
            r5 = r0
            r0 = 0
            r6 = r0
            r0 = r4
            monitor-enter(r0)
            boolean r0 = com.mokee.volley.toolbox.ImageLoader.h     // Catch: java.lang.Throwable -> L4f
            r8 = r0
            r0 = r4
            java.io.File r0 = r0.b     // Catch: java.lang.Throwable -> L4f
            java.io.File[] r0 = r0.listFiles()     // Catch: java.lang.Throwable -> L4f
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L31
            r0 = r9
            int r0 = r0.length     // Catch: java.lang.Throwable -> L4f
            r7 = r0
            r0 = r8
            if (r0 == 0) goto L56
        L22:
            r0 = r9
            r1 = r6
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L4f
            boolean r0 = r0.delete()     // Catch: java.lang.Throwable -> L4f
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L56
        L31:
            r0 = r4
            java.util.Map<java.lang.String, com.mokee.volley.toolbox.DiskBasedCache$b> r0 = r0.d     // Catch: java.lang.Throwable -> L4f
            r0.clear()     // Catch: java.lang.Throwable -> L4f
            r0 = r4
            r1 = 0
            r0.a = r1     // Catch: java.lang.Throwable -> L4f
            java.lang.String[] r0 = com.mokee.volley.toolbox.DiskBasedCache.e     // Catch: java.lang.Throwable -> L4f
            r1 = 13
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L4f
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L4f
            com.mokee.volley.VolleyLog.d(r0, r1)     // Catch: java.lang.Throwable -> L4f
            r0 = r4
            monitor-exit(r0)
            return
        L4f:
            r9 = move-exception
            r0 = r4
            monitor-exit(r0)
            r0 = r9
            throw r0
        L56:
            r0 = r5
            r6 = r0
            r0 = r5
            r1 = r7
            if (r0 < r1) goto L22
            goto L31
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.toolbox.DiskBasedCache.clear():void");
    }

    @Override // com.mokee.volley.Cache
    public Cache.Entry get(String str) {
        a aVar;
        Cache.Entry entry;
        a aVar2;
        synchronized (this) {
            b bVar = this.d.get(str);
            if (bVar == null) {
                entry = null;
            } else {
                try {
                    File fileForKey = getFileForKey(str);
                    try {
                        aVar2 = new a(new FileInputStream(fileForKey), null);
                    } catch (IOException e2) {
                        e = e2;
                        aVar2 = null;
                    } catch (Throwable th) {
                        th = th;
                        aVar = null;
                        if (aVar != null) {
                            try {
                                aVar.close();
                            } catch (IOException e3) {
                                entry = null;
                            }
                        }
                        throw th;
                    }
                    try {
                        b.readHeader(aVar2);
                        aVar = bVar.toCacheEntry(a(aVar2, (int) (fileForKey.length() - aVar2.a)));
                        entry = aVar;
                        if (aVar2 != 0) {
                            try {
                                aVar2.close();
                                entry = aVar;
                            } catch (IOException e4) {
                                entry = null;
                            }
                        }
                    } catch (IOException e5) {
                        e = e5;
                        VolleyLog.d(e[12], fileForKey.getAbsolutePath(), e.toString());
                        aVar = aVar2;
                        remove(str);
                        if (aVar2 != null) {
                            try {
                                aVar2.close();
                            } catch (IOException e6) {
                                entry = null;
                            }
                        }
                        entry = null;
                        return entry;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return entry;
    }

    public File getFileForKey(String str) {
        return new File(this.b, a(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
        if (r0 != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0064, code lost:
        r0 = r0[r8];
        r14 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
        r13 = new java.io.FileInputStream(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
        r12 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
        r0 = com.mokee.volley.toolbox.DiskBasedCache.b.readHeader(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0087, code lost:
        r0.size = r0.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0095, code lost:
        a(r0.key, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a2, code lost:
        if (r13 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a5, code lost:
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ab, code lost:
        r7 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ae, code lost:
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b2, code lost:
        if (r7 < r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ba, code lost:
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00bf, code lost:
        if (r0 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c2, code lost:
        r12 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c6, code lost:
        r0.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ce, code lost:
        if (r13 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d1, code lost:
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00de, code lost:
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e0, code lost:
        r12 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e6, code lost:
        throw r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00e7, code lost:
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00e9, code lost:
        r14 = r12;
        r12 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f3, code lost:
        if (r14 != null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00f6, code lost:
        r14.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00fd, code lost:
        throw r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0108, code lost:
        r12 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00b2 -> B:29:0x0064). Please submit an issue!!! */
    @Override // com.mokee.volley.Cache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void initialize() {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.toolbox.DiskBasedCache.initialize():void");
    }

    @Override // com.mokee.volley.Cache
    public void invalidate(String str, boolean z) {
        synchronized (this) {
            Cache.Entry entry = get(str);
            if (entry != null) {
                entry.softTtl = 0L;
                if (z) {
                    entry.ttl = 0L;
                }
                put(str, entry);
            }
        }
    }

    @Override // com.mokee.volley.Cache
    public void put(String str, Cache.Entry entry) {
        FileOutputStream fileOutputStream;
        b bVar;
        synchronized (this) {
            a(entry.data.length);
            File fileForKey = getFileForKey(str);
            try {
                fileOutputStream = new FileOutputStream(fileForKey);
                bVar = new b(str, entry);
            } catch (IOException e2) {
                if (!fileForKey.delete()) {
                    try {
                        VolleyLog.d(e[10], fileForKey.getAbsolutePath());
                    } catch (IOException e3) {
                        throw e3;
                    }
                }
            }
            if (!bVar.writeHeader(fileOutputStream)) {
                try {
                    fileOutputStream.close();
                    VolleyLog.d(e[9], fileForKey.getAbsolutePath());
                    throw new IOException();
                } catch (IOException e4) {
                    throw e4;
                }
            }
            fileOutputStream.write(entry.data);
            fileOutputStream.close();
            a(str, bVar);
        }
    }

    @Override // com.mokee.volley.Cache
    public void remove(String str) {
        synchronized (this) {
            boolean delete = getFileForKey(str).delete();
            b(str);
            if (!delete) {
                VolleyLog.d(e[8], str, a(str));
            }
        }
    }
}
