/*
 * Used for printing a string of the matrix
 * Does so by double for loop iteration. :< 
 */
public class PrintMatrix {
    public String printMatrix(Matrix2 m){
        String content = ""; //to build string
        
        for(int r = 0; r<m.numrows(); r++){
            for(int c = 0; c<m.numcolumns(); c++){
                if(m.getter(r,c) == m.chr){
                    content = content + m.chr;
                }else if(m.getter(r,c) == '\0'){
                    content = content + ' ';
                }else if(m.getter(r, c) == ' '){
                    content = content + '0';
                }else if(m.getter(r, c) == '#'){
                    content = content + '#';
                }else if(m.getter(r, c) == '~'){
                    content = content + '~';
                }else{
                    throw new IllegalArgumentException("The matrix does not contain a number thats 1 or 0");
                }
            }
            content = content +"\n";
        }
        return content;
    }
}
