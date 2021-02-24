package com.material_ui.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;

import com.material_ui.R;


public final class ModalDialogs {

    public static Dialog showChoiceDialog(@NonNull Activity activity, int titleResourceId, CharSequence[] choices, DialogInterface.OnClickListener clickListener) {
        if (activity.isFinishing()) {
            return null;
        }

        AppCompatDialog dialog = new AlertDialog.Builder(activity, R.style.AlertDialogStyle)
                .setTitle(titleResourceId)
                .setNegativeButton(android.R.string.cancel, null)
                .setItems(choices, clickListener)
                .create();
        dialog.show();

        return dialog;
    }

    public static Dialog showSingleButtonDialog(@NonNull Activity activity, @StringRes int title, @StringRes int message, @StringRes int button, @Nullable ButtonClickListener buttonClickListener) {
        if (activity.isFinishing()) {
            return null;
        }

        AppCompatDialog dialog = new AlertDialog.Builder(activity, R.style.AlertDialogStyle)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(button, buttonClickListener)
                .create();
        dialog.show();

        return dialog;
    }

    public static Dialog showAppUpdateDialog(@NonNull Activity activity, @StringRes int title, @StringRes int message, @StringRes int button, @Nullable ButtonClickListener buttonClickListener) {
        if (activity.isFinishing()) {
            return null;
        }

        AppCompatDialog dialog = new AlertDialog.Builder(activity, R.style.AlertDialogStyle)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(button, buttonClickListener)
                .setCancelable(false)
                .create();
        dialog.show();

        return dialog;
    }

    public static Dialog showConfirmationDialog(@NonNull Activity activity, @StringRes int title, @StringRes int message, @StringRes int negativeButton, @StringRes int positiveButton, @Nullable ButtonClickListener buttonClickListener) {
        return showDialog(activity, title, message, negativeButton, positiveButton, true, buttonClickListener);
    }

    public static Dialog showConfirmationDialog(@NonNull Activity activity, @StringRes int title, String message, @StringRes int negativeButton, @StringRes int positiveButton, @Nullable ButtonClickListener buttonClickListener) {
        return showDialog(activity, title, message, negativeButton, positiveButton, true, buttonClickListener);
    }

    public static Dialog showDialog(@NonNull Activity activity, @StringRes int title, @StringRes int message, @StringRes int negativeButton, @StringRes int positiveButton, boolean isCancelable, @Nullable ButtonClickListener buttonClickListener) {
        if (activity.isFinishing()) {
            return null;
        }

        AppCompatDialog dialog = new AlertDialog.Builder(activity, R.style.AlertDialogStyle)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(isCancelable)
                .setPositiveButton(positiveButton, buttonClickListener)
                .setNegativeButton(negativeButton, buttonClickListener)
                .create();
        dialog.show();

        return dialog;
    }

    public static Dialog showDialog(@NonNull Activity activity, @StringRes int title, String message, @StringRes int negativeButton, @StringRes int positiveButton, boolean isCancelable, @Nullable ButtonClickListener buttonClickListener) {
        if (activity.isFinishing()) {
            return null;
        }

        AppCompatDialog dialog = new AlertDialog.Builder(activity, R.style.AlertDialogStyle)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(isCancelable)
                .setPositiveButton(positiveButton, buttonClickListener)
                .setNegativeButton(negativeButton, buttonClickListener)
                .create();
        dialog.show();

        return dialog;
    }

    public static Dialog showSingleMessageDialog(@NonNull Activity activity, @StringRes int message) {
        return showDialog(activity, View.NO_ID, message);
    }


    public static Dialog showDialog(@NonNull Activity activity, @StringRes int title, @StringRes int message) {
        return showOkButtonDialog(activity, title != View.NO_ID ? activity.getString(title) : null, activity.getString(message), View.NO_ID);
    }

    public static Dialog showDialogNonCancellable(@NonNull Activity activity, @StringRes int title, @StringRes int message) {
        return showDialogNonCancellable(activity, title != View.NO_ID ? activity.getString(title) : null, activity.getString(message), null);
    }


    public static Dialog showUnknownError(@NonNull Activity activity) {
        return showDialog(activity, R.string.error, R.string.unknown_error);
    }

    public static Dialog showDialogNonCancellable(@NonNull Activity activity, @Nullable String title, String message, @Nullable ButtonClickListener buttonClickListener) {
        if (activity.isFinishing()) {
            return null;
        }

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity, R.style.AlertDialogStyle)
                .setPositiveButton(android.R.string.ok, buttonClickListener)
                .setCancelable(false)
                .setMessage(message);

        if (null != title) {
            dialogBuilder.setTitle(title);
        }

        Dialog dialog = dialogBuilder.create();
        dialog.show();

        return dialog;
    }

    public static Dialog showOkButtonDialog(@NonNull Activity activity, @Nullable String title, String message, @LayoutRes int layoutRes) {
        if (activity.isFinishing()) {
            return null;
        }
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity)
                .setPositiveButton(android.R.string.ok, (dialog, which) -> dialog.dismiss())
                .setMessage(message);

        if (View.NO_ID != layoutRes) {
            dialogBuilder.setView(layoutRes);
        }

        if (null != title) {
            dialogBuilder.setTitle(title);
        }
        Dialog dialog = dialogBuilder.create();


        dialog.show();

        return dialog;
    }

    public static Dialog showDialog(@NonNull Activity activity, @Nullable String title, String message, @Nullable ButtonClickListener buttonClickListener, @LayoutRes int layoutRes) {
        if (activity.isFinishing()) {
            return null;
        }

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity, R.style.AlertDialogStyle)
                .setPositiveButton(android.R.string.ok, buttonClickListener)
                .setMessage(message);

        if (View.NO_ID != layoutRes) {
            dialogBuilder.setView(layoutRes);
        }

        if (null != title) {
            dialogBuilder.setTitle(title);
        }

        Dialog dialog = dialogBuilder.create();
        dialog.show();

        return dialog;
    }

    public static Dialog showDialog(@NonNull Activity activity, @Nullable String title, String message, @Nullable ButtonClickListener buttonClickListener) {
        if (activity.isFinishing()) {
            return null;
        }

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity, R.style.AlertDialogStyle)
                .setPositiveButton(android.R.string.ok, buttonClickListener)
                .setMessage(message);

        if (null != title) {
            dialogBuilder.setTitle(title);
        }

        Dialog dialog = dialogBuilder.create();
        dialog.show();

        return dialog;
    }

    public static Dialog showNoNetworkDialog(@NonNull final Activity activity) {
        return showNoNetworkDialog(activity, null);
    }

    public static Dialog showNoNetworkDialog(@NonNull final Activity activity, @Nullable ButtonClickListener buttonClickListener) {
        if (activity.isFinishing()) {
            return null;
        }

        if (null == buttonClickListener) {
            buttonClickListener = new ButtonClickListener() {
                @Override
                public void onPositiveClick() {
                    activity.startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
                }
            };
        }

        AppCompatDialog dialog = new AlertDialog.Builder(activity, R.style.AlertDialogStyle)
                .setCancelable(false)
                .setTitle(R.string.title_error_network_connection)
                .setNegativeButton(android.R.string.cancel, buttonClickListener)
                .setPositiveButton(R.string.error_network_connection_settings, buttonClickListener)
                .setMessage(R.string.error_network_connection_message)
                .create();
        dialog.show();

        return dialog;
    }

    public static Dialog showSimpleErrorDialog(@NonNull Activity activity, int errorTextResourceId) {
        return showSimpleErrorDialog(activity, activity.getResources().getString(errorTextResourceId));
    }

    public static Dialog showSimpleErrorDialog(@NonNull Activity activity, String errorMessage) {
        if (activity.isFinishing()) {
            return null;
        }

        AppCompatDialog dialog = new AlertDialog.Builder(activity, R.style.AlertDialogStyle)
                .setTitle(R.string.default_error)
                .setNeutralButton(android.R.string.ok, null)
                .setMessage(errorMessage)
                .create();
        dialog.show();

        return dialog;
    }


    public static void showDialogWithView(Activity activity, @StringRes int title, @StringRes int positiveButtonText, View view, ButtonClickListener buttonClickListener) {
        if (activity == null || activity.isFinishing()) {
            return;
        }

        AppCompatDialog dialog = new AlertDialog.Builder(activity, R.style.AlertDialogStyle)
                .setTitle(title)
                .setPositiveButton(positiveButtonText, buttonClickListener)
                .setNegativeButton(android.R.string.cancel, null)
                .setMessage(null)
                .setView(view)
                .create();
        dialog.show();
    }

    public static void showUnauthorizedError(@NonNull Activity activity, @Nullable String title, String message, @Nullable ButtonClickListener buttonClickListener) {
        if (activity.isFinishing()) {
            return;
        }

        activity.runOnUiThread(() -> {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity, R.style.AlertDialogStyle)
                    .setPositiveButton(android.R.string.ok, buttonClickListener)
                    .setCancelable(false)
                    .setMessage(message);

            if (null != title) {
                dialogBuilder.setTitle(title);
            }

            Dialog dialog = dialogBuilder.create();
            dialog.show();
        });
    }

    public static class ButtonClickListener
            implements
            DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    onPositiveClick();
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    onNegativeClick();
                    break;
            }
        }

        public void onPositiveClick() {

        }

        public void onNegativeClick() {

        }
    }

}
