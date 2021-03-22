package com.example.xaviernara.newmindapp.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.xaviernara.newmindapp.databinding.FragmentGivingBinding;

public class GivingFragment extends Fragment {

    private FragmentGivingBinding binding;
    private Intent intent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void zelleWebsiteLink(View view){
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cash.app/$NewMindKingdom"));
        startActivity(intent);
    }

    public void paypalWebsiteLink(View view){
        //https://www.paypal.com/donate/?token=numoyRPrpVKFprADwgP4NJrQTT542020KToPYXY48rwoHtbDUT1OHb0U3fOVEBnzHpz8R0&country.x=US&locale.x=US
        //Intent paypalIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://newmindkingdom.org/give.html"));
       intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/donate/?token=numoyRPrpVKFprADwgP4NJrQTT542020KToPYXY48rwoHtbDUT1OHb0U3fOVEBnzHpz8R0&country.x=US&locale.x=US"));
        startActivity(intent);
    }
}
