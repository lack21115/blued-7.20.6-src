package com.tencent.thumbplayer.adapter.strategy;

import com.tencent.thumbplayer.adapter.strategy.utils.TPStrategyUtils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/b.class */
public abstract class b implements a {

    /* renamed from: a  reason: collision with root package name */
    protected com.tencent.thumbplayer.adapter.strategy.a.a f25524a;

    public b(com.tencent.thumbplayer.adapter.strategy.a.a aVar) {
        this.f25524a = aVar;
    }

    @Override // com.tencent.thumbplayer.adapter.strategy.a
    public int a(com.tencent.thumbplayer.adapter.b bVar) {
        int a2 = this.f25524a.a();
        if (a2 == 0) {
            if (b(bVar)) {
                return 2;
            }
            return TPStrategyUtils.isSystemPlayerEnable() ? 1 : 0;
        } else if (a2 == 1) {
            return b(bVar) ? 2 : 0;
        } else if (a2 == 2) {
            if (b(bVar)) {
                return 2;
            }
            return TPStrategyUtils.isSystemPlayerEnable() ? 1 : 0;
        } else if (a2 == 3) {
            return c(bVar) ? 1 : 0;
        } else if (a2 != 4) {
            return 0;
        } else {
            if (c(bVar)) {
                return 1;
            }
            return TPStrategyUtils.isThumbPlayerEnable() ? 2 : 0;
        }
    }

    @Override // com.tencent.thumbplayer.adapter.strategy.a
    public int a(com.tencent.thumbplayer.adapter.b bVar, com.tencent.thumbplayer.adapter.strategy.a.b bVar2) {
        int a2 = this.f25524a.a();
        if (bVar2 == null || bVar2.a() != 0) {
            if (a(bVar2)) {
                return a2 != 0 ? a2 != 2 ? (a2 == 4 && bVar2 != null && bVar2.a() == 1 && b(bVar)) ? 2 : 0 : (bVar2 != null && bVar2.a() == 2 && c(bVar)) ? 1 : 0 : (bVar2 == null || bVar2.a() != 1) ? (bVar2 != null && bVar2.a() == 2 && c(bVar)) ? 1 : 0 : b(bVar) ? 2 : 0;
            }
            return 0;
        }
        return a(bVar);
    }

    protected boolean a(com.tencent.thumbplayer.adapter.strategy.a.b bVar) {
        return false;
    }

    @Override // com.tencent.thumbplayer.adapter.strategy.a
    public int[] a() {
        int b = this.f25524a.b();
        if (b != 0) {
            if (b == 1) {
                return new int[]{102};
            }
            if (b != 2) {
                if (b != 3) {
                    if (b != 4) {
                        return null;
                    }
                    return new int[]{101, 102};
                }
                return new int[]{101};
            }
        }
        return new int[]{102, 101};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(com.tencent.thumbplayer.adapter.b bVar) {
        return TPStrategyUtils.isTVPlatform() ? TPStrategyUtils.isThumbPlayerEnable() : TPStrategyUtils.isThumbPlayerEnable() && TPStrategyUtils.enablePlayByThumbPlayer(bVar);
    }

    boolean c(com.tencent.thumbplayer.adapter.b bVar) {
        if (TPStrategyUtils.isTVPlatform()) {
            return true;
        }
        return TPStrategyUtils.isSystemPlayerEnable() && TPStrategyUtils.enablePlayBySystemPlayer(bVar);
    }
}
