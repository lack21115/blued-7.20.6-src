package com.blued.android.module.yy_china.utils.log;

import android.text.TextUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.google.protobuf.Message;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/log/EventTrackYY.class */
public class EventTrackYY {
    private static String a(String str) {
        return EventTrackUtils.a(str);
    }

    public static void a(ChatRoomProtos.Event event) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).build());
    }

    public static void a(ChatRoomProtos.Event event, int i) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setNum(i).build());
    }

    public static void a(ChatRoomProtos.Event event, String str) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setId(str).build());
    }

    public static void a(ChatRoomProtos.Event event, String str, int i, boolean z) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setNum(i).setUserType(z ? ChatRoomProtos.UserType.NEW : ChatRoomProtos.UserType.OLD).build());
    }

    public static void a(ChatRoomProtos.Event event, String str, ChatRoomProtos.UserType userType) {
        if (event == null || userType == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        newBuilder.setSource(a(str));
        newBuilder.setUserType(userType);
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void a(ChatRoomProtos.Event event, String str, String str2) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setBannerId(str).setUrl(str2).build());
    }

    public static void a(ChatRoomProtos.Event event, String str, String str2, int i) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setPosition(i).build());
    }

    public static void a(ChatRoomProtos.Event event, String str, String str2, String str3) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setTargetUid(a(str3)).build());
    }

    public static void a(ChatRoomProtos.Event event, String str, String str2, String str3, int i) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setId(a(str2)).setMusicId(a(str3)).setDuration(i).build());
    }

    public static void a(ChatRoomProtos.Event event, String str, String str2, String str3, int i, int i2, int i3) {
        if (event == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        newBuilder.setRoomId(a(str));
        newBuilder.setRoomUid(a(str2));
        newBuilder.setLevel(a(str3));
        newBuilder.setNum(i3);
        newBuilder.setBeans(i);
        newBuilder.setCount(i2);
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void a(ChatRoomProtos.Event event, String str, String str2, String str3, int i, String str4) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setRoomType(a(str3)).setDuration(i).setSource(a(str4)).build());
    }

    public static void a(ChatRoomProtos.Event event, String str, String str2, String str3, ChatRoomProtos.From from) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setRoomType(a(str3)).setFrom(from).build());
    }

    public static void a(ChatRoomProtos.Event event, String str, String str2, String str3, ChatRoomProtos.UserType userType) {
        if (event == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        newBuilder.setRoomId(a(str));
        newBuilder.setRoomUid(a(str2));
        newBuilder.setId(a(str3));
        newBuilder.setUserType(userType);
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void a(ChatRoomProtos.Event event, String str, String str2, String str3, String str4) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setTargetUid(a(str3)).setGoodsId(a(str4)).build());
    }

    public static void a(ChatRoomProtos.Event event, String str, String str2, String str3, String str4, int i, int i2) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setType(a(str3)).setTargetUid(a(str4)).setNum(i).setBeans(i2).build());
    }

    public static void a(ChatRoomProtos.Event event, String str, String str2, String str3, String str4, int i, int i2, String str5, int i3, int i4, int i5, int i6, String str6) {
        if (event == null) {
            return;
        }
        LogUtils.d("sendGiftEvent", "event: eventName=" + event.name() + ", RoomId=" + str + ", RoomUid=" + str2 + ", TargetUid=" + str3 + ", GoodsId=" + str4 + ", Num=" + i + ", Count=" + i2 + ", Source=" + str5 + ", Position=" + i3 + ", TabNum=" + i4 + ", PageNum=" + i5 + ", mic_position=" + i6 + ", chatType=" + str6);
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setTargetUid(a(str3)).setGoodsId(a(str4)).setNum(i).setCount(i2).setSource(str5).setPosition(i3).setTabNum(i4).setPageNum(i5).setLocation(i6).setType(str6).build());
    }

    public static void a(ChatRoomProtos.Event event, String str, String str2, String str3, String str4, int i, String str5, int i2) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setType(a(str3)).setTargetUid(a(str4)).setNum(i).setBeans(i2).setGoodsId(a(str5)).build());
    }

    public static void a(ChatRoomProtos.Event event, String str, String str2, String str3, String str4, String str5) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setTargetUid(a(str3)).setType(a(str5)).setContent(a(str4)).build());
    }

    public static void a(ChatRoomProtos.Event event, String str, String str2, String str3, String str4, boolean z) {
        if (event == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        newBuilder.setRoomId(a(str));
        newBuilder.setRoomUid(a(str2));
        newBuilder.setRoomType(a(str3));
        newBuilder.setTargetUid(a(str4));
        newBuilder.setIsTrue(z);
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void a(ChatRoomProtos.Event event, String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7) {
        if (event == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        if (!TextUtils.isEmpty(str)) {
            newBuilder.setRoomId(a(str));
        }
        if (!TextUtils.isEmpty(str2)) {
            newBuilder.setRoomUid(a(str2));
        }
        if (!TextUtils.isEmpty(str3)) {
            newBuilder.setTabId(a(str3));
        }
        if (!TextUtils.isEmpty(str4)) {
            newBuilder.setRoomType(a(str4));
        }
        if (!TextUtils.isEmpty(str5)) {
            newBuilder.setPage(str5);
        }
        if (!TextUtils.isEmpty(str7)) {
            newBuilder.setLabel(str7);
        }
        newBuilder.setIsTrue(z);
        if (!TextUtils.isEmpty(str6)) {
            newBuilder.setSource(a(str6));
        }
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void a(ChatRoomProtos.Event event, String str, String str2, String str3, boolean z) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setTargetUid(a(str3)).setIsFollow(z).build());
    }

    public static void a(String str, String str2, ChatRoomProtos.ShareChannel shareChannel) {
        if (shareChannel == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(ChatRoomProtos.Event.CHAT_ROOM_SHARE_CHANNEL_CLICK).setRoomId(a(str)).setRoomUid(a(str2)).setShareChannel(shareChannel).build());
    }

    public static void a(String str, String str2, String str3) {
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(ChatRoomProtos.Event.CHAT_ROOM_SHARE_TO_FRIEND_CLICK).setRoomId(a(str)).setRoomUid(a(str2)).setTargetUid(str3).build());
    }

    public static void a(String str, String str2, String str3, int i) {
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(ChatRoomProtos.Event.YY_PK_INVITE_CLICK);
        newBuilder.setRoomId(a(str));
        newBuilder.setId(a(str2));
        newBuilder.setTargetUid(a(str3));
        newBuilder.setNum(i);
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void a(String str, boolean z, int i) {
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(ChatRoomProtos.Event.YY_PK_RANDOM_CLICK);
        newBuilder.setRoomId(a(str));
        newBuilder.setIsOpen(z);
        newBuilder.setNum(i);
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void b(ChatRoomProtos.Event event, String str) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setBannerId(str).build());
    }

    public static void b(ChatRoomProtos.Event event, String str, String str2) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setId(str).setUrl(str2).build());
    }

    public static void b(ChatRoomProtos.Event event, String str, String str2, int i) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setTargetUid(a(str2)).setNum(i).build());
    }

    public static void b(ChatRoomProtos.Event event, String str, String str2, String str3) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setType(a(str3)).build());
    }

    public static void b(ChatRoomProtos.Event event, String str, String str2, String str3, String str4) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setTargetUid(a(str3)).setRoomType(a(str4)).build());
    }

    public static void b(ChatRoomProtos.Event event, String str, String str2, String str3, boolean z) {
        if (event == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        newBuilder.setRoomId(a(str));
        newBuilder.setRoomUid(a(str2));
        newBuilder.setId(a(str3));
        newBuilder.setIsOpen(z);
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void c(ChatRoomProtos.Event event, String str) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomType(str).build());
    }

    public static void c(ChatRoomProtos.Event event, String str, String str2) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setTargetUid(a(str2)).build());
    }

    public static void c(ChatRoomProtos.Event event, String str, String str2, int i) {
        if (event == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        newBuilder.setRoomId(a(str));
        newBuilder.setRoomUid(a(str2));
        newBuilder.setNum(i);
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void c(ChatRoomProtos.Event event, String str, String str2, String str3) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setId(str3).build());
    }

    public static void c(ChatRoomProtos.Event event, String str, String str2, String str3, String str4) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setTargetUid(a(str3)).setId(a(str4)).build());
    }

    public static void d(ChatRoomProtos.Event event, String str) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setType(a(str)).build());
    }

    public static void d(ChatRoomProtos.Event event, String str, String str2) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).build());
    }

    public static void d(ChatRoomProtos.Event event, String str, String str2, String str3) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setGoodsId(a(str3)).build());
    }

    public static void d(ChatRoomProtos.Event event, String str, String str2, String str3, String str4) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setUrl(a(str3)).setType(a(str4)).build());
    }

    public static void e(ChatRoomProtos.Event event, String str) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).build());
    }

    public static void e(ChatRoomProtos.Event event, String str, String str2) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setId(a(str2)).build());
    }

    public static void e(ChatRoomProtos.Event event, String str, String str2, String str3) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setMusicId(a(str3)).build());
    }

    public static void e(ChatRoomProtos.Event event, String str, String str2, String str3, String str4) {
        if (event == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        if (!TextUtils.isEmpty(str)) {
            newBuilder.setRoomId(a(str));
        }
        if (!TextUtils.isEmpty(str2)) {
            newBuilder.setRoomUid(a(str2));
        }
        if (!TextUtils.isEmpty(str3)) {
            newBuilder.setTabId(a(str3));
        }
        if (!TextUtils.isEmpty(str4)) {
            newBuilder.setSource(a(str4));
        }
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void f(ChatRoomProtos.Event event, String str) {
        if (event == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        newBuilder.setCount(StringUtils.a(str, 0));
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void f(ChatRoomProtos.Event event, String str, String str2) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRange(a(str2)).build());
    }

    public static void f(ChatRoomProtos.Event event, String str, String str2, String str3) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setRoomType(a(str3)).build());
    }

    public static void f(ChatRoomProtos.Event event, String str, String str2, String str3, String str4) {
        if (event == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        newBuilder.setSource(a(str4));
        newBuilder.setRoomType(a(str2));
        newBuilder.setRoomName(a(str));
        newBuilder.setTheme(a(str3));
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void g(ChatRoomProtos.Event event, String str, String str2, String str3) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setName(a(str3)).build());
    }

    public static void g(ChatRoomProtos.Event event, String str, String str2, String str3, String str4) {
        if (event == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        newBuilder.setRoomId(a(str));
        newBuilder.setRoomUid(a(str2));
        newBuilder.setTargetUid(a(str3));
        newBuilder.setType(a(str4));
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void h(ChatRoomProtos.Event event, String str, String str2, String str3) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setSource(str3).build());
    }

    public static void h(ChatRoomProtos.Event event, String str, String str2, String str3, String str4) {
        if (event == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        newBuilder.setRoomId(a(str));
        newBuilder.setRoomUid(a(str2));
        newBuilder.setType(a(str3));
        newBuilder.setContent(str4);
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void i(ChatRoomProtos.Event event, String str, String str2, String str3) {
        if (event == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        if (!TextUtils.isEmpty(str)) {
            newBuilder.setRoomId(a(str));
        }
        if (!TextUtils.isEmpty(str2)) {
            newBuilder.setRoomUid(a(str2));
        }
        if (!TextUtils.isEmpty(str3)) {
            newBuilder.setId(a(str3));
        }
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void i(ChatRoomProtos.Event event, String str, String str2, String str3, String str4) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setTargetUid(str3).setId(a(str4)).build());
    }

    public static void j(ChatRoomProtos.Event event, String str, String str2, String str3) {
        if (event == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        newBuilder.setRoomId(a(str));
        newBuilder.setRoomUid(a(str2));
        newBuilder.setId(a(str3));
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void j(ChatRoomProtos.Event event, String str, String str2, String str3, String str4) {
        if (event == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        newBuilder.setRoomId(a(str));
        newBuilder.setRoomUid(a(str2));
        newBuilder.setType(a(str3));
        newBuilder.setUrl(a(str4));
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void k(ChatRoomProtos.Event event, String str, String str2, String str3) {
        if (event == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        newBuilder.setRoomId(a(str));
        newBuilder.setRoomUid(a(str2));
        newBuilder.setId(a(str3));
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void k(ChatRoomProtos.Event event, String str, String str2, String str3, String str4) {
        if (event == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        newBuilder.setRoomId(a(str));
        newBuilder.setRoomUid(a(str2));
        newBuilder.setId(a(str3));
        newBuilder.setBeans(StringUtils.a(str4, 0));
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void l(ChatRoomProtos.Event event, String str, String str2, String str3) {
        if (event == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        newBuilder.setRoomId(a(str));
        newBuilder.setRoomUid(a(str2));
        newBuilder.setTargetUid(a(str3));
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void m(ChatRoomProtos.Event event, String str, String str2, String str3) {
        if (event == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        newBuilder.setRoomId(a(str));
        newBuilder.setRoomUid(a(str2));
        newBuilder.setSource(a(str3));
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void n(ChatRoomProtos.Event event, String str, String str2, String str3) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setId(a(str2)).setMusicId(a(str3)).build());
    }

    public static void o(ChatRoomProtos.Event event, String str, String str2, String str3) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setGoodsId(a(str3)).build());
    }

    public static void p(ChatRoomProtos.Event event, String str, String str2, String str3) {
        if (event == null) {
            return;
        }
        EventTrackUtils.a((Message) ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(event).setRoomId(a(str)).setRoomUid(a(str2)).setUrl(str3).build());
    }

    public static void q(ChatRoomProtos.Event event, String str, String str2, String str3) {
        if (event == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        newBuilder.setRoomId(a(str));
        newBuilder.setId(a(str2));
        newBuilder.setTargetUid(a(str3));
        EventTrackUtils.a((Message) newBuilder.build());
    }

    public static void r(ChatRoomProtos.Event event, String str, String str2, String str3) {
        if (event == null) {
            return;
        }
        ChatRoomProtos.ChatRoomProto.Builder newBuilder = ChatRoomProtos.ChatRoomProto.newBuilder();
        newBuilder.setEvent(event);
        newBuilder.setRoomId(a(str));
        newBuilder.setRoomUid(a(str2));
        newBuilder.setCount(StringUtils.a(str3, 0));
        EventTrackUtils.a((Message) newBuilder.build());
    }
}
