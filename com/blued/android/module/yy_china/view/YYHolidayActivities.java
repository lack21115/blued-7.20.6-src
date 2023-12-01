package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.android.internal.R;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.yy_china.databinding.HolidayActivitiesLayoutBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.DialogPrizeOfActivity;
import com.blued.android.module.yy_china.fragment.YYWebViewDialogFragment;
import com.blued.android.module.yy_china.model.EventRoomPkSvgaExtra;
import com.blued.android.module.yy_china.model.IMJsonContents96Model;
import com.blued.android.module.yy_china.model.IMJsonContents97Model;
import com.blued.android.module.yy_china.model.YYDrawActivityModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYHolidayActivities.class */
public final class YYHolidayActivities extends ConstraintLayout {
    private HolidayActivitiesLayoutBinding a;
    private BaseYYStudioFragment b;
    private final int c;
    private String d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYHolidayActivities(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYHolidayActivities(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYHolidayActivities(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        HolidayActivitiesLayoutBinding a = HolidayActivitiesLayoutBinding.a(LayoutInflater.from(getContext()), (ViewGroup) this, true);
        Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
        this.a = a;
        this.c = DensityUtils.a(getContext(), 5.0f);
        this.d = "";
        int a2 = DensityUtils.a(getContext(), 47.0f);
        int a3 = DensityUtils.a(getContext(), 10.0f);
        ViewGroup.LayoutParams layoutParams = this.a.a.getLayoutParams();
        layoutParams.width = a2;
        layoutParams.height = a3;
    }

    private final GradientDrawable a(int i, int i2, float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColors(new int[]{i, i2});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    private final void a() {
        if (this.b == null) {
            return;
        }
        Observable observable = LiveEventBus.get("room_activity_entrance", IMJsonContents96Model.class);
        LifecycleOwner lifecycleOwner = this.b;
        Intrinsics.a(lifecycleOwner);
        observable.observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYHolidayActivities$PWeNjlQJ3_63M617eUsx202J5jM
            public final void onChanged(Object obj) {
                YYHolidayActivities.a(YYHolidayActivities.this, (IMJsonContents96Model) obj);
            }
        });
        Observable observable2 = LiveEventBus.get("play_activity_animation", IMJsonContents97Model.class);
        LifecycleOwner lifecycleOwner2 = this.b;
        Intrinsics.a(lifecycleOwner2);
        observable2.observe(lifecycleOwner2, new Observer() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYHolidayActivities$BAVGNFlbnkt66bCWcjjor8eZLho
            public final void onChanged(Object obj) {
                YYHolidayActivities.a(YYHolidayActivities.this, (IMJsonContents97Model) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(YYDrawActivityModel yYDrawActivityModel) {
        BaseYYStudioFragment baseYYStudioFragment = this.b;
        if (baseYYStudioFragment == null) {
            return;
        }
        DialogPrizeOfActivity dialogPrizeOfActivity = new DialogPrizeOfActivity(yYDrawActivityModel);
        FragmentManager parentFragmentManager = baseYYStudioFragment.getParentFragmentManager();
        Intrinsics.c(parentFragmentManager, "it.parentFragmentManager");
        dialogPrizeOfActivity.show(parentFragmentManager, "activity_prize_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYHolidayActivities this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYHolidayActivities this$0, View view) {
        FragmentManager parentFragmentManager;
        Intrinsics.e(this$0, "this$0");
        if (TextUtils.isEmpty(this$0.d)) {
            return;
        }
        YYWebViewDialogFragment yYWebViewDialogFragment = new YYWebViewDialogFragment();
        yYWebViewDialogFragment.a(this$0.b, this$0.d);
        BaseYYStudioFragment baseYYStudioFragment = this$0.b;
        if (baseYYStudioFragment == null || (parentFragmentManager = baseYYStudioFragment.getParentFragmentManager()) == null) {
            return;
        }
        yYWebViewDialogFragment.show(parentFragmentManager, "dialog_activity_web");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final YYHolidayActivities this$0, IMJsonContents96Model iMJsonContents96Model) {
        Intrinsics.e(this$0, "this$0");
        this$0.setVisibility(0);
        this$0.d = iMJsonContents96Model.getLink();
        BaseYYStudioFragment baseYYStudioFragment = this$0.b;
        ImageLoader.a(baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive(), iMJsonContents96Model.getIcon()).a(this$0.a.b);
        TextView textView = this$0.a.c;
        StringBuilder sb = new StringBuilder();
        sb.append(iMJsonContents96Model.getNum());
        sb.append('/');
        sb.append(iMJsonContents96Model.getTotal());
        textView.setText(sb.toString());
        this$0.setProgressTextColor(iMJsonContents96Model.getFont_color());
        this$0.a(iMJsonContents96Model.getProgress_bg_color(), iMJsonContents96Model.getProgress_start_color(), iMJsonContents96Model.getProgress_end_color());
        this$0.a.a.setMax(iMJsonContents96Model.getTotal());
        this$0.a.a.setProgress(iMJsonContents96Model.getNum());
        BaseYYStudioFragment baseYYStudioFragment2 = this$0.b;
        if (baseYYStudioFragment2 == null) {
            return;
        }
        baseYYStudioFragment2.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYHolidayActivities$FfCJucxSFZzUL8LFKgW0QOvYKl0
            @Override // java.lang.Runnable
            public final void run() {
                YYHolidayActivities.a(YYHolidayActivities.this);
            }
        }, iMJsonContents96Model.getDelay() * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final YYHolidayActivities this$0, IMJsonContents97Model iMJsonContents97Model) {
        SVGAImageView sVGAImageView;
        Intrinsics.e(this$0, "this$0");
        EventRoomPkSvgaExtra eventRoomPkSvgaExtra = new EventRoomPkSvgaExtra();
        eventRoomPkSvgaExtra.svgaName = iMJsonContents97Model.getUrl();
        eventRoomPkSvgaExtra.svgaType = 2;
        eventRoomPkSvgaExtra.clickable = true;
        eventRoomPkSvgaExtra.frameWidth = 0;
        eventRoomPkSvgaExtra.frameHeight = 0;
        LiveEventBus.get("play_svga_room_pk").post(eventRoomPkSvgaExtra);
        BaseYYStudioFragment baseYYStudioFragment = this$0.b;
        if (baseYYStudioFragment == null || (sVGAImageView = baseYYStudioFragment.aa) == null) {
            return;
        }
        sVGAImageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYHolidayActivities$mb0JpKJKAs4-hiUWyW-X-puR9vw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYHolidayActivities.b(YYHolidayActivities.this, view);
            }
        });
    }

    private final void a(String str, String str2, String str3) {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{a(Color.parseColor(str), Color.parseColor(str), this.c), new ScaleDrawable(a(Color.parseColor(str2), Color.parseColor(str3), this.c), 3, 1.0f, 0.5f)});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.progress);
        this.a.a.setProgressDrawable(layerDrawable);
    }

    private final void b() {
        BaseYYStudioFragment baseYYStudioFragment = this.b;
        final ActivityFragmentActive fragmentActive = baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive();
        BluedUIHttpResponse<BluedEntityA<YYDrawActivityModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<YYDrawActivityModel>>(fragmentActive) { // from class: com.blued.android.module.yy_china.view.YYHolidayActivities$toGrabPrize$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYDrawActivityModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                YYHolidayActivities yYHolidayActivities = YYHolidayActivities.this;
                YYDrawActivityModel singleData = bluedEntityA.getSingleData();
                Intrinsics.c(singleData, "response.singleData");
                yYHolidayActivities.a(singleData);
            }
        };
        BaseYYStudioFragment baseYYStudioFragment2 = this.b;
        YYRoomHttpUtils.d((BluedUIHttpResponse) bluedUIHttpResponse, baseYYStudioFragment2 == null ? null : baseYYStudioFragment2.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYHolidayActivities this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.b();
    }

    private final void setProgressTextColor(String str) {
        this.a.c.setTextColor(Color.parseColor(str));
    }

    public final void a(BaseYYStudioFragment attachFragment) {
        Intrinsics.e(attachFragment, "attachFragment");
        this.b = attachFragment;
        a();
        setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYHolidayActivities$Vnhrt4DOTx940W_6mR_WZRGUMMs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYHolidayActivities.a(YYHolidayActivities.this, view);
            }
        });
    }
}
