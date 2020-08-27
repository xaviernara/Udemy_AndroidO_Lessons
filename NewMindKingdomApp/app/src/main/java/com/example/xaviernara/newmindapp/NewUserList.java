package com.example.xaviernara.newmindapp;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class NewUserList extends ArrayAdapter<NewUserInfo> {

    private List<NewUserInfo> newUserList;
    private Activity context;

    public NewUserList(Activity context, int resource, List<NewUserInfo> newUserList, Activity context1) {
        super(context, resource);
        this.newUserList = newUserList;
        this.context = context1;
    }


    protected void onStart(){
        //super.onStart();

        SignUp signUp = new SignUp();
        signUp.getDatabaseNewUser();



    }
}
