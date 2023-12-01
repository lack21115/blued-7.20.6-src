package com.tencent.qcloud.core.http;

import com.huawei.openalliance.ad.constant.ax;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/MimeType.class */
public final class MimeType {
    private static final Map<String, String> mimeTypes;

    static {
        HashMap hashMap = new HashMap();
        mimeTypes = hashMap;
        hashMap.put("bin", "application/octet-stream");
        mimeTypes.put("bmp", "image/bmp");
        mimeTypes.put("cgm", "image/cgm");
        mimeTypes.put("djv", "image/vnd.djvu");
        mimeTypes.put("djvu", "image/vnd.djvu");
        mimeTypes.put("gif", ax.B);
        mimeTypes.put("ico", "image/x-icon");
        mimeTypes.put("ief", "image/ief");
        mimeTypes.put("jp2", "image/jp2");
        mimeTypes.put("jpe", ax.V);
        mimeTypes.put("jpeg", ax.V);
        mimeTypes.put("jpg", ax.V);
        mimeTypes.put("mac", "image/x-macpaint");
        mimeTypes.put("pbm", "image/x-portable-bitmap");
        mimeTypes.put("pct", "image/pict");
        mimeTypes.put("pgm", "image/x-portable-graymap");
        mimeTypes.put("pic", "image/pict");
        mimeTypes.put("pict", "image/pict");
        mimeTypes.put("png", ax.Z);
        mimeTypes.put("pnm", "image/x-portable-anymap");
        mimeTypes.put("pnt", "image/x-macpaint");
        mimeTypes.put("pntg", "image/x-macpaint");
        mimeTypes.put("ppm", "image/x-portable-pixmap");
        mimeTypes.put("qti", "image/x-quicktime");
        mimeTypes.put("qtif", "image/x-quicktime");
        mimeTypes.put("ras", "image/x-cmu-raster");
        mimeTypes.put("rgb", "image/x-rgb");
        mimeTypes.put("svg", "image/svg+xml");
        mimeTypes.put("tif", "image/tiff");
        mimeTypes.put("tiff", "image/tiff");
        mimeTypes.put("wbmp", "image/vnd.wap.wbmp");
        mimeTypes.put("xbm", "image/x-xbitmap");
        mimeTypes.put("xpm", "image/x-xpixmap");
        mimeTypes.put("xwd", "image/x-xwindowdump");
    }

    public static String getTypeByFileName(String str) {
        if (str == null) {
            return null;
        }
        String str2 = mimeTypes.get((str.lastIndexOf(".") != -1 ? str.substring(str.lastIndexOf(".") + 1, str.length()) : "").toLowerCase(Locale.ROOT));
        String str3 = str2;
        if (str2 == null) {
            str3 = mimeTypes.get("bin");
        }
        return str3;
    }
}
