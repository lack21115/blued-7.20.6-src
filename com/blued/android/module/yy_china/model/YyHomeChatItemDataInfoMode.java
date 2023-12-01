package com.blued.android.module.yy_china.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YyHomeChatItemDataInfoMode.class */
public final class YyHomeChatItemDataInfoMode {
    private final ArrayList<YYBannerModel> adv_list;
    private final ChatAnchorLevelModel chat_anchor_level;
    private final ArrayList<YYHomeChatsRightTopMode> config;
    private final String cover;
    private final String create_time;
    private final int in_pk;
    private boolean isDraw;
    private final String label_link;
    private final ArrayList<YyHomeChatItemDataInfoMode> lists;
    private final YyHomeChatItemRoomPropInfo prop_info;
    private final String room_id;
    private final String room_member_count;
    private final String room_name;
    private final String room_type_id;
    private final String room_type_name;
    private final String sort;
    private final String the_same_city;
    private final String theme_id;
    private final String theme_name;
    private final String uid;
    private final String user_avatar;
    private final String user_name;

    public YyHomeChatItemDataInfoMode(boolean z, String uid, String room_type_id, String room_type_name, String room_id, String room_name, String room_member_count, String create_time, String sort, String theme_id, String theme_name, String user_avatar, String user_name, YyHomeChatItemRoomPropInfo prop_info, String the_same_city, String cover, String label_link, ChatAnchorLevelModel chat_anchor_level, int i, ArrayList<YyHomeChatItemDataInfoMode> lists, ArrayList<YYBannerModel> adv_list, ArrayList<YYHomeChatsRightTopMode> config) {
        Intrinsics.e(uid, "uid");
        Intrinsics.e(room_type_id, "room_type_id");
        Intrinsics.e(room_type_name, "room_type_name");
        Intrinsics.e(room_id, "room_id");
        Intrinsics.e(room_name, "room_name");
        Intrinsics.e(room_member_count, "room_member_count");
        Intrinsics.e(create_time, "create_time");
        Intrinsics.e(sort, "sort");
        Intrinsics.e(theme_id, "theme_id");
        Intrinsics.e(theme_name, "theme_name");
        Intrinsics.e(user_avatar, "user_avatar");
        Intrinsics.e(user_name, "user_name");
        Intrinsics.e(prop_info, "prop_info");
        Intrinsics.e(the_same_city, "the_same_city");
        Intrinsics.e(cover, "cover");
        Intrinsics.e(label_link, "label_link");
        Intrinsics.e(chat_anchor_level, "chat_anchor_level");
        Intrinsics.e(lists, "lists");
        Intrinsics.e(adv_list, "adv_list");
        Intrinsics.e(config, "config");
        this.isDraw = z;
        this.uid = uid;
        this.room_type_id = room_type_id;
        this.room_type_name = room_type_name;
        this.room_id = room_id;
        this.room_name = room_name;
        this.room_member_count = room_member_count;
        this.create_time = create_time;
        this.sort = sort;
        this.theme_id = theme_id;
        this.theme_name = theme_name;
        this.user_avatar = user_avatar;
        this.user_name = user_name;
        this.prop_info = prop_info;
        this.the_same_city = the_same_city;
        this.cover = cover;
        this.label_link = label_link;
        this.chat_anchor_level = chat_anchor_level;
        this.in_pk = i;
        this.lists = lists;
        this.adv_list = adv_list;
        this.config = config;
    }

    public /* synthetic */ YyHomeChatItemDataInfoMode(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, YyHomeChatItemRoomPropInfo yyHomeChatItemRoomPropInfo, String str13, String str14, String str15, ChatAnchorLevelModel chatAnchorLevelModel, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, yyHomeChatItemRoomPropInfo, str13, str14, str15, chatAnchorLevelModel, i, arrayList, arrayList2, arrayList3);
    }

    public static /* synthetic */ YyHomeChatItemDataInfoMode copy$default(YyHomeChatItemDataInfoMode yyHomeChatItemDataInfoMode, boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, YyHomeChatItemRoomPropInfo yyHomeChatItemRoomPropInfo, String str13, String str14, String str15, ChatAnchorLevelModel chatAnchorLevelModel, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = yyHomeChatItemDataInfoMode.isDraw;
        }
        if ((i2 & 2) != 0) {
            str = yyHomeChatItemDataInfoMode.uid;
        }
        if ((i2 & 4) != 0) {
            str2 = yyHomeChatItemDataInfoMode.room_type_id;
        }
        if ((i2 & 8) != 0) {
            str3 = yyHomeChatItemDataInfoMode.room_type_name;
        }
        if ((i2 & 16) != 0) {
            str4 = yyHomeChatItemDataInfoMode.room_id;
        }
        if ((i2 & 32) != 0) {
            str5 = yyHomeChatItemDataInfoMode.room_name;
        }
        if ((i2 & 64) != 0) {
            str6 = yyHomeChatItemDataInfoMode.room_member_count;
        }
        if ((i2 & 128) != 0) {
            str7 = yyHomeChatItemDataInfoMode.create_time;
        }
        if ((i2 & 256) != 0) {
            str8 = yyHomeChatItemDataInfoMode.sort;
        }
        if ((i2 & 512) != 0) {
            str9 = yyHomeChatItemDataInfoMode.theme_id;
        }
        if ((i2 & 1024) != 0) {
            str10 = yyHomeChatItemDataInfoMode.theme_name;
        }
        if ((i2 & 2048) != 0) {
            str11 = yyHomeChatItemDataInfoMode.user_avatar;
        }
        if ((i2 & 4096) != 0) {
            str12 = yyHomeChatItemDataInfoMode.user_name;
        }
        if ((i2 & 8192) != 0) {
            yyHomeChatItemRoomPropInfo = yyHomeChatItemDataInfoMode.prop_info;
        }
        if ((i2 & 16384) != 0) {
            str13 = yyHomeChatItemDataInfoMode.the_same_city;
        }
        if ((i2 & 32768) != 0) {
            str14 = yyHomeChatItemDataInfoMode.cover;
        }
        if ((i2 & 65536) != 0) {
            str15 = yyHomeChatItemDataInfoMode.label_link;
        }
        if ((i2 & 131072) != 0) {
            chatAnchorLevelModel = yyHomeChatItemDataInfoMode.chat_anchor_level;
        }
        if ((i2 & 262144) != 0) {
            i = yyHomeChatItemDataInfoMode.in_pk;
        }
        if ((i2 & 524288) != 0) {
            arrayList = yyHomeChatItemDataInfoMode.lists;
        }
        if ((i2 & 1048576) != 0) {
            arrayList2 = yyHomeChatItemDataInfoMode.adv_list;
        }
        if ((i2 & 2097152) != 0) {
            arrayList3 = yyHomeChatItemDataInfoMode.config;
        }
        return yyHomeChatItemDataInfoMode.copy(z, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, yyHomeChatItemRoomPropInfo, str13, str14, str15, chatAnchorLevelModel, i, arrayList, arrayList2, arrayList3);
    }

    public final boolean component1() {
        return this.isDraw;
    }

    public final String component10() {
        return this.theme_id;
    }

    public final String component11() {
        return this.theme_name;
    }

    public final String component12() {
        return this.user_avatar;
    }

    public final String component13() {
        return this.user_name;
    }

    public final YyHomeChatItemRoomPropInfo component14() {
        return this.prop_info;
    }

    public final String component15() {
        return this.the_same_city;
    }

    public final String component16() {
        return this.cover;
    }

    public final String component17() {
        return this.label_link;
    }

    public final ChatAnchorLevelModel component18() {
        return this.chat_anchor_level;
    }

    public final int component19() {
        return this.in_pk;
    }

    public final String component2() {
        return this.uid;
    }

    public final ArrayList<YyHomeChatItemDataInfoMode> component20() {
        return this.lists;
    }

    public final ArrayList<YYBannerModel> component21() {
        return this.adv_list;
    }

    public final ArrayList<YYHomeChatsRightTopMode> component22() {
        return this.config;
    }

    public final String component3() {
        return this.room_type_id;
    }

    public final String component4() {
        return this.room_type_name;
    }

    public final String component5() {
        return this.room_id;
    }

    public final String component6() {
        return this.room_name;
    }

    public final String component7() {
        return this.room_member_count;
    }

    public final String component8() {
        return this.create_time;
    }

    public final String component9() {
        return this.sort;
    }

    public final YyHomeChatItemDataInfoMode copy(boolean z, String uid, String room_type_id, String room_type_name, String room_id, String room_name, String room_member_count, String create_time, String sort, String theme_id, String theme_name, String user_avatar, String user_name, YyHomeChatItemRoomPropInfo prop_info, String the_same_city, String cover, String label_link, ChatAnchorLevelModel chat_anchor_level, int i, ArrayList<YyHomeChatItemDataInfoMode> lists, ArrayList<YYBannerModel> adv_list, ArrayList<YYHomeChatsRightTopMode> config) {
        Intrinsics.e(uid, "uid");
        Intrinsics.e(room_type_id, "room_type_id");
        Intrinsics.e(room_type_name, "room_type_name");
        Intrinsics.e(room_id, "room_id");
        Intrinsics.e(room_name, "room_name");
        Intrinsics.e(room_member_count, "room_member_count");
        Intrinsics.e(create_time, "create_time");
        Intrinsics.e(sort, "sort");
        Intrinsics.e(theme_id, "theme_id");
        Intrinsics.e(theme_name, "theme_name");
        Intrinsics.e(user_avatar, "user_avatar");
        Intrinsics.e(user_name, "user_name");
        Intrinsics.e(prop_info, "prop_info");
        Intrinsics.e(the_same_city, "the_same_city");
        Intrinsics.e(cover, "cover");
        Intrinsics.e(label_link, "label_link");
        Intrinsics.e(chat_anchor_level, "chat_anchor_level");
        Intrinsics.e(lists, "lists");
        Intrinsics.e(adv_list, "adv_list");
        Intrinsics.e(config, "config");
        return new YyHomeChatItemDataInfoMode(z, uid, room_type_id, room_type_name, room_id, room_name, room_member_count, create_time, sort, theme_id, theme_name, user_avatar, user_name, prop_info, the_same_city, cover, label_link, chat_anchor_level, i, lists, adv_list, config);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YyHomeChatItemDataInfoMode) {
            YyHomeChatItemDataInfoMode yyHomeChatItemDataInfoMode = (YyHomeChatItemDataInfoMode) obj;
            return this.isDraw == yyHomeChatItemDataInfoMode.isDraw && Intrinsics.a((Object) this.uid, (Object) yyHomeChatItemDataInfoMode.uid) && Intrinsics.a((Object) this.room_type_id, (Object) yyHomeChatItemDataInfoMode.room_type_id) && Intrinsics.a((Object) this.room_type_name, (Object) yyHomeChatItemDataInfoMode.room_type_name) && Intrinsics.a((Object) this.room_id, (Object) yyHomeChatItemDataInfoMode.room_id) && Intrinsics.a((Object) this.room_name, (Object) yyHomeChatItemDataInfoMode.room_name) && Intrinsics.a((Object) this.room_member_count, (Object) yyHomeChatItemDataInfoMode.room_member_count) && Intrinsics.a((Object) this.create_time, (Object) yyHomeChatItemDataInfoMode.create_time) && Intrinsics.a((Object) this.sort, (Object) yyHomeChatItemDataInfoMode.sort) && Intrinsics.a((Object) this.theme_id, (Object) yyHomeChatItemDataInfoMode.theme_id) && Intrinsics.a((Object) this.theme_name, (Object) yyHomeChatItemDataInfoMode.theme_name) && Intrinsics.a((Object) this.user_avatar, (Object) yyHomeChatItemDataInfoMode.user_avatar) && Intrinsics.a((Object) this.user_name, (Object) yyHomeChatItemDataInfoMode.user_name) && Intrinsics.a(this.prop_info, yyHomeChatItemDataInfoMode.prop_info) && Intrinsics.a((Object) this.the_same_city, (Object) yyHomeChatItemDataInfoMode.the_same_city) && Intrinsics.a((Object) this.cover, (Object) yyHomeChatItemDataInfoMode.cover) && Intrinsics.a((Object) this.label_link, (Object) yyHomeChatItemDataInfoMode.label_link) && Intrinsics.a(this.chat_anchor_level, yyHomeChatItemDataInfoMode.chat_anchor_level) && this.in_pk == yyHomeChatItemDataInfoMode.in_pk && Intrinsics.a(this.lists, yyHomeChatItemDataInfoMode.lists) && Intrinsics.a(this.adv_list, yyHomeChatItemDataInfoMode.adv_list) && Intrinsics.a(this.config, yyHomeChatItemDataInfoMode.config);
        }
        return false;
    }

    public final ArrayList<YYBannerModel> getAdv_list() {
        return this.adv_list;
    }

    public final ChatAnchorLevelModel getChat_anchor_level() {
        return this.chat_anchor_level;
    }

    public final ArrayList<YYHomeChatsRightTopMode> getConfig() {
        return this.config;
    }

    public final String getCover() {
        return this.cover;
    }

    public final String getCreate_time() {
        return this.create_time;
    }

    public final int getIn_pk() {
        return this.in_pk;
    }

    public final String getLabel_link() {
        return this.label_link;
    }

    public final ArrayList<YyHomeChatItemDataInfoMode> getLists() {
        return this.lists;
    }

    public final YyHomeChatItemRoomPropInfo getProp_info() {
        return this.prop_info;
    }

    public final String getRoom_id() {
        return this.room_id;
    }

    public final String getRoom_member_count() {
        return this.room_member_count;
    }

    public final String getRoom_name() {
        return this.room_name;
    }

    public final String getRoom_type_id() {
        return this.room_type_id;
    }

    public final String getRoom_type_name() {
        return this.room_type_name;
    }

    public final String getSort() {
        return this.sort;
    }

    public final String getThe_same_city() {
        return this.the_same_city;
    }

    public final String getTheme_id() {
        return this.theme_id;
    }

    public final String getTheme_name() {
        return this.theme_name;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getUser_avatar() {
        return this.user_avatar;
    }

    public final String getUser_name() {
        return this.user_name;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int hashCode() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final boolean isDraw() {
        return this.isDraw;
    }

    public final void setDraw(boolean z) {
        this.isDraw = z;
    }

    public String toString() {
        return "YyHomeChatItemDataInfoMode(isDraw=" + this.isDraw + ", uid=" + this.uid + ", room_type_id=" + this.room_type_id + ", room_type_name=" + this.room_type_name + ", room_id=" + this.room_id + ", room_name=" + this.room_name + ", room_member_count=" + this.room_member_count + ", create_time=" + this.create_time + ", sort=" + this.sort + ", theme_id=" + this.theme_id + ", theme_name=" + this.theme_name + ", user_avatar=" + this.user_avatar + ", user_name=" + this.user_name + ", prop_info=" + this.prop_info + ", the_same_city=" + this.the_same_city + ", cover=" + this.cover + ", label_link=" + this.label_link + ", chat_anchor_level=" + this.chat_anchor_level + ", in_pk=" + this.in_pk + ", lists=" + this.lists + ", adv_list=" + this.adv_list + ", config=" + this.config + ')';
    }
}
