package com.soft.blued.ui.search.vm;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
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
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "SearchGlobalVM.kt", c = {}, d = "invokeSuspend", e = "com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/vm/SearchGlobalVM$doSearch$2.class */
public final class SearchGlobalVM$doSearch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f19497a;
    final /* synthetic */ SearchGlobalVM b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f19498c;
    private /* synthetic */ Object d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "SearchGlobalVM.kt", c = {92}, d = "invokeSuspend", e = "com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2$1")
    /* renamed from: com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/vm/SearchGlobalVM$doSearch$2$1.class */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f19499a;
        final /* synthetic */ SearchGlobalVM b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19500c;
        private /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SearchGlobalVM searchGlobalVM, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.b = searchGlobalVM;
            this.f19500c = str;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.a);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.b, this.f19500c, continuation);
            anonymousClass1.d = obj;
            return anonymousClass1;
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            ArrayList arrayList;
            int i;
            ArrayList arrayList2;
            ArrayList arrayList3;
            int i2;
            Object a2 = IntrinsicsKt.a();
            int i3 = this.f19499a;
            if (i3 == 0) {
                ResultKt.a(obj);
                coroutineScope = (CoroutineScope) this.d;
                arrayList = this.b.e;
                arrayList.clear();
                this.d = coroutineScope;
                this.f19499a = 1;
                obj = ((SearchApiService) BluedApiProxy.b().a(SearchApiService.class)).a(this.f19500c, (Continuation) this);
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
                String str = bluedEntityA.message;
                Intrinsics.c(str, "message");
                new Error(i4, str);
            } else if (bluedEntityA.hasData()) {
                List list = bluedEntityA.data;
                Intrinsics.c(list, "data");
                boolean hasMore = bluedEntityA.hasMore();
                i2 = searchGlobalVM.f19495c;
                searchGlobalVM.f19495c = i2 | 4;
                CoroutineScopeKt.a(coroutineScope);
                if (!list.isEmpty()) {
                    ArrayList arrayList4 = new ArrayList();
                    SearchGlobalInfo searchGlobalInfo = new SearchGlobalInfo();
                    searchGlobalInfo.a(0);
                    searchGlobalInfo.b(3);
                    searchGlobalInfo.a(hasMore);
                    arrayList4.add(searchGlobalInfo);
                    Iterator it = list.iterator();
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
                ApiState apiState = Succeed.a;
            } else {
                List b = CollectionsKt.b();
                i = searchGlobalVM.f19495c;
                searchGlobalVM.f19495c = i | 4;
                CoroutineScopeKt.a(coroutineScope);
                List list2 = b;
                boolean z = true;
                if (list2 != null) {
                    z = list2.isEmpty();
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
                ApiState apiState2 = Succeed.a;
            }
            return Unit.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "SearchGlobalVM.kt", c = {119}, d = "invokeSuspend", e = "com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2$2")
    /* renamed from: com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2$2  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/vm/SearchGlobalVM$doSearch$2$2.class */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f19501a;
        final /* synthetic */ SearchGlobalVM b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19502c;
        private /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SearchGlobalVM searchGlobalVM, String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.b = searchGlobalVM;
            this.f19502c = str;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.a);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.b, this.f19502c, continuation);
            anonymousClass2.d = obj;
            return anonymousClass2;
        }

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
            int i3 = this.f19501a;
            if (i3 == 0) {
                ResultKt.a(obj);
                coroutineScope = (CoroutineScope) this.d;
                arrayList = this.b.d;
                arrayList.clear();
                this.d = coroutineScope;
                this.f19501a = 1;
                obj = ((SearchApiService) BluedApiProxy.b().a(SearchApiService.class)).b(this.f19502c, (Continuation) this);
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
                String str = bluedEntityA.message;
                Intrinsics.c(str, "message");
                new Error(i4, str);
            } else if (bluedEntityA.hasData()) {
                List list = bluedEntityA.data;
                Intrinsics.c(list, "data");
                boolean hasMore = bluedEntityA.hasMore();
                i2 = searchGlobalVM.f19495c;
                searchGlobalVM.f19495c = i2 | 2;
                CoroutineScopeKt.a(coroutineScope);
                if (!list.isEmpty()) {
                    ArrayList arrayList4 = new ArrayList();
                    SearchGlobalInfo searchGlobalInfo = new SearchGlobalInfo();
                    searchGlobalInfo.a(0);
                    searchGlobalInfo.b(2);
                    searchGlobalInfo.a(hasMore);
                    arrayList4.add(searchGlobalInfo);
                    Iterator it = list.iterator();
                    while (true) {
                        arrayList2 = arrayList4;
                        if (!it.hasNext()) {
                            break;
                        }
                        SearchGlobalInfo.SearchUserModel searchUserModel = (SearchGlobalInfo.SearchUserModel) it.next();
                        ChattingDao a3 = ChattingDao.a();
                        String str2 = searchUserModel.uid;
                        Intrinsics.c(str2, "user.uid");
                        if (a3.c(2, Long.parseLong(str2)) != null) {
                            String str3 = AppInfo.d().getString(R.string.friend_global_search_recent_chat) + MsgCommonUtils.a(AppInfo.d(), c3.msgTimestamp);
                            Intrinsics.c(str3, "recentMsg.toString()");
                            searchUserModel.setRecentMsg(str3);
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
                ApiState apiState = Succeed.a;
            } else {
                List b = CollectionsKt.b();
                i = searchGlobalVM.f19495c;
                searchGlobalVM.f19495c = i | 2;
                CoroutineScopeKt.a(coroutineScope);
                List list2 = b;
                boolean z = true;
                if (list2 != null) {
                    z = list2.isEmpty();
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
                        String str4 = searchUserModel2.uid;
                        Intrinsics.c(str4, "user.uid");
                        if (a4.c(2, Long.parseLong(str4)) != null) {
                            String str5 = AppInfo.d().getString(R.string.friend_global_search_recent_chat) + MsgCommonUtils.a(AppInfo.d(), c2.msgTimestamp);
                            Intrinsics.c(str5, "recentMsg.toString()");
                            searchUserModel2.setRecentMsg(str5);
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
                ApiState apiState2 = Succeed.a;
            }
            return Unit.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "SearchGlobalVM.kt", c = {}, d = "invokeSuspend", e = "com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2$3")
    /* renamed from: com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2$3  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/vm/SearchGlobalVM$doSearch$2$3.class */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f19503a;
        final /* synthetic */ SearchGlobalVM b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19504c;
        private /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(SearchGlobalVM searchGlobalVM, String str, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.b = searchGlobalVM;
            this.f19504c = str;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.a);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass3 = new AnonymousClass3(this.b, this.f19504c, continuation);
            anonymousClass3.d = obj;
            return anonymousClass3;
        }

        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            List b;
            int i;
            ArrayList arrayList2;
            IntrinsicsKt.a();
            if (this.f19503a == 0) {
                ResultKt.a(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.d;
                arrayList = this.b.f;
                arrayList.clear();
                b = this.b.b(this.f19504c);
                SearchGlobalVM searchGlobalVM = this.b;
                i = searchGlobalVM.f19495c;
                searchGlobalVM.f19495c = i | 1;
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
                return Unit.a;
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
        int f19505a;
        final /* synthetic */ SearchGlobalVM b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19506c;
        private /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(SearchGlobalVM searchGlobalVM, String str, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.b = searchGlobalVM;
            this.f19506c = str;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.a);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass4 = new AnonymousClass4(this.b, this.f19506c, continuation);
            anonymousClass4.d = obj;
            return anonymousClass4;
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            ArrayList arrayList;
            int i;
            ArrayList arrayList2;
            Object a2 = IntrinsicsKt.a();
            int i2 = this.f19505a;
            if (i2 == 0) {
                ResultKt.a(obj);
                coroutineScope = (CoroutineScope) this.d;
                arrayList = this.b.g;
                arrayList.clear();
                this.d = coroutineScope;
                this.f19505a = 1;
                obj = BuildersKt.b(coroutineScope, Dispatchers.c(), (CoroutineStart) null, new SearchGlobalVM$doSearch$2$4$circleJob$1(this.b, this.f19506c, null), 2, (Object) null).a((Continuation) this);
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
            i = searchGlobalVM.f19495c;
            searchGlobalVM.f19495c = i | 8;
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
            return Unit.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "SearchGlobalVM.kt", c = {203}, d = "invokeSuspend", e = "com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2$5")
    /* renamed from: com.soft.blued.ui.search.vm.SearchGlobalVM$doSearch$2$5  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/vm/SearchGlobalVM$doSearch$2$5.class */
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f19509a;
        final /* synthetic */ SearchGlobalVM b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19510c;
        private /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(SearchGlobalVM searchGlobalVM, String str, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.b = searchGlobalVM;
            this.f19510c = str;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.a);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass5 = new AnonymousClass5(this.b, this.f19510c, continuation);
            anonymousClass5.d = obj;
            return anonymousClass5;
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            ArrayList arrayList;
            int i;
            ArrayList arrayList2;
            Object a2 = IntrinsicsKt.a();
            int i2 = this.f19509a;
            if (i2 == 0) {
                ResultKt.a(obj);
                coroutineScope = (CoroutineScope) this.d;
                arrayList = this.b.h;
                arrayList.clear();
                this.d = coroutineScope;
                this.f19509a = 1;
                obj = BuildersKt.b(coroutineScope, Dispatchers.c(), (CoroutineStart) null, new SearchGlobalVM$doSearch$2$5$circleJob$1(this.b, this.f19510c, null), 2, (Object) null).a((Continuation) this);
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
            i = searchGlobalVM.f19495c;
            searchGlobalVM.f19495c = i | 16;
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
            return Unit.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchGlobalVM$doSearch$2(SearchGlobalVM searchGlobalVM, String str, Continuation<? super SearchGlobalVM$doSearch$2> continuation) {
        super(2, continuation);
        this.b = searchGlobalVM;
        this.f19498c = str;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> searchGlobalVM$doSearch$2 = new SearchGlobalVM$doSearch$2(this.b, this.f19498c, continuation);
        searchGlobalVM$doSearch$2.d = obj;
        return searchGlobalVM$doSearch$2;
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.a();
        if (this.f19497a == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.d;
            BuildersKt.a(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.b, this.f19498c, null), 3, (Object) null);
            BuildersKt.a(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(this.b, this.f19498c, null), 3, (Object) null);
            BuildersKt.a(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass3(this.b, this.f19498c, null), 3, (Object) null);
            BuildersKt.a(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass4(this.b, this.f19498c, null), 3, (Object) null);
            BuildersKt.a(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass5(this.b, this.f19498c, null), 3, (Object) null);
            return Unit.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
