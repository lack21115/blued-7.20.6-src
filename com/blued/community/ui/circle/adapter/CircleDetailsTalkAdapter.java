package com.blued.community.ui.circle.adapter;

import android.content.Context;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.community.R;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseViewHolder;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/adapter/CircleDetailsTalkAdapter.class */
public class CircleDetailsTalkAdapter extends CircleTalkAdapter {
    private int e;

    public CircleDetailsTalkAdapter(Context context, IRequestHost iRequestHost) {
        super(context, iRequestHost);
        this.e = 0;
    }

    public void a(int i) {
        this.e = i;
    }

    @Override // com.blued.community.ui.circle.adapter.CircleTalkAdapter
    protected void a(BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed.isShowUrlVisited) {
            return;
        }
        FeedProtos.NoteSource noteSource = FeedProtos.NoteSource.UNKNOWN_NOTE_SOURCE;
        int i = this.e;
        if (i == 0) {
            noteSource = FeedProtos.NoteSource.CIRCLE_NEW;
        } else if (i == 1) {
            noteSource = FeedProtos.NoteSource.CIRCLE_HOT;
        } else if (i == 2) {
            noteSource = FeedProtos.NoteSource.CIRCLE_ESSENCE;
        }
        EventTrackFeed.b(FeedProtos.Event.CIRCLE_NOTE_DRAW, bluedIngSelfFeed, noteSource);
        bluedIngSelfFeed.isShowUrlVisited = true;
    }

    @Override // com.blued.community.ui.circle.adapter.CircleTalkAdapter
    protected void a(BaseViewHolder baseViewHolder) {
        baseViewHolder.addOnClickListener(R.id.new_base_header);
        baseViewHolder.addOnClickListener(R.id.new_base_name);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.community.ui.circle.adapter.CircleTalkAdapter
    public void a(BaseViewHolder baseViewHolder, BluedIngSelfFeed bluedIngSelfFeed) {
        if (baseViewHolder != null) {
            super.a(baseViewHolder, bluedIngSelfFeed);
            ImageLoader.a(this.b, bluedIngSelfFeed.user_avatar).b(R.drawable.user_bg_round).c().a((ImageView) baseViewHolder.getView(R.id.new_base_header));
            int i = R.id.iv_anonymous;
            boolean z = true;
            if (bluedIngSelfFeed.is_anonym != 1) {
                z = false;
            }
            baseViewHolder.setGone(i, z);
            baseViewHolder.setText(R.id.new_base_name, bluedIngSelfFeed.user_name);
            b(baseViewHolder);
        }
    }
}
