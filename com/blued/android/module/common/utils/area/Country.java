package com.blued.android.module.common.utils.area;

import com.blued.android.framework.utils.StringUtils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/area/Country.class */
public class Country {
    public String abbr;
    public String code;
    public String continent;
    public String group_by;
    public String has_child;
    public String nation;
    public String nation_code;

    public Country(String str, String str2, String str3, String str4, String str5, int i) {
        this.nation = "";
        this.nation_code = "";
        this.code = "";
        this.abbr = "";
        this.continent = "";
        this.has_child = "";
        this.group_by = "";
        this.code = str3;
        this.nation = str;
        this.nation_code = str2;
        this.code = str3;
        this.abbr = str4;
        this.continent = str5;
        this.has_child = i + "";
        if (StringUtils.b(str4) || str4.length() < 1) {
            return;
        }
        this.group_by = str4.substring(1, 1);
    }
}
