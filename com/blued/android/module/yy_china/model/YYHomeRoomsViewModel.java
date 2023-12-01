package com.blued.android.module.yy_china.model;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYHomeRoomsViewModel.class */
public final class YYHomeRoomsViewModel extends BaseViewModel {
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f17630c;

    /* renamed from: a  reason: collision with root package name */
    private String f17629a = "0";
    private final MutableLiveData<HomeRightMenuModels> d = new MutableLiveData<>();
    private final MutableLiveData<YYHomeExtraModel> e = new MutableLiveData<>();
    private final MutableLiveData<String> f = new MutableLiveData<>();

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

    public final void a(final ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        YYRoomHttpUtils.j(this.b, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<HomeRightMenuModel, YYHomeExtraModel>>(this) { // from class: com.blued.android.module.yy_china.model.YYHomeRoomsViewModel$getState$1
            final /* synthetic */ YYHomeRoomsViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ActivityFragmentActive.this);
                this.b = this;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                this.b.i().postValue("");
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<HomeRightMenuModel, YYHomeExtraModel> bluedEntity) {
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    return;
                }
                MutableLiveData<HomeRightMenuModels> g = this.b.g();
                List<HomeRightMenuModel> list = bluedEntity.data;
                Intrinsics.c(list, "response.data");
                g.postValue(new HomeRightMenuModels(list));
                if (bluedEntity.extra != null) {
                    this.b.h().postValue(bluedEntity.extra);
                } else {
                    this.b.i().postValue("");
                }
            }
        }, (IRequestHost) fragmentActive);
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.f17629a = str;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final void c(String str) {
        this.f17630c = str;
    }

    public final String d() {
        return this.f17629a;
    }

    public final String e() {
        return this.b;
    }

    public final String f() {
        return this.f17630c;
    }

    public final MutableLiveData<HomeRightMenuModels> g() {
        return this.d;
    }

    public final MutableLiveData<YYHomeExtraModel> h() {
        return this.e;
    }

    public final MutableLiveData<String> i() {
        return this.f;
    }
}
