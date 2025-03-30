package com.java8;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class EmployeePojo{
    public int id;
    public String name;
    public double salary;
    public String address;
    public CategoryDto category;

    //public CategoryDto(){}
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class CategoryDto{
    public int id;
    public String name;
    public CategoryDto subCategory;

    //public CategoryDto(){}
}

public class Java8 {
    public static void main(String[] args) {
        List<EmployeePojo> employeePojos = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        Map<CategoryDto, Map<CategoryDto, List<EmployeePojo>>> map = employeePojos.stream().
                collect(Collectors.groupingBy(EmployeePojo::getCategory, Collectors.groupingBy(e -> e.getCategory().getSubCategory())));

        /*
        Problem: Given a list of integers, find and print all the duplicate elements using Java 8 streams.
         */
        List<Integer> duplicateIntegers = integers.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        /*
        Problem: Given a list of employees with id, name, and salary, sort them in ascending order of salary.
        If two employees have the same salary, sort them alphabetically by name.
         */
        employeePojos.stream().sorted((e1, e2) -> {
            int compareBySalary = Double.compare(e1.getSalary(), e2.getSalary());
            if (compareBySalary == 0) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return compareBySalary;
            }
        }).toList();

        employeePojos.stream().sorted(Comparator.comparing(EmployeePojo::getSalary).thenComparing(EmployeePojo::getName)).toList();



        /*
        Given a list of integers, find the second-highest number using streams.
         */
        integers.stream().sorted(Comparator.reverseOrder()).limit(2).toList().get(1);
        Optional<Integer> x = integers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();

        /*Given a list of words, group them by their first letter.*/
        List<String> strings = new ArrayList<>();
        strings.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));

        /*Given a list of words, group them by their first word.*/
        List<String> paragarphs = new ArrayList<>();
        paragarphs.stream().collect(Collectors.groupingBy(s -> s.split(" ")[0]));

        /*Problem: Given a list of strings, find the longest string using Java 8 Streams.*/
        strings.stream().sorted((s1, s2) -> Integer.compare(s2.length(), s1.length())).findFirst();
        strings.stream().max(Comparator.comparing(String::length).reversed());

        /*Problem: Given a list of strings, convert them to uppercase using streams.*/

        strings.stream().map(String::toUpperCase).toList();

        /*Problem: Given a list of integers, find the sum of all even numbers using streams.*/
        integers.stream().mapToInt(Integer::intValue).sum();

        /*
        Given a string, find the first non-repeating character using Java 8 Streams.
         */
        strings.get(0).chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(e -> e.getValue() == 1)
                .findFirst();

        /*
        Problem: Given a list of integers, find the most frequently occurring element.
         */
        integers.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting())).entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));

        /*Given a string, check if it is a palindrome using Java 8 Streams.*/
        String input = "";
        boolean isPalindrome = IntStream.range(0, input.length() / 2)
                .allMatch(i -> input.charAt(i) == input.charAt(input.length() - 1 - i));

    }
}

