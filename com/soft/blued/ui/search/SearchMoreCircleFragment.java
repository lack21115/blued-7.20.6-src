package com.soft.blued.ui.search;

import android.provider.SearchIndexablesContract;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.ui.circle.manager.CircleConstants;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.common.CommonRecyclerFragment;
import com.blued.community.view.CommonMultiItemAdapter;
import com.google.gson.reflect.TypeToken;
import com.soft.blued.ui.search.adapter.SearchCircleAdapter;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/SearchMoreCircleFragment.class */
public final class SearchMoreCircleFragment extends CommonRecyclerFragment<MyCircleModel, BluedEntityBaseExtra> {

    /* renamed from: a  reason: collision with root package name */
    private String f33151a = "";

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public int f() {
        return 2131891580;
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public CommonMultiItemAdapter<MyCircleModel> g() {
        SearchCircleAdapter searchCircleAdapter = new SearchCircleAdapter();
        searchCircleAdapter.a(CircleConstants.CIRCLE_FROM_PAGE.SEARCH_MORE_CIRCLE);
        searchCircleAdapter.a(this.f33151a);
        return searchCircleAdapter;
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public Type k() {
        Type type = new TypeToken<BluedEntity<MyCircleModel, BluedEntityBaseExtra>>() { // from class: com.soft.blued.ui.search.SearchMoreCircleFragment$getHttpResDataType$1
        }.getType();
        Intrinsics.c(type, "object : TypeToken<Blued…tityBaseExtra>>() {}.type");
        return type;
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public String l() {
        return CommunityHttpUtils.a() + "/ticktocks/search/circle?keyword=" + this.f33151a;
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onParseArguments() {
        super.onParseArguments();
        String string = this.args.getString(SearchIndexablesContract.RawData.COLUMN_KEYWORDS, "");
        Intrinsics.c(string, "args.getString(\"keywords\", \"\")");
        this.f33151a = string;
    }
}
