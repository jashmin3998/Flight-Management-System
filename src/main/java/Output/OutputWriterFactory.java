package Output;

import java.util.List;

public class OutputWriterFactory {

	public static OutputWriter getOutputWriter(String fileName, String header, List<String> list) {
		
		if(fileName.contains(".csv")) {
			return new CSVOutputWriter(fileName, header, list);
		}
		else {
			return new TXTOutputWriter(fileName, header, list);
		}
		
	}
}
