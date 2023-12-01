package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.f.b;
import com.qiniu.pili.droid.shortvideo.f.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLDraftBox.class */
public class PLDraftBox {
    private c mDraftBox;

    private PLDraftBox(c cVar) {
        this.mDraftBox = cVar;
    }

    public static PLDraftBox getInstance(Context context) {
        return new PLDraftBox(c.a(context));
    }

    public List<PLDraft> getAllDrafts() {
        List<b> a2 = this.mDraftBox.a();
        ArrayList arrayList = new ArrayList();
        for (b bVar : a2) {
            arrayList.add(new PLDraft(bVar));
        }
        return arrayList;
    }

    public PLDraft getDraftByTag(String str) {
        b a2 = this.mDraftBox.a(str);
        if (a2 == null) {
            return null;
        }
        return new PLDraft(a2);
    }

    public void removeAllDrafts(boolean z) {
        this.mDraftBox.a(z);
    }

    public void removeDraftByTag(String str, boolean z) {
        this.mDraftBox.a(str, z);
    }
}
