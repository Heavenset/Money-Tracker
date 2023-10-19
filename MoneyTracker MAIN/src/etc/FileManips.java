package etc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class FileManips {
	static String path;

	public void writeToFile(String transactionType, int number) throws IOException {
		String path;
		if (transactionType.equals("spending")) {
			path = "D:/MoneyTracker/spendingData.txt";
		} else {
			path = "D:/MoneyTracker/gettingData.txt";
		}

		File file = new File(path);

		try {
			if (!file.exists()) {
				file.createNewFile(); // Create the file if it doesn't exist
				System.out.println("File created: " + path);
			} else {
				System.out.println("File already exists: " + path);
			}
			FileOutputStream fos = new FileOutputStream(file, true);
			OutputStreamWriter writer = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
			writer.write(Integer.toString(number) + "\n");
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	List<Integer> values = new ArrayList<>();

	public int readFromFile() throws IOException {

		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = reader.readLine()) != null) {
				try {
					int value = Integer.parseInt(line);
					values.add(value);
				} catch (NumberFormatException e) {
					System.err.println("Skipping invalid line: " + line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Getting sum from files
		BinaryOperator<Integer> accumulator = (x, y) -> x + y;
		Optional<Integer> sum = values.stream().reduce(accumulator);

		int summary = sum.orElse(0);

		return summary;
	}
}