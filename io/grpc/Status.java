package io.grpc;

import com.google.common.base.Charsets;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import io.grpc.Metadata;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
/* loaded from: source-8829756-dex2jar.jar:io/grpc/Status.class */
public final class Status {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final Metadata.Key<String> MESSAGE_KEY;
    private static final Metadata.TrustedAsciiMarshaller<String> STATUS_MESSAGE_MARSHALLER;
    private final Throwable cause;
    private final Code code;
    private final String description;
    private static final String TEST_EQUALS_FAILURE_PROPERTY = "io.grpc.Status.failOnEqualsForTest";
    private static final boolean FAIL_ON_EQUALS_FOR_TEST = Boolean.parseBoolean(System.getProperty(TEST_EQUALS_FAILURE_PROPERTY, "false"));
    private static final List<Status> STATUS_LIST = buildStatusList();
    public static final Status OK = Code.OK.toStatus();
    public static final Status CANCELLED = Code.CANCELLED.toStatus();
    public static final Status UNKNOWN = Code.UNKNOWN.toStatus();
    public static final Status INVALID_ARGUMENT = Code.INVALID_ARGUMENT.toStatus();
    public static final Status DEADLINE_EXCEEDED = Code.DEADLINE_EXCEEDED.toStatus();
    public static final Status NOT_FOUND = Code.NOT_FOUND.toStatus();
    public static final Status ALREADY_EXISTS = Code.ALREADY_EXISTS.toStatus();
    public static final Status PERMISSION_DENIED = Code.PERMISSION_DENIED.toStatus();
    public static final Status UNAUTHENTICATED = Code.UNAUTHENTICATED.toStatus();
    public static final Status RESOURCE_EXHAUSTED = Code.RESOURCE_EXHAUSTED.toStatus();
    public static final Status FAILED_PRECONDITION = Code.FAILED_PRECONDITION.toStatus();
    public static final Status ABORTED = Code.ABORTED.toStatus();
    public static final Status OUT_OF_RANGE = Code.OUT_OF_RANGE.toStatus();
    public static final Status UNIMPLEMENTED = Code.UNIMPLEMENTED.toStatus();
    public static final Status INTERNAL = Code.INTERNAL.toStatus();
    public static final Status UNAVAILABLE = Code.UNAVAILABLE.toStatus();
    public static final Status DATA_LOSS = Code.DATA_LOSS.toStatus();
    static final Metadata.Key<Status> CODE_KEY = Metadata.Key.of("grpc-status", false, (Metadata.TrustedAsciiMarshaller) new StatusCodeMarshaller());

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Status$Code.class */
    public enum Code {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);
        
        private final int value;
        private final byte[] valueAscii;

        Code(int i) {
            this.value = i;
            this.valueAscii = Integer.toString(i).getBytes(Charsets.US_ASCII);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte[] valueAscii() {
            return this.valueAscii;
        }

        public Status toStatus() {
            return (Status) Status.STATUS_LIST.get(this.value);
        }

        public int value() {
            return this.value;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Status$StatusCodeMarshaller.class */
    static final class StatusCodeMarshaller implements Metadata.TrustedAsciiMarshaller<Status> {
        private StatusCodeMarshaller() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public Status parseAsciiString(byte[] bArr) {
            return Status.fromCodeValue(bArr);
        }

        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public byte[] toAsciiString(Status status) {
            return status.getCode().valueAscii();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Status$StatusMessageMarshaller.class */
    static final class StatusMessageMarshaller implements Metadata.TrustedAsciiMarshaller<String> {
        private static final byte[] HEX = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

        private StatusMessageMarshaller() {
        }

        private static boolean isEscapingChar(byte b) {
            return b < 32 || b >= 126 || b == 37;
        }

        private static String parseAsciiStringSlow(byte[] bArr) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= bArr.length) {
                    return new String(allocate.array(), 0, allocate.position(), Charsets.UTF_8);
                }
                if (bArr[i2] == 37 && i2 + 2 < bArr.length) {
                    try {
                        allocate.put((byte) Integer.parseInt(new String(bArr, i2 + 1, 2, Charsets.US_ASCII), 16));
                        i = i2 + 3;
                    } catch (NumberFormatException e) {
                    }
                }
                allocate.put(bArr[i2]);
                i = i2 + 1;
            }
        }

        private static byte[] toAsciiStringSlow(byte[] bArr, int i) {
            int i2;
            int i3;
            byte[] bArr2 = new byte[((bArr.length - i) * 3) + i];
            if (i != 0) {
                System.arraycopy(bArr, 0, bArr2, 0, i);
            }
            int i4 = i;
            for (int i5 = i; i5 < bArr.length; i5++) {
                byte b = bArr[i5];
                if (isEscapingChar(b)) {
                    bArr2[i4] = 37;
                    byte[] bArr3 = HEX;
                    bArr2[i4 + 1] = bArr3[(b >> 4) & 15];
                    bArr2[i4 + 2] = bArr3[b & 15];
                    i2 = i4;
                    i3 = 3;
                } else {
                    bArr2[i4] = b;
                    i2 = i4;
                    i3 = 1;
                }
                i4 = i2 + i3;
            }
            byte[] bArr4 = new byte[i4];
            System.arraycopy(bArr2, 0, bArr4, 0, i4);
            return bArr4;
        }

        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public String parseAsciiString(byte[] bArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= bArr.length) {
                    return new String(bArr, 0);
                }
                byte b = bArr[i2];
                if (b < 32 || b >= 126 || (b == 37 && i2 + 2 < bArr.length)) {
                    break;
                }
                i = i2 + 1;
            }
            return parseAsciiStringSlow(bArr);
        }

        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public byte[] toAsciiString(String str) {
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= bytes.length) {
                    return bytes;
                }
                if (isEscapingChar(bytes[i2])) {
                    return toAsciiStringSlow(bytes, i2);
                }
                i = i2 + 1;
            }
        }
    }

    static {
        StatusMessageMarshaller statusMessageMarshaller = new StatusMessageMarshaller();
        STATUS_MESSAGE_MARSHALLER = statusMessageMarshaller;
        MESSAGE_KEY = Metadata.Key.of("grpc-message", false, (Metadata.TrustedAsciiMarshaller) statusMessageMarshaller);
    }

    private Status(Code code) {
        this(code, null, null);
    }

    private Status(Code code, @Nullable String str, @Nullable Throwable th) {
        this.code = (Code) Preconditions.checkNotNull(code, "code");
        this.description = str;
        this.cause = th;
    }

    private static List<Status> buildStatusList() {
        TreeMap treeMap = new TreeMap();
        Code[] values = Code.values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return Collections.unmodifiableList(new ArrayList(treeMap.values()));
            }
            Code code = values[i2];
            Status status = (Status) treeMap.put(Integer.valueOf(code.value()), new Status(code));
            if (status != null) {
                throw new IllegalStateException("Code value duplication between " + status.getCode().name() + " & " + code.name());
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String formatThrowableMessage(Status status) {
        if (status.description == null) {
            return status.code.toString();
        }
        return status.code + ": " + status.description;
    }

    public static Status fromCode(Code code) {
        return code.toStatus();
    }

    public static Status fromCodeValue(int i) {
        if (i < 0 || i > STATUS_LIST.size()) {
            Status status = UNKNOWN;
            return status.withDescription("Unknown code " + i);
        }
        return STATUS_LIST.get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status fromCodeValue(byte[] bArr) {
        return (bArr.length == 1 && bArr[0] == 48) ? OK : fromCodeValueSlow(bArr);
    }

    private static Status fromCodeValueSlow(byte[] bArr) {
        int i;
        int length = bArr.length;
        char c2 = 1;
        int i2 = 0;
        if (length != 1) {
            if (length == 2 && bArr[0] >= 48 && bArr[0] <= 57) {
                i2 = 0 + ((bArr[0] - 48) * 10);
            }
            return UNKNOWN.withDescription("Unknown code " + new String(bArr, Charsets.US_ASCII));
        }
        c2 = 0;
        if (bArr[c2] >= 48 && bArr[c2] <= 57 && (i = i2 + (bArr[c2] - 48)) < STATUS_LIST.size()) {
            return STATUS_LIST.get(i);
        }
        return UNKNOWN.withDescription("Unknown code " + new String(bArr, Charsets.US_ASCII));
    }

    public static Status fromThrowable(Throwable th) {
        Throwable th2 = (Throwable) Preconditions.checkNotNull(th, "t");
        while (true) {
            Throwable th3 = th2;
            if (th3 == null) {
                return UNKNOWN.withCause(th);
            }
            if (th3 instanceof StatusException) {
                return ((StatusException) th3).getStatus();
            }
            if (th3 instanceof StatusRuntimeException) {
                return ((StatusRuntimeException) th3).getStatus();
            }
            th2 = th3.getCause();
        }
    }

    public static Metadata trailersFromThrowable(Throwable th) {
        Throwable th2 = (Throwable) Preconditions.checkNotNull(th, "t");
        while (true) {
            Throwable th3 = th2;
            if (th3 == null) {
                return null;
            }
            if (th3 instanceof StatusException) {
                return ((StatusException) th3).getTrailers();
            }
            if (th3 instanceof StatusRuntimeException) {
                return ((StatusRuntimeException) th3).getTrailers();
            }
            th2 = th3.getCause();
        }
    }

    public StatusException asException() {
        return new StatusException(this);
    }

    public StatusException asException(@Nullable Metadata metadata) {
        return new StatusException(this, metadata);
    }

    public StatusRuntimeException asRuntimeException() {
        return new StatusRuntimeException(this);
    }

    public StatusRuntimeException asRuntimeException(@Nullable Metadata metadata) {
        return new StatusRuntimeException(this, metadata);
    }

    public Status augmentDescription(String str) {
        if (str == null) {
            return this;
        }
        if (this.description == null) {
            return new Status(this.code, str, this.cause);
        }
        Code code = this.code;
        return new Status(code, this.description + "\n" + str, this.cause);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Nullable
    public Throwable getCause() {
        return this.cause;
    }

    public Code getCode() {
        return this.code;
    }

    @Nullable
    public String getDescription() {
        return this.description;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isOk() {
        return Code.OK == this.code;
    }

    public String toString() {
        MoreObjects.ToStringHelper add = MoreObjects.toStringHelper(this).add("code", this.code.name()).add("description", this.description);
        Throwable th = this.cause;
        String str = th;
        if (th != null) {
            str = Throwables.getStackTraceAsString(th);
        }
        return add.add("cause", str).toString();
    }

    public Status withCause(Throwable th) {
        return Objects.equal(this.cause, th) ? this : new Status(this.code, this.description, th);
    }

    public Status withDescription(String str) {
        return Objects.equal(this.description, str) ? this : new Status(this.code, str, this.cause);
    }
}
