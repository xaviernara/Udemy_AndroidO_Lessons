package com.example.xaviernara.newmindapp;

import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.widget.TextView;

public class VisionStatement extends Activity {



    String htmlText="<p>The Vision of New Mind Kingdom Ministries is to minister to the Whole man, body, soul and spirit." +
            "Through various ministries set in place; focusing on specific needs through: systematic teachings from the Word of God.</p> \n" +
            " We will accomplish this by promoting an I.C.C.E (Integrity-Character -Compassion -Excellence) Culture. " +
            "<ul>"+

            "           <li> Integrity - presenting things honest, establishing a base of trust whereby the believer can be sure.</li>" +
            "           <li> Character - exemplifying Christ in our lives; even while people are not watching, being who we say that we are.</li>" +
            "           <li> Compassion- genuine love and concern exemplifying that Christ like passion.</li>" +
            "           <li>Excellence - having an eye giving to detail, always doing our best in all things so that God may be glorified.</li>" +
            "</ul>" +

            "\n This will be an environment free from special interest groups." +
            "\n" +
            "<p> Our objective is to help guide the believer to discover their “Purpose” and “Destiny”.  This mandate is our 7Rs concept.a" +
            "It is a check and balance system set in place to edify the believer." +
            "\n <ul>"+
            "        1) <b>Reconcile</b>- bring man back to God to discover their purpose.\n" +
            "        2) <b>Relate</b>- being a believable example, relating with people from where they are and from whence the come.\n" +
            "        3) <b>Restore</b>- working to get them healthy, building them up in their faith by the Word of God, offering healing for the body, soul and spirit.\n" +
            "        4) <b>Renew</b>-transforming the mind to a full understanding of what is God’s plan for their lives. We are changing the “church mentality to Kingdom (all inclusive), a mentality enriching them through the message of hope, faith and salvation.\n" +
            "        5) <b>Reinforce</b>- Through systematic strategic teaching of the Word, offering information, instruction and insight, relative to their vocation where they have were called.\n" +
            "        6) <b>Release</b>- Our main goal is to get the believer to the point of release, pushing them out of the nest, encouraging them to go forth and perform God’s purpose for their lives.\n" +
            "        7) <b>Rejoice</b>- rejoicing with them when they are carrying out their God given purpose, seeing them excel in their profession.\n" +
            "<ul> \n" +

            "<p> We will “Renew the Mind” by establishing; shelters for people that have been battered and abused." +
            "Opening rehabilitation center for substance dependency, assisting former convicts to reconnect to society, a social center, a safe haven for youth and young adults, offering tutoring, assistance in obtaining G.E.D, building a family support system aiding in enhancing spousal role, parenting skills, and how to run a efficient and productive households." +
            "We will create a “Pathway to Purpose” so that the believer will be in a culture that is purpose driven.</p>";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vision_statement);

        TextView visionStatement = findViewById(R.id.visionText);
        visionStatement.setText(Html.fromHtml(htmlText,Html.FROM_HTML_MODE_COMPACT));

    }
}
