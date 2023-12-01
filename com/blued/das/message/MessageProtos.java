package com.blued.das.message;

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
import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/message/MessageProtos.class */
public final class MessageProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013MessageProtos.proto\u0012\u0015com.blued.das.message\"\u0093\n\n\fMessageProto\u0012+\n\u0005event\u0018\u0001 \u0001(\u000e2\u001c.com.blued.das.message.Event\u0012H\n\u0015msg_screen_click_type\u0018\u0002 \u0001(\u000e2).com.blued.das.message.MsgScreenClickType\u0012\u0012\n\ntarget_uid\u0018\u0003 \u0001(\t\u00127\n\fphoto_source\u0018\u0005 \u0001(\u000e2!.com.blued.das.message.SourceType\u00124\n\nphoto_type\u0018\u0006 \u0001(\u000e2 .com.blued.das.message.PhotoType\u0012>\n\u000fstranger_source\u0018\u0007 \u0001(\u000e2%.com.blued.das.message.StrangerSource\u0012\u0011\n\tphoto_num\u0018\b \u0001(\u0005\u0012\u0016\n\u000edisturb_source\u0018\t \u0001(\t\u0012\u0015\n\rdisturb_range\u0018\n \u0001(\t\u0012\u000f\n\u0007is_open\u0018\u000b \u0001(\b\u00122\n\twarn_type\u0018\f \u0001(\u000e2\u001f.com.blued.das.message.WarnType\u0012\u0013\n\u000bis_map_find\u0018\r \u0001(\b\u00122\n\twarn_time\u0018\u000e \u0001(\u000e2\u001f.com.blued.das.message.WarnTime\u0012\u001a\n\u0012is_appreciate_call\u0018\u000f \u0001(\b\u0012\u0015\n\ris_quiet_call\u0018\u0010 \u0001(\b\u0012\u0019\n\u0011is_super_exposure\u0018\u0011 \u0001(\b\u0012\u0011\n\tis_shadow\u0018\u0012 \u0001(\b\u00122\n\tshow_type\u0018\u0013 \u0001(\u000e2\u001f.com.blued.das.message.ShowType\u0012\u0010\n\bimage_id\u0018\u0014 \u0001(\t\u0012\u0010\n\bis_valid\u0018\u0015 \u0001(\b\u0012\u0013\n\u000bcall_filter\u0018\u0016 \u0001(\t\u00122\n\tsort_type\u0018\u0017 \u0001(\u000e2\u001f.com.blued.das.message.SortType\u0012\u000b\n\u0003url\u0018\u0018 \u0001(\t\u0012\u0010\n\bposition\u0018\u0019 \u0001(\u0005\u0012\n\n\u0002id\u0018\u001a \u0001(\t\u0012\u000f\n\u0007keyword\u0018\u001b \u0001(\t\u0012\u000f\n\u0007live_id\u0018\u001c \u0001(\t\u0012\u0013\n\u000bdestination\u0018\u001d \u0001(\t\u0012\f\n\u0004type\u0018\u001e \u0001(\t\u0012\r\n\u0005is_ai\u0018\u001f \u0001(\b\u0012\u000f\n\u0007room_id\u0018  \u0001(\t\u0012\u0010\n\broom_uid\u0018! \u0001(\t\u0012\u000e\n\u0006is_buy\u0018\" \u0001(\b\u0012\u000e\n\u0006msg_id\u0018# \u0001(\t\u0012\u000e\n\u0006reason\u0018$ \u0001(\t\u0012\f\n\u0004name\u0018% \u0001(\t\u0012\u0012\n\nis_special\u0018& \u0001(\b\u0012\f\n\u0004mode\u0018' \u0001(\t\u0012\u0010\n\bstrategy\u0018( \u0001(\t\u0012\u000f\n\u0007virtual\u0018) \u0001(\u0005\u0012\u000e\n\u0006is_new\u0018* \u0001(\b\u00122\n\tcall_type\u0018+ \u0001(\u000e2\u001f.com.blued.das.message.CallType\u0012\u0015\n\ris_super_call\u0018, \u0001(\b\u0012\u000f\n\u0007logo_id\u0018- \u0001(\t\u0012\u0012\n\nstart_time\u0018. \u0001(\u0003\u0012\u0010\n\bend_time\u0018/ \u0001(\u0003\u0012\u0010\n\bduration\u00180 \u0001(\u0003\u0012\u000e\n\u0006status\u00181 \u0001(\t\u0012\f\n\u0004rate\u00182 \u0001(\u0001\u0012\u0010\n\bdistance\u00183 \u0001(\t*\u009b\u001e\n\u0005Event\u0012\u0011\n\rUNKNOWN_EVENT\u0010��\u0012\u0015\n\u0011MSG_SCREEN_UNFOLD\u0010\u0001\u0012\u0013\n\u000fMSG_SCREEN_FOLD\u0010\u0002\u0012 \n\u001cMSG_SCREEN_STARTED_BTN_CLICK\u0010\u0003\u0012!\n\u001dMSG_SCREEN_FOLLOWED_BTN_CLICK\u0010\u0004\u0012\u001f\n\u001bMSG_SCREEN_NEARBY_BTN_CLICK\u0010\u0005\u0012%\n!MSG_SCREEN_UNFOLD_RESET_BTN_CLICK\u0010\u0006\u0012#\n\u001fMSG_SCREEN_FOLD_CLOSE_BTN_CLICK\u0010\u0007\u0012\u001a\n\u0016MSG_UNREAD_DRAG_REMOVE\u0010\b\u0012\u001f\n\u001bMSG_SCREEN_SEARCH_BOX_CLICK\u0010\t\u0012&\n\"MSG_PRIVATE_STRANGER_SOURCE_PROMPT\u0010\n\u0012\u0012\n\u000eMSG_SEND_PHOTO\u0010\u000b\u0012\u0019\n\u0015MSG_NO_DISTURB_FILTER\u0010\f\u0012\u0019\n\u0015MSG_DELETE_POINT_SHOW\u0010\r\u0012\u001d\n\u0019MSG_PHOTO_CLEAR_BTN_CLICK\u0010\u000e\u0012\u0017\n\u0013MSG_TO_UP_BTN_CLICK\u0010\u000f\u0012\u0016\n\u0012MSG_TO_UP_MAX_SHOW\u0010\u0010\u0012\u001a\n\u0016MSG_MORE_IGNORE_UNREAD\u0010\u0011\u0012\u0012\n\u000eMSG_MORE_CLEAR\u0010\u0012\u0012\u001a\n\u0016MSG_MORE_VIDEO_SETTING\u0010\u0013\u0012\u001e\n\u001aMSG_MORE_ATTENTION_SETTING\u0010\u0014\u0012\u001c\n\u0018MSG_MORE_OPEN_LOOK_QUIET\u0010\u0015\u0012\u0015\n\u0011MSG_ADD_BTN_CLICK\u0010\u0016\u0012\u0018\n\u0014MSG_VOCATIV_BTN_SHOW\u0010\u0017\u0012\u0019\n\u0015MSG_VOCATIV_BTN_CLICK\u0010\u0018\u0012\u0016\n\u0012MSG_MORE_BTN_CLICK\u0010\u0019\u0012%\n!MSG_CHAT_SET_BACKGROUND_BTN_CLICK\u0010\u001a\u0012\u0016\n\u0012MSG_PUSH_WARN_SHOW\u0010\u001b\u0012\u0017\n\u0013MSG_PUSH_WARN_CLICK\u0010\u001c\u0012\u0017\n\u0013MSG_PUSH_WARN_CLOSE\u0010\u001d\u0012\u001d\n\u0019MSG_MORE_NO_DISTURB_CLICK\u0010\u001e\u0012\u0019\n\u0015MSG_VOCATIV_USER_SHOW\u0010\u001f\u0012\u001a\n\u0016MSG_VOCATIV_USER_CLICK\u0010 \u0012\u0018\n\u0014MSG_SAVE_VIDEO_CLICK\u0010!\u0012\u0013\n\u000fMSG_EMOJI_CLICK\u0010\"\u0012\u0011\n\rCHAT_SEND_MSG\u0010#\u0012\u001d\n\u0019MSG_SETTINGS_BUBBLE_CLICK\u0010$\u0012\u001a\n\u0016MSG_CLICK_BUBBLE_CLICK\u0010%\u0012\u0019\n\u0015MSG_BUBBLE_SAVE_CLICK\u0010&\u0012\u0017\n\u0013CALL_PAGE_USER_SHOW\u0010'\u0012\u0018\n\u0014CALL_PAGE_USER_CLICK\u0010(\u0012\u001b\n\u0017MSG_SETTINGS_ICON_CLICK\u0010)\u0012\u0019\n\u0015MSG_LIST_OPERATE_SHOW\u0010+\u0012'\n#MSG_LIST_OPERATE_VIEW_PRIVATE_CLICK\u0010,\u0012\u001c\n\u0018MSG_SETTINGS_LIVE_NOTICE\u0010-\u0012\u0013\n\u000fBLUED_MSG_CLICK\u0010.\u0012\u001c\n\u0018PRIVATE_CHAT_OPTION_SHOW\u0010/\u0012\u0014\n\u0010CHAT_VIDEO_CLICK\u00100\u0012\u001d\n\u0019PRIVATE_CHAT_REPORT_CLICK\u00101\u0012\u0018\n\u0014MSG_SAY_HI_LIST_SHOW\u00102\u0012\u0018\n\u0014MSG_SAY_HI_ONE_CLICK\u00103\u0012\u0011\n\rMSG_LIVE_SHOW\u00104\u0012\u0012\n\u000eMSG_LIVE_CLICK\u00105\u0012\u0012\n\u000eNAVIGATION_BTN\u00106\u0012\f\n\bMSG_PUSH\u00107\u0012\u0010\n\fMESSAGE_PAGE\u00108\u0012\r\n\tMSG_CLICK\u00109\u0012\u0018\n\u0014MSG_BUBBLE_VIP_CLICK\u0010:\u0012!\n\u001dMSG_SCREEN_SEARCH_BOX_SUCCESS\u0010;\u0012#\n\u001fCHAT_ROOM_INVITE_MSG_JOIN_CLICK\u0010<\u0012!\n\u001dMSG_VOICE_TRANSFER_WORD_CLICK\u0010=\u0012\u0017\n\u0013GIFT_CARD_PAGE_SHOW\u0010>\u0012\u001d\n\u0019GIFT_CARD_PAGE_SEND_CLICK\u0010?\u0012\u001f\n\u001bGIFT_CARD_PAGE_CANCEL_CLICK\u0010@\u0012+\n'GIFT_CARD_PAGE_CANCEL_POP_CONFIRM_CLICK\u0010A\u0012*\n&GIFT_CARD_PAGE_CANCEL_POP_CANCEL_CLICK\u0010B\u0012\u0017\n\u0013MSG_VOICE_BTN_CLICK\u0010C\u0012\u001b\n\u0017MSG_VOICE_TALK_BTN_SHOW\u0010D\u0012\u001c\n\u0018MSG_VOICE_TALK_BTN_CLICK\u0010E\u0012\u001e\n\u001aMSG_VOICE_DELETE_BTN_CLICK\u0010F\u0012\u001a\n\u0016MSG_YY_ROOM_JOIN_CLICK\u0010G\u0012\u001a\n\u0016MSG_SERVICE_CELL_CLICK\u0010H\u0012\u001d\n\u0019MSG_SERVICE_LIST_ONE_SHOW\u0010I\u0012\u001e\n\u001aMSG_SERVICE_LIST_ONE_CLICK\u0010J\u0012\u0016\n\u0012MSG_SHARE_MSG_SHOW\u0010K\u0012\u0017\n\u0013MSG_SHARE_MSG_CLICK\u0010L\u0012\u0016\n\u0012MSG_GIFT_ICON_SHOW\u0010M\u0012\u0017\n\u0013MSG_GIFT_ICON_CLICK\u0010N\u0012\u0018\n\u0014MSG_CHEAT_TOAST_SHOW\u0010O\u0012\u0019\n\u0015MSG_CHEAT_TOAST_CLOSE\u0010P\u0012\u001b\n\u0017MSG_LIST_SAFE_WARN_SHOW\u0010Q\u0012!\n\u001dMSG_LIST_SAFE_WARN_BACK_CLICK\u0010R\u0012 \n\u001cMSG_LIST_SAFE_WARN_GET_CLICK\u0010S\u0012\u0011\n\rMSG_SEND_FAIL\u0010T\u0012%\n!MSG_SERVICE_ACCOUNT_MSG_ONE_CLICK\u0010U\u0012\u0016\n\u0012MSG_DECEPTION_SHOW\u0010V\u0012\u0011\n\rMSG_AIDS_SHOW\u0010W\u0012\u0017\n\u0013MSG_AIDS_MORE_CLICK\u0010X\u0012\u0014\n\u0010MSG_DISABLE_SHOW\u0010Y\u0012\u0016\n\u0012MSG_SENSITIVE_SHOW\u0010Z\u0012\u001c\n\u0018MSG_SENSITIVE_CASE_CLICK\u0010[\u0012\u001b\n\u0017MSG_SENSITIVE_HIV_CLICK\u0010\\\u0012\u0019\n\u0015SERVICE_MSG_PAGE_SHOW\u0010]\u0012 \n\u001cSERVICE_MSG_PAGE_FIRST_CLICK\u0010^\u0012!\n\u001dSERVICE_MSG_PAGE_SECOND_CLICK\u0010_\u0012\u001f\n\u001bSERVICE_MSG_PAGE_AUTO_REPLY\u0010`\u0012\u001c\n\u0018FLASH_PHOTO_BUY_POP_SHOW\u0010a\u0012!\n\u001dFLASH_PHOTO_BUY_POP_YES_CLICK\u0010b\u0012 \n\u001cFLASH_PHOTO_BUY_POP_NO_CLICK\u0010c\u0012\u000e\n\nMSG_RECALL\u0010d\u0012\u0018\n\u0014MSG_SHADOW_BUY_CLICK\u0010e\u0012\"\n\u001eFLASH_PHOTO_BUY_POP_FREE_CLICK\u0010f\u0012\u001a\n\u0016MSG_OPEN_PUSH_POP_SHOW\u0010j\u0012\u001e\n\u001aMSG_OPEN_PUSH_POP_NO_CLICK\u0010k\u0012 \n\u001cMSG_OPEN_PUSH_POP_OPEN_CLICK\u0010l\u0012\u0012\n\u000eBLUED_MSG_SHOW\u0010m\u0012\u0015\n\u0011POPUP_BANNER_SHOW\u0010n\u0012\u0016\n\u0012POPUP_BANNER_CLICK\u0010o\u0012\u000f\n\u000bMSG_YY_SHOW\u0010p\u0012\u0010\n\fMSG_YY_CLICK\u0010q\u0012\u0016\n\u0012POPUP_BANNER_CLOSE\u0010r\u0012\u0016\n\u0012POPUP_BANNER_COVER\u0010s\u0012\u001a\n\u0016PUSH_VOCATIV_USER_SHOW\u0010t\u0012\u001b\n\u0017PUSH_VOCATIV_USER_CLICK\u0010u\u0012\u0011\n\rMSG_PAGE_SHOW\u0010v\u0012\u0011\n\rMSG_USER_SHOW\u0010w\u0012\u0019\n\u0015MSG_USER_AVATAR_CLICK\u0010x\u0012\u001e\n\u001aMSG_USER_AVATAR_TEXT_CLICK\u0010y\u0012\u0012\n\u000eCHAT_USER_SHOW\u0010z\u0012\u001b\n\u0017CHAT_USER_LIVE_YY_CLICK\u0010{\u0012#\n\u001fMSG_SETTINGS_SPECIAL_CARE_CLICK\u0010|\u0012(\n$MSG_SETTINGS_SPECIAL_CARE_LIMIT_SHOW\u0010}\u0012%\n!MSG_SPECIAL_CARE_FEED_NOTICE_SHOW\u0010~\u0012&\n\"MSG_SPECIAL_CARE_FEED_NOTICE_CLICK\u0010\u007f\u0012\u0010\n\u000bMSG_1V1_END\u0010\u0080\u0001\u0012\u0015\n\u0010MSG_YY_OPEN_SHOW\u0010\u0081\u0001\u0012\u0016\n\u0011MSG_YY_OPEN_CLICK\u0010\u0082\u0001\u0012\u001a\n\u0015MSG_PASS_BY_TIPS_SHOW\u0010\u0083\u0001\u0012\u001e\n\u0019MSG_PASS_BY_TIPS_GO_CLICK\u0010\u0084\u0001\u0012\u0013\n\u000eMSG_1V1_LAUNCH\u0010\u0085\u0001\u0012\u0018\n\u0013MSG_SUPER_FEED_SHOW\u0010\u0086\u0001\u0012\u0019\n\u0014MSG_SUPER_FEED_CLICK\u0010\u0087\u0001\u0012\u0018\n\u0013MSG_LIST_MATCH_SHOW\u0010\u0088\u0001\u0012\u0019\n\u0014MSG_LIST_MATCH_CLICK\u0010\u0089\u0001\u0012\u001d\n\u0018MSG_MATCH_CHAT_PAGE_SHOW\u0010\u008a\u0001\u0012#\n\u001eMSG_MATCH_CHAT_PAGE_LIKE_CLICK\u0010\u008b\u0001\u0012%\n MSG_MATCH_CHAT_PAGE_UNLIKE_CLICK\u0010\u008c\u0001\u0012%\n MSG_MATCH_CHAT_PAGE_REPORT_CLICK\u0010\u008d\u0001*x\n\u0012MsgScreenClickType\u0012!\n\u001dUNKNOWN_MSG_SCREEN_CLICK_TYPE\u0010��\u0012\u001e\n\u001aMSG_SCREEN_CLICK_TYPE_OPEN\u0010\u0001\u0012\u001f\n\u001bMSG_SCREEN_CLICK_TYPE_CLOSE\u0010\u0002*\u0087\r\n\u000eStrangerSource\u0012\u001b\n\u0017UNKNOWN_STRANGER_SOURCE\u0010��\u0012\u0017\n\u0013FRIEND_NEARBY_VISIT\u0010\u0001\u0012\u0016\n\u0012FRIEND_NEARBY_VIEW\u0010\u0002\u0012\u0018\n\u0014FRIEND_NEARBY_NEARBY\u0010\u0003\u0012\u0018\n\u0014FRIEND_NEARBY_ONLINE\u0010\u0004\u0012\u001a\n\u0016FRIEND_NEARBY_NEW_FACE\u0010\u0005\u0012!\n\u001dFRIEND_NEARBY_PERSONAL_NEARBY\u0010\u0006\u0012\u0014\n\u0010FOLLOW_ATTENTION\u0010\u0007\u0012\u000f\n\u000bFEED_NEARBY\u0010\b\u0012\u0013\n\u000fFEED_FIND_PHOTO\u0010\t\u0012\u0013\n\u000fFEED_FIND_PLAZA\u0010\n\u0012\u0017\n\u0013FEED_PERSONAL_TOPIC\u0010\u000b\u0012\u001b\n\u0017FEED_NOT_SUPER_EXPOSURE\u0010\f\u0012\u0019\n\u0015APPRECIATE_CALL_SHORT\u0010\r\u0012\u0019\n\u0015APPRECIATE_CALL_TOTAL\u0010\u000e\u0012\u0015\n\u0011APPRECIATE_NEARBY\u0010\u000f\u0012\u0013\n\u000fAPPRECIATE_FIND\u0010\u0010\u0012\u001d\n\u0019APPRECIATE_SUPER_EXPOSURE\u0010\u0011\u0012\b\n\u0004LIVE\u0010\u0012\u0012\u000f\n\u000bMINE_FOLLOW\u0010\u0013\u0012\f\n\bMINE_FAN\u0010\u0014\u0012\f\n\bMAP_FIND\u0010\u0015\u0012\u001b\n\u0017APPRECIATE_CALL_COMPLEX\u0010\u0016\u0012\u001a\n\u0016APPRECIATE_CALL_ONLINE\u0010\u0017\u0012\u0011\n\rSHADOW_SOURCE\u0010\u0018\u0012\u000f\n\u000bMINE_FRIEND\u0010\u0019\u0012\u0010\n\fCOMPLEX_SORT\u0010\u001a\u0012\u0014\n\u0010ONLINE_TIME_SORT\u0010\u001b\u0012\u0011\n\rDISTANCE_SORT\u0010\u001c\u0012\u0013\n\u000fNEARBY_FEATURED\u0010\u001d\u0012\u0010\n\fFEED_COMMENT\u0010\u001e\u0012\f\n\bNEW_FACE\u0010\u001f\u0012\u0016\n\u0012SUPER_TOPIC_DETAIL\u0010 \u0012\u001d\n\u0019FIND_PLAZA_RECOMMEND_USER\u0010!\u0012\u0018\n\u0014FIND_PLAZA_RECOMMEND\u0010\"\u0012\u0015\n\u0011FIND_PLAZA_FOLLOW\u0010#\u0012\u0015\n\u0011FIND_PLAZA_NEARBY\u0010$\u0012\u0014\n\u0010FIND_PLAZA_IMAGE\u0010%\u0012\u0014\n\u0010FIND_PLAZA_FLASH\u0010&\u0012\u001b\n\u0017FIND_PLAZA_FLASH_DETAIL\u0010'\u0012\u000f\n\u000bFEED_DETAIL\u0010(\u0012\u0012\n\u000ePAGE_FEED_MINE\u0010)\u0012\u0012\n\u000ePAGE_FEED_LIKE\u0010*\u0012\u0019\n\u0015PAGE_FEED_DETAIL_MORE\u0010+\u0012\u0016\n\u0012CIRCLE_NOTE_DETAIL\u0010,\u0012\u001a\n\u0016CIRCLE_DETAIL_NOTE_NEW\u0010-\u0012\u001a\n\u0016CIRCLE_DETAIL_NOTE_HOT\u0010.\u0012\u0010\n\fCIRCLE_USERS\u0010/\u0012\f\n\bONE_CITY\u00100\u0012\u000e\n\nGROUP_CHAT\u00101\u0012\r\n\tCHAT_ROOM\u00102\u0012\u0014\n\u0010NOTICE_FOLLOW_ME\u00103\u0012\r\n\tCITY_TIME\u00104\u0012\u001a\n\u0016FEED_IMAGE_FULL_SCREEN\u00105\u0012\u001e\n\u001aPERSONAL_VIDEO_FULL_SCREEN\u00106\u0012\u0011\n\rMSG_TOP_TITLE\u00107\u0012\r\n\tMSG_PHOTO\u00108\u0012\u0015\n\u0011MSG_SETTING_PHOTO\u00109\u0012\u000f\n\u000bNOTICE_LIKE\u0010:\u0012\u0012\n\u000eLITE_RECOMMEND\u0010;\u0012\u000e\n\nHOT_BUBBLE\u0010<\u0012\u000f\n\u000bCITY_ALL_HI\u0010=\u0012\u0010\n\fCITY_TIME_HI\u0010>\u0012\u0012\n\u000eCITY_ALL_IMAGE\u0010?\u0012\u0012\n\u000eCITY_ALL_VIDEO\u0010@\u0012\u0013\n\u000fCITY_ALL_DETAIL\u0010A\u0012\u0013\n\u000fRECOMMEND_IMAGE\u0010B\u0012\u0013\n\u000fRECOMMEND_VIDEO\u0010C\u0012\u0014\n\u0010RECOMMEND_DETAIL\u0010D\u0012\r\n\tCITY_NOTE\u0010E\u0012\u0012\n\u000eCITY_TIME_NOTE\u0010F\u0012\u0013\n\u000fMAP_FRIEND_USER\u0010G\u0012\u0014\n\u0010NEARBY_OPERATION\u0010H\u0012\r\n\tSAME_USER\u0010I\u0012\r\n\tPUSH_CALL\u0010J\u0012\u0013\n\u000fTOPIC_RECOMMEND\u0010K\u0012\r\n\tTOPIC_NEW\u0010L*K\n\nSourceType\u0012\u0017\n\u0013UNKNOWN_SOURCE_TYPE\u0010��\u0012\u0010\n\fRECENT_PHOTO\u0010\u0001\u0012\u0012\n\u000eCOMPLETE_PHOTO\u0010\u0002*J\n\tPhotoType\u0012\u0016\n\u0012UNKNOWN_PHOTO_TYPE\u0010��\u0012\u0010\n\fNORMAL_PHOTO\u0010\u0001\u0012\u0013\n\u000fBURN_AFTER_READ\u0010\u0002*Y\n\bWarnType\u0012\u0015\n\u0011UNKNOWN_WARN_TYPE\u0010��\u0012\u000e\n\nTOAST_PUSH\u0010\u0001\u0012\f\n\bPOP_PUSH\u0010\u0002\u0012\u0018\n\u0014TOAST_PUSH_PERMANENT\u0010\u0003*r\n\bWarnTime\u0012\u0015\n\u0011UNKNOWN_WARN_TIME\u0010��\u0012\u0010\n\fUNREAD_FIRST\u0010\u0001\u0012\u000e\n\nCHAT_FIRST\u0010\u0002\u0012\u000e\n\nLIVE_FIRST\u0010\u0003\u0012\r\n\tTOAST_MSG\u0010\u0004\u0012\u000e\n\nTOAST_LIVE\u0010\u0005*A\n\bShowType\u0012\u0015\n\u0011UNKNOWN_SHOW_TYPE\u0010��\u0012\u000f\n\u000bPALACE_SHOW\u0010\u0001\u0012\r\n\tLIST_SHOW\u0010\u0002*K\n\bSortType\u0012\u0015\n\u0011UNKNOWN_SORT_TYPE\u0010��\u0012\u0010\n\fAI_SORT_TYPE\u0010\u0001\u0012\u0016\n\u0012DISTANCE_SORT_TYPE\u0010\u0002*R\n\bCallType\u0012\u0015\n\u0011UNKNOWN_CALL_TYPE\u0010��\u0012\u000f\n\u000bCALL_COMMON\u0010\u0001\u0012\u000e\n\nCALL_SUPER\u0010\u0002\u0012\u000e\n\nCALL_QUIET\u0010\u0003B\n¢\u0002\u0007MESSAGEb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_blued_das_message_MessageProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_message_MessageProto_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/message/MessageProtos$CallType.class */
    public enum CallType implements ProtocolMessageEnum {
        UNKNOWN_CALL_TYPE(0),
        CALL_COMMON(1),
        CALL_SUPER(2),
        CALL_QUIET(3),
        UNRECOGNIZED(-1);
        
        public static final int CALL_COMMON_VALUE = 1;
        public static final int CALL_QUIET_VALUE = 3;
        public static final int CALL_SUPER_VALUE = 2;
        public static final int UNKNOWN_CALL_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<CallType> internalValueMap = new Internal.EnumLiteMap<CallType>() { // from class: com.blued.das.message.MessageProtos.CallType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public CallType findValueByNumber(int i) {
                return CallType.forNumber(i);
            }
        };
        private static final CallType[] VALUES = values();

        CallType(int i) {
            this.value = i;
        }

        public static CallType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return CALL_QUIET;
                    }
                    return CALL_SUPER;
                }
                return CALL_COMMON;
            }
            return UNKNOWN_CALL_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return MessageProtos.getDescriptor().getEnumTypes().get(9);
        }

        public static Internal.EnumLiteMap<CallType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static CallType valueOf(int i) {
            return forNumber(i);
        }

        public static CallType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/message/MessageProtos$Event.class */
    public enum Event implements ProtocolMessageEnum {
        UNKNOWN_EVENT(0),
        MSG_SCREEN_UNFOLD(1),
        MSG_SCREEN_FOLD(2),
        MSG_SCREEN_STARTED_BTN_CLICK(3),
        MSG_SCREEN_FOLLOWED_BTN_CLICK(4),
        MSG_SCREEN_NEARBY_BTN_CLICK(5),
        MSG_SCREEN_UNFOLD_RESET_BTN_CLICK(6),
        MSG_SCREEN_FOLD_CLOSE_BTN_CLICK(7),
        MSG_UNREAD_DRAG_REMOVE(8),
        MSG_SCREEN_SEARCH_BOX_CLICK(9),
        MSG_PRIVATE_STRANGER_SOURCE_PROMPT(10),
        MSG_SEND_PHOTO(11),
        MSG_NO_DISTURB_FILTER(12),
        MSG_DELETE_POINT_SHOW(13),
        MSG_PHOTO_CLEAR_BTN_CLICK(14),
        MSG_TO_UP_BTN_CLICK(15),
        MSG_TO_UP_MAX_SHOW(16),
        MSG_MORE_IGNORE_UNREAD(17),
        MSG_MORE_CLEAR(18),
        MSG_MORE_VIDEO_SETTING(19),
        MSG_MORE_ATTENTION_SETTING(20),
        MSG_MORE_OPEN_LOOK_QUIET(21),
        MSG_ADD_BTN_CLICK(22),
        MSG_VOCATIV_BTN_SHOW(23),
        MSG_VOCATIV_BTN_CLICK(24),
        MSG_MORE_BTN_CLICK(25),
        MSG_CHAT_SET_BACKGROUND_BTN_CLICK(26),
        MSG_PUSH_WARN_SHOW(27),
        MSG_PUSH_WARN_CLICK(28),
        MSG_PUSH_WARN_CLOSE(29),
        MSG_MORE_NO_DISTURB_CLICK(30),
        MSG_VOCATIV_USER_SHOW(31),
        MSG_VOCATIV_USER_CLICK(32),
        MSG_SAVE_VIDEO_CLICK(33),
        MSG_EMOJI_CLICK(34),
        CHAT_SEND_MSG(35),
        MSG_SETTINGS_BUBBLE_CLICK(36),
        MSG_CLICK_BUBBLE_CLICK(37),
        MSG_BUBBLE_SAVE_CLICK(38),
        CALL_PAGE_USER_SHOW(39),
        CALL_PAGE_USER_CLICK(40),
        MSG_SETTINGS_ICON_CLICK(41),
        MSG_LIST_OPERATE_SHOW(43),
        MSG_LIST_OPERATE_VIEW_PRIVATE_CLICK(44),
        MSG_SETTINGS_LIVE_NOTICE(45),
        BLUED_MSG_CLICK(46),
        PRIVATE_CHAT_OPTION_SHOW(47),
        CHAT_VIDEO_CLICK(48),
        PRIVATE_CHAT_REPORT_CLICK(49),
        MSG_SAY_HI_LIST_SHOW(50),
        MSG_SAY_HI_ONE_CLICK(51),
        MSG_LIVE_SHOW(52),
        MSG_LIVE_CLICK(53),
        NAVIGATION_BTN(54),
        MSG_PUSH(55),
        MESSAGE_PAGE(56),
        MSG_CLICK(57),
        MSG_BUBBLE_VIP_CLICK(58),
        MSG_SCREEN_SEARCH_BOX_SUCCESS(59),
        CHAT_ROOM_INVITE_MSG_JOIN_CLICK(60),
        MSG_VOICE_TRANSFER_WORD_CLICK(61),
        GIFT_CARD_PAGE_SHOW(62),
        GIFT_CARD_PAGE_SEND_CLICK(63),
        GIFT_CARD_PAGE_CANCEL_CLICK(64),
        GIFT_CARD_PAGE_CANCEL_POP_CONFIRM_CLICK(65),
        GIFT_CARD_PAGE_CANCEL_POP_CANCEL_CLICK(66),
        MSG_VOICE_BTN_CLICK(67),
        MSG_VOICE_TALK_BTN_SHOW(68),
        MSG_VOICE_TALK_BTN_CLICK(69),
        MSG_VOICE_DELETE_BTN_CLICK(70),
        MSG_YY_ROOM_JOIN_CLICK(71),
        MSG_SERVICE_CELL_CLICK(72),
        MSG_SERVICE_LIST_ONE_SHOW(73),
        MSG_SERVICE_LIST_ONE_CLICK(74),
        MSG_SHARE_MSG_SHOW(75),
        MSG_SHARE_MSG_CLICK(76),
        MSG_GIFT_ICON_SHOW(77),
        MSG_GIFT_ICON_CLICK(78),
        MSG_CHEAT_TOAST_SHOW(79),
        MSG_CHEAT_TOAST_CLOSE(80),
        MSG_LIST_SAFE_WARN_SHOW(81),
        MSG_LIST_SAFE_WARN_BACK_CLICK(82),
        MSG_LIST_SAFE_WARN_GET_CLICK(83),
        MSG_SEND_FAIL(84),
        MSG_SERVICE_ACCOUNT_MSG_ONE_CLICK(85),
        MSG_DECEPTION_SHOW(86),
        MSG_AIDS_SHOW(87),
        MSG_AIDS_MORE_CLICK(88),
        MSG_DISABLE_SHOW(89),
        MSG_SENSITIVE_SHOW(90),
        MSG_SENSITIVE_CASE_CLICK(91),
        MSG_SENSITIVE_HIV_CLICK(92),
        SERVICE_MSG_PAGE_SHOW(93),
        SERVICE_MSG_PAGE_FIRST_CLICK(94),
        SERVICE_MSG_PAGE_SECOND_CLICK(95),
        SERVICE_MSG_PAGE_AUTO_REPLY(96),
        FLASH_PHOTO_BUY_POP_SHOW(97),
        FLASH_PHOTO_BUY_POP_YES_CLICK(98),
        FLASH_PHOTO_BUY_POP_NO_CLICK(99),
        MSG_RECALL(100),
        MSG_SHADOW_BUY_CLICK(101),
        FLASH_PHOTO_BUY_POP_FREE_CLICK(102),
        MSG_OPEN_PUSH_POP_SHOW(106),
        MSG_OPEN_PUSH_POP_NO_CLICK(107),
        MSG_OPEN_PUSH_POP_OPEN_CLICK(108),
        BLUED_MSG_SHOW(109),
        POPUP_BANNER_SHOW(110),
        POPUP_BANNER_CLICK(111),
        MSG_YY_SHOW(112),
        MSG_YY_CLICK(113),
        POPUP_BANNER_CLOSE(114),
        POPUP_BANNER_COVER(115),
        PUSH_VOCATIV_USER_SHOW(116),
        PUSH_VOCATIV_USER_CLICK(117),
        MSG_PAGE_SHOW(118),
        MSG_USER_SHOW(119),
        MSG_USER_AVATAR_CLICK(120),
        MSG_USER_AVATAR_TEXT_CLICK(121),
        CHAT_USER_SHOW(122),
        CHAT_USER_LIVE_YY_CLICK(123),
        MSG_SETTINGS_SPECIAL_CARE_CLICK(124),
        MSG_SETTINGS_SPECIAL_CARE_LIMIT_SHOW(125),
        MSG_SPECIAL_CARE_FEED_NOTICE_SHOW(126),
        MSG_SPECIAL_CARE_FEED_NOTICE_CLICK(127),
        MSG_1V1_END(128),
        MSG_YY_OPEN_SHOW(129),
        MSG_YY_OPEN_CLICK(130),
        MSG_PASS_BY_TIPS_SHOW(131),
        MSG_PASS_BY_TIPS_GO_CLICK(132),
        MSG_1V1_LAUNCH(133),
        MSG_SUPER_FEED_SHOW(134),
        MSG_SUPER_FEED_CLICK(135),
        MSG_LIST_MATCH_SHOW(136),
        MSG_LIST_MATCH_CLICK(137),
        MSG_MATCH_CHAT_PAGE_SHOW(138),
        MSG_MATCH_CHAT_PAGE_LIKE_CLICK(139),
        MSG_MATCH_CHAT_PAGE_UNLIKE_CLICK(140),
        MSG_MATCH_CHAT_PAGE_REPORT_CLICK(141),
        UNRECOGNIZED(-1);
        
        public static final int BLUED_MSG_CLICK_VALUE = 46;
        public static final int BLUED_MSG_SHOW_VALUE = 109;
        public static final int CALL_PAGE_USER_CLICK_VALUE = 40;
        public static final int CALL_PAGE_USER_SHOW_VALUE = 39;
        public static final int CHAT_ROOM_INVITE_MSG_JOIN_CLICK_VALUE = 60;
        public static final int CHAT_SEND_MSG_VALUE = 35;
        public static final int CHAT_USER_LIVE_YY_CLICK_VALUE = 123;
        public static final int CHAT_USER_SHOW_VALUE = 122;
        public static final int CHAT_VIDEO_CLICK_VALUE = 48;
        public static final int FLASH_PHOTO_BUY_POP_FREE_CLICK_VALUE = 102;
        public static final int FLASH_PHOTO_BUY_POP_NO_CLICK_VALUE = 99;
        public static final int FLASH_PHOTO_BUY_POP_SHOW_VALUE = 97;
        public static final int FLASH_PHOTO_BUY_POP_YES_CLICK_VALUE = 98;
        public static final int GIFT_CARD_PAGE_CANCEL_CLICK_VALUE = 64;
        public static final int GIFT_CARD_PAGE_CANCEL_POP_CANCEL_CLICK_VALUE = 66;
        public static final int GIFT_CARD_PAGE_CANCEL_POP_CONFIRM_CLICK_VALUE = 65;
        public static final int GIFT_CARD_PAGE_SEND_CLICK_VALUE = 63;
        public static final int GIFT_CARD_PAGE_SHOW_VALUE = 62;
        public static final int MESSAGE_PAGE_VALUE = 56;
        public static final int MSG_1V1_END_VALUE = 128;
        public static final int MSG_1V1_LAUNCH_VALUE = 133;
        public static final int MSG_ADD_BTN_CLICK_VALUE = 22;
        public static final int MSG_AIDS_MORE_CLICK_VALUE = 88;
        public static final int MSG_AIDS_SHOW_VALUE = 87;
        public static final int MSG_BUBBLE_SAVE_CLICK_VALUE = 38;
        public static final int MSG_BUBBLE_VIP_CLICK_VALUE = 58;
        public static final int MSG_CHAT_SET_BACKGROUND_BTN_CLICK_VALUE = 26;
        public static final int MSG_CHEAT_TOAST_CLOSE_VALUE = 80;
        public static final int MSG_CHEAT_TOAST_SHOW_VALUE = 79;
        public static final int MSG_CLICK_BUBBLE_CLICK_VALUE = 37;
        public static final int MSG_CLICK_VALUE = 57;
        public static final int MSG_DECEPTION_SHOW_VALUE = 86;
        public static final int MSG_DELETE_POINT_SHOW_VALUE = 13;
        public static final int MSG_DISABLE_SHOW_VALUE = 89;
        public static final int MSG_EMOJI_CLICK_VALUE = 34;
        public static final int MSG_GIFT_ICON_CLICK_VALUE = 78;
        public static final int MSG_GIFT_ICON_SHOW_VALUE = 77;
        public static final int MSG_LIST_MATCH_CLICK_VALUE = 137;
        public static final int MSG_LIST_MATCH_SHOW_VALUE = 136;
        public static final int MSG_LIST_OPERATE_SHOW_VALUE = 43;
        public static final int MSG_LIST_OPERATE_VIEW_PRIVATE_CLICK_VALUE = 44;
        public static final int MSG_LIST_SAFE_WARN_BACK_CLICK_VALUE = 82;
        public static final int MSG_LIST_SAFE_WARN_GET_CLICK_VALUE = 83;
        public static final int MSG_LIST_SAFE_WARN_SHOW_VALUE = 81;
        public static final int MSG_LIVE_CLICK_VALUE = 53;
        public static final int MSG_LIVE_SHOW_VALUE = 52;
        public static final int MSG_MATCH_CHAT_PAGE_LIKE_CLICK_VALUE = 139;
        public static final int MSG_MATCH_CHAT_PAGE_REPORT_CLICK_VALUE = 141;
        public static final int MSG_MATCH_CHAT_PAGE_SHOW_VALUE = 138;
        public static final int MSG_MATCH_CHAT_PAGE_UNLIKE_CLICK_VALUE = 140;
        public static final int MSG_MORE_ATTENTION_SETTING_VALUE = 20;
        public static final int MSG_MORE_BTN_CLICK_VALUE = 25;
        public static final int MSG_MORE_CLEAR_VALUE = 18;
        public static final int MSG_MORE_IGNORE_UNREAD_VALUE = 17;
        public static final int MSG_MORE_NO_DISTURB_CLICK_VALUE = 30;
        public static final int MSG_MORE_OPEN_LOOK_QUIET_VALUE = 21;
        public static final int MSG_MORE_VIDEO_SETTING_VALUE = 19;
        public static final int MSG_NO_DISTURB_FILTER_VALUE = 12;
        public static final int MSG_OPEN_PUSH_POP_NO_CLICK_VALUE = 107;
        public static final int MSG_OPEN_PUSH_POP_OPEN_CLICK_VALUE = 108;
        public static final int MSG_OPEN_PUSH_POP_SHOW_VALUE = 106;
        public static final int MSG_PAGE_SHOW_VALUE = 118;
        public static final int MSG_PASS_BY_TIPS_GO_CLICK_VALUE = 132;
        public static final int MSG_PASS_BY_TIPS_SHOW_VALUE = 131;
        public static final int MSG_PHOTO_CLEAR_BTN_CLICK_VALUE = 14;
        public static final int MSG_PRIVATE_STRANGER_SOURCE_PROMPT_VALUE = 10;
        public static final int MSG_PUSH_VALUE = 55;
        public static final int MSG_PUSH_WARN_CLICK_VALUE = 28;
        public static final int MSG_PUSH_WARN_CLOSE_VALUE = 29;
        public static final int MSG_PUSH_WARN_SHOW_VALUE = 27;
        public static final int MSG_RECALL_VALUE = 100;
        public static final int MSG_SAVE_VIDEO_CLICK_VALUE = 33;
        public static final int MSG_SAY_HI_LIST_SHOW_VALUE = 50;
        public static final int MSG_SAY_HI_ONE_CLICK_VALUE = 51;
        public static final int MSG_SCREEN_FOLD_CLOSE_BTN_CLICK_VALUE = 7;
        public static final int MSG_SCREEN_FOLD_VALUE = 2;
        public static final int MSG_SCREEN_FOLLOWED_BTN_CLICK_VALUE = 4;
        public static final int MSG_SCREEN_NEARBY_BTN_CLICK_VALUE = 5;
        public static final int MSG_SCREEN_SEARCH_BOX_CLICK_VALUE = 9;
        public static final int MSG_SCREEN_SEARCH_BOX_SUCCESS_VALUE = 59;
        public static final int MSG_SCREEN_STARTED_BTN_CLICK_VALUE = 3;
        public static final int MSG_SCREEN_UNFOLD_RESET_BTN_CLICK_VALUE = 6;
        public static final int MSG_SCREEN_UNFOLD_VALUE = 1;
        public static final int MSG_SEND_FAIL_VALUE = 84;
        public static final int MSG_SEND_PHOTO_VALUE = 11;
        public static final int MSG_SENSITIVE_CASE_CLICK_VALUE = 91;
        public static final int MSG_SENSITIVE_HIV_CLICK_VALUE = 92;
        public static final int MSG_SENSITIVE_SHOW_VALUE = 90;
        public static final int MSG_SERVICE_ACCOUNT_MSG_ONE_CLICK_VALUE = 85;
        public static final int MSG_SERVICE_CELL_CLICK_VALUE = 72;
        public static final int MSG_SERVICE_LIST_ONE_CLICK_VALUE = 74;
        public static final int MSG_SERVICE_LIST_ONE_SHOW_VALUE = 73;
        public static final int MSG_SETTINGS_BUBBLE_CLICK_VALUE = 36;
        public static final int MSG_SETTINGS_ICON_CLICK_VALUE = 41;
        public static final int MSG_SETTINGS_LIVE_NOTICE_VALUE = 45;
        public static final int MSG_SETTINGS_SPECIAL_CARE_CLICK_VALUE = 124;
        public static final int MSG_SETTINGS_SPECIAL_CARE_LIMIT_SHOW_VALUE = 125;
        public static final int MSG_SHADOW_BUY_CLICK_VALUE = 101;
        public static final int MSG_SHARE_MSG_CLICK_VALUE = 76;
        public static final int MSG_SHARE_MSG_SHOW_VALUE = 75;
        public static final int MSG_SPECIAL_CARE_FEED_NOTICE_CLICK_VALUE = 127;
        public static final int MSG_SPECIAL_CARE_FEED_NOTICE_SHOW_VALUE = 126;
        public static final int MSG_SUPER_FEED_CLICK_VALUE = 135;
        public static final int MSG_SUPER_FEED_SHOW_VALUE = 134;
        public static final int MSG_TO_UP_BTN_CLICK_VALUE = 15;
        public static final int MSG_TO_UP_MAX_SHOW_VALUE = 16;
        public static final int MSG_UNREAD_DRAG_REMOVE_VALUE = 8;
        public static final int MSG_USER_AVATAR_CLICK_VALUE = 120;
        public static final int MSG_USER_AVATAR_TEXT_CLICK_VALUE = 121;
        public static final int MSG_USER_SHOW_VALUE = 119;
        public static final int MSG_VOCATIV_BTN_CLICK_VALUE = 24;
        public static final int MSG_VOCATIV_BTN_SHOW_VALUE = 23;
        public static final int MSG_VOCATIV_USER_CLICK_VALUE = 32;
        public static final int MSG_VOCATIV_USER_SHOW_VALUE = 31;
        public static final int MSG_VOICE_BTN_CLICK_VALUE = 67;
        public static final int MSG_VOICE_DELETE_BTN_CLICK_VALUE = 70;
        public static final int MSG_VOICE_TALK_BTN_CLICK_VALUE = 69;
        public static final int MSG_VOICE_TALK_BTN_SHOW_VALUE = 68;
        public static final int MSG_VOICE_TRANSFER_WORD_CLICK_VALUE = 61;
        public static final int MSG_YY_CLICK_VALUE = 113;
        public static final int MSG_YY_OPEN_CLICK_VALUE = 130;
        public static final int MSG_YY_OPEN_SHOW_VALUE = 129;
        public static final int MSG_YY_ROOM_JOIN_CLICK_VALUE = 71;
        public static final int MSG_YY_SHOW_VALUE = 112;
        public static final int NAVIGATION_BTN_VALUE = 54;
        public static final int POPUP_BANNER_CLICK_VALUE = 111;
        public static final int POPUP_BANNER_CLOSE_VALUE = 114;
        public static final int POPUP_BANNER_COVER_VALUE = 115;
        public static final int POPUP_BANNER_SHOW_VALUE = 110;
        public static final int PRIVATE_CHAT_OPTION_SHOW_VALUE = 47;
        public static final int PRIVATE_CHAT_REPORT_CLICK_VALUE = 49;
        public static final int PUSH_VOCATIV_USER_CLICK_VALUE = 117;
        public static final int PUSH_VOCATIV_USER_SHOW_VALUE = 116;
        public static final int SERVICE_MSG_PAGE_AUTO_REPLY_VALUE = 96;
        public static final int SERVICE_MSG_PAGE_FIRST_CLICK_VALUE = 94;
        public static final int SERVICE_MSG_PAGE_SECOND_CLICK_VALUE = 95;
        public static final int SERVICE_MSG_PAGE_SHOW_VALUE = 93;
        public static final int UNKNOWN_EVENT_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<Event> internalValueMap = new Internal.EnumLiteMap<Event>() { // from class: com.blued.das.message.MessageProtos.Event.1
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
                    return MSG_SCREEN_UNFOLD;
                case 2:
                    return MSG_SCREEN_FOLD;
                case 3:
                    return MSG_SCREEN_STARTED_BTN_CLICK;
                case 4:
                    return MSG_SCREEN_FOLLOWED_BTN_CLICK;
                case 5:
                    return MSG_SCREEN_NEARBY_BTN_CLICK;
                case 6:
                    return MSG_SCREEN_UNFOLD_RESET_BTN_CLICK;
                case 7:
                    return MSG_SCREEN_FOLD_CLOSE_BTN_CLICK;
                case 8:
                    return MSG_UNREAD_DRAG_REMOVE;
                case 9:
                    return MSG_SCREEN_SEARCH_BOX_CLICK;
                case 10:
                    return MSG_PRIVATE_STRANGER_SOURCE_PROMPT;
                case 11:
                    return MSG_SEND_PHOTO;
                case 12:
                    return MSG_NO_DISTURB_FILTER;
                case 13:
                    return MSG_DELETE_POINT_SHOW;
                case 14:
                    return MSG_PHOTO_CLEAR_BTN_CLICK;
                case 15:
                    return MSG_TO_UP_BTN_CLICK;
                case 16:
                    return MSG_TO_UP_MAX_SHOW;
                case 17:
                    return MSG_MORE_IGNORE_UNREAD;
                case 18:
                    return MSG_MORE_CLEAR;
                case 19:
                    return MSG_MORE_VIDEO_SETTING;
                case 20:
                    return MSG_MORE_ATTENTION_SETTING;
                case 21:
                    return MSG_MORE_OPEN_LOOK_QUIET;
                case 22:
                    return MSG_ADD_BTN_CLICK;
                case 23:
                    return MSG_VOCATIV_BTN_SHOW;
                case 24:
                    return MSG_VOCATIV_BTN_CLICK;
                case 25:
                    return MSG_MORE_BTN_CLICK;
                case 26:
                    return MSG_CHAT_SET_BACKGROUND_BTN_CLICK;
                case 27:
                    return MSG_PUSH_WARN_SHOW;
                case 28:
                    return MSG_PUSH_WARN_CLICK;
                case 29:
                    return MSG_PUSH_WARN_CLOSE;
                case 30:
                    return MSG_MORE_NO_DISTURB_CLICK;
                case 31:
                    return MSG_VOCATIV_USER_SHOW;
                case 32:
                    return MSG_VOCATIV_USER_CLICK;
                case 33:
                    return MSG_SAVE_VIDEO_CLICK;
                case 34:
                    return MSG_EMOJI_CLICK;
                case 35:
                    return CHAT_SEND_MSG;
                case 36:
                    return MSG_SETTINGS_BUBBLE_CLICK;
                case 37:
                    return MSG_CLICK_BUBBLE_CLICK;
                case 38:
                    return MSG_BUBBLE_SAVE_CLICK;
                case 39:
                    return CALL_PAGE_USER_SHOW;
                case 40:
                    return CALL_PAGE_USER_CLICK;
                case 41:
                    return MSG_SETTINGS_ICON_CLICK;
                case 42:
                case 103:
                case 104:
                case 105:
                default:
                    return null;
                case 43:
                    return MSG_LIST_OPERATE_SHOW;
                case 44:
                    return MSG_LIST_OPERATE_VIEW_PRIVATE_CLICK;
                case 45:
                    return MSG_SETTINGS_LIVE_NOTICE;
                case 46:
                    return BLUED_MSG_CLICK;
                case 47:
                    return PRIVATE_CHAT_OPTION_SHOW;
                case 48:
                    return CHAT_VIDEO_CLICK;
                case 49:
                    return PRIVATE_CHAT_REPORT_CLICK;
                case 50:
                    return MSG_SAY_HI_LIST_SHOW;
                case 51:
                    return MSG_SAY_HI_ONE_CLICK;
                case 52:
                    return MSG_LIVE_SHOW;
                case 53:
                    return MSG_LIVE_CLICK;
                case 54:
                    return NAVIGATION_BTN;
                case 55:
                    return MSG_PUSH;
                case 56:
                    return MESSAGE_PAGE;
                case 57:
                    return MSG_CLICK;
                case 58:
                    return MSG_BUBBLE_VIP_CLICK;
                case 59:
                    return MSG_SCREEN_SEARCH_BOX_SUCCESS;
                case 60:
                    return CHAT_ROOM_INVITE_MSG_JOIN_CLICK;
                case 61:
                    return MSG_VOICE_TRANSFER_WORD_CLICK;
                case 62:
                    return GIFT_CARD_PAGE_SHOW;
                case 63:
                    return GIFT_CARD_PAGE_SEND_CLICK;
                case 64:
                    return GIFT_CARD_PAGE_CANCEL_CLICK;
                case 65:
                    return GIFT_CARD_PAGE_CANCEL_POP_CONFIRM_CLICK;
                case 66:
                    return GIFT_CARD_PAGE_CANCEL_POP_CANCEL_CLICK;
                case 67:
                    return MSG_VOICE_BTN_CLICK;
                case 68:
                    return MSG_VOICE_TALK_BTN_SHOW;
                case 69:
                    return MSG_VOICE_TALK_BTN_CLICK;
                case 70:
                    return MSG_VOICE_DELETE_BTN_CLICK;
                case 71:
                    return MSG_YY_ROOM_JOIN_CLICK;
                case 72:
                    return MSG_SERVICE_CELL_CLICK;
                case 73:
                    return MSG_SERVICE_LIST_ONE_SHOW;
                case 74:
                    return MSG_SERVICE_LIST_ONE_CLICK;
                case 75:
                    return MSG_SHARE_MSG_SHOW;
                case 76:
                    return MSG_SHARE_MSG_CLICK;
                case 77:
                    return MSG_GIFT_ICON_SHOW;
                case 78:
                    return MSG_GIFT_ICON_CLICK;
                case 79:
                    return MSG_CHEAT_TOAST_SHOW;
                case 80:
                    return MSG_CHEAT_TOAST_CLOSE;
                case 81:
                    return MSG_LIST_SAFE_WARN_SHOW;
                case 82:
                    return MSG_LIST_SAFE_WARN_BACK_CLICK;
                case 83:
                    return MSG_LIST_SAFE_WARN_GET_CLICK;
                case 84:
                    return MSG_SEND_FAIL;
                case 85:
                    return MSG_SERVICE_ACCOUNT_MSG_ONE_CLICK;
                case 86:
                    return MSG_DECEPTION_SHOW;
                case 87:
                    return MSG_AIDS_SHOW;
                case 88:
                    return MSG_AIDS_MORE_CLICK;
                case 89:
                    return MSG_DISABLE_SHOW;
                case 90:
                    return MSG_SENSITIVE_SHOW;
                case 91:
                    return MSG_SENSITIVE_CASE_CLICK;
                case 92:
                    return MSG_SENSITIVE_HIV_CLICK;
                case 93:
                    return SERVICE_MSG_PAGE_SHOW;
                case 94:
                    return SERVICE_MSG_PAGE_FIRST_CLICK;
                case 95:
                    return SERVICE_MSG_PAGE_SECOND_CLICK;
                case 96:
                    return SERVICE_MSG_PAGE_AUTO_REPLY;
                case 97:
                    return FLASH_PHOTO_BUY_POP_SHOW;
                case 98:
                    return FLASH_PHOTO_BUY_POP_YES_CLICK;
                case 99:
                    return FLASH_PHOTO_BUY_POP_NO_CLICK;
                case 100:
                    return MSG_RECALL;
                case 101:
                    return MSG_SHADOW_BUY_CLICK;
                case 102:
                    return FLASH_PHOTO_BUY_POP_FREE_CLICK;
                case 106:
                    return MSG_OPEN_PUSH_POP_SHOW;
                case 107:
                    return MSG_OPEN_PUSH_POP_NO_CLICK;
                case 108:
                    return MSG_OPEN_PUSH_POP_OPEN_CLICK;
                case 109:
                    return BLUED_MSG_SHOW;
                case 110:
                    return POPUP_BANNER_SHOW;
                case 111:
                    return POPUP_BANNER_CLICK;
                case 112:
                    return MSG_YY_SHOW;
                case 113:
                    return MSG_YY_CLICK;
                case 114:
                    return POPUP_BANNER_CLOSE;
                case 115:
                    return POPUP_BANNER_COVER;
                case 116:
                    return PUSH_VOCATIV_USER_SHOW;
                case 117:
                    return PUSH_VOCATIV_USER_CLICK;
                case 118:
                    return MSG_PAGE_SHOW;
                case 119:
                    return MSG_USER_SHOW;
                case 120:
                    return MSG_USER_AVATAR_CLICK;
                case 121:
                    return MSG_USER_AVATAR_TEXT_CLICK;
                case 122:
                    return CHAT_USER_SHOW;
                case 123:
                    return CHAT_USER_LIVE_YY_CLICK;
                case 124:
                    return MSG_SETTINGS_SPECIAL_CARE_CLICK;
                case 125:
                    return MSG_SETTINGS_SPECIAL_CARE_LIMIT_SHOW;
                case 126:
                    return MSG_SPECIAL_CARE_FEED_NOTICE_SHOW;
                case 127:
                    return MSG_SPECIAL_CARE_FEED_NOTICE_CLICK;
                case 128:
                    return MSG_1V1_END;
                case 129:
                    return MSG_YY_OPEN_SHOW;
                case 130:
                    return MSG_YY_OPEN_CLICK;
                case 131:
                    return MSG_PASS_BY_TIPS_SHOW;
                case 132:
                    return MSG_PASS_BY_TIPS_GO_CLICK;
                case 133:
                    return MSG_1V1_LAUNCH;
                case 134:
                    return MSG_SUPER_FEED_SHOW;
                case 135:
                    return MSG_SUPER_FEED_CLICK;
                case 136:
                    return MSG_LIST_MATCH_SHOW;
                case 137:
                    return MSG_LIST_MATCH_CLICK;
                case 138:
                    return MSG_MATCH_CHAT_PAGE_SHOW;
                case 139:
                    return MSG_MATCH_CHAT_PAGE_LIKE_CLICK;
                case 140:
                    return MSG_MATCH_CHAT_PAGE_UNLIKE_CLICK;
                case 141:
                    return MSG_MATCH_CHAT_PAGE_REPORT_CLICK;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return MessageProtos.getDescriptor().getEnumTypes().get(0);
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/message/MessageProtos$MessageProto.class */
    public static final class MessageProto extends GeneratedMessageV3 implements MessageProtoOrBuilder {
        public static final int CALL_FILTER_FIELD_NUMBER = 22;
        public static final int CALL_TYPE_FIELD_NUMBER = 43;
        public static final int DESTINATION_FIELD_NUMBER = 29;
        public static final int DISTANCE_FIELD_NUMBER = 51;
        public static final int DISTURB_RANGE_FIELD_NUMBER = 10;
        public static final int DISTURB_SOURCE_FIELD_NUMBER = 9;
        public static final int DURATION_FIELD_NUMBER = 48;
        public static final int END_TIME_FIELD_NUMBER = 47;
        public static final int EVENT_FIELD_NUMBER = 1;
        public static final int ID_FIELD_NUMBER = 26;
        public static final int IMAGE_ID_FIELD_NUMBER = 20;
        public static final int IS_AI_FIELD_NUMBER = 31;
        public static final int IS_APPRECIATE_CALL_FIELD_NUMBER = 15;
        public static final int IS_BUY_FIELD_NUMBER = 34;
        public static final int IS_MAP_FIND_FIELD_NUMBER = 13;
        public static final int IS_NEW_FIELD_NUMBER = 42;
        public static final int IS_OPEN_FIELD_NUMBER = 11;
        public static final int IS_QUIET_CALL_FIELD_NUMBER = 16;
        public static final int IS_SHADOW_FIELD_NUMBER = 18;
        public static final int IS_SPECIAL_FIELD_NUMBER = 38;
        public static final int IS_SUPER_CALL_FIELD_NUMBER = 44;
        public static final int IS_SUPER_EXPOSURE_FIELD_NUMBER = 17;
        public static final int IS_VALID_FIELD_NUMBER = 21;
        public static final int KEYWORD_FIELD_NUMBER = 27;
        public static final int LIVE_ID_FIELD_NUMBER = 28;
        public static final int LOGO_ID_FIELD_NUMBER = 45;
        public static final int MODE_FIELD_NUMBER = 39;
        public static final int MSG_ID_FIELD_NUMBER = 35;
        public static final int MSG_SCREEN_CLICK_TYPE_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 37;
        public static final int PHOTO_NUM_FIELD_NUMBER = 8;
        public static final int PHOTO_SOURCE_FIELD_NUMBER = 5;
        public static final int PHOTO_TYPE_FIELD_NUMBER = 6;
        public static final int POSITION_FIELD_NUMBER = 25;
        public static final int RATE_FIELD_NUMBER = 50;
        public static final int REASON_FIELD_NUMBER = 36;
        public static final int ROOM_ID_FIELD_NUMBER = 32;
        public static final int ROOM_UID_FIELD_NUMBER = 33;
        public static final int SHOW_TYPE_FIELD_NUMBER = 19;
        public static final int SORT_TYPE_FIELD_NUMBER = 23;
        public static final int START_TIME_FIELD_NUMBER = 46;
        public static final int STATUS_FIELD_NUMBER = 49;
        public static final int STRANGER_SOURCE_FIELD_NUMBER = 7;
        public static final int STRATEGY_FIELD_NUMBER = 40;
        public static final int TARGET_UID_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 30;
        public static final int URL_FIELD_NUMBER = 24;
        public static final int VIRTUAL_FIELD_NUMBER = 41;
        public static final int WARN_TIME_FIELD_NUMBER = 14;
        public static final int WARN_TYPE_FIELD_NUMBER = 12;
        private static final long serialVersionUID = 0;
        private volatile Object callFilter_;
        private int callType_;
        private volatile Object destination_;
        private volatile Object distance_;
        private volatile Object disturbRange_;
        private volatile Object disturbSource_;
        private long duration_;
        private long endTime_;
        private int event_;
        private volatile Object id_;
        private volatile Object imageId_;
        private boolean isAi_;
        private boolean isAppreciateCall_;
        private boolean isBuy_;
        private boolean isMapFind_;
        private boolean isNew_;
        private boolean isOpen_;
        private boolean isQuietCall_;
        private boolean isShadow_;
        private boolean isSpecial_;
        private boolean isSuperCall_;
        private boolean isSuperExposure_;
        private boolean isValid_;
        private volatile Object keyword_;
        private volatile Object liveId_;
        private volatile Object logoId_;
        private byte memoizedIsInitialized;
        private volatile Object mode_;
        private volatile Object msgId_;
        private int msgScreenClickType_;
        private volatile Object name_;
        private int photoNum_;
        private int photoSource_;
        private int photoType_;
        private int position_;
        private double rate_;
        private volatile Object reason_;
        private volatile Object roomId_;
        private volatile Object roomUid_;
        private int showType_;
        private int sortType_;
        private long startTime_;
        private volatile Object status_;
        private int strangerSource_;
        private volatile Object strategy_;
        private volatile Object targetUid_;
        private volatile Object type_;
        private volatile Object url_;
        private int virtual_;
        private int warnTime_;
        private int warnType_;
        private static final MessageProto DEFAULT_INSTANCE = new MessageProto();
        private static final Parser<MessageProto> PARSER = new AbstractParser<MessageProto>() { // from class: com.blued.das.message.MessageProtos.MessageProto.1
            @Override // com.google.protobuf.Parser
            public MessageProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new MessageProto(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/message/MessageProtos$MessageProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MessageProtoOrBuilder {
            private Object callFilter_;
            private int callType_;
            private Object destination_;
            private Object distance_;
            private Object disturbRange_;
            private Object disturbSource_;
            private long duration_;
            private long endTime_;
            private int event_;
            private Object id_;
            private Object imageId_;
            private boolean isAi_;
            private boolean isAppreciateCall_;
            private boolean isBuy_;
            private boolean isMapFind_;
            private boolean isNew_;
            private boolean isOpen_;
            private boolean isQuietCall_;
            private boolean isShadow_;
            private boolean isSpecial_;
            private boolean isSuperCall_;
            private boolean isSuperExposure_;
            private boolean isValid_;
            private Object keyword_;
            private Object liveId_;
            private Object logoId_;
            private Object mode_;
            private Object msgId_;
            private int msgScreenClickType_;
            private Object name_;
            private int photoNum_;
            private int photoSource_;
            private int photoType_;
            private int position_;
            private double rate_;
            private Object reason_;
            private Object roomId_;
            private Object roomUid_;
            private int showType_;
            private int sortType_;
            private long startTime_;
            private Object status_;
            private int strangerSource_;
            private Object strategy_;
            private Object targetUid_;
            private Object type_;
            private Object url_;
            private int virtual_;
            private int warnTime_;
            private int warnType_;

            private Builder() {
                this.event_ = 0;
                this.msgScreenClickType_ = 0;
                this.targetUid_ = "";
                this.photoSource_ = 0;
                this.photoType_ = 0;
                this.strangerSource_ = 0;
                this.disturbSource_ = "";
                this.disturbRange_ = "";
                this.warnType_ = 0;
                this.warnTime_ = 0;
                this.showType_ = 0;
                this.imageId_ = "";
                this.callFilter_ = "";
                this.sortType_ = 0;
                this.url_ = "";
                this.id_ = "";
                this.keyword_ = "";
                this.liveId_ = "";
                this.destination_ = "";
                this.type_ = "";
                this.roomId_ = "";
                this.roomUid_ = "";
                this.msgId_ = "";
                this.reason_ = "";
                this.name_ = "";
                this.mode_ = "";
                this.strategy_ = "";
                this.callType_ = 0;
                this.logoId_ = "";
                this.status_ = "";
                this.distance_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.event_ = 0;
                this.msgScreenClickType_ = 0;
                this.targetUid_ = "";
                this.photoSource_ = 0;
                this.photoType_ = 0;
                this.strangerSource_ = 0;
                this.disturbSource_ = "";
                this.disturbRange_ = "";
                this.warnType_ = 0;
                this.warnTime_ = 0;
                this.showType_ = 0;
                this.imageId_ = "";
                this.callFilter_ = "";
                this.sortType_ = 0;
                this.url_ = "";
                this.id_ = "";
                this.keyword_ = "";
                this.liveId_ = "";
                this.destination_ = "";
                this.type_ = "";
                this.roomId_ = "";
                this.roomUid_ = "";
                this.msgId_ = "";
                this.reason_ = "";
                this.name_ = "";
                this.mode_ = "";
                this.strategy_ = "";
                this.callType_ = 0;
                this.logoId_ = "";
                this.status_ = "";
                this.distance_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtos.internal_static_com_blued_das_message_MessageProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = MessageProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MessageProto build() {
                MessageProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MessageProto buildPartial() {
                MessageProto messageProto = new MessageProto(this);
                messageProto.event_ = this.event_;
                messageProto.msgScreenClickType_ = this.msgScreenClickType_;
                messageProto.targetUid_ = this.targetUid_;
                messageProto.photoSource_ = this.photoSource_;
                messageProto.photoType_ = this.photoType_;
                messageProto.strangerSource_ = this.strangerSource_;
                messageProto.photoNum_ = this.photoNum_;
                messageProto.disturbSource_ = this.disturbSource_;
                messageProto.disturbRange_ = this.disturbRange_;
                messageProto.isOpen_ = this.isOpen_;
                messageProto.warnType_ = this.warnType_;
                messageProto.isMapFind_ = this.isMapFind_;
                messageProto.warnTime_ = this.warnTime_;
                messageProto.isAppreciateCall_ = this.isAppreciateCall_;
                messageProto.isQuietCall_ = this.isQuietCall_;
                messageProto.isSuperExposure_ = this.isSuperExposure_;
                messageProto.isShadow_ = this.isShadow_;
                messageProto.showType_ = this.showType_;
                messageProto.imageId_ = this.imageId_;
                messageProto.isValid_ = this.isValid_;
                messageProto.callFilter_ = this.callFilter_;
                messageProto.sortType_ = this.sortType_;
                messageProto.url_ = this.url_;
                messageProto.position_ = this.position_;
                messageProto.id_ = this.id_;
                messageProto.keyword_ = this.keyword_;
                messageProto.liveId_ = this.liveId_;
                messageProto.destination_ = this.destination_;
                messageProto.type_ = this.type_;
                messageProto.isAi_ = this.isAi_;
                messageProto.roomId_ = this.roomId_;
                messageProto.roomUid_ = this.roomUid_;
                messageProto.isBuy_ = this.isBuy_;
                messageProto.msgId_ = this.msgId_;
                messageProto.reason_ = this.reason_;
                messageProto.name_ = this.name_;
                messageProto.isSpecial_ = this.isSpecial_;
                messageProto.mode_ = this.mode_;
                messageProto.strategy_ = this.strategy_;
                messageProto.virtual_ = this.virtual_;
                messageProto.isNew_ = this.isNew_;
                messageProto.callType_ = this.callType_;
                messageProto.isSuperCall_ = this.isSuperCall_;
                messageProto.logoId_ = this.logoId_;
                messageProto.startTime_ = this.startTime_;
                messageProto.endTime_ = this.endTime_;
                messageProto.duration_ = this.duration_;
                messageProto.status_ = this.status_;
                messageProto.rate_ = this.rate_;
                messageProto.distance_ = this.distance_;
                onBuilt();
                return messageProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.event_ = 0;
                this.msgScreenClickType_ = 0;
                this.targetUid_ = "";
                this.photoSource_ = 0;
                this.photoType_ = 0;
                this.strangerSource_ = 0;
                this.photoNum_ = 0;
                this.disturbSource_ = "";
                this.disturbRange_ = "";
                this.isOpen_ = false;
                this.warnType_ = 0;
                this.isMapFind_ = false;
                this.warnTime_ = 0;
                this.isAppreciateCall_ = false;
                this.isQuietCall_ = false;
                this.isSuperExposure_ = false;
                this.isShadow_ = false;
                this.showType_ = 0;
                this.imageId_ = "";
                this.isValid_ = false;
                this.callFilter_ = "";
                this.sortType_ = 0;
                this.url_ = "";
                this.position_ = 0;
                this.id_ = "";
                this.keyword_ = "";
                this.liveId_ = "";
                this.destination_ = "";
                this.type_ = "";
                this.isAi_ = false;
                this.roomId_ = "";
                this.roomUid_ = "";
                this.isBuy_ = false;
                this.msgId_ = "";
                this.reason_ = "";
                this.name_ = "";
                this.isSpecial_ = false;
                this.mode_ = "";
                this.strategy_ = "";
                this.virtual_ = 0;
                this.isNew_ = false;
                this.callType_ = 0;
                this.isSuperCall_ = false;
                this.logoId_ = "";
                this.startTime_ = 0L;
                this.endTime_ = 0L;
                this.duration_ = 0L;
                this.status_ = "";
                this.rate_ = 0.0d;
                this.distance_ = "";
                return this;
            }

            public Builder clearCallFilter() {
                this.callFilter_ = MessageProto.getDefaultInstance().getCallFilter();
                onChanged();
                return this;
            }

            public Builder clearCallType() {
                this.callType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearDestination() {
                this.destination_ = MessageProto.getDefaultInstance().getDestination();
                onChanged();
                return this;
            }

            public Builder clearDistance() {
                this.distance_ = MessageProto.getDefaultInstance().getDistance();
                onChanged();
                return this;
            }

            public Builder clearDisturbRange() {
                this.disturbRange_ = MessageProto.getDefaultInstance().getDisturbRange();
                onChanged();
                return this;
            }

            public Builder clearDisturbSource() {
                this.disturbSource_ = MessageProto.getDefaultInstance().getDisturbSource();
                onChanged();
                return this;
            }

            public Builder clearDuration() {
                this.duration_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearEndTime() {
                this.endTime_ = 0L;
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
                this.id_ = MessageProto.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            public Builder clearImageId() {
                this.imageId_ = MessageProto.getDefaultInstance().getImageId();
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

            public Builder clearIsBuy() {
                this.isBuy_ = false;
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

            public Builder clearIsValid() {
                this.isValid_ = false;
                onChanged();
                return this;
            }

            public Builder clearKeyword() {
                this.keyword_ = MessageProto.getDefaultInstance().getKeyword();
                onChanged();
                return this;
            }

            public Builder clearLiveId() {
                this.liveId_ = MessageProto.getDefaultInstance().getLiveId();
                onChanged();
                return this;
            }

            public Builder clearLogoId() {
                this.logoId_ = MessageProto.getDefaultInstance().getLogoId();
                onChanged();
                return this;
            }

            public Builder clearMode() {
                this.mode_ = MessageProto.getDefaultInstance().getMode();
                onChanged();
                return this;
            }

            public Builder clearMsgId() {
                this.msgId_ = MessageProto.getDefaultInstance().getMsgId();
                onChanged();
                return this;
            }

            public Builder clearMsgScreenClickType() {
                this.msgScreenClickType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = MessageProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearPhotoNum() {
                this.photoNum_ = 0;
                onChanged();
                return this;
            }

            public Builder clearPhotoSource() {
                this.photoSource_ = 0;
                onChanged();
                return this;
            }

            public Builder clearPhotoType() {
                this.photoType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearPosition() {
                this.position_ = 0;
                onChanged();
                return this;
            }

            public Builder clearRate() {
                this.rate_ = 0.0d;
                onChanged();
                return this;
            }

            public Builder clearReason() {
                this.reason_ = MessageProto.getDefaultInstance().getReason();
                onChanged();
                return this;
            }

            public Builder clearRoomId() {
                this.roomId_ = MessageProto.getDefaultInstance().getRoomId();
                onChanged();
                return this;
            }

            public Builder clearRoomUid() {
                this.roomUid_ = MessageProto.getDefaultInstance().getRoomUid();
                onChanged();
                return this;
            }

            public Builder clearShowType() {
                this.showType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSortType() {
                this.sortType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearStartTime() {
                this.startTime_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearStatus() {
                this.status_ = MessageProto.getDefaultInstance().getStatus();
                onChanged();
                return this;
            }

            public Builder clearStrangerSource() {
                this.strangerSource_ = 0;
                onChanged();
                return this;
            }

            public Builder clearStrategy() {
                this.strategy_ = MessageProto.getDefaultInstance().getStrategy();
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = MessageProto.getDefaultInstance().getTargetUid();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = MessageProto.getDefaultInstance().getType();
                onChanged();
                return this;
            }

            public Builder clearUrl() {
                this.url_ = MessageProto.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            public Builder clearVirtual() {
                this.virtual_ = 0;
                onChanged();
                return this;
            }

            public Builder clearWarnTime() {
                this.warnTime_ = 0;
                onChanged();
                return this;
            }

            public Builder clearWarnType() {
                this.warnType_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getCallFilter() {
                Object obj = this.callFilter_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.callFilter_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getCallFilterBytes() {
                Object obj = this.callFilter_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.callFilter_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public CallType getCallType() {
                CallType valueOf = CallType.valueOf(this.callType_);
                CallType callType = valueOf;
                if (valueOf == null) {
                    callType = CallType.UNRECOGNIZED;
                }
                return callType;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public int getCallTypeValue() {
                return this.callType_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MessageProto getDefaultInstanceForType() {
                return MessageProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MessageProtos.internal_static_com_blued_das_message_MessageProto_descriptor;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getDestination() {
                Object obj = this.destination_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.destination_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getDestinationBytes() {
                Object obj = this.destination_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.destination_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getDistance() {
                Object obj = this.distance_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.distance_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getDistanceBytes() {
                Object obj = this.distance_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.distance_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getDisturbRange() {
                Object obj = this.disturbRange_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.disturbRange_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getDisturbRangeBytes() {
                Object obj = this.disturbRange_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.disturbRange_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getDisturbSource() {
                Object obj = this.disturbSource_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.disturbSource_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getDisturbSourceBytes() {
                Object obj = this.disturbSource_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.disturbSource_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public long getDuration() {
                return this.duration_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public long getEndTime() {
                return this.endTime_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public Event getEvent() {
                Event valueOf = Event.valueOf(this.event_);
                Event event = valueOf;
                if (valueOf == null) {
                    event = Event.UNRECOGNIZED;
                }
                return event;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public int getEventValue() {
                return this.event_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getId() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.id_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getIdBytes() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.id_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getImageId() {
                Object obj = this.imageId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.imageId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getImageIdBytes() {
                Object obj = this.imageId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.imageId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public boolean getIsAi() {
                return this.isAi_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public boolean getIsAppreciateCall() {
                return this.isAppreciateCall_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public boolean getIsBuy() {
                return this.isBuy_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public boolean getIsMapFind() {
                return this.isMapFind_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public boolean getIsNew() {
                return this.isNew_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public boolean getIsQuietCall() {
                return this.isQuietCall_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public boolean getIsShadow() {
                return this.isShadow_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public boolean getIsSpecial() {
                return this.isSpecial_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public boolean getIsSuperCall() {
                return this.isSuperCall_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public boolean getIsSuperExposure() {
                return this.isSuperExposure_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public boolean getIsValid() {
                return this.isValid_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getKeyword() {
                Object obj = this.keyword_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.keyword_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getKeywordBytes() {
                Object obj = this.keyword_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.keyword_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getLiveId() {
                Object obj = this.liveId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.liveId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getLiveIdBytes() {
                Object obj = this.liveId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.liveId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getLogoId() {
                Object obj = this.logoId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.logoId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getLogoIdBytes() {
                Object obj = this.logoId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.logoId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getMode() {
                Object obj = this.mode_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.mode_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getModeBytes() {
                Object obj = this.mode_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.mode_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getMsgId() {
                Object obj = this.msgId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.msgId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getMsgIdBytes() {
                Object obj = this.msgId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.msgId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public MsgScreenClickType getMsgScreenClickType() {
                MsgScreenClickType valueOf = MsgScreenClickType.valueOf(this.msgScreenClickType_);
                MsgScreenClickType msgScreenClickType = valueOf;
                if (valueOf == null) {
                    msgScreenClickType = MsgScreenClickType.UNRECOGNIZED;
                }
                return msgScreenClickType;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public int getMsgScreenClickTypeValue() {
                return this.msgScreenClickType_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public int getPhotoNum() {
                return this.photoNum_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public SourceType getPhotoSource() {
                SourceType valueOf = SourceType.valueOf(this.photoSource_);
                SourceType sourceType = valueOf;
                if (valueOf == null) {
                    sourceType = SourceType.UNRECOGNIZED;
                }
                return sourceType;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public int getPhotoSourceValue() {
                return this.photoSource_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public PhotoType getPhotoType() {
                PhotoType valueOf = PhotoType.valueOf(this.photoType_);
                PhotoType photoType = valueOf;
                if (valueOf == null) {
                    photoType = PhotoType.UNRECOGNIZED;
                }
                return photoType;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public int getPhotoTypeValue() {
                return this.photoType_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public int getPosition() {
                return this.position_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public double getRate() {
                return this.rate_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getReason() {
                Object obj = this.reason_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.reason_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getReasonBytes() {
                Object obj = this.reason_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.reason_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getRoomId() {
                Object obj = this.roomId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.roomId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getRoomIdBytes() {
                Object obj = this.roomId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.roomId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getRoomUid() {
                Object obj = this.roomUid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.roomUid_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getRoomUidBytes() {
                Object obj = this.roomUid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.roomUid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ShowType getShowType() {
                ShowType valueOf = ShowType.valueOf(this.showType_);
                ShowType showType = valueOf;
                if (valueOf == null) {
                    showType = ShowType.UNRECOGNIZED;
                }
                return showType;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public int getShowTypeValue() {
                return this.showType_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public SortType getSortType() {
                SortType valueOf = SortType.valueOf(this.sortType_);
                SortType sortType = valueOf;
                if (valueOf == null) {
                    sortType = SortType.UNRECOGNIZED;
                }
                return sortType;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public int getSortTypeValue() {
                return this.sortType_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public long getStartTime() {
                return this.startTime_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getStatus() {
                Object obj = this.status_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.status_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getStatusBytes() {
                Object obj = this.status_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.status_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public StrangerSource getStrangerSource() {
                StrangerSource valueOf = StrangerSource.valueOf(this.strangerSource_);
                StrangerSource strangerSource = valueOf;
                if (valueOf == null) {
                    strangerSource = StrangerSource.UNRECOGNIZED;
                }
                return strangerSource;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public int getStrangerSourceValue() {
                return this.strangerSource_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getStrategy() {
                Object obj = this.strategy_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.strategy_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getStrategyBytes() {
                Object obj = this.strategy_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.strategy_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getTargetUid() {
                Object obj = this.targetUid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.targetUid_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getTargetUidBytes() {
                Object obj = this.targetUid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.targetUid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getType() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.type_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getTypeBytes() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.type_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public String getUrl() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public ByteString getUrlBytes() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.url_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public int getVirtual() {
                return this.virtual_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public WarnTime getWarnTime() {
                WarnTime valueOf = WarnTime.valueOf(this.warnTime_);
                WarnTime warnTime = valueOf;
                if (valueOf == null) {
                    warnTime = WarnTime.UNRECOGNIZED;
                }
                return warnTime;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public int getWarnTimeValue() {
                return this.warnTime_;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public WarnType getWarnType() {
                WarnType valueOf = WarnType.valueOf(this.warnType_);
                WarnType warnType = valueOf;
                if (valueOf == null) {
                    warnType = WarnType.UNRECOGNIZED;
                }
                return warnType;
            }

            @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
            public int getWarnTypeValue() {
                return this.warnType_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtos.internal_static_com_blued_das_message_MessageProto_fieldAccessorTable.ensureFieldAccessorsInitialized(MessageProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(MessageProto messageProto) {
                if (messageProto == MessageProto.getDefaultInstance()) {
                    return this;
                }
                if (messageProto.event_ != 0) {
                    setEventValue(messageProto.getEventValue());
                }
                if (messageProto.msgScreenClickType_ != 0) {
                    setMsgScreenClickTypeValue(messageProto.getMsgScreenClickTypeValue());
                }
                if (!messageProto.getTargetUid().isEmpty()) {
                    this.targetUid_ = messageProto.targetUid_;
                    onChanged();
                }
                if (messageProto.photoSource_ != 0) {
                    setPhotoSourceValue(messageProto.getPhotoSourceValue());
                }
                if (messageProto.photoType_ != 0) {
                    setPhotoTypeValue(messageProto.getPhotoTypeValue());
                }
                if (messageProto.strangerSource_ != 0) {
                    setStrangerSourceValue(messageProto.getStrangerSourceValue());
                }
                if (messageProto.getPhotoNum() != 0) {
                    setPhotoNum(messageProto.getPhotoNum());
                }
                if (!messageProto.getDisturbSource().isEmpty()) {
                    this.disturbSource_ = messageProto.disturbSource_;
                    onChanged();
                }
                if (!messageProto.getDisturbRange().isEmpty()) {
                    this.disturbRange_ = messageProto.disturbRange_;
                    onChanged();
                }
                if (messageProto.getIsOpen()) {
                    setIsOpen(messageProto.getIsOpen());
                }
                if (messageProto.warnType_ != 0) {
                    setWarnTypeValue(messageProto.getWarnTypeValue());
                }
                if (messageProto.getIsMapFind()) {
                    setIsMapFind(messageProto.getIsMapFind());
                }
                if (messageProto.warnTime_ != 0) {
                    setWarnTimeValue(messageProto.getWarnTimeValue());
                }
                if (messageProto.getIsAppreciateCall()) {
                    setIsAppreciateCall(messageProto.getIsAppreciateCall());
                }
                if (messageProto.getIsQuietCall()) {
                    setIsQuietCall(messageProto.getIsQuietCall());
                }
                if (messageProto.getIsSuperExposure()) {
                    setIsSuperExposure(messageProto.getIsSuperExposure());
                }
                if (messageProto.getIsShadow()) {
                    setIsShadow(messageProto.getIsShadow());
                }
                if (messageProto.showType_ != 0) {
                    setShowTypeValue(messageProto.getShowTypeValue());
                }
                if (!messageProto.getImageId().isEmpty()) {
                    this.imageId_ = messageProto.imageId_;
                    onChanged();
                }
                if (messageProto.getIsValid()) {
                    setIsValid(messageProto.getIsValid());
                }
                if (!messageProto.getCallFilter().isEmpty()) {
                    this.callFilter_ = messageProto.callFilter_;
                    onChanged();
                }
                if (messageProto.sortType_ != 0) {
                    setSortTypeValue(messageProto.getSortTypeValue());
                }
                if (!messageProto.getUrl().isEmpty()) {
                    this.url_ = messageProto.url_;
                    onChanged();
                }
                if (messageProto.getPosition() != 0) {
                    setPosition(messageProto.getPosition());
                }
                if (!messageProto.getId().isEmpty()) {
                    this.id_ = messageProto.id_;
                    onChanged();
                }
                if (!messageProto.getKeyword().isEmpty()) {
                    this.keyword_ = messageProto.keyword_;
                    onChanged();
                }
                if (!messageProto.getLiveId().isEmpty()) {
                    this.liveId_ = messageProto.liveId_;
                    onChanged();
                }
                if (!messageProto.getDestination().isEmpty()) {
                    this.destination_ = messageProto.destination_;
                    onChanged();
                }
                if (!messageProto.getType().isEmpty()) {
                    this.type_ = messageProto.type_;
                    onChanged();
                }
                if (messageProto.getIsAi()) {
                    setIsAi(messageProto.getIsAi());
                }
                if (!messageProto.getRoomId().isEmpty()) {
                    this.roomId_ = messageProto.roomId_;
                    onChanged();
                }
                if (!messageProto.getRoomUid().isEmpty()) {
                    this.roomUid_ = messageProto.roomUid_;
                    onChanged();
                }
                if (messageProto.getIsBuy()) {
                    setIsBuy(messageProto.getIsBuy());
                }
                if (!messageProto.getMsgId().isEmpty()) {
                    this.msgId_ = messageProto.msgId_;
                    onChanged();
                }
                if (!messageProto.getReason().isEmpty()) {
                    this.reason_ = messageProto.reason_;
                    onChanged();
                }
                if (!messageProto.getName().isEmpty()) {
                    this.name_ = messageProto.name_;
                    onChanged();
                }
                if (messageProto.getIsSpecial()) {
                    setIsSpecial(messageProto.getIsSpecial());
                }
                if (!messageProto.getMode().isEmpty()) {
                    this.mode_ = messageProto.mode_;
                    onChanged();
                }
                if (!messageProto.getStrategy().isEmpty()) {
                    this.strategy_ = messageProto.strategy_;
                    onChanged();
                }
                if (messageProto.getVirtual() != 0) {
                    setVirtual(messageProto.getVirtual());
                }
                if (messageProto.getIsNew()) {
                    setIsNew(messageProto.getIsNew());
                }
                if (messageProto.callType_ != 0) {
                    setCallTypeValue(messageProto.getCallTypeValue());
                }
                if (messageProto.getIsSuperCall()) {
                    setIsSuperCall(messageProto.getIsSuperCall());
                }
                if (!messageProto.getLogoId().isEmpty()) {
                    this.logoId_ = messageProto.logoId_;
                    onChanged();
                }
                if (messageProto.getStartTime() != 0) {
                    setStartTime(messageProto.getStartTime());
                }
                if (messageProto.getEndTime() != 0) {
                    setEndTime(messageProto.getEndTime());
                }
                if (messageProto.getDuration() != 0) {
                    setDuration(messageProto.getDuration());
                }
                if (!messageProto.getStatus().isEmpty()) {
                    this.status_ = messageProto.status_;
                    onChanged();
                }
                if (messageProto.getRate() != 0.0d) {
                    setRate(messageProto.getRate());
                }
                if (!messageProto.getDistance().isEmpty()) {
                    this.distance_ = messageProto.distance_;
                    onChanged();
                }
                mergeUnknownFields(messageProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.message.MessageProtos.MessageProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.message.MessageProtos.MessageProto.access$5700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.message.MessageProtos$MessageProto r0 = (com.blued.das.message.MessageProtos.MessageProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.message.MessageProtos$MessageProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.message.MessageProtos$MessageProto r0 = (com.blued.das.message.MessageProtos.MessageProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.message.MessageProtos$MessageProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.message.MessageProtos.MessageProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.message.MessageProtos$MessageProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof MessageProto) {
                    return mergeFrom((MessageProto) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setCallFilter(String str) {
                if (str != null) {
                    this.callFilter_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setCallFilterBytes(ByteString byteString) {
                if (byteString != null) {
                    MessageProto.checkByteStringIsUtf8(byteString);
                    this.callFilter_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setCallType(CallType callType) {
                if (callType != null) {
                    this.callType_ = callType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setCallTypeValue(int i) {
                this.callType_ = i;
                onChanged();
                return this;
            }

            public Builder setDestination(String str) {
                if (str != null) {
                    this.destination_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDestinationBytes(ByteString byteString) {
                if (byteString != null) {
                    MessageProto.checkByteStringIsUtf8(byteString);
                    this.destination_ = byteString;
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
                    MessageProto.checkByteStringIsUtf8(byteString);
                    this.distance_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDisturbRange(String str) {
                if (str != null) {
                    this.disturbRange_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDisturbRangeBytes(ByteString byteString) {
                if (byteString != null) {
                    MessageProto.checkByteStringIsUtf8(byteString);
                    this.disturbRange_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDisturbSource(String str) {
                if (str != null) {
                    this.disturbSource_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDisturbSourceBytes(ByteString byteString) {
                if (byteString != null) {
                    MessageProto.checkByteStringIsUtf8(byteString);
                    this.disturbSource_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDuration(long j) {
                this.duration_ = j;
                onChanged();
                return this;
            }

            public Builder setEndTime(long j) {
                this.endTime_ = j;
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
                    MessageProto.checkByteStringIsUtf8(byteString);
                    this.id_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setImageId(String str) {
                if (str != null) {
                    this.imageId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setImageIdBytes(ByteString byteString) {
                if (byteString != null) {
                    MessageProto.checkByteStringIsUtf8(byteString);
                    this.imageId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
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

            public Builder setIsBuy(boolean z) {
                this.isBuy_ = z;
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

            public Builder setIsValid(boolean z) {
                this.isValid_ = z;
                onChanged();
                return this;
            }

            public Builder setKeyword(String str) {
                if (str != null) {
                    this.keyword_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setKeywordBytes(ByteString byteString) {
                if (byteString != null) {
                    MessageProto.checkByteStringIsUtf8(byteString);
                    this.keyword_ = byteString;
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
                    MessageProto.checkByteStringIsUtf8(byteString);
                    this.liveId_ = byteString;
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
                    MessageProto.checkByteStringIsUtf8(byteString);
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
                    MessageProto.checkByteStringIsUtf8(byteString);
                    this.mode_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMsgId(String str) {
                if (str != null) {
                    this.msgId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMsgIdBytes(ByteString byteString) {
                if (byteString != null) {
                    MessageProto.checkByteStringIsUtf8(byteString);
                    this.msgId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMsgScreenClickType(MsgScreenClickType msgScreenClickType) {
                if (msgScreenClickType != null) {
                    this.msgScreenClickType_ = msgScreenClickType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMsgScreenClickTypeValue(int i) {
                this.msgScreenClickType_ = i;
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
                    MessageProto.checkByteStringIsUtf8(byteString);
                    this.name_ = byteString;
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

            public Builder setPhotoSource(SourceType sourceType) {
                if (sourceType != null) {
                    this.photoSource_ = sourceType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPhotoSourceValue(int i) {
                this.photoSource_ = i;
                onChanged();
                return this;
            }

            public Builder setPhotoType(PhotoType photoType) {
                if (photoType != null) {
                    this.photoType_ = photoType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPhotoTypeValue(int i) {
                this.photoType_ = i;
                onChanged();
                return this;
            }

            public Builder setPosition(int i) {
                this.position_ = i;
                onChanged();
                return this;
            }

            public Builder setRate(double d) {
                this.rate_ = d;
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
                    MessageProto.checkByteStringIsUtf8(byteString);
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

            public Builder setRoomId(String str) {
                if (str != null) {
                    this.roomId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRoomIdBytes(ByteString byteString) {
                if (byteString != null) {
                    MessageProto.checkByteStringIsUtf8(byteString);
                    this.roomId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRoomUid(String str) {
                if (str != null) {
                    this.roomUid_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRoomUidBytes(ByteString byteString) {
                if (byteString != null) {
                    MessageProto.checkByteStringIsUtf8(byteString);
                    this.roomUid_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
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

            public Builder setSortType(SortType sortType) {
                if (sortType != null) {
                    this.sortType_ = sortType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setSortTypeValue(int i) {
                this.sortType_ = i;
                onChanged();
                return this;
            }

            public Builder setStartTime(long j) {
                this.startTime_ = j;
                onChanged();
                return this;
            }

            public Builder setStatus(String str) {
                if (str != null) {
                    this.status_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setStatusBytes(ByteString byteString) {
                if (byteString != null) {
                    MessageProto.checkByteStringIsUtf8(byteString);
                    this.status_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setStrangerSource(StrangerSource strangerSource) {
                if (strangerSource != null) {
                    this.strangerSource_ = strangerSource.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setStrangerSourceValue(int i) {
                this.strangerSource_ = i;
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
                    MessageProto.checkByteStringIsUtf8(byteString);
                    this.strategy_ = byteString;
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
                    MessageProto.checkByteStringIsUtf8(byteString);
                    this.targetUid_ = byteString;
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
                    MessageProto.checkByteStringIsUtf8(byteString);
                    this.type_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
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
                    MessageProto.checkByteStringIsUtf8(byteString);
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

            public Builder setWarnTime(WarnTime warnTime) {
                if (warnTime != null) {
                    this.warnTime_ = warnTime.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setWarnTimeValue(int i) {
                this.warnTime_ = i;
                onChanged();
                return this;
            }

            public Builder setWarnType(WarnType warnType) {
                if (warnType != null) {
                    this.warnType_ = warnType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setWarnTypeValue(int i) {
                this.warnType_ = i;
                onChanged();
                return this;
            }
        }

        private MessageProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.event_ = 0;
            this.msgScreenClickType_ = 0;
            this.targetUid_ = "";
            this.photoSource_ = 0;
            this.photoType_ = 0;
            this.strangerSource_ = 0;
            this.disturbSource_ = "";
            this.disturbRange_ = "";
            this.warnType_ = 0;
            this.warnTime_ = 0;
            this.showType_ = 0;
            this.imageId_ = "";
            this.callFilter_ = "";
            this.sortType_ = 0;
            this.url_ = "";
            this.id_ = "";
            this.keyword_ = "";
            this.liveId_ = "";
            this.destination_ = "";
            this.type_ = "";
            this.roomId_ = "";
            this.roomUid_ = "";
            this.msgId_ = "";
            this.reason_ = "";
            this.name_ = "";
            this.mode_ = "";
            this.strategy_ = "";
            this.callType_ = 0;
            this.logoId_ = "";
            this.status_ = "";
            this.distance_ = "";
        }

        private MessageProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.msgScreenClickType_ = codedInputStream.readEnum();
                                continue;
                            case 26:
                                this.targetUid_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 40:
                                this.photoSource_ = codedInputStream.readEnum();
                                continue;
                            case 48:
                                this.photoType_ = codedInputStream.readEnum();
                                continue;
                            case 56:
                                this.strangerSource_ = codedInputStream.readEnum();
                                continue;
                            case 64:
                                this.photoNum_ = codedInputStream.readInt32();
                                continue;
                            case 74:
                                this.disturbSource_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 82:
                                this.disturbRange_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 88:
                                this.isOpen_ = codedInputStream.readBool();
                                continue;
                            case 96:
                                this.warnType_ = codedInputStream.readEnum();
                                continue;
                            case 104:
                                this.isMapFind_ = codedInputStream.readBool();
                                continue;
                            case 112:
                                this.warnTime_ = codedInputStream.readEnum();
                                continue;
                            case 120:
                                this.isAppreciateCall_ = codedInputStream.readBool();
                                continue;
                            case 128:
                                this.isQuietCall_ = codedInputStream.readBool();
                                continue;
                            case 136:
                                this.isSuperExposure_ = codedInputStream.readBool();
                                continue;
                            case 144:
                                this.isShadow_ = codedInputStream.readBool();
                                continue;
                            case 152:
                                this.showType_ = codedInputStream.readEnum();
                                continue;
                            case 162:
                                this.imageId_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 168:
                                this.isValid_ = codedInputStream.readBool();
                                continue;
                            case 178:
                                this.callFilter_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 184:
                                this.sortType_ = codedInputStream.readEnum();
                                continue;
                            case 194:
                                this.url_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 200:
                                this.position_ = codedInputStream.readInt32();
                                continue;
                            case 210:
                                this.id_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 218:
                                this.keyword_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 226:
                                this.liveId_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 234:
                                this.destination_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 242:
                                this.type_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 248:
                                this.isAi_ = codedInputStream.readBool();
                                continue;
                            case 258:
                                this.roomId_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 266:
                                this.roomUid_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 272:
                                this.isBuy_ = codedInputStream.readBool();
                                continue;
                            case 282:
                                this.msgId_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 290:
                                this.reason_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 298:
                                this.name_ = codedInputStream.readStringRequireUtf8();
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
                                this.isNew_ = codedInputStream.readBool();
                                continue;
                            case 344:
                                this.callType_ = codedInputStream.readEnum();
                                continue;
                            case 352:
                                this.isSuperCall_ = codedInputStream.readBool();
                                continue;
                            case 362:
                                this.logoId_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 368:
                                this.startTime_ = codedInputStream.readInt64();
                                continue;
                            case 376:
                                this.endTime_ = codedInputStream.readInt64();
                                continue;
                            case 384:
                                this.duration_ = codedInputStream.readInt64();
                                continue;
                            case 394:
                                this.status_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 401:
                                this.rate_ = codedInputStream.readDouble();
                                continue;
                            case 410:
                                this.distance_ = codedInputStream.readStringRequireUtf8();
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

        private MessageProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static MessageProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtos.internal_static_com_blued_das_message_MessageProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MessageProto messageProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(messageProto);
        }

        public static MessageProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MessageProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static MessageProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MessageProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MessageProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static MessageProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static MessageProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MessageProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static MessageProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MessageProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static MessageProto parseFrom(InputStream inputStream) throws IOException {
            return (MessageProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static MessageProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MessageProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MessageProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static MessageProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static MessageProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static MessageProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<MessageProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof MessageProto) {
                MessageProto messageProto = (MessageProto) obj;
                return this.event_ == messageProto.event_ && this.msgScreenClickType_ == messageProto.msgScreenClickType_ && getTargetUid().equals(messageProto.getTargetUid()) && this.photoSource_ == messageProto.photoSource_ && this.photoType_ == messageProto.photoType_ && this.strangerSource_ == messageProto.strangerSource_ && getPhotoNum() == messageProto.getPhotoNum() && getDisturbSource().equals(messageProto.getDisturbSource()) && getDisturbRange().equals(messageProto.getDisturbRange()) && getIsOpen() == messageProto.getIsOpen() && this.warnType_ == messageProto.warnType_ && getIsMapFind() == messageProto.getIsMapFind() && this.warnTime_ == messageProto.warnTime_ && getIsAppreciateCall() == messageProto.getIsAppreciateCall() && getIsQuietCall() == messageProto.getIsQuietCall() && getIsSuperExposure() == messageProto.getIsSuperExposure() && getIsShadow() == messageProto.getIsShadow() && this.showType_ == messageProto.showType_ && getImageId().equals(messageProto.getImageId()) && getIsValid() == messageProto.getIsValid() && getCallFilter().equals(messageProto.getCallFilter()) && this.sortType_ == messageProto.sortType_ && getUrl().equals(messageProto.getUrl()) && getPosition() == messageProto.getPosition() && getId().equals(messageProto.getId()) && getKeyword().equals(messageProto.getKeyword()) && getLiveId().equals(messageProto.getLiveId()) && getDestination().equals(messageProto.getDestination()) && getType().equals(messageProto.getType()) && getIsAi() == messageProto.getIsAi() && getRoomId().equals(messageProto.getRoomId()) && getRoomUid().equals(messageProto.getRoomUid()) && getIsBuy() == messageProto.getIsBuy() && getMsgId().equals(messageProto.getMsgId()) && getReason().equals(messageProto.getReason()) && getName().equals(messageProto.getName()) && getIsSpecial() == messageProto.getIsSpecial() && getMode().equals(messageProto.getMode()) && getStrategy().equals(messageProto.getStrategy()) && getVirtual() == messageProto.getVirtual() && getIsNew() == messageProto.getIsNew() && this.callType_ == messageProto.callType_ && getIsSuperCall() == messageProto.getIsSuperCall() && getLogoId().equals(messageProto.getLogoId()) && getStartTime() == messageProto.getStartTime() && getEndTime() == messageProto.getEndTime() && getDuration() == messageProto.getDuration() && getStatus().equals(messageProto.getStatus()) && Double.doubleToLongBits(getRate()) == Double.doubleToLongBits(messageProto.getRate()) && getDistance().equals(messageProto.getDistance()) && this.unknownFields.equals(messageProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getCallFilter() {
            Object obj = this.callFilter_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.callFilter_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getCallFilterBytes() {
            Object obj = this.callFilter_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.callFilter_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public CallType getCallType() {
            CallType valueOf = CallType.valueOf(this.callType_);
            CallType callType = valueOf;
            if (valueOf == null) {
                callType = CallType.UNRECOGNIZED;
            }
            return callType;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public int getCallTypeValue() {
            return this.callType_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MessageProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getDestination() {
            Object obj = this.destination_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.destination_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getDestinationBytes() {
            Object obj = this.destination_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.destination_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getDistance() {
            Object obj = this.distance_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.distance_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getDistanceBytes() {
            Object obj = this.distance_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.distance_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getDisturbRange() {
            Object obj = this.disturbRange_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.disturbRange_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getDisturbRangeBytes() {
            Object obj = this.disturbRange_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.disturbRange_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getDisturbSource() {
            Object obj = this.disturbSource_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.disturbSource_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getDisturbSourceBytes() {
            Object obj = this.disturbSource_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.disturbSource_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public long getDuration() {
            return this.duration_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public long getEndTime() {
            return this.endTime_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public Event getEvent() {
            Event valueOf = Event.valueOf(this.event_);
            Event event = valueOf;
            if (valueOf == null) {
                event = Event.UNRECOGNIZED;
            }
            return event;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public int getEventValue() {
            return this.event_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getId() {
            Object obj = this.id_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.id_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getIdBytes() {
            Object obj = this.id_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.id_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getImageId() {
            Object obj = this.imageId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.imageId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getImageIdBytes() {
            Object obj = this.imageId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.imageId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public boolean getIsAi() {
            return this.isAi_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public boolean getIsAppreciateCall() {
            return this.isAppreciateCall_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public boolean getIsBuy() {
            return this.isBuy_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public boolean getIsMapFind() {
            return this.isMapFind_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public boolean getIsNew() {
            return this.isNew_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public boolean getIsQuietCall() {
            return this.isQuietCall_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public boolean getIsShadow() {
            return this.isShadow_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public boolean getIsSpecial() {
            return this.isSpecial_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public boolean getIsSuperCall() {
            return this.isSuperCall_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public boolean getIsSuperExposure() {
            return this.isSuperExposure_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public boolean getIsValid() {
            return this.isValid_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getKeyword() {
            Object obj = this.keyword_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.keyword_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getKeywordBytes() {
            Object obj = this.keyword_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.keyword_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getLiveId() {
            Object obj = this.liveId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.liveId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getLiveIdBytes() {
            Object obj = this.liveId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.liveId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getLogoId() {
            Object obj = this.logoId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.logoId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getLogoIdBytes() {
            Object obj = this.logoId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.logoId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getMode() {
            Object obj = this.mode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.mode_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getModeBytes() {
            Object obj = this.mode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getMsgId() {
            Object obj = this.msgId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.msgId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getMsgIdBytes() {
            Object obj = this.msgId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.msgId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public MsgScreenClickType getMsgScreenClickType() {
            MsgScreenClickType valueOf = MsgScreenClickType.valueOf(this.msgScreenClickType_);
            MsgScreenClickType msgScreenClickType = valueOf;
            if (valueOf == null) {
                msgScreenClickType = MsgScreenClickType.UNRECOGNIZED;
            }
            return msgScreenClickType;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public int getMsgScreenClickTypeValue() {
            return this.msgScreenClickType_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MessageProto> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public int getPhotoNum() {
            return this.photoNum_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public SourceType getPhotoSource() {
            SourceType valueOf = SourceType.valueOf(this.photoSource_);
            SourceType sourceType = valueOf;
            if (valueOf == null) {
                sourceType = SourceType.UNRECOGNIZED;
            }
            return sourceType;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public int getPhotoSourceValue() {
            return this.photoSource_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public PhotoType getPhotoType() {
            PhotoType valueOf = PhotoType.valueOf(this.photoType_);
            PhotoType photoType = valueOf;
            if (valueOf == null) {
                photoType = PhotoType.UNRECOGNIZED;
            }
            return photoType;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public int getPhotoTypeValue() {
            return this.photoType_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public int getPosition() {
            return this.position_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public double getRate() {
            return this.rate_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getReason() {
            Object obj = this.reason_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.reason_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getReasonBytes() {
            Object obj = this.reason_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.reason_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getRoomId() {
            Object obj = this.roomId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.roomId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getRoomIdBytes() {
            Object obj = this.roomId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.roomId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getRoomUid() {
            Object obj = this.roomUid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.roomUid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getRoomUidBytes() {
            Object obj = this.roomUid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.roomUid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
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
            if (this.msgScreenClickType_ != MsgScreenClickType.UNKNOWN_MSG_SCREEN_CLICK_TYPE.getNumber()) {
                i3 = i2 + CodedOutputStream.computeEnumSize(2, this.msgScreenClickType_);
            }
            int i4 = i3;
            if (!getTargetUidBytes().isEmpty()) {
                i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.targetUid_);
            }
            int i5 = i4;
            if (this.photoSource_ != SourceType.UNKNOWN_SOURCE_TYPE.getNumber()) {
                i5 = i4 + CodedOutputStream.computeEnumSize(5, this.photoSource_);
            }
            int i6 = i5;
            if (this.photoType_ != PhotoType.UNKNOWN_PHOTO_TYPE.getNumber()) {
                i6 = i5 + CodedOutputStream.computeEnumSize(6, this.photoType_);
            }
            int i7 = i6;
            if (this.strangerSource_ != StrangerSource.UNKNOWN_STRANGER_SOURCE.getNumber()) {
                i7 = i6 + CodedOutputStream.computeEnumSize(7, this.strangerSource_);
            }
            int i8 = this.photoNum_;
            int i9 = i7;
            if (i8 != 0) {
                i9 = i7 + CodedOutputStream.computeInt32Size(8, i8);
            }
            int i10 = i9;
            if (!getDisturbSourceBytes().isEmpty()) {
                i10 = i9 + GeneratedMessageV3.computeStringSize(9, this.disturbSource_);
            }
            int i11 = i10;
            if (!getDisturbRangeBytes().isEmpty()) {
                i11 = i10 + GeneratedMessageV3.computeStringSize(10, this.disturbRange_);
            }
            boolean z = this.isOpen_;
            int i12 = i11;
            if (z) {
                i12 = i11 + CodedOutputStream.computeBoolSize(11, z);
            }
            int i13 = i12;
            if (this.warnType_ != WarnType.UNKNOWN_WARN_TYPE.getNumber()) {
                i13 = i12 + CodedOutputStream.computeEnumSize(12, this.warnType_);
            }
            boolean z2 = this.isMapFind_;
            int i14 = i13;
            if (z2) {
                i14 = i13 + CodedOutputStream.computeBoolSize(13, z2);
            }
            int i15 = i14;
            if (this.warnTime_ != WarnTime.UNKNOWN_WARN_TIME.getNumber()) {
                i15 = i14 + CodedOutputStream.computeEnumSize(14, this.warnTime_);
            }
            boolean z3 = this.isAppreciateCall_;
            int i16 = i15;
            if (z3) {
                i16 = i15 + CodedOutputStream.computeBoolSize(15, z3);
            }
            boolean z4 = this.isQuietCall_;
            int i17 = i16;
            if (z4) {
                i17 = i16 + CodedOutputStream.computeBoolSize(16, z4);
            }
            boolean z5 = this.isSuperExposure_;
            int i18 = i17;
            if (z5) {
                i18 = i17 + CodedOutputStream.computeBoolSize(17, z5);
            }
            boolean z6 = this.isShadow_;
            int i19 = i18;
            if (z6) {
                i19 = i18 + CodedOutputStream.computeBoolSize(18, z6);
            }
            int i20 = i19;
            if (this.showType_ != ShowType.UNKNOWN_SHOW_TYPE.getNumber()) {
                i20 = i19 + CodedOutputStream.computeEnumSize(19, this.showType_);
            }
            int i21 = i20;
            if (!getImageIdBytes().isEmpty()) {
                i21 = i20 + GeneratedMessageV3.computeStringSize(20, this.imageId_);
            }
            boolean z7 = this.isValid_;
            int i22 = i21;
            if (z7) {
                i22 = i21 + CodedOutputStream.computeBoolSize(21, z7);
            }
            int i23 = i22;
            if (!getCallFilterBytes().isEmpty()) {
                i23 = i22 + GeneratedMessageV3.computeStringSize(22, this.callFilter_);
            }
            int i24 = i23;
            if (this.sortType_ != SortType.UNKNOWN_SORT_TYPE.getNumber()) {
                i24 = i23 + CodedOutputStream.computeEnumSize(23, this.sortType_);
            }
            int i25 = i24;
            if (!getUrlBytes().isEmpty()) {
                i25 = i24 + GeneratedMessageV3.computeStringSize(24, this.url_);
            }
            int i26 = this.position_;
            int i27 = i25;
            if (i26 != 0) {
                i27 = i25 + CodedOutputStream.computeInt32Size(25, i26);
            }
            int i28 = i27;
            if (!getIdBytes().isEmpty()) {
                i28 = i27 + GeneratedMessageV3.computeStringSize(26, this.id_);
            }
            int i29 = i28;
            if (!getKeywordBytes().isEmpty()) {
                i29 = i28 + GeneratedMessageV3.computeStringSize(27, this.keyword_);
            }
            int i30 = i29;
            if (!getLiveIdBytes().isEmpty()) {
                i30 = i29 + GeneratedMessageV3.computeStringSize(28, this.liveId_);
            }
            int i31 = i30;
            if (!getDestinationBytes().isEmpty()) {
                i31 = i30 + GeneratedMessageV3.computeStringSize(29, this.destination_);
            }
            int i32 = i31;
            if (!getTypeBytes().isEmpty()) {
                i32 = i31 + GeneratedMessageV3.computeStringSize(30, this.type_);
            }
            boolean z8 = this.isAi_;
            int i33 = i32;
            if (z8) {
                i33 = i32 + CodedOutputStream.computeBoolSize(31, z8);
            }
            int i34 = i33;
            if (!getRoomIdBytes().isEmpty()) {
                i34 = i33 + GeneratedMessageV3.computeStringSize(32, this.roomId_);
            }
            int i35 = i34;
            if (!getRoomUidBytes().isEmpty()) {
                i35 = i34 + GeneratedMessageV3.computeStringSize(33, this.roomUid_);
            }
            boolean z9 = this.isBuy_;
            int i36 = i35;
            if (z9) {
                i36 = i35 + CodedOutputStream.computeBoolSize(34, z9);
            }
            int i37 = i36;
            if (!getMsgIdBytes().isEmpty()) {
                i37 = i36 + GeneratedMessageV3.computeStringSize(35, this.msgId_);
            }
            int i38 = i37;
            if (!getReasonBytes().isEmpty()) {
                i38 = i37 + GeneratedMessageV3.computeStringSize(36, this.reason_);
            }
            int i39 = i38;
            if (!getNameBytes().isEmpty()) {
                i39 = i38 + GeneratedMessageV3.computeStringSize(37, this.name_);
            }
            boolean z10 = this.isSpecial_;
            int i40 = i39;
            if (z10) {
                i40 = i39 + CodedOutputStream.computeBoolSize(38, z10);
            }
            int i41 = i40;
            if (!getModeBytes().isEmpty()) {
                i41 = i40 + GeneratedMessageV3.computeStringSize(39, this.mode_);
            }
            int i42 = i41;
            if (!getStrategyBytes().isEmpty()) {
                i42 = i41 + GeneratedMessageV3.computeStringSize(40, this.strategy_);
            }
            int i43 = this.virtual_;
            int i44 = i42;
            if (i43 != 0) {
                i44 = i42 + CodedOutputStream.computeInt32Size(41, i43);
            }
            boolean z11 = this.isNew_;
            int i45 = i44;
            if (z11) {
                i45 = i44 + CodedOutputStream.computeBoolSize(42, z11);
            }
            int i46 = i45;
            if (this.callType_ != CallType.UNKNOWN_CALL_TYPE.getNumber()) {
                i46 = i45 + CodedOutputStream.computeEnumSize(43, this.callType_);
            }
            boolean z12 = this.isSuperCall_;
            int i47 = i46;
            if (z12) {
                i47 = i46 + CodedOutputStream.computeBoolSize(44, z12);
            }
            int i48 = i47;
            if (!getLogoIdBytes().isEmpty()) {
                i48 = i47 + GeneratedMessageV3.computeStringSize(45, this.logoId_);
            }
            long j = this.startTime_;
            int i49 = i48;
            if (j != 0) {
                i49 = i48 + CodedOutputStream.computeInt64Size(46, j);
            }
            long j2 = this.endTime_;
            int i50 = i49;
            if (j2 != 0) {
                i50 = i49 + CodedOutputStream.computeInt64Size(47, j2);
            }
            long j3 = this.duration_;
            int i51 = i50;
            if (j3 != 0) {
                i51 = i50 + CodedOutputStream.computeInt64Size(48, j3);
            }
            int i52 = i51;
            if (!getStatusBytes().isEmpty()) {
                i52 = i51 + GeneratedMessageV3.computeStringSize(49, this.status_);
            }
            double d = this.rate_;
            int i53 = i52;
            if (d != 0.0d) {
                i53 = i52 + CodedOutputStream.computeDoubleSize(50, d);
            }
            int i54 = i53;
            if (!getDistanceBytes().isEmpty()) {
                i54 = i53 + GeneratedMessageV3.computeStringSize(51, this.distance_);
            }
            int serializedSize = i54 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ShowType getShowType() {
            ShowType valueOf = ShowType.valueOf(this.showType_);
            ShowType showType = valueOf;
            if (valueOf == null) {
                showType = ShowType.UNRECOGNIZED;
            }
            return showType;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public int getShowTypeValue() {
            return this.showType_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public SortType getSortType() {
            SortType valueOf = SortType.valueOf(this.sortType_);
            SortType sortType = valueOf;
            if (valueOf == null) {
                sortType = SortType.UNRECOGNIZED;
            }
            return sortType;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public int getSortTypeValue() {
            return this.sortType_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public long getStartTime() {
            return this.startTime_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getStatus() {
            Object obj = this.status_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.status_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getStatusBytes() {
            Object obj = this.status_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.status_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public StrangerSource getStrangerSource() {
            StrangerSource valueOf = StrangerSource.valueOf(this.strangerSource_);
            StrangerSource strangerSource = valueOf;
            if (valueOf == null) {
                strangerSource = StrangerSource.UNRECOGNIZED;
            }
            return strangerSource;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public int getStrangerSourceValue() {
            return this.strangerSource_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getStrategy() {
            Object obj = this.strategy_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.strategy_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getStrategyBytes() {
            Object obj = this.strategy_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.strategy_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getTargetUid() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.targetUid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getTargetUidBytes() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.targetUid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getType() {
            Object obj = this.type_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.type_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getTypeBytes() {
            Object obj = this.type_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public int getVirtual() {
            return this.virtual_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public WarnTime getWarnTime() {
            WarnTime valueOf = WarnTime.valueOf(this.warnTime_);
            WarnTime warnTime = valueOf;
            if (valueOf == null) {
                warnTime = WarnTime.UNRECOGNIZED;
            }
            return warnTime;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public int getWarnTimeValue() {
            return this.warnTime_;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public WarnType getWarnType() {
            WarnType valueOf = WarnType.valueOf(this.warnType_);
            WarnType warnType = valueOf;
            if (valueOf == null) {
                warnType = WarnType.UNRECOGNIZED;
            }
            return warnType;
        }

        @Override // com.blued.das.message.MessageProtos.MessageProtoOrBuilder
        public int getWarnTypeValue() {
            return this.warnType_;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.event_) * 37) + 2) * 53) + this.msgScreenClickType_) * 37) + 3) * 53) + getTargetUid().hashCode()) * 37) + 5) * 53) + this.photoSource_) * 37) + 6) * 53) + this.photoType_) * 37) + 7) * 53) + this.strangerSource_) * 37) + 8) * 53) + getPhotoNum()) * 37) + 9) * 53) + getDisturbSource().hashCode()) * 37) + 10) * 53) + getDisturbRange().hashCode()) * 37) + 11) * 53) + Internal.hashBoolean(getIsOpen())) * 37) + 12) * 53) + this.warnType_) * 37) + 13) * 53) + Internal.hashBoolean(getIsMapFind())) * 37) + 14) * 53) + this.warnTime_) * 37) + 15) * 53) + Internal.hashBoolean(getIsAppreciateCall())) * 37) + 16) * 53) + Internal.hashBoolean(getIsQuietCall())) * 37) + 17) * 53) + Internal.hashBoolean(getIsSuperExposure())) * 37) + 18) * 53) + Internal.hashBoolean(getIsShadow())) * 37) + 19) * 53) + this.showType_) * 37) + 20) * 53) + getImageId().hashCode()) * 37) + 21) * 53) + Internal.hashBoolean(getIsValid())) * 37) + 22) * 53) + getCallFilter().hashCode()) * 37) + 23) * 53) + this.sortType_) * 37) + 24) * 53) + getUrl().hashCode()) * 37) + 25) * 53) + getPosition()) * 37) + 26) * 53) + getId().hashCode()) * 37) + 27) * 53) + getKeyword().hashCode()) * 37) + 28) * 53) + getLiveId().hashCode()) * 37) + 29) * 53) + getDestination().hashCode()) * 37) + 30) * 53) + getType().hashCode()) * 37) + 31) * 53) + Internal.hashBoolean(getIsAi())) * 37) + 32) * 53) + getRoomId().hashCode()) * 37) + 33) * 53) + getRoomUid().hashCode()) * 37) + 34) * 53) + Internal.hashBoolean(getIsBuy())) * 37) + 35) * 53) + getMsgId().hashCode()) * 37) + 36) * 53) + getReason().hashCode()) * 37) + 37) * 53) + getName().hashCode()) * 37) + 38) * 53) + Internal.hashBoolean(getIsSpecial())) * 37) + 39) * 53) + getMode().hashCode()) * 37) + 40) * 53) + getStrategy().hashCode()) * 37) + 41) * 53) + getVirtual()) * 37) + 42) * 53) + Internal.hashBoolean(getIsNew())) * 37) + 43) * 53) + this.callType_) * 37) + 44) * 53) + Internal.hashBoolean(getIsSuperCall())) * 37) + 45) * 53) + getLogoId().hashCode()) * 37) + 46) * 53) + Internal.hashLong(getStartTime())) * 37) + 47) * 53) + Internal.hashLong(getEndTime())) * 37) + 48) * 53) + Internal.hashLong(getDuration())) * 37) + 49) * 53) + getStatus().hashCode()) * 37) + 50) * 53) + Internal.hashLong(Double.doubleToLongBits(getRate()))) * 37) + 51) * 53) + getDistance().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtos.internal_static_com_blued_das_message_MessageProto_fieldAccessorTable.ensureFieldAccessorsInitialized(MessageProto.class, Builder.class);
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
            return new MessageProto();
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
            if (this.msgScreenClickType_ != MsgScreenClickType.UNKNOWN_MSG_SCREEN_CLICK_TYPE.getNumber()) {
                codedOutputStream.writeEnum(2, this.msgScreenClickType_);
            }
            if (!getTargetUidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.targetUid_);
            }
            if (this.photoSource_ != SourceType.UNKNOWN_SOURCE_TYPE.getNumber()) {
                codedOutputStream.writeEnum(5, this.photoSource_);
            }
            if (this.photoType_ != PhotoType.UNKNOWN_PHOTO_TYPE.getNumber()) {
                codedOutputStream.writeEnum(6, this.photoType_);
            }
            if (this.strangerSource_ != StrangerSource.UNKNOWN_STRANGER_SOURCE.getNumber()) {
                codedOutputStream.writeEnum(7, this.strangerSource_);
            }
            int i = this.photoNum_;
            if (i != 0) {
                codedOutputStream.writeInt32(8, i);
            }
            if (!getDisturbSourceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 9, this.disturbSource_);
            }
            if (!getDisturbRangeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.disturbRange_);
            }
            boolean z = this.isOpen_;
            if (z) {
                codedOutputStream.writeBool(11, z);
            }
            if (this.warnType_ != WarnType.UNKNOWN_WARN_TYPE.getNumber()) {
                codedOutputStream.writeEnum(12, this.warnType_);
            }
            boolean z2 = this.isMapFind_;
            if (z2) {
                codedOutputStream.writeBool(13, z2);
            }
            if (this.warnTime_ != WarnTime.UNKNOWN_WARN_TIME.getNumber()) {
                codedOutputStream.writeEnum(14, this.warnTime_);
            }
            boolean z3 = this.isAppreciateCall_;
            if (z3) {
                codedOutputStream.writeBool(15, z3);
            }
            boolean z4 = this.isQuietCall_;
            if (z4) {
                codedOutputStream.writeBool(16, z4);
            }
            boolean z5 = this.isSuperExposure_;
            if (z5) {
                codedOutputStream.writeBool(17, z5);
            }
            boolean z6 = this.isShadow_;
            if (z6) {
                codedOutputStream.writeBool(18, z6);
            }
            if (this.showType_ != ShowType.UNKNOWN_SHOW_TYPE.getNumber()) {
                codedOutputStream.writeEnum(19, this.showType_);
            }
            if (!getImageIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 20, this.imageId_);
            }
            boolean z7 = this.isValid_;
            if (z7) {
                codedOutputStream.writeBool(21, z7);
            }
            if (!getCallFilterBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 22, this.callFilter_);
            }
            if (this.sortType_ != SortType.UNKNOWN_SORT_TYPE.getNumber()) {
                codedOutputStream.writeEnum(23, this.sortType_);
            }
            if (!getUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 24, this.url_);
            }
            int i2 = this.position_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(25, i2);
            }
            if (!getIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 26, this.id_);
            }
            if (!getKeywordBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 27, this.keyword_);
            }
            if (!getLiveIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 28, this.liveId_);
            }
            if (!getDestinationBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 29, this.destination_);
            }
            if (!getTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 30, this.type_);
            }
            boolean z8 = this.isAi_;
            if (z8) {
                codedOutputStream.writeBool(31, z8);
            }
            if (!getRoomIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 32, this.roomId_);
            }
            if (!getRoomUidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 33, this.roomUid_);
            }
            boolean z9 = this.isBuy_;
            if (z9) {
                codedOutputStream.writeBool(34, z9);
            }
            if (!getMsgIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 35, this.msgId_);
            }
            if (!getReasonBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 36, this.reason_);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 37, this.name_);
            }
            boolean z10 = this.isSpecial_;
            if (z10) {
                codedOutputStream.writeBool(38, z10);
            }
            if (!getModeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 39, this.mode_);
            }
            if (!getStrategyBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 40, this.strategy_);
            }
            int i3 = this.virtual_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(41, i3);
            }
            boolean z11 = this.isNew_;
            if (z11) {
                codedOutputStream.writeBool(42, z11);
            }
            if (this.callType_ != CallType.UNKNOWN_CALL_TYPE.getNumber()) {
                codedOutputStream.writeEnum(43, this.callType_);
            }
            boolean z12 = this.isSuperCall_;
            if (z12) {
                codedOutputStream.writeBool(44, z12);
            }
            if (!getLogoIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 45, this.logoId_);
            }
            long j = this.startTime_;
            if (j != 0) {
                codedOutputStream.writeInt64(46, j);
            }
            long j2 = this.endTime_;
            if (j2 != 0) {
                codedOutputStream.writeInt64(47, j2);
            }
            long j3 = this.duration_;
            if (j3 != 0) {
                codedOutputStream.writeInt64(48, j3);
            }
            if (!getStatusBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 49, this.status_);
            }
            double d = this.rate_;
            if (d != 0.0d) {
                codedOutputStream.writeDouble(50, d);
            }
            if (!getDistanceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 51, this.distance_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/message/MessageProtos$MessageProtoOrBuilder.class */
    public interface MessageProtoOrBuilder extends MessageOrBuilder {
        String getCallFilter();

        ByteString getCallFilterBytes();

        CallType getCallType();

        int getCallTypeValue();

        String getDestination();

        ByteString getDestinationBytes();

        String getDistance();

        ByteString getDistanceBytes();

        String getDisturbRange();

        ByteString getDisturbRangeBytes();

        String getDisturbSource();

        ByteString getDisturbSourceBytes();

        long getDuration();

        long getEndTime();

        Event getEvent();

        int getEventValue();

        String getId();

        ByteString getIdBytes();

        String getImageId();

        ByteString getImageIdBytes();

        boolean getIsAi();

        boolean getIsAppreciateCall();

        boolean getIsBuy();

        boolean getIsMapFind();

        boolean getIsNew();

        boolean getIsOpen();

        boolean getIsQuietCall();

        boolean getIsShadow();

        boolean getIsSpecial();

        boolean getIsSuperCall();

        boolean getIsSuperExposure();

        boolean getIsValid();

        String getKeyword();

        ByteString getKeywordBytes();

        String getLiveId();

        ByteString getLiveIdBytes();

        String getLogoId();

        ByteString getLogoIdBytes();

        String getMode();

        ByteString getModeBytes();

        String getMsgId();

        ByteString getMsgIdBytes();

        MsgScreenClickType getMsgScreenClickType();

        int getMsgScreenClickTypeValue();

        String getName();

        ByteString getNameBytes();

        int getPhotoNum();

        SourceType getPhotoSource();

        int getPhotoSourceValue();

        PhotoType getPhotoType();

        int getPhotoTypeValue();

        int getPosition();

        double getRate();

        String getReason();

        ByteString getReasonBytes();

        String getRoomId();

        ByteString getRoomIdBytes();

        String getRoomUid();

        ByteString getRoomUidBytes();

        ShowType getShowType();

        int getShowTypeValue();

        SortType getSortType();

        int getSortTypeValue();

        long getStartTime();

        String getStatus();

        ByteString getStatusBytes();

        StrangerSource getStrangerSource();

        int getStrangerSourceValue();

        String getStrategy();

        ByteString getStrategyBytes();

        String getTargetUid();

        ByteString getTargetUidBytes();

        String getType();

        ByteString getTypeBytes();

        String getUrl();

        ByteString getUrlBytes();

        int getVirtual();

        WarnTime getWarnTime();

        int getWarnTimeValue();

        WarnType getWarnType();

        int getWarnTypeValue();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/message/MessageProtos$MsgScreenClickType.class */
    public enum MsgScreenClickType implements ProtocolMessageEnum {
        UNKNOWN_MSG_SCREEN_CLICK_TYPE(0),
        MSG_SCREEN_CLICK_TYPE_OPEN(1),
        MSG_SCREEN_CLICK_TYPE_CLOSE(2),
        UNRECOGNIZED(-1);
        
        public static final int MSG_SCREEN_CLICK_TYPE_CLOSE_VALUE = 2;
        public static final int MSG_SCREEN_CLICK_TYPE_OPEN_VALUE = 1;
        public static final int UNKNOWN_MSG_SCREEN_CLICK_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<MsgScreenClickType> internalValueMap = new Internal.EnumLiteMap<MsgScreenClickType>() { // from class: com.blued.das.message.MessageProtos.MsgScreenClickType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public MsgScreenClickType findValueByNumber(int i) {
                return MsgScreenClickType.forNumber(i);
            }
        };
        private static final MsgScreenClickType[] VALUES = values();

        MsgScreenClickType(int i) {
            this.value = i;
        }

        public static MsgScreenClickType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return MSG_SCREEN_CLICK_TYPE_CLOSE;
                }
                return MSG_SCREEN_CLICK_TYPE_OPEN;
            }
            return UNKNOWN_MSG_SCREEN_CLICK_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return MessageProtos.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<MsgScreenClickType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static MsgScreenClickType valueOf(int i) {
            return forNumber(i);
        }

        public static MsgScreenClickType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/message/MessageProtos$PhotoType.class */
    public enum PhotoType implements ProtocolMessageEnum {
        UNKNOWN_PHOTO_TYPE(0),
        NORMAL_PHOTO(1),
        BURN_AFTER_READ(2),
        UNRECOGNIZED(-1);
        
        public static final int BURN_AFTER_READ_VALUE = 2;
        public static final int NORMAL_PHOTO_VALUE = 1;
        public static final int UNKNOWN_PHOTO_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<PhotoType> internalValueMap = new Internal.EnumLiteMap<PhotoType>() { // from class: com.blued.das.message.MessageProtos.PhotoType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PhotoType findValueByNumber(int i) {
                return PhotoType.forNumber(i);
            }
        };
        private static final PhotoType[] VALUES = values();

        PhotoType(int i) {
            this.value = i;
        }

        public static PhotoType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return BURN_AFTER_READ;
                }
                return NORMAL_PHOTO;
            }
            return UNKNOWN_PHOTO_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return MessageProtos.getDescriptor().getEnumTypes().get(4);
        }

        public static Internal.EnumLiteMap<PhotoType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static PhotoType valueOf(int i) {
            return forNumber(i);
        }

        public static PhotoType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/message/MessageProtos$ShowType.class */
    public enum ShowType implements ProtocolMessageEnum {
        UNKNOWN_SHOW_TYPE(0),
        PALACE_SHOW(1),
        LIST_SHOW(2),
        UNRECOGNIZED(-1);
        
        public static final int LIST_SHOW_VALUE = 2;
        public static final int PALACE_SHOW_VALUE = 1;
        public static final int UNKNOWN_SHOW_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<ShowType> internalValueMap = new Internal.EnumLiteMap<ShowType>() { // from class: com.blued.das.message.MessageProtos.ShowType.1
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
            return MessageProtos.getDescriptor().getEnumTypes().get(7);
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/message/MessageProtos$SortType.class */
    public enum SortType implements ProtocolMessageEnum {
        UNKNOWN_SORT_TYPE(0),
        AI_SORT_TYPE(1),
        DISTANCE_SORT_TYPE(2),
        UNRECOGNIZED(-1);
        
        public static final int AI_SORT_TYPE_VALUE = 1;
        public static final int DISTANCE_SORT_TYPE_VALUE = 2;
        public static final int UNKNOWN_SORT_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<SortType> internalValueMap = new Internal.EnumLiteMap<SortType>() { // from class: com.blued.das.message.MessageProtos.SortType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public SortType findValueByNumber(int i) {
                return SortType.forNumber(i);
            }
        };
        private static final SortType[] VALUES = values();

        SortType(int i) {
            this.value = i;
        }

        public static SortType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return DISTANCE_SORT_TYPE;
                }
                return AI_SORT_TYPE;
            }
            return UNKNOWN_SORT_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return MessageProtos.getDescriptor().getEnumTypes().get(8);
        }

        public static Internal.EnumLiteMap<SortType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static SortType valueOf(int i) {
            return forNumber(i);
        }

        public static SortType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/message/MessageProtos$SourceType.class */
    public enum SourceType implements ProtocolMessageEnum {
        UNKNOWN_SOURCE_TYPE(0),
        RECENT_PHOTO(1),
        COMPLETE_PHOTO(2),
        UNRECOGNIZED(-1);
        
        public static final int COMPLETE_PHOTO_VALUE = 2;
        public static final int RECENT_PHOTO_VALUE = 1;
        public static final int UNKNOWN_SOURCE_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<SourceType> internalValueMap = new Internal.EnumLiteMap<SourceType>() { // from class: com.blued.das.message.MessageProtos.SourceType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public SourceType findValueByNumber(int i) {
                return SourceType.forNumber(i);
            }
        };
        private static final SourceType[] VALUES = values();

        SourceType(int i) {
            this.value = i;
        }

        public static SourceType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return COMPLETE_PHOTO;
                }
                return RECENT_PHOTO;
            }
            return UNKNOWN_SOURCE_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return MessageProtos.getDescriptor().getEnumTypes().get(3);
        }

        public static Internal.EnumLiteMap<SourceType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static SourceType valueOf(int i) {
            return forNumber(i);
        }

        public static SourceType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/message/MessageProtos$StrangerSource.class */
    public enum StrangerSource implements ProtocolMessageEnum {
        UNKNOWN_STRANGER_SOURCE(0),
        FRIEND_NEARBY_VISIT(1),
        FRIEND_NEARBY_VIEW(2),
        FRIEND_NEARBY_NEARBY(3),
        FRIEND_NEARBY_ONLINE(4),
        FRIEND_NEARBY_NEW_FACE(5),
        FRIEND_NEARBY_PERSONAL_NEARBY(6),
        FOLLOW_ATTENTION(7),
        FEED_NEARBY(8),
        FEED_FIND_PHOTO(9),
        FEED_FIND_PLAZA(10),
        FEED_PERSONAL_TOPIC(11),
        FEED_NOT_SUPER_EXPOSURE(12),
        APPRECIATE_CALL_SHORT(13),
        APPRECIATE_CALL_TOTAL(14),
        APPRECIATE_NEARBY(15),
        APPRECIATE_FIND(16),
        APPRECIATE_SUPER_EXPOSURE(17),
        LIVE(18),
        MINE_FOLLOW(19),
        MINE_FAN(20),
        MAP_FIND(21),
        APPRECIATE_CALL_COMPLEX(22),
        APPRECIATE_CALL_ONLINE(23),
        SHADOW_SOURCE(24),
        MINE_FRIEND(25),
        COMPLEX_SORT(26),
        ONLINE_TIME_SORT(27),
        DISTANCE_SORT(28),
        NEARBY_FEATURED(29),
        FEED_COMMENT(30),
        NEW_FACE(31),
        SUPER_TOPIC_DETAIL(32),
        FIND_PLAZA_RECOMMEND_USER(33),
        FIND_PLAZA_RECOMMEND(34),
        FIND_PLAZA_FOLLOW(35),
        FIND_PLAZA_NEARBY(36),
        FIND_PLAZA_IMAGE(37),
        FIND_PLAZA_FLASH(38),
        FIND_PLAZA_FLASH_DETAIL(39),
        FEED_DETAIL(40),
        PAGE_FEED_MINE(41),
        PAGE_FEED_LIKE(42),
        PAGE_FEED_DETAIL_MORE(43),
        CIRCLE_NOTE_DETAIL(44),
        CIRCLE_DETAIL_NOTE_NEW(45),
        CIRCLE_DETAIL_NOTE_HOT(46),
        CIRCLE_USERS(47),
        ONE_CITY(48),
        GROUP_CHAT(49),
        CHAT_ROOM(50),
        NOTICE_FOLLOW_ME(51),
        CITY_TIME(52),
        FEED_IMAGE_FULL_SCREEN(53),
        PERSONAL_VIDEO_FULL_SCREEN(54),
        MSG_TOP_TITLE(55),
        MSG_PHOTO(56),
        MSG_SETTING_PHOTO(57),
        NOTICE_LIKE(58),
        LITE_RECOMMEND(59),
        HOT_BUBBLE(60),
        CITY_ALL_HI(61),
        CITY_TIME_HI(62),
        CITY_ALL_IMAGE(63),
        CITY_ALL_VIDEO(64),
        CITY_ALL_DETAIL(65),
        RECOMMEND_IMAGE(66),
        RECOMMEND_VIDEO(67),
        RECOMMEND_DETAIL(68),
        CITY_NOTE(69),
        CITY_TIME_NOTE(70),
        MAP_FRIEND_USER(71),
        NEARBY_OPERATION(72),
        SAME_USER(73),
        PUSH_CALL(74),
        TOPIC_RECOMMEND(75),
        TOPIC_NEW(76),
        UNRECOGNIZED(-1);
        
        public static final int APPRECIATE_CALL_COMPLEX_VALUE = 22;
        public static final int APPRECIATE_CALL_ONLINE_VALUE = 23;
        public static final int APPRECIATE_CALL_SHORT_VALUE = 13;
        public static final int APPRECIATE_CALL_TOTAL_VALUE = 14;
        public static final int APPRECIATE_FIND_VALUE = 16;
        public static final int APPRECIATE_NEARBY_VALUE = 15;
        public static final int APPRECIATE_SUPER_EXPOSURE_VALUE = 17;
        public static final int CHAT_ROOM_VALUE = 50;
        public static final int CIRCLE_DETAIL_NOTE_HOT_VALUE = 46;
        public static final int CIRCLE_DETAIL_NOTE_NEW_VALUE = 45;
        public static final int CIRCLE_NOTE_DETAIL_VALUE = 44;
        public static final int CIRCLE_USERS_VALUE = 47;
        public static final int CITY_ALL_DETAIL_VALUE = 65;
        public static final int CITY_ALL_HI_VALUE = 61;
        public static final int CITY_ALL_IMAGE_VALUE = 63;
        public static final int CITY_ALL_VIDEO_VALUE = 64;
        public static final int CITY_NOTE_VALUE = 69;
        public static final int CITY_TIME_HI_VALUE = 62;
        public static final int CITY_TIME_NOTE_VALUE = 70;
        public static final int CITY_TIME_VALUE = 52;
        public static final int COMPLEX_SORT_VALUE = 26;
        public static final int DISTANCE_SORT_VALUE = 28;
        public static final int FEED_COMMENT_VALUE = 30;
        public static final int FEED_DETAIL_VALUE = 40;
        public static final int FEED_FIND_PHOTO_VALUE = 9;
        public static final int FEED_FIND_PLAZA_VALUE = 10;
        public static final int FEED_IMAGE_FULL_SCREEN_VALUE = 53;
        public static final int FEED_NEARBY_VALUE = 8;
        public static final int FEED_NOT_SUPER_EXPOSURE_VALUE = 12;
        public static final int FEED_PERSONAL_TOPIC_VALUE = 11;
        public static final int FIND_PLAZA_FLASH_DETAIL_VALUE = 39;
        public static final int FIND_PLAZA_FLASH_VALUE = 38;
        public static final int FIND_PLAZA_FOLLOW_VALUE = 35;
        public static final int FIND_PLAZA_IMAGE_VALUE = 37;
        public static final int FIND_PLAZA_NEARBY_VALUE = 36;
        public static final int FIND_PLAZA_RECOMMEND_USER_VALUE = 33;
        public static final int FIND_PLAZA_RECOMMEND_VALUE = 34;
        public static final int FOLLOW_ATTENTION_VALUE = 7;
        public static final int FRIEND_NEARBY_NEARBY_VALUE = 3;
        public static final int FRIEND_NEARBY_NEW_FACE_VALUE = 5;
        public static final int FRIEND_NEARBY_ONLINE_VALUE = 4;
        public static final int FRIEND_NEARBY_PERSONAL_NEARBY_VALUE = 6;
        public static final int FRIEND_NEARBY_VIEW_VALUE = 2;
        public static final int FRIEND_NEARBY_VISIT_VALUE = 1;
        public static final int GROUP_CHAT_VALUE = 49;
        public static final int HOT_BUBBLE_VALUE = 60;
        public static final int LITE_RECOMMEND_VALUE = 59;
        public static final int LIVE_VALUE = 18;
        public static final int MAP_FIND_VALUE = 21;
        public static final int MAP_FRIEND_USER_VALUE = 71;
        public static final int MINE_FAN_VALUE = 20;
        public static final int MINE_FOLLOW_VALUE = 19;
        public static final int MINE_FRIEND_VALUE = 25;
        public static final int MSG_PHOTO_VALUE = 56;
        public static final int MSG_SETTING_PHOTO_VALUE = 57;
        public static final int MSG_TOP_TITLE_VALUE = 55;
        public static final int NEARBY_FEATURED_VALUE = 29;
        public static final int NEARBY_OPERATION_VALUE = 72;
        public static final int NEW_FACE_VALUE = 31;
        public static final int NOTICE_FOLLOW_ME_VALUE = 51;
        public static final int NOTICE_LIKE_VALUE = 58;
        public static final int ONE_CITY_VALUE = 48;
        public static final int ONLINE_TIME_SORT_VALUE = 27;
        public static final int PAGE_FEED_DETAIL_MORE_VALUE = 43;
        public static final int PAGE_FEED_LIKE_VALUE = 42;
        public static final int PAGE_FEED_MINE_VALUE = 41;
        public static final int PERSONAL_VIDEO_FULL_SCREEN_VALUE = 54;
        public static final int PUSH_CALL_VALUE = 74;
        public static final int RECOMMEND_DETAIL_VALUE = 68;
        public static final int RECOMMEND_IMAGE_VALUE = 66;
        public static final int RECOMMEND_VIDEO_VALUE = 67;
        public static final int SAME_USER_VALUE = 73;
        public static final int SHADOW_SOURCE_VALUE = 24;
        public static final int SUPER_TOPIC_DETAIL_VALUE = 32;
        public static final int TOPIC_NEW_VALUE = 76;
        public static final int TOPIC_RECOMMEND_VALUE = 75;
        public static final int UNKNOWN_STRANGER_SOURCE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<StrangerSource> internalValueMap = new Internal.EnumLiteMap<StrangerSource>() { // from class: com.blued.das.message.MessageProtos.StrangerSource.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public StrangerSource findValueByNumber(int i) {
                return StrangerSource.forNumber(i);
            }
        };
        private static final StrangerSource[] VALUES = values();

        StrangerSource(int i) {
            this.value = i;
        }

        public static StrangerSource forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_STRANGER_SOURCE;
                case 1:
                    return FRIEND_NEARBY_VISIT;
                case 2:
                    return FRIEND_NEARBY_VIEW;
                case 3:
                    return FRIEND_NEARBY_NEARBY;
                case 4:
                    return FRIEND_NEARBY_ONLINE;
                case 5:
                    return FRIEND_NEARBY_NEW_FACE;
                case 6:
                    return FRIEND_NEARBY_PERSONAL_NEARBY;
                case 7:
                    return FOLLOW_ATTENTION;
                case 8:
                    return FEED_NEARBY;
                case 9:
                    return FEED_FIND_PHOTO;
                case 10:
                    return FEED_FIND_PLAZA;
                case 11:
                    return FEED_PERSONAL_TOPIC;
                case 12:
                    return FEED_NOT_SUPER_EXPOSURE;
                case 13:
                    return APPRECIATE_CALL_SHORT;
                case 14:
                    return APPRECIATE_CALL_TOTAL;
                case 15:
                    return APPRECIATE_NEARBY;
                case 16:
                    return APPRECIATE_FIND;
                case 17:
                    return APPRECIATE_SUPER_EXPOSURE;
                case 18:
                    return LIVE;
                case 19:
                    return MINE_FOLLOW;
                case 20:
                    return MINE_FAN;
                case 21:
                    return MAP_FIND;
                case 22:
                    return APPRECIATE_CALL_COMPLEX;
                case 23:
                    return APPRECIATE_CALL_ONLINE;
                case 24:
                    return SHADOW_SOURCE;
                case 25:
                    return MINE_FRIEND;
                case 26:
                    return COMPLEX_SORT;
                case 27:
                    return ONLINE_TIME_SORT;
                case 28:
                    return DISTANCE_SORT;
                case 29:
                    return NEARBY_FEATURED;
                case 30:
                    return FEED_COMMENT;
                case 31:
                    return NEW_FACE;
                case 32:
                    return SUPER_TOPIC_DETAIL;
                case 33:
                    return FIND_PLAZA_RECOMMEND_USER;
                case 34:
                    return FIND_PLAZA_RECOMMEND;
                case 35:
                    return FIND_PLAZA_FOLLOW;
                case 36:
                    return FIND_PLAZA_NEARBY;
                case 37:
                    return FIND_PLAZA_IMAGE;
                case 38:
                    return FIND_PLAZA_FLASH;
                case 39:
                    return FIND_PLAZA_FLASH_DETAIL;
                case 40:
                    return FEED_DETAIL;
                case 41:
                    return PAGE_FEED_MINE;
                case 42:
                    return PAGE_FEED_LIKE;
                case 43:
                    return PAGE_FEED_DETAIL_MORE;
                case 44:
                    return CIRCLE_NOTE_DETAIL;
                case 45:
                    return CIRCLE_DETAIL_NOTE_NEW;
                case 46:
                    return CIRCLE_DETAIL_NOTE_HOT;
                case 47:
                    return CIRCLE_USERS;
                case 48:
                    return ONE_CITY;
                case 49:
                    return GROUP_CHAT;
                case 50:
                    return CHAT_ROOM;
                case 51:
                    return NOTICE_FOLLOW_ME;
                case 52:
                    return CITY_TIME;
                case 53:
                    return FEED_IMAGE_FULL_SCREEN;
                case 54:
                    return PERSONAL_VIDEO_FULL_SCREEN;
                case 55:
                    return MSG_TOP_TITLE;
                case 56:
                    return MSG_PHOTO;
                case 57:
                    return MSG_SETTING_PHOTO;
                case 58:
                    return NOTICE_LIKE;
                case 59:
                    return LITE_RECOMMEND;
                case 60:
                    return HOT_BUBBLE;
                case 61:
                    return CITY_ALL_HI;
                case 62:
                    return CITY_TIME_HI;
                case 63:
                    return CITY_ALL_IMAGE;
                case 64:
                    return CITY_ALL_VIDEO;
                case 65:
                    return CITY_ALL_DETAIL;
                case 66:
                    return RECOMMEND_IMAGE;
                case 67:
                    return RECOMMEND_VIDEO;
                case 68:
                    return RECOMMEND_DETAIL;
                case 69:
                    return CITY_NOTE;
                case 70:
                    return CITY_TIME_NOTE;
                case 71:
                    return MAP_FRIEND_USER;
                case 72:
                    return NEARBY_OPERATION;
                case 73:
                    return SAME_USER;
                case 74:
                    return PUSH_CALL;
                case 75:
                    return TOPIC_RECOMMEND;
                case 76:
                    return TOPIC_NEW;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return MessageProtos.getDescriptor().getEnumTypes().get(2);
        }

        public static Internal.EnumLiteMap<StrangerSource> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static StrangerSource valueOf(int i) {
            return forNumber(i);
        }

        public static StrangerSource valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/message/MessageProtos$WarnTime.class */
    public enum WarnTime implements ProtocolMessageEnum {
        UNKNOWN_WARN_TIME(0),
        UNREAD_FIRST(1),
        CHAT_FIRST(2),
        LIVE_FIRST(3),
        TOAST_MSG(4),
        TOAST_LIVE(5),
        UNRECOGNIZED(-1);
        
        public static final int CHAT_FIRST_VALUE = 2;
        public static final int LIVE_FIRST_VALUE = 3;
        public static final int TOAST_LIVE_VALUE = 5;
        public static final int TOAST_MSG_VALUE = 4;
        public static final int UNKNOWN_WARN_TIME_VALUE = 0;
        public static final int UNREAD_FIRST_VALUE = 1;
        private final int value;
        private static final Internal.EnumLiteMap<WarnTime> internalValueMap = new Internal.EnumLiteMap<WarnTime>() { // from class: com.blued.das.message.MessageProtos.WarnTime.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public WarnTime findValueByNumber(int i) {
                return WarnTime.forNumber(i);
            }
        };
        private static final WarnTime[] VALUES = values();

        WarnTime(int i) {
            this.value = i;
        }

        public static WarnTime forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    return null;
                                }
                                return TOAST_LIVE;
                            }
                            return TOAST_MSG;
                        }
                        return LIVE_FIRST;
                    }
                    return CHAT_FIRST;
                }
                return UNREAD_FIRST;
            }
            return UNKNOWN_WARN_TIME;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return MessageProtos.getDescriptor().getEnumTypes().get(6);
        }

        public static Internal.EnumLiteMap<WarnTime> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static WarnTime valueOf(int i) {
            return forNumber(i);
        }

        public static WarnTime valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/message/MessageProtos$WarnType.class */
    public enum WarnType implements ProtocolMessageEnum {
        UNKNOWN_WARN_TYPE(0),
        TOAST_PUSH(1),
        POP_PUSH(2),
        TOAST_PUSH_PERMANENT(3),
        UNRECOGNIZED(-1);
        
        public static final int POP_PUSH_VALUE = 2;
        public static final int TOAST_PUSH_PERMANENT_VALUE = 3;
        public static final int TOAST_PUSH_VALUE = 1;
        public static final int UNKNOWN_WARN_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<WarnType> internalValueMap = new Internal.EnumLiteMap<WarnType>() { // from class: com.blued.das.message.MessageProtos.WarnType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public WarnType findValueByNumber(int i) {
                return WarnType.forNumber(i);
            }
        };
        private static final WarnType[] VALUES = values();

        WarnType(int i) {
            this.value = i;
        }

        public static WarnType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return TOAST_PUSH_PERMANENT;
                    }
                    return POP_PUSH;
                }
                return TOAST_PUSH;
            }
            return UNKNOWN_WARN_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return MessageProtos.getDescriptor().getEnumTypes().get(5);
        }

        public static Internal.EnumLiteMap<WarnType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static WarnType valueOf(int i) {
            return forNumber(i);
        }

        public static WarnType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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
        internal_static_com_blued_das_message_MessageProto_descriptor = descriptor2;
        internal_static_com_blued_das_message_MessageProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Event", "MsgScreenClickType", "TargetUid", "PhotoSource", "PhotoType", "StrangerSource", "PhotoNum", "DisturbSource", "DisturbRange", "IsOpen", "WarnType", "IsMapFind", "WarnTime", "IsAppreciateCall", "IsQuietCall", "IsSuperExposure", "IsShadow", "ShowType", "ImageId", "IsValid", "CallFilter", "SortType", "Url", "Position", "Id", "Keyword", "LiveId", "Destination", "Type", "IsAi", TXCopyrightedMedia.EXT_INFO_ROOM_ID, "RoomUid", "IsBuy", "MsgId", "Reason", "Name", "IsSpecial", "Mode", "Strategy", "Virtual", "IsNew", "CallType", "IsSuperCall", "LogoId", "StartTime", "EndTime", "Duration", "Status", "Rate", "Distance"});
    }

    private MessageProtos() {
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
