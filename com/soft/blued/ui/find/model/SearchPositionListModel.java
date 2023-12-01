package com.soft.blued.ui.find.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/SearchPositionListModel.class */
public class SearchPositionListModel {
    List<SearchPositionModel> modelList = new ArrayList();

    public void addItem(SearchPositionModel searchPositionModel) {
        this.modelList.add(0, searchPositionModel);
    }

    public SearchPositionModel findModel(String str) {
        for (SearchPositionModel searchPositionModel : this.modelList) {
            if (TextUtils.equals(str, searchPositionModel.name)) {
                return searchPositionModel;
            }
        }
        return null;
    }

    public List<SearchPositionModel> getModelList() {
        return this.modelList;
    }

    public void initTabModelList(List<SearchPositionModel> list) {
        if (list != null) {
            this.modelList.clear();
            this.modelList.addAll(list);
        }
    }

    public void removeItem(SearchPositionModel searchPositionModel) {
        this.modelList.remove(searchPositionModel);
    }
}
