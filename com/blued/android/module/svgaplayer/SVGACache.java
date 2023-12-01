package com.blued.android.module.svgaplayer;

import android.content.Context;
import com.anythink.core.common.k.f;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.svgaplayer.utils.log.LogUtils;
import java.io.File;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGACache.class */
public final class SVGACache {
    public static final SVGACache a = new SVGACache();
    private static Type b = Type.FILE;
    private static String c = BridgeUtil.SPLIT_MARK;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGACache$Type.class */
    public enum Type {
        DEFAULT,
        FILE
    }

    private SVGACache() {
    }

    private final String c() {
        if (!Intrinsics.a((Object) c, (Object) BridgeUtil.SPLIT_MARK)) {
            File file = new File(c);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return c;
    }

    public final String a(URL url) {
        Intrinsics.e(url, "url");
        String url2 = url.toString();
        Intrinsics.c(url2, "url.toString()");
        return c(url2);
    }

    public final void a(Context context) {
        a(context, Type.FILE);
    }

    public final void a(Context context, Type type) {
        File externalCacheDir;
        Intrinsics.e(type, "type");
        if (a() || context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return;
        }
        c = externalCacheDir.getAbsolutePath() + "/svga/";
        File file = new File(a.c());
        if (!(!file.exists())) {
            file = null;
        }
        if (file != null) {
            file.mkdirs();
        }
        b = type;
    }

    public final void a(String path) {
        File[] listFiles;
        Intrinsics.e(path, "path");
        try {
            File file = new File(path);
            if (!file.exists()) {
                file = null;
            }
            if (file == null || (listFiles = file.listFiles()) == null) {
                return;
            }
            Intrinsics.c(listFiles, "listFiles()");
            for (File file2 : listFiles) {
                if (file2.exists()) {
                    if (file2.isDirectory()) {
                        SVGACache sVGACache = a;
                        String absolutePath = file2.getAbsolutePath();
                        Intrinsics.c(absolutePath, "file.absolutePath");
                        sVGACache.a(absolutePath);
                    }
                    file2.delete();
                }
            }
        } catch (Exception e) {
            LogUtils.a.a("SVGACache", "Clear svga cache path: " + path + " fail", e);
        }
    }

    public final boolean a() {
        return !Intrinsics.a((Object) BridgeUtil.SPLIT_MARK, (Object) c()) && new File(c()).exists();
    }

    public final boolean b() {
        return b == Type.DEFAULT;
    }

    public final boolean b(String cacheKey) {
        Intrinsics.e(cacheKey, "cacheKey");
        return (b() ? d(cacheKey) : e(cacheKey)).exists();
    }

    public final String c(String str) {
        Intrinsics.e(str, "str");
        MessageDigest messageDigest = MessageDigest.getInstance(f.a);
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.c(forName, "forName(charsetName)");
        byte[] bytes = str.getBytes(forName);
        Intrinsics.c(bytes, "this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
        byte[] digest = messageDigest.digest();
        Intrinsics.c(digest, "digest");
        int length = digest.length;
        String str2 = "";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return str2;
            }
            byte b2 = digest[i2];
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b2)}, 1));
            Intrinsics.c(format, "format(format, *args)");
            sb.append(format);
            str2 = sb.toString();
            i = i2 + 1;
        }
    }

    public final File d(String cacheKey) {
        Intrinsics.e(cacheKey, "cacheKey");
        return new File(c() + cacheKey + '/');
    }

    public final File e(String cacheKey) {
        Intrinsics.e(cacheKey, "cacheKey");
        return new File(c() + cacheKey + ".svga");
    }

    public final File f(String audio) {
        Intrinsics.e(audio, "audio");
        return new File(c() + audio + ".mp3");
    }
}
