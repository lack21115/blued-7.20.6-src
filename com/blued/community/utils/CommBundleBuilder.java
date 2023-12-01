package com.blued.community.utils;

import android.os.Bundle;
import com.blued.android.module.common.db.model.NewFeedModel;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.topic.model.BluedTopic;
import kotlin.Metadata;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/community/utils/CommBundleBuilder.class */
public final class CommBundleBuilder {

    /* renamed from: a  reason: collision with root package name */
    private String f20459a;
    private BluedTopic b;

    /* renamed from: c  reason: collision with root package name */
    private BluedIngSelfFeed f20460c;
    private int d;
    private String e;
    private int f;
    private String g;
    private NewFeedModel h;

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("feed_id", this.f20459a);
        bundle.putSerializable("super_topic_param", this.b);
        bundle.putSerializable("feed_model", this.f20460c);
        bundle.putInt("page_from", this.d);
        bundle.putString("classify_id", this.e);
        bundle.putInt("nearby_guide_type", this.f);
        bundle.putString("template_param_title", this.g);
        bundle.putSerializable("feed_send_data", this.h);
        return bundle;
    }

    public final CommBundleBuilder a(int i) {
        this.d = i;
        return this;
    }

    public final CommBundleBuilder a(NewFeedModel newFeedModel) {
        this.h = newFeedModel;
        return this;
    }

    public final CommBundleBuilder a(BluedTopic bluedTopic) {
        this.b = bluedTopic;
        return this;
    }

    public final CommBundleBuilder a(String str) {
        this.g = str;
        return this;
    }

    public final CommBundleBuilder b(int i) {
        this.f = i;
        return this;
    }
}
