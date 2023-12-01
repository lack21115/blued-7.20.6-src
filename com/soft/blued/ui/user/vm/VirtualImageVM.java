package com.soft.blued.ui.user.vm;

import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.soft.blued.ui.user.model.VirtualImageModel;
import com.soft.blued.ui.user.state.VirtualImageAction;
import com.soft.blued.ui.user.state.VirtualImageState;
import com.soft.blued.ui.user.utils.VirtualImageUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/vm/VirtualImageVM.class */
public final class VirtualImageVM extends MVIBaseViewModel<VirtualImageState, VirtualImageAction> {

    /* renamed from: a  reason: collision with root package name */
    private VirtualImageUtils f34411a;

    private final void a(String str) {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new VirtualImageVM$getGuestImage$1(str, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public final void a(List<VirtualImageModel.CategoryModel> list) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private final void b() {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new VirtualImageVM$getUserBeanCount$1(this, null), 3, null);
    }

    private final void b(String str) {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new VirtualImageVM$save$1(str, this, null), 3, null);
    }

    private final void b(List<VirtualImageModel.CategoryModel> list) {
        List<VirtualImageModel.Resource> resource;
        final ArrayList arrayList = new ArrayList();
        for (VirtualImageModel.CategoryModel categoryModel : list) {
            ArrayList arrayList2 = new ArrayList();
            List<VirtualImageModel.ImageGoodsModel> goods_list = categoryModel.getGoods_list();
            if (goods_list != null) {
                for (VirtualImageModel.ImageGoodsModel imageGoodsModel : goods_list) {
                    if (imageGoodsModel.is_have() == 1 && (resource = imageGoodsModel.getResource()) != null && (!resource.isEmpty())) {
                        arrayList2.add(imageGoodsModel);
                    }
                }
            }
            if (true ^ arrayList2.isEmpty()) {
                VirtualImageModel.CategoryModel copy$default = VirtualImageModel.CategoryModel.copy$default(categoryModel, 0, null, 0, null, 0.0f, 0L, 0L, null, 0, 0, null, 2047, null);
                copy$default.setGoods_list(CollectionsKt.f((Iterable) arrayList2));
                arrayList.add(copy$default);
            }
        }
        if (arrayList.size() > 1) {
            CollectionsKt.a((List) arrayList, new Comparator() { // from class: com.soft.blued.ui.user.vm.VirtualImageVM$handlePackageImageData$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.a(Integer.valueOf(((VirtualImageModel.CategoryModel) t).getPack_sort()), Integer.valueOf(((VirtualImageModel.CategoryModel) t2).getPack_sort()));
                }
            });
        }
        BluedStructureExtKt.a(this, new Function1<VirtualImageState, VirtualImageState>() { // from class: com.soft.blued.ui.user.vm.VirtualImageVM$handlePackageImageData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final VirtualImageState invoke(VirtualImageState setState) {
                Intrinsics.e(setState, "$this$setState");
                return VirtualImageState.copy$default(setState, null, arrayList, null, 0, 13, null);
            }
        });
    }

    private final void c() {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new VirtualImageVM$getMarketingPicture$1(this, null), 3, null);
    }

    private final void d() {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new VirtualImageVM$getImageCategory$1(this, null), 3, null);
    }

    public final VirtualImageUtils a() {
        return this.f34411a;
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseViewModel
    /* renamed from: a */
    public void dispatchAction(VirtualImageAction action) {
        Intrinsics.e(action, "action");
        if (action instanceof VirtualImageAction.GetImageCategory) {
            d();
        } else if (action instanceof VirtualImageAction.GetBeanCount) {
            b();
        } else if (action instanceof VirtualImageAction.GetMarketingPicture) {
            c();
        } else if (action instanceof VirtualImageAction.Save) {
            b(((VirtualImageAction.Save) action).a());
        } else if (action instanceof VirtualImageAction.GetGuestImage) {
            a(((VirtualImageAction.GetGuestImage) action).a());
        }
    }

    public final void a(VirtualImageUtils virtualImageUtils) {
        this.f34411a = virtualImageUtils;
    }
}
