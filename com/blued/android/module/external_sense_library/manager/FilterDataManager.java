package com.blued.android.module.external_sense_library.manager;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.module.external_sense_library.config.BluedFilterType;
import com.blued.android.module.external_sense_library.model.FilterDataModel;
import com.blued.android.module.external_sense_library.utils.FileUtils;
import com.blued.android.module.external_sense_library.utils.SenseLibSPMgr;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/manager/FilterDataManager.class */
public class FilterDataManager {
    private static FilterDataManager instance;
    private Map<BluedFilterType.FILER, String> modelItemMap = new HashMap();

    private FilterDataManager() {
    }

    private void copyFilterToSd() {
        FilterDataModel filterDataModel = new FilterDataModel();
        Map<BluedFilterType.FILER, String> b = FileUtils.b(AppInfo.d(), "filters");
        if (b == null || b.size() <= 0) {
            return;
        }
        for (Map.Entry<BluedFilterType.FILER, String> entry : b.entrySet()) {
            filterDataModel.a(entry.getKey(), entry.getValue());
        }
        SenseLibSPMgr.a().b(AppInfo.f().toJson(filterDataModel));
        this.modelItemMap.putAll(b);
    }

    public static FilterDataManager getInstance() {
        if (instance == null) {
            synchronized (FilterDataManager.class) {
                try {
                    if (instance == null) {
                        instance = new FilterDataManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.blued.android.module.external_sense_library.manager.FilterDataManager$1] */
    public List<BluedFilterType.FILER> getFilters() {
        if (this.modelItemMap.size() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.modelItemMap.keySet());
            return arrayList;
        }
        String c = SenseLibSPMgr.a().c();
        boolean z = true;
        if (!TextUtils.isEmpty(c)) {
            FilterDataModel filterDataModel = (FilterDataModel) AppInfo.f().fromJson(c, new TypeToken<FilterDataModel>() { // from class: com.blued.android.module.external_sense_library.manager.FilterDataManager.1
            }.getType());
            z = true;
            if (filterDataModel != null) {
                z = true;
                if (filterDataModel.a != null) {
                    z = true;
                    if (filterDataModel.a.size() > 0) {
                        List<String> c2 = FileUtils.c(AppInfo.d(), "filters");
                        z = true;
                        if (c2.size() == filterDataModel.a.size()) {
                            for (FilterDataModel.FilterItemData filterItemData : filterDataModel.a) {
                                if (filterItemData != null) {
                                    this.modelItemMap.put(filterItemData.a, filterItemData.b);
                                    c2.remove(filterItemData.a.getValue());
                                }
                            }
                            z = true;
                            if (c2.size() <= 0) {
                                z = false;
                            }
                        }
                    }
                }
            }
        }
        if (z) {
            copyFilterToSd();
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(this.modelItemMap.keySet());
        return arrayList2;
    }

    public String getModel(BluedFilterType.FILER filer) {
        if (filer == null) {
            return "";
        }
        String str = this.modelItemMap.get(filer);
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            copyFilterToSd();
            return this.modelItemMap.get(filer);
        }
        return str;
    }
}
