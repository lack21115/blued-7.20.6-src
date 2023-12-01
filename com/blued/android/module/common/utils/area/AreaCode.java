package com.blued.android.module.common.utils.area;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/area/AreaCode.class */
public class AreaCode implements Comparable {
    private String abbr;
    private String code;
    private String name;
    private String sort;

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj == null || !(obj instanceof AreaCode)) {
            return -1;
        }
        String sort = ((AreaCode) obj).getSort();
        if (sort.length() == 1) {
            return this.sort.compareTo(sort);
        }
        String str = this.sort;
        return Integer.valueOf(str.substring(0, str.length() - 1)).compareTo(Integer.valueOf(sort.substring(0, sort.length() - 1)));
    }

    public String getAbbr() {
        return this.abbr;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public String getSort() {
        return this.sort;
    }

    public void setAbbr(String str) {
        this.abbr = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSort(String str) {
        this.sort = str;
    }
}
