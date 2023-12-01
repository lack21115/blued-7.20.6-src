package com.blued.android.module.yy_china.model;

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
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYHomeChatsViewModel.class */
public final class YYHomeChatsViewModel extends BaseViewModel {
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f17620c;
    private List<HomeThemeModel> p;

    /* renamed from: a  reason: collision with root package name */
    private String f17619a = "0";
    private long d = -1;
    private final MutableLiveData<List<HomeThemeModel>> e = new MutableLiveData<>();
    private final MutableLiveData<Boolean> f = new MutableLiveData<>();
    private final MutableLiveData<Boolean> g = new MutableLiveData<>();
    private final MutableLiveData<Boolean> h = new MutableLiveData<>();
    private final MutableLiveData<Boolean> i = new MutableLiveData<>();
    private final MutableLiveData<Boolean> j = new MutableLiveData<>();
    private final MutableLiveData<YYRoomExtraModel> k = new MutableLiveData<>();
    private final MutableLiveData<YYLiveState> l = new MutableLiveData<>();
    private final MutableLiveData<YYMatchRoomModel> m = new MutableLiveData<>();
    private final MutableLiveData<YYChatRoomGuideListMode> n = new MutableLiveData<>();
    private MutableLiveData<YYHomeChatsMode> o = new MutableLiveData<>();

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

    public final void a(final ActivityFragmentActive activityFragmentActive) {
        YYRoomHttpUtils.c((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYHomeChatsMode>>(this) { // from class: com.blued.android.module.yy_china.model.YYHomeChatsViewModel$getCradInfo$1
            final /* synthetic */ YYHomeChatsViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ActivityFragmentActive.this);
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYHomeChatsMode> p0) {
                Intrinsics.e(p0, "p0");
                if (p0.hasData()) {
                    this.b.p().postValue(p0.getSingleData());
                }
            }
        }, (IRequestHost) activityFragmentActive);
    }

    public final void a(final ActivityFragmentActive fragmentActive, final Activity active, final String str, String str2, String str3, final String str4, String str5, boolean z, final int i) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        Intrinsics.e(active, "active");
        YYRoomHttpUtils.a(str, str2, str5, str3, z, i, new BluedUIHttpResponse<BluedEntity<YYRoomModel, YYExRoomModel>>(this, active, str4, i, str) { // from class: com.blued.android.module.yy_china.model.YYHomeChatsViewModel$createYYRoom$1
            final /* synthetic */ YYHomeChatsViewModel b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Activity f17622c;
            final /* synthetic */ String d;
            final /* synthetic */ int e;
            final /* synthetic */ String f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ActivityFragmentActive.this);
                this.b = this;
                this.f17622c = active;
                this.d = str4;
                this.e = i;
                this.f = str;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                ToastUtils.a(errorMessage, 0);
                if (i2 == 40380007) {
                    EventTrackYY.c(ChatRoomProtos.Event.CHAT_ROOM_NAME_INVALITE_SHOW, this.e == 1 ? this.f : "8");
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
                Activity activity = this.f17622c;
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
        this.f17619a = str;
    }

    public final void a(List<HomeThemeModel> list) {
        this.p = list;
    }

    public final void b(final ActivityFragmentActive activityFragmentActive) {
        YYRoomHttpUtils.b((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<HomeThemeModel, YYRoomExtraModel>>(this) { // from class: com.blued.android.module.yy_china.model.YYHomeChatsViewModel$getYYTopics$1
            final /* synthetic */ YYHomeChatsViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ActivityFragmentActive.this);
                this.b = this;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                this.b.h().postValue(true);
                return super.onUIFailure(i, errorMessage);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<HomeThemeModel, YYRoomExtraModel> bluedEntity) {
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    this.b.g().postValue(true);
                    return;
                }
                this.b.a(bluedEntity.data);
                this.b.l().postValue(bluedEntity.extra);
                this.b.f().postValue(this.b.q());
            }
        }, (IRequestHost) activityFragmentActive);
    }

    public final void b(String str) {
        this.b = str;
    }

    public final void c(final ActivityFragmentActive activityFragmentActive) {
        YYRoomHttpUtils.b((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<HomeThemeModel, YYRoomExtraModel>>(this) { // from class: com.blued.android.module.yy_china.model.YYHomeChatsViewModel$getYYRed$1
            final /* synthetic */ YYHomeChatsViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ActivityFragmentActive.this);
                this.b = this;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                return super.onUIFailure(i, errorMessage);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<HomeThemeModel, YYRoomExtraModel> bluedEntity) {
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    return;
                }
                this.b.l().postValue(bluedEntity.extra);
            }
        }, (IRequestHost) activityFragmentActive);
    }

    public final void c(String str) {
        this.f17620c = str;
    }

    public final String d() {
        return this.f17619a;
    }

    public final void d(final ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        YYRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<YYLiveState>>(this) { // from class: com.blued.android.module.yy_china.model.YYHomeChatsViewModel$getLiveState$1
            final /* synthetic */ YYHomeChatsViewModel b;

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
                this.b.m().postValue(bluedEntityA.data.get(0));
            }
        }, YYRoomInfoManager.e().c().c(), fragmentActive);
    }

    public final String e() {
        return this.b;
    }

    public final void e(final ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        YYRoomHttpUtils.d((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<YYChatRoomGuideMode, YYRoomGuideExtraModel>>(this) { // from class: com.blued.android.module.yy_china.model.YYHomeChatsViewModel$getChatRoomGuide$1
            final /* synthetic */ YYHomeChatsViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ActivityFragmentActive.this);
                this.b = this;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYChatRoomGuideMode, YYRoomGuideExtraModel> yyRoomGuideExtraModelBluedEntity) {
                Intrinsics.e(yyRoomGuideExtraModelBluedEntity, "yyRoomGuideExtraModelBluedEntity");
                if (yyRoomGuideExtraModelBluedEntity.extra != null) {
                    YYRoomGuideExtraModel yYRoomGuideExtraModel = yyRoomGuideExtraModelBluedEntity.extra;
                    boolean z = false;
                    if (yYRoomGuideExtraModel != null && yYRoomGuideExtraModel.is_show == 1) {
                        MutableLiveData<YYChatRoomGuideListMode> o = this.b.o();
                        List<YYChatRoomGuideMode> list = yyRoomGuideExtraModelBluedEntity.data;
                        YYRoomGuideExtraModel yYRoomGuideExtraModel2 = yyRoomGuideExtraModelBluedEntity.extra;
                        Intrinsics.a(yYRoomGuideExtraModel2);
                        if (yYRoomGuideExtraModel2.is_new == 1) {
                            z = true;
                        }
                        o.postValue(new YYChatRoomGuideListMode(list, z));
                    }
                }
            }
        }, (IRequestHost) fragmentActive);
    }

    public final MutableLiveData<List<HomeThemeModel>> f() {
        return this.e;
    }

    public final void f(final ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.d;
        if (j == -1 || currentTimeMillis - j >= 2000) {
            this.d = currentTimeMillis;
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_RANDOM_CLICK);
            YYRoomHttpUtils.g(new BluedUIHttpResponse<BluedEntityA<YYMatchRoomModel>>(this) { // from class: com.blued.android.module.yy_china.model.YYHomeChatsViewModel$joinMatchRoom$1
                final /* synthetic */ YYHomeChatsViewModel b;

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
                        this.b.n().postValue(response.data.get(0));
                    }
                    this.b.d = -1L;
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str, String str2) {
                    this.b.d = -1L;
                    return super.onUIFailure(i, str, str2);
                }
            }, fragmentActive);
        }
    }

    public final MutableLiveData<Boolean> g() {
        return this.f;
    }

    public final MutableLiveData<Boolean> h() {
        return this.g;
    }

    public final MutableLiveData<Boolean> i() {
        return this.h;
    }

    public final MutableLiveData<Boolean> j() {
        return this.i;
    }

    public final MutableLiveData<Boolean> k() {
        return this.j;
    }

    public final MutableLiveData<YYRoomExtraModel> l() {
        return this.k;
    }

    public final MutableLiveData<YYLiveState> m() {
        return this.l;
    }

    public final MutableLiveData<YYMatchRoomModel> n() {
        return this.m;
    }

    public final MutableLiveData<YYChatRoomGuideListMode> o() {
        return this.n;
    }

    public final MutableLiveData<YYHomeChatsMode> p() {
        return this.o;
    }

    public final List<HomeThemeModel> q() {
        return this.p;
    }
}
