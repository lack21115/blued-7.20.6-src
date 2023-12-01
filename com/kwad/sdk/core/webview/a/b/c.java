package com.kwad.sdk.core.webview.a.b;

import android.content.ClipDescription;
import com.huawei.openalliance.ad.constant.ax;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/a/b/c.class */
public final class c {
    private static final List<String> aqd;

    static {
        ArrayList arrayList = new ArrayList();
        aqd = arrayList;
        arrayList.add("application/x-javascript");
        aqd.add(ax.V);
        aqd.add("image/tiff");
        aqd.add("text/css");
        aqd.add(ClipDescription.MIMETYPE_TEXT_HTML);
        aqd.add(ax.B);
        aqd.add(ax.Z);
        aqd.add("application/javascript");
        aqd.add("video/mp4");
        aqd.add("audio/mpeg");
        aqd.add("application/json");
        aqd.add("image/webp");
        aqd.add("image/apng");
        aqd.add("image/svg+xml");
        aqd.add("application/octet-stream");
    }

    /* renamed from: do  reason: not valid java name */
    public static boolean m7820do(String str) {
        return aqd.contains(str);
    }
}
