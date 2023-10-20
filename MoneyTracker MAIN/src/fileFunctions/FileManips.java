package fileFunctions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
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
		// seting path variable relying on type
		if (transactionType.equals("spending")) {
			path = "D:/MoneyTracker/Data/spendingData.txt";
		} else {
			path = "D:/MoneyTracker/Data/gettingData.txt";
		}
		File file = new File(path);
		// Creating file if not exist
		if (!file.exists()) {
			Files.createDirectories(file.getParentFile().toPath()); // Create parent directories
			file.createNewFile(); // Create the file if it doesn't exist
		}

		try {
			// Adding values user entered in TextBox
			FileOutputStream fos = new FileOutputStream(file, true);
			OutputStreamWriter writer = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
			writer.write(Integer.toString(number) + "\n");
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int readFromFile() throws IOException {
		List<Integer> values = new ArrayList<>();
		// Reading each line from the file
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = reader.readLine()) != null) {
				try {
					int value = Integer.parseInt(line);
					values.add(value);
				} catch (NumberFormatException e) {

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Getting sum from file
		BinaryOperator<Integer> accumulator = (x, y) -> x + y;
		Optional<Integer> sum = values.stream().reduce(accumulator);

		int summary = sum.orElse(0);

		return summary;
	}

	public void deleteFolder() {
		// Simply deleting Data folder which contains .txt files from program
		Path path = Paths.get("D:/MoneyTracker/Data");
		try {
			Files.walk(path).sorted((p1, p2) -> -p1.compareTo(p2)).forEach(p -> {
				try {
					Files.delete(p);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}