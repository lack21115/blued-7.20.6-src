package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYPkGiftAdapter;
import com.blued.android.module.yy_china.adapter.YYRewardAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYPkGiftModel;
import com.blued.android.module.yy_china.model.YYPkGoodsModel;
import com.blued.android.module.yy_china.model.YYRewardModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYVoteTimeModel;
import com.blued.android.module.yy_china.utils.PopupwindowFactory;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYCreatePKView.class */
public class YYCreatePKView extends LinearLayout implements View.OnClickListener {
    private YYSetTimeView a;
    private YYPlayersView b;
    private RecyclerView c;
    private YYPkGiftAdapter d;
    private TextView e;
    private TextView f;
    private ImageView g;
    private ImageView h;
    private ShapeTextView i;
    private PopupWindow j;
    private BaseYYStudioFragment k;
    private int l;
    private String m;
    private YYPkGiftModel n;
    private HashMap<Integer, String> o;

    public YYCreatePKView(Context context) {
        super(context);
        this.l = -1;
        a();
    }

    public YYCreatePKView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = -1;
        a();
    }

    public YYCreatePKView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = -1;
        a();
    }

    private View a(final boolean z, List<YYRewardModel> list) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pop_pk_reward_layout, (ViewGroup) null);
        RecyclerView findViewById = inflate.findViewById(R.id.rv_reward_list);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_create_title);
        final ShapeTextView shapeTextView = (ShapeTextView) inflate.findViewById(R.id.tv_ok_reward);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        findViewById.setLayoutManager(linearLayoutManager);
        textView.setText(String.format(getResources().getString(R.string.yy_pk_reward_title), z ? "A" : "B"));
        final YYRewardAdapter yYRewardAdapter = new YYRewardAdapter();
        findViewById.setAdapter(yYRewardAdapter);
        yYRewardAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.view.YYCreatePKView.4
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= baseQuickAdapter.getData().size()) {
                        baseQuickAdapter.notifyDataSetChanged();
                        return;
                    }
                    YYRewardModel yYRewardModel = (YYRewardModel) baseQuickAdapter.getData().get(i3);
                    if (i3 == i) {
                        yYRewardModel.selected = true;
                        ShapeHelper.a(shapeTextView, R.color.syc_00E0AB, R.color.syc_3883FD);
                        shapeTextView.setEnabled(true);
                    } else {
                        yYRewardModel.selected = false;
                    }
                    i2 = i3 + 1;
                }
            }
        });
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYCreatePKView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                YYRewardModel yYRewardModel;
                Tracker.onClick(view);
                Iterator it = yYRewardAdapter.getData().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        yYRewardModel = null;
                        break;
                    }
                    yYRewardModel = (YYRewardModel) it.next();
                    if (yYRewardModel.selected) {
                        break;
                    }
                }
                if (z) {
                    YYCreatePKView.this.e.setTextColor(YYCreatePKView.this.getResources().getColor(R.color.syc_dark_b));
                    YYCreatePKView.this.g.setImageResource(R.drawable.icon_yy_reward_selected_left);
                    YYCreatePKView.this.e.setText(yYRewardModel.event_name);
                    YYCreatePKView.this.o.put(0, yYRewardModel.event_id);
                } else {
                    YYCreatePKView.this.f.setTextColor(YYCreatePKView.this.getResources().getColor(R.color.syc_dark_b));
                    YYCreatePKView.this.h.setImageResource(R.drawable.icon_yy_reward_selected_right);
                    YYCreatePKView.this.f.setText(yYRewardModel.event_name);
                    YYCreatePKView.this.o.put(1, yYRewardModel.event_id);
                }
                YYCreatePKView.this.e();
                YYCreatePKView.this.j.dismiss();
            }
        });
        yYRewardAdapter.setNewData(list);
        return inflate;
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_create_pk, (ViewGroup) this, true);
        this.a = (YYSetTimeView) findViewById(R.id.set_time_layout);
        this.c = findViewById(R.id.rv_pkgift_list);
        this.b = (YYPlayersView) findViewById(R.id.player_choose_layout);
        this.e = (TextView) findViewById(R.id.tv_reward_left);
        this.f = (TextView) findViewById(R.id.tv_reward_right);
        this.g = (ImageView) findViewById(R.id.iv_reward_bg_left);
        this.h = (ImageView) findViewById(R.id.iv_reward_bg_right);
        this.i = (ShapeTextView) findViewById(R.id.tv_create_pk);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.i.setOnClickListener(this);
        b();
        c();
        d();
    }

    private void a(final int i) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.i(b.room_id, i, new BluedUIHttpResponse<BluedEntityA<YYRewardModel>>(this.k.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYCreatePKView.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYRewardModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                YYCreatePKView.this.b(i == 0, bluedEntityA.data);
            }
        }, this.k.getFragmentActive());
    }

    private void b() {
        this.b.setPlayerTitle(getResources().getString(R.string.yy_pk_user));
        this.b.setMarginTop(DensityUtils.a(getContext(), 8.0f));
        this.b.setOnClickTimeItemListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.view.YYCreatePKView.1
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= baseQuickAdapter.getData().size()) {
                        baseQuickAdapter.notifyDataSetChanged();
                        YYCreatePKView.this.e();
                        return;
                    }
                    YYSeatMemberModel yYSeatMemberModel = (YYSeatMemberModel) baseQuickAdapter.getData().get(i3);
                    if (i3 == i) {
                        yYSeatMemberModel.isVoted = true;
                        YYCreatePKView.this.m = yYSeatMemberModel.getUid();
                    } else {
                        yYSeatMemberModel.isVoted = false;
                    }
                    i2 = i3 + 1;
                }
            }
        });
        this.b.setPlayerList(getPlayerList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, List<YYRewardModel> list) {
        this.j = new PopupwindowFactory.Builder(getContext()).a(a(z, list)).a(80).c(getHeight()).b(-1).d(R.color.transparent).h();
    }

    private void c() {
        this.d = new YYPkGiftAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.c.setLayoutManager(linearLayoutManager);
        this.c.setAdapter(this.d);
        this.d.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.view.YYCreatePKView.2
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= baseQuickAdapter.getData().size()) {
                        baseQuickAdapter.notifyDataSetChanged();
                        YYCreatePKView.this.e();
                        return;
                    }
                    YYPkGiftModel yYPkGiftModel = (YYPkGiftModel) baseQuickAdapter.getData().get(i3);
                    if (i3 == i) {
                        yYPkGiftModel.selected = true;
                        YYCreatePKView.this.n = yYPkGiftModel;
                    } else {
                        yYPkGiftModel.selected = false;
                    }
                    i2 = i3 + 1;
                }
            }
        });
    }

    private void d() {
        this.a.setTimeTitle(getResources().getString(R.string.yy_pk_duration));
        this.a.setMarginTop(DensityUtils.a(getContext(), 8.0f));
        this.a.setTimeRangeList(getTimeList());
        this.a.setOnClickTimeItemListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.view.YYCreatePKView.3
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= baseQuickAdapter.getItemCount()) {
                        baseQuickAdapter.notifyDataSetChanged();
                        YYCreatePKView.this.e();
                        return;
                    }
                    YYVoteTimeModel yYVoteTimeModel = (YYVoteTimeModel) baseQuickAdapter.getItem(i3);
                    if (i3 == i) {
                        yYVoteTimeModel.isCheck = true;
                        YYCreatePKView.this.l = i;
                    } else {
                        yYVoteTimeModel.isCheck = false;
                    }
                    i2 = i3 + 1;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        YYPkGiftModel yYPkGiftModel;
        HashMap<Integer, String> hashMap;
        if (TextUtils.isEmpty(this.m) || this.l < 0 || (yYPkGiftModel = this.n) == null || yYPkGiftModel.gifts == null || this.n.gifts.isEmpty() || (hashMap = this.o) == null || hashMap.isEmpty() || this.o.size() < 2) {
            this.i.setEnabled(false);
            ShapeHelper.a(this.i, R.color.syc_272727, R.color.syc_272727);
            ShapeHelper.a((ShapeHelper.ShapeView) this.i, R.color.syc_dark_j);
            return;
        }
        this.i.setEnabled(true);
        ShapeHelper.a(this.i, R.color.syc_00E0AB, R.color.syc_3883FD);
        ShapeHelper.a((ShapeHelper.ShapeView) this.i, R.color.syc_dark_b);
    }

    private void f() {
        ArrayList arrayList = new ArrayList();
        for (YYPkGoodsModel yYPkGoodsModel : this.n.gifts) {
            arrayList.add(yYPkGoodsModel.goods_id);
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.a(b.room_id, this.o.get(0), this.o.get(1), (String) arrayList.get(0), (String) arrayList.get(1), this.m, this.l, new BluedUIHttpResponse(this.k.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYCreatePKView.6
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                YYCreatePKView.this.k.y();
            }
        }, this.k.getFragmentActive());
    }

    private void getPkGoodsList() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.z(b.room_id, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYPkGiftModel>>(this.k.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYCreatePKView.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYPkGiftModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                YYCreatePKView.this.d.setNewData(bluedEntityA.data);
            }
        }, (IRequestHost) this.k.getFragmentActive());
    }

    private List<YYSeatMemberModel> getPlayerList() {
        ArrayList arrayList = new ArrayList();
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return arrayList;
        }
        for (YYSeatMemberModel yYSeatMemberModel : b.getHasPeopleMics()) {
            arrayList.add(yYSeatMemberModel.copy());
        }
        return arrayList;
    }

    private List<YYVoteTimeModel> getTimeList() {
        String[] stringArray = getResources().getStringArray(R.array.yy_vote_times);
        String[] stringArray2 = getResources().getStringArray(R.array.yy_vote_time_mill);
        if (stringArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= stringArray.length) {
                return arrayList;
            }
            YYVoteTimeModel yYVoteTimeModel = new YYVoteTimeModel();
            yYVoteTimeModel.timeStr = stringArray[i2];
            if (i2 < stringArray2.length) {
                yYVoteTimeModel.timeMill = StringUtils.a(stringArray2[i2], 0);
            }
            if (i2 == 0) {
                yYVoteTimeModel.isCheck = true;
                this.l = 0;
            }
            arrayList.add(yYVoteTimeModel);
            i = i2 + 1;
        }
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.k = baseYYStudioFragment;
        this.o = new HashMap<>();
        getPkGoodsList();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.tv_reward_left) {
            if (ClickUtils.a(R.id.tv_reward_left)) {
                return;
            }
            a(0);
        } else if (view.getId() == R.id.tv_reward_right) {
            if (ClickUtils.a(R.id.tv_reward_right)) {
                return;
            }
            a(1);
        } else if (view.getId() == R.id.tv_create_pk) {
            if (TextUtils.isEmpty(this.m)) {
                ToastUtils.a("请选择奖励嘉宾");
            } else if (this.l < 0) {
                ToastUtils.a("请设置pk时间");
            } else {
                HashMap<Integer, String> hashMap = this.o;
                if (hashMap == null || hashMap.isEmpty()) {
                    ToastUtils.a("请设置pk奖励");
                    return;
                }
                YYPkGiftModel yYPkGiftModel = this.n;
                if (yYPkGiftModel == null || yYPkGiftModel.gifts == null || this.n.gifts.isEmpty()) {
                    ToastUtils.a("请设置pk礼物");
                } else {
                    f();
                }
            }
        }
    }
}
