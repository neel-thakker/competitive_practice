public class CircularTour {

    /*
        CircularTour

        Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.
            1. The amount of petrol that every petrol pump has.
            2. Distance from that petrol pump to the next petrol pump.

        Find a starting point where the truck can start to get through the complete circle without exhausting its petrol in between.
        Note :  Assume for 1 litre petrol, the truck can go 1 unit of distance.
    */

    static int bruteForce(int petrol[], int distance[]) {
        int n = petrol.length;
        
        for(int i=0 ; i<n ; i++) {
            if(petrol[i] >= distance[i]) {
                int j = i + 1, cap = petrol[i] - distance[i];
                
                boolean isIt = true;
                while(j!=i) {
                    if(j==n) {
                        j = 0;
                        continue;
                    }
                    
                    cap += petrol[j] - distance[j];
                    if(cap<0) {
                        isIt = false;
                        break;
                    }
                    
                    j++;
                }
                
                if(isIt) 
                    return i;
            }
        }
        
        return -1;
    }

    static int solve(int petrol[], int distance[], int n) {
        int index = 0, completed = 0, remaining = 0;
        
        for(int i=0 ; i<n ; i++) {
            remaining += petrol[i] - distance[i];
            
            if(remaining<0) {
                completed += remaining;
                remaining = 0;
                index = i + 1;
            }
        }
        
        return (completed+remaining)>0 ? index : -1;
    }

    public static void main(String[] args) {
        int n = 4;
        int petrol[] = { 4, 6, 6, 5 };
        int distance[] = { 7, 3, 4, 5 };

        System.out.println(solve(petrol, distance, n));
    }
}