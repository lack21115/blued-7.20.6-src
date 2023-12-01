package com.soft.blued.ui.setting.vm;

import androidx.lifecycle.ViewModelKt;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.base.mvi.MviEvent;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.txcloud.CredentialsInfo;
import com.blued.android.module.common.txcloud.TxCloud;
import com.blued.android.module.common.user.model.UserInfo;
import com.soft.blued.R;
import com.soft.blued.ui.setting.model.MsgBackInfo;
import com.soft.blued.utils.Logger;
import com.tencent.cos.xml.CosXmlService;
import com.tencent.cos.xml.model.object.GetObjectRequest;
import com.tencent.cos.xml.model.object.GetObjectResult;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "MsgBackupVM.kt", c = {231}, d = "invokeSuspend", e = "com.soft.blued.ui.setting.vm.MsgBackupVM$downAndRestore$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/MsgBackupVM$downAndRestore$1.class */
public final class MsgBackupVM$downAndRestore$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f33662a;
    final /* synthetic */ MsgBackupVM b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "MsgBackupVM.kt", c = {}, d = "invokeSuspend", e = "com.soft.blued.ui.setting.vm.MsgBackupVM$downAndRestore$1$1")
    /* renamed from: com.soft.blued.ui.setting.vm.MsgBackupVM$downAndRestore$1$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/MsgBackupVM$downAndRestore$1$1.class */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f33663a;
        final /* synthetic */ MsgBackupVM b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MsgBackupVM msgBackupVM, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.b = msgBackupVM;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MsgBackInfo msgBackInfo;
            String str;
            String str2;
            String tag;
            IntrinsicsKt.a();
            if (this.f33663a == 0) {
                ResultKt.a(obj);
                try {
                    StringBuilder sb = new StringBuilder();
                    msgBackInfo = this.b.d;
                    sb.append((Object) (msgBackInfo == null ? null : msgBackInfo.getPlatform()));
                    sb.append('_');
                    sb.append((Object) UserInfo.getInstance().getLoginUserInfo().uid);
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder();
                    str = this.b.f33655c;
                    sb3.append((Object) str);
                    sb3.append((Object) File.separator);
                    sb3.append(sb2);
                    String sb4 = sb3.toString();
                    File file = new File(sb4);
                    if (file.exists()) {
                        file.delete();
                    }
                    CosXmlService b = TxCloud.f10836a.b();
                    CredentialsInfo a2 = TxCloud.f10836a.a();
                    String a3 = Intrinsics.a(a2 == null ? null : a2.getPath(), (Object) sb2);
                    CredentialsInfo a4 = TxCloud.f10836a.a();
                    String bucket = a4 == null ? null : a4.getBucket();
                    str2 = this.b.f33655c;
                    GetObjectResult object = b == null ? null : b.getObject(new GetObjectRequest(bucket, a3, str2));
                    tag = this.b.getTAG();
                    Logger.c(tag, Intrinsics.a("download DB: ", (Object) (object == null ? null : object.printResult())));
                    this.b.b(sb4);
                } catch (Throwable th) {
                    MsgBackupVM msgBackupVM = this.b;
                    String string = AppInfo.d().getString(R.string.msg_restore_failed);
                    Intrinsics.c(string, "getAppContext().getStrin…tring.msg_restore_failed)");
                    msgBackupVM.showToast(string);
                    BluedStructureExtKt.a(this.b, new MviEvent.LoadFinished(false, false, 3, null));
                }
                return Unit.f42314a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgBackupVM$downAndRestore$1(MsgBackupVM msgBackupVM, Continuation<? super MsgBackupVM$downAndRestore$1> continuation) {
        super(2, continuation);
        this.b = msgBackupVM;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MsgBackupVM$downAndRestore$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MsgBackupVM$downAndRestore$1(this.b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2;
        Object a3 = IntrinsicsKt.a();
        int i = this.f33662a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f33662a = 1;
            a2 = this.b.a(this);
            if (a2 == a3) {
                return a3;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this.b), Dispatchers.c(), null, new AnonymousClass1(this.b, null), 2, null);
        return Unit.f42314a;
    }
}
