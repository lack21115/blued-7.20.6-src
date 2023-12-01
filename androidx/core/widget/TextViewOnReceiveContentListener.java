package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/widget/TextViewOnReceiveContentListener.class */
public final class TextViewOnReceiveContentListener implements OnReceiveContentListener {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/widget/TextViewOnReceiveContentListener$Api16Impl.class */
    public static final class Api16Impl {
        private Api16Impl() {
        }

        static CharSequence a(Context context, ClipData.Item item, int i) {
            if ((i & 1) != 0) {
                CharSequence coerceToText = item.coerceToText(context);
                String str = coerceToText;
                if (coerceToText instanceof Spanned) {
                    str = coerceToText.toString();
                }
                return str;
            }
            return item.coerceToStyledText(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/widget/TextViewOnReceiveContentListener$ApiImpl.class */
    public static final class ApiImpl {
        private ApiImpl() {
        }

        static CharSequence a(Context context, ClipData.Item item, int i) {
            CharSequence coerceToText = item.coerceToText(context);
            String str = coerceToText;
            if ((i & 1) != 0) {
                str = coerceToText;
                if (coerceToText instanceof Spanned) {
                    str = coerceToText.toString();
                }
            }
            return str;
        }
    }

    private static CharSequence a(Context context, ClipData.Item item, int i) {
        return Build.VERSION.SDK_INT >= 16 ? Api16Impl.a(context, item, i) : ApiImpl.a(context, item, i);
    }

    private static void a(Editable editable, CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int max = Math.max(0, Math.min(selectionStart, selectionEnd));
        int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, max2);
        editable.replace(max, max2, charSequence);
    }

    @Override // androidx.core.view.OnReceiveContentListener
    public ContentInfoCompat onReceiveContent(View view, ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable("ReceiveContent", 3)) {
            Log.d("ReceiveContent", "onReceive: " + contentInfoCompat);
        }
        if (contentInfoCompat.getSource() == 2) {
            return contentInfoCompat;
        }
        ClipData clip = contentInfoCompat.getClip();
        int flags = contentInfoCompat.getFlags();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        int i = 0;
        boolean z = false;
        while (true) {
            boolean z2 = z;
            if (i >= clip.getItemCount()) {
                return null;
            }
            CharSequence a2 = a(context, clip.getItemAt(i), flags);
            boolean z3 = z2;
            if (a2 != null) {
                if (z2) {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), a2);
                    z3 = z2;
                } else {
                    a(editable, a2);
                    z3 = true;
                }
            }
            i++;
            z = z3;
        }
    }
}
