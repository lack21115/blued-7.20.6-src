package com.blued.android.module.yy_china.presenter;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.SharedPreferencesUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.live.base.constants.LiveEventBusConstant;
import com.blued.android.module.live.base.manager.YYMusicManager;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.live.base.view.animation.LiveAnimationListener;
import com.blued.android.module.svgaplayer.SVGACallback;
import com.blued.android.module.svgaplayer.SVGADrawable;
import com.blued.android.module.svgaplayer.SVGADynamicEntity;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.adapter.YYSeatSoloAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.PlayingStudioFragment;
import com.blued.android.module.yy_china.fragment.YYJumpLoadingFragment;
import com.blued.android.module.yy_china.fragment.YYMagicalPrizeFragment;
import com.blued.android.module.yy_china.fragment.YYPKMatchingFragment;
import com.blued.android.module.yy_china.fragment.YYPackGiftDialog;
import com.blued.android.module.yy_china.fragment.YYWebViewDialogFragment;
import com.blued.android.module.yy_china.fragment.YYWishDetailDialog;
import com.blued.android.module.yy_china.manager.YYGiftManager;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.manager.YYVipNotifyManager;
import com.blued.android.module.yy_china.model.ConfessedIMMode;
import com.blued.android.module.yy_china.model.DoublePeopleNoticeImNode;
import com.blued.android.module.yy_china.model.EventRoomPkSvgaExtra;
import com.blued.android.module.yy_china.model.IMJsonContents108Model;
import com.blued.android.module.yy_china.model.IMJsonContents109Model;
import com.blued.android.module.yy_china.model.IMJsonContents95Model;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYBannerRankModel;
import com.blued.android.module.yy_china.model.YYClickApplyEvent;
import com.blued.android.module.yy_china.model.YYEnergyBallMsgModel;
import com.blued.android.module.yy_china.model.YYEventMatching;
import com.blued.android.module.yy_china.model.YYFirstMeetExtra;
import com.blued.android.module.yy_china.model.YYFirstMeetGiftsListItemMode;
import com.blued.android.module.yy_china.model.YYFirstMeetImMessMode;
import com.blued.android.module.yy_china.model.YYFirstMeetMessMode;
import com.blued.android.module.yy_china.model.YYFirstMeetMode;
import com.blued.android.module.yy_china.model.YYGiftEven;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYGlobalMsgMarqueeModel;
import com.blued.android.module.yy_china.model.YYGlobalMsgModel;
import com.blued.android.module.yy_china.model.YYHostUpMode;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYJumpRoomMode;
import com.blued.android.module.yy_china.model.YYMagicalPrizeModel;
import com.blued.android.module.yy_china.model.YYMountModel;
import com.blued.android.module.yy_china.model.YYMsgEmojiExtra;
import com.blued.android.module.yy_china.model.YYMsgGiftExtra;
import com.blued.android.module.yy_china.model.YYMsgMarqueeExtra;
import com.blued.android.module.yy_china.model.YYMsgMarqueeModel;
import com.blued.android.module.yy_china.model.YYMsgMuteExtra;
import com.blued.android.module.yy_china.model.YYMsgUpdateUserList;
import com.blued.android.module.yy_china.model.YYMsgVipMatchExtra;
import com.blued.android.module.yy_china.model.YYMsgWarningExtra;
import com.blued.android.module.yy_china.model.YYMsgWishListModel;
import com.blued.android.module.yy_china.model.YYMusicMode;
import com.blued.android.module.yy_china.model.YYPackGiftIMMode;
import com.blued.android.module.yy_china.model.YYPayGoodsModel;
import com.blued.android.module.yy_china.model.YYPayRequestModel;
import com.blued.android.module.yy_china.model.YYPreciousPackageModel;
import com.blued.android.module.yy_china.model.YYRelationShipRoomImMode;
import com.blued.android.module.yy_china.model.YYReportModel;
import com.blued.android.module.yy_china.model.YYRoomBasicInfoMode;
import com.blued.android.module.yy_china.model.YYRoomBasicMode;
import com.blued.android.module.yy_china.model.YYRoomBasicPropMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYUpMode;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.model.trtc.TRTCSendLeaveMsg;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.trtc_audio.model.YYAudioConfig;
import com.blued.android.module.yy_china.trtc_audio.permission.PermissionHelper;
import com.blued.android.module.yy_china.utils.YYCommonStringUtils;
import com.blued.android.module.yy_china.utils.YYPayUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.YYRoomPreferences;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.FloatComingEventsView;
import com.blued.android.module.yy_china.view.PopYyDialog;
import com.blued.android.module.yy_china.view.PopYyDialogGetView;
import com.blued.android.module.yy_china.view.YYConfessedListDialog;
import com.blued.android.module.yy_china.view.YYFirstMeetResultDialog;
import com.blued.android.module.yy_china.view.YYGiftPKResult;
import com.blued.android.module.yy_china.view.YYGiftPkDetailView;
import com.blued.android.module.yy_china.view.YYGiftWallListAndInfoDialog;
import com.blued.android.module.yy_china.view.YYPrizeDialog;
import com.blued.android.module.yy_china.view.YYRelationShipInvitedDialog;
import com.blued.android.module.yy_china.view.YYReportView;
import com.blued.android.module.yy_china.view.YYRoomFullSvgaMode;
import com.blued.android.module.yy_china.view.YYSayHelloView;
import com.blued.android.module.yy_china.view.YYUserVoteView;
import com.blued.android.module.yy_china.view.YYVoteResultView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/AbstractBasePresenter.class */
public abstract class AbstractBasePresenter {

    /* renamed from: a  reason: collision with root package name */
    public BaseYYStudioFragment f17634a;
    public YYPreciousPackageModel b;

    /* renamed from: c  reason: collision with root package name */
    private CountDownTimer f17635c;
    private FloatComingEventsView d;

    /* renamed from: com.blued.android.module.yy_china.presenter.AbstractBasePresenter$79  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/AbstractBasePresenter$79.class */
    static /* synthetic */ class AnonymousClass79 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17720a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[YYConstants.ApplyFromSource.values().length];
            f17720a = iArr;
            try {
                iArr[YYConstants.ApplyFromSource.SaleVip.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17720a[YYConstants.ApplyFromSource.CoupleVip.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17720a[YYConstants.ApplyFromSource.SeatView.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public AbstractBasePresenter(BaseYYStudioFragment baseYYStudioFragment) {
        this.f17634a = baseYYStudioFragment;
        YYVipNotifyManager.f17597a.a().a(baseYYStudioFragment.R, baseYYStudioFragment.getFragmentActive(), DensityUtils.a(baseYYStudioFragment.getActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SVGACallback a(final View view) {
        return new SVGACallback() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.61
            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onFinished() {
                view.setOnClickListener(null);
                view.setVisibility(8);
            }

            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onPause() {
            }

            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onRepeat() {
            }

            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onStep(int i, double d) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = str;
        if (str.length() > 3) {
            str2 = str.substring(0, 3) + "...";
        }
        return str2;
    }

    private void a(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f17634a.aa.getLayoutParams();
        if (i <= 0) {
            layoutParams.width = AppInfo.l;
        } else {
            layoutParams.width = DensityUtils.a(this.f17634a.getContext(), i);
        }
        if (i2 <= 0) {
            layoutParams.height = AppInfo.m;
        } else {
            layoutParams.height = DensityUtils.a(this.f17634a.getContext(), i2);
        }
        this.f17634a.aa.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || StringUtils.a(b.uid, YYRoomInfoManager.e().k())) {
            return;
        }
        LiveEventBus.get("show_frist_meet").postDelay(new YYFirstMeetMessMode(0, null), 1000 * j);
        YYRoomHttpUtils.y(b.uid, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<YYFirstMeetMode, YYFirstMeetExtra>>(this.f17634a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.69
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYFirstMeetMode, YYFirstMeetExtra> bluedEntity) {
                if (bluedEntity.hasData()) {
                    YYFirstMeetMode singleData = bluedEntity.getSingleData();
                    if (singleData.is_show_meet() != 1 || bluedEntity.extra.getAnchor_info() == null) {
                        return;
                    }
                    singleData.setInfo(bluedEntity.extra.getAnchor_info());
                    LiveEventBus.get("show_frist_meet").postDelay(new YYFirstMeetMessMode(0, singleData), j * 1000);
                }
            }
        }, this.f17634a.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EventRoomPkSvgaExtra eventRoomPkSvgaExtra) {
        a(DensityUtils.a(this.f17634a.getContext(), eventRoomPkSvgaExtra.frameWidth), DensityUtils.a(this.f17634a.getContext(), eventRoomPkSvgaExtra.frameHeight));
        SVGAParser b = SVGAParser.f15958a.b();
        if (TextUtils.isEmpty(eventRoomPkSvgaExtra.svgaName)) {
            b.a(eventRoomPkSvgaExtra.svgaName, g(), (SVGAParser.PlayCallback) null);
            return;
        }
        try {
            b.a(new URL(eventRoomPkSvgaExtra.svgaName), g(), (SVGAParser.PlayCallback) null);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final YYFirstMeetImMessMode yYFirstMeetImMessMode) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (this.f17634a == null || b == null) {
            return;
        }
        YYRoomHttpUtils.k(b.room_id, b.uid, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<YYFirstMeetGiftsListItemMode, YYFirstMeetExtra>>(this.f17634a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.56
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYFirstMeetGiftsListItemMode, YYFirstMeetExtra> bluedEntity) {
                YYFirstMeetResultDialog yYFirstMeetResultDialog = new YYFirstMeetResultDialog();
                yYFirstMeetResultDialog.a(bluedEntity.data);
                yYFirstMeetResultDialog.a(bluedEntity.extra.getAnchor_info());
                yYFirstMeetResultDialog.a(yYFirstMeetImMessMode);
                yYFirstMeetResultDialog.a(AbstractBasePresenter.this.f17634a);
                yYFirstMeetResultDialog.show(AbstractBasePresenter.this.f17634a.getFragmentManager(), "YYFirstMeetResultDialog");
            }
        }, this.f17634a.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YYMagicalPrizeModel yYMagicalPrizeModel) {
        if (yYMagicalPrizeModel == null) {
            return;
        }
        new YYMagicalPrizeFragment(yYMagicalPrizeModel).show(this.f17634a.getParentFragmentManager(), "magical_prize");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final YYPayRequestModel yYPayRequestModel) {
        YYConstants.PayFromSource payFromSource = YYConstants.PayFromSource.Pay_Gift;
        BaseYYStudioFragment baseYYStudioFragment = this.f17634a;
        YYPayUtils.a(yYPayRequestModel, payFromSource, baseYYStudioFragment, baseYYStudioFragment.getFragmentActive(), new YYPayUtils.PayGiftStatusListener() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.72
            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(int i, String str) {
            }

            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(YYPayGoodsModel yYPayGoodsModel) {
                YYGiftModel yYGiftModel;
                YYSeatMemberModel yYSeatMemberModel;
                try {
                    yYGiftModel = yYPayRequestModel.gift;
                } catch (Exception e) {
                    LogUtils.a("赠送礼物 转换失败");
                    yYGiftModel = null;
                }
                if (yYGiftModel == null || (yYSeatMemberModel = YYRoomInfoManager.e().o().get(yYPayRequestModel.target_uid)) == null) {
                    return;
                }
                if (TextUtils.isEmpty(yYGiftModel.contents)) {
                    if (yYPayRequestModel.giftCount > 1) {
                        yYGiftModel.hit_batch = 1;
                        yYGiftModel.hit_count = yYPayRequestModel.giftCount;
                    } else {
                        yYGiftModel.hit_batch = 0;
                    }
                    yYPayRequestModel.hit_id = yYGiftModel.hit_id;
                    YYImMsgManager.a().a(yYGiftModel, yYSeatMemberModel, yYPayGoodsModel, false);
                } else {
                    LogUtils.a("弹幕消息，不模拟发消息");
                }
                if (TextUtils.equals(yYSeatMemberModel.getUid(), yYPayRequestModel.target_uid) && YYRoomInfoManager.e().f17578a != null) {
                    YYRoomInfoManager.e().f17578a.isSendGift = true;
                }
                if (yYGiftModel.yy_password_success_event == null || "YY_SU_DEFAULT".equals(yYGiftModel.yy_password_success_event)) {
                    return;
                }
                LiveEventBus.get("YYSuccessPasswordEvent").post(yYGiftModel.yy_password_success_event);
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YYRoomModel yYRoomModel) {
        if (yYRoomModel != null && !TextUtils.isEmpty(yYRoomModel.room_desc)) {
            YYImModel yYImModel = new YYImModel();
            yYImModel.type = 26;
            yYImModel.contents = yYRoomModel.room_desc;
            YYImMsgManager.a().t(yYImModel);
        }
        YYImMsgManager.a().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final YYRoomModel yYRoomModel, final List<YYImModel> list, final int i, final int i2) {
        BaseYYStudioFragment baseYYStudioFragment = this.f17634a;
        if (baseYYStudioFragment == null) {
            return;
        }
        baseYYStudioFragment.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.71
            @Override // java.lang.Runnable
            public void run() {
                if (yYRoomModel == null || AbstractBasePresenter.this.f17634a == null) {
                    return;
                }
                int i3 = i;
                if (i3 < 0 || i3 >= i2) {
                    YYImMsgManager.a().a(AppInfo.d().getString(R.string.yy_room_regulation_title), AppInfo.d().getString(R.string.yy_room_regulation_content));
                    if (YYRoomInfoManager.e().y()) {
                        return;
                    }
                    AbstractBasePresenter.this.a(yYRoomModel);
                    return;
                }
                YYImModel yYImModel = (YYImModel) list.get(i3);
                if (yYImModel == null || yYImModel.source_profile == null) {
                    AbstractBasePresenter.this.a(yYRoomModel, list, i + 1, i2);
                    return;
                }
                yYImModel.source_profile.chat_anchor = yYImModel.source_profile.role;
                yYRoomModel.addImDatas(i, yYImModel);
                AbstractBasePresenter.this.a(yYRoomModel, list, i + 1, i2);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YYUserInfo yYUserInfo) {
        YYGiftWallListAndInfoDialog yYGiftWallListAndInfoDialog = new YYGiftWallListAndInfoDialog();
        yYGiftWallListAndInfoDialog.a(yYUserInfo);
        yYGiftWallListAndInfoDialog.show(this.f17634a.getChildFragmentManager(), "YYGiftWallListAndInfoDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, YYImModel yYImModel) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        List<YYSeatMemberModel> list = b.mics;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel = list.get(i2);
            if (TextUtils.equals(yYSeatMemberModel.getUid(), str)) {
                yYSeatMemberModel.apngUrl = str2;
                yYSeatMemberModel.emojiModel = yYImModel;
                BaseYYStudioFragment baseYYStudioFragment = this.f17634a;
                if (baseYYStudioFragment != null && baseYYStudioFragment.E != null) {
                    this.f17634a.E.a(i2, str, str2, yYImModel);
                }
                BaseYYStudioFragment baseYYStudioFragment2 = this.f17634a;
                if (baseYYStudioFragment2 == null || baseYYStudioFragment2.D == null || this.f17634a.D.getVisibility() != 0) {
                    return;
                }
                this.f17634a.D.a(i2, str, str2, yYImModel);
                return;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        long j2 = j;
        if (j < 1000) {
            j2 = j * 1000;
        }
        LiveEventBus.get("grab_prize_prepare").post(Long.valueOf(j2));
        this.f17635c = new CountDownTimer(j2 + 1000, 1000L) { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.73
            @Override // android.os.CountDownTimer
            public void onFinish() {
                LiveEventBus.get("grab_prize_end").post("");
                AbstractBasePresenter.this.k();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                LiveEventBus.get("grab_prize_start").post(Long.valueOf(j3));
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final EventRoomPkSvgaExtra eventRoomPkSvgaExtra) {
        a(DensityUtils.a(this.f17634a.getContext(), eventRoomPkSvgaExtra.frameWidth), DensityUtils.a(this.f17634a.getContext(), eventRoomPkSvgaExtra.frameHeight));
        SVGAParser.f15958a.b().a(eventRoomPkSvgaExtra.svgaName, new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.59
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity sVGAVideoEntity) {
                SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                if (eventRoomPkSvgaExtra.users != null) {
                    TextPaint textPaint = new TextPaint();
                    textPaint.setColor(-1);
                    textPaint.setTextSize(28.0f);
                    StringBuilder sb = new StringBuilder("恭喜 ");
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= eventRoomPkSvgaExtra.users.size()) {
                            break;
                        }
                        YYAudienceModel yYAudienceModel = eventRoomPkSvgaExtra.users.get(i2);
                        sb.append(AbstractBasePresenter.this.a(yYAudienceModel.getName()));
                        sb.append("、");
                        if (!TextUtils.isEmpty(yYAudienceModel.getAvatar())) {
                            if (i2 == 0) {
                                sVGADynamicEntity.a(yYAudienceModel.getAvatar(), "user_1");
                            } else if (i2 == 1) {
                                sVGADynamicEntity.a(yYAudienceModel.getAvatar(), "user_2");
                            }
                        }
                        if (i2 >= 1) {
                            break;
                        }
                        i = i2 + 1;
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sVGADynamicEntity.a(sb.toString(), textPaint, "text_1");
                    sVGADynamicEntity.a("获得全场MVP", textPaint, "text_2");
                }
                AbstractBasePresenter.this.f17634a.aa.setImageDrawable(new SVGADrawable(sVGAVideoEntity, sVGADynamicEntity));
                AbstractBasePresenter.this.f17634a.aa.a();
                SVGAImageView sVGAImageView = AbstractBasePresenter.this.f17634a.aa;
                AbstractBasePresenter abstractBasePresenter = AbstractBasePresenter.this;
                sVGAImageView.setCallback(abstractBasePresenter.a(abstractBasePresenter.f17634a.aa));
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final YYFirstMeetImMessMode yYFirstMeetImMessMode) {
        ImageLoader.a(this.f17634a.getFragmentActive(), yYFirstMeetImMessMode.getSource_avatar()).c().a(new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.57
            @Override // com.bumptech.glide.request.target.Target
            /* renamed from: a */
            public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                final Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                ImageLoader.a(AbstractBasePresenter.this.f17634a.getFragmentActive(), yYFirstMeetImMessMode.getTarget_avatar()).c().a(new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.57.1
                    @Override // com.bumptech.glide.request.target.Target
                    /* renamed from: a */
                    public void onResourceReady(Drawable drawable2, Transition<? super Drawable> transition2) {
                        Bitmap bitmap2 = ((BitmapDrawable) drawable2).getBitmap();
                        SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                        sVGADynamicEntity.a(bitmap, "headleft");
                        sVGADynamicEntity.a(bitmap2, "headrightt");
                        TextPaint textPaint = new TextPaint();
                        textPaint.setColor(ContextCompat.getColor(AppInfo.d(), R.color.white));
                        textPaint.setTextSize(21.0f);
                        sVGADynamicEntity.a("恭喜" + YYCommonStringUtils.a(yYFirstMeetImMessMode.getSource_name(), textPaint, AppInfo.d().getResources().getDimensionPixelSize(R.dimen.dp_80)) + "和房主完成第一次遇见", textPaint, Layout.Alignment.ALIGN_CENTER, "mainword");
                        TextPaint textPaint2 = new TextPaint();
                        textPaint2.setColor(ContextCompat.getColor(AppInfo.d(), R.color.white));
                        textPaint2.setTextSize(18.0f);
                        sVGADynamicEntity.a("免费获得1弯豆礼物券等丰厚大礼~", textPaint2, Layout.Alignment.ALIGN_CENTER, "secondword");
                        AbstractBasePresenter.this.f17634a.a(new YYRoomFullSvgaMode("https://web.bldimg.com/cblued/static/headrightt2.1guuig3laoq12d.svga", sVGADynamicEntity, 1));
                        AbstractBasePresenter.this.f17634a.a(new YYRoomFullSvgaMode("https://web.bldimg.com/cblued/static/headrightt2.1guuig3laoq12d.svga", sVGADynamicEntity, 1));
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (StringUtils.b(str)) {
            return;
        }
        new YYWebViewDialogFragment().a(this.f17634a, str).show(this.f17634a.getChildFragmentManager(), "yy_game_dialog");
        this.f17634a.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final EventRoomPkSvgaExtra eventRoomPkSvgaExtra) {
        a(DensityUtils.a(this.f17634a.getContext(), eventRoomPkSvgaExtra.frameWidth), DensityUtils.a(this.f17634a.getContext(), eventRoomPkSvgaExtra.frameHeight));
        SVGAParser.f15958a.b().a(eventRoomPkSvgaExtra.svgaName, new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.60
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity sVGAVideoEntity) {
                SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                if (eventRoomPkSvgaExtra.users != null && !eventRoomPkSvgaExtra.users.isEmpty()) {
                    YYAudienceModel yYAudienceModel = eventRoomPkSvgaExtra.users.get(0);
                    TextPaint textPaint = new TextPaint();
                    textPaint.setColor(-1);
                    textPaint.setTextSize(24.0f);
                    sVGADynamicEntity.a(AbstractBasePresenter.this.a(yYAudienceModel.getName()), textPaint, "text_1");
                    if (!TextUtils.isEmpty(yYAudienceModel.getAvatar())) {
                        sVGADynamicEntity.a(yYAudienceModel.getAvatar(), "user_1");
                    }
                }
                AbstractBasePresenter.this.f17634a.aa.setImageDrawable(new SVGADrawable(sVGAVideoEntity, sVGADynamicEntity));
                AbstractBasePresenter.this.f17634a.aa.a();
                SVGAImageView sVGAImageView = AbstractBasePresenter.this.f17634a.aa;
                AbstractBasePresenter abstractBasePresenter = AbstractBasePresenter.this;
                sVGAImageView.setCallback(abstractBasePresenter.a(abstractBasePresenter.f17634a.aa));
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        BaseYYStudioFragment baseYYStudioFragment = this.f17634a;
        if (baseYYStudioFragment == null) {
            return;
        }
        View inflate = LayoutInflater.from(baseYYStudioFragment.getContext()).inflate(R.layout.dialog_alert_message_layout, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tv_alert_msg)).setText(str);
        LiveAlterDialog.a(this.f17634a.getContext(), inflate, (View.OnClickListener) null, (View.OnClickListener) null, false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (YYRoomInfoManager.e().b() == null) {
            return;
        }
        YYRoomHttpUtils.y(YYRoomInfoManager.e().b().uid, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<YYFirstMeetMode, YYFirstMeetExtra>>(this.f17634a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.55
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYFirstMeetMode, YYFirstMeetExtra> bluedEntity) {
                if (bluedEntity.hasData()) {
                    YYFirstMeetMode singleData = bluedEntity.getSingleData();
                    if (singleData.is_show_meet() != 1 || bluedEntity.extra.getAnchor_info() == null) {
                        return;
                    }
                    SharedPreferences b = SharedPreferencesUtils.b();
                    long j = b.getLong("YY_FIRST_MEET_SHOW_MEET_TIME" + YYRoomInfoManager.e().k(), 0L);
                    long c2 = AbstractBasePresenter.this.c();
                    int i = 0;
                    if (j == c2) {
                        SharedPreferences b2 = SharedPreferencesUtils.b();
                        int i2 = b2.getInt("YY_FIRST_MEET_SHOW_MEET_TIME_NUM" + YYRoomInfoManager.e().k(), 0);
                        i = i2;
                        if (i2 >= 2) {
                            return;
                        }
                    }
                    singleData.setInfo(bluedEntity.extra.getAnchor_info());
                    AbstractBasePresenter.this.f17634a.a(singleData);
                    SharedPreferences.Editor edit = SharedPreferencesUtils.b().edit();
                    edit.putLong("YY_FIRST_MEET_SHOW_MEET_TIME" + YYRoomInfoManager.e().k(), c2).apply();
                    SharedPreferences.Editor edit2 = SharedPreferencesUtils.b().edit();
                    edit2.putInt("YY_FIRST_MEET_SHOW_MEET_TIME_NUM" + YYRoomInfoManager.e().k(), i + 1).apply();
                }
            }
        }, this.f17634a.getFragmentActive());
    }

    private SVGAParser.ParseCompletion g() {
        return new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.58
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity sVGAVideoEntity) {
                AbstractBasePresenter.this.f17634a.aa.setImageDrawable(new SVGADrawable(sVGAVideoEntity, new SVGADynamicEntity()));
                AbstractBasePresenter.this.f17634a.aa.a();
                SVGAImageView sVGAImageView = AbstractBasePresenter.this.f17634a.aa;
                AbstractBasePresenter abstractBasePresenter = AbstractBasePresenter.this;
                sVGAImageView.setCallback(abstractBasePresenter.a(abstractBasePresenter.f17634a.aa));
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f17634a.P == null || this.f17634a.Q == null) {
            return;
        }
        this.f17634a.Q.setText(String.format(this.f17634a.getResources().getString(R.string.yy_magical_notice_text), this.b.count_down));
        this.f17634a.P.startAnimation(AnimationUtils.loadAnimation(this.f17634a.getContext(), R.anim.activity_in_from_left));
        this.f17634a.P.setVisibility(0);
        this.f17634a.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.62
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractBasePresenter.this.f17634a == null || AbstractBasePresenter.this.f17634a.P == null) {
                    return;
                }
                AbstractBasePresenter.this.f17634a.P.startAnimation(AnimationUtils.loadAnimation(AbstractBasePresenter.this.f17634a.getContext(), R.anim.activity_out_to_right));
                AbstractBasePresenter.this.f17634a.P.setVisibility(8);
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f17634a == null) {
            return;
        }
        YYVoteResultView yYVoteResultView = new YYVoteResultView(this.f17634a.getContext());
        yYVoteResultView.a(this.f17634a);
        this.f17634a.a(yYVoteResultView, -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        YYSayHelloView yYSayHelloView = new YYSayHelloView(this.f17634a.getContext());
        yYSayHelloView.a(this.f17634a);
        this.f17634a.a((View) yYSayHelloView, -2, 17, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        BaseYYStudioFragment baseYYStudioFragment = this.f17634a;
        if (baseYYStudioFragment == null || baseYYStudioFragment.J == null || this.b == null) {
            return;
        }
        if (YYRoomInfoManager.e().b() != null && YYRoomInfoManager.e().y()) {
            EventTrackYY.e(ChatRoomProtos.Event.CHAT_ROOM_BOX_RAIN_FALL, YYRoomInfoManager.e().b().room_id);
        }
        this.f17634a.J.a(new YYMountModel("", this.b.animation, "", 0, null, null), true);
        this.f17634a.J.a(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.74
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                AbstractBasePresenter.this.l();
            }
        }));
        YYPreciousPackageModel yYPreciousPackageModel = this.b;
        if (yYPreciousPackageModel == null || StringUtils.a(yYPreciousPackageModel.trigger_vanish_time, 0L) <= 0) {
            return;
        }
        this.f17634a.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.75
            @Override // java.lang.Runnable
            public void run() {
                AbstractBasePresenter.this.f17634a.J.h();
                AbstractBasePresenter.this.a();
            }
        }, StringUtils.a(this.b.trigger_vanish_time, 0L) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (YYRoomInfoManager.e().b() == null) {
            return;
        }
        YYRoomHttpUtils.t(YYRoomInfoManager.e().b().room_id, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYMagicalPrizeModel>>(this.f17634a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.76
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYMagicalPrizeModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                AbstractBasePresenter.this.a(bluedEntityA.getSingleData());
            }
        }, this.f17634a.getFragmentActive());
    }

    public void a() {
        if (this.f17634a == null) {
            return;
        }
        YYRoomHttpUtils.s(YYRoomInfoManager.e().b().room_id, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYPreciousPackageModel>>(this.f17634a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.63
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYPreciousPackageModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                AbstractBasePresenter.this.b = bluedEntityA.getSingleData();
                if (AbstractBasePresenter.this.b == null || StringUtils.a(AbstractBasePresenter.this.b.is_show, 2) != 1) {
                    AbstractBasePresenter.this.f17634a.O.setVisibility(8);
                    return;
                }
                AbstractBasePresenter.this.f17634a.O.setVisibility(0);
                AbstractBasePresenter.this.f17634a.O.a(AbstractBasePresenter.this.b.icon_middle);
                int a2 = StringUtils.a(AbstractBasePresenter.this.b.count_down, 0);
                if (a2 <= 1) {
                    AbstractBasePresenter.this.f17634a.O.a();
                } else {
                    if (TextUtils.isEmpty(AbstractBasePresenter.this.b.animation)) {
                        AbstractBasePresenter.this.b.animation = "https://web.bldimg.com/cblued/static/box1.1ge496l66182qme.mp4";
                    }
                    YYGiftManager.a().a(AbstractBasePresenter.this.b.animation);
                    AbstractBasePresenter.this.b(a2);
                    AbstractBasePresenter.this.h();
                }
                LiveEventBus.get("reset_magical_info").post(AbstractBasePresenter.this.b);
            }
        }, this.f17634a.getFragmentActive());
    }

    public void a(int i, String str) {
        YYMusicMode yYMusicMode = new YYMusicMode();
        yYMusicMode.state = i;
        yYMusicMode.music_cover = str;
        if (YYRoomInfoManager.e().b() == null || this.f17634a == null) {
            return;
        }
        YYRoomHttpUtils.a(YYRoomInfoManager.e().b().room_id, AppInfo.f().toJson(yYMusicMode), new BluedUIHttpResponse() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.77
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, (IRequestHost) this.f17634a.getFragmentActive());
    }

    public void a(LifecycleOwner lifecycleOwner) {
        LiveEventBus.get("common_apply_seat", YYClickApplyEvent.class).observe(lifecycleOwner, new Observer<YYClickApplyEvent>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYClickApplyEvent yYClickApplyEvent) {
                if (yYClickApplyEvent == null) {
                    return;
                }
                LiveLogUtils.a("AbstractBasePresenter --> EVENT_COMMON_APPLY_SEAT --> 申请麦克风权限 --> applyModel：" + yYClickApplyEvent.getSeatNumber());
                AbstractBasePresenter.this.a(yYClickApplyEvent);
            }
        });
        LiveEventBus.get("display_emoji_image", YYImModel.class).observe(lifecycleOwner, new Observer<YYImModel>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYImModel yYImModel) {
                YYMsgEmojiExtra yYMsgEmojiExtra;
                YYAudienceModel yYAudienceModel = yYImModel.source_profile;
                if (yYAudienceModel == null || (yYMsgEmojiExtra = (YYMsgEmojiExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), (Class<Object>) YYMsgEmojiExtra.class)) == null) {
                    return;
                }
                AbstractBasePresenter.this.a(yYAudienceModel.getUid(), yYMsgEmojiExtra.apng, yYImModel);
            }
        });
        LiveEventBus.get("show_frist_meet", YYFirstMeetMessMode.class).observe(lifecycleOwner, new Observer<YYFirstMeetMessMode>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.3
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYFirstMeetMessMode yYFirstMeetMessMode) {
                if (yYFirstMeetMessMode.getType() == 0) {
                    AbstractBasePresenter.this.f();
                } else if (yYFirstMeetMessMode.getType() == 1) {
                    AbstractBasePresenter.this.f17634a.S();
                } else {
                    yYFirstMeetMessMode.getType();
                }
            }
        });
        LiveEventBus.get("show_frist_meetim", YYFirstMeetImMessMode.class).observe(lifecycleOwner, new Observer<YYFirstMeetImMessMode>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.4
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYFirstMeetImMessMode yYFirstMeetImMessMode) {
                if (StringUtils.a(YYRoomInfoManager.e().k(), yYFirstMeetImMessMode.getSource_uid())) {
                    AbstractBasePresenter.this.a(yYFirstMeetImMessMode);
                } else {
                    AbstractBasePresenter.this.b(yYFirstMeetImMessMode);
                }
            }
        });
        LiveEventBus.get("relation_invited", YYRelationShipRoomImMode.class).observe(lifecycleOwner, new Observer<YYRelationShipRoomImMode>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.5
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYRelationShipRoomImMode yYRelationShipRoomImMode) {
                YYRelationShipInvitedDialog yYRelationShipInvitedDialog = new YYRelationShipInvitedDialog();
                yYRelationShipInvitedDialog.a(yYRelationShipRoomImMode);
                yYRelationShipInvitedDialog.show(AbstractBasePresenter.this.f17634a.getChildFragmentManager(), "YYRelationShipInvitedDialog");
            }
        });
        LiveEventBus.get("set_manager_msg", YYAudienceModel.class).observe(lifecycleOwner, new Observer<YYAudienceModel>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.6
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYAudienceModel yYAudienceModel) {
                if (AbstractBasePresenter.this.f17634a == null || AbstractBasePresenter.this.f17634a.E == null) {
                    return;
                }
                AbstractBasePresenter.this.f17634a.E.a(yYAudienceModel.getUid(), yYAudienceModel.chat_anchor);
                YYUserInfo yYUserInfo = YYRoomInfoManager.e().f17578a;
                if (yYUserInfo == null) {
                    return;
                }
                if (TextUtils.equals(yYAudienceModel.getUid(), yYUserInfo.getUid())) {
                    yYUserInfo.chat_anchor = yYAudienceModel.chat_anchor;
                    LiveEventBus.get("update_anchor_UI").post("");
                }
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null && TextUtils.equals(b.uid, yYUserInfo.getUid()) && TextUtils.equals("2", yYAudienceModel.chat_anchor)) {
                    ToastUtils.a("设置成功", 0);
                }
            }
        });
        LiveEventBus.get("show_gift_list", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.7
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (AbstractBasePresenter.this.f17634a == null) {
                    return;
                }
                AbstractBasePresenter.this.f17634a.a(true, "", "");
            }
        });
        LiveEventBus.get("show_gift_view", YYGiftEven.class).observe(lifecycleOwner, new Observer<YYGiftEven>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.8
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYGiftEven yYGiftEven) {
                if (AbstractBasePresenter.this.f17634a == null) {
                    return;
                }
                AbstractBasePresenter.this.f17634a.a(true, yYGiftEven.f17616a, yYGiftEven.b, yYGiftEven.f17617c);
            }
        });
        LiveEventBus.get("notify_alert_message", YYImModel.class).observe(lifecycleOwner, new Observer<YYImModel>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.9
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYImModel yYImModel) {
                if (yYImModel == null || TextUtils.isEmpty(yYImModel.contents)) {
                    return;
                }
                LiveLogUtils.a("AbstractBasePresenter --> EVENT_NOTIFY_ALERT_MESSAGE --> 收到房间警告消息：" + yYImModel.contents);
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null && yYImModel.target_profile != null) {
                    EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_WARN_POP_SHOW, b.room_id, b.uid, yYImModel.target_profile.getUid(), yYImModel.contents, ((YYMsgWarningExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), (Class<Object>) YYMsgWarningExtra.class)).warning_type);
                }
                AbstractBasePresenter.this.c(yYImModel.contents);
            }
        });
        LiveEventBus.get("notify_follow_user", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.10
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                YYRoomModel b;
                Logger.e("AbstractBasePresenter", "发送关注通知 UID= " + str);
                if (AbstractBasePresenter.this.f17634a == null || (b = YYRoomInfoManager.e().b()) == null) {
                    return;
                }
                if (TextUtils.equals(str, b.uid)) {
                    ToastUtils.a("你已关注房主", 0);
                }
                YYRoomHttpUtils.f(b.room_id, str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(AbstractBasePresenter.this.f17634a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.10.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                    }
                }, (IRequestHost) AbstractBasePresenter.this.f17634a.getFragmentActive());
            }
        });
        LiveEventBus.get("show_wish_detail", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.11
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (AbstractBasePresenter.this.f17634a == null) {
                    return;
                }
                new YYWishDetailDialog(AbstractBasePresenter.this.f17634a).show(AbstractBasePresenter.this.f17634a.getParentFragmentManager(), "show_wish_detail_dialog");
            }
        });
        LiveEventBus.get("show_vote_details", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.12
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (AbstractBasePresenter.this.f17634a == null) {
                    return;
                }
                YYUserVoteView yYUserVoteView = new YYUserVoteView(AbstractBasePresenter.this.f17634a.getContext());
                yYUserVoteView.a(AbstractBasePresenter.this.f17634a, str);
                AbstractBasePresenter.this.f17634a.a(yYUserVoteView, -2);
            }
        });
        LiveEventBus.get("show_vote_result", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.13
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (AbstractBasePresenter.this.f17634a != null && TextUtils.isEmpty(str)) {
                    AbstractBasePresenter.this.f17634a.y();
                    AbstractBasePresenter.this.i();
                }
            }
        });
        LiveEventBus.get("event_solo_topic", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.14
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (AbstractBasePresenter.this.f17634a == null || AbstractBasePresenter.this.f17634a.E == null || (AbstractBasePresenter.this.f17634a.E instanceof YYSeatSoloAdapter)) {
                    ((YYSeatSoloAdapter) AbstractBasePresenter.this.f17634a.E).a(str);
                } else if (AbstractBasePresenter.this.f17634a != null) {
                    AbstractBasePresenter.this.f17634a.j();
                }
            }
        });
        LiveEventBus.get("show_gift_pk_details", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.15
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (AbstractBasePresenter.this.f17634a == null) {
                    return;
                }
                YYGiftPkDetailView yYGiftPkDetailView = new YYGiftPkDetailView(AbstractBasePresenter.this.f17634a.getContext());
                yYGiftPkDetailView.a(AbstractBasePresenter.this.f17634a);
                AbstractBasePresenter.this.f17634a.a(yYGiftPkDetailView, -2);
            }
        });
        LiveEventBus.get("show_gift_pk_result", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.16
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (AbstractBasePresenter.this.f17634a == null) {
                    return;
                }
                YYRoomInfoManager.e().s();
                YYGiftPKResult yYGiftPKResult = new YYGiftPKResult(AbstractBasePresenter.this.f17634a.getContext());
                yYGiftPKResult.a(AbstractBasePresenter.this.f17634a);
                AbstractBasePresenter.this.f17634a.a((View) yYGiftPKResult, DensityUtils.a(AbstractBasePresenter.this.f17634a.getContext(), 300.0f), -2, 17, true);
            }
        });
        LiveEventBus.get("frist_rechage", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.17
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (AbstractBasePresenter.this.f17634a == null) {
                    return;
                }
                AbstractBasePresenter.this.f17634a.c(str);
            }
        });
        LiveEventBus.get("EVENT_MARQUEE_GIFT", YYImModel.class).observe(lifecycleOwner, new Observer<YYImModel>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.18
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYImModel yYImModel) {
                YYAudienceModel yYAudienceModel;
                YYMsgMarqueeExtra yYMsgMarqueeExtra;
                YYAudienceModel yYAudienceModel2 = yYImModel.target_profile;
                if (yYAudienceModel2 == null || (yYAudienceModel = yYImModel.source_profile) == null || (yYMsgMarqueeExtra = (YYMsgMarqueeExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), (Class<Object>) YYMsgMarqueeExtra.class)) == null || AbstractBasePresenter.this.f17634a.t == null) {
                    return;
                }
                AbstractBasePresenter.this.f17634a.t.a(AbstractBasePresenter.this.f17634a.t.a(yYMsgMarqueeExtra.send_time, yYAudienceModel.getName(), yYAudienceModel2.getName(), yYMsgMarqueeExtra.goods_count, yYMsgMarqueeExtra.goods_name), yYMsgMarqueeExtra.goods_image);
            }
        });
        LiveEventBus.get("add_new_user", YYImModel.class).observe(lifecycleOwner, new Observer<YYImModel>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.19
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYImModel yYImModel) {
                String str;
                if (AbstractBasePresenter.this.f17634a == null || AbstractBasePresenter.this.f17634a.v == null || yYImModel == null || yYImModel.source_profile == null) {
                    return;
                }
                if (AbstractBasePresenter.this.f17634a.v != null && !StringUtils.b(yYImModel.source_profile.enter_effects)) {
                    AbstractBasePresenter.this.f17634a.v.a(yYImModel);
                }
                if (StringUtils.b(yYImModel.source_profile.mounts_img)) {
                    return;
                }
                String name = yYImModel.source_profile.getName();
                if (!YYRoomInfoManager.e().J() || YYRoomInfoManager.e().g(yYImModel.source_profile.getUid())) {
                    str = name;
                    if (yYImModel.source_profile.getName().length() > 7) {
                        str = name.substring(0, 7) + "...";
                    }
                } else {
                    str = AbstractBasePresenter.this.f17634a.getResources().getString(R.string.masked_user_name);
                }
                AbstractBasePresenter.this.f17634a.J.a(new YYMountModel(str + "飞驰进场", yYImModel.source_profile.mounts_img, yYImModel.source_profile.mounts_icon, 0, null, null));
            }
        });
        LiveEventBus.get("notify_background", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.20
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                AbstractBasePresenter.this.f17634a.q.a();
            }
        });
        LiveEventBus.get("notify_confessed", ConfessedIMMode.class).observe(lifecycleOwner, new Observer<ConfessedIMMode>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.21
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(ConfessedIMMode confessedIMMode) {
                if (AbstractBasePresenter.this.f17634a != null) {
                    AbstractBasePresenter.this.f17634a.a(confessedIMMode);
                }
            }
        });
        LiveEventBus.get("EVENT_PACK_GIFT_NOTIC", YYPackGiftIMMode.class).observe(lifecycleOwner, new Observer<YYPackGiftIMMode>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.22
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYPackGiftIMMode yYPackGiftIMMode) {
                if (yYPackGiftIMMode.getFull_server_notification() != null) {
                    yYPackGiftIMMode.getFull_server_notification().action_type = 100;
                    yYPackGiftIMMode.getFull_server_notification().link = "YYPackGiftDialog";
                    yYPackGiftIMMode.getFull_server_notification().user_avatar = yYPackGiftIMMode.getTrigger_avatar();
                    YYVipNotifyManager.f17597a.a().a(new YYMsgMarqueeModel(YYMsgMarqueeModel.VIP_MARRIAGE, yYPackGiftIMMode.getFull_server_notification()));
                }
            }
        });
        LiveEventBus.get("EVENT_PACK_GIFT", YYPackGiftIMMode.class).observe(lifecycleOwner, new Observer<YYPackGiftIMMode>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.23
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYPackGiftIMMode yYPackGiftIMMode) {
                if (yYPackGiftIMMode.getStatus() != 1) {
                    YYRoomInfoManager.e().b().round_end_time = 0L;
                    AbstractBasePresenter.this.f17634a.U();
                } else if (YYRoomInfoManager.e().b() != null) {
                    YYRoomInfoManager.e().b().round_end_time = yYPackGiftIMMode.getRound_end_time() * 1000;
                    AbstractBasePresenter.this.f17634a.U();
                }
                if (StringUtils.b(yYPackGiftIMMode.getSpecial_effect_result())) {
                    return;
                }
                YYMsgGiftExtra yYMsgGiftExtra = new YYMsgGiftExtra();
                yYMsgGiftExtra.gift_mp4 = yYPackGiftIMMode.getSpecial_effect_result();
                YYImModel yYImModel = new YYImModel();
                yYImModel.is_play_only_mp4 = true;
                yYImModel.setMsgExtra(AppInfo.f().toJson(yYMsgGiftExtra));
                YYObserverManager.a().a(yYImModel, false);
            }
        });
        LiveEventBus.get("into_gift_wall", YYUserInfo.class).observe(lifecycleOwner, new Observer<YYUserInfo>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.24
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYUserInfo yYUserInfo) {
                AbstractBasePresenter.this.a(yYUserInfo);
            }
        });
        LiveEventBus.get("event_to_charge", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.25
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (AbstractBasePresenter.this.f17634a == null) {
                    return;
                }
                AbstractBasePresenter.this.f17634a.t();
                AbstractBasePresenter.this.f17634a.n();
            }
        });
        LiveEventBus.get("event_yy_game", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.26
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                AbstractBasePresenter.this.b(str);
            }
        });
        LiveEventBus.get("EVENT_ROOM_MUSIC", YYMusicMode.class).observe(lifecycleOwner, new Observer<YYMusicMode>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.27
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYMusicMode yYMusicMode) {
                if (yYMusicMode != null) {
                    AbstractBasePresenter.this.f17634a.a(yYMusicMode);
                }
            }
        });
        LiveEventBus.get("common_report_user", YYReportModel.class).observe(lifecycleOwner, new Observer<YYReportModel>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.28
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(final YYReportModel yYReportModel) {
                final PopYyDialog popYyDialog = new PopYyDialog();
                popYyDialog.a(new PopYyDialogGetView() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.28.1
                    @Override // com.blued.android.module.yy_china.view.PopYyDialogGetView
                    public View a() {
                        YYReportView yYReportView = new YYReportView(AbstractBasePresenter.this.f17634a.getContext());
                        yYReportView.a(AbstractBasePresenter.this.f17634a, yYReportModel);
                        yYReportView.d = popYyDialog;
                        return yYReportView;
                    }

                    @Override // com.blued.android.module.yy_china.view.PopYyDialogGetView
                    public FrameLayout.LayoutParams b() {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        layoutParams.gravity = 80;
                        return layoutParams;
                    }

                    @Override // com.blued.android.module.yy_china.view.PopYyDialogGetView
                    public boolean c() {
                        return true;
                    }
                });
                popYyDialog.show(AbstractBasePresenter.this.f17634a.getChildFragmentManager(), "YYCardOptionView");
            }
        });
        LiveEventBus.get("open_user", YYUserInfo.class).observe(lifecycleOwner, new Observer<YYUserInfo>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.29
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYUserInfo yYUserInfo) {
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null) {
                    AbstractBasePresenter.this.f17634a.a(yYUserInfo.getUid(), yYUserInfo.getName(), yYUserInfo.getAvatar(), YYRoomInfoManager.e().f17578a.chat_anchor, b.isExistById(yYUserInfo.getUid()));
                }
            }
        });
        LiveEventBus.get("update_wish_gift", YYMsgWishListModel.class).observe(lifecycleOwner, new Observer<YYMsgWishListModel>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.30
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYMsgWishListModel yYMsgWishListModel) {
                Logger.e("YYStudioTitleView", "更新心愿礼物 ... ");
                if (yYMsgWishListModel == null) {
                    return;
                }
                AbstractBasePresenter.this.f17634a.A.setVisibility(0);
                AbstractBasePresenter.this.f17634a.A.setItems(yYMsgWishListModel.list);
            }
        });
        LiveEventBus.get("pre_pay_succes", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.31
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                AbstractBasePresenter.this.f17634a.r();
            }
        });
        LiveEventBus.get("EVENT_MARQUEE_MATCH", YYMsgVipMatchExtra.class).observe(lifecycleOwner, new Observer<YYMsgVipMatchExtra>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.32
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYMsgVipMatchExtra yYMsgVipMatchExtra) {
                if (yYMsgVipMatchExtra == null || AbstractBasePresenter.this.f17634a == null || AbstractBasePresenter.this.f17634a.t == null) {
                    return;
                }
                AbstractBasePresenter.this.f17634a.t.a(AbstractBasePresenter.this.f17634a.t.a(yYMsgVipMatchExtra.vip_name, yYMsgVipMatchExtra.target_name), "");
            }
        });
        LiveEventBus.get("inner_fragment_close", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.33
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (AbstractBasePresenter.this.f17634a == null) {
                    return;
                }
                AbstractBasePresenter.this.f17634a.N();
            }
        });
        LiveEventBus.get("event_rank_list", YYMsgUpdateUserList.class).observe(lifecycleOwner, new Observer<YYMsgUpdateUserList>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.34
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYMsgUpdateUserList yYMsgUpdateUserList) {
                if (AbstractBasePresenter.this.f17634a == null) {
                    return;
                }
                if (yYMsgUpdateUserList == null || yYMsgUpdateUserList.seats == null || yYMsgUpdateUserList.seats.isEmpty()) {
                    AbstractBasePresenter.this.f17634a.s.setGoldDatas(null);
                }
                AbstractBasePresenter.this.f17634a.s.setGoldDatas(yYMsgUpdateUserList.seats);
            }
        });
        LiveEventBus.get("event_pop_buy_goods", YYPayRequestModel.class).observe(lifecycleOwner, new Observer<YYPayRequestModel>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.35
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYPayRequestModel yYPayRequestModel) {
                AbstractBasePresenter.this.a(yYPayRequestModel);
            }
        });
        LiveEventBus.get("say_hello", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.36
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                AbstractBasePresenter.this.j();
            }
        });
        LiveEventBus.get("EVENT_JUMP_ROOM", YYJumpRoomMode.class).observe(lifecycleOwner, new Observer<YYJumpRoomMode>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.37
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYJumpRoomMode yYJumpRoomMode) {
                YYJumpLoadingFragment.a(AbstractBasePresenter.this.f17634a.getContext());
                YYRoomInfoManager.e().a((BaseFragmentActivity) AbstractBasePresenter.this.f17634a.getActivity(), yYJumpRoomMode.getRoomid(), yYJumpRoomMode.getSource());
            }
        });
        LiveEventBus.get("EVENT_APPLY_CLOSE_ROOM_MESS", Integer.class).observe(lifecycleOwner, new Observer<Integer>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.38
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Integer num) {
                AbstractBasePresenter.this.f17634a.d(num.intValue());
            }
        });
        LiveEventBus.get("show_matching_pk_new", YYEventMatching.class).observe(lifecycleOwner, new Observer<YYEventMatching>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.39
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYEventMatching yYEventMatching) {
                YYPKMatchingFragment.f17352a.a(yYEventMatching).show(AbstractBasePresenter.this.f17634a.getParentFragmentManager(), "new_matching_dialog");
            }
        });
        LiveEventBus.get("EVENT_PRIZE_MESSAGE", YYGlobalMsgModel.class).observe(lifecycleOwner, new Observer<YYGlobalMsgModel>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.40
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYGlobalMsgModel yYGlobalMsgModel) {
                YYGlobalMsgMarqueeModel yYGlobalMsgMarqueeModel;
                if (yYGlobalMsgModel == null) {
                    return;
                }
                int i = yYGlobalMsgModel.type;
                if (i == 1) {
                    YYGlobalMsgMarqueeModel yYGlobalMsgMarqueeModel2 = (YYGlobalMsgMarqueeModel) AppInfo.f().fromJson(yYGlobalMsgModel.body, (Class<Object>) YYGlobalMsgMarqueeModel.class);
                    if (yYGlobalMsgMarqueeModel2 == null) {
                        return;
                    }
                    AbstractBasePresenter.this.f17634a.t.a(yYGlobalMsgMarqueeModel2);
                } else if (i == 4) {
                    YYEnergyBallMsgModel yYEnergyBallMsgModel = (YYEnergyBallMsgModel) AppInfo.f().fromJson(yYGlobalMsgModel.body, (Class<Object>) YYEnergyBallMsgModel.class);
                    if (yYEnergyBallMsgModel == null) {
                        return;
                    }
                    new YYPrizeDialog(yYEnergyBallMsgModel.prizeName, yYEnergyBallMsgModel.prizeImg, yYEnergyBallMsgModel.prizeValue).show(AbstractBasePresenter.this.f17634a.getFragmentManager(), "prize_dialog");
                } else if (i != 7) {
                    if (i == 8 && (yYGlobalMsgMarqueeModel = (YYGlobalMsgMarqueeModel) AppInfo.f().fromJson(yYGlobalMsgModel.body, (Class<Object>) YYGlobalMsgMarqueeModel.class)) != null) {
                        YYVipNotifyManager.f17597a.a().a(new YYMsgMarqueeModel(YYMsgMarqueeModel.VIP_MARRIAGE, yYGlobalMsgMarqueeModel));
                    }
                } else {
                    YYMsgMuteExtra yYMsgMuteExtra = (YYMsgMuteExtra) AppInfo.f().fromJson(yYGlobalMsgModel.body, (Class<Object>) YYMsgMuteExtra.class);
                    if (yYMsgMuteExtra == null) {
                        return;
                    }
                    if (TextUtils.equals(yYMsgMuteExtra.target_uid, YYRoomInfoManager.e().k())) {
                        if (YYRoomInfoManager.e().f17578a != null) {
                            YYRoomInfoManager.e().f17578a.is_mic = "0";
                            YYRoomInfoManager.e().f17578a.is_open_mic = 0;
                        }
                        YYObserverManager.a().a("0");
                        return;
                    }
                    YYAudioConfig yYAudioConfig = new YYAudioConfig();
                    yYAudioConfig.f17862c = yYMsgMuteExtra.target_uid;
                    AudioChannelManager.j().b(5, AppInfo.f().toJson(yYAudioConfig));
                    if (AppInfo.h >= 713040) {
                        TRTCSendLeaveMsg tRTCSendLeaveMsg = new TRTCSendLeaveMsg();
                        tRTCSendLeaveMsg.cmdID = 5;
                        tRTCSendLeaveMsg.uid = yYMsgMuteExtra.target_uid;
                        AudioChannelManager.j().a(tRTCSendLeaveMsg);
                    }
                }
            }
        });
        LiveEventBus.get("EVENT_NOTICE_ROOM_BANNER_ACTIVITY_RANK", YYBannerRankModel.class).observe(lifecycleOwner, new Observer<YYBannerRankModel>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.41
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYBannerRankModel yYBannerRankModel) {
                if (yYBannerRankModel == null || AbstractBasePresenter.this.f17634a == null || AbstractBasePresenter.this.f17634a.L == null) {
                    return;
                }
                AbstractBasePresenter.this.f17634a.L.a(yYBannerRankModel);
            }
        });
        LiveEventBus.get("EVENT_HOST_UP", YYHostUpMode.class).observe(lifecycleOwner, new Observer<YYHostUpMode>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.42
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(final YYHostUpMode yYHostUpMode) {
                if (yYHostUpMode == null || AbstractBasePresenter.this.f17634a == null || AbstractBasePresenter.this.f17634a.K == null) {
                    return;
                }
                if (!StringUtils.b(yYHostUpMode.getMaterial())) {
                    AbstractBasePresenter.this.f17634a.K.a(new YYMountModel("", "", "", 0, yYHostUpMode, new LiveAnimationListener() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.42.1
                        @Override // com.blued.android.module.live.base.view.animation.LiveAnimationListener
                        public void a() {
                        }

                        @Override // com.blued.android.module.live.base.view.animation.LiveAnimationListener
                        public void b() {
                            if (StringUtils.b(yYHostUpMode.getBroadcast_background())) {
                                return;
                            }
                            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.42.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    YYVipNotifyManager.f17597a.a().a(new YYMsgMarqueeModel(YYMsgMarqueeModel.HOST_UP_MARRIAGE, yYHostUpMode));
                                }
                            }, 10000L);
                        }
                    }));
                } else if (StringUtils.b(yYHostUpMode.getBroadcast_background())) {
                } else {
                    YYVipNotifyManager.f17597a.a().a(new YYMsgMarqueeModel(YYMsgMarqueeModel.HOST_UP_MARRIAGE, yYHostUpMode));
                }
            }
        });
        LiveEventBus.get("EVENT_UP", IMJsonContents95Model.class).observe(lifecycleOwner, new Observer<IMJsonContents95Model>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.43
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(IMJsonContents95Model iMJsonContents95Model) {
                YYUpMode yYUpMode;
                if (iMJsonContents95Model.getBusiness() != 2 || iMJsonContents95Model.getType() != 2 || (yYUpMode = (YYUpMode) AppInfo.f().fromJson(iMJsonContents95Model.getExtra(), (Class<Object>) YYUpMode.class)) == null || StringUtils.b(iMJsonContents95Model.getMaterial())) {
                    return;
                }
                yYUpMode.setBroadcast_background(iMJsonContents95Model.getMaterial());
                YYVipNotifyManager.f17597a.a().a(new YYMsgMarqueeModel(YYMsgMarqueeModel.UP_MARRIAGE, yYUpMode));
            }
        });
        LiveEventBus.get("update_coin_num", YYPreciousPackageModel.class).observe(lifecycleOwner, new Observer<YYPreciousPackageModel>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.44
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYPreciousPackageModel yYPreciousPackageModel) {
                if (AbstractBasePresenter.this.f17634a == null || AbstractBasePresenter.this.f17634a.O == null || yYPreciousPackageModel == null) {
                    return;
                }
                if (AbstractBasePresenter.this.b != null) {
                    AbstractBasePresenter.this.b.current_beans = yYPreciousPackageModel.current_beans;
                    AbstractBasePresenter.this.b.need_total_beans = yYPreciousPackageModel.need_total_beans;
                    if (StringUtils.a(yYPreciousPackageModel.grant, -1) >= 0) {
                        AbstractBasePresenter.this.b.grant = yYPreciousPackageModel.grant;
                    }
                    if (!TextUtils.isEmpty(yYPreciousPackageModel.icon_big)) {
                        AbstractBasePresenter.this.b.icon_big = yYPreciousPackageModel.icon_big;
                    }
                    if (!TextUtils.isEmpty(yYPreciousPackageModel.icon_middle)) {
                        AbstractBasePresenter.this.b.icon_middle = yYPreciousPackageModel.icon_middle;
                        AbstractBasePresenter.this.f17634a.O.a(AbstractBasePresenter.this.b.icon_middle);
                    }
                    if (!TextUtils.isEmpty(yYPreciousPackageModel.icon_small)) {
                        AbstractBasePresenter.this.b.icon_small = yYPreciousPackageModel.icon_middle;
                    }
                }
                AbstractBasePresenter.this.f17634a.O.a();
            }
        });
        LiveEventBus.get("fall_down_prize", YYPreciousPackageModel.class).observe(lifecycleOwner, new Observer<YYPreciousPackageModel>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.45
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYPreciousPackageModel yYPreciousPackageModel) {
                if (AbstractBasePresenter.this.f17634a == null || yYPreciousPackageModel == null) {
                    return;
                }
                if (AbstractBasePresenter.this.b != null) {
                    AbstractBasePresenter.this.b.count_down = yYPreciousPackageModel.count_down;
                    AbstractBasePresenter.this.b.level = yYPreciousPackageModel.level;
                    AbstractBasePresenter.this.b.trigger_vanish_time = yYPreciousPackageModel.trigger_vanish_time;
                    AbstractBasePresenter.this.b.animation = yYPreciousPackageModel.animation;
                    AbstractBasePresenter.this.b.grant = yYPreciousPackageModel.grant;
                    AbstractBasePresenter.this.b.icon_big = yYPreciousPackageModel.icon_big;
                    AbstractBasePresenter.this.b.icon_middle = yYPreciousPackageModel.icon_middle;
                    AbstractBasePresenter.this.b.icon_small = yYPreciousPackageModel.icon_middle;
                } else {
                    AbstractBasePresenter.this.b = yYPreciousPackageModel;
                }
                if (AbstractBasePresenter.this.f17634a.O != null) {
                    AbstractBasePresenter.this.f17634a.O.a(AbstractBasePresenter.this.b.icon_middle);
                    if (TextUtils.isEmpty(yYPreciousPackageModel.animation)) {
                        AbstractBasePresenter.this.b.animation = "https://web.bldimg.com/cblued/static/box1.1ge496l66182qme.mp4";
                    }
                    YYGiftManager.a().a(AbstractBasePresenter.this.b.animation);
                    AbstractBasePresenter abstractBasePresenter = AbstractBasePresenter.this;
                    abstractBasePresenter.b(StringUtils.a(abstractBasePresenter.b.count_down, 0));
                }
                AbstractBasePresenter.this.h();
            }
        });
        LiveEventBus.get("show_magical_prize", YYMagicalPrizeModel.class).observe(lifecycleOwner, new Observer<YYMagicalPrizeModel>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.46
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYMagicalPrizeModel yYMagicalPrizeModel) {
                AbstractBasePresenter.this.a(yYMagicalPrizeModel);
            }
        });
        LiveEventBus.get("show_music", String.class).observe(this.f17634a, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.47
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                AbstractBasePresenter.this.f17634a.p();
            }
        });
        LiveEventBus.get("play_svga_room_pk", EventRoomPkSvgaExtra.class).observe(lifecycleOwner, new Observer<EventRoomPkSvgaExtra>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.48
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(EventRoomPkSvgaExtra eventRoomPkSvgaExtra) {
                if (AbstractBasePresenter.this.f17634a == null || AbstractBasePresenter.this.f17634a.aa == null || eventRoomPkSvgaExtra == null) {
                    return;
                }
                int i = eventRoomPkSvgaExtra.svgaType;
                if (i == 1) {
                    AbstractBasePresenter.this.b(eventRoomPkSvgaExtra);
                } else if (i != 2) {
                    AbstractBasePresenter.this.c(eventRoomPkSvgaExtra);
                } else {
                    AbstractBasePresenter.this.a(eventRoomPkSvgaExtra);
                }
            }
        });
        LiveEventBus.get("show_inner_dialog", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.49
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                YYWebViewDialogFragment yYWebViewDialogFragment = new YYWebViewDialogFragment();
                yYWebViewDialogFragment.a(AbstractBasePresenter.this.f17634a, str);
                yYWebViewDialogFragment.show(AbstractBasePresenter.this.f17634a.getParentFragmentManager(), "inner_web_dialog");
            }
        });
        LiveEventBus.get("EVENT_SHOW_LOAD_DIALOG", String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.50
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                boolean z;
                int hashCode = str.hashCode();
                if (hashCode != 876073126) {
                    if (hashCode == 968212689 && str.equals("YYPackGiftDialog")) {
                        z = false;
                    }
                    z = true;
                } else {
                    if (str.equals("YYConfessedListDialog")) {
                        z = true;
                    }
                    z = true;
                }
                if (!z) {
                    new YYPackGiftDialog().show(AbstractBasePresenter.this.f17634a.getChildFragmentManager(), "YYPackGiftDialog");
                } else if (!z) {
                } else {
                    new YYConfessedListDialog().show(AbstractBasePresenter.this.f17634a.getChildFragmentManager(), "YYConfessedListDialog");
                }
            }
        });
        LiveEventBus.get("show_coming_event", IMJsonContents108Model.class).observe(lifecycleOwner, new Observer<IMJsonContents108Model>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.51
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(IMJsonContents108Model iMJsonContents108Model) {
                if (iMJsonContents108Model.getActivity_info() != null && iMJsonContents108Model.getType() == 0) {
                    String id = iMJsonContents108Model.getActivity_info().getId();
                    Long valueOf = Long.valueOf(YYRoomPreferences.a().a(id, 0L));
                    Long d = TimeAndDateUtils.d();
                    if (valueOf.longValue() > 0 && AbstractBasePresenter.this.f17634a.F) {
                        LogUtils.d("AbstractBasePresenter", "当天已经显示过活动预告，且又从小窗返回直播间 activity_id：" + id);
                    } else if (valueOf.longValue() >= d.longValue()) {
                        LogUtils.d("AbstractBasePresenter", "当天已经显示过活动预告 activity_id：" + id);
                        return;
                    } else {
                        YYRoomPreferences.a().c().a(id, d.longValue());
                    }
                }
                FrameLayout frameLayout = (FrameLayout) AbstractBasePresenter.this.f17634a.f17010c.findViewById(R.id.fra_add_view_layout);
                if (frameLayout != null && AbstractBasePresenter.this.d != null) {
                    frameLayout.removeView(AbstractBasePresenter.this.d);
                }
                if (iMJsonContents108Model.getType() == 3) {
                    LogUtils.d("AbstractBasePresenter", "主题专场活动结束");
                    if (YYRoomInfoManager.e().y()) {
                        AbstractBasePresenter.this.f17634a.z.setVisibility(8);
                    } else {
                        AbstractBasePresenter.this.f17634a.z.a(AbstractBasePresenter.this.f17634a, (IMJsonContents109Model) null);
                    }
                } else if (iMJsonContents108Model.getType() == 2) {
                } else {
                    if (iMJsonContents108Model.getType() != 1 || iMJsonContents108Model.getCountdown_time() > 0) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 5;
                        AbstractBasePresenter.this.d = new FloatComingEventsView(AbstractBasePresenter.this.f17634a.getContext());
                        AbstractBasePresenter.this.d.a(AbstractBasePresenter.this.f17634a, iMJsonContents108Model);
                        frameLayout.addView(AbstractBasePresenter.this.d, layoutParams);
                        AbstractBasePresenter.this.d.setY(AbstractBasePresenter.this.f17634a.getResources().getDimensionPixelOffset(R.dimen.dp_300));
                    }
                }
            }
        });
        LiveEventBus.get("theme_activity_gifts", IMJsonContents109Model.class).observe(lifecycleOwner, new Observer<IMJsonContents109Model>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.52
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(IMJsonContents109Model iMJsonContents109Model) {
                if (AbstractBasePresenter.this.f17634a == null || AbstractBasePresenter.this.f17634a.z == null || iMJsonContents109Model == null) {
                    return;
                }
                AbstractBasePresenter.this.f17634a.z.a(AbstractBasePresenter.this.f17634a, iMJsonContents109Model);
            }
        });
        LiveEventBus.get("EVENT_SHOW_DOUBLE_PEOPLE_NOTICE", DoublePeopleNoticeImNode.class).observe(lifecycleOwner, new Observer<DoublePeopleNoticeImNode>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.53
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(DoublePeopleNoticeImNode doublePeopleNoticeImNode) {
                if (doublePeopleNoticeImNode != null) {
                    YYVipNotifyManager.f17597a.a().a(new YYMsgMarqueeModel(YYMsgMarqueeModel.DOUBLE_PEOPLE_MARRIAGE, doublePeopleNoticeImNode));
                }
            }
        });
        LiveEventBus.get(LiveEventBusConstant.e, String.class).observe(lifecycleOwner, new Observer<String>() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.54
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (AbstractBasePresenter.this.f17634a != null) {
                    AbstractBasePresenter.this.f17634a.z();
                }
            }
        });
        b(lifecycleOwner);
    }

    protected final void a(final YYClickApplyEvent yYClickApplyEvent) {
        PermissionHelper.a(new PermissionCallbacks() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.64
            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void U_() {
                LiveLogUtils.a("AbstractBasePresenter --> applySeatByPosition --> 授权麦克风权限 ... ");
                if (yYClickApplyEvent.isShowApplicationDialog()) {
                    AbstractBasePresenter.this.b(yYClickApplyEvent);
                } else {
                    AbstractBasePresenter.this.c(yYClickApplyEvent);
                }
            }

            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void a(String[] strArr) {
                LiveLogUtils.a("AbstractBasePresenter --> applySeatByPosition --> 拒绝麦克风权限 ... ");
                AppMethods.a((CharSequence) "麦克风已被禁用，请在设置中授权麦克风使用");
            }
        });
    }

    public void a(YYGiftModel yYGiftModel, int i, String str, boolean z) {
        BaseYYStudioFragment baseYYStudioFragment;
        YYRoomModel b;
        if (yYGiftModel == null || (baseYYStudioFragment = this.f17634a) == null || !baseYYStudioFragment.isAdded() || !this.f17634a.getFragmentActive().isActive() || (b = YYRoomInfoManager.e().b()) == null) {
            return;
        }
        YYPayRequestModel yYPayRequestModel = new YYPayRequestModel();
        yYPayRequestModel.gift = yYGiftModel;
        yYPayRequestModel.beans = yYGiftModel.beans;
        yYPayRequestModel.giftCount = i;
        yYPayRequestModel.goods_id = yYGiftModel.goods_id;
        yYPayRequestModel.goods_type = yYGiftModel.goods_type;
        yYPayRequestModel.hit_id = yYGiftModel.hit_id;
        yYPayRequestModel.payCode = str;
        yYPayRequestModel.remember_me = z;
        yYPayRequestModel.room_id = b.room_id;
        yYPayRequestModel.target_uid = StringUtils.b(yYGiftModel.yyTarget_uid) ? b.uid : yYGiftModel.yyTarget_uid;
        a(yYPayRequestModel);
    }

    public void a(String str, String str2) {
        if (StringUtils.b(str2)) {
            return;
        }
        YYRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<YYUserInfo>>(this.f17634a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.78
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYUserInfo> bluedEntityA) {
                LiveEventBus.get("into_gift_wall").post(bluedEntityA.data.get(0));
            }
        }, str, str2, this.f17634a.getFragmentActive());
    }

    public void a(final boolean z) {
        BaseYYStudioFragment baseYYStudioFragment = this.f17634a;
        if (baseYYStudioFragment == null) {
            return;
        }
        YYRoomHttpUtils.r(new BluedUIHttpResponse<BluedEntityA<YYRoomBasicMode>>(baseYYStudioFragment.getFragmentActive()) { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.68
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYRoomBasicMode> bluedEntityA) {
                YYRoomBasicMode singleData;
                if (bluedEntityA == null || !bluedEntityA.hasData() || AbstractBasePresenter.this.f17634a == null || (singleData = bluedEntityA.getSingleData()) == null) {
                    return;
                }
                YYRoomBasicInfoMode honor_info = singleData.getHonor_info();
                YYRoomBasicInfoMode anchor_info = singleData.getAnchor_info();
                YYRoomBasicPropMode prop_info = singleData.getProp_info();
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null) {
                    if (honor_info != null && honor_info.getCurrent_level_info() != null) {
                        b.wealth_level = honor_info.getCurrent_level_info().getLevel();
                    }
                    if (anchor_info != null && anchor_info.getCurrent_level_info() != null) {
                        b.anchor_level = anchor_info.getCurrent_level_info().getLevel();
                    }
                    if (prop_info != null) {
                        if (prop_info.getEnter_effects() != null) {
                            b.enter_effects_forward = prop_info.getEnter_effects().getIcon();
                            b.enter_effects = prop_info.getEnter_effects().getImg();
                        }
                        if (prop_info.getPendant() != null) {
                            b.avatar_frame = prop_info.getPendant().getImg();
                        }
                        if (prop_info.getMessage_bubble() != null) {
                            b.message_bubble_icon = prop_info.getMessage_bubble().getIcon();
                            b.message_bubble_img = prop_info.getMessage_bubble().getImg();
                        }
                        if (prop_info.getMounts() != null) {
                            b.mounts_img = prop_info.getMounts().getImg();
                            b.mounts_icon = prop_info.getMounts().getIcon();
                        }
                        if (prop_info.getTitle() != null) {
                            b.title = prop_info.getTitle();
                        }
                    }
                    if (!z && !AbstractBasePresenter.this.f17634a.F) {
                        YYImMsgManager.a().e();
                    }
                    if (singleData.getWeek_star() != null && StringUtils.a(singleData.getWeek_star().is_show(), 2) == 1) {
                        b.weeklyRankUrl = singleData.getWeek_star().getLink();
                    }
                }
                YYMusicManager.f11418a.c().a(false, "", "");
                if (singleData.getFirst_meet() != null) {
                    AbstractBasePresenter.this.a(singleData.getFirst_meet().getShow_delay());
                }
                if (singleData.getTrue_love_box() != null) {
                    if (b != null) {
                        b.round_end_time = singleData.getTrue_love_box().getRound_end_time() * 1000;
                    }
                    AbstractBasePresenter.this.f17634a.U();
                }
                if (b != null) {
                    b.open_batch_gifts = singleData.getOpen_batch_gifts();
                }
                if (singleData.getRelation_data() != null) {
                    YYRoomInfoManager.e().i = singleData.getRelation_data().getReport_online_number();
                    YYRoomInfoManager.e().j = singleData.getRelation_data().getReport_online_time();
                    YYRoomInfoManager.e().a(false);
                }
            }
        }, this.f17634a.getFragmentActive());
    }

    protected String b() {
        return "是否向房主发起上麦申请";
    }

    public abstract void b(LifecycleOwner lifecycleOwner);

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(final YYClickApplyEvent yYClickApplyEvent) {
        BaseYYStudioFragment baseYYStudioFragment = this.f17634a;
        if (baseYYStudioFragment == null || baseYYStudioFragment.isDetached()) {
            return;
        }
        View inflate = LayoutInflater.from(this.f17634a.getContext()).inflate(R.layout.dialog_apply_mic_layout, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.dialog_title)).setText(b());
        LiveAlterDialog.a(this.f17634a.getContext(), inflate, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.65
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                YYRoomModel b;
                Tracker.onClick(view);
                if (yYClickApplyEvent.getSource() != YYConstants.ApplyFromSource.SaleVip || (b = YYRoomInfoManager.e().b()) == null) {
                    return;
                }
                EventTrackYY.e(ChatRoomProtos.Event.CHAT_ROOM_AUCTION_APPLY_TRUE_CLICK, b.room_id);
            }
        }, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.66
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null) {
                    int i = AnonymousClass79.f17720a[yYClickApplyEvent.getSource().ordinal()];
                    if (i == 1) {
                        EventTrackYY.e(ChatRoomProtos.Event.CHAT_ROOM_AUCTION_APPLY_FALSE_CLICK, b.room_id);
                    } else if (i != 2 && i != 3) {
                        EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_MIKE_CONFIRM_CLICK, b.room_id, b.uid);
                    }
                }
                AbstractBasePresenter.this.c(yYClickApplyEvent);
            }
        }, true, false);
    }

    public long c() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTimeInMillis() / 1000;
    }

    public final void c(final YYClickApplyEvent yYClickApplyEvent) {
        final YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || yYClickApplyEvent == null) {
            return;
        }
        YYRoomHttpUtils.d(b.room_id, yYClickApplyEvent.getSeatNumber() < 0 ? 0 : yYClickApplyEvent.getSeatNumber(), new BluedUIHttpResponse<BluedEntityA<Object>>(this.f17634a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.67
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                YYImModel yYImModel = new YYImModel();
                yYImModel.type = -2;
                if (TextUtils.equals(b.chat_type, "9")) {
                    yYImModel.contents = AppInfo.d().getString(R.string.yy_msg_apply_mic_with_manager);
                } else {
                    yYImModel.contents = AppInfo.d().getString(R.string.yy_msg_apply_mic);
                }
                YYImMsgManager.a().f(yYImModel);
                YYClickApplyEvent yYClickApplyEvent2 = yYClickApplyEvent;
                if (yYClickApplyEvent2 != null && yYClickApplyEvent2.getSource() == YYConstants.ApplyFromSource.UserCard) {
                    AbstractBasePresenter.this.f17634a.y();
                }
                LiveLogUtils.a("AbstractBasePresenter --> EVENT_NOTIFY_ALERT_MESSAGE --> 上麦接口请求成功 ... params: " + yYClickApplyEvent.toString());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                if (i == 40380002) {
                    ToastUtils.a("房间已关闭", 0);
                    LiveLogUtils.a("AbstractBasePresenter --> EVENT_NOTIFY_ALERT_MESSAGE --> 上麦接口请求失败 ... errorMessage: " + str);
                    if (AbstractBasePresenter.this.f17634a != null) {
                        if (AbstractBasePresenter.this.f17634a instanceof PlayingStudioFragment) {
                            ((PlayingStudioFragment) AbstractBasePresenter.this.f17634a).aj = true;
                        }
                        AbstractBasePresenter.this.f17634a.G();
                    }
                }
                return super.onUIFailure(i, str);
            }
        }, this.f17634a.getFragmentActive());
    }

    public void d() {
        final YYRoomModel b;
        if (this.f17634a == null || (b = YYRoomInfoManager.e().b()) == null) {
            return;
        }
        YYRoomHttpUtils.l(b.room_id, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYImModel>>(this.f17634a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.presenter.AbstractBasePresenter.70
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYImModel> bluedEntityA) {
                if (bluedEntityA != null && bluedEntityA.hasData()) {
                    if (b != null) {
                        AbstractBasePresenter.this.a(b, bluedEntityA.data, 0, bluedEntityA.data.size());
                        return;
                    }
                    return;
                }
                YYImMsgManager.a().a(AppInfo.d().getString(R.string.yy_room_regulation_title), AppInfo.d().getString(R.string.yy_room_regulation_content));
                if (YYRoomInfoManager.e().y()) {
                    YYImMsgManager.a().b();
                } else {
                    AbstractBasePresenter.this.a(b);
                }
            }
        }, this.f17634a.getFragmentActive());
    }

    public void e() {
        CountDownTimer countDownTimer = this.f17635c;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        YYVipNotifyManager.f17597a.a().a();
    }
}
