import java.util.*;
public class Sample
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Booking obj[] = new Booking[3];
        for(int i = 0; i < 3; i++)
        {
            int id = sc.nextInt();
            sc.nextLine();
            String board_city = sc.nextLine();
            String dest_city = sc.nextLine();
            double fare = sc.nextDouble();
            obj[i] = new Booking(id, board_city, dest_city, fare);
        }
        for(Booking b : obj)
        {
            System.out.println(b);
        }

    }
}
class Booking
{
    private int id;
    private String board_city, dest_city;
    private double fare;

    Booking(int id, String board_city, String dest_city, double fare)
    {
        this.id = id;
        this.board_city = board_city;
        this.dest_city = dest_city;
        this.fare = fare;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }
    public void setBCity(String board_city)
    {
        this.board_city = board_city;
    }
    public String getBCity()
    {
        return board_city;
    }
    public void setDCity(String dest_city)
    {
        this.dest_city = dest_city;
    }
    public String getDCity()
    {
        return dest_city;
    }
    public void setFare(double fare)
    {
        this.fare = fare;
    }
    public double getFare()
    {
        return fare;
    }
    @Override
    public String toString()
    {
        return "Booking Id is:" + id + "\nBoarding City is:" + board_city + "\nDestination City is:" + dest_city + "\nTotal Fare is:" + fare;
    }
}
