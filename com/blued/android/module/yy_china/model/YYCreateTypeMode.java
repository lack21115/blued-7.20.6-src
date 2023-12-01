package com.blued.android.module.yy_china.model;

import com.blued.android.framework.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYCreateTypeMode.class */
public class YYCreateTypeMode {
    private String background_img;
    private ArrayList<BgCollectionMode> bg_collection;
    private int checked_label;
    private String icon;
    private int is_choose = 0;
    private String is_restricted;
    private int is_veiled;
    private String mic_img;
    private List<String> recommend_text;
    private String subscript;
    private String tips;
    private String type;
    private String type_name;

    public String getBackground_img() {
        return this.background_img;
    }

    public ArrayList<BgCollectionMode> getBg_collection() {
        return this.bg_collection;
    }

    public int getChecked_label() {
        return this.checked_label;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getIs_choose() {
        return this.is_choose;
    }

    public int getIs_restricted() {
        return StringUtils.a(this.is_restricted, 0);
    }

    public int getIs_veiled() {
        return this.is_veiled;
    }

    public String getMic_img() {
        return this.mic_img;
    }

    public List<String> getRecommend_text() {
        return this.recommend_text;
    }

    public String getSubscript() {
        return this.subscript;
    }

    public String getTips() {
        return this.tips;
    }

    public String getType() {
        return this.type;
    }

    public String getType_name() {
        return this.type_name;
    }

    public void setBackground_img(String str) {
        this.background_img = str;
    }

    public void setBg_collection(ArrayList<BgCollectionMode> arrayList) {
        this.bg_collection = arrayList;
    }

    public void setChecked_label(int i) {
        this.checked_label = i;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setIs_choose(int i) {
        this.is_choose = i;
    }

    public void setIs_restricted(String str) {
        this.is_restricted = str;
    }

    public void setIs_veiled(int i) {
        this.is_veiled = i;
    }

    public void setMic_img(String str) {
        this.mic_img = str;
    }

    public void setRecommend_text(List<String> list) {
        this.recommend_text = list;
    }

    public void setSubscript(String str) {
        this.subscript = str;
    }

    public void setTips(String str) {
        this.tips = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setType_name(String str) {
        this.type_name = str;
    }
}
