package com.blued.das.profile;

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

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/profile/PersonalProfileProtos.class */
public final class PersonalProfileProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bPersonalProfileProtos.proto\u0012\u0015com.blued.das.profile\"£\t\n\u0014PersonalProfileProto\u0012+\n\u0005event\u0018\u0001 \u0001(\u000e2\u001c.com.blued.das.profile.Event\u0012-\n\u0006source\u0018\u0002 \u0001(\u000e2\u001d.com.blued.das.profile.Source\u0012\u0012\n\ntarget_uid\u0018\u0003 \u0001(\t\u00122\n\tshow_type\u0018\u0005 \u0001(\u000e2\u001f.com.blued.das.profile.ShowType\u0012\u0010\n\bdistance\u0018\u0006 \u0001(\t\u0012\u0013\n\u000bonline_time\u0018\u0007 \u0001(\t\u0012\u000e\n\u0006reason\u0018\b \u0001(\u0005\u0012\r\n\u0005label\u0018\t \u0001(\t\u0012\u0011\n\tphoto_num\u0018\n \u0001(\u0005\u0012\u001a\n\u0012is_appreciate_call\u0018\u000b \u0001(\b\u0012\u0019\n\u0011is_super_exposure\u0018\f \u0001(\b\u0012\u000f\n\u0007gift_id\u0018\r \u0001(\t\u00120\n\btab_type\u0018\u000e \u0001(\u000e2\u001e.com.blued.das.profile.TabType\u00126\n\u000bvote_option\u0018\u000f \u0001(\u000e2!.com.blued.das.profile.VoteOption\u00122\n\tgift_from\u0018\u0010 \u0001(\u000e2\u001f.com.blued.das.profile.GiftFrom\u0012\u0010\n\blink_url\u0018\u0011 \u0001(\t\u0012\u000f\n\u0007feed_id\u0018\u0012 \u0001(\t\u0012G\n\u0014target_identity_type\u0018\u0013 \u0001(\u000e2).com.blued.das.profile.TargetIdentityType\u0012\u0013\n\u000bis_map_find\u0018\u0014 \u0001(\b\u0012\u0011\n\tis_shadow\u0018\u0015 \u0001(\b\u0012\u0015\n\ris_quiet_call\u0018\u0016 \u0001(\b\u0012\u0011\n\tis_follow\u0018\u0017 \u0001(\b\u0012\u0014\n\fidentity_num\u0018\u0018 \u0001(\u0005\u0012\u000f\n\u0007is_open\u0018\u0019 \u0001(\b\u0012\u0010\n\bis_video\u0018\u001a \u0001(\b\u0012\u000e\n\u0006is_bag\u0018\u001b \u0001(\b\u0012\n\n\u0002id\u0018\u001c \u0001(\t\u0012\u000f\n\u0007live_id\u0018\u001d \u0001(\t\u0012\u0010\n\bposition\u0018\u001e \u0001(\u0005\u0012\f\n\u0004type\u0018\u001f \u0001(\u0005\u0012\u000b\n\u0003url\u0018  \u0001(\t\u0012\r\n\u0005is_ai\u0018! \u0001(\b\u00126\n\u000bfilter_type\u0018\" \u0001(\u000e2!.com.blued.das.profile.FilterType\u0012\f\n\u0004name\u0018# \u0001(\t\u0012\u000f\n\u0007is_icon\u0018$ \u0001(\b\u0012\u000e\n\u0006is_hot\u0018% \u0001(\b\u0012\u0012\n\nis_special\u0018& \u0001(\b\u0012\f\n\u0004mode\u0018' \u0001(\t\u0012\u0010\n\bstrategy\u0018( \u0001(\t\u0012\u000f\n\u0007virtual\u0018) \u0001(\u0005\u0012\u000f\n\u0007is_true\u0018* \u0001(\b\u0012\u000e\n\u0006is_new\u0018+ \u0001(\b\u0012\u0015\n\ris_super_call\u0018, \u0001(\b\u0012\u000f\n\u0007logo_id\u0018- \u0001(\t\u0012\r\n\u0005qa_id\u0018. \u0001(\t\u0012\u000f\n\u0007desc_id\u0018/ \u0001(\t\u0012\u0011\n\tlive_rate\u00180 \u0001(\t\u0012\u0012\n\nsimilarity\u00181 \u0001(\t\u0012\f\n\u0004code\u00182 \u0001(\t*õ!\n\u0005Event\u0012\u0011\n\rUNKNOWN_EVENT\u0010��\u0012 \n\u001cPERSONAL_PROFILE_MEDAL_CLICK\u0010\u0001\u0012'\n#PERSONAL_PROFILE_FOLLOWED_BTN_CLICK\u0010\u0002\u0012#\n\u001fPERSONAL_PROFILE_CHAT_BTN_CLICK\u0010\u0003\u0012\u001e\n\u001aPERSONAL_PROFILE_PAGE_SHOW\u0010\u0004\u0012)\n%PERSONAL_PROFILE_PAGE_SIGN_OPEN_CLICK\u0010\u0005\u0012*\n&PERSONAL_PROFILE_PAGE_SIGN_CLOSE_CLICK\u0010\u0006\u0012*\n&PERSONAL_PROFILE_PAGE_LIVE_ENTER_CLICK\u0010\b\u0012,\n(PERSONAL_PROFILE_PAGE_WEALTH_ENTER_CLICK\u0010\t\u0012$\n PERSONAL_PROFILE_PAGE_PHOTO_SHOW\u0010\n\u0012+\n'PERSONAL_PROFILE_PAGE_APPLY_PHOTO_CLICK\u0010\u000b\u0012\u001b\n\u0017APPLY_PHOTO_AGREE_CLICK\u0010\f\u0012\u001c\n\u0018APPLY_PHOTO_IGNORE_CLICK\u0010\r\u0012*\n&PERSONAL_PROFILE_PAGE_LIST_ENTER_CLICK\u0010\u000e\u0012\u0016\n\u0012GIFT_BUY_PAGE_SHOW\u0010\u000f\u0012\u001f\n\u001bGIFT_BUY_PAGE_BUY_BTN_CLICK\u0010\u0010\u0012%\n!PERSONAL_PROFILE_LOAD_DEFAULT_TAB\u0010\u0014\u0012\u001e\n\u001aPERSONAL_PROFILE_SHIFT_TAB\u0010\u0015\u0012$\n BLUED_OFFICER_CONTINUE_BTN_CLICK\u0010\u0016\u0012 \n\u001cBLUED_OFFICER_BACK_BTN_CLICK\u0010\u0017\u0012 \n\u001cBLUED_OFFICER_VOTE_BTN_CLICK\u0010\u0018\u0012/\n+PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_SHOW\u0010\u0019\u00120\n,PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_CLICK\u0010\u001a\u0012\"\n\u001ePERSONAL_PROFILE_VIP_SHED_SHOW\u0010\u001b\u0012#\n\u001fPERSONAL_PROFILE_VIP_SHED_CLICK\u0010\u001c\u0012\"\n\u001ePERSONAL_PROFILE_VIP_ICON_SHOW\u0010\u001d\u0012#\n\u001fPERSONAL_PROFILE_VIP_ICON_CLICK\u0010\u001e\u0012$\n PERSONAL_PROFILE_FEED_MORE_CLICK\u0010\u001f\u0012(\n$PERSONAL_PROFILE_FEED_MORE_TOP_CLICK\u0010 \u0012#\n\u001fPERSONAL_PROFILE_MORE_BTN_CLICK\u0010!\u0012\u001f\n\u001bEDIT_NICKNAME_CONFIRM_CLICK\u0010\"\u0012 \n\u001cEDIT_SIGNATURE_CONFIRM_CLICK\u0010#\u0012%\n!EDIT_SIGNATURE_VIP_PAGE_BTN_CLICK\u0010$\u0012\u001c\n\u0018PERSONAL_PHOTO_PAGE_SHOW\u0010%\u0012\"\n\u001ePERSONAL_PHOTO_PAGE_PHOTO_SHOW\u0010&\u0012+\n'PERSONAL_PROFILE_FEED_MORE_EXPOSE_CLICK\u0010'\u0012&\n\"PERSONAL_PROFILE_MORE_FOLLOW_CLICK\u0010(\u0012(\n$PERSONAL_PROFILE_MORE_UNFOLLOW_CLICK\u0010)\u0012#\n\u001fPERSONAL_FULL_SCREEN_TEXT_CLICK\u0010*\u0012#\n\u001fPERSONAL_FULL_SCREEN_MORE_CLICK\u0010+\u0012$\n PERSONAL_FULL_SCREEN_SHARE_CLICK\u0010,\u0012&\n\"PERSONAL_FULL_SCREEN_COMMENT_CLICK\u0010-\u0012#\n\u001fPERSONAL_FULL_SCREEN_LIKE_CLICK\u0010.\u0012\u001e\n\u001aPERSONAL_MORE_PROFILE_SHOW\u0010/\u0012\u001f\n\u001bPERSONAL_MORE_PROFILE_CLICK\u00100\u0012\u001b\n\u0017GIFT_BUY_PAGE_BAG_CLICK\u00101\u0012\u001b\n\u0017PROFILE_GIFT_LIST_CLICK\u00102\u0012\u001d\n\u0019PERSONAL_BACKGROUND_CLICK\u00104\u0012$\n PERSONAL_BACKGROUND_CHANGE_CLICK\u00105\u0012)\n%PERSONAL_EDIT_BACKGROUND_UPLOAD_CLICK\u00106\u0012\u0017\n\u0013PROFILE_LIVING_SHOW\u00107\u0012\u001d\n\u0019GIFT_BUY_FREE_BUBBLE_SHOW\u00108\u0012\u001c\n\u0018GIFT_BUY_NEW_BUBBLE_SHOW\u00109\u00122\n.PERSONAL_FOLLOW_LIST_CLEAR_INVALID_USERS_CLICK\u0010:\u0012'\n#PERSONAL_LIVE_YEAR_END_PENDANT_SHOW\u0010;\u0012(\n$PERSONAL_LIVE_YEAR_END_PENDANT_CLICK\u0010<\u0012\u0019\n\u0015HEALTH_INFO_PAGE_SHOW\u0010=\u0012$\n HEALTH_INFO_PAGE_SUBSCRIBE_CLICK\u0010>\u0012\u001f\n\u001bHEALTH_INFO_PAGE_MORE_CLICK\u0010?\u0012'\n#HEALTH_INFO_PAGE_ENCYCLOPEDIA_CLICK\u0010@\u0012\u001b\n\u0017PERSONAL_CHAT_ROOM_SHOW\u0010A\u0012\u001c\n\u0018PERSONAL_CHAT_ROOM_CLICK\u0010B\u0012\u0018\n\u0014PERSONAL_PHOTO_CLICK\u0010C\u0012$\n PERSONAL_LOOK_PHOTO_PENDANT_SHOW\u0010D\u0012%\n!PERSONAL_LOOK_PHOTO_PENDANT_CLICK\u0010E\u0012#\n\u001fPERSONAL_SET_PHOTO_PENDANT_SHOW\u0010F\u0012$\n PERSONAL_SET_PHOTO_PENDANT_CLICK\u0010G\u0012\u001b\n\u0017USER_PAGE_OPTIONS_CLICK\u0010H\u0012\u0019\n\u0015FEED_FULL_SCREEN_SHOW\u0010I\u0012\u0019\n\u0015PROFILE_MAX_BLACKLIST\u0010J\u0012\u001c\n\u0018PERSONAL_GIFT_LIST_CLICK\u0010K\u0012+\n'PERSONAL_EDIT_BACKGROUND_CUT_DONE_CLICK\u0010L\u0012\u0019\n\u0015PROFILE_FOLLOW_FILTER\u0010M\u0012\u001f\n\u001bPROFILE_FOLLOW_QUEIT_FILTER\u0010N\u0012\u0017\n\u0013PROFILE_FANS_FILTER\u0010O\u0012\u0019\n\u0015PROFILE_FRIEND_FILTER\u0010P\u0012\u0019\n\u0015PROFILE_ACTIVITY_SHOW\u0010Q\u0012\u001a\n\u0016PROFILE_ACTIVITY_CLICK\u0010R\u0012\u001d\n\u0019SERVICE_PROFILE_PAGE_SHOW\u0010S\u0012!\n\u001dSERVICE_PROFILE_PAGE_POP_SHOW\u0010T\u0012(\n$SERVICE_PROFILE_PAGE_POP_FIRST_CLICK\u0010U\u0012)\n%SERVICE_PROFILE_PAGE_POP_SECOND_CLICK\u0010V\u0012\u001d\n\u0019PROFILE_NFT_ENTRANCE_SHOW\u0010W\u0012\u001e\n\u001aPROFILE_NFT_ENTRANCE_CLICK\u0010X\u0012\u001c\n\u0018PERSONAL_MORE_HIDE_CLICK\u0010Y\u0012#\n\u001fPERSONAL_MORE_HIDE_SUCCESS_SHOW\u0010Z\u0012!\n\u001dPERSONAL_MORE_HIDE_LIMIT_SHOW\u0010[\u0012#\n\u001fPERSONAL_MORE_HIDE_CANCEL_CLICK\u0010\\\u0012*\n&PERSONAL_MORE_HIDE_CANCEL_SUCCESS_SHOW\u0010]\u0012$\n HIDE_SETTING_SEE_HIDE_LIST_CLICK\u0010^\u0012)\n%HIDE_SETTING_SEE_HIDE_LIST_ONE_REMOVE\u0010_\u0012\u001e\n\u001aPERSONAL_PUNISH_TOAST_SHOW\u0010`\u0012\u001a\n\u0016PERSONAL_SAME_POP_SHOW\u0010a\u0012\u001f\n\u001bPERSONAL_SAME_POP_USER_SHOW\u0010b\u0012&\n\"PERSONAL_SAME_POP_USER_PHOTO_CLICK\u0010c\u0012'\n#PERSONAL_SAME_POP_USER_FOLLOW_CLICK\u0010d\u0012%\n!PERSONAL_SAME_POP_USER_CHAT_CLICK\u0010e\u0012 \n\u001cPERSONAL_SAME_POP_MORE_CLICK\u0010f\u0012\u001b\n\u0017PERSONAL_SAME_PAGE_SHOW\u0010g\u0012 \n\u001cPERSONAL_SAME_PAGE_USER_SHOW\u0010h\u0012'\n#PERSONAL_SAME_PAGE_USER_PHOTO_CLICK\u0010i\u0012(\n$PERSONAL_SAME_PAGE_USER_FOLLOW_CLICK\u0010j\u0012&\n\"PERSONAL_SAME_PAGE_USER_CHAT_CLICK\u0010k\u0012\u001e\n\u001aPERSONAL_VIRTUAL_PAGE_SHOW\u0010l\u0012$\n PERSONAL_VIRTUAL_PAGE_EDIT_CLICK\u0010m\u0012%\n!PERSONAL_VIRTUAL_PAGE_SHARE_CLICK\u0010n\u0012)\n%PERSONAL_VIRTUAL_EDIT_PAGE_SAVE_CLICK\u0010o\u0012)\n%PERSONAL_VIRTUAL_EDIT_PAGE_BACK_CLICK\u0010p\u0012\u001f\n\u001bPERSONAL_VIRTUAL_PAGE_CLICK\u0010q\u0012-\n)PERSONAL_VIRTUAL_PAGE_FIRST_VIRTUAL_CLICK\u0010s\u0012(\n$PERSONAL_VIRTUAL_PAGE_FIRST_BG_CLICK\u0010t\u0012&\n\"PERSONAL_VIRTUAL_PAGE_DELETE_CLICK\u0010u\u0012*\n&PERSONAL_VIRTUAL_PAGE_DELETE_YES_CLICK\u0010v\u0012)\n%PERSONAL_VIRTUAL_PAGE_DELETE_NO_CLICK\u0010w\u0012\u001d\n\u0019PERSONAL_BUBBLE_ICON_SHOW\u0010x\u0012\u001e\n\u001aPERSONAL_BUBBLE_ICON_CLICK\u0010y\u0012%\n!PERSONAL_BUBBLE_ICON_DOUBLE_CLICK\u0010z\u0012$\n PERSONAL_BUBBLE_PUBLISH_BTN_SHOW\u0010{\u0012%\n!PERSONAL_BUBBLE_PUBLISH_BTN_CLICK\u0010|\u0012\u001f\n\u001bTC_AVATAR_AUTHENTICATE_FAIL\u0010}*Ï\n\n\u0006Source\u0012\u0019\n\u0015UNKNOWN_FOLLOW_SOURCE\u0010��\u0012\u0017\n\u0013FRIEND_NEARBY_VISIT\u0010\u0001\u0012\u0016\n\u0012FRIEND_NEARBY_VIEW\u0010\u0002\u0012\u0014\n\u0010FOLLOW_ATTENTION\u0010\u0003\u0012\u0013\n\u000fFEED_FIND_PHOTO\u0010\u0004\u0012\u0013\n\u000fFEED_FIND_PLAZA\u0010\u0005\u0012\u0019\n\u0015APPRECIATE_CALL_SHORT\u0010\u0006\u0012\u0019\n\u0015APPRECIATE_CALL_TOTAL\u0010\u0007\u0012\u000f\n\u000bMINE_FOLLOW\u0010\b\u0012\f\n\bMINE_FAN\u0010\t\u0012\u000f\n\u000bMINE_FRIEND\u0010\n\u0012\u0010\n\fCOMPLEX_SORT\u0010\u000b\u0012\u0014\n\u0010ONLINE_TIME_SORT\u0010\f\u0012\u0011\n\rDISTANCE_SORT\u0010\r\u0012\u0013\n\u000fNEARBY_FEATURED\u0010\u000e\u0012\u0010\n\fFEED_COMMENT\u0010\u000f\u0012\f\n\bNEW_FACE\u0010\u0010\u0012\u0016\n\u0012SUPER_TOPIC_DETAIL\u0010\u0011\u0012\u001d\n\u0019FIND_PLAZA_RECOMMEND_USER\u0010\u0012\u0012\u0018\n\u0014FIND_PLAZA_RECOMMEND\u0010\u0013\u0012\u0015\n\u0011FIND_PLAZA_FOLLOW\u0010\u0014\u0012\u0015\n\u0011FIND_PLAZA_NEARBY\u0010\u0015\u0012\u0014\n\u0010FIND_PLAZA_IMAGE\u0010\u0016\u0012\u0014\n\u0010FIND_PLAZA_FLASH\u0010\u0017\u0012\u001b\n\u0017FIND_PLAZA_FLASH_DETAIL\u0010\u0018\u0012\u000f\n\u000bFEED_DETAIL\u0010\u0019\u0012\u0012\n\u000ePAGE_FEED_MINE\u0010\u001a\u0012\u0012\n\u000ePAGE_FEED_LIKE\u0010\u001b\u0012\u0019\n\u0015PAGE_FEED_DETAIL_MORE\u0010\u001c\u0012\u0016\n\u0012CIRCLE_NOTE_DETAIL\u0010\u001d\u0012\u001a\n\u0016CIRCLE_DETAIL_NOTE_NEW\u0010\u001e\u0012\u001a\n\u0016CIRCLE_DETAIL_NOTE_HOT\u0010\u001f\u0012\u0010\n\fCIRCLE_USERS\u0010 \u0012\f\n\bONE_CITY\u0010!\u0012\u0013\n\u000fFIND_TOPIC_FEED\u0010\"\u0012\u001d\n\u0019CIRCLE_ACTIVE_MEMBER_LIST\u0010#\u0012 \n\u001cCIRCLE_ACTIVE_MEMBER_MISSION\u0010$\u0012\u0014\n\u0010NOTICE_FOLLOW_ME\u0010%\u0012\r\n\tCITY_TIME\u0010&\u0012\u001a\n\u0016FEED_IMAGE_FULL_SCREEN\u0010'\u0012\u001e\n\u001aPERSONAL_VIDEO_FULL_SCREEN\u0010(\u0012\u0011\n\rMSG_TOP_TITLE\u0010)\u0012\r\n\tMSG_PHOTO\u0010*\u0012\u0015\n\u0011MSG_SETTING_PHOTO\u0010+\u0012\u000f\n\u000bNOTICE_LIKE\u0010,\u0012\u0012\n\u000eLITE_RECOMMEND\u0010-\u0012\u000e\n\nHOT_BUBBLE\u0010.\u0012\u0012\n\u000eCITY_ALL_IMAGE\u0010/\u0012\u0012\n\u000eCITY_ALL_VIDEO\u00100\u0012\u0013\n\u000fCITY_ALL_DETAIL\u00101\u0012\u0013\n\u000fRECOMMEND_IMAGE\u00102\u0012\u0013\n\u000fRECOMMEND_VIDEO\u00103\u0012\u0014\n\u0010RECOMMEND_DETAIL\u00104\u0012\r\n\tCITY_NOTE\u00105\u0012\u0012\n\u000eCITY_TIME_NOTE\u00106\u0012\u0013\n\u000fMAP_FRIEND_USER\u00107\u0012\u0014\n\u0010NEARBY_OPERATION\u00108\u0012\r\n\tSAME_USER\u00109\u0012\r\n\tPUSH_CALL\u0010:\u0012\u0012\n\u000ePERSONAL_PHOTO\u0010;\u0012\u0011\n\rPERSONAL_FEED\u0010<\u0012\u0013\n\u000fTOPIC_RECOMMEND\u0010=\u0012\r\n\tTOPIC_NEW\u0010>*A\n\bShowType\u0012\u0015\n\u0011UNKNOWN_SHOW_TYPE\u0010��\u0012\u000f\n\u000bPALACE_SHOW\u0010\u0001\u0012\r\n\tLIST_SHOW\u0010\u0002*P\n\u0007TabType\u0012\u0014\n\u0010UNKNOWN_TAB_TYPE\u0010��\u0012\r\n\tFEED_LOAD\u0010\u0001\u0012\u0010\n\fPROFILE_LOAD\u0010\u0002\u0012\u000e\n\nPHOTO_LOAD\u0010\u0003*O\n\nVoteOption\u0012\u0017\n\u0013UNKNOWN_VOTE_OPTION\u0010��\u0012\u000b\n\u0007IS_JUNK\u0010\u0001\u0012\f\n\bNOT_JUNK\u0010\u0002\u0012\r\n\tUNCERTAIN\u0010\u0003*F\n\bGiftFrom\u0012\u0015\n\u0011UNKNOWN_GIFT_FROM\u0010��\u0012\u0011\n\rPERSONAL_PAGE\u0010\u0001\u0012\u0010\n\fMESSAGE_PAGE\u0010\u0002*S\n\u0012TargetIdentityType\u0012 \n\u001cUNKNOWN_TARGET_IDENTITY_TYPE\u0010��\u0012\b\n\u0004NONE\u0010\u0001\u0012\u0007\n\u0003VIP\u0010\u0002\u0012\b\n\u0004SVIP\u0010\u0003*J\n\nFilterType\u0012\u0017\n\u0013UNKNOWN_FILTER_TYPE\u0010��\u0012\u000b\n\u0007DEFAULT\u0010\u0001\u0012\f\n\bLOCATION\u0010\u0002\u0012\b\n\u0004TIME\u0010\u0003B\u0013¢\u0002\u0010PERSONAL_PROFILEb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_blued_das_profile_PersonalProfileProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_profile_PersonalProfileProto_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/profile/PersonalProfileProtos$Event.class */
    public enum Event implements ProtocolMessageEnum {
        UNKNOWN_EVENT(0),
        PERSONAL_PROFILE_MEDAL_CLICK(1),
        PERSONAL_PROFILE_FOLLOWED_BTN_CLICK(2),
        PERSONAL_PROFILE_CHAT_BTN_CLICK(3),
        PERSONAL_PROFILE_PAGE_SHOW(4),
        PERSONAL_PROFILE_PAGE_SIGN_OPEN_CLICK(5),
        PERSONAL_PROFILE_PAGE_SIGN_CLOSE_CLICK(6),
        PERSONAL_PROFILE_PAGE_LIVE_ENTER_CLICK(8),
        PERSONAL_PROFILE_PAGE_WEALTH_ENTER_CLICK(9),
        PERSONAL_PROFILE_PAGE_PHOTO_SHOW(10),
        PERSONAL_PROFILE_PAGE_APPLY_PHOTO_CLICK(11),
        APPLY_PHOTO_AGREE_CLICK(12),
        APPLY_PHOTO_IGNORE_CLICK(13),
        PERSONAL_PROFILE_PAGE_LIST_ENTER_CLICK(14),
        GIFT_BUY_PAGE_SHOW(15),
        GIFT_BUY_PAGE_BUY_BTN_CLICK(16),
        PERSONAL_PROFILE_LOAD_DEFAULT_TAB(20),
        PERSONAL_PROFILE_SHIFT_TAB(21),
        BLUED_OFFICER_CONTINUE_BTN_CLICK(22),
        BLUED_OFFICER_BACK_BTN_CLICK(23),
        BLUED_OFFICER_VOTE_BTN_CLICK(24),
        PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_SHOW(25),
        PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_CLICK(26),
        PERSONAL_PROFILE_VIP_SHED_SHOW(27),
        PERSONAL_PROFILE_VIP_SHED_CLICK(28),
        PERSONAL_PROFILE_VIP_ICON_SHOW(29),
        PERSONAL_PROFILE_VIP_ICON_CLICK(30),
        PERSONAL_PROFILE_FEED_MORE_CLICK(31),
        PERSONAL_PROFILE_FEED_MORE_TOP_CLICK(32),
        PERSONAL_PROFILE_MORE_BTN_CLICK(33),
        EDIT_NICKNAME_CONFIRM_CLICK(34),
        EDIT_SIGNATURE_CONFIRM_CLICK(35),
        EDIT_SIGNATURE_VIP_PAGE_BTN_CLICK(36),
        PERSONAL_PHOTO_PAGE_SHOW(37),
        PERSONAL_PHOTO_PAGE_PHOTO_SHOW(38),
        PERSONAL_PROFILE_FEED_MORE_EXPOSE_CLICK(39),
        PERSONAL_PROFILE_MORE_FOLLOW_CLICK(40),
        PERSONAL_PROFILE_MORE_UNFOLLOW_CLICK(41),
        PERSONAL_FULL_SCREEN_TEXT_CLICK(42),
        PERSONAL_FULL_SCREEN_MORE_CLICK(43),
        PERSONAL_FULL_SCREEN_SHARE_CLICK(44),
        PERSONAL_FULL_SCREEN_COMMENT_CLICK(45),
        PERSONAL_FULL_SCREEN_LIKE_CLICK(46),
        PERSONAL_MORE_PROFILE_SHOW(47),
        PERSONAL_MORE_PROFILE_CLICK(48),
        GIFT_BUY_PAGE_BAG_CLICK(49),
        PROFILE_GIFT_LIST_CLICK(50),
        PERSONAL_BACKGROUND_CLICK(52),
        PERSONAL_BACKGROUND_CHANGE_CLICK(53),
        PERSONAL_EDIT_BACKGROUND_UPLOAD_CLICK(54),
        PROFILE_LIVING_SHOW(55),
        GIFT_BUY_FREE_BUBBLE_SHOW(56),
        GIFT_BUY_NEW_BUBBLE_SHOW(57),
        PERSONAL_FOLLOW_LIST_CLEAR_INVALID_USERS_CLICK(58),
        PERSONAL_LIVE_YEAR_END_PENDANT_SHOW(59),
        PERSONAL_LIVE_YEAR_END_PENDANT_CLICK(60),
        HEALTH_INFO_PAGE_SHOW(61),
        HEALTH_INFO_PAGE_SUBSCRIBE_CLICK(62),
        HEALTH_INFO_PAGE_MORE_CLICK(63),
        HEALTH_INFO_PAGE_ENCYCLOPEDIA_CLICK(64),
        PERSONAL_CHAT_ROOM_SHOW(65),
        PERSONAL_CHAT_ROOM_CLICK(66),
        PERSONAL_PHOTO_CLICK(67),
        PERSONAL_LOOK_PHOTO_PENDANT_SHOW(68),
        PERSONAL_LOOK_PHOTO_PENDANT_CLICK(69),
        PERSONAL_SET_PHOTO_PENDANT_SHOW(70),
        PERSONAL_SET_PHOTO_PENDANT_CLICK(71),
        USER_PAGE_OPTIONS_CLICK(72),
        FEED_FULL_SCREEN_SHOW(73),
        PROFILE_MAX_BLACKLIST(74),
        PERSONAL_GIFT_LIST_CLICK(75),
        PERSONAL_EDIT_BACKGROUND_CUT_DONE_CLICK(76),
        PROFILE_FOLLOW_FILTER(77),
        PROFILE_FOLLOW_QUEIT_FILTER(78),
        PROFILE_FANS_FILTER(79),
        PROFILE_FRIEND_FILTER(80),
        PROFILE_ACTIVITY_SHOW(81),
        PROFILE_ACTIVITY_CLICK(82),
        SERVICE_PROFILE_PAGE_SHOW(83),
        SERVICE_PROFILE_PAGE_POP_SHOW(84),
        SERVICE_PROFILE_PAGE_POP_FIRST_CLICK(85),
        SERVICE_PROFILE_PAGE_POP_SECOND_CLICK(86),
        PROFILE_NFT_ENTRANCE_SHOW(87),
        PROFILE_NFT_ENTRANCE_CLICK(88),
        PERSONAL_MORE_HIDE_CLICK(89),
        PERSONAL_MORE_HIDE_SUCCESS_SHOW(90),
        PERSONAL_MORE_HIDE_LIMIT_SHOW(91),
        PERSONAL_MORE_HIDE_CANCEL_CLICK(92),
        PERSONAL_MORE_HIDE_CANCEL_SUCCESS_SHOW(93),
        HIDE_SETTING_SEE_HIDE_LIST_CLICK(94),
        HIDE_SETTING_SEE_HIDE_LIST_ONE_REMOVE(95),
        PERSONAL_PUNISH_TOAST_SHOW(96),
        PERSONAL_SAME_POP_SHOW(97),
        PERSONAL_SAME_POP_USER_SHOW(98),
        PERSONAL_SAME_POP_USER_PHOTO_CLICK(99),
        PERSONAL_SAME_POP_USER_FOLLOW_CLICK(100),
        PERSONAL_SAME_POP_USER_CHAT_CLICK(101),
        PERSONAL_SAME_POP_MORE_CLICK(102),
        PERSONAL_SAME_PAGE_SHOW(103),
        PERSONAL_SAME_PAGE_USER_SHOW(104),
        PERSONAL_SAME_PAGE_USER_PHOTO_CLICK(105),
        PERSONAL_SAME_PAGE_USER_FOLLOW_CLICK(106),
        PERSONAL_SAME_PAGE_USER_CHAT_CLICK(107),
        PERSONAL_VIRTUAL_PAGE_SHOW(108),
        PERSONAL_VIRTUAL_PAGE_EDIT_CLICK(109),
        PERSONAL_VIRTUAL_PAGE_SHARE_CLICK(110),
        PERSONAL_VIRTUAL_EDIT_PAGE_SAVE_CLICK(111),
        PERSONAL_VIRTUAL_EDIT_PAGE_BACK_CLICK(112),
        PERSONAL_VIRTUAL_PAGE_CLICK(113),
        PERSONAL_VIRTUAL_PAGE_FIRST_VIRTUAL_CLICK(115),
        PERSONAL_VIRTUAL_PAGE_FIRST_BG_CLICK(116),
        PERSONAL_VIRTUAL_PAGE_DELETE_CLICK(117),
        PERSONAL_VIRTUAL_PAGE_DELETE_YES_CLICK(118),
        PERSONAL_VIRTUAL_PAGE_DELETE_NO_CLICK(119),
        PERSONAL_BUBBLE_ICON_SHOW(120),
        PERSONAL_BUBBLE_ICON_CLICK(121),
        PERSONAL_BUBBLE_ICON_DOUBLE_CLICK(122),
        PERSONAL_BUBBLE_PUBLISH_BTN_SHOW(123),
        PERSONAL_BUBBLE_PUBLISH_BTN_CLICK(124),
        TC_AVATAR_AUTHENTICATE_FAIL(125),
        UNRECOGNIZED(-1);
        
        public static final int APPLY_PHOTO_AGREE_CLICK_VALUE = 12;
        public static final int APPLY_PHOTO_IGNORE_CLICK_VALUE = 13;
        public static final int BLUED_OFFICER_BACK_BTN_CLICK_VALUE = 23;
        public static final int BLUED_OFFICER_CONTINUE_BTN_CLICK_VALUE = 22;
        public static final int BLUED_OFFICER_VOTE_BTN_CLICK_VALUE = 24;
        public static final int EDIT_NICKNAME_CONFIRM_CLICK_VALUE = 34;
        public static final int EDIT_SIGNATURE_CONFIRM_CLICK_VALUE = 35;
        public static final int EDIT_SIGNATURE_VIP_PAGE_BTN_CLICK_VALUE = 36;
        public static final int FEED_FULL_SCREEN_SHOW_VALUE = 73;
        public static final int GIFT_BUY_FREE_BUBBLE_SHOW_VALUE = 56;
        public static final int GIFT_BUY_NEW_BUBBLE_SHOW_VALUE = 57;
        public static final int GIFT_BUY_PAGE_BAG_CLICK_VALUE = 49;
        public static final int GIFT_BUY_PAGE_BUY_BTN_CLICK_VALUE = 16;
        public static final int GIFT_BUY_PAGE_SHOW_VALUE = 15;
        public static final int HEALTH_INFO_PAGE_ENCYCLOPEDIA_CLICK_VALUE = 64;
        public static final int HEALTH_INFO_PAGE_MORE_CLICK_VALUE = 63;
        public static final int HEALTH_INFO_PAGE_SHOW_VALUE = 61;
        public static final int HEALTH_INFO_PAGE_SUBSCRIBE_CLICK_VALUE = 62;
        public static final int HIDE_SETTING_SEE_HIDE_LIST_CLICK_VALUE = 94;
        public static final int HIDE_SETTING_SEE_HIDE_LIST_ONE_REMOVE_VALUE = 95;
        public static final int PERSONAL_BACKGROUND_CHANGE_CLICK_VALUE = 53;
        public static final int PERSONAL_BACKGROUND_CLICK_VALUE = 52;
        public static final int PERSONAL_BUBBLE_ICON_CLICK_VALUE = 121;
        public static final int PERSONAL_BUBBLE_ICON_DOUBLE_CLICK_VALUE = 122;
        public static final int PERSONAL_BUBBLE_ICON_SHOW_VALUE = 120;
        public static final int PERSONAL_BUBBLE_PUBLISH_BTN_CLICK_VALUE = 124;
        public static final int PERSONAL_BUBBLE_PUBLISH_BTN_SHOW_VALUE = 123;
        public static final int PERSONAL_CHAT_ROOM_CLICK_VALUE = 66;
        public static final int PERSONAL_CHAT_ROOM_SHOW_VALUE = 65;
        public static final int PERSONAL_EDIT_BACKGROUND_CUT_DONE_CLICK_VALUE = 76;
        public static final int PERSONAL_EDIT_BACKGROUND_UPLOAD_CLICK_VALUE = 54;
        public static final int PERSONAL_FOLLOW_LIST_CLEAR_INVALID_USERS_CLICK_VALUE = 58;
        public static final int PERSONAL_FULL_SCREEN_COMMENT_CLICK_VALUE = 45;
        public static final int PERSONAL_FULL_SCREEN_LIKE_CLICK_VALUE = 46;
        public static final int PERSONAL_FULL_SCREEN_MORE_CLICK_VALUE = 43;
        public static final int PERSONAL_FULL_SCREEN_SHARE_CLICK_VALUE = 44;
        public static final int PERSONAL_FULL_SCREEN_TEXT_CLICK_VALUE = 42;
        public static final int PERSONAL_GIFT_LIST_CLICK_VALUE = 75;
        public static final int PERSONAL_LIVE_YEAR_END_PENDANT_CLICK_VALUE = 60;
        public static final int PERSONAL_LIVE_YEAR_END_PENDANT_SHOW_VALUE = 59;
        public static final int PERSONAL_LOOK_PHOTO_PENDANT_CLICK_VALUE = 69;
        public static final int PERSONAL_LOOK_PHOTO_PENDANT_SHOW_VALUE = 68;
        public static final int PERSONAL_MORE_HIDE_CANCEL_CLICK_VALUE = 92;
        public static final int PERSONAL_MORE_HIDE_CANCEL_SUCCESS_SHOW_VALUE = 93;
        public static final int PERSONAL_MORE_HIDE_CLICK_VALUE = 89;
        public static final int PERSONAL_MORE_HIDE_LIMIT_SHOW_VALUE = 91;
        public static final int PERSONAL_MORE_HIDE_SUCCESS_SHOW_VALUE = 90;
        public static final int PERSONAL_MORE_PROFILE_CLICK_VALUE = 48;
        public static final int PERSONAL_MORE_PROFILE_SHOW_VALUE = 47;
        public static final int PERSONAL_PHOTO_CLICK_VALUE = 67;
        public static final int PERSONAL_PHOTO_PAGE_PHOTO_SHOW_VALUE = 38;
        public static final int PERSONAL_PHOTO_PAGE_SHOW_VALUE = 37;
        public static final int PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_CLICK_VALUE = 26;
        public static final int PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_SHOW_VALUE = 25;
        public static final int PERSONAL_PROFILE_CHAT_BTN_CLICK_VALUE = 3;
        public static final int PERSONAL_PROFILE_FEED_MORE_CLICK_VALUE = 31;
        public static final int PERSONAL_PROFILE_FEED_MORE_EXPOSE_CLICK_VALUE = 39;
        public static final int PERSONAL_PROFILE_FEED_MORE_TOP_CLICK_VALUE = 32;
        public static final int PERSONAL_PROFILE_FOLLOWED_BTN_CLICK_VALUE = 2;
        public static final int PERSONAL_PROFILE_LOAD_DEFAULT_TAB_VALUE = 20;
        public static final int PERSONAL_PROFILE_MEDAL_CLICK_VALUE = 1;
        public static final int PERSONAL_PROFILE_MORE_BTN_CLICK_VALUE = 33;
        public static final int PERSONAL_PROFILE_MORE_FOLLOW_CLICK_VALUE = 40;
        public static final int PERSONAL_PROFILE_MORE_UNFOLLOW_CLICK_VALUE = 41;
        public static final int PERSONAL_PROFILE_PAGE_APPLY_PHOTO_CLICK_VALUE = 11;
        public static final int PERSONAL_PROFILE_PAGE_LIST_ENTER_CLICK_VALUE = 14;
        public static final int PERSONAL_PROFILE_PAGE_LIVE_ENTER_CLICK_VALUE = 8;
        public static final int PERSONAL_PROFILE_PAGE_PHOTO_SHOW_VALUE = 10;
        public static final int PERSONAL_PROFILE_PAGE_SHOW_VALUE = 4;
        public static final int PERSONAL_PROFILE_PAGE_SIGN_CLOSE_CLICK_VALUE = 6;
        public static final int PERSONAL_PROFILE_PAGE_SIGN_OPEN_CLICK_VALUE = 5;
        public static final int PERSONAL_PROFILE_PAGE_WEALTH_ENTER_CLICK_VALUE = 9;
        public static final int PERSONAL_PROFILE_SHIFT_TAB_VALUE = 21;
        public static final int PERSONAL_PROFILE_VIP_ICON_CLICK_VALUE = 30;
        public static final int PERSONAL_PROFILE_VIP_ICON_SHOW_VALUE = 29;
        public static final int PERSONAL_PROFILE_VIP_SHED_CLICK_VALUE = 28;
        public static final int PERSONAL_PROFILE_VIP_SHED_SHOW_VALUE = 27;
        public static final int PERSONAL_PUNISH_TOAST_SHOW_VALUE = 96;
        public static final int PERSONAL_SAME_PAGE_SHOW_VALUE = 103;
        public static final int PERSONAL_SAME_PAGE_USER_CHAT_CLICK_VALUE = 107;
        public static final int PERSONAL_SAME_PAGE_USER_FOLLOW_CLICK_VALUE = 106;
        public static final int PERSONAL_SAME_PAGE_USER_PHOTO_CLICK_VALUE = 105;
        public static final int PERSONAL_SAME_PAGE_USER_SHOW_VALUE = 104;
        public static final int PERSONAL_SAME_POP_MORE_CLICK_VALUE = 102;
        public static final int PERSONAL_SAME_POP_SHOW_VALUE = 97;
        public static final int PERSONAL_SAME_POP_USER_CHAT_CLICK_VALUE = 101;
        public static final int PERSONAL_SAME_POP_USER_FOLLOW_CLICK_VALUE = 100;
        public static final int PERSONAL_SAME_POP_USER_PHOTO_CLICK_VALUE = 99;
        public static final int PERSONAL_SAME_POP_USER_SHOW_VALUE = 98;
        public static final int PERSONAL_SET_PHOTO_PENDANT_CLICK_VALUE = 71;
        public static final int PERSONAL_SET_PHOTO_PENDANT_SHOW_VALUE = 70;
        public static final int PERSONAL_VIRTUAL_EDIT_PAGE_BACK_CLICK_VALUE = 112;
        public static final int PERSONAL_VIRTUAL_EDIT_PAGE_SAVE_CLICK_VALUE = 111;
        public static final int PERSONAL_VIRTUAL_PAGE_CLICK_VALUE = 113;
        public static final int PERSONAL_VIRTUAL_PAGE_DELETE_CLICK_VALUE = 117;
        public static final int PERSONAL_VIRTUAL_PAGE_DELETE_NO_CLICK_VALUE = 119;
        public static final int PERSONAL_VIRTUAL_PAGE_DELETE_YES_CLICK_VALUE = 118;
        public static final int PERSONAL_VIRTUAL_PAGE_EDIT_CLICK_VALUE = 109;
        public static final int PERSONAL_VIRTUAL_PAGE_FIRST_BG_CLICK_VALUE = 116;
        public static final int PERSONAL_VIRTUAL_PAGE_FIRST_VIRTUAL_CLICK_VALUE = 115;
        public static final int PERSONAL_VIRTUAL_PAGE_SHARE_CLICK_VALUE = 110;
        public static final int PERSONAL_VIRTUAL_PAGE_SHOW_VALUE = 108;
        public static final int PROFILE_ACTIVITY_CLICK_VALUE = 82;
        public static final int PROFILE_ACTIVITY_SHOW_VALUE = 81;
        public static final int PROFILE_FANS_FILTER_VALUE = 79;
        public static final int PROFILE_FOLLOW_FILTER_VALUE = 77;
        public static final int PROFILE_FOLLOW_QUEIT_FILTER_VALUE = 78;
        public static final int PROFILE_FRIEND_FILTER_VALUE = 80;
        public static final int PROFILE_GIFT_LIST_CLICK_VALUE = 50;
        public static final int PROFILE_LIVING_SHOW_VALUE = 55;
        public static final int PROFILE_MAX_BLACKLIST_VALUE = 74;
        public static final int PROFILE_NFT_ENTRANCE_CLICK_VALUE = 88;
        public static final int PROFILE_NFT_ENTRANCE_SHOW_VALUE = 87;
        public static final int SERVICE_PROFILE_PAGE_POP_FIRST_CLICK_VALUE = 85;
        public static final int SERVICE_PROFILE_PAGE_POP_SECOND_CLICK_VALUE = 86;
        public static final int SERVICE_PROFILE_PAGE_POP_SHOW_VALUE = 84;
        public static final int SERVICE_PROFILE_PAGE_SHOW_VALUE = 83;
        public static final int TC_AVATAR_AUTHENTICATE_FAIL_VALUE = 125;
        public static final int UNKNOWN_EVENT_VALUE = 0;
        public static final int USER_PAGE_OPTIONS_CLICK_VALUE = 72;
        private final int value;
        private static final Internal.EnumLiteMap<Event> internalValueMap = new Internal.EnumLiteMap<Event>() { // from class: com.blued.das.profile.PersonalProfileProtos.Event.1
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
                    return PERSONAL_PROFILE_MEDAL_CLICK;
                case 2:
                    return PERSONAL_PROFILE_FOLLOWED_BTN_CLICK;
                case 3:
                    return PERSONAL_PROFILE_CHAT_BTN_CLICK;
                case 4:
                    return PERSONAL_PROFILE_PAGE_SHOW;
                case 5:
                    return PERSONAL_PROFILE_PAGE_SIGN_OPEN_CLICK;
                case 6:
                    return PERSONAL_PROFILE_PAGE_SIGN_CLOSE_CLICK;
                case 7:
                case 17:
                case 18:
                case 19:
                case 51:
                case 114:
                default:
                    return null;
                case 8:
                    return PERSONAL_PROFILE_PAGE_LIVE_ENTER_CLICK;
                case 9:
                    return PERSONAL_PROFILE_PAGE_WEALTH_ENTER_CLICK;
                case 10:
                    return PERSONAL_PROFILE_PAGE_PHOTO_SHOW;
                case 11:
                    return PERSONAL_PROFILE_PAGE_APPLY_PHOTO_CLICK;
                case 12:
                    return APPLY_PHOTO_AGREE_CLICK;
                case 13:
                    return APPLY_PHOTO_IGNORE_CLICK;
                case 14:
                    return PERSONAL_PROFILE_PAGE_LIST_ENTER_CLICK;
                case 15:
                    return GIFT_BUY_PAGE_SHOW;
                case 16:
                    return GIFT_BUY_PAGE_BUY_BTN_CLICK;
                case 20:
                    return PERSONAL_PROFILE_LOAD_DEFAULT_TAB;
                case 21:
                    return PERSONAL_PROFILE_SHIFT_TAB;
                case 22:
                    return BLUED_OFFICER_CONTINUE_BTN_CLICK;
                case 23:
                    return BLUED_OFFICER_BACK_BTN_CLICK;
                case 24:
                    return BLUED_OFFICER_VOTE_BTN_CLICK;
                case 25:
                    return PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_SHOW;
                case 26:
                    return PERSONAL_PROFILE_CHARITABLE_ACTIVITIES_CLICK;
                case 27:
                    return PERSONAL_PROFILE_VIP_SHED_SHOW;
                case 28:
                    return PERSONAL_PROFILE_VIP_SHED_CLICK;
                case 29:
                    return PERSONAL_PROFILE_VIP_ICON_SHOW;
                case 30:
                    return PERSONAL_PROFILE_VIP_ICON_CLICK;
                case 31:
                    return PERSONAL_PROFILE_FEED_MORE_CLICK;
                case 32:
                    return PERSONAL_PROFILE_FEED_MORE_TOP_CLICK;
                case 33:
                    return PERSONAL_PROFILE_MORE_BTN_CLICK;
                case 34:
                    return EDIT_NICKNAME_CONFIRM_CLICK;
                case 35:
                    return EDIT_SIGNATURE_CONFIRM_CLICK;
                case 36:
                    return EDIT_SIGNATURE_VIP_PAGE_BTN_CLICK;
                case 37:
                    return PERSONAL_PHOTO_PAGE_SHOW;
                case 38:
                    return PERSONAL_PHOTO_PAGE_PHOTO_SHOW;
                case 39:
                    return PERSONAL_PROFILE_FEED_MORE_EXPOSE_CLICK;
                case 40:
                    return PERSONAL_PROFILE_MORE_FOLLOW_CLICK;
                case 41:
                    return PERSONAL_PROFILE_MORE_UNFOLLOW_CLICK;
                case 42:
                    return PERSONAL_FULL_SCREEN_TEXT_CLICK;
                case 43:
                    return PERSONAL_FULL_SCREEN_MORE_CLICK;
                case 44:
                    return PERSONAL_FULL_SCREEN_SHARE_CLICK;
                case 45:
                    return PERSONAL_FULL_SCREEN_COMMENT_CLICK;
                case 46:
                    return PERSONAL_FULL_SCREEN_LIKE_CLICK;
                case 47:
                    return PERSONAL_MORE_PROFILE_SHOW;
                case 48:
                    return PERSONAL_MORE_PROFILE_CLICK;
                case 49:
                    return GIFT_BUY_PAGE_BAG_CLICK;
                case 50:
                    return PROFILE_GIFT_LIST_CLICK;
                case 52:
                    return PERSONAL_BACKGROUND_CLICK;
                case 53:
                    return PERSONAL_BACKGROUND_CHANGE_CLICK;
                case 54:
                    return PERSONAL_EDIT_BACKGROUND_UPLOAD_CLICK;
                case 55:
                    return PROFILE_LIVING_SHOW;
                case 56:
                    return GIFT_BUY_FREE_BUBBLE_SHOW;
                case 57:
                    return GIFT_BUY_NEW_BUBBLE_SHOW;
                case 58:
                    return PERSONAL_FOLLOW_LIST_CLEAR_INVALID_USERS_CLICK;
                case 59:
                    return PERSONAL_LIVE_YEAR_END_PENDANT_SHOW;
                case 60:
                    return PERSONAL_LIVE_YEAR_END_PENDANT_CLICK;
                case 61:
                    return HEALTH_INFO_PAGE_SHOW;
                case 62:
                    return HEALTH_INFO_PAGE_SUBSCRIBE_CLICK;
                case 63:
                    return HEALTH_INFO_PAGE_MORE_CLICK;
                case 64:
                    return HEALTH_INFO_PAGE_ENCYCLOPEDIA_CLICK;
                case 65:
                    return PERSONAL_CHAT_ROOM_SHOW;
                case 66:
                    return PERSONAL_CHAT_ROOM_CLICK;
                case 67:
                    return PERSONAL_PHOTO_CLICK;
                case 68:
                    return PERSONAL_LOOK_PHOTO_PENDANT_SHOW;
                case 69:
                    return PERSONAL_LOOK_PHOTO_PENDANT_CLICK;
                case 70:
                    return PERSONAL_SET_PHOTO_PENDANT_SHOW;
                case 71:
                    return PERSONAL_SET_PHOTO_PENDANT_CLICK;
                case 72:
                    return USER_PAGE_OPTIONS_CLICK;
                case 73:
                    return FEED_FULL_SCREEN_SHOW;
                case 74:
                    return PROFILE_MAX_BLACKLIST;
                case 75:
                    return PERSONAL_GIFT_LIST_CLICK;
                case 76:
                    return PERSONAL_EDIT_BACKGROUND_CUT_DONE_CLICK;
                case 77:
                    return PROFILE_FOLLOW_FILTER;
                case 78:
                    return PROFILE_FOLLOW_QUEIT_FILTER;
                case 79:
                    return PROFILE_FANS_FILTER;
                case 80:
                    return PROFILE_FRIEND_FILTER;
                case 81:
                    return PROFILE_ACTIVITY_SHOW;
                case 82:
                    return PROFILE_ACTIVITY_CLICK;
                case 83:
                    return SERVICE_PROFILE_PAGE_SHOW;
                case 84:
                    return SERVICE_PROFILE_PAGE_POP_SHOW;
                case 85:
                    return SERVICE_PROFILE_PAGE_POP_FIRST_CLICK;
                case 86:
                    return SERVICE_PROFILE_PAGE_POP_SECOND_CLICK;
                case 87:
                    return PROFILE_NFT_ENTRANCE_SHOW;
                case 88:
                    return PROFILE_NFT_ENTRANCE_CLICK;
                case 89:
                    return PERSONAL_MORE_HIDE_CLICK;
                case 90:
                    return PERSONAL_MORE_HIDE_SUCCESS_SHOW;
                case 91:
                    return PERSONAL_MORE_HIDE_LIMIT_SHOW;
                case 92:
                    return PERSONAL_MORE_HIDE_CANCEL_CLICK;
                case 93:
                    return PERSONAL_MORE_HIDE_CANCEL_SUCCESS_SHOW;
                case 94:
                    return HIDE_SETTING_SEE_HIDE_LIST_CLICK;
                case 95:
                    return HIDE_SETTING_SEE_HIDE_LIST_ONE_REMOVE;
                case 96:
                    return PERSONAL_PUNISH_TOAST_SHOW;
                case 97:
                    return PERSONAL_SAME_POP_SHOW;
                case 98:
                    return PERSONAL_SAME_POP_USER_SHOW;
                case 99:
                    return PERSONAL_SAME_POP_USER_PHOTO_CLICK;
                case 100:
                    return PERSONAL_SAME_POP_USER_FOLLOW_CLICK;
                case 101:
                    return PERSONAL_SAME_POP_USER_CHAT_CLICK;
                case 102:
                    return PERSONAL_SAME_POP_MORE_CLICK;
                case 103:
                    return PERSONAL_SAME_PAGE_SHOW;
                case 104:
                    return PERSONAL_SAME_PAGE_USER_SHOW;
                case 105:
                    return PERSONAL_SAME_PAGE_USER_PHOTO_CLICK;
                case 106:
                    return PERSONAL_SAME_PAGE_USER_FOLLOW_CLICK;
                case 107:
                    return PERSONAL_SAME_PAGE_USER_CHAT_CLICK;
                case 108:
                    return PERSONAL_VIRTUAL_PAGE_SHOW;
                case 109:
                    return PERSONAL_VIRTUAL_PAGE_EDIT_CLICK;
                case 110:
                    return PERSONAL_VIRTUAL_PAGE_SHARE_CLICK;
                case 111:
                    return PERSONAL_VIRTUAL_EDIT_PAGE_SAVE_CLICK;
                case 112:
                    return PERSONAL_VIRTUAL_EDIT_PAGE_BACK_CLICK;
                case 113:
                    return PERSONAL_VIRTUAL_PAGE_CLICK;
                case 115:
                    return PERSONAL_VIRTUAL_PAGE_FIRST_VIRTUAL_CLICK;
                case 116:
                    return PERSONAL_VIRTUAL_PAGE_FIRST_BG_CLICK;
                case 117:
                    return PERSONAL_VIRTUAL_PAGE_DELETE_CLICK;
                case 118:
                    return PERSONAL_VIRTUAL_PAGE_DELETE_YES_CLICK;
                case 119:
                    return PERSONAL_VIRTUAL_PAGE_DELETE_NO_CLICK;
                case 120:
                    return PERSONAL_BUBBLE_ICON_SHOW;
                case 121:
                    return PERSONAL_BUBBLE_ICON_CLICK;
                case 122:
                    return PERSONAL_BUBBLE_ICON_DOUBLE_CLICK;
                case 123:
                    return PERSONAL_BUBBLE_PUBLISH_BTN_SHOW;
                case 124:
                    return PERSONAL_BUBBLE_PUBLISH_BTN_CLICK;
                case 125:
                    return TC_AVATAR_AUTHENTICATE_FAIL;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return PersonalProfileProtos.getDescriptor().getEnumTypes().get(0);
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/profile/PersonalProfileProtos$FilterType.class */
    public enum FilterType implements ProtocolMessageEnum {
        UNKNOWN_FILTER_TYPE(0),
        DEFAULT(1),
        LOCATION(2),
        TIME(3),
        UNRECOGNIZED(-1);
        
        public static final int DEFAULT_VALUE = 1;
        public static final int LOCATION_VALUE = 2;
        public static final int TIME_VALUE = 3;
        public static final int UNKNOWN_FILTER_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<FilterType> internalValueMap = new Internal.EnumLiteMap<FilterType>() { // from class: com.blued.das.profile.PersonalProfileProtos.FilterType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public FilterType findValueByNumber(int i) {
                return FilterType.forNumber(i);
            }
        };
        private static final FilterType[] VALUES = values();

        FilterType(int i) {
            this.value = i;
        }

        public static FilterType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return TIME;
                    }
                    return LOCATION;
                }
                return DEFAULT;
            }
            return UNKNOWN_FILTER_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return PersonalProfileProtos.getDescriptor().getEnumTypes().get(7);
        }

        public static Internal.EnumLiteMap<FilterType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static FilterType valueOf(int i) {
            return forNumber(i);
        }

        public static FilterType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/profile/PersonalProfileProtos$GiftFrom.class */
    public enum GiftFrom implements ProtocolMessageEnum {
        UNKNOWN_GIFT_FROM(0),
        PERSONAL_PAGE(1),
        MESSAGE_PAGE(2),
        UNRECOGNIZED(-1);
        
        public static final int MESSAGE_PAGE_VALUE = 2;
        public static final int PERSONAL_PAGE_VALUE = 1;
        public static final int UNKNOWN_GIFT_FROM_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<GiftFrom> internalValueMap = new Internal.EnumLiteMap<GiftFrom>() { // from class: com.blued.das.profile.PersonalProfileProtos.GiftFrom.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public GiftFrom findValueByNumber(int i) {
                return GiftFrom.forNumber(i);
            }
        };
        private static final GiftFrom[] VALUES = values();

        GiftFrom(int i) {
            this.value = i;
        }

        public static GiftFrom forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return MESSAGE_PAGE;
                }
                return PERSONAL_PAGE;
            }
            return UNKNOWN_GIFT_FROM;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return PersonalProfileProtos.getDescriptor().getEnumTypes().get(5);
        }

        public static Internal.EnumLiteMap<GiftFrom> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static GiftFrom valueOf(int i) {
            return forNumber(i);
        }

        public static GiftFrom valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/profile/PersonalProfileProtos$PersonalProfileProto.class */
    public static final class PersonalProfileProto extends GeneratedMessageV3 implements PersonalProfileProtoOrBuilder {
        public static final int CODE_FIELD_NUMBER = 50;
        public static final int DESC_ID_FIELD_NUMBER = 47;
        public static final int DISTANCE_FIELD_NUMBER = 6;
        public static final int EVENT_FIELD_NUMBER = 1;
        public static final int FEED_ID_FIELD_NUMBER = 18;
        public static final int FILTER_TYPE_FIELD_NUMBER = 34;
        public static final int GIFT_FROM_FIELD_NUMBER = 16;
        public static final int GIFT_ID_FIELD_NUMBER = 13;
        public static final int IDENTITY_NUM_FIELD_NUMBER = 24;
        public static final int ID_FIELD_NUMBER = 28;
        public static final int IS_AI_FIELD_NUMBER = 33;
        public static final int IS_APPRECIATE_CALL_FIELD_NUMBER = 11;
        public static final int IS_BAG_FIELD_NUMBER = 27;
        public static final int IS_FOLLOW_FIELD_NUMBER = 23;
        public static final int IS_HOT_FIELD_NUMBER = 37;
        public static final int IS_ICON_FIELD_NUMBER = 36;
        public static final int IS_MAP_FIND_FIELD_NUMBER = 20;
        public static final int IS_NEW_FIELD_NUMBER = 43;
        public static final int IS_OPEN_FIELD_NUMBER = 25;
        public static final int IS_QUIET_CALL_FIELD_NUMBER = 22;
        public static final int IS_SHADOW_FIELD_NUMBER = 21;
        public static final int IS_SPECIAL_FIELD_NUMBER = 38;
        public static final int IS_SUPER_CALL_FIELD_NUMBER = 44;
        public static final int IS_SUPER_EXPOSURE_FIELD_NUMBER = 12;
        public static final int IS_TRUE_FIELD_NUMBER = 42;
        public static final int IS_VIDEO_FIELD_NUMBER = 26;
        public static final int LABEL_FIELD_NUMBER = 9;
        public static final int LINK_URL_FIELD_NUMBER = 17;
        public static final int LIVE_ID_FIELD_NUMBER = 29;
        public static final int LIVE_RATE_FIELD_NUMBER = 48;
        public static final int LOGO_ID_FIELD_NUMBER = 45;
        public static final int MODE_FIELD_NUMBER = 39;
        public static final int NAME_FIELD_NUMBER = 35;
        public static final int ONLINE_TIME_FIELD_NUMBER = 7;
        public static final int PHOTO_NUM_FIELD_NUMBER = 10;
        public static final int POSITION_FIELD_NUMBER = 30;
        public static final int QA_ID_FIELD_NUMBER = 46;
        public static final int REASON_FIELD_NUMBER = 8;
        public static final int SHOW_TYPE_FIELD_NUMBER = 5;
        public static final int SIMILARITY_FIELD_NUMBER = 49;
        public static final int SOURCE_FIELD_NUMBER = 2;
        public static final int STRATEGY_FIELD_NUMBER = 40;
        public static final int TAB_TYPE_FIELD_NUMBER = 14;
        public static final int TARGET_IDENTITY_TYPE_FIELD_NUMBER = 19;
        public static final int TARGET_UID_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 31;
        public static final int URL_FIELD_NUMBER = 32;
        public static final int VIRTUAL_FIELD_NUMBER = 41;
        public static final int VOTE_OPTION_FIELD_NUMBER = 15;
        private static final long serialVersionUID = 0;
        private volatile Object code_;
        private volatile Object descId_;
        private volatile Object distance_;
        private int event_;
        private volatile Object feedId_;
        private int filterType_;
        private int giftFrom_;
        private volatile Object giftId_;
        private volatile Object id_;
        private int identityNum_;
        private boolean isAi_;
        private boolean isAppreciateCall_;
        private boolean isBag_;
        private boolean isFollow_;
        private boolean isHot_;
        private boolean isIcon_;
        private boolean isMapFind_;
        private boolean isNew_;
        private boolean isOpen_;
        private boolean isQuietCall_;
        private boolean isShadow_;
        private boolean isSpecial_;
        private boolean isSuperCall_;
        private boolean isSuperExposure_;
        private boolean isTrue_;
        private boolean isVideo_;
        private volatile Object label_;
        private volatile Object linkUrl_;
        private volatile Object liveId_;
        private volatile Object liveRate_;
        private volatile Object logoId_;
        private byte memoizedIsInitialized;
        private volatile Object mode_;
        private volatile Object name_;
        private volatile Object onlineTime_;
        private int photoNum_;
        private int position_;
        private volatile Object qaId_;
        private int reason_;
        private int showType_;
        private volatile Object similarity_;
        private int source_;
        private volatile Object strategy_;
        private int tabType_;
        private int targetIdentityType_;
        private volatile Object targetUid_;
        private int type_;
        private volatile Object url_;
        private int virtual_;
        private int voteOption_;
        private static final PersonalProfileProto DEFAULT_INSTANCE = new PersonalProfileProto();
        private static final Parser<PersonalProfileProto> PARSER = new AbstractParser<PersonalProfileProto>() { // from class: com.blued.das.profile.PersonalProfileProtos.PersonalProfileProto.1
            @Override // com.google.protobuf.Parser
            public PersonalProfileProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PersonalProfileProto(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/profile/PersonalProfileProtos$PersonalProfileProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PersonalProfileProtoOrBuilder {
            private Object code_;
            private Object descId_;
            private Object distance_;
            private int event_;
            private Object feedId_;
            private int filterType_;
            private int giftFrom_;
            private Object giftId_;
            private Object id_;
            private int identityNum_;
            private boolean isAi_;
            private boolean isAppreciateCall_;
            private boolean isBag_;
            private boolean isFollow_;
            private boolean isHot_;
            private boolean isIcon_;
            private boolean isMapFind_;
            private boolean isNew_;
            private boolean isOpen_;
            private boolean isQuietCall_;
            private boolean isShadow_;
            private boolean isSpecial_;
            private boolean isSuperCall_;
            private boolean isSuperExposure_;
            private boolean isTrue_;
            private boolean isVideo_;
            private Object label_;
            private Object linkUrl_;
            private Object liveId_;
            private Object liveRate_;
            private Object logoId_;
            private Object mode_;
            private Object name_;
            private Object onlineTime_;
            private int photoNum_;
            private int position_;
            private Object qaId_;
            private int reason_;
            private int showType_;
            private Object similarity_;
            private int source_;
            private Object strategy_;
            private int tabType_;
            private int targetIdentityType_;
            private Object targetUid_;
            private int type_;
            private Object url_;
            private int virtual_;
            private int voteOption_;

            private Builder() {
                this.event_ = 0;
                this.source_ = 0;
                this.targetUid_ = "";
                this.showType_ = 0;
                this.distance_ = "";
                this.onlineTime_ = "";
                this.label_ = "";
                this.giftId_ = "";
                this.tabType_ = 0;
                this.voteOption_ = 0;
                this.giftFrom_ = 0;
                this.linkUrl_ = "";
                this.feedId_ = "";
                this.targetIdentityType_ = 0;
                this.id_ = "";
                this.liveId_ = "";
                this.url_ = "";
                this.filterType_ = 0;
                this.name_ = "";
                this.mode_ = "";
                this.strategy_ = "";
                this.logoId_ = "";
                this.qaId_ = "";
                this.descId_ = "";
                this.liveRate_ = "";
                this.similarity_ = "";
                this.code_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.event_ = 0;
                this.source_ = 0;
                this.targetUid_ = "";
                this.showType_ = 0;
                this.distance_ = "";
                this.onlineTime_ = "";
                this.label_ = "";
                this.giftId_ = "";
                this.tabType_ = 0;
                this.voteOption_ = 0;
                this.giftFrom_ = 0;
                this.linkUrl_ = "";
                this.feedId_ = "";
                this.targetIdentityType_ = 0;
                this.id_ = "";
                this.liveId_ = "";
                this.url_ = "";
                this.filterType_ = 0;
                this.name_ = "";
                this.mode_ = "";
                this.strategy_ = "";
                this.logoId_ = "";
                this.qaId_ = "";
                this.descId_ = "";
                this.liveRate_ = "";
                this.similarity_ = "";
                this.code_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PersonalProfileProtos.internal_static_com_blued_das_profile_PersonalProfileProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = PersonalProfileProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PersonalProfileProto build() {
                PersonalProfileProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PersonalProfileProto buildPartial() {
                PersonalProfileProto personalProfileProto = new PersonalProfileProto(this);
                personalProfileProto.event_ = this.event_;
                personalProfileProto.source_ = this.source_;
                personalProfileProto.targetUid_ = this.targetUid_;
                personalProfileProto.showType_ = this.showType_;
                personalProfileProto.distance_ = this.distance_;
                personalProfileProto.onlineTime_ = this.onlineTime_;
                personalProfileProto.reason_ = this.reason_;
                personalProfileProto.label_ = this.label_;
                personalProfileProto.photoNum_ = this.photoNum_;
                personalProfileProto.isAppreciateCall_ = this.isAppreciateCall_;
                personalProfileProto.isSuperExposure_ = this.isSuperExposure_;
                personalProfileProto.giftId_ = this.giftId_;
                personalProfileProto.tabType_ = this.tabType_;
                personalProfileProto.voteOption_ = this.voteOption_;
                personalProfileProto.giftFrom_ = this.giftFrom_;
                personalProfileProto.linkUrl_ = this.linkUrl_;
                personalProfileProto.feedId_ = this.feedId_;
                personalProfileProto.targetIdentityType_ = this.targetIdentityType_;
                personalProfileProto.isMapFind_ = this.isMapFind_;
                personalProfileProto.isShadow_ = this.isShadow_;
                personalProfileProto.isQuietCall_ = this.isQuietCall_;
                personalProfileProto.isFollow_ = this.isFollow_;
                personalProfileProto.identityNum_ = this.identityNum_;
                personalProfileProto.isOpen_ = this.isOpen_;
                personalProfileProto.isVideo_ = this.isVideo_;
                personalProfileProto.isBag_ = this.isBag_;
                personalProfileProto.id_ = this.id_;
                personalProfileProto.liveId_ = this.liveId_;
                personalProfileProto.position_ = this.position_;
                personalProfileProto.type_ = this.type_;
                personalProfileProto.url_ = this.url_;
                personalProfileProto.isAi_ = this.isAi_;
                personalProfileProto.filterType_ = this.filterType_;
                personalProfileProto.name_ = this.name_;
                personalProfileProto.isIcon_ = this.isIcon_;
                personalProfileProto.isHot_ = this.isHot_;
                personalProfileProto.isSpecial_ = this.isSpecial_;
                personalProfileProto.mode_ = this.mode_;
                personalProfileProto.strategy_ = this.strategy_;
                personalProfileProto.virtual_ = this.virtual_;
                personalProfileProto.isTrue_ = this.isTrue_;
                personalProfileProto.isNew_ = this.isNew_;
                personalProfileProto.isSuperCall_ = this.isSuperCall_;
                personalProfileProto.logoId_ = this.logoId_;
                personalProfileProto.qaId_ = this.qaId_;
                personalProfileProto.descId_ = this.descId_;
                personalProfileProto.liveRate_ = this.liveRate_;
                personalProfileProto.similarity_ = this.similarity_;
                personalProfileProto.code_ = this.code_;
                onBuilt();
                return personalProfileProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.event_ = 0;
                this.source_ = 0;
                this.targetUid_ = "";
                this.showType_ = 0;
                this.distance_ = "";
                this.onlineTime_ = "";
                this.reason_ = 0;
                this.label_ = "";
                this.photoNum_ = 0;
                this.isAppreciateCall_ = false;
                this.isSuperExposure_ = false;
                this.giftId_ = "";
                this.tabType_ = 0;
                this.voteOption_ = 0;
                this.giftFrom_ = 0;
                this.linkUrl_ = "";
                this.feedId_ = "";
                this.targetIdentityType_ = 0;
                this.isMapFind_ = false;
                this.isShadow_ = false;
                this.isQuietCall_ = false;
                this.isFollow_ = false;
                this.identityNum_ = 0;
                this.isOpen_ = false;
                this.isVideo_ = false;
                this.isBag_ = false;
                this.id_ = "";
                this.liveId_ = "";
                this.position_ = 0;
                this.type_ = 0;
                this.url_ = "";
                this.isAi_ = false;
                this.filterType_ = 0;
                this.name_ = "";
                this.isIcon_ = false;
                this.isHot_ = false;
                this.isSpecial_ = false;
                this.mode_ = "";
                this.strategy_ = "";
                this.virtual_ = 0;
                this.isTrue_ = false;
                this.isNew_ = false;
                this.isSuperCall_ = false;
                this.logoId_ = "";
                this.qaId_ = "";
                this.descId_ = "";
                this.liveRate_ = "";
                this.similarity_ = "";
                this.code_ = "";
                return this;
            }

            public Builder clearCode() {
                this.code_ = PersonalProfileProto.getDefaultInstance().getCode();
                onChanged();
                return this;
            }

            public Builder clearDescId() {
                this.descId_ = PersonalProfileProto.getDefaultInstance().getDescId();
                onChanged();
                return this;
            }

            public Builder clearDistance() {
                this.distance_ = PersonalProfileProto.getDefaultInstance().getDistance();
                onChanged();
                return this;
            }

            public Builder clearEvent() {
                this.event_ = 0;
                onChanged();
                return this;
            }

            public Builder clearFeedId() {
                this.feedId_ = PersonalProfileProto.getDefaultInstance().getFeedId();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearFilterType() {
                this.filterType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearGiftFrom() {
                this.giftFrom_ = 0;
                onChanged();
                return this;
            }

            public Builder clearGiftId() {
                this.giftId_ = PersonalProfileProto.getDefaultInstance().getGiftId();
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = PersonalProfileProto.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            public Builder clearIdentityNum() {
                this.identityNum_ = 0;
                onChanged();
                return this;
            }

            public Builder clearIsAi() {
                this.isAi_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsAppreciateCall() {
                this.isAppreciateCall_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsBag() {
                this.isBag_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsFollow() {
                this.isFollow_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsHot() {
                this.isHot_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsIcon() {
                this.isIcon_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsMapFind() {
                this.isMapFind_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsNew() {
                this.isNew_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsQuietCall() {
                this.isQuietCall_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsShadow() {
                this.isShadow_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsSpecial() {
                this.isSpecial_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsSuperCall() {
                this.isSuperCall_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsSuperExposure() {
                this.isSuperExposure_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsTrue() {
                this.isTrue_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsVideo() {
                this.isVideo_ = false;
                onChanged();
                return this;
            }

            public Builder clearLabel() {
                this.label_ = PersonalProfileProto.getDefaultInstance().getLabel();
                onChanged();
                return this;
            }

            public Builder clearLinkUrl() {
                this.linkUrl_ = PersonalProfileProto.getDefaultInstance().getLinkUrl();
                onChanged();
                return this;
            }

            public Builder clearLiveId() {
                this.liveId_ = PersonalProfileProto.getDefaultInstance().getLiveId();
                onChanged();
                return this;
            }

            public Builder clearLiveRate() {
                this.liveRate_ = PersonalProfileProto.getDefaultInstance().getLiveRate();
                onChanged();
                return this;
            }

            public Builder clearLogoId() {
                this.logoId_ = PersonalProfileProto.getDefaultInstance().getLogoId();
                onChanged();
                return this;
            }

            public Builder clearMode() {
                this.mode_ = PersonalProfileProto.getDefaultInstance().getMode();
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = PersonalProfileProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearOnlineTime() {
                this.onlineTime_ = PersonalProfileProto.getDefaultInstance().getOnlineTime();
                onChanged();
                return this;
            }

            public Builder clearPhotoNum() {
                this.photoNum_ = 0;
                onChanged();
                return this;
            }

            public Builder clearPosition() {
                this.position_ = 0;
                onChanged();
                return this;
            }

            public Builder clearQaId() {
                this.qaId_ = PersonalProfileProto.getDefaultInstance().getQaId();
                onChanged();
                return this;
            }

            public Builder clearReason() {
                this.reason_ = 0;
                onChanged();
                return this;
            }

            public Builder clearShowType() {
                this.showType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSimilarity() {
                this.similarity_ = PersonalProfileProto.getDefaultInstance().getSimilarity();
                onChanged();
                return this;
            }

            public Builder clearSource() {
                this.source_ = 0;
                onChanged();
                return this;
            }

            public Builder clearStrategy() {
                this.strategy_ = PersonalProfileProto.getDefaultInstance().getStrategy();
                onChanged();
                return this;
            }

            public Builder clearTabType() {
                this.tabType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTargetIdentityType() {
                this.targetIdentityType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = PersonalProfileProto.getDefaultInstance().getTargetUid();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            public Builder clearUrl() {
                this.url_ = PersonalProfileProto.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            public Builder clearVirtual() {
                this.virtual_ = 0;
                onChanged();
                return this;
            }

            public Builder clearVoteOption() {
                this.voteOption_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public String getCode() {
                Object obj = this.code_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.code_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
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
            public PersonalProfileProto getDefaultInstanceForType() {
                return PersonalProfileProto.getDefaultInstance();
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public String getDescId() {
                Object obj = this.descId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.descId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public ByteString getDescIdBytes() {
                Object obj = this.descId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.descId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PersonalProfileProtos.internal_static_com_blued_das_profile_PersonalProfileProto_descriptor;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public String getDistance() {
                Object obj = this.distance_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.distance_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public ByteString getDistanceBytes() {
                Object obj = this.distance_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.distance_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public Event getEvent() {
                Event valueOf = Event.valueOf(this.event_);
                Event event = valueOf;
                if (valueOf == null) {
                    event = Event.UNRECOGNIZED;
                }
                return event;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public int getEventValue() {
                return this.event_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public String getFeedId() {
                Object obj = this.feedId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.feedId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public ByteString getFeedIdBytes() {
                Object obj = this.feedId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.feedId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public FilterType getFilterType() {
                FilterType valueOf = FilterType.valueOf(this.filterType_);
                FilterType filterType = valueOf;
                if (valueOf == null) {
                    filterType = FilterType.UNRECOGNIZED;
                }
                return filterType;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public int getFilterTypeValue() {
                return this.filterType_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public GiftFrom getGiftFrom() {
                GiftFrom valueOf = GiftFrom.valueOf(this.giftFrom_);
                GiftFrom giftFrom = valueOf;
                if (valueOf == null) {
                    giftFrom = GiftFrom.UNRECOGNIZED;
                }
                return giftFrom;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public int getGiftFromValue() {
                return this.giftFrom_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public String getGiftId() {
                Object obj = this.giftId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.giftId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public ByteString getGiftIdBytes() {
                Object obj = this.giftId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.giftId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public String getId() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.id_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public ByteString getIdBytes() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.id_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public int getIdentityNum() {
                return this.identityNum_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public boolean getIsAi() {
                return this.isAi_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public boolean getIsAppreciateCall() {
                return this.isAppreciateCall_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public boolean getIsBag() {
                return this.isBag_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public boolean getIsFollow() {
                return this.isFollow_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public boolean getIsHot() {
                return this.isHot_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public boolean getIsIcon() {
                return this.isIcon_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public boolean getIsMapFind() {
                return this.isMapFind_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public boolean getIsNew() {
                return this.isNew_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public boolean getIsQuietCall() {
                return this.isQuietCall_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public boolean getIsShadow() {
                return this.isShadow_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public boolean getIsSpecial() {
                return this.isSpecial_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public boolean getIsSuperCall() {
                return this.isSuperCall_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public boolean getIsSuperExposure() {
                return this.isSuperExposure_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public boolean getIsTrue() {
                return this.isTrue_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public boolean getIsVideo() {
                return this.isVideo_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public String getLabel() {
                Object obj = this.label_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.label_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public ByteString getLabelBytes() {
                Object obj = this.label_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.label_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public String getLinkUrl() {
                Object obj = this.linkUrl_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.linkUrl_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public ByteString getLinkUrlBytes() {
                Object obj = this.linkUrl_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.linkUrl_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public String getLiveId() {
                Object obj = this.liveId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.liveId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public ByteString getLiveIdBytes() {
                Object obj = this.liveId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.liveId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public String getLiveRate() {
                Object obj = this.liveRate_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.liveRate_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public ByteString getLiveRateBytes() {
                Object obj = this.liveRate_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.liveRate_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public String getLogoId() {
                Object obj = this.logoId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.logoId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public ByteString getLogoIdBytes() {
                Object obj = this.logoId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.logoId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public String getMode() {
                Object obj = this.mode_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.mode_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public ByteString getModeBytes() {
                Object obj = this.mode_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.mode_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public String getOnlineTime() {
                Object obj = this.onlineTime_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.onlineTime_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public ByteString getOnlineTimeBytes() {
                Object obj = this.onlineTime_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.onlineTime_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public int getPhotoNum() {
                return this.photoNum_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public int getPosition() {
                return this.position_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public String getQaId() {
                Object obj = this.qaId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.qaId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public ByteString getQaIdBytes() {
                Object obj = this.qaId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.qaId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public int getReason() {
                return this.reason_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public ShowType getShowType() {
                ShowType valueOf = ShowType.valueOf(this.showType_);
                ShowType showType = valueOf;
                if (valueOf == null) {
                    showType = ShowType.UNRECOGNIZED;
                }
                return showType;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public int getShowTypeValue() {
                return this.showType_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public String getSimilarity() {
                Object obj = this.similarity_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.similarity_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public ByteString getSimilarityBytes() {
                Object obj = this.similarity_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.similarity_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public Source getSource() {
                Source valueOf = Source.valueOf(this.source_);
                Source source = valueOf;
                if (valueOf == null) {
                    source = Source.UNRECOGNIZED;
                }
                return source;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public int getSourceValue() {
                return this.source_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public String getStrategy() {
                Object obj = this.strategy_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.strategy_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public ByteString getStrategyBytes() {
                Object obj = this.strategy_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.strategy_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public TabType getTabType() {
                TabType valueOf = TabType.valueOf(this.tabType_);
                TabType tabType = valueOf;
                if (valueOf == null) {
                    tabType = TabType.UNRECOGNIZED;
                }
                return tabType;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public int getTabTypeValue() {
                return this.tabType_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public TargetIdentityType getTargetIdentityType() {
                TargetIdentityType valueOf = TargetIdentityType.valueOf(this.targetIdentityType_);
                TargetIdentityType targetIdentityType = valueOf;
                if (valueOf == null) {
                    targetIdentityType = TargetIdentityType.UNRECOGNIZED;
                }
                return targetIdentityType;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public int getTargetIdentityTypeValue() {
                return this.targetIdentityType_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public String getTargetUid() {
                Object obj = this.targetUid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.targetUid_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public ByteString getTargetUidBytes() {
                Object obj = this.targetUid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.targetUid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public int getType() {
                return this.type_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public String getUrl() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public ByteString getUrlBytes() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.url_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public int getVirtual() {
                return this.virtual_;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public VoteOption getVoteOption() {
                VoteOption valueOf = VoteOption.valueOf(this.voteOption_);
                VoteOption voteOption = valueOf;
                if (valueOf == null) {
                    voteOption = VoteOption.UNRECOGNIZED;
                }
                return voteOption;
            }

            @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
            public int getVoteOptionValue() {
                return this.voteOption_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PersonalProfileProtos.internal_static_com_blued_das_profile_PersonalProfileProto_fieldAccessorTable.ensureFieldAccessorsInitialized(PersonalProfileProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(PersonalProfileProto personalProfileProto) {
                if (personalProfileProto == PersonalProfileProto.getDefaultInstance()) {
                    return this;
                }
                if (personalProfileProto.event_ != 0) {
                    setEventValue(personalProfileProto.getEventValue());
                }
                if (personalProfileProto.source_ != 0) {
                    setSourceValue(personalProfileProto.getSourceValue());
                }
                if (!personalProfileProto.getTargetUid().isEmpty()) {
                    this.targetUid_ = personalProfileProto.targetUid_;
                    onChanged();
                }
                if (personalProfileProto.showType_ != 0) {
                    setShowTypeValue(personalProfileProto.getShowTypeValue());
                }
                if (!personalProfileProto.getDistance().isEmpty()) {
                    this.distance_ = personalProfileProto.distance_;
                    onChanged();
                }
                if (!personalProfileProto.getOnlineTime().isEmpty()) {
                    this.onlineTime_ = personalProfileProto.onlineTime_;
                    onChanged();
                }
                if (personalProfileProto.getReason() != 0) {
                    setReason(personalProfileProto.getReason());
                }
                if (!personalProfileProto.getLabel().isEmpty()) {
                    this.label_ = personalProfileProto.label_;
                    onChanged();
                }
                if (personalProfileProto.getPhotoNum() != 0) {
                    setPhotoNum(personalProfileProto.getPhotoNum());
                }
                if (personalProfileProto.getIsAppreciateCall()) {
                    setIsAppreciateCall(personalProfileProto.getIsAppreciateCall());
                }
                if (personalProfileProto.getIsSuperExposure()) {
                    setIsSuperExposure(personalProfileProto.getIsSuperExposure());
                }
                if (!personalProfileProto.getGiftId().isEmpty()) {
                    this.giftId_ = personalProfileProto.giftId_;
                    onChanged();
                }
                if (personalProfileProto.tabType_ != 0) {
                    setTabTypeValue(personalProfileProto.getTabTypeValue());
                }
                if (personalProfileProto.voteOption_ != 0) {
                    setVoteOptionValue(personalProfileProto.getVoteOptionValue());
                }
                if (personalProfileProto.giftFrom_ != 0) {
                    setGiftFromValue(personalProfileProto.getGiftFromValue());
                }
                if (!personalProfileProto.getLinkUrl().isEmpty()) {
                    this.linkUrl_ = personalProfileProto.linkUrl_;
                    onChanged();
                }
                if (!personalProfileProto.getFeedId().isEmpty()) {
                    this.feedId_ = personalProfileProto.feedId_;
                    onChanged();
                }
                if (personalProfileProto.targetIdentityType_ != 0) {
                    setTargetIdentityTypeValue(personalProfileProto.getTargetIdentityTypeValue());
                }
                if (personalProfileProto.getIsMapFind()) {
                    setIsMapFind(personalProfileProto.getIsMapFind());
                }
                if (personalProfileProto.getIsShadow()) {
                    setIsShadow(personalProfileProto.getIsShadow());
                }
                if (personalProfileProto.getIsQuietCall()) {
                    setIsQuietCall(personalProfileProto.getIsQuietCall());
                }
                if (personalProfileProto.getIsFollow()) {
                    setIsFollow(personalProfileProto.getIsFollow());
                }
                if (personalProfileProto.getIdentityNum() != 0) {
                    setIdentityNum(personalProfileProto.getIdentityNum());
                }
                if (personalProfileProto.getIsOpen()) {
                    setIsOpen(personalProfileProto.getIsOpen());
                }
                if (personalProfileProto.getIsVideo()) {
                    setIsVideo(personalProfileProto.getIsVideo());
                }
                if (personalProfileProto.getIsBag()) {
                    setIsBag(personalProfileProto.getIsBag());
                }
                if (!personalProfileProto.getId().isEmpty()) {
                    this.id_ = personalProfileProto.id_;
                    onChanged();
                }
                if (!personalProfileProto.getLiveId().isEmpty()) {
                    this.liveId_ = personalProfileProto.liveId_;
                    onChanged();
                }
                if (personalProfileProto.getPosition() != 0) {
                    setPosition(personalProfileProto.getPosition());
                }
                if (personalProfileProto.getType() != 0) {
                    setType(personalProfileProto.getType());
                }
                if (!personalProfileProto.getUrl().isEmpty()) {
                    this.url_ = personalProfileProto.url_;
                    onChanged();
                }
                if (personalProfileProto.getIsAi()) {
                    setIsAi(personalProfileProto.getIsAi());
                }
                if (personalProfileProto.filterType_ != 0) {
                    setFilterTypeValue(personalProfileProto.getFilterTypeValue());
                }
                if (!personalProfileProto.getName().isEmpty()) {
                    this.name_ = personalProfileProto.name_;
                    onChanged();
                }
                if (personalProfileProto.getIsIcon()) {
                    setIsIcon(personalProfileProto.getIsIcon());
                }
                if (personalProfileProto.getIsHot()) {
                    setIsHot(personalProfileProto.getIsHot());
                }
                if (personalProfileProto.getIsSpecial()) {
                    setIsSpecial(personalProfileProto.getIsSpecial());
                }
                if (!personalProfileProto.getMode().isEmpty()) {
                    this.mode_ = personalProfileProto.mode_;
                    onChanged();
                }
                if (!personalProfileProto.getStrategy().isEmpty()) {
                    this.strategy_ = personalProfileProto.strategy_;
                    onChanged();
                }
                if (personalProfileProto.getVirtual() != 0) {
                    setVirtual(personalProfileProto.getVirtual());
                }
                if (personalProfileProto.getIsTrue()) {
                    setIsTrue(personalProfileProto.getIsTrue());
                }
                if (personalProfileProto.getIsNew()) {
                    setIsNew(personalProfileProto.getIsNew());
                }
                if (personalProfileProto.getIsSuperCall()) {
                    setIsSuperCall(personalProfileProto.getIsSuperCall());
                }
                if (!personalProfileProto.getLogoId().isEmpty()) {
                    this.logoId_ = personalProfileProto.logoId_;
                    onChanged();
                }
                if (!personalProfileProto.getQaId().isEmpty()) {
                    this.qaId_ = personalProfileProto.qaId_;
                    onChanged();
                }
                if (!personalProfileProto.getDescId().isEmpty()) {
                    this.descId_ = personalProfileProto.descId_;
                    onChanged();
                }
                if (!personalProfileProto.getLiveRate().isEmpty()) {
                    this.liveRate_ = personalProfileProto.liveRate_;
                    onChanged();
                }
                if (!personalProfileProto.getSimilarity().isEmpty()) {
                    this.similarity_ = personalProfileProto.similarity_;
                    onChanged();
                }
                if (!personalProfileProto.getCode().isEmpty()) {
                    this.code_ = personalProfileProto.code_;
                    onChanged();
                }
                mergeUnknownFields(personalProfileProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.profile.PersonalProfileProtos.PersonalProfileProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.profile.PersonalProfileProtos.PersonalProfileProto.access$5600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.profile.PersonalProfileProtos$PersonalProfileProto r0 = (com.blued.das.profile.PersonalProfileProtos.PersonalProfileProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.profile.PersonalProfileProtos$PersonalProfileProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.profile.PersonalProfileProtos$PersonalProfileProto r0 = (com.blued.das.profile.PersonalProfileProtos.PersonalProfileProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.profile.PersonalProfileProtos$PersonalProfileProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.profile.PersonalProfileProtos.PersonalProfileProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.profile.PersonalProfileProtos$PersonalProfileProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof PersonalProfileProto) {
                    return mergeFrom((PersonalProfileProto) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
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
                    PersonalProfileProto.checkByteStringIsUtf8(byteString);
                    this.code_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDescId(String str) {
                if (str != null) {
                    this.descId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDescIdBytes(ByteString byteString) {
                if (byteString != null) {
                    PersonalProfileProto.checkByteStringIsUtf8(byteString);
                    this.descId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDistance(String str) {
                if (str != null) {
                    this.distance_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDistanceBytes(ByteString byteString) {
                if (byteString != null) {
                    PersonalProfileProto.checkByteStringIsUtf8(byteString);
                    this.distance_ = byteString;
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

            public Builder setFeedId(String str) {
                if (str != null) {
                    this.feedId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setFeedIdBytes(ByteString byteString) {
                if (byteString != null) {
                    PersonalProfileProto.checkByteStringIsUtf8(byteString);
                    this.feedId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setFilterType(FilterType filterType) {
                if (filterType != null) {
                    this.filterType_ = filterType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setFilterTypeValue(int i) {
                this.filterType_ = i;
                onChanged();
                return this;
            }

            public Builder setGiftFrom(GiftFrom giftFrom) {
                if (giftFrom != null) {
                    this.giftFrom_ = giftFrom.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setGiftFromValue(int i) {
                this.giftFrom_ = i;
                onChanged();
                return this;
            }

            public Builder setGiftId(String str) {
                if (str != null) {
                    this.giftId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setGiftIdBytes(ByteString byteString) {
                if (byteString != null) {
                    PersonalProfileProto.checkByteStringIsUtf8(byteString);
                    this.giftId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
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
                    PersonalProfileProto.checkByteStringIsUtf8(byteString);
                    this.id_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setIdentityNum(int i) {
                this.identityNum_ = i;
                onChanged();
                return this;
            }

            public Builder setIsAi(boolean z) {
                this.isAi_ = z;
                onChanged();
                return this;
            }

            public Builder setIsAppreciateCall(boolean z) {
                this.isAppreciateCall_ = z;
                onChanged();
                return this;
            }

            public Builder setIsBag(boolean z) {
                this.isBag_ = z;
                onChanged();
                return this;
            }

            public Builder setIsFollow(boolean z) {
                this.isFollow_ = z;
                onChanged();
                return this;
            }

            public Builder setIsHot(boolean z) {
                this.isHot_ = z;
                onChanged();
                return this;
            }

            public Builder setIsIcon(boolean z) {
                this.isIcon_ = z;
                onChanged();
                return this;
            }

            public Builder setIsMapFind(boolean z) {
                this.isMapFind_ = z;
                onChanged();
                return this;
            }

            public Builder setIsNew(boolean z) {
                this.isNew_ = z;
                onChanged();
                return this;
            }

            public Builder setIsOpen(boolean z) {
                this.isOpen_ = z;
                onChanged();
                return this;
            }

            public Builder setIsQuietCall(boolean z) {
                this.isQuietCall_ = z;
                onChanged();
                return this;
            }

            public Builder setIsShadow(boolean z) {
                this.isShadow_ = z;
                onChanged();
                return this;
            }

            public Builder setIsSpecial(boolean z) {
                this.isSpecial_ = z;
                onChanged();
                return this;
            }

            public Builder setIsSuperCall(boolean z) {
                this.isSuperCall_ = z;
                onChanged();
                return this;
            }

            public Builder setIsSuperExposure(boolean z) {
                this.isSuperExposure_ = z;
                onChanged();
                return this;
            }

            public Builder setIsTrue(boolean z) {
                this.isTrue_ = z;
                onChanged();
                return this;
            }

            public Builder setIsVideo(boolean z) {
                this.isVideo_ = z;
                onChanged();
                return this;
            }

            public Builder setLabel(String str) {
                if (str != null) {
                    this.label_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLabelBytes(ByteString byteString) {
                if (byteString != null) {
                    PersonalProfileProto.checkByteStringIsUtf8(byteString);
                    this.label_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
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
                    PersonalProfileProto.checkByteStringIsUtf8(byteString);
                    this.linkUrl_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLiveId(String str) {
                if (str != null) {
                    this.liveId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLiveIdBytes(ByteString byteString) {
                if (byteString != null) {
                    PersonalProfileProto.checkByteStringIsUtf8(byteString);
                    this.liveId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLiveRate(String str) {
                if (str != null) {
                    this.liveRate_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLiveRateBytes(ByteString byteString) {
                if (byteString != null) {
                    PersonalProfileProto.checkByteStringIsUtf8(byteString);
                    this.liveRate_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLogoId(String str) {
                if (str != null) {
                    this.logoId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLogoIdBytes(ByteString byteString) {
                if (byteString != null) {
                    PersonalProfileProto.checkByteStringIsUtf8(byteString);
                    this.logoId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMode(String str) {
                if (str != null) {
                    this.mode_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setModeBytes(ByteString byteString) {
                if (byteString != null) {
                    PersonalProfileProto.checkByteStringIsUtf8(byteString);
                    this.mode_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
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
                    PersonalProfileProto.checkByteStringIsUtf8(byteString);
                    this.name_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setOnlineTime(String str) {
                if (str != null) {
                    this.onlineTime_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setOnlineTimeBytes(ByteString byteString) {
                if (byteString != null) {
                    PersonalProfileProto.checkByteStringIsUtf8(byteString);
                    this.onlineTime_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPhotoNum(int i) {
                this.photoNum_ = i;
                onChanged();
                return this;
            }

            public Builder setPosition(int i) {
                this.position_ = i;
                onChanged();
                return this;
            }

            public Builder setQaId(String str) {
                if (str != null) {
                    this.qaId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setQaIdBytes(ByteString byteString) {
                if (byteString != null) {
                    PersonalProfileProto.checkByteStringIsUtf8(byteString);
                    this.qaId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setReason(int i) {
                this.reason_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setShowType(ShowType showType) {
                if (showType != null) {
                    this.showType_ = showType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setShowTypeValue(int i) {
                this.showType_ = i;
                onChanged();
                return this;
            }

            public Builder setSimilarity(String str) {
                if (str != null) {
                    this.similarity_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setSimilarityBytes(ByteString byteString) {
                if (byteString != null) {
                    PersonalProfileProto.checkByteStringIsUtf8(byteString);
                    this.similarity_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
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

            public Builder setStrategy(String str) {
                if (str != null) {
                    this.strategy_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setStrategyBytes(ByteString byteString) {
                if (byteString != null) {
                    PersonalProfileProto.checkByteStringIsUtf8(byteString);
                    this.strategy_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTabType(TabType tabType) {
                if (tabType != null) {
                    this.tabType_ = tabType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTabTypeValue(int i) {
                this.tabType_ = i;
                onChanged();
                return this;
            }

            public Builder setTargetIdentityType(TargetIdentityType targetIdentityType) {
                if (targetIdentityType != null) {
                    this.targetIdentityType_ = targetIdentityType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTargetIdentityTypeValue(int i) {
                this.targetIdentityType_ = i;
                onChanged();
                return this;
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
                    PersonalProfileProto.checkByteStringIsUtf8(byteString);
                    this.targetUid_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setType(int i) {
                this.type_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public Builder setUrl(String str) {
                if (str != null) {
                    this.url_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setUrlBytes(ByteString byteString) {
                if (byteString != null) {
                    PersonalProfileProto.checkByteStringIsUtf8(byteString);
                    this.url_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setVirtual(int i) {
                this.virtual_ = i;
                onChanged();
                return this;
            }

            public Builder setVoteOption(VoteOption voteOption) {
                if (voteOption != null) {
                    this.voteOption_ = voteOption.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setVoteOptionValue(int i) {
                this.voteOption_ = i;
                onChanged();
                return this;
            }
        }

        private PersonalProfileProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.event_ = 0;
            this.source_ = 0;
            this.targetUid_ = "";
            this.showType_ = 0;
            this.distance_ = "";
            this.onlineTime_ = "";
            this.label_ = "";
            this.giftId_ = "";
            this.tabType_ = 0;
            this.voteOption_ = 0;
            this.giftFrom_ = 0;
            this.linkUrl_ = "";
            this.feedId_ = "";
            this.targetIdentityType_ = 0;
            this.id_ = "";
            this.liveId_ = "";
            this.url_ = "";
            this.filterType_ = 0;
            this.name_ = "";
            this.mode_ = "";
            this.strategy_ = "";
            this.logoId_ = "";
            this.qaId_ = "";
            this.descId_ = "";
            this.liveRate_ = "";
            this.similarity_ = "";
            this.code_ = "";
        }

        private PersonalProfileProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw null;
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
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
                                this.source_ = codedInputStream.readEnum();
                                continue;
                            case 26:
                                this.targetUid_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 40:
                                this.showType_ = codedInputStream.readEnum();
                                continue;
                            case 50:
                                this.distance_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 58:
                                this.onlineTime_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 64:
                                this.reason_ = codedInputStream.readInt32();
                                continue;
                            case 74:
                                this.label_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 80:
                                this.photoNum_ = codedInputStream.readInt32();
                                continue;
                            case 88:
                                this.isAppreciateCall_ = codedInputStream.readBool();
                                continue;
                            case 96:
                                this.isSuperExposure_ = codedInputStream.readBool();
                                continue;
                            case 106:
                                this.giftId_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 112:
                                this.tabType_ = codedInputStream.readEnum();
                                continue;
                            case 120:
                                this.voteOption_ = codedInputStream.readEnum();
                                continue;
                            case 128:
                                this.giftFrom_ = codedInputStream.readEnum();
                                continue;
                            case 138:
                                this.linkUrl_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 146:
                                this.feedId_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 152:
                                this.targetIdentityType_ = codedInputStream.readEnum();
                                continue;
                            case 160:
                                this.isMapFind_ = codedInputStream.readBool();
                                continue;
                            case 168:
                                this.isShadow_ = codedInputStream.readBool();
                                continue;
                            case 176:
                                this.isQuietCall_ = codedInputStream.readBool();
                                continue;
                            case 184:
                                this.isFollow_ = codedInputStream.readBool();
                                continue;
                            case 192:
                                this.identityNum_ = codedInputStream.readInt32();
                                continue;
                            case 200:
                                this.isOpen_ = codedInputStream.readBool();
                                continue;
                            case 208:
                                this.isVideo_ = codedInputStream.readBool();
                                continue;
                            case 216:
                                this.isBag_ = codedInputStream.readBool();
                                continue;
                            case 226:
                                this.id_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 234:
                                this.liveId_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 240:
                                this.position_ = codedInputStream.readInt32();
                                continue;
                            case 248:
                                this.type_ = codedInputStream.readInt32();
                                continue;
                            case 258:
                                this.url_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 264:
                                this.isAi_ = codedInputStream.readBool();
                                continue;
                            case 272:
                                this.filterType_ = codedInputStream.readEnum();
                                continue;
                            case 282:
                                this.name_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 288:
                                this.isIcon_ = codedInputStream.readBool();
                                continue;
                            case 296:
                                this.isHot_ = codedInputStream.readBool();
                                continue;
                            case 304:
                                this.isSpecial_ = codedInputStream.readBool();
                                continue;
                            case 314:
                                this.mode_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 322:
                                this.strategy_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 328:
                                this.virtual_ = codedInputStream.readInt32();
                                continue;
                            case 336:
                                this.isTrue_ = codedInputStream.readBool();
                                continue;
                            case 344:
                                this.isNew_ = codedInputStream.readBool();
                                continue;
                            case 352:
                                this.isSuperCall_ = codedInputStream.readBool();
                                continue;
                            case 362:
                                this.logoId_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 370:
                                this.qaId_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 378:
                                this.descId_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 386:
                                this.liveRate_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 394:
                                this.similarity_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 402:
                                this.code_ = codedInputStream.readStringRequireUtf8();
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
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        private PersonalProfileProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static PersonalProfileProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PersonalProfileProtos.internal_static_com_blued_das_profile_PersonalProfileProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PersonalProfileProto personalProfileProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(personalProfileProto);
        }

        public static PersonalProfileProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PersonalProfileProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static PersonalProfileProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PersonalProfileProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PersonalProfileProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static PersonalProfileProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static PersonalProfileProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PersonalProfileProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static PersonalProfileProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PersonalProfileProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static PersonalProfileProto parseFrom(InputStream inputStream) throws IOException {
            return (PersonalProfileProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static PersonalProfileProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PersonalProfileProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PersonalProfileProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static PersonalProfileProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static PersonalProfileProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static PersonalProfileProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<PersonalProfileProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof PersonalProfileProto) {
                PersonalProfileProto personalProfileProto = (PersonalProfileProto) obj;
                return this.event_ == personalProfileProto.event_ && this.source_ == personalProfileProto.source_ && getTargetUid().equals(personalProfileProto.getTargetUid()) && this.showType_ == personalProfileProto.showType_ && getDistance().equals(personalProfileProto.getDistance()) && getOnlineTime().equals(personalProfileProto.getOnlineTime()) && getReason() == personalProfileProto.getReason() && getLabel().equals(personalProfileProto.getLabel()) && getPhotoNum() == personalProfileProto.getPhotoNum() && getIsAppreciateCall() == personalProfileProto.getIsAppreciateCall() && getIsSuperExposure() == personalProfileProto.getIsSuperExposure() && getGiftId().equals(personalProfileProto.getGiftId()) && this.tabType_ == personalProfileProto.tabType_ && this.voteOption_ == personalProfileProto.voteOption_ && this.giftFrom_ == personalProfileProto.giftFrom_ && getLinkUrl().equals(personalProfileProto.getLinkUrl()) && getFeedId().equals(personalProfileProto.getFeedId()) && this.targetIdentityType_ == personalProfileProto.targetIdentityType_ && getIsMapFind() == personalProfileProto.getIsMapFind() && getIsShadow() == personalProfileProto.getIsShadow() && getIsQuietCall() == personalProfileProto.getIsQuietCall() && getIsFollow() == personalProfileProto.getIsFollow() && getIdentityNum() == personalProfileProto.getIdentityNum() && getIsOpen() == personalProfileProto.getIsOpen() && getIsVideo() == personalProfileProto.getIsVideo() && getIsBag() == personalProfileProto.getIsBag() && getId().equals(personalProfileProto.getId()) && getLiveId().equals(personalProfileProto.getLiveId()) && getPosition() == personalProfileProto.getPosition() && getType() == personalProfileProto.getType() && getUrl().equals(personalProfileProto.getUrl()) && getIsAi() == personalProfileProto.getIsAi() && this.filterType_ == personalProfileProto.filterType_ && getName().equals(personalProfileProto.getName()) && getIsIcon() == personalProfileProto.getIsIcon() && getIsHot() == personalProfileProto.getIsHot() && getIsSpecial() == personalProfileProto.getIsSpecial() && getMode().equals(personalProfileProto.getMode()) && getStrategy().equals(personalProfileProto.getStrategy()) && getVirtual() == personalProfileProto.getVirtual() && getIsTrue() == personalProfileProto.getIsTrue() && getIsNew() == personalProfileProto.getIsNew() && getIsSuperCall() == personalProfileProto.getIsSuperCall() && getLogoId().equals(personalProfileProto.getLogoId()) && getQaId().equals(personalProfileProto.getQaId()) && getDescId().equals(personalProfileProto.getDescId()) && getLiveRate().equals(personalProfileProto.getLiveRate()) && getSimilarity().equals(personalProfileProto.getSimilarity()) && getCode().equals(personalProfileProto.getCode()) && this.unknownFields.equals(personalProfileProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public String getCode() {
            Object obj = this.code_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.code_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
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
        public PersonalProfileProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public String getDescId() {
            Object obj = this.descId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.descId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public ByteString getDescIdBytes() {
            Object obj = this.descId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.descId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public String getDistance() {
            Object obj = this.distance_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.distance_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public ByteString getDistanceBytes() {
            Object obj = this.distance_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.distance_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public Event getEvent() {
            Event valueOf = Event.valueOf(this.event_);
            Event event = valueOf;
            if (valueOf == null) {
                event = Event.UNRECOGNIZED;
            }
            return event;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public int getEventValue() {
            return this.event_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public String getFeedId() {
            Object obj = this.feedId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.feedId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public ByteString getFeedIdBytes() {
            Object obj = this.feedId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.feedId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public FilterType getFilterType() {
            FilterType valueOf = FilterType.valueOf(this.filterType_);
            FilterType filterType = valueOf;
            if (valueOf == null) {
                filterType = FilterType.UNRECOGNIZED;
            }
            return filterType;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public int getFilterTypeValue() {
            return this.filterType_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public GiftFrom getGiftFrom() {
            GiftFrom valueOf = GiftFrom.valueOf(this.giftFrom_);
            GiftFrom giftFrom = valueOf;
            if (valueOf == null) {
                giftFrom = GiftFrom.UNRECOGNIZED;
            }
            return giftFrom;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public int getGiftFromValue() {
            return this.giftFrom_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public String getGiftId() {
            Object obj = this.giftId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public ByteString getGiftIdBytes() {
            Object obj = this.giftId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public String getId() {
            Object obj = this.id_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.id_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public ByteString getIdBytes() {
            Object obj = this.id_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.id_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public int getIdentityNum() {
            return this.identityNum_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public boolean getIsAi() {
            return this.isAi_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public boolean getIsAppreciateCall() {
            return this.isAppreciateCall_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public boolean getIsBag() {
            return this.isBag_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public boolean getIsFollow() {
            return this.isFollow_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public boolean getIsHot() {
            return this.isHot_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public boolean getIsIcon() {
            return this.isIcon_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public boolean getIsMapFind() {
            return this.isMapFind_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public boolean getIsNew() {
            return this.isNew_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public boolean getIsQuietCall() {
            return this.isQuietCall_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public boolean getIsShadow() {
            return this.isShadow_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public boolean getIsSpecial() {
            return this.isSpecial_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public boolean getIsSuperCall() {
            return this.isSuperCall_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public boolean getIsSuperExposure() {
            return this.isSuperExposure_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public boolean getIsTrue() {
            return this.isTrue_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public boolean getIsVideo() {
            return this.isVideo_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public String getLabel() {
            Object obj = this.label_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.label_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public ByteString getLabelBytes() {
            Object obj = this.label_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.label_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public String getLinkUrl() {
            Object obj = this.linkUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.linkUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public ByteString getLinkUrlBytes() {
            Object obj = this.linkUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.linkUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public String getLiveId() {
            Object obj = this.liveId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.liveId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public ByteString getLiveIdBytes() {
            Object obj = this.liveId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.liveId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public String getLiveRate() {
            Object obj = this.liveRate_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.liveRate_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public ByteString getLiveRateBytes() {
            Object obj = this.liveRate_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.liveRate_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public String getLogoId() {
            Object obj = this.logoId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.logoId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public ByteString getLogoIdBytes() {
            Object obj = this.logoId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.logoId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public String getMode() {
            Object obj = this.mode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.mode_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public ByteString getModeBytes() {
            Object obj = this.mode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public String getOnlineTime() {
            Object obj = this.onlineTime_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.onlineTime_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public ByteString getOnlineTimeBytes() {
            Object obj = this.onlineTime_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.onlineTime_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PersonalProfileProto> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public int getPhotoNum() {
            return this.photoNum_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public int getPosition() {
            return this.position_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public String getQaId() {
            Object obj = this.qaId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.qaId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public ByteString getQaIdBytes() {
            Object obj = this.qaId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.qaId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public int getReason() {
            return this.reason_;
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
            if (this.source_ != Source.UNKNOWN_FOLLOW_SOURCE.getNumber()) {
                i3 = i2 + CodedOutputStream.computeEnumSize(2, this.source_);
            }
            int i4 = i3;
            if (!getTargetUidBytes().isEmpty()) {
                i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.targetUid_);
            }
            int i5 = i4;
            if (this.showType_ != ShowType.UNKNOWN_SHOW_TYPE.getNumber()) {
                i5 = i4 + CodedOutputStream.computeEnumSize(5, this.showType_);
            }
            int i6 = i5;
            if (!getDistanceBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(6, this.distance_);
            }
            int i7 = i6;
            if (!getOnlineTimeBytes().isEmpty()) {
                i7 = i6 + GeneratedMessageV3.computeStringSize(7, this.onlineTime_);
            }
            int i8 = this.reason_;
            int i9 = i7;
            if (i8 != 0) {
                i9 = i7 + CodedOutputStream.computeInt32Size(8, i8);
            }
            int i10 = i9;
            if (!getLabelBytes().isEmpty()) {
                i10 = i9 + GeneratedMessageV3.computeStringSize(9, this.label_);
            }
            int i11 = this.photoNum_;
            int i12 = i10;
            if (i11 != 0) {
                i12 = i10 + CodedOutputStream.computeInt32Size(10, i11);
            }
            boolean z = this.isAppreciateCall_;
            int i13 = i12;
            if (z) {
                i13 = i12 + CodedOutputStream.computeBoolSize(11, z);
            }
            boolean z2 = this.isSuperExposure_;
            int i14 = i13;
            if (z2) {
                i14 = i13 + CodedOutputStream.computeBoolSize(12, z2);
            }
            int i15 = i14;
            if (!getGiftIdBytes().isEmpty()) {
                i15 = i14 + GeneratedMessageV3.computeStringSize(13, this.giftId_);
            }
            int i16 = i15;
            if (this.tabType_ != TabType.UNKNOWN_TAB_TYPE.getNumber()) {
                i16 = i15 + CodedOutputStream.computeEnumSize(14, this.tabType_);
            }
            int i17 = i16;
            if (this.voteOption_ != VoteOption.UNKNOWN_VOTE_OPTION.getNumber()) {
                i17 = i16 + CodedOutputStream.computeEnumSize(15, this.voteOption_);
            }
            int i18 = i17;
            if (this.giftFrom_ != GiftFrom.UNKNOWN_GIFT_FROM.getNumber()) {
                i18 = i17 + CodedOutputStream.computeEnumSize(16, this.giftFrom_);
            }
            int i19 = i18;
            if (!getLinkUrlBytes().isEmpty()) {
                i19 = i18 + GeneratedMessageV3.computeStringSize(17, this.linkUrl_);
            }
            int i20 = i19;
            if (!getFeedIdBytes().isEmpty()) {
                i20 = i19 + GeneratedMessageV3.computeStringSize(18, this.feedId_);
            }
            int i21 = i20;
            if (this.targetIdentityType_ != TargetIdentityType.UNKNOWN_TARGET_IDENTITY_TYPE.getNumber()) {
                i21 = i20 + CodedOutputStream.computeEnumSize(19, this.targetIdentityType_);
            }
            boolean z3 = this.isMapFind_;
            int i22 = i21;
            if (z3) {
                i22 = i21 + CodedOutputStream.computeBoolSize(20, z3);
            }
            boolean z4 = this.isShadow_;
            int i23 = i22;
            if (z4) {
                i23 = i22 + CodedOutputStream.computeBoolSize(21, z4);
            }
            boolean z5 = this.isQuietCall_;
            int i24 = i23;
            if (z5) {
                i24 = i23 + CodedOutputStream.computeBoolSize(22, z5);
            }
            boolean z6 = this.isFollow_;
            int i25 = i24;
            if (z6) {
                i25 = i24 + CodedOutputStream.computeBoolSize(23, z6);
            }
            int i26 = this.identityNum_;
            int i27 = i25;
            if (i26 != 0) {
                i27 = i25 + CodedOutputStream.computeInt32Size(24, i26);
            }
            boolean z7 = this.isOpen_;
            int i28 = i27;
            if (z7) {
                i28 = i27 + CodedOutputStream.computeBoolSize(25, z7);
            }
            boolean z8 = this.isVideo_;
            int i29 = i28;
            if (z8) {
                i29 = i28 + CodedOutputStream.computeBoolSize(26, z8);
            }
            boolean z9 = this.isBag_;
            int i30 = i29;
            if (z9) {
                i30 = i29 + CodedOutputStream.computeBoolSize(27, z9);
            }
            int i31 = i30;
            if (!getIdBytes().isEmpty()) {
                i31 = i30 + GeneratedMessageV3.computeStringSize(28, this.id_);
            }
            int i32 = i31;
            if (!getLiveIdBytes().isEmpty()) {
                i32 = i31 + GeneratedMessageV3.computeStringSize(29, this.liveId_);
            }
            int i33 = this.position_;
            int i34 = i32;
            if (i33 != 0) {
                i34 = i32 + CodedOutputStream.computeInt32Size(30, i33);
            }
            int i35 = this.type_;
            int i36 = i34;
            if (i35 != 0) {
                i36 = i34 + CodedOutputStream.computeInt32Size(31, i35);
            }
            int i37 = i36;
            if (!getUrlBytes().isEmpty()) {
                i37 = i36 + GeneratedMessageV3.computeStringSize(32, this.url_);
            }
            boolean z10 = this.isAi_;
            int i38 = i37;
            if (z10) {
                i38 = i37 + CodedOutputStream.computeBoolSize(33, z10);
            }
            int i39 = i38;
            if (this.filterType_ != FilterType.UNKNOWN_FILTER_TYPE.getNumber()) {
                i39 = i38 + CodedOutputStream.computeEnumSize(34, this.filterType_);
            }
            int i40 = i39;
            if (!getNameBytes().isEmpty()) {
                i40 = i39 + GeneratedMessageV3.computeStringSize(35, this.name_);
            }
            boolean z11 = this.isIcon_;
            int i41 = i40;
            if (z11) {
                i41 = i40 + CodedOutputStream.computeBoolSize(36, z11);
            }
            boolean z12 = this.isHot_;
            int i42 = i41;
            if (z12) {
                i42 = i41 + CodedOutputStream.computeBoolSize(37, z12);
            }
            boolean z13 = this.isSpecial_;
            int i43 = i42;
            if (z13) {
                i43 = i42 + CodedOutputStream.computeBoolSize(38, z13);
            }
            int i44 = i43;
            if (!getModeBytes().isEmpty()) {
                i44 = i43 + GeneratedMessageV3.computeStringSize(39, this.mode_);
            }
            int i45 = i44;
            if (!getStrategyBytes().isEmpty()) {
                i45 = i44 + GeneratedMessageV3.computeStringSize(40, this.strategy_);
            }
            int i46 = this.virtual_;
            int i47 = i45;
            if (i46 != 0) {
                i47 = i45 + CodedOutputStream.computeInt32Size(41, i46);
            }
            boolean z14 = this.isTrue_;
            int i48 = i47;
            if (z14) {
                i48 = i47 + CodedOutputStream.computeBoolSize(42, z14);
            }
            boolean z15 = this.isNew_;
            int i49 = i48;
            if (z15) {
                i49 = i48 + CodedOutputStream.computeBoolSize(43, z15);
            }
            boolean z16 = this.isSuperCall_;
            int i50 = i49;
            if (z16) {
                i50 = i49 + CodedOutputStream.computeBoolSize(44, z16);
            }
            int i51 = i50;
            if (!getLogoIdBytes().isEmpty()) {
                i51 = i50 + GeneratedMessageV3.computeStringSize(45, this.logoId_);
            }
            int i52 = i51;
            if (!getQaIdBytes().isEmpty()) {
                i52 = i51 + GeneratedMessageV3.computeStringSize(46, this.qaId_);
            }
            int i53 = i52;
            if (!getDescIdBytes().isEmpty()) {
                i53 = i52 + GeneratedMessageV3.computeStringSize(47, this.descId_);
            }
            int i54 = i53;
            if (!getLiveRateBytes().isEmpty()) {
                i54 = i53 + GeneratedMessageV3.computeStringSize(48, this.liveRate_);
            }
            int i55 = i54;
            if (!getSimilarityBytes().isEmpty()) {
                i55 = i54 + GeneratedMessageV3.computeStringSize(49, this.similarity_);
            }
            int i56 = i55;
            if (!getCodeBytes().isEmpty()) {
                i56 = i55 + GeneratedMessageV3.computeStringSize(50, this.code_);
            }
            int serializedSize = i56 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public ShowType getShowType() {
            ShowType valueOf = ShowType.valueOf(this.showType_);
            ShowType showType = valueOf;
            if (valueOf == null) {
                showType = ShowType.UNRECOGNIZED;
            }
            return showType;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public int getShowTypeValue() {
            return this.showType_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public String getSimilarity() {
            Object obj = this.similarity_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.similarity_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public ByteString getSimilarityBytes() {
            Object obj = this.similarity_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.similarity_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public Source getSource() {
            Source valueOf = Source.valueOf(this.source_);
            Source source = valueOf;
            if (valueOf == null) {
                source = Source.UNRECOGNIZED;
            }
            return source;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public int getSourceValue() {
            return this.source_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public String getStrategy() {
            Object obj = this.strategy_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.strategy_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public ByteString getStrategyBytes() {
            Object obj = this.strategy_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.strategy_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public TabType getTabType() {
            TabType valueOf = TabType.valueOf(this.tabType_);
            TabType tabType = valueOf;
            if (valueOf == null) {
                tabType = TabType.UNRECOGNIZED;
            }
            return tabType;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public int getTabTypeValue() {
            return this.tabType_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public TargetIdentityType getTargetIdentityType() {
            TargetIdentityType valueOf = TargetIdentityType.valueOf(this.targetIdentityType_);
            TargetIdentityType targetIdentityType = valueOf;
            if (valueOf == null) {
                targetIdentityType = TargetIdentityType.UNRECOGNIZED;
            }
            return targetIdentityType;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public int getTargetIdentityTypeValue() {
            return this.targetIdentityType_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public String getTargetUid() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.targetUid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public ByteString getTargetUidBytes() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.targetUid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public int getVirtual() {
            return this.virtual_;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public VoteOption getVoteOption() {
            VoteOption valueOf = VoteOption.valueOf(this.voteOption_);
            VoteOption voteOption = valueOf;
            if (valueOf == null) {
                voteOption = VoteOption.UNRECOGNIZED;
            }
            return voteOption;
        }

        @Override // com.blued.das.profile.PersonalProfileProtos.PersonalProfileProtoOrBuilder
        public int getVoteOptionValue() {
            return this.voteOption_;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.event_) * 37) + 2) * 53) + this.source_) * 37) + 3) * 53) + getTargetUid().hashCode()) * 37) + 5) * 53) + this.showType_) * 37) + 6) * 53) + getDistance().hashCode()) * 37) + 7) * 53) + getOnlineTime().hashCode()) * 37) + 8) * 53) + getReason()) * 37) + 9) * 53) + getLabel().hashCode()) * 37) + 10) * 53) + getPhotoNum()) * 37) + 11) * 53) + Internal.hashBoolean(getIsAppreciateCall())) * 37) + 12) * 53) + Internal.hashBoolean(getIsSuperExposure())) * 37) + 13) * 53) + getGiftId().hashCode()) * 37) + 14) * 53) + this.tabType_) * 37) + 15) * 53) + this.voteOption_) * 37) + 16) * 53) + this.giftFrom_) * 37) + 17) * 53) + getLinkUrl().hashCode()) * 37) + 18) * 53) + getFeedId().hashCode()) * 37) + 19) * 53) + this.targetIdentityType_) * 37) + 20) * 53) + Internal.hashBoolean(getIsMapFind())) * 37) + 21) * 53) + Internal.hashBoolean(getIsShadow())) * 37) + 22) * 53) + Internal.hashBoolean(getIsQuietCall())) * 37) + 23) * 53) + Internal.hashBoolean(getIsFollow())) * 37) + 24) * 53) + getIdentityNum()) * 37) + 25) * 53) + Internal.hashBoolean(getIsOpen())) * 37) + 26) * 53) + Internal.hashBoolean(getIsVideo())) * 37) + 27) * 53) + Internal.hashBoolean(getIsBag())) * 37) + 28) * 53) + getId().hashCode()) * 37) + 29) * 53) + getLiveId().hashCode()) * 37) + 30) * 53) + getPosition()) * 37) + 31) * 53) + getType()) * 37) + 32) * 53) + getUrl().hashCode()) * 37) + 33) * 53) + Internal.hashBoolean(getIsAi())) * 37) + 34) * 53) + this.filterType_) * 37) + 35) * 53) + getName().hashCode()) * 37) + 36) * 53) + Internal.hashBoolean(getIsIcon())) * 37) + 37) * 53) + Internal.hashBoolean(getIsHot())) * 37) + 38) * 53) + Internal.hashBoolean(getIsSpecial())) * 37) + 39) * 53) + getMode().hashCode()) * 37) + 40) * 53) + getStrategy().hashCode()) * 37) + 41) * 53) + getVirtual()) * 37) + 42) * 53) + Internal.hashBoolean(getIsTrue())) * 37) + 43) * 53) + Internal.hashBoolean(getIsNew())) * 37) + 44) * 53) + Internal.hashBoolean(getIsSuperCall())) * 37) + 45) * 53) + getLogoId().hashCode()) * 37) + 46) * 53) + getQaId().hashCode()) * 37) + 47) * 53) + getDescId().hashCode()) * 37) + 48) * 53) + getLiveRate().hashCode()) * 37) + 49) * 53) + getSimilarity().hashCode()) * 37) + 50) * 53) + getCode().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PersonalProfileProtos.internal_static_com_blued_das_profile_PersonalProfileProto_fieldAccessorTable.ensureFieldAccessorsInitialized(PersonalProfileProto.class, Builder.class);
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
            return new PersonalProfileProto();
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
            if (this.source_ != Source.UNKNOWN_FOLLOW_SOURCE.getNumber()) {
                codedOutputStream.writeEnum(2, this.source_);
            }
            if (!getTargetUidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.targetUid_);
            }
            if (this.showType_ != ShowType.UNKNOWN_SHOW_TYPE.getNumber()) {
                codedOutputStream.writeEnum(5, this.showType_);
            }
            if (!getDistanceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.distance_);
            }
            if (!getOnlineTimeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.onlineTime_);
            }
            int i = this.reason_;
            if (i != 0) {
                codedOutputStream.writeInt32(8, i);
            }
            if (!getLabelBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 9, this.label_);
            }
            int i2 = this.photoNum_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(10, i2);
            }
            boolean z = this.isAppreciateCall_;
            if (z) {
                codedOutputStream.writeBool(11, z);
            }
            boolean z2 = this.isSuperExposure_;
            if (z2) {
                codedOutputStream.writeBool(12, z2);
            }
            if (!getGiftIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 13, this.giftId_);
            }
            if (this.tabType_ != TabType.UNKNOWN_TAB_TYPE.getNumber()) {
                codedOutputStream.writeEnum(14, this.tabType_);
            }
            if (this.voteOption_ != VoteOption.UNKNOWN_VOTE_OPTION.getNumber()) {
                codedOutputStream.writeEnum(15, this.voteOption_);
            }
            if (this.giftFrom_ != GiftFrom.UNKNOWN_GIFT_FROM.getNumber()) {
                codedOutputStream.writeEnum(16, this.giftFrom_);
            }
            if (!getLinkUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 17, this.linkUrl_);
            }
            if (!getFeedIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 18, this.feedId_);
            }
            if (this.targetIdentityType_ != TargetIdentityType.UNKNOWN_TARGET_IDENTITY_TYPE.getNumber()) {
                codedOutputStream.writeEnum(19, this.targetIdentityType_);
            }
            boolean z3 = this.isMapFind_;
            if (z3) {
                codedOutputStream.writeBool(20, z3);
            }
            boolean z4 = this.isShadow_;
            if (z4) {
                codedOutputStream.writeBool(21, z4);
            }
            boolean z5 = this.isQuietCall_;
            if (z5) {
                codedOutputStream.writeBool(22, z5);
            }
            boolean z6 = this.isFollow_;
            if (z6) {
                codedOutputStream.writeBool(23, z6);
            }
            int i3 = this.identityNum_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(24, i3);
            }
            boolean z7 = this.isOpen_;
            if (z7) {
                codedOutputStream.writeBool(25, z7);
            }
            boolean z8 = this.isVideo_;
            if (z8) {
                codedOutputStream.writeBool(26, z8);
            }
            boolean z9 = this.isBag_;
            if (z9) {
                codedOutputStream.writeBool(27, z9);
            }
            if (!getIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 28, this.id_);
            }
            if (!getLiveIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 29, this.liveId_);
            }
            int i4 = this.position_;
            if (i4 != 0) {
                codedOutputStream.writeInt32(30, i4);
            }
            int i5 = this.type_;
            if (i5 != 0) {
                codedOutputStream.writeInt32(31, i5);
            }
            if (!getUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 32, this.url_);
            }
            boolean z10 = this.isAi_;
            if (z10) {
                codedOutputStream.writeBool(33, z10);
            }
            if (this.filterType_ != FilterType.UNKNOWN_FILTER_TYPE.getNumber()) {
                codedOutputStream.writeEnum(34, this.filterType_);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 35, this.name_);
            }
            boolean z11 = this.isIcon_;
            if (z11) {
                codedOutputStream.writeBool(36, z11);
            }
            boolean z12 = this.isHot_;
            if (z12) {
                codedOutputStream.writeBool(37, z12);
            }
            boolean z13 = this.isSpecial_;
            if (z13) {
                codedOutputStream.writeBool(38, z13);
            }
            if (!getModeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 39, this.mode_);
            }
            if (!getStrategyBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 40, this.strategy_);
            }
            int i6 = this.virtual_;
            if (i6 != 0) {
                codedOutputStream.writeInt32(41, i6);
            }
            boolean z14 = this.isTrue_;
            if (z14) {
                codedOutputStream.writeBool(42, z14);
            }
            boolean z15 = this.isNew_;
            if (z15) {
                codedOutputStream.writeBool(43, z15);
            }
            boolean z16 = this.isSuperCall_;
            if (z16) {
                codedOutputStream.writeBool(44, z16);
            }
            if (!getLogoIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 45, this.logoId_);
            }
            if (!getQaIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 46, this.qaId_);
            }
            if (!getDescIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 47, this.descId_);
            }
            if (!getLiveRateBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 48, this.liveRate_);
            }
            if (!getSimilarityBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 49, this.similarity_);
            }
            if (!getCodeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 50, this.code_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/profile/PersonalProfileProtos$PersonalProfileProtoOrBuilder.class */
    public interface PersonalProfileProtoOrBuilder extends MessageOrBuilder {
        String getCode();

        ByteString getCodeBytes();

        String getDescId();

        ByteString getDescIdBytes();

        String getDistance();

        ByteString getDistanceBytes();

        Event getEvent();

        int getEventValue();

        String getFeedId();

        ByteString getFeedIdBytes();

        FilterType getFilterType();

        int getFilterTypeValue();

        GiftFrom getGiftFrom();

        int getGiftFromValue();

        String getGiftId();

        ByteString getGiftIdBytes();

        String getId();

        ByteString getIdBytes();

        int getIdentityNum();

        boolean getIsAi();

        boolean getIsAppreciateCall();

        boolean getIsBag();

        boolean getIsFollow();

        boolean getIsHot();

        boolean getIsIcon();

        boolean getIsMapFind();

        boolean getIsNew();

        boolean getIsOpen();

        boolean getIsQuietCall();

        boolean getIsShadow();

        boolean getIsSpecial();

        boolean getIsSuperCall();

        boolean getIsSuperExposure();

        boolean getIsTrue();

        boolean getIsVideo();

        String getLabel();

        ByteString getLabelBytes();

        String getLinkUrl();

        ByteString getLinkUrlBytes();

        String getLiveId();

        ByteString getLiveIdBytes();

        String getLiveRate();

        ByteString getLiveRateBytes();

        String getLogoId();

        ByteString getLogoIdBytes();

        String getMode();

        ByteString getModeBytes();

        String getName();

        ByteString getNameBytes();

        String getOnlineTime();

        ByteString getOnlineTimeBytes();

        int getPhotoNum();

        int getPosition();

        String getQaId();

        ByteString getQaIdBytes();

        int getReason();

        ShowType getShowType();

        int getShowTypeValue();

        String getSimilarity();

        ByteString getSimilarityBytes();

        Source getSource();

        int getSourceValue();

        String getStrategy();

        ByteString getStrategyBytes();

        TabType getTabType();

        int getTabTypeValue();

        TargetIdentityType getTargetIdentityType();

        int getTargetIdentityTypeValue();

        String getTargetUid();

        ByteString getTargetUidBytes();

        int getType();

        String getUrl();

        ByteString getUrlBytes();

        int getVirtual();

        VoteOption getVoteOption();

        int getVoteOptionValue();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/profile/PersonalProfileProtos$ShowType.class */
    public enum ShowType implements ProtocolMessageEnum {
        UNKNOWN_SHOW_TYPE(0),
        PALACE_SHOW(1),
        LIST_SHOW(2),
        UNRECOGNIZED(-1);
        
        public static final int LIST_SHOW_VALUE = 2;
        public static final int PALACE_SHOW_VALUE = 1;
        public static final int UNKNOWN_SHOW_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<ShowType> internalValueMap = new Internal.EnumLiteMap<ShowType>() { // from class: com.blued.das.profile.PersonalProfileProtos.ShowType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ShowType findValueByNumber(int i) {
                return ShowType.forNumber(i);
            }
        };
        private static final ShowType[] VALUES = values();

        ShowType(int i) {
            this.value = i;
        }

        public static ShowType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return LIST_SHOW;
                }
                return PALACE_SHOW;
            }
            return UNKNOWN_SHOW_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return PersonalProfileProtos.getDescriptor().getEnumTypes().get(2);
        }

        public static Internal.EnumLiteMap<ShowType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static ShowType valueOf(int i) {
            return forNumber(i);
        }

        public static ShowType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/profile/PersonalProfileProtos$Source.class */
    public enum Source implements ProtocolMessageEnum {
        UNKNOWN_FOLLOW_SOURCE(0),
        FRIEND_NEARBY_VISIT(1),
        FRIEND_NEARBY_VIEW(2),
        FOLLOW_ATTENTION(3),
        FEED_FIND_PHOTO(4),
        FEED_FIND_PLAZA(5),
        APPRECIATE_CALL_SHORT(6),
        APPRECIATE_CALL_TOTAL(7),
        MINE_FOLLOW(8),
        MINE_FAN(9),
        MINE_FRIEND(10),
        COMPLEX_SORT(11),
        ONLINE_TIME_SORT(12),
        DISTANCE_SORT(13),
        NEARBY_FEATURED(14),
        FEED_COMMENT(15),
        NEW_FACE(16),
        SUPER_TOPIC_DETAIL(17),
        FIND_PLAZA_RECOMMEND_USER(18),
        FIND_PLAZA_RECOMMEND(19),
        FIND_PLAZA_FOLLOW(20),
        FIND_PLAZA_NEARBY(21),
        FIND_PLAZA_IMAGE(22),
        FIND_PLAZA_FLASH(23),
        FIND_PLAZA_FLASH_DETAIL(24),
        FEED_DETAIL(25),
        PAGE_FEED_MINE(26),
        PAGE_FEED_LIKE(27),
        PAGE_FEED_DETAIL_MORE(28),
        CIRCLE_NOTE_DETAIL(29),
        CIRCLE_DETAIL_NOTE_NEW(30),
        CIRCLE_DETAIL_NOTE_HOT(31),
        CIRCLE_USERS(32),
        ONE_CITY(33),
        FIND_TOPIC_FEED(34),
        CIRCLE_ACTIVE_MEMBER_LIST(35),
        CIRCLE_ACTIVE_MEMBER_MISSION(36),
        NOTICE_FOLLOW_ME(37),
        CITY_TIME(38),
        FEED_IMAGE_FULL_SCREEN(39),
        PERSONAL_VIDEO_FULL_SCREEN(40),
        MSG_TOP_TITLE(41),
        MSG_PHOTO(42),
        MSG_SETTING_PHOTO(43),
        NOTICE_LIKE(44),
        LITE_RECOMMEND(45),
        HOT_BUBBLE(46),
        CITY_ALL_IMAGE(47),
        CITY_ALL_VIDEO(48),
        CITY_ALL_DETAIL(49),
        RECOMMEND_IMAGE(50),
        RECOMMEND_VIDEO(51),
        RECOMMEND_DETAIL(52),
        CITY_NOTE(53),
        CITY_TIME_NOTE(54),
        MAP_FRIEND_USER(55),
        NEARBY_OPERATION(56),
        SAME_USER(57),
        PUSH_CALL(58),
        PERSONAL_PHOTO(59),
        PERSONAL_FEED(60),
        TOPIC_RECOMMEND(61),
        TOPIC_NEW(62),
        UNRECOGNIZED(-1);
        
        public static final int APPRECIATE_CALL_SHORT_VALUE = 6;
        public static final int APPRECIATE_CALL_TOTAL_VALUE = 7;
        public static final int CIRCLE_ACTIVE_MEMBER_LIST_VALUE = 35;
        public static final int CIRCLE_ACTIVE_MEMBER_MISSION_VALUE = 36;
        public static final int CIRCLE_DETAIL_NOTE_HOT_VALUE = 31;
        public static final int CIRCLE_DETAIL_NOTE_NEW_VALUE = 30;
        public static final int CIRCLE_NOTE_DETAIL_VALUE = 29;
        public static final int CIRCLE_USERS_VALUE = 32;
        public static final int CITY_ALL_DETAIL_VALUE = 49;
        public static final int CITY_ALL_IMAGE_VALUE = 47;
        public static final int CITY_ALL_VIDEO_VALUE = 48;
        public static final int CITY_NOTE_VALUE = 53;
        public static final int CITY_TIME_NOTE_VALUE = 54;
        public static final int CITY_TIME_VALUE = 38;
        public static final int COMPLEX_SORT_VALUE = 11;
        public static final int DISTANCE_SORT_VALUE = 13;
        public static final int FEED_COMMENT_VALUE = 15;
        public static final int FEED_DETAIL_VALUE = 25;
        public static final int FEED_FIND_PHOTO_VALUE = 4;
        public static final int FEED_FIND_PLAZA_VALUE = 5;
        public static final int FEED_IMAGE_FULL_SCREEN_VALUE = 39;
        public static final int FIND_PLAZA_FLASH_DETAIL_VALUE = 24;
        public static final int FIND_PLAZA_FLASH_VALUE = 23;
        public static final int FIND_PLAZA_FOLLOW_VALUE = 20;
        public static final int FIND_PLAZA_IMAGE_VALUE = 22;
        public static final int FIND_PLAZA_NEARBY_VALUE = 21;
        public static final int FIND_PLAZA_RECOMMEND_USER_VALUE = 18;
        public static final int FIND_PLAZA_RECOMMEND_VALUE = 19;
        public static final int FIND_TOPIC_FEED_VALUE = 34;
        public static final int FOLLOW_ATTENTION_VALUE = 3;
        public static final int FRIEND_NEARBY_VIEW_VALUE = 2;
        public static final int FRIEND_NEARBY_VISIT_VALUE = 1;
        public static final int HOT_BUBBLE_VALUE = 46;
        public static final int LITE_RECOMMEND_VALUE = 45;
        public static final int MAP_FRIEND_USER_VALUE = 55;
        public static final int MINE_FAN_VALUE = 9;
        public static final int MINE_FOLLOW_VALUE = 8;
        public static final int MINE_FRIEND_VALUE = 10;
        public static final int MSG_PHOTO_VALUE = 42;
        public static final int MSG_SETTING_PHOTO_VALUE = 43;
        public static final int MSG_TOP_TITLE_VALUE = 41;
        public static final int NEARBY_FEATURED_VALUE = 14;
        public static final int NEARBY_OPERATION_VALUE = 56;
        public static final int NEW_FACE_VALUE = 16;
        public static final int NOTICE_FOLLOW_ME_VALUE = 37;
        public static final int NOTICE_LIKE_VALUE = 44;
        public static final int ONE_CITY_VALUE = 33;
        public static final int ONLINE_TIME_SORT_VALUE = 12;
        public static final int PAGE_FEED_DETAIL_MORE_VALUE = 28;
        public static final int PAGE_FEED_LIKE_VALUE = 27;
        public static final int PAGE_FEED_MINE_VALUE = 26;
        public static final int PERSONAL_FEED_VALUE = 60;
        public static final int PERSONAL_PHOTO_VALUE = 59;
        public static final int PERSONAL_VIDEO_FULL_SCREEN_VALUE = 40;
        public static final int PUSH_CALL_VALUE = 58;
        public static final int RECOMMEND_DETAIL_VALUE = 52;
        public static final int RECOMMEND_IMAGE_VALUE = 50;
        public static final int RECOMMEND_VIDEO_VALUE = 51;
        public static final int SAME_USER_VALUE = 57;
        public static final int SUPER_TOPIC_DETAIL_VALUE = 17;
        public static final int TOPIC_NEW_VALUE = 62;
        public static final int TOPIC_RECOMMEND_VALUE = 61;
        public static final int UNKNOWN_FOLLOW_SOURCE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<Source> internalValueMap = new Internal.EnumLiteMap<Source>() { // from class: com.blued.das.profile.PersonalProfileProtos.Source.1
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
                    return UNKNOWN_FOLLOW_SOURCE;
                case 1:
                    return FRIEND_NEARBY_VISIT;
                case 2:
                    return FRIEND_NEARBY_VIEW;
                case 3:
                    return FOLLOW_ATTENTION;
                case 4:
                    return FEED_FIND_PHOTO;
                case 5:
                    return FEED_FIND_PLAZA;
                case 6:
                    return APPRECIATE_CALL_SHORT;
                case 7:
                    return APPRECIATE_CALL_TOTAL;
                case 8:
                    return MINE_FOLLOW;
                case 9:
                    return MINE_FAN;
                case 10:
                    return MINE_FRIEND;
                case 11:
                    return COMPLEX_SORT;
                case 12:
                    return ONLINE_TIME_SORT;
                case 13:
                    return DISTANCE_SORT;
                case 14:
                    return NEARBY_FEATURED;
                case 15:
                    return FEED_COMMENT;
                case 16:
                    return NEW_FACE;
                case 17:
                    return SUPER_TOPIC_DETAIL;
                case 18:
                    return FIND_PLAZA_RECOMMEND_USER;
                case 19:
                    return FIND_PLAZA_RECOMMEND;
                case 20:
                    return FIND_PLAZA_FOLLOW;
                case 21:
                    return FIND_PLAZA_NEARBY;
                case 22:
                    return FIND_PLAZA_IMAGE;
                case 23:
                    return FIND_PLAZA_FLASH;
                case 24:
                    return FIND_PLAZA_FLASH_DETAIL;
                case 25:
                    return FEED_DETAIL;
                case 26:
                    return PAGE_FEED_MINE;
                case 27:
                    return PAGE_FEED_LIKE;
                case 28:
                    return PAGE_FEED_DETAIL_MORE;
                case 29:
                    return CIRCLE_NOTE_DETAIL;
                case 30:
                    return CIRCLE_DETAIL_NOTE_NEW;
                case 31:
                    return CIRCLE_DETAIL_NOTE_HOT;
                case 32:
                    return CIRCLE_USERS;
                case 33:
                    return ONE_CITY;
                case 34:
                    return FIND_TOPIC_FEED;
                case 35:
                    return CIRCLE_ACTIVE_MEMBER_LIST;
                case 36:
                    return CIRCLE_ACTIVE_MEMBER_MISSION;
                case 37:
                    return NOTICE_FOLLOW_ME;
                case 38:
                    return CITY_TIME;
                case 39:
                    return FEED_IMAGE_FULL_SCREEN;
                case 40:
                    return PERSONAL_VIDEO_FULL_SCREEN;
                case 41:
                    return MSG_TOP_TITLE;
                case 42:
                    return MSG_PHOTO;
                case 43:
                    return MSG_SETTING_PHOTO;
                case 44:
                    return NOTICE_LIKE;
                case 45:
                    return LITE_RECOMMEND;
                case 46:
                    return HOT_BUBBLE;
                case 47:
                    return CITY_ALL_IMAGE;
                case 48:
                    return CITY_ALL_VIDEO;
                case 49:
                    return CITY_ALL_DETAIL;
                case 50:
                    return RECOMMEND_IMAGE;
                case 51:
                    return RECOMMEND_VIDEO;
                case 52:
                    return RECOMMEND_DETAIL;
                case 53:
                    return CITY_NOTE;
                case 54:
                    return CITY_TIME_NOTE;
                case 55:
                    return MAP_FRIEND_USER;
                case 56:
                    return NEARBY_OPERATION;
                case 57:
                    return SAME_USER;
                case 58:
                    return PUSH_CALL;
                case 59:
                    return PERSONAL_PHOTO;
                case 60:
                    return PERSONAL_FEED;
                case 61:
                    return TOPIC_RECOMMEND;
                case 62:
                    return TOPIC_NEW;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return PersonalProfileProtos.getDescriptor().getEnumTypes().get(1);
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/profile/PersonalProfileProtos$TabType.class */
    public enum TabType implements ProtocolMessageEnum {
        UNKNOWN_TAB_TYPE(0),
        FEED_LOAD(1),
        PROFILE_LOAD(2),
        PHOTO_LOAD(3),
        UNRECOGNIZED(-1);
        
        public static final int FEED_LOAD_VALUE = 1;
        public static final int PHOTO_LOAD_VALUE = 3;
        public static final int PROFILE_LOAD_VALUE = 2;
        public static final int UNKNOWN_TAB_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<TabType> internalValueMap = new Internal.EnumLiteMap<TabType>() { // from class: com.blued.das.profile.PersonalProfileProtos.TabType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public TabType findValueByNumber(int i) {
                return TabType.forNumber(i);
            }
        };
        private static final TabType[] VALUES = values();

        TabType(int i) {
            this.value = i;
        }

        public static TabType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return PHOTO_LOAD;
                    }
                    return PROFILE_LOAD;
                }
                return FEED_LOAD;
            }
            return UNKNOWN_TAB_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return PersonalProfileProtos.getDescriptor().getEnumTypes().get(3);
        }

        public static Internal.EnumLiteMap<TabType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static TabType valueOf(int i) {
            return forNumber(i);
        }

        public static TabType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/profile/PersonalProfileProtos$TargetIdentityType.class */
    public enum TargetIdentityType implements ProtocolMessageEnum {
        UNKNOWN_TARGET_IDENTITY_TYPE(0),
        NONE(1),
        VIP(2),
        SVIP(3),
        UNRECOGNIZED(-1);
        
        public static final int NONE_VALUE = 1;
        public static final int SVIP_VALUE = 3;
        public static final int UNKNOWN_TARGET_IDENTITY_TYPE_VALUE = 0;
        public static final int VIP_VALUE = 2;
        private final int value;
        private static final Internal.EnumLiteMap<TargetIdentityType> internalValueMap = new Internal.EnumLiteMap<TargetIdentityType>() { // from class: com.blued.das.profile.PersonalProfileProtos.TargetIdentityType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public TargetIdentityType findValueByNumber(int i) {
                return TargetIdentityType.forNumber(i);
            }
        };
        private static final TargetIdentityType[] VALUES = values();

        TargetIdentityType(int i) {
            this.value = i;
        }

        public static TargetIdentityType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return SVIP;
                    }
                    return VIP;
                }
                return NONE;
            }
            return UNKNOWN_TARGET_IDENTITY_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return PersonalProfileProtos.getDescriptor().getEnumTypes().get(6);
        }

        public static Internal.EnumLiteMap<TargetIdentityType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static TargetIdentityType valueOf(int i) {
            return forNumber(i);
        }

        public static TargetIdentityType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/profile/PersonalProfileProtos$VoteOption.class */
    public enum VoteOption implements ProtocolMessageEnum {
        UNKNOWN_VOTE_OPTION(0),
        IS_JUNK(1),
        NOT_JUNK(2),
        UNCERTAIN(3),
        UNRECOGNIZED(-1);
        
        public static final int IS_JUNK_VALUE = 1;
        public static final int NOT_JUNK_VALUE = 2;
        public static final int UNCERTAIN_VALUE = 3;
        public static final int UNKNOWN_VOTE_OPTION_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<VoteOption> internalValueMap = new Internal.EnumLiteMap<VoteOption>() { // from class: com.blued.das.profile.PersonalProfileProtos.VoteOption.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public VoteOption findValueByNumber(int i) {
                return VoteOption.forNumber(i);
            }
        };
        private static final VoteOption[] VALUES = values();

        VoteOption(int i) {
            this.value = i;
        }

        public static VoteOption forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return UNCERTAIN;
                    }
                    return NOT_JUNK;
                }
                return IS_JUNK;
            }
            return UNKNOWN_VOTE_OPTION;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return PersonalProfileProtos.getDescriptor().getEnumTypes().get(4);
        }

        public static Internal.EnumLiteMap<VoteOption> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static VoteOption valueOf(int i) {
            return forNumber(i);
        }

        public static VoteOption valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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
        internal_static_com_blued_das_profile_PersonalProfileProto_descriptor = descriptor2;
        internal_static_com_blued_das_profile_PersonalProfileProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Event", "Source", "TargetUid", "ShowType", "Distance", "OnlineTime", "Reason", "Label", "PhotoNum", "IsAppreciateCall", "IsSuperExposure", "GiftId", "TabType", "VoteOption", "GiftFrom", "LinkUrl", "FeedId", "TargetIdentityType", "IsMapFind", "IsShadow", "IsQuietCall", "IsFollow", "IdentityNum", "IsOpen", "IsVideo", "IsBag", "Id", "LiveId", "Position", "Type", "Url", "IsAi", "FilterType", "Name", "IsIcon", "IsHot", "IsSpecial", "Mode", "Strategy", "Virtual", "IsTrue", "IsNew", "IsSuperCall", "LogoId", "QaId", "DescId", "LiveRate", "Similarity", "Code"});
    }

    private PersonalProfileProtos() {
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
