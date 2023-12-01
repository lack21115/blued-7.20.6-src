package com.soft.blued.ui.live.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.fragment.LiveBaseDialogFragment;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.log.track.EventTrackLive;
import com.soft.blued.ui.live.fragment.RequestAnchorLiveRewardFragment;
import com.soft.blued.ui.live.model.RequestLiveRewardModel;
import com.soft.blued.ui.pay.BeansPrePayFragment;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/RequestAnchorLiveRewardFragment.class */
public class RequestAnchorLiveRewardFragment extends LiveBaseDialogFragment {
    private View j;
    private ImageView k;
    private GridView l;
    private CommonAdapter<RequestLiveRewardModel> m;
    private int n = 0;
    private List<RequestLiveRewardModel> o = new ArrayList();
    private String p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.live.fragment.RequestAnchorLiveRewardFragment$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/RequestAnchorLiveRewardFragment$1.class */
    public class AnonymousClass1 extends CommonAdapter<RequestLiveRewardModel> {
        AnonymousClass1(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i, View view) {
            Tracker.onClick(view);
            RequestAnchorLiveRewardFragment.this.n = i;
            notifyDataSetChanged();
        }

        public void a(CommonAdapter.ViewHolder viewHolder, RequestLiveRewardModel requestLiveRewardModel, final int i) {
            viewHolder.c((int) R.id.request_anchor_reward_gift_iv, requestLiveRewardModel.images_static).a((int) R.id.request_anchor_reward_gift_name, requestLiveRewardModel.name).a((int) R.id.request_anchor_reward_gift_price, CommonStringUtils.a(requestLiveRewardModel.beans)).b(i == RequestAnchorLiveRewardFragment.this.n ? 2131236091 : BluedPreferences.cK() ? 2131236089 : 2131236088).a(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$RequestAnchorLiveRewardFragment$1$urhdI61Qu_2h657FcHd6TrPP3Ls
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RequestAnchorLiveRewardFragment.AnonymousClass1.this.a(i, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        Tracker.onClick(view);
        if (this.n >= this.o.size()) {
            return;
        }
        final RequestLiveRewardModel requestLiveRewardModel = this.o.get(this.n);
        CommonAlertDialog.a(getActivity(), "确认支付" + requestLiveRewardModel.beans + "弯豆？", "主播开播后才会收到礼物", getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.RequestAnchorLiveRewardFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                RequestAnchorLiveRewardFragment.this.k();
                EventTrackLive.a(LiveProtos.Event.LIVE_ANCHOR_REWARD_GIFT_POP_TRUE_CLICK, RequestAnchorLiveRewardFragment.this.p, requestLiveRewardModel.goods_id, requestLiveRewardModel.beans, UserInfo.getInstance().getLoginUserInfo().getRich_level());
            }
        }, getString(R.string.common_cancel), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$RequestAnchorLiveRewardFragment$UIPoxn4XnXPdVr26YGeZVIsFO4U
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                RequestAnchorLiveRewardFragment.this.a(requestLiveRewardModel, dialogInterface, i);
            }
        }, (DialogInterface.OnDismissListener) null);
        EventTrackLive.a(LiveProtos.Event.LIVE_ANCHOR_REWARD_GIFT_SEND_CLICK, this.p, requestLiveRewardModel.goods_id, requestLiveRewardModel.beans, UserInfo.getInstance().getLoginUserInfo().getRich_level());
        EventTrackLive.a(LiveProtos.Event.LIVE_ANCHOR_REWARD_GIFT_POP_SHOW, this.p, requestLiveRewardModel.goods_id, requestLiveRewardModel.beans, UserInfo.getInstance().getLoginUserInfo().getRich_level());
    }

    public static void a(BaseFragment baseFragment, String str) {
        RequestAnchorLiveRewardFragment requestAnchorLiveRewardFragment = new RequestAnchorLiveRewardFragment();
        Bundle bundle = new Bundle();
        bundle.putString("anchor_id", str);
        requestAnchorLiveRewardFragment.setArguments(bundle);
        requestAnchorLiveRewardFragment.show(baseFragment.getFragmentManager(), requestAnchorLiveRewardFragment.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(RequestLiveRewardModel requestLiveRewardModel, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        EventTrackLive.a(LiveProtos.Event.LIVE_ANCHOR_REWARD_GIFT_POP_FALSE_CLICK, this.p, requestLiveRewardModel.goods_id, requestLiveRewardModel.beans, UserInfo.getInstance().getLoginUserInfo().getRich_level());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        Tracker.onClick(view);
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.n >= this.o.size()) {
            return;
        }
        final RequestLiveRewardModel requestLiveRewardModel = this.o.get(this.n);
        LiveHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<RequestLiveRewardModel>>(a()) { // from class: com.soft.blued.ui.live.fragment.RequestAnchorLiveRewardFragment.4
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<RequestLiveRewardModel> bluedEntityA) {
                if (bluedEntityA != null) {
                    ToastUtils.b("感谢你的激励～");
                    EventTrackLive.a(LiveProtos.Event.LIVE_ANCHOR_REWARD_GIFT_SEND_SUCCESS, RequestAnchorLiveRewardFragment.this.p, requestLiveRewardModel.goods_id, requestLiveRewardModel.beans, UserInfo.getInstance().getLoginUserInfo().getRich_level());
                }
            }

            public boolean onUIFailure(int i, String str) {
                if (i == 4221008) {
                    BeansPrePayFragment.a(RequestAnchorLiveRewardFragment.this.getActivity(), 2);
                }
                return super.onUIFailure(i, str);
            }
        }, requestLiveRewardModel.goods_id, requestLiveRewardModel.beans, this.p, a());
    }

    public int d() {
        return R.layout.fragment_request_anchor_reward;
    }

    public void e() {
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$RequestAnchorLiveRewardFragment$0ysB33MhX252eGo_dObhOfW_oXQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RequestAnchorLiveRewardFragment.this.c(view);
            }
        });
        ImageView imageView = (ImageView) this.b.findViewById(R.id.request_anchor_reward_close);
        this.k = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$RequestAnchorLiveRewardFragment$OLLTv8l__S9n7tfJ-qTGJYDQaAk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RequestAnchorLiveRewardFragment.this.b(view);
            }
        });
        this.l = (GridView) this.b.findViewById(R.id.request_anchor_reward_grid);
        CommonAdapter anonymousClass1 = new AnonymousClass1(R.layout.item_request_anchor_reward_gift);
        this.m = anonymousClass1;
        this.l.setAdapter((ListAdapter) anonymousClass1);
        this.b.findViewById(R.id.request_anchor_reward_send).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$RequestAnchorLiveRewardFragment$Jiv6fXbGoc4ex7Qw3XCLLpoYarA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RequestAnchorLiveRewardFragment.this.a(view);
            }
        });
        this.j = this.b.findViewById(R.id.request_live_reward_bg_view);
        if (BluedPreferences.cK()) {
            this.j.setBackgroundResource(R.drawable.request_live_reward_bg_dark);
            this.k.setImageResource(2131236086);
            return;
        }
        this.j.setBackgroundResource(R.drawable.request_live_reward_bg_white);
        this.k.setImageResource(2131236085);
    }

    public void f() {
        super.f();
        this.p = this.c.getString("anchor_id");
    }

    public void g() {
        super.g();
        LiveHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<RequestLiveRewardModel>>(a()) { // from class: com.soft.blued.ui.live.fragment.RequestAnchorLiveRewardFragment.2
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<RequestLiveRewardModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                RequestAnchorLiveRewardFragment.this.o.clear();
                RequestAnchorLiveRewardFragment.this.o.addAll(bluedEntityA.data);
                if (RequestAnchorLiveRewardFragment.this.o.size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) RequestAnchorLiveRewardFragment.this.l.getLayoutParams();
                    layoutParams.width = (DisplayUtil.a(AppInfo.d(), 106.0f) * RequestAnchorLiveRewardFragment.this.o.size()) + (DisplayUtil.a(AppInfo.d(), 8.0f) * (RequestAnchorLiveRewardFragment.this.o.size() - 1));
                    RequestAnchorLiveRewardFragment.this.l.setLayoutParams(layoutParams);
                }
                RequestAnchorLiveRewardFragment.this.m.a(RequestAnchorLiveRewardFragment.this.o);
            }
        }, a());
    }
}
