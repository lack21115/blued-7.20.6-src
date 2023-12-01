package com.blued.android.module.yy_china.model;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/UserChatRoomInfoModel.class */
public class UserChatRoomInfoModel {
    private YyWealthModel next_wealth_info;
    private YyWealthModel wealth_info;
    private YYWeeklyStarModel week_star;

    public YyWealthModel getNext_wealth() {
        return this.next_wealth_info;
    }

    public YyWealthModel getWealth_info() {
        return this.wealth_info;
    }

    public YYWeeklyStarModel getWeek_star() {
        return this.week_star;
    }

    public void setNext_wealth(YyWealthModel yyWealthModel) {
        this.next_wealth_info = yyWealthModel;
    }

    public void setWealth_info(YyWealthModel yyWealthModel) {
        this.wealth_info = yyWealthModel;
    }

    public void setWeek_star(YYWeeklyStarModel yYWeeklyStarModel) {
        this.week_star = yYWeeklyStarModel;
    }
}
