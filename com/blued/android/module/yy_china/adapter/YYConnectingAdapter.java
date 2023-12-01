package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.BlindPublishModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.observer.SeatChangedObserver;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYConnectingAdapter.class */
public class YYConnectingAdapter extends BaseConnectingAdapter<YYSeatMemberModel, BaseViewHolder> implements SeatChangedObserver {
    private BaseYYStudioFragment a;

    public YYConnectingAdapter(Context context, BaseYYStudioFragment baseYYStudioFragment) {
        super(null);
        this.a = baseYYStudioFragment;
        this.mContext = context;
        addItemType(0, R.layout.item_yy_connecting_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, YYSeatMemberModel yYSeatMemberModel, int i) {
        TextView textView = (TextView) view.findViewById(R.id.tv_audience_name);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_audience_index);
        YYBaseUserHeadView yYBaseUserHeadView = (YYBaseUserHeadView) view.findViewById(R.id.base_us_head);
        textView2.setText(yYSeatMemberModel.mic_position + "");
        if (TextUtils.isEmpty(yYSeatMemberModel.getName())) {
            textView.setText("");
        } else {
            textView.setText(yYSeatMemberModel.getName());
        }
        yYBaseUserHeadView.a(yYSeatMemberModel, this.a.getFragmentActive());
    }

    @Override // com.blued.android.module.yy_china.observer.SeatChangedObserver
    public void a(final int i, final int i2) {
        this.a.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.adapter.YYConnectingAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                YYSeatMemberModel yYSeatMemberModel = (YYSeatMemberModel) YYConnectingAdapter.this.getData().get(i - 1);
                int i3 = i2;
                if (i3 == 1) {
                    yYSeatMemberModel.position_status = -1;
                } else {
                    yYSeatMemberModel.position_status = i3;
                }
                YYBaseUserHeadView yYBaseUserHeadView = (YYBaseUserHeadView) YYConnectingAdapter.this.getViewByPosition(i - 1, R.id.base_us_head);
                if (yYBaseUserHeadView != null) {
                    yYBaseUserHeadView.a(yYSeatMemberModel, YYConnectingAdapter.this.a.getFragmentActive());
                }
            }
        });
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(int i, int i2, boolean z) {
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
    public void a(YYBaseUserHeadView.GetViewX_Y_W_H getViewX_Y_W_H, String str) {
        View viewByPosition;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getData().size()) {
                return;
            }
            if (StringUtils.a(((YYSeatMemberModel) getData().get(i2)).getUid(), str) && (viewByPosition = getViewByPosition(i2, R.id.base_us_head)) != null && (viewByPosition instanceof YYBaseUserHeadView)) {
                ((YYBaseUserHeadView) viewByPosition).a(getViewX_Y_W_H);
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
    public void a(List<BlindPublishModel> list) {
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
        this.a.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.adapter.YYConnectingAdapter.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v24, types: [java.util.List] */
            @Override // java.lang.Runnable
            public void run() {
                if (list == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                if (list.size() > 8) {
                    arrayList = list.subList(0, 8);
                } else {
                    arrayList.addAll(list);
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    YYSeatMemberModel yYSeatMemberModel = (YYSeatMemberModel) arrayList.get(i);
                    View viewByPosition = YYConnectingAdapter.this.getViewByPosition(i, R.id.yy_connectting_root);
                    if (viewByPosition != null) {
                        YYConnectingAdapter.this.a(viewByPosition, yYSeatMemberModel, i);
                    }
                }
            }
        });
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void c() {
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
