import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PigLatin extends PApplet {



public void setup() {
	String lines[] = loadStrings("words.txt");
	System.out.println("there are " + lines.length + " lines");
	for (int i = 0 ; i < lines.length; i++) {
	  System.out.println(pigLatin(lines[i]));
	}
}
public void draw()
{
}
public int findFirstVowel(String sWord)
//precondition: sWord is a valid String of length greater than 0.
//postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
{
	for(int i = 0; i < sWord.length(); i++)
		{
			if(	sWord.charAt(i) == 'a' || sWord.charAt(i) == 'e' || sWord.charAt(i) == 'i' || sWord.charAt(i) == 'o' || sWord.charAt(i) == 'u' ||
			sWord.charAt(i) == 'A' || sWord.charAt(i) == 'E' || sWord.charAt(i) == 'I' || sWord.charAt(i) == 'O' || sWord.charAt(i) == 'U')
				return i;
			else if((sWord.charAt(i) == 'Q' && sWord.charAt(i +1) == 'u') || (sWord.charAt(i) == 'q' && sWord.charAt(i +1) == 'u'))
			{
				return i +2;
			}
		}
	return -1;
}

public String pigLatin(String sLine)
//precondition: sLine is a valid String of length greater than 0
//postcondition: returns the pig latin equivalent of sLine
{
	String words[] = sLine.split(" ");
	for(int i = 0; i < words.length; i++)
	{
		int first = findFirstVowel(words[i]);
		if(first == -1)
			words[i] = words[i] + "ay";
		else if(first == 0)
			words[i] = words[i] + "way";
		else
			words[i] = words[i].substring(first) + words[i].substring(0, first) + "ay";
	}
	String ret = "";
	for(int i = 0; i < words.length; i++)
		ret += words[i] + " ";
	ret = ret.substring(0, ret.length() -1);
	return ret;
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PigLatin" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
