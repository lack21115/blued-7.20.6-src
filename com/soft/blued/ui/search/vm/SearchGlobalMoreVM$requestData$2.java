package com.soft.blued.ui.search.vm;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "SearchGlobalMoreVM.kt", c = {41, 42}, d = "invokeSuspend", e = "com.soft.blued.ui.search.vm.SearchGlobalMoreVM$requestData$2")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/vm/SearchGlobalMoreVM$requestData$2.class */
final class SearchGlobalMoreVM$requestData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f33180a;
    final /* synthetic */ SearchGlobalMoreVM b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchGlobalMoreVM$requestData$2(SearchGlobalMoreVM searchGlobalMoreVM, Continuation<? super SearchGlobalMoreVM$requestData$2> continuation) {
        super(2, continuation);
        this.b = searchGlobalMoreVM;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchGlobalMoreVM$requestData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchGlobalMoreVM$requestData$2(this.b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2;
        Object b;
        Object a3 = IntrinsicsKt.a();
        int i = this.f33180a;
        if (i == 0) {
            ResultKt.a(obj);
            int a4 = this.b.a();
            if (a4 == 1) {
                this.b.d();
            } else if (a4 == 2) {
                this.f33180a = 1;
                a2 = this.b.a(this);
                if (a2 == a3) {
                    return a3;
                }
            } else if (a4 == 3) {
                this.f33180a = 2;
                b = this.b.b(this);
                if (b == a3) {
                    return a3;
                }
            }
        } else if (i != 1 && i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        return Unit.f42314a;
    }
}
