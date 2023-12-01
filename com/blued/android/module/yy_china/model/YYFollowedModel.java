package com.blued.android.module.yy_china.model;

import com.blued.android.framework.http.parser.BluedEntity;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYFollowedModel.class */
public class YYFollowedModel extends BluedEntity {
    public int code;
    public DataBean data;
    public String message;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYFollowedModel$DataBean.class */
    public static class DataBean {
        public String avatar;
        public String create_time;
        public int is_on_live;
        public String last_on_time;
        public String name;
        public String room_desc;
        public String room_id;
        public String room_name;
        public String room_type;
        public String type_id;
        public String uid;
    }
}
