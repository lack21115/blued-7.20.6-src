package com.blued.community.ui.send.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.db.NewFeedDao;
import com.blued.android.module.common.db.model.NewFeedModel;
import com.blued.community.R;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.send.fragment.CircleAddPostFragment;
import com.blued.community.ui.send.fragment.EventScoreAddPostFragment;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.send.manager.FeedSendManager;
import com.blued.community.ui.send.observer.FeedRefreshObserver;
import com.blued.community.utils.StringUtils;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/adapter/FeedSendRecyclerAdapter.class */
public class FeedSendRecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f19901a;
    private IRequestHost b;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/adapter/FeedSendRecyclerAdapter$ViewHolder.class */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public CardView f19906a;
        public ViewGroup b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f19907c;
        public View d;
        public TextView e;
        public TextView f;
        public TextView g;
        public ProgressBar h;
        public View i;
        public View j;
        public LinearLayout k;
        public LinearLayout l;
        public View m;

        public ViewHolder(View view) {
            super(view);
            this.f19906a = (CardView) view.findViewById(R.id.feed_send_item_card_view);
            this.b = (ViewGroup) view.findViewById(R.id.feed_send_item_img_layout);
            this.f19907c = (ImageView) view.findViewById(R.id.header_view);
            this.d = view.findViewById(R.id.feed_send_item_fail);
            this.e = (TextView) view.findViewById(R.id.content_view);
            this.f = (TextView) view.findViewById(R.id.send_state);
            this.h = (ProgressBar) view.findViewById(R.id.progressBar);
            this.i = view.findViewById(R.id.send_btn);
            this.g = (TextView) view.findViewById(R.id.again_edit);
            this.j = view.findViewById(R.id.del_btn);
            this.k = (LinearLayout) view.findViewById(R.id.btn_layout);
            this.l = (LinearLayout) view.findViewById(R.id.content_layout);
            this.m = view.findViewById(R.id.tv_btm_line);
        }
    }

    public FeedSendRecyclerAdapter(Context context, IRequestHost iRequestHost) {
        this.f19901a = context;
        this.b = iRequestHost;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_feed_send_item, viewGroup, false));
    }

    public void a(NewFeedModel newFeedModel) {
        if (newFeedModel.getState() == 0) {
            if (CircleMethods.a(newFeedModel)) {
                CircleAddPostFragment.a(this.f19901a, newFeedModel);
            } else if (newFeedModel.is_evaluate_activity == 1) {
                EventScoreAddPostFragment.b.a(this.f19901a, newFeedModel);
            } else {
                FeedAddPostFragment.a(this.f19901a, newFeedModel);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final NewFeedModel newFeedModel = FeedSendManager.a().d().get(i);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewHolder.m.getLayoutParams();
        if (i == FeedSendManager.a().d().size() - 1) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = DensityUtils.a(this.f19901a, 13.0f);
        }
        viewHolder.m.setLayoutParams(layoutParams);
        if (newFeedModel.is_repost == 1) {
            viewHolder.b.setVisibility(0);
            viewHolder.e.setVisibility(8);
            ImageLoader.a(this.b, newFeedModel.forwardImage).a(viewHolder.f19907c);
        } else if (!TextUtils.isEmpty(newFeedModel.getPics()) || newFeedModel.isVideo == 1) {
            viewHolder.b.setVisibility(0);
            viewHolder.e.setVisibility(8);
            ImageLoader.d(this.b, newFeedModel.localPath).a(viewHolder.f19907c);
        } else {
            viewHolder.b.setVisibility(8);
            viewHolder.e.setVisibility(0);
            viewHolder.e.setText(((Object) StringUtils.a(newFeedModel.getContent(), false, true, false, "")) + "");
        }
        if (BluedSkinUtils.c()) {
            viewHolder.f19906a.setCardBackgroundColor(Color.parseColor("#ECEDF0"));
            viewHolder.h.setProgressDrawable(this.f19901a.getResources().getDrawable(R.drawable.progress_bar_send_feed));
        } else {
            viewHolder.f19906a.setCardBackgroundColor(Color.parseColor("#282828"));
            viewHolder.h.setProgressDrawable(this.f19901a.getResources().getDrawable(R.drawable.progress_bar_send_feed_dark));
        }
        int state = newFeedModel.getState();
        if (state == 0) {
            viewHolder.h.setVisibility(8);
            viewHolder.k.setVisibility(0);
            viewHolder.f.setText(this.f19901a.getResources().getString(R.string.send_failed));
            viewHolder.g.setVisibility(0);
            viewHolder.d.setVisibility(0);
        } else if (state != 1) {
            viewHolder.d.setVisibility(8);
            viewHolder.h.setVisibility(8);
            viewHolder.k.setVisibility(0);
            viewHolder.f.setText(this.f19901a.getResources().getString(R.string.send_failed));
            viewHolder.g.setVisibility(0);
        } else {
            viewHolder.d.setVisibility(8);
            if (newFeedModel.isResend) {
                viewHolder.h.setVisibility(0);
            } else {
                viewHolder.h.setVisibility(8);
            }
            viewHolder.k.setVisibility(8);
            viewHolder.f.setText(this.f19901a.getResources().getString(R.string.send_ing));
            viewHolder.f.setTextColor(BluedSkinUtils.a(this.f19901a, R.color.syc_h));
            viewHolder.g.setVisibility(8);
        }
        viewHolder.h.setProgress(newFeedModel.getProgress());
        viewHolder.i.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.adapter.FeedSendRecyclerAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FeedSendManager.a().b(newFeedModel);
                FeedSendRecyclerAdapter.this.notifyDataSetChanged();
            }
        });
        viewHolder.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.adapter.FeedSendRecyclerAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                NewFeedDao.a().d(newFeedModel);
                FeedSendManager.a().c(newFeedModel);
                FeedSendRecyclerAdapter.this.notifyDataSetChanged();
                FeedRefreshObserver.a().a(null, 4);
            }
        });
        viewHolder.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.adapter.FeedSendRecyclerAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FeedSendRecyclerAdapter.this.a(newFeedModel);
            }
        });
        viewHolder.l.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.adapter.FeedSendRecyclerAdapter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FeedSendRecyclerAdapter.this.a(newFeedModel);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return FeedSendManager.a().e();
    }
}
