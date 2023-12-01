package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYClickApplyEvent;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYJudgeLevelModel;
import com.blued.android.module.yy_china.model.YYMsgRelationExtra;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSaleStageModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYStepModel;
import com.blued.android.module.yy_china.observer.SeatChangedObserver;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;
import com.blued.android.module.yy_china.view.YYMemberSaleView;
import com.blued.android.module.yy_china.view.YYSaleRelationTagView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYSeatSaleAdapter.class */
public class YYSeatSaleAdapter extends BaseConnectingAdapter<YYSeatMemberModel, BaseViewHolder> implements SeatChangedObserver {
    private TextView A;
    private TextView B;
    private ImageView C;
    private YYSaleRelationTagView D;
    private YYSaleRelationTagView E;
    private YYSaleRelationTagView F;
    private YYSaleRelationTagView G;
    private ProgressBar H;
    private YYBaseUserHeadView I;
    private YYBaseUserHeadView J;
    private ShapeTextView K;
    private ShapeTextView L;
    private StepAdapter M;
    private ArrayList<YYStepModel> N;
    private YYStepModel O;
    private YYSeatMemberModel P;
    private YYSeatMemberModel Q;
    private YYRoomModel R;
    private List<YYSaleStageModel> S;
    private ImageView T;
    private int U;
    private RecyclerView V;
    private BaseYYStudioFragment a;
    private ShapeTextView b;
    private ShapeTextView c;
    private ShapeTextView d;
    private ShapeTextView e;
    private ShapeTextView f;
    private ImageView g;
    private YYBaseUserHeadView h;
    private RelativeLayout i;
    private RelativeLayout j;
    private TextView k;
    private LinearLayout l;
    private ImageView m;
    private TextView n;
    private TextView o;
    private ShapeTextView p;
    private LinearLayout q;
    private TextView r;
    private TextView s;
    private ImageView t;
    private TextView u;
    private ShapeTextView v;
    private TextView w;
    private YYBaseUserHeadView x;
    private TextView y;
    private HashMap<Integer, YYMemberSaleView> z;

    public YYSeatSaleAdapter(Context context, BaseYYStudioFragment baseYYStudioFragment) {
        super(null);
        this.U = 0;
        this.mContext = context;
        this.a = baseYYStudioFragment;
        this.z = new HashMap<>();
        addItemType(6, R.layout.item_yy_connecting_sale_layout);
        this.R = YYRoomInfoManager.e().b();
        l();
    }

    private void a(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYSeatSaleAdapter.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
            }
        });
    }

    private void a(final View view, View view2, final YYSeatMemberModel yYSeatMemberModel, boolean z) {
        if (view2 == null) {
            return;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYSeatSaleAdapter.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                if (YYSeatSaleAdapter.this.a != null && StringUtils.a(yYSeatMemberModel.getUid(), 0) > 0) {
                    BaseYYStudioFragment baseYYStudioFragment = YYSeatSaleAdapter.this.a;
                    View view4 = view;
                    YYSeatMemberModel yYSeatMemberModel2 = yYSeatMemberModel;
                    baseYYStudioFragment.a(view4, yYSeatMemberModel2, yYSeatMemberModel2.mic_position);
                }
            }
        });
    }

    private void a(final ImageView imageView) {
        YYRoomModel yYRoomModel = this.R;
        if (yYRoomModel == null || imageView == null) {
            return;
        }
        YYRoomHttpUtils.P(yYRoomModel.room_id, new BluedUIHttpResponse<BluedEntityA<YYJudgeLevelModel>>(this.a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.adapter.YYSeatSaleAdapter.15
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYJudgeLevelModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    imageView.setVisibility(4);
                } else {
                    YYSeatSaleAdapter.this.a(bluedEntityA.getSingleData().image);
                }
            }
        }, this.a.getFragmentActive());
    }

    private void a(YYSeatMemberModel yYSeatMemberModel, int i) {
        YYMemberSaleView yYMemberSaleView = this.z.get(Integer.valueOf(i));
        if (yYMemberSaleView == null) {
            return;
        }
        yYMemberSaleView.a(yYSeatMemberModel, this.a);
    }

    private void b(YYSeatMemberModel yYSeatMemberModel) {
        if (this.V == null) {
            return;
        }
        YYBaseUserHeadView yYBaseUserHeadView = this.h;
        int i = 0;
        if (yYBaseUserHeadView != null) {
            a((View) yYBaseUserHeadView, (View) yYBaseUserHeadView, yYSeatMemberModel, true);
            this.h.a(false);
            this.h.b(false);
            this.h.a(yYSeatMemberModel, this.a.getFragmentActive());
        }
        if (this.M == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
            linearLayoutManager.setOrientation(0);
            this.M = new StepAdapter();
            this.V.setLayoutManager(linearLayoutManager);
            this.V.setAdapter(this.M);
            this.M.setNewData(this.N);
            a(0);
            a(this.T);
        }
        ImageView imageView = this.g;
        if (!YYRoomInfoManager.e().y()) {
            i = 8;
        }
        imageView.setVisibility(i);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYSeatSaleAdapter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYSeatSaleAdapter.this.a == null) {
                    return;
                }
                YYSeatSaleAdapter.this.a.u();
            }
        });
    }

    private String c(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return this.mContext.getResources().getString(YYRoomInfoManager.e().y() ? R.string.yy_sale_start : R.string.yy_up_seat);
                }
                return this.mContext.getResources().getString(R.string.yy_sale_stop);
            }
            return this.mContext.getResources().getString(R.string.yy_relation_upgrade);
        }
        return this.mContext.getResources().getString(R.string.yy_sale_start);
    }

    private void d() {
        YYRoomModel yYRoomModel = this.R;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.R.mics.isEmpty()) {
            return;
        }
        b(this.R.mics.get(0));
        YYStepModel yYStepModel = this.O;
        if (yYStepModel == null || yYStepModel.stepIndex < 3) {
            RelativeLayout relativeLayout = this.i;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            RelativeLayout relativeLayout2 = this.j;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
            f();
            return;
        }
        RelativeLayout relativeLayout3 = this.i;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(8);
        }
        RelativeLayout relativeLayout4 = this.j;
        if (relativeLayout4 != null) {
            relativeLayout4.setVisibility(0);
        }
        e();
    }

    private void e() {
        YYBaseUserHeadView yYBaseUserHeadView;
        YYBaseUserHeadView yYBaseUserHeadView2;
        YYRoomModel yYRoomModel = this.R;
        if (yYRoomModel != null && yYRoomModel.mics != null) {
            if (this.R.mics.size() >= 2) {
                this.P = this.R.mics.get(1);
            }
            if (this.R.mics.size() >= 3) {
                this.Q = this.R.mics.get(2);
            }
        }
        ImageLoader.c(this.a.getFragmentActive(), "heart_beat.png").f().g(-1).a(this.C);
        YYBaseUserHeadView yYBaseUserHeadView3 = this.I;
        a(yYBaseUserHeadView3, yYBaseUserHeadView3, this.P, h());
        YYBaseUserHeadView yYBaseUserHeadView4 = this.J;
        a(yYBaseUserHeadView4, yYBaseUserHeadView4, this.Q, g());
        if (this.P != null && (yYBaseUserHeadView2 = this.I) != null && this.A != null) {
            yYBaseUserHeadView2.a(false);
            this.I.a(this.P, this.a.getFragmentActive());
            this.A.setText(this.P.getName());
        }
        if (this.Q != null && (yYBaseUserHeadView = this.J) != null && this.B != null) {
            yYBaseUserHeadView.a(false);
            this.J.a(this.Q, this.a.getFragmentActive());
            this.B.setText(this.Q.getName());
        }
        this.K.setVisibility(0);
        if (YYRoomInfoManager.e().y()) {
            this.L.setVisibility(4);
        } else {
            YYSeatMemberModel yYSeatMemberModel = this.P;
            if (yYSeatMemberModel == null || !TextUtils.equals(yYSeatMemberModel.getUid(), YYRoomInfoManager.e().k())) {
                YYSeatMemberModel yYSeatMemberModel2 = this.Q;
                if (yYSeatMemberModel2 == null || !TextUtils.equals(yYSeatMemberModel2.getUid(), YYRoomInfoManager.e().k())) {
                    this.L.setText(this.mContext.getResources().getString(R.string.yy_support));
                    this.L.setVisibility(0);
                    this.K.setText(this.mContext.getResources().getString(R.string.yy_up_seat));
                } else {
                    this.L.setText(this.mContext.getResources().getString(R.string.yy_relation_upgrade));
                    this.L.setVisibility(0);
                    this.K.setText("取消竞拍");
                }
            } else {
                this.L.setVisibility(4);
                this.K.setText(this.mContext.getResources().getString(R.string.yy_down_seat));
            }
        }
        this.L.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYSeatSaleAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYSeatSaleAdapter.this.a == null || !YYSeatSaleAdapter.this.h()) {
                    return;
                }
                YYSeatSaleAdapter.this.a.a(true, "gift_icon", YYSeatSaleAdapter.this.P.getUid());
            }
        });
        this.K.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYSeatSaleAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYRoomInfoManager.e().y()) {
                    LiveEventBus.get("event_sale_flow").post(0);
                } else if (TextUtils.equals(YYSeatSaleAdapter.this.P.getUid(), YYRoomInfoManager.e().k())) {
                    LiveEventBus.get("event_exit_room").post("");
                } else if (TextUtils.equals(YYSeatSaleAdapter.this.Q.getUid(), YYRoomInfoManager.e().k())) {
                    LiveEventBus.get("event_exit_room").post("");
                } else {
                    LiveEventBus.get("common_apply_seat").post(new YYClickApplyEvent(YYConstants.ApplyFromSource.SaleVip, "2"));
                }
            }
        });
        j();
    }

    private void f() {
        final YYSeatMemberModel yYSeatMemberModel = this.R.mics.get(1);
        YYBaseUserHeadView yYBaseUserHeadView = this.x;
        if (yYBaseUserHeadView != null) {
            a((View) yYBaseUserHeadView, (View) yYBaseUserHeadView, yYSeatMemberModel, true);
            this.x.a(false);
            this.x.b(false);
            this.x.setNoAudienceView(this.y);
            this.x.a(yYSeatMemberModel, this.a.getFragmentActive());
        }
        this.w.setText(yYSeatMemberModel.getName());
        if (this.z != null) {
            int i = 2;
            while (true) {
                int i2 = i;
                if (i2 >= this.R.mics.size()) {
                    break;
                }
                a(this.R.mics.get(i2), i2);
                i = i2 + 1;
            }
        }
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYSeatSaleAdapter.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYSeatSaleAdapter.this.a == null) {
                    return;
                }
                LiveEventBus.get("event_sale_goods").post("");
            }
        });
        this.v.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYSeatSaleAdapter.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYSeatSaleAdapter.this.a == null) {
                    return;
                }
                LiveEventBus.get("event_sale_relation").post("");
            }
        });
        YYStepModel yYStepModel = this.O;
        if (yYStepModel == null || yYStepModel.stepIndex <= 0) {
            a();
        }
        ShapeTextView shapeTextView = this.b;
        if (shapeTextView == null || this.c == null || this.d == null || this.e == null || this.f == null) {
            return;
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYSeatSaleAdapter.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYSeatSaleAdapter.this.R != null) {
                    EventTrackYY.e(ChatRoomProtos.Event.CHAT_ROOM_AUCTION_APPLY_CLICK, YYSeatSaleAdapter.this.R.room_id);
                }
                LiveEventBus.get("common_apply_seat").post(new YYClickApplyEvent(YYConstants.ApplyFromSource.SaleVip, "2"));
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYSeatSaleAdapter.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveEventBus.get("event_exit_room").post("");
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYSeatSaleAdapter.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYSeatMemberModel yYSeatMemberModel2 = yYSeatMemberModel;
                if (yYSeatMemberModel2 != null) {
                    int i3 = 0;
                    if (StringUtils.a(yYSeatMemberModel2.getUid(), 0) > 0) {
                        int i4 = YYSeatSaleAdapter.this.O.stepIndex + 1;
                        if (i4 <= 3) {
                            i3 = i4;
                        }
                        LiveEventBus.get("event_sale_flow").post(Integer.valueOf(i3));
                        return;
                    }
                }
                ToastUtils.a("请设置拍卖人");
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYSeatSaleAdapter.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYSeatSaleAdapter.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveEventBus.get("event_join_sale").post(yYSeatMemberModel.getUid());
            }
        });
    }

    private boolean g() {
        YYSeatMemberModel yYSeatMemberModel = this.Q;
        return yYSeatMemberModel != null && StringUtils.a(yYSeatMemberModel.getUid(), 0) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        YYSeatMemberModel yYSeatMemberModel = this.P;
        return yYSeatMemberModel != null && StringUtils.a(yYSeatMemberModel.getUid(), 0) > 0;
    }

    private void i() {
        YYRoomModel yYRoomModel;
        if (this.b == null || this.c == null || this.d == null || this.e == null || this.f == null || (yYRoomModel = this.R) == null) {
            return;
        }
        YYSeatMemberModel seatMember = yYRoomModel.getSeatMember(YYRoomInfoManager.e().k());
        int i = 4;
        if (seatMember != null && YYRoomInfoManager.e().y()) {
            this.d.setVisibility(this.O.stepIndex > 0 ? 0 : 8);
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            this.e.setVisibility(4);
            this.f.setVisibility(4);
        } else if (seatMember == null || !YYRoomInfoManager.e().i()) {
            this.d.setVisibility(8);
            this.c.setVisibility(8);
            this.b.setVisibility(0);
            if (this.O.stepIndex < 1) {
                ShapeHelper.a(this.b, R.color.syc_00E0AB, R.color.syc_3883FD);
            } else {
                ShapeHelper.a(this.b, R.color.syc_tran10_FFFFFF, R.color.syc_tran10_FFFFFF);
            }
            this.e.setVisibility(this.O.stepIndex <= 0 ? 0 : 4);
            this.f.setText("参与竞拍");
            ShapeTextView shapeTextView = this.f;
            if (this.O.stepIndex >= 1) {
                i = 0;
            }
            shapeTextView.setVisibility(i);
            if (this.O.stepIndex <= 1) {
                this.f.setEnabled(false);
                ShapeHelper.a(this.f, R.color.color_adadad, R.color.syc_7C7C7C);
            } else {
                this.f.setEnabled(true);
                ShapeHelper.a(this.f, R.color.syc_00E0AB, R.color.syc_3883FD);
            }
        } else {
            this.b.setVisibility(8);
            this.d.setVisibility(8);
            this.c.setVisibility(0);
            this.e.setVisibility(4);
            if (seatMember.getItemType() == 3) {
                this.c.setText(this.mContext.getResources().getString(R.string.yy_down_seat));
                this.f.setVisibility(4);
            } else {
                this.c.setText("取消竞拍");
                this.f.setText("竞拍");
                this.f.setEnabled(true);
                ShapeHelper.a(this.f, R.color.syc_00E0AB, R.color.syc_3883FD);
                ShapeTextView shapeTextView2 = this.f;
                if (this.O.stepIndex > 1) {
                    i = 0;
                }
                shapeTextView2.setVisibility(i);
            }
        }
        this.d.setText(c(this.O.stepIndex));
        if (this.O.stepIndex == 2) {
            ShapeHelper.a(this.d, R.color.syc_FC5394, R.color.syc_F7295B);
        } else {
            ShapeHelper.a(this.d, R.color.syc_tran10_FFFFFF, R.color.syc_tran10_FFFFFF);
        }
    }

    private void j() {
        List<YYSaleStageModel> list = this.S;
        if (list != null) {
            if (list.size() > 0) {
                this.D.setTagValue(this.S.get(0).value);
                this.D.setTagName(this.S.get(0).name);
            }
            if (this.S.size() >= 1) {
                this.E.setTagValue(this.S.get(1).value);
                this.E.setTagName(this.S.get(1).name);
            }
            if (this.S.size() >= 2) {
                this.F.setTagValue(this.S.get(2).value);
                this.F.setTagName(this.S.get(2).name);
            }
            if (this.S.size() >= 3) {
                this.G.setTagValue(this.S.get(3).value);
                this.G.setTagName(this.S.get(3).name);
            }
        }
        b(this.U);
    }

    private void k() {
        YYStepModel yYStepModel = new YYStepModel();
        this.O = yYStepModel;
        yYStepModel.stepIndex = 0;
        this.O.isChecked = true;
    }

    private ArrayList<YYStepModel> l() {
        this.N = new ArrayList<>();
        String[] stringArray = this.mContext.getResources().getStringArray(R.array.yy_sale_step);
        k();
        if (stringArray == null || stringArray.length <= 0) {
            return null;
        }
        if (this.R == null) {
            return this.N;
        }
        int i = 0;
        while (i < stringArray.length) {
            String str = stringArray[i];
            YYStepModel yYStepModel = new YYStepModel();
            i++;
            yYStepModel.stepIndex = i;
            yYStepModel.name = str;
            yYStepModel.isChecked = false;
            this.N.add(yYStepModel);
        }
        return this.N;
    }

    public void a() {
        i();
        b(0);
        YYRoomModel yYRoomModel = this.R;
        if (yYRoomModel == null || this.k == null || this.r == null || this.l == null || this.q == null || this.s == null || this.o == null || this.p == null || this.n == null || this.m == null || this.v == null || this.u == null || this.t == null) {
            return;
        }
        YYSeatMemberModel seatMember = yYRoomModel.getSeatMember(YYRoomInfoManager.e().k());
        if (YYRoomInfoManager.e().y()) {
            this.k.setVisibility(0);
            this.r.setVisibility(0);
            this.l.setVisibility(8);
            this.q.setVisibility(8);
        } else if (!YYRoomInfoManager.e().i() || seatMember == null || seatMember.getItemType() != 3) {
            this.k.setVisibility(0);
            this.r.setVisibility(0);
            this.l.setVisibility(8);
            this.q.setVisibility(8);
        } else {
            this.k.setVisibility(8);
            this.r.setVisibility(8);
            this.l.setVisibility(0);
            this.o.setVisibility(0);
            this.p.setVisibility(0);
            this.n.setVisibility(8);
            this.m.setVisibility(8);
            this.q.setVisibility(0);
            this.s.setVisibility(0);
            this.v.setVisibility(0);
            this.u.setVisibility(8);
            this.t.setVisibility(8);
        }
    }

    public void a(int i) {
        if (this.N == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.N.size()) {
                break;
            }
            YYStepModel yYStepModel = this.N.get(i3);
            if (i == yYStepModel.stepIndex) {
                yYStepModel.isChecked = true;
                this.O = yYStepModel;
            } else {
                yYStepModel.isChecked = false;
            }
            i2 = i3 + 1;
        }
        this.M.notifyDataSetChanged();
        if (i == 0) {
            k();
        }
    }

    @Override // com.blued.android.module.yy_china.observer.SeatChangedObserver
    public void a(int i, int i2) {
        YYRoomModel yYRoomModel = this.R;
        if (yYRoomModel == null || yYRoomModel.mics == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.R.mics.size()) {
                break;
            }
            YYSeatMemberModel yYSeatMemberModel = this.R.mics.get(i4);
            if (yYSeatMemberModel.mic_position != i) {
                i3 = i4 + 1;
            } else if (i2 == 1) {
                yYSeatMemberModel.position_status = -1;
            } else {
                yYSeatMemberModel.position_status = i2;
            }
        }
        d();
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(int i, String str, String str2, YYImModel yYImModel) {
        YYBaseUserHeadView yYBaseUserHeadView;
        YYBaseUserHeadView yYBaseUserHeadView2;
        YYBaseUserHeadView yYBaseUserHeadView3;
        String str3 = TAG;
        Logger.e(str3, "notifyAdapter: positon-> " + i);
        if (i == 0 && (yYBaseUserHeadView3 = this.h) != null) {
            yYBaseUserHeadView3.a(this.a.getFragmentActive(), str, str2, yYImModel);
        } else if (i == 1) {
            if (this.O.stepIndex <= 2 || (yYBaseUserHeadView2 = this.I) == null) {
                this.x.a(this.a.getFragmentActive(), str, str2, yYImModel);
            } else {
                yYBaseUserHeadView2.a(this.a.getFragmentActive(), str, str2, yYImModel);
            }
        } else if (i == 2 && this.O.stepIndex > 2 && (yYBaseUserHeadView = this.J) != null) {
            yYBaseUserHeadView.a(this.a.getFragmentActive(), str, str2, yYImModel);
        } else {
            YYMemberSaleView yYMemberSaleView = this.z.get(Integer.valueOf(i));
            if (yYMemberSaleView != null) {
                yYMemberSaleView.a(this.a.getFragmentActive(), str, str2, yYImModel);
            }
        }
    }

    public void a(YYGiftModel yYGiftModel) {
        if (yYGiftModel == null || this.k == null || this.o == null || this.p == null || this.m == null || this.n == null || TextUtils.isEmpty(yYGiftModel.images_static)) {
            return;
        }
        this.k.setVisibility(8);
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        this.m.setVisibility(0);
        this.n.setVisibility(0);
        ImageLoader.a(this.a.getFragmentActive(), yYGiftModel.images_static).b(R.drawable.gift_default_icon).a(this.m);
        TextView textView = this.n;
        textView.setText(CommonStringUtils.a(yYGiftModel.beans) + this.mContext.getString(R.string.yy_gift_beans));
    }

    public void a(YYMsgRelationExtra yYMsgRelationExtra) {
        if (yYMsgRelationExtra == null || this.r == null || this.s == null || this.v == null || this.t == null || this.u == null || TextUtils.isEmpty(yYMsgRelationExtra.images_static)) {
            return;
        }
        this.r.setVisibility(8);
        this.s.setVisibility(8);
        this.v.setVisibility(8);
        this.t.setVisibility(0);
        this.u.setVisibility(0);
        ImageLoader.a(this.a.getFragmentActive(), yYMsgRelationExtra.images_static).b(R.drawable.gift_default_icon).a(this.t);
        this.u.setText(yYMsgRelationExtra.name);
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(YYSeatMemberModel yYSeatMemberModel) {
        YYRoomModel yYRoomModel;
        super.a(yYSeatMemberModel);
        if (yYSeatMemberModel == null) {
            return;
        }
        YYStepModel yYStepModel = this.O;
        if ((yYStepModel != null && yYStepModel.stepIndex > 2) || (yYRoomModel = this.R) == null || yYRoomModel.mics == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.R.mics.size()) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel2 = this.R.mics.get(i2);
            if (yYSeatMemberModel2 != null && !TextUtils.isEmpty(yYSeatMemberModel2.getUid()) && TextUtils.equals(yYSeatMemberModel2.getUid(), yYSeatMemberModel.getUid())) {
                yYSeatMemberModel2.gift_value = yYSeatMemberModel.gift_value;
                yYSeatMemberModel2.value_order = yYSeatMemberModel.value_order;
                yYSeatMemberModel2.speech_ripple = yYSeatMemberModel.speech_ripple;
                a(yYSeatMemberModel2, i2);
                return;
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(YYBaseUserHeadView.GetViewX_Y_W_H getViewX_Y_W_H, String str) {
        YYBaseUserHeadView yYBaseUserHeadView;
        YYBaseUserHeadView yYBaseUserHeadView2;
        YYRoomModel yYRoomModel = this.R;
        if (yYRoomModel == null || yYRoomModel.mics == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.R.mics.size()) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel = this.R.mics.get(i2);
            if (StringUtils.a(str, yYSeatMemberModel.getUid())) {
                if (i2 == 0) {
                    YYBaseUserHeadView yYBaseUserHeadView3 = this.h;
                    if (yYBaseUserHeadView3 != null) {
                        yYBaseUserHeadView3.a(getViewX_Y_W_H);
                    }
                } else if (i2 == 1) {
                    if (this.O.stepIndex <= 2 || (yYBaseUserHeadView2 = this.I) == null) {
                        YYBaseUserHeadView yYBaseUserHeadView4 = this.x;
                        if (yYBaseUserHeadView4 != null) {
                            yYBaseUserHeadView4.a(getViewX_Y_W_H);
                        }
                    } else {
                        this.P = yYSeatMemberModel;
                        yYBaseUserHeadView2.a(getViewX_Y_W_H);
                    }
                } else if (i2 != 2 || this.O.stepIndex <= 2 || (yYBaseUserHeadView = this.J) == null) {
                    YYMemberSaleView yYMemberSaleView = this.z.get(Integer.valueOf(i2));
                    if (yYMemberSaleView != null) {
                        yYMemberSaleView.a(getViewX_Y_W_H);
                    }
                } else {
                    this.Q = yYSeatMemberModel;
                    yYBaseUserHeadView.a(getViewX_Y_W_H);
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYSeatMemberModel yYSeatMemberModel) {
        a(baseViewHolder.itemView);
        this.h = (YYBaseUserHeadView) baseViewHolder.getView(R.id.base_host_head);
        this.g = (ImageView) baseViewHolder.getView(R.id.iv_apply_list);
        this.T = (ImageView) baseViewHolder.getView(R.id.iv_level_img);
        this.V = baseViewHolder.getView(R.id.rv_step_list);
        this.i = (RelativeLayout) baseViewHolder.getView(R.id.rl_step_sale_layout);
        this.w = (TextView) baseViewHolder.getView(R.id.tv_audience_name);
        this.x = (YYBaseUserHeadView) baseViewHolder.getView(R.id.base_us_head);
        this.k = (TextView) baseViewHolder.getView(R.id.tv_no_gift);
        this.l = (LinearLayout) baseViewHolder.getView(R.id.ll_sale_gift);
        this.m = (ImageView) baseViewHolder.getView(R.id.iv_gift_img);
        this.n = (TextView) baseViewHolder.getView(R.id.tv_gift_name);
        this.o = (TextView) baseViewHolder.getView(R.id.tv_gift_empty);
        this.p = (ShapeTextView) baseViewHolder.getView(R.id.tv_set_gift);
        this.r = (TextView) baseViewHolder.getView(R.id.tv_no_relation);
        this.q = (LinearLayout) baseViewHolder.getView(R.id.ll_sale_relation);
        this.s = (TextView) baseViewHolder.getView(R.id.tv_relation_empty);
        this.t = (ImageView) baseViewHolder.getView(R.id.iv_relation_img);
        this.u = (TextView) baseViewHolder.getView(R.id.tv_relation_name);
        this.v = (ShapeTextView) baseViewHolder.getView(R.id.tv_set_relation);
        this.b = (ShapeTextView) baseViewHolder.getView(R.id.tv_apply_btn);
        this.c = (ShapeTextView) baseViewHolder.getView(R.id.tv_down_seat);
        this.d = (ShapeTextView) baseViewHolder.getView(R.id.tv_step_btn);
        this.e = (ShapeTextView) baseViewHolder.getView(R.id.tv_sale_btn);
        this.f = (ShapeTextView) baseViewHolder.getView(R.id.tv_join_btn);
        this.y = (TextView) baseViewHolder.getView(R.id.tv_no_audience);
        this.z.put(2, (YYMemberSaleView) baseViewHolder.getView(R.id.member_sale_1));
        this.z.put(3, (YYMemberSaleView) baseViewHolder.getView(R.id.member_sale_2));
        this.z.put(4, (YYMemberSaleView) baseViewHolder.getView(R.id.member_sale_3));
        this.z.put(5, (YYMemberSaleView) baseViewHolder.getView(R.id.member_sale_4));
        this.j = (RelativeLayout) baseViewHolder.getView(R.id.rl_step_upgrade_layout);
        this.C = (ImageView) baseViewHolder.getView(R.id.heart_beat_view);
        this.I = (YYBaseUserHeadView) baseViewHolder.getView(R.id.iv_left_member);
        this.J = (YYBaseUserHeadView) baseViewHolder.getView(R.id.iv_right_member);
        this.A = (TextView) baseViewHolder.getView(R.id.tv_left_member_name);
        this.B = (TextView) baseViewHolder.getView(R.id.tv_right_member_name);
        this.K = (ShapeTextView) baseViewHolder.getView(R.id.tv_stop_btn);
        this.L = (ShapeTextView) baseViewHolder.getView(R.id.tv_support_btn);
        this.D = (YYSaleRelationTagView) baseViewHolder.getView(R.id.tag_one);
        this.E = (YYSaleRelationTagView) baseViewHolder.getView(R.id.tag_two);
        this.F = (YYSaleRelationTagView) baseViewHolder.getView(R.id.tag_three);
        this.G = (YYSaleRelationTagView) baseViewHolder.getView(R.id.tag_four);
        this.H = (ProgressBar) baseViewHolder.getView(R.id.relation_progress);
        if (YYRoomInfoManager.e().b().voice_skin_info != null) {
            ImageLoader.a((IRequestHost) null, YYRoomInfoManager.e().b().voice_skin_info.getIcon()).a((Target<Drawable>) new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.adapter.YYSeatSaleAdapter.1
                /* renamed from: a */
                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    YYSeatSaleAdapter.this.y.setBackgroundDrawable(drawable);
                }
            });
        }
        d();
    }

    public void a(String str) {
        ImageView imageView = this.T;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(0);
        ImageLoader.a(this.a.getFragmentActive(), str).a(this.T);
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(String str, String str2) {
        YYSeatMemberModel yYSeatMemberModel = this.R.getMicsMap().get(str);
        if (yYSeatMemberModel == null) {
            return;
        }
        yYSeatMemberModel.chat_anchor = str2;
        d();
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(Set<String> set) {
        YYBaseUserHeadView yYBaseUserHeadView;
        YYBaseUserHeadView yYBaseUserHeadView2;
        YYRoomModel yYRoomModel = this.R;
        if (yYRoomModel == null || yYRoomModel.mics == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.R.mics.size()) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel = this.R.mics.get(i2);
            if (yYSeatMemberModel.is_open_mic != 0) {
                if (set == null || set.isEmpty() || !set.contains(yYSeatMemberModel.getUid())) {
                    yYSeatMemberModel.is_open_mic = 1;
                } else {
                    yYSeatMemberModel.is_open_mic = 2;
                }
                if (i2 == 0) {
                    YYBaseUserHeadView yYBaseUserHeadView3 = this.h;
                    if (yYBaseUserHeadView3 != null) {
                        yYBaseUserHeadView3.a(set, yYSeatMemberModel);
                    }
                } else if (i2 == 1) {
                    if (this.O.stepIndex <= 2 || (yYBaseUserHeadView2 = this.I) == null) {
                        YYBaseUserHeadView yYBaseUserHeadView4 = this.x;
                        if (yYBaseUserHeadView4 != null) {
                            yYBaseUserHeadView4.a(set, yYSeatMemberModel);
                        }
                    } else {
                        this.P = yYSeatMemberModel;
                        yYBaseUserHeadView2.a(set, yYSeatMemberModel);
                    }
                } else if (i2 != 2 || this.O.stepIndex <= 2 || (yYBaseUserHeadView = this.J) == null) {
                    YYMemberSaleView yYMemberSaleView = this.z.get(Integer.valueOf(i2));
                    if (yYMemberSaleView != null) {
                        yYMemberSaleView.a(set, yYSeatMemberModel);
                    }
                } else {
                    this.Q = yYSeatMemberModel;
                    yYBaseUserHeadView.a(set, yYSeatMemberModel);
                }
            }
            i = i2 + 1;
        }
    }

    public void a(boolean z, boolean z2) {
        i();
        YYRoomModel yYRoomModel = this.R;
        if (yYRoomModel == null) {
            return;
        }
        YYSeatMemberModel seatMember = yYRoomModel.getSeatMember(YYRoomInfoManager.e().k());
        int i = 8;
        if (!YYRoomInfoManager.e().i() || seatMember == null || seatMember.getItemType() != 3) {
            this.k.setVisibility(z ? 8 : 0);
            this.r.setVisibility(z2 ? 8 : 0);
            this.l.setVisibility(z ? 0 : 8);
            LinearLayout linearLayout = this.q;
            if (z2) {
                i = 0;
            }
            linearLayout.setVisibility(i);
            return;
        }
        this.k.setVisibility(8);
        this.r.setVisibility(8);
        this.l.setVisibility(0);
        this.o.setVisibility(z ? 8 : 0);
        this.p.setVisibility(z ? 8 : 0);
        this.n.setVisibility(z ? 0 : 8);
        this.m.setVisibility(z ? 0 : 8);
        this.q.setVisibility(0);
        this.s.setVisibility(z2 ? 8 : 0);
        this.v.setVisibility(z2 ? 8 : 0);
        this.u.setVisibility(z2 ? 0 : 8);
        ImageView imageView = this.t;
        if (z2) {
            i = 0;
        }
        imageView.setVisibility(i);
    }

    public void b() {
        i();
        this.k.setVisibility(8);
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        this.n.setVisibility(0);
        this.m.setVisibility(0);
        this.l.setVisibility(0);
        this.r.setVisibility(8);
        this.v.setVisibility(8);
        this.s.setVisibility(8);
        this.u.setVisibility(0);
        this.t.setVisibility(0);
        this.q.setVisibility(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(int r10) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.adapter.YYSeatSaleAdapter.b(int):void");
    }

    @Override // com.blued.android.module.yy_china.observer.SeatChangedObserver
    public void b(List<YYSeatMemberModel> list) {
        if (list == null) {
            return;
        }
        d();
    }

    public void c(List<YYSaleStageModel> list) {
        i();
        Collections.sort(list, new Comparator<YYSaleStageModel>() { // from class: com.blued.android.module.yy_china.adapter.YYSeatSaleAdapter.14
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(YYSaleStageModel yYSaleStageModel, YYSaleStageModel yYSaleStageModel2) {
                return yYSaleStageModel.getValueInt().compareTo(yYSaleStageModel2.getValueInt());
            }
        });
        this.S = list;
        YYRoomModel yYRoomModel = this.R;
        if (yYRoomModel != null) {
            setNewData(yYRoomModel.mics);
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        YYObserverManager.a().a(this);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        YYObserverManager.a().b(this);
        YYRoomModel yYRoomModel = this.R;
        if (yYRoomModel == null) {
            return;
        }
        yYRoomModel.clearEmojiAndSendMessage();
    }

    public void setNewData(List<YYSeatMemberModel> list) {
        ArrayList arrayList = new ArrayList();
        YYSeatMemberModel yYSeatMemberModel = new YYSeatMemberModel();
        yYSeatMemberModel.itemType = 6;
        arrayList.add(yYSeatMemberModel);
        super.setNewData(arrayList);
    }
}
