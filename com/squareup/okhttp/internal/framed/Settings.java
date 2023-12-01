package com.squareup.okhttp.internal.framed;

import java.util.Arrays;

/* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/internal/framed/Settings.class */
public final class Settings {
    static final int CLIENT_CERTIFICATE_VECTOR_SIZE = 8;
    static final int COUNT = 10;
    static final int CURRENT_CWND = 5;
    static final int DEFAULT_INITIAL_WINDOW_SIZE = 65536;
    static final int DOWNLOAD_BANDWIDTH = 2;
    static final int DOWNLOAD_RETRANS_RATE = 6;
    static final int ENABLE_PUSH = 2;
    static final int FLAG_CLEAR_PREVIOUSLY_PERSISTED_SETTINGS = 1;
    static final int FLOW_CONTROL_OPTIONS = 10;
    static final int FLOW_CONTROL_OPTIONS_DISABLED = 1;
    static final int HEADER_TABLE_SIZE = 1;
    static final int INITIAL_WINDOW_SIZE = 7;
    static final int MAX_CONCURRENT_STREAMS = 4;
    static final int MAX_FRAME_SIZE = 5;
    static final int MAX_HEADER_LIST_SIZE = 6;
    static final int PERSISTED = 2;
    static final int PERSIST_VALUE = 1;
    static final int ROUND_TRIP_TIME = 3;
    static final int UPLOAD_BANDWIDTH = 1;
    private int persistValue;
    private int persisted;
    private int set;
    private final int[] values = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        this.persisted = 0;
        this.persistValue = 0;
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int flags(int i) {
        int i2 = isPersisted(i) ? 2 : 0;
        int i3 = i2;
        if (persistValue(i)) {
            i3 = i2 | 1;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int get(int i) {
        return this.values[i];
    }

    int getClientCertificateVectorSize(int i) {
        if ((this.set & 256) != 0) {
            i = this.values[8];
        }
        return i;
    }

    int getCurrentCwnd(int i) {
        if ((this.set & 32) != 0) {
            i = this.values[5];
        }
        return i;
    }

    int getDownloadBandwidth(int i) {
        if ((this.set & 4) != 0) {
            i = this.values[2];
        }
        return i;
    }

    int getDownloadRetransRate(int i) {
        if ((this.set & 64) != 0) {
            i = this.values[6];
        }
        return i;
    }

    boolean getEnablePush(boolean z) {
        int i = (this.set & 4) != 0 ? this.values[2] : z ? 1 : 0;
        boolean z2 = false;
        if (i == 1) {
            z2 = true;
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getInitialWindowSize(int i) {
        if ((this.set & 128) != 0) {
            i = this.values[7];
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMaxConcurrentStreams(int i) {
        if ((this.set & 16) != 0) {
            i = this.values[4];
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMaxFrameSize(int i) {
        if ((this.set & 32) != 0) {
            i = this.values[5];
        }
        return i;
    }

    int getMaxHeaderListSize(int i) {
        if ((this.set & 64) != 0) {
            i = this.values[6];
        }
        return i;
    }

    int getRoundTripTime(int i) {
        if ((this.set & 8) != 0) {
            i = this.values[3];
        }
        return i;
    }

    int getUploadBandwidth(int i) {
        if ((this.set & 2) != 0) {
            i = this.values[1];
        }
        return i;
    }

    boolean isFlowControlDisabled() {
        boolean z = false;
        if ((((this.set & 1024) != 0 ? this.values[10] : 0) & 1) != 0) {
            z = true;
        }
        return z;
    }

    boolean isPersisted(int i) {
        return ((1 << i) & this.persisted) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSet(int i) {
        return ((1 << i) & this.set) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void merge(Settings settings) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 10) {
                return;
            }
            if (settings.isSet(i2)) {
                set(i2, settings.flags(i2), settings.get(i2));
            }
            i = i2 + 1;
        }
    }

    boolean persistValue(int i) {
        return ((1 << i) & this.persistValue) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Settings set(int i, int i2, int i3) {
        if (i >= this.values.length) {
            return this;
        }
        int i4 = 1 << i;
        this.set |= i4;
        if ((i2 & 1) != 0) {
            this.persistValue |= i4;
        } else {
            this.persistValue &= i4;
        }
        if ((i2 & 2) != 0) {
            this.persisted |= i4;
        } else {
            this.persisted &= i4;
        }
        this.values[i] = i3;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int size() {
        return Integer.bitCount(this.set);
    }
}
