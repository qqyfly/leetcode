class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int sumSw=0;
        for(int i=0;i<sweetness.size();i++){
            sumSw+=sweetness[i];
        }

        int avg=sumSw/(k+1);
        
        int l=0,r=avg;

        while(l<=r){
            int mid=(r-l)>>1+l;
            if(isFeasible(mid, k,sweetness))
                l=mid+1;
            else r=mid-1;
        }
        return r;
    }

    boolean isFeasible(int minDiv,int k,int[] sweetness){
        int count=0,sum=0;
        for(int x:sweetness){
            sum+=x;
            if(sum>=minDiv){
                sum=0;
                count++;
            }
        }
        return count>=k+1;
    }
}