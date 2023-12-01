package io.grpc.stub;

import io.grpc.CallOptions;
import io.grpc.stub.ClientCalls;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/stub/InternalClientCalls.class */
public final class InternalClientCalls {

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/stub/InternalClientCalls$StubType.class */
    public enum StubType {
        BLOCKING(ClientCalls.StubType.BLOCKING),
        ASYNC(ClientCalls.StubType.ASYNC),
        FUTURE(ClientCalls.StubType.FUTURE);
        
        private final ClientCalls.StubType internalType;

        StubType(ClientCalls.StubType stubType) {
            this.internalType = stubType;
        }

        public static StubType of(ClientCalls.StubType stubType) {
            StubType[] values = values();
            int length = values.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    throw new AssertionError("Unknown StubType: " + stubType.name());
                }
                StubType stubType2 = values[i2];
                if (stubType2.internalType == stubType) {
                    return stubType2;
                }
                i = i2 + 1;
            }
        }
    }

    public static StubType getStubType(CallOptions callOptions) {
        return StubType.of((ClientCalls.StubType) callOptions.getOption(ClientCalls.STUB_TYPE_OPTION));
    }

    public static CallOptions.Key<ClientCalls.StubType> getStubTypeOption() {
        return ClientCalls.STUB_TYPE_OPTION;
    }

    public static CallOptions setStubType(CallOptions callOptions, StubType stubType) {
        return callOptions.withOption(ClientCalls.STUB_TYPE_OPTION, stubType.internalType);
    }
}
