package io.grpc;

import com.google.common.base.Preconditions;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/ConnectivityStateInfo.class */
public final class ConnectivityStateInfo {
    private final ConnectivityState state;
    private final Status status;

    private ConnectivityStateInfo(ConnectivityState connectivityState, Status status) {
        this.state = (ConnectivityState) Preconditions.checkNotNull(connectivityState, "state is null");
        this.status = (Status) Preconditions.checkNotNull(status, "status is null");
    }

    public static ConnectivityStateInfo forNonError(ConnectivityState connectivityState) {
        Preconditions.checkArgument(connectivityState != ConnectivityState.TRANSIENT_FAILURE, "state is TRANSIENT_ERROR. Use forError() instead");
        return new ConnectivityStateInfo(connectivityState, Status.OK);
    }

    public static ConnectivityStateInfo forTransientFailure(Status status) {
        Preconditions.checkArgument(!status.isOk(), "The error status must not be OK");
        return new ConnectivityStateInfo(ConnectivityState.TRANSIENT_FAILURE, status);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ConnectivityStateInfo) {
            ConnectivityStateInfo connectivityStateInfo = (ConnectivityStateInfo) obj;
            boolean z = false;
            if (this.state.equals(connectivityStateInfo.state)) {
                z = false;
                if (this.status.equals(connectivityStateInfo.status)) {
                    z = true;
                }
            }
            return z;
        }
        return false;
    }

    public ConnectivityState getState() {
        return this.state;
    }

    public Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        return this.state.hashCode() ^ this.status.hashCode();
    }

    public String toString() {
        if (this.status.isOk()) {
            return this.state.toString();
        }
        return this.state + "(" + this.status + ")";
    }
}
