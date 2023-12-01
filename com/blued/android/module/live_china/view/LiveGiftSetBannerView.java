package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveGiftSetBannerViewBinding;
import com.blued.android.module.live_china.fragment.LiveGiftSetDialogFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveGiftSetBuyModel;
import com.blued.android.module.live_china.model.LiveGiftSetInfoModel;
import com.blued.android.module.live_china.model.LiveGiftSetItemModel;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.EventTrackLive;
import com.blued.android.module.live_china.view.LiveGiftSetBannerView;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveGiftSetBannerView.class */
public final class LiveGiftSetBannerView extends FrameLayout {
    private final Lazy a;
    private MyAdapter b;
    private IRequestHost c;
    private Fragment d;
    private boolean e;
    private String f;
    private int g;
    private LiveGiftSetInfoModel h;
    private LiveGiftSetBuyModel i;
    private boolean j;
    private boolean k;
    private boolean l;
    private Runnable m;
    private boolean n;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveGiftSetBannerView$MyAdapter.class */
    public final class MyAdapter extends CommonRecycleAdapter<LiveGiftSetItemModel> {
        final /* synthetic */ LiveGiftSetBannerView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyAdapter(LiveGiftSetBannerView this$0) {
            super(this$0.getContext());
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(LiveGiftSetBannerView this$0, View view) {
            Intrinsics.e(this$0, "this$0");
            this$0.d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(LiveGiftSetItemModel item, int i, CommonRecycleAdapter.CommonAdapterHolder helper) {
            Intrinsics.e(item, "item");
            Intrinsics.e(helper, "helper");
            ImageLoader.a((IRequestHost) null, item.getImage()).e(-1).a((ImageView) helper.a(R.id.iv_icon));
            TextView textView = (TextView) helper.a(R.id.tv_name);
            StringBuilder sb = new StringBuilder();
            sb.append(item.getCount());
            sb.append('/');
            sb.append(item.getTotal());
            textView.setText(sb.toString());
            View a = helper.a(R.id.ll_root);
            final LiveGiftSetBannerView liveGiftSetBannerView = this.a;
            a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftSetBannerView$MyAdapter$PMm3TxCwTHejDCjOg-sMTG6_03Q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGiftSetBannerView.MyAdapter.a(LiveGiftSetBannerView.this, view);
                }
            });
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return R.layout.live_gift_set_banner_item;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveGiftSetBannerView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveGiftSetBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveGiftSetBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.a = LazyKt.a(new Function0<LiveGiftSetBannerViewBinding>() { // from class: com.blued.android.module.live_china.view.LiveGiftSetBannerView$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveGiftSetBannerViewBinding invoke() {
                return LiveGiftSetBannerViewBinding.a(LayoutInflater.from(LiveGiftSetBannerView.this.getContext()), LiveGiftSetBannerView.this, true);
            }
        });
        this.f = "";
        this.m = new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftSetBannerView$KNwKWZBjRwZyMwZNsJlsSbeJcmE
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftSetBannerView.a(LiveGiftSetBannerView.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, String str) {
        if (i == 4221008) {
            f();
            return;
        }
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        AppMethods.a((CharSequence) str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftSetBannerView this$0) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.e) {
            this$0.k = false;
            this$0.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftSetBannerView this$0, DialogInterface dialogInterface) {
        Intrinsics.e(this$0, "this$0");
        this$0.n = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftSetBannerView this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.n = false;
        if (this$0.d != null) {
            LiveRoomInfo a = LiveRoomInfo.a();
            Context context = this$0.getContext();
            Fragment fragment = this$0.d;
            Intrinsics.a(fragment);
            a.a(context, fragment.getChildFragmentManager(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftSetBannerView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveGiftSetBannerView this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.n = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveGiftSetBannerView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveGiftSetBannerView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.b(LiveProtos.Event.LIVE_SET_GIFT_EXPLAIN_PAGE_SEND_ALL_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this$0.f);
        this$0.a(this$0.f, "");
    }

    public final void a() {
        getVb().b.setVisibility(8);
        getVb().c.setVisibility(8);
        getVb().b.clearAnimation();
        getVb().c.clearAnimation();
        this.l = false;
        this.k = false;
    }

    public final void a(LiveGiftSetInfoModel liveGiftSetInfoModel, IRequestHost iRequestHost, Fragment fragment) {
        if (liveGiftSetInfoModel == null || fragment == null) {
            return;
        }
        this.h = liveGiftSetInfoModel;
        this.c = iRequestHost;
        this.d = fragment;
        this.f = String.valueOf(liveGiftSetInfoModel.getId());
        EventTrackLive.b(LiveProtos.Event.LIVE_SET_GIFT_EXPLAIN_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this.f);
        getVb().f.setText(liveGiftSetInfoModel.getName());
        getVb().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftSetBannerView$m0rqq1ru1ZBw1hOzvFeRLmV3Srk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftSetBannerView.a(LiveGiftSetBannerView.this, view);
            }
        });
        boolean z = false;
        if (this.b == null) {
            this.b = new MyAdapter(this);
            getVb().d.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            getVb().d.setAdapter(this.b);
        }
        MyAdapter myAdapter = this.b;
        if (myAdapter != null) {
            myAdapter.setDataAndNotify(liveGiftSetInfoModel.getProgress());
        }
        if (this.j) {
            getVb().e.setVisibility(8);
        } else {
            getVb().e.setVisibility(0);
            getVb().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftSetBannerView$g9e_4TxJI4yxMWXNBarJCsKlMwE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGiftSetBannerView.b(LiveGiftSetBannerView.this, view);
                }
            });
        }
        getVb().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftSetBannerView$xUai6HI9I8SP_lO4nkVGQgRB5tM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftSetBannerView.c(LiveGiftSetBannerView.this, view);
            }
        });
        LiveGiftSetInfoModel liveGiftSetInfoModel2 = this.h;
        if (liveGiftSetInfoModel2 != null) {
            Intrinsics.a(liveGiftSetInfoModel2);
            if (liveGiftSetInfoModel2.getExpire_time() > 0) {
                z = true;
            }
            this.l = z;
            if (z) {
                e();
                return;
            }
            b();
            getVb().b.setVisibility(8);
            getVb().c.setVisibility(8);
        }
    }

    public final void a(final String id, String goodsId) {
        Intrinsics.e(id, "id");
        Intrinsics.e(goodsId, "goodsId");
        final IRequestHost iRequestHost = this.c;
        LiveRoomHttpUtils.a(id, goodsId, 1, new BluedUIHttpResponse<BluedEntityA<LiveGiftSetBuyModel>>(iRequestHost) { // from class: com.blued.android.module.live_china.view.LiveGiftSetBannerView$buyGiftSet$1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Removed duplicated region for block: B:56:0x0236  */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA<com.blued.android.module.live_china.model.LiveGiftSetBuyModel> r5) {
                /*
                    Method dump skipped, instructions count: 598
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view.LiveGiftSetBannerView$buyGiftSet$1.onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA):void");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                LiveGiftSetBannerView.this.a(i, errorMessage);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }
        }, this.c);
    }

    public final void b() {
        LiveGiftSetInfoModel liveGiftSetInfoModel = this.h;
        if (liveGiftSetInfoModel != null) {
            Intrinsics.a(liveGiftSetInfoModel);
            if (liveGiftSetInfoModel.getProgress() != null) {
                LiveGiftSetInfoModel liveGiftSetInfoModel2 = this.h;
                Intrinsics.a(liveGiftSetInfoModel2);
                liveGiftSetInfoModel2.setExpire_time(0);
                LiveGiftSetInfoModel liveGiftSetInfoModel3 = this.h;
                Intrinsics.a(liveGiftSetInfoModel3);
                ArrayList<LiveGiftSetItemModel> progress = liveGiftSetInfoModel3.getProgress();
                if (progress != null) {
                    for (LiveGiftSetItemModel liveGiftSetItemModel : progress) {
                        liveGiftSetItemModel.setCount(0);
                    }
                }
                a();
                MyAdapter myAdapter = this.b;
                if (myAdapter == null) {
                    return;
                }
                LiveGiftSetInfoModel liveGiftSetInfoModel4 = this.h;
                Intrinsics.a(liveGiftSetInfoModel4);
                myAdapter.setDataAndNotify(liveGiftSetInfoModel4.getProgress());
            }
        }
    }

    public final void c() {
        this.j = true;
    }

    public final void d() {
        if (this.j) {
            return;
        }
        EventTrackLive.b(LiveProtos.Event.LIVE_SET_GIFT_EXPLAIN_PAGE_DETAIL_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this.f);
        if (this.d != null) {
            LiveGiftSetDialogFragment.Companion companion = LiveGiftSetDialogFragment.a;
            Fragment fragment = this.d;
            Intrinsics.a(fragment);
            companion.a(fragment, this.f, this.g);
        }
    }

    public final void e() {
        if (!this.l) {
            a();
        } else if (this.k) {
        } else {
            this.k = true;
            getVb().b.clearAnimation();
            getVb().b.setTranslationX(-DensityUtils.a(getContext(), 44.0f));
            getVb().b.animate().translationX(DensityUtils.a(getContext(), 307.0f)).setDuration(920L).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.LiveGiftSetBannerView$anim$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.e(animation, "animation");
                    super.onAnimationEnd(animation);
                    LiveGiftSetBannerView.this.getVb().b.setVisibility(8);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    LiveGiftSetBannerView.this.getVb().b.setVisibility(0);
                }
            }).start();
            getVb().c.clearAnimation();
            getVb().c.setAlpha(0.3f);
            getVb().c.setTranslationX(-DensityUtils.a(getContext(), 44.0f));
            getVb().c.animate().translationX(DensityUtils.a(getContext(), 307.0f)).setDuration(1000L).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.LiveGiftSetBannerView$anim$2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.e(animation, "animation");
                    super.onAnimationEnd(animation);
                    LiveGiftSetBannerView.this.getVb().c.setVisibility(8);
                    AppInfo.n().postDelayed(LiveGiftSetBannerView.this.getTransRunable(), 400L);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    LiveGiftSetBannerView.this.getVb().c.setVisibility(0);
                }
            }).setStartDelay(320L);
        }
    }

    public final void f() {
        LiveGiftPayTools.b();
        if (this.n || this.d == null) {
            return;
        }
        String string = AppInfo.d().getString(R.string.live_id_charge_tip);
        Intrinsics.c(string, "getAppContext().getStrin…tring.live_id_charge_tip)");
        this.n = true;
        CommonAlertDialog.a(getContext(), (View) null, "", string, getContext().getString(R.string.cancel), getContext().getString(R.string.Live_SendPresent_recharge), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftSetBannerView$RicvdLOyyQbuvklZxotpKGmPB78
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveGiftSetBannerView.a(LiveGiftSetBannerView.this, dialogInterface, i);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftSetBannerView$QcanRqVBBB02gizS7ko8-_TwacA
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveGiftSetBannerView.b(LiveGiftSetBannerView.this, dialogInterface, i);
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftSetBannerView$evvuLNh_7_nzJm81J7UA52PSERQ
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                LiveGiftSetBannerView.a(LiveGiftSetBannerView.this, dialogInterface);
            }
        }, true);
    }

    public final IRequestHost getActive() {
        return this.c;
    }

    public final boolean getAniming() {
        return this.k;
    }

    public final boolean getAttatch() {
        return this.e;
    }

    public final boolean getDisableDes() {
        return this.j;
    }

    public final Fragment getFragment() {
        return this.d;
    }

    public final LiveGiftSetBuyModel getGiftBuyModel() {
        return this.i;
    }

    public final LiveGiftSetInfoModel getInfoModel() {
        return this.h;
    }

    public final MyAdapter getMyAdapter() {
        return this.b;
    }

    public final boolean getNeedAnim() {
        return this.l;
    }

    public final String getSetId() {
        return this.f;
    }

    public final Runnable getTransRunable() {
        return this.m;
    }

    public final LiveGiftSetBannerViewBinding getVb() {
        return (LiveGiftSetBannerViewBinding) this.a.getValue();
    }

    public final int getWindowHeight() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.e = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
        this.c = null;
        this.d = null;
        this.e = false;
    }

    public final void setActive(IRequestHost iRequestHost) {
        this.c = iRequestHost;
    }

    public final void setAniming(boolean z) {
        this.k = z;
    }

    public final void setAttatch(boolean z) {
        this.e = z;
    }

    public final void setBannerData(LiveGiftSetInfoModel liveGiftSetInfoModel) {
        MyAdapter myAdapter = this.b;
        if (myAdapter == null) {
            return;
        }
        myAdapter.setDataAndNotify(liveGiftSetInfoModel == null ? null : liveGiftSetInfoModel.getProgress());
    }

    public final void setDisableDes(boolean z) {
        this.j = z;
    }

    public final void setFragment(Fragment fragment) {
        this.d = fragment;
    }

    public final void setGiftBuyModel(LiveGiftSetBuyModel liveGiftSetBuyModel) {
        this.i = liveGiftSetBuyModel;
    }

    public final void setGiftWindowHeight(int i) {
        if (i != 0) {
            this.g = i + DensityUtils.a(getContext(), 37.0f);
        }
    }

    public final void setInfoModel(LiveGiftSetInfoModel liveGiftSetInfoModel) {
        this.h = liveGiftSetInfoModel;
    }

    public final void setMyAdapter(MyAdapter myAdapter) {
        this.b = myAdapter;
    }

    public final void setNeedAnim(boolean z) {
        this.l = z;
    }

    public final void setSetId(String str) {
        Intrinsics.e(str, "<set-?>");
        this.f = str;
    }

    public final void setTransRunable(Runnable runnable) {
        Intrinsics.e(runnable, "<set-?>");
        this.m = runnable;
    }

    public final void setWindowHeight(int i) {
        this.g = i;
    }
}
