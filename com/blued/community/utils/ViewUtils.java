package com.blued.community.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.utils.ViewUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/community/utils/ViewUtils.class */
public final class ViewUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final ViewUtils f20483a = new ViewUtils();

    @Metadata
    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/utils/ViewUtils$ITopicListener.class */
    public interface ITopicListener {
        void a(View view);

        void a(BluedTopic bluedTopic);
    }

    private ViewUtils() {
    }

    @JvmStatic
    public static final View a(Context context, FlowLayout flowLayoutTopics, int i, View.OnClickListener onClickListener) {
        Intrinsics.e(flowLayoutTopics, "flowLayoutTopics");
        View childAt = flowLayoutTopics.getChildAt(0);
        View refactorHotView = LayoutInflater.from(context).inflate(R.layout.item_feed_from_hot, (ViewGroup) null);
        if (onClickListener != null) {
            refactorHotView.setOnClickListener(onClickListener);
        }
        if (childAt != null) {
            if (((TextView) childAt.findViewById(R.id.tv_top_hot)) != null) {
                if (i != 1) {
                    flowLayoutTopics.removeView(childAt);
                }
            } else if (i == 1) {
                flowLayoutTopics.addView(refactorHotView, 0);
            }
        } else if (i == 1) {
            flowLayoutTopics.addView(refactorHotView, 0);
        }
        Intrinsics.c(refactorHotView, "refactorHotView");
        return refactorHotView;
    }

    @JvmStatic
    public static final List<View> a(View rootView) {
        Intrinsics.e(rootView, "rootView");
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addLast(rootView);
        while (!arrayDeque.isEmpty()) {
            Object last = arrayDeque.getLast();
            if (last == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
            }
            View view = (View) last;
            arrayDeque.pollLast();
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount() - 1;
                if (childCount >= 0) {
                    while (true) {
                        int i = childCount - 1;
                        arrayDeque.addLast(viewGroup.getChildAt(childCount));
                        if (i < 0) {
                            break;
                        }
                        childCount = i;
                    }
                }
            }
            if (view.isClickable() && view.hasOnClickListeners()) {
                arrayList.add(view);
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    @JvmStatic
    public static final void a(Context context, IRequestHost fragmentActive, LinearLayout linearContainer, List<? extends UserBasicModel> list, int i, int i2, float f, float f2) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        Intrinsics.e(linearContainer, "linearContainer");
        a(context, fragmentActive, linearContainer, list, i, i2, f, f2, 1.0f);
    }

    @JvmStatic
    public static final void a(Context context, IRequestHost fragmentActive, LinearLayout linearContainer, List<? extends UserBasicModel> list, int i, int i2, float f, float f2, float f3) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        Intrinsics.e(linearContainer, "linearContainer");
        if (context == null) {
            return;
        }
        if (list == null || list.isEmpty()) {
            linearContainer.setVisibility(8);
            return;
        }
        linearContainer.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        int min = Math.min(list.size(), i);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= min) {
                break;
            }
            UserBasicModel userBasicModel = list.get(i4);
            if (userBasicModel != null) {
                arrayList.add(userBasicModel.avatar);
            }
            i3 = i4 + 1;
        }
        if (i2 > i) {
            arrayList.add("-");
        }
        linearContainer.removeAllViews();
        Iterator it = arrayList.iterator();
        boolean z = true;
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                arrayList.clear();
                return;
            }
            String str = (String) it.next();
            ImageView imageView = new ImageView(context);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams((int) BluedViewExtKt.a(f), (int) BluedViewExtKt.a(f));
            if (!z2) {
                marginLayoutParams.leftMargin = -DensityUtils.a(context, f2);
            }
            imageView.setLayoutParams(marginLayoutParams);
            if (TextUtils.equals(str, "-")) {
                ImageLoader.a(fragmentActive, R.drawable.event_details_member_more).c().a(1.0f, BluedSkinUtils.a(context, R.color.syc_x)).a(imageView);
                linearContainer.addView(imageView);
            } else {
                linearContainer.addView(imageView);
                if (StringUtils.d(str)) {
                    ImageLoader.a(fragmentActive, R.drawable.user_bg_round).c().a(1.0f, BluedSkinUtils.a(context, R.color.syc_x)).a(imageView);
                } else {
                    ImageLoader.a(fragmentActive, str).b(R.drawable.user_bg_round).d(R.drawable.user_bg_round).c().a(1.0f, BluedSkinUtils.a(context, R.color.syc_x)).a(imageView);
                }
            }
            z = false;
        }
    }

    @JvmStatic
    public static final void a(Context context, List<? extends BluedTopic> list, FlowLayout flowLayout, boolean z, final ITopicListener iTopicListener, boolean z2) {
        if (flowLayout == null) {
            return;
        }
        if (list == null || list.size() <= 0) {
            flowLayout.removeAllViews();
            return;
        }
        flowLayout.removeAllViews();
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            final BluedTopic bluedTopic = list.get(i2);
            if (!StringUtils.d(bluedTopic.name)) {
                View inflate = LayoutInflater.from(context).inflate(R.layout.item_feed_list_topic, (ViewGroup) null);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_pre_topic);
                ImageView imageView2 = (ImageView) inflate.findViewById(R.id.iv_anonymous);
                ImageView imageView3 = (ImageView) inflate.findViewById(R.id.iv_topic_h5);
                ImageView imageView4 = (ImageView) inflate.findViewById(R.id.img_close);
                TextView textView = (TextView) inflate.findViewById(R.id.tv_topic);
                if (z) {
                    imageView4.setVisibility(8);
                } else {
                    imageView4.setVisibility(0);
                }
                if (bluedTopic.topicType == 1) {
                    imageView3.setVisibility(0);
                    imageView2.setVisibility(8);
                    imageView.setVisibility(8);
                } else if (bluedTopic.is_anonym == 1) {
                    imageView3.setVisibility(8);
                    imageView2.setVisibility(0);
                    imageView.setVisibility(8);
                } else {
                    imageView3.setVisibility(8);
                    imageView2.setVisibility(8);
                    a(imageView);
                    imageView.setVisibility(0);
                }
                textView.setText(bluedTopic.name);
                if (iTopicListener != null) {
                    if (z2) {
                        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.utils.-$$Lambda$ViewUtils$qUylpdAQktE3gqZzIQH4QVqrIhU
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                ViewUtils.a(ViewUtils.ITopicListener.this, bluedTopic, view);
                            }
                        });
                    } else {
                        imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.utils.-$$Lambda$ViewUtils$u-MOrxLdxxNqFdeZw6hctYH8Ck8
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                ViewUtils.b(ViewUtils.ITopicListener.this, bluedTopic, view);
                            }
                        });
                    }
                    iTopicListener.a(inflate);
                }
                flowLayout.addView(inflate);
            }
            i = i2 + 1;
        }
    }

    @JvmStatic
    public static final void a(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        if (CommunityServiceManager.a().D() == 1) {
            imageView.setImageResource(R.drawable.feed_post_subject_icon_blue);
        } else {
            imageView.setImageResource(R.drawable.feed_post_super_topic);
        }
    }

    @JvmStatic
    public static final void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView == null || recyclerView.getLayoutManager() == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager) || i < 0) {
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        Intrinsics.a(linearLayoutManager);
        linearLayoutManager.scrollToPositionWithOffset(i, i2);
    }

    @JvmStatic
    public static final void a(RecyclerView recyclerView, int[] iArr) {
        if (iArr == null || iArr.length < 2) {
            return;
        }
        a(recyclerView, iArr[0], iArr[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ITopicListener iTopicListener, BluedTopic topic, View view) {
        Intrinsics.e(topic, "$topic");
        iTopicListener.a(topic);
    }

    @JvmStatic
    public static final boolean a(View view, MotionEvent motionEvent) {
        boolean z = false;
        if (view != null) {
            if (motionEvent == null) {
                return false;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            z = false;
            if (motionEvent.getRawX() >= i) {
                z = false;
                if (motionEvent.getRawX() <= i + view.getMeasuredWidth()) {
                    z = false;
                    if (motionEvent.getRawY() >= i2) {
                        if (motionEvent.getRawY() > i2 + view.getMeasuredWidth()) {
                            return false;
                        }
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    @JvmStatic
    public static final int[] a(RecyclerView recyclerView) {
        int[] iArr = new int[2];
        if (recyclerView != null && recyclerView.getLayoutManager() != null && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            Intrinsics.a(linearLayoutManager);
            View childAt = linearLayoutManager.getChildAt(0);
            if (childAt != null) {
                iArr[0] = linearLayoutManager.getPosition(childAt);
                iArr[1] = childAt.getTop();
            }
        }
        return iArr;
    }

    @JvmStatic
    public static final void b(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return;
        }
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        Intrinsics.a(itemAnimator);
        itemAnimator.setAddDuration(0L);
        RecyclerView.ItemAnimator itemAnimator2 = recyclerView.getItemAnimator();
        Intrinsics.a(itemAnimator2);
        itemAnimator2.setChangeDuration(0L);
        RecyclerView.ItemAnimator itemAnimator3 = recyclerView.getItemAnimator();
        Intrinsics.a(itemAnimator3);
        itemAnimator3.setMoveDuration(0L);
        RecyclerView.ItemAnimator itemAnimator4 = recyclerView.getItemAnimator();
        Intrinsics.a(itemAnimator4);
        itemAnimator4.setRemoveDuration(0L);
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) recyclerView.getItemAnimator();
        Intrinsics.a(simpleItemAnimator);
        simpleItemAnimator.setSupportsChangeAnimations(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ITopicListener iTopicListener, BluedTopic topic, View view) {
        Intrinsics.e(topic, "$topic");
        iTopicListener.a(topic);
    }
}
