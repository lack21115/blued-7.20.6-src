package com.soft.blued.ui.live.model;

import android.text.TextUtils;
import com.blued.android.module.live_china.model.LiveTabModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/model/LiveClassifyTabModel.class */
public class LiveClassifyTabModel {
    List<LiveTabModel> tabModelList = new ArrayList();

    public void addItem(LiveTabModel liveTabModel) {
        this.tabModelList.add(liveTabModel);
    }

    public LiveTabModel findTabModel(String str) {
        for (LiveTabModel liveTabModel : this.tabModelList) {
            if (TextUtils.equals(str, liveTabModel.id)) {
                return liveTabModel;
            }
        }
        return null;
    }

    public List<LiveTabModel> getTabModelList() {
        return this.tabModelList;
    }

    public void initTabModelList(List<LiveTabModel> list) {
        if (list != null) {
            this.tabModelList.clear();
            this.tabModelList.addAll(list);
        }
    }

    public void removeItem(LiveTabModel liveTabModel) {
        this.tabModelList.remove(liveTabModel);
    }
}
