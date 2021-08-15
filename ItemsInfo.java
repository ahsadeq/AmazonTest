import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemsInfo {
       
	public static void getinfo() throws ClassNotFoundException, SQLException, InterruptedException {
		
		
		WebDriver wb= AmazonItems.Setup();
		wb.get("https://www.amazon.ae/");
		wb.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("huwaei nova 7i");
		wb.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		wb.findElement(By.linkText("HUAWEI Nova 7i Smartphone,Dual SIM,128 GB ROM, 8 GB RAM,48MP,4200 mAh,6.4\" Display - Sakura Pink")).click();
		String Title0= wb.findElement(By.xpath("//*[@id=\"productTitle\"]")).getText();
		String strPrice0=wb.findElement(By.xpath("//*[@id=\"priceblock_ourprice\"]")).getText();
		String dblprice0=strPrice0.replaceAll("[^0-9.]","");
		double price0=Double.valueOf(dblprice0);
		String strRam0= wb.findElement(By.xpath("//*[@id=\"productDetails_techSpec_section_1\"]/tbody/tr[2]/td")).getText();
		String intRam0=strRam0.replaceAll("[^0-9]", "");
		int Ram0=Integer.valueOf(intRam0);
		System.out.println(Title0);//for tracking while coding 
		System.out.println(price0);//for tracking while coding 
		System.out.println(Ram0);//for tracking while coding 
		
		wb.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		Thread.sleep(2000);
		wb.findElement(By.linkText("Huawei P30 lite Dual SIM - 128GB, 4GB RAM, 4G LTE, Peacock Blue")).click();
		String Title1= wb.findElement(By.xpath("//*[@id=\"productTitle\"]")).getText();
		String strPrice1=wb.findElement(By.xpath("//*[@id=\"priceblock_ourprice\"]")).getText();
		String dblprice1=strPrice1.replaceAll("[^0-9.]","");
		double price1=Double.valueOf(dblprice1);
		String strRam1= wb.findElement(By.xpath("//*[@id=\"productDetails_techSpec_section_1\"]/tbody/tr[2]/td")).getText();
		String intRam1=strRam1.replaceAll("[^0-9]", "");
		int Ram1=Integer.valueOf(intRam1);
		System.out.println(Title1);//for tracking while coding 
		System.out.println(price1);//for tracking while coding 
		System.out.println(Ram1);//for tracking while coding 
		
		wb.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		Thread.sleep(2000);
		wb.findElement(By.linkText("HUAWEI Nova 7 SE, 5G Dual-SIM Mobile Phone, 64 MP AI Quad- Camera, 128 GB 8 GB RAM , 6.5\" Punch FullView Display, 40 W SuperCharge, Midsummer Purple")).click();
		String Title2= wb.findElement(By.xpath("//*[@id=\"productTitle\"]")).getText();
		String strPrice2=wb.findElement(By.xpath("//*[@id=\"priceblock_ourprice\"]")).getText();
		String dblprice2=strPrice2.replaceAll("[^0-9.]","");
		double price2=Double.valueOf(dblprice2);
		String strRam2= wb.findElement(By.xpath("//*[@id=\"productDetails_techSpec_section_1\"]/tbody/tr[2]/td")).getText();
		String intRam2=strRam2.replaceAll("[^0-9]", "");
		int Ram2=Integer.valueOf(intRam2);
		System.out.println(Title2);//for tracking while coding 
		System.out.println(price2);//for tracking while coding 
		System.out.println(Ram2);//for tracking while coding 
		
	
	String [] Title= {Title0,Title1,Title2};
	double [] Price= {price0,price1,price2};
	int [] Ram= {Ram0,Ram1,Ram2};
	
	Connection con=DBUtil.getConnection();
	
	String sql="insert into huawei7 values(?,?,?)";
	PreparedStatement ps=con.prepareStatement(sql);
	
	for (int i=0; i<3; i++) {
	ps.setString(1,Title[i]);
	ps.setDouble(2,Price[i]);
	ps.setInt(3,Ram[i]);
	ps.executeUpdate();
	}
		

	
	con.close();
}
}
