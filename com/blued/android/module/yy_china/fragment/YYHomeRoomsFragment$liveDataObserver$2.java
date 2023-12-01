package com.blued.android.module.yy_china.fragment;

import com.blued.android.module.yy_china.model.YYHomeExtraModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHomeRoomsFragment$liveDataObserver$2.class */
final /* synthetic */ class YYHomeRoomsFragment$liveDataObserver$2 extends FunctionReferenceImpl implements Function1<YYHomeExtraModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public YYHomeRoomsFragment$liveDataObserver$2(Object obj) {
        super(1, obj, YYHomeRoomsFragment.class, "homeExtra", "homeExtra(Lcom/blued/android/module/yy_china/model/YYHomeExtraModel;)V", 0);
    }

    public final void a(YYHomeExtraModel yYHomeExtraModel) {
        ((YYHomeRoomsFragment) this.receiver).a(yYHomeExtraModel);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(YYHomeExtraModel yYHomeExtraModel) {
        a(yYHomeExtraModel);
        return Unit.a;
    }
}
