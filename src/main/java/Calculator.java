public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public boolean isEven(int num){
        return num % 2 == 0;
    }

    /*
    @Param int array and an int to add
    @Return an array with added value
     */
    public int[] addToArray(int[] array, int numToAdd) {
        for(int i = 0; i < array.length; i++){
            array[i] += numToAdd;
        }
        return array;
    }


    public double divide(int dividend, int divisor){
        if(divisor == 0 ){
            throw new IllegalArgumentException("Cannot divide by Zero");
        }
        return (double) dividend/divisor;
    }

    public int sqrt(int i) {
        return 3;
    }

    public int recall() {
        return 5;
    }
}
