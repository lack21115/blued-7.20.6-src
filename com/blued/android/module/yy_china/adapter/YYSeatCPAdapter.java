package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.BlindPublishModel;
import com.blued.android.module.yy_china.model.CpRoomChooseMode;
import com.blued.android.module.yy_china.model.YYCPStepModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYStepModel;
import com.blued.android.module.yy_china.observer.SeatChangedObserver;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.TakeOffMaskTimerView;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;
import com.blued.android.module.yy_china.view.YYMemberCPView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYSeatCPAdapter.class */
public abstract class YYSeatCPAdapter extends BaseConnectingAdapter<YYSeatMemberModel, BaseViewHolder> implements View.OnClickListener, SeatChangedObserver {
    protected BaseYYStudioFragment a;
    protected YYStepModel b;
    protected YYRoomModel c;
    protected ArrayList<YYStepModel> d;
    protected HashMap<Integer, YYMemberCPView> e;

    public YYSeatCPAdapter(Context context, BaseYYStudioFragment baseYYStudioFragment) {
        super(null);
        this.a = baseYYStudioFragment;
        this.mContext = context;
        this.e = new HashMap<>();
        g();
    }

    private void a(int i) {
        YYRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<YYCPStepModel>>(this.a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.adapter.YYSeatCPAdapter.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYCPStepModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData() || bluedEntityA.getSingleData() == null) {
                    return;
                }
                YYCPStepModel yYCPStepModel = new YYCPStepModel();
                yYCPStepModel.present_step = bluedEntityA.getSingleData().present_step;
                yYCPStepModel.next_step = bluedEntityA.getSingleData().next_step;
                if (YYSeatCPAdapter.this.c != null) {
                    YYSeatCPAdapter.this.c.setCPPresentStep(yYCPStepModel.present_step);
                    YYSeatCPAdapter.this.c.setCPNextStep(yYCPStepModel.next_step);
                }
            }
        }, this.c.room_id, i, this.a.getFragmentActive());
    }

    private void a(int i, YYSeatMemberModel yYSeatMemberModel) {
        YYMemberCPView yYMemberCPView = this.e.get(Integer.valueOf(i));
        if (yYMemberCPView == null) {
            return;
        }
        yYMemberCPView.setOnSelectListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYSeatCPAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                String str = (String) view.getTag();
                if (!TextUtils.isEmpty(str)) {
                    YYSeatCPAdapter.this.e().setVisibility(0);
                }
                YYSeatCPAdapter.this.a(str);
            }
        });
        yYMemberCPView.a(yYSeatMemberModel, this.a);
        yYMemberCPView.a(yYSeatMemberModel);
    }

    private void a(String str, final YYSeatMemberModel yYSeatMemberModel) {
        YYRoomHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<CpRoomChooseMode>>(this.a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.adapter.YYSeatCPAdapter.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<CpRoomChooseMode> bluedEntityA) {
                YYSeatCPAdapter.this.h();
                if (bluedEntityA.getSingleData() == null) {
                    return;
                }
                CpRoomChooseMode singleData = bluedEntityA.getSingleData();
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b == null || b.mics == null) {
                    return;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= b.mics.size()) {
                        return;
                    }
                    if (StringUtils.a(b.mics.get(i2).getUid(), yYSeatMemberModel.getUid())) {
                        YYImModel yYImModel = new YYImModel();
                        singleData.setUid(yYSeatMemberModel.getUid());
                        if (i2 == 9) {
                            singleData.setContName("老板位");
                        } else {
                            singleData.setContName(i2 + "号麦位");
                        }
                        singleData.setContRealName(yYSeatMemberModel.getName());
                        yYImModel.extra = singleData;
                        yYImModel.type = -7;
                        YYImMsgManager.a().a(yYImModel);
                    }
                    i = i2 + 1;
                }
            }
        }, str, yYSeatMemberModel.getUid(), this.a.getFragmentActive());
    }

    private void b(int i) {
        ArrayList<YYStepModel> arrayList = this.d;
        if (arrayList == null || i >= arrayList.size()) {
            return;
        }
        Iterator<YYStepModel> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().isChecked = false;
        }
        YYStepModel yYStepModel = this.d.get(i);
        this.b = yYStepModel;
        yYStepModel.isChecked = true;
        b();
        if (i != 2) {
            h();
        }
        LiveEventBus.get("refresh_dating_step").post(this.b);
    }

    private void b(int i, YYSeatMemberModel yYSeatMemberModel) {
        a(i, yYSeatMemberModel);
    }

    private void c(int i) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(d());
        int id = this.e.get(Integer.valueOf(i)).getId();
        constraintSet.connect(R.id.btn_selected, 3, id, 3);
        constraintSet.connect(R.id.btn_selected, 1, id, 1);
        constraintSet.connect(R.id.btn_selected, 2, id, 2);
        constraintSet.applyTo(d());
    }

    private ArrayList<YYStepModel> g() {
        this.d = new ArrayList<>();
        String[] stringArray = this.mContext.getResources().getStringArray(R.array.yy_cp_step);
        if (stringArray == null || stringArray.length <= 0) {
            return null;
        }
        this.c = YYRoomInfoManager.e().b();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= stringArray.length) {
                return this.d;
            }
            String str = stringArray[i2];
            YYStepModel yYStepModel = new YYStepModel();
            yYStepModel.stepIndex = i2;
            yYStepModel.name = str;
            yYStepModel.isChecked = false;
            yYStepModel.isLastOne = i2 == stringArray.length - 1;
            YYRoomModel yYRoomModel = this.c;
            if (yYRoomModel != null) {
                if (i2 < yYRoomModel.getCPPresentStep()) {
                    yYStepModel.isChecked = true;
                } else if (i2 == this.c.getCPPresentStep()) {
                    yYStepModel.isChecked = true;
                    this.b = yYStepModel;
                }
            }
            this.d.add(yYStepModel);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        e().setVisibility(8);
        for (YYMemberCPView yYMemberCPView : this.e.values()) {
            if (yYMemberCPView != null) {
                yYMemberCPView.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        YYRoomModel yYRoomModel = this.c;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.c.mics.isEmpty()) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.mics.size()) {
                return;
            }
            b(i2, this.c.mics.get(i2));
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.yy_china.observer.SeatChangedObserver
    public void a(int i, int i2) {
        YYRoomModel yYRoomModel = this.c;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.c.mics.isEmpty() || i >= this.c.mics.size()) {
            return;
        }
        YYSeatMemberModel yYSeatMemberModel = this.c.mics.get(i);
        if (i2 == 1) {
            yYSeatMemberModel.position_status = -1;
        } else {
            yYSeatMemberModel.position_status = i2;
        }
        YYMemberCPView yYMemberCPView = this.e.get(Integer.valueOf(i));
        if (yYMemberCPView == null) {
            return;
        }
        yYMemberCPView.a(yYSeatMemberModel, this.a);
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(int i, int i2, boolean z) {
        b(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, View view) {
        YYRoomModel yYRoomModel = this.c;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.c.mics.isEmpty() || i > this.c.mics.size() - 1 || i < 0) {
            return;
        }
        YYSeatMemberModel yYSeatMemberModel = this.c.mics.get(i);
        this.a.a(view, yYSeatMemberModel, yYSeatMemberModel.mic_position);
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(int i, String str, String str2, YYImModel yYImModel) {
        YYMemberCPView yYMemberCPView = this.e.get(Integer.valueOf(i));
        if (yYMemberCPView == null) {
            return;
        }
        yYMemberCPView.a(this.a.getFragmentActive(), str, str2, yYImModel);
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(YYBaseUserHeadView.GetViewX_Y_W_H getViewX_Y_W_H, String str) {
        YYMemberCPView yYMemberCPView;
        YYRoomModel yYRoomModel = this.c;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.c.mics.isEmpty()) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.mics.size()) {
                return;
            }
            if (StringUtils.a(str, this.c.mics.get(i2).getUid()) && (yYMemberCPView = this.e.get(Integer.valueOf(i2))) != null) {
                yYMemberCPView.a(getViewX_Y_W_H);
            }
            i = i2 + 1;
        }
    }

    public void a(String str) {
        YYRoomModel yYRoomModel = this.c;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.c.mics.isEmpty()) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.mics.size()) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel = this.c.mics.get(i2);
            if (b(yYSeatMemberModel) && i2 != 0) {
                yYSeatMemberModel.isSelected = false;
                if (TextUtils.equals(str, yYSeatMemberModel.getUid())) {
                    yYSeatMemberModel.isSelected = true;
                    c(i2);
                }
                YYMemberCPView yYMemberCPView = this.e.get(Integer.valueOf(i2));
                if (yYMemberCPView == null) {
                    return;
                }
                yYMemberCPView.b(yYSeatMemberModel);
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.blued.android.module.yy_china.view.TakeOffMaskTimerView, android.view.View] */
    public void a(String str, long j) {
        int i;
        ?? takeOffMaskTimerView = new TakeOffMaskTimerView(this.a.getContext());
        takeOffMaskTimerView.a(d(), str, j);
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.c.mics.size()) {
                i = -1;
                break;
            } else if (TextUtils.equals(this.c.mics.get(i).getUid(), str)) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i < 0) {
            return;
        }
        YYMemberCPView yYMemberCPView = this.e.get(Integer.valueOf(i));
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.topToTop = yYMemberCPView.getId();
        layoutParams.rightToRight = yYMemberCPView.getId();
        layoutParams.leftToLeft = yYMemberCPView.getId();
        layoutParams.topMargin = DensityUtils.a(this.a.getContext(), 53.0f);
        d().addView((View) takeOffMaskTimerView, layoutParams);
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(String str, String str2) {
        YYRoomModel yYRoomModel = this.c;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.c.mics.isEmpty()) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.mics.size()) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel = this.c.mics.get(i2);
            if (TextUtils.equals(yYSeatMemberModel.getUid(), str)) {
                yYSeatMemberModel.chat_anchor = str2;
                b(i2, yYSeatMemberModel);
                return;
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(List<BlindPublishModel> list) {
        YYRoomModel yYRoomModel = this.c;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.c.mics.isEmpty()) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.mics.size()) {
                return;
            }
            a(i2, this.c.mics.get(i2));
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(Set<String> set) {
        YYRoomModel yYRoomModel = this.c;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.c.mics.isEmpty()) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.mics.size()) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel = this.c.mics.get(i2);
            if (yYSeatMemberModel.is_open_mic != 0) {
                if (set == null || set.isEmpty() || !set.contains(yYSeatMemberModel.getUid())) {
                    yYSeatMemberModel.is_open_mic = 1;
                } else {
                    yYSeatMemberModel.is_open_mic = 2;
                }
                YYMemberCPView yYMemberCPView = this.e.get(Integer.valueOf(i2));
                if (yYMemberCPView != null) {
                    yYMemberCPView.a(set, yYSeatMemberModel);
                }
            }
            i = i2 + 1;
        }
    }

    protected abstract void b();

    @Override // com.blued.android.module.yy_china.observer.SeatChangedObserver
    public void b(List<YYSeatMemberModel> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            b(i2, list.get(i2));
            i = i2 + 1;
        }
    }

    protected boolean b(YYSeatMemberModel yYSeatMemberModel) {
        return yYSeatMemberModel != null && StringUtils.a(yYSeatMemberModel.getUid(), 0) > 0;
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void c() {
        YYRoomModel yYRoomModel = this.c;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.c.mics.isEmpty()) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.mics.size()) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel = this.c.mics.get(i2);
            yYSeatMemberModel.likeNum = "";
            yYSeatMemberModel.isSelected = false;
            a(i2, yYSeatMemberModel);
            i = i2 + 1;
        }
    }

    public abstract ConstraintLayout d();

    public abstract View e();

    public abstract int f();

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        Logger.e("observer", "YYConnectingAdapter onAttachedToRecyclerView ...");
        YYObserverManager.a().a(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        YYRoomModel yYRoomModel;
        Tracker.onClick(view);
        if (view.getId() == R.id.member_cp_0) {
            a(0, (View) this.e.get(0));
        } else if (view.getId() == R.id.member_cp_1) {
            a(1, (View) this.e.get(1));
        } else if (view.getId() == R.id.member_cp_2) {
            a(2, (View) this.e.get(2));
        } else if (view.getId() == R.id.member_cp_3) {
            a(3, (View) this.e.get(3));
        } else if (view.getId() == R.id.member_cp_4) {
            a(4, (View) this.e.get(4));
        } else if (view.getId() == R.id.member_cp_5) {
            a(5, (View) this.e.get(5));
        } else if (view.getId() == R.id.member_cp_6) {
            a(6, (View) this.e.get(6));
        } else if (view.getId() == R.id.member_cp_7) {
            a(7, (View) this.e.get(7));
        } else if (view.getId() == R.id.member_cp_8) {
            a(8, (View) this.e.get(8));
        } else if (view.getId() == R.id.tv_action) {
            if (this.c == null) {
                return;
            }
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_CP_MATCH_START, this.c.room_id, this.c.uid, this.c.getCPNextStep());
            a(this.c.getCPNextStep());
        } else if (view.getId() == R.id.btn_selected && (yYRoomModel = this.c) != null && yYRoomModel.mics != null && !this.c.mics.isEmpty()) {
            for (int i = 0; i < this.c.mics.size(); i++) {
                YYSeatMemberModel yYSeatMemberModel = this.c.mics.get(i);
                if (b(yYSeatMemberModel) && i != 0 && yYSeatMemberModel.isSelected) {
                    a(this.c.room_id, yYSeatMemberModel);
                    return;
                }
            }
        }
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

    public void setNewData(List<YYSeatMemberModel> list) {
        ArrayList arrayList = new ArrayList();
        YYSeatMemberModel yYSeatMemberModel = new YYSeatMemberModel();
        yYSeatMemberModel.itemType = f();
        arrayList.add(yYSeatMemberModel);
        super.setNewData(arrayList);
    }
}
