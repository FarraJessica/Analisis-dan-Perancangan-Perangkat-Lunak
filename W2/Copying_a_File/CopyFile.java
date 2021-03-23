import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class CopyFile {
    
    public static void main(String[] args)
    {
        copyFile();
    }

    public static void copyFile()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = scan.nextLine();

        File file = new File(fileName);
        try 
        {
            scan = new Scanner(file, StandardCharsets.UTF_8.name());
            while (scan.hasNextLine())
            {
                System.out.println(scan.nextLine());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(fileName + " not found\n");
            copyFile();
        }
    }
}