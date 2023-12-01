package com.opos.mobad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.opos.mobad.activity.VideoActivity;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.service.event.EventDescription;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/i.class */
public class i implements com.opos.mobad.q.a.h {
    @Override // com.opos.mobad.q.a.h
    public void a(Context context, AdItemData adItemData, MaterialFileData materialFileData, int i, boolean z, int i2, EventDescription eventDescription) {
        Intent intent = new Intent();
        intent.setClass(context, VideoActivity.class);
        intent.putExtra(VideoActivity.EXTRA_KEY_AD_ITEM_DATA, adItemData);
        intent.putExtra(VideoActivity.EXTRA_KEY_EVENT_DESCRIPTION, eventDescription);
        intent.putExtra(VideoActivity.EXTRA_KEY_ACTION_TYPE, 1);
        intent.putExtra(VideoActivity.EXTRA_KEY_BID_PRICE, i2);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    @Override // com.opos.mobad.q.a.h
    public boolean a(Activity activity) {
        return activity != null && com.opos.mobad.cmn.a.b.f.b(activity, VideoActivity.class);
    }

    @Override // com.opos.mobad.q.a.h
    public boolean a(Activity activity, AdItemData adItemData, int i, com.opos.mobad.q.a.b.d dVar, EventDescription eventDescription) {
        boolean z = false;
        if (a(activity)) {
            Intent intent = new Intent(activity, VideoActivity.class);
            intent.putExtra(VideoActivity.EXTRA_KEY_AD_ITEM_DATA, adItemData);
            intent.putExtra(VideoActivity.EXTRA_KEY_EVENT_DESCRIPTION, eventDescription);
            intent.putExtra(VideoActivity.EXTRA_KEY_ACTION_TYPE, 2);
            intent.putExtra(VideoActivity.EXTRA_KEY_BID_PRICE, i);
            intent.putExtra(VideoActivity.EXTRA_KEY_TEMPLATE_CREATOR, (Parcelable) dVar);
            if (com.opos.cmn.an.h.f.a.a(activity) || (activity.getWindow().getDecorView().getSystemUiVisibility() & 4) == 4) {
                z = true;
            }
            intent.putExtra(VideoActivity.EXTRA_KEY_SCREEN_MODE, z);
            activity.startActivity(intent);
            com.opos.cmn.an.f.a.b("", "start inter activity");
            return true;
        }
        return false;
    }
}
