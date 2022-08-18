package Adv_DSA;

import java.util.Arrays;

public class MinimumDifference {
    public static int solve(int A, int B, int[][] C) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A; i++) {
                Arrays.sort(C[i]);
        }
        for (int i = 0; i < A-1; i++) {
            for (int j = 0; j < B; j++) {
                int target = C[i][j];
                int L = 0, R = B-1;
                while(L<=R){
                    int mid = L + (R-L)/2;
                    if(C[i+1][mid]<target){
                        L = mid+1;
                    }
                    else{
                        R = mid-1;
                    }
                }
                int upperBound = R+1, lowerBound = L-1;
                int upperBoundVal = 0, lowerBoundVal = 0;
                if(lowerBound<0){
                    upperBoundVal =  C[i + 1][R + 1];
                    ans = Math.min(ans,upperBoundVal-C[i][j]);
                }
                else if(upperBound>B-1){
                    lowerBoundVal = C[i + 1][L - 1];
                    ans = Math.min(ans,C[i][j]-lowerBoundVal);
                }
                else{
                    upperBoundVal = C[i + 1][R + 1];
                    lowerBoundVal = C[i + 1][L - 1];
                    ans = Math.min(ans, Math.min(upperBoundVal-C[i][j],C[i][j]-lowerBoundVal));
                }

            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int A = 4, B = 4;
        int[][] C = {{9,4,3,6},{7,5,2,1},{1,9,3,4},{6,4,5,8}};
        System.out.println(solve(A,B,C));
    }
}
