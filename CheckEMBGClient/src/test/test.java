package test;

import java.rmi.RemoteException;
import java.util.Scanner;

import check.com.web.service.EMBGProxy;

public class test {
	public static void main(String[] args) throws RemoteException {
		EMBGProxy proxy = new EMBGProxy();
		System.out.print("Enter your embg: ");
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String s1 = sc.next();
			System.out.println(proxy.testEMBG(s1));
		}

		System.out.println("The loop has been ended");
	}
}
