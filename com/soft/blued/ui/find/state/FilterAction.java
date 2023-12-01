package com.soft.blued.ui.find.state;

import com.blued.android.module.common.base.mvi.UiAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/state/FilterAction.class */
public abstract class FilterAction implements UiAction {

    @Metadata
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/state/FilterAction$GetFilterData.class */
    public static final class GetFilterData extends FilterAction {

        /* renamed from: a  reason: collision with root package name */
        public static final GetFilterData f16984a = new GetFilterData();

        private GetFilterData() {
            super(null);
        }
    }

    private FilterAction() {
    }

    public /* synthetic */ FilterAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
