package com.soft.blued.ui.msg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.base.mvp.MVPBaseFragment;
import com.soft.blued.customview.SpacesItemDecoration;
import com.soft.blued.ui.msg.contract.IChatBgSelectIView;
import com.soft.blued.ui.msg.presenter.ChatBgSelectPresent;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ChatBgSelectFragment.class */
public class ChatBgSelectFragment extends MVPBaseFragment<IChatBgSelectIView, ChatBgSelectPresent> implements IChatBgSelectIView {
    private PullToRefreshRecyclerView j;
    private RecyclerView k;

    public static void a(BaseFragment baseFragment, int i, long j, short s, int i2) {
        Bundle bundle = new Bundle();
        bundle.putLong("passby_session_id", j);
        bundle.putShort("passby_session_type", s);
        bundle.putInt("from", i);
        TerminalActivity.a(baseFragment, ChatBgSelectFragment.class, bundle, i2);
    }

    @Override // com.soft.blued.ui.msg.contract.IChatBgSelectIView
    public void a(RecyclerView.Adapter adapter) {
        RecyclerView recyclerView = this.k;
        if (recyclerView != null) {
            recyclerView.setAdapter(adapter);
        }
    }

    @Override // com.soft.blued.base.mvp.MVPBaseFragment
    public boolean a(Bundle bundle) {
        return false;
    }

    @Override // com.soft.blued.base.mvp.MVPBaseFragment
    public void b(Bundle bundle) {
        this.f.setCenterText(R.string.biao_v4_chat_setting_select_bg);
        this.f.a();
        PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView) this.f28294c.findViewById(R.id.msg_chatting_bg_select_view);
        this.j = pullToRefreshRecyclerView;
        RecyclerView refreshableView = pullToRefreshRecyclerView.getRefreshableView();
        this.k = refreshableView;
        refreshableView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(DensityUtils.a(getContext(), 1.5f));
        spacesItemDecoration.a(5);
        spacesItemDecoration.a(true, true, true, true);
        spacesItemDecoration.a(0, DensityUtils.a(getContext(), 3.5f), 0, DensityUtils.a(getContext(), 3.5f));
        this.k.addItemDecoration(spacesItemDecoration);
        this.j.setRefreshEnabled(false);
        this.j.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>() { // from class: com.soft.blued.ui.msg.ChatBgSelectFragment.1
            @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase.OnRefreshListener
            public void onRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
                if (ChatBgSelectFragment.this.f28293a != null) {
                    ((ChatBgSelectPresent) ChatBgSelectFragment.this.f28293a).d();
                }
            }
        });
        a(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.ChatBgSelectFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (ChatBgSelectFragment.this.f28293a != null) {
                    ((ChatBgSelectPresent) ChatBgSelectFragment.this.f28293a).d();
                }
            }
        });
    }

    @Override // com.soft.blued.base.mvp.MVPBaseFragment
    public void f() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.soft.blued.base.mvp.MVPBaseFragment
    /* renamed from: h */
    public ChatBgSelectPresent e() {
        return new ChatBgSelectPresent();
    }

    @Override // com.soft.blued.ui.msg.contract.IChatBgSelectIView
    public void i() {
        PullToRefreshRecyclerView pullToRefreshRecyclerView = this.j;
        if (pullToRefreshRecyclerView != null) {
            pullToRefreshRecyclerView.j();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.a(R.layout.fragment_chat_bg_select, layoutInflater, viewGroup, bundle);
    }
}
