package com.soft.blued.ui.user.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/DynamicSkinList.class */
public class DynamicSkinList {
    public List<DynamicSkinModel> modelList = new ArrayList();

    public void addItem(DynamicSkinModel dynamicSkinModel) {
        this.modelList.add(0, dynamicSkinModel);
    }

    public DynamicSkinModel findModel(int i) {
        for (DynamicSkinModel dynamicSkinModel : this.modelList) {
            if (i == dynamicSkinModel.id) {
                return dynamicSkinModel;
            }
        }
        return null;
    }

    public List<DynamicSkinModel> getModelList() {
        return this.modelList;
    }
}
