package com.blued.community.ui.subject.fragment;

import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.R;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.ui.common.CommonRecyclerFragment;
import com.blued.community.ui.subject.adapter.FeedSubjectListAdapter;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.view.CommonMultiItemAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/subject/fragment/FeedSubjectAttentionFragment.class */
public final class FeedSubjectAttentionFragment extends CommonRecyclerFragment<BluedTopic, BluedEntityBaseExtra> {
    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public boolean c() {
        return true;
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public boolean e() {
        return false;
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public CommonMultiItemAdapter<BluedTopic> g() {
        return new FeedSubjectListAdapter(4);
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public void j() {
        super.j();
        NoDataAndLoadFailView b = b();
        if (b == null) {
            return;
        }
        b.setNoDataStr(R.string.feed_subject_no_followed_data);
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public Type k() {
        Type type = new TypeToken<BluedEntity<BluedTopic, BluedEntityBaseExtra>>() { // from class: com.blued.community.ui.subject.fragment.FeedSubjectAttentionFragment$getHttpResDataType$1
        }.getType();
        Intrinsics.c(type, "object : TypeToken<Blued…tityBaseExtra>>() {}.type");
        return type;
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public String l() {
        return Intrinsics.a(CommunityHttpUtils.a(), (Object) "/ticktocks/super_topics/follow/list?filter=follow_list");
    }
}
