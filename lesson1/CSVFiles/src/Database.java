import java.util.Arrays;

public class Database {
    private String[] colNames;
    private int numRows;
    private String[][] data;

    public String[] getColNames() {
        return colNames;
    }

    public void setColNames(String[] colNames) {
        this.colNames = colNames;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public Database(String contents) {
        String []str = contents.split("\n");
        colNames = str[0].split(",");
        numRows = str.length - 1;
        data = new String[numRows][colNames.length];
        for(int i = 1,j = 0; i<numRows; i++,j++)
        {
            data[j] = str[i].split(",");
        }
    }

    public String getValue(String columnName,int row){
/* TODO
This method should return the data contained on row "row" and the column matching  @columname */
        int j=0;
        for(int i = 0;i<colNames.length;i++)
        {
            if(colNames[i].equals(columnName))
            {
                j = i;
                break;
            }
        }
        return data[row][j];
    }
}


