package Adv_DSA;

public class MatrixSearch {
    public static int searchMatrix(int[][] A, int B) {
        int rowLen = A.length, colLen = A[0].length;
        int r = 0;
        while (r < rowLen){
            int L = 0, H = colLen-1;
            while (L<=H){
                int mid = L + (H-L)/2;
                if(A[r][mid]==B){
                    return 1;
                }
                if (A[r][mid]<B){
                    L = mid+1;
                }
                else {
                    H = mid-1 ;
                }
            }
            r++;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[][] A = {{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
        int B = 2;
        System.out.println(searchMatrix(A,B));
    }
}
