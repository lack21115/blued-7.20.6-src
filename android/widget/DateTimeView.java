package android.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.text.format.Time;
import android.util.AttributeSet;
import android.view.RemotableViewMethod;
import android.widget.RemoteViews;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RemoteViews.RemoteView
/* loaded from: source-4181928-dex2jar.jar:android/widget/DateTimeView.class */
public class DateTimeView extends TextView {
    private static final int SHOW_MONTH_DAY_YEAR = 1;
    private static final int SHOW_TIME = 0;
    private static final String TAG = "DateTimeView";
    private static final long TWELVE_HOURS_IN_MINUTES = 720;
    private static final long TWENTY_FOUR_HOURS_IN_MILLIS = 86400000;
    private static final ThreadLocal<ReceiverInfo> sReceiverInfo = new ThreadLocal<>();
    int mLastDisplay;
    DateFormat mLastFormat;
    Date mTime;
    long mTimeMillis;
    private long mUpdateTimeMillis;

    /* loaded from: source-4181928-dex2jar.jar:android/widget/DateTimeView$ReceiverInfo.class */
    private static class ReceiverInfo {
        private final ArrayList<DateTimeView> mAttachedViews;
        private final ContentObserver mObserver;
        private final BroadcastReceiver mReceiver;

        private ReceiverInfo() {
            this.mAttachedViews = new ArrayList<>();
            this.mReceiver = new BroadcastReceiver() { // from class: android.widget.DateTimeView.ReceiverInfo.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (!Intent.ACTION_TIME_TICK.equals(intent.getAction()) || System.currentTimeMillis() >= ReceiverInfo.this.getSoonestUpdateTime()) {
                        ReceiverInfo.this.updateAll();
                    }
                }
            };
            this.mObserver = new ContentObserver(new Handler()) { // from class: android.widget.DateTimeView.ReceiverInfo.2
                @Override // android.database.ContentObserver
                public void onChange(boolean z) {
                    ReceiverInfo.this.updateAll();
                }
            };
        }

        public void addView(DateTimeView dateTimeView) {
            boolean isEmpty = this.mAttachedViews.isEmpty();
            this.mAttachedViews.add(dateTimeView);
            if (isEmpty) {
                register(dateTimeView.getContext().getApplicationContext());
            }
        }

        long getSoonestUpdateTime() {
            long j = Long.MAX_VALUE;
            int size = this.mAttachedViews.size();
            int i = 0;
            while (i < size) {
                long j2 = this.mAttachedViews.get(i).mUpdateTimeMillis;
                long j3 = j;
                if (j2 < j) {
                    j3 = j2;
                }
                i++;
                j = j3;
            }
            return j;
        }

        void register(Context context) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(Intent.ACTION_TIME_TICK);
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction(Intent.ACTION_CONFIGURATION_CHANGED);
            intentFilter.addAction(Intent.ACTION_TIMEZONE_CHANGED);
            context.registerReceiver(this.mReceiver, intentFilter);
            context.getContentResolver().registerContentObserver(Settings.System.getUriFor(Settings.System.DATE_FORMAT), true, this.mObserver);
        }

        public void removeView(DateTimeView dateTimeView) {
            this.mAttachedViews.remove(dateTimeView);
            if (this.mAttachedViews.isEmpty()) {
                unregister(dateTimeView.getContext().getApplicationContext());
            }
        }

        void unregister(Context context) {
            context.unregisterReceiver(this.mReceiver);
            context.getContentResolver().unregisterContentObserver(this.mObserver);
        }

        void updateAll() {
            int size = this.mAttachedViews.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                this.mAttachedViews.get(i2).clearFormatAndUpdate();
                i = i2 + 1;
            }
        }
    }

    public DateTimeView(Context context) {
        super(context);
        this.mLastDisplay = -1;
    }

    public DateTimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastDisplay = -1;
    }

    private DateFormat getDateFormat() {
        String string = Settings.System.getString(getContext().getContentResolver(), Settings.System.DATE_FORMAT);
        if (string == null || "".equals(string)) {
            return DateFormat.getDateInstance(3);
        }
        try {
            return new SimpleDateFormat(string);
        } catch (IllegalArgumentException e) {
            return DateFormat.getDateInstance(3);
        }
    }

    private DateFormat getTimeFormat() {
        return android.text.format.DateFormat.getTimeFormat(getContext());
    }

    void clearFormatAndUpdate() {
        this.mLastFormat = null;
        update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ReceiverInfo receiverInfo = sReceiverInfo.get();
        ReceiverInfo receiverInfo2 = receiverInfo;
        if (receiverInfo == null) {
            receiverInfo2 = new ReceiverInfo();
            sReceiverInfo.set(receiverInfo2);
        }
        receiverInfo2.addView(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ReceiverInfo receiverInfo = sReceiverInfo.get();
        if (receiverInfo != null) {
            receiverInfo.removeView(this);
        }
    }

    @RemotableViewMethod
    public void setTime(long j) {
        Time time = new Time();
        time.set(j);
        time.second = 0;
        this.mTimeMillis = time.toMillis(false);
        this.mTime = new Date(time.year - 1900, time.month, time.monthDay, time.hour, time.minute, 0);
        update();
    }

    void update() {
        DateFormat dateFormat;
        if (this.mTime == null) {
            return;
        }
        System.nanoTime();
        Date date = this.mTime;
        Time time = new Time();
        time.set(this.mTimeMillis);
        time.second = 0;
        time.hour -= 12;
        long millis = time.toMillis(false);
        time.hour += 12;
        long millis2 = time.toMillis(false);
        time.hour = 0;
        time.minute = 0;
        long millis3 = time.toMillis(false);
        time.monthDay++;
        long millis4 = time.toMillis(false);
        time.set(System.currentTimeMillis());
        time.second = 0;
        long normalize = time.normalize(false);
        int i = ((normalize < millis3 || normalize >= millis4) && (normalize < millis || normalize >= millis2)) ? 1 : 0;
        if (i != this.mLastDisplay || this.mLastFormat == null) {
            switch (i) {
                case 0:
                    dateFormat = getTimeFormat();
                    break;
                case 1:
                    dateFormat = getDateFormat();
                    break;
                default:
                    throw new RuntimeException("unknown display value: " + i);
            }
            this.mLastFormat = dateFormat;
        } else {
            dateFormat = this.mLastFormat;
        }
        setText(dateFormat.format(this.mTime));
        if (i == 0) {
            this.mUpdateTimeMillis = millis2 > millis4 ? millis2 : millis4;
        } else if (this.mTimeMillis < normalize) {
            this.mUpdateTimeMillis = 0L;
        } else {
            if (millis >= millis3) {
                millis = millis3;
            }
            this.mUpdateTimeMillis = millis;
        }
        System.nanoTime();
    }
}
