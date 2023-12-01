package com.blued.android.module.yy_china.test;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/test/YYTypefaceUtils.class */
public class YYTypefaceUtils {

    /* renamed from: com.blued.android.module.yy_china.test.YYTypefaceUtils$1  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/test/YYTypefaceUtils$1.class */
    class AnonymousClass1 extends ClickableSpan {
        AnonymousClass1() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: com.blued.android.module.yy_china.test.YYTypefaceUtils$2  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/test/YYTypefaceUtils$2.class */
    class AnonymousClass2 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f17817a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            View.OnClickListener onClickListener = this.f17817a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* renamed from: com.blued.android.module.yy_china.test.YYTypefaceUtils$3  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/test/YYTypefaceUtils$3.class */
    class AnonymousClass3 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f17818a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            View.OnClickListener onClickListener = this.f17818a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/test/YYTypefaceUtils$ClickAtLinkListener.class */
    public interface ClickAtLinkListener {
        void a(String str, String str2);
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/test/YYTypefaceUtils$ClickLinkListener.class */
    public interface ClickLinkListener {
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/test/YYTypefaceUtils$SpannIndex.class */
    public static class SpannIndex {
    }
}
