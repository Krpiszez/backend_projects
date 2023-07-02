package stream.anagram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

// Overuse of streams - don't do this! (page 205)
public class StreamAnagrams {
	
	// coin
	
	public static void main(String[] args) throws IOException {
		Path dictionary = Paths.get("C:\\Users\\Admin\\IdeaProjects\\backend_projects\\EffectiveJava3Edition\\src\\main\\java\\stream\\anagram\\words");
		int minGroupSize = 1;

		try (Stream<String> words = Files.lines(dictionary)) 
		{
			words.collect(groupingBy(word -> word.chars().sorted()
					.collect(StringBuilder::new, (sb, c) -> sb.append((char) c), StringBuilder::append).toString()))
					.values()
					.stream().filter(group -> group.size() >= minGroupSize)
					.map(group -> group.size() + ": " + group)
					.forEach(System.out::println);
		}
	}
	
}
