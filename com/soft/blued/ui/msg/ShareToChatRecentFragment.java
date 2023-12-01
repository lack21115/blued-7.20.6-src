package com.soft.blued.ui.msg;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.app.share.ShareUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.StableSessionListListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ShareToChatRecentFragment.class */
public class ShareToChatRecentFragment extends PreloadFragment {
    private ShareToMsgEntity B;
    private String C;
    private Context j;
    private ChatListAdapter k;
    private ShareToSessionListListener l;
    private View m;
    private NoDataAndLoadFailView n;
    private SearchEditText o;
    private FrameLayout p;
    private ProgressBar q;
    private RecyclerView r;
    private SearchView s;
    private PullToRefreshRecyclerView t;
    private KeyboardListenLinearLayout u;
    private List<SessionModel> v;
    private List<SessionModel> w;
    private List<SessionModel> x;
    private boolean y = false;
    private boolean z = true;
    private int A = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ShareToChatRecentFragment$ChatListAdapter.class */
    public class ChatListAdapter extends BaseQuickAdapter<SessionModel, BaseViewHolder> {
        private TextView b;

        /* renamed from: c  reason: collision with root package name */
        private ShapeTextView f31918c;
        private ImageView d;
        private ImageView e;
        private int f;
        private int g;

        private ChatListAdapter() {
            super(R.layout.item_share_to, null);
            this.f = DensityUtils.a(ShareToChatRecentFragment.this.j, 9.0f);
            this.g = DensityUtils.a(ShareToChatRecentFragment.this.j, 6.0f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, SessionModel sessionModel) {
            if (baseViewHolder == null || sessionModel == null) {
                return;
            }
            this.b = (TextView) baseViewHolder.getView(2131372046);
            this.f31918c = (ShapeTextView) baseViewHolder.getView(R.id.tv_group_icon);
            this.d = (ImageView) baseViewHolder.getView(R.id.riv_avatar);
            this.e = (ImageView) baseViewHolder.getView(2131364726);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.b.getLayoutParams();
            if (sessionModel.sessionType == 3) {
                this.f31918c.setVisibility(0);
                layoutParams.setMargins(this.g, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.f31918c.setVisibility(8);
                layoutParams.setMargins(this.f, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            }
            this.b.setText(ShareToChatRecentFragment.this.a(sessionModel));
            UserBasicModel userBasicModel = new UserBasicModel();
            userBasicModel.vip_grade = sessionModel.vipGrade;
            userBasicModel.is_vip_annual = sessionModel.vipAnnual;
            userBasicModel.vip_exp_lvl = sessionModel.vipExpLvl;
            if (sessionModel.sessionType == 3) {
                userBasicModel.vip_grade = 0;
                userBasicModel.is_vip_annual = 0;
                userBasicModel.vip_exp_lvl = 0;
            }
            UserRelationshipUtils.a(this.mContext, this.b, userBasicModel);
            UserRelationshipUtils.a(this.e, userBasicModel);
            ImageLoader.a(ShareToChatRecentFragment.this.getFragmentActive(), sessionModel.avatar).b(2131237310).c().a(this.d);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ShareToChatRecentFragment$ShareToSessionListListener.class */
    class ShareToSessionListListener extends StableSessionListListener {
        private ShareToSessionListListener() {
        }

        @Override // com.blued.android.chat.StableSessionListListener
        public void onUISessionDataChanged(List<SessionModel> list) {
            if (list == null) {
                list = new ArrayList();
            } else {
                ChatHelperV4.b(list);
            }
            if (BluedConstant.f28239a) {
                Iterator<SessionModel> it = list.iterator();
                while (it.hasNext()) {
                    SessionModel next = it.next();
                    if (next.sessionType == 3) {
                        it.remove();
                    } else if (next.sessionType == 1 && next.sessionId == 2) {
                        it.remove();
                    }
                }
            }
            Iterator<SessionModel> it2 = list.iterator();
            while (it2.hasNext()) {
                SessionModel next2 = it2.next();
                if (next2.sessionType == 2 && next2.sessionId < 0) {
                    it2.remove();
                }
            }
            ShareToChatRecentFragment.this.w = list;
            ShareToChatRecentFragment.this.v.clear();
            ShareToChatRecentFragment.this.v.addAll(list);
            if (ShareToChatRecentFragment.this.w.size() > 0) {
                ShareToChatRecentFragment.this.k.setNewData(ShareToChatRecentFragment.this.v);
            } else {
                ShareToChatRecentFragment.this.k.setNewData(null);
            }
        }
    }

    public static ShareToChatRecentFragment a(Bundle bundle) {
        ShareToChatRecentFragment shareToChatRecentFragment = new ShareToChatRecentFragment();
        if (bundle != null) {
            shareToChatRecentFragment.setArguments(bundle);
        }
        return shareToChatRecentFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(SessionModel sessionModel) {
        if (sessionModel == null) {
            return "";
        }
        SessionSettingModel sessionSettingModel = (SessionSettingModel) sessionModel.sessionSettingModel;
        String sessinoNote = sessionSettingModel != null ? sessionSettingModel.getSessinoNote() : "";
        if (TextUtils.isEmpty(sessinoNote)) {
            if (TextUtils.isEmpty(sessionModel.nickName)) {
                return sessionModel.sessionId + "";
            }
            return sessionModel.nickName;
        }
        return sessinoNote;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (!this.z) {
            i();
        }
        List<SessionModel> list = this.w;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.x.clear();
        for (SessionModel sessionModel : this.w) {
            SessionSettingModel sessionSettingModel = (SessionSettingModel) sessionModel.sessionSettingModel;
            if ((!TextUtils.isEmpty(sessionModel.nickName) && sessionModel.nickName.contains(str)) || ((!TextUtils.isEmpty(sessionModel.lastMsgFromNickname) && sessionModel.lastMsgFromNickname.contains(str)) || ((!TextUtils.isEmpty(sessionModel.lastMsgContent) && sessionModel.lastMsgContent.contains(str)) || (sessionSettingModel != null && !TextUtils.isEmpty(sessionSettingModel.getSessinoNote()) && sessionSettingModel.getSessinoNote().contains(str))))) {
                this.x.add(sessionModel);
            }
        }
        int size = this.k.getData().size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size - 1) {
                break;
            }
            this.k.remove(1);
            i = i2 + 1;
        }
        this.k.addData((Collection) this.x);
        if (this.k.getData().size() > 0) {
            this.k.remove(0);
        }
    }

    private boolean h() {
        return TextUtils.isEmpty(this.o.getText().toString());
    }

    private void i() {
        if (h()) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
    }

    @Override // com.blued.android.framework.activity.PreloadFragment
    public void a(View view) {
        this.x = new ArrayList();
        this.v = new ArrayList();
        this.w = new ArrayList();
        View inflate = LayoutInflater.from(this.j).inflate(R.layout.fragment_share_to_single, (ViewGroup) view, true);
        SearchView searchView = (SearchView) LayoutInflater.from(this.j).inflate(R.layout.layout_msg_search_view, (ViewGroup) null);
        this.s = searchView;
        searchView.setDelaymillis(0L);
        this.o = this.s.getEditView();
        this.p = (FrameLayout) inflate.findViewById(2131363911);
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(2131368973);
        this.q = progressBar;
        progressBar.setVisibility(8);
        this.m = inflate.findViewById(2131366095);
        PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView) inflate.findViewById(R.id.ptrrv_list);
        this.t = pullToRefreshRecyclerView;
        pullToRefreshRecyclerView.setRefreshEnabled(false);
        this.r = this.t.getRefreshableView();
        KeyboardListenLinearLayout keyboardListenLinearLayout = (KeyboardListenLinearLayout) inflate.findViewById(2131366092);
        this.u = keyboardListenLinearLayout;
        super.a(keyboardListenLinearLayout);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.j);
        this.k = new ChatListAdapter();
        this.r.setLayoutManager(linearLayoutManager);
        this.k.addHeaderView(this.s);
        this.k.setHeaderAndEmpty(true);
        this.r.setAdapter(this.k);
        this.k.bindToRecyclerView(this.r);
        this.k.disableLoadMoreIfNotFullPage();
        this.l = new ShareToSessionListListener();
        ChatManager.getInstance().registerSessionListener(this.l);
        this.r.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.soft.blued.ui.msg.ShareToChatRecentFragment.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ShareToChatRecentFragment.this.r.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (ShareToChatRecentFragment.this.y) {
                    return;
                }
                ShareToChatRecentFragment.this.y = true;
                ShareToChatRecentFragment.this.n = new NoDataAndLoadFailView(ShareToChatRecentFragment.this.j);
                ShareToChatRecentFragment.this.n.setNoDataImg(2131233626);
                ShareToChatRecentFragment.this.n.setNoDataStr(2131892286);
                ShareToChatRecentFragment.this.n.a();
                ShareToChatRecentFragment.this.k.setEmptyView(ShareToChatRecentFragment.this.n);
            }
        });
        this.k.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.msg.ShareToChatRecentFragment.2
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                SessionModel sessionModel;
                String a2;
                if (baseQuickAdapter.getData() == null || baseQuickAdapter.getData().size() <= i || i < 0 || (sessionModel = (SessionModel) baseQuickAdapter.getData().get(i)) == null) {
                    return;
                }
                int i2 = ShareToChatRecentFragment.this.A;
                if (i2 != 0) {
                    if (i2 != 1) {
                        return;
                    }
                    EventTrackFeed.e(FeedProtos.Event.CIRCLE_USER_MANAGE_INVITE_USER, ShareToChatRecentFragment.this.C, String.valueOf(sessionModel.sessionId));
                    CircleMethods.a(ShareToChatRecentFragment.this.getFragmentActive(), ShareToChatRecentFragment.this.C, String.valueOf(sessionModel.sessionId), true);
                    return;
                }
                if (sessionModel.sessionType == 3) {
                    a2 = "[" + ShareToChatRecentFragment.this.getResources().getString(R.string.group) + "]" + ShareToChatRecentFragment.this.a(sessionModel);
                } else {
                    a2 = ShareToChatRecentFragment.this.a(sessionModel);
                }
                ShareUtils.a().a(ShareToChatRecentFragment.this.j, sessionModel.sessionId, sessionModel.sessionType, sessionModel.nickName, sessionModel.avatar, sessionModel.vBadge, sessionModel.vipGrade, sessionModel.vipAnnual, sessionModel.vipExpLvl, sessionModel.hideVipLook, ShareToChatRecentFragment.this.B, a2, ShareToChatRecentFragment.this.B.gid);
            }
        });
        this.s.setOnSearchInfoListener(new SearchView.OnSearchInfoListener() { // from class: com.soft.blued.ui.msg.ShareToChatRecentFragment.3
            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void a() {
                KeyboardUtils.a((Activity) ShareToChatRecentFragment.this.j);
            }

            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void a(String str) {
                ShareToChatRecentFragment.this.a(str);
            }

            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void b() {
            }
        });
        this.m.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.msg.ShareToChatRecentFragment.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    KeyboardUtils.a((Activity) ShareToChatRecentFragment.this.j);
                    return true;
                }
                return true;
            }
        });
    }

    @Override // com.blued.android.framework.activity.keyboardpage.KeyBoardFragment
    public void j_(int i) {
        if (i != -3) {
            if (i != -2) {
                return;
            }
            this.z = true;
            if (h()) {
                this.k.setEmptyView(this.n);
                this.k.setNewData(this.v);
            }
            this.m.setVisibility(8);
            this.s.a(false);
            return;
        }
        this.z = false;
        i();
        this.p.setFocusable(false);
        this.p.setFocusableInTouchMode(false);
        SearchView searchView = this.s;
        if (searchView != null) {
            searchView.a(true);
        }
        NoDataAndLoadFailView noDataAndLoadFailView = this.n;
        if (noDataAndLoadFailView != null) {
            this.k.setEmptyView(noDataAndLoadFailView);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.j = context;
        if (getArguments() != null) {
            this.A = getArguments().getInt("share_type");
            this.B = (ShareToMsgEntity) getArguments().get("share_entity");
            this.C = getArguments().getString("circle_id");
        }
    }
}
