package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.framework.R;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshPinnedSectionListView.class */
public class RenrenPullToRefreshPinnedSectionListView extends PullToRefreshPinnedSectionListView {
    private Context b;
    private View c;
    private LinearLayout d;
    private ImageView e;
    private TextView f;
    private ProgressBar g;
    private boolean h;
    private boolean i;
    private OnPullDownListener j;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshPinnedSectionListView$OnPullDownListener.class */
    public interface OnPullDownListener {
        void a();

        void b();
    }

    public RenrenPullToRefreshPinnedSectionListView(Context context) {
        super(context);
        this.h = false;
        this.i = false;
        a(context);
    }

    public RenrenPullToRefreshPinnedSectionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = false;
        this.i = false;
        d(context, attributeSet);
    }

    public RenrenPullToRefreshPinnedSectionListView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
        this.h = false;
        this.i = false;
        a(context);
    }

    public RenrenPullToRefreshPinnedSectionListView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
        this.h = false;
        this.i = false;
        a(context);
    }

    private void a(Context context) {
        d(context, null);
    }

    private void a(AttributeSet attributeSet) {
        ColorStateList colorStateList;
        Drawable drawable;
        TypedArray obtainStyledAttributes = this.b.obtainStyledAttributes(attributeSet, R.styleable.PullToRefresh);
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrFooterBackground) && (drawable = obtainStyledAttributes.getDrawable(R.styleable.PullToRefresh_ptrFooterBackground)) != null) {
            this.d.setBackgroundDrawable(drawable);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrFooterSubTextColor) && (colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.PullToRefresh_ptrFooterSubTextColor)) != null) {
            this.f.setTextColor(colorStateList);
        }
        obtainStyledAttributes.recycle();
    }

    private void b(AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.pulldown_footer, (ViewGroup) null);
        this.c = inflate;
        this.d = (LinearLayout) inflate.findViewById(R.id.pulldown_footer_content);
        this.e = (ImageView) this.c.findViewById(R.id.pulldown_footer_divider);
        TextView textView = (TextView) this.c.findViewById(R.id.pulldown_footer_text);
        this.f = textView;
        textView.setText(PullToRefreshHelper.d());
        this.g = (ProgressBar) this.c.findViewById(R.id.pulldown_footer_loading);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshPinnedSectionListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (RenrenPullToRefreshPinnedSectionListView.this.i) {
                    return;
                }
                RenrenPullToRefreshPinnedSectionListView.this.i = true;
                RenrenPullToRefreshPinnedSectionListView.this.f.setVisibility(4);
                RenrenPullToRefreshPinnedSectionListView.this.g.setVisibility(0);
                if (RenrenPullToRefreshPinnedSectionListView.this.j != null) {
                    RenrenPullToRefreshPinnedSectionListView.this.j.b();
                }
            }
        });
        if (attributeSet != null) {
            a(attributeSet);
        }
        ((ListView) getRefreshableView()).addFooterView(this.c);
    }

    private void d(Context context, AttributeSet attributeSet) {
        this.b = context;
        setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        b(attributeSet);
        setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() { // from class: com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshPinnedSectionListView.1
            @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase.OnRefreshListener
            public void onRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                if (RenrenPullToRefreshPinnedSectionListView.this.j != null) {
                    RenrenPullToRefreshPinnedSectionListView.this.j.a();
                }
            }
        });
        setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() { // from class: com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshPinnedSectionListView.2
            @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase.OnLastItemVisibleListener
            public void a() {
                if (RenrenPullToRefreshPinnedSectionListView.this.h && !RenrenPullToRefreshPinnedSectionListView.this.i && RenrenPullToRefreshPinnedSectionListView.this.r()) {
                    RenrenPullToRefreshPinnedSectionListView.this.i = true;
                    RenrenPullToRefreshPinnedSectionListView.this.f.setVisibility(4);
                    RenrenPullToRefreshPinnedSectionListView.this.g.setVisibility(0);
                    if (RenrenPullToRefreshPinnedSectionListView.this.j != null) {
                        RenrenPullToRefreshPinnedSectionListView.this.j.b();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        ListView listView = (ListView) getRefreshableView();
        return ((listView.getLastVisiblePosition() - listView.getFooterViewsCount()) - listView.getFirstVisiblePosition()) + 1 < listView.getCount() - listView.getFooterViewsCount();
    }

    public void o() {
        this.h = true;
        LinearLayout linearLayout = this.d;
        if (linearLayout == null || linearLayout.getVisibility() == 0) {
            return;
        }
        this.d.setVisibility(0);
    }

    public void p() {
        this.h = false;
        LinearLayout linearLayout = this.d;
        if (linearLayout == null || linearLayout.getVisibility() != 0) {
            return;
        }
        this.d.setVisibility(8);
    }

    public void q() {
        post(new Runnable() { // from class: com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshPinnedSectionListView.4
            @Override // java.lang.Runnable
            public void run() {
                RenrenPullToRefreshPinnedSectionListView.this.i = false;
                RenrenPullToRefreshPinnedSectionListView.this.f.setVisibility(0);
                RenrenPullToRefreshPinnedSectionListView.this.g.setVisibility(4);
            }
        });
    }

    public void setOnPullDownListener(OnPullDownListener onPullDownListener) {
        this.j = onPullDownListener;
    }

    public void setRefreshEnabled(boolean z) {
        if (z) {
            setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        } else {
            setMode(PullToRefreshBase.Mode.DISABLED);
        }
    }
}
