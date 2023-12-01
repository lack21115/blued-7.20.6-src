package com.blued.community.ui.send.view;

import android.content.Context;
import android.media.MediaMetadataEditor;
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

    /* renamed from: a  reason: collision with root package name */
    private Context f20087a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayoutManager f20088c;
    private FeedSendRecyclerAdapter d;
    private SkinCompatBackgroundHelper e;

    public FeedSendRecyclerView(Context context) {
        super(context);
        this.f20087a = context;
        d();
    }

    public FeedSendRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20087a = context;
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.e = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, 0);
        d();
    }

    private void d() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f20087a);
        this.f20088c = linearLayoutManager;
        setLayoutManager(linearLayoutManager);
        setHasFixedSize(true);
        setItemAnimator(new DefaultItemAnimator());
        FeedSendRecyclerAdapter feedSendRecyclerAdapter = new FeedSendRecyclerAdapter(this.f20087a, this.b);
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

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(MediaMetadataEditor.KEY_EDITABLE_MASK, Integer.MIN_VALUE));
    }

    @Override // android.view.View
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
