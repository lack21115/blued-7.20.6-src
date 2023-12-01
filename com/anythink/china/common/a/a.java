package com.anythink.china.common.a;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/common/a/a.class */
public abstract class a {
    public static final String e = ".temp";
    public static final String f = ".log";
    public static final String g = ".apk";
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 3;
    public static final int l = 4;
    private static final String u = a.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    protected String f6292a;
    protected String b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f6293c;
    protected boolean d;
    public int m = 0;
    protected long n;
    protected long o;
    protected long p;
    protected long q;
    protected long r;
    protected long s;
    protected long t;
    private InterfaceC0088a v;
    private e w;
    private String x;

    /* renamed from: com.anythink.china.common.a.a$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/china/common/a/a$1.class */
    final class AnonymousClass1 extends com.anythink.core.common.k.b.b {
        AnonymousClass1() {
        }

        private void b(String str) {
            HttpURLConnection httpURLConnection;
            HttpURLConnection httpURLConnection2;
            HttpURLConnection httpURLConnection3;
            HttpURLConnection httpURLConnection4;
            HttpURLConnection httpURLConnection5;
            HttpURLConnection httpURLConnection6;
            String str2 = "Http connect error!";
            a.this.o = System.currentTimeMillis();
            a.this.p = SystemClock.elapsedRealtime();
            HttpURLConnection httpURLConnection7 = null;
            try {
                try {
                    String unused = a.u;
                    HttpURLConnection httpURLConnection8 = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        httpURLConnection8.setInstanceFollowRedirects(false);
                        if (a.this.w.o) {
                            String i = com.anythink.core.common.k.d.i();
                            if (!TextUtils.isEmpty(i)) {
                                httpURLConnection8.addRequestProperty("User-Agent", i);
                            }
                        }
                        if (a.this.n > 0) {
                            String unused2 = a.u;
                            StringBuilder sb = new StringBuilder("Range: startPos -> ");
                            sb.append(a.this.n);
                            sb.append("  ,  endPos -> ");
                            sb.append(a.this.s);
                            httpURLConnection8.setRequestProperty("Range", "bytes=" + a.this.n + "-");
                        } else {
                            a.this.s = httpURLConnection8.getContentLength();
                        }
                        if (a.this.s <= 0) {
                            String unused3 = a.u;
                            a.this.a(c.a("10000", "downloadSize <= 0"));
                            if (httpURLConnection8 != null) {
                                httpURLConnection8.disconnect();
                            }
                        } else if (a.this.f6293c) {
                            if (a.this.w != null) {
                                a.this.w.j();
                            }
                            a.this.m = 3;
                            a.this.d();
                            if (httpURLConnection8 != null) {
                                httpURLConnection8.disconnect();
                            }
                        } else {
                            httpURLConnection8.setConnectTimeout(60000);
                            httpURLConnection8.connect();
                            int responseCode = httpURLConnection8.getResponseCode();
                            if (responseCode != 200 && responseCode != 206) {
                                String unused4 = a.u;
                                StringBuilder sb2 = new StringBuilder("http respond status code is ");
                                sb2.append(responseCode);
                                sb2.append(" ! url=");
                                sb2.append(str);
                                a.this.a(c.a("10001", httpURLConnection8.getResponseMessage()));
                                if (httpURLConnection8 != null) {
                                    httpURLConnection8.disconnect();
                                }
                            } else if (a.this.f6293c) {
                                if (a.this.w != null) {
                                    a.this.w.j();
                                }
                                a.this.m = 3;
                                a.this.d();
                                if (httpURLConnection8 != null) {
                                    httpURLConnection8.disconnect();
                                }
                            } else {
                                InputStream inputStream = httpURLConnection8.getInputStream();
                                if (a.this.w != null) {
                                    a.this.w.i();
                                }
                                a.this.w.h = a.this.s;
                                if (a.this.v != null) {
                                    a.this.v.a(a.this.w, a.this.n, a.this.s);
                                }
                                int a2 = a.this.a(a.this.b, inputStream);
                                a.this.m = a2;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                a.this.q = System.currentTimeMillis();
                                a.this.r = SystemClock.elapsedRealtime();
                                a.this.w.i = a.this.r - a.this.p;
                                if (a2 == 1) {
                                    String unused5 = a.u;
                                    new StringBuilder("download success --> ").append(a.this.f6292a);
                                    a.this.e();
                                } else if (a2 == 2 || a2 == 3) {
                                    a.this.d();
                                } else {
                                    String unused6 = a.u;
                                    new StringBuilder("download fail --> ").append(a.this.f6292a);
                                    a.this.b(c.a("10000", "Save fail!(" + a.this.x + ")"));
                                }
                                if (httpURLConnection8 != null) {
                                    httpURLConnection8.disconnect();
                                }
                            }
                        }
                    } catch (Exception e) {
                        httpURLConnection3 = httpURLConnection8;
                        e = e;
                        String unused7 = a.u;
                        HttpURLConnection httpURLConnection9 = httpURLConnection3;
                        e.getMessage();
                        HttpURLConnection httpURLConnection10 = httpURLConnection3;
                        if (e.getMessage() != null) {
                            HttpURLConnection httpURLConnection11 = httpURLConnection3;
                            str2 = e.getMessage();
                        }
                        HttpURLConnection httpURLConnection12 = httpURLConnection3;
                        a.this.a(c.a("10000", str2));
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                    } catch (OutOfMemoryError e2) {
                        httpURLConnection2 = httpURLConnection8;
                        e = e2;
                        System.gc();
                        HttpURLConnection httpURLConnection13 = httpURLConnection2;
                        String unused8 = a.u;
                        HttpURLConnection httpURLConnection14 = httpURLConnection2;
                        e.getMessage();
                        HttpURLConnection httpURLConnection15 = httpURLConnection2;
                        if (e.getMessage() != null) {
                            HttpURLConnection httpURLConnection16 = httpURLConnection2;
                            str2 = e.getMessage();
                        }
                        HttpURLConnection httpURLConnection17 = httpURLConnection2;
                        a.this.a(c.a("10000", str2));
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    } catch (StackOverflowError e3) {
                        httpURLConnection = httpURLConnection8;
                        e = e3;
                        System.gc();
                        HttpURLConnection httpURLConnection18 = httpURLConnection;
                        String unused9 = a.u;
                        HttpURLConnection httpURLConnection19 = httpURLConnection;
                        e.getMessage();
                        HttpURLConnection httpURLConnection20 = httpURLConnection;
                        if (e.getMessage() != null) {
                            HttpURLConnection httpURLConnection21 = httpURLConnection;
                            str2 = e.getMessage();
                        }
                        HttpURLConnection httpURLConnection22 = httpURLConnection;
                        a.this.a(c.a("10000", str2));
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Error e4) {
                        httpURLConnection6 = httpURLConnection8;
                        e = e4;
                        System.gc();
                        HttpURLConnection httpURLConnection23 = httpURLConnection6;
                        String unused10 = a.u;
                        HttpURLConnection httpURLConnection24 = httpURLConnection6;
                        e.getMessage();
                        HttpURLConnection httpURLConnection25 = httpURLConnection6;
                        if (e.getMessage() != null) {
                            HttpURLConnection httpURLConnection26 = httpURLConnection6;
                            str2 = e.getMessage();
                        }
                        HttpURLConnection httpURLConnection27 = httpURLConnection6;
                        a.this.a(c.a("10000", str2));
                        if (httpURLConnection6 != null) {
                            httpURLConnection6.disconnect();
                        }
                    } catch (SocketTimeoutException e5) {
                        httpURLConnection5 = httpURLConnection8;
                        e = e5;
                        a.this.a(c.a("20001", e.getMessage()));
                        HttpURLConnection httpURLConnection28 = httpURLConnection5;
                        String unused11 = a.u;
                        if (httpURLConnection5 != null) {
                            httpURLConnection5.disconnect();
                        }
                    } catch (ConnectTimeoutException e6) {
                        httpURLConnection4 = httpURLConnection8;
                        e = e6;
                        a.this.a(e);
                        if (httpURLConnection4 != null) {
                            httpURLConnection4.disconnect();
                        }
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection7 = httpURLConnection8;
                        if (httpURLConnection7 != null) {
                            httpURLConnection7.disconnect();
                        }
                        throw th;
                    }
                } catch (Error e7) {
                    e = e7;
                    httpURLConnection6 = null;
                } catch (SocketTimeoutException e8) {
                    e = e8;
                    httpURLConnection5 = null;
                } catch (ConnectTimeoutException e9) {
                    e = e9;
                    httpURLConnection4 = null;
                } catch (Exception e10) {
                    e = e10;
                    httpURLConnection3 = null;
                } catch (OutOfMemoryError e11) {
                    e = e11;
                    httpURLConnection2 = null;
                } catch (StackOverflowError e12) {
                    e = e12;
                    httpURLConnection = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:203:0x04e8  */
        @Override // com.anythink.core.common.k.b.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a() {
            /*
                Method dump skipped, instructions count: 1306
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.china.common.a.a.AnonymousClass1.a():void");
        }
    }

    /* renamed from: com.anythink.china.common.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/china/common/a/a$a.class */
    public interface InterfaceC0088a {
        void a(e eVar, long j);

        void a(e eVar, long j, long j2);

        void a(e eVar, long j, long j2, int i);

        void a(e eVar, String str);

        void b(e eVar, long j, long j2);
    }

    public a(e eVar) {
        this.w = eVar;
        this.f6292a = eVar.b;
        this.b = eVar.n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, InputStream inputStream) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        Throwable th;
        String a2 = com.anythink.china.common.c.b.a(str);
        if (TextUtils.isEmpty(a2)) {
            return 4;
        }
        File file = new File(a2 + e);
        File file2 = new File(a2 + f);
        try {
            if (!file.exists()) {
                boolean createNewFile = file.createNewFile();
                boolean createNewFile2 = file2.createNewFile();
                if (!createNewFile || !createNewFile2) {
                    return 4;
                }
            }
            RandomAccessFile randomAccessFile3 = new RandomAccessFile(file, "rws");
            try {
                RandomAccessFile randomAccessFile4 = new RandomAccessFile(file2, "rws");
                try {
                    if (this.n > 0) {
                        Log.i(u, "(" + this.w.f6303c + ")  seek to -> " + this.n);
                        randomAccessFile3.seek(this.n);
                    } else {
                        Log.i(u, "(" + this.w.f6303c + ")  set temp file size -> " + this.s);
                        randomAccessFile3.setLength(this.s);
                    }
                    byte[] bArr = new byte[1048576];
                    this.t = this.n;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (-1 == read) {
                            file.renameTo(new File(a2 + ".apk"));
                            if (file2.exists()) {
                                file2.delete();
                            }
                            if (this.w != null) {
                                this.w.l();
                            }
                            try {
                                randomAccessFile3.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            try {
                                randomAccessFile4.close();
                                return 1;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return 1;
                            }
                        } else if (this.d) {
                            if (this.w != null) {
                                this.w.k();
                            }
                            try {
                                randomAccessFile3.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                            try {
                                randomAccessFile4.close();
                                return 2;
                            } catch (IOException e5) {
                                e5.printStackTrace();
                                return 2;
                            }
                        } else if (this.f6293c) {
                            if (this.w != null) {
                                this.w.j();
                            }
                            try {
                                randomAccessFile3.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                            try {
                                randomAccessFile4.close();
                                return 3;
                            } catch (IOException e7) {
                                e7.printStackTrace();
                                return 3;
                            }
                        } else {
                            randomAccessFile3.write(bArr, 0, read);
                            long j2 = this.t + read;
                            this.t = j2;
                            if (this.w != null) {
                                this.w.g = j2;
                            }
                            randomAccessFile4.setLength(0L);
                            randomAccessFile4.write(String.valueOf(this.t).getBytes());
                            if (this.v != null) {
                                this.v.b(this.w, this.t, this.s);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = randomAccessFile4;
                    th = th;
                    randomAccessFile2 = randomAccessFile3;
                    try {
                        th.printStackTrace();
                        this.x = th.getMessage();
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                                return 4;
                            } catch (IOException e9) {
                                e9.printStackTrace();
                                return 4;
                            }
                        }
                        return 4;
                    } catch (Throwable th3) {
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
            }
        } catch (Throwable th5) {
            randomAccessFile = null;
            randomAccessFile2 = null;
            th = th5;
        }
    }

    static /* synthetic */ void a(a aVar) {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader2;
        FileInputStream fileInputStream2;
        BufferedReader bufferedReader;
        File file = new File(com.anythink.china.common.c.b.a(aVar.b) + f);
        File file2 = new File(com.anythink.china.common.c.b.a(aVar.b) + e);
        if (!file.exists() || !file2.exists()) {
            try {
                file.delete();
                file2.delete();
                return;
            } catch (Throwable th) {
                return;
            }
        }
        BufferedReader bufferedReader2 = null;
        try {
            FileInputStream fileInputStream3 = new FileInputStream(file);
            try {
                InputStreamReader inputStreamReader3 = new InputStreamReader(fileInputStream3);
                InputStreamReader inputStreamReader4 = inputStreamReader3;
                bufferedReader2 = null;
                fileInputStream = fileInputStream3;
                try {
                    try {
                        BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader3);
                        try {
                            String readLine = bufferedReader3.readLine();
                            if (!TextUtils.isEmpty(readLine)) {
                                long longValue = Long.valueOf(readLine).longValue();
                                aVar.n = longValue;
                                if (longValue > file2.length()) {
                                    aVar.n = 0L;
                                } else {
                                    aVar.s = file2.length();
                                }
                                StringBuilder sb = new StringBuilder("readLogFile: startPost -> ");
                                sb.append(aVar.n);
                                sb.append(", downloadSize -> ");
                                sb.append(aVar.s);
                            }
                            try {
                                bufferedReader3.close();
                                inputStreamReader3.close();
                                fileInputStream3.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        } catch (Exception e3) {
                            inputStreamReader2 = inputStreamReader3;
                            bufferedReader = bufferedReader3;
                            fileInputStream2 = fileInputStream3;
                            e = e3;
                            inputStreamReader4 = inputStreamReader2;
                            bufferedReader2 = bufferedReader;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    return;
                                }
                            }
                            if (inputStreamReader2 != null) {
                                inputStreamReader2.close();
                            }
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                        } catch (Throwable th2) {
                            bufferedReader2 = bufferedReader3;
                            inputStreamReader = inputStreamReader3;
                            fileInputStream = fileInputStream3;
                            th = th2;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                    throw th;
                                }
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStreamReader = inputStreamReader4;
                    }
                } catch (Exception e6) {
                    inputStreamReader2 = inputStreamReader3;
                    bufferedReader = null;
                    fileInputStream2 = fileInputStream3;
                    e = e6;
                }
            } catch (Exception e7) {
                inputStreamReader2 = null;
                bufferedReader = null;
                fileInputStream2 = fileInputStream3;
                e = e7;
            } catch (Throwable th4) {
                inputStreamReader = null;
                fileInputStream = fileInputStream3;
                th = th4;
            }
        } catch (Exception e8) {
            e = e8;
            inputStreamReader2 = null;
            fileInputStream2 = null;
            bufferedReader = null;
        } catch (Throwable th5) {
            th = th5;
            inputStreamReader = null;
            fileInputStream = null;
        }
    }

    private void g() {
        com.anythink.china.common.a.a.a.a().a((com.anythink.core.common.k.b.b) new AnonymousClass1());
    }

    private void h() {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        File file = new File(com.anythink.china.common.c.b.a(this.b) + f);
        File file2 = new File(com.anythink.china.common.c.b.a(this.b) + e);
        if (!file.exists() || !file2.exists()) {
            try {
                file.delete();
                file2.delete();
                return;
            } catch (Throwable th) {
                return;
            }
        }
        BufferedReader bufferedReader = null;
        BufferedReader bufferedReader2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                InputStreamReader inputStreamReader2 = inputStreamReader;
                bufferedReader = null;
                FileInputStream fileInputStream2 = fileInputStream;
                try {
                    try {
                        BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader);
                        try {
                            String readLine = bufferedReader3.readLine();
                            if (!TextUtils.isEmpty(readLine)) {
                                long longValue = Long.valueOf(readLine).longValue();
                                this.n = longValue;
                                if (longValue > file2.length()) {
                                    this.n = 0L;
                                } else {
                                    this.s = file2.length();
                                }
                                StringBuilder sb = new StringBuilder("readLogFile: startPost -> ");
                                sb.append(this.n);
                                sb.append(", downloadSize -> ");
                                sb.append(this.s);
                            }
                            try {
                                bufferedReader3.close();
                                inputStreamReader.close();
                                fileInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        } catch (Exception e3) {
                            bufferedReader2 = bufferedReader3;
                            e = e3;
                            inputStreamReader2 = inputStreamReader;
                            bufferedReader = bufferedReader2;
                            fileInputStream2 = fileInputStream;
                            e.printStackTrace();
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    return;
                                }
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        } catch (Throwable th2) {
                            bufferedReader = bufferedReader3;
                            th = th2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                    throw th;
                                }
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        inputStreamReader = inputStreamReader2;
                    }
                } catch (Exception e6) {
                    e = e6;
                }
            } catch (Exception e7) {
                e = e7;
                inputStreamReader = null;
            } catch (Throwable th4) {
                th = th4;
                inputStreamReader = null;
            }
        } catch (Exception e8) {
            e = e8;
            inputStreamReader = null;
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            inputStreamReader = null;
            fileInputStream = null;
        }
    }

    private static int i() {
        return 60000;
    }

    private static int j() {
        return 20000;
    }

    public final void a() {
        this.f6293c = true;
    }

    public final void a(InterfaceC0088a interfaceC0088a) {
        this.v = interfaceC0088a;
        this.f6293c = false;
        com.anythink.china.common.a.a.a.a().a((com.anythink.core.common.k.b.b) new AnonymousClass1());
    }

    protected final void a(b bVar) {
        new StringBuilder("url: ").append(this.f6292a);
        b(bVar);
    }

    protected final void a(ConnectTimeoutException connectTimeoutException) {
        b(c.a("10000", connectTimeoutException.getMessage()));
    }

    public final void b() {
        this.d = true;
    }

    protected final void b(b bVar) {
        StringBuilder sb = new StringBuilder("download failed --> ");
        sb.append(this.f6292a);
        sb.append("(");
        sb.append(bVar.a());
        sb.append(")");
        this.w.n();
        InterfaceC0088a interfaceC0088a = this.v;
        if (interfaceC0088a != null) {
            interfaceC0088a.a(this.w, bVar.b());
        }
    }

    protected boolean c() {
        return true;
    }

    protected final void d() {
        new StringBuilder("url: ").append(this.f6292a);
        InterfaceC0088a interfaceC0088a = this.v;
        if (interfaceC0088a != null) {
            interfaceC0088a.a(this.w, this.t, this.s, this.m);
        }
    }

    protected final void e() {
        new StringBuilder("url: ").append(this.f6292a);
        InterfaceC0088a interfaceC0088a = this.v;
        if (interfaceC0088a != null) {
            e eVar = this.w;
            interfaceC0088a.a(eVar, eVar.i);
        }
    }
}
