package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.framework.R;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshListView.class */
public class RenrenPullToRefreshListView extends PullToRefreshListView {
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private View f10276c;
    private LinearLayout d;
    private ImageView e;
    private TextView f;
    private ProgressBar g;
    private boolean h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private long m;
    private OnPullDownListener n;
    private AbsListView.OnScrollListener o;
    private AbsListView.OnScrollListener p;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshListView$OnPullDownListener.class */
    public interface OnPullDownListener {
        void a();

        void b();
    }

    public RenrenPullToRefreshListView(Context context) {
        super(context);
        this.h = false;
        this.i = false;
        this.j = true;
        this.p = new AbsListView.OnScrollListener() { // from class: com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                ListAdapter adapter;
                if (RenrenPullToRefreshListView.this.o != null) {
                    RenrenPullToRefreshListView.this.o.onScroll(absListView, i, i2, i3);
                }
                if (!RenrenPullToRefreshListView.this.j || !RenrenPullToRefreshListView.this.h || RenrenPullToRefreshListView.this.i || RenrenPullToRefreshListView.this.n == null || (adapter = absListView.getAdapter()) == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (RenrenPullToRefreshListView.this.m == 0) {
                    RenrenPullToRefreshListView.this.m = currentTimeMillis;
                } else if (i > RenrenPullToRefreshListView.this.k) {
                    double d = currentTimeMillis - RenrenPullToRefreshListView.this.m;
                    RenrenPullToRefreshListView.this.l = absListView.getLastVisiblePosition();
                    RenrenPullToRefreshListView.this.k = i;
                    RenrenPullToRefreshListView.this.m = currentTimeMillis;
                    if (d <= 30.0d) {
                        if (RenrenPullToRefreshListView.this.l >= (adapter.getCount() < 15 ? (adapter.getCount() - i) / 2 : adapter.getCount() - 14)) {
                            RenrenPullToRefreshListView.this.i = true;
                            RenrenPullToRefreshListView.this.n.b();
                        }
                    } else if (d <= 220.0d) {
                        if (RenrenPullToRefreshListView.this.l >= (adapter.getCount() < 15 ? (adapter.getCount() - i) / 2 : adapter.getCount() - 12)) {
                            RenrenPullToRefreshListView.this.i = true;
                            RenrenPullToRefreshListView.this.n.b();
                        }
                    } else {
                        if (RenrenPullToRefreshListView.this.l >= (adapter.getCount() < 15 ? ((adapter.getCount() - i) * 2) / 3 : adapter.getCount() - 10)) {
                            RenrenPullToRefreshListView.this.i = true;
                            RenrenPullToRefreshListView.this.n.b();
                        }
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (RenrenPullToRefreshListView.this.o != null) {
                    RenrenPullToRefreshListView.this.o.onScrollStateChanged(absListView, i);
                }
                if (i == 1) {
                    RenrenPullToRefreshListView.this.m = 0L;
                }
            }
        };
        a(context);
    }

    public RenrenPullToRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = false;
        this.i = false;
        this.j = true;
        this.p = new AbsListView.OnScrollListener() { // from class: com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                ListAdapter adapter;
                if (RenrenPullToRefreshListView.this.o != null) {
                    RenrenPullToRefreshListView.this.o.onScroll(absListView, i, i2, i3);
                }
                if (!RenrenPullToRefreshListView.this.j || !RenrenPullToRefreshListView.this.h || RenrenPullToRefreshListView.this.i || RenrenPullToRefreshListView.this.n == null || (adapter = absListView.getAdapter()) == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (RenrenPullToRefreshListView.this.m == 0) {
                    RenrenPullToRefreshListView.this.m = currentTimeMillis;
                } else if (i > RenrenPullToRefreshListView.this.k) {
                    double d = currentTimeMillis - RenrenPullToRefreshListView.this.m;
                    RenrenPullToRefreshListView.this.l = absListView.getLastVisiblePosition();
                    RenrenPullToRefreshListView.this.k = i;
                    RenrenPullToRefreshListView.this.m = currentTimeMillis;
                    if (d <= 30.0d) {
                        if (RenrenPullToRefreshListView.this.l >= (adapter.getCount() < 15 ? (adapter.getCount() - i) / 2 : adapter.getCount() - 14)) {
                            RenrenPullToRefreshListView.this.i = true;
                            RenrenPullToRefreshListView.this.n.b();
                        }
                    } else if (d <= 220.0d) {
                        if (RenrenPullToRefreshListView.this.l >= (adapter.getCount() < 15 ? (adapter.getCount() - i) / 2 : adapter.getCount() - 12)) {
                            RenrenPullToRefreshListView.this.i = true;
                            RenrenPullToRefreshListView.this.n.b();
                        }
                    } else {
                        if (RenrenPullToRefreshListView.this.l >= (adapter.getCount() < 15 ? ((adapter.getCount() - i) * 2) / 3 : adapter.getCount() - 10)) {
                            RenrenPullToRefreshListView.this.i = true;
                            RenrenPullToRefreshListView.this.n.b();
                        }
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (RenrenPullToRefreshListView.this.o != null) {
                    RenrenPullToRefreshListView.this.o.onScrollStateChanged(absListView, i);
                }
                if (i == 1) {
                    RenrenPullToRefreshListView.this.m = 0L;
                }
            }
        };
        d(context, attributeSet);
    }

    public RenrenPullToRefreshListView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
        this.h = false;
        this.i = false;
        this.j = true;
        this.p = new AbsListView.OnScrollListener() { // from class: com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                ListAdapter adapter;
                if (RenrenPullToRefreshListView.this.o != null) {
                    RenrenPullToRefreshListView.this.o.onScroll(absListView, i, i2, i3);
                }
                if (!RenrenPullToRefreshListView.this.j || !RenrenPullToRefreshListView.this.h || RenrenPullToRefreshListView.this.i || RenrenPullToRefreshListView.this.n == null || (adapter = absListView.getAdapter()) == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (RenrenPullToRefreshListView.this.m == 0) {
                    RenrenPullToRefreshListView.this.m = currentTimeMillis;
                } else if (i > RenrenPullToRefreshListView.this.k) {
                    double d = currentTimeMillis - RenrenPullToRefreshListView.this.m;
                    RenrenPullToRefreshListView.this.l = absListView.getLastVisiblePosition();
                    RenrenPullToRefreshListView.this.k = i;
                    RenrenPullToRefreshListView.this.m = currentTimeMillis;
                    if (d <= 30.0d) {
                        if (RenrenPullToRefreshListView.this.l >= (adapter.getCount() < 15 ? (adapter.getCount() - i) / 2 : adapter.getCount() - 14)) {
                            RenrenPullToRefreshListView.this.i = true;
                            RenrenPullToRefreshListView.this.n.b();
                        }
                    } else if (d <= 220.0d) {
                        if (RenrenPullToRefreshListView.this.l >= (adapter.getCount() < 15 ? (adapter.getCount() - i) / 2 : adapter.getCount() - 12)) {
                            RenrenPullToRefreshListView.this.i = true;
                            RenrenPullToRefreshListView.this.n.b();
                        }
                    } else {
                        if (RenrenPullToRefreshListView.this.l >= (adapter.getCount() < 15 ? ((adapter.getCount() - i) * 2) / 3 : adapter.getCount() - 10)) {
                            RenrenPullToRefreshListView.this.i = true;
                            RenrenPullToRefreshListView.this.n.b();
                        }
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (RenrenPullToRefreshListView.this.o != null) {
                    RenrenPullToRefreshListView.this.o.onScrollStateChanged(absListView, i);
                }
                if (i == 1) {
                    RenrenPullToRefreshListView.this.m = 0L;
                }
            }
        };
        a(context);
    }

    public RenrenPullToRefreshListView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
        this.h = false;
        this.i = false;
        this.j = true;
        this.p = new AbsListView.OnScrollListener() { // from class: com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                ListAdapter adapter;
                if (RenrenPullToRefreshListView.this.o != null) {
                    RenrenPullToRefreshListView.this.o.onScroll(absListView, i, i2, i3);
                }
                if (!RenrenPullToRefreshListView.this.j || !RenrenPullToRefreshListView.this.h || RenrenPullToRefreshListView.this.i || RenrenPullToRefreshListView.this.n == null || (adapter = absListView.getAdapter()) == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (RenrenPullToRefreshListView.this.m == 0) {
                    RenrenPullToRefreshListView.this.m = currentTimeMillis;
                } else if (i > RenrenPullToRefreshListView.this.k) {
                    double d = currentTimeMillis - RenrenPullToRefreshListView.this.m;
                    RenrenPullToRefreshListView.this.l = absListView.getLastVisiblePosition();
                    RenrenPullToRefreshListView.this.k = i;
                    RenrenPullToRefreshListView.this.m = currentTimeMillis;
                    if (d <= 30.0d) {
                        if (RenrenPullToRefreshListView.this.l >= (adapter.getCount() < 15 ? (adapter.getCount() - i) / 2 : adapter.getCount() - 14)) {
                            RenrenPullToRefreshListView.this.i = true;
                            RenrenPullToRefreshListView.this.n.b();
                        }
                    } else if (d <= 220.0d) {
                        if (RenrenPullToRefreshListView.this.l >= (adapter.getCount() < 15 ? (adapter.getCount() - i) / 2 : adapter.getCount() - 12)) {
                            RenrenPullToRefreshListView.this.i = true;
                            RenrenPullToRefreshListView.this.n.b();
                        }
                    } else {
                        if (RenrenPullToRefreshListView.this.l >= (adapter.getCount() < 15 ? ((adapter.getCount() - i) * 2) / 3 : adapter.getCount() - 10)) {
                            RenrenPullToRefreshListView.this.i = true;
                            RenrenPullToRefreshListView.this.n.b();
                        }
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (RenrenPullToRefreshListView.this.o != null) {
                    RenrenPullToRefreshListView.this.o.onScrollStateChanged(absListView, i);
                }
                if (i == 1) {
                    RenrenPullToRefreshListView.this.m = 0L;
                }
            }
        };
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
        this.f10276c = inflate;
        this.d = (LinearLayout) inflate.findViewById(R.id.pulldown_footer_content);
        this.e = (ImageView) this.f10276c.findViewById(R.id.pulldown_footer_divider);
        TextView textView = (TextView) this.f10276c.findViewById(R.id.pulldown_footer_text);
        this.f = textView;
        textView.setText(PullToRefreshHelper.d());
        this.g = (ProgressBar) this.f10276c.findViewById(R.id.pulldown_footer_loading);
        this.f10276c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (RenrenPullToRefreshListView.this.i) {
                    return;
                }
                RenrenPullToRefreshListView.this.i = true;
                RenrenPullToRefreshListView.this.f.setVisibility(4);
                RenrenPullToRefreshListView.this.g.setVisibility(0);
                if (RenrenPullToRefreshListView.this.n != null) {
                    RenrenPullToRefreshListView.this.n.b();
                }
            }
        });
        if (attributeSet != null) {
            a(attributeSet);
        }
        ((ListView) getRefreshableView()).addFooterView(this.f10276c);
    }

    private void d(Context context, AttributeSet attributeSet) {
        this.b = context;
        setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        b(attributeSet);
        setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() { // from class: com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.1
            @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase.OnRefreshListener
            public void onRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                if (RenrenPullToRefreshListView.this.n != null) {
                    RenrenPullToRefreshListView.this.i = true;
                    RenrenPullToRefreshListView.this.n.a();
                }
            }
        });
        setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() { // from class: com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.2
            @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase.OnLastItemVisibleListener
            public void a() {
                if (RenrenPullToRefreshListView.this.h && !RenrenPullToRefreshListView.this.i && RenrenPullToRefreshListView.this.r()) {
                    RenrenPullToRefreshListView.this.f.setVisibility(4);
                    RenrenPullToRefreshListView.this.g.setVisibility(0);
                    if (RenrenPullToRefreshListView.this.n != null) {
                        RenrenPullToRefreshListView.this.i = true;
                        RenrenPullToRefreshListView.this.n.b();
                    }
                }
            }
        });
        super.setOnScrollListener(this.p);
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
        post(new Runnable() { // from class: com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.5
            @Override // java.lang.Runnable
            public void run() {
                RenrenPullToRefreshListView.this.i = false;
                ListView listView = (ListView) RenrenPullToRefreshListView.this.getRefreshableView();
                if (listView == null || listView.getLastVisiblePosition() < listView.getCount() - 2) {
                    RenrenPullToRefreshListView.this.f.setVisibility(4);
                    RenrenPullToRefreshListView.this.g.setVisibility(0);
                    return;
                }
                RenrenPullToRefreshListView.this.f.setVisibility(0);
                RenrenPullToRefreshListView.this.g.setVisibility(4);
            }
        });
    }

    public void setOnPullDownListener(OnPullDownListener onPullDownListener) {
        this.n = onPullDownListener;
    }

    @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshAdapterViewBase
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.o = onScrollListener;
    }

    public void setPrestrainDataMode(boolean z) {
        this.j = z;
    }

    public void setRefreshEnabled(boolean z) {
        if (z) {
            setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        } else {
            setMode(PullToRefreshBase.Mode.DISABLED);
        }
    }
}
