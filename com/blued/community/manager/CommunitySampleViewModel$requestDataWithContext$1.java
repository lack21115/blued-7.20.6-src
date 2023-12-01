package com.blued.community.manager;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.LogUtils;
import com.blued.community.model.BluedIngSelfFeed;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "CommunitySampleViewModel.kt", c = {33, 52}, d = "invokeSuspend", e = "com.blued.community.manager.CommunitySampleViewModel$requestDataWithContext$1")
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/manager/CommunitySampleViewModel$requestDataWithContext$1.class */
public final class CommunitySampleViewModel$requestDataWithContext$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object a;
    Object b;
    int c;
    final /* synthetic */ CommunitySampleViewModel d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "CommunitySampleViewModel.kt", c = {}, d = "invokeSuspend", e = "com.blued.community.manager.CommunitySampleViewModel$requestDataWithContext$1$1")
    /* renamed from: com.blued.community.manager.CommunitySampleViewModel$requestDataWithContext$1$1  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/manager/CommunitySampleViewModel$requestDataWithContext$1$1.class */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Ref.ObjectRef<BluedEntityA<BluedIngSelfFeed>> b;
        final /* synthetic */ CommunitySampleViewModel c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.ObjectRef<BluedEntityA<BluedIngSelfFeed>> objectRef, CommunitySampleViewModel communitySampleViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.b = objectRef;
            this.c = communitySampleViewModel;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.a();
            if (this.a == 0) {
                ResultKt.a(obj);
                LogUtils.c(Intrinsics.a("ui start, ", (Object) Boxing.a(Thread.currentThread().getId())));
                if (this.b.a != null) {
                    LogUtils.c(Intrinsics.a("ui hasMore, ", (Object) Boxing.a(this.b.a.hasMore())));
                    this.c.loadListSucceed(this.b.a.data, this.b.a.hasMore());
                } else {
                    this.c.loadListFailed();
                }
                return Unit.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommunitySampleViewModel$requestDataWithContext$1(CommunitySampleViewModel communitySampleViewModel, Continuation<? super CommunitySampleViewModel$requestDataWithContext$1> continuation) {
        super(2, continuation);
        this.d = communitySampleViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CommunitySampleViewModel$requestDataWithContext$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommunitySampleViewModel$requestDataWithContext$1(this.d, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Object a2 = IntrinsicsKt.a();
        int i = this.c;
        if (i == 0) {
            ResultKt.a(obj);
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            this.a = objectRef3;
            this.b = objectRef3;
            this.c = 1;
            a = BuildersKt.a(Dispatchers.c(), new CommunitySampleViewModel$requestDataWithContext$1$entityA$1(this.d, null), this);
            if (a == a2) {
                return a2;
            }
            objectRef = objectRef3;
            objectRef2 = objectRef3;
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.a(obj);
                return Unit.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            objectRef2 = (Ref.ObjectRef) this.b;
            objectRef = (Ref.ObjectRef) this.a;
            ResultKt.a(obj);
            a = obj;
        }
        objectRef2.a = a;
        this.a = null;
        this.b = null;
        this.c = 2;
        if (BuildersKt.a(Dispatchers.b(), new AnonymousClass1(objectRef, this.d, null), this) == a2) {
            return a2;
        }
        return Unit.a;
    }
}
