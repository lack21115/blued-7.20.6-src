package com.soft.blued.manager;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.UiUtils;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveFullModeFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.yy_china.fragment.PlayingStudioFragment;
import com.blued.android.module.yy_china.fragment.RecordingStudioFragment;
import com.blued.android.module.yy_china.fragment.YYCreateRoomFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedTopBannerModel;
import com.blued.community.ui.feed.fragment.FeedDetailsFragment;
import com.blued.community.ui.feed.fragment.SignFeedListFragment;
import com.blued.community.ui.feed.model.FeedDetailParams;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.das.guy.GuyProtos;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.DateTodayNotificationLayoutBinding;
import com.soft.blued.databinding.FlashNotificationLayoutBinding;
import com.soft.blued.databinding.HelloCallNotificationLayoutBinding;
import com.soft.blued.databinding.NotificationFeedCityBannerLayoutBinding;
import com.soft.blued.databinding.PrivilegeUserNotificationLayoutBinding;
import com.soft.blued.databinding.SpecialCareNotificationLayoutBinding;
import com.soft.blued.databinding.UsersNotificationLayoutBinding;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.manager.FollowedUsersNotificationManager;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.find.observer.NearbyFindSetSelectedTab;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.msg.ChannelFragment;
import com.soft.blued.ui.msg.MsgChattingFragment;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.manager.DateTodayManager;
import com.soft.blued.ui.msg.model.FriendsNotificationExtra;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.SuperPrivilegeBuyDialogFragment;
import com.soft.blued.ui.welcome.SerialSplashFragment;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/manager/FollowedUsersNotificationManager.class */
public final class FollowedUsersNotificationManager {

    /* renamed from: a  reason: collision with root package name */
    public static final FollowedUsersNotificationManager f29698a;
    private static final String b;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseArray<ViewState> f29699c;
    private static final SparseArray<FriendsNotificationExtra> d;
    private static final Handler e;
    private static String f;
    private static WeakReference<Activity> g;
    private static float h;

    @Metadata
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/manager/FollowedUsersNotificationManager$NotificationRemoveRunnable.class */
    public static final class NotificationRemoveRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final FrameLayout f29700a;
        private final View b;

        /* renamed from: c  reason: collision with root package name */
        private final FriendsNotificationExtra f29701c;

        public NotificationRemoveRunnable(FrameLayout frameLayout, View view, FriendsNotificationExtra friendsNotificationExtra) {
            this.f29700a = frameLayout;
            this.b = view;
            this.f29701c = friendsNotificationExtra;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.b;
            if (view == null || view.getParent() == null) {
                return;
            }
            FollowedUsersNotificationManager.f29698a.a(this.f29700a, this.b, (FriendsNotificationExtra) null);
        }
    }

    @Metadata
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/manager/FollowedUsersNotificationManager$NotificationType.class */
    public static final class NotificationType {

        /* renamed from: a  reason: collision with root package name */
        public static final Companion f29702a = new Companion(null);

        @Metadata
        /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/manager/FollowedUsersNotificationManager$NotificationType$Companion.class */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/manager/FollowedUsersNotificationManager$PUSH_TYPE.class */
    public static final class PUSH_TYPE {

        /* renamed from: a  reason: collision with root package name */
        public static final Companion f29703a = new Companion(null);

        @Metadata
        /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/manager/FollowedUsersNotificationManager$PUSH_TYPE$Companion.class */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/manager/FollowedUsersNotificationManager$ViewState.class */
    public static final class ViewState {

        /* renamed from: a  reason: collision with root package name */
        private View f29704a;
        private NotificationRemoveRunnable b;

        public ViewState(View view, NotificationRemoveRunnable notificationRemoveRunnable) {
            this.f29704a = view;
            this.b = notificationRemoveRunnable;
        }

        public final View a() {
            return this.f29704a;
        }

        public final void a(NotificationRemoveRunnable notificationRemoveRunnable) {
            this.b = notificationRemoveRunnable;
        }

        public final NotificationRemoveRunnable b() {
            return this.b;
        }
    }

    static {
        FollowedUsersNotificationManager followedUsersNotificationManager = new FollowedUsersNotificationManager();
        f29698a = followedUsersNotificationManager;
        String simpleName = followedUsersNotificationManager.getClass().getSimpleName();
        Intrinsics.c(simpleName, "FollowedUsersNotificatio…ager.javaClass.simpleName");
        b = simpleName;
        f29699c = new SparseArray<>();
        d = new SparseArray<>();
        e = new Handler(Looper.getMainLooper());
        f = "";
    }

    private FollowedUsersNotificationManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        EventTrackGuy.a(GuyProtos.Event.PUSH_VOCATIVE_OPEN_POP_OPEN_BTN_CLICK);
        CallHelloManager.a().a((Context) f29698a.c(), (IRequestHost) null, false, 13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        Tracker.onClick(view);
        HomeArgumentHelper.a(AppInfo.d(), "msg", new Bundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view, TranslateAnimation animation) {
        Intrinsics.e(animation, "$animation");
        view.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedTopBannerModel feedTopBannerModel) {
        SignFeedListFragment.Companion companion = SignFeedListFragment.b;
        Context d2 = AppInfo.d();
        Intrinsics.c(d2, "getAppContext()");
        companion.a(d2, feedTopBannerModel == null ? null : feedTopBannerModel.getFeed_ids(), 9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FriendsNotificationExtra model, Ref.ObjectRef id, View rootView, View view) {
        Activity c2;
        Tracker.onClick(view);
        Intrinsics.e(model, "$model");
        Intrinsics.e(id, "$id");
        Intrinsics.e(rootView, "$rootView");
        String str = model.notification_type;
        if (str != null) {
            switch (str.hashCode()) {
                case 3872:
                    if (str.equals("yy")) {
                        YYRoomInfoManager e2 = YYRoomInfoManager.e();
                        FollowedUsersNotificationManager followedUsersNotificationManager = f29698a;
                        Fragment c3 = followedUsersNotificationManager.c(followedUsersNotificationManager.c());
                        e2.a(c3 == null ? null : c3.getActivity(), String.valueOf(model.yy_rome_id), "yy_open_pop");
                        break;
                    }
                    break;
                case 3046161:
                    if (str.equals("care")) {
                        LogData logData = new LogData();
                        ChatHelperV4 a2 = ChatHelperV4.a();
                        Activity c4 = f29698a.c();
                        String str2 = model.user_id;
                        Intrinsics.c(str2, "model.user_id");
                        a2.a(c4, Long.parseLong(str2), "", model.user_head_img, 0, 0, 0, 0, "", false, 0, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
                        break;
                    }
                    break;
                case 3138974:
                    if (str.equals(IAdInterListener.AdProdType.PRODUCT_FEEDS)) {
                        BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
                        bluedIngSelfFeed.feed_id = String.valueOf(model.circle_id);
                        FeedDetailsFragment.a(AppInfo.d(), bluedIngSelfFeed, -1, new FeedDetailParams(0));
                        break;
                    }
                    break;
                case 3322092:
                    if (str.equals("live")) {
                        LiveRoomData liveRoomData = new LiveRoomData(model.rome_id, 0, "", "", "", model.rome_master_img, model.vbadge);
                        liveRoomData.liveFrom = "popup_banner";
                        LiveRoomInfoChannel.a(AppInfo.d(), liveRoomData);
                        break;
                    }
                    break;
                case 97513456:
                    if (str.equals("flash")) {
                        Bundle bundle = new Bundle();
                        bundle.putString("to_message_tab", "1");
                        HomeArgumentHelper.a(AppInfo.d(), "msg", bundle);
                        break;
                    }
                    break;
                case 103668165:
                    if (str.equals("match") && (c2 = f29698a.c()) != null) {
                        DateTodayManager dateTodayManager = DateTodayManager.f32404a;
                        Activity activity = c2;
                        String str3 = model.user_id;
                        Intrinsics.c(str3, "model.user_id");
                        dateTodayManager.a(activity, null, Long.parseLong(str3), model.user_head_img);
                        break;
                    }
                    break;
                case 109801339:
                    if (str.equals("super")) {
                        LogData logData2 = new LogData();
                        ChatHelperV4 a3 = ChatHelperV4.a();
                        Activity c5 = f29698a.c();
                        String str4 = model.user_id;
                        Intrinsics.c(str4, "model.user_id");
                        a3.a(c5, Long.parseLong(str4), "", model.user_head_img, 0, 0, 0, 0, "", false, 0, 0, logData2, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
                        break;
                    }
                    break;
                case 763850025:
                    if (str.equals("push_call_time")) {
                        if (model.push_type != 2) {
                            SuperPrivilegeBuyDialogFragment.Companion companion = SuperPrivilegeBuyDialogFragment.b;
                            Context d2 = AppInfo.d();
                            Intrinsics.c(d2, "getAppContext()");
                            companion.a(d2, 13);
                            break;
                        } else {
                            EventTrackGuy.a(GuyProtos.Event.PUSH_VOCATIVE_OPEN_POP_SHOW);
                            AppInfo.n().post(new Runnable() { // from class: com.soft.blued.manager.-$$Lambda$FollowedUsersNotificationManager$iF54d3mtuCidKR442Nai9vf8lzo
                                @Override // java.lang.Runnable
                                public final void run() {
                                    FollowedUsersNotificationManager.f();
                                }
                            });
                            break;
                        }
                    }
                    break;
                case 778559857:
                    if (str.equals("bubble_feed")) {
                        final FeedTopBannerModel feedTopBannerModel = (FeedTopBannerModel) AppInfo.f().fromJson(model.extra, (Class<Object>) FeedTopBannerModel.class);
                        NearbyFindSetSelectedTab.a().a(1);
                        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.manager.-$$Lambda$FollowedUsersNotificationManager$GiB5kfxhpj6Ms4ipDnEWBSMns_E
                            @Override // java.lang.Runnable
                            public final void run() {
                                FollowedUsersNotificationManager.a(FeedTopBannerModel.this);
                            }
                        }, 50L);
                        break;
                    }
                    break;
            }
        }
        EventTrackMessage.f(MessageProtos.Event.POPUP_BANNER_CLICK, (String) id.f42545a, model.notification_type);
        if (rootView.getParent() == null || !(rootView.getParent() instanceof FrameLayout)) {
            return;
        }
        FollowedUsersNotificationManager followedUsersNotificationManager2 = f29698a;
        ViewParent parent = rootView.getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
        }
        followedUsersNotificationManager2.a((FrameLayout) parent, rootView, (FriendsNotificationExtra) null);
    }

    private final View b(FriendsNotificationExtra friendsNotificationExtra) {
        View inflate = LayoutInflater.from(AppInfo.d()).inflate(R.layout.date_today_notification_layout, (ViewGroup) null);
        DateTodayNotificationLayoutBinding a2 = DateTodayNotificationLayoutBinding.a(inflate);
        Intrinsics.c(a2, "bind(layout)");
        a2.e.setBackgroundResource(R.drawable.date_today_notification_layout_background);
        ImageLoader.a((IRequestHost) null, friendsNotificationExtra.user_head_img).d(2131237310).b(R.drawable.user_bg_round_blur).c().a(100).a(a2.f);
        ImageLoader.a((IRequestHost) null, UserInfo.getInstance().getLoginUserInfo().getAvatar()).d(2131237310).b(2131237310).c().a(a2.g);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(friendsNotificationExtra.age)) {
            sb.append(friendsNotificationExtra.age);
        }
        sb.append(BridgeUtil.SPLIT_MARK);
        if (!TextUtils.isEmpty(friendsNotificationExtra.height)) {
            sb.append(StringUtils.a(friendsNotificationExtra.height, BlueAppLocal.c(), true));
        }
        sb.append(BridgeUtil.SPLIT_MARK);
        if (!TextUtils.isEmpty(friendsNotificationExtra.weight)) {
            sb.append(StringUtils.b(friendsNotificationExtra.weight, BlueAppLocal.c(), true));
        }
        sb.append(BridgeUtil.SPLIT_MARK);
        sb.append(StringUtils.e(friendsNotificationExtra.role));
        StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
        String string = AppInfo.d().getString(R.string.date_today_push_desc1);
        Intrinsics.c(string, "getAppContext().getStrin…ng.date_today_push_desc1)");
        String format = String.format(string, Arrays.copyOf(new Object[]{sb}, 1));
        Intrinsics.c(format, "format(format, *args)");
        String str = format;
        if (!TextUtils.isEmpty(friendsNotificationExtra.tags)) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.f42549a;
            String string2 = AppInfo.d().getString(R.string.date_today_push_desc2);
            Intrinsics.c(string2, "getAppContext().getStrin…ng.date_today_push_desc2)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{friendsNotificationExtra.tags}, 1));
            Intrinsics.c(format2, "format(format, *args)");
            str = Intrinsics.a(format, (Object) format2);
        }
        a2.k.setText(str);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FrameLayout decorView, FriendsNotificationExtra model) {
        Intrinsics.e(decorView, "$decorView");
        Intrinsics.e(model, "$model");
        f29698a.a(decorView, model);
    }

    private final View c(FriendsNotificationExtra friendsNotificationExtra) {
        List<String> user_avatar;
        View layout = LayoutInflater.from(AppInfo.d()).inflate(R.layout.notification_feed_city_banner_layout, (ViewGroup) null);
        NotificationFeedCityBannerLayoutBinding a2 = NotificationFeedCityBannerLayoutBinding.a(layout);
        Intrinsics.c(a2, "bind(layout)");
        FeedTopBannerModel feedTopBannerModel = (FeedTopBannerModel) AppInfo.f().fromJson(friendsNotificationExtra.extra, (Class<Object>) FeedTopBannerModel.class);
        if (CommunityManager.f19086a.a().s()) {
            a2.f.setBackgroundResource(R.drawable.notification_feed_city_banner_bg_dark);
        } else {
            a2.f.setBackgroundResource(R.drawable.notification_feed_city_banner_bg);
        }
        if (feedTopBannerModel != null) {
            a2.g.setText(feedTopBannerModel.getTitle());
            a2.e.setText(feedTopBannerModel.getSubtitle());
            a2.f29497c.setText(feedTopBannerModel.getButton_text());
        }
        if (feedTopBannerModel != null && (user_avatar = feedTopBannerModel.getUser_avatar()) != null && (!user_avatar.isEmpty())) {
            if (user_avatar.size() > 1) {
                ImageLoader.a((IRequestHost) null, user_avatar.get(1)).d(2131237310).c().a(a2.b);
            }
            ImageLoader.a((IRequestHost) null, user_avatar.get(0)).d(2131237310).c().a(a2.f29496a);
        }
        Intrinsics.c(layout, "layout");
        return layout;
    }

    private final View d(FriendsNotificationExtra friendsNotificationExtra) {
        View inflate = LayoutInflater.from(AppInfo.d()).inflate(R.layout.hello_call_notification_layout, (ViewGroup) null);
        HelloCallNotificationLayoutBinding a2 = HelloCallNotificationLayoutBinding.a(inflate);
        Intrinsics.c(a2, "bind(layout)");
        if (Build.VERSION.SDK_INT >= 26) {
            a2.g.setAutoSizeTextTypeWithDefaults(1);
            a2.g.setEllipsize(TextUtils.TruncateAt.END);
            a2.g.setMaxLines(2);
        } else {
            a2.g.setEllipsize(TextUtils.TruncateAt.END);
            a2.g.setMaxLines(3);
        }
        if (!TextUtils.isEmpty(friendsNotificationExtra.call_push_content)) {
            a2.g.setText(friendsNotificationExtra.call_push_content);
        }
        return inflate;
    }

    private final View e(FriendsNotificationExtra friendsNotificationExtra) {
        View layout = LayoutInflater.from(AppInfo.d()).inflate(R.layout.flash_notification_layout, (ViewGroup) null);
        FlashNotificationLayoutBinding a2 = FlashNotificationLayoutBinding.a(layout);
        Intrinsics.c(a2, "bind(layout)");
        a2.f28746c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.manager.-$$Lambda$FollowedUsersNotificationManager$9meVFO79pKLaubiByQOQhkSSM5A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FollowedUsersNotificationManager.a(view);
            }
        });
        Intrinsics.c(layout, "layout");
        return layout;
    }

    private final View f(FriendsNotificationExtra friendsNotificationExtra) {
        View layout = LayoutInflater.from(AppInfo.d()).inflate(R.layout.special_care_notification_layout, (ViewGroup) null);
        SpecialCareNotificationLayoutBinding a2 = SpecialCareNotificationLayoutBinding.a(layout);
        Intrinsics.c(a2, "bind(layout)");
        ImageLoader.a((IRequestHost) null, friendsNotificationExtra.user_head_img).d(2131237310).b(2131237310).c().a(a2.f29591c);
        if (friendsNotificationExtra.vbadge > 0) {
            a2.e.setVisibility(0);
            UserInfoHelper.b(a2.e, friendsNotificationExtra.vbadge, 4, 8);
        } else {
            a2.e.setVisibility(8);
        }
        a2.g.setText(friendsNotificationExtra.user_name);
        Intrinsics.c(layout, "layout");
        return layout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        CommonAlertDialog.a(f29698a.c(), "", AppInfo.d().getString(R.string.hello_call_notification_open_dialog_tips), AppInfo.d().getString(2131887320), new DialogInterface.OnClickListener() { // from class: com.soft.blued.manager.-$$Lambda$FollowedUsersNotificationManager$iy_VLfapxYXdfjpz_PwJfm94Mhg
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                FollowedUsersNotificationManager.a(dialogInterface, i);
            }
        }, AppInfo.d().getString(2131886885), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    private final View g(FriendsNotificationExtra friendsNotificationExtra) {
        View layout = LayoutInflater.from(AppInfo.d()).inflate(R.layout.privilege_user_notification_layout, (ViewGroup) null);
        PrivilegeUserNotificationLayoutBinding a2 = PrivilegeUserNotificationLayoutBinding.a(layout);
        Intrinsics.c(a2, "bind(layout)");
        a2.h.setText(friendsNotificationExtra.notification_title);
        ImageLoader.c(null, "super_privilege_user_notification.png").f().g(-1).a(a2.d);
        ImageLoader.a((IRequestHost) null, friendsNotificationExtra.user_head_img).d(2131237310).b(2131237310).c().a(a2.f29573c);
        UserInfoHelper.b(a2.f, friendsNotificationExtra.vbadge, 4, 8);
        if (!TextUtils.isEmpty(friendsNotificationExtra.privilege_user_tag)) {
            a2.g.setText(friendsNotificationExtra.privilege_user_tag);
        }
        Intrinsics.c(layout, "layout");
        return layout;
    }

    private final View h(FriendsNotificationExtra friendsNotificationExtra) {
        View layout = LayoutInflater.from(AppInfo.d()).inflate(R.layout.users_notification_layout, (ViewGroup) null);
        UsersNotificationLayoutBinding a2 = UsersNotificationLayoutBinding.a(layout);
        Intrinsics.c(a2, "bind(layout)");
        a2.n.setText(friendsNotificationExtra.notification_title);
        a2.f29610a.setVisibility(8);
        a2.i.setVisibility(0);
        if (Intrinsics.a((Object) friendsNotificationExtra.notification_type, (Object) "yy")) {
            a2.g.setVisibility(0);
            a2.h.setVisibility(8);
            ImageLoader.c(null, "anim_chat_list.png").f().g(-1).a(a2.g);
            a2.i.setImageDrawable(BluedSkinUtils.b(AppInfo.d(), R.drawable.yy_live_notification_layout_background));
        } else {
            a2.g.setVisibility(8);
            a2.h.setVisibility(0);
            ImageLoader.c(null, "anim_live_list.png").f().g(-1).a(a2.h);
            a2.i.setImageDrawable(BluedSkinUtils.b(AppInfo.d(), R.drawable.video_live_notification_layout_background));
        }
        if (!TextUtils.isEmpty(friendsNotificationExtra.rome_title)) {
            a2.m.setText(friendsNotificationExtra.rome_title);
        }
        ImageLoader.a((IRequestHost) null, friendsNotificationExtra.rome_master_img).d(2131237310).b(2131237310).c().a(a2.f);
        Intrinsics.c(layout, "layout");
        return layout;
    }

    private final View i(FriendsNotificationExtra friendsNotificationExtra) {
        View layout = LayoutInflater.from(AppInfo.d()).inflate(R.layout.users_notification_layout, (ViewGroup) null);
        UsersNotificationLayoutBinding a2 = UsersNotificationLayoutBinding.a(layout);
        Intrinsics.c(a2, "bind(layout)");
        a2.n.setText(friendsNotificationExtra.notification_title);
        a2.f29610a.setVisibility(0);
        a2.i.setVisibility(8);
        if (!TextUtils.isEmpty(friendsNotificationExtra.circle_content)) {
            a2.m.setText(friendsNotificationExtra.circle_content);
        }
        ImageLoader.a((IRequestHost) null, friendsNotificationExtra.user_head_img).d(2131237310).b(2131237310).c().a(a2.f);
        if (friendsNotificationExtra.circle_type == 0) {
            a2.f29610a.setVisibility(8);
        } else {
            a2.f29610a.setVisibility(0);
            a2.k.setVisibility(8);
            a2.l.setVisibility(8);
            if (friendsNotificationExtra.img_num == 2) {
                a2.l.setVisibility(0);
            } else if (friendsNotificationExtra.img_num > 2) {
                a2.k.setVisibility(0);
                a2.l.setVisibility(0);
            } else {
                a2.k.setVisibility(8);
                a2.l.setVisibility(8);
            }
            ImageLoader.a((IRequestHost) null, friendsNotificationExtra.img_url).a(6.0f).a(a2.b);
        }
        UserInfoHelper.b(a2.j, friendsNotificationExtra.vbadge, 4, 8);
        if (friendsNotificationExtra.circle_type == 2) {
            a2.e.setVisibility(0);
        } else {
            a2.e.setVisibility(8);
        }
        Intrinsics.c(layout, "layout");
        return layout;
    }

    public final Handler a() {
        return e;
    }

    public final void a(float f2) {
        h = f2;
    }

    public final void a(Activity activity) {
        if (activity != null) {
            FrameLayout frameLayout = (FrameLayout) activity.getWindow().getDecorView();
            SparseArray<ViewState> sparseArray = f29699c;
            ViewState viewState = sparseArray == null ? null : sparseArray.get(frameLayout.hashCode());
            if (viewState != null && viewState.a() != null) {
                a(frameLayout, viewState.a());
            }
            SparseArray<FriendsNotificationExtra> sparseArray2 = d;
            if ((sparseArray2 == null ? null : sparseArray2.get(frameLayout.hashCode())) != null) {
                d.remove(frameLayout.hashCode());
            }
        }
    }

    public final void a(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null) {
            return;
        }
        try {
            viewGroup.removeView(view);
            ViewState viewState = f29699c.get(viewGroup.hashCode());
            if ((viewState == null ? null : viewState.b()) != null) {
                Handler handler = e;
                NotificationRemoveRunnable b2 = viewState.b();
                Intrinsics.a(b2);
                handler.removeCallbacks(b2);
            }
            f29699c.remove(viewGroup.hashCode());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(final FrameLayout frameLayout, final View view, final long j) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setInterpolator(new OvershootInterpolator(1.15f));
        translateAnimation.setDuration(500L);
        translateAnimation.setFillBefore(true);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.manager.FollowedUsersNotificationManager$showAnimation$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SparseArray sparseArray;
                Intrinsics.e(animation, "animation");
                FollowedUsersNotificationManager.NotificationRemoveRunnable notificationRemoveRunnable = new FollowedUsersNotificationManager.NotificationRemoveRunnable(FrameLayout.this, view, null);
                sparseArray = FollowedUsersNotificationManager.f29699c;
                FrameLayout frameLayout2 = FrameLayout.this;
                FollowedUsersNotificationManager.ViewState viewState = (FollowedUsersNotificationManager.ViewState) sparseArray.get(frameLayout2 != null ? frameLayout2.hashCode() : 0);
                FollowedUsersNotificationManager.ViewState viewState2 = viewState;
                if (viewState == null) {
                    viewState2 = new FollowedUsersNotificationManager.ViewState(view, null);
                }
                viewState2.a(notificationRemoveRunnable);
                FollowedUsersNotificationManager.f29698a.a().postDelayed(notificationRemoveRunnable, j);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.e(animation, "animation");
            }
        });
        if (view == null) {
            return;
        }
        view.startAnimation(translateAnimation);
    }

    public final void a(FrameLayout frameLayout, final View view, FriendsNotificationExtra friendsNotificationExtra) {
        if (view == null || view.getParent() == null) {
            return;
        }
        final TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        translateAnimation.setDuration(400L);
        translateAnimation.setAnimationListener(new FollowedUsersNotificationManager$dismissAnimation$1(frameLayout, view, friendsNotificationExtra));
        e.post(new Runnable() { // from class: com.soft.blued.manager.-$$Lambda$FollowedUsersNotificationManager$8KbWHE17hSYO6Y2gpSiBbxQGc0I
            @Override // java.lang.Runnable
            public final void run() {
                FollowedUsersNotificationManager.a(View.this, translateAnimation);
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x014c, code lost:
        if (r0.equals("live") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01af, code lost:
        if (r0.equals("yy") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01bf, code lost:
        if (kotlin.jvm.internal.Intrinsics.a((java.lang.Object) r9.notification_type, (java.lang.Object) "yy") == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01c2, code lost:
        r0.f42545a = java.lang.String.valueOf(r9.yy_rome_id);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01d1, code lost:
        r0.f42545a = java.lang.String.valueOf(r9.rome_id);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01dd, code lost:
        r12 = com.soft.blued.manager.FollowedUsersNotificationManager.f29698a.h(r9);
     */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0203 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0204  */
    /* JADX WARN: Type inference failed for: r0v41, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v73, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v23, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v28, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v32, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.widget.FrameLayout r8, final com.soft.blued.ui.msg.model.FriendsNotificationExtra r9) {
        /*
            Method dump skipped, instructions count: 664
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.manager.FollowedUsersNotificationManager.a(android.widget.FrameLayout, com.soft.blued.ui.msg.model.FriendsNotificationExtra):void");
    }

    public final void a(ChattingModel chattingModel) {
        Intrinsics.e(chattingModel, "chattingModel");
        if (TextUtils.isEmpty(chattingModel.getMsgExtra())) {
            return;
        }
        if (AppInfo.m()) {
            Logger.a("user_notification", "type=" + ((int) chattingModel.msgType) + ", extra=" + ((Object) chattingModel.getMsgExtra()));
        }
        FriendsNotificationExtra friendsNotificationExtra = (FriendsNotificationExtra) AppInfo.f().fromJson(chattingModel.getMsgExtra(), (Class<Object>) FriendsNotificationExtra.class);
        friendsNotificationExtra.user_name = chattingModel.fromNickName;
        friendsNotificationExtra.user_id = String.valueOf(chattingModel.fromId);
        short s = chattingModel.msgType;
        if (s == 262) {
            friendsNotificationExtra.notification_type = IAdInterListener.AdProdType.PRODUCT_FEEDS;
        } else if (s == 263) {
            friendsNotificationExtra.notification_type = "live";
        } else if (s == 264) {
            friendsNotificationExtra.notification_type = "yy";
        } else if (s == 266) {
            friendsNotificationExtra.notification_type = "super";
        } else if (s == 270) {
            friendsNotificationExtra.user_head_img = chattingModel.fromAvatar;
            friendsNotificationExtra.notification_type = "care";
        } else if (s == 274) {
            int i = friendsNotificationExtra.push_type;
            if (i == 1) {
                friendsNotificationExtra.notification_type = "flash";
            } else if (i == 2 || i == 3) {
                friendsNotificationExtra.notification_type = "push_call_time";
            } else if (i == 4) {
                friendsNotificationExtra.user_head_img = chattingModel.fromAvatar;
                friendsNotificationExtra.notification_type = "match";
            } else if (i != 5) {
                friendsNotificationExtra.notification_type = "";
            } else {
                friendsNotificationExtra.notification_type = "bubble_feed";
            }
        } else {
            friendsNotificationExtra.notification_type = "";
        }
        if (TextUtils.equals(friendsNotificationExtra.notification_type, "")) {
            return;
        }
        a(friendsNotificationExtra);
    }

    public final void a(final FriendsNotificationExtra friendsNotificationExtra) {
        Window window;
        if (friendsNotificationExtra == null) {
            return;
        }
        Activity c2 = f29698a.c();
        if (UiUtils.a(c2)) {
            FrameLayout frameLayout = null;
            if (c2 != null && (window = c2.getWindow()) != null) {
                frameLayout = window.getDecorView();
            }
            if (frameLayout == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
            }
            final FrameLayout frameLayout2 = frameLayout;
            ViewState viewState = f29699c.get(frameLayout2.hashCode());
            if (viewState == null || viewState.a() == null) {
                f29698a.a().postDelayed(new Runnable() { // from class: com.soft.blued.manager.-$$Lambda$FollowedUsersNotificationManager$A0go089beZVN9AAI-w6dQhn7bj0
                    @Override // java.lang.Runnable
                    public final void run() {
                        FollowedUsersNotificationManager.b(FrameLayout.this, friendsNotificationExtra);
                    }
                }, 50L);
            } else {
                f29698a.a(frameLayout2, viewState.a(), friendsNotificationExtra);
            }
        }
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        f = str;
    }

    public final void a(WeakReference<Activity> weakReference) {
        g = weakReference;
    }

    public final float b() {
        return h;
    }

    public final void b(Activity activity) {
        if (activity == null) {
            return;
        }
        f29698a.a(new WeakReference<>(activity));
        FollowedUsersNotificationManager followedUsersNotificationManager = f29698a;
        String simpleName = activity.getClass().getSimpleName();
        Intrinsics.c(simpleName, "activity.javaClass.simpleName");
        followedUsersNotificationManager.a(simpleName);
        Fragment c2 = f29698a.c(activity);
        if (c2 == null) {
            return;
        }
        c2.getClass().getSimpleName();
    }

    public final boolean b(String str) {
        Activity c2 = c();
        if (c2 == null) {
            return false;
        }
        Fragment c3 = c(c2);
        if (c3 != null) {
            String simpleName = c3.getClass().getSimpleName();
            LogUtils.c(Intrinsics.a("curFragment: ", (Object) simpleName));
            return ((TextUtils.equals(str, "care") && Intrinsics.a((Object) simpleName, (Object) MsgChattingFragment.class.getSimpleName())) || Intrinsics.a((Object) simpleName, (Object) RecordingOnliveFragment.class.getSimpleName()) || Intrinsics.a((Object) simpleName, (Object) PlayingOnliveFragment.class.getSimpleName()) || Intrinsics.a((Object) simpleName, (Object) PlayingOnliveFullModeFragment.class.getSimpleName()) || Intrinsics.a((Object) simpleName, (Object) FeedAddPostFragment.class.getSimpleName()) || Intrinsics.a((Object) simpleName, (Object) PlayingStudioFragment.class.getSimpleName()) || Intrinsics.a((Object) simpleName, (Object) YYCreateRoomFragment.class.getSimpleName()) || Intrinsics.a((Object) simpleName, (Object) RecordingStudioFragment.class.getSimpleName()) || Intrinsics.a((Object) simpleName, (Object) ChannelFragment.class.getSimpleName()) || Intrinsics.a((Object) simpleName, (Object) SerialSplashFragment.class.getSimpleName())) ? false : true;
        }
        return true;
    }

    public final Activity c() {
        WeakReference<Activity> weakReference = g;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final Fragment c(Activity activity) {
        Fragment fragment = null;
        if (activity == null || !(activity instanceof FragmentActivity)) {
            return null;
        }
        List<Fragment> fragments = ((FragmentActivity) activity).getSupportFragmentManager().getFragments();
        Intrinsics.c(fragments, "activity.supportFragmentManager.fragments");
        if (fragments.isEmpty()) {
            return null;
        }
        int size = fragments.size() - 1;
        if (size < 0) {
            return null;
        }
        while (true) {
            int i = size - 1;
            Fragment fragment2 = fragments.get(size);
            Fragment fragment3 = fragment;
            if (fragment2 instanceof BaseFragment) {
                BaseFragment baseFragment = (BaseFragment) fragment2;
                fragment3 = fragment;
                if (baseFragment.isAdded()) {
                    fragment3 = fragment;
                    if (!baseFragment.isHidden()) {
                        fragment3 = fragment;
                        if (!baseFragment.isDetached()) {
                            List<Fragment> fragments2 = baseFragment.getChildFragmentManager().getFragments();
                            Intrinsics.c(fragments2, "parentFragment.childFragmentManager.fragments");
                            if (fragments2.isEmpty()) {
                                fragment3 = fragment2;
                            } else {
                                int size2 = fragments2.size() - 1;
                                fragment3 = fragment;
                                if (size2 >= 0) {
                                    while (true) {
                                        int i2 = size2 - 1;
                                        fragment3 = fragments2.get(size2);
                                        if (!(fragment3 instanceof BaseFragment) || !((BaseFragment) fragment3).getUserVisibleHint()) {
                                            fragment3 = fragment2;
                                        }
                                        if (i2 < 0) {
                                            break;
                                        }
                                        size2 = i2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (i < 0) {
                return fragment3;
            }
            size = i;
            fragment = fragment3;
        }
    }
}
