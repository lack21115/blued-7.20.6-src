package com.soft.blued.ui.user.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/MultiHeadMigration.class */
public class MultiHeadMigration extends BluedEntityBaseExtra {
    public int code;
    public DataBean data;
    public String message;
    public String request_id;
    public double request_time;
    public double response_time;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/MultiHeadMigration$DataBean.class */
    public static class DataBean {
        public int vip_avatar_num;
        public int vip_grade;
    }
}
