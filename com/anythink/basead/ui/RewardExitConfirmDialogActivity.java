package com.anythink.basead.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.anythink.core.common.k.h;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/RewardExitConfirmDialogActivity.class */
public class RewardExitConfirmDialogActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private static Runnable f6162a;
    private static String b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f6163c;

    /* renamed from: com.anythink.basead.ui.RewardExitConfirmDialogActivity$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/RewardExitConfirmDialogActivity$1.class */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            if (RewardExitConfirmDialogActivity.f6162a != null) {
                RewardExitConfirmDialogActivity.f6162a.run();
            }
            RewardExitConfirmDialogActivity.this.finish();
        }
    }

    /* renamed from: com.anythink.basead.ui.RewardExitConfirmDialogActivity$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/RewardExitConfirmDialogActivity$2.class */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            RewardExitConfirmDialogActivity.this.finish();
        }
    }

    public static void a(Context context, String str, Runnable runnable) {
        b = str;
        f6162a = runnable;
        Intent intent = new Intent(context, RewardExitConfirmDialogActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private void b() {
        try {
            View inflate = LayoutInflater.from(this).inflate(h.a(this, "myoffer_confirm_dialog", "layout"), (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(h.a(this, "myoffer_confirm_msg", "id"));
            TextView textView2 = (TextView) inflate.findViewById(h.a(this, "myoffer_confirm_give_up", "id"));
            TextView textView3 = (TextView) inflate.findViewById(h.a(this, "myoffer_confirm_continue", "id"));
            textView.setText(getResources().getString(h.a(this, "myoffer_reward_exit_confirm_msg", "string"), b));
            textView2.setText(getResources().getString(h.a(this, "myoffer_reward_exit_confirm_give_up", "string")));
            textView3.setText(getResources().getString(h.a(this, "myoffer_reward_exit_confirm_continue", "string")));
            textView2.setOnClickListener(new AnonymousClass1());
            textView3.setOnClickListener(new AnonymousClass2());
            Dialog dialog = new Dialog(this, h.a(this, "style_full_screen_translucent_dialog", "style"));
            this.f6163c = dialog;
            dialog.setContentView(inflate);
            this.f6163c.setCancelable(false);
            this.f6163c.show();
        } catch (Throwable th) {
            finish();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            View inflate = LayoutInflater.from(this).inflate(h.a(this, "myoffer_confirm_dialog", "layout"), (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(h.a(this, "myoffer_confirm_msg", "id"));
            TextView textView2 = (TextView) inflate.findViewById(h.a(this, "myoffer_confirm_give_up", "id"));
            TextView textView3 = (TextView) inflate.findViewById(h.a(this, "myoffer_confirm_continue", "id"));
            textView.setText(getResources().getString(h.a(this, "myoffer_reward_exit_confirm_msg", "string"), b));
            textView2.setText(getResources().getString(h.a(this, "myoffer_reward_exit_confirm_give_up", "string")));
            textView3.setText(getResources().getString(h.a(this, "myoffer_reward_exit_confirm_continue", "string")));
            textView2.setOnClickListener(new AnonymousClass1());
            textView3.setOnClickListener(new AnonymousClass2());
            Dialog dialog = new Dialog(this, h.a(this, "style_full_screen_translucent_dialog", "style"));
            this.f6163c = dialog;
            dialog.setContentView(inflate);
            this.f6163c.setCancelable(false);
            this.f6163c.show();
        } catch (Throwable th) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        Dialog dialog = this.f6163c;
        if (dialog != null) {
            dialog.dismiss();
            this.f6163c = null;
        }
        f6162a = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
