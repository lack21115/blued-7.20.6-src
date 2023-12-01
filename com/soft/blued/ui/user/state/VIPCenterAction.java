package com.soft.blued.ui.user.state;

import com.blued.android.module.common.base.mvi.UiAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VIPCenterAction.class */
public abstract class VIPCenterAction implements UiAction {

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VIPCenterAction$GetVIPData.class */
    public static final class GetVIPData extends VIPCenterAction {

        /* renamed from: a  reason: collision with root package name */
        public static final GetVIPData f20619a = new GetVIPData();

        private GetVIPData() {
            super(null);
        }
    }

    private VIPCenterAction() {
    }

    public /* synthetic */ VIPCenterAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
