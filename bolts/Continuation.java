package bolts;

/* loaded from: source-8756600-dex2jar.jar:bolts/Continuation.class */
public interface Continuation<TTaskResult, TContinuationResult> {
    TContinuationResult then(Task<TTaskResult> task) throws Exception;
}
