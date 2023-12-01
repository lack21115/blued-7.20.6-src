package com.soft.blued.ui.user.vm;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.soft.blued.ui.user.api.UserApiService;
import com.soft.blued.ui.user.model.VirtualImageModel;
import com.soft.blued.ui.user.state.VirtualImageEvent;
import com.soft.blued.ui.user.state.VirtualImageState;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "VirtualImageVM.kt", c = {89}, d = "invokeSuspend", e = "com.soft.blued.ui.user.vm.VirtualImageVM$getImageCategory$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/vm/VirtualImageVM$getImageCategory$1.class */
public final class VirtualImageVM$getImageCategory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f20724a;
    final /* synthetic */ VirtualImageVM b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualImageVM$getImageCategory$1(VirtualImageVM virtualImageVM, Continuation<? super VirtualImageVM$getImageCategory$1> continuation) {
        super(2, continuation);
        this.b = virtualImageVM;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VirtualImageVM$getImageCategory$1(this.b, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        ApiState apiState;
        Object a2 = IntrinsicsKt.a();
        int i = this.f20724a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f20724a = 1;
            Object c2 = ((UserApiService) BluedApiProxy.b().a(UserApiService.class)).c((Continuation) this);
            obj = c2;
            if (c2 == a2) {
                return a2;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        BluedEntityA bluedEntityA = (BluedEntityA) obj;
        VirtualImageVM virtualImageVM = this.b;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                final List list = bluedEntityA.data;
                Intrinsics.c(list, "data");
                bluedEntityA.hasMore();
                if (!list.isEmpty()) {
                    List<VirtualImageModel.CategoryModel> category_list = ((VirtualImageModel) list.get(0)).getCategory_list();
                    if (category_list != null) {
                        virtualImageVM.a(category_list);
                    }
                    BluedStructureExtKt.a(virtualImageVM, new Function1<VirtualImageState, VirtualImageState>() { // from class: com.soft.blued.ui.user.vm.VirtualImageVM$getImageCategory$1$1$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* renamed from: a */
                        public final VirtualImageState invoke(VirtualImageState virtualImageState) {
                            Intrinsics.e(virtualImageState, "$this$setState");
                            return VirtualImageState.copy$default(virtualImageState, null, null, null, list.get(0).getRed_dot(), 7, null);
                        }
                    });
                }
            } else {
                final List b = CollectionsKt.b();
                if (!b.isEmpty()) {
                    List<VirtualImageModel.CategoryModel> category_list2 = ((VirtualImageModel) b.get(0)).getCategory_list();
                    if (category_list2 != null) {
                        virtualImageVM.a(category_list2);
                    }
                    BluedStructureExtKt.a(virtualImageVM, new Function1<VirtualImageState, VirtualImageState>() { // from class: com.soft.blued.ui.user.vm.VirtualImageVM$getImageCategory$1$1$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* renamed from: a */
                        public final VirtualImageState invoke(VirtualImageState virtualImageState) {
                            Intrinsics.e(virtualImageState, "$this$setState");
                            return VirtualImageState.copy$default(virtualImageState, null, null, null, b.get(0).getRed_dot(), 7, null);
                        }
                    });
                }
            }
            apiState = (ApiState) Succeed.a;
        } else {
            int i2 = bluedEntityA.code;
            String str = bluedEntityA.message;
            Intrinsics.c(str, "message");
            apiState = (ApiState) new Error(i2, str);
        }
        VirtualImageVM virtualImageVM2 = this.b;
        if (apiState instanceof Error) {
            Error error = apiState;
            error.a();
            error.b();
            BluedStructureExtKt.a(virtualImageVM2, VirtualImageEvent.ErrorEvent.f20630a);
        }
        return Unit.a;
    }
}
