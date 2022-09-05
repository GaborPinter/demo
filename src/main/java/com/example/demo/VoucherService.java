package com.example.demo;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class VoucherService {
	
	private static List<Voucher> vouchers = new ArrayList<>();
	
	static {
		Voucher voucher = new Voucher("1","Erzsébet utalvány", "20%",LocalDate.now().plusYears(1),1);
		
		vouchers.add(voucher);
	}
	
	public List<Voucher> retrieveAllVouchers() {
		return vouchers;
	}
	
	public Voucher retrieveVoucherById(String voucherId) {
		Optional<Voucher> findFirst = vouchers.stream().filter(voucher -> voucher.getId().equals(voucherId)).findFirst();
		if (findFirst.isEmpty()) {
			return null;
		}
		return findFirst.get();
	}
	
	public String addNewVoucher(String voucherId,Voucher voucher) {
		List<Voucher> vouchers = retrieveAllVouchers();
		voucher.setId(generateRandomId());
		vouchers.add(voucher);
		return voucher.getId();
	}
	
	private String generateRandomId() {
		SecureRandom secureRandom=new SecureRandom();
		String randomId = new BigInteger(32, secureRandom).toString();
		return randomId;
	}
	
	public void deleteVoucher(String voucherId) {
		vouchers.removeIf(voucher -> voucher.getId().equalsIgnoreCase(voucherId));
	}
	
	public String redeem(String voucherId) {
		 Voucher voucher = vouchers.stream().filter(v -> v.getId().equals(voucherId)).findFirst().get();
		if (voucher!=null) {
			if(voucher.getUsable()>0 && voucher.getDate().isAfter(LocalDate.now())) {
				int amount=voucher.getUsable()-1;
				voucher.setUsable(amount);
				return "Az "+voucher.getId()+" szammal ellatott azonositoju "+voucher.getName()+" megnevezesu "
						+ "kuponnak koszonhetoen "+voucher.getDiscount()+" kedvezmenyre jogosult es a kupon "
								+ (voucher.getUsable()==0 ?"mar nem hasznalhato fel tobbet":"meg "+
						voucher.getUsable()+" alkalommal hasznalhato fel!");
			}else {
				return "Sajnos a kupon nem valthato be mert nem ervenyes!";
			}
		}else {
			return "Sajnos ilyen azonositoju kuponja nincsen!";
		}
	}
}
