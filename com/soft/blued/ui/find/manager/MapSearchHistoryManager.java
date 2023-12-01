package com.soft.blued.ui.find.manager;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.soft.blued.ui.find.model.SearchPositionListModel;
import com.soft.blued.ui.find.model.SearchPositionModel;
import com.soft.blued.utils.BluedPreferences;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/MapSearchHistoryManager.class */
public class MapSearchHistoryManager {

    /* renamed from: a  reason: collision with root package name */
    private static MapSearchHistoryManager f16911a = new MapSearchHistoryManager();

    private MapSearchHistoryManager() {
    }

    public static MapSearchHistoryManager a() {
        return f16911a;
    }

    public void a(SearchPositionModel searchPositionModel) {
        SearchPositionListModel b = b();
        if (b == null) {
            return;
        }
        SearchPositionModel findModel = b.findModel(searchPositionModel.name);
        if (findModel == null) {
            b.addItem(searchPositionModel);
        } else {
            findModel.update(searchPositionModel);
        }
        BluedPreferences.d(AppInfo.f().toJson(b));
    }

    public SearchPositionListModel b() {
        String s = BluedPreferences.s();
        return TextUtils.isEmpty(s) ? new SearchPositionListModel() : (SearchPositionListModel) AppInfo.f().fromJson(s, (Class<Object>) SearchPositionListModel.class);
    }
}
