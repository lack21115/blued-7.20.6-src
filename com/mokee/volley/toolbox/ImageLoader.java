package com.mokee.volley.toolbox;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.mokee.volley.Request;
import com.mokee.volley.RequestQueue;
import com.mokee.volley.Response;
import com.mokee.volley.VolleyError;
import java.util.HashMap;
import java.util.LinkedList;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/ImageLoader.class */
public class ImageLoader {
    public static boolean h;
    private static final String[] i = null;

    /* renamed from: a  reason: collision with root package name */
    private final RequestQueue f24261a;
    private Runnable d;
    private final ImageCache f;
    private int g = 100;
    private final HashMap<String, c> b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, c> f24262c = new HashMap<>();
    private final Handler e = new Handler(Looper.getMainLooper());

    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/ImageLoader$ImageCache.class */
    public interface ImageCache {
        Bitmap getBitmap(String str);

        void putBitmap(String str, Bitmap bitmap);
    }

    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/ImageLoader$ImageContainer.class */
    public class ImageContainer {

        /* renamed from: a  reason: collision with root package name */
        private Bitmap f24263a;
        private final ImageListener b;

        /* renamed from: c  reason: collision with root package name */
        private final String f24264c;
        private final String d;

        public ImageContainer(Bitmap bitmap, String str, String str2, ImageListener imageListener) {
            this.f24263a = bitmap;
            this.d = str;
            this.f24264c = str2;
            this.b = imageListener;
        }

        public void cancelRequest() {
            if (this.b == null) {
                return;
            }
            c cVar = (c) ImageLoader.this.b.get(this.f24264c);
            if (cVar != null) {
                if (!cVar.removeContainerAndCancelIfNecessary(this)) {
                    return;
                }
                ImageLoader.this.b.remove(this.f24264c);
                if (!ImageLoader.h) {
                    return;
                }
            }
            c cVar2 = (c) ImageLoader.this.f24262c.get(this.f24264c);
            if (cVar2 != null) {
                cVar2.removeContainerAndCancelIfNecessary(this);
                if (cVar2.b.size() == 0) {
                    ImageLoader.this.f24262c.remove(this.f24264c);
                }
            }
        }

        public Bitmap getBitmap() {
            return this.f24263a;
        }

        public String getRequestUrl() {
            return this.d;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/ImageLoader$ImageListener.class */
    public interface ImageListener extends Response.ErrorListener {
        void onResponse(ImageContainer imageContainer, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/ImageLoader$a.class */
    public class a implements Response.Listener<Bitmap> {
        private final /* synthetic */ String val$cacheKey;

        a(String str) {
            this.val$cacheKey = str;
        }

        @Override // com.mokee.volley.Response.Listener
        public void onResponse(Bitmap bitmap) {
            ImageLoader.this.a(this.val$cacheKey, bitmap);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/ImageLoader$b.class */
    class b implements ImageListener {
        private final /* synthetic */ int val$defaultImageResId;
        private final /* synthetic */ int val$errorImageResId;
        private final /* synthetic */ ImageView val$view;

        b(int i, ImageView imageView, int i2) {
            this.val$errorImageResId = i;
            this.val$view = imageView;
            this.val$defaultImageResId = i2;
        }

        @Override // com.mokee.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            if (this.val$errorImageResId != 0) {
                this.val$view.setImageResource(this.val$errorImageResId);
            }
        }

        @Override // com.mokee.volley.toolbox.ImageLoader.ImageListener
        public void onResponse(ImageContainer imageContainer, boolean z) {
            if (imageContainer.getBitmap() != null) {
                this.val$view.setImageBitmap(imageContainer.getBitmap());
                if (!ImageLoader.h) {
                    return;
                }
            }
            if (this.val$defaultImageResId != 0) {
                this.val$view.setImageResource(this.val$defaultImageResId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/ImageLoader$c.class */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        private VolleyError f24265a;
        private final LinkedList<ImageContainer> b = new LinkedList<>();

        /* renamed from: c  reason: collision with root package name */
        private Bitmap f24266c;
        private final Request<?> d;

        public c(Request<?> request, ImageContainer imageContainer) {
            this.d = request;
            this.b.add(imageContainer);
        }

        public void addContainer(ImageContainer imageContainer) {
            this.b.add(imageContainer);
        }

        public VolleyError getError() {
            return this.f24265a;
        }

        public boolean removeContainerAndCancelIfNecessary(ImageContainer imageContainer) {
            this.b.remove(imageContainer);
            if (this.b.size() == 0) {
                this.d.cancel();
                return true;
            }
            return false;
        }

        public void setError(VolleyError volleyError) {
            this.f24265a = volleyError;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/ImageLoader$d.class */
    public class d implements Response.ErrorListener {
        private final /* synthetic */ String val$cacheKey;

        d(String str) {
            this.val$cacheKey = str;
        }

        @Override // com.mokee.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ImageLoader.this.a(this.val$cacheKey, volleyError);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/ImageLoader$e.class */
    public class e implements Runnable {
        e() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x004b, code lost:
            if (r0.getError() != null) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x004e, code lost:
            r0.f24263a = r0.f24266c;
            r0.b.onResponse(r0, false);
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0065, code lost:
            if (r0 == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0068, code lost:
            r0.b.onErrorResponse(r0.getError());
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x007d, code lost:
            if (r0.hasNext() != false) goto L5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0086, code lost:
            if (r0.hasNext() != false) goto L3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0089, code lost:
            r4.this$0.f24262c.clear();
            r4.this$0.d = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x009b, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:3:0x0015, code lost:
            if (r0 != false) goto L3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:4:0x0018, code lost:
            r0 = (com.mokee.volley.toolbox.ImageLoader.c) r0.next();
            r0 = r0.b.iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x002c, code lost:
            if (r0 == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:6:0x002f, code lost:
            r0 = (com.mokee.volley.toolbox.ImageLoader.ImageContainer) r0.next();
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0040, code lost:
            if (r0.b != null) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0044, code lost:
            if (r0 == false) goto L14;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x007d -> B:6:0x002f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0086 -> B:4:0x0018). Please submit an issue!!! */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r4 = this;
                boolean r0 = com.mokee.volley.toolbox.ImageLoader.h
                r5 = r0
                r0 = r4
                com.mokee.volley.toolbox.ImageLoader r0 = com.mokee.volley.toolbox.ImageLoader.this
                java.util.HashMap r0 = com.mokee.volley.toolbox.ImageLoader.access$1(r0)
                java.util.Collection r0 = r0.values()
                java.util.Iterator r0 = r0.iterator()
                r6 = r0
                r0 = r5
                if (r0 == 0) goto L80
            L18:
                r0 = r6
                java.lang.Object r0 = r0.next()
                com.mokee.volley.toolbox.ImageLoader$c r0 = (com.mokee.volley.toolbox.ImageLoader.c) r0
                r7 = r0
                r0 = r7
                java.util.LinkedList r0 = com.mokee.volley.toolbox.ImageLoader.c.access$0(r0)
                java.util.Iterator r0 = r0.iterator()
                r8 = r0
                r0 = r5
                if (r0 == 0) goto L76
            L2f:
                r0 = r8
                java.lang.Object r0 = r0.next()
                com.mokee.volley.toolbox.ImageLoader$ImageContainer r0 = (com.mokee.volley.toolbox.ImageLoader.ImageContainer) r0
                r9 = r0
                r0 = r9
                com.mokee.volley.toolbox.ImageLoader$ImageListener r0 = com.mokee.volley.toolbox.ImageLoader.ImageContainer.access$0(r0)
                if (r0 != 0) goto L47
                r0 = r5
                if (r0 == 0) goto L76
            L47:
                r0 = r7
                com.mokee.volley.VolleyError r0 = r0.getError()
                if (r0 != 0) goto L68
                r0 = r9
                r1 = r7
                android.graphics.Bitmap r1 = com.mokee.volley.toolbox.ImageLoader.c.access$2(r1)
                com.mokee.volley.toolbox.ImageLoader.ImageContainer.access$1(r0, r1)
                r0 = r9
                com.mokee.volley.toolbox.ImageLoader$ImageListener r0 = com.mokee.volley.toolbox.ImageLoader.ImageContainer.access$0(r0)
                r1 = r9
                r2 = 0
                r0.onResponse(r1, r2)
                r0 = r5
                if (r0 == 0) goto L76
            L68:
                r0 = r9
                com.mokee.volley.toolbox.ImageLoader$ImageListener r0 = com.mokee.volley.toolbox.ImageLoader.ImageContainer.access$0(r0)
                r1 = r7
                com.mokee.volley.VolleyError r1 = r1.getError()
                r0.onErrorResponse(r1)
            L76:
                r0 = r8
                boolean r0 = r0.hasNext()
                if (r0 != 0) goto L2f
            L80:
                r0 = r6
                boolean r0 = r0.hasNext()
                if (r0 != 0) goto L18
                r0 = r4
                com.mokee.volley.toolbox.ImageLoader r0 = com.mokee.volley.toolbox.ImageLoader.this
                java.util.HashMap r0 = com.mokee.volley.toolbox.ImageLoader.access$1(r0)
                r0.clear()
                r0 = r4
                com.mokee.volley.toolbox.ImageLoader r0 = com.mokee.volley.toolbox.ImageLoader.this
                r1 = 0
                com.mokee.volley.toolbox.ImageLoader.access$4(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.toolbox.ImageLoader.e.run():void");
        }
    }

    static {
        String[] strArr = new String[3];
        throw new VerifyError("bad dex opcode");
    }

    public ImageLoader(RequestQueue requestQueue, ImageCache imageCache) {
        this.f24261a = requestQueue;
        this.f = imageCache;
    }

    private static String a(String str, int i2, int i3) {
        return new StringBuilder(str.length() + 12).append(i[1]).append(i2).append(i[2]).append(i3).append(str).toString();
    }

    private void a() {
        try {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new IllegalStateException(i[0]);
            }
        } catch (IllegalStateException e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Bitmap bitmap) {
        this.f.putBitmap(str, bitmap);
        c remove = this.b.remove(str);
        if (remove != null) {
            try {
                remove.f24266c = bitmap;
                a(str, remove);
            } catch (IllegalStateException e2) {
                throw e2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, VolleyError volleyError) {
        c remove = this.b.remove(str);
        if (remove != null) {
            try {
                remove.setError(volleyError);
                a(str, remove);
            } catch (IllegalStateException e2) {
                throw e2;
            }
        }
    }

    private void a(String str, c cVar) {
        try {
            this.f24262c.put(str, cVar);
            if (this.d == null) {
                this.d = new e();
                this.e.postDelayed(this.d, this.g);
            }
        } catch (IllegalStateException e2) {
            throw e2;
        }
    }

    public static ImageListener getImageListener(ImageView imageView, int i2, int i3) {
        return new b(i3, imageView, i2);
    }

    public ImageContainer get(String str, ImageListener imageListener) {
        return get(str, imageListener, 0, 0);
    }

    public ImageContainer get(String str, ImageListener imageListener, int i2, int i3) {
        a();
        String a2 = a(str, i2, i3);
        Bitmap bitmap = this.f.getBitmap(a2);
        if (bitmap != null) {
            ImageContainer imageContainer = new ImageContainer(bitmap, str, null, null);
            imageListener.onResponse(imageContainer, true);
            return imageContainer;
        }
        ImageContainer imageContainer2 = new ImageContainer(null, str, a2, imageListener);
        imageListener.onResponse(imageContainer2, true);
        c cVar = this.b.get(a2);
        if (cVar != null) {
            try {
                cVar.addContainer(imageContainer2);
                return imageContainer2;
            } catch (IllegalStateException e2) {
                throw e2;
            }
        }
        ImageRequest imageRequest = new ImageRequest(str, new a(a2), i2, i3, Bitmap.Config.RGB_565, new d(a2));
        this.f24261a.add(imageRequest);
        this.b.put(a2, new c(imageRequest, imageContainer2));
        return imageContainer2;
    }

    public boolean isCached(String str, int i2, int i3) {
        a();
        try {
            return this.f.getBitmap(a(str, i2, i3)) != null;
        } catch (IllegalStateException e2) {
            throw e2;
        }
    }

    public void setBatchedResponseDelay(int i2) {
        this.g = i2;
    }
}
