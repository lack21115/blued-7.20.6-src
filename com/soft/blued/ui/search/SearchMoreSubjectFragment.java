package com.soft.blued.ui.search;

import android.provider.SearchIndexablesContract;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.ui.common.CommonRecyclerFragment;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.view.CommonMultiItemAdapter;
import com.google.gson.reflect.TypeToken;
import com.soft.blued.R;
import com.soft.blued.ui.search.adapter.SearchSubjectAdapter;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/SearchMoreSubjectFragment.class */
public final class SearchMoreSubjectFragment extends CommonRecyclerFragment<BluedTopic, BluedEntityBaseExtra> {

    /* renamed from: a  reason: collision with root package name */
    private String f19461a = "";

    public int f() {
        return R.string.search_more_subject_title;
    }

    public CommonMultiItemAdapter<BluedTopic> g() {
        SearchSubjectAdapter searchSubjectAdapter = new SearchSubjectAdapter();
        searchSubjectAdapter.a(1);
        searchSubjectAdapter.a(this.f19461a);
        return searchSubjectAdapter;
    }

    public Type k() {
        Type type = new TypeToken<BluedEntity<BluedTopic, BluedEntityBaseExtra>>() { // from class: com.soft.blued.ui.search.SearchMoreSubjectFragment$getHttpResDataType$1
        }.getType();
        Intrinsics.c(type, "object : TypeToken<Blued…tityBaseExtra>>() {}.type");
        return type;
    }

    public String l() {
        return CommunityHttpUtils.a() + "/ticktocks/search/topic?keyword=" + this.f19461a;
    }

    public void onParseArguments() {
        super.onParseArguments();
        String string = this.args.getString(SearchIndexablesContract.RawData.COLUMN_KEYWORDS, "");
        Intrinsics.c(string, "args.getString(\"keywords\", \"\")");
        this.f19461a = string;
    }
}
