package com.blued.android.module.common.adx.base;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "AdxBaseManager.kt", c = {DownloadErrorCode.ERROR_UNSUPPORTED_ENCODING, 1413}, d = "doParallelTask", e = "com.blued.android.module.common.adx.base.AdxBaseManager")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/base/AdxBaseManager$doParallelTask$1.class */
public final class AdxBaseManager$doParallelTask$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f10505a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AdxBaseManager f10506c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdxBaseManager$doParallelTask$1(AdxBaseManager adxBaseManager, Continuation<? super AdxBaseManager$doParallelTask$1> continuation) {
        super(continuation);
        this.f10506c = adxBaseManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object e;
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        e = this.f10506c.e(this);
        return e;
    }
}
