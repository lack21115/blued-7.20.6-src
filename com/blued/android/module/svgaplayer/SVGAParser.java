package com.blued.android.module.svgaplayer;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.http.HttpResponseCache;
import android.os.Handler;
import android.os.Looper;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.cache.SVGAVideoDataCache;
import com.blued.android.module.svgaplayer.entities.SVGAVideoData;
import com.blued.android.module.svgaplayer.proto.MovieEntity;
import com.blued.android.module.svgaplayer.utils.log.LogUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGAParser.class */
public final class SVGAParser {

    /* renamed from: a */
    public static final Companion f15958a = new Companion(null);
    private static final AtomicInteger f = new AtomicInteger(0);
    private static SVGAParser g = new SVGAParser(null);
    private static ExecutorService h = Executors.newCachedThreadPool(new ThreadFactory() { // from class: com.blued.android.module.svgaplayer.-$$Lambda$SVGAParser$XkPHVMZfsDpBcVegQ9rnVEcvNc0
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread a2;
            a2 = SVGAParser.a(runnable);
            return a2;
        }
    });
    private Context b;

    /* renamed from: c */
    private volatile int f15959c;
    private volatile int d;
    private FileDownloader e;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGAParser$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ExecutorService a() {
            return SVGAParser.h;
        }

        public final SVGAParser b() {
            return SVGAParser.g;
        }
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGAParser$FileDownloader.class */
    public static class FileDownloader {

        /* renamed from: a */
        private boolean f15960a;

        public static final void a(FileDownloader this$0, URL url, Function1 failure, Ref.BooleanRef cancelled, Function1 complete) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(url, "$url");
            Intrinsics.e(failure, "$failure");
            Intrinsics.e(cancelled, "$cancelled");
            Intrinsics.e(complete, "$complete");
            try {
                LogUtils.f16034a.a("SVGAParser", "================ svga file download start ================");
                if (HttpResponseCache.getInstalled() == null && !this$0.f15960a) {
                    LogUtils.f16034a.d("SVGAParser", "SVGAParser can not handle cache before install HttpResponseCache. see https://github.com/yyued/SVGAPlayer-Android#cache");
                    LogUtils.f16034a.d("SVGAParser", "在配置 HttpResponseCache 前 SVGAParser 无法缓存. 查看 https://github.com/yyued/SVGAPlayer-Android#cache ");
                }
                URLConnection openConnection = url.openConnection();
                HttpURLConnection httpURLConnection = openConnection instanceof HttpURLConnection ? (HttpURLConnection) openConnection : null;
                if (httpURLConnection != null) {
                    httpURLConnection.setConnectTimeout(20000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("Connection", "close");
                    httpURLConnection.connect();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    InputStream inputStream2 = inputStream;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                    byte[] bArr = new byte[4096];
                    while (true) {
                        if (cancelled.f42538a) {
                            LogUtils.f16034a.c("SVGAParser", "================ svga file download canceled ================");
                            break;
                        }
                        int read = inputStream2.read(bArr, 0, 4096);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr, 0, read);
                    }
                    if (cancelled.f42538a) {
                        LogUtils.f16034a.c("SVGAParser", "================ svga file download canceled ================");
                        CloseableKt.a(byteArrayOutputStream, null);
                        CloseableKt.a(inputStream, null);
                        return;
                    }
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream2.toByteArray());
                    try {
                        LogUtils.f16034a.a("SVGAParser", "================ svga file download complete ================");
                        complete.invoke(byteArrayInputStream);
                        Unit unit = Unit.f42314a;
                        CloseableKt.a(byteArrayInputStream, null);
                        Unit unit2 = Unit.f42314a;
                        CloseableKt.a(byteArrayOutputStream, null);
                        Unit unit3 = Unit.f42314a;
                        CloseableKt.a(inputStream, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.a(byteArrayInputStream, th);
                            throw th2;
                        }
                    }
                }
            } catch (Exception e) {
                LogUtils.f16034a.d("SVGAParser", "================ svga file download fail ================");
                LogUtils logUtils = LogUtils.f16034a;
                logUtils.d("SVGAParser", "error: " + e.getMessage());
                e.printStackTrace();
                failure.invoke(e);
            }
        }

        public Function0<Unit> a(final URL url, final Function1<? super InputStream, Unit> complete, final Function1<? super Exception, Unit> failure) {
            Intrinsics.e(url, "url");
            Intrinsics.e(complete, "complete");
            Intrinsics.e(failure, "failure");
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.blued.android.module.svgaplayer.SVGAParser$FileDownloader$resume$cancelBlock$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final void a() {
                    Ref.BooleanRef.this.f42538a = true;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* synthetic */ Unit invoke() {
                    a();
                    return Unit.f42314a;
                }
            };
            SVGAParser.f15958a.a().execute(new Runnable() { // from class: com.blued.android.module.svgaplayer.-$$Lambda$SVGAParser$FileDownloader$wQZVDxKSvjaYWxG_yIjnHwxK9nI
                @Override // java.lang.Runnable
                public final void run() {
                    SVGAParser.FileDownloader.a(SVGAParser.FileDownloader.this, url, failure, booleanRef, complete);
                }
            });
            return function0;
        }
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGAParser$ParseCompletion.class */
    public interface ParseCompletion {
        void onComplete(SVGAVideoEntity sVGAVideoEntity);

        void onError();
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGAParser$PlayCallback.class */
    public interface PlayCallback {
        void a(List<? extends File> list);
    }

    public SVGAParser(Context context) {
        this.b = context != null ? context.getApplicationContext() : null;
        SVGACache.f15940a.a(context);
        this.e = new FileDownloader();
    }

    public static final Thread a(Runnable runnable) {
        return new Thread(runnable, "SVGAParser-Thread-" + f.getAndIncrement());
    }

    public static /* synthetic */ Function0 a(SVGAParser sVGAParser, URL url, ParseCompletion parseCompletion, PlayCallback playCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            playCallback = null;
        }
        return sVGAParser.a(url, parseCompletion, playCallback);
    }

    public static final void a(ParseCompletion parseCompletion) {
        if (parseCompletion != null) {
            parseCompletion.onError();
        }
    }

    public static final void a(SVGAParser this$0, String name, ParseCompletion parseCompletion, PlayCallback playCallback) {
        AssetManager assets;
        InputStream open;
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(name, "$name");
        try {
            Context context = this$0.b;
            if (context == null || (assets = context.getAssets()) == null || (open = assets.open(name)) == null) {
                return;
            }
            SVGACache sVGACache = SVGACache.f15940a;
            this$0.a(open, sVGACache.c("file:///assets/" + name), parseCompletion, true, playCallback, name);
        } catch (Exception e) {
            this$0.a(e, parseCompletion, name);
        }
    }

    public static /* synthetic */ void a(SVGAParser sVGAParser, String str, ParseCompletion parseCompletion, PlayCallback playCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            playCallback = null;
        }
        sVGAParser.a(str, parseCompletion, playCallback);
    }

    public static final void a(SVGAParser this$0, String cacheKey, ParseCompletion parseCompletion, String urlPath, PlayCallback playCallback) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(cacheKey, "$cacheKey");
        Intrinsics.e(urlPath, "$urlPath");
        if (SVGACache.f15940a.b()) {
            this$0.a(cacheKey, parseCompletion, urlPath);
        } else {
            this$0.a(cacheKey, parseCompletion, playCallback, urlPath);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:140:0x00bb, code lost:
        if (r0 != false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(com.blued.android.module.svgaplayer.SVGAParser r7, final java.lang.String r8, com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion r9, java.lang.String r10, com.blued.android.module.svgaplayer.SVGAParser.PlayCallback r11, boolean r12, java.io.InputStream r13) {
        /*
            Method dump skipped, instructions count: 620
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.svgaplayer.SVGAParser.a(com.blued.android.module.svgaplayer.SVGAParser, java.lang.String, com.blued.android.module.svgaplayer.SVGAParser$ParseCompletion, java.lang.String, com.blued.android.module.svgaplayer.SVGAParser$PlayCallback, boolean, java.io.InputStream):void");
    }

    public final void a(final SVGAVideoEntity sVGAVideoEntity, final ParseCompletion parseCompletion, final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.blued.android.module.svgaplayer.-$$Lambda$SVGAParser$wac3Yh39HPzOfIwSehEue7UTL7Y
            @Override // java.lang.Runnable
            public final void run() {
                SVGAParser.a(String.this, parseCompletion, sVGAVideoEntity);
            }
        });
    }

    private final void a(File file, String str) {
        String dstDirCanonicalPath = new File(str).getCanonicalPath();
        String outputFileCanonicalPath = file.getCanonicalPath();
        Intrinsics.c(outputFileCanonicalPath, "outputFileCanonicalPath");
        Intrinsics.c(dstDirCanonicalPath, "dstDirCanonicalPath");
        if (StringsKt.a(outputFileCanonicalPath, dstDirCanonicalPath, false, 2, (Object) null)) {
            return;
        }
        throw new IOException("Found Zip Path Traversal Vulnerability with " + dstDirCanonicalPath);
    }

    private final void a(FileInputStream fileInputStream, File file, ParseCompletion parseCompletion, String str, String str2) {
        LogUtils.f16034a.a("SVGAParser", "decode:: SVGAVideoEntity  start");
        SVGAVideoDataDecode sVGAVideoDataDecode = SVGAVideoDataDecode.f15977a;
        MovieEntity decode = MovieEntity.ADAPTER.decode(fileInputStream);
        Intrinsics.c(decode, "ADAPTER.decode(it)");
        SVGAVideoData a2 = sVGAVideoDataDecode.a(decode, file, this.f15959c, this.d);
        a(new SVGAVideoEntity(a2), parseCompletion, str);
        SVGAVideoDataCache.f15986a.a(this.b).a(str2, a2);
    }

    private final void a(InputStream inputStream, String str) {
        LogUtils.f16034a.a("SVGAParser", "================ unzip prepare ================");
        File d = SVGACache.f15940a.d(str);
        d.mkdirs();
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream);
            try {
                ZipInputStream zipInputStream2 = zipInputStream;
                while (true) {
                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry == null) {
                        Unit unit = Unit.f42314a;
                        CloseableKt.a(zipInputStream, null);
                        Unit unit2 = Unit.f42314a;
                        CloseableKt.a(bufferedInputStream, null);
                        return;
                    }
                    Intrinsics.c(nextEntry, "zipInputStream.nextEntry ?: break");
                    String name = nextEntry.getName();
                    Intrinsics.c(name, "zipItem.name");
                    if (!StringsKt.c((CharSequence) name, (CharSequence) "../", false, 2, (Object) null)) {
                        String name2 = nextEntry.getName();
                        Intrinsics.c(name2, "zipItem.name");
                        if (!StringsKt.c((CharSequence) name2, (CharSequence) BridgeUtil.SPLIT_MARK, false, 2, (Object) null)) {
                            File file = new File(d, nextEntry.getName());
                            String absolutePath = d.getAbsolutePath();
                            Intrinsics.c(absolutePath, "cacheDir.absolutePath");
                            a(file, absolutePath);
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            FileOutputStream fileOutputStream2 = fileOutputStream;
                            byte[] bArr = new byte[2048];
                            while (true) {
                                int read = zipInputStream2.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, read);
                            }
                            Unit unit3 = Unit.f42314a;
                            CloseableKt.a(fileOutputStream, null);
                            LogUtils.f16034a.d("SVGAParser", "================ unzip complete ================");
                            zipInputStream2.closeEntry();
                        }
                    }
                }
            } finally {
            }
        } catch (Exception e) {
            LogUtils.f16034a.d("SVGAParser", "================ unzip error ================");
            LogUtils.f16034a.a("SVGAParser", "error", e);
            SVGACache sVGACache = SVGACache.f15940a;
            String absolutePath2 = d.getAbsolutePath();
            Intrinsics.c(absolutePath2, "cacheDir.absolutePath");
            sVGACache.a(absolutePath2);
            d.delete();
            throw e;
        }
    }

    public final void a(Exception exc, final ParseCompletion parseCompletion, String str) {
        exc.printStackTrace();
        LogUtils logUtils = LogUtils.f16034a;
        logUtils.d("SVGAParser", "================ " + str + " parser error ================");
        LogUtils logUtils2 = LogUtils.f16034a;
        logUtils2.a("SVGAParser", str + " parse error", exc);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.blued.android.module.svgaplayer.-$$Lambda$SVGAParser$Gxntlm-OW1gMQ8qqVQs8Yh_-Wcs
            @Override // java.lang.Runnable
            public final void run() {
                SVGAParser.a(SVGAParser.ParseCompletion.this);
            }
        });
    }

    public static final void a(String str, ParseCompletion parseCompletion, SVGAVideoEntity videoItem) {
        Intrinsics.e(videoItem, "$videoItem");
        LogUtils logUtils = LogUtils.f16034a;
        logUtils.a("SVGAParser", "================ " + str + " parser complete ================");
        if (parseCompletion != null) {
            parseCompletion.onComplete(videoItem);
        }
    }

    private final void a(String str, ParseCompletion parseCompletion, String str2) {
        FileInputStream fileInputStream;
        LogUtils.f16034a.a("SVGAParser", "================ decode " + str2 + " from cache ================");
        LogUtils.f16034a.b("SVGAParser", "decodeFromCacheKey called with cacheKey : " + str);
        if (this.b == null) {
            LogUtils.f16034a.d("SVGAParser", "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
            return;
        }
        try {
            if (a(str, parseCompletion, str2, (PlayCallback) null)) {
                return;
            }
            synchronized (str) {
                if (a(str, parseCompletion, str2, (PlayCallback) null)) {
                    return;
                }
                File d = SVGACache.f15940a.d(str);
                File file = new File(d, "movie.binary");
                if (!file.isFile()) {
                    file = null;
                }
                if (file != null) {
                    try {
                        LogUtils.f16034a.a("SVGAParser", "binary change to entity");
                        fileInputStream = new FileInputStream(file);
                        try {
                            LogUtils.f16034a.a("SVGAParser", "binary change to entity success");
                            a(fileInputStream, d, parseCompletion, str2, str);
                            Unit unit = Unit.f42314a;
                            CloseableKt.a(fileInputStream, null);
                        } finally {
                        }
                    } catch (Exception e) {
                        LogUtils.f16034a.a("SVGAParser", "binary change to entity fail", e);
                        d.delete();
                        file.delete();
                        throw e;
                    }
                }
                File file2 = new File(d, "movie.spec");
                if (!file2.isFile()) {
                    file2 = null;
                }
                if (file2 != null) {
                    try {
                        LogUtils.f16034a.a("SVGAParser", "spec change to entity");
                        fileInputStream = new FileInputStream(file2);
                        try {
                            FileInputStream fileInputStream2 = fileInputStream;
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                            byte[] bArr = new byte[2048];
                            while (true) {
                                int read = fileInputStream2.read(bArr, 0, 2048);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr, 0, read);
                            }
                            JSONObject jSONObject = new JSONObject(byteArrayOutputStream2.toString());
                            LogUtils.f16034a.a("SVGAParser", "spec change to entity success");
                            a(jSONObject, d, parseCompletion, str2, str);
                            Unit unit2 = Unit.f42314a;
                            CloseableKt.a(byteArrayOutputStream, null);
                            Unit unit3 = Unit.f42314a;
                            CloseableKt.a(fileInputStream, null);
                            Unit unit4 = Unit.f42314a;
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    } catch (Exception e2) {
                        LogUtils.f16034a.a("SVGAParser", str2 + " movie.spec change to entity fail", e2);
                        d.delete();
                        file2.delete();
                        throw e2;
                    }
                }
            }
        } catch (Exception e3) {
            a(e3, parseCompletion, str2);
        }
    }

    public static final void a(String str, SVGAParser this$0, String cacheKey, ParseCompletion parseCompletion, PlayCallback playCallback) {
        LogUtils logUtils;
        StringBuilder sb;
        Unit unit;
        Unit unit2;
        LogUtils logUtils2;
        StringBuilder sb2;
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(cacheKey, "$cacheKey");
        try {
            try {
                LogUtils.f16034a.a("SVGAParser", "decodeFromSVGAFileCacheKey:: ================ decode " + str + " from svga cachel file to entity ================");
            } catch (Exception e) {
                this$0.a(e, parseCompletion, str);
                logUtils = LogUtils.f16034a;
                sb = new StringBuilder();
            }
            if (this$0.a(cacheKey, parseCompletion, str, playCallback)) {
                logUtils2 = LogUtils.f16034a;
                sb2 = new StringBuilder();
            } else {
                synchronized (cacheKey) {
                    if (!this$0.a(cacheKey, parseCompletion, str, playCallback)) {
                        FileInputStream fileInputStream = new FileInputStream(SVGACache.f15940a.e(cacheKey));
                        byte[] a2 = this$0.a(fileInputStream);
                        if (a2 != null) {
                            if (this$0.b(a2)) {
                                this$0.a(cacheKey, parseCompletion, str);
                            } else {
                                LogUtils.f16034a.a("SVGAParser", "inflate start");
                                byte[] a3 = this$0.a(a2);
                                if (a3 != null) {
                                    LogUtils.f16034a.a("SVGAParser", "inflate complete");
                                    this$0.a(a3, cacheKey, parseCompletion, str, playCallback);
                                    unit2 = Unit.f42314a;
                                } else {
                                    unit2 = null;
                                }
                                if (unit2 == null) {
                                    this$0.a(new Exception("inflate(bytes) cause exception"), parseCompletion, str);
                                }
                            }
                            unit = Unit.f42314a;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            this$0.a(new Exception("readAsBytes(inputStream) cause exception"), parseCompletion, str);
                        }
                        Unit unit3 = Unit.f42314a;
                        CloseableKt.a(fileInputStream, null);
                        Unit unit4 = Unit.f42314a;
                        logUtils = LogUtils.f16034a;
                        sb = new StringBuilder();
                        sb.append("decodeFromURL:: ================ decode ");
                        sb.append(str);
                        sb.append(" from svga cachel file to entity end ================");
                        logUtils.a("SVGAParser", sb.toString());
                        return;
                    }
                    logUtils2 = LogUtils.f16034a;
                    sb2 = new StringBuilder();
                }
            }
            sb2.append("decodeFromURL:: ================ decode ");
            sb2.append(str);
            sb2.append(" from svga cachel file to entity end ================");
            logUtils2.a("SVGAParser", sb2.toString());
        } catch (Throwable th) {
            LogUtils.f16034a.a("SVGAParser", "decodeFromURL:: ================ decode " + str + " from svga cachel file to entity end ================");
            throw th;
        }
    }

    public static final void a(String cacheKey, byte[] bytes) {
        Intrinsics.e(cacheKey, "$cacheKey");
        Intrinsics.e(bytes, "$bytes");
        File e = SVGACache.f15940a.e(cacheKey);
        try {
            File file = e.exists() ^ true ? e : null;
            if (file != null) {
                file.createNewFile();
            }
            new FileOutputStream(e).write(bytes);
        } catch (Exception e2) {
            LogUtils.f16034a.a("SVGAParser", "create cache file fail.", e2);
            e.delete();
        }
    }

    private final void a(JSONObject jSONObject, File file, ParseCompletion parseCompletion, String str, String str2) {
        LogUtils.f16034a.a("SVGAParser", "decodeFromJson:: SVGAVideoEntity  start");
        SVGAVideoData a2 = SVGAVideoDataDecode.f15977a.a(jSONObject, file, this.f15959c, this.d);
        a(new SVGAVideoEntity(a2), parseCompletion, str);
        SVGAVideoDataCache.f15986a.a(this.b).a(str2, a2);
    }

    private final void a(byte[] bArr, String str, final ParseCompletion parseCompletion, final String str2, PlayCallback playCallback) {
        LogUtils.f16034a.a("SVGAParser", "decode:: SVGAVideoEntity  start");
        SVGAVideoDataDecode sVGAVideoDataDecode = SVGAVideoDataDecode.f15977a;
        MovieEntity decode = MovieEntity.ADAPTER.decode(bArr);
        Intrinsics.c(decode, "ADAPTER.decode(it)");
        SVGAVideoData a2 = sVGAVideoDataDecode.a(decode, new File(str), this.f15959c, this.d);
        final SVGAVideoEntity sVGAVideoEntity = new SVGAVideoEntity(a2);
        sVGAVideoEntity.a(new Function0<Unit>() { // from class: com.blued.android.module.svgaplayer.SVGAParser$decode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final void a() {
                LogUtils.f16034a.a("SVGAParser", "decode:: SVGAVideoEntity prepare success");
                SVGAParser.this.a(sVGAVideoEntity, parseCompletion, str2);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* synthetic */ Unit invoke() {
                a();
                return Unit.f42314a;
            }
        }, playCallback);
        SVGAVideoDataCache.f15986a.a(this.b).a(str, a2);
    }

    private final boolean a(String str, final ParseCompletion parseCompletion, final String str2, PlayCallback playCallback) {
        SVGAVideoData a2 = SVGAVideoDataCache.f15986a.a(this.b).a(str);
        if (a2 != null) {
            LogUtils logUtils = LogUtils.f16034a;
            logUtils.a("SVGAParser", "getCache:: cacheKey = " + str + " SVGAVideoEntity get from cache success");
            final SVGAVideoEntity sVGAVideoEntity = new SVGAVideoEntity(a2);
            LogUtils.f16034a.a("SVGAParser", "getCache::SVGAVideoEntity prepare start");
            sVGAVideoEntity.a(new Function0<Unit>() { // from class: com.blued.android.module.svgaplayer.SVGAParser$getCache$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final void a() {
                    LogUtils.f16034a.a("SVGAParser", "getCache:: SVGAVideoEntity prepare success");
                    SVGAParser.this.a(sVGAVideoEntity, parseCompletion, str2);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* synthetic */ Unit invoke() {
                    a();
                    return Unit.f42314a;
                }
            }, playCallback);
            return true;
        }
        return false;
    }

    private final byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
            byte[] bArr = new byte[2048];
            while (true) {
                int read = inputStream.read(bArr, 0, 2048);
                if (read <= 0) {
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    CloseableKt.a(byteArrayOutputStream, null);
                    return byteArray;
                }
                byteArrayOutputStream2.write(bArr, 0, read);
            }
        } finally {
        }
    }

    private final byte[] a(byte[] bArr) {
        Inflater inflater = new Inflater();
        inflater.setInput(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[2048];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
            while (true) {
                int inflate = inflater.inflate(bArr2, 0, 2048);
                if (inflate <= 0) {
                    inflater.end();
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    CloseableKt.a(byteArrayOutputStream, null);
                    return byteArray;
                }
                byteArrayOutputStream2.write(bArr2, 0, inflate);
            }
        } finally {
        }
    }

    private final boolean b(byte[] bArr) {
        return bArr.length > 4 && bArr[0] == 80 && bArr[1] == 75 && bArr[2] == 3 && bArr[3] == 4;
    }

    public final Function0<Unit> a(URL url, ParseCompletion parseCompletion, PlayCallback playCallback) {
        Intrinsics.e(url, "url");
        return a(url, (String) null, parseCompletion, playCallback);
    }

    public final Function0<Unit> a(final URL url, String str, final ParseCompletion parseCompletion, final PlayCallback playCallback) {
        String a2;
        Intrinsics.e(url, "url");
        if (this.b == null) {
            LogUtils.f16034a.d("SVGAParser", "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
            return null;
        }
        final String url2 = url.toString();
        Intrinsics.c(url2, "url.toString()");
        LogUtils logUtils = LogUtils.f16034a;
        logUtils.a("SVGAParser", "================ decode from url: " + url2 + " ================");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            a2 = SVGACache.f15940a.a(url);
        } else {
            SVGACache sVGACache = SVGACache.f15940a;
            a2 = sVGACache.c(url.toString() + str);
        }
        if (!SVGACache.f15940a.b(a2)) {
            LogUtils.f16034a.a("SVGAParser", "no cached, prepare to download");
            final String str3 = a2;
            return this.e.a(url, new Function1<InputStream, Unit>() { // from class: com.blued.android.module.svgaplayer.SVGAParser$decodeFromURL$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void a(InputStream it) {
                    Intrinsics.e(it, "it");
                    SVGAParser.this.a(it, str3, parseCompletion, false, playCallback, url2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(InputStream inputStream) {
                    a(inputStream);
                    return Unit.f42314a;
                }
            }, new Function1<Exception, Unit>() { // from class: com.blued.android.module.svgaplayer.SVGAParser$decodeFromURL$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void a(Exception it) {
                    Intrinsics.e(it, "it");
                    LogUtils logUtils2 = LogUtils.f16034a;
                    logUtils2.d("SVGAParser", "================ svga file: " + URL.this + " download fail ================");
                    this.a(it, parseCompletion, url2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(Exception exc) {
                    a(exc);
                    return Unit.f42314a;
                }
            });
        }
        LogUtils.f16034a.a("SVGAParser", "this url cached");
        final String str4 = a2;
        h.execute(new Runnable() { // from class: com.blued.android.module.svgaplayer.-$$Lambda$SVGAParser$JHa5sL8-rvnNQ0FRe2RrYVMdEHE
            @Override // java.lang.Runnable
            public final void run() {
                SVGAParser.a(SVGAParser.this, str4, parseCompletion, url2, playCallback);
            }
        });
        return null;
    }

    public final void a(Context context) {
        Intrinsics.e(context, "context");
        this.b = context.getApplicationContext();
        SVGACache.f15940a.a(this.b);
    }

    public final void a(final InputStream inputStream, final String cacheKey, final ParseCompletion parseCompletion, final boolean z, final PlayCallback playCallback, final String str) {
        Intrinsics.e(inputStream, "inputStream");
        Intrinsics.e(cacheKey, "cacheKey");
        if (this.b == null) {
            LogUtils.f16034a.d("SVGAParser", "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
            return;
        }
        LogUtils logUtils = LogUtils.f16034a;
        logUtils.a("SVGAParser", "decodeFromInputStream:: ================ decode " + str + " from input stream ================");
        h.execute(new Runnable() { // from class: com.blued.android.module.svgaplayer.-$$Lambda$SVGAParser$vk2x-263PiPyAsfRbd-ZQehRYnc
            @Override // java.lang.Runnable
            public final void run() {
                SVGAParser.a(SVGAParser.this, cacheKey, parseCompletion, str, playCallback, z, inputStream);
            }
        });
    }

    public final void a(final String name, final ParseCompletion parseCompletion, final PlayCallback playCallback) {
        Intrinsics.e(name, "name");
        if (this.b == null) {
            LogUtils.f16034a.d("SVGAParser", "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
            return;
        }
        LogUtils logUtils = LogUtils.f16034a;
        logUtils.a("SVGAParser", "================ decode " + name + " from assets ================");
        h.execute(new Runnable() { // from class: com.blued.android.module.svgaplayer.-$$Lambda$SVGAParser$5eWBplm59I2ZEBrBH6iSVspKam4
            @Override // java.lang.Runnable
            public final void run() {
                SVGAParser.a(SVGAParser.this, name, parseCompletion, playCallback);
            }
        });
    }

    public final void a(final String cacheKey, final ParseCompletion parseCompletion, final PlayCallback playCallback, final String str) {
        Intrinsics.e(cacheKey, "cacheKey");
        h.execute(new Runnable() { // from class: com.blued.android.module.svgaplayer.-$$Lambda$SVGAParser$EwL60lZCwJmj8NQn0xDs8k8WaPE
            @Override // java.lang.Runnable
            public final void run() {
                SVGAParser.a(String.this, this, cacheKey, parseCompletion, playCallback);
            }
        });
    }
}
