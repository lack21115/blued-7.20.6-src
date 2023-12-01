package com.soft.blued.ui.msg_group.state;

import com.blued.android.module.common.base.mvi.UiAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/state/GroupClassifyStateAction.class */
public abstract class GroupClassifyStateAction implements UiAction {

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/state/GroupClassifyStateAction$GetClassify.class */
    public static final class GetClassify extends GroupClassifyStateAction {

        /* renamed from: a  reason: collision with root package name */
        public static final GetClassify f19135a = new GetClassify();

        private GetClassify() {
            super(null);
        }
    }

    private GroupClassifyStateAction() {
    }

    public /* synthetic */ GroupClassifyStateAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
