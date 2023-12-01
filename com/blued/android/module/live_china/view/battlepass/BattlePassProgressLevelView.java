package com.blued.android.module.live_china.view.battlepass;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.model.BattlePassLevelDataModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/battlepass/BattlePassProgressLevelView.class */
public final class BattlePassProgressLevelView extends FrameLayout {
    private boolean a;
    private LightCallBack b;
    private final int c;
    private final int d;
    private final int e;
    private final ArrayList<BattlePassLevelDataModel> f;
    private final ArrayList<BattlePassLevelItemView> g;
    private int h;
    private int i;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/battlepass/BattlePassProgressLevelView$LightCallBack.class */
    public interface LightCallBack {
        void a(int i);

        void a(boolean z, int i, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BattlePassProgressLevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.e(context, "context");
        this.c = DensityUtils.a(context, 77.5f);
        int a = DensityUtils.a(context, 9.0f);
        this.d = a;
        this.e = a + DensityUtils.a(context, 9.0f);
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
    }

    private final void a(int i) {
        LightCallBack callback;
        int size = this.g.size() - 1;
        for (BattlePassLevelItemView battlePassLevelItemView : this.g) {
            LightCallBack callback2 = getCallback();
            if (callback2 != null) {
                callback2.a(i);
            }
            int a = battlePassLevelItemView.a(i);
            if (a >= 0 && (callback = getCallback()) != null) {
                boolean z = a == 1;
                BattlePassLevelDataModel model = battlePassLevelItemView.getModel();
                Intrinsics.a(model);
                callback.a(z, model.getLevel(), size);
            }
            size--;
        }
    }

    private final int getMaxExp() {
        ArrayList<BattlePassLevelDataModel> arrayList = this.f;
        if (arrayList == null || arrayList.isEmpty()) {
            return 0;
        }
        ArrayList<BattlePassLevelDataModel> arrayList2 = this.f;
        return arrayList2.get(arrayList2.size() - 1).getExp();
    }

    public final void a() {
        int size = this.f.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            if (i2 == 0) {
                this.f.get(i2).setX(-this.e);
            } else {
                this.f.get(i2).setX((-this.e) + ((this.c - this.d) * i2));
            }
            i = i2 + 1;
        }
    }

    public final void a(ArrayList<BattlePassLevelDataModel> dataList, int i) {
        Intrinsics.e(dataList, "dataList");
        this.f.clear();
        this.f.addAll(dataList);
        setExp(i);
        this.i = -1;
        for (BattlePassLevelDataModel battlePassLevelDataModel : this.f) {
            if (i < battlePassLevelDataModel.getExp()) {
                battlePassLevelDataModel.setUiIsLight(false);
            } else {
                battlePassLevelDataModel.setUiIsLight(true);
                setMCurrentLevelIndex(getMCurrentLevelIndex() + 1);
            }
            battlePassLevelDataModel.setCurrentExp(i);
        }
        a();
        b();
    }

    public final void b() {
        int size = this.f.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i = size - 1;
            Context context = getContext();
            Intrinsics.c(context, "context");
            BattlePassLevelDataModel battlePassLevelDataModel = this.f.get(size);
            Intrinsics.c(battlePassLevelDataModel, "mDataList[i]");
            BattlePassLevelItemView battlePassLevelItemView = new BattlePassLevelItemView(context, battlePassLevelDataModel);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.f.get(size).getX();
            if (size == this.f.size() - 1) {
                layoutParams.rightMargin = this.e;
            }
            battlePassLevelItemView.setLayoutParams(layoutParams);
            BattlePassLevelDataModel battlePassLevelDataModel2 = this.f.get(size);
            Intrinsics.c(battlePassLevelDataModel2, "mDataList[i]");
            battlePassLevelItemView.setData(battlePassLevelDataModel2);
            this.g.add(battlePassLevelItemView);
            addView(battlePassLevelItemView);
            if (i < 0) {
                return;
            }
            size = i;
        }
    }

    public final LightCallBack getCallback() {
        return this.b;
    }

    public final int getExp() {
        return this.h;
    }

    public final int getForwardExtend() {
        return this.d;
    }

    public final int getForwardExtendHead() {
        return this.e;
    }

    public final boolean getHasLightLevel() {
        return this.a;
    }

    public final int getItemWidth() {
        return this.c;
    }

    public final int getMCurrentLevelIndex() {
        return this.i;
    }

    public final ArrayList<BattlePassLevelDataModel> getMDataList() {
        return this.f;
    }

    public final ArrayList<BattlePassLevelItemView> getMItemViewList() {
        return this.g;
    }

    public final void setCallback(LightCallBack lightCallBack) {
        this.b = lightCallBack;
    }

    public final void setExp(int i) {
        int maxExp = getMaxExp();
        int i2 = i;
        if (i <= 0) {
            i2 = 0;
        }
        if (i2 >= maxExp) {
            i2 = maxExp;
        }
        this.h = i2;
        a(i2);
    }

    public final void setHasLightLevel(boolean z) {
        this.a = z;
    }

    public final void setMCurrentLevelIndex(int i) {
        this.i = i;
    }
}
