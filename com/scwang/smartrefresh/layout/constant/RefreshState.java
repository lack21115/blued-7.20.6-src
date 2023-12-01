package com.scwang.smartrefresh.layout.constant;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/constant/RefreshState.class */
public enum RefreshState {
    None(0, false, false, false, false, false),
    PullDownToRefresh(1, true, false, false, false, false),
    PullUpToLoad(2, true, false, false, false, false),
    PullDownCanceled(1, false, false, false, false, false),
    PullUpCanceled(2, false, false, false, false, false),
    ReleaseToRefresh(1, true, false, false, false, true),
    ReleaseToLoad(2, true, false, false, false, true),
    ReleaseToTwoLevel(1, true, false, false, true, true),
    TwoLevelReleased(1, false, false, false, true, false),
    RefreshReleased(1, false, false, false, false, false),
    LoadReleased(2, false, false, false, false, false),
    Refreshing(1, false, true, false, false, false),
    Loading(2, false, true, false, false, false),
    TwoLevel(1, false, true, false, true, false),
    RefreshFinish(1, false, false, true, false, false),
    LoadFinish(2, false, false, true, false, false),
    TwoLevelFinish(1, false, false, true, true, false);
    
    public final boolean r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public final boolean v;
    public final boolean w;
    public final boolean x;

    RefreshState(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.r = i == 1;
        this.s = i == 2;
        this.u = z;
        this.v = z2;
        this.w = z3;
        this.t = z4;
        this.x = z5;
    }

    public RefreshState a() {
        return (!this.r || this.t) ? this : values()[ordinal() + 1];
    }

    public RefreshState b() {
        return (!this.s || this.t) ? this : values()[ordinal() - 1];
    }
}
