package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.observer.SeatChangedObserver;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYConnectingGameAdapter.class */
public class YYConnectingGameAdapter extends BaseConnectingAdapter<YYSeatMemberModel, BaseViewHolder> implements SeatChangedObserver {
    private BaseYYStudioFragment a;
    private YYRoomModel b;

    public YYConnectingGameAdapter(Context context, BaseYYStudioFragment baseYYStudioFragment) {
        super(null);
        this.a = baseYYStudioFragment;
        this.mContext = context;
        this.b = YYRoomInfoManager.e().b();
        addItemType(0, R.layout.item_yy_connecting_game_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, YYSeatMemberModel yYSeatMemberModel, int i) {
        TextView textView = (TextView) view.findViewById(R.id.tv_audience_name);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_audience_index);
        TextView textView3 = (TextView) view.findViewById(R.id.tv_active_value);
        TextView textView4 = (TextView) view.findViewById(R.id.tv_team_number);
        TextView textView5 = (TextView) view.findViewById(R.id.tv_leader_election);
        YYBaseUserHeadView yYBaseUserHeadView = (YYBaseUserHeadView) view.findViewById(R.id.base_us_head);
        double a = StringUtils.a(yYSeatMemberModel.gift_value, 0);
        textView3.setText(a > 0.0d ? CommonStringUtils.b(a) : "");
        textView5.setVisibility(8);
        textView4.setVisibility(8);
        int a2 = StringUtils.a(yYSeatMemberModel.election, 0);
        int a3 = StringUtils.a(yYSeatMemberModel.team_num, 0);
        int a4 = StringUtils.a(yYSeatMemberModel.captain, 0);
        if (a2 != 0) {
            textView4.setVisibility(8);
            textView5.setVisibility(0);
        }
        if (a3 != 0) {
            textView5.setVisibility(8);
            textView4.setVisibility(0);
            textView4.setText(a3 + "");
            if (a3 == 1) {
                textView4.setBackgroundResource(R.drawable.shape_layer_team_one);
            } else {
                textView4.setBackgroundResource(R.drawable.shape_layer_team_two);
            }
        }
        if (a4 != 0 && a3 != 0) {
            textView5.setVisibility(8);
            textView4.setVisibility(0);
            textView4.setText(a3 + "队");
            if (a3 == 1) {
                textView4.setBackgroundResource(R.drawable.shape_layer_team_one);
            } else {
                textView4.setBackgroundResource(R.drawable.shape_layer_team_two);
            }
        }
        if (i == 0) {
            textView4.setVisibility(8);
            textView5.setVisibility(8);
        }
        textView2.setText(yYSeatMemberModel.mic_position + "");
        if (textView != null) {
            if (TextUtils.isEmpty(yYSeatMemberModel.getName())) {
                textView.setText("");
            } else {
                textView.setText(yYSeatMemberModel.getName());
            }
        }
        yYBaseUserHeadView.a(yYSeatMemberModel, this.a.getFragmentActive());
    }

    @Override // com.blued.android.module.yy_china.observer.SeatChangedObserver
    public void a(final int i, final int i2) {
        this.a.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.adapter.YYConnectingGameAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                int i3 = i - 1;
                if (i3 >= YYConnectingGameAdapter.this.getData().size()) {
                    return;
                }
                YYSeatMemberModel yYSeatMemberModel = (YYSeatMemberModel) YYConnectingGameAdapter.this.getData().get(i3);
                int i4 = i2;
                if (i4 == 1) {
                    yYSeatMemberModel.position_status = -1;
                } else {
                    yYSeatMemberModel.position_status = i4;
                }
                YYBaseUserHeadView yYBaseUserHeadView = (YYBaseUserHeadView) YYConnectingGameAdapter.this.getViewByPosition(i3, R.id.base_us_head);
                if (yYBaseUserHeadView != null) {
                    yYBaseUserHeadView.a(yYSeatMemberModel, YYConnectingGameAdapter.this.a.getFragmentActive());
                }
            }
        });
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(int i, String str, String str2, YYImModel yYImModel) {
        YYBaseUserHeadView yYBaseUserHeadView = (YYBaseUserHeadView) getViewByPosition(i, R.id.base_us_head);
        if (yYBaseUserHeadView == null) {
            return;
        }
        yYBaseUserHeadView.a(this.a.getFragmentActive(), str, str2, yYImModel);
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(YYSeatMemberModel yYSeatMemberModel) {
        super.a(yYSeatMemberModel);
        if (yYSeatMemberModel == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getData().size()) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel2 = (YYSeatMemberModel) getData().get(i2);
            if (yYSeatMemberModel2 != null && !TextUtils.isEmpty(yYSeatMemberModel2.getUid()) && TextUtils.equals(yYSeatMemberModel2.getUid(), yYSeatMemberModel.getUid())) {
                yYSeatMemberModel2.team_num = yYSeatMemberModel.team_num;
                yYSeatMemberModel2.captain = yYSeatMemberModel.captain;
                yYSeatMemberModel2.election = yYSeatMemberModel.election;
                yYSeatMemberModel2.gift_value = yYSeatMemberModel.gift_value;
                View viewByPosition = getViewByPosition(i2, R.id.yy_connectting_root);
                if (viewByPosition != null) {
                    a(viewByPosition, yYSeatMemberModel2, i2);
                    return;
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(YYBaseUserHeadView.GetViewX_Y_W_H getViewX_Y_W_H, String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getData().size()) {
                return;
            }
            if (StringUtils.a(((YYSeatMemberModel) getData().get(i2)).getUid(), str)) {
                ((YYBaseUserHeadView) getViewByPosition(i2, R.id.base_us_head)).a(getViewX_Y_W_H);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYSeatMemberModel yYSeatMemberModel) {
        a(baseViewHolder.itemView, yYSeatMemberModel, baseViewHolder.getAdapterPosition());
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(String str, String str2) {
        Iterator it = getData().iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel = (YYSeatMemberModel) it.next();
            if (TextUtils.equals(yYSeatMemberModel.getUid(), str)) {
                yYSeatMemberModel.chat_anchor = str2;
                YYBaseUserHeadView yYBaseUserHeadView = (YYBaseUserHeadView) getViewByPosition(i2, R.id.base_us_head);
                if (yYBaseUserHeadView != null) {
                    yYBaseUserHeadView.a(yYSeatMemberModel, this.a.getFragmentActive());
                    return;
                }
                return;
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(Set<String> set) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getData().size()) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel = (YYSeatMemberModel) getData().get(i2);
            if (yYSeatMemberModel.is_open_mic != 0) {
                if (set == null || set.isEmpty() || !set.contains(yYSeatMemberModel.getUid())) {
                    yYSeatMemberModel.is_open_mic = 1;
                } else {
                    yYSeatMemberModel.is_open_mic = 2;
                }
                YYBaseUserHeadView yYBaseUserHeadView = (YYBaseUserHeadView) getViewByPosition(i2, R.id.base_us_head);
                if (yYBaseUserHeadView != null) {
                    yYBaseUserHeadView.a(set, yYSeatMemberModel);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.yy_china.observer.SeatChangedObserver
    public void b(final List<YYSeatMemberModel> list) {
        this.a.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.adapter.YYConnectingGameAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                if (list == null) {
                    return;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        return;
                    }
                    YYSeatMemberModel yYSeatMemberModel = (YYSeatMemberModel) list.get(i2);
                    View viewByPosition = YYConnectingGameAdapter.this.getViewByPosition(i2, R.id.yy_connectting_root);
                    if (viewByPosition != null) {
                        YYConnectingGameAdapter.this.a(viewByPosition, yYSeatMemberModel, i2);
                    }
                    i = i2 + 1;
                }
            }
        });
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        Logger.e("observer", "YYConnectingAdapter onAttachedToRecyclerView ...");
        YYObserverManager.a().a(this);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        Logger.e("observer", "YYConnectingAdapter onDetachedFromRecyclerView ...");
        YYObserverManager.a().b(this);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        b.clearEmojiAndSendMessage();
    }
}
