package com.soft.blued.ui.msg.state;

import com.blued.android.module.common.base.mvi.UiAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/state/ServiceNumberListAction.class */
public abstract class ServiceNumberListAction implements UiAction {

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/state/ServiceNumberListAction$RefreshNewMsg.class */
    public static final class RefreshNewMsg extends ServiceNumberListAction {

        /* renamed from: a  reason: collision with root package name */
        public static final RefreshNewMsg f32598a = new RefreshNewMsg();

        private RefreshNewMsg() {
            super(null);
        }
    }

    private ServiceNumberListAction() {
    }

    public /* synthetic */ ServiceNumberListAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
