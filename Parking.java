// import java.util.Arrays;

class Parking{
    floor flr[] = new floor[7];

    Parking(){
        for(int i=0;i<7;i++)
            flr[i] = new floor(i);
    }

    boolean checkAvailabilty(int type){
        if(type == 6){
            if(flr[0].AllotSlot(type) == -1){
                System.out.println("Sorry our Parking is full for Heavy Vehicles...");
                return false;
            }
            else{
                return true;
            }
        }
        else if(type == 6){
            if(flr[1].AllotSlot(type) == -1){
                System.out.println("Sorry our Parking is full for HCs...");
                return false;
            }
            else{
                return true;
            }
        }
        else{
            boolean flag = false;
            int j = 2;
            do{
                if(flr[j].AllotSlot(type) != -1 ){
                    flag = true;
                    break;
                }
                j++;
            }while(j<7);
            return flag;
        }
    }

    int giveFloor(int type){
            if(type == 06)
                return 0;
            else if(type == 07)
                return 1;
            else{
                int j=2;
                do{
                    if(flr[j].AllotSlot(type) != -1 ){
                        break;
                    }
                    j++;
                }while(j<7);
                if(j == 7)
                    return -1;
                else
                    return (j);
            }
    }

    int allotSlotOnFloor(int floorNo, int type){
        return flr[floorNo].AllocateSlot(type);
    }

    void removeSlot(int floor,int slot,int type){
        flr[floor].removeSlot(slot,type);
    }
}

class floor{
    int [] bikes = new int[5]; 
    int [] EBikes = new int[5];
    int [] HC = new int[30];
    int [] Heavy = new int[30];
    int [] Cars = new int[15];
    int [] ECars = new int[15];
    // 01 -> Bikes
    // 02 -> Electric Bikes
    // 03 -> Cycles
    // 04 -> Cars
    // 05 -> Electric Cars
    // 06 -> Trucks
    // 07 -> HC vehicle
    int floorNumber;
    int slotNumber;

    floor(int floorNumber){
        this.floorNumber = floorNumber;
       // Arrays.fill(Cars,0);
       //System.out.println(Arrays.toString(Cars));
    }

    int AllotSlot(int type){
        if(this.floorNumber <= 1){
            if(this.floorNumber == 0)
                return tellSlot(Heavy);
            else
                return tellSlot(HC);
        }else{
            if(type == 1 || type == 3)
                return tellSlot(bikes);
            else if(type == 2)
                return tellSlot(EBikes);
            else if(type == 4)
                return tellSlot(Cars);
            else 
                return tellSlot(ECars);
        }
    }

   private int tellSlot(int A[]){
        int i;
        for(i=0;i<A.length ; i++){
            if(A[i] == 0){
                break;
            }
        }
        if(i == A.length)
            return -1;
        else
            return (i);
    }

    int AllocateSlot(int type){
        if(this.floorNumber <= 1){
            if(this.floorNumber == 0)
                return fillSlot(Heavy);
            else
                return fillSlot(HC);
        }else{
            if(type == 1 || type == 3)
                return fillSlot(bikes);
            else if(type == 2)
                return fillSlot(EBikes);
            else if(type == 4)
                return fillSlot(Cars);
            else 
                return fillSlot(ECars);
        }
    }

    private int fillSlot(int A[]){
        int i;
        for(i=0;i<A.length ; i++){
            if(A[i] == 0){
                A[i] = 1;
                break;
            }
        }
        if(i == A.length)
            return -1;
        else
            return (i);
    }

    void removeSlot(int slot,int type){
        if(type == 1 || type == 3)
                bikes[slot] = 0;
            else if(type == 2)
                EBikes[slot] = 0;
            else if(type == 4)
                Cars[slot] = 0;
            else 
                ECars[slot] = 0;
    }
}
