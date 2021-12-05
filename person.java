import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

 class person {
    
    List< Object> details = new ArrayList<>();
  //0-HC
  //1-UID
  //2-NoPlate
  //3-Type
  //4-EntryTime
  //5-setEstimatedExitTime
  //6-EstimatedHours
  //7-Points
  //8-EarlyAmtPaid
  //9-floor
  //10-slot
  //11-exithour
  
  //12-ActualAmt


    
    //Setters
    protected void setHC(int x){
        if(x==1){
            this.details.add(0,true);
        }
        else{
           this.details.add(0,false);
        }
    }
    protected void setUID(String UID){
        details.add(UID);
    }

    protected void setNoPlate(String noPlate){
        details.add(noPlate);
    }

    protected void setType(int vehicleType){
        details.add(vehicleType);
        // 01 -> Bikes
        // 02 -> Electric Bikes
        // 03 -> Cycles
        // 04 -> Cars
        // 05 -> Electric Cars
        // 06 -> Trucks
        // 07 -> HC vehicle

    }

    protected void setAllottedFloor(int floor){
        details.add(floor);
    }

    protected void setSlot(int slot){
        details.add(slot);
    }

    protected void setEntryTime(){
        SimpleDateFormat formatter1= new SimpleDateFormat("HH");
        Date time = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter2= new SimpleDateFormat("mm");
        details.add(Double.parseDouble(formatter1.format(time)) + Double.parseDouble(formatter2.format(time))/60);
    }

    



    protected void setEstimatedExitTime(double estExitTime){
        details.add(estExitTime);
    }

    protected void setEstimatedHours(double HH){
        details.add(HH);
    }

    protected void setExitHour(int exitTime){
        details.add(exitTime);
    }
    
    protected void setEarlyAmtPaid(double earlyAmt){
        details.add(earlyAmt);
    }

    protected void setActualAmt(double Amt){
        details.add(Amt);
    }
    
    protected void setPoints(int points){
        details.add(points);
    }

    
    
    //Methods
    public void setInfoForNew(){
        Scanner sam = new Scanner(System.in);
        String uid = generateUID();
        System.out.println("Sir it is your UID keep it private "+uid);
        setUID(uid);
        System.out.println("Please give your Vehicle Number : ");
        setNoPlate(sam.next());
        if((boolean)this.details.get(0) == true)
            this.setType(7);
        else{
            System.out.println("Enter: \n 1-> Bike \n 2-> Electric Bike "+
            "\n 3 -> Cycles \n 4 -> Cars \n 5 -> Electric Cars \n 6 -> Trucks");
            setType(sam.nextInt());
        }
        setEntryTime();
        
        System.out.println("Please Tell us the estimated time in format hh.mm : ");
        setEstimatedExitTime(sam.nextDouble());
        setEstimatedHours(estimatedHours());
        setPoints(0);
        setEarlyAmtPaid(0);
        
        //function to set floor details make an object and call method
        if((boolean)this.details.get(0) == true){
            System.out.println("Sir we will do Valet Parking for U..."+
            "\n You will recieve msg of the details for the same");
        }    
       
    }

    private String generateUID(){
    int leftLimit = 48; // numeral '0'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 10;
    Random random = new Random();

    String generatedString = random.ints(leftLimit, rightLimit + 1)
      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
      .limit(targetStringLength)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();
    return generatedString;
    }

    void setInfoForOld(String UID){
        Scanner sam = new Scanner(System.in);
        setEntryTime();
        System.out.println("Please Tell us the estimated time in format hh.mm : ");
        setEstimatedExitTime(sam.nextDouble());
        //function to set floor details
        if((boolean)details.get(0) == true){
            System.out.println("Sir we will do Valet Parking for U..."+
            "\n You will recieve msg of the details for the same");
        }
        
    }

    void parkedProperly(){
        if((boolean)details.get(0) != true){
            Random rand = new Random();
            int a = rand.nextInt();
            if(a%2 == 0)
                System.out.println("Sir please park your car properly..."+
                "\nIt seems to cross the boundary lines...");
            else
                System.out.println("Sir Your car is parked properly...");
        }
    }

    //return boolean depending on whether (double)actualAmt == PaidAmt
     int estimatedHours(){
        return (int)((double)details.get(5)-(double)details.get(4));
    }
    
    //return boolean depending on whether (double)actualAmt == PaidAmt
    boolean checkPayment(){
        if((double)details.get(9) == (double)details.get(11))
            return true;
        else
            return false;
    }
}

