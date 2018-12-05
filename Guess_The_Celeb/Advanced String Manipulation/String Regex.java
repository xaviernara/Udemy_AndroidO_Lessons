import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HelloWorld {
  public static void main(String[] args) {

    String html = "<div class=\"image\"><img src=\"http://cdn.posh24.se/images/:profile/0fddc23e241e86e1a30c49bb334d76f8a\" alt=\"Taylor Swift\"/></div>";

//Pattern p = Pattern.compile("img src=\"(.*?)\""); & 
//Matcher m = p.matcher(html);
/*
basically looks for the begining part:(img src=\) part of the string:(html) and looks for everything in between: (\"), by using the: (.*?) in the middle and returns it back by using the matcher (ie it finds this pattern and returns it)
*/ and these are called a Pattern and Match regex

/*
these 2 lines find and match the url to the image and its printed down below in the while loop
*/
    Pattern p = Pattern.compile("img src=\"(.*?)\"");
    Matcher m = p.matcher(html);

//while (m.find()) bascially runs until there's no more patterns to find
    while (m.find()) {

//m.group(1) gives access to the pattern found by Pattern p = Pattern.compile("img src=\"(.*?)\""); 
    	System.out.println(m.group(1));
    }


/*
these 2 lines find and match the name that pertains to the image and its printed down below in the while loop
*/

    p = Pattern.compile("alt=\"(.*?)\"");
    m = p.matcher(html);

    while (m.find()) {
    	System.out.println(m.group(1));
    }


  }
}
