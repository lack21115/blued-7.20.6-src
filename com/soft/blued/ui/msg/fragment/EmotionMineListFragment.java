package com.soft.blued.ui.msg.fragment;

import com.blued.android.framework.utils.LogUtils;
import com.soft.blued.ui.msg.model.EmotionListItemModel;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/EmotionMineListFragment.class */
public class EmotionMineListFragment extends EmotionBaseListFragment {
    @Override // com.soft.blued.ui.msg.fragment.EmotionBaseListFragment
    public void a() {
        ArrayList arrayList = new ArrayList();
        for (EmotionListItemModel emotionListItemModel : EmotionDataManager.a().c()) {
            if (emotionListItemModel.downloadState > 0) {
                arrayList.add(emotionListItemModel);
            }
        }
        this.f18647c.a(arrayList);
    }

    @Override // com.soft.blued.ui.msg.fragment.EmotionBaseListFragment
    public void a(EmotionListItemModel emotionListItemModel) {
        if (emotionListItemModel == null) {
            return;
        }
        LogUtils.c("onBtnEmotionClicked: " + emotionListItemModel.name + ", _pageIndex: $_pageIndex, code: " + emotionListItemModel.code + ", state: " + emotionListItemModel.downloadState);
        if (emotionListItemModel.downloadState == 3) {
            d(emotionListItemModel);
        } else if (emotionListItemModel.downloadState == 1) {
            if (emotionListItemModel.downloadUrl == null) {
                b(emotionListItemModel);
            } else {
                c(emotionListItemModel);
            }
        }
    }

    @Override // com.soft.blued.ui.msg.fragment.EmotionBaseListFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        this.f18646a.setVisibility(8);
        this.f18647c.a(1);
    }
}
