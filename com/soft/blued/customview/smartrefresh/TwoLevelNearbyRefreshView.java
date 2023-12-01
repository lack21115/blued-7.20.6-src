package com.soft.blued.customview.smartrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/smartrefresh/TwoLevelNearbyRefreshView.class */
public class TwoLevelNearbyRefreshView extends TwoLevelRefreshView {
    private boolean f;

    /* renamed from: com.soft.blued.customview.smartrefresh.TwoLevelNearbyRefreshView$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/smartrefresh/TwoLevelNearbyRefreshView$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28652a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[RefreshState.values().length];
            f28652a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f28652a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f28652a[RefreshState.ReleaseToRefresh.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f28652a[RefreshState.ReleaseToTwoLevel.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f28652a[RefreshState.Refreshing.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public TwoLevelNearbyRefreshView(Context context) {
        super(context);
        this.f = false;
    }

    public TwoLevelNearbyRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = false;
    }

    public TwoLevelNearbyRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = false;
    }

    @Override // com.soft.blued.customview.smartrefresh.TwoLevelRefreshView, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void a(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        int i = AnonymousClass1.f28652a[refreshState2.ordinal()];
        if (i == 1) {
            if (this.b != null) {
                this.b.setFrame(0);
                this.b.setProgress(0.0f);
            }
        } else if (i == 2) {
            if (this.f) {
                this.f28654c.setText(2131891363);
            } else {
                this.f28654c.setText(2131891361);
            }
        } else if (i == 3) {
            if (!this.e) {
                this.f28654c.setText(2131891364);
            } else if (this.f) {
                this.f28654c.setText(2131891363);
            } else {
                this.f28654c.setText(R.string.nearby_two_level_get);
            }
        } else if (i != 4) {
            if (i != 5) {
                return;
            }
            this.f28654c.setText(2131891363);
            if (this.f) {
                this.f = false;
            }
        } else if (this.e) {
            if (this.f) {
                this.f28654c.setText(2131891363);
            } else {
                this.f28654c.setText(R.string.nearby_two_level_in);
            }
        }
    }

    public void setClickBottomTabToRefresh(boolean z) {
        this.f = z;
    }
}
