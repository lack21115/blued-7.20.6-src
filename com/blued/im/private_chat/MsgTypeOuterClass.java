package com.blued.im.private_chat;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/MsgTypeOuterClass.class */
public final class MsgTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\rMsgType.proto\u0012\u0019com.blued.im.private_chat*\u0098\u000b\n\u0007MsgType\u0012\u0014\n\u0010UNKNOWN_MSG_TYPE\u0010��\u0012\b\n\u0004TEXT\u0010\u0001\u0012\t\n\u0005IMAGE\u0010\u0002\u0012\t\n\u0005AUDIO\u0010\u0003\u0012\f\n\bLOCATION\u0010\u0004\u0012\t\n\u0005VIDEO\u0010\u0005\u0012\u000f\n\u000bCUSTOM_FACE\u0010\u0006\u0012\u0010\n\fGROUP_INVITE\u0010\t\u0012\u000f\n\u000bGROUP_SHARE\u0010\n\u0012\u000e\n\nBURN_IMAGE\u0010\u0018\u0012\u000e\n\nBURN_VIDEO\u0010\u0019\u0012\u000e\n\nSCREENSHOT\u0010\u001a\u0012\u000e\n\nLIVE_SHARE\u0010 \u0012\u0016\n\u0012LIVE_SHARE_PRIVATE\u0010)\u0012\u0015\n\u0011VIDEOCHAT_CALLING\u00104\u0012\r\n\tEND_AUDIO\u00105\u0012\u001d\n\u0019VIDEOCHAT_SWITCH_TO_AUDIO\u00106\u0012\u0013\n\u000fRETRACT_MESSAGE\u00107\u0012\u0011\n\rPERSION_SHARE\u00108\u0012\r\n\tWEB_SHARE\u00109\u0012\r\n\tGIF_EMOJI\u0010:\u0012\r\n\tCHAT_FEED\u0010C\u0012\r\n\tIMAGETEXT\u0010D\u0012\u000e\n\nHIDENALBUM\u0010I\u0012\u000f\n\u000bUNLOCKAlBUM\u0010J\u0012\u0016\n\u0012PRIVATE_LIVE_SHARE\u0010K\u0012\u000e\n\nVIEW_SHARE\u0010W\u0012\u000e\n\nLINK_SHARE\u0010X\u0012\u000e\n\nPOST_SHARE\u0010Y\u0012\u000e\n\nUSER_SHARE\u0010Z\u0012\u0010\n\fVIP_OTHERPAY\u0010b\u0012\f\n\bVIP_GIVE\u0010c\u0012\u000f\n\u000bEACH_FRIEND\u0010i\u0012\u0014\n\u0010AUDIO_LIVE_SHARE\u0010q\u0012\u000f\n\u000bCHAT_SAY_HI\u0010|\u0012\t\n\u0004GIFT\u0010¤\u0001\u0012\t\n\u0004LIKE\u0010¨\u0001\u0012\u000e\n\tSYSNOTICE\u0010©\u0001\u0012\u0015\n\u0010VOICE_ROOM_SHARE\u0010Ë\u0001\u0012\u0012\n\rHELLO_EMOTION\u0010Í\u0001\u0012\u0010\n\u000bMT_YY_SHARE\u0010Ò\u0001\u0012\u0011\n\fDOODLE_SHARE\u0010Ô\u0001\u0012\u0011\n\fGROUP_NOTICE\u0010Ø\u0001\u0012\u001a\n\u0015GROUP_NOTICE_WITHDRAW\u0010Û\u0001\u0012\u0017\n\u0012GROUP_ANNOUNCEMENT\u0010Ü\u0001\u0012\u001d\n\u0018GROUP_ANNOUNCEMENT_ADMIN\u0010Ý\u0001\u0012\u0015\n\u0010GROUP_EVALUATION\u0010ð\u0001\u0012\u001a\n\u0015ANONYMOUS_FEED_SOURCE\u0010ñ\u0001\u0012 \n\u001bANONYMOUS_FEED_SOURCE_SHARE\u0010ò\u0001\u0012\u000f\n\nHELLO_TEXT\u0010ó\u0001\u0012\u0013\n\u000eACTIVITY_SHARE\u0010ô\u0001\u0012\u0012\n\rRANDOM_DATING\u0010ú\u0001\u0012\u0016\n\u0011RANDOM_DATING_IMG\u0010û\u0001\u0012\u0014\n\u000fUSER_VIRTUAL_HI\u0010\u0080\u0002\u0012\u0012\n\rLIVE_SHARE_V2\u0010\u0081\u0002\u0012\u001a\n\u0015FRIENDS_CIRCLE_PROMPT\u0010\u0086\u0002\u0012\u0018\n\u0013FRIENDS_LIVE_PROMPT\u0010\u0087\u0002\u0012\u001e\n\u0019FRIENDS_AUDIO_LIVE_PROMPT\u0010\u0088\u0002\u0012\u001b\n\u0016FRIENDS_PRIVILEGE_USER\u0010\u008a\u0002\u0012\u001e\n\u0019FRIENDS_PRIVILEGE_USER_HI\u0010\u008b\u0002\u0012\u001b\n\u0016BEST_FRIENDS_CHAT_PUSH\u0010\u008e\u0002\u0012\u0018\n\u0013BEST_FRIENDS_CIRCLE\u0010\u008f\u0002\u0012\u0010\n\u000bINSIDE_PUSH\u0010\u0092\u0002\u0012\u001c\n\u0017EXPOSURE_FRIENDS_CIRCLE\u0010\u0097\u0002\u0012\u0018\n\u0013MATCH_BUSINESS_CARD\u0010\u0099\u0002\u0012\r\n\bMATCH_CG\u0010\u009a\u0002\u0012\u0016\n\u0011MATCH_STATUS_CARD\u0010\u009b\u0002\u0012\u0012\n\rMATCH_NO_CARE\u0010\u009f\u0002\u0012\u001a\n\u0015MATCH_STATUS_CARD_RED\u0010 \u0002\u0012\u001f\n\u001aFAMILY_RELATIONSHIP_UPDATE\u0010¢\u0002B\u000e¢\u0002\u000bPrivateChatb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/MsgTypeOuterClass$MsgType.class */
    public enum MsgType implements ProtocolMessageEnum {
        UNKNOWN_MSG_TYPE(0),
        TEXT(1),
        IMAGE(2),
        AUDIO(3),
        LOCATION(4),
        VIDEO(5),
        CUSTOM_FACE(6),
        GROUP_INVITE(9),
        GROUP_SHARE(10),
        BURN_IMAGE(24),
        BURN_VIDEO(25),
        SCREENSHOT(26),
        LIVE_SHARE(32),
        LIVE_SHARE_PRIVATE(41),
        VIDEOCHAT_CALLING(52),
        END_AUDIO(53),
        VIDEOCHAT_SWITCH_TO_AUDIO(54),
        RETRACT_MESSAGE(55),
        PERSION_SHARE(56),
        WEB_SHARE(57),
        GIF_EMOJI(58),
        CHAT_FEED(67),
        IMAGETEXT(68),
        HIDENALBUM(73),
        UNLOCKAlBUM(74),
        PRIVATE_LIVE_SHARE(75),
        VIEW_SHARE(87),
        LINK_SHARE(88),
        POST_SHARE(89),
        USER_SHARE(90),
        VIP_OTHERPAY(98),
        VIP_GIVE(99),
        EACH_FRIEND(105),
        AUDIO_LIVE_SHARE(113),
        CHAT_SAY_HI(124),
        GIFT(164),
        LIKE(168),
        SYSNOTICE(169),
        VOICE_ROOM_SHARE(203),
        HELLO_EMOTION(205),
        MT_YY_SHARE(210),
        DOODLE_SHARE(212),
        GROUP_NOTICE(216),
        GROUP_NOTICE_WITHDRAW(219),
        GROUP_ANNOUNCEMENT(220),
        GROUP_ANNOUNCEMENT_ADMIN(221),
        GROUP_EVALUATION(240),
        ANONYMOUS_FEED_SOURCE(241),
        ANONYMOUS_FEED_SOURCE_SHARE(242),
        HELLO_TEXT(243),
        ACTIVITY_SHARE(244),
        RANDOM_DATING(250),
        RANDOM_DATING_IMG(251),
        USER_VIRTUAL_HI(256),
        LIVE_SHARE_V2(257),
        FRIENDS_CIRCLE_PROMPT(262),
        FRIENDS_LIVE_PROMPT(263),
        FRIENDS_AUDIO_LIVE_PROMPT(264),
        FRIENDS_PRIVILEGE_USER(266),
        FRIENDS_PRIVILEGE_USER_HI(267),
        BEST_FRIENDS_CHAT_PUSH(270),
        BEST_FRIENDS_CIRCLE(271),
        INSIDE_PUSH(274),
        EXPOSURE_FRIENDS_CIRCLE(279),
        MATCH_BUSINESS_CARD(281),
        MATCH_CG(282),
        MATCH_STATUS_CARD(283),
        MATCH_NO_CARE(287),
        MATCH_STATUS_CARD_RED(288),
        FAMILY_RELATIONSHIP_UPDATE(290),
        UNRECOGNIZED(-1);
        
        public static final int ACTIVITY_SHARE_VALUE = 244;
        public static final int ANONYMOUS_FEED_SOURCE_SHARE_VALUE = 242;
        public static final int ANONYMOUS_FEED_SOURCE_VALUE = 241;
        public static final int AUDIO_LIVE_SHARE_VALUE = 113;
        public static final int AUDIO_VALUE = 3;
        public static final int BEST_FRIENDS_CHAT_PUSH_VALUE = 270;
        public static final int BEST_FRIENDS_CIRCLE_VALUE = 271;
        public static final int BURN_IMAGE_VALUE = 24;
        public static final int BURN_VIDEO_VALUE = 25;
        public static final int CHAT_FEED_VALUE = 67;
        public static final int CHAT_SAY_HI_VALUE = 124;
        public static final int CUSTOM_FACE_VALUE = 6;
        public static final int DOODLE_SHARE_VALUE = 212;
        public static final int EACH_FRIEND_VALUE = 105;
        public static final int END_AUDIO_VALUE = 53;
        public static final int EXPOSURE_FRIENDS_CIRCLE_VALUE = 279;
        public static final int FAMILY_RELATIONSHIP_UPDATE_VALUE = 290;
        public static final int FRIENDS_AUDIO_LIVE_PROMPT_VALUE = 264;
        public static final int FRIENDS_CIRCLE_PROMPT_VALUE = 262;
        public static final int FRIENDS_LIVE_PROMPT_VALUE = 263;
        public static final int FRIENDS_PRIVILEGE_USER_HI_VALUE = 267;
        public static final int FRIENDS_PRIVILEGE_USER_VALUE = 266;
        public static final int GIFT_VALUE = 164;
        public static final int GIF_EMOJI_VALUE = 58;
        public static final int GROUP_ANNOUNCEMENT_ADMIN_VALUE = 221;
        public static final int GROUP_ANNOUNCEMENT_VALUE = 220;
        public static final int GROUP_EVALUATION_VALUE = 240;
        public static final int GROUP_INVITE_VALUE = 9;
        public static final int GROUP_NOTICE_VALUE = 216;
        public static final int GROUP_NOTICE_WITHDRAW_VALUE = 219;
        public static final int GROUP_SHARE_VALUE = 10;
        public static final int HELLO_EMOTION_VALUE = 205;
        public static final int HELLO_TEXT_VALUE = 243;
        public static final int HIDENALBUM_VALUE = 73;
        public static final int IMAGETEXT_VALUE = 68;
        public static final int IMAGE_VALUE = 2;
        public static final int INSIDE_PUSH_VALUE = 274;
        public static final int LIKE_VALUE = 168;
        public static final int LINK_SHARE_VALUE = 88;
        public static final int LIVE_SHARE_PRIVATE_VALUE = 41;
        public static final int LIVE_SHARE_V2_VALUE = 257;
        public static final int LIVE_SHARE_VALUE = 32;
        public static final int LOCATION_VALUE = 4;
        public static final int MATCH_BUSINESS_CARD_VALUE = 281;
        public static final int MATCH_CG_VALUE = 282;
        public static final int MATCH_NO_CARE_VALUE = 287;
        public static final int MATCH_STATUS_CARD_RED_VALUE = 288;
        public static final int MATCH_STATUS_CARD_VALUE = 283;
        public static final int MT_YY_SHARE_VALUE = 210;
        public static final int PERSION_SHARE_VALUE = 56;
        public static final int POST_SHARE_VALUE = 89;
        public static final int PRIVATE_LIVE_SHARE_VALUE = 75;
        public static final int RANDOM_DATING_IMG_VALUE = 251;
        public static final int RANDOM_DATING_VALUE = 250;
        public static final int RETRACT_MESSAGE_VALUE = 55;
        public static final int SCREENSHOT_VALUE = 26;
        public static final int SYSNOTICE_VALUE = 169;
        public static final int TEXT_VALUE = 1;
        public static final int UNKNOWN_MSG_TYPE_VALUE = 0;
        public static final int UNLOCKAlBUM_VALUE = 74;
        public static final int USER_SHARE_VALUE = 90;
        public static final int USER_VIRTUAL_HI_VALUE = 256;
        public static final int VIDEOCHAT_CALLING_VALUE = 52;
        public static final int VIDEOCHAT_SWITCH_TO_AUDIO_VALUE = 54;
        public static final int VIDEO_VALUE = 5;
        public static final int VIEW_SHARE_VALUE = 87;
        public static final int VIP_GIVE_VALUE = 99;
        public static final int VIP_OTHERPAY_VALUE = 98;
        public static final int VOICE_ROOM_SHARE_VALUE = 203;
        public static final int WEB_SHARE_VALUE = 57;
        private final int value;
        private static final Internal.EnumLiteMap<MsgType> internalValueMap = new Internal.EnumLiteMap<MsgType>() { // from class: com.blued.im.private_chat.MsgTypeOuterClass.MsgType.1
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
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    if (i != 6) {
                                        if (i != 9) {
                                            if (i != 10) {
                                                if (i != 67) {
                                                    if (i != 68) {
                                                        if (i != 98) {
                                                            if (i != 99) {
                                                                if (i != 168) {
                                                                    if (i != 169) {
                                                                        switch (i) {
                                                                            case 6:
                                                                                break;
                                                                            case 32:
                                                                                return LIVE_SHARE;
                                                                            case 41:
                                                                                return LIVE_SHARE_PRIVATE;
                                                                            case 105:
                                                                                return EACH_FRIEND;
                                                                            case 113:
                                                                                return AUDIO_LIVE_SHARE;
                                                                            case 124:
                                                                                return CHAT_SAY_HI;
                                                                            case 164:
                                                                                return GIFT;
                                                                            case 203:
                                                                                return VOICE_ROOM_SHARE;
                                                                            case 205:
                                                                                return HELLO_EMOTION;
                                                                            case 210:
                                                                                return MT_YY_SHARE;
                                                                            case 212:
                                                                                return DOODLE_SHARE;
                                                                            case 216:
                                                                                return GROUP_NOTICE;
                                                                            case 240:
                                                                                return GROUP_EVALUATION;
                                                                            case 241:
                                                                                return ANONYMOUS_FEED_SOURCE;
                                                                            case 242:
                                                                                return ANONYMOUS_FEED_SOURCE_SHARE;
                                                                            case 243:
                                                                                return HELLO_TEXT;
                                                                            case 244:
                                                                                return ACTIVITY_SHARE;
                                                                            case 250:
                                                                                return RANDOM_DATING;
                                                                            case 251:
                                                                                return RANDOM_DATING_IMG;
                                                                            case 256:
                                                                                return USER_VIRTUAL_HI;
                                                                            case 257:
                                                                                return LIVE_SHARE_V2;
                                                                            case 262:
                                                                                return FRIENDS_CIRCLE_PROMPT;
                                                                            case 263:
                                                                                return FRIENDS_LIVE_PROMPT;
                                                                            case 264:
                                                                                return FRIENDS_AUDIO_LIVE_PROMPT;
                                                                            case 266:
                                                                                return FRIENDS_PRIVILEGE_USER;
                                                                            case 267:
                                                                                return FRIENDS_PRIVILEGE_USER_HI;
                                                                            case 270:
                                                                                return BEST_FRIENDS_CHAT_PUSH;
                                                                            case 271:
                                                                                return BEST_FRIENDS_CIRCLE;
                                                                            case 274:
                                                                                return INSIDE_PUSH;
                                                                            case 279:
                                                                                return EXPOSURE_FRIENDS_CIRCLE;
                                                                            case 281:
                                                                                return MATCH_BUSINESS_CARD;
                                                                            case 282:
                                                                                return MATCH_CG;
                                                                            case 283:
                                                                                return MATCH_STATUS_CARD;
                                                                            case 287:
                                                                                return MATCH_NO_CARE;
                                                                            case 288:
                                                                                return MATCH_STATUS_CARD_RED;
                                                                            case 290:
                                                                                return FAMILY_RELATIONSHIP_UPDATE;
                                                                            default:
                                                                                switch (i) {
                                                                                    case 24:
                                                                                        return BURN_IMAGE;
                                                                                    case 25:
                                                                                        return BURN_VIDEO;
                                                                                    case 26:
                                                                                        return SCREENSHOT;
                                                                                    default:
                                                                                        switch (i) {
                                                                                            case 52:
                                                                                                return VIDEOCHAT_CALLING;
                                                                                            case 53:
                                                                                                return END_AUDIO;
                                                                                            case 54:
                                                                                                return VIDEOCHAT_SWITCH_TO_AUDIO;
                                                                                            case 55:
                                                                                                return RETRACT_MESSAGE;
                                                                                            case 56:
                                                                                                return PERSION_SHARE;
                                                                                            case 57:
                                                                                                return WEB_SHARE;
                                                                                            case 58:
                                                                                                return GIF_EMOJI;
                                                                                            default:
                                                                                                switch (i) {
                                                                                                    case 73:
                                                                                                        return HIDENALBUM;
                                                                                                    case 74:
                                                                                                        return UNLOCKAlBUM;
                                                                                                    case 75:
                                                                                                        return PRIVATE_LIVE_SHARE;
                                                                                                    default:
                                                                                                        switch (i) {
                                                                                                            case 87:
                                                                                                                return VIEW_SHARE;
                                                                                                            case 88:
                                                                                                                return LINK_SHARE;
                                                                                                            case 89:
                                                                                                                return POST_SHARE;
                                                                                                            case 90:
                                                                                                                return USER_SHARE;
                                                                                                            default:
                                                                                                                switch (i) {
                                                                                                                    case 219:
                                                                                                                        return GROUP_NOTICE_WITHDRAW;
                                                                                                                    case 220:
                                                                                                                        return GROUP_ANNOUNCEMENT;
                                                                                                                    case 221:
                                                                                                                        return GROUP_ANNOUNCEMENT_ADMIN;
                                                                                                                    default:
                                                                                                                        return null;
                                                                                                                }
                                                                                                        }
                                                                                                }
                                                                                        }
                                                                                }
                                                                        }
                                                                    } else {
                                                                        return SYSNOTICE;
                                                                    }
                                                                } else {
                                                                    return LIKE;
                                                                }
                                                            } else {
                                                                return VIP_GIVE;
                                                            }
                                                        } else {
                                                            return VIP_OTHERPAY;
                                                        }
                                                    } else {
                                                        return IMAGETEXT;
                                                    }
                                                } else {
                                                    return CHAT_FEED;
                                                }
                                            } else {
                                                return GROUP_SHARE;
                                            }
                                        } else {
                                            return GROUP_INVITE;
                                        }
                                    }
                                    return CUSTOM_FACE;
                                }
                                return VIDEO;
                            }
                            return LOCATION;
                        }
                        return AUDIO;
                    }
                    return IMAGE;
                }
                return TEXT;
            }
            return UNKNOWN_MSG_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return MsgTypeOuterClass.getDescriptor().getEnumTypes().get(0);
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

    private MsgTypeOuterClass() {
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
