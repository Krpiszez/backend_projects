package stream.anagram;

import java.io.File;
import java.io.IOException;
import java.util.*;

// Prints all large anagram groups in a dictionary iteratively (Page 204)
public class IterativeAnagrams {
	public static void main(String[] args) throws IOException {
		
		File dictionary = new File("C:\\Users\\Admin\\IdeaProjects\\backend_projects\\EffectiveJava3Edition\\src\\main\\java\\stream\\anagram\\words");
		//int minGroupSize = Integer.parseInt(args[1]);
		int minGroupSize = 2;

		Map<String, Set<String>> groups = new HashMap<>();
		try (Scanner s = new Scanner(dictionary))
		{
			while (s.hasNext())
			{
				String word = s.next();
				groups.computeIfAbsent(alphabetize(word), (unused) -> new TreeSet<>()).add(word);
			}
		}

		for (Set<String> group : groups.values())
			if (group.size() >= minGroupSize)
				System.out.println(group.size() + ": " + group);
	}

	private static String alphabetize(String s) 
	{
		char[] a = s.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}
	
}