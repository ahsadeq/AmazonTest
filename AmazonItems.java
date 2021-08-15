import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonItems {
	
public static WebDriver Setup() throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Ahmad\\Desktop\\Selenium\\chromedriver.exe");
	WebDriver wb=new ChromeDriver();
	wb.manage().window().maximize();
	Thread.sleep(2000);
	return wb;
}
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		ItemsInfo.getinfo();
		String expectedname="HUAWEI Nova 7i Smartphone,Dual SIM,128 GB ROM, 8 GB RAM,48MP,4200 mAh,6.4\" Display - Sakura Pink";
		double expectedprice=811.4;
		int expectedmemory=6;
		
		Connection con=DBUtil.getConnection();
		String sql="select * from Huawei7 where Ram=6";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		boolean status=false;
		
		while (rs.next()) {
			String actualname=rs.getString(1);
			Double actualprice=rs.getDouble(2);
			Integer actualmemory=rs.getInt(3);		
			
			if(actualname.equals(expectedname)&&actualprice.equals(expectedprice)&&actualmemory.equals(expectedmemory)) {
				System.out.println("Test Case Passed");
				status=true;
				break;
			}
				
		}
		if (status==false) {
			System.out.println("Test Case Failed");
		}
		
		con.close();
	}
	
	
}
