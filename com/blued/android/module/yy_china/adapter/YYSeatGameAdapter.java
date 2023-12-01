package com.blued.android.module.yy_china.adapter;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.observer.SeatChangedObserver;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;
import com.blued.android.module.yy_china.view.YYGameView;
import com.blued.android.module.yy_china.view.YYMemberGameView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYSeatGameAdapter.class */
public class YYSeatGameAdapter extends BaseConnectingAdapter<YYSeatMemberModel, BaseViewHolder> implements SeatChangedObserver {

    /* renamed from: a  reason: collision with root package name */
    private BaseYYStudioFragment f16242a;
    private YYRoomModel b;

    /* renamed from: c  reason: collision with root package name */
    private YYGameView f16243c;
    private HashMap<Integer, YYMemberGameView> d;

    private void a() {
        this.f16243c.a(this.f16242a);
    }

    private void b() {
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.b.mics.isEmpty()) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.mics.size()) {
                return;
            }
            this.d.get(Integer.valueOf(i2)).a(this.b.mics.get(i2), this.f16242a.getFragmentActive());
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.yy_china.observer.SeatChangedObserver
    public void a(int i, int i2) {
        int i3;
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.b.mics.isEmpty() || (i3 = i - 1) >= this.b.mics.size()) {
            return;
        }
        YYSeatMemberModel yYSeatMemberModel = this.b.mics.get(i3);
        if (i2 == 1) {
            yYSeatMemberModel.position_status = -1;
        } else {
            yYSeatMemberModel.position_status = i2;
        }
        YYMemberGameView yYMemberGameView = this.d.get(Integer.valueOf(i3));
        if (yYMemberGameView != null) {
            yYMemberGameView.a(yYSeatMemberModel, this.f16242a.getFragmentActive());
        }
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(int i, String str, String str2, YYImModel yYImModel) {
        YYMemberGameView yYMemberGameView = this.d.get(Integer.valueOf(i));
        if (yYMemberGameView == null) {
            return;
        }
        yYMemberGameView.a(this.f16242a.getFragmentActive(), str, str2, yYImModel);
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(YYSeatMemberModel yYSeatMemberModel) {
        YYRoomModel yYRoomModel;
        super.a(yYSeatMemberModel);
        if (yYSeatMemberModel == null || (yYRoomModel = this.b) == null || yYRoomModel.mics == null || this.b.mics.isEmpty()) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.mics.size()) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel2 = this.b.mics.get(i2);
            if (yYSeatMemberModel2 != null && !TextUtils.isEmpty(yYSeatMemberModel2.getUid()) && TextUtils.equals(yYSeatMemberModel2.getUid(), yYSeatMemberModel.getUid())) {
                yYSeatMemberModel2.team_num = yYSeatMemberModel.team_num;
                yYSeatMemberModel2.captain = yYSeatMemberModel.captain;
                yYSeatMemberModel2.election = yYSeatMemberModel.election;
                yYSeatMemberModel2.gift_value = yYSeatMemberModel.gift_value;
                yYSeatMemberModel2.speech_ripple = yYSeatMemberModel.speech_ripple;
                YYMemberGameView yYMemberGameView = this.d.get(Integer.valueOf(i2));
                if (yYMemberGameView != null) {
                    yYMemberGameView.a(yYSeatMemberModel2, this.f16242a.getFragmentActive());
                    return;
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(YYBaseUserHeadView.GetViewX_Y_W_H getViewX_Y_W_H, String str) {
        YYMemberGameView yYMemberGameView;
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.b.mics.isEmpty()) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.mics.size()) {
                return;
            }
            if (StringUtils.a(str, this.b.mics.get(i2).getUid()) && (yYMemberGameView = this.d.get(Integer.valueOf(i2))) != null) {
                yYMemberGameView.a(getViewX_Y_W_H);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYSeatMemberModel yYSeatMemberModel) {
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYSeatGameAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        if (yYSeatMemberModel.getItemType() != 7) {
            return;
        }
        this.f16243c = (YYGameView) baseViewHolder.itemView.findViewById(R.id.yy_game_layout);
        YYMemberGameView yYMemberGameView = (YYMemberGameView) baseViewHolder.itemView.findViewById(R.id.user_1);
        YYMemberGameView yYMemberGameView2 = (YYMemberGameView) baseViewHolder.itemView.findViewById(R.id.user_2);
        YYMemberGameView yYMemberGameView3 = (YYMemberGameView) baseViewHolder.itemView.findViewById(R.id.user_3);
        YYMemberGameView yYMemberGameView4 = (YYMemberGameView) baseViewHolder.itemView.findViewById(R.id.user_4);
        YYMemberGameView yYMemberGameView5 = (YYMemberGameView) baseViewHolder.itemView.findViewById(R.id.user_5);
        YYMemberGameView yYMemberGameView6 = (YYMemberGameView) baseViewHolder.itemView.findViewById(R.id.user_6);
        YYMemberGameView yYMemberGameView7 = (YYMemberGameView) baseViewHolder.itemView.findViewById(R.id.user_7);
        this.d.put(0, yYMemberGameView);
        this.d.put(1, yYMemberGameView2);
        this.d.put(2, yYMemberGameView3);
        this.d.put(3, yYMemberGameView4);
        this.d.put(4, yYMemberGameView5);
        this.d.put(5, yYMemberGameView6);
        this.d.put(6, yYMemberGameView7);
        a();
        b();
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(String str, String str2) {
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.b.mics.isEmpty()) {
            return;
        }
        int i = 0;
        for (YYSeatMemberModel yYSeatMemberModel : this.b.mics) {
            if (TextUtils.equals(yYSeatMemberModel.getUid(), str)) {
                yYSeatMemberModel.chat_anchor = str2;
                this.d.get(Integer.valueOf(i)).a(yYSeatMemberModel, this.f16242a.getFragmentActive());
                return;
            }
            i++;
        }
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(Set<String> set) {
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.b.mics.isEmpty()) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.mics.size()) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel = this.b.mics.get(i2);
            if (yYSeatMemberModel.is_open_mic != 0) {
                if (set == null || set.isEmpty() || !set.contains(yYSeatMemberModel.getUid())) {
                    yYSeatMemberModel.is_open_mic = 1;
                } else {
                    yYSeatMemberModel.is_open_mic = 2;
                }
                YYMemberGameView yYMemberGameView = this.d.get(Integer.valueOf(i2));
                if (yYMemberGameView != null) {
                    yYMemberGameView.a(set, yYSeatMemberModel);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.yy_china.observer.SeatChangedObserver
    public void b(List<YYSeatMemberModel> list) {
        if (list == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel = list.get(i2);
            YYMemberGameView yYMemberGameView = this.d.get(Integer.valueOf(i2));
            if (yYMemberGameView != null) {
                yYMemberGameView.a(yYSeatMemberModel, this.f16242a.getFragmentActive());
            }
            i = i2 + 1;
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        Logger.e("observer", "YYConnectingAdapter onAttachedToRecyclerView ...");
        YYObserverManager.a().a(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
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

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<YYSeatMemberModel> list) {
        ArrayList arrayList = new ArrayList();
        YYSeatMemberModel yYSeatMemberModel = new YYSeatMemberModel();
        yYSeatMemberModel.itemType = 7;
        arrayList.add(yYSeatMemberModel);
        super.setNewData(arrayList);
    }
}
