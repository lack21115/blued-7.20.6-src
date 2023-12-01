package com.blued.android.views;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.app.share.MoreOptionFromBtm;
import com.soft.blued.R;
import com.soft.blued.ui.share_custom.Model.ShareOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/views/WebBtmOptions.class */
public class WebBtmOptions extends MoreOptionFromBtm {
    public WebBtmOptions(Context context, View.OnClickListener onClickListener) {
        super(context, true, true, false, onClickListener);
    }

    @Override // com.soft.blued.customview.BaseMoreOptionFromBtm
    public List<ShareOption> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ShareOption(R.drawable.icon_option_copy_link, R.string.copy_link));
        arrayList.add(new ShareOption(R.drawable.icon_option_open_in_browser, R.string.open_in_browser));
        arrayList.add(new ShareOption(R.drawable.icon_option_refresh, R.string.refresh));
        return arrayList;
    }

    @Override // com.app.share.MoreOptionFromBtm, com.soft.blued.customview.BaseMoreOptionFromBtm
    public void a(List<ShareOption> list, List<ShareOption> list2) {
        boolean z;
        if (!TextUtils.equals(this.f9210a.q, "open")) {
            if (TextUtils.equals(this.f9210a.q, "close")) {
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
        list.add(0, new ShareOption(R.drawable.icon_share_to_code, 2131891705));
    }
}
