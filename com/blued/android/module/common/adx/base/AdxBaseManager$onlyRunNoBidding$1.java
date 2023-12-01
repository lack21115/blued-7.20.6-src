package com.blued.android.module.common.adx.base;

import com.blued.das.live.LiveProtos;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "AdxBaseManager.kt", c = {LiveProtos.Event.LIVE_USER_RANDOM_GIFT_PAGE_UP_SHOW_VALUE, LiveProtos.Event.LIVE_EXCHANGE_VIP_POP_COPY_CLICK_VALUE}, d = "onlyRunNoBidding", e = "com.blued.android.module.common.adx.base.AdxBaseManager")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/base/AdxBaseManager$onlyRunNoBidding$1.class */
public final class AdxBaseManager$onlyRunNoBidding$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f10509a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AdxBaseManager f10510c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdxBaseManager$onlyRunNoBidding$1(AdxBaseManager adxBaseManager, Continuation<? super AdxBaseManager$onlyRunNoBidding$1> continuation) {
        super(continuation);
        this.f10510c = adxBaseManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b;
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        b = this.f10510c.b(this);
        return b;
    }
}
