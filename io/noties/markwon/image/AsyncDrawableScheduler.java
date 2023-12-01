package io.noties.markwon.image;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import io.noties.markwon.R;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/image/AsyncDrawableScheduler.class */
public abstract class AsyncDrawableScheduler {

    /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/image/AsyncDrawableScheduler$DrawableCallbackImpl.class */
    static class DrawableCallbackImpl implements Drawable.Callback {
        private final Invalidator invalidator;
        private Rect previousBounds;
        private final TextView view;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/image/AsyncDrawableScheduler$DrawableCallbackImpl$Invalidator.class */
        public interface Invalidator {
            void invalidate();
        }

        DrawableCallbackImpl(TextView textView, Invalidator invalidator, Rect rect) {
            this.view = textView;
            this.invalidator = invalidator;
            this.previousBounds = new Rect(rect);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(final Drawable drawable) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.view.post(new Runnable() { // from class: io.noties.markwon.image.AsyncDrawableScheduler.DrawableCallbackImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DrawableCallbackImpl.this.invalidateDrawable(drawable);
                    }
                });
                return;
            }
            Rect bounds = drawable.getBounds();
            if (this.previousBounds.equals(bounds)) {
                this.view.postInvalidate();
                return;
            }
            this.invalidator.invalidate();
            this.previousBounds = new Rect(bounds);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.view.postDelayed(runnable, j - SystemClock.uptimeMillis());
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.view.removeCallbacks(runnable);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/image/AsyncDrawableScheduler$TextViewInvalidator.class */
    static class TextViewInvalidator implements DrawableCallbackImpl.Invalidator, Runnable {
        private final TextView textView;

        TextViewInvalidator(TextView textView) {
            this.textView = textView;
        }

        @Override // io.noties.markwon.image.AsyncDrawableScheduler.DrawableCallbackImpl.Invalidator
        public void invalidate() {
            this.textView.removeCallbacks(this);
            this.textView.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView = this.textView;
            textView.setText(textView.getText());
        }
    }

    private AsyncDrawableScheduler() {
    }

    private static AsyncDrawableSpan[] extractSpans(TextView textView) {
        CharSequence text = textView.getText();
        int length = text != null ? text.length() : 0;
        if (length == 0 || !(text instanceof Spanned)) {
            return null;
        }
        return (AsyncDrawableSpan[]) ((Spanned) text).getSpans(0, length, AsyncDrawableSpan.class);
    }

    public static void schedule(final TextView textView) {
        Integer num = (Integer) textView.getTag(R.id.markwon_drawables_scheduler_last_text_hashcode);
        int hashCode = textView.getText().hashCode();
        if (num != null && num.intValue() == hashCode) {
            return;
        }
        textView.setTag(R.id.markwon_drawables_scheduler_last_text_hashcode, Integer.valueOf(hashCode));
        AsyncDrawableSpan[] extractSpans = extractSpans(textView);
        if (extractSpans == null || extractSpans.length <= 0) {
            return;
        }
        if (textView.getTag(R.id.markwon_drawables_scheduler) == null) {
            View.OnAttachStateChangeListener onAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: io.noties.markwon.image.AsyncDrawableScheduler.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    AsyncDrawableScheduler.unschedule(TextView.this);
                    view.removeOnAttachStateChangeListener(this);
                    view.setTag(R.id.markwon_drawables_scheduler, null);
                }
            };
            textView.addOnAttachStateChangeListener(onAttachStateChangeListener);
            textView.setTag(R.id.markwon_drawables_scheduler, onAttachStateChangeListener);
        }
        TextViewInvalidator textViewInvalidator = new TextViewInvalidator(textView);
        int length = extractSpans.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            AsyncDrawable drawable = extractSpans[i2].getDrawable();
            drawable.setCallback2(new DrawableCallbackImpl(textView, textViewInvalidator, drawable.getBounds()));
            i = i2 + 1;
        }
    }

    public static void unschedule(TextView textView) {
        if (textView.getTag(R.id.markwon_drawables_scheduler_last_text_hashcode) == null) {
            return;
        }
        textView.setTag(R.id.markwon_drawables_scheduler_last_text_hashcode, null);
        AsyncDrawableSpan[] extractSpans = extractSpans(textView);
        if (extractSpans == null || extractSpans.length <= 0) {
            return;
        }
        int length = extractSpans.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            extractSpans[i2].getDrawable().setCallback2(null);
            i = i2 + 1;
        }
    }
}
