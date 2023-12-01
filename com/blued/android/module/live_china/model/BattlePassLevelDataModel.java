package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/BattlePassLevelDataModel.class */
public final class BattlePassLevelDataModel implements Serializable {
    private BattlePassLevelAwardDataModel basic;
    private int currentExp;
    private int exp;
    private int level;
    private int priorExp;
    private BattlePassLevelAwardDataModel top;
    private boolean uiIsLight;
    private int x;

    public final BattlePassLevelAwardDataModel getBasic() {
        return this.basic;
    }

    public final int getCurrentExp() {
        return this.currentExp;
    }

    public final int getExp() {
        return this.exp;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getPriorExp() {
        return this.priorExp;
    }

    public final BattlePassLevelAwardDataModel getTop() {
        return this.top;
    }

    public final boolean getUiIsLight() {
        return this.uiIsLight;
    }

    public final int getX() {
        return this.x;
    }

    public final void setBasic(BattlePassLevelAwardDataModel battlePassLevelAwardDataModel) {
        this.basic = battlePassLevelAwardDataModel;
    }

    public final void setCurrentExp(int i) {
        this.currentExp = i;
    }

    public final void setExp(int i) {
        this.exp = i;
    }

    public final void setLevel(int i) {
        this.level = i;
    }

    public final void setPriorExp(int i) {
        this.priorExp = i;
    }

    public final void setTop(BattlePassLevelAwardDataModel battlePassLevelAwardDataModel) {
        this.top = battlePassLevelAwardDataModel;
    }

    public final void setUiIsLight(boolean z) {
        this.uiIsLight = z;
    }

    public final void setX(int i) {
        this.x = i;
    }
}
