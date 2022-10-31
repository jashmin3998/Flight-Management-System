package Output;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVOutputWriter implements OutputWriter {

	List<String> list;
	String header;
	FileWriter fileWriter;
	
	public CSVOutputWriter(String fileName, String header, List<String> list) {
		// TODO Auto-generated constructor stub
		this.list = list;
		this.header = header;
		try {
			this.fileWriter = new FileWriter(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("FileName Already Exist");
		}
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		
		try {
			if(!header.isEmpty()) {
				fileWriter.write(header);
			}
			for(String str: list) {
				fileWriter.write(str);
			}
			fileWriter.close();
		}
		catch(IOException e) {
			System.out.println("IOException");
		}
		
	}

}
