package Adv_DSA;

import java.util.Arrays;

public class MinimumAbsoluteDifference {
    static void merge(int[] A, int start, int mid, int end){
        int n = mid-start+1;
        int m = end-mid;
        int[] B = new int[n];
        int[] C = new int[m];
//        int len = A.length;
        for (int i = start; i <= mid; i++) {//copying 1st half in B[]
            B[i-start] = A[i];
        }
        for (int i = mid+1; i <= end; i++) {//copying 2nd half in C[]
            C[i-(mid+1)] = A[i];
        }
        //Merge in A
        int i = 0, j = 0;
        for(int k = start; k <= end; k++){
            if(i==n){
                A[k] = C[j];
                j += 1;
            }
            else if (j == m || B[i] <= C[j]) {
                A[k] = B[i];
                i += 1;
            }
            else{
                A[k] = C[j];
                j += 1;
            }
        }
    }
    static void sort(int[] A, int s, int e){
        if (s == e){// only 1 elem remaining
            return;
        }
        int mid = (s + e)/2;
        sort(A,s,mid);//sort first half
        sort(A,mid+1,e);//sort second half
        merge(A,s,mid,e);
    }
    public static int solve(int[] A) {
        int n = A.length;
//        Arrays.sort(A);//implement merge sort
        sort(A,0,n-1);
        int mini = Integer.MAX_VALUE;
        for(int i = 1; i < A.length; i++){
            mini = Math.min(mini,Math.abs(A[i]-A[i-1]));
        }
        return mini;
    }
    public static void main(String[] args) {
        int[] A = {5, 17, 100, 11};
        A = new int[] {33, 82, 75, 4, 52, 74, 79, 46, 18, 73, 1, 83, 46, 94, 44, 86, 40, 1, 46, 24, 99, 16, 88, 6, 66, 17, 1};
        int ans = solve(A);
        System.out.println(ans);
    }
}
