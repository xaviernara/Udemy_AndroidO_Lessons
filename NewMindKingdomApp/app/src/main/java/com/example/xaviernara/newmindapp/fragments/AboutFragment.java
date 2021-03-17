package com.example.xaviernara.newmindapp.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.xaviernara.newmindapp.R;
import com.example.xaviernara.newmindapp.databinding.FragmentAboutBinding;
import com.example.xaviernara.newmindapp.databinding.FragmentBeliefsBinding;

public class AboutFragment extends Fragment {

   private FragmentAboutBinding binding;

  private Intent intent;


    String htmlText = "<p>New Mind Kingdom Ministries is a Life Skill teaching ministry with Destiny and a Destination in mind. Our focus and intent is to teach you the Word of God so that you can make it applicable to your everyday life. " +
            "“The Word works when YOU work it.” Wisdom is the correct application of knowledge. " +
            "Life is based on choices. Make wise choices, good life. Make foolish choices, foolish life.</p>\n" +
            "\n" +
            "<p>Deuteronomy 30:19 I call heaven and earth to record this day against you, that I have set before you life and death, blessing and cursing: therefore choose life, " +
            "that both thou and thy seed may live. We choose our life that consequently affects the lives around us. " +
            "Pastor Ward’s endeavor is to give you so much Word so that you may have ample amount of knowledge to apply wisdom in your choices to have an “Abundant life“  " +"</p>";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAboutBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Image slider in app:  https://youtu.be/G7ZOU8yKmdI
        int[] images = {R.drawable.biblestudy,R.drawable.sundayworship,R.drawable.symposium1,R.drawable.wellmeetyou,R.drawable.wellmeetyou2};



        //for image looping
        for (int image : images) {
            flipperImages(image);

        }

        binding.aboutUsText.setText(Html.fromHtml(htmlText,Html.FROM_HTML_MODE_COMPACT));




    }


    public void flipperImages (int image){

        ImageView imageView = new ImageView(binding.getRoot().getContext());
        imageView.setBackgroundResource(image);

        binding.viewFlipper.addView(imageView);
        binding.viewFlipper.setFlipInterval(10000); // 15 seconds
        binding.viewFlipper.setAutoStart(true);

        //animation
        binding.viewFlipper.setInAnimation(binding.getRoot().getContext(),android.R.anim.slide_in_left);
        binding.viewFlipper.setOutAnimation(binding.getRoot().getContext(),android.R.anim.slide_out_right);
    }



    public void facebookWebsiteLink(View view){
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/NewMindKingdomMinistries/"));
        startActivity(intent);
    }

    public void twitterWebsiteLink(View view){
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/newmindkingdom"));
        startActivity(intent);
    }

    public void instagramWebsiteLink(View view){
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/newmindkingdom/"));
        startActivity(intent);
    }

    public void youtubeWebsiteLink(View view){
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCyu_YbjuDswWIPD8YD4YR8w"));
        startActivity(intent);
    }


}