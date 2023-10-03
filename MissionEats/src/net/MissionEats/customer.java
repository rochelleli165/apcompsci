package net.MissionEats;

public class customer {

        private String name;
        private int grade;
        private String drivername;
        private String fooditem;

  public customer(String n, int g, String d, String f)
        {
            name = n;
            grade = g;
            drivername = d;
            fooditem = f;
        }

        public String getName()
        {
            return name;
        }
        public int getGrade()
        {
            return grade;
        }
        public String getDrivername()
        {
            return drivername;
        }
        public String getFooditem()
        {
            return fooditem;
        }

        public void setName( String x )
        {
            name = x;
        }
        public void setGrade( int y )
        {
            grade = y;
        }
        public void setDrivername( String a )
        {
            drivername = a;
        }
        public void setFooditem( String b )
        {
            fooditem = b;
        }

        public String toString()
        {
            return name + " " + grade + " " + fooditem;
        }
    }
