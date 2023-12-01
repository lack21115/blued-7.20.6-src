package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYRewardAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.IPunishClickListener;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRewardModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYPunishListView.class */
public class YYPunishListView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f18384a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private ShapeTextView f18385c;
    private YYRewardAdapter d;
    private IPunishClickListener e;

    public YYPunishListView(Context context) {
        super(context);
        a();
    }

    public YYPunishListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYPunishListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.pop_pk_reward_layout, (ViewGroup) this, true);
        this.f18384a = (RecyclerView) findViewById(R.id.rv_reward_list);
        this.b = (TextView) findViewById(R.id.tv_create_title);
        this.f18385c = (ShapeTextView) findViewById(R.id.tv_ok_reward);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.f18384a.setLayoutManager(linearLayoutManager);
        YYRewardAdapter yYRewardAdapter = new YYRewardAdapter();
        this.d = yYRewardAdapter;
        this.f18384a.setAdapter(yYRewardAdapter);
        this.d.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.view.YYPunishListView.1
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
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
                        ShapeHelper.a(YYPunishListView.this.f18385c, R.color.syc_00E0AB, R.color.syc_3883FD);
                        YYPunishListView.this.f18385c.setEnabled(true);
                    } else {
                        yYRewardModel.selected = false;
                    }
                    i2 = i3 + 1;
                }
            }
        });
        this.f18385c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYPunishListView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                YYRewardModel yYRewardModel;
                Tracker.onClick(view);
                if (YYPunishListView.this.e != null) {
                    Iterator<YYRewardModel> it = YYPunishListView.this.d.getData().iterator();
                    do {
                        yYRewardModel = null;
                        if (!it.hasNext()) {
                            break;
                        }
                        yYRewardModel = it.next();
                    } while (!yYRewardModel.selected);
                    YYPunishListView.this.e.a(yYRewardModel);
                }
            }
        });
    }

    private void a(BaseYYStudioFragment baseYYStudioFragment) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.H(b.room_id, new BluedUIHttpResponse<BluedEntityA<YYRewardModel>>(baseYYStudioFragment.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYPunishListView.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYRewardModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                YYPunishListView.this.setItemList(bluedEntityA.data);
            }
        }, baseYYStudioFragment.getFragmentActive());
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment, int i) {
        if (i != 1) {
            return;
        }
        a(baseYYStudioFragment);
    }

    public void setConfirmListener(IPunishClickListener iPunishClickListener) {
        this.e = iPunishClickListener;
    }

    public void setItemList(List<YYRewardModel> list) {
        YYRewardAdapter yYRewardAdapter = this.d;
        if (yYRewardAdapter != null) {
            yYRewardAdapter.setNewData(list);
        }
    }

    public void setTitleText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.b.setVisibility(8);
        } else {
            this.b.setText(str);
        }
    }
}
