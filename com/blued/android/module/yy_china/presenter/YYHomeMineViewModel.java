package com.blued.android.module.yy_china.presenter;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.yy_china.model.YYChatRoomFollowedModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/YYHomeMineViewModel.class */
public final class YYHomeMineViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private String f17761a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17762c = true;
    private boolean d = true;
    private boolean e = true;
    private final MutableLiveData<Boolean> f = new MutableLiveData<>();
    private final MutableLiveData<Boolean> g = new MutableLiveData<>();
    private final MutableLiveData<List<YYChatRoomFollowedModel>> h = new MutableLiveData<>();
    private final MutableLiveData<List<YYChatRoomFollowedModel>> i = new MutableLiveData<>();

    private final void b(final ActivityFragmentActive activityFragmentActive) {
        YYRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<YYChatRoomFollowedModel>>(this) { // from class: com.blued.android.module.yy_china.presenter.YYHomeMineViewModel$getYYFollowedList$1
            final /* synthetic */ YYHomeMineViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ActivityFragmentActive.this);
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYChatRoomFollowedModel> response) {
                Intrinsics.e(response, "response");
                if (response.hasData()) {
                    this.b.k().postValue(response.data);
                } else {
                    this.b.i().postValue(true);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                this.b.i().postValue(true);
                return super.onUIFailure(i, errorMessage);
            }
        }, UserInfo.getInstance().getLoginUserInfo().uid, activityFragmentActive);
    }

    private final void c(final ActivityFragmentActive activityFragmentActive) {
        YYRoomHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<YYChatRoomFollowedModel>>(this) { // from class: com.blued.android.module.yy_china.presenter.YYHomeMineViewModel$getYYHistoryList$1
            final /* synthetic */ YYHomeMineViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ActivityFragmentActive.this);
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYChatRoomFollowedModel> response) {
                Intrinsics.e(response, "response");
                if (response.hasData()) {
                    this.b.l().postValue(response.data);
                } else {
                    this.b.j().postValue(true);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                this.b.j().postValue(true);
                return super.onUIFailure(i, errorMessage);
            }
        }, UserInfo.getInstance().getLoginUserInfo().uid, activityFragmentActive);
    }

    @Override // com.blued.android.module.common.base.mvvm.BaseViewModel
    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle == null) {
            return;
        }
        a(bundle.getString("from_source"));
        c(bundle.getBoolean("is_need_ref", false));
    }

    public final void a(ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        b(fragmentActive);
        c(fragmentActive);
    }

    public final void a(String str) {
        this.f17761a = str;
    }

    public final void c(boolean z) {
        this.b = z;
    }

    public final String d() {
        return this.f17761a;
    }

    public final void d(boolean z) {
        this.f17762c = z;
    }

    public final void e(boolean z) {
        this.d = z;
    }

    public final boolean e() {
        return this.b;
    }

    public final void f(boolean z) {
        this.e = z;
    }

    public final boolean f() {
        return this.f17762c;
    }

    public final boolean g() {
        return this.d;
    }

    public final boolean h() {
        return this.e;
    }

    public final MutableLiveData<Boolean> i() {
        return this.f;
    }

    public final MutableLiveData<Boolean> j() {
        return this.g;
    }

    public final MutableLiveData<List<YYChatRoomFollowedModel>> k() {
        return this.h;
    }

    public final MutableLiveData<List<YYChatRoomFollowedModel>> l() {
        return this.i;
    }
}
