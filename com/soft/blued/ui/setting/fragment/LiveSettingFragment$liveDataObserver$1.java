package com.soft.blued.ui.setting.fragment;

import com.blued.android.module.live_china.model.LiveSettingModel;
import com.kuaishou.weapon.p0.bp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/LiveSettingFragment$liveDataObserver$1.class */
final /* synthetic */ class LiveSettingFragment$liveDataObserver$1 extends FunctionReferenceImpl implements Function1<List<? extends LiveSettingModel>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveSettingFragment$liveDataObserver$1(Object obj) {
        super(1, obj, LiveSettingFragment.class, "setLiveSettingData", "setLiveSettingData(Ljava/util/List;)V", 0);
    }

    public final void a(List<? extends LiveSettingModel> list) {
        Intrinsics.e(list, bp.g);
        ((LiveSettingFragment) this.receiver).a(list);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.a;
    }
}
