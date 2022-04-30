package com.vamsi.test;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class Practice {

	public static void main(String[] args) {
		
        List<String> list1 = new ArrayList<String>(Arrays.asList("A", "B", "C", "B"));
        List<String> list2 = new ArrayList<String>(Arrays.asList("B", "C", "D", "E", "F", "B"));
        
        System.out.println(  Runtime.getRuntime().availableProcessors());
        
        System.out.println(new Practice().intersection(list1, list2));
        System.out.println(new Practice().union(list1, list2));
    }
	
    public static int FIND_PAIRS(int[] nums, int k) {
    	int result = 0;
    	Map<Integer, Integer> counter = new HashMap<>();

    	for(int n : nums) {
    		counter.put(n, counter.getOrDefault(n, 0)+1);
    	}
    	
    	for(Entry<Integer, Integer> entry : counter.entrySet()) {
    		int key = entry.getKey();
    		int value = entry.getValue();
    		
        	if(k > 0 && counter.containsKey(key+k)) {
        		result ++;
        	}
        	else if (k==0 && value >1) {
        		result++;
        	}
    	}
    	return result;
    }
      
    public static int MAX_PROFIT(int[] prices) {
        int maxProf = 0, j = 0;
        
        for (int i = 1; i < prices.length; i ++){
          int comparePrice = prices[i] - prices[j];
          if(comparePrice > maxProf){
            maxProf = comparePrice;
          }     
          if(prices[i] < prices[j])
              j = i;
        }
        return maxProf;
    }
    
    public static Set<Set<String>> GROUP_ANAGRAMS(List<String> words)
    {
        // a set to store anagrams
        Set<Set<String>> anagrams = new HashSet<>();
 
        // base case
        if (words == null) {
            return anagrams;
        }
 
        // sort each word on the list
        List<String> list = words.stream()
                .map(s -> Stream.of(s.split("")).sorted()
                        .collect(Collectors.joining()))
                .collect(Collectors.toList());
 
        // construct a map where the key is each sorted word,
        // and value is a list of indices where it is present
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++)
        {
            map.putIfAbsent(list.get(i), new ArrayList<>());
            map.get(list.get(i)).add(i);
        }
 
        // traverse the map and read indices for each sorted key.
        // The anagrams are present in the actual list at those indices
        for (var entry: map.entrySet())
        {
            Set<String> collection = entry.getValue().stream()
                    .map(i -> words.get(i))
                    .collect(Collectors.toSet());
            if (collection.size() > 1) {
                anagrams.add(collection);
            }
        }
 
        return anagrams;
    }
    
    public static boolean PALINDROME(String origString) {

        int length = origString.length();
         
        boolean isPalindrome = true;  
         
        for(int beginIndex = 0; beginIndex < length; beginIndex++)
        {
          if(origString.charAt(beginIndex) != origString.charAt(length-1-beginIndex)) {
            System.out.println("String is not a palindrome.");
            isPalindrome = false;
            break;
          }
        }
          
        return isPalindrome;
    }
    
    public static boolean PRIME_NUMBER(int num) {
        boolean isPrime = true;
        
        //It is because a number is not divisible by more than its half.
        for (int i = 2; i <= num / 2; ++i) {
          // condition for nonprime number
          if (num % i == 0) {
        	  isPrime = false;
            break;
          }
        }
        return isPrime;
    }

    public static void FIBONACCI (int num) {
    	
        int n = 10, firstTerm = 0, secondTerm = 1;
        System.out.println("Fibonacci Series till " + n + " terms:");

        for (int i = 1; i <= n; ++i) {
          System.out.print(firstTerm + ", ");

          // compute the next term by adding firstTerm and secondTerm
          int nextTerm = firstTerm + secondTerm;
          firstTerm = secondTerm;
          secondTerm = nextTerm;
        }
    }
    
    public static int majorityElement(final int[] num) {
        int[] count = new int[101];
		int temp = 0;
		
		for(int i=0; i<num.length; i++) {
			temp = num[i];
			count[temp] ++;
		}
		
		for(int i=1; i < count.length; i++) {
			
			double floor = Math.floor(num.length/2);
			
			if(count[i] > floor) {
                return i;
			}
		}
        return  0;
    }

    public static int BINARY_SEARCH(int[] values, int x) {
    	
    	//Binary search needs Sorted Array to work!
    	//Finding index of the element in the array
    	int startIndex = 0;
    	int endIndex = values.length-1;
    	
    	while(startIndex <= endIndex) {
    		int mid = (startIndex + endIndex)/2;
    		
    		if(values[mid] == x)
    			return mid;
    		else if(values[mid] < x) 
    			startIndex = mid + 1;
    		else
    			endIndex = mid -1;
     	}
    	
    	return -1;
    }
    
    static void IS_ANAGRAM(String str1, String str2) {  
        String s1 = str1.replaceAll("\\s", "");  
        String s2 = str2.replaceAll("\\s", "");  
        boolean status = true;  
        if (s1.length() != s2.length()) {  
            status = false;  
        } else {  
            char[] ArrayS1 = s1.toLowerCase().toCharArray();  
            char[] ArrayS2 = s2.toLowerCase().toCharArray();  
            Arrays.sort(ArrayS1);  
            Arrays.sort(ArrayS2);  
            status = Arrays.equals(ArrayS1, ArrayS2);  
        }  
        if (status) {  
            System.out.println(s1 + " and " + s2 + " are anagrams");  
        } else {  
            System.out.println(s1 + " and " + s2 + " are not anagrams");  
        }  
    }
    
    public <T> List<T> union(List<T> list1, List<T> list2) {
        Set<T> set = new HashSet<T>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<T>(set);
    }

    public <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }

public class TreeNode{
	
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
	}
	
	public TreeNode searchNode(int data) {
		if(data == this.data) {
			return this;
		}
		else if(data < this.data) {
			return (left != null) ?  left.searchNode(data) :  null;
		}
		else
			return (right != null) ?  right.searchNode(data) :  null;
	}
	
	public void insert(int data) {
		if(data < this.data) {
			if(left != null) 
				left.insert(data);
			else 
				left = new TreeNode(data);
		}
		else {
			if(right != null)
				right.insert(data);
			else 
				right = new TreeNode(data);
		}

	}
}

    
    
}

