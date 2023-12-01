package com.blued.android.similarity_operation_provider;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import com.alipay.sdk.cons.c;
import com.android.ims.ImsConferenceState;
import com.app.share.model.ShareEntity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.Hashids;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.SafeUtils;
import com.blued.android.framework.urlroute.BluedURIRouter;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.base.game_center.GameCenterProxy;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.model.LiveChargeCouponModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.model.VerifyStatus;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.widget.emoticon.manager.EmotionManager;
import com.blued.android.module.live_china.fragment.LiveFootPrintFragmentN;
import com.blued.android.module.live_china.fragment.LiveLiangPayFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveTagsSetSelectedTab;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.YYApplyFragment;
import com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment;
import com.blued.android.module.yy_china.fragment.YYFullServiceSquareFragment;
import com.blued.android.module.yy_china.fragment.YYHotTopicListFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYJoinRoomJumpInfoMode;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.circle.fragment.CircleDetailsFragment;
import com.blued.community.ui.circle.fragment.CircleNewFragment;
import com.blued.community.ui.circle.fragment.CirclePostDetailsFragment;
import com.blued.community.ui.circle.fragment.CircleTypeListFragment;
import com.blued.community.ui.circle.manager.CircleConstants;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.event.fragment.EventDetailsFragment;
import com.blued.community.ui.event.fragment.EventListFragment;
import com.blued.community.ui.event.model.EventLogData;
import com.blued.community.ui.feed.fragment.FeedDetailsFragment;
import com.blued.community.ui.feed.fragment.SignFeedListFragment;
import com.blued.community.ui.feed.manager.FeedConstants;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.feed.model.FeedDetailParams;
import com.blued.community.ui.send.fragment.CircleAddPostFragment;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.send.fragment.FeedPostSignStateFragment;
import com.blued.community.ui.square.fragment.HotFeedFragment;
import com.blued.community.ui.topic.fragment.SuperTopicDetailFragment;
import com.blued.community.ui.topic.fragment.SuperTopicFragment;
import com.blued.community.ui.video.fragment.ShineVideoListFragment;
import com.blued.community.ui.video.fragment.VideoScanFragment;
import com.blued.community.utils.CommunityPreferences;
import com.blued.community.utils.UserInfoUtils;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.sobot.chat.ZCSobotApi;
import com.sobot.chat.api.enumtype.SobotChatTitleDisplayMode;
import com.sobot.chat.api.model.Information;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.log.bytedance.CallEventUtils;
import com.soft.blued.log.mobevent.MobEventUtils;
import com.soft.blued.sdk.ui.SDKPayFragment;
import com.soft.blued.ui.discover.fragment.ShineVideoListIndepFragment;
import com.soft.blued.ui.discover.observer.DiscoverSquareViewModel;
import com.soft.blued.ui.find.fragment.FindSearchMapFragment;
import com.soft.blued.ui.find.fragment.HelloOpenDialogFragment;
import com.soft.blued.ui.find.fragment.NearbyLiveFragment;
import com.soft.blued.ui.find.fragment.NearbyModuleUsersFragment;
import com.soft.blued.ui.find.fragment.VisitHistoryFragment;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.find.observer.NearbyFindSetSelectedTab;
import com.soft.blued.ui.find.observer.NearbyPeoplePushTypeObserver;
import com.soft.blued.ui.find.observer.NearbyPeopleTabSelectedObserver;
import com.soft.blued.ui.find.observer.VisitRecordSelectedTabObserver;
import com.soft.blued.ui.group.GroupSearchListFragment;
import com.soft.blued.ui.group.UserGroupListsFragment;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.live.fragment.LiveApplyFragment;
import com.soft.blued.ui.live.fragment.LiveApplyImproveFragment;
import com.soft.blued.ui.live.fragment.LiveApplySimpleFragment;
import com.soft.blued.ui.live.fragment.LiveGrabListFragment;
import com.soft.blued.ui.live.fragment.LiveJoinFansFragment;
import com.soft.blued.ui.live.fragment.LiveYYImproveFragment;
import com.soft.blued.ui.live.model.RecommendAnchorFragment;
import com.soft.blued.ui.msg.ChatBgSettingFragment;
import com.soft.blued.ui.msg.DialogSkipFragment;
import com.soft.blued.ui.msg.MessagePageFragment;
import com.soft.blued.ui.msg.MsgBoxSettingDialogFragment;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.customview.GlobalTaskFloatManager;
import com.soft.blued.ui.msg.fragment.EmotionDetailFragment;
import com.soft.blued.ui.msg.fragment.EmotionMainFragment;
import com.soft.blued.ui.msg.fragment.HelloFragment;
import com.soft.blued.ui.msg.model.ChannelModel;
import com.soft.blued.ui.msg_group.event.UpdateGroupGradeEvent;
import com.soft.blued.ui.msg_group.fragment.GroupInfoFragment;
import com.soft.blued.ui.msg_group.fragment.MyGroupFragmentNew;
import com.soft.blued.ui.msg_group.fragment.RecommendGroupFragment;
import com.soft.blued.ui.msg_group.utils.GroupHelper;
import com.soft.blued.ui.pay.BeansPrePayFragment;
import com.soft.blued.ui.pay.LiveChargeCouponFragment;
import com.soft.blued.ui.setting.fragment.AboutBluedFragment;
import com.soft.blued.ui.setting.fragment.BlacklistFragment;
import com.soft.blued.ui.setting.fragment.ChangeBluedIconFragment;
import com.soft.blued.ui.setting.fragment.FeedBackFragmentNew;
import com.soft.blued.ui.setting.fragment.HelpCenterFragment;
import com.soft.blued.ui.setting.fragment.LanguageSelectFragment;
import com.soft.blued.ui.setting.fragment.LiveSettingFragment;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.ui.setting.fragment.PasswordSettingFragment;
import com.soft.blued.ui.setting.fragment.PersonalVerifyFragment;
import com.soft.blued.ui.setting.fragment.PrivacySettingFragment;
import com.soft.blued.ui.setting.fragment.RemindSettingFragment;
import com.soft.blued.ui.setting.fragment.SettingFragment;
import com.soft.blued.ui.setting.fragment.ShowVerifyFragment;
import com.soft.blued.ui.setting.tools.ServiceHelper;
import com.soft.blued.ui.tag_show.UserTagCombineFragment;
import com.soft.blued.ui.user.fragment.DynamicSkinFragment;
import com.soft.blued.ui.user.fragment.FollowedAndFansFragment;
import com.soft.blued.ui.user.fragment.InterestGalleryFragment;
import com.soft.blued.ui.user.fragment.PayPreOrderFragment;
import com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment;
import com.soft.blued.ui.user.fragment.SuperExposureFragment;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.fragment.VIPBuyFragment;
import com.soft.blued.ui.user.fragment.VIPCenterNewFragment;
import com.soft.blued.ui.user.fragment.VIPCustomizedFragment;
import com.soft.blued.ui.user.fragment.VIPLvlPrivilegeFragment;
import com.soft.blued.ui.user.fragment.VipBubbleFragment;
import com.soft.blued.ui.user.fragment.WidgetListFragment;
import com.soft.blued.ui.user.model.GoodsOptionBasic;
import com.soft.blued.ui.user.observer.FollowAndFansSelectedTabObserver;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.web.ActivityStackManager;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.ui.welcome.BaseADVideoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.CalendarProviderUtil;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.WeChatUtils;
import com.soft.blued.utils.activity.BDActivityManager;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/similarity_operation_provider/BluedURIRouterAdapter.class */
public class BluedURIRouterAdapter {
    private static final String TAG = BluedURIRouterAdapter.class.getSimpleName();

    public static boolean addCalendarEvent(Context context, String str, String str2, long j, long j2, long j3, int i, int i2, int i3) {
        CalendarProviderUtil.a(context, str, str2, j * 1000, j2 * 1000, j3, i, i2, i3);
        return true;
    }

    public static boolean backLoginPhone(Context context) {
        ActivityStackManager.a().b();
        BluedPreferences.af(false);
        return true;
    }

    public static boolean backLoginPhoneSign(Context context) {
        BluedPreferences.af(true);
        return true;
    }

    public static boolean buyLiveLiang(Context context, String str, int i, long j) {
        LiveLiangPayFragment.a(context, str, i, j);
        return true;
    }

    public static boolean checkCloseAccountResult(Context context, String str) {
        UserRelationshipUtils.a(context, str);
        return true;
    }

    public static boolean commonPay(Context context, int i, int i2, int i3, int i4, String str, String str2, String str3, int i5, String str4) {
        GoodsOptionBasic goodsOptionBasic = new GoodsOptionBasic();
        goodsOptionBasic.id = i;
        goodsOptionBasic.c_id = i4;
        goodsOptionBasic.feed_id = str4;
        goodsOptionBasic.alipay_contract = i2;
        goodsOptionBasic.wx_contract = i3;
        String str5 = str2;
        if (TextUtils.equals(str2, "mine_shadow")) {
            str5 = str3;
        }
        if (i5 == 1) {
            PayPreOrderFragment.a(context, goodsOptionBasic, str, str5, 1);
            return true;
        } else if (i5 == 2) {
            PayPreOrderFragment.a(context, goodsOptionBasic, str, str5, 2);
            return true;
        } else if (i5 == 3) {
            PayPreOrderFragment.a(context, goodsOptionBasic, str, str5, 4);
            return true;
        } else if (i5 != 4) {
            PayPreOrderFragment.a(context, goodsOptionBasic, str, str5, 0);
            return true;
        } else {
            PayPreOrderFragment.a(context, goodsOptionBasic, str, str5, 3);
            return true;
        }
    }

    public static boolean downloadedEmotionPack(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        EmotionManager.a(str);
        return true;
    }

    public static boolean exposureInventoryBuySuccess(Context context, String str) {
        PayUtils.a(context, "", str);
        return true;
    }

    public static boolean exposurePaidCallback(Context context, int i, String str, int i2) {
        if (i == 1 && !BluedPreferences.dZ().equals(str)) {
            BluedPreferences.ag(str);
            MobEventUtils.a();
        }
        if (i == 1) {
            PayUtils.a(context, "", str, i2);
            return true;
        }
        return true;
    }

    public static boolean goBuyBeansFromLiving(Context context, int i, String str) {
        LiveRefreshUIObserver.a().a(i);
        return true;
    }

    public static boolean goBuyCallCharge(Context context, String str) {
        Log.v("drb", "呼唤购买弹窗:" + str);
        if (!TextUtils.isEmpty(str)) {
            boolean z = true;
            int hashCode = str.hashCode();
            if (hashCode != -235377960) {
                if (hashCode != 119794870) {
                    if (hashCode == 1536204444 && str.equals("vocative_end_report")) {
                        z = true;
                    }
                } else if (str.equals("mine_vocative_order")) {
                    z = false;
                }
            } else if (str.equals("mine_vocative_order_is_remain")) {
                z = true;
            }
            if (!z) {
                CallEventUtils.a("ORDER_BUY");
            } else if (z) {
                CallEventUtils.a("REPORT_KEEP_ON");
            } else if (z) {
                CallEventUtils.a("ORDER_BUY_MORE");
            }
        }
        PrivilegeBuyDialogFragment.a(context, 9, str, false);
        return true;
    }

    public static boolean goCallOpen(Context context, int i) {
        HelloOpenDialogFragment.a(context, i, 0);
        return true;
    }

    public static boolean goChatAndOpenMsgBox(FragmentManager fragmentManager, int i) {
        MsgBoxSettingDialogFragment msgBoxSettingDialogFragment = new MsgBoxSettingDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("vipFrom", i);
        msgBoxSettingDialogFragment.setArguments(bundle);
        msgBoxSettingDialogFragment.show(fragmentManager, "");
        return true;
    }

    public static boolean liveGiftPackageBack(Context context, String str, int i) {
        LiveRefreshUIObserver.a().a(str, i);
        return true;
    }

    public static boolean openAbout(Context context) {
        TerminalActivity.d(context, AboutBluedFragment.class, null);
        return true;
    }

    public static boolean openAppIconChange(Context context) {
        ChangeBluedIconFragment.a(context);
        return true;
    }

    public static boolean openAvChatDial(Context context, int i, String str, String str2, String str3, int i2) {
        try {
            ChannelModel channelModel = new ChannelModel();
            if (i == 1) {
                channelModel.callType = 1;
            } else if (i != 2) {
                return false;
            } else {
                channelModel.callType = 0;
            }
            channelModel.remoteUid = Integer.valueOf(EncryptTool.a(str)).intValue();
            channelModel.remoteUserName = URLDecoder.decode(str2, "UTF-8");
            channelModel.remoteUserHead = URLDecoder.decode(str3, "UTF-8");
            DialogSkipFragment.a(context, channelModel);
            return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean openAvChatReceive(Context context, long j, int i, String str, String str2, int i2, String str3, String str4, int i3) {
        try {
            ChannelModel channelModel = new ChannelModel();
            if (i == 1) {
                channelModel.callType = 3;
            } else if (i != 2) {
                return false;
            } else {
                channelModel.callType = 2;
            }
            channelModel.channelId = str;
            channelModel.remoteUid = Integer.valueOf(EncryptTool.a(str2)).intValue();
            channelModel.remoteUserName = URLDecoder.decode(str3, "UTF-8");
            channelModel.remoteUserHead = URLDecoder.decode(str4, "UTF-8");
            channelModel.chat_sdk_type = i2;
            if ((System.currentTimeMillis() / 1000) - j < 60) {
                DialogSkipFragment.a(context, channelModel);
                return true;
            }
            return false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean openBaseExplore(Context context, int i) {
        if (BluedConfig.a().K()) {
            CircleTypeListFragment.a.a(context, i, FeedProtos.SourcePage.UNKNOWN_SOURCE_PAGE);
            return true;
        }
        ToastUtils.a(context.getString(2131887260));
        return true;
    }

    @Deprecated
    public static boolean openBluedPay(Context context, int i, String str, String str2, String str3, String str4) {
        SDKPayFragment.a(context, 0L, i, (String) null, (String) null, str, str2, str3, str4);
        return true;
    }

    public static boolean openCallAlert(final Context context) {
        CallHelloManager.a().a(context, (IRequestHost) null, 9, new CallHelloManager.ToOpenListener() { // from class: com.blued.android.similarity_operation_provider.BluedURIRouterAdapter.16
            public void done(boolean z) {
                if (z) {
                    CallHelloManager.a().a(context, (IRequestHost) null, false, 9);
                }
            }
        });
        return true;
    }

    public static boolean openChargePage(Context context, int i, String str) {
        BeansPrePayFragment.a(context, i, str);
        return true;
    }

    public static boolean openCircleApplyJoin(Context context, String str, String str2, String str3, int i) {
        CircleMethods.a(context, EncryptTool.a(str), str3, str2, i == 1, true);
        return true;
    }

    public static boolean openCircleDetail(Context context, int i, String str, int i2, int i3, int i4) {
        if (!BluedConfig.a().K()) {
            ToastUtils.a(context.getString(2131887260));
            return true;
        }
        String a = EncryptTool.a(str);
        if (i2 != 1) {
            CircleNewFragment.a(context);
        }
        CircleDetailsFragment.a(context, a, i, CircleConstants.CIRCLE_FROM_PAGE.LINK, i3, i4 == 1);
        return true;
    }

    public static boolean openCirclePage(Context context) {
        CircleNewFragment.a(context);
        return true;
    }

    public static boolean openCirclePost(Context context, String str, String str2, String str3) {
        CircleAddPostFragment.a(context, EncryptTool.a(str), str2, str3);
        return true;
    }

    public static boolean openCirclePostDetail(Context context, String str, String str2, int i, int i2) {
        if (!BluedConfig.a().K()) {
            ToastUtils.a(context.getString(2131887260));
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            CircleDetailsFragment.a(context, str, 0, CircleConstants.CIRCLE_FROM_PAGE.LINK, i, false);
        }
        CirclePostDetailsFragment.a(context, str2, FeedProtos.NoteSource.UNKNOWN_NOTE_SOURCE, i2 == 1);
        return true;
    }

    public static boolean openDiscoveryNotice(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("to_message_tab", "0");
        HomeArgumentHelper.a(context, c.b, bundle);
        return true;
    }

    public static boolean openDiscoveryNoticeZan(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("to_message_tab", "0");
        HomeArgumentHelper.a(context, c.b, bundle);
        return true;
    }

    public static boolean openDiscoveryPage(Context context, final int i, int i2) {
        HomeArgumentHelper.a(context, "feed", (Bundle) null);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.similarity_operation_provider.BluedURIRouterAdapter.5
            @Override // java.lang.Runnable
            public void run() {
                if (HomeActivity.c != null) {
                    ViewModelProviders.of(HomeActivity.c).get(DiscoverSquareViewModel.class).a.postValue(Integer.valueOf(i));
                }
            }
        }, 500L);
        return true;
    }

    public static boolean openEmotionDetail(Context context, String str) {
        EmotionDetailFragment.a(context, 0, str);
        return true;
    }

    public static boolean openEmotionShop(Context context, int i) {
        EmotionMainFragment.a(context, i);
        return true;
    }

    public static boolean openEventDetails(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        EventLogData eventLogData = new EventLogData();
        eventLogData.setEventId(str);
        if ("SUBSCRIBE_MSG".equalsIgnoreCase(str2)) {
            eventLogData.setSourcePage(FeedProtos.SourcePage.SUBSCRIBE_MSG);
        } else if ("SCORE_MSG".equalsIgnoreCase(str2)) {
            eventLogData.setSourcePage(FeedProtos.SourcePage.SCORE_MSG);
        } else if ("FEED_MSG".equalsIgnoreCase(str2)) {
            eventLogData.setSourcePage(FeedProtos.SourcePage.FEED_MSG);
        } else {
            eventLogData.setSourcePage(FeedProtos.SourcePage.FEED_MSG);
        }
        EventDetailsFragment.a.a(context, str, eventLogData);
        return true;
    }

    public static boolean openEventList(Context context) {
        EventListFragment.a.a(context);
        return true;
    }

    public static boolean openEventMembers(Context context, int i, String str) {
        TextUtils.isEmpty(str);
        return true;
    }

    public static boolean openFans(Context context) {
        LiveJoinFansFragment.a(context);
        return true;
    }

    public static boolean openFeedBubbleState(Context context) {
        FeedPostSignStateFragment.a.a(context, 10);
        return true;
    }

    public static boolean openFeedDetailPage(final Context context, final String str, final String str2, final int i, int i2, final String str3) {
        Log.v("drb", "openFeedDetailPage feedId:" + str + "  comment_id:" + str2);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i2 == 4) {
            HomeArgumentHelper.a(context, "find", (Bundle) null);
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.similarity_operation_provider.BluedURIRouterAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    NearbyFindSetSelectedTab.a().a(1);
                }
            }, 300L);
        } else if (i2 == 3) {
            HomeArgumentHelper.a(context, "feed", (Bundle) null);
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.similarity_operation_provider.BluedURIRouterAdapter.3
                @Override // java.lang.Runnable
                public void run() {
                    if (HomeActivity.c != null) {
                        ViewModelProviders.of(HomeActivity.c).get(DiscoverSquareViewModel.class).a.postValue(1);
                    }
                }
            }, 300L);
        } else if (i2 == 2) {
            HotFeedFragment.a.a(context);
        } else if (i2 == 1) {
            MessagePageFragment.b = 0;
            Bundle bundle = new Bundle();
            bundle.putString("to_message_tab", "0");
            Log.v("drb", "跳转到首页");
            HomeArgumentHelper.a(context, c.b, bundle);
        }
        if (TextUtils.equals(str3, "like")) {
            HomeArgumentHelper.a(context, "feed", (Bundle) null);
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.similarity_operation_provider.BluedURIRouterAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
                bluedIngSelfFeed.feed_id = String.this;
                bluedIngSelfFeed.is_ads = i;
                Log.v("drb", "跳转到动态详情");
                FeedDetailParams feedDetailParams = new FeedDetailParams(0);
                feedDetailParams.commentID = str2;
                if (!TextUtils.isEmpty(str3)) {
                    feedDetailParams.agency = str3;
                }
                FeedDetailsFragment.a(context, bluedIngSelfFeed, 7, feedDetailParams);
            }
        }, 500L);
        return true;
    }

    public static boolean openFeedPost(Context context, String str, String str2, String str3, String str4, int i, int i2, int i3, int i4) {
        String str5;
        try {
            str5 = URLDecoder.decode(str4, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            str5 = "";
        }
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.content = str;
        shareEntity.netImgUrl = str2;
        shareEntity.shareType = 1;
        if (context == null) {
            context = AppInfo.d();
        }
        FeedAddPostFragment.a(context, shareEntity, str3, str5, i == 1, i2, i3 == 1, i4 == 1);
        return true;
    }

    public static boolean openFeedSignList(Context context, int i) {
        SignFeedListFragment.b.a(context, "", i);
        return true;
    }

    public static boolean openFeedback(Context context) {
        FeedBackFragmentNew.a(context);
        return true;
    }

    public static boolean openFlutterFeedExposure(Context context, String str, String str2) {
        String a = EncryptTool.a(str);
        LogUtils.c("openFlutterFeedExposure:" + a + ", origin:" + str);
        return openFlutterFeedExposureWithId(context, a, str2);
    }

    public static boolean openFlutterFeedExposureWithId(Context context, String str, String str2) {
        if (str != null) {
            SuperExposureFragment.a.a(context, str, str2);
            return true;
        }
        return true;
    }

    public static boolean openFollowAndFans(Context context, final int i) {
        FollowedAndFansFragment.a(context, UserInfo.getInstance().getLoginUserInfo().getUid());
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.similarity_operation_provider.BluedURIRouterAdapter.8
            @Override // java.lang.Runnable
            public void run() {
                FollowAndFansSelectedTabObserver.a().a(i);
            }
        }, 500L);
        return true;
    }

    public static boolean openGameHall(Context context) {
        GameCenterProxy.a().a(context, null);
        return true;
    }

    public static boolean openGroupInfoPage(Context context, String str, int i) {
        String str2 = str;
        if (i == 1) {
            str2 = str;
            if (!TextUtils.isEmpty(str)) {
                str2 = EncryptTool.a(str);
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        GroupInfoFragment.a(context, str2, (GroupInfoModel) null, SocialNetWorkProtos.SourceType.UNKNOWN_SOURCE_TYPE);
        return true;
    }

    public static boolean openGroupNotification(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("arg_open_homeactivity_ope", "ope_group_notification");
        bundle.putString("to_message_tab", "0");
        HomeArgumentHelper.a(context, c.b, bundle);
        return true;
    }

    public static boolean openHelloDetail(Context context, String str) {
        if (StringUtils.d(str)) {
            return false;
        }
        try {
            HelloFragment.a(context, URLDecoder.decode(str, "UTF-8"));
            return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean openHelpCenter(Context context) {
        HelpCenterFragment.a(context);
        return true;
    }

    public static boolean openHomePageToLiveList(Context context, int i, final String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("arg_open_homeactivity_ope", "ope_livelist");
        bundle.putString("live_from", "web");
        bundle.putString("live_pay_beans_details", str2);
        HomeArgumentHelper.a(context, "live", bundle);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.similarity_operation_provider.BluedURIRouterAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                LiveTagsSetSelectedTab.a().a(String.this);
            }
        }, 1000L);
        return true;
    }

    public static boolean openHomepageMessage(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("details", str);
        HomeArgumentHelper.a(context, c.b, bundle);
        return true;
    }

    public static boolean openHomepageMine(Context context) {
        HomeArgumentHelper.a(context, "mine", (Bundle) null);
        return true;
    }

    public static boolean openLangeageSetting(Context context) {
        LanguageSelectFragment.a(context);
        return true;
    }

    public static boolean openLiveApply(Context context) {
        TerminalActivity.d(context, LiveApplyFragment.class, null);
        return true;
    }

    public static boolean openLiveChargeCoupon(Context context) {
        TerminalActivity.d(context, LiveChargeCouponFragment.class, null);
        return true;
    }

    public static boolean openLiveFootPrint(Context context) {
        TerminalActivity.d(context, LiveFootPrintFragmentN.class, null);
        return true;
    }

    public static boolean openLiveHB(Context context) {
        LiveGrabListFragment.b.a(context);
        return true;
    }

    public static boolean openLiveImprovePage(Context context) {
        LiveApplyImproveFragment.a(context);
        return true;
    }

    public static boolean openLivePlayPage(Context context, long j, String str, String str2, String str3, String str4) {
        if (LiveRoomManager.a().K()) {
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putString("arg_open_homeactivity_ope", "ope_liveplay");
        LiveRoomData liveRoomData = new LiveRoomData(j, 0, str2, str, "", "", 0);
        liveRoomData.note_type = str3;
        liveRoomData.details = str4;
        bundle.putSerializable("live_anchor_model", liveRoomData);
        HomeArgumentHelper.a(context, "live", bundle);
        return true;
    }

    public static boolean openLiveRecommendMore(Context context) {
        RecommendAnchorFragment.show(context);
        return true;
    }

    public static boolean openLiveSettingPage(Context context) {
        TerminalActivity.d(context, LiveSettingFragment.class, null);
        return true;
    }

    public static boolean openLiveSimplePage(Context context) {
        LiveApplySimpleFragment.a(context, (BluedLiveState) null);
        return true;
    }

    public static boolean openLiveVip(Context context) {
        LiveEventBusUtil.k();
        return true;
    }

    public static boolean openLiveWholeStationRank(Context context) {
        LiveEventBusUtil.m();
        return true;
    }

    public static boolean openMapFind(final Context context) {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.similarity_operation_provider.BluedURIRouterAdapter.9
            @Override // java.lang.Runnable
            public void run() {
                Activity activity = context;
                if (BDActivityManager.a.a() != null) {
                    activity = BDActivityManager.a.a();
                }
                if (activity instanceof BaseFragmentActivity) {
                    FindSearchMapFragment.a((BaseFragmentActivity) activity, 2);
                }
            }
        }, 200L);
        return true;
    }

    public static boolean openModifyProfile(Context context, int i) {
        ModifyUserInfoFragment.a(context, i == 1);
        return true;
    }

    public static boolean openMyBlacklist(Context context) {
        TerminalActivity.d(context, BlacklistFragment.class, null);
        return true;
    }

    public static boolean openMyGroup(Context context) {
        TerminalActivity.d(context, UserGroupListsFragment.class, null);
        return true;
    }

    public static boolean openMyGroups(Context context, boolean z, int i) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("group_my_need_anim", z);
        bundle.putInt("group_my_index", i);
        TerminalActivity.d(context, MyGroupFragmentNew.class, bundle);
        return true;
    }

    public static boolean openNativeVIPCenter(Context context, String str, String str2) {
        if (StringUtils.d(str)) {
            VIPCenterNewFragment.a(context, -1, str2);
            return true;
        }
        int a = SafeUtils.a(str);
        VIPCenterNewFragment.a(context, (a == 0 || a == 1) ? 0 : 1, str2);
        return true;
    }

    public static boolean openNearbyGroup(Context context) {
        RecommendGroupFragment.b.a(context);
        return true;
    }

    public static boolean openNearbyHomeTab(Context context, final int i, final String str) {
        HomeArgumentHelper.a(context, "find", (Bundle) null);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.similarity_operation_provider.BluedURIRouterAdapter.10
            @Override // java.lang.Runnable
            public void run() {
                NearbyFindSetSelectedTab.a().a(i);
            }
        }, 500L);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.similarity_operation_provider.BluedURIRouterAdapter.11
            @Override // java.lang.Runnable
            public void run() {
                NearbyPeopleTabSelectedObserver.a().a(String.this);
            }
        }, 1000L);
        return true;
    }

    public static boolean openNearbyModule(Context context, int i, String str) {
        String str2;
        if (i == 0) {
            NearbyLiveFragment.a(context);
            return true;
        }
        try {
            str2 = URLDecoder.decode(str, "UTF-8");
        } catch (Exception e) {
            str2 = "";
        }
        NearbyModuleUsersFragment.a(context, i, str2);
        return true;
    }

    public static boolean openNearbyPage(Context context, final int i, final String str) {
        HomeArgumentHelper.a(context, "find", (Bundle) null);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.similarity_operation_provider.BluedURIRouterAdapter.6
            @Override // java.lang.Runnable
            public void run() {
                NearbyFindSetSelectedTab.a().a(i);
                NearbyPeoplePushTypeObserver.a().a(str);
            }
        }, 500L);
        return true;
    }

    public static boolean openNearbyPeopleCloseRedPackGuide(Context context) {
        LiveEventBus.get("refresh_red_pack_guide_state").post(true);
        return true;
    }

    public static boolean openNewFans(Context context) {
        ChatHelperV4.a().a(context, 5L, 0L);
        return true;
    }

    public static boolean openNotificationSetting(Context context) {
        TerminalActivity.d(context, RemindSettingFragment.class, null);
        return true;
    }

    public static boolean openOnlineService(Context context, boolean z) {
        String c;
        Information information = new Information();
        information.setApp_key(context.getString(2131891773));
        information.setShowLeftBackPop(true);
        information.setShowSatisfaction(true);
        information.setHideMenuLeave(false);
        if (UserInfoUtils.f()) {
            c = UserInfoUtils.c();
        } else {
            c = System.currentTimeMillis() + "";
        }
        try {
            information.setPartnerid(new Hashids("2765", 24).a(Long.parseLong(c)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        information.setUname(information.getPartnerid());
        information.setUser_name(information.getPartnerid());
        information.setUser_nick(information.getPartnerid());
        information.setUseVoice(false);
        if (z) {
            information.setService_mode(2);
            information.setCloseInquiryForm(true);
        }
        ZCSobotApi.setEvaluationCompletedExit(context, true);
        ZCSobotApi.setSwitchMarkStatus(2, false);
        information.setHideMenuVedio(true);
        ZCSobotApi.setChatTitleDisplayMode(context, SobotChatTitleDisplayMode.Default, "", true);
        ZCSobotApi.openZCChat(context, information);
        return true;
    }

    public static boolean openPasswordSetting(Context context) {
        TerminalActivity.d(context, PasswordSettingFragment.class, null);
        return true;
    }

    public static boolean openPasswordSettingPage(Context context) {
        TerminalActivity.d(context, PasswordSettingFragment.class, null);
        return true;
    }

    public static boolean openPersonalVerifyPage(Context context) {
        String avatar = UserInfo.getInstance().getLoginUserInfo().getAvatar();
        String name = UserInfo.getInstance().getLoginUserInfo().getName();
        String uid = UserInfo.getInstance().getLoginUserInfo().getUid();
        VerifyStatus[] verify = UserInfo.getInstance().getLoginUserInfo().getVerify();
        if (verify == null || verify.length <= 0 || !"1".equals(verify[0].has_audited)) {
            PersonalVerifyFragment.a(context);
            return true;
        }
        ShowVerifyFragment.a(context, name, avatar, verify[0].verified_time, uid, false);
        return true;
    }

    public static boolean openPictureLib(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("tab_id", str);
        TerminalActivity.d(context, InterestGalleryFragment.class, bundle);
        return true;
    }

    public static boolean openPrivacySetting(Context context) {
        TerminalActivity.d(context, PrivacySettingFragment.class, null);
        return true;
    }

    public static boolean openRightOption(Context context) {
        VIPCenterNewFragment.a(context, -1, "");
        return true;
    }

    public static boolean openScanPage(Context context) {
        ShineVideoListFragment.a(context);
        return true;
    }

    public static boolean openSearchGroup(Context context, String str) {
        GroupSearchListFragment.a(context, str);
        return true;
    }

    public static boolean openServiceCenter(Context context) {
        ServiceHelper.a.a(context);
        return true;
    }

    public static boolean openSetting(Context context) {
        SettingFragment.a(context);
        return true;
    }

    public static boolean openShadowSetting(final Context context) {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.similarity_operation_provider.BluedURIRouterAdapter.12
            @Override // java.lang.Runnable
            public void run() {
                Activity activity = context;
                if (BDActivityManager.a.a() != null) {
                    activity = BDActivityManager.a.a();
                }
                if (activity instanceof BaseFragmentActivity) {
                    FindSearchMapFragment.a((BaseFragmentActivity) activity, 1);
                }
            }
        }, 200L);
        return true;
    }

    public static boolean openShineVideoDetail(Context context, String str) {
        VideoScanFragment.a(context, str);
        return true;
    }

    public static boolean openShineVideoList(Context context) {
        ShineVideoListIndepFragment.a(context);
        return true;
    }

    public static boolean openSpecialCare(Context context) {
        return true;
    }

    public static boolean openStartLive(Context context, int i, int i2, String str, int i3, String str2, int i4) {
        Log.i("xpm", "type:" + i + "  screen:" + i2 + "  liveOuterType:" + i4);
        RecordingOnliveFragment.a(context, i, i2, str, i3, str2, i4);
        return true;
    }

    public static boolean openTagCombine(Context context, String str, String str2, int i) {
        String str3;
        try {
            str3 = URLDecoder.decode(str2, "UTF-8");
        } catch (Exception e) {
            str3 = "";
        }
        UserTagCombineFragment.a(context, str, str3, i);
        return true;
    }

    public static boolean openTopicPage(Context context) {
        SuperTopicFragment.a(context);
        return true;
    }

    public static boolean openTopicPage(Context context, String str, String str2, String str3) {
        String str4;
        if (LiveRoomManager.a().K()) {
            return true;
        }
        FeedConstants.b = FeedProtos.DetailFrom.UNKNOWN_DETAIL_FROM;
        if (!TextUtils.isEmpty(str)) {
            SuperTopicDetailFragment.a(context, str, str3);
            return true;
        } else if (TextUtils.isEmpty(str2)) {
            return false;
        } else {
            try {
                str4 = URLDecoder.decode(str2, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                str4 = "";
            }
            SuperTopicDetailFragment.b(context, str4);
            return true;
        }
    }

    public static boolean openUserInfoPage(Context context, String str, String str2, int i, int i2, String str3, boolean z, String str4) {
        String str5;
        if (LiveRoomManager.a().K()) {
            return true;
        }
        String str6 = str;
        if (i == 1) {
            str6 = str;
            if (!TextUtils.isEmpty(str)) {
                str6 = EncryptTool.a(str);
            }
        }
        if (z) {
            Bundle bundle = new Bundle();
            UserBasicModel userBasicModel = new UserBasicModel();
            userBasicModel.uid = UserInfo.getInstance().getLoginUserInfo().uid;
            bundle.putSerializable(ImsConferenceState.USER, userBasicModel);
            bundle.putString("userfrom", str3);
            bundle.putInt("tab", i2);
            bundle.putString("user_to", str4);
            TerminalActivity.a(bundle);
            TerminalActivity.d(context, UserInfoFragmentNew.class, bundle);
            return true;
        } else if (!TextUtils.isEmpty(str6)) {
            Bundle bundle2 = new Bundle();
            UserBasicModel userBasicModel2 = new UserBasicModel();
            userBasicModel2.uid = str6;
            bundle2.putSerializable(ImsConferenceState.USER, userBasicModel2);
            bundle2.putString("userfrom", str3);
            bundle2.putInt("tab", i2);
            TerminalActivity.a(bundle2);
            TerminalActivity.d(context, UserInfoFragmentNew.class, bundle2);
            return true;
        } else if (TextUtils.isEmpty(str2)) {
            return false;
        } else {
            Bundle bundle3 = new Bundle();
            try {
                str5 = URLDecoder.decode(str2, "UTF-8");
            } catch (Exception e) {
                str5 = "";
            }
            bundle3.putString("nickname", str5);
            bundle3.putBoolean("if_from_name", true);
            bundle3.putString("userfrom", str3);
            bundle3.putInt("tab", i2);
            TerminalActivity.a(bundle3);
            TerminalActivity.d(context, UserInfoFragmentNew.class, bundle3);
            return true;
        }
    }

    public static boolean openVIPBuyDialog(Context context, int i, String str) {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0029 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean openVIPBuyPage(android.content.Context r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            r0 = r7
            boolean r0 = com.soft.blued.utils.StringUtils.d(r0)
            r15 = r0
            r0 = -1
            r14 = r0
            r0 = r15
            if (r0 != 0) goto L1a
            r0 = r7
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Exception -> L42
            int r0 = r0.intValue()     // Catch: java.lang.Exception -> L42
            r12 = r0
            goto L1d
        L1a:
            r0 = -1
            r12 = r0
        L1d:
            r0 = r14
            r13 = r0
            r0 = r11
            boolean r0 = com.soft.blued.utils.StringUtils.d(r0)
            if (r0 != 0) goto L33
            r0 = r11
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Exception -> L46
            int r0 = r0.intValue()     // Catch: java.lang.Exception -> L46
            r13 = r0
        L33:
            r0 = r6
            r1 = r12
            r2 = r10
            r3 = r13
            com.blued.das.vip.VipProtos$FromType r4 = com.blued.das.vip.VipProtos.FromType.UNKNOWN_FROM
            com.soft.blued.ui.user.presenter.PayUtils.a(r0, r1, r2, r3, r4)
            r0 = 1
            return r0
        L42:
            r7 = move-exception
            goto L1a
        L46:
            r7 = move-exception
            r0 = r14
            r13 = r0
            goto L33
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.similarity_operation_provider.BluedURIRouterAdapter.openVIPBuyPage(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public static boolean openVIPBuyWithCoupon(Context context, int i, String str, int i2, int i3) {
        VIPBuyFragment.a(context, i, str, -1, VipProtos.FromType.UNKNOWN_FROM, true, true, i2 == 1, i3);
        return true;
    }

    public static boolean openVIPChatBgSetting(Context context) {
        ChatBgSettingFragment.a(context, 2);
        return true;
    }

    public static boolean openVIPCustomSetting(Context context, int i, int i2) {
        if (i == 0) {
            DynamicSkinFragment.a(context, i2, "");
            return true;
        } else if (i == 1) {
            VipBubbleFragment.a(context, i2, "");
            return true;
        } else if (i != 2) {
            return true;
        } else {
            WidgetListFragment.a(context, i2, "", VipProtos.FromType.UNKNOWN_FROM);
            return true;
        }
    }

    public static boolean openVIPCustomizedPage(Context context, int i) {
        VIPCustomizedFragment.a(context, i);
        return true;
    }

    public static boolean openVRVideo(Context context) {
        Activity applicationContext;
        if (!(context instanceof Application)) {
            applicationContext = context.getApplicationContext();
        } else if (BluedApplicationLike.getForeActivity() == null) {
            return true;
        } else {
            applicationContext = BluedApplicationLike.getForeActivity();
        }
        ShortVideoProxy.e().b(applicationContext, 0, 0);
        return true;
    }

    public static boolean openVipLevel(Context context) {
        VIPLvlPrivilegeFragment.b.a(context);
        return true;
    }

    public static boolean openVisitRecord(Context context, final int i) {
        TerminalActivity.d(context, VisitHistoryFragment.class, null);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.similarity_operation_provider.BluedURIRouterAdapter.7
            @Override // java.lang.Runnable
            public void run() {
                VisitRecordSelectedTabObserver.a().a(i);
            }
        }, 500L);
        return true;
    }

    public static boolean openWeChatApplet(Context context, String str, String str2) {
        WeChatUtils.a(context, str, str2);
        return true;
    }

    public static boolean openWebView(Context context, String str, int i) {
        WebViewShowInfoFragment.show(context, str, i);
        return true;
    }

    public static boolean openYYApplyPage(Context context) {
        YYApplyFragment.a(context);
        return true;
    }

    public static boolean openYYChatRoom(final Context context, final String str, final String str2, final String str3, final String str4) {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.similarity_operation_provider.BluedURIRouterAdapter.13
            @Override // java.lang.Runnable
            public void run() {
                Activity activity = context;
                if (BDActivityManager.a.a() != null) {
                    activity = BDActivityManager.a.a();
                }
                if (LiveRoomManager.a().l()) {
                    AppMethods.a((CharSequence) activity.getString(R.string.yy_living_toast));
                } else if (activity instanceof BaseFragmentActivity) {
                    if (!TextUtils.isEmpty(str4)) {
                        YYRoomInfoManager.e().a(new YYJoinRoomJumpInfoMode(0, str4));
                    }
                    YYRoomInfoManager.e().a((BaseFragmentActivity) activity, str, str2, false, str3);
                }
            }
        }, 200L);
        return true;
    }

    public static boolean openYYChatRoomList(Context context, String str, String str2, String str3) {
        String str4 = str;
        if (TextUtils.isEmpty(str)) {
            str4 = "web_chat_room";
        }
        YYChatRoomsListFragment.a.a(context, str4, str2, str3);
        return true;
    }

    public static boolean openYYFullServiceSquare(Context context) {
        YYFullServiceSquareFragment.a.a(context);
        return true;
    }

    public static boolean openYYHotTopicList(Context context) {
        YYHotTopicListFragment.a.a(context);
        return true;
    }

    public static boolean openYYImprovePage(Context context) {
        LiveYYImproveFragment.a(context);
        return true;
    }

    public static boolean promotionBeansPay(Context context, int i, String str, String str2, String str3, String str4, int i2, String str5, String str6, String str7, String str8, String str9) {
        GoodsOptionBasic goodsOptionBasic = new GoodsOptionBasic();
        goodsOptionBasic.id = i;
        goodsOptionBasic.feed_id = str3;
        goodsOptionBasic.trade_type = str4;
        goodsOptionBasic.beans = i2;
        goodsOptionBasic.aim = str5;
        goodsOptionBasic.promotion_type = str6;
        goodsOptionBasic.role = str7;
        goodsOptionBasic.age = str8;
        goodsOptionBasic.area = str9;
        PayPreOrderFragment.a(context, goodsOptionBasic, str, str2, 3);
        return true;
    }

    public static boolean removeEmotionPack(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        EmotionManager.d(str);
        return true;
    }

    public static boolean sendBubbleSayHiEmotion(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
        bluedIngSelfFeed.feed_id = EncryptTool.a(str);
        bluedIngSelfFeed.feed_uid = EncryptTool.a(str2);
        bluedIngSelfFeed.user_name = str4;
        bluedIngSelfFeed.feed_content = str6;
        bluedIngSelfFeed.is_bubble_ticktock = 1;
        bluedIngSelfFeed.bubble_state_icon = str5;
        if (!TextUtils.isEmpty(str5)) {
            bluedIngSelfFeed.feed_pics = new String[]{str5};
        }
        LogData logData = new LogData();
        logData.from = FeedMethods.a(0, 0);
        logData.userFrom = FeedMethods.a(0, 0);
        logData.target_uid = bluedIngSelfFeed.feed_uid;
        logData.feed_id = bluedIngSelfFeed.feed_id;
        logData.is_call = "1";
        logData.bubble_exhibition_img = str3;
        CommunityServiceManager.b().b(context, bluedIngSelfFeed, false, 0, logData, FeedMethods.b(0, 0));
        return true;
    }

    public static boolean sendGroupGradeEvent(Context context, String str, int i) {
        UpdateGroupGradeEvent updateGroupGradeEvent = new UpdateGroupGradeEvent();
        updateGroupGradeEvent.a(i);
        updateGroupGradeEvent.a(str);
        LiveEventBus.get("group_update_grade", UpdateGroupGradeEvent.class).post(updateGroupGradeEvent);
        return true;
    }

    public static boolean sendMessage(final Context context, String str, final String str2, final String str3) {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.similarity_operation_provider.BluedURIRouterAdapter.15
            @Override // java.lang.Runnable
            public void run() {
                Activity activity = context;
                if (BDActivityManager.a.a() != null) {
                    activity = BDActivityManager.a.a();
                }
                if (activity instanceof BaseFragmentActivity) {
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str3));
                    intent.putExtra("sms_body", str2);
                    activity.startActivity(intent);
                }
            }
        }, 200L);
        return true;
    }

    public static boolean setFeedCustomRecommend(Context context, boolean z) {
        Log.v("drb", "setFeedCustomRecommend:" + z);
        CommunityPreferences.b(z);
        return true;
    }

    public static boolean showEventReportDialog(Context context, final String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return true;
        }
        String format = String.format(context.getString(com.blued.community.R.string.event_report_confirm_dialog_content_1), str2);
        CommonAlertDialog.a(context, context.getString(2131890560), format + String.format(context.getString(com.blued.community.R.string.event_report_confirm_dialog_content_2), str3), context.getString(com.blued.community.R.string.event_report_confirm_dialog_btn), new DialogInterface.OnClickListener() { // from class: com.blued.android.similarity_operation_provider.BluedURIRouterAdapter.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                LiveEventBus.get("event_report_confirm_dialog").post(String.this);
            }
        }, null, 1);
        return true;
    }

    public static boolean showGroupRecoverPrivilege(Context context) {
        long eF = BluedPreferences.eF();
        if (eF == 0 || eF + 86400000 < System.currentTimeMillis()) {
            GroupHelper.a.a(context);
            return true;
        }
        return true;
    }

    public static boolean showRewardVideo(Context context, String str, String str2, String str3, String str4) {
        Log.v("drb", "激励视频跳转 adms_type:" + str + " -- task_id:" + str3);
        BluedADExtra bluedADExtra = new BluedADExtra();
        bluedADExtra.aid = str3;
        bluedADExtra.third_id = str4;
        bluedADExtra.adms_type = str;
        BaseADVideoFragment.a(context, bluedADExtra, 0);
        return true;
    }

    public static boolean showTaskFloatView(Context context, int i, String str, int i2, int i3, String str2, String str3) {
        String str4 = TAG;
        Logger.c(str4, new Object[]{"showTaskFloatView :jump_url: " + str2});
        if (!TextUtils.isEmpty(str2)) {
            Uri f = BluedURIRouter.a().f(str2);
            if (f != null) {
                BluedURIRouter.a().a(context, f);
            } else {
                WebViewShowInfoFragment.show(context, str2, -1);
            }
        }
        GlobalTaskFloatManager.TaskInfo taskInfo = new GlobalTaskFloatManager.TaskInfo();
        taskInfo.task_id = i;
        taskInfo.task_name = str;
        taskInfo.max = i2;
        if (i == 26) {
            taskInfo.progress = i2;
        } else {
            taskInfo.progress = i3;
        }
        taskInfo.back_url = str3;
        GlobalTaskFloatManager.a().b(taskInfo);
        return true;
    }

    public static boolean startVIPPay(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        return startVIPPay(context, str, str2, str3, str4, str5, str6, 0);
    }

    public static boolean startVIPPay(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i) {
        return startVIPPay(context, str, str2, str3, str4, str5, str6, i, null);
    }

    public static boolean startVIPPay(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i, LiveChargeCouponModel liveChargeCouponModel) {
        String a = EncryptTool.a(str2);
        GoodsOptionBasic goodsOptionBasic = new GoodsOptionBasic();
        goodsOptionBasic.id = Integer.valueOf(str).intValue();
        if (i > 0) {
            goodsOptionBasic.trackMoney = i;
        }
        if (TextUtils.isEmpty(str5)) {
            str5 = "my";
        }
        if (liveChargeCouponModel != null && i > 0) {
            liveChargeCouponModel.realPayMoney = i;
        }
        PayPreOrderFragment.a(context, goodsOptionBasic, str5, a, str3, str4, str6, 0, 0, liveChargeCouponModel, 0, (IRequestHost) null);
        return true;
    }
}
