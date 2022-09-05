package com.example.demo;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class VoucherResource {

	private VoucherService voucherService;

	public VoucherResource(VoucherService voucherService) {
		super();
		this.voucherService = voucherService;
	}
	
	@RequestMapping("/vouchers")
	public List<Voucher> retrieveAllVouchers() {
		return voucherService.retrieveAllVouchers();
	}
	
	@RequestMapping("/vouchers/{voucherId}")
	public Voucher retrieveVoucherById(@PathVariable String voucherId) {
		Voucher voucher = voucherService.retrieveVoucherById(voucherId);
		if (voucher == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return voucher;
	}
	
	@RequestMapping(value = "/vouchers",method = RequestMethod.POST)
	public ResponseEntity<Object> addNewVoucher(String voucherId,@RequestBody Voucher voucher) {
		String voucherid = voucherService.addNewVoucher(voucherId,voucher);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{voucherid}").buildAndExpand(voucherid).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@RequestMapping(value = "/vouchers/{voucherId}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteVoucher(@PathVariable String voucherId) {
		voucherService.deleteVoucher(voucherId);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping("/vouchers/{voucherId}/redeem")
	public String redeem(@ PathVariable String voucherId) {
		String message = voucherService.redeem(voucherId);
		return message;
	}
	
}
