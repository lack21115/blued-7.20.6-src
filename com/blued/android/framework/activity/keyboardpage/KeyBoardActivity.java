package com.blued.android.framework.activity.keyboardpage;

import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.utils.KeyboardUtils;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/activity/keyboardpage/KeyBoardActivity.class */
public class KeyBoardActivity extends FragmentActivity {

    /* renamed from: a  reason: collision with root package name */
    public View f9778a;
    public boolean b;

    /* renamed from: com.blued.android.framework.activity.keyboardpage.KeyBoardActivity$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/activity/keyboardpage/KeyBoardActivity$1.class */
    class AnonymousClass1 implements KeyboardListenLinearLayout.IOnKeyboardStateChangedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KeyBoardActivity f9779a;

        @Override // com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout.IOnKeyboardStateChangedListener
        public void a(int i) {
            if (i == -3) {
                this.f9779a.a(-3);
            } else if (i != -2) {
            } else {
                this.f9779a.a(-2);
            }
        }
    }

    /* renamed from: com.blued.android.framework.activity.keyboardpage.KeyBoardActivity$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/activity/keyboardpage/KeyBoardActivity$2.class */
    class AnonymousClass2 implements KeyboardListenLinearLayout.IOnKeyboardStateChangedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KeyBoardActivity f9780a;

        @Override // com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout.IOnKeyboardStateChangedListener
        public void a(int i) {
            if (i != -3) {
                if (i != -2) {
                    return;
                }
                KeyBoardActivity keyBoardActivity = this.f9780a;
                keyBoardActivity.a(keyBoardActivity.f9778a);
                this.f9780a.a(-2);
                this.f9780a.b = false;
                return;
            }
            this.f9780a.getWindow().setSoftInputMode(19);
            KeyBoardActivity keyBoardActivity2 = this.f9780a;
            keyBoardActivity2.a(keyBoardActivity2.f9778a);
            this.f9780a.a();
            this.f9780a.a(-3);
            this.f9780a.b = true;
        }
    }

    /* renamed from: com.blued.android.framework.activity.keyboardpage.KeyBoardActivity$3  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/activity/keyboardpage/KeyBoardActivity$3.class */
    class AnonymousClass3 implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KeyBoardActivity f9781a;

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                KeyBoardActivity keyBoardActivity = this.f9781a;
                keyBoardActivity.b(keyBoardActivity.f9778a);
                if (this.f9781a.b) {
                    return false;
                }
                KeyboardUtils.c(this.f9781a);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f9778a.getLayoutParams();
            layoutParams.height = KeyboardUtils.a();
            this.f9778a.setLayoutParams(layoutParams);
        } catch (Exception e) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f9778a.getLayoutParams();
            layoutParams2.height = KeyboardUtils.a();
            this.f9778a.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (view.getVisibility() == 4) {
            getWindow().setSoftInputMode(19);
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        if (view.getVisibility() == 0) {
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            view.setVisibility(4);
        }
    }

    public void a(int i) {
    }
}
