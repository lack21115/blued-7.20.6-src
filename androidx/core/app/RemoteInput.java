package androidx.core.app;

import android.app.RemoteInput;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/app/RemoteInput.class */
public final class RemoteInput {
    public static final int EDIT_CHOICES_BEFORE_SENDING_AUTO = 0;
    public static final int EDIT_CHOICES_BEFORE_SENDING_DISABLED = 1;
    public static final int EDIT_CHOICES_BEFORE_SENDING_ENABLED = 2;
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    public static final int SOURCE_CHOICE = 1;
    public static final int SOURCE_FREE_FORM_INPUT = 0;

    /* renamed from: a  reason: collision with root package name */
    private final String f2343a;
    private final CharSequence b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence[] f2344c;
    private final boolean d;
    private final int e;
    private final Bundle f;
    private final Set<String> g;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/RemoteInput$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final String f2345a;
        private CharSequence d;
        private CharSequence[] e;
        private final Set<String> b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private final Bundle f2346c = new Bundle();
        private boolean f = true;
        private int g = 0;

        public Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.f2345a = str;
        }

        public Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                this.f2346c.putAll(bundle);
            }
            return this;
        }

        public RemoteInput build() {
            return new RemoteInput(this.f2345a, this.d, this.e, this.f, this.g, this.f2346c, this.b);
        }

        public Bundle getExtras() {
            return this.f2346c;
        }

        public Builder setAllowDataType(String str, boolean z) {
            if (z) {
                this.b.add(str);
                return this;
            }
            this.b.remove(str);
            return this;
        }

        public Builder setAllowFreeFormInput(boolean z) {
            this.f = z;
            return this;
        }

        public Builder setChoices(CharSequence[] charSequenceArr) {
            this.e = charSequenceArr;
            return this;
        }

        public Builder setEditChoicesBeforeSending(int i) {
            this.g = i;
            return this;
        }

        public Builder setLabel(CharSequence charSequence) {
            this.d = charSequence;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/RemoteInput$EditChoicesBeforeSending.class */
    public @interface EditChoicesBeforeSending {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/RemoteInput$Source.class */
    public @interface Source {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoteInput(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, int i, Bundle bundle, Set<String> set) {
        this.f2343a = str;
        this.b = charSequence;
        this.f2344c = charSequenceArr;
        this.d = z;
        this.e = i;
        this.f = bundle;
        this.g = set;
        if (getEditChoicesBeforeSending() == 2 && !getAllowFreeFormInput()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    static android.app.RemoteInput a(RemoteInput remoteInput) {
        Set<String> allowedDataTypes;
        RemoteInput.Builder addExtras = new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras());
        if (Build.VERSION.SDK_INT >= 26 && (allowedDataTypes = remoteInput.getAllowedDataTypes()) != null) {
            for (String str : allowedDataTypes) {
                addExtras.setAllowDataType(str, true);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            addExtras.setEditChoicesBeforeSending(remoteInput.getEditChoicesBeforeSending());
        }
        return addExtras.build();
    }

    private static Intent a(Intent intent) {
        ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return null;
        }
        ClipDescription description = clipData.getDescription();
        if (description.hasMimeType(ClipDescription.MIMETYPE_TEXT_INTENT) && description.getLabel().toString().contentEquals("android.remoteinput.results")) {
            return clipData.getItemAt(0).getIntent();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RemoteInput a(android.app.RemoteInput remoteInput) {
        Set<String> allowedDataTypes;
        Builder addExtras = new Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras());
        if (Build.VERSION.SDK_INT >= 26 && (allowedDataTypes = remoteInput.getAllowedDataTypes()) != null) {
            for (String str : allowedDataTypes) {
                addExtras.setAllowDataType(str, true);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            addExtras.setEditChoicesBeforeSending(remoteInput.getEditChoicesBeforeSending());
        }
        return addExtras.build();
    }

    private static String a(String str) {
        return "android.remoteinput.dataTypeResultsData" + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static android.app.RemoteInput[] a(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= remoteInputArr.length) {
                return remoteInputArr2;
            }
            remoteInputArr2[i2] = a(remoteInputArr[i2]);
            i = i2 + 1;
        }
    }

    public static void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map<String, Uri> map) {
        if (Build.VERSION.SDK_INT >= 26) {
            android.app.RemoteInput.addDataResultToIntent(a(remoteInput), intent, map);
        } else if (Build.VERSION.SDK_INT >= 16) {
            Intent a2 = a(intent);
            Intent intent2 = a2;
            if (a2 == null) {
                intent2 = new Intent();
            }
            for (Map.Entry<String, Uri> entry : map.entrySet()) {
                String key = entry.getKey();
                Uri value = entry.getValue();
                if (key != null) {
                    Bundle bundleExtra = intent2.getBundleExtra(a(key));
                    Bundle bundle = bundleExtra;
                    if (bundleExtra == null) {
                        bundle = new Bundle();
                    }
                    bundle.putString(remoteInput.getResultKey(), value.toString());
                    intent2.putExtra(a(key), bundle);
                }
            }
            intent.setClipData(ClipData.newIntent("android.remoteinput.results", intent2));
        }
    }

    public static void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 26) {
            android.app.RemoteInput.addResultsToIntent(a(remoteInputArr), intent, bundle);
            return;
        }
        if (Build.VERSION.SDK_INT < 20) {
            if (Build.VERSION.SDK_INT >= 16) {
                Intent a2 = a(intent);
                Intent intent2 = a2;
                if (a2 == null) {
                    intent2 = new Intent();
                }
                Bundle bundleExtra = intent2.getBundleExtra("android.remoteinput.resultsData");
                Bundle bundle2 = bundleExtra;
                if (bundleExtra == null) {
                    bundle2 = new Bundle();
                }
                for (RemoteInput remoteInput : remoteInputArr) {
                    Object obj = bundle.get(remoteInput.getResultKey());
                    if (obj instanceof CharSequence) {
                        bundle2.putCharSequence(remoteInput.getResultKey(), (CharSequence) obj);
                    }
                }
                intent2.putExtra("android.remoteinput.resultsData", bundle2);
                intent.setClipData(ClipData.newIntent("android.remoteinput.results", intent2));
                return;
            }
            return;
        }
        Bundle resultsFromIntent = getResultsFromIntent(intent);
        int resultsSource = getResultsSource(intent);
        if (resultsFromIntent != null) {
            resultsFromIntent.putAll(bundle);
            bundle = resultsFromIntent;
        }
        int length = remoteInputArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                setResultsSource(intent, resultsSource);
                return;
            }
            RemoteInput remoteInput2 = remoteInputArr[i2];
            Map<String, Uri> dataResultsFromIntent = getDataResultsFromIntent(intent, remoteInput2.getResultKey());
            android.app.RemoteInput.addResultsToIntent(a(new RemoteInput[]{remoteInput2}), intent, bundle);
            if (dataResultsFromIntent != null) {
                addDataResultToIntent(remoteInput2, intent, dataResultsFromIntent);
            }
            i = i2 + 1;
        }
    }

    public static Map<String, Uri> getDataResultsFromIntent(Intent intent, String str) {
        String string;
        if (Build.VERSION.SDK_INT >= 26) {
            return android.app.RemoteInput.getDataResultsFromIntent(intent, str);
        }
        HashMap hashMap = null;
        if (Build.VERSION.SDK_INT >= 16) {
            Intent a2 = a(intent);
            if (a2 == null) {
                return null;
            }
            hashMap = new HashMap();
            for (String str2 : a2.getExtras().keySet()) {
                if (str2.startsWith("android.remoteinput.dataTypeResultsData")) {
                    String substring = str2.substring(39);
                    if (!substring.isEmpty() && (string = a2.getBundleExtra(str2).getString(str)) != null && !string.isEmpty()) {
                        hashMap.put(substring, Uri.parse(string));
                    }
                }
            }
            if (hashMap.isEmpty()) {
                return null;
            }
        }
        return hashMap;
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        Intent a2;
        if (Build.VERSION.SDK_INT >= 20) {
            return android.app.RemoteInput.getResultsFromIntent(intent);
        }
        if (Build.VERSION.SDK_INT < 16 || (a2 = a(intent)) == null) {
            return null;
        }
        return (Bundle) a2.getExtras().getParcelable("android.remoteinput.resultsData");
    }

    public static int getResultsSource(Intent intent) {
        Intent a2;
        if (Build.VERSION.SDK_INT >= 28) {
            return android.app.RemoteInput.getResultsSource(intent);
        }
        if (Build.VERSION.SDK_INT < 16 || (a2 = a(intent)) == null) {
            return 0;
        }
        return a2.getExtras().getInt("android.remoteinput.resultsSource", 0);
    }

    public static void setResultsSource(Intent intent, int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            android.app.RemoteInput.setResultsSource(intent, i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            Intent a2 = a(intent);
            Intent intent2 = a2;
            if (a2 == null) {
                intent2 = new Intent();
            }
            intent2.putExtra("android.remoteinput.resultsSource", i);
            intent.setClipData(ClipData.newIntent("android.remoteinput.results", intent2));
        }
    }

    public boolean getAllowFreeFormInput() {
        return this.d;
    }

    public Set<String> getAllowedDataTypes() {
        return this.g;
    }

    public CharSequence[] getChoices() {
        return this.f2344c;
    }

    public int getEditChoicesBeforeSending() {
        return this.e;
    }

    public Bundle getExtras() {
        return this.f;
    }

    public CharSequence getLabel() {
        return this.b;
    }

    public String getResultKey() {
        return this.f2343a;
    }

    public boolean isDataOnly() {
        if (getAllowFreeFormInput()) {
            return false;
        }
        return ((getChoices() != null && getChoices().length != 0) || getAllowedDataTypes() == null || getAllowedDataTypes().isEmpty()) ? false : true;
    }
}
