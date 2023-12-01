package com.blued.community.ui.event.vm;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.community.R;
import com.blued.community.http.EventHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedParse;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.ui.event.model.EventIdentifyModel;
import com.blued.community.utils.CommEventBusUtil;
import com.blued.community.utils.UserInfoUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/vm/EventDetailsViewModel.class */
public final class EventDetailsViewModel extends BaseViewModel {
    private boolean k;
    private int l;

    /* renamed from: a  reason: collision with root package name */
    private final MutableLiveData<EventDetailsModel> f19571a = new MutableLiveData<>();
    private final MutableLiveData<List<EventDetailsModel>> b = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private final MutableLiveData<EventIdentifyModel> f19572c = new MutableLiveData<>();
    private final MutableLiveData<List<BluedIngSelfFeed>> d = new MutableLiveData<>();
    private final MutableLiveData<Integer> e = new MutableLiveData<>();
    private String f = "";
    private EventDetailsModel g = new EventDetailsModel();
    private List<? extends EventDetailsModel> h = new ArrayList();
    private int i = 1;
    private int j = 7;
    private final MutableLiveData<Boolean> m = new MutableLiveData<>();
    private final MutableLiveData<Boolean> n = new MutableLiveData<>();

    private final BluedUIHttpResponse<?> x() {
        return new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>() { // from class: com.blued.community.ui.event.vm.EventDetailsViewModel$getResponse$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public BluedEntityA<BluedIngSelfFeed> parseData(String response) {
                Intrinsics.e(response, "response");
                BluedEntityA<BluedIngSelfFeed> parseData = (BluedEntityA) super.parseData(response);
                if (parseData == null || !parseData.hasData()) {
                    Intrinsics.c(parseData, "parseData");
                    return parseData;
                }
                for (BluedIngSelfFeed bluedIngSelfFeed : parseData.data) {
                    Intrinsics.a(bluedIngSelfFeed);
                    bluedIngSelfFeed.feedParse = new FeedParse(AppInfo.d(), bluedIngSelfFeed, 25);
                }
                return parseData;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
                if (bluedEntityA != null) {
                    if (EventDetailsViewModel.this.l() == 1 || EventDetailsViewModel.this.g().getValue() == null) {
                        EventDetailsViewModel.this.g().postValue(bluedEntityA.data);
                    } else {
                        List<BluedIngSelfFeed> value = EventDetailsViewModel.this.g().getValue();
                        if (value == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<com.blued.community.model.BluedIngSelfFeed>");
                        }
                        List f = TypeIntrinsics.f(value);
                        List<BluedIngSelfFeed> list = bluedEntityA.data;
                        Intrinsics.c(list, "parseData.data");
                        EventDetailsViewModel.this.g().setValue(CollectionsKt.b((Collection) f, (Iterable) list));
                    }
                    EventDetailsViewModel.this.c(bluedEntityA.hasMore());
                    if (bluedEntityA.extra != 0) {
                        EventDetailsViewModel.this.b(bluedEntityA.extra.total);
                    }
                }
                EventDetailsViewModel.this.p().postValue(Boolean.valueOf(EventDetailsViewModel.this.m()));
                EventDetailsViewModel.this.h().postValue(Integer.valueOf(EventDetailsViewModel.this.n()));
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                if (!z) {
                    EventDetailsViewModel eventDetailsViewModel = EventDetailsViewModel.this;
                    eventDetailsViewModel.a(eventDetailsViewModel.l() - 1);
                }
                EventDetailsViewModel.this.o().postValue(Boolean.valueOf(z));
            }
        };
    }

    public final void a(int i) {
        this.i = i;
    }

    @Override // com.blued.android.module.common.base.mvvm.BaseViewModel
    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle != null) {
            String string = bundle.getString("event_id", "");
            Intrinsics.c(string, "it.getString(EventConstants.DataKey.EVENT_ID, \"\")");
            a(string);
        }
        q();
        r();
    }

    public final void a(final IRequestHost fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        BluedUIHttpResponse<BluedEntityA<?>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<?>>(this) { // from class: com.blued.community.ui.event.vm.EventDetailsViewModel$subOwnerEvent$1
            final /* synthetic */ EventDetailsViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(IRequestHost.this);
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<?> bluedEntityA) {
                this.b.j().is_subscribe = 1;
                this.b.d().postValue(this.b.j());
                CommEventBusUtil.f20461a.d(this.b.j().uid);
                AppMethods.d(R.string.event_sub_owner_event_success);
            }
        };
        String str = this.g.uid;
        Intrinsics.c(str, "eventData.uid");
        EventHttpUtils.c(bluedUIHttpResponse, str, fragmentActive);
    }

    public final void a(EventDetailsModel eventDetailsModel) {
        Intrinsics.e(eventDetailsModel, "<set-?>");
        this.g = eventDetailsModel;
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.f = str;
    }

    public final void a(List<? extends EventDetailsModel> list) {
        Intrinsics.e(list, "<set-?>");
        this.h = list;
    }

    public final void b(int i) {
        this.l = i;
    }

    public final void b(final IRequestHost fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        BluedUIHttpResponse<BluedEntityA<Object>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<Object>>(this) { // from class: com.blued.community.ui.event.vm.EventDetailsViewModel$cancelSub$1
            final /* synthetic */ EventDetailsViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(IRequestHost.this);
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> parseData) {
                Intrinsics.e(parseData, "parseData");
                this.b.j().is_subscribe = 0;
                this.b.d().postValue(this.b.j());
                CommEventBusUtil.f20461a.e(this.b.j().uid);
            }
        };
        String str = this.g.uid;
        Intrinsics.c(str, "eventData.uid");
        EventHttpUtils.d(bluedUIHttpResponse, str, fragmentActive);
    }

    public final void c(boolean z) {
        this.k = z;
    }

    public final MutableLiveData<EventDetailsModel> d() {
        return this.f19571a;
    }

    public final MutableLiveData<List<EventDetailsModel>> e() {
        return this.b;
    }

    public final MutableLiveData<EventIdentifyModel> f() {
        return this.f19572c;
    }

    public final MutableLiveData<List<BluedIngSelfFeed>> g() {
        return this.d;
    }

    public final MutableLiveData<Integer> h() {
        return this.e;
    }

    public final String i() {
        return this.f;
    }

    public final EventDetailsModel j() {
        return this.g;
    }

    public final List<EventDetailsModel> k() {
        return this.h;
    }

    public final int l() {
        return this.i;
    }

    public final boolean m() {
        return this.k;
    }

    public final int n() {
        return this.l;
    }

    public final MutableLiveData<Boolean> o() {
        return this.m;
    }

    public final MutableLiveData<Boolean> p() {
        return this.n;
    }

    public final void q() {
        EventHttpUtils eventHttpUtils = EventHttpUtils.f19079a;
        BluedUIHttpResponse<BluedEntityA<EventDetailsModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<EventDetailsModel>>() { // from class: com.blued.community.ui.event.vm.EventDetailsViewModel$getEventDetailsData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EventDetailsModel> result) {
                Intrinsics.e(result, "result");
                EventDetailsViewModel eventDetailsViewModel = EventDetailsViewModel.this;
                EventDetailsModel singleData = result.getSingleData();
                Intrinsics.c(singleData, "result.singleData");
                eventDetailsViewModel.a(singleData);
                EventDetailsViewModel.this.d().postValue(EventDetailsViewModel.this.j());
                EventDetailsViewModel.this.v();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str, String str2) {
                EventDetailsViewModel.this.a(false);
                return super.onUIFailure(i, str, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                EventDetailsViewModel.this.a(z);
            }
        };
        String str = this.f;
        String latitude = UserInfo.getInstance().getLoginUserInfo().getLatitude();
        Intrinsics.c(latitude, "getInstance().loginUserInfo.latitude");
        String longitude = UserInfo.getInstance().getLoginUserInfo().getLongitude();
        Intrinsics.c(longitude, "getInstance().loginUserInfo.longitude");
        eventHttpUtils.a(bluedUIHttpResponse, str, latitude, longitude, (IRequestHost) null);
    }

    public final void r() {
        EventHttpUtils eventHttpUtils = EventHttpUtils.f19079a;
        BluedUIHttpResponse<BluedEntityA<EventDetailsModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<EventDetailsModel>>() { // from class: com.blued.community.ui.event.vm.EventDetailsViewModel$getRecommendEventList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EventDetailsModel> result) {
                Intrinsics.e(result, "result");
                EventDetailsViewModel eventDetailsViewModel = EventDetailsViewModel.this;
                List<EventDetailsModel> list = result.data;
                Intrinsics.c(list, "result.data");
                eventDetailsViewModel.a(list);
                EventDetailsViewModel.this.e().postValue(EventDetailsViewModel.this.k());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str, String str2) {
                EventDetailsViewModel.this.a(false);
                return super.onUIFailure(i, str, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    return;
                }
                EventDetailsViewModel.this.a(new ArrayList());
                EventDetailsViewModel.this.e().postValue(EventDetailsViewModel.this.k());
            }
        };
        String str = this.f;
        String latitude = UserInfo.getInstance().getLoginUserInfo().getLatitude();
        Intrinsics.c(latitude, "getInstance().loginUserInfo.latitude");
        String longitude = UserInfo.getInstance().getLoginUserInfo().getLongitude();
        Intrinsics.c(longitude, "getInstance().loginUserInfo.longitude");
        eventHttpUtils.b(bluedUIHttpResponse, str, latitude, longitude, null);
    }

    public final void s() {
        EventHttpUtils.f19079a.b(new BluedUIHttpResponse<BluedEntityA<EventIdentifyModel>>() { // from class: com.blued.community.ui.event.vm.EventDetailsViewModel$checkIdentify$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EventIdentifyModel> result) {
                Intrinsics.e(result, "result");
                EventDetailsViewModel.this.f().postValue(result.getSingleData());
            }
        }, null);
    }

    public final void t() {
        EventHttpUtils.f19079a.b(new BluedUIHttpResponse<BluedEntityA<EventDetailsModel>>() { // from class: com.blued.community.ui.event.vm.EventDetailsViewModel$exitEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EventDetailsModel> result) {
                Intrinsics.e(result, "result");
                EventDetailsViewModel.this.j().apply_status = 0;
                if (EventDetailsViewModel.this.j().join_num >= 1) {
                    EventDetailsViewModel.this.j().join_num--;
                }
                ListIterator<UserBasicModel> listIterator = EventDetailsViewModel.this.j().joiners.listIterator();
                while (listIterator.hasNext()) {
                    if (UserInfoUtils.c().equals(listIterator.next().uid)) {
                        listIterator.remove();
                    }
                }
                EventDetailsViewModel.this.d().postValue(EventDetailsViewModel.this.j());
                CommEventBusUtil.f20461a.b(EventDetailsViewModel.this.j());
                AppMethods.d(R.string.event_exit_event_success);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                if (z) {
                    return;
                }
                AppMethods.d(R.string.event_exit_event_fail);
            }
        }, this.f, null);
    }

    public final void u() {
        EventHttpUtils.f19079a.a(new BluedUIHttpResponse<BluedEntityA<EventDetailsModel>>() { // from class: com.blued.community.ui.event.vm.EventDetailsViewModel$toSignUp$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EventDetailsModel> result) {
                Intrinsics.e(result, "result");
                if (EventDetailsViewModel.this.j().is_free == 1) {
                    EventDetailsViewModel.this.j().apply_status = 1;
                    if (EventDetailsViewModel.this.j().join_num < EventDetailsViewModel.this.j().quota_num) {
                        EventDetailsViewModel.this.j().join_num++;
                    }
                    if (EventDetailsViewModel.this.j().joiners == null) {
                        EventDetailsViewModel.this.j().joiners = new ArrayList();
                    }
                    EventDetailsViewModel.this.j().joiners.add(new UserBasicModel(UserInfoUtils.c(), UserInfoUtils.d(), UserInfoUtils.e()));
                    EventDetailsViewModel.this.j().evaluate_status = 0;
                    AppMethods.d(R.string.event_sign_up_success_toast);
                } else {
                    EventDetailsViewModel.this.j().apply_status = 2;
                    AppMethods.d(R.string.event_sign_up_to_exmine);
                }
                EventDetailsViewModel.this.d().postValue(EventDetailsViewModel.this.j());
                CommEventBusUtil.f20461a.b(EventDetailsViewModel.this.j());
                EventDetailsViewModel.this.q();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }
        }, this.f, null);
    }

    public final void v() {
        this.i = 1;
        EventHttpUtils.f19079a.a(x(), this.g.id, this.g.uid, this.i, this.j, (IRequestHost) null);
    }

    public final void w() {
        this.i++;
        EventHttpUtils.f19079a.a(x(), this.g.id, this.g.uid, this.i, this.j, (IRequestHost) null);
    }
}
