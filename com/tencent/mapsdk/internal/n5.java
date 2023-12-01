package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.internal.b7;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/n5.class */
public class n5 implements BitmapDescriptor.BitmapFormator {
    private final int b;
    private Bitmap h;
    private String i;
    private String j;
    private a k;
    private int m;
    private int n;
    private Bitmap[] o;
    private int p;
    private pc q;
    private final Context r;

    /* renamed from: a  reason: collision with root package name */
    private final String f23967a = "marker_default.png";

    /* renamed from: c  reason: collision with root package name */
    private int f23968c = -1;
    private String d = "";
    private String e = "";
    private String f = "";
    private float g = -1.0f;
    private int l = 1;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/n5$a.class */
    public static class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new C0800a();
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public int f23969c;
        public int d;
        public float e;
        public int f;
        public Typeface g;
        public float h;

        /* renamed from: com.tencent.mapsdk.internal.n5$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/n5$a$a.class */
        public static final class C0800a implements Parcelable.Creator<a> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public a[] newArray(int i) {
                return new a[i];
            }
        }

        public a(Parcel parcel) {
            this.h = 1.0f;
            this.b = parcel.readString();
            this.f23969c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readFloat();
            this.f = parcel.readInt();
            this.h = parcel.readFloat();
        }

        public a(String str, int i, int i2) {
            this.h = 1.0f;
            this.b = str;
            this.f23969c = i;
            this.d = i2;
        }

        public float a() {
            return this.h;
        }

        public void a(float f) {
            this.h = f;
        }

        public void a(int i) {
            this.f = i;
        }

        public void a(Typeface typeface) {
            this.g = typeface;
        }

        public int b() {
            return this.f;
        }

        public void b(float f) {
            this.e = f;
        }

        public float c() {
            return this.e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("FontText{");
            stringBuffer.append("text='");
            stringBuffer.append(this.b);
            stringBuffer.append('\'');
            stringBuffer.append(", textSize=");
            stringBuffer.append(this.f23969c);
            stringBuffer.append(", textColor=");
            stringBuffer.append(this.d);
            stringBuffer.append(", strokeWith=");
            stringBuffer.append(this.e);
            stringBuffer.append(", strokeColor=");
            stringBuffer.append(this.f);
            stringBuffer.append(", typeface=");
            stringBuffer.append(this.g);
            stringBuffer.append(", scale=");
            stringBuffer.append(this.h);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.b);
            parcel.writeInt(this.f23969c);
            parcel.writeInt(this.d);
            parcel.writeFloat(this.e);
            parcel.writeInt(this.f);
            parcel.writeFloat(this.h);
        }
    }

    public n5(Context context, int i) {
        this.r = context;
        this.b = i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Bitmap a(Context context, int i) {
        Bitmap bitmap;
        switch (i) {
            case 1:
                return b7.a(context, this.f23968c);
            case 2:
                Bitmap b = b7.b(context, this.d);
                if (b != null) {
                    return b;
                }
                Bitmap c2 = b7.c(context, this.d);
                bitmap = c2;
                if (c2 != null) {
                    bitmap = c2;
                    if (!this.d.equals(t5.M)) {
                        return b7.a(c2);
                    }
                }
                break;
            case 3:
                return b7.a(context, this.e);
            case 4:
                return b7.a(this.f);
            case 5:
                return b7.c(context, "marker_default.png");
            case 6:
                String a2 = a(this.g);
                if (a2 != null) {
                    return b7.c(context, a2);
                }
                bitmap = null;
                break;
            case 7:
                return this.h;
            case 8:
                if (!TextUtils.isEmpty(this.j)) {
                    return a(this.j);
                }
                bitmap = null;
                break;
            case 9:
                a aVar = this.k;
                if (aVar != null) {
                    return a(context, aVar);
                }
                bitmap = null;
                break;
            case 10:
                Bitmap[] bitmapArr = this.o;
                if (bitmapArr != null) {
                    int length = bitmapArr.length;
                    int i2 = this.p;
                    if (length > i2 && i2 >= 0) {
                        return bitmapArr[i2];
                    }
                }
                bitmap = null;
                break;
            default:
                bitmap = null;
                break;
        }
        return bitmap;
    }

    private Bitmap a(Context context, a aVar) {
        if (this.q == null) {
            this.q = new pc(context);
        }
        pc pcVar = this.q;
        pcVar.setText(aVar.b);
        pcVar.setTextSize(0, aVar.f23969c * aVar.h);
        pcVar.setTextColor(aVar.d);
        pcVar.setStrokeColor(aVar.f);
        pcVar.setStrokeWidth(aVar.e * aVar.h);
        pcVar.setTypeface(aVar.g);
        return b7.a(pcVar);
    }

    private Bitmap a(String str) {
        NetResponse doGet = NetManager.getInstance().builder().url(str).doGet();
        if (doGet == null || !doGet.available()) {
            return null;
        }
        try {
            byte[] bArr = doGet.data;
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        } catch (OutOfMemoryError e) {
            System.gc();
            try {
                byte[] bArr2 = doGet.data;
                return BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length);
            } catch (OutOfMemoryError e2) {
                return null;
            }
        }
    }

    private String a() {
        Bitmap bitmap;
        if (TextUtils.isEmpty(this.i) || this.b == 10) {
            switch (this.b) {
                case 1:
                    this.i = "res_" + this.f23968c;
                    break;
                case 2:
                    this.i = "asset_" + this.d;
                    break;
                case 3:
                    this.i = "file_" + this.e;
                    break;
                case 4:
                    this.i = "path_" + this.f;
                    break;
                case 5:
                    this.i = "asset_marker_default.png";
                    break;
                case 6:
                    String a2 = a(this.g);
                    if (a2 != null) {
                        this.i = "asset_" + a2;
                        break;
                    }
                    break;
                case 7:
                    Bitmap bitmap2 = this.h;
                    if (bitmap2 != null && !bitmap2.isRecycled()) {
                        this.i = "bitmap_" + a(this.h);
                        break;
                    }
                    break;
                case 8:
                    if (!TextUtils.isEmpty(this.j)) {
                        this.i = "url_" + wa.a(this.j);
                        break;
                    }
                    break;
                case 9:
                    if (this.k != null) {
                        this.i = "fonttext_" + wa.a(this.k.toString());
                        break;
                    }
                    break;
                case 10:
                    Bitmap[] bitmapArr = this.o;
                    if (bitmapArr != null) {
                        int length = bitmapArr.length;
                        int i = this.p;
                        if (length > i && i >= 0 && (bitmap = bitmapArr[i]) != null && !bitmap.isRecycled()) {
                            this.i = "bitmaps_" + a(bitmap);
                            break;
                        }
                    }
                    break;
            }
            return this.i;
        }
        return this.i;
    }

    private String a(float f) {
        if (f < 30.0f) {
            return "RED.png";
        }
        if (f < 30.0f || f >= 60.0f) {
            if (f < 60.0f || f >= 120.0f) {
                if (f < 120.0f || f >= 180.0f) {
                    if (f < 180.0f || f >= 210.0f) {
                        if (f < 210.0f || f >= 240.0f) {
                            if (f < 240.0f || f >= 270.0f) {
                                if (f < 270.0f || f >= 300.0f) {
                                    if (f < 300.0f || f >= 330.0f) {
                                        if (f >= 330.0f) {
                                            return "ROSE.png";
                                        }
                                        return null;
                                    }
                                    return "MAGENTAV.png";
                                }
                                return "VIOLET.png";
                            }
                            return "BLUE.png";
                        }
                        return "AZURE.png";
                    }
                    return "CYAN.png";
                }
                return "GREEN.png";
            }
            return "YELLOW.png";
        }
        return "ORANGE.png";
    }

    private String a(Bitmap bitmap) {
        return b7.e(bitmap);
    }

    private String b() {
        if (this.l <= 1) {
            return "";
        }
        return "@" + this.l + "x";
    }

    public BitmapDescriptor.BitmapFormator a(int i) {
        this.f23968c = i;
        return this;
    }

    public BitmapDescriptor.BitmapFormator a(a aVar) {
        this.k = aVar;
        return this;
    }

    public void a(Bitmap[] bitmapArr) {
        this.o = bitmapArr;
        getBitmap(this.r);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator
    public int activeSize() {
        Bitmap[] bitmapArr = this.o;
        return bitmapArr != null ? bitmapArr.length : this.h != null ? 1 : 0;
    }

    public BitmapDescriptor.BitmapFormator b(float f) {
        this.g = f;
        return this;
    }

    public BitmapDescriptor.BitmapFormator b(Bitmap bitmap) {
        this.h = bitmap;
        getBitmap(this.r);
        return this;
    }

    public BitmapDescriptor.BitmapFormator b(String str) {
        this.d = str;
        return this;
    }

    public BitmapDescriptor.BitmapFormator c(String str) {
        this.e = str;
        return this;
    }

    public BitmapDescriptor.BitmapFormator d(String str) {
        this.f = str;
        return this;
    }

    public BitmapDescriptor.BitmapFormator e(String str) {
        this.j = str;
        return this;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator
    public Bitmap getBitmap(Context context) {
        Bitmap bitmap = this.h;
        if (bitmap == null || this.i == null || this.b == 10) {
            Bitmap bitmap2 = null;
            if (context == null) {
                return null;
            }
            b7.a aVar = b7.e;
            if (aVar != null) {
                bitmap2 = aVar.a(getBitmapId());
            }
            Bitmap bitmap3 = bitmap2;
            if (bitmap2 == null) {
                Bitmap a2 = a(context, this.b);
                b7.a aVar2 = b7.e;
                bitmap3 = a2;
                if (aVar2 != null) {
                    bitmap3 = a2;
                    if (a2 != null) {
                        aVar2.a(getBitmapId(), a2);
                        bitmap3 = a2;
                    }
                }
            }
            if (bitmap3 != null) {
                this.m = bitmap3.getWidth();
                this.n = bitmap3.getHeight();
                this.h = bitmap3;
            }
            return bitmap3;
        }
        return bitmap;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator
    public String getBitmapId() {
        return a() + b();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator
    public int getFormateType() {
        return this.b;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator
    public int getHeight() {
        getBitmap(this.r);
        return this.n;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator
    public int getWidth() {
        getBitmap(this.r);
        return this.m;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator
    public int nextActiveIndex() {
        Bitmap[] bitmapArr = this.o;
        if (bitmapArr == null || bitmapArr.length <= 1) {
            this.p = 0;
        } else {
            int i = this.p + 1;
            this.p = i;
            this.p = i % bitmapArr.length;
        }
        return this.p;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator
    public void recycle() {
        na.a("BD", "remove on format recycle");
        if (b7.e.b(getBitmapId())) {
            ha.a(this.o);
            ha.a(this.h);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator
    public void setScale(int i) {
        this.l = i;
    }
}
