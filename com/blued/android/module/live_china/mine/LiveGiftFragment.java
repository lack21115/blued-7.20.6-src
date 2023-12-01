package com.blued.android.module.live_china.mine;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.common.model.CountModel;
import com.blued.android.module.common.model.LiveChargeCouponModel;
import com.blued.android.module.common.model.LiveDefaultGiftModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.ReflectionUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.CircleProgressView;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live.base.fragment.LiveGiftBaseFragment;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live.base.model.BasePayRemaining;
import com.blued.android.module.live.base.model.CommonLiveGiftModel;
import com.blued.android.module.live.base.model.LiveGiftNumberModel;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.mine.LiveGiftFragment;
import com.blued.android.module.live_china.mine.backpack.LiveGiftBackpackFragment;
import com.blued.android.module.live_china.model.DefinedRankInfo;
import com.blued.android.module.live_china.model.GiftConstellationBuyInfoModel;
import com.blued.android.module.live_china.model.LiveBunchLightModel;
import com.blued.android.module.live_china.model.LiveCouponNoticeExtra;
import com.blued.android.module.live_china.model.LiveDefinedRankModel;
import com.blued.android.module.live_china.model.LiveEffectModel;
import com.blued.android.module.live_china.model.LiveGiftAdvancedModel;
import com.blued.android.module.live_china.model.LiveGiftBagModel;
import com.blued.android.module.live_china.model.LiveGiftBlindBoxModel;
import com.blued.android.module.live_china.model.LiveGiftExtra;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveGiftOperateIconModel;
import com.blued.android.module.live_china.model.LiveGiftPackageModel;
import com.blued.android.module.live_china.model.LiveGiftSetBuyModel;
import com.blued.android.module.live_china.model.LiveGiftSetInfoModel;
import com.blued.android.module.live_china.model.LiveGiftSetItemModel;
import com.blued.android.module.live_china.model.LiveGiftSkinItemModel;
import com.blued.android.module.live_china.model.LiveGoodsBehalfExtra;
import com.blued.android.module.live_china.model.LiveImgModel;
import com.blued.android.module.live_china.model.LiveLevelInfoModel;
import com.blued.android.module.live_china.model.LiveLevelModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomFunctionItemModel;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.model.PayResultEvent;
import com.blued.android.module.live_china.model.ReChargeGift;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveFansObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.same.tip.CommonShowBottomWindow;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BubbleLayout;
import com.blued.android.module.live_china.view.LiveGiftBlindboxBarView;
import com.blued.android.module.live_china.view.LiveGiftConstellationView;
import com.blued.android.module.live_china.view.LiveGiftRandomBarView;
import com.blued.android.module.live_china.view.LiveGiftSetBannerView;
import com.blued.android.module.live_china.view.LiveGiftSetComboView;
import com.blued.android.module.live_china.view.LiveRechargeGiftBagView;
import com.blued.android.module.live_china.view.PopActionSheet;
import com.blued.android.module.media.selector.view.ActionSheet;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.EventBusConstant;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftFragment.class */
public class LiveGiftFragment extends LiveGiftBaseFragment implements View.OnClickListener {
    protected ViewGroup C;
    protected ViewGroup D;
    protected View E;
    public BaseFragment F;
    private TextView G;
    private LinearLayout H;
    private TextView I;
    private LinearLayout J;
    private FrameLayout K;
    private ImageView L;
    private ImageView M;
    private View N;
    private TextView O;
    private TextView P;
    private View Q;
    private View R;
    private ImageView S;
    private TextView T;
    private ProgressBar U;
    private TextView V;
    private TextView W;
    private View X;
    private View Y;
    private TextView Z;
    private View aA;
    private RecyclerView aB;
    private CommonRecycleAdapter<LiveDefinedRankModel> aC;
    private String aD;
    private String aE;
    private String aF;
    private LiveLevelInfoModel aG;
    private LiveGiftModel aH;
    private CountDownTimer aI;
    private String aM;
    private String aN;
    private Dialog aP;
    private FrameLayout aU;
    private ShapeTextView aW;
    private LiveGiftSetComboView aX;
    private LiveGiftSetBannerView aY;
    private LiveGiftRandomBarView aZ;
    private ProgressBar aa;
    private TextView ab;
    private TextView ac;
    private View ad;
    private View ae;
    private ImageView af;
    private View ag;
    private TextView ah;
    private View ai;
    private ImageView aj;
    private View ak;
    private View al;
    private View am;
    private View an;
    private View ao;
    private View ap;
    private ImageView aq;

    /* renamed from: ar  reason: collision with root package name */
    private ImageView f13829ar;
    private View as;
    private View at;
    private TextView au;
    private CircleProgressView av;
    private BubbleLayout aw;
    private FrameLayout ax;
    private ImageView ay;
    private ImageView az;
    private LiveGiftBlindboxBarView ba;
    private LiveGiftConstellationView bb;
    private View bc;
    private String bd;
    private String be;
    private String bf;
    private ImageView bg;
    private ImageView bh;
    private ImageView bi;
    private TextView bj;
    private TextView bk;
    private FrameLayout bl;
    private ShapeLinearLayout bm;
    private String bn;
    private LiveGoodsBehalfExtra bq;
    private WeakReference<LiveGiftBackpackFragment> bv;
    private List<CommonGiftPackageModel> aJ = new ArrayList();
    private List<CommonGiftPackageModel> aK = new ArrayList();
    private boolean aL = false;
    private int aO = 15;
    private boolean aQ = false;
    private String aR = "#3494f4";
    private Object aS = null;
    private boolean aT = true;
    private Boolean aV = false;
    private Observer<LiveGiftSetBuyModel> bo = new Observer<LiveGiftSetBuyModel>() { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.3
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(LiveGiftSetBuyModel liveGiftSetBuyModel) {
            LiveGiftFragment.this.a(liveGiftSetBuyModel);
        }
    };
    private Observer<Integer> bp = new Observer<Integer>() { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.4
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(Integer num) {
            LiveGiftFragment.this.d(num.intValue());
        }
    };
    private long br = 0;
    private ConcurrentLinkedQueue<String> bs = new ConcurrentLinkedQueue<>();
    private boolean bt = false;
    private boolean bu = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.mine.LiveGiftFragment$15  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftFragment$15.class */
    public class AnonymousClass15 extends BluedUIHttpResponse<BluedEntity<LiveGiftPackageModel, LiveGiftExtra>> {
        AnonymousClass15(IRequestHost iRequestHost) {
            super(iRequestHost);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(BluedEntity bluedEntity) {
            LiveGiftFragment.this.a((BluedEntity<LiveGiftPackageModel, LiveGiftExtra>) bluedEntity);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(final BluedEntity<LiveGiftPackageModel, LiveGiftExtra> bluedEntity) {
            if (!LiveGiftFragment.this.j() || LiveGiftFragment.this.isHidden()) {
                return;
            }
            if (bluedEntity != null && bluedEntity.extra != null) {
                LiveGiftFragment.this.bd = bluedEntity.extra.noble_url;
                LiveGiftFragment.this.be = bluedEntity.extra.banner;
            }
            if (bluedEntity == null || bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                LogUtils.c("从网络获取礼物列表失败 无数据");
            } else if (LiveGiftFragment.this.J != null) {
                LiveGiftFragment.this.J.post(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$15$ejuaC2Ori57bPUsXBL-UjU57M4A
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveGiftFragment.AnonymousClass15.this.a(bluedEntity);
                    }
                });
            } else {
                LiveGiftFragment.this.a(bluedEntity);
            }
            if (bluedEntity == null || bluedEntity.extra == null) {
                return;
            }
            LiveGiftFragment.this.bf = bluedEntity.extra.banner_redirect;
            LiveGoodsBehalfExtra liveGoodsBehalfExtra = bluedEntity.extra.behalf;
            if (liveGoodsBehalfExtra != null) {
                LiveGiftFragment.this.a(liveGoodsBehalfExtra);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.mine.LiveGiftFragment$2  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftFragment$2.class */
    public class AnonymousClass2 extends CommonRecycleAdapter<LiveDefinedRankModel> {
        AnonymousClass2(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(boolean z, LiveDefinedRankModel liveDefinedRankModel, View view) {
            if (z) {
                LiveRoomManager.a().b((String) null);
                LiveEventBusUtil.a((String) null);
            } else {
                LiveRoomManager.a().b(liveDefinedRankModel.title);
                LiveEventBusUtil.a(liveDefinedRankModel.title);
            }
            notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(final LiveDefinedRankModel liveDefinedRankModel, int i, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
            boolean endsWith = TextUtils.isEmpty(LiveRoomManager.a().O()) ? false : LiveRoomManager.a().O().endsWith(liveDefinedRankModel.title);
            final boolean z = endsWith;
            commonAdapterHolder.d(R.id.item_live_gift_defined_rank_state, endsWith ? R.drawable.item_live_gift_defined_rank_avatar_bg : R.color.transparent).a(R.id.item_live_gift_defined_rank_avatar, liveDefinedRankModel.image, 10.0f, R.drawable.channel_default_head).a(R.id.item_live_gift_defined_rank_name, liveDefinedRankModel.title).c(R.id.item_live_gift_defined_rank_name, endsWith ? R.drawable.gradient_922cee_ff3aaa : R.drawable.live_gift_defined_rank_name_bg).a().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$2$voQqI-wOBFfE_r-5X9G2fwAjjK8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGiftFragment.AnonymousClass2.this.a(z, liveDefinedRankModel, view);
                }
            });
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return R.layout.item_live_gift_defined_rank;
        }
    }

    private void B() {
        this.bl = (FrameLayout) this.rootView.findViewById(R.id.fl_gift_behalf_layout);
        this.bm = (ShapeLinearLayout) this.rootView.findViewById(R.id.rl_behalf_status);
        this.bg = (ImageView) this.rootView.findViewById(R.id.img_behalf_user_avatar);
        this.bh = (ImageView) this.rootView.findViewById(R.id.img_gift_behalf_status);
        this.bi = (ImageView) this.rootView.findViewById(R.id.img_behalf_qa);
        this.bj = (TextView) this.rootView.findViewById(R.id.tv_behalf_user_name);
        this.bk = (TextView) this.rootView.findViewById(R.id.tv_gift_behalf_status);
    }

    private void C() {
        this.aA = this.rootView.findViewById(R.id.live_gift_defined_rank_layout);
        RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(R.id.live_gift_defined_rank_rv);
        this.aB = recyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.aB.getContext());
        this.aC = anonymousClass2;
        this.aB.setAdapter(anonymousClass2);
    }

    private void D() {
        ViewGroup viewGroup = this.D;
        if (viewGroup == null || this.az == null) {
            return;
        }
        l(viewGroup.getWidth() < this.az.getWidth() ? 0 : LiveRoomManager.a().p().rechargeGiftBagIconShowType);
    }

    private void E() {
        if (this.aH.is_my == 1) {
            if (this.aH.effect == null || this.aH.effect.size() <= 0) {
                if (this.aH.is_use == 1) {
                    a(3, new String[]{this.aF, this.aE});
                } else {
                    a(4, new String[]{this.aF, this.aD});
                }
            } else if (this.aH.is_use == 1) {
                a(1, d(false));
            } else {
                a(2, d(true));
            }
        } else if (this.aH.effect == null) {
        } else {
            String[] strArr = new String[this.aH.effect.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aH.effect.size()) {
                    a(5, strArr);
                    return;
                }
                strArr[i2] = String.format(getResources().getString(R.string.bug_1_months), String.valueOf(this.aH.effect.get(i2).expire)) + "(" + CommonStringUtils.a(this.aH.effect.get(i2).beans) + getResources().getString(R.string.Live_SendPresent_wandou) + ")";
                i = i2 + 1;
            }
        }
    }

    private void F() {
        this.o.setText(String.valueOf(k()));
        LiveGiftModel liveGiftModel = this.aH;
        if (liveGiftModel == null || liveGiftModel.selectNumModel == null) {
            this.o.setTextColor(Color.parseColor("#8A8A8A"));
            this.q.setAlpha(0.15f);
        } else {
            this.o.setTextColor(getResources().getColor(R.color.syc_dark_b));
            this.q.setAlpha(1.0f);
        }
        O();
    }

    private void G() {
        LiveGiftModel liveGiftModel = this.aH;
        if (liveGiftModel == null || liveGiftModel.effectModel == null) {
            return;
        }
        CommonAlertDialog.a(getActivity(), "", String.format(getString(R.string.verify_purchase_mounts), String.valueOf(this.aH.effectModel.expire), this.aH.name), getString(R.string.verify_purchase), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                LiveGiftFragment.this.H();
            }
        }, getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        LiveGiftModel liveGiftModel;
        boolean z;
        boolean z2;
        boolean z3;
        LogUtils.c("selectedItemIndex: " + this.f10812c);
        if (TextUtils.isEmpty(this.f10812c) || (liveGiftModel = (LiveGiftModel) a(this.f10812c)) == null || liveGiftModel.sendGiftStatus == 1) {
            return;
        }
        liveGiftModel.sendGiftStatus = 1;
        liveGiftModel.effectModel = this.aH.effectModel;
        a((CommonLiveGiftModel) liveGiftModel);
        LiveRoomData p = LiveRoomManager.a().p();
        if (p != null) {
            BaseFragment baseFragment = this.F;
            if (baseFragment instanceof PlayingOnliveFragment) {
                z3 = ((PlayingOnliveFragment) baseFragment).r();
                z2 = ((PlayingOnliveFragment) this.F).z();
                z = ((PlayingOnliveFragment) this.F).aC();
            } else {
                z = false;
                z2 = false;
                z3 = false;
            }
            LiveGiftPackageModel liveGiftPackageModel = (LiveGiftPackageModel) b(liveGiftModel.index);
            LiveGoodsBehalfExtra liveGoodsBehalfExtra = this.bq;
            EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_PAGE_SEND_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), p.liveFrom, p.recommendType, p.livePosition, liveGiftModel.goods_id, k(), (int) (liveGiftModel.beans * k()), liveGiftPackageModel != null ? liveGiftPackageModel.type_name : "", liveGiftModel.pageIndex + 1, liveGiftModel.positionInPage + 1, z2, z3, z ? LiveProtos.LiveType.BLIND_DATING_LIVE : LiveProtos.LiveType.SHOW_LIVE, "gift_bar", liveGiftModel.isScrawlGift(), liveGiftModel.isMp4, false, 0L, "", (liveGoodsBehalfExtra == null || liveGoodsBehalfExtra.getStatus() != 1) ? "" : this.bq.getTarget_uid(), liveGiftModel.random != null);
        }
        a(liveGiftModel, 1, "", false);
    }

    private void I() {
        LiveGiftModel liveGiftModel = this.aH;
        if (liveGiftModel == null || liveGiftModel.ops == 5) {
            return;
        }
        EventTrackLive.a(LiveProtos.Event.USER_LIVE_GIFT_BTN_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this.aH.goods_id, k());
        if (this.aH.is_join_ticket == 1 && LiveRoomManager.a().q() != null && LiveRoomManager.a().q().fans_status == 0) {
            CommonAlertDialog.a(getActivity(), "", String.format(getResources().getString(R.string.live_fans_name_join_tip), String.valueOf(this.aH.beans)), getResources().getString(R.string.sure), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$OgSK8IfQAAOdn27F-vIOAkCeHR0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    LiveGiftFragment.this.a(dialogInterface, i);
                }
            }, getResources().getString(R.string.live_fans_quit_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        } else {
            J();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        LiveGiftModel liveGiftModel;
        boolean z;
        boolean z2;
        boolean z3;
        View view;
        LogUtils.c("selectedItemIndex: " + this.f10812c);
        if (TextUtils.isEmpty(this.f10812c) || (liveGiftModel = (LiveGiftModel) a(this.f10812c)) == null || liveGiftModel.ops == 5 || liveGiftModel.ops == 1101) {
            return;
        }
        LogUtils.c("selectedModel: " + liveGiftModel.toString());
        if (liveGiftModel.double_hit == 1) {
            String str = this.y != null ? this.y.goods_id : "";
            if (liveGiftModel.selectNumModel != null && liveGiftModel.selectNumModel.count > 1) {
                liveGiftModel.hit_id = 0L;
            } else if (!StringUtils.a(str, liveGiftModel.goods_id) || this.u <= 0 || liveGiftModel.comboWaitTime <= 0) {
                liveGiftModel.hit_id = System.currentTimeMillis();
                liveGiftModel.hit_count = 0;
                LogUtils.c("连击: 生成一个新的 hitId = " + liveGiftModel.hit_id);
            } else {
                liveGiftModel.hit_id = this.u;
                LogUtils.c("连击: 判定为有效连击 mLastGiftModel.combo_id = " + liveGiftModel.hit_id);
            }
        }
        liveGiftModel.sendGiftStatus = 1;
        a((CommonLiveGiftModel) liveGiftModel);
        LiveRoomData p = LiveRoomManager.a().p();
        BaseFragment baseFragment = this.F;
        if (baseFragment instanceof PlayingOnliveFragment) {
            z3 = ((PlayingOnliveFragment) baseFragment).r();
            z2 = ((PlayingOnliveFragment) this.F).z();
            z = ((PlayingOnliveFragment) this.F).aC();
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        LiveGiftPackageModel liveGiftPackageModel = (LiveGiftPackageModel) b(liveGiftModel.index);
        LiveGoodsBehalfExtra liveGoodsBehalfExtra = this.bq;
        String target_uid = (liveGoodsBehalfExtra == null || liveGoodsBehalfExtra.getStatus() != 1) ? "" : this.bq.getTarget_uid();
        EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_PAGE_SEND_CLICK, String.valueOf(p.lid), LiveRoomManager.a().g(), p.liveFrom, p.recommendType, p.livePosition, liveGiftModel.goods_id, k(), (int) (liveGiftModel.beans * k()), liveGiftPackageModel != null ? liveGiftPackageModel.type_name : "", liveGiftModel.pageIndex + 1, liveGiftModel.positionInPage + 1, z2, z3, z ? LiveProtos.LiveType.BLIND_DATING_LIVE : LiveProtos.LiveType.SHOW_LIVE, this.aL ? "gift_pack" : "gift_bar", liveGiftModel.isScrawlGift(), liveGiftModel.isMp4, liveGiftModel.hit_count > 0, liveGiftModel.skin_on_use != null ? liveGiftModel.skin_on_use.goods_skin_id : 0L, K(), target_uid, liveGiftModel.random != null);
        a(liveGiftModel, k(), "", false);
        if (!liveGiftModel.isScrawlGift() || (view = this.al) == null) {
            return;
        }
        view.setVisibility(8);
        this.rootView.setBackgroundResource(R.color.transparent);
    }

    private String K() {
        return LiveRoomManager.a().O();
    }

    private void L() {
        LiveGiftModel liveGiftModel = this.aH;
        if (liveGiftModel == null || liveGiftModel.ops == 5 || this.aH.ops == 1101 || this.aH.ops == 1102 || this.aH.ops == 1103) {
            return;
        }
        b(this.aH);
    }

    private void M() {
        Object obj = this.aS;
        if (obj != null && (obj instanceof LiveChargeCouponModel) && this.b.size() > 0) {
            if (((CommonGiftPackageModel) this.b.get(0)).isBag) {
                Iterator it = this.b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CommonGiftPackageModel commonGiftPackageModel = (CommonGiftPackageModel) it.next();
                    if (commonGiftPackageModel.packageType == 5) {
                        Iterator it2 = commonGiftPackageModel.goods.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            LiveGiftModel liveGiftModel = (LiveGiftModel) it2.next();
                            if (StringUtils.a(liveGiftModel.goods_id, String.valueOf(((LiveChargeCouponModel) this.aS).id))) {
                                this.aN = liveGiftModel.index;
                                break;
                            }
                        }
                    }
                }
                this.aS = null;
                LogUtils.c("showDefaultJumpIndex: " + this.aN);
                a((LiveDefaultGiftModel) null);
                c(this.aN);
                return;
            }
            return;
        }
        Object obj2 = this.aS;
        if (obj2 == null || !(obj2 instanceof LiveDefaultGiftModel) || this.b.size() <= 0) {
            if (this.aL) {
                a((LiveDefaultGiftModel) null);
                return;
            }
            if (this.aM == null) {
                this.aM = b();
            }
            U();
            return;
        }
        LiveDefaultGiftModel liveDefaultGiftModel = (LiveDefaultGiftModel) this.aS;
        Iterator it3 = this.b.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            for (LiveGiftModel liveGiftModel2 : ((CommonGiftPackageModel) it3.next()).goods) {
                if (StringUtils.a(liveGiftModel2.goods_id, String.valueOf(liveDefaultGiftModel.id))) {
                    if (liveDefaultGiftModel.is_bag) {
                        this.aN = liveGiftModel2.index;
                    } else {
                        this.aM = liveGiftModel2.index;
                    }
                }
            }
        }
        this.aS = null;
        LogUtils.c("showDefaultJumpIndex: " + this.aN);
        if (liveDefaultGiftModel.is_bag) {
            a(liveDefaultGiftModel);
        } else {
            U();
        }
        c(this.f10812c);
    }

    private void N() {
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        if (this.aG == null) {
            return;
        }
        TextView textView = this.Z;
        textView.setText("Lv." + LiveUtils.a(this.aG.rich_level));
        this.ac.setSingleLine(true);
        this.ac.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.ac.setHorizontallyScrolling(true);
        this.ac.setMarqueeRepeatLimit(-1);
        this.ac.requestFocus();
        this.ac.setSelected(true);
        if (this.aG.next_rich_level == 0) {
            this.ab.setText("Lv.Max");
            this.aa.setProgress(100);
            this.ac.setText(R.string.live_gift_max_value);
            return;
        }
        TextView textView2 = this.ab;
        textView2.setText("Lv." + LiveUtils.b(this.aG.next_rich_level));
        if (Build.VERSION.SDK_INT >= 24) {
            this.aa.setProgress(LiveUtils.a(this.aG.rich_beans, this.aG.this_level_beans, this.aG.next_level_beans), true);
        } else {
            this.aa.setProgress(LiveUtils.a(this.aG.rich_beans, this.aG.this_level_beans, this.aG.next_level_beans));
        }
        int k = k();
        LiveGiftModel liveGiftModel = this.aH;
        if (liveGiftModel != null) {
            this.aa.setSecondaryProgress(LiveUtils.a(liveGiftModel.beans * k, this.aG.rich_beans, this.aG.this_level_beans, this.aG.next_level_beans));
            this.ac.setText(String.format(getString(R.string.live_gift_value_whole), b(((float) (this.aH.beans / 100.0d)) * k), b(this.aG.next_level_beans - this.aG.rich_beans)));
        }
    }

    private boolean P() {
        return (this.aH == null || this.R == null || this.aV.booleanValue() || this.aH.skin_status != 1 || this.aH.skin_on_process == null || TextUtils.isEmpty(this.aH.skin_on_process.goods_id)) ? false : true;
    }

    private void Q() {
        if (P()) {
            FrameLayout frameLayout = this.K;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            View view = this.R;
            if (view != null) {
                view.setVisibility(0);
            }
            if (s() != null) {
                s().i("gift_info_show");
            }
            S();
            ImageLoader.a(getFragmentActive(), this.aH.skin_on_process.images_static).b(R.drawable.gift_default_icon).a(this.S);
            if (this.aH.skin_on_process.level == 0) {
                this.T.setText("初始");
            } else {
                TextView textView = this.T;
                textView.setText("Lv." + this.aH.skin_on_process.level);
            }
            if (this.aH.skin_on_process.next_level == -1) {
                this.V.setText("Lv.Max");
                this.W.setText("最高级");
                this.U.setMax(100);
                this.U.setProgress(100);
            } else {
                TextView textView2 = this.V;
                textView2.setText("Lv." + this.aH.skin_on_process.next_level);
                TextView textView3 = this.W;
                textView3.setText(this.aH.skin_on_process.process + BridgeUtil.SPLIT_MARK + this.aH.skin_on_process.count);
                this.U.setMax(this.aH.skin_on_process.count);
                this.U.setProgress(this.aH.skin_on_process.process);
            }
            EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_SKIN_INTRODUCE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        }
    }

    private boolean R() {
        View view = this.aA;
        return view != null && view.getVisibility() == 0;
    }

    private void S() {
        if (this.J == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        this.J.post(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$Ku4qxUii_mqdCXOiLUCpLtvzgFI
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftFragment.this.a(currentTimeMillis);
            }
        });
    }

    private void T() {
        this.aI = new CountDownTimer(5000L, 1000L) { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.20
            @Override // android.os.CountDownTimer
            public void onFinish() {
                LiveGiftFragment.this.ag.setVisibility(8);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        }.start();
    }

    private void U() {
        this.aL = false;
        this.aV = false;
        V();
        r();
        this.f10812c = this.aM;
        b(this.aJ);
        this.ad.setVisibility(0);
    }

    private void V() {
        if (this.aL) {
            this.ah.setBackgroundResource(R.drawable.live_gift_switcher_selected);
            this.ah.setTextColor(getResources().getColor(R.color.white));
            return;
        }
        this.ah.setBackgroundResource(R.color.transparent);
        this.ah.setTextColor(getResources().getColor(R.color.syc_dark_j));
    }

    private void W() {
        if (this.ap.getAnimation() != null) {
            this.ap.getAnimation().reset();
            this.ap.getAnimation().cancel();
        }
        this.ap.clearAnimation();
        if (this.f13829ar.getAnimation() != null) {
            this.f13829ar.getAnimation().reset();
            this.f13829ar.getAnimation().cancel();
        }
        this.f13829ar.clearAnimation();
        this.ap.setScaleX(1.0f);
        this.ap.setScaleY(1.0f);
        this.ap.animate().scaleX(0.7f).scaleY(0.7f).setDuration(120L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$_H9ikM4PDoXbDojRZtkUTDgGkEI
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftFragment.this.ai();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X */
    public void aj() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setRepeatMode(2);
        scaleAnimation.setInterpolator(new LinearInterpolator());
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setDuration(320L);
        this.ap.startAnimation(scaleAnimation);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1200L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.f13829ar.startAnimation(rotateAnimation);
    }

    private void Y() {
        LogUtils.c("GiftCombo.startComboShowAnim: ");
        this.bt = true;
        this.C.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$Do5NBwMPxdUMr__v5NJ5xXVjcLE
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftFragment.this.ag();
            }
        }).start();
        this.an.setVisibility(0);
        this.an.setAlpha(1.0f);
        this.an.setScaleX(1.0f);
        this.an.setScaleY(1.0f);
        this.ap.setAlpha(0.0f);
        this.ap.setScaleX(0.0f);
        this.ap.setScaleY(0.0f);
        this.ap.animate().alpha(1.0f).scaleX(1.1f).scaleY(1.1f).setDuration(400L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$YryzuDtXNwCldPolgFH2d0eUyec
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftFragment.this.ae();
            }
        }).start();
        this.as.setTranslationY(0.0f);
        this.ao.setAlpha(0.0f);
        this.ao.animate().alpha(1.0f).setDuration(320L).setStartDelay(200L).start();
        this.at.setAlpha(0.0f);
        this.at.setScaleX(0.0f);
        this.at.setScaleY(0.0f);
        this.at.setTranslationY(0.0f);
        this.at.animate().alpha(1.0f).scaleX(1.1f).scaleY(1.1f).setDuration(400L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$wU3JUfpc8uowHI-1VPuE0CjJ-Co
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftFragment.this.ac();
            }
        }).start();
        this.au.setText(String.valueOf(1));
        EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_PAGE_SEND_CONTINUE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        LiveGiftSetComboView liveGiftSetComboView = this.aX;
        if (liveGiftSetComboView != null) {
            liveGiftSetComboView.e();
        }
        View view = this.an;
        if (view == null || view.getVisibility() == 8) {
            this.C.setVisibility(0);
            this.C.setAlpha(1.0f);
        }
    }

    private String a(float f) {
        return CommonStringUtils.d(Float.toString(f));
    }

    private List<CommonGiftPackageModel> a(List<LiveGiftPackageModel> list, boolean z) {
        if (list == null) {
            return new ArrayList();
        }
        List<CommonGiftPackageModel> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                d(arrayList);
                b(arrayList, z);
                return arrayList;
            }
            LiveGiftPackageModel liveGiftPackageModel = list.get(i2);
            liveGiftPackageModel.name = liveGiftPackageModel.type_name;
            liveGiftPackageModel.hasNew = liveGiftPackageModel.red_point == 1;
            if (liveGiftPackageModel.is_ar == 1) {
                liveGiftPackageModel.packageType = 1;
            } else if (liveGiftPackageModel.is_effect == 1) {
                liveGiftPackageModel.packageType = 2;
            }
            if (z) {
                liveGiftPackageModel.isBag = true;
                if ("".equalsIgnoreCase(liveGiftPackageModel.name)) {
                    liveGiftPackageModel.packageType = 3;
                    liveGiftPackageModel.deleteItemIfZeroCount = false;
                } else {
                    liveGiftPackageModel.packageType = -1;
                    liveGiftPackageModel.deleteItemIfZeroCount = true;
                }
            }
            arrayList.add(liveGiftPackageModel);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= liveGiftPackageModel.goods.size()) {
                    break;
                }
                LiveGiftModel liveGiftModel = (LiveGiftModel) liveGiftPackageModel.goods.get(i4);
                if (liveGiftModel != null && liveGiftModel.groups != null && liveGiftModel.groups.size() != 0) {
                    Iterator<LiveGiftNumberModel> it = liveGiftModel.groups.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!TextUtils.isEmpty(it.next().gift_pic_mp4)) {
                                liveGiftModel.isMp4 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                i3 = i4 + 1;
            }
            for (LiveGiftModel liveGiftModel2 : liveGiftPackageModel.goods) {
                if (liveGiftModel2.skin_on_process == null || liveGiftModel2.skin_on_process.goods_id == null) {
                    liveGiftModel2.skin_on_process = liveGiftModel2.skin_on_use;
                }
                if (liveGiftModel2.skin_on_use != null && liveGiftModel2.goods_id.equalsIgnoreCase(liveGiftModel2.skin_on_use.goods_id)) {
                    a(liveGiftModel2, liveGiftModel2.skin_on_use);
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, int i2, String str) {
        b(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final int i, View view) {
        LiveRoomHttpUtils.q(new BluedUIHttpResponse<BluedEntityA<ReChargeGift>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.24
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<ReChargeGift> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                LiveRoomManager.a().a(bluedEntityA.getSingleData(), false);
                LiveRoomPreferences.h(i);
                ImageLoader.a(LiveGiftFragment.this.getFragmentActive(), R.drawable.live_recharge_static).a(LiveGiftFragment.this.az);
                LiveRouteUtil.a((BaseFragment) LiveGiftFragment.this, false);
                EventTrackLive.d(LiveProtos.Event.LIVE_GIFT_POP_RESOURCE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), 2);
            }
        }, getFragmentActive());
    }

    private void a(final int i, String[] strArr) {
        if (strArr == null) {
            return;
        }
        int[] iArr = new int[strArr.length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= strArr.length) {
                break;
            }
            iArr[i3] = R.color.sara_a;
            i2 = i3 + 1;
        }
        if (LiveDataManager.a().f()) {
            PopActionSheet.a(getContext(), strArr, iArr, DensityUtils.a(getContext(), 300.0f), new PopActionSheet.PopSheetClickListner() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$PzMU4JdFtliNiRqPub4uXwKpPyQ
                @Override // com.blued.android.module.live_china.view.PopActionSheet.PopSheetClickListner
                public final void onClick(int i4, String str) {
                    LiveGiftFragment.this.a(i, i4, str);
                }
            });
        } else {
            CommonShowBottomWindow.a(getActivity(), strArr, this.aR, new ActionSheet.ActionSheetListener() { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.6
                @Override // com.blued.android.module.media.selector.view.ActionSheet.ActionSheetListener
                public void a(ActionSheet actionSheet, int i4) {
                    LiveGiftFragment.this.b(i, i4);
                }

                @Override // com.blued.android.module.media.selector.view.ActionSheet.ActionSheetListener
                public void a(ActionSheet actionSheet, boolean z) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(long j) {
        int i;
        if (j < this.br) {
            return;
        }
        int childCount = this.J.getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= childCount) {
                break;
            }
            View childAt = this.J.getChildAt(i2);
            int i4 = i;
            if (childAt != null) {
                i4 = i;
                if (childAt.hashCode() != this.ak.hashCode()) {
                    i4 = i;
                    if (childAt.getVisibility() == 0) {
                        i4 = i + childAt.getHeight() + ((LinearLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                    }
                }
            }
            i2++;
            i3 = i4;
        }
        if (i > 0) {
            i(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        boolean z;
        if (ClickUtils.a(view.getId(), 2000L) || s() == null) {
            return;
        }
        View view2 = this.al;
        if (view2 == null || view2.getVisibility() != 0) {
            ak();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CommonGiftPackageModel commonGiftPackageModel : this.aJ) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < commonGiftPackageModel.goods.size()) {
                    LiveGiftModel liveGiftModel = (LiveGiftModel) commonGiftPackageModel.goods.get(i2);
                    if (liveGiftModel != null && liveGiftModel.isScrawlGift()) {
                        Iterator<E> it = arrayList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (StringUtils.a(((LiveGiftModel) it.next()).goods_id, liveGiftModel.goods_id)) {
                                    z = true;
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                        if (!z) {
                            arrayList.add(liveGiftModel);
                        }
                    }
                    i = i2 + 1;
                }
            }
        }
        boolean r = s().r();
        boolean z2 = s().z();
        boolean aC = s().aC();
        PlayingOnliveFragment s = s();
        LiveGiftModel liveGiftModel2 = this.aH;
        LiveRouteUtil.a(s, arrayList, liveGiftModel2 != null ? liveGiftModel2.index : null, r, z2, aC, K());
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$0og8gEcXMglmFUol4sCRWFBmRnE
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftFragment.this.ak();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluedEntity<LiveGiftPackageModel, LiveGiftExtra> bluedEntity) {
        ShapeTextView shapeTextView;
        LogUtils.c("更新网络礼物列表");
        this.aJ.clear();
        this.aJ.addAll(a(bluedEntity.data, false));
        a(this.aJ);
        if (!this.aL) {
            b(this.aJ);
        }
        M();
        b(this.aH);
        LiveDataManager.a().a(h(), this.aJ);
        if (bluedEntity.extra == null || bluedEntity.extra.pack == null || bluedEntity.extra.pack.getRed_point() != 1 || (shapeTextView = this.aW) == null) {
            return;
        }
        shapeTextView.setVisibility(0);
    }

    private void a(CommonGiftPackageModel<LiveGiftModel> commonGiftPackageModel, LiveGiftSkinItemModel liveGiftSkinItemModel, boolean z) {
        if (commonGiftPackageModel == null || liveGiftSkinItemModel == null) {
            return;
        }
        if (commonGiftPackageModel.packageType == 0 || commonGiftPackageModel.packageType == 1 || commonGiftPackageModel.packageType == -1) {
            for (LiveGiftModel liveGiftModel : commonGiftPackageModel.goods) {
                if (StringUtils.a(liveGiftSkinItemModel.goods_id, liveGiftModel.goods_id)) {
                    a(liveGiftModel, liveGiftSkinItemModel);
                    if (z) {
                        a((CommonLiveGiftModel) liveGiftModel);
                        LogUtils.c("useGiftSkin in " + commonGiftPackageModel.name + ":" + liveGiftModel.index);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(GiftConstellationBuyInfoModel giftConstellationBuyInfoModel) {
        String goods_id = giftConstellationBuyInfoModel.getGoods_id();
        int parseInt = Integer.parseInt(giftConstellationBuyInfoModel.getCount());
        String goods_name = giftConstellationBuyInfoModel.getGoods_name();
        String image = giftConstellationBuyInfoModel.getImage();
        LiveGiftModel liveGiftModel = new LiveGiftModel();
        liveGiftModel.goods_id = goods_id;
        liveGiftModel.name = goods_name;
        liveGiftModel.images_static = image;
        a(liveGiftModel, parseInt, "", false);
    }

    private void a(LiveGiftModel liveGiftModel, int i, int i2) {
        if (this.ba.getGoodId().equals(liveGiftModel.goods_id)) {
            this.ba.a(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveGiftModel liveGiftModel, int i, int i2, String str) {
        LogUtils.c("buyGiftFail: " + liveGiftModel.toString() + ", giftCount:" + i + ", errorCode:" + i2 + ", errorMessage:" + str);
        liveGiftModel.sendGiftStatus = 2;
        a((CommonLiveGiftModel) liveGiftModel);
        StringBuilder sb = new StringBuilder();
        sb.append("buyGiftFail: ");
        sb.append(i2);
        sb.append(", msg: ");
        sb.append(str);
        LogUtils.c(sb.toString());
        switch (i2) {
            case 4221002:
                Bundle bundle = new Bundle();
                bundle.putSerializable("selected_model", liveGiftModel);
                bundle.putInt("gift_count", i);
                bundle.putString("title", getString(R.string.Live_SendPresent_resetPayPassword));
                bundle.putString("content", getString(R.string.live_set_6_num));
                bundle.putString("http_host", LiveRoomInfo.a().m());
                LiveRouteUtil.a(this, bundle, i2);
                return;
            case 4221003:
            case 4221006:
            case 4221007:
            default:
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                AppMethods.a((CharSequence) str);
                liveGiftModel.errorMessage = str;
                return;
            case 4221004:
            case 4221005:
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("selected_model", liveGiftModel);
                bundle2.putInt("gift_count", i);
                if (i2 == 4221005) {
                    bundle2.putString("title", getString(R.string.Live_SendPresent_verifyPassword));
                } else {
                    bundle2.putString("title", str);
                }
                bundle2.putString("content", getString(R.string.Live_SendPresent_verifyPasswordText));
                LiveRouteUtil.a(this, bundle2, i2);
                return;
            case 4221008:
                a(liveGiftModel);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveGiftModel liveGiftModel, View view) {
        d(liveGiftModel);
    }

    private void a(LiveGiftModel liveGiftModel, LiveGiftSkinItemModel liveGiftSkinItemModel) {
        if (liveGiftModel == null || liveGiftSkinItemModel == null || TextUtils.isEmpty(liveGiftSkinItemModel.images_static)) {
            return;
        }
        liveGiftModel.images_apng2 = liveGiftSkinItemModel.images_apng;
        liveGiftModel.images_gif = liveGiftSkinItemModel.images_gif;
        liveGiftModel.images_static = liveGiftSkinItemModel.images_static;
        liveGiftModel.images_mp4 = liveGiftSkinItemModel.images_mp4;
        liveGiftModel.skin_on_use = liveGiftSkinItemModel;
        liveGiftModel.animation = liveGiftSkinItemModel.animation;
    }

    private void a(LiveGiftModel liveGiftModel, boolean z) {
        if (this.aX == null) {
            return;
        }
        if (liveGiftModel == null || liveGiftModel.goods_set_info == null || !liveGiftModel.isGiftSet() || liveGiftModel.goods_set_info.getExpire_time() == 0) {
            Z();
            return;
        }
        this.C.setVisibility(8);
        this.aX.a(liveGiftModel.goods_set_info);
        this.aX.setEventCallBack(new LiveGiftSetComboView.EventCallBack() { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.21
            @Override // com.blued.android.module.live_china.view.LiveGiftSetComboView.EventCallBack
            public void a() {
                LiveGiftFragment.this.J();
            }

            @Override // com.blued.android.module.live_china.view.LiveGiftSetComboView.EventCallBack
            public void b() {
                if (LiveGiftFragment.this.aY != null) {
                    LiveGiftFragment.this.aY.b();
                }
                LiveGiftFragment.this.Z();
            }
        });
    }

    private void a(LiveGiftSetInfoModel liveGiftSetInfoModel) {
        if (liveGiftSetInfoModel == null) {
            return;
        }
        for (CommonGiftPackageModel commonGiftPackageModel : this.b) {
            for (LiveGiftModel liveGiftModel : commonGiftPackageModel.goods) {
                if (liveGiftModel.goods_set_info != null && liveGiftModel.isGiftSet() && liveGiftSetInfoModel != null && liveGiftModel.goods_set_info.getId() == liveGiftSetInfoModel.getId()) {
                    liveGiftModel.goods_set_info = liveGiftSetInfoModel;
                }
            }
        }
        if (liveGiftSetInfoModel.is_finish() == 1) {
            Z();
            LiveGiftSetComboView.f14486a.c(liveGiftSetInfoModel.getId());
        }
        LiveGiftSetComboView.f14486a.a(liveGiftSetInfoModel.getId(), liveGiftSetInfoModel.getExpire_time());
        LiveGiftModel liveGiftModel2 = this.aH;
        if (liveGiftModel2 == null || !liveGiftModel2.isGiftSet() || liveGiftSetInfoModel == null || this.aH.goods_set_info.getId() != liveGiftSetInfoModel.getId()) {
            return;
        }
        this.aH.goods_set_info = liveGiftSetInfoModel;
        a(this.aH, liveGiftSetInfoModel.is_finish() == 1);
        LiveGiftSetBannerView liveGiftSetBannerView = this.aY;
        if (liveGiftSetBannerView != null) {
            liveGiftSetBannerView.setVisibility(0);
            View view = this.bc;
            if (view != null) {
                this.aY.setGiftWindowHeight(view.getHeight());
            }
            this.aY.a(this.aH.goods_set_info, getFragmentActive(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final LiveGoodsBehalfExtra liveGoodsBehalfExtra) {
        if (liveGoodsBehalfExtra.getStatus() == 2) {
            this.bl.setVisibility(8);
            return;
        }
        this.bq = liveGoodsBehalfExtra;
        FrameLayout frameLayout = this.K;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        this.bi.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$SOoaH7NTm8XEEnJfOax2Bo5uYis
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftFragment.this.a(liveGoodsBehalfExtra, view);
            }
        });
        int i = 0;
        this.bl.setVisibility(0);
        ImageLoader.a(getFragmentActive(), liveGoodsBehalfExtra.getTarget_avatar()).b(R.drawable.live_rank_hour_default_avatar).c().a(this.bg);
        this.bj.setText(liveGoodsBehalfExtra.getTarget_username());
        ShapeModel shapeModel = this.bm.getShapeModel();
        if (liveGoodsBehalfExtra.getStatus() == 0) {
            this.bh.setImageResource(R.drawable.img_behalf_gift_disnabel);
            shapeModel.k = getResources().getColor(R.color.color_434343);
            shapeModel.t = 0;
            shapeModel.v = 0;
            this.bk.setText(liveGoodsBehalfExtra.getSwitch_disable_name());
            this.bk.setTextColor(getResources().getColor(R.color.anythink_color_999999));
        } else if (liveGoodsBehalfExtra.getStatus() == 1) {
            this.bh.setImageResource(R.drawable.img_behalf_gift_enabel);
            shapeModel.k = 0;
            shapeModel.t = getResources().getColor(R.color.syc_dark_FF3AAA);
            shapeModel.v = getResources().getColor(R.color.syc_dark_922CEE);
            this.bk.setText(liveGoodsBehalfExtra.getSwitch_enable_name());
            this.bk.setTextColor(getResources().getColor(R.color.white));
        }
        this.bm.setShapeModel(shapeModel);
        if (liveGoodsBehalfExtra.getStatus() == 0) {
            i = 1;
        }
        final int i2 = i;
        this.bm.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$v_NKLWs3QlFs6f5VbIbCZY7PQuw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftFragment.this.a(liveGoodsBehalfExtra, i2, view);
            }
        });
    }

    private void a(final LiveGoodsBehalfExtra liveGoodsBehalfExtra, final int i) {
        EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_POP_SUBSTITUTE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), i == 0 ? 1 : 0);
        LiveRoomHttpUtils.a(liveGoodsBehalfExtra.getTarget_uid(), LiveRoomManager.a().g(), LiveRoomManager.a().e(), i, new BluedUIHttpResponse<BluedEntityA>() { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.17
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA bluedEntityA) {
                ToastUtils.a(bluedEntityA.message);
                liveGoodsBehalfExtra.setStatus(i);
                LiveGiftFragment.this.a(liveGoodsBehalfExtra);
            }
        }, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveGoodsBehalfExtra liveGoodsBehalfExtra, int i, View view) {
        a(liveGoodsBehalfExtra, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveGoodsBehalfExtra liveGoodsBehalfExtra, View view) {
        CommonAlertDialog.a((Context) getActivity(), liveGoodsBehalfExtra.getPopover_title(), liveGoodsBehalfExtra.getPopover_desc(), getString(R.string.common_ok), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null, 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PayResultEvent payResultEvent) {
        if (payResultEvent == null || !payResultEvent.flag) {
            return;
        }
        al();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        ShapeTextView shapeTextView = this.aW;
        if (shapeTextView != null) {
            shapeTextView.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Integer num) {
        LiveDefaultGiftModel liveDefaultGiftModel = new LiveDefaultGiftModel();
        liveDefaultGiftModel.id = num.intValue();
        liveDefaultGiftModel.is_bag = false;
        a((Object) liveDefaultGiftModel);
        this.aH.goods_id = num.toString();
        I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Long l) {
        LiveGoodsBehalfExtra liveGoodsBehalfExtra;
        FrameLayout frameLayout;
        if (this.bl.getVisibility() == 8 || (liveGoodsBehalfExtra = this.bq) == null || !liveGoodsBehalfExtra.getTarget_uid().equals(l.toString()) || (frameLayout = this.bl) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    private void a(String str, String str2, String str3) {
        this.aV = true;
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        int i = 0;
        this.aU.setVisibility(0);
        View view = this.ad;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = this.R;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        this.bv = new WeakReference<>((LiveGiftBackpackFragment) getChildFragmentManager().findFragmentByTag("LiveGiftBackpack"));
        Bundle bundle = new Bundle();
        bundle.putString("from", str);
        bundle.putString("target_uid", str3);
        bundle.putString("goods_id", str2);
        if (this.bv.get() == null) {
            WeakReference<LiveGiftBackpackFragment> weakReference = new WeakReference<>(new LiveGiftBackpackFragment());
            this.bv = weakReference;
            weakReference.get().setArguments(bundle);
            beginTransaction.add(R.id.fl_live_gift_backpack, this.bv.get(), "LiveGiftBackpack");
        } else {
            if (this.bv.get().getArguments() != null) {
                this.bv.get().getArguments().putString("from", str);
                this.bv.get().getArguments().putString("target_uid", str3);
                this.bv.get().getArguments().putString("goods_id", str2);
            } else {
                this.bv.get().setArguments(bundle);
            }
            beginTransaction.show(this.bv.get());
        }
        try {
            beginTransaction.commitNowAllowingStateLoss();
        } catch (Exception e) {
        }
        LiveProtos.Event event = LiveProtos.Event.LIVE_GIFT_POP_GIFT_TAB_SHOW;
        String e2 = LiveRoomManager.a().e();
        String g = LiveRoomManager.a().g();
        LiveGoodsBehalfExtra liveGoodsBehalfExtra = this.bq;
        if (liveGoodsBehalfExtra != null) {
            i = liveGoodsBehalfExtra.getStatus();
        }
        EventTrackLive.a(event, e2, g, i);
    }

    private boolean a(LiveGiftModel liveGiftModel, PayRemaining payRemaining, LiveZanExtraModel liveZanExtraModel, int i) {
        liveGiftModel.sendGiftStatus = 3;
        liveGiftModel.hit_id = payRemaining.hit_id;
        liveGiftModel.beans_count = payRemaining.beans_count;
        liveGiftModel.beans_current_count = payRemaining.beans_current;
        liveGiftModel.free_number = payRemaining.free_number;
        liveGiftModel.bonus = payRemaining.bonus;
        liveGiftModel.animation = payRemaining.animation;
        boolean z = false;
        if (liveZanExtraModel != null) {
            LogUtils.c("updateGiftValue: " + liveZanExtraModel.toString());
            if (liveZanExtraModel.skin_on_process != null && liveZanExtraModel.skin_on_process.goods_id != null) {
                liveGiftModel.skin_on_process = liveZanExtraModel.skin_on_process;
            }
            if (this.aH != null && liveZanExtraModel.skin_on_process != null && StringUtils.a(this.aH.goods_id, liveGiftModel.goods_id) && liveZanExtraModel.skin_on_process.goods_id != null) {
                this.aH.skin_on_process = liveZanExtraModel.skin_on_process;
                L();
            }
            LiveGiftModel liveGiftModel2 = this.aH;
            if (liveGiftModel2 != null && liveGiftModel2.skin_on_use != null) {
                a(liveZanExtraModel.skin_on_use);
                LiveGiftModel liveGiftModel3 = this.aH;
                if (liveGiftModel3 != null && StringUtils.a(liveGiftModel3.goods_id, liveGiftModel.goods_id)) {
                    a(this.aH, liveZanExtraModel.skin_on_use);
                }
            }
            liveGiftModel.user_store_count = liveZanExtraModel.user_store_count;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.aJ.size()) {
                    break;
                }
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 < this.aJ.get(i3).goods.size()) {
                        LiveGiftModel liveGiftModel4 = (LiveGiftModel) this.aJ.get(i3).goods.get(i5);
                        if (StringUtils.a(liveGiftModel.goods_id, liveGiftModel4.goods_id)) {
                            liveGiftModel4.user_store_count = liveZanExtraModel.user_store_count;
                            LogUtils.c("Update item in allGiftList, index: " + liveGiftModel4.index + ", goodsId: " + liveGiftModel4.goods_id);
                        }
                        i4 = i5 + 1;
                    }
                }
                i2 = i3 + 1;
            }
            z = false;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= this.aK.size()) {
                    break;
                }
                Iterator it = this.aK.get(i7).goods.iterator();
                while (it.hasNext()) {
                    LiveGiftModel liveGiftModel5 = (LiveGiftModel) it.next();
                    if (StringUtils.a(liveGiftModel.goods_id, liveGiftModel5.goods_id)) {
                        liveGiftModel5.user_store_count = liveZanExtraModel.user_store_count;
                        boolean z2 = z;
                        if (this.aK.get(i7).deleteItemIfZeroCount) {
                            z2 = z;
                            if (liveGiftModel5.getDeleteItemCount() <= 0) {
                                it.remove();
                                z2 = true;
                            }
                        }
                        LogUtils.c("Update item in bagGiftList, index: " + liveGiftModel5.index + ", goodsId: " + liveGiftModel5.goods_id);
                        z = z2;
                    }
                }
                i6 = i7 + 1;
            }
            if (z) {
                a(this.aK);
            }
            liveGiftModel.danmu_count = liveZanExtraModel.danmu_count;
            if (liveZanExtraModel.join_club == 1) {
                AppMethods.d(R.string.live_fans_add_success);
                if (LiveRoomManager.a().q() != null) {
                    LiveRoomManager.a().q().fans_status = 1;
                }
                LiveEventBus.get(EventBusConstant.KEY_EVENT_LIVE_REFRESH_GIFT_LIST).post(true);
            }
        }
        if (liveGiftModel.is_join_ticket == 1) {
            com.blued.android.module.live_china.utils.log.EventTrackLive.a(LiveProtos.Event.LIVE_SEND_FANS_CLUB_TICKET, LiveProtos.Source.GIFT_PAGE, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        }
        if (LiveRoomManager.a().q() != null && LiveRoomManager.a().q().fans_status == 2 && liveGiftModel.beans_count >= 6.0d) {
            LiveFansObserver.a().d();
        }
        LogUtils.c("after updateGiftValue: " + liveGiftModel.toString());
        return z;
    }

    private void aa() {
        this.bt = false;
        this.bs.clear();
        this.f13829ar.clearAnimation();
        this.ap.clearAnimation();
        this.an.setVisibility(8);
        LiveGiftSetComboView liveGiftSetComboView = this.aX;
        if (liveGiftSetComboView == null || !liveGiftSetComboView.g()) {
            this.C.setVisibility(0);
            this.C.setAlpha(1.0f);
        }
        this.aw.a();
        this.aw.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab() {
        if (this.bt || this.an.getVisibility() == 8) {
            return;
        }
        this.bu = true;
        this.bs.clear();
        this.f13829ar.clearAnimation();
        this.ap.clearAnimation();
        this.aw.a();
        this.aw.setVisibility(8);
        this.an.setAlpha(1.0f);
        this.an.setScaleY(1.0f);
        this.an.setScaleY(1.0f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        animationSet.addAnimation(new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.85f));
        animationSet.setDuration(320L);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.23
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LiveGiftFragment.this.an.setVisibility(8);
                LiveGiftFragment.this.bu = false;
                LogUtils.c("GiftCombo.disComboLayoutAnim.end: " + LiveGiftFragment.this.bs.size());
                if (LiveGiftFragment.this.bs.isEmpty()) {
                    return;
                }
                LiveGiftFragment liveGiftFragment = LiveGiftFragment.this;
                liveGiftFragment.j(CommonStringUtils.a((String) liveGiftFragment.bs.poll()));
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.an.startAnimation(animationSet);
        this.C.setVisibility(0);
        this.C.setAlpha(0.0f);
        this.C.animate().alpha(1.0f).setDuration(320L).start();
        LogUtils.c("GiftCombo.disComboLayoutAnim");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ac() {
        this.at.setScaleX(1.1f);
        this.at.setScaleY(1.1f);
        this.at.animate().scaleX(1.0f).scaleY(1.0f).setDuration(320L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$7wq8ZBXbS4Nq4GAy5g8hiASwsM0
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftFragment.this.ad();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ad() {
        this.bt = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ae() {
        this.ap.setScaleX(1.0f);
        this.ap.setScaleY(1.0f);
        this.ap.animate().scaleX(1.0f).scaleY(1.0f).setDuration(320L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$XeZDVa3lTEG7tNZt1eCr7H-cNq4
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftFragment.this.af();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ag() {
        this.C.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ah() {
        if (getFragmentActive() == null || !getFragmentActive().isActive()) {
            return;
        }
        this.bt = false;
        if (this.bs.isEmpty()) {
            return;
        }
        LogUtils.c("GiftCombo.waitingList has " + this.bs.size() + " data");
        k(CommonStringUtils.a(this.bs.poll()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ai() {
        this.ap.animate().scaleX(1.0f).scaleY(1.0f).setDuration(160L).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$fCzNTy-oOyASghPrBnO5qRhCTc0
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftFragment.this.aj();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void am() {
        int width = (int) ((this.J.getWidth() * 94.0f) / 375.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.L.getLayoutParams();
        layoutParams.height = width;
        layoutParams.bottomMargin = (int) (0.0f - ((width * 18.0f) / 94.0f));
        this.L.setLayoutParams(layoutParams);
    }

    private String b(float f) {
        float f2 = f;
        if (f < 0.0f) {
            f2 = 0.0f;
        }
        return f2 > 100000.0f ? String.valueOf((int) f2) : new DecimalFormat("0.##").format(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        if (i == 1) {
            f(i2);
        } else if (i == 2) {
            g(i2);
        } else if (i == 3 && i2 == 1) {
            b(this.aH, 0);
        } else if (i == 4 && i2 == 1) {
            b(this.aH, 1);
        } else if (i == 5) {
            if (this.aH.effect != null) {
                LiveGiftModel liveGiftModel = this.aH;
                liveGiftModel.effectModel = liveGiftModel.effect.get(i2);
            }
            G();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        LiveRechargeGiftBagView.c();
        ImageLoader.a(getFragmentActive(), R.drawable.live_charge_icon_static).a(this.az);
        LiveRouteUtil.a(this, getFragmentActive(), 1, false, 10020);
        EventTrackLive.d(LiveProtos.Event.LIVE_GIFT_POP_RESOURCE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), 1);
    }

    private void b(CommonGiftPackageModel commonGiftPackageModel) {
        for (LiveGiftModel liveGiftModel : commonGiftPackageModel.goods) {
            if (liveGiftModel.groups != null && liveGiftModel.groups.size() > 1) {
                if (liveGiftModel.groups.get(liveGiftModel.groups.size() - 1).count != 1) {
                    Collections.reverse(liveGiftModel.groups);
                }
                LiveGiftNumberModel liveGiftNumberModel = new LiveGiftNumberModel();
                liveGiftNumberModel.isUserDefined = true;
                liveGiftModel.groups.add(liveGiftNumberModel);
            }
        }
    }

    private void b(final LiveGiftModel liveGiftModel, int i) {
        if (liveGiftModel == null) {
            return;
        }
        liveGiftModel.sendGiftStatus = 1;
        a((CommonLiveGiftModel) liveGiftModel);
        LiveRoomHttpUtils.a(liveGiftModel.goods_id, i, new BluedUIHttpResponse<BluedEntityA<LiveGiftModel>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.7
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveGiftModel> bluedEntityA) {
                liveGiftModel.sendGiftStatus = 0;
                LiveGiftFragment.this.a((CommonLiveGiftModel) liveGiftModel);
                LiveGiftFragment.this.al();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(LiveGiftModel liveGiftModel, View view) {
        d(liveGiftModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PayRemaining payRemaining, LiveGiftModel liveGiftModel, LiveZanExtraModel liveZanExtraModel, int i) {
        LiveGiftAdvancedModel liveGiftAdvancedModel;
        if (payRemaining == null) {
            return;
        }
        LogUtils.c("buyGiftSuccess: " + payRemaining.toString());
        if (!TextUtils.isEmpty(payRemaining.token)) {
            LiveRoomPreferences.c(payRemaining.token);
        }
        LiveEventBus.get("send_gift_success").post(true);
        liveGiftModel.bg_color = liveZanExtraModel.bg_color;
        liveGiftModel.bg_img = liveZanExtraModel.bg_img;
        liveGiftModel.avatar_frame_url = liveZanExtraModel.avatar_frame_url;
        a((BasePayRemaining) payRemaining);
        boolean a2 = a(liveGiftModel, payRemaining, liveZanExtraModel, i);
        if (!TextUtils.isEmpty(liveGiftModel.contents) || liveGiftModel.effect != null) {
            LogUtils.a("弹幕消息， 或者代送礼 不模拟发消息");
        } else if ((liveGiftModel.ops == 13 || liveGiftModel.ops == 19) && liveZanExtraModel != null && liveZanExtraModel.goods != null && liveZanExtraModel.goods.size() >= 2) {
            a(liveGiftModel, i);
            if (liveGiftModel.double_hit == 1 && liveGiftModel.hit_batch == 0) {
                liveGiftModel.comboWaitTime = this.A;
                j(liveGiftModel.hit_count);
            }
            if (liveGiftModel.ops == 19 && liveGiftModel.gameplay_type == 1) {
                EventTrackLive.b(LiveProtos.Event.LIVE_BLIND_BOX_INTRODUCE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id);
                LiveEventBusUtil.h(Integer.parseInt(liveGiftModel.goods_id));
                a(liveGiftModel, liveZanExtraModel.break_even_current, liveZanExtraModel.break_even_max);
            }
            a(payRemaining, liveGiftModel, liveZanExtraModel, i);
        } else {
            a(liveGiftModel, i);
            if (liveGiftModel.goods_set_info == null || !liveGiftModel.isGiftSet()) {
                if (liveGiftModel.double_hit == 1 && liveGiftModel.hit_batch == 0) {
                    liveGiftModel.comboWaitTime = this.A;
                    j(liveGiftModel.hit_count);
                }
            } else if (liveZanExtraModel != null && liveZanExtraModel.goods_set_info != null) {
                liveGiftModel.goods_set_info = liveZanExtraModel.goods_set_info;
                a(liveGiftModel.goods_set_info);
                if (liveZanExtraModel.goods_set_info.is_finish() == 1 && !TextUtils.isEmpty(liveZanExtraModel.goods_set_info.getGoods_set_animation())) {
                    LiveMsgSendManager.a().b(liveZanExtraModel.goods_set_info.getGoods_set_animation());
                }
            }
            if (liveGiftModel.ops != 15 || TypeUtils.a((List<?>) liveGiftModel.advance_list)) {
                if (liveZanExtraModel.lantern_image != null && !liveZanExtraModel.lantern_image.isEmpty()) {
                    LiveBunchLightModel liveBunchLightModel = new LiveBunchLightModel();
                    ArrayList<String> arrayList = new ArrayList<>();
                    for (LiveImgModel liveImgModel : liveZanExtraModel.lantern_image) {
                        arrayList.add(liveImgModel.getImg());
                    }
                    liveBunchLightModel.setImage(arrayList);
                    liveBunchLightModel.setPlay_times(liveZanExtraModel.lantern_play_times);
                    liveGiftModel.bunchLightModel = liveBunchLightModel;
                }
                if (!TextUtils.isEmpty(liveZanExtraModel.random_name)) {
                    liveGiftModel.random_name = liveZanExtraModel.random_name;
                    liveGiftModel.random_static = liveZanExtraModel.random_static;
                    if (!TextUtils.isEmpty(liveZanExtraModel.random_mp4)) {
                        liveGiftModel.images_gif = "";
                        liveGiftModel.images_apng2 = "";
                        liveGiftModel.images_mp4 = liveZanExtraModel.random_mp4;
                    }
                }
                if (!liveZanExtraModel.behalf_bind_status) {
                    LiveMsgSendManager.a().a(liveGiftModel);
                }
            } else {
                LiveGiftModel liveGiftModel2 = new LiveGiftModel();
                ReflectionUtils.a(liveGiftModel, liveGiftModel2);
                Iterator<LiveGiftAdvancedModel> it = liveGiftModel.advance_list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        liveGiftAdvancedModel = null;
                        break;
                    }
                    LiveGiftAdvancedModel next = it.next();
                    liveGiftAdvancedModel = next;
                    if (liveGiftModel.hit_count <= next.count) {
                        break;
                    } else if (next.is_max) {
                        liveGiftAdvancedModel = next;
                        break;
                    }
                }
                if (liveGiftAdvancedModel != null) {
                    LogUtils.c("连击数： " + liveGiftModel.hit_count + " 使用" + liveGiftAdvancedModel.toString());
                    liveGiftModel2.images_gif = liveGiftAdvancedModel.images_gif;
                    liveGiftModel2.images_apng2 = liveGiftAdvancedModel.images_apng;
                    liveGiftModel2.images_mp4 = liveGiftAdvancedModel.images_mp4;
                }
                if (liveZanExtraModel.lantern_image != null && !liveZanExtraModel.lantern_image.isEmpty()) {
                    LiveBunchLightModel liveBunchLightModel2 = new LiveBunchLightModel();
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    for (LiveImgModel liveImgModel2 : liveZanExtraModel.lantern_image) {
                        arrayList2.add(liveImgModel2.getImg());
                    }
                    liveBunchLightModel2.setImage(arrayList2);
                    liveBunchLightModel2.setPlay_times(liveZanExtraModel.lantern_play_times);
                    liveGiftModel2.bunchLightModel = liveBunchLightModel2;
                }
                if (!TextUtils.isEmpty(liveZanExtraModel.random_name)) {
                    liveGiftModel2.random_name = liveZanExtraModel.random_name;
                    liveGiftModel2.random_static = liveZanExtraModel.random_static;
                    if (!TextUtils.isEmpty(liveZanExtraModel.random_mp4)) {
                        liveGiftModel.images_gif = "";
                        liveGiftModel.images_apng2 = "";
                        liveGiftModel.images_mp4 = liveZanExtraModel.random_mp4;
                    }
                }
                if (!liveZanExtraModel.behalf_bind_status) {
                    LiveMsgSendManager.a().a(liveGiftModel2);
                }
            }
        }
        if (this.aZ.getGoodId().equals(liveGiftModel.goods_id)) {
            liveGiftModel.random = liveZanExtraModel.random;
            if (this.aZ.getVisibility() == 0 && !TextUtils.isEmpty(liveGiftModel.goods_id) && liveGiftModel.random != null) {
                this.aZ.a(s(), liveGiftModel.goods_id, liveGiftModel.random);
            }
        }
        u();
        if (this.aL && a2) {
            this.y = null;
            a((LiveDefaultGiftModel) null);
        } else {
            this.y = liveGiftModel;
            f(liveGiftModel, i);
            a((CommonLiveGiftModel) liveGiftModel);
        }
        if (liveGiftModel.ops == 5) {
            al();
        } else {
            b((CommonLiveGiftModel) liveGiftModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Boolean bool) {
        d(this.b);
        LiveEventBus.get("gift_data_change").post("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Integer num) {
        e(num.intValue());
    }

    private void b(List<CommonGiftPackageModel> list, boolean z) {
        int i;
        int i2;
        int a2 = DisplayUtil.a(AppInfo.d(), 25.0f);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(DisplayUtil.a(AppInfo.d(), 9.0f));
        int a3 = DisplayUtil.a(AppInfo.d(), 14.0f);
        int a4 = DisplayUtil.a(AppInfo.d(), 3.0f);
        for (CommonGiftPackageModel commonGiftPackageModel : list) {
            if (!z && (commonGiftPackageModel.packageType == 1 || commonGiftPackageModel.packageType == -1 || commonGiftPackageModel.packageType == 0)) {
                int a5 = ((AppInfo.l - DisplayUtil.a(AppInfo.d(), 4.0f)) / commonGiftPackageModel.getColumn()) - DisplayUtil.a(AppInfo.d(), 14.0f);
                LogUtils.c("maxTagWidth: " + a5);
                int i3 = a5;
                if (a5 <= 100) {
                    i3 = DisplayUtil.a(AppInfo.d(), 83.0f);
                }
                for (LiveGiftModel liveGiftModel : commonGiftPackageModel.goods) {
                    if (liveGiftModel.ops == 15) {
                        LogUtils.c("进阶 " + liveGiftModel.toString());
                    }
                    if (liveGiftModel.giftType == 10 || liveGiftModel.giftType == 0) {
                        liveGiftModel.realOperateIcons = new ArrayList();
                        if (liveGiftModel.is_battle_goods == 1 || liveGiftModel.is_fans_goods == 1 || liveGiftModel.exclusive_icon == 1 || liveGiftModel.event_type == 1) {
                            LiveGiftOperateIconModel liveGiftOperateIconModel = new LiveGiftOperateIconModel();
                            liveGiftOperateIconModel.type = 1001;
                            liveGiftOperateIconModel.width = a2;
                            if (liveGiftModel.is_battle_goods == 1) {
                                liveGiftOperateIconModel.imgResId = R.drawable.live_pk_icon;
                            } else if (liveGiftModel.is_fans_goods == 1) {
                                liveGiftOperateIconModel.imgResId = R.drawable.live_fans_gift;
                            } else if (liveGiftModel.exclusive_icon == 1) {
                                liveGiftOperateIconModel.imgResId = R.drawable.live_exclusive;
                            } else if (liveGiftModel.event_type == 1) {
                                liveGiftOperateIconModel.imgResId = R.drawable.live_week_star_icon;
                            }
                            i = i3 - liveGiftOperateIconModel.width;
                            liveGiftModel.realOperateIcons.add(liveGiftOperateIconModel);
                        } else {
                            i = i3;
                        }
                        if (liveGiftModel.operate_icon_list != null) {
                            for (LiveGiftOperateIconModel liveGiftOperateIconModel2 : liveGiftModel.operate_icon_list) {
                                if (liveGiftOperateIconModel2.type != 0 || TextUtils.isEmpty(liveGiftOperateIconModel2.content)) {
                                    i2 = 0;
                                    if (liveGiftOperateIconModel2.length > 0) {
                                        i2 = 0;
                                        if (liveGiftOperateIconModel2.height > 0) {
                                            i2 = (int) ((liveGiftOperateIconModel2.length * a3) / liveGiftOperateIconModel2.height);
                                        }
                                    }
                                } else {
                                    i2 = ((int) textPaint.measureText(liveGiftOperateIconModel2.content)) + (a4 * 2);
                                }
                                if (i2 > 0 && liveGiftModel.realOperateIcons.size() < 3 && i - i2 > 0) {
                                    int i4 = i;
                                    if (liveGiftModel.realOperateIcons.size() > 0) {
                                        i4 = i - a4;
                                    }
                                    i = i4 - i2;
                                    liveGiftOperateIconModel2.width = i2;
                                    liveGiftModel.realOperateIcons.add(liveGiftOperateIconModel2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(int i, int i2) {
        this.au.setText(String.valueOf(i));
        this.au.setScaleX(2.0f);
        this.au.setScaleY(2.0f);
        this.au.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(i2 / 2).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        EventTrackLive.r(LiveProtos.Event.LIVE_GIFT_POP_BANNER_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this.be);
        if (TextUtils.isEmpty(this.bf) || s() == null) {
            return;
        }
        s().aJ();
        s().a(this.bf, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Boolean bool) {
        al();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Integer num) {
        l(num.intValue());
    }

    private void c(boolean z) {
        if (z) {
            this.aA.setVisibility(0);
        } else {
            this.aA.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(BasePayRemaining basePayRemaining) {
        a(basePayRemaining);
    }

    private void d(LiveGiftModel liveGiftModel) {
        if (LiveDataManager.a().f()) {
            AppMethods.a((CharSequence) getString(R.string.live_luck_turning_land_tips));
        } else if (liveGiftModel == null) {
        } else {
            String str = liveGiftModel.link;
            int i = liveGiftModel.link_type;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            EventTrackLive.n(LiveProtos.Event.LIVE_GOODS_DESC_CLICK, LiveRoomManager.a().p().profile.uid, LiveRoomManager.a().e(), liveGiftModel.goods_id);
            if (s() != null) {
                LiveRoomFunctionItemModel liveRoomFunctionItemModel = new LiveRoomFunctionItemModel();
                liveRoomFunctionItemModel.setLink_type(i);
                liveRoomFunctionItemModel.setLink(str);
                LiveEventBus.get(LiveEventBusUtil.C).postDelay(liveRoomFunctionItemModel, 200L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(Boolean bool) {
        x();
    }

    private void d(List<CommonGiftPackageModel> list) {
        if (TypeUtils.a((List<?>) list)) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            LiveGiftPackageModel liveGiftPackageModel = (LiveGiftPackageModel) list.get(i2);
            if (liveGiftPackageModel.goods.size() <= 0) {
                liveGiftPackageModel.setLine(2);
                liveGiftPackageModel.setColumn(4);
            } else if (LiveDataManager.a().f()) {
                liveGiftPackageModel.setLine(1);
                liveGiftPackageModel.setColumn(8);
                if (liveGiftPackageModel.packageType == 2) {
                    liveGiftPackageModel.setColumn(5);
                }
            } else {
                liveGiftPackageModel.setLine(2);
                liveGiftPackageModel.setColumn(4);
                if (liveGiftPackageModel.packageType == 2) {
                    liveGiftPackageModel.setColumn(3);
                }
            }
            b(liveGiftPackageModel);
            i = i2 + 1;
        }
    }

    private String[] d(boolean z) {
        LiveGiftModel liveGiftModel = this.aH;
        if (liveGiftModel == null || liveGiftModel.effect == null) {
            return null;
        }
        String[] strArr = new String[this.aH.effect.size() + 1];
        if (z) {
            strArr[0] = this.aD;
        } else {
            strArr[0] = this.aE;
        }
        int i = 0;
        while (i < this.aH.effect.size()) {
            LiveEffectModel liveEffectModel = this.aH.effect.get(i);
            i++;
            strArr[i] = String.format(getResources().getString(R.string.renew_1_months), String.valueOf(liveEffectModel.expire)) + "(" + a(liveEffectModel.beans) + getResources().getString(R.string.Live_SendPresent_wandou) + ")";
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        this.ax.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0079, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void e(com.blued.android.module.live_china.model.LiveGiftModel r4) {
        /*
            r3 = this;
            r0 = r4
            if (r0 != 0) goto L5
            return
        L5:
            r0 = 0
            r5 = r0
        L7:
            r0 = r5
            r1 = r3
            java.util.List<com.blued.android.module.common.model.CommonGiftPackageModel> r1 = r1.aJ
            int r1 = r1.size()
            if (r0 >= r1) goto L80
            r0 = r3
            java.util.List<com.blued.android.module.common.model.CommonGiftPackageModel> r0 = r0.aJ
            r1 = r5
            java.lang.Object r0 = r0.get(r1)
            com.blued.android.module.common.model.CommonGiftPackageModel r0 = (com.blued.android.module.common.model.CommonGiftPackageModel) r0
            r7 = r0
            r0 = r7
            int r0 = r0.packageType
            if (r0 == 0) goto L2e
            goto L79
        L2e:
            r0 = 0
            r6 = r0
        L30:
            r0 = r6
            r1 = r7
            java.util.List<T extends com.blued.android.module.common.model.BaseGiftModel> r1 = r1.goods
            int r1 = r1.size()
            if (r0 >= r1) goto L79
            r0 = r3
            java.util.List<com.blued.android.module.common.model.CommonGiftPackageModel> r0 = r0.aJ
            r1 = r5
            java.lang.Object r0 = r0.get(r1)
            com.blued.android.module.common.model.CommonGiftPackageModel r0 = (com.blued.android.module.common.model.CommonGiftPackageModel) r0
            java.util.List<T extends com.blued.android.module.common.model.BaseGiftModel> r0 = r0.goods
            r1 = r6
            java.lang.Object r0 = r0.get(r1)
            com.blued.android.module.live_china.model.LiveGiftModel r0 = (com.blued.android.module.live_china.model.LiveGiftModel) r0
            r8 = r0
            r0 = r4
            java.lang.String r0 = r0.goods_id
            r1 = r8
            java.lang.String r1 = r1.goods_id
            boolean r0 = com.blued.android.framework.utils.StringUtils.a(r0, r1)
            if (r0 == 0) goto L72
            r0 = r8
            r1 = r4
            int r1 = r1.user_store_count
            r0.user_store_count = r1
            return
        L72:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L30
        L79:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L7
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.mine.LiveGiftFragment.e(com.blued.android.module.live_china.model.LiveGiftModel):void");
    }

    private void f(int i) {
        LiveGiftModel liveGiftModel = this.aH;
        if (liveGiftModel == null) {
            return;
        }
        if (i == 0) {
            b(liveGiftModel, 0);
        } else if (i == 1) {
            if (liveGiftModel.effect == null || this.aH.effect.size() < 1) {
                return;
            }
            LiveGiftModel liveGiftModel2 = this.aH;
            liveGiftModel2.effectModel = liveGiftModel2.effect.get(0);
            G();
        } else if (i == 2 && liveGiftModel.effect != null && this.aH.effect.size() >= 2) {
            LiveGiftModel liveGiftModel3 = this.aH;
            liveGiftModel3.effectModel = liveGiftModel3.effect.get(1);
            G();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        ak();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(LiveGiftModel liveGiftModel) {
        if (liveGiftModel == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aJ.size()) {
                return;
            }
            CommonGiftPackageModel commonGiftPackageModel = this.aJ.get(i2);
            if (commonGiftPackageModel.packageType == 2) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < commonGiftPackageModel.goods.size()) {
                        LiveGiftModel liveGiftModel2 = (LiveGiftModel) this.aJ.get(i2).goods.get(i4);
                        if (StringUtils.a(liveGiftModel.goods_id, liveGiftModel2.goods_id)) {
                            liveGiftModel2.is_use = liveGiftModel.is_use;
                        } else {
                            liveGiftModel2.is_use = 0;
                        }
                        i3 = i4 + 1;
                    }
                }
            }
            i = i2 + 1;
        }
    }

    private void g(int i) {
        LiveGiftModel liveGiftModel = this.aH;
        if (liveGiftModel == null) {
            return;
        }
        if (i == 0) {
            b(liveGiftModel, 1);
        } else if (i == 1) {
            if (liveGiftModel.effect == null || this.aH.effect.size() < 1) {
                return;
            }
            LiveGiftModel liveGiftModel2 = this.aH;
            liveGiftModel2.effectModel = liveGiftModel2.effect.get(0);
            G();
        } else if (i == 2 && liveGiftModel.effect != null && this.aH.effect.size() >= 2) {
            LiveGiftModel liveGiftModel3 = this.aH;
            liveGiftModel3.effectModel = liveGiftModel3.effect.get(1);
            G();
        }
    }

    private void g(final String str) {
        LiveRoomHttpUtils.b(str, 1, new BluedUIHttpResponse<BluedEntityA<LiveGiftBlindBoxModel>>(s().getFragmentActive()) { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.18
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveGiftBlindBoxModel> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() == 0 || bluedEntityA.data.get(0) == null) {
                    return;
                }
                LiveGiftBlindBoxModel liveGiftBlindBoxModel = bluedEntityA.data.get(0);
                if (liveGiftBlindBoxModel.getShow_type() == 3) {
                    LiveGiftFragment.this.ba.setVisibility(8);
                    return;
                }
                LiveGiftFragment.this.ba.setVisibility(0);
                LiveGiftFragment.this.ba.a(LiveGiftFragment.this.s(), str, liveGiftBlindBoxModel);
                LiveGiftFragment.this.ba.setVisibility(0);
            }
        }, (IRequestHost) null);
    }

    private void h(int i) {
        if (i == 0) {
            InstantLog.b("live_gift_page", 1);
        } else if (i == 1) {
            InstantLog.b("live_gift_page", 2);
        } else if (i != 2) {
        } else {
            InstantLog.b("live_gift_page", 3);
        }
    }

    private void i(int i) {
        this.br = System.currentTimeMillis();
        if (s() != null) {
            s().f_(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i) {
        if (i == 1) {
            if (this.bu) {
                LogUtils.c("GiftCombo.isDisComboLayoutAnim = true, wait finish");
                if (this.an.getAnimation() != null) {
                    this.an.getAnimation().cancel();
                    this.an.clearAnimation();
                }
                this.bs.offer(String.valueOf(1));
            } else {
                Y();
            }
        } else if (this.bt) {
            this.bs.offer(String.valueOf(i));
            LogUtils.c("GiftCombo.isPlaying, Add " + i + " into list, size:" + this.bs.size());
        } else if (this.bs.isEmpty()) {
            k(i);
        } else {
            this.bs.offer(String.valueOf(i));
            LogUtils.c("GiftCombo.waitingScrawlList, Add " + i + " into list, size:" + this.bs.size());
            k(CommonStringUtils.a(this.bs.poll()));
        }
        this.av.setValue(100.0f);
        this.av.a(100.0f, 0.0f, 5000L);
        if (this.an.getVisibility() == 0) {
            this.aw.setVisibility(0);
            this.aw.a(false, 0, true);
            return;
        }
        this.aw.a();
        this.aw.setVisibility(8);
    }

    private void k(final int i) {
        LogUtils.c("GiftCombo.startComboCountAnim:" + i);
        this.bt = true;
        this.an.setVisibility(0);
        int i2 = this.bs.isEmpty() ? 400 : 200;
        int i3 = this.aO;
        int i4 = (i - 1) / 10;
        final int i5 = i2;
        this.au.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$BBwKFatk6TV5_oy8lGWkOLXZC6Q
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftFragment.this.c(i, i5);
            }
        }).setDuration(i2 / 2).start();
        if (i % 10 == 1) {
            this.as.setAlpha(0.0f);
            this.as.setScaleX(0.0f);
            this.as.setScaleY(0.0f);
            this.as.setTranslationY(0.0f);
            this.as.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(i2).start();
        } else {
            this.as.animate().translationY(i3 * (-1) * (i - (i4 * 10))).setDuration(i2).start();
        }
        this.aq.setScaleX(1.0f);
        this.aq.setScaleY(1.0f);
        this.aq.setAlpha(1.0f);
        this.aq.animate().scaleX(1.7f).scaleY(1.7f).alpha(0.0f).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$tOZjtc-ec0KP-6iJnvPVKNf5ISU
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftFragment.this.ah();
            }
        }).setDuration(i2).start();
    }

    private void l(int i) {
        if (this.az.getTag() != null && (this.az.getTag() instanceof Integer) && ((Integer) this.az.getTag()).intValue() == i) {
            return;
        }
        this.az.setTag(Integer.valueOf(i));
        if (i == 1) {
            this.az.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.az.getLayoutParams();
            layoutParams.width = AppMethods.a(30);
            layoutParams.height = AppMethods.a(30);
            this.az.setLayoutParams(layoutParams);
            if (LiveRechargeGiftBagView.b()) {
                ImageLoader.a(getFragmentActive(), R.drawable.live_charge_icon_static).a(this.az);
            } else {
                ImageLoader.c(getFragmentActive(), "live_first_gift_pay_anim.png").e(this.az.hashCode()).g(-1).a(this.az);
            }
            this.az.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$sTl1fFC926qKPdQpC-M1PxXSZ3k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGiftFragment.this.b(view);
                }
            });
        } else if (i != 2) {
            this.az.setVisibility(8);
        } else {
            this.az.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.az.getLayoutParams();
            layoutParams2.width = AppMethods.a(77);
            layoutParams2.height = AppMethods.a(32);
            this.az.setLayoutParams(layoutParams2);
            Date date = new Date(System.currentTimeMillis());
            final int year = (date.getYear() * 10000) + ((date.getMonth() + 1) * 100) + date.getDate();
            if (year > LiveRoomPreferences.y()) {
                ImageLoader.c(getFragmentActive(), "live_recharge_anim.png").e(this.az.hashCode()).g(-1).a(this.az);
            } else {
                ImageLoader.a(getFragmentActive(), R.drawable.live_recharge_static).a(this.az);
            }
            this.az.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$LchhflG3l2CRqkz8-1QQFyzp5nI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGiftFragment.this.a(year, view);
                }
            });
        }
    }

    public void A() {
        LiveGiftModel liveGiftModel;
        this.aL = false;
        this.aV = false;
        b(this.aH);
        this.aU.setVisibility(8);
        View view = this.ad;
        if (view != null) {
            view.setVisibility(0);
        }
        if (this.al != null && this.am != null) {
            if (this.aV.booleanValue() || LiveDataManager.a().f() || (liveGiftModel = this.aH) == null || !liveGiftModel.isScrawlGift()) {
                this.al.setVisibility(8);
                this.rootView.setBackgroundResource(R.color.transparent);
            } else {
                this.al.setVisibility(0);
                this.rootView.setBackgroundResource(R.color.trans_black_four);
            }
        }
        try {
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            if (this.bv != null) {
                beginTransaction.remove(this.bv.get()).commitNowAllowingStateLoss();
            }
        } catch (Exception e) {
        }
    }

    public long a(LiveGiftModel liveGiftModel, int i) {
        super.e(liveGiftModel, i);
        LogUtils.c("giftCount = " + i + ", " + liveGiftModel.toString());
        if (i > 1) {
            liveGiftModel.hit_batch = 1;
            liveGiftModel.hit_count = i;
        } else {
            liveGiftModel.hit_batch = 0;
            liveGiftModel.displayCount = 1;
            if (liveGiftModel.double_hit == 1) {
                liveGiftModel.hit_count++;
            } else {
                liveGiftModel.hit_count = 1;
            }
        }
        this.u = liveGiftModel.hit_id;
        LogUtils.c("after judge, giftCount = " + i + ", " + liveGiftModel.toString());
        return this.u;
    }

    @Override // com.blued.android.module.common.fragment.BaseGiftRootFragment
    public BaseFragment a(CommonGiftPackageModel commonGiftPackageModel, Bundle bundle) {
        return new LiveGiftParentFragment();
    }

    public void a(BaseFragment baseFragment) {
        this.F = baseFragment;
    }

    @Override // com.blued.android.module.common.fragment.BaseGiftRootFragment
    public void a(BaseGiftModel baseGiftModel, boolean z) {
        boolean z2;
        super.a(baseGiftModel, z);
        LogUtils.c("onItemSelected: " + baseGiftModel.index + ", " + z);
        if (isHidden()) {
            return;
        }
        LiveGiftPackageModel liveGiftPackageModel = (LiveGiftPackageModel) b(baseGiftModel.index);
        LiveGiftModel liveGiftModel = this.aH;
        if (liveGiftModel == null || StringUtils.a(liveGiftModel.index, baseGiftModel.index)) {
            z2 = false;
        } else {
            if (liveGiftPackageModel != null) {
                EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_PAGE_GIFT_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), ((LiveGiftModel) baseGiftModel).goods_id, liveGiftPackageModel.type_name, baseGiftModel.pageIndex + 1, baseGiftModel.isMp4, baseGiftModel.positionInPage + 1);
            }
            r();
            LiveGiftModel liveGiftModel2 = (LiveGiftModel) a(this.aH.index);
            if (liveGiftModel2 != null) {
                LogUtils.c("lastSelectModel: " + liveGiftModel2.index);
                liveGiftModel2.isSelected = false;
                liveGiftModel2.comboWaitTime = 0;
                a((CommonLiveGiftModel) liveGiftModel2);
            } else {
                LogUtils.c("lastSelectModel: null");
            }
            aa();
            LiveGiftModel liveGiftModel3 = (LiveGiftModel) baseGiftModel;
            if (liveGiftModel3.isGiftSet()) {
                c(liveGiftModel3);
            } else {
                Z();
            }
            z2 = true;
        }
        LiveGiftModel liveGiftModel4 = (LiveGiftModel) baseGiftModel;
        this.aH = liveGiftModel4;
        if (this.aL) {
            this.aN = baseGiftModel.index;
        } else {
            this.aM = baseGiftModel.index;
        }
        if (liveGiftModel4.ops == 5) {
            if (!z) {
                FrameLayout frameLayout = this.K;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                    return;
                }
                return;
            }
            E();
            if (liveGiftPackageModel.packageType == 2) {
                this.C.setVisibility(8);
                return;
            } else {
                this.C.setVisibility(0);
                return;
            }
        }
        this.m.setText(getString(R.string.live_give_gift));
        this.p.setVisibility(0);
        this.C.setBackgroundResource(R.drawable.live_gift_switcher_bg);
        if (this.aH.double_hit == 1) {
            this.aw.a(new String[]{this.aH.pic});
        }
        if (TypeUtils.a((List<?>) this.aH.groups)) {
            this.aH.selectNumModel = null;
        } else if (z2) {
            for (LiveGiftNumberModel liveGiftNumberModel : this.aH.groups) {
                if (liveGiftNumberModel.isUserDefined) {
                    liveGiftNumberModel.count = 0;
                }
            }
            LiveGiftModel liveGiftModel5 = this.aH;
            liveGiftModel5.selectNumModel = liveGiftModel5.groups.get(this.aH.groups.size() - 1);
        }
        F();
        b(this.aH);
        O();
        if (this.al != null && this.am != null) {
            if (this.aV.booleanValue() || LiveDataManager.a().f() || !this.aH.isScrawlGift() || !(z || this.aT)) {
                this.al.setVisibility(8);
                this.rootView.setBackgroundResource(R.color.transparent);
            } else {
                this.al.setVisibility(0);
                this.rootView.setBackgroundResource(R.color.trans_black_four);
            }
        }
        this.aT = false;
    }

    @Override // com.blued.android.module.common.fragment.BaseGiftRootFragment
    public void a(CommonGiftPackageModel commonGiftPackageModel) {
        super.a(commonGiftPackageModel);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= commonGiftPackageModel.goods.size()) {
                return;
            }
            ((LiveGiftModel) commonGiftPackageModel.goods.get(i2)).packageTypeName = commonGiftPackageModel.name;
            i = i2 + 1;
        }
    }

    public void a(LiveDefaultGiftModel liveDefaultGiftModel) {
        String str;
        this.aL = true;
        r();
        View view = this.R;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.ad;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        View view3 = this.al;
        if (view3 != null && this.am != null) {
            view3.setVisibility(8);
            this.rootView.setBackgroundResource(R.color.transparent);
        }
        if (liveDefaultGiftModel == null) {
            str = "";
        } else {
            str = liveDefaultGiftModel.id + "";
        }
        a("", str, "");
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    public void a(LiveGiftNumberModel liveGiftNumberModel) {
        LiveGiftModel liveGiftModel = this.aH;
        if (liveGiftModel != null) {
            liveGiftModel.selectNumModel = liveGiftNumberModel;
        }
        LiveRouteUtil.a((Fragment) this);
        EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_NUM_SET_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    public void a(DefinedRankInfo definedRankInfo) {
        if (this.aA == null) {
            return;
        }
        if (definedRankInfo == null || TypeUtils.a((List<?>) definedRankInfo.rank_info) || System.currentTimeMillis() > definedRankInfo.end_time * 1000 || System.currentTimeMillis() < definedRankInfo.start_time * 1000) {
            c(false);
            return;
        }
        c(true);
        this.aC.setDataAndNotify(definedRankInfo.rank_info);
    }

    public void a(LiveGiftModel liveGiftModel) {
        LiveGiftPayTools.b();
        if (LiveGiftPayTools.f14162a || s() == null || s().getFragmentActive() == null || !s().getFragmentActive().isActive()) {
            return;
        }
        String string = getString(R.string.Live_SendPresent_notEnoughWandou);
        String str = string;
        if (liveGiftModel.effect != null) {
            str = string;
            if (liveGiftModel.effect.size() > 0) {
                str = getString(R.string.Live_effect_not_enough);
            }
        }
        LiveGiftPayTools.f14162a = true;
        CommonAlertDialog.a((Context) getActivity(), (View) null, "", str, getString(R.string.cancel), getString(R.string.Live_SendPresent_recharge), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                if (LiveDataManager.a().f()) {
                    if (LiveGiftFragment.this.s() != null) {
                        LiveGiftFragment.this.s().b(true);
                    }
                    LiveRoomInfo.a().a(LiveGiftFragment.this.getActivity(), 2);
                } else {
                    LiveRoomInfo.a().a(LiveGiftFragment.this.getActivity(), LiveGiftFragment.this.getFragmentManager(), 2);
                }
                LiveGiftPayTools.f14162a = false;
            }
        }, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                LiveGiftPayTools.f14162a = false;
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.12
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                LiveGiftPayTools.f14162a = false;
            }
        }, true);
    }

    public void a(final LiveGiftModel liveGiftModel, final int i, String str, boolean z) {
        if (liveGiftModel != null && j()) {
            LogUtils.c("buyGift.selectedModel: " + liveGiftModel.toString() + ", gifCount:" + i + ", payCode:" + str + ", payToken:" + LiveRoomPreferences.b("") + ", remember_me:" + z);
            BluedUIHttpResponse<BluedEntity<PayRemaining, LiveZanExtraModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<PayRemaining, LiveZanExtraModel>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.8
                @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                public void onFailure(Throwable th, int i2, String str2) {
                    super.onFailure(th, i2, str2);
                    LiveGiftFragment.this.e(str2);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i2, String str2) {
                    if (LiveGiftFragment.this.j()) {
                        KeyboardUtils.a(LiveGiftFragment.this.getActivity());
                        LiveGiftFragment.this.a(liveGiftModel, i, i2, str2);
                        return true;
                    }
                    return false;
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity<PayRemaining, LiveZanExtraModel> bluedEntity) {
                    if (LiveGiftFragment.this.j()) {
                        KeyboardUtils.a(LiveGiftFragment.this.getActivity());
                        if (bluedEntity == null || bluedEntity.getSingleData() == null) {
                            LiveGiftFragment.this.a(liveGiftModel, i, 0, (String) null);
                            return;
                        }
                        LiveGiftFragment.this.b(bluedEntity.getSingleData(), liveGiftModel, bluedEntity.extra, i);
                    }
                }
            };
            LiveRoomHttpUtils.a(LiveRoomManager.a().g(), LiveRoomManager.a().e(), liveGiftModel, "", str, TextUtils.isEmpty(str) ? LiveRoomPreferences.b("") : "", z, i, K(), bluedUIHttpResponse, getFragmentActive());
        }
    }

    public void a(LiveGiftSetBuyModel liveGiftSetBuyModel) {
        if (liveGiftSetBuyModel == null) {
            return;
        }
        LiveGiftSetInfoModel liveGiftSetInfoModel = new LiveGiftSetInfoModel();
        liveGiftSetInfoModel.setName(liveGiftSetBuyModel.getName());
        liveGiftSetInfoModel.setId(liveGiftSetBuyModel.getId());
        liveGiftSetInfoModel.setProgress(liveGiftSetBuyModel.getProgress());
        liveGiftSetInfoModel.setExpire_time(liveGiftSetBuyModel.getExpire_time());
        liveGiftSetInfoModel.set_finish(liveGiftSetBuyModel.is_finish());
        a(liveGiftSetInfoModel);
        if (liveGiftSetBuyModel.getGoods_animation() != null) {
            LiveEventBus.get("send_gift_success").post(true);
            Iterator<LiveGiftSetItemModel> it = liveGiftSetBuyModel.getGoods_animation().iterator();
            while (it.hasNext()) {
                LiveGiftSetItemModel next = it.next();
                if (next != null) {
                    LiveGiftModel liveGiftModel = new LiveGiftModel();
                    liveGiftModel.goods_id = next.getGoods_id();
                    liveGiftModel.name = next.getName();
                    liveGiftModel.animation = next.getAnimation();
                    liveGiftModel.images_apng2 = next.getImages_apng();
                    liveGiftModel.images_gif = next.getImages_gif();
                    liveGiftModel.images_mp4 = next.getImages_mp4();
                    liveGiftModel.avatar_frame_url = next.getAvatar_frame_url();
                    liveGiftModel.bg_color = next.getBg_color();
                    liveGiftModel.bg_img = next.getBg_img();
                    liveGiftModel.images_static = next.getImages_static();
                    liveGiftModel.count = next.getCount();
                    liveGiftModel.hit_count = next.getCount();
                    liveGiftModel.hit_batch = 1;
                    liveGiftModel.anim_many = 1;
                    liveGiftModel.beans_count = liveGiftSetBuyModel.getBeans_count();
                    liveGiftModel.beans_current_count = liveGiftSetBuyModel.getBeans_current();
                    liveGiftModel.beans = liveGiftSetBuyModel.getBeans();
                    liveGiftModel.bonus = liveGiftSetBuyModel.getBonus();
                    LiveMsgSendManager.a().a(liveGiftModel);
                }
            }
        }
        BasePayRemaining e = LiveDataManager.a().e();
        if (e != null) {
            e.beans_current = liveGiftSetBuyModel.getBeans_current();
            e.beans = liveGiftSetBuyModel.getBeans();
            e.bonus = liveGiftSetBuyModel.getBonus();
            e.beans_count = liveGiftSetBuyModel.getBeans_count();
            a(e);
        }
        u();
        if (liveGiftSetBuyModel.is_finish() != 1 || TextUtils.isEmpty(liveGiftSetBuyModel.getGoods_set_animation())) {
            return;
        }
        LiveMsgSendManager.a().b(liveGiftSetBuyModel.getGoods_set_animation());
    }

    public void a(LiveGiftSkinItemModel liveGiftSkinItemModel) {
        if (liveGiftSkinItemModel == null) {
            return;
        }
        for (CommonGiftPackageModel commonGiftPackageModel : this.aJ) {
            a(commonGiftPackageModel, liveGiftSkinItemModel, !this.aL);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0239, code lost:
        if (android.text.TextUtils.isEmpty(r0.images_mp4) == false) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.module.live_china.model.PayRemaining r5, com.blued.android.module.live_china.model.LiveGiftModel r6, com.blued.android.module.live_china.model.LiveZanExtraModel r7, int r8) {
        /*
            Method dump skipped, instructions count: 723
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.mine.LiveGiftFragment.a(com.blued.android.module.live_china.model.PayRemaining, com.blued.android.module.live_china.model.LiveGiftModel, com.blued.android.module.live_china.model.LiveZanExtraModel, int):void");
    }

    public void a(Object obj) {
        this.aS = obj;
        if (obj != null) {
            if (obj instanceof LiveChargeCouponModel) {
                this.aL = true;
                if (!isAdded() || this.rootView == null || isHidden()) {
                    return;
                }
                a((LiveDefaultGiftModel) null);
                M();
            } else if (obj instanceof LiveDefaultGiftModel) {
                final LiveDefaultGiftModel liveDefaultGiftModel = (LiveDefaultGiftModel) obj;
                this.aL = liveDefaultGiftModel.is_bag;
                if (!isAdded() || this.rootView == null || isHidden()) {
                    return;
                }
                if (liveDefaultGiftModel.is_bag) {
                    postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.13
                        @Override // java.lang.Runnable
                        public void run() {
                            LiveGiftFragment.this.a(liveDefaultGiftModel);
                        }
                    }, 300L);
                } else {
                    U();
                }
                M();
            }
        }
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    public void b(BasePayRemaining basePayRemaining) {
        if (basePayRemaining == null) {
            return;
        }
        PayRemaining payRemaining = (PayRemaining) basePayRemaining;
        if (TextUtils.isEmpty(payRemaining.image_url)) {
            return;
        }
        LiveSetDataObserver.a().a(payRemaining.image_url);
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    public void b(LiveGiftNumberModel liveGiftNumberModel) {
        LiveGiftModel liveGiftModel = this.aH;
        if (liveGiftModel != null) {
            liveGiftModel.selectNumModel = liveGiftNumberModel;
        }
        F();
    }

    public void b(final LiveGiftModel liveGiftModel) {
        if (isHidden()) {
            return;
        }
        if (P()) {
            LiveGiftSetBannerView liveGiftSetBannerView = this.aY;
            if (liveGiftSetBannerView != null) {
                liveGiftSetBannerView.setVisibility(8);
            }
            ImageView imageView = this.L;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            LiveGiftRandomBarView liveGiftRandomBarView = this.aZ;
            if (liveGiftRandomBarView != null) {
                liveGiftRandomBarView.setVisibility(8);
            }
            LiveGiftBlindboxBarView liveGiftBlindboxBarView = this.ba;
            if (liveGiftBlindboxBarView != null) {
                liveGiftBlindboxBarView.setVisibility(8);
            }
            LiveGiftConstellationView liveGiftConstellationView = this.bb;
            if (liveGiftConstellationView != null) {
                liveGiftConstellationView.setVisibility(8);
            }
            Q();
            return;
        }
        View view = this.R;
        if (view != null) {
            view.setVisibility(8);
        }
        FrameLayout frameLayout = this.bl;
        if (frameLayout != null && frameLayout.getVisibility() == 0) {
            FrameLayout frameLayout2 = this.K;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
            LiveGiftSetBannerView liveGiftSetBannerView2 = this.aY;
            if (liveGiftSetBannerView2 != null) {
                liveGiftSetBannerView2.setVisibility(8);
            }
            ImageView imageView2 = this.L;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            LiveGiftRandomBarView liveGiftRandomBarView2 = this.aZ;
            if (liveGiftRandomBarView2 != null) {
                liveGiftRandomBarView2.setVisibility(8);
            }
            LiveGiftBlindboxBarView liveGiftBlindboxBarView2 = this.ba;
            if (liveGiftBlindboxBarView2 != null) {
                liveGiftBlindboxBarView2.setVisibility(8);
            }
            LiveGiftConstellationView liveGiftConstellationView2 = this.bb;
            if (liveGiftConstellationView2 != null) {
                liveGiftConstellationView2.setVisibility(8);
            }
        } else if (liveGiftModel == null) {
            FrameLayout frameLayout3 = this.K;
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(8);
            }
            LiveGiftSetBannerView liveGiftSetBannerView3 = this.aY;
            if (liveGiftSetBannerView3 != null) {
                liveGiftSetBannerView3.setVisibility(8);
            }
            ImageView imageView3 = this.L;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
            LiveGiftRandomBarView liveGiftRandomBarView3 = this.aZ;
            if (liveGiftRandomBarView3 != null) {
                liveGiftRandomBarView3.setVisibility(8);
            }
            LiveGiftBlindboxBarView liveGiftBlindboxBarView3 = this.ba;
            if (liveGiftBlindboxBarView3 != null) {
                liveGiftBlindboxBarView3.setVisibility(8);
            }
            LiveGiftConstellationView liveGiftConstellationView3 = this.bb;
            if (liveGiftConstellationView3 != null) {
                liveGiftConstellationView3.setVisibility(8);
            }
            if (s() != null) {
                s().i("gift_show");
            }
            S();
        } else if (liveGiftModel.random != null && this.aZ != null) {
            FrameLayout frameLayout4 = this.K;
            if (frameLayout4 != null) {
                frameLayout4.setVisibility(8);
            }
            LiveGiftSetBannerView liveGiftSetBannerView4 = this.aY;
            if (liveGiftSetBannerView4 != null) {
                liveGiftSetBannerView4.setVisibility(8);
            }
            ImageView imageView4 = this.L;
            if (imageView4 != null) {
                imageView4.setVisibility(8);
            }
            LiveGiftBlindboxBarView liveGiftBlindboxBarView4 = this.ba;
            if (liveGiftBlindboxBarView4 != null) {
                liveGiftBlindboxBarView4.setVisibility(8);
            }
            LiveGiftConstellationView liveGiftConstellationView4 = this.bb;
            if (liveGiftConstellationView4 != null) {
                liveGiftConstellationView4.setVisibility(8);
            }
            if (s() != null) {
                this.aZ.a(s(), liveGiftModel.goods_id, liveGiftModel.random);
                this.aZ.setVisibility(0);
                if (s() != null) {
                    s().i("gift_show");
                }
                S();
            }
        } else if (liveGiftModel.constellation != null && this.bb != null) {
            FrameLayout frameLayout5 = this.K;
            if (frameLayout5 != null) {
                frameLayout5.setVisibility(8);
            }
            LiveGiftSetBannerView liveGiftSetBannerView5 = this.aY;
            if (liveGiftSetBannerView5 != null) {
                liveGiftSetBannerView5.setVisibility(8);
            }
            ImageView imageView5 = this.L;
            if (imageView5 != null) {
                imageView5.setVisibility(8);
            }
            LiveGiftBlindboxBarView liveGiftBlindboxBarView5 = this.ba;
            if (liveGiftBlindboxBarView5 != null) {
                liveGiftBlindboxBarView5.setVisibility(8);
            }
            LiveGiftRandomBarView liveGiftRandomBarView4 = this.aZ;
            if (liveGiftRandomBarView4 != null) {
                liveGiftRandomBarView4.setVisibility(8);
            }
            if (s() != null) {
                this.bb.a(s(), liveGiftModel.goods_id, liveGiftModel.constellation);
                this.bb.setVisibility(0);
                if (s() != null) {
                    s().i("gift_show");
                }
                S();
            }
        } else if (liveGiftModel.ops == 19 && liveGiftModel.gameplay_type == 1 && this.ba != null) {
            FrameLayout frameLayout6 = this.K;
            if (frameLayout6 != null) {
                frameLayout6.setVisibility(8);
            }
            LiveGiftSetBannerView liveGiftSetBannerView6 = this.aY;
            if (liveGiftSetBannerView6 != null) {
                liveGiftSetBannerView6.setVisibility(8);
            }
            ImageView imageView6 = this.L;
            if (imageView6 != null) {
                imageView6.setVisibility(8);
            }
            LiveGiftRandomBarView liveGiftRandomBarView5 = this.aZ;
            if (liveGiftRandomBarView5 != null) {
                liveGiftRandomBarView5.setVisibility(8);
            }
            LiveGiftConstellationView liveGiftConstellationView5 = this.bb;
            if (liveGiftConstellationView5 != null) {
                liveGiftConstellationView5.setVisibility(8);
            }
            if (s() != null) {
                String str = this.bn;
                if (str == null || !str.equals(liveGiftModel.goods_id)) {
                    this.bn = liveGiftModel.goods_id;
                    g(liveGiftModel.goods_id);
                    if (s() != null) {
                        s().i("gift_show");
                    }
                    S();
                }
            }
        } else if (liveGiftModel.isScrawlGift()) {
            FrameLayout frameLayout7 = this.K;
            if (frameLayout7 != null) {
                frameLayout7.setVisibility(8);
            }
            LiveGiftSetBannerView liveGiftSetBannerView7 = this.aY;
            if (liveGiftSetBannerView7 != null) {
                liveGiftSetBannerView7.setVisibility(8);
            }
            ImageView imageView7 = this.L;
            if (imageView7 != null) {
                imageView7.setVisibility(8);
            }
            LiveGiftRandomBarView liveGiftRandomBarView6 = this.aZ;
            if (liveGiftRandomBarView6 != null) {
                liveGiftRandomBarView6.setVisibility(8);
            }
            LiveGiftBlindboxBarView liveGiftBlindboxBarView6 = this.ba;
            if (liveGiftBlindboxBarView6 != null) {
                liveGiftBlindboxBarView6.setVisibility(8);
            }
            LiveGiftConstellationView liveGiftConstellationView6 = this.bb;
            if (liveGiftConstellationView6 != null) {
                liveGiftConstellationView6.setVisibility(8);
            }
            if (s() != null) {
                s().i("gift_show");
            }
            S();
        } else if (liveGiftModel.isGiftSet()) {
            FrameLayout frameLayout8 = this.K;
            if (frameLayout8 != null) {
                frameLayout8.setVisibility(8);
            }
            FrameLayout frameLayout9 = this.bl;
            if (frameLayout9 != null) {
                frameLayout9.setVisibility(8);
            }
            ImageView imageView8 = this.L;
            if (imageView8 != null) {
                imageView8.setVisibility(8);
            }
            LiveGiftRandomBarView liveGiftRandomBarView7 = this.aZ;
            if (liveGiftRandomBarView7 != null) {
                liveGiftRandomBarView7.setVisibility(8);
            }
            LiveGiftBlindboxBarView liveGiftBlindboxBarView7 = this.ba;
            if (liveGiftBlindboxBarView7 != null) {
                liveGiftBlindboxBarView7.setVisibility(8);
            }
            LiveGiftConstellationView liveGiftConstellationView7 = this.bb;
            if (liveGiftConstellationView7 != null) {
                liveGiftConstellationView7.setVisibility(8);
            }
            LiveGiftSetBannerView liveGiftSetBannerView8 = this.aY;
            if (liveGiftSetBannerView8 != null) {
                liveGiftSetBannerView8.setVisibility(8);
                this.aY.setVisibility(0);
                View view2 = this.bc;
                if (view2 != null) {
                    this.aY.setGiftWindowHeight(view2.getHeight());
                }
                this.aY.a(liveGiftModel.goods_set_info, getFragmentActive(), this);
            }
            if (s() != null) {
                s().i("gift_info_show");
            }
            S();
        } else {
            LiveGiftSetBannerView liveGiftSetBannerView9 = this.aY;
            if (liveGiftSetBannerView9 != null) {
                liveGiftSetBannerView9.setVisibility(8);
            }
            if (this.K == null) {
                return;
            }
            LiveGiftRandomBarView liveGiftRandomBarView8 = this.aZ;
            if (liveGiftRandomBarView8 != null) {
                liveGiftRandomBarView8.setVisibility(8);
            }
            LiveGiftBlindboxBarView liveGiftBlindboxBarView8 = this.ba;
            if (liveGiftBlindboxBarView8 != null) {
                liveGiftBlindboxBarView8.setVisibility(8);
            }
            LiveGiftConstellationView liveGiftConstellationView8 = this.bb;
            if (liveGiftConstellationView8 != null) {
                liveGiftConstellationView8.setVisibility(8);
            }
            this.Q.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$MKRR7hym6btpSynWpO_NkLfRPvo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    LiveGiftFragment.this.b(liveGiftModel, view3);
                }
            });
            if (!R() && liveGiftModel.show_info == 1 && liveGiftModel.info_type == 2 && !TextUtils.isEmpty(liveGiftModel.info_img)) {
                ImageView imageView9 = this.L;
                if (imageView9 != null) {
                    if (imageView9.getTag() == null || !liveGiftModel.info_img.equals(this.L.getTag())) {
                        this.L.setVisibility(8);
                        this.L.setTag(liveGiftModel.info_img);
                    }
                    ImageLoader.a((IRequestHost) null, liveGiftModel.info_img).a(this.L);
                }
                this.N.setVisibility(8);
                this.K.setVisibility(8);
                if (this.L != null) {
                    EventTrackLive.x(LiveProtos.Event.LIVE_GIFT_POP_GOODS_DETAIL_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id);
                    this.L.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$CatFlNRSY-DhqvPNxuk3vhwbPyk
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            LiveGiftFragment.this.a(liveGiftModel, view3);
                        }
                    });
                    this.L.setVisibility(0);
                }
                if (s() != null) {
                    s().i("gift_banner");
                }
                S();
            } else if (liveGiftModel.show_info != 1 || liveGiftModel.info_type != 1) {
                this.K.setVisibility(8);
                View view3 = this.R;
                if (view3 != null) {
                    view3.setVisibility(8);
                }
                LiveGiftSetBannerView liveGiftSetBannerView10 = this.aY;
                if (liveGiftSetBannerView10 != null) {
                    liveGiftSetBannerView10.setVisibility(8);
                }
                LiveGiftRandomBarView liveGiftRandomBarView9 = this.aZ;
                if (liveGiftRandomBarView9 != null) {
                    liveGiftRandomBarView9.setVisibility(8);
                }
                LiveGiftBlindboxBarView liveGiftBlindboxBarView9 = this.ba;
                if (liveGiftBlindboxBarView9 != null) {
                    liveGiftBlindboxBarView9.setVisibility(8);
                }
                LiveGiftConstellationView liveGiftConstellationView9 = this.bb;
                if (liveGiftConstellationView9 != null) {
                    liveGiftConstellationView9.setVisibility(8);
                }
                if (R() || TextUtils.isEmpty(this.be)) {
                    ImageView imageView10 = this.L;
                    if (imageView10 != null) {
                        imageView10.setVisibility(8);
                    }
                    if (s() != null) {
                        s().i("gift_show");
                    }
                } else {
                    ImageView imageView11 = this.L;
                    if (imageView11 != null) {
                        if (imageView11.getTag() == null || !this.be.equals(this.L.getTag())) {
                            this.L.setVisibility(8);
                            ImageLoader.a((IRequestHost) null, this.be).a(this.L);
                            this.L.setTag(this.be);
                            EventTrackLive.r(LiveProtos.Event.LIVE_BATTLE_PASS_COMMON_EXPLAIN_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this.be);
                        }
                        this.L.setVisibility(0);
                        this.L.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$CqzmJ-gg5elmHxhRIgnD8ud9zk4
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view4) {
                                LiveGiftFragment.this.c(view4);
                            }
                        });
                    }
                    if (s() != null) {
                        s().i("gift_banner");
                    }
                }
                S();
            } else {
                this.K.setVisibility(8);
                ImageView imageView12 = this.L;
                if (imageView12 != null) {
                    imageView12.setVisibility(8);
                }
                LiveGiftRandomBarView liveGiftRandomBarView10 = this.aZ;
                if (liveGiftRandomBarView10 != null) {
                    liveGiftRandomBarView10.setVisibility(8);
                }
                LiveGiftBlindboxBarView liveGiftBlindboxBarView10 = this.ba;
                if (liveGiftBlindboxBarView10 != null) {
                    liveGiftBlindboxBarView10.setVisibility(8);
                }
                LiveGiftConstellationView liveGiftConstellationView10 = this.bb;
                if (liveGiftConstellationView10 != null) {
                    liveGiftConstellationView10.setVisibility(8);
                }
                if (TextUtils.isEmpty(liveGiftModel.info_title)) {
                    this.O.setVisibility(8);
                } else {
                    this.O.setVisibility(0);
                    this.O.setText(liveGiftModel.info_title);
                }
                if (TextUtils.isEmpty(liveGiftModel.info_url)) {
                    this.Q.setVisibility(8);
                } else {
                    this.Q.setVisibility(0);
                }
                if (TextUtils.isEmpty(liveGiftModel.info_content)) {
                    this.P.setVisibility(8);
                } else {
                    this.K.setVisibility(0);
                    this.P.setVisibility(0);
                    this.P.setText(liveGiftModel.info_content);
                    this.P.setFadingEdgeLength(DisplayUtil.a(AppInfo.d(), 10.0f));
                    this.P.setSingleLine(true);
                    this.P.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                    this.P.setHorizontallyScrolling(true);
                    this.P.setMarqueeRepeatLimit(-1);
                    this.P.requestFocus();
                    this.P.setSelected(true);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.P.getLayoutParams();
                    marginLayoutParams.rightMargin = this.Q.getVisibility() == 0 ? DensityUtils.a(getContext(), 8.0f) : 0;
                    marginLayoutParams.leftMargin = this.O.getVisibility() == 0 ? DensityUtils.a(getContext(), 8.0f) : 0;
                }
                this.N.setVisibility(0);
                if (s() != null) {
                    s().i("gift_info_show");
                }
                S();
            }
        }
    }

    public void b(boolean z) {
    }

    @Override // com.blued.android.module.common.fragment.BaseGiftRootFragment
    public String c() {
        if (this.b.size() > 0) {
            for (LiveGiftModel liveGiftModel : ((CommonGiftPackageModel) this.b.get(0)).goods) {
                if (liveGiftModel.beans > 0) {
                    LogUtils.c(liveGiftModel.index);
                    return liveGiftModel.index;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.blued.android.module.common.fragment.BaseGiftRootFragment
    public void c(int i) {
        View view;
        LiveGiftSetComboView liveGiftSetComboView;
        h(i);
        if (i < this.b.size()) {
            LiveGiftPackageModel liveGiftPackageModel = (LiveGiftPackageModel) this.b.get(i);
            LogUtils.d("==blog", "选中Tab切" + liveGiftPackageModel.red_point);
            if (liveGiftPackageModel.red_point == 1 && liveGiftPackageModel.red_point_cancel == 1) {
                liveGiftPackageModel.hasNew = false;
                liveGiftPackageModel.red_point = 0;
                liveGiftPackageModel.red_point_cancel = 0;
                LiveRoomHttpUtils.b((BluedUIHttpResponse) null, liveGiftPackageModel.red_point_word);
                a(i);
            }
            if (liveGiftPackageModel == null) {
                return;
            }
            if (liveGiftPackageModel.packageType == 1 || liveGiftPackageModel.packageType == 2 || liveGiftPackageModel.goods.size() == 0 || (((view = this.an) != null && view.getVisibility() == 0) || ((liveGiftSetComboView = this.aX) != null && liveGiftSetComboView.g()))) {
                this.C.setVisibility(8);
            } else {
                this.C.setVisibility(0);
            }
            if (liveGiftPackageModel.hasNew) {
                liveGiftPackageModel.hasNew = false;
                this.f10811a.setData(this.b);
                LiveRoomHttpUtils.c();
            }
            if (!this.aL) {
                EventTrackLive.k(LiveProtos.Event.LIVE_GIFT_PAGE, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftPackageModel.type_name);
                EventTrackLive.k(LiveProtos.Event.LIVE_GIFT_POP_GIFT_TAB_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftPackageModel.type_name);
                return;
            }
            EventTrackLive.k(LiveProtos.Event.LIVE_GIFT_POP_PACK_TAB_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftPackageModel.type_name);
            if (liveGiftPackageModel.packageType == 5) {
                EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_COUPON_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            }
        }
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    public void c(BasePayRemaining basePayRemaining) {
        super.c(basePayRemaining);
        if (basePayRemaining.bonus <= 0) {
            this.I.setVisibility(8);
            return;
        }
        this.I.setVisibility(0);
        TextView textView = this.I;
        textView.setText("(" + String.format(getResources().getString(R.string.live_contain), CommonStringUtils.d(String.valueOf(basePayRemaining.bonus))) + ")");
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    public void c(CommonLiveGiftModel commonLiveGiftModel) {
        if (commonLiveGiftModel != null) {
            LiveGiftModel liveGiftModel = (LiveGiftModel) commonLiveGiftModel;
            if (liveGiftModel.ops == 15) {
                EventTrackLive.c(LiveProtos.Event.LIVE_GIFT_MORE_HITS, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id, liveGiftModel.hit_count);
                LogUtils.c("进阶礼物埋点：" + liveGiftModel.hit_count);
            }
        }
        super.c(commonLiveGiftModel);
        this.bt = false;
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$FsDd-EeigitqVIRWVN_NCpbt8cc
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftFragment.this.ab();
            }
        }, 100L);
    }

    public void c(LiveGiftModel liveGiftModel) {
        if (this.aX == null) {
            return;
        }
        if (liveGiftModel == null || !liveGiftModel.isGiftSet()) {
            Z();
        } else if (!LiveGiftSetComboView.f14486a.a(liveGiftModel.goods_set_info.getId())) {
            Z();
        } else {
            this.C.setVisibility(8);
            this.aX.a(liveGiftModel.goods_set_info);
            this.aX.setEventCallBack(new LiveGiftSetComboView.EventCallBack() { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.22
                @Override // com.blued.android.module.live_china.view.LiveGiftSetComboView.EventCallBack
                public void a() {
                    LiveGiftFragment.this.J();
                }

                @Override // com.blued.android.module.live_china.view.LiveGiftSetComboView.EventCallBack
                public void b() {
                    if (LiveGiftFragment.this.aY != null) {
                        LiveGiftFragment.this.aY.b();
                    }
                    LiveGiftFragment.this.Z();
                }
            });
        }
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    public void c(List<LiveGiftNumberModel> list) {
        super.c(list);
        if (TypeUtils.a((List<?>) list)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.ai.getLayoutParams();
        layoutParams.height = DisplayUtil.a(this.ai.getContext(), list.size() * 34);
        this.ai.setLayoutParams(layoutParams);
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment, com.blued.android.module.common.fragment.BaseGiftRootFragment
    public void d() {
        super.d();
        this.aT = true;
    }

    public void d(int i) {
        if (getContext() == null || getFragmentActive() == null || !getFragmentActive().isActive() || i == 0) {
            return;
        }
        for (CommonGiftPackageModel commonGiftPackageModel : this.b) {
            for (LiveGiftModel liveGiftModel : commonGiftPackageModel.goods) {
                if (liveGiftModel.goods_set_info != null && liveGiftModel.isGiftSet() && liveGiftModel.goods_set_info.getId() == i) {
                    liveGiftModel.goods_set_info.setExpire_time(0);
                }
            }
        }
        LiveGiftModel liveGiftModel2 = this.aH;
        if (liveGiftModel2 != null && liveGiftModel2.isGiftSet() && this.aH.goods_set_info.getId() == i) {
            this.aH.goods_set_info.setExpire_time(0);
            a(this.aH, true);
            LiveGiftSetBannerView liveGiftSetBannerView = this.aY;
            if (liveGiftSetBannerView != null) {
                liveGiftSetBannerView.setVisibility(0);
                this.aY.a(this.aH.goods_set_info, getFragmentActive(), this);
            }
        }
    }

    public void e(int i) {
        int i2;
        int i3 = i;
        if (i == 0) {
            i3 = 1;
        }
        LiveGiftModel liveGiftModel = this.aH;
        if (liveGiftModel != null && liveGiftModel.selectNumModel != null && this.aH.selectNumModel.isUserDefined) {
            this.aH.selectNumModel.count = i3;
            int i4 = 0;
            while (true) {
                i2 = i4;
                if (i2 >= this.aH.groups.size() || (!this.aH.groups.get(i2).isUserDefined && i3 >= this.aH.groups.get(i2).count)) {
                    break;
                }
                i4 = i2 + 1;
            }
            LogUtils.c("index: " + i2);
            if (i2 < this.aH.groups.size()) {
                this.aH.selectNumModel.gift_pic_mp4 = this.aH.groups.get(i2).gift_pic_mp4;
                LogUtils.c("use: " + this.aH.groups.get(i2).count);
            }
        }
        F();
    }

    public void e(String str) {
        LogUtils.c("checkSavePayToken: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            BluedEntityA bluedEntityA = (BluedEntityA) AppInfo.f().fromJson(str, new TypeToken<BluedEntityA<PayRemaining>>() { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.9
            }.getType());
            if (bluedEntityA.hasData()) {
                String str2 = ((PayRemaining) bluedEntityA.data.get(0)).token;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                LiveRoomPreferences.c(str2);
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    public void f(String str) {
        LiveGiftPackageModel liveGiftPackageModel;
        if (str == null) {
            return;
        }
        String[] split = str.split(BridgeUtil.UNDERLINE_STR);
        if (split.length < 2) {
            return;
        }
        int a2 = CommonStringUtils.a(split[0]);
        int a3 = CommonStringUtils.a(split[1]);
        if (a2 >= this.b.size() || (liveGiftPackageModel = (LiveGiftPackageModel) this.b.get(a2)) == null) {
            return;
        }
        if (liveGiftPackageModel.packageType == 3) {
            this.ay.setImageResource(R.drawable.live_gift_avatar_qa_tips);
            this.ax.setPadding(a3 - DisplayUtil.a(this.ay.getContext(), 53.0f), 0, 0, 0);
            this.ax.setVisibility(0);
        } else if (liveGiftPackageModel.packageType == 4) {
            this.ay.setImageResource(R.drawable.live_gift_bubble_qa_tips);
            this.ax.setPadding(a3 - DisplayUtil.a(this.ay.getContext(), 98.0f), 0, 0, 0);
            this.ax.setVisibility(0);
        } else if (liveGiftPackageModel.packageType != 5) {
            this.ax.setVisibility(8);
        } else {
            this.ay.setImageResource(R.drawable.live_gift_coupon_qa_tips);
            this.ax.setPadding(a3 - DisplayUtil.a(this.ay.getContext(), 96.0f), 0, 0, 0);
            this.ax.setVisibility(0);
        }
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    public String g() {
        return "live_gift";
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    /* renamed from: i */
    public void al() {
        LogUtils.d("pLog", "Live Gift Fragment getGiftList");
        LiveRoomHttpUtils.f(new AnonymousClass15(getFragmentActive()));
        LiveRoomHttpUtils.h(new BluedUIHttpResponse<BluedEntity<CountModel, LiveCouponNoticeExtra>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.16
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<CountModel, LiveCouponNoticeExtra> bluedEntity) {
                boolean z = false;
                if (!LiveGiftFragment.this.j() || bluedEntity == null || bluedEntity.extra == null) {
                    LiveGiftFragment.this.aQ = false;
                    return;
                }
                LiveGiftFragment liveGiftFragment = LiveGiftFragment.this;
                if (bluedEntity.extra.has_new == 1) {
                    z = true;
                }
                liveGiftFragment.aQ = z;
            }
        });
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    public int k() {
        LiveGiftModel liveGiftModel = this.aH;
        if (liveGiftModel == null || liveGiftModel.selectNumModel == null || this.aH.selectNumModel.count <= 0) {
            return 1;
        }
        return this.aH.selectNumModel.count;
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    /* renamed from: m */
    public void ak() {
        StringBuilder sb = new StringBuilder();
        sb.append("onClickClose **********   ");
        sb.append(this.aU.getVisibility() == 0);
        LogUtils.d("pLog", sb.toString());
        this.bn = null;
        if (this.aV.booleanValue()) {
            A();
        }
        if (s() != null) {
            s().aJ();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if ((i == 4221005 || i == 4221004) && intent != null) {
                LiveGiftModel liveGiftModel = (LiveGiftModel) intent.getSerializableExtra("selected_model");
                String stringExtra = intent.getStringExtra("password");
                boolean booleanExtra = intent.getBooleanExtra("remember_me", false);
                int intExtra = intent.getIntExtra("gift_count", 1);
                if (TextUtils.isEmpty(stringExtra) || liveGiftModel == null) {
                    return;
                }
                a(liveGiftModel, intExtra, stringExtra, booleanExtra);
            } else if (i != 4221002 || intent == null) {
                if (i == 100018) {
                    L();
                }
            } else {
                a((LiveGiftModel) intent.getSerializableExtra("selected_model"), intent.getIntExtra("gift_count", 1), intent.getStringExtra("password"), intent.getBooleanExtra("remember_me", false));
            }
        }
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment, com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        if (this.aU.getVisibility() == 0) {
            A();
            return true;
        } else if (super.onBackPressed()) {
            return true;
        } else {
            this.bn = null;
            if (isHidden()) {
                return false;
            }
            if (s() != null) {
                s().aJ();
                return true;
            }
            return true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.top_up_view) {
            if (s().aE()) {
                if (!LiveDataManager.a().f()) {
                    LiveRoomInfo.a().a(getContext(), getFragmentManager(), 10);
                    return;
                }
                s().b(true);
                LiveRoomInfo.a().a(getContext(), 3);
            }
        } else if (view.getId() == R.id.give_gift_view) {
            I();
        } else if (view.getId() == R.id.live_gift_combo_btn_layout) {
            LiveGiftModel liveGiftModel = this.aH;
            if (liveGiftModel == null || liveGiftModel.ops == 5 || this.aH.ops == 1101 || this.aH.double_hit != 1) {
                return;
            }
            W();
            J();
        } else if (view.getId() == R.id.gift_select_num_view) {
            LiveGiftModel liveGiftModel2 = this.aH;
            if (liveGiftModel2 == null || TypeUtils.a((List<?>) liveGiftModel2.groups)) {
                return;
            }
            int k = k();
            ArrayList arrayList = new ArrayList();
            for (LiveGiftNumberModel liveGiftNumberModel : this.aH.groups) {
                if (liveGiftNumberModel.count == k) {
                    liveGiftNumberModel.selected = true;
                } else {
                    liveGiftNumberModel.selected = false;
                }
                arrayList.add(liveGiftNumberModel);
            }
            c(arrayList);
        } else if (view.getId() == R.id.live_pk_tips_btn) {
            b(true);
        } else if (view.getId() == R.id.gift_progress_layout) {
            LiveRoomInfo.a().a(getActivity(), LiveRoomInfo.a().z());
            EventTrackLive.b(LiveProtos.Event.LIVE_GIFT_LEVEL_BAR_CLICK, LiveRoomManager.a().e());
        } else if (view.getId() == R.id.live_gift_banner || view.getId() == R.id.ll_gift_info_look) {
            d(this.aH);
        } else if (view.getId() == R.id.fl_noble && !TextUtils.isEmpty(this.bd)) {
            LiveSetDataObserver.a().c(this.bd, 20);
        }
    }

    @Override // com.blued.android.framework.ui.SimpleFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.F = null;
        this.bv = null;
        this.bn = null;
        Log.d("wangzihang", "LiveGiftFragment onDestroy");
        DialogUtils.b(this.aP);
        LiveGiftSetComboView liveGiftSetComboView = this.aX;
        if (liveGiftSetComboView != null) {
            liveGiftSetComboView.f();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        LiveGiftSetComboView liveGiftSetComboView = this.aX;
        if (liveGiftSetComboView != null) {
            liveGiftSetComboView.setEventCallBack(null);
        }
        LiveEventBus.get("live_gift_set_buy_success", LiveGiftSetBuyModel.class).removeObserver(this.bo);
        LiveEventBus.get("live_gift_set_buy_count_end", Integer.class).removeObserver(this.bp);
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        LogUtils.c("onHiddenChanged:" + z);
        if (z) {
            this.u = 0L;
            a((CommonLiveGiftModel) a(this.f10812c), 0);
            if (!LiveDataManager.a().f()) {
                b(false);
            }
            Z();
            aa();
            LiveSetDataObserver.a().e(0);
            LiveSetDataObserver.a().b(false);
            N();
            s().g(0);
            DialogUtils.b(this.aP);
            s().i("gift_hide");
            i(0);
            return;
        }
        this.y = null;
        this.aL = false;
        this.aT = true;
        M();
        if (LiveDataManager.a().f()) {
            LiveSetDataObserver.a().e(0);
        } else {
            LiveSetDataObserver.a().e(4);
            if (s().r()) {
                t();
            }
        }
        LiveSetDataObserver.a().b(true);
        EventTrackLive.a(LiveProtos.Event.LIVE_VIEWERS_GIFT_BTN_CLICK);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$ohGYGW-1F1ggrhR64Bs2tt3KbzI
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftFragment.this.al();
            }
        }, 300L);
        l(0);
        a(LiveRoomManager.a().p().custom_rank);
        c(this.aH);
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment, com.blued.android.module.common.fragment.BaseGiftRootFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitListener() {
        ViewGroup viewGroup;
        super.onInitListener();
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$B9e7_uiwtK-VJFdOfDPGDYFWBCk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftFragment.this.a(view);
            }
        });
        View view = this.am;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$MVBJufenJjhC9UYvhcKOFJ2eTmk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LiveGiftFragment.this.f(view2);
                }
            });
        }
        this.Y.setOnClickListener(this);
        this.ad.setOnClickListener(this);
        this.ae.setOnClickListener(this);
        this.rootView.findViewById(R.id.ll_switch_gift_bag).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                LiveGiftFragment.this.a((LiveDefaultGiftModel) null);
                EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_POP_PACK_BTN_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            }
        });
        this.ax.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$gq8M1ZRQp45nGXG0SugzhOx6yD0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LiveGiftFragment.this.e(view2);
            }
        });
        View view2 = this.R;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$zrcEKGZdwtMVjMfRttNdmltLZMA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    LiveGiftFragment.this.d(view3);
                }
            });
        }
        if (this.az != null && (viewGroup = this.C) != null && viewGroup.getParent() != null && this.D != null) {
            ((ViewGroup) this.C.getParent()).addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$GP7FBnA2tnM1UwWIVAcgQxBAnKI
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    LiveGiftFragment.this.a(view3, i, i2, i3, i4, i5, i6, i7, i8);
                }
            });
        }
        LiveEventBus.get("live_fans_guide_pop", Boolean.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$ilzdHeMbgiXN42-qhBGoBSPpXfI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftFragment.this.d((Boolean) obj);
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_LIVE_REFRESH_GIFT_LIST, Boolean.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$1uq85oWJoW2KZodjMjwZvL8l9tM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftFragment.this.c((Boolean) obj);
            }
        });
        LiveEventBus.get("live_equip_effect_gift", LiveGiftModel.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$eUc7xGJiR78R3H4eZPs8hK5ah5w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftFragment.this.f((LiveGiftModel) obj);
            }
        });
        LiveEventBus.get("live_update_item_gift", LiveGiftModel.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$D68bTWQ3pJ94-XTXDwTMkpOudaE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftFragment.this.e((LiveGiftModel) obj);
            }
        });
        LiveEventBus.get("screen_orientation_changed", Boolean.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$FyiNLf3Wu6N_IzSBx5srXQB9Duc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftFragment.this.b((Boolean) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.d, PayResultEvent.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$O-AMuXxI-5krZEouUQyEvUCqMIU
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftFragment.this.a((PayResultEvent) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.r, String.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$U2WJ1VpAyKAzxjOnXWo6aJ_QYII
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftFragment.this.f((String) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.u, LiveGiftSkinItemModel.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$uPhdNd4bQ_pGQJK6pryKyTzfGuQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftFragment.this.a((LiveGiftSkinItemModel) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.j, Integer.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$ESp5jber8NGP3o_0KIid0Ge993w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftFragment.this.c((Integer) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.w, Integer.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$UbTdbCU5SDZT80l2w46kYaQcn-M
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftFragment.this.b((Integer) obj);
            }
        });
        LiveEventBus.get("live_show_gift_bag_red_dot", Boolean.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$_JGdH-Btp8FIYp30FXEbrhBRDDY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftFragment.this.a((Boolean) obj);
            }
        });
        LiveEventBus.get("live_hide_gift_behalf_view", Long.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$3vaCIGTYFFz_wRoloZ2msJPXBQ4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftFragment.this.a((Long) obj);
            }
        });
        LiveEventBus.get("live_gift_set_buy_success", LiveGiftSetBuyModel.class).observe(this, this.bo);
        LiveEventBus.get("live_gift_set_buy_count_end", Integer.class).observe(this, this.bp);
        LiveEventBus.get("live_pay_remain_update", BasePayRemaining.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$X0Pd0xzkZ5KMZQSaoJpo063hzF8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftFragment.this.d((BasePayRemaining) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.U, Integer.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$WO7ZIJZE7ndAmHufle9eS2oNgE8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftFragment.this.a((Integer) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.V, GiftConstellationBuyInfoModel.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$ZyIVPN5pj-Rgx7oqq8ZURTITIdQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftFragment.this.a((GiftConstellationBuyInfoModel) obj);
            }
        });
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment, com.blued.android.module.common.fragment.BaseGiftRootFragment, com.blued.android.module.common.fragment.BaseViewPagerParentFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        LinearLayout linearLayout;
        super.onInitView();
        this.w = getString(R.string.Live_SendPresent_recharge);
        this.I = (TextView) this.rootView.findViewById(R.id.give_price_view);
        this.J = (LinearLayout) this.rootView.findViewById(R.id.live_gift_content_view);
        this.m = (TextView) this.rootView.findViewById(R.id.give_gift_view);
        this.n = this.rootView.findViewById(R.id.live_gift_blank_view);
        this.aj = (ImageView) this.rootView.findViewById(R.id.live_gift_scrawl_guide_iv);
        this.ak = this.rootView.findViewById(R.id.live_gift_scrawl_guide_root);
        this.al = this.rootView.findViewById(R.id.live_gift_scrawl_guide_layout);
        this.am = this.rootView.findViewById(R.id.live_gift_scrawl_guide_close_btn);
        this.aU = (FrameLayout) this.rootView.findViewById(R.id.fl_live_gift_backpack);
        this.G = (TextView) this.rootView.findViewById(R.id.gift_msg_view);
        this.H = (LinearLayout) this.rootView.findViewById(R.id.gift_top_layout);
        this.K = (FrameLayout) this.rootView.findViewById(R.id.fl_gift_info_layout);
        this.L = (ImageView) this.rootView.findViewById(R.id.live_gift_banner);
        this.M = (ImageView) this.rootView.findViewById(R.id.iv_gift_info_image);
        this.N = this.rootView.findViewById(R.id.ll_gift_info_content);
        this.O = (TextView) this.rootView.findViewById(R.id.tv_gift_info_name);
        this.P = (TextView) this.rootView.findViewById(R.id.tv_gift_info_des);
        this.Q = this.rootView.findViewById(R.id.ll_gift_info_look);
        this.aW = (ShapeTextView) this.rootView.findViewById(R.id.tv_gift_bad_dot);
        this.bc = this.rootView.findViewById(R.id.fl_main);
        this.aY = (LiveGiftSetBannerView) this.rootView.findViewById(R.id.gift_set_banner);
        this.aZ = (LiveGiftRandomBarView) this.rootView.findViewById(R.id.live_random_gift_bar);
        this.ba = (LiveGiftBlindboxBarView) this.rootView.findViewById(R.id.live_blind_box_gift_bar);
        this.bb = (LiveGiftConstellationView) this.rootView.findViewById(R.id.live_constellation_gift_bar);
        this.X = this.rootView.findViewById(R.id.live_pk_tips);
        this.Y = this.rootView.findViewById(R.id.live_pk_tips_btn);
        this.Z = (TextView) this.rootView.findViewById(R.id.current_level);
        this.aa = (ProgressBar) this.rootView.findViewById(R.id.gift_progress);
        this.ab = (TextView) this.rootView.findViewById(R.id.next_level);
        this.ac = (TextView) this.rootView.findViewById(R.id.grow_up_text);
        this.ad = this.rootView.findViewById(R.id.gift_progress_layout);
        this.ae = this.rootView.findViewById(R.id.fl_noble);
        this.af = (ImageView) this.rootView.findViewById(R.id.iv_noble);
        this.R = this.rootView.findViewById(R.id.live_gift_skin_layout);
        this.S = (ImageView) this.rootView.findViewById(R.id.live_gift_skin_iv);
        this.T = (TextView) this.rootView.findViewById(R.id.live_gift_skin_current_level);
        this.U = (ProgressBar) this.rootView.findViewById(R.id.live_gift_skin_progress);
        this.W = (TextView) this.rootView.findViewById(R.id.live_gift_skin_count_tv);
        this.V = (TextView) this.rootView.findViewById(R.id.live_gift_skin_next_level);
        this.az = (ImageView) this.rootView.findViewById(R.id.live_gift_first_charge_iv);
        this.g = (TextView) this.rootView.findViewById(R.id.price_view);
        this.o = (TextView) this.rootView.findViewById(R.id.gift_select_num_text);
        this.q = (ImageView) this.rootView.findViewById(R.id.gift_select_num_image);
        this.p = (LinearLayout) this.rootView.findViewById(R.id.gift_select_num_view);
        this.l = (TextView) this.rootView.findViewById(R.id.top_up_view);
        this.C = (ViewGroup) this.rootView.findViewById(R.id.live_gift_send_layout);
        this.D = (ViewGroup) this.rootView.findViewById(R.id.view_space);
        this.r = this.rootView.findViewById(R.id.live_gift_number_select_layout);
        this.ai = this.rootView.findViewById(R.id.live_gift_number_select_card);
        this.s = (ListView) this.rootView.findViewById(R.id.live_gift_number_select_list);
        this.ag = this.rootView.findViewById(R.id.live_fans_guide);
        this.ah = (TextView) this.rootView.findViewById(R.id.live_gift_switch_bag);
        this.E = this.rootView.findViewById(R.id.live_gift_no_data_layout);
        this.ax = (FrameLayout) this.rootView.findViewById(R.id.live_gift_avatar_qa_layout);
        this.ay = (ImageView) this.rootView.findViewById(R.id.live_gift_avatar_qa_iv);
        this.aX = (LiveGiftSetComboView) this.rootView.findViewById(R.id.live_gift_set_combo_view);
        this.an = this.rootView.findViewById(R.id.live_gift_combo_layout);
        this.ao = this.rootView.findViewById(R.id.live_gift_combo_line);
        this.ap = this.rootView.findViewById(R.id.live_gift_combo_btn_layout);
        this.aq = (ImageView) this.rootView.findViewById(R.id.live_gift_combo_btn_click_bg);
        this.f13829ar = (ImageView) this.rootView.findViewById(R.id.live_gift_combo_btn_mid);
        this.as = this.rootView.findViewById(R.id.live_gift_combo_count_parent);
        this.at = this.rootView.findViewById(R.id.live_gift_combo_count_layout);
        this.au = (TextView) this.rootView.findViewById(R.id.live_gift_combo_count_tv);
        this.av = (CircleProgressView) this.rootView.findViewById(R.id.live_gift_combo_progress);
        BubbleLayout bubbleLayout = (BubbleLayout) this.rootView.findViewById(R.id.live_gift_combo_bubble);
        this.aw = bubbleLayout;
        bubbleLayout.setShakeWidth(DisplayUtil.a(AppInfo.d(), 75.0f));
        this.ap.setOnClickListener(this);
        this.an.setVisibility(8);
        this.av.setMaxValue(100.0f);
        this.av.setBarColor(Color.parseColor("#FFD041"), Color.parseColor("#FFFDB3"), Color.parseColor("#FFD041"));
        this.av.setBarWidth(DensityUtils.a(AppInfo.d(), 4.0f));
        this.av.setRimWidth(DensityUtils.a(AppInfo.d(), 4.0f));
        this.av.setRimColor(0);
        this.av.setBarStrokeCap(Paint.Cap.ROUND);
        this.aW = (ShapeTextView) this.rootView.findViewById(R.id.tv_gift_bad_dot);
        C();
        B();
        this.aF = getResources().getString(R.string.suspend_renewals);
        this.aD = getResources().getString(R.string.equipment);
        this.aE = getResources().getString(R.string.cancel_equipment);
        this.x = true;
        this.aO = DisplayUtil.a(AppInfo.d(), 5.0f);
        this.aP = DialogUtils.a(getActivity());
        if (this.J != null) {
            LayoutTransition layoutTransition = new LayoutTransition();
            float a2 = DensityUtils.a(getContext(), 10.0f);
            layoutTransition.setAnimator(2, ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("translationY", a2, 0.0f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f)));
            layoutTransition.setAnimator(3, ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("translationY", 0.0f, a2), PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f)));
            layoutTransition.setDuration(200L);
            this.J.setLayoutTransition(layoutTransition);
        }
        if (this.L == null || (linearLayout = this.J) == null) {
            return;
        }
        linearLayout.post(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftFragment$LFBNWNiZ2VCkMCpq_CiDl5cYMAQ
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftFragment.this.am();
            }
        });
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment, com.blued.android.module.common.fragment.BaseViewPagerParentFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitViewFinished() {
        super.onInitViewFinished();
        if (this.aj != null) {
            ImageLoader.c(getFragmentActive(), "live_gift_scrawl_guide_icon.png").e((int) SystemClock.elapsedRealtime()).g(-1).a(this.aj);
        }
        l(LiveRoomManager.a().p().rechargeGiftBagIconShowType);
        a(LiveRoomManager.a().p().custom_rank);
        ImageLoader.c(getFragmentActive(), "live_noble_gift_icon.png").g(-1).e(this.af.hashCode()).a(this.af);
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment, com.blued.android.framework.ui.SimpleFragment
    public void onLoadData() {
        super.onLoadData();
        if (!this.aL && !TypeUtils.a((List<?>) LiveDataManager.a().b(h()))) {
            this.b.clear();
            this.b.addAll(LiveDataManager.a().b(h()));
            d();
        }
        LiveRoomHttpUtils.d();
        w();
        u();
    }

    @Override // com.blued.android.module.common.fragment.BaseGiftRootFragment, com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        return LiveDataManager.a().f() ? R.layout.fragment_live_gift_land : R.layout.fragment_live_gift;
    }

    public PlayingOnliveFragment s() {
        return (PlayingOnliveFragment) getParentFragment();
    }

    public void t() {
    }

    public void u() {
        LiveRoomHttpUtils.r(new BluedUIHttpResponse<BluedEntityA<LiveLevelModel>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.14
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveLevelModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                LiveLevelModel singleData = bluedEntityA.getSingleData();
                if (singleData.info != null) {
                    LiveGiftFragment.this.aG = singleData.info;
                    LiveRoomInfo.a().a(LiveGiftFragment.this.aG.rich_level);
                    if (LiveGiftFragment.this.aG.next_rich_level == -1 || LiveGiftFragment.this.aL) {
                        LiveGiftFragment.this.ad.setVisibility(4);
                        return;
                    }
                    LiveGiftFragment.this.ad.setVisibility(0);
                    LiveGiftFragment.this.O();
                }
            }
        }, LiveRoomInfo.a().f());
    }

    public LiveGoodsBehalfExtra v() {
        return this.bq;
    }

    public void w() {
        if (s() == null) {
            return;
        }
        LiveRoomHttpUtils.t(new BluedUIHttpResponse<BluedEntityA<LiveGiftBagModel>>(s().getFragmentActive()) { // from class: com.blued.android.module.live_china.mine.LiveGiftFragment.19
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveGiftBagModel> bluedEntityA) {
                LogUtils.a("getGiftBag成功");
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                LiveGiftBagModel singleData = bluedEntityA.getSingleData();
                LogUtils.a("liveGiftBagModel = " + singleData.toString());
                LiveMsgSendManager a2 = LiveMsgSendManager.a();
                a2.d("首冲礼包 上架状态：" + singleData.is_shelves_new + " -- 充值购买状态：" + singleData.buy_state);
                if (singleData.is_shelves_new == 1) {
                    if (singleData.buy_state == 0) {
                        EventTrackLive.a(LiveProtos.Event.LIVE_VIEWERS_FIRST_PAY_BTN_SHOW);
                    } else if (singleData.buy_state == 1) {
                        EventTrackLive.a(LiveProtos.Event.LIVE_VIEWERS_FIRST_PAY_BTN_SHOW);
                    } else {
                        int i = singleData.buy_state;
                    }
                }
            }
        });
    }

    public void x() {
        this.ag.setVisibility(0);
        T();
    }

    public void y() {
        CountDownTimer countDownTimer = this.aI;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void z() {
        View view = this.R;
        if (view != null) {
            view.setVisibility(8);
            if (s() != null) {
                s().i("gift_show");
            }
            S();
        }
        LiveGiftModel liveGiftModel = this.aH;
        LiveRouteUtil.a(this, liveGiftModel != null ? liveGiftModel.goods_id : null);
        EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_SKIN_INTRODUCE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }
}
