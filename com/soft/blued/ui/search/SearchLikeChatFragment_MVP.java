package com.soft.blued.ui.search;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.ui.search.model.SearchSessionModel;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/SearchLikeChatFragment_MVP.class */
public final class SearchLikeChatFragment_MVP implements MvpDispatcher {
    private void a(SearchLikeChatFragment searchLikeChatFragment, String str) {
        boolean z;
        int hashCode = str.hashCode();
        if (hashCode == -1059378096) {
            if (str.equals("empty_list")) {
                z = true;
            }
            z = true;
        } else if (hashCode != -979726365) {
            if (hashCode == -254638518 && str.equals("no_more_list")) {
                z = false;
            }
            z = true;
        } else {
            if (str.equals("has_more_list")) {
                z = true;
            }
            z = true;
        }
        if (!z) {
            searchLikeChatFragment.c();
        } else if (z) {
            searchLikeChatFragment.d();
        } else if (!z) {
        } else {
            searchLikeChatFragment.b();
        }
    }

    public void a(MvpFragment mvpFragment, String str, List list) {
        SearchLikeChatFragment searchLikeChatFragment = (SearchLikeChatFragment) mvpFragment;
        if (list != null && list.size() > 0) {
            boolean z = false;
            Object obj = list.get(0);
            if (obj != null) {
                if (str.hashCode() != -1742866476 || !str.equals("notify_list")) {
                    z = true;
                }
                if (!z && SearchSessionModel.class.isInstance(obj)) {
                    searchLikeChatFragment.a(list);
                    return;
                }
            }
        }
        a(searchLikeChatFragment, str);
    }
}
