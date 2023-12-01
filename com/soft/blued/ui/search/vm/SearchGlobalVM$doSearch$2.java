package com.soft.blued.ui.search.vm;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.db.ChattingDao;
import com.blued.android.module.common.db.model.ChattingModelDB;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.topic.model.BluedTopic;
import com.soft.blued.R;
import com.soft.blued.ui.msg.controller.tools.MsgCommonUtils;
import com.soft.blued.ui.search.api.SearchApiService;
import com.soft.blued.ui.search.model.SearchGlobalInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "SearchGlobalVM.kt", c = {}, d = "invokeSuspend", e = "com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/vm/SearchGlobalVM$doSearch$2.class */
public final class SearchGlobalVM$doSearch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f33188a;
    final /* synthetic */ SearchGlobalVM b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f33189c;
    private /* synthetic */ Object d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "SearchGlobalVM.kt", c = {92}, d = "invokeSuspend", e = "com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2$1")
    /* renamed from: com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/vm/SearchGlobalVM$doSearch$2$1.class */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f33190a;
        final /* synthetic */ SearchGlobalVM b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f33191c;
        private /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SearchGlobalVM searchGlobalVM, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.b = searchGlobalVM;
            this.f33191c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.b, this.f33191c, continuation);
            anonymousClass1.d = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            ArrayList arrayList;
            int i;
            ArrayList arrayList2;
            ArrayList arrayList3;
            int i2;
            Object a2 = IntrinsicsKt.a();
            int i3 = this.f33190a;
            if (i3 == 0) {
                ResultKt.a(obj);
                coroutineScope = (CoroutineScope) this.d;
                arrayList = this.b.e;
                arrayList.clear();
                this.d = coroutineScope;
                this.f33190a = 1;
                obj = ((SearchApiService) BluedApiProxy.b().a(SearchApiService.class)).a(this.f33191c, this);
                if (obj == a2) {
                    return a2;
                }
            } else if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                coroutineScope = (CoroutineScope) this.d;
                ResultKt.a(obj);
            }
            BluedEntityA bluedEntityA = (BluedEntityA) obj;
            SearchGlobalVM searchGlobalVM = this.b;
            if (bluedEntityA.code != 200) {
                int i4 = bluedEntityA.code;
                String message = bluedEntityA.message;
                Intrinsics.c(message, "message");
                new Error(i4, message);
            } else if (bluedEntityA.hasData()) {
                Collection data = bluedEntityA.data;
                Intrinsics.c(data, "data");
                boolean hasMore = bluedEntityA.hasMore();
                i2 = searchGlobalVM.f33186c;
                searchGlobalVM.f33186c = i2 | 4;
                CoroutineScopeKt.a(coroutineScope);
                if (!data.isEmpty()) {
                    ArrayList arrayList4 = new ArrayList();
                    SearchGlobalInfo searchGlobalInfo = new SearchGlobalInfo();
                    searchGlobalInfo.a(0);
                    searchGlobalInfo.b(3);
                    searchGlobalInfo.a(hasMore);
                    arrayList4.add(searchGlobalInfo);
                    Iterator it = data.iterator();
                    while (true) {
                        arrayList2 = arrayList4;
                        if (!it.hasNext()) {
                            break;
                        }
                        GroupInfoModel groupInfoModel = (GroupInfoModel) it.next();
                        SearchGlobalInfo searchGlobalInfo2 = new SearchGlobalInfo();
                        searchGlobalInfo2.a(3);
                        searchGlobalInfo2.a(groupInfoModel);
                        arrayList4.add(searchGlobalInfo2);
                    }
                    arrayList3 = searchGlobalVM.e;
                    arrayList3.addAll(arrayList2);
                }
                searchGlobalVM.a();
                Succeed succeed = Succeed.f10631a;
            } else {
                List b = CollectionsKt.b();
                i = searchGlobalVM.f33186c;
                searchGlobalVM.f33186c = i | 4;
                CoroutineScopeKt.a(coroutineScope);
                List list = b;
                boolean z = true;
                if (list != null) {
                    z = list.isEmpty();
                }
                if (!z) {
                    ArrayList arrayList5 = new ArrayList();
                    SearchGlobalInfo searchGlobalInfo3 = new SearchGlobalInfo();
                    searchGlobalInfo3.a(0);
                    searchGlobalInfo3.b(3);
                    searchGlobalInfo3.a(false);
                    arrayList5.add(searchGlobalInfo3);
                    Iterator it2 = b.iterator();
                    while (true) {
                        arrayList2 = arrayList5;
                        if (!it2.hasNext()) {
                            break;
                        }
                        GroupInfoModel groupInfoModel2 = (GroupInfoModel) it2.next();
                        SearchGlobalInfo searchGlobalInfo4 = new SearchGlobalInfo();
                        searchGlobalInfo4.a(3);
                        searchGlobalInfo4.a(groupInfoModel2);
                        arrayList5.add(searchGlobalInfo4);
                    }
                    arrayList3 = searchGlobalVM.e;
                    arrayList3.addAll(arrayList2);
                }
                searchGlobalVM.a();
                Succeed succeed2 = Succeed.f10631a;
            }
            return Unit.f42314a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "SearchGlobalVM.kt", c = {119}, d = "invokeSuspend", e = "com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2$2")
    /* renamed from: com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2$2  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/vm/SearchGlobalVM$doSearch$2$2.class */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f33192a;
        final /* synthetic */ SearchGlobalVM b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f33193c;
        private /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SearchGlobalVM searchGlobalVM, String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.b = searchGlobalVM;
            this.f33193c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.b, this.f33193c, continuation);
            anonymousClass2.d = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            ArrayList arrayList;
            int i;
            ArrayList arrayList2;
            ChattingModelDB c2;
            ArrayList arrayList3;
            int i2;
            ChattingModelDB c3;
            Object a2 = IntrinsicsKt.a();
            int i3 = this.f33192a;
            if (i3 == 0) {
                ResultKt.a(obj);
                coroutineScope = (CoroutineScope) this.d;
                arrayList = this.b.d;
                arrayList.clear();
                this.d = coroutineScope;
                this.f33192a = 1;
                obj = ((SearchApiService) BluedApiProxy.b().a(SearchApiService.class)).b(this.f33193c, this);
                if (obj == a2) {
                    return a2;
                }
            } else if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                coroutineScope = (CoroutineScope) this.d;
                ResultKt.a(obj);
            }
            BluedEntityA bluedEntityA = (BluedEntityA) obj;
            SearchGlobalVM searchGlobalVM = this.b;
            if (bluedEntityA.code != 200) {
                int i4 = bluedEntityA.code;
                String message = bluedEntityA.message;
                Intrinsics.c(message, "message");
                new Error(i4, message);
            } else if (bluedEntityA.hasData()) {
                Collection data = bluedEntityA.data;
                Intrinsics.c(data, "data");
                boolean hasMore = bluedEntityA.hasMore();
                i2 = searchGlobalVM.f33186c;
                searchGlobalVM.f33186c = i2 | 2;
                CoroutineScopeKt.a(coroutineScope);
                if (!data.isEmpty()) {
                    ArrayList arrayList4 = new ArrayList();
                    SearchGlobalInfo searchGlobalInfo = new SearchGlobalInfo();
                    searchGlobalInfo.a(0);
                    searchGlobalInfo.b(2);
                    searchGlobalInfo.a(hasMore);
                    arrayList4.add(searchGlobalInfo);
                    Iterator it = data.iterator();
                    while (true) {
                        arrayList2 = arrayList4;
                        if (!it.hasNext()) {
                            break;
                        }
                        SearchGlobalInfo.SearchUserModel searchUserModel = (SearchGlobalInfo.SearchUserModel) it.next();
                        ChattingDao a3 = ChattingDao.a();
                        String str = searchUserModel.uid;
                        Intrinsics.c(str, "user.uid");
                        if (a3.c(2, Long.parseLong(str)) != null) {
                            String str2 = AppInfo.d().getString(R.string.friend_global_search_recent_chat) + MsgCommonUtils.a(AppInfo.d(), c3.msgTimestamp);
                            Intrinsics.c(str2, "recentMsg.toString()");
                            searchUserModel.setRecentMsg(str2);
                        }
                        SearchGlobalInfo searchGlobalInfo2 = new SearchGlobalInfo();
                        searchGlobalInfo2.a(2);
                        searchGlobalInfo2.a(searchUserModel);
                        arrayList4.add(searchGlobalInfo2);
                    }
                    arrayList3 = searchGlobalVM.d;
                    arrayList3.addAll(arrayList2);
                }
                searchGlobalVM.a();
                Succeed succeed = Succeed.f10631a;
            } else {
                List b = CollectionsKt.b();
                i = searchGlobalVM.f33186c;
                searchGlobalVM.f33186c = i | 2;
                CoroutineScopeKt.a(coroutineScope);
                List list = b;
                boolean z = true;
                if (list != null) {
                    z = list.isEmpty();
                }
                if (!z) {
                    ArrayList arrayList5 = new ArrayList();
                    SearchGlobalInfo searchGlobalInfo3 = new SearchGlobalInfo();
                    searchGlobalInfo3.a(0);
                    searchGlobalInfo3.b(2);
                    searchGlobalInfo3.a(false);
                    arrayList5.add(searchGlobalInfo3);
                    Iterator it2 = b.iterator();
                    while (true) {
                        arrayList2 = arrayList5;
                        if (!it2.hasNext()) {
                            break;
                        }
                        SearchGlobalInfo.SearchUserModel searchUserModel2 = (SearchGlobalInfo.SearchUserModel) it2.next();
                        ChattingDao a4 = ChattingDao.a();
                        String str3 = searchUserModel2.uid;
                        Intrinsics.c(str3, "user.uid");
                        if (a4.c(2, Long.parseLong(str3)) != null) {
                            String str4 = AppInfo.d().getString(R.string.friend_global_search_recent_chat) + MsgCommonUtils.a(AppInfo.d(), c2.msgTimestamp);
                            Intrinsics.c(str4, "recentMsg.toString()");
                            searchUserModel2.setRecentMsg(str4);
                        }
                        SearchGlobalInfo searchGlobalInfo4 = new SearchGlobalInfo();
                        searchGlobalInfo4.a(2);
                        searchGlobalInfo4.a(searchUserModel2);
                        arrayList5.add(searchGlobalInfo4);
                    }
                    arrayList3 = searchGlobalVM.d;
                    arrayList3.addAll(arrayList2);
                }
                searchGlobalVM.a();
                Succeed succeed2 = Succeed.f10631a;
            }
            return Unit.f42314a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "SearchGlobalVM.kt", c = {}, d = "invokeSuspend", e = "com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2$3")
    /* renamed from: com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2$3  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/vm/SearchGlobalVM$doSearch$2$3.class */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f33194a;
        final /* synthetic */ SearchGlobalVM b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f33195c;
        private /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(SearchGlobalVM searchGlobalVM, String str, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.b = searchGlobalVM;
            this.f33195c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.b, this.f33195c, continuation);
            anonymousClass3.d = obj;
            return anonymousClass3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            List b;
            int i;
            ArrayList arrayList2;
            IntrinsicsKt.a();
            if (this.f33194a == 0) {
                ResultKt.a(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.d;
                arrayList = this.b.f;
                arrayList.clear();
                b = this.b.b(this.f33195c);
                SearchGlobalVM searchGlobalVM = this.b;
                i = searchGlobalVM.f33186c;
                searchGlobalVM.f33186c = i | 1;
                CoroutineScopeKt.a(coroutineScope);
                List list = b;
                boolean z = true;
                if (list != null) {
                    z = list.isEmpty();
                }
                if (!z) {
                    arrayList2 = this.b.f;
                    arrayList2.addAll(list);
                }
                this.b.a();
                return Unit.f42314a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "SearchGlobalVM.kt", c = {174}, d = "invokeSuspend", e = "com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2$4")
    /* renamed from: com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2$4  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/vm/SearchGlobalVM$doSearch$2$4.class */
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f33196a;
        final /* synthetic */ SearchGlobalVM b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f33197c;
        private /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(SearchGlobalVM searchGlobalVM, String str, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.b = searchGlobalVM;
            this.f33197c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.b, this.f33197c, continuation);
            anonymousClass4.d = obj;
            return anonymousClass4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            ArrayList arrayList;
            Deferred b;
            int i;
            ArrayList arrayList2;
            Object a2 = IntrinsicsKt.a();
            int i2 = this.f33196a;
            if (i2 == 0) {
                ResultKt.a(obj);
                coroutineScope = (CoroutineScope) this.d;
                arrayList = this.b.g;
                arrayList.clear();
                b = BuildersKt__Builders_commonKt.b(coroutineScope, Dispatchers.c(), null, new SearchGlobalVM$doSearch$2$4$circleJob$1(this.b, this.f33197c, null), 2, null);
                this.d = coroutineScope;
                this.f33196a = 1;
                obj = b.a(this);
                if (obj == a2) {
                    return a2;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                coroutineScope = (CoroutineScope) this.d;
                ResultKt.a(obj);
            }
            BluedEntityA bluedEntityA = (BluedEntityA) obj;
            SearchGlobalVM searchGlobalVM = this.b;
            i = searchGlobalVM.f33186c;
            searchGlobalVM.f33186c = i | 8;
            if (bluedEntityA != null) {
                SearchGlobalVM searchGlobalVM2 = this.b;
                CoroutineScopeKt.a(coroutineScope);
                if (bluedEntityA.hasData()) {
                    ArrayList arrayList3 = new ArrayList();
                    SearchGlobalInfo searchGlobalInfo = new SearchGlobalInfo();
                    searchGlobalInfo.a(0);
                    searchGlobalInfo.b(4);
                    searchGlobalInfo.a(bluedEntityA.hasMore());
                    arrayList3.add(searchGlobalInfo);
                    for (MyCircleModel myCircleModel : bluedEntityA.data) {
                        SearchGlobalInfo searchGlobalInfo2 = new SearchGlobalInfo();
                        searchGlobalInfo2.a(4);
                        searchGlobalInfo2.a(myCircleModel);
                        arrayList3.add(searchGlobalInfo2);
                    }
                    arrayList2 = searchGlobalVM2.g;
                    arrayList2.addAll(arrayList3);
                }
            }
            this.b.a();
            return Unit.f42314a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "SearchGlobalVM.kt", c = {203}, d = "invokeSuspend", e = "com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2$5")
    /* renamed from: com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2$5  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/vm/SearchGlobalVM$doSearch$2$5.class */
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f33200a;
        final /* synthetic */ SearchGlobalVM b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f33201c;
        private /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(SearchGlobalVM searchGlobalVM, String str, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.b = searchGlobalVM;
            this.f33201c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.b, this.f33201c, continuation);
            anonymousClass5.d = obj;
            return anonymousClass5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            ArrayList arrayList;
            Deferred b;
            int i;
            ArrayList arrayList2;
            Object a2 = IntrinsicsKt.a();
            int i2 = this.f33200a;
            if (i2 == 0) {
                ResultKt.a(obj);
                coroutineScope = (CoroutineScope) this.d;
                arrayList = this.b.h;
                arrayList.clear();
                b = BuildersKt__Builders_commonKt.b(coroutineScope, Dispatchers.c(), null, new SearchGlobalVM$doSearch$2$5$circleJob$1(this.b, this.f33201c, null), 2, null);
                this.d = coroutineScope;
                this.f33200a = 1;
                obj = b.a(this);
                if (obj == a2) {
                    return a2;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                coroutineScope = (CoroutineScope) this.d;
                ResultKt.a(obj);
            }
            BluedEntityA bluedEntityA = (BluedEntityA) obj;
            SearchGlobalVM searchGlobalVM = this.b;
            i = searchGlobalVM.f33186c;
            searchGlobalVM.f33186c = i | 16;
            if (bluedEntityA != null) {
                SearchGlobalVM searchGlobalVM2 = this.b;
                CoroutineScopeKt.a(coroutineScope);
                if (bluedEntityA.hasData()) {
                    ArrayList arrayList3 = new ArrayList();
                    SearchGlobalInfo searchGlobalInfo = new SearchGlobalInfo();
                    searchGlobalInfo.a(0);
                    searchGlobalInfo.b(5);
                    searchGlobalInfo.a(bluedEntityA.hasMore());
                    arrayList3.add(searchGlobalInfo);
                    for (BluedTopic bluedTopic : bluedEntityA.data) {
                        SearchGlobalInfo searchGlobalInfo2 = new SearchGlobalInfo();
                        searchGlobalInfo2.a(5);
                        searchGlobalInfo2.a(bluedTopic);
                        arrayList3.add(searchGlobalInfo2);
                    }
                    arrayList2 = searchGlobalVM2.h;
                    arrayList2.addAll(arrayList3);
                }
            }
            this.b.a();
            return Unit.f42314a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchGlobalVM$doSearch$2(SearchGlobalVM searchGlobalVM, String str, Continuation<? super SearchGlobalVM$doSearch$2> continuation) {
        super(2, continuation);
        this.b = searchGlobalVM;
        this.f33189c = str;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchGlobalVM$doSearch$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SearchGlobalVM$doSearch$2 searchGlobalVM$doSearch$2 = new SearchGlobalVM$doSearch$2(this.b, this.f33189c, continuation);
        searchGlobalVM$doSearch$2.d = obj;
        return searchGlobalVM$doSearch$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.a();
        if (this.f33188a == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.d;
            BuildersKt__Builders_commonKt.a(coroutineScope, null, null, new AnonymousClass1(this.b, this.f33189c, null), 3, null);
            BuildersKt__Builders_commonKt.a(coroutineScope, null, null, new AnonymousClass2(this.b, this.f33189c, null), 3, null);
            BuildersKt__Builders_commonKt.a(coroutineScope, null, null, new AnonymousClass3(this.b, this.f33189c, null), 3, null);
            BuildersKt__Builders_commonKt.a(coroutineScope, null, null, new AnonymousClass4(this.b, this.f33189c, null), 3, null);
            BuildersKt__Builders_commonKt.a(coroutineScope, null, null, new AnonymousClass5(this.b, this.f33189c, null), 3, null);
            return Unit.f42314a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
