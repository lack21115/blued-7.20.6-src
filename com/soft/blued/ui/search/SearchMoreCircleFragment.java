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
import com.soft.blued.R;
import com.soft.blued.ui.search.adapter.SearchCircleAdapter;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/SearchMoreCircleFragment.class */
public final class SearchMoreCircleFragment extends CommonRecyclerFragment<MyCircleModel, BluedEntityBaseExtra> {

    /* renamed from: a  reason: collision with root package name */
    private String f19460a = "";

    public int f() {
        return R.string.search_more_circle_title;
    }

    public CommonMultiItemAdapter<MyCircleModel> g() {
        SearchCircleAdapter searchCircleAdapter = new SearchCircleAdapter();
        searchCircleAdapter.a(CircleConstants.CIRCLE_FROM_PAGE.A);
        searchCircleAdapter.a(this.f19460a);
        return searchCircleAdapter;
    }

    public Type k() {
        Type type = new TypeToken<BluedEntity<MyCircleModel, BluedEntityBaseExtra>>() { // from class: com.soft.blued.ui.search.SearchMoreCircleFragment$getHttpResDataType$1
        }.getType();
        Intrinsics.c(type, "object : TypeToken<Blued…tityBaseExtra>>() {}.type");
        return type;
    }

    public String l() {
        return CommunityHttpUtils.a() + "/ticktocks/search/circle?keyword=" + this.f19460a;
    }

    public void onParseArguments() {
        super.onParseArguments();
        String string = this.args.getString(SearchIndexablesContract.RawData.COLUMN_KEYWORDS, "");
        Intrinsics.c(string, "args.getString(\"keywords\", \"\")");
        this.f19460a = string;
    }
}
