import java.util.ArrayList;
public class SolvingInequalities {
    public static ArrayList<Long> numbers = new ArrayList<>();
    public static void Factoring(long num){
        if (DivisorOvershoot.isPrime(num)){
            numbers.add(num);
            return;
        }
        long more, less, dif;
        less = (long) Math.floor(Math.sqrt(num));
        if (less == Math.sqrt(num)){
            Factoring(less);
            Factoring(less);
            return;
        }
        more = less + 1;
        if (less % 2 == 0) {
            less--;
        }
        if (more % 2 == 0) {
            more++;
        }
        dif = less * more - num;
        do {
            if (dif < 0) {
                more += 2;
                dif += less * 2;
            } else if (dif > 0) {
                less -= 2;
                dif -= more * 2;
            }
        } while (dif != 0);
        Factoring(less);
        Factoring(more);
    }
}
