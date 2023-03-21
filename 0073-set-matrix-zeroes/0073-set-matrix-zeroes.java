class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == 0){
                    list1.add(i);
                    list2.add(j);
                }
            }
        }
        
        for(int m=0; m<list1.size(); m++){
            for(int p=0; p<col; p++){
                matrix[list1.get(m)][p] = 0;
            }
        }
        
        for(int n=0; n<list2.size(); n++){
            for(int q=0; q<row; q++){
                matrix[q][list2.get(n)] = 0;
            }
        }
    }
}