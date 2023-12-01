package cn.irisgw.live;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveMsgType.class */
public enum LiveMsgType implements ProtocolMessageEnum {
    EMPTY_T(0),
    TEXT(1),
    JOIN_LIVE(27),
    LEAVE_LIVE(28),
    STOP_LIVE(29),
    LIKE(31),
    GIFT(33),
    WARING(34),
    EVENT_RANK(36),
    BARRAGE(37),
    FIREWORK(38),
    MEDAL(39),
    HORN(40),
    FIRST_FOLLOW(49),
    FIRST_SHARE(50),
    FIRST_LIKE(51),
    BOX(60),
    BOX_GIFT(61),
    HONGBAO(92),
    REFUND(94),
    UPGRADE_RICH_LEVEL(102),
    FOLLOW_NOTICE(103),
    CHAT_NOTICE(104),
    MANAGER_APPOINTMENT(106),
    MANAGER_CANCEL(107),
    MUTE(108),
    UNMUTE(109),
    PK_INVITE(114),
    PK_START(115),
    PK_END(116),
    PK_SCORE(117),
    H5_EVENT(118),
    LINE_INVITE(119),
    LINE_START(120),
    LINE_END(121),
    LINE_REFUSE(122),
    EVENT(123),
    FRIEND_MODE_APPLY(127),
    VOICE_UP_INVITE(128),
    VOICE_UP_IGNORE(129),
    INVITE_IGNORE(130),
    VOICE_STATUS_UPDATE(131),
    FRIEND_MODE_ENTER(132),
    FRIEND_MODE_LEAVE(133),
    FRIEND_MODE_VOICE_UP(134),
    FRIEND_MODE_VOICE_DOWN(135),
    SYNC_FRONT_AUDIENCE(140),
    H5_EVENT_BUBBLE(141),
    SYNC_EXP(154),
    LEVEL_UPDATE(155),
    TAG_LOCATION(157),
    LOTTERY_EVENT(163),
    MALL_ENTRANCE(165),
    TOP_TREND_RANK(167),
    FAN_CLUB_LEVEL(173),
    LOVE_OPEN(190),
    LOVE_CLOSE(191),
    LOVE_JOIN_SYNC(179),
    LOVE_UP(180),
    LOVE_ESC(181),
    LOVE_SUCCESS(183),
    LOVE_LIGHT(184),
    LOVE_DARK(182),
    LOVE_SHOW(185),
    LOVE_JOIN_DISAGREE(187),
    LOVE_JOIN_AGREE(186),
    LOVE_JOIN_REJECT(192),
    LIVE_TOP(194),
    TASK_PROCESS(200),
    TASK_FINISH_NOTIFY(202),
    OFFICIAL_RECOMMEND(211),
    LIVE_ACTIVITY(213),
    PK_BUFF(215),
    GOODS_WISH_LIST_UPDATE(216),
    UPDATE_WISH_LIST(220),
    DRAW_GOODS(221),
    GOODS_LUCK_BAG(222),
    PK_GIFT_OPPONENT(223),
    PK_WIN_STREAK(224),
    LIVE_NOTICE(225),
    LIVE_CONTENT_NOTICE_CREATE(226),
    LIVE_CONTENT_NOTICE_DESTROY(227),
    HOUR_RANK(228),
    PK_3(229),
    COMMON_TOAST(230),
    PK_FINAL_TYPE(231),
    KICK_OUT(232),
    NEW_HORN(233),
    NEW_LINE_UPDATE(234),
    NEW_LINE_INVITE(235),
    WISHING_DRAW(236),
    HOUR_RANK_POP(237),
    CHALLENGE_MATCH(238),
    CHALLENGE_EGG_RESULT(239),
    CHALLENGE_PROP(240),
    CHALLENGE_UPDATE(241),
    CHALLENGE_KILL(242),
    CHALLENGE_END(243),
    CHALLENGE_SYNC(244),
    WINNING_PRIZE(245),
    RESET_WISH_LIST(246),
    CUSTOM_RANK(247),
    ANIMATION(248),
    CHICKEN_NOTIFY(249),
    HTML_NOTICE(250),
    WISHING_CONTEST_TEXT(251),
    WISHING_CONTEST(252),
    PK_OPERATED(253),
    PUBLISH_PK_MACHINES(254),
    PK_MACHINES_TOOLS(255),
    LIKE_UPDATE_CURRENT_BEANS(256),
    LIVE_ROOM_TOOLS_CHANGE(257),
    LIVE_RED_POINT(258),
    MULTI_PK_START(259),
    MULTI_PK_END(260),
    MULTI_PK_RANK(261),
    MULTI_PK_EXIT(262),
    COMMON_ALERT(263),
    PUBLISH_CHAT_BADGE(264),
    COLLECTION_POP_TEXT(265),
    COMMON_SWITCH(266),
    NOBLE_UPGRADE(267),
    USER_INFO_UPGRADE(268),
    PLAY_LANTERN(269),
    PLAY_LANTERN_UPDATE(270),
    LIVE_ROOM_TIPS(271),
    MULTI_PK_MVP(272),
    GROUP_PK_OPERATE(273),
    GROUP_PK_INFO(274),
    BATTLE_PASS_REWARD_NOTIFY(275),
    BLUED_CHAT_CONTENT(276),
    GOODS_SET_ANIMATION(277),
    EXPEDITION_PLANET_DRAW(278),
    EXPEDITION_PLANET_TEXT(279),
    GOODS_WALL_ENTRANCE(280),
    LIVE_VIP(281),
    ADMIN_COMMENT(282),
    Activity_Message(283),
    CONSTELLATION_TOP(284),
    CONSTELLATION_BASIC_COUNT(285),
    CONSTELLATION_TEXT(286),
    LEFT_BOTTOM_COMMON_MSG(287),
    UNRECOGNIZED(-1);
    
    public static final int ADMIN_COMMENT_VALUE = 282;
    public static final int ANIMATION_VALUE = 248;
    public static final int Activity_Message_VALUE = 283;
    public static final int BARRAGE_VALUE = 37;
    public static final int BATTLE_PASS_REWARD_NOTIFY_VALUE = 275;
    public static final int BLUED_CHAT_CONTENT_VALUE = 276;
    public static final int BOX_GIFT_VALUE = 61;
    public static final int BOX_VALUE = 60;
    public static final int CHALLENGE_EGG_RESULT_VALUE = 239;
    public static final int CHALLENGE_END_VALUE = 243;
    public static final int CHALLENGE_KILL_VALUE = 242;
    public static final int CHALLENGE_MATCH_VALUE = 238;
    public static final int CHALLENGE_PROP_VALUE = 240;
    public static final int CHALLENGE_SYNC_VALUE = 244;
    public static final int CHALLENGE_UPDATE_VALUE = 241;
    public static final int CHAT_NOTICE_VALUE = 104;
    public static final int CHICKEN_NOTIFY_VALUE = 249;
    public static final int COLLECTION_POP_TEXT_VALUE = 265;
    public static final int COMMON_ALERT_VALUE = 263;
    public static final int COMMON_SWITCH_VALUE = 266;
    public static final int COMMON_TOAST_VALUE = 230;
    public static final int CONSTELLATION_BASIC_COUNT_VALUE = 285;
    public static final int CONSTELLATION_TEXT_VALUE = 286;
    public static final int CONSTELLATION_TOP_VALUE = 284;
    public static final int CUSTOM_RANK_VALUE = 247;
    public static final int DRAW_GOODS_VALUE = 221;
    public static final int EMPTY_T_VALUE = 0;
    public static final int EVENT_RANK_VALUE = 36;
    public static final int EVENT_VALUE = 123;
    public static final int EXPEDITION_PLANET_DRAW_VALUE = 278;
    public static final int EXPEDITION_PLANET_TEXT_VALUE = 279;
    public static final int FAN_CLUB_LEVEL_VALUE = 173;
    public static final int FIREWORK_VALUE = 38;
    public static final int FIRST_FOLLOW_VALUE = 49;
    public static final int FIRST_LIKE_VALUE = 51;
    public static final int FIRST_SHARE_VALUE = 50;
    public static final int FOLLOW_NOTICE_VALUE = 103;
    public static final int FRIEND_MODE_APPLY_VALUE = 127;
    public static final int FRIEND_MODE_ENTER_VALUE = 132;
    public static final int FRIEND_MODE_LEAVE_VALUE = 133;
    public static final int FRIEND_MODE_VOICE_DOWN_VALUE = 135;
    public static final int FRIEND_MODE_VOICE_UP_VALUE = 134;
    public static final int GIFT_VALUE = 33;
    public static final int GOODS_LUCK_BAG_VALUE = 222;
    public static final int GOODS_SET_ANIMATION_VALUE = 277;
    public static final int GOODS_WALL_ENTRANCE_VALUE = 280;
    public static final int GOODS_WISH_LIST_UPDATE_VALUE = 216;
    public static final int GROUP_PK_INFO_VALUE = 274;
    public static final int GROUP_PK_OPERATE_VALUE = 273;
    public static final int H5_EVENT_BUBBLE_VALUE = 141;
    public static final int H5_EVENT_VALUE = 118;
    public static final int HONGBAO_VALUE = 92;
    public static final int HORN_VALUE = 40;
    public static final int HOUR_RANK_POP_VALUE = 237;
    public static final int HOUR_RANK_VALUE = 228;
    public static final int HTML_NOTICE_VALUE = 250;
    public static final int INVITE_IGNORE_VALUE = 130;
    public static final int JOIN_LIVE_VALUE = 27;
    public static final int KICK_OUT_VALUE = 232;
    public static final int LEAVE_LIVE_VALUE = 28;
    public static final int LEFT_BOTTOM_COMMON_MSG_VALUE = 287;
    public static final int LEVEL_UPDATE_VALUE = 155;
    public static final int LIKE_UPDATE_CURRENT_BEANS_VALUE = 256;
    public static final int LIKE_VALUE = 31;
    public static final int LINE_END_VALUE = 121;
    public static final int LINE_INVITE_VALUE = 119;
    public static final int LINE_REFUSE_VALUE = 122;
    public static final int LINE_START_VALUE = 120;
    public static final int LIVE_ACTIVITY_VALUE = 213;
    public static final int LIVE_CONTENT_NOTICE_CREATE_VALUE = 226;
    public static final int LIVE_CONTENT_NOTICE_DESTROY_VALUE = 227;
    public static final int LIVE_NOTICE_VALUE = 225;
    public static final int LIVE_RED_POINT_VALUE = 258;
    public static final int LIVE_ROOM_TIPS_VALUE = 271;
    public static final int LIVE_ROOM_TOOLS_CHANGE_VALUE = 257;
    public static final int LIVE_TOP_VALUE = 194;
    public static final int LIVE_VIP_VALUE = 281;
    public static final int LOTTERY_EVENT_VALUE = 163;
    public static final int LOVE_CLOSE_VALUE = 191;
    public static final int LOVE_DARK_VALUE = 182;
    public static final int LOVE_ESC_VALUE = 181;
    public static final int LOVE_JOIN_AGREE_VALUE = 186;
    public static final int LOVE_JOIN_DISAGREE_VALUE = 187;
    public static final int LOVE_JOIN_REJECT_VALUE = 192;
    public static final int LOVE_JOIN_SYNC_VALUE = 179;
    public static final int LOVE_LIGHT_VALUE = 184;
    public static final int LOVE_OPEN_VALUE = 190;
    public static final int LOVE_SHOW_VALUE = 185;
    public static final int LOVE_SUCCESS_VALUE = 183;
    public static final int LOVE_UP_VALUE = 180;
    public static final int MALL_ENTRANCE_VALUE = 165;
    public static final int MANAGER_APPOINTMENT_VALUE = 106;
    public static final int MANAGER_CANCEL_VALUE = 107;
    public static final int MEDAL_VALUE = 39;
    public static final int MULTI_PK_END_VALUE = 260;
    public static final int MULTI_PK_EXIT_VALUE = 262;
    public static final int MULTI_PK_MVP_VALUE = 272;
    public static final int MULTI_PK_RANK_VALUE = 261;
    public static final int MULTI_PK_START_VALUE = 259;
    public static final int MUTE_VALUE = 108;
    public static final int NEW_HORN_VALUE = 233;
    public static final int NEW_LINE_INVITE_VALUE = 235;
    public static final int NEW_LINE_UPDATE_VALUE = 234;
    public static final int NOBLE_UPGRADE_VALUE = 267;
    public static final int OFFICIAL_RECOMMEND_VALUE = 211;
    public static final int PK_3_VALUE = 229;
    public static final int PK_BUFF_VALUE = 215;
    public static final int PK_END_VALUE = 116;
    public static final int PK_FINAL_TYPE_VALUE = 231;
    public static final int PK_GIFT_OPPONENT_VALUE = 223;
    public static final int PK_INVITE_VALUE = 114;
    public static final int PK_MACHINES_TOOLS_VALUE = 255;
    public static final int PK_OPERATED_VALUE = 253;
    public static final int PK_SCORE_VALUE = 117;
    public static final int PK_START_VALUE = 115;
    public static final int PK_WIN_STREAK_VALUE = 224;
    public static final int PLAY_LANTERN_UPDATE_VALUE = 270;
    public static final int PLAY_LANTERN_VALUE = 269;
    public static final int PUBLISH_CHAT_BADGE_VALUE = 264;
    public static final int PUBLISH_PK_MACHINES_VALUE = 254;
    public static final int REFUND_VALUE = 94;
    public static final int RESET_WISH_LIST_VALUE = 246;
    public static final int STOP_LIVE_VALUE = 29;
    public static final int SYNC_EXP_VALUE = 154;
    public static final int SYNC_FRONT_AUDIENCE_VALUE = 140;
    public static final int TAG_LOCATION_VALUE = 157;
    public static final int TASK_FINISH_NOTIFY_VALUE = 202;
    public static final int TASK_PROCESS_VALUE = 200;
    public static final int TEXT_VALUE = 1;
    public static final int TOP_TREND_RANK_VALUE = 167;
    public static final int UNMUTE_VALUE = 109;
    public static final int UPDATE_WISH_LIST_VALUE = 220;
    public static final int UPGRADE_RICH_LEVEL_VALUE = 102;
    public static final int USER_INFO_UPGRADE_VALUE = 268;
    public static final int VOICE_STATUS_UPDATE_VALUE = 131;
    public static final int VOICE_UP_IGNORE_VALUE = 129;
    public static final int VOICE_UP_INVITE_VALUE = 128;
    public static final int WARING_VALUE = 34;
    public static final int WINNING_PRIZE_VALUE = 245;
    public static final int WISHING_CONTEST_TEXT_VALUE = 251;
    public static final int WISHING_CONTEST_VALUE = 252;
    public static final int WISHING_DRAW_VALUE = 236;
    private final int value;
    private static final Internal.EnumLiteMap<LiveMsgType> internalValueMap = new Internal.EnumLiteMap<LiveMsgType>() { // from class: cn.irisgw.live.LiveMsgType.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public LiveMsgType findValueByNumber(int i) {
            return LiveMsgType.forNumber(i);
        }
    };
    private static final LiveMsgType[] VALUES = values();

    LiveMsgType(int i) {
        this.value = i;
    }

    public static LiveMsgType forNumber(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 33) {
                    if (i != 34) {
                        if (i != 60) {
                            if (i != 61) {
                                switch (i) {
                                    case 27:
                                        return JOIN_LIVE;
                                    case 28:
                                        return LEAVE_LIVE;
                                    case 29:
                                        return STOP_LIVE;
                                    default:
                                        switch (i) {
                                            case 31:
                                                return LIKE;
                                            case 92:
                                                return HONGBAO;
                                            case 94:
                                                return REFUND;
                                            case 114:
                                                return PK_INVITE;
                                            case 115:
                                                return PK_START;
                                            case 116:
                                                return PK_END;
                                            case 117:
                                                return PK_SCORE;
                                            case 118:
                                                return H5_EVENT;
                                            case 119:
                                                return LINE_INVITE;
                                            case 120:
                                                return LINE_START;
                                            case 121:
                                                return LINE_END;
                                            case 122:
                                                return LINE_REFUSE;
                                            case 123:
                                                return EVENT;
                                            case 140:
                                                return SYNC_FRONT_AUDIENCE;
                                            case 141:
                                                return H5_EVENT_BUBBLE;
                                            case 154:
                                                return SYNC_EXP;
                                            case 155:
                                                return LEVEL_UPDATE;
                                            case 157:
                                                return TAG_LOCATION;
                                            case 163:
                                                return LOTTERY_EVENT;
                                            case 165:
                                                return MALL_ENTRANCE;
                                            case 167:
                                                return TOP_TREND_RANK;
                                            case 173:
                                                return FAN_CLUB_LEVEL;
                                            case 179:
                                                return LOVE_JOIN_SYNC;
                                            case 180:
                                                return LOVE_UP;
                                            case 181:
                                                return LOVE_ESC;
                                            case 182:
                                                return LOVE_DARK;
                                            case 183:
                                                return LOVE_SUCCESS;
                                            case 184:
                                                return LOVE_LIGHT;
                                            case 185:
                                                return LOVE_SHOW;
                                            case 186:
                                                return LOVE_JOIN_AGREE;
                                            case 187:
                                                return LOVE_JOIN_DISAGREE;
                                            case 190:
                                                return LOVE_OPEN;
                                            case 191:
                                                return LOVE_CLOSE;
                                            case 192:
                                                return LOVE_JOIN_REJECT;
                                            case 194:
                                                return LIVE_TOP;
                                            case 200:
                                                return TASK_PROCESS;
                                            case 202:
                                                return TASK_FINISH_NOTIFY;
                                            case 211:
                                                return OFFICIAL_RECOMMEND;
                                            case 213:
                                                return LIVE_ACTIVITY;
                                            case 215:
                                                return PK_BUFF;
                                            case 216:
                                                return GOODS_WISH_LIST_UPDATE;
                                            case 220:
                                                return UPDATE_WISH_LIST;
                                            case 221:
                                                return DRAW_GOODS;
                                            case 222:
                                                return GOODS_LUCK_BAG;
                                            case 223:
                                                return PK_GIFT_OPPONENT;
                                            case 224:
                                                return PK_WIN_STREAK;
                                            case 225:
                                                return LIVE_NOTICE;
                                            case 226:
                                                return LIVE_CONTENT_NOTICE_CREATE;
                                            case 227:
                                                return LIVE_CONTENT_NOTICE_DESTROY;
                                            case 228:
                                                return HOUR_RANK;
                                            case 229:
                                                return PK_3;
                                            case 230:
                                                return COMMON_TOAST;
                                            case 231:
                                                return PK_FINAL_TYPE;
                                            case 232:
                                                return KICK_OUT;
                                            case 233:
                                                return NEW_HORN;
                                            case 234:
                                                return NEW_LINE_UPDATE;
                                            case 235:
                                                return NEW_LINE_INVITE;
                                            case 236:
                                                return WISHING_DRAW;
                                            case 237:
                                                return HOUR_RANK_POP;
                                            case 238:
                                                return CHALLENGE_MATCH;
                                            case 239:
                                                return CHALLENGE_EGG_RESULT;
                                            case 240:
                                                return CHALLENGE_PROP;
                                            case 241:
                                                return CHALLENGE_UPDATE;
                                            case 242:
                                                return CHALLENGE_KILL;
                                            case 243:
                                                return CHALLENGE_END;
                                            case 244:
                                                return CHALLENGE_SYNC;
                                            case 245:
                                                return WINNING_PRIZE;
                                            case 246:
                                                return RESET_WISH_LIST;
                                            case 247:
                                                return CUSTOM_RANK;
                                            case 248:
                                                return ANIMATION;
                                            case 249:
                                                return CHICKEN_NOTIFY;
                                            case 250:
                                                return HTML_NOTICE;
                                            case 251:
                                                return WISHING_CONTEST_TEXT;
                                            case 252:
                                                return WISHING_CONTEST;
                                            case 253:
                                                return PK_OPERATED;
                                            case 254:
                                                return PUBLISH_PK_MACHINES;
                                            case 255:
                                                return PK_MACHINES_TOOLS;
                                            case 256:
                                                return LIKE_UPDATE_CURRENT_BEANS;
                                            case 257:
                                                return LIVE_ROOM_TOOLS_CHANGE;
                                            case 258:
                                                return LIVE_RED_POINT;
                                            case 259:
                                                return MULTI_PK_START;
                                            case 260:
                                                return MULTI_PK_END;
                                            case 261:
                                                return MULTI_PK_RANK;
                                            case 262:
                                                return MULTI_PK_EXIT;
                                            case 263:
                                                return COMMON_ALERT;
                                            case 264:
                                                return PUBLISH_CHAT_BADGE;
                                            case 265:
                                                return COLLECTION_POP_TEXT;
                                            case 266:
                                                return COMMON_SWITCH;
                                            case 267:
                                                return NOBLE_UPGRADE;
                                            case 268:
                                                return USER_INFO_UPGRADE;
                                            case 269:
                                                return PLAY_LANTERN;
                                            case 270:
                                                return PLAY_LANTERN_UPDATE;
                                            case 271:
                                                return LIVE_ROOM_TIPS;
                                            case 272:
                                                return MULTI_PK_MVP;
                                            case 273:
                                                return GROUP_PK_OPERATE;
                                            case 274:
                                                return GROUP_PK_INFO;
                                            case 275:
                                                return BATTLE_PASS_REWARD_NOTIFY;
                                            case 276:
                                                return BLUED_CHAT_CONTENT;
                                            case 277:
                                                return GOODS_SET_ANIMATION;
                                            case 278:
                                                return EXPEDITION_PLANET_DRAW;
                                            case 279:
                                                return EXPEDITION_PLANET_TEXT;
                                            case 280:
                                                return GOODS_WALL_ENTRANCE;
                                            case 281:
                                                return LIVE_VIP;
                                            case 282:
                                                return ADMIN_COMMENT;
                                            case 283:
                                                return Activity_Message;
                                            case 284:
                                                return CONSTELLATION_TOP;
                                            case 285:
                                                return CONSTELLATION_BASIC_COUNT;
                                            case 286:
                                                return CONSTELLATION_TEXT;
                                            case 287:
                                                return LEFT_BOTTOM_COMMON_MSG;
                                            default:
                                                switch (i) {
                                                    case 36:
                                                        return EVENT_RANK;
                                                    case 37:
                                                        return BARRAGE;
                                                    case 38:
                                                        return FIREWORK;
                                                    case 39:
                                                        return MEDAL;
                                                    case 40:
                                                        return HORN;
                                                    default:
                                                        switch (i) {
                                                            case 49:
                                                                return FIRST_FOLLOW;
                                                            case 50:
                                                                return FIRST_SHARE;
                                                            case 51:
                                                                return FIRST_LIKE;
                                                            default:
                                                                switch (i) {
                                                                    case 102:
                                                                        return UPGRADE_RICH_LEVEL;
                                                                    case 103:
                                                                        return FOLLOW_NOTICE;
                                                                    case 104:
                                                                        return CHAT_NOTICE;
                                                                    default:
                                                                        switch (i) {
                                                                            case 106:
                                                                                return MANAGER_APPOINTMENT;
                                                                            case 107:
                                                                                return MANAGER_CANCEL;
                                                                            case 108:
                                                                                return MUTE;
                                                                            case 109:
                                                                                return UNMUTE;
                                                                            default:
                                                                                switch (i) {
                                                                                    case 127:
                                                                                        return FRIEND_MODE_APPLY;
                                                                                    case 128:
                                                                                        return VOICE_UP_INVITE;
                                                                                    case 129:
                                                                                        return VOICE_UP_IGNORE;
                                                                                    case 130:
                                                                                        return INVITE_IGNORE;
                                                                                    case 131:
                                                                                        return VOICE_STATUS_UPDATE;
                                                                                    case 132:
                                                                                        return FRIEND_MODE_ENTER;
                                                                                    case 133:
                                                                                        return FRIEND_MODE_LEAVE;
                                                                                    case 134:
                                                                                        return FRIEND_MODE_VOICE_UP;
                                                                                    case 135:
                                                                                        return FRIEND_MODE_VOICE_DOWN;
                                                                                    default:
                                                                                        return null;
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                            }
                            return BOX_GIFT;
                        }
                        return BOX;
                    }
                    return WARING;
                }
                return GIFT;
            }
            return TEXT;
        }
        return EMPTY_T;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return LiveConstants.getDescriptor().getEnumTypes().get(0);
    }

    public static Internal.EnumLiteMap<LiveMsgType> internalGetValueMap() {
        return internalValueMap;
    }

    @Deprecated
    public static LiveMsgType valueOf(int i) {
        return forNumber(i);
    }

    public static LiveMsgType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() == getDescriptor()) {
            return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
        }
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }

    @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
        if (this != UNRECOGNIZED) {
            return getDescriptor().getValues().get(ordinal());
        }
        throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
    }
}
