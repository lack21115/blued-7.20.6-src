package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveDataListManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveHornModelNew;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/BarrageHornView.class */
public class BarrageHornView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f14214a;
    private LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private List<View> f14215c;
    private List<LiveHornModelNew> d;

    public BarrageHornView(Context context) {
        super(context);
        this.f14215c = new ArrayList();
        this.d = new CopyOnWriteArrayList();
        this.f14214a = context;
        a();
    }

    public BarrageHornView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14215c = new ArrayList();
        this.d = new CopyOnWriteArrayList();
        this.f14214a = context;
        a();
    }

    public BarrageHornView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14215c = new ArrayList();
        this.d = new CopyOnWriteArrayList();
        this.f14214a = context;
        a();
    }

    private void a() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.b = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.b, -1, -1);
    }

    private void a(final View view) {
        if (view != null && this.d.size() > 0) {
            int i = 0;
            final LiveHornModelNew remove = this.d.remove(0);
            if (remove == null) {
                return;
            }
            view.setTag(true);
            view.setVisibility(0);
            Log.i("==xpz", " doAnim:" + remove.contents);
            final View findViewById = view.findViewById(R.id.horn_layout);
            ImageView imageView = (ImageView) view.findViewById(R.id.left_bg);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.middle_bg);
            ImageView imageView3 = (ImageView) view.findViewById(R.id.right_bg);
            ImageView imageView4 = (ImageView) view.findViewById(R.id.horn_icon);
            findViewById.setX(-AppInfo.l);
            TextView textView = (TextView) view.findViewById(R.id.horn_text);
            try {
                textView.setTextColor(Color.parseColor(remove.color));
            } catch (Exception e) {
                textView.setTextColor(-1);
            }
            if (!TextUtils.isEmpty(remove.contents)) {
                textView.setText(ScrollTextViewNew.a(new SpannableString(remove.contents), remove.highlight_color));
                i = (int) textView.getPaint().measureText(textView.getText().toString());
            }
            if (i != 0) {
                imageView2.getLayoutParams().width = i;
                findViewById.getLayoutParams().width = AppMethods.a(80) + i;
            }
            findViewById.getParent().requestLayout();
            int max = Math.max(9000, (int) (((i * 1.0f) / (AppInfo.l == 0 ? 1080 : AppInfo.l)) * 9000.0f)) + ((int) (Math.random() * 5000.0d));
            Log.i("==xpz", " textWidth:" + i + " time:" + max);
            ImageLoader.a((IRequestHost) null, remove.head_image).b(R.drawable.live_horn_left_bg).a(imageView);
            ImageLoader.a((IRequestHost) null, remove.back_image).b(R.drawable.live_horn_middle_bg).a(imageView2);
            ImageLoader.a((IRequestHost) null, remove.tail_image).b(R.drawable.live_horn_end_bg).a(imageView3);
            if (TextUtils.isEmpty(remove.icon_image) || !remove.icon_image.endsWith(".gif")) {
                ImageLoader.a((IRequestHost) null, remove.icon_image).b(R.drawable.live_horn_icon_new).e((int) (System.currentTimeMillis() / 1000)).g(-1).a(imageView4);
            } else {
                ImageLoader.a((IRequestHost) null, remove.icon_image).b(R.drawable.live_horn_icon_new).g(-1).a(imageView4);
            }
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.BarrageHornView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (!TextUtils.isEmpty(remove.redirect_url)) {
                        LiveRefreshUIObserver.a().b(remove.redirect_url, 0);
                        LiveSetDataObserver.a().b(remove.redirect_url, 0);
                    } else if (StringUtils.a(remove.lid, 0L) > 0) {
                        LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(remove.lid, 0L), 0, "live_room_ranking", remove.uid, "", "", 0);
                        if (LiveFloatManager.a().y() && !TextUtils.equals(remove.lid, LiveRoomManager.a().e())) {
                            LiveDataListManager.a().a(liveRoomData, false);
                        }
                    } else if (!TextUtils.isEmpty(remove.uid)) {
                        LiveSetDataObserver.a().e(remove.uid);
                    }
                    EventTrackLive.e(LiveProtos.Event.LIVE_HORN_CLICK, remove.lid, remove.uid, String.valueOf(remove.scene), remove.report_id);
                }
            });
            final int i2 = AppInfo.l;
            final int i3 = -findViewById.getLayoutParams().width;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(max);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.BarrageHornView.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    View view2 = findViewById;
                    int i4 = i3;
                    int i5 = i2;
                    view2.setX(((i4 - i5) * floatValue) + i5);
                }
            });
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.BarrageHornView.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    view.setVisibility(4);
                    view.setTag(false);
                    BarrageHornView.this.b();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            ofFloat.start();
            EventTrackLive.e(LiveProtos.Event.LIVE_HORN_SHOW, remove.lid, remove.uid, String.valueOf(remove.scene), remove.report_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        View barrageView;
        if (this.d.size() > 0 && (barrageView = getBarrageView()) != null) {
            a(barrageView);
        }
    }

    private View getBarrageView() {
        if (this.f14215c.size() < 2) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_barrage_horn, (ViewGroup) null);
            this.b.addView(inflate, -1, -2);
            inflate.setTag(true);
            this.f14215c.add(inflate);
            return inflate;
        }
        for (View view : this.f14215c) {
            if ((view.getTag() instanceof Boolean) && !((Boolean) view.getTag()).booleanValue()) {
                return view;
            }
        }
        return null;
    }

    public void a(LiveHornModelNew liveHornModelNew) {
        this.d.add(liveHornModelNew);
        Log.i("==xpz", "size:" + this.d.size() + " addBarrage:" + liveHornModelNew.contents);
        b();
    }
}
