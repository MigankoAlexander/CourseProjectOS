/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package courseprojectos;

/**
 *
 * @author Miganko
 */
public class JNIWinAPI {
    static{
    System.loadLibrary("javawinapi");
    }
    public static native char getLetterOfName(int i);
}
