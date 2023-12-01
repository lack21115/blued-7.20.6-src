package com.soft.blued.ui.search.vm;

import androidx.lifecycle.ViewModelKt;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.blued.android.module.common.base.mvi.MviEvent;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.das.guy.GuyProtos;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.search.model.SearchGlobalInfo;
import com.soft.blued.ui.search.model.SearchSessionModel;
import com.soft.blued.ui.search.state.SearchGlobalAction;
import com.soft.blued.ui.search.state.SearchGlobalEvent;
import com.soft.blued.ui.search.state.SearchGlobalState;
import com.soft.blued.ui.search.utils.SearchGlobalUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/vm/SearchGlobalVM.class */
public final class SearchGlobalVM extends MVIBaseViewModel<SearchGlobalState, SearchGlobalAction> {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f33185a = new Companion(null);
    private Job b;

    /* renamed from: c  reason: collision with root package name */
    private int f33186c;
    private final ArrayList<SearchGlobalInfo> d = new ArrayList<>();
    private final ArrayList<SearchGlobalInfo> e = new ArrayList<>();
    private final ArrayList<SearchGlobalInfo> f = new ArrayList<>();
    private final ArrayList<SearchGlobalInfo> g = new ArrayList<>();
    private final ArrayList<SearchGlobalInfo> h = new ArrayList<>();

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/vm/SearchGlobalVM$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a(String str, Continuation<? super BluedEntityA<MyCircleModel>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.a(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        FeedHttpUtils.a(str, new BluedUIHttpResponse<BluedEntityA<MyCircleModel>>() { // from class: com.soft.blued.ui.search.vm.SearchGlobalVM$getCircle$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MyCircleModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    Continuation<BluedEntityA<MyCircleModel>> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.f42293a;
                    continuation2.resumeWith(Result.f(null));
                    return;
                }
                Continuation<BluedEntityA<MyCircleModel>> continuation3 = safeContinuation2;
                Result.Companion companion2 = Result.f42293a;
                continuation3.resumeWith(Result.f(bluedEntityA));
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    return;
                }
                Continuation<BluedEntityA<MyCircleModel>> continuation2 = safeContinuation2;
                Result.Companion companion = Result.f42293a;
                continuation2.resumeWith(Result.f(null));
            }
        }, (IRequestHost) null);
        Object a2 = safeContinuation.a();
        if (a2 == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.d);
        arrayList.addAll(this.f);
        arrayList.addAll(this.e);
        arrayList.addAll(this.g);
        arrayList.addAll(this.h);
        SearchGlobalVM searchGlobalVM = this;
        BluedStructureExtKt.a(searchGlobalVM, new Function1<SearchGlobalState, SearchGlobalState>() { // from class: com.soft.blued.ui.search.vm.SearchGlobalVM$refreshList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final SearchGlobalState invoke(SearchGlobalState setState) {
                Intrinsics.e(setState, "$this$setState");
                return SearchGlobalState.copy$default(setState, arrayList, null, 2, null);
            }
        });
        if (b()) {
            BluedStructureExtKt.a(searchGlobalVM, new MviEvent.LoadFinished(false, false, 3, null));
            if (arrayList.isEmpty()) {
                BluedStructureExtKt.a(searchGlobalVM, MviEvent.DataEmpty.f10682a);
            }
        }
    }

    private final void a(String str) {
        Job a2;
        BluedStructureExtKt.a(this, MviEvent.LoadStarted.f10685a);
        EventTrackGuy.b(GuyProtos.Event.SEARCH_ALL_SEARCH, str);
        Job job = this.b;
        if (job != null) {
            Job.DefaultImpls.a(job, null, 1, null);
        }
        this.f33186c = 0;
        a2 = BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), Dispatchers.c().plus(new SearchGlobalVM$doSearch$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.b, this)), null, new SearchGlobalVM$doSearch$2(this, str, null), 2, null);
        this.b = a2;
    }

    private final void a(String str, final IRequestHost iRequestHost) {
        SearchGlobalUtil.f33175a.a(new BluedUIHttpResponse<BluedEntityA<SearchGlobalInfo.SearchShortcutModel>>(this) { // from class: com.soft.blued.ui.search.vm.SearchGlobalVM$getShortcut$1
            final /* synthetic */ SearchGlobalVM b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(IRequestHost.this);
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<SearchGlobalInfo.SearchShortcutModel> bluedEntityA) {
                BluedStructureExtKt.a(this.b, new SearchGlobalEvent.ShortcutEvent(bluedEntityA == null ? null : bluedEntityA.data));
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                return true;
            }
        }, str, iRequestHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object b(String str, Continuation<? super BluedEntityA<BluedTopic>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.a(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        FeedHttpUtils.b(str, new BluedUIHttpResponse<BluedEntityA<BluedTopic>>() { // from class: com.soft.blued.ui.search.vm.SearchGlobalVM$getSubject$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedTopic> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    Continuation<BluedEntityA<BluedTopic>> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.f42293a;
                    continuation2.resumeWith(Result.f(null));
                    return;
                }
                Continuation<BluedEntityA<BluedTopic>> continuation3 = safeContinuation2;
                Result.Companion companion2 = Result.f42293a;
                continuation3.resumeWith(Result.f(bluedEntityA));
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    return;
                }
                Continuation<BluedEntityA<BluedTopic>> continuation2 = safeContinuation2;
                Result.Companion companion = Result.f42293a;
                continuation2.resumeWith(Result.f(null));
            }
        }, (IRequestHost) null);
        Object a2 = safeContinuation.a();
        if (a2 == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SearchGlobalInfo> b(String str) {
        boolean z;
        List<SearchSessionModel> a2 = SearchGlobalUtil.f33175a.a(str);
        ArrayList arrayList = new ArrayList();
        Iterator<E> it = CollectionsKt.b((Iterable) a2, 3).iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            SearchSessionModel searchSessionModel = (SearchSessionModel) it.next();
            SearchGlobalInfo searchGlobalInfo = new SearchGlobalInfo();
            searchGlobalInfo.a(searchSessionModel);
            searchGlobalInfo.a(1);
            arrayList.add(searchGlobalInfo);
        }
        if (arrayList.size() > 0) {
            SearchGlobalInfo searchGlobalInfo2 = new SearchGlobalInfo();
            searchGlobalInfo2.a(0);
            searchGlobalInfo2.b(1);
            if (a2.size() <= 3) {
                z = false;
            }
            searchGlobalInfo2.a(z);
            Unit unit = Unit.f42314a;
            arrayList.add(0, searchGlobalInfo2);
        }
        return arrayList;
    }

    private final boolean b() {
        int i = this.f33186c;
        return ((i >> 0) & 1) > 0 && ((i >> 2) & 1) > 0 && ((i >> 1) & 1) > 0 && ((i >> 3) & 1) > 0 && ((i >> 4) & 1) > 0;
    }

    private final void c() {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), Dispatchers.c(), null, new SearchGlobalVM$getRecentRecord$1(this, null), 2, null);
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseViewModel
    /* renamed from: a */
    public void dispatchAction(SearchGlobalAction action) {
        Intrinsics.e(action, "action");
        if (action instanceof SearchGlobalAction.DoSearch) {
            a(((SearchGlobalAction.DoSearch) action).a());
        } else if (action instanceof SearchGlobalAction.GetRecentRecord) {
            c();
        } else if (action instanceof SearchGlobalAction.GetShortcut) {
            SearchGlobalAction.GetShortcut getShortcut = (SearchGlobalAction.GetShortcut) action;
            a(getShortcut.a(), getShortcut.b());
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        SearchGlobalUtil.f33175a.b();
    }
}
