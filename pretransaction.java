// import java.io.*;
// import java.util.*;
// import java.lang.*;




class pretransaction {
    double change = 0;
    double  amount = 0;
    double due = 0;
    double paid = 0;
    double p;
    double traninfo[] = new double[15];
    public void prepaymentA1(double input ){
        // traninfo[] = cash/ digital;
        traninfo[0]= input ;
    }
    // if condition in the main (points > 280)
    public void prepaymentA2(double input ){
        // traninfo[] = redeem points 
        traninfo[1]= input ;
    }
    
    public void precurrencyA(double input){
        // traninfo[2] = type of currency 
        traninfo[2] = input;
    }
    
    public void prehourinput(double input ){
        if(input <= 1){
            amount = 20;
        }
        else if(input <= 2){
            amount = 20 + 10;
        }
        else if (input > 2){
            amount = 30 + 5*(input - 2);
        }
        p = amount;
    }
    
    
    public void preamountoutput(int points){
        if(traninfo[1] == 1  ){
            int m = 0;
            m = (points / 280);
            
            if(traninfo[2] == 1){
                amount = amount - 140*m;
            }
            if(traninfo[2] == 2){
                amount = amount - 140*m;
                amount = (5/100)*(amount) + amount ;
                amount = amount / (59);
            }
            if(traninfo[2] == 3){
                amount = amount - 140*m;
                amount = (5/100)*(amount) + amount ;
                amount = amount / (74);
            }
            if(traninfo[2] == 4){
                amount = amount - 140*m;
                amount = (5/100)*(amount) + amount ;
                amount = amount / (80);
            }
            if(traninfo[2] == 5){
                amount = amount - 140*m;
                amount = (5/100)*(amount) + amount ;
                amount = amount / (87);
            }
            if(traninfo[2] == 6){
                amount = amount - 140*m;
                amount = (5/100)*(amount) + amount ;
                amount = amount / (89);
            }
            if(traninfo[2] == 7){
                amount = amount - 140*m;
                amount = (5/100)*(amount) + amount ;
                amount = amount / (101);
            }
            if(traninfo[2] == 8){
                amount = amount - 140*m;
                amount = (5/100)*(amount) + amount ;
                amount = amount / (104);
            }
            if(traninfo[2] == 9){
                amount = amount - 140*m;
                amount = (5/100)*(amount) + amount ;
                amount = amount / (192);
            }
            if(traninfo[2] == 10){
                amount = amount - 140*m;
                amount = (5/100)*(amount) + amount ;
                amount = amount / (197);
            }
            if (amount < 0){amount = 0;}
            System.out.println(amount);
        }
        else if(traninfo[1] == 2){
            if(traninfo[2] == 1){
            }
            if(traninfo[2] == 2){
                amount = (5/100)*(amount) + amount ;
                amount = amount / (59);
            }
            if(traninfo[2] == 3){
                amount = (5/100)*(amount) + amount ;
                amount = amount / (74);
            }
            if(traninfo[2] == 4){
                amount = (5/100)*(amount) + amount ;
                amount = amount / (80);
            }
            if(traninfo[2] == 5){
                amount = (5/100)*(amount) + amount ;
                amount = amount / (87);
            }
            if(traninfo[2] == 6){
                amount = (5/100)*(amount) + amount ;
                amount = amount / (89);
            }
            if(traninfo[2] == 7){
                amount = (5/100)*(amount) + amount ;
                amount = amount / (101);
            }
            if(traninfo[2] == 8){
                amount = (5/100)*(amount) + amount ;
                amount = amount / (104);
            }
            if(traninfo[2] == 9){
                amount = (5/100)*(amount) + amount ;
                amount = amount / (192);
            }
            if(traninfo[2] == 10){
                amount = (5/100)*(amount) + amount ;
                amount = amount / (197);
            }
            if(amount<0){amount = 0;}
            System.out.println(amount);
        }
    }

    
    public void prepay ( double tbucks , int points ){
        while (points >=280 && traninfo[1] == 1 && p >= 140){
            points = points - 280;
            p = p - 140;
            traninfo[3]= points;
            
        }
        if (tbucks >= amount ){
            change = tbucks - amount ;
            paid = amount ;
        }
        System.out.println("Change : " + change );
        if(amount > tbucks){
            due = amount - tbucks;
            paid = tbucks;
            System.out.printf("Due : " + due);
        }
        
        
    }
   
}

