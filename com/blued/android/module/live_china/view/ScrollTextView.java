package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.constant.LiveRoomConstants;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveHornModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/ScrollTextView.class */
public class ScrollTextView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public boolean f15242a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f15243c;
    private ImageView d;
    private TextView e;
    private float f;
    private int g;
    private float h;
    private float i;
    private OnScrollListener j;
    private LiveHornModel k;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/ScrollTextView$OnScrollListener.class */
    public interface OnScrollListener {
        void a();
    }

    public ScrollTextView(Context context) {
        super(context);
        this.f = 0.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.f15242a = false;
        this.b = context;
        c();
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 0.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.f15242a = false;
        this.b = context;
        c();
    }

    public ScrollTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 0.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.f15242a = false;
        this.b = context;
        c();
    }

    private void c() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.f15243c = from;
        View inflate = from.inflate(R.layout.scroll_text_layout, (ViewGroup) null);
        this.d = (ImageView) inflate.findViewById(R.id.scroll_icon);
        this.e = (TextView) inflate.findViewById(R.id.scroll_text);
        setWillNotDraw(false);
        addView(inflate);
    }

    public void a() {
        this.f15242a = true;
        invalidate();
    }

    public void a(final LiveHornModel liveHornModel) {
        this.k = liveHornModel;
        this.g = liveHornModel.type;
        TextPaint paint = this.e.getPaint();
        this.e.setText(liveHornModel.content);
        try {
            this.e.setTextColor(Color.parseColor(liveHornModel.color));
        } catch (Exception e) {
            this.e.setTextColor(-1);
        }
        String str = liveHornModel.content;
        String str2 = liveHornModel.highlight_new;
        SpannableString spannableString = new SpannableString(str);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && str.indexOf(str2) >= 0) {
            int indexOf = spannableString.toString().indexOf(str2);
            int indexOf2 = spannableString.toString().indexOf(str2) + str2.length();
            if (indexOf < 0 || indexOf2 < 0) {
                return;
            }
            spannableString.setSpan(new ClickableSpan() { // from class: com.blued.android.module.live_china.view.ScrollTextView.1
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(ScrollTextView.this.b.getResources().getColor(R.color.nafio_f));
                    textPaint.setUnderlineText(false);
                }
            }, indexOf, indexOf2, 33);
        }
        CharSequence a2 = LiveRoomInfo.a().a(spannableString, "#ffef5f", new LiveRoomConstants.ClickAtLinkListener() { // from class: com.blued.android.module.live_china.view.ScrollTextView.2
            @Override // com.blued.android.module.live_china.constant.LiveRoomConstants.ClickAtLinkListener
            public void a(String str3, String str4) {
                if (liveHornModel.type == 1) {
                    if (liveHornModel.is_win_streak) {
                        EventTrackLive.a(LiveProtos.Event.LIVE_PK_WIN_SYSTEM_BROADCAST_CLICK, liveHornModel.lid, liveHornModel.uid);
                    }
                    EventTrackLive.a(LiveProtos.Event.LIVE_HORN_CLICK, liveHornModel.lid, liveHornModel.uid);
                }
                if (TextUtils.isEmpty(str4)) {
                    LiveSetDataObserver.a().d(str3);
                } else {
                    LiveSetDataObserver.a().e(str4);
                }
            }
        });
        this.e.setText(a2);
        if (liveHornModel.is_hongbao) {
            this.d.setImageResource(R.drawable.live_hongbao_horn_icon);
        } else if (liveHornModel.is_wifi) {
            this.d.setImageResource(R.drawable.wifi_horn_icon);
        } else if (TextUtils.isEmpty(liveHornModel.notify_icon)) {
            this.d.setImageResource(R.drawable.live_horn_icon);
        } else {
            ImageLoader.a((IRequestHost) null, liveHornModel.notify_icon).a(this.d);
        }
        if (liveHornModel.type == 1) {
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            layoutParams.width = AppMethods.a(32);
            layoutParams.height = AppMethods.a(32);
            this.d.setLayoutParams(layoutParams);
            this.e.setTextSize(14.0f);
            this.f = paint.measureText(a2.toString()) + AppMethods.a(32) + AppMethods.a(8);
        } else if (liveHornModel.type == 2) {
            ViewGroup.LayoutParams layoutParams2 = this.d.getLayoutParams();
            layoutParams2.width = AppMethods.a(18);
            layoutParams2.height = AppMethods.a(18);
            this.d.setLayoutParams(layoutParams2);
            this.e.setTextSize(12.0f);
            this.f = paint.measureText(a2.toString()) + AppMethods.a(18) + AppMethods.a(8);
        }
        this.e.setMovementMethod(LinkMovementClickMethod.a());
    }

    public void b() {
        this.f15242a = false;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.translate(this.h, 0.0f);
        if (!this.f15242a) {
            super.onDraw(canvas);
            return;
        }
        float f = this.h - 3.0f;
        this.h = f;
        if (f <= (-this.f)) {
            this.h = 0.0f;
            b();
            OnScrollListener onScrollListener = this.j;
            if (onScrollListener != null) {
                onScrollListener.a();
            }
        }
        invalidate();
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure((int) this.f, i2);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.j = onScrollListener;
    }
}
