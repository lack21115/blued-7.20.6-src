package com.soft.blued.ui.user.vm;

import com.soft.blued.ui.user.model.VirtualImageModel;
import com.soft.blued.ui.user.state.VirtualImageState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/vm/VirtualImageVM$handleImageData$2.class */
final class VirtualImageVM$handleImageData$2 extends Lambda implements Function1<VirtualImageState, VirtualImageState> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List<VirtualImageModel.CategoryModel> f34419a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VirtualImageVM$handleImageData$2(List<VirtualImageModel.CategoryModel> list) {
        super(1);
        this.f34419a = list;
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final VirtualImageState invoke(VirtualImageState setState) {
        Intrinsics.e(setState, "$this$setState");
        return VirtualImageState.copy$default(setState, this.f34419a, null, null, 0, 14, null);
    }
}
