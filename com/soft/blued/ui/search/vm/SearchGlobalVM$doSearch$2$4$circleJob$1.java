package com.soft.blued.ui.search.vm;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.community.ui.circle.model.MyCircleModel;
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
@DebugMetadata(b = "SearchGlobalVM.kt", c = {172}, d = "invokeSuspend", e = "com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2$4$circleJob$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/vm/SearchGlobalVM$doSearch$2$4$circleJob$1.class */
final class SearchGlobalVM$doSearch$2$4$circleJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BluedEntityA<MyCircleModel>>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f19507a;
    final /* synthetic */ SearchGlobalVM b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f19508c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchGlobalVM$doSearch$2$4$circleJob$1(SearchGlobalVM searchGlobalVM, String str, Continuation<? super SearchGlobalVM$doSearch$2$4$circleJob$1> continuation) {
        super(2, continuation);
        this.b = searchGlobalVM;
        this.f19508c = str;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BluedEntityA<MyCircleModel>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchGlobalVM$doSearch$2$4$circleJob$1(this.b, this.f19508c, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2;
        Object a3 = IntrinsicsKt.a();
        int i = this.f19507a;
        if (i != 0) {
            if (i == 1) {
                ResultKt.a(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.a(obj);
        this.f19507a = 1;
        a2 = this.b.a(this.f19508c, (Continuation) this);
        return a2 == a3 ? a3 : a2;
    }
}
