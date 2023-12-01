package com.soft.blued.ui.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.live.adapter.PKLiveRecyclerAdapter;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/view/PKLiveHorizontalView.class */
public class PKLiveHorizontalView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public Context f31314a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f31315c;
    private RecyclerView d;
    private PKLiveRecyclerAdapter e;
    private TextView f;
    private ImageView g;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/view/PKLiveHorizontalView$CustomLinearLayoutManager.class */
    public class CustomLinearLayoutManager extends LinearLayoutManager {
        public CustomLinearLayoutManager(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    public PKLiveHorizontalView(Context context) {
        this(context, null);
    }

    public PKLiveHorizontalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PKLiveHorizontalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public void a(Context context) {
        this.f31314a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_pk_live, this);
        this.b = inflate;
        this.f31315c = (TextView) inflate.findViewById(R.id.tv_live_title);
        this.f = (TextView) this.b.findViewById(R.id.tv_live_more);
        this.g = (ImageView) this.b.findViewById(R.id.iv_live_more);
        this.d = (RecyclerView) this.b.findViewById(2131369529);
        CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(this.f31314a);
        customLinearLayoutManager.setStackFromEnd(true);
        customLinearLayoutManager.setOrientation(0);
        customLinearLayoutManager.scrollToPosition(0);
        this.d.setLayoutManager(customLinearLayoutManager);
        this.e = new PKLiveRecyclerAdapter(this.f31314a);
        setVisibility(8);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.view.PKLiveHorizontalView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                WebViewShowInfoFragment.a(AppInfo.d(), H5Url.a(5), PKLiveHorizontalView.this.f31314a.getString(2131889950), 0);
            }
        });
    }

    public void a(IRequestHost iRequestHost, List<BluedLiveListData> list, BluedLiveListData bluedLiveListData, boolean z) {
        if (bluedLiveListData.hotpk_list != null) {
            setVisibility(0);
            this.e.a(iRequestHost, list);
            this.e.setNewData(bluedLiveListData.hotpk_list);
            this.d.setAdapter(this.e);
            this.e.notifyDataSetChanged();
        } else {
            setVisibility(8);
        }
        if (!z) {
            this.f.setVisibility(8);
            this.g.setVisibility(8);
            return;
        }
        this.f.setVisibility(0);
        this.g.setVisibility(0);
        InstantLog.a("live_list_pk_more_show");
    }

    public RecyclerView getListView() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
