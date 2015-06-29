package check.com.web.service;

import java.util.Date;

public class EMBG {

	public String testEMBG(String embg) {
		if(embg == null) {
			return "Не";
		}
		if (embg.length() != 13) {
			return "Не";
		} else
			if (Integer
					.parseInt(embg.substring(12)) == (11
							- ((7 * (Integer.parseInt(embg.substring(0, 1)) + Integer.parseInt(embg.substring(6, 7))))
									+ 6 * (Integer.parseInt(embg.substring(1, 2))
											+ Integer.parseInt(embg.substring(7, 8)))
					+ 5 * (Integer.parseInt(embg.substring(2, 3)) + Integer.parseInt(embg.substring(8, 9)))
					+ 4 * (Integer.parseInt(embg.substring(3, 4)) + Integer.parseInt(embg.substring(9, 10)))
					+ 3 * (Integer.parseInt(embg.substring(4, 5)) + Integer.parseInt(embg.substring(10, 11)))
					+ 2 * (Integer.parseInt(embg.substring(5, 6)) + Integer.parseInt(embg.substring(11, 12)))) % 11)) {
			
				if(Integer.parseInt(embg.substring(0, 2)) <= 31 && Integer.parseInt(embg.substring(2, 4)) <= 12 && Integer.parseInt(embg.substring(4, 7)) < 999) {
					Date date = new Date();
					int tmp = 0;
					if(Integer.parseInt(embg.substring(4, 7)) > 15) {
						tmp = 1000 + Integer.parseInt(embg.substring(4, 7));
					} else {
						tmp = 2000 + Integer.parseInt(embg.substring(4, 7));
					}
					Date dateInput = new Date(tmp, Integer.parseInt(embg.substring(2, 4)), Integer.parseInt(embg.substring(0, 2)));
					if(dateInput.compareTo(date) < 0) {
						return "Да";
					}
				}
				
		}
		return "Не";
	}

}
