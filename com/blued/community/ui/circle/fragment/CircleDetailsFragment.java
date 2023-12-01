package com.blued.community.ui.circle.fragment;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.Observer;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.view.GroupJoinView;
import com.blued.android.module.common.utils.AnimationUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.PageTabLayout;
import com.blued.android.module.common.view.RotateLayout;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.menu.BottomMenuPop;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.manager.CommunityConstants;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.adapter.CircleDetailsTalkAdapter;
import com.blued.community.ui.circle.fragment.CircleDetailsFragment;
import com.blued.community.ui.circle.manager.CircleConstants;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.circle.model.CircleAdModel;
import com.blued.community.ui.circle.model.CircleBubble;
import com.blued.community.ui.circle.model.CircleJoinState;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.circle.presenter.CircleDetailsPresenter;
import com.blued.community.ui.circle.view.CircleJoinView;
import com.blued.community.ui.send.fragment.CircleAddPostFragment;
import com.blued.community.utils.CommunityPreferences;
import com.blued.community.utils.CommunityShareUtils;
import com.blued.community.utils.UserInfoUtils;
import com.blued.community.utils.ViewUtils;
import com.blued.community.view.FloatFooterView;
import com.blued.community.view.TextViewFixTouchForDynamic;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleDetailsFragment.class */
public class CircleDetailsFragment extends MvpFragment<CircleDetailsPresenter> {
    private LinearLayout A;
    private CircleJoinView B;
    private TextViewFixTouchForDynamic C;
    private FrameLayout D;
    private TextView E;
    private LinearLayout F;
    private TextView G;
    private LinearLayout H;
    private TextView I;
    private LinearLayout J;
    private View K;
    private ShapeLinearLayout L;
    private PageTabLayout M;
    private ShapeLinearLayout N;
    private AppBarLayout O;
    private RecyclerView P;
    private SmartRefreshLayout Q;
    private CommonTopTitleNoTrans R;
    private FloatFooterView S;
    private ImageView T;
    private CircleJoinView U;
    private ImageView V;
    private ImageView W;
    private ImageView X;
    private ShapeConstraintLayout Y;
    private NoDataAndLoadFailView Z;

    /* renamed from: a  reason: collision with root package name */
    public AnimationSet f19148a;
    private ImageView aa;
    private CircleJoinView ab;
    private ShapeLinearLayout ac;
    private GroupJoinView ad;
    private CircleDetailsTalkAdapter ae;
    private NoDataAndLoadFailView af;
    private View ag;
    private Context ah;
    private int ai;
    private int aj;
    private float ak;
    private Timer am;

    /* renamed from: c  reason: collision with root package name */
    private View f19149c;
    private ImageView d;
    private ImageView e;
    private RotateLayout f;
    private FrameLayout g;
    private TextView k;
    private ImageView l;
    private TextView m;
    private TextView n;
    private LinearLayout o;
    private FrameLayout p;
    private ImageView q;
    private FrameLayout r;
    private TextView s;
    private TextView t;
    private LinearLayout u;
    private ImageView v;
    private TextView w;
    private ImageView x;
    private LinearLayout y;
    private LinearLayout z;
    private boolean al = false;
    private NestedScrollView.OnScrollChangeListener an = new NestedScrollView.OnScrollChangeListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.17
        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        }
    };
    private AppBarLayout.OnOffsetChangedListener ao = new AppBarLayout.OnOffsetChangedListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.18
        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            int height = CircleDetailsFragment.this.O.getHeight() - DensityUtils.a(CircleDetailsFragment.this.ah, 60.0f);
            int abs = Math.abs(i);
            if (abs > 0) {
                CircleDetailsFragment.this.f.setVisibility(8);
                CircleDetailsFragment.this.R.c();
            }
            float min = (Math.min(abs, height) * 1.0f) / height;
            CircleDetailsFragment.this.g.setAlpha(min);
            CircleDetailsFragment.this.p.setAlpha(min);
            if (min < 0.2f) {
                CircleDetailsFragment.this.U.setClickable(false);
            } else {
                CircleDetailsFragment.this.U.setClickable(true);
            }
            int abs2 = Math.abs(CircleDetailsFragment.this.aj - i);
            if (CircleDetailsFragment.this.aj < i && abs2 > 10) {
                CircleDetailsFragment.this.S.startBtmBtnShow();
            } else if (CircleDetailsFragment.this.aj > i && abs2 > 10) {
                CircleDetailsFragment.this.S.startBtmBtnHide();
            }
            CircleDetailsFragment.this.aj = i;
            if (CircleDetailsFragment.this.Y == null || CircleDetailsFragment.this.Y.getVisibility() != 0) {
                return;
            }
            int height2 = CircleDetailsFragment.this.O.getHeight();
            int height3 = CircleDetailsFragment.this.L.getHeight();
            int height4 = CircleDetailsFragment.this.N.getHeight();
            int height5 = CircleDetailsFragment.this.g.getHeight();
            int height6 = CircleDetailsFragment.this.p.getHeight();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) CircleDetailsFragment.this.Y.getLayoutParams();
            marginLayoutParams.width = -1;
            marginLayoutParams.height = AppInfo.m;
            marginLayoutParams.topMargin = ((height2 - height3) - height4) + height5 + height6;
            CircleDetailsFragment.this.Y.setLayoutParams(marginLayoutParams);
        }
    };
    private RecyclerView.OnScrollListener ap = new RecyclerView.OnScrollListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.19
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (CircleDetailsFragment.this.S == null || i != 0 || !recyclerView.canScrollVertically(-1) || recyclerView.canScrollVertically(1)) {
                return;
            }
            CircleDetailsFragment.this.S.startBtmBtnHide();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (CircleDetailsFragment.this.S != null) {
                if (i2 < 0) {
                    CircleDetailsFragment.this.S.startBtmBtnShow();
                } else if (i2 > 0) {
                    CircleDetailsFragment.this.S.startBtmBtnHide();
                }
            }
        }
    };
    public boolean b = false;
    private boolean aq = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.community.ui.circle.fragment.CircleDetailsFragment$26  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleDetailsFragment$26.class */
    public class AnonymousClass26 extends ImageLoadResult {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MyCircleModel f19169a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass26(IRequestHost iRequestHost, MyCircleModel myCircleModel) {
            super(iRequestHost);
            this.f19169a = myCircleModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            if (CircleDetailsFragment.this.p == null || CircleDetailsFragment.this.k == null || CircleDetailsFragment.this.d == null) {
                return;
            }
            int color = CircleDetailsFragment.this.ah.getResources().getColor(R.color.syc_dark_circle_top_bg);
            CircleDetailsFragment.this.p.setBackgroundColor(color);
            CircleDetailsFragment.this.k.setBackgroundColor(color);
        }

        @Override // com.blued.android.core.image.ImageLoadResult
        public void a() {
            ImageFileLoader.a(CircleDetailsFragment.this.getFragmentActive()).b(AvatarUtils.a(this.f19169a.cover)).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.26.1
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                public void onUIFinish(File file, Exception exc) {
                    Bitmap decodeFile = (file == null || !file.exists()) ? null : BitmapFactory.decodeFile(file.getPath());
                    if (decodeFile != null) {
                        Palette.from(decodeFile).generate(new Palette.PaletteAsyncListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.26.1.1
                            @Override // androidx.palette.graphics.Palette.PaletteAsyncListener
                            public void onGenerated(Palette palette) {
                                if (palette == null) {
                                    AnonymousClass26.this.d();
                                    return;
                                }
                                Palette.Swatch lightVibrantSwatch = palette.getLightVibrantSwatch();
                                if (lightVibrantSwatch == null) {
                                    AnonymousClass26.this.d();
                                    return;
                                }
                                int rgb = lightVibrantSwatch.getRgb();
                                if (CircleDetailsFragment.this.p == null || CircleDetailsFragment.this.k == null || CircleDetailsFragment.this.d == null) {
                                    return;
                                }
                                CircleDetailsFragment.this.p.setBackgroundColor(rgb);
                                CircleDetailsFragment.this.k.setBackgroundColor(rgb);
                                CircleDetailsFragment.this.d.setBackgroundColor(rgb);
                            }
                        });
                    } else {
                        AnonymousClass26.this.d();
                    }
                }
            }).a();
        }

        @Override // com.blued.android.core.image.ImageLoadResult
        public void a(int i, Exception exc) {
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.community.ui.circle.fragment.CircleDetailsFragment$32  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleDetailsFragment$32.class */
    public class AnonymousClass32 extends TimerTask {
        AnonymousClass32() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            CircleDetailsFragment.this.ac.startAnimation(CircleDetailsFragment.this.f19148a);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            CircleDetailsFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleDetailsFragment$32$9yzR8B9QVLIvqrW5gmlRAE2jqo8
                @Override // java.lang.Runnable
                public final void run() {
                    CircleDetailsFragment.AnonymousClass32.this.a();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        ArrayList arrayList = new ArrayList();
        final BasePopupView a2 = CommonShowBottomWindow.a(getContext(), arrayList);
        BottomMenuPop.MenuItemInfo menuItemInfo = new BottomMenuPop.MenuItemInfo();
        menuItemInfo.f11214a = this.ah.getResources().getString(R.string.circle_member_invitation);
        menuItemInfo.d = new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CircleDetailsFragment.this.C();
                BasePopupView basePopupView = a2;
                if (basePopupView != null) {
                    basePopupView.p();
                }
            }
        };
        BottomMenuPop.MenuItemInfo menuItemInfo2 = new BottomMenuPop.MenuItemInfo();
        menuItemInfo2.f11214a = this.ah.getResources().getString(R.string.btn_share);
        menuItemInfo2.d = new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CircleDetailsFragment.this.B();
                BasePopupView basePopupView = a2;
                if (basePopupView != null) {
                    basePopupView.p();
                }
            }
        };
        arrayList.add(menuItemInfo2);
        if (j().n()) {
            EventTrackFeed.h(FeedProtos.Event.CIRCLE_USER_MANAGE_SHOW, j().r());
            arrayList.add(menuItemInfo);
        }
        a2.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        CommunityShareUtils.b().a(this.ah, j().t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        EventTrackFeed.h(FeedProtos.Event.CIRCLE_USER_MANAGE_INVITE_CLICK, j().r());
        CommunityServiceManager.b().b(this.ah, j().r());
    }

    private void D() {
        this.ai = StatusBarHelper.a(this.ah);
        ShapeHelper.b(this.L, R.color.syc_b);
        this.R.setAlpha(1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.R.getLayoutParams();
        layoutParams.topMargin = this.ai;
        this.R.setLayoutParams(layoutParams);
        F();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams2.topMargin += this.ai;
        this.f.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams3.height = this.ai;
        this.g.setLayoutParams(layoutParams3);
        this.g.setAlpha(0.0f);
        this.p.setAlpha(0.0f);
        this.U.setClickable(false);
        this.B.setStyle(1);
        this.U.setStyle(1);
        this.O.addOnOffsetChangedListener(this.ao);
        this.P.addOnScrollListener(this.ap);
        this.Q.b((OnMultiPurposeListener) new SimpleMultiPurposeListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.16
            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void a(RefreshHeader refreshHeader, boolean z, float f, int i, int i2, int i3) {
                if (CircleDetailsFragment.this.e != null) {
                    CircleDetailsFragment.this.f.d();
                    CircleDetailsFragment.this.f.a(-6.0f);
                    FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) CircleDetailsFragment.this.e.getLayoutParams();
                    int i4 = (int) (i * 1.3f);
                    layoutParams4.width = AppInfo.l + i4;
                    layoutParams4.height = (int) (layoutParams4.width * (CircleDetailsFragment.this.ak > 0.0f ? CircleDetailsFragment.this.ak : 0.72f));
                    layoutParams4.leftMargin = (-i4) / 2;
                    CircleDetailsFragment.this.e.setLayoutParams(layoutParams4);
                }
            }

            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
            public void a(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
                if (refreshState2 == RefreshState.PullDownToRefresh) {
                    if (CircleDetailsFragment.this.f != null) {
                        CircleDetailsFragment.this.f.setVisibility(0);
                        CircleDetailsFragment.this.R.a();
                    }
                } else if ((refreshState2 == RefreshState.PullDownCanceled || refreshState2 == RefreshState.None) && CircleDetailsFragment.this.f != null) {
                    CircleDetailsFragment.this.f.setVisibility(8);
                    CircleDetailsFragment.this.R.c();
                }
            }

            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                CircleDetailsFragment.this.j().e();
                CircleDetailsFragment.this.ag.setVisibility(8);
                CircleDetailsFragment.this.e();
            }
        });
        this.ad.setText(getString(R.string.group_chat));
        this.ad.setStrokeColor(R.color.transparent);
    }

    private void E() {
        FeedProtos.TabType tabType = FeedProtos.TabType.UNKNOWN_TAB_TYPE;
        int p = j().p();
        if (p == 0) {
            tabType = FeedProtos.TabType.NEW_CIRCLE;
        } else if (p == 1) {
            tabType = FeedProtos.TabType.HOT_CIRCLE;
        } else if (p == 2) {
            tabType = FeedProtos.TabType.ESSENCE_CICLE;
        }
        EventTrackFeed.a(FeedProtos.Event.CIRCLE_TAB_BTN_SHOW, tabType);
    }

    private void F() {
        int i = AppInfo.l;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.e.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i + DensityUtils.a(this.ah, 50.0f);
        this.e.setLayoutParams(layoutParams);
        this.ak = (layoutParams.height * 1.0f) / layoutParams.width;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        getActivity().finish();
    }

    public static void a(Context context, MyCircleModel myCircleModel, CircleConstants.CIRCLE_FROM_PAGE circle_from_page) {
        if (!CommunityServiceManager.a().z()) {
            AppMethods.d(R.string.common_circle_service_upgraded);
        } else if (myCircleModel == null) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putSerializable("circle_data", myCircleModel);
            bundle.putSerializable("circle_from_page", circle_from_page);
            bundle.putSerializable("circle_classify_id", Integer.valueOf(myCircleModel.classify_id));
            TerminalActivity.a(bundle);
            TerminalActivity.d(context, CircleDetailsFragment.class, bundle);
        }
    }

    public static void a(Context context, String str, int i) {
        a(context, str, null, 0, CircleConstants.CIRCLE_FROM_PAGE.FEED_LIST_ADAPTER, 0, i);
    }

    public static void a(Context context, String str, int i, CircleConstants.CIRCLE_FROM_PAGE circle_from_page, int i2, boolean z) {
        if (!CommunityServiceManager.a().z()) {
            AppMethods.d(R.string.common_circle_service_upgraded);
        } else if (TextUtils.isEmpty(str)) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("circle_id", str);
            bundle.putInt("circle_details_tab", i);
            bundle.putSerializable("circle_from_page", circle_from_page);
            bundle.putInt("h5_from", i2);
            bundle.putBoolean("show_apply_join", z);
            TerminalActivity.a(bundle);
            TerminalActivity.d(context, CircleDetailsFragment.class, bundle);
        }
    }

    public static void a(Context context, String str, CircleConstants.CIRCLE_FROM_PAGE circle_from_page) {
        a(context, str, null, 0, circle_from_page, 0, 0);
    }

    public static void a(Context context, String str, String str2, int i, CircleConstants.CIRCLE_FROM_PAGE circle_from_page, int i2, int i3) {
        if (!CommunityServiceManager.a().z()) {
            AppMethods.d(R.string.common_circle_service_upgraded);
        } else if (TextUtils.isEmpty(str)) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("circle_id", str);
            bundle.putString("feed_id", str2);
            bundle.putInt("circle_details_tab", i);
            bundle.putSerializable("circle_from_page", circle_from_page);
            bundle.putInt("notify_from", i2);
            bundle.putInt("feed_from", i3);
            TerminalActivity.a(bundle);
            TerminalActivity.d(context, CircleDetailsFragment.class, bundle);
        }
    }

    public static void a(Context context, String str, String str2, CircleConstants.CIRCLE_FROM_PAGE circle_from_page) {
        a(context, str, str2, 0, circle_from_page, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        CommunityPreferences.b(j().r(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        CircleMethods.a(j().t().title, "", j().r());
        EventTrackFeed.a(FeedProtos.Event.CIRCLE_JOIN_FEED_POP_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a(2);
    }

    private void a(BluedIngSelfFeed bluedIngSelfFeed) {
        if (TextUtils.isEmpty(bluedIngSelfFeed.circle_id)) {
            bluedIngSelfFeed.circle_id = j().r();
        }
        EventTrackFeed.b(FeedProtos.Event.CIRCLE_NOTE_DRAW, bluedIngSelfFeed, FeedProtos.NoteSource.CIRCLE_TOP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final MyCircleModel myCircleModel) {
        this.f19149c.setVisibility(8);
        if (myCircleModel == null) {
            return;
        }
        ImageLoader.a(getFragmentActive(), AvatarUtils.a(myCircleModel.cover)).b(R.drawable.circle_header_default).a(new AnonymousClass26(getFragmentActive(), myCircleModel)).a(this.e);
        ImageLoader.a(getFragmentActive(), AvatarUtils.a(0, myCircleModel.cover)).b(R.drawable.circle_header_default).a(6.0f).a(this.q);
        if (myCircleModel.cover_is_auditing == 1) {
            this.r.setVisibility(0);
        } else {
            this.r.setVisibility(8);
        }
        this.s.setText(myCircleModel.title);
        this.m.setText(myCircleModel.title);
        String str = myCircleModel.members_num + this.ah.getString(R.string.members_count);
        this.t.setText(str);
        this.n.setText(str);
        this.W.setVisibility(0);
        this.V.setVisibility(0);
        if (myCircleModel.active_list_is_show == 1) {
            this.u.setVisibility(0);
            if (myCircleModel.active_list_open == 1) {
                this.v.setImageResource(R.drawable.circle_active_list_open);
                this.w.setTextColor(getResources().getColor(R.color.syc_b));
                this.x.setVisibility(8);
                this.y.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                if (myCircleModel.active_list_top != null && myCircleModel.active_list_top.length > 0) {
                    arrayList.addAll(Arrays.asList(myCircleModel.active_list_top));
                }
                while (arrayList.size() < 3) {
                    arrayList.add("");
                }
                this.z.removeAllViews();
                Iterator<E> it = arrayList.iterator();
                boolean z = true;
                while (true) {
                    boolean z2 = z;
                    if (!it.hasNext()) {
                        break;
                    }
                    String str2 = (String) it.next();
                    ImageView imageView = new ImageView(this.ah);
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(DensityUtils.a(this.ah, 19.0f), DensityUtils.a(this.ah, 19.0f));
                    if (!z2) {
                        marginLayoutParams.leftMargin = -DensityUtils.a(this.ah, 7.0f);
                    }
                    imageView.setLayoutParams(marginLayoutParams);
                    this.z.addView(imageView);
                    ImageLoader.a(getFragmentActive(), str2).b(R.drawable.user_bg_round_border_white).d(R.drawable.user_bg_round_border_white).c().a(1.0f, this.ah.getResources().getColor(R.color.syc_b)).a(imageView);
                    z = false;
                }
                this.u.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.27
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        EventTrackFeed.h(FeedProtos.Event.CIRCLE_ACTIVE_MEMBER_CLICK, myCircleModel.circle_id);
                        CommunityServiceManager.b().a(CircleDetailsFragment.this.ah, H5Url.a(57, EncryptTool.b(myCircleModel.circle_id)), CommunityConstants.WebShowType.DEFAULT);
                    }
                });
            } else {
                this.v.setImageResource(R.drawable.circle_active_list_close);
                this.w.setTextColor(getResources().getColor(R.color.syc_i));
                this.x.setVisibility(0);
                this.y.setVisibility(8);
                this.u.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.28
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        AppMethods.d(R.string.circle_active_list_toast);
                    }
                });
            }
        } else {
            this.u.setVisibility(8);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (myCircleModel.is_disclosure == 1 || !myCircleModel.isNotMember()) {
                    CircleMemberFragment.a(CircleDetailsFragment.this.ah, myCircleModel);
                } else {
                    AppMethods.d(R.string.circle_apply_join_first);
                }
            }
        };
        this.A.setOnClickListener(onClickListener);
        this.o.setOnClickListener(onClickListener);
        StringBuilder sb = new StringBuilder();
        sb.append(this.ah.getString(R.string.circle_introduction));
        sb.append(!TextUtils.isEmpty(myCircleModel.description) ? myCircleModel.description : getString(R.string.circle_description_default));
        final String sb2 = sb.toString();
        int a2 = AppInfo.l - DensityUtils.a(this.ah, 20.0f);
        ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
        layoutParams.width = a2;
        this.C.setLayoutParams(layoutParams);
        this.C.setMaxWidth(a2);
        this.C.setMoeTextColor(this.ah.getResources().getColor(R.color.syc_b));
        this.C.setMaxLines(3);
        this.C.setExpandText(sb2);
        this.C.setMovementMethod(LinkMovementClickMethod.a());
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (CircleDetailsFragment.this.C.getMaxLines() == 3) {
                    CircleDetailsFragment.this.C.setMaxLines(100);
                    CircleDetailsFragment.this.C.setExpandText(sb2);
                    return;
                }
                CircleDetailsFragment.this.C.setMaxLines(3);
                CircleDetailsFragment.this.C.setExpandText(sb2);
            }
        });
        if (myCircleModel.groups != null) {
            Iterator<GroupInfoModel> it2 = myCircleModel.groups.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (CommunityServiceManager.e().b(it2.next().group_role)) {
                    j().i = true;
                    break;
                }
            }
        }
        if ((myCircleModel.admin_level == 3 || myCircleModel.is_backflow_user == 1) && j().z().dataList.size() > 5 && !this.al) {
            j().a(1);
            b(1);
            PageTabLayout pageTabLayout = this.M;
            pageTabLayout.a(pageTabLayout.a(j().p()));
            this.al = true;
        }
        CommunityServiceManager.e().a(this.ad, myCircleModel.show_groups, myCircleModel.groups, getFragmentActive());
        b(myCircleModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, CircleBubble circleBubble) {
        if (CommunityServiceManager.a().C()) {
            ToastUtils.b(R.string.account_invalid_to_send_feed_in_circle);
        } else {
            CircleAddPostFragment.a(this.ah, str, str2, str3, circleBubble);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final List<BluedIngSelfFeed> list) {
        int size = list.size();
        if (size > 0) {
            BluedIngSelfFeed bluedIngSelfFeed = list.get(0);
            this.K.setVisibility(0);
            this.F.setVisibility(0);
            if (TextUtils.isEmpty(bluedIngSelfFeed.feed_content)) {
                this.E.setText(R.string.circle_picture_talk);
            } else {
                this.E.setText(bluedIngSelfFeed.feed_content);
            }
            this.F.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.33
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    CirclePostDetailsFragment.a(CircleDetailsFragment.this.ah, ((BluedIngSelfFeed) list.get(0)).feed_id, FeedProtos.NoteSource.CIRCLE_TOP);
                }
            });
            a(bluedIngSelfFeed);
        } else {
            this.K.setVisibility(8);
            this.F.setVisibility(8);
        }
        if (size > 1) {
            BluedIngSelfFeed bluedIngSelfFeed2 = list.get(1);
            this.H.setVisibility(0);
            if (TextUtils.isEmpty(bluedIngSelfFeed2.feed_content)) {
                this.G.setText(R.string.circle_picture_talk);
            } else {
                this.G.setText(bluedIngSelfFeed2.feed_content);
            }
            this.H.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.34
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    CirclePostDetailsFragment.a(CircleDetailsFragment.this.ah, ((BluedIngSelfFeed) list.get(1)).feed_id, FeedProtos.NoteSource.CIRCLE_TOP);
                }
            });
            a(bluedIngSelfFeed2);
        } else {
            this.H.setVisibility(8);
        }
        if (size <= 2) {
            this.J.setVisibility(8);
            return;
        }
        BluedIngSelfFeed bluedIngSelfFeed3 = list.get(2);
        this.J.setVisibility(0);
        if (TextUtils.isEmpty(bluedIngSelfFeed3.feed_content)) {
            this.I.setText(R.string.circle_picture_talk);
        } else {
            this.I.setText(bluedIngSelfFeed3.feed_content);
        }
        this.J.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CirclePostDetailsFragment.a(CircleDetailsFragment.this.ah, ((BluedIngSelfFeed) list.get(2)).feed_id, FeedProtos.NoteSource.CIRCLE_TOP);
            }
        });
        a(bluedIngSelfFeed3);
    }

    public static void b(Context context, String str, int i) {
        a(context, str, null, 0, CircleConstants.CIRCLE_FROM_PAGE.CIRCLE_NOTIFY, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        a(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final CircleBubble circleBubble) {
        if (!j().t().isJoin()) {
            Context context = this.ah;
            CommonAlertDialog.a(context, (String) null, context.getString(R.string.circle_not_member_tip), this.ah.getString(R.string.circle_not_member_ok), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    CircleDetailsFragment.this.j().a(false, new CircleMethods.JoinViewChangeListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.8.1
                        @Override // com.blued.community.ui.circle.manager.CircleMethods.JoinViewChangeListener
                        public void joinViewChange(CircleJoinState circleJoinState) {
                            if (circleJoinState.isJoin()) {
                                CircleDetailsFragment.this.a(CircleDetailsFragment.this.j().r(), CircleDetailsFragment.this.j().q(), CircleDetailsFragment.this.j().t().cover, circleBubble);
                            }
                        }
                    }, CircleDetailsFragment.this.getFragmentManager());
                    CircleDetailsFragment.this.w();
                }
            }, this.ah.getString(R.string.circle_not_member_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        } else if (j().t().has_mute != 1) {
            a(j().r(), j().q(), j().t().cover, circleBubble);
        } else if (j().t().user_mute_type != 1 && j().t().user_mute_type != 2) {
            if (j().t().user_mute_type == 1009) {
                AppMethods.a((CharSequence) getResources().getString(R.string.toast_current_circle_mute));
            } else {
                AppMethods.a((CharSequence) getResources().getString(R.string.toast_all_circle_mute));
            }
        } else {
            String c2 = TimeAndDateUtils.c(TimeAndDateUtils.c(j().t().user_mute_time + ""));
            AppMethods.a((CharSequence) ("你已经被禁言， " + c2 + "自动解禁"));
        }
    }

    private void b(final MyCircleModel myCircleModel) {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (myCircleModel.isOwner()) {
                    EventTrackFeed.h(FeedProtos.Event.CIRCLE_SETTINGS_PAGE_SHOW, myCircleModel.circle_id);
                    CircleSettingFragment.a(CircleDetailsFragment.this.getContext(), myCircleModel);
                } else if (!myCircleModel.isJoin()) {
                    EventTrackFeed.b(FeedProtos.Event.CIRCLE_JOIN_BTN_CLICK, FeedProtos.CircleSource.CIRCLE_DETAIL, CircleDetailsFragment.this.j().t());
                    CircleDetailsFragment.this.j().a(true, (CircleMethods.JoinViewChangeListener) null, CircleDetailsFragment.this.getFragmentManager());
                    CircleDetailsFragment.this.w();
                } else {
                    EventTrackFeed.h(FeedProtos.Event.CIRCLE_EXIT_BOX_SHOW, myCircleModel.circle_id);
                    if (CircleDetailsFragment.this.j().i) {
                        CommonAlertDialog.a(CircleDetailsFragment.this.ah, CircleDetailsFragment.this.getString(R.string.community_notice), CircleDetailsFragment.this.getString(R.string.group_quit_circle_notice), CircleDetailsFragment.this.getString(R.string.community_exit), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.31.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Tracker.onClick(dialogInterface, i);
                                EventTrackFeed.h(FeedProtos.Event.CIRCLE_EXIT_BTN_CLICK, myCircleModel.circle_id);
                                CommunityPreferences.a(myCircleModel.circle_id, false);
                                CircleDetailsFragment.this.j().m();
                            }
                        }, CircleDetailsFragment.this.getString(R.string.cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                    } else {
                        CommonAlertDialog.a(CircleDetailsFragment.this.ah, (String) null, CircleDetailsFragment.this.ah.getString(R.string.circle_back), CircleDetailsFragment.this.ah.getString(R.string.circle_back_ok), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.31.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Tracker.onClick(dialogInterface, i);
                                EventTrackFeed.h(FeedProtos.Event.CIRCLE_EXIT_BTN_CLICK, myCircleModel.circle_id);
                                CommunityPreferences.a(myCircleModel.circle_id, false);
                                CircleDetailsFragment.this.j().m();
                            }
                        }, CircleDetailsFragment.this.ah.getString(R.string.circle_back_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                    }
                }
            }
        };
        this.B.setOnClickListener(onClickListener);
        this.U.setOnClickListener(onClickListener);
        if (myCircleModel.isOwner()) {
            this.B.a();
            this.U.a();
            this.ac.setVisibility(8);
        } else {
            this.B.setJoinStatus(myCircleModel.getJoinState());
            this.U.setJoinStatus(myCircleModel.getJoinState());
            this.ab.setJoinStatus(myCircleModel.getJoinState());
        }
        if (myCircleModel.isJoin() || j().t().is_applied != 0) {
            this.ac.setVisibility(8);
            w();
        } else {
            this.ac.setVisibility(0);
            if (this.ac.getVisibility() == 0 && !this.b) {
                this.f19148a = AnimationUtils.a((View) this.ac, 1.3f, 1.45f, 1, 1500);
                Timer timer = new Timer();
                this.am = timer;
                timer.schedule(new AnonymousClass32(), 300L, 15000L);
                this.b = true;
            }
        }
        if (myCircleModel.is_disclosure == 1 || !myCircleModel.isNotMember()) {
            this.Q.c(true);
            View childAt = this.O.getChildAt(0);
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.setScrollFlags(1);
            childAt.setLayoutParams(layoutParams);
            this.Y.setVisibility(8);
        } else {
            this.Q.c(false);
            ((AppBarLayout.LayoutParams) this.O.getChildAt(0).getLayoutParams()).setScrollFlags(0);
            this.Y.setVisibility(0);
            ImageLoader.a(getFragmentActive(), R.drawable.circle_blur_bg).a(this.aa);
            this.Z.setNoDataBtnListener(onClickListener);
            ShapeTextView btn = this.Z.getBtn();
            int i = myCircleModel.is_applied;
            if (i == 1) {
                this.Z.setBtnStr(R.string.circle_applied_join);
                btn.setAlpha(0.3f);
                btn.setEnabled(false);
            } else if (i != 2) {
                this.Z.setBtnStr(R.string.circle_apply_join);
                btn.setAlpha(1.0f);
                btn.setEnabled(true);
            } else {
                this.Z.setBtnStr(R.string.circle_denied);
                btn.setAlpha(0.3f);
                btn.setEnabled(false);
            }
        }
        if (myCircleModel.is_applied == 1 || myCircleModel.is_applied == 2) {
            this.S.setBtnEnabled(false);
            this.S.setBtnBackgroundColor(R.color.syc_a_not_click);
            return;
        }
        this.S.setBtnEnabled(true);
        this.S.setBtnBackgroundColor(R.color.syc_a);
    }

    private void b(boolean z) {
        this.Q.j();
        if (z) {
            this.ae.loadMoreComplete();
        } else {
            this.ae.loadMoreFail();
        }
        if (this.ae.getData().size() <= 0) {
            if (z) {
                this.af.a();
            } else {
                this.af.b();
            }
        }
    }

    private void c() {
        this.f19149c = this.i.findViewById(R.id.skeleton);
        this.d = (ImageView) this.i.findViewById(R.id.iv_top_bg);
        this.e = (ImageView) this.i.findViewById(R.id.img_top_bg);
        this.f = (RotateLayout) this.i.findViewById(R.id.rotate_layout);
        this.g = (FrameLayout) this.i.findViewById(R.id.fl_top_white);
        this.k = (TextView) this.i.findViewById(R.id.tv_top_white);
        this.l = (ImageView) this.i.findViewById(R.id.title_scroll_left);
        this.m = (TextView) this.i.findViewById(R.id.tv_name_scroll);
        this.n = (TextView) this.i.findViewById(R.id.tv_number_scroll);
        this.o = (LinearLayout) this.i.findViewById(R.id.ll_title_scroll);
        this.p = (FrameLayout) this.i.findViewById(R.id.layout_title_scroll);
        this.q = (ImageView) this.i.findViewById(R.id.img_header);
        this.r = (FrameLayout) this.i.findViewById(R.id.fl_header_bottom);
        this.s = (TextView) this.i.findViewById(R.id.tv_name);
        this.t = (TextView) this.i.findViewById(R.id.tv_number);
        this.u = (LinearLayout) this.i.findViewById(R.id.ll_active_list);
        this.v = (ImageView) this.i.findViewById(R.id.iv_active_list);
        this.w = (TextView) this.i.findViewById(R.id.tv_active_list);
        this.x = (ImageView) this.i.findViewById(R.id.iv_active_list_help);
        this.y = (LinearLayout) this.i.findViewById(R.id.ll_active_header_all);
        this.z = (LinearLayout) this.i.findViewById(R.id.ll_active_header);
        this.A = (LinearLayout) this.i.findViewById(R.id.ll_title);
        this.B = (CircleJoinView) this.i.findViewById(R.id.cjv_join);
        this.C = (TextViewFixTouchForDynamic) this.i.findViewById(R.id.tv_content);
        this.D = (FrameLayout) this.i.findViewById(R.id.fl_content);
        this.E = (TextView) this.i.findViewById(R.id.tv_is_top_title_1);
        this.F = (LinearLayout) this.i.findViewById(R.id.ll_is_top_1);
        this.G = (TextView) this.i.findViewById(R.id.tv_is_top_title_2);
        this.H = (LinearLayout) this.i.findViewById(R.id.ll_is_top_2);
        this.I = (TextView) this.i.findViewById(R.id.tv_is_top_title_3);
        this.J = (LinearLayout) this.i.findViewById(R.id.ll_is_top_3);
        this.K = this.i.findViewById(R.id.top_line);
        this.L = (ShapeLinearLayout) this.i.findViewById(R.id.sll_is_top);
        this.M = (PageTabLayout) this.i.findViewById(R.id.tab_layout);
        this.N = (ShapeLinearLayout) this.i.findViewById(R.id.sll_list_title);
        this.O = (AppBarLayout) this.i.findViewById(R.id.appbar);
        this.P = (RecyclerView) this.i.findViewById(R.id.recycler_view);
        this.Q = (SmartRefreshLayout) this.i.findViewById(R.id.refresh_layout);
        this.R = (CommonTopTitleNoTrans) this.i.findViewById(R.id.title_still);
        this.S = (FloatFooterView) this.i.findViewById(R.id.ffv_post);
        this.T = (ImageView) this.i.findViewById(R.id.img_guide);
        this.U = (CircleJoinView) this.i.findViewById(R.id.cjv_join_scroll);
        this.V = (ImageView) this.i.findViewById(R.id.iv_number_scroll);
        this.W = (ImageView) this.i.findViewById(R.id.iv_number);
        this.X = (ImageView) this.i.findViewById(R.id.iv_ad_banner);
        this.Y = (ShapeConstraintLayout) this.i.findViewById(R.id.sfl_no_permission);
        this.Z = (NoDataAndLoadFailView) this.i.findViewById(R.id.no_permission_view);
        this.aa = (ImageView) this.i.findViewById(R.id.iv_no_permission);
        this.ab = (CircleJoinView) this.i.findViewById(R.id.cjv_join_view1);
        this.ac = (ShapeLinearLayout) this.i.findViewById(R.id.cjv_join_stroke);
        this.ad = (GroupJoinView) this.i.findViewById(R.id.group_join);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        a(0);
    }

    private void d() {
        LiveEventBus.get("common_refresh_circle_group", GroupInfoModel.class).observe(this, new Observer<GroupInfoModel>() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(GroupInfoModel groupInfoModel) {
                MyCircleModel t;
                int indexOf;
                if (groupInfoModel == null || (t = CircleDetailsFragment.this.j().t()) == null || t.groups == null || t.groups.size() <= 0 || (indexOf = t.groups.indexOf(groupInfoModel)) == -1) {
                    return;
                }
                t.groups.set(indexOf, groupInfoModel);
            }
        });
        LiveEventBus.get("common_group_dismiss", GroupInfoModel.class).observe(this, new Observer<GroupInfoModel>() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(GroupInfoModel groupInfoModel) {
                MyCircleModel t;
                if (groupInfoModel == null || (t = CircleDetailsFragment.this.j().t()) == null || t.groups == null || t.groups.size() <= 0) {
                    return;
                }
                t.groups.remove(groupInfoModel);
            }
        });
        LiveEventBus.get("common_refresh_circle_group_enter", Integer.class).observe(this, new Observer<Integer>() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.3
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Integer num) {
                if (CircleDetailsFragment.this.j().t() != null) {
                    CircleDetailsFragment.this.j().t().show_groups = num.intValue();
                    CommunityServiceManager.e().a(CircleDetailsFragment.this.ad, CircleDetailsFragment.this.j().t().show_groups, CircleDetailsFragment.this.j().t().groups, CircleDetailsFragment.this.getFragmentActive());
                }
            }
        });
        LiveEventBus.get("common_kick_out_member", Void.class).observe(this, new Observer<Void>() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.4
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Void r3) {
                CircleDetailsFragment.this.l();
            }
        });
        LiveEventBus.get("common_clear_group_member_state", String.class).observe(this, new Observer<String>() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.5
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (TextUtils.equals(str, CircleDetailsFragment.this.j().r())) {
                    CircleDetailsFragment.this.j().i = false;
                    CommunityServiceManager.e().a(CircleDetailsFragment.this.j().t().groups);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f.setVisibility(0);
        this.R.a();
        this.f.d();
        this.f.a(-15.0f);
        this.f.b();
    }

    private void v() {
        this.S.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.6
            @Override // com.blued.community.view.FloatFooterView.OnBtnClickListener
            public void onPostFeedClick() {
                EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_BTN_CLICK, FeedProtos.FeedFrom.PUBLISH_CIRCLE_NOTE);
                CircleDetailsFragment.this.b((CircleBubble) null);
            }
        });
        this.S.setBtnAnimatorUpdateListener(new FloatFooterView.BtnAnimatorUpdateListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.7
            @Override // com.blued.community.view.FloatFooterView.BtnAnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (CircleDetailsFragment.this.T != null) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) CircleDetailsFragment.this.T.getLayoutParams();
                    layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, -intValue);
                    CircleDetailsFragment.this.T.setLayoutParams(layoutParams);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.f19148a != null) {
            this.ac.setVisibility(8);
            this.am.cancel();
            this.f19148a.setRepeatMode(0);
            this.f19148a.cancel();
            this.ac.clearAnimation();
        }
    }

    private void x() {
        ShapeHelper.b(this.N, R.color.syc_b);
        this.M.b(R.string.base_list_new).setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleDetailsFragment$1LeJLxcNfKOsppeT9HPLM2jqcaA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CircleDetailsFragment.this.c(view);
            }
        }));
        this.M.b(R.string.base_list_hot).setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleDetailsFragment$fUgAFMifuVO8vF4n3YI_M8C3SyA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CircleDetailsFragment.this.b(view);
            }
        }));
        this.M.b(R.string.base_list_essence).setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleDetailsFragment$DvJ9VaHV-98HUHCrh7-tH3DOVvk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CircleDetailsFragment.this.a(view);
            }
        }));
        PageTabLayout pageTabLayout = this.M;
        pageTabLayout.a(pageTabLayout.a(j().p()));
    }

    private void y() {
        this.P.setBackgroundColor(BluedSkinUtils.a(this.ah, R.color.syc_b));
        this.P.setLayoutManager(new LinearLayoutManager(getContext()));
        this.ae = new CircleDetailsTalkAdapter(getContext(), getFragmentActive());
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.ah);
        this.af = noDataAndLoadFailView;
        noDataAndLoadFailView.setNoDataImg(R.drawable.icon_no_circle);
        this.af.setNoDataStr(R.string.circle_details_no_data);
        this.ae.setEmptyView(this.af);
        View inflate = View.inflate(this.ah, R.layout.layout_load_more_end_footer, null);
        this.ag = inflate;
        inflate.setVisibility(8);
        this.ae.addFooterView(this.ag);
        this.ae.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.9
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                CircleDetailsFragment.this.j().f();
            }
        }, this.P);
        this.ae.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.10
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                int id = view.getId();
                if (id == R.id.new_base_header || id == R.id.new_base_name) {
                    BluedIngSelfFeed bluedIngSelfFeed = CircleDetailsFragment.this.ae.getData().get(i);
                    if (bluedIngSelfFeed.is_anonym == 1) {
                        AppMethods.d(R.string.circle_anonymous_not_to_user_info);
                        return;
                    }
                    UserBasicModel userBasicModel = new UserBasicModel();
                    userBasicModel.uid = bluedIngSelfFeed.feed_uid;
                    userBasicModel.name = bluedIngSelfFeed.user_name;
                    userBasicModel.avatar = bluedIngSelfFeed.user_avatar;
                    userBasicModel.is_show_vip_page = bluedIngSelfFeed.is_show_vip_page;
                    EncryptTool.b(bluedIngSelfFeed.feed_id);
                    MessageProtos.StrangerSource strangerSource = CircleDetailsFragment.this.j().o() ? MessageProtos.StrangerSource.CIRCLE_DETAIL_NOTE_NEW : MessageProtos.StrangerSource.CIRCLE_DETAIL_NOTE_HOT;
                    LogData logData = new LogData();
                    logData.feed_id = bluedIngSelfFeed.feed_id;
                    CommunityServiceManager.b().a(CircleDetailsFragment.this.ah, userBasicModel, "CIRCLE_DETAIL", false, (View) null, logData, strangerSource);
                }
            }
        });
        this.ae.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.11
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                BluedIngSelfFeed bluedIngSelfFeed = CircleDetailsFragment.this.ae.getData().get(i);
                bluedIngSelfFeed.circle_title = CircleDetailsFragment.this.j().t().title;
                bluedIngSelfFeed.admin_level = CircleDetailsFragment.this.j().t().admin_level;
                bluedIngSelfFeed.cover = CircleDetailsFragment.this.j().t().cover;
                bluedIngSelfFeed.members_num = CircleDetailsFragment.this.j().t().members_num;
                int p = CircleDetailsFragment.this.j().p();
                if (p == 0) {
                    CirclePostDetailsFragment.a(CircleDetailsFragment.this.getContext(), bluedIngSelfFeed, FeedProtos.NoteSource.CIRCLE_NEW);
                } else if (p == 1) {
                    CirclePostDetailsFragment.a(CircleDetailsFragment.this.getContext(), bluedIngSelfFeed, FeedProtos.NoteSource.CIRCLE_HOT);
                } else if (p != 2) {
                } else {
                    CirclePostDetailsFragment.a(CircleDetailsFragment.this.getContext(), bluedIngSelfFeed, FeedProtos.NoteSource.CIRCLE_ESSENCE);
                }
            }
        });
        this.P.setAdapter(this.ae);
    }

    private void z() {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CircleDetailsFragment.this.G();
            }
        };
        this.l.setOnClickListener(onClickListener);
        this.R.setLeftClickListener(onClickListener);
        this.R.setRightClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (CircleDetailsFragment.this.R.getAlpha() >= 0.9f) {
                    EventTrackFeed.i(FeedProtos.Event.CIRCLE_DETAIL_MORE_BTN_CLICK, CircleDetailsFragment.this.j().n() ? "manager" : "user");
                    if (!CircleDetailsFragment.this.j().n()) {
                        CircleDetailsFragment.this.B();
                        return;
                    }
                    EventTrackFeed.i(FeedProtos.Event.CIRCLE_USER_MANAGE_SHOW, CircleDetailsFragment.this.j().n() ? "manager" : "user");
                    CircleDetailsFragment.this.A();
                }
            }
        });
        if (j().n()) {
            this.R.setRightImg(R.drawable.icon_title_more_white);
        } else {
            this.R.setRightImg(R.drawable.icon_title_share_white);
        }
    }

    public void a(int i) {
        if (j().p() == i) {
            this.P.smoothScrollToPosition(0);
            return;
        }
        j().b(j().p()).rvLocation = ViewUtils.a(this.P);
        b(i);
        ViewUtils.a(this.P, j().b(j().p()).rvLocation);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.ah = getContext();
        c();
        StatusBarHelper.a((Activity) getActivity(), false);
        e();
        D();
        z();
        y();
        x();
        v();
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final CircleBubble circleBubble) {
        if (TextUtils.isEmpty(circleBubble.img)) {
            return;
        }
        final String str = circleBubble.bubble_code + UserInfoUtils.c();
        if (CommunityPreferences.c(str)) {
            EventTrackFeed.a(FeedProtos.Event.FEED_BUBBLE_SHOW, j().r(), FeedProtos.FeedFrom.CIRCLE_DETAIL_POP, circleBubble.bubbleId);
            this.T.setVisibility(0);
            ImageLoader.a(getFragmentActive(), circleBubble.img).f().g(-1).a(new ImageLoadResult(getFragmentActive()) { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.36
                @Override // com.blued.android.core.image.ImageLoadResult
                public void a() {
                    CircleDetailsFragment.this.T.setVisibility(0);
                    CircleDetailsFragment.this.T.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.36.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            EventTrackFeed.a(FeedProtos.Event.FEED_BUBBLE_CLICK, CircleDetailsFragment.this.j().r(), FeedProtos.FeedFrom.CIRCLE_DETAIL_POP, circleBubble.bubbleId);
                            CommunityPreferences.d(str);
                            CircleDetailsFragment.this.b(circleBubble);
                            CircleDetailsFragment.this.T.setVisibility(8);
                        }
                    });
                }

                @Override // com.blued.android.core.image.ImageLoadResult
                public void a(int i, Exception exc) {
                    CircleDetailsFragment.this.T.setVisibility(8);
                }
            }).a(this.T);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, List list) {
        super.a(str, list);
        if (list == null) {
            return;
        }
        boolean z = true;
        switch (str.hashCode()) {
            case -1519155757:
                if (str.equals("circle_details")) {
                    z = false;
                    break;
                }
                break;
            case -1110522970:
                if (str.equals("circle_tab")) {
                    z = true;
                    break;
                }
                break;
            case -1098664433:
                if (str.equals("circle_details_ad")) {
                    z = true;
                    break;
                }
                break;
            case -66578769:
                if (str.equals("circle_post")) {
                    z = true;
                    break;
                }
                break;
            case 301159657:
                if (str.equals("circle_details_top")) {
                    z = true;
                    break;
                }
                break;
            case 483172972:
                if (str.equals("circle_new_list")) {
                    z = true;
                    break;
                }
                break;
            case 1211125443:
                if (str.equals("circle_delete_feed")) {
                    z = true;
                    break;
                }
                break;
            case 1799320587:
                if (str.equals("circle_join_state")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                MvpUtils.a(list, MyCircleModel.class, new MvpUtils.DataHandler<MyCircleModel>() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.20
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a() {
                        CircleDetailsFragment.this.a((MyCircleModel) null);
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a(MyCircleModel myCircleModel) {
                        CircleDetailsFragment.this.a(myCircleModel);
                    }
                });
                return;
            case true:
                MvpUtils.a(list, BluedIngSelfFeed.class, new MvpUtils.DataListHandler<BluedIngSelfFeed>() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.21
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a() {
                        CircleDetailsFragment.this.a(new ArrayList());
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a(List<BluedIngSelfFeed> list2) {
                        CircleDetailsFragment.this.a(list2);
                    }
                });
                return;
            case true:
                MvpUtils.a(list, BluedIngSelfFeed.class, new MvpUtils.DataListHandler<BluedIngSelfFeed>() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.22
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a() {
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a(List<BluedIngSelfFeed> list2) {
                        CircleDetailsFragment circleDetailsFragment = CircleDetailsFragment.this;
                        circleDetailsFragment.b(circleDetailsFragment.j().p());
                    }
                });
                return;
            case true:
                b(j().t());
                return;
            case true:
                this.ae.a(j().p());
                E();
                return;
            case true:
                MvpUtils.a(list, BluedIngSelfFeed.class, new MvpUtils.DataHandler<BluedIngSelfFeed>() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.23
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a() {
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a(BluedIngSelfFeed bluedIngSelfFeed) {
                        if (CircleDetailsFragment.this.ae != null) {
                            CircleDetailsFragment.this.ae.addData(0, (int) bluedIngSelfFeed);
                            CircleDetailsFragment.this.ae.notifyDataSetChanged();
                        }
                    }
                });
                return;
            case true:
                MvpUtils.a(list, CircleAdModel.class, new MvpUtils.DataHandler<CircleAdModel>() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.24
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a() {
                        CircleDetailsFragment.this.X.setVisibility(8);
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a(final CircleAdModel circleAdModel) {
                        CircleDetailsFragment.this.X.setVisibility(0);
                        ImageLoader.a(CircleDetailsFragment.this.getFragmentActive(), circleAdModel.icon).a(CircleDetailsFragment.this.X);
                        CircleDetailsFragment.this.X.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.24.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Tracker.onClick(view);
                                CommunityServiceManager.b().a(CircleDetailsFragment.this.ah, circleAdModel.url, CommunityConstants.WebShowType.AD);
                            }
                        });
                    }
                });
                return;
            case true:
                MvpUtils.a(list, String.class, new MvpUtils.DataHandler<String>() { // from class: com.blued.community.ui.circle.fragment.CircleDetailsFragment.25
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a() {
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a(String str2) {
                        CircleDetailsFragment.this.ae.b(str2);
                    }
                });
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        if (str == null) {
            return;
        }
        boolean z2 = true;
        int hashCode = str.hashCode();
        if (hashCode != -1290256561) {
            if (hashCode == 623698297 && str.equals("_load_type_loadmore_")) {
                z2 = true;
            }
        } else if (str.equals("_load_type_refresh_")) {
            z2 = false;
        }
        if (!z2) {
            this.f.setVisibility(8);
            this.R.c();
            this.f.e();
            b();
            j().a(getFragmentManager());
        } else if (!z2) {
            return;
        }
        b(z);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        this.O.removeOnOffsetChangedListener(this.ao);
        this.P.removeOnScrollListener(this.ap);
        super.af_();
        this.af = null;
    }

    public void b() {
        if (CommunityPreferences.a(j().r()) && CommunityPreferences.b(j().r()) && j().t().isJoin()) {
            EventTrackFeed.a(FeedProtos.Event.CIRCLE_JOIN_FEED_POP_SHOW);
            CommunityPreferences.b(j().r(), false);
            CommonAlertDialog.a(getContext(), getString(R.string.join_circle_dialog_title), CircleMethods.b(j().t().title), getString(R.string.join_circle_dialog_button_content), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleDetailsFragment$pVdi-tacYYIKiZtq01QHTqnLZCk
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    CircleDetailsFragment.this.a(dialogInterface, i);
                }
            }, new DialogInterface.OnDismissListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleDetailsFragment$YAhtYgUY2tFIQ3D9JjUnCgx2A58
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    CircleDetailsFragment.this.a(dialogInterface);
                }
            }, 1);
        }
    }

    public void b(int i) {
        this.ae.a(i);
        j().a(i);
        E();
        this.ae.setNewData(j().b(i).dataList);
        if (j().b(i).dataList.size() == 0) {
            this.af.a();
        }
        this.ag.setVisibility(j().b(i).hasMore ? 8 : 0);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_circle_details;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
        this.ae.setEnableLoadMore(true);
        this.ag.setVisibility(8);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        G();
        return true;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f19148a != null) {
            this.am.cancel();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.aq) {
            b();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
        this.ae.setEnableLoadMore(false);
        this.ag.setVisibility(0);
    }
}
