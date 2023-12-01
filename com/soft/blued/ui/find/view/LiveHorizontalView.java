package com.soft.blued.ui.find.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.http.parser.BluedEntity;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.find.adapter.LiveRecyclerAdapter;
import com.soft.blued.ui.find.model.NearbyLiveExtra;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.web.WebViewShowInfoFragment;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/LiveHorizontalView.class */
public class LiveHorizontalView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public Context f17012a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f17013c;
    private TextView d;
    private ImageView e;
    private RecyclerView f;
    private View g;
    private LiveRecyclerAdapter h;
    private BluedEntity<UserFindResult, NearbyLiveExtra> i;

    /* renamed from: com.soft.blued.ui.find.view.LiveHorizontalView$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/LiveHorizontalView$1.class */
    class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NearbyLiveExtra f17014a;
        final /* synthetic */ LiveHorizontalView b;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            WebViewShowInfoFragment.show(this.b.f17012a, this.f17014a.url, 0);
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/LiveHorizontalView$CustomLinearLayoutManager.class */
    public class CustomLinearLayoutManager extends LinearLayoutManager {
        public CustomLinearLayoutManager(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    public LiveHorizontalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public LiveHorizontalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public void a(Context context) {
        this.f17012a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_nearby_live, this);
        this.b = inflate;
        this.g = inflate.findViewById(2131368288);
        this.f17013c = (TextView) this.b.findViewById(R.id.tv_live_title);
        this.d = (TextView) this.b.findViewById(R.id.tv_live_count);
        this.e = (ImageView) this.b.findViewById(R.id.iv_more);
        this.f = (RecyclerView) this.b.findViewById(R.id.rv_list);
        CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(this.f17012a);
        customLinearLayoutManager.setStackFromEnd(true);
        customLinearLayoutManager.setOrientation(0);
        customLinearLayoutManager.scrollToPosition(0);
        this.f.setLayoutManager(customLinearLayoutManager);
        this.h = new LiveRecyclerAdapter(this.f17012a);
        setVisibility(8);
    }

    public RecyclerView getListView() {
        return this.f;
    }

    public BluedEntity<UserFindResult, NearbyLiveExtra> getParseData() {
        return this.i;
    }
}
