package com.sina.weibo.sdk.register.mobile;

import android.text.TextUtils;
import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/register/mobile/Country.class */
public class Country implements Serializable, Comparable<Country> {
    public static final String CHINA_CODE = "0086";
    private static final long serialVersionUID = 0;
    private String code;
    private String[] mccs;
    private String name;
    private String pinyin;

    public Country() {
    }

    public Country(String str, String str2) {
        this.name = str;
        this.code = str2;
    }

    @Override // java.lang.Comparable
    public int compareTo(Country country) {
        if (TextUtils.isEmpty(this.pinyin)) {
            return -1;
        }
        if (country == null || TextUtils.isEmpty(country.pinyin)) {
            return 1;
        }
        return this.pinyin.compareTo(country.pinyin);
    }

    public String getCode() {
        return this.code;
    }

    public String[] getMccs() {
        return this.mccs;
    }

    public String getName() {
        return this.name;
    }

    public String getPinyin() {
        return PinyinUtils.getObject().getPinyin(this.name).toLowerCase();
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMccs(String[] strArr) {
        this.mccs = strArr;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPinyin(String str) {
        this.pinyin = str;
    }
}
