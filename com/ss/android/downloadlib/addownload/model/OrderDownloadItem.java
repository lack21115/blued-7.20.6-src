package com.ss.android.downloadlib.addownload.model;

import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/model/OrderDownloadItem.class */
public class OrderDownloadItem {
    public int b;
    public AdDownloadModel h;
    public long hj;
    public boolean ko;
    public String mb;
    public String ox;
    public AdDownloadEventConfig u;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/model/OrderDownloadItem$OrderCheckStatus.class */
    public @interface OrderCheckStatus {
        public static final int DELETE_LATE_ORDER = 5;
        public static final int INSTALLED = 2;
        public static final int NORMAL = 1;
        public static final int NO_WIFI_PARAM = 4;
        public static final int REPEAT_DOWNLOAD = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/model/OrderDownloadItem$OrderStatus.class */
    public @interface OrderStatus {
        public static final int HANDLE_FAILED = -2;
        public static final int ORDERING = 0;
        public static final int ORDER_CANCEL = 2;
        public static final int ORDER_OVERDUE = 3;
        public static final int QUERY_FAILED = -1;
        public static final int SHELVED = 1;
    }

    public String toString() {
        return "OrderDownloadItem{bizType='" + this.mb + "', orderId='" + this.ox + "', orderStatus=" + this.b + ", nextRequestInterval=" + this.hj + ", downloadModel=" + this.h + ", eventConfig=" + this.u + ", enableDownload=" + this.ko + '}';
    }
}
