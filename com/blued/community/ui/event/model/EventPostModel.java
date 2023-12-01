package com.blued.community.ui.event.model;

import android.text.TextUtils;
import java.io.Serializable;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/model/EventPostModel.class */
public class EventPostModel implements Serializable {
    private static final long serialVersionUID = 1;
    public long activity_date;
    public String city;
    public String cityDef;
    public String description;
    public int is_customize;
    public int is_free;
    public String latitude;
    public String localPic;
    public String localSceneImg;
    public String location;
    public String location_detail;
    public String longitude;
    public int mode_id;
    public String name;
    public String online_text;
    public String online_url;
    public String pic;
    public int quota_num;
    public int sort;
    public String type_id;

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.localPic) && TextUtils.isEmpty(this.name) && TextUtils.isEmpty(this.description) && this.activity_date <= 0 && this.quota_num <= 0 && TextUtils.isEmpty(this.type_id) && TextUtils.equals(this.city, this.cityDef) && TextUtils.isEmpty(this.location) && TextUtils.isEmpty(this.online_url);
    }
}
