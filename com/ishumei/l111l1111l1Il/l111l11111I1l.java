package com.ishumei.l111l1111l1Il;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import com.ishumei.l111l1111llIl.l111l1111lIl;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l1111l1Il/l111l11111I1l.class */
public final class l111l11111I1l {
    private static final String l1111l111111Il = "sm";
    private static final String l111l11111I1l = "Content-Type";
    private static final String l111l11111Il = "application/octet-stream";
    private static final String l111l11111lIl = "Content-Length";
    private static final String l111l1111l1Il = "Connection";
    private static String l111l1111lI1l = "POST";
    private static final String l111l1111llIl = "Close";
    private int l111l1111lIl;
    private int l11l1111I11l;
    private int l11l1111I1l;
    private long l11l1111I1ll;
    private ArrayList<String> l11l1111lIIl = new ArrayList<>();
    private SSLContext l11l1111Il = null;
    private TrustManager[] l11l1111Il1l = null;
    private KeyStore l11l1111Ill = null;

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l1111l1Il/l111l11111I1l$l1111l111111Il.class */
    public static abstract class l1111l111111Il<T> extends com.ishumei.l111l11111I1l.l111l11111lIl<T> {
        private static int l111l11111I1l = 0;
        private static int l111l11111Il = 1;
        private static int l111l1111l1Il = 2;
        private static int l111l1111llIl = 3;
        protected l111l11111lIl l111l11111lIl;

        public l1111l111111Il(boolean z, int i) {
            super(z, i);
            this.l111l11111lIl = null;
        }

        private l1111l111111Il(boolean z, int i, boolean z2) {
            super(z, i, z2);
            this.l111l11111lIl = null;
        }

        private l1111l111111Il(boolean z, int i, boolean z2, long j, boolean z3) {
            super(z, i, z2, j, z3);
            this.l111l11111lIl = null;
        }

        public abstract void l1111l111111Il(String str);

        public boolean l1111l111111Il(String str, int i) {
            if (!this.l111l11111lIl.l111l1111lI1l || this.l111l11111lIl.l111l11111Il + 1 >= this.l111l11111lIl.l111l1111lIl) {
                return true;
            }
            this.l111l11111lIl.l111l11111Il++;
            l111l1111lIl.l1111l111111Il(this.l111l11111lIl.l1111l111111Il);
            this.l111l11111lIl.l1111l111111Il = null;
            this.l111l11111lIl.l111l1111llIl.l1111l111111Il();
            return false;
        }

        /* JADX WARN: Not initialized variable reg: 10, insn: 0x0183: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:58:0x0183 */
        /* JADX WARN: Not initialized variable reg: 9, insn: 0x018a: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:58:0x0183 */
        @Override // java.lang.Runnable
        public void run() {
            Closeable closeable;
            Closeable closeable2;
            Throwable th;
            InputStream inputStream;
            InputStream inputStream2;
            BufferedReader bufferedReader;
            InputStream inputStream3;
            BufferedReader bufferedReader2;
            if (this.l111l11111lIl.l11l1111lIIl != null) {
                l1111l111111Il(this.l111l11111lIl.l11l1111lIIl, 1);
                this.l111l11111lIl.l11l1111lIIl = null;
            } else if (this.l111l11111lIl.l1111l111111Il == null) {
                l1111l111111Il("HttpUrlConnection is null", 0);
            } else {
                try {
                    int responseCode = this.l111l11111lIl.l1111l111111Il.getResponseCode();
                    try {
                        if (responseCode != 200) {
                            l1111l111111Il("responseCode: " + responseCode, 2);
                            return;
                        }
                        try {
                            inputStream2 = this.l111l11111lIl.l1111l111111Il.getInputStream();
                            try {
                                bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream2));
                            } catch (Exception e) {
                                e = e;
                                inputStream3 = inputStream2;
                                bufferedReader = null;
                            } catch (Throwable th2) {
                                th = th2;
                                closeable2 = null;
                                l111l1111lIl.l1111l111111Il((Closeable) inputStream2);
                                l111l1111lIl.l1111l111111Il(closeable2);
                                l111l1111lIl.l1111l111111Il(this.l111l11111lIl.l1111l111111Il);
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            bufferedReader = null;
                            inputStream3 = null;
                        } catch (Throwable th3) {
                            th = th3;
                            closeable2 = null;
                            inputStream2 = null;
                        }
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            if (!TextUtils.isEmpty(this.l111l11111lIl.l11l1111I1l)) {
                                com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il.l1111l111111Il().l1111l111111Il(l111l1111lIl.l111l1111lI1l(this.l111l11111lIl.l11l1111I11l), this.l111l11111lIl.l11l1111I1l);
                            }
                            l1111l111111Il(sb.toString());
                            l111l1111lIl.l1111l111111Il((Closeable) inputStream2);
                            l111l1111lIl.l1111l111111Il((Closeable) bufferedReader2);
                            l111l1111lIl.l1111l111111Il(this.l111l11111lIl.l1111l111111Il);
                        } catch (Exception e3) {
                            e = e3;
                            inputStream3 = inputStream2;
                            bufferedReader = bufferedReader2;
                            Log.getStackTraceString(e);
                            InputStream inputStream4 = inputStream3;
                            StringBuilder sb2 = new StringBuilder("response content err: ");
                            InputStream inputStream5 = inputStream3;
                            sb2.append(e);
                            InputStream inputStream6 = inputStream3;
                            l1111l111111Il(sb2.toString(), 3);
                            l111l1111lIl.l1111l111111Il((Closeable) inputStream3);
                            l111l1111lIl.l1111l111111Il((Closeable) bufferedReader);
                            l111l1111lIl.l1111l111111Il(this.l111l11111lIl.l1111l111111Il);
                        }
                    } catch (Throwable th4) {
                        closeable2 = closeable;
                        th = th4;
                        inputStream2 = inputStream;
                    }
                } catch (Exception e4) {
                    l111l1111lIl.l1111l111111Il(this.l111l11111lIl.l1111l111111Il);
                    Log.getStackTraceString(e4);
                    l1111l111111Il(e4.getMessage(), 2);
                }
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l1111l1Il/l111l11111I1l$l111l11111lIl.class */
    public static final class l111l11111lIl {
        public String l11l1111I11l;
        String l11l1111I1l;
        public boolean l11l1111I1ll;
        HttpURLConnection l1111l111111Il = null;
        public byte[] l111l11111lIl = null;
        Map<String, String> l111l11111I1l = null;
        public int l111l11111Il = -1;
        l1111l111111Il l111l1111l1Il = null;
        com.ishumei.l111l11111I1l.l111l11111lIl<l111l11111lIl> l111l1111llIl = null;
        boolean l111l1111lI1l = false;
        public int l111l1111lIl = 0;
        String l11l1111lIIl = null;
    }

    private String l1111l111111Il(byte[] bArr, Map<String, String> map, String str, boolean z) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        OutputStream outputStream;
        if (bArr == null || bArr.length == 0) {
            throw new IOException("data is null");
        }
        try {
            final String l111l1111lI1l2 = l111l1111lIl.l111l1111lI1l(str);
            String l1111l111111Il2 = com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il.l1111l111111Il().l1111l111111Il(l111l1111lI1l2, z);
            httpURLConnection = (HttpURLConnection) (TextUtils.isEmpty(l1111l111111Il2) ? new URL(str) : new URL(Patterns.DOMAIN_NAME.matcher(str).replaceFirst(l1111l111111Il2))).openConnection();
            try {
                if (this.l111l1111lIl == 0) {
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() { // from class: com.ishumei.l111l1111l1Il.l111l11111I1l.1
                        @Override // javax.net.ssl.HostnameVerifier
                        public final boolean verify(String str2, SSLSession sSLSession) {
                            if (TextUtils.isEmpty(l111l1111lI1l2) || Patterns.IP_ADDRESS.matcher(l111l1111lI1l2).matches()) {
                                return true;
                            }
                            return HttpsURLConnection.getDefaultHostnameVerifier().verify(l111l1111lI1l2, sSLSession);
                        }
                    });
                    if (this.l11l1111Il1l != null && this.l11l1111Il != null) {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.l11l1111Il.getSocketFactory());
                    }
                }
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestMethod(l111l1111lI1l);
                httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                httpURLConnection.setRequestProperty("Connection", l111l1111llIl);
                httpURLConnection.setConnectTimeout(this.l11l1111I11l);
                httpURLConnection.setReadTimeout(this.l11l1111I1l);
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.connect();
                OutputStream outputStream2 = httpURLConnection.getOutputStream();
                try {
                    outputStream2.write(bArr);
                    outputStream2.flush();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 200) {
                        throw new IOException("responseCode = " + responseCode);
                    }
                    InputStream inputStream2 = httpURLConnection.getInputStream();
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream2));
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = null;
                    }
                    try {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        }
                        if (!TextUtils.isEmpty(l1111l111111Il2)) {
                            com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il.l1111l111111Il().l1111l111111Il(l111l1111lI1l2, l1111l111111Il2);
                        }
                        String sb2 = sb.toString();
                        l111l1111lIl.l1111l111111Il((Closeable) outputStream2);
                        l111l1111lIl.l1111l111111Il((Closeable) inputStream2);
                        l111l1111lIl.l1111l111111Il((Closeable) bufferedReader);
                        l111l1111lIl.l1111l111111Il(httpURLConnection);
                        return sb2;
                    } catch (Throwable th2) {
                        th = th2;
                        outputStream = outputStream2;
                        inputStream = inputStream2;
                        l111l1111lIl.l1111l111111Il((Closeable) outputStream);
                        l111l1111lIl.l1111l111111Il((Closeable) inputStream);
                        l111l1111lIl.l1111l111111Il((Closeable) bufferedReader);
                        l111l1111lIl.l1111l111111Il(httpURLConnection);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    outputStream = outputStream2;
                    inputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                bufferedReader = null;
                outputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            httpURLConnection = null;
            bufferedReader = null;
            outputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(22:5|(1:9)|10|(3:72|73|(19:75|76|13|(1:15)(2:69|(1:71))|16|17|18|19|(2:21|(1:25))|26|27|(3:29|(3:33|30|31)|34)|35|36|37|38|39|40|(2:42|43)(1:45)))|12|13|(0)(0)|16|17|18|19|(0)|26|27|(0)|35|36|37|38|39|40|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0179, code lost:
        r8 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x017a, code lost:
        r7 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0180, code lost:
        r13 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0185, code lost:
        r13 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0187, code lost:
        r12 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058 A[Catch: all -> 0x018d, Exception -> 0x0194, TRY_LEAVE, TryCatch #4 {Exception -> 0x0194, blocks: (B:13:0x002d, B:17:0x003e, B:19:0x0058, B:23:0x008c, B:20:0x0065, B:22:0x007f), top: B:75:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065 A[Catch: all -> 0x018d, Exception -> 0x0194, TRY_ENTER, TRY_LEAVE, TryCatch #4 {Exception -> 0x0194, blocks: (B:13:0x002d, B:17:0x003e, B:19:0x0058, B:23:0x008c, B:20:0x0065, B:22:0x007f), top: B:75:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009d A[Catch: Exception -> 0x0185, all -> 0x018d, TryCatch #3 {Exception -> 0x0185, blocks: (B:25:0x0097, B:27:0x009d, B:29:0x00b6, B:31:0x00bd, B:33:0x00ce, B:35:0x011b, B:37:0x012a, B:39:0x0132, B:40:0x015a), top: B:73:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011b A[Catch: Exception -> 0x0185, all -> 0x018d, TRY_ENTER, TryCatch #3 {Exception -> 0x0185, blocks: (B:25:0x0097, B:27:0x009d, B:29:0x00b6, B:31:0x00bd, B:33:0x00ce, B:35:0x011b, B:37:0x012a, B:39:0x0132, B:40:0x015a), top: B:73:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ad A[Catch: all -> 0x01f3, TRY_ENTER, TryCatch #1 {all -> 0x01f3, blocks: (B:54:0x019d, B:56:0x01ad), top: B:71:0x019d }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void l1111l111111Il(byte[] r7, java.util.Map<java.lang.String, java.lang.String> r8, java.lang.String r9, com.ishumei.l111l1111l1Il.l111l11111I1l.l1111l111111Il<?> r10) {
        /*
            Method dump skipped, instructions count: 529
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ishumei.l111l1111l1Il.l111l11111I1l.l1111l111111Il(byte[], java.util.Map, java.lang.String, com.ishumei.l111l1111l1Il.l111l11111I1l$l1111l111111Il):void");
    }

    public final l111l11111I1l l1111l111111Il(com.ishumei.l111l1111l1Il.l1111l111111Il l1111l111111il) {
        if (l1111l111111il == null) {
            return null;
        }
        int length = l1111l111111il.l111l1111llIl().length;
        this.l111l1111lIl = l1111l111111il.l111l11111Il();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                break;
            }
            this.l11l1111lIIl.add(l1111l111111il.l111l1111l1Il());
            i = i2 + 1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                break;
            }
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < 2) {
                    this.l11l1111lIIl.add(l1111l111111il.l111l1111llIl()[i4]);
                    i5 = i6 + 1;
                }
            }
            i3 = i4 + 1;
        }
        this.l11l1111I11l = l1111l111111il.l111l11111lIl() * 1000;
        this.l11l1111I1l = l1111l111111il.l111l11111I1l() * 1000;
        this.l11l1111I1ll = l1111l111111il.l111l1111lIl() * 1000;
        if (1 == this.l111l1111lIl) {
            return this;
        }
        try {
            if (l1111l111111il.l1111l111111Il()) {
                Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(l1111l111111il.l111l1111lI1l()));
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null);
                keyStore.setCertificateEntry("smfp", generateCertificate);
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                this.l11l1111Il1l = trustManagerFactory.getTrustManagers();
                SSLContext sSLContext = SSLContext.getInstance("SSL");
                this.l11l1111Il = sSLContext;
                sSLContext.init(null, this.l11l1111Il1l, null);
            }
            return this;
        } catch (Exception e) {
            this.l11l1111Il = null;
            this.l11l1111Il1l = null;
            return this;
        }
    }

    public final String l1111l111111Il(byte[] bArr, Map<String, String> map) {
        int size = this.l11l1111lIIl.size();
        int i = 0;
        while (i < this.l11l1111lIIl.size()) {
            int i2 = i % size;
            String str = this.l11l1111lIIl.get(i2);
            i++;
            boolean z = true;
            if (i <= 1) {
                z = false;
            }
            try {
                return l1111l111111Il(bArr, (Map<String, String>) null, str, z);
            } catch (Exception e) {
                this.l11l1111lIIl.get(i2);
                Log.getStackTraceString(e);
            }
        }
        throw new Exception("all retry have fail");
    }

    public final String l1111l111111Il(byte[] bArr, Map<String, String> map, String str) {
        return l1111l111111Il(bArr, (Map<String, String>) null, str, false);
    }

    /* JADX WARN: Type inference failed for: r1v14, types: [com.ishumei.l111l1111l1Il.l111l11111I1l$l111l11111lIl, T] */
    public final void l1111l111111Il(byte[] bArr, boolean z, Map<String, String> map, l1111l111111Il l1111l111111il) {
        if (l1111l111111il != null) {
            try {
                com.ishumei.l111l11111lIl.l111l11111lIl l111l11111lIl2 = com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il().l111l11111lIl();
                int l111l1111l1Il2 = l111l11111lIl2 == null ? 2 : l111l11111lIl2.l111l1111l1Il();
                if (l1111l111111il.l111l11111lIl == null) {
                    l1111l111111il.l111l11111lIl = new l111l11111lIl();
                }
                l1111l111111il.l111l11111lIl.l111l11111Il = 0;
                l1111l111111il.l111l11111lIl.l111l11111lIl = bArr;
                l1111l111111il.l111l11111lIl.l111l11111I1l = null;
                l1111l111111il.l111l11111lIl.l111l1111lI1l = true;
                l1111l111111il.l111l11111lIl.l111l1111l1Il = l1111l111111il;
                l1111l111111il.l111l11111lIl.l111l1111lIl = Math.min(l111l1111l1Il2, this.l11l1111lIIl.size());
                l1111l111111il.l111l11111lIl.l11l1111I11l = this.l11l1111lIIl.get(0);
                l1111l111111il.l111l11111lIl.l11l1111I1ll = z;
                l1111l111111il.l111l11111lIl.l111l1111llIl = new com.ishumei.l111l11111I1l.l111l11111lIl<l111l11111lIl>(true, com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(), true, this.l11l1111I1ll, false) { // from class: com.ishumei.l111l1111l1Il.l111l11111I1l.3
                    {
                        super(true, r11, true, r13, false);
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        l111l11111lIl l111l11111lil = (l111l11111lIl) this.l1111l111111Il;
                        try {
                            if (l111l11111lil == null) {
                                throw new Exception("sessionCache is null");
                            }
                            if (l111l11111lil.l111l11111Il >= l111l11111I1l.this.l11l1111lIIl.size()) {
                                return;
                            }
                            l111l11111I1l.this.l1111l111111Il(l111l11111lil.l111l11111lIl, l111l11111lil.l111l11111I1l, (String) l111l11111I1l.this.l11l1111lIIl.get(l111l11111lil.l111l11111Il), l111l11111lil.l111l1111l1Il);
                        } catch (Exception e) {
                            Log.getStackTraceString(e);
                        }
                    }
                };
                l1111l111111il.l111l11111lIl.l111l1111llIl.l1111l111111Il = l1111l111111il.l111l11111lIl;
            } catch (Exception e) {
                Log.getStackTraceString(e);
                return;
            }
        }
        l1111l111111Il(bArr, (Map<String, String>) null, this.l11l1111lIIl.get(0), l1111l111111il);
    }
}
