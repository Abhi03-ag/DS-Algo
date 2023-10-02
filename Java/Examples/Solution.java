import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String args[]) throws IOException
    {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            int tcase = Integer.parseInt(br.readLine());
            for (int j = 0; j < tcase; j++)
            {
                int length = Integer.parseInt(br.readLine());
                int curr_len = 1;
                String input = br.readLine();
                StringBuffer output = new StringBuffer();
                output.append(curr_len + " ");
                for (int i = 1; i < length; i++)
                {
                    char ch = input.charAt(i);
                    if (ch > input.charAt(i - 1))
                    {
                        curr_len++;
                    }
                    else
                        curr_len = 1;
                    output.append(curr_len + " ");
                }
                System.out.println("Case #" + (j + 1) + ": " + output.toString().trim());
                //tcase--;
            }
            br.close();
        }
    }
}