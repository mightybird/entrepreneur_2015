package org.sicdlab.entrepreneur.test.service.impl;

import org.sicdlab.entrepreneur.test.service.ITestService;
import org.springframework.stereotype.Service;

@Service("userService")
public class TestServiceImpl implements ITestService {

	@Override
	public void test() {
		System.out.println("hello world!!");
	}

}
