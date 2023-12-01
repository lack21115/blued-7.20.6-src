package com.blued.android.module.live_china.model;

import com.blued.android.module.common.login.model.BluedADExtra;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveHotListDiversion.class */
public class LiveHotListDiversion extends BluedADExtra {
    public String description;
    public long id;
    public int index;
    public String link;
    public String pic;
    public String title;

    @Override // com.blued.android.module.common.login.model.BluedADExtra
    public String toString() {
        return "LiveHotListDiversion{id=" + this.id + ", pic='" + this.pic + "', title='" + this.title + "', description='" + this.description + "', link='" + this.link + "', index=" + this.index + '}';
    }
}
