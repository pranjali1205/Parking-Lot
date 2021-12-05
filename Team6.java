import java.util.*;
import java.util.ArrayList;

public class Team6 {

    public static boolean verifyUID(ArrayList<person> list,String x){                           
        
        
        for(int i=0;i<list.size();i++){
            
            if(list.get(i).details.get(1).equals(x)){
                System.out.println("UID verified");
                return true;
            }
        }
        System.out.println("Entered UID is invalid");
        System.out.println("You can register as a new user");
        return false;
      }

      public static int getIndexUID(ArrayList<person> list,String x){                           
        
        for(int i=0;i<list.size();i++){
            if(list.get(i).details.get(1).equals(x)){
                return i;
            }
        }
        
        return -1;
      }


 
    public static void main(String[] args){

        

        ArrayList<person> list=new ArrayList<>();
        Message msg =new Message();
        Parking park = new Parking();
        Scanner input = new Scanner(System.in);
        msg.display5();
        int i0=input.nextInt();
        
while(i0!=-1){

    if(i0==1){
        
        msg.display();
        
        String i1 = input.next();
         
        
        person obj =new person();
        list.add(obj);
        
        
        if(i1.equals("1")){
            msg.display2();
            int i2=input.nextInt();
            obj.setHC(i2);
            obj.setInfoForNew();
            if(park.checkAvailabilty((int)obj.details.get(3))){
                System.out.println("Floor : "+park.giveFloor((int)obj.details.get(3)));
                System.out.println("Your Slot No. : "+park.allotSlotOnFloor(park.giveFloor((int)obj.details.get(3)), (int)obj.details.get(3)));
            }else{
                System.out.println("Sorry sir we don't have Availability of the Parking.");
                break;
            }
        }
        else{
            if(verifyUID(list, i1)){
                int t1=getIndexUID(list,i1);
                list.get(t1).setInfoForOld(i1);
                if(park.checkAvailabilty((int)list.get(t1).details.get(3))){
                    System.out.println("Floor : "+park.giveFloor((int)list.get(t1).details.get(3)));
                    System.out.println("Your Slot No. : "+park.allotSlotOnFloor(park.giveFloor((int)list.get(t1).details.get(3)), (int)list.get(t1).details.get(3)));
                }else{
                    System.out.println("Sorry sir we don't have Availability of the Parking.");
                    break;
                }
            }
        }
        //checkpoint2
         msg.display3();
        String i3 = input.next();
        int value=getIndexUID(list, i3);
        if(value == -1){
           System.out.println("Entered UID IS WRONG");

        }
        else{
        pretransaction pay1 = new pretransaction();
        msg.paymentQ1();
        double i4 = input.nextDouble();
        pay1.prepaymentA1(i4);
        if((int)list.get(value).details.get(07) >= 280){
            msg.paymentQ2();
            double i5 = input.nextDouble();
            pay1.prepaymentA2(i5);
        }
        else { pay1.traninfo[1] = 2;}
        pay1.prehourinput((double)list.get(value).details.get(06));
        msg.currency();
        double i6 = input.nextDouble();
        pay1.precurrencyA(i6);
        msg.prepaymentinfo();
        pay1.preamountoutput((int)list.get(value).details.get(07));
        msg.paymentQ3();
        double i7 = input.nextDouble();
        pay1.prepay(i7,(int)list.get(value).details.get(07));
         list.get(value).details.add(8,pay1.paid);
         System.out.println();

        }

     }
     else if(i0==2){
        


        //checkpoint3

        msg.display3();
        String i8 = input.next();
        int value1=getIndexUID(list, i8);
        if(value1 == -1){
           System.out.println("Entered UID IS WRONG");

        }
        else{
            msg.display4();
            int i9=input.nextInt();
            list.get(value1).setExitHour(i9);
        }
        
        
        
        
        // checkpoint 4
        msg.display3();
        String i10 = input.next();
        int value2=getIndexUID(list, i10);
        if(value2 == -1){
           System.out.println("Entered UID IS WRONG");

        }
        else{
            posttransaction pay2 = new posttransaction();
            pay2.paid =  (double)list.get(value2).details.get(8);
            msg.paymentQ1();   
            double i11 = input.nextDouble();
            pay2.postpaymentA1(i11);
            if((int)list.get(value2).details.get(07) >= 280){
                msg.paymentQ2();
                double i12 = input.nextDouble();
                pay2.postpaymentA2(i12);
        }
        else { pay2.traninfo[1] = 2;}
        msg.currency();
        double i13 = input.nextDouble();
        pay2.postcurrencyA(i13);
        pay2.posthourinput((double)list.get(value2).details.get(9));
        pay2.postamountoutput((int)list.get(value2).details.get(07));
        pay2.postfinalamountoutput();
        //pay2.postpoint();
        if(pay2.amount >= 0){
            msg.postpaymentinfo1();
            System.out.println(pay2.amount);
            msg.paymentQ3();
            double i14 =input.nextDouble();
            pay2.postpay(i14,(int)list.get(value2).details.get(07));
        }
        else {
            msg.postpaymentinfo2();
            double p = pay2.amount;
            p = p*(-1);
            System.out.print(p);
        }
        // int i15 =((int)list.get(value2).details.get(9));
        // list.get(value2).details.add(7,i15);
            
        }
        System.out.println("Thanks a Lot for visiting...\n Visit Again...");
        
     }
      msg.display5();
      i0=input.nextInt();
    }        
 
        input.close();

    }      
}
