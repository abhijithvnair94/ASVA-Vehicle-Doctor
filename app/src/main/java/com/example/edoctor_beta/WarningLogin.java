package com.example.edoctor_beta;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;

public class WarningLogin extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()); //creating alert dialog box
        builder.setTitle("Warning")//create our extra dialog
               .setMessage("Exceeds")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }); // in this onCLick we are not doing any thing, ie when we click ok it will just get close.

        return builder.create();
    }
}
