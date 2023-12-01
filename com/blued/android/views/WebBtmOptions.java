package com.blued.android.views;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.app.share.MoreOptionFromBtm;
import com.blued.android.module.common.web.LoaderConstants;
import com.soft.blued.ui.share_custom.Model.ShareOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/views/WebBtmOptions.class */
public class WebBtmOptions extends MoreOptionFromBtm {
    public WebBtmOptions(Context context, View.OnClickListener onClickListener) {
        super(context, true, true, false, onClickListener);
    }

    public List<ShareOption> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ShareOption(2131233669, 2131887355));
        arrayList.add(new ShareOption(2131233674, 2131891181));
        arrayList.add(new ShareOption(2131233676, 2131891459));
        return arrayList;
    }

    public void a(List<ShareOption> list, List<ShareOption> list2) {
        boolean z;
        if (!TextUtils.equals(this.a.q, "open")) {
            if (TextUtils.equals(this.a.q, LoaderConstants.CLOSE)) {
                Iterator<ShareOption> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().iconResourceId == 2131233825) {
                        it.remove();
                    }
                }
                return;
            }
            return;
        }
        Iterator<ShareOption> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = false;
                break;
            } else if (it2.next().iconResourceId == 2131233825) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        list.add(0, new ShareOption(2131233825, 2131891705));
    }
}
