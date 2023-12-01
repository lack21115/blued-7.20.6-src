package com.blued.android.module.yy_china.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.SharedPreferencesUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.adapter.MultiItemTypeSupport;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live.base.constants.LiveEventBusConstant;
import com.blued.android.module.live.base.fragment.LiveGiftBaseFragment;
import com.blued.android.module.live.base.model.BasePayRemaining;
import com.blued.android.module.live.base.model.CommonLiveGiftModel;
import com.blued.android.module.live.base.model.LiveGiftNumberModel;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.adapter.SelectUserAdapter;
import com.blued.android.module.yy_china.databinding.ViewYyGiftListLayoutBinding;
import com.blued.android.module.yy_china.dialog.YYRomanticTripDialog;
import com.blued.android.module.yy_china.fragment.YYGiftListFragment;
import com.blued.android.module.yy_china.manager.YYGiftManager;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.GiftGoodsExtraModle;
import com.blued.android.module.yy_china.model.GiftMicModel;
import com.blued.android.module.yy_china.model.WeekStarInfoMode;
import com.blued.android.module.yy_china.model.WeekStarMode;
import com.blued.android.module.yy_china.model.YYGiftActivityModel;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYGiftPackageModel;
import com.blued.android.module.yy_china.model.YYGiftWantSelectMode;
import com.blued.android.module.yy_china.model.YYPayGoodsModel;
import com.blued.android.module.yy_china.model.YYPayRequestModel;
import com.blued.android.module.yy_china.model.YYRoomBasicInfoMode;
import com.blued.android.module.yy_china.model.YYRoomBasicLevelInfoMode;
import com.blued.android.module.yy_china.model.YYRoomBasicMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YyWealthModel;
import com.blued.android.module.yy_china.utils.YYPayUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.DoubleHitSendGiftView;
import com.blued.android.module.yy_china.view.YYAdInGiftListView;
import com.blued.android.module.yy_china.view.YYConfessedListDialog;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nonnull;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYGiftListFragment.class */
public class YYGiftListFragment extends LiveGiftBaseFragment {
    private YYGiftModel C;
    private LinearLayout D;
    private SelectUserAdapter E;
    private TextView F;
    private TextView G;
    private TextView H;
    private ShapeTextView I;
    private TextView J;
    private TextView K;
    private ProgressBar L;
    private RecyclerView M;
    private ImageView N;
    private ShapeLinearLayout O;
    private List<GiftMicModel> P;
    private YYRoomModel Q;
    private String R;
    private String S;
    private String T;
    private ShapeLinearLayout U;
    private HashMap<Integer, HashSet<String>> V;
    private DoubleHitSendGiftView W;
    private String Y;
    private LinearLayout Z;
    private YYAdInGiftListView aa;
    private ViewYyGiftListLayoutBinding ac;
    private WeekStarMode ad;
    private String X = "0";
    private ArrayMap<String, Long> ab = new ArrayMap<>();
    private List<CommonGiftPackageModel> ae = new ArrayList();
    private ArrayList<YYSeatMemberModel> af = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.yy_china.fragment.YYGiftListFragment$4  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYGiftListFragment$4.class */
    public class AnonymousClass4 extends CommonAdapter<LiveGiftNumberModel> {
        AnonymousClass4(List list, MultiItemTypeSupport multiItemTypeSupport) {
            super(list, multiItemTypeSupport);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(LiveGiftNumberModel liveGiftNumberModel, View view) {
            if (liveGiftNumberModel.isUserDefined) {
                YYGiftListFragment.this.r.setVisibility(8);
                YYGiftListFragment.this.a(false);
                YYGiftListFragment.this.a(liveGiftNumberModel);
                YYGiftListFragment.this.a(false);
                return;
            }
            YYGiftListFragment.this.a(false);
            YYGiftListFragment.this.o.setText(String.valueOf(liveGiftNumberModel.count));
            YYGiftListFragment.this.a(false);
            YYGiftListFragment.this.b(liveGiftNumberModel);
        }

        @Override // com.blued.android.module.common.adapter.CommonAdapter
        public void a(CommonAdapter.ViewHolder viewHolder, final LiveGiftNumberModel liveGiftNumberModel, int i) {
            viewHolder.a(R.id.tv_gift_count, String.valueOf(liveGiftNumberModel.count));
            viewHolder.a(R.id.tv_gift_name, liveGiftNumberModel.name);
            viewHolder.a().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYGiftListFragment$4$KDCzS2zMWgrcApUp3_elsuTyzZM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYGiftListFragment.AnonymousClass4.this.a(liveGiftNumberModel, view);
                }
            });
        }
    }

    private void A() {
        YYConfessedListDialog yYConfessedListDialog = new YYConfessedListDialog();
        yYConfessedListDialog.a("gift_panel");
        yYConfessedListDialog.show(getParentFragmentManager(), "YYConfessedListDialog");
        D().n();
    }

    private void B() {
        this.o.setText(String.valueOf(k()));
        YYGiftModel yYGiftModel = this.C;
        if (yYGiftModel == null || yYGiftModel.selectedGiftNumModel == null) {
            this.o.setTextColor(getResources().getColor(R.color.syc_26FFFFFF));
            this.q.setAlpha(0.15f);
            return;
        }
        this.o.setTextColor(getResources().getColor(R.color.syc_dark_b));
        this.q.setAlpha(1.0f);
    }

    private void C() {
        if (this.C.goods_number == null || this.C.goods_number.isEmpty()) {
            ShapeHelper.b(this.U, R.color.transparent);
            this.p.setVisibility(8);
            if (this.m instanceof ShapeTextView) {
                ShapeHelper.a((ShapeHelper.ShapeView) this.m, DensityUtils.a(getContext(), 14.0f));
                return;
            }
            return;
        }
        ShapeHelper.b(this.U, R.color.syc_00E0AB);
        this.p.setVisibility(0);
        if (this.m instanceof ShapeTextView) {
            ShapeHelper.a((ShapeHelper.ShapeView) this.m, 0.0f, DensityUtils.a(getContext(), 14.0f), 0.0f, DensityUtils.a(getContext(), 14.0f));
        }
    }

    private BaseYYStudioFragment D() {
        return (BaseYYStudioFragment) getParentFragment();
    }

    private void E() {
        SelectUserAdapter selectUserAdapter;
        if (this.C == null || (selectUserAdapter = this.E) == null || selectUserAdapter.a() == null || this.E.a().isEmpty()) {
            return;
        }
        ArrayList<YYSeatMemberModel> arrayList = new ArrayList<>();
        Iterator<YYSeatMemberModel> it = this.E.a().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        if (this.C.goods_type == -2) {
            if (arrayList.size() > 1) {
                ToastUtils.a("粉丝团礼物仅能送给当前房主", 0);
                return;
            }
            YYRoomModel yYRoomModel = this.Q;
            if (yYRoomModel != null && !TextUtils.equals(yYRoomModel.uid, arrayList.get(0).getUid())) {
                ToastUtils.a("粉丝团礼物仅能送给当前房主", 0);
                return;
            }
        }
        if (!TextUtils.equals(this.C.is_free, "1")) {
            if (arrayList.size() == this.af.size()) {
                Iterator<YYSeatMemberModel> it2 = this.af.iterator();
                while (it2.hasNext()) {
                    YYSeatMemberModel next = it2.next();
                    Iterator<YYSeatMemberModel> it3 = arrayList.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            this.ab.clear();
                            break;
                        } else if (next.getUid().equals(it3.next().getUid())) {
                            break;
                        }
                    }
                }
            } else {
                this.ab.clear();
            }
            this.af.clear();
            Iterator<YYSeatMemberModel> it4 = arrayList.iterator();
            while (it4.hasNext()) {
                this.af.add(it4.next());
            }
            int i = this.C.type;
            if (i != 0) {
                if (i == 1) {
                    a(arrayList);
                    return;
                } else if (i == 2) {
                    F();
                    return;
                } else if (i == 3) {
                    G();
                    return;
                } else if (i == 4) {
                    H();
                    return;
                } else if (i != 5) {
                    return;
                } else {
                    A();
                    return;
                }
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= arrayList.size()) {
                    a(arrayList, true);
                    return;
                }
                arrayList.get(i3).isFirstToMicsInTeam = i3 == 0;
                i2 = i3 + 1;
            }
        } else if (this.C.free_count <= 0) {
            ToastUtils.a("礼物次数已用完", 0);
        } else {
            YYRoomModel b = YYRoomInfoManager.e().b();
            Logger.e("timer", "roomModel.countdown: " + b.countdown);
            if (b == null || !b.isTimerFinished()) {
                ToastUtils.a("请耐心等待，礼物还未生成", 0);
                return;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= arrayList.size()) {
                    a(arrayList, true);
                    return;
                }
                arrayList.get(i5).isFirstToMicsInTeam = i5 == 0;
                i4 = i5 + 1;
            }
        }
    }

    private void F() {
        new YYDecorateCarDialog("", "", 0, D()).show(getParentFragmentManager(), "open_music_center_dialog");
        D().n();
    }

    private void G() {
        new YYRomanticTripDialog().show(getParentFragmentManager(), "dialog_romantic_trip");
        D().n();
    }

    private void H() {
        new YYPackGiftDialog().show(getParentFragmentManager(), "YYPackGiftDialog");
        D().n();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        if (r0.isEmpty() != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void I() {
        /*
            r6 = this;
            r0 = r6
            com.blued.android.module.yy_china.model.YYRoomModel r0 = r0.Q
            r8 = r0
            r0 = r8
            if (r0 != 0) goto La
            return
        La:
            r0 = r8
            java.util.List r0 = r0.getHasPeopleMics()
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L1e
            r0 = r9
            r8 = r0
            r0 = r9
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L26
        L1e:
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r1.<init>()
            r8 = r0
        L26:
            r0 = r6
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = r1
            r2.<init>()
            r0.P = r1
            r0 = 0
            r7 = r0
        L33:
            r0 = r7
            r1 = r8
            int r1 = r1.size()
            if (r0 >= r1) goto Laa
            r0 = r8
            r1 = r7
            java.lang.Object r0 = r0.get(r1)
            com.blued.android.module.yy_china.model.YYSeatMemberModel r0 = (com.blued.android.module.yy_china.model.YYSeatMemberModel) r0
            r9 = r0
            r0 = r9
            int r0 = r0.position_status
            r1 = 1
            if (r0 == r1) goto L53
            goto La3
        L53:
            r0 = r9
            java.lang.String r0 = r0.getUid()
            com.blued.android.module.yy_china.manager.YYRoomInfoManager r1 = com.blued.android.module.yy_china.manager.YYRoomInfoManager.e()
            java.lang.String r1 = r1.k()
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 == 0) goto L66
            goto La3
        L66:
            r0 = r9
            java.lang.String r0 = r0.getUid()
            r1 = r6
            com.blued.android.module.yy_china.model.YYRoomModel r1 = r1.Q
            java.lang.String r1 = r1.uid
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 == 0) goto L8e
            r0 = r6
            java.util.List<com.blued.android.module.yy_china.model.GiftMicModel> r0 = r0.P
            com.blued.android.module.yy_china.model.GiftMicModel r1 = new com.blued.android.module.yy_china.model.GiftMicModel
            r2 = r1
            java.lang.String r3 = "0"
            r4 = r9
            r2.<init>(r3, r4)
            boolean r0 = r0.add(r1)
            goto La3
        L8e:
            r0 = r6
            java.util.List<com.blued.android.module.yy_china.model.GiftMicModel> r0 = r0.P
            com.blued.android.module.yy_china.model.GiftMicModel r1 = new com.blued.android.module.yy_china.model.GiftMicModel
            r2 = r1
            java.lang.String r3 = ""
            r4 = r9
            r2.<init>(r3, r4)
            boolean r0 = r0.add(r1)
        La3:
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            goto L33
        Laa:
            r0 = r6
            com.blued.android.module.yy_china.adapter.SelectUserAdapter r0 = r0.E
            r8 = r0
            r0 = r8
            if (r0 == 0) goto Lc2
            r0 = r8
            r1 = r6
            java.util.List<com.blued.android.module.yy_china.model.GiftMicModel> r1 = r1.P
            r0.setNewData(r1)
            r0 = r6
            com.blued.android.module.yy_china.adapter.SelectUserAdapter r0 = r0.E
            r0.c()
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYGiftListFragment.I():void");
    }

    private void J() {
        List<GiftMicModel> list = this.P;
        if (list == null || list.isEmpty()) {
            this.F.setVisibility(0);
            this.M.setVisibility(8);
            this.m.setEnabled(false);
            ShapeHelper.a((ShapeTextView) this.m, R.color.syc_00E0AB, R.color.syc_3883FD);
            this.U.setAlpha(0.5f);
            this.I.setVisibility(8);
            return;
        }
        YYSeatMemberModel mic = this.P.get(0).getMic();
        YYSeatMemberModel yYSeatMemberModel = mic;
        if (!TextUtils.isEmpty(this.T)) {
            Iterator<GiftMicModel> it = this.P.iterator();
            while (true) {
                yYSeatMemberModel = mic;
                if (!it.hasNext()) {
                    break;
                }
                GiftMicModel next = it.next();
                if (TextUtils.equals(this.T, next.getMic().getUid())) {
                    yYSeatMemberModel = next.getMic();
                    break;
                }
            }
        }
        this.F.setVisibility(8);
        this.M.setVisibility(0);
        this.E.notifyDataSetChanged();
        this.m.setEnabled(true);
        ShapeHelper.a((ShapeTextView) this.m, R.color.syc_00E0AB, R.color.syc_3883FD);
        this.U.setAlpha(1.0f);
        this.E.a(yYSeatMemberModel);
        if (this.P.size() > 1) {
            this.I.setVisibility(0);
        } else {
            this.I.setVisibility(8);
        }
    }

    private YYRoomBasicLevelInfoMode a(YyWealthModel yyWealthModel) {
        if (yyWealthModel == null) {
            return null;
        }
        return new YYRoomBasicLevelInfoMode(yyWealthModel.getWealth_level(), yyWealthModel.getCurrent_wealth_experience(), yyWealthModel.getCurrent_consume_beans(), yyWealthModel.getLevel_wealth_experience(), "", yyWealthModel.getLevel_consume_beans());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluedEntity<YYGiftPackageModel, GiftGoodsExtraModle> bluedEntity) {
        if (bluedEntity == null || !bluedEntity.hasData()) {
            Log.e("YYGiftListFragment", "从网络获取礼物列表失败 无数据");
            return;
        }
        GiftGoodsExtraModle giftGoodsExtraModle = bluedEntity.extra;
        if (this.Q != null && giftGoodsExtraModle != null) {
            YyWealthModel yyWealthModel = giftGoodsExtraModle.current_wealth;
            if (yyWealthModel != null) {
                this.Q.wealth_level = yyWealthModel.getWealth_level();
                this.Q.enter_effects = yyWealthModel.getEnter_effects();
                this.Q.avatar_frame = yyWealthModel.getAvatar_frame();
            }
            this.Y = giftGoodsExtraModle.wealth_url;
            YYPayGoodsModel yYPayGoodsModel = new YYPayGoodsModel();
            yYPayGoodsModel.current_wealth = yyWealthModel;
            yYPayGoodsModel.next_wealth = giftGoodsExtraModle.next_wealth;
            a(yYPayGoodsModel);
        }
        Logger.e("YYGiftListFragment", "更新网络礼物列表");
        d(bluedEntity.data);
        LiveEventBus.get("gift_package_selected").post("0");
        LiveEventBus.get("gift_item_selected").post(b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(WeekStarInfoMode weekStarInfoMode, View view) {
        YYRoomInfoManager.e().c().a(getContext(), weekStarInfoMode.getUid(), weekStarInfoMode.getNickname(), weekStarInfoMode.getAvatar(), 0, 2);
        if (this.Q != null) {
            EventTrackYY.l(ChatRoomProtos.Event.YY_NEW_WEEK_CLICK, this.Q.room_id, this.Q.uid, weekStarInfoMode.getUid());
        }
    }

    private void a(YYGiftModel yYGiftModel, YYPayGoodsModel yYPayGoodsModel, int i) {
        yYGiftModel.sendGiftStatus = 3;
        yYGiftModel.beans_count = yYPayGoodsModel.beans_count;
        yYGiftModel.beans_current_count = yYPayGoodsModel.beans_current;
        yYGiftModel.free_number = yYPayGoodsModel.free_number;
        if (yYGiftModel.double_hit == 1) {
            yYGiftModel.comboWaitTime = this.A;
        }
        if (yYGiftModel.isBag()) {
            yYGiftModel.count = yYPayGoodsModel.extra_count;
        }
        Logger.e("YYGiftListFragment", "after updateGiftValue: " + yYGiftModel.toString());
    }

    private void a(final YYGiftModel yYGiftModel, final ArrayList<YYSeatMemberModel> arrayList, final int i, String str, boolean z) {
        if (yYGiftModel != null && j()) {
            YYSeatMemberModel yYSeatMemberModel = arrayList.get(0);
            YYPayRequestModel yYPayRequestModel = new YYPayRequestModel();
            yYPayRequestModel.gift = yYGiftModel;
            yYPayRequestModel.beans = yYGiftModel.beans;
            yYPayRequestModel.giftCount = i;
            yYPayRequestModel.goods_id = yYGiftModel.goods_id;
            yYPayRequestModel.goods_type = yYGiftModel.goods_type;
            yYPayRequestModel.hit_id = yYSeatMemberModel.getHit_id();
            yYPayRequestModel.payCode = str;
            yYPayRequestModel.remember_me = z;
            yYPayRequestModel.room_id = this.Q.room_id;
            yYPayRequestModel.target_uid = arrayList.get(0).getUid();
            yYPayRequestModel.isFirstToMicsInTeam = yYSeatMemberModel.isFirstToMicsInTeam;
            yYPayRequestModel.wantSelect = arrayList;
            YYPayUtils.a(yYPayRequestModel, YYConstants.PayFromSource.Pay_Gift, (Fragment) this, getFragmentActive(), new YYPayUtils.PayGiftStatusListener() { // from class: com.blued.android.module.yy_china.fragment.YYGiftListFragment.6
                @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
                public void a(int i2, String str2) {
                }

                @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
                public void a(YYPayGoodsModel yYPayGoodsModel) {
                    if (YYGiftListFragment.this.j()) {
                        yYPayGoodsModel.beans = yYPayGoodsModel.users_sums_left;
                        Logger.e("buyGift.onUIUpdate: " + yYPayGoodsModel.toString(), new Object[0]);
                        if (yYGiftModel.double_hit == 1 && YYGiftListFragment.this.W != null) {
                            YYGiftListFragment.this.W.setVisibility(0);
                            YYGiftListFragment.this.a(ChatRoomProtos.Event.CHAT_ROOM_GIFT_MORE_HIT_CLICK, yYGiftModel);
                        }
                        yYGiftModel.extra = yYPayGoodsModel.extra;
                        YYGiftListFragment.this.a(arrayList, yYPayGoodsModel, yYGiftModel, i);
                    }
                }
            });
        }
    }

    private void a(YYPayGoodsModel yYPayGoodsModel) {
        if (this.Q != null && yYPayGoodsModel != null && yYPayGoodsModel.current_wealth != null && yYPayGoodsModel.next_wealth != null) {
            this.Q.wealth_level = yYPayGoodsModel.current_wealth.getWealth_level();
            this.Q.enter_effects = yYPayGoodsModel.current_wealth.getEnter_effects();
            this.Q.avatar_frame = yYPayGoodsModel.current_wealth.getAvatar_frame();
        }
        a(a(yYPayGoodsModel.next_wealth), a(yYPayGoodsModel.current_wealth), false, yYPayGoodsModel.current_wealth.getEnter_effects(), yYPayGoodsModel.current_wealth.getAvatar_frame());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YYRoomBasicLevelInfoMode yYRoomBasicLevelInfoMode, YYRoomBasicLevelInfoMode yYRoomBasicLevelInfoMode2, boolean z, String str, String str2) {
        if (yYRoomBasicLevelInfoMode2 != null) {
            if (yYRoomBasicLevelInfoMode == null || ((yYRoomBasicLevelInfoMode != null && (yYRoomBasicLevelInfoMode.getLevel_score() == null || "".equals(yYRoomBasicLevelInfoMode.getLevel_score()))) || yYRoomBasicLevelInfoMode.getLevel().equals(yYRoomBasicLevelInfoMode2.getLevel()))) {
                TextView textView = this.H;
                textView.setText("Lv." + yYRoomBasicLevelInfoMode2.getLevel());
                TextView textView2 = this.G;
                textView2.setText("Lv." + (StringUtils.a(yYRoomBasicLevelInfoMode2.getLevel(), 0) - 1));
                this.J.setText("已达到最高级");
                this.L.setProgress(100);
            } else {
                TextView textView3 = this.G;
                textView3.setText("Lv." + yYRoomBasicLevelInfoMode2.getLevel());
                TextView textView4 = this.H;
                textView4.setText("Lv." + yYRoomBasicLevelInfoMode.getLevel());
                long a = StringUtils.a(yYRoomBasicLevelInfoMode2.getCurrent_score(), 0L);
                long a2 = StringUtils.a(yYRoomBasicLevelInfoMode2.getLevel_score(), 0L);
                long a3 = StringUtils.a(yYRoomBasicLevelInfoMode.getLevel_score(), 0L);
                long a4 = StringUtils.a(yYRoomBasicLevelInfoMode.getLevel_consume_beans(), 0L);
                long a5 = StringUtils.a(yYRoomBasicLevelInfoMode2.getCurrent_consume_beans(), 0L);
                TextView textView5 = this.J;
                textView5.setText("需" + CommonStringUtils.b(((float) (a4 - a5)) * 1.0f) + "升级");
                this.L.setProgress((int) ((((float) (a - a2)) * 100.0f) / ((float) (a3 - a2))));
            }
            YYRoomModel yYRoomModel = this.Q;
            if (yYRoomModel != null && yYRoomBasicLevelInfoMode2 != null) {
                yYRoomModel.wealth_level = yYRoomBasicLevelInfoMode2.getLevel();
                this.Q.enter_effects = str;
                this.Q.avatar_frame = str2;
            }
        }
        if (z) {
            return;
        }
        YYRoomHttpUtils.r(new BluedUIHttpResponse<BluedEntityA<YYRoomBasicMode>>(getFragmentActive()) { // from class: com.blued.android.module.yy_china.fragment.YYGiftListFragment.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYRoomBasicMode> bluedEntityA) {
                YYRoomBasicMode singleData;
                if (bluedEntityA == null || !bluedEntityA.hasData() || (singleData = bluedEntityA.getSingleData()) == null) {
                    return;
                }
                YYRoomBasicInfoMode honor_info = singleData.getHonor_info();
                if (honor_info != null && honor_info.getCurrent_level_info() != null && honor_info.getNext_level_info() != null) {
                    YYRoomInfoManager.e().b().wealth_level = honor_info.getCurrent_level_info().getLevel();
                    String str3 = null;
                    if (singleData.getProp_info() != null) {
                        str3 = null;
                        if (singleData.getProp_info().getEnter_effects() != null) {
                            str3 = singleData.getProp_info().getEnter_effects().getImg();
                        }
                        if (singleData.getProp_info().getPendant() != null) {
                            str3 = singleData.getProp_info().getPendant().getImg();
                        }
                    }
                    YYGiftListFragment.this.a(honor_info.getNext_level_info(), honor_info.getCurrent_level_info(), true, str3, (String) null);
                }
                YYGiftListFragment.this.ad = singleData.getZx_named();
            }
        }, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ChatRoomProtos.Event event, YYGiftModel yYGiftModel) {
        if (yYGiftModel == null || this.E == null || this.Q == null) {
            return;
        }
        int i = -1;
        if (event == ChatRoomProtos.Event.CHAT_ROOM_GIFT_POP_SEND_CLICK) {
            YYSeatMemberModel yYSeatMemberModel = YYRoomInfoManager.e().o().get(YYRoomInfoManager.e().k());
            i = -1;
            if (yYSeatMemberModel != null) {
                i = yYSeatMemberModel.mic_position;
            }
        }
        if (this.E.a() != null) {
            Iterator<YYSeatMemberModel> it = this.E.a().iterator();
            while (it.hasNext()) {
                EventTrackYY.a(event, this.Q.room_id, this.Q.uid, it.next().getUid(), yYGiftModel.goods_id, k(), (int) (k() * yYGiftModel.beans), this.R, yYGiftModel.goods_type, yYGiftModel.pageIndex, yYGiftModel.positionInPage, i, this.X);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Integer num) {
        d(num.intValue());
    }

    private void a(ArrayList<YYSeatMemberModel> arrayList) {
        new YYRedPackageDialog(arrayList).show(getParentFragmentManager(), "red_package_dialog");
        D().n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<YYSeatMemberModel> arrayList, YYPayGoodsModel yYPayGoodsModel, YYGiftModel yYGiftModel, int i) {
        if (yYPayGoodsModel == null) {
            return;
        }
        LogUtils.c("buyGiftSuccess: " + yYPayGoodsModel.toString());
        if (yYGiftModel != null && yYGiftModel.beans >= 500) {
            D().n();
        }
        a(yYPayGoodsModel);
        a((BasePayRemaining) yYPayGoodsModel);
        arrayList.get(0).setHit_id(yYPayGoodsModel.hit_id);
        a(yYGiftModel, yYPayGoodsModel, i);
        Logger.e("buyGiftSuccess after updateGiftValue: " + yYGiftModel.toString(), new Object[0]);
        if (TextUtils.isEmpty(yYGiftModel.contents)) {
            a(arrayList, yYGiftModel, i);
            YYImMsgManager.a().a(yYGiftModel, arrayList.get(0), yYPayGoodsModel, true);
        } else {
            LogUtils.a("弹幕消息，不模拟发消息");
        }
        this.y = yYGiftModel;
        if (TextUtils.equals(arrayList.get(0).getUid(), this.Q.uid) && YYRoomInfoManager.e().a != null) {
            YYRoomInfoManager.e().a.isSendGift = true;
        }
        f(yYGiftModel, i);
        if (yYGiftModel.count > 0 && yYGiftModel.isBag()) {
            LiveEventBus.get("gift_item_update").post(yYGiftModel);
        }
        if (yYGiftModel.count <= 0 && yYGiftModel.isBag() && yYGiftModel.double_hit == 0) {
            LiveEventBus.get("gift_item_update").post(yYGiftModel);
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        arrayList.remove(0);
        if (arrayList.size() > 0) {
            a(arrayList, false);
        }
    }

    private void a(ArrayList<YYSeatMemberModel> arrayList, boolean z) {
        YYGiftModel yYGiftModel;
        LogUtils.c("selectedItemIndex: " + this.c);
        if (TextUtils.isEmpty(this.c) || (yYGiftModel = (YYGiftModel) a(this.c)) == null) {
            return;
        }
        LogUtils.c("selectedModel: " + yYGiftModel.toString());
        if (yYGiftModel.sendGiftStatus == 1) {
            return;
        }
        YYSeatMemberModel yYSeatMemberModel = arrayList.get(0);
        Long l = this.ab.get(yYSeatMemberModel.getUid());
        Long l2 = l;
        if (l == null) {
            l2 = -1L;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("is_combo = ");
        sb.append(yYGiftModel.double_hit == 1);
        sb.append(", goods_id = ");
        sb.append(yYGiftModel.goods_id);
        sb.append(", comboWaitTime = ");
        sb.append(yYGiftModel.comboWaitTime);
        sb.append(", lastBuyModel.goods_id = ");
        sb.append(this.y != null ? this.y.goods_id : "null");
        sb.append(", hitId = ");
        sb.append(this.u);
        LogUtils.c(sb.toString());
        if (yYGiftModel.double_hit == 1) {
            String str = this.y != null ? this.y.goods_id : "";
            YYGiftModel yYGiftModel2 = this.C;
            if (yYGiftModel2 != null && yYGiftModel2.selectedGiftNumModel != null && this.C.selectedGiftNumModel.count > 1) {
                yYSeatMemberModel.setHit_id(0L);
            } else if (!StringUtils.a(str, yYGiftModel.goods_id) || l2.longValue() <= 0 || yYGiftModel.comboWaitTime <= 0) {
                if (z) {
                    this.ab.clear();
                }
                yYSeatMemberModel.setHit_id(System.currentTimeMillis());
                yYSeatMemberModel.setHit_count(0);
                LogUtils.c("生成一个新的hitId = " + yYSeatMemberModel.getHit_id());
            } else {
                yYSeatMemberModel.setHit_id(l2.longValue());
                LogUtils.c("判定为有效连击 mLastGiftModel.combo_id = " + yYSeatMemberModel.getHit_id());
            }
        } else {
            this.ab.clear();
            yYSeatMemberModel.setHit_count(0);
            yYSeatMemberModel.setHit_id(0L);
        }
        yYGiftModel.sendGiftStatus = 1;
        LiveEventBus.get("gift_item_update").post(yYGiftModel);
        a(ChatRoomProtos.Event.CHAT_ROOM_GIFT_POP_SEND_CLICK, this.C);
        a(yYGiftModel, arrayList, k(), "", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void b(com.blued.android.module.yy_china.model.WeekStarInfoMode r6, android.view.View r7) {
        /*
            r5 = this;
            r0 = r5
            com.blued.android.module.yy_china.model.YYRoomModel r0 = r0.Q
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L3c
            r0 = r7
            java.lang.String r0 = r0.room_id
            r7 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r8
            r1 = r6
            int r1 = r1.getRoom_id()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            java.lang.String r1 = ""
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r8
            java.lang.String r1 = r1.toString()
            boolean r0 = com.blued.android.framework.utils.StringUtils.a(r0, r1)
            if (r0 == 0) goto L3c
            r0 = r5
            com.blued.android.module.yy_china.fragment.BaseYYStudioFragment r0 = r0.D()
            r0.n()
            goto L98
        L3c:
            r0 = r5
            com.blued.android.module.yy_china.model.YYRoomModel r0 = r0.Q
            java.lang.String r0 = r0.uid
            com.blued.android.module.yy_china.manager.YYRoomInfoManager r1 = com.blued.android.module.yy_china.manager.YYRoomInfoManager.e()
            java.lang.String r1 = r1.k()
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 == 0) goto L5c
            android.content.Context r0 = com.blued.android.core.AppInfo.d()
            int r1 = com.blued.android.module.yy_china.R.string.yy_in_room_toast
            java.lang.String r0 = r0.getString(r1)
            com.blued.android.core.AppMethods.a(r0)
            return
        L5c:
            r0 = r5
            android.content.Context r0 = r0.getContext()
            com.blued.android.module.yy_china.fragment.YYJumpLoadingFragment.a(r0)
            com.blued.android.module.yy_china.manager.YYRoomInfoManager r0 = com.blued.android.module.yy_china.manager.YYRoomInfoManager.e()
            r7 = r0
            r0 = r5
            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
            com.blued.android.core.ui.BaseFragmentActivity r0 = (com.blued.android.core.ui.BaseFragmentActivity) r0
            r8 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r9 = r0
            r0 = r9
            r1 = r6
            int r1 = r1.getRoom_id()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r9
            java.lang.String r1 = ""
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r8
            r2 = r9
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = ""
            r0.a(r1, r2, r3)
        L98:
            r0 = r5
            com.blued.android.module.yy_china.model.YYRoomModel r0 = r0.Q
            if (r0 == 0) goto Lb7
            com.blued.das.client.chatroom.ChatRoomProtos$Event r0 = com.blued.das.client.chatroom.ChatRoomProtos.Event.YY_NEW_WEEK_CLICK
            r1 = r5
            com.blued.android.module.yy_china.model.YYRoomModel r1 = r1.Q
            java.lang.String r1 = r1.room_id
            r2 = r5
            com.blued.android.module.yy_china.model.YYRoomModel r2 = r2.Q
            java.lang.String r2 = r2.uid
            r3 = r6
            java.lang.String r3 = r3.getUid()
            com.blued.android.module.yy_china.utils.log.EventTrackYY.l(r0, r1, r2, r3)
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYGiftListFragment.b(com.blued.android.module.yy_china.model.WeekStarInfoMode, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(WeekStarInfoMode weekStarInfoMode, View view) {
        YYRoomInfoManager.e().c().a(getContext(), weekStarInfoMode.getUid(), weekStarInfoMode.getNickname(), weekStarInfoMode.getAvatar(), 0, 2);
        if (this.Q != null) {
            EventTrackYY.l(ChatRoomProtos.Event.YY_SUPER_STAR_WEEK_CLICK, this.Q.room_id, this.Q.uid, weekStarInfoMode.getUid());
        }
    }

    private void d(int i) {
        int i2;
        int i3 = i;
        if (i == 0) {
            i3 = 1;
        }
        YYGiftModel yYGiftModel = this.C;
        if (yYGiftModel != null && yYGiftModel.selectedGiftNumModel != null && this.C.selectedGiftNumModel.isUserDefined) {
            this.C.selectedGiftNumModel.count = i3;
            int i4 = 0;
            while (true) {
                i2 = i4;
                if (i2 >= this.C.goods_number.size() || (!this.C.goods_number.get(i2).isUserDefined && i3 >= this.C.goods_number.get(i2).count)) {
                    break;
                }
                i4 = i2 + 1;
            }
            LogUtils.c("index: " + i2);
            if (i2 < this.C.goods_number.size()) {
                this.C.selectedGiftNumModel.gift_pic_mp4 = this.C.goods_number.get(i2).gift_pic_mp4;
                LogUtils.c("use: " + this.C.goods_number.get(i2).count);
            }
        }
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void d(com.blued.android.module.yy_china.model.WeekStarInfoMode r6, android.view.View r7) {
        /*
            r5 = this;
            r0 = r5
            com.blued.android.module.yy_china.model.YYRoomModel r0 = r0.Q
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L3c
            r0 = r7
            java.lang.String r0 = r0.room_id
            r7 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r8
            r1 = r6
            int r1 = r1.getRoom_id()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            java.lang.String r1 = ""
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r8
            java.lang.String r1 = r1.toString()
            boolean r0 = com.blued.android.framework.utils.StringUtils.a(r0, r1)
            if (r0 == 0) goto L3c
            r0 = r5
            com.blued.android.module.yy_china.fragment.BaseYYStudioFragment r0 = r0.D()
            r0.n()
            goto L98
        L3c:
            r0 = r5
            com.blued.android.module.yy_china.model.YYRoomModel r0 = r0.Q
            java.lang.String r0 = r0.uid
            com.blued.android.module.yy_china.manager.YYRoomInfoManager r1 = com.blued.android.module.yy_china.manager.YYRoomInfoManager.e()
            java.lang.String r1 = r1.k()
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 == 0) goto L5c
            android.content.Context r0 = com.blued.android.core.AppInfo.d()
            int r1 = com.blued.android.module.yy_china.R.string.yy_in_room_toast
            java.lang.String r0 = r0.getString(r1)
            com.blued.android.core.AppMethods.a(r0)
            return
        L5c:
            r0 = r5
            android.content.Context r0 = r0.getContext()
            com.blued.android.module.yy_china.fragment.YYJumpLoadingFragment.a(r0)
            com.blued.android.module.yy_china.manager.YYRoomInfoManager r0 = com.blued.android.module.yy_china.manager.YYRoomInfoManager.e()
            r7 = r0
            r0 = r5
            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
            com.blued.android.core.ui.BaseFragmentActivity r0 = (com.blued.android.core.ui.BaseFragmentActivity) r0
            r8 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r9 = r0
            r0 = r9
            r1 = r6
            int r1 = r1.getRoom_id()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r9
            java.lang.String r1 = ""
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r8
            r2 = r9
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = ""
            r0.a(r1, r2, r3)
        L98:
            r0 = r5
            com.blued.android.module.yy_china.model.YYRoomModel r0 = r0.Q
            if (r0 == 0) goto Lb7
            com.blued.das.client.chatroom.ChatRoomProtos$Event r0 = com.blued.das.client.chatroom.ChatRoomProtos.Event.YY_SUPER_STAR_WEEK_CLICK
            r1 = r5
            com.blued.android.module.yy_china.model.YYRoomModel r1 = r1.Q
            java.lang.String r1 = r1.room_id
            r2 = r5
            com.blued.android.module.yy_china.model.YYRoomModel r2 = r2.Q
            java.lang.String r2 = r2.uid
            r3 = r6
            java.lang.String r3 = r3.getUid()
            com.blued.android.module.yy_china.utils.log.EventTrackYY.l(r0, r1, r2, r3)
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYGiftListFragment.d(com.blued.android.module.yy_china.model.WeekStarInfoMode, android.view.View):void");
    }

    private void d(List<YYGiftPackageModel> list) {
        if (list == null) {
            return;
        }
        this.ae.clear();
        ArrayList arrayList = new ArrayList();
        for (YYGiftPackageModel yYGiftPackageModel : list) {
            yYGiftPackageModel.name = yYGiftPackageModel.type_name;
            if (yYGiftPackageModel.isBag()) {
                yYGiftPackageModel.deleteItemIfZeroCount = true;
            }
            for (YYGiftModel yYGiftModel : yYGiftPackageModel.goods) {
                yYGiftModel.pic = yYGiftModel.images_static;
                yYGiftModel.sendGiftStatus = 0;
                if (StringUtils.b(yYGiftPackageModel.type_id)) {
                    yYGiftPackageModel.type_id = "1";
                }
                yYGiftModel.goods_type = StringUtils.a(yYGiftPackageModel.type_id, 0);
                if (yYGiftModel.goods_number != null && !yYGiftModel.goods_number.isEmpty()) {
                    LiveGiftNumberModel liveGiftNumberModel = new LiveGiftNumberModel();
                    liveGiftNumberModel.isUserDefined = true;
                    yYGiftModel.goods_number.add(0, liveGiftNumberModel);
                }
            }
            this.ae.add(yYGiftPackageModel);
            arrayList.add(yYGiftPackageModel);
        }
        YYGiftManager.a().a(arrayList);
        a(this.ae);
        b(this.ae);
        this.h.requestLayout();
        this.h.setOffscreenPageLimit(this.j.size());
        Logger.e("yy_gift", "setOffscreenPageLimit ... ");
        this.a.setToolBtnSelect(0);
        this.h.setCurrentItem(0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        YYGiftModel yYGiftModel = this.C;
        if (yYGiftModel == null) {
            return;
        }
        if (yYGiftModel.type == 1) {
            a(new ArrayList<>(this.E.a()));
        } else if (this.C.type == 2) {
            EventTrackYY.d(ChatRoomProtos.Event.YY_GIFT_MADE_CAR_GO_CLICK, this.Q.room_id, this.Q.uid);
            F();
        } else if (this.C.type == 3) {
            G();
        } else if (this.C.type == 4) {
            H();
        } else if (this.C.type == 5) {
            A();
        } else if (TextUtils.isEmpty(str)) {
            Logger.e("js advertisement url is empty ... ", new Object[0]);
        } else {
            Logger.e("js url: " + str, new Object[0]);
            EventTrackYY.p(ChatRoomProtos.Event.CHAT_ROOM_GIFT_ACTIVITY_CLICK, this.Q.room_id, this.Q.uid, str);
            LiveEventBus.get("event_yy_game").post(str);
        }
    }

    private void t() {
        this.R = getArguments().getString("from");
        this.T = getArguments().getString("target_uid");
        this.S = getArguments().getString("goods_id");
        Logger.e("YYGiftListFragment", "init source = " + this.R);
        YYRoomModel b = YYRoomInfoManager.e().b();
        this.Q = b;
        if (b == null) {
            D().n();
            return;
        }
        this.X = b.chat_type;
        EventTrackYY.h(ChatRoomProtos.Event.CHAT_ROOM_GIFT_POP_SHOW, this.Q.room_id, this.Q.uid, this.R);
        x();
        YYRoomHttpUtils.a();
        u();
    }

    private void u() {
        if (YYRoomInfoManager.e().b() == null || YYRoomInfoManager.e().b().yyPerFirstGiftModel == null || YYRoomInfoManager.e().b().yyPerFirstGiftModel.getType() != 1) {
            return;
        }
        this.N.setVisibility(0);
        this.O.setVisibility(8);
        String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis()));
        if (format.equals(SharedPreferencesUtils.b().getString("yy_FirstRecharge_Gift", ""))) {
            return;
        }
        SharedPreferencesUtils.b().edit().putString("yy_FirstRecharge_Gift", format).apply();
        LiveEventBus.get("frist_rechage").post("1");
        z();
    }

    private void v() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.M.setLayoutManager(linearLayoutManager);
        SelectUserAdapter selectUserAdapter = new SelectUserAdapter();
        this.E = selectUserAdapter;
        selectUserAdapter.a(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYGiftListFragment$C-46Ot3A7z_cQ5OVTDV5ZuFny-g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYGiftListFragment.this.a(view);
            }
        });
        this.M.setAdapter(this.E);
    }

    private void w() {
        if (this.E.a().size() == this.E.getData().size()) {
            ShapeHelper.a(this.I, R.color.black_alpha10, R.color.black_alpha10);
            this.I.setTextColor(getResources().getColor(R.color.syc_989898));
            this.I.setText(R.string.cancel);
            return;
        }
        ShapeHelper.a(this.I, R.color.syc_00E0AB, R.color.syc_3883FD);
        this.I.setTextColor(getResources().getColor(R.color.white));
        this.I.setText("全选");
    }

    private void x() {
        I();
        J();
    }

    private void y() {
        WeekStarMode weekStarMode;
        this.ac.d.setVisibility(8);
        this.ac.e.setVisibility(8);
        if (this.ac == null || (weekStarMode = this.ad) == null || this.C == null || !weekStarMode.getGoods_ids().contains(this.C.goods_id)) {
            return;
        }
        if (this.ad.getStar_info() != null) {
            this.ac.d.setVisibility(0);
            final WeekStarInfoMode star_info = this.ad.getStar_info();
            ImageLoader.a(getFragmentActive(), star_info.getAvatar()).c().b(R.drawable.user_bg_round).a(this.ac.l);
            this.ac.J.setText(star_info.getNickname());
            if (star_info.getRoom_id() > 0) {
                this.ac.m.setVisibility(0);
                this.ac.I.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYGiftListFragment$2_VCJtc2FElzSfPIZLM3kbVGKa4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        YYGiftListFragment.this.d(star_info, view);
                    }
                });
            } else {
                this.ac.m.setVisibility(8);
                this.ac.I.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYGiftListFragment$AsGlLsrqkZ1xW5WK3LrqhZvo3s8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        YYGiftListFragment.this.c(star_info, view);
                    }
                });
            }
            if (this.Q != null) {
                EventTrackYY.l(ChatRoomProtos.Event.YY_SUPER_STAR_WEEK_SHOW, this.Q.room_id, this.Q.uid, star_info.getUid());
            }
        }
        if (this.ad.getNew_info() != null) {
            this.ac.e.setVisibility(0);
            final WeekStarInfoMode new_info = this.ad.getNew_info();
            ImageLoader.a(getFragmentActive(), new_info.getAvatar()).c().b(R.drawable.user_bg_round).a(this.ac.j);
            this.ac.L.setText(new_info.getNickname());
            if (new_info.getRoom_id() > 0) {
                this.ac.k.setVisibility(0);
                this.ac.K.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYGiftListFragment$-TS_GGuB6TGK1yrVVpX2Oy-NATA
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        YYGiftListFragment.this.b(new_info, view);
                    }
                });
            } else {
                this.ac.k.setVisibility(8);
                this.ac.K.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYGiftListFragment$SN5h1odNTx5EZN1kr_SkRfp4eC0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        YYGiftListFragment.this.a(new_info, view);
                    }
                });
            }
            if (this.Q != null) {
                EventTrackYY.l(ChatRoomProtos.Event.YY_NEW_WEEK_SHOW, this.Q.room_id, this.Q.uid, new_info.getUid());
            }
        }
    }

    private void z() {
        YYGiftActivityModel yYGiftActivityModel;
        YYGiftModel yYGiftModel = this.C;
        if (yYGiftModel != null) {
            yYGiftActivityModel = yYGiftModel.activity;
            yYGiftActivityModel.type = this.C.type;
        } else {
            yYGiftActivityModel = null;
        }
        this.aa.a(yYGiftActivityModel, new YYAdInGiftListView.ClickAdvertisementListener() { // from class: com.blued.android.module.yy_china.fragment.YYGiftListFragment.5
            @Override // com.blued.android.module.yy_china.view.YYAdInGiftListView.ClickAdvertisementListener
            public void a() {
                YYGiftListFragment.this.N.setVisibility(0);
            }

            @Override // com.blued.android.module.yy_china.view.YYAdInGiftListView.ClickAdvertisementListener
            public void a(String str) {
                YYGiftListFragment.this.e(str);
            }
        });
    }

    @Override // com.blued.android.module.common.fragment.BaseGiftRootFragment
    public BaseFragment a(CommonGiftPackageModel commonGiftPackageModel, @Nonnull Bundle bundle) {
        return new YYGiftParentFragment();
    }

    @Override // com.blued.android.module.common.fragment.BaseGiftRootFragment
    public void a(BaseGiftModel baseGiftModel, boolean z) {
        super.a(baseGiftModel, z);
        LogUtils.c(baseGiftModel.index + ", " + z);
        YYGiftModel yYGiftModel = this.C;
        boolean z2 = false;
        if (yYGiftModel != null && !StringUtils.a(yYGiftModel.index, baseGiftModel.index)) {
            r();
            YYGiftModel yYGiftModel2 = (YYGiftModel) a(this.C.index);
            if (yYGiftModel2 != null) {
                yYGiftModel2.isSelected = false;
                yYGiftModel2.comboWaitTime = 0;
                LiveEventBus.get("gift_item_update").post(yYGiftModel2);
            }
            DoubleHitSendGiftView doubleHitSendGiftView = this.W;
            if (doubleHitSendGiftView != null) {
                doubleHitSendGiftView.a();
            }
        }
        YYGiftModel yYGiftModel3 = (YYGiftModel) baseGiftModel;
        this.C = yYGiftModel3;
        if (TypeUtils.a((List<?>) yYGiftModel3.goods_number)) {
            this.C.selectedGiftNumModel = null;
        } else {
            YYGiftModel yYGiftModel4 = this.C;
            yYGiftModel4.selectedGiftNumModel = yYGiftModel4.goods_number.get(0);
            for (LiveGiftNumberModel liveGiftNumberModel : this.C.goods_number) {
                if (liveGiftNumberModel.count > 0) {
                    if (this.C.selectedGiftNumModel.count == 0) {
                        this.C.selectedGiftNumModel = liveGiftNumberModel;
                    } else if (this.C.selectedGiftNumModel.count > liveGiftNumberModel.count) {
                        this.C.selectedGiftNumModel = liveGiftNumberModel;
                    }
                }
            }
        }
        SelectUserAdapter selectUserAdapter = this.E;
        if (selectUserAdapter != null) {
            if (this.C.is_all == 0) {
                z2 = true;
            }
            selectUserAdapter.a(z2);
            w();
        }
        z();
        y();
        B();
        C();
        a(ChatRoomProtos.Event.CHAT_ROOM_GIFT_POP_ONE_GIFT_CLICK, this.C);
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    public void a(LiveGiftNumberModel liveGiftNumberModel) {
        YYGiftModel yYGiftModel = this.C;
        if (yYGiftModel != null) {
            yYGiftModel.selectedGiftNumModel = liveGiftNumberModel;
        }
        YYGiftCountInputDlg yYGiftCountInputDlg = new YYGiftCountInputDlg();
        yYGiftCountInputDlg.show(getFragmentManager(), yYGiftCountInputDlg.b());
    }

    protected void a(ArrayList<YYSeatMemberModel> arrayList, CommonLiveGiftModel commonLiveGiftModel, int i) {
        super.e(commonLiveGiftModel, i);
        Logger.e("giftCount = " + i + ", " + commonLiveGiftModel.toString(), new Object[0]);
        YYSeatMemberModel yYSeatMemberModel = arrayList.get(0);
        if (i > 1) {
            commonLiveGiftModel.hit_batch = 1;
            yYSeatMemberModel.setHit_count(i);
        } else {
            commonLiveGiftModel.hit_batch = 0;
            if (commonLiveGiftModel.double_hit == 1) {
                yYSeatMemberModel.setHit_count(yYSeatMemberModel.getHit_count() + 1);
            }
        }
        this.ab.put(yYSeatMemberModel.getUid(), Long.valueOf(yYSeatMemberModel.getHit_id()));
        Logger.e("YYGiftListFragment", "after judge, giftCount = " + i + ", " + commonLiveGiftModel.toString());
    }

    @Override // com.blued.android.module.common.fragment.BaseGiftRootFragment
    public String b() {
        if (TextUtils.isEmpty(this.S)) {
            return super.b();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return "0_0";
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < ((CommonGiftPackageModel) this.b.get(i2)).goods.size()) {
                    YYGiftModel yYGiftModel = (YYGiftModel) ((CommonGiftPackageModel) this.b.get(i2)).goods.get(i4);
                    if (StringUtils.a(this.S, yYGiftModel.goods_id)) {
                        LogUtils.d("YYGiftListFragment", "Update item in allGiftList, index: " + yYGiftModel.index + ", goodsId: " + yYGiftModel.goods_id);
                        return yYGiftModel.index;
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    public void b(LiveGiftNumberModel liveGiftNumberModel) {
        YYGiftModel yYGiftModel = this.C;
        if (yYGiftModel != null) {
            yYGiftModel.selectedGiftNumModel = liveGiftNumberModel;
        }
        B();
    }

    @Override // com.blued.android.module.common.fragment.BaseGiftRootFragment
    public void c(int i) {
        super.c(i);
        LogUtils.d("sendGiftEvent", "onPackageSelected packageIndex: " + i);
        YYGiftPackageModel yYGiftPackageModel = (YYGiftPackageModel) this.ae.get(i);
        if (yYGiftPackageModel == null) {
            return;
        }
        if (this.Z != null) {
            if (YYGiftPackageModel.YY_GIFT_BAG_TYPE_ID.equals(yYGiftPackageModel.type_id)) {
                this.Z.setVisibility(4);
                this.Z.setClickable(false);
                this.K.setTextColor(getResources().getColor(R.color.syc_00E0AB));
            } else {
                this.Z.setVisibility(0);
                this.Z.setClickable(true);
                this.K.setTextColor(getResources().getColor(R.color.syc_989898));
            }
        }
        int i2 = a(b()).pageIndex;
        LogUtils.d("sendGiftEvent", "onPackageSelected packageTabIndex: " + i2);
        List<T> list = yYGiftPackageModel.goods;
        if (list == 0) {
            return;
        }
        if (this.V == null) {
            this.V = new HashMap<>();
        }
        int column = yYGiftPackageModel.getColumn();
        int line = yYGiftPackageModel.getLine();
        for (int column2 = yYGiftPackageModel.getColumn() * i2 * yYGiftPackageModel.getLine(); column2 < (i2 + 1) * column * line && column2 < list.size(); column2++) {
            YYGiftModel yYGiftModel = (YYGiftModel) list.get(column2);
            HashSet<String> hashSet = this.V.get(Integer.valueOf(yYGiftModel.goods_type));
            HashSet<String> hashSet2 = hashSet;
            if (hashSet == null) {
                hashSet2 = new HashSet<>();
                this.V.put(Integer.valueOf(yYGiftModel.goods_type), hashSet2);
            }
            if (hashSet2.contains(yYGiftModel.goods_id)) {
                return;
            }
            hashSet2.add(yYGiftModel.goods_id);
            LogUtils.c("event=" + yYGiftModel.index);
            a(ChatRoomProtos.Event.CHAT_ROOM_GIFT_POP_ONE_GIFT_SHOW, yYGiftModel);
        }
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    public String g() {
        return "yy_gift";
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    public void i() {
        YYRoomHttpUtils.m(new BluedUIHttpResponse<BluedEntity<YYGiftPackageModel, GiftGoodsExtraModle>>(getFragmentActive()) { // from class: com.blued.android.module.yy_china.fragment.YYGiftListFragment.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUICache(BluedEntity<YYGiftPackageModel, GiftGoodsExtraModle> bluedEntity) {
                super.onUICache(bluedEntity);
                YYGiftListFragment.this.a(bluedEntity);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYGiftPackageModel, GiftGoodsExtraModle> bluedEntity) {
                YYGiftListFragment.this.a(bluedEntity);
            }
        }, getFragmentActive());
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    public int k() {
        YYGiftModel yYGiftModel = this.C;
        if (yYGiftModel == null || yYGiftModel.selectedGiftNumModel == null || this.C.selectedGiftNumModel.count <= 0) {
            return 1;
        }
        return this.C.selectedGiftNumModel.count;
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    public void m() {
        D().n();
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    public int n() {
        return R.drawable.icon_gift_up_img;
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    public int o() {
        return R.drawable.icon_gift_down_img;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if ((i == 4221005 || i == 4221004) && intent != null) {
                YYGiftModel yYGiftModel = (YYGiftModel) intent.getSerializableExtra("selected_model");
                YYGiftWantSelectMode yYGiftWantSelectMode = (YYGiftWantSelectMode) intent.getSerializableExtra("want_select");
                String stringExtra = intent.getStringExtra("password");
                boolean booleanExtra = intent.getBooleanExtra("remember_me", false);
                int intExtra = intent.getIntExtra("gift_count", 1);
                if (yYGiftWantSelectMode == null || TextUtils.isEmpty(stringExtra) || yYGiftModel == null) {
                    return;
                }
                a(yYGiftModel, yYGiftWantSelectMode.getWantSelect(), intExtra, stringExtra, booleanExtra);
            } else if (i != 4221002 || intent == null) {
            } else {
                YYGiftModel yYGiftModel2 = (YYGiftModel) intent.getSerializableExtra("selected_model");
                YYGiftWantSelectMode yYGiftWantSelectMode2 = (YYGiftWantSelectMode) intent.getSerializableExtra("want_select");
                int intExtra2 = intent.getIntExtra("gift_count", 1);
                boolean booleanExtra2 = intent.getBooleanExtra("remember_me", false);
                String stringExtra2 = intent.getStringExtra("password");
                if (yYGiftWantSelectMode2 == null) {
                    return;
                }
                a(yYGiftModel2, yYGiftWantSelectMode2.getWantSelect(), intExtra2, stringExtra2, booleanExtra2);
            }
        }
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    public boolean onBackPressed() {
        LogUtils.c("");
        if (super.onBackPressed()) {
            return true;
        }
        LogUtils.c("YYGiftListFragment: " + isHidden());
        if (isHidden()) {
            return false;
        }
        D().n();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_backpack) {
            if (this.h == null || this.h.getAdapter() == null || this.h.getAdapter().getCount() <= 0) {
                return;
            }
            this.h.setCurrentItem(this.h.getAdapter().getCount() - 1);
        } else if (view.getId() == R.id.tv_select_user) {
            SelectUserAdapter selectUserAdapter = this.E;
            if (selectUserAdapter == null) {
                return;
            }
            if (selectUserAdapter.a().size() == this.E.getData().size()) {
                this.E.c();
            } else {
                this.E.b();
            }
            w();
            if (this.Q != null) {
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_GIFT_POP_ALL_CLICK, this.Q.room_id, this.Q.uid);
            }
        } else if (view.getId() == R.id.yy_top_up_first) {
            LiveEventBus.get("frist_rechage").post("0");
        } else if (view.getId() == R.id.ll_gift_count) {
            YYGiftModel yYGiftModel = this.C;
            if (yYGiftModel == null || TypeUtils.a((List<?>) yYGiftModel.goods_number)) {
                return;
            }
            int k = k();
            ArrayList arrayList = new ArrayList();
            for (LiveGiftNumberModel liveGiftNumberModel : this.C.goods_number) {
                if (liveGiftNumberModel.count == k) {
                    liveGiftNumberModel.selected = true;
                } else {
                    liveGiftNumberModel.selected = false;
                }
                arrayList.add(liveGiftNumberModel);
            }
            c(arrayList);
        } else if (view.getId() == R.id.ll_send || view.getId() == R.id.tv_click_doublehit) {
            E();
        } else if (view.getId() == R.id.tv_recharge) {
            if (this.Q != null) {
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_RECHARGE_CLICK, this.Q.room_id, this.Q.uid);
            }
            D().t();
            D().n();
        } else if (view.getId() == R.id.iv_more_leve) {
            if (!StringUtils.b(this.Y)) {
                YYRoomInfoManager.e().c().a(getContext(), this.Y, 0);
            }
            if (this.Q != null) {
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_GIFT_LEVEL_GUIDE_ICON_CLICK, this.Q.room_id, this.Q.uid);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        HashMap<Integer, HashSet<String>> hashMap = this.V;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            this.c = null;
            this.C = null;
            this.y = null;
            t();
            i();
            return;
        }
        BaseGiftModel a = a(this.c);
        if (a != null) {
            a.isSelected = false;
            LiveEventBus.get("gift_item_update").post(a);
        }
        HashMap<Integer, HashSet<String>> hashMap = this.V;
        if (hashMap != null) {
            hashMap.clear();
        }
        DoubleHitSendGiftView doubleHitSendGiftView = this.W;
        if (doubleHitSendGiftView != null) {
            doubleHitSendGiftView.a();
        }
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment, com.blued.android.module.common.fragment.BaseGiftRootFragment
    public void onInitListener() {
        super.onInitListener();
        LiveEventBus.get("show_gift_item", YYGiftModel.class).observe(this, new Observer<YYGiftModel>() { // from class: com.blued.android.module.yy_china.fragment.YYGiftListFragment.1
            /* renamed from: a */
            public void onChanged(YYGiftModel yYGiftModel) {
                if (YYGiftListFragment.this.V == null) {
                    YYGiftListFragment.this.V = new HashMap();
                }
                HashSet hashSet = (HashSet) YYGiftListFragment.this.V.get(Integer.valueOf(yYGiftModel.goods_type));
                HashSet hashSet2 = hashSet;
                if (hashSet == null) {
                    hashSet2 = new HashSet();
                    YYGiftListFragment.this.V.put(Integer.valueOf(yYGiftModel.goods_type), hashSet2);
                }
                if (hashSet2.contains(yYGiftModel.goods_id)) {
                    return;
                }
                hashSet2.add(yYGiftModel.goods_id);
                LogUtils.c("event=" + yYGiftModel.index);
                YYGiftListFragment.this.a(ChatRoomProtos.Event.CHAT_ROOM_GIFT_POP_ONE_GIFT_SHOW, yYGiftModel);
            }
        });
        LiveEventBus.get(LiveEventBusConstant.a, Integer.class).observe(this, new Observer() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYGiftListFragment$enJQ8A_Czu93uIDYKtRheMwNIcY
            public final void onChanged(Object obj) {
                YYGiftListFragment.this.a((Integer) obj);
            }
        });
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment, com.blued.android.module.common.fragment.BaseGiftRootFragment, com.blued.android.module.common.fragment.BaseViewPagerParentFragment
    public void onInitView() {
        super.onInitView();
        this.ac = ViewYyGiftListLayoutBinding.a(this.rootView);
        this.n = this.rootView.findViewById(R.id.live_gift_blank_view);
        this.g = (TextView) this.rootView.findViewById(R.id.tv_price);
        this.l = (TextView) this.rootView.findViewById(R.id.tv_recharge);
        this.m = (TextView) this.rootView.findViewById(R.id.ll_send);
        this.o = (TextView) this.rootView.findViewById(R.id.tv_select_num);
        this.p = (LinearLayout) this.rootView.findViewById(R.id.ll_gift_count);
        this.q = (ImageView) this.rootView.findViewById(R.id.iv_select_num);
        this.r = this.rootView.findViewById(R.id.yy_gift_number_select_layout);
        this.s = (ListView) this.rootView.findViewById(R.id.yy_gift_number_select_list);
        this.D = (LinearLayout) this.rootView.findViewById(R.id.ll_tab_layout);
        this.W = (DoubleHitSendGiftView) this.rootView.findViewById(R.id.tv_click_doublehit);
        this.O = (ShapeLinearLayout) this.rootView.findViewById(R.id.yy_top_up_view);
        this.N = (ImageView) this.rootView.findViewById(R.id.yy_top_up_first);
        this.I = (ShapeTextView) this.rootView.findViewById(R.id.tv_select_user);
        this.D.setVisibility(0);
        this.F = (TextView) this.rootView.findViewById(R.id.tv_no_give);
        this.U = (ShapeLinearLayout) this.rootView.findViewById(R.id.shape_send);
        this.G = (TextView) this.rootView.findViewById(R.id.tv_lv_1);
        this.H = (TextView) this.rootView.findViewById(R.id.tv_lv_2);
        this.L = (ProgressBar) this.rootView.findViewById(R.id.pro_lv);
        this.J = (TextView) this.rootView.findViewById(R.id.tv_last_up_live);
        this.K = (TextView) this.rootView.findViewById(R.id.tv_backpack);
        this.M = this.rootView.findViewById(R.id.rcv_user);
        this.aa = (YYAdInGiftListView) this.rootView.findViewById(R.id.ll_ad_view);
        this.r.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.W.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.rootView.findViewById(R.id.iv_more_leve);
        this.Z = linearLayout;
        linearLayout.setOnClickListener(this);
        v();
        t();
    }

    @Override // com.blued.android.module.common.fragment.BaseGiftRootFragment
    public int onSetRootViewId() {
        return R.layout.view_yy_gift_list_layout;
    }

    @Override // com.blued.android.module.live.base.fragment.LiveGiftBaseFragment
    public void p() {
        this.t = new AnonymousClass4(new ArrayList(), new MultiItemTypeSupport<LiveGiftNumberModel>() { // from class: com.blued.android.module.yy_china.fragment.YYGiftListFragment.3
            @Override // com.blued.android.module.common.adapter.MultiItemTypeSupport
            public int a() {
                return 2;
            }

            @Override // com.blued.android.module.common.adapter.MultiItemTypeSupport
            public int a(int i, LiveGiftNumberModel liveGiftNumberModel) {
                return liveGiftNumberModel.isUserDefined ? R.layout.item_gift_define_num_layout : R.layout.item_gift_num_layout;
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            @Override // com.blued.android.module.common.adapter.MultiItemTypeSupport
            public int b(int i, LiveGiftNumberModel liveGiftNumberModel) {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }
        });
    }

    public void s() {
        this.N.setVisibility(8);
        this.O.setVisibility(0);
    }
}
