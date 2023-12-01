package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;

/* loaded from: source-8756600-dex2jar.jar:androidx/activity/result/ActivityResultCaller.class */
public interface ActivityResultCaller {
    <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback);

    <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultRegistry activityResultRegistry, ActivityResultCallback<O> activityResultCallback);
}
