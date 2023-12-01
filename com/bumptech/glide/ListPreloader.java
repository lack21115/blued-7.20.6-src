package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import java.util.List;
import java.util.Queue;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/ListPreloader.class */
public class ListPreloader<T> implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    private final int f20653a;
    private final PreloadTargetQueue b;

    /* renamed from: c  reason: collision with root package name */
    private final RequestManager f20654c;
    private final PreloadModelProvider<T> d;
    private final PreloadSizeProvider<T> e;
    private int f;
    private int g;
    private int h;
    private int i;
    private boolean j;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/ListPreloader$PreloadModelProvider.class */
    public interface PreloadModelProvider<U> {
        RequestBuilder<?> a(U u);

        List<U> a(int i);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/ListPreloader$PreloadSizeProvider.class */
    public interface PreloadSizeProvider<T> {
        int[] a(T t, int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/ListPreloader$PreloadTarget.class */
    public static final class PreloadTarget implements Target<Object> {

        /* renamed from: a  reason: collision with root package name */
        int f20655a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        private Request f20656c;

        PreloadTarget() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public Request getRequest() {
            return this.f20656c;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void getSize(SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.a(this.b, this.f20655a);
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onDestroy() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadStarted(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object obj, Transition<? super Object> transition) {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStart() {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStop() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void removeCallback(SizeReadyCallback sizeReadyCallback) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void setRequest(Request request) {
            this.f20656c = request;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/ListPreloader$PreloadTargetQueue.class */
    public static final class PreloadTargetQueue {

        /* renamed from: a  reason: collision with root package name */
        final Queue<PreloadTarget> f20657a;

        public PreloadTarget a(int i, int i2) {
            PreloadTarget poll = this.f20657a.poll();
            this.f20657a.offer(poll);
            poll.b = i;
            poll.f20655a = i2;
            return poll;
        }
    }

    private void a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.f20657a.size()) {
                return;
            }
            this.f20654c.a(this.b.a(0, 0));
            i = i2 + 1;
        }
    }

    private void a(int i, int i2) {
        int min;
        int i3;
        if (i < i2) {
            i3 = Math.max(this.f, i);
            min = i2;
        } else {
            min = Math.min(this.g, i);
            i3 = i2;
        }
        int min2 = Math.min(this.i, min);
        int min3 = Math.min(this.i, Math.max(0, i3));
        if (i >= i2) {
            int i4 = min2;
            while (true) {
                int i5 = i4 - 1;
                if (i5 < min3) {
                    break;
                }
                a((List) this.d.a(i5), i5, false);
                i4 = i5;
            }
        } else {
            int i6 = min3;
            while (true) {
                int i7 = i6;
                if (i7 >= min2) {
                    break;
                }
                a((List) this.d.a(i7), i7, true);
                i6 = i7 + 1;
            }
        }
        this.g = min3;
        this.f = min2;
    }

    private void a(int i, boolean z) {
        if (this.j != z) {
            this.j = z;
            a();
        }
        a(i, (z ? this.f20653a : -this.f20653a) + i);
    }

    private void a(T t, int i, int i2) {
        int[] a2;
        RequestBuilder<?> a3;
        if (t == null || (a2 = this.e.a(t, i, i2)) == null || (a3 = this.d.a((PreloadModelProvider<T>) t)) == null) {
            return;
        }
        a3.a((RequestBuilder<?>) this.b.a(a2[0], a2[1]));
    }

    private void a(List<T> list, int i, boolean z) {
        int size = list.size();
        if (z) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    return;
                }
                a((ListPreloader<T>) list.get(i3), i, i3);
                i2 = i3 + 1;
            }
        } else {
            int i4 = size;
            while (true) {
                int i5 = i4 - 1;
                if (i5 < 0) {
                    return;
                }
                a((ListPreloader<T>) list.get(i5), i, i5);
                i4 = i5;
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.i = i3;
        int i4 = this.h;
        if (i > i4) {
            a(i2 + i, true);
        } else if (i < i4) {
            a(i, false);
        }
        this.h = i;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
