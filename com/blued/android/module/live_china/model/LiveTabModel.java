package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveTabModel.class */
public class LiveTabModel extends BluedEntityBaseExtra {
    public String data_point;
    public String default_cate;
    public String default_cate_id;
    public String en_name;
    public String icon;
    public String id;
    public String less_cate_icon;
    public String more_cate_icon;
    public String name;
    public String rectangular_icon;
    public int red_point;
    public int red_point_cancel;
    public String red_point_word;
    public boolean showNew;
    public int type;
    public int vcode;

    public LiveTabModel(String str) {
        this.name = str;
    }

    public LiveTabModel(String str, String str2, int i, int i2) {
        this.id = str;
        this.name = str2;
        this.vcode = i;
        this.type = i2;
    }

    public String toString() {
        return "LiveTabModel{id='" + this.id + "', name='" + this.name + "', vcode=" + this.vcode + ", type=" + this.type + '}';
    }

    public void update(LiveTabModel liveTabModel) {
        this.id = liveTabModel.id;
        this.name = liveTabModel.name;
        this.vcode = liveTabModel.vcode;
        this.type = liveTabModel.type;
    }
}
