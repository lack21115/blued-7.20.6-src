package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/JobImpl.class */
public class JobImpl extends JobSupport implements CompletableJob {
    private final boolean b;

    public JobImpl(Job job) {
        super(true);
        a(job);
        this.b = q();
    }

    private final boolean q() {
        ChildHandle ax_ = ax_();
        ChildHandleNode childHandleNode = ax_ instanceof ChildHandleNode ? (ChildHandleNode) ax_ : null;
        if (childHandleNode == null) {
            return false;
        }
        JobSupport c2 = childHandleNode.c();
        while (true) {
            JobSupport jobSupport = c2;
            if (jobSupport.au_()) {
                return true;
            }
            ChildHandle ax_2 = jobSupport.ax_();
            ChildHandleNode childHandleNode2 = ax_2 instanceof ChildHandleNode ? (ChildHandleNode) ax_2 : null;
            if (childHandleNode2 == null) {
                return false;
            }
            c2 = childHandleNode2.c();
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean au_() {
        return this.b;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean e() {
        return true;
    }
}
