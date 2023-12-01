package com.soft.blued.ui.msg;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.module.common.base.config.ListConfig;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.menu.BottomMenuPop;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.ui.msg.adapter.ServiceNumberListAdapter;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.manager.SubscribeNumberManager;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg.state.ServiceNumberListAction;
import com.soft.blued.ui.msg.viewModel.ServiceNumberListViewModel;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ServiceNumberListFragment.class */
public final class ServiceNumberListFragment extends BaseListFragment<ServiceNumberListViewModel, SessionModel> {
    public static final Companion b = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private BottomMenuPop f31912c;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ServiceNumberListFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.e(context, "context");
            TerminalActivity.d(context, ServiceNumberListFragment.class, null);
        }
    }

    private final void a(SessionModel sessionModel, int i) {
        ChatManager.getInstance().deleteSessionAndChatting((short) 2, sessionModel.sessionId);
        ((ServiceNumberListViewModel) y()).dispatchAction(ServiceNumberListAction.RefreshNewMsg.f32598a);
        f().notifyDataSetChanged();
        LiveEventBus.get(EventBusConstant.KEY_EVENT_SERVICE_NUMBER_DELETE).post(null);
    }

    private final void a(final SessionModel sessionModel, String[] strArr, final int i) {
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            final String str = strArr[i2];
            i2++;
            BottomMenuPop.MenuItemInfo menuItemInfo = new BottomMenuPop.MenuItemInfo();
            menuItemInfo.f11214a = str;
            final Context context = getContext();
            if (context != null) {
                menuItemInfo.d = new View.OnClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$ServiceNumberListFragment$IbiXgS5TASzc_TqjmpH3GleBVvw
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ServiceNumberListFragment.a(ServiceNumberListFragment.this, str, context, sessionModel, i, view);
                    }
                };
                arrayList.add(menuItemInfo);
                BottomMenuPop bottomMenuPop = new BottomMenuPop(context);
                this.f31912c = bottomMenuPop;
                if (bottomMenuPop != null) {
                    bottomMenuPop.b = arrayList;
                }
                new XPopup.Builder(context).a((BasePopupView) this.f31912c).h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ServiceNumberListFragment this$0, ChattingModel chattingModel) {
        Intrinsics.e(this$0, "this$0");
        ((ServiceNumberListViewModel) this$0.y()).dispatchAction(ServiceNumberListAction.RefreshNewMsg.f32598a);
        SubscribeNumberManager.f32449a.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ServiceNumberListFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        Object obj = baseQuickAdapter.getData().get(i);
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.chat.model.SessionModel");
        }
        SessionModel sessionModel = (SessionModel) obj;
        LogData logData = new LogData();
        logData.from = "none";
        ChatHelperV4.a().a((Context) this$0.getActivity(), sessionModel.sessionId, sessionModel.nickName, sessionModel.avatar, sessionModel.vBadge, sessionModel.vipGrade, sessionModel.vipAnnual, sessionModel.vipExpLvl, Intrinsics.a(sessionModel.lastMsgFromDistance, (Object) ""), false, 0, 0, logData, BluedPreferences.eS() && !BluedPreferences.eQ(), new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ServiceNumberListFragment this$0, String s, Context context, SessionModel sessionModel, int i, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(s, "$s");
        Intrinsics.e(context, "$context");
        Intrinsics.e(sessionModel, "$sessionModel");
        BottomMenuPop bottomMenuPop = this$0.f31912c;
        if (bottomMenuPop != null && bottomMenuPop != null) {
            bottomMenuPop.p();
        }
        if (TextUtils.equals(s, context.getResources().getString(2131887471))) {
            this$0.a(sessionModel, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(ServiceNumberListFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        Object obj = baseQuickAdapter.getData().get(i);
        if (obj != null) {
            SessionModel sessionModel = (SessionModel) obj;
            Object[] array = CollectionsKt.d(AppUtils.a(2131887471)).toArray(new String[0]);
            Intrinsics.c(array, "items.toArray(arrayOf())");
            this$0.a(sessionModel, (String[]) array, i);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.blued.android.chat.model.SessionModel");
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public LinearLayoutManager g() {
        return new LinearLayoutManager(getContext());
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public ListConfig h() {
        return new ListConfig.Builder().c(false).b(false).a();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public BaseQuickAdapter<SessionModel, BaseViewHolder> i() {
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        return new ServiceNumberListAdapter(fragmentActive);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        Resources resources;
        super.m();
        CommonTopTitleNoTrans b2 = b();
        String str = null;
        TextView centerTextView = b2 == null ? null : b2.getCenterTextView();
        if (centerTextView != null) {
            Context context = getContext();
            if (context != null && (resources = context.getResources()) != null) {
                str = resources.getString(R.string.msg_service_number);
            }
            centerTextView.setText(str);
        }
        f().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$ServiceNumberListFragment$bEBCul5TNYyIsjStopfEr9mOuGk
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ServiceNumberListFragment.a(ServiceNumberListFragment.this, baseQuickAdapter, view, i);
            }
        });
        NoDataAndLoadFailView c2 = c();
        if (c2 != null) {
            c2.setNoDataImg(2131233626);
            c2.setNoDataBtnVisibility(8);
            c2.setNoDataStr(R.string.msg_service_number_no_data);
        }
        f().setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$ServiceNumberListFragment$yX2BajpHWg_OSUNEVNZPFkPrKkk
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                boolean b3;
                b3 = ServiceNumberListFragment.b(ServiceNumberListFragment.this, baseQuickAdapter, view, i);
                return b3;
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void o() {
        super.o();
        LiveEventBus.get(EventBusConstant.KEY_EVENT_SERVICE_NEW_MSG, ChattingModel.class).observe(this, new Observer() { // from class: com.soft.blued.ui.msg.-$$Lambda$ServiceNumberListFragment$KDDZd2Ze9GV0kFENuCTqeVHVSXo
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ServiceNumberListFragment.a(ServiceNumberListFragment.this, (ChattingModel) obj);
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((ServiceNumberListViewModel) y()).b();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        ((ServiceNumberListViewModel) y()).c();
    }
}
