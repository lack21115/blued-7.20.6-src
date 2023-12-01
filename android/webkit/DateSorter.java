package android.webkit;

import android.content.Context;
import android.content.res.Resources;
import com.android.internal.R;
import java.util.Calendar;
import java.util.Locale;
import libcore.icu.LocaleData;

/* loaded from: source-4181928-dex2jar.jar:android/webkit/DateSorter.class */
public class DateSorter {
    public static final int DAY_COUNT = 5;
    private static final String LOGTAG = "webkit";
    private static final int NUM_DAYS_AGO = 7;
    private long[] mBins = new long[4];
    private String[] mLabels = new String[5];

    public DateSorter(Context context) {
        Resources resources = context.getResources();
        Calendar calendar = Calendar.getInstance();
        beginningOfDay(calendar);
        this.mBins[0] = calendar.getTimeInMillis();
        calendar.add(6, -1);
        this.mBins[1] = calendar.getTimeInMillis();
        calendar.add(6, -6);
        this.mBins[2] = calendar.getTimeInMillis();
        calendar.add(6, 7);
        calendar.add(2, -1);
        this.mBins[3] = calendar.getTimeInMillis();
        Locale locale = resources.getConfiguration().locale;
        LocaleData localeData = LocaleData.get(locale == null ? Locale.getDefault() : locale);
        this.mLabels[0] = localeData.today;
        this.mLabels[1] = localeData.yesterday;
        this.mLabels[2] = String.format(resources.getQuantityString(R.plurals.last_num_days, 7), 7);
        this.mLabels[3] = context.getString(R.string.last_month);
        this.mLabels[4] = context.getString(R.string.older);
    }

    private void beginningOfDay(Calendar calendar) {
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r4 > 4) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long getBoundary(int r4) {
        /*
            r3 = this;
            r0 = r4
            if (r0 < 0) goto Lb
            r0 = r4
            r5 = r0
            r0 = r4
            r1 = 4
            if (r0 <= r1) goto Ld
        Lb:
            r0 = 0
            r5 = r0
        Ld:
            r0 = r5
            r1 = 4
            if (r0 != r1) goto L16
            r0 = -9223372036854775808
            return r0
        L16:
            r0 = r3
            long[] r0 = r0.mBins
            r1 = r5
            r0 = r0[r1]
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.webkit.DateSorter.getBoundary(int):long");
    }

    public int getIndex(long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 4) {
                return 4;
            }
            if (j > this.mBins[i2]) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public String getLabel(int i) {
        return (i < 0 || i >= 5) ? "" : this.mLabels[i];
    }
}
