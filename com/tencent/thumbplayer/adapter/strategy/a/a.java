package com.tencent.thumbplayer.adapter.strategy.a;

import com.tencent.thumbplayer.adapter.c;
import com.tencent.thumbplayer.adapter.strategy.utils.TPStrategyUtils;
import com.tencent.thumbplayer.api.TPOptionalParam;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    int f25520a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    int[] f25521c;
    boolean d;

    public a(c cVar) {
        this.d = false;
        this.f25520a = 2;
        this.b = 2;
        if (TPStrategyUtils.isTVPlatform()) {
            this.b = 4;
            this.f25520a = 2;
        }
        if (cVar == null) {
            return;
        }
        TPOptionalParam b = cVar.b(210);
        if (b != null && b.getParamType() == 4) {
            this.f25521c = b.getParamQueueInt().queueValue;
            this.d = true;
            return;
        }
        TPOptionalParam b2 = cVar.b(202);
        if (b2 != null && b2.getParamType() == 2 && a(b2.getParamLong().value)) {
            this.b = (int) b2.getParamLong().value;
        }
        TPOptionalParam b3 = cVar.b(203);
        if (b3 != null && b3.getParamType() == 2 && b(b3.getParamLong().value)) {
            this.f25520a = (int) b3.getParamLong().value;
        }
        a(this.b, this.f25520a);
    }

    private void a(int i, int i2) {
        if (i == 3 && i2 == 3) {
            throw new IllegalArgumentException("can not soft with systemplayer");
        }
    }

    private boolean a(long j) {
        return j > 0 && j < 5;
    }

    private boolean b(long j) {
        return j > 0 && j < 5;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.f25520a;
    }

    public int[] c() {
        return this.f25521c;
    }

    public boolean d() {
        return this.d;
    }
}
