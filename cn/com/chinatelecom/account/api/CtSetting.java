package cn.com.chinatelecom.account.api;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/CtSetting.class */
public class CtSetting {
    private static final int DEFAULT_CONN_TIMEOUT = 5000;
    private static final int DEFAULT_READ_TIMEOUT = 5000;
    private static final int DEFAULT_TOTAL_TIMEOUT = 10000;
    private int connTimeout;
    private int readTimeout;
    private int totalTimeout;

    public CtSetting() {
        this.totalTimeout = 0;
        this.connTimeout = 0;
        this.readTimeout = 0;
    }

    public CtSetting(int i, int i2, int i3) {
        this.totalTimeout = 0;
        this.connTimeout = 0;
        this.readTimeout = 0;
        this.connTimeout = i;
        this.readTimeout = i2;
        this.totalTimeout = i3;
    }

    public static int getConnTimeout(CtSetting ctSetting) {
        int i;
        if (ctSetting == null || (i = ctSetting.connTimeout) <= 0) {
            return 5000;
        }
        return i;
    }

    public static int getReadTimeout(CtSetting ctSetting) {
        int i;
        if (ctSetting == null || (i = ctSetting.readTimeout) <= 0) {
            return 5000;
        }
        return i;
    }

    public static int getTotalTimeout(CtSetting ctSetting) {
        int i;
        if (ctSetting == null || (i = ctSetting.totalTimeout) <= 0) {
            return 10000;
        }
        return i;
    }

    public void setConnTimeout(int i) {
        this.connTimeout = i;
    }

    public void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    public void setTotalTimeout(int i) {
        this.totalTimeout = i;
    }
}
