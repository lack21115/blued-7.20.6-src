package com.soft.blued.ui.msg;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.anythink.expressad.video.module.a.a.m;
import com.baidu.mobads.sdk.internal.ci;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.StableIMConnectListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.TranslationAnimHintView;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.android.statistics.BluedStatistics;
import com.blued.das.message.MessageProtos;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.customview.HorizontalScrollView;
import com.soft.blued.customview.PopMenu;
import com.soft.blued.customview.RiseNumberTextView;
import com.soft.blued.customview.TouchEnableKeyboardLinearLayout;
import com.soft.blued.customview.VerticalTextView;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.bytedance.MessageEventUtils;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.push.PushChecker;
import com.soft.blued.ui.find.fragment.HelloStateDialogFragment;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.find.model.CallMeStatusData;
import com.soft.blued.ui.find.model.HelloDataExtra;
import com.soft.blued.ui.find.observer.CallHelloObserver;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.home.model.HomeViewModel;
import com.soft.blued.ui.msg.adapter.ChatFriendListAdapter;
import com.soft.blued.ui.msg.adapter.MsgHelloAdapter;
import com.soft.blued.ui.msg.contract.IMsgFilterCallback;
import com.soft.blued.ui.msg.contract.IMsgView;
import com.soft.blued.ui.msg.customview.MsgFilterView;
import com.soft.blued.ui.msg.fragment.HelloFragment;
import com.soft.blued.ui.msg.manager.DateTodayManager;
import com.soft.blued.ui.msg.model.DateTodayConfigModel;
import com.soft.blued.ui.msg.model.MsgListCheatModel;
import com.soft.blued.ui.msg.pop.DateTodayFunctionalEvaluationPop;
import com.soft.blued.ui.msg.pop.DateTodayGuidePop;
import com.soft.blued.ui.msg.pop.MsgBoxGuidePop;
import com.soft.blued.ui.msg.pop.MsgListCheatDialog;
import com.soft.blued.ui.msg.presenter.MsgPresenter;
import com.soft.blued.ui.msg.viewModel.MsgListViewModel;
import com.soft.blued.ui.search.SearchAllFragment;
import com.soft.blued.ui.setting.Contract.IPrivacySettingContract;
import com.soft.blued.ui.setting.Presenter.PrivacySettingPresenter;
import com.soft.blued.ui.setting.fragment.RemindSettingFragment;
import com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment;
import com.soft.blued.ui.user.fragment.VipUpgradeDialogFragment;
import com.soft.blued.ui.user.model.VipUpgradeModel;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.view.dialog.CommonNotification;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgFragment.class */
public class MsgFragment extends MvpFragment<MsgPresenter> implements View.OnClickListener, AbsListView.OnScrollListener, BluedSkinSupportable, CallHelloObserver.ICallHelloObserver, HomeTabClick.TabClickListener, IMsgFilterCallback, IMsgView, IPrivacySettingContract.IView {
    public static boolean b;
    private boolean A;
    private String B;
    private MsgListCheatDialog C;
    private DateTodayGuidePop D;
    private int E;

    /* renamed from: a  reason: collision with root package name */
    public MsgHelloAdapter f31849a;
    @BindView
    public TranslationAnimHintView bottom_hint_view;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f31850c;
    @BindView
    public View cover_view;
    private ListView d;
    private ViewGroup e;
    private MenuViewHolder f;
    private PopMenu g;
    private View k;
    @BindView
    public TouchEnableKeyboardLinearLayout keyboardLayout;
    private HeaderViewHolder l;
    private View m;
    @BindView
    public MsgFilterView msgFilterView;
    @BindView
    public View msg_filter_guide_iv;
    private View n;
    private HelloHeaderHolder o;
    private HelloHeaderHolderB p;
    @BindView
    public RenrenPullToRefreshListView pullRefresh;
    private ChatFriendListAdapter q;
    private IPrivacySettingContract.IPresenter r;
    @BindView
    public RelativeLayout rLayout;
    private Dialog s;
    private ImageView u;
    private int v;
    private int w;
    private boolean x;
    private MsgListViewModel z;
    private final MsgConnectListener t = new MsgConnectListener();
    private ArrayList<Unbinder> y = new ArrayList<>();

    /* renamed from: com.soft.blued.ui.msg.MsgFragment$22  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgFragment$22.class */
    class AnonymousClass22 implements DialogInterface.OnClickListener {
        AnonymousClass22() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Tracker.onClick(dialogInterface, i);
            MsgFragment.this.s.show();
            ThreadManager.a().a(new ThreadExecutor("ClearChatList") { // from class: com.soft.blued.ui.msg.MsgFragment.22.1
                @Override // com.blued.android.framework.pool.ThreadExecutor
                public void execute() {
                    ChatManager.getInstance().deleteAllSessions();
                    BluedStatistics.c().a("DELETE_SESSION_SUCCESS", 0L, 0, "delete all session");
                    MsgFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MsgFragment.22.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (MsgFragment.this.s != null) {
                                MsgFragment.this.s.dismiss();
                            }
                        }
                    });
                }
            });
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgFragment$HeaderViewHolder.class */
    public class HeaderViewHolder {
        @BindView
        public TranslationAnimHintView anim_hint_view;
        @BindView
        public TextView gtvHelloTitle;
        @BindView
        public View header_b;
        @BindView
        public RelativeLayout header_root;
        @BindView
        public ImageView ivMore;
        @BindView
        public ConstraintLayout layoutNewHello;
        @BindView
        public LinearLayout llHello;
        @BindView
        public NoDataAndLoadFailView ll_nodata_chats;
        @BindView
        public HorizontalScrollView mScrollView;
        @BindView
        public RelativeLayout rlHelloEmpty;
        @BindView
        public RiseNumberTextView rtvMultiple;
        @BindView
        public RiseNumberTextView rtvNum;
        @BindView
        public RecyclerView rvHello;
        @BindView
        public ShapeLinearLayout searchLayout;
        @BindView
        public ViewStub stub_push_remind;
        @BindView
        public ViewStub stub_push_remind_permanent;
        @BindView
        public VerticalTextView tvHelloMore;
        @BindView
        public TextView tvMore;

        public HeaderViewHolder() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgFragment$HeaderViewHolder_ViewBinding.class */
    public class HeaderViewHolder_ViewBinding implements Unbinder {
        private HeaderViewHolder b;

        public HeaderViewHolder_ViewBinding(HeaderViewHolder headerViewHolder, View view) {
            this.b = headerViewHolder;
            headerViewHolder.header_root = (RelativeLayout) Utils.a(view, 2131364229, "field 'header_root'", RelativeLayout.class);
            headerViewHolder.ll_nodata_chats = (NoDataAndLoadFailView) Utils.a(view, R.id.ll_nodata_chats, "field 'll_nodata_chats'", NoDataAndLoadFailView.class);
            headerViewHolder.searchLayout = (ShapeLinearLayout) Utils.a(view, R.id.search_layout, "field 'searchLayout'", ShapeLinearLayout.class);
            headerViewHolder.stub_push_remind = (ViewStub) Utils.a(view, R.id.stub_push_remind, "field 'stub_push_remind'", ViewStub.class);
            headerViewHolder.stub_push_remind_permanent = (ViewStub) Utils.a(view, R.id.stub_push_remind_permanent, "field 'stub_push_remind_permanent'", ViewStub.class);
            headerViewHolder.llHello = (LinearLayout) Utils.a(view, 2131367899, "field 'llHello'", LinearLayout.class);
            headerViewHolder.gtvHelloTitle = (TextView) Utils.a(view, R.id.gtv_hello_title, "field 'gtvHelloTitle'", TextView.class);
            headerViewHolder.tvMore = (TextView) Utils.a(view, 2131371973, "field 'tvMore'", TextView.class);
            headerViewHolder.ivMore = (ImageView) Utils.a(view, 2131365652, "field 'ivMore'", ImageView.class);
            headerViewHolder.rvHello = (RecyclerView) Utils.a(view, R.id.hello_recycler_view, "field 'rvHello'", RecyclerView.class);
            headerViewHolder.rlHelloEmpty = (RelativeLayout) Utils.a(view, R.id.rl_hello_empty, "field 'rlHelloEmpty'", RelativeLayout.class);
            headerViewHolder.mScrollView = (HorizontalScrollView) Utils.a(view, 2131369645, "field 'mScrollView'", HorizontalScrollView.class);
            headerViewHolder.tvHelloMore = (VerticalTextView) Utils.a(view, R.id.tv_hello_more, "field 'tvHelloMore'", VerticalTextView.class);
            headerViewHolder.layoutNewHello = (ConstraintLayout) Utils.a(view, R.id.layout_new_hello, "field 'layoutNewHello'", ConstraintLayout.class);
            headerViewHolder.rtvMultiple = (RiseNumberTextView) Utils.a(view, R.id.rtv_multiple, "field 'rtvMultiple'", RiseNumberTextView.class);
            headerViewHolder.rtvNum = (RiseNumberTextView) Utils.a(view, R.id.rtv_num, "field 'rtvNum'", RiseNumberTextView.class);
            headerViewHolder.anim_hint_view = (TranslationAnimHintView) Utils.a(view, R.id.anim_hint_view, "field 'anim_hint_view'", TranslationAnimHintView.class);
            headerViewHolder.header_b = Utils.a(view, R.id.header_b, "field 'header_b'");
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            HeaderViewHolder headerViewHolder = this.b;
            if (headerViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            headerViewHolder.header_root = null;
            headerViewHolder.ll_nodata_chats = null;
            headerViewHolder.searchLayout = null;
            headerViewHolder.stub_push_remind = null;
            headerViewHolder.stub_push_remind_permanent = null;
            headerViewHolder.llHello = null;
            headerViewHolder.gtvHelloTitle = null;
            headerViewHolder.tvMore = null;
            headerViewHolder.ivMore = null;
            headerViewHolder.rvHello = null;
            headerViewHolder.rlHelloEmpty = null;
            headerViewHolder.mScrollView = null;
            headerViewHolder.tvHelloMore = null;
            headerViewHolder.layoutNewHello = null;
            headerViewHolder.rtvMultiple = null;
            headerViewHolder.rtvNum = null;
            headerViewHolder.anim_hint_view = null;
            headerViewHolder.header_b = null;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgFragment$HelloHeaderHolder.class */
    public class HelloHeaderHolder {
        @BindView
        public ImageView iv_call_default;
        @BindView
        public TextView tv_call_me_btn;
        @BindView
        public TextView tv_hint;

        public HelloHeaderHolder() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgFragment$HelloHeaderHolderB.class */
    public class HelloHeaderHolderB {
        @BindView
        public ShapeFrameLayout fm_header_shape;
        @BindView
        public ImageView header_view;
        @BindView
        public ImageView iv_call;
        @BindView
        public TextView tv_call;
        @BindView
        public TextView tv_hint;

        public HelloHeaderHolderB() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgFragment$HelloHeaderHolderB_ViewBinding.class */
    public class HelloHeaderHolderB_ViewBinding implements Unbinder {
        private HelloHeaderHolderB b;

        public HelloHeaderHolderB_ViewBinding(HelloHeaderHolderB helloHeaderHolderB, View view) {
            this.b = helloHeaderHolderB;
            helloHeaderHolderB.fm_header_shape = (ShapeFrameLayout) Utils.a(view, R.id.fm_header_shape, "field 'fm_header_shape'", ShapeFrameLayout.class);
            helloHeaderHolderB.header_view = (ImageView) Utils.a(view, 2131364232, "field 'header_view'", ImageView.class);
            helloHeaderHolderB.iv_call = (ImageView) Utils.a(view, R.id.iv_call, "field 'iv_call'", ImageView.class);
            helloHeaderHolderB.tv_call = (TextView) Utils.a(view, R.id.tv_call, "field 'tv_call'", TextView.class);
            helloHeaderHolderB.tv_hint = (TextView) Utils.a(view, 2131371675, "field 'tv_hint'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            HelloHeaderHolderB helloHeaderHolderB = this.b;
            if (helloHeaderHolderB == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            helloHeaderHolderB.fm_header_shape = null;
            helloHeaderHolderB.header_view = null;
            helloHeaderHolderB.iv_call = null;
            helloHeaderHolderB.tv_call = null;
            helloHeaderHolderB.tv_hint = null;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgFragment$HelloHeaderHolder_ViewBinding.class */
    public class HelloHeaderHolder_ViewBinding implements Unbinder {
        private HelloHeaderHolder b;

        public HelloHeaderHolder_ViewBinding(HelloHeaderHolder helloHeaderHolder, View view) {
            this.b = helloHeaderHolder;
            helloHeaderHolder.tv_call_me_btn = (TextView) Utils.a(view, R.id.tv_call_me_btn, "field 'tv_call_me_btn'", TextView.class);
            helloHeaderHolder.iv_call_default = (ImageView) Utils.a(view, R.id.iv_call_default, "field 'iv_call_default'", ImageView.class);
            helloHeaderHolder.tv_hint = (TextView) Utils.a(view, 2131371675, "field 'tv_hint'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            HelloHeaderHolder helloHeaderHolder = this.b;
            if (helloHeaderHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            helloHeaderHolder.tv_call_me_btn = null;
            helloHeaderHolder.iv_call_default = null;
            helloHeaderHolder.tv_hint = null;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgFragment$IgnoredNoReadMsgObserver.class */
    class IgnoredNoReadMsgObserver implements Observer<Void> {
        private IgnoredNoReadMsgObserver() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(Void r6) {
            if (MsgFragment.this.q != null) {
                MsgFragment.this.q.a();
            }
            MsgFragment.this.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MsgFragment.IgnoredNoReadMsgObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    MsgFragment.this.j().x();
                }
            }, 600L);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgFragment$MenuObserver.class */
    class MenuObserver implements Observer<View> {
        private MenuObserver() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(View view) {
            MsgFragment.this.u = (ImageView) view;
            EventTrackMessage.a(MessageProtos.Event.MSG_MORE_BTN_CLICK);
            if (MsgFragment.this.g.a()) {
                MsgFragment.this.g.d();
            } else {
                MsgFragment.this.g.a(view);
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgFragment$MenuViewHolder.class */
    public class MenuViewHolder {
        @BindView
        public ImageView iv_msg_box_red_point;
        @BindView
        public RelativeLayout lay_item4;
        @BindView
        public RelativeLayout tv_item0;
        @BindView
        public TextView tv_item1;
        @BindView
        public TextView tv_item2;
        @BindView
        public TextView tv_item3;
        @BindView
        public TextView tv_item4;

        public MenuViewHolder() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgFragment$MenuViewHolder_ViewBinding.class */
    public class MenuViewHolder_ViewBinding implements Unbinder {
        private MenuViewHolder b;

        public MenuViewHolder_ViewBinding(MenuViewHolder menuViewHolder, View view) {
            this.b = menuViewHolder;
            menuViewHolder.tv_item0 = (RelativeLayout) Utils.a(view, R.id.tv_item0, "field 'tv_item0'", RelativeLayout.class);
            menuViewHolder.tv_item1 = (TextView) Utils.a(view, R.id.tv_item1, "field 'tv_item1'", TextView.class);
            menuViewHolder.tv_item2 = (TextView) Utils.a(view, R.id.tv_item2, "field 'tv_item2'", TextView.class);
            menuViewHolder.tv_item3 = (TextView) Utils.a(view, R.id.tv_item3, "field 'tv_item3'", TextView.class);
            menuViewHolder.tv_item4 = (TextView) Utils.a(view, R.id.tv_item4, "field 'tv_item4'", TextView.class);
            menuViewHolder.lay_item4 = (RelativeLayout) Utils.a(view, R.id.lay_item4, "field 'lay_item4'", RelativeLayout.class);
            menuViewHolder.iv_msg_box_red_point = (ImageView) Utils.a(view, R.id.iv_msg_box_red_point, "field 'iv_msg_box_red_point'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            MenuViewHolder menuViewHolder = this.b;
            if (menuViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            menuViewHolder.tv_item0 = null;
            menuViewHolder.tv_item1 = null;
            menuViewHolder.tv_item2 = null;
            menuViewHolder.tv_item3 = null;
            menuViewHolder.tv_item4 = null;
            menuViewHolder.lay_item4 = null;
            menuViewHolder.iv_msg_box_red_point = null;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgFragment$MsgConnectListener.class */
    class MsgConnectListener extends StableIMConnectListener {
        private MsgConnectListener() {
        }

        @Override // com.blued.android.chat.StableIMConnectListener
        public void onUIConnected() {
            Logger.c("MsgFragment", "onUIConnected-----");
            if (MsgFragment.this.l == null || MsgFragment.this.l.anim_hint_view == null || MsgFragment.this.getContext() == null) {
                return;
            }
            MsgFragment.this.l.anim_hint_view.a(4);
        }

        @Override // com.blued.android.chat.StableIMConnectListener
        public void onUIConnecting() {
            Logger.c("MsgFragment", "onUIConnecting-----");
            if (MsgFragment.this.l == null || MsgFragment.this.l.anim_hint_view == null || MsgFragment.this.getContext() == null) {
                return;
            }
            MsgFragment.this.l.anim_hint_view.a(4, MsgFragment.this.getContext().getResources().getString(R.string.chat_connecting));
        }

        @Override // com.blued.android.chat.StableIMConnectListener
        public void onUIDisconnected() {
            Logger.c("MsgFragment", "onUIDisconnected-----");
            if (MsgFragment.this.l == null || MsgFragment.this.l.anim_hint_view == null || MsgFragment.this.getContext() == null) {
                return;
            }
            MsgFragment.this.l.anim_hint_view.a(4, MsgFragment.this.getContext().getResources().getString(R.string.chat_disconnect));
        }

        @Override // com.blued.android.chat.StableIMConnectListener
        public void onUIReceiving() {
            Logger.c("MsgFragment", "onUIReceiving-----");
            if (MsgFragment.this.l == null || MsgFragment.this.l.anim_hint_view == null || MsgFragment.this.getContext() == null) {
                return;
            }
            MsgFragment.this.l.anim_hint_view.a(4, MsgFragment.this.getContext().getResources().getString(R.string.chat_receiving));
        }
    }

    public MsgFragment() {
        this.A = BluedConfig.a().b().call_buy_group == 0;
        this.B = "";
        this.E = -1;
    }

    private void F() {
        HelloHeaderHolderB helloHeaderHolderB;
        if (this.A || (helloHeaderHolderB = this.p) == null || helloHeaderHolderB.header_view == null) {
            return;
        }
        ImageLoader.a(getFragmentActive(), UserInfo.getInstance().getLoginUserInfo().avatar).b(2131237310).c().a(this.p.header_view);
    }

    private void G() {
        this.r = new PrivacySettingPresenter(getActivity(), getFragmentActive(), this);
        if (BluedPreferences.ax()) {
            this.r.c();
        }
        LiveEventBus.get(EventBusConstant.KEY_EVENT_SYNC_SECRET_LOOK_STATE, Boolean.class).observe(this, new Observer<Boolean>() { // from class: com.soft.blued.ui.msg.MsgFragment.5
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                MsgFragment.this.H();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        if (this.l == null || this.f == null) {
            return;
        }
        if (!BluedPreferences.av()) {
            this.f.tv_item4.setText(R.string.biao_v4_right_pup_four_open);
            this.l.anim_hint_view.a(3);
            return;
        }
        this.f.tv_item4.setText(R.string.biao_v4_right_pup_four_close);
        if (BluedPreferences.dv()) {
            TranslationAnimHintView.HintInfo hintInfo = new TranslationAnimHintView.HintInfo();
            hintInfo.f11074a = 3;
            hintInfo.b = getContext().getString(R.string.msg_secreting);
            hintInfo.f11075c = new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    BluedPreferences.Y(false);
                    MsgFragment.this.l.anim_hint_view.a(3);
                }
            };
            this.l.anim_hint_view.a(hintInfo);
        }
    }

    private void I() {
        ChatFriendListAdapter chatFriendListAdapter = new ChatFriendListAdapter(getFragmentActive(), this);
        this.q = chatFriendListAdapter;
        this.d.setAdapter((ListAdapter) chatFriendListAdapter);
        this.q.f31972a = j();
        this.d.setOnItemClickListener(j());
        this.d.setOnItemLongClickListener(j());
        this.d.setOnScrollListener(this);
    }

    private void J() {
        this.pullRefresh.setRefreshEnabled(true);
        this.pullRefresh.p();
        this.d = (ListView) this.pullRefresh.getRefreshableView();
        this.pullRefresh.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener() { // from class: com.soft.blued.ui.msg.MsgFragment.7
            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void a() {
                MsgFragment.this.b();
                MsgFragment.this.j().z();
            }

            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void b() {
            }
        });
        View inflate = this.f31850c.inflate(R.layout.layout_msg_list_head_view, (ViewGroup) null);
        this.k = inflate;
        this.d.addHeaderView(inflate);
        HeaderViewHolder headerViewHolder = new HeaderViewHolder();
        this.l = headerViewHolder;
        this.y.add(ButterKnife.a(headerViewHolder, this.k));
        applySkin();
        try {
            this.l.ll_nodata_chats.setNoDataImg(2131233626);
        } catch (Throwable th) {
        }
        this.l.searchLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackMessage.a(MessageProtos.Event.MSG_SCREEN_SEARCH_BOX_CLICK);
                SearchAllFragment.a(MsgFragment.this.getContext(), 1);
            }
        });
        if (this.A) {
            L();
        } else {
            K();
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.l.rvHello.setLayoutManager(linearLayoutManager);
        MsgHelloAdapter msgHelloAdapter = new MsgHelloAdapter(getFragmentActive(), getContext());
        this.f31849a = msgHelloAdapter;
        msgHelloAdapter.setHeaderAndEmpty(true);
        if (this.A) {
            this.f31849a.addHeaderView(this.m);
            ViewGroup.LayoutParams layoutParams = this.f31849a.getHeaderLayout().getLayoutParams();
            layoutParams.width = DensityUtils.a(getContext(), 77.0f);
            this.f31849a.getHeaderLayout().setLayoutParams(layoutParams);
        } else {
            this.n.setVisibility(0);
        }
        this.l.rvHello.setAdapter(this.f31849a);
        this.l.llHello.setVisibility(8);
        this.l.rvHello.setVisibility(8);
        this.l.layoutNewHello.setVisibility(8);
    }

    private void K() {
        this.n = this.l.header_b;
        HelloHeaderHolderB helloHeaderHolderB = new HelloHeaderHolderB();
        this.p = helloHeaderHolderB;
        this.y.add(ButterKnife.a(helloHeaderHolderB, this.n));
        this.n.setVisibility(8);
        ImageLoader.a(getFragmentActive(), UserInfo.getInstance().getLoginUserInfo().avatar).b(2131237310).c().a(this.p.header_view);
        this.p.header_view.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackMessage.b(MessageProtos.Event.MSG_VOCATIV_BTN_CLICK, CallHelloManager.a().f());
                MessageEventUtils.a(CallHelloManager.a().f());
                MsgFragment.this.N();
            }
        }));
        this.p.tv_hint.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgFragment.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackMessage.b(MessageProtos.Event.MSG_VOCATIV_BTN_CLICK, CallHelloManager.a().f());
                MessageEventUtils.a(CallHelloManager.a().f());
                MsgFragment.this.N();
            }
        }));
    }

    private void L() {
        View view = this.m;
        if (view == null) {
            this.m = View.inflate(getContext(), R.layout.layout_recommend_header, null);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.m.getParent()).removeView(this.m);
        }
        HelloHeaderHolder helloHeaderHolder = new HelloHeaderHolder();
        this.o = helloHeaderHolder;
        this.y.add(ButterKnife.a(helloHeaderHolder, this.m));
        this.m.setVisibility(8);
        this.o.tv_call_me_btn.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgFragment.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                EventTrackMessage.b(MessageProtos.Event.MSG_VOCATIV_BTN_CLICK, CallHelloManager.a().f());
                MessageEventUtils.a(CallHelloManager.a().f());
                MsgFragment.this.N();
            }
        }));
    }

    private boolean M() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null && (parentFragment instanceof MessagePageFragment) && ((MessagePageFragment) parentFragment).b() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        CallMeStatusData b2 = CallHelloManager.a().b();
        if (b2 == null || b2.call_status != 5) {
            CallHelloManager.a().a(getContext(), getFragmentActive(), 2, new CallHelloManager.ToOpenListener() { // from class: com.soft.blued.ui.msg.MsgFragment.12
                @Override // com.soft.blued.ui.find.manager.CallHelloManager.ToOpenListener
                public void done(boolean z) {
                    if (z) {
                        CallHelloManager.a().a(MsgFragment.this.getContext(), (IRequestHost) MsgFragment.this.getFragmentActive(), false, 2);
                    }
                }
            });
            return;
        }
        HelloStateDialogFragment.a(getContext(), b2);
        CallHelloManager.a().a(getContext(), getFragmentActive(), 2, (CallHelloManager.ToOpenListener) null);
    }

    private void O() {
        if (this.l == null) {
            return;
        }
        boolean z = true;
        if (!this.A ? this.n.getVisibility() != 0 : this.m.getVisibility() != 0) {
            z = false;
        }
        if (!z && this.f31849a.getData().size() <= 0) {
            this.l.llHello.setVisibility(8);
            this.l.rvHello.setVisibility(8);
            this.l.rlHelloEmpty.setVisibility(8);
            return;
        }
        this.l.llHello.setVisibility(0);
        this.l.rvHello.setVisibility(0);
        if (this.f31849a.getData().size() > 0) {
            this.l.rlHelloEmpty.setVisibility(8);
        } else {
            this.l.rlHelloEmpty.setVisibility(0);
        }
    }

    private void P() {
        View view = this.msg_filter_guide_iv;
        if (view == null || view.getVisibility() != 8) {
            return;
        }
        this.msg_filter_guide_iv.setVisibility(0);
        this.msg_filter_guide_iv.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgFragment.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                MsgFragment.this.msg_filter_guide_iv.setVisibility(8);
                MsgFragment.this.j().m();
            }
        });
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MsgFragment.20
            @Override // java.lang.Runnable
            public void run() {
                if (MsgFragment.this.msg_filter_guide_iv != null) {
                    MsgFragment.this.msg_filter_guide_iv.setVisibility(8);
                }
                MsgFragment.this.j().m();
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        View view = this.cover_view;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void R() {
        if (this.A) {
            if (this.m.getVisibility() != 0) {
                return;
            }
        } else if (this.n.getVisibility() != 0) {
            return;
        }
        CallHelloManager.a().d();
    }

    private void S() {
        if (this.A) {
            this.o.tv_call_me_btn.setBackgroundResource(R.drawable.icon_call_me_default);
            this.o.iv_call_default.setVisibility(0);
            this.o.tv_call_me_btn.setText("");
        } else {
            ImageLoader.c(getFragmentActive(), "msg_call_anim.png").f().g(-1).a(this.p.iv_call);
            this.p.tv_call.setText("");
        }
        CallHelloManager.a().c();
        CallHelloManager.a().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final MsgListCheatModel msgListCheatModel) {
        if (BluedPreferences.ey() == msgListCheatModel.getVersion() || !k()) {
            return;
        }
        MsgListCheatDialog msgListCheatDialog = this.C;
        if (msgListCheatDialog == null || !msgListCheatDialog.s()) {
            this.C = new MsgListCheatDialog(getContext(), msgListCheatModel);
            new XPopup.Builder(getContext()).a(new SimpleCallback() { // from class: com.soft.blued.ui.msg.MsgFragment.4
                @Override // com.blued.android.framework.ui.xpop.interfaces.SimpleCallback, com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
                public void c(BasePopupView basePopupView) {
                    super.c(basePopupView);
                    EventTrackMessage.a(MessageProtos.Event.MSG_LIST_SAFE_WARN_SHOW);
                    BluedPreferences.x(msgListCheatModel.getVersion());
                }

                @Override // com.blued.android.framework.ui.xpop.interfaces.SimpleCallback, com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
                public void d(BasePopupView basePopupView) {
                    Log.e("xxx", "onDismiss dateTodayItemIndex=" + MsgFragment.this.E);
                    if (MsgFragment.this.E >= 0) {
                        MsgFragment.this.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MsgFragment.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MsgFragment.this.b(Integer.valueOf(MsgFragment.this.E));
                            }
                        }, 500L);
                    }
                }
            }).c((Boolean) false).b((Boolean) false).d((Boolean) true).a(PopupAnimation.ScaleAlphaFromCenter).a((BasePopupView) this.C).h();
        }
    }

    private void a(boolean z, int i) {
        ChatFriendListAdapter chatFriendListAdapter = this.q;
        if (chatFriendListAdapter != null) {
            chatFriendListAdapter.a(j().s(), z);
            this.q.notifyDataSetChanged();
        }
        b(z, i);
    }

    private void b(boolean z, int i) {
        HeaderViewHolder headerViewHolder = this.l;
        if (headerViewHolder == null || headerViewHolder.ll_nodata_chats == null) {
            return;
        }
        if (i > 0) {
            this.l.ll_nodata_chats.d();
        } else {
            if (z) {
                this.l.ll_nodata_chats.setNoDataStr(R.string.no_filter_chats);
            } else {
                this.l.ll_nodata_chats.setNoDataStr(R.string.no_chats);
            }
            this.l.ll_nodata_chats.a();
        }
        this.rLayout.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101796));
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgFilterCallback
    public boolean A() {
        return j().o();
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgFilterCallback
    public boolean B() {
        return j().p();
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgFilterCallback
    public boolean C() {
        return j().t();
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public boolean D() {
        return false;
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public boolean E() {
        return false;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.s = DialogUtils.a(getContext());
        LayoutInflater from = LayoutInflater.from(getContext());
        this.f31850c = from;
        this.e = (ViewGroup) from.inflate(R.layout.fragment_main_msg_right_menu, (ViewGroup) null);
        MenuViewHolder menuViewHolder = new MenuViewHolder();
        this.f = menuViewHolder;
        this.y.add(ButterKnife.a(menuViewHolder, this.e));
        this.f.tv_item4.setText(BluedPreferences.av() ? 2131886755 : 2131886756);
        this.f.tv_item1.setOnClickListener(this);
        this.f.tv_item2.setOnClickListener(this);
        this.f.tv_item3.setOnClickListener(this);
        this.f.lay_item4.setOnClickListener(this);
        this.f.tv_item0.setOnClickListener(this);
        this.g = new PopMenu(getContext(), this.e);
        J();
        I();
        G();
        CallHelloObserver.a().a(this, getLifecycle());
    }

    public void a(AbsListView absListView) {
        int i = this.v;
        if (i == 0) {
            absListView.smoothScrollToPosition(0);
        } else {
            a(absListView, i);
        }
    }

    public void a(AbsListView absListView, int i) {
        int i2;
        int i3;
        int a2 = DensityUtils.a(getContext(), 80.0f);
        View view = this.k;
        int height = view != null ? view.getHeight() : 0;
        View childAt = absListView.getChildAt(0);
        int i4 = this.w;
        if (i4 == 0) {
            i3 = i - 1;
        } else {
            if (i4 == 1) {
                height += childAt.getTop();
                i2 = this.w;
            } else {
                height = childAt.getTop() + a2;
                i2 = this.w;
            }
            i3 = i - i2;
        }
        absListView.smoothScrollBy(height + (i3 * a2), 200);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BluedEntity bluedEntity) {
        HeaderViewHolder headerViewHolder = this.l;
        if (headerViewHolder == null) {
            return;
        }
        headerViewHolder.layoutNewHello.setVisibility(8);
        this.f31849a.setNewData(bluedEntity.data);
        this.l.llHello.setVisibility(0);
        this.l.rvHello.setVisibility(0);
        if (bluedEntity.hasMore()) {
            this.l.tvMore.setVisibility(0);
            this.l.ivMore.setVisibility(0);
            this.l.llHello.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgFragment.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    HelloFragment.a(MsgFragment.this.getContext(), MsgFragment.this.l.gtvHelloTitle.getText().toString());
                }
            });
            this.l.mScrollView.setOnReleaseListener(new HorizontalScrollView.OnReleaseListener() { // from class: com.soft.blued.ui.msg.MsgFragment.15
                @Override // com.soft.blued.customview.HorizontalScrollView.OnReleaseListener
                public void a() {
                    HelloFragment.a(MsgFragment.this.getContext(), (MsgFragment.this.l == null || MsgFragment.this.l.gtvHelloTitle == null) ? "" : MsgFragment.this.l.gtvHelloTitle.getText().toString());
                }
            });
            this.l.tvHelloMore.setVisibility(0);
        } else {
            this.l.tvMore.setVisibility(4);
            this.l.ivMore.setVisibility(8);
            this.l.llHello.setOnClickListener(null);
            this.l.mScrollView.setOnReleaseListener(null);
            this.l.tvHelloMore.setVisibility(8);
        }
        O();
    }

    @Override // com.soft.blued.ui.find.observer.CallHelloObserver.ICallHelloObserver
    public void a(CallMeStatusData callMeStatusData) {
        if (this.A) {
            c(callMeStatusData);
        } else {
            b(callMeStatusData);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(HelloDataExtra helloDataExtra) {
        if (this.l == null) {
            return;
        }
        if (!TextUtils.isEmpty(helloDataExtra.main_title)) {
            this.l.gtvHelloTitle.setText(helloDataExtra.main_title);
        }
        if (!TextUtils.isEmpty(helloDataExtra.subheading)) {
            this.l.tvMore.setText(helloDataExtra.subheading);
            return;
        }
        String string = getString(R.string.hello_peoples_wait_you_to_chat);
        String format = String.format(string, helloDataExtra.total_call_num + "");
        SpannableString spannableString = new SpannableString(format);
        CharacterStyle characterStyle = new CharacterStyle() { // from class: com.soft.blued.ui.msg.MsgFragment.16
            @Override // android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                if (MsgFragment.this.getContext() != null) {
                    textPaint.setColor(ContextCompat.getColor(MsgFragment.this.getContext(), 2131101766));
                    textPaint.setUnderlineText(false);
                }
            }
        };
        spannableString.setSpan(characterStyle, 0, (helloDataExtra.total_call_num + "").length() + 1, 33);
        CharacterStyle characterStyle2 = new CharacterStyle() { // from class: com.soft.blued.ui.msg.MsgFragment.17
            @Override // android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                if (MsgFragment.this.getContext() != null) {
                    textPaint.setColor(ContextCompat.getColor(MsgFragment.this.getContext(), 2131102263));
                    textPaint.setUnderlineText(false);
                }
            }
        };
        spannableString.setSpan(characterStyle2, (helloDataExtra.total_call_num + "").length() + 1, format.length(), 33);
        this.l.tvMore.setText(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Boolean bool) {
        if (this.f31849a == null) {
            return;
        }
        if (this.A) {
            if (bool.booleanValue()) {
                EventTrackMessage.b(MessageProtos.Event.MSG_VOCATIV_BTN_SHOW, CallHelloManager.a().f());
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
        } else if (bool.booleanValue()) {
            EventTrackMessage.b(MessageProtos.Event.MSG_VOCATIV_BTN_SHOW, CallHelloManager.a().f());
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
        O();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Integer num) {
        a(j().t(), num.intValue());
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void a(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<VipUpgradeModel> list) {
        VipUpgradeDialogFragment.f34178a.a(getContext(), getParentFragmentManager(), list, 2, j().v(), j().u(), VipProtos.FromType.UNKNOWN_FROM);
    }

    @Override // com.soft.blued.ui.find.observer.CallHelloObserver.ICallHelloObserver
    public void a(boolean z, String str) {
        if (!this.A) {
            if (this.p.iv_call == null || this.p.tv_call == null) {
                return;
            }
            if (z) {
                this.p.iv_call.setVisibility(8);
                this.p.tv_call.setText(str);
                return;
            }
            this.p.iv_call.setVisibility(0);
            this.p.tv_call.setText("");
        } else if (this.o == null || this.m.getVisibility() != 0 || this.o.iv_call_default == null || this.o.tv_call_me_btn == null) {
        } else {
            if (z) {
                this.o.iv_call_default.setVisibility(8);
                this.o.tv_call_me_btn.setText(str);
                return;
            }
            this.o.iv_call_default.setVisibility(0);
            this.o.tv_call_me_btn.setText("");
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
        View view = this.k;
        if (view != null) {
            this.d.removeHeaderView(view);
        }
        Iterator<Unbinder> it = this.y.iterator();
        while (it.hasNext()) {
            it.next().unbind();
        }
        this.y.clear();
        this.l = null;
        this.f = null;
        if (!this.A) {
            this.p = null;
            return;
        }
        this.o = null;
        View view2 = this.m;
        if (view2 == null || view2.getParent() == null) {
            return;
        }
        ((ViewGroup) this.m.getParent()).removeView(this.m);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        HeaderViewHolder headerViewHolder = this.l;
        if (headerViewHolder != null) {
            headerViewHolder.header_root.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101780));
            ShapeModel shapeModel = this.l.searchLayout.getShapeModel();
            shapeModel.k = BluedSkinUtils.a(getContext(), 2131102283);
            this.l.searchLayout.setShapeModel(shapeModel);
        }
    }

    public void b() {
        j().y();
    }

    @Override // com.soft.blued.ui.find.observer.CallHelloObserver.ICallHelloObserver
    public void b(int i) {
        if (this.A) {
            if (this.o == null || this.m.getVisibility() != 0) {
                return;
            }
            this.o.tv_hint.setText(TimeAndDateUtils.a(i, false));
        } else if (this.p == null || this.n.getVisibility() != 0) {
        } else {
            this.p.tv_hint.setText(TimeAndDateUtils.a(i, false));
        }
    }

    public void b(CallMeStatusData callMeStatusData) {
        View view = this.n;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        CallHelloManager.a().a(callMeStatusData);
        S();
        int i = callMeStatusData.call_status;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.p.fm_header_shape.setVisibility(0);
                    this.p.iv_call.setVisibility(0);
                    this.p.iv_call.setImageResource(R.drawable.icon_call_verify_b);
                    this.p.tv_call.setText("");
                    this.p.tv_hint.setText(getResources().getString(R.string.call_under_review));
                    return;
                } else if (i != 4) {
                    if (i != 5) {
                        return;
                    }
                }
            }
            this.p.fm_header_shape.setVisibility(8);
            CallHelloManager.a().a(getContext(), getFragmentActive(), 2);
            return;
        }
        this.p.fm_header_shape.setVisibility(0);
        if (callMeStatusData.free_count != 0) {
            this.p.iv_call.setVisibility(0);
            this.p.tv_call.setText("");
            this.p.tv_hint.setText(getResources().getString(R.string.free_call));
        } else if (callMeStatusData.pay_count == 0) {
            this.p.tv_hint.setText(getResources().getString(R.string.open_call));
        } else {
            this.p.iv_call.setVisibility(8);
            TextView textView = this.p.tv_call;
            textView.setText(callMeStatusData.pay_count + "");
            this.p.tv_hint.setText(getResources().getString(R.string.open_call));
            R();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(HelloDataExtra helloDataExtra) {
        if (this.l == null) {
            return;
        }
        float f = helloDataExtra.multiples;
        int i = helloDataExtra.promote_person_num;
        this.l.llHello.setVisibility(8);
        this.l.rvHello.setVisibility(8);
        this.l.layoutNewHello.setVisibility(0);
        this.l.layoutNewHello.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgFragment.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PrivilegeBuyDialogFragment.a(MsgFragment.this.getContext(), 2);
            }
        });
        if (this.l.rtvMultiple != null) {
            float floatValue = Float.valueOf(this.l.rtvMultiple.getText().toString()).floatValue();
            if (floatValue != 0.0f || f <= 1.0f) {
                this.l.rtvMultiple.setText(floatValue);
            } else {
                this.l.rtvMultiple.a(f, 1.0f);
                this.l.rtvMultiple.setDecimals(ci.d);
                this.l.rtvMultiple.setDuration(m.ag);
                this.l.rtvMultiple.b();
            }
        }
        if (this.l.rtvNum == null || i <= 0) {
            return;
        }
        this.l.rtvNum.a(i, (int) this.l.rtvNum.getNowNumber());
        this.l.rtvNum.setDuration(m.ag);
        this.l.rtvNum.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Boolean bool) {
        MsgFilterView msgFilterView = this.msgFilterView;
        if (msgFilterView != null) {
            msgFilterView.setNewMessageStatus(true);
        }
        if (bool.booleanValue()) {
            P();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Integer num) {
        MsgListCheatDialog msgListCheatDialog = this.C;
        if (msgListCheatDialog != null && msgListCheatDialog.s()) {
            this.E = num.intValue();
            Log.e("xxx", "showDateTodayGuide dateTodayItemIndex=" + this.E);
            return;
        }
        Log.e("xxx", "showDateTodayGuide");
        Context context = getContext();
        if (context == null) {
            return;
        }
        DateTodayGuidePop dateTodayGuidePop = this.D;
        if (dateTodayGuidePop == null || !dateTodayGuidePop.s()) {
            DateTodayManager.f32404a.g();
            int[] iArr = new int[2];
            View childAt = this.d.getChildAt(num.intValue() + this.d.getHeaderViewsCount());
            if (childAt != null) {
                childAt.getLocationInWindow(iArr);
                this.D = new DateTodayGuidePop(context, iArr[1]);
                new XPopup.Builder(context).d((Boolean) false).a((BasePopupView) this.D).h();
            }
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgFilterCallback
    public void b(boolean z) {
        j().a(z);
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void b(boolean z, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        if (k()) {
            postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MsgFragment.13
                @Override // java.lang.Runnable
                public void run() {
                    final MsgBoxGuidePop msgBoxGuidePop = new MsgBoxGuidePop(MsgFragment.this.getContext());
                    new XPopup.Builder(MsgFragment.this.getContext()).a((BasePopupView) msgBoxGuidePop).h();
                    TextView textView = msgBoxGuidePop.f32494c;
                    if (textView == null || MsgFragment.this.e == null) {
                        return;
                    }
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgFragment.13.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            msgBoxGuidePop.p();
                            MsgFragment.this.f.tv_item0.performClick();
                        }
                    });
                }
            });
        }
    }

    public void c(CallMeStatusData callMeStatusData) {
        if (this.o == null || this.m.getVisibility() != 0) {
            return;
        }
        CallHelloManager.a().a(callMeStatusData);
        S();
        int i = callMeStatusData.call_status;
        if (i == 0) {
            if (callMeStatusData.free_count != 0) {
                this.o.iv_call_default.setVisibility(0);
                this.o.tv_call_me_btn.setText("");
                this.o.tv_hint.setText(getResources().getString(R.string.free_call));
                return;
            } else if (callMeStatusData.pay_count == 0) {
                this.o.tv_hint.setText(getResources().getString(R.string.open_call));
                return;
            } else {
                this.o.iv_call_default.setVisibility(8);
                TextView textView = this.o.tv_call_me_btn;
                textView.setText(callMeStatusData.pay_count + "");
                this.o.tv_hint.setText(getResources().getString(R.string.open_call));
                R();
                return;
            }
        }
        if (i != 1) {
            if (i == 2) {
                this.o.iv_call_default.setVisibility(8);
                this.o.tv_call_me_btn.setText("");
                this.o.tv_call_me_btn.setBackgroundResource(R.drawable.icon_call_verify);
                this.o.tv_hint.setText(getResources().getString(R.string.call_under_review));
                return;
            } else if (i != 4) {
                if (i != 5) {
                    return;
                }
                this.o.iv_call_default.setVisibility(8);
                this.o.tv_call_me_btn.setText("");
                this.o.tv_call_me_btn.setBackgroundResource(R.drawable.icon_call_me_complete);
                this.o.tv_hint.setText(getResources().getString(R.string.finish_call));
                return;
            }
        }
        this.o.iv_call_default.setVisibility(8);
        if (callMeStatusData.multiples >= 10.0f) {
            this.o.tv_call_me_btn.setText("10x");
        } else {
            float floatValue = new BigDecimal(callMeStatusData.multiples).setScale(1, 1).floatValue();
            TextView textView2 = this.o.tv_call_me_btn;
            textView2.setText(floatValue + "x");
        }
        this.o.tv_call_me_btn.setBackgroundResource(R.drawable.icon_call_me_default);
        CallHelloManager.a().a(getContext(), getFragmentActive(), 2);
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void c(String str) {
        if ("msg".equals(str)) {
            this.v = 0;
            ListView listView = this.d;
            if (listView != null) {
                listView.smoothScrollToPosition(0);
            }
            j().z();
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgFilterCallback
    public void c(boolean z) {
        j().b(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        TranslationAnimHintView.HintInfo hintInfo = new TranslationAnimHintView.HintInfo();
        hintInfo.f11074a = 5;
        hintInfo.b = getContext().getString(R.string.msg_deleted_for_risk_users);
        hintInfo.f = true;
        this.bottom_hint_view.a(hintInfo);
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void d(String str) {
        if ("msg".equals(str)) {
            w();
            a(this.d);
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgFilterCallback
    public void d(boolean z) {
        j().c(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        RenrenPullToRefreshListView renrenPullToRefreshListView = this.pullRefresh;
        if (renrenPullToRefreshListView != null) {
            renrenPullToRefreshListView.j();
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgFilterCallback
    public void e(boolean z) {
        j().E();
        View view = this.msg_filter_guide_iv;
        if (view != null && view.getVisibility() == 0) {
            this.msg_filter_guide_iv.setVisibility(8);
        }
        if (z) {
            j().m();
        }
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void f(boolean z) {
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_msg;
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void g(boolean z) {
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void h(boolean z) {
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void i(boolean z) {
        BluedPreferences.B(z);
        H();
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void j(boolean z) {
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void k(boolean z) {
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void l(boolean z) {
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void m(boolean z) {
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void n(boolean z) {
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IView
    public void o(boolean z) {
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (b) {
            d();
            b = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131366717) {
            EventTrackMessage.a(MessageProtos.Event.MSG_MORE_OPEN_LOOK_QUIET);
            this.g.d();
            if (!BluedPreferences.av() && UserInfo.getInstance().getLoginUserInfo().vip_grade != 2 && BluedConfig.a().g().is_view_secretly == 0) {
                j().a(13, "chat_msg_quiet_all");
                InstantLog.a("msg_view_secretly_all_click", 0);
                return;
            }
            InstantLog.a("msg_view_secretly_all_click", 1);
            IPrivacySettingContract.IPresenter iPresenter = this.r;
            if (iPresenter != null) {
                iPresenter.a(true ^ BluedPreferences.av(), false);
                return;
            }
            return;
        }
        switch (id) {
            case R.id.tv_item0 /* 2131371742 */:
                this.g.d();
                BluedURIRouterAdapter.goChatAndOpenMsgBox(getChildFragmentManager(), 0);
                EventTrackMessage.a(MessageProtos.Event.MSG_MORE_NO_DISTURB_CLICK);
                if (BluedPreferences.bI()) {
                    return;
                }
                BluedPreferences.bH();
                this.f.iv_msg_box_red_point.setVisibility(4);
                ImageView imageView = this.u;
                if (imageView == null || !(imageView instanceof ImageView)) {
                    return;
                }
                imageView.setImageDrawable(BluedSkinUtils.b(getContext(), R.drawable.icon_title_filter_off));
                return;
            case R.id.tv_item1 /* 2131371743 */:
                EventTrackMessage.a(MessageProtos.Event.MSG_MORE_IGNORE_UNREAD);
                this.g.d();
                CommonAlertDialog.a(getContext(), getString(R.string.common_string_notice), getString(R.string.msg_not_read_clear_all), getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgFragment.21
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        ChatManager.getInstance().ignoredNoReadNumAll();
                    }
                }, getString(2131887258), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                return;
            case R.id.tv_item2 /* 2131371744 */:
                EventTrackMessage.a(MessageProtos.Event.MSG_MORE_CLEAR);
                this.g.d();
                CommonAlertDialog.a(getContext(), getContext().getResources().getString(R.string.biao_new_signin_tip), getContext().getResources().getString(R.string.biao_v4_clear_friend_list), getContext().getResources().getString(2131887281), new AnonymousClass22(), getContext().getResources().getString(2131887258), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                return;
            case R.id.tv_item3 /* 2131371745 */:
                this.g.d();
                TerminalActivity.d(getActivity(), RemindSettingFragment.class, null);
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.z = (MsgListViewModel) new ViewModelProvider(this).get(MsgListViewModel.class);
        LiveEventBus.get(EventBusConstant.KEY_EVENT_CLICK_RIGHT_POP_MENU, View.class).observe(this, new MenuObserver());
        LiveEventBus.get(EventBusConstant.KEY_EVENT_CLEAR_MESSAGE_CHAT, Void.class).observe(this, new IgnoredNoReadMsgObserver());
        ((HomeViewModel) ViewModelProviders.of(getActivity()).get(HomeViewModel.class)).f31047a.observe(this, new Observer<Integer>() { // from class: com.soft.blued.ui.msg.MsgFragment.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Integer num) {
                PushChecker.a().a(MsgFragment.this.getContext(), 0, MessageProtos.WarnTime.UNREAD_FIRST);
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_SESSION_LIST, Void.class).observe(this, new Observer<Void>() { // from class: com.soft.blued.ui.msg.MsgFragment.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Void r3) {
                MsgFragment.this.j().y();
            }
        });
        LiveEventBus.get(DateTodayManager.f32404a.t(), Void.class).observe(this, new Observer<Void>() { // from class: com.soft.blued.ui.msg.MsgFragment.3
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Void r6) {
                MsgFragment.this.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MsgFragment.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DateTodayConfigModel b2 = DateTodayManager.f32404a.b();
                        if (b2 != null) {
                            long l = DateTodayManager.f32404a.l();
                            int u = DateTodayManager.f32404a.u();
                            StringBuilder sb = new StringBuilder();
                            sb.append("nextShowTime=");
                            sb.append(l);
                            sb.append(", nextShowTime <= System.currentTimeMillis():");
                            sb.append(l <= System.currentTimeMillis());
                            Log.e("xxx", sb.toString());
                            if (l > System.currentTimeMillis() || u >= 3 || b2.getFunction_evaluation() == null || MsgFragment.this.getContext() == null) {
                                return;
                            }
                            new XPopup.Builder(MsgFragment.this.getContext()).a((BasePopupView) new DateTodayFunctionalEvaluationPop(MsgFragment.this.getContext(), b2.getFunction_evaluation(), MsgFragment.this.getFragmentActive())).h();
                            DateTodayManager.f32404a.c(u + 1);
                            DateTodayManager.f32404a.s();
                        }
                    }
                }, 200L);
            }
        });
        this.z.d().observe(this, new Observer() { // from class: com.soft.blued.ui.msg.-$$Lambda$MsgFragment$h4KOOT4SkZ3FAW-yHpVUB0aMt3g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MsgFragment.this.a((MsgListCheatModel) obj);
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        j().D();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        CommonNotification.a();
        InstantLog.a("session_list_show");
        j().C();
        this.pullRefresh.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101796));
        this.z.f();
        applySkin();
        F();
        Bundle bundleExtra = getActivity().getIntent().getBundleExtra("arg_subfragment_args");
        if (bundleExtra == null) {
            this.B = "";
            return;
        }
        String string = bundleExtra.getString("details", "");
        this.B = string;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        j().e(this.B);
        getActivity().setIntent(new Intent());
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i + i2 == i3) {
            this.x = true;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ChatManager.getInstance().registerIMStatusListener(this.t);
        j().A();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        j().B();
        ChatManager.getInstance().unregisterIMStatusListener(this.t);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101780));
        PushChecker.a().a(this.l.anim_hint_view, 0, MessageProtos.WarnTime.TOAST_MSG);
        PushChecker.a().a(this.l.anim_hint_view, 2, MessageProtos.WarnTime.TOAST_MSG);
        H();
        if (M()) {
            j().z();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public boolean q() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v() {
        HeaderViewHolder headerViewHolder = this.l;
        if (headerViewHolder == null) {
            return;
        }
        headerViewHolder.tvMore.setVisibility(4);
        this.l.ivMore.setVisibility(8);
        this.l.llHello.setVisibility(8);
        this.l.rvHello.setVisibility(8);
        this.l.layoutNewHello.setVisibility(8);
        O();
    }

    public void w() {
        int firstVisiblePosition = this.d.getFirstVisiblePosition();
        this.w = firstVisiblePosition;
        this.v = 0;
        while (true) {
            int i = firstVisiblePosition + 1;
            if (i >= j().h.a().size() + 1) {
                return;
            }
            firstVisiblePosition = i;
            if (i != 0) {
                if (this.v == i) {
                    firstVisiblePosition = i;
                } else {
                    SessionModel sessionModel = j().h.a().get(i - 1);
                    firstVisiblePosition = i;
                    if (sessionModel != null) {
                        firstVisiblePosition = i;
                        if (sessionModel.noReadMsgCount <= 0) {
                            continue;
                        } else if (!this.x) {
                            this.v = i;
                            return;
                        } else {
                            this.x = false;
                            firstVisiblePosition = 0;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgFilterCallback
    public void x() {
        this.cover_view.setVisibility(0);
        this.cover_view.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.msg.MsgFragment.23
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                MsgFragment.this.Q();
                if (MsgFragment.this.msgFilterView != null) {
                    MsgFragment.this.msgFilterView.a();
                }
                if (MsgFragment.this.msg_filter_guide_iv.getVisibility() == 0) {
                    MsgFragment.this.msg_filter_guide_iv.setVisibility(8);
                    MsgFragment.this.j().m();
                    return true;
                }
                return true;
            }
        });
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgFilterCallback
    public void y() {
        Q();
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgFilterCallback
    public boolean z() {
        return j().n();
    }
}
