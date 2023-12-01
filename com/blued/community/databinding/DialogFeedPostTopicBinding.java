package com.blued.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.view.SearchView;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/DialogFeedPostTopicBinding.class */
public final class DialogFeedPostTopicBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f18803a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeLinearLayout f18804c;
    public final RecyclerView d;
    public final FrameLayout e;
    public final SearchView f;
    private final FrameLayout g;

    private DialogFeedPostTopicBinding(FrameLayout frameLayout, TextView textView, ImageView imageView, ShapeLinearLayout shapeLinearLayout, RecyclerView recyclerView, FrameLayout frameLayout2, SearchView searchView) {
        this.g = frameLayout;
        this.f18803a = textView;
        this.b = imageView;
        this.f18804c = shapeLinearLayout;
        this.d = recyclerView;
        this.e = frameLayout2;
        this.f = searchView;
    }

    public static DialogFeedPostTopicBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogFeedPostTopicBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_feed_post_topic, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogFeedPostTopicBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.feed_post_topic_title_tv);
        if (textView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.ivClose);
            if (imageView != null) {
                ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.layoutTopic);
                if (shapeLinearLayout != null) {
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                    if (recyclerView != null) {
                        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.rootLayout);
                        if (frameLayout != null) {
                            SearchView searchView = (SearchView) view.findViewById(R.id.searchBar);
                            if (searchView != null) {
                                return new DialogFeedPostTopicBinding((FrameLayout) view, textView, imageView, shapeLinearLayout, recyclerView, frameLayout, searchView);
                            }
                            str = "searchBar";
                        } else {
                            str = "rootLayout";
                        }
                    } else {
                        str = "recyclerView";
                    }
                } else {
                    str = "layoutTopic";
                }
            } else {
                str = "ivClose";
            }
        } else {
            str = "feedPostTopicTitleTv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.g;
    }
}
