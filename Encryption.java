//Jacob Gaylord
//jigaylord16@ole.augie.edu
//Encryption.java
//Desc: 	Encrypts or decrypts a file.
//Input: 	The user supplies the character '1' to encrypt, or '2' to
//        decrypt via the keyboard. The user also supplies the name of the
//        source file via the keyboard.
//Output: If the user wants to encrypt, the text in input file is
//        encrypted and the encrypted text is stored in "encrypted.txt".
//        The original file is not changed. If the user wants to decrypt,
//        the text in input file is decrypted and the decrypted text is
//      	stored in "decrypted.txt". The original file is not changed.
import java.util.*;
import java.io.*;
class Encryption
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner keyboard = new Scanner(System.in);
        char choice = '1';
        System.out.println("1. Encrypt a file");
        System.out.println("2. Decrypt a file");
        choice = keyboard.nextLine().charAt(0);
        switch (choice)
        {
            case '1': encrypt(); break;
            case '2': decrypt(); break;
	      }
    }
    //Desc : 	Encrypts a file.
    //Input: 	The user supplies the name of a disk file via the keyboard and
    //        the file must exist.
    //Output: The text in the specified file encrypted and written to
    //        "encrypted.txt".
    public static void encrypt() throws FileNotFoundException
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String s = keyboard.nextLine();
        PrintWriter f;
        Scanner input = new Scanner(new File(s));
        input.useDelimiter("");
        f = new PrintWriter("encrypted.txt");
        while (input.hasNext())
        {
            char ch = input.next().charAt(0);
            ch = convert(ch);
            f.print(ch);
        }
        f.close();
    }
    //Desc : 	Every letter (both uppercase and lowercase) converted to its
    //        successor except z and Z, which are converted to 'a' and 'A'
    //        respectively (i.e., a to b, b to c, …, y to z, z to a, A to B, B
    //        to C, …, Y to Z, Z to A)
    //Return:	The successor of ch if it is a letter (except z) or the
    //        predecessor of ch if it is a digit.
    public static char convert (char ch)
    {
        char result = '\0';
        if(Character.isLetter(ch))
        {
            if(Character.isLowerCase(ch))
            {
                if(ch != 'z')
                    result = (char)(ch+1);
                else
                    result = 'a';
            }
            else if(Character.isUpperCase(ch))
            {
                if(ch != 'Z')
                    result = (char)(ch+1);
                else
                    result = 'A';
            }
        }
        else if(Character.isDigit(ch))
        {
            if(ch != '0')
                result = (char)(ch-1);
            else
                result = '9';
        }
        else if(Character.isWhitespace(ch))
            result = ch;
        return result;
    }
    //Desc : 	Decrypts a file.
    //Input: 	The user supplies the name of a disk file via the keyboard and
    //        the file must exist.
    //Output: The text in the specified file decrypted and written to
    //        "decrypted.txt".
    //Throw: 	FileNotFoundException if the input source file does not exist,
    //        or decrypted.txt cannot be created.
    public static void decrypt() throws FileNotFoundException
    {
        Scanner keyboard=new Scanner(System.in);
        char ch = 'a';
        System.out.print("Enter file name: ");
        String s = keyboard.nextLine();
        PrintWriter f;
        Scanner input = new Scanner(new File(s));
        input.useDelimiter("");
        f = new PrintWriter("decrypted.txt");
        while (input.hasNext())
        {
            ch = input.next().charAt(0);
            ch = inverseConvert(ch);
            f.print(ch);
        }
        f.close();
    }
    //Desc : 	Decrypt an encrypted character to the original value.
    //Return:	The predecessor of ch if it is a letter (except z) or the
    //        successor of ch if it is a digit.
    public static char inverseConvert(char ch)
    {
        char result= '\0';
        if(Character.isLetter(ch))
        {
            if(Character.isLowerCase(ch))
            {
                if(ch != 'a')
                    result = (char)(ch-1);
                else
                    result = 'z';
            }
            else if(Character.isUpperCase(ch))
            {
                if(ch != 'A')
                    result = (char)(ch-1);
                else
                    result = 'Z';
            }
        }
        else if(Character.isDigit(ch))
        {
            if(ch != '9')
                result = (char)(ch+1);
            else
                result = '0';
        }
        else if(Character.isWhitespace(ch))
            result = ch;
        return result;
    }
}
