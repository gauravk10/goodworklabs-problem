/**
 * 
 */
package com.goodworklabs.solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author gaurav
 *
 */
public class NewsPaperHashTags {

	private List<Object> findWordLength(String input) {
		List<Object> list = new ArrayList<Object>();
		String output = "";
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
				output = output + input.charAt(i);
			}

		}
		list.add(output);
		list.add(output.length());
		return list;
	}

	private List<String> getHashTags(String input) {
		Map<String, Integer> hashTagMap = new LinkedHashMap<>();
		Map<String, Integer> sortedHashTagMap = new LinkedHashMap<>();
		List<String> result = new ArrayList<>();
		int count = 0;
		String[] splitStr = input.split(" ");
		for (String item : splitStr) {
			List<Object> list = findWordLength(item.toLowerCase());
			String data = "#" + (String) list.get(0);
			int length = (int) list.get(1);
			hashTagMap.put(data, length);
		}
		hashTagMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(item -> sortedHashTagMap.put(item.getKey(), item.getValue()));
		for (Entry<String, Integer> entry : sortedHashTagMap.entrySet()) {
			count++;
			if (count <= 3) {
				result.add(entry.getKey());
			} else {
				break;
			}

		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NewsPaperHashTags npht = new NewsPaperHashTags();
		String input = "Hey Parents, Surprise, Fruit Juice Is Not Fruit";
		List<String> hashTagsList = npht.getHashTags(input);
		System.out.println(hashTagsList);
	}

}
