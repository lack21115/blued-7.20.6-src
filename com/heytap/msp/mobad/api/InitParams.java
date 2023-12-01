package com.heytap.msp.mobad.api;

import com.heytap.msp.mobad.api.a.a.b;
import com.heytap.msp.mobad.api.a.a.c;
import com.heytap.msp.mobad.api.a.a.d;
import java.util.concurrent.ExecutorService;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/InitParams.class */
public final class InitParams {
    public static final int ADVANCE_MODE_0 = 0;
    public static final int ADVANCE_MODE_1 = 1;
    public static final int ADVANCE_MODE_2 = 2;
    public static final InitParams NONE = new Builder().setDebug(false).build();
    private static final String TAG = "InitParams";
    public final int advanceMode;
    public final boolean appOUIDStatus;
    public final ClassifyByAgeProvider classifyByAgeProvider;
    public final boolean debug;
    public final boolean touristMode;

    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/InitParams$Builder.class */
    public static class Builder {
        private ExecutorService bizExecutorService;
        private ClassifyByAgeProvider classifyByAgeProvider;
        private com.heytap.msp.mobad.api.a.a.a downloadEngine;
        private b httpExecutor;
        private c httpsExecutor;
        private ExecutorService ioExecutorService;
        private d log;
        private ExecutorService netExecutorService;
        private boolean debug = false;
        private boolean useOtherModels = false;
        private boolean appOUIDStatus = true;
        private boolean touristMode = false;
        private int advanceMode = 0;

        public InitParams build() {
            return new InitParams(this);
        }

        public Builder setAdvanceModel(int i) {
            this.advanceMode = i;
            return this;
        }

        public Builder setAppOUIDStatus(boolean z) {
            this.appOUIDStatus = z;
            return this;
        }

        @Deprecated
        public Builder setBizExecutorService(ExecutorService executorService) {
            return this;
        }

        public Builder setClassifyByAgeProvider(ClassifyByAgeProvider classifyByAgeProvider) {
            this.classifyByAgeProvider = classifyByAgeProvider;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.debug = z;
            return this;
        }

        @Deprecated
        public Builder setDownloadEngine(com.heytap.msp.mobad.api.a.a.a aVar) {
            return this;
        }

        @Deprecated
        public Builder setHttpExecutor(b bVar) {
            return this;
        }

        @Deprecated
        public Builder setHttpsExecutor(c cVar) {
            return this;
        }

        @Deprecated
        public Builder setIoExecutorService(ExecutorService executorService) {
            return this;
        }

        @Deprecated
        public Builder setLog(d dVar) {
            return this;
        }

        @Deprecated
        public Builder setNetExecutorService(ExecutorService executorService) {
            return this;
        }

        public Builder setTouristMode(boolean z) {
            this.touristMode = z;
            return this;
        }

        @Deprecated
        public Builder setUseOtherModels(boolean z) {
            return this;
        }
    }

    public InitParams(Builder builder) {
        this.debug = builder.debug;
        this.appOUIDStatus = builder.appOUIDStatus;
        this.touristMode = builder.touristMode;
        this.classifyByAgeProvider = builder.classifyByAgeProvider;
        this.advanceMode = builder.advanceMode;
    }

    public String toString() {
        return "InitParams{}";
    }
}
