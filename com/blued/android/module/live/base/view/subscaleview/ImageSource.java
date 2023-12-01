package com.blued.android.module.live.base.view.subscaleview;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/ImageSource.class */
public final class ImageSource {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f11550a;
    private final Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private final Integer f11551c;
    private boolean d;
    private int e;
    private int f;
    private Rect g;
    private boolean h;

    private ImageSource(int i) {
        this.b = null;
        this.f11550a = null;
        this.f11551c = Integer.valueOf(i);
        this.d = true;
    }

    private ImageSource(Uri uri) {
        String uri2 = uri.toString();
        Uri uri3 = uri;
        if (uri2.startsWith("file:///")) {
            uri3 = uri;
            if (!new File(uri2.substring(7)).exists()) {
                try {
                    uri3 = Uri.parse(URLDecoder.decode(uri2, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    uri3 = uri;
                }
            }
        }
        this.b = null;
        this.f11550a = uri3;
        this.f11551c = null;
        this.d = true;
    }

    public static ImageSource a(int i) {
        return new ImageSource(i);
    }

    public static ImageSource a(String str) {
        if (str != null) {
            return b("file:///android_asset/" + str);
        }
        throw new NullPointerException("Asset name must not be null");
    }

    public static ImageSource b(String str) {
        if (str != null) {
            String str2 = str;
            if (!str.contains("://")) {
                String str3 = str;
                if (str.startsWith(BridgeUtil.SPLIT_MARK)) {
                    str3 = str.substring(1);
                }
                str2 = "file:///" + str3;
            }
            return new ImageSource(Uri.parse(str2));
        }
        throw new NullPointerException("Uri must not be null");
    }

    public ImageSource a() {
        return a(true);
    }

    public ImageSource a(boolean z) {
        this.d = z;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Uri b() {
        return this.f11550a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Bitmap c() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Integer d() {
        return this.f11551c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean e() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int f() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int g() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Rect h() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean i() {
        return this.h;
    }
}
