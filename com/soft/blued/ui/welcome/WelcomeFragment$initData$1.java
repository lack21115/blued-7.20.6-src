package com.soft.blued.ui.welcome;

import android.content.Context;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.module.common.log.oldtrack.InstantLogBody;
import com.blued.das.login.LoginAndRegisterProtos;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.welcome.WelcomeFragment;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "WelcomeFragment.kt", c = {165}, d = "invokeSuspend", e = "com.soft.blued.ui.welcome.WelcomeFragment$initData$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/WelcomeFragment$initData$1.class */
public final class WelcomeFragment$initData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f20929a;
    final /* synthetic */ WelcomeFragment b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WelcomeFragment$initData$1(WelcomeFragment welcomeFragment, Continuation<? super WelcomeFragment$initData$1> continuation) {
        super(2, continuation);
        this.b = welcomeFragment;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WelcomeFragment$initData$1(this.b, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        boolean z;
        Object a2 = IntrinsicsKt.a();
        int i = this.f20929a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f20929a = 1;
            Object a3 = TimeoutKt.a(5000L, new WelcomeFragment$initData$1$result$1(this.b, null), (Continuation) this);
            obj = a3;
            if (a3 == a2) {
                return a2;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        if (((Unit) obj) == null) {
            this.b.a("请求开机图接口请求超时了。。。。");
            LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_REQUEST_TIMEOUT;
            str = this.b.f;
            EventTrackLoginAndRegister.b(event, str);
            InstantLogBody instantLogBody = new InstantLogBody();
            instantLogBody.service = "AD_REQUEST_TIMEOUT";
            Map a4 = BluedHttpTools.a();
            Intrinsics.c(a4, "params");
            str2 = this.b.f;
            a4.put("req_id", str2);
            InstantLog.a(instantLogBody, a4);
            WelcomeFragment.Companion companion = WelcomeFragment.f20927a;
            Context context = this.b.getContext();
            z = this.b.f20928c;
            companion.b(context, z);
        }
        return Unit.a;
    }
}
