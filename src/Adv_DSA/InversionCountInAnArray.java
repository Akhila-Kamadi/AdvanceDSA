package Adv_DSA;

public class InversionCountInAnArray {
    static long ans = 0;
    static int mod = 1000000007;
    static void merge(int[] A, int start, int mid, int end){
        int n = mid - start + 1, m = end - mid;
        int[] B = new int[n];
        int[] C = new int[m];
        for (int i = start; i <= mid; i++) {
            B[i-start] = A[i];
        }
        for (int i = mid+1; i <= end; i++) {
            C[i-(mid+1)] = A[i];
        }
        int i = 0, j = 0;
        for (int k = start; k <= end; k++) {
            if(i == n){
                A[k] = C[j];
                j += 1;
            } else if (j == m || B[i] <= C[j]) {
                A[k] = B[i];
                i += 1;
            }
            else {
                A[k] = C[j];
                j += 1;
                ans = (ans + n-i)%mod;
            }
        }
    }
    static void sort(int[] A, int s, int e){
        if(s == e){
            return;
        }
        int mid = (s+e)/2;
        sort(A,s,mid);
        sort(A,mid+1,e);
        merge(A,s,mid,e);
    }
    public static int solve(int[] A) {
        int n = A.length;
        sort(A,0,n-1);
        return (int)ans%mod;
    }
    public static void main(String[] args) {
        int[] A = {4,5,1,2,6,3};
        System.out.println(solve(A));
    }
}
