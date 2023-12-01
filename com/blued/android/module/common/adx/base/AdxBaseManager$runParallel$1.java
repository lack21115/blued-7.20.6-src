package com.blued.android.module.common.adx.base;

import com.blued.das.live.LiveProtos;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "AdxBaseManager.kt", c = {455, 1410, LiveProtos.Event.LIVE_GIFT_VALIDITY_POP_YES_CLICK_VALUE, 1435, LiveProtos.Event.LIVE_GIFT_POP_DRESS_TAB_PROFILE_CARD_PAGE_SHOW_VALUE}, d = "runParallel", e = "com.blued.android.module.common.adx.base.AdxBaseManager")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/base/AdxBaseManager$runParallel$1.class */
public final class AdxBaseManager$runParallel$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f10511a;
    Object b;

    /* renamed from: c  reason: collision with root package name */
    /* synthetic */ Object f10512c;
    final /* synthetic */ AdxBaseManager d;
    int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdxBaseManager$runParallel$1(AdxBaseManager adxBaseManager, Continuation<? super AdxBaseManager$runParallel$1> continuation) {
        super(continuation);
        this.d = adxBaseManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2;
        this.f10512c = obj;
        this.e |= Integer.MIN_VALUE;
        a2 = this.d.a(this);
        return a2;
    }
}
