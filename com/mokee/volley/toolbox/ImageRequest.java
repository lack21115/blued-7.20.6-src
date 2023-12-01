package com.mokee.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.mokee.volley.DefaultRetryPolicy;
import com.mokee.volley.NetworkResponse;
import com.mokee.volley.ParseError;
import com.mokee.volley.Request;
import com.mokee.volley.Response;
import com.mokee.volley.VolleyLog;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/ImageRequest.class */
public class ImageRequest extends Request<Bitmap> {
    private static final Object p;
    private static final String u;
    private final int q;
    private final int r;
    private final Bitmap.Config s;
    private final Response.Listener<Bitmap> t;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x005c, code lost:
        r0 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0061, code lost:
        r7 = r6;
        r11 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0067, code lost:
        r10 = r11;
        r6 = r7;
        r5 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0071, code lost:
        if (r7 > r8) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0074, code lost:
        com.mokee.volley.toolbox.ImageRequest.u = new java.lang.String(r11).intern();
        com.mokee.volley.toolbox.ImageRequest.p = new java.lang.Object();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x008d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x008e, code lost:
        r5 = 'M';
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0094, code lost:
        r5 = 22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x009a, code lost:
        r5 = 'n';
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a0, code lost:
        r5 = '\f';
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0017, code lost:
        if (r6 <= 1) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001a, code lost:
        r8 = r5;
        r0 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001e, code lost:
        r7 = r0;
        r0 = r10;
        r0 = r0[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:
        switch((r8 % 5)) {
            case 0: goto L12;
            case 1: goto L13;
            case 2: goto L14;
            case 3: goto L15;
            default: goto L6;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0048, code lost:
        r5 = 'O';
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x004b, code lost:
        r0[r7] = (char) (r5 ^ r0);
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0059, code lost:
        if (r6 != 0) goto L10;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0071 -> B:4:0x001a). Please submit an issue!!! */
    static {
        /*
            java.lang.String r0 = "\u000ew\u001bk'96!C\u0002mp\u0001~ohrNn69sNe\",q\u000b o8d\u00021j>"
            char[] r0 = r0.toCharArray()
            r10 = r0
            r0 = r10
            int r0 = r0.length
            r6 = r0
            r0 = 0
            r8 = r0
            r0 = 0
            r5 = r0
            r0 = r10
            r11 = r0
            r0 = r6
            r7 = r0
            r0 = r6
            r1 = 1
            if (r0 > r1) goto L67
        L1a:
            r0 = r5
            r8 = r0
            r0 = r5
            r7 = r0
        L1e:
            r0 = r10
            r11 = r0
            r0 = r11
            r1 = r7
            char r0 = r0[r1]
            r9 = r0
            r0 = r8
            r1 = 5
            int r0 = r0 % r1
            switch(r0) {
                case 0: goto L8e;
                case 1: goto L94;
                case 2: goto L9a;
                case 3: goto La0;
                default: goto L48;
            }
        L48:
            r0 = 79
            r5 = r0
        L4b:
            r0 = r11
            r1 = r7
            r2 = r5
            r3 = r9
            r2 = r2 ^ r3
            char r2 = (char) r2
            r0[r1] = r2
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            r0 = r6
            if (r0 != 0) goto L61
            r0 = r6
            r7 = r0
            goto L1e
        L61:
            r0 = r6
            r7 = r0
            r0 = r10
            r11 = r0
        L67:
            r0 = r11
            r10 = r0
            r0 = r7
            r6 = r0
            r0 = r8
            r5 = r0
            r0 = r7
            r1 = r8
            if (r0 > r1) goto L1a
            java.lang.String r0 = new java.lang.String
            r1 = r0
            r2 = r11
            r1.<init>(r2)
            java.lang.String r0 = r0.intern()
            com.mokee.volley.toolbox.ImageRequest.u = r0
            java.lang.Object r0 = new java.lang.Object
            r1 = r0
            r1.<init>()
            com.mokee.volley.toolbox.ImageRequest.p = r0
            return
        L8e:
            r0 = 77
            r5 = r0
            goto L4b
        L94:
            r0 = 22
            r5 = r0
            goto L4b
        L9a:
            r0 = 110(0x6e, float:1.54E-43)
            r5 = r0
            goto L4b
        La0:
            r0 = 12
            r5 = r0
            goto L4b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.toolbox.ImageRequest.m8073clinit():void");
    }

    public ImageRequest(String str, Response.Listener<Bitmap> listener, int i, int i2, Bitmap.Config config, Response.ErrorListener errorListener) {
        super(0, str, errorListener);
        setRetryPolicy(new DefaultRetryPolicy(1000, 2, 2.0f));
        this.t = listener;
        this.s = config;
        this.q = i;
        this.r = i2;
    }

    static int a(int i, int i2, int i3, int i4) {
        boolean z = ImageLoader.h;
        double min = Math.min(i / i3, i2 / i4);
        float f = 1.0f;
        if (z) {
            f = 1.0f * 2.0f;
        }
        while (true) {
            float f2 = f;
            if (f * 2.0f > min) {
                return (int) f;
            }
            f = f2 * 2.0f;
        }
    }

    private Response<Bitmap> a(NetworkResponse networkResponse) {
        Bitmap decodeByteArray;
        byte[] bArr = networkResponse.data;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.q == 0 && this.r == 0) {
            options.inPreferredConfig = this.s;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int b = b(this.q, this.r, i, i2);
            int b2 = b(this.r, this.q, i2, i);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i, i2, b, b2);
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray != null && (decodeByteArray.getWidth() > b || decodeByteArray.getHeight() > b2)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, b, b2, true);
                decodeByteArray.recycle();
                decodeByteArray = createScaledBitmap;
            }
        }
        return decodeByteArray == null ? Response.error(new ParseError(networkResponse)) : Response.success(decodeByteArray, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    private static int b(int i, int i2, int i3, int i4) {
        int i5;
        if (i == 0 && i2 == 0) {
            i5 = i3;
        } else if (i == 0) {
            return (int) ((i2 / i4) * i3);
        } else {
            i5 = i;
            if (i2 != 0) {
                double d = i4 / i3;
                i5 = i;
                if (i * d > i2) {
                    return (int) (i2 / d);
                }
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mokee.volley.Request
    public void deliverResponse(Bitmap bitmap) {
        this.t.onResponse(bitmap);
    }

    @Override // com.mokee.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mokee.volley.Request
    public Response<Bitmap> parseNetworkResponse(NetworkResponse networkResponse) {
        Response<Bitmap> a2;
        synchronized (p) {
            try {
                a2 = a(networkResponse);
            } catch (OutOfMemoryError e) {
                VolleyLog.e(u, Integer.valueOf(networkResponse.data.length), getUrl());
                return Response.error(new ParseError(e));
            }
        }
        return a2;
    }
}
