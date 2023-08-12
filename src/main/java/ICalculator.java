public interface ICalculator {
    int subtract (int a, int b);

    default int add (int a, int b){
        return a + b;
    }
}
