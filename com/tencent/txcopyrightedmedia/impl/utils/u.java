package com.tencent.txcopyrightedmedia.impl.utils;

import android.net.http.Headers;
import com.baidu.mobads.sdk.internal.bw;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.util.IOUtils;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u.class */
public abstract class u {
    private static final Pattern d = Pattern.compile("([ |\t]*Content-Disposition[ |\t]*:)(.*)", 2);
    private static final Pattern e = Pattern.compile("([ |\t]*content-type[ |\t]*:)(.*)", 2);
    private static final Pattern f = Pattern.compile("[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]([^\"^']*)['|\"]");
    private static final Logger g = Logger.getLogger(u.class.getName());

    /* renamed from: a  reason: collision with root package name */
    protected String f26467a;
    public int b;
    private volatile ServerSocket h;
    private Thread j;
    private q i = new g();
    private t k = new j(this, (byte) 0);

    /* renamed from: c  reason: collision with root package name */
    protected a f26468c = new f();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$a.class */
    public interface a {
        void a();

        void a(b bVar);

        void b(b bVar);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$b.class */
    public final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final InputStream f26469a;
        final Socket b;

        public b(InputStream inputStream, Socket socket) {
            this.f26469a = inputStream;
            this.b = socket;
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00ac, code lost:
            if ("NanoHttpd Shutdown".equals(r10.getMessage()) == false) goto L37;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 240
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.txcopyrightedmedia.impl.utils.u.b.run():void");
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$c.class */
    public static final class c {
        private static final Pattern e = Pattern.compile("[ |\t]*([^/^ ^;^,]+/[^ ^;^,]+)", 2);
        private static final Pattern f = Pattern.compile("[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);
        private static final Pattern g = Pattern.compile("[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);

        /* renamed from: a  reason: collision with root package name */
        final String f26471a;
        final String b;

        /* renamed from: c  reason: collision with root package name */
        final String f26472c;
        final String d;

        public c(String str) {
            String str2;
            this.f26471a = str;
            if (str != null) {
                this.b = a(str, e, "", 1);
                str2 = a(str, f, null, 2);
            } else {
                this.b = "";
                str2 = "UTF-8";
            }
            this.f26472c = str2;
            if (HttpConstants.ContentType.MULTIPART_FORM_DATA.equalsIgnoreCase(this.b)) {
                this.d = a(str, g, null, 2);
            } else {
                this.d = null;
            }
        }

        private static String a(String str, Pattern pattern, String str2, int i) {
            Matcher matcher = pattern.matcher(str);
            return matcher.find() ? matcher.group(i) : str2;
        }

        public final String a() {
            String str = this.f26472c;
            String str2 = str;
            if (str == null) {
                str2 = com.anythink.expressad.exoplayer.b.i;
            }
            return str2;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$d.class */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        final String f26473a;
        final String b;

        /* renamed from: c  reason: collision with root package name */
        final String f26474c;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$e.class */
    public final class e implements Iterable<String> {
        private final HashMap<String, String> b = new HashMap<>();

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList<d> f26476c = new ArrayList<>();

        public e(Map<String, String> map) {
            String str = map.get("cookie");
            if (str == null) {
                return;
            }
            String[] split = str.split(com.huawei.openalliance.ad.constant.t.aE);
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                String[] split2 = split[i2].trim().split("=");
                if (split2.length == 2) {
                    this.b.put(split2[0], split2[1]);
                }
                i = i2 + 1;
            }
        }

        public final void a(n nVar) {
            Iterator<d> it = this.f26476c.iterator();
            while (it.hasNext()) {
                d next = it.next();
                nVar.a("Set-Cookie", String.format("%s=%s; expires=%s", next.f26473a, next.b, next.f26474c));
            }
        }

        @Override // java.lang.Iterable
        public final Iterator<String> iterator() {
            return this.b.keySet().iterator();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$f.class */
    public static final class f implements a {

        /* renamed from: a  reason: collision with root package name */
        private long f26477a;
        private final List<b> b = Collections.synchronizedList(new ArrayList());

        @Override // com.tencent.txcopyrightedmedia.impl.utils.u.a
        public final void a() {
            Iterator it = new ArrayList(this.b).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                u.b(bVar.f26469a);
                u.b(bVar.b);
            }
        }

        @Override // com.tencent.txcopyrightedmedia.impl.utils.u.a
        public final void a(b bVar) {
            this.b.remove(bVar);
        }

        @Override // com.tencent.txcopyrightedmedia.impl.utils.u.a
        public final void b(b bVar) {
            this.f26477a++;
            Thread thread = new Thread(bVar);
            thread.setDaemon(true);
            thread.setName("NanoHttpd Request Processor (#" + this.f26477a + ")");
            this.b.add(bVar);
            thread.start();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$g.class */
    public static final class g implements q {
        @Override // com.tencent.txcopyrightedmedia.impl.utils.u.q
        public final ServerSocket a() {
            return new ServerSocket();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$h.class */
    public static final class h implements r {

        /* renamed from: a  reason: collision with root package name */
        private final File f26478a;
        private final OutputStream b;

        public h(File file) {
            this.f26478a = File.createTempFile("NanoHTTPD-", "", file);
            this.b = new FileOutputStream(this.f26478a);
        }

        @Override // com.tencent.txcopyrightedmedia.impl.utils.u.r
        public final void a() {
            u.b(this.b);
            if (this.f26478a.delete()) {
                return;
            }
            throw new Exception("could not delete temporary file: " + this.f26478a.getAbsolutePath());
        }

        @Override // com.tencent.txcopyrightedmedia.impl.utils.u.r
        public final String b() {
            return this.f26478a.getAbsolutePath();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$i.class */
    public static final class i implements s {

        /* renamed from: a  reason: collision with root package name */
        private final File f26479a;
        private final List<r> b;

        public i() {
            File file = new File(System.getProperty("java.io.tmpdir"));
            this.f26479a = file;
            if (!file.exists()) {
                this.f26479a.mkdirs();
            }
            this.b = new ArrayList();
        }

        @Override // com.tencent.txcopyrightedmedia.impl.utils.u.s
        public final void a() {
            for (r rVar : this.b) {
                try {
                    rVar.a();
                } catch (Exception e) {
                    u.g.log(Level.WARNING, "could not delete file ", (Throwable) e);
                }
            }
            this.b.clear();
        }

        @Override // com.tencent.txcopyrightedmedia.impl.utils.u.s
        public final r b() {
            h hVar = new h(this.f26479a);
            this.b.add(hVar);
            return hVar;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$j.class */
    final class j implements t {
        private j() {
        }

        /* synthetic */ j(u uVar, byte b) {
            this();
        }

        @Override // com.tencent.txcopyrightedmedia.impl.utils.u.t
        public final s a() {
            return new i();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$k.class */
    public final class k implements l {
        private final s b;

        /* renamed from: c  reason: collision with root package name */
        private final OutputStream f26482c;
        private final BufferedInputStream d;
        private int e;
        private int f;
        private String g;
        private m h;
        private Map<String, List<String>> i;
        private Map<String, String> j = new HashMap();
        private e k;
        private String l;
        private String m;

        public k(s sVar, InputStream inputStream, OutputStream outputStream) {
            this.b = sVar;
            this.d = new BufferedInputStream(inputStream, 8192);
            this.f26482c = outputStream;
        }

        private static int a(byte[] bArr, int i) {
            byte b;
            do {
                b = bArr[i];
                i++;
            } while (b != 10);
            return i;
        }

        private String a(ByteBuffer byteBuffer, int i, int i2) {
            if (i2 <= 0) {
                return "";
            }
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    r b = this.b.b();
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(b.b());
                    try {
                        FileChannel channel = fileOutputStream2.getChannel();
                        duplicate.position(i).limit(i + i2);
                        channel.write(duplicate.slice());
                        String b2 = b.b();
                        u.b(fileOutputStream2);
                        return b2;
                    } catch (Exception e) {
                        fileOutputStream = fileOutputStream2;
                        e = e;
                        throw new Error(e);
                    } catch (Throwable th) {
                        fileOutputStream = fileOutputStream2;
                        th = th;
                        u.b(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            }
        }

        private void a(c cVar, ByteBuffer byteBuffer, Map<String, List<String>> map, Map<String, String> map2) {
            int i;
            String group;
            String str;
            int i2;
            try {
                byte[] bytes = cVar.d.getBytes();
                int[] iArr = new int[0];
                if (byteBuffer.remaining() >= bytes.length) {
                    int length = bytes.length + 4096;
                    byte[] bArr = new byte[length];
                    int remaining = byteBuffer.remaining() < length ? byteBuffer.remaining() : length;
                    byteBuffer.get(bArr, 0, remaining);
                    int length2 = remaining - bytes.length;
                    int i3 = 0;
                    int[] iArr2 = iArr;
                    do {
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= length2) {
                                break;
                            }
                            int i6 = 0;
                            while (i6 < bytes.length && bArr[i5 + i6] == bytes[i6]) {
                                int[] iArr3 = iArr2;
                                if (i6 == bytes.length - 1) {
                                    iArr3 = new int[iArr2.length + 1];
                                    System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
                                    iArr3[iArr2.length] = i3 + i5;
                                }
                                i6++;
                                iArr2 = iArr3;
                            }
                            i4 = i5 + 1;
                        }
                        i3 += length2;
                        System.arraycopy(bArr, length - bytes.length, bArr, 0, bytes.length);
                        int length3 = length - bytes.length;
                        length2 = length3;
                        if (byteBuffer.remaining() < length3) {
                            length2 = byteBuffer.remaining();
                        }
                        byteBuffer.get(bArr, bytes.length, length2);
                    } while (length2 > 0);
                    iArr = iArr2;
                }
                try {
                    if (iArr.length < 2) {
                        throw new o(n.c.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but contains less than two boundary strings.");
                    }
                    byte[] bArr2 = new byte[1024];
                    int i7 = 0;
                    int i8 = 0;
                    while (i7 < iArr.length - 1) {
                        byteBuffer.position(iArr[i7]);
                        int remaining2 = byteBuffer.remaining() < 1024 ? byteBuffer.remaining() : 1024;
                        byteBuffer.get(bArr2, 0, remaining2);
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr2, 0, remaining2), Charset.forName(cVar.a())), remaining2);
                        String readLine = bufferedReader.readLine();
                        if (readLine == null || !readLine.contains(cVar.d)) {
                            throw new o(n.c.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but chunk does not start with boundary.");
                        }
                        String readLine2 = bufferedReader.readLine();
                        String str2 = null;
                        String str3 = null;
                        String str4 = null;
                        int i9 = 2;
                        while (readLine2 != null && readLine2.trim().length() > 0) {
                            Matcher matcher = u.d.matcher(readLine2);
                            String str5 = str3;
                            int i10 = i8;
                            String str6 = str2;
                            if (matcher.matches()) {
                                Matcher matcher2 = u.f.matcher(matcher.group(2));
                                while (true) {
                                    str5 = str3;
                                    i10 = i8;
                                    str6 = str2;
                                    if (!matcher2.find()) {
                                        break;
                                    }
                                    String group2 = matcher2.group(1);
                                    if ("name".equalsIgnoreCase(group2)) {
                                        group = matcher2.group(2);
                                        str = str3;
                                        i2 = i8;
                                    } else {
                                        str = str3;
                                        i2 = i8;
                                        group = str2;
                                        if (TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME.equalsIgnoreCase(group2)) {
                                            str3 = matcher2.group(2);
                                            str = str3;
                                            i2 = i8;
                                            group = str2;
                                            if (!str3.isEmpty()) {
                                                if (i8 > 0) {
                                                    str2 = str2 + String.valueOf(i8);
                                                    i8++;
                                                } else {
                                                    i2 = i8 + 1;
                                                    str = str3;
                                                    group = str2;
                                                }
                                            }
                                        }
                                    }
                                    str3 = str;
                                    i8 = i2;
                                    str2 = group;
                                }
                            }
                            Matcher matcher3 = u.e.matcher(readLine2);
                            if (matcher3.matches()) {
                                str4 = matcher3.group(2).trim();
                            }
                            readLine2 = bufferedReader.readLine();
                            i9++;
                            str3 = str5;
                            i8 = i10;
                            str2 = str6;
                        }
                        int i11 = 0;
                        while (i9 > 0) {
                            i11 = a(bArr2, i11);
                            i9--;
                        }
                        if (i11 >= remaining2 - 4) {
                            throw new o(n.c.INTERNAL_ERROR, "Multipart header size exceeds MAX_HEADER_SIZE.");
                        }
                        int i12 = iArr[i7] + i11;
                        i7++;
                        int i13 = iArr[i7] - 4;
                        byteBuffer.position(i12);
                        List<String> list = map.get(str2);
                        ArrayList arrayList = list;
                        if (list == null) {
                            arrayList = new ArrayList();
                            map.put(str2, arrayList);
                        }
                        if (str4 == null) {
                            byte[] bArr3 = new byte[i13 - i12];
                            byteBuffer.get(bArr3);
                            arrayList.add(new String(bArr3, cVar.a()));
                        } else {
                            String a2 = a(byteBuffer, i12, i13 - i12);
                            if (map2.containsKey(str2)) {
                                int i14 = 2;
                                while (true) {
                                    i = i14;
                                    if (!map2.containsKey(str2 + i)) {
                                        break;
                                    }
                                    i14 = i + 1;
                                }
                                map2.put(str2 + i, a2);
                            } else {
                                map2.put(str2, a2);
                            }
                            arrayList.add(str3);
                        }
                    }
                } catch (o e) {
                    e = e;
                    throw e;
                } catch (Exception e2) {
                    e = e2;
                    throw new o(n.c.INTERNAL_ERROR, e.toString());
                }
            } catch (o e3) {
                e = e3;
            } catch (Exception e4) {
                e = e4;
            }
        }

        private void a(BufferedReader bufferedReader, Map<String, String> map, Map<String, List<String>> map2, Map<String, String> map3) {
            String a2;
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                if (!stringTokenizer.hasMoreTokens()) {
                    throw new o(n.c.BAD_REQUEST, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
                }
                map.put("method", stringTokenizer.nextToken());
                if (!stringTokenizer.hasMoreTokens()) {
                    throw new o(n.c.BAD_REQUEST, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                }
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(63);
                if (indexOf >= 0) {
                    a(nextToken.substring(indexOf + 1), map2);
                    a2 = u.a(nextToken.substring(0, indexOf));
                } else {
                    a2 = u.a(nextToken);
                }
                if (stringTokenizer.hasMoreTokens()) {
                    this.m = stringTokenizer.nextToken();
                } else {
                    this.m = "HTTP/1.1";
                    u.g.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
                }
                while (true) {
                    String readLine2 = bufferedReader.readLine();
                    if (readLine2 == null || readLine2.trim().isEmpty()) {
                        break;
                    }
                    int indexOf2 = readLine2.indexOf(58);
                    if (indexOf2 >= 0) {
                        map3.put(readLine2.substring(0, indexOf2).trim().toLowerCase(Locale.US), readLine2.substring(indexOf2 + 1).trim());
                    }
                }
                map.put("uri", a2);
            } catch (IOException e) {
                n.c cVar = n.c.INTERNAL_ERROR;
                throw new o(cVar, "SERVER INTERNAL ERROR: IOException: " + e.getMessage(), e);
            }
        }

        private void a(String str, Map<String, List<String>> map) {
            String trim;
            String str2;
            if (str == null) {
                this.l = "";
                return;
            }
            this.l = str;
            StringTokenizer stringTokenizer = new StringTokenizer(str, ContainerUtils.FIELD_DELIMITER);
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf >= 0) {
                    trim = u.a(nextToken.substring(0, indexOf)).trim();
                    str2 = u.a(nextToken.substring(indexOf + 1));
                } else {
                    trim = u.a(nextToken).trim();
                    str2 = "";
                }
                List<String> list = map.get(trim);
                ArrayList arrayList = list;
                if (list == null) {
                    arrayList = new ArrayList();
                    map.put(trim, arrayList);
                }
                arrayList.add(str2);
            }
        }

        private static int b(byte[] bArr, int i) {
            int i2;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                int i5 = i4 + 1;
                if (i5 >= i) {
                    return 0;
                }
                if (bArr[i4] == 13 && bArr[i5] == 10 && (i2 = i4 + 3) < i && bArr[i4 + 2] == 13 && bArr[i2] == 10) {
                    return i4 + 4;
                }
                if (bArr[i4] == 10 && bArr[i5] == 10) {
                    return i4 + 2;
                }
                i3 = i5;
            }
        }

        private RandomAccessFile g() {
            try {
                return new RandomAccessFile(this.b.b().b(), "rw");
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:108:0x0590  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0414  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a() {
            /*
                Method dump skipped, instructions count: 2145
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.txcopyrightedmedia.impl.utils.u.k.a():void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v104, types: [java.io.DataOutputStream] */
        @Override // com.tencent.txcopyrightedmedia.impl.utils.u.l
        public final void a(Map<String, String> map) {
            RandomAccessFile g;
            ByteArrayOutputStream byteArrayOutputStream;
            MappedByteBuffer map2;
            String str;
            String a2;
            RandomAccessFile randomAccessFile = null;
            try {
                long parseLong = this.j.containsKey(Headers.CONTENT_LEN) ? Long.parseLong(this.j.get(Headers.CONTENT_LEN)) : this.e < this.f ? this.f - this.e : 0L;
                if (parseLong < 1024) {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    g = new DataOutputStream(byteArrayOutputStream);
                } else {
                    g = g();
                    byteArrayOutputStream = null;
                    randomAccessFile = g;
                }
                byte[] bArr = new byte[512];
                while (true) {
                    RandomAccessFile randomAccessFile2 = randomAccessFile;
                    if (this.f < 0 || parseLong <= 0) {
                        break;
                    }
                    int read = this.d.read(bArr, 0, (int) Math.min(parseLong, 512L));
                    RandomAccessFile randomAccessFile3 = randomAccessFile;
                    this.f = read;
                    long j = parseLong - read;
                    parseLong = j;
                    if (read > 0) {
                        g.write(bArr, 0, read);
                        parseLong = j;
                    }
                }
                if (byteArrayOutputStream != null) {
                    map2 = ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                } else {
                    map2 = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, randomAccessFile.length());
                    RandomAccessFile randomAccessFile4 = randomAccessFile;
                    randomAccessFile.seek(0L);
                }
                RandomAccessFile randomAccessFile5 = randomAccessFile;
                if (m.POST.equals(this.h)) {
                    RandomAccessFile randomAccessFile6 = randomAccessFile;
                    c cVar = new c(this.j.get(Headers.CONTENT_TYPE));
                    RandomAccessFile randomAccessFile7 = randomAccessFile;
                    if (HttpConstants.ContentType.MULTIPART_FORM_DATA.equalsIgnoreCase(cVar.b)) {
                        RandomAccessFile randomAccessFile8 = randomAccessFile;
                        if (cVar.d == null) {
                            throw new o(n.c.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                        }
                        RandomAccessFile randomAccessFile9 = randomAccessFile;
                        a(cVar, map2, this.i, map);
                    } else {
                        RandomAccessFile randomAccessFile10 = randomAccessFile;
                        byte[] bArr2 = new byte[map2.remaining()];
                        RandomAccessFile randomAccessFile11 = randomAccessFile;
                        map2.get(bArr2);
                        RandomAccessFile randomAccessFile12 = randomAccessFile;
                        a2 = new String(bArr2, cVar.a()).trim();
                        RandomAccessFile randomAccessFile13 = randomAccessFile;
                        if ("application/x-www-form-urlencoded".equalsIgnoreCase(cVar.b)) {
                            RandomAccessFile randomAccessFile14 = randomAccessFile;
                            a(a2, this.i);
                        } else if (a2.length() != 0) {
                            str = "postData";
                            map.put(str, a2);
                        }
                    }
                } else if (m.PUT.equals(this.h)) {
                    str = "content";
                    a2 = a(map2, 0, map2.limit());
                    map.put(str, a2);
                }
                u.b(randomAccessFile);
            } catch (Throwable th) {
                u.b((Object) null);
                throw th;
            }
        }

        @Override // com.tencent.txcopyrightedmedia.impl.utils.u.l
        public final Map<String, String> b() {
            return this.j;
        }

        @Override // com.tencent.txcopyrightedmedia.impl.utils.u.l
        public final m c() {
            return this.h;
        }

        @Override // com.tencent.txcopyrightedmedia.impl.utils.u.l
        @Deprecated
        public final Map<String, String> d() {
            HashMap hashMap = new HashMap();
            for (String str : this.i.keySet()) {
                hashMap.put(str, this.i.get(str).get(0));
            }
            return hashMap;
        }

        @Override // com.tencent.txcopyrightedmedia.impl.utils.u.l
        public final String e() {
            return this.l;
        }

        @Override // com.tencent.txcopyrightedmedia.impl.utils.u.l
        public final String f() {
            return this.g;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$l.class */
    public interface l {
        void a(Map<String, String> map);

        Map<String, String> b();

        m c();

        @Deprecated
        Map<String, String> d();

        String e();

        String f();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$m.class */
    public enum m {
        GET,
        PUT,
        POST,
        DELETE,
        HEAD,
        OPTIONS,
        TRACE,
        CONNECT,
        PATCH,
        PROPFIND,
        PROPPATCH,
        MKCOL,
        MOVE,
        COPY,
        LOCK,
        UNLOCK;

        static m a(String str) {
            if (str == null) {
                return null;
            }
            try {
                return valueOf(str);
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$n.class */
    public static final class n implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        public b f26485a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        m f26486c;
        boolean d;
        boolean e;
        private InputStream f;
        private long g;
        private final Map<String, String> h = new HashMap<String, String>() { // from class: com.tencent.txcopyrightedmedia.impl.utils.u.n.1
            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* synthetic */ Object put(Object obj, Object obj2) {
                String str = (String) obj;
                String str2 = (String) obj2;
                n.this.i.put(str == null ? str : str.toLowerCase(), str2);
                return (String) super.put(str, str2);
            }
        };
        private final Map<String, String> i = new HashMap();
        private boolean j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$n$a.class */
        public static final class a extends FilterOutputStream {
            public a(OutputStream outputStream) {
                super(outputStream);
            }

            public final void a() {
                this.out.write("0\r\n\r\n".getBytes());
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                write(new byte[]{(byte) i}, 0, 1);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr) {
                write(bArr, 0, bArr.length);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                if (i2 == 0) {
                    return;
                }
                this.out.write(String.format("%x\r\n", Integer.valueOf(i2)).getBytes());
                this.out.write(bArr, i, i2);
                this.out.write(IOUtils.LINE_SEPARATOR_WINDOWS.getBytes());
            }
        }

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$n$b.class */
        public interface b {
            String a();
        }

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$n$c.class */
        public enum c implements b {
            SWITCH_PROTOCOL(101, "Switching Protocols"),
            OK(200, bw.k),
            CREATED(201, "Created"),
            ACCEPTED(202, "Accepted"),
            NO_CONTENT(204, "No Content"),
            PARTIAL_CONTENT(206, "Partial Content"),
            MULTI_STATUS(207, "Multi-Status"),
            REDIRECT(301, "Moved Permanently"),
            FOUND(302, "Found"),
            REDIRECT_SEE_OTHER(303, "See Other"),
            NOT_MODIFIED(304, "Not Modified"),
            TEMPORARY_REDIRECT(307, "Temporary Redirect"),
            BAD_REQUEST(400, "Bad Request"),
            UNAUTHORIZED(401, "Unauthorized"),
            FORBIDDEN(403, "Forbidden"),
            NOT_FOUND(404, "Not Found"),
            METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
            NOT_ACCEPTABLE(406, "Not Acceptable"),
            REQUEST_TIMEOUT(408, "Request Timeout"),
            CONFLICT(409, "Conflict"),
            GONE(410, "Gone"),
            LENGTH_REQUIRED(411, "Length Required"),
            PRECONDITION_FAILED(412, "Precondition Failed"),
            PAYLOAD_TOO_LARGE(413, "Payload Too Large"),
            UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
            RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
            EXPECTATION_FAILED(417, "Expectation Failed"),
            TOO_MANY_REQUESTS(429, "Too Many Requests"),
            INTERNAL_ERROR(500, "Internal Server Error"),
            NOT_IMPLEMENTED(501, "Not Implemented"),
            SERVICE_UNAVAILABLE(503, "Service Unavailable"),
            UNSUPPORTED_HTTP_VERSION(505, "HTTP Version Not Supported");
            
            private final String description;
            private final int requestStatus;

            c(int i, String str) {
                this.requestStatus = i;
                this.description = str;
            }

            @Override // com.tencent.txcopyrightedmedia.impl.utils.u.n.b
            public final String a() {
                return this.requestStatus + " " + this.description;
            }
        }

        protected n(b bVar, String str, InputStream inputStream, long j) {
            this.f26485a = bVar;
            this.b = str;
            boolean z = false;
            if (inputStream == null) {
                this.f = new ByteArrayInputStream(new byte[0]);
                this.g = 0L;
            } else {
                this.f = inputStream;
                this.g = j;
            }
            this.j = this.g < 0 ? true : z;
            this.e = true;
        }

        private long a(PrintWriter printWriter, long j) {
            String a2 = a(Headers.CONTENT_LEN);
            long j2 = j;
            if (a2 != null) {
                try {
                    j2 = Long.parseLong(a2);
                } catch (NumberFormatException e) {
                    u.g.severe("content-length was no number ".concat(String.valueOf(a2)));
                    j2 = j;
                }
            }
            printWriter.print("Content-Length: " + j2 + IOUtils.LINE_SEPARATOR_WINDOWS);
            return j2;
        }

        private void a(OutputStream outputStream, long j) {
            if (!this.d) {
                b(outputStream, j);
                return;
            }
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            b(gZIPOutputStream, -1L);
            gZIPOutputStream.finish();
        }

        private static void a(PrintWriter printWriter, String str, String str2) {
            printWriter.append((CharSequence) str).append(": ").append((CharSequence) str2).append(IOUtils.LINE_SEPARATOR_WINDOWS);
        }

        private void b(OutputStream outputStream, long j) {
            byte[] bArr = new byte[16384];
            boolean z = j == -1;
            while (true) {
                if (j <= 0 && !z) {
                    return;
                }
                long j2 = 16384;
                if (!z) {
                    j2 = Math.min(j, 16384L);
                }
                int read = this.f.read(bArr, 0, (int) j2);
                if (read <= 0) {
                    return;
                }
                outputStream.write(bArr, 0, read);
                if (!z) {
                    j -= read;
                }
            }
        }

        public final String a(String str) {
            return this.i.get(str.toLowerCase());
        }

        protected final void a(OutputStream outputStream) {
            long j;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            try {
                if (this.f26485a == null) {
                    throw new Error("sendResponse(): Status can't be null.");
                }
                PrintWriter printWriter = new PrintWriter((Writer) new BufferedWriter(new OutputStreamWriter(outputStream, new c(this.b).a())), false);
                printWriter.append("HTTP/1.1 ").append(this.f26485a.a()).append(" \r\n");
                if (this.b != null) {
                    a(printWriter, "Content-Type", this.b);
                }
                if (a("date") == null) {
                    a(printWriter, "Date", simpleDateFormat.format(new Date()));
                }
                for (Map.Entry<String, String> entry : this.h.entrySet()) {
                    a(printWriter, entry.getKey(), entry.getValue());
                }
                if (a(Headers.CONN_DIRECTIVE) == null) {
                    a(printWriter, "Connection", this.e ? "keep-alive" : "close");
                }
                if (a(Headers.CONTENT_LEN) != null) {
                    this.d = false;
                }
                if (this.d) {
                    a(printWriter, "Content-Encoding", "gzip");
                    this.j = true;
                }
                long j2 = this.f != null ? this.g : 0L;
                if (this.f26486c == m.HEAD || !this.j) {
                    j = j2;
                    if (!this.d) {
                        j = a(printWriter, j2);
                    }
                } else {
                    a(printWriter, "Transfer-Encoding", DownloadUtils.VALUE_CHUNKED);
                    j = j2;
                }
                printWriter.append(IOUtils.LINE_SEPARATOR_WINDOWS);
                printWriter.flush();
                if (this.f26486c == m.HEAD || !this.j) {
                    a(outputStream, j);
                } else {
                    a aVar = new a(outputStream);
                    a(aVar, -1L);
                    aVar.a();
                }
                outputStream.flush();
                u.b(this.f);
            } catch (IOException e) {
                u.g.log(Level.SEVERE, "Could not send response to the client", (Throwable) e);
            }
        }

        public final void a(String str, String str2) {
            this.h.put(str, str2);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            InputStream inputStream = this.f;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$o.class */
    public static final class o extends Exception {
        private static final long serialVersionUID = 6569838532917408380L;
        final n.c status;

        public o(n.c cVar, String str) {
            super(str);
            this.status = cVar;
        }

        public o(n.c cVar, String str, Exception exc) {
            super(str, exc);
            this.status = cVar;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$p.class */
    public final class p implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private IOException f26490c;
        private boolean d = false;
        private final int b = 5000;

        public p() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                u.this.h.bind(u.this.f26467a != null ? new InetSocketAddress(u.this.f26467a, u.this.b) : new InetSocketAddress(u.this.b));
                this.d = true;
                do {
                    try {
                        Socket accept = u.this.h.accept();
                        if (this.b > 0) {
                            accept.setSoTimeout(this.b);
                        }
                        u.this.f26468c.b(new b(accept.getInputStream(), accept));
                    } catch (IOException e) {
                        u.g.log(Level.FINE, "Communication with the client broken", (Throwable) e);
                    }
                } while (!u.this.h.isClosed());
            } catch (IOException e2) {
                this.f26490c = e2;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$q.class */
    public interface q {
        ServerSocket a();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$r.class */
    public interface r {
        void a();

        String b();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$s.class */
    public interface s {
        void a();

        r b();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/u$t.class */
    public interface t {
        s a();
    }

    public static n a(n.b bVar, String str, InputStream inputStream, long j2) {
        return new n(bVar, str, inputStream, j2);
    }

    public static n a(n.b bVar, String str, String str2) {
        byte[] bArr;
        c cVar = new c(str);
        if (str2 == null) {
            return a(bVar, str, new ByteArrayInputStream(new byte[0]), 0L);
        }
        c cVar2 = cVar;
        c cVar3 = cVar;
        try {
            if (!Charset.forName(cVar.a()).newEncoder().canEncode(str2)) {
                cVar2 = cVar;
                if (cVar.f26472c == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(cVar.f26471a);
                    sb.append("; charset=UTF-8");
                    cVar2 = new c(sb.toString());
                }
            }
            cVar3 = cVar2;
            bArr = str2.getBytes(cVar2.a());
        } catch (UnsupportedEncodingException e2) {
            g.log(Level.SEVERE, "encoding problem, responding nothing", (Throwable) e2);
            bArr = new byte[0];
            cVar2 = cVar3;
        }
        return a(bVar, cVar2.f26471a, new ByteArrayInputStream(bArr), bArr.length);
    }

    protected static String a(String str) {
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (UnsupportedEncodingException e2) {
            g.log(Level.WARNING, "Encoding not supported, ignored", (Throwable) e2);
            return null;
        }
    }

    protected static boolean a(n nVar) {
        if (nVar.b != null) {
            return nVar.b.toLowerCase().contains("text/") || nVar.b.toLowerCase().contains("/json");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof Socket) {
                    ((Socket) obj).close();
                } else if (!(obj instanceof ServerSocket)) {
                    throw new IllegalArgumentException("Unknown object to close");
                } else {
                    ((ServerSocket) obj).close();
                }
            } catch (IOException e2) {
                g.log(Level.SEVERE, "Could not close", (Throwable) e2);
            }
        }
    }

    public n a(l lVar) {
        HashMap hashMap = new HashMap();
        m c2 = lVar.c();
        if (m.PUT.equals(c2) || m.POST.equals(c2)) {
            try {
                lVar.a(hashMap);
            } catch (o e2) {
                return a(e2.status, "text/plain", e2.getMessage());
            } catch (IOException e3) {
                n.c cVar = n.c.INTERNAL_ERROR;
                return a(cVar, "text/plain", "SERVER INTERNAL ERROR: IOException: " + e3.getMessage());
            }
        }
        lVar.d().put("NanoHttpd.QUERY_STRING", lVar.e());
        return a(n.c.NOT_FOUND, "text/plain", "Not Found");
    }

    public final boolean a() {
        return (this.h != null && this.j != null) && !this.h.isClosed() && this.j.isAlive();
    }

    public final void b() {
        this.h = this.i.a();
        this.h.setReuseAddress(true);
        p pVar = new p();
        Thread thread = new Thread(pVar);
        this.j = thread;
        thread.setDaemon(true);
        this.j.setName("NanoHttpd Main Listener");
        this.j.start();
        while (!pVar.d && pVar.f26490c == null) {
            try {
                Thread.sleep(10L);
            } catch (Throwable th) {
            }
        }
        if (pVar.f26490c != null) {
            throw pVar.f26490c;
        }
    }

    public final void c() {
        try {
            b(this.h);
            this.f26468c.a();
            if (this.j != null) {
                this.j.join();
            }
        } catch (Exception e2) {
            g.log(Level.SEVERE, "Could not stop all connections", (Throwable) e2);
        }
    }
}
