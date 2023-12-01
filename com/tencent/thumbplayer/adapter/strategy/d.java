package com.tencent.thumbplayer.adapter.strategy;

import com.tencent.thumbplayer.utils.TPLogUtil;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/d.class */
public class d extends b {
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f39216c;

    public d(com.tencent.thumbplayer.adapter.strategy.a.a aVar) {
        super(aVar);
        this.b = 0;
        int[] c2 = aVar.c();
        this.f39216c = c2;
        if (c2 == null || c2.length == 0) {
            this.f39216c = new int[1];
        }
    }

    @Override // com.tencent.thumbplayer.adapter.strategy.b, com.tencent.thumbplayer.adapter.strategy.a
    public int a(com.tencent.thumbplayer.adapter.b bVar) {
        int[] iArr = this.f39216c;
        int length = iArr.length;
        int i = this.b;
        int i2 = length > i ? iArr[i] : 0;
        if ((i2 == 2 || i2 == 3) && !b(bVar)) {
            i2 = 0;
        }
        TPLogUtil.i("TPThumbPlayer[TPExtStrategy.java]", "strategyForOpen, playerType:".concat(String.valueOf(i2)));
        return i2;
    }

    @Override // com.tencent.thumbplayer.adapter.strategy.b, com.tencent.thumbplayer.adapter.strategy.a
    public int a(com.tencent.thumbplayer.adapter.b bVar, com.tencent.thumbplayer.adapter.strategy.a.b bVar2) {
        int i;
        if (bVar2 == null || bVar2.a() != 0) {
            int[] iArr = this.f39216c;
            int length = iArr.length;
            int i2 = this.b;
            if (length - 1 > i2) {
                int i3 = i2 + 1;
                this.b = i3;
                i = iArr[i3];
            } else {
                i = 0;
            }
            if ((i == 2 || i == 3) && !b(bVar)) {
                i = 0;
            }
            TPLogUtil.i("TPThumbPlayer[TPExtStrategy.java]", "strategyForRetry, playerType:".concat(String.valueOf(i)));
            return i;
        }
        return a(bVar);
    }

    @Override // com.tencent.thumbplayer.adapter.strategy.b, com.tencent.thumbplayer.adapter.strategy.a
    public int[] a() {
        StringBuilder sb;
        int i;
        int[] iArr = {-1};
        int i2 = this.b;
        int[] iArr2 = this.f39216c;
        if (i2 >= iArr2.length) {
            sb = new StringBuilder("strategyForDec error, decType:");
            i = iArr[0];
        } else {
            if (iArr2[i2] == 1 || iArr2[i2] == 2) {
                iArr[0] = 102;
            } else if (iArr2[i2] == 3) {
                iArr[0] = 101;
            }
            sb = new StringBuilder("strategyForDec, decType:");
            i = iArr[0];
        }
        sb.append(i);
        TPLogUtil.i("TPThumbPlayer[TPExtStrategy.java]", sb.toString());
        return iArr;
    }
}
