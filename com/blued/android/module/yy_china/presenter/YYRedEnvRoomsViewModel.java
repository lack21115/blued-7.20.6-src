package com.blued.android.module.yy_china.presenter;

import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.blued.android.module.yy_china.model.YYHongbaoModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/YYRedEnvRoomsViewModel.class */
public final class YYRedEnvRoomsViewModel extends BaseListViewModel<YYHongbaoModel> {
    @Override // com.blued.android.module.common.base.mvi.BaseListViewModel
    public void requestData() {
        YYRoomHttpUtils.g(String.valueOf(getMPage()), String.valueOf(getMPageSize()), (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYHongbaoModel>>() { // from class: com.blued.android.module.yy_china.presenter.YYRedEnvRoomsViewModel$requestData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYHongbaoModel> bluedEntityA) {
                if (bluedEntityA == null) {
                    return;
                }
                YYRedEnvRoomsViewModel.this.loadListSucceed(bluedEntityA.data, bluedEntityA.hasMore());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    return;
                }
                YYRedEnvRoomsViewModel.this.loadListFailed();
            }
        }, (ActivityFragmentActive) null);
    }
}
