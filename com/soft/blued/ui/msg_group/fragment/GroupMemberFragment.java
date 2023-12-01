package com.soft.blued.ui.msg_group.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.event.CommonLiveEventData;
import com.blued.android.module.common.group.GroupMemberModel;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.customview.PopMenu;
import com.soft.blued.ui.msg_group.adapter.GroupMemberAdapter;
import com.soft.blued.ui.msg_group.presenter.GroupMemberPresenter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupMemberFragment.class */
public class GroupMemberFragment extends MvpFragment<GroupMemberPresenter> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private GroupMemberAdapter f19058a;
    private GroupMemberAdapter b;

    /* renamed from: c  reason: collision with root package name */
    private NoDataAndLoadFailView f19059c;
    @BindView
    ImageView ctt_left_img;
    private ListView d;
    private boolean e = true;
    private PopMenu f;
    @BindView
    FrameLayout fm_search_list;
    @BindView
    FrameLayout frame_layout;
    private MenuViewHolder g;
    @BindView
    ImageView iv_delete;
    @BindView
    ImageView iv_sort;
    private Unbinder k;
    @BindView
    RenrenPullToRefreshListView mListViewWrapper;
    @BindView
    RelativeLayout rl_bottom;
    @BindView
    NoDataAndLoadFailView searchNoDataView;
    @BindView
    RenrenPullToRefreshListView search_list;
    @BindView
    SearchView search_view;
    @BindView
    TextView tv_delete;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupMemberFragment$MenuViewHolder.class */
    public static class MenuViewHolder {
        @BindView
        public CheckBox checkbox0;
        @BindView
        public CheckBox checkbox1;
        @BindView
        public CheckBox checkbox2;
        @BindView
        public RelativeLayout rl_item0;
        @BindView
        public RelativeLayout rl_item1;
        @BindView
        public RelativeLayout rl_item2;

        MenuViewHolder() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupMemberFragment$MenuViewHolder_ViewBinding.class */
    public class MenuViewHolder_ViewBinding implements Unbinder {
        private MenuViewHolder b;

        public MenuViewHolder_ViewBinding(MenuViewHolder menuViewHolder, View view) {
            this.b = menuViewHolder;
            menuViewHolder.checkbox0 = (CheckBox) Utils.a(view, R.id.checkbox0, "field 'checkbox0'", CheckBox.class);
            menuViewHolder.checkbox1 = (CheckBox) Utils.a(view, R.id.checkbox1, "field 'checkbox1'", CheckBox.class);
            menuViewHolder.checkbox2 = (CheckBox) Utils.a(view, R.id.checkbox2, "field 'checkbox2'", CheckBox.class);
            menuViewHolder.rl_item0 = (RelativeLayout) Utils.a(view, R.id.rl_item0, "field 'rl_item0'", RelativeLayout.class);
            menuViewHolder.rl_item1 = (RelativeLayout) Utils.a(view, R.id.rl_item1, "field 'rl_item1'", RelativeLayout.class);
            menuViewHolder.rl_item2 = (RelativeLayout) Utils.a(view, R.id.rl_item2, "field 'rl_item2'", RelativeLayout.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            MenuViewHolder menuViewHolder = this.b;
            if (menuViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            menuViewHolder.checkbox0 = null;
            menuViewHolder.checkbox1 = null;
            menuViewHolder.checkbox2 = null;
            menuViewHolder.rl_item0 = null;
            menuViewHolder.rl_item1 = null;
            menuViewHolder.rl_item2 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(CommonLiveEventData commonLiveEventData) {
        List list = (List) commonLiveEventData.a();
        this.searchNoDataView.d();
        if (((GroupMemberPresenter) j()).j != 1) {
            this.f19058a.b(list);
        } else if (list.isEmpty()) {
            this.searchNoDataView.a();
        } else {
            this.f19058a.a(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.search_list.getVisibility() == 0) {
            this.iv_delete.setVisibility(8);
            this.iv_sort.setVisibility(8);
        } else if (((GroupMemberPresenter) j()).o == 1 || ((GroupMemberPresenter) j()).o == 2) {
            this.iv_delete.setVisibility(0);
            this.iv_sort.setVisibility(0);
            this.iv_sort.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupMemberFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (GroupMemberFragment.this.f.a()) {
                        GroupMemberFragment.this.f.d();
                    } else {
                        GroupMemberFragment.this.f.a(GroupMemberFragment.this.iv_sort);
                    }
                }
            });
            this.iv_delete.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupMemberFragment.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (GroupMemberFragment.this.b == null) {
                        return;
                    }
                    GroupMemberFragment.this.b.b = !GroupMemberFragment.this.b.b;
                    GroupMemberFragment.this.b.notifyDataSetChanged();
                    if (GroupMemberFragment.this.b.b) {
                        GroupMemberFragment.this.rl_bottom.setVisibility(0);
                        return;
                    }
                    GroupMemberFragment.this.b.f18942c.clear();
                    GroupMemberFragment.this.rl_bottom.setVisibility(8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final String str) {
        CommonAlertDialog.a(getContext(), "", ((GroupMemberPresenter) j()).p == 4 ? getString(R.string.group_event_member_kick_hint) : (!TextUtils.isEmpty(str) || this.b.f18942c.size() <= 1) ? getString(R.string.group_kick_out_single_hint) : getString(R.string.group_kick_out_hint), getContext().getResources().getString(2131887320), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupMemberFragment.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                StringBuilder sb = new StringBuilder();
                if (TextUtils.isEmpty(str) && GroupMemberFragment.this.b.f18942c.size() > 0) {
                    for (String str2 : GroupMemberFragment.this.b.f18942c) {
                        sb.append(str2 + ",");
                    }
                } else if (!TextUtils.isEmpty(str)) {
                    sb.append(str + ",");
                }
                String sb2 = sb.toString();
                ((GroupMemberPresenter) GroupMemberFragment.this.j()).a(sb2.substring(0, sb2.length() - 1), 4, new int[0]);
                dialogInterface.dismiss();
            }
        }, getContext().getResources().getString(R.string.common_cancel), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupMemberFragment.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
            }
        }, (DialogInterface.OnDismissListener) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d() {
        LiveEventBus.get("data_search", CommonLiveEventData.class).observe(this, new Observer() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$GroupMemberFragment$mwAi-vjtYrbIiy6S_4GCMsD0Ztg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupMemberFragment.this.a((CommonLiveEventData) obj);
            }
        });
        LiveEventBus.get("data_search_end", Boolean.class).observe(this, new Observer<Boolean>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupMemberFragment.8
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                if (bool.booleanValue() || ((GroupMemberPresenter) GroupMemberFragment.this.j()).j != 1) {
                    GroupMemberFragment.this.search_list.q();
                } else {
                    GroupMemberFragment.this.searchNoDataView.b();
                }
            }
        });
        LiveEventBus.get("data_search_has_more", Boolean.class).observe(this, new Observer<Boolean>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupMemberFragment.9
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                if (bool.booleanValue()) {
                    GroupMemberFragment.this.search_list.o();
                } else {
                    GroupMemberFragment.this.search_list.p();
                }
            }
        });
        LiveEventBus.get("delete_member", GroupMemberModel.class).observe(this, new Observer<GroupMemberModel>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupMemberFragment.10
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(GroupMemberModel groupMemberModel) {
                if (groupMemberModel.group_role == 1 || ((GroupMemberPresenter) GroupMemberFragment.this.j()).o == 3) {
                    return;
                }
                if (((GroupMemberPresenter) GroupMemberFragment.this.j()).o != 2 || groupMemberModel.group_role == 3) {
                    GroupMemberFragment.this.c(groupMemberModel.uid);
                }
            }
        });
    }

    private void d(String str) {
        this.f.d();
        ((GroupMemberPresenter) j()).n = str;
        l();
    }

    private void e() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.menu_group_msg_member, (ViewGroup) null);
        MenuViewHolder menuViewHolder = new MenuViewHolder();
        this.g = menuViewHolder;
        this.k = ButterKnife.a(menuViewHolder, inflate);
        this.f = new PopMenu(getContext(), inflate);
        this.g.rl_item0.setOnClickListener(this);
        this.g.rl_item1.setOnClickListener(this);
        this.g.rl_item2.setOnClickListener(this);
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        this.searchNoDataView.setNoDataImg(2131233641);
        this.f19058a = new GroupMemberAdapter(getContext(), 4, ((GroupMemberPresenter) j()).o, getFragmentActive());
        this.search_list.p();
        ListView listView = (ListView) this.search_list.getRefreshableView();
        listView.setAdapter((ListAdapter) this.f19058a);
        listView.setClipToPadding(false);
        listView.setScrollBarStyle(33554432);
        listView.setHeaderDividersEnabled(false);
        listView.setDividerHeight(0);
        this.search_list.setRefreshEnabled(false);
        this.search_list.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupMemberFragment.1
            public void a() {
            }

            public void b() {
                ((GroupMemberPresenter) GroupMemberFragment.this.j()).m();
            }
        });
        this.search_view.setFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupMemberFragment.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Tracker.onFocusChange(view, z);
                if (GroupMemberFragment.this.fm_search_list == null) {
                    return;
                }
                GroupMemberFragment.this.search_view.a(z);
                if (z) {
                    GroupMemberFragment.this.fm_search_list.setVisibility(0);
                } else {
                    GroupMemberFragment.this.fm_search_list.setVisibility(8);
                }
            }
        });
        this.search_view.setOnSearchInfoListener(new SearchView.OnSearchInfoListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupMemberFragment.3
            public void a() {
                GroupMemberFragment.this.search_list.setVisibility(8);
                GroupMemberFragment.this.f19058a.a(new ArrayList());
                GroupMemberFragment.this.search_view.getEditView().clearFocus();
                GroupMemberFragment.this.fm_search_list.setVisibility(8);
                KeyboardUtils.a(GroupMemberFragment.this.getActivity());
                GroupMemberFragment.this.searchNoDataView.d();
                GroupMemberFragment.this.c();
            }

            public void a(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                GroupMemberFragment.this.search_list.setVisibility(0);
                ((ListView) GroupMemberFragment.this.search_list.getRefreshableView()).setVisibility(0);
                ((GroupMemberPresenter) GroupMemberFragment.this.j()).j = 1;
                ((GroupMemberPresenter) GroupMemberFragment.this.j()).d(str);
                GroupMemberFragment.this.c();
            }

            public void b() {
            }
        });
        this.search_view.getEditView().setHint((int) R.string.group_search_member_hint);
        this.search_view.getEditView().clearFocus();
        this.search_view.getEditView().setFocusable(false);
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg_group.fragment.GroupMemberFragment.4
            @Override // java.lang.Runnable
            public void run() {
                GroupMemberFragment.this.search_view.getEditView().setFocusable(true);
            }
        }, 500L);
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(getContext());
        this.f19059c = noDataAndLoadFailView;
        noDataAndLoadFailView.setNoDataImg(2131233641);
        this.f19059c.d();
        this.frame_layout.addView(this.f19059c);
        e();
        this.mListViewWrapper.setRefreshEnabled(true);
        ListView listView2 = (ListView) this.mListViewWrapper.getRefreshableView();
        this.d = listView2;
        listView2.setClipToPadding(false);
        this.d.setScrollBarStyle(33554432);
        this.d.setHeaderDividersEnabled(false);
        this.d.setDividerHeight(0);
        this.mListViewWrapper.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupMemberFragment.5
            public void a() {
                GroupMemberFragment.this.e = true;
                GroupMemberFragment.this.l();
            }

            public void b() {
                if (GroupMemberFragment.this.e) {
                    ((GroupMemberPresenter) GroupMemberFragment.this.j()).f();
                } else {
                    AppMethods.a(GroupMemberFragment.this.getResources().getString(2131887275));
                }
            }
        });
        this.tv_delete.setOnClickListener(this);
        this.ctt_left_img.setOnClickListener(this);
        c();
        d();
    }

    public void a(String str, boolean z) {
        super.a(str, z);
        this.mListViewWrapper.j();
        this.mListViewWrapper.q();
    }

    public void a(List<GroupMemberModel> list) {
        if (this.b == null) {
            GroupMemberAdapter groupMemberAdapter = new GroupMemberAdapter(getContext(), 4, ((GroupMemberPresenter) j()).o, getFragmentActive());
            this.b = groupMemberAdapter;
            this.d.setAdapter((ListAdapter) groupMemberAdapter);
        }
        this.b.a(list);
        if (this.e) {
            this.mListViewWrapper.o();
        }
    }

    public void b() {
        LiveEventBus.get("common_kick_out_member", Void.class).post(null);
        this.rl_bottom.setVisibility(8);
        this.b.a();
    }

    public int g() {
        return R.layout.fm_msg_group_member;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363123) {
            t();
        } else if (id == 2131371256) {
            if (this.b.f18942c.size() <= 0) {
                return;
            }
            c((String) null);
        } else {
            switch (id) {
                case R.id.rl_item0 /* 2131369337 */:
                    if (((GroupMemberPresenter) j()).n.equals("joined")) {
                        return;
                    }
                    this.g.checkbox0.setVisibility(0);
                    this.g.checkbox1.setVisibility(8);
                    this.g.checkbox2.setVisibility(8);
                    d("joined");
                    return;
                case R.id.rl_item1 /* 2131369338 */:
                    if (((GroupMemberPresenter) j()).n.equals("talk")) {
                        return;
                    }
                    this.g.checkbox0.setVisibility(8);
                    this.g.checkbox1.setVisibility(0);
                    this.g.checkbox2.setVisibility(8);
                    d("talk");
                    return;
                case R.id.rl_item2 /* 2131369339 */:
                    if (((GroupMemberPresenter) j()).n.equals("talk_asc")) {
                        return;
                    }
                    this.g.checkbox0.setVisibility(8);
                    this.g.checkbox1.setVisibility(8);
                    this.g.checkbox2.setVisibility(0);
                    d("talk_asc");
                    return;
                default:
                    return;
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.k.unbind();
    }

    public void p() {
        super.p();
        this.e = false;
        this.mListViewWrapper.p();
    }
}
