package com.blued.das.client.chatroom;

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
import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/chatroom/ChatRoomProtos.class */
public final class ChatRoomProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014ChatRoomProtos.proto\u0012\u001dcom.blued.das.client.chatroom\"À\u0006\n\rChatRoomProto\u00123\n\u0005event\u0018\u0001 \u0001(\u000e2$.com.blued.das.client.chatroom.Event\u0012\u000f\n\u0007room_id\u0018\u0002 \u0001(\t\u0012\u0011\n\troom_name\u0018\u0003 \u0001(\t\u0012\u0010\n\broom_uid\u0018\u0004 \u0001(\t\u0012\u0011\n\troom_type\u0018\u0005 \u0001(\t\u0012\u000e\n\u0006source\u0018\u0006 \u0001(\t\u0012\u000e\n\u0006tab_id\u0018\u0007 \u0001(\t\u0012:\n\tuser_type\u0018\b \u0001(\u000e2'.com.blued.das.client.chatroom.UserType\u0012\u0011\n\tbanner_id\u0018\t \u0001(\t\u0012\u0012\n\ntarget_uid\u0018\n \u0001(\t\u0012\u0011\n\tis_follow\u0018\u000b \u0001(\b\u0012\u000e\n\u0006sku_id\u0018\f \u0001(\t\u0012B\n\rshare_channel\u0018\r \u0001(\u000e2+.com.blued.das.client.chatroom.ShareChannel\u0012:\n\twarn_type\u0018\u000e \u0001(\u000e2'.com.blued.das.client.chatroom.WarnType\u0012\u000b\n\u0003num\u0018\u000f \u0001(\u0005\u0012\u0010\n\bgoods_id\u0018\u0010 \u0001(\t\u0012\r\n\u0005count\u0018\u0011 \u0001(\u0005\u0012\u000f\n\u0007content\u0018\u0012 \u0001(\t\u0012\n\n\u0002id\u0018\u0013 \u0001(\t\u00121\n\u0004from\u0018\u0014 \u0001(\u000e2#.com.blued.das.client.chatroom.From\u0012\u0010\n\bposition\u0018\u0015 \u0001(\u0005\u0012\u000f\n\u0007tab_num\u0018\u0016 \u0001(\u0005\u0012\u0010\n\bpage_num\u0018\u0017 \u0001(\u0005\u0012\u0010\n\bmusic_id\u0018\u0018 \u0001(\t\u0012\u0010\n\bduration\u0018\u0019 \u0001(\u0005\u0012\r\n\u0005range\u0018\u001a \u0001(\t\u0012\u000b\n\u0003url\u0018\u001b \u0001(\t\u0012\f\n\u0004page\u0018\u001c \u0001(\t\u0012\u000f\n\u0007is_true\u0018\u001d \u0001(\b\u0012\f\n\u0004type\u0018\u001e \u0001(\t\u0012\u0010\n\blocation\u0018\u001f \u0001(\u0005\u0012\r\n\u0005label\u0018  \u0001(\t\u0012\r\n\u0005theme\u0018! \u0001(\t\u0012\f\n\u0004name\u0018\" \u0001(\t\u0012\r\n\u0005level\u0018# \u0001(\t\u0012\r\n\u0005beans\u0018$ \u0001(\u0005\u0012\u000f\n\u0007is_open\u0018% \u0001(\b*ßr\n\u0005Event\u0012\u0011\n\rUNKNOWN_EVENT\u0010��\u0012 \n\u001cCHAT_ROOM_PROFILE_ENTER_SHOW\u0010\u0001\u0012!\n\u001dCHAT_ROOM_PROFILE_ENTER_CLICK\u0010\u0002\u0012\u001e\n\u001aCHAT_ROOM_MINE_REPORT_SHOW\u0010\u0003\u0012\u001f\n\u001bCHAT_ROOM_MINE_REPORT_CLICK\u0010\u0004\u0012\u001d\n\u0019CHAT_ROOM_MINE_ENTER_SHOW\u0010\u0005\u0012\u0019\n\u0015CHAT_ROOM_ENTER_CLICK\u0010\u0006\u0012 \n\u001cCHAT_ROOM_HOME_PAGE_TAB_SHOW\u0010\u0007\u0012 \n\u001cCHAT_ROOM_TAB_PAGE_ROOM_DRAW\u0010\b\u0012!\n\u001dCHAT_ROOM_TAB_PAGE_ROOM_CLICK\u0010\t\u0012\u0019\n\u0015CHAT_ROOM_CREATE_SHOW\u0010\n\u0012\u001a\n\u0016CHAT_ROOM_CREATE_CLICK\u0010\u000b\u0012\"\n\u001eCHAT_ROOM_CREATE_CONFIRM_CLICK\u0010\f\u0012 \n\u001cCHAT_ROOM_NAME_INVALITE_SHOW\u0010\r\u0012 \n\u001cCHAT_ROOM_APPROVE_GUIDE_SHOW\u0010\u001a\u0012!\n\u001dCHAT_ROOM_APPROVE_GUIDE_CLICK\u0010\u001b\u0012\u0019\n\u0015CHAT_ROOM_BANNER_SHOW\u0010\u001c\u0012\u001a\n\u0016CHAT_ROOM_BANNER_CLICK\u0010\u001d\u0012\u001a\n\u0016CHAT_ROOM_INVITE_CLICK\u0010\u001e\u0012\u001c\n\u0018CHAT_ROOM_KICK_OUT_CLICK\u0010\u001f\u0012$\n CHAT_ROOM_KICK_OUT_CONFIRM_CLICK\u0010 \u0012\u0018\n\u0014CHAT_ROOM_MUTE_CLICK\u0010!\u0012\u001d\n\u0019CHAT_ROOM_INVITE_POP_SHOW\u0010\"\u0012\u001a\n\u0016CHAT_ROOM_REFUSE_CLICK\u0010#\u0012\u001a\n\u0016CHAT_ROOM_ACCEPT_CLICK\u0010$\u0012\u0016\n\u0012CHAT_ROOM_OUT_MIKE\u0010%\u0012\u001f\n\u001bCHAT_ROOM_SET_MANAGER_CLICK\u0010&\u0012\u001e\n\u001aCHAT_ROOM_MANAGER_MAX_SHOW\u0010'\u0012\u001c\n\u0018CHAT_ROOM_EXIT_BTN_CLICK\u0010(\u0012\u001f\n\u001bCHAT_ROOM_REPORT_ROOM_CLICK\u0010)\u0012\u001a\n\u0016CHAT_ROOM_FOLLOW_CLICK\u0010*\u0012\u0016\n\u0012CHAT_ROOM_UNFOLLOW\u0010,\u0012\u001f\n\u001bCHAT_ROOM_FOLLOW_GUIDE_SHOW\u0010-\u0012'\n#CHAT_ROOM_FOLLOW_GUIDE_FOLLOW_CLICK\u0010.\u0012\u001c\n\u0018CHAT_ROOM_SEND_GIFT_SHOW\u0010/\u0012\u001d\n\u0019CHAT_ROOM_SEND_GIFT_CLICK\u00100\u0012\u001c\n\u0018CHAT_ROOM_RECHARGE_CLICK\u00101\u0012\u0019\n\u0015CHAT_ROOM_SHARE_CLICK\u00103\u0012!\n\u001dCHAT_ROOM_SHARE_CHANNEL_CLICK\u00104\u0012\u0018\n\u0014CHAT_ROOM_MIKE_CLICK\u00105\u0012 \n\u001cCHAT_ROOM_PROFILE_MIKE_CLICK\u00106\u0012 \n\u001cCHAT_ROOM_MIKE_CONFIRM_CLICK\u00107\u0012\u001f\n\u001bCHAT_ROOM_MIKE_SUCCESS_SHOW\u00108\u0012\u001e\n\u001aCHAT_ROOM_MIKE_REFUSE_SHOW\u00109\u0012\u001b\n\u0017CHAT_ROOM_MIKE_POP_SHOW\u0010:\u0012#\n\u001fCHAT_ROOM_MIKE_POP_REFUSE_CLICK\u0010;\u0012#\n\u001fCHAT_ROOM_MIKE_POP_ACCEPT_CLICK\u0010<\u0012#\n\u001fCHAT_ROOM_MIKE_POP_AUTO_SUCCESS\u0010=\u0012$\n CHAT_ROOM_MIKE_USER_REFUSE_CLICK\u0010>\u0012$\n CHAT_ROOM_MIKE_USER_ACCEPT_CLICK\u0010?\u0012\u001c\n\u0018CHAT_ROOM_SEND_MSG_CLICK\u0010@\u0012\u001e\n\u001aCHAT_ROOM_PROFILE_GO_CLICK\u0010A\u0012'\n#CHAT_ROOM_USER_PROFILE_FOLLOW_CLICK\u0010B\u0012\u001e\n\u001aCHAT_ROOM_PROFILE_AT_CLICK\u0010C\u0012\u001f\n\u001bCHAT_ROOM_PROFILE_MSG_CLICK\u0010D\u0012 \n\u001cCHAT_ROOM_PROFILE_GIFT_CLICK\u0010E\u0012\"\n\u001eCHAT_ROOM_PROFILE_REPORT_CLICK\u0010F\u0012!\n\u001dCHAT_ROOM_PROFILE_BLACK_CLICK\u0010G\u0012\u0018\n\u0014CHAT_ROOM_LIST_CLICK\u0010H\u0012 \n\u001cCHAT_ROOM_LIST_PAGE_GET_SHOW\u0010I\u0012!\n\u001dCHAT_ROOM_LIST_PAGE_SEND_SHOW\u0010J\u0012\u001b\n\u0017CHAT_ROOM_WARN_POP_SHOW\u0010K\u0012&\n\"CHAT_ROOM_USER_OUT_MIKE_TOAST_SHOW\u0010L\u0012'\n#CHAT_ROOM_OWNER_OUT_MIKE_TOAST_SHOW\u0010M\u0012\u0018\n\u0014CHAT_ROOM_LIKE_CLICK\u0010P\u0012\u0018\n\u0014CHAT_ROOM_GIFT_CLICK\u0010Q\u0012\u001b\n\u0017CHAT_ROOM_GIFT_POP_SHOW\u0010T\u0012!\n\u001dCHAT_ROOM_GIFT_POP_SEND_CLICK\u0010U\u0012\u0015\n\u0011NO_MONEY_POP_SHOW\u0010V\u0012\u001f\n\u001bNO_MONEY_POP_RECHARGE_CLICK\u0010W\u0012\u001f\n\u001bCHAT_ROOM_NAME_CHANGE_CLICK\u0010X\u0012\u001e\n\u001aCHAT_ROOM_PHONE_BIND_CLICK\u0010Y\u0012!\n\u001dCHAT_ROOM_ENTER_APPROVE_CLICK\u0010Z\u0012\u001a\n\u0016CHAT_ROOM_NOTICE_CLICK\u0010[\u0012\u001f\n\u001bCHAT_ROOM_NOTICE_SAVE_CLICK\u0010\\\u0012!\n\u001dCHAT_ROOM_NOTICE_CANCEL_CLICK\u0010]\u0012\u001b\n\u0017CHAT_ROOM_TOOLBOX_CLICK\u0010^\u0012!\n\u001dCHAT_ROOM_TOOLBOX_EMOJI_CLICK\u0010_\u0012\"\n\u001eCHAT_ROOM_PROFILE_FORBID_CLICK\u0010`\u0012)\n%CHAT_ROOM_PROFILE_REMOVE_FORBID_CLICK\u0010a\u0012!\n\u001dCHAT_ROOM_PROFILE_BLOCK_CLICK\u0010c\u0012\u001f\n\u001bCHAT_ROOM_FOLLOW_MORE_CLICK\u0010d\u0012\u001e\n\u001aCHAT_ROOM_FOLLOW_ROOM_SHOW\u0010e\u0012\u001f\n\u001bCHAT_ROOM_FOLLOW_ROOM_CLICK\u0010f\u0012\u001f\n\u001bCHAT_ROOM_EMOJI_ENTER_CLICK\u0010g\u0012)\n%CHAT_ROOM_TOOLBOX_MUSIC_SOMEONE_CLICK\u0010j\u0012\u001f\n\u001bCHAT_ROOM_USER_INVITE_CLICK\u0010k\u0012\u001c\n\u0018CHAT_ROOM_BG_ENTER_CLICK\u0010m\u0012\u001e\n\u001aCHAT_ROOM_BG_SOMEONE_CLICK\u0010n\u0012$\n CHAT_ROOM_GIFT_POP_ONE_GIFT_SHOW\u0010o\u0012%\n!CHAT_ROOM_GIFT_POP_ONE_GIFT_CLICK\u0010p\u0012&\n\"CHAT_ROOM_TOOLBOX_MUSIC_PLAY_CLICK\u0010q\u0012%\n!CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SHOW\u0010r\u0012-\n)CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SEARCH_CLICK\u0010s\u0012&\n\"CHAT_ROOM_TOOLBOX_MUSIC_LIKE_CLICK\u0010t\u0012'\n#CHAT_ROOM_TOOLBOX_MUSIC_PAUSE_CLICK\u0010u\u0012&\n\"CHAT_ROOM_TOOLBOX_MUSIC_EXIT_CLICK\u0010v\u0012&\n\"CHAT_ROOM_TOOLBOX_MUSIC_DONE_CLICK\u0010x\u0012$\n CHAT_ROOM_TOOLBOX_MUSIC_TAB_SHOW\u0010y\u0012$\n CHAT_ROOM_MINIMIZED_WINDOW_CLICK\u0010z\u0012\u001d\n\u0019CHAT_ROOM_VOTE_ICON_CLICK\u0010{\u0012\u001f\n\u001bCHAT_ROOM_VOTE_LAUNCH_CLICK\u0010|\u0012\u001f\n\u001bCHAT_ROOM_VOTE_WINDOW_CLICK\u0010}\u0012\u001d\n\u0019CHAT_ROOM_VOTE_USER_CLICK\u0010~\u0012\u0019\n\u0015CHAT_ROOM_INSTRUCTION\u0010\u007f\u0012\u001d\n\u0018CHAT_ROOM_CP_MATCH_START\u0010\u0080\u0001\u0012\u001f\n\u001aCHAT_ROOM_CP_MATCH_SUCCEED\u0010\u0081\u0001\u0012*\n%CHAT_ROOM_HOST_DISCIPLINE_CLOSE_CLICK\u0010\u0086\u0001\u0012\u001d\n\u0018CHAT_ROOM_MUTE_BTN_CLICK\u0010\u0087\u0001\u0012\u001f\n\u001aCHAT_ROOM_UNMUTE_BTN_CLICK\u0010\u0088\u0001\u0012#\n\u001eCHAT_ROOM_CHANGE_MIC_BTN_CLICK\u0010\u0089\u0001\u0012\u001e\n\u0019CHAT_ROOM_PHONE_BIND_SHOW\u0010\u008a\u0001\u0012'\n\"CHAT_ROOM_PHONE_BIND_CONFIRM_CLICK\u0010\u008b\u0001\u0012$\n\u001fCHAT_ROOM_SHARE_TO_FRIEND_CLICK\u0010\u008c\u0001\u0012#\n\u001eCHAT_END_PAGE_LIVING_USER_SHOW\u0010\u008d\u0001\u0012$\n\u001fCHAT_END_PAGE_LIVING_USER_CLICK\u0010\u008e\u0001\u0012#\n\u001eCHAT_ROOM_FOLLOW_ALL_PAGE_SHOW\u0010\u008f\u0001\u0012\u001b\n\u0016CHAT_ROOM_BANNER1_SHOW\u0010\u0090\u0001\u0012\u001c\n\u0017CHAT_ROOM_BANNER1_CLICK\u0010\u0091\u0001\u0012\u001b\n\u0016CHAT_ROOM_BANNER2_SHOW\u0010\u0092\u0001\u0012\u001c\n\u0017CHAT_ROOM_BANNER2_CLICK\u0010\u0093\u0001\u0012\"\n\u001dCHAT_ROOM_GIFT_GET_LIST_CLICK\u0010\u0094\u0001\u0012#\n\u001eCHAT_ROOM_GIFT_SEND_LIST_CLICK\u0010\u0095\u0001\u0012\u001b\n\u0016CHAT_ROOM_RANDOM_CLICK\u0010\u0096\u0001\u0012\u001d\n\u0018CHAT_ROOM_RANDOM_SUCCESS\u0010\u0097\u0001\u0012\u0017\n\u0012CHAT_ROOM_PK_CLICK\u0010\u0098\u0001\u0012\u0019\n\u0014CHAT_ROOM_VOTE_CLICK\u0010\u0099\u0001\u0012#\n\u001eCHAT_ROOM_GIFT_PAGE_GIFT_CLICK\u0010\u009a\u0001\u0012\"\n\u001dCHAT_ROOM_GIFT_PAGE_BAG_CLICK\u0010\u009b\u0001\u0012\u001d\n\u0018CHAT_ROOM_ACTIVITY_CLICK\u0010\u009c\u0001\u0012\u001c\n\u0017CHAT_ROOM_CAROUSEL_SHOW\u0010\u009d\u0001\u0012%\n CHAT_ROOM_OWNER_GIFT_GUIDE_CLICK\u0010\u009e\u0001\u0012$\n\u001fCHAT_ROOM_OWNER_DOWN_GIFT_CLICK\u0010\u009f\u0001\u0012&\n!CHAT_ROOM_OWNER_GIFT_CREATE_CLICK\u0010 \u0001\u0012\u001e\n\u0019CHAT_ROOM_USER_GIFT_CLICK\u0010¡\u0001\u0012#\n\u001eCHAT_ROOM_USER_GIFT_SEND_CLICK\u0010¢\u0001\u0012\u001f\n\u001aCHAT_ROOM_GAME_START_CLICK\u0010£\u0001\u0012\u001d\n\u0018CHAT_ROOM_GAME_ROB_CLICK\u0010¤\u0001\u0012\u001d\n\u0018CHAT_ROOM_GAME_ADD_CLICK\u0010¥\u0001\u0012 \n\u001bCHAT_ROOM_GAME_DELETE_CLICK\u0010¦\u0001\u0012\"\n\u001dCHAT_ROOM_GIFT_MORE_HIT_CLICK\u0010§\u0001\u0012\"\n\u001dCHAT_ROOM_AUCTION_APPLY_CLICK\u0010¨\u0001\u0012'\n\"CHAT_ROOM_AUCTION_APPLY_TRUE_CLICK\u0010©\u0001\u0012(\n#CHAT_ROOM_AUCTION_APPLY_FALSE_CLICK\u0010ª\u0001\u0012.\n)CHAT_ROOM_AUCTION_APPLY_LIST_CANCEL_CLICK\u0010«\u0001\u0012-\n(CHAT_ROOM_AUCTION_APPLY_LIST_AGREE_CLICK\u0010¬\u0001\u0012.\n)CHAT_ROOM_AUCTION_APPLY_LIST_REFUSE_CLICK\u0010\u00ad\u0001\u0012*\n%CHAT_ROOM_AUCTION_RELATION_TRUE_CLICK\u0010®\u0001\u0012*\n%CHAT_ROOM_GIFT_LEVEL_GUIDE_ICON_CLICK\u0010°\u0001\u0012!\n\u001cCHAT_ROOM_ANCHOR_LEVEL_CLICK\u0010±\u0001\u0012#\n\u001eCHAT_ROOM_HEART_BEAT_VIP_CLICK\u0010²\u0001\u0012%\n CHAT_ROOM_HEART_BEAT_VIP_SUCCESS\u0010³\u0001\u0012#\n\u001eSINGLE_ROOM_CREATE_VOICE_CLICK\u0010´\u0001\u0012 \n\u001bSINGLE_ROOM_FANS_UP_SUCCESS\u0010µ\u0001\u0012 \n\u001bSINGLE_ROOM_GIFT_SEND_CLICK\u0010¶\u0001\u0012!\n\u001cSINGLE_ROOM_ACCOMPANY_UNLOCK\u0010·\u0001\u0012\u001f\n\u001aSINGLE_ROOM_PAY_ICON_CLICK\u0010¸\u0001\u0012#\n\u001eSINGLE_ROOM_FIRST_PAY_POP_SHOW\u0010¹\u0001\u0012$\n\u001fSINGLE_ROOM_FIRST_PAY_POP_CLICK\u0010º\u0001\u0012!\n\u001cSINGLE_ROOM_PAY_SIX_POP_SHOW\u0010»\u0001\u0012\"\n\u001dSINGLE_ROOM_PAY_SIX_POP_CLICK\u0010¼\u0001\u0012/\n*SINGLE_ROOM_PAY_SIX_POP_NOW_RECHARGE_CLICK\u0010½\u0001\u0012\u001e\n\u0019CHAT_ROOM_USER_LIST_CLICK\u0010¾\u0001\u0012!\n\u001cCHAT_ROOM_OWNER_CUSTOM_CLICK\u0010¿\u0001\u0012\u0018\n\u0013CHAT_ROOM_EXIT_ROOM\u0010À\u0001\u0012\u001b\n\u0016PROFILE_GIFT_WALL_SHOW\u0010Á\u0001\u0012\u001c\n\u0017PROFILE_GIFT_WALL_CLICK\u0010Â\u0001\u0012,\n'PROFILE_GIFT_WALL_DETAIL_QUESTION_CLICK\u0010Ã\u0001\u0012-\n(PROFILE_GIFT_WALL_DETAIL_GIFT_SEND_CLICK\u0010Ä\u0001\u0012%\n CHAT_ROOM_TOOLBOX_ACTIVITY_CLICK\u0010Å\u0001\u0012!\n\u001cCHAT_ROOM_GIFT_ACTIVITY_SHOW\u0010Æ\u0001\u0012\"\n\u001dCHAT_ROOM_GIFT_ACTIVITY_CLICK\u0010Ç\u0001\u0012!\n\u001cCHAT_ROOM_TOOLBOX_PROP_CLICK\u0010È\u0001\u0012!\n\u001cCHAT_ROOM_NEW_GUIDE_POP_SHOW\u0010É\u0001\u0012(\n#CHAT_ROOM_NEW_GUIDE_POP_CLOSE_CLICK\u0010Ê\u0001\u0012$\n\u001fCHAT_ROOM_RECALL_GUIDE_POP_SHOW\u0010Ë\u0001\u0012+\n&CHAT_ROOM_RECALL_GUIDE_POP_CLOSE_CLICK\u0010Ì\u0001\u0012\u001e\n\u0019CHAT_ROOM_START_CHAT_SHOW\u0010Í\u0001\u0012'\n\"CHAT_ROOM_FOLLOW_ANCHOR_GUIDE_SHOW\u0010Î\u0001\u0012(\n#CHAT_ROOM_FOLLOW_ANCHOR_GUIDE_CLICK\u0010Ï\u0001\u0012#\n\u001eCHAT_ROOM_SEND_GIFT_GUIDE_SHOW\u0010Ð\u0001\u0012$\n\u001fCHAT_ROOM_SEND_GIFT_GUIDE_CLICK\u0010Ñ\u0001\u0012\u001d\n\u0018CHAT_ROOM_INTERACT_CLICK\u0010Ò\u0001\u0012\"\n\u001dCHAT_ROOM_BACK_INTERACT_CLICK\u0010Ó\u0001\u0012(\n#CHAT_ROOM_CREATE_UPLOAD_COVER_CLICK\u0010Ô\u0001\u0012%\n CHAT_ROOM_UPLOAD_COVER_YES_CLICK\u0010Õ\u0001\u0012\u001d\n\u0018CHAT_ROOM_OUT_GOODS_SHOW\u0010Ö\u0001\u0012\u001e\n\u0019CHAT_ROOM_OUT_GOODS_CLICK\u0010×\u0001\u0012'\n\"CHAT_ROOM_OUT_GOODS_POP_SEND_CLICK\u0010Ø\u0001\u0012)\n$CHAT_ROOM_OUT_GOODS_POP_CANCEL_CLICK\u0010Ù\u0001\u0012(\n#CHAT_ROOM_OUT_GOODS_NOT_ENOUGH_SHOW\u0010Ú\u0001\u0012\u001d\n\u0018CHAT_ROOM_HANG_WARN_SHOW\u0010Û\u0001\u0012%\n CHAT_ROOM_HANG_WARN_IGNORE_CLICK\u0010Ü\u0001\u0012$\n\u001fCHAT_ROOM_HANG_WARN_CLOSE_CLICK\u0010Ý\u0001\u0012\u001b\n\u0016CHAT_ROOM_BOX_PK_CLICK\u0010Þ\u0001\u0012%\n CHAT_ROOM_PK_CREATE_PK_PAGE_SHOW\u0010ß\u0001\u0012(\n#CHAT_ROOM_PK_CREATE_LEVEL_PAGE_SHOW\u0010à\u0001\u0012$\n\u001fCHAT_ROOM_PK_CREATE_MATCH_CLICK\u0010á\u0001\u0012%\n CHAT_ROOM_PK_CREATE_INVITE_CLICK\u0010â\u0001\u0012*\n%CHAT_ROOM_PK_CREATE_USER_INVITE_CLICK\u0010ã\u0001\u0012$\n\u001fCHAT_ROOM_PK_MATCH_SUCCESS_SHOW\u0010ä\u0001\u0012%\n CHAT_ROOM_PK_INVITE_SUCCESS_SHOW\u0010å\u0001\u0012%\n CHAT_ROOM_RECOMMEND_SECOND_CLICK\u0010æ\u0001\u0012\"\n\u001dCHAT_ROOM_GIFT_RESOURCE_CLICK\u0010ç\u0001\u0012!\n\u001cCHAT_ROOM_GIFT_RECEIVE_CLICK\u0010è\u0001\u0012%\n CHAT_ROOM_GIFT_POP_RECEIVE_CLICK\u0010é\u0001\u0012#\n\u001eCHAT_ROOM_HALL_REDBAG_POP_SHOW\u0010ê\u0001\u0012$\n\u001fCHAT_ROOM_HALL_REDBAG_POP_CLICK\u0010ë\u0001\u0012(\n#CHAT_ROOM_REDBAG_PAGE_RECEIVE_CLICK\u0010ì\u0001\u0012 \n\u001bCHAT_ROOM_KTV_SONG_TAB_SHOW\u0010í\u0001\u0012#\n\u001eCHAT_ROOM_KTV_SONG_QUEUE_CLICK\u0010î\u0001\u0012\u001e\n\u0019CHAT_ROOM_KTV_SONG_SEARCH\u0010ï\u0001\u0012%\n CHAT_ROOM_KTV_SONG_GIVE_UP_CLICK\u0010ð\u0001\u0012+\n&CHAT_ROOM_KTV_SONG_ACCOMPANIMENT_CLICK\u0010ñ\u0001\u0012\"\n\u001dCHAT_ROOM_KTV_SONG_SING_CLICK\u0010ò\u0001\u0012\"\n\u001dCHAT_ROOM_KTV_SONG_TONE_CLICK\u0010ó\u0001\u0012%\n CHAT_ROOM_KTV_SONG_TURN_POP_SHOW\u0010ô\u0001\u0012)\n$CHAT_ROOM_KTV_TURN_POP_GIVE_UP_CLICK\u0010õ\u0001\u0012+\n&CHAT_ROOM_KTV_TURN_POP_GIVE_UP_TIMEOUT\u0010ö\u0001\u0012'\n\"CHAT_ROOM_KTV_TURN_POP_START_CLICK\u0010÷\u0001\u0012\u001c\n\u0017CHAT_ROOM_KTV_SONG_PLAY\u0010ø\u0001\u0012\u001e\n\u0019CHAT_ROOM_TASK_ICON_CLICK\u0010ù\u0001\u0012 \n\u001bCHAT_ROOM_TASK_REWARD_CLICK\u0010ú\u0001\u0012\u001f\n\u001aCHAT_ROOM_FANS_ENTER_CLICK\u0010û\u0001\u0012\u001e\n\u0019CHAT_ROOM_FANS_PANEL_SHOW\u0010ü\u0001\u0012$\n\u001fCHAT_ROOM_FANS_PANEL_JOIN_CLICK\u0010ý\u0001\u0012$\n\u001fCHAT_ROOM_GIFT_PANEL_JOIN_CLICK\u0010þ\u0001\u0012\u001d\n\u0018CHAT_ROOM_GUIDE_POP_SHOW\u0010ÿ\u0001\u0012#\n\u001eCHAT_ROOM_GUIDE_POP_JOIN_CLICK\u0010\u0080\u0002\u0012\u001f\n\u001aCHAT_ROOM_FOLLOW_OPEN_SHOW\u0010\u0081\u0002\u0012&\n!CHAT_ROOM_KTV_GUIDE_SONG_POP_SHOW\u0010\u0082\u0002\u0012*\n%CHAT_ROOM_KTV_GUIDE_SONG_POP_GO_CLICK\u0010\u0083\u0002\u0012.\n)CHAT_ROOM_KTV_GUIDE_SONG_POP_IGNORE_CLICK\u0010\u0084\u0002\u0012!\n\u001cCHAT_ROOM_KTV_GUIDE_MSG_SHOW\u0010\u0085\u0002\u0012%\n CHAT_ROOM_KTV_GUIDE_MSG_GO_CLICK\u0010\u0086\u0002\u0012%\n CHAT_ROOM_KTV_NO_MIKE_SONG_CLICK\u0010\u0087\u0002\u0012)\n$CHAT_ROOM_KTV_NO_MIKE_GUIDE_POP_SHOW\u0010\u0088\u0002\u0012-\n(CHAT_ROOM_KTV_NO_MIKE_GUIDE_POP_GO_CLICK\u0010\u0089\u0002\u00121\n,CHAT_ROOM_KTV_NO_MIKE_GUIDE_POP_IGNORE_CLICK\u0010\u008a\u0002\u0012 \n\u001bCHAT_ROOM_NEW_GIFT_POP_SHOW\u0010\u008b\u0002\u0012%\n CHAT_ROOM_NEW_GIFT_POP_GET_CLICK\u0010\u008c\u0002\u0012#\n\u001eCHAT_ROOM_NEW_GIFT_GET_SUCCESS\u0010\u008d\u0002\u0012\"\n\u001dCHAT_ROOM_NEW_GIFT_PROP_CLICK\u0010\u008e\u0002\u0012%\n CHAT_ROOM_PROFILE_RELATION_CLICK\u0010\u008f\u0002\u0012(\n#CHAT_ROOM_PROFILE_HONOR_LEVEL_CLICK\u0010\u0090\u0002\u0012!\n\u001cCHAT_ROOM_PROFILE_CLUB_CLICK\u0010\u0091\u0002\u0012\"\n\u001dCHAT_ROOM_PROFILE_MEDAL_CLICK\u0010\u0092\u0002\u0012&\n!CHAT_ROOM_PROFILE_MEDAL_ONE_CLICK\u0010\u0093\u0002\u0012#\n\u001eCHAT_ROOM_HALL_HEAD_ICON_CLICK\u0010\u0094\u0002\u0012\u001d\n\u0018CHAT_ROOM_HALL_BTN_CLICK\u0010\u0095\u0002\u0012\u001d\n\u0018CHAT_ROOM_BOX_RAIN_CLICK\u0010\u0096\u0002\u0012&\n!CHAT_ROOM_BOX_RAIN_QUESTION_CLICK\u0010\u0097\u0002\u0012\u001c\n\u0017CHAT_ROOM_BOX_RAIN_FALL\u0010\u0098\u0002\u0012&\n!CHAT_ROOM_ANCHOR_LEVEL_ENTER_SHOW\u0010\u0099\u0002\u0012'\n\"CHAT_ROOM_ANCHOR_LEVEL_ENTER_CLICK\u0010\u009a\u0002\u0012\u001f\n\u001aCHAT_ROOM_COOL_STAGE_CLICK\u0010\u009b\u0002\u0012+\n&CHAT_ROOM_COOL_STAGE_SING_END_POP_SHOW\u0010\u009e\u0002\u0012%\n CHAT_ROOM_BG_MUSIC_ENTRANCE_SHOW\u0010¡\u0002\u0012&\n!CHAT_ROOM_BG_MUSIC_ENTRANCE_CLICK\u0010¢\u0002\u0012&\n!CHAT_ROOM_BG_MUSIC_ONE_PLAY_CLICK\u0010£\u0002\u0012!\n\u001cCHAT_ROOM_GIFT_POP_ALL_CLICK\u0010¤\u0002\u0012\u001f\n\u001aCHAT_ROOM_WISH_RESET_CLICK\u0010¥\u0002\u0012\"\n\u001dCHAT_ROOM_WISH_RESET_NO_CLICK\u0010¦\u0002\u0012#\n\u001eCHAT_ROOM_WISH_RESET_YES_CLICK\u0010§\u0002\u0012!\n\u001cCHAT_ROOM_BOSS_SEAT_POP_SHOW\u0010¨\u0002\u0012,\n'CHAT_ROOM_BOSS_SEAT_POP_GIFT_SEND_CLICK\u0010©\u0002\u0012\u001b\n\u0016YY_GIFT_WALL_PAGE_SHOW\u0010ª\u0002\u0012#\n\u001eYY_GIFT_WALL_PAGE_UNLOCK_CLICK\u0010«\u0002\u0012#\n\u001eYY_GIFT_WALL_PAGE_REWARD_CLICK\u0010¬\u0002\u0012$\n\u001fYY_GIFT_WALL_PAGE_GIFT_POP_SHOW\u0010\u00ad\u0002\u0012*\n%YY_GIFT_WALL_PAGE_GIFT_POP_SEND_CLICK\u0010®\u0002\u0012&\n!YY_GIFT_WALL_PAGE_REWARD_POP_SHOW\u0010¯\u0002\u0012\u001b\n\u0016YY_DOWN_EXCHANGE_CLICK\u0010°\u0002\u0012\"\n\u001dYY_EXCHANGE_PAGE_TWELVE_CLICK\u0010±\u0002\u0012\u001c\n\u0017YY_TWELVE_POP_NOW_CLICK\u0010²\u0002\u0012!\n\u001cCHAT_ROOM_KTV_SONG_LIST_SHOW\u0010³\u0002\u0012&\n!CHAT_ROOM_KTV_SONG_LIST_TOP_CLICK\u0010´\u0002\u0012'\n\"CHAT_ROOM_KTV_SONG_LIST_SING_CLICK\u0010µ\u0002\u0012\u001e\n\u0019CHAT_ROOM_FANS_EDIT_CLICK\u0010¶\u0002\u0012%\n CHAT_ROOM_FANS_EDIT_SUBMIT_CLICK\u0010·\u0002\u0012\u001a\n\u0015YY_SETTINGS_PAGE_SHOW\u0010¸\u0002\u0012'\n\"ANCHOR_REPORT_FORM_PAGE_MORE_CLICK\u0010¹\u0002\u0012*\n%ANCHOR_REPORT_FORM_PAGE_MORE_YY_CLICK\u0010º\u0002\u0012\u0013\n\u000eYY_TOPIC_CLICK\u0010»\u0002\u0012!\n\u001cYY_TOPIC_SETTINGS_DONE_CLICK\u0010¼\u0002\u0012\u0019\n\u0014YY_PK_ENTRANCE_CLICK\u0010½\u0002\u0012\u001a\n\u0015YY_BOX_ENTRANCE_CLICK\u0010¾\u0002\u0012\u0010\n\u000bYY_BOX_SHOW\u0010¿\u0002\u0012\u0017\n\u0012YY_PK_RANDOM_CLICK\u0010À\u0002\u0012\u0017\n\u0012YY_PK_INVITE_CLICK\u0010Á\u0002\u0012\u0017\n\u0012YY_PK_CANCEL_CLICK\u0010Â\u0002\u0012\u001a\n\u0015YY_PK_CONNECT_SUCCESS\u0010Ã\u0002\u0012\u0017\n\u0012YY_PK_CONNECT_FAIL\u0010Ä\u0002\u0012\u001a\n\u0015YY_PK_INVITE_POP_SHOW\u0010Å\u0002\u0012\"\n\u001dYY_PK_INVITE_POP_REJECT_CLICK\u0010Æ\u0002\u0012\u001e\n\u0019YY_PK_INVITE_POP_PK_CLICK\u0010Ç\u0002\u0012\u001e\n\u0019CHAT_ROOM_HOT_BANNER_SHOW\u0010È\u0002\u0012\u001f\n\u001aCHAT_ROOM_HOT_BANNER_CLICK\u0010É\u0002\u0012 \n\u001bCHAT_ROOM_HOT_RESOURCE_SHOW\u0010Ê\u0002\u0012!\n\u001cCHAT_ROOM_HOT_RESOURCE_CLICK\u0010Ë\u0002\u0012\u001f\n\u001aYY_HALL_TOP_FAST_ROOM_SHOW\u0010Ì\u0002\u0012 \n\u001bYY_HALL_TOP_FAST_ROOM_CLICK\u0010Í\u0002\u0012\u001b\n\u0016YY_HALL_TOP_PLAZA_SHOW\u0010Î\u0002\u0012\u001c\n\u0017YY_HALL_TOP_PLAZA_CLICK\u0010Ï\u0002\u0012\u001b\n\u0016YY_HALL_TOP_TOPIC_SHOW\u0010Ð\u0002\u0012\u001c\n\u0017YY_HALL_TOP_TOPIC_CLICK\u0010Ñ\u0002\u0012\u0019\n\u0014YY_HALL_TAB_ADD_SHOW\u0010Ò\u0002\u0012\u001a\n\u0015YY_HALL_TAB_ADD_CLICK\u0010Ó\u0002\u0012\u0018\n\u0013YY_HALL_CREATE_SHOW\u0010Ô\u0002\u0012\u0019\n\u0014YY_HALL_CREATE_CLICK\u0010Õ\u0002\u0012\u0018\n\u0013YY_HALL_RANDOM_SHOW\u0010Ö\u0002\u0012\u0019\n\u0014YY_HALL_RANDOM_CLICK\u0010×\u0002\u0012\u0010\n\u000bYY_RES_SHOW\u0010Ø\u0002\u0012\u0011\n\fYY_RES_CLICK\u0010Ù\u0002\u0012\u0016\n\u0011YY_BROADCAST_SHOW\u0010Ú\u0002\u0012\u0017\n\u0012YY_BROADCAST_CLICK\u0010Û\u0002\u0012\u0016\n\u0011YY_ROOM_STAR_SHOW\u0010Ü\u0002\u0012\u0017\n\u0012YY_ROOM_STAR_CLICK\u0010Ý\u0002\u0012\u001c\n\u0017YY_ROOM_BOX_REDBAG_SHOW\u0010Þ\u0002\u0012\u001d\n\u0018YY_ROOM_BOX_REDBAG_CLICK\u0010ß\u0002\u0012\u001d\n\u0018YY_ROOM_REDBAG_PAGE_SHOW\u0010à\u0002\u0012#\n\u001eYY_ROOM_REDBAG_PAGE_RULE_CLICK\u0010á\u0002\u0012#\n\u001eYY_ROOM_REDBAG_PAGE_SEND_CLICK\u0010â\u0002\u0012\u0018\n\u0013YY_HALL_REDBAG_SHOW\u0010ã\u0002\u0012\u0019\n\u0014YY_HALL_REDBAG_CLICK\u0010ä\u0002\u0012\u001d\n\u0018YY_REDBAG_PAGE_GET_CLICK\u0010å\u0002\u0012\u0018\n\u0013YY_ROOM_REDBAG_SHOW\u0010æ\u0002\u0012\u0019\n\u0014YY_ROOM_REDBAG_CLICK\u0010ç\u0002\u0012$\n\u001fYY_ROOM_REDBAG_FOLLOW_GET_CLICK\u0010è\u0002\u0012\u001d\n\u0018YY_ROOM_REDBAG_GET_CLICK\u0010é\u0002\u0012\u0017\n\u0012YY_HALL_RANK_CLICK\u0010ê\u0002\u0012\"\n\u001dYY_HALL_RANK_PAGE_GUILD_CLICK\u0010ë\u0002\u0012\u001c\n\u0017YY_ROB_SING_START_CLICK\u0010ì\u0002\u0012\u001a\n\u0015YY_ROB_SING_END_CLICK\u0010í\u0002\u0012\u001b\n\u0016YY_ROB_SING_SONG_CLICK\u0010î\u0002\u0012\u001d\n\u0018YY_ROB_SING_FOLLOW_CLICK\u0010ï\u0002\u0012\u001c\n\u0017YY_ROB_SING_LIGHT_CLICK\u0010ð\u0002\u0012\u001d\n\u0018YY_ROB_SING_FLOWER_CLICK\u0010ñ\u0002\u0012\"\n\u001dYY_ROB_SING_FLOWER_SEND_CLICK\u0010ò\u0002\u0012\u0017\n\u0012YY_DING_TOAST_SHOW\u0010ó\u0002\u0012\u0018\n\u0013YY_DING_TOAST_CLICK\u0010ô\u0002\u0012\u001b\n\u0016YY_FIRST_MEET_POP_SHOW\u0010õ\u0002\u0012\u001c\n\u0017YY_FIRST_MEET_POP_CLICK\u0010ö\u0002\u0012#\n\u001eYY_FIRST_MEET_SUCCESS_POP_SHOW\u0010÷\u0002\u0012,\n'YY_FIRST_MEET_SUCCESS_POP_GIFT_GO_CLICK\u0010ø\u0002\u0012-\n(YY_FIRST_MEET_SUCCESS_POP_MEDAL_GO_CLICK\u0010ù\u0002\u0012-\n(YY_FIRST_MEET_SUCCESS_POP_FRAME_GO_CLICK\u0010ú\u0002\u0012\u0016\n\u0011YY_VOICE_POP_SHOW\u0010û\u0002\u0012\u001a\n\u0015YY_VOICE_POP_NO_CLICK\u0010ü\u0002\u0012+\n&CHAT_ROOM_BOX_ANCHOR_GROWTH_PLAN_CLICK\u0010ý\u0002\u0012!\n\u001cCHAT_ROOM_BOX_MADE_CAR_CLICK\u0010þ\u0002\u0012$\n\u001fCHAT_ROOM_PROFILE_MADE_CAR_SHOW\u0010ÿ\u0002\u0012%\n CHAT_ROOM_PROFILE_MADE_CAR_CLICK\u0010\u0080\u0003\u0012\u001d\n\u0018YY_GIFT_MADE_CAR_GO_SHOW\u0010\u0081\u0003\u0012\u001e\n\u0019YY_GIFT_MADE_CAR_GO_CLICK\u0010\u0082\u0003\u0012#\n\u001eYY_MADE_CAR_PAGE_CAR_TAB_CLICK\u0010\u0083\u0003\u0012$\n\u001fYY_MADE_CAR_PAGE_HALL_TAB_CLICK\u0010\u0084\u0003\u0012 \n\u001bYY_MADE_CAR_PAGE_MORE_CLICK\u0010\u0085\u0003\u0012 \n\u001bYY_MADE_CAR_PAGE_RULE_CLICK\u0010\u0086\u0003\u0012\"\n\u001dYY_MADE_CAR_PAGE_RECORD_CLICK\u0010\u0087\u0003\u0012 \n\u001bYY_MADE_CAR_PAGE_SEND_CLICK\u0010\u0088\u0003\u0012\u0019\n\u0014YY_PROFILE_PAGE_SHOW\u0010\u0089\u0003\u0012$\n\u001fYY_PROFILE_PAGE_LIFT_MASK_CLICK\u0010\u008a\u0003\u0012\u001a\n\u0015YY_LIFT_MASK_POP_SHOW\u0010\u008b\u0003\u0012\"\n\u001dYY_LIFT_MASK_POP_CANCEL_CLICK\u0010\u008c\u0003\u0012\u001f\n\u001aYY_LIFT_MASK_POP_USE_CLICK\u0010\u008d\u0003\u0012\u001f\n\u001aYY_LIFT_MASK_USER_POP_SHOW\u0010\u008e\u0003\u0012$\n\u001fYY_LIFT_MASK_USER_POP_YES_CLICK\u0010\u008f\u0003\u0012!\n\u001cYY_LIFT_MASK_SECOND_POP_SHOW\u0010\u0090\u0003\u0012&\n!YY_LIFT_MASK_SECOND_POP_YES_CLICK\u0010\u0091\u0003\u0012%\n YY_LIFT_MASK_SECOND_POP_NO_CLICK\u0010\u0092\u0003\u0012\u0019\n\u0014YY_LIFT_MASK_SUCCESS\u0010\u0093\u0003\u0012\u001d\n\u0018YY_PROFILE_RELATION_SHOW\u0010\u0094\u0003\u0012\u001e\n\u0019YY_PROFILE_RELATION_CLICK\u0010\u0095\u0003\u0012&\n!YY_GIFT_WALL_EXHIBITION_PAGE_SHOW\u0010\u0096\u0003\u0012+\n&YY_GIFT_WALL_EXHIBITION_PAGE_ALL_CLICK\u0010\u0097\u0003\u0012,\n'YY_GIFT_WALL_EXHIBITION_PAGE_STAR_CLICK\u0010\u0098\u0003\u0012\u0019\n\u0014YY_BOX_RELATION_SHOW\u0010\u0099\u0003\u0012\u001a\n\u0015YY_BOX_RELATION_CLICK\u0010\u009a\u0003\u0012\u001e\n\u0019YY_RELATION_ROOM_QA_CLICK\u0010\u009b\u0003\u0012#\n\u001eYY_RELATION_ROOM_RANKING_CLICK\u0010\u009c\u0003\u0012%\n YY_RELATION_HIDE_REMOVE_POP_SHOW\u0010\u009d\u0003\u0012+\n&YY_RELATION_HIDE_REMOVE_POP_HIDE_CLICK\u0010\u009e\u0003\u0012-\n(YY_RELATION_HIDE_REMOVE_POP_REMOVE_CLICK\u0010\u009f\u0003\u0012\u001b\n\u0016YY_RELATION_MINE_CLICK\u0010 \u0003\u0012\u001a\n\u0015YY_RELATION_ALL_CLICK\u0010¡\u0003\u0012\"\n\u001dYY_RELATION_USER_INVITE_CLICK\u0010¢\u0003\u0012&\n!YY_RELATION_USER_INVITE_YES_CLICK\u0010£\u0003\u0012%\n YY_RELATION_USER_INVITE_POP_SHOW\u0010¤\u0003\u0012,\n'YY_RELATION_USER_INVITE_POP_AGREE_CLICK\u0010¥\u0003\u0012/\n*YY_RELATION_USER_INVITE_POP_DISAGREE_CLICK\u0010¦\u0003\u0012\u001f\n\u001aYY_RELATION_GUIDE_MSG_SHOW\u0010§\u0003\u0012 \n\u001bYY_RELATION_GUIDE_MSG_CLICK\u0010¨\u0003\u0012#\n\u001eCHAT_ROOM_BOX_CREATE_PRE_CLICK\u0010©\u0003\u0012\u0015\n\u0010YY_NEW_WEEK_SHOW\u0010ª\u0003\u0012\u0016\n\u0011YY_NEW_WEEK_CLICK\u0010«\u0003\u0012\u001c\n\u0017YY_SUPER_STAR_WEEK_SHOW\u0010¬\u0003\u0012\u001d\n\u0018YY_SUPER_STAR_WEEK_CLICK\u0010\u00ad\u0003\u0012\u001d\n\u0018YY_CREATE_PRE_DONE_CLICK\u0010®\u0003\u0012\u001b\n\u0016YY_CREATE_PRE_QA_CLICK\u0010¯\u0003\u0012\u0014\n\u000fYY_PRE_POP_SHOW\u0010°\u0003\u0012\u001c\n\u0017YY_PRE_POP_DETAIL_CLICK\u0010±\u0003\u0012\u001e\n\u0019YY_CELEBRATION_ENTER_SHOW\u0010²\u0003\u0012\u001f\n\u001aYY_CELEBRATION_ENTER_CLICK\u0010³\u0003\u0012\u001e\n\u0019YY_CELEBRATION_KNOW_CLICK\u0010´\u0003\u0012\"\n\u001dYY_CELEBRATION_PRE_FEED_CLICK\u0010µ\u0003\u0012)\n$YY_CELEBRATION_PRE_FEED_CANCEL_CLICK\u0010¶\u0003\u0012\u001a\n\u0015YY_ROMANTIC_PAGE_SHOW\u0010·\u0003\u0012#\n\u001eYY_ROMANTIC_HANDBOOK_PAGE_SHOW\u0010¸\u0003\u0012'\n\"YY_ROMANTIC_ALL_HANDBOOK_PAGE_SHOW\u0010¹\u0003\u0012\u001f\n\u001aYY_ROMANTIC_RULE_PAGE_SHOW\u0010º\u0003\u0012$\n\u001fYY_ROMANTIC_LIGHT_PAGE_GO_CLICK\u0010¼\u0003\u0012\u001a\n\u0015YY_LOVE_GIFT_BAR_SHOW\u0010½\u0003\u0012\u001b\n\u0016YY_LOVE_GIFT_PAGE_SHOW\u0010¾\u0003\u0012\u001f\n\u001aYY_LOVE_GIFT_PAGE_QA_CLICK\u0010¿\u0003\u0012%\n YY_LOVE_GIFT_PAGE_ONE_SEND_CLICK\u0010À\u0003\u0012\u001e\n\u0019YY_ROOM_BOX_SET_GIFT_SHOW\u0010Á\u0003\u0012\u001f\n\u001aYY_ROOM_BOX_SET_GIFT_CLICK\u0010Â\u0003\u0012\u001f\n\u001aYY_SHOW_LOVE_TOP_PAGE_SHOW\u0010Ã\u0003\u0012#\n\u001eYY_SHOW_LOVE_TOP_PAGE_TO_CLICK\u0010Ä\u0003\u0012#\n\u001eYY_TOP_SHOW_LOVE_PAGE_TO_CLICK\u0010Å\u0003\u0012)\n$YY_SHOW_LOVE_TOP_WEEK_TIME_PAGE_SHOW\u0010Æ\u0003\u0012*\n%YY_SHOW_LOVE_TOP_WEEK_SCORE_PAGE_SHOW\u0010Ç\u0003\u0012(\n#YY_SHOW_LOVE_TOP_ALL_TIME_PAGE_SHOW\u0010È\u0003\u0012)\n$YY_SHOW_LOVE_TOP_ALL_SCORE_PAGE_SHOW\u0010É\u0003*\u0098\u0001\n\bUserType\u0012\u0015\n\u0011UNKNOWN_USER_TYPE\u0010��\u0012\u000f\n\u000bCOMMON_USER\u0010\u0001\u0012\u0016\n\u0012APPLY_SUCCESS_USER\u0010\u0002\u0012\u0011\n\rAPPLYING_USER\u0010\u0003\u0012\n\n\u0006ANCHOR\u0010\u0004\u0012\r\n\tFANS_USER\u0010\u0005\u0012\f\n\bNOT_FANS\u0010\u0006\u0012\u0007\n\u0003NEW\u0010\u0007\u0012\u0007\n\u0003OLD\u0010\b*\u0096\u0001\n\fShareChannel\u0012\u0019\n\u0015UNKNOWN_SHARE_CHANNEL\u0010��\u0012\u0011\n\rSHARE_FORWARD\u0010\u0001\u0012\u0010\n\fSHARE_FRIEND\u0010\u0002\u0012\u0010\n\fSHARE_WECHAT\u0010\u0003\u0012\f\n\bSHARE_QQ\u0010\u0004\u0012\u000f\n\u000bSHARE_WEIBO\u0010\u0005\u0012\u0015\n\u0011SHARE_FRIEND_CLUB\u0010\u0006*Ò\u0001\n\bWarnType\u0012\u0015\n\u0011UNKNOWN_WARN_TYPE\u0010��\u0012\f\n\bADS_WARN\u0010\u0001\u0012\u0012\n\u000ePOLITICAL_WARN\u0010\u0002\u0012\r\n\tHINT_WARN\u0010\u0003\u0012\r\n\tDRUG_WARN\u0010\u0004\u0012\u000f\n\u000bSPEECH_WAR", "N\u0010\u0005\u0012\u0010\n\fPRIVACY_WARN\u0010\u0006\u0012\u0015\n\u0011INVALID_LIVE_WARN\u0010\u0007\u0012\u0012\n\u000eCUSTOMIZE_WARN\u0010\b\u0012\u0012\n\u000eCOPYRIGHT_WARN\u0010\t\u0012\r\n\tMUTE_WARN\u0010\n*\u009a\u0001\n\u0004From\u0012\u0010\n\fUNKNOWN_FROM\u0010��\u0012\u0014\n\u0010FOLLOW_ROOM_LIST\u0010\u0001\u0012 \n\u001cFOLLOW_ROOM_LIST_SECOND_PAGE\u0010\u0002\u0012\u0018\n\u0014GIFT_PANEL_FIRST_PAY\u0010\u0003\u0012\u0018\n\u0014GIFT_PANEL_FIRST_POP\u0010\u0004\u0012\u0014\n\u0010RECHARGE_RED_BTN\u0010\u0005B\u000b¢\u0002\bchatroomb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_blued_das_client_chatroom_ChatRoomProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_client_chatroom_ChatRoomProto_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/chatroom/ChatRoomProtos$ChatRoomProto.class */
    public static final class ChatRoomProto extends GeneratedMessageV3 implements ChatRoomProtoOrBuilder {
        public static final int BANNER_ID_FIELD_NUMBER = 9;
        public static final int BEANS_FIELD_NUMBER = 36;
        public static final int CONTENT_FIELD_NUMBER = 18;
        public static final int COUNT_FIELD_NUMBER = 17;
        public static final int DURATION_FIELD_NUMBER = 25;
        public static final int EVENT_FIELD_NUMBER = 1;
        public static final int FROM_FIELD_NUMBER = 20;
        public static final int GOODS_ID_FIELD_NUMBER = 16;
        public static final int ID_FIELD_NUMBER = 19;
        public static final int IS_FOLLOW_FIELD_NUMBER = 11;
        public static final int IS_OPEN_FIELD_NUMBER = 37;
        public static final int IS_TRUE_FIELD_NUMBER = 29;
        public static final int LABEL_FIELD_NUMBER = 32;
        public static final int LEVEL_FIELD_NUMBER = 35;
        public static final int LOCATION_FIELD_NUMBER = 31;
        public static final int MUSIC_ID_FIELD_NUMBER = 24;
        public static final int NAME_FIELD_NUMBER = 34;
        public static final int NUM_FIELD_NUMBER = 15;
        public static final int PAGE_FIELD_NUMBER = 28;
        public static final int PAGE_NUM_FIELD_NUMBER = 23;
        public static final int POSITION_FIELD_NUMBER = 21;
        public static final int RANGE_FIELD_NUMBER = 26;
        public static final int ROOM_ID_FIELD_NUMBER = 2;
        public static final int ROOM_NAME_FIELD_NUMBER = 3;
        public static final int ROOM_TYPE_FIELD_NUMBER = 5;
        public static final int ROOM_UID_FIELD_NUMBER = 4;
        public static final int SHARE_CHANNEL_FIELD_NUMBER = 13;
        public static final int SKU_ID_FIELD_NUMBER = 12;
        public static final int SOURCE_FIELD_NUMBER = 6;
        public static final int TAB_ID_FIELD_NUMBER = 7;
        public static final int TAB_NUM_FIELD_NUMBER = 22;
        public static final int TARGET_UID_FIELD_NUMBER = 10;
        public static final int THEME_FIELD_NUMBER = 33;
        public static final int TYPE_FIELD_NUMBER = 30;
        public static final int URL_FIELD_NUMBER = 27;
        public static final int USER_TYPE_FIELD_NUMBER = 8;
        public static final int WARN_TYPE_FIELD_NUMBER = 14;
        private static final long serialVersionUID = 0;
        private volatile Object bannerId_;
        private int beans_;
        private volatile Object content_;
        private int count_;
        private int duration_;
        private int event_;
        private int from_;
        private volatile Object goodsId_;
        private volatile Object id_;
        private boolean isFollow_;
        private boolean isOpen_;
        private boolean isTrue_;
        private volatile Object label_;
        private volatile Object level_;
        private int location_;
        private byte memoizedIsInitialized;
        private volatile Object musicId_;
        private volatile Object name_;
        private int num_;
        private int pageNum_;
        private volatile Object page_;
        private int position_;
        private volatile Object range_;
        private volatile Object roomId_;
        private volatile Object roomName_;
        private volatile Object roomType_;
        private volatile Object roomUid_;
        private int shareChannel_;
        private volatile Object skuId_;
        private volatile Object source_;
        private volatile Object tabId_;
        private int tabNum_;
        private volatile Object targetUid_;
        private volatile Object theme_;
        private volatile Object type_;
        private volatile Object url_;
        private int userType_;
        private int warnType_;
        private static final ChatRoomProto DEFAULT_INSTANCE = new ChatRoomProto();
        private static final Parser<ChatRoomProto> PARSER = new AbstractParser<ChatRoomProto>() { // from class: com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProto.1
            @Override // com.google.protobuf.Parser
            public ChatRoomProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ChatRoomProto(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/chatroom/ChatRoomProtos$ChatRoomProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChatRoomProtoOrBuilder {
            private Object bannerId_;
            private int beans_;
            private Object content_;
            private int count_;
            private int duration_;
            private int event_;
            private int from_;
            private Object goodsId_;
            private Object id_;
            private boolean isFollow_;
            private boolean isOpen_;
            private boolean isTrue_;
            private Object label_;
            private Object level_;
            private int location_;
            private Object musicId_;
            private Object name_;
            private int num_;
            private int pageNum_;
            private Object page_;
            private int position_;
            private Object range_;
            private Object roomId_;
            private Object roomName_;
            private Object roomType_;
            private Object roomUid_;
            private int shareChannel_;
            private Object skuId_;
            private Object source_;
            private Object tabId_;
            private int tabNum_;
            private Object targetUid_;
            private Object theme_;
            private Object type_;
            private Object url_;
            private int userType_;
            private int warnType_;

            private Builder() {
                this.event_ = 0;
                this.roomId_ = "";
                this.roomName_ = "";
                this.roomUid_ = "";
                this.roomType_ = "";
                this.source_ = "";
                this.tabId_ = "";
                this.userType_ = 0;
                this.bannerId_ = "";
                this.targetUid_ = "";
                this.skuId_ = "";
                this.shareChannel_ = 0;
                this.warnType_ = 0;
                this.goodsId_ = "";
                this.content_ = "";
                this.id_ = "";
                this.from_ = 0;
                this.musicId_ = "";
                this.range_ = "";
                this.url_ = "";
                this.page_ = "";
                this.type_ = "";
                this.label_ = "";
                this.theme_ = "";
                this.name_ = "";
                this.level_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.event_ = 0;
                this.roomId_ = "";
                this.roomName_ = "";
                this.roomUid_ = "";
                this.roomType_ = "";
                this.source_ = "";
                this.tabId_ = "";
                this.userType_ = 0;
                this.bannerId_ = "";
                this.targetUid_ = "";
                this.skuId_ = "";
                this.shareChannel_ = 0;
                this.warnType_ = 0;
                this.goodsId_ = "";
                this.content_ = "";
                this.id_ = "";
                this.from_ = 0;
                this.musicId_ = "";
                this.range_ = "";
                this.url_ = "";
                this.page_ = "";
                this.type_ = "";
                this.label_ = "";
                this.theme_ = "";
                this.name_ = "";
                this.level_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ChatRoomProtos.internal_static_com_blued_das_client_chatroom_ChatRoomProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = ChatRoomProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChatRoomProto build() {
                ChatRoomProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChatRoomProto buildPartial() {
                ChatRoomProto chatRoomProto = new ChatRoomProto(this);
                chatRoomProto.event_ = this.event_;
                chatRoomProto.roomId_ = this.roomId_;
                chatRoomProto.roomName_ = this.roomName_;
                chatRoomProto.roomUid_ = this.roomUid_;
                chatRoomProto.roomType_ = this.roomType_;
                chatRoomProto.source_ = this.source_;
                chatRoomProto.tabId_ = this.tabId_;
                chatRoomProto.userType_ = this.userType_;
                chatRoomProto.bannerId_ = this.bannerId_;
                chatRoomProto.targetUid_ = this.targetUid_;
                chatRoomProto.isFollow_ = this.isFollow_;
                chatRoomProto.skuId_ = this.skuId_;
                chatRoomProto.shareChannel_ = this.shareChannel_;
                chatRoomProto.warnType_ = this.warnType_;
                chatRoomProto.num_ = this.num_;
                chatRoomProto.goodsId_ = this.goodsId_;
                chatRoomProto.count_ = this.count_;
                chatRoomProto.content_ = this.content_;
                chatRoomProto.id_ = this.id_;
                chatRoomProto.from_ = this.from_;
                chatRoomProto.position_ = this.position_;
                chatRoomProto.tabNum_ = this.tabNum_;
                chatRoomProto.pageNum_ = this.pageNum_;
                chatRoomProto.musicId_ = this.musicId_;
                chatRoomProto.duration_ = this.duration_;
                chatRoomProto.range_ = this.range_;
                chatRoomProto.url_ = this.url_;
                chatRoomProto.page_ = this.page_;
                chatRoomProto.isTrue_ = this.isTrue_;
                chatRoomProto.type_ = this.type_;
                chatRoomProto.location_ = this.location_;
                chatRoomProto.label_ = this.label_;
                chatRoomProto.theme_ = this.theme_;
                chatRoomProto.name_ = this.name_;
                chatRoomProto.level_ = this.level_;
                chatRoomProto.beans_ = this.beans_;
                chatRoomProto.isOpen_ = this.isOpen_;
                onBuilt();
                return chatRoomProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.event_ = 0;
                this.roomId_ = "";
                this.roomName_ = "";
                this.roomUid_ = "";
                this.roomType_ = "";
                this.source_ = "";
                this.tabId_ = "";
                this.userType_ = 0;
                this.bannerId_ = "";
                this.targetUid_ = "";
                this.isFollow_ = false;
                this.skuId_ = "";
                this.shareChannel_ = 0;
                this.warnType_ = 0;
                this.num_ = 0;
                this.goodsId_ = "";
                this.count_ = 0;
                this.content_ = "";
                this.id_ = "";
                this.from_ = 0;
                this.position_ = 0;
                this.tabNum_ = 0;
                this.pageNum_ = 0;
                this.musicId_ = "";
                this.duration_ = 0;
                this.range_ = "";
                this.url_ = "";
                this.page_ = "";
                this.isTrue_ = false;
                this.type_ = "";
                this.location_ = 0;
                this.label_ = "";
                this.theme_ = "";
                this.name_ = "";
                this.level_ = "";
                this.beans_ = 0;
                this.isOpen_ = false;
                return this;
            }

            public Builder clearBannerId() {
                this.bannerId_ = ChatRoomProto.getDefaultInstance().getBannerId();
                onChanged();
                return this;
            }

            public Builder clearBeans() {
                this.beans_ = 0;
                onChanged();
                return this;
            }

            public Builder clearContent() {
                this.content_ = ChatRoomProto.getDefaultInstance().getContent();
                onChanged();
                return this;
            }

            public Builder clearCount() {
                this.count_ = 0;
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

            public Builder clearFrom() {
                this.from_ = 0;
                onChanged();
                return this;
            }

            public Builder clearGoodsId() {
                this.goodsId_ = ChatRoomProto.getDefaultInstance().getGoodsId();
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = ChatRoomProto.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            public Builder clearIsFollow() {
                this.isFollow_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsTrue() {
                this.isTrue_ = false;
                onChanged();
                return this;
            }

            public Builder clearLabel() {
                this.label_ = ChatRoomProto.getDefaultInstance().getLabel();
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                this.level_ = ChatRoomProto.getDefaultInstance().getLevel();
                onChanged();
                return this;
            }

            public Builder clearLocation() {
                this.location_ = 0;
                onChanged();
                return this;
            }

            public Builder clearMusicId() {
                this.musicId_ = ChatRoomProto.getDefaultInstance().getMusicId();
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = ChatRoomProto.getDefaultInstance().getName();
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

            public Builder clearPage() {
                this.page_ = ChatRoomProto.getDefaultInstance().getPage();
                onChanged();
                return this;
            }

            public Builder clearPageNum() {
                this.pageNum_ = 0;
                onChanged();
                return this;
            }

            public Builder clearPosition() {
                this.position_ = 0;
                onChanged();
                return this;
            }

            public Builder clearRange() {
                this.range_ = ChatRoomProto.getDefaultInstance().getRange();
                onChanged();
                return this;
            }

            public Builder clearRoomId() {
                this.roomId_ = ChatRoomProto.getDefaultInstance().getRoomId();
                onChanged();
                return this;
            }

            public Builder clearRoomName() {
                this.roomName_ = ChatRoomProto.getDefaultInstance().getRoomName();
                onChanged();
                return this;
            }

            public Builder clearRoomType() {
                this.roomType_ = ChatRoomProto.getDefaultInstance().getRoomType();
                onChanged();
                return this;
            }

            public Builder clearRoomUid() {
                this.roomUid_ = ChatRoomProto.getDefaultInstance().getRoomUid();
                onChanged();
                return this;
            }

            public Builder clearShareChannel() {
                this.shareChannel_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSkuId() {
                this.skuId_ = ChatRoomProto.getDefaultInstance().getSkuId();
                onChanged();
                return this;
            }

            public Builder clearSource() {
                this.source_ = ChatRoomProto.getDefaultInstance().getSource();
                onChanged();
                return this;
            }

            public Builder clearTabId() {
                this.tabId_ = ChatRoomProto.getDefaultInstance().getTabId();
                onChanged();
                return this;
            }

            public Builder clearTabNum() {
                this.tabNum_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = ChatRoomProto.getDefaultInstance().getTargetUid();
                onChanged();
                return this;
            }

            public Builder clearTheme() {
                this.theme_ = ChatRoomProto.getDefaultInstance().getTheme();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = ChatRoomProto.getDefaultInstance().getType();
                onChanged();
                return this;
            }

            public Builder clearUrl() {
                this.url_ = ChatRoomProto.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            public Builder clearUserType() {
                this.userType_ = 0;
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

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getBannerId() {
                Object obj = this.bannerId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.bannerId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getBannerIdBytes() {
                Object obj = this.bannerId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.bannerId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public int getBeans() {
                return this.beans_;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getContent() {
                Object obj = this.content_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.content_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getContentBytes() {
                Object obj = this.content_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.content_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public int getCount() {
                return this.count_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChatRoomProto getDefaultInstanceForType() {
                return ChatRoomProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChatRoomProtos.internal_static_com_blued_das_client_chatroom_ChatRoomProto_descriptor;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public int getDuration() {
                return this.duration_;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public Event getEvent() {
                Event valueOf = Event.valueOf(this.event_);
                Event event = valueOf;
                if (valueOf == null) {
                    event = Event.UNRECOGNIZED;
                }
                return event;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public int getEventValue() {
                return this.event_;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public From getFrom() {
                From valueOf = From.valueOf(this.from_);
                From from = valueOf;
                if (valueOf == null) {
                    from = From.UNRECOGNIZED;
                }
                return from;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public int getFromValue() {
                return this.from_;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getGoodsId() {
                Object obj = this.goodsId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.goodsId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getGoodsIdBytes() {
                Object obj = this.goodsId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.goodsId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getId() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.id_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getIdBytes() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.id_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public boolean getIsFollow() {
                return this.isFollow_;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public boolean getIsTrue() {
                return this.isTrue_;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getLabel() {
                Object obj = this.label_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.label_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getLabelBytes() {
                Object obj = this.label_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.label_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getLevel() {
                Object obj = this.level_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.level_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getLevelBytes() {
                Object obj = this.level_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.level_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public int getLocation() {
                return this.location_;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getMusicId() {
                Object obj = this.musicId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.musicId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getMusicIdBytes() {
                Object obj = this.musicId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.musicId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public int getNum() {
                return this.num_;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getPage() {
                Object obj = this.page_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.page_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getPageBytes() {
                Object obj = this.page_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.page_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public int getPageNum() {
                return this.pageNum_;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public int getPosition() {
                return this.position_;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getRange() {
                Object obj = this.range_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.range_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getRangeBytes() {
                Object obj = this.range_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.range_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getRoomId() {
                Object obj = this.roomId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.roomId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getRoomIdBytes() {
                Object obj = this.roomId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.roomId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getRoomName() {
                Object obj = this.roomName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.roomName_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getRoomNameBytes() {
                Object obj = this.roomName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.roomName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getRoomType() {
                Object obj = this.roomType_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.roomType_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getRoomTypeBytes() {
                Object obj = this.roomType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.roomType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getRoomUid() {
                Object obj = this.roomUid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.roomUid_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getRoomUidBytes() {
                Object obj = this.roomUid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.roomUid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ShareChannel getShareChannel() {
                ShareChannel valueOf = ShareChannel.valueOf(this.shareChannel_);
                ShareChannel shareChannel = valueOf;
                if (valueOf == null) {
                    shareChannel = ShareChannel.UNRECOGNIZED;
                }
                return shareChannel;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public int getShareChannelValue() {
                return this.shareChannel_;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getSkuId() {
                Object obj = this.skuId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.skuId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getSkuIdBytes() {
                Object obj = this.skuId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.skuId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getSource() {
                Object obj = this.source_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.source_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getSourceBytes() {
                Object obj = this.source_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.source_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getTabId() {
                Object obj = this.tabId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.tabId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getTabIdBytes() {
                Object obj = this.tabId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.tabId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public int getTabNum() {
                return this.tabNum_;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getTargetUid() {
                Object obj = this.targetUid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.targetUid_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getTargetUidBytes() {
                Object obj = this.targetUid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.targetUid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getTheme() {
                Object obj = this.theme_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.theme_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getThemeBytes() {
                Object obj = this.theme_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.theme_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getType() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.type_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getTypeBytes() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.type_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public String getUrl() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public ByteString getUrlBytes() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.url_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public UserType getUserType() {
                UserType valueOf = UserType.valueOf(this.userType_);
                UserType userType = valueOf;
                if (valueOf == null) {
                    userType = UserType.UNRECOGNIZED;
                }
                return userType;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public int getUserTypeValue() {
                return this.userType_;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public WarnType getWarnType() {
                WarnType valueOf = WarnType.valueOf(this.warnType_);
                WarnType warnType = valueOf;
                if (valueOf == null) {
                    warnType = WarnType.UNRECOGNIZED;
                }
                return warnType;
            }

            @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
            public int getWarnTypeValue() {
                return this.warnType_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChatRoomProtos.internal_static_com_blued_das_client_chatroom_ChatRoomProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ChatRoomProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(ChatRoomProto chatRoomProto) {
                if (chatRoomProto == ChatRoomProto.getDefaultInstance()) {
                    return this;
                }
                if (chatRoomProto.event_ != 0) {
                    setEventValue(chatRoomProto.getEventValue());
                }
                if (!chatRoomProto.getRoomId().isEmpty()) {
                    this.roomId_ = chatRoomProto.roomId_;
                    onChanged();
                }
                if (!chatRoomProto.getRoomName().isEmpty()) {
                    this.roomName_ = chatRoomProto.roomName_;
                    onChanged();
                }
                if (!chatRoomProto.getRoomUid().isEmpty()) {
                    this.roomUid_ = chatRoomProto.roomUid_;
                    onChanged();
                }
                if (!chatRoomProto.getRoomType().isEmpty()) {
                    this.roomType_ = chatRoomProto.roomType_;
                    onChanged();
                }
                if (!chatRoomProto.getSource().isEmpty()) {
                    this.source_ = chatRoomProto.source_;
                    onChanged();
                }
                if (!chatRoomProto.getTabId().isEmpty()) {
                    this.tabId_ = chatRoomProto.tabId_;
                    onChanged();
                }
                if (chatRoomProto.userType_ != 0) {
                    setUserTypeValue(chatRoomProto.getUserTypeValue());
                }
                if (!chatRoomProto.getBannerId().isEmpty()) {
                    this.bannerId_ = chatRoomProto.bannerId_;
                    onChanged();
                }
                if (!chatRoomProto.getTargetUid().isEmpty()) {
                    this.targetUid_ = chatRoomProto.targetUid_;
                    onChanged();
                }
                if (chatRoomProto.getIsFollow()) {
                    setIsFollow(chatRoomProto.getIsFollow());
                }
                if (!chatRoomProto.getSkuId().isEmpty()) {
                    this.skuId_ = chatRoomProto.skuId_;
                    onChanged();
                }
                if (chatRoomProto.shareChannel_ != 0) {
                    setShareChannelValue(chatRoomProto.getShareChannelValue());
                }
                if (chatRoomProto.warnType_ != 0) {
                    setWarnTypeValue(chatRoomProto.getWarnTypeValue());
                }
                if (chatRoomProto.getNum() != 0) {
                    setNum(chatRoomProto.getNum());
                }
                if (!chatRoomProto.getGoodsId().isEmpty()) {
                    this.goodsId_ = chatRoomProto.goodsId_;
                    onChanged();
                }
                if (chatRoomProto.getCount() != 0) {
                    setCount(chatRoomProto.getCount());
                }
                if (!chatRoomProto.getContent().isEmpty()) {
                    this.content_ = chatRoomProto.content_;
                    onChanged();
                }
                if (!chatRoomProto.getId().isEmpty()) {
                    this.id_ = chatRoomProto.id_;
                    onChanged();
                }
                if (chatRoomProto.from_ != 0) {
                    setFromValue(chatRoomProto.getFromValue());
                }
                if (chatRoomProto.getPosition() != 0) {
                    setPosition(chatRoomProto.getPosition());
                }
                if (chatRoomProto.getTabNum() != 0) {
                    setTabNum(chatRoomProto.getTabNum());
                }
                if (chatRoomProto.getPageNum() != 0) {
                    setPageNum(chatRoomProto.getPageNum());
                }
                if (!chatRoomProto.getMusicId().isEmpty()) {
                    this.musicId_ = chatRoomProto.musicId_;
                    onChanged();
                }
                if (chatRoomProto.getDuration() != 0) {
                    setDuration(chatRoomProto.getDuration());
                }
                if (!chatRoomProto.getRange().isEmpty()) {
                    this.range_ = chatRoomProto.range_;
                    onChanged();
                }
                if (!chatRoomProto.getUrl().isEmpty()) {
                    this.url_ = chatRoomProto.url_;
                    onChanged();
                }
                if (!chatRoomProto.getPage().isEmpty()) {
                    this.page_ = chatRoomProto.page_;
                    onChanged();
                }
                if (chatRoomProto.getIsTrue()) {
                    setIsTrue(chatRoomProto.getIsTrue());
                }
                if (!chatRoomProto.getType().isEmpty()) {
                    this.type_ = chatRoomProto.type_;
                    onChanged();
                }
                if (chatRoomProto.getLocation() != 0) {
                    setLocation(chatRoomProto.getLocation());
                }
                if (!chatRoomProto.getLabel().isEmpty()) {
                    this.label_ = chatRoomProto.label_;
                    onChanged();
                }
                if (!chatRoomProto.getTheme().isEmpty()) {
                    this.theme_ = chatRoomProto.theme_;
                    onChanged();
                }
                if (!chatRoomProto.getName().isEmpty()) {
                    this.name_ = chatRoomProto.name_;
                    onChanged();
                }
                if (!chatRoomProto.getLevel().isEmpty()) {
                    this.level_ = chatRoomProto.level_;
                    onChanged();
                }
                if (chatRoomProto.getBeans() != 0) {
                    setBeans(chatRoomProto.getBeans());
                }
                if (chatRoomProto.getIsOpen()) {
                    setIsOpen(chatRoomProto.getIsOpen());
                }
                mergeUnknownFields(chatRoomProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProto.access$4400()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.client.chatroom.ChatRoomProtos$ChatRoomProto r0 = (com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.client.chatroom.ChatRoomProtos$ChatRoomProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.client.chatroom.ChatRoomProtos$ChatRoomProto r0 = (com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.client.chatroom.ChatRoomProtos$ChatRoomProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.client.chatroom.ChatRoomProtos$ChatRoomProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof ChatRoomProto) {
                    return mergeFrom((ChatRoomProto) message);
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
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
                    this.bannerId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setBeans(int i) {
                this.beans_ = i;
                onChanged();
                return this;
            }

            public Builder setContent(String str) {
                if (str != null) {
                    this.content_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setContentBytes(ByteString byteString) {
                if (byteString != null) {
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
                    this.content_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setCount(int i) {
                this.count_ = i;
                onChanged();
                return this;
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

            public Builder setFrom(From from) {
                if (from != null) {
                    this.from_ = from.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setFromValue(int i) {
                this.from_ = i;
                onChanged();
                return this;
            }

            public Builder setGoodsId(String str) {
                if (str != null) {
                    this.goodsId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setGoodsIdBytes(ByteString byteString) {
                if (byteString != null) {
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
                    this.goodsId_ = byteString;
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
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
                    this.id_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setIsFollow(boolean z) {
                this.isFollow_ = z;
                onChanged();
                return this;
            }

            public Builder setIsOpen(boolean z) {
                this.isOpen_ = z;
                onChanged();
                return this;
            }

            public Builder setIsTrue(boolean z) {
                this.isTrue_ = z;
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
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
                    this.label_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLevel(String str) {
                if (str != null) {
                    this.level_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLevelBytes(ByteString byteString) {
                if (byteString != null) {
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
                    this.level_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLocation(int i) {
                this.location_ = i;
                onChanged();
                return this;
            }

            public Builder setMusicId(String str) {
                if (str != null) {
                    this.musicId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMusicIdBytes(ByteString byteString) {
                if (byteString != null) {
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
                    this.musicId_ = byteString;
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
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
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

            public Builder setPage(String str) {
                if (str != null) {
                    this.page_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPageBytes(ByteString byteString) {
                if (byteString != null) {
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
                    this.page_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPageNum(int i) {
                this.pageNum_ = i;
                onChanged();
                return this;
            }

            public Builder setPosition(int i) {
                this.position_ = i;
                onChanged();
                return this;
            }

            public Builder setRange(String str) {
                if (str != null) {
                    this.range_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRangeBytes(ByteString byteString) {
                if (byteString != null) {
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
                    this.range_ = byteString;
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
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
                    this.roomId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRoomName(String str) {
                if (str != null) {
                    this.roomName_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRoomNameBytes(ByteString byteString) {
                if (byteString != null) {
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
                    this.roomName_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRoomType(String str) {
                if (str != null) {
                    this.roomType_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRoomTypeBytes(ByteString byteString) {
                if (byteString != null) {
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
                    this.roomType_ = byteString;
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
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
                    this.roomUid_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setShareChannel(ShareChannel shareChannel) {
                if (shareChannel != null) {
                    this.shareChannel_ = shareChannel.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setShareChannelValue(int i) {
                this.shareChannel_ = i;
                onChanged();
                return this;
            }

            public Builder setSkuId(String str) {
                if (str != null) {
                    this.skuId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setSkuIdBytes(ByteString byteString) {
                if (byteString != null) {
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
                    this.skuId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setSource(String str) {
                if (str != null) {
                    this.source_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setSourceBytes(ByteString byteString) {
                if (byteString != null) {
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
                    this.source_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTabId(String str) {
                if (str != null) {
                    this.tabId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTabIdBytes(ByteString byteString) {
                if (byteString != null) {
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
                    this.tabId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTabNum(int i) {
                this.tabNum_ = i;
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
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
                    this.targetUid_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTheme(String str) {
                if (str != null) {
                    this.theme_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setThemeBytes(ByteString byteString) {
                if (byteString != null) {
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
                    this.theme_ = byteString;
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
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
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
                    ChatRoomProto.checkByteStringIsUtf8(byteString);
                    this.url_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setUserType(UserType userType) {
                if (userType != null) {
                    this.userType_ = userType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setUserTypeValue(int i) {
                this.userType_ = i;
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

        private ChatRoomProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.event_ = 0;
            this.roomId_ = "";
            this.roomName_ = "";
            this.roomUid_ = "";
            this.roomType_ = "";
            this.source_ = "";
            this.tabId_ = "";
            this.userType_ = 0;
            this.bannerId_ = "";
            this.targetUid_ = "";
            this.skuId_ = "";
            this.shareChannel_ = 0;
            this.warnType_ = 0;
            this.goodsId_ = "";
            this.content_ = "";
            this.id_ = "";
            this.from_ = 0;
            this.musicId_ = "";
            this.range_ = "";
            this.url_ = "";
            this.page_ = "";
            this.type_ = "";
            this.label_ = "";
            this.theme_ = "";
            this.name_ = "";
            this.level_ = "";
        }

        private ChatRoomProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.roomId_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 26:
                                    this.roomName_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 34:
                                    this.roomUid_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 42:
                                    this.roomType_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 50:
                                    this.source_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 58:
                                    this.tabId_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 64:
                                    this.userType_ = codedInputStream.readEnum();
                                    continue;
                                case 74:
                                    this.bannerId_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 82:
                                    this.targetUid_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 88:
                                    this.isFollow_ = codedInputStream.readBool();
                                    continue;
                                case 98:
                                    this.skuId_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 104:
                                    this.shareChannel_ = codedInputStream.readEnum();
                                    continue;
                                case 112:
                                    this.warnType_ = codedInputStream.readEnum();
                                    continue;
                                case 120:
                                    this.num_ = codedInputStream.readInt32();
                                    continue;
                                case 130:
                                    this.goodsId_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 136:
                                    this.count_ = codedInputStream.readInt32();
                                    continue;
                                case 146:
                                    this.content_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 154:
                                    this.id_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 160:
                                    this.from_ = codedInputStream.readEnum();
                                    continue;
                                case 168:
                                    this.position_ = codedInputStream.readInt32();
                                    continue;
                                case 176:
                                    this.tabNum_ = codedInputStream.readInt32();
                                    continue;
                                case 184:
                                    this.pageNum_ = codedInputStream.readInt32();
                                    continue;
                                case 194:
                                    this.musicId_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 200:
                                    this.duration_ = codedInputStream.readInt32();
                                    continue;
                                case 210:
                                    this.range_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 218:
                                    this.url_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 226:
                                    this.page_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 232:
                                    this.isTrue_ = codedInputStream.readBool();
                                    continue;
                                case 242:
                                    this.type_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 248:
                                    this.location_ = codedInputStream.readInt32();
                                    continue;
                                case 258:
                                    this.label_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 266:
                                    this.theme_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 274:
                                    this.name_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 282:
                                    this.level_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 288:
                                    this.beans_ = codedInputStream.readInt32();
                                    continue;
                                case 296:
                                    this.isOpen_ = codedInputStream.readBool();
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

        private ChatRoomProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ChatRoomProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ChatRoomProtos.internal_static_com_blued_das_client_chatroom_ChatRoomProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChatRoomProto chatRoomProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(chatRoomProto);
        }

        public static ChatRoomProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ChatRoomProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ChatRoomProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ChatRoomProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ChatRoomProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ChatRoomProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ChatRoomProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ChatRoomProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ChatRoomProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ChatRoomProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static ChatRoomProto parseFrom(InputStream inputStream) throws IOException {
            return (ChatRoomProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ChatRoomProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ChatRoomProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ChatRoomProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static ChatRoomProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static ChatRoomProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ChatRoomProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<ChatRoomProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ChatRoomProto) {
                ChatRoomProto chatRoomProto = (ChatRoomProto) obj;
                return this.event_ == chatRoomProto.event_ && getRoomId().equals(chatRoomProto.getRoomId()) && getRoomName().equals(chatRoomProto.getRoomName()) && getRoomUid().equals(chatRoomProto.getRoomUid()) && getRoomType().equals(chatRoomProto.getRoomType()) && getSource().equals(chatRoomProto.getSource()) && getTabId().equals(chatRoomProto.getTabId()) && this.userType_ == chatRoomProto.userType_ && getBannerId().equals(chatRoomProto.getBannerId()) && getTargetUid().equals(chatRoomProto.getTargetUid()) && getIsFollow() == chatRoomProto.getIsFollow() && getSkuId().equals(chatRoomProto.getSkuId()) && this.shareChannel_ == chatRoomProto.shareChannel_ && this.warnType_ == chatRoomProto.warnType_ && getNum() == chatRoomProto.getNum() && getGoodsId().equals(chatRoomProto.getGoodsId()) && getCount() == chatRoomProto.getCount() && getContent().equals(chatRoomProto.getContent()) && getId().equals(chatRoomProto.getId()) && this.from_ == chatRoomProto.from_ && getPosition() == chatRoomProto.getPosition() && getTabNum() == chatRoomProto.getTabNum() && getPageNum() == chatRoomProto.getPageNum() && getMusicId().equals(chatRoomProto.getMusicId()) && getDuration() == chatRoomProto.getDuration() && getRange().equals(chatRoomProto.getRange()) && getUrl().equals(chatRoomProto.getUrl()) && getPage().equals(chatRoomProto.getPage()) && getIsTrue() == chatRoomProto.getIsTrue() && getType().equals(chatRoomProto.getType()) && getLocation() == chatRoomProto.getLocation() && getLabel().equals(chatRoomProto.getLabel()) && getTheme().equals(chatRoomProto.getTheme()) && getName().equals(chatRoomProto.getName()) && getLevel().equals(chatRoomProto.getLevel()) && getBeans() == chatRoomProto.getBeans() && getIsOpen() == chatRoomProto.getIsOpen() && this.unknownFields.equals(chatRoomProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getBannerId() {
            Object obj = this.bannerId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.bannerId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public ByteString getBannerIdBytes() {
            Object obj = this.bannerId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.bannerId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public int getBeans() {
            return this.beans_;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getContent() {
            Object obj = this.content_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.content_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public ByteString getContentBytes() {
            Object obj = this.content_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.content_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public int getCount() {
            return this.count_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChatRoomProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public int getDuration() {
            return this.duration_;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public Event getEvent() {
            Event valueOf = Event.valueOf(this.event_);
            Event event = valueOf;
            if (valueOf == null) {
                event = Event.UNRECOGNIZED;
            }
            return event;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public int getEventValue() {
            return this.event_;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public From getFrom() {
            From valueOf = From.valueOf(this.from_);
            From from = valueOf;
            if (valueOf == null) {
                from = From.UNRECOGNIZED;
            }
            return from;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public int getFromValue() {
            return this.from_;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getGoodsId() {
            Object obj = this.goodsId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.goodsId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public ByteString getGoodsIdBytes() {
            Object obj = this.goodsId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.goodsId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getId() {
            Object obj = this.id_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.id_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public ByteString getIdBytes() {
            Object obj = this.id_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.id_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public boolean getIsFollow() {
            return this.isFollow_;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public boolean getIsTrue() {
            return this.isTrue_;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getLabel() {
            Object obj = this.label_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.label_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public ByteString getLabelBytes() {
            Object obj = this.label_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.label_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getLevel() {
            Object obj = this.level_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.level_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public ByteString getLevelBytes() {
            Object obj = this.level_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.level_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public int getLocation() {
            return this.location_;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getMusicId() {
            Object obj = this.musicId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.musicId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public ByteString getMusicIdBytes() {
            Object obj = this.musicId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.musicId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public int getNum() {
            return this.num_;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getPage() {
            Object obj = this.page_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.page_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public ByteString getPageBytes() {
            Object obj = this.page_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.page_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public int getPageNum() {
            return this.pageNum_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChatRoomProto> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public int getPosition() {
            return this.position_;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getRange() {
            Object obj = this.range_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.range_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public ByteString getRangeBytes() {
            Object obj = this.range_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.range_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getRoomId() {
            Object obj = this.roomId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.roomId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public ByteString getRoomIdBytes() {
            Object obj = this.roomId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.roomId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getRoomName() {
            Object obj = this.roomName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.roomName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public ByteString getRoomNameBytes() {
            Object obj = this.roomName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.roomName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getRoomType() {
            Object obj = this.roomType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.roomType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public ByteString getRoomTypeBytes() {
            Object obj = this.roomType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.roomType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getRoomUid() {
            Object obj = this.roomUid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.roomUid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
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
            if (!getRoomIdBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.roomId_);
            }
            int i4 = i3;
            if (!getRoomNameBytes().isEmpty()) {
                i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.roomName_);
            }
            int i5 = i4;
            if (!getRoomUidBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(4, this.roomUid_);
            }
            int i6 = i5;
            if (!getRoomTypeBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(5, this.roomType_);
            }
            int i7 = i6;
            if (!getSourceBytes().isEmpty()) {
                i7 = i6 + GeneratedMessageV3.computeStringSize(6, this.source_);
            }
            int i8 = i7;
            if (!getTabIdBytes().isEmpty()) {
                i8 = i7 + GeneratedMessageV3.computeStringSize(7, this.tabId_);
            }
            int i9 = i8;
            if (this.userType_ != UserType.UNKNOWN_USER_TYPE.getNumber()) {
                i9 = i8 + CodedOutputStream.computeEnumSize(8, this.userType_);
            }
            int i10 = i9;
            if (!getBannerIdBytes().isEmpty()) {
                i10 = i9 + GeneratedMessageV3.computeStringSize(9, this.bannerId_);
            }
            int i11 = i10;
            if (!getTargetUidBytes().isEmpty()) {
                i11 = i10 + GeneratedMessageV3.computeStringSize(10, this.targetUid_);
            }
            boolean z = this.isFollow_;
            int i12 = i11;
            if (z) {
                i12 = i11 + CodedOutputStream.computeBoolSize(11, z);
            }
            int i13 = i12;
            if (!getSkuIdBytes().isEmpty()) {
                i13 = i12 + GeneratedMessageV3.computeStringSize(12, this.skuId_);
            }
            int i14 = i13;
            if (this.shareChannel_ != ShareChannel.UNKNOWN_SHARE_CHANNEL.getNumber()) {
                i14 = i13 + CodedOutputStream.computeEnumSize(13, this.shareChannel_);
            }
            int i15 = i14;
            if (this.warnType_ != WarnType.UNKNOWN_WARN_TYPE.getNumber()) {
                i15 = i14 + CodedOutputStream.computeEnumSize(14, this.warnType_);
            }
            int i16 = this.num_;
            int i17 = i15;
            if (i16 != 0) {
                i17 = i15 + CodedOutputStream.computeInt32Size(15, i16);
            }
            int i18 = i17;
            if (!getGoodsIdBytes().isEmpty()) {
                i18 = i17 + GeneratedMessageV3.computeStringSize(16, this.goodsId_);
            }
            int i19 = this.count_;
            int i20 = i18;
            if (i19 != 0) {
                i20 = i18 + CodedOutputStream.computeInt32Size(17, i19);
            }
            int i21 = i20;
            if (!getContentBytes().isEmpty()) {
                i21 = i20 + GeneratedMessageV3.computeStringSize(18, this.content_);
            }
            int i22 = i21;
            if (!getIdBytes().isEmpty()) {
                i22 = i21 + GeneratedMessageV3.computeStringSize(19, this.id_);
            }
            int i23 = i22;
            if (this.from_ != From.UNKNOWN_FROM.getNumber()) {
                i23 = i22 + CodedOutputStream.computeEnumSize(20, this.from_);
            }
            int i24 = this.position_;
            int i25 = i23;
            if (i24 != 0) {
                i25 = i23 + CodedOutputStream.computeInt32Size(21, i24);
            }
            int i26 = this.tabNum_;
            int i27 = i25;
            if (i26 != 0) {
                i27 = i25 + CodedOutputStream.computeInt32Size(22, i26);
            }
            int i28 = this.pageNum_;
            int i29 = i27;
            if (i28 != 0) {
                i29 = i27 + CodedOutputStream.computeInt32Size(23, i28);
            }
            int i30 = i29;
            if (!getMusicIdBytes().isEmpty()) {
                i30 = i29 + GeneratedMessageV3.computeStringSize(24, this.musicId_);
            }
            int i31 = this.duration_;
            int i32 = i30;
            if (i31 != 0) {
                i32 = i30 + CodedOutputStream.computeInt32Size(25, i31);
            }
            int i33 = i32;
            if (!getRangeBytes().isEmpty()) {
                i33 = i32 + GeneratedMessageV3.computeStringSize(26, this.range_);
            }
            int i34 = i33;
            if (!getUrlBytes().isEmpty()) {
                i34 = i33 + GeneratedMessageV3.computeStringSize(27, this.url_);
            }
            int i35 = i34;
            if (!getPageBytes().isEmpty()) {
                i35 = i34 + GeneratedMessageV3.computeStringSize(28, this.page_);
            }
            boolean z2 = this.isTrue_;
            int i36 = i35;
            if (z2) {
                i36 = i35 + CodedOutputStream.computeBoolSize(29, z2);
            }
            int i37 = i36;
            if (!getTypeBytes().isEmpty()) {
                i37 = i36 + GeneratedMessageV3.computeStringSize(30, this.type_);
            }
            int i38 = this.location_;
            int i39 = i37;
            if (i38 != 0) {
                i39 = i37 + CodedOutputStream.computeInt32Size(31, i38);
            }
            int i40 = i39;
            if (!getLabelBytes().isEmpty()) {
                i40 = i39 + GeneratedMessageV3.computeStringSize(32, this.label_);
            }
            int i41 = i40;
            if (!getThemeBytes().isEmpty()) {
                i41 = i40 + GeneratedMessageV3.computeStringSize(33, this.theme_);
            }
            int i42 = i41;
            if (!getNameBytes().isEmpty()) {
                i42 = i41 + GeneratedMessageV3.computeStringSize(34, this.name_);
            }
            int i43 = i42;
            if (!getLevelBytes().isEmpty()) {
                i43 = i42 + GeneratedMessageV3.computeStringSize(35, this.level_);
            }
            int i44 = this.beans_;
            int i45 = i43;
            if (i44 != 0) {
                i45 = i43 + CodedOutputStream.computeInt32Size(36, i44);
            }
            boolean z3 = this.isOpen_;
            int i46 = i45;
            if (z3) {
                i46 = i45 + CodedOutputStream.computeBoolSize(37, z3);
            }
            int serializedSize = i46 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public ShareChannel getShareChannel() {
            ShareChannel valueOf = ShareChannel.valueOf(this.shareChannel_);
            ShareChannel shareChannel = valueOf;
            if (valueOf == null) {
                shareChannel = ShareChannel.UNRECOGNIZED;
            }
            return shareChannel;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public int getShareChannelValue() {
            return this.shareChannel_;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getSkuId() {
            Object obj = this.skuId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.skuId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public ByteString getSkuIdBytes() {
            Object obj = this.skuId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.skuId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getSource() {
            Object obj = this.source_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.source_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public ByteString getSourceBytes() {
            Object obj = this.source_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.source_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getTabId() {
            Object obj = this.tabId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.tabId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public ByteString getTabIdBytes() {
            Object obj = this.tabId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.tabId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public int getTabNum() {
            return this.tabNum_;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getTargetUid() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.targetUid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public ByteString getTargetUidBytes() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.targetUid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getTheme() {
            Object obj = this.theme_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.theme_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public ByteString getThemeBytes() {
            Object obj = this.theme_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.theme_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getType() {
            Object obj = this.type_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.type_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
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

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public UserType getUserType() {
            UserType valueOf = UserType.valueOf(this.userType_);
            UserType userType = valueOf;
            if (valueOf == null) {
                userType = UserType.UNRECOGNIZED;
            }
            return userType;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public int getUserTypeValue() {
            return this.userType_;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public WarnType getWarnType() {
            WarnType valueOf = WarnType.valueOf(this.warnType_);
            WarnType warnType = valueOf;
            if (valueOf == null) {
                warnType = WarnType.UNRECOGNIZED;
            }
            return warnType;
        }

        @Override // com.blued.das.client.chatroom.ChatRoomProtos.ChatRoomProtoOrBuilder
        public int getWarnTypeValue() {
            return this.warnType_;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.event_) * 37) + 2) * 53) + getRoomId().hashCode()) * 37) + 3) * 53) + getRoomName().hashCode()) * 37) + 4) * 53) + getRoomUid().hashCode()) * 37) + 5) * 53) + getRoomType().hashCode()) * 37) + 6) * 53) + getSource().hashCode()) * 37) + 7) * 53) + getTabId().hashCode()) * 37) + 8) * 53) + this.userType_) * 37) + 9) * 53) + getBannerId().hashCode()) * 37) + 10) * 53) + getTargetUid().hashCode()) * 37) + 11) * 53) + Internal.hashBoolean(getIsFollow())) * 37) + 12) * 53) + getSkuId().hashCode()) * 37) + 13) * 53) + this.shareChannel_) * 37) + 14) * 53) + this.warnType_) * 37) + 15) * 53) + getNum()) * 37) + 16) * 53) + getGoodsId().hashCode()) * 37) + 17) * 53) + getCount()) * 37) + 18) * 53) + getContent().hashCode()) * 37) + 19) * 53) + getId().hashCode()) * 37) + 20) * 53) + this.from_) * 37) + 21) * 53) + getPosition()) * 37) + 22) * 53) + getTabNum()) * 37) + 23) * 53) + getPageNum()) * 37) + 24) * 53) + getMusicId().hashCode()) * 37) + 25) * 53) + getDuration()) * 37) + 26) * 53) + getRange().hashCode()) * 37) + 27) * 53) + getUrl().hashCode()) * 37) + 28) * 53) + getPage().hashCode()) * 37) + 29) * 53) + Internal.hashBoolean(getIsTrue())) * 37) + 30) * 53) + getType().hashCode()) * 37) + 31) * 53) + getLocation()) * 37) + 32) * 53) + getLabel().hashCode()) * 37) + 33) * 53) + getTheme().hashCode()) * 37) + 34) * 53) + getName().hashCode()) * 37) + 35) * 53) + getLevel().hashCode()) * 37) + 36) * 53) + getBeans()) * 37) + 37) * 53) + Internal.hashBoolean(getIsOpen())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChatRoomProtos.internal_static_com_blued_das_client_chatroom_ChatRoomProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ChatRoomProto.class, Builder.class);
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
            return new ChatRoomProto();
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
            if (!getRoomIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.roomId_);
            }
            if (!getRoomNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.roomName_);
            }
            if (!getRoomUidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.roomUid_);
            }
            if (!getRoomTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.roomType_);
            }
            if (!getSourceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.source_);
            }
            if (!getTabIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.tabId_);
            }
            if (this.userType_ != UserType.UNKNOWN_USER_TYPE.getNumber()) {
                codedOutputStream.writeEnum(8, this.userType_);
            }
            if (!getBannerIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 9, this.bannerId_);
            }
            if (!getTargetUidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.targetUid_);
            }
            boolean z = this.isFollow_;
            if (z) {
                codedOutputStream.writeBool(11, z);
            }
            if (!getSkuIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 12, this.skuId_);
            }
            if (this.shareChannel_ != ShareChannel.UNKNOWN_SHARE_CHANNEL.getNumber()) {
                codedOutputStream.writeEnum(13, this.shareChannel_);
            }
            if (this.warnType_ != WarnType.UNKNOWN_WARN_TYPE.getNumber()) {
                codedOutputStream.writeEnum(14, this.warnType_);
            }
            int i = this.num_;
            if (i != 0) {
                codedOutputStream.writeInt32(15, i);
            }
            if (!getGoodsIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 16, this.goodsId_);
            }
            int i2 = this.count_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(17, i2);
            }
            if (!getContentBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 18, this.content_);
            }
            if (!getIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 19, this.id_);
            }
            if (this.from_ != From.UNKNOWN_FROM.getNumber()) {
                codedOutputStream.writeEnum(20, this.from_);
            }
            int i3 = this.position_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(21, i3);
            }
            int i4 = this.tabNum_;
            if (i4 != 0) {
                codedOutputStream.writeInt32(22, i4);
            }
            int i5 = this.pageNum_;
            if (i5 != 0) {
                codedOutputStream.writeInt32(23, i5);
            }
            if (!getMusicIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 24, this.musicId_);
            }
            int i6 = this.duration_;
            if (i6 != 0) {
                codedOutputStream.writeInt32(25, i6);
            }
            if (!getRangeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 26, this.range_);
            }
            if (!getUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 27, this.url_);
            }
            if (!getPageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 28, this.page_);
            }
            boolean z2 = this.isTrue_;
            if (z2) {
                codedOutputStream.writeBool(29, z2);
            }
            if (!getTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 30, this.type_);
            }
            int i7 = this.location_;
            if (i7 != 0) {
                codedOutputStream.writeInt32(31, i7);
            }
            if (!getLabelBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 32, this.label_);
            }
            if (!getThemeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 33, this.theme_);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 34, this.name_);
            }
            if (!getLevelBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 35, this.level_);
            }
            int i8 = this.beans_;
            if (i8 != 0) {
                codedOutputStream.writeInt32(36, i8);
            }
            boolean z3 = this.isOpen_;
            if (z3) {
                codedOutputStream.writeBool(37, z3);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/chatroom/ChatRoomProtos$ChatRoomProtoOrBuilder.class */
    public interface ChatRoomProtoOrBuilder extends MessageOrBuilder {
        String getBannerId();

        ByteString getBannerIdBytes();

        int getBeans();

        String getContent();

        ByteString getContentBytes();

        int getCount();

        int getDuration();

        Event getEvent();

        int getEventValue();

        From getFrom();

        int getFromValue();

        String getGoodsId();

        ByteString getGoodsIdBytes();

        String getId();

        ByteString getIdBytes();

        boolean getIsFollow();

        boolean getIsOpen();

        boolean getIsTrue();

        String getLabel();

        ByteString getLabelBytes();

        String getLevel();

        ByteString getLevelBytes();

        int getLocation();

        String getMusicId();

        ByteString getMusicIdBytes();

        String getName();

        ByteString getNameBytes();

        int getNum();

        String getPage();

        ByteString getPageBytes();

        int getPageNum();

        int getPosition();

        String getRange();

        ByteString getRangeBytes();

        String getRoomId();

        ByteString getRoomIdBytes();

        String getRoomName();

        ByteString getRoomNameBytes();

        String getRoomType();

        ByteString getRoomTypeBytes();

        String getRoomUid();

        ByteString getRoomUidBytes();

        ShareChannel getShareChannel();

        int getShareChannelValue();

        String getSkuId();

        ByteString getSkuIdBytes();

        String getSource();

        ByteString getSourceBytes();

        String getTabId();

        ByteString getTabIdBytes();

        int getTabNum();

        String getTargetUid();

        ByteString getTargetUidBytes();

        String getTheme();

        ByteString getThemeBytes();

        String getType();

        ByteString getTypeBytes();

        String getUrl();

        ByteString getUrlBytes();

        UserType getUserType();

        int getUserTypeValue();

        WarnType getWarnType();

        int getWarnTypeValue();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/chatroom/ChatRoomProtos$Event.class */
    public enum Event implements ProtocolMessageEnum {
        UNKNOWN_EVENT(0),
        CHAT_ROOM_PROFILE_ENTER_SHOW(1),
        CHAT_ROOM_PROFILE_ENTER_CLICK(2),
        CHAT_ROOM_MINE_REPORT_SHOW(3),
        CHAT_ROOM_MINE_REPORT_CLICK(4),
        CHAT_ROOM_MINE_ENTER_SHOW(5),
        CHAT_ROOM_ENTER_CLICK(6),
        CHAT_ROOM_HOME_PAGE_TAB_SHOW(7),
        CHAT_ROOM_TAB_PAGE_ROOM_DRAW(8),
        CHAT_ROOM_TAB_PAGE_ROOM_CLICK(9),
        CHAT_ROOM_CREATE_SHOW(10),
        CHAT_ROOM_CREATE_CLICK(11),
        CHAT_ROOM_CREATE_CONFIRM_CLICK(12),
        CHAT_ROOM_NAME_INVALITE_SHOW(13),
        CHAT_ROOM_APPROVE_GUIDE_SHOW(26),
        CHAT_ROOM_APPROVE_GUIDE_CLICK(27),
        CHAT_ROOM_BANNER_SHOW(28),
        CHAT_ROOM_BANNER_CLICK(29),
        CHAT_ROOM_INVITE_CLICK(30),
        CHAT_ROOM_KICK_OUT_CLICK(31),
        CHAT_ROOM_KICK_OUT_CONFIRM_CLICK(32),
        CHAT_ROOM_MUTE_CLICK(33),
        CHAT_ROOM_INVITE_POP_SHOW(34),
        CHAT_ROOM_REFUSE_CLICK(35),
        CHAT_ROOM_ACCEPT_CLICK(36),
        CHAT_ROOM_OUT_MIKE(37),
        CHAT_ROOM_SET_MANAGER_CLICK(38),
        CHAT_ROOM_MANAGER_MAX_SHOW(39),
        CHAT_ROOM_EXIT_BTN_CLICK(40),
        CHAT_ROOM_REPORT_ROOM_CLICK(41),
        CHAT_ROOM_FOLLOW_CLICK(42),
        CHAT_ROOM_UNFOLLOW(44),
        CHAT_ROOM_FOLLOW_GUIDE_SHOW(45),
        CHAT_ROOM_FOLLOW_GUIDE_FOLLOW_CLICK(46),
        CHAT_ROOM_SEND_GIFT_SHOW(47),
        CHAT_ROOM_SEND_GIFT_CLICK(48),
        CHAT_ROOM_RECHARGE_CLICK(49),
        CHAT_ROOM_SHARE_CLICK(51),
        CHAT_ROOM_SHARE_CHANNEL_CLICK(52),
        CHAT_ROOM_MIKE_CLICK(53),
        CHAT_ROOM_PROFILE_MIKE_CLICK(54),
        CHAT_ROOM_MIKE_CONFIRM_CLICK(55),
        CHAT_ROOM_MIKE_SUCCESS_SHOW(56),
        CHAT_ROOM_MIKE_REFUSE_SHOW(57),
        CHAT_ROOM_MIKE_POP_SHOW(58),
        CHAT_ROOM_MIKE_POP_REFUSE_CLICK(59),
        CHAT_ROOM_MIKE_POP_ACCEPT_CLICK(60),
        CHAT_ROOM_MIKE_POP_AUTO_SUCCESS(61),
        CHAT_ROOM_MIKE_USER_REFUSE_CLICK(62),
        CHAT_ROOM_MIKE_USER_ACCEPT_CLICK(63),
        CHAT_ROOM_SEND_MSG_CLICK(64),
        CHAT_ROOM_PROFILE_GO_CLICK(65),
        CHAT_ROOM_USER_PROFILE_FOLLOW_CLICK(66),
        CHAT_ROOM_PROFILE_AT_CLICK(67),
        CHAT_ROOM_PROFILE_MSG_CLICK(68),
        CHAT_ROOM_PROFILE_GIFT_CLICK(69),
        CHAT_ROOM_PROFILE_REPORT_CLICK(70),
        CHAT_ROOM_PROFILE_BLACK_CLICK(71),
        CHAT_ROOM_LIST_CLICK(72),
        CHAT_ROOM_LIST_PAGE_GET_SHOW(73),
        CHAT_ROOM_LIST_PAGE_SEND_SHOW(74),
        CHAT_ROOM_WARN_POP_SHOW(75),
        CHAT_ROOM_USER_OUT_MIKE_TOAST_SHOW(76),
        CHAT_ROOM_OWNER_OUT_MIKE_TOAST_SHOW(77),
        CHAT_ROOM_LIKE_CLICK(80),
        CHAT_ROOM_GIFT_CLICK(81),
        CHAT_ROOM_GIFT_POP_SHOW(84),
        CHAT_ROOM_GIFT_POP_SEND_CLICK(85),
        NO_MONEY_POP_SHOW(86),
        NO_MONEY_POP_RECHARGE_CLICK(87),
        CHAT_ROOM_NAME_CHANGE_CLICK(88),
        CHAT_ROOM_PHONE_BIND_CLICK(89),
        CHAT_ROOM_ENTER_APPROVE_CLICK(90),
        CHAT_ROOM_NOTICE_CLICK(91),
        CHAT_ROOM_NOTICE_SAVE_CLICK(92),
        CHAT_ROOM_NOTICE_CANCEL_CLICK(93),
        CHAT_ROOM_TOOLBOX_CLICK(94),
        CHAT_ROOM_TOOLBOX_EMOJI_CLICK(95),
        CHAT_ROOM_PROFILE_FORBID_CLICK(96),
        CHAT_ROOM_PROFILE_REMOVE_FORBID_CLICK(97),
        CHAT_ROOM_PROFILE_BLOCK_CLICK(99),
        CHAT_ROOM_FOLLOW_MORE_CLICK(100),
        CHAT_ROOM_FOLLOW_ROOM_SHOW(101),
        CHAT_ROOM_FOLLOW_ROOM_CLICK(102),
        CHAT_ROOM_EMOJI_ENTER_CLICK(103),
        CHAT_ROOM_TOOLBOX_MUSIC_SOMEONE_CLICK(106),
        CHAT_ROOM_USER_INVITE_CLICK(107),
        CHAT_ROOM_BG_ENTER_CLICK(109),
        CHAT_ROOM_BG_SOMEONE_CLICK(110),
        CHAT_ROOM_GIFT_POP_ONE_GIFT_SHOW(111),
        CHAT_ROOM_GIFT_POP_ONE_GIFT_CLICK(112),
        CHAT_ROOM_TOOLBOX_MUSIC_PLAY_CLICK(113),
        CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SHOW(114),
        CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SEARCH_CLICK(115),
        CHAT_ROOM_TOOLBOX_MUSIC_LIKE_CLICK(116),
        CHAT_ROOM_TOOLBOX_MUSIC_PAUSE_CLICK(117),
        CHAT_ROOM_TOOLBOX_MUSIC_EXIT_CLICK(118),
        CHAT_ROOM_TOOLBOX_MUSIC_DONE_CLICK(120),
        CHAT_ROOM_TOOLBOX_MUSIC_TAB_SHOW(121),
        CHAT_ROOM_MINIMIZED_WINDOW_CLICK(122),
        CHAT_ROOM_VOTE_ICON_CLICK(123),
        CHAT_ROOM_VOTE_LAUNCH_CLICK(124),
        CHAT_ROOM_VOTE_WINDOW_CLICK(125),
        CHAT_ROOM_VOTE_USER_CLICK(126),
        CHAT_ROOM_INSTRUCTION(127),
        CHAT_ROOM_CP_MATCH_START(128),
        CHAT_ROOM_CP_MATCH_SUCCEED(129),
        CHAT_ROOM_HOST_DISCIPLINE_CLOSE_CLICK(134),
        CHAT_ROOM_MUTE_BTN_CLICK(135),
        CHAT_ROOM_UNMUTE_BTN_CLICK(136),
        CHAT_ROOM_CHANGE_MIC_BTN_CLICK(137),
        CHAT_ROOM_PHONE_BIND_SHOW(138),
        CHAT_ROOM_PHONE_BIND_CONFIRM_CLICK(139),
        CHAT_ROOM_SHARE_TO_FRIEND_CLICK(140),
        CHAT_END_PAGE_LIVING_USER_SHOW(141),
        CHAT_END_PAGE_LIVING_USER_CLICK(142),
        CHAT_ROOM_FOLLOW_ALL_PAGE_SHOW(143),
        CHAT_ROOM_BANNER1_SHOW(144),
        CHAT_ROOM_BANNER1_CLICK(145),
        CHAT_ROOM_BANNER2_SHOW(146),
        CHAT_ROOM_BANNER2_CLICK(147),
        CHAT_ROOM_GIFT_GET_LIST_CLICK(148),
        CHAT_ROOM_GIFT_SEND_LIST_CLICK(149),
        CHAT_ROOM_RANDOM_CLICK(150),
        CHAT_ROOM_RANDOM_SUCCESS(151),
        CHAT_ROOM_PK_CLICK(152),
        CHAT_ROOM_VOTE_CLICK(153),
        CHAT_ROOM_GIFT_PAGE_GIFT_CLICK(154),
        CHAT_ROOM_GIFT_PAGE_BAG_CLICK(155),
        CHAT_ROOM_ACTIVITY_CLICK(156),
        CHAT_ROOM_CAROUSEL_SHOW(157),
        CHAT_ROOM_OWNER_GIFT_GUIDE_CLICK(158),
        CHAT_ROOM_OWNER_DOWN_GIFT_CLICK(159),
        CHAT_ROOM_OWNER_GIFT_CREATE_CLICK(160),
        CHAT_ROOM_USER_GIFT_CLICK(161),
        CHAT_ROOM_USER_GIFT_SEND_CLICK(162),
        CHAT_ROOM_GAME_START_CLICK(163),
        CHAT_ROOM_GAME_ROB_CLICK(164),
        CHAT_ROOM_GAME_ADD_CLICK(165),
        CHAT_ROOM_GAME_DELETE_CLICK(166),
        CHAT_ROOM_GIFT_MORE_HIT_CLICK(167),
        CHAT_ROOM_AUCTION_APPLY_CLICK(168),
        CHAT_ROOM_AUCTION_APPLY_TRUE_CLICK(169),
        CHAT_ROOM_AUCTION_APPLY_FALSE_CLICK(170),
        CHAT_ROOM_AUCTION_APPLY_LIST_CANCEL_CLICK(171),
        CHAT_ROOM_AUCTION_APPLY_LIST_AGREE_CLICK(172),
        CHAT_ROOM_AUCTION_APPLY_LIST_REFUSE_CLICK(173),
        CHAT_ROOM_AUCTION_RELATION_TRUE_CLICK(174),
        CHAT_ROOM_GIFT_LEVEL_GUIDE_ICON_CLICK(176),
        CHAT_ROOM_ANCHOR_LEVEL_CLICK(177),
        CHAT_ROOM_HEART_BEAT_VIP_CLICK(178),
        CHAT_ROOM_HEART_BEAT_VIP_SUCCESS(179),
        SINGLE_ROOM_CREATE_VOICE_CLICK(180),
        SINGLE_ROOM_FANS_UP_SUCCESS(181),
        SINGLE_ROOM_GIFT_SEND_CLICK(182),
        SINGLE_ROOM_ACCOMPANY_UNLOCK(183),
        SINGLE_ROOM_PAY_ICON_CLICK(184),
        SINGLE_ROOM_FIRST_PAY_POP_SHOW(185),
        SINGLE_ROOM_FIRST_PAY_POP_CLICK(186),
        SINGLE_ROOM_PAY_SIX_POP_SHOW(187),
        SINGLE_ROOM_PAY_SIX_POP_CLICK(188),
        SINGLE_ROOM_PAY_SIX_POP_NOW_RECHARGE_CLICK(189),
        CHAT_ROOM_USER_LIST_CLICK(190),
        CHAT_ROOM_OWNER_CUSTOM_CLICK(191),
        CHAT_ROOM_EXIT_ROOM(192),
        PROFILE_GIFT_WALL_SHOW(193),
        PROFILE_GIFT_WALL_CLICK(194),
        PROFILE_GIFT_WALL_DETAIL_QUESTION_CLICK(195),
        PROFILE_GIFT_WALL_DETAIL_GIFT_SEND_CLICK(196),
        CHAT_ROOM_TOOLBOX_ACTIVITY_CLICK(197),
        CHAT_ROOM_GIFT_ACTIVITY_SHOW(198),
        CHAT_ROOM_GIFT_ACTIVITY_CLICK(199),
        CHAT_ROOM_TOOLBOX_PROP_CLICK(200),
        CHAT_ROOM_NEW_GUIDE_POP_SHOW(201),
        CHAT_ROOM_NEW_GUIDE_POP_CLOSE_CLICK(202),
        CHAT_ROOM_RECALL_GUIDE_POP_SHOW(203),
        CHAT_ROOM_RECALL_GUIDE_POP_CLOSE_CLICK(204),
        CHAT_ROOM_START_CHAT_SHOW(205),
        CHAT_ROOM_FOLLOW_ANCHOR_GUIDE_SHOW(206),
        CHAT_ROOM_FOLLOW_ANCHOR_GUIDE_CLICK(207),
        CHAT_ROOM_SEND_GIFT_GUIDE_SHOW(208),
        CHAT_ROOM_SEND_GIFT_GUIDE_CLICK(209),
        CHAT_ROOM_INTERACT_CLICK(210),
        CHAT_ROOM_BACK_INTERACT_CLICK(211),
        CHAT_ROOM_CREATE_UPLOAD_COVER_CLICK(212),
        CHAT_ROOM_UPLOAD_COVER_YES_CLICK(213),
        CHAT_ROOM_OUT_GOODS_SHOW(214),
        CHAT_ROOM_OUT_GOODS_CLICK(215),
        CHAT_ROOM_OUT_GOODS_POP_SEND_CLICK(216),
        CHAT_ROOM_OUT_GOODS_POP_CANCEL_CLICK(217),
        CHAT_ROOM_OUT_GOODS_NOT_ENOUGH_SHOW(218),
        CHAT_ROOM_HANG_WARN_SHOW(219),
        CHAT_ROOM_HANG_WARN_IGNORE_CLICK(220),
        CHAT_ROOM_HANG_WARN_CLOSE_CLICK(221),
        CHAT_ROOM_BOX_PK_CLICK(222),
        CHAT_ROOM_PK_CREATE_PK_PAGE_SHOW(223),
        CHAT_ROOM_PK_CREATE_LEVEL_PAGE_SHOW(224),
        CHAT_ROOM_PK_CREATE_MATCH_CLICK(225),
        CHAT_ROOM_PK_CREATE_INVITE_CLICK(226),
        CHAT_ROOM_PK_CREATE_USER_INVITE_CLICK(227),
        CHAT_ROOM_PK_MATCH_SUCCESS_SHOW(228),
        CHAT_ROOM_PK_INVITE_SUCCESS_SHOW(229),
        CHAT_ROOM_RECOMMEND_SECOND_CLICK(230),
        CHAT_ROOM_GIFT_RESOURCE_CLICK(231),
        CHAT_ROOM_GIFT_RECEIVE_CLICK(232),
        CHAT_ROOM_GIFT_POP_RECEIVE_CLICK(233),
        CHAT_ROOM_HALL_REDBAG_POP_SHOW(234),
        CHAT_ROOM_HALL_REDBAG_POP_CLICK(235),
        CHAT_ROOM_REDBAG_PAGE_RECEIVE_CLICK(236),
        CHAT_ROOM_KTV_SONG_TAB_SHOW(237),
        CHAT_ROOM_KTV_SONG_QUEUE_CLICK(238),
        CHAT_ROOM_KTV_SONG_SEARCH(239),
        CHAT_ROOM_KTV_SONG_GIVE_UP_CLICK(240),
        CHAT_ROOM_KTV_SONG_ACCOMPANIMENT_CLICK(241),
        CHAT_ROOM_KTV_SONG_SING_CLICK(242),
        CHAT_ROOM_KTV_SONG_TONE_CLICK(243),
        CHAT_ROOM_KTV_SONG_TURN_POP_SHOW(244),
        CHAT_ROOM_KTV_TURN_POP_GIVE_UP_CLICK(245),
        CHAT_ROOM_KTV_TURN_POP_GIVE_UP_TIMEOUT(246),
        CHAT_ROOM_KTV_TURN_POP_START_CLICK(247),
        CHAT_ROOM_KTV_SONG_PLAY(248),
        CHAT_ROOM_TASK_ICON_CLICK(249),
        CHAT_ROOM_TASK_REWARD_CLICK(250),
        CHAT_ROOM_FANS_ENTER_CLICK(251),
        CHAT_ROOM_FANS_PANEL_SHOW(252),
        CHAT_ROOM_FANS_PANEL_JOIN_CLICK(253),
        CHAT_ROOM_GIFT_PANEL_JOIN_CLICK(254),
        CHAT_ROOM_GUIDE_POP_SHOW(255),
        CHAT_ROOM_GUIDE_POP_JOIN_CLICK(256),
        CHAT_ROOM_FOLLOW_OPEN_SHOW(257),
        CHAT_ROOM_KTV_GUIDE_SONG_POP_SHOW(258),
        CHAT_ROOM_KTV_GUIDE_SONG_POP_GO_CLICK(259),
        CHAT_ROOM_KTV_GUIDE_SONG_POP_IGNORE_CLICK(260),
        CHAT_ROOM_KTV_GUIDE_MSG_SHOW(261),
        CHAT_ROOM_KTV_GUIDE_MSG_GO_CLICK(262),
        CHAT_ROOM_KTV_NO_MIKE_SONG_CLICK(263),
        CHAT_ROOM_KTV_NO_MIKE_GUIDE_POP_SHOW(264),
        CHAT_ROOM_KTV_NO_MIKE_GUIDE_POP_GO_CLICK(265),
        CHAT_ROOM_KTV_NO_MIKE_GUIDE_POP_IGNORE_CLICK(266),
        CHAT_ROOM_NEW_GIFT_POP_SHOW(267),
        CHAT_ROOM_NEW_GIFT_POP_GET_CLICK(268),
        CHAT_ROOM_NEW_GIFT_GET_SUCCESS(269),
        CHAT_ROOM_NEW_GIFT_PROP_CLICK(270),
        CHAT_ROOM_PROFILE_RELATION_CLICK(271),
        CHAT_ROOM_PROFILE_HONOR_LEVEL_CLICK(272),
        CHAT_ROOM_PROFILE_CLUB_CLICK(273),
        CHAT_ROOM_PROFILE_MEDAL_CLICK(274),
        CHAT_ROOM_PROFILE_MEDAL_ONE_CLICK(275),
        CHAT_ROOM_HALL_HEAD_ICON_CLICK(276),
        CHAT_ROOM_HALL_BTN_CLICK(277),
        CHAT_ROOM_BOX_RAIN_CLICK(278),
        CHAT_ROOM_BOX_RAIN_QUESTION_CLICK(279),
        CHAT_ROOM_BOX_RAIN_FALL(280),
        CHAT_ROOM_ANCHOR_LEVEL_ENTER_SHOW(281),
        CHAT_ROOM_ANCHOR_LEVEL_ENTER_CLICK(282),
        CHAT_ROOM_COOL_STAGE_CLICK(283),
        CHAT_ROOM_COOL_STAGE_SING_END_POP_SHOW(286),
        CHAT_ROOM_BG_MUSIC_ENTRANCE_SHOW(289),
        CHAT_ROOM_BG_MUSIC_ENTRANCE_CLICK(290),
        CHAT_ROOM_BG_MUSIC_ONE_PLAY_CLICK(291),
        CHAT_ROOM_GIFT_POP_ALL_CLICK(292),
        CHAT_ROOM_WISH_RESET_CLICK(293),
        CHAT_ROOM_WISH_RESET_NO_CLICK(294),
        CHAT_ROOM_WISH_RESET_YES_CLICK(295),
        CHAT_ROOM_BOSS_SEAT_POP_SHOW(296),
        CHAT_ROOM_BOSS_SEAT_POP_GIFT_SEND_CLICK(297),
        YY_GIFT_WALL_PAGE_SHOW(298),
        YY_GIFT_WALL_PAGE_UNLOCK_CLICK(299),
        YY_GIFT_WALL_PAGE_REWARD_CLICK(300),
        YY_GIFT_WALL_PAGE_GIFT_POP_SHOW(301),
        YY_GIFT_WALL_PAGE_GIFT_POP_SEND_CLICK(302),
        YY_GIFT_WALL_PAGE_REWARD_POP_SHOW(303),
        YY_DOWN_EXCHANGE_CLICK(304),
        YY_EXCHANGE_PAGE_TWELVE_CLICK(305),
        YY_TWELVE_POP_NOW_CLICK(306),
        CHAT_ROOM_KTV_SONG_LIST_SHOW(307),
        CHAT_ROOM_KTV_SONG_LIST_TOP_CLICK(308),
        CHAT_ROOM_KTV_SONG_LIST_SING_CLICK(309),
        CHAT_ROOM_FANS_EDIT_CLICK(310),
        CHAT_ROOM_FANS_EDIT_SUBMIT_CLICK(311),
        YY_SETTINGS_PAGE_SHOW(312),
        ANCHOR_REPORT_FORM_PAGE_MORE_CLICK(313),
        ANCHOR_REPORT_FORM_PAGE_MORE_YY_CLICK(314),
        YY_TOPIC_CLICK(315),
        YY_TOPIC_SETTINGS_DONE_CLICK(316),
        YY_PK_ENTRANCE_CLICK(317),
        YY_BOX_ENTRANCE_CLICK(318),
        YY_BOX_SHOW(319),
        YY_PK_RANDOM_CLICK(320),
        YY_PK_INVITE_CLICK(321),
        YY_PK_CANCEL_CLICK(322),
        YY_PK_CONNECT_SUCCESS(323),
        YY_PK_CONNECT_FAIL(324),
        YY_PK_INVITE_POP_SHOW(325),
        YY_PK_INVITE_POP_REJECT_CLICK(326),
        YY_PK_INVITE_POP_PK_CLICK(327),
        CHAT_ROOM_HOT_BANNER_SHOW(328),
        CHAT_ROOM_HOT_BANNER_CLICK(329),
        CHAT_ROOM_HOT_RESOURCE_SHOW(330),
        CHAT_ROOM_HOT_RESOURCE_CLICK(331),
        YY_HALL_TOP_FAST_ROOM_SHOW(332),
        YY_HALL_TOP_FAST_ROOM_CLICK(333),
        YY_HALL_TOP_PLAZA_SHOW(334),
        YY_HALL_TOP_PLAZA_CLICK(335),
        YY_HALL_TOP_TOPIC_SHOW(336),
        YY_HALL_TOP_TOPIC_CLICK(337),
        YY_HALL_TAB_ADD_SHOW(338),
        YY_HALL_TAB_ADD_CLICK(339),
        YY_HALL_CREATE_SHOW(340),
        YY_HALL_CREATE_CLICK(341),
        YY_HALL_RANDOM_SHOW(342),
        YY_HALL_RANDOM_CLICK(343),
        YY_RES_SHOW(344),
        YY_RES_CLICK(345),
        YY_BROADCAST_SHOW(346),
        YY_BROADCAST_CLICK(347),
        YY_ROOM_STAR_SHOW(348),
        YY_ROOM_STAR_CLICK(349),
        YY_ROOM_BOX_REDBAG_SHOW(350),
        YY_ROOM_BOX_REDBAG_CLICK(351),
        YY_ROOM_REDBAG_PAGE_SHOW(352),
        YY_ROOM_REDBAG_PAGE_RULE_CLICK(353),
        YY_ROOM_REDBAG_PAGE_SEND_CLICK(354),
        YY_HALL_REDBAG_SHOW(355),
        YY_HALL_REDBAG_CLICK(356),
        YY_REDBAG_PAGE_GET_CLICK(357),
        YY_ROOM_REDBAG_SHOW(358),
        YY_ROOM_REDBAG_CLICK(359),
        YY_ROOM_REDBAG_FOLLOW_GET_CLICK(360),
        YY_ROOM_REDBAG_GET_CLICK(361),
        YY_HALL_RANK_CLICK(362),
        YY_HALL_RANK_PAGE_GUILD_CLICK(363),
        YY_ROB_SING_START_CLICK(364),
        YY_ROB_SING_END_CLICK(365),
        YY_ROB_SING_SONG_CLICK(366),
        YY_ROB_SING_FOLLOW_CLICK(367),
        YY_ROB_SING_LIGHT_CLICK(368),
        YY_ROB_SING_FLOWER_CLICK(369),
        YY_ROB_SING_FLOWER_SEND_CLICK(370),
        YY_DING_TOAST_SHOW(371),
        YY_DING_TOAST_CLICK(372),
        YY_FIRST_MEET_POP_SHOW(373),
        YY_FIRST_MEET_POP_CLICK(374),
        YY_FIRST_MEET_SUCCESS_POP_SHOW(375),
        YY_FIRST_MEET_SUCCESS_POP_GIFT_GO_CLICK(376),
        YY_FIRST_MEET_SUCCESS_POP_MEDAL_GO_CLICK(377),
        YY_FIRST_MEET_SUCCESS_POP_FRAME_GO_CLICK(378),
        YY_VOICE_POP_SHOW(379),
        YY_VOICE_POP_NO_CLICK(380),
        CHAT_ROOM_BOX_ANCHOR_GROWTH_PLAN_CLICK(381),
        CHAT_ROOM_BOX_MADE_CAR_CLICK(382),
        CHAT_ROOM_PROFILE_MADE_CAR_SHOW(383),
        CHAT_ROOM_PROFILE_MADE_CAR_CLICK(384),
        YY_GIFT_MADE_CAR_GO_SHOW(385),
        YY_GIFT_MADE_CAR_GO_CLICK(386),
        YY_MADE_CAR_PAGE_CAR_TAB_CLICK(387),
        YY_MADE_CAR_PAGE_HALL_TAB_CLICK(388),
        YY_MADE_CAR_PAGE_MORE_CLICK(389),
        YY_MADE_CAR_PAGE_RULE_CLICK(390),
        YY_MADE_CAR_PAGE_RECORD_CLICK(YY_MADE_CAR_PAGE_RECORD_CLICK_VALUE),
        YY_MADE_CAR_PAGE_SEND_CLICK(392),
        YY_PROFILE_PAGE_SHOW(393),
        YY_PROFILE_PAGE_LIFT_MASK_CLICK(394),
        YY_LIFT_MASK_POP_SHOW(YY_LIFT_MASK_POP_SHOW_VALUE),
        YY_LIFT_MASK_POP_CANCEL_CLICK(YY_LIFT_MASK_POP_CANCEL_CLICK_VALUE),
        YY_LIFT_MASK_POP_USE_CLICK(YY_LIFT_MASK_POP_USE_CLICK_VALUE),
        YY_LIFT_MASK_USER_POP_SHOW(YY_LIFT_MASK_USER_POP_SHOW_VALUE),
        YY_LIFT_MASK_USER_POP_YES_CLICK(399),
        YY_LIFT_MASK_SECOND_POP_SHOW(400),
        YY_LIFT_MASK_SECOND_POP_YES_CLICK(401),
        YY_LIFT_MASK_SECOND_POP_NO_CLICK(402),
        YY_LIFT_MASK_SUCCESS(403),
        YY_PROFILE_RELATION_SHOW(404),
        YY_PROFILE_RELATION_CLICK(405),
        YY_GIFT_WALL_EXHIBITION_PAGE_SHOW(406),
        YY_GIFT_WALL_EXHIBITION_PAGE_ALL_CLICK(407),
        YY_GIFT_WALL_EXHIBITION_PAGE_STAR_CLICK(408),
        YY_BOX_RELATION_SHOW(409),
        YY_BOX_RELATION_CLICK(410),
        YY_RELATION_ROOM_QA_CLICK(411),
        YY_RELATION_ROOM_RANKING_CLICK(412),
        YY_RELATION_HIDE_REMOVE_POP_SHOW(413),
        YY_RELATION_HIDE_REMOVE_POP_HIDE_CLICK(414),
        YY_RELATION_HIDE_REMOVE_POP_REMOVE_CLICK(415),
        YY_RELATION_MINE_CLICK(416),
        YY_RELATION_ALL_CLICK(417),
        YY_RELATION_USER_INVITE_CLICK(418),
        YY_RELATION_USER_INVITE_YES_CLICK(419),
        YY_RELATION_USER_INVITE_POP_SHOW(420),
        YY_RELATION_USER_INVITE_POP_AGREE_CLICK(421),
        YY_RELATION_USER_INVITE_POP_DISAGREE_CLICK(422),
        YY_RELATION_GUIDE_MSG_SHOW(423),
        YY_RELATION_GUIDE_MSG_CLICK(424),
        CHAT_ROOM_BOX_CREATE_PRE_CLICK(425),
        YY_NEW_WEEK_SHOW(426),
        YY_NEW_WEEK_CLICK(427),
        YY_SUPER_STAR_WEEK_SHOW(428),
        YY_SUPER_STAR_WEEK_CLICK(429),
        YY_CREATE_PRE_DONE_CLICK(430),
        YY_CREATE_PRE_QA_CLICK(431),
        YY_PRE_POP_SHOW(432),
        YY_PRE_POP_DETAIL_CLICK(433),
        YY_CELEBRATION_ENTER_SHOW(434),
        YY_CELEBRATION_ENTER_CLICK(435),
        YY_CELEBRATION_KNOW_CLICK(436),
        YY_CELEBRATION_PRE_FEED_CLICK(437),
        YY_CELEBRATION_PRE_FEED_CANCEL_CLICK(438),
        YY_ROMANTIC_PAGE_SHOW(439),
        YY_ROMANTIC_HANDBOOK_PAGE_SHOW(440),
        YY_ROMANTIC_ALL_HANDBOOK_PAGE_SHOW(441),
        YY_ROMANTIC_RULE_PAGE_SHOW(442),
        YY_ROMANTIC_LIGHT_PAGE_GO_CLICK(444),
        YY_LOVE_GIFT_BAR_SHOW(445),
        YY_LOVE_GIFT_PAGE_SHOW(446),
        YY_LOVE_GIFT_PAGE_QA_CLICK(447),
        YY_LOVE_GIFT_PAGE_ONE_SEND_CLICK(448),
        YY_ROOM_BOX_SET_GIFT_SHOW(449),
        YY_ROOM_BOX_SET_GIFT_CLICK(450),
        YY_SHOW_LOVE_TOP_PAGE_SHOW(451),
        YY_SHOW_LOVE_TOP_PAGE_TO_CLICK(452),
        YY_TOP_SHOW_LOVE_PAGE_TO_CLICK(453),
        YY_SHOW_LOVE_TOP_WEEK_TIME_PAGE_SHOW(454),
        YY_SHOW_LOVE_TOP_WEEK_SCORE_PAGE_SHOW(455),
        YY_SHOW_LOVE_TOP_ALL_TIME_PAGE_SHOW(456),
        YY_SHOW_LOVE_TOP_ALL_SCORE_PAGE_SHOW(457),
        UNRECOGNIZED(-1);
        
        public static final int ANCHOR_REPORT_FORM_PAGE_MORE_CLICK_VALUE = 313;
        public static final int ANCHOR_REPORT_FORM_PAGE_MORE_YY_CLICK_VALUE = 314;
        public static final int CHAT_END_PAGE_LIVING_USER_CLICK_VALUE = 142;
        public static final int CHAT_END_PAGE_LIVING_USER_SHOW_VALUE = 141;
        public static final int CHAT_ROOM_ACCEPT_CLICK_VALUE = 36;
        public static final int CHAT_ROOM_ACTIVITY_CLICK_VALUE = 156;
        public static final int CHAT_ROOM_ANCHOR_LEVEL_CLICK_VALUE = 177;
        public static final int CHAT_ROOM_ANCHOR_LEVEL_ENTER_CLICK_VALUE = 282;
        public static final int CHAT_ROOM_ANCHOR_LEVEL_ENTER_SHOW_VALUE = 281;
        public static final int CHAT_ROOM_APPROVE_GUIDE_CLICK_VALUE = 27;
        public static final int CHAT_ROOM_APPROVE_GUIDE_SHOW_VALUE = 26;
        public static final int CHAT_ROOM_AUCTION_APPLY_CLICK_VALUE = 168;
        public static final int CHAT_ROOM_AUCTION_APPLY_FALSE_CLICK_VALUE = 170;
        public static final int CHAT_ROOM_AUCTION_APPLY_LIST_AGREE_CLICK_VALUE = 172;
        public static final int CHAT_ROOM_AUCTION_APPLY_LIST_CANCEL_CLICK_VALUE = 171;
        public static final int CHAT_ROOM_AUCTION_APPLY_LIST_REFUSE_CLICK_VALUE = 173;
        public static final int CHAT_ROOM_AUCTION_APPLY_TRUE_CLICK_VALUE = 169;
        public static final int CHAT_ROOM_AUCTION_RELATION_TRUE_CLICK_VALUE = 174;
        public static final int CHAT_ROOM_BACK_INTERACT_CLICK_VALUE = 211;
        public static final int CHAT_ROOM_BANNER1_CLICK_VALUE = 145;
        public static final int CHAT_ROOM_BANNER1_SHOW_VALUE = 144;
        public static final int CHAT_ROOM_BANNER2_CLICK_VALUE = 147;
        public static final int CHAT_ROOM_BANNER2_SHOW_VALUE = 146;
        public static final int CHAT_ROOM_BANNER_CLICK_VALUE = 29;
        public static final int CHAT_ROOM_BANNER_SHOW_VALUE = 28;
        public static final int CHAT_ROOM_BG_ENTER_CLICK_VALUE = 109;
        public static final int CHAT_ROOM_BG_MUSIC_ENTRANCE_CLICK_VALUE = 290;
        public static final int CHAT_ROOM_BG_MUSIC_ENTRANCE_SHOW_VALUE = 289;
        public static final int CHAT_ROOM_BG_MUSIC_ONE_PLAY_CLICK_VALUE = 291;
        public static final int CHAT_ROOM_BG_SOMEONE_CLICK_VALUE = 110;
        public static final int CHAT_ROOM_BOSS_SEAT_POP_GIFT_SEND_CLICK_VALUE = 297;
        public static final int CHAT_ROOM_BOSS_SEAT_POP_SHOW_VALUE = 296;
        public static final int CHAT_ROOM_BOX_ANCHOR_GROWTH_PLAN_CLICK_VALUE = 381;
        public static final int CHAT_ROOM_BOX_CREATE_PRE_CLICK_VALUE = 425;
        public static final int CHAT_ROOM_BOX_MADE_CAR_CLICK_VALUE = 382;
        public static final int CHAT_ROOM_BOX_PK_CLICK_VALUE = 222;
        public static final int CHAT_ROOM_BOX_RAIN_CLICK_VALUE = 278;
        public static final int CHAT_ROOM_BOX_RAIN_FALL_VALUE = 280;
        public static final int CHAT_ROOM_BOX_RAIN_QUESTION_CLICK_VALUE = 279;
        public static final int CHAT_ROOM_CAROUSEL_SHOW_VALUE = 157;
        public static final int CHAT_ROOM_CHANGE_MIC_BTN_CLICK_VALUE = 137;
        public static final int CHAT_ROOM_COOL_STAGE_CLICK_VALUE = 283;
        public static final int CHAT_ROOM_COOL_STAGE_SING_END_POP_SHOW_VALUE = 286;
        public static final int CHAT_ROOM_CP_MATCH_START_VALUE = 128;
        public static final int CHAT_ROOM_CP_MATCH_SUCCEED_VALUE = 129;
        public static final int CHAT_ROOM_CREATE_CLICK_VALUE = 11;
        public static final int CHAT_ROOM_CREATE_CONFIRM_CLICK_VALUE = 12;
        public static final int CHAT_ROOM_CREATE_SHOW_VALUE = 10;
        public static final int CHAT_ROOM_CREATE_UPLOAD_COVER_CLICK_VALUE = 212;
        public static final int CHAT_ROOM_EMOJI_ENTER_CLICK_VALUE = 103;
        public static final int CHAT_ROOM_ENTER_APPROVE_CLICK_VALUE = 90;
        public static final int CHAT_ROOM_ENTER_CLICK_VALUE = 6;
        public static final int CHAT_ROOM_EXIT_BTN_CLICK_VALUE = 40;
        public static final int CHAT_ROOM_EXIT_ROOM_VALUE = 192;
        public static final int CHAT_ROOM_FANS_EDIT_CLICK_VALUE = 310;
        public static final int CHAT_ROOM_FANS_EDIT_SUBMIT_CLICK_VALUE = 311;
        public static final int CHAT_ROOM_FANS_ENTER_CLICK_VALUE = 251;
        public static final int CHAT_ROOM_FANS_PANEL_JOIN_CLICK_VALUE = 253;
        public static final int CHAT_ROOM_FANS_PANEL_SHOW_VALUE = 252;
        public static final int CHAT_ROOM_FOLLOW_ALL_PAGE_SHOW_VALUE = 143;
        public static final int CHAT_ROOM_FOLLOW_ANCHOR_GUIDE_CLICK_VALUE = 207;
        public static final int CHAT_ROOM_FOLLOW_ANCHOR_GUIDE_SHOW_VALUE = 206;
        public static final int CHAT_ROOM_FOLLOW_CLICK_VALUE = 42;
        public static final int CHAT_ROOM_FOLLOW_GUIDE_FOLLOW_CLICK_VALUE = 46;
        public static final int CHAT_ROOM_FOLLOW_GUIDE_SHOW_VALUE = 45;
        public static final int CHAT_ROOM_FOLLOW_MORE_CLICK_VALUE = 100;
        public static final int CHAT_ROOM_FOLLOW_OPEN_SHOW_VALUE = 257;
        public static final int CHAT_ROOM_FOLLOW_ROOM_CLICK_VALUE = 102;
        public static final int CHAT_ROOM_FOLLOW_ROOM_SHOW_VALUE = 101;
        public static final int CHAT_ROOM_GAME_ADD_CLICK_VALUE = 165;
        public static final int CHAT_ROOM_GAME_DELETE_CLICK_VALUE = 166;
        public static final int CHAT_ROOM_GAME_ROB_CLICK_VALUE = 164;
        public static final int CHAT_ROOM_GAME_START_CLICK_VALUE = 163;
        public static final int CHAT_ROOM_GIFT_ACTIVITY_CLICK_VALUE = 199;
        public static final int CHAT_ROOM_GIFT_ACTIVITY_SHOW_VALUE = 198;
        public static final int CHAT_ROOM_GIFT_CLICK_VALUE = 81;
        public static final int CHAT_ROOM_GIFT_GET_LIST_CLICK_VALUE = 148;
        public static final int CHAT_ROOM_GIFT_LEVEL_GUIDE_ICON_CLICK_VALUE = 176;
        public static final int CHAT_ROOM_GIFT_MORE_HIT_CLICK_VALUE = 167;
        public static final int CHAT_ROOM_GIFT_PAGE_BAG_CLICK_VALUE = 155;
        public static final int CHAT_ROOM_GIFT_PAGE_GIFT_CLICK_VALUE = 154;
        public static final int CHAT_ROOM_GIFT_PANEL_JOIN_CLICK_VALUE = 254;
        public static final int CHAT_ROOM_GIFT_POP_ALL_CLICK_VALUE = 292;
        public static final int CHAT_ROOM_GIFT_POP_ONE_GIFT_CLICK_VALUE = 112;
        public static final int CHAT_ROOM_GIFT_POP_ONE_GIFT_SHOW_VALUE = 111;
        public static final int CHAT_ROOM_GIFT_POP_RECEIVE_CLICK_VALUE = 233;
        public static final int CHAT_ROOM_GIFT_POP_SEND_CLICK_VALUE = 85;
        public static final int CHAT_ROOM_GIFT_POP_SHOW_VALUE = 84;
        public static final int CHAT_ROOM_GIFT_RECEIVE_CLICK_VALUE = 232;
        public static final int CHAT_ROOM_GIFT_RESOURCE_CLICK_VALUE = 231;
        public static final int CHAT_ROOM_GIFT_SEND_LIST_CLICK_VALUE = 149;
        public static final int CHAT_ROOM_GUIDE_POP_JOIN_CLICK_VALUE = 256;
        public static final int CHAT_ROOM_GUIDE_POP_SHOW_VALUE = 255;
        public static final int CHAT_ROOM_HALL_BTN_CLICK_VALUE = 277;
        public static final int CHAT_ROOM_HALL_HEAD_ICON_CLICK_VALUE = 276;
        public static final int CHAT_ROOM_HALL_REDBAG_POP_CLICK_VALUE = 235;
        public static final int CHAT_ROOM_HALL_REDBAG_POP_SHOW_VALUE = 234;
        public static final int CHAT_ROOM_HANG_WARN_CLOSE_CLICK_VALUE = 221;
        public static final int CHAT_ROOM_HANG_WARN_IGNORE_CLICK_VALUE = 220;
        public static final int CHAT_ROOM_HANG_WARN_SHOW_VALUE = 219;
        public static final int CHAT_ROOM_HEART_BEAT_VIP_CLICK_VALUE = 178;
        public static final int CHAT_ROOM_HEART_BEAT_VIP_SUCCESS_VALUE = 179;
        public static final int CHAT_ROOM_HOME_PAGE_TAB_SHOW_VALUE = 7;
        public static final int CHAT_ROOM_HOST_DISCIPLINE_CLOSE_CLICK_VALUE = 134;
        public static final int CHAT_ROOM_HOT_BANNER_CLICK_VALUE = 329;
        public static final int CHAT_ROOM_HOT_BANNER_SHOW_VALUE = 328;
        public static final int CHAT_ROOM_HOT_RESOURCE_CLICK_VALUE = 331;
        public static final int CHAT_ROOM_HOT_RESOURCE_SHOW_VALUE = 330;
        public static final int CHAT_ROOM_INSTRUCTION_VALUE = 127;
        public static final int CHAT_ROOM_INTERACT_CLICK_VALUE = 210;
        public static final int CHAT_ROOM_INVITE_CLICK_VALUE = 30;
        public static final int CHAT_ROOM_INVITE_POP_SHOW_VALUE = 34;
        public static final int CHAT_ROOM_KICK_OUT_CLICK_VALUE = 31;
        public static final int CHAT_ROOM_KICK_OUT_CONFIRM_CLICK_VALUE = 32;
        public static final int CHAT_ROOM_KTV_GUIDE_MSG_GO_CLICK_VALUE = 262;
        public static final int CHAT_ROOM_KTV_GUIDE_MSG_SHOW_VALUE = 261;
        public static final int CHAT_ROOM_KTV_GUIDE_SONG_POP_GO_CLICK_VALUE = 259;
        public static final int CHAT_ROOM_KTV_GUIDE_SONG_POP_IGNORE_CLICK_VALUE = 260;
        public static final int CHAT_ROOM_KTV_GUIDE_SONG_POP_SHOW_VALUE = 258;
        public static final int CHAT_ROOM_KTV_NO_MIKE_GUIDE_POP_GO_CLICK_VALUE = 265;
        public static final int CHAT_ROOM_KTV_NO_MIKE_GUIDE_POP_IGNORE_CLICK_VALUE = 266;
        public static final int CHAT_ROOM_KTV_NO_MIKE_GUIDE_POP_SHOW_VALUE = 264;
        public static final int CHAT_ROOM_KTV_NO_MIKE_SONG_CLICK_VALUE = 263;
        public static final int CHAT_ROOM_KTV_SONG_ACCOMPANIMENT_CLICK_VALUE = 241;
        public static final int CHAT_ROOM_KTV_SONG_GIVE_UP_CLICK_VALUE = 240;
        public static final int CHAT_ROOM_KTV_SONG_LIST_SHOW_VALUE = 307;
        public static final int CHAT_ROOM_KTV_SONG_LIST_SING_CLICK_VALUE = 309;
        public static final int CHAT_ROOM_KTV_SONG_LIST_TOP_CLICK_VALUE = 308;
        public static final int CHAT_ROOM_KTV_SONG_PLAY_VALUE = 248;
        public static final int CHAT_ROOM_KTV_SONG_QUEUE_CLICK_VALUE = 238;
        public static final int CHAT_ROOM_KTV_SONG_SEARCH_VALUE = 239;
        public static final int CHAT_ROOM_KTV_SONG_SING_CLICK_VALUE = 242;
        public static final int CHAT_ROOM_KTV_SONG_TAB_SHOW_VALUE = 237;
        public static final int CHAT_ROOM_KTV_SONG_TONE_CLICK_VALUE = 243;
        public static final int CHAT_ROOM_KTV_SONG_TURN_POP_SHOW_VALUE = 244;
        public static final int CHAT_ROOM_KTV_TURN_POP_GIVE_UP_CLICK_VALUE = 245;
        public static final int CHAT_ROOM_KTV_TURN_POP_GIVE_UP_TIMEOUT_VALUE = 246;
        public static final int CHAT_ROOM_KTV_TURN_POP_START_CLICK_VALUE = 247;
        public static final int CHAT_ROOM_LIKE_CLICK_VALUE = 80;
        public static final int CHAT_ROOM_LIST_CLICK_VALUE = 72;
        public static final int CHAT_ROOM_LIST_PAGE_GET_SHOW_VALUE = 73;
        public static final int CHAT_ROOM_LIST_PAGE_SEND_SHOW_VALUE = 74;
        public static final int CHAT_ROOM_MANAGER_MAX_SHOW_VALUE = 39;
        public static final int CHAT_ROOM_MIKE_CLICK_VALUE = 53;
        public static final int CHAT_ROOM_MIKE_CONFIRM_CLICK_VALUE = 55;
        public static final int CHAT_ROOM_MIKE_POP_ACCEPT_CLICK_VALUE = 60;
        public static final int CHAT_ROOM_MIKE_POP_AUTO_SUCCESS_VALUE = 61;
        public static final int CHAT_ROOM_MIKE_POP_REFUSE_CLICK_VALUE = 59;
        public static final int CHAT_ROOM_MIKE_POP_SHOW_VALUE = 58;
        public static final int CHAT_ROOM_MIKE_REFUSE_SHOW_VALUE = 57;
        public static final int CHAT_ROOM_MIKE_SUCCESS_SHOW_VALUE = 56;
        public static final int CHAT_ROOM_MIKE_USER_ACCEPT_CLICK_VALUE = 63;
        public static final int CHAT_ROOM_MIKE_USER_REFUSE_CLICK_VALUE = 62;
        public static final int CHAT_ROOM_MINE_ENTER_SHOW_VALUE = 5;
        public static final int CHAT_ROOM_MINE_REPORT_CLICK_VALUE = 4;
        public static final int CHAT_ROOM_MINE_REPORT_SHOW_VALUE = 3;
        public static final int CHAT_ROOM_MINIMIZED_WINDOW_CLICK_VALUE = 122;
        public static final int CHAT_ROOM_MUTE_BTN_CLICK_VALUE = 135;
        public static final int CHAT_ROOM_MUTE_CLICK_VALUE = 33;
        public static final int CHAT_ROOM_NAME_CHANGE_CLICK_VALUE = 88;
        public static final int CHAT_ROOM_NAME_INVALITE_SHOW_VALUE = 13;
        public static final int CHAT_ROOM_NEW_GIFT_GET_SUCCESS_VALUE = 269;
        public static final int CHAT_ROOM_NEW_GIFT_POP_GET_CLICK_VALUE = 268;
        public static final int CHAT_ROOM_NEW_GIFT_POP_SHOW_VALUE = 267;
        public static final int CHAT_ROOM_NEW_GIFT_PROP_CLICK_VALUE = 270;
        public static final int CHAT_ROOM_NEW_GUIDE_POP_CLOSE_CLICK_VALUE = 202;
        public static final int CHAT_ROOM_NEW_GUIDE_POP_SHOW_VALUE = 201;
        public static final int CHAT_ROOM_NOTICE_CANCEL_CLICK_VALUE = 93;
        public static final int CHAT_ROOM_NOTICE_CLICK_VALUE = 91;
        public static final int CHAT_ROOM_NOTICE_SAVE_CLICK_VALUE = 92;
        public static final int CHAT_ROOM_OUT_GOODS_CLICK_VALUE = 215;
        public static final int CHAT_ROOM_OUT_GOODS_NOT_ENOUGH_SHOW_VALUE = 218;
        public static final int CHAT_ROOM_OUT_GOODS_POP_CANCEL_CLICK_VALUE = 217;
        public static final int CHAT_ROOM_OUT_GOODS_POP_SEND_CLICK_VALUE = 216;
        public static final int CHAT_ROOM_OUT_GOODS_SHOW_VALUE = 214;
        public static final int CHAT_ROOM_OUT_MIKE_VALUE = 37;
        public static final int CHAT_ROOM_OWNER_CUSTOM_CLICK_VALUE = 191;
        public static final int CHAT_ROOM_OWNER_DOWN_GIFT_CLICK_VALUE = 159;
        public static final int CHAT_ROOM_OWNER_GIFT_CREATE_CLICK_VALUE = 160;
        public static final int CHAT_ROOM_OWNER_GIFT_GUIDE_CLICK_VALUE = 158;
        public static final int CHAT_ROOM_OWNER_OUT_MIKE_TOAST_SHOW_VALUE = 77;
        public static final int CHAT_ROOM_PHONE_BIND_CLICK_VALUE = 89;
        public static final int CHAT_ROOM_PHONE_BIND_CONFIRM_CLICK_VALUE = 139;
        public static final int CHAT_ROOM_PHONE_BIND_SHOW_VALUE = 138;
        public static final int CHAT_ROOM_PK_CLICK_VALUE = 152;
        public static final int CHAT_ROOM_PK_CREATE_INVITE_CLICK_VALUE = 226;
        public static final int CHAT_ROOM_PK_CREATE_LEVEL_PAGE_SHOW_VALUE = 224;
        public static final int CHAT_ROOM_PK_CREATE_MATCH_CLICK_VALUE = 225;
        public static final int CHAT_ROOM_PK_CREATE_PK_PAGE_SHOW_VALUE = 223;
        public static final int CHAT_ROOM_PK_CREATE_USER_INVITE_CLICK_VALUE = 227;
        public static final int CHAT_ROOM_PK_INVITE_SUCCESS_SHOW_VALUE = 229;
        public static final int CHAT_ROOM_PK_MATCH_SUCCESS_SHOW_VALUE = 228;
        public static final int CHAT_ROOM_PROFILE_AT_CLICK_VALUE = 67;
        public static final int CHAT_ROOM_PROFILE_BLACK_CLICK_VALUE = 71;
        public static final int CHAT_ROOM_PROFILE_BLOCK_CLICK_VALUE = 99;
        public static final int CHAT_ROOM_PROFILE_CLUB_CLICK_VALUE = 273;
        public static final int CHAT_ROOM_PROFILE_ENTER_CLICK_VALUE = 2;
        public static final int CHAT_ROOM_PROFILE_ENTER_SHOW_VALUE = 1;
        public static final int CHAT_ROOM_PROFILE_FORBID_CLICK_VALUE = 96;
        public static final int CHAT_ROOM_PROFILE_GIFT_CLICK_VALUE = 69;
        public static final int CHAT_ROOM_PROFILE_GO_CLICK_VALUE = 65;
        public static final int CHAT_ROOM_PROFILE_HONOR_LEVEL_CLICK_VALUE = 272;
        public static final int CHAT_ROOM_PROFILE_MADE_CAR_CLICK_VALUE = 384;
        public static final int CHAT_ROOM_PROFILE_MADE_CAR_SHOW_VALUE = 383;
        public static final int CHAT_ROOM_PROFILE_MEDAL_CLICK_VALUE = 274;
        public static final int CHAT_ROOM_PROFILE_MEDAL_ONE_CLICK_VALUE = 275;
        public static final int CHAT_ROOM_PROFILE_MIKE_CLICK_VALUE = 54;
        public static final int CHAT_ROOM_PROFILE_MSG_CLICK_VALUE = 68;
        public static final int CHAT_ROOM_PROFILE_RELATION_CLICK_VALUE = 271;
        public static final int CHAT_ROOM_PROFILE_REMOVE_FORBID_CLICK_VALUE = 97;
        public static final int CHAT_ROOM_PROFILE_REPORT_CLICK_VALUE = 70;
        public static final int CHAT_ROOM_RANDOM_CLICK_VALUE = 150;
        public static final int CHAT_ROOM_RANDOM_SUCCESS_VALUE = 151;
        public static final int CHAT_ROOM_RECALL_GUIDE_POP_CLOSE_CLICK_VALUE = 204;
        public static final int CHAT_ROOM_RECALL_GUIDE_POP_SHOW_VALUE = 203;
        public static final int CHAT_ROOM_RECHARGE_CLICK_VALUE = 49;
        public static final int CHAT_ROOM_RECOMMEND_SECOND_CLICK_VALUE = 230;
        public static final int CHAT_ROOM_REDBAG_PAGE_RECEIVE_CLICK_VALUE = 236;
        public static final int CHAT_ROOM_REFUSE_CLICK_VALUE = 35;
        public static final int CHAT_ROOM_REPORT_ROOM_CLICK_VALUE = 41;
        public static final int CHAT_ROOM_SEND_GIFT_CLICK_VALUE = 48;
        public static final int CHAT_ROOM_SEND_GIFT_GUIDE_CLICK_VALUE = 209;
        public static final int CHAT_ROOM_SEND_GIFT_GUIDE_SHOW_VALUE = 208;
        public static final int CHAT_ROOM_SEND_GIFT_SHOW_VALUE = 47;
        public static final int CHAT_ROOM_SEND_MSG_CLICK_VALUE = 64;
        public static final int CHAT_ROOM_SET_MANAGER_CLICK_VALUE = 38;
        public static final int CHAT_ROOM_SHARE_CHANNEL_CLICK_VALUE = 52;
        public static final int CHAT_ROOM_SHARE_CLICK_VALUE = 51;
        public static final int CHAT_ROOM_SHARE_TO_FRIEND_CLICK_VALUE = 140;
        public static final int CHAT_ROOM_START_CHAT_SHOW_VALUE = 205;
        public static final int CHAT_ROOM_TAB_PAGE_ROOM_CLICK_VALUE = 9;
        public static final int CHAT_ROOM_TAB_PAGE_ROOM_DRAW_VALUE = 8;
        public static final int CHAT_ROOM_TASK_ICON_CLICK_VALUE = 249;
        public static final int CHAT_ROOM_TASK_REWARD_CLICK_VALUE = 250;
        public static final int CHAT_ROOM_TOOLBOX_ACTIVITY_CLICK_VALUE = 197;
        public static final int CHAT_ROOM_TOOLBOX_CLICK_VALUE = 94;
        public static final int CHAT_ROOM_TOOLBOX_EMOJI_CLICK_VALUE = 95;
        public static final int CHAT_ROOM_TOOLBOX_MUSIC_DONE_CLICK_VALUE = 120;
        public static final int CHAT_ROOM_TOOLBOX_MUSIC_EXIT_CLICK_VALUE = 118;
        public static final int CHAT_ROOM_TOOLBOX_MUSIC_LIKE_CLICK_VALUE = 116;
        public static final int CHAT_ROOM_TOOLBOX_MUSIC_PAUSE_CLICK_VALUE = 117;
        public static final int CHAT_ROOM_TOOLBOX_MUSIC_PLAY_CLICK_VALUE = 113;
        public static final int CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SEARCH_CLICK_VALUE = 115;
        public static final int CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SHOW_VALUE = 114;
        public static final int CHAT_ROOM_TOOLBOX_MUSIC_SOMEONE_CLICK_VALUE = 106;
        public static final int CHAT_ROOM_TOOLBOX_MUSIC_TAB_SHOW_VALUE = 121;
        public static final int CHAT_ROOM_TOOLBOX_PROP_CLICK_VALUE = 200;
        public static final int CHAT_ROOM_UNFOLLOW_VALUE = 44;
        public static final int CHAT_ROOM_UNMUTE_BTN_CLICK_VALUE = 136;
        public static final int CHAT_ROOM_UPLOAD_COVER_YES_CLICK_VALUE = 213;
        public static final int CHAT_ROOM_USER_GIFT_CLICK_VALUE = 161;
        public static final int CHAT_ROOM_USER_GIFT_SEND_CLICK_VALUE = 162;
        public static final int CHAT_ROOM_USER_INVITE_CLICK_VALUE = 107;
        public static final int CHAT_ROOM_USER_LIST_CLICK_VALUE = 190;
        public static final int CHAT_ROOM_USER_OUT_MIKE_TOAST_SHOW_VALUE = 76;
        public static final int CHAT_ROOM_USER_PROFILE_FOLLOW_CLICK_VALUE = 66;
        public static final int CHAT_ROOM_VOTE_CLICK_VALUE = 153;
        public static final int CHAT_ROOM_VOTE_ICON_CLICK_VALUE = 123;
        public static final int CHAT_ROOM_VOTE_LAUNCH_CLICK_VALUE = 124;
        public static final int CHAT_ROOM_VOTE_USER_CLICK_VALUE = 126;
        public static final int CHAT_ROOM_VOTE_WINDOW_CLICK_VALUE = 125;
        public static final int CHAT_ROOM_WARN_POP_SHOW_VALUE = 75;
        public static final int CHAT_ROOM_WISH_RESET_CLICK_VALUE = 293;
        public static final int CHAT_ROOM_WISH_RESET_NO_CLICK_VALUE = 294;
        public static final int CHAT_ROOM_WISH_RESET_YES_CLICK_VALUE = 295;
        public static final int NO_MONEY_POP_RECHARGE_CLICK_VALUE = 87;
        public static final int NO_MONEY_POP_SHOW_VALUE = 86;
        public static final int PROFILE_GIFT_WALL_CLICK_VALUE = 194;
        public static final int PROFILE_GIFT_WALL_DETAIL_GIFT_SEND_CLICK_VALUE = 196;
        public static final int PROFILE_GIFT_WALL_DETAIL_QUESTION_CLICK_VALUE = 195;
        public static final int PROFILE_GIFT_WALL_SHOW_VALUE = 193;
        public static final int SINGLE_ROOM_ACCOMPANY_UNLOCK_VALUE = 183;
        public static final int SINGLE_ROOM_CREATE_VOICE_CLICK_VALUE = 180;
        public static final int SINGLE_ROOM_FANS_UP_SUCCESS_VALUE = 181;
        public static final int SINGLE_ROOM_FIRST_PAY_POP_CLICK_VALUE = 186;
        public static final int SINGLE_ROOM_FIRST_PAY_POP_SHOW_VALUE = 185;
        public static final int SINGLE_ROOM_GIFT_SEND_CLICK_VALUE = 182;
        public static final int SINGLE_ROOM_PAY_ICON_CLICK_VALUE = 184;
        public static final int SINGLE_ROOM_PAY_SIX_POP_CLICK_VALUE = 188;
        public static final int SINGLE_ROOM_PAY_SIX_POP_NOW_RECHARGE_CLICK_VALUE = 189;
        public static final int SINGLE_ROOM_PAY_SIX_POP_SHOW_VALUE = 187;
        public static final int UNKNOWN_EVENT_VALUE = 0;
        public static final int YY_BOX_ENTRANCE_CLICK_VALUE = 318;
        public static final int YY_BOX_RELATION_CLICK_VALUE = 410;
        public static final int YY_BOX_RELATION_SHOW_VALUE = 409;
        public static final int YY_BOX_SHOW_VALUE = 319;
        public static final int YY_BROADCAST_CLICK_VALUE = 347;
        public static final int YY_BROADCAST_SHOW_VALUE = 346;
        public static final int YY_CELEBRATION_ENTER_CLICK_VALUE = 435;
        public static final int YY_CELEBRATION_ENTER_SHOW_VALUE = 434;
        public static final int YY_CELEBRATION_KNOW_CLICK_VALUE = 436;
        public static final int YY_CELEBRATION_PRE_FEED_CANCEL_CLICK_VALUE = 438;
        public static final int YY_CELEBRATION_PRE_FEED_CLICK_VALUE = 437;
        public static final int YY_CREATE_PRE_DONE_CLICK_VALUE = 430;
        public static final int YY_CREATE_PRE_QA_CLICK_VALUE = 431;
        public static final int YY_DING_TOAST_CLICK_VALUE = 372;
        public static final int YY_DING_TOAST_SHOW_VALUE = 371;
        public static final int YY_DOWN_EXCHANGE_CLICK_VALUE = 304;
        public static final int YY_EXCHANGE_PAGE_TWELVE_CLICK_VALUE = 305;
        public static final int YY_FIRST_MEET_POP_CLICK_VALUE = 374;
        public static final int YY_FIRST_MEET_POP_SHOW_VALUE = 373;
        public static final int YY_FIRST_MEET_SUCCESS_POP_FRAME_GO_CLICK_VALUE = 378;
        public static final int YY_FIRST_MEET_SUCCESS_POP_GIFT_GO_CLICK_VALUE = 376;
        public static final int YY_FIRST_MEET_SUCCESS_POP_MEDAL_GO_CLICK_VALUE = 377;
        public static final int YY_FIRST_MEET_SUCCESS_POP_SHOW_VALUE = 375;
        public static final int YY_GIFT_MADE_CAR_GO_CLICK_VALUE = 386;
        public static final int YY_GIFT_MADE_CAR_GO_SHOW_VALUE = 385;
        public static final int YY_GIFT_WALL_EXHIBITION_PAGE_ALL_CLICK_VALUE = 407;
        public static final int YY_GIFT_WALL_EXHIBITION_PAGE_SHOW_VALUE = 406;
        public static final int YY_GIFT_WALL_EXHIBITION_PAGE_STAR_CLICK_VALUE = 408;
        public static final int YY_GIFT_WALL_PAGE_GIFT_POP_SEND_CLICK_VALUE = 302;
        public static final int YY_GIFT_WALL_PAGE_GIFT_POP_SHOW_VALUE = 301;
        public static final int YY_GIFT_WALL_PAGE_REWARD_CLICK_VALUE = 300;
        public static final int YY_GIFT_WALL_PAGE_REWARD_POP_SHOW_VALUE = 303;
        public static final int YY_GIFT_WALL_PAGE_SHOW_VALUE = 298;
        public static final int YY_GIFT_WALL_PAGE_UNLOCK_CLICK_VALUE = 299;
        public static final int YY_HALL_CREATE_CLICK_VALUE = 341;
        public static final int YY_HALL_CREATE_SHOW_VALUE = 340;
        public static final int YY_HALL_RANDOM_CLICK_VALUE = 343;
        public static final int YY_HALL_RANDOM_SHOW_VALUE = 342;
        public static final int YY_HALL_RANK_CLICK_VALUE = 362;
        public static final int YY_HALL_RANK_PAGE_GUILD_CLICK_VALUE = 363;
        public static final int YY_HALL_REDBAG_CLICK_VALUE = 356;
        public static final int YY_HALL_REDBAG_SHOW_VALUE = 355;
        public static final int YY_HALL_TAB_ADD_CLICK_VALUE = 339;
        public static final int YY_HALL_TAB_ADD_SHOW_VALUE = 338;
        public static final int YY_HALL_TOP_FAST_ROOM_CLICK_VALUE = 333;
        public static final int YY_HALL_TOP_FAST_ROOM_SHOW_VALUE = 332;
        public static final int YY_HALL_TOP_PLAZA_CLICK_VALUE = 335;
        public static final int YY_HALL_TOP_PLAZA_SHOW_VALUE = 334;
        public static final int YY_HALL_TOP_TOPIC_CLICK_VALUE = 337;
        public static final int YY_HALL_TOP_TOPIC_SHOW_VALUE = 336;
        public static final int YY_LIFT_MASK_POP_CANCEL_CLICK_VALUE = 396;
        public static final int YY_LIFT_MASK_POP_SHOW_VALUE = 395;
        public static final int YY_LIFT_MASK_POP_USE_CLICK_VALUE = 397;
        public static final int YY_LIFT_MASK_SECOND_POP_NO_CLICK_VALUE = 402;
        public static final int YY_LIFT_MASK_SECOND_POP_SHOW_VALUE = 400;
        public static final int YY_LIFT_MASK_SECOND_POP_YES_CLICK_VALUE = 401;
        public static final int YY_LIFT_MASK_SUCCESS_VALUE = 403;
        public static final int YY_LIFT_MASK_USER_POP_SHOW_VALUE = 398;
        public static final int YY_LIFT_MASK_USER_POP_YES_CLICK_VALUE = 399;
        public static final int YY_LOVE_GIFT_BAR_SHOW_VALUE = 445;
        public static final int YY_LOVE_GIFT_PAGE_ONE_SEND_CLICK_VALUE = 448;
        public static final int YY_LOVE_GIFT_PAGE_QA_CLICK_VALUE = 447;
        public static final int YY_LOVE_GIFT_PAGE_SHOW_VALUE = 446;
        public static final int YY_MADE_CAR_PAGE_CAR_TAB_CLICK_VALUE = 387;
        public static final int YY_MADE_CAR_PAGE_HALL_TAB_CLICK_VALUE = 388;
        public static final int YY_MADE_CAR_PAGE_MORE_CLICK_VALUE = 389;
        public static final int YY_MADE_CAR_PAGE_RECORD_CLICK_VALUE = 391;
        public static final int YY_MADE_CAR_PAGE_RULE_CLICK_VALUE = 390;
        public static final int YY_MADE_CAR_PAGE_SEND_CLICK_VALUE = 392;
        public static final int YY_NEW_WEEK_CLICK_VALUE = 427;
        public static final int YY_NEW_WEEK_SHOW_VALUE = 426;
        public static final int YY_PK_CANCEL_CLICK_VALUE = 322;
        public static final int YY_PK_CONNECT_FAIL_VALUE = 324;
        public static final int YY_PK_CONNECT_SUCCESS_VALUE = 323;
        public static final int YY_PK_ENTRANCE_CLICK_VALUE = 317;
        public static final int YY_PK_INVITE_CLICK_VALUE = 321;
        public static final int YY_PK_INVITE_POP_PK_CLICK_VALUE = 327;
        public static final int YY_PK_INVITE_POP_REJECT_CLICK_VALUE = 326;
        public static final int YY_PK_INVITE_POP_SHOW_VALUE = 325;
        public static final int YY_PK_RANDOM_CLICK_VALUE = 320;
        public static final int YY_PRE_POP_DETAIL_CLICK_VALUE = 433;
        public static final int YY_PRE_POP_SHOW_VALUE = 432;
        public static final int YY_PROFILE_PAGE_LIFT_MASK_CLICK_VALUE = 394;
        public static final int YY_PROFILE_PAGE_SHOW_VALUE = 393;
        public static final int YY_PROFILE_RELATION_CLICK_VALUE = 405;
        public static final int YY_PROFILE_RELATION_SHOW_VALUE = 404;
        public static final int YY_REDBAG_PAGE_GET_CLICK_VALUE = 357;
        public static final int YY_RELATION_ALL_CLICK_VALUE = 417;
        public static final int YY_RELATION_GUIDE_MSG_CLICK_VALUE = 424;
        public static final int YY_RELATION_GUIDE_MSG_SHOW_VALUE = 423;
        public static final int YY_RELATION_HIDE_REMOVE_POP_HIDE_CLICK_VALUE = 414;
        public static final int YY_RELATION_HIDE_REMOVE_POP_REMOVE_CLICK_VALUE = 415;
        public static final int YY_RELATION_HIDE_REMOVE_POP_SHOW_VALUE = 413;
        public static final int YY_RELATION_MINE_CLICK_VALUE = 416;
        public static final int YY_RELATION_ROOM_QA_CLICK_VALUE = 411;
        public static final int YY_RELATION_ROOM_RANKING_CLICK_VALUE = 412;
        public static final int YY_RELATION_USER_INVITE_CLICK_VALUE = 418;
        public static final int YY_RELATION_USER_INVITE_POP_AGREE_CLICK_VALUE = 421;
        public static final int YY_RELATION_USER_INVITE_POP_DISAGREE_CLICK_VALUE = 422;
        public static final int YY_RELATION_USER_INVITE_POP_SHOW_VALUE = 420;
        public static final int YY_RELATION_USER_INVITE_YES_CLICK_VALUE = 419;
        public static final int YY_RES_CLICK_VALUE = 345;
        public static final int YY_RES_SHOW_VALUE = 344;
        public static final int YY_ROB_SING_END_CLICK_VALUE = 365;
        public static final int YY_ROB_SING_FLOWER_CLICK_VALUE = 369;
        public static final int YY_ROB_SING_FLOWER_SEND_CLICK_VALUE = 370;
        public static final int YY_ROB_SING_FOLLOW_CLICK_VALUE = 367;
        public static final int YY_ROB_SING_LIGHT_CLICK_VALUE = 368;
        public static final int YY_ROB_SING_SONG_CLICK_VALUE = 366;
        public static final int YY_ROB_SING_START_CLICK_VALUE = 364;
        public static final int YY_ROMANTIC_ALL_HANDBOOK_PAGE_SHOW_VALUE = 441;
        public static final int YY_ROMANTIC_HANDBOOK_PAGE_SHOW_VALUE = 440;
        public static final int YY_ROMANTIC_LIGHT_PAGE_GO_CLICK_VALUE = 444;
        public static final int YY_ROMANTIC_PAGE_SHOW_VALUE = 439;
        public static final int YY_ROMANTIC_RULE_PAGE_SHOW_VALUE = 442;
        public static final int YY_ROOM_BOX_REDBAG_CLICK_VALUE = 351;
        public static final int YY_ROOM_BOX_REDBAG_SHOW_VALUE = 350;
        public static final int YY_ROOM_BOX_SET_GIFT_CLICK_VALUE = 450;
        public static final int YY_ROOM_BOX_SET_GIFT_SHOW_VALUE = 449;
        public static final int YY_ROOM_REDBAG_CLICK_VALUE = 359;
        public static final int YY_ROOM_REDBAG_FOLLOW_GET_CLICK_VALUE = 360;
        public static final int YY_ROOM_REDBAG_GET_CLICK_VALUE = 361;
        public static final int YY_ROOM_REDBAG_PAGE_RULE_CLICK_VALUE = 353;
        public static final int YY_ROOM_REDBAG_PAGE_SEND_CLICK_VALUE = 354;
        public static final int YY_ROOM_REDBAG_PAGE_SHOW_VALUE = 352;
        public static final int YY_ROOM_REDBAG_SHOW_VALUE = 358;
        public static final int YY_ROOM_STAR_CLICK_VALUE = 349;
        public static final int YY_ROOM_STAR_SHOW_VALUE = 348;
        public static final int YY_SETTINGS_PAGE_SHOW_VALUE = 312;
        public static final int YY_SHOW_LOVE_TOP_ALL_SCORE_PAGE_SHOW_VALUE = 457;
        public static final int YY_SHOW_LOVE_TOP_ALL_TIME_PAGE_SHOW_VALUE = 456;
        public static final int YY_SHOW_LOVE_TOP_PAGE_SHOW_VALUE = 451;
        public static final int YY_SHOW_LOVE_TOP_PAGE_TO_CLICK_VALUE = 452;
        public static final int YY_SHOW_LOVE_TOP_WEEK_SCORE_PAGE_SHOW_VALUE = 455;
        public static final int YY_SHOW_LOVE_TOP_WEEK_TIME_PAGE_SHOW_VALUE = 454;
        public static final int YY_SUPER_STAR_WEEK_CLICK_VALUE = 429;
        public static final int YY_SUPER_STAR_WEEK_SHOW_VALUE = 428;
        public static final int YY_TOPIC_CLICK_VALUE = 315;
        public static final int YY_TOPIC_SETTINGS_DONE_CLICK_VALUE = 316;
        public static final int YY_TOP_SHOW_LOVE_PAGE_TO_CLICK_VALUE = 453;
        public static final int YY_TWELVE_POP_NOW_CLICK_VALUE = 306;
        public static final int YY_VOICE_POP_NO_CLICK_VALUE = 380;
        public static final int YY_VOICE_POP_SHOW_VALUE = 379;
        private final int value;
        private static final Internal.EnumLiteMap<Event> internalValueMap = new Internal.EnumLiteMap<Event>() { // from class: com.blued.das.client.chatroom.ChatRoomProtos.Event.1
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
                    return CHAT_ROOM_PROFILE_ENTER_SHOW;
                case 2:
                    return CHAT_ROOM_PROFILE_ENTER_CLICK;
                case 3:
                    return CHAT_ROOM_MINE_REPORT_SHOW;
                case 4:
                    return CHAT_ROOM_MINE_REPORT_CLICK;
                case 5:
                    return CHAT_ROOM_MINE_ENTER_SHOW;
                case 6:
                    return CHAT_ROOM_ENTER_CLICK;
                case 7:
                    return CHAT_ROOM_HOME_PAGE_TAB_SHOW;
                case 8:
                    return CHAT_ROOM_TAB_PAGE_ROOM_DRAW;
                case 9:
                    return CHAT_ROOM_TAB_PAGE_ROOM_CLICK;
                case 10:
                    return CHAT_ROOM_CREATE_SHOW;
                case 11:
                    return CHAT_ROOM_CREATE_CLICK;
                case 12:
                    return CHAT_ROOM_CREATE_CONFIRM_CLICK;
                case 13:
                    return CHAT_ROOM_NAME_INVALITE_SHOW;
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 43:
                case 50:
                case 78:
                case 79:
                case 82:
                case 83:
                case 98:
                case 104:
                case 105:
                case 108:
                case 119:
                case 130:
                case 131:
                case 132:
                case 133:
                case 175:
                case 284:
                case 285:
                case 287:
                case 288:
                case 443:
                default:
                    return null;
                case 26:
                    return CHAT_ROOM_APPROVE_GUIDE_SHOW;
                case 27:
                    return CHAT_ROOM_APPROVE_GUIDE_CLICK;
                case 28:
                    return CHAT_ROOM_BANNER_SHOW;
                case 29:
                    return CHAT_ROOM_BANNER_CLICK;
                case 30:
                    return CHAT_ROOM_INVITE_CLICK;
                case 31:
                    return CHAT_ROOM_KICK_OUT_CLICK;
                case 32:
                    return CHAT_ROOM_KICK_OUT_CONFIRM_CLICK;
                case 33:
                    return CHAT_ROOM_MUTE_CLICK;
                case 34:
                    return CHAT_ROOM_INVITE_POP_SHOW;
                case 35:
                    return CHAT_ROOM_REFUSE_CLICK;
                case 36:
                    return CHAT_ROOM_ACCEPT_CLICK;
                case 37:
                    return CHAT_ROOM_OUT_MIKE;
                case 38:
                    return CHAT_ROOM_SET_MANAGER_CLICK;
                case 39:
                    return CHAT_ROOM_MANAGER_MAX_SHOW;
                case 40:
                    return CHAT_ROOM_EXIT_BTN_CLICK;
                case 41:
                    return CHAT_ROOM_REPORT_ROOM_CLICK;
                case 42:
                    return CHAT_ROOM_FOLLOW_CLICK;
                case 44:
                    return CHAT_ROOM_UNFOLLOW;
                case 45:
                    return CHAT_ROOM_FOLLOW_GUIDE_SHOW;
                case 46:
                    return CHAT_ROOM_FOLLOW_GUIDE_FOLLOW_CLICK;
                case 47:
                    return CHAT_ROOM_SEND_GIFT_SHOW;
                case 48:
                    return CHAT_ROOM_SEND_GIFT_CLICK;
                case 49:
                    return CHAT_ROOM_RECHARGE_CLICK;
                case 51:
                    return CHAT_ROOM_SHARE_CLICK;
                case 52:
                    return CHAT_ROOM_SHARE_CHANNEL_CLICK;
                case 53:
                    return CHAT_ROOM_MIKE_CLICK;
                case 54:
                    return CHAT_ROOM_PROFILE_MIKE_CLICK;
                case 55:
                    return CHAT_ROOM_MIKE_CONFIRM_CLICK;
                case 56:
                    return CHAT_ROOM_MIKE_SUCCESS_SHOW;
                case 57:
                    return CHAT_ROOM_MIKE_REFUSE_SHOW;
                case 58:
                    return CHAT_ROOM_MIKE_POP_SHOW;
                case 59:
                    return CHAT_ROOM_MIKE_POP_REFUSE_CLICK;
                case 60:
                    return CHAT_ROOM_MIKE_POP_ACCEPT_CLICK;
                case 61:
                    return CHAT_ROOM_MIKE_POP_AUTO_SUCCESS;
                case 62:
                    return CHAT_ROOM_MIKE_USER_REFUSE_CLICK;
                case 63:
                    return CHAT_ROOM_MIKE_USER_ACCEPT_CLICK;
                case 64:
                    return CHAT_ROOM_SEND_MSG_CLICK;
                case 65:
                    return CHAT_ROOM_PROFILE_GO_CLICK;
                case 66:
                    return CHAT_ROOM_USER_PROFILE_FOLLOW_CLICK;
                case 67:
                    return CHAT_ROOM_PROFILE_AT_CLICK;
                case 68:
                    return CHAT_ROOM_PROFILE_MSG_CLICK;
                case 69:
                    return CHAT_ROOM_PROFILE_GIFT_CLICK;
                case 70:
                    return CHAT_ROOM_PROFILE_REPORT_CLICK;
                case 71:
                    return CHAT_ROOM_PROFILE_BLACK_CLICK;
                case 72:
                    return CHAT_ROOM_LIST_CLICK;
                case 73:
                    return CHAT_ROOM_LIST_PAGE_GET_SHOW;
                case 74:
                    return CHAT_ROOM_LIST_PAGE_SEND_SHOW;
                case 75:
                    return CHAT_ROOM_WARN_POP_SHOW;
                case 76:
                    return CHAT_ROOM_USER_OUT_MIKE_TOAST_SHOW;
                case 77:
                    return CHAT_ROOM_OWNER_OUT_MIKE_TOAST_SHOW;
                case 80:
                    return CHAT_ROOM_LIKE_CLICK;
                case 81:
                    return CHAT_ROOM_GIFT_CLICK;
                case 84:
                    return CHAT_ROOM_GIFT_POP_SHOW;
                case 85:
                    return CHAT_ROOM_GIFT_POP_SEND_CLICK;
                case 86:
                    return NO_MONEY_POP_SHOW;
                case 87:
                    return NO_MONEY_POP_RECHARGE_CLICK;
                case 88:
                    return CHAT_ROOM_NAME_CHANGE_CLICK;
                case 89:
                    return CHAT_ROOM_PHONE_BIND_CLICK;
                case 90:
                    return CHAT_ROOM_ENTER_APPROVE_CLICK;
                case 91:
                    return CHAT_ROOM_NOTICE_CLICK;
                case 92:
                    return CHAT_ROOM_NOTICE_SAVE_CLICK;
                case 93:
                    return CHAT_ROOM_NOTICE_CANCEL_CLICK;
                case 94:
                    return CHAT_ROOM_TOOLBOX_CLICK;
                case 95:
                    return CHAT_ROOM_TOOLBOX_EMOJI_CLICK;
                case 96:
                    return CHAT_ROOM_PROFILE_FORBID_CLICK;
                case 97:
                    return CHAT_ROOM_PROFILE_REMOVE_FORBID_CLICK;
                case 99:
                    return CHAT_ROOM_PROFILE_BLOCK_CLICK;
                case 100:
                    return CHAT_ROOM_FOLLOW_MORE_CLICK;
                case 101:
                    return CHAT_ROOM_FOLLOW_ROOM_SHOW;
                case 102:
                    return CHAT_ROOM_FOLLOW_ROOM_CLICK;
                case 103:
                    return CHAT_ROOM_EMOJI_ENTER_CLICK;
                case 106:
                    return CHAT_ROOM_TOOLBOX_MUSIC_SOMEONE_CLICK;
                case 107:
                    return CHAT_ROOM_USER_INVITE_CLICK;
                case 109:
                    return CHAT_ROOM_BG_ENTER_CLICK;
                case 110:
                    return CHAT_ROOM_BG_SOMEONE_CLICK;
                case 111:
                    return CHAT_ROOM_GIFT_POP_ONE_GIFT_SHOW;
                case 112:
                    return CHAT_ROOM_GIFT_POP_ONE_GIFT_CLICK;
                case 113:
                    return CHAT_ROOM_TOOLBOX_MUSIC_PLAY_CLICK;
                case 114:
                    return CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SHOW;
                case 115:
                    return CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SEARCH_CLICK;
                case 116:
                    return CHAT_ROOM_TOOLBOX_MUSIC_LIKE_CLICK;
                case 117:
                    return CHAT_ROOM_TOOLBOX_MUSIC_PAUSE_CLICK;
                case 118:
                    return CHAT_ROOM_TOOLBOX_MUSIC_EXIT_CLICK;
                case 120:
                    return CHAT_ROOM_TOOLBOX_MUSIC_DONE_CLICK;
                case 121:
                    return CHAT_ROOM_TOOLBOX_MUSIC_TAB_SHOW;
                case 122:
                    return CHAT_ROOM_MINIMIZED_WINDOW_CLICK;
                case 123:
                    return CHAT_ROOM_VOTE_ICON_CLICK;
                case 124:
                    return CHAT_ROOM_VOTE_LAUNCH_CLICK;
                case 125:
                    return CHAT_ROOM_VOTE_WINDOW_CLICK;
                case 126:
                    return CHAT_ROOM_VOTE_USER_CLICK;
                case 127:
                    return CHAT_ROOM_INSTRUCTION;
                case 128:
                    return CHAT_ROOM_CP_MATCH_START;
                case 129:
                    return CHAT_ROOM_CP_MATCH_SUCCEED;
                case 134:
                    return CHAT_ROOM_HOST_DISCIPLINE_CLOSE_CLICK;
                case 135:
                    return CHAT_ROOM_MUTE_BTN_CLICK;
                case 136:
                    return CHAT_ROOM_UNMUTE_BTN_CLICK;
                case 137:
                    return CHAT_ROOM_CHANGE_MIC_BTN_CLICK;
                case 138:
                    return CHAT_ROOM_PHONE_BIND_SHOW;
                case 139:
                    return CHAT_ROOM_PHONE_BIND_CONFIRM_CLICK;
                case 140:
                    return CHAT_ROOM_SHARE_TO_FRIEND_CLICK;
                case 141:
                    return CHAT_END_PAGE_LIVING_USER_SHOW;
                case 142:
                    return CHAT_END_PAGE_LIVING_USER_CLICK;
                case 143:
                    return CHAT_ROOM_FOLLOW_ALL_PAGE_SHOW;
                case 144:
                    return CHAT_ROOM_BANNER1_SHOW;
                case 145:
                    return CHAT_ROOM_BANNER1_CLICK;
                case 146:
                    return CHAT_ROOM_BANNER2_SHOW;
                case 147:
                    return CHAT_ROOM_BANNER2_CLICK;
                case 148:
                    return CHAT_ROOM_GIFT_GET_LIST_CLICK;
                case 149:
                    return CHAT_ROOM_GIFT_SEND_LIST_CLICK;
                case 150:
                    return CHAT_ROOM_RANDOM_CLICK;
                case 151:
                    return CHAT_ROOM_RANDOM_SUCCESS;
                case 152:
                    return CHAT_ROOM_PK_CLICK;
                case 153:
                    return CHAT_ROOM_VOTE_CLICK;
                case 154:
                    return CHAT_ROOM_GIFT_PAGE_GIFT_CLICK;
                case 155:
                    return CHAT_ROOM_GIFT_PAGE_BAG_CLICK;
                case 156:
                    return CHAT_ROOM_ACTIVITY_CLICK;
                case 157:
                    return CHAT_ROOM_CAROUSEL_SHOW;
                case 158:
                    return CHAT_ROOM_OWNER_GIFT_GUIDE_CLICK;
                case 159:
                    return CHAT_ROOM_OWNER_DOWN_GIFT_CLICK;
                case 160:
                    return CHAT_ROOM_OWNER_GIFT_CREATE_CLICK;
                case 161:
                    return CHAT_ROOM_USER_GIFT_CLICK;
                case 162:
                    return CHAT_ROOM_USER_GIFT_SEND_CLICK;
                case 163:
                    return CHAT_ROOM_GAME_START_CLICK;
                case 164:
                    return CHAT_ROOM_GAME_ROB_CLICK;
                case 165:
                    return CHAT_ROOM_GAME_ADD_CLICK;
                case 166:
                    return CHAT_ROOM_GAME_DELETE_CLICK;
                case 167:
                    return CHAT_ROOM_GIFT_MORE_HIT_CLICK;
                case 168:
                    return CHAT_ROOM_AUCTION_APPLY_CLICK;
                case 169:
                    return CHAT_ROOM_AUCTION_APPLY_TRUE_CLICK;
                case 170:
                    return CHAT_ROOM_AUCTION_APPLY_FALSE_CLICK;
                case 171:
                    return CHAT_ROOM_AUCTION_APPLY_LIST_CANCEL_CLICK;
                case 172:
                    return CHAT_ROOM_AUCTION_APPLY_LIST_AGREE_CLICK;
                case 173:
                    return CHAT_ROOM_AUCTION_APPLY_LIST_REFUSE_CLICK;
                case 174:
                    return CHAT_ROOM_AUCTION_RELATION_TRUE_CLICK;
                case 176:
                    return CHAT_ROOM_GIFT_LEVEL_GUIDE_ICON_CLICK;
                case 177:
                    return CHAT_ROOM_ANCHOR_LEVEL_CLICK;
                case 178:
                    return CHAT_ROOM_HEART_BEAT_VIP_CLICK;
                case 179:
                    return CHAT_ROOM_HEART_BEAT_VIP_SUCCESS;
                case 180:
                    return SINGLE_ROOM_CREATE_VOICE_CLICK;
                case 181:
                    return SINGLE_ROOM_FANS_UP_SUCCESS;
                case 182:
                    return SINGLE_ROOM_GIFT_SEND_CLICK;
                case 183:
                    return SINGLE_ROOM_ACCOMPANY_UNLOCK;
                case 184:
                    return SINGLE_ROOM_PAY_ICON_CLICK;
                case 185:
                    return SINGLE_ROOM_FIRST_PAY_POP_SHOW;
                case 186:
                    return SINGLE_ROOM_FIRST_PAY_POP_CLICK;
                case 187:
                    return SINGLE_ROOM_PAY_SIX_POP_SHOW;
                case 188:
                    return SINGLE_ROOM_PAY_SIX_POP_CLICK;
                case 189:
                    return SINGLE_ROOM_PAY_SIX_POP_NOW_RECHARGE_CLICK;
                case 190:
                    return CHAT_ROOM_USER_LIST_CLICK;
                case 191:
                    return CHAT_ROOM_OWNER_CUSTOM_CLICK;
                case 192:
                    return CHAT_ROOM_EXIT_ROOM;
                case 193:
                    return PROFILE_GIFT_WALL_SHOW;
                case 194:
                    return PROFILE_GIFT_WALL_CLICK;
                case 195:
                    return PROFILE_GIFT_WALL_DETAIL_QUESTION_CLICK;
                case 196:
                    return PROFILE_GIFT_WALL_DETAIL_GIFT_SEND_CLICK;
                case 197:
                    return CHAT_ROOM_TOOLBOX_ACTIVITY_CLICK;
                case 198:
                    return CHAT_ROOM_GIFT_ACTIVITY_SHOW;
                case 199:
                    return CHAT_ROOM_GIFT_ACTIVITY_CLICK;
                case 200:
                    return CHAT_ROOM_TOOLBOX_PROP_CLICK;
                case 201:
                    return CHAT_ROOM_NEW_GUIDE_POP_SHOW;
                case 202:
                    return CHAT_ROOM_NEW_GUIDE_POP_CLOSE_CLICK;
                case 203:
                    return CHAT_ROOM_RECALL_GUIDE_POP_SHOW;
                case 204:
                    return CHAT_ROOM_RECALL_GUIDE_POP_CLOSE_CLICK;
                case 205:
                    return CHAT_ROOM_START_CHAT_SHOW;
                case 206:
                    return CHAT_ROOM_FOLLOW_ANCHOR_GUIDE_SHOW;
                case 207:
                    return CHAT_ROOM_FOLLOW_ANCHOR_GUIDE_CLICK;
                case 208:
                    return CHAT_ROOM_SEND_GIFT_GUIDE_SHOW;
                case 209:
                    return CHAT_ROOM_SEND_GIFT_GUIDE_CLICK;
                case 210:
                    return CHAT_ROOM_INTERACT_CLICK;
                case 211:
                    return CHAT_ROOM_BACK_INTERACT_CLICK;
                case 212:
                    return CHAT_ROOM_CREATE_UPLOAD_COVER_CLICK;
                case 213:
                    return CHAT_ROOM_UPLOAD_COVER_YES_CLICK;
                case 214:
                    return CHAT_ROOM_OUT_GOODS_SHOW;
                case 215:
                    return CHAT_ROOM_OUT_GOODS_CLICK;
                case 216:
                    return CHAT_ROOM_OUT_GOODS_POP_SEND_CLICK;
                case 217:
                    return CHAT_ROOM_OUT_GOODS_POP_CANCEL_CLICK;
                case 218:
                    return CHAT_ROOM_OUT_GOODS_NOT_ENOUGH_SHOW;
                case 219:
                    return CHAT_ROOM_HANG_WARN_SHOW;
                case 220:
                    return CHAT_ROOM_HANG_WARN_IGNORE_CLICK;
                case 221:
                    return CHAT_ROOM_HANG_WARN_CLOSE_CLICK;
                case 222:
                    return CHAT_ROOM_BOX_PK_CLICK;
                case 223:
                    return CHAT_ROOM_PK_CREATE_PK_PAGE_SHOW;
                case 224:
                    return CHAT_ROOM_PK_CREATE_LEVEL_PAGE_SHOW;
                case 225:
                    return CHAT_ROOM_PK_CREATE_MATCH_CLICK;
                case 226:
                    return CHAT_ROOM_PK_CREATE_INVITE_CLICK;
                case 227:
                    return CHAT_ROOM_PK_CREATE_USER_INVITE_CLICK;
                case 228:
                    return CHAT_ROOM_PK_MATCH_SUCCESS_SHOW;
                case 229:
                    return CHAT_ROOM_PK_INVITE_SUCCESS_SHOW;
                case 230:
                    return CHAT_ROOM_RECOMMEND_SECOND_CLICK;
                case 231:
                    return CHAT_ROOM_GIFT_RESOURCE_CLICK;
                case 232:
                    return CHAT_ROOM_GIFT_RECEIVE_CLICK;
                case 233:
                    return CHAT_ROOM_GIFT_POP_RECEIVE_CLICK;
                case 234:
                    return CHAT_ROOM_HALL_REDBAG_POP_SHOW;
                case 235:
                    return CHAT_ROOM_HALL_REDBAG_POP_CLICK;
                case 236:
                    return CHAT_ROOM_REDBAG_PAGE_RECEIVE_CLICK;
                case 237:
                    return CHAT_ROOM_KTV_SONG_TAB_SHOW;
                case 238:
                    return CHAT_ROOM_KTV_SONG_QUEUE_CLICK;
                case 239:
                    return CHAT_ROOM_KTV_SONG_SEARCH;
                case 240:
                    return CHAT_ROOM_KTV_SONG_GIVE_UP_CLICK;
                case 241:
                    return CHAT_ROOM_KTV_SONG_ACCOMPANIMENT_CLICK;
                case 242:
                    return CHAT_ROOM_KTV_SONG_SING_CLICK;
                case 243:
                    return CHAT_ROOM_KTV_SONG_TONE_CLICK;
                case 244:
                    return CHAT_ROOM_KTV_SONG_TURN_POP_SHOW;
                case 245:
                    return CHAT_ROOM_KTV_TURN_POP_GIVE_UP_CLICK;
                case 246:
                    return CHAT_ROOM_KTV_TURN_POP_GIVE_UP_TIMEOUT;
                case 247:
                    return CHAT_ROOM_KTV_TURN_POP_START_CLICK;
                case 248:
                    return CHAT_ROOM_KTV_SONG_PLAY;
                case 249:
                    return CHAT_ROOM_TASK_ICON_CLICK;
                case 250:
                    return CHAT_ROOM_TASK_REWARD_CLICK;
                case 251:
                    return CHAT_ROOM_FANS_ENTER_CLICK;
                case 252:
                    return CHAT_ROOM_FANS_PANEL_SHOW;
                case 253:
                    return CHAT_ROOM_FANS_PANEL_JOIN_CLICK;
                case 254:
                    return CHAT_ROOM_GIFT_PANEL_JOIN_CLICK;
                case 255:
                    return CHAT_ROOM_GUIDE_POP_SHOW;
                case 256:
                    return CHAT_ROOM_GUIDE_POP_JOIN_CLICK;
                case 257:
                    return CHAT_ROOM_FOLLOW_OPEN_SHOW;
                case 258:
                    return CHAT_ROOM_KTV_GUIDE_SONG_POP_SHOW;
                case 259:
                    return CHAT_ROOM_KTV_GUIDE_SONG_POP_GO_CLICK;
                case 260:
                    return CHAT_ROOM_KTV_GUIDE_SONG_POP_IGNORE_CLICK;
                case 261:
                    return CHAT_ROOM_KTV_GUIDE_MSG_SHOW;
                case 262:
                    return CHAT_ROOM_KTV_GUIDE_MSG_GO_CLICK;
                case 263:
                    return CHAT_ROOM_KTV_NO_MIKE_SONG_CLICK;
                case 264:
                    return CHAT_ROOM_KTV_NO_MIKE_GUIDE_POP_SHOW;
                case 265:
                    return CHAT_ROOM_KTV_NO_MIKE_GUIDE_POP_GO_CLICK;
                case 266:
                    return CHAT_ROOM_KTV_NO_MIKE_GUIDE_POP_IGNORE_CLICK;
                case 267:
                    return CHAT_ROOM_NEW_GIFT_POP_SHOW;
                case 268:
                    return CHAT_ROOM_NEW_GIFT_POP_GET_CLICK;
                case 269:
                    return CHAT_ROOM_NEW_GIFT_GET_SUCCESS;
                case 270:
                    return CHAT_ROOM_NEW_GIFT_PROP_CLICK;
                case 271:
                    return CHAT_ROOM_PROFILE_RELATION_CLICK;
                case 272:
                    return CHAT_ROOM_PROFILE_HONOR_LEVEL_CLICK;
                case 273:
                    return CHAT_ROOM_PROFILE_CLUB_CLICK;
                case 274:
                    return CHAT_ROOM_PROFILE_MEDAL_CLICK;
                case 275:
                    return CHAT_ROOM_PROFILE_MEDAL_ONE_CLICK;
                case 276:
                    return CHAT_ROOM_HALL_HEAD_ICON_CLICK;
                case 277:
                    return CHAT_ROOM_HALL_BTN_CLICK;
                case 278:
                    return CHAT_ROOM_BOX_RAIN_CLICK;
                case 279:
                    return CHAT_ROOM_BOX_RAIN_QUESTION_CLICK;
                case 280:
                    return CHAT_ROOM_BOX_RAIN_FALL;
                case 281:
                    return CHAT_ROOM_ANCHOR_LEVEL_ENTER_SHOW;
                case 282:
                    return CHAT_ROOM_ANCHOR_LEVEL_ENTER_CLICK;
                case 283:
                    return CHAT_ROOM_COOL_STAGE_CLICK;
                case 286:
                    return CHAT_ROOM_COOL_STAGE_SING_END_POP_SHOW;
                case 289:
                    return CHAT_ROOM_BG_MUSIC_ENTRANCE_SHOW;
                case 290:
                    return CHAT_ROOM_BG_MUSIC_ENTRANCE_CLICK;
                case 291:
                    return CHAT_ROOM_BG_MUSIC_ONE_PLAY_CLICK;
                case 292:
                    return CHAT_ROOM_GIFT_POP_ALL_CLICK;
                case 293:
                    return CHAT_ROOM_WISH_RESET_CLICK;
                case 294:
                    return CHAT_ROOM_WISH_RESET_NO_CLICK;
                case 295:
                    return CHAT_ROOM_WISH_RESET_YES_CLICK;
                case 296:
                    return CHAT_ROOM_BOSS_SEAT_POP_SHOW;
                case 297:
                    return CHAT_ROOM_BOSS_SEAT_POP_GIFT_SEND_CLICK;
                case 298:
                    return YY_GIFT_WALL_PAGE_SHOW;
                case 299:
                    return YY_GIFT_WALL_PAGE_UNLOCK_CLICK;
                case 300:
                    return YY_GIFT_WALL_PAGE_REWARD_CLICK;
                case 301:
                    return YY_GIFT_WALL_PAGE_GIFT_POP_SHOW;
                case 302:
                    return YY_GIFT_WALL_PAGE_GIFT_POP_SEND_CLICK;
                case 303:
                    return YY_GIFT_WALL_PAGE_REWARD_POP_SHOW;
                case 304:
                    return YY_DOWN_EXCHANGE_CLICK;
                case 305:
                    return YY_EXCHANGE_PAGE_TWELVE_CLICK;
                case 306:
                    return YY_TWELVE_POP_NOW_CLICK;
                case 307:
                    return CHAT_ROOM_KTV_SONG_LIST_SHOW;
                case 308:
                    return CHAT_ROOM_KTV_SONG_LIST_TOP_CLICK;
                case 309:
                    return CHAT_ROOM_KTV_SONG_LIST_SING_CLICK;
                case 310:
                    return CHAT_ROOM_FANS_EDIT_CLICK;
                case 311:
                    return CHAT_ROOM_FANS_EDIT_SUBMIT_CLICK;
                case 312:
                    return YY_SETTINGS_PAGE_SHOW;
                case 313:
                    return ANCHOR_REPORT_FORM_PAGE_MORE_CLICK;
                case 314:
                    return ANCHOR_REPORT_FORM_PAGE_MORE_YY_CLICK;
                case 315:
                    return YY_TOPIC_CLICK;
                case 316:
                    return YY_TOPIC_SETTINGS_DONE_CLICK;
                case 317:
                    return YY_PK_ENTRANCE_CLICK;
                case 318:
                    return YY_BOX_ENTRANCE_CLICK;
                case 319:
                    return YY_BOX_SHOW;
                case 320:
                    return YY_PK_RANDOM_CLICK;
                case 321:
                    return YY_PK_INVITE_CLICK;
                case 322:
                    return YY_PK_CANCEL_CLICK;
                case 323:
                    return YY_PK_CONNECT_SUCCESS;
                case 324:
                    return YY_PK_CONNECT_FAIL;
                case 325:
                    return YY_PK_INVITE_POP_SHOW;
                case 326:
                    return YY_PK_INVITE_POP_REJECT_CLICK;
                case 327:
                    return YY_PK_INVITE_POP_PK_CLICK;
                case 328:
                    return CHAT_ROOM_HOT_BANNER_SHOW;
                case 329:
                    return CHAT_ROOM_HOT_BANNER_CLICK;
                case 330:
                    return CHAT_ROOM_HOT_RESOURCE_SHOW;
                case 331:
                    return CHAT_ROOM_HOT_RESOURCE_CLICK;
                case 332:
                    return YY_HALL_TOP_FAST_ROOM_SHOW;
                case 333:
                    return YY_HALL_TOP_FAST_ROOM_CLICK;
                case 334:
                    return YY_HALL_TOP_PLAZA_SHOW;
                case 335:
                    return YY_HALL_TOP_PLAZA_CLICK;
                case 336:
                    return YY_HALL_TOP_TOPIC_SHOW;
                case 337:
                    return YY_HALL_TOP_TOPIC_CLICK;
                case 338:
                    return YY_HALL_TAB_ADD_SHOW;
                case 339:
                    return YY_HALL_TAB_ADD_CLICK;
                case 340:
                    return YY_HALL_CREATE_SHOW;
                case 341:
                    return YY_HALL_CREATE_CLICK;
                case 342:
                    return YY_HALL_RANDOM_SHOW;
                case 343:
                    return YY_HALL_RANDOM_CLICK;
                case 344:
                    return YY_RES_SHOW;
                case 345:
                    return YY_RES_CLICK;
                case 346:
                    return YY_BROADCAST_SHOW;
                case 347:
                    return YY_BROADCAST_CLICK;
                case 348:
                    return YY_ROOM_STAR_SHOW;
                case 349:
                    return YY_ROOM_STAR_CLICK;
                case 350:
                    return YY_ROOM_BOX_REDBAG_SHOW;
                case 351:
                    return YY_ROOM_BOX_REDBAG_CLICK;
                case 352:
                    return YY_ROOM_REDBAG_PAGE_SHOW;
                case 353:
                    return YY_ROOM_REDBAG_PAGE_RULE_CLICK;
                case 354:
                    return YY_ROOM_REDBAG_PAGE_SEND_CLICK;
                case 355:
                    return YY_HALL_REDBAG_SHOW;
                case 356:
                    return YY_HALL_REDBAG_CLICK;
                case 357:
                    return YY_REDBAG_PAGE_GET_CLICK;
                case 358:
                    return YY_ROOM_REDBAG_SHOW;
                case 359:
                    return YY_ROOM_REDBAG_CLICK;
                case 360:
                    return YY_ROOM_REDBAG_FOLLOW_GET_CLICK;
                case 361:
                    return YY_ROOM_REDBAG_GET_CLICK;
                case 362:
                    return YY_HALL_RANK_CLICK;
                case 363:
                    return YY_HALL_RANK_PAGE_GUILD_CLICK;
                case 364:
                    return YY_ROB_SING_START_CLICK;
                case 365:
                    return YY_ROB_SING_END_CLICK;
                case 366:
                    return YY_ROB_SING_SONG_CLICK;
                case 367:
                    return YY_ROB_SING_FOLLOW_CLICK;
                case 368:
                    return YY_ROB_SING_LIGHT_CLICK;
                case 369:
                    return YY_ROB_SING_FLOWER_CLICK;
                case 370:
                    return YY_ROB_SING_FLOWER_SEND_CLICK;
                case 371:
                    return YY_DING_TOAST_SHOW;
                case 372:
                    return YY_DING_TOAST_CLICK;
                case 373:
                    return YY_FIRST_MEET_POP_SHOW;
                case 374:
                    return YY_FIRST_MEET_POP_CLICK;
                case 375:
                    return YY_FIRST_MEET_SUCCESS_POP_SHOW;
                case 376:
                    return YY_FIRST_MEET_SUCCESS_POP_GIFT_GO_CLICK;
                case 377:
                    return YY_FIRST_MEET_SUCCESS_POP_MEDAL_GO_CLICK;
                case 378:
                    return YY_FIRST_MEET_SUCCESS_POP_FRAME_GO_CLICK;
                case 379:
                    return YY_VOICE_POP_SHOW;
                case 380:
                    return YY_VOICE_POP_NO_CLICK;
                case 381:
                    return CHAT_ROOM_BOX_ANCHOR_GROWTH_PLAN_CLICK;
                case 382:
                    return CHAT_ROOM_BOX_MADE_CAR_CLICK;
                case 383:
                    return CHAT_ROOM_PROFILE_MADE_CAR_SHOW;
                case 384:
                    return CHAT_ROOM_PROFILE_MADE_CAR_CLICK;
                case 385:
                    return YY_GIFT_MADE_CAR_GO_SHOW;
                case 386:
                    return YY_GIFT_MADE_CAR_GO_CLICK;
                case 387:
                    return YY_MADE_CAR_PAGE_CAR_TAB_CLICK;
                case 388:
                    return YY_MADE_CAR_PAGE_HALL_TAB_CLICK;
                case 389:
                    return YY_MADE_CAR_PAGE_MORE_CLICK;
                case 390:
                    return YY_MADE_CAR_PAGE_RULE_CLICK;
                case YY_MADE_CAR_PAGE_RECORD_CLICK_VALUE:
                    return YY_MADE_CAR_PAGE_RECORD_CLICK;
                case 392:
                    return YY_MADE_CAR_PAGE_SEND_CLICK;
                case 393:
                    return YY_PROFILE_PAGE_SHOW;
                case 394:
                    return YY_PROFILE_PAGE_LIFT_MASK_CLICK;
                case YY_LIFT_MASK_POP_SHOW_VALUE:
                    return YY_LIFT_MASK_POP_SHOW;
                case YY_LIFT_MASK_POP_CANCEL_CLICK_VALUE:
                    return YY_LIFT_MASK_POP_CANCEL_CLICK;
                case YY_LIFT_MASK_POP_USE_CLICK_VALUE:
                    return YY_LIFT_MASK_POP_USE_CLICK;
                case YY_LIFT_MASK_USER_POP_SHOW_VALUE:
                    return YY_LIFT_MASK_USER_POP_SHOW;
                case 399:
                    return YY_LIFT_MASK_USER_POP_YES_CLICK;
                case 400:
                    return YY_LIFT_MASK_SECOND_POP_SHOW;
                case 401:
                    return YY_LIFT_MASK_SECOND_POP_YES_CLICK;
                case 402:
                    return YY_LIFT_MASK_SECOND_POP_NO_CLICK;
                case 403:
                    return YY_LIFT_MASK_SUCCESS;
                case 404:
                    return YY_PROFILE_RELATION_SHOW;
                case 405:
                    return YY_PROFILE_RELATION_CLICK;
                case 406:
                    return YY_GIFT_WALL_EXHIBITION_PAGE_SHOW;
                case 407:
                    return YY_GIFT_WALL_EXHIBITION_PAGE_ALL_CLICK;
                case 408:
                    return YY_GIFT_WALL_EXHIBITION_PAGE_STAR_CLICK;
                case 409:
                    return YY_BOX_RELATION_SHOW;
                case 410:
                    return YY_BOX_RELATION_CLICK;
                case 411:
                    return YY_RELATION_ROOM_QA_CLICK;
                case 412:
                    return YY_RELATION_ROOM_RANKING_CLICK;
                case 413:
                    return YY_RELATION_HIDE_REMOVE_POP_SHOW;
                case 414:
                    return YY_RELATION_HIDE_REMOVE_POP_HIDE_CLICK;
                case 415:
                    return YY_RELATION_HIDE_REMOVE_POP_REMOVE_CLICK;
                case 416:
                    return YY_RELATION_MINE_CLICK;
                case 417:
                    return YY_RELATION_ALL_CLICK;
                case 418:
                    return YY_RELATION_USER_INVITE_CLICK;
                case 419:
                    return YY_RELATION_USER_INVITE_YES_CLICK;
                case 420:
                    return YY_RELATION_USER_INVITE_POP_SHOW;
                case 421:
                    return YY_RELATION_USER_INVITE_POP_AGREE_CLICK;
                case 422:
                    return YY_RELATION_USER_INVITE_POP_DISAGREE_CLICK;
                case 423:
                    return YY_RELATION_GUIDE_MSG_SHOW;
                case 424:
                    return YY_RELATION_GUIDE_MSG_CLICK;
                case 425:
                    return CHAT_ROOM_BOX_CREATE_PRE_CLICK;
                case 426:
                    return YY_NEW_WEEK_SHOW;
                case 427:
                    return YY_NEW_WEEK_CLICK;
                case 428:
                    return YY_SUPER_STAR_WEEK_SHOW;
                case 429:
                    return YY_SUPER_STAR_WEEK_CLICK;
                case 430:
                    return YY_CREATE_PRE_DONE_CLICK;
                case 431:
                    return YY_CREATE_PRE_QA_CLICK;
                case 432:
                    return YY_PRE_POP_SHOW;
                case 433:
                    return YY_PRE_POP_DETAIL_CLICK;
                case 434:
                    return YY_CELEBRATION_ENTER_SHOW;
                case 435:
                    return YY_CELEBRATION_ENTER_CLICK;
                case 436:
                    return YY_CELEBRATION_KNOW_CLICK;
                case 437:
                    return YY_CELEBRATION_PRE_FEED_CLICK;
                case 438:
                    return YY_CELEBRATION_PRE_FEED_CANCEL_CLICK;
                case 439:
                    return YY_ROMANTIC_PAGE_SHOW;
                case 440:
                    return YY_ROMANTIC_HANDBOOK_PAGE_SHOW;
                case 441:
                    return YY_ROMANTIC_ALL_HANDBOOK_PAGE_SHOW;
                case 442:
                    return YY_ROMANTIC_RULE_PAGE_SHOW;
                case 444:
                    return YY_ROMANTIC_LIGHT_PAGE_GO_CLICK;
                case 445:
                    return YY_LOVE_GIFT_BAR_SHOW;
                case 446:
                    return YY_LOVE_GIFT_PAGE_SHOW;
                case 447:
                    return YY_LOVE_GIFT_PAGE_QA_CLICK;
                case 448:
                    return YY_LOVE_GIFT_PAGE_ONE_SEND_CLICK;
                case 449:
                    return YY_ROOM_BOX_SET_GIFT_SHOW;
                case 450:
                    return YY_ROOM_BOX_SET_GIFT_CLICK;
                case 451:
                    return YY_SHOW_LOVE_TOP_PAGE_SHOW;
                case 452:
                    return YY_SHOW_LOVE_TOP_PAGE_TO_CLICK;
                case 453:
                    return YY_TOP_SHOW_LOVE_PAGE_TO_CLICK;
                case 454:
                    return YY_SHOW_LOVE_TOP_WEEK_TIME_PAGE_SHOW;
                case 455:
                    return YY_SHOW_LOVE_TOP_WEEK_SCORE_PAGE_SHOW;
                case 456:
                    return YY_SHOW_LOVE_TOP_ALL_TIME_PAGE_SHOW;
                case 457:
                    return YY_SHOW_LOVE_TOP_ALL_SCORE_PAGE_SHOW;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return ChatRoomProtos.getDescriptor().getEnumTypes().get(0);
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/chatroom/ChatRoomProtos$From.class */
    public enum From implements ProtocolMessageEnum {
        UNKNOWN_FROM(0),
        FOLLOW_ROOM_LIST(1),
        FOLLOW_ROOM_LIST_SECOND_PAGE(2),
        GIFT_PANEL_FIRST_PAY(3),
        GIFT_PANEL_FIRST_POP(4),
        RECHARGE_RED_BTN(5),
        UNRECOGNIZED(-1);
        
        public static final int FOLLOW_ROOM_LIST_SECOND_PAGE_VALUE = 2;
        public static final int FOLLOW_ROOM_LIST_VALUE = 1;
        public static final int GIFT_PANEL_FIRST_PAY_VALUE = 3;
        public static final int GIFT_PANEL_FIRST_POP_VALUE = 4;
        public static final int RECHARGE_RED_BTN_VALUE = 5;
        public static final int UNKNOWN_FROM_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<From> internalValueMap = new Internal.EnumLiteMap<From>() { // from class: com.blued.das.client.chatroom.ChatRoomProtos.From.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public From findValueByNumber(int i) {
                return From.forNumber(i);
            }
        };
        private static final From[] VALUES = values();

        From(int i) {
            this.value = i;
        }

        public static From forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    return null;
                                }
                                return RECHARGE_RED_BTN;
                            }
                            return GIFT_PANEL_FIRST_POP;
                        }
                        return GIFT_PANEL_FIRST_PAY;
                    }
                    return FOLLOW_ROOM_LIST_SECOND_PAGE;
                }
                return FOLLOW_ROOM_LIST;
            }
            return UNKNOWN_FROM;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return ChatRoomProtos.getDescriptor().getEnumTypes().get(4);
        }

        public static Internal.EnumLiteMap<From> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static From valueOf(int i) {
            return forNumber(i);
        }

        public static From valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/chatroom/ChatRoomProtos$ShareChannel.class */
    public enum ShareChannel implements ProtocolMessageEnum {
        UNKNOWN_SHARE_CHANNEL(0),
        SHARE_FORWARD(1),
        SHARE_FRIEND(2),
        SHARE_WECHAT(3),
        SHARE_QQ(4),
        SHARE_WEIBO(5),
        SHARE_FRIEND_CLUB(6),
        UNRECOGNIZED(-1);
        
        public static final int SHARE_FORWARD_VALUE = 1;
        public static final int SHARE_FRIEND_CLUB_VALUE = 6;
        public static final int SHARE_FRIEND_VALUE = 2;
        public static final int SHARE_QQ_VALUE = 4;
        public static final int SHARE_WECHAT_VALUE = 3;
        public static final int SHARE_WEIBO_VALUE = 5;
        public static final int UNKNOWN_SHARE_CHANNEL_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<ShareChannel> internalValueMap = new Internal.EnumLiteMap<ShareChannel>() { // from class: com.blued.das.client.chatroom.ChatRoomProtos.ShareChannel.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ShareChannel findValueByNumber(int i) {
                return ShareChannel.forNumber(i);
            }
        };
        private static final ShareChannel[] VALUES = values();

        ShareChannel(int i) {
            this.value = i;
        }

        public static ShareChannel forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_SHARE_CHANNEL;
                case 1:
                    return SHARE_FORWARD;
                case 2:
                    return SHARE_FRIEND;
                case 3:
                    return SHARE_WECHAT;
                case 4:
                    return SHARE_QQ;
                case 5:
                    return SHARE_WEIBO;
                case 6:
                    return SHARE_FRIEND_CLUB;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return ChatRoomProtos.getDescriptor().getEnumTypes().get(2);
        }

        public static Internal.EnumLiteMap<ShareChannel> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static ShareChannel valueOf(int i) {
            return forNumber(i);
        }

        public static ShareChannel valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/chatroom/ChatRoomProtos$UserType.class */
    public enum UserType implements ProtocolMessageEnum {
        UNKNOWN_USER_TYPE(0),
        COMMON_USER(1),
        APPLY_SUCCESS_USER(2),
        APPLYING_USER(3),
        ANCHOR(4),
        FANS_USER(5),
        NOT_FANS(6),
        NEW(7),
        OLD(8),
        UNRECOGNIZED(-1);
        
        public static final int ANCHOR_VALUE = 4;
        public static final int APPLYING_USER_VALUE = 3;
        public static final int APPLY_SUCCESS_USER_VALUE = 2;
        public static final int COMMON_USER_VALUE = 1;
        public static final int FANS_USER_VALUE = 5;
        public static final int NEW_VALUE = 7;
        public static final int NOT_FANS_VALUE = 6;
        public static final int OLD_VALUE = 8;
        public static final int UNKNOWN_USER_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<UserType> internalValueMap = new Internal.EnumLiteMap<UserType>() { // from class: com.blued.das.client.chatroom.ChatRoomProtos.UserType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public UserType findValueByNumber(int i) {
                return UserType.forNumber(i);
            }
        };
        private static final UserType[] VALUES = values();

        UserType(int i) {
            this.value = i;
        }

        public static UserType forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_USER_TYPE;
                case 1:
                    return COMMON_USER;
                case 2:
                    return APPLY_SUCCESS_USER;
                case 3:
                    return APPLYING_USER;
                case 4:
                    return ANCHOR;
                case 5:
                    return FANS_USER;
                case 6:
                    return NOT_FANS;
                case 7:
                    return NEW;
                case 8:
                    return OLD;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return ChatRoomProtos.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<UserType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static UserType valueOf(int i) {
            return forNumber(i);
        }

        public static UserType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/chatroom/ChatRoomProtos$WarnType.class */
    public enum WarnType implements ProtocolMessageEnum {
        UNKNOWN_WARN_TYPE(0),
        ADS_WARN(1),
        POLITICAL_WARN(2),
        HINT_WARN(3),
        DRUG_WARN(4),
        SPEECH_WARN(5),
        PRIVACY_WARN(6),
        INVALID_LIVE_WARN(7),
        CUSTOMIZE_WARN(8),
        COPYRIGHT_WARN(9),
        MUTE_WARN(10),
        UNRECOGNIZED(-1);
        
        public static final int ADS_WARN_VALUE = 1;
        public static final int COPYRIGHT_WARN_VALUE = 9;
        public static final int CUSTOMIZE_WARN_VALUE = 8;
        public static final int DRUG_WARN_VALUE = 4;
        public static final int HINT_WARN_VALUE = 3;
        public static final int INVALID_LIVE_WARN_VALUE = 7;
        public static final int MUTE_WARN_VALUE = 10;
        public static final int POLITICAL_WARN_VALUE = 2;
        public static final int PRIVACY_WARN_VALUE = 6;
        public static final int SPEECH_WARN_VALUE = 5;
        public static final int UNKNOWN_WARN_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<WarnType> internalValueMap = new Internal.EnumLiteMap<WarnType>() { // from class: com.blued.das.client.chatroom.ChatRoomProtos.WarnType.1
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
            switch (i) {
                case 0:
                    return UNKNOWN_WARN_TYPE;
                case 1:
                    return ADS_WARN;
                case 2:
                    return POLITICAL_WARN;
                case 3:
                    return HINT_WARN;
                case 4:
                    return DRUG_WARN;
                case 5:
                    return SPEECH_WARN;
                case 6:
                    return PRIVACY_WARN;
                case 7:
                    return INVALID_LIVE_WARN;
                case 8:
                    return CUSTOMIZE_WARN;
                case 9:
                    return COPYRIGHT_WARN;
                case 10:
                    return MUTE_WARN;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return ChatRoomProtos.getDescriptor().getEnumTypes().get(3);
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
        internal_static_com_blued_das_client_chatroom_ChatRoomProto_descriptor = descriptor2;
        internal_static_com_blued_das_client_chatroom_ChatRoomProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Event", TXCopyrightedMedia.EXT_INFO_ROOM_ID, "RoomName", "RoomUid", "RoomType", "Source", "TabId", "UserType", "BannerId", "TargetUid", "IsFollow", "SkuId", "ShareChannel", "WarnType", "Num", "GoodsId", "Count", "Content", "Id", HttpHeaders.FROM, "Position", "TabNum", "PageNum", "MusicId", "Duration", "Range", "Url", "Page", "IsTrue", "Type", HttpHeaders.LOCATION, "Label", "Theme", "Name", "Level", "Beans", "IsOpen"});
    }

    private ChatRoomProtos() {
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
