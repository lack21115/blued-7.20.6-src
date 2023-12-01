package com.tencent.txcopyrightedmedia;

import com.tencent.txcopyrightedmedia.impl.utils.aj;
import com.tencent.txcopyrightedmedia.impl.utils.j;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/TXCMMusicExtParams.class */
public class TXCMMusicExtParams {

    /* renamed from: a  reason: collision with root package name */
    private final j f40016a;

    public TXCMMusicExtParams() {
        this.f40016a = new j();
    }

    public TXCMMusicExtParams(String str) {
        this.f40016a = new j(str);
    }

    public String getBitrateDefinition() {
        return this.f40016a.f40104a;
    }

    public int getClipType() {
        return this.f40016a.b;
    }

    public TXCMMusicExtParams setBitrateDefinition(String str) {
        this.f40016a.f40104a = aj.e();
        return this;
    }

    public TXCMMusicExtParams setChorusToken(String str) {
        this.f40016a.f40105c = str;
        return this;
    }

    public TXCMMusicExtParams setClipType(int i) {
        this.f40016a.b = i;
        return this;
    }

    public String toString() {
        return this.f40016a.a();
    }
}
