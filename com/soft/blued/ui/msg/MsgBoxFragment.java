package com.soft.blued.ui.msg;

import android.os.Bundle;
import android.view.View;
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
import com.blued.android.chat.model.SessionModel;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.ui.msg.adapter.ChatFriendListAdapter;
import com.soft.blued.ui.msg.contract.IMsgView;
import com.soft.blued.ui.msg.presenter.MsgBoxPresent;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgBoxFragment.class */
public class MsgBoxFragment extends MvpFragment<MsgBoxPresent> implements View.OnClickListener, IMsgView {

    /* renamed from: a  reason: collision with root package name */
    private ListView f18036a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private Unbinder f18037c;
    private HeaderHolder d;
    private ChatFriendListAdapter e;
    @BindView
    public NoDataAndLoadFailView nodataview;
    @BindView
    public RenrenPullToRefreshListView pullRefresh;
    @BindView
    public CommonTopTitleNoTrans title;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgBoxFragment$HeaderHolder.class */
    public class HeaderHolder {
        @BindView
        public ImageView iv_close;
        @BindView
        public RelativeLayout rl_hint;
        @BindView
        public TextView secretView;
        @BindView
        public View view_line;

        public HeaderHolder() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgBoxFragment$HeaderHolder_ViewBinding.class */
    public class HeaderHolder_ViewBinding implements Unbinder {
        private HeaderHolder b;

        public HeaderHolder_ViewBinding(HeaderHolder headerHolder, View view) {
            this.b = headerHolder;
            headerHolder.secretView = (TextView) Utils.a(view, R.id.tv_secreting, "field 'secretView'", TextView.class);
            headerHolder.rl_hint = (RelativeLayout) Utils.a(view, R.id.rl_hint, "field 'rl_hint'", RelativeLayout.class);
            headerHolder.view_line = Utils.a(view, R.id.view_line, "field 'view_line'");
            headerHolder.iv_close = (ImageView) Utils.a(view, 2131365207, "field 'iv_close'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            HeaderHolder headerHolder = this.b;
            if (headerHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            headerHolder.secretView = null;
            headerHolder.rl_hint = null;
            headerHolder.view_line = null;
            headerHolder.iv_close = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b() {
        this.pullRefresh.setRefreshEnabled(false);
        this.pullRefresh.p();
        this.f18036a = (ListView) this.pullRefresh.getRefreshableView();
        View inflate = View.inflate(getActivity(), R.layout.layout_msg_box_list_head_view, null);
        this.b = inflate;
        this.f18036a.addHeaderView(inflate);
        HeaderHolder headerHolder = new HeaderHolder();
        this.d = headerHolder;
        this.f18037c = ButterKnife.a(headerHolder, this.b);
        this.nodataview.setNoDataImg((int) R.drawable.msg_box_no_data);
        this.nodataview.setNoDataStr((int) R.string.msg_box_no_data);
        this.d.iv_close.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgBoxFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                BluedPreferences.bJ();
                MsgBoxFragment.this.d.rl_hint.setVisibility(8);
                MsgBoxFragment.this.d.view_line.setVisibility(8);
            }
        });
        if (!BluedPreferences.bK()) {
            this.d.rl_hint.setVisibility(0);
            this.d.view_line.setVisibility(0);
            this.d.iv_close.setOnClickListener(this);
        }
        ChatFriendListAdapter chatFriendListAdapter = new ChatFriendListAdapter(getFragmentActive(), this);
        this.e = chatFriendListAdapter;
        this.f18036a.setAdapter((ListAdapter) chatFriendListAdapter);
        this.f18036a.setOnItemClickListener(((MsgBoxPresent) j()).p());
        this.f18036a.setOnItemLongClickListener(((MsgBoxPresent) j()).o());
        LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_SESSION_LIST, Void.class).observe(this, new Observer<Void>() { // from class: com.soft.blued.ui.msg.MsgBoxFragment.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Void r3) {
                ((MsgBoxPresent) MsgBoxFragment.this.j()).q();
            }
        });
    }

    private void c() {
        this.title.setCenterText(getString(R.string.msg_mute_box));
        this.title.setCenterTextColor(2131102254);
        this.title.a();
        this.title.setLeftImg(2131233902);
        this.title.setLeftClickListener(this);
        this.title.f();
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        c();
        b();
    }

    public void a(String str, List list) {
        super.a(str, list);
        if (!str.equals("session_list") || list == null) {
            return;
        }
        MvpUtils.a(list, SessionModel.class, new MvpUtils.DataListHandler<SessionModel>() { // from class: com.soft.blued.ui.msg.MsgBoxFragment.3
            public void a() {
                MsgBoxFragment.this.nodataview.setVisibility(0);
                MsgBoxFragment.this.nodataview.a();
                MsgBoxFragment.this.e.a((List<SessionModel>) new ArrayList(), false);
                MsgBoxFragment.this.e.notifyDataSetChanged();
            }

            public void a(List<SessionModel> list2) {
                MsgBoxFragment.this.nodataview.setVisibility(8);
                MsgBoxFragment.this.e.a(list2, false);
                MsgBoxFragment.this.e.notifyDataSetChanged();
            }
        });
    }

    public void af_() {
        super.af_();
        this.f18036a = null;
        Unbinder unbinder = this.f18037c;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    public int g() {
        return R.layout.fragment_msg_box;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id != 2131365207) {
        } else {
            this.d.rl_hint.setVisibility(8);
            this.d.view_line.setVisibility(8);
            BluedPreferences.bJ();
        }
    }

    public void onStart() {
        super.onStart();
        ((MsgBoxPresent) j()).m();
    }

    public void onStop() {
        super.onStop();
        ((MsgBoxPresent) j()).n();
    }
}
