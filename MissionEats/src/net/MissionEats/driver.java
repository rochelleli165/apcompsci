package net.MissionEats;

public class driver {
    //Attributes
    private String name;
    private int grade;
    private int slotsOpen;
    private String location;
    private double commission;
    private int driverID = 0;

    //Constructor
    public driver( String n, int g, int sO, String l, double c )
    {
        customer[] allCustomers = new customer[slotsOpen];
        name = n;
        grade = g;
        slotsOpen = sO;
        location = l;
        commission = c;
    }

    //Getters
    public String getName()
    {
        return name;
    }

    public int getGrade()
    {
        return grade;
    }

    public int getSlotsOpen()
    {
        return slotsOpen;
    }

    /*public int getSlotsLeft()
    {
        for( int a = 0; a < slotsOpen; a++ )
        {
            if( allCustomers[a] != null )
            {
                return slotsOpen - a;
            }
        }
    }*/

    public String getLocation()
    {
        return location;
    }

    public double getCommission()
    {
        return commission;
    }

    public int getDriverID()
    {
        return driverID;
    }

    //Setters
    public void setName( String n )
    {
        name = n;
    }

    public void setGrade( int g )
    {
        grade = g;
    }

    public void setSlotsLeft( int sL )
    {
        slotsOpen = sL;
    }

    public void setLocation( String l )
    {
        location = l;
    }

    public void setCommission( double c )
    {
        commission = c;
    }

    //Other methods
    public String toString()
    {
        return name + ": " + grade + "th grade, " + slotsOpen + " slots open, " + " going to " + location + " and charging " + commission + " per order.";
    }

    public void assignDriverID()
    {
        driverID = driverID + 1;
    }
}

