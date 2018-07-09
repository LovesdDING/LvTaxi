package com.cz10000.lvtaxi.account.view;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by cz10000_001 on 2018/7/9.
 */

public class CreatePasswordDialog extends Dialog implements ICreatePasswordDialogView{



    public CreatePasswordDialog(@NonNull Context context) {
        super(context);
    }

    public CreatePasswordDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }



    @Override
    public void showLoading() {

    }

    @Override
    public void showError(int code, String msg) {

    }

    @Override
    public void showRegisterSuc() {

    }

    @Override
    public void showLoginSuc() {

    }

    @Override
    public void showPasswordnull() {

    }

    @Override
    public void showPasswordNotEqual() {

    }
}
