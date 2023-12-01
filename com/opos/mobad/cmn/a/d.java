package com.opos.mobad.cmn.a;

import android.content.Context;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.service.event.EventDescription;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/d.class */
public interface d {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/d$a.class */
    public interface a {
        void a();

        void a(int i, String str);
    }

    void a(Context context, String str, String str2, AdItemData adItemData, String str3, EventDescription eventDescription);

    void a(Context context, String str, String str2, AdItemData adItemData, String str3, EventDescription eventDescription, String str4);

    void a(Context context, String str, String str2, String str3, a aVar, String str4);

    void a(Context context, String str, String str2, String str3, String str4);

    boolean a(Context context, String str);

    boolean a(Context context, String str, String str2, String str3);

    boolean a(Context context, String str, String str2, String str3, String str4, String str5, String str6);

    boolean b(Context context, String str);

    void c(Context context, String str);

    boolean d(Context context, String str);

    boolean e(Context context, String str);
}
