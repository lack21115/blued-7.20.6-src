package com.blued.im.audio_chatroom;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioMsgType.class */
public final class AudioMsgType {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012AudioMsgType.proto\u0012\u001bcom.blued.im.audio_chatroom*×\u0011\n\u0007MsgType\u0012\u0014\n\u0010UNKNOWN_MSG_TYPE\u0010��\u0012\b\n\u0004TEXT\u0010\u0001\u0012\r\n\tJOIN_ROOM\u0010\u0002\u0012\r\n\tQUIT_ROOM\u0010\u0003\u0012\u000e\n\nCLOSE_ROOM\u0010\u0004\u0012\r\n\tSEND_GIFT\u0010\u0005\u0012\u000e\n\nALERT_ROOM\u0010\u0006\u0012\u0011\n\rFOLLOW_NOTICE\u0010\u0007\u0012\u000f\n\u000bSET_MANAGER\u0010\b\u0012\u0012\n\u000eCANCLE_MANAGER\u0010\t\u0012\b\n\u0004MUTE\u0010\n\u0012\n\n\u0006UNMUTE\u0010\u000b\u0012\u0012\n\u000eINVITE_UP_SEAT\u0010\f\u0012\u0011\n\rREFUSE_INVITE\u0010\r\u0012\u0013\n\u000fUP_SEAT_SUCCESS\u0010\u000e\u0012\u000e\n\nLEAVE_SEAT\u0010\u000f\u0012\u0017\n\u0013APPLY_UP_SEAT_COUNT\u0010\u0010\u0012\u0014\n\u0010MUTE_SEAT_STATUS\u0010\u0011\u0012\u0015\n\u0011CLOSE_SEAT_STATUS\u0010\u0012\u0012\r\n\tKICK_ROOM\u0010\u0013\u0012\u0015\n\u0011ROOM_NAME_INVALID\u0010\u0014\u0012\u000e\n\nOFFICE_MSG\u0010\u0015\u0012\u0013\n\u000fAUDIT_NAME_PASS\u0010\u0016\u0012\u0013\n\u000fUP_APPLY_REJECT\u0010\u0017\u0012\u0017\n\u0013LATE_UP_SEAT_ACCEPT\u0010\u0018\u0012\u0017\n\u0013LATE_UP_SEAT_REJECT\u0010\u0019\u0012\u0010\n\fANNOUNCEMENT\u0010\u001a\u0012\f\n\bEMOJIMSG\u0010\u001b\u0012\u0010\n\fSOUND_EFFECT\u0010\u001c\u0012\u000e\n\nVOTE_START\u0010\u001d\u0012\f\n\bVOTE_END\u0010\u001e\u0012\u0010\n\fTEXT_NO_NAME\u0010\u001f\u0012\u0014\n\u0010BLIND_DATA_START\u0010 \u0012\u0018\n\u0014BLIND_DATA_INTRODUCE\u0010!\u0012\u0015\n\u0011BLIND_DATA_CHOOSE\u0010\"\u0012\u0015\n\u0011BLIND_DATA_PULISH\u0010#\u0012\u0013\n\u000fBLIND_DATA_OVER\u0010$\u0012\u0014\n\u0010BLIND_DATA_HEART\u0010%\u0012\u0013\n\u000fSTART_VOTE_TIME\u0010&\u0012\u0011\n\rEND_VOTE_TIME\u0010'\u0012\u0010\n\fGIFT_MARQUEE\u0010(\u0012\r\n\tWISH_GIFT\u0010)\u0012\u000f\n\u000bGAME_UPDATE\u0010*\u0012\u0016\n\u0012GAME_ACTIVE_VALUES\u0010+\u0012\u0015\n\u0011UPDATE_USER_SEATS\u0010,\u0012\u0012\n\u000eUPDATE_AUCTION\u0010-\u0012\u0017\n\u0013UPDATE_INTIMACY_VAL\u0010.\u0012\u0014\n\u0010AUCTIONEER_LEVEL\u0010/\u0012\u0016\n\u0012GUEST_AUTO_FEEDING\u00100\u0012\u0018\n\u0014FULLSCREEN_ANIMATION\u00101\u0012\u000f\n\u000bVIP_MARQUEE\u00102\u0012\u0017\n\u0013CHATROOM_BACKGROUND\u00103\u0012\u0010\n\fTHEME_CHANGE\u00104\u0012\u0011\n\rGIFT_ON_WHEAT\u00105\u0012\u0018\n\u0014UNLOCK_COMPANION_MIC\u00106\u0012\u001c\n\u0018UPDATE_AVATAR_FRAME_INFO\u00107\u0012\u0014\n\u0010GIFT_LIST_CHANGE\u00108\u0012\u0013\n\u000fVOICE_CHAT_USER\u00109\u0012\u0017\n\u0013MESSAGE_BUBBLE_INFO\u0010:\u0012\u000f\n\u000bBANTER_INFO\u0010;\u0012\u0018\n\u0014INVALID_LIVE_WARNING\u0010<\u0012\u000b\n\u0007PK_INFO\u0010=\u0012\r\n\tPK_RESULT\u0010>\u0012\r\n\tROOM_INFO\u0010?\u0012\u000b\n\u0007PK_OPPO\u0010@\u0012\u0014\n\u0010PK_PROGRESS_INFO\u0010A\u0012\u000b\n\u0007PK_MICS\u0010B\u0012\u0010\n\fPK_OPPO_USER\u0010C\u0012\u0011\n\rPK_SEATS_INFO\u0010D\u0012\u0012\n\u000eGLOBAL_MESSAGE\u0010E\u0012\u0013\n\u000fKTV_SINGER_INFO\u0010F\u0012\u0012\n\u000eKTV_MUSIC_INFO\u0010G\u0012\u0013\n\u000fKTV_SING_RESULT\u0010H\u0012\u0011\n\rKTV_MUSIC_NUM\u0010I\u0012\u0012\n\u000eKTV_ROOM_RESET\u0010J\u0012\u0011\n\rKTV_ACCOMPANY\u0010K\u0012\r\n\tKTV_GUIDE\u0010L\u0012\u0010\n\fKTV_APPLAUSE\u0010M\u0012\u0019\n\u0015KTV_CHOOSE_SONG_GUIDE\u0010N\u0012\r\n\tKTV_STAGE\u0010O\u0012\u000e\n\nFANS_LEVEL\u0010P\u0012\u000f\n\u000bFANS_STATUS\u0010Q\u0012\u0015\n\u0011FANS_CREATE_GROUP\u0010R\u0012\u0014\n\u0010RANK_ANCHOR_INFO\u0010T\u0012\u000e\n\nBOX_NOTIFY\u0010U\u0012\u0014\n\u0010BOX_BEANS_NOTIFY\u0010V\u0012\u000f\n\u000bKTV_RECEIVE\u0010X\u0012\u0014\n\u0010ANCHOR_PRIVILEGE\u0010Y\u0012\u000f\n\u000bREPORT_INFO\u0010Z\u0012\u0010\n\fPOPOVER_INFO\u0010[\u0012\u0016\n\u0012CHATROOM_MIC_BEANS\u0010\\\u0012\u000e\n\nTOPIC_INFO\u0010]\u0012\n\n\u0006NEW_PK\u0010^\u0012\u0015\n\u0011UPGRADE_PRIVILEGE\u0010_\u0012\u0015\n\u0011ACTIVITY_ENTRANCE\u0010`\u0012\u000f\n\u000bREWARD_RAIN\u0010a\u0012\u0018\n\u0014EXPLORATION_MULTIPLE\u0010b\u0012\u0013\n\u000fPROP_SET_UPDATE\u0010c\u0012\u0012\n\u000eNEW_RED_PACKET\u0010d\u0012\u0011\n\rROB_SING_ROOM\u0010e\u0012\u000e\n\nFIRST_MEET\u0010f\u0012\u000e\n\nCUSTOM_CAR\u0010g\u0012\u0014\n\u0010VEILED_OPEN_UIDS\u0010h\u0012\u0015\n\u0011VEILED_OPEN_GUIDE\u0010i\u0012\u0016\n\u0012INVITE_TO_RELATION\u0010j\u0012\u0016\n\u0012BECOME_TO_RELATION\u0010k\u0012\u0013\n\u000fCUSTOM_ACTIVITY\u0010l\u0012\u0019\n\u0015CUSTOM_ACTIVITY_GOODS\u0010m\u0012\u000b\n\u0007EFFECTS\u0010n\u0012\u0011\n\rTRUE_LOVE_BOX\u0010o\u0012\u0016\n\u0012GOODS_LIGHT_REGION\u0010p\u0012\u000f\n\u000bMULTI_GOODS\u0010q\u0012\u000e\n\nCONFESSION\u0010r\u0012\u001b\n\u0017DOUBLE_AVATAR_BROADCAST\u0010s\u0012\r\n\tBROADCAST\u0010vB\u0010¢\u0002\rAudioChatroomb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioMsgType$MsgType.class */
    public enum MsgType implements ProtocolMessageEnum {
        UNKNOWN_MSG_TYPE(0),
        TEXT(1),
        JOIN_ROOM(2),
        QUIT_ROOM(3),
        CLOSE_ROOM(4),
        SEND_GIFT(5),
        ALERT_ROOM(6),
        FOLLOW_NOTICE(7),
        SET_MANAGER(8),
        CANCLE_MANAGER(9),
        MUTE(10),
        UNMUTE(11),
        INVITE_UP_SEAT(12),
        REFUSE_INVITE(13),
        UP_SEAT_SUCCESS(14),
        LEAVE_SEAT(15),
        APPLY_UP_SEAT_COUNT(16),
        MUTE_SEAT_STATUS(17),
        CLOSE_SEAT_STATUS(18),
        KICK_ROOM(19),
        ROOM_NAME_INVALID(20),
        OFFICE_MSG(21),
        AUDIT_NAME_PASS(22),
        UP_APPLY_REJECT(23),
        LATE_UP_SEAT_ACCEPT(24),
        LATE_UP_SEAT_REJECT(25),
        ANNOUNCEMENT(26),
        EMOJIMSG(27),
        SOUND_EFFECT(28),
        VOTE_START(29),
        VOTE_END(30),
        TEXT_NO_NAME(31),
        BLIND_DATA_START(32),
        BLIND_DATA_INTRODUCE(33),
        BLIND_DATA_CHOOSE(34),
        BLIND_DATA_PULISH(35),
        BLIND_DATA_OVER(36),
        BLIND_DATA_HEART(37),
        START_VOTE_TIME(38),
        END_VOTE_TIME(39),
        GIFT_MARQUEE(40),
        WISH_GIFT(41),
        GAME_UPDATE(42),
        GAME_ACTIVE_VALUES(43),
        UPDATE_USER_SEATS(44),
        UPDATE_AUCTION(45),
        UPDATE_INTIMACY_VAL(46),
        AUCTIONEER_LEVEL(47),
        GUEST_AUTO_FEEDING(48),
        FULLSCREEN_ANIMATION(49),
        VIP_MARQUEE(50),
        CHATROOM_BACKGROUND(51),
        THEME_CHANGE(52),
        GIFT_ON_WHEAT(53),
        UNLOCK_COMPANION_MIC(54),
        UPDATE_AVATAR_FRAME_INFO(55),
        GIFT_LIST_CHANGE(56),
        VOICE_CHAT_USER(57),
        MESSAGE_BUBBLE_INFO(58),
        BANTER_INFO(59),
        INVALID_LIVE_WARNING(60),
        PK_INFO(61),
        PK_RESULT(62),
        ROOM_INFO(63),
        PK_OPPO(64),
        PK_PROGRESS_INFO(65),
        PK_MICS(66),
        PK_OPPO_USER(67),
        PK_SEATS_INFO(68),
        GLOBAL_MESSAGE(69),
        KTV_SINGER_INFO(70),
        KTV_MUSIC_INFO(71),
        KTV_SING_RESULT(72),
        KTV_MUSIC_NUM(73),
        KTV_ROOM_RESET(74),
        KTV_ACCOMPANY(75),
        KTV_GUIDE(76),
        KTV_APPLAUSE(77),
        KTV_CHOOSE_SONG_GUIDE(78),
        KTV_STAGE(79),
        FANS_LEVEL(80),
        FANS_STATUS(81),
        FANS_CREATE_GROUP(82),
        RANK_ANCHOR_INFO(84),
        BOX_NOTIFY(85),
        BOX_BEANS_NOTIFY(86),
        KTV_RECEIVE(88),
        ANCHOR_PRIVILEGE(89),
        REPORT_INFO(90),
        POPOVER_INFO(91),
        CHATROOM_MIC_BEANS(92),
        TOPIC_INFO(93),
        NEW_PK(94),
        UPGRADE_PRIVILEGE(95),
        ACTIVITY_ENTRANCE(96),
        REWARD_RAIN(97),
        EXPLORATION_MULTIPLE(98),
        PROP_SET_UPDATE(99),
        NEW_RED_PACKET(100),
        ROB_SING_ROOM(101),
        FIRST_MEET(102),
        CUSTOM_CAR(103),
        VEILED_OPEN_UIDS(104),
        VEILED_OPEN_GUIDE(105),
        INVITE_TO_RELATION(106),
        BECOME_TO_RELATION(107),
        CUSTOM_ACTIVITY(108),
        CUSTOM_ACTIVITY_GOODS(109),
        EFFECTS(110),
        TRUE_LOVE_BOX(111),
        GOODS_LIGHT_REGION(112),
        MULTI_GOODS(113),
        CONFESSION(114),
        DOUBLE_AVATAR_BROADCAST(115),
        BROADCAST(118),
        UNRECOGNIZED(-1);
        
        public static final int ACTIVITY_ENTRANCE_VALUE = 96;
        public static final int ALERT_ROOM_VALUE = 6;
        public static final int ANCHOR_PRIVILEGE_VALUE = 89;
        public static final int ANNOUNCEMENT_VALUE = 26;
        public static final int APPLY_UP_SEAT_COUNT_VALUE = 16;
        public static final int AUCTIONEER_LEVEL_VALUE = 47;
        public static final int AUDIT_NAME_PASS_VALUE = 22;
        public static final int BANTER_INFO_VALUE = 59;
        public static final int BECOME_TO_RELATION_VALUE = 107;
        public static final int BLIND_DATA_CHOOSE_VALUE = 34;
        public static final int BLIND_DATA_HEART_VALUE = 37;
        public static final int BLIND_DATA_INTRODUCE_VALUE = 33;
        public static final int BLIND_DATA_OVER_VALUE = 36;
        public static final int BLIND_DATA_PULISH_VALUE = 35;
        public static final int BLIND_DATA_START_VALUE = 32;
        public static final int BOX_BEANS_NOTIFY_VALUE = 86;
        public static final int BOX_NOTIFY_VALUE = 85;
        public static final int BROADCAST_VALUE = 118;
        public static final int CANCLE_MANAGER_VALUE = 9;
        public static final int CHATROOM_BACKGROUND_VALUE = 51;
        public static final int CHATROOM_MIC_BEANS_VALUE = 92;
        public static final int CLOSE_ROOM_VALUE = 4;
        public static final int CLOSE_SEAT_STATUS_VALUE = 18;
        public static final int CONFESSION_VALUE = 114;
        public static final int CUSTOM_ACTIVITY_GOODS_VALUE = 109;
        public static final int CUSTOM_ACTIVITY_VALUE = 108;
        public static final int CUSTOM_CAR_VALUE = 103;
        public static final int DOUBLE_AVATAR_BROADCAST_VALUE = 115;
        public static final int EFFECTS_VALUE = 110;
        public static final int EMOJIMSG_VALUE = 27;
        public static final int END_VOTE_TIME_VALUE = 39;
        public static final int EXPLORATION_MULTIPLE_VALUE = 98;
        public static final int FANS_CREATE_GROUP_VALUE = 82;
        public static final int FANS_LEVEL_VALUE = 80;
        public static final int FANS_STATUS_VALUE = 81;
        public static final int FIRST_MEET_VALUE = 102;
        public static final int FOLLOW_NOTICE_VALUE = 7;
        public static final int FULLSCREEN_ANIMATION_VALUE = 49;
        public static final int GAME_ACTIVE_VALUES_VALUE = 43;
        public static final int GAME_UPDATE_VALUE = 42;
        public static final int GIFT_LIST_CHANGE_VALUE = 56;
        public static final int GIFT_MARQUEE_VALUE = 40;
        public static final int GIFT_ON_WHEAT_VALUE = 53;
        public static final int GLOBAL_MESSAGE_VALUE = 69;
        public static final int GOODS_LIGHT_REGION_VALUE = 112;
        public static final int GUEST_AUTO_FEEDING_VALUE = 48;
        public static final int INVALID_LIVE_WARNING_VALUE = 60;
        public static final int INVITE_TO_RELATION_VALUE = 106;
        public static final int INVITE_UP_SEAT_VALUE = 12;
        public static final int JOIN_ROOM_VALUE = 2;
        public static final int KICK_ROOM_VALUE = 19;
        public static final int KTV_ACCOMPANY_VALUE = 75;
        public static final int KTV_APPLAUSE_VALUE = 77;
        public static final int KTV_CHOOSE_SONG_GUIDE_VALUE = 78;
        public static final int KTV_GUIDE_VALUE = 76;
        public static final int KTV_MUSIC_INFO_VALUE = 71;
        public static final int KTV_MUSIC_NUM_VALUE = 73;
        public static final int KTV_RECEIVE_VALUE = 88;
        public static final int KTV_ROOM_RESET_VALUE = 74;
        public static final int KTV_SINGER_INFO_VALUE = 70;
        public static final int KTV_SING_RESULT_VALUE = 72;
        public static final int KTV_STAGE_VALUE = 79;
        public static final int LATE_UP_SEAT_ACCEPT_VALUE = 24;
        public static final int LATE_UP_SEAT_REJECT_VALUE = 25;
        public static final int LEAVE_SEAT_VALUE = 15;
        public static final int MESSAGE_BUBBLE_INFO_VALUE = 58;
        public static final int MULTI_GOODS_VALUE = 113;
        public static final int MUTE_SEAT_STATUS_VALUE = 17;
        public static final int MUTE_VALUE = 10;
        public static final int NEW_PK_VALUE = 94;
        public static final int NEW_RED_PACKET_VALUE = 100;
        public static final int OFFICE_MSG_VALUE = 21;
        public static final int PK_INFO_VALUE = 61;
        public static final int PK_MICS_VALUE = 66;
        public static final int PK_OPPO_USER_VALUE = 67;
        public static final int PK_OPPO_VALUE = 64;
        public static final int PK_PROGRESS_INFO_VALUE = 65;
        public static final int PK_RESULT_VALUE = 62;
        public static final int PK_SEATS_INFO_VALUE = 68;
        public static final int POPOVER_INFO_VALUE = 91;
        public static final int PROP_SET_UPDATE_VALUE = 99;
        public static final int QUIT_ROOM_VALUE = 3;
        public static final int RANK_ANCHOR_INFO_VALUE = 84;
        public static final int REFUSE_INVITE_VALUE = 13;
        public static final int REPORT_INFO_VALUE = 90;
        public static final int REWARD_RAIN_VALUE = 97;
        public static final int ROB_SING_ROOM_VALUE = 101;
        public static final int ROOM_INFO_VALUE = 63;
        public static final int ROOM_NAME_INVALID_VALUE = 20;
        public static final int SEND_GIFT_VALUE = 5;
        public static final int SET_MANAGER_VALUE = 8;
        public static final int SOUND_EFFECT_VALUE = 28;
        public static final int START_VOTE_TIME_VALUE = 38;
        public static final int TEXT_NO_NAME_VALUE = 31;
        public static final int TEXT_VALUE = 1;
        public static final int THEME_CHANGE_VALUE = 52;
        public static final int TOPIC_INFO_VALUE = 93;
        public static final int TRUE_LOVE_BOX_VALUE = 111;
        public static final int UNKNOWN_MSG_TYPE_VALUE = 0;
        public static final int UNLOCK_COMPANION_MIC_VALUE = 54;
        public static final int UNMUTE_VALUE = 11;
        public static final int UPDATE_AUCTION_VALUE = 45;
        public static final int UPDATE_AVATAR_FRAME_INFO_VALUE = 55;
        public static final int UPDATE_INTIMACY_VAL_VALUE = 46;
        public static final int UPDATE_USER_SEATS_VALUE = 44;
        public static final int UPGRADE_PRIVILEGE_VALUE = 95;
        public static final int UP_APPLY_REJECT_VALUE = 23;
        public static final int UP_SEAT_SUCCESS_VALUE = 14;
        public static final int VEILED_OPEN_GUIDE_VALUE = 105;
        public static final int VEILED_OPEN_UIDS_VALUE = 104;
        public static final int VIP_MARQUEE_VALUE = 50;
        public static final int VOICE_CHAT_USER_VALUE = 57;
        public static final int VOTE_END_VALUE = 30;
        public static final int VOTE_START_VALUE = 29;
        public static final int WISH_GIFT_VALUE = 41;
        private final int value;
        private static final Internal.EnumLiteMap<MsgType> internalValueMap = new Internal.EnumLiteMap<MsgType>() { // from class: com.blued.im.audio_chatroom.AudioMsgType.MsgType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public MsgType findValueByNumber(int i) {
                return MsgType.forNumber(i);
            }
        };
        private static final MsgType[] VALUES = values();

        MsgType(int i) {
            this.value = i;
        }

        public static MsgType forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_MSG_TYPE;
                case 1:
                    return TEXT;
                case 2:
                    return JOIN_ROOM;
                case 3:
                    return QUIT_ROOM;
                case 4:
                    return CLOSE_ROOM;
                case 5:
                    return SEND_GIFT;
                case 6:
                    return ALERT_ROOM;
                case 7:
                    return FOLLOW_NOTICE;
                case 8:
                    return SET_MANAGER;
                case 9:
                    return CANCLE_MANAGER;
                case 10:
                    return MUTE;
                case 11:
                    return UNMUTE;
                case 12:
                    return INVITE_UP_SEAT;
                case 13:
                    return REFUSE_INVITE;
                case 14:
                    return UP_SEAT_SUCCESS;
                case 15:
                    return LEAVE_SEAT;
                case 16:
                    return APPLY_UP_SEAT_COUNT;
                case 17:
                    return MUTE_SEAT_STATUS;
                case 18:
                    return CLOSE_SEAT_STATUS;
                case 19:
                    return KICK_ROOM;
                case 20:
                    return ROOM_NAME_INVALID;
                case 21:
                    return OFFICE_MSG;
                case 22:
                    return AUDIT_NAME_PASS;
                case 23:
                    return UP_APPLY_REJECT;
                case 24:
                    return LATE_UP_SEAT_ACCEPT;
                case 25:
                    return LATE_UP_SEAT_REJECT;
                case 26:
                    return ANNOUNCEMENT;
                case 27:
                    return EMOJIMSG;
                case 28:
                    return SOUND_EFFECT;
                case 29:
                    return VOTE_START;
                case 30:
                    return VOTE_END;
                case 31:
                    return TEXT_NO_NAME;
                case 32:
                    return BLIND_DATA_START;
                case 33:
                    return BLIND_DATA_INTRODUCE;
                case 34:
                    return BLIND_DATA_CHOOSE;
                case 35:
                    return BLIND_DATA_PULISH;
                case 36:
                    return BLIND_DATA_OVER;
                case 37:
                    return BLIND_DATA_HEART;
                case 38:
                    return START_VOTE_TIME;
                case 39:
                    return END_VOTE_TIME;
                case 40:
                    return GIFT_MARQUEE;
                case 41:
                    return WISH_GIFT;
                case 42:
                    return GAME_UPDATE;
                case 43:
                    return GAME_ACTIVE_VALUES;
                case 44:
                    return UPDATE_USER_SEATS;
                case 45:
                    return UPDATE_AUCTION;
                case 46:
                    return UPDATE_INTIMACY_VAL;
                case 47:
                    return AUCTIONEER_LEVEL;
                case 48:
                    return GUEST_AUTO_FEEDING;
                case 49:
                    return FULLSCREEN_ANIMATION;
                case 50:
                    return VIP_MARQUEE;
                case 51:
                    return CHATROOM_BACKGROUND;
                case 52:
                    return THEME_CHANGE;
                case 53:
                    return GIFT_ON_WHEAT;
                case 54:
                    return UNLOCK_COMPANION_MIC;
                case 55:
                    return UPDATE_AVATAR_FRAME_INFO;
                case 56:
                    return GIFT_LIST_CHANGE;
                case 57:
                    return VOICE_CHAT_USER;
                case 58:
                    return MESSAGE_BUBBLE_INFO;
                case 59:
                    return BANTER_INFO;
                case 60:
                    return INVALID_LIVE_WARNING;
                case 61:
                    return PK_INFO;
                case 62:
                    return PK_RESULT;
                case 63:
                    return ROOM_INFO;
                case 64:
                    return PK_OPPO;
                case 65:
                    return PK_PROGRESS_INFO;
                case 66:
                    return PK_MICS;
                case 67:
                    return PK_OPPO_USER;
                case 68:
                    return PK_SEATS_INFO;
                case 69:
                    return GLOBAL_MESSAGE;
                case 70:
                    return KTV_SINGER_INFO;
                case 71:
                    return KTV_MUSIC_INFO;
                case 72:
                    return KTV_SING_RESULT;
                case 73:
                    return KTV_MUSIC_NUM;
                case 74:
                    return KTV_ROOM_RESET;
                case 75:
                    return KTV_ACCOMPANY;
                case 76:
                    return KTV_GUIDE;
                case 77:
                    return KTV_APPLAUSE;
                case 78:
                    return KTV_CHOOSE_SONG_GUIDE;
                case 79:
                    return KTV_STAGE;
                case 80:
                    return FANS_LEVEL;
                case 81:
                    return FANS_STATUS;
                case 82:
                    return FANS_CREATE_GROUP;
                case 83:
                case 87:
                case 116:
                case 117:
                default:
                    return null;
                case 84:
                    return RANK_ANCHOR_INFO;
                case 85:
                    return BOX_NOTIFY;
                case 86:
                    return BOX_BEANS_NOTIFY;
                case 88:
                    return KTV_RECEIVE;
                case 89:
                    return ANCHOR_PRIVILEGE;
                case 90:
                    return REPORT_INFO;
                case 91:
                    return POPOVER_INFO;
                case 92:
                    return CHATROOM_MIC_BEANS;
                case 93:
                    return TOPIC_INFO;
                case 94:
                    return NEW_PK;
                case 95:
                    return UPGRADE_PRIVILEGE;
                case 96:
                    return ACTIVITY_ENTRANCE;
                case 97:
                    return REWARD_RAIN;
                case 98:
                    return EXPLORATION_MULTIPLE;
                case 99:
                    return PROP_SET_UPDATE;
                case 100:
                    return NEW_RED_PACKET;
                case 101:
                    return ROB_SING_ROOM;
                case 102:
                    return FIRST_MEET;
                case 103:
                    return CUSTOM_CAR;
                case 104:
                    return VEILED_OPEN_UIDS;
                case 105:
                    return VEILED_OPEN_GUIDE;
                case 106:
                    return INVITE_TO_RELATION;
                case 107:
                    return BECOME_TO_RELATION;
                case 108:
                    return CUSTOM_ACTIVITY;
                case 109:
                    return CUSTOM_ACTIVITY_GOODS;
                case 110:
                    return EFFECTS;
                case 111:
                    return TRUE_LOVE_BOX;
                case 112:
                    return GOODS_LIGHT_REGION;
                case 113:
                    return MULTI_GOODS;
                case 114:
                    return CONFESSION;
                case 115:
                    return DOUBLE_AVATAR_BROADCAST;
                case 118:
                    return BROADCAST;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return AudioMsgType.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<MsgType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static MsgType valueOf(int i) {
            return forNumber(i);
        }

        public static MsgType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    private AudioMsgType() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
