package com.soft.blued.ui.find.adapter;

import android.app.Activity;
import android.app.backup.FullBackup;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BlurMaskFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.MaskFilterSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;
import com.anythink.expressad.d.a.b;
import com.anythink.nativead.api.ATNative;
import com.anythink.nativead.api.ATNativeAdView;
import com.anythink.nativead.api.ATNativeEventListener;
import com.anythink.nativead.api.ATNativeNetworkListener;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.api.NativeAd;
import com.anythink.network.gdt.GDTATConst;
import com.anythink.network.toutiao.TTATConst;
import com.blued.ad.ADConstants;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.view.LiveAutoPlayView;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.community.ui.send.dialog.PayVIPPopupWindow;
import com.blued.das.guy.GuyProtos;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huawei.hms.ads.AppDownloadButton;
import com.huawei.hms.ads.nativead.MediaView;
import com.huawei.hms.ads.nativead.NativeView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.kwad.sdk.api.KsNativeAd;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.customview.BannerADView;
import com.soft.blued.customview.BluedADConstraintLayout;
import com.soft.blued.customview.SelfRenderViewUtil;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.bytedance.GuyEventUtils;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.community.view.FeedBubbleStateView;
import com.soft.blued.ui.find.adapter.PeopleListQuickAdapter;
import com.soft.blued.ui.find.manager.MapFindManager;
import com.soft.blued.ui.find.model.UserFindExtra;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.ui.mine.model.MineEntryInfo;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.ADClosePopOptionsUtils;
import com.soft.blued.utils.AdTestManager;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.HWAppDownloadStyle;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/PeopleListQuickAdapter.class */
public class PeopleListQuickAdapter extends PeopleGridQuickAdapter {
    private int A;
    private int B;
    private int C;
    public int v;
    public OnShowRegisterUserGuideDialogListener w;
    private LiveAutoPlayView x;
    private ConcurrentHashMap<String, NativeAd> y;
    private int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.find.adapter.PeopleListQuickAdapter$9  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/PeopleListQuickAdapter$9.class */
    public class AnonymousClass9 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UserFindResult f16417a;
        final /* synthetic */ View b;

        AnonymousClass9(UserFindResult userFindResult, View view) {
            this.f16417a = userFindResult;
            this.b = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(UserFindResult userFindResult) {
            Log.i("ddrb", "onRemoved");
            PeopleListQuickAdapter.this.mData.remove(userFindResult);
            PeopleListQuickAdapter.this.f();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            Log.v("drb", "closeView onClick");
            if (this.f16417a.can_close == 1) {
                Context context = PeopleListQuickAdapter.this.f16394a;
                UserFindResult userFindResult = this.f16417a;
                View view2 = this.b;
                ADConstants.AD_POSITION ad_position = ADConstants.AD_POSITION.NEARBY_HOME_ORIGIN;
                final UserFindResult userFindResult2 = this.f16417a;
                ADClosePopOptionsUtils.a(context, userFindResult, view2, ad_position, new ADClosePopOptionsUtils.ADRemovedListener() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$PeopleListQuickAdapter$9$n8pYSnDV7FB_jaBBBqNrmIE66dE
                    @Override // com.soft.blued.utils.ADClosePopOptionsUtils.ADRemovedListener
                    public final void onRemoved() {
                        PeopleListQuickAdapter.AnonymousClass9.this.a(userFindResult2);
                    }
                });
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/PeopleListQuickAdapter$OnShowRegisterUserGuideDialogListener.class */
    public interface OnShowRegisterUserGuideDialogListener {
        void a();
    }

    public PeopleListQuickAdapter(List<UserFindResult> list, Activity activity, IRequestHost iRequestHost, String str, RecyclerView recyclerView) {
        super(list, activity, iRequestHost, str, recyclerView);
        this.v = 0;
        this.y = new ConcurrentHashMap<>();
        int a2 = AppInfo.l - DensityUtils.a(this.f16394a, 24.0f);
        this.z = a2;
        this.A = (int) (a2 * 0.75f);
        int a3 = AppInfo.l - DensityUtil.a(95.0f);
        this.B = a3;
        this.C = (int) (a3 / 2.3f);
    }

    private void a(NativeAd nativeAd, BaseViewHolder baseViewHolder, final UserFindResult userFindResult) {
        ATNativeAdView aTNativeAdView = (ATNativeAdView) baseViewHolder.getView(2131361988);
        View findViewById = aTNativeAdView.findViewById(R.id.self_render_view);
        nativeAd.setNativeEventListener(new ATNativeEventListener() { // from class: com.soft.blued.ui.find.adapter.PeopleListQuickAdapter.8
            @Override // com.anythink.nativead.api.ATNativeEventListener
            public void onAdClicked(ATNativeAdView aTNativeAdView2, ATAdInfo aTAdInfo) {
                FindHttpUtils.b(userFindResult.click_url);
                Log.i("ddrb", "native ad onAdClicked--------\n" + aTAdInfo.toString());
            }

            @Override // com.anythink.nativead.api.ATNativeEventListener
            public void onAdImpressed(ATNativeAdView aTNativeAdView2, ATAdInfo aTAdInfo) {
                FindHttpUtils.b(userFindResult.show_url);
                Log.i("ddrb", "native ad onAdImpressed--------\n" + aTAdInfo.toString());
            }

            @Override // com.anythink.nativead.api.ATNativeEventListener
            public void onAdVideoEnd(ATNativeAdView aTNativeAdView2) {
                Log.i("ddrb", "native ad onAdVideoEnd--------");
            }

            @Override // com.anythink.nativead.api.ATNativeEventListener
            public void onAdVideoProgress(ATNativeAdView aTNativeAdView2, int i) {
            }

            @Override // com.anythink.nativead.api.ATNativeEventListener
            public void onAdVideoStart(ATNativeAdView aTNativeAdView2) {
                Log.i("ddrb", "native ad onAdVideoStart--------");
            }
        });
        try {
            Log.i("ddrb", "native ad start to render ad------------- ");
            aTNativeAdView.removeAllViews();
            ATNativePrepareInfo aTNativePrepareInfo = null;
            if (nativeAd.isNativeExpress()) {
                Log.i("ddrb", "topon原生模版");
                nativeAd.renderAdContainer(aTNativeAdView, null);
                findViewById.setVisibility(8);
            } else {
                Log.i("ddrb", "topon原生自渲染");
                aTNativePrepareInfo = new ATNativePrepareInfo();
                findViewById.setVisibility(0);
                SelfRenderViewUtil.a(aTNativeAdView.getContext(), nativeAd.getAdMaterial(), findViewById, aTNativePrepareInfo, nativeAd.getAdInfo().getNetworkFirmId());
                nativeAd.renderAdContainer(aTNativeAdView, findViewById);
            }
            View findViewById2 = findViewById.findViewById(R.id.img_close);
            findViewById2.setOnClickListener(new AnonymousClass9(userFindResult, findViewById2));
            nativeAd.prepare(aTNativeAdView, aTNativePrepareInfo);
            nativeAd.onResume();
            nativeAd.setVideoMute(true);
        } catch (Exception e) {
            Log.v("drb", "topon原生 e:" + e.toString());
            e.printStackTrace();
        }
    }

    private void a(UserFindResult userFindResult, int i) {
        if (userFindResult == null || userFindResult.isShowAdVisited) {
            return;
        }
        userFindResult.isShowAdVisited = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final UserFindResult userFindResult, ImageView imageView, View view) {
        Tracker.onClick(view);
        ADClosePopOptionsUtils.a(this.f16394a, userFindResult, imageView, ADConstants.AD_POSITION.NEARBY_HOME_ORIGIN, new ADClosePopOptionsUtils.ADRemovedListener() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$PeopleListQuickAdapter$YPs8iKdMzjU8x4K0HuyKiRmWr7Q
            @Override // com.soft.blued.utils.ADClosePopOptionsUtils.ADRemovedListener
            public final void onRemoved() {
                PeopleListQuickAdapter.this.d(userFindResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final UserFindResult userFindResult, ImageView imageView, View view) {
        Tracker.onClick(view);
        ADClosePopOptionsUtils.a(this.f16394a, userFindResult, imageView, ADConstants.AD_POSITION.NEARBY_HOME_ORIGIN, new ADClosePopOptionsUtils.ADRemovedListener() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$PeopleListQuickAdapter$71ueobqpNaTwNXd00XCFL6zk30I
            @Override // com.soft.blued.utils.ADClosePopOptionsUtils.ADRemovedListener
            public final void onRemoved() {
                PeopleListQuickAdapter.this.e(userFindResult);
            }
        });
    }

    private ShapeModel d(boolean z) {
        ShapeModel shapeModel = new ShapeModel();
        if (z) {
            shapeModel.t = this.f16394a.getResources().getColor(2131101728);
            shapeModel.v = this.f16394a.getResources().getColor(2131101608);
        } else {
            shapeModel.t = this.f16394a.getResources().getColor(2131101446);
            shapeModel.v = this.f16394a.getResources().getColor(2131101533);
        }
        shapeModel.H = DensityUtils.a(this.f16394a, 14.0f);
        shapeModel.b = this.f16394a.getResources().getColor(2131102170);
        return shapeModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(UserFindResult userFindResult) {
        this.mData.remove(userFindResult);
        f();
    }

    private ShapeModel e(boolean z) {
        ShapeModel shapeModel = new ShapeModel();
        if (z) {
            shapeModel.t = this.f16394a.getResources().getColor(2131101697);
            shapeModel.v = this.f16394a.getResources().getColor(2131101570);
        } else {
            shapeModel.t = this.f16394a.getResources().getColor(2131101752);
            shapeModel.v = this.f16394a.getResources().getColor(2131101740);
        }
        shapeModel.H = DensityUtils.a(this.f16394a, 14.0f);
        return shapeModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(UserFindResult userFindResult) {
        this.mData.remove(userFindResult);
        f();
    }

    private void i(BaseViewHolder baseViewHolder, final UserFindResult userFindResult) {
        ImageView imageView = (ImageView) baseViewHolder.getView(2131364232);
        TextView textView = (TextView) baseViewHolder.getView(R.id.name_view);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_style_1_ad_text);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_style_2_ad_text);
        TextView textView4 = (TextView) baseViewHolder.getView(R.id.tv_desc);
        final ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.img_close);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.img_style_1_ad_icon);
        ImageView imageView4 = (ImageView) baseViewHolder.getView(R.id.img_style_2_ad_icon);
        ConstraintLayout constraintLayout = (ConstraintLayout) baseViewHolder.getView(R.id.cl_style_1);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) baseViewHolder.getView(R.id.cl_style_2);
        ViewGroup viewGroup = (ViewGroup) baseViewHolder.getView(R.id.cv_content);
        MediaView mediaView = (MediaView) baseViewHolder.getView(R.id.ad_media);
        TextView textView5 = (TextView) baseViewHolder.getView(R.id.native_ad_install_btn);
        ViewGroup viewGroup2 = (ViewGroup) baseViewHolder.getView(R.id.cl_download_layout);
        BluedADConstraintLayout bluedADConstraintLayout = (BluedADConstraintLayout) baseViewHolder.getView(R.id.fl_main);
        NativeView nativeView = (NativeView) baseViewHolder.getView(R.id.hw_native_view);
        nativeView.setTitleView(textView);
        nativeView.setMediaView(mediaView);
        nativeView.setAdSourceView(textView4);
        nativeView.setCallToActionView(textView5);
        nativeView.setIconView(imageView);
        imageView4.setImageResource(2131233444);
        if (userFindResult.hwNativeAd == null) {
            bluedADConstraintLayout.setVisibility(8);
            return;
        }
        bluedADConstraintLayout.setVisibility(0);
        int creativeType = userFindResult.hwNativeAd.getCreativeType();
        if (creativeType == 103 || creativeType == 106) {
            viewGroup2.setVisibility(0);
        } else {
            viewGroup2.setVisibility(8);
        }
        String uri = (userFindResult.hwNativeAd.getIcon() == null || userFindResult.hwNativeAd.getIcon().getUri() == null) ? "" : userFindResult.hwNativeAd.getIcon().getUri().toString();
        Log.v("drb", "华为原生头像icon url:" + uri);
        ImageLoader.a(this.o, uri).b(2131237310).c().a(imageView);
        ((TextView) nativeView.getTitleView()).setText(userFindResult.hwNativeAd.getAdSource());
        nativeView.getMediaView().setMediaContent(userFindResult.hwNativeAd.getMediaContent());
        if (userFindResult.hwNativeAd.getAdSource() != null) {
            ((TextView) nativeView.getAdSourceView()).setText(userFindResult.hwNativeAd.getTitle());
        }
        nativeView.getAdSourceView().setVisibility(userFindResult.hwNativeAd.getAdSource() != null ? 0 : 4);
        if (userFindResult.hwNativeAd.getCallToAction() != null) {
            ((TextView) nativeView.getCallToActionView()).setText(userFindResult.hwNativeAd.getCallToAction());
        }
        nativeView.setNativeAd(userFindResult.hwNativeAd);
        AppDownloadButton appDownloadButton = (AppDownloadButton) nativeView.findViewById(R.id.app_download_btn);
        appDownloadButton.setAppDownloadButtonStyle(new HWAppDownloadStyle(this.f16394a));
        if (nativeView.register(appDownloadButton)) {
            appDownloadButton.setVisibility(0);
            appDownloadButton.refreshAppStatus();
            nativeView.getCallToActionView().setVisibility(8);
        } else {
            appDownloadButton.setVisibility(8);
            nativeView.getCallToActionView().setVisibility(0);
        }
        if (userFindResult.can_close != 1) {
            imageView2.setVisibility(8);
            return;
        }
        imageView2.setVisibility(0);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$PeopleListQuickAdapter$B2-hl-Wiy_4OyfiIvnFOP1_Prlo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PeopleListQuickAdapter.this.b(userFindResult, imageView2, view);
            }
        });
    }

    private void j(final BaseViewHolder baseViewHolder, final UserFindResult userFindResult) {
        baseViewHolder.setGone(R.id.cl_style_1, true);
        baseViewHolder.setGone(R.id.card_style_2, false);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_bg_1);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_tag_1);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_icon_1);
        ShapeLinearLayout view = baseViewHolder.getView(R.id.btn_enter_room_1);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_room_name_1);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_room_number_1);
        TextView textView4 = (TextView) baseViewHolder.getView(R.id.tv_enter_room_1);
        ShapeLinearLayout view2 = baseViewHolder.getView(R.id.ll_tag_1);
        imageView.setImageDrawable(BluedSkinUtils.b(this.f16394a, (int) R.drawable.item_people_list_new_yy_style_bg));
        imageView2.setImageDrawable(BluedSkinUtils.b(this.f16394a, (int) R.drawable.icon_live_column));
        view2.setShapeModel(e(false));
        if (TextUtils.isEmpty(userFindResult.chatroom.room_type)) {
            view2.setVisibility(8);
        } else {
            textView.setText(userFindResult.chatroom.room_type);
        }
        textView2.setText(userFindResult.chatroom.room_name);
        textView3.setText(userFindResult.chatroom.mem_count + "人");
        textView4.setText(R.string.enter_chat_room);
        view.setShapeModel(d(false));
        ((LinearLayout) baseViewHolder.getView(R.id.fl_main)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.PeopleListQuickAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                PeopleListQuickAdapter.this.c(baseViewHolder, userFindResult);
                PeopleListQuickAdapter.this.a(baseViewHolder.getView(2131364232), userFindResult);
            }
        });
    }

    private void k(final BaseViewHolder baseViewHolder, final UserFindResult userFindResult) {
        if (userFindResult == null || userFindResult.live_info == null) {
            return;
        }
        baseViewHolder.setGone(R.id.cl_style_1, false);
        baseViewHolder.setGone(R.id.card_style_2, true);
        baseViewHolder.setGone(R.id.iv_bg_2, true);
        if (TextUtils.isEmpty(userFindResult.live_info.live_stream_url) || !AppMethods.a(AppInfo.d())) {
            baseViewHolder.setGone(R.id.play_view_mantle, false);
        } else {
            baseViewHolder.setGone(R.id.play_view_mantle, true);
        }
        baseViewHolder.setGone(R.id.live_video_view, true);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_bg_2);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_icon_2);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_tag_2);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_room_name_2);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_room_number_2);
        ShapeLinearLayout view = baseViewHolder.getView(R.id.btn_enter_room_2);
        TextView textView4 = (TextView) baseViewHolder.getView(R.id.tv_enter_room_2);
        ShapeLinearLayout view2 = baseViewHolder.getView(R.id.ll_tag_2);
        imageView.setImageDrawable(BluedSkinUtils.b(this.f16394a, (int) R.drawable.item_people_list_new_live_style_bg));
        imageView2.setImageDrawable(BluedSkinUtils.b(this.f16394a, (int) R.drawable.icon_people_list_live));
        if (TextUtils.isEmpty(userFindResult.live_info.tag)) {
            textView.setVisibility(8);
        } else {
            textView.setText(userFindResult.live_info.tag);
        }
        textView2.setText(userFindResult.live_info.title);
        textView3.setText(userFindResult.live_info.member_count + "人");
        textView4.setText(R.string.enter_live_room);
        view.setShapeModel(d(true));
        view2.setShapeModel(e(true));
        ((LinearLayout) baseViewHolder.getView(R.id.fl_main)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.PeopleListQuickAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                PeopleListQuickAdapter.this.c(baseViewHolder, userFindResult);
                PeopleListQuickAdapter.this.a(baseViewHolder.getView(2131364232), userFindResult);
            }
        });
    }

    private void l() {
        if (this.x == null || !this.r) {
            return;
        }
        this.x.b();
    }

    private void l(BaseViewHolder baseViewHolder, UserFindResult userFindResult) {
        FlowLayout view = baseViewHolder.getView(R.id.tag_flow);
        if (userFindResult.user_tags == null || userFindResult.user_tags.length <= 0) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        view.removeAllViews();
        for (int i = 0; i < userFindResult.user_tags.length; i++) {
            View inflate = View.inflate(this.f16394a, R.layout.operate_user_flow_item, null);
            ((TextView) inflate.findViewById(R.id.tv_tag)).setText(userFindResult.user_tags[i]);
            view.addView(inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m() {
        Log.v("ddrb", " -- sortBy:" + this.b);
        return (!TextUtils.equals(this.b, UserFindResult.USER_SORT_BY.NEARBY) && TextUtils.equals(this.b, UserFindResult.USER_SORT_BY.ONLINE)) ? "home_online" : "home_nearby";
    }

    private void m(final BaseViewHolder baseViewHolder, final UserFindResult userFindResult) {
        ConstraintLayout constraintLayout = (ConstraintLayout) baseViewHolder.getView(2131367999);
        ImageView imageView = (ImageView) baseViewHolder.getView(2131364232);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_operate_title);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_operate_tag);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_operate_content);
        LinearLayout linearLayout = (LinearLayout) baseViewHolder.getView(R.id.ll_img_list);
        if (!userFindResult.isShowOperateVisited) {
            FindHttpUtils.b(userFindResult.show_url);
            userFindResult.isShowOperateVisited = true;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.PeopleListQuickAdapter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FindHttpUtils.b(userFindResult.click_url);
                WebViewShowInfoFragment.show(PeopleListQuickAdapter.this.f16394a, userFindResult.operate_promotion.deep_link_url, -1);
                if (UserFindResult.USER_SORT_BY.ONLINE.equals(PeopleListQuickAdapter.this.b)) {
                    PeopleListQuickAdapter.this.a(GuyProtos.Event.NEARBY_OPERATION_CLICK, userFindResult, GuyProtos.ShowType.LIST_SHOW, baseViewHolder.getLayoutPosition() + 1, false);
                } else {
                    PeopleListQuickAdapter.this.a(GuyProtos.Event.NEARBY_DISTANCE_OPERATION_CLICK, userFindResult, GuyProtos.ShowType.LIST_SHOW, baseViewHolder.getLayoutPosition() + 1, false);
                }
            }
        });
        ImageLoader.a(this.o, userFindResult.operate_promotion.master_image).b(2131237310).c().a(imageView);
        textView.setText(userFindResult.operate_promotion.show_title);
        if (TextUtils.isEmpty(userFindResult.operate_promotion.content)) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(0);
            textView3.setText(userFindResult.operate_promotion.content);
        }
        if (TextUtils.isEmpty(userFindResult.operate_promotion.tag)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(userFindResult.operate_promotion.tag);
        }
        if (UserFindResult.USER_SORT_BY.ONLINE.equals(this.b)) {
            a(GuyProtos.Event.NEARBY_OPERATION_SHOW, userFindResult, GuyProtos.ShowType.LIST_SHOW, baseViewHolder.getLayoutPosition() + 1, false);
        } else {
            a(GuyProtos.Event.NEARBY_DISTANCE_OPERATION_SHOW, userFindResult, GuyProtos.ShowType.LIST_SHOW, baseViewHolder.getLayoutPosition() + 1, false);
        }
        if (userFindResult.operate_promotion.list_images == null || userFindResult.operate_promotion.list_images.size() <= 0) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout.setVisibility(0);
        linearLayout.removeAllViews();
        for (int i = 0; i < userFindResult.operate_promotion.list_images.size(); i++) {
            String str = userFindResult.operate_promotion.list_images.get(i);
            ImageView imageView2 = new ImageView(this.f16394a);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DensityUtils.a(this.f16394a, 55.0f), DensityUtils.a(this.f16394a, 55.0f));
            layoutParams.setMarginEnd(DensityUtils.a(this.f16394a, 5.0f));
            imageView2.setLayoutParams(layoutParams);
            ImageLoader.a(this.o, str).a(6.0f).a(imageView2);
            linearLayout.addView(imageView2);
        }
    }

    private void n(BaseViewHolder baseViewHolder, UserFindResult userFindResult) {
        boolean z;
        ATNativeAdView aTNativeAdView = (ATNativeAdView) baseViewHolder.getView(2131361988);
        aTNativeAdView.findViewById(R.id.self_render_view);
        if (userFindResult.nativeAd == null) {
            if (userFindResult.nativeHandler != null) {
                userFindResult.nativeAd = userFindResult.nativeHandler.getNativeAd();
            }
            z = true;
        } else {
            z = false;
        }
        boolean z2 = z;
        if (BluedPreferences.E()) {
            z2 = z;
            if (AdTestManager.f21022a.a()) {
                z2 = z;
                if ((userFindResult.ads_id + "").equals(AdTestManager.f21022a.b().j())) {
                    z2 = z;
                    if (AdTestManager.f21022a.b().k()) {
                        userFindResult.nativeAd = null;
                        AdTestManager.f21022a.b().e(false);
                        z2 = true;
                    }
                }
            }
        }
        if (z2 || userFindResult.nativeAd == null) {
            Log.i("ddrb", "start to request new ad object.");
            c(userFindResult);
        }
        if (userFindResult.nativeAd == null) {
            Log.i("ddrb", "onBindAdViewHolder: NativeAd is null, it would be gone now.");
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) baseViewHolder.itemView.getLayoutParams();
            baseViewHolder.itemView.setVisibility(8);
            layoutParams.height = 0;
            layoutParams.width = 0;
            baseViewHolder.itemView.setLayoutParams(layoutParams);
            return;
        }
        Log.i("ddrb", "onBindAdViewHolder: NativeAd exist, start to render view.");
        Log.i("ddrb", "onBindAdViewHolder: RenderAd: " + userFindResult.nativeAd.getAdInfo().toString());
        baseViewHolder.itemView.setVisibility(0);
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) baseViewHolder.itemView.getLayoutParams();
        layoutParams2.height = -2;
        layoutParams2.width = -1;
        baseViewHolder.itemView.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 1;
        aTNativeAdView.setLayoutParams(layoutParams3);
        this.y.put(String.valueOf(userFindResult.nativeAd.hashCode()), userFindResult.nativeAd);
        a(userFindResult.nativeAd, baseViewHolder, userFindResult);
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    protected void a(View view, UserFindResult userFindResult) {
        MessageProtos.StrangerSource strangerSource;
        BluedPreferences.n();
        if (userFindResult.live_info != null) {
            if (this.s == 1 && UserFindResult.USER_SORT_BY.ONLINE.equalsIgnoreCase(this.b)) {
                UserRelationshipUtils.b(this.f16394a, userFindResult, userFindResult.live_info.lid, this.b, "home_online", userFindResult.recommend_type, userFindResult.userPositionReal + 1, getData());
            } else {
                UserRelationshipUtils.a(this.f16394a, userFindResult, userFindResult.live_info.lid, this.b, "home_distance", userFindResult.recommend_type, userFindResult.userPositionReal + 1, getData());
            }
        } else if (userFindResult.is_have_chatroom > 0 && userFindResult.chatroom != null && !TextUtils.isEmpty(userFindResult.chatroom.room_id)) {
            if (!UserFindResult.USER_SORT_BY.ONLINE.equalsIgnoreCase(this.b)) {
                YYRoomInfoManager.e().a(this.f16394a, userFindResult.chatroom.room_id, "home_distance_yy_icon");
            } else if (userFindResult.is_insert_chatroom == 1) {
                YYRoomInfoManager.e().a(this.f16394a, userFindResult.chatroom.room_id, "home_online_yy_room");
            } else {
                YYRoomInfoManager.e().a(this.f16394a, userFindResult.chatroom.room_id, "home_online_yy_icon");
            }
        } else {
            String str = "";
            if (!TextUtils.isEmpty(userFindResult.redirect_url)) {
                LiveUtils.a("home_online", userFindResult.recommend_type, userFindResult.userPositionReal + 1);
                WebViewShowInfoFragment.a(this.f16394a, userFindResult.redirect_url, "", false, 9);
            } else if (userFindResult.is_invisible_half == 1 && ((UserInfo.getInstance().getLoginUserInfo().vip_grade != 2 && UserInfo.getInstance().getLoginUserInfo().vip_grade != 1) || BluedConfig.a().g().is_invisible_half == 0)) {
                PayUtils.a(this.f16394a, 3, "setting_half_invisible");
            } else {
                LogData logData = new LogData();
                logData.is_hello = userFindResult.is_call + "";
                logData.type = "1";
                logData.distance = StringUtils.d(userFindResult.distanceStr) ? userFindResult.distance : userFindResult.distanceStr;
                logData.online_time = StringUtils.d(userFindResult.last_operate_str) ? userFindResult.last_operate : userFindResult.last_operate_str;
                logData.isShadow = userFindResult.is_shadow == 1;
                logData.isQuietHello = userFindResult.is_quietly == 1;
                logData.is_call = userFindResult.is_call + "";
                logData.is_special = userFindResult.itemType == 19 ? "1" : "0";
                logData.show_type = "LIST_SHOW";
                if (UserFindResult.USER_SORT_BY.NEARBY.equals(this.b)) {
                    strangerSource = MessageProtos.StrangerSource.DISTANCE_SORT;
                } else if (UserFindResult.USER_SORT_BY.ONLINE.equals(this.b)) {
                    strangerSource = MessageProtos.StrangerSource.ONLINE_TIME_SORT;
                } else if (UserFindResult.USER_SORT_BY.NEWBEE.equals(this.b)) {
                    strangerSource = MessageProtos.StrangerSource.FRIEND_NEARBY_NEW_FACE;
                } else if ("tag_user".equals(this.b)) {
                    strangerSource = MessageProtos.StrangerSource.FRIEND_NEARBY_PERSONAL_NEARBY;
                    str = b();
                } else {
                    strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
                }
                if (MapFindManager.a().b()) {
                    strangerSource = MessageProtos.StrangerSource.MAP_FIND;
                }
                MessageProtos.StrangerSource strangerSource2 = strangerSource;
                if (userFindResult.is_shadow == 1) {
                    strangerSource2 = MessageProtos.StrangerSource.SHADOW_SOURCE;
                }
                MessageProtos.StrangerSource strangerSource3 = strangerSource2;
                if (userFindResult.is_call == 1) {
                    if (UserFindResult.USER_SORT_BY.INTEGRATE.equalsIgnoreCase(this.b)) {
                        strangerSource3 = MessageProtos.StrangerSource.APPRECIATE_CALL_COMPLEX;
                    } else {
                        strangerSource3 = strangerSource2;
                        if (UserFindResult.USER_SORT_BY.ONLINE.equalsIgnoreCase(this.b)) {
                            strangerSource3 = MessageProtos.StrangerSource.APPRECIATE_CALL_ONLINE;
                        }
                    }
                }
                String str2 = this.b;
                if (userFindResult.itemType == 19) {
                    str2 = "nearby_operation";
                }
                if (userFindResult.is_eco_user == 1) {
                    UserInfoFragmentNew.a(this.f16394a, userFindResult.uid);
                } else {
                    UserInfoFragmentNew.a(this.f16394a, userFindResult, str2, userFindResult.live_info != null, view, logData, new MsgSourceEntity(strangerSource3, str));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, UserFindResult userFindResult) {
        a(userFindResult, baseViewHolder.getAdapterPosition() - getHeaderLayoutCount());
        String str = TAG;
        Log.e(str, "convert: userName=" + userFindResult.name + " ,itemType=" + userFindResult.itemType);
        a(baseViewHolder);
        if (baseViewHolder != null) {
            switch (baseViewHolder.getItemViewType()) {
                case 11:
                    d(baseViewHolder, userFindResult);
                    return;
                case 12:
                case 15:
                case 20:
                case 21:
                default:
                    b(baseViewHolder, userFindResult);
                    return;
                case 13:
                case 23:
                    f(baseViewHolder, userFindResult);
                    return;
                case 14:
                    g(baseViewHolder, userFindResult);
                    return;
                case 16:
                    Log.v("ddrb", "bind topon 原生广告");
                    n(baseViewHolder, userFindResult);
                    return;
                case 17:
                    e(baseViewHolder, userFindResult);
                    return;
                case 18:
                    h(baseViewHolder, userFindResult);
                    return;
                case 19:
                    b(baseViewHolder, userFindResult);
                    l(baseViewHolder, userFindResult);
                    return;
                case 22:
                    m(baseViewHolder, userFindResult);
                    return;
                case 24:
                case 26:
                    b(baseViewHolder, userFindResult);
                    k(baseViewHolder, userFindResult);
                    return;
                case 25:
                    b(baseViewHolder, userFindResult);
                    j(baseViewHolder, userFindResult);
                    return;
                case 27:
                    i(baseViewHolder, userFindResult);
                    return;
            }
        }
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public void a(OnShowRegisterUserGuideDialogListener onShowRegisterUserGuideDialogListener) {
        this.w = onShowRegisterUserGuideDialogListener;
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public void b(int i, UserFindResult userFindResult) {
        String str;
        String str2;
        if (userFindResult.isShowUrlVisited) {
            return;
        }
        int headerLayoutCount = i - getHeaderLayoutCount();
        if (userFindResult.live_info != null || !TextUtils.isEmpty(userFindResult.redirect_url)) {
            if (TextUtils.equals(this.b, UserFindResult.USER_SORT_BY.ONLINE)) {
                EventTrackGuy.a(GuyProtos.Event.ONLINE_LIVE_USER_SHOW, String.valueOf(userFindResult.live_info.lid), userFindResult.uid + "", userFindResult.recommend_type, headerLayoutCount + 1, GuyProtos.SortType.ONLINE_TIME_SORT, false);
            } else {
                EventTrackGuy.a(GuyProtos.Event.ONLINE_LIVE_USER_SHOW, String.valueOf(userFindResult.live_info.lid), userFindResult.uid + "", userFindResult.recommend_type, headerLayoutCount + 1, GuyProtos.SortType.DISTANCE_SORT, false);
            }
        }
        if (userFindResult.is_have_chatroom > 0 && userFindResult.chatroom != null) {
            EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_USER_CHATROOM_SHOW, userFindResult.uid, userFindResult.chatroom.room_id, userFindResult.chatroom.uid);
        }
        if (StringUtils.d(userFindResult.uid)) {
            return;
        }
        this.e += Constants.ACCEPT_TIME_SEPARATOR_SERVER + userFindResult.uid;
        if (userFindResult.is_call == 1) {
            this.f += Constants.ACCEPT_TIME_SEPARATOR_SERVER + userFindResult.uid;
        }
        if (InstantLog.a(this.b, this.e, this.f, 1)) {
            this.e = "";
            this.f = "";
        }
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("u", userFindResult.uid);
        a2.put("d", userFindResult.is_hide_distance == 1 ? "-1" : StringUtils.d(userFindResult.distanceStr) ? userFindResult.distance : userFindResult.distanceStr);
        a2.put("t", userFindResult.is_hide_last_operate == 1 ? "-1" : userFindResult.last_operate_time_stamp);
        a2.put(MineEntryInfo.ColumnsExtra.TYPE_SHADOW, userFindResult.is_shadow == 1 ? "1" : "0");
        a2.put(b.cZ, userFindResult.is_reactive_recommend == 1 ? "1" : "0");
        a2.put("call", userFindResult.is_call == 1 ? "1" : "0");
        a2.put("live", userFindResult.live_info != null ? "1" : "0");
        a2.put("lt", userFindResult.lt);
        a2.put("cq", userFindResult.is_quietly == 1 ? "1" : "0");
        a2.put("auto", "0");
        a2.put("rt", userFindResult.recommend_type);
        a2.put("n", headerLayoutCount + "");
        a2.put(FullBackup.SHAREDPREFS_TREE_TOKEN, userFindResult.itemType == 19 ? "1" : "0");
        a2.put("like", userFindResult.is_recommend + "");
        a2.put("virtual", userFindResult.users_face == 1 ? "1" : "0");
        a2.put("yy", userFindResult.is_have_chatroom == 1 ? "1" : "0");
        if (userFindResult.is_have_chatroom == 1) {
            a2.put("yy_type", userFindResult.is_insert_chatroom == 1 ? "2" : "1");
        }
        a2.put("super", userFindResult.is_super_privilege_user == 1 ? "1" : "0");
        a2.put("bubble", userFindResult.bubble != null ? "1" : "0");
        if (userFindResult.live_info != null) {
            str = userFindResult.live_info.lid + "";
        } else {
            str = userFindResult.chatroom != null ? userFindResult.chatroom.room_id : "";
        }
        if (!TextUtils.isEmpty(str)) {
            a2.put("id", str);
        }
        this.n.add(a2);
        this.v++;
        if (headerLayoutCount > 25 && headerLayoutCount < 30 && BluedConfig.a().b().is_register_expierment_open == 1 && UserInfo.getInstance().getLoginUserInfo().vip_grade == 0 && this.w != null && BluedPreferences.eJ()) {
            this.w.a();
            BluedPreferences.eK();
        }
        if (headerLayoutCount == 25) {
            ChatHttpUtils.a();
        }
        if (this.n.size() == 5) {
            EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_PHOTO_DRAW, AppInfo.f().toJson(this.n), EventTrackGuy.c(this.b), GuyProtos.ShowType.LIST_SHOW, MapFindManager.a().b());
            this.n.clear();
        }
        if (UserFindResult.USER_SORT_BY.NEARBY.equals(this.b)) {
            str2 = "DISTANCE_SORT";
        } else {
            str2 = "";
            if (UserFindResult.USER_SORT_BY.ONLINE.equals(this.b)) {
                str2 = "ONLINE_TIME_SORT";
            }
        }
        GuyEventUtils.a(str2, userFindResult.uid, "LIST_SHOW", userFindResult.is_call == 1, userFindResult.itemType == 19, userFindResult.is_have_chatroom == 1, userFindResult.live_info != null);
        userFindResult.isShowUrlVisited = true;
        if (this.t != null) {
            this.t.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onViewRecycled(BaseViewHolder baseViewHolder) {
        super.onViewRecycled(baseViewHolder);
        BannerADView bannerADView = (BannerADView) baseViewHolder.getView(R.id.banner_ad);
        if (bannerADView != null) {
            AdTestManager.f21022a.b().d(bannerADView);
        }
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public void b(final BaseViewHolder baseViewHolder, final UserFindResult userFindResult) {
        final ImageView imageView = (ImageView) baseViewHolder.getView(2131364232);
        TextView textView = (TextView) baseViewHolder.getView(R.id.name_view);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.distance_view);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.online_time_view);
        TextView textView4 = (TextView) baseViewHolder.getView(R.id.age_view);
        TextView textView5 = (TextView) baseViewHolder.getView(R.id.height_view);
        TextView textView6 = (TextView) baseViewHolder.getView(R.id.weight_view);
        TextView textView7 = (TextView) baseViewHolder.getView(R.id.sign_view);
        FeedBubbleStateView feedBubbleStateView = (FeedBubbleStateView) baseViewHolder.getView(R.id.feed_bubble_state_view_id);
        feedBubbleStateView.setBusinessType(1);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.img_verify);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.img_online);
        ImageView imageView4 = (ImageView) baseViewHolder.getView(R.id.list_call_icon);
        ImageView imageView5 = (ImageView) baseViewHolder.getView(R.id.img_blued_medal);
        View view = baseViewHolder.getView(R.id.layout_friend);
        ImageView imageView6 = (ImageView) baseViewHolder.getView(R.id.img_eco_icon);
        ImageView imageView7 = (ImageView) baseViewHolder.getView(R.id.img_live_new_icon);
        TextView textView8 = (TextView) baseViewHolder.getView(R.id.img_recommend);
        ImageView imageView8 = (ImageView) baseViewHolder.getView(R.id.img_chat);
        View view2 = baseViewHolder.getView(R.id.event_icon);
        LinearLayout linearLayout = (LinearLayout) baseViewHolder.getView(R.id.ll_personal_info);
        LinearLayout linearLayout2 = (LinearLayout) baseViewHolder.getView(R.id.ll_user_info);
        ShapeTextView view3 = baseViewHolder.getView(R.id.tv_recommend);
        ImageView imageView9 = (ImageView) baseViewHolder.getView(R.id.iv_user_face);
        if (userFindResult.is_eco_user == 1) {
            imageView6.setVisibility(0);
        } else {
            imageView6.setVisibility(8);
        }
        if (userFindResult.show_activity == 1) {
            view2.setVisibility(0);
        } else {
            view2.setVisibility(8);
        }
        if (userFindResult.users_face == 1 && userFindResult.getItemType() == 10) {
            imageView9.setVisibility(0);
        } else {
            imageView9.setVisibility(8);
        }
        imageView2.setVisibility(0);
        UserInfoHelper.b(imageView2, userFindResult.vbadge, 4, 8);
        imageView3.setVisibility(0);
        imageView7.setVisibility(8);
        imageView8.setVisibility(8);
        if (userFindResult.is_recommend == 1) {
            view3.setVisibility(0);
        } else {
            view3.setVisibility(8);
        }
        if (userFindResult.call_tip == 1) {
            textView8.setVisibility(8);
            imageView4.setVisibility(0);
        } else {
            imageView4.setVisibility(8);
        }
        if (userFindResult.live_info != null) {
            imageView3.setVisibility(8);
            imageView4.setVisibility(8);
            textView8.setVisibility(8);
        } else if (!TextUtils.isEmpty(userFindResult.redirect_url)) {
            imageView3.setVisibility(8);
            imageView4.setVisibility(8);
            textView8.setVisibility(8);
            imageView8.setVisibility(8);
        } else if (userFindResult.is_have_chatroom == 1) {
            imageView3.setVisibility(8);
            imageView4.setVisibility(8);
            textView8.setVisibility(8);
        } else if (userFindResult.online_state == 1) {
            imageView8.setVisibility(8);
            if (BluedPreferences.cK()) {
                imageView3.setImageResource(2131233954);
            } else {
                imageView3.setImageResource(2131233953);
            }
        } else {
            imageView8.setVisibility(8);
            if (BluedPreferences.cK()) {
                imageView3.setImageResource(2131233952);
            } else {
                imageView3.setImageResource(2131233951);
            }
        }
        if (TextUtils.isEmpty(userFindResult.redirect_url)) {
            ImageLoader.a(this.o, userFindResult.is_invisible_half == 1 ? userFindResult.avatar : AvatarUtils.a(0, userFindResult.avatar)).b(2131237310).c().a(imageView);
        } else {
            ImageLoader.a(this.o, userFindResult.list_avatar).b(2131237310).c().a(imageView);
        }
        UserRelationshipUtils.a(imageView5, userFindResult);
        String str = !TextUtils.isEmpty(userFindResult.note) ? userFindResult.note : !TextUtils.isEmpty(userFindResult.name) ? userFindResult.name : "";
        if (a(baseViewHolder.getLayoutPosition())) {
            str = "用户昵称";
        }
        SpannableString spannableString = new SpannableString(str);
        if (a(baseViewHolder.getLayoutPosition())) {
            spannableString.setSpan(new MaskFilterSpan(new BlurMaskFilter(10.0f, BlurMaskFilter.Blur.NORMAL)), 0, spannableString.length(), 17);
        }
        textView.setText(spannableString);
        UserRelationshipUtils.a(this.f16394a, textView, userFindResult);
        if (TextUtils.isEmpty(userFindResult.redirect_url)) {
            textView2.setVisibility(0);
            textView3.setVisibility(0);
            linearLayout.setVisibility(0);
            String str2 = StringUtils.d(userFindResult.distanceStr) ? userFindResult.distance : userFindResult.distanceStr;
            if (TextUtils.isEmpty(str2)) {
                textView2.setText("");
            } else {
                textView2.setText(str2);
            }
            DistanceUtils.a(this.f16394a, textView2, userFindResult, 1);
            String str3 = StringUtils.d(userFindResult.last_operate_str) ? userFindResult.last_operate : userFindResult.last_operate_str;
            if (TextUtils.isEmpty(str3)) {
                textView3.setText("");
            } else {
                textView3.setText(str3);
            }
            TypefaceUtils.a(this.f16394a, textView3, userFindResult.is_hide_last_operate, 1);
            if (UserInfoHelper.a(userFindResult.vbadge) || UserInfoHelper.b(userFindResult.vbadge)) {
                linearLayout.setVisibility(8);
            } else {
                linearLayout.setVisibility(0);
                if (TextUtils.isEmpty(userFindResult.age)) {
                    textView4.setText("");
                } else {
                    textView4.setText(userFindResult.age + this.f16394a.getResources().getString(2131886374));
                }
                if (TextUtils.isEmpty(userFindResult.height)) {
                    textView5.setText("");
                } else {
                    textView5.setText(userFindResult.height);
                }
                if (TextUtils.isEmpty(userFindResult.weight)) {
                    textView6.setText("");
                } else {
                    textView6.setText(userFindResult.weight);
                }
            }
        } else {
            textView2.setVisibility(8);
            textView3.setVisibility(8);
            linearLayout.setVisibility(8);
        }
        feedBubbleStateView.setBubbleState(userFindResult.bubble);
        if (TextUtils.isEmpty(userFindResult.description)) {
            textView7.setText("");
            textView7.setVisibility(8);
        } else {
            textView7.setVisibility(0);
            textView7.setText(userFindResult.description);
        }
        view.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.PeopleListQuickAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view4) {
                Tracker.onClick(view4);
                if (PeopleListQuickAdapter.this.a(baseViewHolder.getLayoutPosition())) {
                    PayVIPPopupWindow.c.a(PeopleListQuickAdapter.this.f16394a, 2, BluedPreferences.fa(), BluedPreferences.fb());
                    return;
                }
                LiveEventBus.get(EventBusConstant.KEY_EVENT_IS_CLICK_ON_HEADER).post(true);
                PeopleListQuickAdapter.this.c(baseViewHolder, userFindResult);
                if (PeopleGridQuickAdapter.a(userFindResult)) {
                    if (UserFindResult.USER_SORT_BY.ONLINE.equals(PeopleListQuickAdapter.this.b)) {
                        PeopleListQuickAdapter.this.a(GuyProtos.Event.NEARBY_OPERATION_CLICK, userFindResult, GuyProtos.ShowType.LIST_SHOW, baseViewHolder.getLayoutPosition() + 1, true);
                    } else {
                        PeopleListQuickAdapter.this.a(GuyProtos.Event.NEARBY_DISTANCE_OPERATION_CLICK, userFindResult, GuyProtos.ShowType.LIST_SHOW, baseViewHolder.getLayoutPosition() + 1, true);
                    }
                }
                PeopleListQuickAdapter.this.a(imageView, userFindResult);
            }
        }));
        if (linearLayout.getVisibility() == 0 || view2.getVisibility() == 0 || imageView6.getVisibility() == 0 || textView7.getVisibility() == 8) {
            linearLayout2.setVisibility(0);
        } else {
            linearLayout2.setVisibility(8);
        }
        if (a(userFindResult)) {
            if (UserFindResult.USER_SORT_BY.ONLINE.equals(this.b)) {
                a(GuyProtos.Event.NEARBY_OPERATION_SHOW, userFindResult, GuyProtos.ShowType.LIST_SHOW, 1 + baseViewHolder.getLayoutPosition(), true);
            } else {
                a(GuyProtos.Event.NEARBY_DISTANCE_OPERATION_SHOW, userFindResult, GuyProtos.ShowType.LIST_SHOW, 1 + baseViewHolder.getLayoutPosition(), true);
            }
        }
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    protected void c(BaseViewHolder baseViewHolder, UserFindResult userFindResult) {
        String str;
        LogData logData = new LogData();
        logData.logService = "click_position";
        logData.position = (baseViewHolder.getAdapterPosition() - getHeaderLayoutCount()) + "";
        logData.from = this.b;
        logData.uid = userFindResult.uid;
        logData.is_hello = userFindResult.is_call + "";
        logData.type = "1";
        InstantLog.a(logData);
        if (!BluedPreferences.aa().equals("0-max")) {
            InstantLog.g("personal_page", "1");
        } else {
            InstantLog.g("personal_page", "0");
        }
        int adapterPosition = baseViewHolder.getAdapterPosition();
        int headerLayoutCount = getHeaderLayoutCount();
        Map a2 = BluedHttpTools.a();
        a2.put("u", userFindResult.uid);
        a2.put("d", userFindResult.is_hide_distance == 1 ? "-1" : StringUtils.d(userFindResult.distanceStr) ? userFindResult.distance : userFindResult.distanceStr);
        a2.put("t", userFindResult.is_hide_last_operate == 1 ? "-1" : userFindResult.last_operate_time_stamp);
        a2.put("virtual", userFindResult.users_face == 1 ? "1" : "0");
        if (userFindResult.live_info != null) {
            str = userFindResult.live_info.lid + "";
        } else {
            str = userFindResult.chatroom != null ? userFindResult.chatroom.room_id : "";
        }
        EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_USER_PHOTO_CLICK, AppInfo.f().toJson(a2), EventTrackGuy.c(this.b), GuyProtos.ShowType.LIST_SHOW, MapFindManager.a().b(), userFindResult.is_shadow == 1, userFindResult.is_call == 1, userFindResult.live_info != null, userFindResult.lt, userFindResult.is_quietly == 1, false, userFindResult.is_reactive_recommend == 1, adapterPosition - headerLayoutCount, userFindResult.recommend_type, userFindResult.itemType == 19, userFindResult.is_recommend, userFindResult.is_have_chatroom == 1, userFindResult.is_super_privilege_user == 1, str, userFindResult.bubble != null);
        GuyEventUtils.b(UserFindResult.USER_SORT_BY.NEARBY.equals(this.b) ? "DISTANCE_SORT" : UserFindResult.USER_SORT_BY.ONLINE.equals(this.b) ? "ONLINE_TIME_SORT" : "", userFindResult.uid, "LIST_SHOW", userFindResult.is_call == 1, userFindResult.itemType == 19, userFindResult.is_have_chatroom == 1, userFindResult.live_info != null);
        if (userFindResult.live_info != null) {
            int i = userFindResult instanceof UserFindExtra ? ((UserFindExtra) userFindResult).position + 1 : 0;
            if (TextUtils.equals(this.b, UserFindResult.USER_SORT_BY.ONLINE)) {
                EventTrackGuy.a(GuyProtos.Event.ONLINE_LIVE_USER_CLICK, String.valueOf(userFindResult.live_info.lid), userFindResult.uid + "", userFindResult.recommend_type, i, GuyProtos.SortType.ONLINE_TIME_SORT, false);
            } else {
                EventTrackGuy.a(GuyProtos.Event.ONLINE_LIVE_USER_CLICK, String.valueOf(userFindResult.live_info.lid), userFindResult.uid + "", userFindResult.recommend_type, i, GuyProtos.SortType.DISTANCE_SORT, false);
            }
        }
        if (userFindResult.is_have_chatroom <= 0 || userFindResult.chatroom == null) {
            return;
        }
        EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_USER_CHATROOM_CLICK, userFindResult.uid, userFindResult.chatroom.room_id, userFindResult.chatroom.uid);
    }

    public void c(final UserFindResult userFindResult) {
        if (userFindResult.nativeHandler == null) {
            userFindResult.nativeHandler = new ATNative(this.f16394a, userFindResult.third_id, new ATNativeNetworkListener() { // from class: com.soft.blued.ui.find.adapter.PeopleListQuickAdapter.10
                @Override // com.anythink.nativead.api.ATNativeNetworkListener
                public void onNativeAdLoadFail(AdError adError) {
                    Log.v("ddrb", "topon原生广告载入失败：" + adError.getFullErrorInfo());
                    LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_NATIVE_RESPONSE_FAIL;
                    EventTrackLoginAndRegister.c(event, userFindResult.ads_id + "", userFindResult.adms_type, PeopleListQuickAdapter.this.m(), adError.getFullErrorInfo());
                }

                @Override // com.anythink.nativead.api.ATNativeNetworkListener
                public void onNativeAdLoaded() {
                    Log.v("ddrb", "topon原生广告加载成功,刷新列表");
                    PeopleListQuickAdapter.this.f();
                    LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_NATIVE_RESPONSE;
                    EventTrackLoginAndRegister.b(event, userFindResult.ads_id + "", userFindResult.adms_type, PeopleListQuickAdapter.this.m());
                }
            });
        }
        HashMap hashMap = new HashMap();
        hashMap.put("key_width", Integer.valueOf(this.z));
        hashMap.put("key_height", Integer.valueOf(this.A));
        hashMap.put(TTATConst.NATIVE_AD_IMAGE_HEIGHT, 0);
        hashMap.put(GDTATConst.AD_HEIGHT, -2);
        userFindResult.nativeHandler.setLocalExtra(hashMap);
        userFindResult.nativeHandler.makeAdRequest();
        LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_NATIVE_REQUEST;
        EventTrackLoginAndRegister.b(event, userFindResult.ads_id + "", userFindResult.adms_type, m());
        Log.i("ddrb", "native ad start to load ad------------- ");
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public void c(String str) {
        if (this.n.size() > 0) {
            EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_PHOTO_DRAW, AppInfo.f().toJson(this.n), EventTrackGuy.c(str), GuyProtos.ShowType.LIST_SHOW, MapFindManager.a().b());
            this.n.clear();
        }
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public boolean c() {
        View findViewByPosition;
        this.x = null;
        RecyclerView.LayoutManager layoutManager = getRecyclerView().getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition() - getHeaderLayoutCount();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition() - getHeaderLayoutCount();
            if (this.mData != null && findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition <= findLastVisibleItemPosition && findLastVisibleItemPosition < this.mData.size()) {
                while (true) {
                    if (findFirstVisibleItemPosition >= findLastVisibleItemPosition) {
                        break;
                    }
                    UserFindResult userFindResult = (UserFindResult) this.mData.get(findFirstVisibleItemPosition);
                    if (userFindResult.getItemType() == 24 && userFindResult.live_info != null && !TextUtils.isEmpty(userFindResult.live_info.live_stream_url) && (findViewByPosition = linearLayoutManager.findViewByPosition(getHeaderLayoutCount() + findFirstVisibleItemPosition)) != null) {
                        LiveAutoPlayView findViewById = findViewByPosition.findViewById(R.id.live_video_view);
                        this.x = findViewById;
                        if (findViewById != null) {
                            BluedLiveListData bluedLiveListData = new BluedLiveListData();
                            bluedLiveListData.lid = String.valueOf(userFindResult.live_info.lid);
                            bluedLiveListData.live_play = userFindResult.live_info.live_stream_url;
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.x.getLayoutParams();
                            LiveAutoPlayView liveAutoPlayView = this.x;
                            liveAutoPlayView.a(this, bluedLiveListData, "", liveAutoPlayView.getMeasuredWidth(), this.x.getMeasuredHeight());
                            this.x.setVisibility(0);
                            break;
                        }
                    }
                    findFirstVisibleItemPosition++;
                }
            } else {
                return false;
            }
        }
        LiveAutoPlayView liveAutoPlayView2 = this.x;
        if (liveAutoPlayView2 == null || !liveAutoPlayView2.e() || this.x.getHeight() == 0) {
            return false;
        }
        l();
        return true;
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public void d() {
        addItemType(10, R.layout.item_people_list);
        addItemType(20, R.layout.item_people_list);
        addItemType(19, R.layout.item_operate_people_list);
        addItemType(11, R.layout.item_people_ad_layout);
        addItemType(13, R.layout.native_ad_item);
        addItemType(14, R.layout.native_ad_item);
        addItemType(15, R.layout.native_ad_item);
        addItemType(18, R.layout.native_ad_item);
        addItemType(27, R.layout.native_hw_ad_item);
        addItemType(16, R.layout.native_list_ad_item);
        addItemType(23, R.layout.native_ad_item);
        addItemType(17, R.layout.item_people_visible_to_vip_layout);
        addItemType(22, R.layout.item_people_list_operate_promotion);
        addItemType(25, R.layout.item_people_list_new_living_user);
        addItemType(24, R.layout.item_people_list_new_living_user);
        addItemType(26, R.layout.item_people_list_new_living_user);
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public void d(BaseViewHolder baseViewHolder, final UserFindResult userFindResult) {
        BannerADView bannerADView = (BannerADView) baseViewHolder.getView(R.id.banner_ad);
        Log.v("drb", "身边列表加载banner广告");
        if (BluedPreferences.E() && AdTestManager.f21022a.a()) {
            AdTestManager.f21022a.b().a("TRYP_BANNER_2", (BluedADExtra) userFindResult);
            if ((userFindResult.ads_id + "").equals(AdTestManager.f21022a.b().i())) {
                AdTestManager.f21022a.b().c(bannerADView);
            }
            bannerADView.d = null;
        }
        bannerADView.a(this.o, userFindResult, ADConstants.AD_POSITION.NEARBY_HOME_LIST_BANNER, new BannerADView.ADListener() { // from class: com.soft.blued.ui.find.adapter.PeopleListQuickAdapter.5
            @Override // com.soft.blued.customview.BannerADView.ADListener
            public void a() {
                PeopleListQuickAdapter.this.mData.remove(userFindResult);
                PeopleListQuickAdapter.this.f();
            }

            @Override // com.soft.blued.customview.BannerADView.ADListener
            public void b() {
                PeopleListQuickAdapter.this.mData.remove(userFindResult);
                PeopleListQuickAdapter.this.f();
            }
        });
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) baseViewHolder.getView(R.id.banner_ad).getLayoutParams();
        layoutParams.rightMargin = 0;
        baseViewHolder.getView(R.id.banner_ad).setLayoutParams(layoutParams);
    }

    public void f(BaseViewHolder baseViewHolder, final UserFindResult userFindResult) {
        ((BluedADConstraintLayout) baseViewHolder.getView(R.id.fl_main)).setADData(userFindResult);
        ImageView imageView = (ImageView) baseViewHolder.getView(2131364232);
        TextView textView = (TextView) baseViewHolder.getView(R.id.name_view);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_style_1_ad_text);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_style_2_ad_text);
        TextView textView4 = (TextView) baseViewHolder.getView(R.id.tv_desc);
        final ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.img_close);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.img_style_1_ad_icon);
        ImageView imageView4 = (ImageView) baseViewHolder.getView(R.id.img_style_2_ad_icon);
        ConstraintLayout constraintLayout = (ConstraintLayout) baseViewHolder.getView(R.id.cl_style_1);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) baseViewHolder.getView(R.id.cl_style_2);
        ViewGroup viewGroup = (ViewGroup) baseViewHolder.getView(R.id.cv_content);
        ImageView imageView5 = (ImageView) baseViewHolder.getView(R.id.iv_resource);
        if ("7".equalsIgnoreCase(userFindResult.adms_type)) {
            imageView3.setVisibility(0);
            imageView4.setVisibility(0);
            imageView3.setImageResource(R.drawable.icon_xiaomi_ad_icon);
            imageView4.setImageResource(R.drawable.icon_xiaomi_ad_icon);
        } else {
            imageView3.setVisibility(8);
            imageView4.setVisibility(8);
        }
        if (userFindResult.is_show_adm_icon == 1) {
            textView2.setVisibility(0);
            textView3.setVisibility(0);
        } else {
            textView2.setVisibility(4);
            textView3.setVisibility(4);
        }
        if (userFindResult.can_close == 1) {
            imageView2.setVisibility(0);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$PeopleListQuickAdapter$z8GpD7Iso8CT46CIg3XfY36pwhs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PeopleListQuickAdapter.this.a(userFindResult, imageView2, view);
                }
            });
        } else {
            imageView2.setVisibility(8);
        }
        ImageLoader.a(this.o, userFindResult.avatar).b(2131237310).c().a(imageView);
        textView.setText(userFindResult.name);
        textView4.setText(userFindResult.description);
        Log.v("ddrb", "mItemData.style_view:" + userFindResult.style_view + " -- mItemData.style_material:" + userFindResult.style_material);
        if (userFindResult.style_view != 2 || TextUtils.isEmpty(userFindResult.style_material)) {
            imageView5.setVisibility(8);
            viewGroup.setVisibility(8);
            constraintLayout.setVisibility(0);
            return;
        }
        imageView5.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = imageView5.getLayoutParams();
        layoutParams.height = this.C;
        imageView5.setLayoutParams(layoutParams);
        ImageLoader.a(this.o, userFindResult.style_material).a(imageView5);
        viewGroup.setVisibility(0);
        constraintLayout.setVisibility(8);
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public void g() {
        LiveAutoPlayView liveAutoPlayView = this.x;
        if (liveAutoPlayView != null) {
            liveAutoPlayView.c();
        }
    }

    public void g(BaseViewHolder baseViewHolder, final UserFindResult userFindResult) {
        userFindResult.is_show_adm_icon = 1;
        userFindResult.can_close = 1;
        f(baseViewHolder, userFindResult);
        ((BluedADConstraintLayout) baseViewHolder.getView(R.id.fl_main)).a(userFindResult, new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$PeopleListQuickAdapter$LdoG-uWNzO6b8xRxHqs93fPpJAU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        ImageLoader.a(this.o, userFindResult.avatar).b(2131237310).c().a((ImageView) baseViewHolder.getView(2131364232));
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.img_style_1_ad_icon);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.img_style_2_ad_icon);
        imageView.setImageResource(2131233931);
        imageView2.setImageResource(2131233931);
        imageView.setVisibility(0);
        imageView2.setVisibility(0);
        if (userFindResult.ttNativeAdData != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(baseViewHolder.getView(R.id.layout_friend));
            userFindResult.ttNativeAdData.registerViewForInteraction((ViewGroup) baseViewHolder.getView(R.id.layout_friend), arrayList, arrayList, new TTNativeAd.AdInteractionListener() { // from class: com.soft.blued.ui.find.adapter.PeopleListQuickAdapter.6
                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdClicked(View view, TTNativeAd tTNativeAd) {
                    FindHttpUtils.b(userFindResult.click_url);
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
                    FindHttpUtils.b(userFindResult.click_url);
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdShow(TTNativeAd tTNativeAd) {
                }
            });
            userFindResult.ttNativeAdData.getInteractionType();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.soft.blued.customview.BluedADConstraintLayout, java.lang.Object, android.view.ViewGroup] */
    public void h(BaseViewHolder baseViewHolder, final UserFindResult userFindResult) {
        userFindResult.is_show_adm_icon = 1;
        userFindResult.can_close = 1;
        f(baseViewHolder, userFindResult);
        ?? r0 = (BluedADConstraintLayout) baseViewHolder.getView(R.id.fl_main);
        r0.a(userFindResult, new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$PeopleListQuickAdapter$1XP5ijlh75r-iwgoTmtU72UKVzQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.img_style_1_ad_icon);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.img_style_2_ad_icon);
        imageView.setImageResource(2131233453);
        imageView2.setImageResource(2131233453);
        imageView.setVisibility(0);
        imageView2.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(r0);
        userFindResult.ksNativeAd.registerViewForInteraction((Activity) this.f16394a, (ViewGroup) r0, arrayList, new KsNativeAd.AdInteractionListener() { // from class: com.soft.blued.ui.find.adapter.PeopleListQuickAdapter.7
            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                return false;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdClicked(View view, KsNativeAd ksNativeAd) {
                FindHttpUtils.b(userFindResult.click_url);
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdShow(KsNativeAd ksNativeAd) {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
            }
        });
    }

    public void i() {
        for (NativeAd nativeAd : this.y.values()) {
            nativeAd.onResume();
        }
    }

    public void j() {
        for (NativeAd nativeAd : this.y.values()) {
            nativeAd.onPause();
        }
    }

    public void k() {
        if (this.mData != null) {
            for (T t : this.mData) {
                if (t.nativeAd != null) {
                    t.nativeAd.destory();
                }
            }
        }
    }
}
