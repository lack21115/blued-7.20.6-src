package com.bytedance.applog.tracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.ListFragment;
import android.app.Presentation;
import android.content.DialogInterface;
import android.location.Location;
import android.preference.PreferenceFragment;
import android.util.LruCache;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebViewFragment;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.applog.util.WebViewJsUtil;
import com.bytedance.bdtracker.a;
import com.bytedance.bdtracker.b;
import com.bytedance.bdtracker.b3;
import com.bytedance.bdtracker.c;
import com.bytedance.bdtracker.c2;
import com.bytedance.bdtracker.d3;
import com.bytedance.bdtracker.k2;
import com.bytedance.bdtracker.o;
import com.bytedance.bdtracker.t2;
import com.bytedance.bdtracker.v1;
import com.bytedance.bdtracker.z2;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/tracker/Tracker.class */
public class Tracker {

    /* renamed from: a  reason: collision with root package name */
    public static float f7575a;
    public static float b;

    /* renamed from: c  reason: collision with root package name */
    public static int[] f7576c = new int[2];
    public static final LruCache<String, Long> d = new LruCache<>(100);

    public static /* synthetic */ String a(View view, v1 v1Var) {
        StringBuilder a2 = a.a("tracker:on click: width = ");
        a2.append(view.getWidth());
        a2.append(" height = ");
        a2.append(view.getHeight());
        a2.append(" touchX = ");
        a2.append(v1Var.B);
        a2.append(" touchY = ");
        a2.append(v1Var.C);
        return a2.toString();
    }

    public static /* synthetic */ void a(View view, v1 v1Var, c cVar) {
        if (cVar.isBavEnabled() && !cVar.isAutoTrackClickIgnored(view)) {
            v1Var.m = cVar.getViewProperties(view);
            cVar.receive(v1Var.m2745clone());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x01f4, code lost:
        if (r6 != null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0203, code lost:
        if (r6 != null) goto L83;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01eb A[Catch: all -> 0x0214, TRY_LEAVE, TryCatch #2 {all -> 0x0214, blocks: (B:64:0x01e3, B:66:0x01eb, B:71:0x0206, B:69:0x01fa), top: B:79:0x01e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01fa A[Catch: all -> 0x0214, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0214, blocks: (B:64:0x01e3, B:66:0x01eb, B:71:0x0206, B:69:0x01fa), top: B:79:0x01e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.view.View r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 555
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.applog.tracker.Tracker.a(android.view.View, java.lang.String):void");
    }

    public static boolean a() {
        return b.b(b.f7589c);
    }

    public static void dismiss(Dialog dialog) {
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            z2.a("tracker:enter dispatchTouchEvent");
            f7575a = motionEvent.getRawX();
            b = motionEvent.getRawY();
        }
    }

    public static void hide(Dialog dialog) {
    }

    public static void loadData(View view, String str, String str2, String str3) {
        loadDataWithBaseURL(view, "", str, str2, str3, "");
    }

    public static void loadDataWithBaseURL(View view, String str, String str2, String str3, String str4, String str5) {
        a(view, str);
        WebViewJsUtil.loadDataWithBaseURL(view, str, str2, str3, str4, str5);
    }

    public static void loadUrl(View view, String str) {
        loadUrl(view, str, null);
    }

    public static void loadUrl(View view, String str, Map<String, String> map) {
        a(view, str);
        WebViewJsUtil.loadUrl(view, str, map);
    }

    public static void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        onClick(compoundButton);
    }

    public static void onCheckedChanged(RadioGroup radioGroup, int i) {
        onClick(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
    }

    public static boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        onClick(view);
        return false;
    }

    public static void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface instanceof AlertDialog) {
            onClick(((AlertDialog) dialogInterface).getButton(i));
            return;
        }
        if (k2.h && (dialogInterface instanceof androidx.appcompat.app.AlertDialog)) {
            onClick(((androidx.appcompat.app.AlertDialog) dialogInterface).getButton(i));
            return;
        }
        if (k2.m && (dialogInterface instanceof androidx.appcompat.app.AlertDialog)) {
            onClick(((androidx.appcompat.app.AlertDialog) dialogInterface).getButton(i));
        }
    }

    public static void onClick(final View view) {
        if (view == null || !(!b.a(b.f7588a).isEmpty())) {
            return;
        }
        final v1 a2 = b3.a(view, true);
        if (a2 == null) {
            z2.c("U SHALL NOT PASS!", (Throwable) null);
            return;
        }
        view.getLocationOnScreen(f7576c);
        int[] iArr = f7576c;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = (int) (f7575a - i);
        int i4 = (int) (b - i2);
        if (i3 >= 0 && i3 <= view.getWidth() && i4 >= 0 && i4 <= view.getHeight()) {
            a2.B = i3;
            a2.C = i4;
        }
        f7575a = 0.0f;
        b = 0.0f;
        z2.a(new z2.a() { // from class: com.bytedance.applog.tracker.-$$Lambda$y5ZEH3t5GjRTMxiF4hKwewwAnoY
            @Override // com.bytedance.bdtracker.z2.a
            public final String a() {
                return Tracker.a(view, a2);
            }
        });
        b.a aVar = new b.a() { // from class: com.bytedance.applog.tracker.-$$Lambda$fFi8SMZSARk6ywxC6NpkVjS7p4w
            @Override // com.bytedance.bdtracker.b.a
            public final void a(c cVar) {
                Tracker.a(view, a2, cVar);
            }
        };
        for (c cVar : c.D) {
            aVar.a(cVar);
        }
    }

    public static void onFocusChange(View view, boolean z) {
        if (view instanceof TextView) {
            onClick(view);
        }
    }

    public static boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        onClick(view);
        return true;
    }

    public static void onHiddenChanged(Fragment fragment, boolean z) {
        if (z) {
            o.a(fragment);
        } else {
            o.b(fragment);
        }
    }

    public static void onHiddenChanged(ListFragment listFragment, boolean z) {
        if (z) {
            o.a(listFragment);
        } else {
            o.b(listFragment);
        }
    }

    public static void onHiddenChanged(PreferenceFragment preferenceFragment, boolean z) {
        if (z) {
            o.a(preferenceFragment);
        } else {
            o.b(preferenceFragment);
        }
    }

    public static void onHiddenChanged(WebViewFragment webViewFragment, boolean z) {
        if (z) {
            o.a(webViewFragment);
        } else {
            o.b(webViewFragment);
        }
    }

    public static void onHiddenChanged(androidx.fragment.app.Fragment fragment, boolean z) {
        if (z) {
            o.a(fragment);
        } else {
            o.b(fragment);
        }
    }

    public static void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        onClick(view);
    }

    public static boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return false;
    }

    public static void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        onItemClick(adapterView, view, i, j);
    }

    public static void onLocationChanged(Location location) {
    }

    public static void onLongClick(View view) {
    }

    public static boolean onMenuItemClick(MenuItem menuItem) {
        View view;
        if (menuItem == null) {
            view = null;
        } else {
            d3.b();
            View[] a2 = d3.a();
            try {
                int length = a2.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    view = null;
                    if (i2 >= length) {
                        break;
                    }
                    View view2 = a2[i2];
                    if (view2.getClass() == d3.d) {
                        view = b3.a(view2, menuItem);
                        if (view != null) {
                            break;
                        }
                    }
                    i = i2 + 1;
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                z2.a(e);
                view = null;
            }
        }
        onClick(view);
        return false;
    }

    public static void onOptionsItemSelected(MenuItem menuItem) {
        onMenuItemClick(menuItem);
    }

    public static void onPause(Fragment fragment) {
        o.a(fragment);
    }

    public static void onPause(ListFragment listFragment) {
        o.a(listFragment);
    }

    public static void onPause(PreferenceFragment preferenceFragment) {
        o.a(preferenceFragment);
    }

    public static void onPause(WebViewFragment webViewFragment) {
        o.a(webViewFragment);
    }

    public static void onPause(androidx.fragment.app.Fragment fragment) {
        o.a(fragment);
    }

    public static void onProgressChanged(Object obj, View view, int i) {
        if (k2.a(view)) {
            try {
                Object invoke = view.getClass().getMethod("getUrl", new Class[0]).invoke(view, new Object[0]);
                if (invoke != null) {
                    String valueOf = String.valueOf(invoke);
                    WebViewJsUtil.evaluateJavascript(view, "if(typeof AppLogBridge !== 'undefined' && !AppLogBridge.hasStarted) { AppLogBridge.hasStarted = function(callback = undefined) {    if(callback) callback(AppLogBridge.hasStartedForJsSdkUnderV5_deprecated());\n    return AppLogBridge.hasStartedForJsSdkUnderV5_deprecated();};\n}");
                    if (a()) {
                        WebViewJsUtil.injectCollectJs(view, valueOf);
                    }
                }
            } catch (Throwable th) {
                z2.a(th);
            }
        }
    }

    public static void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
        if (z) {
            onClick(ratingBar);
        }
    }

    public static void onResume(Fragment fragment) {
        o.b(fragment);
    }

    public static void onResume(ListFragment listFragment) {
        o.b(listFragment);
    }

    public static void onResume(PreferenceFragment preferenceFragment) {
        o.b(preferenceFragment);
    }

    public static void onResume(WebViewFragment webViewFragment) {
        o.b(webViewFragment);
    }

    public static void onResume(androidx.fragment.app.Fragment fragment) {
        o.b(fragment);
    }

    public static void onStart(Presentation presentation) {
        LinkedList linkedList;
        int a2 = o.a(presentation);
        if (o.k.containsKey(Integer.valueOf(a2))) {
            linkedList = o.k.get(Integer.valueOf(a2));
        } else {
            linkedList = new LinkedList();
            o.k.put(Integer.valueOf(a2), linkedList);
        }
        String name = presentation.getClass().getName();
        long currentTimeMillis = System.currentTimeMillis();
        Activity ownerActivity = presentation.getOwnerActivity();
        c2 a3 = o.a(ownerActivity != null ? ownerActivity.getClass() : presentation.getClass(), false, name, "", t2.b(ownerActivity), t2.a(ownerActivity), currentTimeMillis, "", t2.c(ownerActivity));
        if (!o.o && linkedList == null) {
            throw new AssertionError();
        }
        linkedList.add(a3);
    }

    public static void onStop(Presentation presentation) {
        int a2 = o.a(presentation);
        if (o.k.containsKey(Integer.valueOf(a2))) {
            LinkedList linkedList = (LinkedList) o.k.get(Integer.valueOf(a2));
            if (linkedList != null && !linkedList.isEmpty()) {
                o.a(false, (c2) linkedList.removeLast(), System.currentTimeMillis());
            }
            if (linkedList == null || linkedList.isEmpty()) {
                o.k.remove(Integer.valueOf(a2));
            }
        }
    }

    public static void onStopTrackingTouch(SeekBar seekBar) {
        onClick(seekBar);
    }

    public static void setUserVisibleHint(Fragment fragment, boolean z) {
        if (z) {
            o.b(fragment);
        } else {
            o.a(fragment);
        }
    }

    public static void setUserVisibleHint(ListFragment listFragment, boolean z) {
        if (z) {
            o.b(listFragment);
        } else {
            o.a(listFragment);
        }
    }

    public static void setUserVisibleHint(PreferenceFragment preferenceFragment, boolean z) {
        if (z) {
            o.b(preferenceFragment);
        } else {
            o.a(preferenceFragment);
        }
    }

    public static void setUserVisibleHint(WebViewFragment webViewFragment, boolean z) {
        if (z) {
            o.b(webViewFragment);
        } else {
            o.a(webViewFragment);
        }
    }

    public static void setUserVisibleHint(androidx.fragment.app.Fragment fragment, boolean z) {
        if (z) {
            o.b(fragment);
        } else {
            o.a(fragment);
        }
    }

    public static void show(Dialog dialog) {
    }
}
