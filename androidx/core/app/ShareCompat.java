package androidx.core.app;

import android.app.Activity;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.core.util.Preconditions;
import com.huawei.openalliance.ad.constant.t;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/app/ShareCompat.class */
public final class ShareCompat {
    public static final String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
    public static final String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/ShareCompat$Api16Impl.class */
    public static class Api16Impl {
        private Api16Impl() {
        }

        static void a(Intent intent) {
            intent.setClipData(null);
            intent.setFlags(intent.getFlags() & (-2));
        }

        static void a(Intent intent, ArrayList<Uri> arrayList) {
            CharSequence charSequenceExtra = intent.getCharSequenceExtra(Intent.EXTRA_TEXT);
            String stringExtra = intent.getStringExtra("android.intent.extra.HTML_TEXT");
            ClipData clipData = new ClipData(null, new String[]{intent.getType()}, new ClipData.Item(charSequenceExtra, stringExtra, null, arrayList.get(0)));
            int size = arrayList.size();
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    intent.setClipData(clipData);
                    intent.addFlags(1);
                    return;
                }
                clipData.addItem(new ClipData.Item(arrayList.get(i2)));
                i = i2 + 1;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/ShareCompat$IntentBuilder.class */
    public static class IntentBuilder {

        /* renamed from: a  reason: collision with root package name */
        private final Context f2347a;
        private final Intent b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f2348c;
        private ArrayList<String> d;
        private ArrayList<String> e;
        private ArrayList<String> f;
        private ArrayList<Uri> g;

        public IntentBuilder(Context context) {
            Activity activity;
            this.f2347a = (Context) Preconditions.checkNotNull(context);
            Intent action = new Intent().setAction(Intent.ACTION_SEND);
            this.b = action;
            action.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, context.getPackageName());
            this.b.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE_INTEROP, context.getPackageName());
            this.b.addFlags(524288);
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                } else if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (activity != null) {
                ComponentName componentName = activity.getComponentName();
                this.b.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, componentName);
                this.b.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY_INTEROP, componentName);
            }
        }

        private void a(String str, ArrayList<String> arrayList) {
            String[] stringArrayExtra = this.b.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr = new String[arrayList.size() + length];
            arrayList.toArray(strArr);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
            }
            this.b.putExtra(str, strArr);
        }

        private void a(String str, String[] strArr) {
            Intent intent = getIntent();
            String[] stringArrayExtra = intent.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr2 = new String[strArr.length + length];
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr2, 0, length);
            }
            System.arraycopy(strArr, 0, strArr2, length, strArr.length);
            intent.putExtra(str, strArr2);
        }

        @Deprecated
        public static IntentBuilder from(Activity activity) {
            return new IntentBuilder(activity);
        }

        public IntentBuilder addEmailBcc(String str) {
            if (this.f == null) {
                this.f = new ArrayList<>();
            }
            this.f.add(str);
            return this;
        }

        public IntentBuilder addEmailBcc(String[] strArr) {
            a(Intent.EXTRA_BCC, strArr);
            return this;
        }

        public IntentBuilder addEmailCc(String str) {
            if (this.e == null) {
                this.e = new ArrayList<>();
            }
            this.e.add(str);
            return this;
        }

        public IntentBuilder addEmailCc(String[] strArr) {
            a(Intent.EXTRA_CC, strArr);
            return this;
        }

        public IntentBuilder addEmailTo(String str) {
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
            this.d.add(str);
            return this;
        }

        public IntentBuilder addEmailTo(String[] strArr) {
            a(Intent.EXTRA_EMAIL, strArr);
            return this;
        }

        public IntentBuilder addStream(Uri uri) {
            if (this.g == null) {
                this.g = new ArrayList<>();
            }
            this.g.add(uri);
            return this;
        }

        public Intent createChooserIntent() {
            return Intent.createChooser(getIntent(), this.f2348c);
        }

        Context getContext() {
            return this.f2347a;
        }

        public Intent getIntent() {
            ArrayList<String> arrayList = this.d;
            if (arrayList != null) {
                a(Intent.EXTRA_EMAIL, arrayList);
                this.d = null;
            }
            ArrayList<String> arrayList2 = this.e;
            if (arrayList2 != null) {
                a(Intent.EXTRA_CC, arrayList2);
                this.e = null;
            }
            ArrayList<String> arrayList3 = this.f;
            if (arrayList3 != null) {
                a(Intent.EXTRA_BCC, arrayList3);
                this.f = null;
            }
            ArrayList<Uri> arrayList4 = this.g;
            boolean z = true;
            if (arrayList4 == null || arrayList4.size() <= 1) {
                z = false;
            }
            if (z) {
                this.b.setAction(Intent.ACTION_SEND_MULTIPLE);
                this.b.putParcelableArrayListExtra(Intent.EXTRA_STREAM, this.g);
                if (Build.VERSION.SDK_INT >= 16) {
                    Api16Impl.a(this.b, this.g);
                }
            } else {
                this.b.setAction(Intent.ACTION_SEND);
                ArrayList<Uri> arrayList5 = this.g;
                if (arrayList5 == null || arrayList5.isEmpty()) {
                    this.b.removeExtra(Intent.EXTRA_STREAM);
                    if (Build.VERSION.SDK_INT >= 16) {
                        Api16Impl.a(this.b);
                    }
                } else {
                    this.b.putExtra(Intent.EXTRA_STREAM, this.g.get(0));
                    if (Build.VERSION.SDK_INT >= 16) {
                        Api16Impl.a(this.b, this.g);
                    }
                }
            }
            return this.b;
        }

        public IntentBuilder setChooserTitle(int i) {
            return setChooserTitle(this.f2347a.getText(i));
        }

        public IntentBuilder setChooserTitle(CharSequence charSequence) {
            this.f2348c = charSequence;
            return this;
        }

        public IntentBuilder setEmailBcc(String[] strArr) {
            this.b.putExtra(Intent.EXTRA_BCC, strArr);
            return this;
        }

        public IntentBuilder setEmailCc(String[] strArr) {
            this.b.putExtra(Intent.EXTRA_CC, strArr);
            return this;
        }

        public IntentBuilder setEmailTo(String[] strArr) {
            if (this.d != null) {
                this.d = null;
            }
            this.b.putExtra(Intent.EXTRA_EMAIL, strArr);
            return this;
        }

        public IntentBuilder setHtmlText(String str) {
            this.b.putExtra("android.intent.extra.HTML_TEXT", str);
            if (!this.b.hasExtra(Intent.EXTRA_TEXT)) {
                setText(Html.fromHtml(str));
            }
            return this;
        }

        public IntentBuilder setStream(Uri uri) {
            this.g = null;
            if (uri != null) {
                addStream(uri);
            }
            return this;
        }

        public IntentBuilder setSubject(String str) {
            this.b.putExtra(Intent.EXTRA_SUBJECT, str);
            return this;
        }

        public IntentBuilder setText(CharSequence charSequence) {
            this.b.putExtra(Intent.EXTRA_TEXT, charSequence);
            return this;
        }

        public IntentBuilder setType(String str) {
            this.b.setType(str);
            return this;
        }

        public void startChooser() {
            this.f2347a.startActivity(createChooserIntent());
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/ShareCompat$IntentReader.class */
    public static class IntentReader {

        /* renamed from: a  reason: collision with root package name */
        private final Context f2349a;
        private final Intent b;

        /* renamed from: c  reason: collision with root package name */
        private final String f2350c;
        private final ComponentName d;
        private ArrayList<Uri> e;

        public IntentReader(Activity activity) {
            this((Context) Preconditions.checkNotNull(activity), activity.getIntent());
        }

        public IntentReader(Context context, Intent intent) {
            this.f2349a = (Context) Preconditions.checkNotNull(context);
            this.b = (Intent) Preconditions.checkNotNull(intent);
            this.f2350c = ShareCompat.a(intent);
            this.d = ShareCompat.b(intent);
        }

        private static void a(StringBuilder sb, CharSequence charSequence, int i, int i2) {
            while (i < i2) {
                char charAt = charSequence.charAt(i);
                if (charAt == '<') {
                    sb.append("&lt;");
                } else if (charAt == '>') {
                    sb.append("&gt;");
                } else if (charAt == '&') {
                    sb.append("&amp;");
                } else if (charAt > '~' || charAt < ' ') {
                    sb.append("&#");
                    sb.append((int) charAt);
                    sb.append(t.aE);
                } else if (charAt == ' ') {
                    while (true) {
                        int i3 = i + 1;
                        if (i3 >= i2 || charSequence.charAt(i3) != ' ') {
                            break;
                        }
                        sb.append("&nbsp;");
                        i = i3;
                    }
                    sb.append(' ');
                } else {
                    sb.append(charAt);
                }
                i++;
            }
        }

        @Deprecated
        public static IntentReader from(Activity activity) {
            return new IntentReader(activity);
        }

        public ComponentName getCallingActivity() {
            return this.d;
        }

        public Drawable getCallingActivityIcon() {
            if (this.d == null) {
                return null;
            }
            try {
                return this.f2349a.getPackageManager().getActivityIcon(this.d);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("IntentReader", "Could not retrieve icon for calling activity", e);
                return null;
            }
        }

        public Drawable getCallingApplicationIcon() {
            if (this.f2350c == null) {
                return null;
            }
            try {
                return this.f2349a.getPackageManager().getApplicationIcon(this.f2350c);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("IntentReader", "Could not retrieve icon for calling application", e);
                return null;
            }
        }

        public CharSequence getCallingApplicationLabel() {
            if (this.f2350c == null) {
                return null;
            }
            PackageManager packageManager = this.f2349a.getPackageManager();
            try {
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.f2350c, 0));
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("IntentReader", "Could not retrieve label for calling application", e);
                return null;
            }
        }

        public String getCallingPackage() {
            return this.f2350c;
        }

        public String[] getEmailBcc() {
            return this.b.getStringArrayExtra(Intent.EXTRA_BCC);
        }

        public String[] getEmailCc() {
            return this.b.getStringArrayExtra(Intent.EXTRA_CC);
        }

        public String[] getEmailTo() {
            return this.b.getStringArrayExtra(Intent.EXTRA_EMAIL);
        }

        public String getHtmlText() {
            String stringExtra = this.b.getStringExtra("android.intent.extra.HTML_TEXT");
            String str = stringExtra;
            if (stringExtra == null) {
                CharSequence text = getText();
                if (text instanceof Spanned) {
                    return Html.toHtml((Spanned) text);
                }
                str = stringExtra;
                if (text != null) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        return Html.escapeHtml(text);
                    }
                    StringBuilder sb = new StringBuilder();
                    a(sb, text, 0, text.length());
                    str = sb.toString();
                }
            }
            return str;
        }

        public Uri getStream() {
            return (Uri) this.b.getParcelableExtra(Intent.EXTRA_STREAM);
        }

        public Uri getStream(int i) {
            if (this.e == null && isMultipleShare()) {
                this.e = this.b.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
            }
            ArrayList<Uri> arrayList = this.e;
            if (arrayList != null) {
                return arrayList.get(i);
            }
            if (i == 0) {
                return (Uri) this.b.getParcelableExtra(Intent.EXTRA_STREAM);
            }
            throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + i);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        public int getStreamCount() {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        public String getSubject() {
            return this.b.getStringExtra(Intent.EXTRA_SUBJECT);
        }

        public CharSequence getText() {
            return this.b.getCharSequenceExtra(Intent.EXTRA_TEXT);
        }

        public String getType() {
            return this.b.getType();
        }

        public boolean isMultipleShare() {
            return Intent.ACTION_SEND_MULTIPLE.equals(this.b.getAction());
        }

        public boolean isShareIntent() {
            String action = this.b.getAction();
            return Intent.ACTION_SEND.equals(action) || Intent.ACTION_SEND_MULTIPLE.equals(action);
        }

        public boolean isSingleShare() {
            return Intent.ACTION_SEND.equals(this.b.getAction());
        }
    }

    private ShareCompat() {
    }

    static String a(Intent intent) {
        String stringExtra = intent.getStringExtra(EXTRA_CALLING_PACKAGE);
        String str = stringExtra;
        if (stringExtra == null) {
            str = intent.getStringExtra(EXTRA_CALLING_PACKAGE_INTEROP);
        }
        return str;
    }

    static ComponentName b(Intent intent) {
        ComponentName componentName = (ComponentName) intent.getParcelableExtra(EXTRA_CALLING_ACTIVITY);
        ComponentName componentName2 = componentName;
        if (componentName == null) {
            componentName2 = (ComponentName) intent.getParcelableExtra(EXTRA_CALLING_ACTIVITY_INTEROP);
        }
        return componentName2;
    }

    @Deprecated
    public static void configureMenuItem(Menu menu, int i, IntentBuilder intentBuilder) {
        MenuItem findItem = menu.findItem(i);
        if (findItem != null) {
            configureMenuItem(findItem, intentBuilder);
            return;
        }
        throw new IllegalArgumentException("Could not find menu item with id " + i + " in the supplied menu");
    }

    @Deprecated
    public static void configureMenuItem(MenuItem menuItem, IntentBuilder intentBuilder) {
        ActionProvider actionProvider = menuItem.getActionProvider();
        ShareActionProvider shareActionProvider = !(actionProvider instanceof ShareActionProvider) ? new ShareActionProvider(intentBuilder.getContext()) : (ShareActionProvider) actionProvider;
        shareActionProvider.setShareHistoryFileName(".sharecompat_" + intentBuilder.getContext().getClass().getName());
        shareActionProvider.setShareIntent(intentBuilder.getIntent());
        menuItem.setActionProvider(shareActionProvider);
        if (Build.VERSION.SDK_INT >= 16 || menuItem.hasSubMenu()) {
            return;
        }
        menuItem.setIntent(intentBuilder.createChooserIntent());
    }

    public static ComponentName getCallingActivity(Activity activity) {
        Intent intent = activity.getIntent();
        ComponentName callingActivity = activity.getCallingActivity();
        ComponentName componentName = callingActivity;
        if (callingActivity == null) {
            componentName = b(intent);
        }
        return componentName;
    }

    public static String getCallingPackage(Activity activity) {
        Intent intent = activity.getIntent();
        String callingPackage = activity.getCallingPackage();
        String str = callingPackage;
        if (callingPackage == null) {
            str = callingPackage;
            if (intent != null) {
                str = a(intent);
            }
        }
        return str;
    }
}
