package com.soft.blued.ui.setting.vm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.base.mvi.MviEvent;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.user.model.UserInfo;
import com.soft.blued.R;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "MsgBackupVM.kt", c = {}, d = "invokeSuspend", e = "com.soft.blued.ui.setting.vm.MsgBackupVM$RestoreFromLocal$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/MsgBackupVM$RestoreFromLocal$1.class */
public final class MsgBackupVM$RestoreFromLocal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f19965a;
    final /* synthetic */ MsgBackupVM b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "MsgBackupVM.kt", c = {}, d = "invokeSuspend", e = "com.soft.blued.ui.setting.vm.MsgBackupVM$RestoreFromLocal$1$1")
    /* renamed from: com.soft.blued.ui.setting.vm.MsgBackupVM$RestoreFromLocal$1$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/MsgBackupVM$RestoreFromLocal$1$1.class */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f19966a;
        final /* synthetic */ MsgBackupVM b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MsgBackupVM msgBackupVM, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.b = msgBackupVM;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.a);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.a();
            if (this.f19966a == 0) {
                ResultKt.a(obj);
                try {
                    String absolutePath = new File(AppInfo.d().getExternalFilesDir("blued"), Intrinsics.a("android_", UserInfo.getInstance().getLoginUserInfo().uid)).getAbsolutePath();
                    if (new File(absolutePath).exists()) {
                        MsgBackupVM msgBackupVM = this.b;
                        Intrinsics.c(absolutePath, "dst");
                        msgBackupVM.b(absolutePath);
                    } else {
                        MsgBackupVM msgBackupVM2 = this.b;
                        msgBackupVM2.showToast(AppInfo.d().getString(R.string.msg_restore_no_file) + ':' + ((Object) absolutePath));
                        BluedStructureExtKt.a(this.b, new MviEvent.LoadFinished(false, false, 3, (DefaultConstructorMarker) null));
                    }
                } catch (Throwable th) {
                    MsgBackupVM msgBackupVM3 = this.b;
                    String string = AppInfo.d().getString(R.string.msg_restore_failed);
                    Intrinsics.c(string, "getAppContext().getStrin…tring.msg_restore_failed)");
                    msgBackupVM3.showToast(string);
                    BluedStructureExtKt.a(this.b, new MviEvent.LoadFinished(false, false, 3, (DefaultConstructorMarker) null));
                }
                return Unit.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgBackupVM$RestoreFromLocal$1(MsgBackupVM msgBackupVM, Continuation<? super MsgBackupVM$RestoreFromLocal$1> continuation) {
        super(2, continuation);
        this.b = msgBackupVM;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MsgBackupVM$RestoreFromLocal$1(this.b, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.a();
        if (this.f19965a == 0) {
            ResultKt.a(obj);
            BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this.b), Dispatchers.c(), (CoroutineStart) null, new AnonymousClass1(this.b, null), 2, (Object) null);
            return Unit.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
