package com.soft.blued.ui.user.viewmodel;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.ui.user.model.CheckUserPrivilegePermission;
import com.soft.blued.ui.user.state.PrivilegeBuyAction;
import com.soft.blued.ui.user.state.PrivilegeBuyState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "PrivilegeBuyDialogNewVM.kt", c = {}, d = "invokeSuspend", e = "com.soft.blued.ui.user.viewmodel.PrivilegeBuyDialogNewVM$checkUserPermission$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/PrivilegeBuyDialogNewVM$checkUserPermission$1.class */
final class PrivilegeBuyDialogNewVM$checkUserPermission$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f20651a;
    final /* synthetic */ PrivilegeBuyAction.checUserPermission b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ PrivilegeBuyDialogNewVM f20652c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivilegeBuyDialogNewVM$checkUserPermission$1(PrivilegeBuyAction.checUserPermission checuserpermission, PrivilegeBuyDialogNewVM privilegeBuyDialogNewVM, Continuation<? super PrivilegeBuyDialogNewVM$checkUserPermission$1> continuation) {
        super(2, continuation);
        this.b = checuserpermission;
        this.f20652c = privilegeBuyDialogNewVM;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PrivilegeBuyDialogNewVM$checkUserPermission$1(this.b, this.f20652c, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.a();
        if (this.f20651a == 0) {
            ResultKt.a(obj);
            final PrivilegeBuyDialogNewVM privilegeBuyDialogNewVM = this.f20652c;
            PayHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<CheckUserPrivilegePermission>>() { // from class: com.soft.blued.ui.user.viewmodel.PrivilegeBuyDialogNewVM$checkUserPermission$1.1
                {
                    super((IRequestHost) null);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                /* renamed from: a */
                public void onUIUpdate(final BluedEntityA<CheckUserPrivilegePermission> bluedEntityA) {
                    if (bluedEntityA != null) {
                        BluedStructureExtKt.a(PrivilegeBuyDialogNewVM.this, new Function1<PrivilegeBuyState, PrivilegeBuyState>() { // from class: com.soft.blued.ui.user.viewmodel.PrivilegeBuyDialogNewVM$checkUserPermission$1$1$onUIUpdate$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* renamed from: a */
                            public final PrivilegeBuyState invoke(PrivilegeBuyState privilegeBuyState) {
                                Intrinsics.e(privilegeBuyState, "$this$setState");
                                return PrivilegeBuyState.copy$default(privilegeBuyState, null, (CheckUserPrivilegePermission) bluedEntityA.getSingleData(), 1, null);
                            }
                        });
                    }
                }

                public boolean onUIFailure(int i, String str, String str2) {
                    return super.onUIFailure(i, str, str2);
                }
            }, this.b.a(), (IRequestHost) null);
            return Unit.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
