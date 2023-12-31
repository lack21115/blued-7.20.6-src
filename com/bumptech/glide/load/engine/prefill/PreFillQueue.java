package com.bumptech.glide.load.engine.prefill;

import java.util.List;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/prefill/PreFillQueue.class */
final class PreFillQueue {

    /* renamed from: a  reason: collision with root package name */
    private final Map<PreFillType, Integer> f7248a;
    private final List<PreFillType> b;

    /* renamed from: c  reason: collision with root package name */
    private int f7249c;
    private int d;

    public PreFillType a() {
        PreFillType preFillType = this.b.get(this.d);
        Integer num = this.f7248a.get(preFillType);
        if (num.intValue() == 1) {
            this.f7248a.remove(preFillType);
            this.b.remove(this.d);
        } else {
            this.f7248a.put(preFillType, Integer.valueOf(num.intValue() - 1));
        }
        this.f7249c--;
        this.d = this.b.isEmpty() ? 0 : (this.d + 1) % this.b.size();
        return preFillType;
    }

    public boolean b() {
        return this.f7249c == 0;
    }
}
