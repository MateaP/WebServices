package check.com.web.service;

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
			return "Да";
		}
		return "Не";
	}

}
