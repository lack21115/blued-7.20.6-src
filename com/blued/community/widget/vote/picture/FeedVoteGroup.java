package com.blued.community.widget.vote.picture;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.community.R;
import com.blued.community.manager.CommunityManager;
import com.blued.community.ui.feed.manager.FeedMethods;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/widget/vote/picture/FeedVoteGroup.class */
public class FeedVoteGroup extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private CardView f20486a;
    private LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private View f20487c;
    private ImageView d;
    private CardView e;
    private View f;
    private ImageView g;
    private CardView h;
    private View i;
    private ImageView j;
    private TextView k;
    private ImageView l;
    private ImageView m;
    private TextView n;
    private ImageView o;
    private TextView p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private OnViewClickListener u;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/widget/vote/picture/FeedVoteGroup$OnViewClickListener.class */
    public interface OnViewClickListener {
        void a(boolean z);

        void b(boolean z);
    }

    public FeedVoteGroup(Context context) {
        super(context);
        this.t = false;
        a();
    }

    public FeedVoteGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = false;
        a();
    }

    public FeedVoteGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.t = false;
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.feed_vote_root_layout, (ViewGroup) null, false);
        this.f20486a = (CardView) inflate.findViewById(R.id.feed_vote_root_layout);
        this.b = (LinearLayout) inflate.findViewById(R.id.feed_vote_content_layout);
        this.f20487c = inflate.findViewById(R.id.feed_vote_part_left);
        this.d = (ImageView) inflate.findViewById(R.id.feed_vote_iv_left);
        this.e = (CardView) inflate.findViewById(R.id.feed_vote_btn_left);
        this.f = inflate.findViewById(R.id.feed_vote_part_right);
        this.g = (ImageView) inflate.findViewById(R.id.feed_vote_iv_right);
        this.h = (CardView) inflate.findViewById(R.id.feed_vote_btn_right);
        View findViewById = inflate.findViewById(R.id.feed_vote_progress_layout);
        this.i = findViewById;
        findViewById.setVisibility(8);
        this.j = (ImageView) inflate.findViewById(R.id.feed_vote_select_left_iv);
        this.k = (TextView) inflate.findViewById(R.id.feed_vote_progress_left_tv);
        this.l = (ImageView) inflate.findViewById(R.id.feed_vote_progress_left_iv);
        this.m = (ImageView) inflate.findViewById(R.id.feed_vote_progress_right_iv);
        this.n = (TextView) inflate.findViewById(R.id.feed_vote_progress_right_tv);
        this.o = (ImageView) inflate.findViewById(R.id.feed_vote_select_right_iv);
        this.p = (TextView) inflate.findViewById(R.id.feed_vote_all_count_tv);
        int c2 = (AppInfo.l - FeedMethods.c(60)) / 2;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
        marginLayoutParams.height = c2;
        this.d.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.g.getLayoutParams();
        marginLayoutParams2.height = c2;
        this.g.setLayoutParams(marginLayoutParams2);
        b();
        addView(inflate);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        OnViewClickListener onViewClickListener = this.u;
        if (onViewClickListener != null) {
            onViewClickListener.a(false);
        }
    }

    private void b() {
        if (CommunityManager.f19086a.a().s()) {
            this.f20486a.setCardBackgroundColor(Color.parseColor("#1B1B1B"));
            this.e.setCardBackgroundColor(Color.parseColor("#482923"));
            this.h.setCardBackgroundColor(Color.parseColor("#22304B"));
            return;
        }
        this.f20486a.setCardBackgroundColor(Color.parseColor("#F8F8F8"));
        this.e.setCardBackgroundColor(Color.parseColor("#FFDED7"));
        this.h.setCardBackgroundColor(Color.parseColor("#D1E0FF"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        OnViewClickListener onViewClickListener = this.u;
        if (onViewClickListener != null) {
            onViewClickListener.b(false);
        }
    }

    private void c() {
        this.f20487c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.widget.vote.picture.-$$Lambda$FeedVoteGroup$ZLqHn9JwJ-2ZM9MOKG87ir1vPhc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedVoteGroup.this.d(view);
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.widget.vote.picture.-$$Lambda$FeedVoteGroup$u_e_U3OilWhPWnpZuKX66DIPxBU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedVoteGroup.this.c(view);
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.widget.vote.picture.-$$Lambda$FeedVoteGroup$cUh0-zRmkx-u8yPI3tilRlxIEWk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedVoteGroup.this.b(view);
            }
        });
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.widget.vote.picture.-$$Lambda$FeedVoteGroup$Sn9LzGqMC5TaWaP65smwWcanJlM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedVoteGroup.this.a(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        OnViewClickListener onViewClickListener = this.u;
        if (onViewClickListener != null) {
            onViewClickListener.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        OnViewClickListener onViewClickListener = this.u;
        if (onViewClickListener != null) {
            onViewClickListener.b(true);
        }
    }

    public void a(int i, int i2, int i3, boolean z) {
        this.q = i;
        this.t = z;
        if (i == 0 || z) {
            this.e.setVisibility(0);
            this.h.setVisibility(0);
            this.i.setVisibility(8);
        } else {
            this.e.setVisibility(8);
            this.h.setVisibility(8);
            int i4 = (int) (((i2 / i3) * 100.0f) + 0.5f);
            this.r = i4;
            this.s = 100 - i4;
            this.i.setVisibility(0);
            if (this.q == 1) {
                this.j.setVisibility(0);
                this.o.setVisibility(8);
            } else {
                this.j.setVisibility(8);
                this.o.setVisibility(0);
            }
            TextView textView = this.k;
            textView.setText(this.r + "%");
            TextView textView2 = this.n;
            textView2.setText(this.s + "%");
            this.l.setVisibility(0);
            this.m.setVisibility(0);
            boolean s = CommunityManager.f19086a.a().s();
            if (this.r == 0) {
                this.l.setVisibility(8);
                if (s) {
                    this.m.setImageResource(R.drawable.feed_vote_progress_all_right_dark);
                } else {
                    this.m.setImageResource(R.drawable.feed_vote_progress_all_right);
                }
            } else if (this.s == 0) {
                this.m.setVisibility(8);
                if (s) {
                    this.l.setImageResource(R.drawable.feed_vote_progress_all_left_dark);
                } else {
                    this.l.setImageResource(R.drawable.feed_vote_progress_all_left);
                }
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.l.getLayoutParams();
                layoutParams.weight = Math.max(this.r, 10);
                this.l.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams2.weight = Math.max(this.s, 5);
                this.m.setLayoutParams(layoutParams2);
                if (s) {
                    this.l.setImageResource(R.drawable.feed_vote_progress_left_dark);
                    this.m.setImageResource(R.drawable.feed_vote_progress_right_dark);
                } else {
                    this.l.setImageResource(R.drawable.feed_vote_progress_left);
                    this.m.setImageResource(R.drawable.feed_vote_progress_right);
                }
            }
        }
        TextView textView3 = this.p;
        textView3.setText(getContext().getString(R.string.feed_votes) + i3);
        int c2 = this.t ? 0 : FeedMethods.c(12);
        this.b.setPadding(c2, c2, c2, c2);
        b();
    }

    public void a(IRequestHost iRequestHost, String str, String str2) {
        ImageLoader.a(iRequestHost, str).a(7.0f).a(this.d);
        ImageLoader.a(iRequestHost, str2).a(7.0f).a(this.g);
    }

    public void setOnViewClickListener(OnViewClickListener onViewClickListener) {
        this.u = onViewClickListener;
    }
}
