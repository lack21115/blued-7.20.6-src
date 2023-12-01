package com.soft.blued.ui.search;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.ui.search.model.SearchSessionModel;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/SearchMessageFragment_MVP.class */
public final class SearchMessageFragment_MVP implements MvpDispatcher {
    private void a(SearchMessageFragment searchMessageFragment, String str) {
        boolean z;
        int hashCode = str.hashCode();
        if (hashCode == -1388690789) {
            if (str.equals("MESSAGE_No_MORE")) {
                z = true;
            }
            z = true;
        } else if (hashCode != -917674158) {
            if (hashCode == 1060515318 && str.equals("MESSAGE_LIST")) {
                z = false;
            }
            z = true;
        } else {
            if (str.equals("MESSAGE_Has_MORE")) {
                z = true;
            }
            z = true;
        }
        if (!z) {
            searchMessageFragment.b();
        } else if (z) {
            searchMessageFragment.c();
        } else if (!z) {
        } else {
            searchMessageFragment.d();
        }
    }

    public void a(MvpFragment mvpFragment, String str, List list) {
        SearchMessageFragment searchMessageFragment = (SearchMessageFragment) mvpFragment;
        if (list != null && list.size() > 0) {
            boolean z = false;
            Object obj = list.get(0);
            if (obj != null) {
                if (str.hashCode() != 1060515318 || !str.equals("MESSAGE_LIST")) {
                    z = true;
                }
                if (!z && SearchSessionModel.class.isInstance(obj)) {
                    searchMessageFragment.a(list);
                    return;
                }
            }
        }
        a(searchMessageFragment, str);
    }
}
