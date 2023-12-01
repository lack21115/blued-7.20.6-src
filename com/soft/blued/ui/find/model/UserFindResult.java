package com.soft.blued.ui.find.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.community.ui.send.model.FeedPostSignStateItem;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huawei.hms.ads.nativead.NativeAd;
import com.kwad.sdk.api.KsNativeAd;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/UserFindResult.class */
public class UserFindResult extends UserBasicModel implements Parcelable, MultiItemEntity {
    public static final Parcelable.Creator<UserFindResult> CREATOR = new Parcelable.Creator<UserFindResult>() { // from class: com.soft.blued.ui.find.model.UserFindResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserFindResult createFromParcel(Parcel parcel) {
            return new UserFindResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserFindResult[] newArray(int i) {
            return new UserFindResult[i];
        }
    };
    public int accumCount;
    public String additional_tag_data;
    public int additional_tag_type;
    public FeedPostSignStateItem bubble;
    public VoiceBroadcast chatroom;
    public List<GroupInfoModel> fans_group;
    public int hb;
    public NativeAd hwNativeAd;
    public int is_eco_user;
    public int is_have_chatroom;
    public int is_insert_chatroom;
    public int is_insert_operate;
    public int is_super_privilege_user;
    public int itemType;
    public KsNativeAd ksNativeAd;
    public Label label;
    public int layout;
    public int link_type;
    public String list_avatar;
    public int live;
    public int live_card_style;
    public LiveInfo live_info;
    public int live_type;
    public String live_url;
    public String lt;
    public OperateUserADExtra operate_promotion;
    public int play_view_height;
    public int play_view_width;
    public int positionReal;
    public long realtime_count;
    public String redirect_url;
    public String selected_tag;
    public boolean showMore;
    public int show_activity;
    public int size;
    public String source;
    public TTNativeAd ttNativeAdData;
    public int userPositionReal;
    public String[] user_tags;
    public int users_face;
    public long watch_count;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/UserFindResult$Label.class */
    public class Label {
        public String icon;
        public String name;

        public Label() {
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/UserFindResult$LiveInfo.class */
    public class LiveInfo {
        public int lid;
        public String live_stream_url;
        public int member_count;
        public String tag;
        public String title;

        public LiveInfo() {
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/UserFindResult$USER_ITEM_TYPE.class */
    public interface USER_ITEM_TYPE {
        public static final int AD = 11;
        public static final int DN_ORIGIN_AD = 15;
        public static final int HW_ORIGIN_AD = 27;
        public static final int KS_ORIGIN_AD = 18;
        public static final int NEW_CHAT_ROOM_LIST_STYLE = 25;
        public static final int NEW_LIVING_LIST_AND_GRID_STYLE = 26;
        public static final int NEW_LIVING_LIST_STYLE = 24;
        public static final int OPERATE_GRID_USER = 20;
        public static final int OPERATE_PROMOTION = 22;
        public static final int OPERATE_USER = 19;
        public static final int ORIGIN_AD = 13;
        public static final int TOP_ORIGIN_AD = 16;
        public static final int TT_ORIGIN_AD = 14;
        public static final int USER = 10;
        public static final int VISIBLE_TO_VIP = 17;
        public static final int XIAOMI_ORIGIN_AD = 23;
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/UserFindResult$USER_SORT_BY.class */
    public interface USER_SORT_BY {
        public static final String HOME_LIVE = "home_live";
        public static final String INTEGRATE = "integrate";
        public static final String NEARBY = "nearby";
        public static final String NEWBEE = "newbie";
        public static final String ONLINE = "online";
        public static final String SELECTED = "selected";
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/UserFindResult$VoiceBroadcast.class */
    public class VoiceBroadcast {
        public int mem_count;
        public String room_id;
        public String room_name;
        public String room_type;
        public String uid;

        public VoiceBroadcast() {
        }
    }

    public UserFindResult() {
        this.itemType = 10;
        this.accumCount = -1;
        this.positionReal = -1;
        this.userPositionReal = -1;
        this.play_view_width = 0;
        this.play_view_height = 0;
    }

    protected UserFindResult(Parcel parcel) {
        this.itemType = 10;
        this.accumCount = -1;
        this.positionReal = -1;
        this.userPositionReal = -1;
        boolean z = false;
        this.play_view_width = 0;
        this.play_view_height = 0;
        this.hb = parcel.readInt();
        this.showMore = parcel.readByte() != 0 ? true : z;
        this.watch_count = parcel.readLong();
        this.realtime_count = parcel.readLong();
        this.itemType = parcel.readInt();
        this.avatar = parcel.readString();
        this.uid = parcel.readString();
        this.email = parcel.readString();
        this.name = parcel.readString();
        this.height = parcel.readString();
        this.weight = parcel.readString();
        this.last_operate = parcel.readString();
        this.avatar = parcel.readString();
        this.hot = parcel.readString();
        this.description = parcel.readString();
        this.role = parcel.readString();
        this.age = parcel.readString();
        this.online_state = parcel.readInt();
        this.distance = parcel.readString();
        this.photos_count = parcel.readInt();
        this.note = parcel.readString();
        this.vbadge = parcel.readInt();
        this.is_recommend = parcel.readInt();
        this.blued_pic = parcel.readString();
        this.weekstar = parcel.readString();
        this.vip_grade = parcel.readInt();
        this.vip_exp_lvl = parcel.readInt();
        this.is_hide_distance = parcel.readInt();
        this.is_hide_last_operate = parcel.readInt();
        this.is_shadow = parcel.readInt();
        this.is_hide_vip_look = parcel.readInt();
        this.is_show_vip_page = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        if (this.itemType == 0) {
            this.itemType = 10;
        }
        if (this.live_info != null) {
            this.itemType = 24;
        }
        if (this.is_have_chatroom == 1) {
            this.itemType = 25;
        }
        if (this.size == 1 && this.live_info != null) {
            this.itemType = 26;
        }
        return this.itemType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.hb);
        parcel.writeByte(this.showMore ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.watch_count);
        parcel.writeLong(this.realtime_count);
        parcel.writeInt(this.itemType);
        parcel.writeString(this.avatar);
        parcel.writeString(this.uid);
        parcel.writeString(this.email);
        parcel.writeString(this.name);
        parcel.writeString(this.height);
        parcel.writeString(this.weight);
        parcel.writeString(this.last_operate);
        parcel.writeString(this.avatar);
        parcel.writeString(this.hot);
        parcel.writeString(this.description);
        parcel.writeString(this.role);
        parcel.writeString(this.age);
        parcel.writeInt(this.online_state);
        parcel.writeString(this.distance);
        parcel.writeInt(this.photos_count);
        parcel.writeString(this.note);
        parcel.writeInt(this.vbadge);
        parcel.writeInt(this.is_recommend);
        parcel.writeString(this.blued_pic);
        parcel.writeString(this.weekstar);
        parcel.writeInt(this.vip_grade);
        parcel.writeInt(this.vip_exp_lvl);
        parcel.writeInt(this.is_hide_distance);
        parcel.writeInt(this.is_hide_last_operate);
        parcel.writeInt(this.is_shadow);
        parcel.writeInt(this.is_hide_vip_look);
        parcel.writeInt(this.is_show_vip_page);
    }
}
