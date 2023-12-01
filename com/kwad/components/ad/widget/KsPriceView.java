package com.kwad.components.ad.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.kwad.components.core.widget.d;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.b;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/widget/KsPriceView.class */
public class KsPriceView extends TextView implements d {
    private static String GW = "¥%s 到手约 ¥%s";
    private static String GX = "¥%s  ¥%s";
    private static String GY = "¥%s";
    private a GV;
    private String GZ;
    private String Ha;
    private boolean Hb;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/widget/KsPriceView$a.class */
    public static final class a {
        private int Hc;
        private int Hd;
        private int He;
        private int Hf;
        private int Hg;
        private int Hh;

        public final a aj(int i) {
            this.Hd = i;
            return this;
        }

        public final a ak(int i) {
            this.Hg = i;
            return this;
        }

        public final a al(int i) {
            this.Hh = i;
            return this;
        }

        public final int lM() {
            return this.He;
        }

        public final int lN() {
            return this.Hg;
        }

        public final int lO() {
            return this.Hf;
        }

        public final int lP() {
            return this.Hh;
        }

        public final int lQ() {
            return this.Hc;
        }

        public final int lR() {
            return this.Hd;
        }
    }

    public KsPriceView(Context context) {
        super(context);
        this.GV = new a();
        Q(context);
    }

    public KsPriceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GV = new a();
        Q(context);
    }

    public KsPriceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.GV = new a();
        Q(context);
    }

    public KsPriceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.GV = new a();
        Q(context);
    }

    private void Q(Context context) {
        setMaxLines(1);
        this.GV.He = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.GV.Hf = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_price_size);
        this.GV.Hg = context.getResources().getColor(R.color.ksad_reward_original_price);
        this.GV.Hh = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_original_price_size);
        this.GV.Hc = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.GV.Hd = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_price_size);
    }

    private static SpannableString a(String str, String str2, boolean z, a aVar) {
        String format;
        if (str2 == null) {
            format = String.format(GY, str);
        } else {
            format = String.format(z ? GX : GW, str, str2);
        }
        SpannableString spannableString = new SpannableString(format);
        if (format.startsWith("¥")) {
            spannableString.setSpan(new ForegroundColorSpan(aVar.lQ()), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.lR()), 0, 1, 17);
        }
        int indexOf = format.indexOf(str);
        if (indexOf < 0) {
            return null;
        }
        int length = str.length() + indexOf;
        spannableString.setSpan(new ForegroundColorSpan(aVar.lM()), indexOf, length, 18);
        spannableString.setSpan(new AbsoluteSizeSpan(aVar.lO()), indexOf, length, 18);
        if (str2 != null) {
            int lastIndexOf = format.lastIndexOf(str2) - 1;
            int length2 = str2.length() + 1 + lastIndexOf;
            spannableString.setSpan(new ForegroundColorSpan(aVar.lN()), lastIndexOf, length2, 18);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.lP()), lastIndexOf, length2, 18);
            spannableString.setSpan(new StrikethroughSpan(), lastIndexOf, length2, 18);
        }
        return spannableString;
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        this.GV.He = eVar.rB();
        d(this.GZ, this.Ha, this.Hb);
    }

    public final void d(String str, String str2, boolean z) {
        SpannableString spannableString;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        this.GZ = str;
        this.Ha = str2;
        this.Hb = z;
        if (TextUtils.isEmpty(str2)) {
            this.Ha = null;
        }
        String str3 = str;
        if (str != null) {
            str3 = str;
            if (str.startsWith("¥")) {
                str3 = str.replaceFirst("¥", "");
            }
        }
        setTextColor(this.GV.lM());
        try {
            spannableString = a(str3, this.Ha, z, this.GV);
        } catch (Exception e) {
            b.printStackTraceOnly(e);
            spannableString = null;
        }
        if (spannableString != null) {
            setText(spannableString);
        }
    }

    public final void f(String str, String str2) {
        d(str, str2, false);
    }

    public a getConfig() {
        return this.GV;
    }
}
