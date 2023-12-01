package com.soft.blued.ui.live.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.expressad.d.a.b;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.fragment.BaseListFragment;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.google.gson.reflect.TypeToken;
import com.soft.blued.R;
import com.soft.blued.ui.live.fragment.RequestAnchorLiveListFragment;
import com.soft.blued.ui.live.model.RequestAnchorLiveExtra;
import com.soft.blued.ui.live.model.RequestAnchorLiveModel;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import java.lang.reflect.Type;
import java.util.Date;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/RequestAnchorLiveListFragment.class */
public class RequestAnchorLiveListFragment extends BaseListFragment<RequestAnchorLiveModel, RequestAnchorLiveExtra> {
    private View g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private View l;
    private ImageView m;
    private View n;
    private View o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.live.fragment.RequestAnchorLiveListFragment$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/RequestAnchorLiveListFragment$1.class */
    public class AnonymousClass1 extends CommonAdapter<RequestAnchorLiveModel> {
        AnonymousClass1(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(RequestAnchorLiveModel requestAnchorLiveModel, View view) {
            Tracker.onClick(view);
            UserInfoFragmentNew.a(this.f10437a, requestAnchorLiveModel.uid, "");
        }

        @Override // com.blued.android.module.common.adapter.CommonAdapter
        public void a(CommonAdapter.ViewHolder viewHolder, final RequestAnchorLiveModel requestAnchorLiveModel, int i) {
            viewHolder.e(R.id.item_request_live_avatar, requestAnchorLiveModel.avatar).a(R.id.item_request_live_name, requestAnchorLiveModel.name);
            BitmapUtils.a(RequestAnchorLiveListFragment.this.getContext(), (ImageView) viewHolder.a(R.id.item_request_live_rich_level), requestAnchorLiveModel.rich_level);
            long j = requestAnchorLiveModel.time * 1000;
            if (!TimeAndDateUtils.g(j)) {
                viewHolder.a(R.id.item_request_live_time, TimeAndDateUtils.f10913a.get().format(new Date(j)));
            } else if (TimeAndDateUtils.f(j)) {
                viewHolder.a(R.id.item_request_live_time, TimeAndDateUtils.f.get().format(new Date(j)));
            } else if (TimeAndDateUtils.h(j)) {
                viewHolder.a(R.id.item_request_live_time, this.f10437a.getResources().getString(R.string.biao_msg_yesterday));
            } else {
                viewHolder.a(R.id.item_request_live_time, TimeAndDateUtils.g.get().format(new Date(j)));
            }
            if (LiveDataManager.a().h()) {
                viewHolder.b(R.id.item_request_live_gift_layout, 0);
                ImageView imageView = (ImageView) viewHolder.a(R.id.item_request_live_gift_iv);
                if (requestAnchorLiveModel.status == 0 || requestAnchorLiveModel.goods_info == null) {
                    imageView.setVisibility(8);
                    viewHolder.b(R.id.item_request_live_gift_count, 8);
                } else {
                    viewHolder.a(imageView, requestAnchorLiveModel.goods_info.image_static);
                    imageView.setVisibility(0);
                    viewHolder.b(R.id.item_request_live_gift_count, 0);
                }
                if (requestAnchorLiveModel.status == 1) {
                    viewHolder.a(R.id.item_request_live_gift_state, BluedSkinUtils.a(RequestAnchorLiveListFragment.this.getContext(), 2131102264), "(开播后收到礼物)");
                } else if (requestAnchorLiveModel.status == 2) {
                    viewHolder.a(R.id.item_request_live_gift_state, BluedSkinUtils.a(RequestAnchorLiveListFragment.this.getContext(), 2131102264), "(已领取)");
                } else if (requestAnchorLiveModel.status == 3) {
                    viewHolder.a(R.id.item_request_live_gift_state, BluedSkinUtils.a(RequestAnchorLiveListFragment.this.getContext(), 2131102264), "(已退回)");
                } else {
                    viewHolder.a(R.id.item_request_live_gift_state, BluedSkinUtils.a(RequestAnchorLiveListFragment.this.getContext(), 2131102263), "求开播");
                }
            } else {
                viewHolder.b(R.id.item_request_live_gift_layout, 8);
            }
            viewHolder.a().setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$RequestAnchorLiveListFragment$1$X0wL2PyCb62--T2E-DLNeOlGxo0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RequestAnchorLiveListFragment.AnonymousClass1.this.a(requestAnchorLiveModel, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        Tracker.onClick(view);
        this.l.setVisibility(0);
        ((FrameLayout.LayoutParams) this.m.getLayoutParams()).rightMargin = ((AppInfo.l / 3) / 2) - DisplayUtil.a(AppInfo.d(), 30.0f);
        ImageLoader.a(getFragmentActive(), (int) R.drawable.request_anchor_live_qa_tips).a(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        Tracker.onClick(view);
        this.l.setVisibility(8);
    }

    private void d() {
        this.f10817a.f();
        this.f10817a.setCenterText("求开播");
        this.f10817a.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$RequestAnchorLiveListFragment$fiSFqh3sZO6FA5_81z7B74tdd-4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RequestAnchorLiveListFragment.this.d(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        Tracker.onClick(view);
        getActivity().finish();
    }

    private void e() {
        View inflate = this.mLayoutInflater.inflate(R.layout.request_anchor_live_header, (ViewGroup) null);
        this.g = inflate;
        this.h = (TextView) inflate.findViewById(R.id.request_anchor_live_header_time);
        this.i = (TextView) this.g.findViewById(R.id.request_anchor_live_header_time_unit);
        this.j = (TextView) this.g.findViewById(R.id.request_anchor_live_header_count);
        this.k = (TextView) this.g.findViewById(R.id.request_anchor_live_header_reward);
        this.g.findViewById(R.id.request_anchor_live_header_reward_question).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$RequestAnchorLiveListFragment$afdBG1XGmufKMCYDrxT61eOaI7E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RequestAnchorLiveListFragment.this.b(view);
            }
        });
        this.n = this.g.findViewById(R.id.request_anchor_live_header_reward_divider);
        this.o = this.g.findViewById(R.id.request_anchor_live_header_reward_layout);
        if (LiveDataManager.a().h()) {
            this.n.setVisibility(0);
            this.o.setVisibility(0);
        } else {
            this.n.setVisibility(8);
            this.o.setVisibility(8);
        }
        this.f10818c.addHeaderView(this.g);
    }

    @Override // com.blued.android.module.common.fragment.BaseListFragment
    public CommonAdapter<RequestAnchorLiveModel> a() {
        return new AnonymousClass1(R.layout.item_request_anchor_live);
    }

    public void a(View view) {
        Tracker.onClick(view);
        LiveRoomHttpUtils.e(new BluedUIHttpResponse<BluedEntityA<BluedLiveState>>(getFragmentActive()) { // from class: com.soft.blued.ui.live.fragment.RequestAnchorLiveListFragment.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLiveState> bluedEntityA) {
                LiveUtils.a(RequestAnchorLiveListFragment.this.getContext(), bluedEntityA.getSingleData());
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), getFragmentActive());
        EventTrackLive.a(LiveProtos.Event.LIVE_ANCHOR_PLEASE_PAGE_START_CLICK);
    }

    @Override // com.blued.android.module.common.fragment.BaseListFragment
    public Type b() {
        return new TypeToken<BluedEntity<RequestAnchorLiveModel, RequestAnchorLiveExtra>>() { // from class: com.soft.blued.ui.live.fragment.RequestAnchorLiveListFragment.3
        }.getType();
    }

    @Override // com.blued.android.module.common.fragment.BaseListFragment
    public void b(BluedEntity<RequestAnchorLiveModel, RequestAnchorLiveExtra> bluedEntity) {
        super.b(bluedEntity);
        if (bluedEntity == null || bluedEntity.extra == null) {
            return;
        }
        this.j.setText(String.valueOf(bluedEntity.extra.count));
        long currentTimeMillis = (System.currentTimeMillis() - (bluedEntity.extra.last_live_time * 1000)) / 1000;
        if (currentTimeMillis < b.P) {
            this.h.setText(String.valueOf(currentTimeMillis / 60));
            this.i.setText("分钟");
        } else if (currentTimeMillis < 86400) {
            this.h.setText(String.valueOf(currentTimeMillis / b.P));
            this.i.setText("小时");
        } else {
            this.h.setText(String.valueOf(currentTimeMillis / 86400));
            this.i.setText("天");
        }
        this.k.setText(String.valueOf(bluedEntity.extra.rewardCount));
    }

    @Override // com.blued.android.module.common.fragment.BaseListFragment
    public String c() {
        return BluedHttpUrl.q() + "/live/request/list";
    }

    @Override // com.blued.android.module.common.fragment.BaseListFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        d();
        e();
        this.rootView.findViewById(R.id.request_anchor_live_start).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$n_0m8zBKenfdzvrqtJJKYDpp94Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RequestAnchorLiveListFragment.this.a(view);
            }
        });
        EventTrackLive.a(LiveProtos.Event.LIVE_ANCHOR_PLEASE_PAGE_SHOW);
        this.l = this.rootView.findViewById(R.id.request_anchor_live_qa_layout);
        this.m = (ImageView) this.rootView.findViewById(R.id.request_anchor_live_qa_tips);
        this.l.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$RequestAnchorLiveListFragment$RB-cxUzwbj9dY3RvtGZcYH2UuWY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RequestAnchorLiveListFragment.this.c(view);
            }
        });
    }

    @Override // com.blued.android.module.common.fragment.BaseListFragment, com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        return R.layout.fragment_request_anchor_list;
    }
}
