package com.youzan.spiderman.cache;

import android.net.Uri;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.youzan.spiderman.utils.MD5Utils;
import com.youzan.spiderman.utils.Stone;
import com.youzan.spiderman.utils.UriUtil;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/cache/CacheUrl.class */
public class CacheUrl {

    /* renamed from: a  reason: collision with root package name */
    private Uri f41789a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f41790c;

    public CacheUrl(Uri uri) {
        this.f41789a = uri;
        this.b = UriUtil.getUriExtend(uri);
        Uri.Builder builder = new Uri.Builder();
        builder.path(uri.getPath());
        boolean z = true;
        if ((!this.b.equals(Stone.CSS_SUFFIX) || !a(uri.getLastPathSegment(), 32)) && (!this.b.equals(Stone.JS_SUFFIX) || !a(uri.getLastPathSegment(), 10))) {
            z = false;
        }
        if (!z) {
            builder.query(uri.getQuery()).fragment(uri.getFragment());
        }
        this.f41790c = MD5Utils.getStringMd5(builder.toString());
    }

    private static boolean a(String str, int i) {
        String[] split = str.split(BridgeUtil.UNDERLINE_STR);
        return split[split.length - 1].length() == i;
    }

    public String getExtend() {
        return this.b;
    }

    public String getMd5() {
        return this.f41790c;
    }

    public Uri getUri() {
        return this.f41789a;
    }

    public boolean isImg() {
        return UriUtil.isImg(this.b);
    }

    public boolean isScript() {
        return UriUtil.isScript(this.b);
    }
}
