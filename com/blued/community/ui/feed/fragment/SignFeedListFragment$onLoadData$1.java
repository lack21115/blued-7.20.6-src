package com.blued.community.ui.feed.fragment;

import com.blued.community.model.FeedBubbleSignModel;
import com.blued.das.live.LiveProtos;
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
@DebugMetadata(b = "SignFeedListFragment.kt", c = {LiveProtos.Event.LIVE_SHOW_PAGE_GUILD_PAGE_SHOW_VALUE, 719}, d = "invokeSuspend", e = "com.blued.community.ui.feed.fragment.SignFeedListFragment$onLoadData$1")
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/fragment/SignFeedListFragment$onLoadData$1.class */
public final class SignFeedListFragment$onLoadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    Object f19809a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ SignFeedListFragment f19810c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "SignFeedListFragment.kt", c = {717}, d = "invokeSuspend", e = "com.blued.community.ui.feed.fragment.SignFeedListFragment$onLoadData$1$2")
    /* renamed from: com.blued.community.ui.feed.fragment.SignFeedListFragment$onLoadData$1$2  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/fragment/SignFeedListFragment$onLoadData$1$2.class */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FeedBubbleSignModel>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f19811a;
        final /* synthetic */ SignFeedListFragment b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SignFeedListFragment signFeedListFragment, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.b = signFeedListFragment;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FeedBubbleSignModel> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object a2;
            Object a3 = IntrinsicsKt.a();
            int i = this.f19811a;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.a(obj);
                    return obj;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.a(obj);
            this.f19811a = 1;
            a2 = this.b.a(this);
            return a2 == a3 ? a3 : a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "SignFeedListFragment.kt", c = {}, d = "invokeSuspend", e = "com.blued.community.ui.feed.fragment.SignFeedListFragment$onLoadData$1$3")
    /* renamed from: com.blued.community.ui.feed.fragment.SignFeedListFragment$onLoadData$1$3  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/fragment/SignFeedListFragment$onLoadData$1$3.class */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f19812a;
        final /* synthetic */ SignFeedListFragment b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(SignFeedListFragment signFeedListFragment, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.b = signFeedListFragment;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.a();
            if (this.f19812a == 0) {
                ResultKt.a(obj);
                this.b.G();
                return Unit.f42314a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignFeedListFragment$onLoadData$1(SignFeedListFragment signFeedListFragment, Continuation<? super SignFeedListFragment$onLoadData$1> continuation) {
        super(2, continuation);
        this.f19810c = signFeedListFragment;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SignFeedListFragment$onLoadData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SignFeedListFragment$onLoadData$1(this.f19810c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SignFeedListFragment signFeedListFragment;
        Object a2 = IntrinsicsKt.a();
        int i = this.b;
        if (i == 0) {
            ResultKt.a(obj);
            signFeedListFragment = this.f19810c;
            this.f19809a = signFeedListFragment;
            this.b = 1;
            Object a3 = BuildersKt.a(Dispatchers.c().plus(new SignFeedListFragment$onLoadData$1$invokeSuspend$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.b)), new AnonymousClass2(this.f19810c, null), this);
            obj = a3;
            if (a3 == a2) {
                return a2;
            }
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.a(obj);
                return Unit.f42314a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            signFeedListFragment = (SignFeedListFragment) this.f19809a;
            ResultKt.a(obj);
        }
        signFeedListFragment.D = (FeedBubbleSignModel) obj;
        this.f19809a = null;
        this.b = 2;
        if (BuildersKt.a(Dispatchers.b(), new AnonymousClass3(this.f19810c, null), this) == a2) {
            return a2;
        }
        return Unit.f42314a;
    }
}
