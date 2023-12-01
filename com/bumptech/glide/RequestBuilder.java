package com.bumptech.glide;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.signature.AndroidResourceSignature;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/RequestBuilder.class */
public class RequestBuilder<TranscodeType> extends BaseRequestOptions<RequestBuilder<TranscodeType>> implements ModelTypes<RequestBuilder<TranscodeType>>, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    protected static final RequestOptions f7058a = new RequestOptions().b(DiskCacheStrategy.f7157c).b(Priority.LOW).d(true);
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final RequestManager f7059c;
    private final Class<TranscodeType> d;
    private final Glide e;
    private final GlideContext f;
    private TransitionOptions<?, ? super TranscodeType> g;
    private Object h;
    private List<RequestListener<TranscodeType>> i;
    private RequestBuilder<TranscodeType> j;
    private RequestBuilder<TranscodeType> k;
    private Float l;
    private boolean m = true;
    private boolean n;
    private boolean o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bumptech.glide.RequestBuilder$1  reason: invalid class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/RequestBuilder$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7060a;
        static final /* synthetic */ int[] b;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x009a -> B:56:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x009e -> B:74:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00a2 -> B:68:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00a6 -> B:10:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00aa -> B:54:0x0049). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00ae -> B:72:0x0054). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00b2 -> B:66:0x005f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00b6 -> B:58:0x006a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00ba -> B:52:0x0075). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00be -> B:70:0x0081). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00c2 -> B:64:0x008d). Please submit an issue!!! */
        static {
            int[] iArr = new int[Priority.values().length];
            b = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f7060a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f7060a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f7060a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f7060a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f7060a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f7060a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f7060a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f7060a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    public RequestBuilder(Glide glide, RequestManager requestManager, Class<TranscodeType> cls, Context context) {
        this.e = glide;
        this.f7059c = requestManager;
        this.d = cls;
        this.b = context;
        this.g = requestManager.c(cls);
        this.f = glide.d();
        a(requestManager.k());
        b(requestManager.l());
    }

    private Priority a(Priority priority) {
        int i = AnonymousClass1.b[priority.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3 || i == 4) {
                    return Priority.IMMEDIATE;
                }
                throw new IllegalArgumentException("unknown priority: " + F());
            }
            return Priority.HIGH;
        }
        return Priority.NORMAL;
    }

    private RequestBuilder<TranscodeType> a(Object obj) {
        this.h = obj;
        this.n = true;
        return this;
    }

    private Request a(Object obj, Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i, int i2, Executor executor) {
        Context context = this.b;
        GlideContext glideContext = this.f;
        return SingleRequest.a(context, glideContext, obj, this.h, this.d, baseRequestOptions, i, i2, priority, target, requestListener, this.i, requestCoordinator, glideContext.c(), transitionOptions.b(), executor);
    }

    private Request a(Object obj, Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i, int i2, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        ErrorRequestCoordinator errorRequestCoordinator;
        ErrorRequestCoordinator errorRequestCoordinator2;
        if (this.k != null) {
            errorRequestCoordinator = new ErrorRequestCoordinator(obj, requestCoordinator);
            errorRequestCoordinator2 = errorRequestCoordinator;
        } else {
            errorRequestCoordinator = requestCoordinator;
            errorRequestCoordinator2 = null;
        }
        Request b = b(obj, target, requestListener, errorRequestCoordinator, transitionOptions, priority, i, i2, baseRequestOptions, executor);
        if (errorRequestCoordinator2 == null) {
            return b;
        }
        int G = this.k.G();
        int I = this.k.I();
        int i3 = G;
        int i4 = I;
        if (Util.a(i, i2)) {
            i3 = G;
            i4 = I;
            if (!this.k.H()) {
                i3 = baseRequestOptions.G();
                i4 = baseRequestOptions.I();
            }
        }
        RequestBuilder<TranscodeType> requestBuilder = this.k;
        errorRequestCoordinator2.a(b, requestBuilder.a(obj, target, requestListener, errorRequestCoordinator2, requestBuilder.g, requestBuilder.F(), i3, i4, this.k, executor));
        return errorRequestCoordinator2;
    }

    private <Y extends Target<TranscodeType>> Y a(Y y, RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        Preconditions.a(y);
        if (this.n) {
            Request b = b(y, requestListener, baseRequestOptions, executor);
            Request request = y.getRequest();
            if (b.a(request) && !a(baseRequestOptions, request)) {
                if (!((Request) Preconditions.a(request)).d()) {
                    request.a();
                }
                return y;
            }
            this.f7059c.a((Target<?>) y);
            y.setRequest(b);
            this.f7059c.a(y, b);
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    private void a(List<RequestListener<Object>> list) {
        for (RequestListener<Object> requestListener : list) {
            c(requestListener);
        }
    }

    private boolean a(BaseRequestOptions<?> baseRequestOptions, Request request) {
        return !baseRequestOptions.C() && request.e();
    }

    private Request b(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        return a(new Object(), target, requestListener, (RequestCoordinator) null, this.g, baseRequestOptions.F(), baseRequestOptions.G(), baseRequestOptions.I(), baseRequestOptions, executor);
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.bumptech.glide.request.BaseRequestOptions] */
    private Request b(Object obj, Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i, int i2, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        RequestBuilder<TranscodeType> requestBuilder = this.j;
        if (requestBuilder == null) {
            if (this.l != null) {
                ThumbnailRequestCoordinator thumbnailRequestCoordinator = new ThumbnailRequestCoordinator(obj, requestCoordinator);
                thumbnailRequestCoordinator.a(a(obj, target, requestListener, baseRequestOptions, thumbnailRequestCoordinator, transitionOptions, priority, i, i2, executor), a(obj, target, requestListener, baseRequestOptions.clone().b(this.l.floatValue()), thumbnailRequestCoordinator, transitionOptions, a(priority), i, i2, executor));
                return thumbnailRequestCoordinator;
            }
            return a(obj, target, requestListener, baseRequestOptions, requestCoordinator, transitionOptions, priority, i, i2, executor);
        } else if (this.o) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else {
            TransitionOptions<?, ? super TranscodeType> transitionOptions2 = requestBuilder.g;
            if (requestBuilder.m) {
                transitionOptions2 = transitionOptions;
            }
            Priority F = this.j.E() ? this.j.F() : a(priority);
            int G = this.j.G();
            int I = this.j.I();
            int i3 = G;
            int i4 = I;
            if (Util.a(i, i2)) {
                i3 = G;
                i4 = I;
                if (!this.j.H()) {
                    i3 = baseRequestOptions.G();
                    i4 = baseRequestOptions.I();
                }
            }
            ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = new ThumbnailRequestCoordinator(obj, requestCoordinator);
            Request a2 = a(obj, target, requestListener, baseRequestOptions, thumbnailRequestCoordinator2, transitionOptions, priority, i, i2, executor);
            this.o = true;
            RequestBuilder<TranscodeType> requestBuilder2 = this.j;
            Request a3 = requestBuilder2.a(obj, target, requestListener, thumbnailRequestCoordinator2, transitionOptions2, F, i3, i4, requestBuilder2, executor);
            this.o = false;
            thumbnailRequestCoordinator2.a(a2, a3);
            return thumbnailRequestCoordinator2;
        }
    }

    public <Y extends Target<TranscodeType>> Y a(Y y) {
        return (Y) a((RequestBuilder<TranscodeType>) y, (RequestListener) null, Executors.a());
    }

    <Y extends Target<TranscodeType>> Y a(Y y, RequestListener<TranscodeType> requestListener, Executor executor) {
        return (Y) a(y, requestListener, this, executor);
    }

    public ViewTarget<ImageView, TranscodeType> a(ImageView imageView) {
        RequestBuilder<TranscodeType> requestBuilder;
        Util.a();
        Preconditions.a(imageView);
        if (!p() && o() && imageView.getScaleType() != null) {
            switch (AnonymousClass1.f7060a[imageView.getScaleType().ordinal()]) {
                case 1:
                    requestBuilder = clone().m();
                    break;
                case 2:
                    requestBuilder = clone().j();
                    break;
                case 3:
                case 4:
                case 5:
                    requestBuilder = clone().k();
                    break;
                case 6:
                    requestBuilder = clone().j();
                    break;
            }
            return (ViewTarget) a(this.f.a(imageView, this.d), null, requestBuilder, Executors.a());
        }
        requestBuilder = this;
        return (ViewTarget) a(this.f.a(imageView, this.d), null, requestBuilder, Executors.a());
    }

    public RequestBuilder<TranscodeType> b(Uri uri) {
        return a(uri);
    }

    public RequestBuilder<TranscodeType> b(RequestBuilder<TranscodeType> requestBuilder) {
        this.j = requestBuilder;
        return this;
    }

    public RequestBuilder<TranscodeType> b(TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        this.g = (TransitionOptions) Preconditions.a(transitionOptions);
        this.m = false;
        return this;
    }

    public RequestBuilder<TranscodeType> b(File file) {
        return a(file);
    }

    public RequestBuilder<TranscodeType> b(Integer num) {
        return a(num).b(RequestOptions.c(AndroidResourceSignature.a(this.b)));
    }

    public RequestBuilder<TranscodeType> b(Object obj) {
        return a(obj);
    }

    public RequestBuilder<TranscodeType> b(String str) {
        return a(str);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: c */
    public RequestBuilder<TranscodeType> b(BaseRequestOptions<?> baseRequestOptions) {
        Preconditions.a(baseRequestOptions);
        return (RequestBuilder) super.b(baseRequestOptions);
    }

    public RequestBuilder<TranscodeType> c(RequestListener<TranscodeType> requestListener) {
        if (requestListener != null) {
            if (this.i == null) {
                this.i = new ArrayList();
            }
            this.i.add(requestListener);
        }
        return this;
    }

    public FutureTarget<TranscodeType> c(int i, int i2) {
        RequestFutureTarget requestFutureTarget = new RequestFutureTarget(i, i2);
        return (FutureTarget) a((RequestBuilder<TranscodeType>) requestFutureTarget, requestFutureTarget, Executors.b());
    }

    public RequestBuilder<TranscodeType> d(RequestListener<TranscodeType> requestListener) {
        this.i = null;
        return c(requestListener);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: f */
    public RequestBuilder<TranscodeType> n() {
        RequestBuilder<TranscodeType> requestBuilder = (RequestBuilder) super.clone();
        requestBuilder.g = (TransitionOptions<?, ? super TranscodeType>) requestBuilder.g.clone();
        return requestBuilder;
    }

    public FutureTarget<TranscodeType> g() {
        return c(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
}
