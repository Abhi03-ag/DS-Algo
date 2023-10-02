import java.util.*;
class Attendence
{
    public static int calculateAttendence(int arr[])
    {
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> students = new ArrayList<Integer>();
        int day = 0;
        boolean process;
        do
        {
            process = false;
            for(int i = 1; i < arr.length; i++)
            {
                if(arr[i] > arr[i - 1])
                {
                    result.add(i);
                    process = true;
                }
            }
            if(process)
            {
                for(int i = 0; i < arr.length; i++)
                {
                    if(!result.contains(i))
                        students.add(arr[i]);
                }
                arr = students.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
                day++;
                result.clear();
                students.clear();
            }

        }
        while(process);
        return day;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i = 0; i < size; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("The Answer is: " + calculateAttendence(arr));
    }
}