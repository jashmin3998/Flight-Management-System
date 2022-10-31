import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Flight.Category.Business;
import Flight.Category.Category;
import Flight.Category.CategoryFactory;
import Flight.Category.Economy;
import Flight.Category.PremiumEconomy;
import Output.CSVOutputWriter;
import Output.OutputWriter;
import Output.OutputWriterFactory;
import Output.TXTOutputWriter;

public class FactoryDesignPatternTestCase {

	@Test
	public void test1() {
		
		String categoryName = "Economy";
		int availableSeats = 10;
		int price = 10;
		Category category = CategoryFactory.getInstance(categoryName, availableSeats, price);
		
		assertEquals(true,  category instanceof Economy);
	}
	
	@Test
	public void test2() {
		
		String categoryName = "Premium Economy";
		int availableSeats = 10;
		int price = 10;
		Category category = CategoryFactory.getInstance(categoryName, availableSeats, price);
		
		assertEquals(true,  category instanceof PremiumEconomy);
	}
	
	
	@Test
	public void test3() {
		
		String categoryName = "Business";
		int availableSeats = 10;
		int price = 10;
		Category category = CategoryFactory.getInstance(categoryName, availableSeats, price);
		
		assertEquals(true,  category instanceof Business);
	}
	
	
	@Test
	public void test4() {
		
		String fileName = "file.txt";
		String header = "";
		List<String> list = new ArrayList<>();
		OutputWriter outputWriter = OutputWriterFactory.getOutputWriter(fileName, header, list);
		
		assertEquals(true,  outputWriter instanceof TXTOutputWriter);
	}
	
	@Test
	public void test5() {
		
		String fileName = "file.csv";
		String header = "";
		List<String> list = new ArrayList<>();
		OutputWriter outputWriter = OutputWriterFactory.getOutputWriter(fileName, header, list);
		
		assertEquals(true,  outputWriter instanceof CSVOutputWriter);
	}
	
	
	

}
