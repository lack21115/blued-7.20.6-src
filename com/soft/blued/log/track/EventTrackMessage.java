package com.soft.blued.log.track;

import android.text.TextUtils;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.das.message.MessageProtos;
import com.blued.track.trackUtils.EventTrackUtils;
import com.soft.blued.log.bytedance.MessageEventUtils;
import com.soft.blued.ui.find.manager.MapFindManager;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.msg.model.MsgSourceEntity;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/log/track/EventTrackMessage.class */
public class EventTrackMessage {

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/log/track/EventTrackMessage$ShareType.class */
    public static class ShareType {
    }

    private static MessageProtos.ShowType a(LogData logData) {
        MessageProtos.ShowType showType = MessageProtos.ShowType.UNKNOWN_SHOW_TYPE;
        MessageProtos.ShowType showType2 = showType;
        if (logData != null) {
            showType2 = showType;
            if (logData.type != null) {
                if ("0".equalsIgnoreCase(logData.type)) {
                    return MessageProtos.ShowType.PALACE_SHOW;
                }
                showType2 = MessageProtos.ShowType.LIST_SHOW;
            }
        }
        return showType2;
    }

    private static String a(String str) {
        return EventTrackUtils.a(str);
    }

    public static void a(MessageProtos.Event event) {
        if (event != null) {
            EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).build());
        }
    }

    public static void a(MessageProtos.Event event, int i) {
        if (event != null) {
            MessageProtos.MessageProto.Builder event2 = MessageProtos.MessageProto.newBuilder().setEvent(event);
            EventTrackUtils.a(event2.setImageId(i + "").build());
        }
    }

    public static void a(MessageProtos.Event event, int i, String str) {
        if (event != null) {
            EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setPosition(i).setTargetUid(str).build());
        }
    }

    public static void a(MessageProtos.Event event, ChattingModel chattingModel, String str, String str2) {
        if (event != null) {
            MessageProtos.MessageProto.Builder type = MessageProtos.MessageProto.newBuilder().setId(a(str2)).setType(a(str));
            MessageProtos.MessageProto.Builder msgId = type.setMsgId(a(chattingModel.msgId + ""));
            EventTrackUtils.a(msgId.setTargetUid(a(chattingModel.fromId + "")).setEvent(event).build());
        }
    }

    public static void a(MessageProtos.Event event, LogData logData, MsgSourceEntity msgSourceEntity) {
        String str;
        if (event != null) {
            LogData logData2 = logData;
            if (logData == null) {
                logData2 = new LogData();
            }
            boolean equalsIgnoreCase = "1".equalsIgnoreCase(logData2.is_hello);
            String a2 = a(logData2.feed_id);
            if (!TextUtils.isEmpty(logData2.activity_id)) {
                a2 = a(logData2.activity_id);
                str = "3";
            } else if (TextUtils.isEmpty(logData2.feed_id)) {
                str = "0";
            } else if (logData2.is_vote == 1) {
                str = "5";
            } else if (logData2.is_questionnaire == 1) {
                str = "6";
            } else if (logData2.tt_type == 3) {
                str = "7";
            } else if (logData2.tt_type == 5) {
                str = "8";
            } else if (logData2.tt_type == 6) {
                str = "9";
            } else if (TextUtils.isEmpty(logData2.circle_id)) {
                str = "1";
            } else {
                a2 = a(logData2.circle_id);
                str = "2";
            }
            if ("1".equals(logData2.is_call)) {
                str = "4";
            }
            EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setStrangerSource(b(logData2.userFrom)).setShowType(a(logData2)).setTargetUid(a(logData2.target_uid)).setIsAppreciateCall(equalsIgnoreCase).setIsSuperExposure(logData2.is_feed_super_exposure).setIsMapFind(MapFindManager.a().b()).setIsShadow(logData2.isShadow).setIsQuietCall(logData2.isQuietHello).setIsAi(logData2.isReactiveRecommend).setMode(a(logData2.listMode)).setId(a2).setType(str).setIsSpecial(logData2.is_special != null && TextUtils.equals(logData2.is_special, "1")).setStrategy(a(logData2.strong_insert_data)).setVirtual(logData2.virtual).setIsNew(logData2.is_new_face == 1).setIsSpecial(TextUtils.equals(logData2.is_special, "1")).setIsSuperCall(logData2.is_super_call).setLogoId(a(logData2.super_tag_image)).build());
            MessageEventUtils.a(event.name(), b(logData2.userFrom).name(), logData2);
        }
    }

    public static void a(MessageProtos.Event event, MessageProtos.SourceType sourceType, int i, MessageProtos.PhotoType photoType) {
        if (event == null || sourceType == null || photoType == null) {
            return;
        }
        EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setPhotoSource(sourceType).setPhotoNum(i).setPhotoType(photoType).build());
    }

    public static void a(MessageProtos.Event event, MessageProtos.StrangerSource strangerSource, String str) {
        MessageProtos.MessageProto.Builder newBuilder = MessageProtos.MessageProto.newBuilder();
        if (event != null) {
            newBuilder.setEvent(event);
        }
        if (strangerSource != null) {
            newBuilder.setStrangerSource(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE);
        }
        if (!TextUtils.isEmpty(str)) {
            newBuilder.setTargetUid(str);
        }
        EventTrackUtils.a(newBuilder.build());
    }

    public static void a(MessageProtos.Event event, MessageProtos.StrangerSource strangerSource, String str, boolean z, MessageProtos.CallType callType) {
        MessageProtos.MessageProto.Builder newBuilder = MessageProtos.MessageProto.newBuilder();
        if (event != null) {
            newBuilder.setEvent(event);
        }
        if (strangerSource != null) {
            newBuilder.setStrangerSource(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE);
        }
        if (!TextUtils.isEmpty(str)) {
            newBuilder.setTargetUid(str);
        }
        newBuilder.setIsValid(z);
        if (callType != null) {
            newBuilder.setCallType(callType);
        }
        EventTrackUtils.a(newBuilder.build());
    }

    public static void a(MessageProtos.Event event, MessageProtos.WarnType warnType, MessageProtos.WarnTime warnTime) {
        if (event == null || warnType == null) {
            return;
        }
        EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setWarnTime(warnTime).setWarnType(warnType).build());
    }

    public static void a(MessageProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setType(str).build());
        }
    }

    public static void a(MessageProtos.Event event, String str, long j, long j2, long j3, String str2) {
        if (event != null) {
            EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setStartTime(j).setEndTime(j2).setDuration(j3).setTargetUid(a(str)).setType(a(str2)).build());
        }
    }

    public static void a(MessageProtos.Event event, String str, MessageProtos.SortType sortType, String str2, MessageProtos.CallType callType) {
        if (event == null || sortType == null) {
            return;
        }
        EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setTargetUid(a(str)).setSortType(sortType).setCallFilter(a(str2)).setCallType(callType).build());
    }

    public static void a(MessageProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setUrl(str).setId(a(str2)).setType(!TextUtils.isEmpty(str2) ? "msg" : "other").build());
        }
    }

    public static void a(MessageProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setTargetUid(str).setType(str2).setUrl(str3).build());
        }
    }

    public static void a(MessageProtos.Event event, String str, String str2, String str3, String str4, int i, String str5) {
        if (event != null) {
            EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setId(a(str)).setMsgId(a(str2)).setUrl(a(str3)).setName(a(str5)).setType(a(str4)).setPosition(i).build());
        }
    }

    public static void a(MessageProtos.Event event, String str, String str2, String str3, String str4, String str5) {
        if (event != null) {
            EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setId(a(str)).setMsgId(a(str2)).setUrl(a(str3)).setName(a(str5)).setType(a(str4)).build());
        }
    }

    public static void a(MessageProtos.Event event, String str, boolean z) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setId(a(str)).setIsOpen(z).build());
    }

    public static void a(MessageProtos.Event event, String str, boolean... zArr) {
        if (event != null) {
            MessageProtos.MessageProto.Builder event2 = MessageProtos.MessageProto.newBuilder().setEvent(event);
            boolean z = false;
            if (zArr.length > 0) {
                z = false;
                if (zArr[0]) {
                    z = true;
                }
            }
            EventTrackUtils.a(event2.setIsBuy(z).setId(str).build());
        }
    }

    public static void a(MessageProtos.Event event, boolean z) {
        if (event != null) {
            EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setIsOpen(z).build());
        }
    }

    public static void a(String str, String str2, float f) {
        EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(MessageProtos.Event.MSG_MATCH_CHAT_PAGE_SHOW).setTargetUid(a(str)).setDistance(a(str2)).setRate(f).build());
    }

    private static MessageProtos.StrangerSource b(String str) {
        MessageProtos.StrangerSource strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
        if ("my_visitor".equalsIgnoreCase(str)) {
            return MessageProtos.StrangerSource.FRIEND_NEARBY_VISIT;
        }
        if ("my_visited".equalsIgnoreCase(str)) {
            return MessageProtos.StrangerSource.FRIEND_NEARBY_VIEW;
        }
        if ("feed_notice".equalsIgnoreCase(str)) {
            return MessageProtos.StrangerSource.FOLLOW_ATTENTION;
        }
        if ("shine_video_list".equalsIgnoreCase(str)) {
            return MessageProtos.StrangerSource.FIND_PLAZA_FLASH;
        }
        if ("feed_square".equalsIgnoreCase(str)) {
            return MessageProtos.StrangerSource.FIND_PLAZA_RECOMMEND;
        }
        if ("msg_hello".equalsIgnoreCase(str)) {
            return MessageProtos.StrangerSource.APPRECIATE_CALL_SHORT;
        }
        if ("msg_hello_detail".equalsIgnoreCase(str)) {
            return MessageProtos.StrangerSource.APPRECIATE_CALL_TOTAL;
        }
        if ("my_followed".equalsIgnoreCase(str) || "my_secret_follow".equalsIgnoreCase(str)) {
            strangerSource = MessageProtos.StrangerSource.MINE_FOLLOW;
        } else if ("my_fans".equalsIgnoreCase(str)) {
            return MessageProtos.StrangerSource.MINE_FAN;
        } else {
            if ("my_friends".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.MINE_FRIEND;
            }
            if (UserFindResult.USER_SORT_BY.INTEGRATE.equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.COMPLEX_SORT;
            }
            if (UserFindResult.USER_SORT_BY.ONLINE.equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.ONLINE_TIME_SORT;
            }
            if (UserFindResult.USER_SORT_BY.NEARBY.equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.DISTANCE_SORT;
            }
            if (UserFindResult.USER_SORT_BY.SELECTED.equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.NEARBY_FEATURED;
            }
            if (UserFindResult.USER_SORT_BY.NEWBEE.equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.NEW_FACE;
            }
            if ("nearby_mix_recommend".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.APPRECIATE_CALL_SHORT;
            }
            if ("feed_comment_floor".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.FEED_COMMENT;
            }
            if ("topic_detail".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.SUPER_TOPIC_DETAIL;
            }
            if ("feed_followed".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.FIND_PLAZA_FOLLOW;
            }
            if ("feed_nearby".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.FIND_PLAZA_NEARBY;
            }
            if ("feed_city_time".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.CITY_TIME;
            }
            if ("feed_image".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.FIND_PLAZA_IMAGE;
            }
            if ("shine_video_detail".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.FIND_PLAZA_FLASH_DETAIL;
            }
            if ("feed_detail".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.FEED_DETAIL;
            }
            if ("feed_horizontal_recommend".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.FIND_PLAZA_RECOMMEND_USER;
            }
            if ("PAGE_FEED_MINE".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.PAGE_FEED_MINE;
            }
            if ("PAGE_FEED_LIKE".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.PAGE_FEED_LIKE;
            }
            if ("PAGE_FEED_DETAIL_MORE".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.PAGE_FEED_DETAIL_MORE;
            }
            if ("CIRCLE_MEMBERS".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.CIRCLE_USERS;
            }
            if ("CIRCLE_NOTE_DETAIL".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.CIRCLE_NOTE_DETAIL;
            }
            if ("group_chatting".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.GROUP_CHAT;
            }
            if ("msg_chat_room".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.CHAT_ROOM;
            }
            if ("private_chatting_top_title".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.MSG_TOP_TITLE;
            }
            if ("private_chatting_photo".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.MSG_PHOTO;
            }
            if ("chat_setting".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.MSG_SETTING_PHOTO;
            }
            if ("notice_like".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.NOTICE_LIKE;
            }
            if ("map_avatart_location".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.MAP_FRIEND_USER;
            }
            if ("nearby_operation".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.NEARBY_OPERATION;
            }
            if ("recommend_same".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.SAME_USER;
            }
            if ("sunject_recommend".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.TOPIC_RECOMMEND;
            }
            if ("sunject_latest".equalsIgnoreCase(str)) {
                return MessageProtos.StrangerSource.TOPIC_NEW;
            }
        }
        return strangerSource;
    }

    public static void b(MessageProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setType(str).build());
        }
    }

    public static void b(MessageProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setId(str).setTargetUid(str2).build());
        }
    }

    public static void b(MessageProtos.Event event, String str, String str2, String str3) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setTargetUid(a(str3)).build());
    }

    public static void b(MessageProtos.Event event, String str, boolean z) {
        if (event != null) {
            EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setTargetUid(a(str)).setIsOpen(z).build());
        }
    }

    public static void c(MessageProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setDestination(str).build());
        }
    }

    public static void c(MessageProtos.Event event, String str, String str2) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).build());
    }

    public static void c(MessageProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setTargetUid(a(str)).setRoomUid(a(str3)).setRoomId(a(str2)).build());
        }
    }

    public static void d(MessageProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setKeyword(str).build());
        }
    }

    public static void d(MessageProtos.Event event, String str, String str2) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setType(a(str)).setReason(a(str2)).build());
    }

    public static void d(MessageProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setType(a(str)).setTargetUid(a(str2)).setId(a(str3)).build());
        }
    }

    public static void e(MessageProtos.Event event, String str) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setTargetUid(a(str)).build());
    }

    public static void e(MessageProtos.Event event, String str, String str2) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setId(a(str)).setName(a(str2)).build());
    }

    public static void f(MessageProtos.Event event, String str, String str2) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setId(a(str)).setType(a(str2)).build());
    }

    public static void g(MessageProtos.Event event, String str, String str2) {
        if (event != null) {
            MessageEventUtils.a(event, a(str2), a(str));
            EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setRoomUid(a(str2)).setRoomId(a(str)).build());
        }
    }

    public static void h(MessageProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setTargetUid(a(str)).setStatus(a(str2)).build());
        }
    }

    public static void i(MessageProtos.Event event, String str, String str2) {
        EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setTargetUid(a(str)).setDistance(a(str2)).build());
    }
}
