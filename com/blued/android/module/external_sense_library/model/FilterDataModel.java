package com.blued.android.module.external_sense_library.model;

import com.blued.android.module.external_sense_library.config.BluedFilterType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/model/FilterDataModel.class */
public class FilterDataModel implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public List<FilterItemData> f11262a = new ArrayList();

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/model/FilterDataModel$FilterItemData.class */
    public class FilterItemData implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public BluedFilterType.FILER f11263a;
        public String b;

        public FilterItemData() {
        }
    }

    public void a(BluedFilterType.FILER filer, String str) {
        FilterItemData filterItemData = new FilterItemData();
        filterItemData.f11263a = filer;
        filterItemData.b = str;
        this.f11262a.add(filterItemData);
    }
}
