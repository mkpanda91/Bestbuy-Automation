package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	String path = ".\\testData\\Spicejet_TestData.xlsx";
	ExcelUtility xlutil;
	int totalrows;
	int totalcols;
	
	@DataProvider(name = "SignUp")
	public String[][] getDataForSignUp() throws IOException {

		xlutil = new ExcelUtility(path);
		totalrows = xlutil.getRowCount("Sheet1");
		totalcols = xlutil.getCellCount("Sheet1", 1);

		String outputData[][] = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				outputData[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		return outputData;
	}
	
	
	@DataProvider(name = "EmailLogin")
	public String[][] getDataForLoginByEmail() throws IOException {

		xlutil = new ExcelUtility(path);
		totalrows = xlutil.getRowCount("Sheet2");
		totalcols = xlutil.getCellCount("Sheet2", 1);

		String outputData[][] = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				outputData[i - 1][j] = xlutil.getCellData("Sheet2", i, j);
			}
		}
		return outputData;
	}
	
	
	@DataProvider(name = "MobileLogin")
	public String[][] getDataForLoginByMobileNumber() throws IOException {

		xlutil = new ExcelUtility(path);
		totalrows = xlutil.getRowCount("Sheet3");
		totalcols = xlutil.getCellCount("Sheet3", 1);

		String outputData[][] = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				outputData[i - 1][j] = xlutil.getCellData("Sheet3", i, j);
			}
		}
		return outputData;
	}

	
	@DataProvider(name = "LoginData")
	public String[][] getExcelDataForLogin() throws IOException {

		xlutil = new ExcelUtility(path);
		totalrows = xlutil.getRowCount("Sheet4");
		totalcols = xlutil.getCellCount("Sheet4", 1);
		String outputData[][] = new String[totalrows][totalcols];// created for two dimension array which can store the
																	// data user and password
		for (int i = 1; i <= totalrows; i++) // read the data from excel and storing in two dimensional array
		{
			for (int j = 0; j < totalcols; j++) // i is rows j is columns
			{
				outputData[i - 1][j] = xlutil.getCellData("Sheet4", i, j);
			}
		}
		return outputData; // returning two dimension array
	}
	
	
	@DataProvider(name = "FlightStatus")
	public String[][] getDataForFlightStatusFromExcel() throws IOException {

		xlutil = new ExcelUtility(path);
		totalrows = xlutil.getRowCount("Sheet7");
		totalcols = xlutil.getCellCount("Sheet7", 1);

		String outputData[][] = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				outputData[i - 1][j] = xlutil.getCellData("Sheet7", i, j);
			}
		}
		return outputData;
	}

	
	@DataProvider(name = "PNRData")
	public String[][] getPNRDataFromExcel() throws IOException {

		xlutil = new ExcelUtility(path);
		totalrows = xlutil.getRowCount("Sheet8_9");
		totalcols = xlutil.getCellCount("Sheet8_9", 1);

		String outputData[][] = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				outputData[i - 1][j] = xlutil.getCellData("Sheet8_9", i, j);
			}
		}
		return outputData;
	}


	@DataProvider(name = "NoResultsSearch")
	public String[][] getDataForFlightSearchWithNoResults() throws IOException {

		xlutil = new ExcelUtility(path);
		totalrows = xlutil.getRowCount("Sheet10");
		totalcols = xlutil.getCellCount("Sheet10", 1);

		String outputData[][] = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				outputData[i - 1][j] = xlutil.getCellData("Sheet10", i, j);
			}
		}
		return outputData;
	}

	@DataProvider(name = "ModifySearch")
	public String[][] getDataForModifyFlightSearch() throws IOException {

		xlutil = new ExcelUtility(path);
		totalrows = xlutil.getRowCount("Sheet11");
		totalcols = xlutil.getCellCount("Sheet11", 1);

		String outputData[][] = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				outputData[i - 1][j] = xlutil.getCellData("Sheet11", i, j);
			}
		}
		return outputData;
	}

	@DataProvider(name = "InternationalFlightSearch")
	public String[][] getDataForInternationalFlightSearch() throws IOException {

		xlutil = new ExcelUtility(path);
		totalrows = xlutil.getRowCount("Sheet12");
		totalcols = xlutil.getCellCount("Sheet12", 1);

		String outputData[][] = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				outputData[i - 1][j] = xlutil.getCellData("Sheet12", i, j);
			}
		}
		return outputData;
	}

}
