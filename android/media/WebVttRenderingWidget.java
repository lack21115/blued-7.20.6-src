package android.media;

import android.content.Context;
import android.media.SubtitleTrack;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.CaptioningManager;
import android.widget.LinearLayout;
import com.android.internal.widget.SubtitleView;
import java.util.ArrayList;
import java.util.Vector;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/media/WebVttRenderingWidget.class */
public class WebVttRenderingWidget extends ViewGroup implements SubtitleTrack.RenderingWidget {
    private static final boolean DEBUG = false;
    private static final int DEBUG_CUE_BACKGROUND = -2130771968;
    private static final int DEBUG_REGION_BACKGROUND = -2147483393;
    private static final CaptioningManager.CaptionStyle DEFAULT_CAPTION_STYLE = CaptioningManager.CaptionStyle.DEFAULT;
    private static final float LINE_HEIGHT_RATIO = 0.0533f;
    private CaptioningManager.CaptionStyle mCaptionStyle;
    private final CaptioningManager.CaptioningChangeListener mCaptioningListener;
    private final ArrayMap<TextTrackCue, CueLayout> mCueBoxes;
    private float mFontSize;
    private boolean mHasChangeListener;
    private SubtitleTrack.RenderingWidget.OnChangedListener mListener;
    private final CaptioningManager mManager;
    private final ArrayMap<TextTrackRegion, RegionLayout> mRegionBoxes;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/WebVttRenderingWidget$CueLayout.class */
    public static class CueLayout extends LinearLayout {
        private boolean mActive;
        private CaptioningManager.CaptionStyle mCaptionStyle;
        public final TextTrackCue mCue;
        private float mFontSize;
        private int mOrder;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CueLayout(Context context, TextTrackCue textTrackCue, CaptioningManager.CaptionStyle captionStyle, float f) {
            super(context);
            int i = 0;
            this.mCue = textTrackCue;
            this.mCaptionStyle = captionStyle;
            this.mFontSize = f;
            boolean z = textTrackCue.mWritingDirection == 100;
            setOrientation(z ? 1 : i);
            switch (textTrackCue.mAlignment) {
                case 200:
                    setGravity(z ? 1 : 16);
                    break;
                case 201:
                    setGravity(8388611);
                    break;
                case 202:
                    setGravity(8388613);
                    break;
                case 203:
                    setGravity(3);
                    break;
                case 204:
                    setGravity(5);
                    break;
            }
            update();
        }

        public TextTrackCue getCue() {
            return this.mCue;
        }

        public boolean isActive() {
            return this.mActive;
        }

        public void measureForParent(int i, int i2) {
            int i3;
            TextTrackCue textTrackCue = this.mCue;
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            switch (WebVttRenderingWidget.resolveCueAlignment(getLayoutDirection(), textTrackCue.mAlignment)) {
                case 200:
                    if (textTrackCue.mTextPosition > 50) {
                        i3 = (100 - textTrackCue.mTextPosition) * 2;
                        break;
                    } else {
                        i3 = textTrackCue.mTextPosition * 2;
                        break;
                    }
                case 201:
                case 202:
                default:
                    i3 = 0;
                    break;
                case 203:
                    i3 = 100 - textTrackCue.mTextPosition;
                    break;
                case 204:
                    i3 = textTrackCue.mTextPosition;
                    break;
            }
            measure(View.MeasureSpec.makeMeasureSpec((Math.min(textTrackCue.mSize, i3) * size) / 100, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
        }

        public void prepForPrune() {
            this.mActive = false;
        }

        public void setCaptionStyle(CaptioningManager.CaptionStyle captionStyle, float f) {
            this.mCaptionStyle = captionStyle;
            this.mFontSize = f;
            int childCount = getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    return;
                }
                View childAt = getChildAt(i2);
                if (childAt instanceof SpanLayout) {
                    ((SpanLayout) childAt).setCaptionStyle(captionStyle, f);
                }
                i = i2 + 1;
            }
        }

        public void setOrder(int i) {
            this.mOrder = i;
        }

        public void update() {
            Layout.Alignment alignment;
            this.mActive = true;
            removeAllViews();
            switch (WebVttRenderingWidget.resolveCueAlignment(getLayoutDirection(), this.mCue.mAlignment)) {
                case 203:
                    alignment = Layout.Alignment.ALIGN_LEFT;
                    break;
                case 204:
                    alignment = Layout.Alignment.ALIGN_RIGHT;
                    break;
                default:
                    alignment = Layout.Alignment.ALIGN_CENTER;
                    break;
            }
            CaptioningManager.CaptionStyle captionStyle = this.mCaptionStyle;
            float f = this.mFontSize;
            TextTrackCueSpan[][] textTrackCueSpanArr = this.mCue.mLines;
            int length = textTrackCueSpanArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                SpanLayout spanLayout = new SpanLayout(getContext(), textTrackCueSpanArr[i2]);
                spanLayout.setAlignment(alignment);
                spanLayout.setCaptionStyle(captionStyle, f);
                addView(spanLayout, -2, -2);
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/WebVttRenderingWidget$RegionLayout.class */
    public static class RegionLayout extends LinearLayout {
        private CaptioningManager.CaptionStyle mCaptionStyle;
        private float mFontSize;
        private final TextTrackRegion mRegion;
        private final ArrayList<CueLayout> mRegionCueBoxes;

        public RegionLayout(Context context, TextTrackRegion textTrackRegion, CaptioningManager.CaptionStyle captionStyle, float f) {
            super(context);
            this.mRegionCueBoxes = new ArrayList<>();
            this.mRegion = textTrackRegion;
            this.mCaptionStyle = captionStyle;
            this.mFontSize = f;
            setOrientation(1);
            setBackgroundColor(captionStyle.windowColor);
        }

        public TextTrackRegion getRegion() {
            return this.mRegion;
        }

        public void measureForParent(int i, int i2) {
            TextTrackRegion textTrackRegion = this.mRegion;
            measure(View.MeasureSpec.makeMeasureSpec((((int) textTrackRegion.mWidth) * View.MeasureSpec.getSize(i)) / 100, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), Integer.MIN_VALUE));
        }

        public void prepForPrune() {
            int size = this.mRegionCueBoxes.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                this.mRegionCueBoxes.get(i2).prepForPrune();
                i = i2 + 1;
            }
        }

        public boolean prune() {
            int size = this.mRegionCueBoxes.size();
            int i = 0;
            while (i < size) {
                CueLayout cueLayout = this.mRegionCueBoxes.get(i);
                int i2 = size;
                int i3 = i;
                if (!cueLayout.isActive()) {
                    this.mRegionCueBoxes.remove(i);
                    removeView(cueLayout);
                    i2 = size - 1;
                    i3 = i - 1;
                }
                i = i3 + 1;
                size = i2;
            }
            return this.mRegionCueBoxes.isEmpty();
        }

        public void put(TextTrackCue textTrackCue) {
            int size = this.mRegionCueBoxes.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    CueLayout cueLayout = new CueLayout(getContext(), textTrackCue, this.mCaptionStyle, this.mFontSize);
                    this.mRegionCueBoxes.add(cueLayout);
                    addView(cueLayout, -2, -2);
                    if (getChildCount() > this.mRegion.mLines) {
                        removeViewAt(0);
                        return;
                    }
                    return;
                }
                CueLayout cueLayout2 = this.mRegionCueBoxes.get(i2);
                if (cueLayout2.getCue() == textTrackCue) {
                    cueLayout2.update();
                    return;
                }
                i = i2 + 1;
            }
        }

        public void setCaptionStyle(CaptioningManager.CaptionStyle captionStyle, float f) {
            this.mCaptionStyle = captionStyle;
            this.mFontSize = f;
            int size = this.mRegionCueBoxes.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    setBackgroundColor(captionStyle.windowColor);
                    return;
                } else {
                    this.mRegionCueBoxes.get(i2).setCaptionStyle(captionStyle, f);
                    i = i2 + 1;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/WebVttRenderingWidget$SpanLayout.class */
    public static class SpanLayout extends SubtitleView {
        private final SpannableStringBuilder mBuilder;
        private final TextTrackCueSpan[] mSpans;

        public SpanLayout(Context context, TextTrackCueSpan[] textTrackCueSpanArr) {
            super(context);
            this.mBuilder = new SpannableStringBuilder();
            this.mSpans = textTrackCueSpanArr;
            update();
        }

        public void setCaptionStyle(CaptioningManager.CaptionStyle captionStyle, float f) {
            setBackgroundColor(captionStyle.backgroundColor);
            setForegroundColor(captionStyle.foregroundColor);
            setEdgeColor(captionStyle.edgeColor);
            setEdgeType(captionStyle.edgeType);
            setTypeface(captionStyle.getTypeface());
            setTextSize(f);
        }

        public void update() {
            SpannableStringBuilder spannableStringBuilder = this.mBuilder;
            TextTrackCueSpan[] textTrackCueSpanArr = this.mSpans;
            spannableStringBuilder.clear();
            spannableStringBuilder.clearSpans();
            int length = textTrackCueSpanArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    setText(spannableStringBuilder);
                    return;
                }
                if (textTrackCueSpanArr[i2].mEnabled) {
                    spannableStringBuilder.append((CharSequence) textTrackCueSpanArr[i2].mText);
                }
                i = i2 + 1;
            }
        }
    }

    public WebVttRenderingWidget(Context context) {
        this(context, null);
    }

    public WebVttRenderingWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebVttRenderingWidget(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public WebVttRenderingWidget(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mRegionBoxes = new ArrayMap<>();
        this.mCueBoxes = new ArrayMap<>();
        this.mCaptioningListener = new CaptioningManager.CaptioningChangeListener() { // from class: android.media.WebVttRenderingWidget.1
            @Override // android.view.accessibility.CaptioningManager.CaptioningChangeListener
            public void onFontScaleChanged(float f) {
                WebVttRenderingWidget.this.setCaptionStyle(WebVttRenderingWidget.this.mCaptionStyle, WebVttRenderingWidget.this.getHeight() * f * WebVttRenderingWidget.LINE_HEIGHT_RATIO);
            }

            @Override // android.view.accessibility.CaptioningManager.CaptioningChangeListener
            public void onUserStyleChanged(CaptioningManager.CaptionStyle captionStyle) {
                WebVttRenderingWidget.this.setCaptionStyle(captionStyle, WebVttRenderingWidget.this.mFontSize);
            }
        };
        setLayerType(1, null);
        this.mManager = (CaptioningManager) context.getSystemService(Context.CAPTIONING_SERVICE);
        this.mCaptionStyle = this.mManager.getUserStyle();
        this.mFontSize = this.mManager.getFontScale() * getHeight() * LINE_HEIGHT_RATIO;
    }

    private int calculateLinePosition(CueLayout cueLayout) {
        TextTrackCue cue = cueLayout.getCue();
        Integer num = cue.mLinePosition;
        boolean z = cue.mSnapToLines;
        boolean z2 = num == null;
        if (z || z2 || (num.intValue() >= 0 && num.intValue() <= 100)) {
            if (z2) {
                if (z) {
                    return -(cueLayout.mOrder + 1);
                }
                return 100;
            }
            return num.intValue();
        }
        return 100;
    }

    private void layoutCue(int i, int i2, CueLayout cueLayout) {
        int i3;
        TextTrackCue cue = cueLayout.getCue();
        int layoutDirection = getLayoutDirection();
        int resolveCueAlignment = resolveCueAlignment(layoutDirection, cue.mAlignment);
        boolean z = cue.mSnapToLines;
        int measuredWidth = (cueLayout.getMeasuredWidth() * 100) / i;
        switch (resolveCueAlignment) {
            case 203:
                i3 = cue.mTextPosition;
                break;
            case 204:
                i3 = cue.mTextPosition - measuredWidth;
                break;
            default:
                i3 = cue.mTextPosition - (measuredWidth / 2);
                break;
        }
        int i4 = i3;
        if (layoutDirection == 1) {
            i4 = 100 - i3;
        }
        int i5 = measuredWidth;
        int i6 = i4;
        if (z) {
            int paddingLeft = (getPaddingLeft() * 100) / i;
            int paddingRight = (getPaddingRight() * 100) / i;
            int i7 = measuredWidth;
            int i8 = i4;
            if (i4 < paddingLeft) {
                i7 = measuredWidth;
                i8 = i4;
                if (i4 + measuredWidth > paddingLeft) {
                    i8 = i4 + paddingLeft;
                    i7 = measuredWidth - paddingLeft;
                }
            }
            float f = 100 - paddingRight;
            i5 = i7;
            i6 = i8;
            if (i8 < f) {
                i5 = i7;
                i6 = i8;
                if (i8 + i7 > f) {
                    i5 = i7 - paddingRight;
                    i6 = i8;
                }
            }
        }
        int i9 = (i6 * i) / 100;
        int i10 = (i5 * i) / 100;
        int calculateLinePosition = calculateLinePosition(cueLayout);
        int measuredHeight = cueLayout.getMeasuredHeight();
        int i11 = calculateLinePosition < 0 ? i2 + (calculateLinePosition * measuredHeight) : ((i2 - measuredHeight) * calculateLinePosition) / 100;
        cueLayout.layout(i9, i11, i9 + i10, i11 + measuredHeight);
    }

    private void layoutRegion(int i, int i2, RegionLayout regionLayout) {
        TextTrackRegion region = regionLayout.getRegion();
        int measuredHeight = regionLayout.getMeasuredHeight();
        int measuredWidth = regionLayout.getMeasuredWidth();
        float f = region.mViewportAnchorPointX;
        float f2 = region.mViewportAnchorPointY;
        int i3 = (int) (((i - measuredWidth) * f) / 100.0f);
        int i4 = (int) (((i2 - measuredHeight) * f2) / 100.0f);
        regionLayout.layout(i3, i4, i3 + measuredWidth, i4 + measuredHeight);
    }

    private void manageChangeListener() {
        boolean z = isAttachedToWindow() && getVisibility() == 0;
        if (this.mHasChangeListener != z) {
            this.mHasChangeListener = z;
            if (!z) {
                this.mManager.removeCaptioningChangeListener(this.mCaptioningListener);
                return;
            }
            this.mManager.addCaptioningChangeListener(this.mCaptioningListener);
            setCaptionStyle(this.mManager.getUserStyle(), this.mManager.getFontScale() * getHeight() * LINE_HEIGHT_RATIO);
        }
    }

    private void prepForPrune() {
        int size = this.mRegionBoxes.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            this.mRegionBoxes.valueAt(i2).prepForPrune();
            i = i2 + 1;
        }
        int size2 = this.mCueBoxes.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size2) {
                return;
            }
            this.mCueBoxes.valueAt(i4).prepForPrune();
            i3 = i4 + 1;
        }
    }

    private void prune() {
        int size = this.mRegionBoxes.size();
        int i = 0;
        while (i < size) {
            RegionLayout valueAt = this.mRegionBoxes.valueAt(i);
            int i2 = i;
            int i3 = size;
            if (valueAt.prune()) {
                removeView(valueAt);
                this.mRegionBoxes.removeAt(i);
                i3 = size - 1;
                i2 = i - 1;
            }
            i = i2 + 1;
            size = i3;
        }
        int size2 = this.mCueBoxes.size();
        int i4 = 0;
        while (i4 < size2) {
            CueLayout valueAt2 = this.mCueBoxes.valueAt(i4);
            int i5 = size2;
            int i6 = i4;
            if (!valueAt2.isActive()) {
                removeView(valueAt2);
                this.mCueBoxes.removeAt(i4);
                i5 = size2 - 1;
                i6 = i4 - 1;
            }
            i4 = i6 + 1;
            size2 = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int resolveCueAlignment(int i, int i2) {
        switch (i2) {
            case 202:
                return i == 0 ? 204 : 203;
            case 201:
                i2 = 203;
                if (i != 0) {
                    return 204;
                }
                break;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCaptionStyle(CaptioningManager.CaptionStyle captionStyle, float f) {
        CaptioningManager.CaptionStyle applyStyle = DEFAULT_CAPTION_STYLE.applyStyle(captionStyle);
        this.mCaptionStyle = applyStyle;
        this.mFontSize = f;
        int size = this.mCueBoxes.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            this.mCueBoxes.valueAt(i2).setCaptionStyle(applyStyle, f);
            i = i2 + 1;
        }
        int size2 = this.mRegionBoxes.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size2) {
                return;
            }
            this.mRegionBoxes.valueAt(i4).setCaptionStyle(applyStyle, f);
            i3 = i4 + 1;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        manageChangeListener();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        manageChangeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        setCaptionStyle(this.mCaptionStyle, this.mManager.getFontScale() * LINE_HEIGHT_RATIO * i6);
        int size = this.mRegionBoxes.size();
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= size) {
                break;
            }
            layoutRegion(i5, i6, this.mRegionBoxes.valueAt(i8));
            i7 = i8 + 1;
        }
        int size2 = this.mCueBoxes.size();
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= size2) {
                return;
            }
            layoutCue(i5, i6, this.mCueBoxes.valueAt(i10));
            i9 = i10 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = this.mRegionBoxes.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                break;
            }
            this.mRegionBoxes.valueAt(i4).measureForParent(i, i2);
            i3 = i4 + 1;
        }
        int size2 = this.mCueBoxes.size();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= size2) {
                return;
            }
            this.mCueBoxes.valueAt(i6).measureForParent(i, i2);
            i5 = i6 + 1;
        }
    }

    public void setActiveCues(Vector<SubtitleTrack.Cue> vector) {
        Context context = getContext();
        CaptioningManager.CaptionStyle captionStyle = this.mCaptionStyle;
        float f = this.mFontSize;
        prepForPrune();
        int size = vector.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            TextTrackCue textTrackCue = (TextTrackCue) vector.get(i2);
            TextTrackRegion textTrackRegion = textTrackCue.mRegion;
            if (textTrackRegion != null) {
                RegionLayout regionLayout = this.mRegionBoxes.get(textTrackRegion);
                RegionLayout regionLayout2 = regionLayout;
                if (regionLayout == null) {
                    regionLayout2 = new RegionLayout(context, textTrackRegion, captionStyle, f);
                    this.mRegionBoxes.put(textTrackRegion, regionLayout2);
                    addView(regionLayout2, -2, -2);
                }
                regionLayout2.put(textTrackCue);
            } else {
                CueLayout cueLayout = this.mCueBoxes.get(textTrackCue);
                CueLayout cueLayout2 = cueLayout;
                if (cueLayout == null) {
                    cueLayout2 = new CueLayout(context, textTrackCue, captionStyle, f);
                    this.mCueBoxes.put(textTrackCue, cueLayout2);
                    addView(cueLayout2, -2, -2);
                }
                cueLayout2.update();
                cueLayout2.setOrder(i2);
            }
            i = i2 + 1;
        }
        prune();
        setSize(getWidth(), getHeight());
        if (this.mListener != null) {
            this.mListener.onChanged(this);
        }
    }

    @Override // android.media.SubtitleTrack.RenderingWidget
    public void setOnChangedListener(SubtitleTrack.RenderingWidget.OnChangedListener onChangedListener) {
        this.mListener = onChangedListener;
    }

    @Override // android.media.SubtitleTrack.RenderingWidget
    public void setSize(int i, int i2) {
        measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        layout(0, 0, i, i2);
    }

    @Override // android.media.SubtitleTrack.RenderingWidget
    public void setVisible(boolean z) {
        if (z) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
        manageChangeListener();
    }
}
