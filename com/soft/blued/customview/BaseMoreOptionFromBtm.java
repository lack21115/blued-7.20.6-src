package com.soft.blued.customview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.module_share_china.R;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.share_custom.Model.BaseShareEntity;
import com.soft.blued.ui.share_custom.Model.ShareOption;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/BaseMoreOptionFromBtm.class */
public abstract class BaseMoreOptionFromBtm {

    /* renamed from: a  reason: collision with root package name */
    private ShareOptionRecyclerAdapter f28356a;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    protected BaseShareEntity f28357c;
    protected String d = "";
    public boolean e;
    public boolean f;
    public boolean g;
    private ShareOptionRecyclerAdapter h;
    private List<ShareOption> i;
    private List<ShareOption> j;
    private View k;
    private PopMenuFromBottom l;
    private TextView m;

    public BaseMoreOptionFromBtm(Context context, boolean z, boolean z2, boolean z3, final View.OnClickListener onClickListener) {
        this.e = false;
        this.f = false;
        this.g = false;
        this.b = context;
        this.e = z;
        this.f = z2;
        this.g = z3;
        ArrayList arrayList = new ArrayList();
        this.i = arrayList;
        arrayList.add(new ShareOption(R.drawable.icon_share_to_people, R.string.share_to_friends));
        this.i.add(new ShareOption(R.drawable.icon_share_to_feed, R.string.common_main_feed));
        this.i.add(new ShareOption(R.drawable.icon_share_to_wechat, R.string.ssdk_wechat));
        this.i.add(new ShareOption(R.drawable.icon_share_to_wechat_moment, R.string.ssdk_wechatmoments));
        this.i.add(new ShareOption(R.drawable.icon_share_to_qq, R.string.ssdk_qq));
        this.i.add(new ShareOption(R.drawable.icon_share_to_sina_weibo, R.string.ssdk_sinaweibo));
        this.j = new ArrayList();
        List<ShareOption> a2 = a();
        if (a2 != null && a2.size() > 0) {
            this.j.addAll(a2);
        }
        this.f28356a = new ShareOptionRecyclerAdapter(context, this.i, false);
        this.h = new ShareOptionRecyclerAdapter(context, this.j, false);
        View inflate = LayoutInflater.from(context).inflate(R.layout.more_options_common_layout, (ViewGroup) null);
        this.k = inflate;
        this.m = (TextView) inflate.findViewById(R.id.tv_cancel);
        RecyclerView recyclerView = (RecyclerView) this.k.findViewById(R.id.lv_share_options);
        RecyclerView recyclerView2 = (RecyclerView) this.k.findViewById(R.id.lv_other_options);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setOrientation(0);
        linearLayoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(this.f28356a);
        this.f28356a.notifyDataSetChanged();
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(context);
        linearLayoutManager2.setStackFromEnd(true);
        linearLayoutManager2.setOrientation(0);
        linearLayoutManager2.scrollToPosition(0);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setAdapter(this.h);
        this.h.notifyDataSetChanged();
        ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener = new ShareOptionRecyclerAdapter.ShareOptionsItemClickListener() { // from class: com.soft.blued.customview.BaseMoreOptionFromBtm.1
            @Override // com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter.ShareOptionsItemClickListener
            public void onItemClick(int i) {
                BaseMoreOptionFromBtm.this.a(i);
            }
        };
        this.f28356a.a(shareOptionsItemClickListener);
        this.h.a(shareOptionsItemClickListener);
        this.l = new PopMenuFromBottom(context, this.k);
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.BaseMoreOptionFromBtm.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                View.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
                BaseMoreOptionFromBtm.this.l.d();
            }
        });
    }

    public abstract List<ShareOption> a();

    public void a(int i) {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.customview.BaseMoreOptionFromBtm.3
            @Override // java.lang.Runnable
            public void run() {
                BaseMoreOptionFromBtm.this.l.d();
            }
        }, 300L);
    }

    public void a(BaseShareEntity baseShareEntity) {
        this.f28357c = baseShareEntity;
        a(this.i, this.j);
        this.f28356a.notifyDataSetChanged();
        this.h.notifyDataSetChanged();
        this.l.e();
    }

    public abstract void a(List<ShareOption> list, List<ShareOption> list2);
}
