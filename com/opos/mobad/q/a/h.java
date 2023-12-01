package com.opos.mobad.q.a;

import android.app.Activity;
import android.content.Context;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.service.event.EventDescription;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/h.class */
public interface h {
    void a(Context context, AdItemData adItemData, MaterialFileData materialFileData, int i, boolean z, int i2, EventDescription eventDescription);

    boolean a(Activity activity);

    boolean a(Activity activity, AdItemData adItemData, int i, com.opos.mobad.q.a.b.d dVar, EventDescription eventDescription);
}
