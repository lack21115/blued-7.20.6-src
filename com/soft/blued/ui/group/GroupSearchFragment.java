package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.anythink.expressad.video.dynview.a.a;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.framework.view.stickygridheaders.StickyGridHeadersGridView;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.SearchView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.adapter.GroupStickyHeaderGVAdapter;
import com.soft.blued.ui.group.model.BluedGroupTypeGridItem;
import com.soft.blued.ui.group.model.BluedGroupTypeTags;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupSearchFragment.class */
public class GroupSearchFragment extends KeyBoardFragment implements View.OnClickListener {
    public Dialog b;

    /* renamed from: c  reason: collision with root package name */
    public List<BluedGroupTypeGridItem> f30845c;
    public BluedUIHttpResponse j = new BluedUIHttpResponse<BluedEntityA<BluedGroupTypeTags>>() { // from class: com.soft.blued.ui.group.GroupSearchFragment.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedGroupTypeTags> bluedEntityA) {
            try {
                if (!bluedEntityA.hasData()) {
                    AppMethods.a((CharSequence) GroupSearchFragment.this.getResources().getString(2131887275));
                    return;
                }
                GroupSearchFragment.this.q.add(bluedEntityA.getSingleData());
                new BluedGroupTypeTags.GroupsRecommend();
                ArrayList arrayList = new ArrayList();
                arrayList.add(((BluedGroupTypeTags) GroupSearchFragment.this.q.get(0)).getRecommend());
                arrayList.addAll(((BluedGroupTypeTags) GroupSearchFragment.this.q.get(0)).getClassify());
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        GroupSearchFragment.this.n.notifyDataSetChanged();
                        return;
                    }
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < ((BluedGroupTypeTags.GroupsClassify) arrayList.get(i2)).getItem().size()) {
                            GroupSearchFragment.this.f30845c.add(new BluedGroupTypeGridItem(((BluedGroupTypeTags.GroupsClassify) arrayList.get(i2)).getType(), ((BluedGroupTypeTags.GroupsClassify) arrayList.get(i2)).getItem().get(i4), ((BluedGroupTypeTags.GroupsClassify) arrayList.get(i2)).getName()));
                            i3 = i4 + 1;
                        }
                    }
                    i = i2 + 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
                AppMethods.a((CharSequence) GroupSearchFragment.this.l.getResources().getString(2131887272));
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(GroupSearchFragment.this.b);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(GroupSearchFragment.this.b);
        }
    };
    private KeyboardListenLinearLayout k;
    private Context l;
    private StickyGridHeadersGridView m;
    private GroupStickyHeaderGVAdapter n;
    private SearchView o;
    private SearchEditText p;
    private List<BluedGroupTypeTags> q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupSearchFragment$MyOnItemClickListener.class */
    public class MyOnItemClickListener implements AdapterView.OnItemClickListener {
        private MyOnItemClickListener() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Tracker.onItemClick(adapterView, view, i, j);
            if (i < 0 || i > GroupSearchFragment.this.f30845c.size()) {
                return;
            }
            if (!StringUtils.d(GroupSearchFragment.this.f30845c.get(i).getTags())) {
                GroupSearchFragment.this.p.setText(GroupSearchFragment.this.f30845c.get(i).getTags());
                GroupSearchFragment.this.p.setSelection(GroupSearchFragment.this.p.length());
            }
            GroupSearchListFragment.a(GroupSearchFragment.this.l, GroupSearchFragment.this.p.getText().toString());
            ActivityChangeAnimationUtils.e(GroupSearchFragment.this.getActivity());
        }
    }

    private void h() {
        this.b = DialogUtils.a(this.l);
        this.q = new ArrayList();
        this.f30845c = new ArrayList();
        this.m = (StickyGridHeadersGridView) this.k.findViewById(R.id.asset_grid);
        if (getResources().getConfiguration().locale.getLanguage().equals(a.V)) {
            this.m.setNumColumns(4);
        } else {
            this.m.setNumColumns(3);
        }
        this.m.setHeadersIgnorePadding(true);
        GroupStickyHeaderGVAdapter groupStickyHeaderGVAdapter = new GroupStickyHeaderGVAdapter(this.l, this.f30845c);
        this.n = groupStickyHeaderGVAdapter;
        this.m.setAdapter((ListAdapter) groupStickyHeaderGVAdapter);
        this.m.setAreHeadersSticky(true);
        this.m.setSelector(new ColorDrawable(0));
        this.m.setCacheColorHint(0);
        this.m.setOnItemClickListener(new MyOnItemClickListener());
    }

    private void i() {
        SearchView searchView = (SearchView) this.k.findViewById(2131369680);
        this.o = searchView;
        SearchEditText editView = searchView.getEditView();
        this.p = editView;
        editView.setImeOptions(3);
        this.o.setOnSearchInfoListener(new SearchView.OnSearchInfoListener() { // from class: com.soft.blued.ui.group.GroupSearchFragment.1
            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void a() {
                KeyboardUtils.a(GroupSearchFragment.this.getActivity());
                GroupSearchFragment.this.getActivity().finish();
            }

            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void a(String str) {
            }

            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void b() {
            }
        });
        this.p.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.soft.blued.ui.group.GroupSearchFragment.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    if (StringUtils.d(GroupSearchFragment.this.p.getText().toString())) {
                        AppMethods.a((CharSequence) GroupSearchFragment.this.getResources().getString(R.string.group_search));
                        return false;
                    }
                    GroupSearchListFragment.a(GroupSearchFragment.this.l, GroupSearchFragment.this.p.getText().toString());
                    ActivityChangeAnimationUtils.e(GroupSearchFragment.this.getActivity());
                    return true;
                }
                return false;
            }
        });
    }

    private void j() {
        GroupHttpUtils.i(this.l, this.j, "detail", getFragmentActive());
    }

    @Override // com.blued.android.framework.activity.keyboardpage.KeyBoardFragment
    public void j_(int i) {
        SearchView searchView;
        if (i != -3) {
            if (i == -2 && (searchView = this.o) != null) {
                searchView.a(false);
                return;
            }
            return;
        }
        SearchView searchView2 = this.o;
        if (searchView2 != null) {
            searchView2.a(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.l = getActivity();
        KeyboardListenLinearLayout keyboardListenLinearLayout = this.k;
        if (keyboardListenLinearLayout == null) {
            KeyboardListenLinearLayout keyboardListenLinearLayout2 = (KeyboardListenLinearLayout) layoutInflater.inflate(R.layout.fragment_group_search, viewGroup, false);
            this.k = keyboardListenLinearLayout2;
            super.a(keyboardListenLinearLayout2);
            h();
            i();
            j();
        } else if (keyboardListenLinearLayout.getParent() != null) {
            ((ViewGroup) this.k.getParent()).removeView(this.k);
        }
        return this.k;
    }

    @Override // com.blued.android.framework.activity.HomeTabFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
