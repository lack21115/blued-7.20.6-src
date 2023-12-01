package android.text.method;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;

/* loaded from: source-9557208-dex2jar.jar:android/text/method/CharacterPickerDialog.class */
public class CharacterPickerDialog extends Dialog implements AdapterView.OnItemClickListener, View.OnClickListener {
    private Button mCancelButton;
    private LayoutInflater mInflater;
    private boolean mInsert;
    private String mOptions;
    private Editable mText;
    private View mView;

    /* loaded from: source-9557208-dex2jar.jar:android/text/method/CharacterPickerDialog$OptionsAdapter.class */
    private class OptionsAdapter extends BaseAdapter {
        public OptionsAdapter(Context context) {
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            return CharacterPickerDialog.this.mOptions.length();
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i) {
            return String.valueOf(CharacterPickerDialog.this.mOptions.charAt(i));
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            Button button = (Button) CharacterPickerDialog.this.mInflater.inflate(17367099, (ViewGroup) null);
            button.setText(String.valueOf(CharacterPickerDialog.this.mOptions.charAt(i)));
            button.setOnClickListener(CharacterPickerDialog.this);
            return button;
        }
    }

    public CharacterPickerDialog(Context context, View view, Editable editable, String str, boolean z) {
        super(context, R.style.Theme_Panel);
        this.mView = view;
        this.mText = editable;
        this.mOptions = str;
        this.mInsert = z;
        this.mInflater = LayoutInflater.from(context);
    }

    private void replaceCharacterAndClose(CharSequence charSequence) {
        int selectionEnd = Selection.getSelectionEnd(this.mText);
        if (this.mInsert || selectionEnd == 0) {
            this.mText.insert(selectionEnd, charSequence);
        } else {
            this.mText.replace(selectionEnd - 1, selectionEnd, charSequence);
        }
        dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mCancelButton) {
            dismiss();
        } else if (view instanceof Button) {
            replaceCharacterAndClose(((Button) view).getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.token = this.mView.getApplicationWindowToken();
        attributes.type = 1003;
        attributes.flags |= 1;
        setContentView(17367098);
        GridView gridView = (GridView) findViewById(16909026);
        gridView.setAdapter((ListAdapter) new OptionsAdapter(getContext()));
        gridView.setOnItemClickListener(this);
        this.mCancelButton = (Button) findViewById(16909027);
        this.mCancelButton.setOnClickListener(this);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        replaceCharacterAndClose(String.valueOf(this.mOptions.charAt(i)));
    }
}
