package com.blued.android.module.live_china.utils.log.trackUtils;

import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.log.EventTrackUtils;
import com.blued.das.live.LiveProtos;
import com.blued.track.bytedance.ByteDanceLogUtils;
import org.json.JSONObject;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/log/trackUtils/EventTrackLive.class */
public class EventTrackLive {
    public static LiveProtos.FollowStatus a(String str) {
        LiveProtos.FollowStatus followStatus = LiveProtos.FollowStatus.TO_FOLLOW;
        if ("1".equals(str)) {
            return LiveProtos.FollowStatus.FOLLOWED_HIM;
        }
        if ("2".equals(str)) {
            return LiveProtos.FollowStatus.FOLLOW_ME;
        }
        if ("3".equals(str)) {
            return LiveProtos.FollowStatus.FOLLOWED_EACH;
        }
        if ("8".equals(str) || "4".equals(str) || "12".equals(str)) {
            followStatus = LiveProtos.FollowStatus.FOLLOW_BLACK;
        }
        return followStatus;
    }

    public static LiveProtos.TaskType a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? LiveProtos.TaskType.UNKNOWN_TASK_TYPE : LiveProtos.TaskType.SEND_ANY_GIFT : LiveProtos.TaskType.RECHARGE_ANY : LiveProtos.TaskType.SEND_3_MSG : LiveProtos.TaskType.WATCH_15M : LiveProtos.TaskType.LOGIN_DAILY;
    }

    public static void a(LiveProtos.Event event) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).build());
        }
    }

    public static void a(LiveProtos.Event event, int i) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setBtnType(i == 1 ? LiveProtos.BtnType.LIVE_ROOM : LiveProtos.BtnType.LIVE_LIST).build());
        }
    }

    public static void a(LiveProtos.Event event, int i, int i2) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setBtnType(i == 1 ? LiveProtos.BtnType.LIVE_ROOM : LiveProtos.BtnType.LIVE_LIST).setCount(i2).build());
        }
    }

    public static void a(LiveProtos.Event event, long j, String str, LiveProtos.BoxType boxType) {
        if (event == null || boxType == null) {
            return;
        }
        EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str)).setLiveId(String.valueOf(j)).setBoxType(boxType).build());
    }

    public static void a(LiveProtos.Event event, long j, String str, LiveProtos.FollowStatus followStatus) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str)).setLiveId(String.valueOf(j)).setFollowStatus(followStatus).build());
        }
    }

    public static void a(LiveProtos.Event event, LiveProtos.BtnType btnType, String str, String str2, LiveProtos.Status status) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setBtnType(btnType).setStatus(status).build());
        }
    }

    public static void a(LiveProtos.Event event, LiveProtos.LiveType liveType) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveType(liveType).build());
        }
    }

    public static void a(LiveProtos.Event event, LiveProtos.Status status) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setStatus(status).build());
        }
    }

    public static void a(LiveProtos.Event event, Boolean bool) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setIsTrue(bool.booleanValue()).build());
        }
    }

    public static void a(LiveProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setUrl(c(str)).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, int i) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setUrl(c(str)).setNum(i).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, int i, int i2, int i3, int i4, int i5, int i6) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setBeansCount(i).setBeansNum(i2).setViewCount(i3).setLikeCount(i4).setOnlineCount(i5).setLiveDuration(i6).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, long j) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(LiveRoomManager.a().g())).setLiveId(c(LiveRoomManager.a().e())).setId(String.valueOf(j)).setGoodsId(c(str)).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, long j, long j2, long j3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setStartTime(j).setEndTime(j2).setDuration(j3).setLiveId(c(str)).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, LiveProtos.Status status) {
        if (event == null || status == null) {
            return;
        }
        EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setFilterId(c(str)).setStatus(status).build());
    }

    public static void a(LiveProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, int i) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setType(String.valueOf(i)).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, int i, int i2) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str)).setLiveId(c(str2)).setCount(i).setBeansCount(i2).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, int i, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setGoodsId(c(str2)).setNum(i).setType(c(str3)).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, long j) {
        if (event != null) {
            LogUtils.c("sendLiveAvatar:" + event.name());
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setGoodsId(String.valueOf(j)).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, long j, long j2, long j3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setStartTime(j).setEndTime(j2).setDuration(j3).setLiveId(c(str2)).setTargetUid(c(str)).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, LiveProtos.EnterType enterType) {
        if (event == null || enterType == null) {
            return;
        }
        EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setEnterType(enterType).build());
    }

    public static void a(LiveProtos.Event event, String str, String str2, LiveProtos.TaskType taskType) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(str2).setLiveId(str).setTaskType(taskType).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, Boolean bool) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str)).setLiveId(c(str2)).setFrom(bool.booleanValue() ? "auto" : "click").build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setType(c(str3)).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, String str3, int i) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setTargetUid(c(str2)).setGoodsId(c(str3)).setNum(i).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, String str3, String str4) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setTargetUid(c(str2)).setThirdId(c(str3)).setType(c(str4)).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, String str3, String str4, int i) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setLiveFrom(c(str3)).setRecommendType(c(str4)).setLiveFromNum(i).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, String str3, String str4, int i, String str5, int i2, int i3, String str6, int i4, int i5, boolean z, boolean z2, LiveProtos.LiveType liveType, String str7, boolean z3, boolean z4, boolean z5, long j, String str8, String str9, boolean z6) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setLiveFrom(c(str3)).setLiveFromNum(i).setRecommendType(c(str4)).setGoodsId(c(str5)).setNum(i2).setCount(i3).setTabId(c(str6)).setTabNum(i4).setPageNum(i5).setIsHitTime(z).setIsPk(z2).setLiveType(liveType).setType(c(str7)).setIsTrue(z3).setIsMp4(z4).setIsCombo(z5).setId(String.valueOf(j)).setName(c(str8)).setThirdId(c(str9)).setIsRandom(z6).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, String str3, String str4, int i, boolean z, int i2) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setGoodsId(c(str3)).setTabId(c(str4)).setTabNum(i).setIsMp4(z).setPageNum(i2).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, String str3, String str4, long j) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setTargetUid(c(str2)).setId(c(str3)).setGoodsId(c(str4)).setCount(new Long(j).intValue()).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, String str3, String str4, String str5, int i) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setFollowedUid(c(str3)).setLiveFrom(c(str4)).setRecommendType(c(str5)).setLiveFromNum(i).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, String str3, boolean z, int i, String str4) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveTab(c(str)).setTargetUid(c(str3)).setLiveId(c(str2)).setId(c(str4)).setIsTrue(z).setNum(i).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, boolean z) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setIsSuccess(z).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, boolean z, String str2) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setIsSuccess(z).setId(c(str2)).build());
        }
    }

    public static void a(LiveProtos.Event event, boolean z) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setIsAuto(z).build());
        }
    }

    public static LiveProtos.FollowStatus b(String str) {
        LiveProtos.FollowStatus followStatus = LiveProtos.FollowStatus.TO_FOLLOW_STATUS;
        if ("1".equals(str)) {
            return LiveProtos.FollowStatus.FOLLOWED_STATUS;
        }
        if ("2".equals(str)) {
            return LiveProtos.FollowStatus.BE_FOLLOWED_STATUS;
        }
        if ("3".equals(str)) {
            followStatus = LiveProtos.FollowStatus.EACH_FOLLOW_STATUS;
        }
        return followStatus;
    }

    public static void b(LiveProtos.Event event) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).build());
        }
    }

    public static void b(LiveProtos.Event event, int i) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setCount(i).build());
        }
    }

    public static void b(LiveProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).build());
        }
    }

    public static void b(LiveProtos.Event event, String str, long j) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setId(c(str)).setLiveId(String.valueOf(j)).build());
        }
    }

    public static void b(LiveProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setId(c(str2)).build());
        }
    }

    public static void b(LiveProtos.Event event, String str, String str2, int i) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setNum(i).build());
        }
    }

    public static void b(LiveProtos.Event event, String str, String str2, int i, int i2) {
        if (event != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("live_id", c(str));
                jSONObject.put("target_uid", c(str2));
                jSONObject.put("weight", i);
                jSONObject.put("recommend_type", i2);
                ByteDanceLogUtils.a(event.name(), jSONObject);
            } catch (Exception e) {
            }
        }
    }

    public static void b(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setTargetUid(c(str2)).setId(c(str3)).build());
        }
    }

    public static void b(LiveProtos.Event event, String str, String str2, String str3, int i) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setMusicId(c(str2)).setTabId(c(str3)).setCount(i).build());
        }
    }

    public static void b(LiveProtos.Event event, String str, String str2, String str3, String str4) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setUrl(c(str3)).setType(c(str4)).build());
        }
    }

    public static void b(LiveProtos.Event event, String str, String str2, String str3, String str4, int i) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setFrom(c(str3)).setRecommendType(c(str4)).setLiveFromNum(i).build());
        }
    }

    public static void b(LiveProtos.Event event, String str, String str2, String str3, String str4, String str5, int i) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setGuestUid(c(str4)).setThirdId(c(str3)).setType(c(str5)).setNum(i).build());
        }
    }

    public static void b(LiveProtos.Event event, String str, String str2, boolean z) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setIsOpen(z).build());
        }
    }

    private static String c(String str) {
        return EventTrackUtils.a(str);
    }

    public static void c(LiveProtos.Event event) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setIsTrue(false).build());
        }
    }

    public static void c(LiveProtos.Event event, int i) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setId(String.valueOf(i)).build());
        }
    }

    public static void c(LiveProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str)).build());
        }
    }

    public static void c(LiveProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setTabId(c(str2)).build());
        }
    }

    public static void c(LiveProtos.Event event, String str, String str2, int i) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setTargetUid(c(str2)).setCount(i).build());
        }
    }

    public static void c(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setTargetUid(c(str2)).setFrom(c(str3)).build());
        }
    }

    public static void c(LiveProtos.Event event, String str, String str2, String str3, int i) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setGoodsId(c(str3)).setNum(i).build());
        }
    }

    public static void c(LiveProtos.Event event, String str, String str2, String str3, String str4) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str)).setLiveId(c(str2)).setId(c(str3)).setRecommendUid(c(str4)).build());
        }
    }

    public static void c(LiveProtos.Event event, String str, String str2, boolean z) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str2)).setTargetUid(c(str)).build());
        }
    }

    public static void d(LiveProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setId(c(str)).build());
        }
    }

    public static void d(LiveProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setId(c(str)).setUrl(c(str2)).build());
        }
    }

    public static void d(LiveProtos.Event event, String str, String str2, int i) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setNum(i).build());
        }
    }

    public static void d(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setTargetUid(c(str2)).setGuestUid(c(str3)).build());
        }
    }

    public static void d(LiveProtos.Event event, String str, String str2, String str3, String str4) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setId(c(str3)).setThirdId(c(str4)).build());
        }
    }

    public static void e(LiveProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setIsTrue(false).setUrl(c(str)).build());
        }
    }

    public static void e(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setTargetUid(c(str2)).setThirdId(c(str3)).build());
        }
    }

    public static void e(LiveProtos.Event event, String str, String str2, String str3, String str4) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setType(c(str3)).setId(c(str4)).build());
        }
    }

    public static void f(LiveProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setUrl(c(str)).build());
        }
    }

    public static void f(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setLiveFrom(c(str3)).build());
        }
    }

    public static void f(LiveProtos.Event event, String str, String str2, String str3, String str4) {
        if (event != null) {
            LogUtils.c("sendLiveAvatar:" + event.name());
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setTargetUid(c(str2)).setId(c(str3)).setThirdId(c(str4)).build());
        }
    }

    public static void g(LiveProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setName(c(str)).build());
        }
    }

    public static void g(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setMusicId(c(str2)).setTabId(c(str3)).build());
        }
    }

    public static void g(LiveProtos.Event event, String str, String str2, String str3, String str4) {
        if (event != null) {
            LogUtils.c("sendLiveAvatar:" + event.name());
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setId(c(str2)).setTargetUid(c(str3)).setThirdId(c(str4)).build());
        }
    }

    public static void h(LiveProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setType(c(str)).build());
        }
    }

    public static void h(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setTargetUid(c(str2)).setPassword(c(str3)).build());
        }
    }

    public static void h(LiveProtos.Event event, String str, String str2, String str3, String str4) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setId(c(str)).setLiveId(c(str2)).setTargetUid(c(str3)).setThirdId(c(str4)).build());
        }
    }

    public static void i(LiveProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setType(c(str)).build());
        }
    }

    public static void i(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setId(c(str3)).build());
        }
    }

    public static void j(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setContent(c(str3)).build());
        }
    }

    public static void k(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setTabId(c(str3)).build());
        }
    }

    public static void l(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setId(c(str3)).build());
        }
    }

    public static void m(LiveProtos.Event event, String str, String str2, String str3) {
        b(event, str, str2, str3, "");
    }

    public static void n(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str)).setLiveId(c(str2)).setGoodsId(c(str3)).build());
        }
    }

    public static void o(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setType(c(str3)).build());
        }
    }

    public static void p(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            LogUtils.c("sendLiveAvatar:" + event.name());
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(c(str2)).setLiveId(c(str)).setId(c(str3)).build());
        }
    }

    public static void q(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            LogUtils.c("sendLiveAvatar:" + event.name());
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setTargetUid(c(str2)).setThirdId(c(str3)).build());
        }
    }

    public static void r(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setTargetUid(c(str2)).setUrl(c(str3)).build());
        }
    }

    public static void s(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setTargetUid(c(str2)).setId(c(str3)).build());
        }
    }

    public static void t(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            com.blued.track.trackUtils.EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveTab(c(str)).setTargetUid(c(str3)).setLiveId(c(str2)).build());
        }
    }

    public static void u(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setTargetUid(c(str2)).setThirdId(c(str3)).build());
        }
    }

    public static void v(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setTargetUid(c(str2)).setThirdId(c(str3)).build());
        }
    }

    public static void w(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setTargetUid(c(str2)).setId(c(str3)).build());
        }
    }

    public static void x(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str2)).setTargetUid(c(str)).setGoodsId(c(str3)).build());
        }
    }

    public static void y(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(c(str)).setTargetUid(c(str2)).setType(c(str3)).build());
        }
    }
}
