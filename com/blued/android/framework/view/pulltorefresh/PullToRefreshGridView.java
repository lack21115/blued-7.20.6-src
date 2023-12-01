package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.blued.android.framework.R;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshGridView.class */
public class PullToRefreshGridView extends PullToRefreshAdapterViewBase<GridView> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshGridView$InternalGridView.class */
    public class InternalGridView extends GridView implements EmptyViewMethodAccessor {
        public InternalGridView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.widget.AdapterView
        public void setEmptyView(View view) {
            PullToRefreshGridView.this.setEmptyView(view);
        }

        @Override // com.blued.android.framework.view.pulltorefresh.EmptyViewMethodAccessor
        public void setEmptyViewInternal(View view) {
            super.setEmptyView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshGridView$InternalGridViewSDK9.class */
    public final class InternalGridViewSDK9 extends InternalGridView {
        public InternalGridViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.view.View
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            OverscrollHelper.a(PullToRefreshGridView.this, i, i3, i2, i4, z);
            return overScrollBy;
        }
    }

    public PullToRefreshGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    /* renamed from: b */
    public final GridView a(Context context, AttributeSet attributeSet) {
        InternalGridViewSDK9 internalGridViewSDK9 = Build.VERSION.SDK_INT >= 9 ? new InternalGridViewSDK9(context, attributeSet) : new InternalGridView(context, attributeSet);
        internalGridViewSDK9.setId(R.id.gridview);
        return internalGridViewSDK9;
    }

    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase
    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        return PullToRefreshBase.Orientation.VERTICAL;
    }
}
