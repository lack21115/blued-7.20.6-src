package com.anythink.nativead.api;

import android.view.View;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/nativead/api/ATNativePrepareExInfo.class */
public class ATNativePrepareExInfo extends ATNativePrepareInfo {
    List<View> creativeClickViewList;

    public List<View> getCreativeClickViewList() {
        if (this.creativeClickViewList != null && this.closeView != null) {
            this.creativeClickViewList.remove(this.closeView);
        }
        return this.creativeClickViewList;
    }

    public void setCreativeClickViewList(List<View> list) {
        this.creativeClickViewList = list;
    }
}
