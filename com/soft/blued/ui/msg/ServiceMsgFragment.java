package com.soft.blued.ui.msg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.module.common.base.config.ListConfig;
import com.blued.android.module.common.base.mvi.BaseListAction;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.utils.NinePatchUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.ui.msg.adapter.ServiceMsgListAdapter;
import com.soft.blued.ui.msg.manager.SubscribeNumberManager;
import com.soft.blued.ui.msg.model.ServiceMsgModel;
import com.soft.blued.ui.msg.viewModel.ServiceMsgViewModel;
import com.soft.blued.utils.BluedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ServiceMsgFragment.class */
public final class ServiceMsgFragment extends BaseListFragment<ServiceMsgViewModel, ServiceMsgModel> implements BluedSkinSupportable {
    public static final Companion b = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private boolean f31910c;
    private PopupWindow d;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ServiceMsgFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.e(context, "context");
            TerminalActivity.d(context, ServiceMsgFragment.class, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean D() {
        return this.d != null;
    }

    private final void a(View view) {
        Resources resources;
        View inflate = View.inflate(getActivity(), R.layout.pop_service_msg_guide, null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_cnt);
        Context context = getContext();
        textView.setText((context == null || (resources = context.getResources()) == null) ? null : resources.getString(R.string.service_msg_guide_content));
        textView.setBackground(NinePatchUtils.a(NinePatchUtils.GuideArrowPosition.LEFT, 2131232896));
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$ServiceMsgFragment$ReVb1hGhX1Um_ZGM7BXfzwEiBck
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ServiceMsgFragment.b(ServiceMsgFragment.this, view2);
            }
        });
        inflate.measure(0, 0);
        int measuredHeight = inflate.getMeasuredHeight();
        int measuredWidth = inflate.getMeasuredWidth();
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        this.d = popupWindow;
        PopupWindow popupWindow2 = popupWindow;
        if (popupWindow == null) {
            Intrinsics.c("guidePopupWindow");
            popupWindow2 = null;
        }
        popupWindow2.setFocusable(false);
        PopupWindow popupWindow3 = this.d;
        PopupWindow popupWindow4 = popupWindow3;
        if (popupWindow3 == null) {
            Intrinsics.c("guidePopupWindow");
            popupWindow4 = null;
        }
        popupWindow4.setBackgroundDrawable(new ColorDrawable(0));
        PopupWindow popupWindow5 = this.d;
        PopupWindow popupWindow6 = popupWindow5;
        if (popupWindow5 == null) {
            Intrinsics.c("guidePopupWindow");
            popupWindow6 = null;
        }
        popupWindow6.setOutsideTouchable(false);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        PopupWindow popupWindow7 = this.d;
        if (popupWindow7 == null) {
            Intrinsics.c("guidePopupWindow");
            popupWindow7 = null;
        }
        popupWindow7.showAtLocation(view, 0, (iArr[0] + (view.getMeasuredWidth() / 2)) - (measuredWidth / 2), iArr[1] - measuredHeight);
        BluedPreferences.eR();
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.-$$Lambda$ServiceMsgFragment$Xm1cPDDqCiTj8QGCN5pYuSQ8lcc
            @Override // java.lang.Runnable
            public final void run() {
                ServiceMsgFragment.h(ServiceMsgFragment.this);
            }
        }, m.ag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ServiceMsgFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Context context = this$0.getContext();
        if (context == null) {
            return;
        }
        ServiceNumberListFragment.b.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ServiceMsgFragment this$0, ChattingModel chattingModel) {
        Intrinsics.e(this$0, "this$0");
        if (((ServiceMsgViewModel) this$0.y()).a() == null) {
            return;
        }
        ((ServiceMsgViewModel) this$0.y()).dispatchAction(BaseListAction.RefreshData.f10668a);
        SubscribeNumberManager.f32449a.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ServiceMsgFragment this$0, Void r4) {
        Intrinsics.e(this$0, "this$0");
        ((ServiceMsgViewModel) this$0.y()).a((ChattingModel) null);
        ((ServiceMsgViewModel) this$0.y()).dispatchAction(BaseListAction.RefreshData.f10668a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(boolean z) {
        if (z) {
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.-$$Lambda$ServiceMsgFragment$LcDVdX5W1Y-jITMqo-JB_oyiYcs
                @Override // java.lang.Runnable
                public final void run() {
                    ServiceMsgFragment.g(ServiceMsgFragment.this);
                }
            }, 1000L);
            RecyclerView a2 = a();
            if (a2 == null) {
                return;
            }
            a2.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.soft.blued.ui.msg.ServiceMsgFragment$showGuidePop$2
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    Intrinsics.e(recyclerView, "recyclerView");
                    super.onScrollStateChanged(recyclerView, i);
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    BaseQuickAdapter f;
                    RecyclerView a3;
                    BaseQuickAdapter f2;
                    boolean D;
                    PopupWindow popupWindow;
                    boolean z2;
                    PopupWindow popupWindow2;
                    PopupWindow popupWindow3;
                    CommonTopTitleNoTrans b2;
                    PopupWindow popupWindow4;
                    PopupWindow popupWindow5;
                    PopupWindow popupWindow6;
                    PopupWindow popupWindow7;
                    PopupWindow popupWindow8;
                    PopupWindow popupWindow9;
                    PopupWindow popupWindow10;
                    Intrinsics.e(recyclerView, "recyclerView");
                    super.onScrolled(recyclerView, i, i2);
                    int[] iArr = new int[2];
                    f = ServiceMsgFragment.this.f();
                    a3 = ServiceMsgFragment.this.a();
                    f2 = ServiceMsgFragment.this.f();
                    View viewByPosition = f.getViewByPosition(a3, f2.getHeaderLayoutCount() + 1, 2131365082);
                    if (viewByPosition != null) {
                        viewByPosition.getLocationOnScreen(iArr);
                        D = ServiceMsgFragment.this.D();
                        if (D) {
                            popupWindow = ServiceMsgFragment.this.d;
                            if (popupWindow == null) {
                                Intrinsics.c("guidePopupWindow");
                            }
                            z2 = ServiceMsgFragment.this.f31910c;
                            if (z2) {
                                return;
                            }
                            int i3 = iArr[0];
                            int measuredWidth = viewByPosition.getMeasuredWidth() / 2;
                            popupWindow2 = ServiceMsgFragment.this.d;
                            PopupWindow popupWindow11 = popupWindow2;
                            if (popupWindow2 == null) {
                                Intrinsics.c("guidePopupWindow");
                                popupWindow11 = null;
                            }
                            int measuredWidth2 = (i3 + measuredWidth) - (popupWindow11.getContentView().getMeasuredWidth() / 2);
                            int i4 = iArr[1];
                            popupWindow3 = ServiceMsgFragment.this.d;
                            PopupWindow popupWindow12 = popupWindow3;
                            if (popupWindow3 == null) {
                                Intrinsics.c("guidePopupWindow");
                                popupWindow12 = null;
                            }
                            int measuredHeight = i4 - popupWindow12.getContentView().getMeasuredHeight();
                            b2 = ServiceMsgFragment.this.b();
                            int bottom = b2 == null ? 0 : b2.getBottom();
                            popupWindow4 = ServiceMsgFragment.this.d;
                            PopupWindow popupWindow13 = popupWindow4;
                            if (popupWindow4 == null) {
                                Intrinsics.c("guidePopupWindow");
                                popupWindow13 = null;
                            }
                            if (measuredHeight <= bottom + popupWindow13.getContentView().getHeight()) {
                                popupWindow5 = ServiceMsgFragment.this.d;
                                PopupWindow popupWindow14 = popupWindow5;
                                if (popupWindow14 == null) {
                                    Intrinsics.c("guidePopupWindow");
                                    popupWindow14 = null;
                                }
                                popupWindow14.dismiss();
                                return;
                            }
                            popupWindow6 = ServiceMsgFragment.this.d;
                            PopupWindow popupWindow15 = popupWindow6;
                            if (popupWindow6 == null) {
                                Intrinsics.c("guidePopupWindow");
                                popupWindow15 = null;
                            }
                            if (!popupWindow15.isShowing()) {
                                popupWindow7 = ServiceMsgFragment.this.d;
                                PopupWindow popupWindow16 = popupWindow7;
                                if (popupWindow16 == null) {
                                    Intrinsics.c("guidePopupWindow");
                                    popupWindow16 = null;
                                }
                                popupWindow16.showAtLocation(viewByPosition, 0, measuredWidth2, measuredHeight);
                                return;
                            }
                            popupWindow8 = ServiceMsgFragment.this.d;
                            PopupWindow popupWindow17 = popupWindow8;
                            if (popupWindow8 == null) {
                                Intrinsics.c("guidePopupWindow");
                                popupWindow17 = null;
                            }
                            popupWindow9 = ServiceMsgFragment.this.d;
                            PopupWindow popupWindow18 = popupWindow9;
                            if (popupWindow9 == null) {
                                Intrinsics.c("guidePopupWindow");
                                popupWindow18 = null;
                            }
                            int width = popupWindow18.getWidth();
                            popupWindow10 = ServiceMsgFragment.this.d;
                            PopupWindow popupWindow19 = popupWindow10;
                            if (popupWindow19 == null) {
                                Intrinsics.c("guidePopupWindow");
                                popupWindow19 = null;
                            }
                            popupWindow17.update(measuredWidth2, measuredHeight, width, popupWindow19.getHeight());
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ServiceMsgFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        PopupWindow popupWindow = this$0.d;
        PopupWindow popupWindow2 = popupWindow;
        if (popupWindow == null) {
            Intrinsics.c("guidePopupWindow");
            popupWindow2 = null;
        }
        popupWindow2.dismiss();
        this$0.f31910c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ServiceMsgFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        View viewByPosition = this$0.f().getViewByPosition(this$0.a(), this$0.f().getHeaderLayoutCount() + 1, 2131365082);
        if (viewByPosition == null) {
            return;
        }
        this$0.a(viewByPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ServiceMsgFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.f31910c = true;
        PopupWindow popupWindow = this$0.d;
        PopupWindow popupWindow2 = popupWindow;
        if (popupWindow == null) {
            Intrinsics.c("guidePopupWindow");
            popupWindow2 = null;
        }
        popupWindow2.dismiss();
        BluedPreferences.eR();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    /* renamed from: C */
    public ServiceMsgListAdapter i() {
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        return new ServiceMsgListAdapter(fragmentActive);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        CommonTopTitleNoTrans b2 = b();
        if (b2 == null) {
            return;
        }
        b2.getRightImg().setImageDrawable(BluedSkinUtils.b(getContext(), R.drawable.icon_service_msg_right_menu));
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public ListConfig h() {
        return new ListConfig.Builder().a(20).b(false).c(true).a();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        Resources resources;
        super.m();
        FrameLayout frameLayout = (FrameLayout) requireView().findViewById(2131364048);
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101796));
        }
        CommonTopTitleNoTrans b2 = b();
        if (b2 != null) {
            Context context = getContext();
            String str = null;
            if (context != null && (resources = context.getResources()) != null) {
                str = resources.getString(R.string.msg_service_information);
            }
            b2.setCenterText(str);
            b2.getRightImg().setImageDrawable(BluedSkinUtils.b(getContext(), R.drawable.icon_service_msg_right_menu));
            b2.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$ServiceMsgFragment$rDpye5bMWOziIdP-jxWHGUNAmNA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ServiceMsgFragment.a(ServiceMsgFragment.this, view);
                }
            });
        }
        NoDataAndLoadFailView c2 = c();
        if (c2 != null) {
            c2.setNoDataImg(2131233626);
            c2.setNoDataBtnVisibility(8);
            c2.setNoDataStr(R.string.msg_service_information_no_data);
        }
        SubscribeNumberManager.f32449a.c();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void o() {
        super.o();
        ServiceMsgFragment serviceMsgFragment = this;
        LifecycleExtKt.a(serviceMsgFragment, ((ServiceMsgViewModel) y()).c(), new ServiceMsgFragment$liveDataObserver$1(this));
        LiveEventBus.get(EventBusConstant.KEY_EVENT_SERVICE_NUMBER_DELETE, Void.class).observe(serviceMsgFragment, new Observer() { // from class: com.soft.blued.ui.msg.-$$Lambda$ServiceMsgFragment$nRq8LkzL2UqgUlI8Fa7gWGiVzSc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ServiceMsgFragment.a(ServiceMsgFragment.this, (Void) obj);
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_SERVICE_NEW_MSG, ChattingModel.class).observe(serviceMsgFragment, new Observer() { // from class: com.soft.blued.ui.msg.-$$Lambda$ServiceMsgFragment$IA7KCajp35pAKEeCyMgucxRcH7E
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ServiceMsgFragment.a(ServiceMsgFragment.this, (ChattingModel) obj);
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (!BluedPreferences.eS() || BluedPreferences.eQ()) {
            return;
        }
        BluedPreferences.eT();
    }
}
