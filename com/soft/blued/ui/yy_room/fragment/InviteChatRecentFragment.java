package com.soft.blued.ui.yy_room.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.StableSessionListListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.live_china.liveForMsg.model.LiveMsgShareEntity;
import com.blued.android.module.live_china.msg.ILiveMsgSender;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/yy_room/fragment/InviteChatRecentFragment.class */
public class InviteChatRecentFragment extends PreloadFragment {
    private Context j;
    private ChatListAdapter k;
    private ShareToSessionListListener l;
    private View m;
    private NoDataAndLoadFailView n;
    private ProgressBar o;
    private RecyclerView p;
    private PullToRefreshRecyclerView q;
    private KeyboardListenLinearLayout r;
    private FrameLayout s;
    private boolean t = false;
    private int u = 0;
    private ShareToMsgEntity v;
    private String w;
    private String x;
    private List<SessionModel> y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/yy_room/fragment/InviteChatRecentFragment$ChatListAdapter.class */
    public class ChatListAdapter extends BaseQuickAdapter<SessionModel, BaseViewHolder> {
        private TextView b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f20987c;
        private ShapeTextView d;

        private ChatListAdapter() {
            super(R.layout.item_invite_to, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(final UserBasicModel userBasicModel, final int i) {
            LiveHttpUtils.b(InviteChatRecentFragment.this.v.sessionId + "", (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<LiveMsgShareEntity>>(InviteChatRecentFragment.this.getFragmentActive()) { // from class: com.soft.blued.ui.yy_room.fragment.InviteChatRecentFragment.ChatListAdapter.2
                /* JADX INFO: Access modifiers changed from: protected */
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<LiveMsgShareEntity> bluedEntityA) {
                    if (bluedEntityA == null || !bluedEntityA.hasData()) {
                        return;
                    }
                    LiveMsgShareEntity liveMsgShareEntity = (LiveMsgShareEntity) bluedEntityA.getSingleData();
                    Gson f = AppInfo.f();
                    liveMsgShareEntity.copywriting = InviteChatRecentFragment.this.v.title;
                    liveMsgShareEntity.room_type = StringUtils.a(InviteChatRecentFragment.this.x, 1);
                    liveMsgShareEntity.description = InviteChatRecentFragment.this.w;
                    String json = f.toJson(liveMsgShareEntity);
                    Logger.e("invite", "invite friends extra: " + json);
                    ChatHelperV4.a().a(InviteChatRecentFragment.this.a(StringUtils.a(userBasicModel.uid, 0L), (short) 2, (short) 210, ChatListAdapter.this.mContext.getResources().getString(R.string.yy_share_to_chat), json), false);
                    YYRoomInfoManager.e().b().addInvited(userBasicModel.uid);
                    InviteChatRecentFragment.this.k.notifyItemChanged(i);
                    LiveEventBus.get("share_to_private_chat").post(userBasicModel.uid);
                }
            }, (IRequestHost) InviteChatRecentFragment.this.getFragmentActive());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(final BaseViewHolder baseViewHolder, SessionModel sessionModel) {
            if (baseViewHolder == null || sessionModel == null) {
                return;
            }
            this.b = (TextView) baseViewHolder.getView(2131372046);
            this.f20987c = (ImageView) baseViewHolder.getView(R.id.riv_avatar);
            this.d = baseViewHolder.getView(R.id.invite_to);
            this.b.setText(InviteChatRecentFragment.this.a(sessionModel));
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b.isInvited(sessionModel.sessionId + "")) {
                this.d.setEnabled(false);
                this.d.setText("已邀请");
                ShapeHelper.a(this.d, 2131101615);
                ShapeHelper.a(this.d, 2131101874, 2131101874);
            } else {
                this.d.setText("邀请");
                this.d.setEnabled(true);
                ShapeHelper.a(this.d, 2131102478);
                ShapeHelper.a(this.d, 2131101446, 2131101533);
            }
            final UserBasicModel userBasicModel = new UserBasicModel();
            userBasicModel.vip_grade = sessionModel.vipGrade;
            userBasicModel.is_vip_annual = sessionModel.vipAnnual;
            userBasicModel.vip_exp_lvl = sessionModel.vipExpLvl;
            userBasicModel.uid = sessionModel.sessionId + "";
            ImageLoader.a(InviteChatRecentFragment.this.getFragmentActive(), sessionModel.avatar).b(2131237310).c().a(this.f20987c);
            this.d.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.yy_room.fragment.InviteChatRecentFragment.ChatListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    YYRoomModel b2 = YYRoomInfoManager.e().b();
                    if (b2 != null) {
                        EventTrackYY.l(ChatRoomProtos.Event.CHAT_ROOM_USER_INVITE_CLICK, b2.room_id, b2.uid, userBasicModel.uid);
                    }
                    ChatListAdapter.this.a(userBasicModel, baseViewHolder.getAdapterPosition());
                }
            });
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/yy_room/fragment/InviteChatRecentFragment$ShareToSessionListListener.class */
    class ShareToSessionListListener extends StableSessionListListener {
        private ShareToSessionListListener() {
        }

        public void onUISessionDataChanged(List<SessionModel> list) {
            if (list == null) {
                list = new ArrayList();
            } else {
                ChatHelperV4.c(list);
            }
            if (BluedConstant.f14549a) {
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
            if (InviteChatRecentFragment.this.y != null) {
                return;
            }
            InviteChatRecentFragment.this.y = new ArrayList();
            InviteChatRecentFragment.this.y.addAll(list);
            if (InviteChatRecentFragment.this.y.size() > 0) {
                InviteChatRecentFragment.this.k.setNewData(InviteChatRecentFragment.this.y);
            } else {
                InviteChatRecentFragment.this.k.setNewData(null);
            }
        }
    }

    public static InviteChatRecentFragment a(Bundle bundle) {
        InviteChatRecentFragment inviteChatRecentFragment = new InviteChatRecentFragment();
        if (bundle != null) {
            inviteChatRecentFragment.setArguments(bundle);
        }
        return inviteChatRecentFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(SessionModel sessionModel) {
        if (sessionModel == null) {
            return "";
        }
        SessionSettingModel sessionSettingModel = sessionModel.sessionSettingModel;
        String sessinoNote = sessionSettingModel != null ? sessionSettingModel.getSessinoNote() : "";
        if (TextUtils.isEmpty(sessinoNote)) {
            if (TextUtils.isEmpty(sessionModel.nickName)) {
                return sessionModel.sessionId + "";
            }
            return sessionModel.nickName;
        }
        return sessinoNote;
    }

    public ChattingModel a(long j, short s, short s2, String str, String str2) {
        return ChatHelper.getChattingModelForSendmsg(j, s2, str, ILiveMsgSender.e(), str2, s);
    }

    public void a(View view) {
        View inflate = LayoutInflater.from(this.j).inflate(R.layout.fragment_share_to_single, (ViewGroup) view, true);
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(2131368973);
        this.o = progressBar;
        progressBar.setVisibility(8);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(2131363911);
        this.s = frameLayout;
        frameLayout.setBackgroundResource(2131101478);
        this.m = inflate.findViewById(R.id.keyboard_view);
        PullToRefreshRecyclerView findViewById = inflate.findViewById(R.id.ptrrv_list);
        this.q = findViewById;
        findViewById.setRefreshEnabled(false);
        this.p = (RecyclerView) this.q.getRefreshableView();
        KeyboardListenLinearLayout findViewById2 = inflate.findViewById(R.id.keyboard_layout);
        this.r = findViewById2;
        super.a(findViewById2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.j);
        this.k = new ChatListAdapter();
        this.p.setLayoutManager(linearLayoutManager);
        this.k.setHeaderAndEmpty(true);
        this.p.setAdapter(this.k);
        this.k.bindToRecyclerView(this.p);
        this.k.disableLoadMoreIfNotFullPage();
        this.l = new ShareToSessionListListener();
        ChatManager.getInstance().registerSessionListener(this.l);
        this.p.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.soft.blued.ui.yy_room.fragment.InviteChatRecentFragment.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                InviteChatRecentFragment.this.p.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (InviteChatRecentFragment.this.t) {
                    return;
                }
                InviteChatRecentFragment.this.t = true;
                InviteChatRecentFragment.this.n = new NoDataAndLoadFailView(InviteChatRecentFragment.this.j);
                InviteChatRecentFragment.this.n.setBackgroundColorRes(2131101478);
                InviteChatRecentFragment.this.n.setNoDataImg(2131233626);
                InviteChatRecentFragment.this.n.setNoDataTextColor(2131102478);
                InviteChatRecentFragment.this.n.setNoDataStr(2131892286);
                InviteChatRecentFragment.this.n.a();
                InviteChatRecentFragment.this.k.setEmptyView((View) InviteChatRecentFragment.this.n);
            }
        });
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.j = context;
        if (getArguments() != null) {
            this.u = getArguments().getInt("share_type");
            this.v = (ShareToMsgEntity) getArguments().get("share_entity");
            this.w = getArguments().getString("share_yy_type_name");
            this.x = getArguments().getString("share_yy_type_id");
        }
    }
}
