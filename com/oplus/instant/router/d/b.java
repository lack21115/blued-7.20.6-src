package com.oplus.instant.router.d;

import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.OapsWrapper;
import com.google.common.net.HttpHeaders;
import com.oplus.instant.router.Instant;
import com.oplus.instant.router.callback.Callback;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/d/b.class */
public class b extends Instant.Builder {

    /* renamed from: a  reason: collision with root package name */
    Map<String, String> f24287a = new HashMap();
    Map<String, String> b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    Map<String, String> f24288c = null;
    Map<String, String> d = null;
    Callback e;
    String f;

    public b(String str, String str2) {
        b(str);
        a(str2);
    }

    private Instant.Builder a(String str) {
        this.b.put("secret", str);
        return this;
    }

    private Instant.Builder b(String str) {
        this.b.put(HttpHeaders.ReferrerPolicyValues.ORIGIN, str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Req build() {
        return (TextUtils.isEmpty(this.f) || this.f.startsWith("oaps://instant/app")) ? new d(this) : new e(this);
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder putExtra(String str, String str2) {
        if (this.d == null) {
            this.d = new HashMap();
        }
        this.d.put(str, str2);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder putParams(String str, String str2) {
        this.b.put(str, str2);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder putStat(String str, String str2) {
        if (this.f24288c == null) {
            this.f24288c = new HashMap();
        }
        this.f24288c.put(str, str2);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder setCallback(Callback callback) {
        this.e = callback;
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder setExtra(String str) {
        this.f24287a.put("ext", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder setFrom(String str) {
        this.f24287a.put("f", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    @Deprecated
    public Instant.Builder setPackage(String str) {
        this.f24287a.put("pkg", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    @Deprecated
    public Instant.Builder setPage(String str) {
        this.f24287a.put(WBPageConstants.ParamKey.PAGE, str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    @Deprecated
    public Instant.Builder setPath(String str) {
        this.f24287a.put(OapsWrapper.KEY_PATH, str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder setRequestUrl(String str) {
        this.f = str;
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder signAsPlatform() {
        this.b.put(OapsKey.KEY_SIGN_TYPE, "1");
        return this;
    }
}
