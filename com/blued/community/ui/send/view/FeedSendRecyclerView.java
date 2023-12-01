package com.blued.community.ui.send.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.community.ui.send.adapter.FeedSendRecyclerAdapter;
import com.blued.community.ui.send.observer.FeedRefreshObserver;
import skin.support.widget.SkinCompatBackgroundHelper;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/view/FeedSendRecyclerView.class */
public class FeedSendRecyclerView extends RecyclerView implements BluedSkinSupportable, FeedRefreshObserver.IFeedRefreshObserver {
    private Context a;
    private IRequestHost b;
    private LinearLayoutManager c;
    private FeedSendRecyclerAdapter d;
    private SkinCompatBackgroundHelper e;

    public FeedSendRecyclerView(Context context) {
        super(context);
        this.a = context;
        d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeedSendRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.e = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, 0);
        d();
    }

    private void d() {
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this.a);
        this.c = linearLayoutManager;
        setLayoutManager(linearLayoutManager);
        setHasFixedSize(true);
        setItemAnimator(new DefaultItemAnimator());
        FeedSendRecyclerAdapter feedSendRecyclerAdapter = new FeedSendRecyclerAdapter(this.a, this.b);
        this.d = feedSendRecyclerAdapter;
        setAdapter(feedSendRecyclerAdapter);
    }

    public void a() {
        FeedSendRecyclerAdapter feedSendRecyclerAdapter = this.d;
        if (feedSendRecyclerAdapter != null) {
            feedSendRecyclerAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.blued.community.ui.send.observer.FeedRefreshObserver.IFeedRefreshObserver
    public void a(Object obj, int i) {
        if (i == 0) {
            a();
        } else if (i == 1) {
            a();
        } else if (i == 2) {
            a();
        } else if (i == 3) {
            a();
        } else if (i != 4) {
        } else {
            a();
        }
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.e;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
    }

    public void b() {
        FeedRefreshObserver.a().a(this);
    }

    public void c() {
        FeedRefreshObserver.a().b(this);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.e;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }

    public void setRequestHost(IRequestHost iRequestHost) {
        this.b = iRequestHost;
    }
}
