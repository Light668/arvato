package de.arvato.application;

import java.util.List;

public class ProfitableFlears {

	public static int getOptimalValue(Float money, List<Flear> flears) {
		/*
		 * local_res will contain local rating for each recursion step and res will view
		 * the best rating at the end
		 */
		int local_res = 0;
		int res = 0;
		int index = 0;

		if (flears.isEmpty()) {
			return local_res;
		}
		while (index < flears.size()) {
			if (money >= flears.get(index).getPrice()) {
				// recursion step in order to find all possibilities
				local_res = flears.get(index).getRating() + getOptimalValue(money - flears.get(index).getPrice(),
						flears.subList(index + 1, flears.size()));
				// defining local maximum for every recursion step
				if (local_res > res) {
					res = local_res;
				}
			} 
			index++;
		}
		return res;
	}
}
