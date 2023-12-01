package com.soft.blued.ui.user.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/AvatarWidgetList.class */
public class AvatarWidgetList {
    public List<AvatarWidgetModel> modelList = new ArrayList();

    public void addItem(AvatarWidgetModel avatarWidgetModel) {
        this.modelList.add(0, avatarWidgetModel);
    }

    public AvatarWidgetModel findModel(int i) {
        for (AvatarWidgetModel avatarWidgetModel : this.modelList) {
            if (i == avatarWidgetModel.id) {
                return avatarWidgetModel;
            }
        }
        return null;
    }

    public List<AvatarWidgetModel> getModelList() {
        return this.modelList;
    }
}
