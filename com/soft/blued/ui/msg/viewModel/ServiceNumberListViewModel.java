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
    public MsgSessionListener f32619a;
    private long b = 100;

    /* renamed from: c  reason: collision with root package name */
    private List<SessionModel> f32620c = new ArrayList();

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/viewModel/ServiceNumberListViewModel$MsgSessionListener.class */
    public static final class MsgSessionListener extends StableSessionListListener {

        /* renamed from: a  reason: collision with root package name */
        private final ServiceNumberListViewModel f32621a;

        public MsgSessionListener(ServiceNumberListViewModel vm) {
            Intrinsics.e(vm, "vm");
            this.f32621a = vm;
        }

        @Override // com.blued.android.chat.StableSessionListListener
        public void onUISessionDataChanged(List<SessionModel> copyList) {
            Intrinsics.e(copyList, "copyList");
            this.f32621a.d().clear();
            boolean z = true;
            if (copyList.size() > 0) {
                List<SessionModel> d = this.f32621a.d();
                List<SessionModel> d2 = ChatHelperV4.d(SubscribeNumberManager.f32449a.a(copyList, true));
                Intrinsics.c(d2, "sortSessionModelList(\n  …                        )");
                d.addAll(d2);
            }
            List<? extends SessionModel> j = CollectionsKt.j((Iterable) this.f32621a.d());
            ServiceNumberListViewModel serviceNumberListViewModel = this.f32621a;
            if (j.size() != 20) {
                z = false;
            }
            serviceNumberListViewModel.a(j, z);
        }
    }

    public final MsgSessionListener a() {
        MsgSessionListener msgSessionListener = this.f32619a;
        if (msgSessionListener != null) {
            return msgSessionListener;
        }
        Intrinsics.c("msgSessionListener");
        return null;
    }

    public final void a(MsgSessionListener msgSessionListener) {
        Intrinsics.e(msgSessionListener, "<set-?>");
        this.f32619a = msgSessionListener;
    }

    public final void a(List<? extends SessionModel> data, boolean z) {
        Intrinsics.e(data, "data");
        loadListSucceed(data, z);
    }

    public final void b() {
        ChatManager.getInstance().registerSessionListener(a());
    }

    public final void c() {
        ChatManager.getInstance().unregisterSessionListener(a());
    }

    public final List<SessionModel> d() {
        return this.f32620c;
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListViewModel, com.blued.android.module.common.base.mvi.MVIBaseViewModel
    public void dispatchAction(UiAction action) {
        Intrinsics.e(action, "action");
        super.dispatchAction(action);
        if (action instanceof ServiceNumberListAction.RefreshNewMsg) {
            List<SessionModel> sortSessionModelList = ChatHelperV4.d(this.f32620c);
            Intrinsics.c(sortSessionModelList, "sortSessionModelList");
            loadListSucceed(CollectionsKt.j((Iterable) sortSessionModelList), false);
        }
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseViewModel
    public void init(Bundle bundle) {
        super.init(bundle);
        this.f32620c = new ArrayList();
        a(new MsgSessionListener(this));
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListViewModel
    public void requestData() {
    }
}
