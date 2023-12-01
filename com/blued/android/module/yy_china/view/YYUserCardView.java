package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.SharedPreferencesUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.yy_china.IYYRoomInfoCallback;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.databinding.DialogUserCardLayoutBinding;
import com.blued.android.module.yy_china.dialog.YYRomanticGuidebookDialog;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYBaseFansDialog;
import com.blued.android.module.yy_china.fragment.YYDecorateCarDialog;
import com.blued.android.module.yy_china.fragment.YYFansClubAudienceViewDialog;
import com.blued.android.module.yy_china.fragment.YYFansClubHostViewDialog;
import com.blued.android.module.yy_china.fragment.YYFansWelfareDialog;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.UserAuctionModel;
import com.blued.android.module.yy_china.model.UserCardHonorInfoMode;
import com.blued.android.module.yy_china.model.VeiledRoomInfoMode;
import com.blued.android.module.yy_china.model.YYClubLevelInfoModel;
import com.blued.android.module.yy_china.model.YYGiftGottenModel;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYGiftWallModel;
import com.blued.android.module.yy_china.model.YYPayGoodsModel;
import com.blued.android.module.yy_china.model.YYPayRequestModel;
import com.blued.android.module.yy_china.model.YYPersonalProfileMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUserCardInfoMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUserInfoMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUserLeveLInfoMode;
import com.blued.android.module.yy_china.model.YYRoomBasicPropItemMode;
import com.blued.android.module.yy_china.model.YYRoomBasicPropMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYUserCardFansInfoModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.model.YYcollectorMode;
import com.blued.android.module.yy_china.model.trtc.TRTCSendLeaveMsg;
import com.blued.android.module.yy_china.observer.FollowStatusObserver;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.trtc_audio.model.YYAudioConfig;
import com.blued.android.module.yy_china.utils.UserRelationshipUtils;
import com.blued.android.module.yy_china.utils.YYPayUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.YYTextSpanComputer;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.CertificateLevelView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYUserCardView.class */
public abstract class YYUserCardView extends RelativeLayout implements View.OnClickListener, FollowStatusObserver {

    /* renamed from: a  reason: collision with root package name */
    private final DialogUserCardLayoutBinding f18532a;
    private PopYyDialog b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f18533c;
    private final int[] d;
    private final int[] e;
    private final int[] f;
    private final int[] g;
    private final int[] h;
    private BaseYYStudioFragment i;
    private String j;
    private YYUserInfo k;
    private final Observer<String> l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYUserCardView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYUserCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYUserCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        DialogUserCardLayoutBinding a2 = DialogUserCardLayoutBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
        this.f18532a = a2;
        this.f18533c = new int[]{R.color.color_897369, R.color.color_747FB3, R.color.color_5D7D98, R.color.color_4B78B2, R.color.color_6340C1, R.color.color_8C40C1};
        this.d = new int[]{R.drawable.yy_bg_user_card_wealth_1, R.drawable.yy_bg_user_card_wealth_2, R.drawable.yy_bg_user_card_wealth_3, R.drawable.yy_bg_user_card_wealth_4, R.drawable.yy_bg_user_card_wealth_5, R.drawable.yy_bg_user_card_wealth_6};
        this.e = new int[]{R.drawable.yy_icon_live_host_1, R.drawable.yy_icon_live_host_2, R.drawable.yy_icon_live_host_3, R.drawable.yy_icon_live_host_4};
        this.f = new int[]{R.drawable.yy_bg_live_host_1, R.drawable.yy_bg_live_host_2, R.drawable.yy_bg_live_host_3, R.drawable.yy_bg_live_host_4};
        this.g = new int[]{R.color.color_8486a1, R.color.color_879bb4, R.color.color_c59c53, R.color.color_9a8ec8};
        this.h = new int[]{R.color.color_897369, R.color.color_747FB3, R.color.color_5D7D98, R.color.color_4B78B2, R.color.color_6340C1, R.color.color_8C40C1};
        ShapeLinearLayout shapeLinearLayout = this.f18532a.E;
        Intrinsics.c(shapeLinearLayout, "binding.llInfo");
        a(shapeLinearLayout);
        YYUserCardView yYUserCardView = this;
        this.f18532a.z.setOnClickListener(yYUserCardView);
        this.f18532a.P.setOnClickListener(yYUserCardView);
        this.f18532a.b.setOnClickListener(yYUserCardView);
        this.f18532a.y.setOnClickListener(yYUserCardView);
        this.f18532a.f16420c.setOnClickListener(yYUserCardView);
        this.f18532a.ac.setOnClickListener(yYUserCardView);
        this.f18532a.J.setOnClickListener(yYUserCardView);
        this.f18532a.L.setOnClickListener(yYUserCardView);
        this.f18532a.K.setOnClickListener(yYUserCardView);
        this.f18532a.H.setOnClickListener(yYUserCardView);
        this.f18532a.M.setOnClickListener(yYUserCardView);
        this.f18532a.I.setOnClickListener(yYUserCardView);
        this.f18532a.N.setOnClickListener(yYUserCardView);
        this.l = new Observer() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYUserCardView$CIq0zOegna2xFdunWUtxdBQf488
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYUserCardView.a(YYUserCardView.this, (String) obj);
            }
        };
    }

    private final int a(int i) {
        if (i <= 8) {
            return 0;
        }
        if (i <= 16) {
            return 1;
        }
        if (i <= 24) {
            return 2;
        }
        if (i <= 32) {
            return 3;
        }
        return i <= 37 ? 4 : 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(YYGiftGottenModel yYGiftGottenModel, String str) {
        YYcollectorMode.SkinDTO skinDTO;
        if (yYGiftGottenModel != null && !yYGiftGottenModel.goods.isEmpty()) {
            TextView textView = this.f18532a.R;
            textView.setText("点亮" + ((Object) yYGiftGottenModel.gotten_count) + "个礼物");
            int size = yYGiftGottenModel.goods.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                YYGiftWallModel yYGiftWallModel = yYGiftGottenModel.goods.get(i2);
                if (i2 == 0) {
                    this.f18532a.p.setVisibility(0);
                    YYRoomInfoManager e = YYRoomInfoManager.e();
                    BaseYYStudioFragment baseYYStudioFragment = this.i;
                    e.a(baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive(), this.f18532a.p, yYGiftWallModel.sponsor.get(0).getUid(), yYGiftWallModel.sponsor.get(0).getAvatar());
                    this.f18532a.l.setBackgroundResource(R.drawable.shape_raduis_8dp_52b0ff);
                    BaseYYStudioFragment baseYYStudioFragment2 = this.i;
                    ImageLoader.a(baseYYStudioFragment2 == null ? null : baseYYStudioFragment2.getFragmentActive(), yYGiftWallModel.images_static).a(this.f18532a.l);
                }
                if (i2 == 1) {
                    this.f18532a.q.setVisibility(0);
                    YYRoomInfoManager e2 = YYRoomInfoManager.e();
                    BaseYYStudioFragment baseYYStudioFragment3 = this.i;
                    e2.a(baseYYStudioFragment3 == null ? null : baseYYStudioFragment3.getFragmentActive(), this.f18532a.q, yYGiftWallModel.sponsor.get(0).getUid(), yYGiftWallModel.sponsor.get(0).getAvatar());
                    this.f18532a.m.setBackgroundResource(R.drawable.shape_raduis_8dp_52b0ff);
                    BaseYYStudioFragment baseYYStudioFragment4 = this.i;
                    ImageLoader.a(baseYYStudioFragment4 == null ? null : baseYYStudioFragment4.getFragmentActive(), yYGiftWallModel.images_static).a(this.f18532a.m);
                }
                if (i2 == 2) {
                    this.f18532a.r.setVisibility(0);
                    YYRoomInfoManager e3 = YYRoomInfoManager.e();
                    BaseYYStudioFragment baseYYStudioFragment5 = this.i;
                    e3.a(baseYYStudioFragment5 == null ? null : baseYYStudioFragment5.getFragmentActive(), this.f18532a.r, yYGiftWallModel.sponsor.get(0).getUid(), yYGiftWallModel.sponsor.get(0).getAvatar());
                    this.f18532a.n.setBackgroundResource(R.drawable.shape_raduis_8dp_52b0ff);
                    BaseYYStudioFragment baseYYStudioFragment6 = this.i;
                    ImageLoader.a(baseYYStudioFragment6 == null ? null : baseYYStudioFragment6.getFragmentActive(), yYGiftWallModel.images_static).a(this.f18532a.n);
                }
                i = i2 + 1;
            }
        } else {
            this.f18532a.R.setText("点亮0个礼物");
        }
        if (yYGiftGottenModel == null || (skinDTO = yYGiftGottenModel.f17618skin) == null) {
            return;
        }
        BaseYYStudioFragment fragment = getFragment();
        ImageLoader.a(fragment == null ? null : fragment.getFragmentActive(), skinDTO.getProfile()).a(new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.view.YYUserCardView$refreshGiftWall$1$1
            @Override // com.bumptech.glide.request.target.Target
            /* renamed from: a */
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                Intrinsics.e(resource, "resource");
                YYUserCardView.this.getBinding().b.setBackgroundDrawable(resource);
                YYUserCardView.this.getBinding().l.setBackgroundResource(R.drawable.shape_raduis_8dp_ffffff);
                YYUserCardView.this.getBinding().m.setBackgroundResource(R.drawable.shape_raduis_8dp_ffffff);
                YYUserCardView.this.getBinding().n.setBackgroundResource(R.drawable.shape_raduis_8dp_ffffff);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRoomModel roomModel, YYUserCardView this$0, View view) {
        Intrinsics.e(roomModel, "$roomModel");
        Intrinsics.e(this$0, "this$0");
        ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_PROFILE_PAGE_LIFT_MASK_CLICK;
        String str = roomModel.room_id;
        String str2 = roomModel.uid;
        YYUserInfo yYUserInfo = this$0.k;
        EventTrackYY.l(event, str, str2, yYUserInfo == null ? null : yYUserInfo.getUid());
        this$0.l();
    }

    private final void a(YYUserInfo yYUserInfo) {
        if (yYUserInfo.romantic_trip == null || StringUtils.a(yYUserInfo.custom_car_info.getReceived_count(), 0) < 0) {
            this.f18532a.N.setVisibility(8);
            return;
        }
        if (this.f18532a.g.getVisibility() != 0) {
            this.f18532a.g.setVisibility(0);
        }
        this.f18532a.N.setVisibility(0);
        CertificateLevelView.Builder builder = new CertificateLevelView.Builder();
        builder.c(R.drawable.yy_bg_user_card_trip);
        builder.d(R.drawable.yy_icon_user_card_trip);
        StringBuilder sb = new StringBuilder();
        sb.append(yYUserInfo.romantic_trip == null ? 0 : yYUserInfo.romantic_trip.getReceived_count());
        sb.append((char) 20010);
        builder.a(sb.toString());
        builder.b(R.color.syc_tran50_095E89);
        builder.b("浪漫图鉴");
        builder.a(R.color.syc_539FC5);
        this.f18532a.N.a(builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final YYUserCardView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        BaseYYStudioFragment baseYYStudioFragment = this$0.i;
        final ActivityFragmentActive fragmentActive = baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive();
        BluedUIHttpResponse<BluedEntityA<Object>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<Object>>(fragmentActive) { // from class: com.blued.android.module.yy_china.view.YYUserCardView$forcedOut$1$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                AudioChannelManager j = AudioChannelManager.j();
                YYUserInfo userModel = YYUserCardView.this.getUserModel();
                j.a(userModel == null ? null : userModel.getUid(), 0);
                YYAudioConfig yYAudioConfig = new YYAudioConfig();
                YYUserInfo userModel2 = YYUserCardView.this.getUserModel();
                yYAudioConfig.f17862c = userModel2 == null ? null : userModel2.getUid();
                AudioChannelManager.j().b(3, AppInfo.f().toJson(yYAudioConfig));
                if (AppInfo.h >= 713040) {
                    TRTCSendLeaveMsg tRTCSendLeaveMsg = new TRTCSendLeaveMsg();
                    tRTCSendLeaveMsg.cmdID = 3;
                    YYUserInfo userModel3 = YYUserCardView.this.getUserModel();
                    tRTCSendLeaveMsg.uid = userModel3 == null ? null : userModel3.getUid();
                    AudioChannelManager.j().a(tRTCSendLeaveMsg);
                }
                YYUserCardView.this.a(ChatRoomProtos.Event.CHAT_ROOM_KICK_OUT_CONFIRM_CLICK);
                PopYyDialog mPopYyDialog = YYUserCardView.this.getMPopYyDialog();
                if (mPopYyDialog == null) {
                    return;
                }
                mPopYyDialog.dismissAllowingStateLoss();
            }
        };
        String str = b.room_id;
        YYUserInfo yYUserInfo = this$0.k;
        String uid = yYUserInfo == null ? null : yYUserInfo.getUid();
        BaseYYStudioFragment baseYYStudioFragment2 = this$0.i;
        YYRoomHttpUtils.b(bluedUIHttpResponse, str, uid, baseYYStudioFragment2 == null ? null : baseYYStudioFragment2.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYUserCardView this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.getUserInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ChatRoomProtos.Event event) {
        YYUserInfo userModel;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (userModel = getUserModel()) == null) {
            return;
        }
        EventTrackYY.a(event, b.room_id, b.uid, userModel.getUid());
    }

    private final void a(String str) {
        this.f18532a.P.setText(UserRelationshipUtils.a(getContext(), str));
        String str2 = str;
        if (!TextUtils.equals(str2, "1") && !TextUtils.equals(str2, "3")) {
            YYUserInfo yYUserInfo = this.k;
            if (!TextUtils.equals(yYUserInfo == null ? null : yYUserInfo.getUid(), YYRoomInfoManager.e().k()) && !TextUtils.equals(str2, "8") && !TextUtils.equals(str2, "4")) {
                this.f18532a.P.setVisibility(0);
                return;
            }
        }
        this.f18532a.P.setVisibility(8);
    }

    private final void a(String str, boolean z, final YYGiftModel yYGiftModel) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        YYPayRequestModel yYPayRequestModel = new YYPayRequestModel();
        if (yYGiftModel != null) {
            yYGiftModel.hit_id = System.currentTimeMillis();
        }
        yYPayRequestModel.gift = yYGiftModel;
        yYPayRequestModel.beans = (yYGiftModel == null ? null : Long.valueOf(yYGiftModel.beans)) == null ? 0L : yYGiftModel.beans;
        yYPayRequestModel.giftCount = 1;
        yYPayRequestModel.goods_id = yYGiftModel == null ? null : yYGiftModel.goods_id;
        Integer valueOf = yYGiftModel == null ? null : Integer.valueOf(yYGiftModel.goods_type);
        Intrinsics.a(valueOf);
        yYPayRequestModel.goods_type = valueOf.intValue();
        yYPayRequestModel.hit_id = 0L;
        yYPayRequestModel.payCode = str;
        yYPayRequestModel.remember_me = z;
        yYPayRequestModel.room_id = b == null ? null : b.room_id;
        YYUserInfo yYUserInfo = this.k;
        yYPayRequestModel.target_uid = yYUserInfo == null ? null : yYUserInfo.getUid();
        yYPayRequestModel.pay_from = 1;
        YYConstants.PayFromSource payFromSource = YYConstants.PayFromSource.Pay_Gift;
        BaseYYStudioFragment baseYYStudioFragment = this.i;
        YYPayUtils.a(yYPayRequestModel, payFromSource, baseYYStudioFragment, baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive(), new YYPayUtils.PayGiftStatusListener() { // from class: com.blued.android.module.yy_china.view.YYUserCardView$buyGift$1
            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
            }

            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(YYPayGoodsModel goodsModel) {
                Intrinsics.e(goodsModel, "goodsModel");
                YYSeatMemberModel yYSeatMemberModel = new YYSeatMemberModel();
                YYUserInfo userModel = YYUserCardView.this.getUserModel();
                yYSeatMemberModel.setUid(userModel == null ? null : userModel.getUid());
                YYUserInfo userModel2 = YYUserCardView.this.getUserModel();
                yYSeatMemberModel.setName(userModel2 == null ? null : userModel2.getName());
                YYUserInfo userModel3 = YYUserCardView.this.getUserModel();
                yYSeatMemberModel.setAvatar(userModel3 == null ? null : userModel3.getAvatar());
                YYImMsgManager.a().a(yYGiftModel, yYSeatMemberModel, goodsModel, false);
                YYUserCardView.this.getUserInfo();
                ToastUtils.a("揭面成功");
            }
        }, "YY_SU_PASSWORD_userinfo_buy_masked");
    }

    private final void a(boolean z) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || this.k == null) {
            return;
        }
        ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_USER_PROFILE_FOLLOW_CLICK;
        String str = b.room_id;
        String str2 = b.uid;
        YYUserInfo yYUserInfo = this.k;
        EventTrackYY.a(event, str, str2, yYUserInfo == null ? null : yYUserInfo.getUid(), z);
    }

    private final int b(int i) {
        return this.h[a(i)];
    }

    private final void b(YYUserInfo yYUserInfo) {
        if (yYUserInfo.wealth_level < 0) {
            this.f18532a.K.setVisibility(8);
            return;
        }
        this.f18532a.K.setVisibility(0);
        if (this.f18532a.g.getVisibility() != 0) {
            this.f18532a.g.setVisibility(0);
        }
        CertificateLevelView.Builder builder = new CertificateLevelView.Builder();
        builder.c(this.d[a(yYUserInfo.wealth_level)]);
        UserCardHonorInfoMode userCardHonorInfoMode = yYUserInfo.honor_info;
        builder.c(String.valueOf(userCardHonorInfoMode == null ? null : userCardHonorInfoMode.getPersonal_profile_badge()));
        BaseYYStudioFragment baseYYStudioFragment = this.i;
        builder.a(baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive());
        builder.a(true);
        StringBuilder sb = new StringBuilder();
        sb.append(yYUserInfo.wealth_level);
        sb.append((char) 32423);
        builder.a(sb.toString());
        builder.b(b(yYUserInfo.wealth_level));
        builder.b("荣誉等级");
        builder.a(b(yYUserInfo.wealth_level));
        this.f18532a.K.a(builder);
        if (yYUserInfo.wealth_level >= 3) {
            this.f18532a.W.setText(new YYTextSpanComputer.Builder().a(this.f18532a.W.getText().toString(), getContext().getResources().getColor(R.color.color_7BCBFF), getContext().getResources().getColor(R.color.color_DE7BFF)).c().a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYUserCardView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.f18532a.e.getVisibility() == 0) {
            this$0.f18532a.e.setVisibility(8);
            return;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_LIFT_MASK_POP_SHOW;
            String str = b.room_id;
            String str2 = b.uid;
            YYUserInfo userModel = this$0.getUserModel();
            EventTrackYY.l(event, str, str2, userModel == null ? null : userModel.getUid());
        }
        this$0.f18532a.e.setVisibility(0);
    }

    private final int c(int i) {
        int i2 = (i - 1) / 4;
        int[] iArr = this.e;
        int i3 = i2;
        if (i2 >= iArr.length) {
            i3 = iArr.length - 1;
        }
        return this.e[i3];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        ArrayList<UserAuctionModel> arrayList;
        this.f18532a.H.setVisibility(8);
        YYUserInfo yYUserInfo = this.k;
        if (yYUserInfo == null || (arrayList = yYUserInfo.auction) == null || arrayList.size() <= 0) {
            return;
        }
        UserAuctionModel userAuctionModel = arrayList.get(0);
        getBinding().H.setVisibility(0);
        getBinding().O.setText(userAuctionModel.getRelation_name());
        BaseYYStudioFragment fragment = getFragment();
        ImageLoader.a(fragment == null ? null : fragment.getFragmentActive(), userAuctionModel.getRelation_bg()).a(new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.view.YYUserCardView$noticRation$1$1
            @Override // com.bumptech.glide.request.target.Target
            /* renamed from: a */
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                Intrinsics.e(resource, "resource");
                YYUserCardView.this.getBinding().O.setBackgroundDrawable(resource);
            }
        });
        BaseYYStudioFragment fragment2 = getFragment();
        ActivityFragmentActive fragmentActive = fragment2 == null ? null : fragment2.getFragmentActive();
        YYUserInfo userModel = getUserModel();
        String avatar = userModel == null ? null : userModel.getAvatar();
        Intrinsics.a((Object) avatar);
        ImageLoader.a(fragmentActive, avatar).c().b(R.drawable.user_bg_round).a(getBinding().j);
        BaseYYStudioFragment fragment3 = getFragment();
        ImageLoader.a(fragment3 == null ? null : fragment3.getFragmentActive(), userAuctionModel.getAuction_avatar()).c().b(R.drawable.user_bg_round).a(getBinding().k);
        BaseYYStudioFragment fragment4 = getFragment();
        ImageLoader.a(fragment4 == null ? null : fragment4.getFragmentActive(), userAuctionModel.getBg_image()).a(new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.view.YYUserCardView$noticRation$1$2
            @Override // com.bumptech.glide.request.target.Target
            /* renamed from: a */
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                Intrinsics.e(resource, "resource");
                YYUserCardView.this.getBinding().H.setBackgroundDrawable(resource);
            }
        });
    }

    private final void c(YYUserInfo yYUserInfo) {
        if (yYUserInfo.chat_anchor_level == null || yYUserInfo.chat_anchor_level.getLevel() <= 0) {
            this.f18532a.L.setVisibility(8);
            return;
        }
        this.f18532a.L.setVisibility(0);
        if (this.f18532a.g.getVisibility() != 0) {
            this.f18532a.g.setVisibility(0);
        }
        CertificateLevelView.Builder builder = new CertificateLevelView.Builder();
        builder.c(d(yYUserInfo.chat_anchor_level.getLevel()));
        builder.d(c(yYUserInfo.chat_anchor_level.getLevel()));
        StringBuilder sb = new StringBuilder();
        sb.append(yYUserInfo.chat_anchor_level.getLevel());
        sb.append((char) 32423);
        builder.a(sb.toString());
        builder.b(e(yYUserInfo.chat_anchor_level.getLevel()));
        builder.b("主播等级");
        builder.a(e(yYUserInfo.chat_anchor_level.getLevel()));
        this.f18532a.L.a(builder);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_ANCHOR_LEVEL_ENTER_SHOW, b.room_id, b.uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYUserCardView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && this$0.k != null) {
            String str = b.uid;
            YYUserInfo yYUserInfo = this$0.k;
            if (TextUtils.equals(str, yYUserInfo == null ? null : yYUserInfo.getUid())) {
                ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_UNFOLLOW;
                String str2 = b.room_id;
                String str3 = b.uid;
                YYUserInfo yYUserInfo2 = this$0.k;
                EventTrackYY.a(event, str2, str3, yYUserInfo2 == null ? null : yYUserInfo2.getUid());
            }
        }
        YYRoomInfoManager e = YYRoomInfoManager.e();
        Context context = this$0.getContext();
        YYUserInfo yYUserInfo3 = this$0.k;
        String uid = yYUserInfo3 == null ? null : yYUserInfo3.getUid();
        BaseYYStudioFragment baseYYStudioFragment = this$0.i;
        e.a(context, uid, "", baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive());
    }

    private final int d(int i) {
        int i2 = (i - 1) / 4;
        int[] iArr = this.f;
        int i3 = i2;
        if (i2 >= iArr.length) {
            i3 = iArr.length - 1;
        }
        return this.f[i3];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode;
        this.f18532a.M.setVisibility(8);
        YYUserInfo yYUserInfo = this.k;
        if (yYUserInfo == null || (yYRelationShipRoomUserCardInfoMode = yYUserInfo.relation) == null) {
            return;
        }
        getBinding().M.setVisibility(0);
        YYRelationShipRoomUserInfoMode uid_profile = yYRelationShipRoomUserCardInfoMode.getUid_profile();
        if (uid_profile != null) {
            if (YYRoomInfoManager.e().J() && !YYRoomInfoManager.e().g(uid_profile.getUid())) {
                getBinding().B.setImageResource(R.drawable.icon_user_mask_without_text);
            } else if (yYRelationShipRoomUserCardInfoMode.is_hidden() == 1) {
                BaseYYStudioFragment fragment = getFragment();
                ImageLoader.a(fragment == null ? null : fragment.getFragmentActive(), uid_profile.getAvatar()).c().b(R.drawable.user_bg_round).a(100).a(getBinding().B);
            } else {
                BaseYYStudioFragment fragment2 = getFragment();
                ImageLoader.a(fragment2 == null ? null : fragment2.getFragmentActive(), uid_profile.getAvatar()).c().b(R.drawable.user_bg_round).a(getBinding().B);
            }
        }
        YYRelationShipRoomUserInfoMode targe_uid_profile = yYRelationShipRoomUserCardInfoMode.getTarge_uid_profile();
        if (targe_uid_profile != null) {
            if (YYRoomInfoManager.e().J() && !YYRoomInfoManager.e().g(targe_uid_profile.getUid())) {
                getBinding().C.setImageResource(R.drawable.icon_user_mask_without_text);
            } else if (yYRelationShipRoomUserCardInfoMode.getTarget_uid_hidden() == 1) {
                BaseYYStudioFragment fragment3 = getFragment();
                ImageLoader.a(fragment3 == null ? null : fragment3.getFragmentActive(), targe_uid_profile.getAvatar()).c().b(R.drawable.user_bg_round).d().a(getBinding().C);
            } else {
                BaseYYStudioFragment fragment4 = getFragment();
                ImageLoader.a(fragment4 == null ? null : fragment4.getFragmentActive(), targe_uid_profile.getAvatar()).c().b(R.drawable.user_bg_round).a(getBinding().C);
            }
        }
        YYRelationShipRoomUserLeveLInfoMode level_info = yYRelationShipRoomUserCardInfoMode.getLevel_info();
        if (level_info != null) {
            TextView textView = getBinding().Y;
            textView.setText("LV." + level_info.getCurrent_level() + ' ' + level_info.getLevel_name());
            getBinding().Y.setTextColor(Color.parseColor(level_info.getTheme_color_6()));
            BaseYYStudioFragment fragment5 = getFragment();
            ImageLoader.a(fragment5 == null ? null : fragment5.getFragmentActive(), level_info.getBackground_personal_data_image()).a(getBinding().i);
            BaseYYStudioFragment fragment6 = getFragment();
            ImageLoader.a(fragment6 == null ? null : fragment6.getFragmentActive(), level_info.getIcon_progress_relation_center()).a(getBinding().A);
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_PROFILE_RELATION_SHOW;
        String str = b.room_id;
        String str2 = b.uid;
        YYUserInfo userModel = getUserModel();
        EventTrackYY.l(event, str, str2, userModel == null ? null : userModel.getUid());
    }

    private final void d(YYUserInfo yYUserInfo) {
        if (yYUserInfo.badge.size() <= 0) {
            this.f18532a.f16420c.setVisibility(8);
            return;
        }
        this.f18532a.f16420c.setVisibility(0);
        TextView textView = this.f18532a.V;
        StringBuilder sb = new StringBuilder();
        sb.append((char) 20849);
        sb.append(yYUserInfo.badge.size());
        sb.append((char) 20010);
        textView.setText(sb.toString());
        SquareImageView squareImageView = this.f18532a.v;
        Intrinsics.c(squareImageView, "binding.ivMedal1");
        SquareImageView squareImageView2 = squareImageView;
        SquareImageView squareImageView3 = this.f18532a.w;
        Intrinsics.c(squareImageView3, "binding.ivMedal2");
        SquareImageView squareImageView4 = squareImageView3;
        SquareImageView squareImageView5 = this.f18532a.x;
        Intrinsics.c(squareImageView5, "binding.ivMedal3");
        ArrayList d = CollectionsKt.d(squareImageView2, squareImageView4, squareImageView5);
        int size = 3 - yYUserInfo.badge.size();
        int i = size;
        if (size < 0) {
            i = 0;
        }
        int size2 = yYUserInfo.badge.size();
        for (int i2 = 0; i2 < size2; i2++) {
            BaseYYStudioFragment baseYYStudioFragment = this.i;
            ImageLoader.a(baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive(), yYUserInfo.badge.get(i2).getPic()).b(R.drawable.anchor_badge_default).d(R.drawable.anchor_badge_default).a((ImageView) d.get(i));
            i++;
            if (i2 >= 2) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYUserCardView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_LIFT_MASK_POP_USE_CLICK;
            String str = b.room_id;
            String str2 = b.uid;
            YYUserInfo userModel = this$0.getUserModel();
            EventTrackYY.l(event, str, str2, userModel == null ? null : userModel.getUid());
        }
        this$0.m();
    }

    private final int e(int i) {
        int i2 = (i - 1) / 4;
        int[] iArr = this.g;
        int i3 = i2;
        if (i2 >= iArr.length) {
            i3 = iArr.length - 1;
        }
        return this.g[i3];
    }

    private final void e() {
        BaseYYStudioFragment fragment;
        YYUserInfo yYUserInfo = this.k;
        if (yYUserInfo == null || YYRoomInfoManager.e().b() == null || (fragment = getFragment()) == null) {
            return;
        }
        fragment.a(YYRoomInfoManager.e().b().room_id, yYUserInfo.getUid(), yYUserInfo.getName(), yYUserInfo.getAvatar(), getURole(), false, "");
    }

    private final void f() {
        BaseYYStudioFragment fragment;
        if (this.k != null && YYRoomInfoManager.e().b() != null && (fragment = getFragment()) != null) {
            fragment.w();
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_PROFILE_RELATION_CLICK;
        String str = b.room_id;
        String str2 = b.uid;
        YYUserInfo userModel = getUserModel();
        EventTrackYY.l(event, str, str2, userModel == null ? null : userModel.getUid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(YYUserCardView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.getUserInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        String img;
        String img2;
        YYUserInfo yYUserInfo = this.k;
        if (yYUserInfo != null) {
            if (!YYRoomInfoManager.e().J() || YYRoomInfoManager.e().g(yYUserInfo.getUid())) {
                getBinding().ac.setClickable(true);
                getBinding().e.setVisibility(8);
                getBinding().f.setVisibility(8);
                getBinding().aa.setVisibility(0);
                YYBaseUserHeadView yYBaseUserHeadView = getBinding().ac;
                BaseYYStudioFragment fragment = getFragment();
                ActivityFragmentActive fragmentActive = fragment == null ? null : fragment.getFragmentActive();
                YYUserInfo userModel = getUserModel();
                String avatar = userModel == null ? null : userModel.getAvatar();
                YYUserInfo userModel2 = getUserModel();
                yYBaseUserHeadView.a(fragmentActive, avatar, userModel2 == null ? null : userModel2.avatar_frame);
                getBinding().W.setText(yYUserInfo.getName());
                String valueOf = String.valueOf(yYUserInfo.age);
                String str = valueOf;
                if (!TextUtils.isEmpty(yYUserInfo.height)) {
                    str = valueOf;
                    if (!TextUtils.isEmpty(yYUserInfo.weight)) {
                        str = valueOf + " · " + ((Object) yYUserInfo.height) + "cm · " + ((Object) yYUserInfo.weight) + "kg· " + ((Object) UserInfoHelper.a(getContext(), (TextView) null, yYUserInfo.role));
                    }
                }
                getBinding().aa.setText(str + " · " + ((Object) yYUserInfo.location));
                YYPersonalProfileMode yYPersonalProfileMode = yYUserInfo.personal_profile;
                if (yYPersonalProfileMode != null && (img = yYPersonalProfileMode.getImg()) != null) {
                    BaseYYStudioFragment fragment2 = getFragment();
                    ImageLoader.a(fragment2 == null ? null : fragment2.getFragmentActive(), img).g().g(-1).a(getBinding().D);
                }
                b(yYUserInfo);
                c(yYUserInfo);
                j();
                d(yYUserInfo);
                a(yYUserInfo);
                YYRoomBasicPropMode yYRoomBasicPropMode = yYUserInfo.prop_info;
                if (yYRoomBasicPropMode != null) {
                    if (yYRoomBasicPropMode.getTitle() == null || yYRoomBasicPropMode.getTitle().size() <= 0) {
                        getBinding().ab.setVisibility(8);
                    } else {
                        YYTextSpanComputer.Builder builder = new YYTextSpanComputer.Builder();
                        for (YYRoomBasicPropItemMode yYRoomBasicPropItemMode : yYRoomBasicPropMode.getTitle()) {
                            TextView textView = getBinding().ab;
                            Intrinsics.c(textView, "binding.tvUserTitle");
                            BaseYYStudioFragment fragment3 = getFragment();
                            builder.a(textView, fragment3 == null ? null : fragment3.getFragmentActive(), AppMethods.a(yYRoomBasicPropItemMode.getWidth() / 2), AppMethods.a(16), yYRoomBasicPropItemMode.getImg());
                            builder.a(" ");
                        }
                        getBinding().ab.setVisibility(0);
                        getBinding().ab.setText(builder.c().a());
                    }
                }
                String str2 = yYUserInfo.relationship;
                if (str2 != null) {
                    a(str2);
                }
                YYClubLevelInfoModel yYClubLevelInfoModel = yYUserInfo.fans_group_info;
                if (yYClubLevelInfoModel != null) {
                    if (StringUtils.a(yYClubLevelInfoModel.level, -1) > 0) {
                        getBinding().F.setVisibility(0);
                        getBinding().F.a(yYClubLevelInfoModel.level, yYClubLevelInfoModel.name, yYClubLevelInfoModel.status == 1);
                    } else {
                        getBinding().F.setVisibility(8);
                    }
                }
            } else {
                h();
                getBinding().P.setVisibility(8);
                getBinding().ac.setClickable(false);
                YYPersonalProfileMode yYPersonalProfileMode2 = yYUserInfo.personal_profile;
                if (yYPersonalProfileMode2 != null && (img2 = yYPersonalProfileMode2.getImg()) != null) {
                    BaseYYStudioFragment fragment4 = getFragment();
                    ImageLoader.a(fragment4 != null ? fragment4.getFragmentActive() : null, img2).g().g(-1).a(getBinding().D);
                }
                if (yYUserInfo.wealth_level >= 3) {
                    getBinding().W.setText(new YYTextSpanComputer.Builder().a(getBinding().W.getText().toString(), getContext().getResources().getColor(R.color.color_7BCBFF), getContext().getResources().getColor(R.color.color_DE7BFF)).c().a());
                }
            }
            if (TextUtils.equals(yYUserInfo.getUid(), YYRoomInfoManager.e().k())) {
                getBinding().z.setVisibility(8);
            } else {
                getBinding().z.setVisibility(0);
            }
        }
        if (SharedPreferencesUtils.b().getBoolean("tv_red_gift_wall", false)) {
            return;
        }
        this.f18532a.X.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getUserInfo() {
        final YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        BaseYYStudioFragment baseYYStudioFragment = this.i;
        ActivityFragmentActive activityFragmentActive = null;
        final ActivityFragmentActive fragmentActive = baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive();
        BluedUIHttpResponse<BluedEntityA<YYUserInfo>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<YYUserInfo>>(fragmentActive) { // from class: com.blued.android.module.yy_china.view.YYUserCardView$getUserInfo$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYUserInfo> user) {
                String uid;
                Intrinsics.e(user, "user");
                YYUserCardView.this.setUserModel(user.data.get(0));
                YYUserInfo yYUserInfo = YYRoomInfoManager.e().f17578a;
                String str = null;
                if (yYUserInfo != null) {
                    YYUserInfo userModel = YYUserCardView.this.getUserModel();
                    if (TextUtils.equals(userModel == null ? null : userModel.getUid(), yYUserInfo.getUid())) {
                        YYRoomInfoManager.e().f17578a = YYUserCardView.this.getUserModel();
                    }
                }
                if (YYRoomInfoManager.e().J()) {
                    YYRoomInfoManager e = YYRoomInfoManager.e();
                    YYUserInfo userModel2 = YYUserCardView.this.getUserModel();
                    String str2 = "";
                    if (userModel2 != null && (uid = userModel2.getUid()) != null) {
                        str2 = uid;
                    }
                    if (e.g(str2)) {
                        YYUserCardView.this.getBinding().e.setVisibility(8);
                        YYUserCardView.this.getBinding().f.setVisibility(8);
                        YYUserCardView.this.i();
                    }
                } else {
                    YYUserCardView.this.i();
                }
                YYUserInfo userModel3 = YYUserCardView.this.getUserModel();
                if (TextUtils.equals(userModel3 == null ? null : userModel3.chat_anchor, "1")) {
                    ShapeHelper.b(YYUserCardView.this.getBinding().Z, R.color.syc_3883FD);
                    YYUserCardView.this.getBinding().Z.setText(YYUserCardView.this.getContext().getResources().getString(R.string.yy_role_host));
                    YYUserCardView.this.getBinding().Z.setVisibility(0);
                } else {
                    YYUserInfo userModel4 = YYUserCardView.this.getUserModel();
                    if (TextUtils.equals(userModel4 == null ? null : userModel4.chat_anchor, "2")) {
                        ShapeHelper.b(YYUserCardView.this.getBinding().Z, R.color.syc_8F38FD);
                        YYUserCardView.this.getBinding().Z.setText(YYUserCardView.this.getContext().getResources().getString(R.string.yy_role_manager));
                        YYUserCardView.this.getBinding().Z.setVisibility(0);
                    } else {
                        YYUserCardView.this.getBinding().Z.setVisibility(8);
                    }
                }
                YYUserCardView.this.a();
                YYUserCardView.this.g();
                YYUserCardView yYUserCardView = YYUserCardView.this;
                YYUserInfo userModel5 = yYUserCardView.getUserModel();
                YYGiftGottenModel yYGiftGottenModel = userModel5 == null ? null : userModel5.gift_wall;
                YYUserInfo userModel6 = YYUserCardView.this.getUserModel();
                if (userModel6 != null) {
                    str = userModel6.getUid();
                }
                yYUserCardView.a(yYGiftGottenModel, str);
                YYUserCardView.this.d();
                YYUserCardView.this.c();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                YYUserCardView.this.getBinding().d.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                YYUserCardView.this.getBinding().d.setVisibility(0);
            }
        };
        String str = b.room_id;
        YYUserInfo yYUserInfo = this.k;
        String uid = yYUserInfo == null ? null : yYUserInfo.getUid();
        BaseYYStudioFragment baseYYStudioFragment2 = this.i;
        if (baseYYStudioFragment2 != null) {
            activityFragmentActive = baseYYStudioFragment2.getFragmentActive();
        }
        YYRoomHttpUtils.a(bluedUIHttpResponse, str, uid, activityFragmentActive);
        this.f18532a.f16419a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYUserCardView$P-rh9tAYT7-8QvJNDAPIOlnBXoQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYUserCardView.a(YYRoomModel.this, this, view);
            }
        });
    }

    private final void h() {
        VeiledRoomInfoMode veiledRoomInfoMode;
        YYGiftModel goods_info;
        ShapeTextView shapeTextView = this.f18532a.T;
        Resources resources = getResources();
        int i = R.string.use_masked_guide;
        YYRoomModel b = YYRoomInfoManager.e().b();
        Long l = "";
        if (b != null && (veiledRoomInfoMode = b.mMaskedVeiledRoominfo) != null && (goods_info = veiledRoomInfoMode.getGoods_info()) != null) {
            l = Long.valueOf(goods_info.beans);
        }
        shapeTextView.setText(resources.getString(i, l));
        this.f18532a.t.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYUserCardView$RdsNSOR-AgXX2oRLt2vAmvoUSNs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYUserCardView.b(YYUserCardView.this, view);
            }
        });
        this.f18532a.f.setVisibility(0);
        this.f18532a.aa.setVisibility(8);
        this.f18532a.ac.setEmptyHead(R.drawable.icon_user_mask_with_text);
        this.f18532a.W.setText(getResources().getString(R.string.masked_user_name));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        YYUserCardFansInfoModel yYUserCardFansInfoModel;
        YYUserCardFansInfoModel yYUserCardFansInfoModel2;
        String str;
        YYUserInfo yYUserInfo = this.k;
        if ((yYUserInfo == null ? null : yYUserInfo.target_fans_group_data) != null) {
            YYUserInfo yYUserInfo2 = this.k;
            if (!TextUtils.isEmpty((yYUserInfo2 == null || (yYUserCardFansInfoModel = yYUserInfo2.target_fans_group_data) == null) ? null : yYUserCardFansInfoModel.fans_count)) {
                YYUserInfo yYUserInfo3 = this.k;
                if (!TextUtils.isEmpty((yYUserInfo3 == null || (yYUserCardFansInfoModel2 = yYUserInfo3.target_fans_group_data) == null) ? null : yYUserCardFansInfoModel2.name)) {
                    if (this.f18532a.g.getVisibility() != 0) {
                        this.f18532a.g.setVisibility(0);
                    }
                    this.f18532a.J.setVisibility(0);
                    CertificateLevelView.Builder builder = new CertificateLevelView.Builder();
                    builder.c(R.drawable.yy_bg_user_card_fans);
                    builder.d(R.drawable.yy_icon_user_card_fans);
                    YYUserInfo yYUserInfo4 = this.k;
                    if (yYUserInfo4 == null) {
                        str = null;
                    } else {
                        YYUserCardFansInfoModel yYUserCardFansInfoModel3 = yYUserInfo4.target_fans_group_data;
                        str = yYUserCardFansInfoModel3 == null ? null : yYUserCardFansInfoModel3.fans_count;
                    }
                    builder.a(Intrinsics.a(str, (Object) "人"));
                    builder.b(R.color.syc_F7295B);
                    builder.b("粉丝团");
                    builder.a(R.color.syc_F7295B);
                    this.f18532a.J.a(builder);
                    return;
                }
            }
        }
        this.f18532a.J.setVisibility(8);
    }

    private final void j() {
        YYUserInfo yYUserInfo = this.k;
        if (yYUserInfo == null) {
            return;
        }
        if (yYUserInfo.custom_car_info == null || StringUtils.a(yYUserInfo.custom_car_info.getReceived_count(), 0) < 0) {
            getBinding().I.setVisibility(8);
            return;
        }
        if (getBinding().g.getVisibility() != 0) {
            getBinding().g.setVisibility(0);
        }
        getBinding().I.setVisibility(0);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_MADE_CAR_SHOW, b.room_id, b.uid);
        }
        CertificateLevelView.Builder builder = new CertificateLevelView.Builder();
        builder.c(R.drawable.icon_user_car_exhibition);
        builder.d(R.drawable.icon_user_card_car);
        builder.a(Intrinsics.a(yYUserInfo.custom_car_info.getReceived_count(), (Object) "个跑车"));
        builder.b(R.color.syc_tran50_5372C5);
        builder.b("定制展馆");
        builder.a(R.color.syc_5372C5);
        getBinding().I.a(builder);
    }

    private final void k() {
        LiveAlterDialog.a(getContext(), R.layout.dialog_follow_layout, (View.OnClickListener) null, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYUserCardView$3OUg50O6qzJG4SsK3CpWgddsW9k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYUserCardView.c(YYUserCardView.this, view);
            }
        }, false, true);
    }

    private final void l() {
        if (SharedPreferencesUtils.b().getBoolean("YYMaskedBuyReidesDialog", false)) {
            m();
            return;
        }
        YYUserInfo yYUserInfo = this.k;
        YYMaskedBuyReidesDialog yYMaskedBuyReidesDialog = new YYMaskedBuyReidesDialog(yYUserInfo == null ? null : yYUserInfo.getUid());
        yYMaskedBuyReidesDialog.a(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYUserCardView$yY525swboV3TIO0xRBKe0wSdLRs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYUserCardView.d(YYUserCardView.this, view);
            }
        });
        BaseYYStudioFragment baseYYStudioFragment = this.i;
        if (baseYYStudioFragment == null) {
            return;
        }
        FragmentManager childFragmentManager = baseYYStudioFragment.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "it.childFragmentManager");
        yYMaskedBuyReidesDialog.show(childFragmentManager, "YYMaskedBuyReidesDialog");
    }

    private final void m() {
        VeiledRoomInfoMode veiledRoomInfoMode;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (veiledRoomInfoMode = b.mMaskedVeiledRoominfo) == null) {
            return;
        }
        a("", false, veiledRoomInfoMode.getGoods_info());
    }

    public abstract void a();

    public abstract void a(LinearLayout linearLayout);

    /* JADX WARN: Removed duplicated region for block: B:36:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.module.yy_china.fragment.BaseYYStudioFragment r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.view.YYUserCardView.a(com.blued.android.module.yy_china.fragment.BaseYYStudioFragment, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    @Override // com.blued.android.module.yy_china.observer.FollowStatusObserver
    public void a_(String str, String str2) {
        YYUserInfo yYUserInfo = this.k;
        if (yYUserInfo == null) {
            return;
        }
        yYUserInfo.relationship = str2;
        String str3 = str2;
        if (TextUtils.equals(str3, "1") || TextUtils.equals(str3, "3")) {
            ToastUtils.a(getResources().getString(R.string.yy_follow_success));
        }
        Intrinsics.a((Object) str2);
        a(str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        LiveAlterDialog.a(getContext(), R.layout.dialog_kick_out_layout, (View.OnClickListener) null, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYUserCardView$hgB3EzH_2ralqyQlArRWJtOQPsU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYUserCardView.a(YYUserCardView.this, view);
            }
        }, false, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DialogUserCardLayoutBinding getBinding() {
        return this.f18532a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BaseYYStudioFragment getFragment() {
        return this.i;
    }

    public final PopYyDialog getMPopYyDialog() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getURole() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final YYUserInfo getUserModel() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        YYObserverManager.a().a(this);
        LiveEventBus.get("YYSuccessPasswordEvent", String.class).observeForever(this.l);
        LiveEventBus.get("take_off_mask", String.class).observeForever(this.l);
    }

    public void onClick(View view) {
        BaseYYStudioFragment baseYYStudioFragment;
        FragmentActivity activity;
        BaseFullScreenDialog baseFullScreenDialog;
        Tracker.onClick(view);
        if (ClickUtils.a(R.id.yy_base_head)) {
            return;
        }
        ActivityFragmentActive activityFragmentActive = null;
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i = R.id.rl_lv_host;
        if (valueOf != null && valueOf.intValue() == i) {
            YYUserInfo yYUserInfo = this.k;
            if (TextUtils.equals(yYUserInfo == null ? null : yYUserInfo.getUid(), YYRoomInfoManager.e().k())) {
                IYYRoomInfoCallback c2 = YYRoomInfoManager.e().c();
                Context context = getContext();
                String c3 = YYRoomInfoManager.e().c(8);
                YYUserInfo yYUserInfo2 = this.k;
                c2.a(context, Intrinsics.a(c3, (Object) EncryptTool.b(yYUserInfo2 == null ? null : yYUserInfo2.getUid())), 0, true);
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null) {
                    EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_ANCHOR_LEVEL_ENTER_CLICK, b.room_id, b.uid);
                    return;
                }
                return;
            }
            return;
        }
        int i2 = R.id.rl_lv_honor;
        if (valueOf != null && valueOf.intValue() == i2) {
            YYUserInfo yYUserInfo3 = this.k;
            if (TextUtils.equals(yYUserInfo3 == null ? null : yYUserInfo3.getUid(), YYRoomInfoManager.e().k())) {
                IYYRoomInfoCallback c4 = YYRoomInfoManager.e().c();
                Context context2 = getContext();
                String c5 = YYRoomInfoManager.e().c(7);
                YYUserInfo yYUserInfo4 = this.k;
                c4.a(context2, Intrinsics.a(c5, (Object) EncryptTool.b(yYUserInfo4 == null ? null : yYUserInfo4.getUid())), 0, true);
                a(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_HONOR_LEVEL_CLICK);
                return;
            }
            return;
        }
        int i3 = R.id.rl_fans;
        if (valueOf != null && valueOf.intValue() == i3) {
            if (this.i == null) {
                return;
            }
            YYUserInfo yYUserInfo5 = this.k;
            if (yYUserInfo5 != null) {
                if (Intrinsics.a((Object) YYRoomInfoManager.e().k(), (Object) yYUserInfo5.getUid())) {
                    BaseYYStudioFragment fragment = getFragment();
                    Intrinsics.a(fragment);
                    YYFansClubHostViewDialog yYFansClubHostViewDialog = new YYFansClubHostViewDialog(fragment, yYUserInfo5);
                    BaseYYStudioFragment fragment2 = getFragment();
                    FragmentManager parentFragmentManager = fragment2 == null ? null : fragment2.getParentFragmentManager();
                    Intrinsics.a(parentFragmentManager);
                    Intrinsics.c(parentFragmentManager, "fragment?.parentFragmentManager!!");
                    yYFansClubHostViewDialog.show(parentFragmentManager, "fans_club_dialog");
                } else {
                    if (yYUserInfo5.in_target_fans_group_info == null || yYUserInfo5.in_target_fans_group_info.level == null) {
                        BaseYYStudioFragment fragment3 = getFragment();
                        Intrinsics.a(fragment3);
                        baseFullScreenDialog = (YYBaseFansDialog) new YYFansWelfareDialog(fragment3, yYUserInfo5);
                    } else {
                        BaseYYStudioFragment fragment4 = getFragment();
                        Intrinsics.a(fragment4);
                        baseFullScreenDialog = (YYBaseFansDialog) new YYFansClubAudienceViewDialog(fragment4, yYUserInfo5);
                    }
                    BaseYYStudioFragment fragment5 = getFragment();
                    Intrinsics.a(fragment5);
                    FragmentManager parentFragmentManager2 = fragment5.getParentFragmentManager();
                    Intrinsics.c(parentFragmentManager2, "fragment!!.parentFragmentManager");
                    baseFullScreenDialog.show(parentFragmentManager2, "fans_club_dialog");
                }
            }
            a(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_CLUB_CLICK);
            return;
        }
        int i4 = R.id.tv_follow;
        if (valueOf != null && valueOf.intValue() == i4) {
            YYUserInfo yYUserInfo6 = this.k;
            if (!TextUtils.equals(r0, yYUserInfo6 == null ? null : yYUserInfo6.relationship)) {
                YYUserInfo yYUserInfo7 = this.k;
                if (!TextUtils.equals(r0, yYUserInfo7 == null ? null : yYUserInfo7.relationship)) {
                    a(false);
                    k();
                    return;
                }
            }
            a(true);
            YYRoomInfoManager e = YYRoomInfoManager.e();
            Context context3 = getContext();
            YYUserInfo yYUserInfo8 = this.k;
            String uid = yYUserInfo8 == null ? null : yYUserInfo8.getUid();
            BaseYYStudioFragment baseYYStudioFragment2 = this.i;
            if (baseYYStudioFragment2 != null) {
                activityFragmentActive = baseYYStudioFragment2.getFragmentActive();
            }
            e.b(context3, uid, "", activityFragmentActive);
            return;
        }
        int i5 = R.id.iv_more;
        if (valueOf != null && valueOf.intValue() == i5) {
            BaseYYStudioFragment baseYYStudioFragment3 = this.i;
            if (baseYYStudioFragment3 == null) {
                return;
            }
            baseYYStudioFragment3.a(this.k);
            return;
        }
        int i6 = R.id.yy_base_head;
        if (valueOf != null && valueOf.intValue() == i6) {
            a(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_GO_CLICK);
            YYUserInfo yYUserInfo9 = this.k;
            if (yYUserInfo9 != null) {
                YYRoomInfoManager.e().c().a(getContext(), yYUserInfo9.getUid(), yYUserInfo9.getName(), yYUserInfo9.getAvatar(), yYUserInfo9.vbadge, 2);
            }
            BaseYYStudioFragment baseYYStudioFragment4 = this.i;
            if (baseYYStudioFragment4 != null) {
                baseYYStudioFragment4.onBackPressed();
            }
            BaseYYStudioFragment baseYYStudioFragment5 = this.i;
            if (baseYYStudioFragment5 == null || (activity = baseYYStudioFragment5.getActivity()) == null) {
                return;
            }
            activity.finish();
            return;
        }
        int i7 = R.id.rl_relationship;
        if (valueOf != null && valueOf.intValue() == i7) {
            f();
            a(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_RELATION_CLICK);
            return;
        }
        int i8 = R.id.rl_cp;
        if (valueOf != null && valueOf.intValue() == i8) {
            e();
            a(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_RELATION_CLICK);
            return;
        }
        int i9 = R.id.con_gift;
        if (valueOf != null && valueOf.intValue() == i9) {
            YYRoomModel b2 = YYRoomInfoManager.e().b();
            if (b2 != null && this.k != null) {
                ChatRoomProtos.Event event = ChatRoomProtos.Event.PROFILE_GIFT_WALL_CLICK;
                String str = b2.room_id;
                String str2 = b2.uid;
                YYUserInfo yYUserInfo10 = this.k;
                EventTrackYY.l(event, str, str2, yYUserInfo10 == null ? null : yYUserInfo10.getUid());
            }
            LiveEventBus.get("into_gift_wall").post(this.k);
            this.f18532a.X.setVisibility(8);
            SharedPreferencesUtils.b().edit().putBoolean("tv_red_gift_wall", true).apply();
            return;
        }
        int i10 = R.id.con_medal;
        if (valueOf != null && valueOf.intValue() == i10) {
            if (this.i == null) {
                return;
            }
            YYUserInfo yYUserInfo11 = this.k;
            if (yYUserInfo11 != null) {
                YYMedalListDialog yYMedalListDialog = new YYMedalListDialog();
                BaseYYStudioFragment fragment6 = getFragment();
                Intrinsics.a(fragment6);
                yYMedalListDialog.a(yYUserInfo11, fragment6);
                BaseYYStudioFragment fragment7 = getFragment();
                Intrinsics.a(fragment7);
                FragmentManager childFragmentManager = fragment7.getChildFragmentManager();
                Intrinsics.c(childFragmentManager, "fragment!!.childFragmentManager");
                yYMedalListDialog.show(childFragmentManager, "YYMedalListDialog");
            }
            a(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_MEDAL_CLICK);
            return;
        }
        int i11 = R.id.rl_exhibition;
        if (valueOf != null && valueOf.intValue() == i11) {
            YYRoomModel b3 = YYRoomInfoManager.e().b();
            if (b3 != null) {
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_MADE_CAR_CLICK, b3.room_id, b3.uid);
            }
            BaseYYStudioFragment baseYYStudioFragment6 = this.i;
            if (baseYYStudioFragment6 == null) {
                return;
            }
            YYUserInfo userModel = getUserModel();
            String uid2 = userModel == null ? null : userModel.getUid();
            YYUserInfo userModel2 = getUserModel();
            YYDecorateCarDialog yYDecorateCarDialog = new YYDecorateCarDialog(uid2, userModel2 == null ? null : userModel2.getName(), 1, baseYYStudioFragment6);
            FragmentManager childFragmentManager2 = baseYYStudioFragment6.getChildFragmentManager();
            Intrinsics.c(childFragmentManager2, "it.childFragmentManager");
            yYDecorateCarDialog.show(childFragmentManager2, "dialog_decorate_exhibition");
            return;
        }
        int i12 = R.id.rl_travel;
        if (valueOf == null || valueOf.intValue() != i12 || (baseYYStudioFragment = this.i) == null) {
            return;
        }
        YYRomanticGuidebookDialog yYRomanticGuidebookDialog = new YYRomanticGuidebookDialog();
        Bundle bundleOf = BundleKt.bundleOf(new Pair[0]);
        YYUserInfo userModel3 = getUserModel();
        bundleOf.putString("user_id", userModel3 == null ? null : userModel3.getUid());
        YYUserInfo userModel4 = getUserModel();
        bundleOf.putString("user_name", userModel4 == null ? null : userModel4.getName());
        yYRomanticGuidebookDialog.setArguments(bundleOf);
        FragmentManager childFragmentManager3 = baseYYStudioFragment.getChildFragmentManager();
        Intrinsics.c(childFragmentManager3, "it.childFragmentManager");
        yYRomanticGuidebookDialog.show(childFragmentManager3, "guidebook_dialog");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        YYObserverManager.a().b(this);
        LiveEventBus.get("YYSuccessPasswordEvent", String.class).removeObserver(this.l);
        LiveEventBus.get("take_off_mask", String.class).removeObserver(this.l);
    }

    protected final void setFragment(BaseYYStudioFragment baseYYStudioFragment) {
        this.i = baseYYStudioFragment;
    }

    public final void setMPopYyDialog(PopYyDialog popYyDialog) {
        this.b = popYyDialog;
    }

    protected final void setURole(String str) {
        this.j = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setUserModel(YYUserInfo yYUserInfo) {
        this.k = yYUserInfo;
    }
}
