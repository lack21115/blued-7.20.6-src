package com.blued.android.module.common.widget.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.R;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalClassics;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/refresh/BluedLoadMoreView.class */
public class BluedLoadMoreView extends InternalClassics implements RefreshFooter {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f11226a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private View f11227c;
    private View d;
    private View e;
    private Context f;

    /* renamed from: com.blued.android.module.common.widget.refresh.BluedLoadMoreView$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/refresh/BluedLoadMoreView$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11228a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:37:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0051 -> B:33:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:31:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:27:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:35:0x0040). Please submit an issue!!! */
        static {
            int[] iArr = new int[RefreshState.values().length];
            f11228a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11228a[RefreshState.PullUpToLoad.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11228a[RefreshState.Loading.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f11228a[RefreshState.LoadReleased.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f11228a[RefreshState.ReleaseToLoad.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f11228a[RefreshState.Refreshing.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public BluedLoadMoreView(Context context) {
        this(context, null);
    }

    public BluedLoadMoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.f = context;
    }

    public BluedLoadMoreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11226a = false;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_load_more, this);
        this.e = inflate.findViewById(R.id.layout_load_more_view);
        this.b = inflate.findViewById(R.id.load_more_loading_view);
        this.f11227c = inflate.findViewById(R.id.load_more_load_fail_view);
        this.d = inflate.findViewById(R.id.load_more_load_end_view);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int a(RefreshLayout refreshLayout, boolean z) {
        if (this.f11226a) {
            return 0;
        }
        if (z) {
            this.b.setVisibility(0);
            this.f11227c.setVisibility(8);
            this.d.setVisibility(8);
        } else {
            this.b.setVisibility(8);
            this.f11227c.setVisibility(0);
            this.d.setVisibility(8);
        }
        return super.a(refreshLayout, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void a(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        if (this.f11226a) {
            return;
        }
        switch (AnonymousClass1.f11228a[refreshState2.ordinal()]) {
            case 1:
                this.b.setVisibility(0);
                this.f11227c.setVisibility(8);
                this.d.setVisibility(8);
                break;
            case 2:
                break;
            case 3:
            case 4:
                this.b.setVisibility(0);
                this.f11227c.setVisibility(8);
                this.d.setVisibility(8);
                return;
            case 5:
                this.b.setVisibility(0);
                this.f11227c.setVisibility(8);
                this.d.setVisibility(8);
                return;
            case 6:
                this.b.setVisibility(0);
                this.f11227c.setVisibility(8);
                this.d.setVisibility(8);
                return;
            default:
                return;
        }
        this.b.setVisibility(0);
        this.f11227c.setVisibility(8);
        this.d.setVisibility(8);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshFooter
    public boolean a(boolean z) {
        if (this.f11226a != z) {
            this.f11226a = z;
            if (z) {
                this.b.setVisibility(8);
                this.f11227c.setVisibility(8);
                this.d.setVisibility(0);
                return true;
            }
            this.b.setVisibility(0);
            this.f11227c.setVisibility(8);
            this.d.setVisibility(8);
            return true;
        }
        return true;
    }

    public void setBackgroundColorRes(int i) {
        this.e.setBackgroundColor(BluedSkinUtils.a(this.f, i));
    }
}
