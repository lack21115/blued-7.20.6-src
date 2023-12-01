package com.blued.android.module.common.base.mvi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/BaseListAction.class */
public abstract class BaseListAction implements UiAction {

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/BaseListAction$LoadMoreData.class */
    public static final class LoadMoreData extends BaseListAction {
        public static final LoadMoreData a = new LoadMoreData();

        private LoadMoreData() {
            super(null);
        }
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/BaseListAction$RefreshData.class */
    public static final class RefreshData extends BaseListAction {
        public static final RefreshData a = new RefreshData();

        private RefreshData() {
            super(null);
        }
    }

    private BaseListAction() {
    }

    public /* synthetic */ BaseListAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
