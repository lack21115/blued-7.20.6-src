package com.soft.blued.ui.yy_room.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.framework.view.pulltorefresh.RecyclerViewLoadMoreView;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.live_china.liveForMsg.model.LiveMsgShareEntity;
import com.blued.android.module.live_china.msg.ILiveMsgSender;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.FriendsModel;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.Collection;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/yy_room/fragment/InviteFriendsFragment.class */
public class InviteFriendsFragment extends PreloadFragment {
    private final int j = 20;
    private int k = 1;
    private boolean l;
    private boolean m;
    private Context n;
    private FriendListAdapter o;
    private NoDataAndLoadFailView p;
    private FrameLayout q;
    private ProgressBar r;
    private RecyclerView s;
    private PullToRefreshRecyclerView t;
    private FriendsModel u;
    private ShareToMsgEntity v;
    private String w;
    private String x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/yy_room/fragment/InviteFriendsFragment$FriendListAdapter.class */
    public class FriendListAdapter extends BaseQuickAdapter<BluedBlackList, BaseViewHolder> {
        private TextView b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f34689c;
        private ShapeTextView d;

        private FriendListAdapter() {
            super(R.layout.item_invite_to, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(final BluedBlackList bluedBlackList, final int i) {
            LiveHttpUtils.b(InviteFriendsFragment.this.v.sessionId + "", new BluedUIHttpResponse<BluedEntityA<LiveMsgShareEntity>>(InviteFriendsFragment.this.getFragmentActive()) { // from class: com.soft.blued.ui.yy_room.fragment.InviteFriendsFragment.FriendListAdapter.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<LiveMsgShareEntity> bluedEntityA) {
                    if (bluedEntityA == null || !bluedEntityA.hasData()) {
                        return;
                    }
                    LiveMsgShareEntity singleData = bluedEntityA.getSingleData();
                    Gson f = AppInfo.f();
                    singleData.copywriting = InviteFriendsFragment.this.v.title;
                    singleData.room_type = StringUtils.a(InviteFriendsFragment.this.x, 1);
                    singleData.description = InviteFriendsFragment.this.w;
                    String json = f.toJson(singleData);
                    Logger.e("invite", "invite friends extra: " + json);
                    ChatHelperV4.a().a(InviteFriendsFragment.this.a(StringUtils.a(bluedBlackList.uid, 0L), (short) 2, (short) 210, FriendListAdapter.this.mContext.getResources().getString(R.string.yy_share_to_chat), json), false);
                    YYRoomInfoManager.e().b().addInvited(bluedBlackList.uid);
                    InviteFriendsFragment.this.o.notifyItemChanged(i);
                }
            }, InviteFriendsFragment.this.getFragmentActive());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(final BaseViewHolder baseViewHolder, final BluedBlackList bluedBlackList) {
            if (baseViewHolder == null || bluedBlackList == null) {
                return;
            }
            this.b = (TextView) baseViewHolder.getView(2131372046);
            this.f34689c = (ImageView) baseViewHolder.getView(R.id.riv_avatar);
            this.d = (ShapeTextView) baseViewHolder.getView(R.id.invite_to);
            if (YYRoomInfoManager.e().b().isInvited(bluedBlackList.uid)) {
                this.d.setEnabled(false);
                this.d.setText("已邀请");
                ShapeHelper.a((ShapeHelper.ShapeView) this.d, 2131101615);
                ShapeHelper.a(this.d, 2131101874, 2131101874);
            } else {
                this.d.setEnabled(true);
                this.d.setText("邀请");
                ShapeHelper.a((ShapeHelper.ShapeView) this.d, 2131102478);
                ShapeHelper.a(this.d, 2131101446, 2131101533);
            }
            this.b.setText(InviteFriendsFragment.this.a(bluedBlackList));
            ImageLoader.a(InviteFriendsFragment.this.getFragmentActive(), bluedBlackList.avatar).b(2131237310).c().a(this.f34689c);
            this.d.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.yy_room.fragment.InviteFriendsFragment.FriendListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    YYRoomModel b = YYRoomInfoManager.e().b();
                    if (b != null) {
                        EventTrackYY.l(ChatRoomProtos.Event.CHAT_ROOM_USER_INVITE_CLICK, b.room_id, b.uid, bluedBlackList.uid);
                    }
                    FriendListAdapter.this.a(bluedBlackList, baseViewHolder.getAdapterPosition());
                }
            });
        }
    }

    static /* synthetic */ int a(InviteFriendsFragment inviteFriendsFragment) {
        int i = inviteFriendsFragment.k;
        inviteFriendsFragment.k = i + 1;
        return i;
    }

    public static InviteFriendsFragment a(Bundle bundle) {
        InviteFriendsFragment inviteFriendsFragment = new InviteFriendsFragment();
        if (bundle != null) {
            inviteFriendsFragment.setArguments(bundle);
        }
        return inviteFriendsFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(BluedBlackList bluedBlackList) {
        return bluedBlackList == null ? "" : !TextUtils.isEmpty(bluedBlackList.note) ? bluedBlackList.note : !TextUtils.isEmpty(bluedBlackList.name) ? bluedBlackList.name : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluedEntityA<BluedBlackList> bluedEntityA) {
        if (bluedEntityA != null) {
            try {
                if (bluedEntityA.hasData()) {
                    this.l = false;
                    if (this.k == 1) {
                        this.o.setNewData(bluedEntityA.data);
                    } else {
                        this.o.addData((Collection) bluedEntityA.data);
                    }
                    boolean hasMore = bluedEntityA.hasMore();
                    this.m = hasMore;
                    this.o.setEnableLoadMore(hasMore);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.l = true;
        if (this.k == 1 || this.o.getData().size() <= 0) {
            return;
        }
        AppMethods.a((CharSequence) this.n.getResources().getString(2131887275));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<BluedBlackList> list) {
        if (list == null) {
            return false;
        }
        try {
            if (list.size() <= 0) {
                return false;
            }
            this.u.data.clear();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    return true;
                }
                this.u.data.add((BluedBlackList) list.get(i2).clone());
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    static /* synthetic */ int f(InviteFriendsFragment inviteFriendsFragment) {
        int i = inviteFriendsFragment.k;
        inviteFriendsFragment.k = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Context context = this.n;
        BluedUIHttpResponse<BluedEntityA<BluedBlackList>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<BluedBlackList>>(getFragmentActive()) { // from class: com.soft.blued.ui.yy_room.fragment.InviteFriendsFragment.4

            /* renamed from: a  reason: collision with root package name */
            boolean f34687a = false;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedBlackList> bluedEntityA) {
                this.f34687a = false;
                InviteFriendsFragment.this.a(bluedEntityA);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                if (InviteFriendsFragment.this.k == 1 && InviteFriendsFragment.this.o.getData().size() == 0) {
                    InviteFriendsFragment.this.p.b();
                    InviteFriendsFragment.this.o.setEmptyView(InviteFriendsFragment.this.p);
                    InviteFriendsFragment.this.o.setNewData(null);
                } else if (InviteFriendsFragment.this.k != 1) {
                    InviteFriendsFragment.this.o.loadMoreFail();
                }
                if (InviteFriendsFragment.this.k != 1) {
                    InviteFriendsFragment.f(InviteFriendsFragment.this);
                }
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                InviteFriendsFragment.this.r.setVisibility(8);
                InviteFriendsFragment.this.t.j();
                if (!InviteFriendsFragment.this.l && !this.f34687a) {
                    if (InviteFriendsFragment.this.m) {
                        InviteFriendsFragment.this.o.loadMoreComplete();
                    } else {
                        InviteFriendsFragment.this.o.loadMoreEnd();
                    }
                }
                if (InviteFriendsFragment.this.l && !this.f34687a) {
                    if (InviteFriendsFragment.this.k != 1) {
                        InviteFriendsFragment.f(InviteFriendsFragment.this);
                    } else {
                        InviteFriendsFragment.this.p.a();
                        InviteFriendsFragment.this.o.setEmptyView(InviteFriendsFragment.this.p);
                        InviteFriendsFragment.this.o.setNewData(null);
                    }
                    InviteFriendsFragment.this.o.loadMoreEnd();
                }
                InviteFriendsFragment inviteFriendsFragment = InviteFriendsFragment.this;
                inviteFriendsFragment.a(inviteFriendsFragment.o.getData());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                InviteFriendsFragment.this.l = false;
                InviteFriendsFragment.this.m = false;
            }
        };
        MineHttpUtils.b(context, bluedUIHttpResponse, this.k + "", BaseWrapper.ENTER_ID_SYSTEM_HELPER, getFragmentActive());
    }

    public ChattingModel a(long j, short s, short s2, String str, String str2) {
        return ChatHelper.getChattingModelForSendmsg(j, s2, str, ILiveMsgSender.e(), str2, s);
    }

    @Override // com.blued.android.framework.activity.PreloadFragment
    public void a(View view) {
        this.u = new FriendsModel();
        View inflate = LayoutInflater.from(this.n).inflate(R.layout.fragment_share_to_single, (ViewGroup) view, true);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(2131363911);
        this.q = frameLayout;
        frameLayout.setBackgroundResource(2131101478);
        this.r = (ProgressBar) inflate.findViewById(2131368973);
        PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView) inflate.findViewById(R.id.ptrrv_list);
        this.t = pullToRefreshRecyclerView;
        pullToRefreshRecyclerView.setRefreshEnabled(true);
        this.s = this.t.getRefreshableView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.n);
        this.o = new FriendListAdapter();
        this.s.setLayoutManager(linearLayoutManager);
        this.o.setHeaderAndEmpty(true);
        this.o.setLoadMoreView(new RecyclerViewLoadMoreView());
        this.s.setAdapter(this.o);
        this.o.bindToRecyclerView(this.s);
        this.o.disableLoadMoreIfNotFullPage();
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.n);
        this.p = noDataAndLoadFailView;
        noDataAndLoadFailView.setBackgroundColorRes(2131101478);
        this.p.setNoDataTextColor(2131102478);
        this.p.setNoDataStr(2131892287);
        this.p.setNoDataImg(2131233641);
        this.p.d();
        this.d = (KeyboardListenLinearLayout) inflate.findViewById(2131366092);
        super.a(this.d);
        this.o.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.yy_room.fragment.InviteFriendsFragment.1
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                InviteFriendsFragment.a(InviteFriendsFragment.this);
                InviteFriendsFragment.this.h();
            }
        }, this.s);
        this.t.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>() { // from class: com.soft.blued.ui.yy_room.fragment.InviteFriendsFragment.2
            @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase.OnRefreshListener
            public void onRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
                InviteFriendsFragment.this.k = 1;
                InviteFriendsFragment.this.h();
            }
        });
        h();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        LiveEventBus.get("share_to_private_chat", String.class).observe(this, new Observer<String>() { // from class: com.soft.blued.ui.yy_room.fragment.InviteFriendsFragment.3
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                Logger.e("invite", "event bus onChanged ...");
                if (TextUtils.isEmpty(str) || InviteFriendsFragment.this.o == null) {
                    return;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= InviteFriendsFragment.this.o.getItemCount()) {
                        return;
                    }
                    BluedBlackList item = InviteFriendsFragment.this.o.getItem(i2);
                    if (item != null && TextUtils.equals(item.uid, str)) {
                        Logger.e("invite", "event bus uid: " + item.uid);
                        InviteFriendsFragment.this.o.notifyItemChanged(i2);
                        return;
                    }
                    i = i2 + 1;
                }
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.n = context;
        if (getArguments() != null) {
            this.v = (ShareToMsgEntity) getArguments().get("share_entity");
            this.w = getArguments().getString("share_yy_type_name");
            this.x = getArguments().getString("share_yy_type_id");
        }
    }
}
