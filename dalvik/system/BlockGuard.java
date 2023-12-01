package dalvik.system;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/BlockGuard.class */
public final class BlockGuard {
    public static final int DISALLOW_DISK_READ = 2;
    public static final int DISALLOW_DISK_WRITE = 1;
    public static final int DISALLOW_NETWORK = 4;
    public static final int PASS_RESTRICTIONS_VIA_RPC = 8;
    public static final int PENALTY_DEATH = 64;
    public static final int PENALTY_DIALOG = 32;
    public static final int PENALTY_LOG = 16;
    public static final Policy LAX_POLICY = new Policy() { // from class: dalvik.system.BlockGuard.1
        @Override // dalvik.system.BlockGuard.Policy
        public int getPolicyMask() {
            return 0;
        }

        @Override // dalvik.system.BlockGuard.Policy
        public void onNetwork() {
        }

        @Override // dalvik.system.BlockGuard.Policy
        public void onReadFromDisk() {
        }

        @Override // dalvik.system.BlockGuard.Policy
        public void onWriteToDisk() {
        }
    };
    private static ThreadLocal<Policy> threadPolicy = new ThreadLocal<Policy>() { // from class: dalvik.system.BlockGuard.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Policy initialValue() {
            return BlockGuard.LAX_POLICY;
        }
    };

    /* loaded from: source-2895416-dex2jar.jar:dalvik/system/BlockGuard$BlockGuardPolicyException.class */
    public static class BlockGuardPolicyException extends RuntimeException {
        private final String mMessage;
        private final int mPolicyState;
        private final int mPolicyViolated;

        public BlockGuardPolicyException(int i, int i2) {
            this(i, i2, null);
        }

        public BlockGuardPolicyException(int i, int i2, String str) {
            this.mPolicyState = i;
            this.mPolicyViolated = i2;
            this.mMessage = str;
            fillInStackTrace();
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return "policy=" + this.mPolicyState + " violation=" + this.mPolicyViolated + (this.mMessage == null ? "" : " msg=" + this.mMessage);
        }

        public int getPolicy() {
            return this.mPolicyState;
        }

        public int getPolicyViolation() {
            return this.mPolicyViolated;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:dalvik/system/BlockGuard$Policy.class */
    public interface Policy {
        int getPolicyMask();

        void onNetwork();

        void onReadFromDisk();

        void onWriteToDisk();
    }

    private BlockGuard() {
    }

    public static Policy getThreadPolicy() {
        return threadPolicy.get();
    }

    public static void setThreadPolicy(Policy policy) {
        if (policy == null) {
            throw new NullPointerException("policy == null");
        }
        threadPolicy.set(policy);
    }
}
