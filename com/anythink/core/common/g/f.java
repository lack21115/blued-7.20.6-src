package com.anythink.core.common.g;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.e.an;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/g/f.class */
public final class f extends a {
    public static final int e = 1;

    /* renamed from: a  reason: collision with root package name */
    String f6725a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    String f6726c;
    int d;
    private an f;

    private f(String str) {
        this.d = 0;
        this.f6725a = str;
    }

    private f(String str, int i, String str2) {
        this(str);
        this.d = 1;
        this.b = i;
        this.f6726c = str2;
    }

    public static f a(String str, int i, String str2) {
        return new f(str, i, str2);
    }

    public static f b(String str) {
        return new f(str);
    }

    @Override // com.anythink.core.common.g.a
    protected final int a() {
        return 2;
    }

    @Override // com.anythink.core.common.g.a
    protected final Object a(String str) {
        an anVar;
        if (1 != this.d || (anVar = this.f) == null) {
            return null;
        }
        anVar.a(BasicPushStatus.SUCCESS_CODE);
        com.anythink.core.common.j.c.a(this.f);
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final void a(AdError adError) {
    }

    public final void a(an anVar) {
        this.f = anVar;
    }

    @Override // com.anythink.core.common.g.a
    protected final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.g.a
    protected final String b() {
        return this.f6725a;
    }

    @Override // com.anythink.core.common.g.a
    protected final void b(AdError adError) {
        an anVar;
        if (1 == this.d && ErrorCode.httpStatuException.equals(adError.getCode()) && (anVar = this.f) != null) {
            anVar.a(adError.getPlatformCode());
            this.f.b(adError.getPlatformMSG());
            com.anythink.core.common.j.c.a(this.f);
        }
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, String> c() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final byte[] d() {
        return new byte[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.core.common.g.a
    public final String g() {
        return "";
    }

    @Override // com.anythink.core.common.g.a
    protected final String h() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final Context i() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final String j() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final String k() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, Object> l() {
        return null;
    }
}
