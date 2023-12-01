package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.View;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/accessibility/AccessibilityViewCommand.class */
public interface AccessibilityViewCommand {

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/accessibility/AccessibilityViewCommand$CommandArguments.class */
    public static abstract class CommandArguments {

        /* renamed from: a  reason: collision with root package name */
        Bundle f2731a;

        public void setBundle(Bundle bundle) {
            this.f2731a = bundle;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/accessibility/AccessibilityViewCommand$MoveAtGranularityArguments.class */
    public static final class MoveAtGranularityArguments extends CommandArguments {
        public boolean getExtendSelection() {
            return this.f2731a.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        }

        public int getGranularity() {
            return this.f2731a.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/accessibility/AccessibilityViewCommand$MoveHtmlArguments.class */
    public static final class MoveHtmlArguments extends CommandArguments {
        public String getHTMLElement() {
            return this.f2731a.getString("ACTION_ARGUMENT_HTML_ELEMENT_STRING");
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/accessibility/AccessibilityViewCommand$MoveWindowArguments.class */
    public static final class MoveWindowArguments extends CommandArguments {
        public int getX() {
            return this.f2731a.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_MOVE_WINDOW_X);
        }

        public int getY() {
            return this.f2731a.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_MOVE_WINDOW_Y);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/accessibility/AccessibilityViewCommand$ScrollToPositionArguments.class */
    public static final class ScrollToPositionArguments extends CommandArguments {
        public int getColumn() {
            return this.f2731a.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_COLUMN_INT);
        }

        public int getRow() {
            return this.f2731a.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_ROW_INT);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/accessibility/AccessibilityViewCommand$SetProgressArguments.class */
    public static final class SetProgressArguments extends CommandArguments {
        public float getProgress() {
            return this.f2731a.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/accessibility/AccessibilityViewCommand$SetSelectionArguments.class */
    public static final class SetSelectionArguments extends CommandArguments {
        public int getEnd() {
            return this.f2731a.getInt("ACTION_ARGUMENT_SELECTION_END_INT");
        }

        public int getStart() {
            return this.f2731a.getInt("ACTION_ARGUMENT_SELECTION_START_INT");
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/accessibility/AccessibilityViewCommand$SetTextArguments.class */
    public static final class SetTextArguments extends CommandArguments {
        public CharSequence getText() {
            return this.f2731a.getCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
        }
    }

    boolean perform(View view, CommandArguments commandArguments);
}
