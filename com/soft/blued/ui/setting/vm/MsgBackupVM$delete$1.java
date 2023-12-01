package com.soft.blued.ui.setting.vm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.base.mvi.MviEvent;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.txcloud.CredentialsInfo;
import com.blued.android.module.common.txcloud.TxCloud;
import com.blued.das.settings.SettingsProtos;
import com.soft.blued.R;
import com.soft.blued.ui.setting.state.MsgBackupState;
import com.soft.blued.utils.Logger;
import com.tencent.cos.xml.CosXmlService;
import com.tencent.cos.xml.model.object.DeleteObjectRequest;
import com.tencent.cos.xml.model.object.DeleteObjectResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "MsgBackupVM.kt", c = {69}, d = "invokeSuspend", e = "com.soft.blued.ui.setting.vm.MsgBackupVM$delete$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/MsgBackupVM$delete$1.class */
public final class MsgBackupVM$delete$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f19968a;
    final /* synthetic */ MsgBackupVM b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "MsgBackupVM.kt", c = {}, d = "invokeSuspend", e = "com.soft.blued.ui.setting.vm.MsgBackupVM$delete$1$1")
    /* renamed from: com.soft.blued.ui.setting.vm.MsgBackupVM$delete$1$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/MsgBackupVM$delete$1$1.class */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f19969a;
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
            String tag;
            MsgBackupVM msgBackupVM;
            MviEvent.LoadFinished loadFinished;
            String str;
            String tag2;
            IntrinsicsKt.a();
            if (this.f19969a == 0) {
                ResultKt.a(obj);
                try {
                    CosXmlService b = TxCloud.a.b();
                    CredentialsInfo a2 = TxCloud.a.a();
                    String path = a2 == null ? null : a2.getPath();
                    str = this.b.b;
                    String a3 = Intrinsics.a(path, str);
                    CredentialsInfo a4 = TxCloud.a.a();
                    DeleteObjectResult deleteObject = b == null ? null : b.deleteObject(new DeleteObjectRequest(a4 == null ? null : a4.getBucket(), a3));
                    this.b.d = null;
                    BluedStructureExtKt.a(this.b, new Function1<MsgBackupState, MsgBackupState>() { // from class: com.soft.blued.ui.setting.vm.MsgBackupVM.delete.1.1.1
                        /* renamed from: a */
                        public final MsgBackupState invoke(MsgBackupState msgBackupState) {
                            Intrinsics.e(msgBackupState, "$this$setState");
                            return msgBackupState.a("");
                        }
                    });
                    EventTrackSettings.a(SettingsProtos.Event.MINE_DELETE_RECORD_SUCCESS);
                    MsgBackupVM msgBackupVM2 = this.b;
                    String string = AppInfo.d().getString(R.string.msg_delete_succeed);
                    Intrinsics.c(string, "getAppContext().getStrin…tring.msg_delete_succeed)");
                    msgBackupVM2.showToast(string);
                    tag2 = this.b.getTAG();
                    Logger.c(tag2, Intrinsics.a("delete : ", deleteObject == null ? null : deleteObject.printResult()));
                    msgBackupVM = this.b;
                    loadFinished = new MviEvent.LoadFinished(false, false, 3, (DefaultConstructorMarker) null);
                } catch (Throwable th) {
                    try {
                        tag = this.b.getTAG();
                        Logger.c(tag, Intrinsics.a("delete e: ", th.getMessage()));
                        EventTrackSettings.a(SettingsProtos.Event.MINE_DELETE_RECORD_FAIL);
                        MsgBackupVM msgBackupVM3 = this.b;
                        String string2 = AppInfo.d().getString(R.string.msg_delete_failed);
                        Intrinsics.c(string2, "getAppContext().getStrin…string.msg_delete_failed)");
                        msgBackupVM3.showToast(string2);
                        msgBackupVM = this.b;
                        loadFinished = new MviEvent.LoadFinished(false, false, 3, (DefaultConstructorMarker) null);
                    } catch (Throwable th2) {
                        BluedStructureExtKt.a(this.b, new MviEvent.LoadFinished(false, false, 3, (DefaultConstructorMarker) null));
                        throw th2;
                    }
                }
                BluedStructureExtKt.a(msgBackupVM, loadFinished);
                return Unit.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgBackupVM$delete$1(MsgBackupVM msgBackupVM, Continuation<? super MsgBackupVM$delete$1> continuation) {
        super(2, continuation);
        this.b = msgBackupVM;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MsgBackupVM$delete$1(this.b, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2;
        Object a3 = IntrinsicsKt.a();
        int i = this.f19968a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f19968a = 1;
            a2 = this.b.a((Continuation) this);
            if (a2 == a3) {
                return a3;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this.b), Dispatchers.c(), (CoroutineStart) null, new AnonymousClass1(this.b, null), 2, (Object) null);
        return Unit.a;
    }
}
