package utilities;

import java.io.IOException;

public class DataProviders {
    @org.testng.annotations.DataProvider(name="LoginData")

    public String[][] getData() throws IOException {
        String path=System.getProperty("user.dir")+"/testData/Opencart_LoginData.xlsx";
        ExcelUtility xlpath=new ExcelUtility(path);

        int totalrow=xlpath.getRowCount("Sheet1");
        int totalcol=xlpath.getCellCount("Sheet1",1);

        String loginData[][]=new String[totalrow][totalcol];
        for(int i=1;i<=totalrow;i++)
        {
            for(int j =0;j<totalcol;j++)
            {
                loginData[i-1][j]=xlpath.getCellData("Sheet1",i,j);
            }
        }
        return loginData;
    }

}
