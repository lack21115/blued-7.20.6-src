package com.soft.blued.log.track;

import android.text.TextUtils;
import com.blued.android.core.utils.SafeUtils;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.community.model.AlbumFlow;
import com.blued.community.track.ByteDanceEvent;
import com.blued.das.profile.PersonalProfileProtos;
import com.blued.track.trackUtils.EventTrackUtils;
import com.soft.blued.ui.find.manager.MapFindManager;
import com.soft.blued.ui.find.model.UserFindResult;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/log/track/EventTrackPersonalProfile.class */
public class EventTrackPersonalProfile {
    private static PersonalProfileProtos.ShowType a(LogData logData) {
        PersonalProfileProtos.ShowType showType = PersonalProfileProtos.ShowType.UNKNOWN_SHOW_TYPE;
        PersonalProfileProtos.ShowType showType2 = showType;
        if (logData != null) {
            showType2 = showType;
            if (logData.type != null) {
                if ("0".equalsIgnoreCase(logData.type)) {
                    return PersonalProfileProtos.ShowType.PALACE_SHOW;
                }
                showType2 = PersonalProfileProtos.ShowType.LIST_SHOW;
            }
        }
        return showType2;
    }

    public static PersonalProfileProtos.Source a(String str) {
        PersonalProfileProtos.Source source = PersonalProfileProtos.Source.UNKNOWN_FOLLOW_SOURCE;
        if ("my_visitor".equalsIgnoreCase(str)) {
            return PersonalProfileProtos.Source.FRIEND_NEARBY_VISIT;
        }
        if ("my_visited".equalsIgnoreCase(str)) {
            return PersonalProfileProtos.Source.FRIEND_NEARBY_VIEW;
        }
        if ("feed_notice".equalsIgnoreCase(str)) {
            return PersonalProfileProtos.Source.FOLLOW_ATTENTION;
        }
        if ("shine_video_list".equalsIgnoreCase(str)) {
            return PersonalProfileProtos.Source.FIND_PLAZA_FLASH;
        }
        if ("feed_square".equalsIgnoreCase(str)) {
            return PersonalProfileProtos.Source.FIND_PLAZA_RECOMMEND;
        }
        if ("msg_hello".equalsIgnoreCase(str)) {
            return PersonalProfileProtos.Source.APPRECIATE_CALL_SHORT;
        }
        if ("msg_hello_detail".equalsIgnoreCase(str)) {
            return PersonalProfileProtos.Source.APPRECIATE_CALL_TOTAL;
        }
        if ("my_followed".equalsIgnoreCase(str) || "my_secret_follow".equalsIgnoreCase(str)) {
            source = PersonalProfileProtos.Source.MINE_FOLLOW;
        } else if ("my_fans".equalsIgnoreCase(str)) {
            return PersonalProfileProtos.Source.MINE_FAN;
        } else {
            if ("my_friends".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.MINE_FRIEND;
            }
            if (UserFindResult.USER_SORT_BY.INTEGRATE.equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.COMPLEX_SORT;
            }
            if (UserFindResult.USER_SORT_BY.ONLINE.equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.ONLINE_TIME_SORT;
            }
            if (UserFindResult.USER_SORT_BY.NEARBY.equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.DISTANCE_SORT;
            }
            if (UserFindResult.USER_SORT_BY.SELECTED.equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.NEARBY_FEATURED;
            }
            if (UserFindResult.USER_SORT_BY.NEWBEE.equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.NEW_FACE;
            }
            if ("nearby_mix_recommend".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.APPRECIATE_CALL_SHORT;
            }
            if ("feed_comment_floor".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.FEED_COMMENT;
            }
            if ("topic_detail".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.SUPER_TOPIC_DETAIL;
            }
            if ("feed_followed".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.FIND_PLAZA_FOLLOW;
            }
            if ("feed_nearby".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.FIND_PLAZA_NEARBY;
            }
            if ("feed_image".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.FIND_PLAZA_IMAGE;
            }
            if ("shine_video_detail".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.FIND_PLAZA_FLASH_DETAIL;
            }
            if ("feed_detail".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.FEED_DETAIL;
            }
            if ("feed_horizontal_recommend".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.FIND_PLAZA_RECOMMEND_USER;
            }
            if ("PAGE_FEED_MINE".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.PAGE_FEED_MINE;
            }
            if ("PAGE_FEED_LIKE".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.PAGE_FEED_LIKE;
            }
            if ("PAGE_FEED_DETAIL_MORE".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.PAGE_FEED_DETAIL_MORE;
            }
            if ("CIRCLE_MEMBERS".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.CIRCLE_USERS;
            }
            if ("CIRCLE_NOTE_DETAIL".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.CIRCLE_NOTE_DETAIL;
            }
            if ("CIRCLE_ACTIVE_MEMBER_LIST".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.CIRCLE_ACTIVE_MEMBER_LIST;
            }
            if ("CIRCLE_ACTIVE_MEMBER_MISSION".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.CIRCLE_ACTIVE_MEMBER_MISSION;
            }
            if ("attention_notify".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.NOTICE_FOLLOW_ME;
            }
            if ("feed_show_photo".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.FEED_IMAGE_FULL_SCREEN;
            }
            if ("album_show_video".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.PERSONAL_VIDEO_FULL_SCREEN;
            }
            if ("feed_city_time".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.CITY_TIME;
            }
            if ("private_chatting_top_title".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.MSG_TOP_TITLE;
            }
            if ("private_chatting_photo".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.MSG_PHOTO;
            }
            if ("chat_setting".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.MSG_SETTING_PHOTO;
            }
            if ("notice_like".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.NOTICE_LIKE;
            }
            if ("map_avatart_location".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.MAP_FRIEND_USER;
            }
            if ("nearby_operation".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.NEARBY_OPERATION;
            }
            if ("recommend_same".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.SAME_USER;
            }
            if ("sunject_recommend".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.TOPIC_RECOMMEND;
            }
            if ("sunject_latest".equalsIgnoreCase(str)) {
                return PersonalProfileProtos.Source.TOPIC_NEW;
            }
        }
        return source;
    }

    public static PersonalProfileProtos.TargetIdentityType a(int i) {
        return i != 1 ? i != 2 ? PersonalProfileProtos.TargetIdentityType.NONE : PersonalProfileProtos.TargetIdentityType.SVIP : PersonalProfileProtos.TargetIdentityType.VIP;
    }

    public static void a(PersonalProfileProtos.Event event) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(event).build());
        }
    }

    public static void a(PersonalProfileProtos.Event event, int i) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(event).setType(i).build());
        }
    }

    public static void a(PersonalProfileProtos.Event event, LogData logData) {
        if (event != null) {
            LogData logData2 = logData;
            if (logData == null) {
                logData2 = new LogData();
            }
            boolean equalsIgnoreCase = "1".equalsIgnoreCase(logData2.is_hello);
            String b = b(logData2.feed_id);
            int i = 6;
            if (!TextUtils.isEmpty(logData2.activity_id)) {
                b = b(logData2.activity_id);
                i = 3;
            } else if (TextUtils.isEmpty(logData2.feed_id)) {
                i = 0;
            } else if (logData2.is_vote == 1) {
                i = 5;
            } else if (logData2.is_questionnaire != 1) {
                if (logData2.tt_type == 3) {
                    i = 7;
                } else if (logData2.tt_type == 5) {
                    i = 8;
                } else if (logData2.tt_type == 6) {
                    i = 9;
                } else if (TextUtils.isEmpty(logData2.circle_id)) {
                    i = 1;
                } else {
                    i = 2;
                    b = b(logData2.circle_id);
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("source", a(logData2.userFrom).name());
                jSONObject.put("target_uid", logData2.target_uid);
                jSONObject.put("id", logData2.feed_id);
                jSONObject.put("type", i);
                jSONObject.put("strategy", logData2.strong_insert_data);
                jSONObject.put("show_type", b(logData2.show_type));
                jSONObject.put("call", SafeUtils.a(logData2.is_call == null ? "0" : logData2.is_call) == 1);
                jSONObject.put("special", SafeUtils.a(logData2.is_special == null ? "0" : logData2.is_special) == 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ByteDanceEvent.a(event.name(), jSONObject);
            PersonalProfileProtos.PersonalProfileProto.Builder virtual = PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(event).setSource(a(logData2.userFrom)).setShowType(a(logData2)).setDistance(logData2.distance == null ? "" : logData2.distance).setOnlineTime(logData2.online_time == null ? "" : logData2.online_time).setReason(logData2.vip_selected_reason).setLabel(logData2.vip_selected_tag == null ? "" : logData2.vip_selected_tag).setTargetUid(b(logData2.target_uid)).setIsAppreciateCall(equalsIgnoreCase).setIsSuperExposure(logData2.is_feed_super_exposure).setIsMapFind(MapFindManager.a().b()).setIsShadow(logData2.isShadow).setIsQuietCall(logData2.isQuietHello).setIsFollow(logData2.isAddFollow).setLiveId(b(logData2.session_id + "")).setIsAi(logData2.isReactiveRecommend).setFeedId(b(logData2.feed_id)).setIsHot(logData2.is_hot_feed == 1).setId(b).setMode(b(logData2.listMode)).setType(i).setIsSpecial(logData2.is_special != null && TextUtils.equals(logData2.is_special, "1")).setStrategy(b(logData2.strong_insert_data)).setVirtual(logData2.virtual);
            boolean z = false;
            if (logData2.is_new_face == 1) {
                z = true;
            }
            EventTrackUtils.a(virtual.setIsNew(z).setIsSuperCall(logData2.is_super_call).setLogoId(b(logData2.super_tag_image)).build());
        }
    }

    public static void a(PersonalProfileProtos.Event event, AlbumFlow albumFlow, boolean z, PersonalProfileProtos.Source source) {
        if (event != null) {
            PersonalProfileProtos.PersonalProfileProto.Builder strategy = PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(event).setTargetUid(b(albumFlow.feed_uid)).setFeedId(b(albumFlow.feed_id)).setIsVideo(z).setSource(source).setIsIcon(albumFlow.is_top_hot == 1).setIsHot(albumFlow.is_hot_feed == 1).setDistance(b(albumFlow.distance)).setStrategy(b(albumFlow.strong_insert_data));
            boolean z2 = false;
            if (albumFlow.is_new_face == 1) {
                z2 = true;
            }
            EventTrackUtils.a(strategy.setIsNew(z2).setUrl(b(albumFlow.album_pic)).build());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("source", source.name());
                jSONObject.put("is_video", z);
                jSONObject.put("feed_id", albumFlow.feed_id);
                ByteDanceEvent.a(event.name(), jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(PersonalProfileProtos.Event event, PersonalProfileProtos.TabType tabType, String str) {
        if (event == null || tabType == null) {
            return;
        }
        EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setTabType(tabType).setEvent(event).setTargetUid(b(str)).build());
    }

    public static void a(PersonalProfileProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(event).setId(str).build());
        }
    }

    public static void a(PersonalProfileProtos.Event event, String str, int i) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(event).setTargetUid(b(str)).setTargetIdentityType(a(i)).build());
        }
    }

    public static void a(PersonalProfileProtos.Event event, String str, PersonalProfileProtos.GiftFrom giftFrom) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setTargetUid(b(str)).setEvent(event).setGiftFrom(giftFrom).build());
        }
    }

    public static void a(PersonalProfileProtos.Event event, String str, PersonalProfileProtos.GiftFrom giftFrom, String str2, boolean z) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setTargetUid(b(str)).setEvent(event).setGiftId(b(str2)).setGiftFrom(giftFrom).setIsBag(z).build());
        }
    }

    public static void a(PersonalProfileProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(event).setTargetUid(b(str)).setId(str2).build());
        }
    }

    public static void a(PersonalProfileProtos.Event event, String str, String str2, int i, String str3) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setTargetUid(b(str)).setEvent(event).setFeedId(b(str2)).setType(i).setUrl(b(str3)).build());
        }
    }

    public static void a(PersonalProfileProtos.Event event, String str, boolean z) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(event).setTargetUid(b(str)).setIsTrue(z).build());
        }
    }

    public static void a(PersonalProfileProtos.Event event, boolean z) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(event).setIsTrue(z).build());
        }
    }

    public static void a(String str, PersonalProfileProtos.VoteOption voteOption) {
        EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(PersonalProfileProtos.Event.BLUED_OFFICER_VOTE_BTN_CLICK).setTargetUid(str).setVoteOption(voteOption).build());
    }

    public static void a(boolean z) {
        EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(PersonalProfileProtos.Event.EDIT_SIGNATURE_VIP_PAGE_BTN_CLICK).setIdentityNum(UserInfo.getInstance().getLoginUserInfo().vbadge).setIsOpen(z).build());
    }

    private static String b(String str) {
        return EventTrackUtils.a(str);
    }

    public static void b(PersonalProfileProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(event).setTargetUid(EventTrackUtils.a(str)).build());
        }
    }

    public static void b(PersonalProfileProtos.Event event, String str, int i) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setTargetUid(b(str)).setEvent(event).setPosition(i).build());
        }
    }

    public static void b(PersonalProfileProtos.Event event, String str, PersonalProfileProtos.GiftFrom giftFrom) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setTargetUid(b(str)).setEvent(event).setGiftFrom(giftFrom).build());
        }
    }

    public static void b(PersonalProfileProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(event).setTargetUid(b(str)).setLiveId(b(str2)).build());
        }
    }

    public static void b(PersonalProfileProtos.Event event, String str, boolean z) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(event).setTargetUid(b(str)).setIsOpen(z).build());
        }
    }

    public static void c(PersonalProfileProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(event).setFeedId(b(str)).build());
        }
    }

    public static void c(PersonalProfileProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(event).setTargetUid(b(str)).setFeedId(b(str2)).build());
        }
    }

    public static void d(PersonalProfileProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setTargetUid(b(str)).setEvent(event).build());
        }
    }

    public static void d(PersonalProfileProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(event).setTargetUid(b(str)).setId(b(str2)).build());
        }
    }

    public static void e(PersonalProfileProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(event).setTargetUid(b(str)).build());
        }
    }

    public static void e(PersonalProfileProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(event).setTargetUid(b(str)).setName(b(str2)).build());
        }
    }
}
