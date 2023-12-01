package com.soft.blued.ui.msg.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/ConfirmYellowListModel.class */
public class ConfirmYellowListModel {
    List<ConfirmYellowModel> modelList = new ArrayList();

    public void addItem(ConfirmYellowModel confirmYellowModel) {
        if (this.modelList.size() > 100) {
            List<ConfirmYellowModel> list = this.modelList;
            list.remove(list.size() - 1);
        }
        this.modelList.add(0, confirmYellowModel);
    }

    public ConfirmYellowModel findModel(String str) {
        for (ConfirmYellowModel confirmYellowModel : this.modelList) {
            if (TextUtils.equals(str, confirmYellowModel.path)) {
                return confirmYellowModel;
            }
        }
        return null;
    }

    public List<ConfirmYellowModel> getModelList() {
        return this.modelList;
    }

    public void removeItem(ConfirmYellowModel confirmYellowModel) {
        this.modelList.remove(confirmYellowModel);
    }
}
