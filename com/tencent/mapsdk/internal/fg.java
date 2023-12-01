package com.tencent.mapsdk.internal;

import android.content.Context;
import android.widget.ListView;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/fg.class */
public class fg extends ListView {
    private a g;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/fg$a.class */
    public interface a {
        void b();
    }

    public fg(Context context) {
        super(context);
    }

    @Override // android.widget.AbsListView
    public void handleDataChanged() {
        super.handleDataChanged();
        a aVar = this.g;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void setOnDataChangedListener(a aVar) {
        this.g = aVar;
    }
}
