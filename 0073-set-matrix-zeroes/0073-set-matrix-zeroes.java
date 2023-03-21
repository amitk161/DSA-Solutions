class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == 0){
                    for(int k=0; k<col; k++){
                        if(matrix[i][k] != 0){
                            matrix[i][k] = (int)(1e9);
                        }
                    }
                }
                if(matrix[i][j] == 0){
                    for(int k=0; k<row; k++){
                        if(matrix[k][j] != 0){
                            matrix[k][j] = (int)(1e9);
                        }
                    }
                }
            }
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == (int)(1e9)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}