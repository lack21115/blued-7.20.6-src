package com.soft.blued.ui.search.vm;

import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.soft.blued.ui.search.state.SearchGlobalState;
import com.soft.blued.ui.search.utils.SearchGlobalUtil;
import java.util.List;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "SearchGlobalVM.kt", c = {}, d = "invokeSuspend", e = "com.soft.blued.ui.search.vm.SearchGlobalVM$getRecentRecord$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/vm/SearchGlobalVM$getRecentRecord$1.class */
public final class SearchGlobalVM$getRecentRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f19514a;
    final /* synthetic */ SearchGlobalVM b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchGlobalVM$getRecentRecord$1(SearchGlobalVM searchGlobalVM, Continuation<? super SearchGlobalVM$getRecentRecord$1> continuation) {
        super(2, continuation);
        this.b = searchGlobalVM;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchGlobalVM$getRecentRecord$1(this.b, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.a();
        if (this.f19514a == 0) {
            ResultKt.a(obj);
            final List<String> a2 = SearchGlobalUtil.f19484a.a();
            if (a2 != null) {
                BluedStructureExtKt.a(this.b, new Function1<SearchGlobalState, SearchGlobalState>() { // from class: com.soft.blued.ui.search.vm.SearchGlobalVM$getRecentRecord$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* renamed from: a */
                    public final SearchGlobalState invoke(SearchGlobalState searchGlobalState) {
                        Intrinsics.e(searchGlobalState, "$this$setState");
                        return SearchGlobalState.copy$default(searchGlobalState, null, a2, 1, null);
                    }
                });
            }
            return Unit.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
