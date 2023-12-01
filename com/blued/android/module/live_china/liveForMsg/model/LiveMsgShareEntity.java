package com.blued.android.module.live_china.liveForMsg.model;

import java.io.Serializable;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/liveForMsg/model/LiveMsgShareEntity.class */
public class LiveMsgShareEntity implements Serializable {
    public String avatar;
    public String copywriting;
    public String description;
    public String lid;
    public String link;
    public int msg_type;
    public String name;
    public String note_type;
    public String pic_url;
    public String push_type;
    public int redirect;
    public String room_describe;
    public String room_id;
    public String room_level;
    public String room_level_img;
    public String room_name;
    public String room_tag;
    public String room_tag_img;
    public int room_type;
    public String room_type_id;
    public String room_type_name;
    public long session_id;
    public short session_type;
    public String uid;
    public String url;
    public int vbadge;
    public int watch_count;

    public String toString() {
        return "LiveMsgShareEntity{pic_url='" + this.pic_url + "', name='" + this.name + "', description='" + this.description + "', watch_count=" + this.watch_count + ", vbadge=" + this.vbadge + ", avatar='" + this.avatar + "', uid='" + this.uid + "', lid='" + this.lid + "', copywriting='" + this.copywriting + "', session_type=" + ((int) this.session_type) + ", session_id=" + this.session_id + ", room_id='" + this.room_id + "', room_type=" + this.room_type + ", msg_type=" + this.msg_type + ", redirect=" + this.redirect + ", link='" + this.link + "', push_type='" + this.push_type + "', note_type='" + this.note_type + "'}";
    }
}
