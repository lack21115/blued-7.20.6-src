package com.tencent.thumbplayer.common;

import com.tencent.thumbplayer.adapter.a.b;
import com.tencent.thumbplayer.core.player.TPDynamicStatisticParams;
import com.tencent.thumbplayer.core.player.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.utils.TPLogUtil;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/common/a.class */
public class a implements com.tencent.thumbplayer.tplayer.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    private b f25576a;

    public a(b bVar) {
        this.f25576a = bVar;
    }

    @Override // com.tencent.thumbplayer.tplayer.a.a.a
    public TPDynamicStatisticParams a(boolean z) {
        b bVar = this.f25576a;
        if (bVar == null) {
            TPLogUtil.e("TPPlayerInfoGetterImpl", "playerBase is null, return default dynamic statistic params");
            return new TPDynamicStatisticParams();
        }
        TPDynamicStatisticParams c2 = bVar.c(z);
        TPDynamicStatisticParams tPDynamicStatisticParams = c2;
        if (c2 == null) {
            TPLogUtil.e("TPPlayerInfoGetterImpl", "cannot get params from core, return default dynamic statistic params");
            tPDynamicStatisticParams = new TPDynamicStatisticParams();
        }
        return tPDynamicStatisticParams;
    }

    @Override // com.tencent.thumbplayer.tplayer.a.a.a
    public TPGeneralPlayFlowParams a() {
        b bVar = this.f25576a;
        if (bVar == null) {
            TPLogUtil.e("TPPlayerInfoGetterImpl", "playerBase is null, return default general play flow params");
            return new TPGeneralPlayFlowParams();
        }
        TPGeneralPlayFlowParams u = bVar.u();
        TPGeneralPlayFlowParams tPGeneralPlayFlowParams = u;
        if (u == null) {
            TPLogUtil.e("TPPlayerInfoGetterImpl", "cannot get params from core, return default general play flow params");
            tPGeneralPlayFlowParams = new TPGeneralPlayFlowParams();
        }
        return tPGeneralPlayFlowParams;
    }
}
