public class DivisorOvershoot {
    public static boolean isPrime(long n){
        if(n==1L) // 1 - не просте число
            return false;
        // перебираємо можливі дільники від 2 до sqrt(n)
        for(long d = 2L; d * d<=n; d++){
            // если поділилось націло, то складене
            if(n%d==0)
                return false;
        }
        return true;
    }
}
