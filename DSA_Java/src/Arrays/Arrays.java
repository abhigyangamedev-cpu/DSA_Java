package Arrays;

public class Arrays {

    public static void printArrayForLoop(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.println("Printing Array using for loop element number with index "+ + i +" = " +a[i]);
        }
    }

    private static void printArrayEnhancedLoop(int[] a){
        for(int ele : a){
            System.out.println("Printing Array using EnhancedLoop element:- "+ + ele);
        }
    }

    private static void printArrayWhileLoop(int[] a){
        int i = 0;
        while(i < a.length){
            System.out.println("Printing Array using WhileLoop element:- "+ + a[i]);
            i++;
        }
    }

    private static boolean CheckIfPresent(int[] a, int value){
        for (int i = 0; i < a.length; i++){
            if(a[i] == value){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        // Creation and Initialisation
        int[] arr = {1,2,3,4,5};

        printArrayForLoop(arr);
        printArrayEnhancedLoop(arr);
        printArrayWhileLoop(arr);

        // Updation
        System.out.println("Printing the arrat after updating the index 2 with number 10 replacing number 3");
        arr[2] = 10;
        printArrayForLoop(arr);

        System.out.println("Is 1 present or not :- " + CheckIfPresent(arr,1));
        System.out.println("Is 12 present or not :- " + CheckIfPresent(arr,12));


    }
}
