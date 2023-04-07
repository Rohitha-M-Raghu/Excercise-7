package hack;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.List;
import java.util.Set;

public class Hacker {
	
	private Hacker() {
		
	}
	
	private static Path getFile() throws IOException {
		
		Path filePath = Paths.get("History.txt");
		
		if (Files.notExists(filePath)) {
			try {
				Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rw-------");
				FileAttribute<Set<PosixFilePermission>> attributes = PosixFilePermissions.asFileAttribute(permissions);
				Files.createFile(filePath,attributes);
			} catch (IOException e) {
				throw new IOException("unable to create History.txt");
			}
		}
		
		return filePath;
	}
	
	public static void writeHistory(List<String> urlHistory) throws IOException {
		Path filePath = getFile();
		
		try {
			Files.write(filePath, urlHistory, StandardCharsets.UTF_8);
		}
		catch (IOException e) {
			throw new IOException("Error Occured while writing into History.txt");
		}
	}
	
	public static void readHistory(List<String> urlHistory) throws IOException {
		Path filePath = getFile();
		List<String> historyData;
		
		try {
			historyData = Files.readAllLines(filePath, StandardCharsets.UTF_8);
		}
		catch (IOException e) {
			throw new IOException("Error occured while reading History.txt");
		}
		
		urlHistory.clear();
		urlHistory.addAll(historyData);
	}
}
