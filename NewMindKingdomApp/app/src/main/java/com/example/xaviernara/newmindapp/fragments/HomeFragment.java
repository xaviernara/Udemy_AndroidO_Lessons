package com.example.xaviernara.newmindapp.fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.xaviernara.newmindapp.BeliefsActivity;
import com.example.xaviernara.newmindapp.CrestInfo;
import com.example.xaviernara.newmindapp.GivingWays;
import com.example.xaviernara.newmindapp.LocationActivity;
import com.example.xaviernara.newmindapp.PastorBiography;
import com.example.xaviernara.newmindapp.R;
import com.example.xaviernara.newmindapp.ServiceTimes;
import com.example.xaviernara.newmindapp.SevenRConcept;
import com.example.xaviernara.newmindapp.VisionStatement;
import com.example.xaviernara.newmindapp.databinding.FragmentBeliefsBinding;
import com.example.xaviernara.newmindapp.databinding.FragmentHomeBinding;

import java.util.Random;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    Random generator = new Random();

    Intent intent;

    private NavDirections action;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int[] images = {R.drawable.home_gallery1,R.drawable.home_gallery2,R.drawable.home_gallery3,R.drawable.home_gallery4,R.drawable.home_gallery5,R.drawable.home_gallery6,
                R.drawable.home_gallery7,R.drawable.home_gallery8,R.drawable.home_gallery9,R.drawable.home_gallery10,R.drawable.home_gallery11,R.drawable.home_gallery12};
        for(int i = 0; i<images.length;i++){
            int randomImage = generator.nextInt(images.length);
            flipperImages(images[randomImage]);

        }

    }

    public void flipperImages (int image){

        ImageView imageView = new ImageView(binding.getRoot().getContext());
        imageView.setBackgroundResource(image);

        binding.viewFlipper.addView(imageView);
        binding.viewFlipper.setFlipInterval(15000); // 15 seconds
        binding.viewFlipper.setAutoStart(true);

        //animation
        binding.viewFlipper.setInAnimation(binding.getRoot().getContext(),android.R.anim.slide_in_left);
        binding.viewFlipper.setOutAnimation(binding.getRoot().getContext(),android.R.anim.slide_out_right);
    }

    public void previousSermonsOnClick(View view) {
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCyu_YbjuDswWIPD8YD4YR8w"));
        startActivity(intent);
    }

    public void websiteOnClick(View view) {
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://newmindkingdom.org"));
        startActivity(intent);
        //finish();
    }

    public void sevenROnClick(View view) {
        action = HomeFragmentDirections.actionHomeFragment2ToSevenRFragment();
        Navigation.findNavController(view).navigate(action);
    }

    public void clockOnClick(View view) {
        action = HomeFragmentDirections.actionHomeFragment2ToClockFragment();
        Navigation.findNavController(view).navigate(action);
    }

    public void visionOnClick(View view) {
        action = HomeFragmentDirections.actionHomeFragment2ToSevenRFragment();
        Navigation.findNavController(view).navigate(action);
        // finish();
    }

    public void crestOnClick(View view) {
        action = HomeFragmentDirections.actionHomeFragment2ToCrestInfoFragment();
        Navigation.findNavController(view).navigate(action);
    }

    public void givingOnClick(View view) {
        action = HomeFragmentDirections.actionHomeFragment2ToGivingFragment();
        Navigation.findNavController(view).navigate(action);
    }

    public void pastorOnClick(View view) {
        action = HomeFragmentDirections.actionHomeFragment2ToPastorBioFragment();
        Navigation.findNavController(view).navigate(action);
    }

    public void beliefsOnClick(View view) {
        action = HomeFragmentDirections.actionHomeFragment2ToBeliefsFragment();
        Navigation.findNavController(view).navigate(action);
    }

    public void locationOnClick(View view){

        action = HomeFragmentDirections.actionHomeFragment2ToLocationActivity();
        Navigation.findNavController((View) action);
    }

    //https://www.tutorialspoint.com/android/android_phone_calls.htm
    public void phoneOnClick(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel: +2198032331"));
        if (ActivityCompat.checkSelfPermission(binding.getRoot().getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(callIntent);
    }
}
