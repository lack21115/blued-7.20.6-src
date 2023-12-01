package androidx.core.view;

import android.app.Activity;
import android.os.Build;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/DragAndDropPermissionsCompat.class */
public final class DragAndDropPermissionsCompat {

    /* renamed from: a  reason: collision with root package name */
    private Object f2581a;

    private DragAndDropPermissionsCompat(Object obj) {
        this.f2581a = obj;
    }

    public static DragAndDropPermissionsCompat request(Activity activity, DragEvent dragEvent) {
        DragAndDropPermissions requestDragAndDropPermissions;
        if (Build.VERSION.SDK_INT < 24 || (requestDragAndDropPermissions = activity.requestDragAndDropPermissions(dragEvent)) == null) {
            return null;
        }
        return new DragAndDropPermissionsCompat(requestDragAndDropPermissions);
    }

    public void release() {
        if (Build.VERSION.SDK_INT >= 24) {
            ((DragAndDropPermissions) this.f2581a).release();
        }
    }
}
