package com.blued.android.module.yy_china.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.HomeTopicModel;
import com.blued.android.module.yy_china.model.YYBannerModel;
import com.blued.android.module.yy_china.model.YYChatRoomGuideListMode;
import com.blued.android.module.yy_china.model.YYChatRoomGuideMode;
import com.blued.android.module.yy_china.model.YYExRoomModel;
import com.blued.android.module.yy_china.model.YYLiveState;
import com.blued.android.module.yy_china.model.YYMatchRoomModel;
import com.blued.android.module.yy_china.model.YYRoomExtraModel;
import com.blued.android.module.yy_china.model.YYRoomGuideExtraModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/YYChatRoomsListViewModel.class */
public final class YYChatRoomsListViewModel extends BaseViewModel {
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f17747c;
    private List<? extends HomeTopicModel> o;

    /* renamed from: a  reason: collision with root package name */
    private String f17746a = "0";
    private final MutableLiveData<List<HomeTopicModel>> d = new MutableLiveData<>();
    private final MutableLiveData<Boolean> e = new MutableLiveData<>();
    private final MutableLiveData<Boolean> f = new MutableLiveData<>();
    private final MutableLiveData<Boolean> g = new MutableLiveData<>();
    private final MutableLiveData<Boolean> h = new MutableLiveData<>();
    private final MutableLiveData<Boolean> i = new MutableLiveData<>();
    private final MutableLiveData<List<YYBannerModel>> j = new MutableLiveData<>();
    private final MutableLiveData<YYRoomExtraModel> k = new MutableLiveData<>();
    private final MutableLiveData<YYLiveState> l = new MutableLiveData<>();
    private final MutableLiveData<YYMatchRoomModel> m = new MutableLiveData<>();
    private final MutableLiveData<YYChatRoomGuideListMode> n = new MutableLiveData<>();
    private long p = -1;

    private final void e(final ActivityFragmentActive activityFragmentActive) {
        YYRoomHttpUtils.k(new BluedUIHttpResponse<BluedEntityA<YYBannerModel>>(this) { // from class: com.blued.android.module.yy_china.presenter.YYChatRoomsListViewModel$getBannerList$1
            final /* synthetic */ YYChatRoomsListViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ActivityFragmentActive.this);
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYBannerModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    this.b.l().postValue(new ArrayList());
                } else {
                    this.b.l().postValue(bluedEntityA.data);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                this.b.l().postValue(new ArrayList());
                return super.onUIFailure(i, errorMessage);
            }
        }, activityFragmentActive);
    }

    private final void f(final ActivityFragmentActive activityFragmentActive) {
        YYRoomHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<HomeTopicModel, YYRoomExtraModel>>(this) { // from class: com.blued.android.module.yy_china.presenter.YYChatRoomsListViewModel$getYYTopics$1
            final /* synthetic */ YYChatRoomsListViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ActivityFragmentActive.this);
                this.b = this;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                Logger.e("cache", "yy topic list onUIFailure ... ");
                this.b.h().postValue(true);
                return super.onUIFailure(i, errorMessage);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<HomeTopicModel, YYRoomExtraModel> bluedEntity) {
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    this.b.g().postValue(true);
                    return;
                }
                this.b.a(bluedEntity.data);
                this.b.m().postValue(bluedEntity.extra);
                this.b.f().postValue(this.b.q());
            }
        }, (IRequestHost) activityFragmentActive);
    }

    @Override // com.blued.android.module.common.base.mvvm.BaseViewModel
    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle == null) {
            return;
        }
        String string = bundle.getString("type_id", "0");
        Intrinsics.c(string, "it.getString(\"type_id\", \"0\")");
        a(string);
        b(bundle.getString("from_source", ""));
        c(bundle.getString(TTLiveConstants.ROOMID_KEY, ""));
    }

    public final void a(ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        f(fragmentActive);
        e(fragmentActive);
    }

    public final void a(final ActivityFragmentActive fragmentActive, final Activity active, final String str, String str2, String str3, final String str4, String str5, boolean z, int i) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        Intrinsics.e(active, "active");
        YYRoomHttpUtils.a(str, str2, str5, str3, z, i, new BluedUIHttpResponse<BluedEntity<YYRoomModel, YYExRoomModel>>(this, active, str4, str) { // from class: com.blued.android.module.yy_china.presenter.YYChatRoomsListViewModel$createYYRoom$1
            final /* synthetic */ YYChatRoomsListViewModel b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Activity f17749c;
            final /* synthetic */ String d;
            final /* synthetic */ String e;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ActivityFragmentActive.this);
                this.b = this;
                this.f17749c = active;
                this.d = str4;
                this.e = str;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                ToastUtils.a(errorMessage, 0);
                if (i2 == 40380007) {
                    EventTrackYY.c(ChatRoomProtos.Event.CHAT_ROOM_NAME_INVALITE_SHOW, this.e);
                }
                return super.onUIFailure(i2, errorMessage);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z2) {
                super.onUIFinish(z2);
                this.b.j().postValue(true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                this.b.i().postValue(true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYRoomModel, YYExRoomModel> response) {
                Intrinsics.e(response, "response");
                this.b.k().postValue(true);
                YYRoomModel singleData = response.getSingleData();
                if (singleData == null) {
                    return;
                }
                Activity activity = this.f17749c;
                String str6 = this.d;
                ActivityFragmentActive activityFragmentActive = ActivityFragmentActive.this;
                YYExRoomModel yYExRoomModel = response.extra;
                if (yYExRoomModel != null) {
                    singleData.task_url = yYExRoomModel.getTask_url();
                }
                if (singleData.mics != null && singleData.mics.size() > 0) {
                    singleData.mics.get(0).is_open_mic = 2;
                    if (TextUtils.equals(singleData.chat_type, "4")) {
                        singleData.mics.get(0).itemType = 2;
                        singleData.mics.get(1).itemType = 3;
                    } else if (TextUtils.equals(singleData.chat_type, "8") || TextUtils.equals(singleData.chat_type, "11")) {
                        singleData.mics.get(singleData.mics.size() - 1).isVip = true;
                    }
                }
                YYRoomInfoManager.e().a(singleData);
                YYRoomInfoManager.e().a((Context) activity);
                if (str6 != null) {
                    YYRoomHttpUtils.a(singleData.room_id, str6, activityFragmentActive);
                }
                if (TextUtils.equals(singleData.chat_type, "9")) {
                    return;
                }
                YYRoomInfoManager.e().B();
            }
        }, fragmentActive);
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.f17746a = str;
    }

    public final void a(List<? extends HomeTopicModel> list) {
        this.o = list;
    }

    public final void b(final ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        YYRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<YYLiveState>>(this) { // from class: com.blued.android.module.yy_china.presenter.YYChatRoomsListViewModel$getLiveState$1
            final /* synthetic */ YYChatRoomsListViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ActivityFragmentActive.this);
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYLiveState> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                this.b.n().postValue(bluedEntityA.data.get(0));
            }
        }, YYRoomInfoManager.e().c().c(), fragmentActive);
    }

    public final void b(String str) {
        this.b = str;
    }

    public final void c(final ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        YYRoomHttpUtils.d((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<YYChatRoomGuideMode, YYRoomGuideExtraModel>>(this) { // from class: com.blued.android.module.yy_china.presenter.YYChatRoomsListViewModel$getChatRoomGuide$1
            final /* synthetic */ YYChatRoomsListViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ActivityFragmentActive.this);
                this.b = this;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYChatRoomGuideMode, YYRoomGuideExtraModel> entity) {
                Intrinsics.e(entity, "entity");
                if (entity.extra != null) {
                    YYRoomGuideExtraModel yYRoomGuideExtraModel = entity.extra;
                    boolean z = false;
                    if (yYRoomGuideExtraModel != null && yYRoomGuideExtraModel.is_show == 1) {
                        MutableLiveData<YYChatRoomGuideListMode> p = this.b.p();
                        List<YYChatRoomGuideMode> list = entity.data;
                        YYRoomGuideExtraModel yYRoomGuideExtraModel2 = entity.extra;
                        Intrinsics.a(yYRoomGuideExtraModel2);
                        if (yYRoomGuideExtraModel2.is_new == 1) {
                            z = true;
                        }
                        p.postValue(new YYChatRoomGuideListMode(list, z));
                    }
                }
            }
        }, (IRequestHost) fragmentActive);
    }

    public final void c(String str) {
        this.f17747c = str;
    }

    public final String d() {
        return this.f17746a;
    }

    public final void d(final ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.p;
        if (j == -1 || currentTimeMillis - j >= 2000) {
            this.p = currentTimeMillis;
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_RANDOM_CLICK);
            YYRoomHttpUtils.g(new BluedUIHttpResponse<BluedEntityA<YYMatchRoomModel>>(this) { // from class: com.blued.android.module.yy_china.presenter.YYChatRoomsListViewModel$joinMatchRoom$1
                final /* synthetic */ YYChatRoomsListViewModel b;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(ActivityFragmentActive.this);
                    this.b = this;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<YYMatchRoomModel> response) {
                    Intrinsics.e(response, "response");
                    if (response.data != null && response.data.size() > 0) {
                        this.b.o().postValue(response.data.get(0));
                    }
                    this.b.p = -1L;
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str, String str2) {
                    this.b.p = -1L;
                    return super.onUIFailure(i, str, str2);
                }
            }, fragmentActive);
        }
    }

    public final String e() {
        return this.b;
    }

    public final MutableLiveData<List<HomeTopicModel>> f() {
        return this.d;
    }

    public final MutableLiveData<Boolean> g() {
        return this.e;
    }

    public final MutableLiveData<Boolean> h() {
        return this.f;
    }

    public final MutableLiveData<Boolean> i() {
        return this.g;
    }

    public final MutableLiveData<Boolean> j() {
        return this.h;
    }

    public final MutableLiveData<Boolean> k() {
        return this.i;
    }

    public final MutableLiveData<List<YYBannerModel>> l() {
        return this.j;
    }

    public final MutableLiveData<YYRoomExtraModel> m() {
        return this.k;
    }

    public final MutableLiveData<YYLiveState> n() {
        return this.l;
    }

    public final MutableLiveData<YYMatchRoomModel> o() {
        return this.m;
    }

    public final MutableLiveData<YYChatRoomGuideListMode> p() {
        return this.n;
    }

    public final List<HomeTopicModel> q() {
        return this.o;
    }
}
