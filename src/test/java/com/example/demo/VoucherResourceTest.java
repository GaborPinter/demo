package com.example.demo;

import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
public class VoucherResourceTest {

	@Autowired
	VoucherService voucherService;
	
	@Test
	@DisplayName("Retrieve voucher by id")
	public void addNewVoucherTestAssertNotEquals() throws JSONException{
		Voucher retrieveVoucherById = voucherService.retrieveVoucherById("1");
		String id = retrieveVoucherById.getId();
		JSONAssert.assertEquals("1", id,true);
	}
	
}
