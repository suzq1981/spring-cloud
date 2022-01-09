package com.badou.senior.producer.service.impl;

import org.springframework.stereotype.Service;

import com.badou.senior.producer.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	//@Autowired
	//private DepartmentMapper deptMapper;

	@Override
	//@Transactional(propagation = Propagation.REQUIRED)
	public void autoBatchCreateDepart() {
		//Department sale = Department.builder().deptName("销售").description("销售部").build();
		//deptMapper.createDept(sale);
		long start = System.currentTimeMillis();
		while (true) {
			if (System.currentTimeMillis() - start > 5000) {
				break;
			}
		}
		//Department market = Department.builder().deptName("市场").description("市场部").build();
		//deptMapper.createDept(market);

		if (Thread.currentThread().isInterrupted()) {
			throw new RuntimeException("Hystrix Thread interrupted");
		}
	}

}
