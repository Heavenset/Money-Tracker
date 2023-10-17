package etc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class FileManips {
	static String path;

	public void writeToFile(String transactionType, int number) throws IOException {
		if (transactionType.equals("spending")) {
			path = "D:/MoneyTracker/spendingData.txt";
		} else {
			path = "D:/MoneyTracker/gettingData.txt";
		}
		String folderPath = "D:/MoneyTracker";
		File file = new java.io.File(path);
		file.getParentFile().mkdirs();
		Path folder = Paths.get(path);

		if (!Files.exists(folder)) {
			Files.createDirectories(folder);
			System.out.println("Folder created: " + folderPath);
			FileWriter writer = new FileWriter(file, true);
			writer.write(String.valueOf(number) + "\n");
			writer.close();
			System.out.println("Number written to file: " + number);
		}
	}

	public int readFromFile() throws IOException {
		List<Integer> values = new ArrayList<>();

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
		BinaryOperator<Integer> accumulator = (x, y) -> x + y;
		Optional<Integer> sum = values.stream().reduce(accumulator);

		int summary = sum.get();

		return summary;
	}
}