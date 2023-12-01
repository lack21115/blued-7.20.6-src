package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.yy_china.databinding.FloatViewComingEventsBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYWebViewDialogFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.IMJsonContents108Model;
import com.blued.android.module.yy_china.model.YYEventsThemeModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYThemeActivityInfo;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/FloatComingEventsView.class */
public final class FloatComingEventsView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f17929a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f17930c;
    private int d;
    private CountDownTimer e;
    private String f;
    private BaseYYStudioFragment g;
    private final FloatViewComingEventsBinding h;
    private float i;
    private float j;
    private boolean k;

    public FloatComingEventsView(Context context) {
        this(context, null);
    }

    public FloatComingEventsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatComingEventsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = "";
        FloatViewComingEventsBinding a2 = FloatViewComingEventsBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
        this.h = a2;
    }

    private final String a(String str) {
        String g = TimeAndDateUtils.g(str);
        Intrinsics.c(g, "getStrYMDHMTime_2(time)");
        return g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        if (getParent() instanceof ViewGroup) {
            ViewParent parent = getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ((ViewGroup) parent).removeView(this);
        }
    }

    private final void a(final long j) {
        this.h.f16464c.setVisibility(8);
        this.h.g.setVisibility(8);
        this.h.f16463a.setVisibility(8);
        CountDownTimer countDownTimer = new CountDownTimer(j, this) { // from class: com.blued.android.module.yy_china.view.FloatComingEventsView$showTimer$1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ long f17931a;
            final /* synthetic */ FloatComingEventsView b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(j, 1000L);
                this.f17931a = j;
                this.b = this;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                FloatViewComingEventsBinding floatViewComingEventsBinding;
                floatViewComingEventsBinding = this.b.h;
                floatViewComingEventsBinding.e.setText("00:00");
                this.b.a();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                FloatViewComingEventsBinding floatViewComingEventsBinding;
                SimpleDateFormat simpleDateFormat = TimeAndDateUtils.k.get();
                Intrinsics.a(simpleDateFormat);
                String format = simpleDateFormat.format(Long.valueOf(j2));
                floatViewComingEventsBinding = this.b.h;
                floatViewComingEventsBinding.e.setText(format);
            }
        };
        this.e = countDownTimer;
        if (countDownTimer == null) {
            return;
        }
        countDownTimer.start();
    }

    private final void a(YYThemeActivityInfo yYThemeActivityInfo, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(DensityUtils.a(getContext(), 13.0f));
        gradientDrawable.setColor(Color.parseColor(str));
        this.h.g.setBackground(gradientDrawable);
        this.h.f16464c.setText(a(yYThemeActivityInfo.getStart_time()));
        this.h.e.setText(b(yYThemeActivityInfo.getStart_time()));
        this.h.f16463a.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FloatComingEventsView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FloatComingEventsView this$0, BaseYYStudioFragment fragment, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(fragment, "$fragment");
        if (TextUtils.isEmpty(this$0.f)) {
            return;
        }
        ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_PRE_POP_DETAIL_CLICK;
        YYRoomModel b = YYRoomInfoManager.e().b();
        EventTrackYY.d(event, b == null ? null : b.room_id, YYRoomInfoManager.e().b().uid);
        YYWebViewDialogFragment yYWebViewDialogFragment = new YYWebViewDialogFragment();
        yYWebViewDialogFragment.a(fragment, this$0.f);
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "fragment.childFragmentManager");
        yYWebViewDialogFragment.show(childFragmentManager, "activity_detail_dialog");
    }

    private final String b(String str) {
        String a2 = TimeAndDateUtils.a(str);
        Intrinsics.c(a2, "toDateMillionString(time)");
        return a2;
    }

    public final void a(final BaseYYStudioFragment fragment, IMJsonContents108Model iMJsonContents108Model) {
        Intrinsics.e(fragment, "fragment");
        this.g = fragment;
        this.h.f16463a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$FloatComingEventsView$XqUY4eqrJibxiQZJDr3kkorSY5s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatComingEventsView.a(FloatComingEventsView.this, view);
            }
        });
        this.h.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$FloatComingEventsView$xpOMQb7w7MYcE5vwj4kAEySf8zA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatComingEventsView.a(FloatComingEventsView.this, fragment, view);
            }
        });
        if (iMJsonContents108Model == null) {
            return;
        }
        ActivityFragmentActive fragmentActive = fragment.getFragmentActive();
        YYEventsThemeModel skin2 = iMJsonContents108Model.getSkin();
        ImageLoader.a(fragmentActive, skin2 == null ? null : skin2.getFloat_window_bg()).a(this.h.f);
        TextView textView = this.h.d;
        YYThemeActivityInfo activity_info = iMJsonContents108Model.getActivity_info();
        textView.setText(activity_info == null ? null : activity_info.getName());
        YYThemeActivityInfo activity_info2 = iMJsonContents108Model.getActivity_info();
        this.f = activity_info2 == null ? null : activity_info2.getLink();
        TextView textView2 = this.h.h;
        YYEventsThemeModel skin3 = iMJsonContents108Model.getSkin();
        textView2.setText(Intrinsics.a(skin3 == null ? null : skin3.getTheme_name(), (Object) "专场预告"));
        if (iMJsonContents108Model.getType() == 0) {
            ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_PRE_POP_SHOW;
            YYRoomModel b = YYRoomInfoManager.e().b();
            EventTrackYY.d(event, b == null ? null : b.room_id, YYRoomInfoManager.e().b().uid);
            YYThemeActivityInfo activity_info3 = iMJsonContents108Model.getActivity_info();
            YYEventsThemeModel skin4 = iMJsonContents108Model.getSkin();
            a(activity_info3, skin4 == null ? null : skin4.getButton_color());
        } else if (iMJsonContents108Model.getType() != 1 || iMJsonContents108Model.getCountdown_time() <= 0) {
        } else {
            long countdown_time = iMJsonContents108Model.getCountdown_time();
            long countdown_time2 = iMJsonContents108Model.getCountdown_time();
            long j = countdown_time2;
            if (countdown_time < 1000) {
                j = countdown_time2 * 1000;
            }
            a(j + 1000);
        }
    }

    public final BaseYYStudioFragment getFragment() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CountDownTimer countDownTimer = this.e;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.e = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f17929a = getMeasuredWidth();
        this.b = getMeasuredHeight();
        Object systemService = getContext().getSystemService(Context.WINDOW_SERVICE);
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        WindowManager windowManager = (WindowManager) systemService;
        this.f17930c = windowManager.getDefaultDisplay().getWidth();
        this.d = windowManager.getDefaultDisplay().getHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        float f;
        float f2;
        Intrinsics.e(event, "event");
        super.onTouchEvent(event);
        if (isEnabled()) {
            int actionMasked = event.getActionMasked();
            if (actionMasked == 0) {
                this.k = false;
                this.i = event.getRawX();
                this.j = event.getRawY();
                return true;
            } else if (actionMasked == 1) {
                setPressed(false);
                return true;
            } else if (actionMasked != 2) {
                if (actionMasked != 3) {
                    return true;
                }
                setPressed(false);
                return true;
            } else {
                float rawX = this.i - event.getRawX();
                float rawY = this.j - event.getRawY();
                if (Math.abs(rawX) > 10.0f || Math.abs(rawY) > 10.0f) {
                    this.k = true;
                    float y = getY() - rawY;
                    float x = getX() - rawX;
                    if (y < 0.0f) {
                        f = 0.0f;
                    } else {
                        f = y;
                        if (y > this.d - getHeight()) {
                            f = this.d - getHeight();
                        }
                    }
                    if (x < 0.0f) {
                        f2 = 0.0f;
                    } else {
                        f2 = x;
                        if (x > this.f17930c - getWidth()) {
                            f2 = this.f17930c - getWidth();
                        }
                    }
                    setX(f2);
                    setY(f);
                    this.i = event.getRawX();
                    this.j = event.getRawY();
                    return true;
                }
                return true;
            }
        }
        return true;
    }

    public final void setFragment(BaseYYStudioFragment baseYYStudioFragment) {
        this.g = baseYYStudioFragment;
    }
}
