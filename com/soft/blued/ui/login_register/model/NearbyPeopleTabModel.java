package com.soft.blued.ui.login_register.model;

import android.text.TextUtils;
import com.blued.android.core.BlueAppLocal;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/model/NearbyPeopleTabModel.class */
public class NearbyPeopleTabModel {
    public String sort_by;
    private String title;
    private String title_en;
    private String title_zhcn;
    private String title_zhtw;

    public NearbyPeopleTabModel(String str, String str2) {
        this.title = str;
        this.sort_by = str2;
    }

    public String getTitle() {
        if (!BlueAppLocal.d()) {
            this.title = TextUtils.isEmpty(this.title_en) ? this.title : this.title_en;
        } else if ("CN".equals(BlueAppLocal.c().getCountry().toUpperCase())) {
            this.title = TextUtils.isEmpty(this.title_zhcn) ? this.title : this.title_zhcn;
        } else {
            this.title = TextUtils.isEmpty(this.title_zhtw) ? this.title : this.title_zhtw;
        }
        return this.title;
    }
}
