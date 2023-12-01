package com.anythink.expressad.atsignalcommon.windvane;

import android.content.ClipDescription;
import com.huawei.openalliance.ad.constant.ax;
import com.youzan.spiderman.utils.Stone;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/windvane/h.class */
public enum h {
    JS(Stone.JS_SUFFIX, "application/x-javascript"),
    CSS(Stone.CSS_SUFFIX, "text/css"),
    JPG("jpg", ax.V),
    JPEG("jpep", ax.V),
    PNG("png", ax.Z),
    WEBP("webp", "image/webp"),
    GIF("gif", ax.B),
    HTM("htm", ClipDescription.MIMETYPE_TEXT_HTML),
    HTML(com.baidu.mobads.sdk.internal.a.f, ClipDescription.MIMETYPE_TEXT_HTML);
    
    private String j;
    private String k;

    h(String str, String str2) {
        this.j = str;
        this.k = str2;
    }

    private void a(String str) {
        this.j = str;
    }

    private void b(String str) {
        this.k = str;
    }

    public final String a() {
        return this.j;
    }

    public final String b() {
        return this.k;
    }
}
