package com.soft.blued.ui.find.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.ui.find.model.UserFindResult;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/SearchUserFragment_MVP.class */
public final class SearchUserFragment_MVP implements MvpDispatcher {
    private void a(SearchUserFragment searchUserFragment, String str) {
        if ((str.hashCode() == 1756700488 && str.equals("PERSON_LIST")) ? false : true) {
            return;
        }
        searchUserFragment.b();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    public void a(MvpFragment mvpFragment, String str, List list) {
        SearchUserFragment searchUserFragment = (SearchUserFragment) mvpFragment;
        if (list != null && list.size() > 0) {
            boolean z = false;
            Object obj = list.get(0);
            if (obj != null) {
                if (str.hashCode() != 1756700488 || !str.equals("PERSON_LIST")) {
                    z = true;
                }
                if (!z && UserFindResult.class.isInstance(obj)) {
                    searchUserFragment.a(list);
                    return;
                }
            }
        }
        a(searchUserFragment, str);
    }
}
