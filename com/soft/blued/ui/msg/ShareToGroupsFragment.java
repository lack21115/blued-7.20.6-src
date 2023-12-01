package com.soft.blued.ui.msg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.app.share.ShareUtils;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.model.BluedCreatedGroupInfo;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.ui.group.model.BluedMyGroupLists;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ShareToGroupsFragment.class */
public class ShareToGroupsFragment extends PreloadFragment {
    private Context j;
    private ShareToMsgEntity k;
    private GroupListAdapter l;
    private NoDataAndLoadFailView m;
    private ProgressBar n;
    private RecyclerView o;
    private PullToRefreshRecyclerView p;
    private List<BluedGroupLists> q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ShareToGroupsFragment$GroupListAdapter.class */
    public class GroupListAdapter extends BaseQuickAdapter<BluedGroupLists, BaseViewHolder> {
        private TextView b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f18245c;

        private GroupListAdapter() {
            super(R.layout.item_share_to, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, BluedGroupLists bluedGroupLists) {
            if (baseViewHolder == null || bluedGroupLists == null) {
                return;
            }
            this.b = (TextView) baseViewHolder.getView(2131372046);
            this.f18245c = (ImageView) baseViewHolder.getView(R.id.riv_avatar);
            if (TextUtils.isEmpty(bluedGroupLists.groups_name)) {
                this.b.setVisibility(4);
            } else {
                this.b.setText(bluedGroupLists.groups_name);
            }
            ImageLoader.a(ShareToGroupsFragment.this.getFragmentActive(), bluedGroupLists.groups_avatar).b(2131237310).c().a(this.f18245c);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ShareToGroupsFragment$SectionDecoration.class */
    class SectionDecoration extends RecyclerView.ItemDecoration {
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f18247c;
        private int d;
        private int e;
        private final int h = 2131101196;
        private final int i = 2131101207;
        private Paint g = new Paint(1);
        private Rect f = new Rect();

        public SectionDecoration(int i) {
            this.b = i;
            this.f18247c = DensityUtils.d(ShareToGroupsFragment.this.j, 12.0f);
            this.d = DensityUtils.a(ShareToGroupsFragment.this.j, 11.0f);
            this.e = DensityUtils.a(ShareToGroupsFragment.this.j, 15.0f);
        }

        private void a(Canvas canvas, int i, int i2, View view, RecyclerView.LayoutParams layoutParams, int i3) {
            this.g.setColor(ShareToGroupsFragment.this.getResources().getColor(2131101196));
            canvas.drawRect(i, (view.getTop() - layoutParams.topMargin) - this.b, i2, view.getTop() - layoutParams.topMargin, this.g);
            this.g.setTextSize(this.f18247c);
            this.g.setColor(ShareToGroupsFragment.this.getResources().getColor(2131101207));
            canvas.drawText(((BluedGroupLists) ShareToGroupsFragment.this.q.get(i3)).header_name, this.e, (view.getTop() - layoutParams.topMargin) - ((this.b - this.d) - this.f18247c), this.g);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            int viewLayoutPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
            if (viewLayoutPosition <= -1 || ShareToGroupsFragment.this.q.size() <= 0) {
                return;
            }
            if (viewLayoutPosition == 0) {
                rect.set(0, this.b, 0, 0);
            } else if (((BluedGroupLists) ShareToGroupsFragment.this.q.get(viewLayoutPosition)).header_name == null || ((BluedGroupLists) ShareToGroupsFragment.this.q.get(viewLayoutPosition)).header_name.equals(((BluedGroupLists) ShareToGroupsFragment.this.q.get(viewLayoutPosition - 1)).header_name)) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(0, this.b, 0, 0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            super.onDraw(canvas, recyclerView, state);
            int paddingLeft = recyclerView.getPaddingLeft();
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    return;
                }
                View childAt = recyclerView.getChildAt(i2);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                int viewLayoutPosition = layoutParams.getViewLayoutPosition();
                if (viewLayoutPosition > -1 && ShareToGroupsFragment.this.q.size() > 0) {
                    if (viewLayoutPosition == 0) {
                        a(canvas, paddingLeft, width, childAt, layoutParams, viewLayoutPosition);
                    } else if (((BluedGroupLists) ShareToGroupsFragment.this.q.get(viewLayoutPosition)).header_name != null && !((BluedGroupLists) ShareToGroupsFragment.this.q.get(viewLayoutPosition)).header_name.equals(((BluedGroupLists) ShareToGroupsFragment.this.q.get(viewLayoutPosition - 1)).header_name)) {
                        a(canvas, paddingLeft, width, childAt, layoutParams, viewLayoutPosition);
                    }
                }
                i = i2 + 1;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            int findFirstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            if (findFirstVisibleItemPosition < 0 || ShareToGroupsFragment.this.q.size() < 1) {
                return;
            }
            String str = ((BluedGroupLists) ShareToGroupsFragment.this.q.get(findFirstVisibleItemPosition)).header_name;
            this.g.setColor(ShareToGroupsFragment.this.getResources().getColor(2131101196));
            canvas.drawRect(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getRight() - recyclerView.getPaddingRight(), recyclerView.getPaddingTop() + this.b, this.g);
            this.g.setColor(ShareToGroupsFragment.this.getResources().getColor(2131101207));
            float f = this.e;
            int paddingTop = recyclerView.getPaddingTop();
            int i = this.b;
            canvas.drawText(str, f, (paddingTop + i) - ((i - this.d) - this.f18247c), this.g);
        }
    }

    public static ShareToGroupsFragment a(Bundle bundle) {
        ShareToGroupsFragment shareToGroupsFragment = new ShareToGroupsFragment();
        if (bundle != null) {
            shareToGroupsFragment.setArguments(bundle);
        }
        return shareToGroupsFragment;
    }

    private void h() {
        GroupHttpUtils.g(this.j, new BluedUIHttpResponse<BluedEntityA<BluedMyGroupLists>>() { // from class: com.soft.blued.ui.msg.ShareToGroupsFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedMyGroupLists> bluedEntityA) {
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.hasData()) {
                            BluedMyGroupLists bluedMyGroupLists = (BluedMyGroupLists) bluedEntityA.getSingleData();
                            if (bluedMyGroupLists == null) {
                                ShareToGroupsFragment.this.m.a();
                                ShareToGroupsFragment.this.l.setEmptyView((View) ShareToGroupsFragment.this.m);
                                ShareToGroupsFragment.this.l.setNewData(null);
                                return;
                            }
                            List<BluedCreatedGroupInfo> list = bluedMyGroupLists.created;
                            List<BluedCreatedGroupInfo> list2 = bluedMyGroupLists.admin;
                            List<BluedCreatedGroupInfo> list3 = bluedMyGroupLists.joined;
                            if (list != null) {
                                int i = 0;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= list.size()) {
                                        break;
                                    }
                                    list.get(i2).type = 0;
                                    list.get(i2).header_name = ShareToGroupsFragment.this.getResources().getString(R.string.my_created_groups);
                                    ShareToGroupsFragment.this.q.add(list.get(i2));
                                    i = i2 + 1;
                                }
                            }
                            if (list2 != null) {
                                int i3 = 0;
                                while (true) {
                                    int i4 = i3;
                                    if (i4 >= list2.size()) {
                                        break;
                                    }
                                    list2.get(i4).type = 1;
                                    list2.get(i4).header_name = ShareToGroupsFragment.this.getResources().getString(R.string.my_managed_groups);
                                    ShareToGroupsFragment.this.q.add(list2.get(i4));
                                    i3 = i4 + 1;
                                }
                            }
                            if (list3 != null) {
                                int i5 = 0;
                                while (true) {
                                    int i6 = i5;
                                    if (i6 >= list3.size()) {
                                        break;
                                    }
                                    list3.get(i6).type = 2;
                                    list3.get(i6).header_name = ShareToGroupsFragment.this.getResources().getString(R.string.my_joined_groups);
                                    ShareToGroupsFragment.this.q.add(list3.get(i6));
                                    i5 = i6 + 1;
                                }
                            }
                            if (ShareToGroupsFragment.this.q.size() != 0) {
                                ShareToGroupsFragment.this.l.setNewData(ShareToGroupsFragment.this.q);
                                return;
                            }
                            ShareToGroupsFragment.this.m.a();
                            ShareToGroupsFragment.this.l.setEmptyView((View) ShareToGroupsFragment.this.m);
                            ShareToGroupsFragment.this.l.setNewData(null);
                            return;
                        }
                    } catch (Exception e) {
                        ShareToGroupsFragment.this.m.a();
                        ShareToGroupsFragment.this.l.setEmptyView((View) ShareToGroupsFragment.this.m);
                        ShareToGroupsFragment.this.l.setNewData(null);
                        e.printStackTrace();
                        return;
                    }
                }
                ShareToGroupsFragment.this.m.a();
                ShareToGroupsFragment.this.l.setEmptyView((View) ShareToGroupsFragment.this.m);
                ShareToGroupsFragment.this.l.setNewData(null);
            }

            public boolean onUIFailure(int i, String str) {
                ShareToGroupsFragment.this.m.b();
                ShareToGroupsFragment.this.l.setEmptyView((View) ShareToGroupsFragment.this.m);
                ShareToGroupsFragment.this.l.setNewData(null);
                return super.onUIFailure(i, str);
            }

            public void onUIFinish() {
                super.onUIFinish();
                ShareToGroupsFragment.this.n.setVisibility(8);
                ShareToGroupsFragment.this.l.loadMoreEnd();
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), getFragmentActive());
    }

    public void a(View view) {
        this.q = new ArrayList();
        View inflate = LayoutInflater.from(this.j).inflate(R.layout.fragment_share_to_single, (ViewGroup) view, true);
        this.n = (ProgressBar) inflate.findViewById(2131368973);
        PullToRefreshRecyclerView findViewById = inflate.findViewById(R.id.ptrrv_list);
        this.p = findViewById;
        findViewById.setRefreshEnabled(false);
        this.o = (RecyclerView) this.p.getRefreshableView();
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.j);
        this.m = noDataAndLoadFailView;
        noDataAndLoadFailView.setNoDataImg(2131233642);
        this.m.setNoDataStr(2131892288);
        this.m.a();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.j);
        this.l = new GroupListAdapter();
        this.o.addItemDecoration(new SectionDecoration(DensityUtils.a(this.j, 30.0f)));
        this.o.setLayoutManager(linearLayoutManager);
        this.o.setAdapter(this.l);
        this.l.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.msg.ShareToGroupsFragment.1
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                BluedGroupLists bluedGroupLists = (BluedGroupLists) baseQuickAdapter.getData().get(i);
                if (bluedGroupLists == null) {
                    return;
                }
                ShareUtils.a().a(ShareToGroupsFragment.this.j, Long.parseLong(bluedGroupLists.groups_gid), (short) 3, bluedGroupLists.groups_name, bluedGroupLists.groups_avatar, bluedGroupLists.vbadge, 0, 0, 0, 0, ShareToGroupsFragment.this.k, "[" + ShareToGroupsFragment.this.getResources().getString(R.string.group) + "]" + bluedGroupLists.groups_name, ShareToGroupsFragment.this.k.gid);
            }
        });
        h();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.j = context;
        if (getArguments() != null) {
            this.k = (ShareToMsgEntity) getArguments().get("share_entity");
        }
    }
}
