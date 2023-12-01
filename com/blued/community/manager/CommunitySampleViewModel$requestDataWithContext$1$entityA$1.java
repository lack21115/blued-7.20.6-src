package com.blued.community.manager;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.community.model.BluedIngSelfFeed;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "CommunitySampleViewModel.kt", c = {40, 41}, d = "invokeSuspend", e = "com.blued.community.manager.CommunitySampleViewModel$requestDataWithContext$1$entityA$1")
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/manager/CommunitySampleViewModel$requestDataWithContext$1$entityA$1.class */
final class CommunitySampleViewModel$requestDataWithContext$1$entityA$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BluedEntityA<BluedIngSelfFeed>>, Object> {
    Object a;
    Object b;
    int c;
    final /* synthetic */ CommunitySampleViewModel d;
    private /* synthetic */ Object e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommunitySampleViewModel$requestDataWithContext$1$entityA$1(CommunitySampleViewModel communitySampleViewModel, Continuation<? super CommunitySampleViewModel$requestDataWithContext$1$entityA$1> continuation) {
        super(2, continuation);
        this.d = communitySampleViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BluedEntityA<BluedIngSelfFeed>> continuation) {
        return ((CommunitySampleViewModel$requestDataWithContext$1$entityA$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CommunitySampleViewModel$requestDataWithContext$1$entityA$1 communitySampleViewModel$requestDataWithContext$1$entityA$1 = new CommunitySampleViewModel$requestDataWithContext$1$entityA$1(this.d, continuation);
        communitySampleViewModel$requestDataWithContext$1$entityA$1.e = obj;
        return communitySampleViewModel$requestDataWithContext$1$entityA$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x012a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.community.manager.CommunitySampleViewModel$requestDataWithContext$1$entityA$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
