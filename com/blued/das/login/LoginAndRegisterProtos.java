package com.blued.das.login;

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

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/login/LoginAndRegisterProtos.class */
public final class LoginAndRegisterProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cLoginAndRegisterProtos.proto\u0012\u0013com.blued.das.login\"\u0087\u0006\n\u0015LoginAndRegisterProto\u0012)\n\u0005event\u0018\u0001 \u0001(\u000e2\u001a.com.blued.das.login.Event\u00120\n\tunit_type\u0018\u0002 \u0001(\u000e2\u001d.com.blued.das.login.UnitType\u00120\n\trole_type\u0018\u0003 \u0001(\u000e2\u001d.com.blued.das.login.RoleType\u00126\n\flabel_status\u0018\u0004 \u0001(\u000e2 .com.blued.das.login.LabelStatus\u0012\u0012\n\ntarget_uid\u0018\u0005 \u0001(\t\u0012\u0017\n\u000ftarget_uid_list\u0018\u0006 \u0001(\t\u0012+\n\u0006source\u0018\u0007 \u0001(\u000e2\u001b.com.blued.das.login.Source\u00122\n\nlabel_type\u0018\b \u0001(\u000e2\u001e.com.blued.das.login.LabelType\u0012\u0010\n\bduration\u0018\t \u0001(\u0005\u0012\u0016\n\u000ethird_duration\u0018\n \u0001(\u0005\u0012\u0013\n\u000bis_callback\u0018\u000b \u0001(\b\u0012\u0013\n\u000bori_channel\u0018\f \u0001(\t\u0012\f\n\u0004json\u0018\r \u0001(\t\u0012\n\n\u0002id\u0018\u000e \u0001(\t\u0012\f\n\u0004type\u0018\u000f \u0001(\t\u0012\u000e\n\u0006reason\u0018\u0010 \u0001(\t\u0012\u0010\n\bposition\u0018\u0011 \u0001(\t\u0012\f\n\u0004code\u0018\u0012 \u0001(\t\u0012\r\n\u0005speed\u0018\u0013 \u0001(\t\u0012\r\n\u0005angle\u0018\u0014 \u0001(\t\u0012\u0013\n\u000bop_duration\u0018\u0015 \u0001(\t\u0012\u000b\n\u0003num\u0018\u0016 \u0001(\u0005\u0012\u0010\n\bthird_id\u0018\u0017 \u0001(\t\u0012\r\n\u0005price\u0018\u0018 \u0001(\u0001\u0012\u0014\n\fprice_second\u0018\u0019 \u0001(\u0001\u0012\u000e\n\u0006id_sub\u0018\u001a \u0001(\t\u0012\u0011\n\tid_parent\u0018\u001b \u0001(\t\u0012\u000b\n\u0003nbt\u0018\u001c \u0001(\t\u0012\u0015\n\rposition_code\u0018\u001d \u0001(\t\u0012\u000e\n\u0006req_id\u0018\u001e \u0001(\t\u0012\u000f\n\u0007op_type\u0018\u001f \u0001(\t\u0012\u000e\n\u0006layout\u0018  \u0001(\t*\u0099\u001a\n\u0005Event\u0012\u000b\n\u0007UNKNOWN\u0010��\u0012\u0013\n\u000fLOGIN_BTN_CLICK\u0010\u0001\u0012!\n\u001dLOGIN_PAGE_REGISTER_BTN_CLICK\u0010\u0002\u0012$\n LOGIN_PAGE_THIRD_LOGIN_BTN_CLICK\u0010\u0003\u0012$\n REGISTER_PAGE_REGISTER_BTN_CLICK\u0010\u0004\u0012'\n#REGISTER_PAGE_THIRD_LOGIN_BTN_CLICK\u0010\u0005\u0012\u001e\n\u001aAUTHCODE_CONFIRM_BTN_CLICK\u0010\u0006\u0012\u001d\n\u0019AUTHCODE_RESEND_BTN_CLICK\u0010\u0007\u0012(\n$PROFILE_WRITE_PAGE_CONFIRM_BTN_CLICK\u0010\b\u0012\u0014\n\u0010REGISTER_SUCCESS\u0010\t\u0012\u001c\n\u0018REC_PAGE_ENTER_BTN_CLICK\u0010\n\u0012)\n%PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CLICK\u0010\u000b\u00121\n-PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CONFIRM_CLICK\u0010\f\u0012%\n!PROFILE_WRITE_PAGE_UNIT_BTN_CLICK\u0010\r\u0012%\n!PROFILE_WRITE_PAGE_ROLE_BTN_CLICK\u0010\u000e\u0012!\n\u001dPERSONAL_LABEL_NEXT_BTN_CLICK\u0010\u000f\u0012\u001d\n\u0019LIKE_LABEL_NEXT_BTN_CLICK\u0010\u0010\u0012#\n\u001fRECOMMEND_PAGE_GRID_AVATAR_DRAW\u0010\u0011\u0012\u001f\n\u001bRECOMMEND_PAGE_POP_UPS_SHOW\u0010\u0012\u0012'\n#RECOMMEND_PAGE_POP_UPS_FOLLOW_CLICK\u0010\u0013\u0012\u001b\n\u0017PROFILE_WRITE_PAGE_SHOW\u0010\u0014\u0012\u0016\n\u0012ONE_CLICK_POP_SHOW\u0010\u0015\u0012\u001c\n\u0018ONE_CLICK_POP_TRUE_CLICK\u0010\u0016\u0012\u001a\n\u0016LOGIN_PRIVACY_POP_SHOW\u0010\u0017\u0012!\n\u001dLOGIN_PRIVACY_POP_AGREE_CLICK\u0010\u0018\u0012$\n LOGIN_PRIVACY_POP_DISAGREE_CLICK\u0010\u0019\u0012\u001c\n\u0018LOGIN_AUTHORITY_POP_SHOW\u0010\u001a\u0012\"\n\u001eLOGIN_AUTHORITY_POP_OPEN_CLICK\u0010\u001b\u0012\u0015\n\u0011FIND_PWD_BY_PHONE\u0010\u001c\u0012\u0019\n\u0015FIND_PWD_BY_REG_EMAIL\u0010\u001d\u0012\u001a\n\u0016FIND_PWD_BY_SAFE_EMAIL\u0010\u001e\u0012\u0011\n\rLOGIN_SUCCESS\u0010\u001f\u0012\u001f\n\u001bREGISTER_APPLE_ID_BTN_CLICK\u0010 \u0012\u001d\n\u0019ONE_CLICK_LOGIN_BTN_CLICK\u0010!\u0012%\n!OPEN_PAGE_CREATE_TO_SHOW_DURATION\u0010\"\u0012\u0013\n\u000fHW_CHANNEL_DATA\u0010#\u0012\u0010\n\fJD_AD_TO_APP\u0010$\u0012\u000f\n\u000bJD_AD_TO_H5\u0010%\u0012\u0016\n\u0012OPEN_AD_WORD_CLICK\u0010&\u0012\u0013\n\u000fOPEN_AD_TIMEOUT\u0010'\u0012\u0014\n\u0010AD_VIDEO_REQUEST\u0010(\u0012\u0015\n\u0011AD_VIDEO_RESPONSE\u0010)\u0012\u001b\n\u0017AD_VIDEO_WANDOU_SUCCESS\u0010*\u0012\u0018\n\u0014AD_REACH_MAX_REQUEST\u0010+\u0012\u0019\n\u0015AD_REACH_MAX_RESPONSE\u0010,\u0012\u0014\n\u0010OPEN_AD_UP_SLIDE\u0010-\u0012\u0011\n\rOPEN_AD_SHAKE\u0010.\u0012\u001b\n\u0017OTHER_PHONE_LOGIN_CLICK\u0010/\u0012\u0016\n\u0012AUTHCODE_GET_CLICK\u00100\u0012\"\n\u001eREGISTER_PHONE_BIND_LIMIT_SHOW\u00101\u0012*\n&REGISTER_PHONE_BIND_LIMIT_CANCEL_CLICK\u00102\u0012*\n&REGISTER_PHONE_BIND_LIMIT_CHANGE_CLICK\u00103\u0012\"\n\u001eREGISTER_PROFILE_NICKNAME_SHOW\u00104\u0012\"\n\u001eREGISTER_PROFILE_BIRTHDAY_SHOW\u00105\u0012\u001e\n\u001aREGISTER_PROFILE_ROLE_SHOW\u00106\u0012\u001d\n\u0019REGISTER_LABEL_SKIP_CLICK\u00107\u0012\u001f\n\u001bREGISTER_LABEL_MY_BODY_SHOW\u00108\u0012 \n\u001cREGISTER_LABEL_MY_LABEL_SHOW\u00109\u0012\"\n\u001eREGISTER_LABEL_MY_PURPOSE_SHOW\u0010:\u0012 \n\u001cREGISTER_LABEL_HIS_BODY_SHOW\u0010;\u0012!\n\u001dREGISTER_LABEL_HIS_LABEL_SHOW\u0010<\u0012\u001d\n\u0019REGISTER_LABEL_MATCH_SHOW\u0010=\u0012\u001a\n\u0016FLASH_AD_VIDEO_REQUEST\u0010>\u0012\u001b\n\u0017FLASH_AD_VIDEO_RESPONSE\u0010?\u0012\u001a\n\u0016FLASH_AD_VIDEO_SUCCESS\u0010@\u0012\u0018\n\u0014USER_VERIFY_POP_SHOW\u0010A\u0012\u001e\n\u001aUSER_VERIFY_POP_SEND_CLICK\u0010B\u0012\u001e\n\u001aUSER_VERIFY_POP_DONE_CLICK\u0010C\u0012\u0018\n\u0014USER_VERIFY_POP_FAIL\u0010D\u0012\u001b\n\u0017USER_VERIFY_POP_SUCCESS\u0010E\u0012\u001b\n\u0017AD_HOME_BANNER1_REQUEST\u0010F\u0012\u001c\n\u0018AD_HOME_BANNER1_RESPONSE\u0010G\u0012\u0013\n\u000fOPEN_AD_REQUEST\u0010H\u0012\u001a\n\u0016OPEN_AD_RETURN_SUCCESS\u0010I\u0012\u0017\n\u0013OPEN_AD_RETURN_FAIL\u0010J\u0012\u0010\n\fOPEN_AD_SHOW\u0010K\u0012\u0015\n\u0011OPEN_AD_SHOW_FAIL\u0010L\u0012\u0016\n\u0012OPEN_AD_SKIP_CLICK\u0010M\u0012\u0011\n\rOPEN_AD_CLICK\u0010N\u0012\u0015\n\u0011AD_NATIVE_REQUEST\u0010O\u0012\u0016\n\u0012AD_NATIVE_RESPONSE\u0010P\u0012\u001b\n\u0017AD_NATIVE_RESPONSE_FAIL\u0010Q\u0012\u000f\n\u000bPHONE_SHAKE\u0010R\u0012\u0016\n\u0012AD_OPEN_SHAKE_DONE\u0010S\u0012\u0012\n\u000eAD_REQUEST_ALL\u0010T\u0012\u0012\n\u000eAD_REQUEST_SUB\u0010U\u0012\u0019\n\u0015AD_RETURN_SUCCESS_ALL\u0010V\u0012\u0019\n\u0015AD_RETURN_SUCCESS_SUB\u0010W\u0012\u0016\n\u0012AD_RETURN_FAIL_ALL\u0010X\u0012\u0016\n\u0012AD_RETURN_FAIL_SUB\u0010Y\u0012\u001a\n\u0016AD_BIDDING_SUCCESS_ALL\u0010Z\u0012\u001a\n\u0016AD_BIDDING_SUCCESS_SUB\u0010[\u0012\u0017\n\u0013AD_BIDDING_FAIL_ALL\u0010\\\u0012\u0017\n\u0013AD_BIDDING_FAIL_SUB\u0010]\u0012\u000e\n\nAD_TIMEOUT\u0010^\u0012\u001c\n\u0018UNINSTALL_LOGIN_POP_SHOW\u0010_\u0012!\n\u001dUNINSTALL_LOGIN_POP_YES_CLICK\u0010`\u0012$\n UNINSTALL_LOGIN_POP_CHANGE_CLICK\u0010a\u0012%\n!UNINSTALL_LOGIN_POP_LOGIN_SUCCESS\u0010b\u0012!\n\u001dAD_HOME_BANNER1_RESPONSE_FAIL\u0010d\u0012\u0012\n\u000eAD_API_REQUEST\u0010h\u0012\u001e\n\u001aAD_SOURCE_DOWNLOAD_SUCCESS\u0010j\u0012\u001b\n\u0017AD_SOURCE_DOWNLOAD_FAIL\u0010k\u0012\u0018\n\u0014AD_DOWNLOAD_POP_SHOW\u0010l\u0012\u001d\n\u0019AD_DOWNLOAD_POP_YES_CLICK\u0010m\u0012\u001c\n\u0018AD_DOWNLOAD_POP_NO_CLICK\u0010n\u0012\u0013\n\u000fAD_REQUEST_FAIL\u0010o\u0012\u0016\n\u0012AD_REQUEST_TIMEOUT\u0010p\u0012\u0010\n\fAD_REQUEST_A\u0010q\u0012\u000e\n\nAD_REQUEST\u0010r\u0012\u0012\n\u000eAD_SUB_TIMEOUT\u0010s\u0012\u001a\n\u0016AD_API_REQUEST_SUCCESS\u0010t\u0012\u000f\n\u000bAD_ADX_SHOW\u0010u\u0012\u0014\n\u0010AD_ADX_VIEW_SHOW\u0010v\u0012\u0010\n\fAD_SHOW_FAIL\u0010w\u0012\u001b\n\u0017AD_APPLET_OPEN_POP_SHOW\u0010x\u0012 \n\u001cAD_APPLET_OPEN_POP_YES_CLICK\u0010y*7\n\bUnitType\u0012\u0015\n\u0011UNKNOWN_UNIT_TYPE\u0010��\u0012\t\n\u0005FT_LB\u0010\u0001\u0012\t\n\u0005CM_KG\u0010\u0002*I\n\bRoleType\u0012\u0015\n\u0011UNKNOWN_ROLE_TYPE\u0010��\u0012\u0007\n\u0003ONE\u0010\u0001\u0012\b\n\u0004ZERO\u0010\u0002\u0012\b\n\u0004HARF\u0010\u0003\u0012\t\n\u0005OTHER\u0010\u0004*\\\n\u000bLabelStatus\u0012\u0018\n\u0014UNKNOWN_LABEL_STATUS\u0010��\u0012\u0011\n\rINITIATIVE_NO\u0010\u0001\u0012\u0013\n\u000fINITIATIVE_HAVE\u0010\u0002\u0012\u000b\n\u0007DEFAULT\u0010\u0003*D\n\tLabelType\u0012\u0016\n\u0012UNKNOWN_LABEL_TYPE\u0010��\u0012\b\n\u0004BODY\u0010\u0001\u0012\u000b\n\u0007FEATURE\u0010\u0002\u0012\b\n\u0004WANT\u0010\u0003*h\n\u0006Source\u0012\u0012\n\u000eUNKNOWN_SOURCE\u0010��\u0012\t\n\u0005PHONE\u0010\u0001\u0012\n\n\u0006WECHAT\u0010\u0002\u0012\t\n\u0005APPLE\u0010\u0003\u0012\r\n\tONE_CLICK\u0010\u0004\u0012\t\n\u0005EMAIL\u0010\u0005\u0012\u000e\n\nPHONE_CODE\u0010\u0006B\u0015¢\u0002\u0012LOGIN_AND_REGISTERb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_blued_das_login_LoginAndRegisterProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_login_LoginAndRegisterProto_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/login/LoginAndRegisterProtos$Event.class */
    public enum Event implements ProtocolMessageEnum {
        UNKNOWN(0),
        LOGIN_BTN_CLICK(1),
        LOGIN_PAGE_REGISTER_BTN_CLICK(2),
        LOGIN_PAGE_THIRD_LOGIN_BTN_CLICK(3),
        REGISTER_PAGE_REGISTER_BTN_CLICK(4),
        REGISTER_PAGE_THIRD_LOGIN_BTN_CLICK(5),
        AUTHCODE_CONFIRM_BTN_CLICK(6),
        AUTHCODE_RESEND_BTN_CLICK(7),
        PROFILE_WRITE_PAGE_CONFIRM_BTN_CLICK(8),
        REGISTER_SUCCESS(9),
        REC_PAGE_ENTER_BTN_CLICK(10),
        PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CLICK(11),
        PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CONFIRM_CLICK(12),
        PROFILE_WRITE_PAGE_UNIT_BTN_CLICK(13),
        PROFILE_WRITE_PAGE_ROLE_BTN_CLICK(14),
        PERSONAL_LABEL_NEXT_BTN_CLICK(15),
        LIKE_LABEL_NEXT_BTN_CLICK(16),
        RECOMMEND_PAGE_GRID_AVATAR_DRAW(17),
        RECOMMEND_PAGE_POP_UPS_SHOW(18),
        RECOMMEND_PAGE_POP_UPS_FOLLOW_CLICK(19),
        PROFILE_WRITE_PAGE_SHOW(20),
        ONE_CLICK_POP_SHOW(21),
        ONE_CLICK_POP_TRUE_CLICK(22),
        LOGIN_PRIVACY_POP_SHOW(23),
        LOGIN_PRIVACY_POP_AGREE_CLICK(24),
        LOGIN_PRIVACY_POP_DISAGREE_CLICK(25),
        LOGIN_AUTHORITY_POP_SHOW(26),
        LOGIN_AUTHORITY_POP_OPEN_CLICK(27),
        FIND_PWD_BY_PHONE(28),
        FIND_PWD_BY_REG_EMAIL(29),
        FIND_PWD_BY_SAFE_EMAIL(30),
        LOGIN_SUCCESS(31),
        REGISTER_APPLE_ID_BTN_CLICK(32),
        ONE_CLICK_LOGIN_BTN_CLICK(33),
        OPEN_PAGE_CREATE_TO_SHOW_DURATION(34),
        HW_CHANNEL_DATA(35),
        JD_AD_TO_APP(36),
        JD_AD_TO_H5(37),
        OPEN_AD_WORD_CLICK(38),
        OPEN_AD_TIMEOUT(39),
        AD_VIDEO_REQUEST(40),
        AD_VIDEO_RESPONSE(41),
        AD_VIDEO_WANDOU_SUCCESS(42),
        AD_REACH_MAX_REQUEST(43),
        AD_REACH_MAX_RESPONSE(44),
        OPEN_AD_UP_SLIDE(45),
        OPEN_AD_SHAKE(46),
        OTHER_PHONE_LOGIN_CLICK(47),
        AUTHCODE_GET_CLICK(48),
        REGISTER_PHONE_BIND_LIMIT_SHOW(49),
        REGISTER_PHONE_BIND_LIMIT_CANCEL_CLICK(50),
        REGISTER_PHONE_BIND_LIMIT_CHANGE_CLICK(51),
        REGISTER_PROFILE_NICKNAME_SHOW(52),
        REGISTER_PROFILE_BIRTHDAY_SHOW(53),
        REGISTER_PROFILE_ROLE_SHOW(54),
        REGISTER_LABEL_SKIP_CLICK(55),
        REGISTER_LABEL_MY_BODY_SHOW(56),
        REGISTER_LABEL_MY_LABEL_SHOW(57),
        REGISTER_LABEL_MY_PURPOSE_SHOW(58),
        REGISTER_LABEL_HIS_BODY_SHOW(59),
        REGISTER_LABEL_HIS_LABEL_SHOW(60),
        REGISTER_LABEL_MATCH_SHOW(61),
        FLASH_AD_VIDEO_REQUEST(62),
        FLASH_AD_VIDEO_RESPONSE(63),
        FLASH_AD_VIDEO_SUCCESS(64),
        USER_VERIFY_POP_SHOW(65),
        USER_VERIFY_POP_SEND_CLICK(66),
        USER_VERIFY_POP_DONE_CLICK(67),
        USER_VERIFY_POP_FAIL(68),
        USER_VERIFY_POP_SUCCESS(69),
        AD_HOME_BANNER1_REQUEST(70),
        AD_HOME_BANNER1_RESPONSE(71),
        OPEN_AD_REQUEST(72),
        OPEN_AD_RETURN_SUCCESS(73),
        OPEN_AD_RETURN_FAIL(74),
        OPEN_AD_SHOW(75),
        OPEN_AD_SHOW_FAIL(76),
        OPEN_AD_SKIP_CLICK(77),
        OPEN_AD_CLICK(78),
        AD_NATIVE_REQUEST(79),
        AD_NATIVE_RESPONSE(80),
        AD_NATIVE_RESPONSE_FAIL(81),
        PHONE_SHAKE(82),
        AD_OPEN_SHAKE_DONE(83),
        AD_REQUEST_ALL(84),
        AD_REQUEST_SUB(85),
        AD_RETURN_SUCCESS_ALL(86),
        AD_RETURN_SUCCESS_SUB(87),
        AD_RETURN_FAIL_ALL(88),
        AD_RETURN_FAIL_SUB(89),
        AD_BIDDING_SUCCESS_ALL(90),
        AD_BIDDING_SUCCESS_SUB(91),
        AD_BIDDING_FAIL_ALL(92),
        AD_BIDDING_FAIL_SUB(93),
        AD_TIMEOUT(94),
        UNINSTALL_LOGIN_POP_SHOW(95),
        UNINSTALL_LOGIN_POP_YES_CLICK(96),
        UNINSTALL_LOGIN_POP_CHANGE_CLICK(97),
        UNINSTALL_LOGIN_POP_LOGIN_SUCCESS(98),
        AD_HOME_BANNER1_RESPONSE_FAIL(100),
        AD_API_REQUEST(104),
        AD_SOURCE_DOWNLOAD_SUCCESS(106),
        AD_SOURCE_DOWNLOAD_FAIL(107),
        AD_DOWNLOAD_POP_SHOW(108),
        AD_DOWNLOAD_POP_YES_CLICK(109),
        AD_DOWNLOAD_POP_NO_CLICK(110),
        AD_REQUEST_FAIL(111),
        AD_REQUEST_TIMEOUT(112),
        AD_REQUEST_A(113),
        AD_REQUEST(114),
        AD_SUB_TIMEOUT(115),
        AD_API_REQUEST_SUCCESS(116),
        AD_ADX_SHOW(117),
        AD_ADX_VIEW_SHOW(118),
        AD_SHOW_FAIL(119),
        AD_APPLET_OPEN_POP_SHOW(120),
        AD_APPLET_OPEN_POP_YES_CLICK(121),
        UNRECOGNIZED(-1);
        
        public static final int AD_ADX_SHOW_VALUE = 117;
        public static final int AD_ADX_VIEW_SHOW_VALUE = 118;
        public static final int AD_API_REQUEST_SUCCESS_VALUE = 116;
        public static final int AD_API_REQUEST_VALUE = 104;
        public static final int AD_APPLET_OPEN_POP_SHOW_VALUE = 120;
        public static final int AD_APPLET_OPEN_POP_YES_CLICK_VALUE = 121;
        public static final int AD_BIDDING_FAIL_ALL_VALUE = 92;
        public static final int AD_BIDDING_FAIL_SUB_VALUE = 93;
        public static final int AD_BIDDING_SUCCESS_ALL_VALUE = 90;
        public static final int AD_BIDDING_SUCCESS_SUB_VALUE = 91;
        public static final int AD_DOWNLOAD_POP_NO_CLICK_VALUE = 110;
        public static final int AD_DOWNLOAD_POP_SHOW_VALUE = 108;
        public static final int AD_DOWNLOAD_POP_YES_CLICK_VALUE = 109;
        public static final int AD_HOME_BANNER1_REQUEST_VALUE = 70;
        public static final int AD_HOME_BANNER1_RESPONSE_FAIL_VALUE = 100;
        public static final int AD_HOME_BANNER1_RESPONSE_VALUE = 71;
        public static final int AD_NATIVE_REQUEST_VALUE = 79;
        public static final int AD_NATIVE_RESPONSE_FAIL_VALUE = 81;
        public static final int AD_NATIVE_RESPONSE_VALUE = 80;
        public static final int AD_OPEN_SHAKE_DONE_VALUE = 83;
        public static final int AD_REACH_MAX_REQUEST_VALUE = 43;
        public static final int AD_REACH_MAX_RESPONSE_VALUE = 44;
        public static final int AD_REQUEST_ALL_VALUE = 84;
        public static final int AD_REQUEST_A_VALUE = 113;
        public static final int AD_REQUEST_FAIL_VALUE = 111;
        public static final int AD_REQUEST_SUB_VALUE = 85;
        public static final int AD_REQUEST_TIMEOUT_VALUE = 112;
        public static final int AD_REQUEST_VALUE = 114;
        public static final int AD_RETURN_FAIL_ALL_VALUE = 88;
        public static final int AD_RETURN_FAIL_SUB_VALUE = 89;
        public static final int AD_RETURN_SUCCESS_ALL_VALUE = 86;
        public static final int AD_RETURN_SUCCESS_SUB_VALUE = 87;
        public static final int AD_SHOW_FAIL_VALUE = 119;
        public static final int AD_SOURCE_DOWNLOAD_FAIL_VALUE = 107;
        public static final int AD_SOURCE_DOWNLOAD_SUCCESS_VALUE = 106;
        public static final int AD_SUB_TIMEOUT_VALUE = 115;
        public static final int AD_TIMEOUT_VALUE = 94;
        public static final int AD_VIDEO_REQUEST_VALUE = 40;
        public static final int AD_VIDEO_RESPONSE_VALUE = 41;
        public static final int AD_VIDEO_WANDOU_SUCCESS_VALUE = 42;
        public static final int AUTHCODE_CONFIRM_BTN_CLICK_VALUE = 6;
        public static final int AUTHCODE_GET_CLICK_VALUE = 48;
        public static final int AUTHCODE_RESEND_BTN_CLICK_VALUE = 7;
        public static final int FIND_PWD_BY_PHONE_VALUE = 28;
        public static final int FIND_PWD_BY_REG_EMAIL_VALUE = 29;
        public static final int FIND_PWD_BY_SAFE_EMAIL_VALUE = 30;
        public static final int FLASH_AD_VIDEO_REQUEST_VALUE = 62;
        public static final int FLASH_AD_VIDEO_RESPONSE_VALUE = 63;
        public static final int FLASH_AD_VIDEO_SUCCESS_VALUE = 64;
        public static final int HW_CHANNEL_DATA_VALUE = 35;
        public static final int JD_AD_TO_APP_VALUE = 36;
        public static final int JD_AD_TO_H5_VALUE = 37;
        public static final int LIKE_LABEL_NEXT_BTN_CLICK_VALUE = 16;
        public static final int LOGIN_AUTHORITY_POP_OPEN_CLICK_VALUE = 27;
        public static final int LOGIN_AUTHORITY_POP_SHOW_VALUE = 26;
        public static final int LOGIN_BTN_CLICK_VALUE = 1;
        public static final int LOGIN_PAGE_REGISTER_BTN_CLICK_VALUE = 2;
        public static final int LOGIN_PAGE_THIRD_LOGIN_BTN_CLICK_VALUE = 3;
        public static final int LOGIN_PRIVACY_POP_AGREE_CLICK_VALUE = 24;
        public static final int LOGIN_PRIVACY_POP_DISAGREE_CLICK_VALUE = 25;
        public static final int LOGIN_PRIVACY_POP_SHOW_VALUE = 23;
        public static final int LOGIN_SUCCESS_VALUE = 31;
        public static final int ONE_CLICK_LOGIN_BTN_CLICK_VALUE = 33;
        public static final int ONE_CLICK_POP_SHOW_VALUE = 21;
        public static final int ONE_CLICK_POP_TRUE_CLICK_VALUE = 22;
        public static final int OPEN_AD_CLICK_VALUE = 78;
        public static final int OPEN_AD_REQUEST_VALUE = 72;
        public static final int OPEN_AD_RETURN_FAIL_VALUE = 74;
        public static final int OPEN_AD_RETURN_SUCCESS_VALUE = 73;
        public static final int OPEN_AD_SHAKE_VALUE = 46;
        public static final int OPEN_AD_SHOW_FAIL_VALUE = 76;
        public static final int OPEN_AD_SHOW_VALUE = 75;
        public static final int OPEN_AD_SKIP_CLICK_VALUE = 77;
        public static final int OPEN_AD_TIMEOUT_VALUE = 39;
        public static final int OPEN_AD_UP_SLIDE_VALUE = 45;
        public static final int OPEN_AD_WORD_CLICK_VALUE = 38;
        public static final int OPEN_PAGE_CREATE_TO_SHOW_DURATION_VALUE = 34;
        public static final int OTHER_PHONE_LOGIN_CLICK_VALUE = 47;
        public static final int PERSONAL_LABEL_NEXT_BTN_CLICK_VALUE = 15;
        public static final int PHONE_SHAKE_VALUE = 82;
        public static final int PROFILE_WRITE_PAGE_CONFIRM_BTN_CLICK_VALUE = 8;
        public static final int PROFILE_WRITE_PAGE_ROLE_BTN_CLICK_VALUE = 14;
        public static final int PROFILE_WRITE_PAGE_SHOW_VALUE = 20;
        public static final int PROFILE_WRITE_PAGE_UNIT_BTN_CLICK_VALUE = 13;
        public static final int PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CLICK_VALUE = 11;
        public static final int PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CONFIRM_CLICK_VALUE = 12;
        public static final int RECOMMEND_PAGE_GRID_AVATAR_DRAW_VALUE = 17;
        public static final int RECOMMEND_PAGE_POP_UPS_FOLLOW_CLICK_VALUE = 19;
        public static final int RECOMMEND_PAGE_POP_UPS_SHOW_VALUE = 18;
        public static final int REC_PAGE_ENTER_BTN_CLICK_VALUE = 10;
        public static final int REGISTER_APPLE_ID_BTN_CLICK_VALUE = 32;
        public static final int REGISTER_LABEL_HIS_BODY_SHOW_VALUE = 59;
        public static final int REGISTER_LABEL_HIS_LABEL_SHOW_VALUE = 60;
        public static final int REGISTER_LABEL_MATCH_SHOW_VALUE = 61;
        public static final int REGISTER_LABEL_MY_BODY_SHOW_VALUE = 56;
        public static final int REGISTER_LABEL_MY_LABEL_SHOW_VALUE = 57;
        public static final int REGISTER_LABEL_MY_PURPOSE_SHOW_VALUE = 58;
        public static final int REGISTER_LABEL_SKIP_CLICK_VALUE = 55;
        public static final int REGISTER_PAGE_REGISTER_BTN_CLICK_VALUE = 4;
        public static final int REGISTER_PAGE_THIRD_LOGIN_BTN_CLICK_VALUE = 5;
        public static final int REGISTER_PHONE_BIND_LIMIT_CANCEL_CLICK_VALUE = 50;
        public static final int REGISTER_PHONE_BIND_LIMIT_CHANGE_CLICK_VALUE = 51;
        public static final int REGISTER_PHONE_BIND_LIMIT_SHOW_VALUE = 49;
        public static final int REGISTER_PROFILE_BIRTHDAY_SHOW_VALUE = 53;
        public static final int REGISTER_PROFILE_NICKNAME_SHOW_VALUE = 52;
        public static final int REGISTER_PROFILE_ROLE_SHOW_VALUE = 54;
        public static final int REGISTER_SUCCESS_VALUE = 9;
        public static final int UNINSTALL_LOGIN_POP_CHANGE_CLICK_VALUE = 97;
        public static final int UNINSTALL_LOGIN_POP_LOGIN_SUCCESS_VALUE = 98;
        public static final int UNINSTALL_LOGIN_POP_SHOW_VALUE = 95;
        public static final int UNINSTALL_LOGIN_POP_YES_CLICK_VALUE = 96;
        public static final int UNKNOWN_VALUE = 0;
        public static final int USER_VERIFY_POP_DONE_CLICK_VALUE = 67;
        public static final int USER_VERIFY_POP_FAIL_VALUE = 68;
        public static final int USER_VERIFY_POP_SEND_CLICK_VALUE = 66;
        public static final int USER_VERIFY_POP_SHOW_VALUE = 65;
        public static final int USER_VERIFY_POP_SUCCESS_VALUE = 69;
        private final int value;
        private static final Internal.EnumLiteMap<Event> internalValueMap = new Internal.EnumLiteMap<Event>() { // from class: com.blued.das.login.LoginAndRegisterProtos.Event.1
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
                    return UNKNOWN;
                case 1:
                    return LOGIN_BTN_CLICK;
                case 2:
                    return LOGIN_PAGE_REGISTER_BTN_CLICK;
                case 3:
                    return LOGIN_PAGE_THIRD_LOGIN_BTN_CLICK;
                case 4:
                    return REGISTER_PAGE_REGISTER_BTN_CLICK;
                case 5:
                    return REGISTER_PAGE_THIRD_LOGIN_BTN_CLICK;
                case 6:
                    return AUTHCODE_CONFIRM_BTN_CLICK;
                case 7:
                    return AUTHCODE_RESEND_BTN_CLICK;
                case 8:
                    return PROFILE_WRITE_PAGE_CONFIRM_BTN_CLICK;
                case 9:
                    return REGISTER_SUCCESS;
                case 10:
                    return REC_PAGE_ENTER_BTN_CLICK;
                case 11:
                    return PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CLICK;
                case 12:
                    return PROFILE_WRITE_PAGE_UPLOAD_PHOTO_CONFIRM_CLICK;
                case 13:
                    return PROFILE_WRITE_PAGE_UNIT_BTN_CLICK;
                case 14:
                    return PROFILE_WRITE_PAGE_ROLE_BTN_CLICK;
                case 15:
                    return PERSONAL_LABEL_NEXT_BTN_CLICK;
                case 16:
                    return LIKE_LABEL_NEXT_BTN_CLICK;
                case 17:
                    return RECOMMEND_PAGE_GRID_AVATAR_DRAW;
                case 18:
                    return RECOMMEND_PAGE_POP_UPS_SHOW;
                case 19:
                    return RECOMMEND_PAGE_POP_UPS_FOLLOW_CLICK;
                case 20:
                    return PROFILE_WRITE_PAGE_SHOW;
                case 21:
                    return ONE_CLICK_POP_SHOW;
                case 22:
                    return ONE_CLICK_POP_TRUE_CLICK;
                case 23:
                    return LOGIN_PRIVACY_POP_SHOW;
                case 24:
                    return LOGIN_PRIVACY_POP_AGREE_CLICK;
                case 25:
                    return LOGIN_PRIVACY_POP_DISAGREE_CLICK;
                case 26:
                    return LOGIN_AUTHORITY_POP_SHOW;
                case 27:
                    return LOGIN_AUTHORITY_POP_OPEN_CLICK;
                case 28:
                    return FIND_PWD_BY_PHONE;
                case 29:
                    return FIND_PWD_BY_REG_EMAIL;
                case 30:
                    return FIND_PWD_BY_SAFE_EMAIL;
                case 31:
                    return LOGIN_SUCCESS;
                case 32:
                    return REGISTER_APPLE_ID_BTN_CLICK;
                case 33:
                    return ONE_CLICK_LOGIN_BTN_CLICK;
                case 34:
                    return OPEN_PAGE_CREATE_TO_SHOW_DURATION;
                case 35:
                    return HW_CHANNEL_DATA;
                case 36:
                    return JD_AD_TO_APP;
                case 37:
                    return JD_AD_TO_H5;
                case 38:
                    return OPEN_AD_WORD_CLICK;
                case 39:
                    return OPEN_AD_TIMEOUT;
                case 40:
                    return AD_VIDEO_REQUEST;
                case 41:
                    return AD_VIDEO_RESPONSE;
                case 42:
                    return AD_VIDEO_WANDOU_SUCCESS;
                case 43:
                    return AD_REACH_MAX_REQUEST;
                case 44:
                    return AD_REACH_MAX_RESPONSE;
                case 45:
                    return OPEN_AD_UP_SLIDE;
                case 46:
                    return OPEN_AD_SHAKE;
                case 47:
                    return OTHER_PHONE_LOGIN_CLICK;
                case 48:
                    return AUTHCODE_GET_CLICK;
                case 49:
                    return REGISTER_PHONE_BIND_LIMIT_SHOW;
                case 50:
                    return REGISTER_PHONE_BIND_LIMIT_CANCEL_CLICK;
                case 51:
                    return REGISTER_PHONE_BIND_LIMIT_CHANGE_CLICK;
                case 52:
                    return REGISTER_PROFILE_NICKNAME_SHOW;
                case 53:
                    return REGISTER_PROFILE_BIRTHDAY_SHOW;
                case 54:
                    return REGISTER_PROFILE_ROLE_SHOW;
                case 55:
                    return REGISTER_LABEL_SKIP_CLICK;
                case 56:
                    return REGISTER_LABEL_MY_BODY_SHOW;
                case 57:
                    return REGISTER_LABEL_MY_LABEL_SHOW;
                case 58:
                    return REGISTER_LABEL_MY_PURPOSE_SHOW;
                case 59:
                    return REGISTER_LABEL_HIS_BODY_SHOW;
                case 60:
                    return REGISTER_LABEL_HIS_LABEL_SHOW;
                case 61:
                    return REGISTER_LABEL_MATCH_SHOW;
                case 62:
                    return FLASH_AD_VIDEO_REQUEST;
                case 63:
                    return FLASH_AD_VIDEO_RESPONSE;
                case 64:
                    return FLASH_AD_VIDEO_SUCCESS;
                case 65:
                    return USER_VERIFY_POP_SHOW;
                case 66:
                    return USER_VERIFY_POP_SEND_CLICK;
                case 67:
                    return USER_VERIFY_POP_DONE_CLICK;
                case 68:
                    return USER_VERIFY_POP_FAIL;
                case 69:
                    return USER_VERIFY_POP_SUCCESS;
                case 70:
                    return AD_HOME_BANNER1_REQUEST;
                case 71:
                    return AD_HOME_BANNER1_RESPONSE;
                case 72:
                    return OPEN_AD_REQUEST;
                case 73:
                    return OPEN_AD_RETURN_SUCCESS;
                case 74:
                    return OPEN_AD_RETURN_FAIL;
                case 75:
                    return OPEN_AD_SHOW;
                case 76:
                    return OPEN_AD_SHOW_FAIL;
                case 77:
                    return OPEN_AD_SKIP_CLICK;
                case 78:
                    return OPEN_AD_CLICK;
                case 79:
                    return AD_NATIVE_REQUEST;
                case 80:
                    return AD_NATIVE_RESPONSE;
                case 81:
                    return AD_NATIVE_RESPONSE_FAIL;
                case 82:
                    return PHONE_SHAKE;
                case 83:
                    return AD_OPEN_SHAKE_DONE;
                case 84:
                    return AD_REQUEST_ALL;
                case 85:
                    return AD_REQUEST_SUB;
                case 86:
                    return AD_RETURN_SUCCESS_ALL;
                case 87:
                    return AD_RETURN_SUCCESS_SUB;
                case 88:
                    return AD_RETURN_FAIL_ALL;
                case 89:
                    return AD_RETURN_FAIL_SUB;
                case 90:
                    return AD_BIDDING_SUCCESS_ALL;
                case 91:
                    return AD_BIDDING_SUCCESS_SUB;
                case 92:
                    return AD_BIDDING_FAIL_ALL;
                case 93:
                    return AD_BIDDING_FAIL_SUB;
                case 94:
                    return AD_TIMEOUT;
                case 95:
                    return UNINSTALL_LOGIN_POP_SHOW;
                case 96:
                    return UNINSTALL_LOGIN_POP_YES_CLICK;
                case 97:
                    return UNINSTALL_LOGIN_POP_CHANGE_CLICK;
                case 98:
                    return UNINSTALL_LOGIN_POP_LOGIN_SUCCESS;
                case 99:
                case 101:
                case 102:
                case 103:
                case 105:
                default:
                    return null;
                case 100:
                    return AD_HOME_BANNER1_RESPONSE_FAIL;
                case 104:
                    return AD_API_REQUEST;
                case 106:
                    return AD_SOURCE_DOWNLOAD_SUCCESS;
                case 107:
                    return AD_SOURCE_DOWNLOAD_FAIL;
                case 108:
                    return AD_DOWNLOAD_POP_SHOW;
                case 109:
                    return AD_DOWNLOAD_POP_YES_CLICK;
                case 110:
                    return AD_DOWNLOAD_POP_NO_CLICK;
                case 111:
                    return AD_REQUEST_FAIL;
                case 112:
                    return AD_REQUEST_TIMEOUT;
                case 113:
                    return AD_REQUEST_A;
                case 114:
                    return AD_REQUEST;
                case 115:
                    return AD_SUB_TIMEOUT;
                case 116:
                    return AD_API_REQUEST_SUCCESS;
                case 117:
                    return AD_ADX_SHOW;
                case 118:
                    return AD_ADX_VIEW_SHOW;
                case 119:
                    return AD_SHOW_FAIL;
                case 120:
                    return AD_APPLET_OPEN_POP_SHOW;
                case 121:
                    return AD_APPLET_OPEN_POP_YES_CLICK;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return LoginAndRegisterProtos.getDescriptor().getEnumTypes().get(0);
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/login/LoginAndRegisterProtos$LabelStatus.class */
    public enum LabelStatus implements ProtocolMessageEnum {
        UNKNOWN_LABEL_STATUS(0),
        INITIATIVE_NO(1),
        INITIATIVE_HAVE(2),
        DEFAULT(3),
        UNRECOGNIZED(-1);
        
        public static final int DEFAULT_VALUE = 3;
        public static final int INITIATIVE_HAVE_VALUE = 2;
        public static final int INITIATIVE_NO_VALUE = 1;
        public static final int UNKNOWN_LABEL_STATUS_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<LabelStatus> internalValueMap = new Internal.EnumLiteMap<LabelStatus>() { // from class: com.blued.das.login.LoginAndRegisterProtos.LabelStatus.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public LabelStatus findValueByNumber(int i) {
                return LabelStatus.forNumber(i);
            }
        };
        private static final LabelStatus[] VALUES = values();

        LabelStatus(int i) {
            this.value = i;
        }

        public static LabelStatus forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return DEFAULT;
                    }
                    return INITIATIVE_HAVE;
                }
                return INITIATIVE_NO;
            }
            return UNKNOWN_LABEL_STATUS;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return LoginAndRegisterProtos.getDescriptor().getEnumTypes().get(3);
        }

        public static Internal.EnumLiteMap<LabelStatus> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static LabelStatus valueOf(int i) {
            return forNumber(i);
        }

        public static LabelStatus valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/login/LoginAndRegisterProtos$LabelType.class */
    public enum LabelType implements ProtocolMessageEnum {
        UNKNOWN_LABEL_TYPE(0),
        BODY(1),
        FEATURE(2),
        WANT(3),
        UNRECOGNIZED(-1);
        
        public static final int BODY_VALUE = 1;
        public static final int FEATURE_VALUE = 2;
        public static final int UNKNOWN_LABEL_TYPE_VALUE = 0;
        public static final int WANT_VALUE = 3;
        private final int value;
        private static final Internal.EnumLiteMap<LabelType> internalValueMap = new Internal.EnumLiteMap<LabelType>() { // from class: com.blued.das.login.LoginAndRegisterProtos.LabelType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public LabelType findValueByNumber(int i) {
                return LabelType.forNumber(i);
            }
        };
        private static final LabelType[] VALUES = values();

        LabelType(int i) {
            this.value = i;
        }

        public static LabelType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return WANT;
                    }
                    return FEATURE;
                }
                return BODY;
            }
            return UNKNOWN_LABEL_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return LoginAndRegisterProtos.getDescriptor().getEnumTypes().get(4);
        }

        public static Internal.EnumLiteMap<LabelType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static LabelType valueOf(int i) {
            return forNumber(i);
        }

        public static LabelType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/login/LoginAndRegisterProtos$LoginAndRegisterProto.class */
    public static final class LoginAndRegisterProto extends GeneratedMessageV3 implements LoginAndRegisterProtoOrBuilder {
        public static final int ANGLE_FIELD_NUMBER = 20;
        public static final int CODE_FIELD_NUMBER = 18;
        public static final int DURATION_FIELD_NUMBER = 9;
        public static final int EVENT_FIELD_NUMBER = 1;
        public static final int ID_FIELD_NUMBER = 14;
        public static final int ID_PARENT_FIELD_NUMBER = 27;
        public static final int ID_SUB_FIELD_NUMBER = 26;
        public static final int IS_CALLBACK_FIELD_NUMBER = 11;
        public static final int JSON_FIELD_NUMBER = 13;
        public static final int LABEL_STATUS_FIELD_NUMBER = 4;
        public static final int LABEL_TYPE_FIELD_NUMBER = 8;
        public static final int LAYOUT_FIELD_NUMBER = 32;
        public static final int NBT_FIELD_NUMBER = 28;
        public static final int NUM_FIELD_NUMBER = 22;
        public static final int OP_DURATION_FIELD_NUMBER = 21;
        public static final int OP_TYPE_FIELD_NUMBER = 31;
        public static final int ORI_CHANNEL_FIELD_NUMBER = 12;
        public static final int POSITION_CODE_FIELD_NUMBER = 29;
        public static final int POSITION_FIELD_NUMBER = 17;
        public static final int PRICE_FIELD_NUMBER = 24;
        public static final int PRICE_SECOND_FIELD_NUMBER = 25;
        public static final int REASON_FIELD_NUMBER = 16;
        public static final int REQ_ID_FIELD_NUMBER = 30;
        public static final int ROLE_TYPE_FIELD_NUMBER = 3;
        public static final int SOURCE_FIELD_NUMBER = 7;
        public static final int SPEED_FIELD_NUMBER = 19;
        public static final int TARGET_UID_FIELD_NUMBER = 5;
        public static final int TARGET_UID_LIST_FIELD_NUMBER = 6;
        public static final int THIRD_DURATION_FIELD_NUMBER = 10;
        public static final int THIRD_ID_FIELD_NUMBER = 23;
        public static final int TYPE_FIELD_NUMBER = 15;
        public static final int UNIT_TYPE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private volatile Object angle_;
        private volatile Object code_;
        private int duration_;
        private int event_;
        private volatile Object idParent_;
        private volatile Object idSub_;
        private volatile Object id_;
        private boolean isCallback_;
        private volatile Object json_;
        private int labelStatus_;
        private int labelType_;
        private volatile Object layout_;
        private byte memoizedIsInitialized;
        private volatile Object nbt_;
        private int num_;
        private volatile Object opDuration_;
        private volatile Object opType_;
        private volatile Object oriChannel_;
        private volatile Object positionCode_;
        private volatile Object position_;
        private double priceSecond_;
        private double price_;
        private volatile Object reason_;
        private volatile Object reqId_;
        private int roleType_;
        private int source_;
        private volatile Object speed_;
        private volatile Object targetUidList_;
        private volatile Object targetUid_;
        private int thirdDuration_;
        private volatile Object thirdId_;
        private volatile Object type_;
        private int unitType_;
        private static final LoginAndRegisterProto DEFAULT_INSTANCE = new LoginAndRegisterProto();
        private static final Parser<LoginAndRegisterProto> PARSER = new AbstractParser<LoginAndRegisterProto>() { // from class: com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProto.1
            @Override // com.google.protobuf.Parser
            public LoginAndRegisterProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LoginAndRegisterProto(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/login/LoginAndRegisterProtos$LoginAndRegisterProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LoginAndRegisterProtoOrBuilder {
            private Object angle_;
            private Object code_;
            private int duration_;
            private int event_;
            private Object idParent_;
            private Object idSub_;
            private Object id_;
            private boolean isCallback_;
            private Object json_;
            private int labelStatus_;
            private int labelType_;
            private Object layout_;
            private Object nbt_;
            private int num_;
            private Object opDuration_;
            private Object opType_;
            private Object oriChannel_;
            private Object positionCode_;
            private Object position_;
            private double priceSecond_;
            private double price_;
            private Object reason_;
            private Object reqId_;
            private int roleType_;
            private int source_;
            private Object speed_;
            private Object targetUidList_;
            private Object targetUid_;
            private int thirdDuration_;
            private Object thirdId_;
            private Object type_;
            private int unitType_;

            private Builder() {
                this.event_ = 0;
                this.unitType_ = 0;
                this.roleType_ = 0;
                this.labelStatus_ = 0;
                this.targetUid_ = "";
                this.targetUidList_ = "";
                this.source_ = 0;
                this.labelType_ = 0;
                this.oriChannel_ = "";
                this.json_ = "";
                this.id_ = "";
                this.type_ = "";
                this.reason_ = "";
                this.position_ = "";
                this.code_ = "";
                this.speed_ = "";
                this.angle_ = "";
                this.opDuration_ = "";
                this.thirdId_ = "";
                this.idSub_ = "";
                this.idParent_ = "";
                this.nbt_ = "";
                this.positionCode_ = "";
                this.reqId_ = "";
                this.opType_ = "";
                this.layout_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.event_ = 0;
                this.unitType_ = 0;
                this.roleType_ = 0;
                this.labelStatus_ = 0;
                this.targetUid_ = "";
                this.targetUidList_ = "";
                this.source_ = 0;
                this.labelType_ = 0;
                this.oriChannel_ = "";
                this.json_ = "";
                this.id_ = "";
                this.type_ = "";
                this.reason_ = "";
                this.position_ = "";
                this.code_ = "";
                this.speed_ = "";
                this.angle_ = "";
                this.opDuration_ = "";
                this.thirdId_ = "";
                this.idSub_ = "";
                this.idParent_ = "";
                this.nbt_ = "";
                this.positionCode_ = "";
                this.reqId_ = "";
                this.opType_ = "";
                this.layout_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LoginAndRegisterProtos.internal_static_com_blued_das_login_LoginAndRegisterProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = LoginAndRegisterProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LoginAndRegisterProto build() {
                LoginAndRegisterProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LoginAndRegisterProto buildPartial() {
                LoginAndRegisterProto loginAndRegisterProto = new LoginAndRegisterProto(this);
                loginAndRegisterProto.event_ = this.event_;
                loginAndRegisterProto.unitType_ = this.unitType_;
                loginAndRegisterProto.roleType_ = this.roleType_;
                loginAndRegisterProto.labelStatus_ = this.labelStatus_;
                loginAndRegisterProto.targetUid_ = this.targetUid_;
                loginAndRegisterProto.targetUidList_ = this.targetUidList_;
                loginAndRegisterProto.source_ = this.source_;
                loginAndRegisterProto.labelType_ = this.labelType_;
                loginAndRegisterProto.duration_ = this.duration_;
                loginAndRegisterProto.thirdDuration_ = this.thirdDuration_;
                loginAndRegisterProto.isCallback_ = this.isCallback_;
                loginAndRegisterProto.oriChannel_ = this.oriChannel_;
                loginAndRegisterProto.json_ = this.json_;
                loginAndRegisterProto.id_ = this.id_;
                loginAndRegisterProto.type_ = this.type_;
                loginAndRegisterProto.reason_ = this.reason_;
                loginAndRegisterProto.position_ = this.position_;
                loginAndRegisterProto.code_ = this.code_;
                loginAndRegisterProto.speed_ = this.speed_;
                loginAndRegisterProto.angle_ = this.angle_;
                loginAndRegisterProto.opDuration_ = this.opDuration_;
                loginAndRegisterProto.num_ = this.num_;
                loginAndRegisterProto.thirdId_ = this.thirdId_;
                loginAndRegisterProto.price_ = this.price_;
                loginAndRegisterProto.priceSecond_ = this.priceSecond_;
                loginAndRegisterProto.idSub_ = this.idSub_;
                loginAndRegisterProto.idParent_ = this.idParent_;
                loginAndRegisterProto.nbt_ = this.nbt_;
                loginAndRegisterProto.positionCode_ = this.positionCode_;
                loginAndRegisterProto.reqId_ = this.reqId_;
                loginAndRegisterProto.opType_ = this.opType_;
                loginAndRegisterProto.layout_ = this.layout_;
                onBuilt();
                return loginAndRegisterProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.event_ = 0;
                this.unitType_ = 0;
                this.roleType_ = 0;
                this.labelStatus_ = 0;
                this.targetUid_ = "";
                this.targetUidList_ = "";
                this.source_ = 0;
                this.labelType_ = 0;
                this.duration_ = 0;
                this.thirdDuration_ = 0;
                this.isCallback_ = false;
                this.oriChannel_ = "";
                this.json_ = "";
                this.id_ = "";
                this.type_ = "";
                this.reason_ = "";
                this.position_ = "";
                this.code_ = "";
                this.speed_ = "";
                this.angle_ = "";
                this.opDuration_ = "";
                this.num_ = 0;
                this.thirdId_ = "";
                this.price_ = 0.0d;
                this.priceSecond_ = 0.0d;
                this.idSub_ = "";
                this.idParent_ = "";
                this.nbt_ = "";
                this.positionCode_ = "";
                this.reqId_ = "";
                this.opType_ = "";
                this.layout_ = "";
                return this;
            }

            public Builder clearAngle() {
                this.angle_ = LoginAndRegisterProto.getDefaultInstance().getAngle();
                onChanged();
                return this;
            }

            public Builder clearCode() {
                this.code_ = LoginAndRegisterProto.getDefaultInstance().getCode();
                onChanged();
                return this;
            }

            public Builder clearDuration() {
                this.duration_ = 0;
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

            public Builder clearId() {
                this.id_ = LoginAndRegisterProto.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            public Builder clearIdParent() {
                this.idParent_ = LoginAndRegisterProto.getDefaultInstance().getIdParent();
                onChanged();
                return this;
            }

            public Builder clearIdSub() {
                this.idSub_ = LoginAndRegisterProto.getDefaultInstance().getIdSub();
                onChanged();
                return this;
            }

            public Builder clearIsCallback() {
                this.isCallback_ = false;
                onChanged();
                return this;
            }

            public Builder clearJson() {
                this.json_ = LoginAndRegisterProto.getDefaultInstance().getJson();
                onChanged();
                return this;
            }

            public Builder clearLabelStatus() {
                this.labelStatus_ = 0;
                onChanged();
                return this;
            }

            public Builder clearLabelType() {
                this.labelType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearLayout() {
                this.layout_ = LoginAndRegisterProto.getDefaultInstance().getLayout();
                onChanged();
                return this;
            }

            public Builder clearNbt() {
                this.nbt_ = LoginAndRegisterProto.getDefaultInstance().getNbt();
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

            public Builder clearOpDuration() {
                this.opDuration_ = LoginAndRegisterProto.getDefaultInstance().getOpDuration();
                onChanged();
                return this;
            }

            public Builder clearOpType() {
                this.opType_ = LoginAndRegisterProto.getDefaultInstance().getOpType();
                onChanged();
                return this;
            }

            public Builder clearOriChannel() {
                this.oriChannel_ = LoginAndRegisterProto.getDefaultInstance().getOriChannel();
                onChanged();
                return this;
            }

            public Builder clearPosition() {
                this.position_ = LoginAndRegisterProto.getDefaultInstance().getPosition();
                onChanged();
                return this;
            }

            public Builder clearPositionCode() {
                this.positionCode_ = LoginAndRegisterProto.getDefaultInstance().getPositionCode();
                onChanged();
                return this;
            }

            public Builder clearPrice() {
                this.price_ = 0.0d;
                onChanged();
                return this;
            }

            public Builder clearPriceSecond() {
                this.priceSecond_ = 0.0d;
                onChanged();
                return this;
            }

            public Builder clearReason() {
                this.reason_ = LoginAndRegisterProto.getDefaultInstance().getReason();
                onChanged();
                return this;
            }

            public Builder clearReqId() {
                this.reqId_ = LoginAndRegisterProto.getDefaultInstance().getReqId();
                onChanged();
                return this;
            }

            public Builder clearRoleType() {
                this.roleType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSource() {
                this.source_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSpeed() {
                this.speed_ = LoginAndRegisterProto.getDefaultInstance().getSpeed();
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = LoginAndRegisterProto.getDefaultInstance().getTargetUid();
                onChanged();
                return this;
            }

            public Builder clearTargetUidList() {
                this.targetUidList_ = LoginAndRegisterProto.getDefaultInstance().getTargetUidList();
                onChanged();
                return this;
            }

            public Builder clearThirdDuration() {
                this.thirdDuration_ = 0;
                onChanged();
                return this;
            }

            public Builder clearThirdId() {
                this.thirdId_ = LoginAndRegisterProto.getDefaultInstance().getThirdId();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = LoginAndRegisterProto.getDefaultInstance().getType();
                onChanged();
                return this;
            }

            public Builder clearUnitType() {
                this.unitType_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getAngle() {
                Object obj = this.angle_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.angle_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getAngleBytes() {
                Object obj = this.angle_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.angle_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getCode() {
                Object obj = this.code_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.code_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getCodeBytes() {
                Object obj = this.code_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.code_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LoginAndRegisterProto getDefaultInstanceForType() {
                return LoginAndRegisterProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LoginAndRegisterProtos.internal_static_com_blued_das_login_LoginAndRegisterProto_descriptor;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public int getDuration() {
                return this.duration_;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public Event getEvent() {
                Event valueOf = Event.valueOf(this.event_);
                Event event = valueOf;
                if (valueOf == null) {
                    event = Event.UNRECOGNIZED;
                }
                return event;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public int getEventValue() {
                return this.event_;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getId() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.id_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getIdBytes() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.id_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getIdParent() {
                Object obj = this.idParent_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.idParent_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getIdParentBytes() {
                Object obj = this.idParent_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.idParent_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getIdSub() {
                Object obj = this.idSub_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.idSub_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getIdSubBytes() {
                Object obj = this.idSub_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.idSub_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public boolean getIsCallback() {
                return this.isCallback_;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getJson() {
                Object obj = this.json_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.json_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getJsonBytes() {
                Object obj = this.json_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.json_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public LabelStatus getLabelStatus() {
                LabelStatus valueOf = LabelStatus.valueOf(this.labelStatus_);
                LabelStatus labelStatus = valueOf;
                if (valueOf == null) {
                    labelStatus = LabelStatus.UNRECOGNIZED;
                }
                return labelStatus;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public int getLabelStatusValue() {
                return this.labelStatus_;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public LabelType getLabelType() {
                LabelType valueOf = LabelType.valueOf(this.labelType_);
                LabelType labelType = valueOf;
                if (valueOf == null) {
                    labelType = LabelType.UNRECOGNIZED;
                }
                return labelType;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public int getLabelTypeValue() {
                return this.labelType_;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getLayout() {
                Object obj = this.layout_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.layout_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getLayoutBytes() {
                Object obj = this.layout_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.layout_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getNbt() {
                Object obj = this.nbt_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.nbt_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getNbtBytes() {
                Object obj = this.nbt_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.nbt_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public int getNum() {
                return this.num_;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getOpDuration() {
                Object obj = this.opDuration_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.opDuration_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getOpDurationBytes() {
                Object obj = this.opDuration_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.opDuration_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getOpType() {
                Object obj = this.opType_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.opType_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getOpTypeBytes() {
                Object obj = this.opType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.opType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getOriChannel() {
                Object obj = this.oriChannel_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.oriChannel_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getOriChannelBytes() {
                Object obj = this.oriChannel_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.oriChannel_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getPosition() {
                Object obj = this.position_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.position_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getPositionBytes() {
                Object obj = this.position_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.position_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getPositionCode() {
                Object obj = this.positionCode_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.positionCode_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getPositionCodeBytes() {
                Object obj = this.positionCode_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.positionCode_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public double getPrice() {
                return this.price_;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public double getPriceSecond() {
                return this.priceSecond_;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getReason() {
                Object obj = this.reason_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.reason_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getReasonBytes() {
                Object obj = this.reason_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.reason_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getReqId() {
                Object obj = this.reqId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.reqId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getReqIdBytes() {
                Object obj = this.reqId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.reqId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public RoleType getRoleType() {
                RoleType valueOf = RoleType.valueOf(this.roleType_);
                RoleType roleType = valueOf;
                if (valueOf == null) {
                    roleType = RoleType.UNRECOGNIZED;
                }
                return roleType;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public int getRoleTypeValue() {
                return this.roleType_;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public Source getSource() {
                Source valueOf = Source.valueOf(this.source_);
                Source source = valueOf;
                if (valueOf == null) {
                    source = Source.UNRECOGNIZED;
                }
                return source;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public int getSourceValue() {
                return this.source_;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getSpeed() {
                Object obj = this.speed_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.speed_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getSpeedBytes() {
                Object obj = this.speed_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.speed_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getTargetUid() {
                Object obj = this.targetUid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.targetUid_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getTargetUidBytes() {
                Object obj = this.targetUid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.targetUid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getTargetUidList() {
                Object obj = this.targetUidList_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.targetUidList_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getTargetUidListBytes() {
                Object obj = this.targetUidList_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.targetUidList_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public int getThirdDuration() {
                return this.thirdDuration_;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getThirdId() {
                Object obj = this.thirdId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.thirdId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getThirdIdBytes() {
                Object obj = this.thirdId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.thirdId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public String getType() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.type_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public ByteString getTypeBytes() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.type_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public UnitType getUnitType() {
                UnitType valueOf = UnitType.valueOf(this.unitType_);
                UnitType unitType = valueOf;
                if (valueOf == null) {
                    unitType = UnitType.UNRECOGNIZED;
                }
                return unitType;
            }

            @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
            public int getUnitTypeValue() {
                return this.unitType_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LoginAndRegisterProtos.internal_static_com_blued_das_login_LoginAndRegisterProto_fieldAccessorTable.ensureFieldAccessorsInitialized(LoginAndRegisterProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(LoginAndRegisterProto loginAndRegisterProto) {
                if (loginAndRegisterProto == LoginAndRegisterProto.getDefaultInstance()) {
                    return this;
                }
                if (loginAndRegisterProto.event_ != 0) {
                    setEventValue(loginAndRegisterProto.getEventValue());
                }
                if (loginAndRegisterProto.unitType_ != 0) {
                    setUnitTypeValue(loginAndRegisterProto.getUnitTypeValue());
                }
                if (loginAndRegisterProto.roleType_ != 0) {
                    setRoleTypeValue(loginAndRegisterProto.getRoleTypeValue());
                }
                if (loginAndRegisterProto.labelStatus_ != 0) {
                    setLabelStatusValue(loginAndRegisterProto.getLabelStatusValue());
                }
                if (!loginAndRegisterProto.getTargetUid().isEmpty()) {
                    this.targetUid_ = loginAndRegisterProto.targetUid_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getTargetUidList().isEmpty()) {
                    this.targetUidList_ = loginAndRegisterProto.targetUidList_;
                    onChanged();
                }
                if (loginAndRegisterProto.source_ != 0) {
                    setSourceValue(loginAndRegisterProto.getSourceValue());
                }
                if (loginAndRegisterProto.labelType_ != 0) {
                    setLabelTypeValue(loginAndRegisterProto.getLabelTypeValue());
                }
                if (loginAndRegisterProto.getDuration() != 0) {
                    setDuration(loginAndRegisterProto.getDuration());
                }
                if (loginAndRegisterProto.getThirdDuration() != 0) {
                    setThirdDuration(loginAndRegisterProto.getThirdDuration());
                }
                if (loginAndRegisterProto.getIsCallback()) {
                    setIsCallback(loginAndRegisterProto.getIsCallback());
                }
                if (!loginAndRegisterProto.getOriChannel().isEmpty()) {
                    this.oriChannel_ = loginAndRegisterProto.oriChannel_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getJson().isEmpty()) {
                    this.json_ = loginAndRegisterProto.json_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getId().isEmpty()) {
                    this.id_ = loginAndRegisterProto.id_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getType().isEmpty()) {
                    this.type_ = loginAndRegisterProto.type_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getReason().isEmpty()) {
                    this.reason_ = loginAndRegisterProto.reason_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getPosition().isEmpty()) {
                    this.position_ = loginAndRegisterProto.position_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getCode().isEmpty()) {
                    this.code_ = loginAndRegisterProto.code_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getSpeed().isEmpty()) {
                    this.speed_ = loginAndRegisterProto.speed_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getAngle().isEmpty()) {
                    this.angle_ = loginAndRegisterProto.angle_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getOpDuration().isEmpty()) {
                    this.opDuration_ = loginAndRegisterProto.opDuration_;
                    onChanged();
                }
                if (loginAndRegisterProto.getNum() != 0) {
                    setNum(loginAndRegisterProto.getNum());
                }
                if (!loginAndRegisterProto.getThirdId().isEmpty()) {
                    this.thirdId_ = loginAndRegisterProto.thirdId_;
                    onChanged();
                }
                if (loginAndRegisterProto.getPrice() != 0.0d) {
                    setPrice(loginAndRegisterProto.getPrice());
                }
                if (loginAndRegisterProto.getPriceSecond() != 0.0d) {
                    setPriceSecond(loginAndRegisterProto.getPriceSecond());
                }
                if (!loginAndRegisterProto.getIdSub().isEmpty()) {
                    this.idSub_ = loginAndRegisterProto.idSub_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getIdParent().isEmpty()) {
                    this.idParent_ = loginAndRegisterProto.idParent_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getNbt().isEmpty()) {
                    this.nbt_ = loginAndRegisterProto.nbt_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getPositionCode().isEmpty()) {
                    this.positionCode_ = loginAndRegisterProto.positionCode_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getReqId().isEmpty()) {
                    this.reqId_ = loginAndRegisterProto.reqId_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getOpType().isEmpty()) {
                    this.opType_ = loginAndRegisterProto.opType_;
                    onChanged();
                }
                if (!loginAndRegisterProto.getLayout().isEmpty()) {
                    this.layout_ = loginAndRegisterProto.layout_;
                    onChanged();
                }
                mergeUnknownFields(loginAndRegisterProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProto.access$3900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.login.LoginAndRegisterProtos$LoginAndRegisterProto r0 = (com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.login.LoginAndRegisterProtos$LoginAndRegisterProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.login.LoginAndRegisterProtos$LoginAndRegisterProto r0 = (com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.login.LoginAndRegisterProtos$LoginAndRegisterProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.login.LoginAndRegisterProtos$LoginAndRegisterProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof LoginAndRegisterProto) {
                    return mergeFrom((LoginAndRegisterProto) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setAngle(String str) {
                if (str != null) {
                    this.angle_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAngleBytes(ByteString byteString) {
                if (byteString != null) {
                    LoginAndRegisterProto.checkByteStringIsUtf8(byteString);
                    this.angle_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setCode(String str) {
                if (str != null) {
                    this.code_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setCodeBytes(ByteString byteString) {
                if (byteString != null) {
                    LoginAndRegisterProto.checkByteStringIsUtf8(byteString);
                    this.code_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDuration(int i) {
                this.duration_ = i;
                onChanged();
                return this;
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

            public Builder setId(String str) {
                if (str != null) {
                    this.id_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setIdBytes(ByteString byteString) {
                if (byteString != null) {
                    LoginAndRegisterProto.checkByteStringIsUtf8(byteString);
                    this.id_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setIdParent(String str) {
                if (str != null) {
                    this.idParent_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setIdParentBytes(ByteString byteString) {
                if (byteString != null) {
                    LoginAndRegisterProto.checkByteStringIsUtf8(byteString);
                    this.idParent_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setIdSub(String str) {
                if (str != null) {
                    this.idSub_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setIdSubBytes(ByteString byteString) {
                if (byteString != null) {
                    LoginAndRegisterProto.checkByteStringIsUtf8(byteString);
                    this.idSub_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setIsCallback(boolean z) {
                this.isCallback_ = z;
                onChanged();
                return this;
            }

            public Builder setJson(String str) {
                if (str != null) {
                    this.json_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setJsonBytes(ByteString byteString) {
                if (byteString != null) {
                    LoginAndRegisterProto.checkByteStringIsUtf8(byteString);
                    this.json_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLabelStatus(LabelStatus labelStatus) {
                if (labelStatus != null) {
                    this.labelStatus_ = labelStatus.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLabelStatusValue(int i) {
                this.labelStatus_ = i;
                onChanged();
                return this;
            }

            public Builder setLabelType(LabelType labelType) {
                if (labelType != null) {
                    this.labelType_ = labelType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLabelTypeValue(int i) {
                this.labelType_ = i;
                onChanged();
                return this;
            }

            public Builder setLayout(String str) {
                if (str != null) {
                    this.layout_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLayoutBytes(ByteString byteString) {
                if (byteString != null) {
                    LoginAndRegisterProto.checkByteStringIsUtf8(byteString);
                    this.layout_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setNbt(String str) {
                if (str != null) {
                    this.nbt_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setNbtBytes(ByteString byteString) {
                if (byteString != null) {
                    LoginAndRegisterProto.checkByteStringIsUtf8(byteString);
                    this.nbt_ = byteString;
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

            public Builder setOpDuration(String str) {
                if (str != null) {
                    this.opDuration_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setOpDurationBytes(ByteString byteString) {
                if (byteString != null) {
                    LoginAndRegisterProto.checkByteStringIsUtf8(byteString);
                    this.opDuration_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setOpType(String str) {
                if (str != null) {
                    this.opType_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setOpTypeBytes(ByteString byteString) {
                if (byteString != null) {
                    LoginAndRegisterProto.checkByteStringIsUtf8(byteString);
                    this.opType_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setOriChannel(String str) {
                if (str != null) {
                    this.oriChannel_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setOriChannelBytes(ByteString byteString) {
                if (byteString != null) {
                    LoginAndRegisterProto.checkByteStringIsUtf8(byteString);
                    this.oriChannel_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPosition(String str) {
                if (str != null) {
                    this.position_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPositionBytes(ByteString byteString) {
                if (byteString != null) {
                    LoginAndRegisterProto.checkByteStringIsUtf8(byteString);
                    this.position_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPositionCode(String str) {
                if (str != null) {
                    this.positionCode_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPositionCodeBytes(ByteString byteString) {
                if (byteString != null) {
                    LoginAndRegisterProto.checkByteStringIsUtf8(byteString);
                    this.positionCode_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPrice(double d) {
                this.price_ = d;
                onChanged();
                return this;
            }

            public Builder setPriceSecond(double d) {
                this.priceSecond_ = d;
                onChanged();
                return this;
            }

            public Builder setReason(String str) {
                if (str != null) {
                    this.reason_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setReasonBytes(ByteString byteString) {
                if (byteString != null) {
                    LoginAndRegisterProto.checkByteStringIsUtf8(byteString);
                    this.reason_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setReqId(String str) {
                if (str != null) {
                    this.reqId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setReqIdBytes(ByteString byteString) {
                if (byteString != null) {
                    LoginAndRegisterProto.checkByteStringIsUtf8(byteString);
                    this.reqId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRoleType(RoleType roleType) {
                if (roleType != null) {
                    this.roleType_ = roleType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRoleTypeValue(int i) {
                this.roleType_ = i;
                onChanged();
                return this;
            }

            public Builder setSource(Source source) {
                if (source != null) {
                    this.source_ = source.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setSourceValue(int i) {
                this.source_ = i;
                onChanged();
                return this;
            }

            public Builder setSpeed(String str) {
                if (str != null) {
                    this.speed_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setSpeedBytes(ByteString byteString) {
                if (byteString != null) {
                    LoginAndRegisterProto.checkByteStringIsUtf8(byteString);
                    this.speed_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTargetUid(String str) {
                if (str != null) {
                    this.targetUid_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTargetUidBytes(ByteString byteString) {
                if (byteString != null) {
                    LoginAndRegisterProto.checkByteStringIsUtf8(byteString);
                    this.targetUid_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTargetUidList(String str) {
                if (str != null) {
                    this.targetUidList_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTargetUidListBytes(ByteString byteString) {
                if (byteString != null) {
                    LoginAndRegisterProto.checkByteStringIsUtf8(byteString);
                    this.targetUidList_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setThirdDuration(int i) {
                this.thirdDuration_ = i;
                onChanged();
                return this;
            }

            public Builder setThirdId(String str) {
                if (str != null) {
                    this.thirdId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setThirdIdBytes(ByteString byteString) {
                if (byteString != null) {
                    LoginAndRegisterProto.checkByteStringIsUtf8(byteString);
                    this.thirdId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setType(String str) {
                if (str != null) {
                    this.type_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTypeBytes(ByteString byteString) {
                if (byteString != null) {
                    LoginAndRegisterProto.checkByteStringIsUtf8(byteString);
                    this.type_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setUnitType(UnitType unitType) {
                if (unitType != null) {
                    this.unitType_ = unitType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setUnitTypeValue(int i) {
                this.unitType_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private LoginAndRegisterProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.event_ = 0;
            this.unitType_ = 0;
            this.roleType_ = 0;
            this.labelStatus_ = 0;
            this.targetUid_ = "";
            this.targetUidList_ = "";
            this.source_ = 0;
            this.labelType_ = 0;
            this.oriChannel_ = "";
            this.json_ = "";
            this.id_ = "";
            this.type_ = "";
            this.reason_ = "";
            this.position_ = "";
            this.code_ = "";
            this.speed_ = "";
            this.angle_ = "";
            this.opDuration_ = "";
            this.thirdId_ = "";
            this.idSub_ = "";
            this.idParent_ = "";
            this.nbt_ = "";
            this.positionCode_ = "";
            this.reqId_ = "";
            this.opType_ = "";
            this.layout_ = "";
        }

        private LoginAndRegisterProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                case 16:
                                    this.unitType_ = codedInputStream.readEnum();
                                    continue;
                                case 24:
                                    this.roleType_ = codedInputStream.readEnum();
                                    continue;
                                case 32:
                                    this.labelStatus_ = codedInputStream.readEnum();
                                    continue;
                                case 42:
                                    this.targetUid_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 50:
                                    this.targetUidList_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 56:
                                    this.source_ = codedInputStream.readEnum();
                                    continue;
                                case 64:
                                    this.labelType_ = codedInputStream.readEnum();
                                    continue;
                                case 72:
                                    this.duration_ = codedInputStream.readInt32();
                                    continue;
                                case 80:
                                    this.thirdDuration_ = codedInputStream.readInt32();
                                    continue;
                                case 88:
                                    this.isCallback_ = codedInputStream.readBool();
                                    continue;
                                case 98:
                                    this.oriChannel_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 106:
                                    this.json_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 114:
                                    this.id_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 122:
                                    this.type_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 130:
                                    this.reason_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 138:
                                    this.position_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 146:
                                    this.code_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 154:
                                    this.speed_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 162:
                                    this.angle_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 170:
                                    this.opDuration_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 176:
                                    this.num_ = codedInputStream.readInt32();
                                    continue;
                                case 186:
                                    this.thirdId_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 193:
                                    this.price_ = codedInputStream.readDouble();
                                    continue;
                                case 201:
                                    this.priceSecond_ = codedInputStream.readDouble();
                                    continue;
                                case 210:
                                    this.idSub_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 218:
                                    this.idParent_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 226:
                                    this.nbt_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 234:
                                    this.positionCode_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 242:
                                    this.reqId_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 250:
                                    this.opType_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 258:
                                    this.layout_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                default:
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                        break;
                                    } else {
                                        continue;
                                    }
                            }
                            z = true;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        private LoginAndRegisterProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static LoginAndRegisterProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LoginAndRegisterProtos.internal_static_com_blued_das_login_LoginAndRegisterProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LoginAndRegisterProto loginAndRegisterProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(loginAndRegisterProto);
        }

        public static LoginAndRegisterProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LoginAndRegisterProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LoginAndRegisterProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LoginAndRegisterProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LoginAndRegisterProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LoginAndRegisterProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LoginAndRegisterProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LoginAndRegisterProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LoginAndRegisterProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LoginAndRegisterProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static LoginAndRegisterProto parseFrom(InputStream inputStream) throws IOException {
            return (LoginAndRegisterProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LoginAndRegisterProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LoginAndRegisterProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LoginAndRegisterProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static LoginAndRegisterProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static LoginAndRegisterProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LoginAndRegisterProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<LoginAndRegisterProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof LoginAndRegisterProto) {
                LoginAndRegisterProto loginAndRegisterProto = (LoginAndRegisterProto) obj;
                return this.event_ == loginAndRegisterProto.event_ && this.unitType_ == loginAndRegisterProto.unitType_ && this.roleType_ == loginAndRegisterProto.roleType_ && this.labelStatus_ == loginAndRegisterProto.labelStatus_ && getTargetUid().equals(loginAndRegisterProto.getTargetUid()) && getTargetUidList().equals(loginAndRegisterProto.getTargetUidList()) && this.source_ == loginAndRegisterProto.source_ && this.labelType_ == loginAndRegisterProto.labelType_ && getDuration() == loginAndRegisterProto.getDuration() && getThirdDuration() == loginAndRegisterProto.getThirdDuration() && getIsCallback() == loginAndRegisterProto.getIsCallback() && getOriChannel().equals(loginAndRegisterProto.getOriChannel()) && getJson().equals(loginAndRegisterProto.getJson()) && getId().equals(loginAndRegisterProto.getId()) && getType().equals(loginAndRegisterProto.getType()) && getReason().equals(loginAndRegisterProto.getReason()) && getPosition().equals(loginAndRegisterProto.getPosition()) && getCode().equals(loginAndRegisterProto.getCode()) && getSpeed().equals(loginAndRegisterProto.getSpeed()) && getAngle().equals(loginAndRegisterProto.getAngle()) && getOpDuration().equals(loginAndRegisterProto.getOpDuration()) && getNum() == loginAndRegisterProto.getNum() && getThirdId().equals(loginAndRegisterProto.getThirdId()) && Double.doubleToLongBits(getPrice()) == Double.doubleToLongBits(loginAndRegisterProto.getPrice()) && Double.doubleToLongBits(getPriceSecond()) == Double.doubleToLongBits(loginAndRegisterProto.getPriceSecond()) && getIdSub().equals(loginAndRegisterProto.getIdSub()) && getIdParent().equals(loginAndRegisterProto.getIdParent()) && getNbt().equals(loginAndRegisterProto.getNbt()) && getPositionCode().equals(loginAndRegisterProto.getPositionCode()) && getReqId().equals(loginAndRegisterProto.getReqId()) && getOpType().equals(loginAndRegisterProto.getOpType()) && getLayout().equals(loginAndRegisterProto.getLayout()) && this.unknownFields.equals(loginAndRegisterProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getAngle() {
            Object obj = this.angle_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.angle_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getAngleBytes() {
            Object obj = this.angle_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.angle_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getCode() {
            Object obj = this.code_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.code_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getCodeBytes() {
            Object obj = this.code_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.code_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LoginAndRegisterProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public int getDuration() {
            return this.duration_;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public Event getEvent() {
            Event valueOf = Event.valueOf(this.event_);
            Event event = valueOf;
            if (valueOf == null) {
                event = Event.UNRECOGNIZED;
            }
            return event;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public int getEventValue() {
            return this.event_;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getId() {
            Object obj = this.id_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.id_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getIdBytes() {
            Object obj = this.id_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.id_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getIdParent() {
            Object obj = this.idParent_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.idParent_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getIdParentBytes() {
            Object obj = this.idParent_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.idParent_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getIdSub() {
            Object obj = this.idSub_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.idSub_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getIdSubBytes() {
            Object obj = this.idSub_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.idSub_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public boolean getIsCallback() {
            return this.isCallback_;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getJson() {
            Object obj = this.json_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.json_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getJsonBytes() {
            Object obj = this.json_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.json_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public LabelStatus getLabelStatus() {
            LabelStatus valueOf = LabelStatus.valueOf(this.labelStatus_);
            LabelStatus labelStatus = valueOf;
            if (valueOf == null) {
                labelStatus = LabelStatus.UNRECOGNIZED;
            }
            return labelStatus;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public int getLabelStatusValue() {
            return this.labelStatus_;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public LabelType getLabelType() {
            LabelType valueOf = LabelType.valueOf(this.labelType_);
            LabelType labelType = valueOf;
            if (valueOf == null) {
                labelType = LabelType.UNRECOGNIZED;
            }
            return labelType;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public int getLabelTypeValue() {
            return this.labelType_;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getLayout() {
            Object obj = this.layout_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.layout_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getLayoutBytes() {
            Object obj = this.layout_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.layout_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getNbt() {
            Object obj = this.nbt_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.nbt_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getNbtBytes() {
            Object obj = this.nbt_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.nbt_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public int getNum() {
            return this.num_;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getOpDuration() {
            Object obj = this.opDuration_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.opDuration_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getOpDurationBytes() {
            Object obj = this.opDuration_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.opDuration_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getOpType() {
            Object obj = this.opType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.opType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getOpTypeBytes() {
            Object obj = this.opType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.opType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getOriChannel() {
            Object obj = this.oriChannel_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.oriChannel_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getOriChannelBytes() {
            Object obj = this.oriChannel_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.oriChannel_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LoginAndRegisterProto> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getPosition() {
            Object obj = this.position_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.position_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getPositionBytes() {
            Object obj = this.position_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.position_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getPositionCode() {
            Object obj = this.positionCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.positionCode_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getPositionCodeBytes() {
            Object obj = this.positionCode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.positionCode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public double getPrice() {
            return this.price_;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public double getPriceSecond() {
            return this.priceSecond_;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getReason() {
            Object obj = this.reason_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.reason_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getReasonBytes() {
            Object obj = this.reason_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.reason_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getReqId() {
            Object obj = this.reqId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.reqId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getReqIdBytes() {
            Object obj = this.reqId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.reqId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public RoleType getRoleType() {
            RoleType valueOf = RoleType.valueOf(this.roleType_);
            RoleType roleType = valueOf;
            if (valueOf == null) {
                roleType = RoleType.UNRECOGNIZED;
            }
            return roleType;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public int getRoleTypeValue() {
            return this.roleType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.event_ != Event.UNKNOWN.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.event_);
            }
            int i3 = i2;
            if (this.unitType_ != UnitType.UNKNOWN_UNIT_TYPE.getNumber()) {
                i3 = i2 + CodedOutputStream.computeEnumSize(2, this.unitType_);
            }
            int i4 = i3;
            if (this.roleType_ != RoleType.UNKNOWN_ROLE_TYPE.getNumber()) {
                i4 = i3 + CodedOutputStream.computeEnumSize(3, this.roleType_);
            }
            int i5 = i4;
            if (this.labelStatus_ != LabelStatus.UNKNOWN_LABEL_STATUS.getNumber()) {
                i5 = i4 + CodedOutputStream.computeEnumSize(4, this.labelStatus_);
            }
            int i6 = i5;
            if (!getTargetUidBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(5, this.targetUid_);
            }
            int i7 = i6;
            if (!getTargetUidListBytes().isEmpty()) {
                i7 = i6 + GeneratedMessageV3.computeStringSize(6, this.targetUidList_);
            }
            int i8 = i7;
            if (this.source_ != Source.UNKNOWN_SOURCE.getNumber()) {
                i8 = i7 + CodedOutputStream.computeEnumSize(7, this.source_);
            }
            int i9 = i8;
            if (this.labelType_ != LabelType.UNKNOWN_LABEL_TYPE.getNumber()) {
                i9 = i8 + CodedOutputStream.computeEnumSize(8, this.labelType_);
            }
            int i10 = this.duration_;
            int i11 = i9;
            if (i10 != 0) {
                i11 = i9 + CodedOutputStream.computeInt32Size(9, i10);
            }
            int i12 = this.thirdDuration_;
            int i13 = i11;
            if (i12 != 0) {
                i13 = i11 + CodedOutputStream.computeInt32Size(10, i12);
            }
            boolean z = this.isCallback_;
            int i14 = i13;
            if (z) {
                i14 = i13 + CodedOutputStream.computeBoolSize(11, z);
            }
            int i15 = i14;
            if (!getOriChannelBytes().isEmpty()) {
                i15 = i14 + GeneratedMessageV3.computeStringSize(12, this.oriChannel_);
            }
            int i16 = i15;
            if (!getJsonBytes().isEmpty()) {
                i16 = i15 + GeneratedMessageV3.computeStringSize(13, this.json_);
            }
            int i17 = i16;
            if (!getIdBytes().isEmpty()) {
                i17 = i16 + GeneratedMessageV3.computeStringSize(14, this.id_);
            }
            int i18 = i17;
            if (!getTypeBytes().isEmpty()) {
                i18 = i17 + GeneratedMessageV3.computeStringSize(15, this.type_);
            }
            int i19 = i18;
            if (!getReasonBytes().isEmpty()) {
                i19 = i18 + GeneratedMessageV3.computeStringSize(16, this.reason_);
            }
            int i20 = i19;
            if (!getPositionBytes().isEmpty()) {
                i20 = i19 + GeneratedMessageV3.computeStringSize(17, this.position_);
            }
            int i21 = i20;
            if (!getCodeBytes().isEmpty()) {
                i21 = i20 + GeneratedMessageV3.computeStringSize(18, this.code_);
            }
            int i22 = i21;
            if (!getSpeedBytes().isEmpty()) {
                i22 = i21 + GeneratedMessageV3.computeStringSize(19, this.speed_);
            }
            int i23 = i22;
            if (!getAngleBytes().isEmpty()) {
                i23 = i22 + GeneratedMessageV3.computeStringSize(20, this.angle_);
            }
            int i24 = i23;
            if (!getOpDurationBytes().isEmpty()) {
                i24 = i23 + GeneratedMessageV3.computeStringSize(21, this.opDuration_);
            }
            int i25 = this.num_;
            int i26 = i24;
            if (i25 != 0) {
                i26 = i24 + CodedOutputStream.computeInt32Size(22, i25);
            }
            int i27 = i26;
            if (!getThirdIdBytes().isEmpty()) {
                i27 = i26 + GeneratedMessageV3.computeStringSize(23, this.thirdId_);
            }
            double d = this.price_;
            int i28 = i27;
            if (d != 0.0d) {
                i28 = i27 + CodedOutputStream.computeDoubleSize(24, d);
            }
            double d2 = this.priceSecond_;
            int i29 = i28;
            if (d2 != 0.0d) {
                i29 = i28 + CodedOutputStream.computeDoubleSize(25, d2);
            }
            int i30 = i29;
            if (!getIdSubBytes().isEmpty()) {
                i30 = i29 + GeneratedMessageV3.computeStringSize(26, this.idSub_);
            }
            int i31 = i30;
            if (!getIdParentBytes().isEmpty()) {
                i31 = i30 + GeneratedMessageV3.computeStringSize(27, this.idParent_);
            }
            int i32 = i31;
            if (!getNbtBytes().isEmpty()) {
                i32 = i31 + GeneratedMessageV3.computeStringSize(28, this.nbt_);
            }
            int i33 = i32;
            if (!getPositionCodeBytes().isEmpty()) {
                i33 = i32 + GeneratedMessageV3.computeStringSize(29, this.positionCode_);
            }
            int i34 = i33;
            if (!getReqIdBytes().isEmpty()) {
                i34 = i33 + GeneratedMessageV3.computeStringSize(30, this.reqId_);
            }
            int i35 = i34;
            if (!getOpTypeBytes().isEmpty()) {
                i35 = i34 + GeneratedMessageV3.computeStringSize(31, this.opType_);
            }
            int i36 = i35;
            if (!getLayoutBytes().isEmpty()) {
                i36 = i35 + GeneratedMessageV3.computeStringSize(32, this.layout_);
            }
            int serializedSize = i36 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public Source getSource() {
            Source valueOf = Source.valueOf(this.source_);
            Source source = valueOf;
            if (valueOf == null) {
                source = Source.UNRECOGNIZED;
            }
            return source;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public int getSourceValue() {
            return this.source_;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getSpeed() {
            Object obj = this.speed_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.speed_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getSpeedBytes() {
            Object obj = this.speed_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.speed_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getTargetUid() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.targetUid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getTargetUidBytes() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.targetUid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getTargetUidList() {
            Object obj = this.targetUidList_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.targetUidList_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getTargetUidListBytes() {
            Object obj = this.targetUidList_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.targetUidList_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public int getThirdDuration() {
            return this.thirdDuration_;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getThirdId() {
            Object obj = this.thirdId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.thirdId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getThirdIdBytes() {
            Object obj = this.thirdId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.thirdId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public String getType() {
            Object obj = this.type_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.type_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public ByteString getTypeBytes() {
            Object obj = this.type_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public UnitType getUnitType() {
            UnitType valueOf = UnitType.valueOf(this.unitType_);
            UnitType unitType = valueOf;
            if (valueOf == null) {
                unitType = UnitType.UNRECOGNIZED;
            }
            return unitType;
        }

        @Override // com.blued.das.login.LoginAndRegisterProtos.LoginAndRegisterProtoOrBuilder
        public int getUnitTypeValue() {
            return this.unitType_;
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
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.event_) * 37) + 2) * 53) + this.unitType_) * 37) + 3) * 53) + this.roleType_) * 37) + 4) * 53) + this.labelStatus_) * 37) + 5) * 53) + getTargetUid().hashCode()) * 37) + 6) * 53) + getTargetUidList().hashCode()) * 37) + 7) * 53) + this.source_) * 37) + 8) * 53) + this.labelType_) * 37) + 9) * 53) + getDuration()) * 37) + 10) * 53) + getThirdDuration()) * 37) + 11) * 53) + Internal.hashBoolean(getIsCallback())) * 37) + 12) * 53) + getOriChannel().hashCode()) * 37) + 13) * 53) + getJson().hashCode()) * 37) + 14) * 53) + getId().hashCode()) * 37) + 15) * 53) + getType().hashCode()) * 37) + 16) * 53) + getReason().hashCode()) * 37) + 17) * 53) + getPosition().hashCode()) * 37) + 18) * 53) + getCode().hashCode()) * 37) + 19) * 53) + getSpeed().hashCode()) * 37) + 20) * 53) + getAngle().hashCode()) * 37) + 21) * 53) + getOpDuration().hashCode()) * 37) + 22) * 53) + getNum()) * 37) + 23) * 53) + getThirdId().hashCode()) * 37) + 24) * 53) + Internal.hashLong(Double.doubleToLongBits(getPrice()))) * 37) + 25) * 53) + Internal.hashLong(Double.doubleToLongBits(getPriceSecond()))) * 37) + 26) * 53) + getIdSub().hashCode()) * 37) + 27) * 53) + getIdParent().hashCode()) * 37) + 28) * 53) + getNbt().hashCode()) * 37) + 29) * 53) + getPositionCode().hashCode()) * 37) + 30) * 53) + getReqId().hashCode()) * 37) + 31) * 53) + getOpType().hashCode()) * 37) + 32) * 53) + getLayout().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LoginAndRegisterProtos.internal_static_com_blued_das_login_LoginAndRegisterProto_fieldAccessorTable.ensureFieldAccessorsInitialized(LoginAndRegisterProto.class, Builder.class);
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
            return new LoginAndRegisterProto();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.event_ != Event.UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(1, this.event_);
            }
            if (this.unitType_ != UnitType.UNKNOWN_UNIT_TYPE.getNumber()) {
                codedOutputStream.writeEnum(2, this.unitType_);
            }
            if (this.roleType_ != RoleType.UNKNOWN_ROLE_TYPE.getNumber()) {
                codedOutputStream.writeEnum(3, this.roleType_);
            }
            if (this.labelStatus_ != LabelStatus.UNKNOWN_LABEL_STATUS.getNumber()) {
                codedOutputStream.writeEnum(4, this.labelStatus_);
            }
            if (!getTargetUidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.targetUid_);
            }
            if (!getTargetUidListBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.targetUidList_);
            }
            if (this.source_ != Source.UNKNOWN_SOURCE.getNumber()) {
                codedOutputStream.writeEnum(7, this.source_);
            }
            if (this.labelType_ != LabelType.UNKNOWN_LABEL_TYPE.getNumber()) {
                codedOutputStream.writeEnum(8, this.labelType_);
            }
            int i = this.duration_;
            if (i != 0) {
                codedOutputStream.writeInt32(9, i);
            }
            int i2 = this.thirdDuration_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(10, i2);
            }
            boolean z = this.isCallback_;
            if (z) {
                codedOutputStream.writeBool(11, z);
            }
            if (!getOriChannelBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 12, this.oriChannel_);
            }
            if (!getJsonBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 13, this.json_);
            }
            if (!getIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 14, this.id_);
            }
            if (!getTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 15, this.type_);
            }
            if (!getReasonBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 16, this.reason_);
            }
            if (!getPositionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 17, this.position_);
            }
            if (!getCodeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 18, this.code_);
            }
            if (!getSpeedBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 19, this.speed_);
            }
            if (!getAngleBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 20, this.angle_);
            }
            if (!getOpDurationBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 21, this.opDuration_);
            }
            int i3 = this.num_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(22, i3);
            }
            if (!getThirdIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 23, this.thirdId_);
            }
            double d = this.price_;
            if (d != 0.0d) {
                codedOutputStream.writeDouble(24, d);
            }
            double d2 = this.priceSecond_;
            if (d2 != 0.0d) {
                codedOutputStream.writeDouble(25, d2);
            }
            if (!getIdSubBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 26, this.idSub_);
            }
            if (!getIdParentBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 27, this.idParent_);
            }
            if (!getNbtBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 28, this.nbt_);
            }
            if (!getPositionCodeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 29, this.positionCode_);
            }
            if (!getReqIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 30, this.reqId_);
            }
            if (!getOpTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 31, this.opType_);
            }
            if (!getLayoutBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 32, this.layout_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/login/LoginAndRegisterProtos$LoginAndRegisterProtoOrBuilder.class */
    public interface LoginAndRegisterProtoOrBuilder extends MessageOrBuilder {
        String getAngle();

        ByteString getAngleBytes();

        String getCode();

        ByteString getCodeBytes();

        int getDuration();

        Event getEvent();

        int getEventValue();

        String getId();

        ByteString getIdBytes();

        String getIdParent();

        ByteString getIdParentBytes();

        String getIdSub();

        ByteString getIdSubBytes();

        boolean getIsCallback();

        String getJson();

        ByteString getJsonBytes();

        LabelStatus getLabelStatus();

        int getLabelStatusValue();

        LabelType getLabelType();

        int getLabelTypeValue();

        String getLayout();

        ByteString getLayoutBytes();

        String getNbt();

        ByteString getNbtBytes();

        int getNum();

        String getOpDuration();

        ByteString getOpDurationBytes();

        String getOpType();

        ByteString getOpTypeBytes();

        String getOriChannel();

        ByteString getOriChannelBytes();

        String getPosition();

        ByteString getPositionBytes();

        String getPositionCode();

        ByteString getPositionCodeBytes();

        double getPrice();

        double getPriceSecond();

        String getReason();

        ByteString getReasonBytes();

        String getReqId();

        ByteString getReqIdBytes();

        RoleType getRoleType();

        int getRoleTypeValue();

        Source getSource();

        int getSourceValue();

        String getSpeed();

        ByteString getSpeedBytes();

        String getTargetUid();

        ByteString getTargetUidBytes();

        String getTargetUidList();

        ByteString getTargetUidListBytes();

        int getThirdDuration();

        String getThirdId();

        ByteString getThirdIdBytes();

        String getType();

        ByteString getTypeBytes();

        UnitType getUnitType();

        int getUnitTypeValue();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/login/LoginAndRegisterProtos$RoleType.class */
    public enum RoleType implements ProtocolMessageEnum {
        UNKNOWN_ROLE_TYPE(0),
        ONE(1),
        ZERO(2),
        HARF(3),
        OTHER(4),
        UNRECOGNIZED(-1);
        
        public static final int HARF_VALUE = 3;
        public static final int ONE_VALUE = 1;
        public static final int OTHER_VALUE = 4;
        public static final int UNKNOWN_ROLE_TYPE_VALUE = 0;
        public static final int ZERO_VALUE = 2;
        private final int value;
        private static final Internal.EnumLiteMap<RoleType> internalValueMap = new Internal.EnumLiteMap<RoleType>() { // from class: com.blued.das.login.LoginAndRegisterProtos.RoleType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public RoleType findValueByNumber(int i) {
                return RoleType.forNumber(i);
            }
        };
        private static final RoleType[] VALUES = values();

        RoleType(int i) {
            this.value = i;
        }

        public static RoleType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return null;
                            }
                            return OTHER;
                        }
                        return HARF;
                    }
                    return ZERO;
                }
                return ONE;
            }
            return UNKNOWN_ROLE_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return LoginAndRegisterProtos.getDescriptor().getEnumTypes().get(2);
        }

        public static Internal.EnumLiteMap<RoleType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static RoleType valueOf(int i) {
            return forNumber(i);
        }

        public static RoleType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/login/LoginAndRegisterProtos$Source.class */
    public enum Source implements ProtocolMessageEnum {
        UNKNOWN_SOURCE(0),
        PHONE(1),
        WECHAT(2),
        APPLE(3),
        ONE_CLICK(4),
        EMAIL(5),
        PHONE_CODE(6),
        UNRECOGNIZED(-1);
        
        public static final int APPLE_VALUE = 3;
        public static final int EMAIL_VALUE = 5;
        public static final int ONE_CLICK_VALUE = 4;
        public static final int PHONE_CODE_VALUE = 6;
        public static final int PHONE_VALUE = 1;
        public static final int UNKNOWN_SOURCE_VALUE = 0;
        public static final int WECHAT_VALUE = 2;
        private final int value;
        private static final Internal.EnumLiteMap<Source> internalValueMap = new Internal.EnumLiteMap<Source>() { // from class: com.blued.das.login.LoginAndRegisterProtos.Source.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Source findValueByNumber(int i) {
                return Source.forNumber(i);
            }
        };
        private static final Source[] VALUES = values();

        Source(int i) {
            this.value = i;
        }

        public static Source forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_SOURCE;
                case 1:
                    return PHONE;
                case 2:
                    return WECHAT;
                case 3:
                    return APPLE;
                case 4:
                    return ONE_CLICK;
                case 5:
                    return EMAIL;
                case 6:
                    return PHONE_CODE;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return LoginAndRegisterProtos.getDescriptor().getEnumTypes().get(5);
        }

        public static Internal.EnumLiteMap<Source> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Source valueOf(int i) {
            return forNumber(i);
        }

        public static Source valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/login/LoginAndRegisterProtos$UnitType.class */
    public enum UnitType implements ProtocolMessageEnum {
        UNKNOWN_UNIT_TYPE(0),
        FT_LB(1),
        CM_KG(2),
        UNRECOGNIZED(-1);
        
        public static final int CM_KG_VALUE = 2;
        public static final int FT_LB_VALUE = 1;
        public static final int UNKNOWN_UNIT_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<UnitType> internalValueMap = new Internal.EnumLiteMap<UnitType>() { // from class: com.blued.das.login.LoginAndRegisterProtos.UnitType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public UnitType findValueByNumber(int i) {
                return UnitType.forNumber(i);
            }
        };
        private static final UnitType[] VALUES = values();

        UnitType(int i) {
            this.value = i;
        }

        public static UnitType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return CM_KG;
                }
                return FT_LB;
            }
            return UNKNOWN_UNIT_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return LoginAndRegisterProtos.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<UnitType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static UnitType valueOf(int i) {
            return forNumber(i);
        }

        public static UnitType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_das_login_LoginAndRegisterProto_descriptor = descriptor2;
        internal_static_com_blued_das_login_LoginAndRegisterProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Event", "UnitType", "RoleType", "LabelStatus", "TargetUid", "TargetUidList", "Source", "LabelType", "Duration", "ThirdDuration", "IsCallback", "OriChannel", "Json", "Id", "Type", "Reason", "Position", "Code", "Speed", "Angle", "OpDuration", "Num", "ThirdId", "Price", "PriceSecond", "IdSub", "IdParent", "Nbt", "PositionCode", "ReqId", "OpType", "Layout"});
    }

    private LoginAndRegisterProtos() {
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
