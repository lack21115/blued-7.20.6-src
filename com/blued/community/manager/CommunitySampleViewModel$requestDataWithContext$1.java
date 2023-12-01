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

    /* renamed from: a  reason: collision with root package name */
    Object f19103a;
    Object b;

    /* renamed from: c  reason: collision with root package name */
    int f19104c;
    final /* synthetic */ CommunitySampleViewModel d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "CommunitySampleViewModel.kt", c = {}, d = "invokeSuspend", e = "com.blued.community.manager.CommunitySampleViewModel$requestDataWithContext$1$1")
    /* renamed from: com.blued.community.manager.CommunitySampleViewModel$requestDataWithContext$1$1  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/manager/CommunitySampleViewModel$requestDataWithContext$1$1.class */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f19105a;
        final /* synthetic */ Ref.ObjectRef<BluedEntityA<BluedIngSelfFeed>> b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CommunitySampleViewModel f19106c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.ObjectRef<BluedEntityA<BluedIngSelfFeed>> objectRef, CommunitySampleViewModel communitySampleViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.b = objectRef;
            this.f19106c = communitySampleViewModel;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.b, this.f19106c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.a();
            if (this.f19105a == 0) {
                ResultKt.a(obj);
                LogUtils.c(Intrinsics.a("ui start, ", (Object) Boxing.a(Thread.currentThread().getId())));
                if (this.b.f42545a != null) {
                    LogUtils.c(Intrinsics.a("ui hasMore, ", (Object) Boxing.a(this.b.f42545a.hasMore())));
                    this.f19106c.loadListSucceed(this.b.f42545a.data, this.b.f42545a.hasMore());
                } else {
                    this.f19106c.loadListFailed();
                }
                return Unit.f42314a;
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
        return ((CommunitySampleViewModel$requestDataWithContext$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommunitySampleViewModel$requestDataWithContext$1(this.d, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Object a3 = IntrinsicsKt.a();
        int i = this.f19104c;
        if (i == 0) {
            ResultKt.a(obj);
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            this.f19103a = objectRef3;
            this.b = objectRef3;
            this.f19104c = 1;
            a2 = BuildersKt.a(Dispatchers.c(), new CommunitySampleViewModel$requestDataWithContext$1$entityA$1(this.d, null), this);
            if (a2 == a3) {
                return a3;
            }
            objectRef = objectRef3;
            objectRef2 = objectRef3;
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.a(obj);
                return Unit.f42314a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            objectRef2 = (Ref.ObjectRef) this.b;
            objectRef = (Ref.ObjectRef) this.f19103a;
            ResultKt.a(obj);
            a2 = obj;
        }
        objectRef2.f42545a = a2;
        this.f19103a = null;
        this.b = null;
        this.f19104c = 2;
        if (BuildersKt.a(Dispatchers.b(), new AnonymousClass1(objectRef, this.d, null), this) == a3) {
            return a3;
        }
        return Unit.f42314a;
    }
}
