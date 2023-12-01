package com.blued.community.ui.topic.manager;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.module.common.view.CenterAlignImageSpan;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.manager.CommunityManager;
import com.blued.community.ui.topic.model.BluedTopic;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/topic/manager/TopicMethods.class */
public final class TopicMethods {
    public static final TopicMethods a = new TopicMethods();

    private TopicMethods() {
    }

    @JvmStatic
    public static final SpannableStringBuilder a(SpannableStringBuilder spannableStr, boolean z, int i, int i2, int i3) {
        Intrinsics.e(spannableStr, "spannableStr");
        if (z) {
            spannableStr.append(" e");
            Drawable drawable = AppInfo.d().getResources().getDrawable(i);
            drawable.setBounds(0, 0, AppMethods.a(i2), AppMethods.a(i3));
            spannableStr.setSpan(new CenterAlignImageSpan(drawable), spannableStr.length() - 1, spannableStr.length(), 33);
            return spannableStr;
        }
        spannableStr.insert(0, "s ");
        Drawable drawable2 = AppInfo.d().getResources().getDrawable(i);
        drawable2.setBounds(0, 0, AppMethods.a(i2), AppMethods.a(i3));
        spannableStr.setSpan(new CenterAlignImageSpan(drawable2), 0, 1, 33);
        return spannableStr;
    }

    @JvmStatic
    public static final SpannableStringBuilder a(BluedTopic model, CharSequence content) {
        Intrinsics.e(model, "model");
        Intrinsics.e(content, "content");
        return a(model, content, true);
    }

    @JvmStatic
    public static final SpannableStringBuilder a(BluedTopic model, CharSequence content, boolean z) {
        Intrinsics.e(model, "model");
        Intrinsics.e(content, "content");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(content);
        if (z) {
            if (CommunityServiceManager.a().D() != 1) {
                a(spannableStringBuilder, false, R.drawable.icon_pre_topic, 18, 18);
            } else if (CommunityManager.a.a().s()) {
                a(spannableStringBuilder, false, R.drawable.feed_post_subject_icon, 18, 18);
            } else {
                a(spannableStringBuilder, false, R.drawable.feed_post_subject_icon_dark, 18, 18);
            }
        }
        if (model.is_new == 1) {
            a(spannableStringBuilder, true, R.drawable.feed_topic_list_new, 18, 18);
        }
        if (model.is_anonym == 1) {
            a(spannableStringBuilder, true, R.drawable.anonymous_icon, 30, 15);
        }
        return spannableStringBuilder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final List<BluedTopic> a(List<? extends BluedTopic> topicList, boolean z) {
        Intrinsics.e(topicList, "topicList");
        if (!z && !topicList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (BluedTopic bluedTopic : topicList) {
                if (bluedTopic.is_anonym != 1) {
                    arrayList.add(bluedTopic);
                }
            }
            return arrayList;
        }
        return topicList;
    }
}
