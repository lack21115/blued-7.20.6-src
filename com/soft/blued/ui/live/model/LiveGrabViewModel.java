package com.soft.blued.ui.live.model;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.soft.blued.R;
import com.soft.blued.http.LiveHttpUtils;
import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/model/LiveGrabViewModel.class */
public final class LiveGrabViewModel extends BaseListViewModel<LiveGrabModel> {
    @Override // com.blued.android.module.common.base.mvi.BaseListViewModel
    public void requestData() {
        LiveHttpUtils.a(getMPage(), new BluedUIHttpResponse<BluedEntity<LiveGrabModel, LiveGrabExtra>>() { // from class: com.soft.blued.ui.live.model.LiveGrabViewModel$requestData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(null);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    return;
                }
                LiveGrabViewModel.this.loadListFailed();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveGrabModel, LiveGrabExtra> bluedEntity) {
                if (bluedEntity == null) {
                    return;
                }
                LiveGrabViewModel liveGrabViewModel = LiveGrabViewModel.this;
                if (liveGrabViewModel.getMPage() == 1) {
                    boolean isEmpty = bluedEntity.data.isEmpty();
                    LiveGrabModel liveGrabModel = new LiveGrabModel();
                    liveGrabModel.setItemType(1);
                    liveGrabModel.name = AppInfo.d().getString(R.string.recommend_grab_current);
                    bluedEntity.data.add(0, liveGrabModel);
                    if (isEmpty) {
                        LiveGrabModel liveGrabModel2 = new LiveGrabModel();
                        liveGrabModel2.setItemType(2);
                        bluedEntity.data.add(liveGrabModel2);
                    }
                    LiveGrabModel liveGrabModel3 = new LiveGrabModel();
                    liveGrabModel3.setItemType(1);
                    liveGrabModel3.name = AppInfo.d().getString(R.string.recommend_grab_today);
                    bluedEntity.data.add(liveGrabModel3);
                }
                if (bluedEntity.extra != null && !TypeUtils.a((List<?>) bluedEntity.extra.today_list)) {
                    for (LiveGrabModel liveGrabModel4 : bluedEntity.extra.today_list) {
                        liveGrabModel4.contentType = 2;
                        bluedEntity.data.add(liveGrabModel4);
                    }
                }
                liveGrabViewModel.loadListSucceed(bluedEntity.data, bluedEntity.hasMore());
            }
        });
    }
}
