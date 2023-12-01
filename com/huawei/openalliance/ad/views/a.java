package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.download.app.k;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/a.class */
public class a {
    protected C0272a V = new C0272a();
    protected C0272a I = new C0272a();
    protected C0272a Z = new C0272a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.openalliance.ad.views.a$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/a$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:37:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0051 -> B:33:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:31:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:27:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:35:0x0040). Please submit an issue!!! */
        static {
            int[] iArr = new int[k.values().length];
            Code = iArr;
            try {
                iArr[k.PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Code[k.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Code[k.INSTALLING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                Code[k.INSTALLED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                Code[k.DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                Code[k.INSTALL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/a$a.class */
    public static class C0272a {
        protected Drawable Code;
        protected int I = 12;
        protected int V;
        protected Typeface Z;

        public void Code(int i) {
            this.V = i;
        }

        public void Code(Typeface typeface) {
            this.Z = typeface;
        }

        public void Code(Drawable drawable) {
            this.Code = drawable;
        }

        public void V(int i) {
            this.I = i;
        }
    }

    public a(Context context) {
        this.V.Code = context.getResources().getDrawable(R.drawable.hiad_app_down_btn_normal);
        this.V.V = context.getResources().getColor(R.color.hiad_down_normal_text);
        this.I.Code(Code(context, R.drawable.hiad_app_down_btn_processing));
        this.I.Code(context.getResources().getColor(R.color.hiad_app_down_processing_text));
        this.Z.Code(context.getResources().getDrawable(R.drawable.hiad_app_down_btn_installing));
        this.Z.Code(context.getResources().getColor(R.color.hiad_app_down_installing_text));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable Code(Context context, int i) {
        Drawable drawable = context.getResources().getDrawable(i);
        if (Build.VERSION.SDK_INT >= 23 && TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            drawable.setLayoutDirection(1);
        }
        return drawable;
    }

    public C0272a Code() {
        return this.V;
    }

    public C0272a Code(Context context, k kVar) {
        int i = AnonymousClass1.Code[kVar.ordinal()];
        return (i == 1 || i == 2) ? this.I : i != 3 ? Code() : this.Z;
    }

    public C0272a V() {
        return this.I;
    }
}
