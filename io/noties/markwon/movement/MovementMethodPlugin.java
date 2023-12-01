package io.noties.markwon.movement;

import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.widget.TextView;
import io.noties.markwon.AbstractMarkwonPlugin;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/movement/MovementMethodPlugin.class */
public class MovementMethodPlugin extends AbstractMarkwonPlugin {
    private final MovementMethod movementMethod;

    MovementMethodPlugin(MovementMethod movementMethod) {
        this.movementMethod = movementMethod;
    }

    public static MovementMethodPlugin create() {
        return create(LinkMovementMethod.getInstance());
    }

    public static MovementMethodPlugin create(MovementMethod movementMethod) {
        return new MovementMethodPlugin(movementMethod);
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void beforeSetText(TextView textView, Spanned spanned) {
        textView.setMovementMethod(this.movementMethod);
    }
}
