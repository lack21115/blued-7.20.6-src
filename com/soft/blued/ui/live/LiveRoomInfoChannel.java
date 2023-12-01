package com.soft.blued.ui.live;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.anythink.expressad.video.module.a.a.m;
import com.app.share.ShareUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.FileUtils;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.model.DecryptJson;
import com.blued.android.module.common.model.LiveChargeCouponModel;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.android.module.common.utils.NetworkUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.blued.android.module.live.base.model.PayOption;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.constant.LiveRoomConstants;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveDataListManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.LiveChatBadgeModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveFansRelationForShareModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.model.LiveTwoFloorModel;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.media.selector.utils.Tools;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.das.message.MessageProtos;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.manager.SendNotificationManager;
import com.soft.blued.ui.feed.fragment.LiveClipPhotoFragment;
import com.soft.blued.ui.find.model.FindRecommendData;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.live.fragment.LiveApplyImproveFragment;
import com.soft.blued.ui.live.fragment.LiveFragment;
import com.soft.blued.ui.live.fragment.LiveTwoLevelFragment;
import com.soft.blued.ui.live.fragment.ShareWithContactFragment;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.controller.tools.MsgCommonUtils;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.pay.BeansPrePayDialogFragment;
import com.soft.blued.ui.pay.BeansPrePayFragment;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.share_custom.Model.BaseShareEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.ShareCoreUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/live/LiveRoomInfoChannel.class */
public class LiveRoomInfoChannel {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.live.LiveRoomInfoChannel$4  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/live/LiveRoomInfoChannel$4.class */
    public class AnonymousClass4 implements PermissionCallbacks {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f31056a;
        final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f31057c;

        AnonymousClass4(String str, String str2, String str3) {
            this.f31056a = str;
            this.b = str2;
            this.f31057c = str3;
        }

        @Override // com.blued.android.framework.permission.PermissionCallbacks
        public void U_() {
            ThreadManager.a().a(new ThreadExecutor("CopyVideoToPicDir") { // from class: com.soft.blued.ui.live.LiveRoomInfoChannel.4.1
                @Override // com.blued.android.framework.pool.ThreadExecutor
                public void execute() {
                    FileUtils.a(AnonymousClass4.this.f31056a, AnonymousClass4.this.b, AnonymousClass4.this.f31057c);
                    AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.live.LiveRoomInfoChannel.4.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Tools.a(AppInfo.d(), AnonymousClass4.this.b, true);
                        }
                    });
                }
            });
        }

        @Override // com.blued.android.framework.permission.PermissionCallbacks
        public void a(String[] strArr) {
        }
    }

    public static List<LiveRoomData> a(List<BluedLiveListData> list, String str) {
        String str2;
        String str3;
        int i;
        String str4;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (BluedLiveListData bluedLiveListData : list) {
                String str5 = bluedLiveListData.uid;
                UserBasicModel userBasicModel = bluedLiveListData.anchor;
                if (userBasicModel != null) {
                    String str6 = str5;
                    if (TextUtils.isEmpty(str5)) {
                        str6 = userBasicModel.uid;
                    }
                    str2 = userBasicModel.name;
                    String str7 = userBasicModel.avatar;
                    i = userBasicModel.vbadge;
                    str4 = str6;
                    str3 = str7;
                } else {
                    str2 = "";
                    str3 = str2;
                    i = 0;
                    str4 = str5;
                }
                LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(bluedLiveListData.lid, 0L), bluedLiveListData.screen_pattern, str, str4, str2, str3, i);
                if (!TextUtils.isEmpty(bluedLiveListData.live_play)) {
                    liveRoomData.live_url = bluedLiveListData.live_play;
                }
                arrayList.add(liveRoomData);
            }
        }
        return arrayList;
    }

    public static void a() {
        if (LiveRoomInfo.b()) {
            return;
        }
        LiveRoomInfo.a().a(c());
    }

    public static void a(Context context, LiveRoomData liveRoomData) {
        LiveDataListManager.a().a(liveRoomData);
        a(context, liveRoomData, -1, LiveDataListManager.a().b());
    }

    public static void a(Context context, LiveRoomData liveRoomData, int i, List<LiveRoomData> list) {
        a(context, liveRoomData, i, list, null);
    }

    public static void a(Context context, LiveRoomData liveRoomData, int i, List<LiveRoomData> list, Bundle bundle) {
        if (AudioChannelManager.j().n()) {
            AppMethods.a(context.getResources().getText(2131893031));
            return;
        }
        a();
        PlayingOnliveFragment.a(context, liveRoomData, i, list, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static UserRelationshipUtils.IAddOrRemoveAttentionDone b(final LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone) {
        return new UserRelationshipUtils.IAddOrRemoveAttentionDone() { // from class: com.soft.blued.ui.live.LiveRoomInfoChannel.3
            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void a() {
                LiveUserRelationshipUtils.IAddOrRemoveAttentionDone.this.Q_();
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void a(String str) {
                LiveUserRelationshipUtils.IAddOrRemoveAttentionDone.this.a(str);
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void b() {
                LiveUserRelationshipUtils.IAddOrRemoveAttentionDone.this.c();
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void b(String str) {
                LiveUserRelationshipUtils.IAddOrRemoveAttentionDone.this.b(str);
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void c() {
                LiveUserRelationshipUtils.IAddOrRemoveAttentionDone.this.d();
            }
        };
    }

    public static List<LiveRoomData> b(List<FindRecommendData> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (FindRecommendData findRecommendData : list) {
                int i = findRecommendData.uid;
                arrayList.add(new LiveRoomData(StringUtils.a(findRecommendData.live, 0L), 0, str, String.valueOf(i), findRecommendData.title, "", 0));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.widget.EditText r5, java.lang.String r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.live.LiveRoomInfoChannel.b(android.widget.EditText, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, String str2, String str3) {
        Log.i("xpm", "saveScreenVideo:" + str);
        PermissionUtils.f(new AnonymousClass4(str, str2, str3));
    }

    private static ILiveRoomInfoCallBack c() {
        return new ILiveRoomInfoCallBack() { // from class: com.soft.blued.ui.live.LiveRoomInfoChannel.1
            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String A() {
                return H5Url.a(54);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String B() {
                return H5Url.a(56);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String C() {
                return H5Url.a(64);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String D() {
                return H5Url.a(75);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public Activity E() {
                return SendNotificationManager.a().b();
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void F() {
                LiveUtils.a("", "", 0);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public CharSequence a(CharSequence charSequence, String str, final LiveRoomConstants.ClickAtLinkListener clickAtLinkListener) {
                return StringUtils.a(charSequence, true, false, false, new TypefaceUtils.ClickAtLinkListener() { // from class: com.soft.blued.ui.live.LiveRoomInfoChannel.1.2
                    @Override // com.soft.blued.utils.TypefaceUtils.ClickAtLinkListener
                    public void a(String str2, String str3) {
                        clickAtLinkListener.a(str2, str3);
                    }
                }, true, str, "");
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String a() {
                return UserInfo.getInstance().getLoginUserInfo().getName();
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String a(Context context, TextView textView, String str) {
                return UserInfoHelper.a(context, textView, str);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String a(String str) {
                return AreaUtils.getAreaTxt(str, BlueAppLocal.c());
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String a(String str, boolean z) {
                return StringUtils.a(str, BlueAppLocal.c(), z);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(double d) {
                UserInfo.getInstance().setUserPrice(d);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(int i) {
                UserInfo.getInstance().getLoginUserInfo().setRich_level(i);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Activity activity) {
                ActivityChangeAnimationUtils.k(activity);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Context context) {
                HomeArgumentHelper.a(context, "live", (Bundle) null);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Context context, int i) {
                BeansPrePayFragment.a(context, i);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Context context, TextView textView, int i, int i2) {
                TypefaceUtils.b(context, textView, i, i2);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Context context, TextView textView, LiveRoomUserModel liveRoomUserModel, int i) {
                UserBasicModel userBasicModel = new UserBasicModel();
                userBasicModel.vip_grade = liveRoomUserModel.vip_grade;
                userBasicModel.is_hide_vip_look = liveRoomUserModel.is_hide_vip_look;
                userBasicModel.is_vip_annual = liveRoomUserModel.is_vip_annual;
                UserInfoHelper.a(context, textView, userBasicModel, i);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Context context, FragmentManager fragmentManager, int i, int i2, String str) {
                new BeansPrePayDialogFragment(context, i, i2, str).show(fragmentManager, "BeansPrePayDialog");
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Context context, FragmentManager fragmentManager, int i, LiveChargeCouponModel liveChargeCouponModel) {
                new BeansPrePayDialogFragment(context, i, liveChargeCouponModel).show(fragmentManager, "BeansPrePayDialog");
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Context context, PayOption._pay_list _pay_listVar, String str) {
                if (_pay_listVar == null) {
                    return;
                }
                BluedURIRouterAdapter.startVIPPay(context, String.valueOf(_pay_listVar.id), "", "", "", str, str, (int) _pay_listVar.money);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Context context, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, String str, String str2, IRequestHost iRequestHost) {
                UserHttpUtils.b(context, LiveRoomInfoChannel.b(iAddOrRemoveAttentionDone), str, str2, iRequestHost);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Context context, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, String str, String str2, String str3, IRequestHost iRequestHost, boolean z) {
                UserRelationshipUtils.a(context, LiveRoomInfoChannel.b(iAddOrRemoveAttentionDone), str, str2, str3, iRequestHost, z);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Context context, LiveRoomData liveRoomData) {
                LiveRoomInfoChannel.a(context, liveRoomData);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Context context, LiveRoomData liveRoomData, int i, List<LiveRoomData> list, Bundle bundle) {
                LiveRoomInfoChannel.a(context, liveRoomData, i, list, bundle);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Context context, LiveRoomData liveRoomData, String str, String str2, String str3, String str4, Bitmap bitmap) {
                BaseShareEntity.ShareLiveData shareLiveData = new BaseShareEntity.ShareLiveData();
                shareLiveData.f33710a = UserInfo.getInstance().getLoginUserInfo().getName();
                shareLiveData.j = str2;
                shareLiveData.f33711c = str3;
                shareLiveData.d = UserInfo.getInstance().getLoginUserInfo().getAvatar();
                shareLiveData.e = bitmap;
                shareLiveData.f = UserInfo.getInstance().getLoginUserInfo().getUid();
                shareLiveData.g = str;
                shareLiveData.b = str4;
                ShareUtils.a().a(context, shareLiveData);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Context context, LiveTwoFloorModel liveTwoFloorModel) {
                LiveTwoLevelFragment.a(context, "two_floor_live", liveTwoFloorModel);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Context context, String str) {
                WebViewShowInfoFragment.show(context, str, -1);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Context context, String str, TextView textView, ImageView imageView, boolean z) {
                UserRelationshipUtils.a(context, str, textView, imageView, z);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Context context, String str, String str2, long j, IRequestHost iRequestHost) {
                MsgCommonUtils.a(context, str, str2, j, iRequestHost);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Context context, String str, String str2, String str3, int i, int i2) {
                LiveRoomData liveRoomData;
                UserBasicModel userBasicModel = new UserBasicModel();
                userBasicModel.uid = str;
                userBasicModel.name = str2;
                userBasicModel.avatar = str3;
                userBasicModel.is_show_vip_page = i;
                if (LiveRoomManager.a().G()) {
                    liveRoomData = null;
                } else {
                    liveRoomData = (LiveRoomData) AppInfo.f().fromJson(AppInfo.f().toJson(LiveRoomManager.a().p()), (Class<Object>) LiveRoomData.class);
                }
                if (i2 == 1) {
                    UserInfoFragmentNew.a(context, userBasicModel, liveRoomData, "", false, new MsgSourceEntity(MessageProtos.StrangerSource.LIVE, ""));
                } else if (i2 == 2) {
                    UserInfoFragmentNew.a(context, userBasicModel, liveRoomData, "", false, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
                }
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Context context, final boolean z, LiveRoomData liveRoomData, Bitmap bitmap, String str) {
                BaseShareEntity.ShareLiveData shareLiveData = new BaseShareEntity.ShareLiveData();
                shareLiveData.i = z;
                shareLiveData.f33710a = "";
                shareLiveData.d = "";
                shareLiveData.f = "";
                if (!LiveRoomManager.a().t()) {
                    shareLiveData.f33710a = LiveRoomManager.a().p().profile.name;
                    shareLiveData.d = LiveRoomManager.a().p().profile.avatar;
                    shareLiveData.f = LiveRoomManager.a().p().profile.uid;
                }
                shareLiveData.f33711c = "";
                shareLiveData.e = bitmap;
                if (liveRoomData != null) {
                    shareLiveData.h = liveRoomData.lid + "";
                }
                shareLiveData.b = str;
                shareLiveData.l = new ShareOptionRecyclerAdapter.ShareOptionsItemClickListener() { // from class: com.soft.blued.ui.live.LiveRoomInfoChannel.1.3
                    @Override // com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter.ShareOptionsItemClickListener
                    public void onItemClick(int i) {
                        LiveRoomInfoChannel.d();
                        boolean z2 = true;
                        switch (i) {
                            case 2131887268:
                            case 2131891709:
                                z2 = false;
                                break;
                            case 2131892070:
                            case 2131892078:
                            case 2131892085:
                            case 2131892088:
                                break;
                            default:
                                z2 = true;
                                break;
                        }
                        if (z && z2) {
                            LiveFloatManager.a().I();
                            LiveRefreshUIObserver.a().b(false);
                        }
                    }
                };
                shareLiveData.k = new ShareCoreUtils.ShareBackLister() { // from class: com.soft.blued.ui.live.LiveRoomInfoChannel.1.4
                    @Override // com.soft.blued.utils.ShareCoreUtils.ShareBackLister
                    public void a(String str2) {
                        if (LiveFloatManager.a().C()) {
                            AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.live.LiveRoomInfoChannel.1.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    LiveSetDataObserver.a().n();
                                }
                            }, m.ag);
                        } else {
                            LiveSetDataObserver.a().n();
                        }
                    }

                    @Override // com.soft.blued.utils.ShareCoreUtils.ShareBackLister
                    public void b(String str2) {
                    }

                    @Override // com.soft.blued.utils.ShareCoreUtils.ShareBackLister
                    public void c(String str2) {
                    }

                    @Override // com.soft.blued.utils.ShareCoreUtils.ShareBackLister
                    public void d(String str2) {
                        if (z) {
                            LiveFloatManager.a().s();
                        }
                    }
                };
                ShareUtils.a().a(context, shareLiveData);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Bitmap bitmap, long j, Context context, KeyboardListenLinearLayout keyboardListenLinearLayout) {
                ShareUtils.a().a(bitmap, j, context, keyboardListenLinearLayout);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(EditText editText, String str, String str2) {
                LiveRoomInfoChannel.b(editText, str, str2);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(ImageView imageView, int i) {
                UserInfoHelper.a(imageView, i, 1);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(ImageView imageView, LiveRoomUserModel liveRoomUserModel) {
                UserBasicModel userBasicModel = new UserBasicModel();
                userBasicModel.vip_grade = liveRoomUserModel.vip_grade;
                userBasicModel.is_hide_vip_look = liveRoomUserModel.is_hide_vip_look;
                userBasicModel.is_vip_annual = liveRoomUserModel.is_vip_annual;
                userBasicModel.vip_exp_lvl = liveRoomUserModel.vip_exp_lvl;
                UserRelationshipUtils.a(imageView, userBasicModel);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Fragment fragment) {
                if (fragment instanceof LiveFragment) {
                    ((LiveFragment) fragment).a(fragment);
                }
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Fragment fragment, float f, int i) {
                if (fragment instanceof LiveFragment) {
                    ((LiveFragment) fragment).a(f, i);
                }
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Fragment fragment, int i) {
                ViewPager b;
                if (!(fragment instanceof LiveFragment) || (b = ((LiveFragment) fragment).b()) == null) {
                    return;
                }
                b.setCurrentItem(i);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Fragment fragment, boolean z) {
                if (fragment instanceof LiveFragment) {
                    ((LiveFragment) fragment).b(true);
                }
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(Fragment fragment, boolean z, String str, int i) {
                if (fragment instanceof LiveFragment) {
                    ((LiveFragment) fragment).a(z, str, i);
                }
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(BaseFragment baseFragment, String str, String str2, int i) {
                LiveClipPhotoFragment liveClipPhotoFragment = new LiveClipPhotoFragment();
                Bundle bundle = new Bundle();
                bundle.putString("photo_path", str2);
                bundle.putInt("select_photo", i);
                bundle.putString("select_http_url", str);
                liveClipPhotoFragment.setArguments(bundle);
                liveClipPhotoFragment.show(baseFragment.getFragmentManager(), "liveMakeLoverOkDialog");
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(PermissionCallbacks permissionCallbacks) {
                PermissionUtils.g(permissionCallbacks);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(RecordingOnliveFragment recordingOnliveFragment, int i, int i2, String str, String[] strArr) {
                ShareWithContactFragment.a(recordingOnliveFragment, i, 8, str, strArr);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(LiveChatBadgeModel liveChatBadgeModel) {
                UserInfo.getInstance().getLoginUserInfo().chat_badge_url = liveChatBadgeModel == null ? "" : liveChatBadgeModel.getChat_badge_url();
                UserInfo.getInstance().getLoginUserInfo().chat_badge_length = liveChatBadgeModel == null ? 0 : liveChatBadgeModel.getChat_badge_length().intValue();
                UserInfo.getInstance().getLoginUserInfo().chat_badge_height = liveChatBadgeModel == null ? 0 : liveChatBadgeModel.getChat_badge_height().intValue();
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(LiveChattingModel liveChattingModel, boolean z) {
                ChatHelperV4.a().a(liveChattingModel, z);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(String str, int i) {
                UserInfo.getInstance().getLoginUserInfo().avatar_frame = str;
                UserInfo.getInstance().getLoginUserInfo().avatar_frame_type = i;
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(String str, String str2, String str3) {
                LiveRoomInfoChannel.b(str, str2, str3);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(String str, boolean z, IRequestHost iRequestHost) {
                PayHttpUtils.a(str, Boolean.valueOf(z), 1, new BluedUIHttpResponse<BluedEntityA<PayRemaining>>(iRequestHost) { // from class: com.soft.blued.ui.live.LiveRoomInfoChannel.1.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<PayRemaining> bluedEntityA) {
                        if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                            AppMethods.d(2131888227);
                        } else if (!BluedHttpUtils.a(bluedEntityA.code, bluedEntityA.message)) {
                            AppMethods.d(2131888227);
                        } else {
                            try {
                                LiveRoomPreferences.c(((DecryptJson) AppInfo.f().fromJson(AesCrypto.c(bluedEntityA.data.get(0).encrypted), (Class<Object>) DecryptJson.class)).token);
                            } catch (Exception e) {
                            }
                        }
                    }
                }, iRequestHost);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void a(String[] strArr) {
                FindHttpUtils.b(strArr);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public boolean a(Context context, View.OnClickListener onClickListener) {
                return PopMenuUtils.a(context, onClickListener);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String b() {
                return UserInfo.getInstance().getLoginUserInfo().avatar;
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String b(String str, boolean z) {
                return StringUtils.b(str, BlueAppLocal.c(), z);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void b(Context context, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, String str, String str2, IRequestHost iRequestHost) {
                UserHttpUtils.a(context, LiveRoomInfoChannel.b(iAddOrRemoveAttentionDone), str, str2, iRequestHost);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void b(Context context, String str) {
                WebViewShowInfoFragment.show(context, str, 14);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public boolean b(Context context) {
                return BluedApplicationLike.isMainApplication(AppInfo.d());
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public boolean b(String str) {
                return UserInfoHelper.a(str);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String c() {
                return UserInfo.getInstance().getLoginResultFromDB() != null ? UserInfo.getInstance().getLoginResultFromDB().avatar : "";
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void c(Context context) {
                LiveApplyImproveFragment.a(context);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void c(Context context, String str) {
                WebViewShowInfoFragment.show(context, str, 9);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String d() {
                return UserInfo.getInstance().getLoginUserInfo().getUid();
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String d(Context context, String str) {
                return UserInfoHelper.a(context, str);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public boolean e() {
                return BluedPreferences.cK();
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String f() {
                return UserInfo.getInstance().getLoginUserInfo().getAccess_token();
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public int g() {
                return UserInfo.getInstance().getLoginUserInfo().getRich_level();
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public LiveChatBadgeModel h() {
                LiveChatBadgeModel liveChatBadgeModel = new LiveChatBadgeModel();
                liveChatBadgeModel.setChat_badge_url(UserInfo.getInstance().getLoginUserInfo().chat_badge_url);
                liveChatBadgeModel.setChat_badge_length(Integer.valueOf(UserInfo.getInstance().getLoginUserInfo().chat_badge_length));
                liveChatBadgeModel.setChat_badge_height(Integer.valueOf(UserInfo.getInstance().getLoginUserInfo().chat_badge_height));
                return liveChatBadgeModel;
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public boolean i() {
                return LiveCloakingUtil.f14157a;
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public int j() {
                return UserInfo.getInstance().getLoginUserInfo().getVBadge();
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public boolean k() {
                return BluedHttpUrl.h();
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String l() {
                return BluedHttpUrl.q();
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String m() {
                return BluedHttpUrl.A();
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String n() {
                return NetworkUtils.d();
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String o() {
                return DeviceUtils.d();
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String p() {
                return BluedHttpUrl.r();
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public BluedLoginResult q() {
                return UserInfo.getInstance().getLoginUserInfo();
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public boolean r() {
                boolean z = true;
                if (UserInfo.getInstance().getLoginUserInfo().is_invisible_half != 1) {
                    if (UserInfo.getInstance().getLoginUserInfo().is_invisible_all == 1) {
                        return true;
                    }
                    z = false;
                }
                return z;
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public void s() {
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public boolean t() {
                return BluedApplicationLike.isAppOnForeground();
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public boolean u() {
                return BluedConfig.a().t();
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String v() {
                return H5Url.a(11);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String w() {
                return H5Url.a(25, EncryptTool.b(LiveRoomInfo.a().f()));
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String x() {
                return H5Url.a(37);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String y() {
                return H5Url.a(50);
            }

            @Override // com.blued.android.module.live_china.live_info.ILiveRoomInfoCallBack
            public String z() {
                return H5Url.a(50);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() {
        LiveRoomHttpUtils.v(new BluedUIHttpResponse<BluedEntityA<LiveFansRelationForShareModel>>() { // from class: com.soft.blued.ui.live.LiveRoomInfoChannel.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveFansRelationForShareModel> bluedEntityA) {
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                Log.i("xpp", "postLiveFansRelationForShare fail:" + str);
                return true;
            }
        });
    }
}
