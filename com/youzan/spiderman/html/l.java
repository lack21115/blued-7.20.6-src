package com.youzan.spiderman.html;

import android.net.Uri;
import com.youzan.spiderman.utils.MD5Utils;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/html/l.class */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private String f28154a;
    private Uri b;

    /* renamed from: c  reason: collision with root package name */
    private String f28155c;

    public l(Uri uri) {
        String uri2 = uri.toString();
        this.f28154a = uri2;
        this.b = uri;
        this.f28155c = MD5Utils.getStringMd5(uri2);
    }

    public l(String str) {
        this.f28154a = str;
        this.b = Uri.parse(str);
        this.f28155c = MD5Utils.getStringMd5(str);
    }

    public final String a() {
        return this.f28154a;
    }

    public final Uri b() {
        return this.b;
    }

    public final String c() {
        return this.f28155c;
    }
}
