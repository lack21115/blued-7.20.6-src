package com.blued.community.widget.vote.text.adapter;

import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.community.R;
import com.blued.community.manager.CommunityManager;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.widget.vote.text.model.CircleTextVote;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/widget/vote/text/adapter/CircleTextVoteViewAdapter.class */
public class CircleTextVoteViewAdapter extends BaseQuickAdapter<CircleTextVote, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private int f6888a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6889c;
    private boolean d;
    private int e;

    public CircleTextVoteViewAdapter() {
        super(R.layout.view_item_circle_text_vote);
        this.f6888a = 0;
        this.b = false;
        this.f6889c = false;
        this.d = false;
        this.e = 0;
        this.d = CommunityManager.a.a().s();
        this.e = AppInfo.l - FeedMethods.c(48);
    }

    private void a(ShapeTextView shapeTextView, int i) {
        if (i <= 0) {
            ViewGroup.LayoutParams layoutParams = shapeTextView.getLayoutParams();
            layoutParams.width = 0;
            shapeTextView.setLayoutParams(layoutParams);
            return;
        }
        int a2 = DensityUtils.a(this.mContext, 8);
        int i2 = this.f6888a;
        if (i == i2) {
            ViewGroup.LayoutParams layoutParams2 = shapeTextView.getLayoutParams();
            layoutParams2.width = this.e;
            shapeTextView.setLayoutParams(layoutParams2);
            ShapeHelper.a(shapeTextView, a2);
            return;
        }
        int i3 = (int) ((this.e - (a2 * 2)) * (i / i2));
        ViewGroup.LayoutParams layoutParams3 = shapeTextView.getLayoutParams();
        layoutParams3.width = i3 + a2;
        shapeTextView.setLayoutParams(layoutParams3);
        float f = a2;
        ShapeHelper.a(shapeTextView, f, 0.0f, f, 0.0f);
    }

    public void a(int i) {
        this.f6888a = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, CircleTextVote circleTextVote) {
        if (baseViewHolder == null || circleTextVote == null) {
            return;
        }
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_option);
        textView.setText(circleTextVote.option);
        if (this.d) {
            textView.setTextColor(Color.parseColor("#E0E0E0"));
        } else {
            textView.setTextColor(Color.parseColor("#1E1F23"));
        }
        if (circleTextVote.select) {
            baseViewHolder.setGone(R.id.iv_ok, true);
        } else {
            baseViewHolder.setGone(R.id.iv_ok, false);
        }
        if (this.b) {
            baseViewHolder.setText(R.id.tv_num, String.valueOf(circleTextVote.count));
            baseViewHolder.setGone(R.id.tv_num, true);
        } else {
            baseViewHolder.setGone(R.id.tv_num, false);
        }
        ShapeTextView view = baseViewHolder.getView(R.id.stv_select_option);
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.stv_vote_option);
        LogUtils.c("text:" + circleTextVote.option + ", isVoted:" + this.b + ", select:" + circleTextVote.select + ", num:" + circleTextVote.count);
        if (!this.b) {
            shapeTextView.setVisibility(8);
            view.setEnabled(true);
            return;
        }
        ShapeModel shapeModel = shapeTextView.getShapeModel();
        ShapeModel shapeModel2 = shapeModel;
        if (shapeModel == null) {
            shapeModel2 = new ShapeModel();
        }
        if (circleTextVote.select) {
            shapeModel2.k = Color.parseColor("#332B72FF");
        } else if (circleTextVote.count <= 0) {
            shapeModel2.k = Color.parseColor("#00000000");
        } else if (this.d) {
            shapeModel2.k = Color.parseColor("#2C2C2C");
        } else {
            shapeModel2.k = Color.parseColor("#E5E5E5");
        }
        shapeTextView.setShapeModel(shapeModel2);
        a(shapeTextView, circleTextVote.count);
        shapeTextView.setVisibility(0);
        view.setEnabled(false);
    }

    public void a(boolean z) {
        this.b = z;
        notifyDataSetChanged();
    }

    public boolean a() {
        return this.b;
    }

    public void b(boolean z) {
        this.f6889c = z;
    }
}
