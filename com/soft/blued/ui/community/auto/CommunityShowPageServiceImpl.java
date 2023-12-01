package com.soft.blued.ui.community.auto;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.blued.ad.ADConstants;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.community.auto.ICommunityShowPageService;
import com.blued.community.manager.CommunityConstants;
import com.blued.community.model.AlbumFlow;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.send.dialog.PayVIPPopupWindow;
import com.blued.community.ui.square.model.AttentionLiveRecommendData;
import com.blued.community.ui.square.model.FeedRecommendUser;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.blued.das.message.MessageProtos;
import com.blued.das.vip.VipProtos;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.feed.fragment.TakePhotoFragment;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.msg.ShareToFragment;
import com.soft.blued.ui.msg.ShowPositionActivity;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.ChatBundleExtra;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg_group.fragment.GroupIdentifyFragment;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.photo.manager.AlbumViewDataManager;
import com.soft.blued.ui.user.fragment.ChooseFollowedFragment;
import com.soft.blued.ui.user.fragment.DynamicSkinFragment;
import com.soft.blued.ui.user.fragment.ReportFragmentNew;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.model.AlbumForDataTrans;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.ui.welcome.BaseADVideoFragment;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/community/auto/CommunityShowPageServiceImpl.class */
public class CommunityShowPageServiceImpl implements ICommunityShowPageService {

    /* renamed from: com.soft.blued.ui.community.auto.CommunityShowPageServiceImpl$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/community/auto/CommunityShowPageServiceImpl$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16101a;
        static final /* synthetic */ int[] b;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0055 -> B:32:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0059 -> B:28:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x005d -> B:38:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0061 -> B:10:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0065 -> B:30:0x0049). Please submit an issue!!! */
        static {
            int[] iArr = new int[CommunityConstants.ReportType.values().length];
            b = iArr;
            try {
                iArr[CommunityConstants.ReportType.a.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[CommunityConstants.ReportType.b.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[CommunityConstants.ReportType.c.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[CommunityConstants.ReportType.d.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            int[] iArr2 = new int[CommunityConstants.WebShowType.values().length];
            f16101a = iArr2;
            try {
                iArr2[CommunityConstants.WebShowType.b.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f16101a[CommunityConstants.WebShowType.c.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public String a() {
        return "MAIN";
    }

    public void a(Activity activity, Bundle bundle, int i) {
        if (activity != null) {
            TerminalActivity.a(activity, ChooseFollowedFragment.class, bundle, i);
            ActivityChangeAnimationUtils.a(activity);
        }
    }

    public void a(Context context, int i) {
        BluedURIRouterAdapter.openDiscoveryPage(context, i, 0);
    }

    public void a(Context context, int i, int i2, LoadOptions loadOptions) {
        BasePhotoFragment.a(context, i, i2, loadOptions);
    }

    public void a(Context context, int i, ADConstants.AD_POSITION ad_position, int i2, VipProtos.FromType fromType) {
        PayUtils.a(context, i, EventTrackVIP.a(ad_position), i2, fromType);
    }

    public void a(Context context, int i, String str) {
        DynamicSkinFragment.a(context, i, str);
    }

    public void a(Context context, int i, String str, int i2, VipProtos.FromType fromType) {
        PayUtils.a(context, i, str, i2, fromType);
    }

    public void a(Context context, Bundle bundle) {
        GroupIdentifyFragment.f18981a.a(context, bundle);
    }

    public void a(Context context, BluedADExtra bluedADExtra, int i, PayVIPPopupWindow.OnVideoSuccessListener onVideoSuccessListener) {
        BaseADVideoFragment.a(context, bluedADExtra, i, onVideoSuccessListener);
    }

    public void a(Context context, UserBasicModel userBasicModel, long j) {
        UserRelationshipUtils.a(context, userBasicModel, j, "flash_detail_live");
    }

    public void a(Context context, UserBasicModel userBasicModel, long j, String str) {
        UserRelationshipUtils.a(context, userBasicModel, j, str);
    }

    public void a(Context context, UserBasicModel userBasicModel, LogData logData, boolean z, int i, MessageProtos.StrangerSource strangerSource) {
        if (userBasicModel == null) {
            return;
        }
        ChatHelperV4.a().a(context, CommonStringUtils.c(userBasicModel.uid), userBasicModel.name, userBasicModel.avatar, userBasicModel.vbadge, userBasicModel.vip_grade, userBasicModel.is_vip_annual, userBasicModel.vip_exp_lvl, userBasicModel.distance, z, i, userBasicModel.is_hide_vip_look, logData, new MsgSourceEntity(strangerSource, ""));
    }

    public void a(Context context, UserBasicModel userBasicModel, BluedIngSelfFeed bluedIngSelfFeed, String str, View view) {
        UserInfoFragmentNew.a(context, userBasicModel, bluedIngSelfFeed, str, view);
    }

    public void a(Context context, UserBasicModel userBasicModel, BluedIngSelfFeed bluedIngSelfFeed, String str, boolean z, View view, LogData logData, MessageProtos.StrangerSource strangerSource) {
        if (strangerSource == null) {
            strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
        }
        UserInfoFragmentNew.a(context, userBasicModel, bluedIngSelfFeed, str, z, view, logData, new MsgSourceEntity(strangerSource, logData != null ? EncryptTool.b(logData.feed_id) : ""));
    }

    public void a(Context context, UserBasicModel userBasicModel, String str, View view) {
        UserInfoFragmentNew.a(context, userBasicModel, str, view);
    }

    public void a(Context context, UserBasicModel userBasicModel, String str, boolean z, View view, LogData logData, MessageProtos.StrangerSource strangerSource) {
        if (strangerSource == null) {
            strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
        }
        UserInfoFragmentNew.a(context, userBasicModel, str, z, view, logData, new MsgSourceEntity(strangerSource, logData != null ? EncryptTool.b(logData.feed_id) : ""));
    }

    public void a(Context context, CommunityConstants.ReportType reportType, String str, String str2, String str3) {
        int i = AnonymousClass1.b[reportType.ordinal()];
        if (i == 1) {
            ReportFragmentNew.a(context, 2, str2, str);
        } else if (i == 2) {
            ReportFragmentNew.a(context, 9, str2, str);
        } else if (i == 3) {
            ReportFragmentNew.a(context, str3, str2, str);
        } else if (i != 4) {
        } else {
            ReportFragmentNew.b(context, str3, str2, str);
        }
    }

    public void a(Context context, BluedIngSelfFeed bluedIngSelfFeed, int i, int i2, LoadOptions loadOptions, String str, int i3) {
        BasePhotoFragment.a(context, bluedIngSelfFeed, i, i2, loadOptions, str, i3);
    }

    public void a(Context context, BluedIngSelfFeed bluedIngSelfFeed, String str, String str2) {
        UserInfoFragmentNew.a(context, str, bluedIngSelfFeed, str2);
    }

    public void a(Context context, BluedIngSelfFeed bluedIngSelfFeed, boolean z, int i, LogData logData, MessageProtos.StrangerSource strangerSource) {
        ChatHelperV4.a().a(context, Long.parseLong(bluedIngSelfFeed.feed_uid), bluedIngSelfFeed.user_name, bluedIngSelfFeed.user_avatar, bluedIngSelfFeed.vbadge, bluedIngSelfFeed.vip_grade, bluedIngSelfFeed.is_vip_annual, bluedIngSelfFeed.vip_exp_lvl, bluedIngSelfFeed.getFeedParse(context, 0).getDistance(), z, i, bluedIngSelfFeed.is_hide_vip_look, logData, new MsgSourceEntity(strangerSource, ""));
    }

    public void a(Context context, AttentionLiveRecommendData attentionLiveRecommendData, List<AttentionLiveRecommendData> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            arrayList.add(new LiveRoomData(Long.parseLong(EncryptTool.a(list.get(i2).lid)), list.get(i2).live_type == 1 ? 1 : 0, "follow_top_live", EncryptTool.a(list.get(i2).uid), list.get(i2).title, list.get(i2).pic_url, 0));
            i = i2 + 1;
        }
        LiveRoomInfoChannel.a(context, new LiveRoomData(Long.parseLong(attentionLiveRecommendData.lid), attentionLiveRecommendData.live_type == 1 ? 1 : 0, "follow_top_live", attentionLiveRecommendData.uid, attentionLiveRecommendData.title, attentionLiveRecommendData.pic_url, 0), -1, arrayList);
    }

    public void a(Context context, FeedRecommendUser feedRecommendUser, List<FeedRecommendUser> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            String a2 = EncryptTool.a(list.get(i2).uid);
            String a3 = EncryptTool.a(list.get(i2).lid);
            long j = 0;
            if (!TextUtils.isEmpty(a3)) {
                j = Long.parseLong(a3);
            }
            arrayList.add(new LiveRoomData(j, list.get(i2).liveType == 1 ? 1 : 0, feedRecommendUser.source, a2, list.get(i2).name, list.get(i2).avatar, list.get(i2).vbadge));
            i = i2 + 1;
        }
        LiveRoomInfoChannel.a(context, new LiveRoomData(Long.parseLong(EncryptTool.a(feedRecommendUser.lid)), feedRecommendUser.liveType == 1 ? 1 : 0, feedRecommendUser.source, EncryptTool.a(feedRecommendUser.uid), feedRecommendUser.name, feedRecommendUser.avatar, feedRecommendUser.vbadge), -1, arrayList);
    }

    public void a(Context context, String str) {
        WebViewShowInfoFragment.show(context, str);
    }

    public void a(Context context, String str, GroupInfoModel groupInfoModel, LogData logData, SocialNetWorkProtos.SourceType sourceType) {
        ChatHelperV4.a().a(context, Long.valueOf(str).longValue(), (groupInfoModel == null || groupInfoModel.event == null) ? "" : groupInfoModel.event.name, "", 0, 0, 0, 0, "", false, 1, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
    }

    public void a(Context context, String str, CommunityConstants.WebShowType webShowType) {
        int i = AnonymousClass1.f16101a[webShowType.ordinal()];
        WebViewShowInfoFragment.show(context, str, i != 1 ? i != 2 ? -1 : 9 : 0);
    }

    public void a(Context context, String str, String str2) {
        UserInfoFragmentNew.a(context, str, str2);
    }

    public void a(Context context, String str, String str2, int i, String str3, int i2, int i3) {
        ReportFragmentNew.a(context, str2, str, i, str3, i2, i3);
    }

    public void a(Context context, String str, String str2, MessageProtos.StrangerSource strangerSource) {
        UserInfoFragmentNew.a(context, str, "", new MsgSourceEntity(strangerSource));
    }

    public void a(Context context, String str, String str2, String str3) {
        ShowPositionActivity.a(context, str, str2, str3, 1);
    }

    public void a(Context context, String str, String str2, String str3, int i) {
        ShowPositionActivity.a(context, str, str2, str3, i);
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, int i3, long j) {
        BasePhotoFragment.a(context, str, str2, str3, i, i2, i3, j);
    }

    public void a(Context context, String str, String str2, String str3, int i, long j) {
        BasePhotoFragment.a(context, str, str2, str3, i, j);
    }

    public void a(Context context, List<AlbumFlow> list, int i, int i2, int i3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        AlbumForDataTrans albumForDataTrans = new AlbumForDataTrans();
        String str = null;
        if (list.size() > 0) {
            str = list.get(0).feed_uid;
        }
        albumForDataTrans.data.addAll(list);
        AlbumViewDataManager.a().a(false);
        BasePhotoFragment.a(context, albumForDataTrans, i, i2, "", str, i3);
    }

    public void a(Context context, String[] strArr, int i, int i2, LoadOptions loadOptions) {
        BasePhotoFragment.a(context, strArr, i, i2, loadOptions);
    }

    public void a(Context context, String[] strArr, int i, int i2, LoadOptions loadOptions, String str, View view, String str2) {
        BasePhotoFragment.a(context, strArr, i, i2, loadOptions, str, view, str2);
    }

    public void a(Fragment fragment, Bundle bundle, int i) {
        if (fragment != null) {
            TerminalActivity.a(fragment, ChooseFollowedFragment.class, bundle, i);
            ActivityChangeAnimationUtils.a(fragment.getActivity());
        }
    }

    public void a(BaseFragment baseFragment, int i, int i2) {
        PhotoSelectFragment.a(baseFragment, i, i2);
    }

    public void a(BaseFragment baseFragment, BluedIngSelfFeed bluedIngSelfFeed, int i, int i2, LoadOptions loadOptions, String str, int i3, int i4) {
        BasePhotoFragment.a(baseFragment, bluedIngSelfFeed, i, i2, loadOptions, str, i3, i4);
    }

    public void b(Context context, BluedIngSelfFeed bluedIngSelfFeed, boolean z, int i, LogData logData, MessageProtos.StrangerSource strangerSource) {
        MsgSourceEntity msgSourceEntity = new MsgSourceEntity(strangerSource, "");
        ChatBundleExtra chatBundleExtra = new ChatBundleExtra();
        if (bluedIngSelfFeed != null) {
            chatBundleExtra.feed = bluedIngSelfFeed;
        }
        ChatHelperV4.a().a(context, CommonStringUtils.c(bluedIngSelfFeed.feed_uid), bluedIngSelfFeed.user_name, bluedIngSelfFeed.user_avatar, bluedIngSelfFeed.vbadge, bluedIngSelfFeed.vip_grade, bluedIngSelfFeed.is_vip_annual, bluedIngSelfFeed.vip_exp_lvl, bluedIngSelfFeed.getFeedParse(context, 0).getDistance(), z, i, bluedIngSelfFeed.is_hide_vip_look, logData, msgSourceEntity, chatBundleExtra);
    }

    public void b(Context context, String str) {
        ShareToFragment.a(context, str);
    }

    public void b(Context context, String str, String str2) {
        UserInfoFragmentNew.d(context, str, str2);
    }

    public void b(BaseFragment baseFragment, int i, int i2) {
        TakePhotoFragment.a(baseFragment, i, i2, "");
    }

    public void c(Context context, String str) {
        YYChatRoomsListFragment.a.a(context, str);
    }

    public void c(Context context, String str, String str2) {
        YYRoomInfoManager.e().a((BaseFragmentActivity) context, str, str2);
    }

    public void d(Context context, String str) {
        BluedURIRouterAdapter.openFlutterFeedExposureWithId(context, str, "my_feed_more_option");
    }
}
