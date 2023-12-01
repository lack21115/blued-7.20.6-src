package com.soft.blued.ui.msg.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MarkYellowListModel.class */
public class MarkYellowListModel {
    List<MarkYellowModel> modelList = new ArrayList();

    public void addItem(MarkYellowModel markYellowModel) {
        if (this.modelList.size() > 100) {
            List<MarkYellowModel> list = this.modelList;
            list.remove(list.size() - 1);
        }
        this.modelList.add(0, markYellowModel);
    }

    public MarkYellowModel findModel(String str) {
        for (MarkYellowModel markYellowModel : this.modelList) {
            if (TextUtils.equals(str, markYellowModel.path)) {
                return markYellowModel;
            }
        }
        return null;
    }

    public List<MarkYellowModel> getModelList() {
        return this.modelList;
    }

    public void removeItem(MarkYellowModel markYellowModel) {
        this.modelList.remove(markYellowModel);
    }
}
