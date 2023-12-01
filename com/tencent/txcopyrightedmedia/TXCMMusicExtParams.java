package com.tencent.txcopyrightedmedia;

import com.tencent.txcopyrightedmedia.impl.utils.aj;
import com.tencent.txcopyrightedmedia.impl.utils.j;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/TXCMMusicExtParams.class */
public class TXCMMusicExtParams {

    /* renamed from: a  reason: collision with root package name */
    private final j f26325a;

    public TXCMMusicExtParams() {
        this.f26325a = new j();
    }

    public TXCMMusicExtParams(String str) {
        this.f26325a = new j(str);
    }

    public String getBitrateDefinition() {
        return this.f26325a.f26413a;
    }

    public int getClipType() {
        return this.f26325a.b;
    }

    public TXCMMusicExtParams setBitrateDefinition(String str) {
        this.f26325a.f26413a = aj.e();
        return this;
    }

    public TXCMMusicExtParams setChorusToken(String str) {
        this.f26325a.f26414c = str;
        return this;
    }

    public TXCMMusicExtParams setClipType(int i) {
        this.f26325a.b = i;
        return this;
    }

    public String toString() {
        return this.f26325a.a();
    }
}
