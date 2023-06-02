public class Overshoot {
    private long n;
    private long[] nums;
    Overshoot(long a){
        this.n =a;
    }
    public long[] result(){
        for(int d=2; d*d<=n; d++){
            // если разделилось нацело, то составное
            if(n%d==0){
                nums = new long[]{d, (n / d)};
                break;
            }
        }
        return nums;
    }
}
