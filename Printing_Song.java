/***
 * Assignment #1
 * @author  Shangze Yang
 * sy2827@nyu.edu
 * 09 Feb. 2020
 * 30 minutes
 *
 * Description: This program uses one loop and two parameters to print the
 * song 'The Ants Go Marching' in a simple way.
 */

package Assignment1;

import java.awt.*;

public class PrintSong {
    public static void main(String[] args){
        String[] NumberArray={"one","two","three","four","five","six",
                "seven","eight", "nine","ten","eleven"};
        String[] VerseArray={"suck his thumb","tie her shoe","climb a tree","shut the door",
                "take a dive","pick up sticks", "pray to heaven","check the gate",
                "check the time", "say “The End!”","enjoy the day"};

        System.out.println("\n       ‘The Ants Go Marching’ \n");

        for(int i=0;i<NumberArray.length;i++){
            VerseFormat(NumberArray[i],VerseArray[i]);
        }
}

    public static void VerseFormat(String number, String words){
        System.out.print("The ants go marching " + number +  " by " + number+ ",\n" +
                "“Hurrah!, Hurrah!”\n" +
                "The ants go marching " + number +  " by " + number+ ",\n" +
                "“Hurrah!, Hurrah!”\n" +
                "The ants go marching " + number +  " by " + number+ ",\n" +
                "The little one stops to " + words + ".\n" +
                "And they all go marching down,\n" +
                "To the ground, to get out, of the rain.\n" +
                "       BOOM /'\\ BOOM /'\\ BOOM /'\\ \n \n");

    }
}
