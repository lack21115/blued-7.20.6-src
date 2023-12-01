package com.blued.community.ui.feed.adapter;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.feed.fragment.FeedDetailsFragment;

/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedDetailsPhotoAdapter.class */
public class FeedDetailsPhotoAdapter extends BaseAdapter {
    private Context a;
    private IRequestHost b;
    private BluedIngSelfFeed c;
    private LoadOptions d;
    private View e;
    private String f;
    private FeedDetailsFragment g;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/adapter/FeedDetailsPhotoAdapter$ViewHolder.class */
    class ViewHolder {
        ImageView a;
        ShapeTextView b;

        private ViewHolder() {
        }
    }

    public FeedDetailsPhotoAdapter(FeedDetailsFragment feedDetailsFragment, IRequestHost iRequestHost, BluedIngSelfFeed bluedIngSelfFeed, LoadOptions loadOptions, View view, String str) {
        this.a = feedDetailsFragment.getContext();
        this.g = feedDetailsFragment;
        this.b = iRequestHost;
        this.c = bluedIngSelfFeed;
        this.d = loadOptions;
        this.e = view;
        this.f = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.c.feed_pics.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0190  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View getView(final int r7, android.view.View r8, android.view.ViewGroup r9) {
        /*
            Method dump skipped, instructions count: 427
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.community.ui.feed.adapter.FeedDetailsPhotoAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
