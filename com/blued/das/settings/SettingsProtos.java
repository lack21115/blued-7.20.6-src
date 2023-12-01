package com.blued.das.settings;

import com.google.common.net.HttpHeaders;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/settings/SettingsProtos.class */
public final class SettingsProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014SettingsProtos.proto\u0012\u0016com.blued.das.settings\"\u008b\u0002\n\rSettingsProto\u0012,\n\u0005event\u0018\u0001 \u0001(\u000e2\u001d.com.blued.das.settings.Event\u0012\f\n\u0004name\u0018\u0002 \u0001(\t\u0012\u0010\n\blink_url\u0018\u0003 \u0001(\t\u00127\n\u000bmodule_type\u0018\u0004 \u0001(\u000e2\".com.blued.das.settings.ModuleType\u0012\u0011\n\tbanner_id\u0018\u0005 \u0001(\t\u0012\u000f\n\u0007is_open\u0018\u0006 \u0001(\b\u0012\u000f\n\u0007is_auto\u0018\u0007 \u0001(\b\u0012\u0011\n\tis_shadow\u0018\b \u0001(\b\u0012\u000b\n\u0003num\u0018\t \u0001(\u0005\u0012\u0010\n\bposition\u0018\n \u0001(\u0005\u0012\f\n\u0004from\u0018\u000b \u0001(\u0005*\u0081\u0017\n\u0005Event\u0012\u0011\n\rUNKNOWN_EVENT\u0010��\u0012\u001c\n\u0018CANCEL_ACCOUNT_BTN_CLICK\u0010\u0001\u0012\u0018\n\u0014CHANGE_ACCOUNT_CLICK\u0010\u0002\u0012$\n MINE_VIP_BANNER_COPYWRITING_SHOW\u0010\u0003\u0012%\n!MINE_VIP_BANNER_COPYWRITING_CLICK\u0010\u0004\u0012\u0012\n\u000eMINE_AREA_SHOW\u0010\u0005\u0012\u0012\n\u000eMINE_BTN_CLICK\u0010\u0006\u0012\u0017\n\u0013DARK_MODE_BTN_CLICK\u0010\u0007\u0012\u001d\n\u0019MINE_SETTINGS_ANTI_HARASS\u0010\b\u0012 \n\u001cMINE_VIP_BANNER_CENTER_CLICK\u0010\t\u0012*\n&MINE_SETTINGS_PRIVACY_NO_DISTURB_CLICK\u0010\n\u0012)\n%MINE_SETTINGS_PRIVACY_HIDE_TIME_CLICK\u0010\u000b\u0012-\n)MINE_SETTINGS_PRIVACY_HIDE_DISTANCE_CLICK\u0010\f\u0012+\n'MINE_SETTINGS_PRIVACY_STEALTH_BTN_CLICK\u0010\r\u0012&\n\"MINE_SETTINGS_PRIVACY_ACCESS_CLICK\u0010\u0012\u0012,\n(MINE_SETTINGS_PRIVACY_VIEW_PRIVATE_CLICK\u0010\u0013\u0012*\n&MINE_SETTINGS_COMMON_CHANGE_ICON_CLICK\u0010\u0014\u0012(\n$MINE_SETTINGS_COMMON_CHANGE_BG_CLICK\u0010\u0015\u0012#\n\u001fMINE_EDIT_PERSONALITY_BTN_CLICK\u0010\u0016\u0012\"\n\u001eMINE_EDIT_MORE_PHOTO_BTN_CLICK\u0010\u0017\u0012\u0014\n\u0010WORD_SIZE_CHANGE\u0010\u0018\u0012\u001d\n\u0019MINE_HELP_RENEW_BUY_CLICK\u0010\u0019\u0012\u0013\n\u000fDEEP_LINK_CLICK\u0010\u001a\u0012\u0014\n\u0010APP_NEARBY_CLICK\u0010\u001b\u0012\u0012\n\u000eAPP_LIVE_CLICK\u0010\u001c\u0012\u0012\n\u000eAPP_FIND_CLICK\u0010\u001d\u0012\u0011\n\rAPP_MSG_CLICK\u0010\u001e\u0012\u0010\n\fAPP_ME_CLICK\u0010\u001f\u0012\u0014\n\u0010LOGOUT_BTN_CLICK\u0010 \u0012\u0012\n\u000eUNBOUND_WECHAT\u0010!\u0012\u0010\n\fBOUND_WECHAT\u0010\"\u0012\u0015\n\u0011PATTERN_LOCK_OPEN\u0010#\u0012\u0016\n\u0012PATTERN_LOCK_CLOSE\u0010$\u0012\u0014\n\u0010LOGIN_PROTECTION\u0010%\u0012\u0019\n\u0015VERIFY_PHOTO_UPLOADED\u0010&\u0012\u0018\n\u0014PERSONAL_VERIFY_SHOW\u0010'\u0012\u0017\n\u0013AV_FACE_RESULT_SHOW\u0010(\u0012\u0019\n\u0015AV_IDCARD_RESULT_SHOW\u0010)\u0012\u001d\n\u0019ACCOUNT_LOCK_APPEAL_CLICK\u0010*\u0012\u0016\n\u0012PWD_SETTINGS_CLICK\u0010+\u0012\u001e\n\u001aACCOUNT_PWD_SETTINGS_CLICK\u0010,\u0012\u001a\n\u0016PAY_PWD_SETTINGS_CLICK\u0010-\u0012\u001e\n\u001aGESTURE_PWD_SETTINGS_CLICK\u0010.\u0012\u001b\n\u0017MINE_SETTINGS_MSG_CLICK\u0010/\u0012,\n(MINE_SETTINGS_MSG_LOGIN_SWITCH_BTN_CLICK\u00100\u0012+\n'MINE_SETTINGS_MSG_USED_SWITCH_BTN_CLICK\u00101\u0012\u0017\n\u0013MINE_NICKNAME_CLICK\u00102\u0012\u001b\n\u0017MINE_EDIT_PROFILE_CLICK\u00103\u0012\u001c\n\u0018MINE_TOP_BAR_PHOTO_CLICK\u00104\u0012\u0017\n\u0013MINE_INTERACT_CLICK\u00105\u0012\u0015\n\u0011MINE_VISITE_CLICK\u00106\u0012\u0013\n\u000fMINE_FEED_CLICK\u00107\u0012\u001c\n\u0018MINE_BACKUP_RECORD_CLICK\u00109\u0012#\n\u001fMINE_BACKUP_RECORD_CANCEL_CLICK\u0010:\u0012%\n!MINE_BACKUP_RECORD_CONTINUE_CLICK\u0010;\u0012$\n MINE_BACKUP_RECORD_EXIT_POP_SHOW\u0010<\u0012*\n&MINE_BACKUP_RECORD_EXIT_POP_BACK_CLICK\u0010=\u0012*\n&MINE_BACKUP_RECORD_EXIT_POP_EXIT_CLICK\u0010>\u0012\u001e\n\u001aMINE_BACKUP_RECORD_SUCCESS\u0010?\u0012\u001b\n\u0017MINE_BACKUP_RECORD_FAIL\u0010@\u0012\u001e\n\u001aMINE_RECOVERY_RECORD_CLICK\u0010A\u0012%\n!MINE_RECOVERY_RECORD_CANCEL_CLICK\u0010B\u0012'\n#MINE_RECOVERY_RECORD_CONTINUE_CLICK\u0010C\u0012&\n\"MINE_RECOVERY_RECORD_EXIT_POP_SHOW\u0010D\u0012,\n(MINE_RECOVERY_RECORD_EXIT_POP_BACK_CLICK\u0010E\u0012,\n(MINE_RECOVERY_RECORD_EXIT_POP_EXIT_CLICK\u0010F\u0012 \n\u001cMINE_RECOVERY_RECORD_SUCCESS\u0010G\u0012\u001d\n\u0019MINE_RECOVERY_RECORD_FAIL\u0010H\u0012\u001c\n\u0018MINE_DELETE_RECORD_CLICK\u0010I\u0012#\n\u001fMINE_DELETE_RECORD_CANCEL_CLICK\u0010J\u0012!\n\u001dMINE_DELETE_RECORD_TRUE_CLICK\u0010K\u0012\u001e\n\u001aMINE_DELETE_RECORD_SUCCESS\u0010L\u0012\u001b\n\u0017MINE_DELETE_RECORD_FAIL\u0010M\u0012\u001c\n\u0018MINE_SETTINGS_LIVE_CLICK\u0010N\u0012!\n\u001dMINE_SETTINGS_LIVE_BACK_CLICK\u0010O\u0012#\n\u001fMINE_SETTINGS_LIVE_WINDOW_CLICK\u0010P\u0012&\n\"MINE_SETTINGS_LIVE_LIST_HIDE_CLICK\u0010Q\u0012'\n#MINE_SETTINGS_LIVE_ENTER_HIDE_CLICK\u0010R\u0012(\n$MINE_SETTINGS_LIVE_GIFT_EFFECT_CLICK\u0010S\u0012'\n#MINE_SETTINGS_LIVE_GIFT_SHOCK_CLICK\u0010T\u0012+\n'MINE_SETTINGS_PRIVACY_GO_SETTINGS_CLICK\u0010U\u0012\u001a\n\u0016PASSWORD_SET_PAGE_SHOW\u0010V\u0012\u0018\n\u0014PASSWORD_SET_SUCCESS\u0010W\u0012$\n UNDER_AGE_UNABLE_LOGIN_PAGE_SHOW\u0010X\u0012\u001c\n\u0018UNDER_AGE_AUTH_BTN_CLICK\u0010Y\u0012\u001c\n\u0018UNDER_AGE_FACE_BTN_CLICK\u0010Z\u0012\u001f\n\u001bUNDER_AGE_AUTH_SUCCESS_SHOW\u0010[\u0012\u001e\n\u001aLITE_MINE_CALL_ENTER_CLICK\u0010\\\u0012\u0016\n\u0012MINE_RESOURCE_SHOW\u0010]\u0012\u0017\n\u0013MINE_RESOURCE_CLICK\u0010^\u0012\u0013\n\u000fMINE_GROUP_SHOW\u0010_\u0012\u0014\n\u0010MINE_GROUP_CLICK\u0010`\u0012\u0012\n\u000eMINE_PAGE_SHOW\u0010a*³\u0001\n\nModuleType\u0012\u0017\n\u0013UNKNOWN_MODULE_TYPE\u0010��\u0012\u0011\n\rAGENCY_BANNER\u0010\u0001\u0012\n\n\u0006HEALTH\u0010\u0002\u0012\u000f\n\u000bHEER_BANNER\u0010\u0003\u0012\r\n\tSETTYINGS\u0010\u0004\u0012\u000f\n\u000bCOMMON_USER\u0010\u0005\u0012\f\n\bVIP_USER\u0010\u0006\u0012\r\n\tSVIP_USER\u0010\u0007\u0012\u000e\n\nEXPIRE_VIP\u0010\b\u0012\u000f\n\u000bEXPIRE_SVIP\u0010\tB\u000b¢\u0002\bSETTINGSb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_blued_das_settings_SettingsProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_settings_SettingsProto_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/settings/SettingsProtos$Event.class */
    public enum Event implements ProtocolMessageEnum {
        UNKNOWN_EVENT(0),
        CANCEL_ACCOUNT_BTN_CLICK(1),
        CHANGE_ACCOUNT_CLICK(2),
        MINE_VIP_BANNER_COPYWRITING_SHOW(3),
        MINE_VIP_BANNER_COPYWRITING_CLICK(4),
        MINE_AREA_SHOW(5),
        MINE_BTN_CLICK(6),
        DARK_MODE_BTN_CLICK(7),
        MINE_SETTINGS_ANTI_HARASS(8),
        MINE_VIP_BANNER_CENTER_CLICK(9),
        MINE_SETTINGS_PRIVACY_NO_DISTURB_CLICK(10),
        MINE_SETTINGS_PRIVACY_HIDE_TIME_CLICK(11),
        MINE_SETTINGS_PRIVACY_HIDE_DISTANCE_CLICK(12),
        MINE_SETTINGS_PRIVACY_STEALTH_BTN_CLICK(13),
        MINE_SETTINGS_PRIVACY_ACCESS_CLICK(18),
        MINE_SETTINGS_PRIVACY_VIEW_PRIVATE_CLICK(19),
        MINE_SETTINGS_COMMON_CHANGE_ICON_CLICK(20),
        MINE_SETTINGS_COMMON_CHANGE_BG_CLICK(21),
        MINE_EDIT_PERSONALITY_BTN_CLICK(22),
        MINE_EDIT_MORE_PHOTO_BTN_CLICK(23),
        WORD_SIZE_CHANGE(24),
        MINE_HELP_RENEW_BUY_CLICK(25),
        DEEP_LINK_CLICK(26),
        APP_NEARBY_CLICK(27),
        APP_LIVE_CLICK(28),
        APP_FIND_CLICK(29),
        APP_MSG_CLICK(30),
        APP_ME_CLICK(31),
        LOGOUT_BTN_CLICK(32),
        UNBOUND_WECHAT(33),
        BOUND_WECHAT(34),
        PATTERN_LOCK_OPEN(35),
        PATTERN_LOCK_CLOSE(36),
        LOGIN_PROTECTION(37),
        VERIFY_PHOTO_UPLOADED(38),
        PERSONAL_VERIFY_SHOW(39),
        AV_FACE_RESULT_SHOW(40),
        AV_IDCARD_RESULT_SHOW(41),
        ACCOUNT_LOCK_APPEAL_CLICK(42),
        PWD_SETTINGS_CLICK(43),
        ACCOUNT_PWD_SETTINGS_CLICK(44),
        PAY_PWD_SETTINGS_CLICK(45),
        GESTURE_PWD_SETTINGS_CLICK(46),
        MINE_SETTINGS_MSG_CLICK(47),
        MINE_SETTINGS_MSG_LOGIN_SWITCH_BTN_CLICK(48),
        MINE_SETTINGS_MSG_USED_SWITCH_BTN_CLICK(49),
        MINE_NICKNAME_CLICK(50),
        MINE_EDIT_PROFILE_CLICK(51),
        MINE_TOP_BAR_PHOTO_CLICK(52),
        MINE_INTERACT_CLICK(53),
        MINE_VISITE_CLICK(54),
        MINE_FEED_CLICK(55),
        MINE_BACKUP_RECORD_CLICK(57),
        MINE_BACKUP_RECORD_CANCEL_CLICK(58),
        MINE_BACKUP_RECORD_CONTINUE_CLICK(59),
        MINE_BACKUP_RECORD_EXIT_POP_SHOW(60),
        MINE_BACKUP_RECORD_EXIT_POP_BACK_CLICK(61),
        MINE_BACKUP_RECORD_EXIT_POP_EXIT_CLICK(62),
        MINE_BACKUP_RECORD_SUCCESS(63),
        MINE_BACKUP_RECORD_FAIL(64),
        MINE_RECOVERY_RECORD_CLICK(65),
        MINE_RECOVERY_RECORD_CANCEL_CLICK(66),
        MINE_RECOVERY_RECORD_CONTINUE_CLICK(67),
        MINE_RECOVERY_RECORD_EXIT_POP_SHOW(68),
        MINE_RECOVERY_RECORD_EXIT_POP_BACK_CLICK(69),
        MINE_RECOVERY_RECORD_EXIT_POP_EXIT_CLICK(70),
        MINE_RECOVERY_RECORD_SUCCESS(71),
        MINE_RECOVERY_RECORD_FAIL(72),
        MINE_DELETE_RECORD_CLICK(73),
        MINE_DELETE_RECORD_CANCEL_CLICK(74),
        MINE_DELETE_RECORD_TRUE_CLICK(75),
        MINE_DELETE_RECORD_SUCCESS(76),
        MINE_DELETE_RECORD_FAIL(77),
        MINE_SETTINGS_LIVE_CLICK(78),
        MINE_SETTINGS_LIVE_BACK_CLICK(79),
        MINE_SETTINGS_LIVE_WINDOW_CLICK(80),
        MINE_SETTINGS_LIVE_LIST_HIDE_CLICK(81),
        MINE_SETTINGS_LIVE_ENTER_HIDE_CLICK(82),
        MINE_SETTINGS_LIVE_GIFT_EFFECT_CLICK(83),
        MINE_SETTINGS_LIVE_GIFT_SHOCK_CLICK(84),
        MINE_SETTINGS_PRIVACY_GO_SETTINGS_CLICK(85),
        PASSWORD_SET_PAGE_SHOW(86),
        PASSWORD_SET_SUCCESS(87),
        UNDER_AGE_UNABLE_LOGIN_PAGE_SHOW(88),
        UNDER_AGE_AUTH_BTN_CLICK(89),
        UNDER_AGE_FACE_BTN_CLICK(90),
        UNDER_AGE_AUTH_SUCCESS_SHOW(91),
        LITE_MINE_CALL_ENTER_CLICK(92),
        MINE_RESOURCE_SHOW(93),
        MINE_RESOURCE_CLICK(94),
        MINE_GROUP_SHOW(95),
        MINE_GROUP_CLICK(96),
        MINE_PAGE_SHOW(97),
        UNRECOGNIZED(-1);
        
        public static final int ACCOUNT_LOCK_APPEAL_CLICK_VALUE = 42;
        public static final int ACCOUNT_PWD_SETTINGS_CLICK_VALUE = 44;
        public static final int APP_FIND_CLICK_VALUE = 29;
        public static final int APP_LIVE_CLICK_VALUE = 28;
        public static final int APP_ME_CLICK_VALUE = 31;
        public static final int APP_MSG_CLICK_VALUE = 30;
        public static final int APP_NEARBY_CLICK_VALUE = 27;
        public static final int AV_FACE_RESULT_SHOW_VALUE = 40;
        public static final int AV_IDCARD_RESULT_SHOW_VALUE = 41;
        public static final int BOUND_WECHAT_VALUE = 34;
        public static final int CANCEL_ACCOUNT_BTN_CLICK_VALUE = 1;
        public static final int CHANGE_ACCOUNT_CLICK_VALUE = 2;
        public static final int DARK_MODE_BTN_CLICK_VALUE = 7;
        public static final int DEEP_LINK_CLICK_VALUE = 26;
        public static final int GESTURE_PWD_SETTINGS_CLICK_VALUE = 46;
        public static final int LITE_MINE_CALL_ENTER_CLICK_VALUE = 92;
        public static final int LOGIN_PROTECTION_VALUE = 37;
        public static final int LOGOUT_BTN_CLICK_VALUE = 32;
        public static final int MINE_AREA_SHOW_VALUE = 5;
        public static final int MINE_BACKUP_RECORD_CANCEL_CLICK_VALUE = 58;
        public static final int MINE_BACKUP_RECORD_CLICK_VALUE = 57;
        public static final int MINE_BACKUP_RECORD_CONTINUE_CLICK_VALUE = 59;
        public static final int MINE_BACKUP_RECORD_EXIT_POP_BACK_CLICK_VALUE = 61;
        public static final int MINE_BACKUP_RECORD_EXIT_POP_EXIT_CLICK_VALUE = 62;
        public static final int MINE_BACKUP_RECORD_EXIT_POP_SHOW_VALUE = 60;
        public static final int MINE_BACKUP_RECORD_FAIL_VALUE = 64;
        public static final int MINE_BACKUP_RECORD_SUCCESS_VALUE = 63;
        public static final int MINE_BTN_CLICK_VALUE = 6;
        public static final int MINE_DELETE_RECORD_CANCEL_CLICK_VALUE = 74;
        public static final int MINE_DELETE_RECORD_CLICK_VALUE = 73;
        public static final int MINE_DELETE_RECORD_FAIL_VALUE = 77;
        public static final int MINE_DELETE_RECORD_SUCCESS_VALUE = 76;
        public static final int MINE_DELETE_RECORD_TRUE_CLICK_VALUE = 75;
        public static final int MINE_EDIT_MORE_PHOTO_BTN_CLICK_VALUE = 23;
        public static final int MINE_EDIT_PERSONALITY_BTN_CLICK_VALUE = 22;
        public static final int MINE_EDIT_PROFILE_CLICK_VALUE = 51;
        public static final int MINE_FEED_CLICK_VALUE = 55;
        public static final int MINE_GROUP_CLICK_VALUE = 96;
        public static final int MINE_GROUP_SHOW_VALUE = 95;
        public static final int MINE_HELP_RENEW_BUY_CLICK_VALUE = 25;
        public static final int MINE_INTERACT_CLICK_VALUE = 53;
        public static final int MINE_NICKNAME_CLICK_VALUE = 50;
        public static final int MINE_PAGE_SHOW_VALUE = 97;
        public static final int MINE_RECOVERY_RECORD_CANCEL_CLICK_VALUE = 66;
        public static final int MINE_RECOVERY_RECORD_CLICK_VALUE = 65;
        public static final int MINE_RECOVERY_RECORD_CONTINUE_CLICK_VALUE = 67;
        public static final int MINE_RECOVERY_RECORD_EXIT_POP_BACK_CLICK_VALUE = 69;
        public static final int MINE_RECOVERY_RECORD_EXIT_POP_EXIT_CLICK_VALUE = 70;
        public static final int MINE_RECOVERY_RECORD_EXIT_POP_SHOW_VALUE = 68;
        public static final int MINE_RECOVERY_RECORD_FAIL_VALUE = 72;
        public static final int MINE_RECOVERY_RECORD_SUCCESS_VALUE = 71;
        public static final int MINE_RESOURCE_CLICK_VALUE = 94;
        public static final int MINE_RESOURCE_SHOW_VALUE = 93;
        public static final int MINE_SETTINGS_ANTI_HARASS_VALUE = 8;
        public static final int MINE_SETTINGS_COMMON_CHANGE_BG_CLICK_VALUE = 21;
        public static final int MINE_SETTINGS_COMMON_CHANGE_ICON_CLICK_VALUE = 20;
        public static final int MINE_SETTINGS_LIVE_BACK_CLICK_VALUE = 79;
        public static final int MINE_SETTINGS_LIVE_CLICK_VALUE = 78;
        public static final int MINE_SETTINGS_LIVE_ENTER_HIDE_CLICK_VALUE = 82;
        public static final int MINE_SETTINGS_LIVE_GIFT_EFFECT_CLICK_VALUE = 83;
        public static final int MINE_SETTINGS_LIVE_GIFT_SHOCK_CLICK_VALUE = 84;
        public static final int MINE_SETTINGS_LIVE_LIST_HIDE_CLICK_VALUE = 81;
        public static final int MINE_SETTINGS_LIVE_WINDOW_CLICK_VALUE = 80;
        public static final int MINE_SETTINGS_MSG_CLICK_VALUE = 47;
        public static final int MINE_SETTINGS_MSG_LOGIN_SWITCH_BTN_CLICK_VALUE = 48;
        public static final int MINE_SETTINGS_MSG_USED_SWITCH_BTN_CLICK_VALUE = 49;
        public static final int MINE_SETTINGS_PRIVACY_ACCESS_CLICK_VALUE = 18;
        public static final int MINE_SETTINGS_PRIVACY_GO_SETTINGS_CLICK_VALUE = 85;
        public static final int MINE_SETTINGS_PRIVACY_HIDE_DISTANCE_CLICK_VALUE = 12;
        public static final int MINE_SETTINGS_PRIVACY_HIDE_TIME_CLICK_VALUE = 11;
        public static final int MINE_SETTINGS_PRIVACY_NO_DISTURB_CLICK_VALUE = 10;
        public static final int MINE_SETTINGS_PRIVACY_STEALTH_BTN_CLICK_VALUE = 13;
        public static final int MINE_SETTINGS_PRIVACY_VIEW_PRIVATE_CLICK_VALUE = 19;
        public static final int MINE_TOP_BAR_PHOTO_CLICK_VALUE = 52;
        public static final int MINE_VIP_BANNER_CENTER_CLICK_VALUE = 9;
        public static final int MINE_VIP_BANNER_COPYWRITING_CLICK_VALUE = 4;
        public static final int MINE_VIP_BANNER_COPYWRITING_SHOW_VALUE = 3;
        public static final int MINE_VISITE_CLICK_VALUE = 54;
        public static final int PASSWORD_SET_PAGE_SHOW_VALUE = 86;
        public static final int PASSWORD_SET_SUCCESS_VALUE = 87;
        public static final int PATTERN_LOCK_CLOSE_VALUE = 36;
        public static final int PATTERN_LOCK_OPEN_VALUE = 35;
        public static final int PAY_PWD_SETTINGS_CLICK_VALUE = 45;
        public static final int PERSONAL_VERIFY_SHOW_VALUE = 39;
        public static final int PWD_SETTINGS_CLICK_VALUE = 43;
        public static final int UNBOUND_WECHAT_VALUE = 33;
        public static final int UNDER_AGE_AUTH_BTN_CLICK_VALUE = 89;
        public static final int UNDER_AGE_AUTH_SUCCESS_SHOW_VALUE = 91;
        public static final int UNDER_AGE_FACE_BTN_CLICK_VALUE = 90;
        public static final int UNDER_AGE_UNABLE_LOGIN_PAGE_SHOW_VALUE = 88;
        public static final int UNKNOWN_EVENT_VALUE = 0;
        public static final int VERIFY_PHOTO_UPLOADED_VALUE = 38;
        public static final int WORD_SIZE_CHANGE_VALUE = 24;
        private final int value;
        private static final Internal.EnumLiteMap<Event> internalValueMap = new Internal.EnumLiteMap<Event>() { // from class: com.blued.das.settings.SettingsProtos.Event.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Event findValueByNumber(int i) {
                return Event.forNumber(i);
            }
        };
        private static final Event[] VALUES = values();

        Event(int i) {
            this.value = i;
        }

        public static Event forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_EVENT;
                case 1:
                    return CANCEL_ACCOUNT_BTN_CLICK;
                case 2:
                    return CHANGE_ACCOUNT_CLICK;
                case 3:
                    return MINE_VIP_BANNER_COPYWRITING_SHOW;
                case 4:
                    return MINE_VIP_BANNER_COPYWRITING_CLICK;
                case 5:
                    return MINE_AREA_SHOW;
                case 6:
                    return MINE_BTN_CLICK;
                case 7:
                    return DARK_MODE_BTN_CLICK;
                case 8:
                    return MINE_SETTINGS_ANTI_HARASS;
                case 9:
                    return MINE_VIP_BANNER_CENTER_CLICK;
                case 10:
                    return MINE_SETTINGS_PRIVACY_NO_DISTURB_CLICK;
                case 11:
                    return MINE_SETTINGS_PRIVACY_HIDE_TIME_CLICK;
                case 12:
                    return MINE_SETTINGS_PRIVACY_HIDE_DISTANCE_CLICK;
                case 13:
                    return MINE_SETTINGS_PRIVACY_STEALTH_BTN_CLICK;
                case 14:
                case 15:
                case 16:
                case 17:
                case 56:
                default:
                    return null;
                case 18:
                    return MINE_SETTINGS_PRIVACY_ACCESS_CLICK;
                case 19:
                    return MINE_SETTINGS_PRIVACY_VIEW_PRIVATE_CLICK;
                case 20:
                    return MINE_SETTINGS_COMMON_CHANGE_ICON_CLICK;
                case 21:
                    return MINE_SETTINGS_COMMON_CHANGE_BG_CLICK;
                case 22:
                    return MINE_EDIT_PERSONALITY_BTN_CLICK;
                case 23:
                    return MINE_EDIT_MORE_PHOTO_BTN_CLICK;
                case 24:
                    return WORD_SIZE_CHANGE;
                case 25:
                    return MINE_HELP_RENEW_BUY_CLICK;
                case 26:
                    return DEEP_LINK_CLICK;
                case 27:
                    return APP_NEARBY_CLICK;
                case 28:
                    return APP_LIVE_CLICK;
                case 29:
                    return APP_FIND_CLICK;
                case 30:
                    return APP_MSG_CLICK;
                case 31:
                    return APP_ME_CLICK;
                case 32:
                    return LOGOUT_BTN_CLICK;
                case 33:
                    return UNBOUND_WECHAT;
                case 34:
                    return BOUND_WECHAT;
                case 35:
                    return PATTERN_LOCK_OPEN;
                case 36:
                    return PATTERN_LOCK_CLOSE;
                case 37:
                    return LOGIN_PROTECTION;
                case 38:
                    return VERIFY_PHOTO_UPLOADED;
                case 39:
                    return PERSONAL_VERIFY_SHOW;
                case 40:
                    return AV_FACE_RESULT_SHOW;
                case 41:
                    return AV_IDCARD_RESULT_SHOW;
                case 42:
                    return ACCOUNT_LOCK_APPEAL_CLICK;
                case 43:
                    return PWD_SETTINGS_CLICK;
                case 44:
                    return ACCOUNT_PWD_SETTINGS_CLICK;
                case 45:
                    return PAY_PWD_SETTINGS_CLICK;
                case 46:
                    return GESTURE_PWD_SETTINGS_CLICK;
                case 47:
                    return MINE_SETTINGS_MSG_CLICK;
                case 48:
                    return MINE_SETTINGS_MSG_LOGIN_SWITCH_BTN_CLICK;
                case 49:
                    return MINE_SETTINGS_MSG_USED_SWITCH_BTN_CLICK;
                case 50:
                    return MINE_NICKNAME_CLICK;
                case 51:
                    return MINE_EDIT_PROFILE_CLICK;
                case 52:
                    return MINE_TOP_BAR_PHOTO_CLICK;
                case 53:
                    return MINE_INTERACT_CLICK;
                case 54:
                    return MINE_VISITE_CLICK;
                case 55:
                    return MINE_FEED_CLICK;
                case 57:
                    return MINE_BACKUP_RECORD_CLICK;
                case 58:
                    return MINE_BACKUP_RECORD_CANCEL_CLICK;
                case 59:
                    return MINE_BACKUP_RECORD_CONTINUE_CLICK;
                case 60:
                    return MINE_BACKUP_RECORD_EXIT_POP_SHOW;
                case 61:
                    return MINE_BACKUP_RECORD_EXIT_POP_BACK_CLICK;
                case 62:
                    return MINE_BACKUP_RECORD_EXIT_POP_EXIT_CLICK;
                case 63:
                    return MINE_BACKUP_RECORD_SUCCESS;
                case 64:
                    return MINE_BACKUP_RECORD_FAIL;
                case 65:
                    return MINE_RECOVERY_RECORD_CLICK;
                case 66:
                    return MINE_RECOVERY_RECORD_CANCEL_CLICK;
                case 67:
                    return MINE_RECOVERY_RECORD_CONTINUE_CLICK;
                case 68:
                    return MINE_RECOVERY_RECORD_EXIT_POP_SHOW;
                case 69:
                    return MINE_RECOVERY_RECORD_EXIT_POP_BACK_CLICK;
                case 70:
                    return MINE_RECOVERY_RECORD_EXIT_POP_EXIT_CLICK;
                case 71:
                    return MINE_RECOVERY_RECORD_SUCCESS;
                case 72:
                    return MINE_RECOVERY_RECORD_FAIL;
                case 73:
                    return MINE_DELETE_RECORD_CLICK;
                case 74:
                    return MINE_DELETE_RECORD_CANCEL_CLICK;
                case 75:
                    return MINE_DELETE_RECORD_TRUE_CLICK;
                case 76:
                    return MINE_DELETE_RECORD_SUCCESS;
                case 77:
                    return MINE_DELETE_RECORD_FAIL;
                case 78:
                    return MINE_SETTINGS_LIVE_CLICK;
                case 79:
                    return MINE_SETTINGS_LIVE_BACK_CLICK;
                case 80:
                    return MINE_SETTINGS_LIVE_WINDOW_CLICK;
                case 81:
                    return MINE_SETTINGS_LIVE_LIST_HIDE_CLICK;
                case 82:
                    return MINE_SETTINGS_LIVE_ENTER_HIDE_CLICK;
                case 83:
                    return MINE_SETTINGS_LIVE_GIFT_EFFECT_CLICK;
                case 84:
                    return MINE_SETTINGS_LIVE_GIFT_SHOCK_CLICK;
                case 85:
                    return MINE_SETTINGS_PRIVACY_GO_SETTINGS_CLICK;
                case 86:
                    return PASSWORD_SET_PAGE_SHOW;
                case 87:
                    return PASSWORD_SET_SUCCESS;
                case 88:
                    return UNDER_AGE_UNABLE_LOGIN_PAGE_SHOW;
                case 89:
                    return UNDER_AGE_AUTH_BTN_CLICK;
                case 90:
                    return UNDER_AGE_FACE_BTN_CLICK;
                case 91:
                    return UNDER_AGE_AUTH_SUCCESS_SHOW;
                case 92:
                    return LITE_MINE_CALL_ENTER_CLICK;
                case 93:
                    return MINE_RESOURCE_SHOW;
                case 94:
                    return MINE_RESOURCE_CLICK;
                case 95:
                    return MINE_GROUP_SHOW;
                case 96:
                    return MINE_GROUP_CLICK;
                case 97:
                    return MINE_PAGE_SHOW;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return SettingsProtos.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<Event> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Event valueOf(int i) {
            return forNumber(i);
        }

        public static Event valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/settings/SettingsProtos$ModuleType.class */
    public enum ModuleType implements ProtocolMessageEnum {
        UNKNOWN_MODULE_TYPE(0),
        AGENCY_BANNER(1),
        HEALTH(2),
        HEER_BANNER(3),
        SETTYINGS(4),
        COMMON_USER(5),
        VIP_USER(6),
        SVIP_USER(7),
        EXPIRE_VIP(8),
        EXPIRE_SVIP(9),
        UNRECOGNIZED(-1);
        
        public static final int AGENCY_BANNER_VALUE = 1;
        public static final int COMMON_USER_VALUE = 5;
        public static final int EXPIRE_SVIP_VALUE = 9;
        public static final int EXPIRE_VIP_VALUE = 8;
        public static final int HEALTH_VALUE = 2;
        public static final int HEER_BANNER_VALUE = 3;
        public static final int SETTYINGS_VALUE = 4;
        public static final int SVIP_USER_VALUE = 7;
        public static final int UNKNOWN_MODULE_TYPE_VALUE = 0;
        public static final int VIP_USER_VALUE = 6;
        private final int value;
        private static final Internal.EnumLiteMap<ModuleType> internalValueMap = new Internal.EnumLiteMap<ModuleType>() { // from class: com.blued.das.settings.SettingsProtos.ModuleType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ModuleType findValueByNumber(int i) {
                return ModuleType.forNumber(i);
            }
        };
        private static final ModuleType[] VALUES = values();

        ModuleType(int i) {
            this.value = i;
        }

        public static ModuleType forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_MODULE_TYPE;
                case 1:
                    return AGENCY_BANNER;
                case 2:
                    return HEALTH;
                case 3:
                    return HEER_BANNER;
                case 4:
                    return SETTYINGS;
                case 5:
                    return COMMON_USER;
                case 6:
                    return VIP_USER;
                case 7:
                    return SVIP_USER;
                case 8:
                    return EXPIRE_VIP;
                case 9:
                    return EXPIRE_SVIP;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return SettingsProtos.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<ModuleType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static ModuleType valueOf(int i) {
            return forNumber(i);
        }

        public static ModuleType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/settings/SettingsProtos$SettingsProto.class */
    public static final class SettingsProto extends GeneratedMessageV3 implements SettingsProtoOrBuilder {
        public static final int BANNER_ID_FIELD_NUMBER = 5;
        public static final int EVENT_FIELD_NUMBER = 1;
        public static final int FROM_FIELD_NUMBER = 11;
        public static final int IS_AUTO_FIELD_NUMBER = 7;
        public static final int IS_OPEN_FIELD_NUMBER = 6;
        public static final int IS_SHADOW_FIELD_NUMBER = 8;
        public static final int LINK_URL_FIELD_NUMBER = 3;
        public static final int MODULE_TYPE_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int NUM_FIELD_NUMBER = 9;
        public static final int POSITION_FIELD_NUMBER = 10;
        private static final long serialVersionUID = 0;
        private volatile Object bannerId_;
        private int event_;
        private int from_;
        private boolean isAuto_;
        private boolean isOpen_;
        private boolean isShadow_;
        private volatile Object linkUrl_;
        private byte memoizedIsInitialized;
        private int moduleType_;
        private volatile Object name_;
        private int num_;
        private int position_;
        private static final SettingsProto DEFAULT_INSTANCE = new SettingsProto();
        private static final Parser<SettingsProto> PARSER = new AbstractParser<SettingsProto>() { // from class: com.blued.das.settings.SettingsProtos.SettingsProto.1
            @Override // com.google.protobuf.Parser
            public SettingsProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SettingsProto(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/settings/SettingsProtos$SettingsProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SettingsProtoOrBuilder {
            private Object bannerId_;
            private int event_;
            private int from_;
            private boolean isAuto_;
            private boolean isOpen_;
            private boolean isShadow_;
            private Object linkUrl_;
            private int moduleType_;
            private Object name_;
            private int num_;
            private int position_;

            private Builder() {
                this.event_ = 0;
                this.name_ = "";
                this.linkUrl_ = "";
                this.moduleType_ = 0;
                this.bannerId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.event_ = 0;
                this.name_ = "";
                this.linkUrl_ = "";
                this.moduleType_ = 0;
                this.bannerId_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SettingsProtos.internal_static_com_blued_das_settings_SettingsProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = SettingsProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SettingsProto build() {
                SettingsProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SettingsProto buildPartial() {
                SettingsProto settingsProto = new SettingsProto(this);
                settingsProto.event_ = this.event_;
                settingsProto.name_ = this.name_;
                settingsProto.linkUrl_ = this.linkUrl_;
                settingsProto.moduleType_ = this.moduleType_;
                settingsProto.bannerId_ = this.bannerId_;
                settingsProto.isOpen_ = this.isOpen_;
                settingsProto.isAuto_ = this.isAuto_;
                settingsProto.isShadow_ = this.isShadow_;
                settingsProto.num_ = this.num_;
                settingsProto.position_ = this.position_;
                settingsProto.from_ = this.from_;
                onBuilt();
                return settingsProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.event_ = 0;
                this.name_ = "";
                this.linkUrl_ = "";
                this.moduleType_ = 0;
                this.bannerId_ = "";
                this.isOpen_ = false;
                this.isAuto_ = false;
                this.isShadow_ = false;
                this.num_ = 0;
                this.position_ = 0;
                this.from_ = 0;
                return this;
            }

            public Builder clearBannerId() {
                this.bannerId_ = SettingsProto.getDefaultInstance().getBannerId();
                onChanged();
                return this;
            }

            public Builder clearEvent() {
                this.event_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearFrom() {
                this.from_ = 0;
                onChanged();
                return this;
            }

            public Builder clearIsAuto() {
                this.isAuto_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsShadow() {
                this.isShadow_ = false;
                onChanged();
                return this;
            }

            public Builder clearLinkUrl() {
                this.linkUrl_ = SettingsProto.getDefaultInstance().getLinkUrl();
                onChanged();
                return this;
            }

            public Builder clearModuleType() {
                this.moduleType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = SettingsProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder clearNum() {
                this.num_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearPosition() {
                this.position_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
            public String getBannerId() {
                Object obj = this.bannerId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.bannerId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
            public ByteString getBannerIdBytes() {
                Object obj = this.bannerId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.bannerId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SettingsProto getDefaultInstanceForType() {
                return SettingsProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SettingsProtos.internal_static_com_blued_das_settings_SettingsProto_descriptor;
            }

            @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
            public Event getEvent() {
                Event valueOf = Event.valueOf(this.event_);
                Event event = valueOf;
                if (valueOf == null) {
                    event = Event.UNRECOGNIZED;
                }
                return event;
            }

            @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
            public int getEventValue() {
                return this.event_;
            }

            @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
            public int getFrom() {
                return this.from_;
            }

            @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
            public boolean getIsAuto() {
                return this.isAuto_;
            }

            @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
            public boolean getIsShadow() {
                return this.isShadow_;
            }

            @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
            public String getLinkUrl() {
                Object obj = this.linkUrl_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.linkUrl_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
            public ByteString getLinkUrlBytes() {
                Object obj = this.linkUrl_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.linkUrl_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
            public ModuleType getModuleType() {
                ModuleType valueOf = ModuleType.valueOf(this.moduleType_);
                ModuleType moduleType = valueOf;
                if (valueOf == null) {
                    moduleType = ModuleType.UNRECOGNIZED;
                }
                return moduleType;
            }

            @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
            public int getModuleTypeValue() {
                return this.moduleType_;
            }

            @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
            public int getNum() {
                return this.num_;
            }

            @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
            public int getPosition() {
                return this.position_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SettingsProtos.internal_static_com_blued_das_settings_SettingsProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SettingsProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(SettingsProto settingsProto) {
                if (settingsProto == SettingsProto.getDefaultInstance()) {
                    return this;
                }
                if (settingsProto.event_ != 0) {
                    setEventValue(settingsProto.getEventValue());
                }
                if (!settingsProto.getName().isEmpty()) {
                    this.name_ = settingsProto.name_;
                    onChanged();
                }
                if (!settingsProto.getLinkUrl().isEmpty()) {
                    this.linkUrl_ = settingsProto.linkUrl_;
                    onChanged();
                }
                if (settingsProto.moduleType_ != 0) {
                    setModuleTypeValue(settingsProto.getModuleTypeValue());
                }
                if (!settingsProto.getBannerId().isEmpty()) {
                    this.bannerId_ = settingsProto.bannerId_;
                    onChanged();
                }
                if (settingsProto.getIsOpen()) {
                    setIsOpen(settingsProto.getIsOpen());
                }
                if (settingsProto.getIsAuto()) {
                    setIsAuto(settingsProto.getIsAuto());
                }
                if (settingsProto.getIsShadow()) {
                    setIsShadow(settingsProto.getIsShadow());
                }
                if (settingsProto.getNum() != 0) {
                    setNum(settingsProto.getNum());
                }
                if (settingsProto.getPosition() != 0) {
                    setPosition(settingsProto.getPosition());
                }
                if (settingsProto.getFrom() != 0) {
                    setFrom(settingsProto.getFrom());
                }
                mergeUnknownFields(settingsProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.settings.SettingsProtos.SettingsProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.settings.SettingsProtos.SettingsProto.access$1800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.settings.SettingsProtos$SettingsProto r0 = (com.blued.das.settings.SettingsProtos.SettingsProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.settings.SettingsProtos$SettingsProto$Builder r0 = r0.mergeFrom(r1)
                L1a:
                    r0 = r4
                    return r0
                L1c:
                    r6 = move-exception
                    r0 = r7
                    r5 = r0
                    goto L31
                L22:
                    r6 = move-exception
                    r0 = r6
                    com.google.protobuf.MessageLite r0 = r0.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L1c
                    com.blued.das.settings.SettingsProtos$SettingsProto r0 = (com.blued.das.settings.SettingsProtos.SettingsProto) r0     // Catch: java.lang.Throwable -> L1c
                    r5 = r0
                    r0 = r6
                    java.io.IOException r0 = r0.unwrapIOException()     // Catch: java.lang.Throwable -> L30
                    throw r0     // Catch: java.lang.Throwable -> L30
                L30:
                    r6 = move-exception
                L31:
                    r0 = r5
                    if (r0 == 0) goto L3b
                    r0 = r4
                    r1 = r5
                    com.blued.das.settings.SettingsProtos$SettingsProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.settings.SettingsProtos.SettingsProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.settings.SettingsProtos$SettingsProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof SettingsProto) {
                    return mergeFrom((SettingsProto) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setBannerId(String str) {
                if (str != null) {
                    this.bannerId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setBannerIdBytes(ByteString byteString) {
                if (byteString != null) {
                    SettingsProto.checkByteStringIsUtf8(byteString);
                    this.bannerId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setEvent(Event event) {
                if (event != null) {
                    this.event_ = event.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setEventValue(int i) {
                this.event_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setFrom(int i) {
                this.from_ = i;
                onChanged();
                return this;
            }

            public Builder setIsAuto(boolean z) {
                this.isAuto_ = z;
                onChanged();
                return this;
            }

            public Builder setIsOpen(boolean z) {
                this.isOpen_ = z;
                onChanged();
                return this;
            }

            public Builder setIsShadow(boolean z) {
                this.isShadow_ = z;
                onChanged();
                return this;
            }

            public Builder setLinkUrl(String str) {
                if (str != null) {
                    this.linkUrl_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLinkUrlBytes(ByteString byteString) {
                if (byteString != null) {
                    SettingsProto.checkByteStringIsUtf8(byteString);
                    this.linkUrl_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setModuleType(ModuleType moduleType) {
                if (moduleType != null) {
                    this.moduleType_ = moduleType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setModuleTypeValue(int i) {
                this.moduleType_ = i;
                onChanged();
                return this;
            }

            public Builder setName(String str) {
                if (str != null) {
                    this.name_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setNameBytes(ByteString byteString) {
                if (byteString != null) {
                    SettingsProto.checkByteStringIsUtf8(byteString);
                    this.name_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setNum(int i) {
                this.num_ = i;
                onChanged();
                return this;
            }

            public Builder setPosition(int i) {
                this.position_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private SettingsProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.event_ = 0;
            this.name_ = "";
            this.linkUrl_ = "";
            this.moduleType_ = 0;
            this.bannerId_ = "";
        }

        private SettingsProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw null;
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    this.event_ = codedInputStream.readEnum();
                                    continue;
                                case 18:
                                    this.name_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 26:
                                    this.linkUrl_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 32:
                                    this.moduleType_ = codedInputStream.readEnum();
                                    continue;
                                case 42:
                                    this.bannerId_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 48:
                                    this.isOpen_ = codedInputStream.readBool();
                                    continue;
                                case 56:
                                    this.isAuto_ = codedInputStream.readBool();
                                    continue;
                                case 64:
                                    this.isShadow_ = codedInputStream.readBool();
                                    continue;
                                case 72:
                                    this.num_ = codedInputStream.readInt32();
                                    continue;
                                case 80:
                                    this.position_ = codedInputStream.readInt32();
                                    continue;
                                case 88:
                                    this.from_ = codedInputStream.readInt32();
                                    continue;
                                default:
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                        break;
                                    } else {
                                        continue;
                                    }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        private SettingsProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SettingsProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SettingsProtos.internal_static_com_blued_das_settings_SettingsProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SettingsProto settingsProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(settingsProto);
        }

        public static SettingsProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SettingsProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SettingsProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SettingsProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SettingsProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static SettingsProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static SettingsProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SettingsProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static SettingsProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SettingsProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static SettingsProto parseFrom(InputStream inputStream) throws IOException {
            return (SettingsProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SettingsProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SettingsProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SettingsProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static SettingsProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static SettingsProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static SettingsProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<SettingsProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof SettingsProto) {
                SettingsProto settingsProto = (SettingsProto) obj;
                return this.event_ == settingsProto.event_ && getName().equals(settingsProto.getName()) && getLinkUrl().equals(settingsProto.getLinkUrl()) && this.moduleType_ == settingsProto.moduleType_ && getBannerId().equals(settingsProto.getBannerId()) && getIsOpen() == settingsProto.getIsOpen() && getIsAuto() == settingsProto.getIsAuto() && getIsShadow() == settingsProto.getIsShadow() && getNum() == settingsProto.getNum() && getPosition() == settingsProto.getPosition() && getFrom() == settingsProto.getFrom() && this.unknownFields.equals(settingsProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
        public String getBannerId() {
            Object obj = this.bannerId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.bannerId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
        public ByteString getBannerIdBytes() {
            Object obj = this.bannerId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.bannerId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SettingsProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
        public Event getEvent() {
            Event valueOf = Event.valueOf(this.event_);
            Event event = valueOf;
            if (valueOf == null) {
                event = Event.UNRECOGNIZED;
            }
            return event;
        }

        @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
        public int getEventValue() {
            return this.event_;
        }

        @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
        public int getFrom() {
            return this.from_;
        }

        @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
        public boolean getIsAuto() {
            return this.isAuto_;
        }

        @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
        public boolean getIsShadow() {
            return this.isShadow_;
        }

        @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
        public String getLinkUrl() {
            Object obj = this.linkUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.linkUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
        public ByteString getLinkUrlBytes() {
            Object obj = this.linkUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.linkUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
        public ModuleType getModuleType() {
            ModuleType valueOf = ModuleType.valueOf(this.moduleType_);
            ModuleType moduleType = valueOf;
            if (valueOf == null) {
                moduleType = ModuleType.UNRECOGNIZED;
            }
            return moduleType;
        }

        @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
        public int getModuleTypeValue() {
            return this.moduleType_;
        }

        @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
        public int getNum() {
            return this.num_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SettingsProto> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.das.settings.SettingsProtos.SettingsProtoOrBuilder
        public int getPosition() {
            return this.position_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.event_ != Event.UNKNOWN_EVENT.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.event_);
            }
            int i3 = i2;
            if (!getNameBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.name_);
            }
            int i4 = i3;
            if (!getLinkUrlBytes().isEmpty()) {
                i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.linkUrl_);
            }
            int i5 = i4;
            if (this.moduleType_ != ModuleType.UNKNOWN_MODULE_TYPE.getNumber()) {
                i5 = i4 + CodedOutputStream.computeEnumSize(4, this.moduleType_);
            }
            int i6 = i5;
            if (!getBannerIdBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(5, this.bannerId_);
            }
            boolean z = this.isOpen_;
            int i7 = i6;
            if (z) {
                i7 = i6 + CodedOutputStream.computeBoolSize(6, z);
            }
            boolean z2 = this.isAuto_;
            int i8 = i7;
            if (z2) {
                i8 = i7 + CodedOutputStream.computeBoolSize(7, z2);
            }
            boolean z3 = this.isShadow_;
            int i9 = i8;
            if (z3) {
                i9 = i8 + CodedOutputStream.computeBoolSize(8, z3);
            }
            int i10 = this.num_;
            int i11 = i9;
            if (i10 != 0) {
                i11 = i9 + CodedOutputStream.computeInt32Size(9, i10);
            }
            int i12 = this.position_;
            int i13 = i11;
            if (i12 != 0) {
                i13 = i11 + CodedOutputStream.computeInt32Size(10, i12);
            }
            int i14 = this.from_;
            int i15 = i13;
            if (i14 != 0) {
                i15 = i13 + CodedOutputStream.computeInt32Size(11, i14);
            }
            int serializedSize = i15 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.event_) * 37) + 2) * 53) + getName().hashCode()) * 37) + 3) * 53) + getLinkUrl().hashCode()) * 37) + 4) * 53) + this.moduleType_) * 37) + 5) * 53) + getBannerId().hashCode()) * 37) + 6) * 53) + Internal.hashBoolean(getIsOpen())) * 37) + 7) * 53) + Internal.hashBoolean(getIsAuto())) * 37) + 8) * 53) + Internal.hashBoolean(getIsShadow())) * 37) + 9) * 53) + getNum()) * 37) + 10) * 53) + getPosition()) * 37) + 11) * 53) + getFrom()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SettingsProtos.internal_static_com_blued_das_settings_SettingsProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SettingsProto.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new SettingsProto();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.event_ != Event.UNKNOWN_EVENT.getNumber()) {
                codedOutputStream.writeEnum(1, this.event_);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.name_);
            }
            if (!getLinkUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.linkUrl_);
            }
            if (this.moduleType_ != ModuleType.UNKNOWN_MODULE_TYPE.getNumber()) {
                codedOutputStream.writeEnum(4, this.moduleType_);
            }
            if (!getBannerIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.bannerId_);
            }
            boolean z = this.isOpen_;
            if (z) {
                codedOutputStream.writeBool(6, z);
            }
            boolean z2 = this.isAuto_;
            if (z2) {
                codedOutputStream.writeBool(7, z2);
            }
            boolean z3 = this.isShadow_;
            if (z3) {
                codedOutputStream.writeBool(8, z3);
            }
            int i = this.num_;
            if (i != 0) {
                codedOutputStream.writeInt32(9, i);
            }
            int i2 = this.position_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(10, i2);
            }
            int i3 = this.from_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(11, i3);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/settings/SettingsProtos$SettingsProtoOrBuilder.class */
    public interface SettingsProtoOrBuilder extends MessageOrBuilder {
        String getBannerId();

        ByteString getBannerIdBytes();

        Event getEvent();

        int getEventValue();

        int getFrom();

        boolean getIsAuto();

        boolean getIsOpen();

        boolean getIsShadow();

        String getLinkUrl();

        ByteString getLinkUrlBytes();

        ModuleType getModuleType();

        int getModuleTypeValue();

        String getName();

        ByteString getNameBytes();

        int getNum();

        int getPosition();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_das_settings_SettingsProto_descriptor = descriptor2;
        internal_static_com_blued_das_settings_SettingsProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Event", "Name", "LinkUrl", "ModuleType", "BannerId", "IsOpen", "IsAuto", "IsShadow", "Num", "Position", HttpHeaders.FROM});
    }

    private SettingsProtos() {
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
