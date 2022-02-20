package com.moneta.test.project.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.moneta.test.project.service.CalculateService;

@Service
public class CalculateServiceImpl implements CalculateService {

	@Override
	public String calculateInput(String number) {
		String[] numbersSplit = number.split("");
		List<String> numbers = Arrays.asList(numbersSplit);
		numbers = numbers.stream().filter(item -> !item.equals("7")).collect(Collectors.toList());
		int evenNumbers = 0;
		
		for (int i = numbers.size() - 1; i >= 0; i--) {
			Integer num = Integer.parseInt(numbers.get(i));
			
			if (num <= 3 && i != numbers.size() - 1) {
				Collections.swap(numbers, i, i + 1);
			}
			
			if (num == 8 || num == 9) {
				num *= 2;
				numbers.set(i, String.valueOf(num));
			}
			
			if (num % 2 == 0) {
				evenNumbers++;
			}
		}
		
		int resultInt = Integer.parseInt(String.join("", numbers));
		String result = String.valueOf(resultInt / evenNumbers);
		
		return result;
	}

}
