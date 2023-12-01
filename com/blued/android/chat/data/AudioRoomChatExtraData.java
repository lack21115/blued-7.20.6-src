package com.blued.android.chat.data;

import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.utils.MsgPackHelper;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/data/AudioRoomChatExtraData.class */
public class AudioRoomChatExtraData implements Serializable {
    public int apply_count;
    public String bg_color;
    public int event;
    public String full_effects;
    public long full_effects_time;
    public int is_public;
    public int looker_count;
    public String msg_animation;
    public long room_create_time;
    public long room_id;
    public AudioLanguageModel room_language;
    public int room_member_count;
    public int room_member_lock_count;
    public int room_member_total;
    public String room_name;
    public String room_notice;
    public long room_owner;
    public AudioSystemNoticeModel system_notice;
    public AudioTagsModel tags;
    public String user_sig;
    public int wealth_level;
    public String wealth_level_badge_icon;
    public int member_role = 2;
    public List<RoomMember> room_members = new ArrayList();
    public List<RoomMember> looker_list = new ArrayList();
    public List<RoomMember> change_members = new ArrayList();
    public List<Integer> lock_list = new ArrayList();

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/data/AudioRoomChatExtraData$AudioLanguageModel.class */
    public static class AudioLanguageModel implements Serializable {
        public int is_default;
        public String lan;
        public String lan_sim;

        public void parseData(Map<String, Object> map) {
            if (map == null) {
                return;
            }
            this.lan = MsgPackHelper.getStringValue(map, "lan");
            this.lan_sim = MsgPackHelper.getStringValue(map, "lan_sim");
            this.is_default = MsgPackHelper.getIntValue(map, "is_default", 0);
        }

        public String toString() {
            return "AudioLanguageModel{lan='" + this.lan + "', lan_sim='" + this.lan_sim + "', is_default='" + this.is_default + "'}";
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/data/AudioRoomChatExtraData$AudioSystemNoticeModel.class */
    public static class AudioSystemNoticeModel implements Serializable {
        public String content;
        public String title;

        public void parseData(Map<String, Object> map) {
            if (map == null) {
                return;
            }
            this.title = MsgPackHelper.getStringValue(map, "title");
            this.content = MsgPackHelper.getStringValue(map, "content");
        }

        public String toString() {
            return "AudioSystemNoticeModel{title='" + this.title + "', content='" + this.content + "'}";
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/data/AudioRoomChatExtraData$AudioTagsModel.class */
    public static class AudioTagsModel implements Serializable {
        public String end_color;
        public String start_color;
        public String tag;

        public void parseData(Map<String, Object> map) {
            if (map == null) {
                return;
            }
            this.tag = MsgPackHelper.getStringValue(map, "tag");
            this.start_color = MsgPackHelper.getStringValue(map, "start_color");
            this.end_color = MsgPackHelper.getStringValue(map, "end_color");
        }

        public String toString() {
            return "AudioTagsModel{tag='" + this.tag + "', start_color='" + this.start_color + "', end_color='" + this.end_color + "'}";
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/data/AudioRoomChatExtraData$RoomMember.class */
    public static class RoomMember implements Serializable {
        public String animation;
        public transient String arApng;
        public String avatar;
        public String avatar_pendant;
        public String beans;
        public boolean isLockMic;
        public int member_role;
        public String name;
        public int seat_num;
        public long uid;
        public boolean isOnAnchor = false;
        public int is_invited = 0;
        public transient boolean select = false;

        /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/data/AudioRoomChatExtraData$RoomMember$MemberRole.class */
        public interface MemberRole {
            public static final int ANCHOR = 1;
            public static final int AUDIENCE = 2;
        }

        public void parseData(Map<String, Object> map) {
            if (map == null) {
                return;
            }
            this.uid = MsgPackHelper.getLongValue(map, "uid");
            this.name = MsgPackHelper.getStringValue(map, "name");
            this.avatar = MsgPackHelper.getStringValue(map, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR);
            this.animation = MsgPackHelper.getStringValue(map, ReqAckPackage.REQ_RESPONSE_KEY.ANIMATION);
            this.avatar_pendant = MsgPackHelper.getStringValue(map, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR_PENDANT);
            this.member_role = MsgPackHelper.getIntValue(map, ReqAckPackage.REQ_RESPONSE_KEY.MEMBER_ROLE);
            this.seat_num = MsgPackHelper.getIntValue(map, ReqAckPackage.REQ_RESPONSE_KEY.SEAT_NUM);
            this.isLockMic = MsgPackHelper.getBooleanValue(map, ReqAckPackage.REQ_RESPONSE_KEY.IS_LOCK_MIC);
            this.beans = MsgPackHelper.getStringValue(map, ReqAckPackage.REQ_RESPONSE_KEY.BEANS);
        }

        public String toString() {
            return "RoomMember{uid=" + this.uid + ", name='" + this.name + "', avatar='" + this.avatar + "', member_role='" + this.member_role + "', isOnAnchor='" + this.isOnAnchor + "', seat_num='" + this.seat_num + "'}";
        }
    }

    private void parseMembersMap(List<RoomMember> list, List<Map<String, Object>> list2) {
        if (list2 == null) {
            return;
        }
        for (Map<String, Object> map : list2) {
            RoomMember roomMember = new RoomMember();
            roomMember.parseData(map);
            list.add(roomMember);
        }
    }

    public void parseData(Map<String, Object> map) {
        List<Integer> list;
        if (map == null) {
            return;
        }
        Log.d("AudioRoomChat", "parseData" + map.toString());
        this.room_id = MsgPackHelper.getLongValue(map, TTLiveConstants.ROOMID_KEY);
        this.room_name = MsgPackHelper.getStringValue(map, "room_name");
        this.room_create_time = MsgPackHelper.getLongValue(map, "room_create_time");
        this.room_owner = MsgPackHelper.getLongValue(map, "room_owner");
        this.user_sig = MsgPackHelper.getStringValue(map, "user_sig");
        this.member_role = MsgPackHelper.getIntValue(map, ReqAckPackage.REQ_RESPONSE_KEY.MEMBER_ROLE);
        this.is_public = MsgPackHelper.getIntValue(map, "is_public");
        AudioLanguageModel audioLanguageModel = new AudioLanguageModel();
        this.room_language = audioLanguageModel;
        audioLanguageModel.parseData(MsgPackHelper.getMapValue(map, "room_language"));
        AudioSystemNoticeModel audioSystemNoticeModel = new AudioSystemNoticeModel();
        this.system_notice = audioSystemNoticeModel;
        audioSystemNoticeModel.parseData(MsgPackHelper.getMapValue(map, "system_notice"));
        this.room_member_total = MsgPackHelper.getIntValue(map, "room_member_total");
        this.room_member_lock_count = MsgPackHelper.getIntValue(map, "room_member_lock_count");
        this.looker_count = MsgPackHelper.getIntValue(map, "looker_count");
        this.apply_count = MsgPackHelper.getIntValue(map, "apply_count");
        this.room_member_count = MsgPackHelper.getIntValue(map, "room_member_count");
        this.bg_color = MsgPackHelper.getStringValue(map, ReqAckPackage.REQ_RESPONSE_KEY.BG_COLOR);
        List<Map<String, Object>> listValue = MsgPackHelper.getListValue(map, "room_members");
        List<Map<String, Object>> listValue2 = MsgPackHelper.getListValue(map, "looker_list");
        List<Map<String, Object>> listValue3 = MsgPackHelper.getListValue(map, "change_members");
        List listValue4 = MsgPackHelper.getListValue(map, "lock_list");
        parseMembersMap(this.room_members, listValue);
        parseMembersMap(this.looker_list, listValue2);
        parseMembersMap(this.change_members, listValue3);
        if (listValue4 != null && (list = this.lock_list) != null) {
            list.addAll(listValue4);
        }
        AudioTagsModel audioTagsModel = new AudioTagsModel();
        this.tags = audioTagsModel;
        audioTagsModel.parseData(MsgPackHelper.getMapValue(map, "tags"));
        this.room_notice = MsgPackHelper.getStringValue(map, "room_notice");
        this.event = MsgPackHelper.getIntValue(map, "event");
        this.full_effects = MsgPackHelper.getStringValue(map, ReqAckPackage.REQ_RESPONSE_KEY.EFFECT_MP4);
        this.full_effects_time = MsgPackHelper.getLongValue(map, ReqAckPackage.REQ_RESPONSE_KEY.EFFECT_MP4_TIME);
        this.wealth_level = MsgPackHelper.getIntValue(map, "wealth_level");
        this.wealth_level_badge_icon = MsgPackHelper.getStringValue(map, "wealth_level_badge_icon");
        this.msg_animation = MsgPackHelper.getStringValue(map, "msg_animation");
    }

    public String toString() {
        return "AudioRoomChatExtraData{room_id=" + this.room_id + ", room_name='" + this.room_name + "', room_create_time=" + this.room_create_time + ", room_owner=" + this.room_owner + ", user_sig=" + this.user_sig + ", member_role=" + this.member_role + ", is_public=" + this.is_public + ", room_language='" + this.room_language + "', roomMembersMaxCount=" + this.room_member_total + ", looker_count=" + this.looker_count + ", apply_count=" + this.apply_count + ", room_member_count=" + this.room_member_count + ", bg_color=" + this.bg_color + ", tags=" + this.tags + ", room_member_lock_count=" + this.room_member_lock_count + ", room_members=" + this.room_members + ", looker_list=" + this.looker_list + ", lock_list=" + this.lock_list + ", change_members=" + this.change_members + ", room_notice=" + this.room_notice + '}';
    }
}
