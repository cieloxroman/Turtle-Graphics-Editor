/*
 * Create an actual matrix using char[][]
 */
public class Matrix2 {
    private char[][] matrix;
    public char chr = '#'; //default char unless otherwise specified
    public Matrix2(int r, int c){ // create empty matrix
        if(r<1 || c<1){
            throw new IllegalArgumentException("The row and column lengths must be greater than or equal to 1");
        }
        matrix = new char[r][c];
    }
    public Matrix2(char[][] twoDarray){ // create matrix with specified char[][]
        if(twoDarray.length == 0 || twoDarray.length<1 || twoDarray[0].length<1){
            throw new IllegalArgumentException("The row and column lengths in the specified array are less than 1");
        }
        matrix=twoDarray;
    }
    public void setCell(int x, int y, char chr){ // set a specific cell in the matrix
        this.chr = chr;
        matrix[x][y] = chr;
    }
    public char[][] getArray(){ // return a copy of the matrix char[][]
        char[][] copy = new char[this.numrows()][this.numcolumns()];
        for(int i = 0; i< this.numrows(); i++){
            System.arraycopy(matrix[i], 0, copy[i], 0, this.numcolumns());
        }
        return copy;
    }
    public void setter(char[][] newData){matrix = newData;} // sets the matrix char[][] to new specified char[][]
    public int getter(int r, int c){return matrix[r][c];} // gets a specific cell in matrix 
    public int numrows(){return matrix.length;} // return # of rows
    public int numcolumns(){return matrix[0].length;}; // return # of columns
}
