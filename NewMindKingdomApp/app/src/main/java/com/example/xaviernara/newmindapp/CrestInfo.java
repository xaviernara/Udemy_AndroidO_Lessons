package com.example.xaviernara.newmindapp;

import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.widget.TextView;

public class CrestInfo extends Activity {

    String htmlText = "The shield rooted in the Word of God, our foundation, has four intents: "+
            "<ul>"+
            "        <li>Renew the Mind of the believer</li>" +
            "        <li>The chauffeur speaks of our call and purpose</li>" +
            "        <li>The praying hand represent our commitment to prayer</li>" +
            "        <li>the dove represents the free flowing of Holy Spirit.</li>" +
            "</ul>"+
            "\n <p>In the center of the shield is our 7R concept." +
            "The Lions are covered in silver, which represent Holy Spirit, and the lions represent Boldness." +
            "Therefore, the Lion are in silver representing Boldness in the Spirit." +
            "The Sword represents the piercing power of the Word of God.</p>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crest_info);

        TextView crestInfoText = findViewById(R.id.crestInfoText);
        crestInfoText.setText(Html.fromHtml(htmlText,Html.FROM_HTML_MODE_COMPACT));



    }
}
