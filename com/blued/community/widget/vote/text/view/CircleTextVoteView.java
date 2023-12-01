package com.blued.community.widget.vote.text.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.community.R;
import com.blued.community.widget.vote.text.adapter.CircleTextVoteViewAdapter;
import com.blued.community.widget.vote.text.model.CircleTextVote;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/widget/vote/text/view/CircleTextVoteView.class */
public class CircleTextVoteView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f6890a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f6891c;
    private TextView d;
    private ShapeTextView e;
    private CircleTextVoteViewAdapter f;
    private OnVoteListener g;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/widget/vote/text/view/CircleTextVoteView$OnVoteListener.class */
    public interface OnVoteListener {
        void a(CircleTextVote circleTextVote, int i);
    }

    public CircleTextVoteView(Context context) {
        this(context, null);
    }

    public CircleTextVoteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleTextVoteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_circle_text_vote, this);
        this.f6890a = inflate;
        this.b = (TextView) inflate.findViewById(R.id.tv_title);
        this.f6891c = (RecyclerView) this.f6890a.findViewById(R.id.recycler_view);
        this.d = (TextView) this.f6890a.findViewById(R.id.tv_count);
        this.e = this.f6890a.findViewById(R.id.stv_vote_ok);
        this.f6891c.setLayoutManager(new LinearLayoutManager(context) { // from class: com.blued.community.widget.vote.text.view.CircleTextVoteView.1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        });
        CircleTextVoteViewAdapter circleTextVoteViewAdapter = new CircleTextVoteViewAdapter();
        this.f = circleTextVoteViewAdapter;
        this.f6891c.setAdapter(circleTextVoteViewAdapter);
    }

    public void a(final int i, int i2) {
        this.f.a(i);
        this.d.setText(i + getContext().getString(R.string.circle_text_vote_count));
        this.d.setVisibility(0);
        if (i2 > 0) {
            this.e.setText(R.string.circle_text_vote_voted);
            if (this.f.getData().size() >= i2) {
                this.f.getData().get(i2 - 1).select = true;
            }
            this.f.a(true);
        } else {
            this.e.setText(R.string.circle_text_vote_select);
            this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.widget.vote.text.view.CircleTextVoteView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    AppMethods.d(R.string.circle_text_vote_select_tip);
                }
            });
            this.f.b(true);
            this.f.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.community.widget.vote.text.view.CircleTextVoteView.3
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
                public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, final int i3) {
                    if (CircleTextVoteView.this.f.a()) {
                        return;
                    }
                    for (CircleTextVote circleTextVote : CircleTextVoteView.this.f.getData()) {
                        circleTextVote.select = false;
                    }
                    final CircleTextVote circleTextVote2 = CircleTextVoteView.this.f.getData().get(i3);
                    circleTextVote2.select = true;
                    CircleTextVoteView.this.f.notifyDataSetChanged();
                    CircleTextVoteView.this.e.setAlpha(1.0f);
                    CircleTextVoteView.this.e.setText(R.string.circle_text_vote_ok);
                    CircleTextVoteView.this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.widget.vote.text.view.CircleTextVoteView.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            Tracker.onClick(view2);
                            if (CircleTextVoteView.this.g != null) {
                                CircleTextVoteView.this.e.setOnClickListener((View.OnClickListener) null);
                                CircleTextVoteView.this.e.setEnabled(false);
                                CircleTextVoteView.this.e.setAlpha(0.3f);
                                CircleTextVoteView.this.e.setText(R.string.circle_text_vote_voted);
                                CircleTextVoteView.this.g.a(circleTextVote2, i3);
                                int i4 = i + 1;
                                CircleTextVoteView.this.d.setText(i4 + CircleTextVoteView.this.getContext().getString(R.string.circle_text_vote_count));
                                CircleTextVoteView.this.f.a(i4);
                                CircleTextVote circleTextVote3 = circleTextVote2;
                                circleTextVote3.count = circleTextVote3.count + 1;
                                CircleTextVoteView.this.f.b(false);
                                CircleTextVoteView.this.f.a(true);
                            }
                        }
                    });
                }
            });
        }
        this.e.setAlpha(0.3f);
        this.e.setVisibility(0);
    }

    public void setOnVoteListener(OnVoteListener onVoteListener) {
        this.g = onVoteListener;
    }

    public void setOptionList(List<CircleTextVote> list) {
        this.f.setNewData(list);
    }

    public void setOptionTitle(String str) {
        this.b.setText(str);
    }
}
