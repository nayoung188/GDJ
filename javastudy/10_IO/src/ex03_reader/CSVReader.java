package ex03_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

	public static void main(String[] args) {
		
		
		File file = new File("C:\\storage", "product.csv");
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			
			// 첫 행 읽어 버리기
			br.readLine();
			
			
		} catch ( IOException e) {
			e.printStackTrace();
		}

	}

}
