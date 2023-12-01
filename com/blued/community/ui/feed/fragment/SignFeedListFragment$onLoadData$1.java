package com.blued.community.ui.feed.fragment;

import com.blued.community.model.FeedBubbleSignModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "SignFeedListFragment.kt", c = {714, 719}, d = "invokeSuspend", e = "com.blued.community.ui.feed.fragment.SignFeedListFragment$onLoadData$1")
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/fragment/SignFeedListFragment$onLoadData$1.class */
public final class SignFeedListFragment$onLoadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object a;
    int b;
    final /* synthetic */ SignFeedListFragment c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "SignFeedListFragment.kt", c = {717}, d = "invokeSuspend", e = "com.blued.community.ui.feed.fragment.SignFeedListFragment$onLoadData$1$2")
    /* renamed from: com.blued.community.ui.feed.fragment.SignFeedListFragment$onLoadData$1$2  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/fragment/SignFeedListFragment$onLoadData$1$2.class */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FeedBubbleSignModel>, Object> {
        int a;
        final /* synthetic */ SignFeedListFragment b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SignFeedListFragment signFeedListFragment, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.b = signFeedListFragment;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FeedBubbleSignModel> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object a;
            Object a2 = IntrinsicsKt.a();
            int i = this.a;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.a(obj);
                    return obj;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.a(obj);
            this.a = 1;
            a = this.b.a(this);
            return a == a2 ? a2 : a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "SignFeedListFragment.kt", c = {}, d = "invokeSuspend", e = "com.blued.community.ui.feed.fragment.SignFeedListFragment$onLoadData$1$3")
    /* renamed from: com.blued.community.ui.feed.fragment.SignFeedListFragment$onLoadData$1$3  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/fragment/SignFeedListFragment$onLoadData$1$3.class */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ SignFeedListFragment b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(SignFeedListFragment signFeedListFragment, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.b = signFeedListFragment;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.a();
            if (this.a == 0) {
                ResultKt.a(obj);
                this.b.G();
                return Unit.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignFeedListFragment$onLoadData$1(SignFeedListFragment signFeedListFragment, Continuation<? super SignFeedListFragment$onLoadData$1> continuation) {
        super(2, continuation);
        this.c = signFeedListFragment;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SignFeedListFragment$onLoadData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SignFeedListFragment$onLoadData$1(this.c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SignFeedListFragment signFeedListFragment;
        Object a = IntrinsicsKt.a();
        int i = this.b;
        if (i == 0) {
            ResultKt.a(obj);
            signFeedListFragment = this.c;
            this.a = signFeedListFragment;
            this.b = 1;
            Object a2 = BuildersKt.a(Dispatchers.c().plus(new SignFeedListFragment$onLoadData$1$invokeSuspend$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.b)), new AnonymousClass2(this.c, null), this);
            obj = a2;
            if (a2 == a) {
                return a;
            }
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.a(obj);
                return Unit.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            signFeedListFragment = (SignFeedListFragment) this.a;
            ResultKt.a(obj);
        }
        signFeedListFragment.D = (FeedBubbleSignModel) obj;
        this.a = null;
        this.b = 2;
        if (BuildersKt.a(Dispatchers.b(), new AnonymousClass3(this.c, null), this) == a) {
            return a;
        }
        return Unit.a;
    }
}
