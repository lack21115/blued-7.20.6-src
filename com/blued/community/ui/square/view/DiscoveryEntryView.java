package com.blued.community.ui.square.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.fragment.CircleNewFragment;
import com.blued.community.ui.square.fragment.HotFeedFragment;
import com.blued.community.ui.square.fragment.ImageFeedFragment;
import com.blued.community.ui.square.model.DiscoverSquareExtra;
import com.blued.community.ui.topic.fragment.SuperTopicFragment;
import com.blued.community.ui.video.fragment.ShineVideoListFragment;
import com.blued.community.utils.CommRouteUtil;
import com.blued.community.utils.CommunityPreferences;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/view/DiscoveryEntryView.class */
public class DiscoveryEntryView extends LinearLayout implements View.OnClickListener {
    private ImageView a;
    private ImageView b;
    private TextView c;
    private DiscoverSquareExtra.Explore d;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/view/DiscoveryEntryView$Entry.class */
    public @interface Entry {
    }

    public DiscoveryEntryView(Context context, AttributeSet attributeSet, int i, IRequestHost iRequestHost) {
        super(context, attributeSet, i);
        LayoutInflater.from(getContext()).inflate(R.layout.view_discovery_entry, (ViewGroup) this, true);
        this.a = (ImageView) findViewById(R.id.discovery_entry_iv);
        this.c = (TextView) findViewById(R.id.discovery_entry_name);
        this.b = (ImageView) findViewById(R.id.discovery_entry_corner_iv);
        setOnClickListener(new SingleClickProxy(this));
    }

    public DiscoveryEntryView(Context context, AttributeSet attributeSet, IRequestHost iRequestHost) {
        this(context, attributeSet, 0, iRequestHost);
    }

    public DiscoveryEntryView(Context context, IRequestHost iRequestHost) {
        this(context, null, iRequestHost);
    }

    private void setCornerImg(IRequestHost iRequestHost) {
        if (TextUtils.isEmpty(this.d.getCornerImg())) {
            this.b.setVisibility(8);
            return;
        }
        this.b.setVisibility(0);
        ImageLoader.a(iRequestHost, this.d.getCornerImg()).e(getId()).g(this.d.loop > 0 ? this.d.loop : -1).a(this.b);
    }

    private void setIcon(IRequestHost iRequestHost) {
        int i = this.d.index;
        ImageLoader.a(iRequestHost, this.d.png).d(i != 1 ? i != 2 ? i != 4 ? i != 5 ? i != 6 ? i != 7 ? R.drawable.discovery_entry_default : R.drawable.discovery_entry_hot : R.drawable.discovery_entry_chat_room : R.drawable.discovery_entry_image : R.drawable.discovery_entry_scan : CommunityServiceManager.a().D() == 1 ? R.drawable.discovery_entry_subject : R.drawable.discovery_entry_topic : R.drawable.discovery_entry_circle).a(this.a);
    }

    public void a(final IRequestHost iRequestHost) {
        post(new Runnable() { // from class: com.blued.community.ui.square.view.DiscoveryEntryView.1
            @Override // java.lang.Runnable
            public void run() {
                DiscoveryEntryView discoveryEntryView = DiscoveryEntryView.this;
                discoveryEntryView.a(discoveryEntryView.d, iRequestHost);
            }
        });
    }

    public void a(DiscoverSquareExtra.Explore explore, IRequestHost iRequestHost) {
        if (explore == null || explore.index <= 0) {
            setVisibility(8);
            return;
        }
        this.d = explore;
        setId(explore.index);
        setVisibility(0);
        if ("en".equals(BlueAppLocal.a())) {
            this.c.setTextSize(11.0f);
        } else {
            this.c.setTextSize(13.0f);
        }
        String name = explore.getName();
        if (TextUtils.isEmpty(name)) {
            this.c.setVisibility(8);
        } else {
            this.c.setText(name);
            this.c.setVisibility(0);
        }
        setIcon(iRequestHost);
        setCornerImg(iRequestHost);
        EventTrackFeed.a(FeedProtos.Event.FIND_RECOMMEND_GUIDE_BTN_SHOW, explore.index, explore.url, "png", this.c.getText().toString());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int i = this.d.index;
        if (i == 1) {
            CircleNewFragment.a(getContext());
        } else if (i != 2) {
            if (i == 4) {
                ShineVideoListFragment.a(getContext());
            } else if (i == 5) {
                ImageFeedFragment.a(getContext());
            } else if (i == 6) {
                CommunityServiceManager.b().c(getContext(), "plaza_top_yy");
            } else if (i != 7) {
                CommunityServiceManager.b().a(getContext(), this.d.url);
            } else {
                HotFeedFragment.a.a(getContext());
            }
        } else if (CommunityServiceManager.a().D() == 1) {
            CommRouteUtil.b(getContext());
        } else {
            SuperTopicFragment.a(getContext());
        }
        EventTrackFeed.a(FeedProtos.Event.FIND_RECOMMEND_GUIDE_BTN_CLICK, this.d.index, this.d.url, "png", this.c.getText().toString());
        if (!"apng".equalsIgnoreCase(this.d.getCornerType()) || CommunityPreferences.w(this.d.getApngSpCountStr()) < 2) {
            return;
        }
        this.d.resetCornerImg();
        setCornerImg(null);
    }
}
