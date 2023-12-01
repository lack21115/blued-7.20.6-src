package com.soft.blued.ui.msg.viewModel;

import android.os.Bundle;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.StableSessionListListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.blued.android.module.common.base.mvi.UiAction;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.manager.SubscribeNumberManager;
import com.soft.blued.ui.msg.state.ServiceNumberListAction;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/viewModel/ServiceNumberListViewModel.class */
public final class ServiceNumberListViewModel extends BaseListViewModel<SessionModel> {

    /* renamed from: a  reason: collision with root package name */
    public MsgSessionListener f18928a;
    private long b = 100;

    /* renamed from: c  reason: collision with root package name */
    private List<SessionModel> f18929c = new ArrayList();

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/viewModel/ServiceNumberListViewModel$MsgSessionListener.class */
    public static final class MsgSessionListener extends StableSessionListListener {

        /* renamed from: a  reason: collision with root package name */
        private final ServiceNumberListViewModel f18930a;

        public MsgSessionListener(ServiceNumberListViewModel serviceNumberListViewModel) {
            Intrinsics.e(serviceNumberListViewModel, "vm");
            this.f18930a = serviceNumberListViewModel;
        }

        public void onUISessionDataChanged(List<SessionModel> list) {
            Intrinsics.e(list, "copyList");
            this.f18930a.d().clear();
            boolean z = true;
            if (list.size() > 0) {
                List<SessionModel> d = this.f18930a.d();
                List<SessionModel> d2 = ChatHelperV4.d(SubscribeNumberManager.f18759a.a(list, true));
                Intrinsics.c(d2, "sortSessionModelList(\n  …                        )");
                d.addAll(d2);
            }
            List<? extends SessionModel> j = CollectionsKt.j(this.f18930a.d());
            ServiceNumberListViewModel serviceNumberListViewModel = this.f18930a;
            if (j.size() != 20) {
                z = false;
            }
            serviceNumberListViewModel.a(j, z);
        }
    }

    public final MsgSessionListener a() {
        MsgSessionListener msgSessionListener = this.f18928a;
        if (msgSessionListener != null) {
            return msgSessionListener;
        }
        Intrinsics.c("msgSessionListener");
        return null;
    }

    public final void a(MsgSessionListener msgSessionListener) {
        Intrinsics.e(msgSessionListener, "<set-?>");
        this.f18928a = msgSessionListener;
    }

    public final void a(List<? extends SessionModel> list, boolean z) {
        Intrinsics.e(list, "data");
        loadListSucceed(list, z);
    }

    public final void b() {
        ChatManager.getInstance().registerSessionListener(a());
    }

    public final void c() {
        ChatManager.getInstance().unregisterSessionListener(a());
    }

    public final List<SessionModel> d() {
        return this.f18929c;
    }

    public void dispatchAction(UiAction uiAction) {
        Intrinsics.e(uiAction, "action");
        super.dispatchAction(uiAction);
        if (uiAction instanceof ServiceNumberListAction.RefreshNewMsg) {
            List<SessionModel> d = ChatHelperV4.d(this.f18929c);
            Intrinsics.c(d, "sortSessionModelList");
            loadListSucceed(CollectionsKt.j(d), false);
        }
    }

    public void init(Bundle bundle) {
        super.init(bundle);
        this.f18929c = new ArrayList();
        a(new MsgSessionListener(this));
    }

    public void requestData() {
    }
}
