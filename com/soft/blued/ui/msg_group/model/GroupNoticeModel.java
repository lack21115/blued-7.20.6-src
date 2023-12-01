package com.soft.blued.ui.msg_group.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/model/GroupNoticeModel.class */
public class GroupNoticeModel implements MultiItemEntity {
    public static final int ERROR_CODE_OPERATE_INVALID = 40319014;
    public static final int NOTIFY_RESULT_AGREE = 1;
    public static final int NOTIFY_RESULT_INVALID = 3;
    public static final int NOTIFY_RESULT_NONE = 0;
    public static final int NOTIFY_RESULT_REFUSE = 2;
    public static final int NOTIFY_TYPE_ACCEPT_GROUP_OWNER = 10;
    public static final int NOTIFY_TYPE_ADD = 1;
    public static final int NOTIFY_TYPE_APPLY = 2;
    public static final int NOTIFY_TYPE_APPLY_REFUSE = 9;
    public static final int NOTIFY_TYPE_APPLY_REFUSED_FOREVER = 21;
    public static final int NOTIFY_TYPE_APPLY_SECOND = 20;
    public static final int NOTIFY_TYPE_AUTO_OWNER_CHANGE = 8;
    public static final int NOTIFY_TYPE_DANGER = 4;
    public static final int NOTIFY_TYPE_EXIT = 3;
    public static final int NOTIFY_TYPE_GROUP_ACTIVE = 18;
    public static final int NOTIFY_TYPE_GROUP_CREATE_SUCCEED = 12;
    public static final int NOTIFY_TYPE_GROUP_DEGRADE = 15;
    public static final int NOTIFY_TYPE_GROUP_FROZEN = 17;
    public static final int NOTIFY_TYPE_GROUP_FROZEN_TRANSFER = 19;
    public static final int NOTIFY_TYPE_GROUP_FROZEN_WAIT = 16;
    public static final int NOTIFY_TYPE_GROUP_UPGRADE = 14;
    public static final int NOTIFY_TYPE_OWNER_CHANGE = 7;
    public static final int NOTIFY_TYPE_REFUSE_GROUP_OWNER = 11;
    public static final int NOTIFY_TYPE_SET_MANAGER = 5;
    public static final int NOTIFY_TYPE_SET_MANAGER_CANCEL = 6;
    public String group_cover;
    public int group_id;
    public String group_title;
    public int id;
    public boolean is_owner;
    public int is_read;
    public int ops_age;
    public String ops_avatar;
    public int ops_group_ago_role;
    public int ops_height;
    public String ops_name;
    public float ops_role;
    public int ops_uid;
    public int ops_vbadge;
    public int ops_weight;
    public String reason;
    public int result;
    public String text;
    public int timestamp;
    public String title;
    public int type;

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.type;
    }
}
