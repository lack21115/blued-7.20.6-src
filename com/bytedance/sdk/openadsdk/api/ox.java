package com.bytedance.sdk.openadsdk.api;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/ox.class */
public final class ox {
    private boolean mb = false;
    private int ox = -1;
    private String b = null;
    private ValueSet hj = null;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/ox$mb.class */
    static final class mb implements Result {
        private final String b;
        private final ValueSet hj;
        private final boolean mb;
        private final int ox;

        private mb(boolean z, int i, String str, ValueSet valueSet) {
            this.mb = z;
            this.ox = i;
            this.b = str;
            this.hj = valueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.ox;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.mb;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.b;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.hj;
        }
    }

    private ox() {
    }

    public static final ox mb() {
        return new ox();
    }

    public ox mb(int i) {
        this.ox = i;
        return this;
    }

    public ox mb(ValueSet valueSet) {
        this.hj = valueSet;
        return this;
    }

    public ox mb(boolean z) {
        this.mb = z;
        return this;
    }

    public Result ox() {
        boolean z = this.mb;
        int i = this.ox;
        String str = this.b;
        ValueSet valueSet = this.hj;
        ValueSet valueSet2 = valueSet;
        if (valueSet == null) {
            valueSet2 = b.mb().ox();
        }
        return new mb(z, i, str, valueSet2);
    }
}
