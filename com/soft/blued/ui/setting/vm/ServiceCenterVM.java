package com.soft.blued.ui.setting.vm;

import android.app.Activity;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.sobot.chat.api.ZhiChiApi;
import com.sobot.chat.api.model.StCategoryModel;
import com.sobot.chat.api.model.StDocModel;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.network.http.callback.StringResultCallBack;
import com.soft.blued.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/ServiceCenterVM.class */
public final class ServiceCenterVM extends BaseListViewModel<StDocModel> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f19998a;
    private final MutableLiveData<StCategoryModel> b = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private Activity f19999c;

    public final void a(Activity activity) {
        this.f19999c = activity;
    }

    public final boolean a() {
        return this.f19998a;
    }

    public final MutableLiveData<StCategoryModel> b() {
        return this.b;
    }

    public final Activity getActivity() {
        return this.f19999c;
    }

    public void onCleared() {
        super.onCleared();
        this.f19998a = true;
    }

    public void requestData() {
        final ZhiChiApi zhiChiApi = SobotMsgManager.getInstance(this.f19999c).getZhiChiApi();
        zhiChiApi.getCategoryList(this.f19999c, AppInfo.d().getString(R.string.sobot_app_key), (StringResultCallBack) new StringResultCallBack<List<? extends StCategoryModel>>() { // from class: com.soft.blued.ui.setting.vm.ServiceCenterVM$requestData$1
            @Override // com.sobot.network.http.callback.StringResultCallBack
            /* renamed from: a */
            public void onSuccess(List<? extends StCategoryModel> list) {
                List<? extends StCategoryModel> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                StCategoryModel stCategoryModel = list.get(0);
                ServiceCenterVM.this.b().postValue(stCategoryModel);
                ZhiChiApi zhiChiApi2 = zhiChiApi;
                Activity activity = ServiceCenterVM.this.getActivity();
                String appId = stCategoryModel.getAppId();
                String categoryId = stCategoryModel.getCategoryId();
                final ServiceCenterVM serviceCenterVM = ServiceCenterVM.this;
                zhiChiApi2.getHelpDocByCategoryId(activity, appId, categoryId, (StringResultCallBack) new StringResultCallBack<List<? extends StDocModel>>() { // from class: com.soft.blued.ui.setting.vm.ServiceCenterVM$requestData$1$onSuccess$1
                    @Override // com.sobot.network.http.callback.StringResultCallBack
                    /* renamed from: a */
                    public void onSuccess(List<? extends StDocModel> list3) {
                        List<? extends StDocModel> list4 = list3;
                        if ((list4 == null || list4.isEmpty()) || ServiceCenterVM.this.a()) {
                            return;
                        }
                        ServiceCenterVM.this.loadListSucceed(list3, false);
                    }

                    @Override // com.sobot.network.http.callback.StringResultCallBack
                    public void onFailure(Exception exc, String str) {
                        Intrinsics.e(exc, "e");
                        Intrinsics.e(str, "des");
                        ServiceCenterVM.this.loadListFailed();
                    }
                });
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
                Intrinsics.e(exc, "e");
                Intrinsics.e(str, "des");
                ServiceCenterVM.this.loadListFailed();
            }
        });
    }
}
