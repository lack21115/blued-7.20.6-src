package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.StableSessionListListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.SearchView;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.openalliance.ad.constant.ao;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.ui.live.adapter.ShareWithContactAdapter;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/ShareWithContactFragment.class */
public class ShareWithContactFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public ShareWithContactAdapter f17546a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private View f17547c;
    private RenrenPullToRefreshListView d;
    private ListView e;
    private List<SessionModel> f;
    private LayoutInflater g;
    private int h;
    private TextView k;
    private CommonTopTitleNoTrans l;
    private SearchView m;
    private SearchEditText n;
    private LinearLayout o;
    private LinearLayout p;
    private int i = 10;
    private boolean j = true;
    private int q = 1;
    private String r = "";
    private ArrayList<String> s = new ArrayList<>();
    private ShareWithContactSessionListener t = new ShareWithContactSessionListener();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/ShareWithContactFragment$ShareWithContactSessionListener.class */
    class ShareWithContactSessionListener extends StableSessionListListener {
        private ShareWithContactSessionListener() {
        }

        public void onUISessionDataChanged(List<SessionModel> list) {
            ChatHelperV4.d(list);
            if (ShareWithContactFragment.this.f.size() == 0) {
                ShareWithContactFragment.this.f.clear();
                ArrayList arrayList = list;
                if (list == null) {
                    arrayList = new ArrayList();
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    SessionModel sessionModel = arrayList.get(i2);
                    sessionModel.checked = false;
                    if (ShareWithContactFragment.this.s != null && ShareWithContactFragment.this.s.size() > 0) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= ShareWithContactFragment.this.s.size()) {
                                break;
                            }
                            if (((String) ShareWithContactFragment.this.s.get(i4)).equals(String.valueOf(sessionModel.sessionId))) {
                                sessionModel.checked = true;
                            }
                            i3 = i4 + 1;
                        }
                    }
                    if (sessionModel.sessionType == 2) {
                        ShareWithContactFragment.this.f.add(sessionModel);
                    } else if (sessionModel.sessionType == 3 && !BluedConstant.f14549a) {
                        ShareWithContactFragment.this.f.add(sessionModel);
                    }
                    i = i2 + 1;
                }
                ShareWithContactFragment.this.f17546a = new ShareWithContactAdapter(ShareWithContactFragment.this.getFragmentActive(), ShareWithContactFragment.this.b, ShareWithContactFragment.this.f, ShareWithContactFragment.this.q);
                ShareWithContactFragment.this.e.setAdapter((ListAdapter) ShareWithContactFragment.this.f17546a);
                ShareWithContactFragment.this.f17546a.notifyDataSetChanged();
                if (ShareWithContactFragment.this.f.size() > 0) {
                    if (ShareWithContactFragment.this.o != null) {
                        ShareWithContactFragment.this.o.setVisibility(8);
                    }
                } else if (ShareWithContactFragment.this.o != null) {
                    ShareWithContactFragment.this.o.setVisibility(0);
                }
                ShareWithContactFragment.this.c();
            }
        }
    }

    static /* synthetic */ int a(ShareWithContactFragment shareWithContactFragment) {
        int i = shareWithContactFragment.h;
        shareWithContactFragment.h = i + 1;
        return i;
    }

    private void a() {
        CommonTopTitleNoTrans findViewById = this.f17547c.findViewById(R.id.top_title);
        this.l = findViewById;
        findViewById.setCenterText(getString(R.string.biao_v4_msg_title));
        this.l.setLeftText(2131886885);
        this.l.setRightText((int) R.string.done);
        this.l.setRightTextColor(2131102254);
        this.l.setLeftClickListener(this);
        this.l.setRightClickListener(this);
        if (this.q == 1) {
            this.l.a();
        }
    }

    public static void a(BaseFragment baseFragment, int i, int i2, String str, String[] strArr) {
        Bundle bundle = new Bundle();
        bundle.putInt(ao.h, i2);
        bundle.putString("bottomHintStr", str);
        ArrayList<String> arrayList = new ArrayList<>();
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= strArr.length) {
                    break;
                }
                arrayList.add(strArr[i4]);
                i3 = i4 + 1;
            }
        }
        if (arrayList.size() > 0) {
            bundle.putStringArrayList("selectedIDS", arrayList);
        }
        TerminalActivity.a(baseFragment, ShareWithContactFragment.class, bundle, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int i;
        if (z) {
            this.h = 1;
        }
        if (this.h == 1) {
            this.j = true;
        }
        if (this.j || (i = this.h) == 1) {
            return;
        }
        this.h = i - 1;
        AppMethods.a(this.b.getResources().getString(2131887275));
        this.d.j();
        this.d.q();
    }

    private void b() {
        LinearLayout linearLayout = (LinearLayout) this.f17547c.findViewById(R.id.ll_hint);
        this.p = linearLayout;
        linearLayout.setOnClickListener(this);
        if (LiveRoomPreferences.C()) {
            this.p.setVisibility(8);
        } else {
            this.p.setVisibility(4);
        }
        this.k = (TextView) this.f17547c.findViewById(R.id.tv_hint_text);
        if (StringUtils.d(this.r)) {
            this.p.setVisibility(8);
        } else {
            this.p.setVisibility(0);
            this.p.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in));
            this.k.setText(this.r);
        }
        this.o = (LinearLayout) this.f17547c.findViewById(R.id.ll_nodata);
        RenrenPullToRefreshListView findViewById = this.f17547c.findViewById(R.id.list_view);
        this.d = findViewById;
        findViewById.setRefreshEnabled(true);
        ListView listView = (ListView) this.d.getRefreshableView();
        this.e = listView;
        listView.setClipToPadding(false);
        this.e.setScrollBarStyle(33554432);
        this.e.setHeaderDividersEnabled(false);
        this.e.setDividerHeight(0);
        this.d.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener() { // from class: com.soft.blued.ui.live.fragment.ShareWithContactFragment.1
            public void a() {
                ShareWithContactFragment.this.h = 1;
                ShareWithContactFragment.this.a(false);
            }

            public void b() {
                ShareWithContactFragment.a(ShareWithContactFragment.this);
                ShareWithContactFragment.this.a(false);
            }
        });
        this.d.setRefreshEnabled(false);
        LayoutInflater from = LayoutInflater.from(getActivity());
        this.g = from;
        SearchView inflate = from.inflate(R.layout.search_layout, (ViewGroup) null);
        this.m = inflate;
        this.n = inflate.getEditView();
        this.m.setDelaymillis(0L);
        this.m.setOnSearchInfoListener(new SearchView.OnSearchInfoListener() { // from class: com.soft.blued.ui.live.fragment.ShareWithContactFragment.2
            public void a() {
                ShareWithContactFragment.this.h = 1;
                ShareWithContactFragment.this.a(false);
            }

            public void a(String str) {
                ShareWithContactFragment.this.f17546a.a(str);
                ShareWithContactFragment.this.f17546a.notifyDataSetChanged();
            }

            public void b() {
            }
        });
        this.d.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.soft.blued.ui.live.fragment.ShareWithContactFragment.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                ShareWithContactFragment.this.n.clearFocus();
            }
        });
        this.e.addHeaderView(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        RenrenPullToRefreshListView renrenPullToRefreshListView = this.d;
        if (renrenPullToRefreshListView != null) {
            renrenPullToRefreshListView.j();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id != 2131363126) {
            if (id != 2131367903) {
                return;
            }
            this.p.setVisibility(8);
            LiveRoomPreferences.c(true);
            this.p.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out));
        } else {
            Intent intent = new Intent();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f.size()) {
                    intent.putExtra("CHOOSED_UID", (String[]) arrayList.toArray(new String[arrayList.size()]));
                    intent.putExtra("CHOOSED_TYPE", (String[]) arrayList2.toArray(new String[arrayList2.size()]));
                    getActivity().setResult(-1, intent);
                    getActivity().finish();
                    return;
                }
                if (this.f.get(i2).checked) {
                    arrayList.add(String.valueOf(this.f.get(i2).sessionId));
                    arrayList2.add(String.valueOf((int) this.f.get(i2).sessionType));
                }
                i = i2 + 1;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        this.f = new ArrayList();
        View view = this.f17547c;
        if (view == null) {
            this.f17547c = layoutInflater.inflate(R.layout.fragment_share_with_contact, viewGroup, false);
            if (getArguments() != null) {
                this.q = getArguments().getInt(ao.h);
                this.r = getArguments().getString("bottomHintStr");
                this.s = getArguments().getStringArrayList("selectedIDS");
            }
            b();
            a();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f17547c.getParent()).removeView(this.f17547c);
        }
        return this.f17547c;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f.clear();
    }

    public void onStart() {
        super.onStart();
        ChatManager.getInstance().registerSessionListener(this.t);
    }

    public void onStop() {
        super.onStop();
        ChatManager.getInstance().unregisterSessionListener(this.t);
    }
}
