package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import io.grpc.Status;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nonnull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/RetryPolicy.class */
public final class RetryPolicy {
    static final RetryPolicy DEFAULT = new RetryPolicy(1, 0, 0, 1.0d, Collections.emptySet());
    final double backoffMultiplier;
    final long initialBackoffNanos;
    final int maxAttempts;
    final long maxBackoffNanos;
    final Set<Status.Code> retryableStatusCodes;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/RetryPolicy$Provider.class */
    public interface Provider {
        RetryPolicy get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RetryPolicy(int i, long j, long j2, double d, @Nonnull Set<Status.Code> set) {
        this.maxAttempts = i;
        this.initialBackoffNanos = j;
        this.maxBackoffNanos = j2;
        this.backoffMultiplier = d;
        this.retryableStatusCodes = ImmutableSet.copyOf((Collection) set);
    }

    public boolean equals(Object obj) {
        if (obj instanceof RetryPolicy) {
            RetryPolicy retryPolicy = (RetryPolicy) obj;
            boolean z = false;
            if (this.maxAttempts == retryPolicy.maxAttempts) {
                z = false;
                if (this.initialBackoffNanos == retryPolicy.initialBackoffNanos) {
                    z = false;
                    if (this.maxBackoffNanos == retryPolicy.maxBackoffNanos) {
                        z = false;
                        if (Double.compare(this.backoffMultiplier, retryPolicy.backoffMultiplier) == 0) {
                            z = false;
                            if (Objects.equal(this.retryableStatusCodes, retryPolicy.retryableStatusCodes)) {
                                z = true;
                            }
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.maxAttempts), Long.valueOf(this.initialBackoffNanos), Long.valueOf(this.maxBackoffNanos), Double.valueOf(this.backoffMultiplier), this.retryableStatusCodes);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("maxAttempts", this.maxAttempts).add("initialBackoffNanos", this.initialBackoffNanos).add("maxBackoffNanos", this.maxBackoffNanos).add("backoffMultiplier", this.backoffMultiplier).add("retryableStatusCodes", this.retryableStatusCodes).toString();
    }
}
