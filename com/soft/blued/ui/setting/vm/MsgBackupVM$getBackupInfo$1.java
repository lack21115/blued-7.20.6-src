package com.soft.blued.ui.setting.vm;

import androidx.lifecycle.ViewModelKt;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.txcloud.CredentialsInfo;
import com.blued.android.module.common.txcloud.TxCloud;
import com.soft.blued.ui.setting.model.MsgBackInfo;
import com.soft.blued.ui.setting.state.MsgBackupState;
import com.soft.blued.utils.FileUtils;
import com.soft.blued.utils.Logger;
import com.tencent.cos.xml.CosXmlService;
import com.tencent.cos.xml.model.object.GetObjectRequest;
import com.tencent.cos.xml.model.object.GetObjectResult;
import java.io.File;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "MsgBackupVM.kt", c = {339}, d = "invokeSuspend", e = "com.soft.blued.ui.setting.vm.MsgBackupVM$getBackupInfo$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/MsgBackupVM$getBackupInfo$1.class */
public final class MsgBackupVM$getBackupInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f33664a;
    final /* synthetic */ MsgBackupVM b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "MsgBackupVM.kt", c = {}, d = "invokeSuspend", e = "com.soft.blued.ui.setting.vm.MsgBackupVM$getBackupInfo$1$1")
    /* renamed from: com.soft.blued.ui.setting.vm.MsgBackupVM$getBackupInfo$1$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/MsgBackupVM$getBackupInfo$1$1.class */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f33665a;
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
            String tag;
            String str;
            String str2;
            String tag2;
            String str3;
            String str4;
            String tag3;
            String tag4;
            final MsgBackInfo msgBackInfo;
            IntrinsicsKt.a();
            if (this.f33665a == 0) {
                ResultKt.a(obj);
                try {
                    str = this.b.f33655c;
                    str2 = this.b.b;
                    File file = new File(str, str2);
                    if (file.exists()) {
                        file.delete();
                    }
                    tag2 = this.b.getTAG();
                    Logger.c(tag2, "getBackupService");
                    CosXmlService b = TxCloud.f10836a.b();
                    CredentialsInfo a2 = TxCloud.f10836a.a();
                    String bucket = a2 == null ? null : a2.getBucket();
                    CredentialsInfo a3 = TxCloud.f10836a.a();
                    String path = a3 == null ? null : a3.getPath();
                    str3 = this.b.b;
                    String a4 = Intrinsics.a(path, (Object) str3);
                    str4 = this.b.f33655c;
                    GetObjectResult object = b == null ? null : b.getObject(new GetObjectRequest(bucket, a4, str4));
                    tag3 = this.b.getTAG();
                    Logger.c(tag3, Intrinsics.a("download: ", (Object) (object == null ? null : object.printResult())));
                    byte[] a5 = FileUtils.a(file.getAbsolutePath());
                    Intrinsics.c(a5, "getBytes(file.absolutePath)");
                    String str5 = new String(a5, Charsets.b);
                    tag4 = this.b.getTAG();
                    Logger.c(tag4, "download data: " + str5 + " length :" + FileUtils.a(file.getAbsolutePath()).length);
                    this.b.d = (MsgBackInfo) AppInfo.f().fromJson(str5, (Class<Object>) MsgBackInfo.class);
                    msgBackInfo = this.b.d;
                    if (msgBackInfo != null) {
                        final MsgBackupVM msgBackupVM = this.b;
                        BluedStructureExtKt.a(msgBackupVM, new Function1<MsgBackupState, MsgBackupState>() { // from class: com.soft.blued.ui.setting.vm.MsgBackupVM$getBackupInfo$1$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            /* renamed from: a */
                            public final MsgBackupState invoke(MsgBackupState setState) {
                                SimpleDateFormat simpleDateFormat;
                                Intrinsics.e(setState, "$this$setState");
                                simpleDateFormat = MsgBackupVM.this.f33654a;
                                return setState.a(simpleDateFormat.format(new Date(msgBackInfo.getDate())));
                            }
                        });
                    }
                } catch (Throwable th) {
                    tag = this.b.getTAG();
                    Logger.c(tag, Intrinsics.a("upload e: ", th));
                }
                return Unit.f42314a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgBackupVM$getBackupInfo$1(MsgBackupVM msgBackupVM, Continuation<? super MsgBackupVM$getBackupInfo$1> continuation) {
        super(2, continuation);
        this.b = msgBackupVM;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MsgBackupVM$getBackupInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MsgBackupVM$getBackupInfo$1(this.b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2;
        Object a3 = IntrinsicsKt.a();
        int i = this.f33664a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f33664a = 1;
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
