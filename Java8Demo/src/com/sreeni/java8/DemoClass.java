package com.sreeni.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DemoClass {
	


	public static void main(String[] args) {
		List<InsurencePremium> premiumList = new ArrayList<>();
		InsurencePremium insurencePremium1 = new InsurencePremium();
		insurencePremium1.setPersonName("Sreeni");
		insurencePremium1.setAmount(10000.00);
		premiumList.add(insurencePremium1);
		
		InsurencePremium insurencePremium2 = new InsurencePremium();
		insurencePremium2.setPersonName("Suresh");
		insurencePremium2.setAmount(20000.00);
		premiumList.add(insurencePremium2);
		
		//first version
		for(InsurencePremium premium : premiumList){
			System.out.println(premium.toString());
		}
		
		//second version
		premiumList.forEach(new InsurencePremiumConsumer());
		
		//third version
		premiumList.forEach(new Consumer<InsurencePremium>() {
			public void accept(InsurencePremium insurencePremium){
				System.out.println(insurencePremium.toString());
			}
		});
		
		
		//fourth version
		premiumList.forEach(x -> System.out.println(x.toString()));
		
		//fifth version
		
		Consumer<InsurencePremium> IPConsumer = (InsurencePremium ip) -> System.out.println(ip.toString());
		premiumList.forEach(IPConsumer);
	}
	
	static class InsurencePremiumConsumer implements Consumer<InsurencePremium>{

		@Override
		public void accept(InsurencePremium premium ){
			System.out.println(premium.toString());
		}

		
	}
	static class InsurencePremium {
		 String personName;
		 double amount;
		public String getPersonName() {
			return personName;
		}
		public void setPersonName(String personName) {
			this.personName = personName;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		@Override
		public String toString() {
			return "InsurencePremium [personName=" + personName + ", amount=" + amount + "]";
		}
		 
		 
	}
}
