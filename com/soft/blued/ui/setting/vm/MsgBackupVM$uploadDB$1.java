package com.soft.blued.ui.setting.vm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.base.mvi.MviEvent;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.txcloud.CredentialsInfo;
import com.blued.android.module.common.txcloud.TxCloud;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.das.settings.SettingsProtos;
import com.soft.blued.R;
import com.soft.blued.ui.setting.model.MsgBackInfo;
import com.soft.blued.ui.setting.state.MsgBackupState;
import com.soft.blued.utils.Logger;
import com.tencent.cos.xml.CosXmlService;
import com.tencent.cos.xml.model.object.PutObjectRequest;
import java.io.File;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@DebugMetadata(b = "MsgBackupVM.kt", c = {179}, d = "invokeSuspend", e = "com.soft.blued.ui.setting.vm.MsgBackupVM$uploadDB$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/MsgBackupVM$uploadDB$1.class */
public final class MsgBackupVM$uploadDB$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f19979a;
    final /* synthetic */ MsgBackupVM b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f19980c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "MsgBackupVM.kt", c = {}, d = "invokeSuspend", e = "com.soft.blued.ui.setting.vm.MsgBackupVM$uploadDB$1$1")
    /* renamed from: com.soft.blued.ui.setting.vm.MsgBackupVM$uploadDB$1$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/MsgBackupVM$uploadDB$1$1.class */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f19981a;
        final /* synthetic */ MsgBackupVM b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19982c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MsgBackupVM msgBackupVM, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.b = msgBackupVM;
            this.f19982c = str;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.a);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.b, this.f19982c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            MsgBackupVM msgBackupVM;
            MviEvent.LoadFinished loadFinished;
            String str;
            String tag;
            IntrinsicsKt.a();
            if (this.f19981a == 0) {
                ResultKt.a(obj);
                try {
                    CosXmlService b = TxCloud.a.b();
                    final MsgBackInfo msgBackInfo = new MsgBackInfo();
                    String json = AppInfo.f().toJson(msgBackInfo);
                    CredentialsInfo a2 = TxCloud.a.a();
                    String path = a2 == null ? null : a2.getPath();
                    str = this.b.b;
                    String a3 = Intrinsics.a(path, str);
                    CredentialsInfo a4 = TxCloud.a.a();
                    String bucket = a4 == null ? null : a4.getBucket();
                    Intrinsics.c(json, "backupInfo");
                    Charset forName = Charset.forName("UTF-8");
                    Intrinsics.c(forName, "forName(\"UTF-8\")");
                    byte[] bytes = json.getBytes(forName);
                    Intrinsics.c(bytes, "this as java.lang.String).getBytes(charset)");
                    PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, a3, bytes);
                    CredentialsInfo a5 = TxCloud.a.a();
                    String a6 = Intrinsics.a(a5 == null ? null : a5.getPath(), new File(this.f19982c).getName());
                    tag = this.b.getTAG();
                    Logger.c(tag, Intrinsics.a("dbCosPath: ", a6));
                    CredentialsInfo a7 = TxCloud.a.a();
                    PutObjectRequest putObjectRequest2 = new PutObjectRequest(a7 == null ? null : a7.getBucket(), a6, this.f19982c);
                    if (b != null) {
                        b.putObject(putObjectRequest);
                    }
                    if (b != null) {
                        b.putObject(putObjectRequest2);
                    }
                    this.b.d = msgBackInfo;
                    EventTrackSettings.a(SettingsProtos.Event.MINE_BACKUP_RECORD_SUCCESS);
                    MsgBackupVM msgBackupVM2 = this.b;
                    String string = AppInfo.d().getString(R.string.msg_backup_complete);
                    Intrinsics.c(string, "getAppContext().getStrin…ring.msg_backup_complete)");
                    msgBackupVM2.showToast(string);
                    final MsgBackupVM msgBackupVM3 = this.b;
                    BluedStructureExtKt.a(this.b, new Function1<MsgBackupState, MsgBackupState>() { // from class: com.soft.blued.ui.setting.vm.MsgBackupVM.uploadDB.1.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* renamed from: a */
                        public final MsgBackupState invoke(MsgBackupState msgBackupState) {
                            SimpleDateFormat simpleDateFormat;
                            Intrinsics.e(msgBackupState, "$this$setState");
                            simpleDateFormat = MsgBackupVM.this.f19963a;
                            return msgBackupState.a(simpleDateFormat.format(new Date(msgBackInfo.getDate())));
                        }
                    });
                    msgBackupVM = this.b;
                    loadFinished = new MviEvent.LoadFinished(false, false, 3, (DefaultConstructorMarker) null);
                } catch (Throwable th) {
                    try {
                        EventTrackSettings.a(SettingsProtos.Event.MINE_BACKUP_RECORD_FAIL);
                        ToastUtils.a(AppInfo.d().getString(R.string.msg_backup_failed));
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
    public MsgBackupVM$uploadDB$1(MsgBackupVM msgBackupVM, String str, Continuation<? super MsgBackupVM$uploadDB$1> continuation) {
        super(2, continuation);
        this.b = msgBackupVM;
        this.f19980c = str;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MsgBackupVM$uploadDB$1(this.b, this.f19980c, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2;
        Object a3 = IntrinsicsKt.a();
        int i = this.f19979a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f19979a = 1;
            a2 = this.b.a((Continuation) this);
            if (a2 == a3) {
                return a3;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this.b), Dispatchers.c(), (CoroutineStart) null, new AnonymousClass1(this.b, this.f19980c, null), 2, (Object) null);
        return Unit.a;
    }
}
