package com.example.xaviernara.newmindapp;

import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.widget.EditText;
import android.widget.TextView;

public class AboutUs extends Activity {

    TextView aboutUsText;
    String htmlText = "New Mind Kingdom Ministries is a Life Skill teaching ministry with Destiny and a Destination in mind. Our focus and intent is to teach you the Word of God so that you can make it applicable to your everyday life. " +
            "“The Word works when YOU work it.” Wisdom is the correct application of knowledge. " +
            "Life is based on choices. Make wise choices, good life. Make foolish choices, foolish life.\n" +
            "\n" +
            "Deuteronomy 30:19 I call heaven and earth to record this day against you, that I have set before you life and death, blessing and cursing: therefore choose life, " +
            "that both thou and thy seed may live. We choose our life that consequently affects the lives around us. " +
            "Pastor Ward’s endeavor is to give you so much Word so that you may have ample amount of knowledge to apply wisdom in your choices to have an “Abundant life.”\"";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        aboutUsText = findViewById(R.id.aboutUsText);
        aboutUsText.setText(Html.fromHtml(htmlText,Html.FROM_HTML_MODE_COMPACT));
    }
}
